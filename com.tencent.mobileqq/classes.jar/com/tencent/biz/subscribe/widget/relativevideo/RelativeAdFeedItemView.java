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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
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

public class RelativeAdFeedItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
  implements View.OnClickListener, View.OnLongClickListener
{
  private CertifiedAccountMeta.StFeed jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130840321);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private RoundCornerImageView jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView;
  private RelativeAdFeedItemView.AdInnerClickListener jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeAdFeedItemView$AdInnerClickListener;
  private AsyncRichTextView jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private SquareImageView jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private vac_adv_get.VacFeedsAdvMetaInfo jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo;
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private TextView b;
  private int c;
  
  public RelativeAdFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = (ImmersiveUtils.getScreenWidth() / 2);
  }
  
  public RelativeAdFeedItemView(Context paramContext, RelativeAdFeedItemView.AdInnerClickListener paramAdInnerClickListener)
  {
    super(paramContext);
    this.jdField_c_of_type_Int = (ImmersiveUtils.getScreenWidth() / 2);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeAdFeedItemView$AdInnerClickListener = paramAdInnerClickListener;
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo == null) {
      return;
    }
    try
    {
      GdtHandler.Params localParams = new GdtHandler.Params();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = new GdtAppReceiver();
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver.register(getContext());
      localParams.jdField_c_of_type_Int = 1;
      if ((getContext() instanceof Activity)) {
        localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)getContext());
      }
      localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp);
      localParams.jdField_a_of_type_Boolean = true;
      localParams.jdField_b_of_type_Boolean = true;
      if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() == 185))
      {
        localParams.jdField_c_of_type_Boolean = true;
        localParams.d = true;
      }
      localParams.e = true;
      Object localObject = new int[2];
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLocationInWindow((int[])localObject);
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLocationOnScreen((int[])localObject);
      localParams.jdField_a_of_type_AndroidGraphicsRect = new Rect(localObject[0], localObject[1], localObject[0] + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getWidth(), localObject[1] + this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getHeight());
      localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      localObject = new Bundle();
      ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
      ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_renzhenghao");
      localParams.jdField_a_of_type_AndroidOsBundle = ((Bundle)localObject);
      GdtHandler.a(localParams);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected int a()
  {
    return 2131558768;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ActionSheet.createMenuSheet(getContext());
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131558767, null);
      localViewGroup.findViewById(2131376332).setOnClickListener(this);
      localViewGroup.findViewById(2131371678).setOnClickListener(this);
      localViewGroup.findViewById(2131364259).setOnClickListener(this);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setActionContentView(localViewGroup, null);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (!paramStFeed.adBuffer.has()) {
        return;
      }
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
      try
      {
        this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo = new vac_adv_get.VacFeedsAdvMetaInfo();
        this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.mergeFrom(paramStFeed.adBuffer.get().toByteArray());
      }
      catch (Exception paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
      paramStFeed = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo;
      if (paramStFeed == null) {
        return;
      }
      if ((paramStFeed.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info != null))
      {
        if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info != null)
        {
          float f;
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.pic_width.get() >= this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.pic_height.get()) {
            f = 0.5625F;
          } else {
            f = 1.777778F;
          }
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().height = ((int)(this.jdField_c_of_type_Int * f));
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.getLayoutParams().width = this.jdField_c_of_type_Int;
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.requestLayout();
          this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setText(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.txt.get());
          paramStFeed = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.basic_info.img.get();
          if (!TextUtils.isEmpty(paramStFeed)) {
            SubImageLoader.a(paramStFeed, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView);
          }
        }
        if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info != null)
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info.corporate_image_name.get());
          SubImageLoader.a(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.advertiser_info.corporate_logo.get(), this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView);
        }
        if ((this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() != 185) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.creative_size.get() != 585))
        {
          this.b.setVisibility(8);
        }
        else
        {
          if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info != null)
          {
            int i = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info.media_duration.get() / 60;
            int j = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.display_info.video_info.media_duration.get();
            this.b.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j % 60) }));
          }
          this.b.setVisibility(0);
        }
      }
      paramStFeed = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo;
      if ((paramStFeed != null) && (paramStFeed.adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get())) && (!this.jdField_a_of_type_JavaUtilSet.contains(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get())))
      {
        SubscribeUtils.a(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get());
        this.jdField_a_of_type_JavaUtilSet.add(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.exposure_url.get());
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView.setFilterColor(1711276032);
        this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setColorFilter(1711276032);
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView.setTextColor(-5723992);
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-10132123);
        this.b.setTextColor(-5723992);
        this.b.setBackgroundDrawable(getResources().getDrawable(2130838943));
      }
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetTextviewAsyncRichTextView = ((AsyncRichTextView)findViewById(2131379675));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379529));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView = ((RoundCornerImageView)findViewById(2131369356));
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDiscoverRoundCornerImageView.setCorner(ImmersiveUtils.dpToPx(4.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetSquareImageView = ((SquareImageView)findViewById(2131369284));
    this.b = ((TextView)findViewById(2131379668));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370333);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369270));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376648));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376648: 
      c();
      break;
    case 2131376332: 
      localObject = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      if ((localObject != null) && (((CertifiedAccountMeta.StFeed)localObject).adBuffer.has()))
      {
        localObject = this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoRelativeAdFeedItemView$AdInnerClickListener;
        if (localObject != null)
        {
          ((RelativeAdFeedItemView.AdInnerClickListener)localObject).b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed);
          localObject = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo;
          if ((localObject != null) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).adv_rsp != null) && (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.negative_feedback_url.get()))) {
            SubscribeUtils.a(this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.adv_rsp.report_info.negative_feedback_url.get().replace("__ACT_TYPE__", "2001"));
          }
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      break;
    case 2131371678: 
      if (this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.droplist != null)
      {
        localObject = this.jdField_a_of_type_CooperationVipPbVac_adv_get$VacFeedsAdvMetaInfo.droplist.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          vac_adv_get.DropList localDropList = (vac_adv_get.DropList)((Iterator)localObject).next();
          if ((localDropList.action_type != null) && (localDropList.action_type.get() == 1)) {
            SubscribeLaucher.a(localDropList.jumpurl.get());
          }
        }
      }
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      break;
    case 2131364259: 
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    GdtAppReceiver localGdtAppReceiver = this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
    if (localGdtAppReceiver != null) {
      localGdtAppReceiver.unregister(getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView
 * JD-Core Version:    0.7.0.1
 */