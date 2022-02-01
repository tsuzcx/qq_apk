package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager.FriendHeadFlagItem;
import com.tencent.mobileqq.app.utils.ExtensionInfoLogUtils;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.mutualmark.MutualMarkDataS2CHandleHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
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

public class QQProfileItem
  implements CheckUpdateItemInterface
{
  private final QQAppInterface a;
  private ByteStringMicro b;
  
  public QQProfileItem(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = null;
    a(this.a, "775_hot_friend_new_boat_clear_version");
    a(this.a, "top_position_and_disturb_clear_version");
    a(this.a, "check_message_preview_version_clear");
  }
  
  public static void a(long paramLong, String paramString, DiscussionManager paramDiscussionManager)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateDiscussionMemberInfoName uin = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",nickName = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("QQProfileItem", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = paramDiscussionManager.b();
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject2).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramDiscussionManager.b(localDiscussionInfo.uin, Long.toString(paramLong));
        if ((localDiscussionMemberInfo != null) && (a(paramString, localDiscussionMemberInfo.memberName)))
        {
          localDiscussionMemberInfo.memberName = paramString;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateDiscussionMemberInfoName discussMem.memberName = ");
            localStringBuilder.append(localDiscussionMemberInfo.memberName);
            localStringBuilder.append(",discussMem.inteRemark = ");
            localStringBuilder.append(localDiscussionMemberInfo.inteRemark);
            localStringBuilder.append(",discussionUin = ");
            localStringBuilder.append(localDiscussionInfo.uin);
            QLog.d("QQProfileItem", 2, localStringBuilder.toString());
          }
          ((ArrayList)localObject1).add(localDiscussionMemberInfo);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramDiscussionManager.b((List)localObject1);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(((ArrayList)localObject1).size()));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "updateDiscussMemberNick", true, 0L, 0L, paramString, "", true);
      }
    }
  }
  
  private void a(FriendsManager paramFriendsManager, Friends[] paramArrayOfFriends, int paramInt, ArrayList<Friends> paramArrayList)
  {
    Object localObject = paramFriendsManager.j();
    paramFriendsManager = this.a.getMsgCache().b;
    localObject = ((List)localObject).iterator();
    int i;
    for (;;)
    {
      boolean bool = ((Iterator)localObject).hasNext();
      i = 0;
      if (!bool) {
        break;
      }
      Friends localFriends = (Friends)((Iterator)localObject).next();
      if ((localFriends.isShield()) && (!paramFriendsManager.containsKey(localFriends.uin)))
      {
        localFriends.setShieldFlag(false);
        paramArrayList.add(localFriends);
      }
      else if ((!localFriends.isShield()) && (paramFriendsManager.containsKey(localFriends.uin)))
      {
        localFriends.setShieldFlag(true);
        paramArrayList.add(localFriends);
      }
    }
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
    Object localObject1 = new String();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("len = ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d(paramString, 2, ((StringBuilder)localObject2).toString());
    }
    StringBuilder localStringBuilder = new StringBuilder("");
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfByte[i];
      int k = paramArrayOfByte[i];
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("0123456789ABCDEF".charAt(j >> 4 & 0xF));
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append("0123456789ABCDEF".charAt(k & 0xF));
      ((StringBuilder)localObject2).append(" ");
      localObject1 = ((StringBuilder)localObject2).toString();
      j = i + 1;
      if (j % 8 == 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" ");
        localObject2 = ((StringBuilder)localObject2).toString();
        localObject1 = localObject2;
        i = j;
        if (j % 16 == 0)
        {
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append("\n");
            localStringBuilder.append(((StringBuilder)localObject1).toString());
          }
          localObject1 = "";
          i = j;
        }
      }
      else
      {
        i = j;
      }
    }
    QLog.d(paramString, 2, localStringBuilder.toString());
    if (QLog.isColorLevel()) {
      QLog.d(paramString, 2, (String)localObject1);
    }
  }
  
  /* Error */
  private void a(ArrayList<TroopInfo> paramArrayList, FriendsManager paramFriendsManager, TroopManager paramTroopManager)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 120	java/util/ArrayList:size	()I
    //   4: ifle +69 -> 73
    //   7: aload_2
    //   8: invokevirtual 261	com/tencent/mobileqq/app/FriendsManager:r	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 266	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   16: aload_1
    //   17: invokevirtual 72	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   20: astore_1
    //   21: aload_1
    //   22: invokeinterface 77 1 0
    //   27: ifeq +19 -> 46
    //   30: aload_3
    //   31: aload_1
    //   32: invokeinterface 81 1 0
    //   37: checkcast 268	com/tencent/mobileqq/data/troop/TroopInfo
    //   40: invokevirtual 273	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V
    //   43: goto -22 -> 21
    //   46: aload_2
    //   47: invokevirtual 275	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   50: goto +12 -> 62
    //   53: astore_1
    //   54: goto +13 -> 67
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 278	java/lang/Exception:printStackTrace	()V
    //   62: aload_2
    //   63: invokevirtual 281	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   66: return
    //   67: aload_2
    //   68: invokevirtual 281	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   71: aload_1
    //   72: athrow
    //   73: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	QQProfileItem
    //   0	74	1	paramArrayList	ArrayList<TroopInfo>
    //   0	74	2	paramFriendsManager	FriendsManager
    //   0	74	3	paramTroopManager	TroopManager
    // Exception table:
    //   from	to	target	type
    //   12	21	53	finally
    //   21	43	53	finally
    //   46	50	53	finally
    //   58	62	53	finally
    //   12	21	57	java/lang/Exception
    //   21	43	57	java/lang/Exception
    //   46	50	57	java/lang/Exception
  }
  
  private void a(ArrayList<Friends> paramArrayList1, ArrayList<Friends> paramArrayList2)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.a.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    Object localObject;
    if (paramArrayList1.size() > 0)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        localObject = (Friends)paramArrayList1.next();
        String str = ((Friends)localObject).name;
        a(Long.parseLong(((Friends)localObject).uin), str, localDiscussionManager);
      }
    }
    if (paramArrayList2.size() > 0)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (Friends)paramArrayList1.next();
        localObject = paramArrayList2.remark;
        b(Long.parseLong(paramArrayList2.uin), (String)localObject, localDiscussionManager);
      }
    }
  }
  
  private void a(Oidb_0x5d0.SnsUpateBuffer paramSnsUpateBuffer, FriendsManager paramFriendsManager, ArrayList<SpecialCareInfo> paramArrayList, Map<String, Boolean> paramMap, ArrayList<String> paramArrayList1)
  {
    Object localObject1 = paramSnsUpateBuffer.rpt_msg_sns_update_item.get();
    long l = paramSnsUpateBuffer.uint64_uin.get();
    Iterator localIterator = ((List)localObject1).iterator();
    Object localObject2 = null;
    while (localIterator.hasNext())
    {
      Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)localIterator.next();
      if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has())) {
        if (localSnsUpdateItem.uint32_update_sns_type.get() == 13578)
        {
          localObject1 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l), 13578, 18);
          if (!localSnsUpdateItem.bytes_value.has()) {
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject1).a(null);
          } else {
            ((FriendsStatusUtil.UpdateFriendStatusItem)localObject1).a(localSnsUpdateItem.bytes_value.get().toByteArray());
          }
          FriendsStatusUtil.a(this.a, (FriendsStatusUtil.UpdateFriendStatusItem)localObject1, null);
        }
        else if (localSnsUpdateItem.uint32_update_sns_type.get() == 13579)
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQProfileItem", 2, "get do not disturb push");
          }
          localObject1 = new FriendsStatusUtil.UpdateFriendStatusItem(String.valueOf(l), 13579, 19);
          ((FriendsStatusUtil.UpdateFriendStatusItem)localObject1).b(localSnsUpdateItem.bytes_value.get().toByteArray());
          FriendsStatusUtil.a(this.a, (FriendsStatusUtil.UpdateFriendStatusItem)localObject1, null);
        }
        else
        {
          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13568) {
            QvipSpecialCareUtil.a(String.valueOf(paramSnsUpateBuffer.uint64_uin.get()), localSnsUpdateItem.bytes_value.get().toStringUtf8(), this.a);
          }
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = paramFriendsManager.y(String.valueOf(l));
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
          Object localObject3;
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleCheckUpdateRspBody uin=");
            ((StringBuilder)localObject3).append(((SpecialCareInfo)localObject1).uin);
            ((StringBuilder)localObject3).append(", itemtype=");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(",itemVal=");
            ((StringBuilder)localObject3).append((String)localObject2);
            QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject3).toString());
          }
          if (localSnsUpdateItem.uint32_update_sns_type.get() == 13575)
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleCheckUpdateRspBody uin= ");
              ((StringBuilder)localObject2).append(l);
              QLog.d("HotFriend_ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject2).toString());
            }
            String str = String.valueOf(paramSnsUpateBuffer.uint64_uin.get());
            byte[] arrayOfByte = localSnsUpdateItem.bytes_value.get().toByteArray();
            localObject3 = paramFriendsManager.x(str);
            localObject2 = localObject3;
            if (localObject3 == null)
            {
              localObject2 = new ExtensionInfo();
              ((ExtensionInfo)localObject2).uin = str;
            }
            FriendListHandler.updateSnsData_HOT_FRIEND_CHAT_LEVEL_TYPE(str, arrayOfByte, (ExtensionInfo)localObject2);
            paramFriendsManager.a((ExtensionInfo)localObject2);
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
        ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendGroupList(true);
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager)
  {
    if (paramContentItem.msg_genderfiled.has())
    {
      paramContentItem = (Oidb_0x5e0.GenderFiled)paramContentItem.msg_genderfiled.get();
      long l = paramContentItem.uint64_uin.get();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l);
      ((StringBuilder)localObject).append("");
      localObject = paramFriendsManager.f(((StringBuilder)localObject).toString());
      if (localObject != null)
      {
        int j = paramContentItem.uint32_gender.get();
        int i;
        if (j == 1)
        {
          i = 0;
        }
        else if (j == 2)
        {
          i = 1;
        }
        else
        {
          i = j;
          if (j == 0) {
            i = 2;
          }
        }
        ((Card)localObject).shGender = ((short)i);
        if (Utils.a(this.a.getCurrentAccountUin(), String.valueOf(l)))
        {
          paramContentItem = (INearbyCardManager)this.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
          if (paramContentItem != null) {
            paramContentItem.c(((Card)localObject).shGender);
          }
        }
        paramFriendsManager.a((Card)localObject);
        if (QLog.isColorLevel())
        {
          paramContentItem = new StringBuilder();
          paramContentItem.append("CheckUpdate  sex: uin = ");
          paramFriendsManager = new StringBuilder();
          paramFriendsManager.append(l);
          paramFriendsManager.append("temp");
          paramContentItem.append(paramFriendsManager.toString().substring(0, 4));
          paramContentItem.append(" sex = ");
          paramContentItem.append(i);
          QLog.d("ProfileService.CheckUpdateReq", 2, paramContentItem.toString());
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager, TroopManager paramTroopManager, ArrayList<Friends> paramArrayList1, ArrayList<Friends> paramArrayList2, Friends[] paramArrayOfFriends, int paramInt, ArrayList<TroopInfo> paramArrayList, ArrayList<SpecialCareInfo> paramArrayList3, Map<String, Boolean> paramMap, ArrayList<String> paramArrayList4)
  {
    ClassicHeadActivityManager.FriendHeadFlagItem localFriendHeadFlagItem = new ClassicHeadActivityManager.FriendHeadFlagItem(0L);
    localFriendHeadFlagItem.a();
    switch (paramContentItem.uint32_update_profile_id.get())
    {
    case 8: 
    case 14: 
    default: 
      break;
    case 18: 
      if (paramContentItem.msg_mutual_mark_data.has()) {
        MutualMarkDataS2CHandleHelper.a(this.a, (Oidb_0xd6b.MutualMarkData)paramContentItem.msg_mutual_mark_data.get());
      }
      break;
    case 17: 
      if (paramContentItem.msg_ext_sns_frd_data.has()) {
        ExtSnsFrdDataHandleHelper.a(this.a, (Oidb_0xd50.ExtSnsFrdData)paramContentItem.msg_ext_sns_frd_data.get());
      }
      break;
    case 16: 
      if (paramContentItem.msg_intimate_info.has()) {
        FriendIntimateRelationshipHelper.a(this.a, (intimate_relation.IntimateInfo)paramContentItem.msg_intimate_info.get());
      }
      break;
    case 15: 
      a(paramContentItem, paramFriendsManager, localFriendHeadFlagItem);
      break;
    case 13: 
      b(paramContentItem, paramFriendsManager);
      break;
    case 12: 
      e(paramContentItem, paramFriendsManager);
      break;
    case 11: 
      d(paramContentItem, paramFriendsManager);
      break;
    case 10: 
      c(paramContentItem, paramFriendsManager);
      break;
    case 9: 
      a(paramContentItem, paramFriendsManager, paramArrayList3, paramMap, paramArrayList4);
      break;
    case 7: 
      a(paramContentItem, paramFriendsManager, paramArrayOfFriends, paramInt);
      break;
    case 6: 
      a(paramContentItem);
      break;
    case 5: 
      a(paramContentItem, paramTroopManager, paramArrayList);
      break;
    case 3: 
      a(paramContentItem, paramFriendsManager, paramArrayList2);
      break;
    case 2: 
      a(paramContentItem, paramFriendsManager);
      break;
    case 1: 
      a(paramContentItem, paramFriendsManager, paramArrayList1, paramArrayOfFriends, paramInt);
    }
    if (!TextUtils.isEmpty(localFriendHeadFlagItem.a))
    {
      paramContentItem = (ClassicHeadActivityManager)this.a.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
      if (paramContentItem != null) {
        paramContentItem.a(localFriendHeadFlagItem);
      }
      localFriendHeadFlagItem.a();
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager, ClassicHeadActivityManager.FriendHeadFlagItem paramFriendHeadFlagItem)
  {
    if (paramContentItem.msg_profile_info.has())
    {
      paramContentItem = (Oidb_0x5e0.ProfileInfo)paramContentItem.msg_profile_info.get();
      long l = paramContentItem.uint64_uin.get();
      Object localObject2 = paramContentItem.rpt_msg_profile_info.get();
      paramFriendHeadFlagItem.a();
      paramFriendHeadFlagItem.a = Long.toString(l);
      IApolloManagerService localIApolloManagerService = (IApolloManagerService)this.a.getRuntimeService(IApolloManagerService.class, "all");
      paramContentItem = (IApolloDaoManagerService)this.a.getRuntimeService(IApolloDaoManagerService.class, "all");
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l);
      ((StringBuilder)localObject1).append("");
      localObject1 = paramContentItem.getApolloBaseInfo(((StringBuilder)localObject1).toString());
      localObject2 = ((List)localObject2).iterator();
      boolean bool = false;
      while (((Iterator)localObject2).hasNext())
      {
        Oidb_0x5e0.ProfileTvInfo localProfileTvInfo = (Oidb_0x5e0.ProfileTvInfo)((Iterator)localObject2).next();
        int i = localProfileTvInfo.uint32_field_id.get();
        localProfileTvInfo.uint32_field_type.get();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("Check update for profile field uin: ");
          StringBuilder localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(l);
          localStringBuilder2.append("temp");
          localStringBuilder1.append(localStringBuilder2.toString().substring(0, 4));
          localStringBuilder1.append(",field: ");
          localStringBuilder1.append(i);
          localStringBuilder1.append(", int_value: ");
          localStringBuilder1.append(0L);
          QLog.d("ProfileService.CheckUpdateReq", 2, localStringBuilder1.toString());
        }
        bool |= a(localProfileTvInfo, paramFriendsManager, l, i, localIApolloManagerService, (ApolloBaseInfo)localObject1);
        if (i != 20015)
        {
          if (i != 27201)
          {
            if (i != 27218)
            {
              if (i != 27254)
              {
                if (i != 40530)
                {
                  if (i != 40556)
                  {
                    if (i == 42099) {
                      paramFriendHeadFlagItem.b = localProfileTvInfo.uint64_field_int_value.get();
                    }
                  }
                  else {
                    paramFriendHeadFlagItem.d = localProfileTvInfo.uint64_field_int_value.get();
                  }
                }
                else {
                  a(localProfileTvInfo, paramFriendsManager, l);
                }
              }
              else {
                c(localProfileTvInfo, paramFriendsManager, l);
              }
            }
            else {
              b(localProfileTvInfo, paramFriendsManager, l);
            }
          }
          else {
            d(localProfileTvInfo, paramFriendsManager, l);
          }
        }
        else {
          paramFriendHeadFlagItem.c = localProfileTvInfo.uint64_field_int_value.get();
        }
      }
      if (bool) {
        paramContentItem.saveOrUpdateApolloBaseInfo((ApolloBaseInfo)localObject1);
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager, ArrayList<Friends> paramArrayList)
  {
    if (paramContentItem.msg_friendremark.has())
    {
      paramContentItem = (Oidb_0x5e0.FriendRemark)paramContentItem.msg_friendremark.get();
      if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()))
      {
        long l = paramContentItem.uint64_uin.get();
        String str = paramContentItem.bytes_value.get().toStringUtf8();
        if (QLog.isColorLevel())
        {
          paramContentItem = new StringBuilder();
          paramContentItem.append("CheckUpdate Remark：uin = ");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("temp");
          paramContentItem.append(((StringBuilder)localObject).toString().substring(0, 4));
          paramContentItem.append(" 备注内容 = ");
          paramContentItem.append(MessageRecordUtil.a(str));
          QLog.d("ProfileService.CheckUpdateReq", 2, paramContentItem.toString());
        }
        Object localObject = paramFriendsManager.m(Long.toString(l));
        paramContentItem = null;
        if (localObject != null) {
          paramContentItem = ((Friends)localObject).remark;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        paramFriendsManager = paramFriendsManager.d(localStringBuilder.toString(), str);
        if ((localObject != null) && (((Friends)localObject).isFriend()) && (b(str, paramContentItem))) {
          paramArrayList.add(paramFriendsManager);
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager, ArrayList<SpecialCareInfo> paramArrayList, Map<String, Boolean> paramMap, ArrayList<String> paramArrayList1)
  {
    if (paramContentItem.msg_general_buffer.has())
    {
      Oidb_0x5e0.GeneralBuffer localGeneralBuffer = (Oidb_0x5e0.GeneralBuffer)paramContentItem.msg_general_buffer.get();
      if ((localGeneralBuffer != null) && (localGeneralBuffer.bytes_value.has()))
      {
        paramContentItem = new Oidb_0x5d0.SnsUpateBuffer();
        try
        {
          paramContentItem.mergeFrom(localGeneralBuffer.bytes_value.get().toByteArray());
        }
        catch (Exception localException)
        {
          paramContentItem = null;
          localException.printStackTrace();
        }
        if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()) && (paramContentItem.rpt_uin32_idlist.has())) {
          paramMap = paramContentItem.rpt_uin32_idlist.get().iterator();
        }
        while (paramMap.hasNext()) {
          if (((Integer)paramMap.next()).intValue() == 4051)
          {
            paramArrayList = String.valueOf(paramContentItem.uint64_uin.get());
            if (QLog.isColorLevel())
            {
              if (paramArrayList.length() >= 4) {
                paramFriendsManager = paramArrayList.substring(paramArrayList.length() - 4);
              } else {
                paramFriendsManager = paramArrayList;
              }
              paramArrayList1 = new StringBuilder();
              paramArrayList1.append("CheckUpdate ValueBit : shd: ");
              paramArrayList1.append(paramFriendsManager);
              QLog.d("ProfileService.CheckUpdateReq", 2, paramArrayList1.toString());
            }
            this.a.getMsgCache().b.put(paramArrayList, paramArrayList);
            continue;
            if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()) && (paramContentItem.rpt_msg_sns_update_item.has())) {
              a(paramContentItem, paramFriendsManager, paramArrayList, paramMap, paramArrayList1);
            }
          }
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager, ArrayList<Friends> paramArrayList, Friends[] paramArrayOfFriends, int paramInt)
  {
    if (paramContentItem.msg_nicknamefiled.has())
    {
      paramContentItem = (Oidb_0x5e0.NickNameFiled)paramContentItem.msg_nicknamefiled.get();
      if ((paramContentItem != null) && (paramContentItem.uint64_uin.has()))
      {
        long l = paramContentItem.uint64_uin.get();
        String str = paramContentItem.bytes_value.get().toStringUtf8();
        if (QLog.isColorLevel())
        {
          paramContentItem = new StringBuilder();
          paramContentItem.append("CheckUpdate  Nick：uin = ");
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("temp");
          paramContentItem.append(((StringBuilder)localObject).toString().substring(0, 4));
          paramContentItem.append(" 昵称 = ");
          paramContentItem.append(MessageRecordUtil.a(str));
          QLog.d("ProfileService.CheckUpdateReq", 2, paramContentItem.toString());
        }
        Object localObject = paramFriendsManager.m(Long.toString(l));
        paramContentItem = null;
        if (localObject != null) {
          paramContentItem = ((Friends)localObject).name;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        paramFriendsManager = paramFriendsManager.c(localStringBuilder.toString(), str);
        paramArrayOfFriends[paramInt] = paramFriendsManager;
        if ((localObject != null) && (((Friends)localObject).isFriend()) && (a(str, paramContentItem))) {
          paramArrayList.add(paramFriendsManager);
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager, Friends[] paramArrayOfFriends, int paramInt)
  {
    if (paramContentItem.msg_value_bit.has())
    {
      Object localObject = (Oidb_0x5e0.ValueBit)paramContentItem.msg_value_bit.get();
      if ((localObject != null) && (((Oidb_0x5e0.ValueBit)localObject).uint64_uin.has()))
      {
        long l = ((Oidb_0x5e0.ValueBit)localObject).uint64_uin.get();
        paramContentItem = paramFriendsManager.m(Long.toString(l));
        int i;
        int j;
        int k;
        if (paramContentItem != null)
        {
          i = paramContentItem.qqVipInfo;
          j = paramContentItem.superQqInfo;
          k = paramContentItem.superVipInfo;
        }
        else
        {
          i = 0;
          j = 0;
          k = 0;
        }
        boolean bool = ((Oidb_0x5e0.ValueBit)localObject).bytes_identity_flag.has();
        int n = 1;
        int m;
        int i1;
        if ((bool) && (((Oidb_0x5e0.ValueBit)localObject).bytes_identity_flag.get().size() >= 3))
        {
          m = ((Oidb_0x5e0.ValueBit)localObject).bytes_identity_flag.get().byteAt(0);
          i1 = ((Oidb_0x5e0.ValueBit)localObject).bytes_identity_flag.get().byteAt(2);
          if (paramContentItem != null)
          {
            int i2 = paramContentItem.qqVipInfo;
            if ((m & 0xFC) != 0) {
              m = 1;
            } else {
              m = 0;
            }
            paramContentItem.qqVipInfo = (m << 24 | i2);
            i2 = paramContentItem.qqVipInfo;
            if ((i1 & 0x60) != 0) {
              m = 1;
            } else {
              m = 0;
            }
            paramContentItem.qqVipInfo = (i2 | m << 24);
          }
        }
        if ((((Oidb_0x5e0.ValueBit)localObject).bytes_ext_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject).bytes_ext_flag.get().size() >= 5))
        {
          m = ((Oidb_0x5e0.ValueBit)localObject).bytes_ext_flag.get().byteAt(5);
          if (paramContentItem != null)
          {
            i1 = paramContentItem.superVipInfo;
            if ((m & 0x20) != 0) {
              m = n;
            } else {
              m = 0;
            }
            paramContentItem.superVipInfo = (m << 24 | i1);
          }
        }
        if ((paramContentItem != null) && ((paramContentItem.superVipInfo != k) || (paramContentItem.qqVipInfo != i) || (paramContentItem.superQqInfo != j)))
        {
          if (QLog.isColorLevel())
          {
            paramFriendsManager = new StringBuilder();
            paramFriendsManager.append("find a vip user uin = ");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append("temp");
            paramFriendsManager.append(((StringBuilder)localObject).toString().substring(0, 4));
            paramFriendsManager.append(" superVipInfo = ");
            paramFriendsManager.append(paramContentItem.superVipInfo);
            paramFriendsManager.append(" qqVipInfo = ");
            paramFriendsManager.append(paramContentItem.qqVipInfo);
            paramFriendsManager.append(" superQqInfo = ");
            paramFriendsManager.append(paramContentItem.superQqInfo);
            QLog.d("ProfileService.CheckUpdateReq", 2, paramFriendsManager.toString());
          }
          paramArrayOfFriends[paramInt] = paramContentItem;
        }
      }
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(l);
        localStringBuilder.append("");
        paramTroopManager = paramTroopManager.f(localStringBuilder.toString());
        if (paramTroopManager != null)
        {
          paramTroopManager.troopname = paramContentItem;
          paramArrayList.add(paramTroopManager);
          if (QLog.isColorLevel())
          {
            paramTroopManager = new StringBuilder();
            paramTroopManager.append("CheckUpdate TroopName：uin = ");
            paramArrayList = new StringBuilder();
            paramArrayList.append(l);
            paramArrayList.append("temp");
            paramTroopManager.append(paramArrayList.toString().substring(0, 4));
            paramTroopManager.append(" 群名称内容 = ");
            paramTroopManager.append(MessageRecordUtil.a(paramContentItem));
            QLog.d("ProfileService.CheckUpdateReq", 2, paramTroopManager.toString());
          }
        }
      }
    }
  }
  
  private void a(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, FriendsManager paramFriendsManager, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(Long.toString(paramLong));
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
      paramFriendsManager.a(paramProfileTvInfo);
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = new StringBuilder();
      paramFriendsManager.append("update, Get magic font, uin= ");
      paramFriendsManager.append(paramLong);
      paramFriendsManager.append(", magicfont = ");
      paramFriendsManager.append(paramProfileTvInfo.magicFont);
      QLog.d("QQProfileItem", 2, paramFriendsManager.toString());
    }
  }
  
  private void a(Oidb_0x5e0.RspBody paramRspBody)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
    TroopManager localTroopManager = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject5 = paramRspBody.rpt_msg_contentItem.get();
    if (localObject5 == null) {
      return;
    }
    this.a.getMsgCache().c.addAndGet(((List)localObject5).size());
    boolean bool1;
    if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("QQProfileItem::handleCheckUpdateRspBody called contentitemlist size = ");
    ((StringBuilder)localObject1).append(((List)localObject5).size());
    ((StringBuilder)localObject1).append(" overFlag:");
    ((StringBuilder)localObject1).append(bool1);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = "ProfileService.CheckUpdateReq";
    QLog.i("ProfileService.CheckUpdateReq", 1, (String)localObject1);
    localObject1 = new Friends[((List)localObject5).size()];
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList8 = localArrayList4;
    ArrayList localArrayList9 = localArrayList5;
    ArrayList localArrayList6 = localArrayList3;
    HashMap localHashMap2 = localHashMap1;
    ArrayList localArrayList7 = localArrayList2;
    ArrayList localArrayList10 = localArrayList1;
    Object localObject4 = localObject1;
    Object localObject3 = localObject2;
    boolean bool2 = bool1;
    if (localObject5 != null)
    {
      localObject5 = ((List)localObject5).iterator();
      for (;;)
      {
        localArrayList8 = localArrayList4;
        localArrayList9 = localArrayList5;
        localArrayList6 = localArrayList3;
        localHashMap2 = localHashMap1;
        localArrayList7 = localArrayList2;
        localArrayList10 = localArrayList1;
        localObject4 = localObject1;
        localObject3 = localObject2;
        bool2 = bool1;
        if (!((Iterator)localObject5).hasNext()) {
          break;
        }
        localObject3 = (Oidb_0x5e0.ContentItem)((Iterator)localObject5).next();
        if (((Oidb_0x5e0.ContentItem)localObject3).uint32_update_profile_id.has()) {
          a((Oidb_0x5e0.ContentItem)localObject3, localFriendsManager, localTroopManager, localArrayList5, localArrayList4, (Friends[])localObject1, 0, localArrayList1, localArrayList2, localHashMap1, localArrayList3);
        }
      }
    }
    a(localArrayList9, localArrayList8);
    a(localArrayList10, localFriendsManager, localTroopManager);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleCheckUpdateRspBody, bulkSaveOrUpdateSpecialCareInfos,size=");
      ((StringBuilder)localObject1).append(localArrayList7.size());
      QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
    }
    if (localArrayList7.size() > 0)
    {
      localFriendsManager.d(localArrayList7);
      ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(97, true, new Object[] { Boolean.valueOf(true), localArrayList7 });
    }
    if (QLog.isColorLevel()) {
      QLog.d("tag_hidden_chat", 2, new Object[] { "0x5e0 hiddenChatMap.size:", Integer.valueOf(localHashMap2.size()) });
    }
    if (localHashMap2.size() > 0) {
      FriendsStatusUtil.a(localHashMap2, this.a);
    }
    if (localArrayList6.size() > 0) {
      ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(104, true, localArrayList6);
    }
    if ((bool2) && (this.a.getMsgCache().c.get() != 0))
    {
      localObject1 = new ArrayList();
      a(localFriendsManager, localObject4, 0, (ArrayList)localObject1);
      localObject2 = new Friends[((ArrayList)localObject1).size()];
      ((ArrayList)localObject1).toArray((Object[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CheckUpdate ValueBit update Friends count = ");
        ((StringBuilder)localObject1).append(0);
        ((StringBuilder)localObject1).append(" includeShield:");
        ((StringBuilder)localObject1).append(localObject2.length);
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
      }
      localFriendsManager.a((Friends[])localObject2, localObject2.length);
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("CheckUpdate ValueBit update Friends count = ");
        ((StringBuilder)localObject1).append(0);
        QLog.d((String)localObject3, 2, ((StringBuilder)localObject1).toString());
      }
      localFriendsManager.a(localObject4, 0);
    }
    b(paramRspBody);
    if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1))
    {
      this.b = null;
      this.a.getMsgCache().b.clear();
      this.a.getMsgCache().c.set(0);
      return;
    }
    if (paramRspBody.bytes_svrcontext.has())
    {
      this.b = paramRspBody.bytes_svrcontext.get();
      ((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getCheckUpdate(false, 1);
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!paramString1.equals(paramString2))) {
      bool = true;
    } else {
      bool = false;
    }
    if ((QLog.isColorLevel()) && (bool))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShouldUpdateDiscussinMemberInfoByName newFriendName = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",oldFriendName = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",result = ");
      localStringBuilder.append(bool);
      QLog.d("QQProfileItem", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean a(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, FriendsManager paramFriendsManager, long paramLong, int paramInt, IApolloManagerService paramIApolloManagerService, ApolloBaseInfo paramApolloBaseInfo)
  {
    boolean bool2 = true;
    switch (paramInt)
    {
    default: 
      break;
    case 42980: 
      paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
      if ((paramApolloBaseInfo != null) && (paramApolloBaseInfo.apolloStatus != paramLong))
      {
        paramApolloBaseInfo.apolloStatus = ((int)paramLong);
        return true;
      }
      break;
    case 42230: 
      paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
      if ((paramApolloBaseInfo != null) && (paramApolloBaseInfo.cmshow3dFlag != paramLong))
      {
        paramApolloBaseInfo.cmshow3dFlag = ((int)paramLong);
        return true;
      }
      break;
    case 42003: 
      paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
      if ((paramApolloBaseInfo != null) && (paramApolloBaseInfo.apolloVipFlag != paramLong))
      {
        paramApolloBaseInfo.apolloVipFlag = ((int)paramLong);
        return true;
      }
      break;
    case 41999: 
      paramLong = (int)paramProfileTvInfo.uint64_field_int_value.get();
      if ((paramApolloBaseInfo != null) && (paramApolloBaseInfo.apolloVipLevel != paramLong))
      {
        paramApolloBaseInfo.apolloVipLevel = ((int)paramLong);
        return true;
      }
      break;
    case 27210: 
      long l = paramProfileTvInfo.uint64_field_int_value.get();
      paramInt = paramApolloBaseInfo.apolloAISwitch;
      int i = (int)l;
      boolean bool1;
      if (paramInt != i)
      {
        paramApolloBaseInfo.apolloAISwitch = i;
        bool1 = bool2;
        if (String.valueOf(paramLong).equals(this.a.getCurrentUin()))
        {
          paramIApolloManagerService.updateUserFlag(i, 3);
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break label428;
      }
      paramProfileTvInfo = new StringBuilder();
      paramProfileTvInfo.append("apollo aiSwitch profileupdate :");
      paramProfileTvInfo.append(l);
      QLog.d("ProfileService.CheckUpdateReq", 2, paramProfileTvInfo.toString());
      return bool1;
    case 27206: 
      paramLong = paramProfileTvInfo.uint64_field_int_value.get();
      if ((paramLong < NetConnInfoCenter.getServerTime()) && (paramApolloBaseInfo != null) && (paramApolloBaseInfo.apolloSignValidTS != paramLong))
      {
        paramApolloBaseInfo.apolloLocalSignTs = paramApolloBaseInfo.apolloSignValidTS;
        paramApolloBaseInfo.apolloSignValidTS = paramLong;
        paramApolloBaseInfo.apolloSignStr = "";
        return true;
      }
      break;
    case 27059: 
      paramLong = paramProfileTvInfo.uint64_field_int_value.get();
      if ((paramApolloBaseInfo != null) && (paramApolloBaseInfo.apolloServerTS != paramLong))
      {
        paramApolloBaseInfo.apolloServerTS = paramLong;
        return true;
      }
      break;
    }
    bool2 = false;
    label428:
    return bool2;
  }
  
  public static void b(long paramLong, String paramString, DiscussionManager paramDiscussionManager)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateDiscussionMemberInfoRemark uin = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(",remarkName = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("QQProfileItem", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = paramDiscussionManager.b();
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject2).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramDiscussionManager.b(localDiscussionInfo.uin, Long.toString(paramLong));
        if ((localDiscussionMemberInfo != null) && (b(paramString, localDiscussionMemberInfo.inteRemark)))
        {
          localDiscussionMemberInfo.inteRemark = paramString;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateDiscussionMemberInfoRemark discussMem.memberName = ");
            localStringBuilder.append(localDiscussionMemberInfo.memberName);
            localStringBuilder.append(",discussMem.inteRemark = ");
            localStringBuilder.append(localDiscussionMemberInfo.inteRemark);
            localStringBuilder.append(",discussionUin = ");
            localStringBuilder.append(localDiscussionInfo.uin);
            QLog.d("QQProfileItem", 2, localStringBuilder.toString());
          }
          ((ArrayList)localObject1).add(localDiscussionMemberInfo);
        }
      }
      if (((ArrayList)localObject1).size() > 0)
      {
        paramDiscussionManager.b((List)localObject1);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(((ArrayList)localObject1).size()));
        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "updateDiscussMemberRemark", true, 0L, 0L, paramString, "", true);
      }
    }
  }
  
  private void b(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager)
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
          long l2 = 0xFFFFFFFF & paramContentItem.getInt();
          byte[] arrayOfByte = new byte[paramContentItem.getShort() & 0xFFFF];
          paramContentItem.get(arrayOfByte);
          ExtensionInfo localExtensionInfo = paramFriendsManager.x(Long.toString(l1));
          ExtensionInfoLogUtils.a("QQProfileItem", "handleUpdateProfileItemIdxNewRichStatus before fm.getExtensionInfo，friendUin:", localExtensionInfo);
          paramContentItem = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = Long.toString(l1);
          }
          if (paramContentItem.richTime != l2)
          {
            ExtensionRichStatus.a(paramContentItem, arrayOfByte, l2);
            paramContentItem.isAdded2C2C = SignatureManager.a(this.a, Long.toString(l1), ExtensionRichStatus.c(paramContentItem));
            ExtensionInfoLogUtils.a("QQProfileItem", "handleUpdateProfileItemIdxNewRichStatus before save，friendUin:", paramContentItem);
            paramFriendsManager.a(paramContentItem);
            if (QLog.isColorLevel())
            {
              paramFriendsManager = new StringBuilder();
              paramFriendsManager.append("insertSignMsgIfNeeded from QQProfileItem uin = ");
              paramFriendsManager.append(l1);
              paramFriendsManager.append(" result = ");
              paramFriendsManager.append(paramContentItem.isAdded2C2C);
              QLog.d("ProfileService.CheckUpdateReq", 2, paramFriendsManager.toString());
            }
          }
        }
      }
    }
  }
  
  private void b(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, FriendsManager paramFriendsManager, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(Long.toString(paramLong));
    paramProfileTvInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileTvInfo = new ExtensionInfo();
      paramProfileTvInfo.uin = Long.toString(paramLong);
    }
    if (paramProfileTvInfo.latestPLUpdateTimestamp != l)
    {
      paramProfileTvInfo.latestPLUpdateTimestamp = l;
      paramFriendsManager.a(paramProfileTvInfo);
      if (QLog.isColorLevel())
      {
        paramProfileTvInfo = new StringBuilder();
        paramProfileTvInfo.append("update uin=");
        paramProfileTvInfo.append(paramLong);
        paramProfileTvInfo.append(" latestplNewsTs=");
        paramProfileTvInfo.append(l);
        QLog.d("QQProfileItem", 2, paramProfileTvInfo.toString());
      }
    }
  }
  
  private void b(Oidb_0x5e0.RspBody paramRspBody)
  {
    Object localObject1 = paramRspBody.rpt_msg_ProfileListResult.get();
    if (localObject1 != null)
    {
      paramRspBody = this.a.getPreferences().edit();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Oidb_0x5e0.ProfileListResult)((Iterator)localObject1).next();
        if ((((Oidb_0x5e0.ProfileListResult)localObject2).uint32_result.has()) && (((Oidb_0x5e0.ProfileListResult)localObject2).uint32_result.get() == 0))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("get result =");
            localStringBuilder.append(((Oidb_0x5e0.ProfileListResult)localObject2).uint32_result.get());
            QLog.d("ProfileService.CheckUpdateReq", 2, localStringBuilder.toString());
          }
          if ((((Oidb_0x5e0.ProfileListResult)localObject2).uint32_update_profile_id.has()) && (((Oidb_0x5e0.ProfileListResult)localObject2).uint32_new_content_timestamp.has()))
          {
            int i = ((Oidb_0x5e0.ProfileListResult)localObject2).uint32_update_profile_id.get();
            int j = ((Oidb_0x5e0.ProfileListResult)localObject2).uint32_new_content_timestamp.get();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("inccheckupdatetimeStamp");
            ((StringBuilder)localObject2).append(i);
            paramRspBody.putLong(((StringBuilder)localObject2).toString(), j);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("handleCheckUpdateRspBody profileid:");
              ((StringBuilder)localObject2).append(i);
              ((StringBuilder)localObject2).append(" uint32_new_content_timestamp =");
              ((StringBuilder)localObject2).append(j);
              QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject2).toString());
            }
          }
        }
      }
      paramRspBody.commit();
    }
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    boolean bool1;
    if ((!TextUtils.isEmpty(paramString1)) && (!paramString1.equals(paramString2))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (TextUtils.isEmpty(paramString1))
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramString2)) {
        bool2 = true;
      }
    }
    if ((QLog.isColorLevel()) && (bool2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkShouldUpdateDiscussinMemberInfoByRemark ,newRemark = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(",oldRemark = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",result = ");
      localStringBuilder.append(bool2);
      QLog.d("QQProfileItem", 2, localStringBuilder.toString());
    }
    return bool2;
  }
  
  private void c(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager)
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
          Object localObject = paramFriendsManager.x(String.valueOf(l1));
          ExtensionInfoLogUtils.a("QQProfileItem", "handleUpdateProfileItemIdxFaceAddonId before fm.getExtensionInfo，friendUin:", (ExtensionInfo)localObject);
          paramContentItem = (Oidb_0x5e0.ContentItem)localObject;
          if (localObject == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = String.valueOf(l1);
          }
          paramContentItem.pendantId = l2;
          paramContentItem.timestamp = System.currentTimeMillis();
          ExtensionInfoLogUtils.a("QQProfileItem", "handleUpdateProfileItemIdxFaceAddonId before save，friendUin:", paramContentItem);
          paramFriendsManager.a(paramContentItem);
          if (QLog.isColorLevel())
          {
            paramFriendsManager = new StringBuilder();
            paramFriendsManager.append("Check update, Get Pendant, uin=");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append("temp");
            paramFriendsManager.append(((StringBuilder)localObject).toString().substring(0, 4));
            paramFriendsManager.append(", id=");
            paramFriendsManager.append(paramContentItem.pendantId);
            QLog.d("ProfileService.CheckUpdateReq", 2, paramFriendsManager.toString());
          }
        }
      }
    }
  }
  
  private void c(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, FriendsManager paramFriendsManager, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(Long.toString(paramLong));
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
      paramFriendsManager.a(paramProfileTvInfo);
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = new StringBuilder();
      paramFriendsManager.append("update, Get font effect, uin= ");
      paramFriendsManager.append(paramLong);
      paramFriendsManager.append(", fontEffect = ");
      paramFriendsManager.append(paramProfileTvInfo.fontEffect);
      paramFriendsManager.append(", updateTime = ");
      paramFriendsManager.append(paramProfileTvInfo.fontEffectLastUpdateTime);
      QLog.d("QQProfileItem", 2, paramFriendsManager.toString());
    }
  }
  
  private void d(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager)
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
          ExtensionInfo localExtensionInfo = paramFriendsManager.x(String.valueOf(l1));
          paramContentItem = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = String.valueOf(l1);
          }
          l2 = paramContentItem.uVipFont;
          long l3 = i;
          if (l2 != l3)
          {
            paramContentItem.uVipFont = l3;
            paramContentItem.timestamp = System.currentTimeMillis();
            paramFriendsManager.a(paramContentItem);
          }
          if (QLog.isColorLevel())
          {
            paramContentItem = new StringBuilder();
            paramContentItem.append("Check update, Get Font, uin=");
            paramFriendsManager = new StringBuilder();
            paramFriendsManager.append(l1);
            paramFriendsManager.append("temp");
            paramContentItem.append(paramFriendsManager.toString().substring(0, 4));
            paramContentItem.append(", id=");
            paramContentItem.append(i);
            QLog.d("ProfileService.CheckUpdateReq", 2, paramContentItem.toString());
          }
        }
      }
    }
  }
  
  private void d(Oidb_0x5e0.ProfileTvInfo paramProfileTvInfo, FriendsManager paramFriendsManager, long paramLong)
  {
    long l = paramProfileTvInfo.uint64_field_int_value.get();
    ExtensionInfo localExtensionInfo = ((FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER)).x(Long.toString(paramLong));
    paramProfileTvInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileTvInfo = new ExtensionInfo();
      paramProfileTvInfo.uin = Long.toString(paramLong);
    }
    if ((paramProfileTvInfo.uVipFont != FontManagerConstants.parseFontId(l)) || (paramProfileTvInfo.vipFontType != FontManagerConstants.parseFontType(l)))
    {
      paramProfileTvInfo.uVipFont = FontManagerConstants.parseFontId(l);
      paramProfileTvInfo.vipFontType = FontManagerConstants.parseFontType(l);
      paramProfileTvInfo.timestamp = System.currentTimeMillis();
      paramFriendsManager.a(paramProfileTvInfo);
    }
    if (QLog.isColorLevel())
    {
      paramFriendsManager = new StringBuilder();
      paramFriendsManager.append("update, Get Font, uin=");
      paramFriendsManager.append(paramLong);
      paramFriendsManager.append(", id=");
      paramFriendsManager.append(paramProfileTvInfo.uVipFont);
      paramFriendsManager.append(", type = ");
      paramFriendsManager.append(paramProfileTvInfo.vipFontType);
      QLog.d("QQProfileItem", 2, paramFriendsManager.toString());
    }
  }
  
  private void e(Oidb_0x5e0.ContentItem paramContentItem, FriendsManager paramFriendsManager)
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
          ExtensionInfo localExtensionInfo = paramFriendsManager.x(String.valueOf(l1));
          paramContentItem = localExtensionInfo;
          if (localExtensionInfo == null)
          {
            paramContentItem = new ExtensionInfo();
            paramContentItem.uin = String.valueOf(l1);
          }
          l2 = paramContentItem.colorRingId;
          long l3 = i;
          if (l2 != l3)
          {
            paramContentItem.colorRingId = l3;
            paramContentItem.timestamp = System.currentTimeMillis();
            paramFriendsManager.a(paramContentItem);
            ColorRingManager.a(paramContentItem.uin, 1, this.a.getCurrentAccountUin());
          }
          if (QLog.isColorLevel())
          {
            paramContentItem = new StringBuilder();
            paramContentItem.append("Check update, Get colorRing, uin=");
            paramFriendsManager = new StringBuilder();
            paramFriendsManager.append(l1);
            paramFriendsManager.append("temp");
            paramContentItem.append(paramFriendsManager.toString().substring(0, 4));
            paramContentItem.append(", id=");
            paramContentItem.append(i);
            QLog.d("ProfileService.CheckUpdateReq", 2, paramContentItem.toString());
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
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("QQProfileItem::getCheckUpdateItemData called checkUpdateType:");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject1).toString());
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 101;
    Object localObject1 = this.a.getPreferences();
    Object localObject3 = new long[19];
    int i = 0;
    while (i < 19)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("inccheckupdatetimeStamp");
      ((StringBuilder)localObject2).append(Integer.toString(i));
      localObject3[i] = (((SharedPreferences)localObject1).getLong(((StringBuilder)localObject2).toString(), 0L) - 0L);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(50);
      i = 0;
      while (i < 19)
      {
        ((StringBuilder)localObject1).append(Long.toString(localObject3[i]));
        ((StringBuilder)localObject1).append(" ");
        i += 1;
      }
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject1).toString());
    }
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList1 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList1.uint32_need_content.set(0);
    localUpdateProfileList1.uint32_update_profile_id.set(1);
    localUpdateProfileList1.uint32_friendlist_type.set(1);
    localUpdateProfileList1.uint32_get_content_timestamp.set((int)localObject3[1]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList2 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList2.uint32_need_content.set(0);
    localUpdateProfileList2.uint32_update_profile_id.set(2);
    localUpdateProfileList2.uint32_friendlist_type.set(1);
    localUpdateProfileList2.uint32_get_content_timestamp.set((int)localObject3[2]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList3 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList3.uint32_need_content.set(0);
    localUpdateProfileList3.uint32_update_profile_id.set(3);
    localUpdateProfileList3.uint32_friendlist_type.set(0);
    localUpdateProfileList3.uint32_get_content_timestamp.set((int)localObject3[3]);
    Object localObject2 = null;
    if (!((FriendListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).isSyncingAllFriendsRichStatus())
    {
      localObject1 = new Oidb_0x5e0.UpdateProfileList();
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_need_content.set(0);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_update_profile_id.set(13);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_friendlist_type.set(1);
      ((Oidb_0x5e0.UpdateProfileList)localObject1).uint32_get_content_timestamp.set((int)localObject3[13]);
    }
    else
    {
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("ProfileService.CheckUpdateReq", 2, "skip rich status check update");
        localObject1 = localObject2;
      }
    }
    localObject2 = new Oidb_0x5e0.UpdateProfileList();
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_need_content.set(0);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_update_profile_id.set(5);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_friendlist_type.set(0);
    ((Oidb_0x5e0.UpdateProfileList)localObject2).uint32_get_content_timestamp.set((int)localObject3[5]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList4 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList4.uint32_need_content.set(1);
    localUpdateProfileList4.uint32_update_profile_id.set(6);
    localUpdateProfileList4.uint32_friendlist_type.set(0);
    localUpdateProfileList4.uint32_get_content_timestamp.set((int)localObject3[6]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList5 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList5.uint32_need_content.set(0);
    localUpdateProfileList5.uint32_update_profile_id.set(7);
    localUpdateProfileList5.uint32_friendlist_type.set(1);
    localUpdateProfileList5.uint32_get_content_timestamp.set((int)localObject3[7]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList6 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList6.uint32_need_content.set(0);
    localUpdateProfileList6.uint32_update_profile_id.set(9);
    localUpdateProfileList6.uint32_friendlist_type.set(1);
    localUpdateProfileList6.uint32_get_content_timestamp.set((int)localObject3[9]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList7 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList7.uint32_need_content.set(0);
    localUpdateProfileList7.uint32_update_profile_id.set(10);
    localUpdateProfileList7.uint32_friendlist_type.set(1);
    localUpdateProfileList7.uint32_get_content_timestamp.set((int)localObject3[10]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList8 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList8.uint32_need_content.set(0);
    localUpdateProfileList8.uint32_update_profile_id.set(11);
    localUpdateProfileList8.uint32_friendlist_type.set(1);
    localUpdateProfileList8.uint32_get_content_timestamp.set((int)localObject3[11]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList9 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList9.uint32_need_content.set(0);
    localUpdateProfileList9.uint32_update_profile_id.set(12);
    localUpdateProfileList9.uint32_friendlist_type.set(1);
    localUpdateProfileList9.uint32_get_content_timestamp.set((int)localObject3[12]);
    Oidb_0x5e0.UpdateProfileList localUpdateProfileList10 = new Oidb_0x5e0.UpdateProfileList();
    localUpdateProfileList10.uint32_need_content.set(0);
    localUpdateProfileList10.uint32_update_profile_id.set(15);
    localUpdateProfileList10.uint32_friendlist_type.set(1);
    localUpdateProfileList10.uint32_get_content_timestamp.set((int)localObject3[15]);
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(42003));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(41999));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(42980));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(27059));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(27206));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(27210));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(42230));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(27201));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(40530));
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(27254));
    Object localObject4 = (ClassicHeadActivityManager)this.a.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localObject4 != null) && (((ClassicHeadActivityManager)localObject4).a()))
    {
      localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(42099));
      localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(40556));
      localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(20015));
      if (QLog.isColorLevel()) {
        QLog.d("QQProfileItem", 2, "ClassicHeadActivity Params is add");
      }
    }
    localUpdateProfileList10.rpt_uint32_profile_field_list.add(Integer.valueOf(27218));
    localObject4 = new Oidb_0x5e0.UpdateProfileList();
    ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_need_content.set(0);
    ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_update_profile_id.set(16);
    ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_friendlist_type.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject4).uint32_get_content_timestamp.set((int)localObject3[16]);
    if (QLog.isColorLevel())
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("getCheckUpdateItemData IDX_INTIMATE_FIELD_LIST time::");
      ((StringBuilder)localObject5).append((int)localObject3[16]);
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject5).toString());
    }
    Object localObject5 = new Oidb_0x5e0.UpdateProfileList();
    ((Oidb_0x5e0.UpdateProfileList)localObject5).uint32_need_content.set(0);
    ((Oidb_0x5e0.UpdateProfileList)localObject5).uint32_update_profile_id.set(17);
    ((Oidb_0x5e0.UpdateProfileList)localObject5).uint32_friendlist_type.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject5).uint32_get_content_timestamp.set((int)localObject3[17]);
    Object localObject6 = new Oidb_0xd50.ReqBody();
    ((Oidb_0xd50.ReqBody)localObject6).appid.set(10002L);
    ((Oidb_0xd50.ReqBody)localObject6).req_music_switch.set(1);
    ((Oidb_0xd50.ReqBody)localObject6).req_ksing_switch.set(1);
    ((Oidb_0xd50.ReqBody)localObject6).req_mutualmark_lbsshare.set(1);
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, new Object[] { "getCheckUpdateItemData: invoked. ", " req lbs share profile. ", "此处很可能触发增量资料更新限频逻辑，会导致状态刷新不及时。（消息tab外显图标未刷新等等问题）" });
    }
    ((Oidb_0xd50.ReqBody)localObject6).req_mutualmark_alienation.set(1);
    ((Oidb_0xd50.ReqBody)localObject6).req_aio_quick_app.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject5).msg_0xd50_req.set((MessageMicro)localObject6);
    if (QLog.isColorLevel())
    {
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("getCheckUpdateItemData profileid:17, ");
      ((StringBuilder)localObject6).append((int)localObject3[17]);
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject6).toString());
    }
    localObject6 = new Oidb_0x5e0.UpdateProfileList();
    ((Oidb_0x5e0.UpdateProfileList)localObject6).uint32_need_content.set(0);
    ((Oidb_0x5e0.UpdateProfileList)localObject6).uint32_update_profile_id.set(18);
    ((Oidb_0x5e0.UpdateProfileList)localObject6).uint32_friendlist_type.set(1);
    ((Oidb_0x5e0.UpdateProfileList)localObject6).uint32_get_content_timestamp.set((int)localObject3[18]);
    Object localObject7 = new Oidb_0xd6b.ReqBody();
    ((Oidb_0xd6b.ReqBody)localObject7).start_time.set((int)localObject3[18]);
    ((Oidb_0x5e0.UpdateProfileList)localObject6).msg_0xd6b_req.set((MessageMicro)localObject7);
    if (QLog.isColorLevel())
    {
      localObject7 = new StringBuilder();
      ((StringBuilder)localObject7).append("getCheckUpdateItemData profileid:18, ");
      ((StringBuilder)localObject7).append((int)localObject3[18]);
      QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject7).toString());
    }
    localObject3 = new Oidb_0x5e0.ReqBody();
    if (this.b != null) {
      ((Oidb_0x5e0.ReqBody)localObject3).bytes_svrcontext.set(this.b);
    }
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList1);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList2);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList3);
    if (localObject1 != null) {
      ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add((MessageMicro)localObject1);
    }
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add((MessageMicro)localObject2);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList4);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList5);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList6);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList7);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList8);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList9);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add(localUpdateProfileList10);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add((MessageMicro)localObject4);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add((MessageMicro)localObject5);
    ((Oidb_0x5e0.ReqBody)localObject3).rpt_msg_update_profile_list.add((MessageMicro)localObject6);
    if (paramInt == 8) {
      ((Oidb_0x5e0.ReqBody)localObject3).uint32_forced_update.set(1);
    }
    localReqItem.vecParam = ((Oidb_0x5e0.ReqBody)localObject3).toByteArray();
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QQProfileItem::handleCheckUpdateItemData called item.cResult = ");
    ((StringBuilder)localObject).append(paramRespItem.cResult);
    QLog.i("ProfileService.CheckUpdateReq", 1, ((StringBuilder)localObject).toString());
    if ((paramRespItem.eServiceID == 101) && (paramRespItem.cResult == 2))
    {
      paramRespItem = paramRespItem.vecUpdate;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleCheckUpdateItemData pbdata.length=");
        int i;
        if (paramRespItem != null) {
          i = paramRespItem.length;
        } else {
          i = 0;
        }
        ((StringBuilder)localObject).append(i);
        QLog.d("QQProfileItem", 2, ((StringBuilder)localObject).toString());
      }
      localObject = new Oidb_0x5e0.RspBody();
      try
      {
        paramRespItem = (Oidb_0x5e0.RspBody)((Oidb_0x5e0.RspBody)localObject).mergeFrom(paramRespItem);
      }
      catch (Exception paramRespItem)
      {
        paramRespItem.printStackTrace();
        paramRespItem = null;
      }
      if (paramRespItem == null) {
        return;
      }
      a(paramRespItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQProfileItem
 * JD-Core Version:    0.7.0.1
 */