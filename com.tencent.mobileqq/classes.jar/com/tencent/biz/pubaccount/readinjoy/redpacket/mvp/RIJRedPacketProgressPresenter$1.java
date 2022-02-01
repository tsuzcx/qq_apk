package com.tencent.biz.pubaccount.readinjoy.redpacket.mvp;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import rae;
import raf;
import raq;

public class RIJRedPacketProgressPresenter$1
  implements Runnable
{
  public RIJRedPacketProgressPresenter$1(raq paramraq, String paramString, int paramInt) {}
  
  public void run()
  {
    if (raq.a(this.this$0) != null) {
      if (!this.jdField_a_of_type_JavaLangString.equals(raq.a(this.this$0).a())) {
        break label552;
      }
    }
    label552:
    for (int i = raq.a(this.this$0).b();; i = 0)
    {
      int j;
      int k;
      if (((!raq.a(this.this$0).a(this.jdField_a_of_type_JavaLangString)) && (i < raq.a(this.this$0).e())) || ((!TextUtils.isEmpty(raq.a(this.this$0).b())) && (raq.a(this.this$0).b().equals(this.jdField_a_of_type_JavaLangString)) && (raq.a(this.this$0).f() + raq.a(this.this$0).b() < raq.a(this.this$0).e())))
      {
        i = raq.a(this.this$0).h();
        j = raq.a(this.this$0).g();
        k = raq.a(this.this$0).d();
        int m = raq.a(this.this$0).c();
        int n = (j + k - 1) / k;
        if (!this.jdField_a_of_type_JavaLangString.equals(raq.a(this.this$0).a()))
        {
          raq.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
          raq.a(this.this$0).b(0);
          raq.a(this.this$0).a(this.jdField_a_of_type_Int);
        }
        raq.a(this.this$0).b(raq.a(this.this$0).b() + 33);
        if (j > i)
        {
          this.this$0.c();
          raq.a(this.this$0).setFinishRound(m);
          raq.a(this.this$0).d(0);
          return;
        }
        if ((j + 33 > n * k) && (n != 0))
        {
          raq.a(this.this$0).d(j + 33);
          raq.a(this.this$0).setRound(n, m);
          raq.a(this.this$0).setProgress(0.0F);
          long l = NetConnInfoCenter.getServerTimeMillis();
          if (!raq.a(this.this$0, l, l - 33L))
          {
            raq.a(this.this$0).setProgress(0.0F);
            raq.a(this.this$0).b(0);
            raq.a(this.this$0).d(0);
          }
        }
      }
      for (;;)
      {
        raq.a(this.this$0).postDelayed(raq.a(this.this$0), 33L);
        return;
        raq.a(this.this$0).d(j + 33);
        raq.a(this.this$0).setProgress(j % k / k * 100.0F);
        break;
        this.this$0.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.redpacket.mvp.RIJRedPacketProgressPresenter.1
 * JD-Core Version:    0.7.0.1
 */