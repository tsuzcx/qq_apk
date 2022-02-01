package com.tencent.av.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class GAudioSoundUtil
{
  public static String a()
  {
    File localFile = BaseApplication.getContext().getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("GAudioSoundUtil", 2, "[sound_early] getFilesDir is null");
      }
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localFile.getParent());
    localStringBuilder.append("/qav/sound_early/");
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GAudioSoundUtil", 2, "[sound_early] trigger early download");
    }
    Object localObject2 = a();
    Object localObject1 = new File((String)localObject2, "qav_gaudio_muted.mp3");
    File localFile = new File((String)localObject2, "qav_gaudio_cancel_muted.mp3");
    localObject2 = new File((String)localObject2, "qav_peer_phone_calling.mp3");
    if ((!((File)localObject1).exists()) || (!localFile.exists()) || (!((File)localObject2).exists()))
    {
      localObject1 = new Intent("tencent.video.v2q.downloadGAudioSound");
      ((Intent)localObject1).setPackage(paramContext.getPackageName());
      paramContext.sendBroadcast((Intent)localObject1);
    }
  }
  
  public static boolean a(String paramString)
  {
    return new File(a(), paramString).exists();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.GAudioSoundUtil
 * JD-Core Version:    0.7.0.1
 */