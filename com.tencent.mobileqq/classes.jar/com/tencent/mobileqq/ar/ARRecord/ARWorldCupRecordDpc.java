package com.tencent.mobileqq.ar.ARRecord;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class ARWorldCupRecordDpc
{
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  
  private ARWorldCupRecordDpc()
  {
    a();
  }
  
  public static ARWorldCupRecordDpc a()
  {
    return ARWorldCupRecordDpc.ARWorldCupRecordDpcHolder.a();
  }
  
  private void a()
  {
    Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.ARCfg.name());
    QLog.d("Q.worldcup.record.dpc", 1, String.format("loadDPC dpcValue=%s", new Object[] { localObject }));
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localObject = ((String)localObject).split("\\|");
        if (localObject.length >= 13)
        {
          if (Integer.valueOf(localObject[13]).intValue() != 1) {
            continue;
          }
          bool = true;
          this.jdField_a_of_type_Boolean = bool;
        }
        if (localObject.length >= 14)
        {
          if (Integer.valueOf(localObject[14]).intValue() != 1) {
            continue;
          }
          bool = true;
          this.jdField_b_of_type_Boolean = bool;
        }
        if (localObject.length >= 15) {
          this.jdField_a_of_type_Int = Integer.valueOf(localObject[15]).intValue();
        }
        if (localObject.length >= 16) {
          this.jdField_b_of_type_Int = Integer.valueOf(localObject[16]).intValue();
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        localException.printStackTrace();
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Boolean = false;
        this.jdField_a_of_type_Int = 0;
        this.jdField_b_of_type_Int = 1;
        QLog.e("Q.worldcup.record.dpc", 1, "loadValue, excption: " + localException.getMessage());
        continue;
      }
      QLog.d("Q.worldcup.record.dpc", 1, String.format("loadValue, mIsSupportRecord = %s, mIsSegmentRecord = %s, mMergeModel = %s, mMergeAudioModel = %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_b_of_type_Int) }));
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARWorldCupRecordDpc
 * JD-Core Version:    0.7.0.1
 */