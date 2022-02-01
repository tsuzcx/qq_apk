package com.tencent.aelight.camera.ae.camera.ui.watermark;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aelight.camera.ae.entry.AECameraEntryManager;
import org.light.bean.WMElement;

class WatermarkEditListAdapter$3
  implements View.OnClickListener
{
  WatermarkEditListAdapter$3(WatermarkEditListAdapter paramWatermarkEditListAdapter, WatermarkEditListAdapter.EditTextViewHolder paramEditTextViewHolder, WMElement paramWMElement) {}
  
  public void onClick(View paramView)
  {
    ((InputMethodManager)AEModule.getContext().getSystemService("input_method")).hideSoftInputFromWindow(WatermarkEditListAdapter.a(this.c).getWindowToken(), 0);
    WatermarkEditListAdapter.a(this.c).setTextColor(-1);
    paramView = this.c;
    WatermarkEditListAdapter.a(paramView, WatermarkEditListAdapter.a(paramView));
    WatermarkEditListAdapter.b(this.c, this.a.a);
    if (AECameraEntryManager.o(WatermarkEditListAdapter.c(this.c).getIntent())) {
      WatermarkEditListAdapter.a(this.c).setTextColor(WatermarkEditListAdapter.c(this.c).getResources().getColor(2063794238));
    } else {
      WatermarkEditListAdapter.a(this.c).setTextColor(WatermarkEditListAdapter.c(this.c).getResources().getColor(2063794239));
    }
    WatermarkEditListAdapter.a(this.c, this.b);
    if (WatermarkEditListAdapter.b(this.c) != null)
    {
      paramView = WatermarkEditListAdapter.a(this.c, this.b.getInnerValue());
      WatermarkEditListAdapter.b(this.c).a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.watermark.WatermarkEditListAdapter.3
 * JD-Core Version:    0.7.0.1
 */