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
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.weishi_new.commercial.AbsWSRichWidgetData;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class WSVerticalItemWidgetController
  extends AbsWsVerticalUIGroup
  implements View.OnClickListener
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private AbsWSRichWidgetData jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
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
    WSVerticalItemData localWSVerticalItemData1;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().a() != null))
    {
      localWSVerticalItemData1 = (WSVerticalItemData)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a().a().jdField_a_of_type_JavaLangObject;
      if (localWSVerticalItemData1 != null) {}
    }
    else
    {
      return false;
    }
    WSVerticalItemData localWSVerticalItemData2 = (WSVerticalItemData)a();
    stSimpleMetaFeed localstSimpleMetaFeed;
    if (localWSVerticalItemData2 != null)
    {
      localstSimpleMetaFeed = localWSVerticalItemData2.a();
      if ((localstSimpleMetaFeed != null) && (localWSVerticalItemData2.a() != null)) {}
    }
    else
    {
      return false;
    }
    return TextUtils.equals(localWSVerticalItemData1.a().id, localstSimpleMetaFeed.id);
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void d(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.getLayoutParams();
    if (paramInt == 3)
    {
      this.b.setBackgroundResource(2130842884);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
      localLayoutParams.width = WeishiUIUtil.g;
      localLayoutParams.height = WeishiUIUtil.g;
      localLayoutParams.leftMargin = WeishiUIUtil.e;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setLayoutParams(localLayoutParams);
      return;
      if (paramInt == 1)
      {
        this.b.setBackgroundResource(2130842885);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, a().getDrawable(2130851329), null);
        this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(WeishiUIUtil.b);
        localLayoutParams.width = WeishiUIUtil.o;
        localLayoutParams.height = WeishiUIUtil.j;
        localLayoutParams.leftMargin = 0;
      }
    }
  }
  
  private void f()
  {
    int i = c();
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.b())) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.a())) || ((i != 3) && (i != 1)))
    {
      bool = true;
      WSLog.a("WSVerticalItemWidgetController", "[updateWidgetBtnContent] des : " + ((WSVerticalItemData)a()).a().feed_desc + ", isGone :" + bool);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setImageBitmap(null);
      if (!bool) {
        break label122;
      }
      this.b.setVisibility(8);
    }
    label122:
    do
    {
      return;
      bool = false;
      break;
      d(i);
      this.b.setVisibility(0);
      String str1 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.b();
      String str2 = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.a();
      WSLog.a("WSVerticalItemWidgetController", "[updateWidgetBtnContent] text:" + str1 + ", iconUrl:" + str2);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str1);
      WeishiUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView, str2, null);
    } while (!a());
    g();
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), (WSVerticalItemData)a());
    }
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData = localWSVerticalItemData.a();
    }
  }
  
  public int b()
  {
    return 2131560165;
  }
  
  public void b()
  {
    f();
  }
  
  public int c()
  {
    int i = 0;
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData != null) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommercialAbsWSRichWidgetData.a();
    }
    return i;
  }
  
  public void c() {}
  
  protected void c(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.b.getVisibility() == 0) {
      WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a(), this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b(), (WSVerticalItemData)a());
    }
  }
  
  public void e()
  {
    this.b = a(2131381221);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)a(2131381223));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131381222));
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131381221) {
      WSVerticalJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment, (WSVerticalItemData)a());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetController
 * JD-Core Version:    0.7.0.1
 */