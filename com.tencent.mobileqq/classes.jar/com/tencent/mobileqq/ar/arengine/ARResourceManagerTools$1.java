package com.tencent.mobileqq.ar.arengine;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

class ARResourceManagerTools$1
  implements ARResourceDownload.ARResourceDownloadCallback
{
  ARResourceManagerTools$1(ARResourceManagerTools paramARResourceManagerTools, ARResourceManagerTools.ARResourceCallback paramARResourceCallback, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    ARResourceManagerTools.ARResourceCallback localARResourceCallback = this.a;
    if (localARResourceCallback != null) {
      localARResourceCallback.a(ARResourceManagerTools.a(this.d, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, ARResourceDownload.DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onARResourceDownloadComplete result");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.i("AREngine_ARResourceManagerTools", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.a;
    if (localObject1 != null) {
      ((ARResourceManagerTools.ARResourceCallback)localObject1).a(paramDownloadInfo.a, paramBoolean);
    }
    if (paramBoolean)
    {
      localObject1 = this.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ARResourceDownload.DownloadInfo localDownloadInfo = (ARResourceDownload.DownloadInfo)((Iterator)localObject1).next();
        if (localDownloadInfo.b.equals(paramDownloadInfo.b)) {
          if (!paramDownloadInfo.e) {}
        }
        try
        {
          System.currentTimeMillis();
          if (paramDownloadInfo.a == 6)
          {
            new File(paramDownloadInfo.d);
            ArResourceConfigUtils.b(paramDownloadInfo.d, ARResouceDir.b());
          }
          else if (paramDownloadInfo.a == 7)
          {
            ArResourceConfigUtils.b(paramDownloadInfo.d, ARResouceDir.a(paramDownloadInfo.c));
          }
          else
          {
            localObject2 = new File(paramDownloadInfo.d);
            String str = paramDownloadInfo.d;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((File)localObject2).getParentFile().getAbsolutePath());
            localStringBuilder.append(File.separator);
            localStringBuilder.append(paramDownloadInfo.c);
            localStringBuilder.append(File.separator);
            ArResourceConfigUtils.b(str, localStringBuilder.toString());
          }
          QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
        }
        catch (Exception localException)
        {
          Object localObject2;
          label260:
          break label260;
        }
        new File(paramDownloadInfo.d).delete();
        QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
        paramDownloadInfo = this.a;
        if (paramDownloadInfo != null) {
          paramDownloadInfo.a(false);
        }
        this.d.a();
        QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
        return;
        this.c.remove(localDownloadInfo);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onARMarkerModelDownloadComplete  remove ");
        ((StringBuilder)localObject2).append(localDownloadInfo.b);
        QLog.i("AREngine_ARResourceManagerTools", 1, ((StringBuilder)localObject2).toString());
      }
      if (this.c.size() == 0)
      {
        paramDownloadInfo = this.a;
        if (paramDownloadInfo != null) {
          paramDownloadInfo.a(true);
        }
        this.d.a();
      }
    }
    else
    {
      paramDownloadInfo = this.a;
      if (paramDownloadInfo != null) {
        paramDownloadInfo.a(false);
      }
      this.d.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceManagerTools.1
 * JD-Core Version:    0.7.0.1
 */