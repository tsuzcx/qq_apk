package com.tencent.biz.videostory.widget.view;

import awgf;
import awgg;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import zbr;

public class MineWSPanel$3
  implements Runnable
{
  public MineWSPanel$3(zbr paramzbr, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (zbr.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    awgf localawgf = zbr.a(this.this$0).app.getEntityManagerFactory().createEntityManager();
    WSPersonalEntity localWSPersonalEntity = new WSPersonalEntity();
    localWSPersonalEntity.updateWeiShiFeedListEntity(zbr.a(this.this$0), this.a);
    if (localWSPersonalEntity.getStatus() == 1000) {
      localawgf.a(localWSPersonalEntity);
    }
    for (;;)
    {
      localawgf.a();
      return;
      localawgf.a(localWSPersonalEntity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.3
 * JD-Core Version:    0.7.0.1
 */