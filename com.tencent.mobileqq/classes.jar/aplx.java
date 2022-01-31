import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.1.1;
import com.tencent.qphone.base.util.QLog;

public class aplx
  extends aoun
{
  aplx(aplw paramaplw) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    bigj.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt);
    if (paramLong != this.a.jdField_a_of_type_Apkt.a().nSessionId) {
      return;
    }
    apug.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if ((paramLong1 == this.a.jdField_a_of_type_Apkt.a()) && (this.a.jdField_a_of_type_Apkq != null)) {
      this.a.jdField_a_of_type_Apkq.a();
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.jdField_a_of_type_Apkt.a().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    apug.a(paramString2);
  }
  
  protected void a(apez paramapez)
  {
    if ((TextUtils.isEmpty(paramapez.a)) || (TextUtils.isEmpty(paramapez.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramapez.a + " [path] = " + paramapez.b);
      }
    }
    while (this.a.jdField_a_of_type_Apne == null) {
      return;
    }
    this.a.jdField_a_of_type_Apne.a(paramapez.a, paramapez.b);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    apug.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (!paramBoolean) {}
    do
    {
      do
      {
        do
        {
          return;
          paramInt = this.a.e();
          if (paramInt != 4) {
            break;
          }
        } while (this.a.jdField_a_of_type_Apne == null);
        this.a.jdField_a_of_type_Apne.a(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.a.d() != paramLong) || (this.a.jdField_a_of_type_Apne == null));
      this.a.jdField_a_of_type_Apne.a(String.valueOf(paramLong), paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      apug.a(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Apkt.a()) {}
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_Apkt.a();
    } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (this.a.jdField_a_of_type_Apnf == null));
    this.a.jdField_a_of_type_Apnf.a(paramString.fProgress);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    bigj.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt2);
    if (paramLong2 != this.a.jdField_a_of_type_Apkt.a()) {}
    while (this.a.jdField_a_of_type_Apnf == null) {
      return;
    }
    if (!paramBoolean)
    {
      apug.a(paramLong2, paramInt2, paramString2);
      this.a.jdField_a_of_type_Apnf.g();
      return;
    }
    if (this.a.e() == 2)
    {
      new Handler().postDelayed(new C2CFileModel.1.1(this), 1000L);
      return;
    }
    this.a.jdField_a_of_type_Apnf.f();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Apkt.a()) {}
    while (this.a.jdField_a_of_type_Apnf == null) {
      return;
    }
    this.a.jdField_a_of_type_Apnf.d();
  }
  
  protected void c(int paramInt, String paramString)
  {
    apug.a(paramString);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aplx
 * JD-Core Version:    0.7.0.1
 */