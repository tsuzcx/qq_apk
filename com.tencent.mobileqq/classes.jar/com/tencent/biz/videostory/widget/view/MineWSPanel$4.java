package com.tencent.biz.videostory.widget.view;

import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import android.text.TextUtils;
import aukp;
import aukq;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import xij;

public class MineWSPanel$4
  implements Runnable
{
  public MineWSPanel$4(xij paramxij) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(xij.a(this.this$0))) {
      QLog.i("MineWSPanel", 2, "mUin is invalid");
    }
    do
    {
      return;
      if (xij.a(this.this$0) == null)
      {
        QLog.i("MineWSPanel", 2, "mBaseActivity is null");
        return;
      }
      Object localObject = xij.a(this.this$0).app.getEntityManagerFactory().createEntityManager();
      WSPersonalEntity localWSPersonalEntity = (WSPersonalEntity)((aukp)localObject).a(WSPersonalEntity.class, xij.a(this.this$0));
      ((aukp)localObject).a();
      if (localWSPersonalEntity == null) {
        break;
      }
      localObject = new WEISHI.stGetPersonalPageRsp();
      try
      {
        ((WEISHI.stGetPersonalPageRsp)localObject).mergeFrom(localWSPersonalEntity.weiShiPersonalRsp);
        if ((localObject != null) && (xij.a(this.this$0) != null)) {
          xij.a(this.this$0).runOnUiThread(new MineWSPanel.4.1(this, (WEISHI.stGetPersonalPageRsp)localObject));
        }
        this.this$0.a();
        return;
      }
      catch (Exception localException) {}
    } while (!QLog.isColorLevel());
    QLog.e("MineWSPanel", 2, "getWeiShiPersonalDataFromDB, ex= " + localException.getMessage());
    return;
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.MineWSPanel.4
 * JD-Core Version:    0.7.0.1
 */