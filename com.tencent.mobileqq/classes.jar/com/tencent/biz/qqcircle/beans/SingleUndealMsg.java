package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class SingleUndealMsg
  extends Entity
  implements Serializable, Cloneable
{
  public byte[] mBizBufferData;
  public int mType;
  
  public SingleUndealMsg() {}
  
  public SingleUndealMsg(int paramInt, byte[] paramArrayOfByte)
  {
    this.mType = paramInt;
    this.mBizBufferData = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.beans.SingleUndealMsg
 * JD-Core Version:    0.7.0.1
 */