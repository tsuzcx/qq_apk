import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneVideoSoDownloadModule;

public class bmvz
  implements bcxw
{
  ResultReceiver jdField_a_of_type_AndroidOsResultReceiver;
  
  public bmvz(QzoneVideoSoDownloadModule paramQzoneVideoSoDownloadModule, ResultReceiver paramResultReceiver)
  {
    this.jdField_a_of_type_AndroidOsResultReceiver = paramResultReceiver;
  }
  
  public void B_()
  {
    QLog.e("QzoneVideoSoDownloadModule", 1, "onNetWorkNone");
    QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -3, anzj.a(2131711351));
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.i("QzoneVideoSoDownloadModule", 1, "onDownloadFinish name=" + paramString1 + " result=" + paramInt + " filePath=" + paramString2);
    if (paramString1.startsWith("new_qq_android_native_short_video_"))
    {
      if (paramInt == 0) {
        break label102;
      }
      QzoneVideoSoDownloadModule.a(this.jdField_a_of_type_CooperationQzoneQzoneVideoSoDownloadModule, this.jdField_a_of_type_AndroidOsResultReceiver, -3, anzj.a(2131711360) + paramInt + "]");
      bcwy.b(2, paramInt);
    }
    label102:
    while (this.jdField_a_of_type_AndroidOsResultReceiver == null) {
      return;
    }
    paramString1 = new Bundle();
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramString1);
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("QzoneVideoSoDownloadModule", 4, "onUpdateProgress: name=" + paramString + " curOffset=" + paramLong1 + " totalLen=" + paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmvz
 * JD-Core Version:    0.7.0.1
 */