package com.tencent.mobileqq.activity.aio.rebuild;

import aido;
import aifj;
import android.os.Handler;
import android.text.TextUtils;
import aoan;
import bdla;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import okn;
import olh;

public class PublicAccountChatPie$9
  implements Runnable
{
  public PublicAccountChatPie$9(aido paramaido) {}
  
  public void run()
  {
    Object localObject = null;
    aoan localaoan = (aoan)this.this$0.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (localaoan != null) {
      localObject = localaoan.b(this.this$0.sessionInfo.curFriendUin);
    }
    boolean bool;
    if (localObject == null)
    {
      bool = this.this$0.b();
      this.this$0.a();
      if ((bool) && (TextUtils.isEmpty(this.this$0.b)) && (localaoan != null))
      {
        localObject = localaoan.a(this.this$0.sessionInfo.curFriendUin);
        if ((localObject != null) && (!TextUtils.isEmpty(((AccountDetail)localObject).summary))) {
          this.this$0.b = ((AccountDetail)localObject).summary;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (aido.a(this.this$0)))
      {
        olh.a(this.this$0.app, "CliOper", "", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "", false);
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
        bdla.b(this.this$0.app, "CliOper", "", this.this$0.sessionInfo.curFriendUin, "0X8005619", "0X8005619", 0, 0, Long.toString(l), (String)localObject, "", "");
        return;
        if (!aido.b(this.this$0)) {
          this.this$0.jdField_a_of_type_Okn.a(this.this$0.mActivity, this.this$0.app, this.this$0.app.getAccount(), this.this$0.sessionInfo.curFriendUin, new aifj(this));
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