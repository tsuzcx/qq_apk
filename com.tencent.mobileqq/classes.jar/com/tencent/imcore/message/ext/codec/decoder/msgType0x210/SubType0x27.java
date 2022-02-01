package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.common.app.AppInterface;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QQProfileItem;
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
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.profilecommon.api.IProfileCommonService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.tofumsg.TofuHelper;
import com.tencent.mobileqq.troop.api.ITroopNameHelperService;
import com.tencent.mobileqq.troop.api.observer.TroopCommonlyUsedObserver;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.showexternal.api.TroopShowExternalObserver;
import com.tencent.mobileqq.troop.util.api.ITroopDBUtilsApi;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager.Utils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.adapter.ThemeFontAdapter;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.mobileqq.vas.font.api.IFontManagerService;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.ThemeSwitchUtil;
import com.tencent.mobileqq.vas.theme.ThemeSwitcher;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
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
import mqq.app.AppRuntime;
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
  implements Msg0X210SubTypeDecoder<OnLinePushMessageProcessor>
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
    long l1 = paramProfileInfo.uVipFont;
    long l2 = i;
    if ((l1 != FontManagerConstants.parseFontId(l2)) || (paramProfileInfo.vipFontType != FontManagerConstants.parseFontType(l2)))
    {
      paramProfileInfo.uVipFont = FontManagerConstants.parseFontId(l2);
      paramProfileInfo.vipFontType = FontManagerConstants.parseFontType(l2);
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramFriendsManager.a(paramProfileInfo);
      VasUtils.a(paramOnLinePushMessageProcessor.a());
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("push, Get Font, uin=");
      paramOnLinePushMessageProcessor.append(paramLong);
      paramOnLinePushMessageProcessor.append(", id=");
      paramOnLinePushMessageProcessor.append(paramProfileInfo.uVipFont);
      paramOnLinePushMessageProcessor.append(", type = ");
      paramOnLinePushMessageProcessor.append(paramProfileInfo.vipFontType);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
    return (int)FontManagerConstants.parseFontId(l2);
  }
  
  private int a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, Friends[] paramArrayOfFriends, int paramInt, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    String str = paramProfileInfo.bytes_value.get().toStringUtf8();
    if (QLog.isColorLevel())
    {
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append("push a ModProfile Nick = ");
      paramProfileInfo.append(str);
      QLog.d("cardpush", 2, paramProfileInfo.toString());
    }
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    paramProfileInfo = null;
    if (localFriends != null) {
      paramProfileInfo = localFriends.name;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    paramArrayOfFriends[paramInt] = paramFriendsManager.a(localStringBuilder.toString(), str);
    if ((localFriends != null) && (localFriends.isFriend()) && (QQProfileItem.a(str, paramProfileInfo))) {
      QQProfileItem.a(paramLong, str, (DiscussionManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.DISCUSSION_MANAGER));
    }
    paramArrayOfFriends = new StringBuilder();
    paramArrayOfFriends.append(paramLong);
    paramArrayOfFriends.append("");
    paramArrayOfFriends = paramFriendsManager.a(paramArrayOfFriends.toString());
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
    paramForwardBody = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    int m;
    if (paramForwardBody.uint64_uin.has())
    {
      long l = paramForwardBody.uint64_uin.get();
      QQAppInterface localQQAppInterface = (QQAppInterface)paramOnLinePushMessageProcessor.a();
      IProfileCommonService localIProfileCommonService = (IProfileCommonService)localQQAppInterface.getRuntimeService(IProfileCommonService.class, "all");
      localIProfileCommonService.notifyProfileModifyPushBegin(l);
      Iterator localIterator = paramForwardBody.rpt_msg_profile_infos.get().iterator();
      int j = 0;
      int i = 0;
      int k = 0;
      for (;;)
      {
        Object localObject1 = paramOnLinePushMessageProcessor;
        paramForwardBody = this;
        if (!localIterator.hasNext()) {
          break;
        }
        Object localObject2 = (SubMsgType0x27.ProfileInfo)localIterator.next();
        if ((((SubMsgType0x27.ProfileInfo)localObject2).uint32_field.has()) && (((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.has()))
        {
          m = ((SubMsgType0x27.ProfileInfo)localObject2).uint32_field.get();
          ByteStringMicro localByteStringMicro = ((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.get();
          switch (m)
          {
          default: 
            localIProfileCommonService.notifyProcessProfileModifyPush(m, localByteStringMicro);
            break;
          case 45000: 
            paramForwardBody.h((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42393: 
            paramForwardBody.a((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42354: 
            paramForwardBody.c(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42344: 
            paramForwardBody.d(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42334: 
            b(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42324: 
            c(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42315: 
            paramForwardBody.d((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42287: 
            paramForwardBody.c((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42249: 
            d(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42241: 
            e(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42240: 
            f(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42224: 
          case 42226: 
          case 42227: 
          case 42228: 
          case 42368: 
          case 42370: 
          case 42375: 
          case 42378: 
            paramForwardBody.a((OnLinePushMessageProcessor)localObject1, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42122: 
            h(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42121: 
            g(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 42116: 
            paramForwardBody = (TicketManager)localQQAppInterface.getManager(2);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(l);
            ((StringBuilder)localObject1).append("");
            paramForwardBody = paramForwardBody.getSkey(((StringBuilder)localObject1).toString());
            localObject1 = (VipInfoHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(l);
            ((StringBuilder)localObject2).append("");
            ((VipInfoHandler)localObject1).a(paramForwardBody, ((StringBuilder)localObject2).toString());
            break;
          case 41812: 
            paramForwardBody.b(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 40530: 
            m(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27375: 
            a(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27373: 
            paramForwardBody.a((SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27372: 
            paramForwardBody.g((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27370: 
            paramForwardBody.b((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27263: 
            paramForwardBody.e((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27262: 
            paramForwardBody.f((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27254: 
            l(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27241: 
            j = ByteBuffer.wrap(((SubMsgType0x27.ProfileInfo)localObject2).bytes_value.get().toByteArray()).asIntBuffer().get();
            if (j != 0) {
              k = 1;
            }
            break;
          case 27238: 
            paramForwardBody.b((OnLinePushMessageProcessor)localObject1, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27235: 
            paramForwardBody.a(paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27225: 
            j(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27224: 
            i(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27201: 
            i = a(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27041: 
            k(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 27025: 
            n(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 23109: 
            paramForwardBody.c((OnLinePushMessageProcessor)localObject1, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 23104: 
            paramForwardBody.i((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 20059: 
            paramForwardBody.j((OnLinePushMessageProcessor)localObject1, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 20015: 
            p(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 20009: 
            o(paramOnLinePushMessageProcessor, paramFriendsManager, l, (SubMsgType0x27.ProfileInfo)localObject2);
            break;
          case 20002: 
            paramInt = a(paramOnLinePushMessageProcessor, paramFriendsManager, paramArrayOfFriends, paramInt, l, (SubMsgType0x27.ProfileInfo)localObject2);
          }
        }
      }
      localIProfileCommonService.notifyProfileModifyPushEnd();
      m = paramInt;
      if (k != 0)
      {
        if (QLog.isColorLevel())
        {
          paramForwardBody = new StringBuilder();
          paramForwardBody.append("Onlinepush hasDiyFontTimestamp: uin = ");
          paramForwardBody.append(l);
          paramForwardBody.append(" fontid = ");
          paramForwardBody.append(i);
          paramForwardBody.append(" timestamp = ");
          paramForwardBody.append(j);
          QLog.d("FontManagerConstants", 2, paramForwardBody.toString());
        }
        paramFriendsManager = paramFriendsManager.a(String.valueOf(l));
        paramForwardBody = paramFriendsManager;
        if (paramFriendsManager == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l);
        }
        if (i == 0) {
          i = (int)paramForwardBody.uVipFont;
        }
        ((IFontManagerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IFontManagerService.class, "")).checkUpdateDIYConfig(paramOnLinePushMessageProcessor.a(), String.valueOf(l), paramForwardBody, i, j);
        return paramInt;
      }
    }
    else
    {
      m = paramInt;
    }
    return m;
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    byte[] arrayOfByte = paramProfileInfo.bytes_value.get().toByteArray();
    int i = arrayOfByte.length;
    boolean bool = true;
    if (i == 1)
    {
      if (arrayOfByte[0] == 1) {}
    }
    else {
      while (ByteBuffer.wrap(arrayOfByte).asShortBuffer().get() != 1)
      {
        bool = false;
        break;
      }
    }
    ((TempMsgManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a((short)paramProfileInfo.uint32_field.get(), false, "", bool ^ true);
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("push temp msg block,uin=");
      paramOnLinePushMessageProcessor.append(paramLong);
      paramOnLinePushMessageProcessor.append(", id=");
      paramOnLinePushMessageProcessor.append(bool);
      paramOnLinePushMessageProcessor.append(" field=");
      paramOnLinePushMessageProcessor.append(paramProfileInfo.uint32_field.get());
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    ByteStringMicro localByteStringMicro = paramProfileInfo.bytes_value.get();
    paramProfileInfo = new Dialogue();
    try
    {
      paramProfileInfo.mergeFrom(localByteStringMicro.toByteArray());
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
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
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("vip_card_extension id by push=");
      paramOnLinePushMessageProcessor.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, IPublicAccountDataManager paramIPublicAccountDataManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_friend.has())
    {
      Object localObject1 = ((SubMsgType0x27.DelFriend)paramForwardBody.msg_del_friend.get()).rpt_uint64_uins.get();
      paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
      paramForwardBody = (QQStoryFeedManager)paramOnLinePushMessageProcessor.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER);
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        long l = ((Long)((Iterator)localObject1).next()).longValue();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("");
        paramFriendsManager.d(((StringBuilder)localObject2).toString());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("");
        paramIPublicAccountDataManager.delPublicAccountInfo(((StringBuilder)localObject2).toString());
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("push a DelFriend  = id:");
          ((StringBuilder)localObject2).append(l);
          QLog.d("cardpush", 2, ((StringBuilder)localObject2).toString());
        }
        try
        {
          localObject2 = (QidianManager)paramOnLinePushMessageProcessor.getManager(QQManagerFactory.QIDIAN_MANAGER);
          if (localObject2 != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(l);
            localStringBuilder.append("");
            if (((QidianManager)localObject2).a(localStringBuilder.toString()))
            {
              paramOnLinePushMessageProcessor.getProxyManager().a().a(String.valueOf(l), true);
              localObject2 = paramOnLinePushMessageProcessor.getApplication().getBaseContext();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramOnLinePushMessageProcessor.getCurrentAccountUin());
              localStringBuilder.append("_customer_transfer_sharepreference");
              localObject2 = ((Context)localObject2).getSharedPreferences(localStringBuilder.toString(), 0).edit();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(paramOnLinePushMessageProcessor.getCurrentAccountUin());
              localStringBuilder.append("_");
              localStringBuilder.append(l);
              localStringBuilder.append("");
              ((SharedPreferences.Editor)localObject2).putBoolean(localStringBuilder.toString(), false);
              ((SharedPreferences.Editor)localObject2).apply();
            }
          }
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("push a DelFriend  = id:");
            localStringBuilder.append(l);
            localStringBuilder.append(" error :");
            localStringBuilder.append(localException.toString());
            QLog.d("cardpush", 2, localStringBuilder.toString());
          }
        }
        paramOnLinePushMessageProcessor.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(15, true, Long.valueOf(l));
        String str = String.valueOf(l);
        paramForwardBody.a(str);
        IceBreakingUtil.a(paramOnLinePushMessageProcessor, str);
        TofuHelper.a(paramOnLinePushMessageProcessor, str);
      }
      paramOnLinePushMessageProcessor = (IPhoneContactService)paramOnLinePushMessageProcessor.getRuntimeService(IPhoneContactService.class, "");
      if (paramOnLinePushMessageProcessor != null) {
        paramOnLinePushMessageProcessor.onFriendListChanged();
      }
    }
  }
  
  private void a(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    boolean bool = paramForwardBody.msg_mod_friend_rings.has();
    int j = 0;
    Object localObject1 = Integer.valueOf(0);
    Object localObject2;
    Iterator localIterator;
    int i;
    Object localObject3;
    if (bool)
    {
      localObject2 = ((SubMsgType0x27.ModSnsGeneralInfo)paramForwardBody.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        paramOnLinePushMessageProcessor = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject2).next();
        localIterator = paramOnLinePushMessageProcessor.rpt_msg_sns_update_item.get().iterator();
        for (i = j;; i = 0)
        {
          j = i;
          if (!localIterator.hasNext()) {
            break;
          }
          Object localObject4 = (SubMsgType0x27.SnsUpdateItem)localIterator.next();
          j = ((SubMsgType0x27.SnsUpdateItem)localObject4).uint32_update_sns_type.get();
          Object localObject5;
          if ((j == 13569) && (paramOnLinePushMessageProcessor.uint32_result.get() == 0))
          {
            localObject3 = paramTroopManager.b(Long.toString(paramOnLinePushMessageProcessor.uint64_uin.get()));
            j = ((SubMsgType0x27.SnsUpdateItem)localObject4).bytes_value.get().size();
            if (QLog.isColorLevel())
            {
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("ONLine push commonTroop troopUin=");
              ((StringBuilder)localObject5).append((String)localObject3);
              ((StringBuilder)localObject5).append(" status=");
              ((StringBuilder)localObject5).append(j);
              QLog.d("Q.msg.BaseMessageProcessor", 4, ((StringBuilder)localObject5).toString());
            }
            if (j == 0)
            {
              if (paramTroopManager.b((String)localObject3))
              {
                localObject4 = localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_COMMONLY_USED_HANDLER);
                j = TroopCommonlyUsedObserver.a;
                localObject5 = new Object[4];
                localObject5[i] = localObject3;
                localObject5[1] = Integer.valueOf(1);
                localObject5[2] = localObject1;
                localObject5[3] = null;
                ((BusinessHandler)localObject4).notifyUI(j, true, localObject5);
              }
            }
            else if (j >= 4)
            {
              localObject4 = ((SubMsgType0x27.SnsUpdateItem)localObject4).bytes_value.get().toByteArray();
              localObject5 = new byte[4];
              System.arraycopy(localObject4, i, localObject5, i, 4);
              if (paramTroopManager.a((String)localObject3, MessageHandlerUtils.a((byte[])localObject5))) {
                localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_COMMONLY_USED_HANDLER).notifyUI(TroopCommonlyUsedObserver.a, true, new Object[] { localObject3, localObject1, localObject1, null });
              }
            }
          }
          else if (j == 13571)
          {
            localObject3 = String.valueOf(Long.valueOf(paramOnLinePushMessageProcessor.uint64_code.get()));
            i = ((SubMsgType0x27.SnsUpdateItem)localObject4).bytes_value.get().size();
            localObject4 = ((SubMsgType0x27.SnsUpdateItem)localObject4).bytes_value.get().toByteArray();
            if (i >= 6)
            {
              i = localObject4[1];
              if (i == 1)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                }
                localObject5 = new byte[4];
                System.arraycopy(localObject4, 2, localObject5, 0, 4);
                if (paramTroopManager.b((String)localObject3, MessageHandlerUtils.a((byte[])localObject5))) {
                  localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHOW_EXTERNAL_HANDLER).notifyUI(TroopShowExternalObserver.b, true, new Object[] { localObject3, Integer.valueOf(i), localObject1, Integer.valueOf(i) });
                }
              }
              if ((i == 0) && (paramTroopManager.d((String)localObject3))) {
                localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHOW_EXTERNAL_HANDLER).notifyUI(TroopShowExternalObserver.b, true, new Object[] { localObject3, Integer.valueOf(i), localObject1, Integer.valueOf(i) });
              }
            }
          }
        }
      }
    }
    if (paramForwardBody.msg_mod_friend_rings.has())
    {
      paramOnLinePushMessageProcessor = (SubMsgType0x27.ModSnsGeneralInfo)paramForwardBody.msg_mod_friend_rings.get();
      if ((paramOnLinePushMessageProcessor != null) && (paramOnLinePushMessageProcessor.rpt_msg_sns_general_infos.has()))
      {
        paramOnLinePushMessageProcessor = paramOnLinePushMessageProcessor.rpt_msg_sns_general_infos.get();
        paramForwardBody = new HashMap();
        localObject1 = paramOnLinePushMessageProcessor.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramOnLinePushMessageProcessor = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
          if ((paramOnLinePushMessageProcessor != null) && (paramOnLinePushMessageProcessor.uint64_uin.has()) && (paramOnLinePushMessageProcessor.rpt_msg_sns_update_item.has()))
          {
            long l = paramOnLinePushMessageProcessor.uint64_uin.get();
            localObject2 = String.valueOf(l);
            localIterator = paramOnLinePushMessageProcessor.rpt_msg_sns_update_item.get().iterator();
            while (localIterator.hasNext())
            {
              localObject3 = (SubMsgType0x27.SnsUpdateItem)localIterator.next();
              if ((localObject3 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject3).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject3).bytes_value.has()) && (!FriendsStatusUtil.a((SubMsgType0x27.SnsUpdateItem)localObject3, localQQAppInterface, (String)localObject2)))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject3).uint32_update_sns_type.get() == 13568) {
                  QvipSpecialCareUtil.a((String)localObject2, ((SubMsgType0x27.SnsUpdateItem)localObject3).bytes_value.get().toStringUtf8(), localQQAppInterface);
                }
                paramTroopManager = (SpecialCareInfo)paramForwardBody.get(localObject2);
                paramOnLinePushMessageProcessor = paramTroopManager;
                if (paramTroopManager == null)
                {
                  paramTroopManager = paramFriendsManager.a(String.valueOf(l));
                  paramOnLinePushMessageProcessor = paramTroopManager;
                  if (paramTroopManager == null)
                  {
                    paramOnLinePushMessageProcessor = new SpecialCareInfo();
                    paramOnLinePushMessageProcessor.uin = String.valueOf(l);
                  }
                  paramForwardBody.put(paramOnLinePushMessageProcessor.uin, paramOnLinePushMessageProcessor);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject3).uint32_update_sns_type.get();
                paramTroopManager = ((SubMsgType0x27.SnsUpdateItem)localObject3).bytes_value.get().toStringUtf8();
                FriendListHandler.initSpecialCareInfo(paramOnLinePushMessageProcessor, i, paramTroopManager);
                if (QLog.isColorLevel())
                {
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("handleMsgType0x210SubMsgType0x27 uin=");
                  ((StringBuilder)localObject3).append(paramOnLinePushMessageProcessor.uin);
                  ((StringBuilder)localObject3).append(", itemtype=");
                  ((StringBuilder)localObject3).append(i);
                  ((StringBuilder)localObject3).append(",itemVal=");
                  ((StringBuilder)localObject3).append(paramTroopManager);
                  QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject3).toString());
                }
              }
            }
          }
        }
        paramTroopManager = paramForwardBody.entrySet().iterator();
        paramOnLinePushMessageProcessor = new ArrayList();
        while (paramTroopManager.hasNext())
        {
          paramForwardBody = (SpecialCareInfo)((Map.Entry)paramTroopManager.next()).getValue();
          if ((paramForwardBody != null) && ((paramForwardBody.getStatus() != 1000) || (paramForwardBody.globalSwitch != 0))) {
            paramOnLinePushMessageProcessor.add(paramForwardBody);
          }
        }
        if (QLog.isColorLevel())
        {
          paramTroopManager = new StringBuilder();
          paramTroopManager.append("handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=");
          paramTroopManager.append(paramOnLinePushMessageProcessor.size());
          QLog.d("Q.msg.BaseMessageProcessor", 2, paramTroopManager.toString());
        }
        paramFriendsManager.c(paramOnLinePushMessageProcessor);
        if (paramOnLinePushMessageProcessor.size() > 0) {
          localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(97, true, new Object[] { Boolean.valueOf(true), paramOnLinePushMessageProcessor });
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
      Object localObject = paramFriendsManager.a(str);
      paramForwardBody = (SubMsgType0x27.ForwardBody)localObject;
      if (localObject == null)
      {
        paramForwardBody = new ExtensionInfo();
        paramForwardBody.uin = str;
      }
      ExtensionRichStatus.a(paramForwardBody, arrayOfByte, l);
      paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
      paramForwardBody.isAdded2C2C = SignatureManager.a(paramOnLinePushMessageProcessor, str, ExtensionRichStatus.a(paramForwardBody));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insertSignMsgIfNeeded from OnLinePush uin = ");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(" result =  ");
        ((StringBuilder)localObject).append(paramForwardBody.isAdded2C2C);
        QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      paramFriendsManager.a(paramForwardBody);
      paramForwardBody = new StringBuilder();
      paramForwardBody.append(localModLongNick.uint64_uin.get());
      paramForwardBody.append("");
      paramForwardBody = paramFriendsManager.a(paramForwardBody.toString());
      if (paramForwardBody != null)
      {
        paramForwardBody.vRichSign = arrayOfByte;
        paramForwardBody.lSignModifyTime = l;
        paramFriendsManager.a(paramForwardBody);
      }
      paramOnLinePushMessageProcessor.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, str);
      paramOnLinePushMessageProcessor.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(2, true, new String[] { str });
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
        paramForwardBody = (ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class);
        Object localObject2 = paramOnLinePushMessageProcessor.a();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(l2);
        ((StringBuilder)localObject3).append("");
        localObject3 = ((StringBuilder)localObject3).toString();
        Object localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(l3);
        ((StringBuilder)localObject4).append("");
        paramForwardBody = paramForwardBody.getTroopMemberCardInfo((AppRuntime)localObject2, (String)localObject3, ((StringBuilder)localObject4).toString());
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.has())) {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 1)
            {
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("push a ModGroupMemberProfile 1--Nick = ");
                ((StringBuilder)localObject3).append(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8());
                ((StringBuilder)localObject3).append(" info.bytes_value.get().size() = ");
                ((StringBuilder)localObject3).append(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
                QLog.d("cardpush", 2, ((StringBuilder)localObject3).toString());
              }
              QQProfileItem.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size());
              if (paramForwardBody != null)
              {
                paramForwardBody.colorNick = ColorNickManager.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get());
                paramForwardBody.name = ColorNickManager.b(paramForwardBody.colorNick);
                paramForwardBody.colorNickId = ColorNickManager.a(((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toByteArray());
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(l1);
                ((StringBuilder)localObject2).append("");
                localObject2 = ((StringBuilder)localObject2).toString();
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(l3);
                ((StringBuilder)localObject3).append("");
                paramTroopManager.a((String)localObject2, ((StringBuilder)localObject3).toString(), paramForwardBody.colorNick, -100, null, null, -100, -100, -100, -100L, -100L, paramForwardBody.colorNickId);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 2)
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().size() == 1)
              {
                byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().byteAt(0);
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("push a ModGroupMemberProfile 2--sex = ");
                  ((StringBuilder)localObject2).append(b);
                  QLog.d("cardpush", 2, ((StringBuilder)localObject2).toString());
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(l1);
                ((StringBuilder)localObject2).append("");
                localObject2 = ((StringBuilder)localObject2).toString();
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(l3);
                ((StringBuilder)localObject3).append("");
                paramTroopManager.a((String)localObject2, ((StringBuilder)localObject3).toString(), null, -100, null, null, -100, b, -100, -100L, -100L);
                if (paramForwardBody != null) {
                  paramForwardBody.sex = b;
                }
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 3)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("push a ModGroupMemberProfile 3--phone = ");
                ((StringBuilder)localObject3).append((String)localObject2);
                QLog.d("cardpush", 2, ((StringBuilder)localObject3).toString());
              }
              if (paramForwardBody != null) {
                paramForwardBody.tel = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 4)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("push a ModGroupMemberProfile 4--email= ");
                ((StringBuilder)localObject3).append((String)localObject2);
                QLog.d("cardpush", 2, ((StringBuilder)localObject3).toString());
              }
              if (paramForwardBody != null) {
                paramForwardBody.email = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 5)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("push a ModGroupMemberProfile 5--remark= ");
                ((StringBuilder)localObject3).append((String)localObject2);
                QLog.d("cardpush", 2, ((StringBuilder)localObject3).toString());
              }
              localObject3 = (TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER);
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(l1);
              ((StringBuilder)localObject4).append("");
              localObject4 = ((StringBuilder)localObject4).toString();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(l3);
              localStringBuilder.append("");
              ((TroopManager)localObject3).a((String)localObject4, localStringBuilder.toString(), null, -100, null, (String)localObject2, -100, -100, -100, -100L, -100L);
              if (paramForwardBody != null) {
                paramForwardBody.memo = ((String)localObject2);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject2).uint32_field.get() == 6)
            {
              localObject2 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject2).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("push a ModGroupMemberProfile 6--job= ");
                ((StringBuilder)localObject3).append((String)localObject2);
                QLog.d("cardpush", 2, ((StringBuilder)localObject3).toString());
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
          if (paramForwardBody != null)
          {
            ((ITroopDBUtilsApi)QRoute.api(ITroopDBUtilsApi.class)).saveTroopMemberCardInfo(paramOnLinePushMessageProcessor.a(), paramForwardBody);
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(paramForwardBody);
            paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER).notifyUI(TroopObserver.TYPE_MODIFY_TROOPMEMEBER_CARD_PUSH, true, localObject2);
            paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_CARD_HANDLER).notifyUI(TroopObserver.TYPE_GET_TROOPMEMEBER_CARD_LIST, true, new Object[] { localObject2, Boolean.valueOf(true) });
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
    try
    {
      Object localObject2 = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (FriendsManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject1 = (TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER);
      IPublicAccountDataManager localIPublicAccountDataManager = (IPublicAccountDataManager)paramOnLinePushMessageProcessor.a().getRuntimeService(IPublicAccountDataManager.class, "all");
      Object localObject3 = ((SubMsgType0x27.MsgBody)localObject2).rpt_msg_mod_infos.get();
      localObject2 = new Friends[((List)localObject3).size()];
      localObject3 = ((List)localObject3).iterator();
      int i = 0;
      while (((Iterator)localObject3).hasNext())
      {
        SubMsgType0x27.ForwardBody localForwardBody = (SubMsgType0x27.ForwardBody)((Iterator)localObject3).next();
        if (((!localForwardBody.uint32_notify_type.has()) || (localForwardBody.uint32_notify_type.get() != 1)) && (localForwardBody.uint32_op_type.has()))
        {
          int j = localForwardBody.uint32_op_type.get();
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2)
              {
                if (j != 3)
                {
                  if (j != 4)
                  {
                    if (j != 5)
                    {
                      if (j != 7)
                      {
                        if (j != 8)
                        {
                          if (j != 10)
                          {
                            if (j != 40)
                            {
                              if (j != 110)
                              {
                                if (j != 203)
                                {
                                  if (j != 205)
                                  {
                                    if (j != 214)
                                    {
                                      if ((j != 60) && (j != 61)) {
                                        if (j != 80)
                                        {
                                          if (j != 81)
                                          {
                                            if (j != 200)
                                            {
                                              if (j != 201) {
                                                switch (j)
                                                {
                                                default: 
                                                  switch (j)
                                                  {
                                                  default: 
                                                    break;
                                                  case 212: 
                                                    b(localForwardBody);
                                                    break;
                                                  case 211: 
                                                    a(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
                                                    break;
                                                  case 210: 
                                                    c(paramOnLinePushMessageProcessor, localForwardBody);
                                                  }
                                                  break;
                                                case 22: 
                                                  c(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
                                                  break;
                                                case 21: 
                                                  c(paramOnLinePushMessageProcessor, (TroopManager)localObject1, localForwardBody);
                                                  break;
                                                case 20: 
                                                  if (!localForwardBody.msg_mod_profile.has()) {
                                                    continue;
                                                  }
                                                  i = a(paramOnLinePushMessageProcessor, localForwardBody, paramArrayOfByte, (Friends[])localObject2, i);
                                                  break;
                                                }
                                              } else {
                                                a(paramOnLinePushMessageProcessor, localForwardBody);
                                              }
                                            }
                                            else {
                                              b(paramOnLinePushMessageProcessor, localForwardBody);
                                            }
                                          }
                                          else {
                                            a(paramOnLinePushMessageProcessor, (TroopManager)localObject1, localForwardBody);
                                          }
                                        }
                                        else {
                                          b(paramOnLinePushMessageProcessor, (TroopManager)localObject1, localForwardBody);
                                        }
                                      }
                                    }
                                    else {
                                      a(localForwardBody);
                                    }
                                  }
                                  else {
                                    d(paramOnLinePushMessageProcessor, localForwardBody);
                                  }
                                }
                                else {
                                  f(paramOnLinePushMessageProcessor, localForwardBody);
                                }
                              }
                              else {
                                g(paramOnLinePushMessageProcessor, localForwardBody);
                              }
                            }
                            else {
                              b(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
                            }
                          }
                          else {
                            e(paramOnLinePushMessageProcessor, localForwardBody);
                          }
                        }
                        else {
                          d(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
                        }
                      }
                      else {
                        a(paramOnLinePushMessageProcessor, paramArrayOfByte, (TroopManager)localObject1, localForwardBody);
                      }
                    }
                    else {
                      a(paramOnLinePushMessageProcessor, paramArrayOfByte, localIPublicAccountDataManager, localForwardBody);
                    }
                  }
                  else {
                    e(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
                  }
                }
                else {
                  f(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
                }
              }
              else {
                g(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
              }
            }
            else {
              h(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
            }
          }
          else {
            i(paramOnLinePushMessageProcessor, paramArrayOfByte, localForwardBody);
          }
        }
      }
      paramArrayOfByte.a((Friends[])localObject2, i);
      return;
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      QLog.e("MsgType0x210SubMsgType0x27", 1, "handleMsgType0x210SubMsgType0x27 decode fail.", paramOnLinePushMessageProcessor);
    }
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
    if (QLog.isColorLevel())
    {
      paramFriendsManager = new StringBuilder();
      paramFriendsManager.append("push, Get PendantDiyId, uin=");
      paramFriendsManager.append(paramLong);
      paramFriendsManager.append(", id=");
      paramFriendsManager.append(paramProfileInfo.pendantDiyId);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramFriendsManager.toString());
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
        return;
      }
    }
    catch (Exception paramForwardBody)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.FrdCustomOnlineStatusChange fail", paramForwardBody);
      }
    }
  }
  
  private void a(SubMsgType0x27.FriendRemark paramFriendRemark, OnLinePushMessageProcessor paramOnLinePushMessageProcessor)
  {
    if (paramFriendRemark.uint64_group_code.has())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("push a ModFriendRemark  : 1 troop troopcode = ");
        ((StringBuilder)localObject).append(paramFriendRemark.uint64_group_code.get());
        QLog.d("cardpush", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (TroopManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.TROOP_MANAGER);
      TroopInfo localTroopInfo = ((TroopManager)localObject).c(String.valueOf(paramFriendRemark.uint64_group_code.get()));
      localTroopInfo.troopRemark = paramFriendRemark.bytes_rmk_name.get().toStringUtf8();
      ((TroopManager)localObject).b(localTroopInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER).notifyUI(TroopObserver.TYPE_NOTIFY_UPDATE_RECENT_LIST, true, null);
    }
  }
  
  private void a(SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ThemeFontAdapter.b(i);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" theme font online push ");
      localStringBuilder.append(paramProfileInfo.uint32_field.get());
      localStringBuilder.append(" id:");
      localStringBuilder.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    ((VasExtensionManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(Long.toString(paramLong), i);
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("push, Get faceId, uin=");
      paramOnLinePushMessageProcessor.append(paramLong);
      paramOnLinePushMessageProcessor.append(", id=");
      paramOnLinePushMessageProcessor.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private void b(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    int j = paramProfileInfo.length;
    int i = 0;
    if (j == 1)
    {
      i = paramProfileInfo[0];
    }
    else if (paramProfileInfo.length == 2)
    {
      i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
    }
    else if (paramProfileInfo.length == 4)
    {
      i = ByteBuffer.wrap(paramProfileInfo).asIntBuffer().get();
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("rsp VASPROFILEGATE_SERVICE oidb FIELD_QQ_LEVEL_ICON_TYPE flag content error, len:");
      localStringBuilder.append(paramProfileInfo.length);
      QLog.e("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
    if ((paramProfileInfo != null) && (paramProfileInfo.mQQLevelType != i))
    {
      paramProfileInfo.mQQLevelType = i;
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
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
            Object localObject1 = paramFriendsManager.e(Long.toString(l));
            paramForwardBody = null;
            if (localObject1 != null) {
              paramForwardBody = ((Friends)localObject1).remark;
            }
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("push a ModFriendRemark  : 0 Friend uin = ");
              ((StringBuilder)localObject2).append(localFriendRemark.uint64_fuin.get());
              ((StringBuilder)localObject2).append("备注 = ");
              ((StringBuilder)localObject2).append(localFriendRemark.bytes_rmk_name.get().toStringUtf8());
              ((StringBuilder)localObject2).append(",oldRemark = ");
              ((StringBuilder)localObject2).append(paramForwardBody);
              QLog.d("cardpush", 2, ((StringBuilder)localObject2).toString());
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(localFriendRemark.uint64_fuin.get());
            ((StringBuilder)localObject2).append("");
            paramFriendsManager.b(((StringBuilder)localObject2).toString(), localFriendRemark.bytes_rmk_name.get().toStringUtf8());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(localFriendRemark.uint64_fuin.get());
            ((StringBuilder)localObject2).append("");
            localObject2 = paramFriendsManager.a(((StringBuilder)localObject2).toString());
            String str = localFriendRemark.bytes_rmk_name.get().toStringUtf8();
            if ((localObject2 != null) && (!str.equals(((Card)localObject2).strReMark)))
            {
              ((Card)localObject2).strReMark = str;
              paramFriendsManager.a((Card)localObject2);
            }
            if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (QQProfileItem.b(str, paramForwardBody))) {
              QQProfileItem.b(l, str, (DiscussionManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.DISCUSSION_MANAGER));
            }
            paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(localFriendRemark.uint64_fuin.get()));
            paramForwardBody = paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(localFriendRemark.uint64_fuin.get());
            ((StringBuilder)localObject1).append("");
            paramForwardBody.notifyUI(27, true, new Object[] { ((StringBuilder)localObject1).toString(), localFriendRemark.bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
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
    if (paramForwardBody.msg_mod_group_profile.has())
    {
      paramForwardBody = (SubMsgType0x27.ModGroupProfile)paramForwardBody.msg_mod_group_profile.get();
      if (paramForwardBody.uint64_group_code.has())
      {
        long l1 = paramForwardBody.uint64_group_uin.get();
        long l2 = paramForwardBody.uint64_group_code.get();
        try
        {
          paramForwardBody = paramForwardBody.rpt_msg_group_profile_infos.get().iterator();
          while (paramForwardBody.hasNext())
          {
            Object localObject1 = (SubMsgType0x27.GroupProfileInfo)paramForwardBody.next();
            if ((((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.has()) && (((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.has()))
            {
              int i = ((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get();
              Object localObject2;
              if (i == 1)
              {
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("push a ModGroupProfile 1--TroopName  = ");
                  ((StringBuilder)localObject2).append(((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get().toStringUtf8());
                  QLog.d("cardpush", 2, ((StringBuilder)localObject2).toString());
                }
              }
              else
              {
                i = ((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get();
                if (i == 2)
                {
                  localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get();
                  if ((localObject1 != null) && (((ByteStringMicro)localObject1).size() == 2))
                  {
                    i = ((ByteStringMicro)localObject1).byteAt(0);
                    short s = (short)(((ByteStringMicro)localObject1).byteAt(1) | i << 8);
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append(l1);
                    ((StringBuilder)localObject1).append("");
                    localObject1 = paramTroopManager.b(((StringBuilder)localObject1).toString());
                    ((TroopInfo)localObject1).troopface = s;
                    ((TroopInfo)localObject1).hasSetNewTroopHead = true;
                    if (QLog.isColorLevel())
                    {
                      localObject2 = new StringBuilder();
                      ((StringBuilder)localObject2).append("push a ModGroupProfile 2--TroopHead(2bytes) = ");
                      ((StringBuilder)localObject2).append(s);
                      QLog.d("cardpush", 2, ((StringBuilder)localObject2).toString());
                    }
                    paramTroopManager.b((TroopInfo)localObject1);
                    localObject1 = (IQQAvatarHandlerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IQQAvatarHandlerService.class, "");
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append(l1);
                    ((StringBuilder)localObject2).append("");
                    ((IQQAvatarHandlerService)localObject1).getTroopHead(((StringBuilder)localObject2).toString());
                  }
                }
                else if (((SubMsgType0x27.GroupProfileInfo)localObject1).uint32_field.get() == 3)
                {
                  localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject1).bytes_value.get().toStringUtf8();
                  boolean bool = QLog.isColorLevel();
                  if (bool)
                  {
                    localObject2 = new StringBuilder();
                    ((StringBuilder)localObject2).append("onLinePush, creditLevelChange:");
                    ((StringBuilder)localObject2).append(l1);
                    ((StringBuilder)localObject2).append(",");
                    ((StringBuilder)localObject2).append(l2);
                    ((StringBuilder)localObject2).append(",");
                    ((StringBuilder)localObject2).append((String)localObject1);
                    QLog.i("troop.credit.data", 2, ((StringBuilder)localObject2).toString());
                  }
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append(l2);
                  ((StringBuilder)localObject2).append("");
                  localObject2 = paramTroopManager.b(((StringBuilder)localObject2).toString());
                  if (localObject2 != null)
                  {
                    ((TroopInfo)localObject2).troopCreditLevel = Long.valueOf((String)localObject1).longValue();
                    paramTroopManager.b((TroopInfo)localObject2);
                    if (QLog.isColorLevel()) {
                      QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange, save");
                    }
                  }
                }
              }
            }
          }
          return;
        }
        catch (Exception paramOnLinePushMessageProcessor)
        {
          paramOnLinePushMessageProcessor.printStackTrace();
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
    MessageNotificationSettingManager.a((QQAppInterface)paramOnLinePushMessageProcessor.a()).b(i);
  }
  
  private void b(FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    int i;
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    } else {
      i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
    }
    paramProfileInfo = paramFriendsManager.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.cNewLoverDiamondFlag = i;
      paramFriendsManager.a(paramProfileInfo);
    }
  }
  
  private void b(SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      if ((SubMsgType0x27.ChatMatchInfo)paramForwardBody.msg_chat_match_info.get() != null)
      {
        QLog.d("Q.msg.BaseMessageProcessorExtendFriendLimitChat", 2, "SubMsgType0x27.ChatMatchInfo");
        return;
      }
    }
    catch (Exception paramForwardBody)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.ChatMatchInfo fail", paramForwardBody);
      }
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    if (((paramProfileInfo.byteAt(31) & 0x20) != 0) || ((paramProfileInfo.byteAt(34) & 0x10) != 0) || ((paramProfileInfo.byteAt(29) & 0x10) != 0))
    {
      Object localObject = paramOnLinePushMessageProcessor.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      int j = paramProfileInfo.byteAt(11);
      int i = 3;
      StringBuilder localStringBuilder;
      if (((j & 0x20) == 0) && ((paramProfileInfo.byteAt(14) & 0x10) == 0))
      {
        if ((paramProfileInfo.byteAt(9) & 0x10) == 0)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("message_roam_flag");
          localStringBuilder.append(paramOnLinePushMessageProcessor.getCurrentAccountUin());
          i = ((SharedPreferences)localObject).getInt(localStringBuilder.toString(), -1);
          if ((i != 4) && (i != 3)) {
            i = -1;
          } else {
            i = 1;
          }
        }
      }
      else {
        i = 4;
      }
      if (i != -1)
      {
        localObject = ((SharedPreferences)localObject).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("message_roam_flag");
        localStringBuilder.append(paramOnLinePushMessageProcessor.getCurrentAccountUin());
        ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), i).apply();
        paramOnLinePushMessageProcessor.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(99, true, Integer.valueOf(i));
      }
    }
    boolean bool;
    if ((paramProfileInfo.byteAt(12) & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).setSttAbility(paramOnLinePushMessageProcessor, bool);
    if ((paramProfileInfo.byteAt(13) & 0x40) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (SettingCloneUtil.readValue(paramOnLinePushMessageProcessor.getApplication(), Long.toString(paramLong), null, "qqsetting_pcactive_key", false) != bool)
    {
      SettingCloneUtil.writeValue(paramOnLinePushMessageProcessor.getApplication(), Long.valueOf(paramLong).toString(), null, "qqsetting_pcactive_key", bool);
      paramProfileInfo = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
      paramProfileInfo.putExtra("pcActive", bool);
      paramProfileInfo.putExtra("uin", Long.valueOf(paramLong).toString());
      paramOnLinePushMessageProcessor.getApp().sendBroadcast(paramProfileInfo);
      if (bool)
      {
        SettingCloneUtil.writeValue(paramOnLinePushMessageProcessor.getApplication(), Long.toString(paramLong), null, "pcactive_config", true);
        paramOnLinePushMessageProcessor.openMsfPCActive(Long.toString(paramLong), "config", true);
        QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
      }
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    int i;
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    } else {
      i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
    }
    if (QLog.isColorLevel())
    {
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append("push the big club iVipType change = ");
      paramProfileInfo.append(i);
      QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, paramProfileInfo.toString());
    }
    paramProfileInfo = paramFriendsManager.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      paramProfileInfo.bigClubInfo = ((i & 0xFF) << 16 | paramProfileInfo.bigClubInfo & 0xFF00FFFF);
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, Long.toString(paramLong));
    }
    paramFriendsManager = (TicketManager)paramOnLinePushMessageProcessor.a().getManager(2);
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramFriendsManager = paramFriendsManager.getSkey(paramProfileInfo.toString());
    paramOnLinePushMessageProcessor = (VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramOnLinePushMessageProcessor.a(paramFriendsManager, paramProfileInfo.toString());
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_daren_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.DaRenNotify)paramForwardBody.msg_daren_notify.get();
      long l1 = paramForwardBody.uint64_uin.get();
      int i = paramForwardBody.uint32_login_days.get();
      int j = paramForwardBody.uint32_days.get();
      if (paramOnLinePushMessageProcessor.a().getCurrentAccountUin().equals(String.valueOf(l1)))
      {
        paramForwardBody = paramFriendsManager.b(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
        long l2 = i;
        if ((l2 != paramForwardBody.lLoginDays) || (j != paramForwardBody.lQQMasterLogindays))
        {
          paramForwardBody.lLoginDays = l2;
          paramForwardBody.lQQMasterLogindays = j;
          paramFriendsManager.a(paramForwardBody);
          paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramForwardBody);
        }
        if (QLog.isColorLevel())
        {
          paramOnLinePushMessageProcessor = new StringBuilder();
          paramOnLinePushMessageProcessor.append("daren notify received local data logindays=");
          paramOnLinePushMessageProcessor.append(paramForwardBody.lLoginDays);
          paramOnLinePushMessageProcessor.append(";days=");
          paramOnLinePushMessageProcessor.append(paramForwardBody.lQQMasterLogindays);
          QLog.d("cardpush", 2, paramOnLinePushMessageProcessor.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramOnLinePushMessageProcessor = new StringBuilder();
        paramOnLinePushMessageProcessor.append("daren notify received uin=");
        paramOnLinePushMessageProcessor.append(l1);
        paramOnLinePushMessageProcessor.append(";logindays=");
        paramOnLinePushMessageProcessor.append(i);
        paramOnLinePushMessageProcessor.append(";days=");
        paramOnLinePushMessageProcessor.append(j);
        QLog.d("cardpush", 2, paramOnLinePushMessageProcessor.toString());
      }
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, TroopManager paramTroopManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_custom_face.has())
    {
      Object localObject = (SubMsgType0x27.ModCustomFace)paramForwardBody.msg_mod_custom_face.get();
      if ((((SubMsgType0x27.ModCustomFace)localObject).uint32_type.has()) && (((SubMsgType0x27.ModCustomFace)localObject).uint64_uin.has()))
      {
        paramForwardBody = (IQQAvatarHandlerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IQQAvatarHandlerService.class, "");
        long l;
        if (((SubMsgType0x27.ModCustomFace)localObject).uint32_type.get() == 0)
        {
          l = ((SubMsgType0x27.ModCustomFace)localObject).uint64_uin.get();
          paramTroopManager = Long.toString(l);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("push a ModCustomFace  :0  Normal user uin = ");
            ((StringBuilder)localObject).append(l);
            QLog.d("cardpush", 2, ((StringBuilder)localObject).toString());
          }
          paramForwardBody.getCustomHead(paramTroopManager);
          paramForwardBody.sendBroadCastHeadChanged(1, paramTroopManager);
          paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, paramTroopManager);
          return;
        }
        if (((SubMsgType0x27.ModCustomFace)localObject).uint32_type.get() == 1)
        {
          l = ((SubMsgType0x27.ModCustomFace)localObject).uint64_group_code.get();
          if (QLog.isColorLevel())
          {
            paramOnLinePushMessageProcessor = new StringBuilder();
            paramOnLinePushMessageProcessor.append("push a ModCustomFace  :1 Troop uin = ");
            paramOnLinePushMessageProcessor.append(l);
            QLog.d("cardpush", 2, paramOnLinePushMessageProcessor.toString());
          }
          paramOnLinePushMessageProcessor = paramTroopManager.b(String.valueOf(l));
          paramOnLinePushMessageProcessor.hasSetNewTroopHead = true;
          paramTroopManager.b(paramOnLinePushMessageProcessor);
          paramForwardBody.getTroopHead(Long.toString(l));
        }
      }
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    try
    {
      paramForwardBody = (SubMsgType0x27.MQQCampusNotify)paramForwardBody.msg_campus_notify.get();
      if (paramForwardBody != null)
      {
        ((CampusNoticeManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CAMPUS_NOTICE_MANAGER)).a(paramForwardBody);
        return;
      }
    }
    catch (Exception paramOnLinePushMessageProcessor)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", paramOnLinePushMessageProcessor);
      }
    }
  }
  
  private void c(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    if (paramProfileInfo.length > 1)
    {
      boolean bool1;
      if (paramProfileInfo[1] == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append("it have receive push value:");
      paramProfileInfo.append(bool1);
      QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, paramProfileInfo.toString());
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
      paramProfileInfo = paramOnLinePushMessageProcessor.a().getApp().getSharedPreferences("check_update_sp_key", 0);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_text_");
      ((StringBuilder)localObject1).append(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("businessinfo_ptt_auto_change_time_");
      ((StringBuilder)localObject2).append(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessinfo_ptt_auto_change_guide_has_show_");
      localStringBuilder.append(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
      paramOnLinePushMessageProcessor = localStringBuilder.toString();
      paramProfileInfo = paramProfileInfo.edit();
      paramProfileInfo.putBoolean((String)localObject1, bool2);
      long l = NetConnInfoCenter.getServerTime();
      if (bool2)
      {
        paramProfileInfo.putLong((String)localObject2, l);
        paramProfileInfo.putBoolean(paramOnLinePushMessageProcessor, true);
      }
      else
      {
        paramProfileInfo.putLong((String)localObject2, 9223372036854775807L);
      }
      paramProfileInfo.apply();
      com.tencent.mobileqq.activity.aio.item.PttConstants.c = bool2;
      com.tencent.mobileqq.activity.aio.item.PttConstants.a = l;
      return;
    }
    QLog.e("vip_ptt.Q.msg.BaseMessageProcessor", 1, "it have receive push value is null");
    paramProfileInfo = new ArrayList();
    paramProfileInfo.add(Short.valueOf((short)-23249));
    paramOnLinePushMessageProcessor = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(paramOnLinePushMessageProcessor.a(), TempGetProfileDetailProcessor.class);
    if (paramOnLinePushMessageProcessor != null) {
      paramOnLinePushMessageProcessor.getDetailCardInfo(paramProfileInfo, null);
    }
  }
  
  private void c(FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel())
      {
        paramProfileInfo = new StringBuilder();
        paramProfileInfo.append("push 42354 = ");
        paramProfileInfo.append(i);
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, paramProfileInfo.toString());
      }
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append(paramLong);
      paramProfileInfo.append("");
      paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
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
    int i;
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    } else {
      i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
    }
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    if (paramProfileInfo != null)
    {
      long l = i;
      paramProfileInfo.lBigClubTemplateId = l;
      paramProfileInfo.lSuperVipTemplateId = l;
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
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("FriendShield : onLinePush : uin : ");
            ((StringBuilder)localObject).append(l1);
            ((StringBuilder)localObject).append(" flag:");
            ((StringBuilder)localObject).append(i);
            ((StringBuilder)localObject).append(" id:");
            ((StringBuilder)localObject).append(l2);
            QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
          }
          if (l2 == 4051L)
          {
            localObject = paramFriendsManager.e(String.valueOf(l1));
            if (localObject != null)
            {
              boolean bool;
              if (i == 1) {
                bool = true;
              } else {
                bool = false;
              }
              ((Friends)localObject).setShieldFlag(bool);
              paramFriendsManager.a((Friends)localObject);
              paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(55, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
            }
          }
        }
      }
    }
  }
  
  private void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    paramForwardBody = (SubMsgType0x27.PraiseRankNotify)paramForwardBody.msg_praise_rank_notify.get();
    if (paramForwardBody.str_msg.has()) {
      paramForwardBody = paramForwardBody.str_msg.get();
    } else {
      paramForwardBody = null;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("praise rank notify: ");
      ((StringBuilder)localObject).append(paramForwardBody);
      QLog.d("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (!TextUtils.isEmpty(paramForwardBody))
    {
      localObject = BitmapManager.a(paramOnLinePushMessageProcessor.a().getApp().getResources(), 2130840405);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramOnLinePushMessageProcessor.a().getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
      Intent localIntent = new Intent(paramOnLinePushMessageProcessor.a().getApp(), LikeRankingListActivity.class);
      localIntent.putExtra("param_from", 1);
      localIntent.addFlags(67108864);
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramForwardBody });
      localToServiceMsg.extraData.putParcelable("intent", localIntent);
      localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject);
      paramOnLinePushMessageProcessor.a().sendToService(localToServiceMsg);
      ReportController.b(paramOnLinePushMessageProcessor.a(), "dc00898", "", "", "0X8007618", "0X8007618", 0, 0, "", "", "", "");
    }
  }
  
  private void d(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    int i = paramProfileInfo.length;
    boolean bool = false;
    if (i == 1)
    {
      if (paramProfileInfo[0] != 0) {}
    }
    else {
      while (ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get() == 0)
      {
        bool = true;
        break;
      }
    }
    paramOnLinePushMessageProcessor = (QQAppInterface)paramOnLinePushMessageProcessor.a();
    ((IStickerRecManager)paramOnLinePushMessageProcessor.getRuntimeService(IStickerRecManager.class)).updateEmotionRecSetting(bool);
    paramOnLinePushMessageProcessor.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(102, true, Boolean.valueOf(bool));
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("handleModProfileBranch emotionRec flag:");
      paramOnLinePushMessageProcessor.append(bool);
      QLog.i("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private void d(FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    if ((paramProfileInfo.uint32_field.has()) && (paramProfileInfo.bytes_value.has()))
    {
      int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
      if (QLog.isColorLevel())
      {
        paramProfileInfo = new StringBuilder();
        paramProfileInfo.append("push 42344 = ");
        paramProfileInfo.append(i);
        QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, paramProfileInfo.toString());
      }
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append(paramLong);
      paramProfileInfo.append("");
      paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
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
    int i;
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    } else {
      i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
    }
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
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
    if (QLog.isColorLevel())
    {
      paramFriendsManager = new StringBuilder();
      paramFriendsManager.append("push the big club type change=");
      paramFriendsManager.append(i);
      QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, paramFriendsManager.toString());
    }
    paramFriendsManager = (TicketManager)paramOnLinePushMessageProcessor.a().getManager(2);
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramFriendsManager = paramFriendsManager.getSkey(paramProfileInfo.toString());
    paramOnLinePushMessageProcessor = (VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramOnLinePushMessageProcessor.a(paramFriendsManager, paramProfileInfo.toString());
  }
  
  private void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_friend_group.has())
    {
      paramForwardBody = ((SubMsgType0x27.ModFriendGroup)paramForwardBody.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramForwardBody != null)
      {
        paramForwardBody = paramForwardBody.iterator();
        while (paramForwardBody.hasNext())
        {
          Object localObject = (SubMsgType0x27.FriendGroup)paramForwardBody.next();
          if ((((SubMsgType0x27.FriendGroup)localObject).uint64_fuin.has()) && (((SubMsgType0x27.FriendGroup)localObject).rpt_uint32_new_group_id.get().size() > 0))
          {
            long l = ((SubMsgType0x27.FriendGroup)localObject).uint64_fuin.get();
            int j = ((Integer)((SubMsgType0x27.FriendGroup)localObject).rpt_uint32_new_group_id.get(0)).intValue();
            int i;
            if (((SubMsgType0x27.FriendGroup)localObject).rpt_uint32_old_group_id.get().size() > 0) {
              i = ((Integer)((SubMsgType0x27.FriendGroup)localObject).rpt_uint32_old_group_id.get(0)).intValue();
            } else {
              i = 0;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(l);
            ((StringBuilder)localObject).append("");
            paramFriendsManager.a(((StringBuilder)localObject).toString(), j);
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("push a ModFriendGroup  = id:");
              ((StringBuilder)localObject).append(l);
              ((StringBuilder)localObject).append(" newgroupid:");
              ((StringBuilder)localObject).append(j);
              QLog.d("cardpush", 2, ((StringBuilder)localObject).toString());
            }
            localObject = paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(l);
            localStringBuilder.append("");
            ((BusinessHandler)localObject).notifyUI(9, true, new Object[] { localStringBuilder.toString(), Byte.valueOf((byte)j), Byte.valueOf((byte)i) });
          }
        }
      }
    }
  }
  
  private void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_new_comein_user_notify.has())
    {
      paramForwardBody = (SubMsgType0x27.NewComeinUserNotify)paramForwardBody.msg_new_comein_user_notify.get();
      int i = -1;
      if (paramForwardBody.uint32_msg_type.has()) {
        i = paramForwardBody.uint32_msg_type.get();
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("receive msg0x210submsg0x27 face2face add friend push, type:");
        localStringBuilder.append(i);
        QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
      }
      if (i == 1)
      {
        paramOnLinePushMessageProcessor = (LBSHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.LBS_HANDLER);
        if (paramOnLinePushMessageProcessor != null) {
          paramOnLinePushMessageProcessor.a(paramForwardBody);
        }
      }
      else if ((i == 2) || (i == 3))
      {
        paramOnLinePushMessageProcessor = (NearFieldTroopHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.NEARFIELD_TROOP_HANDLER);
        if (paramOnLinePushMessageProcessor != null) {
          paramOnLinePushMessageProcessor.a(i, paramForwardBody);
        }
      }
    }
  }
  
  private void e(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramOnLinePushMessageProcessor = (ChatBackgroundManager)paramOnLinePushMessageProcessor.a().getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER);
    if (paramOnLinePushMessageProcessor != null) {
      paramOnLinePushMessageProcessor.a(i, 0, null, "onlinePush", -1);
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append(" bg online push ");
      paramOnLinePushMessageProcessor.append(paramProfileInfo.uint32_field.get());
      paramOnLinePushMessageProcessor.append(" bgId:");
      paramOnLinePushMessageProcessor.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    int i;
    if (paramProfileInfo.length == 1) {
      i = paramProfileInfo[0];
    } else {
      i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
    }
    if (QLog.isColorLevel())
    {
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append("push the big club level change=");
      paramProfileInfo.append(i);
      QLog.d("QVipSettingMe.Q.msg.BaseMessageProcessor", 1, paramProfileInfo.toString());
    }
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
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
    paramFriendsManager = (TicketManager)paramOnLinePushMessageProcessor.a().getManager(2);
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramFriendsManager = paramFriendsManager.getSkey(paramProfileInfo.toString());
    paramOnLinePushMessageProcessor = (VipInfoHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER);
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramOnLinePushMessageProcessor.a(paramFriendsManager, paramProfileInfo.toString());
  }
  
  private void f(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_group_sort.has())
    {
      Object localObject = ((SubMsgType0x27.ModGroupSort)paramForwardBody.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
      if (localObject != null)
      {
        int i = 0;
        paramFriendsManager = new byte[((List)localObject).size()];
        paramForwardBody = new byte[((List)localObject).size()];
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          SubMsgType0x27.GroupSort localGroupSort = (SubMsgType0x27.GroupSort)((Iterator)localObject).next();
          if ((localGroupSort.uint32_groupid.has()) && (localGroupSort.uint32_sortid.has()))
          {
            paramFriendsManager[i] = ((byte)localGroupSort.uint32_groupid.get());
            paramForwardBody[i] = ((byte)localGroupSort.uint32_sortid.get());
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("push a ModGroupSort  = id:");
              localStringBuilder.append(localGroupSort.uint32_groupid.get());
              localStringBuilder.append(" sortid:");
              localStringBuilder.append(localGroupSort.uint32_sortid.get());
              QLog.d("cardpush", 2, localStringBuilder.toString());
            }
            i += 1;
          }
        }
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(22, true, null);
        ((IFriendDataService)((QQAppInterface)paramOnLinePushMessageProcessor.a()).getRuntimeService(IFriendDataService.class, "")).updateGroupSortIds(paramFriendsManager, paramForwardBody);
      }
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
    if ((!bool) && (DarkModeManager.a(String.valueOf(i))))
    {
      if (!ThemeSwitcher.a(String.valueOf(i))) {
        ThemeSwitcher.a(String.valueOf(i), "209", null);
      }
    }
    else {
      ThemeSwitchUtil.a(paramOnLinePushMessageProcessor.a(), String.valueOf(i), "20000000");
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("theme online push ");
      paramOnLinePushMessageProcessor.append(paramProfileInfo.uint32_field.get());
      paramOnLinePushMessageProcessor.append(" themeId:");
      paramOnLinePushMessageProcessor.append(i);
      paramOnLinePushMessageProcessor.append(" isSimpleMode：");
      paramOnLinePushMessageProcessor.append(bool);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
    Friends localFriends = paramFriendsManager.e(Long.toString(paramLong));
    boolean bool2 = false;
    boolean bool1;
    if (paramProfileInfo != null)
    {
      if (i == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramProfileInfo.namePlateOfKingDanDisplatSwitch = bool1;
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
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
    paramOnLinePushMessageProcessor = new StringBuilder();
    paramOnLinePushMessageProcessor.append("handle push namePlateOfKingDanDisplatSwitch = ");
    paramOnLinePushMessageProcessor.append(i);
    paramOnLinePushMessageProcessor.append(", uin = ");
    paramOnLinePushMessageProcessor.append(paramLong);
    QLog.i("namePlateOfKing", 1, paramOnLinePushMessageProcessor.toString());
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_mod_group_name.has())
    {
      SubMsgType0x27.ModGroupName localModGroupName = (SubMsgType0x27.ModGroupName)paramForwardBody.msg_mod_group_name.get();
      if ((localModGroupName.uint32_groupid.has()) && (localModGroupName.bytes_groupname.has()))
      {
        int i = localModGroupName.uint32_groupid.get();
        String str = localModGroupName.bytes_groupname.get().toStringUtf8();
        paramForwardBody = paramFriendsManager.a(String.valueOf(i));
        if (paramForwardBody != null)
        {
          paramForwardBody.group_name = str;
        }
        else
        {
          paramForwardBody = new Groups();
          paramForwardBody.group_id = i;
          paramForwardBody.group_name = str;
        }
        paramFriendsManager.a(paramForwardBody);
        if (QLog.isColorLevel())
        {
          paramFriendsManager = new StringBuilder();
          paramFriendsManager.append("push a ModGroupName  = id:");
          paramFriendsManager.append(localModGroupName.uint32_groupid.get());
          paramFriendsManager.append(" name:");
          paramFriendsManager.append(localModGroupName.bytes_groupname.get().toStringUtf8());
          QLog.d("cardpush", 2, paramFriendsManager.toString());
        }
        paramFriendsManager = new RenameGroupResp();
        paramFriendsManager.dwToUin = localModGroupName.uint32_groupid.get();
        paramFriendsManager.sGroupName = localModGroupName.bytes_groupname.get().toStringUtf8();
        paramFriendsManager = new GroupActionResp(0, "", paramFriendsManager);
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(19, true, paramFriendsManager);
      }
    }
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_appointment_notify.has())
    {
      Object localObject = (SubMsgType0x27.AppointmentNotify)paramForwardBody.msg_appointment_notify.get();
      if (((SubMsgType0x27.AppointmentNotify)localObject).uint32_notifytype.has())
      {
        long l1 = ((SubMsgType0x27.AppointmentNotify)localObject).uint32_notifytype.get();
        QQAppInterface localQQAppInterface = (QQAppInterface)paramOnLinePushMessageProcessor.a();
        if ((l1 != 2L) && (l1 != 4L) && (l1 != 5L) && ((l1 != 6L) || (!((SubMsgType0x27.AppointmentNotify)localObject).bytes_feed_event_info.has())))
        {
          if (((l1 == 0L) || (l1 == 1L) || (l1 == 3L)) && (((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.has()))
          {
            long l2 = ((SubMsgType0x27.AppointmentNotify)localObject).uint64_from_uin.get();
            String str1 = null;
            String str2 = localQQAppInterface.getCurrentAccountUin();
            String str3 = Long.toString(l2);
            if (l1 == 0L)
            {
              paramForwardBody = str2;
            }
            else
            {
              if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.has()))
              {
                paramForwardBody = ((SubMsgType0x27.AppointmentNotify)localObject).bytes_sig.get().toByteArray();
                localQQAppInterface.getMsgCache().k(str3, paramForwardBody);
              }
              paramForwardBody = str3;
            }
            if (((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.has()) {
              str1 = ((SubMsgType0x27.AppointmentNotify)localObject).str_tips_content.get();
            }
            localObject = new ArrayList();
            MessageRecord localMessageRecord = MessageRecordFactory.a(-1024);
            l2 = MessageCache.a();
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("handle date push friendUin=");
              localStringBuilder.append(str3);
              localStringBuilder.append(",senderUin=");
              localStringBuilder.append(paramForwardBody);
              localStringBuilder.append(",notifytype=");
              localStringBuilder.append(l1);
              QLog.d("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
            }
            localMessageRecord.init(str2, str3, paramForwardBody, str1, l2, -1024, 1010, l2);
            localMessageRecord.isread = false;
            if (l1 == 0L)
            {
              localMessageRecord.issend = 1;
              localMessageRecord.isread = true;
            }
            ((ArrayList)localObject).add(localMessageRecord);
            localQQAppInterface.getMessageFacade().a(localMessageRecord, localMessageRecord.selfuin);
            paramOnLinePushMessageProcessor.a("handleMsgType0x210SubMsgType0x27", true, (List)localObject, false, false);
          }
        }
        else {
          NearbyManagerHelper.a(localQQAppInterface).a(localObject);
        }
      }
    }
  }
  
  private void g(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get().toByteArray();
    int i = paramProfileInfo.length;
    long l1 = 0L;
    if (i == 4)
    {
      int j = ByteBuffer.wrap(new byte[] { paramProfileInfo[3] }).get();
      i = j;
      if (j == 1)
      {
        l1 = ByteBuffer.wrap(new byte[] { paramProfileInfo[2], paramProfileInfo[1] }).asShortBuffer().get() & 0xFFFF;
        i = j;
      }
    }
    else
    {
      i = ByteBuffer.wrap(paramProfileInfo).asShortBuffer().get();
    }
    paramProfileInfo = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusFromProfile(i);
    IOnlineStatusService localIOnlineStatusService = (IOnlineStatusService)paramOnLinePushMessageProcessor.a().getRuntimeService(IOnlineStatusService.class, "");
    AppRuntime.Status localStatus = localIOnlineStatusService.getOnlineStatus();
    long l2 = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getSelfExtOnlineStatus(paramOnLinePushMessageProcessor.a());
    if ((paramProfileInfo != localStatus) || (l2 != l1))
    {
      localIOnlineStatusService.setOnlineStatus(paramProfileInfo);
      localIOnlineStatusService.setExtOnlineStatus(l1);
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
      localIOnlineStatusService.checkBatteryStatus();
      localIOnlineStatusService.updateOnlineStatus(paramProfileInfo, l1);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessor", 2, "udc reset battery status");
      }
    }
  }
  
  private void h(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
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
    paramOnLinePushMessageProcessor = new StringBuilder();
    paramOnLinePushMessageProcessor.append("handle push namePlateOfKingDan = ");
    paramOnLinePushMessageProcessor.append(i);
    paramOnLinePushMessageProcessor.append(", uin = ");
    paramOnLinePushMessageProcessor.append(paramLong);
    QLog.i("namePlateOfKing", 1, paramOnLinePushMessageProcessor.toString());
  }
  
  private void h(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_del_group.has())
    {
      paramForwardBody = (SubMsgType0x27.DelGroup)paramForwardBody.msg_del_group.get();
      if (paramForwardBody.uint32_groupid.has())
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramForwardBody.uint32_groupid.get());
        ((StringBuilder)localObject).append("");
        paramFriendsManager = paramFriendsManager.a(((StringBuilder)localObject).toString());
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("push a DelGroup  = id:");
          ((StringBuilder)localObject).append(paramForwardBody.uint32_groupid.get());
          QLog.d("cardpush", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new DelGroupResp();
        ((DelGroupResp)localObject).dwToUin = Long.valueOf(paramOnLinePushMessageProcessor.a().getAccount()).longValue();
        ((DelGroupResp)localObject).dwSequence = paramFriendsManager.seqid;
        ((DelGroupResp)localObject).cGroupid = ((byte)paramForwardBody.uint32_groupid.get());
        paramFriendsManager = new GroupActionResp(0, "", (DelGroupResp)localObject);
        ((FriendListHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).handleDelGroupResp((DelGroupResp)localObject, true, paramFriendsManager);
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
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramOnLinePushMessageProcessor.a(bool);
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("");
      paramOnLinePushMessageProcessor.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, String.format("bubble unread feature push %s", new Object[] { paramOnLinePushMessageProcessor.toString() }));
    }
  }
  
  private void i(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
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
    paramOnLinePushMessageProcessor = new StringBuilder();
    paramOnLinePushMessageProcessor.append("handle push gameLoginTime = ");
    paramOnLinePushMessageProcessor.append(l);
    paramOnLinePushMessageProcessor.append(", uin = ");
    paramOnLinePushMessageProcessor.append(paramLong);
    QLog.i("namePlateOfKing", 1, paramOnLinePushMessageProcessor.toString());
  }
  
  private void i(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, SubMsgType0x27.ForwardBody paramForwardBody)
  {
    if (paramForwardBody.msg_add_group.has())
    {
      Object localObject = (SubMsgType0x27.AddGroup)paramForwardBody.msg_add_group.get();
      paramForwardBody = new Groups();
      if (((SubMsgType0x27.AddGroup)localObject).uint32_groupid.has()) {
        paramForwardBody.group_id = ((SubMsgType0x27.AddGroup)localObject).uint32_groupid.get();
      }
      if (((SubMsgType0x27.AddGroup)localObject).bytes_groupname.has()) {
        paramForwardBody.group_name = ((SubMsgType0x27.AddGroup)localObject).bytes_groupname.get().toStringUtf8();
      }
      if (((SubMsgType0x27.AddGroup)localObject).uint32_sortid.has()) {
        paramForwardBody.seqid = ((byte)((SubMsgType0x27.AddGroup)localObject).uint32_sortid.get());
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("push a AddGroup  = id:");
        ((StringBuilder)localObject).append(paramForwardBody.group_id);
        ((StringBuilder)localObject).append(" name : ");
        ((StringBuilder)localObject).append(paramForwardBody.group_name);
        ((StringBuilder)localObject).append(" sortid: ");
        ((StringBuilder)localObject).append(paramForwardBody.seqid);
        QLog.d("cardpush", 2, ((StringBuilder)localObject).toString());
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
    Object localObject = paramProfileInfo.bytes_value.get();
    int j = ((ByteStringMicro)localObject).byteAt(5);
    int i = 2;
    if ((j & 0x2) != 0)
    {
      paramProfileInfo = paramOnLinePushMessageProcessor.a().getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
      if ((((ByteStringMicro)localObject).byteAt(1) & 0x2) == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("message_roam_flag");
        ((StringBuilder)localObject).append(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
        if (paramProfileInfo.getInt(((StringBuilder)localObject).toString(), -1) == 2) {
          i = 1;
        } else {
          i = -1;
        }
      }
      if (i != -1)
      {
        paramProfileInfo = paramProfileInfo.edit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("message_roam_flag");
        ((StringBuilder)localObject).append(paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
        paramProfileInfo.putInt(((StringBuilder)localObject).toString(), i).apply();
        paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(99, true, Integer.valueOf(i));
      }
    }
  }
  
  private void j(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    long l = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get();
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
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
    paramOnLinePushMessageProcessor = new StringBuilder();
    paramOnLinePushMessageProcessor.append("handle push gameId = ");
    paramOnLinePushMessageProcessor.append(l);
    paramOnLinePushMessageProcessor.append(", uin = ");
    paramOnLinePushMessageProcessor.append(paramLong);
    QLog.i("namePlateOfKing", 1, paramOnLinePushMessageProcessor.toString());
  }
  
  private void j(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int i = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asIntBuffer().get(0);
    paramOnLinePushMessageProcessor.a(i);
    ((ISVIPHandler)paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).notifyUI(101, true, Integer.valueOf(i));
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("bubble id = ");
      paramOnLinePushMessageProcessor.append(i);
      QLog.d("vip", 2, paramOnLinePushMessageProcessor.toString());
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
    long l1 = paramProfileInfo.colorRingId;
    long l2 = i;
    if (l1 != l2)
    {
      paramProfileInfo.colorRingId = l2;
      paramProfileInfo.timestamp = System.currentTimeMillis();
      paramFriendsManager.a(paramProfileInfo);
      ColorRingManager.a(paramProfileInfo.uin, 1, paramOnLinePushMessageProcessor.a().getCurrentAccountUin());
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("push, Get ColorRing, uin=");
      paramOnLinePushMessageProcessor.append(paramLong);
      paramOnLinePushMessageProcessor.append(", id=");
      paramOnLinePushMessageProcessor.append(paramProfileInfo.colorRingId);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
    }
  }
  
  private void l(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int k = ByteBuffer.wrap(paramProfileInfo.bytes_value.get().toByteArray()).asShortBuffer().get();
    paramProfileInfo = paramFriendsManager.a(String.valueOf(paramLong));
    int j = 1;
    int i;
    if (paramProfileInfo == null)
    {
      paramProfileInfo = new ExtensionInfo();
      paramProfileInfo.uin = String.valueOf(paramLong);
      paramProfileInfo.fontEffect = -1;
      i = 1;
    }
    else
    {
      i = 0;
    }
    if (paramProfileInfo.fontEffect != k)
    {
      paramProfileInfo.fontEffect = k;
      paramProfileInfo.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      ((IFontManagerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IFontManagerService.class, "")).resetLastSendReportTime();
      i = j;
    }
    if (i != 0) {
      paramFriendsManager.a(paramProfileInfo);
    }
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("push Get fontEffect uin = ");
      paramOnLinePushMessageProcessor.append(paramLong);
      paramOnLinePushMessageProcessor.append(", fontEffect = ");
      paramOnLinePushMessageProcessor.append(k);
      paramOnLinePushMessageProcessor.append(", updateTime = ");
      paramOnLinePushMessageProcessor.append(paramProfileInfo.fontEffectLastUpdateTime);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
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
    if (QLog.isColorLevel())
    {
      paramOnLinePushMessageProcessor = new StringBuilder();
      paramOnLinePushMessageProcessor.append("push Get MagicFont uin = ");
      paramOnLinePushMessageProcessor.append(paramLong);
      paramOnLinePushMessageProcessor.append(", magicFont = ");
      paramOnLinePushMessageProcessor.append(i);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramOnLinePushMessageProcessor.toString());
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
    if (QLog.isColorLevel())
    {
      paramFriendsManager = new StringBuilder();
      paramFriendsManager.append("push, Get Pendant, uin=");
      paramFriendsManager.append(paramLong);
      paramFriendsManager.append(", id=");
      paramFriendsManager.append(paramProfileInfo.pendantId);
      QLog.d("Q.msg.BaseMessageProcessor", 2, paramFriendsManager.toString());
    }
    paramFriendsManager = new HashSet(1);
    paramFriendsManager.add(String.valueOf(paramLong));
    paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(65, true, paramFriendsManager);
  }
  
  private void o(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    int j = paramProfileInfo.bytes_value.get().byteAt(0);
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
    if (QLog.isColorLevel())
    {
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append("push a ModProfile Sex = ");
      paramProfileInfo.append(i);
      QLog.d("cardpush", 2, paramProfileInfo.toString());
    }
    paramProfileInfo = new StringBuilder();
    paramProfileInfo.append(paramLong);
    paramProfileInfo.append("");
    paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
    if (paramProfileInfo != null)
    {
      paramProfileInfo.shGender = ((short)i);
      paramFriendsManager.a(paramProfileInfo);
      paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER).notifyUI(1, true, paramProfileInfo);
    }
  }
  
  private void p(OnLinePushMessageProcessor paramOnLinePushMessageProcessor, FriendsManager paramFriendsManager, long paramLong, SubMsgType0x27.ProfileInfo paramProfileInfo)
  {
    paramProfileInfo = paramProfileInfo.bytes_value.get();
    if ((paramProfileInfo != null) && (paramProfileInfo.size() == 2))
    {
      int i = paramProfileInfo.byteAt(0);
      i = (short)(paramProfileInfo.byteAt(1) | i << 8);
      if (QLog.isColorLevel())
      {
        paramProfileInfo = new StringBuilder();
        paramProfileInfo.append("push a ModProfile Head = ");
        paramProfileInfo.append(i);
        QLog.d("cardpush", 2, paramProfileInfo.toString());
      }
      ((IQQAvatarHandlerService)paramOnLinePushMessageProcessor.a().getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(Long.toString(paramLong));
      paramProfileInfo = new StringBuilder();
      paramProfileInfo.append(paramLong);
      paramProfileInfo.append("");
      paramProfileInfo = paramFriendsManager.a(paramProfileInfo.toString());
      if (paramProfileInfo != null)
      {
        paramProfileInfo.nFaceID = i;
        paramFriendsManager.a(paramProfileInfo);
        paramFriendsManager = paramOnLinePushMessageProcessor.a().getBusinessHandler(BusinessHandlerFactory.AVATAR_HANDLER);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramLong);
        localStringBuilder.append("");
        paramFriendsManager.notifyUI(1, true, new Object[] { localStringBuilder.toString(), paramProfileInfo, null });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x27
 * JD-Core Version:    0.7.0.1
 */