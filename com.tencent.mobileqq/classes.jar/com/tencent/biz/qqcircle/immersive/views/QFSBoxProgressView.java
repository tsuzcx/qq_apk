package com.tencent.biz.qqcircle.immersive.views;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.widgets.QCircleCustomDialog;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.winkpublish.IQueueTask;
import com.tencent.mobileqq.winkpublish.api.IUploadTaskManager;
import com.tencent.mobileqq.winkpublish.event.BoxProgressStatusEvent;
import com.tencent.mobileqq.winkpublish.model.PublishQueueTaskInfo;
import com.tencent.mobileqq.winkpublish.view.BaseProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class QFSBoxProgressView
  extends BaseProgressView
  implements View.OnClickListener, SimpleEventReceiver
{
  private QFSRoundProgressView a;
  private int b = 0;
  private int c = 0;
  private int d = 80;
  private QFSBoxProgressView.FakeProgressRunnable e = new QFSBoxProgressView.FakeProgressRunnable(this);
  private Map<String, Integer> f = new HashMap();
  private ImageView g;
  private boolean h = false;
  
  public QFSBoxProgressView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public QFSBoxProgressView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    double d1 = Math.pow(0.8D, paramInt1 * 1.0F / 30.0F);
    double d2 = this.d / 100.0F;
    Double.isNaN(d2);
    d1 = (1.0D - d1) * d2;
    d2 = paramInt2;
    Double.isNaN(d2);
    int i = (int)(100.0D * d1 + d2 * (1.0D - d1));
    if (QLog.isColorLevel()) {
      QLog.d("QFSBoxProgressView", 1, String.format(Locale.getDefault(), "[computeProgress] fakeProgressCount:%04d, fakeProgress:%.3f, uploadProgress:%3d, result:%3d", new Object[] { Integer.valueOf(paramInt1), Double.valueOf(d1), Integer.valueOf(paramInt2), Integer.valueOf(i) }));
    }
    return i;
  }
  
  private int a(Collection<Integer> paramCollection)
  {
    Iterator localIterator = paramCollection.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      i += ((Integer)localIterator.next()).intValue();
    }
    return i / paramCollection.size();
  }
  
  private void a(List<String> paramList)
  {
    if (!this.f.isEmpty())
    {
      QLog.d("QFSBoxProgressView", 1, "[initProgress] progressMap.is notEmpty.");
      return;
    }
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[initProgress] task.getPhotoSources(): ");
      ((StringBuilder)localObject).append(paramList);
      QLog.d("QFSBoxProgressView", 1, ((StringBuilder)localObject).toString());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (String)paramList.next();
        this.f.put(localObject, Integer.valueOf(0));
      }
    }
  }
  
  private void b()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).getTaskList();
    int j = 0;
    if (localCopyOnWriteArrayList != null)
    {
      i = 0;
      while (i < localCopyOnWriteArrayList.size())
      {
        if (((IQueueTask)localCopyOnWriteArrayList.get(i)).getState() == 1) {
          break label63;
        }
        i += 1;
      }
    }
    int i = -1;
    label63:
    if (i == -1)
    {
      a();
      return;
    }
    a((IQueueTask)localCopyOnWriteArrayList.get(i));
    this.b = 0;
    this.a.setProgress(0);
    if (this.e == null) {
      this.e = new QFSBoxProgressView.FakeProgressRunnable(this);
    }
    RFThreadManager.getUIHandler().postDelayed(this.e, 200L);
    ImageView localImageView = this.g;
    if (((IQueueTask)localCopyOnWriteArrayList.get(i)).needShowCloseBt()) {
      i = j;
    } else {
      i = 8;
    }
    localImageView.setVisibility(i);
  }
  
  private void b(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask != null)
    {
      PublishQueueTaskInfo localPublishQueueTaskInfo = paramIQueueTask.getInfo();
      if (localPublishQueueTaskInfo != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QFSBoxProgressView", 1, new Object[] { "[updateProcess] task.getPhotoSource: ", paramIQueueTask.getPhotoSource(), ", task.getPhotoSources: ", paramIQueueTask.getPhotoSources(), "publishQueueTaskInfo", localPublishQueueTaskInfo });
        }
        if ((localPublishQueueTaskInfo.state != 0) && (localPublishQueueTaskInfo.state != 4) && (localPublishQueueTaskInfo.state != 1) && (localPublishQueueTaskInfo.state != 6))
        {
          a();
          return;
        }
        a(paramIQueueTask.getPhotoSources());
        RFThreadManager.getUIHandler().removeCallbacks(this.e);
        a(paramIQueueTask);
        if (paramIQueueTask.isVideoTask())
        {
          if (localPublishQueueTaskInfo.progress > this.b)
          {
            this.b = localPublishQueueTaskInfo.progress;
            this.a.setProgress(a(this.c, this.b));
          }
        }
        else
        {
          Integer localInteger = (Integer)this.f.get(paramIQueueTask.getPhotoSource());
          if ((localInteger != null) && (localPublishQueueTaskInfo.progress > localInteger.intValue()))
          {
            this.f.put(paramIQueueTask.getPhotoSource(), Integer.valueOf(localPublishQueueTaskInfo.progress));
            int i = a(this.f.values());
            this.a.setProgress(a(this.c, i));
          }
        }
        return;
      }
    }
    QLog.e("QFSBoxProgressView", 1, "[updateProcess] IQueueTask or PublishQueueTaskInfo is null");
    a();
  }
  
  private void c()
  {
    IQueueTask localIQueueTask = getCurrentTask();
    if ((localIQueueTask != null) && (localIQueueTask.getState() == 1))
    {
      localIQueueTask.cancel();
      ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).completeTask(localIQueueTask, false);
      a();
    }
  }
  
  private void d()
  {
    QCircleCustomDialog.a(getContext(), null, getContext().getString(2131896237), 2131887648, 2131896222, new QFSBoxProgressView.7(this), new QFSBoxProgressView.8(this)).show();
  }
  
  private IQueueTask getCurrentTask()
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).getTaskList();
    if (localCopyOnWriteArrayList != null)
    {
      i = 0;
      while (i < localCopyOnWriteArrayList.size())
      {
        if (((IQueueTask)localCopyOnWriteArrayList.get(i)).getState() == 1) {
          break label61;
        }
        i += 1;
      }
    }
    int i = -1;
    label61:
    if (i == -1) {
      return null;
    }
    return (IQueueTask)localCopyOnWriteArrayList.get(i);
  }
  
  private void setLocalCover(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSBoxProgressView", 1, new Object[] { "[setLocalCover] localCoverUrl: ", paramString });
    }
    Option localOption = new Option();
    localOption.setUrl(paramString).setTargetView(this.a).setPredecode(true).setRequestWidth(ViewUtils.dip2px(105.0F)).setRequestHeight(ViewUtils.dip2px(105.0F));
    QCircleFeedPicLoader.g().loadImage(localOption, new QFSBoxProgressView.6(this));
  }
  
  public void a()
  {
    this.c = 0;
    this.b = 0;
    this.a.setProgress(0);
    Map localMap = this.f;
    if (localMap != null) {
      localMap.clear();
    }
    RFThreadManager.getUIHandler().removeCallbacks(this.e);
    RFThreadManager.getUIHandler().post(new QFSBoxProgressView.5(this));
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    PublishQueueTaskInfo localPublishQueueTaskInfo = paramIQueueTask.getInfo();
    if (localPublishQueueTaskInfo == null)
    {
      QLog.e("QFSBoxProgressView", 1, "[show] publishQueueTaskInfo is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QFSBoxProgressView", 1, new Object[] { "[show] publishQueueTaskInfo: ", localPublishQueueTaskInfo });
    }
    if (getVisibility() != 0) {
      setVisibility(0);
    }
    if ((!TextUtils.isEmpty(localPublishQueueTaskInfo.url)) && (new File(localPublishQueueTaskInfo.url).exists()))
    {
      setLocalCover(localPublishQueueTaskInfo.url);
      return;
    }
    a();
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).removeTask(paramIQueueTask);
    QLog.e("QFSBoxProgressView", 1, "[show] info.url is null");
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(BoxProgressStatusEvent.class);
    return localArrayList;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131441956) {
      d();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    RFThreadManager.getUIHandler().removeCallbacks(this.e);
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDetachedFromWindow... progressRunnable:");
    localStringBuilder.append(this.e);
    QLog.d("QFSBoxProgressView", 1, localStringBuilder.toString());
  }
  
  public int onGetLayoutId()
  {
    return 2131627166;
  }
  
  protected void onInitView(Context paramContext, View paramView)
  {
    this.a = ((QFSRoundProgressView)paramView.findViewById(2131442026));
    this.g = ((ImageView)paramView.findViewById(2131441956));
    this.g.setOnClickListener(this);
    SimpleEventBus.getInstance().registerReceiver(this);
    ((IUploadTaskManager)QRoute.api(IUploadTaskManager.class)).addPublishQueueListener(this);
    b();
  }
  
  public void onProgressChanged(IQueueTask paramIQueueTask)
  {
    RFThreadManager.getUIHandler().post(new QFSBoxProgressView.2(this, paramIQueueTask));
  }
  
  public void onQueueChanged()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QFSBoxProgressView", 1, "onQueueChanged");
    }
    RFThreadManager.getUIHandler().post(new QFSBoxProgressView.1(this));
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof BoxProgressStatusEvent))
    {
      int i = ((BoxProgressStatusEvent)paramSimpleBaseEvent).getType();
      if (i == 0)
      {
        RFThreadManager.getUIHandler().post(new QFSBoxProgressView.3(this));
        return;
      }
      if (i == 1) {
        RFThreadManager.getUIHandler().post(new QFSBoxProgressView.4(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.views.QFSBoxProgressView
 * JD-Core Version:    0.7.0.1
 */