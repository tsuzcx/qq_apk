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
  private View jdField_a_of_type_AndroidViewView;
  private RecommendBannerViewNew jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew;
  private TopPanelContract.Presenter jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter;
  private boolean jdField_a_of_type_Boolean = false;
  
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
    RecommendBannerViewNew localRecommendBannerViewNew = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew;
    if (localRecommendBannerViewNew == null) {
      return;
    }
    localRecommendBannerViewNew.a(paramStEntry, paramList, paramBoolean);
    ViewUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew, 0);
    if (((paramList == null) || (paramList.size() < 10)) && (paramBoolean)) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew.a();
    }
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = SubscribeUtils.a();
    inflate(paramContext, 2131558743, this);
    if (this.jdField_a_of_type_Boolean) {
      setBackgroundColor(-16777216);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew = ((RecommendBannerViewNew)findViewById(2131376213));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369320);
  }
  
  public void b()
  {
    ViewUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew, 8);
  }
  
  public void setOnHideBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setPresenter(TopPanelContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter = paramPresenter;
    RecommendBannerViewNew localRecommendBannerViewNew = this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew;
    if (localRecommendBannerViewNew != null) {
      localRecommendBannerViewNew.setPresenter(paramPresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew
 * JD-Core Version:    0.7.0.1
 */