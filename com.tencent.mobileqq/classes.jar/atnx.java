import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.C2CFileObserver.1;
import com.tencent.qphone.base.util.QLog;

public class atnx
  extends asyw
{
  private atnx(atns paramatns) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    bnaz.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt);
    if (paramLong != this.a.jdField_a_of_type_Atmn.a().nSessionId) {
      return;
    }
    atvo.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramLong != this.a.jdField_a_of_type_Atmn.a().nSessionId) {}
    while ((this.a.jdField_a_of_type_Ator == null) || (paramInt1 != 0)) {
      return;
    }
    this.a.jdField_a_of_type_Ator.a(paramInt2, paramString1, paramString2, paramBundle);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if ((paramLong1 == this.a.jdField_a_of_type_Atmn.a()) && (this.a.jdField_a_of_type_Atmk != null)) {
      this.a.jdField_a_of_type_Atmk.a();
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.jdField_a_of_type_Atmn.a().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    atvo.a(paramString2);
  }
  
  protected void a(athr paramathr)
  {
    if ((TextUtils.isEmpty(paramathr.a)) || (TextUtils.isEmpty(paramathr.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramathr.a + " [path] = " + paramathr.b);
      }
    }
    while (this.a.jdField_a_of_type_Atot == null) {
      return;
    }
    this.a.jdField_a_of_type_Atot.a(paramathr.a, paramathr.b);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    atvo.a(paramLong, paramInteger.intValue(), paramString);
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
        } while (this.a.jdField_a_of_type_Atot == null);
        this.a.jdField_a_of_type_Atot.a(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.a.d() != paramLong) || (this.a.jdField_a_of_type_Atot == null));
      this.a.jdField_a_of_type_Atot.a(String.valueOf(paramLong), paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      atvo.a(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Atmn.a()) {}
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_Atmn.a();
    } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (this.a.jdField_a_of_type_Atou == null));
    this.a.jdField_a_of_type_Atou.a(paramString.fProgress);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    bnaz.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt2);
    if (paramLong2 != this.a.jdField_a_of_type_Atmn.a()) {}
    while (this.a.jdField_a_of_type_Atou == null) {
      return;
    }
    if (!paramBoolean)
    {
      atvo.a(paramLong2, paramInt2, paramString2);
      this.a.jdField_a_of_type_Atou.g();
      return;
    }
    if (this.a.e() == 2)
    {
      new Handler().postDelayed(new C2CFileModel.C2CFileObserver.1(this), 1000L);
      return;
    }
    this.a.jdField_a_of_type_Atou.f();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Atmn.a()) {}
    while (this.a.jdField_a_of_type_Atou == null) {
      return;
    }
    this.a.jdField_a_of_type_Atou.d();
  }
  
  protected void c(int paramInt, String paramString)
  {
    atvo.a(paramString);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atnx
 * JD-Core Version:    0.7.0.1
 */