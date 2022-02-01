package com.tencent.biz.videostory.widget.view;

import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import android.text.TextUtils;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class MineWSPanel$4
  implements Runnable
{
  MineWSPanel$4(MineWSPanel paramMineWSPanel) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(MineWSPanel.c(this.this$0)))
    {
      QLog.i("MineWSPanel", 2, "mUin is invalid");
      return;
    }
    if (MineWSPanel.a(this.this$0) == null)
    {
      QLog.i("MineWSPanel", 2, "mBaseActivity is null");
      return;
    }
    Object localObject = MineWSPanel.a(this.this$0).getAppRuntime().getEntityManagerFactory().createEntityManager();
    WSPersonalEntity localWSPersonalEntity = (WSPersonalEntity)((EntityManager)localObject).find(WSPersonalEntity.class, MineWSPanel.c(this.this$0));
    ((EntityManager)localObject).close();
    if (localWSPersonalEntity != null)
    {
      localObject = new WEISHI.stGetPersonalPageRsp();
      try
      {
        ((WEISHI.stGetPersonalPageRsp)localObject).mergeFrom(localWSPersonalEntity.weiShiPersonalRsp);
        if (MineWSPanel.a(this.this$0) != null) {
          MineWSPanel.a(this.this$0).runOnUiThread(new MineWSPanel.4.1(this, (WEISHI.stGetPersonalPageRsp)localObject));
        }
        this.this$0.c();
        return;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getWeiShiPersonalDataFromDB, ex= ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("MineWSPanel", 2, ((StringBuilder)localObject).toString());
    }
    else
    {
      this.this$0.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.4
 * JD-Core Version:    0.7.0.1
 */