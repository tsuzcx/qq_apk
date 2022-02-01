package com.tencent.biz.qqcircle.publish.outbox;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.bizparts.QCircleBasePart;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.publish.common.config.LocalConfig;
import com.tencent.biz.qqcircle.publish.queue.IPublishQueueListener;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.publish.task.IQueueTask;
import com.tencent.biz.qqcircle.publish.view.widget.SlideDetectListView;
import com.tencent.biz.qqcircle.publish.view.widget.SlideDetectListView.OnSlideListener;
import com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.qcircle.api.event.QCircleHostCloseEnvEvent;
import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QCirclePublishQueuePart
  extends QCircleBasePart
  implements SimpleEventReceiver
{
  public static boolean d = true;
  public ActionSheet a;
  IPublishQueueListener c = new QCirclePublishQueuePart.2(this);
  private SlideDetectListView e;
  private QCirclePublishQueuePart.UploadingListAdapter f;
  private QCircleTaskQueue g;
  private List<IQueueTask> h = new ArrayList();
  private IQueueTask i;
  private int j;
  private SlideDetectListView.OnSlideListener k = new QCirclePublishQueuePart.5(this);
  private View.OnClickListener l = new QCirclePublishQueuePart.6(this);
  private View.OnClickListener m = new QCirclePublishQueuePart.7(this);
  
  private String a(IQueueTask paramIQueueTask, int paramInt)
  {
    if (paramIQueueTask == null) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramIQueueTask.j());
    localStringBuilder.append("_");
    localStringBuilder.append(paramIQueueTask.r());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  private boolean b(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return false;
    }
    String str = QCircleConfigHelper.a("QZoneTextSetting", "ToastCannotCancelThisTask", "不能取消该上传任务!");
    boolean bool2;
    try
    {
      if (this.g != null)
      {
        bool1 = this.g.c(paramIQueueTask);
        bool2 = bool1;
        if (bool1) {
          return bool2;
        }
        try
        {
          QCircleToast.a(str, 0);
          return bool1;
        }
        catch (Exception paramIQueueTask) {}
      }
      else
      {
        return false;
      }
    }
    catch (Exception paramIQueueTask)
    {
      boolean bool1 = false;
      QLog.e("[QcirclePublish]QCirclePublishQueuePart", 1, "syncronized ", paramIQueueTask);
      QCircleToast.a(str, 0);
      bool2 = bool1;
    }
    return bool2;
  }
  
  private void i()
  {
    Object localObject = this.g;
    if (localObject != null) {
      localObject = ((QCircleTaskQueue)localObject).h();
    } else {
      localObject = null;
    }
    int n;
    if (localObject != null) {
      n = ((List)localObject).size();
    } else {
      n = 0;
    }
    if (n == 0)
    {
      this.h.clear();
      this.f.notifyDataSetChanged();
      return;
    }
    IQueueTask localIQueueTask;
    if (localObject != null)
    {
      localIQueueTask = this.i;
      if ((localIQueueTask != null) && (!((List)localObject).contains(localIQueueTask)))
      {
        l();
        break label131;
      }
    }
    if (localObject != null)
    {
      localIQueueTask = this.i;
      if (localIQueueTask != null)
      {
        n = localIQueueTask.bn_();
        if ((this.j != n) && (n == 2)) {
          l();
        } else {
          this.j = n;
        }
      }
    }
    label131:
    this.h.clear();
    this.h.addAll((Collection)localObject);
    this.f.notifyDataSetChanged();
  }
  
  private void l()
  {
    try
    {
      if ((this.a != null) && (this.a.isShowing())) {
        this.a.dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public String a()
  {
    return "[QcirclePublish]QCirclePublishQueuePart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.e = ((SlideDetectListView)paramView.findViewById(2131440865));
    this.e.setOnSlideListener(this.k);
    this.f = new QCirclePublishQueuePart.UploadingListAdapter(this, g());
    this.f.a(this.e);
    this.f.b(this.m);
    this.f.a(this.l);
    this.e.setAdapter(this.f);
    this.e.setDivider(new ColorDrawable(QCircleSkinHelper.getInstance().getColor(2131167061)));
    this.e.setDividerHeight(ViewUtils.a(1.0F));
    this.f.registerDataSetObserver(new QCirclePublishQueuePart.1(this));
    i();
  }
  
  public void a(IQueueTask paramIQueueTask)
  {
    if (paramIQueueTask == null) {
      return;
    }
    QCirclePublishQueuePart.3 local3 = new QCirclePublishQueuePart.3(this, paramIQueueTask);
    this.a = ActionSheet.a(g());
    if (paramIQueueTask.bn_() != 3)
    {
      this.a.a(c().getResources().getString(2131895785), 1);
      if (paramIQueueTask.bn_() == 2)
      {
        QCircleTaskQueue localQCircleTaskQueue = this.g;
        if ((localQCircleTaskQueue != null) && (!localQCircleTaskQueue.c(paramIQueueTask, false))) {
          this.a.a(c().getResources().getString(2131895787), 1);
        }
      }
    }
    this.a.a(local3);
    this.a.e(2131887648);
    this.a.setOnDismissListener(new QCirclePublishQueuePart.4(this));
    this.i = paramIQueueTask;
    this.j = this.i.bn_();
    this.a.show();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleHostCloseEnvEvent.class);
    return localArrayList;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    super.onActivityCreated(paramActivity, paramBundle);
    SimpleEventBus.getInstance().registerReceiver(this);
    this.g = QCircleTaskQueue.a();
    this.g.a(this.c);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    SimpleEventBus.getInstance().unRegisterReceiver(this);
    this.a = null;
    super.onActivityDestroyed(paramActivity);
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    super.onActivityPaused(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleHostCloseEnvEvent))
    {
      LocalConfig.a("sp_has_loginout", true, LoginData.a().b());
      HostUIHelper.closeHostEnvironment();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceiveEvent... ");
      localStringBuilder.append(((QCircleHostCloseEnvEvent)paramSimpleBaseEvent).ret);
      QLog.d("[QcirclePublish]QCirclePublishQueuePart", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.outbox.QCirclePublishQueuePart
 * JD-Core Version:    0.7.0.1
 */