package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class TextPreviewTranslateActivity$6
  implements PopupWindow.OnDismissListener
{
  TextPreviewTranslateActivity$6(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void onDismiss()
  {
    Object localObject = this.a;
    ((TextPreviewTranslateActivity)localObject).j = null;
    if ((TextPreviewTranslateActivity.j((TextPreviewTranslateActivity)localObject) != null) && (TextPreviewTranslateActivity.j(this.a).size() > 1))
    {
      localObject = this.a.getResources();
      int i;
      if (TextPreviewTranslateActivity.h(this.a)) {
        i = 2130847264;
      } else {
        i = 2130847827;
      }
      localObject = ((Resources)localObject).getDrawable(i);
      TextPreviewTranslateActivity.k(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.6
 * JD-Core Version:    0.7.0.1
 */