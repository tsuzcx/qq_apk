package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Intent;
import android.text.TextUtils;
import bmqa;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import pha;
import pmy;
import pnn;
import rat;
import tdx;
import ube;

class ReadinjoyTabFrame$14
  implements Runnable
{
  ReadinjoyTabFrame$14(ReadinjoyTabFrame paramReadinjoyTabFrame, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      pha.f(this.this$0.a);
      if (this.jdField_a_of_type_Int == 5)
      {
        ReadinjoyTabFrame.a(this.this$0, true, false);
        localObject = (KandianMergeManager)this.this$0.a.getManager(162);
        ((KandianMergeManager)localObject).d(false);
        if (bmqa.j()) {
          ((KandianMergeManager)localObject).h();
        }
        ube.a(this.this$0.a, false);
        pmy.a().a.a(true);
        localObject = pha.e(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label254;
        }
        i = rat.d;
        label120:
        rat.a().a(i, 1);
      }
    }
    for (;;)
    {
      if (bmqa.h())
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label286;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        i = pha.e();
        int j = pha.d;
        tdx.a().a(this.this$0.a, l, i, j);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.14.1(this, l, i, j));
      }
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        pha.f();
        break;
      }
      if (this.jdField_a_of_type_Int != 13) {
        break;
      }
      localObject = this.this$0.a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        pha.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      pha.a(-1);
      break;
      label254:
      if (this.jdField_a_of_type_Int == 13)
      {
        i = rat.f;
        break label120;
      }
      i = rat.e;
      break label120;
      rat.a().c();
    }
    label286:
    tdx.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.14.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.14
 * JD-Core Version:    0.7.0.1
 */