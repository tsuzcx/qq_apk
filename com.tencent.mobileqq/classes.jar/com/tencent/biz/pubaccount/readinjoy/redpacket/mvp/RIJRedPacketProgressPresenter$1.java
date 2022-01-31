package com.tencent.biz.pubaccount.readinjoy.redpacket.mvp;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import qgw;
import qgx;
import qhi;

public class RIJRedPacketProgressPresenter$1
  implements Runnable
{
  public RIJRedPacketProgressPresenter$1(qhi paramqhi, String paramString, int paramInt) {}
  
  public void run()
  {
    if (qhi.a(this.this$0) != null) {
      if (!this.jdField_a_of_type_JavaLangString.equals(qhi.a(this.this$0).a())) {
        break label552;
      }
    }
    label552:
    for (int i = qhi.a(this.this$0).b();; i = 0)
    {
      int j;
      int k;
      if (((!qhi.a(this.this$0).a(this.jdField_a_of_type_JavaLangString)) && (i < qhi.a(this.this$0).e())) || ((!TextUtils.isEmpty(qhi.a(this.this$0).b())) && (qhi.a(this.this$0).b().equals(this.jdField_a_of_type_JavaLangString)) && (qhi.a(this.this$0).f() + qhi.a(this.this$0).b() < qhi.a(this.this$0).e())))
      {
        i = qhi.a(this.this$0).h();
        j = qhi.a(this.this$0).g();
        k = qhi.a(this.this$0).d();
        int m = qhi.a(this.this$0).c();
        int n = (j + k - 1) / k;
        if (!this.jdField_a_of_type_JavaLangString.equals(qhi.a(this.this$0).a()))
        {
          qhi.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
          qhi.a(this.this$0).b(0);
          qhi.a(this.this$0).a(this.jdField_a_of_type_Int);
        }
        qhi.a(this.this$0).b(qhi.a(this.this$0).b() + 33);
        if (j > i)
        {
          this.this$0.c();
          qhi.a(this.this$0).setFinishRound(m);
          qhi.a(this.this$0).d(0);
          return;
        }
        if ((j + 33 > n * k) && (n != 0))
        {
          qhi.a(this.this$0).d(j + 33);
          qhi.a(this.this$0).setRound(n, m);
          qhi.a(this.this$0).setProgress(0.0F);
          long l = NetConnInfoCenter.getServerTimeMillis();
          if (!qhi.a(this.this$0, l, l - 33L))
          {
            qhi.a(this.this$0).setProgress(0.0F);
            qhi.a(this.this$0).b(0);
            qhi.a(this.this$0).d(0);
          }
        }
      }
      for (;;)
      {
        qhi.a(this.this$0).postDelayed(qhi.a(this.this$0), 33L);
        return;
        qhi.a(this.this$0).d(j + 33);
        qhi.a(this.this$0).setProgress(j % k / k * 100.0F);
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