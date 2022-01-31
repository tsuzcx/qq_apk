package com.tencent.mobileqq.activity.qwallet;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class PriceSettingDialog$PriceTextWater
  implements TextWatcher
{
  final long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  String jdField_a_of_type_JavaLangString;
  final long jdField_b_of_type_Long;
  String jdField_b_of_type_JavaLangString;
  
  public PriceSettingDialog$PriceTextWater(Context paramContext, long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = 1;
    int i = 0;
    String str = paramEditable.toString();
    int k = str.indexOf(".");
    if (k == 0)
    {
      paramEditable.delete(0, 1);
      paramEditable = paramEditable.toString();
    }
    for (;;)
    {
      try
      {
        long l = (Double.valueOf(paramEditable).doubleValue() * 100.0D);
        if (l > this.jdField_b_of_type_Long)
        {
          if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_JavaLangString, 0).a();
          }
          return;
          if (k <= 0) {
            break;
          }
          if (str.length() - k - 1 < 2) {
            break label200;
          }
          i = j;
          if (str.length() - k - 1 > 2) {
            paramEditable.delete(k + 3, k + 4);
          }
          break;
        }
        if ((i == 0) || (l >= this.jdField_a_of_type_Long) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
          continue;
        }
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, 0).a();
        return;
      }
      catch (Exception paramEditable)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PriceTextWater", 2, "afterTextChanged exception:", paramEditable);
        return;
      }
      label200:
      i = 0;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.PriceSettingDialog.PriceTextWater
 * JD-Core Version:    0.7.0.1
 */