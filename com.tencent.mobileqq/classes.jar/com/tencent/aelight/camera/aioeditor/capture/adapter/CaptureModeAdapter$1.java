package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import java.util.List;

class CaptureModeAdapter$1
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    Integer localInteger = (Integer)paramView.getTag();
    if (localInteger.intValue() == CaptureModeAdapter.a(this.a)) {
      return;
    }
    ((TextView)CaptureModeAdapter.b(this.a).get(CaptureModeAdapter.a(this.a))).setTextColor(CaptureModeAdapter.c(this.a));
    CaptureModeAdapter.a(this.a, localInteger.intValue());
    if (CaptureModeAdapter.d(this.a) != null) {
      CaptureModeAdapter.d(this.a).a(localInteger.intValue(), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.CaptureModeAdapter.1
 * JD-Core Version:    0.7.0.1
 */