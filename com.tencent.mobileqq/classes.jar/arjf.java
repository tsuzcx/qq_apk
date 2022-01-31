import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.1.1;
import com.tencent.qphone.base.util.QLog;

public class arjf
  extends aqru
{
  arjf(arje paramarje) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    bkmm.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt);
    if (paramLong != this.a.jdField_a_of_type_Arhz.a().nSessionId) {
      return;
    }
    arrr.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if ((paramLong1 == this.a.jdField_a_of_type_Arhz.a()) && (this.a.jdField_a_of_type_Arhw != null)) {
      this.a.jdField_a_of_type_Arhw.a();
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.jdField_a_of_type_Arhz.a().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    arrr.a(paramString2);
  }
  
  protected void a(arcg paramarcg)
  {
    if ((TextUtils.isEmpty(paramarcg.a)) || (TextUtils.isEmpty(paramarcg.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramarcg.a + " [path] = " + paramarcg.b);
      }
    }
    while (this.a.jdField_a_of_type_Arkn == null) {
      return;
    }
    this.a.jdField_a_of_type_Arkn.a(paramarcg.a, paramarcg.b);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    arrr.a(paramLong, paramInteger.intValue(), paramString);
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
        } while (this.a.jdField_a_of_type_Arkn == null);
        this.a.jdField_a_of_type_Arkn.a(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.a.d() != paramLong) || (this.a.jdField_a_of_type_Arkn == null));
      this.a.jdField_a_of_type_Arkn.a(String.valueOf(paramLong), paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      arrr.a(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Arhz.a()) {}
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_Arhz.a();
    } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (this.a.jdField_a_of_type_Arko == null));
    this.a.jdField_a_of_type_Arko.a(paramString.fProgress);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    bkmm.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt2);
    if (paramLong2 != this.a.jdField_a_of_type_Arhz.a()) {}
    while (this.a.jdField_a_of_type_Arko == null) {
      return;
    }
    if (!paramBoolean)
    {
      arrr.a(paramLong2, paramInt2, paramString2);
      this.a.jdField_a_of_type_Arko.g();
      return;
    }
    if (this.a.e() == 2)
    {
      new Handler().postDelayed(new C2CFileModel.1.1(this), 1000L);
      return;
    }
    this.a.jdField_a_of_type_Arko.f();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Arhz.a()) {}
    while (this.a.jdField_a_of_type_Arko == null) {
      return;
    }
    this.a.jdField_a_of_type_Arko.d();
  }
  
  protected void c(int paramInt, String paramString)
  {
    arrr.a(paramString);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arjf
 * JD-Core Version:    0.7.0.1
 */