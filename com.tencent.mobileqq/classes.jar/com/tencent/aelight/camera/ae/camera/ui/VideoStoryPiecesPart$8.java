package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.log.AEQLog;

class VideoStoryPiecesPart$8
  implements Observer<AEMaterialWrapper>
{
  VideoStoryPiecesPart$8(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (VideoStoryPiecesPart.a(this.a) == AECaptureMode.GIF)
    {
      if (paramAEMaterialWrapper != null) {
        paramAEMaterialWrapper = AEGifMaterialManager.a().a(paramAEMaterialWrapper.a);
      } else {
        paramAEMaterialWrapper = AEResUtil.f();
      }
      AEGifMaterialManager.a().a(paramAEMaterialWrapper);
      VideoStoryPiecesPart.a(this.a).setMaterial(paramAEMaterialWrapper);
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when material change");
      VideoStoryPiecesPart.c(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.8
 * JD-Core Version:    0.7.0.1
 */