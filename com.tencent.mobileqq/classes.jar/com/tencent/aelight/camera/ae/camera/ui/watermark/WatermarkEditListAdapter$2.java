package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.ae.camera.ui.poi.AESelectLocationFragment;

class WatermarkEditListAdapter$2
  implements View.OnClickListener
{
  WatermarkEditListAdapter$2(WatermarkEditListAdapter paramWatermarkEditListAdapter) {}
  
  public void onClick(View paramView)
  {
    paramView = (InputMethodManager)AEModule.getContext().getSystemService("input_method");
    if (WatermarkEditListAdapter.a(this.a) != null)
    {
      paramView.hideSoftInputFromWindow(WatermarkEditListAdapter.a(this.a).getWindowToken(), 0);
      paramView = this.a;
      WatermarkEditListAdapter.a(paramView, WatermarkEditListAdapter.a(paramView));
      WatermarkEditListAdapter.a(this.a).setTextColor(-1);
    }
    if (WatermarkEditListAdapter.b(this.a) != null) {
      WatermarkEditListAdapter.b(this.a).b();
    }
    AESelectLocationFragment.a(WatermarkEditListAdapter.c(this.a), 203);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.2
 * JD-Core Version:    0.7.0.1
 */