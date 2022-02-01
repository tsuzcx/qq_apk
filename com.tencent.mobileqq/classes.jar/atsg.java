import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atsg
  extends atse
{
  private int jdField_a_of_type_Int = 0;
  atsf jdField_a_of_type_Atsf;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FileManagerEntity jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  boolean jdField_a_of_type_Boolean = false;
  long b;
  
  public atsg(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Long = 0L;
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download for C2CFileDownloader");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atsf.a.jdField_a_of_type_JavaLangString = auea.f(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    this.jdField_a_of_type_Atsf.a.d = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Atsf.a.jdField_b_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType;
    try
    {
      this.jdField_a_of_type_Atsf.a.c = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, paramQQAppInterface.toString());
    }
  }
  
  private int a(int paramInt)
  {
    int i;
    if ((paramInt == 300) || (paramInt == 301) || (paramInt == 302) || (paramInt == 303) || (paramInt == 400) || (paramInt == 402) || (paramInt == 403)) {
      if (AppNetConnInfo.isNetSupport())
      {
        i = paramInt;
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isLogin()) {}
      }
      else
      {
        i = 9004;
      }
    }
    do
    {
      return i;
      if ((paramInt == 501) || (paramInt == 502) || (paramInt == 503)) {
        break;
      }
      i = paramInt;
    } while (paramInt != 505);
    if (SystemUtil.isExistSDCard()) {}
    for (long l = SystemUtil.getSDCardAvailableSize() * 1024L;; l = SystemUtil.getSystemAvailableSize() * 1024L)
    {
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize <= l) {
        break;
      }
      return 506;
    }
  }
  
  private void a(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (paramExcitingTransferOneSlotComplete == null) {
      return;
    }
    String str = "";
    if (this.jdField_a_of_type_Atsf.a != null) {
      str = String.valueOf(this.jdField_a_of_type_Atsf.a.c);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("param_fromType", 1);
    localBundle.putInt("param_V6SelectType", this.jdField_a_of_type_Int);
    localBundle.putInt("param_ipAddrType", aufd.b(paramExcitingTransferOneSlotComplete.m_strIp));
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localBundle.putInt("param_ishttps", i);
      if (paramInt == 0) {
        break;
      }
      auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDownDetail", this.jdField_b_of_type_Long, paramExcitingTransferOneSlotComplete.m_strIp, str, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, "", paramExcitingTransferOneSlotComplete.m_DownloadedSize, paramExcitingTransferOneSlotComplete.m_DownloadedSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, paramExcitingTransferOneSlotComplete.m_strIp, "", 0, "", null, localBundle);
      return;
    }
    auea.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDownDetail", paramExcitingTransferOneSlotComplete.m_TotalTimes, paramExcitingTransferOneSlotComplete.m_strIp, str, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramExcitingTransferOneSlotComplete.m_DownloadedSize, paramExcitingTransferOneSlotComplete.m_DownloadedSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, 0, null, localBundle);
  }
  
  private void a(List<String> paramList1, String paramString, int paramInt, List<String> paramList2, boolean paramBoolean)
  {
    if ((paramList1 == null) || (!atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1)))
    {
      this.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Atsf.b(this.jdField_a_of_type_Int);
      return;
    }
    if ((paramBoolean) && (paramList2 != null) && (paramList2.size() > 0))
    {
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. is config enable IPv6. v6ipsize[" + paramList2.size() + "]");
      paramString = atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, paramList2);
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (atlb.a())
        {
          QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download. debugIsDisableIPv4OnDoubleStack");
          paramList1.clear();
        }
        paramList1.addAll(0, paramString);
        this.jdField_a_of_type_Int = 2;
        QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download use IPv6. iplist:" + paramList1.toString());
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Atsf.b(this.jdField_a_of_type_Int);
      return;
      this.jdField_a_of_type_Int = 1;
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline mediaplatform exciting download use IPv4");
      continue;
      if (!TextUtils.isEmpty(paramString))
      {
        QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. is config enable IPv6. domain[" + paramString + "]");
        paramString = new atlc(paramString, paramInt);
        paramString = atlb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, 1);
        if ((paramString != null) && (!paramString.a()))
        {
          if (atlb.a())
          {
            QLog.d("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download. debugIsDisableIPv4OnDoubleStack");
            paramList1.clear();
          }
          atlb.a(paramString.jdField_a_of_type_JavaUtilList, paramList1, true, true);
          this.jdField_a_of_type_Int = 2;
          if (paramString.jdField_a_of_type_Int == 1) {
            this.jdField_a_of_type_Int = 3;
          }
          QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv6. iplist:" + paramList1.toString());
        }
        else
        {
          this.jdField_a_of_type_Int = 1;
          QLog.i("C2CFileDownloader<FileAssistant>", 1, "[IPv6-File] offline exciting download use IPv4");
        }
      }
      else
      {
        this.jdField_a_of_type_Int = 1;
      }
    }
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  protected atrt a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atsf = new atsf(paramQQAppInterface);
    return this.jdField_a_of_type_Atsf;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  protected void a(ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (paramExcitingTransferDownloadCompletedInfo == null) {
      return;
    }
    paramExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo.m_strFileSavePath;
    auea.a(paramExcitingTransferDownloadCompletedInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = auea.a(paramExcitingTransferDownloadCompletedInfo);
    int i = paramExcitingTransferDownloadCompletedInfo.length() - this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - i) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - i);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(paramExcitingTransferDownloadCompletedInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = auea.a(paramExcitingTransferDownloadCompletedInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = auea.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = atrr.a(auea.c(paramExcitingTransferDownloadCompletedInfo));
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = atrr.a(auea.a(paramExcitingTransferDownloadCompletedInfo));
      }
    }
    VFSFile localVFSFile = new VFSFile(paramExcitingTransferDownloadCompletedInfo);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = localVFSFile.lastModified();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = bcrg.a();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 11, new Object[] { paramExcitingTransferDownloadCompletedInfo, "", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), "", "" }, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      aues.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      aues.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      aues.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      auea.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        auea.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
  }
  
  protected void a(ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Atsf.c();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, false, new atsh(this, paramExcitingTransferDownloadReqInfo));
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 12, null, 6, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
  }
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, String paramString5, Bundle paramBundle, ExcitingTransferDownloadReqInfo paramExcitingTransferDownloadReqInfo)
  {
    if (a()) {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= vk [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] but isStoped");
    }
    int i;
    do
    {
      return;
      this.jdField_a_of_type_Atsf.d();
      if (!paramBoolean1)
      {
        this.jdField_a_of_type_Atsf.b(paramLong);
        a(null, 0);
        return;
      }
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        this.jdField_a_of_type_Atrt.a();
        a(null, 0);
        return;
      }
      paramExcitingTransferDownloadReqInfo.fileSize = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      paramExcitingTransferDownloadReqInfo.isSupportHttps = false;
      i = paramShort;
      if (atpj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
      {
        i = paramShort;
        if (paramBundle != null)
        {
          String str = paramBundle.getString("strHttpsDomain");
          short s = paramBundle.getShort("httpsPort", (short)0);
          i = paramShort;
          if (!TextUtils.isEmpty(str))
          {
            paramShort = s;
            if (s == 0) {
              paramShort = 443;
            }
            paramExcitingTransferDownloadReqInfo.isSupportHttps = true;
            paramExcitingTransferDownloadReqInfo.sslCName = str;
            i = paramShort;
          }
        }
      }
      this.jdField_a_of_type_Boolean = paramExcitingTransferDownloadReqInfo.isSupportHttps;
      this.jdField_a_of_type_Atsf.c(this.jdField_a_of_type_Boolean);
    } while (a(paramLong, paramByteStringMicro, paramString3));
    if ((paramLong != 0L) && (paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("C2CFileDownloader<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramString1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, (int)paramLong, paramString1);
    }
    if (paramList == null) {}
    for (paramString1 = new ArrayList();; paramString1 = paramList)
    {
      paramString1.add(0, paramString3);
      paramByteStringMicro = "";
      paramString3 = null;
      if (paramBundle != null)
      {
        paramByteStringMicro = paramBundle.getString("IPv6Dns", "");
        paramString3 = paramBundle.getStringArrayList("ipv6list");
      }
      a(paramString1, paramByteStringMicro, i, paramString3, paramBoolean2);
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "get lstUrl size:" + paramString1.size());
      paramByteStringMicro = new ArrayList();
      paramString1 = paramString1.iterator();
      while (paramString1.hasNext()) {
        paramByteStringMicro.add(new ExcitingTransferHostInfo((String)paramString1.next(), i));
      }
      paramExcitingTransferDownloadReqInfo.mHosts = ((ExcitingTransferHostInfo[])paramByteStringMicro.toArray(new ExcitingTransferHostInfo[paramByteStringMicro.size()]));
      paramExcitingTransferDownloadReqInfo.strCookie = ("Cookie:t=0;v=" + AppSetting.a() + ";" + paramString2 + ";\r\n");
      paramExcitingTransferDownloadReqInfo.serverPath = paramString4;
      paramExcitingTransferDownloadReqInfo.strTempFilePath = b();
      paramExcitingTransferDownloadReqInfo.strFileName = paramString5;
      paramExcitingTransferDownloadReqInfo.strSaveFileDir = this.jdField_a_of_type_Audf.b();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_Atsf.e();
      f();
      return;
    }
  }
  
  protected boolean a(long paramLong, ByteStringMicro paramByteStringMicro, String paramString)
  {
    boolean bool = false;
    if ((TextUtils.isEmpty(paramString)) || (paramByteStringMicro == null))
    {
      if ((paramLong == -6101L) || (paramLong == -7003L)) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      }
      if (paramLong != 0L) {
        break label101;
      }
      this.jdField_a_of_type_Atsf.a.jdField_b_of_type_Long = 9048L;
      this.jdField_a_of_type_Atsf.a.jdField_a_of_type_Long = 2L;
      this.jdField_a_of_type_Atsf.a(5);
      this.jdField_a_of_type_Atsf.a(false);
    }
    for (;;)
    {
      a(null, (int)paramLong);
      bool = true;
      return bool;
      label101:
      this.jdField_a_of_type_Atsf.c(paramLong);
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  public String b()
  {
    String str1 = this.jdField_a_of_type_Audf.c();
    String str2 = MD5.toMD5(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid);
    return str1 + str2;
  }
  
  public int c()
  {
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
  }
  
  public void onOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    int j = 3;
    if (paramExcitingTransferOneSlotComplete == null)
    {
      QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + paramInt + " slotInfo is null");
      return;
    }
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "OnOneSlotComplete:" + paramInt + " slotInfo : " + paramExcitingTransferOneSlotComplete.toString());
    int i = a(paramInt);
    int k = 4;
    if (i == 9004) {
      i = 5;
    }
    for (;;)
    {
      this.jdField_a_of_type_Atsf.a(i, j, paramExcitingTransferOneSlotComplete);
      a(paramInt, paramExcitingTransferOneSlotComplete);
      return;
      if (i == 506)
      {
        k = 3;
        j = i;
        i = k;
      }
      else
      {
        j = i;
        i = k;
      }
    }
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    QLog.i("C2CFileDownloader<FileAssistant>", 1, "file download result:" + paramInt);
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      this.jdField_a_of_type_Atsf.c(0);
    }
    int i;
    if (paramInt != 0)
    {
      i = a(paramInt);
      this.jdField_a_of_type_Atsf.a.jdField_b_of_type_Long = i;
      this.jdField_a_of_type_Atsf.a.jdField_a_of_type_Long = 4L;
      if (i == 9004)
      {
        this.jdField_a_of_type_Atsf.a.jdField_a_of_type_Long = 5L;
        this.jdField_a_of_type_Atsf.a(3);
        a(null, i);
        label107:
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerDataCenter().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (paramExcitingTransferDownloadCompletedInfo != null)
        {
          this.jdField_a_of_type_Atsf.a(paramExcitingTransferDownloadCompletedInfo);
          paramExcitingTransferDownloadCompletedInfo = this.jdField_a_of_type_Atsf;
          if (i != 0) {
            break label304;
          }
        }
      }
    }
    label304:
    for (boolean bool = true;; bool = false)
    {
      paramExcitingTransferDownloadCompletedInfo.a(bool);
      return;
      if (i == 506)
      {
        this.jdField_a_of_type_Atsf.a.jdField_a_of_type_Long = 3L;
        this.jdField_a_of_type_Atsf.a(i);
        break;
      }
      this.jdField_a_of_type_Atsf.a(i);
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileTransferHandler().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, null);
      this.jdField_a_of_type_Atsf.a.jdField_b_of_type_Long = paramInt;
      this.jdField_a_of_type_Atsf.a.jdField_a_of_type_Long = 0L;
      this.jdField_a_of_type_Atsf.a(0);
      a(paramExcitingTransferDownloadCompletedInfo);
      i = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType != 5) {
        break label107;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerEngine().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      i = paramInt;
      break label107;
    }
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    this.jdField_a_of_type_Atsf.a(paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong2 / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFileManagerNotifyCenter().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
  }
  
  public void onRecvStart() {}
  
  public void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    paramExcitingTransferDownloadSpeedInfo = aufd.b(paramExcitingTransferDownloadSpeedInfo.mTotalSpeed);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.mExcitingSpeed = paramExcitingTransferDownloadSpeedInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsg
 * JD-Core Version:    0.7.0.1
 */