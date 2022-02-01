package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Intent;
import android.text.TextUtils;
import bkwm;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import pay;
import ple;
import plt;
import qxg;
import syp;
import uhv;

class ReadinjoyTabFrame$13
  implements Runnable
{
  ReadinjoyTabFrame$13(ReadinjoyTabFrame paramReadinjoyTabFrame, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      pay.f(this.this$0.a);
      if (this.jdField_a_of_type_Int == 5)
      {
        ReadinjoyTabFrame.a(this.this$0, true, false);
        localObject = (KandianMergeManager)this.this$0.a.getManager(162);
        ((KandianMergeManager)localObject).d(false);
        if (bkwm.k()) {
          ((KandianMergeManager)localObject).h();
        }
        uhv.a(this.this$0.a, false);
        ple.a().a.a(true);
        localObject = pay.e(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label264;
        }
        i = qxg.d;
        label120:
        qxg.a().a(i, 1);
      }
    }
    for (;;)
    {
      VideoReport.traversePage(ReadinjoyTabFrame.b(this.this$0));
      if (bkwm.i())
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label296;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        i = pay.e();
        int j = pay.d;
        syp.a().a(this.this$0.a, l, i, j);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13.1(this, l, i, j));
      }
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        pay.f();
        break;
      }
      if (this.jdField_a_of_type_Int != 13) {
        break;
      }
      localObject = this.this$0.a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        pay.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      pay.a(-1);
      break;
      label264:
      if (this.jdField_a_of_type_Int == 13)
      {
        i = qxg.f;
        break label120;
      }
      i = qxg.e;
      break label120;
      qxg.a().c();
    }
    label296:
    syp.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.13
 * JD-Core Version:    0.7.0.1
 */