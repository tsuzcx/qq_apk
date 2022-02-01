package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;

public class TopPanelView
  extends RelativeLayout
  implements TopPanelContract.View
{
  private TopPanelContract.Presenter a;
  private RecommendBannerView b;
  private PassiveBubbleView c;
  private TextView d;
  
  public TopPanelView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopPanelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TopPanelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public void a()
  {
    ViewUtils.setViewVisibility(this.c, 8);
  }
  
  public void a(int paramInt)
  {
    PassiveBubbleView localPassiveBubbleView = this.c;
    if (localPassiveBubbleView != null)
    {
      localPassiveBubbleView.a(paramInt);
      ViewUtils.setViewVisibility(this.c, 0);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList, boolean paramBoolean)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (paramStEntry == null))
    {
      b();
      return;
    }
    RecommendBannerView localRecommendBannerView = this.b;
    if (localRecommendBannerView != null) {
      localRecommendBannerView.a(paramStEntry, paramList, paramBoolean);
    }
    ViewUtils.setViewVisibility(this.b, 0);
    ViewUtils.setViewVisibility(this.d, 0);
    if (((paramList == null) || (paramList.size() < 10)) && (paramBoolean))
    {
      paramStEntry = this.b;
      if (paramStEntry != null) {
        paramStEntry.a();
      }
    }
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131624362, this);
    setBackgroundResource(2130839577);
    this.b = ((RecommendBannerView)findViewById(2131444421));
    this.c = ((PassiveBubbleView)findViewById(2131439856));
    this.d = ((TextView)findViewById(2131446588));
  }
  
  public void b()
  {
    ViewUtils.setViewVisibility(this.b, 8);
    ViewUtils.setViewVisibility(this.d, 8);
  }
  
  public void setPresenter(TopPanelContract.Presenter paramPresenter)
  {
    this.a = paramPresenter;
    RecommendBannerView localRecommendBannerView = this.b;
    if (localRecommendBannerView != null) {
      localRecommendBannerView.setPresenter(paramPresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView
 * JD-Core Version:    0.7.0.1
 */