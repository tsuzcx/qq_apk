package com.tencent.mobileqq.activity;

import ajjj;
import atmo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private atmo jdField_a_of_type_Atmo;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseChatPie$SaveInputTypeTask(atmo paramatmo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atmo = paramatmo;
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
      localObject = (ajjj)((QQAppInterface)localObject).getManager(51);
      if ((this.jdField_a_of_type_Atmo instanceof ExtensionInfo))
      {
        ((ajjj)localObject).a((ExtensionInfo)this.jdField_a_of_type_Atmo);
        return;
      }
    } while (!(this.jdField_a_of_type_Atmo instanceof NoC2CExtensionInfo));
    ((ajjj)localObject).a((NoC2CExtensionInfo)this.jdField_a_of_type_Atmo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */