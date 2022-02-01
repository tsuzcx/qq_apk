package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.commercial.AbsWSRichWidgetData;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSVerticalItemWidgetController
  extends AbsWsVerticalUIGroup
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AbsWSRichWidgetData jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private KandianUrlImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView;
  private boolean jdField_a_of_type_Boolean;
  private View b;
  
  public WSVerticalItemWidgetController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    if ((localObject != null) && (((WSVerticalPageFragment)localObject).a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().a() != null))
    {
      localObject = (WSVerticalItemData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().a().jdField_a_of_type_JavaLangObject;
      if (localObject == null) {
        return false;
      }
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
      if (localWSVerticalItemData != null)
      {
        stSimpleMetaFeed localstSimpleMetaFeed = localWSVerticalItemData.a();
        if (localstSimpleMetaFeed != null)
        {
          if (localWSVerticalItemData.a() == null) {
            return false;
          }
          return TextUtils.equals(((WSVerticalItemData)localObject).a().id, localstSimpleMetaFeed.id);
        }
      }
    }
    return false;
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void e(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.getLayoutParams();
    if (paramInt == 3)
    {
      this.b.setBackgroundResource(2130842787);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localLayoutParams.width = WeishiUIUtil.i;
      localLayoutParams.height = WeishiUIUtil.i;
      localLayoutParams.leftMargin = WeishiUIUtil.f;
    }
    else if (paramInt == 1)
    {
      this.b.setBackgroundResource(2130842788);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, a().getDrawable(2130851242), null);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(WeishiUIUtil.b);
      localLayoutParams.width = WeishiUIUtil.r;
      localLayoutParams.height = WeishiUIUtil.l;
      localLayoutParams.leftMargin = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setLayoutParams(localLayoutParams);
  }
  
  private void f()
  {
    int i = c();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(((AbsWSRichWidgetData)localObject).b()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.a())) {
          if ((i != 3) && (i != 1)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[updateWidgetBtnContent] des : ");
    ((StringBuilder)localObject).append(((WSVerticalItemData)a()).a().feed_desc);
    ((StringBuilder)localObject).append(", isGone :");
    ((StringBuilder)localObject).append(bool1);
    WSLog.a("WSVerticalItemWidgetController", ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView.setImageBitmap(null);
    if (bool1)
    {
      this.b.setVisibility(8);
      return;
    }
    e(i);
    this.b.setVisibility(0);
    localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.b();
    String str = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateWidgetBtnContent] text:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", iconUrl:");
    localStringBuilder.append(str);
    WSLog.a("WSVerticalItemWidgetController", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    WSPicLoader.a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView, str, null);
    if (a()) {
      g();
    }
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), (WSVerticalItemData)a());
    }
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData = localWSVerticalItemData.a();
    }
  }
  
  protected int b()
  {
    return 2131560051;
  }
  
  protected void b()
  {
    f();
  }
  
  public int c()
  {
    AbsWSRichWidgetData localAbsWSRichWidgetData = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData;
    if (localAbsWSRichWidgetData != null) {
      return localAbsWSRichWidgetData.a();
    }
    return 0;
  }
  
  protected void c() {}
  
  protected void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.b.getVisibility() == 0) {
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), (WSVerticalItemData)a());
    }
  }
  
  protected void d(int paramInt) {}
  
  protected void e()
  {
    this.b = a(2131380477);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetKandianUrlImageView = ((KandianUrlImageView)a(2131380479));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380478));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380477) {
      WSVerticalJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, (WSVerticalItemData)a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetController
 * JD-Core Version:    0.7.0.1
 */