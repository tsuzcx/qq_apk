package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager.FriendHeadFlagItem;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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

public class QQProfileItem
  implements CheckUpdateItemInterface
{
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ByteStringMicro jdField_a_of_type_ComTencentMobileqqPbByteStringMicro;
  
  public QQProfileItem(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
  }
  
  public static void a(long paramLong, String paramString, DiscussionManager paramDiscussionManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoName uin = " + paramLong + ",nickName = " + paramString);
    }
    Object localObject = paramDiscussionManager.a();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramDiscussionManager.a(localDiscussionInfo.uin, Long.toString(paramLong));
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
        paramDiscussionManager.b(localArrayList);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(localArrayList.size()));
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "updateDiscussMemberNick", true, 0L, 0L, paramString, "", true);
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
  
  private void a(Oidb_0x5e0.RspBody paramRspBody)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject2 = paramRspBody.rpt_msg_contentItem.get();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(((List)localObject2).size());
    if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1)) {}
    label1549:
    label4771:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::handleCheckUpdateRspBody called contentitemlist size = " + ((List)localObject2).size() + " overFlag:" + bool1);
      }
      Friends[] arrayOfFriends = new Friends[((List)localObject2).size()];
      int j = 0;
      int i = 0;
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList5 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      Object localObject1 = null;
      if (localObject2 != null)
      {
        Iterator localIterator1 = ((List)localObject2).iterator();
        j = i;
        if (localIterator1.hasNext())
        {
          localObject2 = (Oidb_0x5e0.ContentItem)localIterator1.next();
          if (!((Oidb_0x5e0.ContentItem)localObject2).uint32_update_profile_id.has()) {
            break label6943;
          }
          switch (((Oidb_0x5e0.ContentItem)localObject2).uint32_update_profile_id.get())
          {
          case 8: 
          case 14: 
          default: 
            label324:
            if ((localObject1 != null) && (!TextUtils.isEmpty(((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1).jdField_a_of_type_JavaLangString)))
            {
              localObject2 = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
              if (localObject2 != null) {
                ((ClassicHeadActivityManager)localObject2).a((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1);
              }
              ((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1).a();
            }
            break;
          }
        }
      }
      label4524:
      label6838:
      for (;;)
      {
        break;
        if (!((Oidb_0x5e0.ContentItem)localObject2).msg_nicknamefiled.has()) {
          break label324;
        }
        localObject2 = (Oidb_0x5e0.NickNameFiled)((Oidb_0x5e0.ContentItem)localObject2).msg_nicknamefiled.get();
        j = i;
        Object localObject6;
        Object localObject7;
        if (localObject2 != null)
        {
          j = i;
          if (((Oidb_0x5e0.NickNameFiled)localObject2).uint64_uin.has())
          {
            l1 = ((Oidb_0x5e0.NickNameFiled)localObject2).uint64_uin.get();
            localObject5 = ((Oidb_0x5e0.NickNameFiled)localObject2).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  Nick：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 昵称 = " + Utils.a((String)localObject5));
            }
            localObject6 = localFriendsManager.c(Long.toString(l1));
            localObject2 = null;
            if (localObject6 != null) {
              localObject2 = ((Friends)localObject6).name;
            }
            localObject7 = localFriendsManager.a(l1 + "", (String)localObject5);
            arrayOfFriends[i] = localObject7;
            if ((localObject6 != null) && (((Friends)localObject6).isFriend()) && (a((String)localObject5, (String)localObject2))) {
              localArrayList5.add(localObject7);
            }
            j = i + 1;
          }
        }
        i = j;
        break label324;
        if (!((Oidb_0x5e0.ContentItem)localObject2).msg_genderfiled.has()) {
          break label324;
        }
        Object localObject5 = (Oidb_0x5e0.GenderFiled)((Oidb_0x5e0.ContentItem)localObject2).msg_genderfiled.get();
        long l1 = ((Oidb_0x5e0.GenderFiled)localObject5).uint64_uin.get();
        localObject2 = localFriendsManager.a(l1 + "");
        if (localObject2 != null)
        {
          j = ((Oidb_0x5e0.GenderFiled)localObject5).uint32_gender.get();
          if (j != 1) {
            break label829;
          }
          j = 0;
        }
        label3644:
        for (;;)
        {
          ((Card)localObject2).shGender = ((short)j);
          if (Utils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), String.valueOf(l1)))
          {
            localObject5 = (NearbyCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
            if (localObject5 != null) {
              ((NearbyCardManager)localObject5).b(((Card)localObject2).shGender);
            }
          }
          localFriendsManager.a((Card)localObject2);
          if (QLog.isColorLevel()) {
            QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate  sex: uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " sex = " + j);
          }
          break;
          label829:
          if (j == 2)
          {
            j = 1;
          }
          else if (j == 0)
          {
            j = 2;
            continue;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_friendremark.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.FriendRemark)((Oidb_0x5e0.ContentItem)localObject2).msg_friendremark.get();
            if ((localObject2 != null) && (((Oidb_0x5e0.FriendRemark)localObject2).uint64_uin.has()))
            {
              l1 = ((Oidb_0x5e0.FriendRemark)localObject2).uint64_uin.get();
              localObject5 = ((Oidb_0x5e0.FriendRemark)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate Remark：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 备注内容 = " + Utils.a((String)localObject5));
              }
              localObject6 = localFriendsManager.c(Long.toString(l1));
              localObject2 = null;
              if (localObject6 != null) {
                localObject2 = ((Friends)localObject6).remark;
              }
              localObject7 = localFriendsManager.b(l1 + "", (String)localObject5);
              if ((localObject6 != null) && (((Friends)localObject6).isFriend()) && (b((String)localObject5, (String)localObject2))) {
                localArrayList4.add(localObject7);
              }
            }
            break;
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_groupname.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.GroupName)((Oidb_0x5e0.ContentItem)localObject2).msg_groupname.get();
            if ((localObject2 != null) && (((Oidb_0x5e0.GroupName)localObject2).uint64_group_uin.has()))
            {
              l1 = ((Oidb_0x5e0.GroupName)localObject2).uint64_group_uin.get();
              localObject2 = ((Oidb_0x5e0.GroupName)localObject2).bytes_value.get().toStringUtf8();
              localObject5 = localTroopManager.a(l1 + "");
              if (localObject5 != null)
              {
                ((TroopInfo)localObject5).troopname = ((String)localObject2);
                localArrayList3.add(localObject5);
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate TroopName：uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " 群名称内容 = " + Utils.a((String)localObject2));
                }
              }
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_friend_teamlist.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.FriendTeamList)((Oidb_0x5e0.ContentItem)localObject2).msg_friend_teamlist.get();
            if ((localObject2 != null) && (((Oidb_0x5e0.FriendTeamList)localObject2).uint32_update_flag.has()) && (((Oidb_0x5e0.FriendTeamList)localObject2).uint32_update_flag.get() == 1))
            {
              if (QLog.isColorLevel()) {
                QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate GroupList：uin = ");
              }
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(true);
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_value_bit.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.ValueBit)((Oidb_0x5e0.ContentItem)localObject2).msg_value_bit.get();
            j = i;
            int n;
            int m;
            int k;
            int i1;
            int i2;
            if (localObject2 != null)
            {
              j = i;
              if (((Oidb_0x5e0.ValueBit)localObject2).uint64_uin.has())
              {
                l1 = ((Oidb_0x5e0.ValueBit)localObject2).uint64_uin.get();
                localObject5 = localFriendsManager.c(Long.toString(l1));
                n = 0;
                m = 0;
                k = 0;
                if (localObject5 != null)
                {
                  n = ((Friends)localObject5).qqVipInfo;
                  m = ((Friends)localObject5).superQqInfo;
                  k = ((Friends)localObject5).superVipInfo;
                }
                if ((((Oidb_0x5e0.ValueBit)localObject2).bytes_identity_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject2).bytes_identity_flag.get().size() >= 3))
                {
                  j = ((Oidb_0x5e0.ValueBit)localObject2).bytes_identity_flag.get().byteAt(0);
                  i1 = ((Oidb_0x5e0.ValueBit)localObject2).bytes_identity_flag.get().byteAt(2);
                  if (localObject5 != null)
                  {
                    i2 = ((Friends)localObject5).qqVipInfo;
                    if ((j & 0xFC) == 0) {
                      break label1786;
                    }
                    j = 1;
                    label1520:
                    ((Friends)localObject5).qqVipInfo = (j << 24 | i2);
                    i2 = ((Friends)localObject5).qqVipInfo;
                    if ((i1 & 0x60) == 0) {
                      break label1791;
                    }
                    j = 1;
                    ((Friends)localObject5).qqVipInfo = (j << 24 | i2);
                  }
                }
                if ((((Oidb_0x5e0.ValueBit)localObject2).bytes_ext_flag.has()) && (((Oidb_0x5e0.ValueBit)localObject2).bytes_ext_flag.get().size() >= 5))
                {
                  j = ((Oidb_0x5e0.ValueBit)localObject2).bytes_ext_flag.get().byteAt(5);
                  if (localObject5 != null)
                  {
                    i1 = ((Friends)localObject5).superVipInfo;
                    if ((j & 0x20) == 0) {
                      break label1796;
                    }
                  }
                }
              }
            }
            for (j = 1;; j = 0)
            {
              ((Friends)localObject5).superVipInfo = (j << 24 | i1);
              j = i;
              if (localObject5 != null) {
                if ((((Friends)localObject5).superVipInfo == k) && (((Friends)localObject5).qqVipInfo == n))
                {
                  j = i;
                  if (((Friends)localObject5).superQqInfo == m) {}
                }
                else
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "find a vip user uin = " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + " superVipInfo = " + ((Friends)localObject5).superVipInfo + " qqVipInfo = " + ((Friends)localObject5).qqVipInfo + " superQqInfo = " + ((Friends)localObject5).superQqInfo);
                  }
                  arrayOfFriends[i] = localObject5;
                  j = i + 1;
                }
              }
              i = j;
              break;
              label1786:
              j = 0;
              break label1520;
              label1791:
              j = 0;
              break label1549;
            }
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
            long l2;
            if ((localObject2 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has()))
            {
              localObject2 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
              if (((ByteBuffer)localObject2).remaining() > 8)
              {
                l1 = ((ByteBuffer)localObject2).getInt() & 0xFFFFFFFF;
                l2 = ((ByteBuffer)localObject2).getInt() & 0xFFFFFFFF;
                localObject6 = new byte[((ByteBuffer)localObject2).getShort() & 0xFFFF];
                ((ByteBuffer)localObject2).get((byte[])localObject6);
                localObject5 = localFriendsManager.a(Long.toString(l1));
                localObject2 = localObject5;
                if (localObject5 == null)
                {
                  localObject2 = new ExtensionInfo();
                  ((ExtensionInfo)localObject2).uin = Long.toString(l1);
                }
                if (((ExtensionInfo)localObject2).richTime != l2)
                {
                  ((ExtensionInfo)localObject2).setRichBuffer((byte[])localObject6, l2);
                  ((ExtensionInfo)localObject2).isAdded2C2C = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l1), ((ExtensionInfo)localObject2).getRichStatus());
                  localFriendsManager.a((ExtensionInfo)localObject2);
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "insertSignMsgIfNeeded from QQProfileItem uin = " + l1 + " result = " + ((ExtensionInfo)localObject2).isAdded2C2C);
                  }
                }
              }
            }
            break;
            if (!((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.has()) {
              break;
            }
            localObject2 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject2).msg_general_buffer.get();
            if ((localObject2 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.has())) {
              localObject7 = new Oidb_0x5d0.SnsUpateBuffer();
            }
            for (;;)
            {
              try
              {
                ((Oidb_0x5d0.SnsUpateBuffer)localObject7).mergeFrom(((Oidb_0x5e0.GeneralBuffer)localObject2).bytes_value.get().toByteArray());
                if ((localObject7 != null) && (((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_uin32_idlist.has()))
                {
                  localObject6 = ((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_uin32_idlist.get().iterator();
                  if (!((Iterator)localObject6).hasNext()) {
                    break label3644;
                  }
                  if (((Integer)((Iterator)localObject6).next()).intValue() != 4051) {
                    continue;
                  }
                  localObject5 = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get());
                  if (QLog.isColorLevel())
                  {
                    if (((String)localObject5).length() < 4) {
                      break label6933;
                    }
                    localObject2 = ((String)localObject5).substring(((String)localObject5).length() - 4);
                    QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit : shd: " + (String)localObject2);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject5, localObject5);
                  continue;
                }
              }
              catch (Exception localException1)
              {
                localException1.printStackTrace();
                localObject7 = null;
                continue;
                if (localObject7 == null) {
                  break label3644;
                }
              }
              Object localObject3;
              Iterator localIterator2;
              Object localObject8;
              int i9;
              if ((((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.has()) && (((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_msg_sns_update_item.has()))
              {
                localObject3 = ((Oidb_0x5d0.SnsUpateBuffer)localObject7).rpt_msg_sns_update_item.get();
                l1 = ((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get();
                localIterator2 = ((List)localObject3).iterator();
                localObject5 = null;
                if (localIterator2.hasNext())
                {
                  localObject8 = (Oidb_0x5d0.SnsUpdateItem)localIterator2.next();
                  localObject6 = localObject5;
                  if (localObject8 != null)
                  {
                    localObject6 = localObject5;
                    if (((Oidb_0x5d0.SnsUpdateItem)localObject8).uint32_update_sns_type.has())
                    {
                      localObject6 = localObject5;
                      if (((Oidb_0x5d0.SnsUpdateItem)localObject8).bytes_value.has())
                      {
                        if (((Oidb_0x5d0.SnsUpdateItem)localObject8).uint32_update_sns_type.get() == 13568) {
                          QvipSpecialCareManager.a(String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get()), ((Oidb_0x5d0.SnsUpdateItem)localObject8).bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                        }
                        localObject3 = localObject5;
                        if (localObject5 == null)
                        {
                          localObject5 = localFriendsManager.a(String.valueOf(l1));
                          localObject3 = localObject5;
                          if (localObject5 == null)
                          {
                            localObject3 = new SpecialCareInfo();
                            ((SpecialCareInfo)localObject3).uin = String.valueOf(String.valueOf(l1));
                          }
                        }
                        j = ((Oidb_0x5d0.SnsUpdateItem)localObject8).uint32_update_sns_type.get();
                        localObject5 = ((Oidb_0x5d0.SnsUpdateItem)localObject8).bytes_value.get().toStringUtf8();
                        FriendListHandler.a((SpecialCareInfo)localObject3, j, (String)localObject5);
                        if (QLog.isColorLevel()) {
                          QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody uin=" + ((SpecialCareInfo)localObject3).uin + ", itemtype=" + j + ",itemVal=" + (String)localObject5);
                        }
                        localObject6 = localObject3;
                        if (((Oidb_0x5d0.SnsUpdateItem)localObject8).uint32_update_sns_type.get() == 13575)
                        {
                          if (QLog.isColorLevel()) {
                            QLog.d("HotFriend_ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody uin= " + l1);
                          }
                          localObject6 = String.valueOf(((Oidb_0x5d0.SnsUpateBuffer)localObject7).uint64_uin.get());
                          localObject8 = ((Oidb_0x5d0.SnsUpdateItem)localObject8).bytes_value.get().toByteArray();
                          i9 = localObject8.length;
                          localObject5 = localFriendsManager.a((String)localObject6);
                          if (localObject5 != null) {
                            break label6930;
                          }
                          localObject5 = new ExtensionInfo();
                          ((ExtensionInfo)localObject5).uin = ((String)localObject6);
                        }
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                k = 0;
                j = 0;
                if (i9 >= 3)
                {
                  k = localObject8[0] & 0xFF;
                  j = (localObject8[1] << 8 & 0xFF00) + (localObject8[2] & 0xFF);
                  ((ExtensionInfo)localObject5).praiseHotLevel = k;
                  ((ExtensionInfo)localObject5).praiseDays = j;
                }
                n = 0;
                m = 0;
                if (i9 >= 6)
                {
                  n = localObject8[3] & 0xFF;
                  m = (localObject8[4] << 8 & 0xFF00) + (localObject8[5] & 0xFF);
                  ((ExtensionInfo)localObject5).chatHotLevel = n;
                  ((ExtensionInfo)localObject5).chatDays = m;
                }
                i2 = 0;
                i1 = 0;
                if (i9 >= 9)
                {
                  i2 = localObject8[6] & 0xFF;
                  i1 = (localObject8[7] << 8 & 0xFF00) + (localObject8[8] & 0xFF);
                  ((ExtensionInfo)localObject5).bestIntimacyType = i2;
                  ((ExtensionInfo)localObject5).bestIntimacyDays = i1;
                }
                int i3 = 0;
                if (i9 >= 11)
                {
                  i3 = (localObject8[9] << 8 & 0xFF00) + (localObject8[10] & 0xFF);
                  ((ExtensionInfo)localObject5).lastpraiseTime = (86400 * i3 - 28800);
                }
                int i4 = 0;
                if (i9 >= 13)
                {
                  i4 = (localObject8[11] << 8 & 0xFF00) + (localObject8[12] & 0xFF);
                  ((ExtensionInfo)localObject5).lastChatTime = (86400 * i4 - 28800);
                }
                int i7 = 0;
                int i6 = 0;
                int i5 = 0;
                if (i9 >= 18)
                {
                  i7 = localObject8[13] & 0xFF;
                  i5 = localObject8[14];
                  i6 = (localObject8[15] & 0xFF) + (i5 << 8 & 0xFF00);
                  i5 = (localObject8[16] << 8 & 0xFF00) + (localObject8[17] & 0xFF);
                  ((ExtensionInfo)localObject5).qzoneVisitType = i7;
                  ((ExtensionInfo)localObject5).qzoneHotDays = i6;
                  ((ExtensionInfo)localObject5).lastQzoneVisitTime = (86400 * i5 - 28800);
                }
                if (i9 >= 24)
                {
                  i8 = localObject8[18];
                  int i10 = localObject8[19];
                  int i11 = localObject8[20];
                  int i12 = localObject8[21];
                  int i13 = localObject8[22];
                  int i14 = localObject8[23];
                  ((ExtensionInfo)localObject5).loverChatLevel = (i8 & 0xFF);
                  ((ExtensionInfo)localObject5).loverChatDays = ((i10 << 8 & 0xFF00) + (i11 & 0xFF));
                  ((ExtensionInfo)localObject5).loverLastChatTime = (86400 * ((i12 << 8 & 0xFF00) + (i13 & 0xFF)) - 28800);
                  ((ExtensionInfo)localObject5).loverFlag = (i14 & 0xFF);
                }
                int i8 = 0;
                if (i9 >= 25) {
                  i8 = localObject8[24] & 0xFF;
                }
                if (i8 != 0) {}
                for (boolean bool2 = true;; bool2 = false)
                {
                  ((ExtensionInfo)localObject5).loverTransFlag = bool2;
                  if (HotReactiveHelper.a())
                  {
                    ((ExtensionInfo)localObject5).hasRemindChat = false;
                    ((ExtensionInfo)localObject5).hasRemindPraise = false;
                    ((ExtensionInfo)localObject5).hasRemindQzoneVisit = false;
                    ((ExtensionInfo)localObject5).hasRemindLoverChat = false;
                  }
                  localFriendsManager.a((ExtensionInfo)localObject5);
                  if (QLog.isColorLevel())
                  {
                    localObject8 = new StringBuilder();
                    ((StringBuilder)localObject8).append("QQprofileItem === hotFriend uin: ").append((String)localObject6).append(",dataLength=").append(i9).append(", praiseData=").append(k).append("|").append(j).append(",chatData=").append(n).append("|").append(m).append(",closeData=").append(i2).append("|").append(i1).append(",lastpraiseTime=").append(i3).append(",lastChatTime=").append(i4).append(",qzoneLevel=").append(i7).append(",qzoneDay=").append(i6).append(",lastQzoneDay=").append(i5).append(",cLoverLevel=").append(((ExtensionInfo)localObject5).loverChatLevel).append(",wLoverDay=").append(((ExtensionInfo)localObject5).loverChatDays).append(",wLstLoverDay=").append(((ExtensionInfo)localObject5).loverLastChatTime).append(",cLoverFlag=").append(((ExtensionInfo)localObject5).loverFlag).append(",cTransFlag=").append(((ExtensionInfo)localObject5).loverTransFlag).append(",hasRemindChat=").append(((ExtensionInfo)localObject5).hasRemindChat).append(",hasRemindPraise=").append(((ExtensionInfo)localObject5).hasRemindPraise).append(",hasRemindQzoneVisit=").append(((ExtensionInfo)localObject5).hasRemindQzoneVisit).append(",hasRemindLoverChat=").append(((ExtensionInfo)localObject5).hasRemindLoverChat);
                    QLog.i("FriendReactive", 2, ((StringBuilder)localObject8).toString());
                  }
                  localArrayList2.add(((ExtensionInfo)localObject5).uin);
                  localObject6 = localObject3;
                  localObject5 = localObject6;
                  break;
                }
                if ((localObject5 != null) && ((((SpecialCareInfo)localObject5).getStatus() != 1000) || (((SpecialCareInfo)localObject5).globalSwitch != 0))) {
                  localArrayList1.add(localObject5);
                }
                break;
                if (!((Oidb_0x5e0.ContentItem)localObject3).msg_general_buffer.has()) {
                  break;
                }
                localObject3 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject3).msg_general_buffer.get();
                l2 = 0L;
                l1 = l2;
                if (localObject3 != null)
                {
                  l1 = l2;
                  if (((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.has()) {
                    l1 = ((Oidb_0x5e0.GeneralBuffer)localObject3).uint64_uin.get();
                  }
                }
                if ((localObject3 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.has()))
                {
                  localObject3 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.get().toByteArray());
                  if (((ByteBuffer)localObject3).remaining() >= 8)
                  {
                    l2 = ((ByteBuffer)localObject3).getLong();
                    localObject5 = localFriendsManager.a(String.valueOf(l1));
                    localObject3 = localObject5;
                    if (localObject5 == null)
                    {
                      localObject3 = new ExtensionInfo();
                      ((ExtensionInfo)localObject3).uin = String.valueOf(l1);
                    }
                    ((ExtensionInfo)localObject3).pendantId = l2;
                    ((ExtensionInfo)localObject3).timestamp = System.currentTimeMillis();
                    localFriendsManager.a((ExtensionInfo)localObject3);
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Pendant, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + ((ExtensionInfo)localObject3).pendantId);
                    }
                  }
                }
                break;
                if (!((Oidb_0x5e0.ContentItem)localObject3).msg_general_buffer.has()) {
                  break;
                }
                localObject3 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject3).msg_general_buffer.get();
                l2 = 0L;
                l1 = l2;
                if (localObject3 != null)
                {
                  l1 = l2;
                  if (((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.has()) {
                    l1 = ((Oidb_0x5e0.GeneralBuffer)localObject3).uint64_uin.get();
                  }
                }
                if ((localObject3 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.has()))
                {
                  localObject3 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.get().toByteArray());
                  if (((ByteBuffer)localObject3).remaining() >= 4)
                  {
                    j = ((ByteBuffer)localObject3).getInt();
                    localObject5 = localFriendsManager.a(String.valueOf(l1));
                    localObject3 = localObject5;
                    if (localObject5 == null)
                    {
                      localObject3 = new ExtensionInfo();
                      ((ExtensionInfo)localObject3).uin = String.valueOf(l1);
                    }
                    if (((ExtensionInfo)localObject3).uVipFont != j)
                    {
                      ((ExtensionInfo)localObject3).uVipFont = j;
                      ((ExtensionInfo)localObject3).timestamp = System.currentTimeMillis();
                      localFriendsManager.a((ExtensionInfo)localObject3);
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get Font, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + j);
                    }
                  }
                }
                break;
                if (!((Oidb_0x5e0.ContentItem)localObject3).msg_general_buffer.has()) {
                  break;
                }
                localObject3 = (Oidb_0x5e0.GeneralBuffer)((Oidb_0x5e0.ContentItem)localObject3).msg_general_buffer.get();
                l2 = 0L;
                l1 = l2;
                if (localObject3 != null)
                {
                  l1 = l2;
                  if (((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.has()) {
                    l1 = ((Oidb_0x5e0.GeneralBuffer)localObject3).uint64_uin.get();
                  }
                }
                if ((localObject3 != null) && (((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.has()))
                {
                  localObject3 = ByteBuffer.wrap(((Oidb_0x5e0.GeneralBuffer)localObject3).bytes_value.get().toByteArray());
                  if (((ByteBuffer)localObject3).remaining() >= 4)
                  {
                    j = ((ByteBuffer)localObject3).getInt();
                    localObject5 = localFriendsManager.a(String.valueOf(l1));
                    localObject3 = localObject5;
                    if (localObject5 == null)
                    {
                      localObject3 = new ExtensionInfo();
                      ((ExtensionInfo)localObject3).uin = String.valueOf(l1);
                    }
                    if (((ExtensionInfo)localObject3).colorRingId != j)
                    {
                      ((ExtensionInfo)localObject3).colorRingId = j;
                      ((ExtensionInfo)localObject3).timestamp = System.currentTimeMillis();
                      localFriendsManager.a((ExtensionInfo)localObject3);
                      ColorRingManager.a(((ExtensionInfo)localObject3).uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "Check update, Get colorRing, uin=" + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", id=" + j);
                    }
                  }
                }
                break;
                if (!((Oidb_0x5e0.ContentItem)localObject3).msg_profile_info.has()) {
                  break;
                }
                localObject3 = (Oidb_0x5e0.ProfileInfo)((Oidb_0x5e0.ContentItem)localObject3).msg_profile_info.get();
                l1 = ((Oidb_0x5e0.ProfileInfo)localObject3).uint64_uin.get();
                localObject3 = ((Oidb_0x5e0.ProfileInfo)localObject3).rpt_msg_profile_info.get();
                if (localObject1 == null)
                {
                  localObject1 = new ClassicHeadActivityManager.FriendHeadFlagItem(l1);
                  localObject6 = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
                  localObject7 = ((ApolloManager)localObject6).b(l1 + "");
                  localIterator2 = ((List)localObject3).iterator();
                  j = 0;
                  if (!localIterator2.hasNext()) {
                    break label5981;
                  }
                  localObject3 = (Oidb_0x5e0.ProfileTvInfo)localIterator2.next();
                  k = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint32_field_id.get();
                  ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint32_field_type.get();
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "Check update for profile field uin: " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ",field: " + k + ", int_value: " + 0L);
                  }
                  switch (k)
                  {
                  default: 
                    k = j;
                    j = k;
                  }
                }
                for (;;)
                {
                  break label4524;
                  ((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1).a();
                  ((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1).jdField_a_of_type_JavaLangString = Long.toString(l1);
                  break;
                  l2 = (int)((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4771;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloVipLevel == l2) {
                    break label4771;
                  }
                  ((ApolloBaseInfo)localObject7).apolloVipLevel = ((int)l2);
                  j = 1;
                  continue;
                  l2 = (int)((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4771;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloVipFlag == l2) {
                    break label4771;
                  }
                  ((ApolloBaseInfo)localObject7).apolloVipFlag = ((int)l2);
                  j = 1;
                  continue;
                  l2 = (int)((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4771;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloStatus == l2) {
                    break label4771;
                  }
                  ((ApolloBaseInfo)localObject7).apolloStatus = ((int)l2);
                  j = 1;
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (localObject7 == null) {
                    break label4771;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloServerTS == l2) {
                    break label4771;
                  }
                  ((ApolloBaseInfo)localObject7).apolloServerTS = l2;
                  j = 1;
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  k = j;
                  if (l2 >= NetConnInfoCenter.getServerTime()) {
                    break label4771;
                  }
                  k = j;
                  if (localObject7 == null) {
                    break label4771;
                  }
                  k = j;
                  if (((ApolloBaseInfo)localObject7).apolloSignValidTS == l2) {
                    break label4771;
                  }
                  ((ApolloBaseInfo)localObject7).apolloLocalSignTs = ((ApolloBaseInfo)localObject7).apolloSignValidTS;
                  ((ApolloBaseInfo)localObject7).apolloSignValidTS = l2;
                  ((ApolloBaseInfo)localObject7).apolloSignStr = "";
                  j = 1;
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  if (((ApolloBaseInfo)localObject7).apolloAISwitch != (int)l2)
                  {
                    ((ApolloBaseInfo)localObject7).apolloAISwitch = ((int)l2);
                    if (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))
                    {
                      ApolloManager.c((int)l2);
                      ((ApolloManager)localObject6).d((int)l2);
                    }
                    j = 1;
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4771;
                  }
                  QLog.d("ProfileService.CheckUpdateReq", 2, "apollo aiSwitch profileupdate :" + l2);
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                  }
                  if ((((ExtensionInfo)localObject3).uVipFont != FontManager.a(l2)) || (((ExtensionInfo)localObject3).vipFontType != FontManager.b(l2)))
                  {
                    ((ExtensionInfo)localObject3).uVipFont = FontManager.a(l2);
                    ((ExtensionInfo)localObject3).vipFontType = FontManager.b(l2);
                    ((ExtensionInfo)localObject3).timestamp = System.currentTimeMillis();
                    localFriendsManager.a((ExtensionInfo)localObject3);
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4771;
                  }
                  QLog.d("QQProfileItem", 2, "update, Get Font, uin=" + l1 + ", id=" + ((ExtensionInfo)localObject3).uVipFont + ", type = " + ((ExtensionInfo)localObject3).vipFontType);
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                  }
                  if (((ExtensionInfo)localObject3).magicFont != l2)
                  {
                    ((ExtensionInfo)localObject3).magicFont = ((int)l2);
                    ((ExtensionInfo)localObject3).timestamp = System.currentTimeMillis();
                    localFriendsManager.a((ExtensionInfo)localObject3);
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4771;
                  }
                  QLog.d("QQProfileItem", 2, "update, Get magic font, uin= " + l1 + ", magicfont = " + ((ExtensionInfo)localObject3).magicFont);
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                    ((ExtensionInfo)localObject3).fontEffect = -1;
                  }
                  if (((ExtensionInfo)localObject3).fontEffect != l2)
                  {
                    ((ExtensionInfo)localObject3).fontEffect = ((int)l2);
                    ((ExtensionInfo)localObject3).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
                    localFriendsManager.a((ExtensionInfo)localObject3);
                  }
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4771;
                  }
                  QLog.d("QQProfileItem", 2, "update, Get font effect, uin= " + l1 + ", fontEffect = " + ((ExtensionInfo)localObject3).fontEffect + ", updateTime = " + ((ExtensionInfo)localObject3).fontEffectLastUpdateTime);
                  continue;
                  ((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1).jdField_a_of_type_Long = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  continue;
                  ((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1).b = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  continue;
                  ((ClassicHeadActivityManager.FriendHeadFlagItem)localObject1).c = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                  }
                  if (((ExtensionInfo)localObject3).latestPLUpdateTimestamp != l2)
                  {
                    ((ExtensionInfo)localObject3).latestPLUpdateTimestamp = l2;
                    localFriendsManager.a((ExtensionInfo)localObject3);
                    if (QLog.isColorLevel()) {
                      QLog.d("QQProfileItem", 2, "update uin=" + l1 + " latestplNewsTs=" + l2);
                    }
                  }
                  continue;
                  l2 = ((Oidb_0x5e0.ProfileTvInfo)localObject3).uint64_field_int_value.get();
                  localObject5 = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(Long.toString(l1));
                  localObject3 = localObject5;
                  if (localObject5 == null)
                  {
                    localObject3 = new ExtensionInfo();
                    ((ExtensionInfo)localObject3).uin = Long.toString(l1);
                  }
                  k = j;
                  if (((ExtensionInfo)localObject3).medalUpdateTimestamp == l2) {
                    break label4771;
                  }
                  ((ExtensionInfo)localObject3).medalUpdateTimestamp = l2;
                  localFriendsManager.a((ExtensionInfo)localObject3);
                  k = j;
                  if (!QLog.isColorLevel()) {
                    break label4771;
                  }
                  QLog.d("QQProfileItem", 2, "update uin=" + l1 + " medalUpdateTimestamp=" + l2);
                }
                label5981:
                if (j != 0) {
                  ((ApolloManager)localObject6).a((ApolloBaseInfo)localObject7);
                }
                break;
                localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
                if (localArrayList5.size() > 0)
                {
                  localObject3 = localArrayList5.iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject5 = (Friends)((Iterator)localObject3).next();
                    localObject6 = ((Friends)localObject5).name;
                    a(Long.parseLong(((Friends)localObject5).uin), (String)localObject6, (DiscussionManager)localObject1);
                  }
                }
                if (localArrayList4.size() > 0)
                {
                  localObject3 = localArrayList4.iterator();
                  while (((Iterator)localObject3).hasNext())
                  {
                    localObject5 = (Friends)((Iterator)localObject3).next();
                    localObject6 = ((Friends)localObject5).remark;
                    b(Long.parseLong(((Friends)localObject5).uin), (String)localObject6, (DiscussionManager)localObject1);
                  }
                }
                if (localArrayList3.size() > 0) {
                  localObject1 = localFriendsManager.a();
                }
                for (;;)
                {
                  try
                  {
                    ((EntityTransaction)localObject1).a();
                    localObject3 = localArrayList3.iterator();
                    if (((Iterator)localObject3).hasNext())
                    {
                      localTroopManager.b((TroopInfo)((Iterator)localObject3).next());
                      continue;
                    }
                    if (((Friends)localObject6).isShield()) {
                      continue;
                    }
                  }
                  catch (Exception localException2)
                  {
                    localException2.printStackTrace();
                    ((EntityTransaction)localObject1).b();
                    if (QLog.isColorLevel()) {
                      QLog.d("ProfileService.CheckUpdateReq", 2, "handleCheckUpdateRspBody, bulkSaveOrUpdateSpecialCareInfos,size=" + localArrayList1.size());
                    }
                    if (localArrayList1.size() > 0)
                    {
                      localFriendsManager.c(localArrayList1);
                      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(99, true, new Object[] { Boolean.valueOf(true), localArrayList1 });
                    }
                    if (localArrayList2.size() > 0) {
                      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(107, true, localArrayList2);
                    }
                    if ((!bool1) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() == 0)) {
                      break label6786;
                    }
                    localObject5 = localFriendsManager.c();
                    localObject1 = new ArrayList();
                    localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
                    localObject5 = ((ArrayList)localObject5).iterator();
                    if (!((Iterator)localObject5).hasNext()) {
                      break;
                    }
                    localObject6 = (Friends)((Iterator)localObject5).next();
                    if ((((Friends)localObject6).isShield()) && (!((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin)))
                    {
                      ((Friends)localObject6).setShieldFlag(false);
                      ((ArrayList)localObject1).add(localObject6);
                      continue;
                      ((EntityTransaction)localObject1).c();
                      ((EntityTransaction)localObject1).b();
                      continue;
                    }
                  }
                  finally
                  {
                    ((EntityTransaction)localObject1).b();
                  }
                  if (((ConcurrentHashMap)localObject4).containsKey(((Friends)localObject6).uin))
                  {
                    ((Friends)localObject6).setShieldFlag(true);
                    ((ArrayList)localObject1).add(localObject6);
                  }
                }
                i = 0;
                while (i < j)
                {
                  if (arrayOfFriends[i] != null) {
                    ((ArrayList)localObject1).add(arrayOfFriends[i]);
                  }
                  i += 1;
                }
                localObject4 = new Friends[((ArrayList)localObject1).size()];
                ((ArrayList)localObject1).toArray((Object[])localObject4);
                if (QLog.isColorLevel()) {
                  QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + j + " includeShield:" + localObject4.length);
                }
                localFriendsManager.a((Friends[])localObject4, localObject4.length);
                for (;;)
                {
                  localObject4 = paramRspBody.rpt_msg_ProfileListResult.get();
                  if (localObject4 == null) {
                    break label6838;
                  }
                  localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
                  localObject4 = ((List)localObject4).iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    localObject5 = (Oidb_0x5e0.ProfileListResult)((Iterator)localObject4).next();
                    if ((((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.has()) && (((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.get() == 0))
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("ProfileService.CheckUpdateReq", 2, "get result =" + ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_result.get());
                      }
                      if ((((Oidb_0x5e0.ProfileListResult)localObject5).uint32_update_profile_id.has()) && (((Oidb_0x5e0.ProfileListResult)localObject5).uint32_new_content_timestamp.has()))
                      {
                        i = ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_update_profile_id.get();
                        j = ((Oidb_0x5e0.ProfileListResult)localObject5).uint32_new_content_timestamp.get();
                        ((SharedPreferences.Editor)localObject1).putLong("inccheckupdatetimeStamp" + i, j);
                      }
                    }
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("ProfileService.CheckUpdateReq", 2, "CheckUpdate ValueBit update Friends count = " + j);
                  }
                  localFriendsManager.a(arrayOfFriends, j);
                }
                ((SharedPreferences.Editor)localObject1).commit();
                if ((paramRspBody.uint32_over_flag.has()) && (paramRspBody.uint32_over_flag.get() == 1))
                {
                  this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(0);
                }
                while (!paramRspBody.bytes_svrcontext.has()) {
                  return;
                }
                this.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = paramRspBody.bytes_svrcontext.get();
                ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(false, 1);
                return;
              }
              Object localObject4 = localObject5;
            }
          }
        }
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByName newFriendName = " + paramString1 + ",oldFriendName = " + paramString2 + ",result = " + bool1);
    }
    return bool1;
  }
  
  public static void b(long paramLong, String paramString, DiscussionManager paramDiscussionManager)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "updateDiscussionMemberInfoRemark uin = " + paramLong + ",remarkName = " + paramString);
    }
    Object localObject = paramDiscussionManager.a();
    if (localObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject).next();
        DiscussionMemberInfo localDiscussionMemberInfo = paramDiscussionManager.a(localDiscussionInfo.uin, Long.toString(paramLong));
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
        paramDiscussionManager.b(localArrayList);
        paramString = new HashMap();
        paramString.put("count", String.valueOf(localArrayList.size()));
        StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "updateDiscussMemberRemark", true, 0L, 0L, paramString, "", true);
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("QQProfileItem", 2, "checkShouldUpdateDiscussinMemberInfoByRemark ,newRemark = " + paramString1 + ",oldRemark = " + paramString2 + ",result = " + bool2);
    }
    return bool2;
  }
  
  public int a()
  {
    return 5;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileService.CheckUpdateReq", 2, "QQProfileItem::getCheckUpdateItemData called");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.eServiceID = 101;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    Object localObject2 = new long[16];
    int i = 0;
    while (i < 16)
    {
      localObject2[i] = (((SharedPreferences)localObject1).getLong("inccheckupdatetimeStamp" + Integer.toString(i), 0L) - 0L);
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(50);
      i = 0;
      while (i < 16)
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
    if (!((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a())
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
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27201));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(40530));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27254));
      localObject2 = (ClassicHeadActivityManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
      if ((localObject2 != null) && (((ClassicHeadActivityManager)localObject2).a()))
      {
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(42099));
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(40556));
        localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(20015));
        if (QLog.isColorLevel()) {
          QLog.d("QQProfileItem", 2, "ClassicHeadActivity Params is add");
        }
      }
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27218));
      localUpdateProfileList11.rpt_uint32_profile_field_list.add(Integer.valueOf(27213));
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
    Oidb_0x5e0.RspBody localRspBody;
    if ((paramRespItem.eServiceID == 101) && (paramRespItem.cResult == 2))
    {
      paramRespItem = paramRespItem.vecUpdate;
      localRspBody = new Oidb_0x5e0.RspBody();
    }
    try
    {
      paramRespItem = (Oidb_0x5e0.RspBody)localRspBody.mergeFrom(paramRespItem);
      if (paramRespItem == null) {
        return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQProfileItem
 * JD-Core Version:    0.7.0.1
 */