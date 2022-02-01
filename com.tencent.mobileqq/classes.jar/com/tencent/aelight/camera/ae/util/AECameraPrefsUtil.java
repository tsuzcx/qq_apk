package com.tencent.aelight.camera.ae.util;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.config.AppSetting;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class AECameraPrefsUtil
{
  private static final List<Pair<String, Integer>> a = new LinkedList();
  
  static
  {
    a.add(new Pair("AEKIT_CAMERA_FIRST_LAUNCH", Integer.valueOf(0)));
    List localList = a;
    Integer localInteger = Integer.valueOf(4);
    localList.add(new Pair("ShadowBackendSvc.GetCategoryMaterialMqStoryCamera", localInteger));
    a.add(new Pair("ShadowBackendSvc.GetCategoryMaterialMqKuaishanCamera", localInteger));
    a.add(new Pair("ShadowBackendSvc.GetCategoryMaterialMqEmoCamera", localInteger));
    a.add(new Pair("ShadowBackendSvc.GetPlayShowCatMatTree", localInteger));
  }
  
  private AECameraPrefsUtil()
  {
    Object localObject = AECameraPrefsUtil.MultiProcessPreferences.b("key_app_version", "");
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!AppSetting.b().equals(localObject)))
    {
      localObject = a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        if (4 == ((Integer)localPair.second).intValue()) {
          AECameraPrefsUtil.MultiProcessPreferences.a((String)localPair.first);
        } else {
          AECameraPrefsUtil.DefaultPreferences.a((String)localPair.first);
        }
      }
      AECameraPrefsUtil.MultiProcessPreferences.a("key_app_version", AppSetting.b());
    }
  }
  
  public static AECameraPrefsUtil a()
  {
    return AECameraPrefsUtil.UtilInstanceHolder.a();
  }
  
  public void a(@NonNull String paramString, float paramFloat, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString, paramFloat);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString, paramFloat);
  }
  
  public void a(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString);
  }
  
  public void a(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString, paramInt1);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString, paramInt1);
  }
  
  public void a(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString, paramLong);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString, paramLong);
  }
  
  public void a(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString1, paramString2);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString1, paramString2);
  }
  
  public void a(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt)
    {
      AECameraPrefsUtil.MultiProcessPreferences.a(paramString, paramBoolean);
      return;
    }
    AECameraPrefsUtil.DefaultPreferences.a(paramString, paramBoolean);
  }
  
  public float b(@NonNull String paramString, float paramFloat, int paramInt)
  {
    if (4 == paramInt) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString, paramFloat);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString, paramFloat);
  }
  
  public int b(@NonNull String paramString, int paramInt1, int paramInt2)
  {
    if (4 == paramInt2) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString, paramInt1);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString, paramInt1);
  }
  
  public long b(@NonNull String paramString, long paramLong, int paramInt)
  {
    if (4 == paramInt) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString, paramLong);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString, paramLong);
  }
  
  @NonNull
  public SharedPreferences b()
  {
    return AECameraPrefsUtil.DefaultPreferences.a();
  }
  
  @Nullable
  public String b(@NonNull String paramString1, String paramString2, int paramInt)
  {
    if (4 == paramInt) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString1, paramString2);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString1, paramString2);
  }
  
  public boolean b(@NonNull String paramString, int paramInt)
  {
    if (4 == paramInt) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString);
  }
  
  public boolean b(@NonNull String paramString, boolean paramBoolean, int paramInt)
  {
    if (4 == paramInt) {
      return AECameraPrefsUtil.MultiProcessPreferences.b(paramString, paramBoolean);
    }
    return AECameraPrefsUtil.DefaultPreferences.b(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AECameraPrefsUtil
 * JD-Core Version:    0.7.0.1
 */