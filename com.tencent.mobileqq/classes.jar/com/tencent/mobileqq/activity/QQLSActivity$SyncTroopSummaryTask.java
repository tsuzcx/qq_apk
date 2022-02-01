package com.tencent.mobileqq.activity;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLSActivity$SyncTroopSummaryTask
  implements Runnable
{
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  String jdField_a_of_type_JavaLangString;
  WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  String b;
  
  public QQLSActivity$SyncTroopSummaryTask(AppInterface paramAppInterface, WeakReferenceHandler paramWeakReferenceHandler, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = paramWeakReferenceHandler;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
  
  public void run()
  {
    AppInterface localAppInterface = (AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    String str = this.b.concat(this.jdField_a_of_type_JavaLangString);
    if ((localAppInterface != null) && (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null) && (!QQLSActivity.a().contains(str)))
    {
      QQLSActivity.a().add(str);
      ContactUtils.b(localAppInterface, this.b, this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(17);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.SyncTroopSummaryTask
 * JD-Core Version:    0.7.0.1
 */