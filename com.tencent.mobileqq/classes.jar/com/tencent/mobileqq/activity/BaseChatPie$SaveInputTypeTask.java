package com.tencent.mobileqq.activity;

import alto;
import awge;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private awge jdField_a_of_type_Awge;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  public BaseChatPie$SaveInputTypeTask(awge paramawge, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awge = paramawge;
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
      localObject = (alto)((QQAppInterface)localObject).getManager(51);
      if ((this.jdField_a_of_type_Awge instanceof ExtensionInfo))
      {
        ((alto)localObject).a((ExtensionInfo)this.jdField_a_of_type_Awge);
        return;
      }
    } while (!(this.jdField_a_of_type_Awge instanceof NoC2CExtensionInfo));
    ((alto)localObject).a((NoC2CExtensionInfo)this.jdField_a_of_type_Awge, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */