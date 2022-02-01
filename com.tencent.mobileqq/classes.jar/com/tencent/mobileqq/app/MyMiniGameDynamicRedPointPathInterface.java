package com.tencent.mobileqq.app;

import com.tencent.mobileqq.tianshu.data.BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class MyMiniGameDynamicRedPointPathInterface
  implements BusinessInfoCheckUpdateItem.DynamicRedPointPathInterface
{
  private List<String> a = new ArrayList();
  
  public List<String> getRedPointPaths(AppRuntime paramAppRuntime)
  {
    if (this.a.isEmpty()) {
      this.a.add("100077");
    }
    if (((paramAppRuntime instanceof QQAppInterface)) && (QzoneConfig.getInstance().getConfig("qqminiapp", "settingMeMiniGameEnable", 1) == 1)) {
      return this.a;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MyMiniGameDynamicRedPointPathInterface
 * JD-Core Version:    0.7.0.1
 */