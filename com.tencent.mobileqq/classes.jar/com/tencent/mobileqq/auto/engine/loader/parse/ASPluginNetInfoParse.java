package com.tencent.mobileqq.auto.engine.loader.parse;

import com.tencent.mobileqq.auto.engine.loader.ASDynamicEngine;
import com.tencent.mobileqq.auto.engine.loader.ASPluginBean;
import com.tencent.mobileqq.qqcommon.api.IFileUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ASPluginNetInfoParse
  extends ASBaseInfoParse
{
  public ASPluginNetInfoParse(ASPluginBean paramASPluginBean)
  {
    super(paramASPluginBean);
  }
  
  private boolean a(ASPluginBean paramASPluginBean)
  {
    if (paramASPluginBean == null) {
      return false;
    }
    Object localObject;
    if (paramASPluginBean.getVersionCode() != this.e)
    {
      localObject = ASDynamicEngine.a(this.d.getBusinessKey());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseNet#:version not match,config version:");
      localStringBuilder.append(paramASPluginBean.getVersionCode());
      localStringBuilder.append(" netVersion:");
      localStringBuilder.append(this.e);
      QLog.i((String)localObject, 1, localStringBuilder.toString());
      return false;
    }
    if (paramASPluginBean.getSupportMinHostVersion() > a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseNet#:version not match,host version too low supportMinHostVersion:");
      ((StringBuilder)localObject).append(paramASPluginBean.getSupportMinHostVersion());
      ((StringBuilder)localObject).append(" hostVersion:");
      ((StringBuilder)localObject).append(a());
      QLog.i("ASDynamicEngine", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    return true;
  }
  
  private boolean b(ASPluginBean paramASPluginBean)
  {
    if (paramASPluginBean == null) {
      return false;
    }
    if ((((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(paramASPluginBean.getPluginMangerApkPath())) && (((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(paramASPluginBean.getPluginZipPath())))
    {
      File localFile1 = new File(paramASPluginBean.getPluginMangerApkPath());
      File localFile2 = new File(paramASPluginBean.getPluginZipPath());
      if ((localFile1.length() == paramASPluginBean.getManagerFileLength()) && (localFile2.length() == paramASPluginBean.getZipFileLength()))
      {
        QLog.i("ASDynamicEngine", 1, "parseNet#fileLengthValid():true");
        return true;
      }
    }
    QLog.i(ASDynamicEngine.a(this.d.getBusinessKey()), 1, "parseNet#fileLengthValid():false");
    return false;
  }
  
  private ASPluginBean c()
  {
    String str1 = this.d.getPluginZipPath();
    String str2 = this.d.getPluginMangerApkPath();
    if ((((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(str1)) && (((IFileUtilsApi)QRoute.api(IFileUtilsApi.class)).fileExists(str2)) && (b(this.d)))
    {
      QLog.i(ASDynamicEngine.a(this.d.getBusinessKey()), 1, "parseNet#:net plugin has in folder");
      Object localObject = this.f;
      localObject = ASPluginInfoUnZip.b(new File(str1));
      if (!a((String)localObject, str1, "parseNet#")) {
        return null;
      }
      localObject = b(a(new File(this.f.a((String)localObject, new File(str1)), "config.json").getAbsolutePath()));
      if (!a((ASPluginBean)localObject)) {
        return null;
      }
      ((ASPluginBean)localObject).setType(this.c).setBusinessKey(this.d.getBusinessKey()).setPluginZipPath(str1).setPluginMangerApkPath(str2).setManagerFileLength(this.d.getManagerFileLength()).setZipFileLength(this.d.getZipFileLength()).setVersionCode(this.e);
      return localObject;
    }
    QLog.i(ASDynamicEngine.a(this.d.getBusinessKey()), 1, "parseNet#:net plugin not valid");
    return null;
  }
  
  public ASPluginBean b()
  {
    return c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.loader.parse.ASPluginNetInfoParse
 * JD-Core Version:    0.7.0.1
 */