import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MediaChangePushInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.MediaUserInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11f.SubMsgType0x11f.MsgBody;

public class auzl
{
  private static String a = "ListenTogether.PushHelper";
  private static String b = "is_open_with_open";
  private static final String c = amtj.a(2131693351);
  private static final String d = amtj.a(2131693355);
  
  private static void a(int paramInt1, String paramString1, int paramInt2, String paramString2, aucf paramaucf)
  {
    Object localObject;
    if (paramInt2 == 31)
    {
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, String.format("dealGrayTipsJoin uinType=%d uin=%s subType=%d operUin=%s", new Object[] { Integer.valueOf(paramInt1), MobileQQ.getShortUinStr(paramString1), Integer.valueOf(paramInt2), paramString2 }));
      }
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ListenTogetherManager localListenTogetherManager = ListenTogetherManager.a((QQAppInterface)localObject);
      if (paramInt1 != 1) {
        break label188;
      }
      paramInt1 = 1;
      boolean bool = localListenTogetherManager.b(paramInt1, paramString1);
      paramString2 = bddg.a(16, auzn.a((QQAppInterface)localObject, paramString1, paramInt1, paramString2));
      localObject = BaseApplicationImpl.getApplication().getResources();
      if (!bool) {
        break label193;
      }
    }
    label188:
    label193:
    for (paramString1 = "";; paramString1 = " " + d)
    {
      paramString1 = ((Resources)localObject).getString(2131693376, new Object[] { paramString2, paramString1 });
      paramaucf.c = paramString1;
      paramInt1 = paramString1.indexOf(d);
      if (paramInt1 != -1)
      {
        paramString1 = new Bundle();
        paramString1.putInt("key_action", 59);
        paramaucf.a(paramInt1, d.length() + paramInt1, paramString1);
      }
      return;
      paramInt1 = 2;
      break;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, TroopTips0x857.MediaChangePushInfo paramMediaChangePushInfo)
  {
    if (paramMediaChangePushInfo != null)
    {
      Bundle localBundle = new Bundle();
      int i;
      label58:
      String str1;
      label82:
      String str2;
      label106:
      String str3;
      label130:
      long l1;
      if (paramMediaChangePushInfo.uint32_msg_type.has())
      {
        i = paramMediaChangePushInfo.uint32_msg_type.get();
        if (!paramMediaChangePushInfo.bytes_msg_info.has()) {
          break label367;
        }
        paramMediaChangePushInfo.bytes_msg_info.get().toStringUtf8();
        if (!paramMediaChangePushInfo.uint64_group_id.has()) {
          break label370;
        }
        str1 = String.valueOf(paramMediaChangePushInfo.uint64_group_id.get());
        if (!paramMediaChangePushInfo.uint64_oper_uin.has()) {
          break label377;
        }
        str2 = String.valueOf(paramMediaChangePushInfo.uint64_oper_uin.get());
        if (!paramMediaChangePushInfo.bytes_gray_tips.has()) {
          break label384;
        }
        str3 = paramMediaChangePushInfo.bytes_gray_tips.get().toStringUtf8();
        if (!paramMediaChangePushInfo.uint64_msg_seq.has()) {
          break label391;
        }
        l1 = paramMediaChangePushInfo.uint64_msg_seq.get();
        label151:
        if (!paramMediaChangePushInfo.uint32_join_nums.has()) {
          break label397;
        }
      }
      ListenTogetherManager localListenTogetherManager;
      label384:
      label391:
      label397:
      for (int j = paramMediaChangePushInfo.uint32_join_nums.get();; j = 0)
      {
        boolean bool = paramMediaChangePushInfo.is_join_when_start.get();
        localBundle.putBoolean(b, bool);
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "decodeGroupPush, msg_type = " + i + " groupUin = " + str1 + " oper_uin = " + str2 + " gray_tips = " + str3 + " timeStamp = " + l1 + " joinedNum = " + j + " isOpenWithJoin = " + bool);
        }
        localListenTogetherManager = (ListenTogetherManager)paramQQAppInterface.getManager(331);
        long l2 = localListenTogetherManager.a(1, str1);
        if (l1 >= l2) {
          break label403;
        }
        QLog.d(a, 1, String.format("decodeGroupPush, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, groupUin: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), str1 }));
        return;
        i = -1;
        break;
        label367:
        break label58;
        label370:
        str1 = "";
        break label82;
        label377:
        str2 = "";
        break label106;
        str3 = "";
        break label130;
        l1 = 0L;
        break label151;
      }
      label403:
      if ((i == 31) || (i == 32)) {
        localListenTogetherManager.a(1, str1, paramLong1, l1, auzn.a(1, j, 0));
      }
      Integer localInteger = null;
      if (i == 16) {
        localInteger = Integer.valueOf(paramMediaChangePushInfo.uint32_play_mode.get());
      }
      localListenTogetherManager.a(1, str1, paramLong1, str2, i, l1, localInteger);
      a(paramQQAppInterface, str1, 1, str3, i, str2, paramLong1, paramLong2, localBundle);
      return;
    }
    QLog.d(a, 1, "decodeGroupPush, pushInfo == null");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    int i1;
    int i;
    label28:
    int j;
    label43:
    int k;
    label70:
    int m;
    label87:
    boolean bool;
    int n;
    if (!TextUtils.isEmpty(paramString1))
    {
      i1 = 1;
      if (paramInt2 != 31) {
        break label146;
      }
      if (TextUtils.isEmpty(paramString3)) {
        break label140;
      }
      i = 1;
      if (paramInt2 != 31) {
        break label158;
      }
      if (paramInt1 != 1) {
        break label152;
      }
      j = 1;
      if (paramInt2 != 31) {
        break label170;
      }
      if (paramString3.equals(BaseApplicationImpl.getApplication().getRuntime().getAccount())) {
        break label164;
      }
      k = 1;
      if (paramInt2 == 31) {
        break label182;
      }
      if (TextUtils.isEmpty(paramString2)) {
        break label176;
      }
      m = 1;
      bool = paramBundle.getBoolean(b, false);
      if (paramInt2 != 31) {
        break label194;
      }
      if (bool) {
        break label188;
      }
      n = 1;
      label113:
      if ((n & i1 & i & j & k & m) != 0) {
        break label200;
      }
    }
    label140:
    label146:
    label152:
    label158:
    label164:
    label170:
    label176:
    label182:
    label188:
    label194:
    label200:
    do
    {
      return;
      i1 = 0;
      break;
      i = 0;
      break label28;
      i = 1;
      break label28;
      j = 0;
      break label43;
      j = 1;
      break label43;
      k = 0;
      break label70;
      k = 1;
      break label70;
      m = 0;
      break label87;
      m = 1;
      break label87;
      n = 0;
      break label113;
      n = 1;
      break label113;
      if (QLog.isColorLevel()) {
        QLog.i(a, 2, "insertGrayTips begin uin:" + paramString1 + " uinType:" + paramInt1 + " grayTips:" + paramString2 + " sub_type:" + paramInt2 + " operUin:" + paramString3 + " msgSeq:" + paramLong1 + " msgTime:" + paramLong2);
      }
      i = -5020;
      if ((paramInt2 == 1) || (paramInt2 == 3) || (paramInt2 == 2) || (paramInt2 == 4)) {
        i = -5040;
      }
      paramBundle = new aucf(paramString1, paramString1, paramString2, paramInt1, i, 131083, bbko.a());
      a(paramString2, paramInt2, paramBundle);
      a(paramInt1, paramString1, paramInt2, paramString3, paramBundle);
      paramString2 = new MessageForUniteGrayTip();
      paramString2.hasRead = 0;
      paramString2.subType = paramInt2;
      paramString2.initGrayTipMsg(paramQQAppInterface, paramBundle);
      paramString2.tipParam.d = (paramString1 + "_" + paramInt1 + "_listen_together_" + paramLong1 + "_" + paramLong2);
      bool = aucg.a(paramQQAppInterface, paramString2);
    } while (!QLog.isColorLevel());
    QLog.i(a, 2, "insertGrayTips end  res:" + bool + " grayTipKey:" + paramString2.tipParam.d);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str2 = paramQQAppInterface.getCurrentAccountUin();
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "decodePush0x210_0x11f, msgSeq = " + paramLong1 + " msgTime = " + paramLong2 + " selfUin:" + str2 + " isOffline = " + paramBoolean);
    }
    SubMsgType0x11f.MsgBody localMsgBody;
    int i;
    String str1;
    long l1;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((paramArrayOfByte != null) && (!TextUtils.isEmpty(str2)))
    {
      try
      {
        localMsgBody = new SubMsgType0x11f.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        i = localMsgBody.uint32_msg_type.get();
        str1 = String.valueOf(localMsgBody.uint64_oper_uin.get());
        if (!localMsgBody.uint64_msg_seq.has()) {
          break label765;
        }
        l1 = localMsgBody.uint64_msg_seq.get();
        localObject2 = "";
        localObject3 = "";
        Object localObject4 = localMsgBody.rpt_msg_media_uin.get();
        paramArrayOfByte = (byte[])localObject2;
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          paramArrayOfByte = (byte[])localObject2;
          localObject1 = localObject3;
          if (((List)localObject4).size() > 0)
          {
            localObject3 = ((List)localObject4).iterator();
            localObject1 = "";
            paramArrayOfByte = "";
            label212:
            if (!((Iterator)localObject3).hasNext()) {
              break label781;
            }
            localObject4 = (SubMsgType0x11f.MediaUserInfo)((Iterator)localObject3).next();
            localObject2 = String.valueOf(((SubMsgType0x11f.MediaUserInfo)localObject4).uint64_to_uin.get());
            int j = ((SubMsgType0x11f.MediaUserInfo)localObject4).uint32_join_state.get();
            if (!str2.equals(localObject2)) {
              break label771;
            }
            localObject2 = auzn.a(2, 0, j);
            localObject1 = paramArrayOfByte;
            paramArrayOfByte = (byte[])localObject2;
            break label752;
          }
        }
        label285:
        localObject2 = localMsgBody.bytes_gray_tips.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.i(a, 2, "decodePush0x210_0x11f, msg_type = " + i + " friend_uin = " + paramArrayOfByte + " oper_uin = " + str1 + " gray_tips = " + (String)localObject2 + " timeStamp = " + l1 + " statusTips = " + (String)localObject1);
        }
        if ((TextUtils.isEmpty(paramArrayOfByte)) || (TextUtils.isEmpty(str1)))
        {
          QLog.d(a, 1, "filter friendUin: " + paramArrayOfByte + ", operatorUin: " + str1);
          return;
        }
      }
      catch (Throwable paramQQAppInterface)
      {
        QLog.i(a, 1, "decodePush0x210_0x11f decode error, e=" + paramQQAppInterface.toString());
        return;
      }
      if (paramBoolean)
      {
        if ((i != 1) && (i != 2) && (i != 3) && (i != 4))
        {
          QLog.d(a, 1, "filter offline msg, msgType:" + i);
          return;
        }
        l2 = paramQQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp17", 0L);
        if (l1 / 1000L < l2)
        {
          QLog.d(a, 1, String.format("filter offline msg, timestamp: %s < incUpdateTimeStamp: %s", new Object[] { Long.valueOf(l1 / 1000L), Long.valueOf(l2) }));
          return;
        }
      }
      localObject3 = (ListenTogetherManager)paramQQAppInterface.getManager(331);
      long l2 = ((ListenTogetherManager)localObject3).a(2, paramArrayOfByte);
      if (l1 > l2) {
        break label784;
      }
      QLog.d(a, 1, String.format("decodePush0x210_0x11f, filter oldTimeStamp: %s, timeStamp: %s, msyType: %s, friendUin: %s", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i), paramArrayOfByte }));
    }
    label771:
    label781:
    label784:
    for (;;)
    {
      label667:
      ((ListenTogetherManager)localObject3).a(2, paramArrayOfByte, paramLong1, l1, (String)localObject1);
      label752:
      label765:
      do
      {
        localObject1 = null;
        if (i == 16) {
          localObject1 = Integer.valueOf(localMsgBody.uint32_play_mode.get());
        }
        ((ListenTogetherManager)localObject3).a(2, paramArrayOfByte, paramLong1, str1, i, l1, localObject1);
        a(paramQQAppInterface, paramArrayOfByte, 0, (String)localObject2, i, str1, paramLong1, paramLong2, new Bundle());
        return;
        QLog.i(a, 1, "decodePush0x210_0x11f pbData = null");
        return;
        for (;;)
        {
          localObject2 = localObject1;
          localObject1 = paramArrayOfByte;
          paramArrayOfByte = (byte[])localObject2;
          break label212;
          l1 = 0L;
          break;
          paramArrayOfByte = (byte[])localObject1;
          localObject1 = localObject2;
        }
        break label285;
        if (i == 31) {
          break label667;
        }
      } while (i != 32);
    }
  }
  
  private static void a(String paramString, int paramInt, aucf paramaucf)
  {
    if ((paramInt == 1) || (paramInt == 3))
    {
      paramInt = paramString.indexOf(c);
      if (paramInt != -1)
      {
        paramString = new Bundle();
        paramString.putInt("key_action", 46);
        paramaucf.a(paramInt, paramInt + 4, paramString);
      }
    }
    else
    {
      return;
    }
    QLog.d(a, 1, String.format("grayTips: %s don't contain keyword", new Object[] { paramString }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzl
 * JD-Core Version:    0.7.0.1
 */