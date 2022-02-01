package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import aonw;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DiscMessageProcessor$2
  implements Runnable
{
  public DiscMessageProcessor$2(aonw paramaonw, ArrayList paramArrayList, long paramLong1, long paramLong2, String paramString, MsgInfo paramMsgInfo, long paramLong3) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.contains(Long.valueOf(this.jdField_a_of_type_Long)))
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "陌生人uin包括自己,移出");
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.jdField_a_of_type_JavaUtilArrayList.size() * 8);
      aonw.a(this.this$0, localStringBuilder, this.jdField_a_of_type_JavaUtilArrayList, this.b);
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.DiscMsgPc.discuss", 2, "show yinsi tips" + localStringBuilder.toString());
      }
      aonw.a(this.this$0, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_a_of_type_Long, this.b, this.c, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */