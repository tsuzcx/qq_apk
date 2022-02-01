package com.tencent.av.ui;

import com.tencent.av.business.manager.pendant.EffectPendantTools;
import com.tencent.qphone.base.util.QLog;

class EffectToolbar$2
  implements Runnable
{
  EffectToolbar$2(EffectToolbar paramEffectToolbar, String paramString, long paramLong) {}
  
  public void run()
  {
    if (EffectToolbar.access$200(this.this$0) != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("postSetCurrentItemById, id[");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("]");
      QLog.w("EffectToolbar", 1, localStringBuilder.toString());
      EffectToolbar.access$200(this.this$0).a(this.jdField_a_of_type_Long, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.EffectToolbar.2
 * JD-Core Version:    0.7.0.1
 */