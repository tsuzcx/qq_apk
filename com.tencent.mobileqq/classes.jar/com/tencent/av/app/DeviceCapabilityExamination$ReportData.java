package com.tencent.av.app;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.AndroidCodecUtil;
import com.tencent.qphone.base.util.QLog;

public class DeviceCapabilityExamination$ReportData
{
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j = 0;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  public int o = 0;
  public int p = 0;
  public int q = 0;
  public int r = 0;
  
  public DeviceCapabilityExamination$ReportData()
  {
    this.jdField_a_of_type_JavaLangString = Build.HARDWARE;
    this.jdField_b_of_type_JavaLangString = Build.MANUFACTURER;
    this.jdField_c_of_type_JavaLangString = Build.MODEL;
    this.jdField_d_of_type_JavaLangString = Build.PRODUCT;
    this.jdField_e_of_type_JavaLangString = Build.FINGERPRINT;
    this.jdField_f_of_type_JavaLangString = VcSystemInfo.getCpuModel();
    this.jdField_a_of_type_Int = Build.VERSION.SDK_INT;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
    this.jdField_g_of_type_JavaLangString = "";
    this.jdField_h_of_type_JavaLangString = "";
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_i_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
  }
  
  public String a()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_a_of_type_Long);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_b_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_h_of_type_JavaLangString);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_c_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_d_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_e_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_f_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_g_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_h_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_i_of_type_Int);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.j);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_i_of_type_JavaLangString);
    localStringBuilder1.append("|");
    this.k = VcSystemInfo.getNumCores();
    this.jdField_b_of_type_Long = (VcSystemInfo.getMaxCpuFreq() / 1024L);
    this.jdField_c_of_type_Long = (VcSystemInfo.getMemoryTotal() / 1024L);
    this.l = AndroidCodec.getHwDetectOutputFormatForReport();
    this.m = AndroidCodecUtil.jdField_a_of_type_Int;
    this.n = AndroidCodecUtil.jdField_b_of_type_Int;
    this.o = AndroidCodecUtil.jdField_c_of_type_Int;
    this.p = AndroidCodecUtil.jdField_d_of_type_Int;
    this.q = AndroidCodecUtil.jdField_e_of_type_Int;
    this.r = AndroidCodecUtil.jdField_f_of_type_Int;
    localStringBuilder1.append(this.k);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_b_of_type_Long);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.jdField_c_of_type_Long);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.l);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.m);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.n);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.o);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.p);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.q);
    localStringBuilder1.append("|");
    localStringBuilder1.append(this.r);
    localStringBuilder1.append("|");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("ReportData:");
    localStringBuilder2.append(localStringBuilder1.toString());
    QLog.i("DeviceCapabilityExamination", 1, localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.DeviceCapabilityExamination.ReportData
 * JD-Core Version:    0.7.0.1
 */