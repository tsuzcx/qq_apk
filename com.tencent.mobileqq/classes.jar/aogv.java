import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aogv
  extends MqqHandler
{
  WeakReference<VideoBroadcastReceiver> a;
  
  public aogv(Looper paramLooper, VideoBroadcastReceiver paramVideoBroadcastReceiver)
  {
    super(paramLooper);
    this.a = new WeakReference(paramVideoBroadcastReceiver);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    Object localObject1;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        return;
        localObject1 = (VideoBroadcastReceiver)this.a.get();
      } while ((localObject1 == null) || (VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1) == null));
      localQQAppInterface = (QQAppInterface)VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1).get();
    } while (localQQAppInterface == null);
    Object localObject3;
    int i;
    Object localObject5;
    Object localObject2;
    Object localObject4;
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      localObject3 = (Object[])paramMessage.obj;
      i = ((Integer)localObject3[0]).intValue();
      localObject5 = (String)localObject3[1];
      localObject1 = (String)localObject3[2];
      localObject2 = (String)localObject3[3];
      paramMessage = (Context)localObject3[4];
      localObject3 = (String)localObject3[5];
      localObject4 = new SessionInfo();
      ((SessionInfo)localObject4).curType = i;
      ((SessionInfo)localObject4).curFriendNick = ((String)localObject5);
      if (i == 1006)
      {
        ((SessionInfo)localObject4).curFriendUin = ((String)localObject1);
        localObject1 = ((awyz)localQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
        if (localObject1 != null) {
          ((SessionInfo)localObject4).phoneNum = (((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo);
        }
      }
      for (;;)
      {
        admh.b(localQQAppInterface, paramMessage, (SessionInfo)localObject4, (String)localObject3);
        return;
        if (i == 1000)
        {
          localObject5 = ((TroopManager)localQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b((String)localObject1);
          if (localObject5 == null)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e(VideoBroadcastReceiver.a, 2, "findTroopInfo fail ,uin : " + (String)localObject1);
            return;
          }
          ((SessionInfo)localObject4).curFriendUin = ((String)localObject2);
          ((SessionInfo)localObject4).troopUin = ((TroopInfo)localObject5).troopcode;
          ((SessionInfo)localObject4).realTroopUin = ((TroopInfo)localObject5).troopuin;
          continue;
        }
        if (i == 1004)
        {
          ((SessionInfo)localObject4).curFriendUin = ((String)localObject2);
          ((SessionInfo)localObject4).troopUin = ((String)localObject1);
        }
        else
        {
          ((SessionInfo)localObject4).curFriendUin = ((String)localObject2);
        }
      }
    case 1: 
      localObject1 = (Object[])paramMessage.obj;
      if (!(localObject1[0] instanceof QQCustomDialog)) {
        break;
      }
    }
    for (paramMessage = (QQCustomDialog)localObject1[0];; paramMessage = null)
    {
      i = ((Integer)localObject1[1]).intValue();
      boolean bool2 = ((Boolean)localObject1[2]).booleanValue();
      localObject2 = (String)localObject1[3];
      localObject3 = (String)localObject1[4];
      boolean bool3 = ((Boolean)localObject1[5]).booleanValue();
      if ((paramMessage == null) || (!paramMessage.isShowing())) {
        break;
      }
      paramMessage.dismiss();
      if (!bool2) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        VideoMsgTools.a(localQQAppInterface, i, 10, bool1, (String)localObject2, (String)localObject3, bool3, null, true, new Object[0]);
        msa.c(localQQAppInterface.isBackgroundPause, bool2);
        return;
      }
      localObject2 = (Object[])paramMessage.obj;
      if ((localObject2[0] instanceof QQCustomDialog)) {}
      for (paramMessage = (QQCustomDialog)localObject2[0];; paramMessage = null)
      {
        i = ((Integer)localObject2[1]).intValue();
        int j = ((Integer)localObject2[2]).intValue();
        localObject3 = (String)localObject2[3];
        localObject4 = (String)localObject2[4];
        localObject5 = (String)localObject2[5];
        localObject2 = (String)localObject2[6];
        if ((paramMessage == null) || (!paramMessage.isShowing())) {
          break;
        }
        paramMessage.dismiss();
        if (i == 3000)
        {
          VideoMsgTools.a(localQQAppInterface, i, j, false, (String)localObject3, (String)localObject4, false, null, false, new Object[0]);
          VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1, 8, i, (String)localObject3, (String)localObject5, (String)localObject2);
        }
        msa.e(localQQAppInterface.isBackgroundPause);
        return;
        paramMessage = (QQCustomDialog)((Object[])(Object[])paramMessage.obj)[0];
        if (!paramMessage.isShowing()) {
          break;
        }
        paramMessage.dismiss();
        return;
        paramMessage = (Intent)((Object[])(Object[])paramMessage.obj)[0];
        localQQAppInterface.getApp().startActivity(paramMessage);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogv
 * JD-Core Version:    0.7.0.1
 */