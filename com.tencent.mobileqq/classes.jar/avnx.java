import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameIPCModule.1;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class avnx
  extends QIPCModule
{
  private static volatile avnx a;
  
  public avnx(String paramString)
  {
    super(paramString);
  }
  
  public static avnx a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new avnx("QQGameIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject2 == null) || (!(localObject2 instanceof QQAppInterface))) {}
    do
    {
      int i;
      Object localObject1;
      do
      {
        return null;
        if ("findMessage".equals(paramString)) {
          for (;;)
          {
            try
            {
              paramBundle = ((QQAppInterface)localObject2).a().a("2747277822", 1008, 10);
              if ((paramBundle == null) || (paramBundle.size() <= 0)) {
                break;
              }
              paramString = new ArrayList();
              i = paramBundle.size() - 1;
              if (i >= 0)
              {
                localObject1 = (MessageRecord)paramBundle.get(i);
                if (("2747277822".equals(((MessageRecord)localObject1).frienduin)) && (((localObject1 instanceof MessageForArkApp)) || ((localObject1 instanceof MessageForPubAccount)) || ((localObject1 instanceof MessageForStructing))))
                {
                  localObject1 = QQGameMsgInfo.parseMessageRecord((MessageRecord)localObject1);
                  if (localObject1 != null) {
                    paramString.add(localObject1);
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
          paramString = (avld)((AppRuntime)localObject2).getManager(358);
          localObject1 = paramString.a();
          paramBundle = new ArrayList();
          if (localObject1 != null) {
            paramBundle.addAll(paramString.a());
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putSerializable("key_get_game_msg", paramBundle);
          ((Bundle)localObject1).putInt("key_get_game_view_type", paramString.d());
          ((Bundle)localObject1).putBoolean("key_get_game_show_on_list", paramString.b);
          ((Bundle)localObject1).putBoolean("key_get_game_show_req_msg_unread", paramString.c);
          ((Bundle)localObject1).putBoolean("key_get_game_gray_user", paramString.c());
          callbackResult(paramInt, EIPCResult.createSuccessResult((Bundle)localObject1));
          return null;
        }
        if ("doOnResume".equals(paramString))
        {
          ((avld)((AppRuntime)localObject2).getManager(358)).a(0);
          ((QQAppInterface)localObject2).a().a("2747277822", 1008, true, true);
          return null;
        }
        if ("doOnDestory".equals(paramString))
        {
          ((avld)((AppRuntime)localObject2).getManager(358)).a(0);
          return null;
        }
        if ("getGameMsgUrl".equals(paramString))
        {
          paramString = (avld)((AppRuntime)localObject2).getManager(358);
          paramBundle = new Bundle();
          paramBundle.putString("key_get_msg_list_url", paramString.b());
          callbackResult(paramInt, EIPCResult.createSuccessResult(paramBundle));
          return null;
        }
        if (!"saveGalleryDataToMsg".equals(paramString)) {
          break;
        }
        paramString = paramBundle.getString("game_source_pic_txt");
        localObject1 = paramBundle.getString("game_source_pic_url");
        paramInt = paramBundle.getInt("game_source_type_pic", 0);
        i = paramBundle.getInt("game_source_subtype_pic", 0);
        long l = paramBundle.getLong("uniseq");
        int j = paramBundle.getInt("is_troop");
        paramBundle = paramBundle.getString("friend_uin");
        localObject2 = (QQAppInterface)localObject2;
        paramBundle = ((QQAppInterface)localObject2).a().b(paramBundle, j, l);
      } while (paramBundle == null);
      avlv.a("game_source_pic_txt", paramString, paramBundle);
      avlv.a("game_source_pic_url", (String)localObject1, paramBundle);
      avlv.a("game_source_type_pic", paramInt + "", paramBundle);
      avlv.a("game_source_subtype_pic", i + "", paramBundle);
      ThreadManager.excute(new QQGameIPCModule.1(this, (QQAppInterface)localObject2, paramBundle), 32, null, false);
      return null;
      if ("clearUnreadMsg".equals(paramString))
      {
        ((QQAppInterface)localObject2).a().a("2747277822", 1008, false);
        return null;
      }
      if ("openSessionPage".equals(paramString))
      {
        avlf.a(((avld)((AppRuntime)localObject2).getManager(358)).b(), ((AppRuntime)localObject2).getApplication(), null);
        return null;
      }
    } while (!"action_set_clean_req_time".equals(paramString));
    avlf.a(((AppRuntime)localObject2).getAccount());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avnx
 * JD-Core Version:    0.7.0.1
 */