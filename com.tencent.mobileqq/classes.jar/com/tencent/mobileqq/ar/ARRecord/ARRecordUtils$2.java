package com.tencent.mobileqq.ar.ARRecord;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;

final class ARRecordUtils$2
  implements Runnable
{
  ARRecordUtils$2(boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QQToast.a(BaseApplicationImpl.getContext(), this.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    QQToast.a(BaseApplicationImpl.getContext(), 2, this.jdField_a_of_type_JavaLangString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARRecordUtils.2
 * JD-Core Version:    0.7.0.1
 */