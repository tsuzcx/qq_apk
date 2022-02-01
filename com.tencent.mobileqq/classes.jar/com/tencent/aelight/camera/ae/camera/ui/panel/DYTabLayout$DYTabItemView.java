package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;

class DYTabLayout$DYTabItemView
  extends FrameLayout
{
  TextView a;
  int b;
  
  public DYTabLayout$DYTabItemView(DYTabLayout paramDYTabLayout, @NonNull Context paramContext, String paramString, int paramInt)
  {
    super(paramContext);
    this.b = paramInt;
    paramInt = (int)TypedValue.applyDimension(1, 7.0F, paramContext.getResources().getDisplayMetrics());
    setPadding(paramInt, 0, paramInt, 0);
    this.a = new TextView(paramContext);
    this.a.setTextSize(1, 12.0F);
    this.a.setText(paramString);
    a();
    paramDYTabLayout = generateDefaultLayoutParams();
    paramDYTabLayout.width = -2;
    paramDYTabLayout.height = -2;
    paramDYTabLayout.gravity = 17;
    addView(this.a, paramDYTabLayout);
  }
  
  private void a()
  {
    TextView localTextView = this.a;
    String str;
    if (isSelected()) {
      str = "#FFFFFF";
    } else {
      str = "#99FFFFFF";
    }
    localTextView.setTextColor(Color.parseColor(str));
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYTabLayout.DYTabItemView
 * JD-Core Version:    0.7.0.1
 */