package com.tencent.mobileqq.activity.registerGuideLogin;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.dinifly.ImageAssetDelegate;
import com.tencent.mobileqq.dinifly.LottieImageAsset;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

public class LoginBtnImageAssetDelegate
  implements ImageAssetDelegate
{
  private Context a;
  
  public LoginBtnImageAssetDelegate(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @Nullable
  public Bitmap fetchBitmap(LottieImageAsset paramLottieImageAsset)
  {
    try
    {
      localObject = this.a.getAssets();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("login_btn_lottie_images/");
      localStringBuilder.append(paramLottieImageAsset.getFileName());
      paramLottieImageAsset = ((AssetManager)localObject).open(localStringBuilder.toString());
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeStream(paramLottieImageAsset, (Rect)null, (BitmapFactory.Options)localObject);
      paramLottieImageAsset.close();
      return localObject;
    }
    catch (Throwable paramLottieImageAsset)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("fetchBitmap error ");
      ((StringBuilder)localObject).append(paramLottieImageAsset.getMessage());
      QLog.i("LoginBtnImageAssetDelegate", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginBtnImageAssetDelegate
 * JD-Core Version:    0.7.0.1
 */