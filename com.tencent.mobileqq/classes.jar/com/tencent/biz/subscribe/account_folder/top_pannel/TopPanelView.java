package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import aafo;
import aafp;
import aagb;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bhtq;
import com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView;
import java.util.List;

public class TopPanelView
  extends RelativeLayout
  implements aafp
{
  private aafo jdField_a_of_type_Aafo;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PassiveBubbleView jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView;
  private RecommendBannerView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView;
  
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
    bhtq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 8);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView.a(paramInt);
      bhtq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 0);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<aagb> paramList, boolean paramBoolean)
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
      bhtq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 0);
      bhtq.a(this.jdField_a_of_type_AndroidWidgetTextView, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.a();
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558771, this);
    setBackgroundResource(2130839402);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView = ((RecommendBannerView)findViewById(2131376306));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView = ((PassiveBubbleView)findViewById(2131372296));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378203));
  }
  
  public void b()
  {
    bhtq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 8);
    bhtq.a(this.jdField_a_of_type_AndroidWidgetTextView, 8);
  }
  
  public void setPresenter(aafo paramaafo)
  {
    this.jdField_a_of_type_Aafo = paramaafo;
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.setPresenter(paramaafo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView
 * JD-Core Version:    0.7.0.1
 */