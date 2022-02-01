package com.tencent.biz.pubaccount.imagecollection.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.WXShareListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class PublicAccountImageCollectionUtilsImpl
  implements IPublicAccountImageCollectionUtils
{
  public static final String IMAGE_KEY = "image_key";
  public static final String POSITION_X = "positionX";
  public static final String POSITION_Y = "positionY";
  public static final String TAG = "PublicAccountImageCollectionUtils";
  public static final String VIEW_HEIGHT = "viewHeight";
  public static final String VIEW_WIDTH = "viewWidth";
  public static ConcurrentHashMap<String, SoftReference<Bitmap>> animationBitmapList = new ConcurrentHashMap();
  
  public static boolean openPublicAccountImageCollectionMainActivityInner(Activity paramActivity, Intent paramIntent, String paramString)
  {
    if ((paramActivity != null) && (paramIntent != null))
    {
      paramIntent.putExtra("articleid", paramString);
      paramActivity.startActivity(paramIntent);
      return true;
    }
    return false;
  }
  
  private static Bitmap scaleBitmapForWeChat(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int k = j * i;
      localObject = paramBitmap;
      if (k > 8000)
      {
        double d1 = k;
        Double.isNaN(d1);
        d1 = 8000.0D / d1;
        d1 = Math.sqrt(d1);
        double d2 = j;
        Double.isNaN(d2);
        j = (int)(d2 * d1);
        d2 = i;
        Double.isNaN(d2);
        i = (int)(d2 * d1);
        localObject = Bitmap.createScaledBitmap(paramBitmap, j, i, true);
      }
      return localObject;
    }
    catch (Exception paramBitmap)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scaleBitmapForWeChat ERROR e=");
        ((StringBuilder)localObject).append(paramBitmap.getMessage());
        QLog.d("PublicAccountImageCollectionUtils", 2, ((StringBuilder)localObject).toString());
        return null;
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      System.gc();
      paramBitmap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionUtils", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
      }
    }
    return null;
  }
  
  public static void shareToWechatWithThumb(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt)
  {
    Object localObject = "";
    paramBaseActivity = paramString1;
    if (paramString1 == null) {
      paramBaseActivity = "";
    }
    if (paramString2 == null) {
      paramString1 = (String)localObject;
    } else {
      paramString1 = paramString2;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720478;
    } else if (!WXShareHelper.a().b()) {
      i = 2131720479;
    } else {
      i = -1;
    }
    if (i != -1)
    {
      QRUtils.a(0, i);
    }
    else
    {
      paramString2 = String.valueOf(System.currentTimeMillis());
      localObject = new PublicAccountImageCollectionUtilsImpl.1(paramString2);
      WXShareHelper.a().a((WXShareHelper.WXShareListener)localObject);
      localObject = WXShareHelper.a();
      paramBitmap = scaleBitmapForWeChat(paramBitmap);
      if (paramInt == 9) {
        i = 0;
      } else {
        i = 1;
      }
      ((WXShareHelper)localObject).a(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, i);
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("title=");
      paramString2.append(paramBaseActivity);
      paramString2.append(", description=");
      paramString2.append(paramString1);
      paramString2.append(", shareUrl=");
      paramString2.append(paramString3);
      paramString2.append(", action=");
      paramString2.append(paramInt);
      QLog.d("PublicAccountImageCollectionUtils", 2, paramString2.toString());
    }
  }
  
  public boolean openPublicAccountImageCollectionMainActivity(Activity paramActivity, Intent paramIntent, String paramString)
  {
    return openPublicAccountImageCollectionMainActivityInner(paramActivity, paramIntent, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionUtilsImpl
 * JD-Core Version:    0.7.0.1
 */