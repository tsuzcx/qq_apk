package com.tencent.aelight.camera.ae.gif.giftext.adapter;

import android.support.annotation.Nullable;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.ae.gif.giftext.AEGIFOutlineTextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.util.DisplayUtil;

class AEGIFChunkPreviewAdapter$3
  implements Observer<String>
{
  AEGIFChunkPreviewAdapter$3(AEGIFChunkPreviewAdapter paramAEGIFChunkPreviewAdapter, AEGIFOutlineTextView paramAEGIFOutlineTextView) {}
  
  public void a(@Nullable String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("")) {}
    }
    else
    {
      str = HardCodeUtil.a(2131898229);
    }
    paramString = this.a.getLayoutParams();
    int i;
    if (str.indexOf('\n') > 0) {
      i = AEGIFChunkPreviewAdapter.b(this.b) * 3 / 10;
    } else {
      i = AEGIFChunkPreviewAdapter.b(this.b) * 11 / 50;
    }
    paramString.height = i;
    this.a.setTextSize(DisplayUtil.c(AEGIFChunkPreviewAdapter.c(this.b), 23.0F));
    this.a.setOutlineWidth(DisplayUtil.a(AEGIFChunkPreviewAdapter.c(this.b), 2.0F));
    this.a.setText(str);
    this.a.setLayoutParams(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.giftext.adapter.AEGIFChunkPreviewAdapter.3
 * JD-Core Version:    0.7.0.1
 */