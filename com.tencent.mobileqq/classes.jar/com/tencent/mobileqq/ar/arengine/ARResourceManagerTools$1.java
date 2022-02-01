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
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(ARResourceManagerTools.a(this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools, paramLong1, 0));
    }
  }
  
  public void a(boolean paramBoolean, ARResourceDownload.DownloadInfo paramDownloadInfo)
  {
    QLog.i("AREngine_ARResourceManagerTools", 1, "onARResourceDownloadComplete result" + paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(paramDownloadInfo.jdField_a_of_type_Int, paramBoolean);
    }
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localDownloadInfo = (ARResourceDownload.DownloadInfo)localIterator.next();
          if (!localDownloadInfo.jdField_a_of_type_JavaLangString.equals(paramDownloadInfo.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          if (paramDownloadInfo.jdField_a_of_type_Boolean) {}
          try
          {
            System.currentTimeMillis();
            if (paramDownloadInfo.jdField_a_of_type_Int == 6)
            {
              new File(paramDownloadInfo.c);
              ArResourceConfigUtils.a(paramDownloadInfo.c, ARResouceDir.b());
            }
            for (;;)
            {
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  ");
              this.b.remove(localDownloadInfo);
              QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerModelDownloadComplete  remove " + localDownloadInfo.jdField_a_of_type_JavaLangString);
              break;
              if (paramDownloadInfo.jdField_a_of_type_Int != 7) {
                break label268;
              }
              ArResourceConfigUtils.a(paramDownloadInfo.c, ARResouceDir.a(paramDownloadInfo.b));
            }
            return;
          }
          catch (Exception localException)
          {
            new File(paramDownloadInfo.c).delete();
            QLog.i("AREngine_ARResourceManagerTools", 1, "Download end. uncompressZip error. url = ");
            if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback != null) {
              this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(false);
            }
            this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
            QLog.i("AREngine_ARResourceManagerTools", 1, "onARMarkerAllDownloadComplete  ");
          }
        }
      }
      label268:
      while (this.b.size() != 0) {
        for (;;)
        {
          ARResourceDownload.DownloadInfo localDownloadInfo;
          File localFile = new File(paramDownloadInfo.c);
          ArResourceConfigUtils.a(paramDownloadInfo.c, localFile.getParentFile().getAbsolutePath() + File.separator + paramDownloadInfo.b + File.separator);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback != null) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools$ARResourceCallback.a(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqArArengineARResourceManagerTools.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARResourceManagerTools.1
 * JD-Core Version:    0.7.0.1
 */