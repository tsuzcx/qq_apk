package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;
import com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyNativeAdFragment
  extends PublicBaseFragment
  implements View.OnClickListener, INetInfoHandler, DownloadListener
{
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private AdProgressButton jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private AdModuleAdapter jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter;
  private BannerInfo jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
  private IPublicAccountImageDownListener jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener = null;
  private ResizeURLImageView jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<AdModuleBase> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int d = 1;
  
  private void a()
  {
    Object localObject1 = getArguments().getString("param_ad_json");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkData->");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReadInJoyNativeAdFragment", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      getBaseActivity().finish();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("adId");
        this.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("channelId");
        this.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("info");
        this.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("upslideType");
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo = BannerInfo.a(((JSONObject)localObject1).optString("bannerInfo"));
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject1 = ((JSONObject)localObject1).optJSONArray("pageInfoList");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = AdModuleBase.a(getBaseActivity().app, ((JSONArray)localObject1).getJSONObject(i));
          if (localObject2 != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0) {
            getBaseActivity().finish();
          }
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 1, 1, 0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        getBaseActivity().finish();
        return;
      }
      i += 1;
    }
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
  
  private void b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
    if ((localObject1 != null) && (((BannerInfo)localObject1).jdField_a_of_type_Int == 1))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)
      {
        int i = this.jdField_a_of_type_Int;
        if ((i == 1) || (i == 2))
        {
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (this.jdField_a_of_type_Int == 1) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131378749).setVisibility(8);
          }
          Object localObject2 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380312);
          localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131380313);
          ((View)localObject2).setAlpha(0.0F);
          ((View)localObject2).setVisibility(0);
          ((View)localObject1).setAlpha(0.0F);
          ((View)localObject1).setVisibility(0);
          localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
          localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
          ((ObjectAnimator)localObject1).setDuration(1800L);
          ((ObjectAnimator)localObject1).setRepeatCount(-1);
          ((ObjectAnimator)localObject1).setRepeatMode(1);
          ((ObjectAnimator)localObject1).setStartDelay(100L);
          ((ObjectAnimator)localObject2).setDuration(1800L);
          ((ObjectAnimator)localObject2).setRepeatCount(-1);
          ((ObjectAnimator)localObject2).setRepeatMode(1);
          ((ObjectAnimator)localObject2).setStartDelay(240L);
          AnimatorSet localAnimatorSet = new AnimatorSet();
          localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
          localAnimatorSet.start();
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.a())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        try
        {
          localObject1 = new URL(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setImage((URL)localObject1);
          if (((IImageManager)QRoute.api(IImageManager.class)).isLocalFileExist((URL)localObject1))
          {
            this.jdField_c_of_type_Int = 2;
          }
          else
          {
            this.jdField_c_of_type_Int = 1;
            this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener = new ReadInJoyNativeAdFragment.2(this);
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setPublicAccountImageDownListener(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(this);
      }
      AppNetConnInfo.registerConnectionChangeReceiver(getBaseActivity(), this);
    }
  }
  
  private void c()
  {
    if (this.jdField_c_of_type_Int == 3)
    {
      Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
      if ((localObject != null) && (!TextUtils.isEmpty(((BannerInfo)localObject).jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNativeAdFragment", 2, "retry download icon");
        }
        try
        {
          localObject = new URL(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView.setImage((URL)localObject);
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet == null)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(getBaseActivity(), null));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131717956, 5);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addButton(2131717958, 5);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.addCancelButton(2131690728);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(new ReadInJoyNativeAdFragment.3(this));
      this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnButtonClickListener(new ReadInJoyNativeAdFragment.4(this));
    }
    if (!this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
    {
      QQToast.a(getBaseActivity(), 1, getString(2131717855), 0).b(0);
      return;
    }
    if (NetworkUtil.isWifiConnected(getBaseActivity()))
    {
      f();
      return;
    }
    g();
  }
  
  private void f()
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).downloadApk(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo, this);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717955));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839314);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    this.jdField_b_of_type_Int = 3;
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 2, 0);
  }
  
  private void g()
  {
    if (!getBaseActivity().isFinishing())
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).createDialog(getBaseActivity(), null, getString(2131717963), new ReadInJoyNativeAdFragment.9(this), getString(2131717964), new ReadInJoyNativeAdFragment.10(this), getString(2131717965));
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private void h()
  {
    if (this.jdField_b_of_type_Int == 3)
    {
      DownloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d);
      QQToast.a(getBaseActivity(), 1, getString(2131717966), 0).b(0);
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.11(this));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(2130772006, 0);
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364705)
    {
      if (i != 2131366744)
      {
        if (i != 2131373137) {
          return;
        }
        paramView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
        if (paramView != null)
        {
          if (paramView.jdField_b_of_type_Int == 2)
          {
            paramView = new Intent(getBaseActivity(), QQBrowserActivity.class);
            paramView.putExtra("url", this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_c_of_type_JavaLangString);
            startActivity(paramView);
            ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 3, 0);
            return;
          }
          if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 1)
          {
            i = this.jdField_b_of_type_Int;
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2) {
                  return;
                }
                ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).installApk(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo);
                ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
                return;
              }
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launchApp(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f);
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 1, 0);
              return;
            }
            e();
          }
        }
      }
      else
      {
        d();
      }
    }
    else {
      getBaseActivity().doOnBackPressed();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560238, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(getBaseActivity()).inflate(2131560237, null);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12, -1);
    ((ViewGroup)paramLayoutInflater).addView(paramViewGroup, paramBundle);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getBaseActivity().app != null)
    {
      localObject = (NativeAdPreloadManager)getBaseActivity().app.getManager(QQManagerFactory.KANDIAN_NATIVE_AD_PRELOAD_MANAGER);
      if (localObject != null) {
        ((NativeAdPreloadManager)localObject).a();
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
    if ((localObject != null) && (((BannerInfo)localObject).jdField_b_of_type_Int == 1)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int == 1)
      {
        DownloadManager.a().b(this);
        AppNetConnInfo.unregisterNetInfoHandler(this);
        if (this.jdField_b_of_type_Int == 3) {
          DownloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d);
        }
      }
      else if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_a_of_type_Int == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter.a();
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgDownloading(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo) >= 0) {
          DownloadManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.d);
        }
      }
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 4, 1, this.d);
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.6(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.8(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.5(this));
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, 3, 4, 0);
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
        ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.7(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void onFinish()
  {
    getBaseActivity().overridePendingTransition(0, 2130772003);
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetMobile2None");
    }
    h();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetNone2Mobile");
    }
    h();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetWifi2Mobile");
    }
    h();
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetWifi2None");
    }
    h();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo;
    if ((localObject != null) && (((BannerInfo)localObject).jdField_a_of_type_Int == 1)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 2) {
        this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717969));
      } else if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.jdField_b_of_type_Int == 1) {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717967));
          this.jdField_b_of_type_Int = 1;
        }
        else if (ADBaseAppDownloadManager.a(getBaseActivity(), this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo.f))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717960));
          this.jdField_b_of_type_Int = 2;
        }
        else if (this.jdField_b_of_type_Int != 3)
        {
          this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setText(getText(2131717954));
          this.jdField_b_of_type_Int = 0;
        }
      }
    }
    localObject = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
    if (localObject != null) {}
    try
    {
      int i = ((ViewPager)localObject).getCurrentItem();
      ((AdModuleBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a();
      i += 1;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size()) {
        ((AdModuleBase)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)localViewGroup.findViewById(2131371431));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter = new AdModuleAdapter(getBaseActivity(), this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountNativeAdDataBannerInfo, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(new ReadInJoyNativeAdFragment.1(this));
    localViewGroup.findViewById(2131364705).setOnClickListener(this);
    localViewGroup.findViewById(2131366744).setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localViewGroup.findViewById(2131378747));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localViewGroup.findViewById(2131365830));
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetResizeURLImageView = ((ResizeURLImageView)localViewGroup.findViewById(2131365842));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localViewGroup.findViewById(2131365837));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131373137));
    this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(getResources().getColor(2131165349));
    b();
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment
 * JD-Core Version:    0.7.0.1
 */