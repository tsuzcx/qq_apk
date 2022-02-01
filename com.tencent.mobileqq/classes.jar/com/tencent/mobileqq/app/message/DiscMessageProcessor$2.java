package com.tencent.mobileqq.app.message;

import OnlinePushPack.MsgInfo;
import android.util.Pair;
import aosi;
import java.util.ArrayList;

public class DiscMessageProcessor$2
  implements Runnable
{
  public DiscMessageProcessor$2(aosi paramaosi, long paramLong1, long paramLong2, Pair paramPair1, MsgInfo paramMsgInfo, long paramLong3, long paramLong4, byte paramByte, long paramLong5, Pair paramPair2, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Long != this.jdField_b_of_type_Long)
    {
      aosi.a(this.this$0, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_b_of_type_Long, this.c, this.d, this.jdField_a_of_type_Byte, this.e, this.jdField_b_of_type_AndroidUtilPair);
      return;
    }
    aosi.a(this.this$0, this.jdField_a_of_type_AndroidUtilPair, this.jdField_a_of_type_OnlinePushPackMsgInfo, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_b_of_type_Long, String.valueOf(this.c), this.jdField_a_of_type_Byte, this.e, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.DiscMessageProcessor.2
 * JD-Core Version:    0.7.0.1
 */