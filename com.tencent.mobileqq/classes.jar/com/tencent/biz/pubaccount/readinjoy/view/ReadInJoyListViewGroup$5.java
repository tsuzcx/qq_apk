package com.tencent.biz.pubaccount.readinjoy.view;

import actn;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import oot;

class ReadInJoyListViewGroup$5
  implements Runnable
{
  ReadInJoyListViewGroup$5(ReadInJoyListViewGroup paramReadInJoyListViewGroup, View paramView1, int paramInt1, int paramInt2, View paramView2) {}
  
  public void run()
  {
    if ((oot.b()) && (oot.a())) {}
    int j;
    do
    {
      int i;
      do
      {
        return;
        j = this.jdField_a_of_type_AndroidViewView.getHeight();
        if ((j != this.jdField_a_of_type_Int) && (QLog.isColorLevel())) {
          QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + j + ",heightDef =" + this.jdField_a_of_type_Int);
        }
        if (!oot.a()) {
          break;
        }
        if (j <= this.jdField_b_of_type_Int * 3)
        {
          i = j;
          if (j >= this.jdField_b_of_type_Int) {}
        }
        else
        {
          actn.a("ReadInJoyListViewGroup", "", new IllegalStateException("hideWithAnimation" + j));
          i = this.jdField_b_of_type_Int;
        }
        this.jdField_b_of_type_AndroidViewView.setPadding(0, i, 0, 0);
        this.this$0.a.setPadding(0, i, 0, 0);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding error: statusLineHeight not equal heightDef;statusLineHeight=" + i + ",heightDef =" + this.jdField_a_of_type_Int);
        }
      } while (i > this.jdField_b_of_type_Int);
      ReadInJoyListViewGroup.a(this.this$0).i();
      return;
    } while (j <= this.jdField_a_of_type_Int);
    this.jdField_b_of_type_AndroidViewView.setPadding(0, j, 0, 0);
    this.this$0.a.setPadding(0, j, 0, 0);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyListViewGroup", 2, "initUI 看点 mListView.setPadding statusLineHeight=" + j);
    }
    ReadInJoyListViewGroup.a(this.this$0).i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.5
 * JD-Core Version:    0.7.0.1
 */