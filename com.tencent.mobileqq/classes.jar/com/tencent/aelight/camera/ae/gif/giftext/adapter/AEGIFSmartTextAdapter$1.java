package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFSmartTextData;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextColorConfig.SmartTextColor;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFTextMvp;
import com.tencent.aelight.camera.ae.report.AEBaseDataReporter;
import java.util.ArrayList;
import java.util.List;

class AEGIFSmartTextAdapter$1
  implements View.OnClickListener
{
  AEGIFSmartTextAdapter$1(AEGIFSmartTextAdapter paramAEGIFSmartTextAdapter, AEGIFSmartTextAdapter.QIMGIFSmartTextViewHolder paramQIMGIFSmartTextViewHolder, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (AEGIFSmartTextAdapter.a(this.c) != this.a.getLayoutPosition()) {
      AEBaseDataReporter.a().m(this.b);
    }
    if ((AEGIFSmartTextAdapter.a(this.c) == -1) && (TextUtils.isEmpty(AEGIFSmartTextAdapter.b(this.c).g())))
    {
      AEGIFSmartTextAdapter.b(this.c).a(this.b, ((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.b.get(0)).a, ((AEGIFTextColorConfig.SmartTextColor)AEGIFTextColorConfig.b.get(0)).b);
      AEGIFSmartTextAdapter.b(this.c).a(true, false);
    }
    else
    {
      AEGIFSmartTextAdapter.b(this.c).a(this.b);
    }
    this.c.a();
    AEGIFSmartTextAdapter.a(this.c, this.a.getLayoutPosition());
    ((AEGIFSmartTextData)AEGIFSmartTextAdapter.c(this.c).get(AEGIFSmartTextAdapter.a(this.c) - 1)).a(true);
    this.a.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFSmartTextAdapter.1
 * JD-Core Version:    0.7.0.1
 */