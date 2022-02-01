package com.tencent.imcore.message;

import IMMsgBodyPack.MsgType0x210;
import IMMsgBodyPack.MsgType0x210SubMsgType0x24;
import IMMsgBodyPack.PluginNum;
import OnlinePushPack.DelMsgInfo;
import OnlinePushPack.SvcReqPushMsg;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.tencent.avgame.protocol.SubType0x138;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.basic.MapClassGenerator;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x100;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x101;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x102;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x103;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x104;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x108;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x10b;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x111;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x113;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x115;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x116;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x117;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x118;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x119;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11a;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11b;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11c;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11e;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11f;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x120;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x122;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x125;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x126;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x127;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x128;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x133;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x135;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x136;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x139;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x13b;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x13c;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x141;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x144;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x145;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x146;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x26;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x27;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x28;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x30;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x31;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x35;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x3b;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x3d;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x3f;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x43;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x44;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x48;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x4a;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x4e;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x51;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x54;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x63;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x66;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x67;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x69;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x6b;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x6e;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x6f;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x71;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x72;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x76;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x78;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x79;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x7c;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x7e;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x83;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x85;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x86;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x87;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x89;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x8a;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x8d;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x90;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x92;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x94;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x95;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x96;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x98;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x9f;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xa0;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xa2;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xa4;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xa6;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xa8;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xaa;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xab;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xae;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb1;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb3;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb5;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xbe;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc1;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc3;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc5;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc6;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc7;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc9;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xcb;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xcc;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xce;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xcf;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xd0;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xd7;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xda;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xdb;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xdc;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xdd;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xde;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xdf;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xe4;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xe5;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xe8;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xe9;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xeb;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xee;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xef;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xf4;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xf9;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xfb;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xfd;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xfe;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ExtSnsFrdDataHandleHelper;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQGAudioMsgHandler;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.handler.PreDownloadMsg;
import com.tencent.mobileqq.app.message.AddMessageHelper;
import com.tencent.mobileqq.app.message.PushMsg0x210C7Info;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.managers.PullActiveManager;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.mutualmark.oldlogic.ReactivePushHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.config.ConfigUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.BuddyTransfileProcessor;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.NoDisturbUtil;
import com.tencent.mobileqq.utils.QQUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceReqInfo;
import tencent.im.group.cmd0x2dc.GroupVisitorJoinMsg;
import tencent.im.group.cmd0x2dc.VisitorJoinInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ForwardBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xea.submsgtype0xea.MsgBody;

public class OnLinePushMessageProcessor
  extends BaseOnLinePushMessageProcessor
{
  public OnLinePushMessageProcessor(QQAppInterface paramQQAppInterface, MessageHandler paramMessageHandler)
  {
    super(paramQQAppInterface, paramMessageHandler);
    c();
  }
  
  @Nullable
  private String a(SubMsgType0xa8.MsgBody paramMsgBody, Intent paramIntent)
  {
    if (!paramMsgBody.bytes_extend_content.has()) {
      return null;
    }
    paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
    paramIntent.putExtra("open_chatfragment", true);
    paramIntent.putExtra("uin", paramMsgBody);
    paramIntent.putExtra("param_fromuin", paramMsgBody);
    paramIntent.putExtra("uintype", 1008);
    paramIntent.putExtra("isforceRequestDetail", true);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: public account uin: %s", new Object[] { paramMsgBody }));
    }
    return paramMsgBody;
  }
  
  private void a(byte paramByte, int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("----->handleTroopExitMsg dwGroupCode = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", cOp = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", cSubOp = ");
      ((StringBuilder)localObject).append(paramByte);
      QLog.i("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((QQAppInterface)this.q).getGAudioHandler();
    if (localObject != null)
    {
      if (paramByte != 0) {
        if (paramByte != 1)
        {
          if (paramByte != 2)
          {
            if (paramByte != 3) {
              return;
            }
            ((QQGAudioMsgHandler)localObject).b(paramLong, true);
          }
        }
        else
        {
          ((QQGAudioMsgHandler)localObject).b(paramLong, false);
          return;
        }
      }
      ((QQGAudioMsgHandler)localObject).a(paramLong, true);
    }
  }
  
  private void a(byte paramByte, int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("----->handleTroopExitMsg dwGroupCode = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", cOp = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", cSubOp = ");
      ((StringBuilder)localObject).append(paramByte);
      QLog.i("Q.msg.BaseMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (HotChatManager)this.q.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    HotChatInfo localHotChatInfo = ((HotChatManager)localObject).c(String.valueOf(paramLong));
    if (paramByte == 3)
    {
      a(paramByte, paramInt1 + 1 + 4, paramLong, paramString, paramInt2, paramByte, (HotChatManager)localObject, localHotChatInfo);
      return;
    }
    if (paramByte == 2)
    {
      a(paramString, (HotChatManager)localObject, localHotChatInfo);
      return;
    }
    if (paramByte == 1) {
      a(paramLong);
    }
  }
  
  private void a(int paramInt1, int paramInt2, long paramLong, String paramString, int paramInt3, int paramInt4, HotChatManager paramHotChatManager, HotChatInfo paramHotChatInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----->handleTroopExitMsg dwGroupCode = ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", cOp = ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", cSubOp = ");
      localStringBuilder.append(paramInt4);
      localStringBuilder.append(", cSubOp2 = ");
      localStringBuilder.append(paramInt1);
      QLog.i("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return;
        }
        if (paramHotChatInfo != null)
        {
          paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
          HotChatHelper.a((QQAppInterface)this.q, paramHotChatInfo, this.q.getApp().getString(2131890715), true);
          ((IHotChatApi)QRoute.api(IHotChatApi.class)).delHotChatRecentUserNotNotifyUi((QQAppInterface)this.q, paramString, 6);
          ((IHotChatHandler)this.q.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
        }
      }
      else if (paramHotChatInfo != null)
      {
        paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT);
        HotChatHelper.a((QQAppInterface)this.q, paramHotChatInfo, this.q.getApp().getString(2131890714), true);
        ((IHotChatApi)QRoute.api(IHotChatApi.class)).delHotChatRecentUserNotNotifyUi((QQAppInterface)this.q, paramString, 6);
        ((IHotChatHandler)this.q.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_KICK_OUT });
      }
    }
    else if (paramHotChatInfo != null)
    {
      paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
      HotChatHelper.a((QQAppInterface)this.q, paramHotChatInfo, this.q.getApp().getString(2131890734), true);
      ((IHotChatApi)QRoute.api(IHotChatApi.class)).delHotChatRecentUserNotNotifyUi((QQAppInterface)this.q, paramString, 6);
      ((IHotChatHandler)this.q.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED });
    }
  }
  
  private void a(long paramLong)
  {
    QQGAudioMsgHandler localQQGAudioMsgHandler = ((QQAppInterface)this.q).getGAudioHandler();
    if (localQQGAudioMsgHandler != null) {
      localQQGAudioMsgHandler.a(paramLong, false);
    }
  }
  
  private void a(PushMsg0x210C7Info paramPushMsg0x210C7Info, submsgtype0xc7.ForwardBody paramForwardBody)
  {
    if ((paramForwardBody.uint32_notify_type.has()) && (paramForwardBody.uint32_notify_type.get() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7 push a no content");
      }
      return;
    }
    if (!paramForwardBody.uint32_op_type.has()) {
      return;
    }
    int i = paramForwardBody.uint32_op_type.get();
    if (i != 3000)
    {
      if (i != 4000) {
        return;
      }
      if (paramForwardBody.msg_relational_chain_change.has())
      {
        paramForwardBody = (submsgtype0xc7.RelationalChainChange)paramForwardBody.msg_relational_chain_change.get();
        if (paramForwardBody.uint64_appid.get() == 10001L)
        {
          FriendIntimateRelationshipHelper.a(this.q, paramForwardBody, paramPushMsg0x210C7Info);
          return;
        }
        if (paramForwardBody.uint64_appid.get() == 19999L)
        {
          ReactivePushHelper.a(this.q, paramForwardBody, paramPushMsg0x210C7Info);
          return;
        }
        if (paramForwardBody.uint64_appid.get() == 10002L) {
          ExtSnsFrdDataHandleHelper.a((QQAppInterface)this.q, paramForwardBody, paramPushMsg0x210C7Info);
        }
      }
    }
  }
  
  private void a(String paramString, long paramLong1, long[] paramArrayOfLong, byte[] paramArrayOfByte, long paramLong2, short paramShort, boolean paramBoolean)
  {
    paramLong1 = paramArrayOfLong[0];
    paramArrayOfByte = BuddyTransfileProcessor.analysisOffLineFileMsg(paramArrayOfByte, paramArrayOfLong);
    if (paramArrayOfByte != null)
    {
      ((QQAppInterface)this.q).getFileTransferHandler().a(paramString, String.valueOf(paramArrayOfLong[0]), paramArrayOfByte, paramLong2, paramShort, paramLong1, paramBoolean);
      return;
    }
  }
  
  private void a(String paramString, HotChatManager paramHotChatManager, HotChatInfo paramHotChatInfo)
  {
    if (paramHotChatInfo != null)
    {
      paramHotChatManager.a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_LEFT_LONG_TIME_NOT_SAY);
      HotChatHelper.a((QQAppInterface)this.q, paramHotChatInfo, this.q.getApp().getString(2131890713), false);
      ((IHotChatApi)QRoute.api(IHotChatApi.class)).delHotChatRecentUserNotNotifyUi((QQAppInterface)this.q, paramString, 6);
      ((IHotChatHandler)this.q.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).notifyUI(1041, true, new Object[] { paramString, HotChatManager.HotChatStateWrapper.STATE_LEFT_LONG_TIME_NOT_SAY });
    }
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject1 = new cmd0x2dc.GroupVisitorJoinMsg();
    try
    {
      cmd0x2dc.GroupVisitorJoinMsg localGroupVisitorJoinMsg = (cmd0x2dc.GroupVisitorJoinMsg)((cmd0x2dc.GroupVisitorJoinMsg)localObject1).mergeFrom(paramArrayOfByte);
      long l = localGroupVisitorJoinMsg.uint64_group_code.get();
      paramArrayOfByte = localGroupVisitorJoinMsg.rpt_msg_visitor_join_info.get();
      if ((paramArrayOfByte != null) && (paramArrayOfByte.size() > 0))
      {
        localObject1 = this.q.getCurrentAccountUin();
        if (((HotChatManager)this.q.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(String.valueOf(l)))
        {
          Iterator localIterator = paramArrayOfByte.iterator();
          paramArrayOfByte = "";
          while (localIterator.hasNext())
          {
            Object localObject2 = (cmd0x2dc.VisitorJoinInfo)localIterator.next();
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("");
            ((StringBuilder)localObject3).append(((cmd0x2dc.VisitorJoinInfo)localObject2).uint64_visitor_uin.get());
            localObject3 = ((StringBuilder)localObject3).toString();
            if (!((String)localObject3).equalsIgnoreCase((String)localObject1)) {
              if (((cmd0x2dc.VisitorJoinInfo)localObject2).bytes_visitor_name.get().toStringUtf8().equals(""))
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(paramArrayOfByte);
                ((StringBuilder)localObject2).append((String)localObject3);
                ((StringBuilder)localObject2).append("、");
                paramArrayOfByte = ((StringBuilder)localObject2).toString();
              }
              else
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(paramArrayOfByte);
                ((StringBuilder)localObject3).append(((cmd0x2dc.VisitorJoinInfo)localObject2).bytes_visitor_name.get().toStringUtf8());
                ((StringBuilder)localObject3).append("、");
                paramArrayOfByte = ((StringBuilder)localObject3).toString();
              }
            }
          }
          int j = paramArrayOfByte.length();
          int i = 0;
          localObject1 = paramArrayOfByte;
          if (j > 1) {
            localObject1 = paramArrayOfByte.substring(0, paramArrayOfByte.length() - 1);
          }
          if (localGroupVisitorJoinMsg.uint32_op_flag.has()) {
            i = localGroupVisitorJoinMsg.uint32_op_flag.get();
          }
          if (QLog.isColorLevel())
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("handleEnterOpenTroopHotChatPushMsg. groupCode=");
            paramArrayOfByte.append(l);
            paramArrayOfByte.append(", name=");
            paramArrayOfByte.append((String)localObject1);
            paramArrayOfByte.append(", op_flag=");
            paramArrayOfByte.append(i);
            QLog.i("Q.msg.BaseMessageProcessor", 2, paramArrayOfByte.toString());
          }
          if (paramInt == 11)
          {
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append((String)localObject1);
            paramArrayOfByte.append(this.q.getApplication().getString(2131890720));
            paramArrayOfByte = paramArrayOfByte.toString();
          }
          else
          {
            paramArrayOfByte = (byte[])localObject1;
            if (paramInt == 13) {
              if (1 == i)
              {
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append((String)localObject1);
                paramArrayOfByte.append(this.q.getApplication().getString(2131890738));
                paramArrayOfByte = paramArrayOfByte.toString();
              }
              else
              {
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append((String)localObject1);
                paramArrayOfByte.append(this.q.getApplication().getString(2131890724));
                paramArrayOfByte = paramArrayOfByte.toString();
              }
            }
          }
          AddMessageHelper.a(this.q, String.valueOf(l), paramArrayOfByte, 1, false, true);
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private boolean a(SubMsgType0xa8.MsgBody paramMsgBody, Intent paramIntent, int paramInt)
  {
    if (!paramMsgBody.bytes_extend_content.has()) {
      return true;
    }
    paramMsgBody = paramMsgBody.bytes_extend_content.get().toStringUtf8();
    paramIntent.putExtra("extra_pull_active_push_type", paramInt);
    paramIntent.putExtra("extra_pull_active_push_url", paramMsgBody);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: url: %s", new Object[] { paramMsgBody }));
    }
    return false;
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    long l = PkgTools.getLongData(paramArrayOfByte, 0);
    int i = paramArrayOfByte[5];
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----->handleTroopExitMsg cOp = ");
      localStringBuilder.append(i);
      QLog.i("Q.msg.BaseMessageProcessor", 2, localStringBuilder.toString());
    }
    if (i == 3)
    {
      a(paramArrayOfByte[5], 5, l, String.valueOf(l), i);
      return;
    }
    if (i == 1) {
      a(paramArrayOfByte[5], 5, l, i);
    }
  }
  
  private boolean b(SubMsgType0xa8.MsgBody paramMsgBody, Intent paramIntent, int paramInt)
  {
    if (!paramMsgBody.uint32_action_subType.has()) {
      return true;
    }
    int i = paramMsgBody.uint32_action_subType.get();
    paramIntent.putExtra("extra_pull_active_push_type", paramInt);
    paramIntent.putExtra("extra_pull_active_push_subtype", i);
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionSubType: %d", new Object[] { Integer.valueOf(i) }));
    }
    return false;
  }
  
  private boolean b(byte[] paramArrayOfByte, int paramInt)
  {
    long l1 = PkgTools.getLongData(paramArrayOfByte, 0);
    if (paramArrayOfByte[4] == 15)
    {
      long l2 = PkgTools.getLongData(paramArrayOfByte, 5);
      long l3 = PkgTools.getLongData(paramArrayOfByte, 9);
      paramArrayOfByte = PkgTools.getUTFString(paramArrayOfByte, 15, PkgTools.getHShortData(paramArrayOfByte, 13));
      long l4 = NetConnInfoCenter.getServerTime();
      ((TroopManager)this.q.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramInt, l1, l4, l3, l2, paramArrayOfByte);
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.t.a(Long.valueOf(39L), SubType0x27.class);
    this.t.a(Long.valueOf(40L), SubType0x28.class);
    this.t.a(Long.valueOf(63L), SubType0x3f.class);
    this.t.a(Long.valueOf(166L), SubType0xa6.class);
    this.t.a(Long.valueOf(48L), SubType0x30.class);
    this.t.a(Long.valueOf(49L), SubType0x31.class);
    this.t.a(Long.valueOf(53L), SubType0x35.class);
    this.t.a(Long.valueOf(201L), SubType0xc9.class);
    this.t.a(Long.valueOf(59L), SubType0x3b.class);
    this.t.a(Long.valueOf(61L), SubType0x3d.class);
    this.t.a(Long.valueOf(67L), SubType0x43.class);
    this.t.a(Long.valueOf(68L), SubType0x44.class);
    this.t.a(Long.valueOf(179L), SubType0xb3.class);
    this.t.a(Long.valueOf(228L), SubType0xe4.class);
    this.t.a(Long.valueOf(38L), SubType0x26.class);
    this.t.a(Long.valueOf(278L), SubType0x116.class);
    this.t.a(Long.valueOf(279L), SubType0x117.class);
    this.t.a(Long.valueOf(309L), SubType0x135.class);
    this.t.a(Long.valueOf(131L), SubType0x83.class);
    this.t.a(Long.valueOf(181L), SubType0xb5.class);
    this.t.a(Long.valueOf(190L), SubType0xbe.class);
    this.t.a(Long.valueOf(72L), SubType0x48.class);
    this.t.a(Long.valueOf(81L), SubType0x51.class);
    this.t.a(Long.valueOf(74L), SubType0x4a.class);
    this.t.a(Long.valueOf(84L), SubType0x54.class);
    this.t.a(Long.valueOf(103L), SubType0x67.class);
    this.t.a(Long.valueOf(110L), SubType0x6e.class);
    this.t.a(Long.valueOf(99L), SubType0x63.class);
    this.t.a(Long.valueOf(102L), SubType0x66.class);
    this.t.a(Long.valueOf(195L), SubType0xc3.class);
    this.t.a(Long.valueOf(126L), SubType0x7e.class);
    this.t.a(Long.valueOf(78L), SubType0x4e.class);
    this.t.a(Long.valueOf(107L), SubType0x6b.class);
    this.t.a(Long.valueOf(105L), SubType0x69.class);
    this.t.a(Long.valueOf(222L), SubType0xde.class);
    this.t.a(Long.valueOf(111L), SubType0x6f.class);
    this.t.a(Long.valueOf(120L), SubType0x78.class);
    this.t.a(Long.valueOf(113L), SubType0x71.class);
    this.t.a(Long.valueOf(137L), SubType0x89.class);
    this.t.a(Long.valueOf(280L), SubType0x118.class);
    this.t.a(Long.valueOf(118L), SubType0x76.class);
    this.t.a(Long.valueOf(114L), SubType0x72.class);
    this.t.a(Long.valueOf(121L), SubType0x79.class);
    this.t.a(Long.valueOf(124L), SubType0x7c.class);
    this.t.a(Long.valueOf(134L), SubType0x86.class);
    this.t.a(Long.valueOf(133L), SubType0x85.class);
    this.t.a(Long.valueOf(146L), SubType0x92.class);
    this.t.a(Long.valueOf(229L), SubType0xe5.class);
    this.t.a(Long.valueOf(159L), SubType0x9f.class);
    this.t.a(Long.valueOf(162L), SubType0xa2.class);
    this.t.a(Long.valueOf(141L), SubType0x8d.class);
    this.t.a(Long.valueOf(135L), SubType0x87.class);
    this.t.a(Long.valueOf(138L), SubType0x8a.class);
    this.t.a(Long.valueOf(139L), SubType0x8a.class);
    this.t.a(Long.valueOf(144L), SubType0x90.class);
    this.t.a(Long.valueOf(149L), SubType0x95.class);
    this.t.a(Long.valueOf(150L), SubType0x96.class);
    this.t.a(Long.valueOf(206L), SubType0xce.class);
    this.t.a(Long.valueOf(284L), SubType0x11c.class);
    this.t.a(Long.valueOf(148L), SubType0x94.class);
    this.t.a(Long.valueOf(220L), SubType0xdc.class);
    this.t.a(Long.valueOf(152L), SubType0x98.class);
    this.t.a(Long.valueOf(160L), SubType0xa0.class);
    this.t.a(Long.valueOf(164L), SubType0xa4.class);
    this.t.a(Long.valueOf(171L), SubType0xab.class);
    this.t.a(Long.valueOf(168L), SubType0xa8.class);
    this.t.a(Long.valueOf(170L), SubType0xaa.class);
    this.t.a(Long.valueOf(174L), SubType0xae.class);
    this.t.a(Long.valueOf(177L), SubType0xb1.class);
    this.t.a(Long.valueOf(193L), SubType0xc1.class);
    this.t.a(Long.valueOf(233L), SubType0xe9.class);
    this.t.a(Long.valueOf(199L), SubType0xc7.class);
    this.t.a(Long.valueOf(197L), SubType0xc5.class);
    this.t.a(Long.valueOf(258L), SubType0x102.class);
    this.t.a(Long.valueOf(238L), SubType0xee.class);
    this.t.a(Long.valueOf(249L), SubType0xf9.class);
    this.t.a(Long.valueOf(253L), SubType0xfd.class);
    this.t.a(Long.valueOf(198L), SubType0xc6.class);
    this.t.a(Long.valueOf(203L), SubType0xcb.class);
    this.t.a(Long.valueOf(204L), SubType0xcc.class);
    this.t.a(Long.valueOf(207L), SubType0xcf.class);
    this.t.a(Long.valueOf(208L), SubType0xd0.class);
    this.t.a(Long.valueOf(218L), SubType0xda.class);
    this.t.a(Long.valueOf(215L), SubType0xd7.class);
    this.t.a(Long.valueOf(254L), SubType0xfe.class);
    this.t.a(Long.valueOf(221L), SubType0xdd.class);
    this.t.a(Long.valueOf(219L), SubType0xdb.class);
    this.t.a(Long.valueOf(223L), SubType0xdf.class);
    this.t.a(Long.valueOf(232L), SubType0xe8.class);
    this.t.a(Long.valueOf(235L), SubType0xeb.class);
    this.t.a(Long.valueOf(239L), SubType0xef.class);
    this.t.a(Long.valueOf(267L), SubType0x10b.class);
    this.t.a(Long.valueOf(244L), SubType0xf4.class);
    this.t.a(Long.valueOf(251L), SubType0xfb.class);
    this.t.a(Long.valueOf(256L), SubType0x100.class);
    this.t.a(Long.valueOf(257L), SubType0x101.class);
    this.t.a(Long.valueOf(259L), SubType0x103.class);
    this.t.a(Long.valueOf(260L), SubType0x104.class);
    this.t.a(Long.valueOf(264L), SubType0x108.class);
    this.t.a(Long.valueOf(273L), SubType0x111.class);
    this.t.a(Long.valueOf(286L), SubType0x11e.class);
    this.t.a(Long.valueOf(287L), SubType0x11f.class);
    this.t.a(Long.valueOf(295L), SubType0x127.class);
    this.t.a(Long.valueOf(297L), SubType0x127.class);
    this.t.a(Long.valueOf(275L), SubType0x113.class);
    this.t.a(Long.valueOf(277L), SubType0x115.class);
    this.t.a(Long.valueOf(281L), SubType0x119.class);
    this.t.a(Long.valueOf(288L), SubType0x120.class);
    this.t.a(Long.valueOf(293L), SubType0x125.class);
    this.t.a(Long.valueOf(282L), SubType0x11a.class);
    this.t.a(Long.valueOf(294L), SubType0x126.class);
    this.t.a(Long.valueOf(283L), SubType0x11b.class);
    this.t.a(Long.valueOf(290L), SubType0x122.class);
    this.t.a(Long.valueOf(291L), SubType0x122.class);
    this.t.a(Long.valueOf(296L), SubType0x128.class);
    this.t.a(Long.valueOf(311L), SubType0x128.class);
    this.t.a(Long.valueOf(307L), SubType0x133.class);
    this.t.a(Long.valueOf(310L), SubType0x136.class);
    this.t.a(Long.valueOf(313L), SubType0x139.class);
    this.t.a(Long.valueOf(312L), SubType0x138.class);
    this.t.a(Long.valueOf(315L), SubType0x13b.class);
    this.t.a(Long.valueOf(316L), SubType0x13c.class);
    this.t.a(Long.valueOf(321L), SubType0x141.class);
    this.t.a(Long.valueOf(324L), SubType0x144.class);
    this.t.a(Long.valueOf(325L), SubType0x145.class);
    this.t.a(Long.valueOf(326L), SubType0x146.class);
  }
  
  public void a(int paramInt)
  {
    ((ISVIPHandler)this.q.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramInt);
  }
  
  protected void a(MsgType0x210 paramMsgType0x210)
  {
    paramMsgType0x210 = paramMsgType0x210.stMsgInfo0x24;
    if ((paramMsgType0x210 != null) && (paramMsgType0x210.vPluginNumList != null))
    {
      Object localObject = paramMsgType0x210.vPluginNumList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        paramMsgType0x210 = (GameCenterManagerImp)this.q.getManager(QQManagerFactory.GAMECENTER_MANAGER);
        if (paramMsgType0x210 != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PluginNum localPluginNum = (PluginNum)((Iterator)localObject).next();
            if (localPluginNum != null)
            {
              long l = localPluginNum.dwID;
              boolean bool;
              if (localPluginNum.cFlag == 0) {
                bool = false;
              } else {
                bool = true;
              }
              paramMsgType0x210.a(l, bool, localPluginNum.dwNUm);
            }
          }
        }
      }
    }
  }
  
  protected void a(SvcReqPushMsg paramSvcReqPushMsg)
  {
    ((QQAppInterface)this.q).userActiveStatus = paramSvcReqPushMsg.wUserActive;
    if ((paramSvcReqPushMsg.wGeneralFlag & 0x20) == 32) {
      NoDisturbUtil.a(true);
    } else {
      NoDisturbUtil.a(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, new Object[] { "OnlinePush.ReqPush,notify.wUserActive:", Integer.valueOf(paramSvcReqPushMsg.wUserActive), ", muteGeneralFlag:", Integer.valueOf(paramSvcReqPushMsg.wGeneralFlag) });
    }
  }
  
  protected void a(FromServiceMsg paramFromServiceMsg, ArrayList<MessageRecord> paramArrayList, ArrayList<String> paramArrayList1, SvcReqPushMsg paramSvcReqPushMsg, ArrayList<DelMsgInfo> paramArrayList2, long paramLong, int paramInt)
  {
    if (paramArrayList1.size() > 0) {
      a(paramArrayList1);
    }
    int i = paramFromServiceMsg.getRequestSsoSeq();
    ((BaseMessageHandler)this.q.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER)).a(paramLong, paramArrayList2, paramInt, i, null);
    if (paramArrayList.size() > 0)
    {
      boolean bool2 = MessageHandlerUtils.a(paramArrayList);
      paramInt = MsgProxyUtils.a(paramArrayList, (MessageCache)this.q.getMsgCache());
      paramFromServiceMsg = (IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "");
      boolean bool1;
      if ((bool2) && (this.q.isBackgroundStop)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramFromServiceMsg.addMessage(paramArrayList, String.valueOf(paramLong), bool1);
      ((MessageCache)this.q.getMsgCache()).a((int)paramSvcReqPushMsg.uMsgTime);
      a("handleGetBuddyMessageResp", true, paramInt, this.r.a(bool2), false);
    }
    PreDownloadMsg.a(paramArrayList, true, this.q);
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = (String)paramArrayList.next();
        Object localObject = ((MessageCache)this.q.getMsgCache()).O(str);
        if (((localObject == null) || (System.currentTimeMillis() - ((AppShareID)localObject).updateTime >= 86400000L)) && (((MessageCache)this.q.getMsgCache()).u().add(str)))
        {
          localObject = new GetResourceReqInfo();
          ((GetResourceReqInfo)localObject).uiResID = 0L;
          ((GetResourceReqInfo)localObject).strPkgName = str;
          ((GetResourceReqInfo)localObject).uiCurVer = 0L;
          ((GetResourceReqInfo)localObject).sResType = 4;
          ((GetResourceReqInfo)localObject).sLanType = 0;
          ((GetResourceReqInfo)localObject).sReqType = 1;
          localArrayList.add(localObject);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("Request list add appid = ");
            ((StringBuilder)localObject).append(str);
            QLog.d("share_appid", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      if (localArrayList.size() > 0) {
        ConfigUtil.a(this.q, this.q.getCurrentAccountUin(), localArrayList);
      }
    }
  }
  
  public void a(SubMsgType0xa8.MsgBody paramMsgBody)
  {
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PullActive", 2, "handlePullActivePushMsg, isNeedNotifyActivePush is false");
      }
      return;
    }
    ReportController.b(this.q, "CliOper", "", "", "0X80065A9", "0X80065A9", 0, 0, "", "", "", "");
    if (!paramMsgBody.bytes_msg_summary.has()) {
      return;
    }
    Object localObject2 = paramMsgBody.bytes_msg_summary.get().toStringUtf8();
    Intent localIntent = new Intent(this.q.getApp(), SplashActivity.class);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.setFlags(335544320);
    int i = paramMsgBody.uint32_action_type.get();
    if (QLog.isColorLevel()) {
      QLog.d("PullActive", 2, String.format("Recv 0x210_0xa8: actionType: %d, brief: %s", new Object[] { Integer.valueOf(i), localObject2 }));
    }
    if (i == 1)
    {
      if (!b(paramMsgBody, localIntent, i)) {}
    }
    else
    {
      if (i != 2) {
        break label215;
      }
      if (a(paramMsgBody, localIntent, i)) {
        return;
      }
    }
    paramMsgBody = "";
    label215:
    if (i == 3)
    {
      Object localObject1 = a(paramMsgBody, localIntent);
      paramMsgBody = (SubMsgType0xa8.MsgBody)localObject1;
      if (localObject1 == null) {
        return;
      }
      localIntent.putExtra(PullActiveManager.b, (String)localObject2);
      localIntent.putExtra("activepull_push_flag", true);
      localObject1 = PullActiveManager.a;
      Object localObject3 = BitmapManager.a(this.q.getApp().getResources(), 2130841158);
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.q.getCurrentAccountUin(), "CMD_SHOW_NOTIFIYCATION");
      localToServiceMsg.extraData.putStringArray("cmds", new String[] { localObject2, localObject1, localObject2 });
      localToServiceMsg.extraData.putParcelable("intent", localIntent);
      localToServiceMsg.extraData.putParcelable("bitmap", (Parcelable)localObject3);
      this.q.sendToService(localToServiceMsg);
      localObject1 = this.q.getApp().getBaseContext();
      if (QQUtils.a((Context)localObject1))
      {
        localObject2 = (PullActiveManager)this.q.getManager(QQManagerFactory.PULL_ACTIVE_MANAGER);
        ((PullActiveManager)localObject2).a(localIntent);
        localObject3 = (QQLSRecentManager)this.q.getManager(QQManagerFactory.QQLS_DATA_MANAGER);
        if (SettingCloneUtil.readValue((Context)localObject1, this.q.getCurrentAccountUin(), ((Context)localObject1).getString(2131891413), "qqsetting_lock_screen_whenexit_key", true))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "handlePullActivePushMsg, start lsActivity");
          }
          ((QQLSRecentManager)localObject3).a(this.q, AppConstants.PULL_ACTIVE_PUSH_UIN, 9653, false, MsgPushReportHelper.a(paramMsgBody, 1008, localIntent));
        }
        ((IMessageFacade)this.q.getRuntimeService(IMessageFacade.class, "")).setChangeAndNotify(((PullActiveManager)localObject2).c);
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, PushMsg0x210C7Info paramPushMsg0x210C7Info)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7");
    }
    if (paramArrayOfByte == null) {
      return;
    }
    submsgtype0xc7.MsgBody localMsgBody = new submsgtype0xc7.MsgBody();
    try
    {
      paramArrayOfByte = (submsgtype0xc7.MsgBody)localMsgBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = paramArrayOfByte.rpt_msg_mod_infos.get().iterator();
      while (paramArrayOfByte.hasNext()) {
        a(paramPushMsg0x210C7Info, (submsgtype0xc7.ForwardBody)paramArrayOfByte.next());
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("HotFriend_PushMessage", 2, "handleMsgType0x210SubMsgType0xc7", paramArrayOfByte);
      }
    }
  }
  
  protected OnLinePushMessageProcessor.ProcessOneMsg b(BaseOnLinePushMessageProcessor.ProcessOneMsgBuildParams paramProcessOneMsgBuildParams)
  {
    return new OnLinePushMessageProcessor.ProcessOneMsg(this, paramProcessOneMsgBuildParams);
  }
  
  protected void b(MsgType0x210 paramMsgType0x210)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xea, [S2C push for ark]");
    }
    for (;;)
    {
      try
      {
        submsgtype0xea.MsgBody localMsgBody = new submsgtype0xea.MsgBody();
        if (d(paramMsgType0x210))
        {
          localMsgBody.mergeFrom(paramMsgType0x210.vProtobuf);
          boolean bool = localMsgBody.bytes_title.has();
          localObject = "";
          if (!bool) {
            break label147;
          }
          paramMsgType0x210 = localMsgBody.bytes_title.get().toStringUtf8();
          if (localMsgBody.bytes_content.has()) {
            localObject = localMsgBody.bytes_content.get().toStringUtf8();
          }
          ArkTipsManager.b().a(this.q, paramMsgType0x210, (String)localObject);
          return;
        }
      }
      catch (Exception paramMsgType0x210)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[msg0x210.uSubMsgType == 0xea], errInfo->");
        ((StringBuilder)localObject).append(paramMsgType0x210.getMessage());
        QLog.e("Q.msg.BaseMessageProcessor", 1, ((StringBuilder)localObject).toString());
      }
      return;
      label147:
      paramMsgType0x210 = "";
    }
  }
  
  public boolean b()
  {
    return ((this.q.isBackgroundPause) || (this.q.isBackgroundStop)) && (((QQAppInterface)this.q).userActiveStatus == 0);
  }
  
  public boolean b(int paramInt)
  {
    boolean bool2 = true;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt == 1) {
        return bool1;
      }
      if (paramInt != 2)
      {
        bool1 = bool2;
        if (paramInt == 3) {
          return bool1;
        }
      }
    }
    boolean bool1 = false;
    return bool1;
  }
  
  public boolean c(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1)
    {
      bool1 = bool2;
      if (paramInt != 2) {
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean d(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 9) || (paramInt == 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.OnLinePushMessageProcessor
 * JD-Core Version:    0.7.0.1
 */