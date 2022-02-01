import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ContentItem;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.FriendRemark;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.FriendTeamList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GenderFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GeneralBuffer;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.GroupName;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.NickNameFiled;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileInfo;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileListResult;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ProfileTvInfo;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ReqBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.RspBody;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.UpdateProfileList;
import tencent.im.oidb.cmd0x5e0.Oidb_0x5e0.ValueBit;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ExtSnsFrdData;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.MutualMarkData;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.ReqBody;
import tencent.intimate_relation.intimate_relation.IntimateInfo;

public class amzf
  implements bbnm
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
  
  public amzf(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "775_hot_friend_new_boat_clear_version");
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "top_position_and_disturb_clear_version");
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "check_message_preview_version_clear");
  }
  
  public static void a(long paramLong, String paramString, amrb paramamrb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoName uin = " + paramLong + ",nickName = " + paramString);
    }
    Object localObject = paramamrb.a();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramamrb.a(localDiscussionInfo.uin, Long.toString(paramLong));
        if ((localDiscussionMemberInfo != null) && (a(paramString, localDiscussionMemberInfo.memberName)))
        {
          localDiscussionMemberInfo.memberName = paramString;
          if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoName discussMem.memberName = " + localDiscussionMemberInfo.memberName + ",discussMem.inteRemark = " + localDiscussionMemberInfo.inteRemark + ",discussionUin = " + localDiscussionInfo.uin);
          }
          localArrayList.add(localDiscussionMemberInfo);
        }
      }
      if (localArrayList.size() > 0)
      {
        paramamrb.b(localArrayList);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(localArrayList.size()));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "updateDiscussMemberNick", true, 0L, 0L, paramString, "", true);
      }
    }
  }
  
  private void a(amsw paramamsw, Friends[] paramArrayOfFriends, int paramInt, ArrayList<Friends> paramArrayList)
  {
    Object localObject = paramamsw.d();
    paramamsw = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Friends localFriends = (Friends)((Iterator)localObject).next();
      if ((localFriends.isShield()) && (!paramamsw.containsKey(localFriends.uin)))
      {
        localFriends.setShieldFlag(false);
        paramArrayList.add(localFriends);
      }
      else if ((!localFriends.isShield()) && (paramamsw.containsKey(localFriends.uin)))
      {
        localFriends.setShieldFlag(true);
        paramArrayList.add(localFriends);
      }
    }
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfFriends[i] != null) {
        paramArrayList.add(paramArrayOfFriends[i]);
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQProfileItem", 2, "checkNewBoatUpdateVersion");
      }
      paramQQAppInterface = paramQQAppInterface.getPreferences();
      if (!paramQQAppInterface.getBoolean(paramString, false))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQProfileItem", 2, "checkNewBoatUpdateVersion clear");
        }
        paramQQAppInterface = paramQQAppInterface.edit();
        paramQQAppInterface.putBoolean(paramString, true);
        paramQQAppInterface.putLong("inccheckupdatetimeStamp9", 0L);
        paramQQAppInterface.commit();
      }
    }
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new String();
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, "len = " + paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfByte[i];
      int k = paramArrayOfByte[i];
      String str = (String)localObject + "0123456789ABCDEF".charAt(j >> 4 & 0xF) + "" + "0123456789ABCDEF".charAt(k & 0xF) + " ";
      localObject = str;
      if ((i + 1) % 8 == 0)
      {
        str = str + " ";
        localObject = str;
        if ((i + 1) % 16 == 0)
        {
          if (QLog.isColorLevel()) {
            localStringBuilder.append(str + "\n");
          }
          localObject = "";
        }
      }
      i += 1;
    }
    QLog.d(paramString, 2, localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, (String)localObject);
    }
  }
  
  /* Error */
  private void a(ArrayList<TroopInfo> paramArrayList, amsw paramamsw, TroopManager paramTroopManager)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 119	java/util/ArrayList:size	()I
    //   4: ifle +51 -> 55
    //   7: aload_2
    //   8: invokevirtual 255	amsw:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 260	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   16: aload_1
    //   17: invokevirtual 71	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   20: astore_1
    //   21: aload_1
    //   22: invokeinterface 76 1 0
    //   27: ifeq +29 -> 56
    //   30: aload_3
    //   31: aload_1
    //   32: invokeinterface 80 1 0
    //   37: checkcast 262	com/tencent/mobileqq/data/troop/TroopInfo
    //   40: invokevirtual 267	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   43: goto -22 -> 21
    //   46: astore_1
    //   47: aload_1
    //   48: invokevirtual 270	java/lang/Exception:printStackTrace	()V
    //   51: aload_2
    //   52: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   55: return
    //   56: aload_2
    //   57: invokevirtual 275	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   60: aload_2
    //   61: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   64: return
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	amzf
    //   0	72	1	paramArrayList	ArrayList<TroopInfo>
    //   0	72	2	paramamsw	amsw
    //   0	72	3	paramTroopManager	TroopManager
    // Exception table:
    //   from	to	target	type
    //   12	21	46	java/lang/Exception
    //   21	43	46	java/lang/Exception
    //   56	60	46	java/lang/Exception
    //   12	21	65	finally
    //   21	43	65	finally
    //   47	51	65	finally
    //   56	60	65	finally
  }
  
  private void a(ArrayList<Friends> paramArrayList1, ArrayList<Friends> paramArrayList2)
  {
    amrb localamrb = (amrb)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53);
    Object localObject;
    if (paramArrayList1.size() > 0)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        localObject = (Friends)paramArrayList1.next();
        String str = ((Friends)localObject).name;
        a(Long.parseLong(((Friends)localObject).uin), str, localamrb);
      }
    }
    if (paramArrayList2.size() > 0)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (Friends)paramArrayList1.next();
        localObject = paramArrayList2.remark;
        b(Long.parseLong(paramArrayList2.uin), (String)localObject, localamrb);
      }
    }
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, amsw paramamsw, ArrayList<SpecialCareInfo> paramArrayList, Map<String, Boolean> paramMap, ArrayList<String> paramArrayList1)
  {
    Object localObject1 = paramSnsUpateBuffer.rpt_msg_sns_update_item.get();
    Object localObject2 = null;
    long l = paramSnsUpateBuffer.uint64_uin.get();
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
      if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()))
      {
        if (localSnsUpdateItem.uint32_update_sns_type.get() == 13578)
        {
          localObject1 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l), 13578, 18);
          if (!localSnsUpdateItem.bytes_value.has()) {
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject1).a(null);
          }
          for (;;)
          {
            FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FriendsStatusUtil.UpdateFriendStatusItem)localObject1, null);
            break;
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject1).a(localSnsUpdateItem.bytes_value.get().toByteArray());
          }
        }
        if (localSnsUpdateItem.uint32_update_sns_type.get() == 13579)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "get do not disturb push");
          }
          localObject1 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l), 13579, 19);
          ((FriendsStatusUtil.UpdateFriendStatusItem)localObject1).b(localSnsUpdateItem.bytes_value.get().toByteArray());
          FriendsStatusUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FriendsStatusUtil.UpdateFriendStatusItem)localObject1, null);
        }
        else
        {
          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13568) {
            alem.a(String.valueOf(paramSnsUpateBuffer.uint64_uin.get()), localSnsUpdateItem.bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = paramamsw.a(String.valueOf(l));
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new SpecialCareInfo();
              ((SpecialCareInfo)localObject1).uin = String.valueOf(String.valueOf(l));
            }
          }
          int i = localSnsUpdateItem.uint32_update_sns_type.get();
          localObject2 = localSnsUpdateItem.bytes_value.get().toStringUtf8();
          FriendListHandler.initSpecialCareInfo((SpecialCareInfo)localObject1, i, (String)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody uin=" + ((SpecialCareInfo)localObject1).uin + ", itemtype=" + i + ",itemVal=" + (String)localObject2);
          }
          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13575)
          {
            if (QLog.isColorLevel()) {
              QLog.d("HotFriend_ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody uin= " + l);
            }
            String str = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
            byte[] arrayOfByte = localSnsUpdateItem.bytes_value.get().toByteArray();
            ExtensionInfo localExtensionInfo = paramamsw.a(str);
            localObject2 = localExtensionInfo;
            if (localExtensionInfo == null)
            {
              localObject2 = new ExtensionInfo();
              ((ExtensionInfo)localObject2).uin = str;
            }
            FriendListHandler.updateSnsData_HOT_FRIEND_CHAT_LEVEL_TYPE(str, arrayOfByte, (ExtensionInfo)localObject2);
            paramamsw.a((ExtensionInfo)localObject2);
            paramArrayList1.add(((ExtensionInfo)localObject2).uin);
          }
          localObject2 = localObject1;
          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13581)
          {
            localObject2 = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
            if (TextUtils.isEmpty(localSnsUpdateItem.bytes_value.get().toStringUtf8()))
            {
              paramMap.put(localObject2, Boolean.valueOf(false));
              localObject2 = localObject1;
            }
            else
            {
              paramMap.put(localObject2, Boolean.valueOf(true));
              localObject2 = localObject1;
            }
          }
        }
      }
    }
    if ((localObject2 != null) && ((((SpecialCareInfo)localObject2).getStatus() != 1000) || (((SpecialCareInfo)localObject2).globalSwitch != 0))) {
      paramArrayList.add(localObject2);
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem)
  {
    if (paramContentItem.msg_friend_teamlist.has())
    {
      paramContentItem = (Oidb_0x5e0.FriendTeamList)paramContentItem.msg_friend_teamlist.get();
      if ((paramContentItem != null) && (paramContentItem.uint32_update_flag.has()) && (paramContentItem.uint32_update_flag.get() == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate GroupList：uin = ");
        }
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getFriendGroupList(true);
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw)
  {
    int i = 1;
    Object localObject;
    long l;
    int j;
    if (paramContentItem.msg_genderfiled.has())
    {
      localObject = (Oidb_0x5e0.GenderFiled)paramContentItem.msg_genderfiled.get();
      l = ((Oidb_0x5e0.GenderFiled)localObject).uint64_uin.get();
      paramContentItem = paramamsw.b(l + "");
      if (paramContentItem != null)
      {
        j = ((Oidb_0x5e0.GenderFiled)localObject).uint32_gender.get();
        if (j != 1) {
          break label208;
        }
        i = 0;
      }
    }
    for (;;)
    {
      paramContentItem.shGender = ((short)i);
      if (bftf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(l)))
      {
        localObject = (awhw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106);
        if (localObject != null) {
          ((awhw)localObject).b(paramContentItem.shGender);
        }
      }
      paramamsw.a(paramContentItem);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  sex: uin = " + new StringBuilder().append(l).append("temp").toString().substring(0, 4) + " sex = " + i);
      }
      return;
      label208:
      if (j != 2) {
        if (j == 0) {
          i = 2;
        } else {
          i = j;
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw, anwq paramanwq)
  {
    if (paramContentItem.msg_profile_info.has())
    {
      paramContentItem = (Oidb_0x5e0.ProfileInfo)paramContentItem.msg_profile_info.get();
      long l = paramContentItem.uint64_uin.get();
      Object localObject = paramContentItem.rpt_msg_profile_info.get();
      paramanwq.a();
      paramanwq.jdField_a_of_type_JavaLangString = Long.toString(l);
      paramContentItem = (alnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
      ApolloBaseInfo localApolloBaseInfo = paramContentItem.b(l + "");
      boolean bool = false;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Oidb_0x5e0.ProfileTvInfo localProfileTvInfo = (Oidb_0x5e0.ProfileTvInfo)((Iterator)localObject).next();
        int i = localProfileTvInfo.uint32_field_id.get();
        localProfileTvInfo.uint32_field_type.get();
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "Check update for profile field uin: " + new StringBuilder().append(l).append("temp").toString().substring(0, 4) + ",field: " + i + ", int_value: " + 0L);
        }
        bool |= a(localProfileTvInfo, paramamsw, l, i, paramContentItem, localApolloBaseInfo);
        switch (i)
        {
        default: 
          break;
        case 20015: 
          paramanwq.b = localProfileTvInfo.uint64_field_int_value.get();
          break;
        case 27201: 
          d(localProfileTvInfo, paramamsw, l);
          break;
        case 40530: 
          a(localProfileTvInfo, paramamsw, l);
          break;
        case 27254: 
          c(localProfileTvInfo, paramamsw, l);
          break;
        case 42099: 
          paramanwq.jdField_a_of_type_Long = localProfileTvInfo.uint64_field_int_value.get();
          break;
        case 40556: 
          paramanwq.c = localProfileTvInfo.uint64_field_int_value.get();
          break;
        case 27218: 
          b(localProfileTvInfo, paramamsw, l);
        }
      }
      if (bool) {
        paramContentItem.a(localApolloBaseInfo);
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw, TroopManager paramTroopManager, ArrayList<Friends> paramArrayList1, ArrayList<Friends> paramArrayList2, Friends[] paramArrayOfFriends, int paramInt, ArrayList<TroopInfo> paramArrayList, ArrayList<SpecialCareInfo> paramArrayList3, Map<String, Boolean> paramMap, ArrayList<String> paramArrayList4)
  {
    anwq localanwq = new anwq(0L);
    localanwq.a();
    switch (paramContentItem.uint32_update_profile_id.get())
    {
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(localanwq.jdField_a_of_type_JavaLangString))
      {
        paramContentItem = (anwp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
        if (paramContentItem != null) {
          paramContentItem.a(localanwq);
        }
        localanwq.a();
      }
      return;
      a(paramContentItem, paramamsw, paramArrayList1, paramArrayOfFriends, paramInt);
      continue;
      a(paramContentItem, paramamsw);
      continue;
      a(paramContentItem, paramamsw, paramArrayList2);
      continue;
      a(paramContentItem, paramTroopManager, paramArrayList);
      continue;
      a(paramContentItem);
      continue;
      a(paramContentItem, paramamsw, paramArrayOfFriends, paramInt);
      continue;
      b(paramContentItem, paramamsw);
      continue;
      a(paramContentItem, paramamsw, paramArrayList3, paramMap, paramArrayList4);
      continue;
      c(paramContentItem, paramamsw);
      continue;
      d(paramContentItem, paramamsw);
      continue;
      e(paramContentItem, paramamsw);
      continue;
      a(paramContentItem, paramamsw, localanwq);
      continue;
      if (paramContentItem.msg_intimate_info.has())
      {
        awgt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (intimate_relation.IntimateInfo)paramContentItem.msg_intimate_info.get());
        continue;
        if (paramContentItem.msg_ext_sns_frd_data.has())
        {
          afas.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Oidb_0xd50.ExtSnsFrdData)paramContentItem.msg_ext_sns_frd_data.get());
          continue;
          if (paramContentItem.msg_mutual_mark_data.has()) {
            awfr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Oidb_0xd6b.MutualMarkData)paramContentItem.msg_mutual_mark_data.get());
          }
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw, ArrayList<Friends> paramArrayList)
  {
    if (paramContentItem.msg_friendremark.has())
    {
      paramContentItem = (Oidb_0x5e0.FriendRemark)paramContentItem.msg_friendremark.get();
      if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()))
      {
        long l = paramContentItem.uint64_uin.get();
        String str = paramContentItem.bytes_value.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate Remark：uin = " + new StringBuilder().append(l).append("temp").toString().substring(0, 4) + " 备注内容 = " + bftf.a(str));
        }
        Friends localFriends = paramamsw.e(Long.toString(l));
        paramContentItem = null;
        if (localFriends != null) {
          paramContentItem = localFriends.remark;
        }
        paramamsw = paramamsw.b(l + "", str);
        if ((localFriends != null) && (localFriends.isFriend()) && (b(str, paramContentItem))) {
          paramArrayList.add(paramamsw);
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw, ArrayList<SpecialCareInfo> paramArrayList, Map<String, Boolean> paramMap, ArrayList<String> paramArrayList1)
  {
    Oidb_0x5e0.GeneralBuffer localGeneralBuffer;
    if (paramContentItem.msg_general_buffer.has())
    {
      localGeneralBuffer = (Oidb_0x5e0.GeneralBuffer)paramContentItem.msg_general_buffer.get();
      if ((localGeneralBuffer != null) && (localGeneralBuffer.bytes_value.has())) {
        paramContentItem = new Oidb_0x5d0.SnsUpateBuffer();
      }
    }
    for (;;)
    {
      try
      {
        paramContentItem.mergeFrom(localGeneralBuffer.bytes_value.get().toByteArray());
        if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()) && (paramContentItem.rpt_uin32_idlist.has()))
        {
          paramMap = paramContentItem.rpt_uin32_idlist.get().iterator();
          if (!paramMap.hasNext()) {
            break label258;
          }
          if (((Integer)paramMap.next()).intValue() != 4051) {
            continue;
          }
          paramArrayList = String.valueOf(paramContentItem.uint64_uin.get());
          if (QLog.isColorLevel())
          {
            if (paramArrayList.length() < 4) {
              break label259;
            }
            paramamsw = paramArrayList.substring(paramArrayList.length() - 4);
            QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit : shd: " + paramamsw);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramArrayList, paramArrayList);
          continue;
        }
      }
      catch (Exception localException)
      {
        paramContentItem = null;
        localException.printStackTrace();
        continue;
        if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()) && (paramContentItem.rpt_msg_sns_update_item.has())) {
          a(paramContentItem, paramamsw, paramArrayList, paramMap, paramArrayList1);
        }
      }
      label258:
      return;
      label259:
      paramamsw = paramArrayList;
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw, ArrayList<Friends> paramArrayList, Friends[] paramArrayOfFriends, int paramInt)
  {
    if (paramContentItem.msg_nicknamefiled.has())
    {
      paramContentItem = (Oidb_0x5e0.NickNameFiled)paramContentItem.msg_nicknamefiled.get();
      if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()))
      {
        long l = paramContentItem.uint64_uin.get();
        String str = paramContentItem.bytes_value.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  Nick：uin = " + new StringBuilder().append(l).append("temp").toString().substring(0, 4) + " 昵称 = " + bftf.a(str));
        }
        Friends localFriends = paramamsw.e(Long.toString(l));
        paramContentItem = null;
        if (localFriends != null) {
          paramContentItem = localFriends.name;
        }
        paramamsw = paramamsw.a(l + "", str);
        paramArrayOfFriends[paramInt] = paramamsw;
        if ((localFriends != null) && (localFriends.isFriend()) && (a(str, paramContentItem))) {
          paramArrayList.add(paramamsw);
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw, Friends[] paramArrayOfFriends, int paramInt)
  {
    long l;
    int k;
    int j;
    int i;
    int n;
    if (paramContentItem.msg_value_bit.has())
    {
      paramContentItem = (Oidb_0x5e0.ValueBit)paramContentItem.msg_value_bit.get();
      if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()))
      {
        l = paramContentItem.uint64_uin.get();
        paramamsw = paramamsw.e(Long.toString(l));
        k = 0;
        j = 0;
        i = 0;
        if (paramamsw != null)
        {
          k = paramamsw.qqVipInfo;
          j = paramamsw.superQqInfo;
          i = paramamsw.superVipInfo;
        }
        if ((paramContentItem.bytes_identity_flag.has()) && (paramContentItem.bytes_identity_flag.get().size() >= 3))
        {
          m = paramContentItem.bytes_identity_flag.get().byteAt(0);
          n = paramContentItem.bytes_identity_flag.get().byteAt(2);
          if (paramamsw != null)
          {
            int i1 = paramamsw.qqVipInfo;
            if ((m & 0xFC) == 0) {
              break label402;
            }
            m = 1;
            paramamsw.qqVipInfo = (m << 24 | i1);
            i1 = paramamsw.qqVipInfo;
            if ((n & 0x60) == 0) {
              break label408;
            }
            m = 1;
            label186:
            paramamsw.qqVipInfo = (m << 24 | i1);
          }
        }
        if ((paramContentItem.bytes_ext_flag.has()) && (paramContentItem.bytes_ext_flag.get().size() >= 5))
        {
          m = paramContentItem.bytes_ext_flag.get().byteAt(5);
          if (paramamsw != null)
          {
            n = paramamsw.superVipInfo;
            if ((m & 0x20) == 0) {
              break label414;
            }
          }
        }
      }
    }
    label402:
    label408:
    label414:
    for (int m = 1;; m = 0)
    {
      paramamsw.superVipInfo = (m << 24 | n);
      if ((paramamsw != null) && ((paramamsw.superVipInfo != i) || (paramamsw.qqVipInfo != k) || (paramamsw.superQqInfo != j)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "find a vip user uin = " + new StringBuilder().append(l).append("temp").toString().substring(0, 4) + " superVipInfo = " + paramamsw.superVipInfo + " qqVipInfo = " + paramamsw.qqVipInfo + " superQqInfo = " + paramamsw.superQqInfo);
        }
        paramArrayOfFriends[paramInt] = paramamsw;
      }
      return;
      m = 0;
      break;
      m = 0;
      break label186;
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, TroopManager paramTroopManager, ArrayList<TroopInfo> paramArrayList)
  {
    if (paramContentItem.msg_groupname.has())
    {
      paramContentItem = (Oidb_0x5e0.GroupName)paramContentItem.msg_groupname.get();
      if ((paramContentItem != null) && (paramContentItem.uint64_group_uin.has()))
      {
        long l = paramContentItem.uint64_group_uin.get();
        paramContentItem = paramContentItem.bytes_value.get().toStringUtf8();
        paramTroopManager = paramTroopManager.b(l + "");
        if (paramTroopManager != null)
        {
          paramTroopManager.troopname = paramContentItem;
          paramArrayList.add(paramTroopManager);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate TroopName：uin = " + new StringBuilder().append(l).append("temp").toString().substring(0, 4) + " 群名称内容 = " + bftf.a(paramContentItem));
          }
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, amsw paramamsw, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(Long.toString(paramLong));
    paramProfileTvInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileTvInfo = new ExtensionInfo();
      paramProfileTvInfo.uin = Long.toString(paramLong);
    }
    if (paramProfileTvInfo.magicFont != l)
    {
      paramProfileTvInfo.magicFont = ((int)l);
      paramProfileTvInfo.timestamp = System.currentTimeMillis();
      paramamsw.a(paramProfileTvInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "update, Get magic font, uin= " + paramLong + ", magicfont = " + paramProfileTvInfo.magicFont);
    }
  }
  
  private void a(Oidb_0x5e0.RspBody paramRspBody)
  {
    amsw localamsw = (amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    Object localObject2 = paramRspBody.rpt_msg_contentItem.get();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(((List)localObject2).size());
    if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1)) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateRspBody called contentitemlist size = " + ((List)localObject2).size() + " overFlag:" + bool);
      }
      Friends[] arrayOfFriends = new Friends[((List)localObject2).size()];
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      HashMap localHashMap = new HashMap();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Oidb_0x5e0.ContentItem localContentItem = (Oidb_0x5e0.ContentItem)((Iterator)localObject2).next();
          if (localContentItem.uint32_update_profile_id.has()) {
            a(localContentItem, localamsw, (TroopManager)localObject1, localArrayList4, localArrayList5, arrayOfFriends, 0, localArrayList1, localArrayList2, localHashMap, localArrayList3);
          }
        }
      }
      a(localArrayList4, localArrayList5);
      a(localArrayList1, localamsw, (TroopManager)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody, bulkSaveOrUpdateSpecialCareInfos,size=" + localArrayList2.size());
      }
      if (localArrayList2.size() > 0)
      {
        localamsw.c(localArrayList2);
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).notifyUI(99, true, new Object[] { Boolean.valueOf(true), localArrayList2 });
      }
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, new Object[] { "0x5e0 hiddenChatMap.size:", Integer.valueOf(localHashMap.size()) });
      }
      if (localHashMap.size() > 0) {
        FriendsStatusUtil.a(localHashMap, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      if (localArrayList3.size() > 0) {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).notifyUI(107, true, localArrayList3);
      }
      if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != 0))
      {
        localObject1 = new ArrayList();
        a(localamsw, arrayOfFriends, 0, (ArrayList)localObject1);
        arrayOfFriends = new Friends[((ArrayList)localObject1).size()];
        ((ArrayList)localObject1).toArray(arrayOfFriends);
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + 0 + " includeShield:" + arrayOfFriends.length);
        }
        localamsw.a(arrayOfFriends, arrayOfFriends.length);
        b(paramRspBody);
        if ((!paramRspBody.uint32_over_flag.has()) || (paramRspBody.uint32_over_flag.get() != 1)) {
          break label667;
        }
        this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
      }
      label667:
      while (!paramRspBody.bytes_svrcontext.has())
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + 0);
        }
        localamsw.a(arrayOfFriends, 0);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramRspBody.bytes_svrcontext.get();
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).getCheckUpdate(false, 1);
      return;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        bool1 = bool2;
        if (!paramString1.equals(paramString2)) {
          bool1 = true;
        }
      }
    }
    if ((QLog.isColorLevel()) && (bool1)) {
      QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByName newFriendName = " + paramString1 + ",oldFriendName = " + paramString2 + ",result = " + bool1);
    }
    return bool1;
  }
  
  private boolean a(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, amsw paramamsw, long paramLong, int paramInt, alnr paramalnr, ApolloBaseInfo paramApolloBaseInfo)
  {
    boolean bool2 = true;
    switch (paramInt)
    {
    default: 
    case 41999: 
    case 42003: 
    case 42980: 
    case 42230: 
    case 27059: 
    case 27206: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return false;
                  paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
                } while ((paramApolloBaseInfo == null) || (paramApolloBaseInfo.apolloVipLevel == paramLong));
                paramApolloBaseInfo.apolloVipLevel = ((int)paramLong);
                return true;
                paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
              } while ((paramApolloBaseInfo == null) || (paramApolloBaseInfo.apolloVipFlag == paramLong));
              paramApolloBaseInfo.apolloVipFlag = ((int)paramLong);
              return true;
              paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
            } while ((paramApolloBaseInfo == null) || (paramApolloBaseInfo.apolloStatus == paramLong));
            paramApolloBaseInfo.apolloStatus = ((int)paramLong);
            return true;
            paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
          } while ((paramApolloBaseInfo == null) || (paramApolloBaseInfo.cmshow3dFlag == paramLong));
          paramApolloBaseInfo.cmshow3dFlag = ((int)paramLong);
          return true;
          paramLong = paramProfileTvInfo.uint64_field_int_value.get();
        } while ((paramApolloBaseInfo == null) || (paramApolloBaseInfo.apolloServerTS == paramLong));
        paramApolloBaseInfo.apolloServerTS = paramLong;
        return true;
        paramLong = paramProfileTvInfo.uint64_field_int_value.get();
      } while ((paramLong >= NetConnInfoCenter.getServerTime()) || (paramApolloBaseInfo == null) || (paramApolloBaseInfo.apolloSignValidTS == paramLong));
      paramApolloBaseInfo.apolloLocalSignTs = paramApolloBaseInfo.apolloSignValidTS;
      paramApolloBaseInfo.apolloSignValidTS = paramLong;
      paramApolloBaseInfo.apolloSignStr = "";
      return true;
    }
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    if (paramApolloBaseInfo.apolloAISwitch != (int)l)
    {
      paramApolloBaseInfo.apolloAISwitch = ((int)l);
      bool1 = bool2;
      if (String.valueOf(paramLong).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin())) {
        paramalnr.a((int)l, 3);
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "apollo aiSwitch profileupdate :" + l);
      }
      return bool1;
    }
  }
  
  public static void b(long paramLong, String paramString, amrb paramamrb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoRemark uin = " + paramLong + ",remarkName = " + paramString);
    }
    Object localObject = paramamrb.a();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramamrb.a(localDiscussionInfo.uin, Long.toString(paramLong));
        if ((localDiscussionMemberInfo != null) && (b(paramString, localDiscussionMemberInfo.inteRemark)))
        {
          localDiscussionMemberInfo.inteRemark = paramString;
          if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoRemark discussMem.memberName = " + localDiscussionMemberInfo.memberName + ",discussMem.inteRemark = " + localDiscussionMemberInfo.inteRemark + ",discussionUin = " + localDiscussionInfo.uin);
          }
          localArrayList.add(localDiscussionMemberInfo);
        }
      }
      if (localArrayList.size() > 0)
      {
        paramamrb.b(localArrayList);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(localArrayList.size()));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "updateDiscussMemberRemark", true, 0L, 0L, paramString, "", true);
      }
    }
  }
  
  private void b(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw)
  {
    if (paramContentItem.msg_general_buffer.has())
    {
      paramContentItem = (Oidb_0x5e0.GeneralBuffer)paramContentItem.msg_general_buffer.get();
      if ((paramContentItem != null) && (paramContentItem.bytes_value.has()))
      {
        paramContentItem = ByteBuffer.wrap(paramContentItem.bytes_value.get().toByteArray());
        if (paramContentItem.remaining() > 8)
        {
          long l1 = paramContentItem.getInt() & 0xFFFFFFFF;
          long l2 = paramContentItem.getInt() & 0xFFFFFFFF;
          byte[] arrayOfByte = new byte[paramContentItem.getShort() & 0xFFFF];
          paramContentItem.get(arrayOfByte);
          ExtensionInfo localExtensionInfo = paramamsw.a(Long.toString(l1));
          paramContentItem = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = Long.toString(l1);
          }
          if (paramContentItem.richTime != l2)
          {
            paramContentItem.setRichBuffer(arrayOfByte, l2);
            paramContentItem.isAdded2C2C = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l1), paramContentItem.getRichStatus());
            paramamsw.a(paramContentItem);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "insertSignMsgIfNeeded from QQProfileItem uin = " + l1 + " result = " + paramContentItem.isAdded2C2C);
            }
          }
        }
      }
    }
  }
  
  private void b(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, amsw paramamsw, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(Long.toString(paramLong));
    paramProfileTvInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileTvInfo = new ExtensionInfo();
      paramProfileTvInfo.uin = Long.toString(paramLong);
    }
    if (paramProfileTvInfo.latestPLUpdateTimestamp != l)
    {
      paramProfileTvInfo.latestPLUpdateTimestamp = l;
      paramamsw.a(paramProfileTvInfo);
      if (QLog.isColorLevel()) {
        QLog.d("QQProfileItem", 2, "update uin=" + paramLong + " latestplNewsTs=" + l);
      }
    }
  }
  
  private void b(Oidb_0x5e0.RspBody paramRspBody)
  {
    Object localObject = paramRspBody.rpt_msg_ProfileListResult.get();
    if (localObject != null)
    {
      paramRspBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Oidb_0x5e0.ProfileListResult localProfileListResult = (Oidb_0x5e0.ProfileListResult)((Iterator)localObject).next();
        if ((localProfileListResult.uint32_result.has()) && (localProfileListResult.uint32_result.get() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "get result =" + localProfileListResult.uint32_result.get());
          }
          if ((localProfileListResult.uint32_update_profile_id.has()) && (localProfileListResult.uint32_new_content_timestamp.has()))
          {
            int i = localProfileListResult.uint32_update_profile_id.get();
            int j = localProfileListResult.uint32_new_content_timestamp.get();
            paramRspBody.putLong("inccheckupdatetimeStamp" + i, j);
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody profileid:" + i + " uint32_new_content_timestamp =" + j);
            }
          }
        }
      }
      paramRspBody.commit();
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString1))
    {
      bool1 = bool2;
      if (!paramString1.equals(paramString2)) {
        bool1 = true;
      }
    }
    bool2 = bool1;
    if (TextUtils.isEmpty(paramString1))
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramString2)) {
        bool2 = true;
      }
    }
    if ((QLog.isColorLevel()) && (bool2)) {
      QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByRemark ,newRemark = " + paramString1 + ",oldRemark = " + paramString2 + ",result = " + bool2);
    }
    return bool2;
  }
  
  private void c(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw)
  {
    if (paramContentItem.msg_general_buffer.has())
    {
      paramContentItem = (Oidb_0x5e0.GeneralBuffer)paramContentItem.msg_general_buffer.get();
      long l2 = 0L;
      long l1 = l2;
      if (paramContentItem != null)
      {
        l1 = l2;
        if (paramContentItem.bytes_value.has()) {
          l1 = paramContentItem.uint64_uin.get();
        }
      }
      if ((paramContentItem != null) && (paramContentItem.bytes_value.has()))
      {
        paramContentItem = ByteBuffer.wrap(paramContentItem.bytes_value.get().toByteArray());
        if (paramContentItem.remaining() >= 8)
        {
          l2 = paramContentItem.getLong();
          ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(l1));
          paramContentItem = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = String.valueOf(l1);
          }
          paramContentItem.pendantId = l2;
          paramContentItem.timestamp = System.currentTimeMillis();
          paramamsw.a(paramContentItem);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Pendant, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + paramContentItem.pendantId);
          }
        }
      }
    }
  }
  
  private void c(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, amsw paramamsw, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(Long.toString(paramLong));
    paramProfileTvInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileTvInfo = new ExtensionInfo();
      paramProfileTvInfo.uin = Long.toString(paramLong);
      paramProfileTvInfo.fontEffect = -1;
    }
    if (paramProfileTvInfo.fontEffect != l)
    {
      paramProfileTvInfo.fontEffect = ((int)l);
      paramProfileTvInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      paramamsw.a(paramProfileTvInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "update, Get font effect, uin= " + paramLong + ", fontEffect = " + paramProfileTvInfo.fontEffect + ", updateTime = " + paramProfileTvInfo.fontEffectLastUpdateTime);
    }
  }
  
  private void d(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw)
  {
    if (paramContentItem.msg_general_buffer.has())
    {
      paramContentItem = (Oidb_0x5e0.GeneralBuffer)paramContentItem.msg_general_buffer.get();
      long l2 = 0L;
      long l1 = l2;
      if (paramContentItem != null)
      {
        l1 = l2;
        if (paramContentItem.bytes_value.has()) {
          l1 = paramContentItem.uint64_uin.get();
        }
      }
      if ((paramContentItem != null) && (paramContentItem.bytes_value.has()))
      {
        paramContentItem = ByteBuffer.wrap(paramContentItem.bytes_value.get().toByteArray());
        if (paramContentItem.remaining() >= 4)
        {
          int i = paramContentItem.getInt();
          ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(l1));
          paramContentItem = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = String.valueOf(l1);
          }
          if (paramContentItem.uVipFont != i)
          {
            paramContentItem.uVipFont = i;
            paramContentItem.timestamp = System.currentTimeMillis();
            paramamsw.a(paramContentItem);
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Font, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + i);
          }
        }
      }
    }
  }
  
  private void d(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, amsw paramamsw, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((amsw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(Long.toString(paramLong));
    paramProfileTvInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileTvInfo = new ExtensionInfo();
      paramProfileTvInfo.uin = Long.toString(paramLong);
    }
    if ((paramProfileTvInfo.uVipFont != gb.a(l)) || (paramProfileTvInfo.vipFontType != gb.b(l)))
    {
      paramProfileTvInfo.uVipFont = gb.a(l);
      paramProfileTvInfo.vipFontType = gb.b(l);
      paramProfileTvInfo.timestamp = System.currentTimeMillis();
      paramamsw.a(paramProfileTvInfo);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "update, Get Font, uin=" + paramLong + ", id=" + paramProfileTvInfo.uVipFont + ", type = " + paramProfileTvInfo.vipFontType);
    }
  }
  
  private void e(Oidb_0x5e0.ContentItem paramContentItem, amsw paramamsw)
  {
    if (paramContentItem.msg_general_buffer.has())
    {
      paramContentItem = (Oidb_0x5e0.GeneralBuffer)paramContentItem.msg_general_buffer.get();
      long l2 = 0L;
      long l1 = l2;
      if (paramContentItem != null)
      {
        l1 = l2;
        if (paramContentItem.bytes_value.has()) {
          l1 = paramContentItem.uint64_uin.get();
        }
      }
      if ((paramContentItem != null) && (paramContentItem.bytes_value.has()))
      {
        paramContentItem = ByteBuffer.wrap(paramContentItem.bytes_value.get().toByteArray());
        if (paramContentItem.remaining() >= 4)
        {
          int i = paramContentItem.getInt();
          ExtensionInfo localExtensionInfo = paramamsw.a(String.valueOf(l1));
          paramContentItem = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = String.valueOf(l1);
          }
          if (paramContentItem.colorRingId != i)
          {
            paramContentItem.colorRingId = i;
            paramContentItem.timestamp = System.currentTimeMillis();
            paramamsw.a(paramContentItem);
            bgdt.a(paramContentItem.uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          }
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get colorRing, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + i);
          }
        }
      }
    }
  }
  
  public int a()
  {
    return 13;
  }
  
  public ReqItem a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::getCheckUpdateItemData called checkUpdateType:" + paramInt);
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 101;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject2 = new long[19];
    int i = 0;
    while (i < 19)
    {
      localObject2[i] = (((SharedPreferences)localObject1).getLong("inccheckupdatetimeStamp" + Integer.toString(i), 0L) - 0L);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(50);
      i = 0;
      while (i < 19)
      {
        ((StringBuilder)localObject1).append(Long.toString(localObject2[i])).append(" ");
        i += 1;
      }
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject1).toString());
    }
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList2 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList2.uint32_need_content.set(0);
    localUpdateProfileList2.uint32_update_profile_id.set(1);
    localUpdateProfileList2.uint32_friendlist_type.set(1);
    localUpdateProfileList2.uint32_get_content_timestamp.set((int)localObject2[1]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList3 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList3.uint32_need_content.set(0);
    localUpdateProfileList3.uint32_update_profile_id.set(2);
    localUpdateProfileList3.uint32_friendlist_type.set(1);
    localUpdateProfileList3.uint32_get_content_timestamp.set((int)localObject2[2]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList4 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList4.uint32_need_content.set(0);
    localUpdateProfileList4.uint32_update_profile_id.set(3);
    localUpdateProfileList4.uint32_friendlist_type.set(0);
    localUpdateProfileList4.uint32_get_content_timestamp.set((int)localObject2[3]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList1 = null;
    if (!((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(1)).isSyncingAllFriendsRichStatus())
    {
      localObject1 = new Oidb_0x5e0.UpdateProfileList();
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_need_content.set(0);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_update_profile_id.set(13);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_friendlist_type.set(1);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_get_content_timestamp.set((int)localObject2[13]);
    }
    for (;;)
    {
      localUpdateProfileList1 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList1.uint32_need_content.set(0);
      localUpdateProfileList1.uint32_update_profile_id.set(5);
      localUpdateProfileList1.uint32_friendlist_type.set(0);
      localUpdateProfileList1.uint32_get_content_timestamp.set((int)localObject2[5]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList5 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList5.uint32_need_content.set(1);
      localUpdateProfileList5.uint32_update_profile_id.set(6);
      localUpdateProfileList5.uint32_friendlist_type.set(0);
      localUpdateProfileList5.uint32_get_content_timestamp.set((int)localObject2[6]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList6 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList6.uint32_need_content.set(0);
      localUpdateProfileList6.uint32_update_profile_id.set(7);
      localUpdateProfileList6.uint32_friendlist_type.set(1);
      localUpdateProfileList6.uint32_get_content_timestamp.set((int)localObject2[7]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList7 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList7.uint32_need_content.set(0);
      localUpdateProfileList7.uint32_update_profile_id.set(9);
      localUpdateProfileList7.uint32_friendlist_type.set(1);
      localUpdateProfileList7.uint32_get_content_timestamp.set((int)localObject2[9]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList8 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList8.uint32_need_content.set(0);
      localUpdateProfileList8.uint32_update_profile_id.set(10);
      localUpdateProfileList8.uint32_friendlist_type.set(1);
      localUpdateProfileList8.uint32_get_content_timestamp.set((int)localObject2[10]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList9 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList9.uint32_need_content.set(0);
      localUpdateProfileList9.uint32_update_profile_id.set(11);
      localUpdateProfileList9.uint32_friendlist_type.set(1);
      localUpdateProfileList9.uint32_get_content_timestamp.set((int)localObject2[11]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList10 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList10.uint32_need_content.set(0);
      localUpdateProfileList10.uint32_update_profile_id.set(12);
      localUpdateProfileList10.uint32_friendlist_type.set(1);
      localUpdateProfileList10.uint32_get_content_timestamp.set((int)localObject2[12]);
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList11 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList11.uint32_need_content.set(0);
      localUpdateProfileList11.uint32_update_profile_id.set(15);
      localUpdateProfileList11.uint32_friendlist_type.set(1);
      localUpdateProfileList11.uint32_get_content_timestamp.set((int)localObject2[15]);
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42003));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(41999));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42980));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27059));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27206));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27210));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42230));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27201));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(40530));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27254));
      Object localObject3 = (anwp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(199);
      if ((localObject3 != null) && (((anwp)localObject3).a()))
      {
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42099));
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(40556));
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(20015));
        if (QLog.isColorLevel()) {
          QLog.d("QQProfileItem", 2, "ClassicHeadActivity Params is add");
        }
      }
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27218));
      localObject3 = new Oidb_0x5e0.UpdateProfileList();
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_need_content.set(0);
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_update_profile_id.set(16);
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_friendlist_type.set(1);
      ((Oidb_0x5e0.UpdateProfileList)localObject3).uint32_get_content_timestamp.set((int)localObject2[16]);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdateItemData IDX_INTIMATE_FIELD_LIST time::" + (int)localObject2[16]);
      }
      Oidb_0x5e0.UpdateProfileList localUpdateProfileList12 = new Oidb_0x5e0.UpdateProfileList();
      localUpdateProfileList12.uint32_need_content.set(0);
      localUpdateProfileList12.uint32_update_profile_id.set(17);
      localUpdateProfileList12.uint32_friendlist_type.set(1);
      localUpdateProfileList12.uint32_get_content_timestamp.set((int)localObject2[17]);
      Object localObject4 = new Oidb_0xd50.ReqBody();
      ((Oidb_0xd50.ReqBody)localObject4).appid.set(10002L);
      ((Oidb_0xd50.ReqBody)localObject4).req_music_switch.set(1);
      ((Oidb_0xd50.ReqBody)localObject4).req_ksing_switch.set(1);
      ((Oidb_0xd50.ReqBody)localObject4).req_mutualmark_lbsshare.set(1);
      if (QLog.isColorLevel()) {
        QLog.d("QQProfileItem", 2, new Object[] { "getCheckUpdateItemData: invoked. ", " req lbs share profile. ", "此处很可能触发增量资料更新限频逻辑，会导致状态刷新不及时。（消息tab外显图标未刷新等等问题）" });
      }
      ((Oidb_0xd50.ReqBody)localObject4).req_mutualmark_alienation.set(1);
      ((Oidb_0xd50.ReqBody)localObject4).req_aio_quick_app.set(1);
      localUpdateProfileList12.msg_0xd50_req.set((MessageMicro)localObject4);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdateItemData profileid:17, " + (int)localObject2[17]);
      }
      localObject4 = new Oidb_0x5e0.UpdateProfileList();
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_need_content.set(0);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_update_profile_id.set(18);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_friendlist_type.set(1);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_get_content_timestamp.set((int)localObject2[18]);
      Oidb_0xd6b.ReqBody localReqBody = new Oidb_0xd6b.ReqBody();
      localReqBody.start_time.set((int)localObject2[18]);
      ((Oidb_0x5e0.UpdateProfileList)localObject4).msg_0xd6b_req.set(localReqBody);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdateItemData profileid:18, " + (int)localObject2[18]);
      }
      localObject2 = new Oidb_0x5e0.ReqBody();
      if (this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro != null) {
        ((Oidb_0x5e0.ReqBody)localObject2).bytes_svrcontext.set(this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro);
      }
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList2);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList3);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList4);
      if (localObject1 != null) {
        ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add((MessageMicro)localObject1);
      }
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList1);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList5);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList6);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList7);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList8);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList9);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList10);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList11);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add((MessageMicro)localObject3);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add(localUpdateProfileList12);
      ((Oidb_0x5e0.ReqBody)localObject2).rpt_msg_update_profile_list.add((MessageMicro)localObject4);
      if (paramInt == 8) {
        ((Oidb_0x5e0.ReqBody)localObject2).uint32_forced_update.set(1);
      }
      localReqItem.vecParam = ((Oidb_0x5e0.ReqBody)localObject2).toByteArray();
      return localReqItem;
      localObject1 = localUpdateProfileList1;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileService.CheckUpdateReq", 2, "skip rich status check update");
        localObject1 = localUpdateProfileList1;
      }
    }
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateItemData called item.cResult = " + paramRespItem.cResult);
    }
    Object localObject;
    int i;
    if ((paramRespItem.eServiceID == 101) && (paramRespItem.cResult == 2))
    {
      paramRespItem = paramRespItem.vecUpdate;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleCheckUpdateItemData pbdata.length=");
        if (paramRespItem == null) {
          break label121;
        }
        i = paramRespItem.length;
      }
    }
    for (;;)
    {
      QLog.d("QQProfileItem", 2, i);
      localObject = new Oidb_0x5e0.RspBody();
      try
      {
        paramRespItem = (Oidb_0x5e0.RspBody)((Oidb_0x5e0.RspBody)localObject).mergeFrom(paramRespItem);
        if (paramRespItem == null)
        {
          return;
          label121:
          i = 0;
        }
      }
      catch (Exception paramRespItem)
      {
        for (;;)
        {
          paramRespItem.printStackTrace();
          paramRespItem = null;
        }
        a(paramRespItem);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzf
 * JD-Core Version:    0.7.0.1
 */