package com.tencent.aelight.camera.ae.camera.ui.bottom;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.VideoStoryPiecesPart;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import com.tencent.aelight.camera.ae.view.AECircleCaptureStyle;

class AECircleBottomListPart$2
  implements Observer<AEVideoStoryTopBarViewModel.Ratio>
{
  AECircleBottomListPart$2(AECircleBottomListPart paramAECircleBottomListPart) {}
  
  public void a(@Nullable AEVideoStoryTopBarViewModel.Ratio paramRatio)
  {
    AEBottomListAdapter.b(VideoStoryPiecesPart.a(paramRatio).n);
    this.a.c.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.bottom.AECircleBottomListPart.2
 * JD-Core Version:    0.7.0.1
 */