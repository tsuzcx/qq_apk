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
  public View a;
  protected int b;
  protected QQAppInterface c;
  protected AnimatorSet d;
  protected Context e;
  protected String f;
  protected String g;
  protected String h;
  protected int i;
  protected BannerInfo j;
  protected boolean k;
  protected int l;
  protected AdProgressButton m;
  protected Dialog n;
  public INetInfoHandler o;
  
  public static AdModuleBase a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      int i1 = paramJSONObject.optInt("moduleType");
      if (i1 != 1)
      {
        if (i1 != 2) {
          paramJSONObject = null;
        } else {
          paramJSONObject = AdModuleVideo.a(paramJSONObject.optJSONObject("mixVideoModule"));
        }
      }
      else {
        paramJSONObject = AdModuleSinglePic.a(paramJSONObject.optJSONObject("singleImageModule"));
      }
      if (paramJSONObject != null) {
        paramJSONObject.c = paramQQAppInterface;
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
    if ((paramDownloadInfo != null) && (this.j != null) && (!TextUtils.isEmpty(paramDownloadInfo.e)) && (!TextUtils.isEmpty(paramDownloadInfo.c)) && (!TextUtils.isEmpty(this.j.h)))
    {
      if (TextUtils.isEmpty(this.j.f)) {
        return false;
      }
      if ((paramDownloadInfo.e.equals(this.j.h)) && (paramDownloadInfo.c.equals(this.j.f))) {
        return true;
      }
    }
    return false;
  }
  
  private void d()
  {
    if (!NetworkUtil.isNetworkAvailable(this.e))
    {
      Context localContext = this.e;
      QQToast.makeText(localContext, 1, localContext.getString(2131915328), 0).show(0);
      return;
    }
    if (NetworkUtil.isWifiConnected(this.e))
    {
      e();
      return;
    }
    f();
  }
  
  private void e()
  {
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).downloadApk((Activity)this.e, this.j, this);
    AdProgressButton localAdProgressButton = this.m;
    if (localAdProgressButton != null)
    {
      localAdProgressButton.setText(this.e.getText(2131915435));
      this.m.setTextColor(-16777216);
      this.m.setBackgroundResource(2130839494);
      this.m.setProgress(0);
      this.m.setClickable(false);
    }
    this.l = 3;
    ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.c, this.f, this.g, this.h, 3, 2, 0);
  }
  
  private void f()
  {
    Object localObject = this.e;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (this.n == null)
      {
        localObject = (IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class);
        Context localContext = this.e;
        this.n = ((IRIJAdUtilService)localObject).createDialog(localContext, null, localContext.getString(2131915443), new AdModuleBase.3(this), this.e.getString(2131915444), new AdModuleBase.4(this), this.e.getString(2131915445));
        this.n.setCanceledOnTouchOutside(false);
      }
      this.n.show();
    }
  }
  
  private void g()
  {
    if (this.l == 3)
    {
      DownloadManager.b().g(this.j.f);
      Context localContext = this.e;
      QQToast.makeText(localContext, 1, localContext.getString(2131915446), 0).show(0);
      ThreadManager.getUIHandler().post(new AdModuleBase.5(this));
    }
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, BannerInfo paramBannerInfo, boolean paramBoolean)
  {
    this.e = paramContext;
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
    this.i = paramInt;
    this.j = paramBannerInfo;
    this.k = paramBoolean;
    return null;
  }
  
  public void a()
  {
    if ((this.k) && (this.a != null))
    {
      Object localObject = this.j;
      if ((localObject != null) && (((BannerInfo)localObject).a == 2))
      {
        localObject = (AdProgressButton)this.a.findViewById(2131440742);
        if (this.j.d == 2)
        {
          ((AdProgressButton)localObject).setText(this.e.getText(2131915449));
          return;
        }
        if (this.j.d == 1)
        {
          if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppInstall(this.e, this.j.h))
          {
            ((AdProgressButton)localObject).setText(this.e.getText(2131915447));
            this.l = 1;
            return;
          }
          if (ADBaseAppDownloadManager.a(this.e, this.j.h))
          {
            ((AdProgressButton)localObject).setText(this.e.getText(2131915440));
            this.l = 2;
            return;
          }
          if (this.l != 3)
          {
            ((AdProgressButton)localObject).setText(this.e.getText(2131915434));
            this.l = 0;
          }
        }
      }
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    Object localObject1 = LayoutInflater.from(paramContext).inflate(2131626284, null);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(12, -1);
    ((ViewGroup)paramView).addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = this.j;
    int i1;
    if (((localObject1 == null) || (((BannerInfo)localObject1).a != 1)) && (!this.k))
    {
      i1 = this.i;
      if ((i1 == 1) || (i1 == 2))
      {
        paramView.findViewById(2131447421).setVisibility(0);
        if (this.i == 1) {
          paramView.findViewById(2131447423).setVisibility(8);
        }
        localObject1 = paramView.findViewById(2131449242);
        localObject2 = paramView.findViewById(2131449243);
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
        this.d = new AnimatorSet();
        this.d.playTogether(new Animator[] { localObject2, localObject1 });
        this.d.start();
      }
    }
    if (this.k)
    {
      localObject1 = this.j;
      if ((localObject1 != null) && (((BannerInfo)localObject1).a == 2))
      {
        paramView.findViewById(2131432088).setVisibility(0);
        try
        {
          localObject1 = new URL(this.j.b);
          ((ResizeURLImageView)paramView.findViewById(2131432100)).setImage((URL)localObject1);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        ((TextView)paramView.findViewById(2131432095)).setText(this.j.c);
        this.m = ((AdProgressButton)paramView.findViewById(2131440742));
        this.m.setProgressColor(paramContext.getResources().getColor(2131165591));
        this.m.setOnClickListener(new AdModuleBase.1(this));
        i1 = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isPkgDownloading(this.e, this.j);
        if (i1 >= 0)
        {
          this.m.setText(this.e.getText(2131915435));
          this.m.setTextColor(-16777216);
          this.m.setBackgroundResource(2130839494);
          this.m.setProgress(i1);
          this.m.setClickable(false);
          this.l = 3;
          DownloadManager.b().a(this);
        }
        if (this.o == null)
        {
          this.o = new AdModuleBase.2(this);
          AppNetConnInfo.registerConnectionChangeReceiver(this.e, this.o);
        }
      }
    }
  }
  
  public abstract void b();
  
  public void c()
  {
    this.a = null;
    AnimatorSet localAnimatorSet = this.d;
    if (localAnimatorSet != null)
    {
      localAnimatorSet.cancel();
      this.d = null;
    }
    this.b = 0;
    if (this.k) {
      DownloadManager.b().b(this);
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
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.c, this.f, this.g, this.h, 3, 4, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase
 * JD-Core Version:    0.7.0.1
 */