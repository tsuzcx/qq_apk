import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;

class axrl
{
  public long a;
  public String a;
  public long b;
  public String b;
  public long c;
  public String c;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  public long g;
  public long h;
  public long i = 0L;
  public long j = 4L;
  public long k = a();
  public long l = Build.VERSION.SDK_INT;
  public long m;
  public long n = 0L;
  public long o = 0L;
  public long p = 0L;
  public long q = 0L;
  
  public axrl()
  {
    this.jdField_e_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "8.3.0";
    this.jdField_c_of_type_JavaLangString = Build.MODEL;
  }
  
  public int a()
  {
    int i2 = 0;
    int i1;
    if (AppNetConnInfo.isWifiConn()) {
      i1 = 2;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ScoreReportController", 2, "getNetType: " + i1);
      }
      return i1;
      i1 = i2;
      if (AppNetConnInfo.isMobileConn()) {
        switch (AppNetConnInfo.getMobileInfo())
        {
        default: 
          i1 = i2;
          break;
        case 1: 
          i1 = 3;
          break;
        case 2: 
          i1 = 4;
          break;
        case 3: 
          i1 = 5;
        }
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_e_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_f_of_type_Long);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.g);
    localStringBuilder.append('|');
    localStringBuilder.append(this.h);
    localStringBuilder.append('|');
    localStringBuilder.append(this.i);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.j);
    localStringBuilder.append('|');
    localStringBuilder.append(this.k);
    localStringBuilder.append('|');
    localStringBuilder.append(this.l);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('|');
    localStringBuilder.append(this.m);
    localStringBuilder.append('|');
    localStringBuilder.append(this.n);
    localStringBuilder.append('|');
    localStringBuilder.append(this.o);
    localStringBuilder.append('|');
    localStringBuilder.append(this.p);
    localStringBuilder.append('|');
    localStringBuilder.append(this.q);
    localStringBuilder.append('|');
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('|');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axrl
 * JD-Core Version:    0.7.0.1
 */