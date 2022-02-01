package com.tencent.av;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import java.io.File;

public class AVPathUtil
{
  public static String a()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "qav" + File.separator);
  }
  
  public static String b()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "ptv_template" + File.separator);
  }
  
  public static String c()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "new_ptv_template" + File.separator);
  }
  
  public static String d()
  {
    return c() + "new_ptv_template_usable" + File.separator;
  }
  
  public static String e()
  {
    return a() + "effect" + File.separator;
  }
  
  public static String f()
  {
    return a() + "effect";
  }
  
  public static String g()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "funcall" + File.separator);
  }
  
  public static String h()
  {
    if (SystemUtil.a()) {}
    for (String str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);; str1 = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath())
    {
      String str2 = str1;
      if (str1 != null)
      {
        str2 = str1;
        if (!str1.endsWith(File.separator)) {
          str2 = str1 + File.separator;
        }
      }
      return str2 + "pddata/prd/" + "av_redpacket" + File.separator;
    }
  }
  
  public static String i()
  {
    return a() + "beauty" + File.separator;
  }
  
  public static String j()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "av_image_data" + File.separator);
  }
  
  public static String k()
  {
    return VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "av_report_record_dir");
  }
  
  public static String l()
  {
    return BaseApplicationImpl.getLogExternalPath(BaseApplicationImpl.getContext()) + "/tencent/msflogs/com/tencent/mobileqq/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.AVPathUtil
 * JD-Core Version:    0.7.0.1
 */