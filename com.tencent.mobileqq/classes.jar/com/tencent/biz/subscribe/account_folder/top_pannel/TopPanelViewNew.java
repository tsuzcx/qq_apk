package com.tencent.biz.subscribe.account_folder.top_pannel;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StEntry;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import bdoo;
import com.tencent.biz.subscribe.account_folder.recommend_banner.RecommendBannerViewNew;
import java.util.List;
import ybu;
import ycy;
import ycz;
import ydc;
import ydd;
import ydn;

public class TopPanelViewNew
  extends RelativeLayout
  implements ycz
{
  private View jdField_a_of_type_AndroidViewView;
  private RecommendBannerViewNew jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew;
  private ycy jdField_a_of_type_Ycy;
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
  
  public void a(CertifiedAccountMeta.StEntry paramStEntry, List<ydn> paramList, boolean paramBoolean)
  {
    if (((paramList == null) || (paramList.size() == 0)) && (paramStEntry == null)) {
      b();
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew != null) {
        this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew.a(paramStEntry, paramList, paramBoolean);
      }
      bdoo.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew, 0);
    } while (((paramList != null) && (paramList.size() >= 10)) || (!paramBoolean));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew.a();
  }
  
  protected void a(Context paramContext)
  {
    this.jdField_a_of_type_Boolean = ybu.a();
    inflate(paramContext, 2131558708, this);
    if (this.jdField_a_of_type_Boolean) {
      setBackgroundColor(-16777216);
    }
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew = ((RecommendBannerViewNew)findViewById(2131375443));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368743);
  }
  
  public void b()
  {
    bdoo.a(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew, 8);
  }
  
  public void c()
  {
    if (getVisibility() == 8)
    {
      clearAnimation();
      return;
    }
    Object localObject = (View)getParent();
    if (localObject != null) {
      measure(View.MeasureSpec.makeMeasureSpec(((View)localObject).getMeasuredWidth(), -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
    localObject = ValueAnimator.ofInt(new int[] { getMeasuredHeight(), 0 });
    ((ValueAnimator)localObject).addUpdateListener(new ydd(this, this, null));
    ((ValueAnimator)localObject).addListener(new ydc(this));
    ((ValueAnimator)localObject).start();
  }
  
  public void setOnHideBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void setPresenter(ycy paramycy)
  {
    this.jdField_a_of_type_Ycy = paramycy;
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerRecommendBannerViewNew.setPresenter(paramycy);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelViewNew
 * JD-Core Version:    0.7.0.1
 */