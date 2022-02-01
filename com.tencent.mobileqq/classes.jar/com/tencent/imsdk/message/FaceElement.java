package com.tencent.imsdk.message;

public class FaceElement
  extends MessageBaseElement
{
  private byte[] faceData;
  private int faceIndex;
  
  public FaceElement()
  {
    setElementType(8);
  }
  
  public byte[] getFaceData()
  {
    return this.faceData;
  }
  
  public int getFaceIndex()
  {
    return this.faceIndex;
  }
  
  public void setFaceData(byte[] paramArrayOfByte)
  {
    this.faceData = paramArrayOfByte;
  }
  
  public void setFaceIndex(int paramInt)
  {
    this.faceIndex = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.message.FaceElement
 * JD-Core Version:    0.7.0.1
 */