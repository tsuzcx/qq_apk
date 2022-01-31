package com.tencent.mobileqq.bigbrother.RockDownloader;

import ajyc;
import amam;
import aman;
import android.text.TextUtils;
import aukm;
import aukn;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.data.RockDownloadInfo;
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
    Object localObject = aman.a().a(RockDownloadInfo.class, true, "businessName=? AND packageName=?", new String[] { this.a.getDownloadInfo().businessName, this.a.getDownloadInfo().packageName }, null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RockDownloader", 2, new Object[] { "result size=", Integer.valueOf(((List)localObject).size()) });
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        aukm localaukm = (aukm)((Iterator)localObject).next();
        if ((localaukm instanceof RockDownloadInfo))
        {
          RockDownloadInfo localRockDownloadInfo = (RockDownloadInfo)localaukm;
          if ((!TextUtils.isEmpty(localRockDownloadInfo.localPath)) && (new VFSFile(localRockDownloadInfo.localPath).exists()))
          {
            localArrayList.add(localRockDownloadInfo);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("RockDownloader", 2, new Object[] { "File Removed: ", localaukm.toString() });
            }
            aman.a().b(localRockDownloadInfo);
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
    this.a.getQueryAPKListener().a(this.a.getDownloadInfo(), ajyc.a(2131713487), 10002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloader.2
 * JD-Core Version:    0.7.0.1
 */