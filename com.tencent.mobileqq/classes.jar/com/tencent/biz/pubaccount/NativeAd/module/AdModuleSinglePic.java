package com.tencent.biz.pubaccount.NativeAd.module;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageDownListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.ResizeURLImageView;
import com.tencent.mobileqq.qroute.QRoute;
import java.net.URL;
import org.json.JSONObject;

public class AdModuleSinglePic
  extends AdModuleBase
{
  public String p;
  public int q;
  public int r;
  private IPublicAccountImageDownListener s;
  
  public static AdModuleSinglePic a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      AdModuleSinglePic localAdModuleSinglePic = new AdModuleSinglePic();
      localAdModuleSinglePic.p = paramJSONObject.optString("imageUrl");
      localAdModuleSinglePic.q = paramJSONObject.optInt("imageWidth");
      localAdModuleSinglePic.r = paramJSONObject.optInt("imageHeight");
      boolean bool = TextUtils.isEmpty(localAdModuleSinglePic.p);
      if (bool) {
        return null;
      }
      return localAdModuleSinglePic;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public View a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, BannerInfo paramBannerInfo, boolean paramBoolean)
  {
    super.a(paramContext, paramString1, paramString2, paramString3, paramInt, paramBannerInfo, paramBoolean);
    paramString1 = LayoutInflater.from(paramContext).inflate(2131626286, null);
    paramString2 = (ResizeURLImageView)paramString1.findViewById(2131440263);
    if (!TextUtils.isEmpty(this.p)) {
      try
      {
        paramString3 = new URL(this.p);
        paramString2.setImage(paramString3);
        if (((IImageManager)QRoute.api(IImageManager.class)).isLocalFileExist(paramString3))
        {
          this.b = 2;
        }
        else
        {
          this.b = 1;
          this.s = new AdModuleSinglePic.1(this, paramString1, paramString2);
          paramString2.setPublicAccountImageDownListener(this.s);
          paramString1.findViewById(2131437626).setVisibility(0);
        }
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
    }
    a(paramContext, paramString1);
    return paramString1;
  }
  
  public void a()
  {
    super.a();
    if (this.b == 3) {
      d();
    }
  }
  
  public void b()
  {
    if (this.c != null)
    {
      NativeAdPreloadManager localNativeAdPreloadManager = (NativeAdPreloadManager)this.c.getManager(QQManagerFactory.KANDIAN_NATIVE_AD_PRELOAD_MANAGER);
      if (localNativeAdPreloadManager != null) {
        localNativeAdPreloadManager.a(this.p);
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.s = null;
  }
  
  public void d()
  {
    this.b = 1;
    this.a.findViewById(2131437626).setVisibility(0);
    this.a.findViewById(2131432776).setVisibility(8);
    try
    {
      URL localURL = new URL(this.p);
      ((ResizeURLImageView)this.a.findViewById(2131440263)).setImage(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleSinglePic
 * JD-Core Version:    0.7.0.1
 */