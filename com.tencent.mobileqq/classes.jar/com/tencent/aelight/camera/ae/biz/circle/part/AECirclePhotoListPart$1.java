package com.tencent.aelight.camera.ae.biz.circle.part;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.aelight.camera.ae.view.NoScrollViewPager;

class AECirclePhotoListPart$1
  implements RadioGroup.OnCheckedChangeListener
{
  AECirclePhotoListPart$1(AECirclePhotoListPart paramAECirclePhotoListPart) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    if (AECirclePhotoListPart.a(this.a).getId() == paramInt)
    {
      AECirclePhotoListPart.b(this.a).setCurrentItem(0);
      AECirclePhotoListPart.a(this.a, 0);
      return;
    }
    if (AECirclePhotoListPart.c(this.a).getId() == paramInt)
    {
      AECirclePhotoListPart.b(this.a).setCurrentItem(1);
      AECirclePhotoListPart.a(this.a, 1);
      return;
    }
    if (AECirclePhotoListPart.d(this.a).getId() == paramInt)
    {
      AECirclePhotoListPart.b(this.a).setCurrentItem(2);
      AECirclePhotoListPart.a(this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECirclePhotoListPart.1
 * JD-Core Version:    0.7.0.1
 */