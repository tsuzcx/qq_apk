package com.tencent.mobileqq.ar;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class ScanEntranceDPC
{
  private static ScanEntranceDPC a;
  public float a;
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public static ScanEntranceDPC a()
  {
    if (jdField_a_of_type_ComTencentMobileqqArScanEntranceDPC == null)
    {
      jdField_a_of_type_ComTencentMobileqqArScanEntranceDPC = new ScanEntranceDPC();
      jdField_a_of_type_ComTencentMobileqqArScanEntranceDPC.a();
    }
    return jdField_a_of_type_ComTencentMobileqqArScanEntranceDPC;
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    b();
    Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.ARCfg.name());
    QLog.d("ScanEntranceDPC", 1, String.format("loadDPC dpcValue=%s", new Object[] { localObject }));
    j = -1;
    i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 9) {
          continue;
        }
        if (Integer.valueOf(localObject[1]).intValue() != 1) {
          continue;
        }
        bool = true;
        this.jdField_a_of_type_Boolean = bool;
        i = Integer.valueOf(localObject[2]).intValue();
        if (i >= 0) {
          this.jdField_a_of_type_Int = i;
        }
        float f = Float.valueOf(localObject[3]).floatValue();
        if ((f >= 0.05F) && (f <= 0.95F)) {
          this.jdField_a_of_type_Float = f;
        }
        if (Integer.valueOf(localObject[4]).intValue() != 1) {
          continue;
        }
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        i = Integer.valueOf(localObject[5]).intValue();
        if (i >= 0) {
          this.jdField_b_of_type_Int = i;
        }
        if (Integer.valueOf(localObject[6]).intValue() != 1) {
          continue;
        }
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
        if (Integer.valueOf(localObject[7]).intValue() != 1) {
          continue;
        }
        bool = true;
        this.d = bool;
        i = Integer.valueOf(localObject[8]).intValue();
        if ((i >= 0) && (i <= 255)) {
          this.jdField_c_of_type_Int = i;
        }
        if (localObject.length >= 12)
        {
          if (Integer.valueOf(localObject[11]).intValue() != 1) {
            continue;
          }
          bool = true;
          this.e = bool;
        }
        i = j;
        if (localObject.length > 12) {
          i = Integer.valueOf(localObject[12]).intValue();
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        QLog.e("ScanEntranceDPC", 1, "loadDPC fail, use default value.", localException);
        b();
        i = j;
        continue;
      }
      QLog.d("ScanEntranceDPC", 1, String.format("loadDPC mHighPerfDevice=%s mCameraZoom=%s mScanRectRadio=%s mContinuousFocus=%s mARRecogInterval=%s mRecycleFaceResource=%s mRecordEnable=%s mDarkThreshold=%s mNeonCfgSwitch=%s, disableWorldCup=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Float.valueOf(this.jdField_a_of_type_Float), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.d), Integer.valueOf(this.jdField_c_of_type_Int), Boolean.valueOf(this.e), Integer.valueOf(i) }));
      QLog.d("ScanEntranceDPC", 1, String.format("loadDPC time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      return;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      bool = false;
      continue;
      QLog.e("ScanEntranceDPC", 1, "loadDPC dpc length invalid, use default value.");
      i = j;
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_Float = 0.7F;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Int = 500;
    this.jdField_c_of_type_Boolean = true;
    this.d = true;
    this.jdField_c_of_type_Int = 28;
    this.e = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ScanEntranceDPC
 * JD-Core Version:    0.7.0.1
 */