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
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PassiveBubbleView jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView;
  private RecommendBannerView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView;
  private TopPanelContract.Presenter jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter;
  
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
    ViewUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 8);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView.a(paramInt);
      ViewUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 0);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<RecommendInfoItem> paramList, boolean paramBoolean)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (paramStEntry == null)) {
      b();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.a(paramStEntry, paramList, paramBoolean);
      }
      ViewUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 0);
      ViewUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean) || (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView == null));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.a();
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558844, this);
    setBackgroundResource(2130839537);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView = ((RecommendBannerView)findViewById(2131376714));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView = ((PassiveBubbleView)findViewById(2131372764));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378687));
  }
  
  public void b()
  {
    ViewUtils.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 8);
    ViewUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, 8);
  }
  
  public void setPresenter(TopPanelContract.Presenter paramPresenter)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelContract$Presenter = paramPresenter;
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.setPresenter(paramPresenter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView
 * JD-Core Version:    0.7.0.1
 */