package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class GdtAdWSVerticalItemTopController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  public static GdtAppReceiver a;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private WSVerticalPageAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private RoundImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView;
  private View b;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
  }
  
  public GdtAdWSVerticalItemTopController(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
  }
  
  public GdtAdWSVerticalItemTopController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalPageFragment;
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData == null) {}
    while (!(localWSVerticalItemData.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
  }
  
  public int b()
  {
    return 2131559301;
  }
  
  @UiThread
  public void b()
  {
    WSLog.a("GdtAdWSVerticalItemTopController", "onUpdateUI hashcode******************************" + hashCode() + ",position:" + a());
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData == null) {}
    while (!(localWSVerticalItemData.a() instanceof stSimpleMetaFeed)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.nick);
    WeishiUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.avatar);
  }
  
  public void c() {}
  
  public void e()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.height = WeishiUIUtil.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = WeishiUIUtil.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    localLayoutParams.leftMargin = WeishiUIUtil.a();
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    this.b = a(2131377377);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView = ((RoundImageView)a(2131367773));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367776));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewRoundImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null))
    {
      WSLog.b("GdtAdWSVerticalItemTopController", "跳转到广告落地页");
      if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
      {
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
      }
      Object localObject = new GdtAd(GdtAdUtil.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed));
      if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
        this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new GdtAdWSVerticalItemTopController.1(this);
      }
      AdExposureChecker.onClick(a(), (Ad)localObject, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
        if ((localObject != null) && (((WSVerticalVideoHolder)localObject).a != null) && (a() != null) && (((WSVerticalItemData)a()).a() != null))
        {
          GdtAdUtil.a(a(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, ((WSVerticalVideoHolder)localObject).a, false);
          ((WSVerticalItemData)a()).a().isGdtAdclicked = true;
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemTopController
 * JD-Core Version:    0.7.0.1
 */