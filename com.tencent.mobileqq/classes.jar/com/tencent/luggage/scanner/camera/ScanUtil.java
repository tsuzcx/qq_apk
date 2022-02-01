package com.tencent.luggage.scanner.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.tencent.luggage.wxa.ry.b;
import com.tencent.qbar.QbarNative.QbarAiModelParam;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;

public class ScanUtil
{
  public static void copyFile(InputStream paramInputStream, String paramString, boolean paramBoolean)
  {
    paramString = new File(paramString);
    if ((!paramString.exists()) || ((paramString.exists()) && (paramBoolean))) {
      try
      {
        paramString.delete();
        FileUtils.copyInputStreamToFile(paramInputStream, paramString);
        return;
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  public static void copyFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString2 = new File(paramString2);
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {
      return;
    }
    if ((!paramString2.exists()) || ((paramString2.exists()) && (paramBoolean))) {
      try
      {
        paramString2.delete();
        FileUtils.copyFile(paramString1, paramString2);
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static QbarNative.QbarAiModelParam getAiModeParam(Context paramContext)
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramContext.getFilesDir().getAbsolutePath());
      ((StringBuilder)localObject1).append("/");
      ((StringBuilder)localObject1).append("qbar");
      String str = ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str);
      ((StringBuilder)localObject1).append("/detect_model.bin");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("/detect_model.param");
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append("/srnet.bin");
      localObject3 = ((StringBuilder)localObject3).toString();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append("/srnet.param");
      str = ((StringBuilder)localObject4).toString();
      localObject4 = paramContext.getSharedPreferences("qbar_ai_preference_file", 0);
      int i = ((SharedPreferences)localObject4).getInt("qbar_ai_model_version", 0);
      int j = ((SharedPreferences)localObject4).getInt("qbar_ai_model_copy_version", 0);
      b.c("ScanUtil", String.format("version %d, copyVersion %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
      if ((i != 103) || (i != j))
      {
        copyFile(paramContext.getResources().getAssets().open("qbar/detect_model.bin"), (String)localObject1, true);
        copyFile(paramContext.getResources().getAssets().open("qbar/detect_model.param"), (String)localObject2, true);
        copyFile(paramContext.getResources().getAssets().open("qbar/srnet.bin"), (String)localObject3, true);
        copyFile(paramContext.getResources().getAssets().open("qbar/srnet.param"), str, true);
        ((SharedPreferences)localObject4).edit().putInt("qbar_ai_model_version", 103).apply();
        ((SharedPreferences)localObject4).edit().putInt("qbar_ai_model_copy_version", 103).commit();
      }
      paramContext = new QbarNative.QbarAiModelParam();
      paramContext.detect_model_bin_path_ = ((String)localObject1);
      paramContext.detect_model_param_path_ = ((String)localObject2);
      paramContext.superresolution_model_bin_path_ = ((String)localObject3);
      paramContext.superresolution_model_param_path_ = str;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("copy qbar ai model file error! ");
      ((StringBuilder)localObject1).append(paramContext.getMessage());
      b.a("ScanUtil", ((StringBuilder)localObject1).toString());
    }
    return null;
  }
  
  public static boolean getBoolean(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (NumberFormatException paramString) {}
    return paramBoolean;
  }
  
  public static double getDouble(String paramString, double paramDouble)
  {
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      double d = Double.parseDouble(paramString);
      return d;
    }
    catch (NumberFormatException paramString) {}
    return paramDouble;
  }
  
  public static float getFloat(String paramString, float paramFloat)
  {
    if (paramString == null) {
      return paramFloat;
    }
    try
    {
      float f = Float.parseFloat(paramString);
      return f;
    }
    catch (NumberFormatException paramString) {}
    return paramFloat;
  }
  
  public static int getInt(String paramString, int paramInt)
  {
    int i = paramInt;
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0) {
        return paramInt;
      }
      i = Integer.decode(paramString).intValue();
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static long getLong(String paramString, long paramLong)
  {
    long l = paramLong;
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0) {
        return paramLong;
      }
      l = Long.decode(paramString).longValue();
      return l;
    }
    catch (NumberFormatException paramString) {}
    return paramLong;
  }
  
  public static boolean isNullOrNil(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.camera.ScanUtil
 * JD-Core Version:    0.7.0.1
 */