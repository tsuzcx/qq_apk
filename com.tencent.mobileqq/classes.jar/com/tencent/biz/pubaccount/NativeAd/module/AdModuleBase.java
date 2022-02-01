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
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public abstract class AdModuleBase
  implements DownloadListener
{
  protected int a;
  protected AnimatorSet a;
  protected Dialog a;
  protected Context a;
  public View a;
  protected AdProgressButton a;
  protected BannerInfo a;
  protected QQAppInterface a;
  public INetInfoHandler a;
  protected String a;
  protected boolean a;
  protected int b;
  protected String b;
  protected int c;
  protected String c;
  
  public static AdModuleBase a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      int i = paramJSONObject.optInt("moduleType");
      if (i != 1)
      {
        if (i != 2) {
          paramJSONObject = null;
        } else {
          paramJSONObject = AdModuleVideo.a(paramJSONObject.optJSONObject("mixVideoModule"));
        }
      }
      else {
        paramJSONObject = AdModuleSinglePic.a(paramJSONObject.optJSONObject("singleImageModule"));
      }
      if (paramJSONObject != null) {
        paramJSONObject.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      }
      return paramJSONObject;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return null;
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo != null) && (!TextUtils.isEmpty(paramDownloadInfo.e)) && (!TextUtils.isEmpty(paramDownloadInfo.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f)))
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d)) {
        return false;
      }
      if ((paramDownloadInfo.e.equals(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f)) && (paramDownloadInfo.jdField_c_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d))) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(localContext, 1, localContext.getString(2131717855), 0).b(0);
      return;
    }
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext))
    {
      e();
      return;
    }
    f();
  }
  
  private void e()
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).downloadApk((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo, this);
    AdProgressButton localAdProgressButton = this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
    if (localAdProgressButton != null)
    {
      localAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717955));
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839314);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
      this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    }
    this.jdField_c_of_type_Int = 3;
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        localObject = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
        Context localContext = this.jdField_a_of_type_AndroidContentContext;
        this.jdField_a_of_type_AndroidAppDialog = ((IRIJAdUtilService)localObject).createDialog(localContext, null, localContext.getString(2131717963), new AdModuleBase.3(this), this.jdField_a_of_type_AndroidContentContext.getString(2131717964), new AdModuleBase.4(this), this.jdField_a_of_type_AndroidContentContext.getString(2131717965));
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
      Context localContext = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a(localContext, 1, localContext.getString(2131717966), 0).b(0);
      ThreadManager.getUIHandler().post(new AdModuleBase.5(this));
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
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
      if ((localObject != null) && (((BannerInfo)localObject).jdField_a_of_type_Int == 2))
      {
        localObject = (AdProgressButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131373137);
        if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 2)
        {
          ((AdProgressButton)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717969));
          return;
        }
        if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 1)
        {
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f))
          {
            ((AdProgressButton)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717967));
            this.jdField_c_of_type_Int = 1;
            return;
          }
          if (ADBaseAppDownloadManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f))
          {
            ((AdProgressButton)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717960));
            this.jdField_c_of_type_Int = 2;
            return;
          }
          if (this.jdField_c_of_type_Int != 3)
          {
            ((AdProgressButton)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717954));
            this.jdField_c_of_type_Int = 0;
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131560237, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((ViewGroup)paramView).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
    int i;
    if (((localObject1 == null) || (((BannerInfo)localObject1).jdField_a_of_type_Int != 1)) && (!this.jdField_a_of_type_Boolean))
    {
      i = this.jdField_b_of_type_Int;
      if ((i == 1) || (i == 2))
      {
        paramView.findViewById(2131378747).setVisibility(0);
        if (this.jdField_b_of_type_Int == 1) {
          paramView.findViewById(2131378749).setVisibility(8);
        }
        localObject1 = paramView.findViewById(2131380312);
        localObject2 = paramView.findViewById(2131380313);
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
    }
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
      if ((localObject1 != null) && (((BannerInfo)localObject1).jdField_a_of_type_Int == 2))
      {
        paramView.findViewById(2131365830).setVisibility(0);
        try
        {
          localObject1 = new URL(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_JavaLangString);
          ((ResizeURLImageView)paramView.findViewById(2131365842)).setImage((URL)localObject1);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        ((TextView)paramView.findViewById(2131365837)).setText(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)paramView.findViewById(2131373137));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(paramContext.getResources().getColor(2131165349));
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(new AdModuleBase.1(this));
        i = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgDownloading(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo);
        if (i >= 0)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(this.jdField_a_of_type_AndroidContentContext.getText(2131717955));
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839314);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(i);
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
          this.jdField_c_of_type_Int = 3;
          DownloadManager.a().a(this);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler == null)
        {
          this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new AdModuleBase.2(this);
          AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
        }
      }
    }
  }
  
  public abstract void b();
  
  public void c()
  {
    this.jdField_a_of_type_AndroidViewView = null;
    AnimatorSet localAnimatorSet = this.jdField_a_of_type_AndroidAnimationAnimatorSet;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.cancel();
      this.jdField_a_of_type_AndroidAnimationAnimatorSet = null;
    }
    this.jdField_a_of_type_Int = 0;
    if (this.jdField_a_of_type_Boolean) {
      DownloadManager.a().b(this);
    }
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new AdModuleBase.7(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new AdModuleBase.9(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new AdModuleBase.6(this));
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (a(localDownloadInfo)) {
        ThreadManager.getUIHandler().post(new AdModuleBase.8(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase
 * JD-Core Version:    0.7.0.1
 */