package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import bhns;
import bjbk;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.subscribe.component.base.ComponentPageView;
import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import trc;
import ydp;
import yds;
import yeb;
import yej;
import yel;

public abstract class QCircleFakeAdapter
  extends ydp
  implements yel
{
  private static boolean f;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<FeedCloudMeta.StFeed> jdField_a_of_type_JavaUtilList = new ArrayList(5);
  private HashMap<String, Runnable> b = new HashMap();
  private boolean d;
  private boolean e = true;
  
  public QCircleFakeAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString)
  {
    int i = 0;
    FeedCloudMeta.StFeed localStFeed;
    int j;
    if (i < b().size())
    {
      localStFeed = (FeedCloudMeta.StFeed)b().get(i);
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
    c(paramQCircleFeedEvent);
    return;
    e(paramQCircleFeedEvent);
    return;
    d(paramQCircleFeedEvent);
    return;
    a(paramQCircleFeedEvent, false);
  }
  
  private void c()
  {
    if (b().size() > 0)
    {
      Iterator localIterator = b().iterator();
      while (localIterator.hasNext()) {
        if (((FeedCloudMeta.StFeed)localIterator.next()).id.get().startsWith("qcircle_fakeid_")) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void c(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (!this.e) {
      return;
    }
    this.e = false;
    if ((paramQCircleFeedEvent.mFakeFeedDataList != null) && (paramQCircleFeedEvent.mFakeFeedDataList.size() > 0))
    {
      f = true;
      a().post(new QCircleFakeAdapter.1(this, paramQCircleFeedEvent));
      return;
    }
    f = false;
    b();
  }
  
  private boolean c()
  {
    boolean bool = false;
    if (b().size() > 0) {
      bool = ((FeedCloudMeta.StFeed)b().get(0)).id.get().startsWith("qcircle_fakeid_");
    }
    return bool;
  }
  
  private void d(QCircleFeedEvent paramQCircleFeedEvent)
  {
    int i = a(paramQCircleFeedEvent.mTargetId);
    if (i != -1) {
      a().post(new QCircleFakeAdapter.3(this, i));
    }
  }
  
  private void e(QCircleFeedEvent paramQCircleFeedEvent)
  {
    a().post(new QCircleFakeAdapter.4(this, paramQCircleFeedEvent));
  }
  
  public void Q_()
  {
    if (this.d)
    {
      this.e = true;
      bjbk.a().a();
    }
  }
  
  protected Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  protected void a(int paramInt)
  {
    if (bhns.a(paramInt, b())) {
      return;
    }
    b().remove(paramInt);
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
      this.b.put(paramQCircleFeedEvent.mTargetId, localObject);
      a().postDelayed((Runnable)localObject, i);
      return;
      localObject = (Integer)this.jdField_a_of_type_JavaUtilHashMap.get(paramQCircleFeedEvent.mTargetId);
      if (((Integer)localObject).intValue() >= 3)
      {
        if (a() != null) {
          QQToast.a(a(), 0, 2131695781, 0).a();
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
    VSNetworkHelper.a().a(new QCircleGetFeedDetailRequest(paramQCircleFeedEvent.mSingleFakeFeed.id.get(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), paramQCircleFeedEvent.mSingleFakeFeed.createTime.get(), true), new trc(this, paramQCircleFeedEvent, paramBoolean));
  }
  
  public void a(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      b((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    notifyDataSetChanged();
    if (paramArrayList == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.size() > 0) {
      this.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int i;
    yds localyds;
    if ((a() != null) && (a() != null))
    {
      a().a(4);
      a().setRefreshing(false);
      if (this.c)
      {
        if (getItemCount() != 0) {
          break label74;
        }
        i = 1;
        localyds = a();
        if ((!paramBoolean2) || (i != 0)) {
          break label79;
        }
      }
    }
    label74:
    label79:
    for (paramBoolean2 = bool;; paramBoolean2 = false)
    {
      localyds.a(paramBoolean1, paramBoolean2);
      return;
      i = 0;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (this.d) {
      yej.a().a(this);
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.d) {
      yej.a().b(this);
    }
    if (this.b.size() > 0)
    {
      paramRecyclerView = this.b.keySet().iterator();
      while (paramRecyclerView.hasNext())
      {
        String str = (String)paramRecyclerView.next();
        a().removeCallbacks((Runnable)this.b.get(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter
 * JD-Core Version:    0.7.0.1
 */