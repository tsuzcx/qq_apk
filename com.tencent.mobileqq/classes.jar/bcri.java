import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.bmqq.protocol.Crm.CrmCCNotify;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import tencent.im.msg.hummer.resv.notonlinefile.tencent_im_msg_hummer_resv_notonlinefile.ResvAttr;
import tencent.im.msg.im_msg_body.CrmElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;

public class bcri
{
  /* Error */
  public static int a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: ldc 10
    //   5: invokevirtual 16	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8: astore_0
    //   9: bipush 24
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_1
    //   14: iload_1
    //   15: istore 4
    //   17: iload_3
    //   18: aload_0
    //   19: arraylength
    //   20: if_icmpge +46 -> 66
    //   23: iload_1
    //   24: i2l
    //   25: lstore 5
    //   27: aload_0
    //   28: iload_3
    //   29: aaload
    //   30: invokestatic 22	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   33: lstore 7
    //   35: lload 5
    //   37: lload 7
    //   39: iload_2
    //   40: lshl
    //   41: lor
    //   42: l2i
    //   43: istore_1
    //   44: iload_3
    //   45: iconst_1
    //   46: iadd
    //   47: istore_3
    //   48: iload_2
    //   49: bipush 8
    //   51: isub
    //   52: istore_2
    //   53: goto -39 -> 14
    //   56: astore_0
    //   57: iconst_0
    //   58: istore_1
    //   59: aload_0
    //   60: invokevirtual 26	java/lang/Exception:printStackTrace	()V
    //   63: iload_1
    //   64: istore 4
    //   66: iload 4
    //   68: ireturn
    //   69: astore_0
    //   70: goto -11 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	paramString	String
    //   13	51	1	i	int
    //   11	42	2	j	int
    //   1	47	3	k	int
    //   15	52	4	m	int
    //   25	11	5	l1	long
    //   33	5	7	l2	long
    // Exception table:
    //   from	to	target	type
    //   2	9	56	java/lang/Exception
    //   17	23	69	java/lang/Exception
    //   27	35	69	java/lang/Exception
  }
  
  public static String a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    String str2 = paramChatMessage.getExtInfoFromExtStr("qidian_ext_nick_name");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bcpn.a(paramQQAppInterface, paramChatMessage.senderuin);
    }
    if ((TextUtils.isEmpty(str1)) && (QLog.isColorLevel())) {
      QLog.d("QidianUtils", 2, "qidian ext nickname is null");
    }
    return str1;
  }
  
  public static void a(awbm paramawbm, msg_comm.Msg paramMsg, MessageRecord paramMessageRecord)
  {
    if ((paramawbm != null) && (paramawbm.a == 1024) && (paramMsg.msg_body.rich_text.has()) && (paramMsg.msg_body.rich_text.elems.has()))
    {
      paramawbm = paramMsg.msg_body.rich_text.elems.get().iterator();
      while (paramawbm.hasNext())
      {
        paramMsg = (im_msg_body.Elem)paramawbm.next();
        if ((paramMsg.has()) && (paramMsg.crm_elem.has()) && (paramMsg.crm_elem.crm_buf.has()))
        {
          Crm.CrmCCNotify localCrmCCNotify = new Crm.CrmCCNotify();
          try
          {
            localCrmCCNotify.mergeFrom(paramMsg.crm_elem.crm_buf.get().toByteArray());
            if (localCrmCCNotify.str_ext_nick_name.has()) {
              paramMessageRecord.saveExtInfoToExtStr("qidian_ext_nick_name", localCrmCCNotify.str_ext_nick_name.get());
            }
          }
          catch (InvalidProtocolBufferMicroException paramMsg)
          {
            QLog.d("QidianUtils", 2, "qidian add ext name in master session " + paramMsg);
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    int i;
    if (!TextUtils.isEmpty(paramString4))
    {
      i = paramString4.indexOf(paramQQAppInterface.getApp().getString(2131632501));
      if (i != -1) {}
    }
    else
    {
      return;
    }
    paramString4 = new aqax(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString4, paramInt, -5023, 1245186, awao.a());
    paramString4.f = false;
    paramString4.a = paramLong;
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("key_action", 12);
    paramString4.a(i, i + 4, (Bundle)localObject);
    localObject = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString4);
    ((MessageForUniteGrayTip)localObject).masterUin = paramString2;
    ((MessageForUniteGrayTip)localObject).extUin = paramString1;
    ((MessageForUniteGrayTip)localObject).taskId = paramString3;
    aqay.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Crm.CrmCCNotify paramCrmCCNotify, msg_comm.Msg paramMsg, awbm paramawbm)
  {
    long l = paramMsg.msg_head.from_uin.get();
    if (paramawbm == null) {}
    for (int i = 0;; i = paramawbm.a)
    {
      a(paramQQAppInterface, String.valueOf(l), i, -2005, paramMsg.msg_head.msg_time.get(), paramCrmCCNotify.str_check_id.get());
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.equals(paramQQAppInterface.getCurrentAccountUin())) || (TextUtils.isEmpty(paramString2))) {}
    label134:
    label177:
    for (;;)
    {
      return;
      String str1 = "0";
      String str2;
      if (paramInt2 == -1000)
      {
        str1 = "1";
        str2 = null;
        if (paramInt1 != 0) {
          break label134;
        }
        str2 = "0X800980B";
      }
      for (;;)
      {
        if (str2 == null) {
          break label177;
        }
        awqx.b(paramQQAppInterface, "dc00899", "Qidian", paramString1, str2, "1", 1, 0, str1, "0", String.valueOf(paramInt3), paramString2);
        return;
        if (paramInt2 == -2000)
        {
          str1 = "2";
          break;
        }
        if (paramInt2 == -2005)
        {
          str1 = "3";
          break;
        }
        if (paramInt2 != -2011) {
          break;
        }
        str1 = "4";
        break;
        if (paramInt1 == 1024) {
          str2 = "0X8009810";
        } else if (paramInt1 == 1025) {
          str2 = "0X8009811";
        } else if (paramInt1 == 1000) {
          str2 = "0X800980E";
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    long l = awao.a();
    paramString1 = new aqax(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString2, paramInt, -5020, 1245187, l);
    paramString1.f = false;
    paramString1.a = l;
    paramString1.d = paramString3;
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    aqay.a(paramQQAppInterface, paramString2);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, msg_comm.Msg paramMsg, awbm paramawbm, Crm.CrmCCNotify paramCrmCCNotify)
  {
    int i = 0;
    if (paramList.isEmpty()) {}
    do
    {
      return;
      paramList = (MessageRecord)paramList.get(0);
    } while ((paramList == null) || (paramList.isSend()));
    long l = paramMsg.msg_head.from_uin.get();
    if (paramawbm == null) {}
    for (;;)
    {
      int j = paramMsg.msg_head.msg_time.get();
      paramMsg = paramCrmCCNotify.str_check_id.get();
      a(paramQQAppInterface, String.valueOf(l), i, paramList.msgtype, j, paramMsg);
      return;
      i = paramawbm.a;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<MessageRecord> paramList, im_msg_body.NotOnlineFile paramNotOnlineFile, msg_comm.Msg paramMsg, awbm paramawbm)
  {
    if ((paramNotOnlineFile == null) || (!paramNotOnlineFile.bytes_pb_reserve.has())) {
      return;
    }
    Object localObject = paramNotOnlineFile.bytes_pb_reserve.get().toByteArray();
    try
    {
      paramNotOnlineFile = new tencent_im_msg_hummer_resv_notonlinefile.ResvAttr();
      paramNotOnlineFile.mergeFrom((byte[])localObject);
      localObject = new Crm.CrmCCNotify();
      ((Crm.CrmCCNotify)localObject).mergeFrom(paramNotOnlineFile.bytes_crm_buf.get().toByteArray());
      if ((((Crm.CrmCCNotify)localObject).str_ext_nick_name.has()) && (!paramList.isEmpty())) {
        ((MessageRecord)paramList.get(0)).saveExtInfoToExtStr("qidian_ext_nick_name", ((Crm.CrmCCNotify)localObject).str_ext_nick_name.get());
      }
      a(paramQQAppInterface, (Crm.CrmCCNotify)localObject, paramMsg, paramawbm);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bcri
 * JD-Core Version:    0.7.0.1
 */