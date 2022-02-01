package com.tencent.mobileqq.activity.selectable;

import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.widget.participle.ParticipleBottomMenuView.OnMenuClickListener;

class TextPreviewMenu$1
  implements ParticipleBottomMenuView.OnMenuClickListener
{
  TextPreviewMenu$1(TextPreviewMenu paramTextPreviewMenu, TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a()
  {
    TextPreviewMenu.a(this.b);
  }
  
  public void a(String paramString)
  {
    MenuUtil.copy(paramString, "OCR_Participle_copy");
  }
  
  public void b(String paramString)
  {
    int i = this.a.a();
    if (i >= 0)
    {
      MenuUtil.a(this.a, paramString, i);
      return;
    }
    MenuUtil.a(this.a, paramString);
  }
  
  public void c(String paramString)
  {
    TextPreviewActivity localTextPreviewActivity = this.a;
    MenuUtil.a(localTextPreviewActivity, localTextPreviewActivity.app, paramString);
  }
  
  public void d(String paramString)
  {
    Intent localIntent = new Intent(this.a, TextPreviewTranslateActivity.class);
    localIntent.putExtra("TranslateText", paramString);
    localIntent.putExtra("WhereAreYouFrom", "AIO_TEXTPREVIEW");
    TextPreviewMenu.a(this.b, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextPreviewMenu.1
 * JD-Core Version:    0.7.0.1
 */