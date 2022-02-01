package com.tencent.imcore.message;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.hiddenchat.TroopStatusUtil;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.troop.troopgame.MemberGradeLevelInfo;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameCardService;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils;
import com.tencent.mobileqq.utils.VipUtils.VipIconUtils.NamePlateVipTpye;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.qphone.base.util.QLog;
import gxh_message.Dialogue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.ExtraInfo;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.PubGroup;
import tencent.im.oidb.cmd0x787.oidb_0x787.MsgNeedField;

class BaseMessageProcessorForTroopAndDisc$TroopHotChatTopicHandler
{
  private byte jdField_a_of_type_Byte;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  private PBDecodeContext jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<MessageRecord> jdField_a_of_type_JavaUtilArrayList;
  private List<im_msg_body.Elem> jdField_a_of_type_JavaUtilList;
  private msg_comm.MsgHead jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public BaseMessageProcessorForTroopAndDisc$TroopHotChatTopicHandler(ArrayList<MessageRecord> paramArrayList, PBDecodeContext paramPBDecodeContext, boolean paramBoolean, msg_comm.MsgHead paramMsgHead, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List<im_msg_body.Elem> paramList, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramPBDecodeContext;
    this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext = paramBoolean;
    this.jdField_a_of_type_Boolean = paramMsgHead;
    this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead = paramLong1;
    this.jdField_a_of_type_Long = ???;
    this.jdField_b_of_type_Long = ???;
    this.jdField_c_of_type_Long = ???;
    Object localObject1;
    this.jdField_d_of_type_Long = localObject1;
    this.jdField_a_of_type_JavaUtilList = paramByte;
    this.jdField_a_of_type_Byte = paramString;
    Object localObject2;
    this.jdField_a_of_type_JavaLangString = localObject2;
  }
  
  private int a(int paramInt, long paramLong, generalflags.ResvAttr paramResvAttr)
  {
    int j = paramInt;
    if (paramResvAttr.uint32_title_id.has())
    {
      int k = paramResvAttr.uint32_title_id.get();
      if (k > 0) {
        paramInt = k;
      }
      j = paramInt;
      if (QLog.isColorLevel())
      {
        QLog.d("TroopRankConfig", 2, "decodeSinglePbMsg_GroupDis, titleId=" + k + ", troopUin=" + paramLong + ", sender=" + this.jdField_a_of_type_Long + ", msgTime=" + this.jdField_c_of_type_Long + ", isSaveDb=" + this.jdField_a_of_type_Boolean);
        j = paramInt;
      }
    }
    return j;
  }
  
  private int a(int paramInt, long paramLong, im_msg_body.Elem paramElem)
  {
    int n = 0;
    int j = paramInt;
    generalflags.ResvAttr localResvAttr;
    int k;
    label111:
    int m;
    if (paramElem.general_flags.bytes_pb_reserve.has())
    {
      localResvAttr = new generalflags.ResvAttr();
      localResvAttr.mergeFrom(paramElem.general_flags.bytes_pb_reserve.get().toByteArray());
      if (localResvAttr.uint32_rich_card_name_ver.has()) {
        localResvAttr.uint32_rich_card_name_ver.get();
      }
      if (!localResvAttr.uint32_nearby_charm_level.has()) {
        break label493;
      }
      j = localResvAttr.uint32_nearby_charm_level.get();
      if (!localResvAttr.uint32_global_group_level.has()) {
        break label500;
      }
      k = localResvAttr.uint32_global_group_level.get();
      if (!localResvAttr.uint32_vip_type.has()) {
        break label507;
      }
      m = localResvAttr.uint32_vip_type.get();
      label132:
      this.jdField_a_of_type_Int = m;
      if (!localResvAttr.uint32_vip_level.has()) {
        break label513;
      }
      m = localResvAttr.uint32_vip_level.get();
      label159:
      this.jdField_b_of_type_Int = VipUtils.c(m);
      if (localResvAttr.uint32_user_bigclub_flag.has()) {
        this.jdField_c_of_type_Int = localResvAttr.uint32_user_bigclub_flag.get();
      }
      if (localResvAttr.uint32_user_bigclub_level.has()) {
        this.jdField_d_of_type_Int = localResvAttr.uint32_user_bigclub_level.get();
      }
      if (localResvAttr.uint32_nameplate.has()) {
        this.e = localResvAttr.uint32_nameplate.get();
      }
      if (localResvAttr.bytes_user_vip_info.has())
      {
        paramElem = new Dialogue();
        paramElem.mergeFrom(localResvAttr.bytes_user_vip_info.get().toByteArray());
        m = n;
        if (paramElem.short_nameplate_itemid.has()) {
          m = paramElem.short_nameplate_itemid.get();
        }
        this.f = m;
        this.i = paramElem.diyfontid.get();
      }
      a(paramLong, localResvAttr);
      a(localResvAttr);
      if (QLog.isColorLevel()) {
        QLog.d("kaiyan", 2, "isHideBigClub=" + this.g);
      }
      paramInt = a(paramInt, paramLong, localResvAttr);
      paramElem = a(paramLong, j, k, localResvAttr);
      a(this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext, paramLong, localResvAttr, paramElem);
      if (!localResvAttr.bytes_hudong_mark.has()) {
        break label519;
      }
    }
    label513:
    label519:
    for (paramElem = localResvAttr.bytes_hudong_mark.get().toByteArray();; paramElem = null)
    {
      String str = TroopHonorUtils.a(paramElem);
      ((ITroopHonorService)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getRuntimeService(ITroopHonorService.class, "")).updateTroopMemberHonor(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), str, (byte)localResvAttr.uint32_group_rich_flag.get(), this.jdField_c_of_type_Long);
      this.h = TroopMemberLevelUtils.a(paramElem);
      j = paramInt;
      return j;
      label493:
      j = -100;
      break;
      label500:
      k = -100;
      break label111;
      label507:
      m = 0;
      break label132;
      m = 0;
      break label159;
    }
  }
  
  private int a(int paramInt, im_msg_body.Elem paramElem)
  {
    if (paramElem.general_flags.uint32_glamour_level.has()) {
      paramInt = paramElem.general_flags.uint32_glamour_level.get();
    }
    return paramInt;
  }
  
  @Nullable
  private TroopManager a(long paramLong, int paramInt1, int paramInt2, generalflags.ResvAttr paramResvAttr)
  {
    int j;
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.e == 1) && (paramResvAttr.uint32_group_member_flag_ex2.has()))
    {
      j = paramResvAttr.uint32_group_member_flag_ex2.get();
      TroopStatusUtil.a(this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a, paramLong, j);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.e == 1) && (paramResvAttr.uint32_group_ringtone_id.has()) && (paramResvAttr.uint32_group_ringtone_id.get() > 0))
    {
      j = paramResvAttr.uint32_group_ringtone_id.get();
      TroopStatusUtil.b(this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a, paramLong, j);
    }
    paramResvAttr = (TroopManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramResvAttr != null) {
      paramResvAttr.a(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), paramInt1, paramInt2);
    }
    return paramResvAttr;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (im_msg_body.Elem)localIterator.next();
        if ((((im_msg_body.Elem)localObject).general_flags.has()) && (((im_msg_body.Elem)localObject).general_flags.bytes_pb_reserve.has()))
        {
          generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
          localResvAttr.mergeFrom(((im_msg_body.Elem)localObject).general_flags.bytes_pb_reserve.get().toByteArray());
          if (localResvAttr.bytes_user_vip_info.has())
          {
            localObject = new Dialogue();
            ((Dialogue)localObject).mergeFrom(localResvAttr.bytes_user_vip_info.get().toByteArray());
            this.i = ((Dialogue)localObject).diyfontid.get();
          }
        }
      }
    }
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_b_of_type_Boolean) {
      ((HotChatManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramLong);
    }
  }
  
  private void a(long paramLong, String paramString, TroopManager paramTroopManager, TroopInfo paramTroopInfo)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramTroopInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + paramLong + ", memberUin=" + this.jdField_a_of_type_Long + " troopinfo is null, getGroupInfoReq ");
      }
      paramTroopInfo = new TroopInfo();
      paramTroopInfo.troopuin = paramString;
      paramTroopManager.b(paramTroopInfo);
      ((TroopInfoHandler)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).b(paramString);
    }
  }
  
  private void a(long paramLong, generalflags.ResvAttr paramResvAttr)
  {
    Object localObject1;
    Object localObject2;
    if (paramResvAttr.uint32_kings_honor_level.has())
    {
      localObject1 = (ITroopGameCardService)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getRuntimeService(ITroopGameCardService.class, "");
      if (localObject1 != null)
      {
        localObject2 = new MemberGradeLevelInfo();
        ((MemberGradeLevelInfo)localObject2).memberuin = String.valueOf(this.jdField_a_of_type_Long);
        ((MemberGradeLevelInfo)localObject2).gradeLevel = (paramResvAttr.uint32_kings_honor_level.get() * 10000);
        ((ITroopGameCardService)localObject1).saveMemberGradeLevelInfo((MemberGradeLevelInfo)localObject2);
      }
    }
    for (;;)
    {
      if ((paramResvAttr.uint32_group_info_flag_ex4.has()) || (paramResvAttr.bytes_group_msg_busi_buf.has()))
      {
        localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.TROOP_MANAGER);
        if (paramResvAttr.uint32_group_info_flag_ex4.has())
        {
          localObject2 = ((TroopManager)localObject1).c(String.valueOf(paramLong));
          ((TroopInfo)localObject2).groupFlagExt4 |= paramResvAttr.uint32_group_info_flag_ex4.get();
          ((TroopManager)localObject1).b((TroopInfo)localObject2);
        }
        if (paramResvAttr.bytes_group_msg_busi_buf.has()) {
          localObject2 = new oidb_0x787.MsgNeedField();
        }
      }
      try
      {
        ((oidb_0x787.MsgNeedField)localObject2).mergeFrom(paramResvAttr.bytes_group_msg_busi_buf.get().toByteArray());
        if (((oidb_0x787.MsgNeedField)localObject2).uint32_cmduin_flagex3_grocery.has()) {
          ((TroopManager)localObject1).b(String.valueOf(paramLong), String.valueOf(this.jdField_a_of_type_Long), ((oidb_0x787.MsgNeedField)localObject2).uint32_cmduin_flagex3_grocery.get());
        }
        return;
      }
      catch (Exception paramResvAttr)
      {
        paramResvAttr.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "kings_honor_level is null");
      }
    }
  }
  
  private void a(long paramLong1, boolean paramBoolean, long paramLong2, im_msg_body.Elem paramElem)
  {
    if (paramBoolean)
    {
      int j = paramElem.extra_info.uint32_flags.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "elem.extra_info.uint32_flags:" + j + "|groupCode:" + paramLong2 + "fromUin:" + paramLong1);
      }
      if ((j & 0x10) == 16)
      {
        paramElem = ((HotChatManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramLong2 + "");
        String str = paramLong1 + "";
        if ((paramElem != null) && (!paramElem.adminUins.contains(str))) {
          paramElem.adminUins.add(str);
        }
      }
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, long paramLong, generalflags.ResvAttr paramResvAttr, TroopManager paramTroopManager)
  {
    if ((paramPBDecodeContext.e == 1) && (paramResvAttr.uint32_custom_featureid.has()) && (paramTroopManager != null) && (paramResvAttr.uint32_custom_featureid.get() == 19713))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.qidian_private_troop", 2, "decodeSinglePbMsg_GroupDis, hasPrivateTroopFlag, troopUin=" + paramLong);
      }
      paramPBDecodeContext = paramTroopManager.b(String.valueOf(paramLong));
      if ((paramPBDecodeContext != null) && (!paramPBDecodeContext.isQidianPrivateTroop()))
      {
        paramPBDecodeContext.setQidianPrivateTroopFlag();
        paramTroopManager.b(paramPBDecodeContext);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.qidian_private_troop", 2, "set privateTroop flag, troopUin=" + paramLong);
        }
      }
    }
  }
  
  private void a(PBDecodeContext paramPBDecodeContext, long paramLong, im_msg_body.Elem paramElem)
  {
    boolean bool;
    if ((paramPBDecodeContext.e == 1) && (paramElem.general_flags.uint64_group_rank_seq.has()))
    {
      paramPBDecodeContext = String.valueOf(paramLong);
      if ((this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.mAutomator == null) || (!this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.mAutomator.c())) {
        break label203;
      }
      bool = true;
      if (!bool) {
        break label209;
      }
      localTroopInfo = ((TroopManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramPBDecodeContext);
      if (localTroopInfo != null)
      {
        paramLong = paramElem.general_flags.uint64_group_rank_seq.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + paramPBDecodeContext + ", serverRankSeq=" + paramLong + ", localRankSeq=" + localTroopInfo.dwGroupLevelSeq + ", isSyncMsgFinish=" + bool);
        }
        if (paramLong > localTroopInfo.dwGroupLevelSeq) {
          ((TroopHandler)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(paramPBDecodeContext, false);
        }
      }
    }
    label203:
    label209:
    while (!QLog.isColorLevel())
    {
      TroopInfo localTroopInfo;
      return;
      bool = false;
      break;
    }
    QLog.d("Q.getTroopMemberLevelInfo", 2, "onNewMsg: troopUin=" + paramPBDecodeContext + ", isSyncMsgFinish=" + bool);
  }
  
  private void a(String paramString, TroopBindPublicAccountMgr paramTroopBindPublicAccountMgr)
  {
    if (paramTroopBindPublicAccountMgr.b(paramString))
    {
      int k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int j = 0;
      int m = k - 1;
      if (m >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)this.jdField_a_of_type_JavaUtilArrayList.get(m);
        k = j;
        if (TroopBindPublicAccountMgr.a(localMessageRecord))
        {
          if ((!TextUtils.isEmpty(localMessageRecord.msg)) || (localMessageRecord.msgData != null)) {
            break label89;
          }
          k = j;
        }
        for (;;)
        {
          m -= 1;
          j = k;
          break;
          label89:
          k = j;
          if (j == 0)
          {
            paramTroopBindPublicAccountMgr.a(paramString, localMessageRecord.uniseq);
            k = 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopBindPublicAccountMgr.redDot", 2, "decodePBAccountMSg:" + paramString + "," + localMessageRecord.uniseq + "," + localMessageRecord.shmsgseq);
          }
          paramTroopBindPublicAccountMgr.c(paramString);
        }
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if ((paramString2 != null) && (!paramString2.equals(this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getCurrentAccountUin())))
    {
      paramString2 = (TroopBindPublicAccountMgr)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
      if (!paramString2.a(paramString1))
      {
        a(paramString1, paramString2);
        if (this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getTroopMask(paramString1) == 3)
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.closeRcvMsgTmp", 2, "Shield troop recv msg:" + paramString1);
          }
          ((TroopHandler)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(paramString1, this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getCurrentAccountUin(), 0, 0);
        }
      }
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList, boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        ((MessageRecord)paramArrayList.next()).isOpenTroopMessage = true;
      }
      paramArrayList = (TroopManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((paramArrayList != null) && (!paramArrayList.f(paramString)))
      {
        paramArrayList = (TroopHandler)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
        if (paramArrayList != null) {
          paramArrayList.e(paramString, false);
        }
      }
    }
  }
  
  private void a(generalflags.ResvAttr paramResvAttr)
  {
    VipUtils.VipIconUtils.NamePlateVipTpye localNamePlateVipTpye;
    if ((this.jdField_c_of_type_Int != 0) && (paramResvAttr.uint32_nameplate_vip_type.has()) && (paramResvAttr.uint32_gray_name_plate.has()))
    {
      j = paramResvAttr.uint32_nameplate_vip_type.get();
      localNamePlateVipTpye = VipUtils.VipIconUtils.NamePlateVipTpye.a(j);
      if ((!VipUtils.VipIconUtils.a(j)) || (localNamePlateVipTpye.b())) {
        break label96;
      }
    }
    label96:
    for (int j = 1;; j = 0)
    {
      if ((paramResvAttr.uint32_gray_name_plate.get() != 0) || (j != 0)) {
        this.g = 1;
      }
      if ((this.jdField_c_of_type_Int == 3) && (!localNamePlateVipTpye.c())) {
        this.jdField_c_of_type_Int = 1;
      }
      return;
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, double paramDouble, int paramInt3, String paramString1, String paramString2, int paramInt4, String paramString3, int paramInt5, int paramInt6)
  {
    TroopManager localTroopManager;
    if ((!paramBoolean) || (this.jdField_b_of_type_Boolean))
    {
      if (paramInt1 != -100) {
        ((IBizTroopMemberInfoService)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getRuntimeService(IBizTroopMemberInfoService.class, "")).saveTroopMemberGlamourLevel(paramString1, paramString2, paramInt1);
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label306;
      }
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.TROOP_MANAGER);
      switch (paramInt5)
      {
      default: 
        localTroopManager.a(paramString1, paramString2, paramString3, paramInt3, null, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
      }
    }
    for (;;)
    {
      localTroopManager.a(paramString1, paramString2, this.jdField_a_of_type_JavaLangString, paramInt4, this.h);
      return;
      localTroopManager.a(paramString1, paramString2, paramString3, paramInt3, null, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
      continue;
      localTroopManager.a(paramString1, paramString2, "", paramInt3, paramString3, null, paramByte1, paramByte2, paramInt2, this.jdField_b_of_type_Long, this.jdField_a_of_type_Byte, 0L, paramDouble, null, -100, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.e, this.g, paramInt6);
    }
    label306:
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = new TroopMemberInfo();
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.newRealLevel = this.h;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopuin = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.memberuin = paramString2;
    switch (paramInt5)
    {
    default: 
      paramString1 = ColorNickManager.b(paramString3);
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNick = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick = paramString1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNickId = paramInt6;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.level = paramInt3;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.realLevel = paramInt4;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.sex = paramByte2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.age = paramByte1;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distance = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.msgseq = this.jdField_b_of_type_Long;
      paramString1 = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
      if (this.jdField_a_of_type_Byte != 1) {
        break;
      }
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramString1.isTroopFollowed = paramBoolean;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distanceToSelf = paramDouble;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.distanceToSelfUpdateTimeStamp = System.currentTimeMillis();
      return;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopnick = "";
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.friendnick = paramString3;
      this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo.troopColorNickId = paramInt6;
      break;
    }
  }
  
  private boolean a(im_msg_body.Elem paramElem)
  {
    if (QLog.isColorLevel()) {
      if (!((im_msg_body.PubGroup)paramElem.pub_group.get()).bytes_nickname.has()) {
        break label74;
      }
    }
    label74:
    for (paramElem = ((im_msg_body.PubGroup)paramElem.pub_group.get()).bytes_nickname.get().toStringUtf8();; paramElem = null)
    {
      QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive  pub_group,bytes_nickname = " + paramElem);
      return true;
    }
  }
  
  private boolean a(boolean paramBoolean, im_msg_body.Elem paramElem)
  {
    boolean bool2 = true;
    boolean bool1 = paramBoolean;
    if (paramElem.general_flags.uint32_group_type.has()) {
      switch (paramElem.general_flags.uint32_group_type.get())
      {
      }
    }
    for (;;)
    {
      bool1 = paramBoolean;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis,receive general_flags.uint32_group_type, isPubGroupVisitor = " + paramBoolean + ", isHotChatMsg = " + this.jdField_b_of_type_Boolean);
        bool1 = paramBoolean;
      }
      return bool1;
      if (paramElem.general_flags.uint32_to_uin_flag.has())
      {
        if (paramElem.general_flags.uint32_to_uin_flag.get() == 2) {}
        for (paramBoolean = bool2;; paramBoolean = false) {
          break;
        }
        this.jdField_b_of_type_Boolean = true;
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public TroopHotChatTopicHandler a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -100;
    this.jdField_b_of_type_Int = -100;
    this.jdField_c_of_type_Int = -100;
    this.jdField_d_of_type_Int = -100;
    this.e = -100;
    this.f = -100;
    this.i = -100;
    this.g = 0;
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo = null;
    this.h = 0;
    a();
    long l;
    msg_comm.GroupInfo localGroupInfo;
    Object localObject1;
    int j;
    boolean bool2;
    boolean bool1;
    double d1;
    int k;
    Object localObject2;
    boolean bool3;
    int m;
    if ((this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.e == 1) || (this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext.e == 1026))
    {
      l = 0L;
      localGroupInfo = (msg_comm.GroupInfo)this.jdField_a_of_type_MsfMsgcommMsg_comm$MsgHead.group_info.get();
      if (localGroupInfo != null) {
        l = localGroupInfo.group_code.get();
      }
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label725;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
      j = -100;
      bool2 = false;
      bool1 = false;
      d1 = -100.0D;
      k = -1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (im_msg_body.Elem)((Iterator)localObject1).next();
        if (((im_msg_body.Elem)localObject2).general_flags.has())
        {
          bool3 = a(bool1, (im_msg_body.Elem)localObject2);
          m = a(j, (im_msg_body.Elem)localObject2);
          j = a(k, l, (im_msg_body.Elem)localObject2);
          a(this.jdField_a_of_type_ComTencentMobileqqServiceMessagePBDecodeContext, l, (im_msg_body.Elem)localObject2);
          k = m;
          bool1 = bool2;
          bool2 = bool3;
        }
        for (;;)
        {
          m = k;
          bool3 = bool2;
          k = j;
          j = m;
          bool2 = bool1;
          bool1 = bool3;
          break;
          if ((((im_msg_body.Elem)localObject2).extra_info.has()) && (((im_msg_body.Elem)localObject2).extra_info.uint32_flags.has()))
          {
            a(this.jdField_a_of_type_Long, this.jdField_b_of_type_Boolean, l, (im_msg_body.Elem)localObject2);
            m = j;
            bool3 = bool1;
            j = k;
            k = m;
            bool1 = bool2;
            bool2 = bool3;
          }
          else if (((im_msg_body.Elem)localObject2).pub_group.has())
          {
            bool2 = a((im_msg_body.Elem)localObject2);
            m = j;
            bool3 = bool1;
            j = k;
            k = m;
            bool1 = bool2;
            bool2 = bool3;
          }
          else
          {
            if ((!((im_msg_body.Elem)localObject2).elem_flags2.has()) || (!((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint32_longtitude.has()) || (!((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject2).elem_flags2.get()).uint32_latitude.has())) {
              break label700;
            }
            if (this.jdField_d_of_type_Long == this.jdField_a_of_type_Long) {
              break;
            }
            d1 = -1001.0D;
            m = j;
            bool3 = bool1;
            j = k;
            k = m;
            bool1 = bool2;
            bool2 = bool3;
          }
        }
      }
    }
    for (;;)
    {
      localObject1 = String.valueOf(l);
      localObject2 = (TroopManager)this.jdField_a_of_type_ComTencentImcoreMessageBaseMessageProcessorForTroopAndDisc.a.getManager(QQManagerFactory.TROOP_MANAGER);
      Object localObject3 = ((TroopManager)localObject2).b((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorForTroopAndDisc", 2, "decodeSinglePbMsg_GroupDis: troopUin=" + l + ", memberUin=" + this.jdField_a_of_type_Long + "，isHotChatMsg = " + this.jdField_b_of_type_Boolean + ",ti = " + localObject3);
      }
      a(l, (String)localObject1, (TroopManager)localObject2, (TroopInfo)localObject3);
      localObject2 = String.valueOf(this.jdField_a_of_type_Long);
      m = localGroupInfo.group_level.get();
      localObject3 = ColorNickManager.a(localGroupInfo.group_card.get());
      int n = ColorNickManager.a(localGroupInfo.group_card.get().toByteArray());
      int i1 = localGroupInfo.group_card_type.get();
      a(l);
      a(this.jdField_a_of_type_JavaUtilArrayList, bool1, (String)localObject1);
      a(bool2, j, (byte)0, (byte)1, 100, d1, k, (String)localObject1, (String)localObject2, m, (String)localObject3, i1, n);
      a((String)localObject1, (String)localObject2);
      return this;
      label700:
      m = j;
      bool3 = bool1;
      j = k;
      k = m;
      bool1 = bool2;
      bool2 = bool3;
      break;
      label725:
      k = -1;
      d1 = -100.0D;
      j = -100;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public TroopMemberInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc.TroopHotChatTopicHandler
 * JD-Core Version:    0.7.0.1
 */