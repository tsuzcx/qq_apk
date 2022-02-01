package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WSVerticalForQQSchemePresenter
  extends AbsWSVerticalPagePresenter
{
  private static final int a = ScreenUtil.dip2px(42.0F);
  private stSimpleMetaFeed b;
  private String i;
  
  public WSVerticalForQQSchemePresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private void a(List<WSVerticalItemData> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((paramBoolean) && (C())) {
        return;
      }
      paramList = a(this.i, paramList);
      if (paramList != null)
      {
        a(b(0), paramList.b());
        a(paramList.b());
        c(paramList);
      }
    }
  }
  
  protected boolean H()
  {
    return true;
  }
  
  protected boolean I()
  {
    return true;
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if ((paramArrayList.get(0) instanceof stSimpleMetaFeed))
      {
        this.b = ((stSimpleMetaFeed)paramArrayList.get(0));
        this.i = this.b.id;
      }
      return WSVerticalDataUtil.a(paramArrayList);
    }
    return Collections.emptyList();
  }
  
  public void a()
  {
    super.a();
    WSAioListHelper.a();
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPageSelected] currentPosition:");
    localStringBuilder.append(paramInt);
    WSLog.d("WSVerticalForQQSchemePresenter", localStringBuilder.toString());
    if (z() == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.f = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.e });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    a(paramList, paramBoolean2);
    super.a(paramList, paramBoolean1, true, paramObject);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    return (paramBoolean2) && (C());
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[fetchFeedData] isRefresh:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" isFirst:");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(" from:");
    localStringBuilder.append(paramString);
    WSLog.d("WSVerticalForQQSchemePresenter", localStringBuilder.toString());
    paramString = z();
    if (paramString == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForQQSchemePresenter.1(this, paramBoolean1, paramBoolean2, paramString));
    return true;
  }
  
  public int c()
  {
    return a;
  }
  
  public void g()
  {
    super.g();
    if (WSExpABTestManager.a().v())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(WSVerticalBeaconReport.c(z().k()));
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(z().k());
      localObject = ((StringBuilder)localObject).toString();
      WSAioListHelper.a(N(), (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForQQSchemePresenter
 * JD-Core Version:    0.7.0.1
 */