package com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter;

import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.ViewHolder;
import com.tencent.biz.pubaccount.weishi_new.event.WSCommentEvent;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.View;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
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
  private static final int b = ScreenUtil.dip2px(42.0F);
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private String jdField_a_of_type_JavaLangString;
  
  public WSVerticalForQQSchemePresenter(WSVerticalPageContract.View paramView)
  {
    super(paramView);
  }
  
  private void a(List<WSVerticalItemData> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((paramBoolean) && (h())) {
        return;
      }
      paramList = a(this.jdField_a_of_type_JavaLangString, paramList);
      if (paramList != null)
      {
        a(a(0), paramList.a());
        a(paramList.a());
        a(paramList);
      }
    }
  }
  
  public List<WSVerticalItemData> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if ((paramArrayList.get(0) instanceof stSimpleMetaFeed))
      {
        this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)paramArrayList.get(0));
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.id;
      }
      return WSVerticalDataUtil.a(paramArrayList);
    }
    return Collections.emptyList();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    paramBundle.putString("share_feed_id", this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    super.a(paramViewHolder, paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onPageSelected] currentPosition:");
    localStringBuilder.append(paramInt);
    WSLog.d("WSVerticalForQQSchemePresenter", localStringBuilder.toString());
    if (a() == null) {
      return;
    }
    if ((paramViewHolder instanceof WSVerticalVideoHolder))
    {
      paramViewHolder = (WSVerticalVideoHolder)paramViewHolder;
      com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.a = 1;
      paramViewHolder = new WSCommentEvent(4, new Object[] { Integer.valueOf(paramInt), paramViewHolder.a });
      StoryDispatcher.a().dispatch(paramViewHolder);
    }
  }
  
  public void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    a(paramList, paramBoolean2);
    super.a(paramList, paramBoolean1, true, paramObject);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[fetchFeedData] isRefresh:");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" isFirst:");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(" from:");
    localStringBuilder.append(paramString);
    WSLog.d("WSVerticalForQQSchemePresenter", localStringBuilder.toString());
    paramString = a();
    if (paramString == null) {
      return false;
    }
    ThreadManager.executeOnSubThread(new WSVerticalForQQSchemePresenter.1(this, paramBoolean1, paramBoolean2, paramString));
    return true;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, List<WSVerticalItemData> paramList, Object paramObject)
  {
    return (paramBoolean2) && (h());
  }
  
  public int b()
  {
    return b;
  }
  
  public void e()
  {
    super.e();
    WSPublicAccReport.getInstance().enterPublicAccReport(null, 2, "from_qq_scheme", this.jdField_a_of_type_AndroidOsBundle);
  }
  
  protected boolean k()
  {
    return true;
  }
  
  protected boolean l()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.presenter.WSVerticalForQQSchemePresenter
 * JD-Core Version:    0.7.0.1
 */