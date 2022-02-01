package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler.Options;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivityReverseLandscapeForTool;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public final class GdtInterstitialFragment
  extends QPublicBaseFragment
{
  private static Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private GdtInterstitialParams jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  private GdtInterstitialStatus jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus = new GdtInterstitialStatus();
  private GdtInterstitialView jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  
  public static int a(Activity paramActivity, GdtInterstitialParams paramGdtInterstitialParams)
  {
    Object localObject;
    int i;
    if ((Looper.myLooper() == Looper.getMainLooper()) && (paramActivity != null) && (paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.b()))
    {
      localObject = null;
      if (paramGdtInterstitialParams.jdField_a_of_type_Int == 1) {
        localObject = QPublicTransFragmentActivityForTool.class;
      } else if (paramGdtInterstitialParams.jdField_a_of_type_Int == 0) {
        localObject = QPublicTransFragmentActivityLandscapeForTool.class;
      } else if (paramGdtInterstitialParams.jdField_a_of_type_Int == 8) {
        localObject = QPublicTransFragmentActivityReverseLandscapeForTool.class;
      }
      if (localObject != null) {}
    }
    else
    {
      i = 4;
      break label217;
    }
    if (jdField_a_of_type_JavaUtilSet.contains(paramGdtInterstitialParams.a()))
    {
      i = 2;
    }
    else
    {
      jdField_a_of_type_JavaUtilSet.add(paramGdtInterstitialParams.a());
      Bundle localBundle = new Bundle();
      if ((paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle != null) && (!paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle.isEmpty())) {
        localBundle.putAll(paramGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle);
      }
      localBundle.putParcelable("interstitialParams", paramGdtInterstitialParams);
      localBundle.putLong("interstitialStartToShowTimeMillis", System.currentTimeMillis());
      paramGdtInterstitialParams = new Intent();
      paramGdtInterstitialParams.putExtra("public_fragment_window_feature", 1);
      paramGdtInterstitialParams.putExtras(localBundle);
      QPublicFragmentActivity.Launcher.a(paramActivity, paramGdtInterstitialParams, (Class)localObject, GdtInterstitialFragment.class, 10001);
      i = 0;
    }
    label217:
    GdtLog.b("GdtInterstitialFragment", String.format("start errorCode:%d", new Object[] { Integer.valueOf(i) }));
    return i;
  }
  
  private String a()
  {
    GdtInterstitialParams localGdtInterstitialParams = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
    if ((localGdtInterstitialParams != null) && (localGdtInterstitialParams.b())) {
      return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.a();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    GdtLog.b("GdtInterstitialFragment", String.format("setLoading visible:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    QQProgressDialog localQQProgressDialog;
    if (paramBoolean)
    {
      localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(getActivity(), getResources().getDimensionPixelSize(2131299168));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("正在加载");
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      return;
    }
    if (!paramBoolean)
    {
      localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
      if (localQQProgressDialog != null)
      {
        if (localQQProgressDialog.isShowing()) {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
          }
          catch (Throwable localThrowable)
          {
            GdtLog.d("GdtInterstitialFragment", "setLoading", localThrowable);
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
    if (localObject != null)
    {
      if (!((GdtInterstitialParams)localObject).b()) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(getContext(), (GdtAd)localObject);
    }
  }
  
  GdtInterstitialParams a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
  }
  
  GdtInterstitialStatus a()
  {
    return this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      GdtLog.d("GdtInterstitialFragment", "onLoaded error");
      return;
    }
    GdtInterstitialStatus localGdtInterstitialStatus = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
    localGdtInterstitialStatus.jdField_e_of_type_Boolean = true;
    if (localGdtInterstitialStatus.jdField_a_of_type_Int == 2) {
      GdtInterstitialNotifyReg.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    }
    a(false);
    GdtLog.b("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", new Object[] { Long.valueOf(this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.a()) }));
    GdtAnalysisHelperForInterstitial.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_f_of_type_Int = paramInt;
  }
  
  boolean a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Object localObject = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams;
      if ((localObject != null) && (((GdtInterstitialParams)localObject).b()))
      {
        localObject = new GdtHandler.Params();
        ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(getActivity());
        ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(GdtInterstitialManager.a().a());
        ((GdtHandler.Params)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
        ((GdtHandler.Params)localObject).jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Boolean;
        ((GdtHandler.Params)localObject).jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Int;
        ((GdtHandler.Params)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_b_of_type_Int;
        ((GdtHandler.Params)localObject).jdField_b_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_b_of_type_Boolean;
        ((GdtHandler.Params)localObject).c = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.c;
        ((GdtHandler.Params)localObject).d = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.d;
        ((GdtHandler.Params)localObject).jdField_e_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_e_of_type_Boolean;
        ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidGraphicsRect = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidGraphicsRect;
        ((GdtHandler.Params)localObject).jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_Long;
        ((GdtHandler.Params)localObject).jdField_f_of_type_Boolean = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_f_of_type_Boolean;
        ((GdtHandler.Params)localObject).g = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.g;
        ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_JavaLangString;
        ((GdtHandler.Params)localObject).jdField_a_of_type_OrgJsonJSONObject = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_OrgJsonJSONObject;
        ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options.jdField_a_of_type_AndroidOsBundle;
        ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).handleGdtAdClick((GdtHandler.Params)localObject);
        bool = true;
        break label302;
      }
    }
    boolean bool = false;
    label302:
    GdtLog.b("GdtInterstitialFragment", String.format("onClick %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(false);
      GdtInterstitialStatus localGdtInterstitialStatus = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
      localGdtInterstitialStatus.jdField_b_of_type_Int = paramInt1;
      localGdtInterstitialStatus.c = paramInt2;
      localGdtInterstitialStatus.d = paramInt3;
      localGdtInterstitialStatus.jdField_e_of_type_Int = paramInt4;
      if (getActivity() != null) {}
    }
    else
    {
      bool = false;
      break label86;
    }
    getActivity().finish();
    GdtAnalysisHelperForInterstitial.d(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    boolean bool = true;
    label86:
    GdtLog.b("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    return bool;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_f_of_type_Boolean) {
      return;
    }
    GdtInterstitialStatus localGdtInterstitialStatus = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus;
    localGdtInterstitialStatus.jdField_f_of_type_Boolean = true;
    GdtLog.b("GdtInterstitialFragment", String.format("onImpression timeMillis:%d", new Object[] { Long.valueOf(localGdtInterstitialStatus.a()) }));
    GdtAnalysisHelperForInterstitial.c(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
  }
  
  public void beforeFinish()
  {
    GdtLog.b("GdtInterstitialFragment", "beforeFinish");
    Object localObject = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialView;
    if (localObject != null) {
      ((GdtInterstitialView)localObject).c(getActivity());
    }
    GdtInterstitialManager.a().a(a());
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("interstitialStatus", this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    Intent localIntent = new Intent();
    localIntent.putExtras((Bundle)localObject);
    getActivity().setResult(-1, localIntent);
    super.beforeFinish();
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    if ((paramActivity != null) && (Build.VERSION.SDK_INT >= 5)) {
      paramActivity.overridePendingTransition(0, 0);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    return true;
  }
  
  /* Error */
  public android.view.View onCreateView(android.view.LayoutInflater paramLayoutInflater, android.view.ViewGroup paramViewGroup, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 27	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;
    //   4: astore_1
    //   5: invokestatic 395	com/tencent/gdtad/api/interstitial/GdtInterstitialPreDownloader:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialPreDownloader;
    //   8: invokevirtual 398	com/tencent/gdtad/api/interstitial/GdtInterstitialPreDownloader:a	()I
    //   11: iconst_3
    //   12: if_icmpne +9 -> 21
    //   15: iconst_1
    //   16: istore 6
    //   18: goto +6 -> 24
    //   21: iconst_0
    //   22: istore 6
    //   24: aload_1
    //   25: iload 6
    //   27: putfield 399	com/tencent/gdtad/api/interstitial/GdtInterstitialStatus:jdField_a_of_type_Boolean	Z
    //   30: iconst_4
    //   31: istore 4
    //   33: new 401	android/widget/FrameLayout
    //   36: dup
    //   37: aload_0
    //   38: invokevirtual 166	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   41: invokespecial 403	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   44: astore_1
    //   45: iload 4
    //   47: istore 5
    //   49: aload_0
    //   50: iconst_1
    //   51: invokespecial 238	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:a	(Z)V
    //   54: iload 4
    //   56: istore 5
    //   58: getstatic 409	com/tencent/ad/tangram/thread/AdThreadManager:INSTANCE	Lcom/tencent/ad/tangram/thread/AdThreadManager;
    //   61: new 411	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$1
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 414	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$1:<init>	(Lcom/tencent/gdtad/api/interstitial/GdtInterstitialFragment;)V
    //   69: iconst_0
    //   70: ldc2_w 415
    //   73: invokevirtual 420	com/tencent/ad/tangram/thread/AdThreadManager:postDelayed	(Ljava/lang/Runnable;IJ)Z
    //   76: pop
    //   77: iload 4
    //   79: istore 5
    //   81: invokestatic 424	com/tencent/gdtad/api/interstitial/GdtArkUtil:a	()V
    //   84: iload 4
    //   86: istore 5
    //   88: ldc_w 426
    //   91: invokestatic 212	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   94: checkcast 426	com/tencent/mobileqq/ark/api/IArkAPIService
    //   97: invokestatic 271	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialManager;
    //   100: invokevirtual 429	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtArkApp;
    //   103: getfield 432	com/tencent/gdtad/api/interstitial/GdtArkApp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokestatic 271	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialManager;
    //   109: invokevirtual 435	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialNotifyReg;
    //   112: invokeinterface 439 3 0
    //   117: iload 4
    //   119: istore 5
    //   121: aload_0
    //   122: invokevirtual 443	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   125: ifnonnull +6 -> 131
    //   128: goto +336 -> 464
    //   131: iload 4
    //   133: istore 5
    //   135: aload_0
    //   136: invokevirtual 443	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   139: ldc 84
    //   141: invokevirtual 446	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   144: ifne +6 -> 150
    //   147: goto +317 -> 464
    //   150: iload 4
    //   152: istore 5
    //   154: aload_0
    //   155: aload_0
    //   156: invokevirtual 443	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   159: ldc 84
    //   161: invokevirtual 450	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   164: checkcast 39	com/tencent/gdtad/api/interstitial/GdtInterstitialParams
    //   167: putfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   170: iload 4
    //   172: istore 5
    //   174: aload_0
    //   175: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   178: ifnonnull +6 -> 184
    //   181: goto +283 -> 464
    //   184: iload 4
    //   186: istore 5
    //   188: aload_0
    //   189: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   192: invokevirtual 43	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:b	()Z
    //   195: ifne +6 -> 201
    //   198: goto +266 -> 464
    //   201: iload 4
    //   203: istore 5
    //   205: aload_0
    //   206: invokespecial 358	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:a	()Ljava/lang/String;
    //   209: invokestatic 455	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifeq +6 -> 218
    //   215: goto +249 -> 464
    //   218: iload 4
    //   220: istore 5
    //   222: aload_0
    //   223: invokevirtual 443	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   226: ldc 90
    //   228: invokevirtual 446	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   231: ifne +6 -> 237
    //   234: goto +230 -> 464
    //   237: iload 4
    //   239: istore 5
    //   241: aload_0
    //   242: getfield 27	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;
    //   245: aload_0
    //   246: invokevirtual 443	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   249: ldc 90
    //   251: invokevirtual 459	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   254: putfield 460	com/tencent/gdtad/api/interstitial/GdtInterstitialStatus:jdField_a_of_type_Long	J
    //   257: invokestatic 271	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialManager;
    //   260: aload_0
    //   261: invokespecial 358	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:a	()Ljava/lang/String;
    //   264: new 260	java/lang/ref/WeakReference
    //   267: dup
    //   268: aload_0
    //   269: invokespecial 263	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   272: invokevirtual 463	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	(Ljava/lang/String;Ljava/lang/ref/WeakReference;)Z
    //   275: ifne +6 -> 281
    //   278: goto +183 -> 461
    //   281: aload_0
    //   282: invokevirtual 166	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   285: ifnonnull +6 -> 291
    //   288: goto +173 -> 461
    //   291: aload_0
    //   292: invokevirtual 166	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   295: aload_0
    //   296: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   299: getfield 46	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:jdField_a_of_type_Int	I
    //   302: invokevirtual 466	androidx/fragment/app/FragmentActivity:setRequestedOrientation	(I)V
    //   305: aload_0
    //   306: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   309: aload_0
    //   310: invokevirtual 166	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   313: invokestatic 471	com/tencent/gdtad/views/GdtUIUtils:b	(Landroid/content/Context;)I
    //   316: putfield 472	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:jdField_b_of_type_Int	I
    //   319: aload_0
    //   320: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   323: aload_0
    //   324: invokevirtual 166	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   327: invokestatic 474	com/tencent/gdtad/views/GdtUIUtils:c	(Landroid/content/Context;)I
    //   330: putfield 475	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:c	I
    //   333: aload_0
    //   334: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   337: getfield 472	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:jdField_b_of_type_Int	I
    //   340: ifle +121 -> 461
    //   343: aload_0
    //   344: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   347: getfield 475	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:c	I
    //   350: ifgt +6 -> 356
    //   353: goto +108 -> 461
    //   356: aload_0
    //   357: new 354	com/tencent/gdtad/api/interstitial/GdtInterstitialView
    //   360: dup
    //   361: aload_0
    //   362: invokevirtual 166	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   365: aload_0
    //   366: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   369: aload_0
    //   370: getfield 27	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;
    //   373: invokespecial 477	com/tencent/gdtad/api/interstitial/GdtInterstitialView:<init>	(Landroid/content/Context;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;)V
    //   376: putfield 352	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialView	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialView;
    //   379: aload_0
    //   380: getfield 352	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialView	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialView;
    //   383: invokevirtual 480	com/tencent/gdtad/api/interstitial/GdtInterstitialView:a	()Landroid/view/View;
    //   386: ifnonnull +6 -> 392
    //   389: goto +72 -> 461
    //   392: new 482	android/widget/FrameLayout$LayoutParams
    //   395: dup
    //   396: aload_0
    //   397: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   400: getfield 472	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:jdField_b_of_type_Int	I
    //   403: aload_0
    //   404: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   407: getfield 475	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:c	I
    //   410: invokespecial 484	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   413: astore_2
    //   414: aload_2
    //   415: bipush 17
    //   417: putfield 487	android/widget/FrameLayout$LayoutParams:gravity	I
    //   420: aload_1
    //   421: aload_0
    //   422: getfield 352	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialView	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialView;
    //   425: invokevirtual 480	com/tencent/gdtad/api/interstitial/GdtInterstitialView:a	()Landroid/view/View;
    //   428: aload_2
    //   429: invokevirtual 491	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   432: aload_0
    //   433: getfield 144	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   436: getfield 492	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:jdField_a_of_type_Boolean	Z
    //   439: ifne +16 -> 455
    //   442: aload_0
    //   443: invokevirtual 166	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   446: invokevirtual 496	androidx/fragment/app/FragmentActivity:getWindow	()Landroid/view/Window;
    //   449: sipush 1024
    //   452: invokevirtual 501	android/view/Window:addFlags	(I)V
    //   455: iconst_0
    //   456: istore 4
    //   458: goto +6 -> 464
    //   461: iconst_1
    //   462: istore 4
    //   464: iload 4
    //   466: istore 5
    //   468: ldc 120
    //   470: ldc_w 503
    //   473: iconst_1
    //   474: anewarray 124	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_0
    //   480: invokespecial 358	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:a	()Ljava/lang/String;
    //   483: aastore
    //   484: invokestatic 136	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   487: invokestatic 141	com/tencent/gdtad/log/GdtLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: goto +30 -> 520
    //   493: astore_2
    //   494: iconst_1
    //   495: istore 4
    //   497: goto +14 -> 511
    //   500: astore_2
    //   501: iload 5
    //   503: istore 4
    //   505: goto +6 -> 511
    //   508: astore_2
    //   509: aconst_null
    //   510: astore_1
    //   511: ldc 120
    //   513: ldc_w 504
    //   516: aload_2
    //   517: invokestatic 200	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   520: aload_0
    //   521: invokespecial 506	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:c	()V
    //   524: getstatic 409	com/tencent/ad/tangram/thread/AdThreadManager:INSTANCE	Lcom/tencent/ad/tangram/thread/AdThreadManager;
    //   527: new 508	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$2
    //   530: dup
    //   531: aload_0
    //   532: iload 4
    //   534: invokespecial 511	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$2:<init>	(Lcom/tencent/gdtad/api/interstitial/GdtInterstitialFragment;I)V
    //   537: iconst_5
    //   538: invokevirtual 515	com/tencent/ad/tangram/thread/AdThreadManager:post	(Ljava/lang/Runnable;I)Z
    //   541: pop
    //   542: aload_0
    //   543: aload_1
    //   544: invokestatic 521	com/tencent/qqlive/module/videoreport/inject/fragment/AndroidXFragmentCollector:onAndroidXFragmentViewCreated	(Landroidx/fragment/app/Fragment;Landroid/view/View;)V
    //   547: aload_1
    //   548: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	549	0	this	GdtInterstitialFragment
    //   0	549	1	paramLayoutInflater	android.view.LayoutInflater
    //   0	549	2	paramViewGroup	android.view.ViewGroup
    //   0	549	3	paramBundle	Bundle
    //   31	502	4	i	int
    //   47	455	5	j	int
    //   16	10	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   257	278	493	java/lang/Throwable
    //   281	288	493	java/lang/Throwable
    //   291	353	493	java/lang/Throwable
    //   356	389	493	java/lang/Throwable
    //   392	455	493	java/lang/Throwable
    //   49	54	500	java/lang/Throwable
    //   58	77	500	java/lang/Throwable
    //   81	84	500	java/lang/Throwable
    //   88	117	500	java/lang/Throwable
    //   121	128	500	java/lang/Throwable
    //   135	147	500	java/lang/Throwable
    //   154	170	500	java/lang/Throwable
    //   174	181	500	java/lang/Throwable
    //   188	198	500	java/lang/Throwable
    //   205	215	500	java/lang/Throwable
    //   222	234	500	java/lang/Throwable
    //   241	257	500	java/lang/Throwable
    //   468	490	500	java/lang/Throwable
    //   33	45	508	java/lang/Throwable
  }
  
  public void onFinish()
  {
    GdtLog.b("GdtInterstitialFragment", "onFinish");
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (Build.VERSION.SDK_INT >= 5)) {
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onPause()
  {
    GdtLog.b("GdtInterstitialFragment", "onPause");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 3;
    GdtInterstitialView localGdtInterstitialView = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialView;
    if (localGdtInterstitialView != null) {
      localGdtInterstitialView.a(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean) {
      GdtInterstitialNotifyReg.b(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    GdtLog.b("GdtInterstitialFragment", "onResume");
    this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_a_of_type_Int = 2;
    GdtInterstitialView localGdtInterstitialView = this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialView;
    if (localGdtInterstitialView != null) {
      localGdtInterstitialView.b(getActivity());
    }
    if (this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus.jdField_e_of_type_Boolean)
    {
      a(false);
      GdtInterstitialNotifyReg.a(getActivity(), this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialParams, this.jdField_a_of_type_ComTencentGdtadApiInterstitialGdtInterstitialStatus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment
 * JD-Core Version:    0.7.0.1
 */