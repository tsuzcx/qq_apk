package com.tencent.avgame.config;

import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.config.data.AvGameLobbyConfBean;
import com.tencent.avgame.config.data.CJPreloadConfBean;
import com.tencent.mobileqq.config.QConfigManager;

public class AvGameConfigUtil
{
  public static AvGameConfBean a()
  {
    AvGameConfBean localAvGameConfBean = (AvGameConfBean)QConfigManager.b().b(642);
    if (localAvGameConfBean != null) {
      return localAvGameConfBean;
    }
    return new AvGameConfBean();
  }
  
  public static AvGameLobbyConfBean b()
  {
    AvGameLobbyConfBean localAvGameLobbyConfBean = (AvGameLobbyConfBean)QConfigManager.b().b(713);
    if (localAvGameLobbyConfBean != null) {
      return localAvGameLobbyConfBean;
    }
    return new AvGameLobbyConfBean();
  }
  
  public static CJPreloadConfBean c()
  {
    CJPreloadConfBean localCJPreloadConfBean = (CJPreloadConfBean)QConfigManager.b().b(721);
    if (localCJPreloadConfBean != null) {
      return localCJPreloadConfBean;
    }
    return new CJPreloadConfBean();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.config.AvGameConfigUtil
 * JD-Core Version:    0.7.0.1
 */