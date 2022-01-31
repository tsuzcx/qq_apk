package com.tencent.mobileqq.activity.selectable;

import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.widget.ScrollView;

class TextPreviewMenu$3
  implements Runnable
{
  TextPreviewMenu$3(TextPreviewMenu paramTextPreviewMenu, TextPreviewActivity paramTextPreviewActivity) {}
  
  public void run()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)this.a.findViewById(2131371264);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    localLayoutParams.height = this.a.a.getHeight();
    localRelativeLayout.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextPreviewMenu.3
 * JD-Core Version:    0.7.0.1
 */