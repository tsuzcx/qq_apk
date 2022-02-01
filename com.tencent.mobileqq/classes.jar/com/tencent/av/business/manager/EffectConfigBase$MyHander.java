package com.tencent.av.business.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class EffectConfigBase$MyHander<T extends EffectConfigBase.ItemBase>
  extends Handler
{
  final String jdField_a_of_type_JavaLangString;
  WeakReference<EffectConfigBase<T>> jdField_a_of_type_JavaLangRefWeakReference;
  
  EffectConfigBase$MyHander(String paramString, EffectConfigBase<T> paramEffectConfigBase)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramEffectConfigBase);
  }
  
  public void handleMessage(Message paramMessage)
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
    {
      EffectConfigBase localEffectConfigBase = (EffectConfigBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      EffectConfigBase.ItemBase localItemBase;
      switch (paramMessage.what)
      {
      default: 
        localEffectConfigBase.a(paramMessage);
      case 0: 
        do
        {
          return;
          localItemBase = (EffectConfigBase.ItemBase)paramMessage.obj;
          l = paramMessage.arg1;
          bool = EffectConfigBase.a(localEffectConfigBase, localItemBase, localEffectConfigBase.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase);
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MSG_ON_ITEM_SELECT_CHANGED, seq[" + l + "], isEqual[" + bool + "], count_MSG[" + localEffectConfigBase.jdField_a_of_type_Int + "], \nitem[" + localItemBase + "], \ncur[" + localEffectConfigBase.jdField_a_of_type_ComTencentAvBusinessManagerEffectConfigBase$ItemBase + "]");
          if (localEffectConfigBase.jdField_a_of_type_Int >= 0) {
            localEffectConfigBase.jdField_a_of_type_Int -= 1;
          }
        } while (!bool);
        EffectConfigBase.a(localEffectConfigBase, l, localItemBase);
        return;
      case 1: 
        localItemBase = (EffectConfigBase.ItemBase)paramMessage.obj;
        l = paramMessage.arg2;
        if (paramMessage.arg1 == 1) {}
        for (;;)
        {
          EffectConfigBase.a(localEffectConfigBase, l, localItemBase, bool);
          return;
          bool = false;
        }
      }
      EffectConfigBase.a(localEffectConfigBase, (EffectConfigBase.ItemBase)paramMessage.obj, paramMessage.arg1);
      return;
    }
    long l = 0L;
    if (paramMessage.what == 0) {
      l = paramMessage.arg1;
    }
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "handleMessage, had destroy, msg[" + paramMessage.what + "], seq[" + l + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase.MyHander
 * JD-Core Version:    0.7.0.1
 */