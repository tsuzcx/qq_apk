package com.tencent.av.utils;

import bdex;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;

class VideoMsgTools$MygetGroupInfoRunnable
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString = null;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference = null;
  
  public VideoMsgTools$MygetGroupInfoRunnable(long paramLong, QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQAppInterface != null) {
      bdex.a("addGroupMember_" + this.jdField_a_of_type_Long, localQQAppInterface, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.MygetGroupInfoRunnable
 * JD-Core Version:    0.7.0.1
 */