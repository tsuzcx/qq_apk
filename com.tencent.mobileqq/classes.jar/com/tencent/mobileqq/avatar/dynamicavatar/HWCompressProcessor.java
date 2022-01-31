package com.tencent.mobileqq.avatar.dynamicavatar;

import android.os.Build.VERSION;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class HWCompressProcessor
  implements VideoConverter.Processor
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  Throwable jdField_a_of_type_JavaLangThrowable;
  final int b;
  final int c;
  
  public VideoConverter.VideoConvertConfig a(int paramInt1, int paramInt2)
  {
    int i = 18;
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    if (paramInt1 <= paramInt2)
    {
      File localFile = new File(this.jdField_a_of_type_JavaLangString);
      if (localFile.exists()) {
        localFile.delete();
      }
      localVideoConvertConfig.jdField_a_of_type_JavaIoFile = localFile;
      localVideoConvertConfig.jdField_a_of_type_Float = (this.c / paramInt2);
      localVideoConvertConfig.jdField_a_of_type_Int = ((int)(this.jdField_a_of_type_Int * localVideoConvertConfig.jdField_a_of_type_Float * localVideoConvertConfig.jdField_a_of_type_Float + 0.5F));
      if (localVideoConvertConfig.jdField_a_of_type_Int <= 460800) {
        break label181;
      }
      localVideoConvertConfig.jdField_a_of_type_Int = 460800;
    }
    for (;;)
    {
      paramInt1 = i;
      if (this.jdField_b_of_type_Int <= 18) {
        paramInt1 = this.jdField_b_of_type_Int;
      }
      localVideoConvertConfig.jdField_b_of_type_Int = paramInt1;
      localVideoConvertConfig.jdField_b_of_type_Boolean = a();
      if (QLog.isColorLevel()) {
        QLog.i("HWCompressProcessor", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.jdField_b_of_type_Boolean);
      }
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
      break;
      label181:
      if (localVideoConvertConfig.jdField_a_of_type_Int < 51200) {
        localVideoConvertConfig.jdField_a_of_type_Int = 51200;
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("HWCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onSuccessed");
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("HWCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onProgress:" + paramInt);
    }
  }
  
  public void a(Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.e("HWCompressProcessor", 2, "CompressTask, step: HWCompressProcessor onFailed");
    }
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
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
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.dynamicavatar.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */