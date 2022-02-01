package com.tencent.biz.pubaccount.imagecollection;

import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.util.Stack;

public class PublicAccountImageCollectionActivityManager
{
  private static int jdField_a_of_type_Int = 3;
  private static PublicAccountImageCollectionActivityManager jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionActivityManager;
  private static String jdField_a_of_type_JavaLangString = "PublicAccountImageCollectionActivityManager";
  private static Stack<Activity> jdField_a_of_type_JavaUtilStack;
  
  public static PublicAccountImageCollectionActivityManager a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionActivityManager == null) {
      jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionActivityManager = new PublicAccountImageCollectionActivityManager();
    }
    return jdField_a_of_type_ComTencentBizPubaccountImagecollectionPublicAccountImageCollectionActivityManager;
  }
  
  private void b()
  {
    Activity localActivity = (Activity)jdField_a_of_type_JavaUtilStack.firstElement();
    if (localActivity != null)
    {
      localActivity.finish();
      jdField_a_of_type_JavaUtilStack.remove(localActivity);
    }
  }
  
  public int a()
  {
    Object localObject = jdField_a_of_type_JavaUtilStack;
    if (localObject != null)
    {
      int i = ((Stack)localObject).size();
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getActivityStackNum = ");
        localStringBuilder.append(i);
        QLog.d((String)localObject, 2, localStringBuilder.toString());
      }
      return i;
    }
    return 0;
  }
  
  public void a()
  {
    Stack localStack = jdField_a_of_type_JavaUtilStack;
    if ((localStack != null) && (localStack.size() > jdField_a_of_type_Int))
    {
      int j = jdField_a_of_type_JavaUtilStack.size();
      int k = jdField_a_of_type_Int;
      int i = 0;
      while (i < j - k)
      {
        b();
        i += 1;
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    if (jdField_a_of_type_JavaUtilStack == null) {
      jdField_a_of_type_JavaUtilStack = new Stack();
    }
    jdField_a_of_type_JavaUtilStack.add(paramActivity);
  }
  
  public void b(Activity paramActivity)
  {
    Stack localStack = jdField_a_of_type_JavaUtilStack;
    if ((localStack != null) && (paramActivity != null)) {
      localStack.remove(paramActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionActivityManager
 * JD-Core Version:    0.7.0.1
 */