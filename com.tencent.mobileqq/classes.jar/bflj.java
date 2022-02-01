import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsg;

public class bflj
{
  public static int a(QQAppInterface paramQQAppInterface, bfkz parambfkz, ChatMessage paramChatMessage)
  {
    if ((paramQQAppInterface == null) || (parambfkz == null) || (paramChatMessage == null)) {}
    label130:
    label248:
    label252:
    for (;;)
    {
      return 0;
      if ((!nty.a(paramChatMessage)) && ((!paramChatMessage.isSendFromLocal()) || ((paramChatMessage.extraflag != 32768) && (paramChatMessage.extraflag != 32772))))
      {
        paramChatMessage = (bfkx)aqxe.a().a(668);
        if ((paramChatMessage != null) && (paramChatMessage.a(Long.toString(parambfkz.a))) && (paramChatMessage.a() != 0))
        {
          boolean bool1 = TroopUtils.isTroopAdmin(paramQQAppInterface, Long.toString(parambfkz.a), paramQQAppInterface.getCurrentUin());
          boolean bool2 = TroopUtils.isTroopOwner(paramQQAppInterface, Long.toString(parambfkz.a), paramQQAppInterface.getCurrentUin());
          int i;
          Object localObject;
          if ((bool1) || (bool2))
          {
            i = 1;
            localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            if (localObject == null) {
              break label248;
            }
            localObject = ((TroopManager)localObject).c(String.valueOf(parambfkz.a));
            if (localObject == null) {
              break label248;
            }
          }
          for (int j = ((TroopInfo)localObject).wMemberNum;; j = 0)
          {
            if ((i == 0) && (j > paramChatMessage.a())) {
              break label252;
            }
            paramChatMessage = (bflc)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
            paramChatMessage.b(parambfkz);
            parambfkz = paramChatMessage.a(parambfkz);
            if ((parambfkz == null) || (parambfkz.a == 2))
            {
              return 1;
              i = 0;
              break label130;
            }
            if ((i == 0) && (!parambfkz.b.equals(paramQQAppInterface.getCurrentUin()))) {
              break;
            }
            return 2;
          }
        }
      }
    }
  }
  
  private static int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    int j = 1;
    int k = 0;
    int i;
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramBaseBubbleBuilder == null)) {
      i = 0;
    }
    do
    {
      do
      {
        do
        {
          return i;
          i = j;
        } while ((paramBaseBubbleBuilder instanceof ahit));
        i = j;
      } while ((paramBaseBubbleBuilder instanceof aham));
      i = j;
    } while ((paramBaseBubbleBuilder instanceof aham));
    if ((paramBaseBubbleBuilder instanceof agqg)) {
      return 3;
    }
    if ((paramBaseBubbleBuilder instanceof ahbp)) {
      return 2;
    }
    if ((paramBaseBubbleBuilder instanceof ahdp)) {
      return 4;
    }
    if ((paramBaseBubbleBuilder instanceof ahdw)) {
      return 5;
    }
    if ((paramBaseBubbleBuilder instanceof ahdr)) {
      return 6;
    }
    if (!c(paramChatMessage))
    {
      i = k;
      if (!d(paramChatMessage)) {}
    }
    else
    {
      i = 1;
    }
    if (i != 0) {
      return 7;
    }
    if ((a(paramChatMessage)) || (b(paramChatMessage))) {
      return 8;
    }
    return 9;
  }
  
  private static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
      return 0L;
    }
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.dwGroupClassExt;
      }
    }
    return 0L;
  }
  
  public static bflb a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg)
  {
    if (paramQQGroupDigestMsg == null) {
      return null;
    }
    bfkz localbfkz = new bfkz(paramQQGroupDigestMsg.group_code.get(), paramQQGroupDigestMsg.msg_seq.get(), paramQQGroupDigestMsg.msg_random.get());
    bfla localbfla = new bfla(paramQQGroupDigestMsg.op_type.get(), String.valueOf(paramQQGroupDigestMsg.msg_sender.get()), String.valueOf(paramQQGroupDigestMsg.digest_oper.get()), paramQQGroupDigestMsg.op_time.get(), 0L);
    String str1 = "";
    String str2 = "";
    if (paramQQGroupDigestMsg.oper_nick.has()) {
      str1 = paramQQGroupDigestMsg.oper_nick.get().toStringUtf8();
    }
    if (paramQQGroupDigestMsg.sender_nick.has()) {
      str2 = paramQQGroupDigestMsg.sender_nick.get().toStringUtf8();
    }
    return new bflb(new TroopEssenceMsgItem(localbfkz, localbfla), paramQQGroupDigestMsg.lastest_msg_seq.get(), str1, str2);
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, bflb parambflb)
  {
    if ((paramQQAppInterface == null) || (parambflb == null) || (parambflb.a == null)) {
      return null;
    }
    Object localObject2 = String.valueOf(parambflb.a.troopUin);
    Object localObject1 = BaseApplicationImpl.getContext().getResources().getString(2131719537);
    String str1 = BaseApplicationImpl.getContext().getResources().getString(2131719536);
    String str3 = ((String)localObject1).replace("$MSGSENDERNAME", parambflb.b);
    String str2 = str3 + BaseApplicationImpl.getContext().getResources().getString(2131719539) + str1;
    localObject1 = new avhz((String)localObject2, (String)localObject2, str2, 1, -5040, 131090, bcrg.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 58);
    localBundle.putString("textColor", "#40A0FF");
    localBundle.putString("key_action_DATA", String.valueOf(parambflb.a.msgSeq));
    ((avhz)localObject1).a(0, str3.length(), localBundle);
    parambflb = a((String)localObject2, parambflb.a.msgSeq, parambflb.a.msgRandom);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 1);
    ((Bundle)localObject2).putString("textColor", "#40A0FF");
    ((Bundle)localObject2).putString("key_action_DATA", parambflb);
    ((avhz)localObject1).a(str2.length() - str1.length(), str2.length(), (Bundle)localObject2);
    parambflb = new MessageForUniteGrayTip();
    parambflb.createMessageUniseq();
    parambflb.initGrayTipMsg(paramQQAppInterface, (avhz)localObject1);
    return parambflb;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      if (paramString2.equals(paramQQAppInterface.getCurrentUin())) {
        return BaseApplicationImpl.getContext().getResources().getString(2131719538);
      }
      paramQQAppInterface = ContactUtils.getTroopNickName(paramQQAppInterface, paramString2, paramString1, ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).d(paramString1), true, null);
      if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!paramQQAppInterface.equals(paramString2))) {
        break;
      }
      paramQQAppInterface = paramString3;
    } while (!TextUtils.isEmpty(paramString3));
    return paramString2;
    return paramQQAppInterface;
  }
  
  private static String a(String paramString, long paramLong, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    return "https://qun.qq.com/essence/index?gc=$GC&seq=$SEQ&random=$RANDOM&_wv=3&_wwv=128&_wvx=2&_wvxBclr=f5f6fa".replace("$GC", paramString).replace("$SEQ", String.valueOf(paramLong)).replace("$RANDOM", String.valueOf(paramInt));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    try
    {
      long l = Long.parseLong(paramString2);
      if ((paramContext instanceof FragmentActivity))
      {
        paramContext = ((FragmentActivity)paramContext).getChatFragment();
        if ((paramContext != null) && (paramContext.a() != null) && ((paramContext.a() instanceof afzn))) {
          paramContext.a().refreshHeadMessage(103, l, 0, null);
        }
      }
      bdla.b(null, "dc00898", "", paramString1, "0X800B34C", "0X800B34C", 0, 0, String.valueOf(a(paramQQAppInterface, paramString1)), "", "", "");
      return;
    }
    catch (NumberFormatException paramQQAppInterface) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, TroopEssenceMsgItem paramTroopEssenceMsgItem, BaseBubbleBuilder paramBaseBubbleBuilder)
  {
    if ((paramQQAppInterface == null) || (paramChatMessage == null) || (paramTroopEssenceMsgItem == null)) {}
    long l;
    int i;
    label136:
    do
    {
      return;
      l = a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin));
      if ((TroopUtils.isTroopAdmin(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.getCurrentUin())) || (TroopUtils.isTroopOwner(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.getCurrentUin())))
      {
        i = 1;
        if (paramTroopEssenceMsgItem.opType != 1) {
          continue;
        }
        paramTroopEssenceMsgItem = Long.toString(paramTroopEssenceMsgItem.troopUin);
        j = a(paramQQAppInterface, paramChatMessage, paramBaseBubbleBuilder);
        if (i == 0) {
          break label136;
        }
      }
      for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
      {
        bdla.b(null, "dc00898", "", paramTroopEssenceMsgItem, "0X800B34B", "0X800B34B", 0, 0, String.valueOf(l), String.valueOf(j), paramQQAppInterface, "");
        return;
        i = 0;
        break;
      }
    } while (paramTroopEssenceMsgItem.opType != 2);
    paramTroopEssenceMsgItem = Long.toString(paramTroopEssenceMsgItem.troopUin);
    int j = a(paramQQAppInterface, paramChatMessage, paramBaseBubbleBuilder);
    if (i != 0) {}
    for (paramQQAppInterface = "1";; paramQQAppInterface = "2")
    {
      bdla.b(null, "dc00898", "", paramTroopEssenceMsgItem, "0X800B34D", "0X800B34D", 0, 0, String.valueOf(l), String.valueOf(j), paramQQAppInterface, "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    bdla.b(null, "dc00898", "", paramString, "0X800B34F", "0X800B34F", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, int paramInt, Context paramContext)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      return;
    }
    String str = a(paramString, paramLong, paramInt);
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", str);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if ((paramContext instanceof BaseActivity)) {
      ((BaseActivity)paramContext).startActivityForResult(localIntent, 20008);
    }
    bdla.b(null, "dc00898", "", paramString, "0X800B34A", "0X800B34A", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (bflc)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER);
    return (paramQQAppInterface != null) && (paramQQAppInterface.a(new bfkz(paramLong1, paramLong2, paramInt)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return a(paramQQAppInterface, l, paramChatMessage.shmsgseq, bcsc.b(paramChatMessage.msgUid));
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return false;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForStructing))) {
      return false;
    }
    paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
    if (paramChatMessage == null) {
      return false;
    }
    return (paramChatMessage.mMsgServiceID == 1) || (paramChatMessage.mMsgServiceID == 33) || (paramChatMessage.mMsgServiceID == 95) || (((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == becr.a));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    bdla.b(null, "dc00898", "", paramString, "0X800B34E", "0X800B34E", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static boolean b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!(paramChatMessage instanceof MessageForArkApp))) {
      return false;
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if ((localMessageForArkApp == null) || (localMessageForArkApp.ark_app_message == null)) {
      return false;
    }
    if ("com.tencent.structmsg".equals(localMessageForArkApp.ark_app_message.appName)) {
      return true;
    }
    return d(paramChatMessage);
  }
  
  private static boolean c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return false;
    }
    if ((paramChatMessage instanceof MessageForStructing))
    {
      paramChatMessage = ((MessageForStructing)paramChatMessage).structingMsg;
      if (paramChatMessage != null)
      {
        if (paramChatMessage.mMsgServiceID == 95) {
          return true;
        }
        if (((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == becr.a)) {
          return true;
        }
        if ((!TextUtils.isEmpty(paramChatMessage.mMsgUrl)) && (atpk.a(paramChatMessage.mMsgUrl))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean d(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {}
    for (;;)
    {
      return false;
      if ((paramChatMessage instanceof MessageForArkApp))
      {
        paramChatMessage = (MessageForArkApp)paramChatMessage;
        if (paramChatMessage.ark_app_message != null) {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramChatMessage.ark_app_message.metaList);
            if ("com.tencent.miniapp_01".equals(paramChatMessage.ark_app_message.appName))
            {
              if (!localJSONObject.has("detail_1")) {
                continue;
              }
              paramChatMessage = localJSONObject.optJSONObject("detail_1");
              if (paramChatMessage == null) {
                continue;
              }
              paramChatMessage = paramChatMessage.optString("appid");
              if (!paramChatMessage.equals("1108338344")) {
                if (!paramChatMessage.equals("1108961705")) {
                  continue;
                }
              }
            }
            else
            {
              if ("com.tencent.miniapp".equals(paramChatMessage.ark_app_message.appName))
              {
                if (!localJSONObject.has("detail")) {
                  continue;
                }
                paramChatMessage = localJSONObject.optJSONObject("detail");
                if (paramChatMessage == null) {
                  continue;
                }
                paramChatMessage = paramChatMessage.optString("appid");
                if (paramChatMessage.equals("1108338344")) {
                  break label258;
                }
                if (!paramChatMessage.equals("1108961705")) {
                  continue;
                }
                break label258;
              }
              if ((!"com.tencent.structmsg".equals(paramChatMessage.ark_app_message.appName)) || (!localJSONObject.has("news"))) {
                continue;
              }
              paramChatMessage = localJSONObject.getJSONObject("news");
              if (paramChatMessage == null) {
                continue;
              }
              long l1 = Long.valueOf(paramChatMessage.getLong("appid")).longValue();
              long l2 = becr.a;
              if (l1 != l2) {
                continue;
              }
              return true;
            }
          }
          catch (JSONException paramChatMessage)
          {
            paramChatMessage.printStackTrace();
            return false;
          }
        }
      }
    }
    return true;
    label258:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflj
 * JD-Core Version:    0.7.0.1
 */