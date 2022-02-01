package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.subscribe.SubscribeGlobalInfo;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.event.PublishBoxStatusEvent;
import com.tencent.biz.subscribe.event.SubscribeFeedsEvent;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView.AdInnerClickListener;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ArrayUtils;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class FakerFeedsAdapter
  extends MultiViewBlock<CertifiedAccountMeta.StFeed>
  implements SimpleEventReceiver, RelativeAdFeedItemView.AdInnerClickListener
{
  protected RecyclerView.LayoutManager a;
  private boolean b = true;
  private boolean c;
  
  public FakerFeedsAdapter(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  private void a(SubscribeFeedsEvent paramSubscribeFeedsEvent)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fakeFeed state:");
    ((StringBuilder)localObject).append(paramSubscribeFeedsEvent.mState);
    ((StringBuilder)localObject).append(",fakeId:");
    ((StringBuilder)localObject).append(paramSubscribeFeedsEvent.mTargetId);
    ((StringBuilder)localObject).append(",fake listSize:");
    if (paramSubscribeFeedsEvent.mFakeFeedDataList == null) {
      i = 0;
    } else {
      i = paramSubscribeFeedsEvent.mFakeFeedDataList.size();
    }
    ((StringBuilder)localObject).append(i);
    QLog.d("FakerFeedsAdapter", 2, ((StringBuilder)localObject).toString());
    if (a("share_key_subscribe_user") == null) {
      return;
    }
    int i = paramSubscribeFeedsEvent.mState;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (!this.b) {
            return;
          }
          this.b = false;
          if ((paramSubscribeFeedsEvent.mFakeFeedDataList != null) && (paramSubscribeFeedsEvent.mFakeFeedDataList.size() > 0))
          {
            if (SubscribeGlobalInfo.a() != null)
            {
              localObject = paramSubscribeFeedsEvent.mFakeFeedDataList.iterator();
              while (((Iterator)localObject).hasNext())
              {
                CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)((Iterator)localObject).next();
                if (localStFeed.poster != null)
                {
                  localStFeed.poster.icon.set(SubscribeGlobalInfo.a().icon.get());
                  localStFeed.poster.nick.set(SubscribeGlobalInfo.a().nick.get());
                }
              }
            }
            M().post(new FakerFeedsAdapter.4(this, paramSubscribeFeedsEvent));
          }
        }
        else
        {
          i = b(paramSubscribeFeedsEvent.mTargetId);
          if (i != -1) {
            M().post(new FakerFeedsAdapter.3(this, i));
          }
        }
      }
      else
      {
        i = b(paramSubscribeFeedsEvent.mTargetId);
        if (i != -1)
        {
          localObject = SubscribeUtils.b((CertifiedAccountMeta.StFeed)N().get(i));
          ((CertifiedAccountMeta.StFeed)localObject).id.set(paramSubscribeFeedsEvent.mSingleFakeFeed.id.get());
          ((CertifiedAccountMeta.StFeed)localObject).createTime.set(paramSubscribeFeedsEvent.mSingleFakeFeed.createTime.get());
          ((CertifiedAccountMeta.StFeed)localObject).cover.url.set(paramSubscribeFeedsEvent.mSingleFakeFeed.cover.url.get());
          M().post(new FakerFeedsAdapter.2(this, (CertifiedAccountMeta.StFeed)localObject, i));
        }
      }
    }
    else
    {
      if (SubscribeGlobalInfo.a() != null)
      {
        paramSubscribeFeedsEvent.mSingleFakeFeed.poster.icon.set(SubscribeGlobalInfo.a().icon.get());
        paramSubscribeFeedsEvent.mSingleFakeFeed.poster.nick.set(SubscribeGlobalInfo.a().nick.get());
      }
      M().post(new FakerFeedsAdapter.1(this, paramSubscribeFeedsEvent));
    }
  }
  
  private int b(String paramString)
  {
    int i = 0;
    while (i < N().size())
    {
      Object localObject = (CertifiedAccountMeta.StFeed)N().get(i);
      if ((paramString.startsWith("fakeid_")) && (!((CertifiedAccountMeta.StFeed)localObject).id.get().startsWith("fakeid_")))
      {
        QLog.d("FakerFeedsAdapter", 2, "has none fakeFeeds");
        break;
      }
      if (paramString.equals(((CertifiedAccountMeta.StFeed)localObject).id.get()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("find fakeid:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("FakerFeedsAdapter", 2, ((StringBuilder)localObject).toString());
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (N() != null) {
      b(N().indexOf(paramStFeed));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  protected void b(int paramInt)
  {
    if (ArrayUtils.isOutOfArrayIndex(paramInt, N())) {
      return;
    }
    N().remove(paramInt);
    notifyItemRemoved(paramInt);
  }
  
  protected void d()
  {
    RecyclerView.LayoutManager localLayoutManager = this.a;
    if ((localLayoutManager instanceof StaggeredGridLayoutManager)) {
      ((StaggeredGridLayoutManager)localLayoutManager).invalidateSpanAssignments();
    }
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public void f()
  {
    if (e())
    {
      this.b = true;
      QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SubscribeFeedsEvent.class);
    localArrayList.add(PublishBoxStatusEvent.class);
    return localArrayList;
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.a = paramRecyclerView.getLayoutManager();
    if (this.c)
    {
      SimpleEventBus.getInstance().registerReceiver(this);
      QzoneIPCModule.getInstance().getCertifiedAccountTaskList();
    }
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    if (this.c) {
      SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof SubscribeFeedsEvent)) {
      a((SubscribeFeedsEvent)paramSimpleBaseEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.FakerFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */