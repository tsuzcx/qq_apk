package com.tencent.aelight.camera.ae.camera.ui;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.core.AECameraGLSurfaceView;
import com.tencent.aelight.camera.ae.data.AEGifMaterialManager;
import com.tencent.aelight.camera.ae.data.AEMaterialWrapper;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.log.AEQLog;

class VideoStoryPiecesPart$9
  implements Observer<AEMaterialWrapper>
{
  VideoStoryPiecesPart$9(VideoStoryPiecesPart paramVideoStoryPiecesPart) {}
  
  public void a(@Nullable AEMaterialWrapper paramAEMaterialWrapper)
  {
    if (VideoStoryPiecesPart.C(this.a) == AECaptureMode.GIF)
    {
      if (paramAEMaterialWrapper != null) {
        paramAEMaterialWrapper = AEGifMaterialManager.a().a(paramAEMaterialWrapper.b);
      } else {
        paramAEMaterialWrapper = AEResUtil.m();
      }
      AEGifMaterialManager.a().b(paramAEMaterialWrapper);
      VideoStoryPiecesPart.D(this.a).setMaterial(paramAEMaterialWrapper);
      AEQLog.a("VideoStoryPiecesPart", "[GifAuthor]---checkShowGifAuthor when material change");
      VideoStoryPiecesPart.E(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart.9
 * JD-Core Version:    0.7.0.1
 */