package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

public class EditTextDialog$LengthInputFilter
  implements InputFilter
{
  protected int a;
  private QQToast a;
  
  public EditTextDialog$LengthInputFilter(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(CharSequence paramCharSequence)
  {
    int m = paramCharSequence.length();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      int n = paramCharSequence.charAt(i);
      if (n != 10)
      {
        k = j;
        if (n != 13) {}
      }
      else
      {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(BaseApplicationImpl.getContext(), HardCodeUtil.a(2131703858), 0);
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d()) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
    }
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = this.jdField_a_of_type_Int - (paramSpanned.length() - (paramInt4 - paramInt3));
    paramInt4 = paramInt2 - paramInt1 - a(paramCharSequence.subSequence(paramInt1, paramInt2));
    if (paramInt3 > 0)
    {
      paramInt2 = paramInt3;
      if (paramInt3 >= paramInt4) {}
    }
    else
    {
      paramInt2 = paramInt3 + a(paramSpanned);
    }
    if (((paramInt2 <= 0) || (paramInt2 < paramInt4)) && (!TextUtils.equals("", paramCharSequence))) {
      a();
    }
    if (paramInt2 <= 0) {
      return "";
    }
    if (paramInt2 >= paramInt4) {
      return null;
    }
    paramInt3 = paramInt2 + paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1) {
        return "";
      }
    }
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.LengthInputFilter
 * JD-Core Version:    0.7.0.1
 */