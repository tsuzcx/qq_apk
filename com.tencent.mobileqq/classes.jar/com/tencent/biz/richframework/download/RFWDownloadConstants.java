package com.tencent.biz.richframework.download;

import com.tencent.mobileqq.vfs.VFSAssistantUtils;

public class RFWDownloadConstants
{
  private static final String APP_CACHE_PRIVATE_ROOT_PATH = VFSAssistantUtils.getSDKPrivatePath("cache/");
  private static final String APP_FILE_PRIVATE_ROOT_PATH = VFSAssistantUtils.getSDKPrivatePath("file/");
  public static final String RFW_CACHE_PRIVATE_ROOT_PATH = RFW_PRIVATE_ROOT_PATH + "cache/";
  public static final String RFW_DOWNLOAD_STRATEGY = "RichFrameWorkStrategy";
  public static final String RFW_FILE_PRIVATE_ROOT_PATH;
  public static final String RFW_PRIVATE_ROOT_PATH = VFSAssistantUtils.getSDKPrivatePath("rfw/");
  
  static
  {
    RFW_FILE_PRIVATE_ROOT_PATH = RFW_PRIVATE_ROOT_PATH + "file/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloadConstants
 * JD-Core Version:    0.7.0.1
 */