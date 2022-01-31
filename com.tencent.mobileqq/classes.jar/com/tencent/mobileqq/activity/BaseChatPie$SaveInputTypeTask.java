package com.tencent.mobileqq.activity;

import ajxn;
import aukm;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private aukm jdField_a_of_type_Aukm;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseChatPie$SaveInputTypeTask(aukm paramaukm, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aukm = paramaukm;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localObject == null);
      localObject = (ajxn)((QQAppInterface)localObject).getManager(51);
      if ((this.jdField_a_of_type_Aukm instanceof ExtensionInfo))
      {
        ((ajxn)localObject).a((ExtensionInfo)this.jdField_a_of_type_Aukm);
        return;
      }
    } while (!(this.jdField_a_of_type_Aukm instanceof NoC2CExtensionInfo));
    ((ajxn)localObject).a((NoC2CExtensionInfo)this.jdField_a_of_type_Aukm, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */