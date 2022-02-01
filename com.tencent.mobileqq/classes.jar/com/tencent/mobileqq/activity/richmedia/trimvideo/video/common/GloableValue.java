package com.tencent.mobileqq.activity.richmedia.trimvideo.video.common;

import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.mediadevice.StorageManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class GloableValue
{
  public static long a;
  public static Context a;
  public static String a;
  
  static
  {
    jdField_a_of_type_AndroidContentContext = MobileQQ.getContext();
    jdField_a_of_type_Long = -1L;
  }
  
  public static void a()
  {
    try
    {
      ((AudioManager)MobileQQ.getContext().getSystemService("audio")).requestAudioFocus(null, 3, 1);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a(long paramLong)
  {
    long l = jdField_a_of_type_Long;
    if ((l > 0L) && (l == paramLong)) {
      return true;
    }
    Object localObject = StorageManager.a().a();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(File.separator);
    localStringBuilder.append("cover");
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramLong);
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    localObject = new File(jdField_a_of_type_JavaLangString);
    if ((!((File)localObject).mkdirs()) && (!((File)localObject).isDirectory()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("make cover dir: ");
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" failed.");
      QLog.e("GloableValue", 2, ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  public static void b()
  {
    try
    {
      ((AudioManager)MobileQQ.getContext().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.common.GloableValue
 * JD-Core Version:    0.7.0.1
 */