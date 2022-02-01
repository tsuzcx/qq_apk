package com.tencent.biz.qqcircle.immersive.part;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.ioc.IQFSFeedIoc;
import com.tencent.biz.qqcircle.immersive.manager.QFSPictureReloadManager;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;
import com.tencent.biz.qqcircle.widgets.QCircleStatusView;
import com.tencent.biz.richframework.part.PartManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import feedcloud.FeedCloudMeta.StDittoFeed;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QFSLayerPageListPart
  extends QFSLayerBasePart
  implements IQFSFeedIoc
{
  private QCircleLayerBean h;
  private IDataDisplaySurface<FeedBlockData> i;
  private boolean j = true;
  
  public QFSLayerPageListPart(QCircleLayerBean paramQCircleLayerBean)
  {
    this.h = paramQCircleLayerBean;
  }
  
  private int b(List<FeedBlockData> paramList)
  {
    if ((this.h != null) && (paramList != null) && (paramList.size() != 0))
    {
      Object localObject;
      StringBuilder localStringBuilder;
      if (paramList.size() <= this.h.getDataPosInList())
      {
        localObject = a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("checkFindRealPosition return unusual position = -1 dataSize: ");
        localStringBuilder.append(paramList.size());
        localStringBuilder.append(" posInList");
        localStringBuilder.append(this.h.getDataPosInList());
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        return -1;
      }
      if (TextUtils.equals(this.h.getFeed().id.get(), ((FeedBlockData)paramList.get(this.h.getDataPosInList())).b().id.get()))
      {
        paramList = a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkFindRealPosition return mInitBean.getFeedPosition() = ");
        ((StringBuilder)localObject).append(this.h.getDataPosInList());
        QLog.i(paramList, 1, ((StringBuilder)localObject).toString());
        return this.h.getDataPosInList();
      }
      int k = 0;
      while (k < paramList.size())
      {
        localObject = (FeedBlockData)paramList.get(k);
        if (TextUtils.equals(((FeedBlockData)localObject).b().id.get(), this.h.getFeed().id.get()))
        {
          paramList = a();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkFindRealPosition return position = ");
          localStringBuilder.append(k);
          localStringBuilder.append(" , feedId = ");
          localStringBuilder.append(((FeedBlockData)localObject).b().id.get());
          QLog.i(paramList, 1, localStringBuilder.toString());
          return k;
        }
        k += 1;
      }
      QLog.i(a(), 1, "checkFindRealPosition return default position = 0");
      return 0;
    }
    QLog.e(a(), 1, "checkFindRealPosition return unusual position = -1 UIStateData dataList is null");
    return -1;
  }
  
  private void c(int paramInt)
  {
    this.d = paramInt;
    if (this.a.getViewPager2().getCurrentItem() != paramInt)
    {
      this.a.getViewPager2().setCurrentItem(paramInt, false);
      return;
    }
    a(paramInt);
  }
  
  private void c(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (!this.j) {
      return;
    }
    this.j = false;
    int k = b((List)paramUIStateData.e());
    if ((k >= 0) && (((List)paramUIStateData.e()).size() > k))
    {
      paramUIStateData.a(k);
      return;
    }
    String str = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("firstEnterSelectPosition return, list.size = ");
    localStringBuilder.append(((List)paramUIStateData.e()).size());
    localStringBuilder.append(" , position = ");
    localStringBuilder.append(k);
    QLog.i(str, 1, localStringBuilder.toString());
  }
  
  private void t()
  {
    Object localObject = this.h;
    if ((localObject != null) && (((QCircleLayerBean)localObject).getGlobalViewModelKey() != null))
    {
      this.i = QCircleFeedDataCenter.a().c(this.h.getGlobalViewModelKey());
      localObject = this.i;
      if (localObject != null) {
        if (((IDataDisplaySurface)localObject).a(new Object[] { this.h.getTransInitBean() }) != null)
        {
          this.i.a(new Object[] { this.h.getTransInitBean() }).observe(m(), new QFSLayerPageListPart.2(this));
          return;
        }
      }
      QLog.e(a(), 1, "initViewModel  mDataDisplaySurface or data == null");
      return;
    }
    QLog.e(a(), 1, "initViewModel  viewModelKey == null");
  }
  
  public String a()
  {
    return "QFSLayerPageListPart";
  }
  
  public ArrayList<FeedBlockData> a(List<FeedBlockData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      FeedBlockData localFeedBlockData = (FeedBlockData)paramList.next();
      if ((localFeedBlockData != null) && (localFeedBlockData.b() != null) && (!TextUtils.isEmpty(localFeedBlockData.b().id.get())) && (!localFeedBlockData.b().dittoFeed.has())) {
        localArrayList.add(localFeedBlockData);
      }
    }
    return localArrayList;
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.a.setRefreshEnable(false);
    this.a.setLoadMoreEnable(true);
    this.a.getViewPager2().registerOnPageChangeCallback(new QFSLayerPageListPart.1(this));
    this.b.a(this);
    t();
  }
  
  protected void a(UIStateData<List<FeedBlockData>> paramUIStateData, boolean paramBoolean)
  {
    o();
    if (this.e == null) {
      return;
    }
    this.e.c();
    this.a.f();
    if (paramUIStateData.i())
    {
      b(paramUIStateData);
    }
    else
    {
      this.b.a(paramUIStateData);
      if (this.b.getDataList().size() == 0) {
        return;
      }
    }
    c(paramUIStateData.j());
    this.b.notifyDataSetChanged();
    QFSPictureReloadManager.a().a((List)paramUIStateData.e());
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    PartManager localPartManager = E();
    if (localPartManager == null)
    {
      QLog.d(a(), 1, "[onTabHandlerMessage] manager should not be null.");
      return;
    }
    if (TextUtils.equals(paramString, "event_open_comment"))
    {
      localPartManager.a("comment_panel_show", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_hide_comment"))
    {
      localPartManager.a("comment_panel_dismiss", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_comment_input"))
    {
      localPartManager.a("comment_input_window_show", null);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_share"))
    {
      localPartManager.a("share_action_show_share_sheet", paramVarArgs[0]);
      return;
    }
    if (TextUtils.equals(paramString, "event_open_friend_push_panel")) {
      localPartManager.a("light_interact_list_show", paramVarArgs[0]);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return;
    }
    IDataDisplaySurface localIDataDisplaySurface = this.i;
    if (localIDataDisplaySurface == null) {
      return;
    }
    localIDataDisplaySurface.b(new Object[] { this.h.getTransInitBean(), g() });
  }
  
  public boolean ah_()
  {
    if ((this.i != null) && (this.h != null) && (m() != null)) {
      if (this.i.a(new Object[] { this.h.getTransInitBean() }) != null) {
        this.i.a(new Object[] { this.h.getTransInitBean() }).removeObservers(m());
      }
    }
    return super.ah_();
  }
  
  protected void b(UIStateData<List<FeedBlockData>> paramUIStateData)
  {
    if (this.b == null) {
      return;
    }
    paramUIStateData = a((List)paramUIStateData.e());
    this.b.setDatas(paramUIStateData);
  }
  
  public int bk_()
  {
    return this.d;
  }
  
  public int bl_()
  {
    return 0;
  }
  
  public int d()
  {
    return 0;
  }
  
  public QCircleInitBean e()
  {
    return this.h;
  }
  
  public int f()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerPageListPart
 * JD-Core Version:    0.7.0.1
 */