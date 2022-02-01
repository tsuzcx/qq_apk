package com.tencent.aelight.camera.ae;

import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEBeautyConfigModel;
import com.tencent.aelight.camera.ae.camera.ui.panel.SeekBarOpDataWrapper;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.ttpic.openapi.config.BeautyRealConfig.TYPE;
import java.util.List;

class AEPituCameraUnit$57
  implements Observer<SeekBarOpDataWrapper>
{
  AEPituCameraUnit$57(AEPituCameraUnit paramAEPituCameraUnit) {}
  
  public void a(SeekBarOpDataWrapper paramSeekBarOpDataWrapper)
  {
    if (!this.a.Y()) {
      return;
    }
    if (paramSeekBarOpDataWrapper != null)
    {
      if (!paramSeekBarOpDataWrapper.c())
      {
        AEQLog.b(this.a.a, "not refresh effect");
        return;
      }
      int i = paramSeekBarOpDataWrapper.a();
      paramSeekBarOpDataWrapper = paramSeekBarOpDataWrapper.b();
      if (i != 2) {
        return;
      }
      if ((paramSeekBarOpDataWrapper instanceof AEBeautyConfigModel))
      {
        paramSeekBarOpDataWrapper = (AEBeautyConfigModel)paramSeekBarOpDataWrapper;
        String str = this.a.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("beautySelected: ");
        localStringBuilder.append(paramSeekBarOpDataWrapper.b());
        AEQLog.a(str, localStringBuilder.toString());
        if (!paramSeekBarOpDataWrapper.i().isEmpty())
        {
          AEPituCameraUnit.a(this.a, paramSeekBarOpDataWrapper, false);
          return;
        }
        if (paramSeekBarOpDataWrapper.a() == BeautyRealConfig.TYPE.NONE)
        {
          if (paramSeekBarOpDataWrapper.h())
          {
            AEPituCameraUnit.b(this.a);
            return;
          }
          AEPituCameraUnit.t(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AEPituCameraUnit.57
 * JD-Core Version:    0.7.0.1
 */