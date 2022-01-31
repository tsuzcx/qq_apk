package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import begr;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.fragments.SubscribeAdGdtCanvasFragment;
import com.tencent.biz.subscribe.fragments.SubscribeAdVideoCeilingFragment;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.pb.vac_adv_get.DropList;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaInfo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import vvr;
import vvy;
import vvz;
import wgr;
import yjr;
import yjs;

public class RelativeAdFeedItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
  implements View.OnClickListener, View.OnLongClickListener
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839687);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private begr jdField_a_of_type_Begr;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private vac_adv_get.VacFeedsAdvMetaInfo jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private wgr jdField_a_of_type_Wgr;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = ImmersiveUtils.a() / 2;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public RelativeAdFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativeAdFeedItemView(Context paramContext, wgr paramwgr)
  {
    super(paramContext);
    this.jdField_a_of_type_Wgr = paramwgr;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo == null) {
      return;
    }
    try
    {
      yjs localyjs = new yjs();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(getContext());
      localyjs.jdField_a_of_type_Int = 1;
      if ((getContext() instanceof Activity)) {
        localyjs.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)getContext());
      }
      localyjs.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp);
      localyjs.jdField_a_of_type_Boolean = true;
      localyjs.jdField_b_of_type_Boolean = true;
      if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() == 185))
      {
        localyjs.c = true;
        localyjs.d = true;
      }
      localyjs.e = true;
      Object localObject = new int[2];
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLocationInWindow((int[])localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLocationOnScreen((int[])localObject);
      localyjs.jdField_a_of_type_AndroidGraphicsRect = new Rect(localObject[0], localObject[1], localObject[0] + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getWidth(), localObject[1] + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getHeight());
      localyjs.jdField_a_of_type_JavaLangClass = SubscribeAdVideoCeilingFragment.class;
      localyjs.jdField_b_of_type_JavaLangClass = SubscribeAdGdtCanvasFragment.class;
      localyjs.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localObject = new Bundle();
      ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
      ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_renzhenghao");
      localyjs.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
      yjr.a(localyjs);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public int a()
  {
    return 2131493143;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Begr == null)
    {
      this.jdField_a_of_type_Begr = begr.c(getContext());
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131493142, null);
      localViewGroup.findViewById(2131309297).setOnClickListener(this);
      localViewGroup.findViewById(2131304950).setOnClickListener(this);
      localViewGroup.findViewById(2131298297).setOnClickListener(this);
      this.jdField_a_of_type_Begr.a(localViewGroup, null);
    }
    this.jdField_a_of_type_Begr.show();
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if ((paramStFeed == null) || (!paramStFeed.adBuffer.has())) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      try
      {
        this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo = new vac_adv_get.VacFeedsAdvMetaInfo();
        this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.mergeFrom(paramStFeed.adBuffer.get().toByteArray());
        if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo == null) {
          continue;
        }
        if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info != null))
        {
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info != null)
          {
            if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.pic_width.get() < this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.pic_height.get()) {
              break label663;
            }
            f = 0.5625F;
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(f * this.jdField_b_of_type_Int));
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.jdField_b_of_type_Int;
            this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
            this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.txt.get());
            paramStFeed = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.img.get();
            if (!TextUtils.isEmpty(paramStFeed)) {
              vvr.a(paramStFeed, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
            }
          }
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info != null)
          {
            this.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info.corporate_image_name.get());
            vvr.a(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info.corporate_logo.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
          }
          if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() != 185) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() != 585)) {
            break label670;
          }
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info != null)
          {
            int i = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info.media_duration.get() / 60;
            int j = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info.media_duration.get();
            this.c.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
          }
          this.c.setVisibility(0);
        }
        else
        {
          if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get())) && (!this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get())))
          {
            vvz.a(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get());
            this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get());
          }
          if (!this.jdField_a_of_type_Boolean) {
            continue;
          }
          this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(1711276032);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setColorFilter(1711276032);
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
          this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-10132123);
          this.c.setTextColor(-5723992);
          this.c.setBackgroundDrawable(getResources().getDrawable(2130838623));
          return;
        }
      }
      catch (Exception paramStFeed)
      {
        for (;;)
        {
          paramStFeed.printStackTrace();
          continue;
          label663:
          float f = 1.777778F;
          continue;
          label670:
          this.c.setVisibility(8);
        }
      }
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312345));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131312231));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131302939));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.a(4.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131302878));
    this.c = ((TextView)findViewById(2131312339));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131303790);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131302868));
    paramView.setOnClickListener(this);
    paramView.setOnLongClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131309590: 
      b();
      return;
    case 2131309297: 
      if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.adBuffer.has()) && (this.jdField_a_of_type_Wgr != null))
      {
        this.jdField_a_of_type_Wgr.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
        if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.negative_feedback_url.get()))) {
          vvz.a(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.negative_feedback_url.get().replace("__ACT_TYPE__", "2001"));
        }
      }
      this.jdField_a_of_type_Begr.cancel();
      return;
    case 2131304950: 
      if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.droplist != null)
      {
        paramView = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.droplist.get().iterator();
        while (paramView.hasNext())
        {
          vac_adv_get.DropList localDropList = (vac_adv_get.DropList)paramView.next();
          if ((localDropList.action_type != null) && (localDropList.action_type.get() == 1)) {
            vvy.a(localDropList.jumpurl.get());
          }
        }
      }
      this.jdField_a_of_type_Begr.cancel();
      return;
    }
    this.jdField_a_of_type_Begr.cancel();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver != null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.unregister(getContext());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    a();
    return true;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView
 * JD-Core Version:    0.7.0.1
 */