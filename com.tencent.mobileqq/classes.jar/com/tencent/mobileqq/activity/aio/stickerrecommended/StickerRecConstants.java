package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;

public class StickerRecConstants
{
  public static final String a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append(".sticker_recommended_pics/");
    a = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String a(String paramString)
  {
    try
    {
      paramString = Utils.Crc64String(paramString);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecConstants
 * JD-Core Version:    0.7.0.1
 */