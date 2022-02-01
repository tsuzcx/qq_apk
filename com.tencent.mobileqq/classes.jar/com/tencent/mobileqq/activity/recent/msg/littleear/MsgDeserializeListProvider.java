package com.tencent.mobileqq.activity.recent.msg.littleear;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.msg.MsgDeserialize;
import com.tencent.mobileqq.activity.recent.msg.StringMsgDeserialize;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class MsgDeserializeListProvider
  implements Provider<SparseArray<MsgDeserialize>>
{
  private SparseArray<MsgDeserialize> a = new SparseArray();
  
  public MsgDeserializeListProvider()
  {
    StringMsgDeserialize localStringMsgDeserialize = new StringMsgDeserialize();
    this.a.put(26, localStringMsgDeserialize);
    this.a.put(1, localStringMsgDeserialize);
  }
  
  public SparseArray<MsgDeserialize> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.littleear.MsgDeserializeListProvider
 * JD-Core Version:    0.7.0.1
 */