package com.tencent.av.opengl.effects;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVNetEngine;
import com.tencent.av.AVPathUtil;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.opengl.config.BeautyConfigParser;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class EffectBeautyTools
{
  private static float jdField_a_of_type_Float = -1.0F;
  private static int jdField_a_of_type_Int;
  private static final String jdField_a_of_type_JavaLangString = AVPathUtil.i() + "SKINCOLOR" + File.separator;
  
  static
  {
    jdField_a_of_type_Int = 0;
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
        AVLog.printColorLog("EffectBeautyTools", "mBeautyRatio:" + jdField_a_of_type_Float);
      }
      catch (Exception localException)
      {
        AVLog.printColorLog("EffectBeautyTools", "getNewBeautyRatio Exception:" + localException);
        jdField_a_of_type_Float = 1.0F;
        continue;
      }
      return jdField_a_of_type_Float;
      jdField_a_of_type_Float = 1.0F;
    }
  }
  
  private static EffectBeautyTools.SkinColorFilterDesc a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      AVLog.printColorLog("EffectBeautyTools", "parseConfig|content is empty.");
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
          AVLog.printColorLog("EffectBeautyTools", "parseConfig:" + i + "|" + str1 + "|" + str2);
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
        AVLog.printColorLog("EffectBeautyTools", "parseConfig failed. info = " + localJSONObject);
        return localSkinColorFilterDesc;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
        AVLog.printColorLog("EffectBeautyTools", "parseConfig|parse failed.context = " + paramString);
        return localSkinColorFilterDesc;
      }
    }
  }
  
  private static void a()
  {
    SharedPreferences.Editor localEditor = EffectConfigBase.a(180, EffectConfigBase.c).edit();
    localEditor.putInt("qav_effect_beauty_config_first_launch", 1);
    localEditor.commit();
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (b())
      {
        a();
        if (new File(jdField_a_of_type_JavaLangString).exists()) {
          FileUtils.a(jdField_a_of_type_JavaLangString);
        }
      }
      paramContext = a(EffectConfigBase.b(180, EffectConfigBase.c));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)))
      {
        Object localObject = new File(jdField_a_of_type_JavaLangString + "params.json");
        AVLog.printColorLog("EffectBeautyTools", "preDownloadResource :" + ((File)localObject).exists());
        if (!((File)localObject).exists())
        {
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new EffectBeautyTools.MyHttpListener();
          ((HttpNetReq)localObject).mReqUrl = paramContext.jdField_a_of_type_JavaLangString;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          ((HttpNetReq)localObject).mOutPath = (AVPathUtil.i() + "skin_color.zip");
          ((HttpNetReq)localObject).setUserData(paramContext);
          AVNetEngine.a().sendReq((NetReq)localObject);
        }
      }
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    a(paramContext, paramString, EffectConfigBase.b(180, EffectConfigBase.c));
    EffectConfigBase.a(180, EffectConfigBase.c, paramInt, paramString);
    if (paramBoolean) {
      a(paramContext);
    }
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
        FileUtils.a(jdField_a_of_type_JavaLangString);
      }
      while ((paramString1 == null) || (paramContext.b.equals(paramString1.b))) {
        return;
      }
      FileUtils.a(jdField_a_of_type_JavaLangString);
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
        if ((localBeautyConfigParser == null) || (!localBeautyConfigParser.a()) || (!c())) {
          continue;
        }
        jdField_a_of_type_Int = 2;
        AVLog.printColorLog("EffectBeautyTools", "mIsSupportFlag:" + jdField_a_of_type_Int);
      }
      catch (Exception localException)
      {
        AVLog.printColorLog("EffectBeautyTools", "isSupportNewBeauty Exception:" + localException);
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
  
  private static boolean b()
  {
    boolean bool = false;
    int i = EffectConfigBase.a(180, EffectConfigBase.c).getInt("qav_effect_beauty_config_first_launch", 0);
    AVLog.printColorLog("EffectBeautyTools", "getIsFirstLauncher:" + i);
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  private static boolean c()
  {
    int i = EffectConfigBase.c(180, EffectConfigBase.c);
    return (new File(jdField_a_of_type_JavaLangString + "params.json").exists()) && (i != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectBeautyTools
 * JD-Core Version:    0.7.0.1
 */