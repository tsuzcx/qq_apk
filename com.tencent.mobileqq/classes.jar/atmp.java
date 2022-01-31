import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MediaChangePushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.MediaUserInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.MsgBody;

public class atmp
{
  private static String a = "ListenTogether.PushHelper";
  private static final String b = alud.a(2131693938);
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, TroopTips0x857.MediaChangePushInfo paramMediaChangePushInfo)
  {
    if (paramMediaChangePushInfo != null)
    {
      int i;
      label49:
      String str1;
      label73:
      String str2;
      label97:
      String str3;
      label121:
      long l1;
      label142:
      int j;
      label163:
      ListenTogetherManager localListenTogetherManager;
      if (paramMediaChangePushInfo.uint32_msg_type.has())
      {
        i = paramMediaChangePushInfo.uint32_msg_type.get();
        if (!paramMediaChangePushInfo.bytes_msg_info.has()) {
          break label328;
        }
        paramMediaChangePushInfo.bytes_msg_info.get().toStringUtf8();
        if (!paramMediaChangePushInfo.uint64_group_id.has()) {
          break label331;
        }
        str1 = String.valueOf(paramMediaChangePushInfo.uint64_group_id.get());
        if (!paramMediaChangePushInfo.uint64_oper_uin.has()) {
          break label338;
        }
        str2 = String.valueOf(paramMediaChangePushInfo.uint64_oper_uin.get());
        if (!paramMediaChangePushInfo.bytes_gray_tips.has()) {
          break label345;
        }
        str3 = paramMediaChangePushInfo.bytes_gray_tips.get().toStringUtf8();
        if (!paramMediaChangePushInfo.uint64_msg_seq.has()) {
          break label352;
        }
        l1 = paramMediaChangePushInfo.uint64_msg_seq.get();
        if (!paramMediaChangePushInfo.uint32_join_nums.has()) {
          break label358;
        }
        j = paramMediaChangePushInfo.uint32_join_nums.get();
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "decodeGroupPush, msg_type = " + i + " groupUin = " + str1 + " oper_uin = " + str2 + " gray_tips = " + str3 + " timeStamp = " + l1 + " joinedNum = " + j);
        }
        localListenTogetherManager = (ListenTogetherManager)paramQQAppInterface.getManager(331);
        long l2 = localListenTogetherManager.a(1, str1);
        if (l1 >= l2) {
          break label364;
        }
        QLog.d(a, 1, String.format("decodeGroupPush, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, groupUin: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), str1 }));
      }
      label328:
      label331:
      label338:
      label345:
      label352:
      label358:
      label364:
      do
      {
        return;
        i = -1;
        break;
        break label49;
        str1 = "";
        break label73;
        str2 = "";
        break label97;
        str3 = "";
        break label121;
        l1 = 0L;
        break label142;
        j = 0;
        break label163;
        if ((i == 31) || (i == 32))
        {
          localListenTogetherManager.a(1, str1, paramLong1, l1, atmr.a(1, j, 0));
          return;
        }
        Integer localInteger = null;
        if (i == 16) {
          localInteger = Integer.valueOf(paramMediaChangePushInfo.uint32_play_mode.get());
        }
        localListenTogetherManager.a(1, str1, paramLong1, str2, i, l1, localInteger);
      } while ((TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(str1)));
      a(paramQQAppInterface, str1, 1, str3, i, paramLong1, paramLong2);
      return;
    }
    QLog.d(a, 1, "decodeGroupPush, pushInfo == null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "insertGrayTips begin uin:" + paramString1 + " uinType:" + paramInt1 + " grayTips:" + paramString2 + " sub_type:" + paramInt2 + " msgSeq:" + paramLong1 + " msgTime:" + paramLong2);
    }
    if ((TextUtils.isEmpty(paramString2)) || ("0".equals(paramString1))) {
      return;
    }
    int i = -5020;
    if ((paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 2) || (paramInt2 == 4)) {
      i = -5040;
    }
    aspy localaspy = new aspy(paramString1, paramString1, paramString2, paramInt1, i, 131083, ayzl.a());
    if ((paramInt2 == 1) || (paramInt2 == 3))
    {
      i = paramString2.indexOf(b);
      if (i == -1) {
        break label339;
      }
      paramString2 = new Bundle();
      paramString2.putInt("key_action", 46);
      localaspy.a(i, i + 4, paramString2);
    }
    for (;;)
    {
      paramString2 = new MessageForUniteGrayTip();
      paramString2.hasRead = 0;
      paramString2.subType = paramInt2;
      paramString2.initGrayTipMsg(paramQQAppInterface, localaspy);
      paramString2.tipParam.d = (paramString1 + "_" + paramInt1 + "_listen_together_" + paramLong1 + "_" + paramLong2);
      boolean bool = aspz.a(paramQQAppInterface, paramString2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i(a, 2, "insertGrayTips end  res:" + bool + " grayTipKey:" + paramString2.tipParam.d);
      return;
      label339:
      QLog.d(a, 1, String.format("grayTips: %s don't contain keyword", new Object[] { paramString2 }));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    String str1;
    if (paramQQAppInterface != null) {
      str1 = paramQQAppInterface.getCurrentAccountUin();
    }
    SubMsgType0x11f.MsgBody localMsgBody;
    int i;
    String str2;
    long l1;
    label148:
    Object localObject1;
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "decodePush0x210_0x11f, msgSeq = " + paramLong1 + " msgTime = " + paramLong2 + " selfUin:" + str1 + " isOffline = " + paramBoolean);
      }
      if ((paramArrayOfByte == null) || (TextUtils.isEmpty(str1))) {
        break label773;
      }
      try
      {
        localMsgBody = new SubMsgType0x11f.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        i = localMsgBody.uint32_msg_type.get();
        str2 = String.valueOf(localMsgBody.uint64_oper_uin.get());
        if (localMsgBody.uint64_msg_seq.has())
        {
          l1 = localMsgBody.uint64_msg_seq.get();
          localObject2 = "";
          Object localObject3 = "";
          Object localObject4 = localMsgBody.rpt_msg_media_uin.get();
          paramArrayOfByte = (byte[])localObject2;
          localObject1 = localObject3;
          if (localObject4 == null) {
            break label317;
          }
          paramArrayOfByte = (byte[])localObject2;
          localObject1 = localObject3;
          if (((List)localObject4).size() <= 0) {
            break label317;
          }
          localObject3 = ((List)localObject4).iterator();
          localObject1 = "";
          paramArrayOfByte = (byte[])localObject2;
          label211:
          if (!((Iterator)localObject3).hasNext()) {
            break label317;
          }
          localObject4 = (SubMsgType0x11f.MediaUserInfo)((Iterator)localObject3).next();
          localObject2 = String.valueOf(((SubMsgType0x11f.MediaUserInfo)localObject4).uint64_to_uin.get());
          int j = ((SubMsgType0x11f.MediaUserInfo)localObject4).uint32_join_state.get();
          if (!str1.equals(localObject2)) {
            break label307;
          }
          localObject2 = atmr.a(2, 0, j);
          localObject1 = paramArrayOfByte;
          paramArrayOfByte = (byte[])localObject2;
        }
        for (;;)
        {
          localObject2 = localObject1;
          localObject1 = paramArrayOfByte;
          paramArrayOfByte = (byte[])localObject2;
          break label211;
          str1 = "";
          break;
          l1 = 0L;
          break label148;
          label307:
          paramArrayOfByte = (byte[])localObject1;
          localObject1 = localObject2;
        }
        label317:
        str1 = localMsgBody.bytes_gray_tips.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "decodePush0x210_0x11f, msg_type = " + i + " friend_uin = " + paramArrayOfByte + " oper_uin = " + str2 + " gray_tips = " + str1 + " timeStamp = " + l1 + " statusTips = " + (String)localObject1);
        }
        if ((TextUtils.isEmpty(paramArrayOfByte)) || (TextUtils.isEmpty(str2)))
        {
          QLog.d(a, 1, "filter friendUin: " + paramArrayOfByte + ", operatorUin: " + str2);
          return;
        }
        if (!paramBoolean) {
          break label624;
        }
        if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
        {
          QLog.d(a, 1, "filter offline msg, msgType:" + i);
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.i(a, 1, "decodePush0x210_0x11f decode error, e=" + paramQQAppInterface.toString());
        return;
      }
    }
    long l2 = paramQQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp17", 0L);
    if (l1 / 1000L < l2)
    {
      QLog.d(a, 1, String.format("filter offline msg, timestamp: %s < incUpdateTimeStamp: %s", new Object[] { Long.valueOf(l1 / 1000L), Long.valueOf(l2) }));
      return;
    }
    label624:
    Object localObject2 = (ListenTogetherManager)paramQQAppInterface.getManager(331);
    l2 = ((ListenTogetherManager)localObject2).a(2, paramArrayOfByte);
    if (l1 <= l2)
    {
      QLog.d(a, 1, String.format("decodePush0x210_0x11f, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, friendUin: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramArrayOfByte }));
      return;
    }
    for (;;)
    {
      ((ListenTogetherManager)localObject2).a(2, paramArrayOfByte, paramLong1, l1, (String)localObject1);
      return;
      label773:
      do
      {
        localObject1 = null;
        if (i == 16) {
          localObject1 = Integer.valueOf(localMsgBody.uint32_play_mode.get());
        }
        ((ListenTogetherManager)localObject2).a(2, paramArrayOfByte, paramLong1, str2, i, l1, localObject1);
        if (!TextUtils.isEmpty(str1))
        {
          a(paramQQAppInterface, paramArrayOfByte, 0, str1, i, paramLong1, paramLong2);
          return;
          QLog.i(a, 1, "decodePush0x210_0x11f pbData = null");
        }
        return;
        if (i == 31) {
          break;
        }
      } while (i != 32);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmp
 * JD-Core Version:    0.7.0.1
 */