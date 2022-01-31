package com.tencent.mobileqq.app.message;

import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.MsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import QQService.EVIPSPEC;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.etrump.mixlayout.FontManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.qqstory.base.QQStoryFeedManager;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.LikeRankingListActivity;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.view.ApolloGameHotChatController;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatHandler;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.HotChatRecentUserMgr;
import com.tencent.mobileqq.app.LBSHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.NearFieldTroopHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQProfileItem;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.campuscircle.CampusNoticeManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForNearbyLiveTip;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.managers.PullActiveManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcall.PstnCardInfo;
import com.tencent.mobileqq.qcall.PstnHandler;
import com.tencent.mobileqq.qcall.PstnManager;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.SttManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.systemmsg.FriendSystemMsgController;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.ColorRingManager;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import cooperation.troop.NearbyVideoProxyBroadcastReceiver;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.EAddFriendSourceID;
import friendlist.RenameGroupResp;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import localpb.richMsg.SafeMsg.SafeMoreInfo;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AddGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.AppointmentNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DaRenNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelFriend;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.DelGroup;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody;
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
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.QQPayPush;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpateBuffer;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateItem;
import tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.SnsUpdateOneFlag;
import tencent.im.s2c.msgtype0x210.submsgtype0x31.submsgtype0x31.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ClearCountMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.FriendSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.GroupSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.ModifySyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.WaitingSyncMsg;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x83.SubMsgType0x83.MsgParams;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xb3.SubMsgType0xb3.PushAddFrdNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.Medal;
import tencent.im.s2c.msgtype0x210.submsgtype0xbe.SubMsgType0xbe.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.HotFriendNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xcb.SubMsgType0xcb.MsgBody;
import ztr;
import zts;

public class OnLinePushMessageProcessor
  extends BaseMessageProcessor
{
  public OnLinePushMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
  }
  
  private int a(SubMsgType0x27.ForwardBody paramForwardBody, FriendsManager paramFriendsManager, TroopManager paramTroopManager, PstnManager paramPstnManager, ApolloManager paramApolloManager, Friends[] paramArrayOfFriends, int paramInt)
  {
    paramForwardBody = (SubMsgType0x27.ModProfile)paramForwardBody.msg_mod_profile.get();
    int n = paramInt;
    if (paramForwardBody.uint64_uin.has())
    {
      long l1 = paramForwardBody.uint64_uin.get();
      Iterator localIterator = paramForwardBody.rpt_msg_profile_infos.get().iterator();
      n = 0;
      int k = 0;
      int m = 0;
      int i1 = paramInt;
      paramInt = n;
      if (localIterator.hasNext())
      {
        paramForwardBody = (SubMsgType0x27.ProfileInfo)localIterator.next();
        n = k;
        if (paramForwardBody.uint32_field.has())
        {
          n = k;
          if (paramForwardBody.bytes_value.has()) {
            switch (paramForwardBody.uint32_field.get())
            {
            }
          }
        }
        for (;;)
        {
          n = k;
          if (QLog.isColorLevel())
          {
            QLog.d("cardpush", 2, "push a unknow field Uint32Field = " + paramForwardBody.uint32_field.get());
            n = k;
          }
          label489:
          int i2 = m;
          k = n;
          m = paramInt;
          paramInt = i2;
          for (;;)
          {
            label505:
            n = m;
            m = paramInt;
            paramInt = n;
            break;
            paramTroopManager = paramForwardBody.bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModProfile Nick = " + paramTroopManager);
            }
            Friends localFriends = paramFriendsManager.c(Long.toString(l1));
            paramForwardBody = null;
            if (localFriends != null) {
              paramForwardBody = localFriends.name;
            }
            paramArrayOfFriends[i1] = paramFriendsManager.a(l1 + "", paramTroopManager);
            if ((localFriends != null) && (localFriends.isFriend()) && (QQProfileItem.a(paramTroopManager, paramForwardBody))) {
              QQProfileItem.a(l1, paramTroopManager, (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
            }
            paramForwardBody = paramFriendsManager.a(l1 + "");
            if (paramForwardBody != null)
            {
              paramForwardBody.strNick = paramTroopManager;
              paramFriendsManager.a(paramForwardBody);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
            }
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
            TroopNameHelper.b(Long.toString(l1));
            i1 += 1;
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            paramForwardBody = paramForwardBody.bytes_value.get();
            if ((paramForwardBody != null) && (paramForwardBody.size() == 2))
            {
              n = paramForwardBody.byteAt(0);
              n = (short)(paramForwardBody.byteAt(1) | n << 8);
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModProfile Head = " + n);
              }
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c(Long.toString(l1));
              paramForwardBody = paramFriendsManager.a(l1 + "");
              if (paramForwardBody != null)
              {
                paramForwardBody.nFaceID = n;
                paramFriendsManager.a(paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(4, true, new Object[] { l1 + "", paramForwardBody, null });
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
              }
            }
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            i2 = paramForwardBody.bytes_value.get().byteAt(0);
            if (i2 == 1) {
              n = 0;
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModProfile Sex = " + n);
              }
              paramForwardBody = paramFriendsManager.a(l1 + "");
              if (paramForwardBody != null)
              {
                paramForwardBody.shGender = ((short)n);
                paramFriendsManager.a(paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
              }
              n = paramInt;
              paramInt = m;
              m = n;
              break;
              if (i2 == 2)
              {
                n = 1;
              }
              else
              {
                n = i2;
                if (i2 == 0) {
                  n = 2;
                }
              }
            }
            i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get(0);
            a(i2);
            ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(101, true, Integer.valueOf(i2));
            n = k;
            if (!QLog.isColorLevel()) {
              break label489;
            }
            QLog.d("vip", 2, "bubble id = " + i2);
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("vip", 2, "vip update uin=" + l1);
            }
            paramForwardBody = paramForwardBody.bytes_value.get();
            paramTroopManager = paramFriendsManager.c(Long.toString(l1));
            n = k;
            if (paramTroopManager == null) {
              break label489;
            }
            paramTroopManager = (Friends)paramTroopManager.clone();
            if (QLog.isColorLevel()) {
              QLog.d("vip", 2, String.format("bit info = %02X", new Object[] { Byte.valueOf(paramForwardBody.byteAt(0)) }));
            }
            i2 = paramTroopManager.qqVipInfo;
            if ((paramForwardBody.byteAt(0) & 0x80) == 0)
            {
              n = 0;
              label1343:
              paramTroopManager.qqVipInfo = (n << 24 | 0xFFFFFF & i2);
              i2 = paramTroopManager.superQqInfo;
              if ((paramForwardBody.byteAt(0) & 0x8) != 0) {
                break label1633;
              }
              n = 0;
              label1379:
              paramTroopManager.superQqInfo = (n << 24 | 0xFFFFFF & i2);
              if ((paramForwardBody.byteAt(0) & 0x40) == 0) {
                break label1639;
              }
              bool1 = true;
              label1409:
              if (QLog.isColorLevel()) {
                QLog.d("vip", 2, "is year vip =" + bool1);
              }
              if (!bool1) {
                break label1645;
              }
              n = 65536;
              label1452:
              if (!paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP)) {
                break label1651;
              }
              paramTroopManager.superVipInfo = (n | paramTroopManager.superVipInfo & 0xFF00FFFF);
            }
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("vip", 2, String.format("SVIP = %08X, VIP = %08X, SuperQQ = %08X", new Object[] { Integer.valueOf(paramTroopManager.superVipInfo), Integer.valueOf(paramTroopManager.qqVipInfo), Integer.valueOf(paramTroopManager.superQqInfo) }));
              }
              paramFriendsManager.a(paramTroopManager);
              ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(100, true, null);
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(Long.toString(l1)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "[EmoticonUpdateAuth] 23105 updateEmoticonAuth");
                }
                paramForwardBody = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
                paramForwardBody.a(0, 0);
                paramForwardBody.a(0, 0, 1);
              }
              n = paramInt;
              paramInt = m;
              m = n;
              break;
              n = 1;
              break label1343;
              label1633:
              n = 1;
              break label1379;
              label1639:
              bool1 = false;
              break label1409;
              label1645:
              n = 0;
              break label1452;
              label1651:
              if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_QQVIP)) {
                paramTroopManager.qqVipInfo = (n | paramTroopManager.qqVipInfo & 0xFF00FFFF);
              } else if (paramTroopManager.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ)) {
                paramTroopManager.superQqInfo = (n | paramTroopManager.superQqInfo & 0xFF00FFFF);
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("vip", 2, "vip update uin=" + l1);
            }
            paramForwardBody = paramForwardBody.bytes_value.get();
            paramTroopManager = Long.toString(l1);
            localFriends = paramFriendsManager.c(paramTroopManager);
            n = k;
            if (localFriends == null) {
              break label489;
            }
            localFriends = (Friends)localFriends.clone();
            boolean bool1 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP);
            boolean bool2 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
            boolean bool3 = localFriends.isServiceEnabled(EVIPSPEC.E_SP_SUPERQQ);
            if (QLog.isColorLevel()) {
              QLog.d("vip", 2, "SVIP: " + bool1 + "; VIP: " + bool2 + "; SuperQQ: " + bool3);
            }
            int i4 = 0;
            int i = paramForwardBody.byteAt(4);
            int j = paramForwardBody.byteAt(5);
            if ((j & 0xF0) != 0)
            {
              i2 = 16;
              i3 = 0;
              label1897:
              n = i4;
              if (i3 < 4)
              {
                if ((j & i2) != 0) {
                  n = 13 - i3;
                }
              }
              else
              {
                label1922:
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, String.format("[%02X%02X] => LV %d", new Object[] { Byte.valueOf(i), Byte.valueOf(j), Integer.valueOf(n) }));
                }
                if (!bool1) {
                  break label2126;
                }
                localFriends.superVipInfo = (n & 0xFFFF | localFriends.superVipInfo & 0xFFFF0000);
              }
            }
            for (;;)
            {
              paramFriendsManager.a(localFriends);
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopManager)) {
                ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(100, true, null);
              }
              n = paramInt;
              paramInt = m;
              m = n;
              break;
              i3 += 1;
              i2 = (byte)(i2 << 1);
              break label1897;
              if (i != 0)
              {
                i2 = 1;
                i3 = 0;
                for (;;)
                {
                  n = i4;
                  if (i3 >= 8) {
                    break;
                  }
                  if ((i & i2) != 0)
                  {
                    n = 9 - i3;
                    break;
                  }
                  i3 += 1;
                  i2 = (byte)(i2 << 1);
                }
              }
              n = 1;
              break label1922;
              label2126:
              if (bool2) {
                localFriends.qqVipInfo = (n & 0xFFFF | localFriends.qqVipInfo & 0xFFFF0000);
              } else if (bool3) {
                localFriends.superQqInfo = (n & 0xFFFF | localFriends.superQqInfo & 0xFFFF0000);
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("vip", 2, "svip update uin=" + l1);
            }
            paramForwardBody = paramForwardBody.bytes_value.get();
            paramTroopManager = Long.toString(l1);
            localFriends = paramFriendsManager.c(paramTroopManager);
            n = k;
            if (localFriends == null) {
              break label489;
            }
            localFriends = (Friends)localFriends.clone();
            if ((paramForwardBody.byteAt(5) & 0x20) != 0)
            {
              bool1 = true;
              label2271:
              i2 = localFriends.superVipInfo;
              if (!bool1) {
                break label2451;
              }
            }
            label2451:
            for (n = 1;; n = 0)
            {
              localFriends.superVipInfo = (n << 24 | 0xFFFFFF & i2);
              paramFriendsManager.a(localFriends);
              if (QLog.isColorLevel()) {
                QLog.d("vip", 2, "isSVip=" + bool1 + "friend.superVipInfo=" + localFriends.superVipInfo);
              }
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramTroopManager))
              {
                ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(100, true, null);
                if (QLog.isColorLevel()) {
                  QLog.d("vip", 2, "[EmoticonUpdateAuth] 23107 updateEmoticonAuth");
                }
                paramForwardBody = (EmoticonHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12);
                paramForwardBody.a(0, 0);
                paramForwardBody.a(0, 0, 1);
              }
              n = paramInt;
              paramInt = m;
              m = n;
              break;
              bool1 = false;
              break label2271;
            }
            paramForwardBody = paramForwardBody.bytes_value.get();
            n = k;
            if ((paramForwardBody.byteAt(5) & 0x2) == 0) {
              break label489;
            }
            paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
            if ((paramForwardBody.byteAt(1) & 0x2) != 0) {
              n = 2;
            }
            for (;;)
            {
              if (n != -1)
              {
                paramTroopManager.edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), n).commit();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(101, true, Integer.valueOf(n));
              }
              n = paramInt;
              paramInt = m;
              m = n;
              break;
              if (paramTroopManager.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1) == 2) {
                n = 1;
              } else {
                n = -1;
              }
            }
            paramForwardBody = paramForwardBody.bytes_value.get();
            if (((paramForwardBody.byteAt(31) & 0x20) != 0) || ((paramForwardBody.byteAt(34) & 0x10) != 0) || ((paramForwardBody.byteAt(29) & 0x10) != 0))
            {
              paramTroopManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("vip_message_roam_banner_file", 0);
              if (((paramForwardBody.byteAt(11) & 0x20) == 0) && ((paramForwardBody.byteAt(14) & 0x10) == 0)) {
                break label3004;
              }
              n = 4;
              label2727:
              if (n != -1)
              {
                paramTroopManager.edit().putInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), n).commit();
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(101, true, Integer.valueOf(n));
              }
            }
            if ((paramForwardBody.byteAt(12) & 0x8) != 0)
            {
              bool1 = true;
              label2812:
              SttManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool1);
              if ((paramForwardBody.byteAt(13) & 0x40) == 0) {
                break label3087;
              }
            }
            label3087:
            for (bool1 = true;; bool1 = false)
            {
              n = k;
              if (SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l1), null, "qqsetting_pcactive_key", false) == bool1) {
                break;
              }
              SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.valueOf(l1).toString(), null, "qqsetting_pcactive_key", bool1);
              paramForwardBody = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
              paramForwardBody.putExtra("pcActive", bool1);
              paramForwardBody.putExtra("uin", Long.valueOf(l1).toString());
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramForwardBody);
              if (bool1)
              {
                SettingCloneUtil.writeValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), Long.toString(l1), null, "pcactive_config", true);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.openMsfPCActive(Long.toString(l1), "config", true);
                QLog.d("OnlinePush", 1, "PCActive opened: true by switch push");
              }
              n = paramInt;
              paramInt = m;
              m = n;
              break label505;
              label3004:
              if ((paramForwardBody.byteAt(9) & 0x10) != 0)
              {
                n = 3;
                break label2727;
              }
              n = paramTroopManager.getInt("message_roam_flag" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1);
              if ((n == 4) || (n == 3))
              {
                n = 1;
                break label2727;
              }
              n = -1;
              break label2727;
              bool1 = false;
              break label2812;
            }
            long l2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asLongBuffer().get();
            paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
            paramForwardBody = paramTroopManager;
            if (paramTroopManager == null)
            {
              paramForwardBody = new ExtensionInfo();
              paramForwardBody.uin = String.valueOf(l1);
            }
            paramForwardBody.pendantId = l2;
            paramForwardBody.timestamp = System.currentTimeMillis();
            paramFriendsManager.a(paramForwardBody);
            n = k;
            if (!QLog.isColorLevel()) {
              break label489;
            }
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Pendant, uin=" + l1 + ", id=" + paramForwardBody.pendantId);
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            paramInt = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
            paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
            paramForwardBody = paramTroopManager;
            if (paramTroopManager == null)
            {
              paramForwardBody = new ExtensionInfo();
              paramForwardBody.uin = String.valueOf(l1);
            }
            if ((paramForwardBody.uVipFont != FontManager.a(paramInt)) || (paramForwardBody.vipFontType != FontManager.b(paramInt)))
            {
              paramForwardBody.uVipFont = FontManager.a(paramInt);
              paramForwardBody.vipFontType = FontManager.b(paramInt);
              paramForwardBody.timestamp = System.currentTimeMillis();
              paramFriendsManager.a(paramForwardBody);
              VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get Font, uin=" + l1 + ", id=" + paramForwardBody.uVipFont + ", type = " + paramForwardBody.vipFontType);
            }
            n = (int)FontManager.a(paramInt);
            paramInt = m;
            m = n;
            continue;
            i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
            paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
            paramForwardBody = paramTroopManager;
            if (paramTroopManager == null)
            {
              paramForwardBody = new ExtensionInfo();
              paramForwardBody.uin = String.valueOf(l1);
              paramForwardBody.magicFont = -1;
            }
            if (paramForwardBody.magicFont != i2)
            {
              paramForwardBody.magicFont = i2;
              paramForwardBody.timestamp = System.currentTimeMillis();
              paramFriendsManager.a(paramForwardBody);
              VasUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            n = k;
            if (!QLog.isColorLevel()) {
              break label489;
            }
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get MagicFont uin = " + l1 + ", magicFont = " + i2);
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
            paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
            n = 0;
            paramForwardBody = paramTroopManager;
            if (paramTroopManager == null)
            {
              paramForwardBody = new ExtensionInfo();
              paramForwardBody.uin = String.valueOf(l1);
              paramForwardBody.fontEffect = -1;
              n = 1;
            }
            if (paramForwardBody.fontEffect != i2)
            {
              paramForwardBody.fontEffect = i2;
              paramForwardBody.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
              ((FontManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41)).c();
              n = 1;
            }
            if (n != 0) {
              paramFriendsManager.a(paramForwardBody);
            }
            n = k;
            if (!QLog.isColorLevel()) {
              break label489;
            }
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push Get fontEffect uin = " + l1 + ", fontEffect = " + i2 + ", updateTime = " + paramForwardBody.fontEffectLastUpdateTime);
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            k = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
            n = k;
            if (k == 0) {
              break label489;
            }
            n = 1;
            m = paramInt;
            paramInt = n;
            continue;
            n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
            paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
            paramForwardBody = paramTroopManager;
            if (paramTroopManager == null)
            {
              paramForwardBody = new ExtensionInfo();
              paramForwardBody.uin = String.valueOf(l1);
            }
            if (paramForwardBody.colorRingId != n)
            {
              paramForwardBody.colorRingId = n;
              paramForwardBody.timestamp = System.currentTimeMillis();
              paramFriendsManager.a(paramForwardBody);
              ColorRingManager.a(paramForwardBody.uin, 1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            n = k;
            if (!QLog.isColorLevel()) {
              break label489;
            }
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get ColorRing, uin=" + l1 + ", id=" + paramForwardBody.colorRingId);
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            paramTroopManager = paramForwardBody.bytes_value.get();
            int i3 = paramForwardBody.uint32_field.get();
            if ((i3 >= 42005) && (i3 <= 42012))
            {
              i2 = ByteBuffer.wrap(paramTroopManager.toByteArray()).asShortBuffer().get();
              label4037:
              paramForwardBody = paramPstnManager.a(String.valueOf(l1));
              n = k;
              if (paramForwardBody == null) {
                break label489;
              }
              n = k;
              if (i2 == -1) {
                break label489;
              }
              if (i3 != 420005) {
                break label4250;
              }
              paramForwardBody.pstn_c2c_vip = i2;
            }
            for (;;)
            {
              if (paramForwardBody.pstn_ever_c2c_vip != 0) {
                paramForwardBody.pstn_c2c_try_status = 1;
              }
              if (paramForwardBody.pstn_ever_multi_vip != 0) {
                paramForwardBody.pstn_multi_try_status = 1;
              }
              paramPstnManager.a(paramForwardBody);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(82).a(60000, true, paramForwardBody);
              paramTroopManager = new Intent("tencent.video.q2v.pstnCardInfoChanged");
              paramTroopManager.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName());
              paramTroopManager.putExtra("pstnCardInfo", paramForwardBody);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(paramTroopManager);
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a pstn attr Uint32Field = " + i3 + ",bit = " + i2);
              }
              n = paramInt;
              paramInt = m;
              m = n;
              break;
              i2 = ByteBuffer.wrap(paramTroopManager.toByteArray()).asIntBuffer().get();
              break label4037;
              label4250:
              if (i3 == 42006) {
                paramForwardBody.pstn_multi_vip = i2;
              } else if (i3 == 42007) {
                paramForwardBody.pstn_ever_c2c_vip = i2;
              } else if (i3 == 42008) {
                paramForwardBody.pstn_ever_multi_vip = i2;
              } else if (i3 == 42011) {
                paramForwardBody.pstn_multi_try_status = i2;
              } else if (i3 == 42012) {
                paramForwardBody.pstn_c2c_try_status = i2;
              } else if (i3 == 26012) {
                paramForwardBody.pstn_multi_call_time = i2;
              } else if (i3 == 26013) {
                paramForwardBody.pstn_multi_last_guide_recharge_time = i2;
              } else if (i3 == 26014) {
                paramForwardBody.pstn_c2c_call_time = i2;
              } else if (i3 == 26015) {
                paramForwardBody.pstn_c2c_last_guide_recharge_time = i2;
              }
            }
            i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
            paramForwardBody = paramApolloManager.b(String.valueOf(l1));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l1 + ", avip flag: " + i2);
            }
            n = k;
            if (paramForwardBody.apolloVipFlag == i2) {
              break label489;
            }
            paramForwardBody.apolloVipFlag = i2;
            paramApolloManager.a(paramForwardBody);
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
            paramForwardBody = paramApolloManager.b(String.valueOf(l1));
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + l1 + ", avip level: " + i2);
            }
            n = k;
            if (paramForwardBody.apolloVipLevel == i2) {
              break label489;
            }
            paramForwardBody.apolloVipLevel = i2;
            paramApolloManager.a(paramForwardBody);
            n = paramInt;
            paramInt = m;
            m = n;
            continue;
            n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
            paramForwardBody = paramApolloManager.b(String.valueOf(l1));
            if ((QLog.isColorLevel()) || (l1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())) {
              QLog.d("Q.msg.BaseMessageProcessor", 1, "apollo push uin: " + l1 + ", apollo status: " + n);
            }
            if (paramForwardBody.apolloStatus != n)
            {
              paramForwardBody.apolloStatus = n;
              paramApolloManager.a(paramForwardBody);
              if ((l1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) && (1 == n) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
              {
                paramForwardBody = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
                if (paramForwardBody != null) {
                  paramForwardBody.a("statusChange");
                }
              }
            }
            paramTroopManager = String.valueOf(l1);
            if (l1 == this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin())
            {
              paramForwardBody = new Pair(paramTroopManager, Integer.valueOf(n));
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71).a(3, true, paramForwardBody);
              n = paramInt;
              paramInt = m;
              m = n;
            }
            else
            {
              paramForwardBody = new ArrayList();
              paramForwardBody.add(paramTroopManager);
              paramTroopManager = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (paramTroopManager != null) {
                paramTroopManager.a(n, paramForwardBody);
              }
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              i2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              paramForwardBody = String.valueOf(l1);
              paramTroopManager = paramApolloManager.b(paramForwardBody);
              if ((!TextUtils.isEmpty(paramForwardBody)) && (paramForwardBody.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
                ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(new long[] { l1 });
              }
              n = k;
              if (paramTroopManager.apolloServerTS == i2) {
                break label489;
              }
              paramTroopManager.apolloServerTS = i2;
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "apollo push uin: " + new StringBuilder().append(l1).append("temp").toString().substring(0, 4) + ", timeStamp: " + i2);
              }
              paramApolloManager.a(paramTroopManager);
              paramTroopManager = new ArrayList();
              paramTroopManager.add(paramForwardBody);
              paramForwardBody = SpriteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              if (paramForwardBody != null) {
                paramForwardBody.a(3, paramTroopManager);
              }
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              n = k;
              if (l1 != this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()) {
                break label489;
              }
              n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
              if (n != ApolloManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))
              {
                paramForwardBody = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
                paramForwardBody.b(n);
                if (n == 1)
                {
                  paramForwardBody = paramForwardBody.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                  if ((paramForwardBody.apolloStatus == 1) && (paramForwardBody.apolloLocalTS != paramForwardBody.apolloServerTS))
                  {
                    paramForwardBody = (VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
                    if (paramForwardBody != null) {
                      paramForwardBody.a("whiteList");
                    }
                  }
                }
              }
              QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push white list: " + n);
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              l2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              paramForwardBody = paramApolloManager.b(String.valueOf(l1));
              long l3 = NetConnInfoCenter.getServerTime();
              if ((l2 > l3) && (paramForwardBody.apolloSignValidTS != l2))
              {
                paramForwardBody.apolloLocalSignTs = paramForwardBody.apolloSignValidTS;
                paramForwardBody.apolloSignValidTS = l2;
                paramForwardBody.apolloSignStr = "";
                paramApolloManager.a(paramForwardBody);
              }
              QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo push sign uin: " + l1 + ", valid TS: " + l2 + ", currTS: " + l3);
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              if (paramApolloManager != null)
              {
                paramForwardBody = paramApolloManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
                if ((paramForwardBody != null) && (n != paramForwardBody.apolloAISwitch))
                {
                  paramForwardBody.apolloAISwitch = n;
                  if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (String.valueOf(l1).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
                    ApolloManager.c(n);
                  }
                  paramApolloManager.a(paramForwardBody);
                }
                paramApolloManager.d(n);
              }
              QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo aiSwitch  push: " + n);
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              l2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              paramForwardBody = paramFriendsManager.a(l1 + "");
              paramTroopManager = paramFriendsManager.c(Long.toString(l1));
              if (paramForwardBody != null)
              {
                paramForwardBody.namePlateOfKingGameId = l2;
                paramFriendsManager.a(paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
              }
              if (paramTroopManager != null)
              {
                paramTroopManager.namePlateOfKingGameId = l2;
                paramFriendsManager.a(paramTroopManager);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
              }
              QLog.i("namePlateOfKing", 1, "handle push gameId = " + l2 + ", uin = " + l1);
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              l2 = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              paramForwardBody = paramFriendsManager.a(l1 + "");
              paramTroopManager = paramFriendsManager.c(Long.toString(l1));
              if (paramForwardBody != null)
              {
                paramForwardBody.namePlateOfKingLoginTime = l2;
                paramFriendsManager.a(paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
              }
              if (paramTroopManager != null)
              {
                paramTroopManager.namePlateOfKingLoginTime = l2;
                paramFriendsManager.a(paramTroopManager);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
              }
              QLog.i("namePlateOfKing", 1, "handle push gameLoginTime = " + l2 + ", uin = " + l1);
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
              paramForwardBody = paramFriendsManager.a(l1 + "");
              paramTroopManager = paramFriendsManager.c(Long.toString(l1));
              if (paramForwardBody != null)
              {
                paramForwardBody.namePlateOfKingDan = n;
                paramFriendsManager.a(paramForwardBody);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
              }
              if (paramTroopManager != null)
              {
                paramTroopManager.namePlateOfKingDan = n;
                paramFriendsManager.a(paramTroopManager);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
              }
              QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDan = " + n + ", uin = " + l1);
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asShortBuffer().get();
              paramForwardBody = paramFriendsManager.a(l1 + "");
              paramTroopManager = paramFriendsManager.c(Long.toString(l1));
              if (paramForwardBody != null)
              {
                if (n == 1)
                {
                  bool1 = true;
                  label6192:
                  paramForwardBody.namePlateOfKingDanDisplatSwitch = bool1;
                  paramFriendsManager.a(paramForwardBody);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramForwardBody);
                }
              }
              else if (paramTroopManager != null) {
                if (n != 1) {
                  break label6320;
                }
              }
              label6320:
              for (bool1 = true;; bool1 = false)
              {
                paramTroopManager.namePlateOfKingDanDisplatSwitch = bool1;
                paramFriendsManager.a(paramTroopManager);
                this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(l1));
                QLog.i("namePlateOfKing", 1, "handle push namePlateOfKingDanDisplatSwitch = " + n + ", uin = " + l1);
                n = paramInt;
                paramInt = m;
                m = n;
                break;
                bool1 = false;
                break label6192;
              }
              paramForwardBody = ((TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey(l1 + "");
              ((VipInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a(paramForwardBody, l1 + "");
              n = paramInt;
              paramInt = m;
              m = n;
              continue;
              n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
              paramTroopManager = paramFriendsManager.a(String.valueOf(l1));
              paramForwardBody = paramTroopManager;
              if (paramTroopManager == null)
              {
                paramForwardBody = new ExtensionInfo();
                paramForwardBody.uin = String.valueOf(l1);
              }
              paramForwardBody.pendantDiyId = n;
              paramForwardBody.timestamp = System.currentTimeMillis();
              paramFriendsManager.a(paramForwardBody);
              n = k;
              if (!QLog.isColorLevel()) {
                break label489;
              }
              QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get PendantDiyId, uin=" + l1 + ", id=" + paramForwardBody.pendantDiyId);
              n = paramInt;
              paramInt = m;
              m = n;
            }
          }
          n = ByteBuffer.wrap(paramForwardBody.bytes_value.get().toByteArray()).asIntBuffer().get();
          ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a.b(Long.toString(l1), n);
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "push, Get faceId, uin=" + l1 + ", id=" + n);
          }
        }
      }
      n = i1;
      if (m != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasFont", 2, "Onlinepush hasDiyFontTimestamp: uin = " + l1 + " fontid = " + paramInt + " timestamp = " + k);
        }
        paramFriendsManager = paramFriendsManager.a(String.valueOf(l1));
        paramForwardBody = paramFriendsManager;
        if (paramFriendsManager == null)
        {
          paramForwardBody = new ExtensionInfo();
          paramForwardBody.uin = String.valueOf(l1);
        }
        m = paramInt;
        if (paramInt == 0) {
          m = (int)paramForwardBody.uVipFont;
        }
        FontManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1), paramForwardBody, m, k);
        n = i1;
      }
    }
    return n;
  }
  
  private MessageRecord a(MsgInfo paramMsgInfo, long paramLong)
  {
    paramMsgInfo = paramMsgInfo.vMsg;
    PkgTools.a(paramMsgInfo, 0);
    int i = paramMsgInfo[4];
    PkgTools.a(paramMsgInfo, 5);
    PkgTools.a(paramMsgInfo, 9);
    PkgTools.a(paramMsgInfo, 13);
    i = paramMsgInfo[17];
    PkgTools.a(paramMsgInfo, 18);
    PkgTools.a(paramMsgInfo, 22);
    PkgTools.a(paramMsgInfo, 24);
    return null;
  }
  
  private void a(int paramInt)
  {
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramInt);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString, int paramInt4, long paramLong, int paramInt5)
  {
    Object localObject1 = ContactUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
    Object localObject2 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    int j = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("hotDisableInteractive", 0);
    int i = 2097153;
    if (QLog.isColorLevel()) {
      QLog.d("FriendReactive", 2, "addHotFriendAIOGrayTips type=" + paramInt1 + "level=" + paramInt2 + "flag=" + paramInt3 + "IsDisableInteractive=" + ((FriendsManager)localObject2).j + "prelevel=" + paramInt4);
    }
    String str1;
    if (((paramInt3 != 0) && (j != 1)) || (paramInt5 == 2) || (paramInt5 == 3))
    {
      label203:
      Object localObject3;
      switch (paramInt1)
      {
      default: 
        paramInt4 = 0;
        paramInt2 = 1;
        paramInt1 = 0;
        str1 = "";
        localObject2 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), str1, (String)localObject1, (FriendsManager)localObject2);
        localObject3 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), (String)((List)localObject2).get(0));
        str1 = (String)((List)localObject3).get(0);
        ((List)localObject2).remove(0);
        ((List)localObject3).remove(0);
        if ((paramInt1 != 0) && (!QvipSpecialCareManager.a(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
          ((VasExtensionHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(paramString, paramInt1);
        }
        if (paramInt3 == 1) {
          paramInt1 = 2097153;
        }
        break;
      }
      Object localObject4;
      for (;;)
      {
        localObject1 = new UniteGrayTipParam(paramString, paramString, str1, 0, -5020, paramInt1, MessageCache.a());
        if ((localObject3 == null) || (((List)localObject3).size() <= 0)) {
          break label1381;
        }
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject3).size())
        {
          localObject4 = new Bundle();
          String str2 = (String)((List)localObject3).get(paramInt1);
          if (!TextUtils.isEmpty(str2))
          {
            ((Bundle)localObject4).putString("image_resource", str2);
            paramInt3 = str1.lastIndexOf(str2);
            if (paramInt3 >= 0) {
              ((UniteGrayTipParam)localObject1).a(paramInt3, str2.length() + paramInt3, (Bundle)localObject4);
            }
            if (QLog.isColorLevel()) {
              QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + str1 + "iconPos=" + paramInt3 + "icon=" + str2 + "grayStr=" + str1);
            }
          }
          paramInt1 += 1;
        }
        paramInt1 = ((FriendsManager)localObject2).c;
        paramInt1 = ((FriendsManager)localObject2).d;
        if (paramInt2 == 1)
        {
          if (paramInt3 == 1)
          {
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 21);
            paramInt4 = 5;
            paramInt2 = 1;
            paramInt1 = 0;
            break label203;
          }
          if (paramInt3 != 2) {
            break;
          }
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 24);
          paramInt4 = 8;
          paramInt2 = 1;
          paramInt1 = 0;
          break label203;
        }
        if (paramInt2 == 2)
        {
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 42);
          paramInt4 = 6;
          paramInt2 = 2;
          paramInt1 = 0;
          break label203;
        }
        if (paramInt2 != 0) {
          break;
        }
        str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 27);
        paramInt4 = 7;
        paramInt2 = 1;
        paramInt1 = 0;
        break label203;
        paramInt1 = ((FriendsManager)localObject2).a;
        paramInt1 = ((FriendsManager)localObject2).b;
        if (paramInt2 == 1)
        {
          if (paramInt3 == 1)
          {
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 20);
            paramInt4 = 1;
            paramInt2 = 3;
            paramInt1 = 0;
            break label203;
          }
          if (paramInt3 != 2) {
            break;
          }
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 23);
          paramInt4 = 4;
          paramInt2 = 4;
          paramInt1 = 0;
          break label203;
        }
        if (paramInt2 == 2)
        {
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 41);
          paramInt4 = 2;
          paramInt2 = 4;
          paramInt1 = 1;
          break label203;
        }
        if (paramInt2 != 0) {
          break;
        }
        str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 26);
        paramInt4 = 3;
        paramInt2 = 1;
        paramInt1 = 0;
        break label203;
        paramInt1 = ((FriendsManager)localObject2).e;
        paramInt1 = ((FriendsManager)localObject2).f;
        if (paramInt5 == 3)
        {
          if (paramInt2 == 1)
          {
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 69);
            paramInt4 = 31;
            paramInt2 = 5;
            paramInt1 = 3;
            break label203;
          }
          if (paramInt2 != 2) {
            break;
          }
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 70);
          paramInt4 = 32;
          paramInt2 = 6;
          paramInt1 = 4;
          break label203;
        }
        if (paramInt5 == 2)
        {
          if (paramInt2 == 1)
          {
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 65);
            paramInt4 = 27;
            paramInt2 = 9;
            paramInt1 = 5;
            break label203;
          }
          if (paramInt2 != 2) {
            break;
          }
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 68);
          paramInt4 = 28;
          paramInt2 = 10;
          paramInt1 = 6;
          break label203;
        }
        if (paramInt2 == 1)
        {
          if (paramInt3 == 1)
          {
            if ((paramInt5 == 1) || (paramInt5 == 2))
            {
              str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 65);
              paramInt4 = 29;
              paramInt2 = 9;
              paramInt1 = 5;
              break label203;
            }
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 22);
            paramInt4 = 9;
            paramInt2 = 5;
            paramInt1 = 3;
            break label203;
          }
          if (paramInt3 != 2) {
            break;
          }
          paramInt4 = 0;
          paramInt2 = 1;
          paramInt1 = 0;
          str1 = "";
          break label203;
        }
        if (paramInt2 == 2)
        {
          if ((paramInt5 == 1) || (paramInt5 == 2))
          {
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 68);
            paramInt4 = 30;
            paramInt2 = 10;
            paramInt1 = 6;
            break label203;
          }
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 43);
          paramInt4 = 10;
          paramInt2 = 6;
          paramInt1 = 4;
          break label203;
        }
        if (paramInt2 != 0) {
          break;
        }
        if (paramInt4 == 1)
        {
          if ((paramInt5 == 1) || (paramInt5 == 2))
          {
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 67);
            paramInt4 = 33;
            paramInt2 = 1;
            paramInt1 = 0;
            break label203;
          }
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 28);
          paramInt4 = 11;
          paramInt2 = 1;
          paramInt1 = 0;
          break label203;
        }
        if (paramInt4 != 2) {
          break;
        }
        if ((paramInt5 == 1) || (paramInt5 == 2))
        {
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 66);
          paramInt4 = 34;
          paramInt2 = 1;
          paramInt1 = 0;
          break label203;
        }
        str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 25);
        paramInt4 = 12;
        paramInt2 = 1;
        paramInt1 = 0;
        break label203;
        paramInt1 = ((FriendsManager)localObject2).g;
        paramInt1 = ((FriendsManager)localObject2).h;
        if (paramInt2 == 1)
        {
          if (paramInt3 == 1)
          {
            str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 38);
            paramInt2 = HotReactiveHelper.a;
            paramInt4 = 13;
            paramInt1 = 2;
            break label203;
          }
          if (paramInt3 != 2) {
            break;
          }
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 39);
          paramInt4 = 16;
          paramInt2 = 1;
          paramInt1 = 0;
          break label203;
        }
        if (paramInt2 == 2)
        {
          str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 44);
          paramInt2 = HotReactiveHelper.b;
          paramInt4 = 14;
          paramInt1 = 0;
          break label203;
        }
        if (paramInt2 != 0) {
          break;
        }
        str1 = HotReactiveHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 40);
        paramInt4 = 15;
        paramInt2 = 1;
        paramInt1 = 0;
        break label203;
        paramInt1 = i;
        if (paramInt3 == 2) {
          paramInt1 = 2097154;
        }
      }
      label1381:
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        paramInt1 = 0;
        while (paramInt1 < ((List)localObject2).size())
        {
          localObject3 = new Bundle();
          localObject4 = (String)((List)localObject2).get(paramInt1);
          if (!TextUtils.isEmpty((CharSequence)localObject4))
          {
            ((Bundle)localObject3).putInt("key_action", 11);
            ((Bundle)localObject3).putString("key_action_DATA", (String)localObject4);
            paramInt3 = str1.lastIndexOf((String)localObject4);
            if (paramInt3 >= 0) {
              ((UniteGrayTipParam)localObject1).a(paramInt3, ((String)localObject4).length() + paramInt3, (Bundle)localObject3);
            }
            if (QLog.isColorLevel()) {
              QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + str1 + "spanPos=" + paramInt3 + "iconName=" + (String)localObject4);
            }
          }
          paramInt1 += 1;
        }
      }
      localObject2 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject2).hasRead = 0;
      ((MessageForUniteGrayTip)localObject2).subType = paramInt2;
      ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (UniteGrayTipParam)localObject1);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramString, 0);
      if ((paramString == null) || (paramString.isEmpty())) {
        break label1733;
      }
      paramString = (MessageRecord)paramString.get(paramString.size() - 1);
      if ((!(paramString instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramString).tipParam == null) || (((MessageForUniteGrayTip)paramString).subType != ((MessageForUniteGrayTip)localObject2).subType) || (!((MessageForUniteGrayTip)paramString).tipParam.c.equals(((MessageForUniteGrayTip)localObject2).tipParam.c)) || (((MessageForUniteGrayTip)localObject2).tipParam.a - ((MessageForUniteGrayTip)paramString).tipParam.a > 1L)) {
        break label1733;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
      }
    }
    return;
    label1733:
    if (!TextUtils.isEmpty(str1)) {
      UniteGrayTipUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForUniteGrayTip)localObject2);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007779", "0X8007779", paramInt4, 0, "", "", "", "");
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcReqPushMsg paramSvcReqPushMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleC2COnlinePushMsgResp");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = paramSvcReqPushMsg.wUserActive;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "OnlinePush.ReqPush,notify.wUserActive:" + paramSvcReqPushMsg.wUserActive);
    }
    String str1 = (String)paramFromServiceMsg.getAttribute("_tag_LOGSTR");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = paramSvcReqPushMsg.vMsgInfos;
    ArrayList localArrayList3;
    long l3;
    int n;
    ArrayList localArrayList4;
    MsgInfo localMsgInfo;
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localArrayList3 = new ArrayList();
      l3 = paramSvcReqPushMsg.lUin;
      n = paramSvcReqPushMsg.svrip;
      localArrayList4 = new ArrayList();
      Iterator localIterator = localArrayList2.iterator();
      if (localIterator.hasNext()) {
        localMsgInfo = (MsgInfo)localIterator.next();
      }
    }
    for (;;)
    {
      long l2;
      long l1;
      long l4;
      label501:
      MessageRecord localMessageRecord;
      try
      {
        new ArrayList();
        j = localMsgInfo.shMsgType;
        localObject = null;
        l2 = localMsgInfo.lFromUin;
        l1 = localMsgInfo.lFromUin;
        if (paramFromServiceMsg.getUin() != null) {
          continue;
        }
        paramToServiceMsg = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        l4 = paramToServiceMsg.longValue();
        if (l4 == l2) {}
        paramToServiceMsg = new DelMsgInfo();
        ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(localMsgInfo.lFromUin);
        paramToServiceMsg.lFromUin = localMsgInfo.lFromUin;
        paramToServiceMsg.shMsgSeq = localMsgInfo.shMsgSeq;
        paramToServiceMsg.uMsgTime = localMsgInfo.uMsgTime;
        paramToServiceMsg.vMsgCookies = localMsgInfo.vMsgCookies;
        localArrayList3.add(paramToServiceMsg);
        if ((42 != j) && (83 != j) && (127 != j) && (QLog.isColorLevel())) {
          MessageHandlerUtils.a("Q.msg.BaseMessageProcessor", str1, localMsgInfo.shMsgSeq, String.valueOf(l3), String.valueOf(localMsgInfo.lFromUin));
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp  before analysis msgInfo.lFromUin: " + localMsgInfo.lFromUin + " msgInfo.shMsgType: " + localMsgInfo.shMsgType + " msgInfo.uRealMsgTime: " + localMsgInfo.uRealMsgTime + " msgInfo.shMsgSeq: " + localMsgInfo.shMsgSeq + ", msgInfo.lMsgUid" + localMsgInfo.lMsgUid);
        }
        if (!OnLinePushMsgTypeProcessorDispatcher.a().containsKey(Integer.valueOf(j))) {
          continue;
        }
        paramToServiceMsg = b(j, localMsgInfo, paramSvcReqPushMsg);
        if (paramToServiceMsg == null) {
          break label2258;
        }
        if (paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
          localArrayList1.add(paramToServiceMsg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
        }
        if (paramToServiceMsg.jdField_a_of_type_Boolean) {
          break;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        String str2;
        label574:
        paramToServiceMsg.printStackTrace();
        if ((localMsgInfo.vMsg == null) || (!QLog.isColorLevel())) {
          continue;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp Exception msgInfo.vMsg: " + HexUtil.a(localMsgInfo.vMsg));
        continue;
      }
      if (paramToServiceMsg != null)
      {
        localMessageRecord = MessageRecordFactory.a(i);
        if (j != 1006) {
          break label2052;
        }
        str2 = ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l2));
        localMessageRecord.init(String.valueOf(l3), ContactUtils.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l1)), str2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        localMessageRecord.shmsgseq = localMsgInfo.shMsgSeq;
        localMessageRecord.isread = bool1;
        localMessageRecord.msgUid = localMsgInfo.lMsgUid;
        localMessageRecord.msgData = ((byte[])localObject);
        if (k > 0) {
          localMessageRecord.extraflag = k;
        }
        if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, true)) {
          localArrayList1.add(localMessageRecord);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "----------handleC2COnlinePushMsgResp after analysis friendUin: " + l1 + " msgType: " + i + " friendType: " + j + " shMsgSeq: " + localMsgInfo.shMsgSeq + " msgContent: " + Utils.a(paramToServiceMsg));
        }
      }
      if (localMsgInfo.uAppShareID <= 0L) {
        break;
      }
      localArrayList4.add(AppShareIDUtil.a(localMsgInfo.uAppShareID));
      break;
      paramToServiceMsg = Long.valueOf(paramFromServiceMsg.getUin());
      continue;
      if (169 == j)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "------->msgFilter-handleC2COnlinePushMsgResp receive msg size:" + localArrayList2.size());
        }
        if (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, String.valueOf(l1), String.valueOf(l2), localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq)) {
          break;
        }
        localArrayList3.remove(paramToServiceMsg);
        paramToServiceMsg = new String(localMsgInfo.vMsg) + localMsgInfo.uMsgTime;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(paramToServiceMsg))
        {
          paramToServiceMsg = new long[1];
          paramToServiceMsg[0] = localMsgInfo.lFromUin;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "---->handleC2COnlinePushMsgResp, new file msg, about to call handleOffLineFileResp");
          }
          a(String.valueOf(l1), l3, paramToServiceMsg, localMsgInfo.vMsg, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq, false);
          localMsgInfo.lFromUin = paramToServiceMsg[0];
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.msg.BaseMessageProcessor", 2, "rcv a repeated offline file push msg");
        break;
      }
      if (8 == j)
      {
        paramToServiceMsg = new byte[4];
        if (localMsgInfo.vMsg.length > 4) {
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
        }
        l2 = PkgTools.a(paramToServiceMsg, 0);
        if (localMsgInfo.vMsg.length >= 9)
        {
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.a(paramToServiceMsg), "utf-8");
          break label2280;
        }
      }
      else
      {
        if (132 == j)
        {
          paramToServiceMsg = new byte[4];
          if (localMsgInfo.vMsg.length > 4) {
            PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, 4);
          }
          l2 = PkgTools.a(paramToServiceMsg, 0);
          paramToServiceMsg = (ToServiceMsg)localObject;
          if (localMsgInfo.vMsg.length < 9) {
            break label2302;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 9];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 8, paramToServiceMsg.length);
          paramToServiceMsg = new String(MessageUtils.a(paramToServiceMsg), "utf-8");
          break label2302;
        }
        if (732 == j)
        {
          if (localMsgInfo.vMsg == null) {
            return;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 0, paramToServiceMsg.length);
          i = paramToServiceMsg[4];
          if (!QLog.isColorLevel()) {
            break label2325;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "<---0x2dc push  groupCode:" + PkgTools.a(localMsgInfo.vMsg, 0) + " subType:" + i + "msgSeq:" + localMsgInfo.shMsgSeq);
          break label2325;
          label1347:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2342;
          }
          paramToServiceMsg = (TroopTipsMsgMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80);
          localObject = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a((byte[])localObject, 0, localMsgInfo.vMsg, 7, localObject.length);
          paramToServiceMsg = paramToServiceMsg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte[])localObject, localMsgInfo.shMsgSeq, localMsgInfo.uRealMsgTime, false, false, null);
          if (paramToServiceMsg == null) {
            break label2342;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2342;
          label1439:
          if (!((TroopGagMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(47)).a(paramToServiceMsg, localMsgInfo.shMsgSeq)) {
            break label2342;
          }
          return;
          label1464:
          if (i == 15)
          {
            a(paramToServiceMsg, localMsgInfo.shMsgSeq);
            return;
          }
          if (i != 6) {
            break label2381;
          }
          g(paramToServiceMsg);
          break label2342;
          label1498:
          if (localMsgInfo.vMsg.length <= 7) {
            break label2342;
          }
          paramToServiceMsg = new byte[localMsgInfo.vMsg.length - 7];
          PkgTools.a(paramToServiceMsg, 0, localMsgInfo.vMsg, 7, paramToServiceMsg.length);
          a(paramToServiceMsg, i);
          break label2342;
        }
        if (230 == j)
        {
          paramToServiceMsg = new String(MessageUtils.a(localMsgInfo.vMsg), "utf-8");
          localObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(l1 + "");
          if ((localObject != null) && (((Friends)localObject).isFriend())) {}
          for (j = 0;; j = 1006)
          {
            label1625:
            localObject = new SafeMsg.SafeMoreInfo();
            ((SafeMsg.SafeMoreInfo)localObject).strFromMobile.set(localMsgInfo.strFromMobile);
            ((SafeMsg.SafeMoreInfo)localObject).strFromName.set(localMsgInfo.strFromName);
            ((SafeMsg.SafeMoreInfo)localObject).strMsgTxt.set(paramToServiceMsg);
            localObject = ((SafeMsg.SafeMoreInfo)localObject).toByteArray();
            i = -1002;
            k = -1;
            bool1 = true;
            break;
            localObject = ((PhoneContactManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).b(String.valueOf(l2));
            if ((localObject == null) || (((String)localObject).length() == 0)) {
              break label2398;
            }
          }
        }
        if (SystemMsg.isSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(2);
          l1 = 9998L;
          i = -1006 - (j - 187);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, localMsgInfo.lFromUin, j, i, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
          bool1 = false;
          k = -1;
          localObject = null;
          paramToServiceMsg = null;
          j = 0;
          continue;
        }
        if (SystemMsg.isTroopSystemMessage(j))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(3);
          if (j == 45)
          {
            paramToServiceMsg = a(localMsgInfo, l3);
            if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
              break label2406;
            }
            localArrayList1.add(paramToServiceMsg);
            break label2406;
          }
        }
      }
      for (;;)
      {
        GroupSystemMsgController.a().a(l2, localMsgInfo.uMsgTime, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        k = i;
        localObject = null;
        paramToServiceMsg = null;
        int m = 0;
        bool1 = false;
        i = j;
        j = m;
        break label501;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(l3, j, localMsgInfo.vMsg, localMsgInfo.lFromUin, localMsgInfo.uMsgTime, localMsgInfo.shMsgSeq);
        l1 = 9998L;
        i = 32769;
        j = SystemMsg.getTroopSystemMsgType(j);
        continue;
        if (528 == j)
        {
          paramToServiceMsg = b(localMsgInfo, l4);
          if ((paramToServiceMsg == null) || (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramToServiceMsg, true))) {
            break label2417;
          }
          localArrayList1.add(paramToServiceMsg);
          break label2417;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.w("Q.msg.BaseMessageProcessor", 2, "~~~~~handleC2COnlinePushMsgResp msgtype: unknow msgType!!!");
        break;
        label2052:
        localMessageRecord.init(l3, l1, l2, paramToServiceMsg, localMsgInfo.uRealMsgTime, i, j, localMsgInfo.uMsgTime);
        break label574;
        if (localArrayList4.size() > 0) {
          a(localArrayList4);
        }
        i = paramFromServiceMsg.getRequestSsoSeq();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l3, localArrayList3, n, i, null);
        boolean bool2;
        boolean bool3;
        if (localArrayList1.size() > 0)
        {
          bool2 = MessageHandlerUtils.a(localArrayList1);
          bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localArrayList1);
          i = MsgProxyUtils.a(localArrayList1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
          if ((!bool2) || (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {
            break label2247;
          }
        }
        label2247:
        for (bool1 = true;; bool1 = false)
        {
          paramToServiceMsg.a(localArrayList1, String.valueOf(l3), bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramSvcReqPushMsg.uMsgTime);
          a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localArrayList1);
          return;
        }
        paramToServiceMsg = null;
        break label2280;
        label2258:
        bool1 = false;
        k = -1;
        localObject = null;
        paramToServiceMsg = null;
        i = -1000;
        j = 0;
        break label501;
        label2280:
        j = 1000;
        i = -1000;
        k = -1;
        localObject = null;
        bool1 = false;
        break label501;
        label2302:
        j = 1020;
        i = -1000;
        k = -1;
        localObject = null;
        bool1 = false;
        break label501;
        return;
        label2325:
        if (i == 16) {
          break label1347;
        }
        if (i == 17) {
          break label1347;
        }
        label2342:
        label2381:
        do
        {
          bool1 = false;
          k = -1;
          localObject = null;
          paramToServiceMsg = null;
          i = -1000;
          j = 0;
          break;
          if (i == 12) {
            break label1439;
          }
          if (i != 14) {
            break label1464;
          }
          break label1439;
          if (i == 11) {
            break label1498;
          }
        } while (i != 13);
        break label1498;
        label2398:
        j = 1000;
        break label1625;
        label2406:
        i = -1;
        j = -1000;
      }
      label2417:
      boolean bool1 = false;
      int k = -1;
      Object localObject = null;
      paramToServiceMsg = null;
      int i = -1000;
      int j = 0;
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = BuddyTransfileProcessor.a(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      cmd0x2dc.GroupVisitorJoinMsg localGroupVisitorJoinMsg = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject).mergeFrom(paramArrayOfByte);
      long l = localGroupVisitorJoinMsg.uint64_group_code.get();
      paramArrayOfByte = localGroupVisitorJoinMsg.rpt_msg_visitor_join_info.get();
      int i;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(String.valueOf(l)))
        {
          Iterator localIterator = paramArrayOfByte.iterator();
          paramArrayOfByte = "";
          while (localIterator.hasNext())
          {
            cmd0x2dc.VisitorJoinInfo localVisitorJoinInfo = (cmd0x2dc.VisitorJoinInfo)localIterator.next();
            String str = "" + localVisitorJoinInfo.uint64_visitor_uin.get();
            if (!str.equalsIgnoreCase((String)localObject))
            {
              if (localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8().equals("")) {}
              for (paramArrayOfByte = paramArrayOfByte + str + "、";; paramArrayOfByte = paramArrayOfByte + localVisitorJoinInfo.bytes_visitor_name.get().toStringUtf8() + "、") {
                break;
              }
            }
          }
          localObject = paramArrayOfByte;
          if (paramArrayOfByte.length() > 1) {
            localObject = paramArrayOfByte.substring(0, paramArrayOfByte.length() - 1);
          }
          if (!localGroupVisitorJoinMsg.uint32_op_flag.has()) {
            break label395;
          }
          i = localGroupVisitorJoinMsg.uint32_op_flag.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "handleEnterOpenTroopHotChatPushMsg. groupCode=" + l + ", name=" + (String)localObject + ", op_flag=" + i);
          }
          if (paramInt != 11) {
            break label400;
          }
          paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437319);
        }
      }
      for (;;)
      {
        AddMessageHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramArrayOfByte, 1, false, true);
        return;
        label395:
        i = 0;
        break;
        label400:
        paramArrayOfByte = (byte[])localObject;
        if (paramInt == 13) {
          if (1 == i) {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437329);
          } else {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437320);
          }
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 2: 
    default: 
      return false;
    case 1: 
      return true;
    }
    return true;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    long l1 = PkgTools.a(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = PkgTools.a(paramArrayOfByte, 5);
      long l3 = PkgTools.a(paramArrayOfByte, 9);
      int i = PkgTools.b(paramArrayOfByte, 13);
      paramArrayOfByte = PkgTools.a(paramArrayOfByte, 15, i);
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  private MessageRecord b(MsgInfo paramMsgInfo, long paramLong)
  {
    // Byte code:
    //   0: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 86
    //   8: iconst_2
    //   9: ldc_w 1420
    //   12: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: getfield 807	OnlinePushPack/MsgInfo:vMsg	[B
    //   19: invokestatic 1425	com/tencent/mobileqq/service/gamecenter/GameCenterPackeger:a	([B)LIMMsgBodyPack/MsgType0x210;
    //   22: astore 32
    //   24: aload 32
    //   26: ifnonnull +5 -> 31
    //   29: aconst_null
    //   30: areturn
    //   31: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +33 -> 67
    //   37: ldc 86
    //   39: iconst_2
    //   40: new 88	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 1427
    //   50: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 32
    //   55: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   58: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload 32
    //   69: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   72: ldc2_w 1433
    //   75: lcmp
    //   76: ifne +140 -> 216
    //   79: aload 32
    //   81: getfield 1438	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   84: ifnull +132 -> 216
    //   87: aload 32
    //   89: getfield 1438	IMMsgBodyPack/MsgType0x210:stMsgInfo0x24	LIMMsgBodyPack/MsgType0x210SubMsgType0x24;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -65 -> 29
    //   97: aload_1
    //   98: getfield 1443	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   101: ifnull -72 -> 29
    //   104: aload_1
    //   105: getfield 1443	IMMsgBodyPack/MsgType0x210SubMsgType0x24:vPluginNumList	Ljava/util/ArrayList;
    //   108: astore 28
    //   110: aload 28
    //   112: ifnull -83 -> 29
    //   115: aload 28
    //   117: invokeinterface 873 1 0
    //   122: ifle -93 -> 29
    //   125: aload_0
    //   126: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   129: bipush 11
    //   131: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   134: checkcast 1445	com/tencent/mobileqq/servlet/GameCenterManagerImp
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull -110 -> 29
    //   142: aload 28
    //   144: invokeinterface 51 1 0
    //   149: astore 28
    //   151: aload 28
    //   153: invokeinterface 56 1 0
    //   158: ifeq -129 -> 29
    //   161: aload 28
    //   163: invokeinterface 60 1 0
    //   168: checkcast 1447	IMMsgBodyPack/PluginNum
    //   171: astore 29
    //   173: aload 29
    //   175: ifnull -24 -> 151
    //   178: aload 29
    //   180: getfield 1450	IMMsgBodyPack/PluginNum:dwID	J
    //   183: lstore_2
    //   184: aload 29
    //   186: getfield 1454	IMMsgBodyPack/PluginNum:cFlag	B
    //   189: ifne +21 -> 210
    //   192: iconst_0
    //   193: istore 19
    //   195: aload_1
    //   196: lload_2
    //   197: iload 19
    //   199: aload 29
    //   201: getfield 1457	IMMsgBodyPack/PluginNum:dwNUm	J
    //   204: invokevirtual 1460	com/tencent/mobileqq/servlet/GameCenterManagerImp:a	(JZJ)V
    //   207: goto -56 -> 151
    //   210: iconst_1
    //   211: istore 19
    //   213: goto -18 -> 195
    //   216: aload 32
    //   218: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   221: ifnull +15000 -> 15221
    //   224: aload 32
    //   226: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   229: ldc2_w 1464
    //   232: lcmp
    //   233: ifne +29 -> 262
    //   236: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +12 -> 251
    //   242: ldc 86
    //   244: iconst_2
    //   245: ldc_w 1467
    //   248: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_0
    //   252: aload 32
    //   254: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   257: invokevirtual 1469	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([B)V
    //   260: aconst_null
    //   261: areturn
    //   262: aload 32
    //   264: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   267: ldc2_w 1470
    //   270: lcmp
    //   271: ifeq +27 -> 298
    //   274: aload 32
    //   276: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   279: ldc2_w 1472
    //   282: lcmp
    //   283: ifeq +15 -> 298
    //   286: aload 32
    //   288: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   291: ldc2_w 1474
    //   294: lcmp
    //   295: ifne +46 -> 341
    //   298: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +13 -> 314
    //   304: ldc_w 1477
    //   307: iconst_2
    //   308: ldc_w 1479
    //   311: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   314: aload_0
    //   315: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: bipush 11
    //   320: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   323: checkcast 1481	com/tencent/mobileqq/app/PublicAccountHandler
    //   326: aload 32
    //   328: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   331: aload 32
    //   333: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   336: invokevirtual 1484	com/tencent/mobileqq/app/PublicAccountHandler:a	(J[B)V
    //   339: aconst_null
    //   340: areturn
    //   341: aload 32
    //   343: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   346: ldc2_w 1485
    //   349: lcmp
    //   350: ifne +41 -> 391
    //   353: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +13 -> 369
    //   359: ldc_w 1488
    //   362: iconst_2
    //   363: ldc_w 1490
    //   366: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_0
    //   370: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   373: bipush 18
    //   375: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   378: checkcast 1492	com/tencent/mobileqq/app/ShieldListHandler
    //   381: aload 32
    //   383: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   386: invokevirtual 1493	com/tencent/mobileqq/app/ShieldListHandler:a	([B)V
    //   389: aconst_null
    //   390: areturn
    //   391: aload 32
    //   393: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   396: ldc2_w 1494
    //   399: lcmp
    //   400: ifne +15 -> 415
    //   403: aload_0
    //   404: lload_2
    //   405: aload 32
    //   407: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   410: invokespecial 1497	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	(J[B)V
    //   413: aconst_null
    //   414: areturn
    //   415: aload 32
    //   417: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   420: ldc2_w 1498
    //   423: lcmp
    //   424: ifne +85 -> 509
    //   427: new 1501	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   430: dup
    //   431: invokespecial 1502	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:<init>	()V
    //   434: aload 32
    //   436: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   439: invokevirtual 1503	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   442: checkcast 1501	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody
    //   445: getfield 1506	tencent/im/s2c/msgtype0x210/submsgtype0x35/Submsgtype0x35$MsgBody:uint32_bubble_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   448: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   451: istore 4
    //   453: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq -427 -> 29
    //   459: ldc_w 468
    //   462: iconst_2
    //   463: new 88	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 1508
    //   473: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: iload 4
    //   478: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   481: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   487: aconst_null
    //   488: areturn
    //   489: astore_1
    //   490: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   493: ifeq -464 -> 29
    //   496: ldc_w 468
    //   499: iconst_2
    //   500: ldc_w 1510
    //   503: aload_1
    //   504: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   507: aconst_null
    //   508: areturn
    //   509: aload 32
    //   511: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   514: ldc2_w 1514
    //   517: lcmp
    //   518: ifne +617 -> 1135
    //   521: new 1517	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody
    //   524: dup
    //   525: invokespecial 1518	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:<init>	()V
    //   528: astore 29
    //   530: aload 29
    //   532: aload 32
    //   534: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   537: invokevirtual 1519	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   540: pop
    //   541: aload 29
    //   543: getfield 1522	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   546: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   549: iconst_1
    //   550: if_icmpne -521 -> 29
    //   553: new 88	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   560: aload 29
    //   562: getfield 1525	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   565: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   568: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   571: ldc 140
    //   573: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: astore_1
    //   580: new 88	java/lang/StringBuilder
    //   583: dup
    //   584: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   587: aload 29
    //   589: getfield 1528	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:uint64_action_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   592: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   595: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   598: ldc 140
    //   600: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: astore 28
    //   608: aload 29
    //   610: getfield 1532	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:source	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   613: invokevirtual 1535	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   616: iconst_2
    //   617: if_icmpne +261 -> 878
    //   620: sipush 1001
    //   623: istore 4
    //   625: aload 29
    //   627: getfield 1539	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:bool_new_friend	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   630: invokevirtual 1543	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   633: ifeq +34 -> 667
    //   636: iconst_0
    //   637: istore 4
    //   639: aload_0
    //   640: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   643: iconst_1
    //   644: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   647: checkcast 201	com/tencent/mobileqq/app/FriendListHandler
    //   650: astore 30
    //   652: aload 30
    //   654: bipush 63
    //   656: iconst_1
    //   657: aload_1
    //   658: invokevirtual 1544	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   661: aload 30
    //   663: aload_1
    //   664: invokevirtual 1545	com/tencent/mobileqq/app/FriendListHandler:b	(Ljava/lang/String;)V
    //   667: aload 29
    //   669: getfield 1548	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$MsgBody:rpt_msg_business_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   672: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   675: invokeinterface 51 1 0
    //   680: astore 29
    //   682: aload 29
    //   684: invokeinterface 56 1 0
    //   689: ifeq -660 -> 29
    //   692: aload 29
    //   694: invokeinterface 60 1 0
    //   699: checkcast 1550	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg
    //   702: astore 30
    //   704: aload 30
    //   706: getfield 1553	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:msg_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   709: invokevirtual 1535	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   712: istore 5
    //   714: iload 5
    //   716: iconst_1
    //   717: if_icmpne +169 -> 886
    //   720: sipush -1000
    //   723: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   726: checkcast 1555	com/tencent/mobileqq/data/MessageForText
    //   729: astore 31
    //   731: aload 31
    //   733: aload_1
    //   734: putfield 1558	com/tencent/mobileqq/data/MessageForText:frienduin	Ljava/lang/String;
    //   737: aload_0
    //   738: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   741: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   744: aload 28
    //   746: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   749: ifeq +9 -> 758
    //   752: aload 31
    //   754: iconst_1
    //   755: putfield 1561	com/tencent/mobileqq/data/MessageForText:issend	I
    //   758: aload 31
    //   760: aload_0
    //   761: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   764: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   767: aload_1
    //   768: aload 28
    //   770: aload 30
    //   772: getfield 1564	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   775: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   778: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   781: invokestatic 520	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   784: sipush -1000
    //   787: iload 4
    //   789: aload_0
    //   790: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   793: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   796: aload_1
    //   797: iload 4
    //   799: invokevirtual 1567	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   802: getfield 1570	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shmsgseq	J
    //   805: lconst_1
    //   806: ladd
    //   807: invokevirtual 1571	com/tencent/mobileqq/data/MessageForText:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   810: aload 31
    //   812: iconst_0
    //   813: putfield 1572	com/tencent/mobileqq/data/MessageForText:isread	Z
    //   816: aload_0
    //   817: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   820: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   823: aload 31
    //   825: aload_0
    //   826: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   829: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   832: invokevirtual 1575	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   835: goto -153 -> 682
    //   838: astore_1
    //   839: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   842: ifeq -813 -> 29
    //   845: ldc_w 1577
    //   848: iconst_2
    //   849: new 88	java/lang/StringBuilder
    //   852: dup
    //   853: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   856: ldc_w 1579
    //   859: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: aload 32
    //   864: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   867: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   870: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   873: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   876: aconst_null
    //   877: areturn
    //   878: sipush 10002
    //   881: istore 4
    //   883: goto -258 -> 625
    //   886: iload 5
    //   888: iconst_2
    //   889: if_icmpne -207 -> 682
    //   892: aload 30
    //   894: getfield 1584	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bool_tab_visible	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   897: invokevirtual 1543	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   900: istore 19
    //   902: aload 30
    //   904: getfield 1564	tencent/im/s2c/msgtype0x210/submsgtype0xc9/submsgtype0xc9$BusinessMsg:bytes_msg_data	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   907: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   910: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   913: astore 30
    //   915: iload 19
    //   917: ifeq +140 -> 1057
    //   920: sipush -5001
    //   923: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   926: checkcast 1586	com/tencent/mobileqq/data/MessageForNewGrayTips
    //   929: astore 31
    //   931: aload 31
    //   933: aload_0
    //   934: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   937: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   940: aload_1
    //   941: aload_1
    //   942: aload 30
    //   944: invokestatic 520	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   947: sipush -5001
    //   950: iload 4
    //   952: lconst_1
    //   953: aload_0
    //   954: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   957: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   960: aload_1
    //   961: iload 4
    //   963: invokevirtual 1567	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   966: getfield 1570	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shmsgseq	J
    //   969: ladd
    //   970: invokevirtual 1587	com/tencent/mobileqq/data/MessageForNewGrayTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   973: aload 31
    //   975: iconst_1
    //   976: putfield 1588	com/tencent/mobileqq/data/MessageForNewGrayTips:isread	Z
    //   979: aload 31
    //   981: iconst_1
    //   982: putfield 1591	com/tencent/mobileqq/data/MessageForNewGrayTips:mNeedTimeStamp	Z
    //   985: aload 31
    //   987: invokevirtual 1594	com/tencent/mobileqq/data/MessageForNewGrayTips:updateMsgData	()V
    //   990: aload_0
    //   991: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   994: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   997: aload 31
    //   999: aload_0
    //   1000: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1003: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1006: invokevirtual 1575	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1009: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1012: ifeq -330 -> 682
    //   1015: ldc_w 1577
    //   1018: iconst_2
    //   1019: new 88	java/lang/StringBuilder
    //   1022: dup
    //   1023: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1026: ldc_w 1596
    //   1029: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: iload 19
    //   1034: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1037: ldc_w 1598
    //   1040: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1043: aload 30
    //   1045: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1051: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1054: goto -372 -> 682
    //   1057: sipush -5000
    //   1060: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1063: astore 31
    //   1065: aload 31
    //   1067: aload_0
    //   1068: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1071: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1074: aload_1
    //   1075: aload_1
    //   1076: aload 30
    //   1078: invokestatic 520	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   1081: sipush -5000
    //   1084: iload 4
    //   1086: lconst_1
    //   1087: aload_0
    //   1088: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1091: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1094: aload_1
    //   1095: iload 4
    //   1097: invokevirtual 1567	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;I)Lcom/tencent/mobileqq/app/message/QQMessageFacade$Message;
    //   1100: getfield 1570	com/tencent/mobileqq/app/message/QQMessageFacade$Message:shmsgseq	J
    //   1103: ladd
    //   1104: invokevirtual 1108	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   1107: aload 31
    //   1109: iconst_1
    //   1110: putfield 1114	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   1113: aload_0
    //   1114: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1117: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1120: aload 31
    //   1122: aload_0
    //   1123: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1126: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1129: invokevirtual 1575	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1132: goto -123 -> 1009
    //   1135: aload 32
    //   1137: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1140: ldc2_w 1599
    //   1143: lcmp
    //   1144: ifne +315 -> 1459
    //   1147: new 1602	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody
    //   1150: dup
    //   1151: invokespecial 1603	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:<init>	()V
    //   1154: astore 28
    //   1156: aload 28
    //   1158: aload 32
    //   1160: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1163: invokevirtual 1604	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1166: pop
    //   1167: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1170: ifeq +111 -> 1281
    //   1173: new 88	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 1606
    //   1183: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: astore 29
    //   1188: aload 28
    //   1190: getfield 1607	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1193: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1196: ifeq +251 -> 1447
    //   1199: aload 28
    //   1201: getfield 1607	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1204: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1207: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1210: astore_1
    //   1211: aload 29
    //   1213: aload_1
    //   1214: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: ldc_w 1609
    //   1220: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: astore 29
    //   1225: aload 28
    //   1227: getfield 1612	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1230: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1233: ifeq +220 -> 1453
    //   1236: aload 28
    //   1238: getfield 1612	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1241: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1244: invokestatic 1614	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1247: astore_1
    //   1248: ldc_w 1616
    //   1251: iconst_2
    //   1252: aload 29
    //   1254: aload_1
    //   1255: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1258: ldc_w 1618
    //   1261: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1264: aload 28
    //   1266: getfield 1621	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1269: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1272: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1275: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1281: aload 28
    //   1283: getfield 1607	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1286: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   1289: ifeq -1260 -> 29
    //   1292: aload 28
    //   1294: getfield 1612	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1297: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1300: ifeq +87 -> 1387
    //   1303: aload 28
    //   1305: getfield 1612	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1308: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1311: istore 4
    //   1313: aload 28
    //   1315: getfield 1607	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1318: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1321: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1324: astore_1
    //   1325: aload_0
    //   1326: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1329: bipush 51
    //   1331: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1334: checkcast 1411	com/tencent/mobileqq/app/TroopManager
    //   1337: astore 29
    //   1339: aload 29
    //   1341: aload_1
    //   1342: invokevirtual 1624	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   1345: astore 30
    //   1347: aload 30
    //   1349: iload 4
    //   1351: i2b
    //   1352: putfield 1629	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1355: aload 29
    //   1357: aload 30
    //   1359: invokevirtual 1632	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1362: iconst_1
    //   1363: aload 30
    //   1365: getfield 1629	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   1368: if_icmpne +19 -> 1387
    //   1371: aload_0
    //   1372: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1375: bipush 20
    //   1377: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1380: checkcast 1634	com/tencent/mobileqq/app/TroopHandler
    //   1383: aload_1
    //   1384: invokevirtual 1636	com/tencent/mobileqq/app/TroopHandler:e	(Ljava/lang/String;)V
    //   1387: aload 28
    //   1389: getfield 1621	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint32_member_level_changed	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1392: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1395: ifeq -1366 -> 29
    //   1398: aload 28
    //   1400: getfield 1607	tencent/im/s2c/msgtype0x210/submsgtype0x3b/Submsgtype0x3b$MsgBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1403: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   1406: lstore_2
    //   1407: aload_0
    //   1408: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1411: bipush 20
    //   1413: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1416: checkcast 1634	com/tencent/mobileqq/app/TroopHandler
    //   1419: lload_2
    //   1420: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1423: invokevirtual 1636	com/tencent/mobileqq/app/TroopHandler:e	(Ljava/lang/String;)V
    //   1426: aconst_null
    //   1427: areturn
    //   1428: astore_1
    //   1429: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1432: ifeq -1403 -> 29
    //   1435: ldc_w 1616
    //   1438: iconst_2
    //   1439: ldc_w 1638
    //   1442: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1445: aconst_null
    //   1446: areturn
    //   1447: ldc 140
    //   1449: astore_1
    //   1450: goto -239 -> 1211
    //   1453: ldc 140
    //   1455: astore_1
    //   1456: goto -208 -> 1248
    //   1459: aload 32
    //   1461: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1464: ldc2_w 1639
    //   1467: lcmp
    //   1468: ifne +25 -> 1493
    //   1471: aload_0
    //   1472: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1475: bipush 16
    //   1477: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1480: checkcast 376	com/tencent/mobileqq/stt/SttManager
    //   1483: aload 32
    //   1485: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1488: invokevirtual 1641	com/tencent/mobileqq/stt/SttManager:a	([B)V
    //   1491: aconst_null
    //   1492: areturn
    //   1493: aload 32
    //   1495: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1498: ldc2_w 1642
    //   1501: lcmp
    //   1502: ifne +17 -> 1519
    //   1505: aload_0
    //   1506: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1509: aload 32
    //   1511: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1514: invokestatic 1648	com/tencent/mobileqq/app/ConfigHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   1517: aconst_null
    //   1518: areturn
    //   1519: aload 32
    //   1521: ifnull +35 -> 1556
    //   1524: aload 32
    //   1526: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1529: ldc2_w 1649
    //   1532: lcmp
    //   1533: ifne +23 -> 1556
    //   1536: aload 32
    //   1538: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1541: ifnull +15 -> 1556
    //   1544: aload_0
    //   1545: lload_2
    //   1546: aload 32
    //   1548: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1551: invokevirtual 1651	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(J[B)V
    //   1554: aconst_null
    //   1555: areturn
    //   1556: aload 32
    //   1558: ifnull +35 -> 1593
    //   1561: aload 32
    //   1563: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1566: ldc2_w 1652
    //   1569: lcmp
    //   1570: ifne +23 -> 1593
    //   1573: aload 32
    //   1575: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1578: ifnull +15 -> 1593
    //   1581: aload_0
    //   1582: aload 32
    //   1584: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1587: invokevirtual 1654	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([B)Ljava/lang/String;
    //   1590: pop
    //   1591: aconst_null
    //   1592: areturn
    //   1593: aload 32
    //   1595: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1598: ldc2_w 1655
    //   1601: lcmp
    //   1602: ifne +22 -> 1624
    //   1605: aload 32
    //   1607: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1610: ifnull +14 -> 1624
    //   1613: aload_0
    //   1614: aload 32
    //   1616: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1619: invokespecial 1658	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:f	([B)V
    //   1622: aconst_null
    //   1623: areturn
    //   1624: aload 32
    //   1626: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1629: ldc2_w 1659
    //   1632: lcmp
    //   1633: ifne +22 -> 1655
    //   1636: aload 32
    //   1638: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1641: ifnull +14 -> 1655
    //   1644: aload_0
    //   1645: aload 32
    //   1647: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1650: invokevirtual 1662	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	([B)V
    //   1653: aconst_null
    //   1654: areturn
    //   1655: aload 32
    //   1657: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1660: ldc2_w 1663
    //   1663: lcmp
    //   1664: ifne +14 -> 1678
    //   1667: aload_0
    //   1668: aload 32
    //   1670: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1673: invokevirtual 1666	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:d	([B)V
    //   1676: aconst_null
    //   1677: areturn
    //   1678: aload 32
    //   1680: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1683: ldc2_w 1667
    //   1686: lcmp
    //   1687: ifne +14 -> 1701
    //   1690: aload_0
    //   1691: aload 32
    //   1693: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1696: invokevirtual 1670	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:e	([B)V
    //   1699: aconst_null
    //   1700: areturn
    //   1701: aload 32
    //   1703: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1706: ldc2_w 1671
    //   1709: lcmp
    //   1710: ifne +22 -> 1732
    //   1713: aload 32
    //   1715: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1718: ifnull +14 -> 1732
    //   1721: aload_0
    //   1722: aload 32
    //   1724: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1727: invokevirtual 1674	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:c	([B)V
    //   1730: aconst_null
    //   1731: areturn
    //   1732: aload 32
    //   1734: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   1737: ldc2_w 1675
    //   1740: lcmp
    //   1741: ifne +311 -> 2052
    //   1744: aload 32
    //   1746: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1749: ifnull +303 -> 2052
    //   1752: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1755: ifeq +13 -> 1768
    //   1758: ldc_w 1678
    //   1761: iconst_2
    //   1762: ldc_w 1680
    //   1765: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1768: new 1682	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock
    //   1771: dup
    //   1772: invokespecial 1683	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:<init>	()V
    //   1775: astore_1
    //   1776: aload_1
    //   1777: aload 32
    //   1779: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   1782: invokevirtual 1684	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1785: pop
    //   1786: new 397	android/content/Intent
    //   1789: dup
    //   1790: invokespecial 1685	android/content/Intent:<init>	()V
    //   1793: astore 28
    //   1795: aload 28
    //   1797: ldc_w 1687
    //   1800: aload_1
    //   1801: getfield 1689	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1804: invokevirtual 1543	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1807: invokevirtual 407	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   1810: pop
    //   1811: aload 28
    //   1813: ldc_w 1691
    //   1816: aload_1
    //   1817: getfield 1694	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1820: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1823: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1826: pop
    //   1827: aload 28
    //   1829: ldc_w 1698
    //   1832: aload_1
    //   1833: getfield 1701	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1836: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1839: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1842: pop
    //   1843: aload 28
    //   1845: ldc_w 1703
    //   1848: aload_1
    //   1849: getfield 1706	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1852: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1855: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1858: pop
    //   1859: aload 28
    //   1861: ldc_w 1708
    //   1864: aload_1
    //   1865: getfield 1711	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1868: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1871: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1874: pop
    //   1875: aload_1
    //   1876: getfield 1715	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_wording_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   1879: invokevirtual 1718	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   1882: astore 29
    //   1884: new 655	java/util/ArrayList
    //   1887: dup
    //   1888: invokespecial 656	java/util/ArrayList:<init>	()V
    //   1891: astore 30
    //   1893: aload 29
    //   1895: ifnull +21 -> 1916
    //   1898: aload 29
    //   1900: invokeinterface 873 1 0
    //   1905: ifle +11 -> 1916
    //   1908: aload 30
    //   1910: aload 29
    //   1912: invokevirtual 1722	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   1915: pop
    //   1916: aload 28
    //   1918: ldc_w 1724
    //   1921: aload 30
    //   1923: invokevirtual 1728	android/content/Intent:putStringArrayListExtra	(Ljava/lang/String;Ljava/util/ArrayList;)Landroid/content/Intent;
    //   1926: pop
    //   1927: aload_0
    //   1928: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1931: aload 28
    //   1933: invokevirtual 1731	com/tencent/mobileqq/app/QQAppInterface:setDevLockIntent	(Landroid/content/Intent;)V
    //   1936: aload_0
    //   1937: sipush 8007
    //   1940: iconst_1
    //   1941: bipush 6
    //   1943: anewarray 209	java/lang/Object
    //   1946: dup
    //   1947: iconst_0
    //   1948: aload_1
    //   1949: getfield 1689	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:canCancel	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1952: invokevirtual 1543	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1955: invokestatic 1736	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1958: aastore
    //   1959: dup
    //   1960: iconst_1
    //   1961: aload_1
    //   1962: getfield 1694	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1965: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1968: aastore
    //   1969: dup
    //   1970: iconst_2
    //   1971: aload_1
    //   1972: getfield 1701	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1975: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1978: aastore
    //   1979: dup
    //   1980: iconst_3
    //   1981: aload_1
    //   1982: getfield 1706	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_second_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1985: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1988: aastore
    //   1989: dup
    //   1990: iconst_4
    //   1991: aload_1
    //   1992: getfield 1711	tencent/im/s2c/msgtype0x210/submsgtype0x48/RecommendDeviceLock:str_third_title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1995: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1998: aastore
    //   1999: dup
    //   2000: iconst_5
    //   2001: aload 30
    //   2003: aastore
    //   2004: invokevirtual 1737	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2007: aconst_null
    //   2008: areturn
    //   2009: astore_1
    //   2010: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2013: ifeq +13 -> 2026
    //   2016: ldc_w 1678
    //   2019: iconst_2
    //   2020: ldc_w 1739
    //   2023: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2026: aload_0
    //   2027: sipush 8007
    //   2030: iconst_0
    //   2031: iconst_2
    //   2032: anewarray 209	java/lang/Object
    //   2035: dup
    //   2036: iconst_0
    //   2037: iconst_1
    //   2038: invokestatic 1736	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   2041: aastore
    //   2042: dup
    //   2043: iconst_1
    //   2044: ldc 140
    //   2046: aastore
    //   2047: invokevirtual 1737	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   2050: aconst_null
    //   2051: areturn
    //   2052: aload 32
    //   2054: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2057: ldc2_w 1740
    //   2060: lcmp
    //   2061: ifne +327 -> 2388
    //   2064: aload 32
    //   2066: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2069: ifnull +319 -> 2388
    //   2072: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2075: ifeq +13 -> 2088
    //   2078: ldc_w 1678
    //   2081: iconst_2
    //   2082: ldc_w 1743
    //   2085: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2088: new 1745	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2091: dup
    //   2092: invokespecial 1746	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2095: pop
    //   2096: aconst_null
    //   2097: astore 28
    //   2099: aconst_null
    //   2100: astore 29
    //   2102: aconst_null
    //   2103: astore 30
    //   2105: aconst_null
    //   2106: astore 31
    //   2108: new 1745	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody
    //   2111: dup
    //   2112: invokespecial 1746	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:<init>	()V
    //   2115: astore 33
    //   2117: aload 33
    //   2119: aload 32
    //   2121: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2124: invokevirtual 1747	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2127: pop
    //   2128: aload 33
    //   2130: getfield 1750	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2133: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2136: ifeq +26 -> 2162
    //   2139: new 264	java/lang/String
    //   2142: dup
    //   2143: aload 33
    //   2145: getfield 1750	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_qrsig_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2148: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2151: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2154: ldc_w 1200
    //   2157: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2160: astore 28
    //   2162: aload 33
    //   2164: getfield 1753	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2167: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2170: ifeq +26 -> 2196
    //   2173: new 264	java/lang/String
    //   2176: dup
    //   2177: aload 33
    //   2179: getfield 1753	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint1	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2182: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2185: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2188: ldc_w 1200
    //   2191: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2194: astore 29
    //   2196: aload 33
    //   2198: getfield 1756	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2201: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2204: ifeq +26 -> 2230
    //   2207: new 264	java/lang/String
    //   2210: dup
    //   2211: aload 33
    //   2213: getfield 1756	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_hint2	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2216: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2219: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2222: ldc_w 1200
    //   2225: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   2228: astore 30
    //   2230: aload 33
    //   2232: getfield 1759	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2235: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   2238: ifeq +16 -> 2254
    //   2241: aload 33
    //   2243: getfield 1759	com/tencent/msf/service/protocol/pb/SubMsgType0x51$MsgBody:bytes_login_conf	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2246: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2249: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2252: astore 31
    //   2254: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2257: ifeq +53 -> 2310
    //   2260: ldc_w 1678
    //   2263: iconst_2
    //   2264: new 88	java/lang/StringBuilder
    //   2267: dup
    //   2268: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2271: ldc_w 1761
    //   2274: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2277: aload 28
    //   2279: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2282: ldc_w 1763
    //   2285: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2288: aload 29
    //   2290: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2293: ldc_w 1765
    //   2296: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2299: aload 30
    //   2301: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2304: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2307: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2310: invokestatic 1770	com/tencent/mobileqq/equipmentlock/EquipmentLockImpl:a	()Lcom/tencent/mobileqq/equipmentlock/EquipmentLockImpl;
    //   2313: aload_0
    //   2314: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2317: aload 28
    //   2319: aload 29
    //   2321: aload 30
    //   2323: aload 31
    //   2325: invokevirtual 1773	com/tencent/mobileqq/equipmentlock/EquipmentLockImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[B)V
    //   2328: aload_1
    //   2329: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   2332: lstore_2
    //   2333: aload_1
    //   2334: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   2337: istore 4
    //   2339: aload_1
    //   2340: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   2343: lstore 15
    //   2345: aload_1
    //   2346: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   2349: istore 5
    //   2351: aload_0
    //   2352: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   2355: lload_2
    //   2356: iload 4
    //   2358: lload 15
    //   2360: iload 5
    //   2362: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   2365: aconst_null
    //   2366: areturn
    //   2367: astore 28
    //   2369: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2372: ifeq -44 -> 2328
    //   2375: ldc_w 1678
    //   2378: iconst_2
    //   2379: ldc_w 1780
    //   2382: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2385: goto -57 -> 2328
    //   2388: aload 32
    //   2390: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2393: ldc2_w 1781
    //   2396: lcmp
    //   2397: ifne +33 -> 2430
    //   2400: aload 32
    //   2402: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2405: ifnull +25 -> 2430
    //   2408: aload_0
    //   2409: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2412: bipush 24
    //   2414: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2417: checkcast 1784	com/tencent/mobileqq/app/SafeCenterPushHandler
    //   2420: aload 32
    //   2422: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2425: invokevirtual 1785	com/tencent/mobileqq/app/SafeCenterPushHandler:a	([B)V
    //   2428: aconst_null
    //   2429: areturn
    //   2430: aload 32
    //   2432: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2435: ldc2_w 1786
    //   2438: lcmp
    //   2439: ifne +221 -> 2660
    //   2442: aload 32
    //   2444: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2447: ifnull +213 -> 2660
    //   2450: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2453: ifeq +13 -> 2466
    //   2456: ldc_w 1789
    //   2459: iconst_2
    //   2460: ldc_w 1791
    //   2463: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2466: aload_0
    //   2467: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2470: iconst_4
    //   2471: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2474: checkcast 1645	com/tencent/mobileqq/app/ConfigHandler
    //   2477: astore_1
    //   2478: aload_1
    //   2479: ifnull -2450 -> 29
    //   2482: new 1793	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody
    //   2485: dup
    //   2486: invokespecial 1794	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:<init>	()V
    //   2489: astore 28
    //   2491: aload 28
    //   2493: aload 32
    //   2495: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2498: invokevirtual 1795	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2501: pop
    //   2502: aload 28
    //   2504: getfield 1798	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_type	Lcom/tencent/mobileqq/pb/PBEnumField;
    //   2507: invokevirtual 1535	com/tencent/mobileqq/pb/PBEnumField:get	()I
    //   2510: istore 4
    //   2512: aload 28
    //   2514: getfield 1801	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:task_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2517: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2520: astore 30
    //   2522: new 655	java/util/ArrayList
    //   2525: dup
    //   2526: invokespecial 656	java/util/ArrayList:<init>	()V
    //   2529: astore 29
    //   2531: aload 30
    //   2533: ifnull +87 -> 2620
    //   2536: aload 30
    //   2538: invokeinterface 873 1 0
    //   2543: ifle +77 -> 2620
    //   2546: aload 30
    //   2548: invokeinterface 51 1 0
    //   2553: astore 30
    //   2555: aload 30
    //   2557: invokeinterface 56 1 0
    //   2562: ifeq +58 -> 2620
    //   2565: aload 30
    //   2567: invokeinterface 60 1 0
    //   2572: checkcast 1803	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo
    //   2575: astore 31
    //   2577: new 1805	com/tencent/mobileqq/config/operation/QQOperationViopTipTask
    //   2580: dup
    //   2581: invokespecial 1806	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:<init>	()V
    //   2584: astore 32
    //   2586: aload 32
    //   2588: aload 31
    //   2590: getfield 1809	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody$TaskInfo:task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2593: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2596: putfield 1812	com/tencent/mobileqq/config/operation/QQOperationViopTipTask:taskid	I
    //   2599: aload 29
    //   2601: aload 32
    //   2603: invokevirtual 659	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2606: pop
    //   2607: goto -52 -> 2555
    //   2610: astore 29
    //   2612: aload 29
    //   2614: invokevirtual 1813	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2617: goto -115 -> 2502
    //   2620: aload 28
    //   2622: getfield 1816	tencent/im/s2c/msgtype0x210/submsgtype0x54/submsgtype0x54$MsgBody:peer_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   2625: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   2628: lstore_2
    //   2629: iload 4
    //   2631: iconst_1
    //   2632: if_icmpne +20 -> 2652
    //   2635: iconst_0
    //   2636: istore 4
    //   2638: aload_1
    //   2639: lload_2
    //   2640: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2643: iload 4
    //   2645: aload 29
    //   2647: invokevirtual 1819	com/tencent/mobileqq/app/ConfigHandler:a	(Ljava/lang/String;ILjava/util/ArrayList;)V
    //   2650: aconst_null
    //   2651: areturn
    //   2652: sipush 3000
    //   2655: istore 4
    //   2657: goto -19 -> 2638
    //   2660: aload 32
    //   2662: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2665: ldc2_w 1820
    //   2668: lcmp
    //   2669: ifne +21 -> 2690
    //   2672: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2675: ifeq -2646 -> 29
    //   2678: ldc_w 468
    //   2681: iconst_2
    //   2682: ldc_w 1823
    //   2685: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2688: aconst_null
    //   2689: areturn
    //   2690: aload 32
    //   2692: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2695: ldc2_w 1824
    //   2698: lcmp
    //   2699: ifne +160 -> 2859
    //   2702: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2705: ifeq +44 -> 2749
    //   2708: new 88	java/lang/StringBuilder
    //   2711: dup
    //   2712: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2715: ldc_w 1827
    //   2718: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2721: astore_1
    //   2722: aload 32
    //   2724: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2727: ifnull +84 -> 2811
    //   2730: iconst_1
    //   2731: istore 19
    //   2733: ldc_w 1829
    //   2736: iconst_2
    //   2737: aload_1
    //   2738: iload 19
    //   2740: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2743: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2746: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2749: new 1831	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody
    //   2752: dup
    //   2753: invokespecial 1832	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:<init>	()V
    //   2756: astore_1
    //   2757: aload_1
    //   2758: aload 32
    //   2760: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2763: invokevirtual 1833	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2766: pop
    //   2767: aload_1
    //   2768: getfield 1836	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2771: invokevirtual 1837	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   2774: ifeq -2745 -> 29
    //   2777: aload_1
    //   2778: getfield 1836	tencent/im/s2c/msgtype0x210/submsgtype0x67/submsgtype0x67$MsgBody:rpt_msg_grpinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2781: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   2784: astore_1
    //   2785: aload_0
    //   2786: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2789: iconst_3
    //   2790: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2793: checkcast 1839	com/tencent/mobileqq/app/LBSHandler
    //   2796: astore 28
    //   2798: aload 28
    //   2800: ifnull -2771 -> 29
    //   2803: aload 28
    //   2805: aload_1
    //   2806: invokevirtual 1842	com/tencent/mobileqq/app/LBSHandler:a	(Ljava/util/List;)V
    //   2809: aconst_null
    //   2810: areturn
    //   2811: iconst_0
    //   2812: istore 19
    //   2814: goto -81 -> 2733
    //   2817: astore 28
    //   2819: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2822: ifeq -55 -> 2767
    //   2825: ldc_w 1829
    //   2828: iconst_2
    //   2829: new 88	java/lang/StringBuilder
    //   2832: dup
    //   2833: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   2836: ldc_w 1844
    //   2839: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2842: aload 28
    //   2844: invokevirtual 1845	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   2847: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2850: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2853: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2856: goto -89 -> 2767
    //   2859: aload 32
    //   2861: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2864: ldc2_w 1846
    //   2867: lcmp
    //   2868: ifne +27 -> 2895
    //   2871: aload_0
    //   2872: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2875: bipush 21
    //   2877: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2880: checkcast 1849	com/tencent/mobileqq/app/RecommendTroopManagerImp
    //   2883: astore_1
    //   2884: aload_1
    //   2885: ifnull -2856 -> 29
    //   2888: aload_1
    //   2889: invokevirtual 1851	com/tencent/mobileqq/app/RecommendTroopManagerImp:a	()Z
    //   2892: pop
    //   2893: aconst_null
    //   2894: areturn
    //   2895: aload 32
    //   2897: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2900: ldc2_w 1852
    //   2903: lcmp
    //   2904: ifne +90 -> 2994
    //   2907: aload 32
    //   2909: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   2912: ifnull +82 -> 2994
    //   2915: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2918: ifeq +13 -> 2931
    //   2921: ldc_w 468
    //   2924: iconst_2
    //   2925: ldc_w 1855
    //   2928: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2931: aload_0
    //   2932: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2935: ldc_w 1857
    //   2938: ldc 140
    //   2940: ldc 140
    //   2942: ldc_w 1859
    //   2945: ldc_w 1859
    //   2948: iconst_0
    //   2949: iconst_0
    //   2950: ldc 140
    //   2952: ldc 140
    //   2954: ldc 140
    //   2956: ldc 140
    //   2958: invokestatic 986	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2961: new 1861	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody
    //   2964: dup
    //   2965: invokespecial 1862	tencent/im/s2c/msgtype0x210/submsgtype0x63/submsgtype0x63$MsgBody:<init>	()V
    //   2968: pop
    //   2969: new 1864	com/tencent/av/service/QavWrapper
    //   2972: dup
    //   2973: invokestatic 1867	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2976: invokespecial 1870	com/tencent/av/service/QavWrapper:<init>	(Landroid/content/Context;)V
    //   2979: new 1872	ztp
    //   2982: dup
    //   2983: aload_0
    //   2984: aload 32
    //   2986: invokespecial 1875	ztp:<init>	(Lcom/tencent/mobileqq/app/message/OnLinePushMessageProcessor;LIMMsgBodyPack/MsgType0x210;)V
    //   2989: invokevirtual 1878	com/tencent/av/service/QavWrapper:a	(Lcom/tencent/av/service/QavWrapper$OnReadyListener;)V
    //   2992: aconst_null
    //   2993: areturn
    //   2994: aload 32
    //   2996: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   2999: ldc2_w 1879
    //   3002: lcmp
    //   3003: ifne +57 -> 3060
    //   3006: aload 32
    //   3008: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3011: ifnull +49 -> 3060
    //   3014: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3017: ifeq +13 -> 3030
    //   3020: ldc_w 1882
    //   3023: iconst_2
    //   3024: ldc_w 1884
    //   3027: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3030: aload_0
    //   3031: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3034: aload 32
    //   3036: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3039: aload_1
    //   3040: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   3043: aload_1
    //   3044: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3047: aload_1
    //   3048: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3051: aload_1
    //   3052: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   3055: invokestatic 1889	com/tencent/mobileqq/activity/qwallet/QWalletPushManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3058: aconst_null
    //   3059: areturn
    //   3060: aload 32
    //   3062: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3065: ldc2_w 1890
    //   3068: lcmp
    //   3069: ifne +25 -> 3094
    //   3072: aload 32
    //   3074: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3077: ifnull +17 -> 3094
    //   3080: aload_0
    //   3081: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3084: aload 32
    //   3086: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3089: invokestatic 1894	com/tencent/mobileqq/activity/aio/tips/PubAccountTips:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3092: aconst_null
    //   3093: areturn
    //   3094: aload 32
    //   3096: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3099: ldc2_w 1895
    //   3102: lcmp
    //   3103: ifne +57 -> 3160
    //   3106: aload 32
    //   3108: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3111: ifnull +49 -> 3160
    //   3114: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3117: ifeq +13 -> 3130
    //   3120: ldc_w 1882
    //   3123: iconst_2
    //   3124: ldc_w 1898
    //   3127: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3130: aload_0
    //   3131: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3134: aload 32
    //   3136: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3139: aload_1
    //   3140: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   3143: aload_1
    //   3144: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3147: aload_1
    //   3148: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3151: aload_1
    //   3152: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   3155: invokestatic 1900	com/tencent/mobileqq/activity/qwallet/QWalletPushManager:b	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJIJI)V
    //   3158: aconst_null
    //   3159: areturn
    //   3160: aload 32
    //   3162: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3165: ldc2_w 1901
    //   3168: lcmp
    //   3169: ifne +81 -> 3250
    //   3172: aload 32
    //   3174: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3177: ifnull +73 -> 3250
    //   3180: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3183: ifeq +13 -> 3196
    //   3186: ldc_w 1904
    //   3189: iconst_2
    //   3190: ldc_w 1906
    //   3193: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3196: aload_0
    //   3197: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3200: aload 32
    //   3202: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3205: invokestatic 1907	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)V
    //   3208: aload_1
    //   3209: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   3212: lstore_2
    //   3213: aload_1
    //   3214: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3217: istore 4
    //   3219: aload_1
    //   3220: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3223: lstore 15
    //   3225: aload_1
    //   3226: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   3229: istore 5
    //   3231: aload_0
    //   3232: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3235: invokevirtual 1160	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/MessageHandler;
    //   3238: lload_2
    //   3239: iload 4
    //   3241: lload 15
    //   3243: iload 5
    //   3245: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3248: aconst_null
    //   3249: areturn
    //   3250: aload 32
    //   3252: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3255: ldc2_w 1908
    //   3258: lcmp
    //   3259: ifne +433 -> 3692
    //   3262: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3265: ifeq +13 -> 3278
    //   3268: ldc_w 1911
    //   3271: iconst_2
    //   3272: ldc_w 1906
    //   3275: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3278: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3281: ifeq +13 -> 3294
    //   3284: ldc_w 1913
    //   3287: iconst_2
    //   3288: ldc_w 1915
    //   3291: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3294: new 1917	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody
    //   3297: dup
    //   3298: invokespecial 1918	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:<init>	()V
    //   3301: astore 31
    //   3303: aload 31
    //   3305: aload 32
    //   3307: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3310: invokevirtual 1919	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3313: pop
    //   3314: aload 31
    //   3316: getfield 1922	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:uint64_to_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3319: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3322: lstore_2
    //   3323: aload_0
    //   3324: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3327: invokevirtual 1031	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   3330: astore 28
    //   3332: invokestatic 1927	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3335: lload_2
    //   3336: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3339: aconst_null
    //   3340: ldc_w 381
    //   3343: iconst_0
    //   3344: invokestatic 387	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:readValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z
    //   3347: ifne +326 -> 3673
    //   3350: lload_2
    //   3351: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3354: aload 28
    //   3356: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3359: istore 19
    //   3361: iload 19
    //   3363: ifeq +310 -> 3673
    //   3366: aconst_null
    //   3367: astore 28
    //   3369: aconst_null
    //   3370: astore 29
    //   3372: aconst_null
    //   3373: astore 33
    //   3375: aload 31
    //   3377: getfield 1930	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3380: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3383: ifeq +12078 -> 15461
    //   3386: new 264	java/lang/String
    //   3389: dup
    //   3390: aload 31
    //   3392: getfield 1930	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_tips_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3395: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3398: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3401: ldc_w 1200
    //   3404: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3407: astore 30
    //   3409: aload 30
    //   3411: astore 28
    //   3413: aload 31
    //   3415: getfield 1933	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3418: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3421: ifeq +12034 -> 15455
    //   3424: new 264	java/lang/String
    //   3427: dup
    //   3428: aload 31
    //   3430: getfield 1933	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_yes_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3433: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3436: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3439: ldc_w 1200
    //   3442: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3445: astore 30
    //   3447: aload 30
    //   3449: astore 29
    //   3451: aload 31
    //   3453: getfield 1936	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3456: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   3459: ifeq +11990 -> 15449
    //   3462: new 264	java/lang/String
    //   3465: dup
    //   3466: aload 31
    //   3468: getfield 1936	tencent/im/s2c/msgtype0x210/submsgtype0x6b/SubMsgType0x6b$MsgBody:bytes_no_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3471: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3474: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3477: ldc_w 1200
    //   3480: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   3483: astore 30
    //   3485: aload 30
    //   3487: astore 31
    //   3489: aload 28
    //   3491: astore 30
    //   3493: aload 29
    //   3495: astore 32
    //   3497: invokestatic 1927	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3500: lload_2
    //   3501: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3504: aload 30
    //   3506: aload 31
    //   3508: aload 32
    //   3510: invokevirtual 1940	com/tencent/common/app/BaseApplicationImpl:setPCActiveNotice	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   3513: aload_0
    //   3514: sipush 8013
    //   3517: iconst_1
    //   3518: iconst_4
    //   3519: anewarray 209	java/lang/Object
    //   3522: dup
    //   3523: iconst_0
    //   3524: lload_2
    //   3525: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   3528: aastore
    //   3529: dup
    //   3530: iconst_1
    //   3531: aload 30
    //   3533: aastore
    //   3534: dup
    //   3535: iconst_2
    //   3536: aload 31
    //   3538: aastore
    //   3539: dup
    //   3540: iconst_3
    //   3541: aload 32
    //   3543: aastore
    //   3544: invokevirtual 1737	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   3547: aload_1
    //   3548: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   3551: lstore_2
    //   3552: aload_1
    //   3553: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   3556: istore 4
    //   3558: aload_1
    //   3559: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   3562: lstore 15
    //   3564: aload_1
    //   3565: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   3568: istore 5
    //   3570: aload_0
    //   3571: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   3574: lload_2
    //   3575: iload 4
    //   3577: lload 15
    //   3579: iload 5
    //   3581: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   3584: aconst_null
    //   3585: areturn
    //   3586: astore 30
    //   3588: aload 29
    //   3590: astore 32
    //   3592: aload 33
    //   3594: astore 31
    //   3596: aload 28
    //   3598: astore 30
    //   3600: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3603: ifeq -106 -> 3497
    //   3606: ldc_w 1911
    //   3609: iconst_2
    //   3610: ldc_w 1942
    //   3613: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3616: aload 29
    //   3618: astore 32
    //   3620: aload 33
    //   3622: astore 31
    //   3624: aload 28
    //   3626: astore 30
    //   3628: goto -131 -> 3497
    //   3631: astore 28
    //   3633: aload 28
    //   3635: invokevirtual 1813	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   3638: aload_0
    //   3639: sipush 8013
    //   3642: iconst_0
    //   3643: iconst_4
    //   3644: anewarray 209	java/lang/Object
    //   3647: dup
    //   3648: iconst_0
    //   3649: ldc 140
    //   3651: aastore
    //   3652: dup
    //   3653: iconst_1
    //   3654: ldc 140
    //   3656: aastore
    //   3657: dup
    //   3658: iconst_2
    //   3659: ldc 140
    //   3661: aastore
    //   3662: dup
    //   3663: iconst_3
    //   3664: ldc 140
    //   3666: aastore
    //   3667: invokevirtual 1737	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   3670: goto -123 -> 3547
    //   3673: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3676: ifeq -129 -> 3547
    //   3679: ldc_w 1911
    //   3682: iconst_2
    //   3683: ldc_w 1944
    //   3686: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3689: goto -142 -> 3547
    //   3692: ldc2_w 1945
    //   3695: aload 32
    //   3697: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3700: lcmp
    //   3701: ifne +46 -> 3747
    //   3704: aload_0
    //   3705: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3708: aload 32
    //   3710: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3713: invokestatic 1951	com/tencent/biz/TroopRedpoint/TroopRedTouchHandler:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[B)Ltencent/im/oidb/cmd0x791/oidb_0x791$RedDotInfo;
    //   3716: astore_1
    //   3717: aload_1
    //   3718: ifnull -3689 -> 29
    //   3721: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3724: ifeq +13 -> 3737
    //   3727: ldc_w 1953
    //   3730: iconst_2
    //   3731: ldc_w 1955
    //   3734: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3737: aload_0
    //   3738: bipush 105
    //   3740: iconst_1
    //   3741: aload_1
    //   3742: invokevirtual 1737	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   3745: aconst_null
    //   3746: areturn
    //   3747: aload 32
    //   3749: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3752: ldc2_w 1956
    //   3755: lcmp
    //   3756: ifne +26 -> 3782
    //   3759: ldc_w 1959
    //   3762: ldc_w 1961
    //   3765: iconst_0
    //   3766: iconst_0
    //   3767: iconst_1
    //   3768: anewarray 264	java/lang/String
    //   3771: dup
    //   3772: iconst_0
    //   3773: ldc_w 1963
    //   3776: aastore
    //   3777: invokestatic 1968	com/tencent/biz/qqstory/support/report/StoryReportor:a	(Ljava/lang/String;Ljava/lang/String;II[Ljava/lang/String;)V
    //   3780: aconst_null
    //   3781: areturn
    //   3782: aload 32
    //   3784: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   3787: ldc2_w 1969
    //   3790: lcmp
    //   3791: ifne +1672 -> 5463
    //   3794: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3797: ifeq +13 -> 3810
    //   3800: ldc_w 1972
    //   3803: iconst_2
    //   3804: ldc_w 1906
    //   3807: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3810: new 1974	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody
    //   3813: dup
    //   3814: invokespecial 1975	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:<init>	()V
    //   3817: astore 29
    //   3819: aload 29
    //   3821: aload 32
    //   3823: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   3826: invokevirtual 1976	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3829: pop
    //   3830: iconst_0
    //   3831: istore 4
    //   3833: iload 4
    //   3835: aload 29
    //   3837: getfield 1979	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3840: invokevirtual 1980	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3843: if_icmpge -3814 -> 29
    //   3846: aload 29
    //   3848: getfield 1979	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MsgBody:rpt_msg_mod_infos	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3851: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   3854: iload 4
    //   3856: invokeinterface 850 2 0
    //   3861: checkcast 1982	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody
    //   3864: astore 28
    //   3866: iconst_m1
    //   3867: istore 5
    //   3869: aload 28
    //   3871: getfield 1985	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3874: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3877: ifeq +13 -> 3890
    //   3880: aload 28
    //   3882: getfield 1985	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3885: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3888: istore 5
    //   3890: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3893: ifeq +31 -> 3924
    //   3896: ldc_w 1972
    //   3899: iconst_2
    //   3900: new 88	java/lang/StringBuilder
    //   3903: dup
    //   3904: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   3907: ldc_w 1987
    //   3910: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3913: iload 5
    //   3915: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3918: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3921: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3924: iload 5
    //   3926: sipush 2001
    //   3929: if_icmpne +263 -> 4192
    //   3932: aload 28
    //   3934: getfield 1991	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3937: invokevirtual 1994	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:has	()Z
    //   3940: ifeq +252 -> 4192
    //   3943: aload 28
    //   3945: getfield 1991	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mcard_notification_like	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;
    //   3948: invokevirtual 1995	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3951: checkcast 1993	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike
    //   3954: astore 30
    //   3956: ldc 140
    //   3958: astore 28
    //   3960: lconst_0
    //   3961: lstore_2
    //   3962: iconst_0
    //   3963: istore 6
    //   3965: iconst_0
    //   3966: istore 5
    //   3968: aload 30
    //   3970: getfield 1998	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3973: invokevirtual 1999	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3976: ifeq +13 -> 3989
    //   3979: aload 30
    //   3981: getfield 1998	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:str_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3984: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3987: astore 28
    //   3989: aload 30
    //   3991: getfield 2002	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3994: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3997: ifeq +13 -> 4010
    //   4000: aload 30
    //   4002: getfield 2002	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_new	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4005: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4008: istore 5
    //   4010: aload 30
    //   4012: getfield 2003	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4015: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4018: ifeq +12 -> 4030
    //   4021: aload 30
    //   4023: getfield 2003	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint64_from_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4026: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4029: lstore_2
    //   4030: aload 30
    //   4032: getfield 2006	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4035: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4038: ifeq +13 -> 4051
    //   4041: aload 30
    //   4043: getfield 2006	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike:uint32_counter_total	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4046: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4049: istore 6
    //   4051: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4054: ifeq +63 -> 4117
    //   4057: ldc_w 1972
    //   4060: iconst_2
    //   4061: new 88	java/lang/StringBuilder
    //   4064: dup
    //   4065: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4068: ldc_w 2008
    //   4071: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4074: aload 28
    //   4076: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4079: ldc_w 2010
    //   4082: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4085: iload 6
    //   4087: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4090: ldc_w 2012
    //   4093: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4096: iload 5
    //   4098: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4101: ldc_w 2014
    //   4104: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4107: lload_2
    //   4108: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4111: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4114: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4117: aload_0
    //   4118: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4121: bipush 70
    //   4123: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4126: checkcast 2016	com/tencent/mobileqq/dating/DatingProxyManager
    //   4129: astore 28
    //   4131: aload 28
    //   4133: ifnull +13 -> 4146
    //   4136: aload 28
    //   4138: invokevirtual 2019	com/tencent/mobileqq/dating/DatingProxyManager:a	()Lcom/tencent/mobileqq/dating/widget/VoteEventMgr;
    //   4141: aload 30
    //   4143: invokevirtual 2024	com/tencent/mobileqq/dating/widget/VoteEventMgr:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$MCardNotificationLike;)V
    //   4146: aload_1
    //   4147: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   4150: lstore_2
    //   4151: aload_1
    //   4152: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   4155: istore 5
    //   4157: aload_1
    //   4158: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   4161: lstore 15
    //   4163: aload_1
    //   4164: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   4167: istore 6
    //   4169: aload_0
    //   4170: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   4173: lload_2
    //   4174: iload 5
    //   4176: lload 15
    //   4178: iload 6
    //   4180: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   4183: iload 4
    //   4185: iconst_1
    //   4186: iadd
    //   4187: istore 4
    //   4189: goto -356 -> 3833
    //   4192: iload 5
    //   4194: sipush 2002
    //   4197: if_icmpne +450 -> 4647
    //   4200: aload 28
    //   4202: getfield 2028	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4205: invokevirtual 2031	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:has	()Z
    //   4208: ifeq +439 -> 4647
    //   4211: aload 28
    //   4213: getfield 2028	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_vip_info_notify	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify;
    //   4216: invokevirtual 2032	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4219: checkcast 2030	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify
    //   4222: astore 30
    //   4224: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4227: ifeq +34 -> 4261
    //   4230: ldc_w 468
    //   4233: iconst_2
    //   4234: new 88	java/lang/StringBuilder
    //   4237: dup
    //   4238: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4241: ldc_w 2034
    //   4244: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4247: aload 30
    //   4249: invokevirtual 2035	java/lang/Object:toString	()Ljava/lang/String;
    //   4252: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4255: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4258: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4261: lconst_0
    //   4262: lstore_2
    //   4263: aload 30
    //   4265: getfield 2036	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4268: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4271: ifeq +12 -> 4283
    //   4274: aload 30
    //   4276: getfield 2036	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4279: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4282: lstore_2
    //   4283: lload_2
    //   4284: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4287: astore 28
    //   4289: aload 30
    //   4291: getfield 2039	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4294: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4297: ifeq +11146 -> 15443
    //   4300: aload 30
    //   4302: getfield 2039	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4305: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4308: istore 5
    //   4310: aload 30
    //   4312: getfield 2042	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4315: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4318: ifeq +11119 -> 15437
    //   4321: aload 30
    //   4323: getfield 2042	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4326: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4329: istore 6
    //   4331: iconst_m1
    //   4332: istore 7
    //   4334: iconst_m1
    //   4335: istore 8
    //   4337: aload 30
    //   4339: getfield 2045	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4342: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4345: ifeq +13 -> 4358
    //   4348: aload 30
    //   4350: getfield 2045	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_red_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4353: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4356: istore 7
    //   4358: aload 30
    //   4360: getfield 2048	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4363: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4366: ifeq +13 -> 4379
    //   4369: aload 30
    //   4371: getfield 2048	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_disable_red_envelope	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4374: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4377: istore 8
    //   4379: aload 30
    //   4381: getfield 2051	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_redpack_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4384: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4387: istore 9
    //   4389: aload 30
    //   4391: getfield 2054	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:str_redpack_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4394: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4397: astore 30
    //   4399: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4402: ifeq +11065 -> 15467
    //   4405: ldc_w 468
    //   4408: iconst_2
    //   4409: new 88	java/lang/StringBuilder
    //   4412: dup
    //   4413: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4416: ldc_w 2056
    //   4419: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4422: iload 9
    //   4424: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4427: ldc_w 2058
    //   4430: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4433: aload 30
    //   4435: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4438: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4441: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4444: goto +11023 -> 15467
    //   4447: aload_0
    //   4448: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4451: sipush 130
    //   4454: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4457: checkcast 2060	com/tencent/mobileqq/app/IndividualRedPacketManager
    //   4460: astore 31
    //   4462: aload 31
    //   4464: iload 7
    //   4466: iload 8
    //   4468: iconst_1
    //   4469: invokevirtual 2063	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(IIZ)V
    //   4472: aload 31
    //   4474: iload 9
    //   4476: aload 30
    //   4478: invokevirtual 2066	com/tencent/mobileqq/app/IndividualRedPacketManager:a	(ILjava/lang/String;)V
    //   4481: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4484: ifeq +10996 -> 15480
    //   4487: ldc_w 468
    //   4490: iconst_2
    //   4491: new 88	java/lang/StringBuilder
    //   4494: dup
    //   4495: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4498: ldc_w 2068
    //   4501: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4504: aload 28
    //   4506: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4509: ldc_w 2070
    //   4512: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4515: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4518: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4521: goto +10959 -> 15480
    //   4524: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4527: ifeq +42 -> 4569
    //   4530: ldc_w 468
    //   4533: iconst_2
    //   4534: new 88	java/lang/StringBuilder
    //   4537: dup
    //   4538: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4541: ldc_w 2072
    //   4544: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4547: iload 5
    //   4549: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4552: ldc_w 2074
    //   4555: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4558: iload 6
    //   4560: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4563: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4566: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4569: aload_0
    //   4570: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4573: iconst_2
    //   4574: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4577: checkcast 763	mqq/manager/TicketManager
    //   4580: aload 28
    //   4582: invokeinterface 767 2 0
    //   4587: astore 30
    //   4589: aload_0
    //   4590: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4593: bipush 27
    //   4595: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4598: checkcast 769	com/tencent/mobileqq/app/VipInfoHandler
    //   4601: aload 30
    //   4603: aload 28
    //   4605: invokevirtual 772	com/tencent/mobileqq/app/VipInfoHandler:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   4608: goto -462 -> 4146
    //   4611: astore_1
    //   4612: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4615: ifeq -4586 -> 29
    //   4618: ldc_w 1972
    //   4621: iconst_2
    //   4622: new 88	java/lang/StringBuilder
    //   4625: dup
    //   4626: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4629: ldc_w 2076
    //   4632: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4635: aload_1
    //   4636: invokevirtual 2079	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4639: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4642: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4645: aconst_null
    //   4646: areturn
    //   4647: iload 5
    //   4649: sipush 2003
    //   4652: if_icmpne +155 -> 4807
    //   4655: aload 28
    //   4657: getfield 2083	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4660: invokevirtual 2086	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:has	()Z
    //   4663: ifeq +144 -> 4807
    //   4666: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4669: ifeq +13 -> 4682
    //   4672: ldc_w 2088
    //   4675: iconst_2
    //   4676: ldc_w 2090
    //   4679: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4682: aload 28
    //   4684: getfield 2083	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_push_lost_dev_found	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound;
    //   4687: invokevirtual 2091	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4690: checkcast 2085	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound
    //   4693: astore 28
    //   4695: new 875	android/os/Bundle
    //   4698: dup
    //   4699: invokespecial 876	android/os/Bundle:<init>	()V
    //   4702: astore 30
    //   4704: aload 28
    //   4706: getfield 2094	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4709: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4712: ifeq +19 -> 4731
    //   4715: aload 30
    //   4717: ldc_w 2096
    //   4720: aload 28
    //   4722: getfield 2094	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_msg_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4725: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4728: invokevirtual 931	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4731: aload 28
    //   4733: getfield 2099	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4736: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4739: ifeq +19 -> 4758
    //   4742: aload 30
    //   4744: ldc_w 2101
    //   4747: aload 28
    //   4749: getfield 2099	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint32_dev_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4752: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4755: invokevirtual 931	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4758: aload 28
    //   4760: getfield 2104	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4763: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4766: ifeq +19 -> 4785
    //   4769: aload 30
    //   4771: ldc_w 2106
    //   4774: aload 28
    //   4776: getfield 2104	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$PushLostDevFound:uint64_din	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4779: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4782: invokevirtual 2110	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   4785: aload_0
    //   4786: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4789: bipush 51
    //   4791: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4794: checkcast 2112	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   4797: bipush 111
    //   4799: aload 30
    //   4801: invokevirtual 2115	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	(ILandroid/os/Bundle;)V
    //   4804: goto -658 -> 4146
    //   4807: iload 5
    //   4809: sipush 2007
    //   4812: if_icmpne +50 -> 4862
    //   4815: aload 28
    //   4817: getfield 2119	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_babyq_reward_info	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo;
    //   4820: invokevirtual 2122	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$RewardInfo:has	()Z
    //   4823: ifeq +39 -> 4862
    //   4826: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4829: ifeq +13 -> 4842
    //   4832: ldc_w 468
    //   4835: iconst_2
    //   4836: ldc_w 2124
    //   4839: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4842: aload_0
    //   4843: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4846: bipush 53
    //   4848: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4851: checkcast 2126	com/tencent/mobileqq/app/BabyQHandler
    //   4854: aload 28
    //   4856: invokevirtual 2129	com/tencent/mobileqq/app/BabyQHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody;)V
    //   4859: goto -713 -> 4146
    //   4862: iload 5
    //   4864: sipush 2011
    //   4867: if_icmpne -721 -> 4146
    //   4870: aload 28
    //   4872: getfield 2133	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   4875: invokevirtual 2136	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:has	()Z
    //   4878: ifeq -732 -> 4146
    //   4881: aload 28
    //   4883: getfield 2133	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$ForwardBody:msg_mod_qim_friend_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ;
    //   4886: invokevirtual 2137	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4889: checkcast 2135	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ
    //   4892: astore 28
    //   4894: iconst_m1
    //   4895: istore 5
    //   4897: aload 28
    //   4899: getfield 2140	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4902: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4905: ifeq +13 -> 4918
    //   4908: aload 28
    //   4910: getfield 2140	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:uint32_notify_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4913: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4916: istore 5
    //   4918: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4921: ifeq +31 -> 4952
    //   4924: ldc_w 2142
    //   4927: iconst_2
    //   4928: new 88	java/lang/StringBuilder
    //   4931: dup
    //   4932: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   4935: ldc_w 2144
    //   4938: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4941: iload 5
    //   4943: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4946: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4949: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4952: iload 5
    //   4954: iconst_1
    //   4955: if_icmpne +190 -> 5145
    //   4958: aload 28
    //   4960: getfield 2148	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   4963: invokevirtual 2151	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:has	()Z
    //   4966: ifeq -820 -> 4146
    //   4969: aload 28
    //   4971: getfield 2148	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ;
    //   4974: astore 28
    //   4976: new 2153	com/tencent/mobileqq/data/QIMFollwerAdd
    //   4979: dup
    //   4980: invokespecial 2154	com/tencent/mobileqq/data/QIMFollwerAdd:<init>	()V
    //   4983: astore 30
    //   4985: aload 30
    //   4987: aload 28
    //   4989: getfield 2155	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4992: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4995: putfield 2157	com/tencent/mobileqq/data/QIMFollwerAdd:uin	J
    //   4998: aload 30
    //   5000: aload 28
    //   5002: getfield 2160	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5005: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5008: putfield 2163	com/tencent/mobileqq/data/QIMFollwerAdd:gender	I
    //   5011: aload 30
    //   5013: aload 28
    //   5015: getfield 2166	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_cares_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5018: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5021: putfield 2169	com/tencent/mobileqq/data/QIMFollwerAdd:careSCount	J
    //   5024: aload 30
    //   5026: aload 28
    //   5028: getfield 2172	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5031: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5034: putfield 2175	com/tencent/mobileqq/data/QIMFollwerAdd:totalNum	J
    //   5037: aload 30
    //   5039: aload 28
    //   5041: getfield 2178	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_smart_remark	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5044: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5047: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5050: putfield 2181	com/tencent/mobileqq/data/QIMFollwerAdd:smartRemark	Ljava/lang/String;
    //   5053: aload 30
    //   5055: aload 28
    //   5057: getfield 2182	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint32_op_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5060: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5063: putfield 2185	com/tencent/mobileqq/data/QIMFollwerAdd:opType	I
    //   5066: aload 30
    //   5068: aload 28
    //   5070: getfield 2188	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:uint64_fans_count	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5073: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5076: putfield 2191	com/tencent/mobileqq/data/QIMFollwerAdd:fansCount	J
    //   5079: aload 30
    //   5081: aload 28
    //   5083: getfield 2194	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_longnick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5086: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5089: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   5092: invokestatic 2200	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   5095: invokevirtual 2203	com/tencent/mobileqq/richstatus/RichStatus:getPlainText	()Ljava/lang/String;
    //   5098: putfield 2206	com/tencent/mobileqq/data/QIMFollwerAdd:longNick	Ljava/lang/String;
    //   5101: aload 30
    //   5103: invokestatic 869	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   5106: putfield 2209	com/tencent/mobileqq/data/QIMFollwerAdd:upTime	J
    //   5109: aload 30
    //   5111: aload 28
    //   5113: getfield 2212	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimFriendNotifyToQQ:bytes_src_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5116: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5119: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5122: putfield 2214	com/tencent/mobileqq/data/QIMFollwerAdd:source	Ljava/lang/String;
    //   5125: aload_0
    //   5126: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5129: bipush 33
    //   5131: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5134: checkcast 2216	com/tencent/mobileqq/app/NewFriendManager
    //   5137: aload 30
    //   5139: invokevirtual 2219	com/tencent/mobileqq/app/NewFriendManager:b	(Lcom/tencent/mobileqq/data/QIMFollwerAdd;)V
    //   5142: goto -996 -> 4146
    //   5145: iload 5
    //   5147: iconst_2
    //   5148: if_icmpeq -1002 -> 4146
    //   5151: iload 5
    //   5153: iconst_3
    //   5154: if_icmpne -1008 -> 4146
    //   5157: aload 28
    //   5159: getfield 2223	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5162: invokevirtual 2226	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:has	()Z
    //   5165: ifeq -1019 -> 4146
    //   5168: aload 28
    //   5170: getfield 2223	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$QimFriendNotifyToQQ:msg_add_not_login_frd_notify_to_qq	Ltencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ;
    //   5173: invokevirtual 2227	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5176: checkcast 2225	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ
    //   5179: astore 28
    //   5181: new 2229	com/tencent/mobileqq/data/QIMNotifyAddFriend
    //   5184: dup
    //   5185: invokespecial 2230	com/tencent/mobileqq/data/QIMNotifyAddFriend:<init>	()V
    //   5188: astore 30
    //   5190: aload 30
    //   5192: aload 28
    //   5194: getfield 2231	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5197: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5200: putfield 2232	com/tencent/mobileqq/data/QIMNotifyAddFriend:uin	J
    //   5203: aload 30
    //   5205: aload 28
    //   5207: getfield 2235	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_qq_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5210: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5213: putfield 2238	com/tencent/mobileqq/data/QIMNotifyAddFriend:qqUin	J
    //   5216: aload 30
    //   5218: aload 28
    //   5220: getfield 2241	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5223: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5226: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5229: putfield 2244	com/tencent/mobileqq/data/QIMNotifyAddFriend:nickName	Ljava/lang/String;
    //   5232: aload 30
    //   5234: aload 28
    //   5236: getfield 2245	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_gender	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5239: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5242: putfield 2246	com/tencent/mobileqq/data/QIMNotifyAddFriend:gender	I
    //   5245: aload 30
    //   5247: aload 28
    //   5249: getfield 2249	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5252: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5255: putfield 2252	com/tencent/mobileqq/data/QIMNotifyAddFriend:age	I
    //   5258: aload 30
    //   5260: aload 28
    //   5262: getfield 2255	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_coverstory	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5265: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5268: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5271: putfield 2258	com/tencent/mobileqq/data/QIMNotifyAddFriend:coverStory	Ljava/lang/String;
    //   5274: aload 30
    //   5276: aload 28
    //   5278: getfield 2259	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:uint64_storys_total_num	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   5281: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   5284: putfield 2262	com/tencent/mobileqq/data/QIMNotifyAddFriend:storyTotalNum	J
    //   5287: aload 30
    //   5289: aload 28
    //   5291: getfield 2265	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5294: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5297: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5300: putfield 2267	com/tencent/mobileqq/data/QIMNotifyAddFriend:wording	Ljava/lang/String;
    //   5303: iconst_0
    //   5304: istore 5
    //   5306: iload 5
    //   5308: aload 28
    //   5310: getfield 2270	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5313: invokevirtual 1980	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   5316: if_icmpge +81 -> 5397
    //   5319: aload 28
    //   5321: getfield 2270	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$AddQimNotLoginFrdNotifyToQQ:rpt_msg_video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5324: iload 5
    //   5326: invokevirtual 2273	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5329: checkcast 2275	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo
    //   5332: astore 31
    //   5334: new 2277	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo
    //   5337: dup
    //   5338: invokespecial 2278	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:<init>	()V
    //   5341: astore 32
    //   5343: aload 32
    //   5345: aload 31
    //   5347: getfield 2281	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_video_cover_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5350: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5353: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5356: putfield 2284	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:coverUrl	Ljava/lang/String;
    //   5359: aload 32
    //   5361: aload 31
    //   5363: getfield 2287	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VideoInfo:bytes_vid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   5366: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   5369: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   5372: putfield 2290	com/tencent/mobileqq/data/QIMNotifyAddFriend$VideoInfo:videoVid	Ljava/lang/String;
    //   5375: aload 30
    //   5377: getfield 2294	com/tencent/mobileqq/data/QIMNotifyAddFriend:videoInfos	Ljava/util/List;
    //   5380: aload 32
    //   5382: invokeinterface 2295 2 0
    //   5387: pop
    //   5388: iload 5
    //   5390: iconst_1
    //   5391: iadd
    //   5392: istore 5
    //   5394: goto -88 -> 5306
    //   5397: aload 30
    //   5399: invokestatic 869	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   5402: putfield 2298	com/tencent/mobileqq/data/QIMNotifyAddFriend:pushTime	J
    //   5405: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5408: ifeq +34 -> 5442
    //   5411: ldc_w 2142
    //   5414: iconst_2
    //   5415: new 88	java/lang/StringBuilder
    //   5418: dup
    //   5419: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5422: ldc_w 2300
    //   5425: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5428: aload 30
    //   5430: invokevirtual 2301	com/tencent/mobileqq/data/QIMNotifyAddFriend:toString	()Ljava/lang/String;
    //   5433: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5436: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5439: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5442: aload_0
    //   5443: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5446: sipush 256
    //   5449: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5452: checkcast 2303	com/tencent/mobileqq/app/QIMNewFriendManager
    //   5455: aload 30
    //   5457: invokevirtual 2306	com/tencent/mobileqq/app/QIMNewFriendManager:a	(Lcom/tencent/mobileqq/data/QIMNotifyAddFriend;)V
    //   5460: goto -1314 -> 4146
    //   5463: aload 32
    //   5465: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5468: ldc2_w 2307
    //   5471: lcmp
    //   5472: ifne +319 -> 5791
    //   5475: new 2310	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody
    //   5478: dup
    //   5479: invokespecial 2311	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:<init>	()V
    //   5482: astore_1
    //   5483: aload_1
    //   5484: aload 32
    //   5486: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5489: invokevirtual 2312	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5492: pop
    //   5493: aload_1
    //   5494: getfield 2313	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5497: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5500: istore 4
    //   5502: iload 4
    //   5504: sipush 1004
    //   5507: if_icmpne +56 -> 5563
    //   5510: aload_0
    //   5511: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5514: bipush 78
    //   5516: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5519: checkcast 2315	com/tencent/mobileqq/portal/PortalManager
    //   5522: astore 28
    //   5524: aload 28
    //   5526: ifnull -5497 -> 29
    //   5529: aload 28
    //   5531: aload_1
    //   5532: invokevirtual 2318	com/tencent/mobileqq/portal/PortalManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5535: aconst_null
    //   5536: areturn
    //   5537: astore_1
    //   5538: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5541: ifeq +13 -> 5554
    //   5544: ldc_w 2320
    //   5547: iconst_2
    //   5548: ldc 140
    //   5550: aload_1
    //   5551: invokestatic 2322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   5554: new 2324	java/lang/RuntimeException
    //   5557: dup
    //   5558: aload_1
    //   5559: invokespecial 2327	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   5562: athrow
    //   5563: iload 4
    //   5565: bipush 49
    //   5567: if_icmpne +26 -> 5593
    //   5570: aload_0
    //   5571: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5574: aload_0
    //   5575: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5578: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5581: aload_1
    //   5582: getfield 2330	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5585: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5588: invokestatic 2335	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5591: aconst_null
    //   5592: areturn
    //   5593: iload 4
    //   5595: bipush 46
    //   5597: if_icmpne +29 -> 5626
    //   5600: aload_0
    //   5601: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5604: aload_0
    //   5605: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5608: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5611: aload_1
    //   5612: getfield 2330	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5615: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5618: ldc_w 2337
    //   5621: invokestatic 2342	com/tencent/hotpatch/config/PatchConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;ILjava/lang/String;)V
    //   5624: aconst_null
    //   5625: areturn
    //   5626: iload 4
    //   5628: sipush 1003
    //   5631: if_icmpne +22 -> 5653
    //   5634: aload_0
    //   5635: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5638: sipush 166
    //   5641: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5644: checkcast 2344	com/tencent/mobileqq/olympic/OlympicManager
    //   5647: aload_1
    //   5648: invokevirtual 2345	com/tencent/mobileqq/olympic/OlympicManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody;)V
    //   5651: aconst_null
    //   5652: areturn
    //   5653: iload 4
    //   5655: sipush 133
    //   5658: if_icmpne +26 -> 5684
    //   5661: aload_0
    //   5662: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5665: aload_0
    //   5666: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5669: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5672: aload_1
    //   5673: getfield 2330	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5676: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5679: invokestatic 2347	com/tencent/mobileqq/config/splashlogo/ConfigServlet:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   5682: aconst_null
    //   5683: areturn
    //   5684: iload 4
    //   5686: sipush 222
    //   5689: if_icmpne -5660 -> 29
    //   5692: aload_0
    //   5693: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5696: invokevirtual 2351	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   5699: ldc_w 2353
    //   5702: iconst_0
    //   5703: invokeinterface 374 3 0
    //   5708: istore 4
    //   5710: iload 4
    //   5712: aload_1
    //   5713: getfield 2330	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5716: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5719: if_icmpeq +20 -> 5739
    //   5722: aload_0
    //   5723: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5726: sipush 222
    //   5729: aload_0
    //   5730: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5733: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5736: invokestatic 2356	com/tencent/mobileqq/config/splashlogo/ConfigServlet:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ILjava/lang/String;)V
    //   5739: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5742: ifeq -5713 -> 29
    //   5745: ldc_w 468
    //   5748: iconst_2
    //   5749: new 88	java/lang/StringBuilder
    //   5752: dup
    //   5753: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5756: ldc_w 2358
    //   5759: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5762: iload 4
    //   5764: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5767: ldc_w 2360
    //   5770: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5773: aload_1
    //   5774: getfield 2330	tencent/im/s2c/msgtype0x210/submsgtype0x78/submsgtype0x78$MsgBody:uint32_version	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5777: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5780: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5783: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5786: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5789: aconst_null
    //   5790: areturn
    //   5791: aload 32
    //   5793: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5796: ldc2_w 2361
    //   5799: lcmp
    //   5800: ifne +36 -> 5836
    //   5803: aload_0
    //   5804: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5807: bipush 35
    //   5809: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5812: checkcast 2364	com/tencent/mobileqq/redtouch/RedTouchManager
    //   5815: aload 32
    //   5817: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5820: invokevirtual 2367	com/tencent/mobileqq/redtouch/RedTouchManager:a	([B)Z
    //   5823: ifeq -5794 -> 29
    //   5826: aload_0
    //   5827: bipush 113
    //   5829: iconst_1
    //   5830: aconst_null
    //   5831: invokevirtual 1737	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(IZLjava/lang/Object;)V
    //   5834: aconst_null
    //   5835: areturn
    //   5836: aload 32
    //   5838: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5841: ldc2_w 2368
    //   5844: lcmp
    //   5845: ifne +25 -> 5870
    //   5848: aload_0
    //   5849: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5852: bipush 63
    //   5854: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5857: checkcast 2371	com/tencent/mobileqq/redtouch/NumRedPointManager
    //   5860: aload 32
    //   5862: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5865: invokevirtual 2372	com/tencent/mobileqq/redtouch/NumRedPointManager:a	([B)V
    //   5868: aconst_null
    //   5869: areturn
    //   5870: aload 32
    //   5872: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5875: ldc2_w 2373
    //   5878: lcmp
    //   5879: ifne +148 -> 6027
    //   5882: aload_1
    //   5883: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   5886: lstore 15
    //   5888: aload_1
    //   5889: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   5892: istore 4
    //   5894: aload_1
    //   5895: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   5898: lstore 17
    //   5900: aload_1
    //   5901: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   5904: istore 5
    //   5906: aload 32
    //   5908: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   5911: l2i
    //   5912: istore 6
    //   5914: aload_0
    //   5915: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5918: bipush 84
    //   5920: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5923: checkcast 2376	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   5926: aload_1
    //   5927: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   5930: invokevirtual 2378	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(I)Z
    //   5933: ifeq +56 -> 5989
    //   5936: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5939: ifeq +33 -> 5972
    //   5942: ldc_w 468
    //   5945: iconst_2
    //   5946: new 88	java/lang/StringBuilder
    //   5949: dup
    //   5950: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   5953: ldc_w 2380
    //   5956: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5959: aload_1
    //   5960: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   5963: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5966: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5969: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5972: aload_0
    //   5973: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   5976: lload 15
    //   5978: iload 4
    //   5980: lload 17
    //   5982: iload 5
    //   5984: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   5987: aconst_null
    //   5988: areturn
    //   5989: aload_0
    //   5990: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5993: aload 32
    //   5995: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   5998: lload 15
    //   6000: lload_2
    //   6001: iload 4
    //   6003: iload 5
    //   6005: iload 6
    //   6007: invokestatic 2383	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BJJIII)Z
    //   6010: ifeq -38 -> 5972
    //   6013: aload_0
    //   6014: ldc_w 2385
    //   6017: iconst_1
    //   6018: iconst_1
    //   6019: iconst_1
    //   6020: iconst_0
    //   6021: invokevirtual 1338	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(Ljava/lang/String;ZIZZ)V
    //   6024: goto -52 -> 5972
    //   6027: aload 32
    //   6029: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6032: ldc2_w 2386
    //   6035: lcmp
    //   6036: ifne +25 -> 6061
    //   6039: aload_0
    //   6040: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6043: bipush 47
    //   6045: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   6048: checkcast 2389	com/tencent/mobileqq/app/QPayHandler
    //   6051: aload 32
    //   6053: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6056: invokevirtual 2390	com/tencent/mobileqq/app/QPayHandler:a	([B)V
    //   6059: aconst_null
    //   6060: areturn
    //   6061: aload 32
    //   6063: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6066: ldc2_w 2391
    //   6069: lcmp
    //   6070: ifne +271 -> 6341
    //   6073: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6076: ifeq +46 -> 6122
    //   6079: ldc_w 2397
    //   6082: iconst_4
    //   6083: new 88	java/lang/StringBuilder
    //   6086: dup
    //   6087: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6090: ldc_w 2399
    //   6093: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6096: aload_1
    //   6097: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6100: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6103: ldc_w 2401
    //   6106: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6109: aload_1
    //   6110: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6113: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6116: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6119: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6122: new 2403	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody
    //   6125: dup
    //   6126: invokespecial 2404	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:<init>	()V
    //   6129: astore_1
    //   6130: aload_1
    //   6131: aload 32
    //   6133: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6136: invokevirtual 2405	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6139: pop
    //   6140: aload_1
    //   6141: getfield 2408	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6144: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6147: pop
    //   6148: aload_1
    //   6149: getfield 2411	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_undeal_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6152: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6155: istore 4
    //   6157: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6160: ifeq +31 -> 6191
    //   6163: ldc_w 2397
    //   6166: iconst_2
    //   6167: new 88	java/lang/StringBuilder
    //   6170: dup
    //   6171: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6174: ldc_w 2413
    //   6177: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6180: iload 4
    //   6182: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6185: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6188: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6191: ldc_w 2415
    //   6194: iconst_m1
    //   6195: aload_0
    //   6196: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6199: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6202: invokestatic 2421	cooperation/qzone/LocalMultiProcConfig:getInt4Uin	(Ljava/lang/String;IJ)I
    //   6205: istore 5
    //   6207: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6210: ifeq +47 -> 6257
    //   6213: ldc_w 468
    //   6216: iconst_2
    //   6217: new 88	java/lang/StringBuilder
    //   6220: dup
    //   6221: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6224: ldc_w 2423
    //   6227: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6230: aload_0
    //   6231: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6234: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6237: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6240: ldc_w 2425
    //   6243: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6246: iload 5
    //   6248: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6251: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6254: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6257: iload 5
    //   6259: iconst_1
    //   6260: if_icmpne -6231 -> 29
    //   6263: aload_0
    //   6264: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6267: bipush 9
    //   6269: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6272: checkcast 2427	com/tencent/mobileqq/servlet/QZoneManagerImp
    //   6275: astore_1
    //   6276: new 655	java/util/ArrayList
    //   6279: dup
    //   6280: invokespecial 656	java/util/ArrayList:<init>	()V
    //   6283: astore 28
    //   6285: new 2429	cooperation/qzone/UndealCount/QZoneCountUserInfo
    //   6288: dup
    //   6289: invokespecial 2430	cooperation/qzone/UndealCount/QZoneCountUserInfo:<init>	()V
    //   6292: astore 29
    //   6294: aload 29
    //   6296: aload_0
    //   6297: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6300: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6303: putfield 2431	cooperation/qzone/UndealCount/QZoneCountUserInfo:a	J
    //   6306: aload 28
    //   6308: aload 29
    //   6310: invokevirtual 659	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6313: pop
    //   6314: aload_1
    //   6315: bipush 17
    //   6317: iload 4
    //   6319: i2l
    //   6320: aload 28
    //   6322: ldc 140
    //   6324: iconst_0
    //   6325: iconst_1
    //   6326: ldc 140
    //   6328: invokevirtual 2434	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(IJLjava/util/ArrayList;Ljava/lang/String;ZZLjava/lang/String;)Z
    //   6331: pop
    //   6332: aconst_null
    //   6333: areturn
    //   6334: astore_1
    //   6335: aload_1
    //   6336: invokevirtual 1813	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   6339: aconst_null
    //   6340: areturn
    //   6341: aload 32
    //   6343: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6346: ldc2_w 2435
    //   6349: lcmp
    //   6350: ifne +134 -> 6484
    //   6353: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6356: ifeq +46 -> 6402
    //   6359: ldc_w 468
    //   6362: iconst_4
    //   6363: new 88	java/lang/StringBuilder
    //   6366: dup
    //   6367: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6370: ldc_w 2438
    //   6373: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6376: aload_1
    //   6377: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6380: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6383: ldc_w 2401
    //   6386: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6389: aload_1
    //   6390: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6393: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6396: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6399: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6402: new 2440	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody
    //   6405: dup
    //   6406: invokespecial 2441	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:<init>	()V
    //   6409: astore_1
    //   6410: aload_1
    //   6411: aload 32
    //   6413: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6416: invokevirtual 2442	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6419: pop
    //   6420: aload_1
    //   6421: getfield 2443	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6424: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6427: lstore_2
    //   6428: aload_0
    //   6429: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6432: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6435: lload_2
    //   6436: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6439: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6442: ifeq -6413 -> 29
    //   6445: aload_0
    //   6446: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6449: bipush 93
    //   6451: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6454: checkcast 2445	com/tencent/mobileqq/secspy/SecSpyFileManager
    //   6457: aload_1
    //   6458: iconst_3
    //   6459: invokevirtual 2448	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;I)V
    //   6462: aconst_null
    //   6463: areturn
    //   6464: astore_1
    //   6465: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6468: ifeq -6439 -> 29
    //   6471: ldc_w 468
    //   6474: iconst_2
    //   6475: ldc_w 2450
    //   6478: aload_1
    //   6479: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6482: aconst_null
    //   6483: areturn
    //   6484: aload 32
    //   6486: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6489: ldc2_w 2451
    //   6492: lcmp
    //   6493: ifne +143 -> 6636
    //   6496: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6499: ifeq +46 -> 6545
    //   6502: ldc_w 468
    //   6505: iconst_4
    //   6506: new 88	java/lang/StringBuilder
    //   6509: dup
    //   6510: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6513: ldc_w 2454
    //   6516: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6519: aload_1
    //   6520: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6523: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6526: ldc_w 2401
    //   6529: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6532: aload_1
    //   6533: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6536: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6539: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6542: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6545: new 2456	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody
    //   6548: dup
    //   6549: invokespecial 2457	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody:<init>	()V
    //   6552: astore_1
    //   6553: aload_1
    //   6554: aload 32
    //   6556: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6559: invokevirtual 2458	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6562: pop
    //   6563: aload_1
    //   6564: getfield 2459	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6567: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6570: lstore_2
    //   6571: aload_0
    //   6572: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6575: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6578: lload_2
    //   6579: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6582: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6585: ifne +9 -> 6594
    //   6588: lload_2
    //   6589: lconst_0
    //   6590: lcmp
    //   6591: ifne -6562 -> 29
    //   6594: aload_0
    //   6595: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6598: sipush 152
    //   6601: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6604: checkcast 608	com/tencent/mobileqq/apollo/ApolloManager
    //   6607: aload_1
    //   6608: ldc_w 2461
    //   6611: invokevirtual 2464	com/tencent/mobileqq/apollo/ApolloManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody;Ljava/lang/String;)V
    //   6614: aconst_null
    //   6615: areturn
    //   6616: astore_1
    //   6617: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6620: ifeq -6591 -> 29
    //   6623: ldc_w 468
    //   6626: iconst_2
    //   6627: ldc_w 2450
    //   6630: aload_1
    //   6631: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6634: aconst_null
    //   6635: areturn
    //   6636: aload 32
    //   6638: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6641: ldc2_w 2465
    //   6644: lcmp
    //   6645: ifne +166 -> 6811
    //   6648: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6651: ifeq +46 -> 6697
    //   6654: ldc_w 468
    //   6657: iconst_4
    //   6658: new 88	java/lang/StringBuilder
    //   6661: dup
    //   6662: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6665: ldc_w 2468
    //   6668: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6671: aload_1
    //   6672: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6675: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6678: ldc_w 2401
    //   6681: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6684: aload_1
    //   6685: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6688: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6691: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6694: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6697: new 2470	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody
    //   6700: dup
    //   6701: invokespecial 2471	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:<init>	()V
    //   6704: astore_1
    //   6705: aload_1
    //   6706: aload 32
    //   6708: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6711: invokevirtual 2472	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6714: pop
    //   6715: aload_1
    //   6716: ifnull -6687 -> 29
    //   6719: aload_1
    //   6720: getfield 2475	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:uint32_notify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6723: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6726: iconst_1
    //   6727: if_icmpne +78 -> 6805
    //   6730: iconst_1
    //   6731: istore 19
    //   6733: iload 19
    //   6735: iconst_1
    //   6736: if_icmpne -6707 -> 29
    //   6739: new 264	java/lang/String
    //   6742: dup
    //   6743: aload_1
    //   6744: getfield 2478	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:bytes_notify_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6747: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6750: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6753: ldc_w 1200
    //   6756: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   6759: astore_1
    //   6760: aload_0
    //   6761: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6764: iload 19
    //   6766: aload_1
    //   6767: invokestatic 2483	com/tencent/mobileqq/qcall/QCallFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ZLjava/lang/String;)V
    //   6770: aload_0
    //   6771: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6774: invokevirtual 2486	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   6777: iload 19
    //   6779: aload_1
    //   6780: invokevirtual 2491	com/tencent/av/gaudio/AVNotifyCenter:a	(ZLjava/lang/String;)V
    //   6783: aconst_null
    //   6784: areturn
    //   6785: astore_1
    //   6786: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6789: ifeq -6760 -> 29
    //   6792: ldc_w 468
    //   6795: iconst_2
    //   6796: ldc_w 2493
    //   6799: aload_1
    //   6800: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6803: aconst_null
    //   6804: areturn
    //   6805: iconst_0
    //   6806: istore 19
    //   6808: goto -75 -> 6733
    //   6811: aload 32
    //   6813: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6816: ldc2_w 2494
    //   6819: lcmp
    //   6820: ifne +449 -> 7269
    //   6823: new 2497	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody
    //   6826: dup
    //   6827: invokespecial 2498	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:<init>	()V
    //   6830: astore 28
    //   6832: sipush -2029
    //   6835: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6838: checkcast 2500	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   6841: astore 29
    //   6843: aload 28
    //   6845: aload 32
    //   6847: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6850: invokevirtual 2501	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6853: pop
    //   6854: aload 29
    //   6856: new 88	java/lang/StringBuilder
    //   6859: dup
    //   6860: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6863: aload 28
    //   6865: getfield 2504	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6868: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6871: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6874: ldc 140
    //   6876: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6879: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6882: putfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   6885: aload 29
    //   6887: new 88	java/lang/StringBuilder
    //   6890: dup
    //   6891: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6894: aload 28
    //   6896: getfield 2510	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6899: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6902: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6905: ldc 140
    //   6907: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6910: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6913: putfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   6916: aload 29
    //   6918: aload 28
    //   6920: getfield 2516	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6923: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6926: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6929: putfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   6932: aload 29
    //   6934: aload 28
    //   6936: getfield 2522	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6939: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6942: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6945: putfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   6948: aload 29
    //   6950: aload 28
    //   6952: getfield 2528	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6955: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6958: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6961: putfield 2531	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   6964: aload 29
    //   6966: aload 28
    //   6968: getfield 2532	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6971: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6974: putfield 2535	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   6977: aload 29
    //   6979: aload 28
    //   6981: getfield 2538	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6984: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6987: putfield 2539	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   6990: aload_0
    //   6991: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6994: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6997: astore 30
    //   6999: aload_0
    //   7000: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7003: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7006: aload 29
    //   7008: getfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7011: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7014: ifeq +215 -> 7229
    //   7017: aload 29
    //   7019: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7022: astore 28
    //   7024: aload 29
    //   7026: aload 30
    //   7028: aload 28
    //   7030: ldc 140
    //   7032: ldc_w 2541
    //   7035: aload_1
    //   7036: invokevirtual 2544	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   7039: sipush -2029
    //   7042: iconst_0
    //   7043: aload_1
    //   7044: invokevirtual 2547	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   7047: i2l
    //   7048: invokevirtual 2548	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   7051: aload 29
    //   7053: iconst_1
    //   7054: putfield 2549	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   7057: aload 29
    //   7059: aload_1
    //   7060: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7063: i2l
    //   7064: putfield 2550	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   7067: aload 29
    //   7069: aload_1
    //   7070: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   7073: putfield 2551	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   7076: aload 29
    //   7078: invokevirtual 2554	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   7081: pop
    //   7082: aload 29
    //   7084: invokevirtual 2557	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   7087: aload 29
    //   7089: getfield 2535	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7092: iconst_1
    //   7093: if_icmpne +11 -> 7104
    //   7096: aload 29
    //   7098: getfield 2539	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7101: ifeq +8331 -> 15432
    //   7104: aload 29
    //   7106: astore_1
    //   7107: aload 29
    //   7109: getfield 2535	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7112: iconst_1
    //   7113: if_icmpne +114 -> 7227
    //   7116: aload_0
    //   7117: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7120: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7123: astore 28
    //   7125: aconst_null
    //   7126: astore_1
    //   7127: aload 28
    //   7129: aload 29
    //   7131: getfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7134: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7137: ifeq +110 -> 7247
    //   7140: aload 29
    //   7142: getfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7145: astore_1
    //   7146: aload 29
    //   7148: aload_0
    //   7149: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7152: aload_1
    //   7153: invokevirtual 2560	com/tencent/mobileqq/data/MessageForQQWalletTips:getQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   7156: astore 28
    //   7158: aload 29
    //   7160: astore_1
    //   7161: aload 28
    //   7163: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7166: ifne +61 -> 7227
    //   7169: aload 28
    //   7171: ldc_w 2562
    //   7174: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7177: ifne +17 -> 7194
    //   7180: aload 29
    //   7182: astore_1
    //   7183: aload 28
    //   7185: ldc_w 2564
    //   7188: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7191: ifeq +36 -> 7227
    //   7194: aload 29
    //   7196: aload_0
    //   7197: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7200: aload 28
    //   7202: aload 29
    //   7204: getfield 2567	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightStart	I
    //   7207: aload 29
    //   7209: getfield 2570	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightEnd	I
    //   7212: aload 29
    //   7214: getfield 2573	com/tencent/mobileqq/data/MessageForQQWalletTips:textColor	Ljava/lang/String;
    //   7217: aload 29
    //   7219: getfield 2576	com/tencent/mobileqq/data/MessageForQQWalletTips:url	Ljava/lang/String;
    //   7222: invokevirtual 2580	com/tencent/mobileqq/data/MessageForQQWalletTips:addQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   7225: aconst_null
    //   7226: astore_1
    //   7227: aload_1
    //   7228: areturn
    //   7229: aload 29
    //   7231: getfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7234: astore 28
    //   7236: goto -212 -> 7024
    //   7239: astore_1
    //   7240: aload_1
    //   7241: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   7244: goto -157 -> 7087
    //   7247: aload 28
    //   7249: aload 29
    //   7251: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7254: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7257: ifeq -111 -> 7146
    //   7260: aload 29
    //   7262: getfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7265: astore_1
    //   7266: goto -120 -> 7146
    //   7269: aload 32
    //   7271: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7274: ldc2_w 2581
    //   7277: lcmp
    //   7278: ifne +76 -> 7354
    //   7281: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7284: ifeq +13 -> 7297
    //   7287: ldc_w 2584
    //   7290: iconst_2
    //   7291: ldc_w 2586
    //   7294: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7297: new 2588	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7300: dup
    //   7301: invokespecial 2589	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:<init>	()V
    //   7304: aload 32
    //   7306: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7309: invokevirtual 2590	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7312: checkcast 2588	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7315: astore_1
    //   7316: aload_0
    //   7317: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7320: bipush 85
    //   7322: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   7325: checkcast 2592	com/tencent/qidian/controller/QidianHandler
    //   7328: aload_1
    //   7329: invokevirtual 2595	com/tencent/qidian/controller/QidianHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody;)V
    //   7332: aconst_null
    //   7333: areturn
    //   7334: astore_1
    //   7335: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7338: ifeq -7309 -> 29
    //   7341: ldc_w 468
    //   7344: iconst_2
    //   7345: ldc_w 2597
    //   7348: aload_1
    //   7349: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7352: aconst_null
    //   7353: areturn
    //   7354: aload 32
    //   7356: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7359: ldc2_w 2598
    //   7362: lcmp
    //   7363: ifne +76 -> 7439
    //   7366: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7369: ifeq +13 -> 7382
    //   7372: ldc_w 2601
    //   7375: iconst_2
    //   7376: ldc_w 2603
    //   7379: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7382: new 2605	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7385: dup
    //   7386: invokespecial 2606	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:<init>	()V
    //   7389: aload 32
    //   7391: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7394: invokevirtual 2607	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7397: checkcast 2605	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7400: astore_1
    //   7401: aload_0
    //   7402: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7405: bipush 85
    //   7407: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   7410: checkcast 2592	com/tencent/qidian/controller/QidianHandler
    //   7413: aload_1
    //   7414: invokevirtual 2610	com/tencent/qidian/controller/QidianHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody;)V
    //   7417: aconst_null
    //   7418: areturn
    //   7419: astore_1
    //   7420: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7423: ifeq -7394 -> 29
    //   7426: ldc_w 468
    //   7429: iconst_2
    //   7430: ldc_w 2612
    //   7433: aload_1
    //   7434: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7437: aconst_null
    //   7438: areturn
    //   7439: aload 32
    //   7441: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7444: ldc2_w 2613
    //   7447: lcmp
    //   7448: ifne +359 -> 7807
    //   7451: new 2616	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody
    //   7454: dup
    //   7455: invokespecial 2617	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:<init>	()V
    //   7458: astore 31
    //   7460: sipush -2029
    //   7463: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7466: checkcast 2500	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7469: astore 30
    //   7471: aload 31
    //   7473: aload 32
    //   7475: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7478: invokevirtual 2618	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7481: pop
    //   7482: iconst_0
    //   7483: istore 5
    //   7485: ldc 140
    //   7487: astore 29
    //   7489: aload 29
    //   7491: astore 28
    //   7493: iload 5
    //   7495: istore 4
    //   7497: aload 31
    //   7499: getfield 2622	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:sint32_sessiontype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   7502: invokevirtual 2625	com/tencent/mobileqq/pb/PBSInt32Field:get	()I
    //   7505: tableswitch	default:+7988 -> 15493, 3:+242->7747, 4:+263->7768, 5:+31->7536, 6:+8002->15507
    //   7537: lload_0
    //   7538: new 88	java/lang/StringBuilder
    //   7541: dup
    //   7542: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7545: aload 31
    //   7547: getfield 2626	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7550: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7553: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7556: ldc 140
    //   7558: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7561: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7564: putfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7567: aload 30
    //   7569: new 88	java/lang/StringBuilder
    //   7572: dup
    //   7573: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7576: aload 31
    //   7578: getfield 2627	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7581: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7584: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7587: ldc 140
    //   7589: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7592: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7595: putfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7598: aload 30
    //   7600: aload 31
    //   7602: getfield 2628	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7605: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7608: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7611: putfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7614: aload 30
    //   7616: aload 31
    //   7618: getfield 2629	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7621: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7624: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7627: putfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7630: aload 30
    //   7632: aload 31
    //   7634: getfield 2630	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7637: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7640: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7643: putfield 2531	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   7646: aload_0
    //   7647: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7650: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7653: astore 31
    //   7655: aload_0
    //   7656: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7659: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7662: aload 30
    //   7664: getfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7667: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7670: ifeq +119 -> 7789
    //   7673: aload 30
    //   7675: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7678: astore 29
    //   7680: aload 30
    //   7682: aload 31
    //   7684: aload 29
    //   7686: aload 28
    //   7688: ldc_w 2541
    //   7691: aload_1
    //   7692: invokevirtual 2544	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   7695: sipush -2029
    //   7698: iload 4
    //   7700: aload_1
    //   7701: invokevirtual 2547	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   7704: i2l
    //   7705: invokevirtual 2548	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   7708: aload 30
    //   7710: iconst_1
    //   7711: putfield 2549	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   7714: aload 30
    //   7716: aload_1
    //   7717: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7720: i2l
    //   7721: putfield 2550	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   7724: aload 30
    //   7726: aload_1
    //   7727: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   7730: putfield 2551	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   7733: aload 30
    //   7735: invokevirtual 2554	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   7738: pop
    //   7739: aload 30
    //   7741: invokevirtual 2557	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   7744: goto +7760 -> 15504
    //   7747: sipush 1000
    //   7750: istore 4
    //   7752: aload 31
    //   7754: getfield 2633	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7757: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7760: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7763: astore 28
    //   7765: goto -229 -> 7536
    //   7768: sipush 1004
    //   7771: istore 4
    //   7773: aload 31
    //   7775: getfield 2633	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7778: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7781: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7784: astore 28
    //   7786: goto -250 -> 7536
    //   7789: aload 30
    //   7791: getfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7794: astore 29
    //   7796: goto -116 -> 7680
    //   7799: astore_1
    //   7800: aload_1
    //   7801: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   7804: goto +7700 -> 15504
    //   7807: aload 32
    //   7809: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7812: ldc2_w 2634
    //   7815: lcmp
    //   7816: ifne +305 -> 8121
    //   7819: aload_0
    //   7820: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7823: bipush 50
    //   7825: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7828: checkcast 125	com/tencent/mobileqq/app/FriendsManager
    //   7831: astore 34
    //   7833: new 2637	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody
    //   7836: dup
    //   7837: invokespecial 2638	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:<init>	()V
    //   7840: astore 33
    //   7842: sipush -2029
    //   7845: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7848: checkcast 2500	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7851: astore 31
    //   7853: aload 33
    //   7855: aload 32
    //   7857: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7860: invokevirtual 2639	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7863: pop
    //   7864: new 88	java/lang/StringBuilder
    //   7867: dup
    //   7868: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7871: aload 33
    //   7873: getfield 2640	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7876: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7879: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7882: ldc 140
    //   7884: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7887: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7890: astore 29
    //   7892: new 88	java/lang/StringBuilder
    //   7895: dup
    //   7896: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7899: aload 33
    //   7901: getfield 2641	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7904: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7907: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7910: ldc 140
    //   7912: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7915: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7918: astore 30
    //   7920: aload_0
    //   7921: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7924: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7927: aload 29
    //   7929: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7932: ifeq +166 -> 8098
    //   7935: aload 30
    //   7937: astore 28
    //   7939: aload 34
    //   7941: aload 28
    //   7943: invokevirtual 129	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   7946: astore 32
    //   7948: aload 32
    //   7950: ifnull +155 -> 8105
    //   7953: aload 32
    //   7955: invokevirtual 146	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   7958: ifeq +147 -> 8105
    //   7961: iconst_0
    //   7962: istore 4
    //   7964: aload 31
    //   7966: aload 29
    //   7968: putfield 2507	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7971: aload 31
    //   7973: aload 30
    //   7975: putfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7978: aload 31
    //   7980: aload 33
    //   7982: getfield 2642	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7985: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7988: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7991: putfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7994: aload 31
    //   7996: aload 33
    //   7998: getfield 2643	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8001: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8004: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8007: putfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8010: aload 31
    //   8012: aload 33
    //   8014: getfield 2644	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8017: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8020: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8023: putfield 2531	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8026: aload 31
    //   8028: aload_0
    //   8029: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8032: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8035: aload 28
    //   8037: ldc 140
    //   8039: ldc_w 2541
    //   8042: aload_1
    //   8043: invokevirtual 2544	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8046: sipush -2029
    //   8049: iload 4
    //   8051: aload_1
    //   8052: invokevirtual 2547	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8055: i2l
    //   8056: invokevirtual 2548	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8059: aload 31
    //   8061: iconst_1
    //   8062: putfield 2549	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8065: aload 31
    //   8067: aload_1
    //   8068: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8071: i2l
    //   8072: putfield 2550	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8075: aload 31
    //   8077: aload_1
    //   8078: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8081: putfield 2551	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8084: aload 31
    //   8086: invokevirtual 2554	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8089: pop
    //   8090: aload 31
    //   8092: invokevirtual 2557	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8095: aload 31
    //   8097: areturn
    //   8098: aload 29
    //   8100: astore 28
    //   8102: goto -163 -> 7939
    //   8105: sipush 1001
    //   8108: istore 4
    //   8110: goto -146 -> 7964
    //   8113: astore_1
    //   8114: aload_1
    //   8115: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   8118: goto -23 -> 8095
    //   8121: aload 32
    //   8123: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8126: ldc2_w 2645
    //   8129: lcmp
    //   8130: ifne +62 -> 8192
    //   8133: aload_0
    //   8134: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8137: bipush 62
    //   8139: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   8142: checkcast 2648	com/tencent/mobileqq/app/readinjoy/ReadInJoyHandler
    //   8145: aload 32
    //   8147: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8150: invokevirtual 2649	com/tencent/mobileqq/app/readinjoy/ReadInJoyHandler:a	([B)V
    //   8153: aload_1
    //   8154: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   8157: lstore_2
    //   8158: aload_1
    //   8159: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8162: istore 4
    //   8164: aload_1
    //   8165: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8168: lstore 15
    //   8170: aload_1
    //   8171: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   8174: istore 5
    //   8176: aload_0
    //   8177: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8180: lload_2
    //   8181: iload 4
    //   8183: lload 15
    //   8185: iload 5
    //   8187: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   8190: aconst_null
    //   8191: areturn
    //   8192: aload 32
    //   8194: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8197: ldc2_w 2650
    //   8200: lcmp
    //   8201: ifne +114 -> 8315
    //   8204: new 2653	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody
    //   8207: dup
    //   8208: invokespecial 2654	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:<init>	()V
    //   8211: astore_1
    //   8212: aload_1
    //   8213: aload 32
    //   8215: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8218: invokevirtual 2655	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8221: pop
    //   8222: aload_1
    //   8223: getfield 2658	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8226: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   8229: ifeq +34 -> 8263
    //   8232: aload_1
    //   8233: getfield 2658	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8236: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8239: lconst_1
    //   8240: lcmp
    //   8241: ifne +68 -> 8309
    //   8244: iconst_1
    //   8245: istore 4
    //   8247: iload 4
    //   8249: ifeq +14 -> 8263
    //   8252: aload_0
    //   8253: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8256: invokevirtual 1261	com/tencent/mobileqq/app/MessageHandler:a	()Lcom/tencent/mobileqq/app/message/SystemMessageProcessor;
    //   8259: iconst_2
    //   8260: invokevirtual 1264	com/tencent/mobileqq/app/message/SystemMessageProcessor:a	(I)V
    //   8263: aload_1
    //   8264: getfield 2661	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:rpt_msg_msg_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   8267: invokevirtual 1837	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   8270: ifeq -8241 -> 29
    //   8273: aload_0
    //   8274: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8277: aload_1
    //   8278: invokestatic 2666	com/tencent/mobileqq/activity/contact/newfriend/CloneFriendPushHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody;)V
    //   8281: aconst_null
    //   8282: areturn
    //   8283: astore_1
    //   8284: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8287: ifeq +13 -> 8300
    //   8290: ldc_w 2320
    //   8293: iconst_2
    //   8294: ldc 140
    //   8296: aload_1
    //   8297: invokestatic 2322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8300: new 2324	java/lang/RuntimeException
    //   8303: dup
    //   8304: aload_1
    //   8305: invokespecial 2327	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   8308: athrow
    //   8309: iconst_0
    //   8310: istore 4
    //   8312: goto -65 -> 8247
    //   8315: aload 32
    //   8317: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8320: ldc2_w 2667
    //   8323: lcmp
    //   8324: ifeq +15 -> 8339
    //   8327: aload 32
    //   8329: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8332: ldc2_w 2669
    //   8335: lcmp
    //   8336: ifne +68 -> 8404
    //   8339: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8342: ifeq +13 -> 8355
    //   8345: ldc_w 2672
    //   8348: iconst_2
    //   8349: ldc_w 2674
    //   8352: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8355: new 2676	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody
    //   8358: dup
    //   8359: invokespecial 2677	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:<init>	()V
    //   8362: astore_1
    //   8363: aload_1
    //   8364: aload 32
    //   8366: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8369: invokevirtual 2678	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8372: pop
    //   8373: aload_0
    //   8374: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8377: aload_1
    //   8378: lconst_0
    //   8379: iconst_0
    //   8380: invokestatic 2681	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody;JZ)V
    //   8383: aconst_null
    //   8384: areturn
    //   8385: astore_1
    //   8386: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8389: ifeq -8360 -> 29
    //   8392: ldc_w 2672
    //   8395: iconst_2
    //   8396: ldc_w 2683
    //   8399: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8402: aconst_null
    //   8403: areturn
    //   8404: aload 32
    //   8406: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8409: ldc2_w 2684
    //   8412: lcmp
    //   8413: ifne +25 -> 8438
    //   8416: aload_0
    //   8417: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8420: bipush 51
    //   8422: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   8425: checkcast 2112	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   8428: aload 32
    //   8430: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8433: invokevirtual 2686	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	([B)V
    //   8436: aconst_null
    //   8437: areturn
    //   8438: aload 32
    //   8440: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8443: ldc2_w 2687
    //   8446: lcmp
    //   8447: ifne +24 -> 8471
    //   8450: iconst_2
    //   8451: invokestatic 2694	com/tencent/mqp/app/sec/d:x	()[Ljava/lang/Object;
    //   8454: aload 32
    //   8456: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8459: invokestatic 2698	com/tencent/mqp/app/sec/d:e1	(I[Ljava/lang/Object;[B)V
    //   8462: aconst_null
    //   8463: areturn
    //   8464: astore_1
    //   8465: aload_1
    //   8466: invokevirtual 2699	java/lang/Throwable:printStackTrace	()V
    //   8469: aconst_null
    //   8470: areturn
    //   8471: aload 32
    //   8473: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8476: ldc2_w 2700
    //   8479: lcmp
    //   8480: ifne +182 -> 8662
    //   8483: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8486: ifeq +13 -> 8499
    //   8489: ldc_w 468
    //   8492: iconst_4
    //   8493: ldc_w 2703
    //   8496: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8499: new 2705	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody
    //   8502: dup
    //   8503: invokespecial 2706	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:<init>	()V
    //   8506: astore_1
    //   8507: aload_1
    //   8508: aload 32
    //   8510: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8513: invokevirtual 2707	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8516: pop
    //   8517: new 397	android/content/Intent
    //   8520: dup
    //   8521: ldc_w 2709
    //   8524: invokespecial 401	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   8527: astore 28
    //   8529: aload_1
    //   8530: getfield 2712	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8533: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8536: ifeq +114 -> 8650
    //   8539: aload_1
    //   8540: getfield 2712	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8543: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8546: tableswitch	default:+6973 -> 15519, 0:+80->8626, 1:+92->8638
    //   8569: iload_2
    //   8570: ldc_w 2714
    //   8573: invokevirtual 2717	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8576: pop
    //   8577: aload 28
    //   8579: ldc_w 2719
    //   8582: aload_1
    //   8583: getfield 2722	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:string_push_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8586: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   8589: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8592: pop
    //   8593: aload_0
    //   8594: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8597: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8600: aload 28
    //   8602: invokevirtual 422	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   8605: aconst_null
    //   8606: areturn
    //   8607: astore_1
    //   8608: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8611: ifeq -8582 -> 29
    //   8614: ldc_w 468
    //   8617: iconst_4
    //   8618: ldc_w 2724
    //   8621: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8624: aconst_null
    //   8625: areturn
    //   8626: aload 28
    //   8628: ldc_w 2714
    //   8631: invokevirtual 2717	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8634: pop
    //   8635: goto -58 -> 8577
    //   8638: aload 28
    //   8640: ldc_w 2726
    //   8643: invokevirtual 2717	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8646: pop
    //   8647: goto -70 -> 8577
    //   8650: aload 28
    //   8652: ldc_w 2714
    //   8655: invokevirtual 2717	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8658: pop
    //   8659: goto -82 -> 8577
    //   8662: aload 32
    //   8664: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8667: ldc2_w 2727
    //   8670: lcmp
    //   8671: ifne +240 -> 8911
    //   8674: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8677: ifeq +13 -> 8690
    //   8680: ldc_w 468
    //   8683: iconst_2
    //   8684: ldc_w 2730
    //   8687: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8690: new 2732	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody
    //   8693: dup
    //   8694: invokespecial 2733	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:<init>	()V
    //   8697: astore_1
    //   8698: aload_1
    //   8699: aload 32
    //   8701: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8704: invokevirtual 2734	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8707: pop
    //   8708: aload_1
    //   8709: getfield 2737	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:string_params	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8712: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   8715: astore_1
    //   8716: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8719: ifeq +29 -> 8748
    //   8722: ldc_w 468
    //   8725: new 88	java/lang/StringBuilder
    //   8728: dup
    //   8729: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8732: ldc_w 2739
    //   8735: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8738: aload_1
    //   8739: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8742: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8745: invokestatic 2743	com/tencent/open/wadl/WLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   8748: new 2745	org/json/JSONObject
    //   8751: dup
    //   8752: aload_1
    //   8753: invokespecial 2746	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8756: ldc_w 2748
    //   8759: invokevirtual 2751	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8762: astore 28
    //   8764: ldc_w 2753
    //   8767: invokestatic 2756	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   8770: ldc_w 2758
    //   8773: invokevirtual 2762	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8776: astore 29
    //   8778: iconst_0
    //   8779: istore 6
    //   8781: iconst_0
    //   8782: istore 4
    //   8784: iload 6
    //   8786: istore 5
    //   8788: iload 4
    //   8790: aload 29
    //   8792: arraylength
    //   8793: if_icmpge +38 -> 8831
    //   8796: aload 29
    //   8798: iload 4
    //   8800: aaload
    //   8801: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8804: ifne +98 -> 8902
    //   8807: aload 28
    //   8809: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8812: ifne +90 -> 8902
    //   8815: aload 29
    //   8817: iload 4
    //   8819: aaload
    //   8820: aload 28
    //   8822: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8825: ifeq +77 -> 8902
    //   8828: iconst_1
    //   8829: istore 5
    //   8831: iload 5
    //   8833: ifne +33 -> 8866
    //   8836: aload 28
    //   8838: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8841: ifne +25 -> 8866
    //   8844: aload 28
    //   8846: ldc_w 2764
    //   8849: invokestatic 2766	com/tencent/gamecenter/appointment/GameCenterUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   8852: pop
    //   8853: aload 28
    //   8855: aload_1
    //   8856: ldc_w 2768
    //   8859: invokestatic 2771	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   8862: pop
    //   8863: invokestatic 2775	com/tencent/gamecenter/appointment/GameCenterBroadcastReceiver:a	()V
    //   8866: invokestatic 2779	com/tencent/gamecenter/appointment/GameCenterCheck:b	()V
    //   8869: aload_0
    //   8870: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8873: ldc_w 2781
    //   8876: ldc_w 2783
    //   8879: aload 28
    //   8881: ldc_w 2785
    //   8884: ldc_w 2787
    //   8887: ldc_w 2789
    //   8890: invokestatic 2792	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   8893: aconst_null
    //   8894: areturn
    //   8895: astore_1
    //   8896: aload_1
    //   8897: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   8900: aconst_null
    //   8901: areturn
    //   8902: iload 4
    //   8904: iconst_1
    //   8905: iadd
    //   8906: istore 4
    //   8908: goto -124 -> 8784
    //   8911: aload 32
    //   8913: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8916: ldc2_w 2793
    //   8919: lcmp
    //   8920: ifne +1451 -> 10371
    //   8923: new 2796	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody
    //   8926: dup
    //   8927: invokespecial 2797	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:<init>	()V
    //   8930: astore 28
    //   8932: aload 28
    //   8934: aload 32
    //   8936: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8939: invokevirtual 2798	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8942: pop
    //   8943: aload 28
    //   8945: getfield 2801	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8948: invokevirtual 1999	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   8951: ifeq +1201 -> 10152
    //   8954: aload 28
    //   8956: getfield 2801	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8959: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   8962: invokevirtual 2804	java/lang/String:trim	()Ljava/lang/String;
    //   8965: astore_1
    //   8966: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8969: ifeq +30 -> 8999
    //   8972: ldc_w 2806
    //   8975: iconst_2
    //   8976: new 88	java/lang/StringBuilder
    //   8979: dup
    //   8980: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8983: ldc_w 2808
    //   8986: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8989: aload_1
    //   8990: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8993: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8996: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   8999: aload 28
    //   9001: getfield 2811	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9004: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9007: iconst_1
    //   9008: if_icmpne +1150 -> 10158
    //   9011: iconst_1
    //   9012: istore 22
    //   9014: aload 28
    //   9016: getfield 2814	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_folder_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9019: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9022: iconst_1
    //   9023: if_icmpne +1141 -> 10164
    //   9026: iconst_1
    //   9027: istore 23
    //   9029: aload 28
    //   9031: getfield 2817	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9034: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9037: iconst_1
    //   9038: if_icmpne +1132 -> 10170
    //   9041: iconst_1
    //   9042: istore 20
    //   9044: aload 28
    //   9046: getfield 2820	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9049: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9052: iconst_1
    //   9053: if_icmpne +1123 -> 10176
    //   9056: iconst_1
    //   9057: istore 19
    //   9059: aload 28
    //   9061: getfield 2823	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9064: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9067: iconst_1
    //   9068: if_icmpne +1114 -> 10182
    //   9071: iconst_1
    //   9072: istore 21
    //   9074: aload 28
    //   9076: getfield 2826	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_start_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9079: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9082: istore 6
    //   9084: aload 28
    //   9086: getfield 2829	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_end_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9089: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9092: istore 7
    //   9094: invokestatic 460	java/lang/System:currentTimeMillis	()J
    //   9097: ldc2_w 2830
    //   9100: ldiv
    //   9101: l2i
    //   9102: istore 8
    //   9104: aload 28
    //   9106: getfield 2834	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_period_of_validity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9109: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9112: istore 5
    //   9114: aload 28
    //   9116: getfield 2837	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9119: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9122: istore 9
    //   9124: aload 28
    //   9126: getfield 2840	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_task_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9129: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9132: astore 31
    //   9134: aload 28
    //   9136: getfield 2843	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9139: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9142: astore 32
    //   9144: aload 28
    //   9146: getfield 2846	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9149: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9152: astore 33
    //   9154: aload 28
    //   9156: getfield 2849	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9159: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9162: astore 29
    //   9164: aload 28
    //   9166: getfield 2852	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9169: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9172: istore 10
    //   9174: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9177: ifeq +163 -> 9340
    //   9180: ldc_w 2806
    //   9183: iconst_2
    //   9184: new 88	java/lang/StringBuilder
    //   9187: dup
    //   9188: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9191: ldc_w 2854
    //   9194: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9197: iload 6
    //   9199: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9202: ldc_w 2856
    //   9205: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9208: iload 7
    //   9210: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9213: ldc_w 2858
    //   9216: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9219: iload 5
    //   9221: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9224: ldc_w 2860
    //   9227: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9230: iload 23
    //   9232: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9235: ldc_w 2862
    //   9238: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9241: iload 22
    //   9243: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9246: ldc_w 2862
    //   9249: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9252: iload 20
    //   9254: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9257: ldc_w 2862
    //   9260: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9263: iload 19
    //   9265: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9268: ldc_w 2862
    //   9271: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9274: iload 21
    //   9276: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9279: ldc_w 2864
    //   9282: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9285: iload 9
    //   9287: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9290: ldc_w 2866
    //   9293: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9296: aload 31
    //   9298: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9301: ldc_w 2868
    //   9304: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9307: aload 32
    //   9309: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9312: ldc_w 2870
    //   9315: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9318: aload 33
    //   9320: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9323: ldc_w 2872
    //   9326: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9329: aload 29
    //   9331: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9334: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9337: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9340: iload 8
    //   9342: iload 6
    //   9344: if_icmplt -9315 -> 29
    //   9347: iload 8
    //   9349: iload 7
    //   9351: if_icmpgt -9322 -> 29
    //   9354: iload 5
    //   9356: istore 4
    //   9358: iload 5
    //   9360: ldc_w 2873
    //   9363: if_icmple +8 -> 9371
    //   9366: ldc_w 2873
    //   9369: istore 4
    //   9371: iload 22
    //   9373: ifne +18 -> 9391
    //   9376: iload 20
    //   9378: ifne +13 -> 9391
    //   9381: iload 19
    //   9383: ifne +8 -> 9391
    //   9386: iload 21
    //   9388: ifeq +6041 -> 15429
    //   9391: iconst_1
    //   9392: istore 23
    //   9394: iload 23
    //   9396: ifne +6014 -> 15410
    //   9399: iload 22
    //   9401: ifne +15 -> 9416
    //   9404: aload 28
    //   9406: getfield 2876	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9409: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9412: iconst_1
    //   9413: if_icmpne +775 -> 10188
    //   9416: iconst_1
    //   9417: istore 22
    //   9419: iload 20
    //   9421: ifne +15 -> 9436
    //   9424: aload 28
    //   9426: getfield 2879	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9429: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9432: iconst_1
    //   9433: if_icmpne +761 -> 10194
    //   9436: iconst_1
    //   9437: istore 20
    //   9439: iload 19
    //   9441: ifne +15 -> 9456
    //   9444: aload 28
    //   9446: getfield 2882	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9449: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9452: iconst_1
    //   9453: if_icmpne +747 -> 10200
    //   9456: iconst_1
    //   9457: istore 19
    //   9459: iload 21
    //   9461: ifne +15 -> 9476
    //   9464: aload 28
    //   9466: getfield 2885	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9469: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9472: iconst_1
    //   9473: if_icmpne +733 -> 10206
    //   9476: iconst_1
    //   9477: istore 21
    //   9479: iload 21
    //   9481: istore 24
    //   9483: iload 22
    //   9485: istore 25
    //   9487: iload 20
    //   9489: istore 26
    //   9491: iload 19
    //   9493: istore 27
    //   9495: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9498: ifeq +80 -> 9578
    //   9501: ldc_w 2806
    //   9504: iconst_2
    //   9505: new 88	java/lang/StringBuilder
    //   9508: dup
    //   9509: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9512: ldc_w 2887
    //   9515: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9518: iload 22
    //   9520: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9523: ldc_w 2862
    //   9526: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9529: iload 20
    //   9531: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9534: ldc_w 2862
    //   9537: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9540: iload 19
    //   9542: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9545: ldc_w 2862
    //   9548: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9551: iload 21
    //   9553: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9556: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9559: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9562: iload 19
    //   9564: istore 27
    //   9566: iload 20
    //   9568: istore 26
    //   9570: iload 22
    //   9572: istore 25
    //   9574: iload 21
    //   9576: istore 24
    //   9578: aload_0
    //   9579: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9582: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9585: astore 30
    //   9587: aload 30
    //   9589: astore 28
    //   9591: aload 30
    //   9593: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9596: ifeq +8 -> 9604
    //   9599: ldc_w 2889
    //   9602: astore 28
    //   9604: aload_0
    //   9605: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9608: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9611: new 88	java/lang/StringBuilder
    //   9614: dup
    //   9615: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9618: ldc_w 2891
    //   9621: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9624: aload 28
    //   9626: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9629: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9632: iconst_0
    //   9633: invokevirtual 824	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   9636: astore 30
    //   9638: aload 30
    //   9640: invokeinterface 359 1 0
    //   9645: astore 28
    //   9647: aload 30
    //   9649: ldc_w 2893
    //   9652: iconst_0
    //   9653: invokeinterface 2897 3 0
    //   9658: ifne +59 -> 9717
    //   9661: aload 30
    //   9663: ldc_w 2899
    //   9666: iconst_0
    //   9667: invokeinterface 2897 3 0
    //   9672: ifne +45 -> 9717
    //   9675: aload 30
    //   9677: ldc_w 2901
    //   9680: iconst_0
    //   9681: invokeinterface 2897 3 0
    //   9686: ifne +31 -> 9717
    //   9689: aload 30
    //   9691: ldc_w 2903
    //   9694: iconst_0
    //   9695: invokeinterface 2897 3 0
    //   9700: ifne +17 -> 9717
    //   9703: aload 30
    //   9705: ldc_w 2905
    //   9708: iconst_0
    //   9709: invokeinterface 2897 3 0
    //   9714: ifeq +109 -> 9823
    //   9717: aload 30
    //   9719: ldc_w 2907
    //   9722: iconst_0
    //   9723: invokeinterface 374 3 0
    //   9728: istore 5
    //   9730: aload 30
    //   9732: ldc_w 2909
    //   9735: iconst_0
    //   9736: invokeinterface 374 3 0
    //   9741: istore 11
    //   9743: aload 30
    //   9745: ldc_w 2911
    //   9748: iconst_0
    //   9749: invokeinterface 374 3 0
    //   9754: istore 12
    //   9756: aload 30
    //   9758: ldc_w 2913
    //   9761: iconst_0
    //   9762: invokeinterface 374 3 0
    //   9767: istore 13
    //   9769: invokestatic 460	java/lang/System:currentTimeMillis	()J
    //   9772: ldc2_w 2830
    //   9775: ldiv
    //   9776: l2i
    //   9777: istore 14
    //   9779: iload 14
    //   9781: ifeq +42 -> 9823
    //   9784: iload 11
    //   9786: ifeq +37 -> 9823
    //   9789: iload 12
    //   9791: ifeq +32 -> 9823
    //   9794: iload 13
    //   9796: ifeq +27 -> 9823
    //   9799: iload 14
    //   9801: iload 11
    //   9803: if_icmplt +409 -> 10212
    //   9806: iload 14
    //   9808: iload 12
    //   9810: if_icmpgt +402 -> 10212
    //   9813: iload 14
    //   9815: iload 5
    //   9817: isub
    //   9818: iload 13
    //   9820: if_icmpge +392 -> 10212
    //   9823: aload 28
    //   9825: ldc_w 2909
    //   9828: iload 6
    //   9830: invokeinterface 367 3 0
    //   9835: pop
    //   9836: aload 28
    //   9838: ldc_w 2911
    //   9841: iload 7
    //   9843: invokeinterface 367 3 0
    //   9848: pop
    //   9849: aload 28
    //   9851: ldc_w 2913
    //   9854: iload 4
    //   9856: invokeinterface 367 3 0
    //   9861: pop
    //   9862: aload 28
    //   9864: ldc_w 2915
    //   9867: aload_1
    //   9868: invokeinterface 2918 3 0
    //   9873: pop
    //   9874: aload 28
    //   9876: ldc_w 2907
    //   9879: iload 8
    //   9881: invokeinterface 367 3 0
    //   9886: pop
    //   9887: aload 28
    //   9889: ldc_w 2920
    //   9892: iload 9
    //   9894: invokeinterface 367 3 0
    //   9899: pop
    //   9900: aload 28
    //   9902: ldc_w 2922
    //   9905: aload 31
    //   9907: invokeinterface 2918 3 0
    //   9912: pop
    //   9913: aload 28
    //   9915: ldc_w 2924
    //   9918: aload 32
    //   9920: invokeinterface 2918 3 0
    //   9925: pop
    //   9926: aload 28
    //   9928: ldc_w 2926
    //   9931: aload 33
    //   9933: invokeinterface 2918 3 0
    //   9938: pop
    //   9939: aload 28
    //   9941: ldc_w 2928
    //   9944: invokestatic 520	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   9947: invokeinterface 2931 4 0
    //   9952: pop
    //   9953: aload 28
    //   9955: ldc_w 2933
    //   9958: iload 10
    //   9960: invokeinterface 367 3 0
    //   9965: pop
    //   9966: aload 29
    //   9968: ifnonnull +323 -> 10291
    //   9971: ldc 140
    //   9973: astore_1
    //   9974: aload 28
    //   9976: ldc_w 2935
    //   9979: aload_1
    //   9980: invokeinterface 2918 3 0
    //   9985: pop
    //   9986: aload 28
    //   9988: ldc_w 2937
    //   9991: iconst_1
    //   9992: invokeinterface 367 3 0
    //   9997: pop
    //   9998: aload 28
    //   10000: ldc_w 2905
    //   10003: iload 23
    //   10005: invokeinterface 2941 3 0
    //   10010: pop
    //   10011: aload 28
    //   10013: ldc_w 2893
    //   10016: iload 25
    //   10018: invokeinterface 2941 3 0
    //   10023: pop
    //   10024: aload 28
    //   10026: ldc_w 2899
    //   10029: iload 26
    //   10031: invokeinterface 2941 3 0
    //   10036: pop
    //   10037: aload 28
    //   10039: ldc_w 2901
    //   10042: iload 27
    //   10044: invokeinterface 2941 3 0
    //   10049: pop
    //   10050: aload 28
    //   10052: ldc_w 2903
    //   10055: iload 24
    //   10057: invokeinterface 2941 3 0
    //   10062: pop
    //   10063: aload 28
    //   10065: invokeinterface 370 1 0
    //   10070: pop
    //   10071: iload 23
    //   10073: ifeq +224 -> 10297
    //   10076: aload_0
    //   10077: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10080: bipush 87
    //   10082: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10085: checkcast 2943	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager
    //   10088: invokestatic 520	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10091: iload 23
    //   10093: invokevirtual 2946	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:a	(JZ)V
    //   10096: aload_0
    //   10097: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10100: bipush 68
    //   10102: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10105: checkcast 2948	com/tencent/biz/pubaccount/ecshopassit/EcShopHandler
    //   10108: invokevirtual 2949	com/tencent/biz/pubaccount/ecshopassit/EcShopHandler:b	()V
    //   10111: aconst_null
    //   10112: astore_1
    //   10113: iload 25
    //   10115: ifeq +208 -> 10323
    //   10118: ldc_w 2951
    //   10121: astore_1
    //   10122: aload_0
    //   10123: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10126: ldc_w 979
    //   10129: ldc 140
    //   10131: ldc 140
    //   10133: ldc_w 2953
    //   10136: aload_1
    //   10137: iconst_0
    //   10138: iconst_0
    //   10139: ldc 140
    //   10141: ldc 140
    //   10143: ldc 140
    //   10145: ldc 140
    //   10147: invokestatic 986	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10150: aconst_null
    //   10151: areturn
    //   10152: ldc 140
    //   10154: astore_1
    //   10155: goto -1189 -> 8966
    //   10158: iconst_0
    //   10159: istore 22
    //   10161: goto -1147 -> 9014
    //   10164: iconst_0
    //   10165: istore 23
    //   10167: goto -1138 -> 9029
    //   10170: iconst_0
    //   10171: istore 20
    //   10173: goto -1129 -> 9044
    //   10176: iconst_0
    //   10177: istore 19
    //   10179: goto -1120 -> 9059
    //   10182: iconst_0
    //   10183: istore 21
    //   10185: goto -1111 -> 9074
    //   10188: iconst_0
    //   10189: istore 22
    //   10191: goto -772 -> 9419
    //   10194: iconst_0
    //   10195: istore 20
    //   10197: goto -758 -> 9439
    //   10200: iconst_0
    //   10201: istore 19
    //   10203: goto -744 -> 9459
    //   10206: iconst_0
    //   10207: istore 21
    //   10209: goto -730 -> 9479
    //   10212: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10215: ifeq +13 -> 10228
    //   10218: ldc_w 2806
    //   10221: iconst_2
    //   10222: ldc_w 2955
    //   10225: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10228: aload 28
    //   10230: ldc_w 2893
    //   10233: iconst_0
    //   10234: invokeinterface 2941 3 0
    //   10239: pop
    //   10240: aload 28
    //   10242: ldc_w 2899
    //   10245: iconst_0
    //   10246: invokeinterface 2941 3 0
    //   10251: pop
    //   10252: aload 28
    //   10254: ldc_w 2901
    //   10257: iconst_0
    //   10258: invokeinterface 2941 3 0
    //   10263: pop
    //   10264: aload 28
    //   10266: ldc_w 2903
    //   10269: iconst_0
    //   10270: invokeinterface 2941 3 0
    //   10275: pop
    //   10276: aload 28
    //   10278: ldc_w 2905
    //   10281: iconst_0
    //   10282: invokeinterface 2941 3 0
    //   10287: pop
    //   10288: goto -465 -> 9823
    //   10291: aload 29
    //   10293: astore_1
    //   10294: goto -320 -> 9974
    //   10297: aload_0
    //   10298: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10301: ldc_w 2957
    //   10304: invokevirtual 2961	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   10307: astore_1
    //   10308: aload_1
    //   10309: ifnull -213 -> 10096
    //   10312: aload_1
    //   10313: sipush 1009
    //   10316: invokevirtual 2966	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   10319: pop
    //   10320: goto -224 -> 10096
    //   10323: iload 26
    //   10325: ifeq +10 -> 10335
    //   10328: ldc_w 2968
    //   10331: astore_1
    //   10332: goto -210 -> 10122
    //   10335: iload 27
    //   10337: ifeq +10 -> 10347
    //   10340: ldc_w 2970
    //   10343: astore_1
    //   10344: goto -222 -> 10122
    //   10347: iload 24
    //   10349: ifeq +10 -> 10359
    //   10352: ldc_w 2972
    //   10355: astore_1
    //   10356: goto -234 -> 10122
    //   10359: iload 23
    //   10361: ifeq -239 -> 10122
    //   10364: ldc_w 2974
    //   10367: astore_1
    //   10368: goto -246 -> 10122
    //   10371: aload 32
    //   10373: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10376: ldc2_w 2975
    //   10379: lcmp
    //   10380: ifne +88 -> 10468
    //   10383: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10386: ifeq +13 -> 10399
    //   10389: ldc_w 468
    //   10392: iconst_2
    //   10393: ldc_w 2978
    //   10396: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10399: aload_0
    //   10400: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10403: sipush 152
    //   10406: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10409: checkcast 608	com/tencent/mobileqq/apollo/ApolloManager
    //   10412: astore 28
    //   10414: aload 28
    //   10416: ifnull +13 -> 10429
    //   10419: aload 28
    //   10421: aload 32
    //   10423: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10426: invokevirtual 2979	com/tencent/mobileqq/apollo/ApolloManager:a	([B)V
    //   10429: aload_1
    //   10430: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   10433: lstore_2
    //   10434: aload_1
    //   10435: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   10438: istore 4
    //   10440: aload_1
    //   10441: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   10444: lstore 15
    //   10446: aload_1
    //   10447: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   10450: istore 5
    //   10452: aload_0
    //   10453: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   10456: lload_2
    //   10457: iload 4
    //   10459: lload 15
    //   10461: iload 5
    //   10463: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   10466: aconst_null
    //   10467: areturn
    //   10468: aload 32
    //   10470: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10473: ldc2_w 2980
    //   10476: lcmp
    //   10477: ifne +56 -> 10533
    //   10480: new 2983	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody
    //   10483: dup
    //   10484: invokespecial 2984	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:<init>	()V
    //   10487: astore_1
    //   10488: aload_1
    //   10489: aload 32
    //   10491: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10494: invokevirtual 2985	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10497: pop
    //   10498: aload_1
    //   10499: getfield 2986	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   10502: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   10505: pop2
    //   10506: aload_1
    //   10507: getfield 2989	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10510: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10513: pop
    //   10514: aload_1
    //   10515: getfield 2993	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:msg_mod_block	Ltencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock;
    //   10518: invokevirtual 2996	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10521: checkcast 2995	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock
    //   10524: getfield 2999	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10527: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10530: pop
    //   10531: aconst_null
    //   10532: areturn
    //   10533: aload 32
    //   10535: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10538: ldc2_w 3000
    //   10541: lcmp
    //   10542: ifne +87 -> 10629
    //   10545: new 3003	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   10548: dup
    //   10549: invokespecial 3004	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   10552: astore_1
    //   10553: aload_1
    //   10554: aload 32
    //   10556: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10559: invokevirtual 3005	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10562: pop
    //   10563: aload_1
    //   10564: getfield 3008	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10567: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10570: istore 4
    //   10572: iload 4
    //   10574: ifne +26 -> 10600
    //   10577: iconst_1
    //   10578: istore 19
    //   10580: aload_0
    //   10581: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10584: sipush 137
    //   10587: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10590: checkcast 3010	com/tencent/mobileqq/activity/bless/BlessManager
    //   10593: iload 19
    //   10595: invokevirtual 3013	com/tencent/mobileqq/activity/bless/BlessManager:c	(Z)V
    //   10598: aconst_null
    //   10599: areturn
    //   10600: iconst_0
    //   10601: istore 19
    //   10603: goto -23 -> 10580
    //   10606: astore_1
    //   10607: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10610: ifeq +13 -> 10623
    //   10613: ldc_w 3015
    //   10616: iconst_2
    //   10617: ldc_w 3017
    //   10620: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   10623: iconst_1
    //   10624: istore 19
    //   10626: goto -46 -> 10580
    //   10629: aload 32
    //   10631: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10634: ldc2_w 3018
    //   10637: lcmp
    //   10638: ifne +552 -> 11190
    //   10641: iconst_0
    //   10642: istore 19
    //   10644: aload_0
    //   10645: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10648: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10651: ldc_w 3021
    //   10654: invokevirtual 3024	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10657: checkcast 3026	android/app/ActivityManager
    //   10660: iconst_1
    //   10661: invokevirtual 3030	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   10664: astore_1
    //   10665: aload_1
    //   10666: ifnull +4738 -> 15404
    //   10669: aload_1
    //   10670: invokeinterface 873 1 0
    //   10675: iconst_1
    //   10676: if_icmplt +4728 -> 15404
    //   10679: aload_1
    //   10680: iconst_0
    //   10681: invokeinterface 850 2 0
    //   10686: checkcast 3032	android/app/ActivityManager$RunningTaskInfo
    //   10689: getfield 3036	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   10692: invokevirtual 3041	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   10695: astore_1
    //   10696: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10699: ifeq +30 -> 10729
    //   10702: ldc_w 468
    //   10705: iconst_2
    //   10706: new 88	java/lang/StringBuilder
    //   10709: dup
    //   10710: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   10713: ldc_w 3043
    //   10716: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10719: aload_1
    //   10720: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10723: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10726: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10729: ldc_w 3045
    //   10732: aload_1
    //   10733: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10736: istore 20
    //   10738: iload 20
    //   10740: istore 19
    //   10742: aload_0
    //   10743: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10746: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10749: ldc_w 3047
    //   10752: invokevirtual 3024	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10755: checkcast 3049	android/os/PowerManager
    //   10758: invokevirtual 3052	android/os/PowerManager:isScreenOn	()Z
    //   10761: istore 20
    //   10763: iload 20
    //   10765: ifeq +18 -> 10783
    //   10768: aload_0
    //   10769: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10772: getfield 3055	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   10775: ifeq -10746 -> 29
    //   10778: iload 19
    //   10780: ifne -10751 -> 29
    //   10783: new 3057	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody
    //   10786: dup
    //   10787: invokespecial 3058	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:<init>	()V
    //   10790: astore 30
    //   10792: aconst_null
    //   10793: astore_1
    //   10794: aconst_null
    //   10795: astore 28
    //   10797: aconst_null
    //   10798: astore 29
    //   10800: aload 30
    //   10802: aload 32
    //   10804: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10807: invokevirtual 3059	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10810: pop
    //   10811: aload 30
    //   10813: getfield 3062	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10816: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   10819: ifeq +15 -> 10834
    //   10822: aload 30
    //   10824: getfield 3062	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10827: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   10830: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   10833: astore_1
    //   10834: aload 30
    //   10836: getfield 3065	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10839: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   10842: ifeq +16 -> 10858
    //   10845: aload 30
    //   10847: getfield 3065	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10850: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   10853: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   10856: astore 28
    //   10858: aload 30
    //   10860: getfield 3068	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10863: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   10866: ifeq +16 -> 10882
    //   10869: aload 30
    //   10871: getfield 3068	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10874: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   10877: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   10880: astore 29
    //   10882: aload_1
    //   10883: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10886: ifne -10857 -> 29
    //   10889: aload 28
    //   10891: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10894: ifne -10865 -> 29
    //   10897: aload 29
    //   10899: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10902: ifne -10873 -> 29
    //   10905: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10908: ifeq +52 -> 10960
    //   10911: ldc_w 468
    //   10914: iconst_2
    //   10915: new 88	java/lang/StringBuilder
    //   10918: dup
    //   10919: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   10922: ldc_w 3070
    //   10925: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10928: aload_1
    //   10929: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10932: ldc_w 3072
    //   10935: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10938: aload 28
    //   10940: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10943: ldc_w 3074
    //   10946: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10949: aload 29
    //   10951: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10954: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10957: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10960: new 397	android/content/Intent
    //   10963: dup
    //   10964: aload_0
    //   10965: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10968: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10971: ldc_w 3076
    //   10974: invokespecial 3079	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   10977: astore 30
    //   10979: aload 30
    //   10981: ldc_w 3080
    //   10984: aload 29
    //   10986: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   10989: pop
    //   10990: aload 30
    //   10992: ldc_w 3082
    //   10995: sipush 3001
    //   10998: invokevirtual 3085	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11001: pop
    //   11002: new 3087	com/tencent/qphone/base/remote/ToServiceMsg
    //   11005: dup
    //   11006: ldc_w 3089
    //   11009: aload_0
    //   11010: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11013: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11016: ldc_w 3091
    //   11019: invokespecial 3094	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11022: astore 29
    //   11024: aload 29
    //   11026: getfield 3098	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11029: ldc_w 3100
    //   11032: iconst_3
    //   11033: anewarray 264	java/lang/String
    //   11036: dup
    //   11037: iconst_0
    //   11038: aload 28
    //   11040: aastore
    //   11041: dup
    //   11042: iconst_1
    //   11043: aload_1
    //   11044: aastore
    //   11045: dup
    //   11046: iconst_2
    //   11047: aload 28
    //   11049: aastore
    //   11050: invokevirtual 3104	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11053: aload 29
    //   11055: getfield 3098	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11058: ldc_w 3106
    //   11061: aload 30
    //   11063: invokevirtual 3110	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11066: aload 29
    //   11068: getfield 3098	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11071: ldc_w 3112
    //   11074: aconst_null
    //   11075: invokevirtual 3110	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11078: aload_0
    //   11079: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11082: aload 29
    //   11084: invokevirtual 3116	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   11087: aconst_null
    //   11088: ldc_w 979
    //   11091: ldc 140
    //   11093: ldc 140
    //   11095: ldc_w 3118
    //   11098: ldc_w 3118
    //   11101: iconst_0
    //   11102: iconst_0
    //   11103: ldc 140
    //   11105: ldc 140
    //   11107: ldc 140
    //   11109: ldc 140
    //   11111: invokestatic 986	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11114: aconst_null
    //   11115: areturn
    //   11116: astore_1
    //   11117: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11120: ifeq +13 -> 11133
    //   11123: ldc_w 468
    //   11126: iconst_2
    //   11127: ldc_w 3120
    //   11130: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11133: aload_1
    //   11134: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   11137: aconst_null
    //   11138: areturn
    //   11139: astore_1
    //   11140: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11143: ifeq +13 -> 11156
    //   11146: ldc_w 468
    //   11149: iconst_2
    //   11150: ldc_w 3122
    //   11153: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11156: aload_1
    //   11157: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   11160: goto -418 -> 10742
    //   11163: astore_1
    //   11164: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11167: ifeq +13 -> 11180
    //   11170: ldc_w 468
    //   11173: iconst_2
    //   11174: ldc_w 3124
    //   11177: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11180: aload_1
    //   11181: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   11184: iconst_1
    //   11185: istore 20
    //   11187: goto -424 -> 10763
    //   11190: aload 32
    //   11192: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11195: ldc2_w 3125
    //   11198: lcmp
    //   11199: ifne +289 -> 11488
    //   11202: aload 32
    //   11204: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11207: ifnull +281 -> 11488
    //   11210: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11213: ifeq +13 -> 11226
    //   11216: ldc_w 468
    //   11219: iconst_2
    //   11220: ldc_w 3128
    //   11223: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11226: aload_0
    //   11227: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11230: sipush 142
    //   11233: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11236: checkcast 544	com/tencent/mobileqq/qcall/PstnManager
    //   11239: invokevirtual 3130	com/tencent/mobileqq/qcall/PstnManager:a	()I
    //   11242: iconst_1
    //   11243: if_icmpne -11214 -> 29
    //   11246: new 3132	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody
    //   11249: dup
    //   11250: invokespecial 3133	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:<init>	()V
    //   11253: astore 28
    //   11255: aload 28
    //   11257: aload 32
    //   11259: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11262: invokevirtual 3134	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11265: checkcast 3132	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody
    //   11268: astore 28
    //   11270: sipush -2045
    //   11273: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   11276: astore 29
    //   11278: aload 28
    //   11280: getfield 3135	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11283: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11286: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11289: astore 30
    //   11291: aload 28
    //   11293: getfield 3136	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11296: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11299: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11302: astore 31
    //   11304: aload 28
    //   11306: getfield 3139	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_auth_key	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11309: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11312: invokestatic 3143	com/tencent/mobileqq/qcall/UinUtils:a	(I)Ljava/lang/String;
    //   11315: astore 32
    //   11317: aload 28
    //   11319: getfield 3144	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11322: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11325: istore 5
    //   11327: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11330: ifeq +4192 -> 15522
    //   11333: ldc_w 468
    //   11336: iconst_2
    //   11337: iconst_3
    //   11338: anewarray 209	java/lang/Object
    //   11341: dup
    //   11342: iconst_0
    //   11343: ldc_w 3146
    //   11346: aastore
    //   11347: dup
    //   11348: iconst_1
    //   11349: iload 5
    //   11351: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11354: aastore
    //   11355: dup
    //   11356: iconst_2
    //   11357: aload 28
    //   11359: getfield 3139	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_auth_key	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11362: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11365: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11368: aastore
    //   11369: invokestatic 3149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   11372: goto +4150 -> 15522
    //   11375: aload 29
    //   11377: aload_0
    //   11378: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11381: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11384: aload 32
    //   11386: aload 32
    //   11388: new 88	java/lang/StringBuilder
    //   11391: dup
    //   11392: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11395: aload 30
    //   11397: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11400: ldc_w 3151
    //   11403: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11406: aload 31
    //   11408: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11411: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11414: lconst_0
    //   11415: sipush -2045
    //   11418: iload 4
    //   11420: aload_1
    //   11421: invokevirtual 2547	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   11424: i2l
    //   11425: invokevirtual 1108	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   11428: aload 29
    //   11430: iconst_1
    //   11431: putfield 1114	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   11434: aload_0
    //   11435: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11438: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   11441: aload 29
    //   11443: aload_0
    //   11444: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11447: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11450: invokevirtual 1575	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   11453: aconst_null
    //   11454: areturn
    //   11455: astore_1
    //   11456: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11459: ifeq -11430 -> 29
    //   11462: ldc_w 468
    //   11465: iconst_2
    //   11466: ldc_w 3153
    //   11469: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11472: aconst_null
    //   11473: areturn
    //   11474: iload 5
    //   11476: iconst_2
    //   11477: if_icmpne -102 -> 11375
    //   11480: sipush 3000
    //   11483: istore 4
    //   11485: goto -110 -> 11375
    //   11488: aload 32
    //   11490: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11493: ldc2_w 3000
    //   11496: lcmp
    //   11497: ifne +87 -> 11584
    //   11500: new 3003	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11503: dup
    //   11504: invokespecial 3004	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11507: astore_1
    //   11508: aload_1
    //   11509: aload 32
    //   11511: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11514: invokevirtual 3005	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11517: pop
    //   11518: aload_1
    //   11519: getfield 3008	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11522: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11525: istore 4
    //   11527: iload 4
    //   11529: ifne +26 -> 11555
    //   11532: iconst_1
    //   11533: istore 19
    //   11535: aload_0
    //   11536: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11539: sipush 137
    //   11542: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11545: checkcast 3010	com/tencent/mobileqq/activity/bless/BlessManager
    //   11548: iload 19
    //   11550: invokevirtual 3013	com/tencent/mobileqq/activity/bless/BlessManager:c	(Z)V
    //   11553: aconst_null
    //   11554: areturn
    //   11555: iconst_0
    //   11556: istore 19
    //   11558: goto -23 -> 11535
    //   11561: astore_1
    //   11562: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11565: ifeq +13 -> 11578
    //   11568: ldc_w 3015
    //   11571: iconst_2
    //   11572: ldc_w 3017
    //   11575: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11578: iconst_1
    //   11579: istore 19
    //   11581: goto -46 -> 11535
    //   11584: aload 32
    //   11586: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11589: ldc2_w 3154
    //   11592: lcmp
    //   11593: ifne +100 -> 11693
    //   11596: new 3157	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody
    //   11599: dup
    //   11600: invokespecial 3158	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:<init>	()V
    //   11603: astore_1
    //   11604: aload_1
    //   11605: aload 32
    //   11607: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11610: invokevirtual 3159	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11613: pop
    //   11614: aload_0
    //   11615: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11618: bipush 75
    //   11620: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   11623: checkcast 3161	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   11626: astore 28
    //   11628: aload_0
    //   11629: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11632: bipush 114
    //   11634: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11637: checkcast 3163	cooperation/dingdong/DingdongPluginManager
    //   11640: astore 29
    //   11642: aload 28
    //   11644: aload_1
    //   11645: iconst_0
    //   11646: invokevirtual 3166	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody;Z)V
    //   11649: aconst_null
    //   11650: areturn
    //   11651: astore 28
    //   11653: ldc_w 468
    //   11656: iconst_1
    //   11657: new 88	java/lang/StringBuilder
    //   11660: dup
    //   11661: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11664: ldc_w 3168
    //   11667: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11670: aload 28
    //   11672: invokevirtual 3169	java/lang/Exception:toString	()Ljava/lang/String;
    //   11675: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11678: ldc_w 3171
    //   11681: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11684: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11687: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11690: goto -76 -> 11614
    //   11693: aload 32
    //   11695: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11698: ldc2_w 3172
    //   11701: lcmp
    //   11702: ifne +82 -> 11784
    //   11705: new 3175	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody
    //   11708: dup
    //   11709: invokespecial 3176	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:<init>	()V
    //   11712: astore_1
    //   11713: aload_1
    //   11714: aload 32
    //   11716: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11719: invokevirtual 3177	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11722: pop
    //   11723: aload_0
    //   11724: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11727: bipush 75
    //   11729: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   11732: checkcast 3161	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   11735: aload_1
    //   11736: iconst_0
    //   11737: invokevirtual 3180	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody;Z)V
    //   11740: aconst_null
    //   11741: areturn
    //   11742: astore 28
    //   11744: ldc_w 468
    //   11747: iconst_1
    //   11748: new 88	java/lang/StringBuilder
    //   11751: dup
    //   11752: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11755: ldc_w 3182
    //   11758: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11761: aload 28
    //   11763: invokevirtual 3169	java/lang/Exception:toString	()Ljava/lang/String;
    //   11766: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11769: ldc_w 3171
    //   11772: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11775: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11778: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11781: goto -58 -> 11723
    //   11784: aload 32
    //   11786: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11789: ldc2_w 3183
    //   11792: lcmp
    //   11793: ifne +104 -> 11897
    //   11796: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11799: ifeq +13 -> 11812
    //   11802: ldc_w 3186
    //   11805: iconst_2
    //   11806: ldc_w 3188
    //   11809: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11812: new 3190	tencent/qht_exinfo/qht_post_exinfo
    //   11815: dup
    //   11816: invokespecial 3191	tencent/qht_exinfo/qht_post_exinfo:<init>	()V
    //   11819: astore_1
    //   11820: aload_1
    //   11821: aload 32
    //   11823: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11826: invokevirtual 3192	tencent/qht_exinfo/qht_post_exinfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11829: pop
    //   11830: aload_0
    //   11831: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11834: bipush 97
    //   11836: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11839: checkcast 3194	com/tencent/mobileqq/troop/utils/TroopTopicMgr
    //   11842: astore 28
    //   11844: aload 28
    //   11846: ifnull -11817 -> 29
    //   11849: aload 28
    //   11851: aload_1
    //   11852: getfield 3197	tencent/qht_exinfo/qht_post_exinfo:groupCode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   11855: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   11858: aload_1
    //   11859: getfield 3200	tencent/qht_exinfo/qht_post_exinfo:msgSeq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   11862: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   11865: aload_1
    //   11866: getfield 3203	tencent/qht_exinfo/qht_post_exinfo:pVersion	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   11869: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   11872: invokevirtual 3206	com/tencent/mobileqq/troop/utils/TroopTopicMgr:a	(Ljava/lang/String;JJ)V
    //   11875: aconst_null
    //   11876: areturn
    //   11877: astore_1
    //   11878: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11881: ifeq -11852 -> 29
    //   11884: ldc_w 3186
    //   11887: iconst_2
    //   11888: ldc_w 3208
    //   11891: aload_1
    //   11892: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   11895: aconst_null
    //   11896: areturn
    //   11897: aload 32
    //   11899: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11902: ldc2_w 3209
    //   11905: lcmp
    //   11906: ifne +75 -> 11981
    //   11909: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11912: ifeq +13 -> 11925
    //   11915: ldc_w 3212
    //   11918: iconst_2
    //   11919: ldc_w 3214
    //   11922: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11925: new 3216	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody
    //   11928: dup
    //   11929: invokespecial 3217	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:<init>	()V
    //   11932: astore_1
    //   11933: aload_1
    //   11934: aload 32
    //   11936: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11939: invokevirtual 3218	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11942: pop
    //   11943: aload_0
    //   11944: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11947: bipush 20
    //   11949: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   11952: checkcast 1634	com/tencent/mobileqq/app/TroopHandler
    //   11955: aload_1
    //   11956: invokevirtual 3221	com/tencent/mobileqq/app/TroopHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody;)V
    //   11959: aconst_null
    //   11960: areturn
    //   11961: astore_1
    //   11962: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11965: ifeq -11936 -> 29
    //   11968: ldc_w 3212
    //   11971: iconst_2
    //   11972: ldc_w 3223
    //   11975: aload_1
    //   11976: invokestatic 3225	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   11979: aconst_null
    //   11980: areturn
    //   11981: aload 32
    //   11983: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11986: ldc2_w 3226
    //   11989: lcmp
    //   11990: ifne +47 -> 12037
    //   11993: new 3229	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody
    //   11996: dup
    //   11997: invokespecial 3230	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:<init>	()V
    //   12000: astore_1
    //   12001: aload_1
    //   12002: aload 32
    //   12004: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12007: invokevirtual 3231	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12010: pop
    //   12011: aload_0
    //   12012: aload_1
    //   12013: invokevirtual 3234	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody;)V
    //   12016: aconst_null
    //   12017: areturn
    //   12018: astore_1
    //   12019: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12022: ifeq -11993 -> 29
    //   12025: ldc_w 3236
    //   12028: iconst_2
    //   12029: ldc_w 3238
    //   12032: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12035: aconst_null
    //   12036: areturn
    //   12037: aload 32
    //   12039: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12042: ldc2_w 3239
    //   12045: lcmp
    //   12046: ifne +78 -> 12124
    //   12049: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12052: ifeq +13 -> 12065
    //   12055: ldc_w 3242
    //   12058: iconst_2
    //   12059: ldc_w 3244
    //   12062: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12065: new 3246	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   12068: dup
    //   12069: invokespecial 3247	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   12072: astore_1
    //   12073: aload_1
    //   12074: aload 32
    //   12076: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12079: invokevirtual 3248	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12082: pop
    //   12083: aload_0
    //   12084: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12087: sipush 155
    //   12090: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12093: checkcast 3250	com/tencent/mobileqq/gameparty/GamePartyManager
    //   12096: aload_1
    //   12097: iconst_0
    //   12098: invokevirtual 3253	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   12101: aconst_null
    //   12102: areturn
    //   12103: astore 28
    //   12105: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12108: ifeq -25 -> 12083
    //   12111: ldc_w 3242
    //   12114: iconst_2
    //   12115: ldc_w 3255
    //   12118: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12121: goto -38 -> 12083
    //   12124: aload 32
    //   12126: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12129: ldc2_w 3256
    //   12132: lcmp
    //   12133: ifne +735 -> 12868
    //   12136: new 3259	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody
    //   12139: dup
    //   12140: invokespecial 3260	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:<init>	()V
    //   12143: astore 28
    //   12145: aload 28
    //   12147: aload 32
    //   12149: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12152: invokevirtual 3261	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12155: pop
    //   12156: aload 28
    //   12158: getfield 3262	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12161: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12164: ifeq +579 -> 12743
    //   12167: aload 28
    //   12169: getfield 3262	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12172: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12175: iconst_2
    //   12176: if_icmpne +567 -> 12743
    //   12179: aload 28
    //   12181: getfield 3266	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12184: getfield 3272	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:fixed32_timestamp	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   12187: invokevirtual 3275	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   12190: i2l
    //   12191: lstore_2
    //   12192: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12195: ifeq +30 -> 12225
    //   12198: ldc_w 468
    //   12201: iconst_2
    //   12202: new 88	java/lang/StringBuilder
    //   12205: dup
    //   12206: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   12209: ldc_w 3277
    //   12212: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12215: lload_2
    //   12216: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12219: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12222: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12225: aload 28
    //   12227: getfield 3266	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12230: getfield 3280	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:rpt_msg_friend_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   12233: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   12236: astore 30
    //   12238: aload 30
    //   12240: ifnull +579 -> 12819
    //   12243: aload 30
    //   12245: invokeinterface 873 1 0
    //   12250: ifle +569 -> 12819
    //   12253: new 655	java/util/ArrayList
    //   12256: dup
    //   12257: aload 30
    //   12259: invokeinterface 873 1 0
    //   12264: invokespecial 3282	java/util/ArrayList:<init>	(I)V
    //   12267: astore 29
    //   12269: aload 30
    //   12271: invokeinterface 51 1 0
    //   12276: astore 30
    //   12278: aload 30
    //   12280: invokeinterface 56 1 0
    //   12285: ifeq +497 -> 12782
    //   12288: aload 30
    //   12290: invokeinterface 60 1 0
    //   12295: checkcast 3284	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow
    //   12298: astore 31
    //   12300: new 3286	com/tencent/mobileqq/data/PushRecommend
    //   12303: dup
    //   12304: invokespecial 3287	com/tencent/mobileqq/data/PushRecommend:<init>	()V
    //   12307: astore 32
    //   12309: aload 31
    //   12311: getfield 3288	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12314: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   12317: ifeq +19 -> 12336
    //   12320: aload 32
    //   12322: aload 31
    //   12324: getfield 3288	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12327: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   12330: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   12333: putfield 3289	com/tencent/mobileqq/data/PushRecommend:uin	Ljava/lang/String;
    //   12336: aload 31
    //   12338: getfield 3292	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12341: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12344: ifeq +26 -> 12370
    //   12347: aload 32
    //   12349: new 264	java/lang/String
    //   12352: dup
    //   12353: aload 31
    //   12355: getfield 3292	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12358: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12361: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12364: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12367: putfield 3295	com/tencent/mobileqq/data/PushRecommend:nick	Ljava/lang/String;
    //   12370: aload 31
    //   12372: getfield 3296	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12375: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12378: ifeq +17 -> 12395
    //   12381: aload 32
    //   12383: aload 31
    //   12385: getfield 3296	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12388: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12391: i2s
    //   12392: putfield 3298	com/tencent/mobileqq/data/PushRecommend:age	S
    //   12395: aload 31
    //   12397: getfield 3301	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12400: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12403: ifeq +17 -> 12420
    //   12406: aload 32
    //   12408: aload 31
    //   12410: getfield 3301	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12413: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12416: i2s
    //   12417: putfield 3303	com/tencent/mobileqq/data/PushRecommend:gender	S
    //   12420: aload 31
    //   12422: getfield 3306	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12425: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12428: ifeq +26 -> 12454
    //   12431: aload 32
    //   12433: new 264	java/lang/String
    //   12436: dup
    //   12437: aload 31
    //   12439: getfield 3306	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12442: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12445: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12448: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12451: putfield 3309	com/tencent/mobileqq/data/PushRecommend:recommendReason	Ljava/lang/String;
    //   12454: aload 31
    //   12456: getfield 3312	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12459: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12462: ifeq +19 -> 12481
    //   12465: aload 32
    //   12467: aload 31
    //   12469: getfield 3312	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12472: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12475: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12478: putfield 3315	com/tencent/mobileqq/data/PushRecommend:algBuffer	[B
    //   12481: aload 31
    //   12483: getfield 3318	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12486: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12489: ifeq +26 -> 12515
    //   12492: aload 32
    //   12494: new 264	java/lang/String
    //   12497: dup
    //   12498: aload 31
    //   12500: getfield 3318	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12503: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12506: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12509: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12512: putfield 3321	com/tencent/mobileqq/data/PushRecommend:sourceReason	Ljava/lang/String;
    //   12515: aload 31
    //   12517: getfield 3324	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12520: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12523: ifeq +16 -> 12539
    //   12526: aload 32
    //   12528: aload 31
    //   12530: getfield 3324	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12533: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12536: putfield 3327	com/tencent/mobileqq/data/PushRecommend:fromSource	I
    //   12539: aload 31
    //   12541: getfield 3331	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12544: invokevirtual 3334	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:has	()Z
    //   12547: ifeq +69 -> 12616
    //   12550: aload 31
    //   12552: getfield 3331	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12555: invokevirtual 3335	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12558: checkcast 3333	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource
    //   12561: astore 33
    //   12563: aload 33
    //   12565: ifnull +51 -> 12616
    //   12568: aload 33
    //   12570: getfield 3336	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12573: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12576: ifeq +16 -> 12592
    //   12579: aload 32
    //   12581: aload 33
    //   12583: getfield 3336	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12586: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12589: putfield 3339	com/tencent/mobileqq/data/PushRecommend:sourceId	I
    //   12592: aload 33
    //   12594: getfield 3342	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12597: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12600: ifeq +16 -> 12616
    //   12603: aload 32
    //   12605: aload 33
    //   12607: getfield 3342	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12610: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12613: putfield 3345	com/tencent/mobileqq/data/PushRecommend:subSourceId	I
    //   12616: aload 31
    //   12618: getfield 3348	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12621: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12624: ifeq +26 -> 12650
    //   12627: aload 32
    //   12629: new 264	java/lang/String
    //   12632: dup
    //   12633: aload 31
    //   12635: getfield 3348	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12638: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12641: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12644: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12647: putfield 3351	com/tencent/mobileqq/data/PushRecommend:wzryVerifyStr	Ljava/lang/String;
    //   12650: aload 31
    //   12652: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12655: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12658: ifeq +16 -> 12674
    //   12661: aload 32
    //   12663: aload 31
    //   12665: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12668: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12671: putfield 3357	com/tencent/mobileqq/data/PushRecommend:wzrySourceId	I
    //   12674: aload 31
    //   12676: getfield 3360	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12679: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12682: ifeq +26 -> 12708
    //   12685: aload 32
    //   12687: new 264	java/lang/String
    //   12690: dup
    //   12691: aload 31
    //   12693: getfield 3360	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12696: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12699: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12702: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12705: putfield 3363	com/tencent/mobileqq/data/PushRecommend:wzryGameNick	Ljava/lang/String;
    //   12708: aload 32
    //   12710: lload_2
    //   12711: putfield 3364	com/tencent/mobileqq/data/PushRecommend:timestamp	J
    //   12714: aload 29
    //   12716: aload 32
    //   12718: invokevirtual 659	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   12721: pop
    //   12722: goto -444 -> 12278
    //   12725: astore 28
    //   12727: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12730: ifeq +13 -> 12743
    //   12733: ldc_w 3236
    //   12736: iconst_2
    //   12737: ldc_w 3366
    //   12740: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12743: aload_1
    //   12744: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   12747: lstore_2
    //   12748: aload_1
    //   12749: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   12752: istore 4
    //   12754: aload_1
    //   12755: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   12758: lstore 15
    //   12760: aload_1
    //   12761: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   12764: istore 5
    //   12766: aload_0
    //   12767: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   12770: lload_2
    //   12771: iload 4
    //   12773: lload 15
    //   12775: iload 5
    //   12777: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   12780: aconst_null
    //   12781: areturn
    //   12782: aload_0
    //   12783: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12786: sipush 158
    //   12789: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12792: checkcast 3368	com/tencent/mobileqq/app/MayknowRecommendManager
    //   12795: aload 29
    //   12797: lload_2
    //   12798: invokevirtual 3371	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Ljava/util/ArrayList;J)V
    //   12801: aload_0
    //   12802: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12805: iconst_1
    //   12806: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   12809: checkcast 201	com/tencent/mobileqq/app/FriendListHandler
    //   12812: bipush 109
    //   12814: iconst_1
    //   12815: aconst_null
    //   12816: invokevirtual 1544	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   12819: aload 28
    //   12821: getfield 3266	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12824: getfield 3372	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12827: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12830: ifeq -87 -> 12743
    //   12833: aload 28
    //   12835: getfield 3266	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12838: getfield 3372	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12841: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12844: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   12847: astore 28
    //   12849: aload_0
    //   12850: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12853: aload_0
    //   12854: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12857: invokevirtual 677	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   12860: aload 28
    //   12862: invokestatic 3378	com/tencent/mobileqq/data/KplRoleInfo:saveGameNickWithUin	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   12865: goto -122 -> 12743
    //   12868: aload 32
    //   12870: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12873: ldc2_w 3379
    //   12876: lcmp
    //   12877: ifne +172 -> 13049
    //   12880: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12883: ifeq +13 -> 12896
    //   12886: ldc_w 3382
    //   12889: iconst_2
    //   12890: ldc_w 3384
    //   12893: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12896: new 3386	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody
    //   12899: dup
    //   12900: invokespecial 3387	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:<init>	()V
    //   12903: astore_1
    //   12904: aload_1
    //   12905: aload 32
    //   12907: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12910: invokevirtual 3388	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12913: pop
    //   12914: aload_1
    //   12915: getfield 3389	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12918: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12921: istore 4
    //   12923: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12926: ifeq +28 -> 12954
    //   12929: ldc_w 3382
    //   12932: iconst_2
    //   12933: iconst_2
    //   12934: anewarray 209	java/lang/Object
    //   12937: dup
    //   12938: iconst_0
    //   12939: ldc_w 3391
    //   12942: aastore
    //   12943: dup
    //   12944: iconst_1
    //   12945: iload 4
    //   12947: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12950: aastore
    //   12951: invokestatic 3149	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   12954: iload 4
    //   12956: iconst_1
    //   12957: if_icmpne -12928 -> 29
    //   12960: aload_1
    //   12961: getfield 3395	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:msg_body_type	Ltencent/im/oidb/olympic/submsgtype0xb4$BodyType;
    //   12964: astore_1
    //   12965: aload_1
    //   12966: getfield 3401	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   12969: invokevirtual 3404	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:has	()Z
    //   12972: ifeq +59 -> 13031
    //   12975: aload_0
    //   12976: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12979: bipush 94
    //   12981: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   12984: checkcast 3406	com/tencent/mobileqq/olympic/OlympicHandler
    //   12987: astore 28
    //   12989: aload 28
    //   12991: ifnull -12962 -> 29
    //   12994: aload 28
    //   12996: aload_1
    //   12997: getfield 3401	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   13000: invokevirtual 3407	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13003: checkcast 3403	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo
    //   13006: invokevirtual 3410	com/tencent/mobileqq/olympic/OlympicHandler:a	(Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;)V
    //   13009: aconst_null
    //   13010: areturn
    //   13011: astore_1
    //   13012: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13015: ifeq -12986 -> 29
    //   13018: ldc_w 3382
    //   13021: iconst_2
    //   13022: ldc_w 3412
    //   13025: aload_1
    //   13026: invokestatic 2322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13029: aconst_null
    //   13030: areturn
    //   13031: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13034: ifeq -13005 -> 29
    //   13037: ldc_w 3382
    //   13040: iconst_2
    //   13041: ldc_w 3414
    //   13044: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13047: aconst_null
    //   13048: areturn
    //   13049: aload 32
    //   13051: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13054: ldc2_w 3415
    //   13057: lcmp
    //   13058: ifne +18 -> 13076
    //   13061: aload_0
    //   13062: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13065: aload 32
    //   13067: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13070: iconst_1
    //   13071: invokestatic 3419	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BZ)V
    //   13074: aconst_null
    //   13075: areturn
    //   13076: aload 32
    //   13078: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13081: ldc2_w 3420
    //   13084: lcmp
    //   13085: ifne +70 -> 13155
    //   13088: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13091: ifeq +13 -> 13104
    //   13094: ldc_w 3423
    //   13097: iconst_2
    //   13098: ldc_w 3425
    //   13101: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13104: new 3427	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody
    //   13107: dup
    //   13108: invokespecial 3428	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:<init>	()V
    //   13111: astore_1
    //   13112: aload_1
    //   13113: aload 32
    //   13115: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13118: invokevirtual 3429	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13121: pop
    //   13122: aload_0
    //   13123: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13126: invokevirtual 3432	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13129: aload_1
    //   13130: invokevirtual 3437	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody;)V
    //   13133: aconst_null
    //   13134: areturn
    //   13135: astore_1
    //   13136: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13139: ifeq -13110 -> 29
    //   13142: ldc_w 3423
    //   13145: iconst_2
    //   13146: ldc_w 3439
    //   13149: aload_1
    //   13150: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13153: aconst_null
    //   13154: areturn
    //   13155: aload 32
    //   13157: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13160: ldc2_w 3440
    //   13163: lcmp
    //   13164: ifne +166 -> 13330
    //   13167: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13170: ifeq +13 -> 13183
    //   13173: ldc_w 3443
    //   13176: iconst_2
    //   13177: ldc_w 3445
    //   13180: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13183: new 3447	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody
    //   13186: dup
    //   13187: invokespecial 3448	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:<init>	()V
    //   13190: astore_1
    //   13191: aload_1
    //   13192: aload 32
    //   13194: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13197: invokevirtual 3449	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13200: pop
    //   13201: aload_0
    //   13202: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13205: invokevirtual 3432	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13208: aload_1
    //   13209: invokevirtual 3452	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody;)V
    //   13212: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13215: ifeq -13186 -> 29
    //   13218: aload_1
    //   13219: getfield 3455	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:bytes_business	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   13222: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   13225: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   13228: astore_1
    //   13229: ldc_w 3443
    //   13232: iconst_2
    //   13233: new 88	java/lang/StringBuilder
    //   13236: dup
    //   13237: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13240: ldc_w 3457
    //   13243: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13246: aload_1
    //   13247: arraylength
    //   13248: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13251: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13254: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13257: ldc_w 3443
    //   13260: iconst_2
    //   13261: new 88	java/lang/StringBuilder
    //   13264: dup
    //   13265: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13268: ldc_w 3459
    //   13271: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13274: aload_1
    //   13275: arraylength
    //   13276: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13279: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13282: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13285: aconst_null
    //   13286: areturn
    //   13287: astore_1
    //   13288: aload_1
    //   13289: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   13292: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13295: ifeq -13266 -> 29
    //   13298: ldc_w 3443
    //   13301: iconst_2
    //   13302: new 88	java/lang/StringBuilder
    //   13305: dup
    //   13306: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13309: ldc_w 3461
    //   13312: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13315: aload_1
    //   13316: invokevirtual 3464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13319: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13322: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13325: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13328: aconst_null
    //   13329: areturn
    //   13330: aload 32
    //   13332: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13335: ldc2_w 3465
    //   13338: lcmp
    //   13339: ifne +92 -> 13431
    //   13342: aload 32
    //   13344: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13347: ifnull +84 -> 13431
    //   13350: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13353: ifeq +13 -> 13366
    //   13356: ldc_w 3468
    //   13359: iconst_2
    //   13360: ldc_w 3470
    //   13363: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13366: aload_1
    //   13367: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   13370: lstore_2
    //   13371: aload_1
    //   13372: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13375: istore 4
    //   13377: aload_1
    //   13378: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13381: lstore 15
    //   13383: aload_1
    //   13384: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   13387: istore 5
    //   13389: new 3472	com/tencent/mobileqq/app/message/HotReactivePushMsg
    //   13392: dup
    //   13393: lload_2
    //   13394: iload 4
    //   13396: i2l
    //   13397: lload 15
    //   13399: iload 5
    //   13401: invokespecial 3475	com/tencent/mobileqq/app/message/HotReactivePushMsg:<init>	(JJJI)V
    //   13404: astore_1
    //   13405: aload_0
    //   13406: aload 32
    //   13408: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13411: aload_1
    //   13412: invokevirtual 3478	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BLcom/tencent/mobileqq/app/message/HotReactivePushMsg;)V
    //   13415: aload_0
    //   13416: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13419: lload_2
    //   13420: iload 4
    //   13422: lload 15
    //   13424: iload 5
    //   13426: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13429: aconst_null
    //   13430: areturn
    //   13431: aload 32
    //   13433: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13436: ldc2_w 3479
    //   13439: lcmp
    //   13440: ifne +19 -> 13459
    //   13443: aload_0
    //   13444: aload 32
    //   13446: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13449: aload_1
    //   13450: getfield 1070	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13453: i2l
    //   13454: invokevirtual 3483	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BJ)V
    //   13457: aconst_null
    //   13458: areturn
    //   13459: aload 32
    //   13461: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13464: ldc2_w 3484
    //   13467: lcmp
    //   13468: ifne +19 -> 13487
    //   13471: aload_0
    //   13472: aload 32
    //   13474: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13477: aload_1
    //   13478: getfield 1070	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13481: i2l
    //   13482: invokevirtual 3487	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	([BJ)V
    //   13485: aconst_null
    //   13486: areturn
    //   13487: aload 32
    //   13489: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13492: ldc2_w 3488
    //   13495: lcmp
    //   13496: ifne +16 -> 13512
    //   13499: aload_0
    //   13500: aload 32
    //   13502: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13505: iconst_1
    //   13506: aload_1
    //   13507: invokevirtual 3492	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BILOnlinePushPack/MsgInfo;)V
    //   13510: aconst_null
    //   13511: areturn
    //   13512: aload 32
    //   13514: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13517: ldc2_w 3493
    //   13520: lcmp
    //   13521: ifne +70 -> 13591
    //   13524: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13527: ifeq +13 -> 13540
    //   13530: ldc_w 3496
    //   13533: iconst_2
    //   13534: ldc_w 3498
    //   13537: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13540: aload_0
    //   13541: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13544: bipush 34
    //   13546: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13549: checkcast 3500	com/tencent/mobileqq/app/SecSvcHandler
    //   13552: astore_1
    //   13553: aload_1
    //   13554: ifnull +19 -> 13573
    //   13557: aload_1
    //   13558: aload 32
    //   13560: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13563: aload 32
    //   13565: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13568: invokevirtual 3501	com/tencent/mobileqq/app/SecSvcHandler:a	(J[B)V
    //   13571: aconst_null
    //   13572: areturn
    //   13573: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13576: ifeq -13547 -> 29
    //   13579: ldc_w 3496
    //   13582: iconst_2
    //   13583: ldc_w 3503
    //   13586: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13589: aconst_null
    //   13590: areturn
    //   13591: aload 32
    //   13593: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13596: ldc2_w 3504
    //   13599: lcmp
    //   13600: ifne +15 -> 13615
    //   13603: aload_0
    //   13604: aload 32
    //   13606: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13609: aload_1
    //   13610: invokevirtual 3508	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BLOnlinePushPack/MsgInfo;)V
    //   13613: aconst_null
    //   13614: areturn
    //   13615: aload 32
    //   13617: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13620: ldc2_w 3509
    //   13623: lcmp
    //   13624: ifne +25 -> 13649
    //   13627: aload_0
    //   13628: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13631: bipush 98
    //   13633: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13636: checkcast 3512	com/tencent/biz/qqstory/base/QQStoryHandler
    //   13639: aload 32
    //   13641: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13644: invokevirtual 3513	com/tencent/biz/qqstory/base/QQStoryHandler:a	([B)V
    //   13647: aconst_null
    //   13648: areturn
    //   13649: aload 32
    //   13651: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13654: ldc2_w 3514
    //   13657: lcmp
    //   13658: ifne +70 -> 13728
    //   13661: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13664: ifeq +13 -> 13677
    //   13667: ldc_w 3423
    //   13670: iconst_2
    //   13671: ldc_w 3517
    //   13674: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13677: new 3519	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody
    //   13680: dup
    //   13681: invokespecial 3520	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:<init>	()V
    //   13684: astore_1
    //   13685: aload_1
    //   13686: aload 32
    //   13688: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13691: invokevirtual 3521	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13694: pop
    //   13695: aload_0
    //   13696: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13699: invokevirtual 3432	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13702: aload_1
    //   13703: invokevirtual 3524	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody;)V
    //   13706: aconst_null
    //   13707: areturn
    //   13708: astore_1
    //   13709: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13712: ifeq -13683 -> 29
    //   13715: ldc_w 3423
    //   13718: iconst_2
    //   13719: ldc_w 3526
    //   13722: aload_1
    //   13723: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13726: aconst_null
    //   13727: areturn
    //   13728: aload 32
    //   13730: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13733: ldc2_w 3527
    //   13736: lcmp
    //   13737: ifne +25 -> 13762
    //   13740: aload_0
    //   13741: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13744: bipush 98
    //   13746: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13749: checkcast 3512	com/tencent/biz/qqstory/base/QQStoryHandler
    //   13752: aload 32
    //   13754: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13757: invokevirtual 3529	com/tencent/biz/qqstory/base/QQStoryHandler:b	([B)V
    //   13760: aconst_null
    //   13761: areturn
    //   13762: aload 32
    //   13764: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13767: ldc2_w 3530
    //   13770: lcmp
    //   13771: ifne +25 -> 13796
    //   13774: aload_0
    //   13775: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13778: bipush 98
    //   13780: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13783: checkcast 3512	com/tencent/biz/qqstory/base/QQStoryHandler
    //   13786: aload 32
    //   13788: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13791: invokevirtual 3532	com/tencent/biz/qqstory/base/QQStoryHandler:c	([B)V
    //   13794: aconst_null
    //   13795: areturn
    //   13796: aload 32
    //   13798: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13801: ldc2_w 3533
    //   13804: lcmp
    //   13805: ifne +42 -> 13847
    //   13808: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13811: ifeq +13 -> 13824
    //   13814: ldc_w 468
    //   13817: iconst_2
    //   13818: ldc_w 3536
    //   13821: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13824: aload_0
    //   13825: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13828: sipush 201
    //   13831: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   13834: checkcast 3538	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   13837: aload 32
    //   13839: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13842: invokevirtual 3541	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xd7InteractAndFollowMsg	([B)V
    //   13845: aconst_null
    //   13846: areturn
    //   13847: aload 32
    //   13849: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13852: ldc2_w 3542
    //   13855: lcmp
    //   13856: ifne +25 -> 13881
    //   13859: aload_0
    //   13860: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13863: bipush 107
    //   13865: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13868: checkcast 3545	com/tencent/mobileqq/werewolves/WerewolvesHandler
    //   13871: aload 32
    //   13873: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13876: invokevirtual 3546	com/tencent/mobileqq/werewolves/WerewolvesHandler:a	([B)V
    //   13879: aconst_null
    //   13880: areturn
    //   13881: aload 32
    //   13883: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13886: ldc2_w 3547
    //   13889: lcmp
    //   13890: ifne +70 -> 13960
    //   13893: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13896: ifeq +13 -> 13909
    //   13899: ldc_w 3550
    //   13902: iconst_2
    //   13903: ldc_w 3552
    //   13906: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13909: new 3554	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody
    //   13912: dup
    //   13913: invokespecial 3555	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:<init>	()V
    //   13916: astore_1
    //   13917: aload_1
    //   13918: aload 32
    //   13920: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13923: invokevirtual 3556	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13926: pop
    //   13927: aload_0
    //   13928: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13931: invokevirtual 3432	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13934: aload_1
    //   13935: invokevirtual 3559	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody;)V
    //   13938: aconst_null
    //   13939: areturn
    //   13940: astore_1
    //   13941: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13944: ifeq -13915 -> 29
    //   13947: ldc_w 3550
    //   13950: iconst_2
    //   13951: ldc_w 3561
    //   13954: aload_1
    //   13955: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13958: aconst_null
    //   13959: areturn
    //   13960: aload 32
    //   13962: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13965: ldc2_w 3562
    //   13968: lcmp
    //   13969: ifne +21 -> 13990
    //   13972: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13975: ifeq -13946 -> 29
    //   13978: ldc_w 468
    //   13981: iconst_2
    //   13982: ldc_w 3565
    //   13985: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13988: aconst_null
    //   13989: areturn
    //   13990: aload 32
    //   13992: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13995: ldc2_w 3566
    //   13998: lcmp
    //   13999: ifne +21 -> 14020
    //   14002: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14005: ifeq -13976 -> 29
    //   14008: ldc_w 468
    //   14011: iconst_2
    //   14012: ldc_w 3569
    //   14015: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14018: aconst_null
    //   14019: areturn
    //   14020: aload 32
    //   14022: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14025: ldc2_w 3570
    //   14028: lcmp
    //   14029: ifne +219 -> 14248
    //   14032: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14035: ifeq +13 -> 14048
    //   14038: ldc_w 3573
    //   14041: iconst_2
    //   14042: ldc_w 3575
    //   14045: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14048: new 3577	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody
    //   14051: dup
    //   14052: invokespecial 3578	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:<init>	()V
    //   14055: astore_1
    //   14056: aload_1
    //   14057: aload 32
    //   14059: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14062: invokevirtual 3579	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14065: pop
    //   14066: aload_1
    //   14067: getfield 3583	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14070: invokevirtual 3586	tencent/im/apollo_game_status$STCMGameMessage:has	()Z
    //   14073: ifeq -14044 -> 29
    //   14076: aload_1
    //   14077: getfield 3583	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14080: invokevirtual 3587	tencent/im/apollo_game_status$STCMGameMessage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14083: checkcast 3585	tencent/im/apollo_game_status$STCMGameMessage
    //   14086: astore_1
    //   14087: aload_1
    //   14088: getfield 3591	tencent/im/apollo_game_status$STCMGameMessage:msg_comm	Ltencent/im/apollo_game_status$STCMGameMessage$STMsgComm;
    //   14091: invokevirtual 3594	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14094: checkcast 3593	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm
    //   14097: astore 29
    //   14099: aload 29
    //   14101: getfield 3597	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:uint32_session_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   14104: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   14107: invokestatic 3600	com/tencent/mobileqq/util/Utils:a	(I)J
    //   14110: lstore 15
    //   14112: aload_0
    //   14113: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14116: sipush 210
    //   14119: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14122: checkcast 3602	com/tencent/mobileqq/apollo/ApolloGameManager
    //   14125: astore 28
    //   14127: lload_2
    //   14128: lload 15
    //   14130: lcmp
    //   14131: ifne +102 -> 14233
    //   14134: aload 29
    //   14136: getfield 3605	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:rpt_uint32_session_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   14139: invokevirtual 1718	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   14142: astore 29
    //   14144: aload 29
    //   14146: ifnull -14117 -> 29
    //   14149: aload 29
    //   14151: invokeinterface 873 1 0
    //   14156: ifle -14127 -> 29
    //   14159: aload 29
    //   14161: invokeinterface 51 1 0
    //   14166: astore 29
    //   14168: aload 29
    //   14170: invokeinterface 56 1 0
    //   14175: ifeq -14146 -> 29
    //   14178: aload 29
    //   14180: invokeinterface 60 1 0
    //   14185: checkcast 241	java/lang/Integer
    //   14188: invokevirtual 3608	java/lang/Integer:intValue	()I
    //   14191: invokestatic 3600	com/tencent/mobileqq/util/Utils:a	(I)J
    //   14194: lstore 15
    //   14196: lload 15
    //   14198: lload_2
    //   14199: lcmp
    //   14200: ifeq -32 -> 14168
    //   14203: aload 28
    //   14205: iconst_0
    //   14206: iconst_0
    //   14207: lload 15
    //   14209: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14212: aload_1
    //   14213: invokevirtual 3611	com/tencent/mobileqq/apollo/ApolloGameManager:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14216: goto -48 -> 14168
    //   14219: astore_1
    //   14220: ldc_w 3573
    //   14223: iconst_1
    //   14224: ldc_w 3613
    //   14227: aload_1
    //   14228: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14231: aconst_null
    //   14232: areturn
    //   14233: aload 28
    //   14235: iconst_0
    //   14236: iconst_0
    //   14237: lload 15
    //   14239: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14242: aload_1
    //   14243: invokevirtual 3611	com/tencent/mobileqq/apollo/ApolloGameManager:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14246: aconst_null
    //   14247: areturn
    //   14248: aload 32
    //   14250: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14253: ldc2_w 3614
    //   14256: lcmp
    //   14257: ifne +132 -> 14389
    //   14260: ldc_w 3617
    //   14263: iconst_1
    //   14264: ldc_w 3619
    //   14267: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14270: new 3621	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody
    //   14273: dup
    //   14274: invokespecial 3622	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:<init>	()V
    //   14277: astore_1
    //   14278: aload_1
    //   14279: aload 32
    //   14281: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14284: invokevirtual 3623	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14287: pop
    //   14288: aload_1
    //   14289: getfield 3627	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14292: invokevirtual 3630	tencent/im/apollo_push_msgInfo$STPushMsgElem:has	()Z
    //   14295: ifeq -14266 -> 29
    //   14298: aload_1
    //   14299: getfield 3627	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14302: invokevirtual 3631	tencent/im/apollo_push_msgInfo$STPushMsgElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14305: checkcast 3629	tencent/im/apollo_push_msgInfo$STPushMsgElem
    //   14308: astore_1
    //   14309: aload_0
    //   14310: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14313: ifnull -14284 -> 29
    //   14316: aload_0
    //   14317: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14320: sipush 226
    //   14323: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14326: checkcast 3633	com/tencent/mobileqq/apollo/ApolloPushManager
    //   14329: astore 28
    //   14331: aload 28
    //   14333: iconst_0
    //   14334: aload_1
    //   14335: invokevirtual 3636	com/tencent/mobileqq/apollo/ApolloPushManager:a	(ILtencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14338: aload 28
    //   14340: aload_1
    //   14341: invokevirtual 3639	com/tencent/mobileqq/apollo/ApolloPushManager:b	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14344: aload 28
    //   14346: aload_1
    //   14347: invokevirtual 3641	com/tencent/mobileqq/apollo/ApolloPushManager:a	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14350: aconst_null
    //   14351: areturn
    //   14352: astore_1
    //   14353: aload_1
    //   14354: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   14357: ldc_w 3617
    //   14360: iconst_1
    //   14361: new 88	java/lang/StringBuilder
    //   14364: dup
    //   14365: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14368: ldc_w 3643
    //   14371: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14374: aload_1
    //   14375: invokevirtual 3464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14378: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14381: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14384: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14387: aconst_null
    //   14388: areturn
    //   14389: aload 32
    //   14391: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14394: ldc2_w 3644
    //   14397: lcmp
    //   14398: ifne +88 -> 14486
    //   14401: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14404: ifeq +13 -> 14417
    //   14407: ldc_w 468
    //   14410: iconst_2
    //   14411: ldc_w 3647
    //   14414: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14417: new 3649	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody
    //   14420: dup
    //   14421: invokespecial 3650	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:<init>	()V
    //   14424: astore_1
    //   14425: aload 32
    //   14427: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14430: ifnull +13 -> 14443
    //   14433: aload_1
    //   14434: aload 32
    //   14436: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14439: invokevirtual 3651	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14442: pop
    //   14443: aload_0
    //   14444: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14447: aload_1
    //   14448: invokestatic 3654	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody;)V
    //   14451: aconst_null
    //   14452: areturn
    //   14453: astore_1
    //   14454: ldc_w 468
    //   14457: iconst_1
    //   14458: new 88	java/lang/StringBuilder
    //   14461: dup
    //   14462: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14465: ldc_w 3656
    //   14468: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14471: aload_1
    //   14472: invokevirtual 3464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14475: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14478: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14481: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14484: aconst_null
    //   14485: areturn
    //   14486: aload 32
    //   14488: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14491: ldc2_w 3657
    //   14494: lcmp
    //   14495: ifne +195 -> 14690
    //   14498: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14501: ifeq +13 -> 14514
    //   14504: ldc_w 468
    //   14507: iconst_2
    //   14508: ldc_w 3660
    //   14511: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14514: aload 32
    //   14516: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14519: arraylength
    //   14520: istore 4
    //   14522: iload 4
    //   14524: bipush 6
    //   14526: if_icmpge +33 -> 14559
    //   14529: ldc_w 468
    //   14532: iconst_2
    //   14533: new 88	java/lang/StringBuilder
    //   14536: dup
    //   14537: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14540: ldc_w 3662
    //   14543: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14546: iload 4
    //   14548: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14551: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14554: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14557: aconst_null
    //   14558: areturn
    //   14559: aload 32
    //   14561: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14564: iconst_0
    //   14565: baload
    //   14566: iconst_4
    //   14567: ishl
    //   14568: aload 32
    //   14570: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14573: iconst_1
    //   14574: baload
    //   14575: iadd
    //   14576: istore 5
    //   14578: iconst_4
    //   14579: newarray byte
    //   14581: astore_1
    //   14582: aload 32
    //   14584: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14587: iconst_2
    //   14588: aload_1
    //   14589: iconst_0
    //   14590: iconst_4
    //   14591: invokestatic 3666	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14594: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14597: ifeq +31 -> 14628
    //   14600: ldc_w 468
    //   14603: iconst_2
    //   14604: new 88	java/lang/StringBuilder
    //   14607: dup
    //   14608: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14611: ldc_w 3668
    //   14614: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14617: iload 5
    //   14619: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14622: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14625: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14628: invokestatic 3674	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   14631: new 3676	ztq
    //   14634: dup
    //   14635: aload_0
    //   14636: iload 5
    //   14638: invokespecial 3679	ztq:<init>	(Lcom/tencent/mobileqq/app/message/OnLinePushMessageProcessor;I)V
    //   14641: invokevirtual 3683	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   14644: pop
    //   14645: iload 4
    //   14647: bipush 6
    //   14649: if_icmple -14620 -> 29
    //   14652: iload 4
    //   14654: bipush 6
    //   14656: isub
    //   14657: newarray byte
    //   14659: astore 28
    //   14661: aload 32
    //   14663: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14666: bipush 6
    //   14668: aload 28
    //   14670: iconst_0
    //   14671: iload 4
    //   14673: bipush 6
    //   14675: isub
    //   14676: invokestatic 3666	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14679: iload 5
    //   14681: aload_1
    //   14682: aload 28
    //   14684: invokestatic 3688	com/tencent/mobileqq/app/utils/LinkStarDebugProcessor:a	(I[B[B)Z
    //   14687: pop
    //   14688: aconst_null
    //   14689: areturn
    //   14690: aload 32
    //   14692: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14695: ldc2_w 3689
    //   14698: lcmp
    //   14699: ifne +183 -> 14882
    //   14702: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14705: ifeq +13 -> 14718
    //   14708: ldc_w 468
    //   14711: iconst_2
    //   14712: ldc_w 3692
    //   14715: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14718: aload_0
    //   14719: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14722: sipush 251
    //   14725: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14728: checkcast 3694	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryNodeConfigManager
    //   14731: astore 28
    //   14733: new 3696	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify
    //   14736: dup
    //   14737: invokespecial 3697	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:<init>	()V
    //   14740: astore_1
    //   14741: aload_1
    //   14742: aload 32
    //   14744: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14747: invokevirtual 3698	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14750: pop
    //   14751: aload_0
    //   14752: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14755: sipush 250
    //   14758: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14761: checkcast 3700	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryManager
    //   14764: astore 29
    //   14766: aload 28
    //   14768: getfield 3701	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryNodeConfigManager:jdField_a_of_type_Boolean	Z
    //   14771: ifeq +12 -> 14783
    //   14774: aload 29
    //   14776: invokevirtual 3704	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryManager:a	()Lcom/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeListLoader;
    //   14779: aload_1
    //   14780: invokevirtual 3709	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeListLoader:a	(Lcom/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify;)V
    //   14783: new 3711	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo
    //   14786: dup
    //   14787: invokespecial 3712	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo:<init>	()V
    //   14790: astore 28
    //   14792: aload 28
    //   14794: aload_1
    //   14795: getfield 3716	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:msg_notify_node_info	Lcom/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodeInfo;
    //   14798: invokevirtual 3719	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodeInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14801: checkcast 3718	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodeInfo
    //   14804: invokevirtual 3722	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo:a	(Lcom/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodeInfo;)V
    //   14807: aload_0
    //   14808: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14811: sipush 196
    //   14814: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14817: checkcast 3724	com/tencent/biz/qqstory/base/StoryHaloManager
    //   14820: astore 29
    //   14822: aload 29
    //   14824: aload_1
    //   14825: getfield 3727	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:bytes_current_seq	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   14828: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   14831: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   14834: invokevirtual 3728	com/tencent/biz/qqstory/base/StoryHaloManager:a	(Ljava/lang/String;)V
    //   14837: aload 29
    //   14839: invokevirtual 3731	com/tencent/biz/qqstory/base/StoryHaloManager:a	()Lcom/tencent/biz/qqstory/network/handler/RecentTabHaloBatchLoader;
    //   14842: aload 28
    //   14844: invokevirtual 3736	com/tencent/biz/qqstory/network/handler/RecentTabHaloBatchLoader:a	(Lcom/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo;)V
    //   14847: aconst_null
    //   14848: areturn
    //   14849: astore_1
    //   14850: ldc_w 468
    //   14853: iconst_1
    //   14854: new 88	java/lang/StringBuilder
    //   14857: dup
    //   14858: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14861: ldc_w 3738
    //   14864: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14867: aload_1
    //   14868: invokevirtual 3739	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   14871: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14874: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14877: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14880: aconst_null
    //   14881: areturn
    //   14882: aload 32
    //   14884: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14887: ldc2_w 3740
    //   14890: lcmp
    //   14891: ifne +81 -> 14972
    //   14894: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14897: ifeq +34 -> 14931
    //   14900: ldc_w 468
    //   14903: iconst_2
    //   14904: new 88	java/lang/StringBuilder
    //   14907: dup
    //   14908: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14911: ldc_w 3743
    //   14914: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14917: aload 32
    //   14919: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14922: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14925: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14928: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14931: aload_0
    //   14932: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14935: sipush 252
    //   14938: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14941: checkcast 3745	com/tencent/biz/qqstory/base/QQStoryFeedManager
    //   14944: astore 28
    //   14946: aload_1
    //   14947: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   14950: lstore_2
    //   14951: aload 28
    //   14953: aload 28
    //   14955: aload 32
    //   14957: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14960: lload_2
    //   14961: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   14964: invokevirtual 3748	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	([BLjava/lang/String;)Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;
    //   14967: invokevirtual 3751	com/tencent/biz/qqstory/base/QQStoryFeedManager:a	(Lcom/tencent/mobileqq/data/MessageForQQStoryFeed;)V
    //   14970: aconst_null
    //   14971: areturn
    //   14972: aload 32
    //   14974: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14977: ldc2_w 3752
    //   14980: lcmp
    //   14981: ifne -14952 -> 29
    //   14984: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14987: ifeq +13 -> 15000
    //   14990: ldc_w 468
    //   14993: iconst_2
    //   14994: ldc_w 3755
    //   14997: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15000: new 3757	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody
    //   15003: dup
    //   15004: invokespecial 3758	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:<init>	()V
    //   15007: astore_1
    //   15008: aload 32
    //   15010: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15013: ifnull -14984 -> 29
    //   15016: aload_1
    //   15017: aload 32
    //   15019: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15022: invokevirtual 3759	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15025: pop
    //   15026: aload_1
    //   15027: getfield 3762	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:rpt_now_push_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   15030: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   15033: invokeinterface 51 1 0
    //   15038: astore_1
    //   15039: aload_1
    //   15040: invokeinterface 56 1 0
    //   15045: ifeq -15016 -> 29
    //   15048: aload_1
    //   15049: invokeinterface 60 1 0
    //   15054: checkcast 3764	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg
    //   15057: astore 28
    //   15059: aload_0
    //   15060: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15063: sipush 265
    //   15066: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15069: checkcast 3766	com/tencent/mobileqq/now/enter/NowHongbaoPushManager
    //   15072: aload 28
    //   15074: invokevirtual 3769	com/tencent/mobileqq/now/enter/NowHongbaoPushManager:a	(Lcom/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg;)V
    //   15077: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15080: ifeq -41 -> 15039
    //   15083: ldc_w 468
    //   15086: iconst_2
    //   15087: new 88	java/lang/StringBuilder
    //   15090: dup
    //   15091: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15094: ldc_w 3771
    //   15097: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15100: aload 28
    //   15102: getfield 3774	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15105: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15108: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15111: ldc_w 3776
    //   15114: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15117: aload 28
    //   15119: getfield 3777	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15122: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15125: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15128: ldc_w 3779
    //   15131: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15134: aload 28
    //   15136: getfield 3780	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15139: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15142: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15145: ldc_w 3782
    //   15148: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15151: aload 28
    //   15153: getfield 3785	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_start_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15156: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15159: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15162: ldc_w 3787
    //   15165: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15168: aload 28
    //   15170: getfield 3790	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15173: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15176: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15179: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15182: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15185: goto -146 -> 15039
    //   15188: astore_1
    //   15189: ldc_w 468
    //   15192: iconst_1
    //   15193: new 88	java/lang/StringBuilder
    //   15196: dup
    //   15197: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15200: ldc_w 3792
    //   15203: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15206: aload_1
    //   15207: invokevirtual 3464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   15210: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15213: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15216: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15219: aconst_null
    //   15220: areturn
    //   15221: aload 32
    //   15223: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15226: ldc2_w 3793
    //   15229: lcmp
    //   15230: ifne -15201 -> 29
    //   15233: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15236: ifeq +13 -> 15249
    //   15239: ldc_w 468
    //   15242: iconst_2
    //   15243: ldc_w 3796
    //   15246: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15249: new 3798	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody
    //   15252: dup
    //   15253: invokespecial 3799	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:<init>	()V
    //   15256: astore 28
    //   15258: aload 32
    //   15260: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15263: ifnull -15234 -> 29
    //   15266: aload 28
    //   15268: aload 32
    //   15270: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15273: invokevirtual 3800	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15276: pop
    //   15277: aload 28
    //   15279: getfield 3801	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15282: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   15285: ifeq +87 -> 15372
    //   15288: aload 28
    //   15290: getfield 3801	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15293: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   15296: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   15299: astore_1
    //   15300: aload 28
    //   15302: getfield 3804	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15305: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   15308: ifeq +70 -> 15378
    //   15311: aload 28
    //   15313: getfield 3804	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15316: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   15319: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   15322: astore 28
    //   15324: invokestatic 3809	com/tencent/mobileqq/ark/ArkTipsManager:a	()Lcom/tencent/mobileqq/ark/ArkTipsManager;
    //   15327: aload_0
    //   15328: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15331: aload_1
    //   15332: aload 28
    //   15334: invokevirtual 3811	com/tencent/mobileqq/ark/ArkTipsManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   15337: aconst_null
    //   15338: areturn
    //   15339: astore_1
    //   15340: ldc_w 468
    //   15343: iconst_1
    //   15344: new 88	java/lang/StringBuilder
    //   15347: dup
    //   15348: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15351: ldc_w 3813
    //   15354: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15357: aload_1
    //   15358: invokevirtual 3464	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   15361: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15364: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15367: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15370: aconst_null
    //   15371: areturn
    //   15372: ldc 140
    //   15374: astore_1
    //   15375: goto -75 -> 15300
    //   15378: ldc 140
    //   15380: astore 28
    //   15382: goto -58 -> 15324
    //   15385: astore 28
    //   15387: goto -4889 -> 10498
    //   15390: astore_1
    //   15391: goto -6448 -> 8943
    //   15394: astore 30
    //   15396: goto -11808 -> 3588
    //   15399: astore 30
    //   15401: goto -11813 -> 3588
    //   15404: iconst_0
    //   15405: istore 19
    //   15407: goto -4665 -> 10742
    //   15410: iload 21
    //   15412: istore 24
    //   15414: iload 22
    //   15416: istore 25
    //   15418: iload 20
    //   15420: istore 26
    //   15422: iload 19
    //   15424: istore 27
    //   15426: goto -5848 -> 9578
    //   15429: goto -6035 -> 9394
    //   15432: aconst_null
    //   15433: astore_1
    //   15434: goto -8207 -> 7227
    //   15437: iconst_0
    //   15438: istore 6
    //   15440: goto -11109 -> 4331
    //   15443: iconst_0
    //   15444: istore 5
    //   15446: goto -11136 -> 4310
    //   15449: aconst_null
    //   15450: astore 30
    //   15452: goto -11967 -> 3485
    //   15455: aconst_null
    //   15456: astore 29
    //   15458: goto -12007 -> 3451
    //   15461: aconst_null
    //   15462: astore 28
    //   15464: goto -12051 -> 3413
    //   15467: iload 7
    //   15469: ifge -11022 -> 4447
    //   15472: iload 8
    //   15474: iflt -10993 -> 4481
    //   15477: goto -11030 -> 4447
    //   15480: iload 5
    //   15482: ifne -10958 -> 4524
    //   15485: iload 6
    //   15487: ifeq -11341 -> 4146
    //   15490: goto -10966 -> 4524
    //   15493: aload 29
    //   15495: astore 28
    //   15497: iload 5
    //   15499: istore 4
    //   15501: goto -7965 -> 7536
    //   15504: aload 30
    //   15506: areturn
    //   15507: sipush 1001
    //   15510: istore 4
    //   15512: aload 29
    //   15514: astore 28
    //   15516: goto -7980 -> 7536
    //   15519: goto -6951 -> 8568
    //   15522: iconst_0
    //   15523: istore 4
    //   15525: iload 5
    //   15527: iconst_3
    //   15528: if_icmpne -4054 -> 11474
    //   15531: iconst_0
    //   15532: istore 4
    //   15534: goto -4159 -> 11375
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	15537	0	this	OnLinePushMessageProcessor
    //   0	15537	1	paramMsgInfo	MsgInfo
    //   0	15537	2	paramLong	long
    //   451	15082	4	i	int
    //   712	14817	5	j	int
    //   3963	11523	6	k	int
    //   4332	11136	7	m	int
    //   4335	11138	8	n	int
    //   4387	5506	9	i1	int
    //   9172	787	10	i2	int
    //   9741	63	11	i3	int
    //   9754	57	12	i4	int
    //   9767	54	13	i5	int
    //   9777	41	14	i6	int
    //   2343	11895	15	l1	long
    //   5898	83	17	l2	long
    //   193	15230	19	bool1	boolean
    //   9042	6377	20	bool2	boolean
    //   9072	6339	21	bool3	boolean
    //   9012	6403	22	bool4	boolean
    //   9027	1333	23	bool5	boolean
    //   9481	5932	24	bool6	boolean
    //   9485	5932	25	bool7	boolean
    //   9489	5932	26	bool8	boolean
    //   9493	5932	27	bool9	boolean
    //   108	2210	28	localObject1	Object
    //   2367	1	28	localException1	Exception
    //   2489	315	28	localObject2	Object
    //   2817	26	28	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   3330	295	28	localObject3	Object
    //   3631	3	28	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   3864	7779	28	localObject4	Object
    //   11651	20	28	localException2	Exception
    //   11742	20	28	localException3	Exception
    //   11842	8	28	localTroopTopicMgr	com.tencent.mobileqq.troop.utils.TroopTopicMgr
    //   12103	1	28	localException4	Exception
    //   12143	83	28	localMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody
    //   12725	109	28	localException5	Exception
    //   12847	2534	28	localObject5	Object
    //   15385	1	28	localThrowable	java.lang.Throwable
    //   15462	53	28	localObject6	Object
    //   171	2429	29	localObject7	Object
    //   2610	36	29	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   3370	12143	29	localObject8	Object
    //   650	2882	30	localObject9	Object
    //   3586	1	30	localException6	Exception
    //   3598	8691	30	localObject10	Object
    //   15394	1	30	localException7	Exception
    //   15399	1	30	localException8	Exception
    //   15450	55	30	localMessageRecord	MessageRecord
    //   729	11963	31	localObject11	Object
    //   22	15247	32	localObject12	Object
    //   2115	10491	33	localObject13	Object
    //   7831	109	34	localFriendsManager	FriendsManager
    // Exception table:
    //   from	to	target	type
    //   427	487	489	java/lang/Exception
    //   521	620	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   625	636	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   639	667	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   667	682	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   682	714	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   720	758	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   758	835	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   892	915	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   920	1009	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1009	1054	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1057	1132	838	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1147	1211	1428	java/lang/Exception
    //   1211	1248	1428	java/lang/Exception
    //   1248	1281	1428	java/lang/Exception
    //   1281	1387	1428	java/lang/Exception
    //   1387	1426	1428	java/lang/Exception
    //   1776	1893	2009	java/lang/Exception
    //   1898	1916	2009	java/lang/Exception
    //   1916	2007	2009	java/lang/Exception
    //   2108	2128	2367	java/lang/Exception
    //   2128	2162	2367	java/lang/Exception
    //   2162	2196	2367	java/lang/Exception
    //   2196	2230	2367	java/lang/Exception
    //   2230	2254	2367	java/lang/Exception
    //   2254	2310	2367	java/lang/Exception
    //   2310	2328	2367	java/lang/Exception
    //   2491	2502	2610	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2757	2767	2817	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3375	3409	3586	java/lang/Exception
    //   3278	3294	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3294	3361	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3375	3409	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3413	3447	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3451	3485	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3497	3547	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3600	3616	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3673	3689	3631	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3810	3830	4611	java/lang/Exception
    //   3833	3866	4611	java/lang/Exception
    //   3869	3890	4611	java/lang/Exception
    //   3890	3924	4611	java/lang/Exception
    //   3932	3956	4611	java/lang/Exception
    //   3968	3989	4611	java/lang/Exception
    //   3989	4010	4611	java/lang/Exception
    //   4010	4030	4611	java/lang/Exception
    //   4030	4051	4611	java/lang/Exception
    //   4051	4117	4611	java/lang/Exception
    //   4117	4131	4611	java/lang/Exception
    //   4136	4146	4611	java/lang/Exception
    //   4146	4183	4611	java/lang/Exception
    //   4200	4261	4611	java/lang/Exception
    //   4263	4283	4611	java/lang/Exception
    //   4283	4310	4611	java/lang/Exception
    //   4310	4331	4611	java/lang/Exception
    //   4337	4358	4611	java/lang/Exception
    //   4358	4379	4611	java/lang/Exception
    //   4379	4444	4611	java/lang/Exception
    //   4447	4481	4611	java/lang/Exception
    //   4481	4521	4611	java/lang/Exception
    //   4524	4569	4611	java/lang/Exception
    //   4569	4608	4611	java/lang/Exception
    //   4655	4682	4611	java/lang/Exception
    //   4682	4731	4611	java/lang/Exception
    //   4731	4758	4611	java/lang/Exception
    //   4758	4785	4611	java/lang/Exception
    //   4785	4804	4611	java/lang/Exception
    //   4815	4842	4611	java/lang/Exception
    //   4842	4859	4611	java/lang/Exception
    //   4870	4894	4611	java/lang/Exception
    //   4897	4918	4611	java/lang/Exception
    //   4918	4952	4611	java/lang/Exception
    //   4958	5142	4611	java/lang/Exception
    //   5157	5303	4611	java/lang/Exception
    //   5306	5388	4611	java/lang/Exception
    //   5397	5442	4611	java/lang/Exception
    //   5442	5460	4611	java/lang/Exception
    //   5483	5493	5537	java/lang/Throwable
    //   6122	6191	6334	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6191	6257	6334	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6263	6332	6334	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6410	6462	6464	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6553	6588	6616	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6594	6614	6616	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6705	6715	6785	java/lang/Exception
    //   6719	6730	6785	java/lang/Exception
    //   6739	6783	6785	java/lang/Exception
    //   6843	7024	7239	java/lang/Exception
    //   7024	7087	7239	java/lang/Exception
    //   7229	7236	7239	java/lang/Exception
    //   7297	7332	7334	java/lang/Exception
    //   7382	7417	7419	java/lang/Exception
    //   7471	7482	7799	java/lang/Exception
    //   7497	7536	7799	java/lang/Exception
    //   7536	7680	7799	java/lang/Exception
    //   7680	7744	7799	java/lang/Exception
    //   7752	7765	7799	java/lang/Exception
    //   7773	7786	7799	java/lang/Exception
    //   7789	7796	7799	java/lang/Exception
    //   7853	7935	8113	java/lang/Exception
    //   7939	7948	8113	java/lang/Exception
    //   7953	7961	8113	java/lang/Exception
    //   7964	8095	8113	java/lang/Exception
    //   8212	8222	8283	java/lang/Throwable
    //   8363	8383	8385	java/lang/Exception
    //   8450	8462	8464	java/lang/Throwable
    //   8507	8568	8607	java/lang/Exception
    //   8568	8577	8607	java/lang/Exception
    //   8577	8605	8607	java/lang/Exception
    //   8626	8635	8607	java/lang/Exception
    //   8638	8647	8607	java/lang/Exception
    //   8650	8659	8607	java/lang/Exception
    //   8698	8748	8895	java/lang/Exception
    //   8748	8778	8895	java/lang/Exception
    //   8788	8828	8895	java/lang/Exception
    //   8836	8866	8895	java/lang/Exception
    //   8866	8893	8895	java/lang/Exception
    //   10553	10572	10606	java/lang/Exception
    //   10800	10811	11116	java/lang/Exception
    //   10811	10834	11116	java/lang/Exception
    //   10834	10858	11116	java/lang/Exception
    //   10858	10882	11116	java/lang/Exception
    //   10882	10960	11116	java/lang/Exception
    //   10960	11114	11116	java/lang/Exception
    //   10644	10665	11139	java/lang/Exception
    //   10669	10729	11139	java/lang/Exception
    //   10729	10738	11139	java/lang/Exception
    //   10742	10763	11163	java/lang/Exception
    //   11255	11372	11455	java/lang/Exception
    //   11375	11453	11455	java/lang/Exception
    //   11508	11527	11561	java/lang/Exception
    //   11604	11614	11651	java/lang/Exception
    //   11713	11723	11742	java/lang/Exception
    //   11812	11844	11877	java/lang/Exception
    //   11849	11875	11877	java/lang/Exception
    //   11925	11959	11961	java/lang/Exception
    //   12001	12016	12018	java/lang/Exception
    //   12073	12083	12103	java/lang/Exception
    //   12145	12225	12725	java/lang/Exception
    //   12225	12238	12725	java/lang/Exception
    //   12243	12278	12725	java/lang/Exception
    //   12278	12336	12725	java/lang/Exception
    //   12336	12370	12725	java/lang/Exception
    //   12370	12395	12725	java/lang/Exception
    //   12395	12420	12725	java/lang/Exception
    //   12420	12454	12725	java/lang/Exception
    //   12454	12481	12725	java/lang/Exception
    //   12481	12515	12725	java/lang/Exception
    //   12515	12539	12725	java/lang/Exception
    //   12539	12563	12725	java/lang/Exception
    //   12568	12592	12725	java/lang/Exception
    //   12592	12616	12725	java/lang/Exception
    //   12616	12650	12725	java/lang/Exception
    //   12650	12674	12725	java/lang/Exception
    //   12674	12708	12725	java/lang/Exception
    //   12708	12722	12725	java/lang/Exception
    //   12782	12819	12725	java/lang/Exception
    //   12819	12865	12725	java/lang/Exception
    //   12904	12954	13011	java/lang/Exception
    //   12960	12989	13011	java/lang/Exception
    //   12994	13009	13011	java/lang/Exception
    //   13031	13047	13011	java/lang/Exception
    //   13104	13133	13135	java/lang/Exception
    //   13183	13285	13287	java/lang/Exception
    //   13677	13706	13708	java/lang/Exception
    //   13909	13938	13940	java/lang/Exception
    //   14048	14127	14219	java/lang/Exception
    //   14134	14144	14219	java/lang/Exception
    //   14149	14168	14219	java/lang/Exception
    //   14168	14196	14219	java/lang/Exception
    //   14203	14216	14219	java/lang/Exception
    //   14233	14246	14219	java/lang/Exception
    //   14270	14350	14352	java/lang/Exception
    //   14417	14443	14453	java/lang/Exception
    //   14443	14451	14453	java/lang/Exception
    //   14733	14783	14849	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   14783	14847	14849	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   15000	15039	15188	java/lang/Exception
    //   15039	15185	15188	java/lang/Exception
    //   15249	15300	15339	java/lang/Exception
    //   15300	15324	15339	java/lang/Exception
    //   15324	15337	15339	java/lang/Exception
    //   10488	10498	15385	java/lang/Throwable
    //   8932	8943	15390	java/lang/Throwable
    //   3413	3447	15394	java/lang/Exception
    //   3451	3485	15399	java/lang/Exception
  }
  
  private zts b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt)).a(OnLinePushMsgTypeProcessorDispatcher.a(paramInt), paramMsgInfo, paramSvcReqPushMsg);
  }
  
  private void b(long paramLong, byte[] paramArrayOfByte)
  {
    Object localObject1 = new submsgtype0x31.MsgBody();
    int i;
    long l1;
    SubAccountManager localSubAccountManager;
    try
    {
      paramArrayOfByte = (submsgtype0x31.MsgBody)((submsgtype0x31.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null)
      {
        paramArrayOfByte = new HashMap();
        paramArrayOfByte.put("param_FailCode", "12017");
        paramArrayOfByte.put("fail_step", "msgbyod_null");
        paramArrayOfByte.put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      do
      {
        long l2;
        do
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decodeC2CMsgPkg_SecretfileReport parse failed.", paramArrayOfByte);
            }
            paramArrayOfByte = null;
          }
          if ((!paramArrayOfByte.uint32_flag.has()) || (!paramArrayOfByte.uint64_bind_uin.has()) || (!paramArrayOfByte.uint64_uin.has()))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uinflag_null");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
          i = paramArrayOfByte.uint32_flag.get();
          l1 = paramArrayOfByte.uint32_time.get();
          l1 = paramArrayOfByte.uint64_uin.get();
          l2 = paramArrayOfByte.uint64_bind_uin.get();
          if ((l1 <= 0L) || (l2 <= 0L))
          {
            paramArrayOfByte = new HashMap();
            paramArrayOfByte.put("param_FailCode", "12017");
            paramArrayOfByte.put("fail_step", "uin_error");
            paramArrayOfByte.put("fail_location", "MessageHandler");
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", false, 0L, 0L, paramArrayOfByte, "");
            return;
          }
        } while (!String.valueOf(paramLong).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
        paramArrayOfByte = new SubAccountBackProtocData();
        paramArrayOfByte.c = String.valueOf(l1);
        paramArrayOfByte.b = String.valueOf(l2);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("param_FailCode", "12018");
        ((HashMap)localObject1).put("fail_step", "success_" + i);
        ((HashMap)localObject1).put("fail_location", "MessageHandler");
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actSBPushNotifaction", true, 0L, 0L, (HashMap)localObject1, "");
        localObject1 = (SubAccountControll)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(61);
        if (i == 1)
        {
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (byte)0, paramArrayOfByte.c);
          SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte.c);
          paramArrayOfByte.a = 1;
          ((SubAccountControll)localObject1).a(paramArrayOfByte.c, 1);
          a(8004, true, paramArrayOfByte);
          return;
        }
      } while (i != 0);
      localObject1 = String.valueOf(l1);
      localSubAccountManager = (SubAccountManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(60);
      paramArrayOfByte.a((String)localObject1);
      localSubAccountManager.a(paramArrayOfByte);
      Object localObject2 = paramArrayOfByte.a();
      if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
      {
        localObject2 = ((ArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint is new,msg num=1, subUin=" + str);
          }
          i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 7000);
          if (i != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, 7000, i);
          }
        }
      }
      boolean bool = false;
      localObject2 = SubAccountControll.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject1);
      if (localObject2 != null) {
        bool = ((Boolean)((Pair)localObject2).second).booleanValue();
      }
      if (!bool) {
        break label783;
      }
    }
    localSubAccountManager.a((String)localObject1, 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l1), new ztr(this, localSubAccountManager));
    for (;;)
    {
      paramArrayOfByte.a = 0;
      a(8004, true, paramArrayOfByte);
      return;
      label783:
      if (localSubAccountManager.a(String.valueOf(l1), 2))
      {
        i = 1 - this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((String)localObject1, 7000);
        if (i != 0)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c((String)localObject1, 7000, i);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new String[] { AppConstants.w, localObject1 });
        }
        if (QLog.isColorLevel()) {
          QLog.d("SUB_ACCOUNT", 2, "decodeC2CMsgPush() hint need to verify,msg num=1, subUin=" + (String)localObject1);
        }
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private boolean c(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    return true;
  }
  
  private void f(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessorQ.nearby.video_chat", 2, "handleMsgType0x210SuMsgType0xe4");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      Intent localIntent = new Intent("tencent.video.q2v.nearbyVideoChatPush");
      localIntent.putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
      localIntent.putExtra("pushData", paramArrayOfByte);
      NearbyVideoProxyBroadcastReceiver.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), localIntent);
    }
  }
  
  private void g(byte[] paramArrayOfByte)
  {
    long l = PkgTools.a(paramArrayOfByte, 0);
    String str = String.valueOf(l);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel()) {
      QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg cOp = " + i);
    }
    int j;
    HotChatManager localHotChatManager;
    HotChatInfo localHotChatInfo;
    if (i == 3)
    {
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      localHotChatManager = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
      localHotChatInfo = localHotChatManager.a(String.valueOf(l));
      if (j == 3)
      {
        int k = paramArrayOfByte[11];
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j + ", cSubOp2 = " + k);
        }
        switch (k)
        {
        }
      }
    }
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
                do
                {
                  do
                  {
                    do
                    {
                      return;
                    } while (localHotChatInfo == null);
                    localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
                    HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437330), true);
                    HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                    ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
                    return;
                  } while (localHotChatInfo == null);
                  localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                  HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437328), true);
                  HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                  ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                  return;
                } while (localHotChatInfo == null);
                localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437321), true);
                HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                return;
                if (j != 2) {
                  break;
                }
              } while (localHotChatInfo == null);
              localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
              HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437327), false);
              HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
              ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY });
            } while (localHotChatInfo.apolloGameId <= 0);
            ((ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo.name, localHotChatInfo.apolloGameId, localHotChatInfo.troopUin);
            return;
          } while (j != 1);
          paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        } while (paramArrayOfByte == null);
        paramArrayOfByte.a(l, false);
        return;
      } while (i != 1);
      j = paramArrayOfByte[10];
      if (QLog.isColorLevel()) {
        QLog.i("Q.msg.BaseMessageProcessor", 2, "----->handleTroopExitMsg dwGroupCode = " + l + ", cOp = " + i + ", cSubOp = " + j);
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    } while (paramArrayOfByte == null);
    switch (j)
    {
    default: 
      return;
    case 0: 
    case 2: 
      paramArrayOfByte.a(l, true);
      return;
    case 1: 
      paramArrayOfByte.b(l, false);
      return;
    }
    paramArrayOfByte.b(l, true);
  }
  
  public String a(byte[] paramArrayOfByte)
  {
    String str = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse start");
    }
    SubMsgType0xb3.PushAddFrdNotify localPushAddFrdNotify;
    int i;
    int j;
    long l1;
    MessageHandler localMessageHandler;
    for (;;)
    {
      try
      {
        paramArrayOfByte = (SubMsgType0xb3.MsgBody)new SubMsgType0xb3.MsgBody().mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msgBody is null.");
          }
          return null;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
        continue;
        if (!paramArrayOfByte.msg_add_frd_notify.has())
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0xb3 | msg_add_frd_notify is null.");
          return null;
        }
        localPushAddFrdNotify = (SubMsgType0xb3.PushAddFrdNotify)paramArrayOfByte.msg_add_frd_notify.get();
        i = localPushAddFrdNotify.uint32_source_id.get();
        j = localPushAddFrdNotify.uint32_subsource_id.get();
        if (!localPushAddFrdNotify.uint64_req_uin.has()) {
          break;
        }
      }
      l1 = localPushAddFrdNotify.uint64_req_uin.get();
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.BaseMessageProcessorQ.nearby.follow", 2, "decodeC2CMsgPkgSubMsgType0xb3, sourceid:" + i + "|subSourceid:" + j + " |reqUin: " + l1);
      }
      if ((i != 3076) && (i != 3077) && (i != 2076) && (i != 2077) && (i != 10012) && (i != 10013))
      {
        boolean bool = EAddFriendSourceID.a(i);
        localMessageHandler = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
        if (!bool) {
          break label415;
        }
        if (!localPushAddFrdNotify.bytes_mobile.has()) {
          break label402;
        }
        paramArrayOfByte = localPushAddFrdNotify.bytes_mobile.get().toStringUtf8();
      }
    }
    for (;;)
    {
      label301:
      long l3 = localPushAddFrdNotify.uint64_fuin.get();
      if (localPushAddFrdNotify.uint64_fuin_bubble_id.has()) {}
      for (long l2 = localPushAddFrdNotify.uint64_fuin_bubble_id.get();; l2 = -1L)
      {
        if (localPushAddFrdNotify.bytes_wording.has()) {
          str = localPushAddFrdNotify.bytes_wording.get().toStringUtf8();
        }
        localMessageHandler.a(String.valueOf(l3), paramArrayOfByte, l2, str, localPushAddFrdNotify.fixed32_timestamp.get(), i, j, l1);
        return String.valueOf(localPushAddFrdNotify.uint64_fuin.get());
        l1 = 0L;
        break;
        label402:
        paramArrayOfByte = null;
        break label301;
      }
      label415:
      paramArrayOfByte = null;
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 3))
    {
      a((ToServiceMsg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (SvcReqPushMsg)paramVarArgs[2]);
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse start");
    }
    try
    {
      paramArrayOfByte = (submsgtype0x44.MsgBody)new submsgtype0x44.MsgBody().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte == null) {
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 parse failed.", paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      if (QLog.isColorLevel())
      {
        if ((paramArrayOfByte.msg_friend_msg_sync.has()) && (paramArrayOfByte.msg_friend_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get() + ";fuin" + paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
        }
        if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";processtype=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get() + ";grp_code=" + paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
        }
        if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null)) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
        }
      }
      if (!paramArrayOfByte.msg_friend_msg_sync.has()) {
        break label1231;
      }
    }
    int i;
    label349:
    Object localObject2;
    Object localObject1;
    if (paramArrayOfByte.msg_friend_msg_sync.get() != null) {
      if (a(paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get()))
      {
        i = 1;
        if (c(paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get()))
        {
          localObject2 = String.valueOf(paramArrayOfByte.msg_friend_msg_sync.uint64_fuin.get());
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (StringUtil.c((String)localObject2)))
          {
            localObject1 = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
            j = paramArrayOfByte.msg_friend_msg_sync.uint32_sourceid.get();
            localObject2 = String.valueOf(localObject2);
            if (!((FriendListHandler)localObject1).a((String)localObject2, 0, j, null, false, false, -1L)) {
              ((FriendListHandler)localObject1).a((String)localObject2);
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_friend_msg_sync uint32_processflag=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processflag.get() + ";uint32_processtype=" + paramArrayOfByte.msg_friend_msg_sync.uint32_processtype.get());
        }
      }
    }
    label560:
    label1231:
    for (int j = i;; j = 0)
    {
      if ((paramArrayOfByte.msg_group_msg_sync.has()) && (paramArrayOfByte.msg_group_msg_sync.get() != null)) {
        if (a(paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get()))
        {
          i = 1;
          if (b(paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get()))
          {
            localObject1 = String.valueOf(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            Object localObject3 = SystemMsgUtils.a(paramArrayOfByte.msg_group_msg_sync.uint64_grp_code.get());
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject3)) && (StringUtil.c((String)localObject1)))
            {
              TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
              if (localTroopManager.a((String)localObject1) == null)
              {
                localObject2 = new TroopInfo();
                ((TroopInfo)localObject2).troopuin = ((String)localObject1);
                ((TroopInfo)localObject2).troopcode = ((String)localObject3);
                localTroopManager.a((TroopInfo)localObject2);
                localObject3 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
                ((TroopHandler)localObject3).b(((TroopInfo)localObject2).troopuin, false);
                ((TroopHandler)localObject3).a(((TroopInfo)localObject2).troopuin, (byte)1, ((TroopInfo)localObject2).dwTimeStamp, 0);
                ((TroopHandler)localObject3).a(6, true, new Object[] { Integer.valueOf(6), Byte.valueOf(0), localObject1 });
              }
              a(2001, true, null);
            }
          }
          k = i;
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_group_msg_sync uint32_processflag=" + paramArrayOfByte.msg_group_msg_sync.uint32_processflag.get() + ";uint32_msg_type=" + paramArrayOfByte.msg_group_msg_sync.uint32_msg_type.get());
          }
        }
      }
      for (int k = i;; k = 0)
      {
        if ((j != 0) || (k != 0))
        {
          if ((j == 0) || (k == 0)) {
            break label1173;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(4);
        }
        for (;;)
        {
          if ((paramArrayOfByte.msg_clean_count_msg.has()) && (paramArrayOfByte.msg_clean_count_msg.get() != null))
          {
            if (a(paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get()))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.S, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
              GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
              FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
              localObject1 = (NewFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(AppConstants.K, 0, true, true);
              ((NewFriendManager)localObject1).a();
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_clean_count_msg uint32_processflag=" + paramArrayOfByte.msg_clean_count_msg.uint32_processflag.get());
            }
          }
          if ((paramArrayOfByte.msg_modify_msg_sync.has()) && (paramArrayOfByte.msg_modify_msg_sync.get() != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().b(2);
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_modify_msg_sync =" + paramArrayOfByte.msg_modify_msg_sync.get());
            }
          }
          if ((!paramArrayOfByte.msg_waiting_msg_sync.has()) || (paramArrayOfByte.msg_waiting_msg_sync.get() == null)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("Q.msg.BaseMessageProcessor", 2, "decodeC2CMsgPkgSubMsgType0x44 msg_waiting_msg_sync =" + paramArrayOfByte.msg_waiting_msg_sync.get());
          return;
          if (j != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(2);
          } else if (k != 0) {
            this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a().a(3, 1, false);
          }
        }
        i = 0;
        break label560;
      }
      i = 0;
      break label349;
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel()) {
            QLog.d("share_appid", 2, "Request list add appid = " + str);
          }
        }
      }
      if (localArrayList.size() > 0) {
        ConfigUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void a(SubMsgType0xa8.MsgBody paramMsgBody)
  {
    if (!a()) {
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, "handlePullActivePushMsg, isNeedNotifyActivePush is false");
      }
    }
    Object localObject2;
    Object localObject1;
    int i;
    do
    {
      do
      {
        return;
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
      } while (!paramMsgBody.bytes_msg_summary.has());
      localObject2 = paramMsgBody.bytes_msg_summary.get().toStringUtf8();
      localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", MainFragment.a);
      ((Intent)localObject1).putExtra("fragment_id", 1);
      ((Intent)localObject1).setFlags(335544320);
      i = paramMsgBody.uint32_action_type.get();
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionType: %d, brief: %s", new Object[] { Integer.valueOf(i), localObject2 }));
      }
      if (i != 1) {
        break;
      }
    } while (!paramMsgBody.uint32_action_subType.has());
    int j = paramMsgBody.uint32_action_subType.get();
    ((Intent)localObject1).putExtra("extra_pull_active_push_type", i);
    ((Intent)localObject1).putExtra("extra_pull_active_push_subtype", j);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionSubType: %d", new Object[] { Integer.valueOf(j) }));
    }
    for (;;)
    {
      ((Intent)localObject1).putExtra(PullActiveManager.b, (String)localObject2);
      ((Intent)localObject1).putExtra("activepull_push_flag", true);
      paramMsgBody = PullActiveManager.jdField_a_of_type_JavaLangString;
      Bitmap localBitmap = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130839193);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject2, paramMsgBody, localObject2 });
      localToServiceMsg.extraData.putParcelable("intent", (Parcelable)localObject1);
      localToServiceMsg.extraData.putParcelable("bitmap", localBitmap);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
      paramMsgBody = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext();
      if (!QQUtils.a(paramMsgBody)) {
        break;
      }
      localObject2 = (PullActiveManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(144);
      ((PullActiveManager)localObject2).a((Intent)localObject1);
      localObject1 = (QQLSRecentManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(71);
      if (SettingCloneUtil.readValue(paramMsgBody, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMsgBody.getString(2131435404), "qqsetting_lock_screen_whenexit_key", true))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
        }
        ((QQLSRecentManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, AppConstants.ao, 9653, false);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((PullActiveManager)localObject2).jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemPullActivePush);
      return;
      if (i == 2)
      {
        if (!paramMsgBody.bytes_extend_content.has()) {
          break;
        }
        paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
        ((Intent)localObject1).putExtra("extra_pull_active_push_type", i);
        ((Intent)localObject1).putExtra("extra_pull_active_push_url", paramMsgBody);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: url: %s", new Object[] { paramMsgBody }));
        continue;
      }
      if ((i != 3) || (!paramMsgBody.bytes_extend_content.has())) {
        break;
      }
      paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
      ((Intent)localObject1).putExtra("open_chatfragment", true);
      ((Intent)localObject1).putExtra("uin", paramMsgBody);
      ((Intent)localObject1).putExtra("uintype", 1008);
      ((Intent)localObject1).putExtra("isforceRequestDetail", true);
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: public account uin: %s", new Object[] { paramMsgBody }));
      }
    }
  }
  
  public void a(submsgtype0xc7.HotFriendNotify paramHotFriendNotify, HotReactivePushMsg paramHotReactivePushMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "decodeC2CMsgPkgSubMsgType0xc7");
    }
    FriendsManager localFriendsManager;
    long l2;
    ArrayList localArrayList;
    if (paramHotFriendNotify != null)
    {
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      l2 = paramHotFriendNotify.uint64_dst_uin.get();
      localArrayList = new ArrayList();
      paramHotReactivePushMsg = localFriendsManager.a(String.valueOf(l2));
      if (paramHotReactivePushMsg != null) {
        break label1199;
      }
      paramHotReactivePushMsg = new ExtensionInfo();
      paramHotReactivePushMsg.uin = String.valueOf(l2);
    }
    label1199:
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" === hotFriend uin: ").append(l2);
      boolean bool1 = false;
      boolean bool2 = false;
      long l3;
      if (paramHotFriendNotify.uint64_notify_time.has())
      {
        l1 = paramHotFriendNotify.uint64_notify_time.get();
        l3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("inccheckupdatetimeStamp9", 0L);
        bool1 = bool2;
        if (l1 < l3)
        {
          localStringBuilder.append(", notify_time is out of date notifyTime=" + l1 + "timeStamps=" + l3);
          if (QLog.isColorLevel()) {
            QLog.i("HotFriend_PushMessage", 2, localStringBuilder.toString());
          }
          bool1 = true;
        }
        localStringBuilder.append(", notify_time" + l1 + "timeStamps=" + l3);
      }
      long l1 = -1L;
      int i = 1;
      int j = 1;
      if (paramHotFriendNotify.uint64_notify_time.has()) {
        l1 = paramHotFriendNotify.uint64_notify_time.get();
      }
      if (paramHotReactivePushMsg != null)
      {
        i = j;
        if (paramHotReactivePushMsg.lastGrayPushTime == l1)
        {
          i = j;
          if (l1 != -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendReactive", 2, "addHotFriendAIOGrayTips lastPushTime=" + l1 + "needAddGray isfalse");
            }
            i = 0;
          }
        }
        paramHotReactivePushMsg.lastGrayPushTime = l1;
      }
      j = 0;
      if (paramHotFriendNotify.uint32_lover_flag.has())
      {
        j = paramHotFriendNotify.uint32_lover_flag.get();
        if ((!paramHotReactivePushMsg.isQzoneLover) || ((j == 1) || (j == 2)))
        {
          bool2 = true;
          paramHotReactivePushMsg.isQzoneLover = bool2;
          localStringBuilder.append(", isQzoneLover=").append(j);
        }
      }
      else
      {
        int k;
        int m;
        int n;
        if (paramHotFriendNotify.uint32_praise_hot_level.has())
        {
          k = paramHotReactivePushMsg.praiseHotLevel;
          m = paramHotFriendNotify.uint32_praise_hot_level.get();
          paramHotReactivePushMsg.praiseHotLevel = m;
          localStringBuilder.append(", praiseHotLevel=").append(m);
          if (paramHotFriendNotify.uint32_praise_flag.has())
          {
            n = paramHotFriendNotify.uint32_praise_flag.get();
            if (i != 0) {
              a(1, m, n, String.valueOf(l2), k, l1, j);
            }
          }
        }
        if (paramHotFriendNotify.uint32_praise_hot_days.has())
        {
          k = paramHotFriendNotify.uint32_praise_hot_days.get();
          paramHotReactivePushMsg.praiseDays = k;
          localStringBuilder.append(", praiseDays=").append(k);
        }
        if (paramHotFriendNotify.uint32_chat_hot_level.has())
        {
          k = paramHotFriendNotify.uint32_chat_hot_level.get();
          m = paramHotReactivePushMsg.chatHotLevel;
          paramHotReactivePushMsg.chatHotLevel = k;
          localStringBuilder.append(", chatHotLevel=").append(k);
          if (paramHotFriendNotify.uint32_chat_flag.has())
          {
            n = paramHotFriendNotify.uint32_chat_flag.get();
            if (i != 0) {
              a(2, k, n, String.valueOf(l2), m, l1, j);
            }
          }
        }
        if (paramHotFriendNotify.uint32_chat_hot_days.has())
        {
          k = paramHotFriendNotify.uint32_chat_hot_days.get();
          paramHotReactivePushMsg.chatDays = k;
          localStringBuilder.append(", chatDays=").append(k);
        }
        if (paramHotFriendNotify.uint32_close_level.has())
        {
          k = paramHotReactivePushMsg.bestIntimacyType;
          m = paramHotFriendNotify.uint32_close_level.get();
          paramHotReactivePushMsg.bestIntimacyType = m;
          localStringBuilder.append(", closeLevel=").append(m);
          if ((paramHotFriendNotify.uint32_close_flag.has()) || (j == 2) || (j == 3))
          {
            n = paramHotFriendNotify.uint32_close_flag.get();
            if (i != 0) {
              a(3, m, n, String.valueOf(l2), k, l1, j);
            }
          }
        }
        if (paramHotFriendNotify.uint32_close_days.has())
        {
          k = paramHotFriendNotify.uint32_close_days.get();
          paramHotReactivePushMsg.bestIntimacyDays = k;
          localStringBuilder.append(", closeDays=").append(k);
        }
        if (paramHotFriendNotify.uint64_last_praise_time.has())
        {
          l3 = paramHotFriendNotify.uint64_last_praise_time.get();
          paramHotReactivePushMsg.lastpraiseTime = (86400L * l3 - 28800L);
          localStringBuilder.append(", lastpraiseTime=").append(l3);
        }
        if (paramHotFriendNotify.uint64_last_chat_time.has())
        {
          l3 = paramHotFriendNotify.uint64_last_chat_time.get();
          paramHotReactivePushMsg.lastChatTime = (86400L * l3 - 28800L);
          localStringBuilder.append(", lastchatTime=").append(l3);
        }
        if (paramHotFriendNotify.uint32_qzone_hot_level.has())
        {
          k = paramHotReactivePushMsg.qzoneVisitType;
          m = paramHotFriendNotify.uint32_qzone_hot_level.get();
          paramHotReactivePushMsg.qzoneVisitType = m;
          localStringBuilder.append(", qzoneHotLevel=").append(m);
          if (paramHotFriendNotify.uint32_qzone_flag.has())
          {
            n = paramHotFriendNotify.uint32_qzone_flag.get();
            if (i != 0) {
              a(4, m, n, String.valueOf(l2), k, l1, j);
            }
          }
        }
        if (paramHotFriendNotify.uint32_qzone_hot_days.has())
        {
          i = paramHotFriendNotify.uint32_qzone_hot_days.get();
          paramHotReactivePushMsg.qzoneHotDays = i;
          localStringBuilder.append(", qzoneDays=").append(i);
        }
        if (paramHotFriendNotify.uint64_last_qzone_time.has())
        {
          l1 = paramHotFriendNotify.uint64_last_qzone_time.get();
          paramHotReactivePushMsg.lastQzoneVisitTime = (86400L * l1 - 28800L);
          localStringBuilder.append(", lastQzoneVisitTime=").append(l1);
        }
        if (QLog.isColorLevel()) {
          QLog.i("HotFriend_PushMessage", 2, localStringBuilder.toString() + "isTimeOutOfDate=" + bool1);
        }
        if (!bool1)
        {
          localFriendsManager.a(paramHotReactivePushMsg);
          localArrayList.add(String.valueOf(l2));
          if (!localArrayList.isEmpty()) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(107, true, localArrayList);
          }
        }
      }
      do
      {
        return;
        bool2 = false;
        break;
      } while (!QLog.isColorLevel());
      QLog.d("HotFriend_PushMessage", 2, "decodeC2CMsgPkgSubMsgType0xc7 data is null");
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject1 = new SubMsgType0x27.MsgBody();
    FriendsManager localFriendsManager;
    TroopManager localTroopManager;
    PublicAccountDataManager localPublicAccountDataManager;
    PstnManager localPstnManager;
    ApolloManager localApolloManager;
    int j;
    Friends[] arrayOfFriends;
    do
    {
      do
      {
        do
        {
          do
          {
            for (;;)
            {
              try
              {
                paramArrayOfByte = (SubMsgType0x27.MsgBody)((SubMsgType0x27.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
                if (paramArrayOfByte == null) {
                  break;
                }
                localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
                localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                localPublicAccountDataManager = (PublicAccountDataManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55);
                localPstnManager = (PstnManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(142);
                localApolloManager = (ApolloManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
                j = 0;
                paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get();
                arrayOfFriends = new Friends[paramArrayOfByte.size()];
                new ArrayList();
                Iterator localIterator = paramArrayOfByte.iterator();
                if (!localIterator.hasNext()) {
                  break label7829;
                }
                paramArrayOfByte = (SubMsgType0x27.ForwardBody)localIterator.next();
                if ((paramArrayOfByte.uint32_notify_type.has()) && (paramArrayOfByte.uint32_notify_type.get() == 1))
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("cardpush", 2, "push a no content，如何处理？");
                  continue;
                }
                if (!paramArrayOfByte.uint32_op_type.has()) {
                  continue;
                }
              }
              catch (Exception paramArrayOfByte)
              {
                paramArrayOfByte.printStackTrace();
                return;
              }
              switch (paramArrayOfByte.uint32_op_type.get())
              {
              case 60: 
              case 61: 
              default: 
                break;
              case 0: 
                if (paramArrayOfByte.msg_add_group.has())
                {
                  localObject1 = (SubMsgType0x27.AddGroup)paramArrayOfByte.msg_add_group.get();
                  paramArrayOfByte = new Groups();
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.has()) {
                    paramArrayOfByte.group_id = ((SubMsgType0x27.AddGroup)localObject1).uint32_groupid.get();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.has()) {
                    paramArrayOfByte.group_name = ((SubMsgType0x27.AddGroup)localObject1).bytes_groupname.get().toStringUtf8();
                  }
                  if (((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.has()) {
                    paramArrayOfByte.seqid = ((byte)((SubMsgType0x27.AddGroup)localObject1).uint32_sortid.get());
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("cardpush", 2, "push a AddGroup  = id:" + paramArrayOfByte.group_id + " name : " + paramArrayOfByte.group_name + " sortid: " + paramArrayOfByte.seqid);
                  }
                  localFriendsManager.a(paramArrayOfByte);
                  localObject1 = new AddGroupResp();
                  ((AddGroupResp)localObject1).dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                  ((AddGroupResp)localObject1).dwSequence = paramArrayOfByte.seqid;
                  ((AddGroupResp)localObject1).cGroupId = ((byte)paramArrayOfByte.group_id);
                  ((AddGroupResp)localObject1).cSortId = paramArrayOfByte.seqid;
                  paramArrayOfByte = new GroupActionResp(0, "", (AddGroupResp)localObject1);
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(18, true, paramArrayOfByte);
                }
                break;
              case 1: 
                if (paramArrayOfByte.msg_del_group.has())
                {
                  localObject1 = (SubMsgType0x27.DelGroup)paramArrayOfByte.msg_del_group.get();
                  if (((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.has())
                  {
                    localObject2 = localFriendsManager.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
                    if (QLog.isColorLevel()) {
                      QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    }
                    paramArrayOfByte = new DelGroupResp();
                    paramArrayOfByte.dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                    paramArrayOfByte.dwSequence = ((Groups)localObject2).seqid;
                    paramArrayOfByte.cGroupid = ((byte)((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    localObject1 = new GroupActionResp(0, "", paramArrayOfByte);
                    ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a(paramArrayOfByte, true, (GroupActionResp)localObject1);
                  }
                }
                break;
              }
            }
          } while (!paramArrayOfByte.msg_mod_group_name.has());
          localObject1 = (SubMsgType0x27.ModGroupName)paramArrayOfByte.msg_mod_group_name.get();
        } while ((!((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.has()) || (!((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.has()));
        i = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
        localObject2 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
        paramArrayOfByte = localFriendsManager.a(String.valueOf(i));
        if (paramArrayOfByte != null) {}
        for (paramArrayOfByte.group_name = ((String)localObject2);; paramArrayOfByte.group_name = ((String)localObject2))
        {
          localFriendsManager.a(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModGroupName  = id:" + ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get() + " name:" + ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          }
          paramArrayOfByte = new RenameGroupResp();
          paramArrayOfByte.dwToUin = ((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          i = (byte)((SubMsgType0x27.ModGroupName)localObject1).uint32_groupid.get();
          paramArrayOfByte.sGroupName = new String(((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8());
          paramArrayOfByte = new GroupActionResp(0, "", paramArrayOfByte);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(19, true, paramArrayOfByte);
          break;
          paramArrayOfByte = new Groups();
          paramArrayOfByte.group_id = i;
        }
      } while (!paramArrayOfByte.msg_mod_group_sort.has());
      localObject2 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
    } while (localObject2 == null);
    paramArrayOfByte = new byte[((List)localObject2).size()];
    localObject1 = new byte[((List)localObject2).size()];
    Object localObject2 = ((List)localObject2).iterator();
    int i = 0;
    label1208:
    Object localObject4;
    if (((Iterator)localObject2).hasNext())
    {
      localObject4 = (SubMsgType0x27.GroupSort)((Iterator)localObject2).next();
      if ((!((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.has())) {
        break label7857;
      }
      paramArrayOfByte[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get());
      localObject1[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      }
      i += 1;
    }
    label1408:
    label2057:
    label7829:
    label7857:
    for (;;)
    {
      break label1208;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(22, true, null);
      localFriendsManager.a(paramArrayOfByte, (byte[])localObject1);
      break;
      if (!paramArrayOfByte.msg_mod_friend_group.has()) {
        break;
      }
      paramArrayOfByte = ((SubMsgType0x27.ModFriendGroup)paramArrayOfByte.msg_mod_friend_group.get()).rpt_msg_frd_group.get();
      if (paramArrayOfByte == null) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte.iterator();
      do
      {
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject1 = (SubMsgType0x27.FriendGroup)paramArrayOfByte.next();
      } while ((!((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.has()) || (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get().size() <= 0));
      long l1 = ((SubMsgType0x27.FriendGroup)localObject1).uint64_fuin.get();
      int k = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_new_group_id.get(0)).intValue();
      if (((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get().size() > 0) {}
      for (i = ((Integer)((SubMsgType0x27.FriendGroup)localObject1).rpt_uint32_old_group_id.get(0)).intValue();; i = 0)
      {
        localFriendsManager.a(l1 + "", k);
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModFriendGroup  = id:" + l1 + " newgroupid:" + k);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(9, true, new Object[] { l1 + "", Byte.valueOf((byte)k), Byte.valueOf((byte)i) });
        break label1408;
        if (!paramArrayOfByte.msg_del_friend.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get();
        paramArrayOfByte = (QQStoryFeedManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(252);
        localObject1 = ((List)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2057;
          }
          l1 = ((Long)((Iterator)localObject1).next()).longValue();
          localFriendsManager.d(l1 + "");
          localPublicAccountDataManager.b(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          try
          {
            localObject2 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
            if ((localObject2 != null) && (((QidianManager)localObject2).a(l1 + "")))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(l1), true);
              localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getBaseContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
              ((SharedPreferences.Editor)localObject2).putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + l1 + "", false);
              ((SharedPreferences.Editor)localObject2).commit();
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1 + " error :" + localException.toString());
              }
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(15, true, Long.valueOf(l1));
          paramArrayOfByte.a(String.valueOf(l1));
        }
        paramArrayOfByte = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte.b();
        break;
        Object localObject6;
        Object localObject7;
        if (paramArrayOfByte.msg_mod_friend_rings.has())
        {
          localObject1 = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject1).next();
            localObject4 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              localObject6 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject4).next();
              i = ((SubMsgType0x27.SnsUpdateItem)localObject6).uint32_update_sns_type.get();
              if ((i == 13569) && (((SubMsgType0x27.SnsUpateBuffer)localObject3).uint32_result.get() == 0))
              {
                localObject5 = localTroopManager.b(Long.valueOf(((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_uin.get()).toString());
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                if (i == 0)
                {
                  if (localTroopManager.c((String)localObject5)) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22).a(18, true, new Object[] { localObject5, Integer.valueOf(1), Integer.valueOf(0), null });
                  }
                }
                else if (i >= 4)
                {
                  localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                  localObject7 = new byte[i];
                  System.arraycopy(localObject6, 0, localObject7, 0, 4);
                  if (localTroopManager.a((String)localObject5, MessageHandlerUtils.a((byte[])localObject7))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22).a(18, true, new Object[] { localObject5, Integer.valueOf(0), Integer.valueOf(0), null });
                  }
                }
              }
              else if (i == 13571)
              {
                l1 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_uin.get();
                l2 = ((SubMsgType0x27.SnsUpateBuffer)localObject3).uint64_code.get();
                Long.valueOf(l1).toString();
                localObject5 = String.valueOf(Long.valueOf(l2));
                i = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().size();
                localObject6 = ((SubMsgType0x27.SnsUpdateItem)localObject6).bytes_value.get().toByteArray();
                if (i >= 6)
                {
                  if ((localObject6[0] != 1) || (localObject6[0] == 0)) {}
                  i = localObject6[1];
                  if (i == 1)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("Q.msg.BaseMessageProcessor", 2, "onlinePush, oprerate external show troop...");
                    }
                    localObject7 = new byte[4];
                    System.arraycopy(localObject6, 2, localObject7, 0, 4);
                    if (localTroopManager.b((String)localObject5, MessageHandlerUtils.a((byte[])localObject7))) {
                      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                    }
                  }
                  if ((i == 0) && (localTroopManager.e((String)localObject5))) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(54, true, new Object[] { localObject5, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i) });
                  }
                }
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_friend_rings.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get();
        if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_general_infos.has())) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_sns_general_infos.get();
        Object localObject3 = new HashMap();
        localObject4 = paramArrayOfByte.iterator();
        while (((Iterator)localObject4).hasNext())
        {
          paramArrayOfByte = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject4).next();
          if ((paramArrayOfByte != null) && (paramArrayOfByte.uint64_uin.has()) && (paramArrayOfByte.rpt_msg_sns_update_item.has()))
          {
            l1 = paramArrayOfByte.uint64_uin.get();
            localObject5 = String.valueOf(l1);
            localObject6 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (SubMsgType0x27.SnsUpdateItem)((Iterator)localObject6).next();
              if ((localObject7 != null) && (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.has()) && (((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.has()))
              {
                if (((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get() == 13568) {
                  QvipSpecialCareManager.a((String)localObject5, ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                }
                localObject1 = (SpecialCareInfo)((HashMap)localObject3).get(localObject5);
                paramArrayOfByte = (byte[])localObject1;
                if (localObject1 == null)
                {
                  localObject1 = localFriendsManager.a(String.valueOf(l1));
                  paramArrayOfByte = (byte[])localObject1;
                  if (localObject1 == null)
                  {
                    paramArrayOfByte = new SpecialCareInfo();
                    paramArrayOfByte.uin = String.valueOf(String.valueOf(l1));
                  }
                  ((HashMap)localObject3).put(paramArrayOfByte.uin, paramArrayOfByte);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
                localObject1 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8();
                FriendListHandler.a(paramArrayOfByte, i, (String)localObject1);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramArrayOfByte.uin + ", itemtype=" + i + ",itemVal=" + (String)localObject1);
                }
              }
            }
          }
        }
        paramArrayOfByte = ((HashMap)localObject3).entrySet().iterator();
        localObject1 = new ArrayList();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (SpecialCareInfo)((Map.Entry)paramArrayOfByte.next()).getValue();
          if ((localObject3 != null) && ((((SpecialCareInfo)localObject3).getStatus() != 1000) || (((SpecialCareInfo)localObject3).globalSwitch != 0))) {
            ((List)localObject1).add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + ((List)localObject1).size());
        }
        localFriendsManager.c((List)localObject1);
        if (((List)localObject1).size() <= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(99, true, new Object[] { Boolean.valueOf(true), localObject1 });
        break;
        if (!paramArrayOfByte.msg_mod_friend_flag.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.SnsUpdateFlag)paramArrayOfByte.msg_mod_friend_flag.get();
        if (!paramArrayOfByte.rpt_msg_update_sns_flag.has()) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_update_sns_flag.get().iterator();
        do
        {
          do
          {
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localObject1 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64__uin.get();
            i = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject1).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + i + " id:" + l2);
            }
          } while (l2 != 4051L);
          localObject1 = localFriendsManager.c(String.valueOf(l1));
        } while (localObject1 == null);
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((Friends)localObject1).setShieldFlag(bool);
          localFriendsManager.a((Friends)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(56, true, new Object[] { Long.valueOf(l1), Boolean.valueOf(bool), Boolean.valueOf(true), Boolean.valueOf(true), "" });
          break;
        }
        if (!paramArrayOfByte.msg_mod_profile.has()) {
          break;
        }
        j = a(paramArrayOfByte, localFriendsManager, localTroopManager, localPstnManager, localApolloManager, arrayOfFriends, j);
        break;
        if (!paramArrayOfByte.msg_mod_custom_face.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((!((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.has()) || (!((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.has())) {
          break;
        }
        paramArrayOfByte = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() == 0)
        {
          l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_uin.get();
          localObject1 = Long.toString(l1);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          paramArrayOfByte.c((String)localObject1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, localObject1);
          break;
        }
        if (((SubMsgType0x27.ModCustomFace)localObject1).uint32_type.get() != 1) {
          break;
        }
        l1 = ((SubMsgType0x27.ModCustomFace)localObject1).uint64_group_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
        }
        localObject1 = localTroopManager.a(String.valueOf(l1));
        ((TroopInfo)localObject1).hasSetNewTroopHead = true;
        localTroopManager.b((TroopInfo)localObject1);
        paramArrayOfByte.d(Long.toString(l1));
        break;
        if (!paramArrayOfByte.msg_daren_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.DaRenNotify)paramArrayOfByte.msg_daren_notify.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        i = paramArrayOfByte.uint32_login_days.get();
        k = paramArrayOfByte.uint32_days.get();
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l1)))
        {
          paramArrayOfByte = localFriendsManager.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if ((i != paramArrayOfByte.lLoginDays) || (k != paramArrayOfByte.lQQMasterLogindays))
          {
            paramArrayOfByte.lLoginDays = i;
            paramArrayOfByte.lQQMasterLogindays = k;
            localFriendsManager.a(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2).a(1, true, paramArrayOfByte);
          }
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "daren notify received local data logindays=" + paramArrayOfByte.lLoginDays + ";days=" + paramArrayOfByte.lQQMasterLogindays);
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cardpush", 2, "daren notify received uin=" + l1 + ";logindays=" + i + ";days=" + k);
        break;
        if (!paramArrayOfByte.msg_mod_friend_remark.has()) {
          break;
        }
        localObject1 = ((SubMsgType0x27.ModFriendRemark)paramArrayOfByte.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SubMsgType0x27.FriendRemark)((Iterator)localObject1).next();
          if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.has()) {
            if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.get() == 0)
            {
              l1 = ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get();
              localObject4 = localFriendsManager.c(Long.toString(l1));
              paramArrayOfByte = null;
              if (localObject4 != null) {
                paramArrayOfByte = ((Friends)localObject4).remark;
              }
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 0 Friend uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "备注 = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + ",oldRemark = " + paramArrayOfByte);
              }
              localFriendsManager.b(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8());
              localObject5 = localFriendsManager.a(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "");
              localObject6 = ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8();
              if ((localObject5 != null) && (!((String)localObject6).equals(((Card)localObject5).strReMark)))
              {
                ((Card)localObject5).strReMark = ((String)localObject6);
                localFriendsManager.a((Card)localObject5);
              }
              if ((localObject4 != null) && (((Friends)localObject4).isFriend()) && (QQProfileItem.b((String)localObject6, paramArrayOfByte))) {
                QQProfileItem.b(l1, (String)localObject6, (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52));
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, Long.toString(((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get()));
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(27, true, new Object[] { ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + "", ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8(), Byte.valueOf(1) });
              TroopNameHelper.b(Long.toString(l1));
            }
            else if (((SubMsgType0x27.FriendRemark)localObject3).uint32_type.get() == 1)
            {
              if (((SubMsgType0x27.FriendRemark)localObject3).uint64_group_code.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remarkuin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + " troopcode = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_group_code.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
                }
              }
              else if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModFriendRemark  : 1 troop remark uin = " + ((SubMsgType0x27.FriendRemark)localObject3).uint64_fuin.get() + " remark = " + ((SubMsgType0x27.FriendRemark)localObject3).bytes_rmk_name.get().toStringUtf8() + "目前群备注在android上没看到有地方显示？");
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_rich_long_nick_ex.has()) {
          break;
        }
        Object localObject5 = (SubMsgType0x27.ModLongNick)paramArrayOfByte.msg_mod_rich_long_nick_ex.get();
        localObject3 = Long.toString(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get());
        paramArrayOfByte = ByteBuffer.wrap(((SubMsgType0x27.ModLongNick)localObject5).bytes_value.get().toByteArray());
        l1 = paramArrayOfByte.getLong();
        localObject4 = new byte[paramArrayOfByte.remaining()];
        paramArrayOfByte.get((byte[])localObject4);
        localObject1 = localFriendsManager.a((String)localObject3);
        paramArrayOfByte = (byte[])localObject1;
        if (localObject1 == null)
        {
          paramArrayOfByte = new ExtensionInfo();
          paramArrayOfByte.uin = ((String)localObject3);
        }
        paramArrayOfByte.setRichBuffer((byte[])localObject4, l1);
        paramArrayOfByte.isAdded2C2C = SignatureManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (String)localObject3, paramArrayOfByte.getRichStatus());
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "insertSignMsgIfNeeded from OnLinePush uin = " + (String)localObject3 + " result =  " + paramArrayOfByte.isAdded2C2C);
        }
        localFriendsManager.a(paramArrayOfByte);
        paramArrayOfByte = localFriendsManager.a(((SubMsgType0x27.ModLongNick)localObject5).uint64_uin.get() + "");
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.vRichSign = ((byte[])localObject4);
          paramArrayOfByte.lSignModifyTime = l1;
          localFriendsManager.a(paramArrayOfByte);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, localObject3);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(2, true, new String[] { localObject3 });
        break;
        if (!paramArrayOfByte.msg_mod_group_profile.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.ModGroupProfile)paramArrayOfByte.msg_mod_group_profile.get();
        l1 = paramArrayOfByte.uint64_cmd_uin.get();
        if (!paramArrayOfByte.uint64_group_code.has()) {
          break;
        }
        long l2 = paramArrayOfByte.uint64_group_uin.get();
        long l3 = paramArrayOfByte.uint64_group_code.get();
        for (;;)
        {
          try
          {
            paramArrayOfByte = paramArrayOfByte.rpt_msg_group_profile_infos.get().iterator();
            if (!paramArrayOfByte.hasNext()) {
              break;
            }
            localObject4 = (SubMsgType0x27.GroupProfileInfo)paramArrayOfByte.next();
            if ((!((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.has()) || (!((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.has())) {
              continue;
            }
            if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() != 1) {
              break label5211;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8());
            }
            localObject1 = String.valueOf(l3);
            localObject3 = localTroopManager.a((String)localObject1);
            if (localObject3 == null) {
              continue;
            }
            localObject4 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8();
            if (!TextUtils.equals((CharSequence)localObject4, ((TroopInfo)localObject3).troopname))
            {
              i = 1;
              ((TroopInfo)localObject3).troopname = ((String)localObject4);
              ((TroopInfo)localObject3).hasSetNewTroopName = true;
              localTroopManager.b((TroopInfo)localObject3);
              localObject5 = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20);
              ((TroopHandler)localObject5).a(2, false, null);
              ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(44, true, new Object[] { localObject1, localObject4, null });
              if (i == 0) {
                continue;
              }
              ((TroopHandler)localObject5).b((String)localObject1, String.valueOf(l1), ((TroopInfo)localObject3).troopname);
              continue;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          i = 0;
          continue;
          label5211:
          if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 2)
          {
            localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get();
            if ((localObject1 != null) && (((ByteStringMicro)localObject1).size() == 2))
            {
              i = ((ByteStringMicro)localObject1).byteAt(0);
              short s = (short)(((ByteStringMicro)localObject1).byteAt(1) | i << 8);
              localObject1 = localTroopManager.a(l2 + "");
              ((TroopInfo)localObject1).troopface = s;
              ((TroopInfo)localObject1).hasSetNewTroopHead = true;
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
              }
              localTroopManager.b((TroopInfo)localObject1);
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(l2 + "");
            }
          }
          else if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 3)
          {
            localObject1 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange:" + l2 + "," + l3 + "," + (String)localObject1);
            }
            localObject3 = localTroopManager.a(l3 + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).troopCreditLevel = Long.valueOf((String)localObject1).longValue();
              localTroopManager.b((TroopInfo)localObject3);
              if (QLog.isColorLevel()) {
                QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange, save");
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_mod_group_member_profile.has()) {
          break;
        }
        localObject1 = (SubMsgType0x27.ModGroupMemberProfile)paramArrayOfByte.msg_mod_group_member_profile.get();
        if ((!((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.has()) || (!((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.has())) {
          break;
        }
        l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_uin.get();
        l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_group_code.get();
        l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).uint64_uin.get();
        paramArrayOfByte = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2 + "", l3 + "");
        localObject1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject1).rpt_msg_group_member_profile_infos.get().iterator();
        label6499:
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject1).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() != 1) {
              break label5996;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupMemberProfile 1--Nick = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8() + " info.bytes_value.get().size() = " + ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            }
            QQProfileItem.a("cardpush", ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toByteArray(), ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size());
            localTroopManager.a(l1 + "", l3 + "", ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8(), -100, null, null, -100, -100, -100, -100L, -100L);
            if (paramArrayOfByte != null) {
              paramArrayOfByte.name = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
            }
          }
          for (;;)
          {
            if (paramArrayOfByte == null) {
              break label6499;
            }
            DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(16, true, localObject3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(11, true, new Object[] { localObject3, Boolean.valueOf(true) });
            break;
            label5996:
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 2)
            {
              if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().size() == 1)
              {
                byte b = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().byteAt(0);
                if (QLog.isColorLevel()) {
                  QLog.d("cardpush", 2, "push a ModGroupMemberProfile 2--sex = " + b);
                }
                localTroopManager.a(l1 + "", l3 + "", null, -100, null, null, -100, b, -100, -100L, -100L);
                if (paramArrayOfByte != null) {
                  paramArrayOfByte.sex = b;
                }
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 3)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 3--phone = " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.tel = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 4)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 4--email= " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.email = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 5)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 5--remark= " + (String)localObject3);
              }
              ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(l1 + "", l3 + "", null, -100, null, (String)localObject3, -100, -100, -100, -100L, -100L);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.memo = ((String)localObject3);
              }
            }
            else if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() == 6)
            {
              localObject3 = ((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.get().toStringUtf8();
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupMemberProfile 6--job= " + (String)localObject3);
              }
              if (paramArrayOfByte != null) {
                paramArrayOfByte.job = ((String)localObject3);
              }
            }
          }
        }
        if (!paramArrayOfByte.msg_appointment_notify.has()) {
          break;
        }
        localObject5 = (SubMsgType0x27.AppointmentNotify)paramArrayOfByte.msg_appointment_notify.get();
        if (!((SubMsgType0x27.AppointmentNotify)localObject5).uint32_notifytype.has()) {
          break;
        }
        l1 = ((SubMsgType0x27.AppointmentNotify)localObject5).uint32_notifytype.get();
        if ((l1 == 2L) || (l1 == 4L) || (l1 == 5L) || ((l1 == 6L) && (((SubMsgType0x27.AppointmentNotify)localObject5).bytes_feed_event_info.has())))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((SubMsgType0x27.AppointmentNotify)localObject5);
          break;
        }
        if (((l1 != 0L) && (l1 != 1L) && (l1 != 3L)) || (!((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.has())) {
          break;
        }
        l2 = ((SubMsgType0x27.AppointmentNotify)localObject5).uint64_from_uin.get();
        localObject1 = null;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject4 = Long.toString(l2);
        if (l1 == 0L) {}
        for (paramArrayOfByte = (byte[])localObject3;; paramArrayOfByte = (byte[])localObject4)
        {
          if (((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.has()) {
            localObject1 = ((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.get();
          }
          localObject5 = new ArrayList();
          localObject6 = MessageRecordFactory.a(-1024);
          l2 = MessageCache.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + (String)localObject4 + ",senderUin=" + paramArrayOfByte + ",notifytype=" + l1);
          }
          ((MessageRecord)localObject6).init((String)localObject3, (String)localObject4, paramArrayOfByte, (String)localObject1, l2, -1024, 1010, l2);
          ((MessageRecord)localObject6).isread = false;
          if (l1 == 0L)
          {
            ((MessageRecord)localObject6).issend = 1;
            ((MessageRecord)localObject6).isread = true;
          }
          ((ArrayList)localObject5).add(localObject6);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((MessageRecord)localObject6, ((MessageRecord)localObject6).selfuin);
          a("handleMsgType0x210SubMsgType0x27", true, (List)localObject5, false, false);
          break;
          if ((l1 == 1L) && (((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.has()))
          {
            paramArrayOfByte = ((SubMsgType0x27.AppointmentNotify)localObject5).bytes_sig.get().toByteArray();
            if (paramArrayOfByte != null) {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().m((String)localObject4, paramArrayOfByte);
            }
          }
        }
        if (!paramArrayOfByte.bytes_redpoint_info.has()) {
          break;
        }
        ((LocalRedTouchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159)).a(paramArrayOfByte.bytes_redpoint_info.get().toByteArray());
        break;
        if (!paramArrayOfByte.msg_push_search_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushSearchDev)paramArrayOfByte.msg_push_search_dev.get();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("optype", 200);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject1).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.uint32_dev_time.has()) {
          ((Bundle)localObject1).putInt("devtime", paramArrayOfByte.uint32_dev_time.get());
        }
        if (paramArrayOfByte.uint64_din.has()) {
          ((Bundle)localObject1).putLong("din", paramArrayOfByte.uint64_din.get());
        }
        if (paramArrayOfByte.str_data.has()) {
          ((Bundle)localObject1).putString("data", paramArrayOfByte.str_data.get());
        }
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject1);
        break;
        if (!paramArrayOfByte.msg_push_report_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushReportDev)paramArrayOfByte.msg_push_report_dev.get();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("optype", 201);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject1).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.bytes_cookie.has()) {
          ((Bundle)localObject1).putString("cookie", paramArrayOfByte.bytes_cookie.get().toStringUtf8());
        }
        if (paramArrayOfByte.uint32_report_max_num.has()) {
          ((Bundle)localObject1).putInt("count", paramArrayOfByte.uint32_report_max_num.get());
        }
        if (paramArrayOfByte.bytes_sn.has()) {
          ((Bundle)localObject1).putString("sn", paramArrayOfByte.bytes_sn.get().toStringUtf8());
        }
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject1);
        break;
        if (!paramArrayOfByte.msg_qq_pay_push.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.QQPayPush)paramArrayOfByte.msg_qq_pay_push.get();
        l1 = paramArrayOfByte.uint64_uin.get();
        bool = paramArrayOfByte.bool_pay_ok.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, " === qq pay push uin: " + l1 + ", isPaySuccess | " + bool);
        }
        ((PstnHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(82)).a(l1, bool);
        break;
        if (!paramArrayOfByte.msg_new_comein_user_notify.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.NewComeinUserNotify)paramArrayOfByte.msg_new_comein_user_notify.get();
        if (paramArrayOfByte.uint32_msg_type.has()) {}
        for (i = paramArrayOfByte.uint32_msg_type.get();; i = -1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "receive msg0x210submsg0x27 face2face add friend push, type:" + i);
          }
          if (i == 1)
          {
            localObject1 = (LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
            if (localObject1 == null) {
              break;
            }
            ((LBSHandler)localObject1).a(paramArrayOfByte);
            break;
          }
          if ((i != 2) && (i != 3)) {
            break;
          }
          localObject1 = (NearFieldTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(57);
          if (localObject1 == null) {
            break;
          }
          ((NearFieldTroopHandler)localObject1).a(i, paramArrayOfByte);
          break;
          paramArrayOfByte = (SubMsgType0x27.PraiseRankNotify)paramArrayOfByte.msg_praise_rank_notify.get();
          if (paramArrayOfByte.str_msg.has()) {}
          for (paramArrayOfByte = paramArrayOfByte.str_msg.get();; paramArrayOfByte = null)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "praise rank notify: " + paramArrayOfByte);
              }
              if (TextUtils.isEmpty(paramArrayOfByte)) {
                break;
              }
              localObject1 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130839193);
              localObject3 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
              localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), LikeRankingListActivity.class);
              ((Intent)localObject4).putExtra("param_from", 1);
              ((Intent)localObject4).addFlags(67108864);
              ((ToServiceMsg)localObject3).extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramArrayOfByte });
              ((ToServiceMsg)localObject3).extraData.putParcelable("intent", (Parcelable)localObject4);
              ((ToServiceMsg)localObject3).extraData.putParcelable("bitmap", (Parcelable)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendToService((ToServiceMsg)localObject3);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.reportClickEvent("dc00898", "0X8007618");
              break;
              try
              {
                paramArrayOfByte = (SubMsgType0x27.MQQCampusNotify)paramArrayOfByte.msg_campus_notify.get();
                if (paramArrayOfByte == null) {
                  break;
                }
                ((CampusNoticeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(239)).a(paramArrayOfByte);
              }
              catch (Exception paramArrayOfByte) {}
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("Q.msg.BaseMessageProcessor", 2, "deal SubMsgType0x27.MQQCampusNotify fail", paramArrayOfByte);
            break;
            localFriendsManager.a(arrayOfFriends, j);
            return;
          }
        }
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt, MsgInfo paramMsgInfo)
  {
    ((ImaxAdVideoPreloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(267)).a(paramArrayOfByte, paramInt, paramMsgInfo);
  }
  
  public void a(byte[] paramArrayOfByte, long paramLong)
  {
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161);
    localKandianMergeManager.a(paramArrayOfByte, paramLong);
    if ((KandianMergeManager.a(paramArrayOfByte)) && (localKandianMergeManager.d())) {
      a("handleGetKandian210Message", true, 1, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(true, false), false);
    }
  }
  
  public void a(byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    boolean bool2 = true;
    Object localObject = new SubMsgType0xcb.MsgBody();
    label422:
    String str;
    try
    {
      ((SubMsgType0xcb.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (MessageForNearbyLiveTip)MessageRecordFactory.a(-2053);
      if (((SubMsgType0xcb.MsgBody)localObject).uint32_anchor_status.get() == 1)
      {
        bool1 = true;
        paramArrayOfByte.isLiving = bool1;
        paramArrayOfByte.jumpingUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_jump_schema.get().toStringUtf8();
        paramArrayOfByte.msg = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_wording.get().toStringUtf8();
        paramArrayOfByte.headUrl = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_head_url.get().toStringUtf8();
        paramArrayOfByte.nickName = ((SubMsgType0xcb.MsgBody)localObject).bytes_anchor_nickname.get().toStringUtf8();
        paramArrayOfByte.liveEndWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_live_end_wording.get().toStringUtf8();
        paramArrayOfByte.c2cMsgWording = ((SubMsgType0xcb.MsgBody)localObject).bytes_c2c_msg_wording.get().toStringUtf8();
        paramArrayOfByte.time = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.msgseq = paramMsgInfo.uRealMsgTime;
        paramArrayOfByte.shmsgseq = paramMsgInfo.shMsgSeq;
        paramArrayOfByte.msgUid = paramMsgInfo.lMsgUid;
        paramArrayOfByte.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramArrayOfByte.istroop = 1001;
        paramArrayOfByte.senderuin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.l);
        paramArrayOfByte.frienduin = String.valueOf(paramMsgInfo.lFromUin + AppConstants.l);
        paramArrayOfByte.getBytes();
        if (QLog.isColorLevel())
        {
          paramMsgInfo = new StringBuilder();
          paramMsgInfo.append("status=").append(paramArrayOfByte.isLiving).append("jumpingUrl=").append(paramArrayOfByte.jumpingUrl).append("liveWording=").append(paramArrayOfByte.msg).append("headUrl").append(paramArrayOfByte.headUrl).append("nickName").append(paramArrayOfByte.nickName);
          QLog.i("Q.msg.BaseMessageProcessor", 2, paramMsgInfo.toString());
        }
        if ((!MessageForNearbyLiveTip.isHuayangTip(paramArrayOfByte.jumpingUrl)) || (MessageForNearbyLiveTip.isSupportHuayangBusinessType(paramArrayOfByte.jumpingUrl))) {
          break label422;
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg discard a not support huayang tips message, jumpUrl=" + paramArrayOfByte.jumpingUrl);
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      do
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.i("Q.msg.BaseMessageProcessor", 2, "decodeNearbyLiveTipMsg decode failed" + paramArrayOfByte.toString());
            continue;
            bool1 = false;
          }
        }
        paramMsgInfo = new ArrayList();
      } while (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte, true));
      paramMsgInfo.add(paramArrayOfByte);
      if (paramArrayOfByte.isLiving)
      {
        bool2 = MessageHandlerUtils.a(paramMsgInfo);
        boolean bool3 = MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMsgInfo);
        int i = MsgProxyUtils.a(paramMsgInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if ((bool2) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) {}
        for (bool1 = true;; bool1 = false)
        {
          ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
          a("handleGetBuddyMessageResp", true, i, this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(bool2, bool3), false);
          return;
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop);
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte.frienduin, paramArrayOfByte.istroop, ((MessageRecord)localObject).uniseq, paramArrayOfByte.msgData);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localObject);
        return;
      }
      bool1 = MessageHandlerUtils.a(paramMsgInfo);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!bool1) {
        break label703;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop) {}
    label703:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QQMessageFacade)localObject).a(paramMsgInfo, str, bool1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((int)paramArrayOfByte.time);
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, HotReactivePushMsg paramHotReactivePushMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7");
    }
    if (paramArrayOfByte == null) {
      return;
    }
    Object localObject = new submsgtype0xc7.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (submsgtype0xc7.MsgBody)((submsgtype0xc7.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte == null) {
          break;
        }
        paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get().iterator();
        if (!paramArrayOfByte.hasNext()) {
          break;
        }
        localObject = (submsgtype0xc7.ForwardBody)paramArrayOfByte.next();
        if ((!((submsgtype0xc7.ForwardBody)localObject).uint32_notify_type.has()) || (((submsgtype0xc7.ForwardBody)localObject).uint32_notify_type.get() != 1)) {
          break label133;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 push a no content");
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramArrayOfByte) {}
      QLog.e("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7", paramArrayOfByte);
      return;
      label133:
      if (((submsgtype0xc7.ForwardBody)localObject).uint32_op_type.has()) {
        switch (((submsgtype0xc7.ForwardBody)localObject).uint32_op_type.get())
        {
        default: 
          break;
        case 3000: 
          if (((submsgtype0xc7.ForwardBody)localObject).msg_hot_friend_notify.has()) {
            a((submsgtype0xc7.HotFriendNotify)((submsgtype0xc7.ForwardBody)localObject).msg_hot_friend_notify.get(), paramHotReactivePushMsg);
          }
          break;
        }
      }
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Pause) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop)) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a == 0);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
    }
    submsgtype0x26.MsgBody localMsgBody = new submsgtype0x26.MsgBody();
    do
    {
      do
      {
        do
        {
          do
          {
            try
            {
              localMsgBody.mergeFrom(paramArrayOfByte);
              if (!localMsgBody.uint32_sub_cmd.has())
              {
                if (QLog.isColorLevel()) {
                  QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
                }
                return;
              }
            }
            catch (Exception paramArrayOfByte)
            {
              while (!QLog.isColorLevel()) {}
              QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
              return;
            }
            if ((localMsgBody.uint32_sub_cmd.get() == 1) || (localMsgBody.uint32_sub_cmd.get() == 4))
            {
              ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(paramArrayOfByte);
              return;
            }
          } while (localMsgBody.uint32_sub_cmd.get() != 3);
          if ((!localMsgBody.msg_subcmd_0x3_push_body.has()) && (QLog.isColorLevel())) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
          }
          paramArrayOfByte = (submsgtype0x26.MsgBody.SubCmd0x3UpdateDiscussAppInfo)localMsgBody.msg_subcmd_0x3_push_body.get();
        } while ((!paramArrayOfByte.uint64_conf_uin.has()) || (!paramArrayOfByte.msg_app_tip_notify.has()));
        paramArrayOfByte.uint64_conf_uin.get();
        paramArrayOfByte = (submsgtype0x26.AppTipNotify)paramArrayOfByte.msg_app_tip_notify.get();
      } while (!paramArrayOfByte.bytes_text.has());
      paramArrayOfByte = paramArrayOfByte.bytes_text.get().toByteArray();
    } while (paramArrayOfByte.length <= 0);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramArrayOfByte);
  }
  
  public void b(byte[] paramArrayOfByte, long paramLong)
  {
    ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).b(paramArrayOfByte, paramLong);
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe");
    }
    Object localObject = new SubMsgType0xbe.MsgBody();
    try
    {
      ((SubMsgType0xbe.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      if (!((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : msg has not uint64_group_code");
        }
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0xbe : fail to parse submsgtype0xbe.");
      return;
    }
    try
    {
      paramArrayOfByte = new JSONObject();
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_uin.has()) {
        paramArrayOfByte.put("uin", ((SubMsgType0xbe.MsgBody)localObject).uint64_uin.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.has()) {
        paramArrayOfByte.put("groupCode", ((SubMsgType0xbe.MsgBody)localObject).uint64_group_code.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.has()) {
        paramArrayOfByte.put("notifyType", ((SubMsgType0xbe.MsgBody)localObject).uint32_notify_type.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.has()) {
        paramArrayOfByte.put("onlineLevel", ((SubMsgType0xbe.MsgBody)localObject).uint32_online_level.get());
      }
      if (((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.has())
      {
        JSONArray localJSONArray = new JSONArray();
        localObject = ((SubMsgType0xbe.MsgBody)localObject).rpt_msg_medal_list.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          SubMsgType0xbe.Medal localMedal = (SubMsgType0xbe.Medal)((Iterator)localObject).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("id", localMedal.uint32_id.get());
          localJSONObject.put("level", localMedal.uint32_level.get());
          localJSONObject.put("type", localMedal.uint32_type.get());
          localJSONObject.put("iconUrl", localMedal.str_icon_url.get());
          localJSONObject.put("flashUrl", localMedal.str_flash_url.get());
          localJSONObject.put("name", localMedal.str_name.get());
          localJSONArray.put(localJSONObject);
        }
        paramArrayOfByte.put("medalList", localJSONArray);
      }
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte.toString());
  }
  
  public void d(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83");
    }
    Object localObject1 = new SubMsgType0x83.MsgBody();
    do
    {
      try
      {
        ((SubMsgType0x83.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has())
        {
          if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : msg has not uint64_group_id");
          }
          return;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x83 : fail to parse submsgtype0x83.");
        return;
      }
    } while (!((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params.has());
    paramArrayOfByte = ((SubMsgType0x83.MsgBody)localObject1).rpt_msg_params;
    long l1 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_seq.has()) {
      l1 = ((SubMsgType0x83.MsgBody)localObject1).uint64_seq.get();
    }
    long l2 = -1L;
    if (((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.has()) {
      l2 = ((SubMsgType0x83.MsgBody)localObject1).uint64_group_id.get();
    }
    int i = 0;
    label149:
    if (i < paramArrayOfByte.size())
    {
      localObject1 = (SubMsgType0x83.MsgParams)paramArrayOfByte.get(i);
      if ((localObject1 != null) && (((SubMsgType0x83.MsgParams)localObject1).uint32_type.has())) {
        break label190;
      }
    }
    label190:
    int j;
    label443:
    do
    {
      for (;;)
      {
        i += 1;
        break label149;
        break;
        j = ((SubMsgType0x83.MsgParams)localObject1).uint32_type.get();
        Object localObject3;
        int k;
        if ((j >= 2001) && (j <= 3000))
        {
          if ((((SubMsgType0x83.MsgParams)localObject1).str_data.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.has()) && (((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.has()))
          {
            localObject3 = ((SubMsgType0x83.MsgParams)localObject1).str_data.get();
            try
            {
              k = new JSONObject((String)localObject3).getInt("count");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(j, ((SubMsgType0x83.MsgParams)localObject1).uint64_from_uin.get(), ((SubMsgType0x83.MsgParams)localObject1).uint64_to_uin.get(), k, l1, l2);
            }
            catch (Exception localException1) {}
          }
        }
        else
        {
          if (j != 1005) {
            break label443;
          }
          if ((localException1.str_data.has()) && (localException1.uint64_from_uin.has()) && (localException1.uint64_to_uin.has()))
          {
            localObject3 = localException1.str_data.get();
            try
            {
              localObject3 = new JSONObject((String)localObject3);
              j = ((JSONObject)localObject3).optInt("enable");
              k = ((JSONObject)localObject3).optInt("level");
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localException1.uint32_type.get(), localException1.uint64_from_uin.get(), localException1.uint64_to_uin.get(), j, k, l1, l2);
            }
            catch (Exception localException2) {}
          }
        }
      }
    } while ((j != 1010) || (!localException2.bytes_data.has()));
    Object localObject2 = new String(localException2.bytes_data.get().toByteArray());
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject((String)localObject2);
        if (((JSONObject)localObject2).getInt("sndRank") == 0) {
          break label544;
        }
        j = 1;
        boolean bool = ((JSONObject)localObject2).getBoolean("rank_changed");
        if ((j == 0) || (!bool)) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(l2);
      }
      catch (Exception localException3) {}
      break;
      label544:
      j = 0;
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().j(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.OnLinePushMessageProcessor
 * JD-Core Version:    0.7.0.1
 */