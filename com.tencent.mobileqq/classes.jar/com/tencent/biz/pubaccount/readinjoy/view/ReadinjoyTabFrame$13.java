package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Intent;
import android.text.TextUtils;
import bnrf;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import ozs;
import pfs;
import pgh;
import qrn;
import sup;
import ubg;

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
      ozs.f(this.this$0.a);
      if (this.jdField_a_of_type_Int == 5)
      {
        ReadinjoyTabFrame.a(this.this$0, true, false);
        localObject = (KandianMergeManager)this.this$0.a.getManager(162);
        ((KandianMergeManager)localObject).d(false);
        if (bnrf.j()) {
          ((KandianMergeManager)localObject).h();
        }
        ubg.a(this.this$0.a, false);
        pfs.a().a.a(true);
        localObject = ozs.e(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label254;
        }
        i = qrn.d;
        label120:
        qrn.a().a(i, 1);
      }
    }
    for (;;)
    {
      if (bnrf.h())
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label286;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        i = ozs.e();
        int j = ozs.d;
        sup.a().a(this.this$0.a, l, i, j);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13.1(this, l, i, j));
      }
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        ozs.f();
        break;
      }
      if (this.jdField_a_of_type_Int != 13) {
        break;
      }
      localObject = this.this$0.a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        ozs.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      ozs.a(-1);
      break;
      label254:
      if (this.jdField_a_of_type_Int == 13)
      {
        i = qrn.f;
        break label120;
      }
      i = qrn.e;
      break label120;
      qrn.a().c();
    }
    label286:
    sup.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.13
 * JD-Core Version:    0.7.0.1
 */