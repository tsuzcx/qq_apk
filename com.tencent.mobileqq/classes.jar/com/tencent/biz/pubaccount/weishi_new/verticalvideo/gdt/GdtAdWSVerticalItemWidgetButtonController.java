package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class GdtAdWSVerticalItemWidgetButtonController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  public static GdtAppReceiver a;
  private stNewIconStyle jdField_a_of_type_UserGrowthStNewIconStyle;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private WSVerticalPageAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private View b;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = null;
  }
  
  public GdtAdWSVerticalItemWidgetButtonController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_UserGrowthStNewIconStyle.title)))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.b.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStNewIconStyle.title);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.b.setVisibility(8);
  }
  
  public void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed)))
    {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
      this.jdField_a_of_type_UserGrowthStNewIconStyle = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.new_icon;
    }
  }
  
  public int b()
  {
    return 2131559303;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_UserGrowthStNewIconStyle != null) && (this.jdField_a_of_type_UserGrowthStNewIconStyle.tag_type == 0))
    {
      a(true);
      return;
    }
    a(false);
  }
  
  public void c() {}
  
  public void e()
  {
    this.b = a(2131367767);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367769));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131367767) && (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null))
    {
      if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
      {
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
      }
      Object localObject = new GdtAd(GdtAdUtil.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed));
      if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
        this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new GdtAdWSVerticalItemWidgetButtonController.1(this);
      }
      AdExposureChecker.onClick(a(), (Ad)localObject, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      if ((this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a() != null))
      {
        localObject = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
        if ((localObject != null) && (((WSVerticalVideoHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (a() != null) && (((WSVerticalItemData)a()).a() != null))
        {
          GdtAdUtil.a(a(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, ((WSVerticalVideoHolder)localObject).jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, true);
          ((WSVerticalItemData)a()).a().isGdtAdclicked = true;
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemWidgetButtonController
 * JD-Core Version:    0.7.0.1
 */