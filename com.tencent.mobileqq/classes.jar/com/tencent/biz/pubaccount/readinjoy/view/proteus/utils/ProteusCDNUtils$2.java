package com.tencent.biz.pubaccount.readinjoy.view.proteus.utils;

import com.tencent.biz.common.offline.BidDownloader;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.LzmaUtils;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import nvf;
import nwj;
import nwo;
import nwp;
import tnc;

public final class ProteusCDNUtils$2
  implements Runnable
{
  public ProteusCDNUtils$2(String paramString) {}
  
  public void run()
  {
    String str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER + this.a + ".7z");
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
        String str3 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER);
        str2 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER + this.a + ".zip");
        localObject = new File(str2);
        if (((File)localObject).exists())
        {
          FileUtils.deleteFile(str2);
          QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], delete file = " + str2);
        }
        int j = LzmaUtils.a(BaseApplicationImpl.getApplication().getApplicationContext(), str1, str3);
        QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], firstUnCompressCode = " + j + ", outputFilePath = " + str3);
        i = -1;
        str1 = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH_READINJOY_OFFLINE_TEMP_FOLDER + this.a);
        if (j == 0)
        {
          nwo.a(str1);
          if (!new File(str1).mkdirs())
          {
            QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], mkdirs error.");
            return;
          }
          i = nwp.a(str2, str1);
          QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], secondUnCompressCode = " + i + ", folderPathNew = " + str1);
        }
      } while (i != 0);
      String str2 = nvf.a(this.a);
      str2 = str2 + this.a;
      ((File)localObject).renameTo(new File(str1 + "/b.zip"));
      if (!nwj.a(str1, this.a)) {
        break;
      }
      nwo.a(str2);
      bool = new File(str1).renameTo(new File(str2));
      QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], isRenameSuccess = " + bool + ", folderPathNew = " + str1 + ", targetFolderPath = " + str2);
    } while (!bool);
    tnc.b("0X800ABFF", this.a);
    return;
    QLog.i("ProteusCDNUtils", 1, "[unCompressOfflineFile], bid = " + this.a + ", folderPathNew = " + str1 + ", folder may have changed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.ProteusCDNUtils.2
 * JD-Core Version:    0.7.0.1
 */