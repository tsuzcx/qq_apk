package com.tencent.mobileqq.app;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import protocol.KQQConfig.GetResourceRespInfo;

public class ConditionSearchManager$DownloadTask
  extends AbsPreDownloadTask
{
  public GetResourceRespInfo a;
  public File b;
  
  public ConditionSearchManager$DownloadTask(QQAppInterface paramQQAppInterface, String paramString, GetResourceRespInfo paramGetResourceRespInfo, File paramFile)
  {
    super(paramQQAppInterface, paramString);
    this.a = paramGetResourceRespInfo;
    this.b = paramFile;
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
    GetResourceRespInfo localGetResourceRespInfo = this.a;
    ThreadManagerV2.excute(new ConditionSearchManager.DownloadTask.1(this, str, this.b, localBaseQQAppInterface, localGetResourceRespInfo), 128, null, true);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[DownloadTask] url=");
    localStringBuilder.append(this.key);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.DownloadTask
 * JD-Core Version:    0.7.0.1
 */