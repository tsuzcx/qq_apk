import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VideoBroadcastReceiver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class aoku
  extends MqqHandler
{
  WeakReference<VideoBroadcastReceiver> a;
  
  public aoku(Looper paramLooper, VideoBroadcastReceiver paramVideoBroadcastReceiver)
  {
    super(paramLooper);
    this.a = new WeakReference(paramVideoBroadcastReceiver);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.a == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      Object localObject1;
      Object localObject2;
      int i;
      Object localObject4;
      String str;
      Object localObject3;
      int j;
      do
      {
        boolean bool2;
        boolean bool3;
        do
        {
          do
          {
            do
            {
              return;
              localObject1 = (VideoBroadcastReceiver)this.a.get();
            } while ((localObject1 == null) || (VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1) == null));
            localQQAppInterface = (QQAppInterface)VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1).get();
          } while (localQQAppInterface == null);
          switch (paramMessage.what)
          {
          default: 
            return;
          case 0: 
            localObject2 = (Object[])paramMessage.obj;
            i = ((Integer)localObject2[0]).intValue();
            localObject4 = (String)localObject2[1];
            localObject1 = (String)localObject2[2];
            str = (String)localObject2[3];
            paramMessage = (Context)localObject2[4];
            localObject2 = (String)localObject2[5];
            localObject3 = new SessionInfo();
            ((SessionInfo)localObject3).jdField_a_of_type_Int = i;
            ((SessionInfo)localObject3).d = ((String)localObject4);
            if (i == 1006)
            {
              ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject1);
              localObject1 = ((axfr)localQQAppInterface.getManager(11)).a();
              if (localObject1 != null) {
                ((SessionInfo)localObject3).e = (((RespondQueryQQBindingStat)localObject1).nationCode + ((RespondQueryQQBindingStat)localObject1).mobileNo);
              }
            }
            for (;;)
            {
              aean.b(localQQAppInterface, paramMessage, (SessionInfo)localObject3, (String)localObject2);
              return;
              if (i == 1000)
              {
                localObject4 = ((TroopManager)localQQAppInterface.getManager(52)).b((String)localObject1);
                if (localObject4 == null)
                {
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.e(VideoBroadcastReceiver.jdField_a_of_type_JavaLangString, 2, "findTroopInfo fail ,uin : " + (String)localObject1);
                  return;
                }
                ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = str;
                ((SessionInfo)localObject3).b = ((TroopInfo)localObject4).troopcode;
                ((SessionInfo)localObject3).c = ((TroopInfo)localObject4).troopuin;
                continue;
              }
              if (i == 1004)
              {
                ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = str;
                ((SessionInfo)localObject3).b = ((String)localObject1);
              }
              else
              {
                ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString = str;
              }
            }
          case 1: 
            paramMessage = (Object[])paramMessage.obj;
            localObject1 = (bhpc)paramMessage[0];
            i = ((Integer)paramMessage[1]).intValue();
            bool2 = ((Boolean)paramMessage[2]).booleanValue();
            str = (String)paramMessage[3];
            localObject2 = (String)paramMessage[4];
            bool3 = ((Boolean)paramMessage[5]).booleanValue();
          }
        } while (!((bhpc)localObject1).isShowing());
        ((bhpc)localObject1).dismiss();
        if (!bool2) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          VideoMsgTools.a(localQQAppInterface, i, 10, bool1, str, (String)localObject2, bool3, null, true, new Object[0]);
          mru.c(localQQAppInterface.isBackgroundPause, bool2);
          return;
        }
        localObject4 = (Object[])paramMessage.obj;
        paramMessage = (bhpc)localObject4[0];
        i = ((Integer)localObject4[1]).intValue();
        j = ((Integer)localObject4[2]).intValue();
        str = (String)localObject4[3];
        localObject2 = (String)localObject4[4];
        localObject3 = (String)localObject4[5];
        localObject4 = (String)localObject4[6];
      } while (!paramMessage.isShowing());
      paramMessage.dismiss();
      if (i == 3000)
      {
        VideoMsgTools.a(localQQAppInterface, i, j, false, str, (String)localObject2, false, null, false, new Object[0]);
        VideoBroadcastReceiver.a((VideoBroadcastReceiver)localObject1, 8, i, str, (String)localObject3, (String)localObject4);
      }
      mru.e(localQQAppInterface.isBackgroundPause);
      return;
      paramMessage = (bhpc)((Object[])(Object[])paramMessage.obj)[0];
    } while (!paramMessage.isShowing());
    paramMessage.dismiss();
    return;
    paramMessage = (Intent)((Object[])(Object[])paramMessage.obj)[0];
    localQQAppInterface.getApp().startActivity(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoku
 * JD-Core Version:    0.7.0.1
 */