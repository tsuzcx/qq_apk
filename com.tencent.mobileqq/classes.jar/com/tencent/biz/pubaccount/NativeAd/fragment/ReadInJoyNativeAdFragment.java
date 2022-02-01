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
  private ViewPager a;
  private AdModuleAdapter b;
  private LinearLayout c;
  private RelativeLayout d;
  private ResizeURLImageView e;
  private TextView f;
  private AdProgressButton g;
  private Dialog h;
  private ActionSheet i;
  private boolean j;
  private String k;
  private String l;
  private String m;
  private BannerInfo n;
  private ArrayList<AdModuleBase> o;
  private int p;
  private int q;
  private IPublicAccountImageDownListener r = null;
  private int s;
  private int t = 1;
  
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
      int i1;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        this.k = ((JSONObject)localObject1).optString("adId");
        this.l = ((JSONObject)localObject1).optString("channelId");
        this.m = ((JSONObject)localObject1).optString("info");
        this.p = ((JSONObject)localObject1).optInt("upslideType");
        this.n = BannerInfo.a(((JSONObject)localObject1).optString("bannerInfo"));
        this.o = new ArrayList();
        localObject1 = ((JSONObject)localObject1).optJSONArray("pageInfoList");
        i1 = 0;
        if (i1 < ((JSONArray)localObject1).length())
        {
          localObject2 = AdModuleBase.a(getBaseActivity().app, ((JSONArray)localObject1).getJSONObject(i1));
          if (localObject2 != null) {
            this.o.add(localObject2);
          }
        }
        else
        {
          if (this.o.size() <= 0) {
            getBaseActivity().finish();
          }
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.k, this.l, this.m, 1, 1, 0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        getBaseActivity().finish();
        return;
      }
      i1 += 1;
    }
  }
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo != null) && (this.n != null) && (!TextUtils.isEmpty(paramDownloadInfo.e)) && (!TextUtils.isEmpty(paramDownloadInfo.c)) && (!TextUtils.isEmpty(this.n.h)))
    {
      if (TextUtils.isEmpty(this.n.f)) {
        return false;
      }
      if ((paramDownloadInfo.e.equals(this.n.h)) && (paramDownloadInfo.c.equals(this.n.f))) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    Object localObject1 = this.n;
    if ((localObject1 != null) && (((BannerInfo)localObject1).a == 1))
    {
      if (this.o.size() > 1)
      {
        int i1 = this.p;
        if ((i1 == 1) || (i1 == 2))
        {
          this.c.setVisibility(0);
          if (this.p == 1) {
            this.c.findViewById(2131447423).setVisibility(8);
          }
          Object localObject2 = this.c.findViewById(2131449242);
          localObject1 = this.c.findViewById(2131449243);
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
      if (this.n.a())
      {
        this.d.setVisibility(0);
        try
        {
          localObject1 = new URL(this.n.b);
          this.e.setImage((URL)localObject1);
          if (((IImageManager)QRoute.api(IImageManager.class)).isLocalFileExist((URL)localObject1))
          {
            this.s = 2;
          }
          else
          {
            this.s = 1;
            this.r = new ReadInJoyNativeAdFragment.2(this);
            this.e.setPublicAccountImageDownListener(this.r);
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        this.f.setText(this.n.c);
        this.g.setOnClickListener(this);
      }
      AppNetConnInfo.registerConnectionChangeReceiver(getBaseActivity(), this);
    }
  }
  
  private void c()
  {
    if (this.s == 3)
    {
      Object localObject = this.n;
      if ((localObject != null) && (!TextUtils.isEmpty(((BannerInfo)localObject).b)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNativeAdFragment", 2, "retry download icon");
        }
        try
        {
          localObject = new URL(this.n.b);
          this.e.setImage((URL)localObject);
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
    if (this.i == null)
    {
      this.i = ((ActionSheet)ActionSheetHelper.b(getBaseActivity(), null));
      this.i.addButton(2131915436, 5);
      this.i.addButton(2131915438, 5);
      this.i.addCancelButton(2131887648);
      this.i.setOnDismissListener(new ReadInJoyNativeAdFragment.3(this));
      this.i.setOnButtonClickListener(new ReadInJoyNativeAdFragment.4(this));
    }
    if (!this.i.isShowing())
    {
      this.j = false;
      this.i.show();
    }
  }
  
  private void e()
  {
    if (!NetworkUtil.isNetworkAvailable(getBaseActivity()))
    {
      QQToast.makeText(getBaseActivity(), 1, getString(2131915328), 0).show(0);
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
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).downloadApk(getBaseActivity(), this.n, this);
    this.g.setText(getText(2131915435));
    this.g.setTextColor(-16777216);
    this.g.setBackgroundResource(2130839494);
    this.g.setProgress(0);
    this.g.setClickable(false);
    this.q = 3;
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.k, this.l, this.m, 3, 2, 0);
  }
  
  private void g()
  {
    if (!getBaseActivity().isFinishing())
    {
      if (this.h == null)
      {
        this.h = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).createDialog(getBaseActivity(), null, getString(2131915443), new ReadInJoyNativeAdFragment.9(this), getString(2131915444), new ReadInJoyNativeAdFragment.10(this), getString(2131915445));
        this.h.setCanceledOnTouchOutside(false);
      }
      this.h.show();
    }
  }
  
  private void h()
  {
    if (this.q == 3)
    {
      DownloadManager.b().g(this.n.f);
      QQToast.makeText(getBaseActivity(), 1, getString(2131915446), 0).show(0);
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.11(this));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(2130772009, 0);
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
    int i1 = paramView.getId();
    if (i1 != 2131430808)
    {
      if (i1 != 2131433066)
      {
        if (i1 != 2131440742) {
          return;
        }
        paramView = this.n;
        if (paramView != null)
        {
          if (paramView.d == 2)
          {
            paramView = new Intent(getBaseActivity(), QQBrowserActivity.class);
            paramView.putExtra("url", this.n.e);
            startActivity(paramView);
            ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.k, this.l, this.m, 3, 3, 0);
            return;
          }
          if (this.n.d == 1)
          {
            i1 = this.q;
            if (i1 != 0)
            {
              if (i1 != 1)
              {
                if (i1 != 2) {
                  return;
                }
                ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).installApk(this.n);
                ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.k, this.l, this.m, 3, 4, 0);
                return;
              }
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).launchApp(getBaseActivity(), this.n.h);
              ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.k, this.l, this.m, 3, 1, 0);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131626285, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(getBaseActivity()).inflate(2131626284, null);
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
    Object localObject = this.n;
    if ((localObject != null) && (((BannerInfo)localObject).d == 1)) {
      if (this.n.a == 1)
      {
        DownloadManager.b().b(this);
        AppNetConnInfo.unregisterNetInfoHandler(this);
        if (this.q == 3) {
          DownloadManager.b().g(this.n.f);
        }
      }
      else if (this.n.a == 2)
      {
        this.b.a();
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgDownloading(getBaseActivity(), this.n) >= 0) {
          DownloadManager.b().g(this.n.f);
        }
      }
    }
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.k, this.l, this.m, 4, 1, this.t);
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
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(getBaseActivity().app, this.k, this.l, this.m, 3, 4, 0);
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
    getBaseActivity().overridePendingTransition(0, 2130772006);
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
    Object localObject = this.n;
    if ((localObject != null) && (((BannerInfo)localObject).a == 1)) {
      if (this.n.d == 2) {
        this.g.setText(getText(2131915449));
      } else if (this.n.d == 1) {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(getBaseActivity(), this.n.h))
        {
          this.g.setText(getText(2131915447));
          this.q = 1;
        }
        else if (ADBaseAppDownloadManager.a(getBaseActivity(), this.n.h))
        {
          this.g.setText(getText(2131915440));
          this.q = 2;
        }
        else if (this.q != 3)
        {
          this.g.setText(getText(2131915434));
          this.q = 0;
        }
      }
    }
    localObject = this.a;
    if (localObject != null) {}
    try
    {
      int i1 = ((ViewPager)localObject).getCurrentItem();
      ((AdModuleBase)this.o.get(i1)).a();
      i1 += 1;
      if (i1 < this.o.size()) {
        ((AdModuleBase)this.o.get(i1)).b();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.a = ((ViewPager)localViewGroup.findViewById(2131438798));
    this.b = new AdModuleAdapter(getBaseActivity(), this.k, this.l, this.m, this.p, this.n, this.o);
    this.a.setAdapter(this.b);
    this.a.setOnPageChangeListener(new ReadInJoyNativeAdFragment.1(this));
    localViewGroup.findViewById(2131430808).setOnClickListener(this);
    localViewGroup.findViewById(2131433066).setOnClickListener(this);
    this.c = ((LinearLayout)localViewGroup.findViewById(2131447421));
    this.d = ((RelativeLayout)localViewGroup.findViewById(2131432088));
    this.e = ((ResizeURLImageView)localViewGroup.findViewById(2131432100));
    this.f = ((TextView)localViewGroup.findViewById(2131432095));
    this.g = ((AdProgressButton)localViewGroup.findViewById(2131440742));
    this.g.setProgressColor(getResources().getColor(2131165591));
    b();
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment
 * JD-Core Version:    0.7.0.1
 */