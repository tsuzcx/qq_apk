package com.tencent.mobileqq.ar.ARPromotionMgr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;
import java.util.TreeMap;

public class PromotionPath
{
  static String a;
  
  public static String a()
  {
    if (a == null)
    {
      Object localObject;
      if (SystemUtil.a())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
        ((StringBuilder)localObject).append("pddata/prd/");
        ((StringBuilder)localObject).append("ar_promotion");
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getFilesDir());
        ((StringBuilder)localObject).append("/pddata/prd/");
        ((StringBuilder)localObject).append("ar_promotion");
        ((StringBuilder)localObject).append(File.separator);
        localObject = ((StringBuilder)localObject).toString();
      }
      a = (String)localObject;
    }
    return a;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramZipItem.d);
    localStringBuilder.append("entry");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramString);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramInt);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  static String a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramString1, paramInt));
    localStringBuilder.append(paramString2);
    localStringBuilder.append(".zip");
    return localStringBuilder.toString();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramZipItem.d);
    localStringBuilder.append("guide");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  static final String b(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramString1, paramInt));
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.PromotionPath
 * JD-Core Version:    0.7.0.1
 */