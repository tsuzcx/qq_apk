package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Intent;
import android.text.TextUtils;
import bmhv;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import pqu;
import prp;
import prq;
import pwb;
import pwq;
import rjm;
import tlx;
import uvs;

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
      prp.a(this.this$0.a);
      if (this.jdField_a_of_type_Int == 5)
      {
        ReadinjoyTabFrame.a(this.this$0, true, false);
        localObject = (KandianMergeManager)this.this$0.a.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
        ((KandianMergeManager)localObject).d(false);
        if (bmhv.n()) {
          ((KandianMergeManager)localObject).h();
        }
        uvs.a(this.this$0.a, false);
        pwb.a().a.a(true);
        localObject = prp.a(0);
        if ((!"1".equals(localObject)) && (!"0".equals(localObject))) {
          break label264;
        }
        i = rjm.d;
        label120:
        rjm.a().a(i, 1);
      }
    }
    for (;;)
    {
      VideoReport.traversePage(ReadinjoyTabFrame.b(this.this$0));
      if (bmhv.l())
      {
        if (!this.jdField_a_of_type_Boolean) {
          break label296;
        }
        long l = NetConnInfoCenter.getServerTimeMillis();
        i = pqu.a();
        int j = prp.jdField_a_of_type_Int;
        tlx.a().a(this.this$0.a, l, i, j);
        ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13.1(this, l, i, j));
      }
      return;
      if (this.jdField_a_of_type_Int == 6)
      {
        prq.a();
        break;
      }
      if (this.jdField_a_of_type_Int != 13) {
        break;
      }
      localObject = this.this$0.a().getIntent().getStringExtra("folder_status");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        prp.a(Integer.valueOf((String)localObject).intValue());
        break;
      }
      prp.a(-1);
      break;
      label264:
      if (this.jdField_a_of_type_Int == 13)
      {
        i = rjm.f;
        break label120;
      }
      i = rjm.e;
      break label120;
      rjm.a().c();
    }
    label296:
    tlx.a().a();
    ThreadManager.executeOnSubThread(new ReadinjoyTabFrame.13.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.13
 * JD-Core Version:    0.7.0.1
 */