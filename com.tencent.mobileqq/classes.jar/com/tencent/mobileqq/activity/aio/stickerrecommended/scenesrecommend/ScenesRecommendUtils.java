package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScenesRecommendUtils
{
  private static ScenesRecommendItem a(ScenesRecommendItem.ScenesRecConfigItem paramScenesRecConfigItem)
  {
    if ((paramScenesRecConfigItem != null) && (paramScenesRecConfigItem.b != null))
    {
      if (paramScenesRecConfigItem.b.equalsIgnoreCase("redpacket_id001")) {
        return new HongBaoScenesRecommendItem(paramScenesRecConfigItem);
      }
      return new ScenesRecommendItem(paramScenesRecConfigItem);
    }
    return null;
  }
  
  private static ScenesRecommendItem a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    Object localObject2 = paramJSONObject.optString("scene", "");
    String str4 = paramJSONObject.optString("title", "");
    String str5 = paramJSONObject.optString("sceneId", "");
    String str6 = paramJSONObject.optString("kvo", "");
    String str1 = paramJSONObject.optString("startDate", "");
    String str3 = paramJSONObject.optString("expiryDate", "");
    int i = paramJSONObject.optInt("switch");
    Object localObject1 = paramJSONObject.optJSONArray("keywords");
    ScenesRecommendItem.ScenesRecConfigItem localScenesRecConfigItem = new ScenesRecommendItem.ScenesRecConfigItem();
    localScenesRecConfigItem.c = i;
    localScenesRecConfigItem.b = str5;
    localScenesRecConfigItem.e = ((String)localObject2);
    localScenesRecConfigItem.d = str4;
    localScenesRecConfigItem.f = str6;
    if ((!StringUtil.isEmpty(str1)) && (!StringUtil.isEmpty(str3)))
    {
      localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
      try
      {
        localScenesRecConfigItem.g = ((SimpleDateFormat)localObject2).parse(str1);
        localScenesRecConfigItem.h = ((SimpleDateFormat)localObject2).parse(str3);
      }
      catch (Exception localException)
      {
        QLog.d("ScenesRecommendUtils", 2, "parse invalidTime failed!", localException);
      }
    }
    if (localObject1 != null)
    {
      localScenesRecConfigItem.a = new ArrayList();
      i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        String str2 = ((JSONArray)localObject1).optString(i);
        if (!StringUtil.isEmpty(str2)) {
          localScenesRecConfigItem.a.add(str2);
        }
        i += 1;
      }
    }
    localObject1 = a(localScenesRecConfigItem);
    if (localObject1 == null) {
      return null;
    }
    if (paramJSONObject.has("extra")) {
      try
      {
        ((ScenesRecommendItem)localObject1).a(paramJSONObject.getJSONObject("extra"));
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return new ScenesRecommendItem(localScenesRecConfigItem);
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SCENESRECOMMEND_CONTEXT");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public static List<ScenesRecommendItem> a(String paramString)
  {
    if (StringUtil.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseJson  strJson = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("ScenesRecommendUtils", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = new ArrayList();
    try
    {
      Object localObject2 = new JSONObject(paramString);
      Object localObject3;
      if (((JSONObject)localObject2).has("scenes"))
      {
        localObject2 = ((JSONObject)localObject2).getJSONArray("scenes");
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          localObject3 = a(((JSONArray)localObject2).getJSONObject(i));
          if (localObject3 != null) {
            ((List)localObject1).add(localObject3);
          }
          i += 1;
        }
      }
      return localObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("parseJson has exception strJson = ");
      ((StringBuilder)localObject3).append(paramString);
      QLog.e("ScenesRecommendUtils", 2, ((StringBuilder)localObject3).toString(), localJSONException);
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    if (paramString == null) {
      return;
    }
    SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("MOBILEQQ_SCENESRECOMMEND_CONFIG", 4).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SCENESRECOMMEND_CONTEXT");
    localStringBuilder.append(paramAppInterface.getCurrentAccountUin());
    localEditor.putString(localStringBuilder.toString(), paramString);
    localEditor.apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.ScenesRecommendUtils
 * JD-Core Version:    0.7.0.1
 */