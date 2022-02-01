package com.tencent.featuretoggle.hltxkg.access.http.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.access.http.a.d;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import com.tencent.featuretoggle.hltxkg.common.a.k;
import com.tencent.featuretoggle.hltxkg.common.b.a.f;
import com.tencent.featuretoggle.hltxkg.common.e.c;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements k
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected d a;
  private int b;
  public String b;
  private int c;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected com.tencent.featuretoggle.hltxkg.common.b.a.a e;
  
  public a(d paramd)
  {
    this.jdField_b_of_type_Int = 5000;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD = paramd;
    this.jdField_b_of_type_JavaLangString = paramd.a;
    this.jdField_c_of_type_JavaLangString = paramd.a;
    this.jdField_a_of_type_Int = paramd.f;
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
  
  public f a()
  {
    try
    {
      this.jdField_b_of_type_Int = i.a("app_http_proxy_timeout", 0, 20000, 5000);
      int i = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Int <= 0) {
        this.jdField_a_of_type_Int = i.a("app_req_timeout", 1000, 1000000, 15000);
      }
      if ((this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD.k > 0) && (this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD.k < this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD.k;
      }
      i = this.jdField_a_of_type_Int;
      f localf;
      for (;;)
      {
        localf = a(i);
        i = c.a((int)(this.jdField_a_of_type_Int - (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long)), 0, this.jdField_a_of_type_Int);
        if ((localf.jdField_a_of_type_Int != 0) || (localf.jdField_c_of_type_Int < 300) || (localf.jdField_c_of_type_Int >= 400) || (!this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD.e) || (i <= 200)) {
          break;
        }
        String str = localf.a("location");
        if (TextUtils.isEmpty(str))
        {
          localf.jdField_a_of_type_Int = -6;
          break;
        }
        this.jdField_c_of_type_JavaLangString = str;
        this.jdField_c_of_type_Int += 1;
        if (this.jdField_c_of_type_Int > 5)
        {
          localf.jdField_a_of_type_Int = -5;
          break;
        }
        this.e.a(true);
      }
      if (this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD.j)
      {
        localf.jdField_a_of_type_Int = -20;
        localf.jdField_b_of_type_JavaLangString = "";
      }
      if (this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD.m)
      {
        this.e.k = true;
        this.e.j = true;
        this.e.l = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgAccessHttpAD.k;
      }
      else
      {
        this.e.l = (SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
      }
      this.e.a(false);
      return localf;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      return new f(-1, c.a(localThrowable), 0);
    }
  }
  
  protected abstract f a(int paramInt);
  
  public final boolean b()
  {
    try
    {
      if (this.e != null) {
        this.e.b();
      }
      label15:
      return true;
    }
    catch (Throwable localThrowable)
    {
      break label15;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.b.a
 * JD-Core Version:    0.7.0.1
 */