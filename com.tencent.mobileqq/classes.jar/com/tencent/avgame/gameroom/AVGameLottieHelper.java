package com.tencent.avgame.gameroom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.FileInputStream;
import org.jetbrains.annotations.Nullable;

public class AVGameLottieHelper
{
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString1, new AVGameLottieHelper.3(paramInt1, paramContext, paramInt2, paramInt3, paramString2, paramLottieDrawableLoadedListener));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("AVGameLottieHelper", 1, "fromAssetFileName fail", paramContext);
      ThreadManager.a().post(new AVGameLottieHelper.4(paramLottieDrawableLoadedListener));
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    paramString1 = AvGameResDownloadManager.a() + paramString1;
    paramString2 = AvGameResDownloadManager.a() + paramString2;
    if (QLog.isColorLevel()) {
      QLog.d("AVGameLottieHelper", 2, "loadLottieAnim  animJsonPath = " + paramString1 + ",animImageDirPath = " + paramString2);
    }
    if ((FileUtils.b(paramString1)) && (FileUtils.b(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLottieHelper", 2, "loadLottieAnim loadLottieAnimFromFile");
      }
      b(paramContext, paramString1, paramString2, paramInt1, paramInt2, paramLottieDrawableLoadedListener);
    }
  }
  
  @Nullable
  private static Bitmap b(String paramString)
  {
    Object localObject = GlobalImageCache.a.get(paramString);
    if ((localObject != null) && ((localObject instanceof Bitmap))) {
      return (Bitmap)localObject;
    }
    try
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inScaled = false;
      localObject = BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      GlobalImageCache.a.put(paramString, localObject);
      return localObject;
    }
    catch (Throwable paramString)
    {
      QLog.i("AVGameLottieHelper", 1, "getBitmap error " + paramString.getMessage());
    }
    return null;
  }
  
  public static void b(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, AVGameLottieHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    try
    {
      LottieComposition.Factory.fromInputStream(paramContext, new FileInputStream(paramString1), new AVGameLottieHelper.1(paramInt1, paramInt2, paramContext, paramString2, paramLottieDrawableLoadedListener));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("AVGameLottieHelper", 1, "fromAssetFileName fail", paramContext);
      ThreadManager.a().post(new AVGameLottieHelper.2(paramLottieDrawableLoadedListener));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.AVGameLottieHelper
 * JD-Core Version:    0.7.0.1
 */