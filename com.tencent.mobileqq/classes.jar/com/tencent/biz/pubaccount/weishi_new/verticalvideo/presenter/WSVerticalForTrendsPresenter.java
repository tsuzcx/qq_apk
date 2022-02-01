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
      if (WSGlobalConfig.a().e(6) == paramInt) {
        paramView.a(WSGlobalConfig.a().a(6));
      }
    }
  }
  
  private void b(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.f = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.e });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
  }
  
  protected boolean B()
  {
    return true;
  }
  
  protected boolean I()
  {
    return true;
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    return null;
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    WSVerticalPageContract.View localView = z();
    b(paramViewHolder, paramInt);
    a(paramInt, localView);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    if (paramBoolean2) {
      return C();
    }
    return super.a(paramBoolean1, false, paramList, paramObject);
  }
  
  public boolean b(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (z() == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForTrendsPresenter.1(this, paramBoolean2, paramBoolean1));
    return true;
  }
  
  public void d()
  {
    super.d();
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this);
    }
  }
  
  public void destroy()
  {
    super.destroy();
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(this);
    }
  }
  
  public void g()
  {
    super.g();
    WSVerticalTrendsCacheUtils.a(z());
  }
  
  public void h()
  {
    super.h();
    WSPublicAccReport.getInstance().trendsCloseReport(M());
  }
  
  public void onApplicationBackground()
  {
    WSPublicAccReport.getInstance().trendsWSBackgroundReport();
  }
  
  public void onApplicationForeground()
  {
    WSPublicAccReport.getInstance().trendsWSForegroundReport();
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForTrendsPresenter
 * JD-Core Version:    0.7.0.1
 */