package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleUnRead;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.graytip.CustomizeGrayTipsManager;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineStatusConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.theme.ThemeSwitcher;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tofumsg.TofuHelper;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vip.QVipConfigManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.RenameGroupResp;
import gxh_message.Dialogue;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.observer.AccountObserver;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ChatMatchInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FrdCustomOnlineStatusChange;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.FriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupMemberProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.GroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MQQCampusNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModCustomFace;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModFriendRemark;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupMemberProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupName;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModGroupSort;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModLongNick;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModProfile;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ModSnsGeneralInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.NewComeinUserNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PraiseRankNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ProfileInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushReportDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.PushSearchDev;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag;

public class SubType0x27
  implements Msg0X210SubTypeDecoder
{
  private int a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    if ((paramProfileInfo.uVipFont != FontManager.a(i)) || (paramProfileInfo.vipFontType != FontManager.b(i)))
    {
      paramProfileInfo.uVipFont = FontManager.a(i);
      paramProfileInfo.vipFontType = FontManager.b(i);
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramFriendsManager.a(paramProfileInfo);
      VasUtils.a(paramOnLinePushMessageProcessor.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + paramLong + ", id=" + paramProfileInfo.uVipFont + ", type = " + paramProfileInfo.vipFontType);
    }
    return (int)FontManager.a(i);
  }
  
  private int a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, Friends[] paramArrayOfFriends, int paramInt, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    String str = paramProfileInfo.bytes_value.get().toStringUtf8();
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "push a ModProfile Nick = " + str);
    }
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    paramProfileInfo = null;
    if (localFriends != null) {
      paramProfileInfo = localFriends.name;
    }
    paramArrayOfFriends[paramInt] = paramFriendsManager.a(paramLong + "", str);
    if ((localFriends != null) && (localFriends.isFriend()) && (QQProfileItem.a(str, paramProfileInfo))) {
      QQProfileItem.a(paramLong, str, (DiscussionManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.DISCUSSION_MANAGER));
    }
    paramArrayOfFriends = paramFriendsManager.a(paramLong + "");
    if (paramArrayOfFriends != null)
    {
      paramArrayOfFriends.strNick = str;
      paramFriendsManager.a(paramArrayOfFriends);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramArrayOfFriends);
    }
    paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    ((ITroopNameHelperService)paramOnLinePushMessageProcessor.a().getRuntimeService(ITroopNameHelperService.class, "")).onFriendNameChaned(Long.toString(paramLong));
    return paramInt + 1;
  }
  
  private int a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody, FriendsManager paramFriendsManager, Friends[] paramArrayOfFriends, int paramInt)
  {
    Object localObject1 = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    if (((SubMsgType0x27.ModProfile)localObject1).uint64_uin.has())
    {
      long l = ((SubMsgType0x27.ModProfile)localObject1).uint64_uin.get();
      paramForwardBody = (IProfileCommonService)paramOnLinePushMessageProcessor.a().getRuntimeService(IProfileCommonService.class, "all");
      paramForwardBody.notifyProfileModifyPushBegin(l);
      localObject1 = ((SubMsgType0x27.ModProfile)localObject1).rpt_msg_profile_infos.get().iterator();
      int j = 0;
      int i = 0;
      int k = 0;
      int m = paramInt;
      paramInt = k;
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (SubMsgType0x27.ProfileInfo)((Iterator)localObject1).next();
        k = i;
        ByteStringMicro localByteStringMicro;
        if (((SubMsgType0x27.ProfileInfo)localObject2).uint32_field.has())
        {
          k = i;
          if (((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.has())
          {
            k = ((SubMsgType0x27.ProfileInfo)localObject2).uint32_field.get();
            localByteStringMicro = ((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.get();
          }
        }
        switch (k)
        {
        default: 
          paramForwardBody.notifyProcessProfileModifyPush(k, localByteStringMicro);
          k = i;
          label578:
          int n = j;
          i = k;
          j = paramInt;
          paramInt = n;
        }
        for (;;)
        {
          k = j;
          j = paramInt;
          paramInt = k;
          break;
          m = a(paramOnLinePushMessageProcessor, paramFriendsManager, paramArrayOfFriends, m, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          s(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          r(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          j(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          q(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          p(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          o(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramOnLinePushMessageProcessor, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          n(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          k = a(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          paramInt = j;
          j = k;
          continue;
          m(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          l(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i = ByteBuffer.wrap(((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.get().toByteArray()).asIntBuffer().get();
          k = i;
          if (i == 0) {
            break label578;
          }
          k = 1;
          j = paramInt;
          paramInt = k;
          continue;
          k(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          j(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          i(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          h(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          g(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          localObject2 = ((TicketManager)paramOnLinePushMessageProcessor.a().getManager(2)).getSkey(l + "");
          ((VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a((String)localObject2, l + "");
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          f(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          e(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramOnLinePushMessageProcessor, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          h(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramOnLinePushMessageProcessor, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          g(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          f(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          e(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a((SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          d(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          c(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          b(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
          continue;
          a(paramOnLinePushMessageProcessor, (SubMsgType0x27.ProfileInfo)localObject2);
          k = paramInt;
          paramInt = j;
          j = k;
        }
      }
      paramForwardBody.notifyProfileModifyPushEnd();
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "Onlinepush hasDiyFontTimestamp: uin = " + l + " fontid = " + paramInt + " timestamp = " + i);
        }
        paramFriendsManager = paramFriendsManager.a(String.valueOf(l));
        paramForwardBody = paramFriendsManager;
        if (paramFriendsManager == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l);
        }
        j = paramInt;
        if (paramInt == 0) {
          j = (int)paramForwardBody.uVipFont;
        }
        FontManager.a(paramOnLinePushMessageProcessor.a(), String.valueOf(l), paramForwardBody, j, i);
      }
      return m;
    }
    return paramInt;
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = true;
    byte[] arrayOfByte = paramProfileInfo.bytes_value.get().toByteArray();
    boolean bool1;
    short s;
    if (arrayOfByte.length == 1) {
      if (arrayOfByte[0] == 1)
      {
        bool1 = true;
        paramOnLinePushMessageProcessor = (TempMsgManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
        s = (short)paramProfileInfo.uint32_field.get();
        if (bool1) {
          break label168;
        }
      }
    }
    for (;;)
    {
      paramOnLinePushMessageProcessor.a(s, false, "", bool2);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push temp msg block,uin=" + paramLong + ", id=" + bool1 + " field=" + paramProfileInfo.uint32_field.get());
      }
      return;
      bool1 = false;
      break;
      if (ByteBuffer.wrap(arrayOfByte).asShortBuffer().get() == 1) {}
      for (bool1 = true;; bool1 = false) {
        break;
      }
      label168:
      bool2 = false;
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    ByteStringMicro localByteStringMicro = paramProfileInfo.bytes_value.get();
    paramProfileInfo = new Dialogue();
    try
    {
      paramProfileInfo.mergeFrom(localByteStringMicro.toByteArray());
      int i = paramProfileInfo.short_nameplate_itemid.get();
      int j = paramProfileInfo.diyfontid.get();
      paramProfileInfo = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.bigClubExtTemplateId = i;
        paramProfileInfo.diyFontId = j;
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "vip_card_extension id by push=" + i);
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, PublicAccountDataManager paramPublicAccountDataManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_friend.has())
    {
      Object localObject1 = ((SubMsgType0x27.DelFriend)paramForwardBody.msg_del_friend.get()).rpt_uint64_uins.get();
      paramForwardBody = (QQStoryFeedManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER);
      localObject1 = ((List)localObject1).iterator();
      long l;
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label436;
        }
        l = ((Long)((Iterator)localObject1).next()).longValue();
        paramFriendsManager.d(l + "");
        paramPublicAccountDataManager.b(l + "");
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a DelFriend  = id:" + l);
        }
        try
        {
          localObject2 = (QidianManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.QIDIAN_MANAGER);
          if ((localObject2 != null) && (((QidianManager)localObject2).a(l + "")))
          {
            paramOnLinePushMessageProcessor.a().getProxyManager().a().a(String.valueOf(l), true);
            localObject2 = paramOnLinePushMessageProcessor.a().getApplication().getBaseContext().getSharedPreferences(paramOnLinePushMessageProcessor.a().getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
            ((SharedPreferences.Editor)localObject2).putBoolean(paramOnLinePushMessageProcessor.a().getCurrentAccountUin() + "_" + l + "", false);
            ((SharedPreferences.Editor)localObject2).apply();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Object localObject2;
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a DelFriend  = id:" + l + " error :" + localException.toString());
            }
          }
        }
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(15, true, Long.valueOf(l));
        localObject2 = String.valueOf(l);
        paramForwardBody.a((String)localObject2);
        IceBreakingUtil.a(paramOnLinePushMessageProcessor.a(), (String)localObject2);
        TofuHelper.a(paramOnLinePushMessageProcessor.a(), (String)localObject2);
      }
      label436:
      paramOnLinePushMessageProcessor = (PhoneContactManagerImp)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CONTACT_MANAGER);
      if (paramOnLinePushMessageProcessor != null) {
        paramOnLinePushMessageProcessor.b();
      }
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject5;
    int i;
    Object localObject4;
    if (paramForwardBody.msg_mod_friend_rings.has())
    {
      localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramForwardBody.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
        localObject3 = ((SubMsgType0x27.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.get().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject5 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject3).next();
          i = ((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get();
          byte[] arrayOfByte;
          if ((i == 13569) && (((SubMsgType0x27.SnsUpateBuffer)localObject2).uint32_result.get() == 0))
          {
            localObject4 = paramTroopManager.b(Long.toString(((SubMsgType0x27.SnsUpateBuffer)localObject2).uint64_uin.get()));
            i = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().size();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 4, "ONLine push commonTroop troopUin=" + (String)localObject4 + " status=" + i);
            }
            if (i == 0)
            {
              if (paramTroopManager.c((String)localObject4)) {
                paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER).notifyUI(18, true, new Object[] { localObject4, Integer.valueOf(1), Integer.valueOf(0), null });
              }
            }
            else if (i >= 4)
            {
              localObject5 = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toByteArray();
              arrayOfByte = new byte[4];
              System.arraycopy(localObject5, 0, arrayOfByte, 0, 4);
              if (paramTroopManager.a((String)localObject4, MessageHandlerUtils.a(arrayOfByte))) {
                paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.BIZ_TROOP_HANDLER).notifyUI(18, true, new Object[] { localObject4, Integer.valueOf(0), Integer.valueOf(0), null });
              }
            }
          }
          else if (i == 13571)
          {
            localObject4 = String.valueOf(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject2).uint64_code.get()));
            i = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().size();
            localObject5 = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toByteArray();
            if (i >= 6)
            {
              i = localObject5[1];
              if (i == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                }
                arrayOfByte = new byte[4];
                System.arraycopy(localObject5, 2, arrayOfByte, 0, 4);
                if (paramTroopManager.b((String)localObject4, MessageHandlerUtils.a(arrayOfByte))) {
                  paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER).notifyUI(TroopNotificationConstants.ac, true, new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                }
              }
              if ((i == 0) && (paramTroopManager.e((String)localObject4))) {
                paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER).notifyUI(TroopNotificationConstants.ac, true, new Object[] { localObject4, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
              }
            }
          }
        }
      }
    }
    if (paramForwardBody.msg_mod_friend_rings.has())
    {
      paramTroopManager = (SubMsgType0x27.ModSnsGeneralInfo)paramForwardBody.msg_mod_friend_rings.get();
      if ((paramTroopManager != null) && (paramTroopManager.rpt_msg_sns_general_infos.has()))
      {
        paramTroopManager = paramTroopManager.rpt_msg_sns_general_infos.get();
        localObject1 = new HashMap();
        localObject2 = paramTroopManager.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          paramTroopManager = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject2).next();
          if ((paramTroopManager != null) && (paramTroopManager.uint64_uin.has()) && (paramTroopManager.rpt_msg_sns_update_item.has()))
          {
            long l = paramTroopManager.uint64_uin.get();
            localObject3 = String.valueOf(l);
            localObject4 = paramTroopManager.rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject5 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject4).next();
              if ((localObject5 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.has()) && (!FriendsStatusUtil.a((SubMsgType0x27.SnsUpdateItem)localObject5, paramOnLinePushMessageProcessor.a(), (String)localObject3)))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get() == 13568) {
                  QvipSpecialCareManager.a((String)localObject3, ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toStringUtf8(), paramOnLinePushMessageProcessor.a());
                }
                paramForwardBody = (SpecialCareInfo)((HashMap)localObject1).get(localObject3);
                paramTroopManager = paramForwardBody;
                if (paramForwardBody == null)
                {
                  paramForwardBody = paramFriendsManager.a(String.valueOf(l));
                  paramTroopManager = paramForwardBody;
                  if (paramForwardBody == null)
                  {
                    paramTroopManager = new SpecialCareInfo();
                    paramTroopManager.uin = String.valueOf(l);
                  }
                  ((HashMap)localObject1).put(paramTroopManager.uin, paramTroopManager);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject5).uint32_update_sns_type.get();
                paramForwardBody = ((SubMsgType0x27.SnsUpdateItem)localObject5).bytes_value.get().toStringUtf8();
                FriendListHandler.initSpecialCareInfo(paramTroopManager, i, paramForwardBody);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramTroopManager.uin + ", itemtype=" + i + ",itemVal=" + paramForwardBody);
                }
              }
            }
          }
        }
        paramTroopManager = ((HashMap)localObject1).entrySet().iterator();
        paramForwardBody = new ArrayList();
        while (paramTroopManager.hasNext())
        {
          localObject1 = (SpecialCareInfo)((Map.Entry)paramTroopManager.next()).getValue();
          if ((localObject1 != null) && ((((SpecialCareInfo)localObject1).getStatus() != 1000) || (((SpecialCareInfo)localObject1).globalSwitch != 0))) {
            paramForwardBody.add(localObject1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + paramForwardBody.size());
        }
        paramFriendsManager.c(paramForwardBody);
        if (paramForwardBody.size() > 0) {
          paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(99, true, new Object[] { Boolean.valueOf(true), paramForwardBody });
        }
      }
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_rich_long_nick_ex.has())
    {
      SubMsgType0x27.ModLongNick localModLongNick = (SubMsgType0x27.ModLongNick)paramForwardBody.msg_mod_rich_long_nick_ex.get();
      String str = Long.toString(localModLongNick.uint64_uin.get());
      paramForwardBody = ByteBuffer.wrap(localModLongNick.bytes_value.get().toByteArray());
      long l = paramForwardBody.getLong();
      byte[] arrayOfByte = new byte[paramForwardBody.remaining()];
      paramForwardBody.get(arrayOfByte);
      ExtensionInfo localExtensionInfo = paramFriendsManager.a(str);
      paramForwardBody = localExtensionInfo;
      if (localExtensionInfo == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = str;
      }
      ExtensionRichStatus.a(paramForwardBody, arrayOfByte, l);
      paramForwardBody.isAdded2C2C = SignatureManager.a(paramOnLinePushMessageProcessor.a(), str, ExtensionRichStatus.a(paramForwardBody));
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + str + " result =  " + paramForwardBody.isAdded2C2C);
      }
      paramFriendsManager.a(paramForwardBody);
      paramForwardBody = paramFriendsManager.a(localModLongNick.uint64_uin.get() + "");
      if (paramForwardBody != null)
      {
        paramForwardBody.vRichSign = arrayOfByte;
        paramForwardBody.lSignModifyTime = l;
        paramFriendsManager.a(paramForwardBody);
      }
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(2, true, new String[] { str });
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_group_member_profile.has())
    {
      Object localObject1 = (SubMsgType0x27.ModGroupMemberProfile)paramForwardBody.msg_mod_group_member_profile.get();
      if ((((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.has()) && (((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.has()))
      {
        long l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.get();
        long l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.get();
        long l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_uin.get();
        paramForwardBody = ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).getTroopMemberCardInfo(paramOnLinePushMessageProcessor.a(), l2 + "", l3 + "");
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        label1076:
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() != 1) {
              break label505;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
            }
            QQProfileItem.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
            if (paramForwardBody != null)
            {
              paramForwardBody.colorNick = ColorNickManager.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get());
              paramForwardBody.name = ColorNickManager.b(paramForwardBody.colorNick);
              paramForwardBody.colorNickId = ColorNickManager.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray());
              paramTroopManager.a(l1 + "", l3 + "", paramForwardBody.colorNick, -100, null, null, -100, -100, -100, -100L, -100L, paramForwardBody.colorNickId);
            }
          }
          for (;;)
          {
            if (paramForwardBody == null) {
              break label1076;
            }
            ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).saveTroopMemberCardInfo(paramOnLinePushMessageProcessor.a(), paramForwardBody);
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramForwardBody);
            paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER).notifyUI(TroopNotificationConstants.q, true, localObject2);
            paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER).notifyUI(TroopNotificationConstants.k, true, new Object[] { localObject2, Boolean.valueOf(true) });
            break;
            label505:
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 2)
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size() == 1)
              {
                byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().byteAt(0);
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                }
                paramTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                if (paramForwardBody != null) {
                  paramForwardBody.sex = b;
                }
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 3)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject2);
              }
              if (paramForwardBody != null) {
                paramForwardBody.tel = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 4)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject2);
              }
              if (paramForwardBody != null) {
                paramForwardBody.email = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 5)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject2);
              }
              ((TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER)).a(l1 + "", l3 + "", null, -100, null, (String)localObject2, -100, -100, -100, -100L, -100L);
              if (paramForwardBody != null) {
                paramForwardBody.memo = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 6)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 6--job= " + (String)localObject2);
              }
              if (paramForwardBody != null) {
                paramForwardBody.job = ((String)localObject2);
              }
            }
            else if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 7) && (paramForwardBody != null))
            {
              paramForwardBody.colorNick = ColorNickManager.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get());
              paramForwardBody.name = ColorNickManager.b(paramForwardBody.colorNick);
              paramForwardBody.colorNickId = ColorNickManager.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray());
            }
          }
        }
      }
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_push_report_dev.has())
    {
      paramForwardBody = (SubMsgType0x27.PushReportDev)paramForwardBody.msg_push_report_dev.get();
      Bundle localBundle = new Bundle();
      localBundle.putInt("optype", 201);
      if (paramForwardBody.uint32_msg_type.has()) {
        localBundle.putInt("msgtype", paramForwardBody.uint32_msg_type.get());
      }
      if (paramForwardBody.bytes_cookie.has()) {
        localBundle.putString("cookie", paramForwardBody.bytes_cookie.get().toStringUtf8());
      }
      if (paramForwardBody.uint32_report_max_num.has()) {
        localBundle.putInt("count", paramForwardBody.uint32_report_max_num.get());
      }
      if (paramForwardBody.bytes_sn.has()) {
        localBundle.putString("sn", paramForwardBody.bytes_sn.get().toStringUtf8());
      }
      ((SmartDeviceProxyMgr)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(39, localBundle);
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ((CustomizeGrayTipsManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).a(i);
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    Object localObject2;
    int i;
    for (;;)
    {
      PublicAccountDataManager localPublicAccountDataManager;
      SubMsgType0x27.ForwardBody localForwardBody;
      try
      {
        localObject2 = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        paramArrayOfByte = (FriendsManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.FRIENDS_MANAGER);
        localObject1 = (TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER);
        localPublicAccountDataManager = (PublicAccountDataManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
        Object localObject3 = ((SubMsgType0x27.MsgBody)localObject2).rpt_msg_mod_infos.get();
        i = 0;
        localObject2 = new Friends[((List)localObject3).size()];
        localObject3 = ((List)localObject3).iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localForwardBody = (SubMsgType0x27.ForwardBody)((Iterator)localObject3).next();
        if (((localForwardBody.uint32_notify_type.has()) && (localForwardBody.uint32_notify_type.get() == 1)) || (!localForwardBody.uint32_op_type.has())) {
          continue;
        }
        switch (localForwardBody.uint32_op_type.get())
        {
        case 60: 
        case 61: 
        default: 
          break;
        case 0: 
          i(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
          break;
        case 1: 
          h(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
        }
      }
      catch (Exception paramOnLinePushMessageProcessor)
      {
        QLog.e("MsgType0x210SubMsgType0x27", 1, "handleMsgType0x210SubMsgType0x27 decode fail.", paramOnLinePushMessageProcessor);
        return;
      }
      continue;
      g(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
      continue;
      f(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
      continue;
      e(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
      continue;
      a(paramOnLinePushMessageProcessor, paramArrayOfByte, localPublicAccountDataManager, localForwardBody);
      continue;
      a(paramOnLinePushMessageProcessor, paramArrayOfByte, (TroopManager)localObject1, localForwardBody);
      continue;
      d(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
      continue;
      if (localForwardBody.msg_mod_profile.has())
      {
        i = a(paramOnLinePushMessageProcessor, localForwardBody, paramArrayOfByte, (Friends[])localObject2, i);
        continue;
        c(paramOnLinePushMessageProcessor, (TroopManager)localObject1, localForwardBody);
        continue;
        c(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
        continue;
        b(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
        continue;
        a(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
        continue;
        b(paramOnLinePushMessageProcessor, (TroopManager)localObject1, localForwardBody);
        continue;
        a(paramOnLinePushMessageProcessor, (TroopManager)localObject1, localForwardBody);
        continue;
        g(paramOnLinePushMessageProcessor, localForwardBody);
        continue;
        f(paramOnLinePushMessageProcessor, localForwardBody);
        continue;
        b(paramOnLinePushMessageProcessor, localForwardBody);
        continue;
        a(paramOnLinePushMessageProcessor, localForwardBody);
        continue;
        e(paramOnLinePushMessageProcessor, localForwardBody);
        continue;
        d(paramOnLinePushMessageProcessor, localForwardBody);
        continue;
        c(paramOnLinePushMessageProcessor, localForwardBody);
        continue;
        b(localForwardBody);
        a(localForwardBody);
      }
    }
    paramArrayOfByte.a((Friends[])localObject2, i);
  }
  
  private void a(FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    paramProfileInfo.pendantDiyId = i;
    paramProfileInfo.timestamp = System.currentTimeMillis();
    paramFriendsManager.a(paramProfileInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + paramLong + ", id=" + paramProfileInfo.pendantDiyId);
    }
  }
  
  private void a(SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      paramForwardBody = (SubMsgType0x27.FrdCustomOnlineStatusChange)paramForwardBody.msg_frd_custom_online_status_change.get();
      if (paramForwardBody != null)
      {
        CustomOnlineStatusManager.Utils.a(paramForwardBody);
        QLog.d("Q.msg.BaseMessageProcessorCustomOnlineStatus", 2, "SubMsgType0x27.FrdCustomOnlineStatusChange");
      }
      return;
    }
    catch (Exception paramForwardBody)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.FrdCustomOnlineStatusChange fail", paramForwardBody);
    }
  }
  
  private void a(SubMsgType0x27.FriendRemark paramFriendRemark, OnLinePushMessageProcessor paramOnLinePushMessageProcessor)
  {
    if (paramFriendRemark.uint64_group_code.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop troopcode = " + paramFriendRemark.uint64_group_code.get());
      }
      TroopManager localTroopManager = (TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER);
      TroopInfo localTroopInfo = localTroopManager.c(String.valueOf(paramFriendRemark.uint64_group_code.get()));
      localTroopInfo.troopRemark = paramFriendRemark.bytes_rmk_name.get().toStringUtf8();
      localTroopManager.b(localTroopInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER).notifyUI(TroopNotificationConstants.aC, true, null);
    }
  }
  
  private void a(SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ThemeFontAdapter.b(i);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, " theme font online push " + paramProfileInfo.uint32_field.get() + " id:" + i);
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ((VasExtensionManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(Long.toString(paramLong), i);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + paramLong + ", id=" + i);
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 0;
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    }
    for (;;)
    {
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      if ((paramProfileInfo != null) && (paramProfileInfo.mQQLevelType != i))
      {
        paramProfileInfo.mQQLevelType = i;
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      return;
      if (paramProfileInfo.length == 2) {
        i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
      } else if (paramProfileInfo.length == 4) {
        i = ByteBuffer.wrap(paramProfileInfo).asIntBuffer().get();
      } else {
        QLog.e("Q.msg.BaseMessageProcessor", 2, "rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error, len:" + paramProfileInfo.length);
      }
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_friend_remark.has())
    {
      Iterator localIterator = ((SubMsgType0x27.ModFriendRemark)paramForwardBody.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
      while (localIterator.hasNext())
      {
        SubMsgType0x27.FriendRemark localFriendRemark = (SubMsgType0x27.FriendRemark)localIterator.next();
        if (localFriendRemark.uint32_type.has()) {
          if (localFriendRemark.uint32_type.get() == 0)
          {
            long l = localFriendRemark.uint64_fuin.get();
            Friends localFriends = paramFriendsManager.e(Long.toString(l));
            paramForwardBody = null;
            if (localFriends != null) {
              paramForwardBody = localFriends.remark;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + localFriendRemark.uint64_fuin.get() + "备注 = " + localFriendRemark.bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramForwardBody);
            }
            paramFriendsManager.b(localFriendRemark.uint64_fuin.get() + "", localFriendRemark.bytes_rmk_name.get().toStringUtf8());
            Card localCard = paramFriendsManager.a(localFriendRemark.uint64_fuin.get() + "");
            String str = localFriendRemark.bytes_rmk_name.get().toStringUtf8();
            if ((localCard != null) && (!str.equals(localCard.strReMark)))
            {
              localCard.strReMark = str;
              paramFriendsManager.a(localCard);
            }
            if ((localFriends != null) && (localFriends.isFriend()) && (QQProfileItem.b(str, paramForwardBody))) {
              QQProfileItem.b(l, str, (DiscussionManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.DISCUSSION_MANAGER));
            }
            paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(localFriendRemark.uint64_fuin.get()));
            paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(27, true, new Object[] { localFriendRemark.uint64_fuin.get() + "", localFriendRemark.bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
            ((ITroopNameHelperService)paramOnLinePushMessageProcessor.a().getRuntimeService(ITroopNameHelperService.class, "")).onFriendNameChaned(Long.toString(l));
          }
          else if (localFriendRemark.uint32_type.get() == 1)
          {
            a(localFriendRemark, paramOnLinePushMessageProcessor);
          }
        }
      }
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    long l1;
    long l2;
    if (paramForwardBody.msg_mod_group_profile.has())
    {
      paramForwardBody = (SubMsgType0x27.ModGroupProfile)paramForwardBody.msg_mod_group_profile.get();
      if (paramForwardBody.uint64_group_code.has())
      {
        l1 = paramForwardBody.uint64_group_uin.get();
        l2 = paramForwardBody.uint64_group_code.get();
      }
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramForwardBody = paramForwardBody.rpt_msg_group_profile_infos.get().iterator();
        if (paramForwardBody.hasNext())
        {
          localObject = (SubMsgType0x27.GroupProfileInfo)paramForwardBody.next();
          if ((!((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.has())) {
            continue;
          }
          if (((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.get() == 1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.get().toStringUtf8());
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception paramOnLinePushMessageProcessor)
      {
        paramOnLinePushMessageProcessor.printStackTrace();
      }
      if (((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.get() == 2)
      {
        localObject = ((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.get();
        if ((localObject != null) && (((ByteStringMicro)localObject).size() == 2))
        {
          int i = ((ByteStringMicro)localObject).byteAt(0);
          short s = (short)(((ByteStringMicro)localObject).byteAt(1) | i << 8);
          localObject = paramTroopManager.b(l1 + "");
          ((TroopInfo)localObject).troopface = s;
          ((TroopInfo)localObject).hasSetNewTroopHead = true;
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
          }
          paramTroopManager.b((TroopInfo)localObject);
          ((IQQAvatarHandlerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IQQAvatarHandlerService.class, "")).getTroopHead(l1 + "");
        }
      }
      else if (((SubMsgType0x27.GroupProfileInfo)localObject).uint32_field.get() == 3)
      {
        localObject = ((SubMsgType0x27.GroupProfileInfo)localObject).bytes_value.get().toStringUtf8();
        if (QLog.isColorLevel()) {
          QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange:" + l1 + "," + l2 + "," + (String)localObject);
        }
        TroopInfo localTroopInfo = paramTroopManager.b(l2 + "");
        if (localTroopInfo != null)
        {
          localTroopInfo.troopCreditLevel = Long.valueOf((String)localObject).longValue();
          paramTroopManager.b(localTroopInfo);
          if (QLog.isColorLevel()) {
            QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange, save");
          }
        }
      }
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_push_search_dev.has())
    {
      paramForwardBody = (SubMsgType0x27.PushSearchDev)paramForwardBody.msg_push_search_dev.get();
      Bundle localBundle = new Bundle();
      localBundle.putInt("optype", 200);
      if (paramForwardBody.uint32_msg_type.has()) {
        localBundle.putInt("msgtype", paramForwardBody.uint32_msg_type.get());
      }
      if (paramForwardBody.uint32_dev_time.has()) {
        localBundle.putInt("devtime", paramForwardBody.uint32_dev_time.get());
      }
      if (paramForwardBody.uint64_din.has()) {
        localBundle.putLong("din", paramForwardBody.uint64_din.get());
      }
      if (paramForwardBody.str_data.has()) {
        localBundle.putString("data", paramForwardBody.str_data.get());
      }
      ((SmartDeviceProxyMgr)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(39, localBundle);
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "handleModProfileBranch: invoked. c2c online push, field id: 27370, changed global ring id", " ringId: ", Integer.valueOf(i) });
    }
    MessageNotificationSettingManager.a(paramOnLinePushMessageProcessor.a()).b(i);
  }
  
  private void b(FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.cNewLoverDiamondFlag = i;
        paramFriendsManager.a(paramProfileInfo);
      }
      return;
    }
  }
  
  private void b(SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      if ((SubMsgType0x27.ChatMatchInfo)paramForwardBody.msg_chat_match_info.get() != null) {
        QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
      }
      return;
    }
    catch (Exception paramForwardBody)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.ChatMatchInfo fail", paramForwardBody);
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 3;
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    SharedPreferences localSharedPreferences;
    if (((paramProfileInfo.byteAt(31) & 0x20) != 0) || ((paramProfileInfo.byteAt(34) & 0x10) != 0) || ((paramProfileInfo.byteAt(29) & 0x10) != 0))
    {
      localSharedPreferences = paramOnLinePushMessageProcessor.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if (((paramProfileInfo.byteAt(11) & 0x20) == 0) && ((paramProfileInfo.byteAt(14) & 0x10) == 0)) {
        break label359;
      }
      i = 4;
      if (i != -1)
      {
        localSharedPreferences.edit().putInt("message_roam_flag" + paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), i).apply();
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(101, true, Integer.valueOf(i));
      }
    }
    if ((paramProfileInfo.byteAt(12) & 0x8) != 0)
    {
      bool = true;
      label185:
      SttManager.a(paramOnLinePushMessageProcessor.a(), bool);
      if ((paramProfileInfo.byteAt(13) & 0x40) == 0) {
        break label438;
      }
    }
    label438:
    for (boolean bool = true;; bool = false)
    {
      if (SettingCloneUtil.readValue(paramOnLinePushMessageProcessor.a().getApplication(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false) != bool)
      {
        SettingCloneUtil.writeValue(paramOnLinePushMessageProcessor.a().getApplication(), Long.valueOf(paramLong).toString(), null, "qqsetting_pcactive_key", bool);
        paramProfileInfo = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        paramProfileInfo.putExtra("pcActive", bool);
        paramProfileInfo.putExtra("uin", Long.valueOf(paramLong).toString());
        paramOnLinePushMessageProcessor.a().getApp().sendBroadcast(paramProfileInfo);
        if (bool)
        {
          SettingCloneUtil.writeValue(paramOnLinePushMessageProcessor.a().getApplication(), Long.toString(paramLong), null, "pcactive_config", true);
          paramOnLinePushMessageProcessor.a().openMsfPCActive(Long.toString(paramLong), "config", true);
          QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
        }
      }
      return;
      label359:
      if ((paramProfileInfo.byteAt(9) & 0x10) != 0) {
        break;
      }
      i = localSharedPreferences.getInt("message_roam_flag" + paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), -1);
      if ((i == 4) || (i == 3))
      {
        i = 1;
        break;
      }
      i = -1;
      break;
      bool = false;
      break label185;
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club iVipType change = " + i);
      }
      paramProfileInfo = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.bigClubInfo = ((i & 0xFF) << 16 | paramProfileInfo.bigClubInfo & 0xFF00FFFF);
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      paramFriendsManager = ((TicketManager)paramOnLinePushMessageProcessor.a().getManager(2)).getSkey(paramLong + "");
      ((VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramFriendsManager, paramLong + "");
      return;
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_daren_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.DaRenNotify)paramForwardBody.msg_daren_notify.get();
      long l = paramForwardBody.uint64_uin.get();
      int i = paramForwardBody.uint32_login_days.get();
      int j = paramForwardBody.uint32_days.get();
      if (paramOnLinePushMessageProcessor.a().getCurrentAccountUin().equals(String.valueOf(l)))
      {
        paramForwardBody = paramFriendsManager.b(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
        if ((i != paramForwardBody.lLoginDays) || (j != paramForwardBody.lQQMasterLogindays))
        {
          paramForwardBody.lLoginDays = i;
          paramForwardBody.lQQMasterLogindays = j;
          paramFriendsManager.a(paramForwardBody);
          paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramForwardBody);
        }
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramForwardBody.lLoginDays + ";days=" + paramForwardBody.lQQMasterLogindays);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "daren notify received uin=" + l + ";logindays=" + i + ";days=" + j);
      }
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    SubMsgType0x27.ModCustomFace localModCustomFace;
    if (paramForwardBody.msg_mod_custom_face.has())
    {
      localModCustomFace = (SubMsgType0x27.ModCustomFace)paramForwardBody.msg_mod_custom_face.get();
      if ((localModCustomFace.uint32_type.has()) && (localModCustomFace.uint64_uin.has()))
      {
        paramForwardBody = (IQQAvatarHandlerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IQQAvatarHandlerService.class, "");
        if (localModCustomFace.uint32_type.get() != 0) {
          break label152;
        }
        l = localModCustomFace.uint64_uin.get();
        paramTroopManager = Long.toString(l);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l);
        }
        paramForwardBody.getCustomHead(paramTroopManager);
        paramForwardBody.sendBroadCastHeadChanged(1, paramTroopManager);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramTroopManager);
      }
    }
    label152:
    while (localModCustomFace.uint32_type.get() != 1) {
      return;
    }
    long l = localModCustomFace.uint64_group_code.get();
    if (QLog.isColorLevel()) {
      QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l);
    }
    paramOnLinePushMessageProcessor = paramTroopManager.b(String.valueOf(l));
    paramOnLinePushMessageProcessor.hasSetNewTroopHead = true;
    paramTroopManager.b(paramOnLinePushMessageProcessor);
    paramForwardBody.getTroopHead(Long.toString(l));
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      paramForwardBody = (SubMsgType0x27.MQQCampusNotify)paramForwardBody.msg_campus_notify.get();
      if (paramForwardBody != null) {
        ((CampusNoticeManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(paramForwardBody);
      }
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", paramOnLinePushMessageProcessor);
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    boolean bool1;
    Object localObject;
    String str;
    if (paramProfileInfo.length > 1) {
      if (paramProfileInfo[1] == 1)
      {
        bool1 = true;
        QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value:" + bool1);
        boolean bool2 = bool1;
        if (bool1)
        {
          paramProfileInfo = (PttAutoChangeBean)QConfigManager.a().a(442);
          bool2 = bool1;
          if (paramProfileInfo != null)
          {
            bool2 = bool1;
            if (!paramProfileInfo.a())
            {
              QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "get ptt auto to txt push switch is true but config is close!!");
              bool2 = false;
            }
          }
        }
        localObject = paramOnLinePushMessageProcessor.a().getApp().getSharedPreferences("check_update_sp_key", 0);
        paramProfileInfo = "businessinfo_ptt_auto_change_text_" + paramOnLinePushMessageProcessor.a().getCurrentAccountUin();
        str = "businessinfo_ptt_auto_change_time_" + paramOnLinePushMessageProcessor.a().getCurrentAccountUin();
        paramOnLinePushMessageProcessor = "businessinfo_ptt_auto_change_guide_has_show_" + paramOnLinePushMessageProcessor.a().getCurrentAccountUin();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).putBoolean(paramProfileInfo, bool2);
        long l = NetConnInfoCenter.getServerTime();
        if (!bool2) {
          break label276;
        }
        ((SharedPreferences.Editor)localObject).putLong(str, l);
        ((SharedPreferences.Editor)localObject).putBoolean(paramOnLinePushMessageProcessor, true);
        label253:
        ((SharedPreferences.Editor)localObject).apply();
        com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper.c = bool2;
        com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper.a = l;
      }
    }
    label276:
    do
    {
      return;
      bool1 = false;
      break;
      ((SharedPreferences.Editor)localObject).putLong(str, 9223372036854775807L);
      break label253;
      QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
      paramProfileInfo = new ArrayList();
      paramProfileInfo.add(Short.valueOf((short)-23249));
      paramOnLinePushMessageProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(paramOnLinePushMessageProcessor.a(), TempGetProfileDetailProcessor.class);
    } while (paramOnLinePushMessageProcessor == null);
    paramOnLinePushMessageProcessor.getDetailCardInfo(paramProfileInfo, null);
  }
  
  private void c(FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42354 = " + i);
      }
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.grayNameplateFlag = i;
        paramFriendsManager.a(paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.grayNameplateFlag = i;
        paramFriendsManager.a(localFriends);
      }
    }
  }
  
  private void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.lBigClubTemplateId = i;
        paramProfileInfo.lSuperVipTemplateId = i;
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.superVipTemplateId = i;
        localFriends.bigClubTemplateId = i;
        paramFriendsManager.a(localFriends);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      return;
    }
  }
  
  private void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_friend_flag.has())
    {
      paramForwardBody = (SubMsgType0x27.SnsUpdateFlag)paramForwardBody.msg_mod_friend_flag.get();
      if (paramForwardBody.rpt_msg_update_sns_flag.has())
      {
        paramForwardBody = paramForwardBody.rpt_msg_update_sns_flag.get().iterator();
        while (paramForwardBody.hasNext())
        {
          Object localObject = (SubMsgType0x27.SnsUpdateOneFlag)paramForwardBody.next();
          long l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject).uint64__uin.get();
          int i = ((SubMsgType0x27.SnsUpdateOneFlag)localObject).uint32_flag.get();
          long l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject).uint64_id.get();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + i + " id:" + l2);
          }
          if (l2 == 4051L)
          {
            localObject = paramFriendsManager.e(String.valueOf(l1));
            if (localObject != null)
            {
              if (i == 1) {}
              for (boolean bool = true;; bool = false)
              {
                ((Friends)localObject).setShieldFlag(bool);
                paramFriendsManager.a((Friends)localObject);
                paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
                break;
              }
            }
          }
        }
      }
    }
  }
  
  private void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    paramForwardBody = (SubMsgType0x27.PraiseRankNotify)paramForwardBody.msg_praise_rank_notify.get();
    if (paramForwardBody.str_msg.has()) {}
    for (paramForwardBody = paramForwardBody.str_msg.get();; paramForwardBody = null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "praise rank notify: " + paramForwardBody);
      }
      if (!TextUtils.isEmpty(paramForwardBody))
      {
        Bitmap localBitmap = BitmapManager.a(paramOnLinePushMessageProcessor.a().getApp().getResources(), 2130840535);
        ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
        Intent localIntent = new Intent(paramOnLinePushMessageProcessor.a().getApp(), LikeRankingListActivity.class);
        localIntent.putExtra("param_from", 1);
        localIntent.addFlags(67108864);
        localToServiceMsg.extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramForwardBody });
        localToServiceMsg.extraData.putParcelable("intent", localIntent);
        localToServiceMsg.extraData.putParcelable("bitmap", localBitmap);
        paramOnLinePushMessageProcessor.a().sendToService(localToServiceMsg);
        ReportController.b(paramOnLinePushMessageProcessor.a(), "dc00898", "", "", "0X8007618", "0X8007618", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  private void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool = false;
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {
      if (paramProfileInfo[0] == 0) {
        bool = true;
      }
    }
    for (;;)
    {
      StickerRecManager.a(paramOnLinePushMessageProcessor.a()).a(bool);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(104, true, Boolean.valueOf(bool));
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "handleModProfileBranch emotionRec flag:" + bool);
      }
      return;
      if (ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get() == 0) {
        bool = true;
      }
    }
  }
  
  private void d(FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push 42344 = " + i);
      }
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.nameplateVipType = i;
        paramFriendsManager.a(paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.nameplateVipType = i;
        paramFriendsManager.a(localFriends);
      }
    }
  }
  
  private void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.iBigClubVipType = i;
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.bigClubInfo = (localFriends.bigClubInfo & 0xFFFFFF | (i & 0xFF) << 24);
        paramFriendsManager.a(localFriends);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club type change=" + i);
      }
      paramFriendsManager = ((TicketManager)paramOnLinePushMessageProcessor.a().getManager(2)).getSkey(paramLong + "");
      ((VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramFriendsManager, paramLong + "");
      return;
    }
  }
  
  private void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    SubMsgType0x27.FriendGroup localFriendGroup;
    long l;
    int j;
    if (paramForwardBody.msg_mod_friend_group.has())
    {
      paramForwardBody = ((SubMsgType0x27.ModFriendGroup)paramForwardBody.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramForwardBody != null)
      {
        paramForwardBody = paramForwardBody.iterator();
        while (paramForwardBody.hasNext())
        {
          localFriendGroup = (SubMsgType0x27.FriendGroup)paramForwardBody.next();
          if ((localFriendGroup.uint64_fuin.has()) && (localFriendGroup.rpt_uint32_new_group_id.get().size() > 0))
          {
            l = localFriendGroup.uint64_fuin.get();
            j = ((Integer)localFriendGroup.rpt_uint32_new_group_id.get(0)).intValue();
            if (localFriendGroup.rpt_uint32_old_group_id.get().size() <= 0) {
              break label280;
            }
          }
        }
      }
    }
    label280:
    for (int i = ((Integer)localFriendGroup.rpt_uint32_old_group_id.get(0)).intValue();; i = 0)
    {
      paramFriendsManager.a(l + "", j);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l + " newgroupid:" + j);
      }
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(9, true, new Object[] { l + "", Byte.valueOf((byte)j), Byte.valueOf((byte)i) });
      break;
      return;
    }
  }
  
  private void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_new_comein_user_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.NewComeinUserNotify)paramForwardBody.msg_new_comein_user_notify.get();
      if (!paramForwardBody.uint32_msg_type.has()) {
        break label135;
      }
    }
    label135:
    for (int i = paramForwardBody.uint32_msg_type.get();; i = -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + i);
      }
      if (i == 1)
      {
        paramOnLinePushMessageProcessor = (LBSHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
        if (paramOnLinePushMessageProcessor != null) {
          paramOnLinePushMessageProcessor.a(paramForwardBody);
        }
      }
      do
      {
        do
        {
          return;
        } while ((i != 2) && (i != 3));
        paramOnLinePushMessageProcessor = (NearFieldTroopHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
      } while (paramOnLinePushMessageProcessor == null);
      paramOnLinePushMessageProcessor.a(i, paramForwardBody);
      return;
    }
  }
  
  private void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramOnLinePushMessageProcessor = (ChatBackgroundManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
    if (paramOnLinePushMessageProcessor != null) {
      paramOnLinePushMessageProcessor.a(i, 0, null, "onlinePush", -1);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, " bg online push " + paramProfileInfo.uint32_field.get() + " bgId:" + i);
    }
  }
  
  private void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length == 1) {}
    for (int i = paramProfileInfo[0];; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, "push the big club level change=" + i);
      }
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
      if (paramProfileInfo != null)
      {
        paramProfileInfo.iBigClubVipLevel = i;
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      if (localFriends != null)
      {
        localFriends.bigClubInfo = (i & 0xFFFF | localFriends.bigClubInfo & 0xFFFF0000);
        paramFriendsManager.a(localFriends);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      paramFriendsManager = ((TicketManager)paramOnLinePushMessageProcessor.a().getManager(2)).getSkey(paramLong + "");
      ((VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramFriendsManager, paramLong + "");
      return;
    }
  }
  
  private void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_group_sort.has())
    {
      Object localObject = ((SubMsgType0x27.ModGroupSort)paramForwardBody.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
      if (localObject != null)
      {
        paramFriendsManager = new byte[((List)localObject).size()];
        paramForwardBody = new byte[((List)localObject).size()];
        localObject = ((List)localObject).iterator();
        int i = 0;
        if (((Iterator)localObject).hasNext())
        {
          SubMsgType0x27.GroupSort localGroupSort = (SubMsgType0x27.GroupSort)((Iterator)localObject).next();
          if ((!localGroupSort.uint32_groupid.has()) || (!localGroupSort.uint32_sortid.has())) {
            break label240;
          }
          paramFriendsManager[i] = ((byte)localGroupSort.uint32_groupid.get());
          paramForwardBody[i] = ((byte)localGroupSort.uint32_sortid.get());
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + localGroupSort.uint32_groupid.get() + " sortid:" + localGroupSort.uint32_sortid.get());
          }
          i += 1;
        }
      }
    }
    label240:
    for (;;)
    {
      break;
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(22, true, null);
      ((IFriendDataService)paramOnLinePushMessageProcessor.a().getRuntimeService(IFriendDataService.class, "")).updateGroupSortIds(paramFriendsManager, paramForwardBody);
      return;
    }
  }
  
  private void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.bytes_redpoint_info.has()) {
      ((LocalRedTouchManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER)).a(paramForwardBody.bytes_redpoint_info.get().toByteArray());
    }
  }
  
  private void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    boolean bool = ThemeUtil.isNowThemeIsSimple(paramOnLinePushMessageProcessor.a(), false, null);
    if ((!bool) && (DarkModeManager.a(String.valueOf(i)))) {
      if (!ThemeSwitcher.a(String.valueOf(i))) {
        ThemeSwitcher.a(String.valueOf(i), "209", null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "theme online push " + paramProfileInfo.uint32_field.get() + " themeId:" + i + " isSimpleMode：" + bool);
      }
      return;
      ThemeSwitchUtil.a(paramOnLinePushMessageProcessor.a(), String.valueOf(i), "20000000");
    }
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    boolean bool2 = false;
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramFriendsManager.a(paramLong + "");
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    if (paramProfileInfo != null) {
      if (i != 1) {
        break label194;
      }
    }
    label194:
    for (boolean bool1 = true;; bool1 = false)
    {
      paramProfileInfo.namePlateOfKingDanDisplatSwitch = bool1;
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      if (localFriends != null)
      {
        bool1 = bool2;
        if (i == 1) {
          bool1 = true;
        }
        localFriends.namePlateOfKingDanDisplatSwitch = bool1;
        paramFriendsManager.a(localFriends);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
      }
      QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + i + ", uin = " + paramLong);
      return;
    }
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    SubMsgType0x27.ModGroupName localModGroupName;
    int i;
    String str;
    if (paramForwardBody.msg_mod_group_name.has())
    {
      localModGroupName = (SubMsgType0x27.ModGroupName)paramForwardBody.msg_mod_group_name.get();
      if ((localModGroupName.uint32_groupid.has()) && (localModGroupName.bytes_groupname.has()))
      {
        i = localModGroupName.uint32_groupid.get();
        str = localModGroupName.bytes_groupname.get().toStringUtf8();
        paramForwardBody = paramFriendsManager.a(String.valueOf(i));
        if (paramForwardBody == null) {
          break label217;
        }
      }
    }
    for (paramForwardBody.group_name = str;; paramForwardBody.group_name = str)
    {
      paramFriendsManager.a(paramForwardBody);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupName  = id:" + localModGroupName.uint32_groupid.get() + " name:" + localModGroupName.bytes_groupname.get().toStringUtf8());
      }
      paramFriendsManager = new RenameGroupResp();
      paramFriendsManager.dwToUin = localModGroupName.uint32_groupid.get();
      paramFriendsManager.sGroupName = localModGroupName.bytes_groupname.get().toStringUtf8();
      paramFriendsManager = new GroupActionResp(0, "", paramFriendsManager);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(19, true, paramFriendsManager);
      return;
      label217:
      paramForwardBody = new Groups();
      paramForwardBody.group_id = i;
    }
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    Object localObject;
    long l1;
    if (paramForwardBody.msg_appointment_notify.has())
    {
      localObject = (SubMsgType0x27.AppointmentNotify)paramForwardBody.msg_appointment_notify.get();
      if (((SubMsgType0x27.AppointmentNotify)localObject).uint32_notifytype.has())
      {
        l1 = ((SubMsgType0x27.AppointmentNotify)localObject).uint32_notifytype.get();
        if ((l1 != 2L) && (l1 != 4L) && (l1 != 5L) && ((l1 != 6L) || (!((SubMsgType0x27.AppointmentNotify)localObject).bytes_feed_event_info.has()))) {
          break label99;
        }
        paramOnLinePushMessageProcessor.a().getNearbyProxy().a((SubMsgType0x27.AppointmentNotify)localObject);
      }
    }
    label99:
    while (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.has())) {
      return;
    }
    long l2 = ((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.get();
    String str1 = null;
    String str2 = paramOnLinePushMessageProcessor.a().getCurrentAccountUin();
    String str3 = Long.toString(l2);
    if (l1 == 0L) {}
    for (paramForwardBody = str2;; paramForwardBody = str3)
    {
      if (((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.has()) {
        str1 = ((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.get();
      }
      localObject = new ArrayList();
      MessageRecord localMessageRecord = MessageRecordFactory.a(-1024);
      l2 = MessageCache.a();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + str3 + ",senderUin=" + paramForwardBody + ",notifytype=" + l1);
      }
      localMessageRecord.init(str2, str3, paramForwardBody, str1, l2, -1024, 1010, l2);
      localMessageRecord.isread = false;
      if (l1 == 0L)
      {
        localMessageRecord.issend = 1;
        localMessageRecord.isread = true;
      }
      ((ArrayList)localObject).add(localMessageRecord);
      paramOnLinePushMessageProcessor.a().getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
      paramOnLinePushMessageProcessor.a("handleMsgType0x210SubMsgType0x27", true, (List)localObject, false, false);
      return;
      if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.has()))
      {
        paramForwardBody = ((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.get().toByteArray();
        paramOnLinePushMessageProcessor.a().getMsgCache().k(str3, paramForwardBody);
      }
    }
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    long l1 = 0L;
    int j;
    if (paramProfileInfo.length == 4)
    {
      j = ByteBuffer.wrap(new byte[] { paramProfileInfo[3] }).get();
      i = j;
      if (j == 1) {
        l1 = ByteBuffer.wrap(new byte[] { paramProfileInfo[2], paramProfileInfo[1] }).asShortBuffer().get() & 0xFFFF;
      }
    }
    for (int i = j;; i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get())
    {
      paramProfileInfo = OnlineStatusConstants.a(i);
      AppRuntime.Status localStatus = paramOnLinePushMessageProcessor.a().getOnlineStatus();
      long l2 = OnLineStatusHelper.a().a(paramOnLinePushMessageProcessor.a());
      if ((paramProfileInfo != localStatus) || (l2 != l1))
      {
        paramOnLinePushMessageProcessor.a().setOnlineStatus(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().setExtOnlineStatus(l1);
        Bundle localBundle = new Bundle();
        localBundle.putSerializable("onlineStatus", paramProfileInfo);
        localBundle.putLong("extOnlineStatus", l1);
        paramOnLinePushMessageProcessor.a().notifyObservers(AccountObserver.class, 2211, true, localBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("online new status push code: %s, newStatus: %s, curStatus: %s, ext:%s", new Object[] { Integer.valueOf(i), paramProfileInfo, localStatus, Long.valueOf(l1) }));
      }
      if ((paramProfileInfo == AppRuntime.Status.online) && (l1 == 1000L) && ((localStatus != paramProfileInfo) || (l1 != l2)))
      {
        paramOnLinePushMessageProcessor.a().checkBatteryStatus();
        paramOnLinePushMessageProcessor.a().updateOnlineStatus(paramProfileInfo, l1);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "udc reset battery status");
        }
      }
      return;
    }
  }
  
  private void h(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramFriendsManager.a(paramLong + "");
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingDan = i;
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingDan = i;
      paramFriendsManager.a(localFriends);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + i + ", uin = " + paramLong);
  }
  
  private void h(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_group.has())
    {
      paramForwardBody = (SubMsgType0x27.DelGroup)paramForwardBody.msg_del_group.get();
      if (paramForwardBody.uint32_groupid.has())
      {
        Groups localGroups = paramFriendsManager.a(paramForwardBody.uint32_groupid.get() + "");
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a DelGroup  = id:" + paramForwardBody.uint32_groupid.get());
        }
        paramFriendsManager = new DelGroupResp();
        paramFriendsManager.dwToUin = Long.valueOf(paramOnLinePushMessageProcessor.a().getAccount()).longValue();
        paramFriendsManager.dwSequence = localGroups.seqid;
        paramFriendsManager.cGroupid = ((byte)paramForwardBody.uint32_groupid.get());
        paramForwardBody = new GroupActionResp(0, "", paramFriendsManager);
        ((FriendListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).handleDelGroupResp(paramFriendsManager, true, paramForwardBody);
      }
    }
  }
  
  private void h(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramOnLinePushMessageProcessor = (BubbleManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);
    if (paramOnLinePushMessageProcessor != null)
    {
      paramOnLinePushMessageProcessor = paramOnLinePushMessageProcessor.a;
      if (i != 0) {
        break label101;
      }
    }
    label101:
    for (boolean bool = true;; bool = false)
    {
      paramOnLinePushMessageProcessor.a(bool);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", new Object[] { "" + i }));
      }
      return;
    }
  }
  
  private void i(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramFriendsManager.a(paramLong + "");
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingLoginTime = l;
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingLoginTime = l;
      paramFriendsManager.a(localFriends);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l + ", uin = " + paramLong);
  }
  
  private void i(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_add_group.has())
    {
      SubMsgType0x27.AddGroup localAddGroup = (SubMsgType0x27.AddGroup)paramForwardBody.msg_add_group.get();
      paramForwardBody = new Groups();
      if (localAddGroup.uint32_groupid.has()) {
        paramForwardBody.group_id = localAddGroup.uint32_groupid.get();
      }
      if (localAddGroup.bytes_groupname.has()) {
        paramForwardBody.group_name = localAddGroup.bytes_groupname.get().toStringUtf8();
      }
      if (localAddGroup.uint32_sortid.has()) {
        paramForwardBody.seqid = ((byte)localAddGroup.uint32_sortid.get());
      }
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramForwardBody.group_id + " name : " + paramForwardBody.group_name + " sortid: " + paramForwardBody.seqid);
      }
      paramFriendsManager.a(paramForwardBody);
      paramFriendsManager = new AddGroupResp();
      paramFriendsManager.dwToUin = Long.valueOf(paramOnLinePushMessageProcessor.a().getAccount()).longValue();
      paramFriendsManager.dwSequence = paramForwardBody.seqid;
      paramFriendsManager.cGroupId = ((byte)paramForwardBody.group_id);
      paramFriendsManager.cSortId = paramForwardBody.seqid;
      paramFriendsManager = new GroupActionResp(0, "", paramFriendsManager);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(18, true, paramFriendsManager);
    }
  }
  
  private void i(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 2;
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    SharedPreferences localSharedPreferences;
    if ((paramProfileInfo.byteAt(5) & 0x2) != 0)
    {
      localSharedPreferences = paramOnLinePushMessageProcessor.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if ((paramProfileInfo.byteAt(1) & 0x2) == 0) {
        break label116;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        localSharedPreferences.edit().putInt("message_roam_flag" + paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), i).apply();
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(101, true, Integer.valueOf(i));
      }
      return;
      label116:
      if (localSharedPreferences.getInt("message_roam_flag" + paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), -1) == 2) {
        i = 1;
      } else {
        i = -1;
      }
    }
  }
  
  private void j(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = paramFriendsManager.a(paramLong + "");
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.namePlateOfKingGameId = l;
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
    if (localFriends != null)
    {
      localFriends.namePlateOfKingGameId = l;
      paramFriendsManager.a(localFriends);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    }
    QLog.i("namePlateOfKing", 1, "handle push gameId = " + l + ", uin = " + paramLong);
  }
  
  private void j(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get(0);
    paramOnLinePushMessageProcessor.a(i);
    ((SVIPHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).notifyUI(101, true, Integer.valueOf(i));
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "bubble id = " + i);
    }
  }
  
  private void k(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    if (paramProfileInfo.colorRingId != i)
    {
      paramProfileInfo.colorRingId = i;
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramFriendsManager.a(paramProfileInfo);
      ColorRingManager.a(paramProfileInfo.uin, 1, paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + paramLong + ", id=" + paramProfileInfo.colorRingId);
    }
  }
  
  private void k(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int j = -1;
    int i;
    int k;
    if (paramProfileInfo.bytes_value.has())
    {
      paramProfileInfo = paramProfileInfo.bytes_value.get();
      i = paramProfileInfo.size();
      if (paramProfileInfo.size() > 0)
      {
        paramOnLinePushMessageProcessor = (CardHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        if (paramOnLinePushMessageProcessor != null)
        {
          k = paramProfileInfo.byteAt(0);
          if (k != 101) {
            paramOnLinePushMessageProcessor.d(k);
          }
          j = i;
          i = k;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "20014 push a ProfileInfo size = " + j + "  settingValue = " + i);
      }
      return;
      k = -1;
      j = i;
      i = k;
      continue;
      i = -1;
    }
  }
  
  private void l(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int j = 1;
    int k = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(String.valueOf(paramLong));
    int i = 0;
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
      paramProfileInfo.fontEffect = -1;
      i = 1;
    }
    if (paramProfileInfo.fontEffect != k)
    {
      paramProfileInfo.fontEffect = k;
      paramProfileInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      ((FontManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CHAT_FONT_MANAGER)).e();
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        paramFriendsManager.a(paramProfileInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + paramLong + ", fontEffect = " + k + ", updateTime = " + paramProfileInfo.fontEffectLastUpdateTime);
      }
      return;
    }
  }
  
  private void m(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
      paramProfileInfo.magicFont = -1;
    }
    if (paramProfileInfo.magicFont != i)
    {
      paramProfileInfo.magicFont = i;
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramFriendsManager.a(paramProfileInfo);
      VasUtils.a(paramOnLinePushMessageProcessor.a());
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + paramLong + ", magicFont = " + i);
    }
  }
  
  private void n(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asLongBuffer().get();
    ExtensionInfo localExtensionInfo = paramFriendsManager.a(String.valueOf(paramLong));
    paramProfileInfo = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
    }
    paramProfileInfo.pendantId = l;
    paramProfileInfo.timestamp = System.currentTimeMillis();
    paramFriendsManager.a(paramProfileInfo);
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + paramLong + ", id=" + paramProfileInfo.pendantId);
    }
    paramFriendsManager = new HashSet(1);
    paramFriendsManager.add(String.valueOf(paramLong));
    paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(66, true, paramFriendsManager);
  }
  
  private void o(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "svip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    String str = Long.toString(paramLong);
    Friends localFriends = paramFriendsManager.e(str);
    boolean bool;
    int j;
    if (localFriends != null)
    {
      localFriends = (Friends)localFriends.clone();
      if ((paramProfileInfo.byteAt(5) & 0x20) == 0) {
        break label250;
      }
      bool = true;
      j = localFriends.superVipInfo;
      if (!bool) {
        break label256;
      }
    }
    label256:
    for (int i = 1;; i = 0)
    {
      localFriends.superVipInfo = (i << 24 | 0xFFFFFF & j);
      paramFriendsManager.a(localFriends);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "isSVip=" + bool + "friend.superVipInfo=" + localFriends.superVipInfo);
      }
      if (paramOnLinePushMessageProcessor.a().getCurrentAccountUin().equals(str))
      {
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(100, true, null);
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
        }
        paramOnLinePushMessageProcessor = (EmoticonHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        paramOnLinePushMessageProcessor.a(0, 0);
        paramOnLinePushMessageProcessor.a(0, 0, 1, 0);
      }
      return;
      label250:
      bool = false;
      break;
    }
  }
  
  private void p(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "vip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    String str = Long.toString(paramLong);
    Friends localFriends = paramFriendsManager.e(str);
    boolean bool2;
    boolean bool3;
    boolean bool4;
    int n;
    byte b1;
    int k;
    int m;
    int j;
    if (localFriends != null)
    {
      localFriends = (Friends)localFriends.clone();
      boolean bool1 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
      bool2 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      bool3 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
      bool4 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB);
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "SVIP: " + bool1 + "; VIP: " + bool2 + "; SuperQQ: " + bool3);
      }
      n = 0;
      b1 = paramProfileInfo.byteAt(4);
      int i = paramProfileInfo.byteAt(5);
      if ((i & 0xF0) == 0) {
        break label382;
      }
      k = 16;
      m = 0;
      j = n;
      if (m < 4)
      {
        if ((i & k) == 0) {
          break label366;
        }
        j = 13 - m;
      }
      label228:
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(b1), Byte.valueOf(i), Integer.valueOf(j) }));
      }
      if (!bool1) {
        break label444;
      }
      localFriends.superVipInfo = (localFriends.superVipInfo & 0xFFFF0000 | 0xFFFF & j);
    }
    for (;;)
    {
      if (bool4) {
        localFriends.bigClubInfo = (j & 0xFFFF | localFriends.bigClubInfo & 0xFFFF0000);
      }
      paramFriendsManager.a(localFriends);
      if (paramOnLinePushMessageProcessor.a().getCurrentAccountUin().equals(str)) {
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER).notifyUI(100, true, null);
      }
      return;
      label366:
      m += 1;
      byte b2 = (byte)(k << 1);
      break;
      label382:
      if (b1 != 0)
      {
        b2 = 1;
        m = 0;
        for (;;)
        {
          j = n;
          if (m >= 8) {
            break;
          }
          if ((b1 & b2) != 0)
          {
            j = 9 - m;
            break;
          }
          m += 1;
          b2 = (byte)(b2 << 1);
        }
      }
      j = 1;
      break label228;
      label444:
      if (bool2) {
        localFriends.qqVipInfo = (localFriends.qqVipInfo & 0xFFFF0000 | 0xFFFF & j);
      } else if (bool3) {
        localFriends.superQqInfo = (localFriends.superQqInfo & 0xFFFF0000 | 0xFFFF & j);
      }
    }
  }
  
  private void q(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip", 2, "vip update uin=" + paramLong);
    }
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    int i;
    label165:
    boolean bool;
    if (localFriends != null)
    {
      localFriends = (Friends)localFriends.clone();
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramProfileInfo.byteAt(0)) }));
      }
      int j = localFriends.qqVipInfo;
      if ((paramProfileInfo.byteAt(0) & 0x80) != 0) {
        break label588;
      }
      i = 0;
      localFriends.qqVipInfo = (i << 24 | 0xFFFFFF & j);
      j = localFriends.superQqInfo;
      if ((paramProfileInfo.byteAt(0) & 0x8) != 0) {
        break label594;
      }
      i = 0;
      localFriends.superQqInfo = (i << 24 | 0xFFFFFF & j);
      if ((paramProfileInfo.byteAt(0) & 0x40) == 0) {
        break label600;
      }
      bool = true;
      label197:
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, "is year vip =" + bool);
      }
      if (!bool) {
        break label606;
      }
      i = 65536;
      label241:
      if (!localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
        break label612;
      }
      localFriends.superVipInfo = (localFriends.superVipInfo & 0xFF00FFFF | i);
    }
    for (;;)
    {
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_BIGCLUB)) {
        localFriends.bigClubInfo = (i | localFriends.bigClubInfo & 0xFF00FFFF);
      }
      if (QLog.isColorLevel()) {
        QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(localFriends.superVipInfo), Integer.valueOf(localFriends.qqVipInfo), Integer.valueOf(localFriends.superQqInfo) }));
      }
      paramFriendsManager.a(localFriends);
      ((SVIPHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).notifyUI(100, true, null);
      if (paramOnLinePushMessageProcessor.a().getCurrentAccountUin().equals(Long.toString(paramLong)))
      {
        paramFriendsManager = new Intent("tencent.video.q2v.SVIP.PAY");
        paramFriendsManager.putExtra("SVIPpaySuccess", true);
        paramFriendsManager.setPackage(MobileQQ.getContext().getPackageName());
        paramOnLinePushMessageProcessor.a().getApp().sendBroadcast(paramFriendsManager);
      }
      if (paramOnLinePushMessageProcessor.a().getCurrentAccountUin().equals(Long.toString(paramLong)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
        }
        paramFriendsManager = (EmoticonHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.HANDLER_EMOSM);
        paramFriendsManager.a(0, 0);
        paramFriendsManager.a(0, 0, 1, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QVipSettingMe.", 2, "[vipInfoPush] 23105 request vipInfoHandler");
        }
        QVipConfigManager.a(paramOnLinePushMessageProcessor.a(), "last_pull_pay_rule", 0L);
        paramFriendsManager = ((TicketManager)paramOnLinePushMessageProcessor.a().getManager(2)).getSkey(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
        ((VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(paramFriendsManager, paramLong + "");
      }
      return;
      label588:
      i = 1;
      break;
      label594:
      i = 1;
      break label165;
      label600:
      bool = false;
      break label197;
      label606:
      i = 0;
      break label241;
      label612:
      if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
        localFriends.qqVipInfo = (localFriends.qqVipInfo & 0xFF00FFFF | i);
      } else if (localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
        localFriends.superQqInfo = (localFriends.superQqInfo & 0xFF00FFFF | i);
      }
    }
  }
  
  private void r(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = 0;
    int j = paramProfileInfo.bytes_value.get().byteAt(0);
    if (j == 1) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModProfile Sex = " + i);
      }
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      if (paramProfileInfo != null)
      {
        paramProfileInfo.shGender = ((short)i);
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
      return;
      if (j == 2) {
        i = 1;
      } else if (j == 0) {
        i = 2;
      } else {
        i = j;
      }
    }
  }
  
  private void s(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    if ((paramProfileInfo != null) && (paramProfileInfo.size() == 2))
    {
      int i = paramProfileInfo.byteAt(0);
      i = (short)(paramProfileInfo.byteAt(1) | i << 8);
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModProfile Head = " + i);
      }
      ((IQQAvatarHandlerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(Long.toString(paramLong));
      paramProfileInfo = paramFriendsManager.a(paramLong + "");
      if (paramProfileInfo != null)
      {
        paramProfileInfo.nFaceID = i;
        paramFriendsManager.a(paramProfileInfo);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.AVATAR_HANDLER).notifyUI(1, true, new Object[] { paramLong + "", paramProfileInfo, null });
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
      }
    }
  }
  
  public MessageRecord a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, MsgType0x210 paramMsgType0x210, long paramLong, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    a(paramOnLinePushMessageProcessor, paramMsgType0x210.vProtobuf);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x27
 * JD-Core Version:    0.7.0.1
 */