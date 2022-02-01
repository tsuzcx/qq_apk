import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;

public class aolc
{
  private static void a(int paramInt, Friends paramFriends, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem)
  {
    int i = 0;
    if (paramInt != 13824) {}
    do
    {
      return;
      paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toByteArray();
      paramInt = i;
      if (paramSnsUpdateItem != null)
      {
        paramInt = i;
        if (paramSnsUpdateItem.length >= 1)
        {
          i = paramSnsUpdateItem[0] & 0x2;
          paramInt = i;
          if (i == 2)
          {
            paramFriends.friendType = 1;
            paramInt = i;
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler.SnsDataUtil", 2, "updateQimFriend | friend.uin : " + paramFriends.uin + " | friend.friendType : " + paramFriends.friendType + " | itemType : " + paramInt);
  }
  
  private static void a(int paramInt, SpecialCareInfo paramSpecialCareInfo, String paramString)
  {
    if (paramInt != 13572) {}
    do
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramString)) {
          break;
        }
        paramSpecialCareInfo.qzoneSwitch = 0;
        return;
      }
      catch (Exception paramSpecialCareInfo) {}
    } while (!QLog.isColorLevel());
    QLog.w("FriendListHandler.SnsDataUtil", 2, "updateSpecialCareZoneSwitch initSpecialCareInfo|exception = ", paramSpecialCareInfo);
    return;
    paramSpecialCareInfo.qzoneSwitch = 1;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, ExtensionInfo paramExtensionInfo, Friends paramFriends, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem)
  {
    if (paramInt != 13579) {
      return;
    }
    String str = new String(paramSnsUpdateItem.bytes_value.get().toByteArray());
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.SnsDataUtil", 2, new Object[] { "updateDontDisturb, friend.uin=", paramFriends.uin, " setTime=", str });
    }
    paramFriends = new FriendsStatusUtil.UpdateFriendStatusItem(paramFriends.uin, 13579, 19);
    paramFriends.b(paramSnsUpdateItem.bytes_value.get().toByteArray());
    FriendsStatusUtil.a(paramQQAppInterface, paramFriends, paramExtensionInfo);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString)
  {
    if (paramInt != 13582) {}
    do
    {
      return;
      paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toByteArray();
      FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13582, 21);
      localUpdateFriendStatusItem.b(paramSnsUpdateItem);
      FriendsStatusUtil.a(paramQQAppInterface, localUpdateFriendStatusItem, paramExtensionInfo);
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler.SnsDataUtil", 2, new Object[] { "updateNotificationSetting: invoked. inc update notification switch::preview & vibrate", " uinStr: ", paramString });
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SpecialCareInfo paramSpecialCareInfo, String paramString1, String paramString2, Set<String> paramSet, List<String> paramList1, List<String> paramList2)
  {
    if (paramInt != 13573) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (!TextUtils.isEmpty(paramString2)) {
            break label86;
          }
          paramSpecialCareInfo.globalSwitch = 0;
          if ((paramSet != null) && (paramSet.contains(paramString1))) {
            paramList1.add(paramString1);
          }
          if ((paramList2 != null) && (amci.b(paramString1, paramQQAppInterface)))
          {
            paramList2.add(paramString1);
            return;
          }
        }
        catch (Exception paramQQAppInterface) {}
      }
    } while (!QLog.isColorLevel());
    QLog.w("FriendListHandler.SnsDataUtil", 2, "updateSpecialCareGlobalSwitch initSpecialCareInfo|exception = ", paramQQAppInterface);
    return;
    label86:
    paramSpecialCareInfo.globalSwitch = 1;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, SpecialCareInfo paramSpecialCareInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString1, String paramString2)
  {
    if (paramInt != 13568) {}
    for (;;)
    {
      return;
      amci.a(paramString2, paramSnsUpdateItem.bytes_value.get().toStringUtf8(), paramQQAppInterface);
      try
      {
        if (TextUtils.isEmpty(paramString1)) {
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler.SnsDataUtil", 2, new Object[] { "updateSpecialCareSoundSingle: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " specialCareInfo: ", paramSpecialCareInfo });
          return;
          if (Pattern.compile("[0-9]*").matcher(paramString1).matches())
          {
            paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString1);
            paramSpecialCareInfo.specialRingSwitch = 1;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("FriendListHandler.SnsDataUtil", 2, "updateSpecialCareSoundSingle initSpecialCareInfo|exception = ", paramQQAppInterface);
          }
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Map<String, Boolean> paramMap, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, ExtensionInfo paramExtensionInfo, String paramString, boolean paramBoolean)
  {
    if (paramInt != 13581) {}
    boolean bool;
    label75:
    do
    {
      return;
      if (!TextUtils.isEmpty(paramSnsUpdateItem.bytes_value.get().toStringUtf8()))
      {
        bool = true;
        if (paramBoolean) {
          continue;
        }
        paramSnsUpdateItem = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13581, 21);
        if (!bool) {
          break label75;
        }
      }
      for (paramMap = new byte[1];; paramMap = null)
      {
        paramSnsUpdateItem.a(paramMap);
        FriendsStatusUtil.a(paramQQAppInterface, paramSnsUpdateItem, paramExtensionInfo);
        return;
        bool = false;
        break;
      }
    } while (paramMap == null);
    paramMap.put(paramString, Boolean.valueOf(bool));
  }
  
  private static void a(QQAppInterface paramQQAppInterface, int paramInt, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString1, String paramString2, Set<String> paramSet, List<String> paramList1, List<String> paramList2, Map<String, Integer> paramMap, List<String> paramList3, SpecialCareInfo paramSpecialCareInfo)
  {
    if (paramInt != 13568) {}
    for (;;)
    {
      return;
      paramSnsUpdateItem = paramSnsUpdateItem.bytes_value.get().toStringUtf8();
      if ((paramSnsUpdateItem == null) || (paramSnsUpdateItem.length() == 0))
      {
        if ((paramSet != null) && (paramSet.contains(paramString1))) {
          paramList2.add(paramString1);
        }
        if (amci.b(paramString1, paramQQAppInterface)) {
          paramList3.add(paramString1);
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler.SnsDataUtil", 2, new Object[] { "updateSpecialCareSoundBatch: invoked. should turn off sound", " uinStr: ", paramString1 });
        }
      }
      try
      {
        label102:
        if (TextUtils.isEmpty(paramString2)) {
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
        while (QLog.isColorLevel())
        {
          for (;;)
          {
            QLog.d("FriendListHandler.SnsDataUtil", 2, new Object[] { "updateSpecialCareSoundBatch: invoked(旧的特别关心铃声和开关，不需要同步到新的开关上，新开关仅适用0x350e). friendlist::ring switch & id", " info: ", paramSpecialCareInfo, " info.friendRingId: ", Integer.valueOf(paramSpecialCareInfo.friendRingId), " info.uin: ", paramSpecialCareInfo.uin });
            return;
            try
            {
              paramInt = Integer.parseInt(paramSnsUpdateItem);
              paramList1.add(paramString1);
              paramMap.put(paramString1, Integer.valueOf(paramInt));
            }
            catch (Exception paramQQAppInterface) {}
          }
          if (!QLog.isColorLevel()) {
            break label102;
          }
          QLog.i("FriendListHandler.SnsDataUtil", 2, "updateSpecialCareSoundBatch dealWithRespSound|exception = " + paramQQAppInterface.toString());
          break label102;
          if (Pattern.compile("[0-9]*").matcher(paramString2).matches())
          {
            paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString2);
            paramSpecialCareInfo.specialRingSwitch = 1;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("FriendListHandler.SnsDataUtil", 2, "updateSpecialCareSoundBatch initSpecialCareInfo|exception = ", paramQQAppInterface);
          }
          paramSpecialCareInfo.specialRingSwitch = 0;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo, Friends paramFriends, SpecialCareInfo paramSpecialCareInfo, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler.SnsDataUtil", 2, String.format("updateSnsDataSingle friendUin=%s", new Object[] { paramFriends.uin }));
    }
    Object localObject = new Oidb_0x5d0.SnsUpateBuffer();
    try
    {
      ((Oidb_0x5d0.SnsUpateBuffer)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_update_item.has())) {
        break label357;
      }
      localObject = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject).next();
        if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()))
        {
          paramSpecialCareInfo.uin = paramFriends.uin;
          paramSpecialCareInfo.dateTime = paramLong;
          int i = localSnsUpdateItem.uint32_update_sns_type.get();
          String str1 = localSnsUpdateItem.bytes_value.get().toStringUtf8();
          String str2 = String.valueOf(paramArrayOfByte.uint64_uin.get());
          a(paramQQAppInterface, i, paramSpecialCareInfo, localSnsUpdateItem, str1, str2);
          b(paramQQAppInterface, i, paramExtensionInfo, paramFriends, localSnsUpdateItem);
          a(paramQQAppInterface, i, paramExtensionInfo, paramFriends, localSnsUpdateItem);
          a(paramQQAppInterface, i, paramSpecialCareInfo, str2, str1, null, null, null);
          a(i, paramSpecialCareInfo, str1);
          a(i, paramExtensionInfo, localSnsUpdateItem, str2);
          a(paramQQAppInterface, i, null, localSnsUpdateItem, paramExtensionInfo, str2, false);
          a(paramQQAppInterface, i, paramExtensionInfo, localSnsUpdateItem, str2);
          b(paramQQAppInterface, i, paramExtensionInfo, localSnsUpdateItem, str2);
        }
      }
      label357:
      paramArrayOfByte = paramFriends.uin;
      if (!amci.a(paramArrayOfByte, paramQQAppInterface)) {
        break label375;
      }
      amci.b(paramArrayOfByte, paramQQAppInterface);
      label375:
      if (!amci.b(paramArrayOfByte, paramQQAppInterface)) {
        return;
      }
      amci.c(paramArrayOfByte, paramQQAppInterface);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_uin32_idlist.has()))
    {
      localObject = paramArrayOfByte.rpt_uin32_idlist.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Integer)((Iterator)localObject).next()).intValue() == 4051) {
          paramFriends.setShieldFlag(true);
        }
      }
    }
  }
  
  private static boolean a(int paramInt, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString)
  {
    if (paramInt != 13575) {
      return false;
    }
    return FriendListHandler.updateSnsData_HOT_FRIEND_CHAT_LEVEL_TYPE(paramString, paramSnsUpdateItem.bytes_value.get().toByteArray(), paramExtensionInfo);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo, Friends paramFriends, Set<String> paramSet, List<String> paramList1, List<String> paramList2, Map<String, Integer> paramMap, List<String> paramList3, Map<String, Boolean> paramMap1, SpecialCareInfo paramSpecialCareInfo, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler.SnsDataUtil", 2, String.format("updateSnsDataBatch friendUin=%s", new Object[] { paramFriends.uin }));
    }
    boolean bool1 = false;
    Object localObject = new Oidb_0x5d0.SnsUpateBuffer();
    try
    {
      ((Oidb_0x5d0.SnsUpateBuffer)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_update_item.has())) {
        break label409;
      }
      localObject = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
      boolean bool2;
      for (bool1 = false; ((Iterator)localObject).hasNext(); bool1 = bool2)
      {
        Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject).next();
        bool2 = bool1;
        if (localSnsUpdateItem != null)
        {
          bool2 = bool1;
          if (localSnsUpdateItem.uint32_update_sns_type.has())
          {
            bool2 = bool1;
            if (localSnsUpdateItem.bytes_value.has())
            {
              paramSpecialCareInfo.uin = paramFriends.uin;
              paramSpecialCareInfo.dateTime = paramLong;
              int i = localSnsUpdateItem.uint32_update_sns_type.get();
              String str1 = localSnsUpdateItem.bytes_value.get().toStringUtf8();
              String str2 = String.valueOf(paramArrayOfByte.uint64_uin.get());
              a(paramQQAppInterface, i, localSnsUpdateItem, str2, str1, paramSet, paramList1, paramList2, paramMap, paramList3, paramSpecialCareInfo);
              b(paramQQAppInterface, i, paramExtensionInfo, localSnsUpdateItem, str2);
              a(paramQQAppInterface, i, paramExtensionInfo, localSnsUpdateItem, str2);
              b(paramQQAppInterface, i, paramExtensionInfo, paramFriends, localSnsUpdateItem);
              a(paramQQAppInterface, i, paramExtensionInfo, paramFriends, localSnsUpdateItem);
              a(i, paramFriends, localSnsUpdateItem);
              a(paramQQAppInterface, i, paramSpecialCareInfo, str2, str1, paramSet, paramList2, paramList3);
              a(i, paramSpecialCareInfo, str1);
              bool2 = bool1 | a(i, paramExtensionInfo, localSnsUpdateItem, str2);
              a(paramQQAppInterface, i, paramMap1, localSnsUpdateItem, paramExtensionInfo, str2, true);
            }
          }
        }
      }
      do
      {
        return bool1;
        paramArrayOfByte = paramFriends.uin;
        if ((paramSet != null) && (paramSet.contains(paramArrayOfByte))) {
          paramList2.add(paramArrayOfByte);
        }
      } while (!amci.b(paramArrayOfByte, paramQQAppInterface));
      paramList3.add(paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_uin32_idlist.has()))
    {
      localObject = paramArrayOfByte.rpt_uin32_idlist.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Integer)((Iterator)localObject).next()).intValue() == 4051) {
          paramFriends.setShieldFlag(true);
        }
      }
    }
    label409:
    return false;
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt, ExtensionInfo paramExtensionInfo, Friends paramFriends, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem)
  {
    if (paramInt != 13578) {
      return;
    }
    paramFriends = new FriendsStatusUtil.UpdateFriendStatusItem(paramFriends.uin, 13578, 18);
    if (!paramSnsUpdateItem.bytes_value.has()) {
      paramFriends.a(null);
    }
    for (;;)
    {
      FriendsStatusUtil.a(paramQQAppInterface, paramFriends, paramExtensionInfo);
      return;
      paramFriends.a(paramSnsUpdateItem.bytes_value.get().toByteArray());
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, int paramInt, ExtensionInfo paramExtensionInfo, Oidb_0x5d0.SnsUpdateItem paramSnsUpdateItem, String paramString)
  {
    if (paramInt != 13580) {}
    do
    {
      return;
      FriendsStatusUtil.UpdateFriendStatusItem localUpdateFriendStatusItem = new FriendsStatusUtil.UpdateFriendStatusItem(paramString, 13580, 21);
      if (paramSnsUpdateItem.bytes_value.has())
      {
        localUpdateFriendStatusItem.b(paramSnsUpdateItem.bytes_value.get().toByteArray());
        FriendsStatusUtil.a(paramQQAppInterface, localUpdateFriendStatusItem, paramExtensionInfo);
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler.SnsDataUtil", 2, new Object[] { "updateRingId: invoked. UPDATE_SNS_TYPE_RING_ID uin:", paramString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolc
 * JD-Core Version:    0.7.0.1
 */