package com.tencent.biz.subscribe.beans;

import java.io.Serializable;

public class SubscribeColorNoteReserveBean
  implements Serializable
{
  public byte[] feedData;
  public int pageType;
  
  public SubscribeColorNoteReserveBean(byte[] paramArrayOfByte, int paramInt)
  {
    this.feedData = paramArrayOfByte;
    this.pageType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.beans.SubscribeColorNoteReserveBean
 * JD-Core Version:    0.7.0.1
 */