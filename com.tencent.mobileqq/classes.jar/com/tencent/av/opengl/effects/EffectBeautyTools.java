package com.tencent.av.opengl.effects;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVNetEngine;
import com.tencent.av.opengl.config.BeautyConfigParser;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.io.IOException;
import jjn;
import org.json.JSONException;
import org.json.JSONObject;

public class EffectBeautyTools
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  public static final String a;
  private static final String b = AppConstants.aJ + "qav" + File.separator + "beauty" + File.separator;
  private static final String c = b + "SKINCOLOR" + File.separator;
  
  static
  {
    jdField_a_of_type_JavaLangString = b;
  }
  
  public static float a()
  {
    if (jdField_a_of_type_Float != -1.0F) {
      return jdField_a_of_type_Float;
    }
    for (;;)
    {
      try
      {
        BeautyConfigParser localBeautyConfigParser = BeautyConfigParser.a();
        if (localBeautyConfigParser == null) {
          continue;
        }
        jdField_a_of_type_Float = localBeautyConfigParser.a();
        AVLog.c("EffectBeautyTools", "mBeautyRatio:" + jdField_a_of_type_Float);
      }
      catch (Exception localException)
      {
        AVLog.c("EffectBeautyTools", "getNewBeautyRatio Exception:" + localException);
        jdField_a_of_type_Float = 1.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 1.0F;
    }
  }
  
  public static int a(Context paramContext)
  {
    if (TextUtils.isEmpty(a(paramContext))) {
      return 0;
    }
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qav_effect_beauty_config_version", 0);
    AVLog.c("EffectBeautyTools", "getVideoEffectBeautyConfigVersion:" + i);
    return i;
  }
  
  private static EffectBeautyTools.SkinColorFilterDesc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.c("EffectBeautyTools", "parseConfig|content is empty.");
      return null;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      }
      catch (JSONException localJSONException3)
      {
        JSONObject localJSONObject;
        int i;
        String str1;
        String str2;
        localSkinColorFilterDesc = null;
        continue;
      }
      try
      {
        i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        str1 = localJSONObject.getString("resurl");
        str2 = localJSONObject.getString("md5");
        localSkinColorFilterDesc = new EffectBeautyTools.SkinColorFilterDesc(i, str1, str2);
        try
        {
          AVLog.c("EffectBeautyTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
          return localSkinColorFilterDesc;
        }
        catch (JSONException localJSONException1) {}
      }
      catch (JSONException localJSONException4)
      {
        localSkinColorFilterDesc = null;
        continue;
      }
      try
      {
        localJSONException1.printStackTrace();
        AVLog.c("EffectBeautyTools", "parseConfig failed. info = " + localJSONObject);
        return localSkinColorFilterDesc;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        AVLog.c("EffectBeautyTools", "parseConfig|parse failed.context = " + paramString);
        return localSkinColorFilterDesc;
      }
    }
  }
  
  public static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(b + "beauty_config.json");
      AVLog.c("EffectBeautyTools", "getVideoEffectBeautyConfig:" + b + "beauty_config.json" + "|" + localFile.exists());
      if (localFile.exists()) {
        return FileUtils.b(localFile);
      }
      a(paramContext, 0);
      return null;
    }
    catch (IOException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (a(paramContext))
      {
        b(paramContext);
        if (new File(c).exists()) {
          FileUtils.a(c);
        }
      }
      paramContext = a(a(paramContext));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(c + "params.json");
        AVLog.c("EffectBeautyTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = new jjn();
          ((HttpNetReq)localObject).jdField_a_of_type_JavaLangString = paramContext.jdField_a_of_type_JavaLangString;
          ((HttpNetReq)localObject).jdField_a_of_type_Int = 0;
          ((HttpNetReq)localObject).c = (b + "skin_color.zip");
          ((HttpNetReq)localObject).a(paramContext);
          AVNetEngine.a().a((NetReq)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    AVLog.c("EffectBeautyTools", "setVideoEffectBeautyConfigVersion:" + paramInt);
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_version", paramInt);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      AVLog.c("EffectBeautyTools", "updateVideoEffectBeautyConfig error ");
    }
    do
    {
      return;
      a(paramContext, paramString, a(paramContext));
      FileUtils.a(b, "beauty_config.json", paramString);
      a(paramContext, paramInt);
    } while (!paramBoolean);
    a(paramContext);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    if (!TextUtils.isEmpty(paramString1)) {}
    for (paramContext = a(paramString1);; paramContext = null)
    {
      paramString1 = localObject;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = a(paramString2);
      }
      if (paramContext == null) {
        FileUtils.a(c);
      }
      while ((paramString1 == null) || (paramContext.b.equals(paramString1.b))) {
        return;
      }
      FileUtils.a(c);
      return;
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int != 0) {
      return jdField_a_of_type_Int == 2;
    }
    for (;;)
    {
      try
      {
        BeautyConfigParser localBeautyConfigParser = BeautyConfigParser.a();
        if ((localBeautyConfigParser == null) || (!localBeautyConfigParser.a()) || (!b())) {
          continue;
        }
        jdField_a_of_type_Int = 2;
        AVLog.c("EffectBeautyTools", "mIsSupportFlag:" + jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        AVLog.c("EffectBeautyTools", "isSupportNewBeauty Exception:" + localException);
        jdField_a_of_type_Int = 1;
        continue;
      }
      if (jdField_a_of_type_Int == 2) {
        break;
      }
      return false;
      jdField_a_of_type_Int = 1;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = false;
    int i = PreferenceManager.getDefaultSharedPreferences(paramContext).getInt("qav_effect_beauty_config_first_launch", 0);
    AVLog.c("EffectBeautyTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static void b(Context paramContext)
  {
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext).edit();
    paramContext.putInt("qav_effect_beauty_config_first_launch", 1);
    paramContext.commit();
  }
  
  private static boolean b()
  {
    return (new File(c + "params.json").exists()) && (new File(b + "beauty_config.json").exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectBeautyTools
 * JD-Core Version:    0.7.0.1
 */