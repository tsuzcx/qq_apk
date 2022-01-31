package com.tencent.av.report;

import android.content.Intent;
import android.os.SystemClock;

public class AVReport
{
  static volatile AVReport a;
  public long A;
  public long B;
  public long C;
  public long D;
  public long E;
  public long F;
  public long G;
  public long H;
  public long I;
  public long J;
  public long K;
  public long L;
  public long M;
  public long N;
  public long O;
  public long P;
  public long Q;
  public long R;
  public long S;
  public long T;
  public long a;
  public AVReport.ReceiverNodeStage a;
  public AVReport.SenderNodeStage a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  public boolean b;
  public long c;
  public boolean c;
  public long d;
  public boolean d;
  public long e;
  public boolean e;
  public long f;
  public boolean f;
  public long g;
  public boolean g;
  public long h;
  public boolean h;
  public long i;
  public boolean i;
  public long j;
  public boolean j;
  public long k;
  public boolean k;
  public long l;
  public boolean l;
  public long m;
  public boolean m;
  public long n;
  public boolean n;
  public long o;
  public boolean o;
  public long p;
  public boolean p;
  public long q;
  public long r;
  public long s;
  public long t;
  public long u;
  public long v;
  public long w;
  public long x;
  public long y;
  public long z;
  
  private AVReport()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public static AVReport a()
  {
    if (jdField_a_of_type_ComTencentAvReportAVReport == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentAvReportAVReport == null) {
        jdField_a_of_type_ComTencentAvReportAVReport = new AVReport();
      }
      return jdField_a_of_type_ComTencentAvReportAVReport;
    }
    finally {}
  }
  
  private String a(int paramInt, boolean paramBoolean1, long paramLong1, long paramLong2, boolean paramBoolean2)
  {
    long l1;
    if (paramLong1 > paramLong2) {
      l1 = paramLong1 - paramLong2;
    }
    while (paramBoolean1) {
      if (paramBoolean2)
      {
        if ((paramLong2 > 0L) && (paramLong1 > paramLong2))
        {
          return "" + "|STEP" + paramInt + "_1_0_" + l1;
          l1 = paramLong2 - paramLong1;
        }
        else
        {
          return "" + "|STEP" + paramInt + "_2_-1_0";
        }
      }
      else {
        return "" + "|STEP" + paramInt + "_1_0_" + l1;
      }
    }
    return "" + "|STEP" + paramInt + "_2_-1_0";
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    return (paramLong2 > 0L) && (paramLong1 > paramLong2);
  }
  
  public String a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long))
      {
        str = "" + a(1, true, this.jdField_b_of_type_Long, this.jdField_a_of_type_Long, true);
        paramBoolean = true;
        if (!paramBoolean) {
          break label398;
        }
        str = str + a(2, true, this.jdField_c_of_type_Long, this.jdField_b_of_type_Long, true);
        paramBoolean = a(this.jdField_c_of_type_Long, this.jdField_b_of_type_Long);
        label111:
        if (this.jdField_b_of_type_Long > this.jdField_c_of_type_Long) {
          this.jdField_p_of_type_Boolean = false;
        }
        if ((this.jdField_c_of_type_Long <= 0L) || (this.jdField_d_of_type_Long <= 0L)) {
          this.jdField_p_of_type_Boolean = false;
        }
        if (!paramBoolean) {
          break label421;
        }
        str = str + a(3, true, this.jdField_d_of_type_Long, this.jdField_c_of_type_Long, true);
        paramBoolean = a(this.jdField_d_of_type_Long, this.jdField_c_of_type_Long);
        label201:
        if (!paramBoolean) {
          break label444;
        }
        str = str + a(4, true, this.jdField_e_of_type_Long, this.jdField_d_of_type_Long, true);
        paramBoolean = a(this.jdField_e_of_type_Long, this.jdField_d_of_type_Long);
        label251:
        if (!paramBoolean) {
          break label467;
        }
        str = str + a(5, true, this.jdField_f_of_type_Long, this.jdField_e_of_type_Long, true);
        paramBoolean = a(this.jdField_f_of_type_Long, this.jdField_e_of_type_Long);
        label301:
        if (!paramBoolean) {
          break label490;
        }
        str = str + a(6, true, this.jdField_g_of_type_Long, this.jdField_f_of_type_Long, true);
        a(this.jdField_g_of_type_Long, this.jdField_f_of_type_Long);
      }
      for (;;)
      {
        return str + "|";
        str = "" + "|STEP1_2_-1_0";
        paramBoolean = false;
        break;
        label398:
        str = str + "|STEP2_0_0_0";
        break label111;
        label421:
        str = str + "|STEP3_0_0_0";
        break label201;
        label444:
        str = str + "|STEP4_0_0_0";
        break label251;
        label467:
        str = str + "|STEP5_0_0_0";
        break label301;
        label490:
        str = str + "|STEP6_0_0_0";
      }
    }
    int i1;
    if ((this.q > 0L) && (this.r > this.q))
    {
      str = "" + a(1, true, this.r, this.q, true);
      i1 = 1;
      if (i1 == 0) {
        break label710;
      }
      if ((this.u <= 0L) || (this.v <= this.u)) {
        break label674;
      }
      str = str + a(2, true, this.v, this.r, true);
    }
    for (;;)
    {
      return str + "|";
      str = "" + "|STEP1_2_-1_0";
      i1 = 0;
      break;
      label674:
      str = str + a(2, true, this.t, this.r, true);
      continue;
      label710:
      str = str + "|STEP2_0_0_0";
    }
  }
  
  public void a()
  {
    this.jdField_p_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_k_of_type_Long = 0L;
    this.jdField_l_of_type_Long = 0L;
    this.jdField_m_of_type_Long = 0L;
    this.jdField_n_of_type_Long = 0L;
    this.jdField_o_of_type_Long = 0L;
    this.jdField_p_of_type_Long = 0L;
    this.q = 0L;
    this.r = 0L;
    this.s = 0L;
    this.t = 0L;
    this.u = 0L;
    this.v = 0L;
    this.w = 0L;
    this.x = 0L;
    this.y = 0L;
    this.z = 0L;
    this.A = 0L;
    this.B = 0L;
    this.C = 0L;
    this.D = 0L;
    this.E = 0L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    this.F = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.G = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.H = 0L;
    this.jdField_f_of_type_Boolean = false;
    this.I = 0L;
    this.jdField_g_of_type_Boolean = false;
    this.J = 0L;
    this.jdField_h_of_type_Boolean = false;
    this.K = 0L;
    this.jdField_i_of_type_Boolean = false;
    this.L = 0L;
    this.jdField_j_of_type_Boolean = false;
    this.M = 0L;
    this.jdField_k_of_type_Boolean = false;
    this.N = 0L;
    this.jdField_l_of_type_Boolean = false;
    this.O = 0L;
    this.jdField_m_of_type_Boolean = false;
    this.P = 0L;
    this.jdField_n_of_type_Boolean = false;
    this.Q = 0L;
  }
  
  public void a(Intent paramIntent, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramIntent != null)
    {
      this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isSender", false);
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_h_of_type_Long = SystemClock.elapsedRealtime();
        this.jdField_i_of_type_Long = 0L;
        this.jdField_a_of_type_Long = paramIntent.getLongExtra("senderStartTime", 0L);
      }
    }
    else
    {
      return;
    }
    this.w = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.report.AVReport
 * JD-Core Version:    0.7.0.1
 */