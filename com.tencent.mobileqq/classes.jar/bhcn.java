import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vas.qvip.QQVipMsgInfo;
import com.tencent.mobileqq.vas.qvip.fragment.QQVipFeedWedFragment;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bhcn
{
  public static Intent a(QQAppInterface paramQQAppInterface)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("qqvip_pubaccount_msg_list", a(paramQQAppInterface));
    return localIntent;
  }
  
  public static AppInterface a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof ToolAppRuntime))
      {
        localObject = ((AppRuntime)localObject).getAppRuntime("modular_web");
        if (!(localObject instanceof AppInterface)) {
          break label53;
        }
        return (AppInterface)localObject;
      }
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
    label53:
    return null;
  }
  
  public static ArrayList<QQVipMsgInfo> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(anhk.aX, 1008, 50);
    ArrayList localArrayList = new ArrayList();
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0))
    {
      int i = paramQQAppInterface.size() - 1;
      while (i >= 0)
      {
        Object localObject = (MessageRecord)paramQQAppInterface.get(i);
        if (anhk.aX.equals(((MessageRecord)localObject).frienduin))
        {
          if (((localObject instanceof MessageForArkApp)) || ((localObject instanceof MessageForPubAccount)) || ((localObject instanceof MessageForStructing)))
          {
            localObject = QQVipMsgInfo.parseMessageRecord((MessageRecord)localObject);
            if ((localObject != null) && (((QQVipMsgInfo)localObject).msgType != 0)) {
              localArrayList.add(localObject);
            }
          }
          if (localArrayList.size() == 4) {
            return localArrayList;
          }
        }
        i -= 1;
      }
    }
    return localArrayList;
  }
  
  public static void a(int paramInt1, QQVipMsgInfo paramQQVipMsgInfo, int paramInt2)
  {
    if (paramQQVipMsgInfo == null) {}
    String str;
    do
    {
      return;
      str = "";
      if (!TextUtils.isEmpty(paramQQVipMsgInfo.advId)) {
        str = paramQQVipMsgInfo.advId;
      }
    } while (TextUtils.isEmpty(str));
    aoqq.a(paramInt1, paramInt2, str);
  }
  
  public static void a(Context paramContext)
  {
    Intent localIntent = a((QQAppInterface)a());
    PublicFragmentActivityForTool.b((Activity)paramContext, localIntent, QQVipFeedWedFragment.class, 10000);
  }
  
  public static boolean a(Context paramContext)
  {
    Object localObject = (anrs)((QQAppInterface)a()).getManager(56);
    if (localObject != null)
    {
      localObject = ((anrs)localObject).b(anhk.aX);
      if (localObject != null) {
        return ((AccountDetail)localObject).isRecvPush;
      }
      c(paramContext);
    }
    return false;
  }
  
  public static void b(Context paramContext)
  {
    PublicFragmentActivityForTool.b(paramContext, a((QQAppInterface)a()), QQVipFeedWedFragment.class);
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (aqyd.c() != null)
    {
      bool1 = bool2;
      if (aqyd.c().a().booleanValue())
      {
        bool1 = bool2;
        if (a(paramContext)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static void c(Context paramContext)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)a();
    paramContext = new NewIntent(paramContext, oaz.class);
    paramContext.putExtra("cmd", "get_detail_info");
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.4.1,3,4680");
    try
    {
      localGetPublicAccountDetailInfoRequest.uin.set((int)Long.parseLong(anhk.aX));
      label66:
      paramContext.putExtra("data", localGetPublicAccountDetailInfoRequest.toByteArray());
      localGetPublicAccountDetailInfoRequest.version.set(1);
      paramContext.setObserver(new bhco(localQQAppInterface));
      localQQAppInterface.startServlet(paramContext);
      return;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcn
 * JD-Core Version:    0.7.0.1
 */