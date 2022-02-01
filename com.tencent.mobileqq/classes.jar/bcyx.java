import android.os.Build.VERSION;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;

class bcyx
  implements VideoConverter.Processor
{
  bcyp jdField_a_of_type_Bcyp;
  bcyy jdField_a_of_type_Bcyy;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  final String b;
  
  bcyx(WeakReference<QQAppInterface> paramWeakReference, String paramString1, String paramString2, bcyp parambcyp, bcyy parambcyy)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.b = paramString1;
    this.jdField_a_of_type_Bcyy = parambcyy;
    this.jdField_a_of_type_JavaLangThrowable = null;
    if (paramString2 == null) {
      throw new IllegalArgumentException("null == outputFilePath");
    }
    this.jdField_a_of_type_Bcyp = parambcyp;
  }
  
  private boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public VideoConverter.VideoConvertConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if (localFile.exists()) {
      localFile.delete();
    }
    localVideoConvertConfig.output = localFile;
    localVideoConvertConfig.scaleRate = this.jdField_a_of_type_Bcyp.jdField_a_of_type_Float;
    localVideoConvertConfig.videoFrameRate = ((int)this.jdField_a_of_type_Bcyp.b);
    localVideoConvertConfig.videoBitRate = ((int)this.jdField_a_of_type_Bcyp.jdField_a_of_type_Long);
    localVideoConvertConfig.setRotation = a();
    return localVideoConvertConfig;
  }
  
  public void onCanceled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onCanceled!");
    }
    if (this.jdField_a_of_type_Bcyy != null) {
      this.jdField_a_of_type_Bcyy.a(3);
    }
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
    if (this.jdField_a_of_type_Bcyy != null) {
      this.jdField_a_of_type_Bcyy.a(2);
    }
  }
  
  public void onProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
    if ((this.jdField_a_of_type_Bcyy != null) && (paramInt >= 0) && (paramInt <= 10000)) {
      this.jdField_a_of_type_Bcyy.a(paramInt / 10000.0F);
    }
  }
  
  public void onSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSucceed");
    }
    if (this.jdField_a_of_type_Bcyy != null) {
      this.jdField_a_of_type_Bcyy.a(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcyx
 * JD-Core Version:    0.7.0.1
 */