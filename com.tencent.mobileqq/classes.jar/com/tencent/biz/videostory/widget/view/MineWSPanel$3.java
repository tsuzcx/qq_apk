package com.tencent.biz.videostory.widget.view;

import atmp;
import atmq;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import wzm;

public class MineWSPanel$3
  implements Runnable
{
  public MineWSPanel$3(wzm paramwzm, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (wzm.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    atmp localatmp = wzm.a(this.this$0).app.getEntityManagerFactory().createEntityManager();
    WSPersonalEntity localWSPersonalEntity = new WSPersonalEntity();
    localWSPersonalEntity.updateWeiShiFeedListEntity(wzm.a(this.this$0), this.a);
    if (localWSPersonalEntity.getStatus() == 1000) {
      localatmp.a(localWSPersonalEntity);
    }
    for (;;)
    {
      localatmp.a();
      return;
      localatmp.a(localWSPersonalEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.3
 * JD-Core Version:    0.7.0.1
 */