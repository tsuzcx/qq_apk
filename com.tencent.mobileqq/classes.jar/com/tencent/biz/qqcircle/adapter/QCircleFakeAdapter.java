package com.tencent.biz.qqcircle.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.adapter.interfaces.QCircleInteractor;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.fragments.QCircleBlockContainer;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.publish.queue.QCircleTaskQueue;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.biz.qqcircle.richframework.part.utils.ArrayUtils;
import com.tencent.biz.qqcircle.utils.QCircleProtoUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.part.IStatusViewProvider;
import com.tencent.biz.richframework.part.block.BlockContainer;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleConstants;
import com.tencent.mobileqq.winkpublish.event.QCirclePublishBoxStatusEvent;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StClientInfo;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StRecomForward;
import feedcloud.FeedCloudMeta.StTagInfo;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class QCircleFakeAdapter
  extends QCircleBaseFeedBlock
  implements SimpleEventReceiver
{
  public static final int e = QCircleConstants.b;
  private boolean f = false;
  private boolean g = true;
  private ArrayList<FeedBlockData> h = new ArrayList(5);
  private HashMap<String, Integer> i = new HashMap();
  private HashMap<String, Runnable> j = new HashMap();
  
  public QCircleFakeAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private int a(String paramString)
  {
    int k = 0;
    while (k < getDataList().size())
    {
      Object localObject = ((FeedBlockData)getDataList().get(k)).b();
      if ((paramString.startsWith("qcircle_fakeid_")) && (!((FeedCloudMeta.StFeed)localObject).id.get().startsWith("qcircle_fakeid_")))
      {
        QLog.d("QCircleFakeAdapter", 2, "has none fakeFeeds");
        break;
      }
      if (((FeedCloudMeta.StFeed)localObject).isRecomFd.get())
      {
        if (paramString.equals(((FeedCloudMeta.StFeed)localObject).recomForward.id.get())) {
          return k;
        }
      }
      else if (paramString.equals(((FeedCloudMeta.StFeed)localObject).id.get()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("find fakeid:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("QCircleFakeAdapter", 2, ((StringBuilder)localObject).toString());
        return k;
      }
      k += 1;
    }
    return -1;
  }
  
  private List<FeedCloudMeta.StFeed> a(ArrayList<FeedBlockData> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localArrayList.add(((FeedBlockData)paramArrayList.next()).b());
    }
    return localArrayList;
  }
  
  private void a(FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, QCircleFeedEvent paramQCircleFeedEvent)
  {
    int k = a(paramQCircleFeedEvent.mTargetId);
    if (k != -1)
    {
      QCirclePluginGlobalInfo.a(paramStGetFeedDetailRsp.feed.id.get(), ((FeedBlockData)getDataList().get(k)).b());
      b(paramQCircleFeedEvent.mTargetId);
      getDataList().remove(k);
      getDataList().add(k, new FeedBlockData(paramStGetFeedDetailRsp.feed));
      notifyDataSetChanged();
      QLog.d("QCircleFakeAdapter", 1, "success replace feed");
    }
  }
  
  private void a(List<FeedBlockData> paramList)
  {
    try
    {
      paramList = b(paramList);
      a(getDataList(), paramList);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPublishFeedReload   event fake feed size ");
      localStringBuilder.append(paramList.size());
      localStringBuilder.append("mFakeFeed list size");
      localStringBuilder.append(this.h.size());
      QLog.i("QCircleFakeAdapter", 1, localStringBuilder.toString());
      if (((getBlockContainer() instanceof QCircleBlockContainer)) && (getBlockContainer().getStatusInterface() != null) && (getBlockContainer().getStatusInterface().getStatusView().getVisibility() == 0))
      {
        getBlockContainer().getStatusInterface().getStatusView().setVisibility(8);
        QLog.i("QCircleFakeAdapter", 1, "onPublishFeedReload   StatusView == gone");
      }
      if (this.h.size() != paramList.size())
      {
        if (this.h.size() == 0)
        {
          getDataList().addAll(0, paramList);
        }
        else
        {
          i();
          getDataList().addAll(0, paramList);
        }
        this.h.clear();
        this.h.addAll(paramList);
        notifyDataSetChanged();
        return;
      }
      if (!j())
      {
        getDataList().addAll(0, paramList);
        this.h.addAll(paramList);
        notifyDataSetChanged();
        QLog.i("QCircleFakeAdapter", 1, "onPublishFeedReload  has fake feeds false");
        return;
      }
      QLog.i("QCircleFakeAdapter", 1, "onPublishFeedReload  has fake feeds true");
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPublishFeedReload exception:");
      localStringBuilder.append(paramList.toString());
      QLog.e("QCircleFakeAdapter", 1, localStringBuilder.toString());
    }
  }
  
  private void a(List<FeedBlockData> paramList1, List<FeedBlockData> paramList2)
  {
    if (paramList1 != null) {}
    try
    {
      if ((paramList1.size() > 0) && (paramList2 != null) && (paramList2.size() > 0))
      {
        paramList2 = paramList2.iterator();
        for (;;)
        {
          if (!paramList2.hasNext()) {
            break label162;
          }
          Object localObject = ((FeedBlockData)paramList2.next()).b().id.get();
          Iterator localIterator = paramList1.iterator();
          if (localIterator.hasNext())
          {
            String str = ((FeedBlockData)localIterator.next()).b().clientInfo.feedclientkey.get();
            if (!((String)localObject).equals(str)) {
              break;
            }
            paramList2.remove();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("remove same fake feed:");
            ((StringBuilder)localObject).append(str);
            QLog.d("QCircleFakeAdapter", 1, ((StringBuilder)localObject).toString());
          }
        }
        label162:
        return;
      }
      QLog.d("QCircleFakeAdapter", 1, "a feedList is empty");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramList1;
    }
  }
  
  public static boolean a(Object paramObject)
  {
    boolean bool3 = paramObject instanceof FeedCloudMeta.StFeed;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
  
  private List<FeedBlockData> b(List<FeedBlockData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FeedBlockData localFeedBlockData = (FeedBlockData)paramList.next();
        FeedCloudMeta.StFeed localStFeed = localFeedBlockData.b();
        boolean bool = QCirclePluginGlobalInfo.c(localStFeed.id.get());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localStFeed.id.get());
        localStringBuilder.append(" has add already:");
        localStringBuilder.append(bool);
        QLog.i("QCircleFakeAdapter", 1, localStringBuilder.toString());
        if ((a(localStFeed)) && (!bool)) {
          localArrayList.add(localFeedBlockData);
        }
      }
    }
    return localArrayList;
  }
  
  private void b(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent == null)
    {
      QLog.e("QCircleFakeAdapter", 1, "handleFakeEvent error fakeEvent is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fakeFeed state:");
    localStringBuilder.append(paramQCircleFeedEvent.mState);
    localStringBuilder.append(",fakeId:");
    localStringBuilder.append(paramQCircleFeedEvent.mTargetId);
    localStringBuilder.append(",fake listSize:");
    if (paramQCircleFeedEvent.mFakeFeedDataList == null) {
      k = 0;
    } else {
      k = paramQCircleFeedEvent.mFakeFeedDataList.size();
    }
    localStringBuilder.append(k);
    QLog.d("QCircleFakeAdapter", 2, localStringBuilder.toString());
    int k = paramQCircleFeedEvent.mState;
    if (k != 1)
    {
      if (k != 2)
      {
        if (k != 3)
        {
          if (k != 4)
          {
            if (k != 5) {
              return;
            }
            c(paramQCircleFeedEvent);
            return;
          }
          d(paramQCircleFeedEvent);
          return;
        }
        e(paramQCircleFeedEvent);
        return;
      }
      a(paramQCircleFeedEvent, false);
      return;
    }
    f(paramQCircleFeedEvent);
  }
  
  private void b(String paramString)
  {
    if (this.h.size() > 0)
    {
      Iterator localIterator = this.h.iterator();
      while (localIterator.hasNext()) {
        if (paramString.equals(((FeedBlockData)localIterator.next()).b().id.get())) {
          localIterator.remove();
        }
      }
    }
  }
  
  private void c(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (paramQCircleFeedEvent != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("qcircle_fakeid_");
      localStringBuilder.append(paramQCircleFeedEvent.mTargetId);
      QCirclePluginGlobalInfo.a(localStringBuilder.toString(), Integer.valueOf(paramQCircleFeedEvent.mState));
      QLog.d("QCircleFakeAdapter", 1, "fake feed composite success");
    }
  }
  
  private void d(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if (!this.g) {
      return;
    }
    this.g = false;
    if ((paramQCircleFeedEvent.mFakeFeedDataList != null) && (paramQCircleFeedEvent.mFakeFeedDataList.size() > 0))
    {
      paramQCircleFeedEvent = QCircleProtoUtil.b(paramQCircleFeedEvent.mFakeFeedDataList);
      getMainHandler().post(new QCircleFakeAdapter.1(this, paramQCircleFeedEvent));
      return;
    }
    g();
  }
  
  private void e(QCircleFeedEvent paramQCircleFeedEvent)
  {
    if ((paramQCircleFeedEvent.mTargetPage == -1) || (((getExtraTypeInfo() instanceof QCircleExtraTypeInfo)) && (paramQCircleFeedEvent.mTargetPage == ((QCircleExtraTypeInfo)getExtraTypeInfo()).pageType)))
    {
      int k = a(paramQCircleFeedEvent.mTargetId);
      if (k != -1) {
        getMainHandler().post(new QCircleFakeAdapter.3(this, k));
      }
    }
  }
  
  private void f(QCircleFeedEvent paramQCircleFeedEvent)
  {
    getMainHandler().post(new QCircleFakeAdapter.4(this, paramQCircleFeedEvent));
  }
  
  private void g()
  {
    getMainHandler().post(new QCircleFakeAdapter.2(this));
  }
  
  private String h()
  {
    if ((getInteractor() instanceof QCircleInteractor)) {
      return ((QCircleInteractor)getInteractor()).c().getTagInfo().tagName.get();
    }
    return "";
  }
  
  private void i()
  {
    if (getDataList().size() > 0)
    {
      Iterator localIterator = getDataList().iterator();
      while (localIterator.hasNext()) {
        if (((FeedBlockData)localIterator.next()).b().id.get().startsWith("qcircle_fakeid_")) {
          localIterator.remove();
        }
      }
    }
  }
  
  private boolean j()
  {
    if (getDataList().size() > 0) {
      return ((FeedBlockData)getDataList().get(0)).b().id.get().startsWith("qcircle_fakeid_");
    }
    return false;
  }
  
  private void k()
  {
    ArrayList localArrayList = QCircleTaskQueue.a().j();
    if (localArrayList != null) {
      SimpleEventBus.getInstance().dispatchEvent(new QCircleFeedEvent(localArrayList));
    }
    int k;
    if (localArrayList == null) {
      k = 0;
    } else {
      k = localArrayList.size();
    }
    QLog.d("QCircleFakeAdapter", 4, String.format("Get QCircleFakeFeed task list %b", new Object[] { Integer.valueOf(k) }));
  }
  
  protected void a(QCircleFeedEvent paramQCircleFeedEvent)
  {
    boolean bool = this.i.containsKey(paramQCircleFeedEvent.mTargetId);
    int k = 2000;
    if (!bool)
    {
      this.i.put(paramQCircleFeedEvent.mTargetId, Integer.valueOf(1));
    }
    else
    {
      localObject = (Integer)this.i.get(paramQCircleFeedEvent.mTargetId);
      if (((Integer)localObject).intValue() >= e)
      {
        if (getContext() != null) {
          QCircleToast.a(QCircleToast.b, 2131893014, 0);
        }
        QLog.d("QCircleFakeAdapter", 1, "max retry return");
        return;
      }
      localObject = Integer.valueOf(((Integer)localObject).intValue() + 1);
      this.i.put(paramQCircleFeedEvent.mTargetId, localObject);
      k = ((Integer)localObject).intValue() * 2000;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" retry count delay:");
    ((StringBuilder)localObject).append(k);
    QLog.d("QCircleFakeAdapter", 1, ((StringBuilder)localObject).toString());
    localObject = new QCircleFakeAdapter.RetryRunnable(this, paramQCircleFeedEvent);
    this.j.put(paramQCircleFeedEvent.mTargetId, localObject);
    getMainHandler().postDelayed((Runnable)localObject, k);
  }
  
  protected void a(QCircleFeedEvent paramQCircleFeedEvent, boolean paramBoolean)
  {
    FeedBlockData localFeedBlockData = QCircleProtoUtil.a(paramQCircleFeedEvent.mSingleFakeFeed);
    if (localFeedBlockData == null) {
      return;
    }
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetFeedDetailRequest(localFeedBlockData.b().id.get(), HostDataTransUtils.getAccount(), localFeedBlockData.b().createTime.get(), true), new QCircleFakeAdapter.5(this, paramQCircleFeedEvent, paramBoolean));
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  protected boolean a(FeedCloudMeta.StFeed paramStFeed)
  {
    if ((paramStFeed != null) && ((getExtraTypeInfo() instanceof QCircleExtraTypeInfo)) && (((QCircleExtraTypeInfo)getExtraTypeInfo()).pageType == 7))
    {
      Object localObject = paramStFeed.tagInfos.get();
      paramStFeed = h();
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
  
  protected void c(int paramInt)
  {
    if (ArrayUtils.a(paramInt, getDataList())) {
      return;
    }
    getDataList().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  public List<FeedCloudMeta.StFeed> d()
  {
    if ((this.mDataList != null) && (this.mDataList.size() != 0))
    {
      if (f()) {
        this.mDataList.removeAll(this.h);
      }
      return a(this.mDataList);
    }
    return null;
  }
  
  public void e()
  {
    if (this.f)
    {
      this.g = true;
      k();
    }
  }
  
  public boolean f()
  {
    return this.h.size() > 0;
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleFeedEvent.class);
    localArrayList.add(QCirclePublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    if (this.f) {
      SimpleEventBus.getInstance().registerReceiver(this);
    }
  }
  
  public void onDetachedFromRecyclerView(@NonNull RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.f) {
      SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
    if (this.j.size() > 0)
    {
      paramRecyclerView = this.j.keySet().iterator();
      while (paramRecyclerView.hasNext())
      {
        String str = (String)paramRecyclerView.next();
        getMainHandler().removeCallbacks((Runnable)this.j.get(str));
      }
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleFeedEvent)) {
      b((QCircleFeedEvent)paramSimpleBaseEvent);
    }
  }
  
  public void setDatas(List<FeedBlockData> paramList)
  {
    a(paramList, this.h);
    this.mDataList.clear();
    notifyDataSetChanged();
    if (paramList == null) {
      return;
    }
    if (this.h.size() > 0) {
      this.mDataList.addAll(this.h);
    }
    this.mDataList.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter
 * JD-Core Version:    0.7.0.1
 */