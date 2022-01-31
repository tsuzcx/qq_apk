package com.tencent.biz.pubaccount.readinjoy.skin;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.surfaceviewaction.builder.SceneBuilder;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CommonSkinRes
  extends BaseSkinRes
{
  private static int jdField_a_of_type_Int = 0;
  private static String jdField_a_of_type_JavaLangString = "";
  private static List jdField_a_of_type_JavaUtilList;
  private static JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private static String b;
  private static String c;
  
  public static String a()
  {
    return AppConstants.aJ + ".readInjoy/skin_res/";
  }
  
  public static String a(String paramString)
  {
    return AppConstants.aJ + ".readInjoy/skin_res/" + paramString;
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
  
  public static JSONObject a()
  {
    if (jdField_a_of_type_OrgJsonJSONObject == null) {}
    try
    {
      jdField_a_of_type_OrgJsonJSONObject = new JSONObject(FileUtils.b(new File(b() + "/colors.json")));
      return jdField_a_of_type_OrgJsonJSONObject;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
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
      QLog.e("CommonSkinRes", 1, "parseRefreshParaJson error json = " + localIOException);
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
  
  public static int b()
  {
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    return jdField_a_of_type_Int;
  }
  
  public static String b()
  {
    return AppConstants.aJ + ".readInjoy/skin_res/" + jdField_a_of_type_JavaLangString;
  }
  
  private static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonSkinRes", 2, "clearDataAfterSetSkin()");
    }
    jdField_a_of_type_Int = 0;
    b = null;
    c = null;
    jdField_a_of_type_JavaUtilList = null;
    jdField_a_of_type_OrgJsonJSONObject = null;
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
  
  public int a(String paramString)
  {
    JSONObject localJSONObject = a();
    if (localJSONObject == null) {
      return 0;
    }
    return Color.parseColor(localJSONObject.optString(paramString));
  }
  
  public Drawable a(Resources paramResources, String paramString1, String paramString2)
  {
    paramResources = new CommonSkinRes.SkinStateListDrawable();
    paramResources.a = a(paramString1);
    paramResources.b = a(paramString2);
    paramString1 = paramResources.b;
    paramResources.addState(new int[] { 16842913 }, paramString1);
    paramString1 = paramResources.b;
    paramResources.addState(new int[] { 16842912 }, paramString1);
    paramString1 = paramResources.a;
    paramResources.addState(new int[] { -16842919 }, paramString1);
    return paramResources;
  }
  
  public Drawable a(String paramString)
  {
    Object localObject2 = b() + "/" + paramString;
    Object localObject1 = new File((String)localObject2 + ".gif");
    paramString = (String)localObject1;
    if (!((File)localObject1).exists())
    {
      localObject1 = new File((String)localObject2 + ".png");
      paramString = (String)localObject1;
      if (!((File)localObject1).exists())
      {
        paramString = new File((String)localObject2 + ".jpg");
        if (!paramString.exists()) {
          break label219;
        }
      }
    }
    localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = Utils.a(paramString.getAbsolutePath());
    localObject2 = new ColorDrawable(0);
    ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
    ((URLDrawable.URLDrawableOptions)localObject1).mUseAutoScaleParams = true;
    ((URLDrawable.URLDrawableOptions)localObject1).mUseMemoryCache = false;
    label219:
    label228:
    for (;;)
    {
      try
      {
        paramString = paramString.toURL();
        if (!((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage) {
          break label228;
        }
        paramString = new URL("readinjoy_skin_gif", paramString.getAuthority(), paramString.getFile());
        paramString = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
      return new ColorDrawable(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.skin.CommonSkinRes
 * JD-Core Version:    0.7.0.1
 */