package com.tencent.mobileqq.activity.qwallet.preload;

import android.text.TextUtils;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

public class PreloadResource$RealTimeDownloadListener
  extends PreloadResource.DownloadListenerWrapper
{
  public PreloadResource$RealTimeDownloadListener(DownloadListener paramDownloadListener)
  {
    super(paramDownloadListener);
  }
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "RealTime onDoneFile|" + paramDownloadTask.jdField_a_of_type_Int + "|" + paramDownloadTask.jdField_a_of_type_JavaLangString + "|" + ((File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString)).getAbsolutePath());
    }
    File localFile;
    if ((paramDownloadTask.jdField_a_of_type_Int == 0) && (paramDownloadTask.jdField_a_of_type_JavaUtilMap != null) && (!TextUtils.isEmpty(paramDownloadTask.jdField_a_of_type_JavaLangString)))
    {
      localFile = (File)paramDownloadTask.jdField_a_of_type_JavaUtilMap.get(paramDownloadTask.jdField_a_of_type_JavaLangString);
      if (localFile != null) {
        break label161;
      }
    }
    label161:
    for (String str = "";; str = localFile.getAbsolutePath())
    {
      str = MD5Coding.encodeFile2HexStr(str);
      if ((localFile != null) && (localFile.exists()) && (!TextUtils.isEmpty(str))) {
        ResUtil.a(paramDownloadTask.jdField_a_of_type_JavaLangString, str, NetConnInfoCenter.getServerTimeMillis());
      }
      super.onDoneFile(paramDownloadTask);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadResource.RealTimeDownloadListener
 * JD-Core Version:    0.7.0.1
 */