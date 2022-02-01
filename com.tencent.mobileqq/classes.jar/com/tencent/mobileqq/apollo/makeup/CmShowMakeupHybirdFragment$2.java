package com.tencent.mobileqq.apollo.makeup;

import anis;
import ankl;
import anlx;
import com.tencent.qphone.base.util.QLog;

class CmShowMakeupHybirdFragment$2
  implements Runnable
{
  CmShowMakeupHybirdFragment$2(CmShowMakeupHybirdFragment paramCmShowMakeupHybirdFragment) {}
  
  public void run()
  {
    ankl.a("dressup_3d_page", "model", "expose", null);
    anlx.a("dressup_first_frame", String.valueOf(System.currentTimeMillis() - CmShowMakeupHybirdFragment.a(this.this$0)), null);
    anis.a(126, 4, 0, new Object[0]);
    CmShowMakeupHybirdFragment.a(this.this$0, false);
    QLog.i("CmShowMakeupHybirdFragment", 1, "[doSetCmShowAssetsData] first frame");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.makeup.CmShowMakeupHybirdFragment.2
 * JD-Core Version:    0.7.0.1
 */