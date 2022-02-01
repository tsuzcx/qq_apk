package com.tencent.mobileqq.activity.selectable;

import android.content.Intent;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.TextPreviewTranslateActivity;
import com.tencent.mobileqq.textpreview.MenuUtil;
import com.tencent.mobileqq.widget.ParticipleBottomMenuView.OnMenuClickListener;

class TextPreviewMenu$1
  implements ParticipleBottomMenuView.OnMenuClickListener
{
  TextPreviewMenu$1(TextPreviewMenu paramTextPreviewMenu, TextPreviewActivity paramTextPreviewActivity) {}
  
  public void a()
  {
    TextPreviewMenu.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu);
  }
  
  public void a(String paramString)
  {
    MenuUtil.copy(paramString, "OCR_Participle_copy");
  }
  
  public void b(String paramString)
  {
    MenuUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity, paramString);
  }
  
  public void c(String paramString)
  {
    MenuUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity, this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity.app, paramString);
  }
  
  public void d(String paramString)
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityTextPreviewActivity, TextPreviewTranslateActivity.class);
    localIntent.putExtra("TranslateText", paramString);
    localIntent.putExtra("WhereAreYouFrom", "AIO_TEXTPREVIEW");
    TextPreviewMenu.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectableTextPreviewMenu, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.TextPreviewMenu.1
 * JD-Core Version:    0.7.0.1
 */