package com.tencent.aelight.camera.ae.flashshow;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.widget.immersive.SystemBarTintManager;

class AEFlashShowMultiUnit$1
  implements OnApplyWindowInsetsListener
{
  AEFlashShowMultiUnit$1(AEFlashShowMultiUnit paramAEFlashShowMultiUnit) {}
  
  public WindowInsetsCompat onApplyWindowInsets(View paramView, WindowInsetsCompat paramWindowInsetsCompat)
  {
    int j = paramWindowInsetsCompat.getSystemWindowInsetBottom();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("system window bottom insets = ");
    localStringBuilder.append(j);
    AEQLog.b("AEFlashShowMultiUnit", localStringBuilder.toString());
    int i = j;
    if (j <= 0)
    {
      i = j;
      if (DisplayUtil.c(BaseApplicationImpl.getContext()))
      {
        i = SystemBarTintManager.getNavigationBarHeight(BaseApplicationImpl.getContext());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("system navigation bar height = ");
        localStringBuilder.append(i);
        AEQLog.b("AEFlashShowMultiUnit", localStringBuilder.toString());
      }
    }
    paramView.setPadding(0, 0, 0, i);
    return paramWindowInsetsCompat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.AEFlashShowMultiUnit.1
 * JD-Core Version:    0.7.0.1
 */