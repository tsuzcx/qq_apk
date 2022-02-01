package com.tencent.comic.utils;

import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class VipComicUrlHelper
{
  private static Map<String, String> jdField_a_of_type_JavaUtilMap;
  private static boolean jdField_a_of_type_Boolean = false;
  private static Map<String, String> b = new HashMap();
  
  static
  {
    b.put("comicIndex", "https://qc.vip.qq.com/gc/pages/index.html?asyncMode=3");
    b.put("comicCategory", "https://qc.vip.qq.com/gc/pages/category.html?from=1006002&filter=0&categoryType=1&sort=4&_bid=354&_wv=1027&_cwv=4&_webviewtype=4&asyncMode=3&_wvx=3");
    b.put("comicGroup", "https://qc.vip.qq.com/gc/pages/user/home.html?_wv=1091118887&_wvx=3&asyncMode=3&_sharp_v=1&_sonic_xv=32&cancelColorTab=1");
    b.put("comicMore", "https://qc.vip.qq.com/gc/pages/community/square.html?_wv=3&_cwv=4&origin=1&from=10000001");
    b.put("comicPayDownload", "https://cdn.vip.qq.com/club/client/comic/release/html/payDownload.html");
    b.put("comicPayRead", "https://cdn.vip.qq.com/club/client/comic/release/html/payRead.html");
    b.put("comicDetailComic", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
    b.put("comicDetailNovel", "https://cdn.vip.qq.com/club/client/comic/release/html/detail.html");
    b.put("comicDetailVideo", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
    b.put("comicMyPic", "https://cdn.vip.qq.com/club/client/comic/release/html/my_pic.html");
    b.put("comicVideoSimple", "https://cdn.vip.qq.com/club/client/comic/release/html/video.html");
    b.put("comicReadShare", "https://cdn.vip.qq.com/club/client/comic/release/html/read_share.html");
    b.put("comicPicShare", "https://cdn.vip.qq.com/club/client/comic/release/html/pic_share.html");
    b.put("comicReport", "https://guanjia.qq.com/online_server/m_report.html");
    b.put("comicCdn", "https://imgcache.gtimg.cn/club/mobile/profile/comic_center/");
    b.put("comicFav", "https://qc.vip.qq.com/gc/pages/user/favorite.html?_wv=3&_cwv=4&asyncMode=3&_sharp_v=1&_sonic_xv=32");
    b.put("comicReaderContent", "https://cdn.vip.qq.com/club/client/comic/release/html/readerIndex.html");
    b.put("comicSearch", "https://cdn.vip.qq.com/club/client/comic/release/html/search.html?platId=109&_bid=354&pos=external&_wv=1027&from=6");
    b.put("comicBarrageList", "https://cdn.vip.qq.com/club/client/comic/release/html/bulletScreen.html");
    b.put("comicQRCode", "https://cdn.vip.qq.com/club/client/comic/release/html/redirect.html");
    b.put("comicReaderContentNew", "https://qc.vip.qq.com/gc/pages/detail/reader-index.html");
    b.put("comicNewDetailPage", "https://qc.vip.qq.com/gc/pages/detail/comicDetail.html");
    b.put("downloadDetail", "https://cdn.vip.qq.com/club/client/comic/release/html/downloadDetail.html");
    b.put("downloadPage", "https://qc.vip.qq.com/gc/pages/download.html");
  }
  
  public static String a(String paramString)
  {
    Object localObject1 = jdField_a_of_type_JavaUtilMap;
    if (localObject1 != null) {
      localObject1 = (String)((Map)localObject1).get(paramString);
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = (String)b.get(paramString);
    }
    return localObject2;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject1 = paramString1;
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString1;
      }
      if (paramString1.contains("#"))
      {
        Object localObject2 = paramString1.split("\\#");
        localObject1 = localObject2[0];
        int j = localObject2.length;
        int i = 1;
        paramString1 = "";
        StringBuilder localStringBuilder;
        while (i < j)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString1);
          localStringBuilder.append("#");
          localStringBuilder.append(localObject2[i]);
          paramString1 = localStringBuilder.toString();
          i += 1;
        }
        if (((String)localObject1).contains("?"))
        {
          localObject2 = new StringBuilder();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("?");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("&");
          ((StringBuilder)localObject2).append(((String)localObject1).replace("?", localStringBuilder.toString()));
          ((StringBuilder)localObject2).append(paramString1);
          return ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("?");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(paramString1);
        return ((StringBuilder)localObject2).toString();
      }
      if (paramString1.contains("?"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("?");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append("&");
        return paramString1.replace("?", ((StringBuilder)localObject1).toString());
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append("?");
      ((StringBuilder)localObject1).append(paramString2);
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    StringBuilder localStringBuilder;
    if ((!paramString1.isEmpty()) && (!paramString2.isEmpty()) && (!paramString3.isEmpty()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append("=[^&]*)");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append("=");
      localStringBuilder.append(paramString3);
      localObject = paramString1.replaceAll((String)localObject, localStringBuilder.toString());
    }
    else
    {
      localObject = "";
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("replaceUrlFieldValueReg url is ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("fieldName is ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",newValue is ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", newUrl is ");
      localStringBuilder.append((String)localObject);
      QLog.d("VipComicUrlHelper", 2, localStringBuilder.toString());
    }
    return localObject;
  }
  
  public static void a(Intent paramIntent)
  {
    try
    {
      boolean bool = jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      if (paramIntent == null) {
        return;
      }
      paramIntent = paramIntent.getSerializableExtra("urlMap");
      bool = paramIntent instanceof HashMap;
      if (!bool) {
        return;
      }
      paramIntent = (HashMap)paramIntent;
      bool = paramIntent.isEmpty();
      if (bool) {
        return;
      }
      if (jdField_a_of_type_JavaUtilMap == null) {
        jdField_a_of_type_JavaUtilMap = new HashMap();
      }
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_a_of_type_JavaUtilMap.putAll(paramIntent);
      jdField_a_of_type_Boolean = true;
      return;
    }
    finally {}
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null) {
      if ((paramString.indexOf("banSlideToTab=1") == -1) && (paramString.indexOf("bodong.vip.qq.com") == -1) && (paramString.indexOf("qc.vip.qq.com") == -1))
      {
        bool1 = bool2;
        if (paramString.indexOf("cdn.vip.qq.com/club/client/comic") == -1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isBoodoUrl() url is ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" isBoodo is ");
      localStringBuilder.append(bool1);
      QLog.d("VipComicUrlHelper", 2, localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (paramString1.indexOf(paramString2) == -1)
    {
      localObject = Uri.parse(paramString1).buildUpon();
      ((Uri.Builder)localObject).appendQueryParameter(paramString2, paramString3);
      localObject = ((Uri.Builder)localObject).build().toString();
    }
    else
    {
      localObject = paramString1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addUrlField url is ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("fieldName is ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",Value is ");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", newUrl is ");
      localStringBuilder.append((String)localObject);
      QLog.d("VipComicUrlHelper", 2, localStringBuilder.toString());
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.utils.VipComicUrlHelper
 * JD-Core Version:    0.7.0.1
 */