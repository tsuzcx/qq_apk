package com.tencent.mobileqq.activity.recent.msg.littleear;

import android.util.SparseArray;
import com.tencent.mobileqq.activity.recent.msg.MsgSerialize;
import com.tencent.mobileqq.activity.recent.msg.StringMsgSerialize;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class MsgSerializeListProvider
  implements Provider<SparseArray<MsgSerialize>>
{
  private SparseArray<MsgSerialize> a = new SparseArray();
  
  public MsgSerializeListProvider()
  {
    StringMsgSerialize localStringMsgSerialize = new StringMsgSerialize();
    this.a.put(25, localStringMsgSerialize);
    this.a.put(1, localStringMsgSerialize);
  }
  
  public SparseArray<MsgSerialize> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.littleear.MsgSerializeListProvider
 * JD-Core Version:    0.7.0.1
 */