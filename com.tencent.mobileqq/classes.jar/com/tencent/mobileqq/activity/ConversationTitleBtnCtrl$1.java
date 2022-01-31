package com.tencent.mobileqq.activity;

import acos;
import android.app.Activity;
import axho;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tyj;

public class ConversationTitleBtnCtrl$1
  implements Runnable
{
  public ConversationTitleBtnCtrl$1(acos paramacos) {}
  
  public void run()
  {
    Object localObject = (axho)BaseApplicationImpl.getApplication().getRuntime().getManager(36);
    for (;;)
    {
      try
      {
        localObject = ((axho)localObject).a("140000");
        if (localObject == null) {
          return;
        }
        int i = ((BusinessInfoCheckUpdate.AppInfo)localObject).iNewFlag.get();
        if (i != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        QLog.e("ConversationTitleBtnCtrl", 2, "updateQQCircleRedFlag  updateRedDot" + localException.toString());
        boolean bool = false;
        continue;
        tyj.a("", 2, 1L, 3L);
        continue;
      }
      if (acos.a(this.this$0) != bool)
      {
        acos.a(this.this$0, bool);
        acos.b(this.this$0, true);
      }
      acos.a(this.this$0).runOnUiThread(new ConversationTitleBtnCtrl.1.1(this, bool));
      if (!acos.b(this.this$0)) {
        return;
      }
      if (!acos.a(this.this$0)) {
        continue;
      }
      tyj.a("", 2, 1L, 1L);
      acos.b(this.this$0, false);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.1
 * JD-Core Version:    0.7.0.1
 */