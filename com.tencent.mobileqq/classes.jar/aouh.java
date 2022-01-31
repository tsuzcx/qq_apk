import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.1.1;
import com.tencent.qphone.base.util.QLog;

public class aouh
  extends aodp
{
  aouh(aoug paramaoug) {}
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    bgwq.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt);
    if (paramLong != this.a.jdField_a_of_type_Aotf.a().nSessionId) {
      return;
    }
    apck.a(paramLong, paramInt, paramString);
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    super.a(paramLong1, paramLong2);
    if ((paramLong1 == this.a.jdField_a_of_type_Aotf.a()) && (this.a.jdField_a_of_type_Aotc != null)) {
      this.a.jdField_a_of_type_Aotc.a();
    }
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.jdField_a_of_type_Aotf.a().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    apck.a(paramString2);
  }
  
  protected void a(aooa paramaooa)
  {
    if ((TextUtils.isEmpty(paramaooa.a)) || (TextUtils.isEmpty(paramaooa.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramaooa.a + " [path] = " + paramaooa.b);
      }
    }
    while (this.a.jdField_a_of_type_Aovn == null) {
      return;
    }
    this.a.jdField_a_of_type_Aovn.a(paramaooa.a, paramaooa.b);
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    apck.a(paramLong, paramInteger.intValue(), paramString);
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
        } while (this.a.jdField_a_of_type_Aovn == null);
        this.a.jdField_a_of_type_Aovn.a(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.a.d() != paramLong) || (this.a.jdField_a_of_type_Aovn == null));
      this.a.jdField_a_of_type_Aovn.a(String.valueOf(paramLong), paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
  }
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      apck.a(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Aotf.a()) {}
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_Aotf.a();
    } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (this.a.jdField_a_of_type_Aovo == null));
    this.a.jdField_a_of_type_Aovo.a(paramString.fProgress);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    bgwq.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt2);
    if (paramLong2 != this.a.jdField_a_of_type_Aotf.a()) {}
    while (this.a.jdField_a_of_type_Aovo == null) {
      return;
    }
    if (!paramBoolean)
    {
      apck.a(paramLong2, paramInt2, paramString2);
      this.a.jdField_a_of_type_Aovo.g();
      return;
    }
    if (this.a.e() == 2)
    {
      new Handler().postDelayed(new C2CFileModel.1.1(this), 1000L);
      return;
    }
    this.a.jdField_a_of_type_Aovo.f();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Aotf.a()) {}
    while (this.a.jdField_a_of_type_Aovo == null) {
      return;
    }
    this.a.jdField_a_of_type_Aovo.d();
  }
  
  protected void c(int paramInt, String paramString)
  {
    apck.a(paramString);
  }
  
  protected void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aouh
 * JD-Core Version:    0.7.0.1
 */