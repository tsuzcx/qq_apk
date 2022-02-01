package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import bkfj;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StTagInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import uxc;
import uyh;
import uzb;
import uzv;
import zwp;
import zwr;
import zxo;
import zxz;

public abstract class QCircleFakeAdapter
  extends uzv<FeedCloudMeta.StFeed>
  implements zwr
{
  private static boolean jdField_a_of_type_Boolean;
  protected int a;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilList = new ArrayList(5);
  private HashMap<String, Runnable> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
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
  
  public static boolean a(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof FeedCloudMeta.StFeed))
    {
      paramObject = ((FeedCloudMeta.StFeed)paramObject).id.get();
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramObject))
      {
        bool1 = bool2;
        if (paramObject.startsWith("qcircle_fakeid_")) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
  
  private String c()
  {
    if ((getInteractor() instanceof uzb)) {
      return ((uzb)getInteractor()).a().getTagInfo().tagName.get();
    }
    return "";
  }
  
  private void c()
  {
    getMainHandler().post(new QCircleFakeAdapter.2(this));
  }
  
  private void c(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent != null)
    {
      uxc.a("qcircle_fakeid_" + paramQCircleFeedEvent.mTargetId, Integer.valueOf(paramQCircleFeedEvent.mState));
      QLog.d("QCircleFakeAdapter", 4, "fake feed composite success");
    }
  }
  
  private void d()
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
  
  private void d(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (!this.c) {
      return;
    }
    this.c = false;
    if ((paramQCircleFeedEvent.mFakeFeedDataList != null) && (paramQCircleFeedEvent.mFakeFeedDataList.size() > 0))
    {
      jdField_a_of_type_Boolean = true;
      paramQCircleFeedEvent = a(paramQCircleFeedEvent.mFakeFeedDataList);
      getMainHandler().post(new QCircleFakeAdapter.1(this, paramQCircleFeedEvent));
      return;
    }
    jdField_a_of_type_Boolean = false;
    c();
  }
  
  private void e(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if ((paramQCircleFeedEvent.mTargetPage == -1) || (paramQCircleFeedEvent.mTargetPage == getExtraTypeInfo().pageType))
    {
      int i = a(paramQCircleFeedEvent.mTargetId);
      if (i != -1) {
        getMainHandler().post(new QCircleFakeAdapter.3(this, i));
      }
    }
  }
  
  private void f(QCircleFeedEvent paramQCircleFeedEvent)
  {
    getMainHandler().post(new QCircleFakeAdapter.4(this, paramQCircleFeedEvent));
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
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
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
      getMainHandler().postDelayed((Runnable)localObject, i);
      return;
      localObject = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramQCircleFeedEvent.mTargetId);
      if (((Integer)localObject).intValue() >= 3)
      {
        if (getContext() != null) {
          QQToast.a(getContext(), 0, 2131694666, 0).a();
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
    VSNetworkHelper.a().a(new QCircleGetFeedDetailRequest(paramQCircleFeedEvent.mSingleFakeFeed.id.get(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQCircleFeedEvent.mSingleFakeFeed.createTime.get(), true), new uyh(this, paramQCircleFeedEvent, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int i;
    zxo localzxo;
    if ((getBlockContainer() != null) && (getBlockMerger() != null))
    {
      getLoadInfo().a(4);
      getBlockContainer().setRefreshing(false);
      if (isLastPeerBlock())
      {
        if (getItemCount() != 0) {
          break label74;
        }
        i = 1;
        localzxo = getBlockMerger();
        if ((!paramBoolean2) || (i != 0)) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localzxo.a(paramBoolean1, paramBoolean2);
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
      paramStFeed = c();
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
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.c = true;
      QzoneIPCModule.a().a();
    }
  }
  
  protected void b(int paramInt)
  {
    if (bkfj.a(paramInt, getDataList())) {
      return;
    }
    getDataList().remove(paramInt);
    notifyItemRemoved(paramInt);
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
    if (this.jdField_b_of_type_Boolean) {
      zwp.a().a(this);
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.jdField_b_of_type_Boolean) {
      zwp.a().b(this);
    }
    if (this.jdField_b_of_type_JavaUtilHashMap.size() > 0)
    {
      paramRecyclerView = this.jdField_b_of_type_JavaUtilHashMap.keySet().iterator();
      while (paramRecyclerView.hasNext())
      {
        String str = (String)paramRecyclerView.next();
        getMainHandler().removeCallbacks((Runnable)this.jdField_b_of_type_JavaUtilHashMap.get(str));
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      b((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setDatas(ArrayList<FeedCloudMeta.StFeed> paramArrayList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter
 * JD-Core Version:    0.7.0.1
 */