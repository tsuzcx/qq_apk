import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVideoSoDownloadModule;

public class bjgr
  implements azef
{
  ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  
  public bjgr(QzoneVideoSoDownloadModule paramQzoneVideoSoDownloadModule, ResultReceiver paramResultReceiver)
  {
    this.jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
  }
  
  public void G_()
  {
    QLog.e("QzoneVideoSoDownloadModule", 1, "onNetWorkNone");
    QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -3, alud.a(2131712863));
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.i("QzoneVideoSoDownloadModule", 1, "onDownloadFinish name=" + paramString1 + " result=" + paramInt + " filePath=" + paramString2);
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label111;
      }
      QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -3, alud.a(2131712872) + paramInt + "]");
      azdh.b(2, paramInt);
    }
    for (;;)
    {
      if (paramString1.startsWith("new_qq_android_native_short_filter_")) {}
      return;
      label111:
      if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramString2 = new Bundle();
        this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramString2);
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneVideoSoDownloadModule", 4, "onUpdateProgress: name=" + paramString + " curOffset=" + paramLong1 + " totalLen=" + paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjgr
 * JD-Core Version:    0.7.0.1
 */