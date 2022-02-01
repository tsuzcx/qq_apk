import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class awct
{
  public static boolean a = true;
  public static boolean b = true;
  
  public static int a(ChatMessage paramChatMessage)
  {
    int j = 0;
    int i = j;
    if (a(paramChatMessage))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      i = j;
      if (paramChatMessage.structingMsg != null)
      {
        i = j;
        if ("viewMultiMsg".equals(paramChatMessage.structingMsg.mMsgAction)) {
          i = paramChatMessage.structingMsg.mTSum;
        }
      }
    }
    return i + 1;
  }
  
  public static MessageRecord a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord == null) || (paramQQAppInterface == null)) {
      return null;
    }
    String str1 = paramMessageRecord.getExtInfoFromExtStr("outest_uin");
    String str2 = paramMessageRecord.getExtInfoFromExtStr("outest_uintype");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("outest_uniseq");
    try
    {
      paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMsgItemByUniseq(str1, Integer.parseInt(str2), Long.parseLong(paramMessageRecord));
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MultiMsg_TAG", 1, paramQQAppInterface, new Object[0]);
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null)) {
      return null;
    }
    if (((paramMessageRecord instanceof MessageForStructing)) && (((MessageForStructing)paramMessageRecord).structingMsg != null) && (((MessageForStructing)paramMessageRecord).structingMsg.mMsgServiceID == 128)) {
      return amtj.a(2131706131);
    }
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    paramQQAppInterface.getMessageFacade().decodeMsg(localMessage);
    paramMessageRecord = new MsgSummary();
    bfwr.a(paramQQAppInterface.getApp(), paramQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, null, false, false);
    try
    {
      paramQQAppInterface = paramMessageRecord.parseMsg(paramQQAppInterface.getApp()).toString();
      return paramQQAppInterface;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("MultiMsg_TAG.Nest", 1, paramQQAppInterface, new Object[0]);
    }
    return null;
  }
  
  public static String a(String paramString)
  {
    return paramString;
  }
  
  public static ArrayList<ChatMessage> a(QQAppInterface paramQQAppInterface, ArrayList<ChatMessage> paramArrayList)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.size() == 0)) {
      return paramArrayList;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ChatMessage localChatMessage = (ChatMessage)paramArrayList.next();
      if (a(paramQQAppInterface, localChatMessage))
      {
        localArrayList.add(localChatMessage);
      }
      else
      {
        String str = a(paramQQAppInterface, localChatMessage);
        localChatMessage = (ChatMessage)paramQQAppInterface.getMultiMessageProxy().a(localChatMessage, str, false);
        if (localChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin())) {
          ((anaj)paramQQAppInterface.getBusinessHandler(13)).a(localChatMessage);
        }
        localChatMessage.setStatus(1000);
        localChatMessage.msgData = localChatMessage.msg.getBytes();
        localArrayList.add(localChatMessage);
      }
    }
    return localArrayList;
  }
  
  public static void a(MessageRecord paramMessageRecord1, String paramString, MessageRecord paramMessageRecord2)
  {
    a("step.fillExtraInfo.nickName = %s", new Object[] { paramString });
    if ((paramMessageRecord1 == null) || (paramMessageRecord2 == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramMessageRecord1.saveExtInfoToExtStr("outest_uin", paramMessageRecord2.frienduin);
    paramMessageRecord1.saveExtInfoToExtStr("outest_uintype", String.valueOf(paramMessageRecord2.istroop));
    paramMessageRecord1.saveExtInfoToExtStr("outest_uniseq", String.valueOf(paramMessageRecord2.uniseq));
    paramMessageRecord1.saveExtInfoToExtStr("self_nickname", paramString);
  }
  
  public static void a(String paramString)
  {
    bcef.b(null, "dc00898", "", "", paramString, paramString, 0, 0, "", "", "", "");
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (!a) {}
    while (!QLog.isDevelopLevel()) {
      return;
    }
    QLog.d("MultiMsg_TAG.Nest", 4, String.format(paramString, paramVarArgs));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((MessageForShortVideo.class.isInstance(paramChatMessage)) && (((MessageForShortVideo)paramChatMessage).busiType == 2)) {}
    while (((MessageForLongTextMsg.class.isInstance(paramChatMessage)) && ((paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("2")) || (paramChatMessage.getExtInfoFromExtStr("long_text_recv_state").equals("3")))) || (!MessageForArkApp.isAllowedArkForward(false, paramChatMessage)) || (MessageForTroopConfess.class.isInstance(paramChatMessage)) || (MessageForLightVideo.class.isInstance(paramChatMessage)) || ((paramChatMessage instanceof MessageForFuDai)) || (amrp.a(paramChatMessage)) || (((paramChatMessage instanceof MessageForPic)) && (ahtj.a((MessageForPic)paramChatMessage)))) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForWriteTogether)) {
      return true;
    }
    boolean bool;
    switch (paramChatMessage.msgtype)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      paramQQAppInterface = (MessageForStructing)paramChatMessage;
      if (paramQQAppInterface.structingMsg == null)
      {
        bool = false;
      }
      else
      {
        int i = paramQQAppInterface.structingMsg.mMsgServiceID;
        if ((i == 107) || (i == 82) || (i == 128) || (i == 104))
        {
          bool = false;
        }
        else if ((paramQQAppInterface.structingMsg.hasFlag(1)) && (i != 35))
        {
          bool = false;
        }
        else
        {
          bool = true;
          continue;
          paramQQAppInterface = (MessageForArkBabyqReply)paramChatMessage;
          if ((paramQQAppInterface.mArkBabyqReplyCardList == null) || (paramQQAppInterface.mArkBabyqReplyCardList.size() <= 0))
          {
            bool = false;
          }
          else
          {
            bool = true;
            continue;
            if (!(paramChatMessage instanceof MessageForFile)) {
              break;
            }
            if (paramChatMessage.isMultiMsg) {
              bool = true;
            } else if (aszt.a(paramQQAppInterface, (MessageForFile)paramChatMessage).getCloudType() == 0) {
              bool = false;
            } else {
              bool = true;
            }
          }
        }
      }
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (MessageForStructing.class.isInstance(paramChatMessage))
    {
      paramChatMessage = (MessageForStructing)paramChatMessage;
      bool1 = bool2;
      if (paramChatMessage.structingMsg != null)
      {
        bool1 = bool2;
        if ("viewMultiMsg".equals(paramChatMessage.structingMsg.mMsgAction)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    return false;
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG.Nest", 2, String.format(paramString, paramVarArgs));
    }
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    return ((paramChatMessage instanceof MessageForText)) || ((paramChatMessage instanceof MessageForReplyText)) || ((paramChatMessage instanceof MessageForPic)) || ((paramChatMessage instanceof MessageForStructing)) || ((paramChatMessage instanceof MessageForShortVideo)) || ((paramChatMessage instanceof MessageForArkApp)) || ((paramChatMessage instanceof MessageForFile)) || ((paramChatMessage instanceof MessageForMixedMsg)) || ((paramChatMessage instanceof MessageForTroopFile));
  }
  
  public static boolean c(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForGrayTips)) || ((paramChatMessage instanceof MessageForUniteGrayTip)) || ((paramChatMessage instanceof MessageForIncompatibleGrayTips)) || ((paramChatMessage instanceof MessageForNewGrayTips)) || ((paramChatMessage instanceof MessageForSafeGrayTips)) || ((paramChatMessage instanceof MessageForFoldMsgGrayTips)) || ((paramChatMessage instanceof MessageForNearbyMarketGrayTips)) || ((paramChatMessage instanceof MessageForQQWalletTips)) || ((paramChatMessage instanceof MessageForSplitLineTips))) {}
    for (boolean bool = false;; bool = true)
    {
      if ((paramChatMessage instanceof MessageForTroopGift)) {
        return true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awct
 * JD-Core Version:    0.7.0.1
 */