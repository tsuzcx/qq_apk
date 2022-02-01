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
    ((TextView)CaptureModeAdapter.a(this.a).get(CaptureModeAdapter.a(this.a))).setTextColor(CaptureModeAdapter.b(this.a));
    CaptureModeAdapter.a(this.a, localInteger.intValue());
    if (CaptureModeAdapter.a(this.a) != null) {
      CaptureModeAdapter.a(this.a).a(localInteger.intValue(), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.CaptureModeAdapter.1
 * JD-Core Version:    0.7.0.1
 */