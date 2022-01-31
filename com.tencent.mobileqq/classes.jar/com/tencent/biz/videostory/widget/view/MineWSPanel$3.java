package com.tencent.biz.videostory.widget.view;

import awbw;
import awbx;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import yxc;

public class MineWSPanel$3
  implements Runnable
{
  public MineWSPanel$3(yxc paramyxc, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (yxc.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    awbw localawbw = yxc.a(this.this$0).app.getEntityManagerFactory().createEntityManager();
    WSPersonalEntity localWSPersonalEntity = new WSPersonalEntity();
    localWSPersonalEntity.updateWeiShiFeedListEntity(yxc.a(this.this$0), this.a);
    if (localWSPersonalEntity.getStatus() == 1000) {
      localawbw.a(localWSPersonalEntity);
    }
    for (;;)
    {
      localawbw.a();
      return;
      localawbw.a(localWSPersonalEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.3
 * JD-Core Version:    0.7.0.1
 */