package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.views.image.GdtDrawableLoader;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label;

public class GdtAdWSVerticalItemBottomUserController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  public static GdtAppReceiver a;
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public AdExposureChecker.ExposureCallback a;
  private WSVerticalPageAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
  private WSVerticalPageFragment jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
  private GdtAdWSCountDownLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
  private GdtAdWSIndustryLabelContainer jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSIndustryLabelContainer;
  private WSRoundedImageView jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView;
  private GdtDrawableLoader.Listener jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener;
  private GdtDrawableLoader jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  
  public GdtAdWSVerticalItemBottomUserController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = null;
    if (paramWSVerticalVideoHolder != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment = paramWSVerticalVideoHolder.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment;
    }
  }
  
  private boolean a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = GdtAdUtil.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    paramWSVerticalItemData = new String[3];
    int j = 8;
    try
    {
      localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.basic_info.element_structure_content.label.get().iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label localLabel = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localLabel.content.get()))
        {
          paramWSVerticalItemData[i] = localLabel.content.get();
          i += 1;
        }
      }
      if (!TextUtils.isEmpty(paramWSVerticalItemData[0]))
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(paramWSVerticalItemData[0]);
        this.c.setText(paramWSVerticalItemData[1]);
        this.d.setText(paramWSVerticalItemData[2]);
        localObject = this.jdField_b_of_type_AndroidWidgetTextView;
        if (!TextUtils.isEmpty(paramWSVerticalItemData[0])) {
          i = 0;
        } else {
          i = 8;
        }
        ((TextView)localObject).setVisibility(i);
        localObject = this.c;
        if (!TextUtils.isEmpty(paramWSVerticalItemData[1])) {
          i = 0;
        } else {
          i = 8;
        }
        ((TextView)localObject).setVisibility(i);
        localObject = this.d;
        i = j;
        if (!TextUtils.isEmpty(paramWSVerticalItemData[2])) {
          i = 0;
        }
        ((TextView)localObject).setVisibility(i);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSIndustryLabelContainer.setVisibility(0);
        return true;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSIndustryLabelContainer.setVisibility(8);
      return false;
    }
    catch (Exception paramWSVerticalItemData)
    {
      label240:
      break label240;
    }
    QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "showGdtIndustryLabelContainer: 后台未下发labels字段");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSIndustryLabelContainer.setVisibility(8);
    return false;
  }
  
  private boolean b(WSVerticalItemData paramWSVerticalItemData)
  {
    try
    {
      long l1 = Long.parseLong(GdtAdUtil.a("countdown_end_time", paramWSVerticalItemData.a()));
      long l2 = System.currentTimeMillis() / 1000L;
      return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout.a((int)(l1 - l2));
    }
    catch (NumberFormatException paramWSVerticalItemData)
    {
      label35:
      break label35;
    }
    QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "showGdtCountDownWidget: 后台未下发倒计时字段");
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout.c();
    return false;
  }
  
  private boolean c(WSVerticalItemData paramWSVerticalItemData)
  {
    paramWSVerticalItemData = GdtAdUtil.a(paramWSVerticalItemData.a());
    if (!TextUtils.isEmpty(paramWSVerticalItemData))
    {
      this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader = new GdtDrawableLoader(paramWSVerticalItemData, new WeakReference(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader$Listener));
      this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader.a();
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentGdtadViewsImageGdtDrawableLoader.a());
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return true;
    }
    QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "showGdtMarketingPendantUrl: 后台未下发营销挂件字段");
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    return false;
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = localWSVerticalItemData.a();
    }
  }
  
  protected int b()
  {
    return 2131559173;
  }
  
  protected void b()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)a();
    if (localWSVerticalItemData != null)
    {
      if (localWSVerticalItemData.a() == null) {
        return;
      }
      if ((localWSVerticalItemData.a() instanceof stSimpleMetaFeed))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.nick);
        WSPicLoader.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.poster.avatar);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeWidth(8);
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setStrokeColor(Color.parseColor("#66FFFFFF"));
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "onUpdateUI, victoryfxu");
        if ((!b(localWSVerticalItemData)) && (!c(localWSVerticalItemData))) {
          a(localWSVerticalItemData);
        }
      }
    }
  }
  
  protected void c()
  {
    GdtAdWSCountDownLayout localGdtAdWSCountDownLayout = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout;
    if (localGdtAdWSCountDownLayout != null)
    {
      localGdtAdWSCountDownLayout.b();
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout = null;
    }
  }
  
  protected void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView = ((WSRoundedImageView)a(2131367531));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131367534));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)a(2131367521));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)a(2131367525));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout = ((GdtAdWSCountDownLayout)a(2131367519));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSIndustryLabelContainer = ((GdtAdWSIndustryLabelContainer)a(2131367523));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2131367576));
    this.c = ((TextView)a(2131367577));
    this.d = ((TextView)a(2131367578));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSRoundedImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSCountDownLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoGdtGdtAdWSIndustryLabelContainer.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131367521)
    {
      paramView = new WSShareParam();
      paramView.jdField_a_of_type_UserGrowthStSimpleMetaFeed = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed;
      paramView.jdField_a_of_type_Int = 2;
      paramView.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      paramView.jdField_a_of_type_JavaLangString = WSVerticalBeaconReport.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a());
      paramView.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.b();
      paramView.c = "more_operations";
      paramView.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment);
      WeishiShareUtil.a(this.jdField_a_of_type_AndroidContentContext, paramView);
      return;
    }
    if ((this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null) && (a() != null) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment != null))
    {
      WSLog.b("GdtAdWSVerticalItemBottomUserController", "跳转到广告落地页");
      if (jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
      {
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
        jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(BaseApplicationImpl.getContext());
      }
      paramView = new GdtAd(GdtAdUtil.a(this.jdField_a_of_type_UserGrowthStSimpleMetaFeed));
      if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
        this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = new GdtAdWSVerticalItemBottomUserController.1(this);
      }
      AdExposureChecker.onClick(a(), paramView, new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageFragment.a();
      paramView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter;
      if ((paramView != null) && (paramView.a() != null))
      {
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newVerticalvideoWSVerticalPageAdapter.a();
        if ((paramView != null) && (paramView.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam != null) && (a() != null) && (((WSVerticalItemData)a()).a() != null))
        {
          GdtAdUtil.a(a(), this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver, paramView.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerParam, false);
          ((WSVerticalItemData)a()).a().isGdtAdclicked = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemBottomUserController
 * JD-Core Version:    0.7.0.1
 */