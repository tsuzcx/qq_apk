package com.tencent.mobileqq.bigbrother.RockDownloader;

import ajjy;
import ally;
import allz;
import android.text.TextUtils;
import atmo;
import atmp;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RockDownloader$2
  implements Runnable
{
  public RockDownloader$2(RockDownloaderTask paramRockDownloaderTask) {}
  
  public void run()
  {
    Object localObject = allz.a().a(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[] { this.a.getDownloadInfo().businessName, this.a.getDownloadInfo().packageName }, null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "result size=", Integer.valueOf(((List)localObject).size()) });
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        atmo localatmo = (atmo)((Iterator)localObject).next();
        if ((localatmo instanceof RockDownloadInfo))
        {
          RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)localatmo;
          if ((!TextUtils.isEmpty(localRockDownloadInfo.localPath)) && (new File(localRockDownloadInfo.localPath).exists()))
          {
            localArrayList.add(localRockDownloadInfo);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("RockDownloader", 2, new Object[] { "File Removed: ", localatmo.toString() });
            }
            allz.a().b(localRockDownloadInfo);
          }
        }
      }
    }
    if (this.a.getQueryAPKListener() != null)
    {
      if (localArrayList.size() > 0) {
        this.a.getQueryAPKListener().a(localArrayList);
      }
    }
    else {
      return;
    }
    this.a.getQueryAPKListener().a(this.a.getDownloadInfo(), ajjy.a(2131647699), 10002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader.2
 * JD-Core Version:    0.7.0.1
 */