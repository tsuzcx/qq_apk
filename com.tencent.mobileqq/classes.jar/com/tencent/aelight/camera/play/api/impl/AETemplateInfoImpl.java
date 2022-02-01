package com.tencent.aelight.camera.play.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.aelight.camera.ae.play.AETemplateInfoFragment;
import com.tencent.aelight.camera.play.api.IAETemplateInfo;

public class AETemplateInfoImpl
  implements IAETemplateInfo
{
  public void sendPickedPhotosToMe(Context paramContext, Intent paramIntent)
  {
    AETemplateInfoFragment.sendPickedPhotosToMe(paramContext, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.play.api.impl.AETemplateInfoImpl
 * JD-Core Version:    0.7.0.1
 */