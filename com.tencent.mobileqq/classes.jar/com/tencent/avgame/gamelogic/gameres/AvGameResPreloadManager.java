package com.tencent.avgame.gamelogic.gameres;

import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.CJPreloadConfBean;
import com.tencent.qphone.base.util.QLog;

public class AvGameResPreloadManager
  implements IAvGameResPreloadManager
{
  public static IAvGameResPreloadManager.ConfInfo a()
  {
    CJPreloadConfBean localCJPreloadConfBean = AvGameConfigUtil.c();
    if (localCJPreloadConfBean == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("AvGameResPreloadManager", 2, "getConfInfo SpringFestivalRedpacketPreloadConfProcessor.loadConfig null");
      }
      return new IAvGameResPreloadManager.ConfInfo();
    }
    return localCJPreloadConfBean.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResPreloadManager
 * JD-Core Version:    0.7.0.1
 */