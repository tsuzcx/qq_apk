package com.google.android.exoplayer2.text.dvb;

final class DvbParser$ObjectData
{
  public final byte[] bottomFieldData;
  public final int id;
  public final boolean nonModifyingColorFlag;
  public final byte[] topFieldData;
  
  public DvbParser$ObjectData(int paramInt, boolean paramBoolean, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.id = paramInt;
    this.nonModifyingColorFlag = paramBoolean;
    this.topFieldData = paramArrayOfByte1;
    this.bottomFieldData = paramArrayOfByte2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.text.dvb.DvbParser.ObjectData
 * JD-Core Version:    0.7.0.1
 */