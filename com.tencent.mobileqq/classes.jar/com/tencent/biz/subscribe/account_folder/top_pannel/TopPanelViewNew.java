package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew;
import com.tencent.biz.subscribe.beans.RecommendInfoItem;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;

public class TopPanelViewNew
  extends RelativeLayout
  implements TopPanelContract.View
{
  private TopPanelContract.Presenter a;
  private RecommendBannerViewNew b;
  private View c;
  private boolean d = false;
  
  public TopPanelViewNew(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public TopPanelViewNew(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public TopPanelViewNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList, boolean paramBoolean)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (paramStEntry == null))
    {
      b();
      return;
    }
    RecommendBannerViewNew localRecommendBannerViewNew = this.b;
    if (localRecommendBannerViewNew == null) {
      return;
    }
    localRecommendBannerViewNew.a(paramStEntry, paramList, paramBoolean);
    ViewUtils.setViewVisibility(this.b, 0);
    if (((paramList == null) || (paramList.size() < 10)) && (paramBoolean)) {
      this.b.a();
    }
  }
  
  protected void a(Context paramContext)
  {
    this.d = SubscribeUtils.a();
    inflate(paramContext, 2131624363, this);
    if (this.d) {
      setBackgroundColor(-16777216);
    }
    this.b = ((RecommendBannerViewNew)findViewById(2131444421));
    this.c = findViewById(2131436319);
  }
  
  public void b()
  {
    ViewUtils.setViewVisibility(this.b, 8);
  }
  
  public void setOnHideBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    View localView = this.c;
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setPresenter(TopPanelContract.Presenter paramPresenter)
  {
    this.a = paramPresenter;
    RecommendBannerViewNew localRecommendBannerViewNew = this.b;
    if (localRecommendBannerViewNew != null) {
      localRecommendBannerViewNew.setPresenter(paramPresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew
 * JD-Core Version:    0.7.0.1
 */