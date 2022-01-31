package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import kyd;

class EffectToolbar$2
  implements Runnable
{
  EffectToolbar$2(EffectToolbar paramEffectToolbar, String paramString, long paramLong) {}
  
  public void run()
  {
    if (EffectToolbar.access$200(this.this$0) != null)
    {
      QLog.w("EffectToolbar", 1, "postSetCurrentItemById, id[" + this.jdField_a_of_type_JavaLangString + "], seq[" + this.jdField_a_of_type_Long + "]");
      EffectToolbar.access$200(this.this$0).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar.2
 * JD-Core Version:    0.7.0.1
 */