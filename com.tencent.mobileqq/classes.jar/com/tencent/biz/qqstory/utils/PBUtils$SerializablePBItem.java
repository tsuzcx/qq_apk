package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.pb.MessageMicro;
import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class PBUtils$SerializablePBItem
  implements Externalizable
{
  protected PBUtils.PBItemCreator mCreator;
  protected MessageMicro mPB;
  
  public PBUtils$SerializablePBItem(PBUtils.PBItemCreator paramPBItemCreator)
  {
    this(null, paramPBItemCreator);
  }
  
  public PBUtils$SerializablePBItem(MessageMicro paramMessageMicro, PBUtils.PBItemCreator paramPBItemCreator)
  {
    this.mPB = paramMessageMicro;
    this.mCreator = paramPBItemCreator;
  }
  
  public MessageMicro item()
  {
    return this.mPB;
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    byte[] arrayOfByte = new byte[paramObjectInput.readInt()];
    paramObjectInput.read(arrayOfByte);
    this.mPB = this.mCreator.a();
    this.mPB.mergeFrom(arrayOfByte);
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeInt(this.mPB.getSerializedSize());
    paramObjectOutput.write(this.mPB.toByteArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PBUtils.SerializablePBItem
 * JD-Core Version:    0.7.0.1
 */