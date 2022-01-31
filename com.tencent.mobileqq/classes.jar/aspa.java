import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class aspa
  extends QIPCModule
{
  private static volatile aspa a;
  
  public aspa(String paramString)
  {
    super(paramString);
  }
  
  public static aspa a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aspa("QQGameIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle == null) || (!(paramBundle instanceof QQAppInterface))) {}
    do
    {
      return null;
      Object localObject;
      if ("findMessage".equals(paramString)) {
        for (;;)
        {
          int i;
          try
          {
            paramBundle = ((QQAppInterface)paramBundle).a().a("2747277822", 1008, 10);
            if ((paramBundle == null) || (paramBundle.size() <= 0)) {
              break;
            }
            paramString = new ArrayList();
            i = paramBundle.size() - 1;
            if (i >= 0)
            {
              localObject = (MessageRecord)paramBundle.get(i);
              if (("2747277822".equals(((MessageRecord)localObject).frienduin)) && (((localObject instanceof MessageForArkApp)) || ((localObject instanceof MessageForPubAccount)) || ((localObject instanceof MessageForStructing))))
              {
                localObject = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject);
                if (localObject != null) {
                  paramString.add(localObject);
                }
              }
              if (paramString.size() != 3) {}
            }
            else
            {
              paramBundle = new Bundle();
              paramBundle.putSerializable("key_get_msg", paramString);
              callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
              return null;
            }
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
            return null;
          }
          i -= 1;
        }
      }
      if ("getGameMsg".equals(paramString))
      {
        paramBundle = (asmu)paramBundle.getManager(358);
        localObject = paramBundle.a();
        paramString = new ArrayList();
        if (localObject != null) {
          paramString.addAll(paramBundle.a());
        }
        paramBundle = new Bundle();
        paramBundle.putSerializable("key_get_game_msg", paramString);
        callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
        return null;
      }
      if ("doOnResume".equals(paramString))
      {
        ((asmu)paramBundle.getManager(358)).a(0);
        ((QQAppInterface)paramBundle).a().a("2747277822", 1008, true, true);
        return null;
      }
      if ("doOnDestory".equals(paramString))
      {
        ((asmu)paramBundle.getManager(358)).a(0);
        return null;
      }
    } while (!"getGameMsgUrl".equals(paramString));
    paramString = (asmu)paramBundle.getManager(358);
    paramBundle = new Bundle();
    paramBundle.putString("key_get_msg_list_url", paramString.a());
    callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aspa
 * JD-Core Version:    0.7.0.1
 */