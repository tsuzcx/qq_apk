package com.tencent.mobileqq.activity.contacts.alphabet;

import ajik;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;

public class AlphabetFriendAdapter$4
  implements Runnable
{
  public AlphabetFriendAdapter$4(ajik paramajik, Object[] paramArrayOfObject) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlphabetFriendAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    this.this$0.jdField_a_of_type_JavaUtilLinkedHashMap = ((LinkedHashMap)this.a[0]);
    this.this$0.jdField_a_of_type_ArrayOfInt = ((int[])this.a[1]);
    this.this$0.jdField_a_of_type_ArrayOfJavaLangString = ((String[])this.a[2]);
    ajik.b(this.this$0);
    this.this$0.c();
    ajik.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.4
 * JD-Core Version:    0.7.0.1
 */