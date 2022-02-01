package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLSActivity$SyncTroopSummaryTask
  implements Runnable
{
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  String b;
  
  public QQLSActivity$SyncTroopSummaryTask(QQAppInterface paramQQAppInterface, WeakReferenceHandler paramWeakReferenceHandler, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = paramWeakReferenceHandler;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.b.concat(this.jdField_a_of_type_JavaLangString);
    if ((localQQAppInterface != null) && (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (!QQLSActivity.a().contains(str)))
    {
      QQLSActivity.a().add(str);
      ContactUtils.g(localQQAppInterface, this.b, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask
 * JD-Core Version:    0.7.0.1
 */