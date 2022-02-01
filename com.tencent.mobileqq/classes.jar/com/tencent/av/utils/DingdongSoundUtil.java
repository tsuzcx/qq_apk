package com.tencent.av.utils;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class DingdongSoundUtil
{
  public static String a()
  {
    File localFile = BaseApplicationImpl.sApplication.getFilesDir();
    if (localFile == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("DingdongSoundUtil", 2, "[sound_early] getFilesDir is null");
      }
      return "";
    }
    return localFile.getParent() + "/dingdong/sound_early/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.DingdongSoundUtil
 * JD-Core Version:    0.7.0.1
 */