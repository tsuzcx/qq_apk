package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bajq;
import com.tencent.biz.subscribe.account_folder.passive_bubble.PassiveBubbleView;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerView;
import java.util.List;
import vxc;
import vxd;
import vxm;

public class TopPanelView
  extends RelativeLayout
  implements vxd
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private PassiveBubbleView jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView;
  private RecommendBannerView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView;
  private vxc jdField_a_of_type_Vxc;
  
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
    bajq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 8);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView.a(paramInt);
      bajq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView, 0);
    }
  }
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<vxm> paramList, boolean paramBoolean)
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
      bajq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 0);
      bajq.a(this.jdField_a_of_type_AndroidWidgetTextView, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.a();
  }
  
  protected void a(Context paramContext)
  {
    inflate(paramContext, 2131493120, this);
    setBackgroundResource(2130839104);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView = ((RecommendBannerView)findViewById(2131309178));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderPassive_bubblePassiveBubbleView = ((PassiveBubbleView)findViewById(2131305582));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131310862));
  }
  
  public void b()
  {
    bajq.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView, 8);
    bajq.a(this.jdField_a_of_type_AndroidWidgetTextView, 8);
  }
  
  public void setPresenter(vxc paramvxc)
  {
    this.jdField_a_of_type_Vxc = paramvxc;
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerView.setPresenter(paramvxc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView
 * JD-Core Version:    0.7.0.1
 */