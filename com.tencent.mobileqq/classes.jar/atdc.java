import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.2;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.1.4;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

public class atdc
  extends aszq
{
  final int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  
  atdc(atdb paramatdb) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isDevelopLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 4, "Id[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  protected void a(boolean paramBoolean1, long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean2, String paramString3, short paramShort, String paramString4, List<String> paramList, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Atdb.a())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay], SessionId[" + this.jdField_a_of_type_Atdb.jdField_c_of_type_Long + "], working stop!");
      return;
    }
    if (paramBoolean2) {}
    for (String str1 = paramString4 + "&isthumb=0";; str1 = paramString4)
    {
      if ((TextUtils.isEmpty(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)) && (!TextUtils.isEmpty(paramString6))) {
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 = paramString6;
      }
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bUseMediaPlatform = paramBoolean2;
      atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, null);
      if (atdb.a(this.jdField_a_of_type_Atdb, paramBoolean1, paramLong1, paramString1, paramInt, "=_= ^! [CS Replay]id[", "server ret error")) {
        break;
      }
      this.jdField_a_of_type_Atdb.jdField_i_of_type_JavaLangString = paramString2;
      if (paramString5 != null) {
        this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdb.a(this.jdField_a_of_type_Atdb.e, paramString5);
      }
      short s = atdb.a(this.jdField_a_of_type_Atdb, paramShort, paramBundle);
      ArrayList localArrayList = new ArrayList();
      if (paramList != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          String str2 = (String)paramList.next();
          localArrayList.add(str2 + ":" + s);
        }
      }
      str1 = atdb.a(this.jdField_a_of_type_Atdb, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramBundle, str1, s, localArrayList);
      paramList = new Bundle();
      paramList.putInt("param_V6SelectType", this.jdField_a_of_type_Atdb.jdField_c_of_type_Int);
      paramList.putInt("param_ipAddrType", atdb.a(this.jdField_a_of_type_Atdb));
      int i;
      if (this.jdField_a_of_type_Atdb.jdField_c_of_type_Boolean)
      {
        i = 1;
        paramList.putInt("param_ishttps", i);
        if (str1 != null) {
          break label769;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "] get offlinefile info Url is null, IP is null too");
        this.jdField_a_of_type_Atdb.a(2005);
        if ((paramLong1 == -6101L) || (paramLong1 == -7003L)) {
          this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
        }
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_b_of_type_Long, this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
        if (paramLong1 != 0L) {
          break label766;
        }
        paramLong1 = 9048L;
      }
      label766:
      for (;;)
      {
        atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_g_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt), this.jdField_a_of_type_Atdb.jdField_i_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_Long, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), "", atdb.b(this.jdField_a_of_type_Atdb), "ip url error", null, paramList);
        atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.k, this.jdField_a_of_type_Atdb.jdField_g_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt), this.jdField_a_of_type_Atdb.jdField_i_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_Long, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), "", atdb.c(this.jdField_a_of_type_Atdb), "ip url error", null, paramList);
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        return;
        i = 0;
        break;
      }
      label769:
      this.jdField_a_of_type_Atdb.f = str1;
      atdb.a(this.jdField_a_of_type_Atdb, this.jdField_a_of_type_Atdb.f);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]nSessionID[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "] mUseHttps:" + this.jdField_a_of_type_Atdb.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_a_of_type_Atdb.l + " downloadPort:" + s);
      if ((paramLong1 != 0L) && (paramString1 != null) && (paramString1.length() > 0))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_b_of_type_Long, this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
      }
      if (-1L != this.jdField_a_of_type_Atdb.jdField_b_of_type_Long) {
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_a_of_type_Atdb.e, 0, this.jdField_a_of_type_Atdb.jdField_b_of_type_Long);
      }
      str1 = MD5.toMD5(this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Atdb.jdField_c_of_type_JavaLangString + str1);
      if (!bgnt.d(BaseApplication.getContext()))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "] no network! return!");
        this.jdField_a_of_type_Atdb.a(2005);
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_b_of_type_Long, this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_Int, 1, null, 2, null);
        atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_g_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Atdb.jdField_i_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_Long, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), "", atdb.b(this.jdField_a_of_type_Atdb), "net", null, paramList);
        atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.k, this.jdField_a_of_type_Atdb.jdField_g_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Atdb.jdField_i_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_Long, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), "", atdb.c(this.jdField_a_of_type_Atdb), "net", null, paramList);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString + "]");
      }
      this.jdField_a_of_type_Atdb.jdField_a_of_type_Long = atvo.a(this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Atdb.jdField_a_of_type_Long == this.jdField_a_of_type_Atdb.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_a_of_type_Atdb.a(2003);
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_b_of_type_Long, this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_Int, 11, new Object[] { this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Atdb.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_a_of_type_Atdb.f }, 0, null);
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.d(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdb.a(this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (bgmg.a(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString)) {
          this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString = atvo.b(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
        }
        atvo.a(new File(this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString), new File(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "] is exist, and filesize is right!");
        atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.jdField_j_of_type_JavaLangString, 0L, this.jdField_a_of_type_Atdb.f, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.f, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.c(this.jdField_a_of_type_Atdb), null, paramList);
        return;
      }
      if (this.jdField_a_of_type_Atdb.jdField_d_of_type_Long > this.jdField_a_of_type_Atdb.jdField_a_of_type_Long)
      {
        long l = this.jdField_a_of_type_Atdb.jdField_d_of_type_Long - this.jdField_a_of_type_Atdb.jdField_a_of_type_Long;
        if (this.jdField_a_of_type_Atdb.jdField_a_of_type_Atut.a() < l)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Replay]id[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "] not enought space! ProcessNewPath");
          paramList = new ArrayList();
          paramList.addAll(localArrayList);
          atdb.a(this.jdField_a_of_type_Atdb, l, new atdd(this, paramBoolean1, paramLong1, paramString1, paramString2, paramByteStringMicro, paramBoolean2, paramString3, paramShort, paramString4, paramList, paramInt, paramString5, paramString6, paramString7, paramLong2, paramBundle));
          return;
        }
      }
      atvy.a().execute(new FileManagerRSWorker.1.2(this));
      return;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Atdb.a()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Disc Download Replay] id[" + this.jdField_a_of_type_Atdb.jdField_c_of_type_Long + "]OnDiscDownloadInfo, network error");
    }
    int i;
    String str;
    do
    {
      do
      {
        return;
      } while (atdb.a(this.jdField_a_of_type_Atdb, paramBoolean, paramLong1, paramString1, paramInt2, "=_= v! [Disc Download Replay]id[", "ret error"));
      i = atdb.a(this.jdField_a_of_type_Atdb, paramInt1, paramBundle);
      str = "";
      if (paramBundle != null) {
        str = paramBundle.getString("IPv6Dns", "");
      }
      str = atdb.a(this.jdField_a_of_type_Atdb, paramString3, paramString4, i, str, null);
    } while (atdb.a(this.jdField_a_of_type_Atdb, paramLong1, paramString1, paramInt2, str));
    this.jdField_a_of_type_Atdb.f = str;
    atdb.a(this.jdField_a_of_type_Atdb, this.jdField_a_of_type_Atdb.f);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Disc Download Replay]nSessionID[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "]downLoadUrl[" + String.valueOf(this.jdField_a_of_type_Atdb.f) + "] mUseHttps:" + this.jdField_a_of_type_Atdb.jdField_c_of_type_Boolean + " mHttpsDomain:" + this.jdField_a_of_type_Atdb.l + " downloadPort:" + i);
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_b_of_type_Long, this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSeseeId[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "]renamed[" + String.valueOf(paramString2) + "]");
      }
      this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdb.a(this.jdField_a_of_type_Atdb.e, paramString2);
    }
    if (this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1) {
      this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString = atvo.b(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString = (this.jdField_a_of_type_Atdb.jdField_c_of_type_JavaLangString + "dsc-" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.replace("/", "")));
    if (!bgnt.d(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_Atdb.a(2005);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_b_of_type_Long, this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_Int, 1, null, 2, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "], NetWork Error, notify UI!");
      atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.jdField_j_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_g_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Atdb.jdField_i_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_Long, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), "", atdb.b(this.jdField_a_of_type_Atdb), "net", null);
      atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.k, this.jdField_a_of_type_Atdb.jdField_g_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.jdField_a_of_type_Atdb.jdField_i_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_Long, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.a(this.jdField_a_of_type_Atdb), "", atdb.c(this.jdField_a_of_type_Atdb), "net", null);
      return;
    }
    this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "], strTmp[" + this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_Atdb.jdField_a_of_type_Long = atvo.a(this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Atdb.jdField_a_of_type_Long == this.jdField_a_of_type_Atdb.jdField_d_of_type_Long)
    {
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_Atdb.a(2003);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_b_of_type_Long, this.jdField_a_of_type_Atdb.jdField_c_of_type_Long, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_Int, 11, new Object[] { this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Atdb.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_a_of_type_Atdb.f }, 0, null);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.d(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_Atdb.a(this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (bgmg.a(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString = atvo.b(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
      }
      atvo.a(new File(this.jdField_a_of_type_Atdb.jdField_d_of_type_JavaLangString), new File(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString));
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = atvo.a(this.jdField_a_of_type_Atdb.jdField_b_of_type_JavaLangString);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.jdField_a_of_type_Atdb.jdField_c_of_type_Long) + "], fileExisted, notify UI!");
      atvo.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Atdb.jdField_j_of_type_JavaLangString, 0L, this.jdField_a_of_type_Atdb.f, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.f, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, atdb.c(this.jdField_a_of_type_Atdb), null);
      return;
    }
    if (this.jdField_a_of_type_Atdb.jdField_d_of_type_Long > this.jdField_a_of_type_Atdb.jdField_a_of_type_Long)
    {
      long l = this.jdField_a_of_type_Atdb.jdField_d_of_type_Long - this.jdField_a_of_type_Atdb.jdField_a_of_type_Long;
      if (this.jdField_a_of_type_Atdb.jdField_a_of_type_Atut.a() < l)
      {
        atdb.a(this.jdField_a_of_type_Atdb, l, new atde(this, paramBoolean, paramLong1, paramString1, paramString2, paramString3, paramInt1, paramString4, paramString5, paramInt2, paramLong2, paramBundle));
        return;
      }
    }
    atvy.a().execute(new FileManagerRSWorker.1.4(this, paramString5));
  }
  
  public void aF_()
  {
    this.jdField_a_of_type_Atdb.j();
  }
  
  protected void b(boolean paramBoolean, aszn paramaszn, anqe paramanqe)
  {
    super.b(paramBoolean, paramaszn, paramanqe);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] id[" + this.jdField_a_of_type_Atdb.jdField_c_of_type_Long + "]onDownloadFileSuc");
    if ((paramBoolean) && ((paramaszn.jdField_c_of_type_Int == 2) || (paramaszn.jdField_c_of_type_Int == 0)) && (!this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramaszn.jdField_a_of_type_Int + "],retMsg[" + paramaszn.jdField_a_of_type_JavaLangString + "],retStat[" + paramaszn.jdField_c_of_type_Int + "]. need to send file receipt");
      if (this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName != null)
      {
        this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        return;
      }
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_Atdb.jdField_d_of_type_Long, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [SetFileDownloadStatus Replay] onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramaszn.jdField_a_of_type_Int + "],retMsg[" + paramaszn.jdField_a_of_type_JavaLangString + "],retStat[" + paramaszn.jdField_c_of_type_Int + "]. don't need to send file receipt");
  }
  
  protected void b(boolean paramBoolean, aszn paramaszn, anqe paramanqe, List<String> paramList)
  {
    if ((paramaszn.jdField_a_of_type_Int == 0) && (!this.jdField_a_of_type_Atdb.jdField_b_of_type_Boolean))
    {
      if (this.jdField_a_of_type_Atdb.jdField_a_of_type_Atuh != null) {
        this.jdField_a_of_type_Atdb.jdField_a_of_type_Atuh.a();
      }
      this.jdField_a_of_type_Atdb.b();
      if ((paramaszn.jdField_a_of_type_ArrayOfByte == null) || (paramaszn.jdField_a_of_type_ArrayOfByte.length <= 0)) {
        break label272;
      }
      this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString = new String(paramaszn.jdField_a_of_type_ArrayOfByte);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_a_of_type_Atdb.jdField_g_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_a_of_type_Atdb.jdField_j_of_type_Long = System.currentTimeMillis();
      this.jdField_a_of_type_Atdb.h = System.currentTimeMillis();
      atvo.b(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.jdField_a_of_type_Atdb.f);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_Atdb.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Atdb.e, this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, atdb.a(this.jdField_a_of_type_Atdb));
      paramaszn = new atvn();
      paramaszn.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramaszn.jdField_a_of_type_Int = 1;
      atvm.a(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramaszn);
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_Atdb.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      label272:
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdc
 * JD-Core Version:    0.7.0.1
 */