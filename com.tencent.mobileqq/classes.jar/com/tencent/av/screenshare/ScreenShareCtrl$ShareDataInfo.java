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
    StringBuilder localStringBuilder;
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2) || (!this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.equals(paramRecordParam)) || (this.c != paramInt3)) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("updateFrame, frameIndex[").append(this.d).append("], data[");
        if (paramArrayOfByte != null) {
          break label198;
        }
      }
    }
    label198:
    for (paramArrayOfByte = "null";; paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length))
    {
      QLog.i("AVShare", 2, paramArrayOfByte + "], imgFormat[" + this.b + "-->" + paramInt2 + "], recordParam[" + this.jdField_a_of_type_ComTencentAvcoreDataRecordParam + "--->" + paramRecordParam + "], angle[" + this.c + "-->" + paramInt3 + "]");
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      this.jdField_a_of_type_ComTencentAvcoreDataRecordParam.update(paramRecordParam);
      this.c = paramInt3;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.screenshare.ScreenShareCtrl.ShareDataInfo
 * JD-Core Version:    0.7.0.1
 */