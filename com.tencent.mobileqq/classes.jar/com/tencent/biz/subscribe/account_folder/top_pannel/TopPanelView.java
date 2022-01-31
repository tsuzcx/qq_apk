package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bbll;
import com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView;
import java.util.List;
import wjx;
import wjy;
import wkl;

public class TopPanelView
  extends RelativeLayout
  implements wjy
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PassiveBubbleView jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView;
  private RecommendBannerView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView;
  private wjx jdField_a_of_type_Wjx;
  
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
    bbll.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 8);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView.a(paramInt);
      bbll.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 0);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<wkl> paramList, boolean paramBoolean)
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
      bbll.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 0);
      bbll.a(this.jdField_a_of_type_AndroidWidgetTextView, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.a();
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131558671, this);
    setBackgroundResource(2130839132);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView = ((RecommendBannerView)findViewById(2131374924));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView = ((PassiveBubbleView)findViewById(2131371278));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376671));
  }
  
  public void b()
  {
    bbll.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 8);
    bbll.a(this.jdField_a_of_type_AndroidWidgetTextView, 8);
  }
  
  public void setPresenter(wjx paramwjx)
  {
    this.jdField_a_of_type_Wjx = paramwjx;
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.setPresenter(paramwjx);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView
 * JD-Core Version:    0.7.0.1
 */