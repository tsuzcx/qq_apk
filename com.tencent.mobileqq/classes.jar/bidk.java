import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import cooperation.weiyun.WeiyunAIOUtils.4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bidk
{
  public static void a(Activity paramActivity)
  {
    String str = String.format("https://jump.weiyun.com?from=3092&aid=%s", new Object[] { "qq_an_wyshouxian" });
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    paramActivity.startActivityForResult(localIntent, 21);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List<ChatMessage> paramList, MqqHandler paramMqqHandler)
  {
    Object localObject2 = new ArrayList();
    Object localObject1 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ChatMessage localChatMessage = (ChatMessage)paramList.get(0);
    bicz.a(localChatMessage.frienduin, localChatMessage.senderuin, localChatMessage.istroop);
    int i = 0;
    if (i < paramList.size())
    {
      localChatMessage = (ChatMessage)paramList.get(i);
      if ((localChatMessage instanceof MessageForTroopFile)) {
        ((ArrayList)localObject2).add(localChatMessage);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localChatMessage instanceof MessageForFile)) {
          ((ArrayList)localObject1).add((MessageForFile)localChatMessage);
        } else if ((localChatMessage instanceof MessageForPic)) {
          localArrayList1.add((MessageForPic)localChatMessage);
        } else if ((localChatMessage instanceof MessageForShortVideo))
        {
          if (!(localChatMessage instanceof MessageForLightVideo)) {
            localArrayList2.add((MessageForShortVideo)localChatMessage);
          }
        }
        else if (akqa.b(localChatMessage)) {
          localArrayList3.add((StructMsgForImageShare)((MessageForStructing)localChatMessage).structingMsg);
        }
      }
    }
    if (((ArrayList)localObject2).size() > 0)
    {
      paramList = (ChatMessage)((ArrayList)localObject2).get(0);
      if (TroopFileTransferManager.a(paramQQAppInterface, Long.parseLong(paramList.frienduin)) == null) {
        return false;
      }
      paramList = bakx.a(paramQQAppInterface, (MessageForTroopFile)paramList);
      if ((paramList == null) || (paramList.e == null)) {
        return false;
      }
      bakx.a(paramActivity, paramQQAppInterface, (List)localObject2);
    }
    boolean bool = false;
    if (((ArrayList)localObject1).size() > 0)
    {
      paramActivity = new ArrayList();
      paramList = ((ArrayList)localObject1).iterator();
      label320:
      int j;
      for (i = 0; paramList.hasNext(); i = j)
      {
        localObject1 = (MessageForFile)paramList.next();
        localObject2 = apug.a(paramQQAppInterface, (MessageForFile)localObject1);
        if ((((FileManagerEntity)localObject2).cloudType == 0) || (((FileManagerEntity)localObject2).status == 16)) {
          break label320;
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (aptd.a((FileManagerEntity)localObject2).a(false)) {
            j = 1;
          }
        }
        paramActivity.add(localObject1);
      }
      if (paramActivity.size() == 0)
      {
        aptx.a(2131692669);
        return false;
      }
      if (i != 0) {
        aptt.a(BaseActivity.sTopActivity, 2131692673, 2131692678, new bidl(paramActivity, paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt));
      }
    }
    while (bool)
    {
      bcql.a(paramQQAppInterface.getApp(), 2131692830, 0).b(paramInt);
      return true;
      paramActivity = paramActivity.iterator();
      for (bool = false; paramActivity.hasNext(); bool = apug.a(paramQQAppInterface, (MessageForFile)paramActivity.next(), BaseActivity.sTopActivity, true)) {}
      bool |= a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt);
      continue;
      bool = a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt);
    }
    bcql.a(paramQQAppInterface.getApp(), 2131692881, 0).b(paramInt);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, MqqHandler paramMqqHandler)
  {
    axqy.b(paramQQAppInterface, "CliOper", "", "", "0X80067F8", "0X80067F8", 0, 0, "", "", "", "");
    if (!bbfj.d(paramActivity))
    {
      bcql.a(paramQQAppInterface.getApp(), 2131692321, 0).b(paramInt);
      return false;
    }
    List localList = asua.a().a();
    if (localList.size() == 0)
    {
      bcql.a(paramQQAppInterface.getApp(), 2131698475, 0).b(paramInt);
      return false;
    }
    if (localList.size() == 1) {
      return b(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
    }
    return a(paramQQAppInterface, paramActivity, paramInt, localList, paramMqqHandler);
  }
  
  static boolean a(QQAppInterface paramQQAppInterface, ArrayList<MessageForPic> paramArrayList, ArrayList<MessageForShortVideo> paramArrayList1, ArrayList<StructMsgForImageShare> paramArrayList2, MqqHandler paramMqqHandler, int paramInt)
  {
    if (((paramArrayList != null) && (paramArrayList.size() > 0)) || ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) || ((paramArrayList2 != null) && (paramArrayList2.size() > 0)))
    {
      ArrayList localArrayList = new ArrayList();
      if ((paramArrayList2 != null) && (paramArrayList2.size() > 0))
      {
        paramArrayList2 = paramArrayList2.iterator();
        label58:
        if (paramArrayList2.hasNext())
        {
          Iterator localIterator = ((StructMsgForImageShare)paramArrayList2.next()).mStructMsgItemLists.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label58;
            }
            Object localObject1 = (axup)localIterator.next();
            if (!axuq.class.isInstance(localObject1)) {
              break;
            }
            localObject1 = ((axuq)localObject1).a.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (axup)((Iterator)localObject1).next();
              if (axwv.class.isInstance(localObject2))
              {
                localObject2 = (axwv)localObject2;
                if ((!a(((axwv)localObject2).a)) && (!aezl.a(((axwv)localObject2).a))) {
                  localArrayList.add(((axwv)localObject2).a);
                }
              }
            }
          }
        }
      }
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramArrayList2 = (MessageForPic)paramArrayList.next();
          if ((!a(paramArrayList2)) && (!aezl.a(paramArrayList2))) {
            localArrayList.add(paramArrayList2);
          }
        }
      }
      if ((localArrayList.size() == 0) && ((paramArrayList1 == null) || (paramArrayList1.size() == 0))) {
        return false;
      }
      paramQQAppInterface.a().a().a(localArrayList, paramArrayList1, new bido(paramMqqHandler, paramQQAppInterface.getApp(), paramQQAppInterface, paramInt));
      return true;
    }
    return false;
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    return (ajyi.a(paramChatMessage)) || (ajwb.a(paramChatMessage));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List<ChatMessage> paramList, MqqHandler paramMqqHandler)
  {
    paramList = (ChatMessage)paramList.get(0);
    bicz.a(paramList.frienduin, paramList.senderuin, paramList.istroop);
    if ((paramList instanceof MessageForTroopFile)) {
      bakx.a(paramActivity, paramQQAppInterface, paramList);
    }
    for (;;)
    {
      return true;
      if ((paramList instanceof MessageForFile))
      {
        paramActivity = apug.a(paramQQAppInterface, (MessageForFile)paramList);
        if (paramActivity.cloudType == 0)
        {
          aptx.a(2131692669);
          return false;
        }
        if (paramActivity.status == 16)
        {
          aptx.a(2131692857);
          return false;
        }
        if (aptd.a((MessageForFile)paramList).a(false))
        {
          if (bcwb.a(BaseActivity.sTopActivity, 5, new bidm(paramQQAppInterface, paramList))) {
            aptt.a(BaseActivity.sTopActivity, 2131692673, 2131692676, new bidn(paramQQAppInterface, paramList));
          }
        }
        else {
          apug.a(paramQQAppInterface, paramList, BaseActivity.sTopActivity);
        }
      }
      else if (((paramList instanceof MessageForPic)) || ((paramList instanceof MessageForShortVideo)))
      {
        if (a(paramList))
        {
          aptx.a(2131692669);
          return false;
        }
        if (((paramList instanceof MessageForPic)) && (aezl.a((MessageForPic)paramList)))
        {
          aptx.a(2131692669);
          return false;
        }
        paramQQAppInterface.a().a().a(paramList, new bido(paramMqqHandler, paramActivity, paramQQAppInterface, paramInt));
        if (Looper.myLooper() != Looper.getMainLooper()) {
          ThreadManager.getUIHandler().post(new WeiyunAIOUtils.4(paramQQAppInterface, paramInt));
        } else {
          bcql.a(paramQQAppInterface.getApp(), 2131692830, 0).b(paramInt);
        }
      }
      else
      {
        if (!akqa.b(paramList)) {
          break;
        }
        paramList = (StructMsgForImageShare)((MessageForStructing)paramList).structingMsg;
        paramActivity = new ArrayList();
        paramList = paramList.mStructMsgItemLists.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (axup)paramList.next();
          if (axuq.class.isInstance(localObject1))
          {
            localObject1 = ((axuq)localObject1).a.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (axup)((Iterator)localObject1).next();
              if (axwv.class.isInstance(localObject2))
              {
                localObject2 = (axwv)localObject2;
                if (!a(((axwv)localObject2).a)) {
                  paramActivity.add(((axwv)localObject2).a);
                }
              }
            }
          }
        }
        if (paramActivity.size() > 0)
        {
          a(paramQQAppInterface, paramActivity, null, null, paramMqqHandler, paramInt);
          bcql.a(paramQQAppInterface.getApp(), 2131692830, 0).b(paramInt);
        }
        else
        {
          bcql.a(paramQQAppInterface.getApp(), 2131692881, 0).b(paramInt);
        }
      }
    }
    bcql.a(paramQQAppInterface.getApp(), 2131692881, 0).b(paramInt);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidk
 * JD-Core Version:    0.7.0.1
 */