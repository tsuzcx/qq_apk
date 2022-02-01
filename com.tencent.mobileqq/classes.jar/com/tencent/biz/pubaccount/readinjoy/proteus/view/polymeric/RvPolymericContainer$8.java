package com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.qphone.base.util.QLog;

class RvPolymericContainer$8
  implements ProteusRecycleView.OnStateChangeListener
{
  RvPolymericContainer$8(RvPolymericContainer paramRvPolymericContainer) {}
  
  public void a()
  {
    if (RvPolymericContainer.a(this.a) != null)
    {
      RvPolymericContainer.a(this.a).a();
      return;
    }
    ReadInJoyUtils.a(RvPolymericContainer.b(this.a).getContext(), RvPolymericContainer.a(this.a));
    QLog.d("RvPolymericContainer", 1, "mScrollJumpUrl : " + RvPolymericContainer.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.polymeric.RvPolymericContainer.8
 * JD-Core Version:    0.7.0.1
 */