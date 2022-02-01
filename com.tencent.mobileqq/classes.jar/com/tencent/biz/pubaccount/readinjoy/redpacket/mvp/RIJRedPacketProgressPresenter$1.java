package com.tencent.biz.pubaccount.readinjoy.redpacket.mvp;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import qrk;
import qrl;
import qrm;

public class RIJRedPacketProgressPresenter$1
  implements Runnable
{
  public void run()
  {
    if (qrm.a(this.this$0) != null) {
      if (!this.jdField_a_of_type_JavaLangString.equals(qrm.a(this.this$0).a())) {
        break label552;
      }
    }
    label552:
    for (int i = qrm.a(this.this$0).b();; i = 0)
    {
      int j;
      int k;
      if (((!qrm.a(this.this$0).a(this.jdField_a_of_type_JavaLangString)) && (i < qrm.a(this.this$0).e())) || ((!TextUtils.isEmpty(qrm.a(this.this$0).b())) && (qrm.a(this.this$0).b().equals(this.jdField_a_of_type_JavaLangString)) && (qrm.a(this.this$0).f() + qrm.a(this.this$0).b() < qrm.a(this.this$0).e())))
      {
        i = qrm.a(this.this$0).h();
        j = qrm.a(this.this$0).g();
        k = qrm.a(this.this$0).d();
        int m = qrm.a(this.this$0).c();
        int n = (j + k - 1) / k;
        if (!this.jdField_a_of_type_JavaLangString.equals(qrm.a(this.this$0).a()))
        {
          qrm.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
          qrm.a(this.this$0).b(0);
          qrm.a(this.this$0).a(this.jdField_a_of_type_Int);
        }
        qrm.a(this.this$0).b(qrm.a(this.this$0).b() + 33);
        if (j > i)
        {
          this.this$0.a();
          qrm.a(this.this$0).b(m);
          qrm.a(this.this$0).c(0);
          return;
        }
        if ((j + 33 > n * k) && (n != 0))
        {
          qrm.a(this.this$0).c(j + 33);
          qrm.a(this.this$0).a(n, m);
          qrm.a(this.this$0).a(0.0F);
          long l = NetConnInfoCenter.getServerTimeMillis();
          if (!qrm.a(this.this$0, l, l - 33L))
          {
            qrm.a(this.this$0).a(0.0F);
            qrm.a(this.this$0).b(0);
            qrm.a(this.this$0).c(0);
          }
        }
      }
      for (;;)
      {
        qrm.a(this.this$0).postDelayed(qrm.a(this.this$0), 33L);
        return;
        qrm.a(this.this$0).c(j + 33);
        qrm.a(this.this$0).a(j % k / k * 100.0F);
        break;
        this.this$0.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.mvp.RIJRedPacketProgressPresenter.1
 * JD-Core Version:    0.7.0.1
 */