package com.tencent.biz.videostory.widget.view;

import aukn;
import auko;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import xim;

public class MineWSPanel$3
  implements Runnable
{
  public MineWSPanel$3(xim paramxim, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (xim.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    aukn localaukn = xim.a(this.this$0).app.getEntityManagerFactory().createEntityManager();
    WSPersonalEntity localWSPersonalEntity = new WSPersonalEntity();
    localWSPersonalEntity.updateWeiShiFeedListEntity(xim.a(this.this$0), this.a);
    if (localWSPersonalEntity.getStatus() == 1000) {
      localaukn.a(localWSPersonalEntity);
    }
    for (;;)
    {
      localaukn.a();
      return;
      localaukn.a(localWSPersonalEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.3
 * JD-Core Version:    0.7.0.1
 */