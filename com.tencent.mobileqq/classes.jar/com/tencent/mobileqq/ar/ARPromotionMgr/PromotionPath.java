package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;
import java.util.TreeMap;

public class PromotionPath
{
  static String a = null;
  
  public static String a()
  {
    if (a == null) {
      if (!SystemUtil.a()) {
        break label56;
      }
    }
    label56:
    for (String str = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH) + "pddata/prd/" + "ar_promotion" + File.separator;; str = BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "ar_promotion" + File.separator)
    {
      a = str;
      return a;
    }
  }
  
  public static String a(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    if (paramPromotionItem == null) {
      return null;
    }
    paramPromotionItem = (PromotionConfigInfo.ZipItem)paramPromotionItem.a().get(Integer.valueOf(0));
    if (paramPromotionItem == null) {
      return null;
    }
    return a(paramPromotionItem);
  }
  
  public static String a(PromotionConfigInfo.ZipItem paramZipItem)
  {
    return paramZipItem.d + "entry" + File.separator;
  }
  
  private static String a(String paramString, int paramInt)
  {
    return a() + paramString + File.separator + paramInt + File.separator;
  }
  
  static String a(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + ".zip";
  }
  
  public static String b(PromotionConfigInfo.PromotionItem paramPromotionItem)
  {
    paramPromotionItem = (PromotionConfigInfo.ZipItem)paramPromotionItem.a().get(Integer.valueOf(0));
    if (paramPromotionItem == null) {
      return null;
    }
    return b(paramPromotionItem);
  }
  
  public static String b(PromotionConfigInfo.ZipItem paramZipItem)
  {
    return paramZipItem.d + "guide" + File.separator;
  }
  
  static final String b(String paramString1, int paramInt, String paramString2)
  {
    return a(paramString1, paramInt) + paramString2 + File.separator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionPath
 * JD-Core Version:    0.7.0.1
 */