package com.tencent.av.opengl.effects;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.av.AVLog;
import com.tencent.av.AVNetEngine;
import com.tencent.av.AVPathUtil;
import com.tencent.av.utils.QAVConfigUtils;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

public class EffectBeautyTools
{
  private static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AVPathUtil.l());
    localStringBuilder.append("SKINCOLOR");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
  }
  
  private static EffectBeautyTools.SkinColorFilterDesc a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      AVLog.printColorLog("EffectBeautyTools", "parseConfig|content is empty.");
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString).getJSONObject("skinColorFilter");
      try
      {
        int i = Integer.valueOf(localJSONObject.getString("filterid")).intValue();
        String str1 = localJSONObject.getString("resurl");
        String str2 = localJSONObject.getString("md5");
        localObject2 = new EffectBeautyTools.SkinColorFilterDesc(i, str1, str2);
        try
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("parseConfig:");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append("|");
          ((StringBuilder)localObject1).append(str2);
          AVLog.printColorLog("EffectBeautyTools", ((StringBuilder)localObject1).toString());
          return localObject2;
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = localObject2;
        }
        localObject2 = localObject1;
      }
      catch (JSONException localJSONException3) {}
      localJSONException3.printStackTrace();
      localObject2 = localObject1;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localObject2 = localObject1;
      localStringBuilder2.append("parseConfig failed. info = ");
      localObject2 = localObject1;
      localStringBuilder2.append(localJSONObject);
      localObject2 = localObject1;
      AVLog.printColorLog("EffectBeautyTools", localStringBuilder2.toString());
      return localObject1;
    }
    catch (JSONException localJSONException1)
    {
      localJSONException1.printStackTrace();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("parseConfig|parse failed.context = ");
      localStringBuilder1.append(paramString);
      AVLog.printColorLog("EffectBeautyTools", localStringBuilder1.toString());
    }
    return localObject2;
  }
  
  private static void a()
  {
    SharedPreferences.Editor localEditor = QAVConfigUtils.a(180, QAVConfigUtils.b).edit();
    localEditor.putInt("qav_effect_beauty_config_first_launch", 1);
    localEditor.commit();
  }
  
  public static void a(Context paramContext)
  {
    try
    {
      if (a())
      {
        a();
        if (new File(a).exists()) {
          FileUtils.deleteDirectory(a);
        }
      }
      paramContext = a(QAVConfigUtils.a(180, QAVConfigUtils.b));
      if ((paramContext != null) && (!TextUtils.isEmpty(paramContext.a)))
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(a);
        ((StringBuilder)localObject).append("params.json");
        localObject = new File(((StringBuilder)localObject).toString());
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preDownloadResource :");
        localStringBuilder.append(((File)localObject).exists());
        AVLog.printColorLog("EffectBeautyTools", localStringBuilder.toString());
        if (!((File)localObject).exists())
        {
          localObject = new HttpNetReq();
          ((HttpNetReq)localObject).mCallback = new EffectBeautyTools.MyHttpListener();
          ((HttpNetReq)localObject).mReqUrl = paramContext.a;
          ((HttpNetReq)localObject).mHttpMethod = 0;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(AVPathUtil.l());
          localStringBuilder.append("skin_color.zip");
          ((HttpNetReq)localObject).mOutPath = localStringBuilder.toString();
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
    a(paramContext, paramString, QAVConfigUtils.a(180, QAVConfigUtils.b));
    QAVConfigUtils.a(180, QAVConfigUtils.b, paramInt, paramString);
    if (paramBoolean) {
      a(paramContext);
    }
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2)
  {
    boolean bool = TextUtils.isEmpty(paramString1);
    Object localObject = null;
    if (!bool) {
      paramContext = a(paramString1);
    } else {
      paramContext = null;
    }
    paramString1 = localObject;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = a(paramString2);
    }
    if (paramContext == null)
    {
      FileUtils.deleteDirectory(a);
      return;
    }
    if ((paramString1 != null) && (!paramContext.b.equals(paramString1.b))) {
      FileUtils.deleteDirectory(a);
    }
  }
  
  private static boolean a()
  {
    Object localObject = QAVConfigUtils.a(180, QAVConfigUtils.b);
    boolean bool = false;
    int i = ((SharedPreferences)localObject).getInt("qav_effect_beauty_config_first_launch", 0);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getIsFirstLauncher:");
    ((StringBuilder)localObject).append(i);
    AVLog.printColorLog("EffectBeautyTools", ((StringBuilder)localObject).toString());
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.effects.EffectBeautyTools
 * JD-Core Version:    0.7.0.1
 */