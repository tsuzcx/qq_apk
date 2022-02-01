package com.tencent.mobileqq.auto.engine.loader.parse;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ASPluginDebugInfoParse
  extends ASBaseInfoParse
{
  private ASPluginBean c()
  {
    QLog.i(ASDynamicEngine.a(this.d.getBusinessKey()), 1, "parseTest# not debugVersion return");
    return null;
  }
  
  public ASPluginBean b()
  {
    ASPluginBean localASPluginBean = c();
    if (localASPluginBean != null)
    {
      Object localObject = this.f;
      localObject = ASPluginInfoUnZip.b(new File(localASPluginBean.getPluginZipPath()));
      File localFile = this.f.a((String)localObject, new File(localASPluginBean.getPluginZipPath()));
      if (!a((String)localObject, localASPluginBean.getPluginZipPath(), "parseTest#")) {
        return null;
      }
      localASPluginBean.setUnZipPath(localFile.getAbsolutePath());
      localASPluginBean.setUUid(b(a(new File(localFile, "config.json").getAbsolutePath())).getUUid());
      if (a((String)localObject, localASPluginBean.getPluginZipPath(), "parseTest#")) {
        QLog.i(ASDynamicEngine.a(this.d.getBusinessKey()), 1, "parseTest# unzip success");
      }
    }
    return localASPluginBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.parse.ASPluginDebugInfoParse
 * JD-Core Version:    0.7.0.1
 */