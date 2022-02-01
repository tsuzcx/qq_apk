package com.tencent.biz.qqcircle.publish.util;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

public class ImageQualityPreference
{
  private static ImageQualityPreference a;
  
  public static ImageQualityPreference a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ImageQualityPreference();
        }
      }
      finally {}
    }
    return a;
  }
  
  public int a(int paramInt, LocalMediaInfo paramLocalMediaInfo)
  {
    if (paramInt != 1) {
      paramInt = 2;
    } else {
      paramInt = QCircleConfigHelper.a("PhotoUpload", "MoodUploadQualityForVideoQcircle", Integer.valueOf(3)).intValue();
    }
    boolean bool1;
    if (paramInt != 3) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1)
    {
      paramInt = Math.max(paramLocalMediaInfo.mediaWidth, paramLocalMediaInfo.mediaHeight);
      if (paramInt > 1920) {
        bool1 = true;
      }
      QLog.d("[upload2]ImageQualityPreference", 1, new Object[] { "getUploadVideoQualityForOther... media Size:", Integer.valueOf(paramInt), " videoSize:", Integer.valueOf(1920), " isNeedCompress:", Boolean.valueOf(bool1) });
      bool2 = bool1;
    }
    if (bool2) {
      return 2;
    }
    return 3;
  }
  
  public int a(int paramInt, ArrayList<String> paramArrayList, HashMap<String, LocalMediaInfo> paramHashMap)
  {
    int i = 1;
    if (paramInt != 1) {
      paramInt = 2;
    } else {
      paramInt = QCircleConfigHelper.a("PhotoUpload", "MoodUploadQualityForPicQcircle", Integer.valueOf(3)).intValue();
    }
    if (paramInt != 3) {
      paramInt = i;
    } else {
      paramInt = 0;
    }
    if (paramInt != 0) {
      return 2;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.util.ImageQualityPreference
 * JD-Core Version:    0.7.0.1
 */