package com.tencent.avgame.gamelogic.gameres;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class AvGameResDownloadUtil
{
  public static String a;
  
  public static URLDrawable a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(c());
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDrawableByImageName path = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("AvGameResDownloadUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (!FileUtils.fileExists(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDrawableByImageName return null,path = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("AvGameResDownloadUtil", 2, ((StringBuilder)localObject).toString());
      }
      return null;
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
    paramString = URLDrawable.getDrawable(new File(paramString), (URLDrawable.URLDrawableOptions)localObject);
    paramString.downloadImediatly(true);
    return paramString;
  }
  
  public static String a()
  {
    if (TextUtils.isEmpty(a)) {
      a = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4).getString("resPath", a);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("lottie");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(f());
    localStringBuilder.append("star/");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static String b()
  {
    if (TextUtils.isEmpty(a)) {
      a = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4).getString("resPath", a);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("sounds");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String c()
  {
    if (TextUtils.isEmpty(a)) {
      a = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4).getString("resPath", a);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("images");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String d()
  {
    a = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4).getString("resPath", a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("fonts");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String e()
  {
    if (TextUtils.isEmpty(a)) {
      a = MobileQQ.sMobileQQ.getSharedPreferences("av_game_sp", 4).getString("resPath", a);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("AVGameFontConfigure.json");
    return localStringBuilder.toString();
  }
  
  private static String f()
  {
    if (SystemUtil.a()) {
      localObject1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
    } else {
      localObject1 = MobileQQ.sMobileQQ.getFilesDir().getAbsolutePath();
    }
    Object localObject2 = localObject1;
    if (localObject1 != null)
    {
      localObject2 = localObject1;
      if (!((String)localObject1).endsWith(File.separator))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separator);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("avgame/res");
    ((StringBuilder)localObject1).append(File.separator);
    return ((StringBuilder)localObject1).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil
 * JD-Core Version:    0.7.0.1
 */