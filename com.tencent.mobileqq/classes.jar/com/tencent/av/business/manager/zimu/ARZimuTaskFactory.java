package com.tencent.av.business.manager.zimu;

import android.content.Context;
import com.tencent.av.AVLog;
import com.tencent.av.app.VideoAppInterface;

public class ARZimuTaskFactory
{
  public static ARZimuTask a(VideoAppInterface paramVideoAppInterface, Context paramContext, String paramString)
  {
    VideoAppInterface localVideoAppInterface = null;
    AVLog.c("ARZimuTaskFactory", "ARZimuTaskFactory: " + paramString);
    if ("spit".equals(paramString))
    {
      paramVideoAppInterface = new SpitZimuTask(paramVideoAppInterface);
      localVideoAppInterface = paramVideoAppInterface;
      if ((paramContext instanceof SpitZimuTask.IMouthDetector))
      {
        ((SpitZimuTask)paramVideoAppInterface).a((SpitZimuTask.IMouthDetector)paramContext);
        localVideoAppInterface = paramVideoAppInterface;
      }
    }
    return localVideoAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.business.manager.zimu.ARZimuTaskFactory
 * JD-Core Version:    0.7.0.1
 */