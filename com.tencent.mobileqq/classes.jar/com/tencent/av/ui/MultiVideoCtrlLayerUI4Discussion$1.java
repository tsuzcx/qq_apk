package com.tencent.av.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import mdd;
import mww;

class MultiVideoCtrlLayerUI4Discussion$1
  implements Runnable
{
  MultiVideoCtrlLayerUI4Discussion$1(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_Boolean) {
      return;
    }
    String str2 = null;
    String str1;
    if (this.jdField_a_of_type_Int == 2131696013)
    {
      if (this.this$0.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
        str2 = (String)this.this$0.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!TextUtils.equals(str2, "QQ")) {
          break label323;
        }
      }
      str1 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.this$0.b), this.this$0.e);
    }
    label323:
    for (;;)
    {
      float f = this.this$0.jdField_a_of_type_AndroidContentResResources.getDimensionPixelSize(2131297038);
      str1 = mww.a((Context)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get(), str1, this.this$0.jdField_d_of_type_AndroidWidgetTextView, f);
      str1 = str1 + this.this$0.jdField_a_of_type_AndroidContentResResources.getString(this.jdField_a_of_type_Int);
      mdd.a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 3009, str1);
      QLog.e(this.this$0.jdField_d_of_type_JavaLangString, 1, "showHrMeetingInOrOutWordingWithDelay str=" + str1);
      return;
      str2 = this.this$0.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_JavaLangString, String.valueOf(this.this$0.b), this.this$0.e);
      if (!TextUtils.isEmpty(str2))
      {
        str1 = str2;
        if (!TextUtils.equals(str2, "QQ")) {}
      }
      else
      {
        str1 = str2;
        if (this.this$0.jdField_a_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_JavaLangString)) {
          str1 = (String)this.this$0.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion.1
 * JD-Core Version:    0.7.0.1
 */