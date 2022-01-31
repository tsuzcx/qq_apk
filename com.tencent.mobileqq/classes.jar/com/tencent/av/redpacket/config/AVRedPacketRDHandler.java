package com.tencent.av.redpacket.config;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.armap.ResDownloadHandler.DefaultRDHandler;
import com.tencent.mobileqq.armap.ResDownloadManager.DownloadParam;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AVRedPacketRDHandler
  extends ResDownloadHandler.DefaultRDHandler
{
  public static String a()
  {
    if (SystemUtil.a()) {
      return AppConstants.aJ + "pddata/prd/" + "av_redpacket";
    }
    return BaseApplicationImpl.getApplication().getFilesDir() + "/pddata/prd/" + "av_redpacket";
  }
  
  public String a(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    paramDownloadParam = a() + File.separator + paramDownloadParam.b + File.separator;
    if (QLog.isColorLevel()) {
      QLog.d("AVRedPacketRDHandler", 2, "getUnzipDirPath dir = " + paramDownloadParam);
    }
    return paramDownloadParam;
  }
  
  public boolean a(ResDownloadManager.DownloadParam paramDownloadParam, boolean paramBoolean)
  {
    long l1 = -1L;
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramDownloadParam.a)
    {
      long l3 = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4).getLong(paramDownloadParam.b, -1L);
      paramDownloadParam = new File(a(paramDownloadParam));
      paramBoolean = bool2;
      if (paramDownloadParam.exists())
      {
        long l2 = paramDownloadParam.lastModified();
        l1 = l2;
        paramBoolean = bool2;
        if (l3 > 0L)
        {
          l1 = l2;
          paramBoolean = bool2;
          if (l3 != l2)
          {
            paramBoolean = false;
            l1 = l2;
          }
        }
      }
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("AVRedPacketRDHandler", 2, "verifyUnzipDir result = " + paramBoolean + ",recordedModifyTime = " + l3 + ",realModifyTime = " + l1);
        bool1 = paramBoolean;
      }
    }
    return bool1;
  }
  
  public String b(ResDownloadManager.DownloadParam paramDownloadParam)
  {
    return a() + File.separator + paramDownloadParam.b + ".end";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.redpacket.config.AVRedPacketRDHandler
 * JD-Core Version:    0.7.0.1
 */