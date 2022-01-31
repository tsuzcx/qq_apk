import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class aphm
  extends aowi
{
  aphm(aphl paramaphl, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aphl.a())
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= vk [CS Replay]id[" + String.valueOf(aphl.a(this.jdField_a_of_type_Aphl).nSessionId) + "] but isStoped");
      return;
    }
    this.jdField_a_of_type_Aphl.a.d();
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Aphl.a.b(paramLong1);
      this.jdField_a_of_type_Aphl.a(null, 0);
      return;
    }
    if (!bbfj.d(BaseApplication.getContext()))
    {
      aphl.a(this.jdField_a_of_type_Aphl).a();
      this.jdField_a_of_type_Aphl.a(null, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.fileSize = aphl.a(this.jdField_a_of_type_Aphl).fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.isSupportHttps = false;
    paramInt = paramShort;
    if (apei.b(aphl.a(this.jdField_a_of_type_Aphl)))
    {
      paramInt = paramShort;
      if (paramBundle != null)
      {
        paramString6 = paramBundle.getString("strHttpsDomain");
        short s = paramBundle.getShort("httpsPort", (short)0);
        paramInt = paramShort;
        if (!TextUtils.isEmpty(paramString6))
        {
          paramShort = s;
          if (s == 0) {
            paramShort = 443;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.isSupportHttps = true;
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.sslCName = paramString6;
          paramInt = paramShort;
        }
      }
    }
    if ((TextUtils.isEmpty(paramString3)) || (paramByteStringMicro == null))
    {
      if ((paramLong1 == -6101L) || (paramLong1 == -7003L)) {
        aphl.a(this.jdField_a_of_type_Aphl).status = 16;
      }
      if (paramLong1 == 0L)
      {
        this.jdField_a_of_type_Aphl.a.a.b = 9048L;
        this.jdField_a_of_type_Aphl.a.a.a = 2L;
        this.jdField_a_of_type_Aphl.a.a(5);
        this.jdField_a_of_type_Aphl.a.a(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aphl.a(null, (int)paramLong1);
        return;
        this.jdField_a_of_type_Aphl.a.c(paramLong1);
      }
    }
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(aphl.a(this.jdField_a_of_type_Aphl).nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      aphl.a(this.jdField_a_of_type_Aphl).a().a(aphl.a(this.jdField_a_of_type_Aphl).uniseq, aphl.a(this.jdField_a_of_type_Aphl).nSessionId, aphl.a(this.jdField_a_of_type_Aphl).peerUin, aphl.a(this.jdField_a_of_type_Aphl).peerType, 4, null, (int)paramLong1, paramString1);
    }
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = new ArrayList();
    }
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "get lstUrl size:" + paramString1.size());
    paramByteStringMicro = new ArrayList();
    paramString1 = paramString1.iterator();
    while (paramString1.hasNext()) {
      paramByteStringMicro.add(new ExcitingTransferHostInfo((String)paramString1.next(), paramInt));
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.mHosts = ((ExcitingTransferHostInfo[])paramByteStringMicro.toArray(new ExcitingTransferHostInfo[paramByteStringMicro.size()]));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.strCookie = ("Cookie:t=0;v=" + AppSetting.a() + ";" + paramString2 + ";\r\n");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.serverPath = paramString4;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.strTempFilePath = this.jdField_a_of_type_Aphl.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.strFileName = paramString5;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.strSaveFileDir = aphl.a(this.jdField_a_of_type_Aphl).b();
    aphl.a(this.jdField_a_of_type_Aphl).status = 2;
    this.jdField_a_of_type_Aphl.a.e();
    aphl.a(this.jdField_a_of_type_Aphl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphm
 * JD-Core Version:    0.7.0.1
 */