package com.tencent.mobileqq.activity.aio.rebuild;

import ahhp;
import android.support.v4.app.FragmentActivity;
import arhi;
import arib;
import aros;
import auyo;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class LimitChatPie$7
  implements Runnable
{
  public LimitChatPie$7(ahhp paramahhp, String paramString) {}
  
  public void run()
  {
    arhi localarhi = (arhi)this.this$0.app.getManager(264);
    if (localarhi == null) {
      QLog.e(this.this$0.tag, 2, "getSubThreadHandler  extendFriendManager Is null");
    }
    do
    {
      return;
      ahhp.a(this.this$0, localarhi.a(this.a, true));
      if (ahhp.a(this.this$0) == null)
      {
        auyo.a(this.this$0.app, this.a, 1, "", false);
        ahhp.a(this.this$0, localarhi.a(this.a, true));
      }
      if ((ahhp.a(this.this$0) != null) && (ahhp.a(this.this$0).isSignalBomb()) && (ahhp.a(this.this$0).showDistanceHLight))
      {
        ahhp.a(this.this$0).showDistanceHLight = false;
        localarhi.a(ahhp.a(this.this$0));
      }
      Object localObject = this.this$0.app.getMessageFacade().getAllMessages(this.this$0.sessionInfo.curFriendUin, this.this$0.sessionInfo.curType, null, 500);
      ahhp.a(this.this$0, (List)localObject);
      if (localObject != null) {
        ahhp.a(this.this$0, ((List)localObject).size());
      }
      if (ahhp.g(this.this$0) <= 0) {
        aros.a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), this.a, this.this$0.sessionInfo.curType);
      }
      if ((localObject != null) && (((List)localObject).size() > 0) && (!ahhp.a(this.this$0).enableQQCall))
      {
        QLog.d(this.this$0.tag, 2, "enableQQCall check");
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((MessageRecord)((Iterator)localObject).next()).senderuin.equals(ahhp.a(this.this$0).uin))
          {
            ahhp.a(this.this$0).enableQQCall = true;
            localarhi.a(ahhp.a(this.this$0));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.this$0.tag, 2, "mAllMsgCount " + ahhp.g(this.this$0));
      }
      this.this$0.refresh(65536);
      ThreadManager.getUIHandler().post(new LimitChatPie.7.1(this));
    } while (this.this$0.mActivity.isFinishing());
    arib.a(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.7
 * JD-Core Version:    0.7.0.1
 */