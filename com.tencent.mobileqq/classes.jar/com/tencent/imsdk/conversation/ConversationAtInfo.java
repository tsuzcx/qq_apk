package com.tencent.imsdk.conversation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConversationAtInfo
  implements Serializable
{
  public static final String AT_ALL_TAG = "__kImSDK_MesssageAtALL__";
  public static final int TIM_AT_ALL = 2;
  public static final int TIM_AT_ALL_AT_ME = 3;
  public static final int TIM_AT_ME = 1;
  public static final int TIM_AT_UNKNOWN = 0;
  private long atMessageSequence;
  private List<Integer> atTypes = new ArrayList();
  
  protected void addAtType(int paramInt)
  {
    this.atTypes.add(Integer.valueOf(paramInt));
  }
  
  public long getAtMessageSequence()
  {
    return this.atMessageSequence;
  }
  
  public int getAtType()
  {
    Iterator localIterator = this.atTypes.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      int j = ((Integer)localIterator.next()).intValue();
      if (j == 1) {
        i |= 0x1;
      } else if (j == 2) {
        i |= 0x2;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.conversation.ConversationAtInfo
 * JD-Core Version:    0.7.0.1
 */