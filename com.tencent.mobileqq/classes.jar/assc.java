import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.model.C2CFileModel.C2CFileObserver.1;
import com.tencent.qphone.base.util.QLog;

public class assc
  extends asbj
{
  private assc(asrx paramasrx) {}
  
  protected void onFileTransferEnd(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CFileModel<FileAssistant>", 2, "OnFileTransferEnd : isSuccess[" + paramBoolean + "], uniseq[" + paramLong1 + "], nSessionId[" + paramLong2 + paramString1 + "], peerType[" + paramInt1 + "]");
    }
    blho.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt2);
    if (paramLong2 != this.a.jdField_a_of_type_Asqs.a()) {}
    while (this.a.jdField_a_of_type_Assz == null) {
      return;
    }
    if (!paramBoolean)
    {
      aszt.a(paramLong2, paramInt2, paramString2);
      this.a.jdField_a_of_type_Assz.g();
      return;
    }
    if (this.a.e() == 2)
    {
      new Handler().postDelayed(new C2CFileModel.C2CFileObserver.1(this), 1000L);
      return;
    }
    this.a.jdField_a_of_type_Assz.f();
  }
  
  protected void onFileTransferProgress(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Asqs.a()) {}
    do
    {
      return;
      paramString = this.a.jdField_a_of_type_Asqs.a();
    } while ((paramString == null) || ((paramString.getCloudType() == 0) && (paramString.nOpType == 10)) || (this.a.jdField_a_of_type_Assz == null));
    this.a.jdField_a_of_type_Assz.a(paramString.fProgress);
  }
  
  protected void onFileTransferStart(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    if (paramLong2 != this.a.jdField_a_of_type_Asqs.a()) {}
    while (this.a.jdField_a_of_type_Assz == null) {
      return;
    }
    this.a.jdField_a_of_type_Assz.d();
  }
  
  protected void onForwardOfflineFile(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    if (!paramBoolean) {
      aszt.a(paramLong3, paramInt, paramString1);
    }
  }
  
  protected void onMMApkFileSafeCheckResult(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramLong != this.a.jdField_a_of_type_Asqs.a().nSessionId) {}
    while ((this.a.jdField_a_of_type_Assw == null) || (paramInt1 != 0)) {
      return;
    }
    this.a.jdField_a_of_type_Assw.a(paramInt2, paramString1, paramString2, paramBundle);
  }
  
  protected void onOfflineSendToWeiYunFaild(int paramInt, long paramLong, String paramString)
  {
    blho.a(this.a.jdField_a_of_type_AndroidAppActivity, paramInt);
    if (paramLong != this.a.jdField_a_of_type_Asqs.a().nSessionId) {
      return;
    }
    aszt.a(paramLong, paramInt, paramString);
  }
  
  protected void onOfflineSendToWeiYunSuccess(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if (paramLong != this.a.jdField_a_of_type_Asqs.a().nSessionId) {}
    while ((paramString2 == null) || (paramString2.length() <= 0) || (paramInt == 0)) {
      return;
    }
    aszt.c(paramString2);
  }
  
  protected void onOnlineFileUpDone(long paramLong1, long paramLong2)
  {
    super.onOnlineFileUpDone(paramLong1, paramLong2);
    if ((paramLong1 == this.a.jdField_a_of_type_Asqs.a()) && (this.a.jdField_a_of_type_Asqp != null)) {
      this.a.jdField_a_of_type_Asqp.a();
    }
  }
  
  protected void onShowToast(int paramInt, String paramString)
  {
    aszt.c(paramString);
  }
  
  protected void onThumbDownLoadSuccess(aslv paramaslv)
  {
    if ((TextUtils.isEmpty(paramaslv.a)) || (TextUtils.isEmpty(paramaslv.b))) {
      if (QLog.isColorLevel()) {
        QLog.i("C2CFileModel<FileAssistant>", 2, "OnThumbDownLoad error : [fileId] = " + paramaslv.a + " [path] = " + paramaslv.b);
      }
    }
    while (this.a.jdField_a_of_type_Assy == null) {
      return;
    }
    this.a.jdField_a_of_type_Assy.a(paramaslv.a, paramaslv.b);
  }
  
  protected void onWeiYunSendToOfflineFaild(Integer paramInteger, long paramLong, String paramString)
  {
    aszt.a(paramLong, paramInteger.intValue(), paramString);
  }
  
  protected void onWeiYunSendToOfflineSuccess() {}
  
  protected void onZipImageThumbDownloadCompleted(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
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
        } while (this.a.jdField_a_of_type_Assy == null);
        this.a.jdField_a_of_type_Assy.a(String.valueOf(paramLong), paramString2);
        return;
        if (paramInt != 0) {
          break;
        }
      } while ((this.a.d() != paramLong) || (this.a.jdField_a_of_type_Assy == null));
      this.a.jdField_a_of_type_Assy.a(String.valueOf(paramLong), paramString2);
      return;
    } while (!QLog.isColorLevel());
    QLog.i("C2CFileModel<FileAssistant>", 2, "OnZipImageThumbDownloadCompleted : sessionId[" + paramLong + "]  thumbPath[" + paramString2 + "] but current file browser can not handle");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     assc
 * JD-Core Version:    0.7.0.1
 */