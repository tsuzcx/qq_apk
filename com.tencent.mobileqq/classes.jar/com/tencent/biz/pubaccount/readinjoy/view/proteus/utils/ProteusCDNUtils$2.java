package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import aljq;
import bdcs;
import bduw;
import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import ncb;
import ndl;
import ndq;
import ndr;
import sgl;

public final class ProteusCDNUtils$2
  implements Runnable
{
  public ProteusCDNUtils$2(String paramString) {}
  
  public void run()
  {
    String str1 = bduw.a(aljq.cE + this.a + ".7z");
    if (!new File(str1).exists()) {
      QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], bid = " + this.a + ", file does not exist.");
    }
    boolean bool;
    do
    {
      Object localObject;
      int i;
      do
      {
        return;
        localObject = BidDownloader.a(str1);
        QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], fileFormat = " + (String)localObject);
        String str3 = bduw.a(aljq.cE);
        str2 = bduw.a(aljq.cE + this.a + ".zip");
        localObject = new File(str2);
        if (((File)localObject).exists())
        {
          bdcs.d(str2);
          QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], delete file = " + str2);
        }
        int j = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), str1, str3);
        QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], firstUnCompressCode = " + j + ", outputFilePath = " + str3);
        i = -1;
        str1 = bduw.a(aljq.cE + this.a);
        if (j == 0)
        {
          ndq.a(str1);
          if (!new File(str1).mkdirs())
          {
            QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], mkdirs error.");
            return;
          }
          i = ndr.a(str2, str1);
          QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], secondUnCompressCode = " + i + ", folderPathNew = " + str1);
        }
      } while (i != 0);
      String str2 = ncb.a(this.a);
      str2 = str2 + this.a;
      ((File)localObject).renameTo(new File(str1 + "/b.zip"));
      if (!ndl.a(str1, this.a)) {
        break;
      }
      ndq.a(str2);
      bool = new File(str1).renameTo(new File(str2));
      QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], isRenameSuccess = " + bool + ", folderPathNew = " + str1 + ", targetFolderPath = " + str2);
    } while (!bool);
    sgl.b("0X800ABFF", this.a);
    return;
    QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], bid = " + this.a + ", folderPathNew = " + str1 + ", folder may have changed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils.2
 * JD-Core Version:    0.7.0.1
 */