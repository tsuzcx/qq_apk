package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;

class DYAEFilterProviderView$1
  implements Observer<QIMFilterCategoryItem>
{
  DYAEFilterProviderView$1(DYAEFilterProviderView paramDYAEFilterProviderView) {}
  
  public void a(QIMFilterCategoryItem paramQIMFilterCategoryItem)
  {
    String str = DYAEFilterProviderView.a(this.a);
    if (paramQIMFilterCategoryItem != null) {
      str = paramQIMFilterCategoryItem.a;
    }
    DYAEFilterProviderView.b(this.a).a(str, true);
    if ((DYAEFilterProviderView.c(this.a) != null) && (DYAEFilterProviderView.c(this.a).b != null) && (TextUtils.equals(DYAEFilterProviderView.c(this.a).b.a, str)))
    {
      paramQIMFilterCategoryItem = this.a;
      DYAEFilterProviderView.a(paramQIMFilterCategoryItem, DYAEFilterProviderView.c(paramQIMFilterCategoryItem).b, DYAEFilterProviderView.c(this.a).a);
      DYAEFilterProviderView.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.DYAEFilterProviderView.1
 * JD-Core Version:    0.7.0.1
 */