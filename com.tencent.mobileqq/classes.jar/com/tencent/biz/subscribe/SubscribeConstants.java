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
  public static final String b;
  public static final String c;
  public static final String d;
  public static final HashMap<String, String> e;
  public static final HashMap<String, String> f;
  public static final HashMap<String, String> g;
  public static final String[] h = { "follow_guide_pics", "praise_guide_pics" };
  private static final String i = VFSAssistantUtils.getSDKPrivatePath("cache/");
  private static final String j = VFSAssistantUtils.getSDKPrivatePath("qsubscribe/");
  
  static
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("file/");
    a = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append("cache/");
    b = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a);
    ((StringBuilder)localObject).append("animation/");
    c = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("tencent_sdk_download/");
    d = ((StringBuilder)localObject).toString();
    e = new HashMap();
    f = new HashMap();
    g = new HashMap();
    e.put("follow_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/follow_guide_pics.zip");
    e.put("praise_guide_pics", "https://down.qq.com/video_story/certified_account/animation_pics/praise_guide_pics.zip");
    localObject = f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("follow_guide_pics");
    localStringBuilder.append(File.separator);
    ((HashMap)localObject).put("follow_guide_pics", localStringBuilder.toString());
    localObject = f;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(c);
    localStringBuilder.append("praise_guide_pics");
    localStringBuilder.append(File.separator);
    ((HashMap)localObject).put("praise_guide_pics", localStringBuilder.toString());
    g.put("follow_guide_pics", "KEY_SUBSCRIBE_FOLLOW_GUIDE_DOWNLOAD_URL");
    g.put("praise_guide_pics", "KEY_SUBSCRIBE_FOLLOW_PRAISE_DOWNLOAD_URL");
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
      if (!StringUtil.isEmpty(paramString2))
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
    localStringBuilder.append(a);
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("QSUSCRIBE_DOWNLOAD_ROOT_PATH");
      localStringBuilder.append(a);
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