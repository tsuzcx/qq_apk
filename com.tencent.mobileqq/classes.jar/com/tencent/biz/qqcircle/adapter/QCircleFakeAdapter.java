package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import bhrz;
import bjfr;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import tqg;
import trd;
import trw;
import yhy;
import yib;
import yii;
import yiw;
import yiy;

public abstract class QCircleFakeAdapter
  extends yhy
  implements yiy
{
  private static boolean c;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilList = new ArrayList(5);
  private boolean jdField_a_of_type_Boolean;
  private HashMap<String, Runnable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean = true;
  
  public QCircleFakeAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString)
  {
    int i = 0;
    FeedCloudMeta.StFeed localStFeed;
    int j;
    if (i < getDataList().size())
    {
      localStFeed = (FeedCloudMeta.StFeed)getDataList().get(i);
      if ((paramString.startsWith("qcircle_fakeid_")) && (!localStFeed.id.get().startsWith("qcircle_fakeid_"))) {
        QLog.d("QCircleFakeAdapter", 2, "has none fakeFeeds");
      }
    }
    else
    {
      j = -1;
    }
    do
    {
      return j;
      if (!localStFeed.isRecomFd.get()) {
        break;
      }
      j = i;
    } while (paramString.equals(localStFeed.recomForward.id.get()));
    while (!paramString.equals(localStFeed.id.get()))
    {
      i += 1;
      break;
    }
    QLog.d("QCircleFakeAdapter", 2, "find fakeid:" + paramString);
    return i;
  }
  
  private String a()
  {
    if ((getInteractor() instanceof trw)) {
      return ((trw)getInteractor()).a().getTagInfo().tagName.get();
    }
    return "";
  }
  
  private List<FeedCloudMeta.StFeed> a(List<FeedCloudMeta.StFeed> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedCloudMeta.StFeed localStFeed = (FeedCloudMeta.StFeed)paramList.next();
        if (a(localStFeed)) {
          localArrayList.add(localStFeed);
        }
      }
    }
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((FeedCloudMeta.StFeed)localIterator.next()).id.get())) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void b()
  {
    a().post(new QCircleFakeAdapter.2(this));
  }
  
  private void b(QCircleFeedEvent paramQCircleFeedEvent)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("fakeFeed state:").append(paramQCircleFeedEvent.mState).append(",fakeId:").append(paramQCircleFeedEvent.mTargetId).append(",fake listSize:");
    if (paramQCircleFeedEvent.mFakeFeedDataList == null) {}
    for (int i = 0;; i = paramQCircleFeedEvent.mFakeFeedDataList.size())
    {
      QLog.d("QCircleFakeAdapter", 2, i);
      if (paramQCircleFeedEvent != null) {}
      switch (paramQCircleFeedEvent.mState)
      {
      default: 
        return;
      }
    }
    d(paramQCircleFeedEvent);
    return;
    f(paramQCircleFeedEvent);
    return;
    e(paramQCircleFeedEvent);
    return;
    a(paramQCircleFeedEvent, false);
    return;
    c(paramQCircleFeedEvent);
  }
  
  private boolean b()
  {
    boolean bool = false;
    if (getDataList().size() > 0) {
      bool = ((FeedCloudMeta.StFeed)getDataList().get(0)).id.get().startsWith("qcircle_fakeid_");
    }
    return bool;
  }
  
  private void c()
  {
    if (getDataList().size() > 0)
    {
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        if (((FeedCloudMeta.StFeed)localIterator.next()).id.get().startsWith("qcircle_fakeid_")) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void c(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent != null)
    {
      tqg.a("qcircle_fakeid_" + paramQCircleFeedEvent.mTargetId, Integer.valueOf(paramQCircleFeedEvent.mState));
      QLog.d("QCircleFakeAdapter", 4, "fake feed composite success");
    }
  }
  
  private void d(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    if ((paramQCircleFeedEvent.mFakeFeedDataList != null) && (paramQCircleFeedEvent.mFakeFeedDataList.size() > 0))
    {
      c = true;
      paramQCircleFeedEvent = a(paramQCircleFeedEvent.mFakeFeedDataList);
      a().post(new QCircleFakeAdapter.1(this, paramQCircleFeedEvent));
      return;
    }
    c = false;
    b();
  }
  
  private void e(QCircleFeedEvent paramQCircleFeedEvent)
  {
    int i = a(paramQCircleFeedEvent.mTargetId);
    if (i != -1) {
      a().post(new QCircleFakeAdapter.3(this, i));
    }
  }
  
  private void f(QCircleFeedEvent paramQCircleFeedEvent)
  {
    a().post(new QCircleFakeAdapter.4(this, paramQCircleFeedEvent));
  }
  
  protected Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public List<FeedCloudMeta.StFeed> a()
  {
    if ((this.mDataList == null) || (this.mDataList.size() == 0)) {
      return null;
    }
    if (a()) {
      this.mDataList.removeAll(this.jdField_a_of_type_JavaUtilList);
    }
    return this.mDataList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      bjfr.a().a();
    }
  }
  
  protected void a(int paramInt)
  {
    if (bhrz.a(paramInt, getDataList())) {
      return;
    }
    getDataList().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  public void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramQCircleFeedEvent.mTargetId)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramQCircleFeedEvent.mTargetId, Integer.valueOf(1));
    }
    Object localObject;
    for (int i = 2000;; i = ((Integer)localObject).intValue() * 2000)
    {
      QLog.d("QCircleFakeAdapter", 1, " retry count delay:" + i);
      localObject = new QCircleFakeAdapter.RetryRunnable(this, paramQCircleFeedEvent);
      this.jdField_b_of_type_JavaUtilHashMap.put(paramQCircleFeedEvent.mTargetId, localObject);
      a().postDelayed((Runnable)localObject, i);
      return;
      localObject = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramQCircleFeedEvent.mTargetId);
      if (((Integer)localObject).intValue() >= 3)
      {
        if (getContext() != null) {
          QQToast.a(getContext(), 0, 2131695783, 0).a();
        }
        QLog.d("QCircleFakeAdapter", 1, "max retry return");
        return;
      }
      localObject = Integer.valueOf(((Integer)localObject).intValue() + 1);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramQCircleFeedEvent.mTargetId, localObject);
    }
  }
  
  protected void a(QCircleFeedEvent paramQCircleFeedEvent, boolean paramBoolean)
  {
    VSNetworkHelper.a().a(new QCircleGetFeedDetailRequest(paramQCircleFeedEvent.mSingleFakeFeed.id.get(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQCircleFeedEvent.mSingleFakeFeed.createTime.get(), true), new trd(this, paramQCircleFeedEvent, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int i;
    yib localyib;
    if ((getComponentPageView() != null) && (getParentAdapter() != null))
    {
      getLoadInfo().a(4);
      getComponentPageView().setRefreshing(false);
      if (isLastAdapter())
      {
        if (getItemCount() != 0) {
          break label74;
        }
        i = 1;
        localyib = getParentAdapter();
        if ((!paramBoolean2) || (i != 0)) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localyib.a(paramBoolean1, paramBoolean2);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  protected boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && (getExtraTypeInfo() != null) && (getExtraTypeInfo().pageType == 7))
    {
      Object localObject = paramStFeed.tagInfos.get();
      paramStFeed = a();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((FeedCloudMeta.StTagInfo)((Iterator)localObject).next()).tagName.get().equals(paramStFeed)) {
          return true;
        }
      }
      return false;
    }
    return true;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Boolean) {
      yiw.a().a(this);
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_a_of_type_Boolean) {
      yiw.a().b(this);
    }
    if (this.jdField_b_of_type_JavaUtilHashMap.size() > 0)
    {
      paramRecyclerView = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramRecyclerView.hasNext())
      {
        String str = (String)paramRecyclerView.next();
        a().removeCallbacks((Runnable)this.jdField_b_of_type_JavaUtilHashMap.get(str));
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      b((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setDatas(ArrayList paramArrayList)
  {
    this.mDataList.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      this.mDataList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    this.mDataList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter
 * JD-Core Version:    0.7.0.1
 */