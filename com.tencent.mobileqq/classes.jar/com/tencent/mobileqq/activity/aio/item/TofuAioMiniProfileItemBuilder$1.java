package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.tofumsg.TofuManager;

class TofuAioMiniProfileItemBuilder$1
  implements Runnable
{
  TofuAioMiniProfileItemBuilder$1(TofuAioMiniProfileItemBuilder paramTofuAioMiniProfileItemBuilder, TofuAioMiniProfileItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    ((TofuManager)this.this$0.a.getManager(QQManagerFactory.TOFUMSG_MANAGER)).a(this.a.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TofuAioMiniProfileItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */