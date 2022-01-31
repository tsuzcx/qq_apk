package com.tencent.mobileqq.armap.wealthgod;

import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class ARMapDPC
{
  public float a;
  public int a;
  public String a;
  public boolean a;
  public float b;
  public int b;
  public String b;
  public boolean b;
  public float c;
  public int c;
  public boolean c;
  public float d;
  public int d;
  public boolean d;
  public int e = 60;
  
  public ARMapDPC()
  {
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static ARMapDPC a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapDPC", 2, "loaARMapDPC");
    }
    long l = System.currentTimeMillis();
    int i12 = (int)(DeviceInfoUtil.e() / 1024L / 1024L);
    int i13 = ViewUtils.a();
    int i4 = 512;
    int i5 = 480;
    int i6 = 0;
    int i7 = 0;
    int i8 = 0;
    int i9 = 100;
    int i10 = 1500;
    String str2 = "ON";
    float f5 = 0.2F;
    bool3 = false;
    boolean bool4 = false;
    int i11 = 60;
    float f6 = 0.1F;
    float f7 = 0.1F;
    float f8 = 0.2F;
    String str3 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.arMapCfg.name());
    f1 = f8;
    f2 = f7;
    f3 = f6;
    i = i11;
    bool1 = bool4;
    bool2 = bool3;
    f4 = f5;
    String str1 = str2;
    j = i10;
    k = i9;
    m = i8;
    n = i7;
    i1 = i6;
    i2 = i5;
    i3 = i4;
    if (!TextUtils.isEmpty(str3)) {
      localObject1 = str2;
    }
    for (;;)
    {
      try
      {
        String[] arrayOfString = str3.split("\\|");
        f1 = f8;
        f2 = f7;
        f3 = f6;
        i = i11;
        bool1 = bool4;
        bool2 = bool3;
        f4 = f5;
        str1 = str2;
        j = i10;
        k = i9;
        m = i8;
        n = i7;
        i1 = i6;
        i2 = i5;
        i3 = i4;
        localObject1 = str2;
        if (arrayOfString.length >= 15)
        {
          localObject1 = str2;
          i3 = Integer.valueOf(arrayOfString[0]).intValue();
          localObject1 = str2;
          i2 = Integer.valueOf(arrayOfString[1]).intValue();
          localObject1 = str2;
          i1 = Integer.valueOf(arrayOfString[2]).intValue();
          localObject1 = str2;
          n = Integer.valueOf(arrayOfString[3]).intValue();
          localObject1 = str2;
          m = Integer.valueOf(arrayOfString[4]).intValue();
          localObject1 = str2;
          k = Integer.valueOf(arrayOfString[5]).intValue();
          localObject1 = str2;
          j = Integer.valueOf(arrayOfString[6]).intValue();
          str1 = arrayOfString[7];
          localObject1 = str1;
          f4 = Float.valueOf(arrayOfString[8]).floatValue();
          localObject1 = str1;
          if (Integer.valueOf(arrayOfString[9]).intValue() == 0) {
            continue;
          }
          bool2 = true;
          localObject1 = str1;
          if (Integer.valueOf(arrayOfString[10]).intValue() == 0) {
            continue;
          }
          bool1 = true;
          localObject1 = str1;
          i = Integer.valueOf(arrayOfString[11]).intValue();
          localObject1 = str1;
          f3 = Float.valueOf(arrayOfString[12]).floatValue();
          localObject1 = str1;
          f2 = Float.valueOf(arrayOfString[13]).floatValue();
          localObject1 = str1;
          f1 = Float.valueOf(arrayOfString[14]).floatValue();
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("ARMapDPC", 2, "loaARMapDPC fail!");
        i3 = 512;
        i2 = 480;
        i1 = 0;
        n = 0;
        m = 0;
        k = 100;
        j = 1500;
        f4 = 0.2F;
        bool2 = false;
        bool1 = false;
        i = 60;
        f3 = 0.1F;
        f2 = 0.1F;
        f1 = 0.2F;
        Object localObject2 = localObject1;
        continue;
        bool3 = false;
        continue;
        bool3 = false;
        continue;
      }
      localObject1 = new ARMapDPC();
      ((ARMapDPC)localObject1).jdField_a_of_type_JavaLangString = str3;
      if ((i12 > i3) && (i13 > i2)) {
        continue;
      }
      bool3 = true;
      ((ARMapDPC)localObject1).jdField_a_of_type_Boolean = bool3;
      if (i1 == 0) {
        continue;
      }
      bool3 = true;
      ((ARMapDPC)localObject1).jdField_b_of_type_Boolean = bool3;
      ((ARMapDPC)localObject1).jdField_a_of_type_Int = n;
      ((ARMapDPC)localObject1).jdField_b_of_type_Int = m;
      ((ARMapDPC)localObject1).jdField_c_of_type_Int = k;
      ((ARMapDPC)localObject1).jdField_d_of_type_Int = j;
      ((ARMapDPC)localObject1).jdField_b_of_type_JavaLangString = str1;
      ((ARMapDPC)localObject1).jdField_a_of_type_Float = f4;
      ((ARMapDPC)localObject1).jdField_c_of_type_Boolean = bool2;
      ((ARMapDPC)localObject1).jdField_d_of_type_Boolean = bool1;
      ((ARMapDPC)localObject1).e = i;
      ((ARMapDPC)localObject1).jdField_b_of_type_Float = f3;
      ((ARMapDPC)localObject1).jdField_c_of_type_Float = f2;
      ((ARMapDPC)localObject1).jdField_d_of_type_Float = f1;
      if (QLog.isColorLevel())
      {
        QLog.d("ARMapDPC", 2, String.format("loaARMapDPC arMapDPC:%s", new Object[] { localObject1 }));
        QLog.d("ARMapDPC", 2, String.format("loaARMapDPC time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) }));
      }
      return localObject1;
      bool2 = false;
      continue;
      bool1 = false;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mDPCStr=").append(this.jdField_a_of_type_JavaLangString).append(" mUseInSample2=").append(this.jdField_a_of_type_Boolean).append(" mUseARGB8888=").append(this.jdField_b_of_type_Boolean).append(", network=").append(this.jdField_a_of_type_Int).append(", forceCheck=").append(this.jdField_b_of_type_Int).append(", maxPOIReachCount=").append(this.jdField_c_of_type_Int).append(", maxPOIExposureCache=").append(this.jdField_d_of_type_Int).append(", armapSwitcher=").append(this.jdField_b_of_type_JavaLangString).append(", mapNotSupportSensor=").append(this.jdField_c_of_type_Boolean).append(", mapFPSLimitSwitch=").append(this.jdField_d_of_type_Boolean).append(", mapFPSLimit=").append(this.e).append(", preloadGridMapRate_0_7=").append(this.jdField_a_of_type_Float).append(", preloadGridMapRate_7_15=").append(this.jdField_b_of_type_Float).append(", preloadGridMapRate_15_24=").append(this.jdField_c_of_type_Float).append(", preloadARMapRate=").append(this.jdField_d_of_type_Float);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.wealthgod.ARMapDPC
 * JD-Core Version:    0.7.0.1
 */