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
import zql;
import zqm;

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
          paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437302);
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
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437312);
          } else {
            paramArrayOfByte = (String)localObject + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437303);
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
    //   221: ifnull +14937 -> 15158
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
    //   2979: new 1872	zqj
    //   2982: dup
    //   2983: aload_0
    //   2984: aload 32
    //   2986: invokespecial 1875	zqj:<init>	(Lcom/tencent/mobileqq/app/message/OnLinePushMessageProcessor;LIMMsgBodyPack/MsgType0x210;)V
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
    //   3383: ifeq +12015 -> 15398
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
    //   3421: ifeq +11971 -> 15392
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
    //   3459: ifeq +11927 -> 15386
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
    //   4297: ifeq +11083 -> 15380
    //   4300: aload 30
    //   4302: getfield 2039	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_identify	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4305: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4308: istore 5
    //   4310: aload 30
    //   4312: getfield 2042	tencent/im/s2c/msgtype0x210/submsgtype0x6f/SubMsgType0x6f$VipInfoNotify:uint32_vip_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4315: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4318: ifeq +11056 -> 15374
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
    //   4402: ifeq +11002 -> 15404
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
    //   4444: goto +10960 -> 15404
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
    //   4484: ifeq +10933 -> 15417
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
    //   4521: goto +10896 -> 15417
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
    //   6070: ifne +321 -> 6391
    //   6073: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6076: ifeq +71 -> 6147
    //   6079: new 88	java/lang/StringBuilder
    //   6082: dup
    //   6083: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6086: getstatic 2400	cooperation/qzone/util/QZoneLogTags:LOG_TAG_UNDEALCOUNT	Ljava/lang/String;
    //   6089: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6092: getstatic 2403	cooperation/qzone/util/QZoneLogTags:LOG_TAG_ZEBRAALBUM	Ljava/lang/String;
    //   6095: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6098: ldc_w 468
    //   6101: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6104: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6107: iconst_4
    //   6108: new 88	java/lang/StringBuilder
    //   6111: dup
    //   6112: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6115: ldc_w 2405
    //   6118: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6121: aload_1
    //   6122: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6125: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6128: ldc_w 2407
    //   6131: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6134: aload_1
    //   6135: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6138: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6141: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6144: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6147: new 2409	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody
    //   6150: dup
    //   6151: invokespecial 2410	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:<init>	()V
    //   6154: astore_1
    //   6155: aload_1
    //   6156: aload 32
    //   6158: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6161: invokevirtual 2411	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6164: pop
    //   6165: aload_1
    //   6166: getfield 2414	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_src_app_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6169: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6172: pop
    //   6173: aload_1
    //   6174: getfield 2417	tencent/im/c2c/msgtype0x210/submsgtype0x79/submsgtype0x79$MsgBody:uint32_undeal_count	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6177: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6180: istore 4
    //   6182: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6185: ifeq +56 -> 6241
    //   6188: new 88	java/lang/StringBuilder
    //   6191: dup
    //   6192: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6195: getstatic 2400	cooperation/qzone/util/QZoneLogTags:LOG_TAG_UNDEALCOUNT	Ljava/lang/String;
    //   6198: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6201: getstatic 2403	cooperation/qzone/util/QZoneLogTags:LOG_TAG_ZEBRAALBUM	Ljava/lang/String;
    //   6204: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6207: ldc_w 468
    //   6210: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6213: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6216: iconst_2
    //   6217: new 88	java/lang/StringBuilder
    //   6220: dup
    //   6221: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6224: ldc_w 2419
    //   6227: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6230: iload 4
    //   6232: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6235: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6238: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6241: ldc_w 2421
    //   6244: iconst_m1
    //   6245: aload_0
    //   6246: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6249: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6252: invokestatic 2427	cooperation/qzone/LocalMultiProcConfig:getInt4Uin	(Ljava/lang/String;IJ)I
    //   6255: istore 5
    //   6257: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6260: ifeq +47 -> 6307
    //   6263: ldc_w 468
    //   6266: iconst_2
    //   6267: new 88	java/lang/StringBuilder
    //   6270: dup
    //   6271: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6274: ldc_w 2429
    //   6277: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6280: aload_0
    //   6281: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6284: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6287: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6290: ldc_w 2431
    //   6293: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6296: iload 5
    //   6298: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6301: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6304: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6307: iload 5
    //   6309: iconst_1
    //   6310: if_icmpne -6281 -> 29
    //   6313: aload_0
    //   6314: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6317: bipush 9
    //   6319: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6322: checkcast 2433	com/tencent/mobileqq/servlet/QZoneManagerImp
    //   6325: astore_1
    //   6326: new 655	java/util/ArrayList
    //   6329: dup
    //   6330: invokespecial 656	java/util/ArrayList:<init>	()V
    //   6333: astore 28
    //   6335: new 2435	cooperation/qzone/UndealCount/QZoneCountUserInfo
    //   6338: dup
    //   6339: invokespecial 2436	cooperation/qzone/UndealCount/QZoneCountUserInfo:<init>	()V
    //   6342: astore 29
    //   6344: aload 29
    //   6346: aload_0
    //   6347: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6350: invokevirtual 631	com/tencent/mobileqq/app/QQAppInterface:getLongAccountUin	()J
    //   6353: putfield 2437	cooperation/qzone/UndealCount/QZoneCountUserInfo:a	J
    //   6356: aload 28
    //   6358: aload 29
    //   6360: invokevirtual 659	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6363: pop
    //   6364: aload_1
    //   6365: bipush 17
    //   6367: iload 4
    //   6369: i2l
    //   6370: aload 28
    //   6372: ldc 140
    //   6374: iconst_0
    //   6375: iconst_1
    //   6376: ldc 140
    //   6378: invokevirtual 2440	com/tencent/mobileqq/servlet/QZoneManagerImp:a	(IJLjava/util/ArrayList;Ljava/lang/String;ZZLjava/lang/String;)Z
    //   6381: pop
    //   6382: aconst_null
    //   6383: areturn
    //   6384: astore_1
    //   6385: aload_1
    //   6386: invokevirtual 1813	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   6389: aconst_null
    //   6390: areturn
    //   6391: aload 32
    //   6393: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6396: ldc2_w 2441
    //   6399: lcmp
    //   6400: ifne +134 -> 6534
    //   6403: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6406: ifeq +46 -> 6452
    //   6409: ldc_w 468
    //   6412: iconst_4
    //   6413: new 88	java/lang/StringBuilder
    //   6416: dup
    //   6417: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6420: ldc_w 2444
    //   6423: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6426: aload_1
    //   6427: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6430: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6433: ldc_w 2407
    //   6436: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6439: aload_1
    //   6440: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6443: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6446: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6449: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6452: new 2446	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody
    //   6455: dup
    //   6456: invokespecial 2447	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:<init>	()V
    //   6459: astore_1
    //   6460: aload_1
    //   6461: aload 32
    //   6463: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6466: invokevirtual 2448	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6469: pop
    //   6470: aload_1
    //   6471: getfield 2449	tencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6474: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6477: lstore_2
    //   6478: aload_0
    //   6479: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6482: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6485: lload_2
    //   6486: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6489: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6492: ifeq -6463 -> 29
    //   6495: aload_0
    //   6496: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6499: bipush 93
    //   6501: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6504: checkcast 2451	com/tencent/mobileqq/secspy/SecSpyFileManager
    //   6507: aload_1
    //   6508: iconst_3
    //   6509: invokevirtual 2454	com/tencent/mobileqq/secspy/SecSpyFileManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x7c/submsgtype0x7c$MsgBody;I)V
    //   6512: aconst_null
    //   6513: areturn
    //   6514: astore_1
    //   6515: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6518: ifeq -6489 -> 29
    //   6521: ldc_w 468
    //   6524: iconst_2
    //   6525: ldc_w 2456
    //   6528: aload_1
    //   6529: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6532: aconst_null
    //   6533: areturn
    //   6534: aload 32
    //   6536: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6539: ldc2_w 2457
    //   6542: lcmp
    //   6543: ifne +143 -> 6686
    //   6546: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6549: ifeq +46 -> 6595
    //   6552: ldc_w 468
    //   6555: iconst_4
    //   6556: new 88	java/lang/StringBuilder
    //   6559: dup
    //   6560: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6563: ldc_w 2460
    //   6566: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6569: aload_1
    //   6570: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6573: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6576: ldc_w 2407
    //   6579: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6582: aload_1
    //   6583: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6586: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6589: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6592: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6595: new 2462	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody
    //   6598: dup
    //   6599: invokespecial 2463	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody:<init>	()V
    //   6602: astore_1
    //   6603: aload_1
    //   6604: aload 32
    //   6606: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6609: invokevirtual 2464	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6612: pop
    //   6613: aload_1
    //   6614: getfield 2465	tencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6617: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6620: lstore_2
    //   6621: aload_0
    //   6622: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6625: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   6628: lload_2
    //   6629: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6632: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6635: ifne +9 -> 6644
    //   6638: lload_2
    //   6639: lconst_0
    //   6640: lcmp
    //   6641: ifne -6612 -> 29
    //   6644: aload_0
    //   6645: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6648: sipush 152
    //   6651: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6654: checkcast 608	com/tencent/mobileqq/apollo/ApolloManager
    //   6657: aload_1
    //   6658: ldc_w 2467
    //   6661: invokevirtual 2470	com/tencent/mobileqq/apollo/ApolloManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xca/submsgtype0xca$MsgBody;Ljava/lang/String;)V
    //   6664: aconst_null
    //   6665: areturn
    //   6666: astore_1
    //   6667: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6670: ifeq -6641 -> 29
    //   6673: ldc_w 468
    //   6676: iconst_2
    //   6677: ldc_w 2456
    //   6680: aload_1
    //   6681: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6684: aconst_null
    //   6685: areturn
    //   6686: aload 32
    //   6688: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6691: ldc2_w 2471
    //   6694: lcmp
    //   6695: ifne +166 -> 6861
    //   6698: invokestatic 2395	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   6701: ifeq +46 -> 6747
    //   6704: ldc_w 468
    //   6707: iconst_4
    //   6708: new 88	java/lang/StringBuilder
    //   6711: dup
    //   6712: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6715: ldc_w 2474
    //   6718: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6721: aload_1
    //   6722: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   6725: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6728: ldc_w 2407
    //   6731: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6734: aload_1
    //   6735: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   6738: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6741: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6744: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6747: new 2476	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody
    //   6750: dup
    //   6751: invokespecial 2477	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:<init>	()V
    //   6754: astore_1
    //   6755: aload_1
    //   6756: aload 32
    //   6758: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6761: invokevirtual 2478	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6764: pop
    //   6765: aload_1
    //   6766: ifnull -6737 -> 29
    //   6769: aload_1
    //   6770: getfield 2481	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:uint32_notify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   6773: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   6776: iconst_1
    //   6777: if_icmpne +78 -> 6855
    //   6780: iconst_1
    //   6781: istore 19
    //   6783: iload 19
    //   6785: iconst_1
    //   6786: if_icmpne -6757 -> 29
    //   6789: new 264	java/lang/String
    //   6792: dup
    //   6793: aload_1
    //   6794: getfield 2484	tencent/im/s2c/msgtype0x210/submsgtype0x86/SubMsgType0x86$MsgBody:bytes_notify_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6797: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6800: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   6803: ldc_w 1200
    //   6806: invokespecial 1203	java/lang/String:<init>	([BLjava/lang/String;)V
    //   6809: astore_1
    //   6810: aload_0
    //   6811: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6814: iload 19
    //   6816: aload_1
    //   6817: invokestatic 2489	com/tencent/mobileqq/qcall/QCallFacade:a	(Lcom/tencent/mobileqq/app/QQAppInterface;ZLjava/lang/String;)V
    //   6820: aload_0
    //   6821: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6824: invokevirtual 2492	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/av/gaudio/AVNotifyCenter;
    //   6827: iload 19
    //   6829: aload_1
    //   6830: invokevirtual 2497	com/tencent/av/gaudio/AVNotifyCenter:a	(ZLjava/lang/String;)V
    //   6833: aconst_null
    //   6834: areturn
    //   6835: astore_1
    //   6836: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6839: ifeq -6810 -> 29
    //   6842: ldc_w 468
    //   6845: iconst_2
    //   6846: ldc_w 2499
    //   6849: aload_1
    //   6850: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   6853: aconst_null
    //   6854: areturn
    //   6855: iconst_0
    //   6856: istore 19
    //   6858: goto -75 -> 6783
    //   6861: aload 32
    //   6863: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   6866: ldc2_w 2500
    //   6869: lcmp
    //   6870: ifne +449 -> 7319
    //   6873: new 2503	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody
    //   6876: dup
    //   6877: invokespecial 2504	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:<init>	()V
    //   6880: astore 28
    //   6882: sipush -2029
    //   6885: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   6888: checkcast 2506	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   6891: astore 29
    //   6893: aload 28
    //   6895: aload 32
    //   6897: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   6900: invokevirtual 2507	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6903: pop
    //   6904: aload 29
    //   6906: new 88	java/lang/StringBuilder
    //   6909: dup
    //   6910: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6913: aload 28
    //   6915: getfield 2510	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6918: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6921: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6924: ldc 140
    //   6926: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6929: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6932: putfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   6935: aload 29
    //   6937: new 88	java/lang/StringBuilder
    //   6940: dup
    //   6941: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   6944: aload 28
    //   6946: getfield 2516	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   6949: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   6952: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6955: ldc 140
    //   6957: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6960: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6963: putfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   6966: aload 29
    //   6968: aload 28
    //   6970: getfield 2522	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6973: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6976: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6979: putfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   6982: aload 29
    //   6984: aload 28
    //   6986: getfield 2528	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   6989: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   6992: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   6995: putfield 2531	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   6998: aload 29
    //   7000: aload 28
    //   7002: getfield 2534	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7005: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7008: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7011: putfield 2537	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   7014: aload 29
    //   7016: aload 28
    //   7018: getfield 2538	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7021: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7024: putfield 2541	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7027: aload 29
    //   7029: aload 28
    //   7031: getfield 2544	tencent/im/s2c/msgtype0x210/submsgtype0x85/SubMsgType0x85$MsgBody:uint32_sub_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7034: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7037: putfield 2545	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7040: aload_0
    //   7041: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7044: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7047: astore 30
    //   7049: aload_0
    //   7050: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7053: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7056: aload 29
    //   7058: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7061: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7064: ifeq +215 -> 7279
    //   7067: aload 29
    //   7069: getfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7072: astore 28
    //   7074: aload 29
    //   7076: aload 30
    //   7078: aload 28
    //   7080: ldc 140
    //   7082: ldc_w 2547
    //   7085: aload_1
    //   7086: invokevirtual 2550	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   7089: sipush -2029
    //   7092: iconst_0
    //   7093: aload_1
    //   7094: invokevirtual 2553	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   7097: i2l
    //   7098: invokevirtual 2554	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   7101: aload 29
    //   7103: iconst_1
    //   7104: putfield 2555	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   7107: aload 29
    //   7109: aload_1
    //   7110: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7113: i2l
    //   7114: putfield 2556	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   7117: aload 29
    //   7119: aload_1
    //   7120: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   7123: putfield 2557	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   7126: aload 29
    //   7128: invokevirtual 2560	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   7131: pop
    //   7132: aload 29
    //   7134: invokevirtual 2563	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   7137: aload 29
    //   7139: getfield 2541	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7142: iconst_1
    //   7143: if_icmpne +11 -> 7154
    //   7146: aload 29
    //   7148: getfield 2545	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   7151: ifeq +8218 -> 15369
    //   7154: aload 29
    //   7156: astore_1
    //   7157: aload 29
    //   7159: getfield 2541	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   7162: iconst_1
    //   7163: if_icmpne +114 -> 7277
    //   7166: aload_0
    //   7167: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7170: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7173: astore 28
    //   7175: aconst_null
    //   7176: astore_1
    //   7177: aload 28
    //   7179: aload 29
    //   7181: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7184: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7187: ifeq +110 -> 7297
    //   7190: aload 29
    //   7192: getfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7195: astore_1
    //   7196: aload 29
    //   7198: aload_0
    //   7199: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7202: aload_1
    //   7203: invokevirtual 2566	com/tencent/mobileqq/data/MessageForQQWalletTips:getQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   7206: astore 28
    //   7208: aload 29
    //   7210: astore_1
    //   7211: aload 28
    //   7213: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7216: ifne +61 -> 7277
    //   7219: aload 28
    //   7221: ldc_w 2568
    //   7224: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7227: ifne +17 -> 7244
    //   7230: aload 29
    //   7232: astore_1
    //   7233: aload 28
    //   7235: ldc_w 2570
    //   7238: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7241: ifeq +36 -> 7277
    //   7244: aload 29
    //   7246: aload_0
    //   7247: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7250: aload 28
    //   7252: aload 29
    //   7254: getfield 2573	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightStart	I
    //   7257: aload 29
    //   7259: getfield 2576	com/tencent/mobileqq/data/MessageForQQWalletTips:highLightEnd	I
    //   7262: aload 29
    //   7264: getfield 2579	com/tencent/mobileqq/data/MessageForQQWalletTips:textColor	Ljava/lang/String;
    //   7267: aload 29
    //   7269: getfield 2582	com/tencent/mobileqq/data/MessageForQQWalletTips:url	Ljava/lang/String;
    //   7272: invokevirtual 2586	com/tencent/mobileqq/data/MessageForQQWalletTips:addQQWalletTips	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V
    //   7275: aconst_null
    //   7276: astore_1
    //   7277: aload_1
    //   7278: areturn
    //   7279: aload 29
    //   7281: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7284: astore 28
    //   7286: goto -212 -> 7074
    //   7289: astore_1
    //   7290: aload_1
    //   7291: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   7294: goto -157 -> 7137
    //   7297: aload 28
    //   7299: aload 29
    //   7301: getfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7304: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7307: ifeq -111 -> 7196
    //   7310: aload 29
    //   7312: getfield 2531	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7315: astore_1
    //   7316: goto -120 -> 7196
    //   7319: aload 32
    //   7321: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7324: ldc2_w 2587
    //   7327: lcmp
    //   7328: ifne +76 -> 7404
    //   7331: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7334: ifeq +13 -> 7347
    //   7337: ldc_w 2590
    //   7340: iconst_2
    //   7341: ldc_w 2592
    //   7344: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7347: new 2594	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7350: dup
    //   7351: invokespecial 2595	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:<init>	()V
    //   7354: aload 32
    //   7356: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7359: invokevirtual 2596	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7362: checkcast 2594	tencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody
    //   7365: astore_1
    //   7366: aload_0
    //   7367: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7370: bipush 85
    //   7372: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   7375: checkcast 2598	com/tencent/qidian/controller/QidianHandler
    //   7378: aload_1
    //   7379: invokevirtual 2601	com/tencent/qidian/controller/QidianHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x92/SubMsgType0x92$MsgBody;)V
    //   7382: aconst_null
    //   7383: areturn
    //   7384: astore_1
    //   7385: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7388: ifeq -7359 -> 29
    //   7391: ldc_w 468
    //   7394: iconst_2
    //   7395: ldc_w 2603
    //   7398: aload_1
    //   7399: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7402: aconst_null
    //   7403: areturn
    //   7404: aload 32
    //   7406: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7409: ldc2_w 2604
    //   7412: lcmp
    //   7413: ifne +76 -> 7489
    //   7416: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7419: ifeq +13 -> 7432
    //   7422: ldc_w 2607
    //   7425: iconst_2
    //   7426: ldc_w 2609
    //   7429: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7432: new 2611	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7435: dup
    //   7436: invokespecial 2612	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:<init>	()V
    //   7439: aload 32
    //   7441: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7444: invokevirtual 2613	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7447: checkcast 2611	tencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody
    //   7450: astore_1
    //   7451: aload_0
    //   7452: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7455: bipush 85
    //   7457: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   7460: checkcast 2598	com/tencent/qidian/controller/QidianHandler
    //   7463: aload_1
    //   7464: invokevirtual 2616	com/tencent/qidian/controller/QidianHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe5/Submsgtype0xe5$MsgBody;)V
    //   7467: aconst_null
    //   7468: areturn
    //   7469: astore_1
    //   7470: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7473: ifeq -7444 -> 29
    //   7476: ldc_w 468
    //   7479: iconst_2
    //   7480: ldc_w 2618
    //   7483: aload_1
    //   7484: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   7487: aconst_null
    //   7488: areturn
    //   7489: aload 32
    //   7491: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7494: ldc2_w 2619
    //   7497: lcmp
    //   7498: ifne +357 -> 7855
    //   7501: new 2622	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody
    //   7504: dup
    //   7505: invokespecial 2623	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:<init>	()V
    //   7508: astore 31
    //   7510: sipush -2029
    //   7513: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7516: checkcast 2506	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7519: astore 30
    //   7521: aload 31
    //   7523: aload 32
    //   7525: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7528: invokevirtual 2624	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7531: pop
    //   7532: iconst_0
    //   7533: istore 5
    //   7535: ldc 140
    //   7537: astore 29
    //   7539: aload 29
    //   7541: astore 28
    //   7543: iload 5
    //   7545: istore 4
    //   7547: aload 31
    //   7549: getfield 2628	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:sint32_sessiontype	Lcom/tencent/mobileqq/pb/PBSInt32Field;
    //   7552: invokevirtual 2631	com/tencent/mobileqq/pb/PBSInt32Field:get	()I
    //   7555: tableswitch	default:+7875 -> 15430, 3:+240->7795, 4:+261->7816, 5:+29->7584, 6:+7889->15444
    //   7585: lload_0
    //   7586: new 88	java/lang/StringBuilder
    //   7589: dup
    //   7590: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7593: aload 31
    //   7595: getfield 2632	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7598: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7601: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7604: ldc 140
    //   7606: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7609: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7612: putfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7615: aload 30
    //   7617: new 88	java/lang/StringBuilder
    //   7620: dup
    //   7621: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7624: aload 31
    //   7626: getfield 2633	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7629: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7632: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7635: ldc 140
    //   7637: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7640: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7643: putfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7646: aload 30
    //   7648: aload 31
    //   7650: getfield 2634	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7653: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7656: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7659: putfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   7662: aload 30
    //   7664: aload 31
    //   7666: getfield 2635	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7669: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7672: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7675: putfield 2531	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   7678: aload 30
    //   7680: aload 31
    //   7682: getfield 2636	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7685: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7688: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7691: putfield 2537	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   7694: aload_0
    //   7695: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7698: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7701: astore 31
    //   7703: aload_0
    //   7704: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7707: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7710: aload 30
    //   7712: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7715: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7718: ifeq +119 -> 7837
    //   7721: aload 30
    //   7723: getfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   7726: astore 29
    //   7728: aload 30
    //   7730: aload 31
    //   7732: aload 29
    //   7734: aload 28
    //   7736: ldc_w 2547
    //   7739: aload_1
    //   7740: invokevirtual 2550	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   7743: sipush -2029
    //   7746: iload 4
    //   7748: aload_1
    //   7749: invokevirtual 2553	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   7752: i2l
    //   7753: invokevirtual 2554	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   7756: aload 30
    //   7758: iconst_1
    //   7759: putfield 2555	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   7762: aload 30
    //   7764: aload_1
    //   7765: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   7768: i2l
    //   7769: putfield 2556	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   7772: aload 30
    //   7774: aload_1
    //   7775: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   7778: putfield 2557	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   7781: aload 30
    //   7783: invokevirtual 2560	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   7786: pop
    //   7787: aload 30
    //   7789: invokevirtual 2563	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   7792: goto +7649 -> 15441
    //   7795: sipush 1000
    //   7798: istore 4
    //   7800: aload 31
    //   7802: getfield 2639	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7805: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7808: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7811: astore 28
    //   7813: goto -229 -> 7584
    //   7816: sipush 1004
    //   7819: istore 4
    //   7821: aload 31
    //   7823: getfield 2639	tencent/im/s2c/msgtype0x210/submsgtype0x9f/MsgBody:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7826: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7829: invokestatic 443	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7832: astore 28
    //   7834: goto -250 -> 7584
    //   7837: aload 30
    //   7839: getfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   7842: astore 29
    //   7844: goto -116 -> 7728
    //   7847: astore_1
    //   7848: aload_1
    //   7849: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   7852: goto +7589 -> 15441
    //   7855: aload 32
    //   7857: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   7860: ldc2_w 2640
    //   7863: lcmp
    //   7864: ifne +305 -> 8169
    //   7867: aload_0
    //   7868: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7871: bipush 50
    //   7873: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7876: checkcast 125	com/tencent/mobileqq/app/FriendsManager
    //   7879: astore 34
    //   7881: new 2643	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody
    //   7884: dup
    //   7885: invokespecial 2644	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:<init>	()V
    //   7888: astore 33
    //   7890: sipush -2029
    //   7893: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   7896: checkcast 2506	com/tencent/mobileqq/data/MessageForQQWalletTips
    //   7899: astore 31
    //   7901: aload 33
    //   7903: aload 32
    //   7905: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   7908: invokevirtual 2645	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7911: pop
    //   7912: new 88	java/lang/StringBuilder
    //   7915: dup
    //   7916: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7919: aload 33
    //   7921: getfield 2646	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_sender_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7924: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7927: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7930: ldc 140
    //   7932: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7935: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7938: astore 29
    //   7940: new 88	java/lang/StringBuilder
    //   7943: dup
    //   7944: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   7947: aload 33
    //   7949: getfield 2647	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:uint64_receiver_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7952: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7955: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7958: ldc 140
    //   7960: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7963: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7966: astore 30
    //   7968: aload_0
    //   7969: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7972: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   7975: aload 29
    //   7977: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7980: ifeq +166 -> 8146
    //   7983: aload 30
    //   7985: astore 28
    //   7987: aload 34
    //   7989: aload 28
    //   7991: invokevirtual 129	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   7994: astore 32
    //   7996: aload 32
    //   7998: ifnull +155 -> 8153
    //   8001: aload 32
    //   8003: invokevirtual 146	com/tencent/mobileqq/data/Friends:isFriend	()Z
    //   8006: ifeq +147 -> 8153
    //   8009: iconst_0
    //   8010: istore 4
    //   8012: aload 31
    //   8014: aload 29
    //   8016: putfield 2513	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   8019: aload 31
    //   8021: aload 30
    //   8023: putfield 2519	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   8026: aload 31
    //   8028: aload 33
    //   8030: getfield 2648	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_sender_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8033: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8036: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8039: putfield 2525	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   8042: aload 31
    //   8044: aload 33
    //   8046: getfield 2649	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_receiver_rich_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8049: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8052: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8055: putfield 2531	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   8058: aload 31
    //   8060: aload 33
    //   8062: getfield 2650	tencent/im/s2c/msgtype0x210/submsgtype0xa2/MsgBody:bytes_authkey	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   8065: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   8068: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   8071: putfield 2537	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   8074: aload 31
    //   8076: aload_0
    //   8077: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8080: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   8083: aload 28
    //   8085: ldc 140
    //   8087: ldc_w 2547
    //   8090: aload_1
    //   8091: invokevirtual 2550	OnlinePushPack/MsgInfo:getUMsgTime	()J
    //   8094: sipush -2029
    //   8097: iload 4
    //   8099: aload_1
    //   8100: invokevirtual 2553	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   8103: i2l
    //   8104: invokevirtual 2554	com/tencent/mobileqq/data/MessageForQQWalletTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   8107: aload 31
    //   8109: iconst_1
    //   8110: putfield 2555	com/tencent/mobileqq/data/MessageForQQWalletTips:isread	Z
    //   8113: aload 31
    //   8115: aload_1
    //   8116: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8119: i2l
    //   8120: putfield 2556	com/tencent/mobileqq/data/MessageForQQWalletTips:shmsgseq	J
    //   8123: aload 31
    //   8125: aload_1
    //   8126: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8129: putfield 2557	com/tencent/mobileqq/data/MessageForQQWalletTips:msgUid	J
    //   8132: aload 31
    //   8134: invokevirtual 2560	com/tencent/mobileqq/data/MessageForQQWalletTips:getBytes	()[B
    //   8137: pop
    //   8138: aload 31
    //   8140: invokevirtual 2563	com/tencent/mobileqq/data/MessageForQQWalletTips:onReceiveGrapTips	()V
    //   8143: aload 31
    //   8145: areturn
    //   8146: aload 29
    //   8148: astore 28
    //   8150: goto -163 -> 7987
    //   8153: sipush 1001
    //   8156: istore 4
    //   8158: goto -146 -> 8012
    //   8161: astore_1
    //   8162: aload_1
    //   8163: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   8166: goto -23 -> 8143
    //   8169: aload 32
    //   8171: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8174: ldc2_w 2651
    //   8177: lcmp
    //   8178: ifne +62 -> 8240
    //   8181: aload_0
    //   8182: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8185: bipush 62
    //   8187: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   8190: checkcast 2654	com/tencent/mobileqq/app/readinjoy/ReadInJoyHandler
    //   8193: aload 32
    //   8195: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8198: invokevirtual 2655	com/tencent/mobileqq/app/readinjoy/ReadInJoyHandler:a	([B)V
    //   8201: aload_1
    //   8202: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   8205: lstore_2
    //   8206: aload_1
    //   8207: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   8210: istore 4
    //   8212: aload_1
    //   8213: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   8216: lstore 15
    //   8218: aload_1
    //   8219: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   8222: istore 5
    //   8224: aload_0
    //   8225: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8228: lload_2
    //   8229: iload 4
    //   8231: lload 15
    //   8233: iload 5
    //   8235: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   8238: aconst_null
    //   8239: areturn
    //   8240: aload 32
    //   8242: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8245: ldc2_w 2656
    //   8248: lcmp
    //   8249: ifne +114 -> 8363
    //   8252: new 2659	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody
    //   8255: dup
    //   8256: invokespecial 2660	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:<init>	()V
    //   8259: astore_1
    //   8260: aload_1
    //   8261: aload 32
    //   8263: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8266: invokevirtual 2661	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8269: pop
    //   8270: aload_1
    //   8271: getfield 2664	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8274: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   8277: ifeq +34 -> 8311
    //   8280: aload_1
    //   8281: getfield 2664	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:uint64_friend_msg_type_flag	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   8284: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   8287: lconst_1
    //   8288: lcmp
    //   8289: ifne +68 -> 8357
    //   8292: iconst_1
    //   8293: istore 4
    //   8295: iload 4
    //   8297: ifeq +14 -> 8311
    //   8300: aload_0
    //   8301: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   8304: invokevirtual 1261	com/tencent/mobileqq/app/MessageHandler:a	()Lcom/tencent/mobileqq/app/message/SystemMessageProcessor;
    //   8307: iconst_2
    //   8308: invokevirtual 1264	com/tencent/mobileqq/app/message/SystemMessageProcessor:a	(I)V
    //   8311: aload_1
    //   8312: getfield 2667	tencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody:rpt_msg_msg_notify	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   8315: invokevirtual 1837	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   8318: ifeq -8289 -> 29
    //   8321: aload_0
    //   8322: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8325: aload_1
    //   8326: invokestatic 2672	com/tencent/mobileqq/activity/contact/newfriend/CloneFriendPushHelper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/s2c/msgtype0x210/submsgtype0x87/SubMsgType0x87$MsgBody;)V
    //   8329: aconst_null
    //   8330: areturn
    //   8331: astore_1
    //   8332: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8335: ifeq +13 -> 8348
    //   8338: ldc_w 2320
    //   8341: iconst_2
    //   8342: ldc 140
    //   8344: aload_1
    //   8345: invokestatic 2322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   8348: new 2324	java/lang/RuntimeException
    //   8351: dup
    //   8352: aload_1
    //   8353: invokespecial 2327	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   8356: athrow
    //   8357: iconst_0
    //   8358: istore 4
    //   8360: goto -65 -> 8295
    //   8363: aload 32
    //   8365: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8368: ldc2_w 2673
    //   8371: lcmp
    //   8372: ifeq +15 -> 8387
    //   8375: aload 32
    //   8377: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8380: ldc2_w 2675
    //   8383: lcmp
    //   8384: ifne +68 -> 8452
    //   8387: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8390: ifeq +13 -> 8403
    //   8393: ldc_w 2678
    //   8396: iconst_2
    //   8397: ldc_w 2680
    //   8400: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8403: new 2682	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody
    //   8406: dup
    //   8407: invokespecial 2683	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:<init>	()V
    //   8410: astore_1
    //   8411: aload_1
    //   8412: aload 32
    //   8414: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8417: invokevirtual 2684	tencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8420: pop
    //   8421: aload_0
    //   8422: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8425: aload_1
    //   8426: lconst_0
    //   8427: iconst_0
    //   8428: invokestatic 2687	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/msgsync/cmd0x100/Submsgtype0x8a$ReqBody;JZ)V
    //   8431: aconst_null
    //   8432: areturn
    //   8433: astore_1
    //   8434: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8437: ifeq -8408 -> 29
    //   8440: ldc_w 2678
    //   8443: iconst_2
    //   8444: ldc_w 2689
    //   8447: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8450: aconst_null
    //   8451: areturn
    //   8452: aload 32
    //   8454: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8457: ldc2_w 2690
    //   8460: lcmp
    //   8461: ifne +25 -> 8486
    //   8464: aload_0
    //   8465: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8468: bipush 51
    //   8470: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   8473: checkcast 2112	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   8476: aload 32
    //   8478: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8481: invokevirtual 2692	com/tencent/device/devicemgr/SmartDeviceProxyMgr:a	([B)V
    //   8484: aconst_null
    //   8485: areturn
    //   8486: aload 32
    //   8488: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8491: ldc2_w 2693
    //   8494: lcmp
    //   8495: ifne +24 -> 8519
    //   8498: iconst_2
    //   8499: invokestatic 2700	com/tencent/mqp/app/sec/d:x	()[Ljava/lang/Object;
    //   8502: aload 32
    //   8504: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8507: invokestatic 2704	com/tencent/mqp/app/sec/d:e1	(I[Ljava/lang/Object;[B)V
    //   8510: aconst_null
    //   8511: areturn
    //   8512: astore_1
    //   8513: aload_1
    //   8514: invokevirtual 2705	java/lang/Throwable:printStackTrace	()V
    //   8517: aconst_null
    //   8518: areturn
    //   8519: aload 32
    //   8521: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8524: ldc2_w 2706
    //   8527: lcmp
    //   8528: ifne +182 -> 8710
    //   8531: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8534: ifeq +13 -> 8547
    //   8537: ldc_w 468
    //   8540: iconst_4
    //   8541: ldc_w 2709
    //   8544: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8547: new 2711	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody
    //   8550: dup
    //   8551: invokespecial 2712	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:<init>	()V
    //   8554: astore_1
    //   8555: aload_1
    //   8556: aload 32
    //   8558: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8561: invokevirtual 2713	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8564: pop
    //   8565: new 397	android/content/Intent
    //   8568: dup
    //   8569: ldc_w 2715
    //   8572: invokespecial 401	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   8575: astore 28
    //   8577: aload_1
    //   8578: getfield 2718	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8581: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   8584: ifeq +114 -> 8698
    //   8587: aload_1
    //   8588: getfield 2718	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:uint32_push_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   8591: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   8594: tableswitch	default:+6862 -> 15456, 0:+80->8674, 1:+92->8686
    //   8617: iload_2
    //   8618: ldc_w 2720
    //   8621: invokevirtual 2723	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8624: pop
    //   8625: aload 28
    //   8627: ldc_w 2725
    //   8630: aload_1
    //   8631: getfield 2728	tencent/im/s2c/msgtype0x210/submsgtype0x96/submsgtype0x96$MsgBody:string_push_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8634: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   8637: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   8640: pop
    //   8641: aload_0
    //   8642: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8645: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   8648: aload 28
    //   8650: invokevirtual 422	com/tencent/qphone/base/util/BaseApplication:sendBroadcast	(Landroid/content/Intent;)V
    //   8653: aconst_null
    //   8654: areturn
    //   8655: astore_1
    //   8656: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8659: ifeq -8630 -> 29
    //   8662: ldc_w 468
    //   8665: iconst_4
    //   8666: ldc_w 2730
    //   8669: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8672: aconst_null
    //   8673: areturn
    //   8674: aload 28
    //   8676: ldc_w 2720
    //   8679: invokevirtual 2723	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8682: pop
    //   8683: goto -58 -> 8625
    //   8686: aload 28
    //   8688: ldc_w 2732
    //   8691: invokevirtual 2723	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8694: pop
    //   8695: goto -70 -> 8625
    //   8698: aload 28
    //   8700: ldc_w 2720
    //   8703: invokevirtual 2723	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   8706: pop
    //   8707: goto -82 -> 8625
    //   8710: aload 32
    //   8712: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8715: ldc2_w 2733
    //   8718: lcmp
    //   8719: ifne +240 -> 8959
    //   8722: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8725: ifeq +13 -> 8738
    //   8728: ldc_w 468
    //   8731: iconst_2
    //   8732: ldc_w 2736
    //   8735: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   8738: new 2738	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody
    //   8741: dup
    //   8742: invokespecial 2739	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:<init>	()V
    //   8745: astore_1
    //   8746: aload_1
    //   8747: aload 32
    //   8749: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8752: invokevirtual 2740	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8755: pop
    //   8756: aload_1
    //   8757: getfield 2743	tencent/im/s2c/msgtype0x210/submsgtype0xce/submsgtype0xce$MsgBody:string_params	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8760: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   8763: astore_1
    //   8764: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8767: ifeq +29 -> 8796
    //   8770: ldc_w 468
    //   8773: new 88	java/lang/StringBuilder
    //   8776: dup
    //   8777: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   8780: ldc_w 2745
    //   8783: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8786: aload_1
    //   8787: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   8790: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   8793: invokestatic 2749	com/tencent/open/wadl/WLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   8796: new 2751	org/json/JSONObject
    //   8799: dup
    //   8800: aload_1
    //   8801: invokespecial 2752	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8804: ldc_w 2754
    //   8807: invokevirtual 2757	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   8810: astore 28
    //   8812: ldc_w 2759
    //   8815: invokestatic 2762	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   8818: ldc_w 2764
    //   8821: invokevirtual 2768	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   8824: astore 29
    //   8826: iconst_0
    //   8827: istore 6
    //   8829: iconst_0
    //   8830: istore 4
    //   8832: iload 6
    //   8834: istore 5
    //   8836: iload 4
    //   8838: aload 29
    //   8840: arraylength
    //   8841: if_icmpge +38 -> 8879
    //   8844: aload 29
    //   8846: iload 4
    //   8848: aaload
    //   8849: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8852: ifne +98 -> 8950
    //   8855: aload 28
    //   8857: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8860: ifne +90 -> 8950
    //   8863: aload 29
    //   8865: iload 4
    //   8867: aaload
    //   8868: aload 28
    //   8870: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   8873: ifeq +77 -> 8950
    //   8876: iconst_1
    //   8877: istore 5
    //   8879: iload 5
    //   8881: ifne +33 -> 8914
    //   8884: aload 28
    //   8886: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8889: ifne +25 -> 8914
    //   8892: aload 28
    //   8894: ldc_w 2770
    //   8897: invokestatic 2772	com/tencent/gamecenter/appointment/GameCenterUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   8900: pop
    //   8901: aload 28
    //   8903: aload_1
    //   8904: ldc_w 2774
    //   8907: invokestatic 2777	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   8910: pop
    //   8911: invokestatic 2781	com/tencent/gamecenter/appointment/GameCenterBroadcastReceiver:a	()V
    //   8914: invokestatic 2785	com/tencent/gamecenter/appointment/GameCenterCheck:b	()V
    //   8917: aload_0
    //   8918: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   8921: ldc_w 2787
    //   8924: ldc_w 2789
    //   8927: aload 28
    //   8929: ldc_w 2791
    //   8932: ldc_w 2793
    //   8935: ldc_w 2795
    //   8938: invokestatic 2798	com/tencent/gamecenter/appointment/GameCenterUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   8941: aconst_null
    //   8942: areturn
    //   8943: astore_1
    //   8944: aload_1
    //   8945: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   8948: aconst_null
    //   8949: areturn
    //   8950: iload 4
    //   8952: iconst_1
    //   8953: iadd
    //   8954: istore 4
    //   8956: goto -124 -> 8832
    //   8959: aload 32
    //   8961: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   8964: ldc2_w 2799
    //   8967: lcmp
    //   8968: ifne +1451 -> 10419
    //   8971: new 2802	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody
    //   8974: dup
    //   8975: invokespecial 2803	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:<init>	()V
    //   8978: astore 28
    //   8980: aload 28
    //   8982: aload 32
    //   8984: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   8987: invokevirtual 2804	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   8990: pop
    //   8991: aload 28
    //   8993: getfield 2807	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   8996: invokevirtual 1999	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   8999: ifeq +1201 -> 10200
    //   9002: aload 28
    //   9004: getfield 2807	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_folder_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9007: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9010: invokevirtual 2810	java/lang/String:trim	()Ljava/lang/String;
    //   9013: astore_1
    //   9014: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9017: ifeq +30 -> 9047
    //   9020: ldc_w 2812
    //   9023: iconst_2
    //   9024: new 88	java/lang/StringBuilder
    //   9027: dup
    //   9028: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9031: ldc_w 2814
    //   9034: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9037: aload_1
    //   9038: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9041: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9044: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9047: aload 28
    //   9049: getfield 2817	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9052: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9055: iconst_1
    //   9056: if_icmpne +1150 -> 10206
    //   9059: iconst_1
    //   9060: istore 22
    //   9062: aload 28
    //   9064: getfield 2820	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_folder_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9067: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9070: iconst_1
    //   9071: if_icmpne +1141 -> 10212
    //   9074: iconst_1
    //   9075: istore 23
    //   9077: aload 28
    //   9079: getfield 2823	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9082: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9085: iconst_1
    //   9086: if_icmpne +1132 -> 10218
    //   9089: iconst_1
    //   9090: istore 20
    //   9092: aload 28
    //   9094: getfield 2826	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9097: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9100: iconst_1
    //   9101: if_icmpne +1123 -> 10224
    //   9104: iconst_1
    //   9105: istore 19
    //   9107: aload 28
    //   9109: getfield 2829	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9112: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9115: iconst_1
    //   9116: if_icmpne +1114 -> 10230
    //   9119: iconst_1
    //   9120: istore 21
    //   9122: aload 28
    //   9124: getfield 2832	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_start_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9127: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9130: istore 6
    //   9132: aload 28
    //   9134: getfield 2835	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_end_ts	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9137: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9140: istore 7
    //   9142: invokestatic 460	java/lang/System:currentTimeMillis	()J
    //   9145: ldc2_w 2836
    //   9148: ldiv
    //   9149: l2i
    //   9150: istore 8
    //   9152: aload 28
    //   9154: getfield 2840	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_period_of_validity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9157: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9160: istore 5
    //   9162: aload 28
    //   9164: getfield 2843	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9167: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9170: istore 9
    //   9172: aload 28
    //   9174: getfield 2846	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_task_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9177: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9180: astore 31
    //   9182: aload 28
    //   9184: getfield 2849	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_name	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9187: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9190: astore 32
    //   9192: aload 28
    //   9194: getfield 2852	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_type_color	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9197: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9200: astore 33
    //   9202: aload 28
    //   9204: getfield 2855	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:str_jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   9207: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   9210: astore 29
    //   9212: aload 28
    //   9214: getfield 2858	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9217: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9220: istore 10
    //   9222: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9225: ifeq +163 -> 9388
    //   9228: ldc_w 2812
    //   9231: iconst_2
    //   9232: new 88	java/lang/StringBuilder
    //   9235: dup
    //   9236: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9239: ldc_w 2860
    //   9242: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9245: iload 6
    //   9247: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9250: ldc_w 2862
    //   9253: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9256: iload 7
    //   9258: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9261: ldc_w 2864
    //   9264: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9267: iload 5
    //   9269: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9272: ldc_w 2866
    //   9275: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9278: iload 23
    //   9280: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9283: ldc_w 2868
    //   9286: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9289: iload 22
    //   9291: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9294: ldc_w 2868
    //   9297: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9300: iload 20
    //   9302: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9305: ldc_w 2868
    //   9308: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9311: iload 19
    //   9313: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9316: ldc_w 2868
    //   9319: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9322: iload 21
    //   9324: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9327: ldc_w 2870
    //   9330: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9333: iload 9
    //   9335: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   9338: ldc_w 2872
    //   9341: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9344: aload 31
    //   9346: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9349: ldc_w 2874
    //   9352: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9355: aload 32
    //   9357: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9360: ldc_w 2876
    //   9363: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9366: aload 33
    //   9368: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9371: ldc_w 2878
    //   9374: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9377: aload 29
    //   9379: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9382: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9385: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9388: iload 8
    //   9390: iload 6
    //   9392: if_icmplt -9363 -> 29
    //   9395: iload 8
    //   9397: iload 7
    //   9399: if_icmpgt -9370 -> 29
    //   9402: iload 5
    //   9404: istore 4
    //   9406: iload 5
    //   9408: ldc_w 2879
    //   9411: if_icmple +8 -> 9419
    //   9414: ldc_w 2879
    //   9417: istore 4
    //   9419: iload 22
    //   9421: ifne +18 -> 9439
    //   9424: iload 20
    //   9426: ifne +13 -> 9439
    //   9429: iload 19
    //   9431: ifne +8 -> 9439
    //   9434: iload 21
    //   9436: ifeq +5930 -> 15366
    //   9439: iconst_1
    //   9440: istore 23
    //   9442: iload 23
    //   9444: ifne +5903 -> 15347
    //   9447: iload 22
    //   9449: ifne +15 -> 9464
    //   9452: aload 28
    //   9454: getfield 2882	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discover_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9457: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9460: iconst_1
    //   9461: if_icmpne +775 -> 10236
    //   9464: iconst_1
    //   9465: istore 22
    //   9467: iload 20
    //   9469: ifne +15 -> 9484
    //   9472: aload 28
    //   9474: getfield 2885	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_discount_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9477: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9480: iconst_1
    //   9481: if_icmpne +761 -> 10242
    //   9484: iconst_1
    //   9485: istore 20
    //   9487: iload 19
    //   9489: ifne +15 -> 9504
    //   9492: aload 28
    //   9494: getfield 2888	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_nearby_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9497: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9500: iconst_1
    //   9501: if_icmpne +747 -> 10248
    //   9504: iconst_1
    //   9505: istore 19
    //   9507: iload 21
    //   9509: ifne +15 -> 9524
    //   9512: aload 28
    //   9514: getfield 2891	tencent/im/s2c/msgtype0x210/submsgtype0x94/Submsgtype0x94$MsgBody:uint32_only_mine_reddot_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   9517: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   9520: iconst_1
    //   9521: if_icmpne +733 -> 10254
    //   9524: iconst_1
    //   9525: istore 21
    //   9527: iload 21
    //   9529: istore 24
    //   9531: iload 22
    //   9533: istore 25
    //   9535: iload 20
    //   9537: istore 26
    //   9539: iload 19
    //   9541: istore 27
    //   9543: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9546: ifeq +80 -> 9626
    //   9549: ldc_w 2812
    //   9552: iconst_2
    //   9553: new 88	java/lang/StringBuilder
    //   9556: dup
    //   9557: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9560: ldc_w 2893
    //   9563: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9566: iload 22
    //   9568: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9571: ldc_w 2868
    //   9574: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9577: iload 20
    //   9579: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9582: ldc_w 2868
    //   9585: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9588: iload 19
    //   9590: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9593: ldc_w 2868
    //   9596: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9599: iload 21
    //   9601: invokevirtual 280	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   9604: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9607: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   9610: iload 19
    //   9612: istore 27
    //   9614: iload 20
    //   9616: istore 26
    //   9618: iload 22
    //   9620: istore 25
    //   9622: iload 21
    //   9624: istore 24
    //   9626: aload_0
    //   9627: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9630: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   9633: astore 30
    //   9635: aload 30
    //   9637: astore 28
    //   9639: aload 30
    //   9641: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9644: ifeq +8 -> 9652
    //   9647: ldc_w 2895
    //   9650: astore 28
    //   9652: aload_0
    //   9653: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   9656: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   9659: new 88	java/lang/StringBuilder
    //   9662: dup
    //   9663: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   9666: ldc_w 2897
    //   9669: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9672: aload 28
    //   9674: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   9677: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   9680: iconst_0
    //   9681: invokevirtual 824	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   9684: astore 30
    //   9686: aload 30
    //   9688: invokeinterface 359 1 0
    //   9693: astore 28
    //   9695: aload 30
    //   9697: ldc_w 2899
    //   9700: iconst_0
    //   9701: invokeinterface 2903 3 0
    //   9706: ifne +59 -> 9765
    //   9709: aload 30
    //   9711: ldc_w 2905
    //   9714: iconst_0
    //   9715: invokeinterface 2903 3 0
    //   9720: ifne +45 -> 9765
    //   9723: aload 30
    //   9725: ldc_w 2907
    //   9728: iconst_0
    //   9729: invokeinterface 2903 3 0
    //   9734: ifne +31 -> 9765
    //   9737: aload 30
    //   9739: ldc_w 2909
    //   9742: iconst_0
    //   9743: invokeinterface 2903 3 0
    //   9748: ifne +17 -> 9765
    //   9751: aload 30
    //   9753: ldc_w 2911
    //   9756: iconst_0
    //   9757: invokeinterface 2903 3 0
    //   9762: ifeq +109 -> 9871
    //   9765: aload 30
    //   9767: ldc_w 2913
    //   9770: iconst_0
    //   9771: invokeinterface 374 3 0
    //   9776: istore 5
    //   9778: aload 30
    //   9780: ldc_w 2915
    //   9783: iconst_0
    //   9784: invokeinterface 374 3 0
    //   9789: istore 11
    //   9791: aload 30
    //   9793: ldc_w 2917
    //   9796: iconst_0
    //   9797: invokeinterface 374 3 0
    //   9802: istore 12
    //   9804: aload 30
    //   9806: ldc_w 2919
    //   9809: iconst_0
    //   9810: invokeinterface 374 3 0
    //   9815: istore 13
    //   9817: invokestatic 460	java/lang/System:currentTimeMillis	()J
    //   9820: ldc2_w 2836
    //   9823: ldiv
    //   9824: l2i
    //   9825: istore 14
    //   9827: iload 14
    //   9829: ifeq +42 -> 9871
    //   9832: iload 11
    //   9834: ifeq +37 -> 9871
    //   9837: iload 12
    //   9839: ifeq +32 -> 9871
    //   9842: iload 13
    //   9844: ifeq +27 -> 9871
    //   9847: iload 14
    //   9849: iload 11
    //   9851: if_icmplt +409 -> 10260
    //   9854: iload 14
    //   9856: iload 12
    //   9858: if_icmpgt +402 -> 10260
    //   9861: iload 14
    //   9863: iload 5
    //   9865: isub
    //   9866: iload 13
    //   9868: if_icmpge +392 -> 10260
    //   9871: aload 28
    //   9873: ldc_w 2915
    //   9876: iload 6
    //   9878: invokeinterface 367 3 0
    //   9883: pop
    //   9884: aload 28
    //   9886: ldc_w 2917
    //   9889: iload 7
    //   9891: invokeinterface 367 3 0
    //   9896: pop
    //   9897: aload 28
    //   9899: ldc_w 2919
    //   9902: iload 4
    //   9904: invokeinterface 367 3 0
    //   9909: pop
    //   9910: aload 28
    //   9912: ldc_w 2921
    //   9915: aload_1
    //   9916: invokeinterface 2924 3 0
    //   9921: pop
    //   9922: aload 28
    //   9924: ldc_w 2913
    //   9927: iload 8
    //   9929: invokeinterface 367 3 0
    //   9934: pop
    //   9935: aload 28
    //   9937: ldc_w 2926
    //   9940: iload 9
    //   9942: invokeinterface 367 3 0
    //   9947: pop
    //   9948: aload 28
    //   9950: ldc_w 2928
    //   9953: aload 31
    //   9955: invokeinterface 2924 3 0
    //   9960: pop
    //   9961: aload 28
    //   9963: ldc_w 2930
    //   9966: aload 32
    //   9968: invokeinterface 2924 3 0
    //   9973: pop
    //   9974: aload 28
    //   9976: ldc_w 2932
    //   9979: aload 33
    //   9981: invokeinterface 2924 3 0
    //   9986: pop
    //   9987: aload 28
    //   9989: ldc_w 2934
    //   9992: invokestatic 520	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   9995: invokeinterface 2937 4 0
    //   10000: pop
    //   10001: aload 28
    //   10003: ldc_w 2939
    //   10006: iload 10
    //   10008: invokeinterface 367 3 0
    //   10013: pop
    //   10014: aload 29
    //   10016: ifnonnull +323 -> 10339
    //   10019: ldc 140
    //   10021: astore_1
    //   10022: aload 28
    //   10024: ldc_w 2941
    //   10027: aload_1
    //   10028: invokeinterface 2924 3 0
    //   10033: pop
    //   10034: aload 28
    //   10036: ldc_w 2943
    //   10039: iconst_1
    //   10040: invokeinterface 367 3 0
    //   10045: pop
    //   10046: aload 28
    //   10048: ldc_w 2911
    //   10051: iload 23
    //   10053: invokeinterface 2947 3 0
    //   10058: pop
    //   10059: aload 28
    //   10061: ldc_w 2899
    //   10064: iload 25
    //   10066: invokeinterface 2947 3 0
    //   10071: pop
    //   10072: aload 28
    //   10074: ldc_w 2905
    //   10077: iload 26
    //   10079: invokeinterface 2947 3 0
    //   10084: pop
    //   10085: aload 28
    //   10087: ldc_w 2907
    //   10090: iload 27
    //   10092: invokeinterface 2947 3 0
    //   10097: pop
    //   10098: aload 28
    //   10100: ldc_w 2909
    //   10103: iload 24
    //   10105: invokeinterface 2947 3 0
    //   10110: pop
    //   10111: aload 28
    //   10113: invokeinterface 370 1 0
    //   10118: pop
    //   10119: iload 23
    //   10121: ifeq +224 -> 10345
    //   10124: aload_0
    //   10125: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10128: bipush 87
    //   10130: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10133: checkcast 2949	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager
    //   10136: invokestatic 520	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10139: iload 23
    //   10141: invokevirtual 2952	com/tencent/biz/pubaccount/ecshopassit/EcShopAssistantManager:a	(JZ)V
    //   10144: aload_0
    //   10145: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10148: bipush 68
    //   10150: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   10153: checkcast 2954	com/tencent/biz/pubaccount/ecshopassit/EcShopHandler
    //   10156: invokevirtual 2955	com/tencent/biz/pubaccount/ecshopassit/EcShopHandler:b	()V
    //   10159: aconst_null
    //   10160: astore_1
    //   10161: iload 25
    //   10163: ifeq +208 -> 10371
    //   10166: ldc_w 2957
    //   10169: astore_1
    //   10170: aload_0
    //   10171: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10174: ldc_w 979
    //   10177: ldc 140
    //   10179: ldc 140
    //   10181: ldc_w 2959
    //   10184: aload_1
    //   10185: iconst_0
    //   10186: iconst_0
    //   10187: ldc 140
    //   10189: ldc 140
    //   10191: ldc 140
    //   10193: ldc 140
    //   10195: invokestatic 986	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   10198: aconst_null
    //   10199: areturn
    //   10200: ldc 140
    //   10202: astore_1
    //   10203: goto -1189 -> 9014
    //   10206: iconst_0
    //   10207: istore 22
    //   10209: goto -1147 -> 9062
    //   10212: iconst_0
    //   10213: istore 23
    //   10215: goto -1138 -> 9077
    //   10218: iconst_0
    //   10219: istore 20
    //   10221: goto -1129 -> 9092
    //   10224: iconst_0
    //   10225: istore 19
    //   10227: goto -1120 -> 9107
    //   10230: iconst_0
    //   10231: istore 21
    //   10233: goto -1111 -> 9122
    //   10236: iconst_0
    //   10237: istore 22
    //   10239: goto -772 -> 9467
    //   10242: iconst_0
    //   10243: istore 20
    //   10245: goto -758 -> 9487
    //   10248: iconst_0
    //   10249: istore 19
    //   10251: goto -744 -> 9507
    //   10254: iconst_0
    //   10255: istore 21
    //   10257: goto -730 -> 9527
    //   10260: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10263: ifeq +13 -> 10276
    //   10266: ldc_w 2812
    //   10269: iconst_2
    //   10270: ldc_w 2961
    //   10273: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   10276: aload 28
    //   10278: ldc_w 2899
    //   10281: iconst_0
    //   10282: invokeinterface 2947 3 0
    //   10287: pop
    //   10288: aload 28
    //   10290: ldc_w 2905
    //   10293: iconst_0
    //   10294: invokeinterface 2947 3 0
    //   10299: pop
    //   10300: aload 28
    //   10302: ldc_w 2907
    //   10305: iconst_0
    //   10306: invokeinterface 2947 3 0
    //   10311: pop
    //   10312: aload 28
    //   10314: ldc_w 2909
    //   10317: iconst_0
    //   10318: invokeinterface 2947 3 0
    //   10323: pop
    //   10324: aload 28
    //   10326: ldc_w 2911
    //   10329: iconst_0
    //   10330: invokeinterface 2947 3 0
    //   10335: pop
    //   10336: goto -465 -> 9871
    //   10339: aload 29
    //   10341: astore_1
    //   10342: goto -320 -> 10022
    //   10345: aload_0
    //   10346: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10349: ldc_w 2963
    //   10352: invokevirtual 2967	com/tencent/mobileqq/app/QQAppInterface:getHandler	(Ljava/lang/Class;)Lmqq/os/MqqHandler;
    //   10355: astore_1
    //   10356: aload_1
    //   10357: ifnull -213 -> 10144
    //   10360: aload_1
    //   10361: sipush 1009
    //   10364: invokevirtual 2972	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   10367: pop
    //   10368: goto -224 -> 10144
    //   10371: iload 26
    //   10373: ifeq +10 -> 10383
    //   10376: ldc_w 2974
    //   10379: astore_1
    //   10380: goto -210 -> 10170
    //   10383: iload 27
    //   10385: ifeq +10 -> 10395
    //   10388: ldc_w 2976
    //   10391: astore_1
    //   10392: goto -222 -> 10170
    //   10395: iload 24
    //   10397: ifeq +10 -> 10407
    //   10400: ldc_w 2978
    //   10403: astore_1
    //   10404: goto -234 -> 10170
    //   10407: iload 23
    //   10409: ifeq -239 -> 10170
    //   10412: ldc_w 2980
    //   10415: astore_1
    //   10416: goto -246 -> 10170
    //   10419: aload 32
    //   10421: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10424: ldc2_w 2981
    //   10427: lcmp
    //   10428: ifne +88 -> 10516
    //   10431: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10434: ifeq +13 -> 10447
    //   10437: ldc_w 468
    //   10440: iconst_2
    //   10441: ldc_w 2984
    //   10444: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10447: aload_0
    //   10448: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10451: sipush 152
    //   10454: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10457: checkcast 608	com/tencent/mobileqq/apollo/ApolloManager
    //   10460: astore 28
    //   10462: aload 28
    //   10464: ifnull +13 -> 10477
    //   10467: aload 28
    //   10469: aload 32
    //   10471: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10474: invokevirtual 2985	com/tencent/mobileqq/apollo/ApolloManager:a	([B)V
    //   10477: aload_1
    //   10478: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   10481: lstore_2
    //   10482: aload_1
    //   10483: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   10486: istore 4
    //   10488: aload_1
    //   10489: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   10492: lstore 15
    //   10494: aload_1
    //   10495: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   10498: istore 5
    //   10500: aload_0
    //   10501: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   10504: lload_2
    //   10505: iload 4
    //   10507: lload 15
    //   10509: iload 5
    //   10511: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   10514: aconst_null
    //   10515: areturn
    //   10516: aload 32
    //   10518: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10521: ldc2_w 2986
    //   10524: lcmp
    //   10525: ifne +56 -> 10581
    //   10528: new 2989	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody
    //   10531: dup
    //   10532: invokespecial 2990	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:<init>	()V
    //   10535: astore_1
    //   10536: aload_1
    //   10537: aload 32
    //   10539: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10542: invokevirtual 2991	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10545: pop
    //   10546: aload_1
    //   10547: getfield 2992	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   10550: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   10553: pop2
    //   10554: aload_1
    //   10555: getfield 2995	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:uint32_sub_cmd	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10558: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10561: pop
    //   10562: aload_1
    //   10563: getfield 2999	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$MsgBody:msg_mod_block	Ltencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock;
    //   10566: invokevirtual 3002	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10569: checkcast 3001	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock
    //   10572: getfield 3005	tencent/im/s2c/msgtype0x210/submsgtype0x98/submsgtype0x98$ModBlock:uint32_op	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10575: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10578: pop
    //   10579: aconst_null
    //   10580: areturn
    //   10581: aload 32
    //   10583: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10586: ldc2_w 3006
    //   10589: lcmp
    //   10590: ifne +87 -> 10677
    //   10593: new 3009	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   10596: dup
    //   10597: invokespecial 3010	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   10600: astore_1
    //   10601: aload_1
    //   10602: aload 32
    //   10604: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10607: invokevirtual 3011	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10610: pop
    //   10611: aload_1
    //   10612: getfield 3014	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   10615: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   10618: istore 4
    //   10620: iload 4
    //   10622: ifne +26 -> 10648
    //   10625: iconst_1
    //   10626: istore 19
    //   10628: aload_0
    //   10629: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10632: sipush 137
    //   10635: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10638: checkcast 3016	com/tencent/mobileqq/activity/bless/BlessManager
    //   10641: iload 19
    //   10643: invokevirtual 3019	com/tencent/mobileqq/activity/bless/BlessManager:c	(Z)V
    //   10646: aconst_null
    //   10647: areturn
    //   10648: iconst_0
    //   10649: istore 19
    //   10651: goto -23 -> 10628
    //   10654: astore_1
    //   10655: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10658: ifeq +13 -> 10671
    //   10661: ldc_w 3021
    //   10664: iconst_2
    //   10665: ldc_w 3023
    //   10668: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   10671: iconst_1
    //   10672: istore 19
    //   10674: goto -46 -> 10628
    //   10677: aload 32
    //   10679: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   10682: ldc2_w 3024
    //   10685: lcmp
    //   10686: ifne +552 -> 11238
    //   10689: iconst_0
    //   10690: istore 19
    //   10692: aload_0
    //   10693: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10696: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10699: ldc_w 3027
    //   10702: invokevirtual 3030	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10705: checkcast 3032	android/app/ActivityManager
    //   10708: iconst_1
    //   10709: invokevirtual 3036	android/app/ActivityManager:getRunningTasks	(I)Ljava/util/List;
    //   10712: astore_1
    //   10713: aload_1
    //   10714: ifnull +4627 -> 15341
    //   10717: aload_1
    //   10718: invokeinterface 873 1 0
    //   10723: iconst_1
    //   10724: if_icmplt +4617 -> 15341
    //   10727: aload_1
    //   10728: iconst_0
    //   10729: invokeinterface 850 2 0
    //   10734: checkcast 3038	android/app/ActivityManager$RunningTaskInfo
    //   10737: getfield 3042	android/app/ActivityManager$RunningTaskInfo:topActivity	Landroid/content/ComponentName;
    //   10740: invokevirtual 3047	android/content/ComponentName:getClassName	()Ljava/lang/String;
    //   10743: astore_1
    //   10744: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10747: ifeq +30 -> 10777
    //   10750: ldc_w 468
    //   10753: iconst_2
    //   10754: new 88	java/lang/StringBuilder
    //   10757: dup
    //   10758: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   10761: ldc_w 3049
    //   10764: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10767: aload_1
    //   10768: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10771: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   10774: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   10777: ldc_w 3051
    //   10780: aload_1
    //   10781: invokevirtual 307	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   10784: istore 20
    //   10786: iload 20
    //   10788: istore 19
    //   10790: aload_0
    //   10791: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10794: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   10797: ldc_w 3053
    //   10800: invokevirtual 3030	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10803: checkcast 3055	android/os/PowerManager
    //   10806: invokevirtual 3058	android/os/PowerManager:isScreenOn	()Z
    //   10809: istore 20
    //   10811: iload 20
    //   10813: ifeq +18 -> 10831
    //   10816: aload_0
    //   10817: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   10820: getfield 3061	com/tencent/mobileqq/app/QQAppInterface:isBackground_Pause	Z
    //   10823: ifeq -10794 -> 29
    //   10826: iload 19
    //   10828: ifne -10799 -> 29
    //   10831: new 3063	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody
    //   10834: dup
    //   10835: invokespecial 3064	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:<init>	()V
    //   10838: astore 30
    //   10840: aconst_null
    //   10841: astore_1
    //   10842: aconst_null
    //   10843: astore 28
    //   10845: aconst_null
    //   10846: astore 29
    //   10848: aload 30
    //   10850: aload 32
    //   10852: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   10855: invokevirtual 3065	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   10858: pop
    //   10859: aload 30
    //   10861: getfield 3068	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10864: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   10867: ifeq +15 -> 10882
    //   10870: aload 30
    //   10872: getfield 3068	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10875: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   10878: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   10881: astore_1
    //   10882: aload 30
    //   10884: getfield 3071	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10887: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   10890: ifeq +16 -> 10906
    //   10893: aload 30
    //   10895: getfield 3071	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_brief	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10898: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   10901: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   10904: astore 28
    //   10906: aload 30
    //   10908: getfield 3074	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10911: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   10914: ifeq +16 -> 10930
    //   10917: aload 30
    //   10919: getfield 3074	tencent/im/s2c/msgtype0x210/submsgtype0xa4/submsgtype0xa4$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   10922: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   10925: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   10928: astore 29
    //   10930: aload_1
    //   10931: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10934: ifne -10905 -> 29
    //   10937: aload 28
    //   10939: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10942: ifne -10913 -> 29
    //   10945: aload 29
    //   10947: invokestatic 675	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10950: ifne -10921 -> 29
    //   10953: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10956: ifeq +52 -> 11008
    //   10959: ldc_w 468
    //   10962: iconst_2
    //   10963: new 88	java/lang/StringBuilder
    //   10966: dup
    //   10967: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   10970: ldc_w 3076
    //   10973: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10976: aload_1
    //   10977: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10980: ldc_w 3078
    //   10983: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10986: aload 28
    //   10988: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10991: ldc_w 3080
    //   10994: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   10997: aload 29
    //   10999: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11002: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11005: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11008: new 397	android/content/Intent
    //   11011: dup
    //   11012: aload_0
    //   11013: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11016: invokevirtual 416	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   11019: ldc_w 3082
    //   11022: invokespecial 3085	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   11025: astore 30
    //   11027: aload 30
    //   11029: ldc_w 3086
    //   11032: aload 29
    //   11034: invokevirtual 412	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   11037: pop
    //   11038: aload 30
    //   11040: ldc_w 3088
    //   11043: sipush 3001
    //   11046: invokevirtual 3091	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   11049: pop
    //   11050: new 3093	com/tencent/qphone/base/remote/ToServiceMsg
    //   11053: dup
    //   11054: ldc_w 3095
    //   11057: aload_0
    //   11058: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11061: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11064: ldc_w 3097
    //   11067: invokespecial 3100	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11070: astore 29
    //   11072: aload 29
    //   11074: getfield 3104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11077: ldc_w 3106
    //   11080: iconst_3
    //   11081: anewarray 264	java/lang/String
    //   11084: dup
    //   11085: iconst_0
    //   11086: aload 28
    //   11088: aastore
    //   11089: dup
    //   11090: iconst_1
    //   11091: aload_1
    //   11092: aastore
    //   11093: dup
    //   11094: iconst_2
    //   11095: aload 28
    //   11097: aastore
    //   11098: invokevirtual 3110	android/os/Bundle:putStringArray	(Ljava/lang/String;[Ljava/lang/String;)V
    //   11101: aload 29
    //   11103: getfield 3104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11106: ldc_w 3112
    //   11109: aload 30
    //   11111: invokevirtual 3116	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11114: aload 29
    //   11116: getfield 3104	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   11119: ldc_w 3118
    //   11122: aconst_null
    //   11123: invokevirtual 3116	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   11126: aload_0
    //   11127: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11130: aload 29
    //   11132: invokevirtual 3122	com/tencent/mobileqq/app/QQAppInterface:sendToService	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   11135: aconst_null
    //   11136: ldc_w 979
    //   11139: ldc 140
    //   11141: ldc 140
    //   11143: ldc_w 3124
    //   11146: ldc_w 3124
    //   11149: iconst_0
    //   11150: iconst_0
    //   11151: ldc 140
    //   11153: ldc 140
    //   11155: ldc 140
    //   11157: ldc 140
    //   11159: invokestatic 986	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   11162: aconst_null
    //   11163: areturn
    //   11164: astore_1
    //   11165: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11168: ifeq +13 -> 11181
    //   11171: ldc_w 468
    //   11174: iconst_2
    //   11175: ldc_w 3126
    //   11178: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11181: aload_1
    //   11182: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   11185: aconst_null
    //   11186: areturn
    //   11187: astore_1
    //   11188: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11191: ifeq +13 -> 11204
    //   11194: ldc_w 468
    //   11197: iconst_2
    //   11198: ldc_w 3128
    //   11201: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11204: aload_1
    //   11205: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   11208: goto -418 -> 10790
    //   11211: astore_1
    //   11212: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11215: ifeq +13 -> 11228
    //   11218: ldc_w 468
    //   11221: iconst_2
    //   11222: ldc_w 3130
    //   11225: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11228: aload_1
    //   11229: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   11232: iconst_1
    //   11233: istore 20
    //   11235: goto -424 -> 10811
    //   11238: aload 32
    //   11240: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11243: ldc2_w 3131
    //   11246: lcmp
    //   11247: ifne +289 -> 11536
    //   11250: aload 32
    //   11252: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11255: ifnull +281 -> 11536
    //   11258: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11261: ifeq +13 -> 11274
    //   11264: ldc_w 468
    //   11267: iconst_2
    //   11268: ldc_w 3134
    //   11271: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11274: aload_0
    //   11275: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11278: sipush 142
    //   11281: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11284: checkcast 544	com/tencent/mobileqq/qcall/PstnManager
    //   11287: invokevirtual 3136	com/tencent/mobileqq/qcall/PstnManager:a	()I
    //   11290: iconst_1
    //   11291: if_icmpne -11262 -> 29
    //   11294: new 3138	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody
    //   11297: dup
    //   11298: invokespecial 3139	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:<init>	()V
    //   11301: astore 28
    //   11303: aload 28
    //   11305: aload 32
    //   11307: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11310: invokevirtual 3140	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11313: checkcast 3138	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody
    //   11316: astore 28
    //   11318: sipush -2045
    //   11321: invokestatic 1102	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   11324: astore 29
    //   11326: aload 28
    //   11328: getfield 3141	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:bytes_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11331: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11334: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11337: astore 30
    //   11339: aload 28
    //   11341: getfield 3142	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11344: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   11347: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   11350: astore 31
    //   11352: aload 28
    //   11354: getfield 3145	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_auth_key	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11357: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11360: invokestatic 3149	com/tencent/mobileqq/qcall/UinUtils:a	(I)Ljava/lang/String;
    //   11363: astore 32
    //   11365: aload 28
    //   11367: getfield 3150	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11370: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11373: istore 5
    //   11375: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11378: ifeq +4081 -> 15459
    //   11381: ldc_w 468
    //   11384: iconst_2
    //   11385: iconst_3
    //   11386: anewarray 209	java/lang/Object
    //   11389: dup
    //   11390: iconst_0
    //   11391: ldc_w 3152
    //   11394: aastore
    //   11395: dup
    //   11396: iconst_1
    //   11397: iload 5
    //   11399: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11402: aastore
    //   11403: dup
    //   11404: iconst_2
    //   11405: aload 28
    //   11407: getfield 3145	tencent/im/s2c/msgtype0x210/submsgtype0x9e/SubmsgType0x9e$MsgBody:uint32_auth_key	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11410: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11413: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   11416: aastore
    //   11417: invokestatic 3155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   11420: goto +4039 -> 15459
    //   11423: aload 29
    //   11425: aload_0
    //   11426: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11429: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11432: aload 32
    //   11434: aload 32
    //   11436: new 88	java/lang/StringBuilder
    //   11439: dup
    //   11440: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11443: aload 30
    //   11445: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11448: ldc_w 3157
    //   11451: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11454: aload 31
    //   11456: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11459: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11462: lconst_0
    //   11463: sipush -2045
    //   11466: iload 4
    //   11468: aload_1
    //   11469: invokevirtual 2553	OnlinePushPack/MsgInfo:getShMsgSeq	()S
    //   11472: i2l
    //   11473: invokevirtual 1108	com/tencent/mobileqq/data/MessageRecord:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   11476: aload 29
    //   11478: iconst_1
    //   11479: putfield 1114	com/tencent/mobileqq/data/MessageRecord:isread	Z
    //   11482: aload_0
    //   11483: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11486: invokevirtual 953	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   11489: aload 29
    //   11491: aload_0
    //   11492: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11495: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   11498: invokevirtual 1575	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   11501: aconst_null
    //   11502: areturn
    //   11503: astore_1
    //   11504: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11507: ifeq -11478 -> 29
    //   11510: ldc_w 468
    //   11513: iconst_2
    //   11514: ldc_w 3159
    //   11517: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11520: aconst_null
    //   11521: areturn
    //   11522: iload 5
    //   11524: iconst_2
    //   11525: if_icmpne -102 -> 11423
    //   11528: sipush 3000
    //   11531: istore 4
    //   11533: goto -110 -> 11423
    //   11536: aload 32
    //   11538: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11541: ldc2_w 3006
    //   11544: lcmp
    //   11545: ifne +87 -> 11632
    //   11548: new 3009	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody
    //   11551: dup
    //   11552: invokespecial 3010	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:<init>	()V
    //   11555: astore_1
    //   11556: aload_1
    //   11557: aload 32
    //   11559: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11562: invokevirtual 3011	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11565: pop
    //   11566: aload_1
    //   11567: getfield 3014	tencent/im/s2c/msgtype0x210/submsgtype0xa0/submsgtype0xa0$MsgBody:uint32_is_mass_bless_open	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   11570: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   11573: istore 4
    //   11575: iload 4
    //   11577: ifne +26 -> 11603
    //   11580: iconst_1
    //   11581: istore 19
    //   11583: aload_0
    //   11584: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11587: sipush 137
    //   11590: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11593: checkcast 3016	com/tencent/mobileqq/activity/bless/BlessManager
    //   11596: iload 19
    //   11598: invokevirtual 3019	com/tencent/mobileqq/activity/bless/BlessManager:c	(Z)V
    //   11601: aconst_null
    //   11602: areturn
    //   11603: iconst_0
    //   11604: istore 19
    //   11606: goto -23 -> 11583
    //   11609: astore_1
    //   11610: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11613: ifeq +13 -> 11626
    //   11616: ldc_w 3021
    //   11619: iconst_2
    //   11620: ldc_w 3023
    //   11623: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11626: iconst_1
    //   11627: istore 19
    //   11629: goto -46 -> 11583
    //   11632: aload 32
    //   11634: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11637: ldc2_w 3160
    //   11640: lcmp
    //   11641: ifne +100 -> 11741
    //   11644: new 3163	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody
    //   11647: dup
    //   11648: invokespecial 3164	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:<init>	()V
    //   11651: astore_1
    //   11652: aload_1
    //   11653: aload 32
    //   11655: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11658: invokevirtual 3165	tencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11661: pop
    //   11662: aload_0
    //   11663: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11666: bipush 75
    //   11668: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   11671: checkcast 3167	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   11674: astore 28
    //   11676: aload_0
    //   11677: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11680: bipush 114
    //   11682: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11685: checkcast 3169	cooperation/dingdong/DingdongPluginManager
    //   11688: astore 29
    //   11690: aload 28
    //   11692: aload_1
    //   11693: iconst_0
    //   11694: invokevirtual 3172	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9b/SubMsgType0x9b$MsgBody;Z)V
    //   11697: aconst_null
    //   11698: areturn
    //   11699: astore 28
    //   11701: ldc_w 468
    //   11704: iconst_1
    //   11705: new 88	java/lang/StringBuilder
    //   11708: dup
    //   11709: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11712: ldc_w 3174
    //   11715: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11718: aload 28
    //   11720: invokevirtual 3175	java/lang/Exception:toString	()Ljava/lang/String;
    //   11723: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11726: ldc_w 3177
    //   11729: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11732: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11735: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11738: goto -76 -> 11662
    //   11741: aload 32
    //   11743: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11746: ldc2_w 3178
    //   11749: lcmp
    //   11750: ifne +82 -> 11832
    //   11753: new 3181	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody
    //   11756: dup
    //   11757: invokespecial 3182	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:<init>	()V
    //   11760: astore_1
    //   11761: aload_1
    //   11762: aload 32
    //   11764: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11767: invokevirtual 3183	tencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11770: pop
    //   11771: aload_0
    //   11772: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11775: bipush 75
    //   11777: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   11780: checkcast 3167	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler
    //   11783: aload_1
    //   11784: iconst_0
    //   11785: invokevirtual 3186	com/tencent/mobileqq/app/utils/DingdongPluginBizHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0x9c/SubMsgType0x9c$MsgBody;Z)V
    //   11788: aconst_null
    //   11789: areturn
    //   11790: astore 28
    //   11792: ldc_w 468
    //   11795: iconst_1
    //   11796: new 88	java/lang/StringBuilder
    //   11799: dup
    //   11800: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   11803: ldc_w 3188
    //   11806: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11809: aload 28
    //   11811: invokevirtual 3175	java/lang/Exception:toString	()Ljava/lang/String;
    //   11814: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11817: ldc_w 3177
    //   11820: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   11823: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   11826: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   11829: goto -58 -> 11771
    //   11832: aload 32
    //   11834: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11837: ldc2_w 3189
    //   11840: lcmp
    //   11841: ifne +104 -> 11945
    //   11844: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11847: ifeq +13 -> 11860
    //   11850: ldc_w 3192
    //   11853: iconst_2
    //   11854: ldc_w 3194
    //   11857: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11860: new 3196	tencent/qht_exinfo/qht_post_exinfo
    //   11863: dup
    //   11864: invokespecial 3197	tencent/qht_exinfo/qht_post_exinfo:<init>	()V
    //   11867: astore_1
    //   11868: aload_1
    //   11869: aload 32
    //   11871: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11874: invokevirtual 3198	tencent/qht_exinfo/qht_post_exinfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11877: pop
    //   11878: aload_0
    //   11879: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11882: bipush 97
    //   11884: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   11887: checkcast 3200	com/tencent/mobileqq/troop/utils/TroopTopicMgr
    //   11890: astore 28
    //   11892: aload 28
    //   11894: ifnull -11865 -> 29
    //   11897: aload 28
    //   11899: aload_1
    //   11900: getfield 3203	tencent/qht_exinfo/qht_post_exinfo:groupCode	Lcom/tencent/mobileqq/pb/PBStringField;
    //   11903: invokevirtual 1696	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   11906: aload_1
    //   11907: getfield 3206	tencent/qht_exinfo/qht_post_exinfo:msgSeq	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   11910: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   11913: aload_1
    //   11914: getfield 3209	tencent/qht_exinfo/qht_post_exinfo:pVersion	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   11917: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   11920: invokevirtual 3212	com/tencent/mobileqq/troop/utils/TroopTopicMgr:a	(Ljava/lang/String;JJ)V
    //   11923: aconst_null
    //   11924: areturn
    //   11925: astore_1
    //   11926: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11929: ifeq -11900 -> 29
    //   11932: ldc_w 3192
    //   11935: iconst_2
    //   11936: ldc_w 3214
    //   11939: aload_1
    //   11940: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   11943: aconst_null
    //   11944: areturn
    //   11945: aload 32
    //   11947: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   11950: ldc2_w 3215
    //   11953: lcmp
    //   11954: ifne +75 -> 12029
    //   11957: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11960: ifeq +13 -> 11973
    //   11963: ldc_w 3218
    //   11966: iconst_2
    //   11967: ldc_w 3220
    //   11970: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   11973: new 3222	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody
    //   11976: dup
    //   11977: invokespecial 3223	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:<init>	()V
    //   11980: astore_1
    //   11981: aload_1
    //   11982: aload 32
    //   11984: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   11987: invokevirtual 3224	tencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   11990: pop
    //   11991: aload_0
    //   11992: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   11995: bipush 20
    //   11997: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   12000: checkcast 1634	com/tencent/mobileqq/app/TroopHandler
    //   12003: aload_1
    //   12004: invokevirtual 3227	com/tencent/mobileqq/app/TroopHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xab/SubMsgType0xab$MsgBody;)V
    //   12007: aconst_null
    //   12008: areturn
    //   12009: astore_1
    //   12010: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12013: ifeq -11984 -> 29
    //   12016: ldc_w 3218
    //   12019: iconst_2
    //   12020: ldc_w 3229
    //   12023: aload_1
    //   12024: invokestatic 3231	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   12027: aconst_null
    //   12028: areturn
    //   12029: aload 32
    //   12031: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12034: ldc2_w 3232
    //   12037: lcmp
    //   12038: ifne +47 -> 12085
    //   12041: new 3235	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody
    //   12044: dup
    //   12045: invokespecial 3236	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:<init>	()V
    //   12048: astore_1
    //   12049: aload_1
    //   12050: aload 32
    //   12052: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12055: invokevirtual 3237	tencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12058: pop
    //   12059: aload_0
    //   12060: aload_1
    //   12061: invokevirtual 3240	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xa8/SubMsgType0xa8$MsgBody;)V
    //   12064: aconst_null
    //   12065: areturn
    //   12066: astore_1
    //   12067: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12070: ifeq -12041 -> 29
    //   12073: ldc_w 3242
    //   12076: iconst_2
    //   12077: ldc_w 3244
    //   12080: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12083: aconst_null
    //   12084: areturn
    //   12085: aload 32
    //   12087: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12090: ldc2_w 3245
    //   12093: lcmp
    //   12094: ifne +78 -> 12172
    //   12097: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12100: ifeq +13 -> 12113
    //   12103: ldc_w 3248
    //   12106: iconst_2
    //   12107: ldc_w 3250
    //   12110: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12113: new 3252	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody
    //   12116: dup
    //   12117: invokespecial 3253	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:<init>	()V
    //   12120: astore_1
    //   12121: aload_1
    //   12122: aload 32
    //   12124: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12127: invokevirtual 3254	tencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12130: pop
    //   12131: aload_0
    //   12132: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12135: sipush 155
    //   12138: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12141: checkcast 3256	com/tencent/mobileqq/gameparty/GamePartyManager
    //   12144: aload_1
    //   12145: iconst_0
    //   12146: invokevirtual 3259	com/tencent/mobileqq/gameparty/GamePartyManager:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xaa/SubMsgType0xaa$MsgBody;Z)V
    //   12149: aconst_null
    //   12150: areturn
    //   12151: astore 28
    //   12153: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12156: ifeq -25 -> 12131
    //   12159: ldc_w 3248
    //   12162: iconst_2
    //   12163: ldc_w 3261
    //   12166: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12169: goto -38 -> 12131
    //   12172: aload 32
    //   12174: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12177: ldc2_w 3262
    //   12180: lcmp
    //   12181: ifne +735 -> 12916
    //   12184: new 3265	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody
    //   12187: dup
    //   12188: invokespecial 3266	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:<init>	()V
    //   12191: astore 28
    //   12193: aload 28
    //   12195: aload 32
    //   12197: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12200: invokevirtual 3267	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12203: pop
    //   12204: aload 28
    //   12206: getfield 3268	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12209: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12212: ifeq +579 -> 12791
    //   12215: aload 28
    //   12217: getfield 3268	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12220: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12223: iconst_2
    //   12224: if_icmpne +567 -> 12791
    //   12227: aload 28
    //   12229: getfield 3272	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12232: getfield 3278	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:fixed32_timestamp	Lcom/tencent/mobileqq/pb/PBFixed32Field;
    //   12235: invokevirtual 3281	com/tencent/mobileqq/pb/PBFixed32Field:get	()I
    //   12238: i2l
    //   12239: lstore_2
    //   12240: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12243: ifeq +30 -> 12273
    //   12246: ldc_w 468
    //   12249: iconst_2
    //   12250: new 88	java/lang/StringBuilder
    //   12253: dup
    //   12254: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   12257: ldc_w 3283
    //   12260: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   12263: lload_2
    //   12264: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   12267: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   12270: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12273: aload 28
    //   12275: getfield 3272	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12278: getfield 3286	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:rpt_msg_friend_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   12281: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   12284: astore 30
    //   12286: aload 30
    //   12288: ifnull +579 -> 12867
    //   12291: aload 30
    //   12293: invokeinterface 873 1 0
    //   12298: ifle +569 -> 12867
    //   12301: new 655	java/util/ArrayList
    //   12304: dup
    //   12305: aload 30
    //   12307: invokeinterface 873 1 0
    //   12312: invokespecial 3288	java/util/ArrayList:<init>	(I)V
    //   12315: astore 29
    //   12317: aload 30
    //   12319: invokeinterface 51 1 0
    //   12324: astore 30
    //   12326: aload 30
    //   12328: invokeinterface 56 1 0
    //   12333: ifeq +497 -> 12830
    //   12336: aload 30
    //   12338: invokeinterface 60 1 0
    //   12343: checkcast 3290	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow
    //   12346: astore 31
    //   12348: new 3292	com/tencent/mobileqq/data/PushRecommend
    //   12351: dup
    //   12352: invokespecial 3293	com/tencent/mobileqq/data/PushRecommend:<init>	()V
    //   12355: astore 32
    //   12357: aload 31
    //   12359: getfield 3294	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12362: invokevirtual 33	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   12365: ifeq +19 -> 12384
    //   12368: aload 32
    //   12370: aload 31
    //   12372: getfield 3294	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   12375: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   12378: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   12381: putfield 3295	com/tencent/mobileqq/data/PushRecommend:uin	Ljava/lang/String;
    //   12384: aload 31
    //   12386: getfield 3298	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12389: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12392: ifeq +26 -> 12418
    //   12395: aload 32
    //   12397: new 264	java/lang/String
    //   12400: dup
    //   12401: aload 31
    //   12403: getfield 3298	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12406: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12409: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12412: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12415: putfield 3301	com/tencent/mobileqq/data/PushRecommend:nick	Ljava/lang/String;
    //   12418: aload 31
    //   12420: getfield 3302	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12423: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12426: ifeq +17 -> 12443
    //   12429: aload 32
    //   12431: aload 31
    //   12433: getfield 3302	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12436: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12439: i2s
    //   12440: putfield 3304	com/tencent/mobileqq/data/PushRecommend:age	S
    //   12443: aload 31
    //   12445: getfield 3307	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12448: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12451: ifeq +17 -> 12468
    //   12454: aload 32
    //   12456: aload 31
    //   12458: getfield 3307	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12461: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12464: i2s
    //   12465: putfield 3309	com/tencent/mobileqq/data/PushRecommend:gender	S
    //   12468: aload 31
    //   12470: getfield 3312	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12473: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12476: ifeq +26 -> 12502
    //   12479: aload 32
    //   12481: new 264	java/lang/String
    //   12484: dup
    //   12485: aload 31
    //   12487: getfield 3312	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_main_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12490: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12493: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12496: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12499: putfield 3315	com/tencent/mobileqq/data/PushRecommend:recommendReason	Ljava/lang/String;
    //   12502: aload 31
    //   12504: getfield 3318	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12507: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12510: ifeq +19 -> 12529
    //   12513: aload 32
    //   12515: aload 31
    //   12517: getfield 3318	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_alghrithm	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12520: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12523: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12526: putfield 3321	com/tencent/mobileqq/data/PushRecommend:algBuffer	[B
    //   12529: aload 31
    //   12531: getfield 3324	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12534: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12537: ifeq +26 -> 12563
    //   12540: aload 32
    //   12542: new 264	java/lang/String
    //   12545: dup
    //   12546: aload 31
    //   12548: getfield 3324	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_soure_reason	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12551: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12554: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12557: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12560: putfield 3327	com/tencent/mobileqq/data/PushRecommend:sourceReason	Ljava/lang/String;
    //   12563: aload 31
    //   12565: getfield 3330	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12568: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12571: ifeq +16 -> 12587
    //   12574: aload 32
    //   12576: aload 31
    //   12578: getfield 3330	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12581: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12584: putfield 3333	com/tencent/mobileqq/data/PushRecommend:fromSource	I
    //   12587: aload 31
    //   12589: getfield 3337	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12592: invokevirtual 3340	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:has	()Z
    //   12595: ifeq +69 -> 12664
    //   12598: aload 31
    //   12600: getfield 3337	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:msg_android_source	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource;
    //   12603: invokevirtual 3341	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12606: checkcast 3339	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource
    //   12609: astore 33
    //   12611: aload 33
    //   12613: ifnull +51 -> 12664
    //   12616: aload 33
    //   12618: getfield 3342	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12621: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12624: ifeq +16 -> 12640
    //   12627: aload 32
    //   12629: aload 33
    //   12631: getfield 3342	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12634: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12637: putfield 3345	com/tencent/mobileqq/data/PushRecommend:sourceId	I
    //   12640: aload 33
    //   12642: getfield 3348	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12645: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12648: ifeq +16 -> 12664
    //   12651: aload 32
    //   12653: aload 33
    //   12655: getfield 3348	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$AddFriendSource:uint32_sub_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12658: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12661: putfield 3351	com/tencent/mobileqq/data/PushRecommend:subSourceId	I
    //   12664: aload 31
    //   12666: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12669: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12672: ifeq +26 -> 12698
    //   12675: aload 32
    //   12677: new 264	java/lang/String
    //   12680: dup
    //   12681: aload 31
    //   12683: getfield 3354	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_msg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12686: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12689: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12692: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12695: putfield 3357	com/tencent/mobileqq/data/PushRecommend:wzryVerifyStr	Ljava/lang/String;
    //   12698: aload 31
    //   12700: getfield 3360	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12703: invokevirtual 69	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   12706: ifeq +16 -> 12722
    //   12709: aload 32
    //   12711: aload 31
    //   12713: getfield 3360	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:uint32_game_source	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12716: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12719: putfield 3363	com/tencent/mobileqq/data/PushRecommend:wzrySourceId	I
    //   12722: aload 31
    //   12724: getfield 3366	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12727: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12730: ifeq +26 -> 12756
    //   12733: aload 32
    //   12735: new 264	java/lang/String
    //   12738: dup
    //   12739: aload 31
    //   12741: getfield 3366	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PersonMayKnow:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12744: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12747: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   12750: invokespecial 1157	java/lang/String:<init>	([B)V
    //   12753: putfield 3369	com/tencent/mobileqq/data/PushRecommend:wzryGameNick	Ljava/lang/String;
    //   12756: aload 32
    //   12758: lload_2
    //   12759: putfield 3370	com/tencent/mobileqq/data/PushRecommend:timestamp	J
    //   12762: aload 29
    //   12764: aload 32
    //   12766: invokevirtual 659	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   12769: pop
    //   12770: goto -444 -> 12326
    //   12773: astore 28
    //   12775: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12778: ifeq +13 -> 12791
    //   12781: ldc_w 3242
    //   12784: iconst_2
    //   12785: ldc_w 3372
    //   12788: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12791: aload_1
    //   12792: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   12795: lstore_2
    //   12796: aload_1
    //   12797: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   12800: istore 4
    //   12802: aload_1
    //   12803: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   12806: lstore 15
    //   12808: aload_1
    //   12809: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   12812: istore 5
    //   12814: aload_0
    //   12815: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   12818: lload_2
    //   12819: iload 4
    //   12821: lload 15
    //   12823: iload 5
    //   12825: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   12828: aconst_null
    //   12829: areturn
    //   12830: aload_0
    //   12831: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12834: sipush 158
    //   12837: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   12840: checkcast 3374	com/tencent/mobileqq/app/MayknowRecommendManager
    //   12843: aload 29
    //   12845: lload_2
    //   12846: invokevirtual 3377	com/tencent/mobileqq/app/MayknowRecommendManager:a	(Ljava/util/ArrayList;J)V
    //   12849: aload_0
    //   12850: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12853: iconst_1
    //   12854: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   12857: checkcast 201	com/tencent/mobileqq/app/FriendListHandler
    //   12860: bipush 109
    //   12862: iconst_1
    //   12863: aconst_null
    //   12864: invokevirtual 1544	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   12867: aload 28
    //   12869: getfield 3272	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12872: getfield 3378	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12875: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   12878: ifeq -87 -> 12791
    //   12881: aload 28
    //   12883: getfield 3272	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$MsgBody:msg_persons_may_know	Ltencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2;
    //   12886: getfield 3378	tencent/im/s2c/msgtype0x210/submsgtype0xae/SubMsgType0xae$PushPeopleMayKnowV2:bytes_role_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   12889: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   12892: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   12895: astore 28
    //   12897: aload_0
    //   12898: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12901: aload_0
    //   12902: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   12905: invokevirtual 677	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   12908: aload 28
    //   12910: invokestatic 3384	com/tencent/mobileqq/data/KplRoleInfo:saveGameNickWithUin	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   12913: goto -122 -> 12791
    //   12916: aload 32
    //   12918: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   12921: ldc2_w 3385
    //   12924: lcmp
    //   12925: ifne +172 -> 13097
    //   12928: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12931: ifeq +13 -> 12944
    //   12934: ldc_w 3388
    //   12937: iconst_2
    //   12938: ldc_w 3390
    //   12941: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12944: new 3392	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody
    //   12947: dup
    //   12948: invokespecial 3393	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:<init>	()V
    //   12951: astore_1
    //   12952: aload_1
    //   12953: aload 32
    //   12955: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   12958: invokevirtual 3394	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   12961: pop
    //   12962: aload_1
    //   12963: getfield 3395	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   12966: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   12969: istore 4
    //   12971: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   12974: ifeq +28 -> 13002
    //   12977: ldc_w 3388
    //   12980: iconst_2
    //   12981: iconst_2
    //   12982: anewarray 209	java/lang/Object
    //   12985: dup
    //   12986: iconst_0
    //   12987: ldc_w 3397
    //   12990: aastore
    //   12991: dup
    //   12992: iconst_1
    //   12993: iload 4
    //   12995: invokestatic 245	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   12998: aastore
    //   12999: invokestatic 3155	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   13002: iload 4
    //   13004: iconst_1
    //   13005: if_icmpne -12976 -> 29
    //   13008: aload_1
    //   13009: getfield 3401	tencent/im/oidb/olympic/submsgtype0xb4$MsgBody:msg_body_type	Ltencent/im/oidb/olympic/submsgtype0xb4$BodyType;
    //   13012: astore_1
    //   13013: aload_1
    //   13014: getfield 3407	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   13017: invokevirtual 3410	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:has	()Z
    //   13020: ifeq +59 -> 13079
    //   13023: aload_0
    //   13024: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13027: bipush 94
    //   13029: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13032: checkcast 3412	com/tencent/mobileqq/olympic/OlympicHandler
    //   13035: astore 28
    //   13037: aload 28
    //   13039: ifnull -13010 -> 29
    //   13042: aload 28
    //   13044: aload_1
    //   13045: getfield 3407	tencent/im/oidb/olympic/submsgtype0xb4$BodyType:msg_torchbearer	Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;
    //   13048: invokevirtual 3413	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13051: checkcast 3409	tencent/im/oidb/olympic/torch_transfer$TorchbearerInfo
    //   13054: invokevirtual 3416	com/tencent/mobileqq/olympic/OlympicHandler:a	(Ltencent/im/oidb/olympic/torch_transfer$TorchbearerInfo;)V
    //   13057: aconst_null
    //   13058: areturn
    //   13059: astore_1
    //   13060: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13063: ifeq -13034 -> 29
    //   13066: ldc_w 3388
    //   13069: iconst_2
    //   13070: ldc_w 3418
    //   13073: aload_1
    //   13074: invokestatic 2322	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13077: aconst_null
    //   13078: areturn
    //   13079: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13082: ifeq -13053 -> 29
    //   13085: ldc_w 3388
    //   13088: iconst_2
    //   13089: ldc_w 3420
    //   13092: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13095: aconst_null
    //   13096: areturn
    //   13097: aload 32
    //   13099: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13102: ldc2_w 3421
    //   13105: lcmp
    //   13106: ifne +18 -> 13124
    //   13109: aload_0
    //   13110: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13113: aload 32
    //   13115: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13118: iconst_1
    //   13119: invokestatic 3425	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/QQAppInterface;[BZ)V
    //   13122: aconst_null
    //   13123: areturn
    //   13124: aload 32
    //   13126: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13129: ldc2_w 3426
    //   13132: lcmp
    //   13133: ifne +70 -> 13203
    //   13136: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13139: ifeq +13 -> 13152
    //   13142: ldc_w 3429
    //   13145: iconst_2
    //   13146: ldc_w 3431
    //   13149: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13152: new 3433	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody
    //   13155: dup
    //   13156: invokespecial 3434	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:<init>	()V
    //   13159: astore_1
    //   13160: aload_1
    //   13161: aload 32
    //   13163: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13166: invokevirtual 3435	tencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13169: pop
    //   13170: aload_0
    //   13171: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13174: invokevirtual 3438	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13177: aload_1
    //   13178: invokevirtual 3443	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xc1/submsgtype0xc1$MsgBody;)V
    //   13181: aconst_null
    //   13182: areturn
    //   13183: astore_1
    //   13184: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13187: ifeq -13158 -> 29
    //   13190: ldc_w 3429
    //   13193: iconst_2
    //   13194: ldc_w 3445
    //   13197: aload_1
    //   13198: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13201: aconst_null
    //   13202: areturn
    //   13203: aload 32
    //   13205: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13208: ldc2_w 3446
    //   13211: lcmp
    //   13212: ifne +166 -> 13378
    //   13215: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13218: ifeq +13 -> 13231
    //   13221: ldc_w 3449
    //   13224: iconst_2
    //   13225: ldc_w 3451
    //   13228: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13231: new 3453	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody
    //   13234: dup
    //   13235: invokespecial 3454	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:<init>	()V
    //   13238: astore_1
    //   13239: aload_1
    //   13240: aload 32
    //   13242: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13245: invokevirtual 3455	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13248: pop
    //   13249: aload_0
    //   13250: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13253: invokevirtual 3438	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13256: aload_1
    //   13257: invokevirtual 3458	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody;)V
    //   13260: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13263: ifeq -13234 -> 29
    //   13266: aload_1
    //   13267: getfield 3461	tencent/im/s2c/msgtype0x210/submsgtype0xe9/SubMsgType0xe9$MsgBody:bytes_business	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   13270: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   13273: invokevirtual 219	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   13276: astore_1
    //   13277: ldc_w 3449
    //   13280: iconst_2
    //   13281: new 88	java/lang/StringBuilder
    //   13284: dup
    //   13285: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13288: ldc_w 3463
    //   13291: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13294: aload_1
    //   13295: arraylength
    //   13296: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13299: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13302: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13305: ldc_w 3449
    //   13308: iconst_2
    //   13309: new 88	java/lang/StringBuilder
    //   13312: dup
    //   13313: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13316: ldc_w 3465
    //   13319: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13322: aload_1
    //   13323: arraylength
    //   13324: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13327: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13330: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13333: aconst_null
    //   13334: areturn
    //   13335: astore_1
    //   13336: aload_1
    //   13337: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   13340: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13343: ifeq -13314 -> 29
    //   13346: ldc_w 3449
    //   13349: iconst_2
    //   13350: new 88	java/lang/StringBuilder
    //   13353: dup
    //   13354: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   13357: ldc_w 3467
    //   13360: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13363: aload_1
    //   13364: invokevirtual 3470	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   13367: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13370: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   13373: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13376: aconst_null
    //   13377: areturn
    //   13378: aload 32
    //   13380: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13383: ldc2_w 3471
    //   13386: lcmp
    //   13387: ifne +92 -> 13479
    //   13390: aload 32
    //   13392: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13395: ifnull +84 -> 13479
    //   13398: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13401: ifeq +13 -> 13414
    //   13404: ldc_w 3474
    //   13407: iconst_2
    //   13408: ldc_w 3476
    //   13411: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   13414: aload_1
    //   13415: getfield 1025	OnlinePushPack/MsgInfo:lFromUin	J
    //   13418: lstore_2
    //   13419: aload_1
    //   13420: getfield 1047	OnlinePushPack/MsgInfo:shMsgSeq	S
    //   13423: istore 4
    //   13425: aload_1
    //   13426: getfield 1077	OnlinePushPack/MsgInfo:lMsgUid	J
    //   13429: lstore 15
    //   13431: aload_1
    //   13432: getfield 1022	OnlinePushPack/MsgInfo:shMsgType	S
    //   13435: istore 5
    //   13437: new 3478	com/tencent/mobileqq/app/message/HotReactivePushMsg
    //   13440: dup
    //   13441: lload_2
    //   13442: iload 4
    //   13444: i2l
    //   13445: lload 15
    //   13447: iload 5
    //   13449: invokespecial 3481	com/tencent/mobileqq/app/message/HotReactivePushMsg:<init>	(JJJI)V
    //   13452: astore_1
    //   13453: aload_0
    //   13454: aload 32
    //   13456: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13459: aload_1
    //   13460: invokevirtual 3484	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BLcom/tencent/mobileqq/app/message/HotReactivePushMsg;)V
    //   13463: aload_0
    //   13464: getfield 1332	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppMessageHandler	Lcom/tencent/mobileqq/app/MessageHandler;
    //   13467: lload_2
    //   13468: iload 4
    //   13470: lload 15
    //   13472: iload 5
    //   13474: invokestatic 1778	com/tencent/mobileqq/service/message/MessageProtoCodec:a	(Lcom/tencent/mobileqq/app/MessageHandler;JIJI)V
    //   13477: aconst_null
    //   13478: areturn
    //   13479: aload 32
    //   13481: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13484: ldc2_w 3485
    //   13487: lcmp
    //   13488: ifne +19 -> 13507
    //   13491: aload_0
    //   13492: aload 32
    //   13494: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13497: aload_1
    //   13498: getfield 1070	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13501: i2l
    //   13502: invokevirtual 3489	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BJ)V
    //   13505: aconst_null
    //   13506: areturn
    //   13507: aload 32
    //   13509: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13512: ldc2_w 3490
    //   13515: lcmp
    //   13516: ifne +19 -> 13535
    //   13519: aload_0
    //   13520: aload 32
    //   13522: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13525: aload_1
    //   13526: getfield 1070	OnlinePushPack/MsgInfo:uRealMsgTime	I
    //   13529: i2l
    //   13530: invokevirtual 3493	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:b	([BJ)V
    //   13533: aconst_null
    //   13534: areturn
    //   13535: aload 32
    //   13537: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13540: ldc2_w 3494
    //   13543: lcmp
    //   13544: ifne +16 -> 13560
    //   13547: aload_0
    //   13548: aload 32
    //   13550: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13553: iconst_1
    //   13554: aload_1
    //   13555: invokevirtual 3498	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BILOnlinePushPack/MsgInfo;)V
    //   13558: aconst_null
    //   13559: areturn
    //   13560: aload 32
    //   13562: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13565: ldc2_w 3499
    //   13568: lcmp
    //   13569: ifne +70 -> 13639
    //   13572: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13575: ifeq +13 -> 13588
    //   13578: ldc_w 3502
    //   13581: iconst_2
    //   13582: ldc_w 3504
    //   13585: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13588: aload_0
    //   13589: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13592: bipush 34
    //   13594: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13597: checkcast 3506	com/tencent/mobileqq/app/SecSvcHandler
    //   13600: astore_1
    //   13601: aload_1
    //   13602: ifnull +19 -> 13621
    //   13605: aload_1
    //   13606: aload 32
    //   13608: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13611: aload 32
    //   13613: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13616: invokevirtual 3507	com/tencent/mobileqq/app/SecSvcHandler:a	(J[B)V
    //   13619: aconst_null
    //   13620: areturn
    //   13621: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13624: ifeq -13595 -> 29
    //   13627: ldc_w 3502
    //   13630: iconst_2
    //   13631: ldc_w 3509
    //   13634: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13637: aconst_null
    //   13638: areturn
    //   13639: aload 32
    //   13641: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13644: ldc2_w 3510
    //   13647: lcmp
    //   13648: ifne +15 -> 13663
    //   13651: aload_0
    //   13652: aload 32
    //   13654: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13657: aload_1
    //   13658: invokevirtual 3514	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:a	([BLOnlinePushPack/MsgInfo;)V
    //   13661: aconst_null
    //   13662: areturn
    //   13663: aload 32
    //   13665: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13668: ldc2_w 3515
    //   13671: lcmp
    //   13672: ifne +25 -> 13697
    //   13675: aload_0
    //   13676: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13679: bipush 98
    //   13681: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13684: checkcast 3518	com/tencent/biz/qqstory/base/QQStoryHandler
    //   13687: aload 32
    //   13689: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13692: invokevirtual 3519	com/tencent/biz/qqstory/base/QQStoryHandler:a	([B)V
    //   13695: aconst_null
    //   13696: areturn
    //   13697: aload 32
    //   13699: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13702: ldc2_w 3520
    //   13705: lcmp
    //   13706: ifne +70 -> 13776
    //   13709: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13712: ifeq +13 -> 13725
    //   13715: ldc_w 3429
    //   13718: iconst_2
    //   13719: ldc_w 3523
    //   13722: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13725: new 3525	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody
    //   13728: dup
    //   13729: invokespecial 3526	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:<init>	()V
    //   13732: astore_1
    //   13733: aload_1
    //   13734: aload 32
    //   13736: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13739: invokevirtual 3527	tencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13742: pop
    //   13743: aload_0
    //   13744: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13747: invokevirtual 3438	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13750: aload_1
    //   13751: invokevirtual 3530	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xcf/submsgtype0xcf$MsgBody;)V
    //   13754: aconst_null
    //   13755: areturn
    //   13756: astore_1
    //   13757: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13760: ifeq -13731 -> 29
    //   13763: ldc_w 3429
    //   13766: iconst_2
    //   13767: ldc_w 3532
    //   13770: aload_1
    //   13771: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   13774: aconst_null
    //   13775: areturn
    //   13776: aload 32
    //   13778: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13781: ldc2_w 3533
    //   13784: lcmp
    //   13785: ifne +25 -> 13810
    //   13788: aload_0
    //   13789: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13792: bipush 98
    //   13794: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13797: checkcast 3518	com/tencent/biz/qqstory/base/QQStoryHandler
    //   13800: aload 32
    //   13802: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13805: invokevirtual 3535	com/tencent/biz/qqstory/base/QQStoryHandler:b	([B)V
    //   13808: aconst_null
    //   13809: areturn
    //   13810: aload 32
    //   13812: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13815: ldc2_w 3536
    //   13818: lcmp
    //   13819: ifne +25 -> 13844
    //   13822: aload_0
    //   13823: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13826: bipush 98
    //   13828: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13831: checkcast 3518	com/tencent/biz/qqstory/base/QQStoryHandler
    //   13834: aload 32
    //   13836: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13839: invokevirtual 3538	com/tencent/biz/qqstory/base/QQStoryHandler:c	([B)V
    //   13842: aconst_null
    //   13843: areturn
    //   13844: aload 32
    //   13846: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13849: ldc2_w 3539
    //   13852: lcmp
    //   13853: ifne +42 -> 13895
    //   13856: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13859: ifeq +13 -> 13872
    //   13862: ldc_w 468
    //   13865: iconst_2
    //   13866: ldc_w 3542
    //   13869: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   13872: aload_0
    //   13873: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13876: sipush 201
    //   13879: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   13882: checkcast 3544	com/tencent/mobileqq/data/MsgBoxInterFollowManager
    //   13885: aload 32
    //   13887: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13890: invokevirtual 3547	com/tencent/mobileqq/data/MsgBoxInterFollowManager:decode0xd7InteractAndFollowMsg	([B)V
    //   13893: aconst_null
    //   13894: areturn
    //   13895: aload 32
    //   13897: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13900: ldc2_w 3548
    //   13903: lcmp
    //   13904: ifne +25 -> 13929
    //   13907: aload_0
    //   13908: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13911: bipush 107
    //   13913: invokevirtual 179	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   13916: checkcast 3551	com/tencent/mobileqq/werewolves/WerewolvesHandler
    //   13919: aload 32
    //   13921: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13924: invokevirtual 3552	com/tencent/mobileqq/werewolves/WerewolvesHandler:a	([B)V
    //   13927: aconst_null
    //   13928: areturn
    //   13929: aload 32
    //   13931: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   13934: ldc2_w 3553
    //   13937: lcmp
    //   13938: ifne +70 -> 14008
    //   13941: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13944: ifeq +13 -> 13957
    //   13947: ldc_w 3556
    //   13950: iconst_2
    //   13951: ldc_w 3558
    //   13954: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   13957: new 3560	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody
    //   13960: dup
    //   13961: invokespecial 3561	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:<init>	()V
    //   13964: astore_1
    //   13965: aload_1
    //   13966: aload 32
    //   13968: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   13971: invokevirtual 3562	tencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   13974: pop
    //   13975: aload_0
    //   13976: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13979: invokevirtual 3438	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/QQGAudioMsgHandler;
    //   13982: aload_1
    //   13983: invokevirtual 3565	com/tencent/mobileqq/app/QQGAudioMsgHandler:a	(Ltencent/im/s2c/msgtype0x210/submsgtype0xdb/submsgtype0xdb$MsgBody;)V
    //   13986: aconst_null
    //   13987: areturn
    //   13988: astore_1
    //   13989: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   13992: ifeq -13963 -> 29
    //   13995: ldc_w 3556
    //   13998: iconst_2
    //   13999: ldc_w 3567
    //   14002: aload_1
    //   14003: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14006: aconst_null
    //   14007: areturn
    //   14008: aload 32
    //   14010: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14013: ldc2_w 3568
    //   14016: lcmp
    //   14017: ifne +21 -> 14038
    //   14020: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14023: ifeq -13994 -> 29
    //   14026: ldc_w 468
    //   14029: iconst_2
    //   14030: ldc_w 3571
    //   14033: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14036: aconst_null
    //   14037: areturn
    //   14038: aload 32
    //   14040: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14043: ldc2_w 3572
    //   14046: lcmp
    //   14047: ifne +21 -> 14068
    //   14050: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14053: ifeq -14024 -> 29
    //   14056: ldc_w 468
    //   14059: iconst_2
    //   14060: ldc_w 3575
    //   14063: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14066: aconst_null
    //   14067: areturn
    //   14068: aload 32
    //   14070: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14073: ldc2_w 3576
    //   14076: lcmp
    //   14077: ifne +219 -> 14296
    //   14080: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14083: ifeq +13 -> 14096
    //   14086: ldc_w 3579
    //   14089: iconst_2
    //   14090: ldc_w 3581
    //   14093: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14096: new 3583	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody
    //   14099: dup
    //   14100: invokespecial 3584	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:<init>	()V
    //   14103: astore_1
    //   14104: aload_1
    //   14105: aload 32
    //   14107: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14110: invokevirtual 3585	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14113: pop
    //   14114: aload_1
    //   14115: getfield 3589	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14118: invokevirtual 3592	tencent/im/apollo_game_status$STCMGameMessage:has	()Z
    //   14121: ifeq -14092 -> 29
    //   14124: aload_1
    //   14125: getfield 3589	tencent/im/s2c/msgtype0x210/submsgtype0xdf/submsgtype0xdf$MsgBody:msg_game_state	Ltencent/im/apollo_game_status$STCMGameMessage;
    //   14128: invokevirtual 3593	tencent/im/apollo_game_status$STCMGameMessage:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14131: checkcast 3591	tencent/im/apollo_game_status$STCMGameMessage
    //   14134: astore_1
    //   14135: aload_1
    //   14136: getfield 3597	tencent/im/apollo_game_status$STCMGameMessage:msg_comm	Ltencent/im/apollo_game_status$STCMGameMessage$STMsgComm;
    //   14139: invokevirtual 3600	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14142: checkcast 3599	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm
    //   14145: astore 29
    //   14147: aload 29
    //   14149: getfield 3603	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:uint32_session_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   14152: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   14155: invokestatic 3606	com/tencent/mobileqq/util/Utils:a	(I)J
    //   14158: lstore 15
    //   14160: aload_0
    //   14161: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14164: sipush 210
    //   14167: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14170: checkcast 3608	com/tencent/mobileqq/apollo/ApolloGameManager
    //   14173: astore 28
    //   14175: lload_2
    //   14176: lload 15
    //   14178: lcmp
    //   14179: ifne +102 -> 14281
    //   14182: aload 29
    //   14184: getfield 3611	tencent/im/apollo_game_status$STCMGameMessage$STMsgComm:rpt_uint32_session_list	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   14187: invokevirtual 1718	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   14190: astore 29
    //   14192: aload 29
    //   14194: ifnull -14165 -> 29
    //   14197: aload 29
    //   14199: invokeinterface 873 1 0
    //   14204: ifle -14175 -> 29
    //   14207: aload 29
    //   14209: invokeinterface 51 1 0
    //   14214: astore 29
    //   14216: aload 29
    //   14218: invokeinterface 56 1 0
    //   14223: ifeq -14194 -> 29
    //   14226: aload 29
    //   14228: invokeinterface 60 1 0
    //   14233: checkcast 241	java/lang/Integer
    //   14236: invokevirtual 3614	java/lang/Integer:intValue	()I
    //   14239: invokestatic 3606	com/tencent/mobileqq/util/Utils:a	(I)J
    //   14242: lstore 15
    //   14244: lload 15
    //   14246: lload_2
    //   14247: lcmp
    //   14248: ifeq -32 -> 14216
    //   14251: aload 28
    //   14253: iconst_0
    //   14254: iconst_0
    //   14255: lload 15
    //   14257: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14260: aload_1
    //   14261: invokevirtual 3617	com/tencent/mobileqq/apollo/ApolloGameManager:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14264: goto -48 -> 14216
    //   14267: astore_1
    //   14268: ldc_w 3579
    //   14271: iconst_1
    //   14272: ldc_w 3619
    //   14275: aload_1
    //   14276: invokestatic 1513	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   14279: aconst_null
    //   14280: areturn
    //   14281: aload 28
    //   14283: iconst_0
    //   14284: iconst_0
    //   14285: lload 15
    //   14287: invokestatic 123	java/lang/Long:toString	(J)Ljava/lang/String;
    //   14290: aload_1
    //   14291: invokevirtual 3617	com/tencent/mobileqq/apollo/ApolloGameManager:a	(IILjava/lang/String;Ltencent/im/apollo_game_status$STCMGameMessage;)V
    //   14294: aconst_null
    //   14295: areturn
    //   14296: aload 32
    //   14298: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14301: ldc2_w 3620
    //   14304: lcmp
    //   14305: ifne +132 -> 14437
    //   14308: ldc_w 3623
    //   14311: iconst_1
    //   14312: ldc_w 3625
    //   14315: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14318: new 3627	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody
    //   14321: dup
    //   14322: invokespecial 3628	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:<init>	()V
    //   14325: astore_1
    //   14326: aload_1
    //   14327: aload 32
    //   14329: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14332: invokevirtual 3629	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14335: pop
    //   14336: aload_1
    //   14337: getfield 3633	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14340: invokevirtual 3636	tencent/im/apollo_push_msgInfo$STPushMsgElem:has	()Z
    //   14343: ifeq -14314 -> 29
    //   14346: aload_1
    //   14347: getfield 3633	tencent/im/s2c/msgtype0x210/submsgtype0xe8/submsgtype0xe8$MsgBody:msg_item	Ltencent/im/apollo_push_msgInfo$STPushMsgElem;
    //   14350: invokevirtual 3637	tencent/im/apollo_push_msgInfo$STPushMsgElem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14353: checkcast 3635	tencent/im/apollo_push_msgInfo$STPushMsgElem
    //   14356: astore_1
    //   14357: aload_0
    //   14358: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14361: ifnull -14332 -> 29
    //   14364: aload_0
    //   14365: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14368: sipush 226
    //   14371: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14374: checkcast 3639	com/tencent/mobileqq/apollo/ApolloPushManager
    //   14377: astore 28
    //   14379: aload 28
    //   14381: iconst_0
    //   14382: aload_1
    //   14383: invokevirtual 3642	com/tencent/mobileqq/apollo/ApolloPushManager:a	(ILtencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14386: aload 28
    //   14388: aload_1
    //   14389: invokevirtual 3645	com/tencent/mobileqq/apollo/ApolloPushManager:b	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14392: aload 28
    //   14394: aload_1
    //   14395: invokevirtual 3647	com/tencent/mobileqq/apollo/ApolloPushManager:a	(Ltencent/im/apollo_push_msgInfo$STPushMsgElem;)V
    //   14398: aconst_null
    //   14399: areturn
    //   14400: astore_1
    //   14401: aload_1
    //   14402: invokevirtual 1178	java/lang/Exception:printStackTrace	()V
    //   14405: ldc_w 3623
    //   14408: iconst_1
    //   14409: new 88	java/lang/StringBuilder
    //   14412: dup
    //   14413: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14416: ldc_w 3649
    //   14419: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14422: aload_1
    //   14423: invokevirtual 3470	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14426: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14429: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14432: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14435: aconst_null
    //   14436: areturn
    //   14437: aload 32
    //   14439: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14442: ldc2_w 3650
    //   14445: lcmp
    //   14446: ifne +88 -> 14534
    //   14449: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14452: ifeq +13 -> 14465
    //   14455: ldc_w 468
    //   14458: iconst_2
    //   14459: ldc_w 3653
    //   14462: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14465: new 3655	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody
    //   14468: dup
    //   14469: invokespecial 3656	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:<init>	()V
    //   14472: astore_1
    //   14473: aload 32
    //   14475: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14478: ifnull +13 -> 14491
    //   14481: aload_1
    //   14482: aload 32
    //   14484: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14487: invokevirtual 3657	tencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14490: pop
    //   14491: aload_0
    //   14492: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14495: aload_1
    //   14496: invokestatic 3660	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ltencent/im/c2c/msgtype0x210/submsgtype0xeb/submsgtype0xeb$MsgBody;)V
    //   14499: aconst_null
    //   14500: areturn
    //   14501: astore_1
    //   14502: ldc_w 468
    //   14505: iconst_1
    //   14506: new 88	java/lang/StringBuilder
    //   14509: dup
    //   14510: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14513: ldc_w 3662
    //   14516: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14519: aload_1
    //   14520: invokevirtual 3470	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   14523: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14526: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14529: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14532: aconst_null
    //   14533: areturn
    //   14534: aload 32
    //   14536: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14539: ldc2_w 3663
    //   14542: lcmp
    //   14543: ifne +195 -> 14738
    //   14546: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14549: ifeq +13 -> 14562
    //   14552: ldc_w 468
    //   14555: iconst_2
    //   14556: ldc_w 3666
    //   14559: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14562: aload 32
    //   14564: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14567: arraylength
    //   14568: istore 4
    //   14570: iload 4
    //   14572: bipush 6
    //   14574: if_icmpge +33 -> 14607
    //   14577: ldc_w 468
    //   14580: iconst_2
    //   14581: new 88	java/lang/StringBuilder
    //   14584: dup
    //   14585: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14588: ldc_w 3668
    //   14591: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14594: iload 4
    //   14596: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14599: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14602: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14605: aconst_null
    //   14606: areturn
    //   14607: aload 32
    //   14609: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14612: iconst_0
    //   14613: baload
    //   14614: iconst_4
    //   14615: ishl
    //   14616: aload 32
    //   14618: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14621: iconst_1
    //   14622: baload
    //   14623: iadd
    //   14624: istore 5
    //   14626: iconst_4
    //   14627: newarray byte
    //   14629: astore_1
    //   14630: aload 32
    //   14632: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14635: iconst_2
    //   14636: aload_1
    //   14637: iconst_0
    //   14638: iconst_4
    //   14639: invokestatic 3672	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14642: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14645: ifeq +31 -> 14676
    //   14648: ldc_w 468
    //   14651: iconst_2
    //   14652: new 88	java/lang/StringBuilder
    //   14655: dup
    //   14656: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14659: ldc_w 3674
    //   14662: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14665: iload 5
    //   14667: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   14670: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14673: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14676: invokestatic 3680	com/tencent/mobileqq/app/ThreadManager:getUIHandler	()Lmqq/os/MqqHandler;
    //   14679: new 3682	zqk
    //   14682: dup
    //   14683: aload_0
    //   14684: iload 5
    //   14686: invokespecial 3685	zqk:<init>	(Lcom/tencent/mobileqq/app/message/OnLinePushMessageProcessor;I)V
    //   14689: invokevirtual 3689	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   14692: pop
    //   14693: iload 4
    //   14695: bipush 6
    //   14697: if_icmple -14668 -> 29
    //   14700: iload 4
    //   14702: bipush 6
    //   14704: isub
    //   14705: newarray byte
    //   14707: astore 28
    //   14709: aload 32
    //   14711: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14714: bipush 6
    //   14716: aload 28
    //   14718: iconst_0
    //   14719: iload 4
    //   14721: bipush 6
    //   14723: isub
    //   14724: invokestatic 3672	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   14727: iload 5
    //   14729: aload_1
    //   14730: aload 28
    //   14732: invokestatic 3694	com/tencent/mobileqq/app/utils/LinkStarDebugProcessor:a	(I[B[B)Z
    //   14735: pop
    //   14736: aconst_null
    //   14737: areturn
    //   14738: aload 32
    //   14740: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14743: ldc2_w 3695
    //   14746: lcmp
    //   14747: ifne +111 -> 14858
    //   14750: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14753: ifeq +13 -> 14766
    //   14756: ldc_w 468
    //   14759: iconst_2
    //   14760: ldc_w 3698
    //   14763: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14766: aload_0
    //   14767: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14770: sipush 251
    //   14773: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14776: checkcast 3700	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryNodeConfigManager
    //   14779: getfield 3701	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryNodeConfigManager:jdField_a_of_type_Boolean	Z
    //   14782: ifeq -14753 -> 29
    //   14785: new 3703	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify
    //   14788: dup
    //   14789: invokespecial 3704	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:<init>	()V
    //   14792: astore_1
    //   14793: aload_1
    //   14794: aload 32
    //   14796: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14799: invokevirtual 3705	com/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14802: pop
    //   14803: aload_0
    //   14804: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   14807: sipush 250
    //   14810: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   14813: checkcast 3707	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryManager
    //   14816: invokevirtual 3710	com/tencent/biz/qqstory/msgTabNode/model/MsgTabStoryManager:a	()Lcom/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeListLoader;
    //   14819: aload_1
    //   14820: invokevirtual 3715	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeListLoader:a	(Lcom/tencent/biz/qqstory/network/pb/qqstory_service$MsgTabNodePushNotify;)V
    //   14823: aconst_null
    //   14824: areturn
    //   14825: astore_1
    //   14826: ldc_w 468
    //   14829: iconst_1
    //   14830: new 88	java/lang/StringBuilder
    //   14833: dup
    //   14834: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14837: ldc_w 3717
    //   14840: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14843: aload_1
    //   14844: invokevirtual 3718	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   14847: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14850: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14853: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   14856: aconst_null
    //   14857: areturn
    //   14858: aload 32
    //   14860: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14863: ldc2_w 3719
    //   14866: lcmp
    //   14867: ifne +42 -> 14909
    //   14870: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14873: ifeq -14844 -> 29
    //   14876: ldc_w 468
    //   14879: iconst_2
    //   14880: new 88	java/lang/StringBuilder
    //   14883: dup
    //   14884: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   14887: ldc_w 3722
    //   14890: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14893: aload 32
    //   14895: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14898: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   14901: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   14904: invokestatic 708	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   14907: aconst_null
    //   14908: areturn
    //   14909: aload 32
    //   14911: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   14914: ldc2_w 3723
    //   14917: lcmp
    //   14918: ifne -14889 -> 29
    //   14921: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14924: ifeq +13 -> 14937
    //   14927: ldc_w 468
    //   14930: iconst_2
    //   14931: ldc_w 3726
    //   14934: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14937: new 3728	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody
    //   14940: dup
    //   14941: invokespecial 3729	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:<init>	()V
    //   14944: astore_1
    //   14945: aload 32
    //   14947: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14950: ifnull -14921 -> 29
    //   14953: aload_1
    //   14954: aload 32
    //   14956: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   14959: invokevirtual 3730	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   14962: pop
    //   14963: aload_1
    //   14964: getfield 3733	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$MsgBody:rpt_now_push_msg	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   14967: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   14970: invokeinterface 51 1 0
    //   14975: astore_1
    //   14976: aload_1
    //   14977: invokeinterface 56 1 0
    //   14982: ifeq -14953 -> 29
    //   14985: aload_1
    //   14986: invokeinterface 60 1 0
    //   14991: checkcast 3735	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg
    //   14994: astore 28
    //   14996: aload_0
    //   14997: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15000: sipush 265
    //   15003: invokevirtual 160	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   15006: checkcast 3737	com/tencent/mobileqq/now/enter/NowHongbaoPushManager
    //   15009: aload 28
    //   15011: invokevirtual 3740	com/tencent/mobileqq/now/enter/NowHongbaoPushManager:a	(Lcom/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg;)V
    //   15014: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15017: ifeq -41 -> 14976
    //   15020: ldc_w 468
    //   15023: iconst_2
    //   15024: new 88	java/lang/StringBuilder
    //   15027: dup
    //   15028: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15031: ldc_w 3742
    //   15034: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15037: aload 28
    //   15039: getfield 3745	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15042: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15045: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15048: ldc_w 3747
    //   15051: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15054: aload 28
    //   15056: getfield 3748	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_task_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15059: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15062: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15065: ldc_w 3750
    //   15068: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15071: aload 28
    //   15073: getfield 3751	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   15076: invokevirtual 79	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   15079: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15082: ldc_w 3753
    //   15085: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15088: aload 28
    //   15090: getfield 3756	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_start_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15093: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15096: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15099: ldc_w 3758
    //   15102: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15105: aload 28
    //   15107: getfield 3761	com/tencent/mobileqq/now/enter/pb/NowPushMsgList$NowPushMsg:uint64_end_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   15110: invokevirtual 36	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   15113: invokevirtual 138	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   15116: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15119: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15122: goto -146 -> 14976
    //   15125: astore_1
    //   15126: ldc_w 468
    //   15129: iconst_1
    //   15130: new 88	java/lang/StringBuilder
    //   15133: dup
    //   15134: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15137: ldc_w 3763
    //   15140: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15143: aload_1
    //   15144: invokevirtual 3470	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   15147: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15150: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15153: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15156: aconst_null
    //   15157: areturn
    //   15158: aload 32
    //   15160: getfield 1432	IMMsgBodyPack/MsgType0x210:uSubMsgType	J
    //   15163: ldc2_w 3764
    //   15166: lcmp
    //   15167: ifne -15138 -> 29
    //   15170: invokestatic 84	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   15173: ifeq +13 -> 15186
    //   15176: ldc_w 468
    //   15179: iconst_2
    //   15180: ldc_w 3767
    //   15183: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15186: new 3769	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody
    //   15189: dup
    //   15190: invokespecial 3770	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:<init>	()V
    //   15193: astore 28
    //   15195: aload 32
    //   15197: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15200: ifnull -15171 -> 29
    //   15203: aload 28
    //   15205: aload 32
    //   15207: getfield 1463	IMMsgBodyPack/MsgType0x210:vProtobuf	[B
    //   15210: invokevirtual 3771	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   15213: pop
    //   15214: aload 28
    //   15216: getfield 3772	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15219: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   15222: ifeq +87 -> 15309
    //   15225: aload 28
    //   15227: getfield 3772	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_title	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15230: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   15233: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   15236: astore_1
    //   15237: aload 28
    //   15239: getfield 3775	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15242: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   15245: ifeq +70 -> 15315
    //   15248: aload 28
    //   15250: getfield 3775	tencent/im/s2c/msgtype0x210/submsgtype0xea/submsgtype0xea$MsgBody:bytes_content	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   15253: invokevirtual 111	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   15256: invokevirtual 116	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   15259: astore 28
    //   15261: invokestatic 3780	com/tencent/mobileqq/ark/ArkTipsManager:a	()Lcom/tencent/mobileqq/ark/ArkTipsManager;
    //   15264: aload_0
    //   15265: getfield 154	com/tencent/mobileqq/app/message/OnLinePushMessageProcessor:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   15268: aload_1
    //   15269: aload 28
    //   15271: invokevirtual 3782	com/tencent/mobileqq/ark/ArkTipsManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)V
    //   15274: aconst_null
    //   15275: areturn
    //   15276: astore_1
    //   15277: ldc_w 468
    //   15280: iconst_1
    //   15281: new 88	java/lang/StringBuilder
    //   15284: dup
    //   15285: invokespecial 91	java/lang/StringBuilder:<init>	()V
    //   15288: ldc_w 3784
    //   15291: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15294: aload_1
    //   15295: invokevirtual 3470	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   15298: invokevirtual 97	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15301: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   15304: invokestatic 1581	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   15307: aconst_null
    //   15308: areturn
    //   15309: ldc 140
    //   15311: astore_1
    //   15312: goto -75 -> 15237
    //   15315: ldc 140
    //   15317: astore 28
    //   15319: goto -58 -> 15261
    //   15322: astore 28
    //   15324: goto -4778 -> 10546
    //   15327: astore_1
    //   15328: goto -6337 -> 8991
    //   15331: astore 30
    //   15333: goto -11745 -> 3588
    //   15336: astore 30
    //   15338: goto -11750 -> 3588
    //   15341: iconst_0
    //   15342: istore 19
    //   15344: goto -4554 -> 10790
    //   15347: iload 21
    //   15349: istore 24
    //   15351: iload 22
    //   15353: istore 25
    //   15355: iload 20
    //   15357: istore 26
    //   15359: iload 19
    //   15361: istore 27
    //   15363: goto -5737 -> 9626
    //   15366: goto -5924 -> 9442
    //   15369: aconst_null
    //   15370: astore_1
    //   15371: goto -8094 -> 7277
    //   15374: iconst_0
    //   15375: istore 6
    //   15377: goto -11046 -> 4331
    //   15380: iconst_0
    //   15381: istore 5
    //   15383: goto -11073 -> 4310
    //   15386: aconst_null
    //   15387: astore 30
    //   15389: goto -11904 -> 3485
    //   15392: aconst_null
    //   15393: astore 29
    //   15395: goto -11944 -> 3451
    //   15398: aconst_null
    //   15399: astore 28
    //   15401: goto -11988 -> 3413
    //   15404: iload 7
    //   15406: ifge -10959 -> 4447
    //   15409: iload 8
    //   15411: iflt -10930 -> 4481
    //   15414: goto -10967 -> 4447
    //   15417: iload 5
    //   15419: ifne -10895 -> 4524
    //   15422: iload 6
    //   15424: ifeq -11278 -> 4146
    //   15427: goto -10903 -> 4524
    //   15430: aload 29
    //   15432: astore 28
    //   15434: iload 5
    //   15436: istore 4
    //   15438: goto -7854 -> 7584
    //   15441: aload 30
    //   15443: areturn
    //   15444: sipush 1001
    //   15447: istore 4
    //   15449: aload 29
    //   15451: astore 28
    //   15453: goto -7869 -> 7584
    //   15456: goto -6840 -> 8616
    //   15459: iconst_0
    //   15460: istore 4
    //   15462: iload 5
    //   15464: iconst_3
    //   15465: if_icmpne -3943 -> 11522
    //   15468: iconst_0
    //   15469: istore 4
    //   15471: goto -4048 -> 11423
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	15474	0	this	OnLinePushMessageProcessor
    //   0	15474	1	paramMsgInfo	MsgInfo
    //   0	15474	2	paramLong	long
    //   451	15019	4	i	int
    //   712	14754	5	j	int
    //   3963	11460	6	k	int
    //   4332	11073	7	m	int
    //   4335	11075	8	n	int
    //   4387	5554	9	i1	int
    //   9220	787	10	i2	int
    //   9789	63	11	i3	int
    //   9802	57	12	i4	int
    //   9815	54	13	i5	int
    //   9825	41	14	i6	int
    //   2343	11943	15	l1	long
    //   5898	83	17	l2	long
    //   193	15167	19	bool1	boolean
    //   9090	6266	20	bool2	boolean
    //   9120	6228	21	bool3	boolean
    //   9060	6292	22	bool4	boolean
    //   9075	1333	23	bool5	boolean
    //   9529	5821	24	bool6	boolean
    //   9533	5821	25	bool7	boolean
    //   9537	5821	26	bool8	boolean
    //   9541	5821	27	bool9	boolean
    //   108	2210	28	localObject1	Object
    //   2367	1	28	localException1	Exception
    //   2489	315	28	localObject2	Object
    //   2817	26	28	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   3330	295	28	localObject3	Object
    //   3631	3	28	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   3864	7827	28	localObject4	Object
    //   11699	20	28	localException2	Exception
    //   11790	20	28	localException3	Exception
    //   11890	8	28	localTroopTopicMgr	com.tencent.mobileqq.troop.utils.TroopTopicMgr
    //   12151	1	28	localException4	Exception
    //   12191	83	28	localMsgBody	tencent.im.s2c.msgtype0x210.submsgtype0xae.SubMsgType0xae.MsgBody
    //   12773	109	28	localException5	Exception
    //   12895	2423	28	localObject5	Object
    //   15322	1	28	localThrowable	java.lang.Throwable
    //   15399	53	28	localObject6	Object
    //   171	2429	29	localObject7	Object
    //   2610	36	29	localInvalidProtocolBufferMicroException3	InvalidProtocolBufferMicroException
    //   3370	12080	29	localObject8	Object
    //   650	2882	30	localObject9	Object
    //   3586	1	30	localException6	Exception
    //   3598	8739	30	localObject10	Object
    //   15331	1	30	localException7	Exception
    //   15336	1	30	localException8	Exception
    //   15387	55	30	localMessageRecord	MessageRecord
    //   729	12011	31	localObject11	Object
    //   22	15184	32	localObject12	Object
    //   2115	10539	33	localObject13	Object
    //   7879	109	34	localFriendsManager	FriendsManager
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
    //   6147	6241	6384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6241	6307	6384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6313	6382	6384	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6460	6512	6514	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6603	6638	6666	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6644	6664	6666	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6755	6765	6835	java/lang/Exception
    //   6769	6780	6835	java/lang/Exception
    //   6789	6833	6835	java/lang/Exception
    //   6893	7074	7289	java/lang/Exception
    //   7074	7137	7289	java/lang/Exception
    //   7279	7286	7289	java/lang/Exception
    //   7347	7382	7384	java/lang/Exception
    //   7432	7467	7469	java/lang/Exception
    //   7521	7532	7847	java/lang/Exception
    //   7547	7584	7847	java/lang/Exception
    //   7584	7728	7847	java/lang/Exception
    //   7728	7792	7847	java/lang/Exception
    //   7800	7813	7847	java/lang/Exception
    //   7821	7834	7847	java/lang/Exception
    //   7837	7844	7847	java/lang/Exception
    //   7901	7983	8161	java/lang/Exception
    //   7987	7996	8161	java/lang/Exception
    //   8001	8009	8161	java/lang/Exception
    //   8012	8143	8161	java/lang/Exception
    //   8260	8270	8331	java/lang/Throwable
    //   8411	8431	8433	java/lang/Exception
    //   8498	8510	8512	java/lang/Throwable
    //   8555	8616	8655	java/lang/Exception
    //   8616	8625	8655	java/lang/Exception
    //   8625	8653	8655	java/lang/Exception
    //   8674	8683	8655	java/lang/Exception
    //   8686	8695	8655	java/lang/Exception
    //   8698	8707	8655	java/lang/Exception
    //   8746	8796	8943	java/lang/Exception
    //   8796	8826	8943	java/lang/Exception
    //   8836	8876	8943	java/lang/Exception
    //   8884	8914	8943	java/lang/Exception
    //   8914	8941	8943	java/lang/Exception
    //   10601	10620	10654	java/lang/Exception
    //   10848	10859	11164	java/lang/Exception
    //   10859	10882	11164	java/lang/Exception
    //   10882	10906	11164	java/lang/Exception
    //   10906	10930	11164	java/lang/Exception
    //   10930	11008	11164	java/lang/Exception
    //   11008	11162	11164	java/lang/Exception
    //   10692	10713	11187	java/lang/Exception
    //   10717	10777	11187	java/lang/Exception
    //   10777	10786	11187	java/lang/Exception
    //   10790	10811	11211	java/lang/Exception
    //   11303	11420	11503	java/lang/Exception
    //   11423	11501	11503	java/lang/Exception
    //   11556	11575	11609	java/lang/Exception
    //   11652	11662	11699	java/lang/Exception
    //   11761	11771	11790	java/lang/Exception
    //   11860	11892	11925	java/lang/Exception
    //   11897	11923	11925	java/lang/Exception
    //   11973	12007	12009	java/lang/Exception
    //   12049	12064	12066	java/lang/Exception
    //   12121	12131	12151	java/lang/Exception
    //   12193	12273	12773	java/lang/Exception
    //   12273	12286	12773	java/lang/Exception
    //   12291	12326	12773	java/lang/Exception
    //   12326	12384	12773	java/lang/Exception
    //   12384	12418	12773	java/lang/Exception
    //   12418	12443	12773	java/lang/Exception
    //   12443	12468	12773	java/lang/Exception
    //   12468	12502	12773	java/lang/Exception
    //   12502	12529	12773	java/lang/Exception
    //   12529	12563	12773	java/lang/Exception
    //   12563	12587	12773	java/lang/Exception
    //   12587	12611	12773	java/lang/Exception
    //   12616	12640	12773	java/lang/Exception
    //   12640	12664	12773	java/lang/Exception
    //   12664	12698	12773	java/lang/Exception
    //   12698	12722	12773	java/lang/Exception
    //   12722	12756	12773	java/lang/Exception
    //   12756	12770	12773	java/lang/Exception
    //   12830	12867	12773	java/lang/Exception
    //   12867	12913	12773	java/lang/Exception
    //   12952	13002	13059	java/lang/Exception
    //   13008	13037	13059	java/lang/Exception
    //   13042	13057	13059	java/lang/Exception
    //   13079	13095	13059	java/lang/Exception
    //   13152	13181	13183	java/lang/Exception
    //   13231	13333	13335	java/lang/Exception
    //   13725	13754	13756	java/lang/Exception
    //   13957	13986	13988	java/lang/Exception
    //   14096	14175	14267	java/lang/Exception
    //   14182	14192	14267	java/lang/Exception
    //   14197	14216	14267	java/lang/Exception
    //   14216	14244	14267	java/lang/Exception
    //   14251	14264	14267	java/lang/Exception
    //   14281	14294	14267	java/lang/Exception
    //   14318	14398	14400	java/lang/Exception
    //   14465	14491	14501	java/lang/Exception
    //   14491	14499	14501	java/lang/Exception
    //   14785	14823	14825	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   14937	14976	15125	java/lang/Exception
    //   14976	15122	15125	java/lang/Exception
    //   15186	15237	15276	java/lang/Exception
    //   15237	15261	15276	java/lang/Exception
    //   15261	15274	15276	java/lang/Exception
    //   10536	10546	15322	java/lang/Throwable
    //   8980	8991	15327	java/lang/Throwable
    //   3413	3447	15331	java/lang/Exception
    //   3451	3485	15336	java/lang/Exception
  }
  
  private zqm b(int paramInt, MsgInfo paramMsgInfo, SvcReqPushMsg paramSvcReqPushMsg)
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getSubAccountKey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), String.valueOf(l1), new zql(this, localSubAccountManager));
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
                    HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437313), true);
                    HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                    ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
                    return;
                  } while (localHotChatInfo == null);
                  localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                  HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437311), true);
                  HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                  ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                  return;
                } while (localHotChatInfo == null);
                localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
                HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437304), true);
                HotChatRecentUserMgr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 6);
                ((HotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(35)).a(1041, true, new Object[] { str, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
                return;
                if (j != 2) {
                  break;
                }
              } while (localHotChatInfo == null);
              localHotChatManager.a(localHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT__LONG_TIME_NOT_SAY);
              HotChatHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localHotChatInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131437310), false);
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
      Bitmap localBitmap = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130839189);
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
      if (SettingCloneUtil.readValue(paramMsgBody, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramMsgBody.getString(2131435387), "qqsetting_lock_screen_whenexit_key", true))
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
                  break label7799;
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
                    localObject3 = localFriendsManager.a(((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get() + "");
                    if (QLog.isColorLevel()) {
                      QLog.d("cardpush", 2, "push a DelGroup  = id:" + ((SubMsgType0x27.DelGroup)localObject1).uint32_groupid.get());
                    }
                    paramArrayOfByte = new DelGroupResp();
                    paramArrayOfByte.dwToUin = Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).longValue();
                    paramArrayOfByte.dwSequence = ((Groups)localObject3).seqid;
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
        localObject3 = ((SubMsgType0x27.ModGroupName)localObject1).bytes_groupname.get().toStringUtf8();
        paramArrayOfByte = localFriendsManager.a(String.valueOf(i));
        if (paramArrayOfByte != null) {}
        for (paramArrayOfByte.group_name = ((String)localObject3);; paramArrayOfByte.group_name = ((String)localObject3))
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
      localObject3 = ((SubMsgType0x27.ModGroupSort)paramArrayOfByte.msg_mod_group_sort.get()).rpt_msg_groupsort.get();
    } while (localObject3 == null);
    paramArrayOfByte = new byte[((List)localObject3).size()];
    localObject1 = new byte[((List)localObject3).size()];
    Object localObject3 = ((List)localObject3).iterator();
    int i = 0;
    label1208:
    Object localObject4;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (SubMsgType0x27.GroupSort)((Iterator)localObject3).next();
      if ((!((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.has()) || (!((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.has())) {
        break label7827;
      }
      paramArrayOfByte[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get());
      localObject1[i] = ((byte)((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      if (QLog.isColorLevel()) {
        QLog.d("cardpush", 2, "push a ModGroupSort  = id:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_groupid.get() + " sortid:" + ((SubMsgType0x27.GroupSort)localObject4).uint32_sortid.get());
      }
      i += 1;
    }
    label1408:
    label7827:
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
        paramArrayOfByte = ((SubMsgType0x27.DelFriend)paramArrayOfByte.msg_del_friend.get()).rpt_uint64_uins.get().iterator();
        for (;;)
        {
          if (!paramArrayOfByte.hasNext()) {
            break label2027;
          }
          l1 = ((Long)paramArrayOfByte.next()).longValue();
          localFriendsManager.d(l1 + "");
          localPublicAccountDataManager.b(l1 + "");
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a DelFriend  = id:" + l1);
          }
          try
          {
            localObject1 = (QidianManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(164);
            if ((localObject1 != null) && (((QidianManager)localObject1).a(l1 + "")))
            {
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(l1), true);
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getBaseContext().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_customer_transfer_sharepreference", 0).edit();
              ((SharedPreferences.Editor)localObject1).putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "_" + l1 + "", false);
              ((SharedPreferences.Editor)localObject1).commit();
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
        }
        label2027:
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
          localObject2 = ((SubMsgType0x27.ModSnsGeneralInfo)paramArrayOfByte.msg_mod_friend_rings.get()).rpt_msg_sns_general_infos.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (SubMsgType0x27.SnsUpateBuffer)((Iterator)localObject2).next();
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
        localObject3 = new HashMap();
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
                localObject2 = (SpecialCareInfo)((HashMap)localObject3).get(localObject5);
                paramArrayOfByte = (byte[])localObject2;
                if (localObject2 == null)
                {
                  localObject2 = localFriendsManager.a(String.valueOf(l1));
                  paramArrayOfByte = (byte[])localObject2;
                  if (localObject2 == null)
                  {
                    paramArrayOfByte = new SpecialCareInfo();
                    paramArrayOfByte.uin = String.valueOf(String.valueOf(l1));
                  }
                  ((HashMap)localObject3).put(paramArrayOfByte.uin, paramArrayOfByte);
                }
                i = ((SubMsgType0x27.SnsUpdateItem)localObject7).uint32_update_sns_type.get();
                localObject2 = ((SubMsgType0x27.SnsUpdateItem)localObject7).bytes_value.get().toStringUtf8();
                FriendListHandler.a(paramArrayOfByte, i, (String)localObject2);
                if (QLog.isColorLevel()) {
                  QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 uin=" + paramArrayOfByte.uin + ", itemtype=" + i + ",itemVal=" + (String)localObject2);
                }
              }
            }
          }
        }
        paramArrayOfByte = ((HashMap)localObject3).entrySet().iterator();
        Object localObject2 = new ArrayList();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (SpecialCareInfo)((Map.Entry)paramArrayOfByte.next()).getValue();
          if ((localObject3 != null) && ((((SpecialCareInfo)localObject3).getStatus() != 1000) || (((SpecialCareInfo)localObject3).globalSwitch != 0))) {
            ((List)localObject2).add(localObject3);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x27 bulkSaveOrUpdateSpecialCareInfos=" + ((List)localObject2).size());
        }
        localFriendsManager.c((List)localObject2);
        if (((List)localObject2).size() <= 0) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(99, true, new Object[] { Boolean.valueOf(true), localObject2 });
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
            localObject2 = (SubMsgType0x27.SnsUpdateOneFlag)paramArrayOfByte.next();
            l1 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject2).uint64__uin.get();
            i = ((SubMsgType0x27.SnsUpdateOneFlag)localObject2).uint32_flag.get();
            l2 = ((SubMsgType0x27.SnsUpdateOneFlag)localObject2).uint64_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("Q.msg.BaseMessageProcessor", 2, "FriendShield : onLinePush : uin : " + l1 + " flag:" + i + " id:" + l2);
            }
          } while (l2 != 4051L);
          localObject2 = localFriendsManager.c(String.valueOf(l1));
        } while (localObject2 == null);
        if (i == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((Friends)localObject2).setShieldFlag(bool);
          localFriendsManager.a((Friends)localObject2);
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
        localObject2 = (SubMsgType0x27.ModCustomFace)paramArrayOfByte.msg_mod_custom_face.get();
        if ((!((SubMsgType0x27.ModCustomFace)localObject2).uint32_type.has()) || (!((SubMsgType0x27.ModCustomFace)localObject2).uint64_uin.has())) {
          break;
        }
        paramArrayOfByte = (FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
        if (((SubMsgType0x27.ModCustomFace)localObject2).uint32_type.get() == 0)
        {
          l1 = ((SubMsgType0x27.ModCustomFace)localObject2).uint64_uin.get();
          localObject2 = Long.toString(l1);
          if (QLog.isColorLevel()) {
            QLog.d("cardpush", 2, "push a ModCustomFace  :0  Normal user uin = " + l1);
          }
          paramArrayOfByte.c((String)localObject2);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, localObject2);
          break;
        }
        if (((SubMsgType0x27.ModCustomFace)localObject2).uint32_type.get() != 1) {
          break;
        }
        l1 = ((SubMsgType0x27.ModCustomFace)localObject2).uint64_group_code.get();
        if (QLog.isColorLevel()) {
          QLog.d("cardpush", 2, "push a ModCustomFace  :1 Troop uin = " + l1);
        }
        localObject2 = localTroopManager.a(String.valueOf(l1));
        ((TroopInfo)localObject2).hasSetNewTroopHead = true;
        localTroopManager.b((TroopInfo)localObject2);
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
        localObject2 = ((SubMsgType0x27.ModFriendRemark)paramArrayOfByte.msg_mod_friend_remark.get()).rpt_msg_frd_rmk.get().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubMsgType0x27.FriendRemark)((Iterator)localObject2).next();
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
        localObject2 = localFriendsManager.a((String)localObject3);
        paramArrayOfByte = (byte[])localObject2;
        if (localObject2 == null)
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
              break label5181;
            }
            if (QLog.isColorLevel()) {
              QLog.d("cardpush", 2, "push a ModGroupProfile 1--TroopName  = " + ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8());
            }
            localObject2 = String.valueOf(l3);
            localObject3 = localTroopManager.a((String)localObject2);
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
              ((BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(22)).a(44, true, new Object[] { localObject2, localObject4, null });
              if (i == 0) {
                continue;
              }
              ((TroopHandler)localObject5).b((String)localObject2, String.valueOf(l1), ((TroopInfo)localObject3).troopname);
              continue;
            }
          }
          catch (Exception paramArrayOfByte)
          {
            paramArrayOfByte.printStackTrace();
          }
          i = 0;
          continue;
          label5181:
          if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 2)
          {
            localObject2 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get();
            if ((localObject2 != null) && (((ByteStringMicro)localObject2).size() == 2))
            {
              i = ((ByteStringMicro)localObject2).byteAt(0);
              short s = (short)(((ByteStringMicro)localObject2).byteAt(1) | i << 8);
              localObject2 = localTroopManager.a(l2 + "");
              ((TroopInfo)localObject2).troopface = s;
              ((TroopInfo)localObject2).hasSetNewTroopHead = true;
              if (QLog.isColorLevel()) {
                QLog.d("cardpush", 2, "push a ModGroupProfile 2--TroopHead(2bytes) = " + s);
              }
              localTroopManager.b((TroopInfo)localObject2);
              ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).d(l2 + "");
            }
          }
          else if (((SubMsgType0x27.GroupProfileInfo)localObject4).uint32_field.get() == 3)
          {
            localObject2 = ((SubMsgType0x27.GroupProfileInfo)localObject4).bytes_value.get().toStringUtf8();
            if (QLog.isColorLevel()) {
              QLog.i("troop.credit.data", 2, "onLinePush, creditLevelChange:" + l2 + "," + l3 + "," + (String)localObject2);
            }
            localObject3 = localTroopManager.a(l3 + "");
            if (localObject3 != null)
            {
              ((TroopInfo)localObject3).troopCreditLevel = Long.valueOf((String)localObject2).longValue();
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
        localObject2 = (SubMsgType0x27.ModGroupMemberProfile)paramArrayOfByte.msg_mod_group_member_profile.get();
        if ((!((SubMsgType0x27.ModGroupMemberProfile)localObject2).uint64_group_code.has()) || (!((SubMsgType0x27.ModGroupMemberProfile)localObject2).uint64_group_uin.has())) {
          break;
        }
        l1 = ((SubMsgType0x27.ModGroupMemberProfile)localObject2).uint64_group_uin.get();
        l2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject2).uint64_group_code.get();
        l3 = ((SubMsgType0x27.ModGroupMemberProfile)localObject2).uint64_uin.get();
        paramArrayOfByte = DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l2 + "", l3 + "");
        localObject2 = ((SubMsgType0x27.ModGroupMemberProfile)localObject2).rpt_msg_group_member_profile_infos.get().iterator();
        label6469:
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SubMsgType0x27.GroupMemberProfileInfo)((Iterator)localObject2).next();
          if ((((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.has()) && (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).bytes_value.has()))
          {
            if (((SubMsgType0x27.GroupMemberProfileInfo)localObject3).uint32_field.get() != 1) {
              break label5966;
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
              break label6469;
            }
            DBUtils.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayOfByte);
            localObject3 = new ArrayList();
            ((ArrayList)localObject3).add(paramArrayOfByte);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(16, true, localObject3);
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20).a(11, true, new Object[] { localObject3, Boolean.valueOf(true) });
            break;
            label5966:
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
        localObject2 = null;
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localObject4 = Long.toString(l2);
        if (l1 == 0L) {}
        for (paramArrayOfByte = (byte[])localObject3;; paramArrayOfByte = (byte[])localObject4)
        {
          if (((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.has()) {
            localObject2 = ((SubMsgType0x27.AppointmentNotify)localObject5).str_tips_content.get();
          }
          localObject5 = new ArrayList();
          localObject6 = MessageRecordFactory.a(-1024);
          l2 = MessageCache.a();
          if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handle date push friendUin=" + (String)localObject4 + ",senderUin=" + paramArrayOfByte + ",notifytype=" + l1);
          }
          ((MessageRecord)localObject6).init((String)localObject3, (String)localObject4, paramArrayOfByte, (String)localObject2, l2, -1024, 1010, l2);
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
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("optype", 200);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject2).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.uint32_dev_time.has()) {
          ((Bundle)localObject2).putInt("devtime", paramArrayOfByte.uint32_dev_time.get());
        }
        if (paramArrayOfByte.uint64_din.has()) {
          ((Bundle)localObject2).putLong("din", paramArrayOfByte.uint64_din.get());
        }
        if (paramArrayOfByte.str_data.has()) {
          ((Bundle)localObject2).putString("data", paramArrayOfByte.str_data.get());
        }
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject2);
        break;
        if (!paramArrayOfByte.msg_push_report_dev.has()) {
          break;
        }
        paramArrayOfByte = (SubMsgType0x27.PushReportDev)paramArrayOfByte.msg_push_report_dev.get();
        localObject2 = new Bundle();
        ((Bundle)localObject2).putInt("optype", 201);
        if (paramArrayOfByte.uint32_msg_type.has()) {
          ((Bundle)localObject2).putInt("msgtype", paramArrayOfByte.uint32_msg_type.get());
        }
        if (paramArrayOfByte.bytes_cookie.has()) {
          ((Bundle)localObject2).putString("cookie", paramArrayOfByte.bytes_cookie.get().toStringUtf8());
        }
        if (paramArrayOfByte.uint32_report_max_num.has()) {
          ((Bundle)localObject2).putInt("count", paramArrayOfByte.uint32_report_max_num.get());
        }
        if (paramArrayOfByte.bytes_sn.has()) {
          ((Bundle)localObject2).putString("sn", paramArrayOfByte.bytes_sn.get().toStringUtf8());
        }
        ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(39, (Bundle)localObject2);
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
            localObject2 = (LBSHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(3);
            if (localObject2 == null) {
              break;
            }
            ((LBSHandler)localObject2).a(paramArrayOfByte);
            break;
          }
          if ((i != 2) && (i != 3)) {
            break;
          }
          localObject2 = (NearFieldTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(57);
          if (localObject2 == null) {
            break;
          }
          ((NearFieldTroopHandler)localObject2).a(i, paramArrayOfByte);
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
              localObject2 = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130839189);
              localObject3 = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
              localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), LikeRankingListActivity.class);
              ((Intent)localObject4).putExtra("param_from", 1);
              ((Intent)localObject4).addFlags(67108864);
              ((ToServiceMsg)localObject3).extraData.putStringArray("cmds", new String[] { "QQ", "QQ", paramArrayOfByte });
              ((ToServiceMsg)localObject3).extraData.putParcelable("intent", (Parcelable)localObject4);
              ((ToServiceMsg)localObject3).extraData.putParcelable("bitmap", (Parcelable)localObject2);
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
            label7799:
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