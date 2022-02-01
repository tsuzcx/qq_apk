package com.tencent.mobileqq.app;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConditionSearchManager$DownloadTask
  extends AbsPreDownloadTask
{
  public File a;
  public GetResourceRespInfo a;
  
  public ConditionSearchManager$DownloadTask(QQAppInterface paramQQAppInterface, String paramString, GetResourceRespInfo paramGetResourceRespInfo, File paramFile)
  {
    super(paramQQAppInterface, paramString);
    this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo = paramGetResourceRespInfo;
    this.jdField_a_of_type_JavaIoFile = paramFile;
  }
  
  protected void realCancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask realCancel");
    }
  }
  
  protected void realStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask realStart");
    }
    String str = this.key;
    BaseQQAppInterface localBaseQQAppInterface = this.app;
    GetResourceRespInfo localGetResourceRespInfo = this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo;
    ThreadManagerV2.excute(new ConditionSearchManager.DownloadTask.1(this, str, this.jdField_a_of_type_JavaIoFile, localBaseQQAppInterface, localGetResourceRespInfo), 128, null, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DownloadTask] url=");
    localStringBuilder.append(this.key);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask
 * JD-Core Version:    0.7.0.1
 */