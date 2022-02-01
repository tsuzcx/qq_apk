package com.tencent.biz;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nst;

class PoiMapActivity$12
  implements Runnable
{
  PoiMapActivity$12(PoiMapActivity paramPoiMapActivity, boolean paramBoolean1, String paramString1, String paramString2, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean2) {}
  
  public void run()
  {
    label118:
    PoiMapActivity localPoiMapActivity;
    String str;
    ArrayList localArrayList;
    if (this.this$0.i) {
      if (this.jdField_a_of_type_Boolean)
      {
        this.this$0.a("rec_locate", "call_foursquare", "", "", "", "");
        QLog.d("PoiMapActivity", 1, "hasPoiListForFoursquareFinal: true");
        this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.this$0.jdField_b_of_type_AndroidWidgetLinearLayout != null) {
          this.this$0.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (!this.jdField_a_of_type_JavaLangString.equals(this.this$0.jdField_b_of_type_ArrayOfJavaLangString[0]))
        {
          this.this$0.l = 0;
          this.this$0.jdField_a_of_type_ArrayOfNst[0].b(true);
        }
        if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
          break label235;
        }
        if (this.jdField_b_of_type_JavaLangString.equals(this.this$0.c))
        {
          localPoiMapActivity = this.this$0;
          str = this.jdField_b_of_type_JavaLangString;
          localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
          if (this.jdField_a_of_type_Int <= 0) {
            break label230;
          }
        }
      }
    }
    label230:
    for (boolean bool = true;; bool = false)
    {
      localPoiMapActivity.a(str, localArrayList, bool);
      return;
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      break;
      this.this$0.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      if (this.this$0.jdField_b_of_type_AndroidWidgetLinearLayout == null) {
        break label118;
      }
      this.this$0.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      break label118;
    }
    label235:
    this.this$0.a(this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_Int, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.d, this.jdField_b_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.PoiMapActivity.12
 * JD-Core Version:    0.7.0.1
 */