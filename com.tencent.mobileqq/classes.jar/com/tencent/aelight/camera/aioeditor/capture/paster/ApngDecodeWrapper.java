package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.mobileqq.dov.vas.api.IVasApngIPCModule;
import com.tencent.mobileqq.editor.composite.util.GifDecoderWrapper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

@KeepClassConstructor
public class ApngDecodeWrapper
  implements GifDecoderWrapper
{
  private NativeApngDecoder jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterNativeApngDecoder;
  private String jdField_a_of_type_JavaLangString;
  
  public ApngDecodeWrapper(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public ApngDecodeWrapper(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
  }
  
  public int a()
  {
    return 1;
  }
  
  public Bitmap getNextGifFrame(long paramLong)
  {
    NativeApngDecoder localNativeApngDecoder = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterNativeApngDecoder;
    if (localNativeApngDecoder != null) {
      return localNativeApngDecoder.a(paramLong);
    }
    return null;
  }
  
  public void init()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (!((IVasApngIPCModule)QRoute.api(IVasApngIPCModule.class)).loadSoLib())
    {
      ((IVasApngIPCModule)QRoute.api(IVasApngIPCModule.class)).download();
      if (QLog.isColorLevel()) {
        QLog.d("ApngDecodeWrapper", 2, "so not loaded");
      }
      return;
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString);
    if ((localFile.exists()) && (localFile.isFile())) {
      try
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterNativeApngDecoder = new NativeApngDecoder(localFile);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void release()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCapturePasterNativeApngDecoder = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.ApngDecodeWrapper
 * JD-Core Version:    0.7.0.1
 */