package com.tencent.mobileqq.armap.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.armap.ARMapManager;
import com.tencent.mobileqq.armap.ArMapInterface;
import com.tencent.mobileqq.armap.ResDownloadHandler.RDHandler;
import com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam;
import com.tencent.mobileqq.armap.utils.ARResUtil;
import com.tencent.mobileqq.portal.PortalUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ARMapRDHandler
  implements ResDownloadHandler.RDHandler
{
  private String a;
  
  public ARMapRDHandler(AppInterface paramAppInterface)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramAppInterface != null) {
      if ((paramAppInterface instanceof QQAppInterface))
      {
        localObject1 = ((ARMapConfigManager)paramAppInterface.getManager(189)).a();
        if (localObject1 == null) {
          break label126;
        }
        this.a = ((ARMapConfig)localObject1).pccBid;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMapRDHandler", 2, "pccDir:" + this.a);
      }
      return;
      localObject1 = localObject2;
      if (!(paramAppInterface instanceof ArMapInterface)) {
        break;
      }
      localObject1 = ((ARMapManager)paramAppInterface.getManager(209)).a(true);
      break;
      localObject1 = localObject2;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ARMapRDHandler", 2, "app is null");
      localObject1 = localObject2;
      break;
      label126:
      if (QLog.isColorLevel()) {
        QLog.d("ARMapRDHandler", 2, "config is null");
      }
    }
  }
  
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if ((paramDownloadParam.a instanceof BaseCheckHandler.ItemConfig)) {
      return ((BaseCheckHandler.ItemConfig)paramDownloadParam.a).c;
    }
    return ARResUtil.a() + File.separator + paramDownloadParam.b;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    String str = b(paramDownloadParam);
    try
    {
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.d("ARMapRDHandler", 2, "needDownload.file exist|" + bool + "|" + paramDownloadParam + "|" + str);
      }
      if (!bool) {
        return true;
      }
    }
    catch (Throwable paramDownloadParam)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARMapRDHandler", 2, "isNeedDownload.exception happen.e=" + paramDownloadParam.getMessage());
      }
      paramDownloadParam.printStackTrace();
    }
    return false;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    return true;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    if ((paramDownloadParam.a instanceof BaseCheckHandler.ItemConfig)) {
      return ((BaseCheckHandler.ItemConfig)paramDownloadParam.a).e;
    }
    return ARResUtil.a + File.separator + this.a + File.separator + paramDownloadParam.b;
  }
  
  public boolean b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    boolean bool = true;
    String str = PortalUtils.a(b(paramDownloadParam));
    if (!paramDownloadParam.b.equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ARMapRDHandler", 1, "checkDownloadFile.verify failed|" + str + "|" + paramDownloadParam);
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.config.ARMapRDHandler
 * JD-Core Version:    0.7.0.1
 */