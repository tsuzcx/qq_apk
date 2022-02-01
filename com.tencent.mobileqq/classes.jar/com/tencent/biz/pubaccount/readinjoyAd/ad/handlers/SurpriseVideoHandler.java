package com.tencent.biz.pubaccount.readinjoyAd.ad.handlers;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.AdVPNGImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVpngVideo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJSurpriseVideoService;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import cooperation.liveroom.LiveRoomGiftCallback;
import java.io.File;
import java.lang.ref.SoftReference;

public class SurpriseVideoHandler
{
  private SoftReference<AdVPNGImageView> a = new SoftReference(null);
  private LiveRoomGiftCallback b = new -..Lambda.SurpriseVideoHandler.45IdL_v8UVqjMxiVGxnEtZWULdA(this);
  private volatile boolean c = false;
  
  private String a(String paramString)
  {
    int i = paramString.lastIndexOf('/');
    if (i != -1)
    {
      paramString = paramString.substring(i + 1);
      if (!TextUtils.isEmpty(paramString))
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append(AppConstants.SDCARD_PATH);
        localStringBuilder2.append(".readInjoy/resource/surpriseVideo/");
        localStringBuilder1.append(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder2.toString()));
        localStringBuilder1.append(paramString);
        return localStringBuilder1.toString();
      }
    }
    return "";
  }
  
  private String b(String paramString)
  {
    Object localObject = a(paramString);
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists()) {
        return ((File)localObject).getAbsolutePath();
      }
      ThreadManagerV2.executeOnSubThread(new -..Lambda.SurpriseVideoHandler.o-IYGsubMmJ1znEZx0BOYaupFJs(paramString, (File)localObject));
    }
    return paramString;
  }
  
  private static boolean c()
  {
    String str = Aladdin.getConfig(479).getString("surprise_video_play_switch_on", "1");
    return (str != null) && (str.equals("1"));
  }
  
  private void d()
  {
    if (!this.c) {
      return;
    }
    this.c = false;
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).setSurpriseVideoPlayingState(false);
    AdVPNGImageView localAdVPNGImageView = (AdVPNGImageView)this.a.get();
    if (localAdVPNGImageView == null) {
      return;
    }
    if (localAdVPNGImageView.getParent() != null) {
      ((ViewGroup)localAdVPNGImageView.getParent()).removeView(localAdVPNGImageView);
    }
    localAdVPNGImageView.a();
  }
  
  public void a()
  {
    AdVPNGImageView localAdVPNGImageView = (AdVPNGImageView)this.a.get();
    if ((localAdVPNGImageView != null) && (this.c)) {
      localAdVPNGImageView.onPause();
    }
  }
  
  public void a(Context paramContext)
  {
    ((IRIJSurpriseVideoService)QRoute.api(IRIJSurpriseVideoService.class)).setVideoSearchCallback(new -..Lambda.SurpriseVideoHandler.-7OCwDG_su-ZHQYGa1QrY7dn5bM(this));
    ((IRIJSurpriseVideoService)QRoute.api(IRIJSurpriseVideoService.class)).setDisLikeListener(new SurpriseVideoHandler.1(this));
    AppNetConnInfo.registerConnectionChangeReceiver(paramContext, new SurpriseVideoHandler.2(this));
  }
  
  public void a(View paramView, String paramString)
  {
    if (!c()) {
      return;
    }
    AdVPNGImageView localAdVPNGImageView2 = (AdVPNGImageView)this.a.get();
    AdVPNGImageView localAdVPNGImageView1 = localAdVPNGImageView2;
    if (localAdVPNGImageView2 == null)
    {
      localAdVPNGImageView1 = new AdVPNGImageView(paramView.getContext());
      localAdVPNGImageView1.b();
      this.a = new SoftReference(localAdVPNGImageView1);
      localAdVPNGImageView1.setPlayOnSubThread(true);
    }
    if (this.c) {
      return;
    }
    paramView = (ReadInJoyAdVpngVideo)((IProteusItemView)paramView).getContainer().getVirtualView().findViewBaseByName("ReadInJoyAdVpngVideo");
    paramString = b(paramString);
    if (localAdVPNGImageView1.getParent() != null) {
      ((ViewGroup)localAdVPNGImageView1.getParent()).removeView(localAdVPNGImageView1);
    }
    localAdVPNGImageView1.setPlayOnSubThread(false);
    paramView.a(paramString, localAdVPNGImageView1, this.b);
    this.c = true;
    ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).setSurpriseVideoPlayingState(true);
  }
  
  public void b()
  {
    AdVPNGImageView localAdVPNGImageView = (AdVPNGImageView)this.a.get();
    if ((localAdVPNGImageView != null) && (this.c))
    {
      localAdVPNGImageView.onResume();
      localAdVPNGImageView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.SurpriseVideoHandler
 * JD-Core Version:    0.7.0.1
 */