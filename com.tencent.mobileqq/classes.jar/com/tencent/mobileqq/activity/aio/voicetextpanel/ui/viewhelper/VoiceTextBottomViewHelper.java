package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;

public class VoiceTextBottomViewHelper
{
  private LinearLayout a;
  private View b;
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextBottomViewHelper", 2, "hideBottom");
    }
    this.a.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.bottomMargin = 0;
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    this.a = ((LinearLayout)paramVoiceTextPanel.findViewById(2131429680));
    this.b = paramVoiceTextPanel.findViewById(2131437197);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VoiceTextBottomViewHelper", 2, "showBottom");
    }
    this.a.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.bottomMargin = ScreenUtil.dip2px(75.0F);
    this.b.setLayoutParams(localLayoutParams);
  }
  
  public void c()
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextBottomViewHelper
 * JD-Core Version:    0.7.0.1
 */