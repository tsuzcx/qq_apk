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
import com.tencent.mobileqq.widget.QQToast;
import cooperation.weiyun.WeiyunAIOUtils.4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class bkfg
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
    bkev.a(localChatMessage.frienduin, localChatMessage.senderuin, localChatMessage.istroop);
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
        else if (amgm.b(localChatMessage)) {
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
      paramList = bcjk.a(paramQQAppInterface, (MessageForTroopFile)paramList);
      if ((paramList == null) || (paramList.e == null)) {
        return false;
      }
      bcjk.a(paramActivity, paramQQAppInterface, (List)localObject2);
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
        localObject2 = arni.a(paramQQAppInterface, (MessageForFile)localObject1);
        if ((((FileManagerEntity)localObject2).cloudType == 0) || (((FileManagerEntity)localObject2).status == 16)) {
          break label320;
        }
        j = i;
        if (i == 0)
        {
          j = i;
          if (armf.a((FileManagerEntity)localObject2).a(false)) {
            j = 1;
          }
        }
        paramActivity.add(localObject1);
      }
      if (paramActivity.size() == 0)
      {
        armz.a(2131692748);
        return false;
      }
      if (i != 0) {
        armv.a(BaseActivity.sTopActivity, 2131692752, 2131692757, new bkfh(paramActivity, paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt));
      }
    }
    while (bool)
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131692912, 0).b(paramInt);
      return true;
      paramActivity = paramActivity.iterator();
      for (bool = false; paramActivity.hasNext(); bool = arni.a(paramQQAppInterface, (MessageForFile)paramActivity.next(), BaseActivity.sTopActivity, true)) {}
      bool |= a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt);
      continue;
      bool = a(paramQQAppInterface, localArrayList1, localArrayList2, localArrayList3, paramMqqHandler, paramInt);
    }
    QQToast.a(paramQQAppInterface.getApp(), 2131692963, 0).b(paramInt);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, MqqHandler paramMqqHandler)
  {
    azmj.b(paramQQAppInterface, "CliOper", "", "", "0X80067F8", "0X80067F8", 0, 0, "", "", "", "");
    if (!bdee.d(paramActivity))
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131692397, 0).b(paramInt);
      return false;
    }
    List localList = aukx.a().a();
    if (localList.size() == 0)
    {
      QQToast.a(paramQQAppInterface.getApp(), 2131698770, 0).b(paramInt);
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
            Object localObject1 = (azqj)localIterator.next();
            if (!azqk.class.isInstance(localObject1)) {
              break;
            }
            localObject1 = ((azqk)localObject1).a.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (azqj)((Iterator)localObject1).next();
              if (azsp.class.isInstance(localObject2))
              {
                localObject2 = (azsp)localObject2;
                if ((!a(((azsp)localObject2).a)) && (!agwq.a(((azsp)localObject2).a))) {
                  localArrayList.add(((azsp)localObject2).a);
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
          if ((!a(paramArrayList2)) && (!agwq.a(paramArrayList2))) {
            localArrayList.add(paramArrayList2);
          }
        }
      }
      if ((localArrayList.size() == 0) && ((paramArrayList1 == null) || (paramArrayList1.size() == 0))) {
        return false;
      }
      paramQQAppInterface.a().a().a(localArrayList, paramArrayList1, new bkfk(paramMqqHandler, paramQQAppInterface.getApp(), paramQQAppInterface, paramInt));
      return true;
    }
    return false;
  }
  
  private static boolean a(ChatMessage paramChatMessage)
  {
    return (alpw.a(paramChatMessage)) || (alnp.a(paramChatMessage));
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt, List<ChatMessage> paramList, MqqHandler paramMqqHandler)
  {
    paramList = (ChatMessage)paramList.get(0);
    bkev.a(paramList.frienduin, paramList.senderuin, paramList.istroop);
    if ((paramList instanceof MessageForTroopFile)) {
      bcjk.b(paramActivity, paramQQAppInterface, paramList);
    }
    for (;;)
    {
      return true;
      if ((paramList instanceof MessageForFile))
      {
        paramActivity = arni.a(paramQQAppInterface, (MessageForFile)paramList);
        if (paramActivity.cloudType == 0)
        {
          armz.a(2131692748);
          return false;
        }
        if (paramActivity.status == 16)
        {
          armz.a(2131692939);
          return false;
        }
        if (armf.a((MessageForFile)paramList).a(false))
        {
          if (bevd.a(BaseActivity.sTopActivity, 5, new bkfi(paramQQAppInterface, paramList))) {
            armv.a(BaseActivity.sTopActivity, 2131692752, 2131692755, new bkfj(paramQQAppInterface, paramList));
          }
        }
        else {
          arni.a(paramQQAppInterface, paramList, BaseActivity.sTopActivity);
        }
      }
      else if (((paramList instanceof MessageForPic)) || ((paramList instanceof MessageForShortVideo)))
      {
        if (a(paramList))
        {
          armz.a(2131692748);
          return false;
        }
        if (((paramList instanceof MessageForPic)) && (agwq.a((MessageForPic)paramList)))
        {
          armz.a(2131692748);
          return false;
        }
        paramQQAppInterface.a().a().a(paramList, new bkfk(paramMqqHandler, paramActivity, paramQQAppInterface, paramInt));
        if (Looper.myLooper() != Looper.getMainLooper()) {
          ThreadManager.getUIHandler().post(new WeiyunAIOUtils.4(paramQQAppInterface, paramInt));
        } else {
          QQToast.a(paramQQAppInterface.getApp(), 2131692912, 0).b(paramInt);
        }
      }
      else
      {
        if (!amgm.b(paramList)) {
          break;
        }
        paramList = (StructMsgForImageShare)((MessageForStructing)paramList).structingMsg;
        paramActivity = new ArrayList();
        paramList = paramList.mStructMsgItemLists.iterator();
        while (paramList.hasNext())
        {
          Object localObject1 = (azqj)paramList.next();
          if (azqk.class.isInstance(localObject1))
          {
            localObject1 = ((azqk)localObject1).a.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (azqj)((Iterator)localObject1).next();
              if (azsp.class.isInstance(localObject2))
              {
                localObject2 = (azsp)localObject2;
                if (!a(((azsp)localObject2).a)) {
                  paramActivity.add(((azsp)localObject2).a);
                }
              }
            }
          }
        }
        if (paramActivity.size() > 0)
        {
          a(paramQQAppInterface, paramActivity, null, null, paramMqqHandler, paramInt);
          QQToast.a(paramQQAppInterface.getApp(), 2131692912, 0).b(paramInt);
        }
        else
        {
          QQToast.a(paramQQAppInterface.getApp(), 2131692963, 0).b(paramInt);
        }
      }
    }
    QQToast.a(paramQQAppInterface.getApp(), 2131692963, 0).b(paramInt);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkfg
 * JD-Core Version:    0.7.0.1
 */