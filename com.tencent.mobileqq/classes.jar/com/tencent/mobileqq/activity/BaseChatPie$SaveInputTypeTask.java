package com.tencent.mobileqq.activity;

import ajxl;
import auko;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private auko jdField_a_of_type_Auko;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseChatPie$SaveInputTypeTask(auko paramauko, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Auko = paramauko;
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
      localObject = (ajxl)((QQAppInterface)localObject).getManager(51);
      if ((this.jdField_a_of_type_Auko instanceof ExtensionInfo))
      {
        ((ajxl)localObject).a((ExtensionInfo)this.jdField_a_of_type_Auko);
        return;
      }
    } while (!(this.jdField_a_of_type_Auko instanceof NoC2CExtensionInfo));
    ((ajxl)localObject).a((NoC2CExtensionInfo)this.jdField_a_of_type_Auko, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */