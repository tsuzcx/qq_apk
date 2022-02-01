import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem.MsgInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0xea3.oidb_0xea3.BackMsg;

public class bglk
{
  public static int a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return -1;
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr(bcrn.E);
    } while (TextUtils.isEmpty(paramMessageRecord));
    try
    {
      int i = Integer.parseInt(paramMessageRecord);
      return i;
    }
    catch (NumberFormatException paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
    }
    return -1;
  }
  
  public static ImportantMsgItem.MsgInfo a(long paramLong)
  {
    return new ImportantMsgItem.MsgInfo(0L, paramLong, "", 0, "", true, 0);
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    if (paramInt == 1) {
      return a(paramMessageRecord);
    }
    if (paramInt == 3) {
      return b(paramMessageRecord);
    }
    if (paramInt == 2) {
      return c(paramMessageRecord);
    }
    if (paramInt == 4) {
      return d(paramMessageRecord);
    }
    if (paramInt == 5) {
      return a(paramMessageRecord, false);
    }
    if (paramInt == 6) {
      return a(paramMessageRecord, true);
    }
    return "";
  }
  
  private static String a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord)
  {
    QQMessageFacade.Message localMessage = new QQMessageFacade.Message();
    MessageRecord.copyMessageRecordBaseField(localMessage, paramMessageRecord);
    localMessage.emoRecentMsg = null;
    localMessage.fileType = -1;
    paramQQAppInterface.a().a(localMessage);
    paramMessageRecord = new MsgSummary();
    bhnt.a(paramContext, paramQQAppInterface, localMessage, localMessage.istroop, paramMessageRecord, "", false, false);
    return paramMessageRecord.parseMsg(paramContext).toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, Context paramContext, MessageRecord paramMessageRecord, int paramInt)
  {
    Object localObject = (bglc)aran.a().a(658);
    if (localObject == null) {
      return "";
    }
    localObject = ((bglc)localObject).a(paramInt);
    if (localObject == null) {
      return "";
    }
    if (((bgld)localObject).a == 0) {
      return a(paramQQAppInterface, paramContext, paramInt, paramMessageRecord);
    }
    if (((bgld)localObject).a == 1) {
      return ((bgld)localObject).b;
    }
    if (((bgld)localObject).a == 2) {
      return a(paramQQAppInterface, paramContext, paramMessageRecord);
    }
    return "";
  }
  
  private static String a(MessageRecord paramMessageRecord)
  {
    String str2 = BaseApplicationImpl.getContext().getResources().getString(2131718906);
    String str1 = str2;
    if ((paramMessageRecord instanceof MessageForTroopFile))
    {
      paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
      str1 = str2;
      if (!TextUtils.isEmpty(paramMessageRecord.fileName)) {
        str1 = paramMessageRecord.fileName;
      }
    }
    return str1;
  }
  
  private static String a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131718905);
    if (paramBoolean) {
      str = BaseApplicationImpl.getContext().getResources().getString(2131718907);
    }
    for (;;)
    {
      Object localObject;
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
        localObject = str;
        if (paramMessageRecord != null)
        {
          localObject = str;
          if ((paramMessageRecord.appName != null) && (!paramMessageRecord.appName.equals("com.tencent.structmsg"))) {
            break label124;
          }
        }
      }
      label124:
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                try
                {
                  paramMessageRecord = new JSONObject(paramMessageRecord.metaList).optJSONObject("news");
                  localObject = str;
                  if (paramMessageRecord != null)
                  {
                    paramMessageRecord = paramMessageRecord.optString("title", "");
                    paramBoolean = paramMessageRecord.isEmpty();
                    localObject = str;
                    if (!paramBoolean) {
                      localObject = paramMessageRecord;
                    }
                  }
                  return localObject;
                }
                catch (JSONException paramMessageRecord)
                {
                  paramMessageRecord.printStackTrace();
                  return str;
                }
                localObject = str;
                if (paramMessageRecord.appName.equals("com.tencent.miniapp_01")) {
                  try
                  {
                    paramMessageRecord = new JSONObject(paramMessageRecord.metaList).optJSONObject("detail_1");
                    localObject = str;
                    if (paramMessageRecord != null)
                    {
                      paramMessageRecord = paramMessageRecord.optString("desc", "");
                      paramBoolean = paramMessageRecord.isEmpty();
                      localObject = str;
                      if (!paramBoolean) {
                        return paramMessageRecord;
                      }
                    }
                  }
                  catch (JSONException paramMessageRecord)
                  {
                    paramMessageRecord.printStackTrace();
                    return str;
                  }
                }
              }
              localObject = str;
            } while (!(paramMessageRecord instanceof MessageForStructing));
            paramMessageRecord = bdow.a(paramMessageRecord.msgData);
            localObject = str;
          } while (paramMessageRecord == null);
          localObject = str;
        } while (!(paramMessageRecord instanceof StructMsgForGeneralShare));
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        localObject = str;
      } while (TextUtils.isEmpty(paramMessageRecord.mContentTitle));
      return paramMessageRecord.mContentTitle;
    }
  }
  
  public static ArrayList<ImportantMsgItem.MsgInfo> a(QQAppInterface paramQQAppInterface, long paramLong, List<MessageRecord> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MessageRecord)localIterator.next();
      int j = a(paramList);
      if ((paramBoolean) || ((a(paramList)) && (-1 != j)))
      {
        boolean bool = true;
        int i = 0;
        long l1 = paramList.time;
        long l2 = paramList.shmsgseq;
        String str2 = paramList.senderuin;
        if (b(paramList))
        {
          QLog.i("ImportantMsgUtil", 1, "parseImportantMsg isRevokedMsg troopUin:" + paramLong + " msgSeq:" + l2);
          bool = false;
          i = 2;
          paramList = "";
          label146:
          if (!TextUtils.isEmpty(paramList)) {
            break label315;
          }
          paramList = "";
        }
        label315:
        for (;;)
        {
          localArrayList.add(new ImportantMsgItem.MsgInfo(l1, l2, str2, j, paramList, bool, i));
          break;
          if (c(paramList))
          {
            QLog.i("ImportantMsgUtil", 1, "parseImportantMsg isTroopNotificationShowWindow troopUin:" + paramLong + " msgSeq:" + l2);
            bool = false;
            i = 4;
            paramList = "";
            break label146;
          }
          String str1 = a(paramQQAppInterface, BaseApplicationImpl.getContext(), paramList, j);
          paramList = str1;
          if (!TextUtils.isEmpty(str1)) {
            break label146;
          }
          QLog.i("ImportantMsgUtil", 1, "parseImportantMsg msgSummary == null troopUin:" + paramLong + " msgSeq:" + l2);
          bool = false;
          paramList = "";
          i = 3;
          break label146;
        }
      }
    }
    return localArrayList;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, oidb_0xea3.BackMsg paramBackMsg, List<MessageRecord> paramList)
  {
    if ((paramQQAppInterface == null) || (paramBackMsg == null) || (paramList == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if (!paramBackMsg.msg.has()) {
          break;
        }
        msg_comm.Msg localMsg = new msg_comm.Msg();
        localMsg.mergeFrom(paramBackMsg.msg.get().toByteArray());
        if (!localMsg.msg_head.has()) {
          break label394;
        }
        paramBackMsg = (msg_comm.MsgHead)localMsg.msg_head.get();
        if ((!paramBackMsg.group_info.has()) || (((msg_comm.GroupInfo)paramBackMsg.group_info.get()).group_type.get() != 127)) {
          break label389;
        }
        i = 1;
        l2 = paramBackMsg.msg_seq.get();
        l1 = paramBackMsg.msg_time.get();
        l3 = paramBackMsg.from_uin.get();
        if (!localMsg.content_head.has()) {
          break label383;
        }
        j = ((msg_comm.ContentHead)localMsg.content_head.get()).pkg_num.get();
        if (localMsg.msg_body.has())
        {
          paramBackMsg = (im_msg_body.MsgBody)localMsg.msg_body.get();
          if (paramBackMsg.rich_text.has())
          {
            if (!((im_msg_body.RichText)paramBackMsg.rich_text.get()).ptt.has()) {
              break label364;
            }
            new bcsk().a(paramQQAppInterface, localMsg, paramList, null);
          }
        }
        if ((paramList.size() == 0) && (j > 1))
        {
          if (QLog.isColorLevel()) {
            QLog.i("ImportantMsgUtil", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
          }
          paramQQAppInterface = (MessageForText)bcry.a(-1000);
          paramQQAppInterface.msgtype = -1000;
          paramQQAppInterface.msg = "";
          paramList.add(paramQQAppInterface);
        }
        paramQQAppInterface = paramList.iterator();
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        paramBackMsg = (MessageRecord)paramQQAppInterface.next();
        if (i != 0) {
          paramBackMsg.msgtype = -2006;
        }
        paramBackMsg.time = l1;
        paramBackMsg.shmsgseq = l2;
        paramBackMsg.senderuin = String.valueOf(l3);
        continue;
        bcrw.a(paramQQAppInterface, paramList, localMsg, false, false, new bfoy());
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      label364:
      continue;
      label383:
      int j = 0;
      continue;
      label389:
      int i = 0;
      continue;
      label394:
      long l1 = 0L;
      long l2 = 0L;
      long l3 = 0L;
      i = 0;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    do
    {
      return false;
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr(bcrn.D);
    } while ((TextUtils.isEmpty(paramMessageRecord)) || (!paramMessageRecord.equals("1")));
    return true;
  }
  
  private static String b(MessageRecord paramMessageRecord)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131718904);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord == null) {}
    }
    try
    {
      Object localObject = new JSONObject(paramMessageRecord.metaList).optJSONObject("albumData");
      if (localObject != null)
      {
        paramMessageRecord = ((JSONObject)localObject).optString("title", "");
        localObject = ((JSONObject)localObject).optString("albumName", "");
        if ((!paramMessageRecord.isEmpty()) && (!((String)localObject).isEmpty()))
        {
          localObject = "《" + (String)localObject + "》";
          if (paramMessageRecord.startsWith((String)localObject)) {
            return paramMessageRecord.substring(((String)localObject).length());
          }
        }
        else if (((String)localObject).isEmpty())
        {
          boolean bool = paramMessageRecord.isEmpty();
          if (!bool) {
            return paramMessageRecord;
          }
        }
      }
    }
    catch (JSONException paramMessageRecord)
    {
      for (;;)
      {
        paramMessageRecord.printStackTrace();
      }
    }
    return str;
    return paramMessageRecord;
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (paramMessageRecord.msgtype != -2006) {
      return false;
    }
    return true;
  }
  
  private static String c(MessageRecord paramMessageRecord)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131718909);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if (paramMessageRecord != null) {
        try
        {
          paramMessageRecord = new JSONObject(paramMessageRecord.metaList).optJSONObject("mannounce");
          if (paramMessageRecord != null)
          {
            paramMessageRecord = paramMessageRecord.optString("text", "");
            if (!paramMessageRecord.isEmpty())
            {
              paramMessageRecord = new String(Base64.decode(paramMessageRecord, 2));
              return paramMessageRecord;
            }
          }
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return str;
  }
  
  private static boolean c(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    for (;;)
    {
      return false;
      if ((paramMessageRecord instanceof MessageForArkApp))
      {
        paramMessageRecord = (MessageForArkApp)paramMessageRecord;
        try
        {
          if (paramMessageRecord.ark_app_message != null)
          {
            paramMessageRecord = new JSONObject(paramMessageRecord.ark_app_message.metaList).optJSONObject("mannounce");
            if (paramMessageRecord != null)
            {
              int i = paramMessageRecord.optInt("tw", 1);
              if (i == 0) {
                return true;
              }
            }
          }
        }
        catch (JSONException paramMessageRecord)
        {
          paramMessageRecord.printStackTrace();
        }
      }
    }
    return false;
  }
  
  private static String d(MessageRecord paramMessageRecord)
  {
    String str = BaseApplicationImpl.getContext().getResources().getString(2131718908);
    if ((paramMessageRecord instanceof MessageForArkApp))
    {
      paramMessageRecord = ((MessageForArkApp)paramMessageRecord).ark_app_message;
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.getSummery()))) {
        return paramMessageRecord.getSummery();
      }
    }
    else if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = bdow.a(paramMessageRecord.msgData);
      if ((paramMessageRecord != null) && ((paramMessageRecord instanceof StructMsgForGeneralShare)))
      {
        paramMessageRecord = (StructMsgForGeneralShare)paramMessageRecord;
        if (!TextUtils.isEmpty(paramMessageRecord.mContentTitle)) {
          return paramMessageRecord.mContentTitle;
        }
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bglk
 * JD-Core Version:    0.7.0.1
 */