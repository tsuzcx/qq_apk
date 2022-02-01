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
    DavWTogetherObserver.a(this.this$0).e(0L, this.jdField_a_of_type_Int);
    AVActivity localAVActivity = DavWTogetherObserver.a(this.this$0).a();
    if ((!this.jdField_a_of_type_Boolean) && (this.b) && (!localAVActivity.isFinishing()) && (WTogetherUtil.b()))
    {
      Object localObject = SessionMgr.a().a();
      localObject = ((WTogetherMng)this.this$0.a.a(15)).b((SessionInfo)localObject);
      if (((WatchTogetherInfo)localObject).jdField_a_of_type_Boolean) {
        break label103;
      }
      ((WatchTogetherInfo)localObject).jdField_a_of_type_Boolean = true;
      WTogetherUtil.a(localAVActivity, localAVActivity.getString(2131695983));
    }
    label103:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("WTogether", 2, "showNetTip, have shown. 2");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.DavWTogetherObserver.1
 * JD-Core Version:    0.7.0.1
 */