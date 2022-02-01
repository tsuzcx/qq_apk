package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.util.AEPreviewSizeUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.activity.richmedia.Size;

class VideoStoryCapturePart$7
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  VideoStoryCapturePart$7(VideoStoryCapturePart paramVideoStoryCapturePart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mCurrentRatio---onChanged: ratio=");
    ((StringBuilder)localObject).append(paramRatio);
    AEQLog.b("VideoStoryCapturePart", ((StringBuilder)localObject).toString());
    if (paramRatio == null) {
      return;
    }
    if (VideoStoryCapturePart.a(this.a) == paramRatio) {
      return;
    }
    VideoStoryCapturePart.a(this.a, paramRatio);
    int i = 0;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
      i = VideoStoryCapturePart.a(this.a);
    } else if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      i = VideoStoryCapturePart.a;
    }
    localObject = AEPreviewSizeUtil.a();
    paramRatio = AEPreviewSizeUtil.a(VideoStoryCapturePart.a(this.a), (Size)localObject, VideoStoryCapturePart.b(this.a), paramRatio);
    VideoStoryCapturePart.a(this.a, i, paramRatio);
    VideoStoryCapturePart.a(this.a, (Size)localObject, paramRatio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.7
 * JD-Core Version:    0.7.0.1
 */