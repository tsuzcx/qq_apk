package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.config.WSGlobalConfig;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalTrendsCacheUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalForTrendsPresenter
  extends AbsWSVerticalPagePresenter
  implements IGuardInterface
{
  public WSVerticalForTrendsPresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private void a(int paramInt, WSVerticalPageContract.View paramView)
  {
    if (paramInt > 0)
    {
      if (paramView == null) {
        return;
      }
      if (WSGlobalConfig.a().a(paramInt, 6))
      {
        paramView.a(paramInt, 6);
        return;
      }
      if (WSGlobalConfig.a().d(6) == paramInt) {
        paramView.a(WSGlobalConfig.a().a(6));
      }
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.a });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
  }
  
  public void G_()
  {
    WSPublicAccReport.getInstance().trendsWSForegroundReport();
  }
  
  public void H_()
  {
    WSPublicAccReport.getInstance().trendsWSBackgroundReport();
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return null;
  }
  
  public void a(long paramLong) {}
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSVerticalPageContract.View localView = a();
    b(paramViewHolder, paramInt);
    a(paramInt, localView);
  }
  
  public void a(boolean paramBoolean) {}
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (a() == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForTrendsPresenter.1(this, paramBoolean2, paramBoolean1));
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if (paramBoolean2) {
      return h();
    }
    return super.a(paramBoolean1, false, paramList, paramObject);
  }
  
  public void b()
  {
    super.b();
    if (GuardManager.a != null) {
      GuardManager.a.b(this);
    }
  }
  
  public void b(long paramLong) {}
  
  public void c(long paramLong) {}
  
  public void d()
  {
    super.d();
    if (GuardManager.a != null) {
      GuardManager.a.a(this);
    }
  }
  
  public void g()
  {
    super.g();
    WSVerticalTrendsCacheUtils.a(a());
  }
  
  protected boolean g()
  {
    return true;
  }
  
  public void h()
  {
    super.h();
    WSPublicAccReport.getInstance().trendsCloseReport(c());
  }
  
  protected boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForTrendsPresenter
 * JD-Core Version:    0.7.0.1
 */