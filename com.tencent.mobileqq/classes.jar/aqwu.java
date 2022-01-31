import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.2;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;

public class aqwu
  extends aqtp
{
  final int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  
  aqwu(aqwt paramaqwt) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, "Id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramLong2) + "] SendCC [" + String.valueOf(paramBoolean) + "],retCode[" + String.valueOf(paramLong1) + "]");
    if (!paramBoolean)
    {
      if (paramLong1 == -100001L) {}
      for (paramLong3 = 9043L;; paramLong3 = 90460L)
      {
        this.jdField_a_of_type_Aqwt.a(1005);
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, paramLong2, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 15, null, 5, null);
        this.jdField_a_of_type_Aqwt.b();
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !");
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong3, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "sendCCFaild", null);
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong3, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "sendCCFaild", null);
        return;
      }
    }
    if (paramLong1 == 58L)
    {
      arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "ServerMasking", null);
      arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "ServerMasking", null);
      this.jdField_a_of_type_Aqwt.a(1005);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, paramLong2, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 15, null, 5, null);
      this.jdField_a_of_type_Aqwt.b();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      return;
    }
    String str = null;
    if (this.jdField_a_of_type_Aqwt.jdField_d_of_type_Int > 0) {
      str = "ChanedUrlCount[" + this.jdField_a_of_type_Aqwt.jdField_d_of_type_Int + "]";
    }
    arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_h_of_type_Long - this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, this.jdField_a_of_type_Aqwt.f, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.b(this.jdField_a_of_type_Aqwt), str);
    arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_h_of_type_Long - this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, this.jdField_a_of_type_Aqwt.f, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.b(this.jdField_a_of_type_Aqwt), str);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aqwt.a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay], SessionId[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "], working stop!");
      return;
    }
    if ((TextUtils.isEmpty(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
    }
    arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramInt);
      this.jdField_a_of_type_Aqwt.a(2005);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == -100001L) {}
      for (paramLong2 = 9043L;; paramLong2 = 9045L)
      {
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "server ret error", null);
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "server ret error", null);
        return;
      }
    }
    this.jdField_a_of_type_Aqwt.jdField_h_of_type_JavaLangString = paramString2;
    if (paramString5 != null) {
      this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aqwt.a(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, paramString5);
    }
    String str;
    int i;
    if ((arbp.b(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramBundle != null))
    {
      str = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort", (short)0);
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_Aqwt.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Aqwt.k = str;
        if (i == 0) {
          i = 443;
        }
      }
    }
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          str = (String)paramList.next();
          localArrayList.add(str + ":" + i);
        }
      }
      str = null;
      paramList = str;
      if (paramString3 != null)
      {
        paramList = str;
        if (paramByteStringMicro != null)
        {
          str = paramString3 + ":" + i;
          paramList = str;
          if (arbp.jdField_b_of_type_Boolean)
          {
            paramList = str;
            if (!this.jdField_a_of_type_Aqwt.jdField_b_of_type_Boolean) {
              paramList = "113.108.29.146:" + paramShort;
            }
          }
          localArrayList.add(0, paramList);
          paramList = "";
          if (paramBundle != null) {
            paramList = paramBundle.getString("IPv6Dns", "");
          }
          if ((!TextUtils.isEmpty(paramList)) && (arsx.b(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
          {
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[CS Replay] download support IPv6. domain[" + paramList + "]");
            localArrayList.add(0, paramList + ":" + i);
          }
          aqwt.a(this.jdField_a_of_type_Aqwt, new aqxx(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, paramString4));
          if (!this.jdField_a_of_type_Aqwt.jdField_b_of_type_Boolean) {
            break label1360;
          }
          aqwt.a(this.jdField_a_of_type_Aqwt).a(true);
          paramList = aqwt.a(this.jdField_a_of_type_Aqwt).a();
        }
      }
      if (paramList == null)
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] get offlinefile info Url is null, IP is null too");
        this.jdField_a_of_type_Aqwt.a(2005);
        if ((paramLong1 == -6101L) || (paramLong1 == -7003L)) {
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
        }
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
        if (paramLong1 == 0L) {
          paramLong1 = 9048L;
        }
        for (;;)
        {
          arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "ip url error", null);
          arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "ip url error", null);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          return;
          label1360:
          aqwt.a(this.jdField_a_of_type_Aqwt).a(false);
          break;
        }
      }
      this.jdField_a_of_type_Aqwt.f = paramList;
      aqwt.a(this.jdField_a_of_type_Aqwt, this.jdField_a_of_type_Aqwt.f);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "] mUseHttps:" + this.jdField_a_of_type_Aqwt.jdField_b_of_type_Boolean + " mHttpsDomain:" + this.jdField_a_of_type_Aqwt.k + " downloadPort:" + i);
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
      }
      if (-1L != this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long) {
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, 0, this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long);
      }
      paramList = MD5.toMD5(this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Aqwt.jdField_c_of_type_JavaLangString + paramList);
      if (!bdin.d(BaseApplication.getContext()))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] no network! return!");
        this.jdField_a_of_type_Aqwt.a(2005);
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 1, null, 2, null);
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "net", null);
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "net", null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString + "]");
      }
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long = arrr.a(this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long == this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_a_of_type_Aqwt.a(2003);
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 11, new Object[] { this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_a_of_type_Aqwt.f }, 0, null);
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.d(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aqwt.a(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (bdhb.a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString = arrr.b(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
        }
        arrr.a(new VFSFile(this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString), new VFSFile(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] is exist, and filesize is right!");
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, 0L, this.jdField_a_of_type_Aqwt.f, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.f, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.b(this.jdField_a_of_type_Aqwt), null);
        return;
      }
      if (this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long > this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long)
      {
        long l = this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long - this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_Arqx.a() < l)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] not enought space! ProcessNewPath");
          paramList = new ArrayList();
          paramList.addAll(localArrayList);
          aqwt.a(this.jdField_a_of_type_Aqwt, l, new aqwv(this, paramBoolean, paramLong1, paramString1, paramString2, paramByteStringMicro, paramString3, paramShort, paramString4, paramList, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle));
          return;
        }
      }
      arsd.a().execute(new FileManagerRSWorker.1.2(this));
      return;
      continue;
      i = paramShort;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Aqwt.a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay] id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]OnDiscDownloadInfo, network error");
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramInt2);
      this.jdField_a_of_type_Aqwt.a(2005);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == -100001L) {}
      for (paramLong2 = 9043L;; paramLong2 = 9045L)
      {
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "ret error", null);
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "ret error", null);
        return;
      }
    }
    String str1;
    if ((arbp.f(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramBundle != null))
    {
      str1 = paramBundle.getString("strHttpsDomain");
      int j = paramBundle.getShort("httpsPort", (short)0);
      if (!TextUtils.isEmpty(str1))
      {
        this.jdField_a_of_type_Aqwt.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_Aqwt.k = str1;
        i = j;
        if (j != 0) {}
      }
    }
    for (int i = 443;; i = paramInt1)
    {
      if (paramBundle != null) {}
      for (str1 = paramBundle.getString("IPv6Dns", "");; str1 = "")
      {
        String str3 = null;
        String str2 = str3;
        if (paramString3 != null)
        {
          str2 = str3;
          if (paramString4 != null)
          {
            str2 = paramString3 + ":" + i;
            str3 = aqwt.b(this.jdField_a_of_type_Aqwt, paramString4);
            ArrayList localArrayList = new ArrayList(1);
            localArrayList.add(str2);
            if ((!TextUtils.isEmpty(str1)) && (arsx.b(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)))
            {
              QLog.i("FileManagerRSWorker<FileAssistant>", 1, "[CS Disc Replay] disc download support IPv6. domain[" + str1 + "]");
              localArrayList.add(0, str1 + ":" + i);
            }
            aqwt.a(this.jdField_a_of_type_Aqwt, new aqxx(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList, str3));
            if (!this.jdField_a_of_type_Aqwt.jdField_b_of_type_Boolean) {
              break label1125;
            }
            aqwt.a(this.jdField_a_of_type_Aqwt).a(true);
            str2 = aqwt.a(this.jdField_a_of_type_Aqwt).a();
          }
        }
        if (str2 == null)
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay]id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] get DiscdownLoad info Url is null");
          this.jdField_a_of_type_Aqwt.a(2005);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
          if (paramLong1 == 0L) {
            paramLong1 = 9048L;
          }
          for (;;)
          {
            arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt2), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "ip url error", null);
            arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt2), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "ip url error", null);
            return;
            label1125:
            aqwt.a(this.jdField_a_of_type_Aqwt).a(false);
            break;
          }
        }
        this.jdField_a_of_type_Aqwt.f = str2;
        aqwt.a(this.jdField_a_of_type_Aqwt, this.jdField_a_of_type_Aqwt.f);
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Disc Download Replay]nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "]downLoadUrl[" + String.valueOf(this.jdField_a_of_type_Aqwt.f) + "] mUseHttps:" + this.jdField_a_of_type_Aqwt.jdField_b_of_type_Boolean + " mHttpsDomain:" + this.jdField_a_of_type_Aqwt.k + " downloadPort:" + i);
        if ((paramString1 != null) && (paramString1.length() > 0))
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
        }
        if ((paramString2 != null) && (paramString2.length() > 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSeseeId[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "]renamed[" + String.valueOf(paramString2) + "]");
          }
          this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aqwt.a(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, paramString2);
        }
        if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1) {
          this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString = arrr.b(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
        }
        this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Aqwt.jdField_c_of_type_JavaLangString + "dsc-" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.replace("/", "")));
        if (!bdin.d(BaseApplication.getContext()))
        {
          this.jdField_a_of_type_Aqwt.a(2005);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 1, null, 2, null);
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "], NetWork Error, notify UI!");
          arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "net", null);
          arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "net", null);
          return;
        }
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString + "]");
        }
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long = arrr.a(this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString);
        if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long == this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long)
        {
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
          this.jdField_a_of_type_Aqwt.a(2003);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 11, new Object[] { this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_a_of_type_Aqwt.f }, 0, null);
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
          if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
          {
            this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.d(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
            this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Aqwt.a(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          }
          if (bdhb.a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString)) {
            this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString = arrr.b(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
          }
          arrr.a(new VFSFile(this.jdField_a_of_type_Aqwt.jdField_d_of_type_JavaLangString), new VFSFile(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString));
          this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = arrr.a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_JavaLangString);
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "], fileExisted, notify UI!");
          arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, 0L, this.jdField_a_of_type_Aqwt.f, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.f, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.b(this.jdField_a_of_type_Aqwt), null);
          return;
        }
        if (this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long > this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long)
        {
          long l = this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long - this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long;
          if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_Arqx.a() < l)
          {
            aqwt.a(this.jdField_a_of_type_Aqwt, l, new aqww(this, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle));
            return;
          }
        }
        arsd.a().execute(new FileManagerRSWorker.1.4(this, paramString5));
        return;
      }
    }
  }
  
  protected void a(boolean paramBoolean, aqtm paramaqtm, alwy paramalwy)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [SetFileState Replay] Id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]setOfflineFileState success!");
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_=^![SetFileState Replay] Id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]wk,onUpdateSetOfflineFileState-->failed");
      this.jdField_a_of_type_Aqwt.a(1005);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 15, null, paramaqtm.jdField_a_of_type_Int, paramaqtm.jdField_a_of_type_JavaLangString);
      int i = paramaqtm.jdField_a_of_type_Int;
      if (paramaqtm.jdField_a_of_type_Int == -100001) {
        i = 9043;
      }
      arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramalwy.jdField_a_of_type_Int) + "&" + String.valueOf(paramaqtm.jdField_a_of_type_Int), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), paramaqtm.jdField_a_of_type_JavaLangString, null);
      arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramalwy.jdField_a_of_type_Int) + "&" + String.valueOf(paramaqtm.jdField_a_of_type_Int), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), paramaqtm.jdField_a_of_type_JavaLangString, null);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramaqtm.jdField_a_of_type_Int) + "]");
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [SetFileState Replay] -> [Send CC] id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]onUpdateSetOfflineFileState success, send CC!");
    this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, aqwt.a(this.jdField_a_of_type_Aqwt));
  }
  
  protected void a(boolean paramBoolean, aqtm paramaqtm, alwy paramalwy, List<String> paramList)
  {
    if (this.jdField_a_of_type_Aqwt.a())
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long = 0L;
    int i;
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]wk,onUpdateSendOfflineFile-->failed");
      this.jdField_a_of_type_Aqwt.a(1005);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 15, null, paramaqtm.jdField_a_of_type_Int, paramaqtm.jdField_a_of_type_JavaLangString);
      if (paramaqtm.jdField_a_of_type_Int == -100001) {}
      for (i = 9043;; i = 9045)
      {
        paramList = "server retError";
        if (paramaqtm.jdField_a_of_type_JavaLangString != null) {
          paramList = paramaqtm.jdField_a_of_type_JavaLangString;
        }
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramalwy.jdField_a_of_type_Int) + "&" + String.valueOf(paramaqtm.jdField_a_of_type_Int), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), paramList, null);
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramalwy.jdField_a_of_type_Int) + "&" + String.valueOf(paramaqtm.jdField_a_of_type_Int), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), paramList, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramaqtm.jdField_a_of_type_Int) + "]");
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]wk,handleSendOfflineFileResp");
    }
    if ((paramaqtm.jdField_b_of_type_JavaLangString == null) || (paramaqtm.jdField_b_of_type_JavaLangString.length() == 0))
    {
      this.jdField_a_of_type_Aqwt.a(1005);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 15, null, paramaqtm.jdField_a_of_type_Int, paramaqtm.jdField_a_of_type_JavaLangString);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "]ResultCodeNoServerAddr ip = 0");
      if (paramaqtm.jdField_a_of_type_Int == 0) {}
      for (i = 9048;; i = paramaqtm.jdField_a_of_type_Int)
      {
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_i_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramalwy.jdField_a_of_type_Int) + "&" + String.valueOf(paramaqtm.jdField_a_of_type_Int), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.a(this.jdField_a_of_type_Aqwt), "onUpSend ip url error", null);
        arrr.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Aqwt.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramalwy.jdField_a_of_type_Int) + "&" + String.valueOf(paramaqtm.jdField_a_of_type_Int), this.jdField_a_of_type_Aqwt.jdField_i_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, aqwt.a(this.jdField_a_of_type_Aqwt), "", aqwt.b(this.jdField_a_of_type_Aqwt), "onUpSend ip url error", null);
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramaqtm.jdField_a_of_type_Int) + "]");
    if ((paramaqtm.jdField_a_of_type_JavaLangString != null) && (paramaqtm.jdField_a_of_type_JavaLangString.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramaqtm.jdField_a_of_type_Int) + "], retMsg:" + paramaqtm.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_b_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_Int, 4, null, paramaqtm.jdField_a_of_type_Int, paramaqtm.jdField_a_of_type_JavaLangString);
    }
    if ((paramaqtm.jdField_a_of_type_ArrayOfByte != null) && (paramaqtm.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString = new String(paramaqtm.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject = new byte[this.jdField_a_of_type_Aqwt.jdField_a_of_type_ArrayOfByte.length + 4];
      bdqa.a((byte[])localObject, 0, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ArrayOfByte.length);
      bdqa.a((byte[])localObject, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ArrayOfByte.length, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long);
      if ((paramaqtm.jdField_a_of_type_Boolean != true) || (paramaqtm.jdField_c_of_type_Long > 104857600L)) {
        break;
      }
      this.jdField_a_of_type_Aqwt.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Aqwt.jdField_h_of_type_Long = System.currentTimeMillis();
      arrr.b(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_a_of_type_Aqwt.f);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Aqwt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, aqwt.a(this.jdField_a_of_type_Aqwt));
      paramaqtm = new arrq();
      paramaqtm.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramaqtm.jdField_a_of_type_Int = 1;
      arrp.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramaqtm);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
    paramalwy = HexUtil.bytes2HexStr(paramaqtm.jdField_b_of_type_ArrayOfByte);
    Object localObject = HexUtil.bytes2HexStr((byte[])localObject).toLowerCase(Locale.US);
    if (paramList == null)
    {
      paramList = new ArrayList();
      paramList.add(paramaqtm.jdField_b_of_type_JavaLangString + ":" + paramaqtm.jdField_a_of_type_Short);
      if (arbp.jdField_b_of_type_Boolean)
      {
        paramList.clear();
        paramList.add(0, "14.17.29.27:" + paramaqtm.jdField_a_of_type_Short);
      }
      if (paramaqtm.jdField_d_of_type_Int != 2) {
        break label2183;
      }
    }
    label2183:
    for (paramalwy = "/ftn_handler";; paramalwy = aqwt.a(this.jdField_a_of_type_Aqwt, paramalwy, (String)localObject, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long))
    {
      aqwt.a(this.jdField_a_of_type_Aqwt, new aqxx(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramalwy));
      aqwt.a(this.jdField_a_of_type_Aqwt, paramaqtm);
      aqwt.a(this.jdField_a_of_type_Aqwt, this.jdField_a_of_type_Aqwt.f);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = this.jdField_a_of_type_Aqwt.f;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      if ((!paramaqtm.jdField_a_of_type_Boolean) || (paramaqtm.jdField_d_of_type_Int != 1)) {
        break label2204;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "], onUpdateSendOfflineFile: file Exist");
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "], FileSize[" + this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long + "], Uuid[" + this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString + "]");
      }
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "CS秒传,nSessionID[" + String.valueOf(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      this.jdField_a_of_type_Aqwt.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Aqwt.jdField_h_of_type_Long = System.currentTimeMillis();
      arrr.b(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_a_of_type_Aqwt.f);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Aqwt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, aqwt.a(this.jdField_a_of_type_Aqwt));
      paramaqtm = new arrq();
      paramaqtm.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramaqtm.jdField_a_of_type_Int = 1;
      arrp.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramaqtm);
      return;
      paramList.add(0, paramaqtm.jdField_b_of_type_JavaLangString + ":" + paramaqtm.jdField_a_of_type_Short);
      break;
    }
    label2204:
    this.jdField_a_of_type_Aqwt.jdField_e_of_type_Long = paramaqtm.jdField_b_of_type_Int;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^[CS Step], CS Step Success! Goto [Upload Step]!");
    if (paramaqtm.jdField_d_of_type_Int == 2)
    {
      this.jdField_a_of_type_Aqwt.a(this.jdField_a_of_type_Aqwt.f, 0L, paramaqtm.jdField_b_of_type_ArrayOfByte);
      return;
    }
    this.jdField_a_of_type_Aqwt.a(this.jdField_a_of_type_Aqwt.f, 0L);
  }
  
  public void aB_()
  {
    this.jdField_a_of_type_Aqwt.j();
  }
  
  protected void b(boolean paramBoolean, aqtm paramaqtm, alwy paramalwy)
  {
    super.b(paramBoolean, paramaqtm, paramalwy);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] id[" + this.jdField_a_of_type_Aqwt.jdField_c_of_type_Long + "]onDownloadFileSuc");
    if ((paramBoolean) && ((paramaqtm.jdField_c_of_type_Int == 2) || (paramaqtm.jdField_c_of_type_Int == 0)) && (!this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramaqtm.jdField_a_of_type_Int + "],retMsg[" + paramaqtm.jdField_a_of_type_JavaLangString + "],retStat[" + paramaqtm.jdField_c_of_type_Int + "]. need to send file receipt");
      if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName != null)
      {
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        return;
      }
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Aqwt.jdField_d_of_type_Long, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramaqtm.jdField_a_of_type_Int + "],retMsg[" + paramaqtm.jdField_a_of_type_JavaLangString + "],retStat[" + paramaqtm.jdField_c_of_type_Int + "]. don't need to send file receipt");
  }
  
  protected void b(boolean paramBoolean, aqtm paramaqtm, alwy paramalwy, List<String> paramList)
  {
    if ((paramaqtm.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_Aqwt.jdField_a_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Aqwt.jdField_a_of_type_Arqk != null) {
        this.jdField_a_of_type_Aqwt.jdField_a_of_type_Arqk.a();
      }
      this.jdField_a_of_type_Aqwt.b();
      if ((paramaqtm.jdField_a_of_type_ArrayOfByte == null) || (paramaqtm.jdField_a_of_type_ArrayOfByte.length <= 0)) {
        break label272;
      }
      this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString = new String(paramaqtm.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_a_of_type_Aqwt.jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqwt.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Aqwt.jdField_h_of_type_Long = System.currentTimeMillis();
      arrr.b(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_a_of_type_Aqwt.f);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Aqwt.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, aqwt.a(this.jdField_a_of_type_Aqwt));
      paramaqtm = new arrq();
      paramaqtm.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramaqtm.jdField_a_of_type_Int = 1;
      arrp.a(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramaqtm);
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Aqwt.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      label272:
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwu
 * JD-Core Version:    0.7.0.1
 */