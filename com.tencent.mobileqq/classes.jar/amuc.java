import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class amuc
{
  private static amuc a;
  public float a;
  public int a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  
  public static amuc a()
  {
    if (jdField_a_of_type_Amuc == null)
    {
      jdField_a_of_type_Amuc = new amuc();
      jdField_a_of_type_Amuc.a();
    }
    return jdField_a_of_type_Amuc;
  }
  
  private void a()
  {
    long l = System.currentTimeMillis();
    b();
    Object localObject = DeviceProfileManager.b().a(DeviceProfileManager.DpcNames.ARCfg.name());
    QLog.d("ScanEntranceDPC", 1, String.format("loadDPC dpcValue=%s", new Object[] { localObject }));
    int k = -1;
    m = k;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      j = k;
    }
    for (;;)
    {
      try
      {
        localObject = ((String)localObject).split("\\|");
        j = k;
        if (localObject.length < 9) {
          continue;
        }
        j = k;
        if (Integer.valueOf(localObject[1]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.jdField_a_of_type_Boolean = bool;
        j = k;
        int i = Integer.valueOf(localObject[2]).intValue();
        if (i >= 0)
        {
          j = k;
          this.jdField_a_of_type_Int = i;
        }
        j = k;
        float f1 = Float.valueOf(localObject[3]).floatValue();
        if ((f1 >= 0.05F) && (f1 <= 0.95F))
        {
          j = k;
          this.jdField_a_of_type_Float = f1;
        }
        j = k;
        if (Integer.valueOf(localObject[4]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.jdField_b_of_type_Boolean = bool;
        j = k;
        i = Integer.valueOf(localObject[5]).intValue();
        if (i >= 0)
        {
          j = k;
          this.jdField_b_of_type_Int = i;
        }
        j = k;
        if (Integer.valueOf(localObject[6]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.jdField_c_of_type_Boolean = bool;
        j = k;
        if (Integer.valueOf(localObject[7]).intValue() != 1) {
          continue;
        }
        bool = true;
        j = k;
        this.d = bool;
        j = k;
        i = Integer.valueOf(localObject[8]).intValue();
        if ((i >= 0) && (i <= 255))
        {
          j = k;
          this.jdField_c_of_type_Int = i;
        }
        j = k;
        if (localObject.length >= 12)
        {
          j = k;
          if (Integer.valueOf(localObject[11]).intValue() != 1) {
            continue;
          }
          bool = true;
          j = k;
          this.e = bool;
        }
        i = k;
        j = k;
        if (localObject.length > 12)
        {
          j = k;
          i = Integer.valueOf(localObject[12]).intValue();
        }
        j = i;
        if (localObject.length >= 18)
        {
          j = i;
          if (Integer.valueOf(localObject[17]).intValue() != 1) {
            continue;
          }
          bool = true;
          j = i;
          this.f = bool;
        }
        m = i;
        j = i;
        if (localObject.length >= 19)
        {
          j = i;
          if (Integer.valueOf(localObject[18]).intValue() != 1) {
            continue;
          }
          bool = true;
          j = i;
          this.g = bool;
          m = i;
        }
      }
      catch (Exception localException)
      {
        boolean bool;
        QLog.e("ScanEntranceDPC", 1, "loadDPC fail, use default value.", localException);
        b();
        m = j;
        continue;
      }
      QLog.d("ScanEntranceDPC", 1, String.format("loadDPC mHighPerfDevice=%s mCameraZoom=%s mScanRectRadio=%s mContinuousFocus=%s mARRecogInterval=%s mRecycleFaceResource=%s mRecordEnable=%s mDarkThreshold=%s mNeonCfgSwitch=%s, disableWorldCup=%s mMiniDecodeSwitch=%s mMiniDetectSwitch=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(this.jdField_a_of_type_Int), Float.valueOf(this.jdField_a_of_type_Float), Boolean.valueOf(this.jdField_b_of_type_Boolean), Integer.valueOf(this.jdField_b_of_type_Int), Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.d), Integer.valueOf(this.jdField_c_of_type_Int), Boolean.valueOf(this.e), Integer.valueOf(m), Boolean.valueOf(this.f), Boolean.valueOf(this.g) }));
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
      bool = false;
      continue;
      bool = false;
      continue;
      j = k;
      QLog.e("ScanEntranceDPC", 1, "loadDPC dpc length invalid, use default value.");
      m = k;
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
    this.f = false;
    this.g = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuc
 * JD-Core Version:    0.7.0.1
 */