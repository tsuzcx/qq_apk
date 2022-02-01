package com.tencent.av.business.manager;

import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.pendant.ItemBase;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class EffectConfigBase$MyHander<T extends ItemBase>
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
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference.get();
    boolean bool = true;
    Object localObject2;
    long l;
    if (localObject1 != null)
    {
      localObject1 = (EffectConfigBase)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            ((EffectConfigBase)localObject1).a(paramMessage);
            return;
          }
          EffectConfigBase.a((EffectConfigBase)localObject1, (ItemBase)paramMessage.obj, paramMessage.arg1);
          return;
        }
        localObject2 = (ItemBase)paramMessage.obj;
        l = paramMessage.arg2;
        if (paramMessage.arg1 != 1) {
          bool = false;
        }
        EffectConfigBase.a((EffectConfigBase)localObject1, l, (ItemBase)localObject2, bool);
        return;
      }
      localObject2 = (ItemBase)paramMessage.obj;
      l = paramMessage.arg1;
      bool = EffectConfigBase.a((EffectConfigBase)localObject1, (ItemBase)localObject2, ((EffectConfigBase)localObject1).jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase);
      paramMessage = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MSG_ON_ITEM_SELECT_CHANGED, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("], isEqual[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], count_MSG[");
      localStringBuilder.append(((EffectConfigBase)localObject1).jdField_a_of_type_Int);
      localStringBuilder.append("], \nitem[");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("], \ncur[");
      localStringBuilder.append(((EffectConfigBase)localObject1).jdField_a_of_type_ComTencentAvBusinessManagerPendantItemBase);
      localStringBuilder.append("]");
      QLog.w(paramMessage, 1, localStringBuilder.toString());
      if (((EffectConfigBase)localObject1).jdField_a_of_type_Int >= 0) {
        ((EffectConfigBase)localObject1).jdField_a_of_type_Int -= 1;
      }
      if (bool) {
        EffectConfigBase.a((EffectConfigBase)localObject1, l, (ItemBase)localObject2);
      }
    }
    else
    {
      l = 0L;
      if (paramMessage.what == 0) {
        l = paramMessage.arg1;
      }
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("handleMessage, had destroy, msg[");
      ((StringBuilder)localObject2).append(paramMessage.what);
      ((StringBuilder)localObject2).append("], seq[");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.EffectConfigBase.MyHander
 * JD-Core Version:    0.7.0.1
 */