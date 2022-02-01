package com.tencent.mobileqq.activity.aio.rebuild;

import ahiu;
import ahkp;
import amxz;
import android.os.Handler;
import android.text.TextUtils;
import bcef;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import ocw;
import odq;

public class PublicAccountChatPie$9
  implements Runnable
{
  public PublicAccountChatPie$9(ahiu paramahiu) {}
  
  public void run()
  {
    Object localObject = null;
    amxz localamxz = (amxz)this.this$0.app.getManager(56);
    if (localamxz != null) {
      localObject = localamxz.b(this.this$0.sessionInfo.curFriendUin);
    }
    boolean bool;
    if (localObject == null)
    {
      bool = this.this$0.b();
      this.this$0.a();
      if ((bool) && (TextUtils.isEmpty(this.this$0.b)) && (localamxz != null))
      {
        localObject = localamxz.a(this.this$0.sessionInfo.curFriendUin);
        if ((localObject != null) && (!TextUtils.isEmpty(((AccountDetail)localObject).summary))) {
          this.this$0.b = ((AccountDetail)localObject).summary;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (ahiu.a(this.this$0)))
      {
        odq.a(this.this$0.app, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
        this.this$0.c = true;
        this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      }
      for (;;)
      {
        localObject = "0";
        if (bool) {
          localObject = "1";
        }
        long l = NetConnInfoCenter.getServerTime();
        if (QLog.isColorLevel()) {
          QLog.d("struct_log_tag", 2, "PublicAccountChatPie :CliOper|" + this.this$0.sessionInfo.curFriendUin + "|0X8005619|0X8005619" + 0 + "|" + 0 + "|" + Long.toString(l) + "|" + (String)localObject);
        }
        bcef.b(this.this$0.app, "CliOper", "", this.this$0.sessionInfo.curFriendUin, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject, "", "");
        return;
        if (!ahiu.b(this.this$0)) {
          this.this$0.jdField_a_of_type_Ocw.a(this.this$0.mActivity, this.this$0.app, this.this$0.app.getAccount(), this.this$0.sessionInfo.curFriendUin, new ahkp(this));
        }
      }
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.9
 * JD-Core Version:    0.7.0.1
 */