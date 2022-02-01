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
  private IPublicAccountImageDownListener a;
  public int d;
  public String d;
  public int e;
  
  public static AdModuleSinglePic a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      AdModuleSinglePic localAdModuleSinglePic = new AdModuleSinglePic();
      localAdModuleSinglePic.jdField_d_of_type_JavaLangString = paramJSONObject.optString("imageUrl");
      localAdModuleSinglePic.jdField_d_of_type_Int = paramJSONObject.optInt("imageWidth");
      localAdModuleSinglePic.e = paramJSONObject.optInt("imageHeight");
      boolean bool = TextUtils.isEmpty(localAdModuleSinglePic.jdField_d_of_type_JavaLangString);
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
    paramString1 = LayoutInflater.from(paramContext).inflate(2131560239, null);
    paramString2 = (ResizeURLImageView)paramString1.findViewById(2131372717);
    if (!TextUtils.isEmpty(this.jdField_d_of_type_JavaLangString)) {
      try
      {
        paramString3 = new URL(this.jdField_d_of_type_JavaLangString);
        paramString2.setImage(paramString3);
        if (((IImageManager)QRoute.api(IImageManager.class)).isLocalFileExist(paramString3))
        {
          this.jdField_a_of_type_Int = 2;
        }
        else
        {
          this.jdField_a_of_type_Int = 1;
          this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener = new AdModuleSinglePic.1(this, paramString1, paramString2);
          paramString2.setPublicAccountImageDownListener(this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener);
          paramString1.findViewById(2131370364).setVisibility(0);
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
    if (this.jdField_a_of_type_Int == 3) {
      d();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      NativeAdPreloadManager localNativeAdPreloadManager = (NativeAdPreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_NATIVE_AD_PRELOAD_MANAGER);
      if (localNativeAdPreloadManager != null) {
        localNativeAdPreloadManager.a(this.jdField_d_of_type_JavaLangString);
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentBizPubaccountImagecollectionApiIPublicAccountImageDownListener = null;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_AndroidViewView.findViewById(2131370364).setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131366458).setVisibility(8);
    try
    {
      URL localURL = new URL(this.jdField_d_of_type_JavaLangString);
      ((ResizeURLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372717)).setImage(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleSinglePic
 * JD-Core Version:    0.7.0.1
 */