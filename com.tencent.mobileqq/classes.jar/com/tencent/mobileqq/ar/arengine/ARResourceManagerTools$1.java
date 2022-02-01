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
    ARResourceManagerTools.ARResourceCallback localARResourceCallback = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
    if (localARResourceCallback != null) {
      localARResourceCallback.a(ARResourceManagerTools.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, ARResourceDownload.DownloadInfo paramDownloadInfo)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onARResourceDownloadComplete result");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.i("AREngine_ARResourceManagerTools", 1, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
    if (localObject1 != null) {
      ((ARResourceManagerTools.ARResourceCallback)localObject1).a(paramDownloadInfo.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ARResourceDownload.DownloadInfo localDownloadInfo = (ARResourceDownload.DownloadInfo)((Iterator)localObject1).next();
        if (localDownloadInfo.jdField_a_of_type_JavaLangString.equals(paramDownloadInfo.jdField_a_of_type_JavaLangString)) {
          if (!paramDownloadInfo.jdField_a_of_type_Boolean) {}
        }
        try
        {
          System.currentTimeMillis();
          if (paramDownloadInfo.jdField_a_of_type_Int == 6)
          {
            new File(paramDownloadInfo.c);
            ArResourceConfigUtils.a(paramDownloadInfo.c, ARResouceDir.b());
          }
          else if (paramDownloadInfo.jdField_a_of_type_Int == 7)
          {
            ArResourceConfigUtils.a(paramDownloadInfo.c, ARResouceDir.a(paramDownloadInfo.b));
          }
          else
          {
            localObject2 = new File(paramDownloadInfo.c);
            String str = paramDownloadInfo.c;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(((File)localObject2).getParentFile().getAbsolutePath());
            localStringBuilder.append(File.separator);
            localStringBuilder.append(paramDownloadInfo.b);
            localStringBuilder.append(File.separator);
            ArResourceConfigUtils.a(str, localStringBuilder.toString());
          }
          QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
        }
        catch (Exception localException)
        {
          Object localObject2;
          label260:
          break label260;
        }
        new File(paramDownloadInfo.c).delete();
        QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
        paramDownloadInfo = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
        if (paramDownloadInfo != null) {
          paramDownloadInfo.a(false);
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
        QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
        return;
        this.b.remove(localDownloadInfo);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onARMarkerModelDownloadComplete  remove ");
        ((StringBuilder)localObject2).append(localDownloadInfo.jdField_a_of_type_JavaLangString);
        QLog.i("AREngine_ARResourceManagerTools", 1, ((StringBuilder)localObject2).toString());
      }
      if (this.b.size() == 0)
      {
        paramDownloadInfo = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
        if (paramDownloadInfo != null) {
          paramDownloadInfo.a(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
      }
    }
    else
    {
      paramDownloadInfo = this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback;
      if (paramDownloadInfo != null) {
        paramDownloadInfo.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceManagerTools.1
 * JD-Core Version:    0.7.0.1
 */