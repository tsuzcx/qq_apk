package com.tencent.biz.videostory.widget.view;

import WEISHI_USER_GROWTH.WEISHI.stGetPersonalPageRsp;
import android.text.TextUtils;
import atmp;
import atmq;
import com.tencent.biz.videostory.db.WSPersonalEntity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import wzm;

public class MineWSPanel$4
  implements Runnable
{
  public MineWSPanel$4(wzm paramwzm) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(wzm.a(this.this$0))) {
      QLog.i("MineWSPanel", 2, "mUin is invalid");
    }
    do
    {
      return;
      if (wzm.a(this.this$0) == null)
      {
        QLog.i("MineWSPanel", 2, "mBaseActivity is null");
        return;
      }
      Object localObject = wzm.a(this.this$0).app.getEntityManagerFactory().createEntityManager();
      WSPersonalEntity localWSPersonalEntity = (WSPersonalEntity)((atmp)localObject).a(WSPersonalEntity.class, wzm.a(this.this$0));
      ((atmp)localObject).a();
      if (localWSPersonalEntity == null) {
        break;
      }
      localObject = new WEISHI.stGetPersonalPageRsp();
      try
      {
        ((WEISHI.stGetPersonalPageRsp)localObject).mergeFrom(localWSPersonalEntity.weiShiPersonalRsp);
        if ((localObject != null) && (wzm.a(this.this$0) != null)) {
          wzm.a(this.this$0).runOnUiThread(new MineWSPanel.4.1(this, (WEISHI.stGetPersonalPageRsp)localObject));
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