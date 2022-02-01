package com.tencent.aelight.camera.ae.camera.ui.capture;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
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
    if (VideoStoryCapturePart.k(this.a) == paramRatio) {
      return;
    }
    VideoStoryCapturePart.a(this.a, paramRatio);
    int i = 0;
    if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_4_3) {
      i = VideoStoryCapturePart.l(this.a);
    } else if (paramRatio == AEVideoStoryTopBarViewModel.Ratio.R_1_1) {
      i = VideoStoryCapturePart.b;
    }
    localObject = AEPreviewSizeUtil.a();
    paramRatio = AEPreviewSizeUtil.a(VideoStoryCapturePart.f(this.a), (Size)localObject, VideoStoryCapturePart.m(this.a), paramRatio);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mCurrentRatio---mCaptureMode");
    localStringBuilder.append(VideoStoryCapturePart.f(this.a));
    AEQLog.b("VideoStoryCapturePart", localStringBuilder.toString());
    if (VideoStoryCapturePart.m(this.a)) {
      VideoStoryCapturePart.a(this.a, i, paramRatio);
    } else if (VideoStoryCapturePart.f(this.a) == AECaptureMode.NORMAL) {
      VideoStoryCapturePart.b(this.a, i, (Size)localObject);
    } else {
      VideoStoryCapturePart.a(this.a, i, paramRatio);
    }
    VideoStoryCapturePart.a(this.a, (Size)localObject, paramRatio);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.capture.VideoStoryCapturePart.7
 * JD-Core Version:    0.7.0.1
 */