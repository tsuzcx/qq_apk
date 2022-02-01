package com.tencent.biz.pubaccount;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.lang.ref.WeakReference;
import obj;
import obs;

public class PublicAccountManager$4
  implements Runnable
{
  public PublicAccountManager$4(obj paramobj) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.a.get();
    String str = this.this$0.jdField_b_of_type_JavaLangString;
    boolean bool = this.this$0.jdField_b_of_type_Boolean;
    if ((this.this$0.jdField_b_of_type_JavaLangRefWeakReference != null) && (this.this$0.jdField_b_of_type_JavaLangRefWeakReference.get() != null) && (localQQAppInterface != null)) {
      SosoInterface.a(new obs(this, 1, true, true, 0L, true, false, "PublicAccountManager", str, bool));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountManager.4
 * JD-Core Version:    0.7.0.1
 */