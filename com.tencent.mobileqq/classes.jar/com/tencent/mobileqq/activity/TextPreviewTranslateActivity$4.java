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
    Object localObject = this.a;
    ((TextPreviewTranslateActivity)localObject).b = null;
    if ((TextPreviewTranslateActivity.a((TextPreviewTranslateActivity)localObject) != null) && (TextPreviewTranslateActivity.a(this.a).size() > 1))
    {
      localObject = this.a.getResources();
      int i;
      if (TextPreviewTranslateActivity.a(this.a)) {
        i = 2130845794;
      } else {
        i = 2130846354;
      }
      localObject = ((Resources)localObject).getDrawable(i);
      TextPreviewTranslateActivity.a(this.a).setCompoundDrawablesWithIntrinsicBounds(null, null, null, (Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TextPreviewTranslateActivity.4
 * JD-Core Version:    0.7.0.1
 */