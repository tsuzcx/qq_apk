package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.List;

class TextPreviewTranslateActivity$4
  implements PopupWindow.OnDismissListener
{
  TextPreviewTranslateActivity$4(TextPreviewTranslateActivity paramTextPreviewTranslateActivity) {}
  
  public void onDismiss()
  {
    this.a.b = null;
    Object localObject;
    if ((TextPreviewTranslateActivity.a(this.a) != null) && (TextPreviewTranslateActivity.a(this.a).size() > 1))
    {
      localObject = this.a.getResources();
      if (!TextPreviewTranslateActivity.a(this.a)) {
        break label76;
      }
    }
    label76:
    for (int i = 2130845921;; i = 2130846474)
    {
      localObject = ((Resources)localObject).getDrawable(i);
      TextPreviewTranslateActivity.a(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.4
 * JD-Core Version:    0.7.0.1
 */