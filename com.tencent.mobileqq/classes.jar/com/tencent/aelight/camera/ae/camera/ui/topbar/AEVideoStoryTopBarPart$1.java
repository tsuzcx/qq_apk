package com.tencent.aelight.camera.ae.camera.ui.topbar;

import android.app.Activity;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.WindowInsetsCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import com.tencent.mobileqq.utils.ViewUtils;

class AEVideoStoryTopBarPart$1
  implements OnApplyWindowInsetsListener
{
  AEVideoStoryTopBarPart$1(AEVideoStoryTopBarPart paramAEVideoStoryTopBarPart) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    if ((paramView instanceof ViewGroup))
    {
      paramView = (ViewGroup)paramView.findViewById(2064122223);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
      int j = paramWindowInsetsCompat.getSystemWindowInsetTop();
      int i = j;
      if (AEVideoStoryTopBarPart.a(this.a) != null)
      {
        i = j;
        if (AEVideoStoryTopBarPart.a(this.a).a() != null)
        {
          i = j;
          if (!AECameraEntryManager.k(AEVideoStoryTopBarPart.a(this.a).a().getIntent())) {
            i = j / 2;
          }
        }
      }
      if (AEVideoStoryTopBarPart.a(this.a)) {
        i = ViewUtils.a(20.0F);
      }
      localMarginLayoutParams.topMargin = i;
      paramView.setLayoutParams(localMarginLayoutParams);
    }
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarPart.1
 * JD-Core Version:    0.7.0.1
 */