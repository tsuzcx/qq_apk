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

class aphi
  extends aowe
{
  aphi(aphh paramaphh, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo) {}
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aphh.a())
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= vk [CS Replay]id[" + String.valueOf(aphh.a(this.jdField_a_of_type_Aphh).nSessionId) + "] but isStoped");
      return;
    }
    this.jdField_a_of_type_Aphh.a.d();
    if (!paramBoolean)
    {
      this.jdField_a_of_type_Aphh.a.b(paramLong1);
      this.jdField_a_of_type_Aphh.a(null, 0);
      return;
    }
    if (!bbev.d(BaseApplication.getContext()))
    {
      aphh.a(this.jdField_a_of_type_Aphh).a();
      this.jdField_a_of_type_Aphh.a(null, 0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.fileSize = aphh.a(this.jdField_a_of_type_Aphh).fileSize;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.isSupportHttps = false;
    paramInt = paramShort;
    if (apee.b(aphh.a(this.jdField_a_of_type_Aphh)))
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
        aphh.a(this.jdField_a_of_type_Aphh).status = 16;
      }
      if (paramLong1 == 0L)
      {
        this.jdField_a_of_type_Aphh.a.a.b = 9048L;
        this.jdField_a_of_type_Aphh.a.a.a = 2L;
        this.jdField_a_of_type_Aphh.a.a(5);
        this.jdField_a_of_type_Aphh.a.a(false);
      }
      for (;;)
      {
        this.jdField_a_of_type_Aphh.a(null, (int)paramLong1);
        return;
        this.jdField_a_of_type_Aphh.a.c(paramLong1);
      }
    }
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(aphh.a(this.jdField_a_of_type_Aphh).nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      aphh.a(this.jdField_a_of_type_Aphh).a().a(aphh.a(this.jdField_a_of_type_Aphh).uniseq, aphh.a(this.jdField_a_of_type_Aphh).nSessionId, aphh.a(this.jdField_a_of_type_Aphh).peerUin, aphh.a(this.jdField_a_of_type_Aphh).peerType, 4, null, (int)paramLong1, paramString1);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.strTempFilePath = this.jdField_a_of_type_Aphh.b();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.strFileName = paramString5;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadReqInfo.strSaveFileDir = aphh.a(this.jdField_a_of_type_Aphh).b();
    aphh.a(this.jdField_a_of_type_Aphh).status = 2;
    this.jdField_a_of_type_Aphh.a.e();
    aphh.a(this.jdField_a_of_type_Aphh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aphi
 * JD-Core Version:    0.7.0.1
 */