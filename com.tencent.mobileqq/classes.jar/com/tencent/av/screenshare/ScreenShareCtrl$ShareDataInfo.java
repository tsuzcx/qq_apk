package com.tencent.av.screenshare;

import com.tencent.avcore.data.RecordParam;
import com.tencent.qphone.base.util.QLog;

class ScreenShareCtrl$ShareDataInfo
{
  public int a;
  public int b;
  public final RecordParam c = new RecordParam();
  public int d;
  private int e;
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, RecordParam paramRecordParam)
  {
    this.e += 1;
    if ((this.a != paramInt1) || (this.b != paramInt2) || (!this.c.equals(paramRecordParam)) || (this.d != paramInt3))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFrame, frameIndex[");
        localStringBuilder.append(this.e);
        localStringBuilder.append("], data[");
        if (paramArrayOfByte == null) {
          paramArrayOfByte = "null";
        } else {
          paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
        }
        localStringBuilder.append(paramArrayOfByte);
        localStringBuilder.append("], imgFormat[");
        localStringBuilder.append(this.b);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append("], recordParam[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("--->");
        localStringBuilder.append(paramRecordParam);
        localStringBuilder.append("], angle[");
        localStringBuilder.append(this.d);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append("]");
        QLog.i("AVShare", 2, localStringBuilder.toString());
      }
      this.a = paramInt1;
      this.b = paramInt2;
      this.c.update(paramRecordParam);
      this.d = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ShareDataInfo
 * JD-Core Version:    0.7.0.1
 */