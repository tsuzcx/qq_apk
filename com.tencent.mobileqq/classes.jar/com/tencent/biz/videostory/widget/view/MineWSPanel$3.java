package com.tencent.biz.videostory.widget.view;

import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class MineWSPanel$3
  implements Runnable
{
  MineWSPanel$3(MineWSPanel paramMineWSPanel, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (MineWSPanel.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    EntityManager localEntityManager = MineWSPanel.a(this.this$0).getAppRuntime().getEntityManagerFactory().createEntityManager();
    WSPersonalEntity localWSPersonalEntity2 = (WSPersonalEntity)localEntityManager.find(WSPersonalEntity.class, MineWSPanel.c(this.this$0));
    WSPersonalEntity localWSPersonalEntity1 = localWSPersonalEntity2;
    if (localWSPersonalEntity2 == null) {
      localWSPersonalEntity1 = new WSPersonalEntity();
    }
    localWSPersonalEntity1.updateWeiShiFeedListEntity(MineWSPanel.c(this.this$0), this.a);
    if (localWSPersonalEntity1.getStatus() == 1000) {
      localEntityManager.persist(localWSPersonalEntity1);
    } else {
      localEntityManager.update(localWSPersonalEntity1);
    }
    localEntityManager.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.3
 * JD-Core Version:    0.7.0.1
 */