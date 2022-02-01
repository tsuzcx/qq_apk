package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.List;
import zqn;
import zrr;
import zrs;
import zse;

public class TopPanelViewNew
  extends RelativeLayout
  implements zrs
{
  private View jdField_a_of_type_AndroidViewView;
  private RecommendBannerViewNew jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew;
  private zrr jdField_a_of_type_Zrr;
  private boolean jdField_a_of_type_Boolean;
  
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
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<zse> paramList, boolean paramBoolean)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (paramStEntry == null)) {
      b();
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew == null);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew.a(paramStEntry, paramList, paramBoolean);
      ViewUtils.setViewVisibility(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew.a();
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = zqn.a();
    inflate(paramContext, 2131558805, this);
    if (this.jdField_a_of_type_Boolean) {
      setBackgroundColor(-16777216);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew = ((RecommendBannerViewNew)findViewById(2131376319));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131369357);
  }
  
  public void b()
  {
    ViewUtils.setViewVisibility(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew, 8);
  }
  
  public void setOnHideBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setPresenter(zrr paramzrr)
  {
    this.jdField_a_of_type_Zrr = paramzrr;
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew.setPresenter(paramzrr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew
 * JD-Core Version:    0.7.0.1
 */