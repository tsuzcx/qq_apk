package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable;
import com.tencent.mobileqq.editor.composite.util.GifDecoderWrapper;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

@KeepClassConstructor
public class AnimationDecodeWrapper
  implements GifDecoderWrapper
{
  private String a;
  private InfoStickerDrawable b;
  
  public AnimationDecodeWrapper(String paramString1, String paramString2)
  {
    this.a = paramString2;
  }
  
  public int a()
  {
    return 3;
  }
  
  public Bitmap getNextGifFrame(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("timestamp:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("AnimationDecodeWrapper", 2, ((StringBuilder)localObject).toString());
    }
    paramLong = paramLong / 1000L / 1000L;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("timestampMs:");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("AnimationDecodeWrapper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if (localObject != null) {
      return ((InfoStickerDrawable)localObject).a(paramLong);
    }
    return null;
  }
  
  public void init()
  {
    this.b = InformationFaceConstant.a(MobileQQ.getContext(), this.a);
  }
  
  public void release()
  {
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.paster.AnimationDecodeWrapper
 * JD-Core Version:    0.7.0.1
 */