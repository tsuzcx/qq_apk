package com.tencent.mobileqq.ar.ARRecord;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.ui.funchat.record.FileSwapHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.text.SimpleDateFormat;

public class VideoEncoderUtils
{
  public static String a()
  {
    String str = BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/AR/ARVideoRecord.tmp");
    return localStringBuilder.toString();
  }
  
  public static boolean a()
  {
    return (Build.VERSION.SDK_INT >= 18) && (ScanEntranceDPC.a().d) && (!Build.MODEL.equalsIgnoreCase("CAM-TL00"));
  }
  
  public static String b()
  {
    String str = ShortVideoUtils.getCameraPath();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis())));
    str = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(FileSwapHelper.a);
    str = ((StringBuilder)localObject).toString();
    localObject = new File(str).getParentFile();
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils
 * JD-Core Version:    0.7.0.1
 */