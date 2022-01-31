import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;

public class aqub
  extends QIPCModule
{
  private static volatile aqub a;
  
  public aqub(String paramString)
  {
    super(paramString);
  }
  
  public static aqub a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aqub("QQGameIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle == null) || (!(paramBundle instanceof QQAppInterface))) {}
    while (!"findMessage".equals(paramString)) {
      return null;
    }
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
          Object localObject = (MessageRecord)paramBundle.get(i);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqub
 * JD-Core Version:    0.7.0.1
 */