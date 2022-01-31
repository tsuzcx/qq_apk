import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator.1;
import com.tencent.mobileqq.filemanager.discoperation.DiscFileOperator.2;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.Executor;

public class ardx
  extends aqtp
  implements arec, ared
{
  final int jdField_a_of_type_Int = 1000;
  long jdField_a_of_type_Long = 0L;
  aqtp jdField_a_of_type_Aqtp = null;
  ardy jdField_a_of_type_Ardy = null;
  public ardz a;
  public areb a;
  public QQAppInterface a;
  public FileManagerEntity a;
  final String jdField_a_of_type_JavaLangString = "DiscFileOperator<FileAssistant>";
  public boolean a;
  
  public ardx(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = null;
    this.jdField_a_of_type_Areb = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Ardz = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_Areb = new areb(paramQQAppInterface.getCurrentAccountUin(), "actDiscussFileUp");
  }
  
  private void a(boolean paramBoolean)
  {
    QLog.i("DiscFileOperator<FileAssistant>", 1, "nID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]notifyUIRefresh[" + paramBoolean + "]");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 1.0F;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 14, new Object[] { this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize), Boolean.valueOf(true), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath }, 0, null);
      String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 5)
      {
        str1 = str2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strApkPackageName))
        {
          str1 = str2;
          if (str2.indexOf(".apk") < 0) {
            str1 = str2 + ".apk";
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.msgUid, this);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 15, null, 5, null);
      if (this.jdField_a_of_type_Ardz != null) {
        this.jdField_a_of_type_Ardz.a();
      }
    }
  }
  
  private boolean a(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    boolean bool = true;
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]checkParam-->Host null");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      if (paramLong == 0L)
      {
        this.jdField_a_of_type_Areb.jdField_a_of_type_Long = 9048L;
        this.jdField_a_of_type_Areb.c = "onSendDiscFile Host null";
        this.jdField_a_of_type_Areb.c();
        a(false);
        bool = false;
      }
    }
    while ((paramString2 != null) && (paramString2.length() != 0) && (paramString3 != null) && (paramString3.length() != 0)) {
      for (;;)
      {
        return bool;
        this.jdField_a_of_type_Areb.jdField_a_of_type_Long = ((int)paramLong);
      }
    }
    QLog.i("DiscFileOperator<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]checkParam-->param error");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    if (paramLong == 0L) {}
    for (this.jdField_a_of_type_Areb.jdField_a_of_type_Long = 9005L;; this.jdField_a_of_type_Areb.jdField_a_of_type_Long = ((int)paramLong))
    {
      this.jdField_a_of_type_Areb.c = "onSendDiscFile param error";
      this.jdField_a_of_type_Areb.c();
      a(false);
      return false;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nOpType;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return null;
  }
  
  public void a()
  {
    a(true);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)paramLong1 / (float)paramLong2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    paramLong1 = System.currentTimeMillis();
    if (paramLong1 - this.jdField_a_of_type_Long >= 1000L)
    {
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 16, null, 0, null);
      if (QLog.isColorLevel())
      {
        String str = this.jdField_a_of_type_Areb.a();
        QLog.i("DiscFileOperator<FileAssistant>.Speed", 1, "Id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "], speed[" + str + "]Notify UI Progress! and send continue!");
      }
    }
  }
  
  public void a(Object paramObject, int paramInt)
  {
    a(false);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      QLog.w("DiscFileOperator<FileAssistant>", 1, "nID[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "],onSendDiscFile user canceled!");
      return;
    }
    this.jdField_a_of_type_Areb.jdField_d_of_type_Long = System.currentTimeMillis();
    if (!paramBoolean)
    {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "=_= ^! Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onSendDiscFile-->failed");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      if (paramLong == -100001L) {}
      for (this.jdField_a_of_type_Areb.jdField_a_of_type_Long = 9043L;; this.jdField_a_of_type_Areb.jdField_a_of_type_Long = 9045L)
      {
        this.jdField_a_of_type_Areb.c = "server retError";
        if (paramString6 != null) {
          this.jdField_a_of_type_Areb.c = paramString6;
        }
        this.jdField_a_of_type_Areb.c();
        a(false);
        return;
      }
    }
    QLog.d("DiscFileOperator<FileAssistant>", 2, "=_= ^> [CS Replay]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]onSendDiscFile, Go [Upload Step]");
    if (!a(paramLong, paramString4, paramString3, paramString2))
    {
      QLog.d("DiscFileOperator<FileAssistant>", 2, "=_= ^! [Check Param]Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]checkParam error!");
      return;
    }
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      QLog.e("DiscFileOperator<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "] will show taost, retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramString6);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType, 4, null, (int)paramLong, paramString6);
    }
    paramBoolean = false;
    int i;
    if ((arbp.e(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) && (paramBundle != null))
    {
      paramString2 = paramBundle.getString("strHttpsDomain");
      i = paramBundle.getShort("httpsPort", (short)0);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramBoolean = true;
        if (i == 0) {
          paramInt = 443;
        }
      }
    }
    for (;;)
    {
      paramString5 = "";
      if (arsx.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        paramString5 = paramBundle.getString("IPv6Dns");
      }
      QLog.i("DiscFileOperator<FileAssistant>", 1, "=_= ^> nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "],retCode[" + String.valueOf(paramLong) + "] useHttps:" + paramBoolean + " httpsDomain:" + paramString2 + " uploadPort:" + paramInt);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.jdField_a_of_type_Ardy = new ardy();
      this.jdField_a_of_type_Ardy.a(paramString3, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this);
      this.jdField_a_of_type_Ardz = new ardz(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Areb, paramString4, paramInt, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Ardy, paramBoolean, paramString2, paramString5);
      ThreadManager.post(new DiscFileOperator.1(this), 8, null, true);
      return;
      paramInt = i;
      continue;
      paramString2 = null;
    }
  }
  
  protected void a(boolean paramBoolean, Long paramLong)
  {
    this.jdField_a_of_type_Areb.jdField_a_of_type_Long = paramLong.longValue();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void aA_()
  {
    this.jdField_a_of_type_Boolean = false;
    f();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ardz != null) {
      this.jdField_a_of_type_Ardz.a();
    }
  }
  
  public int c()
  {
    return (int)(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress * 100.0F);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ardz != null) {
      this.jdField_a_of_type_Ardz.a();
    }
    this.jdField_a_of_type_Areb.jdField_a_of_type_Long = 9004L;
    this.jdField_a_of_type_Areb.g = System.currentTimeMillis();
    this.jdField_a_of_type_Areb.c();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Ardz != null) {
      this.jdField_a_of_type_Ardz.a();
    }
    this.jdField_a_of_type_Areb.jdField_a_of_type_Long = 9037L;
    this.jdField_a_of_type_Areb.g = System.currentTimeMillis();
    this.jdField_a_of_type_Areb.c();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
  }
  
  public void e()
  {
    b();
  }
  
  public void f()
  {
    this.jdField_a_of_type_Areb.jdField_a_of_type_Int = 3000;
    this.jdField_a_of_type_Areb.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    this.jdField_a_of_type_Areb.j = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Areb.h = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    if (QLog.isColorLevel()) {
      QLog.i("DiscFileOperator<FileAssistant>", 1, "start sendFile:" + ayzl.a());
    }
    arsd.a().execute(new DiscFileOperator.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardx
 * JD-Core Version:    0.7.0.1
 */