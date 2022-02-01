package com.tencent.av;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public class AVPathUtil
{
  private static boolean a;
  
  public static String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("qav");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = a;
    boolean bool1 = bool2;
    if (!bool2) {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (paramContext != null)
        {
          bool1 = bool2;
          if (paramContext.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0)
          {
            a = true;
            return a;
          }
        }
      }
      else
      {
        a = true;
        bool1 = a;
      }
    }
    return bool1;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("ptv_template");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (!a(paramContext))) {
      return localFile.getPath();
    }
    return Environment.getExternalStorageDirectory().getPath();
  }
  
  public static String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("new_ptv_template");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(c());
    localStringBuilder.append("new_ptv_template_usable");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("avatar2d");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String f()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(e());
    localStringBuilder.append("avatar2d_usable");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("effect");
    return localStringBuilder.toString();
  }
  
  public static String h()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("effect_material_config");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String i()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h());
    localStringBuilder.append("pendant");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String j()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i());
    localStringBuilder.append("pendant_update_template.json");
    return localStringBuilder.toString();
  }
  
  public static String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h());
    localStringBuilder.append("face");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String l()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(k());
    localStringBuilder.append("face_update_template.json");
    return localStringBuilder.toString();
  }
  
  public static String m()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(h());
    localStringBuilder.append("avatar2d");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(m());
    localStringBuilder.append("avatar_2d_update_template.json");
    return localStringBuilder.toString();
  }
  
  public static String o()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("funcall");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String p()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("beauty");
    localStringBuilder.append(File.separator);
    return localStringBuilder.toString();
  }
  
  public static String q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("av_image_data");
    localStringBuilder.append(File.separator);
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("av_report_record_dir");
    return VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
  }
  
  public static String s()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(BaseApplication.getContext()));
    localStringBuilder.append("/tencent/msflogs/com/tencent/mobileqq/");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.AVPathUtil
 * JD-Core Version:    0.7.0.1
 */