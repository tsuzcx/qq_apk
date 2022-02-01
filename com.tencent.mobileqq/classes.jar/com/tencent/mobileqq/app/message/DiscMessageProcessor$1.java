package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import android.util.Pair;
import java.util.ArrayList;

class DiscMessageProcessor$1
  implements Runnable
{
  DiscMessageProcessor$1(DiscMessageProcessor paramDiscMessageProcessor, long paramLong1, long paramLong2, Pair paramPair1, MsgInfo paramMsgInfo, long paramLong3, long paramLong4, byte paramByte, long paramLong5, Pair paramPair2, ArrayList paramArrayList) {}
  
  public void run()
  {
    long l1 = this.jdField_a_of_type_Long;
    long l2 = this.jdField_b_of_type_Long;
    if (l1 != l2)
    {
      DiscMessageProcessor.a(this.this$0, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, l2, this.c, this.d, this.jdField_a_of_type_Byte, this.e, this.jdField_b_of_type_AndroidUtilPair);
      return;
    }
    DiscMessageProcessor.a(this.this$0, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_a_of_type_JavaUtilArrayList, l2, String.valueOf(this.c), this.jdField_a_of_type_Byte, this.e, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */