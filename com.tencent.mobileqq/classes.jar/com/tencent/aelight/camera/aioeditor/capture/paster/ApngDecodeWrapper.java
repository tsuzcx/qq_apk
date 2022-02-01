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
  private NativeApngDecoder a;
  private String b;
  
  public ApngDecodeWrapper(String paramString)
  {
    this.b = paramString;
  }
  
  public ApngDecodeWrapper(String paramString1, String paramString2)
  {
    this.b = paramString1;
  }
  
  public int a()
  {
    return 1;
  }
  
  public Bitmap getNextGifFrame(long paramLong)
  {
    NativeApngDecoder localNativeApngDecoder = this.a;
    if (localNativeApngDecoder != null) {
      return localNativeApngDecoder.a(paramLong);
    }
    return null;
  }
  
  public void init()
  {
    if (TextUtils.isEmpty(this.b)) {
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
    File localFile = new File(this.b);
    if ((localFile.exists()) && (localFile.isFile())) {
      try
      {
        this.a = new NativeApngDecoder(localFile);
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
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.ApngDecodeWrapper
 * JD-Core Version:    0.7.0.1
 */