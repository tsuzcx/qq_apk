package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$1
  implements View.OnClickListener
{
  WatermarkEditListAdapter$1(WatermarkEditListAdapter paramWatermarkEditListAdapter, WMElement paramWMElement, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder) {}
  
  public void onClick(View paramView)
  {
    if ("CHECK_IN".equals(this.a.type))
    {
      WatermarkEditListAdapter.a(this.c, this.b);
      return;
    }
    this.b.a.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.1
 * JD-Core Version:    0.7.0.1
 */