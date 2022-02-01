package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$4
  implements View.OnFocusChangeListener
{
  WatermarkEditListAdapter$4(WatermarkEditListAdapter paramWatermarkEditListAdapter, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder, WMElement paramWMElement) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      WatermarkEditListAdapter.a(this.c, this.a.a, this.b);
      this.a.c.setBackgroundResource(2063925381);
      this.a.c.setVisibility(0);
      return;
    }
    this.a.c.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.4
 * JD-Core Version:    0.7.0.1
 */