package com.tencent.biz.pubaccount.util;

import android.os.Environment;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;

public final class ScreenshotContentObserver$ScreenShotPath
{
  public static final String a;
  public static final String b;
  public static final String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(Environment.DIRECTORY_PICTURES);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Screenshots");
    localStringBuilder.append(File.separator);
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(Environment.DIRECTORY_DCIM);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Screenshots");
    localStringBuilder.append(File.separator);
    b = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(HardCodeUtil.a(2131911057));
    localStringBuilder.append(File.separator);
    c = localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ScreenshotContentObserver.ScreenShotPath
 * JD-Core Version:    0.7.0.1
 */