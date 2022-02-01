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
  private static Set<String> a = new HashSet();
  private GdtInterstitialParams b;
  private GdtInterstitialStatus c = new GdtInterstitialStatus();
  private GdtInterstitialView d;
  private QQProgressDialog e;
  
  public static int a(Activity paramActivity, GdtInterstitialParams paramGdtInterstitialParams)
  {
    Object localObject;
    int i;
    if ((Looper.myLooper() == Looper.getMainLooper()) && (paramActivity != null) && (paramGdtInterstitialParams != null) && (paramGdtInterstitialParams.b()))
    {
      localObject = null;
      if (paramGdtInterstitialParams.e == 1) {
        localObject = QPublicTransFragmentActivityForTool.class;
      } else if (paramGdtInterstitialParams.e == 0) {
        localObject = QPublicTransFragmentActivityLandscapeForTool.class;
      } else if (paramGdtInterstitialParams.e == 8) {
        localObject = QPublicTransFragmentActivityReverseLandscapeForTool.class;
      }
      if (localObject != null) {}
    }
    else
    {
      i = 4;
      break label217;
    }
    if (a.contains(paramGdtInterstitialParams.c()))
    {
      i = 2;
    }
    else
    {
      a.add(paramGdtInterstitialParams.c());
      Bundle localBundle = new Bundle();
      if ((paramGdtInterstitialParams.d.p != null) && (!paramGdtInterstitialParams.d.p.isEmpty())) {
        localBundle.putAll(paramGdtInterstitialParams.d.p);
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
  
  private void a(boolean paramBoolean)
  {
    GdtLog.b("GdtInterstitialFragment", String.format("setLoading visible:%b", new Object[] { Boolean.valueOf(paramBoolean) }));
    QQProgressDialog localQQProgressDialog;
    if (paramBoolean)
    {
      localQQProgressDialog = this.e;
      if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
        return;
      }
      this.e = new QQProgressDialog(getActivity(), getResources().getDimensionPixelSize(2131299920));
      this.e.setCancelable(false);
      this.e.a("正在加载");
      this.e.show();
      return;
    }
    if (!paramBoolean)
    {
      localQQProgressDialog = this.e;
      if (localQQProgressDialog != null)
      {
        if (localQQProgressDialog.isShowing()) {
          try
          {
            this.e.dismiss();
          }
          catch (Throwable localThrowable)
          {
            GdtLog.d("GdtInterstitialFragment", "setLoading", localThrowable);
          }
        }
        this.e = null;
      }
    }
  }
  
  private void f()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (!((GdtInterstitialParams)localObject).b()) {
        return;
      }
      localObject = this.b.d.a;
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(getContext(), (GdtAd)localObject);
    }
  }
  
  private String g()
  {
    GdtInterstitialParams localGdtInterstitialParams = this.b;
    if ((localGdtInterstitialParams != null) && (localGdtInterstitialParams.b())) {
      return this.b.c();
    }
    return null;
  }
  
  void a()
  {
    if (this.c.f)
    {
      GdtLog.d("GdtInterstitialFragment", "onLoaded error");
      return;
    }
    GdtInterstitialStatus localGdtInterstitialStatus = this.c;
    localGdtInterstitialStatus.f = true;
    if (localGdtInterstitialStatus.a == 2) {
      GdtInterstitialNotifyReg.a(getActivity(), this.b, this.c);
    }
    a(false);
    GdtLog.b("GdtInterstitialFragment", String.format("onLoaded timeMillis:%d", new Object[] { Long.valueOf(this.c.a()) }));
    GdtAnalysisHelperForInterstitial.b(getActivity(), this.b, this.c);
  }
  
  void a(int paramInt)
  {
    this.c.l = paramInt;
  }
  
  boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(false);
      GdtInterstitialStatus localGdtInterstitialStatus = this.c;
      localGdtInterstitialStatus.h = paramInt1;
      localGdtInterstitialStatus.i = paramInt2;
      localGdtInterstitialStatus.j = paramInt3;
      localGdtInterstitialStatus.k = paramInt4;
      if (getActivity() != null) {}
    }
    else
    {
      bool = false;
      break label86;
    }
    getActivity().finish();
    GdtAnalysisHelperForInterstitial.d(getActivity(), this.b, this.c);
    boolean bool = true;
    label86:
    GdtLog.b("GdtInterstitialFragment", String.format("finish %b error:%d arkError:%d arkScriptError:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
    return bool;
  }
  
  void b()
  {
    if (this.c.g) {
      return;
    }
    GdtInterstitialStatus localGdtInterstitialStatus = this.c;
    localGdtInterstitialStatus.g = true;
    GdtLog.b("GdtInterstitialFragment", String.format("onImpression timeMillis:%d", new Object[] { Long.valueOf(localGdtInterstitialStatus.a()) }));
    GdtAnalysisHelperForInterstitial.c(getActivity(), this.b, this.c);
  }
  
  public void beforeFinish()
  {
    GdtLog.b("GdtInterstitialFragment", "beforeFinish");
    Object localObject = this.d;
    if (localObject != null) {
      ((GdtInterstitialView)localObject).c(getActivity());
    }
    GdtInterstitialManager.a().b(g());
    localObject = new Bundle();
    ((Bundle)localObject).putParcelable("interstitialStatus", this.c);
    Intent localIntent = new Intent();
    localIntent.putExtras((Bundle)localObject);
    getActivity().setResult(-1, localIntent);
    super.beforeFinish();
  }
  
  boolean c()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      Object localObject = this.b;
      if ((localObject != null) && (((GdtInterstitialParams)localObject).b()))
      {
        localObject = new GdtHandler.Params();
        ((GdtHandler.Params)localObject).r = new WeakReference(getActivity());
        ((GdtHandler.Params)localObject).s = new WeakReference(GdtInterstitialManager.a().c());
        ((GdtHandler.Params)localObject).a = this.b.d.a;
        ((GdtHandler.Params)localObject).b = this.b.d.b;
        ((GdtHandler.Params)localObject).c = this.b.d.c;
        ((GdtHandler.Params)localObject).d = this.b.d.d;
        ((GdtHandler.Params)localObject).e = this.b.d.e;
        ((GdtHandler.Params)localObject).f = this.b.d.f;
        ((GdtHandler.Params)localObject).g = this.b.d.g;
        ((GdtHandler.Params)localObject).h = this.b.d.h;
        ((GdtHandler.Params)localObject).i = this.b.d.i;
        ((GdtHandler.Params)localObject).j = this.b.d.j;
        ((GdtHandler.Params)localObject).k = this.b.d.k;
        ((GdtHandler.Params)localObject).l = this.b.d.l;
        ((GdtHandler.Params)localObject).m = this.b.d.m;
        ((GdtHandler.Params)localObject).n = this.b.d.n;
        ((GdtHandler.Params)localObject).o = this.b.d.o;
        ((GdtHandler.Params)localObject).p = this.b.d.p;
        ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).handleGdtAdClick((GdtHandler.Params)localObject);
        bool = true;
        break label316;
      }
    }
    boolean bool = false;
    label316:
    GdtLog.b("GdtInterstitialFragment", String.format("onClick %b", new Object[] { Boolean.valueOf(bool) }));
    return bool;
  }
  
  GdtInterstitialParams d()
  {
    return this.b;
  }
  
  GdtInterstitialStatus e()
  {
    return this.c;
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
    //   1: getfield 31	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:c	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;
    //   4: astore_1
    //   5: invokestatic 413	com/tencent/gdtad/api/interstitial/GdtInterstitialPreDownloader:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialPreDownloader;
    //   8: invokevirtual 416	com/tencent/gdtad/api/interstitial/GdtInterstitialPreDownloader:b	()I
    //   11: iconst_3
    //   12: if_icmpne +9 -> 21
    //   15: iconst_1
    //   16: istore 6
    //   18: goto +6 -> 24
    //   21: iconst_0
    //   22: istore 6
    //   24: aload_1
    //   25: iload 6
    //   27: putfield 417	com/tencent/gdtad/api/interstitial/GdtInterstitialStatus:b	Z
    //   30: iconst_4
    //   31: istore 4
    //   33: new 419	android/widget/FrameLayout
    //   36: dup
    //   37: aload_0
    //   38: invokevirtual 169	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   41: invokespecial 421	android/widget/FrameLayout:<init>	(Landroid/content/Context;)V
    //   44: astore_1
    //   45: iload 4
    //   47: istore 5
    //   49: aload_0
    //   50: iconst_1
    //   51: invokespecial 240	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:a	(Z)V
    //   54: iload 4
    //   56: istore 5
    //   58: getstatic 427	com/tencent/ad/tangram/thread/AdThreadManager:INSTANCE	Lcom/tencent/ad/tangram/thread/AdThreadManager;
    //   61: new 429	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$1
    //   64: dup
    //   65: aload_0
    //   66: invokespecial 432	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$1:<init>	(Lcom/tencent/gdtad/api/interstitial/GdtInterstitialFragment;)V
    //   69: iconst_0
    //   70: ldc2_w 433
    //   73: invokevirtual 438	com/tencent/ad/tangram/thread/AdThreadManager:postDelayed	(Ljava/lang/Runnable;IJ)Z
    //   76: pop
    //   77: iload 4
    //   79: istore 5
    //   81: invokestatic 442	com/tencent/gdtad/api/interstitial/GdtArkUtil:a	()V
    //   84: iload 4
    //   86: istore 5
    //   88: ldc_w 444
    //   91: invokestatic 215	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   94: checkcast 444	com/tencent/mobileqq/ark/api/IArkAPIService
    //   97: invokestatic 299	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialManager;
    //   100: invokevirtual 447	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:d	()Lcom/tencent/gdtad/api/interstitial/GdtArkApp;
    //   103: getfield 451	com/tencent/gdtad/api/interstitial/GdtArkApp:a	Ljava/lang/String;
    //   106: invokestatic 299	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialManager;
    //   109: invokevirtual 454	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:e	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialNotifyReg;
    //   112: invokeinterface 458 3 0
    //   117: iload 4
    //   119: istore 5
    //   121: aload_0
    //   122: invokevirtual 462	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   125: ifnonnull +6 -> 131
    //   128: goto +336 -> 464
    //   131: iload 4
    //   133: istore 5
    //   135: aload_0
    //   136: invokevirtual 462	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   139: ldc 88
    //   141: invokevirtual 465	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   144: ifne +6 -> 150
    //   147: goto +317 -> 464
    //   150: iload 4
    //   152: istore 5
    //   154: aload_0
    //   155: aload_0
    //   156: invokevirtual 462	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   159: ldc 88
    //   161: invokevirtual 469	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   164: checkcast 43	com/tencent/gdtad/api/interstitial/GdtInterstitialParams
    //   167: putfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   170: iload 4
    //   172: istore 5
    //   174: aload_0
    //   175: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   178: ifnonnull +6 -> 184
    //   181: goto +283 -> 464
    //   184: iload 4
    //   186: istore 5
    //   188: aload_0
    //   189: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   192: invokevirtual 46	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:b	()Z
    //   195: ifne +6 -> 201
    //   198: goto +266 -> 464
    //   201: iload 4
    //   203: istore 5
    //   205: aload_0
    //   206: invokespecial 301	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:g	()Ljava/lang/String;
    //   209: invokestatic 474	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   212: ifeq +6 -> 218
    //   215: goto +249 -> 464
    //   218: iload 4
    //   220: istore 5
    //   222: aload_0
    //   223: invokevirtual 462	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   226: ldc 94
    //   228: invokevirtual 465	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   231: ifne +6 -> 237
    //   234: goto +230 -> 464
    //   237: iload 4
    //   239: istore 5
    //   241: aload_0
    //   242: getfield 31	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:c	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;
    //   245: aload_0
    //   246: invokevirtual 462	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getArguments	()Landroid/os/Bundle;
    //   249: ldc 94
    //   251: invokevirtual 478	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   254: putfield 480	com/tencent/gdtad/api/interstitial/GdtInterstitialStatus:m	J
    //   257: invokestatic 299	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	()Lcom/tencent/gdtad/api/interstitial/GdtInterstitialManager;
    //   260: aload_0
    //   261: invokespecial 301	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:g	()Ljava/lang/String;
    //   264: new 317	java/lang/ref/WeakReference
    //   267: dup
    //   268: aload_0
    //   269: invokespecial 320	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   272: invokevirtual 483	com/tencent/gdtad/api/interstitial/GdtInterstitialManager:a	(Ljava/lang/String;Ljava/lang/ref/WeakReference;)Z
    //   275: ifne +6 -> 281
    //   278: goto +183 -> 461
    //   281: aload_0
    //   282: invokevirtual 169	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   285: ifnonnull +6 -> 291
    //   288: goto +173 -> 461
    //   291: aload_0
    //   292: invokevirtual 169	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   295: aload_0
    //   296: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   299: getfield 49	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:e	I
    //   302: invokevirtual 486	androidx/fragment/app/FragmentActivity:setRequestedOrientation	(I)V
    //   305: aload_0
    //   306: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   309: aload_0
    //   310: invokevirtual 169	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   313: invokestatic 491	com/tencent/gdtad/views/GdtUIUtils:b	(Landroid/content/Context;)I
    //   316: putfield 493	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:g	I
    //   319: aload_0
    //   320: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   323: aload_0
    //   324: invokevirtual 169	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   327: invokestatic 495	com/tencent/gdtad/views/GdtUIUtils:c	(Landroid/content/Context;)I
    //   330: putfield 496	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:h	I
    //   333: aload_0
    //   334: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   337: getfield 493	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:g	I
    //   340: ifle +121 -> 461
    //   343: aload_0
    //   344: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   347: getfield 496	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:h	I
    //   350: ifgt +6 -> 356
    //   353: goto +108 -> 461
    //   356: aload_0
    //   357: new 291	com/tencent/gdtad/api/interstitial/GdtInterstitialView
    //   360: dup
    //   361: aload_0
    //   362: invokevirtual 169	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   365: aload_0
    //   366: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   369: aload_0
    //   370: getfield 31	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:c	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;
    //   373: invokespecial 498	com/tencent/gdtad/api/interstitial/GdtInterstitialView:<init>	(Landroid/content/Context;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;Lcom/tencent/gdtad/api/interstitial/GdtInterstitialStatus;)V
    //   376: putfield 289	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:d	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialView;
    //   379: aload_0
    //   380: getfield 289	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:d	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialView;
    //   383: invokevirtual 502	com/tencent/gdtad/api/interstitial/GdtInterstitialView:getView	()Landroid/view/View;
    //   386: ifnonnull +6 -> 392
    //   389: goto +72 -> 461
    //   392: new 504	android/widget/FrameLayout$LayoutParams
    //   395: dup
    //   396: aload_0
    //   397: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   400: getfield 493	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:g	I
    //   403: aload_0
    //   404: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   407: getfield 496	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:h	I
    //   410: invokespecial 506	android/widget/FrameLayout$LayoutParams:<init>	(II)V
    //   413: astore_2
    //   414: aload_2
    //   415: bipush 17
    //   417: putfield 509	android/widget/FrameLayout$LayoutParams:gravity	I
    //   420: aload_1
    //   421: aload_0
    //   422: getfield 289	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:d	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialView;
    //   425: invokevirtual 502	com/tencent/gdtad/api/interstitial/GdtInterstitialView:getView	()Landroid/view/View;
    //   428: aload_2
    //   429: invokevirtual 513	android/widget/FrameLayout:addView	(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    //   432: aload_0
    //   433: getfield 148	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:b	Lcom/tencent/gdtad/api/interstitial/GdtInterstitialParams;
    //   436: getfield 514	com/tencent/gdtad/api/interstitial/GdtInterstitialParams:f	Z
    //   439: ifne +16 -> 455
    //   442: aload_0
    //   443: invokevirtual 169	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:getActivity	()Landroidx/fragment/app/FragmentActivity;
    //   446: invokevirtual 518	androidx/fragment/app/FragmentActivity:getWindow	()Landroid/view/Window;
    //   449: sipush 1024
    //   452: invokevirtual 523	android/view/Window:addFlags	(I)V
    //   455: iconst_0
    //   456: istore 4
    //   458: goto +6 -> 464
    //   461: iconst_1
    //   462: istore 4
    //   464: iload 4
    //   466: istore 5
    //   468: ldc 124
    //   470: ldc_w 525
    //   473: iconst_1
    //   474: anewarray 128	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_0
    //   480: invokespecial 301	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:g	()Ljava/lang/String;
    //   483: aastore
    //   484: invokestatic 140	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   487: invokestatic 145	com/tencent/gdtad/log/GdtLog:b	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   511: ldc 124
    //   513: ldc_w 526
    //   516: aload_2
    //   517: invokestatic 202	com/tencent/gdtad/log/GdtLog:d	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   520: aload_0
    //   521: invokespecial 528	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment:f	()V
    //   524: getstatic 427	com/tencent/ad/tangram/thread/AdThreadManager:INSTANCE	Lcom/tencent/ad/tangram/thread/AdThreadManager;
    //   527: new 530	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$2
    //   530: dup
    //   531: aload_0
    //   532: iload 4
    //   534: invokespecial 533	com/tencent/gdtad/api/interstitial/GdtInterstitialFragment$2:<init>	(Lcom/tencent/gdtad/api/interstitial/GdtInterstitialFragment;I)V
    //   537: iconst_5
    //   538: invokevirtual 537	com/tencent/ad/tangram/thread/AdThreadManager:post	(Ljava/lang/Runnable;I)Z
    //   541: pop
    //   542: aload_0
    //   543: aload_1
    //   544: invokestatic 543	com/tencent/qqlive/module/videoreport/inject/fragment/AndroidXFragmentCollector:onAndroidXFragmentViewCreated	(Landroidx/fragment/app/Fragment;Landroid/view/View;)V
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
    this.c.a = 3;
    GdtInterstitialView localGdtInterstitialView = this.d;
    if (localGdtInterstitialView != null) {
      localGdtInterstitialView.a(getActivity());
    }
    if (this.c.f) {
      GdtInterstitialNotifyReg.b(getActivity(), this.b, this.c);
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    GdtLog.b("GdtInterstitialFragment", "onResume");
    this.c.a = 2;
    GdtInterstitialView localGdtInterstitialView = this.d;
    if (localGdtInterstitialView != null) {
      localGdtInterstitialView.b(getActivity());
    }
    if (this.c.f)
    {
      a(false);
      GdtInterstitialNotifyReg.a(getActivity(), this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.api.interstitial.GdtInterstitialFragment
 * JD-Core Version:    0.7.0.1
 */