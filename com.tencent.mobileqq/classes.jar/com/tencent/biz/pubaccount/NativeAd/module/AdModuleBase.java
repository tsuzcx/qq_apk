package com.tencent.biz.pubaccount.NativeAd.module;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import kwo;
import kwp;
import kwq;
import kwr;
import kws;
import kwt;
import kwu;
import kwv;
import kww;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class AdModuleBase
  implements DownloadListener
{
  public int a;
  protected AnimatorSet a;
  public Dialog a;
  public Context a;
  public View a;
  public AdProgressButton a;
  public BannerInfo a;
  public QQAppInterface a;
  public INetInfoHandler a;
  public String a;
  protected boolean a;
  protected int b;
  public String b;
  public int c;
  public String c;
  
  public static AdModuleBase a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        switch (paramJSONObject.optInt("moduleType"))
        {
        case 1: 
          if (paramJSONObject == null) {
            return paramJSONObject;
          }
          paramJSONObject.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return null;
      }
      paramJSONObject = AdModuleSinglePic.a(paramJSONObject.optJSONObject("singleImageModule"));
      continue;
      paramJSONObject = AdModuleVideo.a(paramJSONObject.optJSONObject("mixVideoModule"));
      continue;
      paramJSONObject = null;
    }
    return paramJSONObject;
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo == null) || (TextUtils.isEmpty(paramDownloadInfo.d)) || (TextUtils.isEmpty(paramDownloadInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d))) {}
    while ((!paramDownloadInfo.d.equals(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f)) || (!paramDownloadInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d))) {
      return false;
    }
    return true;
  }
  
  private void d()
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131438866), 0).b(0);
      return;
    }
    if (NetworkUtil.h(this.jdField_a_of_type_AndroidContentContext))
    {
      e();
      return;
    }
    f();
  }
  
  private void e()
  {
    NativeAdUtils.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo, this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131438695));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838520);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    }
    this.jdField_c_of_type_Int = 3;
    NativeAdUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_AndroidContentContext.getString(2131438698), new kwq(this), this.jdField_a_of_type_AndroidContentContext.getString(2131438699), new kwr(this), this.jdField_a_of_type_AndroidContentContext.getString(2131438697));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Int == 3)
    {
      DownloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 1, this.jdField_a_of_type_AndroidContentContext.getString(2131438700), 0).b(0);
      ThreadManager.getUIHandler().post(new kws(this));
    }
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, BannerInfo paramBannerInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo = paramBannerInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    return null;
  }
  
  public void a()
  {
    AdProgressButton localAdProgressButton;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int == 2))
    {
      localAdProgressButton = (AdProgressButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131367244);
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int != 2) {
        break label70;
      }
      localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131438692));
    }
    label70:
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int != 1);
      if (NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f))
      {
        localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131438696));
        this.jdField_c_of_type_Int = 1;
        return;
      }
      if (NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo))
      {
        localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131438694));
        this.jdField_c_of_type_Int = 2;
        return;
      }
    } while (this.jdField_c_of_type_Int == 3);
    localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131438693));
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(Context paramContext, View paramView)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2130969633, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((ViewGroup)paramView).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    if (((this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo == null) || (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int != 1)) && (!this.jdField_a_of_type_Boolean) && ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 2)))
    {
      paramView.findViewById(2131367240).setVisibility(0);
      if (this.jdField_b_of_type_Int == 1) {
        paramView.findViewById(2131367241).setVisibility(8);
      }
      localObject1 = paramView.findViewById(2131365588);
      localObject2 = paramView.findViewById(2131365589);
      ((View)localObject1).setAlpha(0.0F);
      ((View)localObject1).setVisibility(0);
      ((View)localObject2).setAlpha(0.0F);
      ((View)localObject2).setVisibility(0);
      localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
      ((ObjectAnimator)localObject2).setDuration(1800L);
      ((ObjectAnimator)localObject2).setRepeatCount(-1);
      ((ObjectAnimator)localObject2).setRepeatMode(1);
      ((ObjectAnimator)localObject2).setStartDelay(100L);
      ((ObjectAnimator)localObject1).setDuration(1800L);
      ((ObjectAnimator)localObject1).setRepeatCount(-1);
      ((ObjectAnimator)localObject1).setRepeatMode(1);
      ((ObjectAnimator)localObject1).setStartDelay(240L);
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.playTogether(new Animator[] { localObject2, localObject1 });
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int == 2)) {
      paramView.findViewById(2131367242).setVisibility(0);
    }
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_JavaLangString);
      ((ResizeURLImageView)paramView.findViewById(2131367243)).a((URL)localObject1);
      ((TextView)paramView.findViewById(2131367245)).setText(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)paramView.findViewById(2131367244));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(paramContext.getResources().getColor(2131493308));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(new kwo(this));
      int i = NativeAdUtils.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo);
      if (i >= 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131438695));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130838520);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(i);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
        this.jdField_c_of_type_Int = 3;
        DownloadManager.a().a(this);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new kwp(this);
        AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(DownloadInfo paramDownloadInfo) {}
  
  public void a(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new kww(this));
    }
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void a(List paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (a(localDownloadInfo)) {
        ThreadManager.getUIHandler().post(new kwv(this, localDownloadInfo));
      }
    }
  }
  
  public abstract void b();
  
  public void b(DownloadInfo paramDownloadInfo) {}
  
  public void b(String paramString1, String paramString2) {}
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null)
    {
      this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Boolean) {
      DownloadManager.a().b(this);
    }
  }
  
  public void c(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new kwt(this));
      NativeAdUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
    }
  }
  
  public void c(String paramString1, String paramString2) {}
  
  public void d(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new kwu(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase
 * JD-Core Version:    0.7.0.1
 */