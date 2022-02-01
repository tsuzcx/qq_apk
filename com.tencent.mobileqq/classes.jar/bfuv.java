import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgItem;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsg;

public class bfuv
{
  public static int a(QQAppInterface paramQQAppInterface, bful parambful, ChatMessage paramChatMessage)
  {
    if ((paramQQAppInterface == null) || (parambful == null) || (paramChatMessage == null)) {}
    label130:
    label247:
    label251:
    for (;;)
    {
      return 0;
      if ((!nlj.a(paramChatMessage)) && ((!paramChatMessage.isSendFromLocal()) || ((paramChatMessage.extraflag != 32768) && (paramChatMessage.extraflag != 32772))))
      {
        paramChatMessage = (bfuj)aran.a().a(668);
        if ((paramChatMessage != null) && (paramChatMessage.a(Long.toString(parambful.a))) && (paramChatMessage.a() != 0))
        {
          boolean bool1 = bguq.b(paramQQAppInterface, Long.toString(parambful.a), paramQQAppInterface.c());
          boolean bool2 = bguq.a(paramQQAppInterface, Long.toString(parambful.a), paramQQAppInterface.c());
          int i;
          Object localObject;
          if ((bool1) || (bool2))
          {
            i = 1;
            localObject = (TroopManager)paramQQAppInterface.getManager(52);
            if (localObject == null) {
              break label247;
            }
            localObject = ((TroopManager)localObject).c(String.valueOf(parambful.a));
            if (localObject == null) {
              break label247;
            }
          }
          for (int j = ((TroopInfo)localObject).wMemberNum;; j = 0)
          {
            if ((i == 0) && (j > paramChatMessage.a())) {
              break label251;
            }
            paramChatMessage = (bfuo)paramQQAppInterface.getManager(381);
            paramChatMessage.b(parambful);
            parambful = paramChatMessage.a(parambful);
            if ((parambful == null) || (parambful.a == 2))
            {
              return 1;
              i = 0;
              break label130;
            }
            if ((i == 0) && (!parambful.b.equals(paramQQAppInterface.c()))) {
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
        } while ((paramBaseBubbleBuilder instanceof ahtp));
        i = j;
      } while ((paramBaseBubbleBuilder instanceof ahlj));
      i = j;
    } while ((paramBaseBubbleBuilder instanceof ahlj));
    if ((paramBaseBubbleBuilder instanceof ahbe)) {
      return 3;
    }
    if ((paramBaseBubbleBuilder instanceof ahmm)) {
      return 2;
    }
    if ((paramBaseBubbleBuilder instanceof ahom)) {
      return 4;
    }
    if ((paramBaseBubbleBuilder instanceof ahot)) {
      return 5;
    }
    if ((paramBaseBubbleBuilder instanceof ahoo)) {
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
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.c(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.dwGroupClassExt;
      }
    }
    return 0L;
  }
  
  public static bfun a(TroopTips0x857.QQGroupDigestMsg paramQQGroupDigestMsg)
  {
    if (paramQQGroupDigestMsg == null) {
      return null;
    }
    bful localbful = new bful(paramQQGroupDigestMsg.group_code.get(), paramQQGroupDigestMsg.msg_seq.get(), paramQQGroupDigestMsg.msg_random.get());
    bfum localbfum = new bfum(paramQQGroupDigestMsg.op_type.get(), String.valueOf(paramQQGroupDigestMsg.msg_sender.get()), String.valueOf(paramQQGroupDigestMsg.digest_oper.get()), paramQQGroupDigestMsg.op_time.get(), 0L);
    String str1 = "";
    String str2 = "";
    if (paramQQGroupDigestMsg.oper_nick.has()) {
      str1 = paramQQGroupDigestMsg.oper_nick.get().toStringUtf8();
    }
    if (paramQQGroupDigestMsg.sender_nick.has()) {
      str2 = paramQQGroupDigestMsg.sender_nick.get().toStringUtf8();
    }
    return new bfun(new TroopEssenceMsgItem(localbful, localbfum), paramQQGroupDigestMsg.lastest_msg_seq.get(), str1, str2);
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, bfun parambfun)
  {
    if ((paramQQAppInterface == null) || (parambfun == null) || (parambfun.a == null)) {
      return null;
    }
    Object localObject2 = String.valueOf(parambfun.a.troopUin);
    Object localObject1 = BaseApplicationImpl.getContext().getResources().getString(2131718873);
    String str1 = BaseApplicationImpl.getContext().getResources().getString(2131718872);
    String str3 = ((String)localObject1).replace("$MSGSENDERNAME", parambfun.b);
    String str2 = str3 + BaseApplicationImpl.getContext().getResources().getString(2131718875) + str1;
    localObject1 = new avpd((String)localObject2, (String)localObject2, str2, 1, -5040, 131090, bcrg.a());
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_action", 58);
    localBundle.putString("textColor", "#40A0FF");
    localBundle.putString("key_action_DATA", String.valueOf(parambfun.a.msgSeq));
    ((avpd)localObject1).a(0, str3.length(), localBundle);
    parambfun = a((String)localObject2, parambfun.a.msgSeq, parambfun.a.msgRandom);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("key_action", 1);
    ((Bundle)localObject2).putString("textColor", "#40A0FF");
    ((Bundle)localObject2).putString("key_action_DATA", parambfun);
    ((avpd)localObject1).a(str2.length() - str1.length(), str2.length(), (Bundle)localObject2);
    parambfun = new MessageForUniteGrayTip();
    parambfun.createMessageUniseq();
    parambfun.initGrayTipMsg(paramQQAppInterface, (avpd)localObject1);
    return parambfun;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramQQAppInterface = "";
    }
    do
    {
      return paramQQAppInterface;
      if (paramString2.equals(paramQQAppInterface.c())) {
        return BaseApplicationImpl.getContext().getResources().getString(2131718874);
      }
      paramQQAppInterface = bhlg.a(paramQQAppInterface, paramString2, paramString1, ((TroopManager)paramQQAppInterface.getManager(52)).d(paramString1), true, null);
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
        if ((paramContext != null) && (paramContext.a() != null) && ((paramContext.a() instanceof aihd))) {
          paramContext.a().a(103, l, 0, null);
        }
      }
      bdll.b(null, "dc00898", "", paramString1, "0X800B34C", "0X800B34C", 0, 0, String.valueOf(a(paramQQAppInterface, paramString1)), "", "", "");
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
      if ((bguq.b(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.c())) || (bguq.a(paramQQAppInterface, Long.toString(paramTroopEssenceMsgItem.troopUin), paramQQAppInterface.c())))
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
        bdll.b(null, "dc00898", "", paramTroopEssenceMsgItem, "0X800B34B", "0X800B34B", 0, 0, String.valueOf(l), String.valueOf(j), paramQQAppInterface, "");
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
      bdll.b(null, "dc00898", "", paramTroopEssenceMsgItem, "0X800B34D", "0X800B34D", 0, 0, String.valueOf(l), String.valueOf(j), paramQQAppInterface, "");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    bdll.b(null, "dc00898", "", paramString, "0X800B34F", "0X800B34F", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
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
    bdll.b(null, "dc00898", "", paramString, "0X800B34A", "0X800B34A", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return false;
    }
    paramQQAppInterface = (bfuo)paramQQAppInterface.getManager(381);
    return (paramQQAppInterface != null) && (paramQQAppInterface.a(new bful(paramLong1, paramLong2, paramInt)));
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return a(paramQQAppInterface, l, paramChatMessage.shmsgseq, bcsa.b(paramChatMessage.msgUid));
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
    return (paramChatMessage.mMsgServiceID == 1) || (paramChatMessage.mMsgServiceID == 33) || (paramChatMessage.mMsgServiceID == 95) || (((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == becb.a));
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    bdll.b(null, "dc00898", "", paramString, "0X800B34E", "0X800B34E", 0, 0, String.valueOf(a(paramQQAppInterface, paramString)), "", "", "");
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
        if (((paramChatMessage instanceof StructMsgForGeneralShare)) && (((StructMsgForGeneralShare)paramChatMessage).mSourceAppid == becb.a)) {
          return true;
        }
        if ((!TextUtils.isEmpty(paramChatMessage.mMsgUrl)) && (atyu.a(paramChatMessage.mMsgUrl))) {
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
              long l2 = becb.a;
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
 * Qualified Name:     bfuv
 * JD-Core Version:    0.7.0.1
 */