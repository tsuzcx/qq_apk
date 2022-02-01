package com.tencent.biz.videostory.widget.view;

import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import zyx;

public class MineWSPanel$3
  implements Runnable
{
  public MineWSPanel$3(zyx paramzyx, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (zyx.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    EntityManager localEntityManager = zyx.a(this.this$0).app.getEntityManagerFactory().createEntityManager();
    WSPersonalEntity localWSPersonalEntity2 = (WSPersonalEntity)localEntityManager.find(WSPersonalEntity.class, zyx.a(this.this$0));
    WSPersonalEntity localWSPersonalEntity1 = localWSPersonalEntity2;
    if (localWSPersonalEntity2 == null) {
      localWSPersonalEntity1 = new WSPersonalEntity();
    }
    localWSPersonalEntity1.updateWeiShiFeedListEntity(zyx.a(this.this$0), this.a);
    if (localWSPersonalEntity1.getStatus() == 1000) {
      localEntityManager.persist(localWSPersonalEntity1);
    }
    for (;;)
    {
      localEntityManager.close();
      return;
      localEntityManager.update(localWSPersonalEntity1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.3
 * JD-Core Version:    0.7.0.1
 */