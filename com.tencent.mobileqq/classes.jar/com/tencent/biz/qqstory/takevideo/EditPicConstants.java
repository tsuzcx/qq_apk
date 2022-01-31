package com.tencent.biz.qqstory.takevideo;

import android.content.Context;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class EditPicConstants
{
  public static String a;
  
  public static boolean a(long paramLong, Context paramContext)
  {
    boolean bool2 = true;
    if (paramLong <= 0L) {
      QLog.e("initDirs", 1, "initPicDirs uin null");
    }
    a = AppConstants.aQ + "QQEditPic" + File.separator + paramLong + File.separator;
    paramContext = new File(a);
    boolean bool3 = paramContext.mkdirs();
    boolean bool4 = paramContext.isDirectory();
    if (QLog.isColorLevel()) {
      QLog.e("initDirs", 2, "thumbFilesDirPath=" + bool3 + " isdir=" + bool4);
    }
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!bool4) {
        bool1 = false;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditPicConstants
 * JD-Core Version:    0.7.0.1
 */