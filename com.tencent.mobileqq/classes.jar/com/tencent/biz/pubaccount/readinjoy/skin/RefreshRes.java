package com.tencent.biz.pubaccount.readinjoy.skin;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class RefreshRes
{
  private static int jdField_a_of_type_Int = 0;
  private static String jdField_a_of_type_JavaLangString = "";
  private static List jdField_a_of_type_JavaUtilList;
  private static String b;
  private static String c;
  
  public static int a()
  {
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    return jdField_a_of_type_Int;
  }
  
  public static String a()
  {
    return AppConstants.aJ + ".readInjoy/refresh_res/";
  }
  
  public static String a(String paramString)
  {
    return AppConstants.aJ + ".readInjoy/refresh_res/" + paramString;
  }
  
  public static List a()
  {
    Object localObject3 = null;
    Object localObject2;
    if (jdField_a_of_type_JavaUtilList != null)
    {
      localObject2 = jdField_a_of_type_JavaUtilList;
      return localObject2;
    }
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    Object localObject1;
    if (jdField_a_of_type_Int == 1) {
      localObject1 = new File(c() + "refreshAnimatePictures" + "/");
    }
    for (;;)
    {
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = localObject3;
      if (!((File)localObject1).exists()) {
        break;
      }
      localObject2 = localObject3;
      if (!((File)localObject1).isDirectory()) {
        break;
      }
      localObject1 = ((File)localObject1).listFiles();
      localObject2 = localObject3;
      if (localObject1 == null) {
        break;
      }
      localObject2 = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i < localObject1.length)
        {
          if (localObject1[i].getName().endsWith(".png")) {
            ((List)localObject2).add(localObject1[i].getName());
          }
          i += 1;
          continue;
          if (jdField_a_of_type_Int != 2) {
            break label199;
          }
          localObject1 = new File(c() + "refreshRandomPictures" + "/");
          break;
        }
      }
      jdField_a_of_type_JavaUtilList = (List)localObject2;
      return localObject2;
      label199:
      localObject1 = null;
    }
  }
  
  public static void a()
  {
    Object localObject = null;
    try
    {
      String str = FileUtils.b(new File(c() + "refreshConfig.json"));
      localObject = str;
      JSONObject localJSONObject = new JSONObject(str);
      if (localJSONObject != null)
      {
        localObject = str;
        jdField_a_of_type_Int = localJSONObject.optInt("refresh_type");
        localObject = str;
        b = localJSONObject.optString("voice_path");
        localObject = str;
        c = localJSONObject.optString("rain_animate_path");
      }
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("RefreshRes", 1, "parseRefreshParaJson error json = " + localIOException);
      localJSONException.printStackTrace();
    }
  }
  
  static void a(String paramString)
  {
    if (!jdField_a_of_type_JavaLangString.equals(paramString))
    {
      jdField_a_of_type_JavaLangString = paramString;
      b();
    }
  }
  
  public static boolean a(String paramString)
  {
    return SceneBuilder.a(new File(a(paramString)));
  }
  
  public static String b()
  {
    return AppConstants.aJ + ".readInjoy/refresh_res/" + jdField_a_of_type_JavaLangString;
  }
  
  private static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RefreshRes", 2, "clearDataAfterSetRefreshInfo()");
    }
    jdField_a_of_type_Int = 0;
    b = null;
    c = null;
    jdField_a_of_type_JavaUtilList = null;
  }
  
  public static String c()
  {
    return b() + "/" + "refresh" + "/";
  }
  
  public static String d()
  {
    if ((TextUtils.isEmpty(b)) && (jdField_a_of_type_Int == 0)) {
      a();
    }
    if (!TextUtils.isEmpty(b)) {
      return c() + b;
    }
    return null;
  }
  
  public static String e()
  {
    if ((TextUtils.isEmpty(c)) && (jdField_a_of_type_Int == 0)) {
      a();
    }
    if (!TextUtils.isEmpty(c)) {
      return c() + c;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.RefreshRes
 * JD-Core Version:    0.7.0.1
 */