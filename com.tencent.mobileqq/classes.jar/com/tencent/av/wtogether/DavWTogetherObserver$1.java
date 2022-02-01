package com.tencent.av.wtogether;

import android.app.Activity;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.av.wtogether.data.WatchTogetherInfo;
import com.tencent.av.wtogether.util.WTogetherUtil;
import com.tencent.qphone.base.util.QLog;

class DavWTogetherObserver$1
  implements Runnable
{
  DavWTogetherObserver$1(DavWTogetherObserver paramDavWTogetherObserver, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    DavWTogetherObserver.a(this.this$0).e(0L, this.a);
    AVActivity localAVActivity = DavWTogetherObserver.a(this.this$0).U();
    if ((!this.b) && (this.c) && (!localAVActivity.isFinishing()) && (WTogetherUtil.c()))
    {
      Object localObject = SessionMgr.a().b();
      localObject = ((WTogetherMng)this.this$0.b.c(17)).b((SessionInfo)localObject);
      if (!((WatchTogetherInfo)localObject).e)
      {
        ((WatchTogetherInfo)localObject).e = true;
        WTogetherUtil.a(localAVActivity, localAVActivity.getString(2131893760));
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("WTogether", 2, "showNetTip, have shown. 2");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.wtogether.DavWTogetherObserver.1
 * JD-Core Version:    0.7.0.1
 */