package com.tencent.av.screenshare;

import com.tencent.avcore.data.RecordParam;
import com.tencent.qphone.base.util.QLog;

class ScreenShareCtrl$ShareDataInfo
{
  public int a;
  public final RecordParam a;
  public int b;
  public int c;
  private int d;
  
  ScreenShareCtrl$ShareDataInfo()
  {
    this.jdField_a_of_type_ComTencentAvcoreDataRecordParam = new RecordParam();
  }
  
  public void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, RecordParam paramRecordParam)
  {
    this.d += 1;
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2) || (!this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.equals(paramRecordParam)) || (this.c != paramInt3))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateFrame, frameIndex[");
        localStringBuilder.append(this.d);
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
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAvcoreDataRecordParam);
        localStringBuilder.append("--->");
        localStringBuilder.append(paramRecordParam);
        localStringBuilder.append("], angle[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("-->");
        localStringBuilder.append(paramInt3);
        localStringBuilder.append("]");
        QLog.i("AVShare", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
      this.c = paramInt3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ShareDataInfo
 * JD-Core Version:    0.7.0.1
 */