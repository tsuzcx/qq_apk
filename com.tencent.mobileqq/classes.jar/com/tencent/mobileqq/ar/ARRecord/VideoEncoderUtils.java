package com.tencent.mobileqq.ar.ARRecord;

import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.av.ui.funchat.record.FileSwapHelper;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.text.SimpleDateFormat;

public class VideoEncoderUtils
{
  public static String a()
  {
    String str = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
    return str + "/Camera/ARVideoRecord.tmp";
  }
  
  public static boolean a()
  {
    return (Build.VERSION.SDK_INT >= 18) && (ScanEntranceDPC.a().d);
  }
  
  public static String b()
  {
    String str = ShortVideoUtils.c();
    str = str + new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Long.valueOf(System.currentTimeMillis()));
    str = str + FileSwapHelper.a;
    File localFile = new File(str).getParentFile();
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.VideoEncoderUtils
 * JD-Core Version:    0.7.0.1
 */