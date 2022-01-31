package com.tencent.mobileqq.app;

import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;
import yyj;

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
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "DownloadTask realStart");
    }
    String str = this.d;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    GetResourceRespInfo localGetResourceRespInfo = this.jdField_a_of_type_ProtocolKQQConfigGetResourceRespInfo;
    localQQAppInterface.a(new yyj(this, str, this.jdField_a_of_type_JavaIoFile, localQQAppInterface, localGetResourceRespInfo));
  }
  
  public String toString()
  {
    return "[DownloadTask] url=" + this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask
 * JD-Core Version:    0.7.0.1
 */