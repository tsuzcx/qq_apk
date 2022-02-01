package com.tencent.biz.subscribe;

import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;

public class SubscribeConstants
{
  public static final String a;
  public static final HashMap<String, String> a;
  public static final String[] a;
  public static final String b;
  public static final HashMap<String, String> b;
  public static final String c;
  public static final HashMap<String, String> c;
  public static final String d;
  private static final String e = VFSAssistantUtils.getSDKPrivatePath("cache/");
  private static final String f = VFSAssistantUtils.getSDKPrivatePath("qsubscribe/");
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append("file/");
    jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(f);
    ((StringBuilder)localObject).append("cache/");
    jdField_b_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("animation/");
    jdField_c_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(e);
    ((StringBuilder)localObject).append("tencent_sdk_download/");
    d = ((StringBuilder)localObject).toString();
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_a_of_type_JavaUtilHashMap.put("follow_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/follow_guide_pics.zip");
    jdField_a_of_type_JavaUtilHashMap.put("praise_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/praise_guide_pics.zip");
    localObject = jdField_b_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_c_of_type_JavaLangString);
    localStringBuilder.append("follow_guide_pics");
    localStringBuilder.append(File.separator);
    ((HashMap)localObject).put("follow_guide_pics", localStringBuilder.toString());
    localObject = jdField_b_of_type_JavaUtilHashMap;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_c_of_type_JavaLangString);
    localStringBuilder.append("praise_guide_pics");
    localStringBuilder.append(File.separator);
    ((HashMap)localObject).put("praise_guide_pics", localStringBuilder.toString());
    jdField_c_of_type_JavaUtilHashMap.put("follow_guide_pics", "KEY_SUBSCRIBE_FOLLOW_GUIDE_DOWNLOAD_URL");
    jdField_c_of_type_JavaUtilHashMap.put("praise_guide_pics", "KEY_SUBSCRIBE_FOLLOW_PRAISE_DOWNLOAD_URL");
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "follow_guide_pics", "praise_guide_pics" };
  }
  
  public static String a(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/openshop/%s?_proxy=1&_wv=3", new Object[] { paramString });
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = String.format("https://h5.qzone.qq.com/subscription/addgoods/%s?_proxy=1&_wv=3", new Object[] { paramString1 });
    paramString1 = str;
    if (paramString2 != null)
    {
      paramString1 = str;
      if (!StringUtil.a(paramString2))
      {
        paramString1 = new StringBuilder();
        paramString1.append(str);
        paramString1.append("&id=");
        paramString1.append(URLEncoder.encode(paramString2));
        paramString1 = paramString1.toString();
      }
    }
    return paramString1;
  }
  
  public static String b(String paramString)
  {
    return "https://h5.qzone.qq.com/subscription/morerecommend/{uin}?_proxy=1&_wv=3&_p=".replace("{uin}", paramString);
  }
  
  public static String c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QSUSCRIBE_DOWNLOAD_ROOT_PATH");
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append("   getSDKPrivatePath realPath=");
      localStringBuilder.append(paramString);
      QLog.d("SubscribeConstants", 4, localStringBuilder.toString());
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.SubscribeConstants
 * JD-Core Version:    0.7.0.1
 */