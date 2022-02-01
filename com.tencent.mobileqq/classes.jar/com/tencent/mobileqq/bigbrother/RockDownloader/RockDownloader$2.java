package com.tencent.mobileqq.bigbrother.RockDownloader;

import android.text.TextUtils;
import anvx;
import aqgd;
import aqge;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class RockDownloader$2
  implements Runnable
{
  public RockDownloader$2(RockDownloaderTask paramRockDownloaderTask) {}
  
  public void run()
  {
    Object localObject = aqge.a().query(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[] { this.a.getDownloadInfo().businessName, this.a.getDownloadInfo().packageName }, null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "result size=", Integer.valueOf(((List)localObject).size()) });
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Entity localEntity = (Entity)((Iterator)localObject).next();
        if ((localEntity instanceof RockDownloadInfo))
        {
          RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)localEntity;
          if ((!TextUtils.isEmpty(localRockDownloadInfo.localPath)) && (new VFSFile(localRockDownloadInfo.localPath).exists()))
          {
            localArrayList.add(localRockDownloadInfo);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("RockDownloader", 2, new Object[] { "File Removed: ", localEntity.toString() });
            }
            aqge.a().remove(localRockDownloadInfo);
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
    this.a.getQueryAPKListener().a(this.a.getDownloadInfo(), anvx.a(2131712949), 10002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader.2
 * JD-Core Version:    0.7.0.1
 */