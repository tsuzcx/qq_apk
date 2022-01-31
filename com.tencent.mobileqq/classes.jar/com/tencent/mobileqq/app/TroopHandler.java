package com.tencent.mobileqq.app;

import KQQ.GroupMemberFlag;
import KQQ.GroupMngRes;
import KQQ.ProfGroupInfoRes;
import KQQ.RespBatchProcess;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.jce.wup.UniPacket;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.RecvGVideoLevelInfo;
import com.tencent.av.service.RecvGVideoLevelInfo.Medal;
import com.tencent.av.utils.GVideoGrayConfig;
import com.tencent.av.utils.VideoMsgTools;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.common.util.SubString;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.DealInviteReqBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.DealInviteRspBody;
import com.tencent.im.oidb.cmd0x6d1.cmd0x6d1.ReqBody;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.lbs.LbsInfoMgr;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.compatible.PbServlet;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.LightReplyMsgRich2;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.ShowExternalTroop;
import com.tencent.mobileqq.data.TroopAIONotifyItem;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberCard;
import com.tencent.mobileqq.data.TroopMemberCard.CustomEntry;
import com.tencent.mobileqq.data.TroopMemberCard.GBarInfo;
import com.tencent.mobileqq.data.TroopMemberCard.MemberGameInfo;
import com.tencent.mobileqq.data.TroopMemberCard.StoryInfo;
import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.intervideo.groupvideo.GVideoStateGetListener;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoManager;
import com.tencent.mobileqq.intervideo.groupvideo.VideoStateInfo;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.lightReply.MsgInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import com.tencent.mobileqq.troop.data.TroopCreateLogic;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectConfig;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.TroopEnterEffectData;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectManager;
import com.tencent.mobileqq.troop.homework.HomeworkInfo;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.AioKeyword;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.GroupMsgConfig;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.ReqBody;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.Robot;
import com.tencent.mobileqq.troop.org.pb.oidb_0x496.RspBody;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopAioNotifyManager;
import com.tencent.mobileqq.troop.utils.TroopAppMgr;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopNameHelper;
import com.tencent.mobileqq.troop.utils.TroopRewardMgr;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberItem;
import com.tencent.mobileqq.trooponline.data.TroopOnlineMemberManager;
import com.tencent.mobileqq.troopshare.TroopShareResp;
import com.tencent.mobileqq.util.TroopSystemMsgUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.protofile.group_homework.value.HomeworkInfo;
import com.tencent.protofile.homework.hw_assign_homework.ReqAssignHomework;
import com.tencent.protofile.homework.hw_get_homework_info.ErrorInfo;
import com.tencent.protofile.homework.hw_get_homework_info.ReqGetHomeworkInfo;
import com.tencent.protofile.homework.hw_get_homework_info.RspGetHomeworkInfo;
import com.tencent.protofile.homework.hw_submit_homework.HwCommentInfo;
import com.tencent.protofile.homework.hw_submit_homework.ReqSubmitHomework;
import com.tencent.protofile.join_group_link.join_group_link.ReqBody;
import com.tencent.protofile.join_group_link.join_group_link.RspBody;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import friendlist.GetMultiTroopInfoResp;
import friendlist.GetTroopAppointRemarkResp;
import friendlist.GetTroopListRespV2;
import friendlist.GetTroopMemberListReq;
import friendlist.GetTroopMemberListResp;
import friendlist.ModifyGroupCardResp;
import friendlist.ModifyGroupInfoResp;
import friendlist.stFavoriteGroup;
import friendlist.stGroupRankInfo;
import friendlist.stTroopInfoV2;
import friendlist.stTroopMemberInfo;
import friendlist.stTroopNum;
import friendlist.stUinInfo;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import tencent.im.cs.cmd0x2323.BodyMsg;
import tencent.im.cs.cmd0x2323.ReqBody;
import tencent.im.cs.cmd0x2323.RspBody;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyMsg;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.AnonyStatus;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.ReqBody;
import tencent.im.cs.cmd0x3bb.cmd0x3bb.RspBody;
import tencent.im.cs.cmd0x3fb.cmd0x3fb.GrayMsg;
import tencent.im.cs.cmd0x3fb.cmd0x3fb.ReqBody;
import tencent.im.cs.cmd0x3fb.cmd0x3fb.RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.LevelInfo;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.LevelMsg;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.Medal;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.ReqBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.RspBody;
import tencent.im.cs.cmd0x3fe.cmd0x3fe.UserInfo;
import tencent.im.group.group_member_info.CustomEntry;
import tencent.im.group.group_member_info.GBarInfo;
import tencent.im.group.group_member_info.InfoCardVideoInfo;
import tencent.im.group.group_member_info.MemberGameInfo;
import tencent.im.group.group_member_info.MemberInfo;
import tencent.im.group.group_member_info.ReqBody;
import tencent.im.group.group_member_info.RspBody;
import tencent.im.group.group_member_info.RspGroupCardGetStory;
import tencent.im.group.group_member_info.TeamEntry;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationReq;
import tencent.im.kqq.profilesvr.GroupLocation.SetGroupLocationRes;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListQuery;
import tencent.im.oidb.cmd0x406.cmd0x406.GroupFeeMemberListResult;
import tencent.im.oidb.cmd0x406.cmd0x406.ReqBody;
import tencent.im.oidb.cmd0x406.cmd0x406.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.RspBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x758.cmd0x758.InviteUinInfo;
import tencent.im.oidb.cmd0x758.cmd0x758.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.MemberLevelInfo;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupExInfoOnly;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.RspGroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.cmd0x899.oidb_0x899.ReqBody;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.ReqBody;
import tencent.im.oidb.cmd0x89e.oidb_0x89e.RspBody;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickMemberInfo;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.KickResult;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.ReqBody;
import tencent.im.oidb.cmd0x8a0.oidb_0x8a0.RspBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.ReqBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7.RspBody;
import tencent.im.oidb.cmd0x8b4.GroupInfo;
import tencent.im.oidb.cmd0x8b4.ReqBody;
import tencent.im.oidb.cmd0x8b4.RspBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.DelPicReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ModifyOrderReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ReqBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.SetDefaultReq;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.ReqBody;
import tencent.im.oidb.cmd0x8ca.cmd0x8ca.RspBody;
import tencent.im.oidb.cmd0x903.cmd0x903.ReqBody;
import tencent.im.oidb.cmd0x903.cmd0x903.RspBody;
import tencent.im.oidb.cmd0x903.cmd0x903.SubCmd0x2Req;
import tencent.im.oidb.cmd0x903.cmd0x903.SubCmd0x2Rsp;
import tencent.im.oidb.cmd0x91a.cmd0x91a.ReqBody;
import tencent.im.oidb.cmd0x91a.cmd0x91a.RspBody;
import tencent.im.oidb.cmd0x91b.cmd0x91b.ReqBody;
import tencent.im.oidb.cmd0x91c.cmd0x91c.ReqBody;
import tencent.im.oidb.cmd0x91c.cmd0x91c.RspBody;
import tencent.im.oidb.cmd0x971.oidb_0x971.ReqBody;
import tencent.im.oidb.cmd0x9ab.oidb_0x9ab.ReqBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.GetSimilarGroupWebInfo;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.ReqBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.RspBody;
import tencent.im.oidb.cmd0x9fa.oidb_0x9fa.SimilarGroupWebInfo;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.Cell;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.GPS;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.LBSInfo;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.ReqBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.RspBody;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.UserInfo;
import tencent.im.oidb.cmd0xa2a.oidb_0xa2a.Wifi;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.MemberInfo;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqBody;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.ReqGroupInfo;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.RspBody;
import tencent.im.oidb.cmd0xa80.oidb_cmd0xa80.RspGroupInfo;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.ReqBody;
import tencent.im.oidb.cmd0xa8d.oidb_0xa8d.RspBody;
import tencent.im.oidb.cmd0xae6.oidb_0xae6.MsgInfo;
import tencent.im.oidb.cmd0xae6.oidb_0xae6.ReqBody;
import tencent.im.oidb.cmd0xae6.oidb_0xae6.RspBody;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ClientInfo;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.ReqBody;
import tencent.im.oidb.cmd0xaf4.oidb_0xaf4.RspBody;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.GroupMember;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.ReqBody;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6.RspBody;
import tencent.im.oidb.cmd0xb01.cmd0xb01.ReqBody;
import tencent.im.oidb.cmd0xb01.cmd0xb01.RspBody;
import tencent.im.oidb.cmd0xb14.oidb_0xb14.ReqBody;
import tencent.im.oidb.cmd0xb14.oidb_0xb14.RspBody;
import tencent.im.oidb.cmd0xb14.oidb_0xb14.UserInfo;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.AppInfo;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.ReqBody;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.Result;
import tencent.im.oidb.inner.cmd0xca02.cmd0xca02.RspBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.AppInfo;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.ReqBody;
import tencent.im.oidb.inner.cmd0xca04.cmd0xca04.RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.AppInfo;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.ReqBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05.RspBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783.RemarkInfo;
import tencent.im.oidb.oidb_0x783.oidb_0x783.ReqBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783.RspBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783.UinListInfo;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.ReqBody;
import tencent.im.oidb.oidb_0x928.oidb_0x928.NoticeInfo;
import tencent.im.oidb.oidb_0x928.oidb_0x928.ReqBody;
import tencent.im.oidb.oidb_0x928.oidb_0x928.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.opengroup.jstoken.ReqBody;
import tencent.im.opengroup.jstoken.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyContent;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x4UpdateApp;
import tencent.im.s2c.msgtype0x210.submsgtype0xab.SubMsgType0xab.MsgBody;
import tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusInfo;
import tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusReq;
import tencent.nearby.user.relation.UserFollowStatus.UserFollowStatusRsp;
import tencent.qun.group_effect.group_effect.EffectInfo;
import tencent.qun.group_effect.push_msg.PushMsg;
import zkv;
import zkw;
import zkx;
import zky;
import zkz;
import zla;
import zlb;
import zle;
import zlu;

public class TroopHandler
  extends BusinessHandler
{
  public static int a;
  public static String a;
  public static boolean a;
  public static int b;
  public static int c;
  protected static int d;
  protected static int e = 2;
  protected long a;
  private GroupIconHelper jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper = new GroupIconHelper(c(), this);
  private GVideoStateGetListener jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoStateGetListener;
  TroopBatchAddFriendMgr jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr;
  protected ArrayList a;
  HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected Set a;
  protected ConcurrentHashMap a;
  ArrayList jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap(50);
  protected ConcurrentHashMap b;
  protected boolean b;
  ArrayList jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_c_of_type_JavaUtilHashMap;
  public ConcurrentHashMap c;
  private HashMap d;
  
  static
  {
    jdField_a_of_type_Int = 9101;
    jdField_b_of_type_Int = 9102;
    jdField_c_of_type_Int = 9103;
    jdField_a_of_type_JavaLangString = "GroupCodeZero";
    jdField_d_of_type_Int = 1;
  }
  
  TroopHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_d_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp");
    }
    int i;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (paramToServiceMsg == null)
      {
        i = -1;
        a(71, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(i), Integer.valueOf(-1001) });
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp: req == null || resp == null");
        }
      }
    }
    int k;
    label388:
    label619:
    do
    {
      String str1;
      String str2;
      String str3;
      int j;
      do
      {
        for (;;)
        {
          return;
          i = paramToServiceMsg.extraData.getInt("seq");
          break;
          i = paramToServiceMsg.extraData.getInt("appid");
          str1 = paramToServiceMsg.extraData.getString("openGroupId");
          str2 = paramToServiceMsg.extraData.getString("token");
          str3 = paramToServiceMsg.extraData.getString("url");
          j = paramToServiceMsg.extraData.getInt("seq");
          k = paramFromServiceMsg.getResultCode();
          if (k != 1000) {
            break label619;
          }
          paramFromServiceMsg = new jstoken.RspBody();
          try
          {
            paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if (paramFromServiceMsg.uint32_result.get() == 0) {
              break label388;
            }
            a(71, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(paramToServiceMsg.extraData.getInt("seq")), Integer.valueOf(paramFromServiceMsg.uint32_result.get()) });
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp: rspBody.uint32_result.get():" + paramFromServiceMsg.uint32_result.get());
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            a(71, false, null);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.e("TroopHandler.troop.openapi", 2, "handleTroopOpenApiVerifyRsp, onReceive" + paramToServiceMsg.toString());
      return;
      k = paramFromServiceMsg.uint32_frequency.get();
      paramToServiceMsg = paramFromServiceMsg.bytes_err_info.get().toStringUtf8();
      int m = paramFromServiceMsg.uint32_token_time_out.get();
      Object localObject = paramFromServiceMsg.rpt_bytes_apilist.get();
      paramObject = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramObject.add(((ByteStringMicro)((Iterator)localObject).next()).toStringUtf8());
      }
      a(71, true, new Object[] { Integer.valueOf(i), str1, str2, str3, Integer.valueOf(k), Integer.valueOf(m), paramObject, Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.uint32_result.get()) });
      QLog.d("TroopHandler", 2, "uint32_frequency:" + k + "|erroInfo:" + paramToServiceMsg + "|rpt_bytes_apilist:" + paramFromServiceMsg.rpt_bytes_apilist.get().toString() + "|uint32_result:" + paramFromServiceMsg.uint32_result);
      return;
      a(71, false, new Object[] { Integer.valueOf(0), null, null, null, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(j), Integer.valueOf(-1001) });
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler", 2, "handleTroopOpenApiVerifyRsp: resp.getResultCode():" + k);
  }
  
  private void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = -1;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleTroopShareLink: start");
    }
    TroopShareResp localTroopShareResp = new TroopShareResp();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(0, false, localTroopShareResp);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handlerBindSubAccount: req == null || resp == null");
      }
      return;
    }
    localTroopShareResp.jdField_a_of_type_Boolean = paramToServiceMsg.extraData.getBoolean("isVerify");
    localTroopShareResp.jdField_a_of_type_JavaLangString = paramToServiceMsg.extraData.getString("troopUin");
    if (paramFromServiceMsg.getResultCode() == 1000) {
      paramToServiceMsg = new join_group_link.RspBody();
    }
    for (;;)
    {
      for (;;)
      {
        boolean bool1;
        boolean bool2;
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.error_code.has()) {
            i = paramToServiceMsg.error_code.get();
          }
          if (i == 0) {
            bool1 = true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          bool1 = false;
        }
        try
        {
          if (paramToServiceMsg.group_code.has()) {
            localTroopShareResp.jdField_a_of_type_JavaLangString = String.valueOf(paramToServiceMsg.group_code.get());
          }
          bool2 = bool1;
          if (paramToServiceMsg.url.has())
          {
            localTroopShareResp.jdField_b_of_type_JavaLangString = paramToServiceMsg.url.get();
            bool2 = bool1;
          }
          a(0, bool2, localTroopShareResp);
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, "handleTroopShareLink.errCode:" + localTroopShareResp.jdField_a_of_type_Int + "　troopUin:" + localTroopShareResp.jdField_a_of_type_JavaLangString + " isVerify:" + localTroopShareResp.jdField_a_of_type_Boolean + " shareUrl:" + localTroopShareResp.jdField_b_of_type_JavaLangString);
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopHandler", 2, "handleTroopShareLink: end");
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          label320:
          break label320;
        }
      }
      localTroopShareResp.jdField_a_of_type_Int = i;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleTroopShareLink: RspBody parseFrom byte InvalidProtocolBufferMicroException");
      }
      paramToServiceMsg.printStackTrace();
      bool2 = bool1;
      continue;
      localTroopShareResp.jdField_a_of_type_Int = -1;
      bool2 = false;
    }
  }
  
  /* Error */
  private void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 96
    //   8: iconst_2
    //   9: ldc_w 326
    //   12: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_1
    //   16: ifnull +7 -> 23
    //   19: aload_2
    //   20: ifnonnull +27 -> 47
    //   23: aload_0
    //   24: bipush 113
    //   26: iconst_0
    //   27: aconst_null
    //   28: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   31: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +12 -> 46
    //   37: ldc 96
    //   39: iconst_2
    //   40: ldc_w 328
    //   43: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: return
    //   47: iconst_m1
    //   48: istore 4
    //   50: aload_2
    //   51: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   54: istore 5
    //   56: iload 5
    //   58: sipush 1000
    //   61: if_icmpne +315 -> 376
    //   64: new 330	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework
    //   67: dup
    //   68: invokespecial 331	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:<init>	()V
    //   71: astore_2
    //   72: iload 4
    //   74: istore 5
    //   76: aload_2
    //   77: aload_3
    //   78: checkcast 151	[B
    //   81: checkcast 151	[B
    //   84: invokevirtual 332	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   87: pop
    //   88: iload 4
    //   90: istore 5
    //   92: aload_2
    //   93: getfield 336	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:errinfo	Lcom/tencent/protofile/homework/hw_assign_homework$ErrorInfo;
    //   96: invokevirtual 339	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:has	()Z
    //   99: ifeq +309 -> 408
    //   102: iload 4
    //   104: istore 5
    //   106: aload_2
    //   107: getfield 336	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:errinfo	Lcom/tencent/protofile/homework/hw_assign_homework$ErrorInfo;
    //   110: invokevirtual 342	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: checkcast 338	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo
    //   116: getfield 343	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   122: ifeq +196 -> 318
    //   125: iload 4
    //   127: istore 5
    //   129: aload_2
    //   130: getfield 336	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:errinfo	Lcom/tencent/protofile/homework/hw_assign_homework$ErrorInfo;
    //   133: invokevirtual 342	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 338	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo
    //   139: getfield 343	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: istore 4
    //   147: iload 4
    //   149: istore 5
    //   151: aload_2
    //   152: getfield 336	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:errinfo	Lcom/tencent/protofile/homework/hw_assign_homework$ErrorInfo;
    //   155: invokevirtual 342	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   158: checkcast 338	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo
    //   161: getfield 346	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:error_desc	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   164: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   167: ifeq +157 -> 324
    //   170: iload 4
    //   172: istore 5
    //   174: aload_2
    //   175: getfield 336	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:errinfo	Lcom/tencent/protofile/homework/hw_assign_homework$ErrorInfo;
    //   178: invokevirtual 342	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   181: checkcast 338	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo
    //   184: getfield 346	com/tencent/protofile/homework/hw_assign_homework$ErrorInfo:error_desc	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   187: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   190: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   193: astore_1
    //   194: iload 4
    //   196: ifne +201 -> 397
    //   199: iconst_1
    //   200: istore 6
    //   202: aload_2
    //   203: getfield 350	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:hw_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   206: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   209: ifeq +122 -> 331
    //   212: aload_2
    //   213: getfield 350	com/tencent/protofile/homework/hw_assign_homework$RspAssignHomework:hw_id	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   216: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   219: lstore 7
    //   221: iconst_1
    //   222: istore 6
    //   224: aload_0
    //   225: bipush 113
    //   227: iload 6
    //   229: iconst_2
    //   230: anewarray 103	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: lload 7
    //   237: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: iload 4
    //   245: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: aastore
    //   249: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   252: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq -209 -> 46
    //   258: ldc 96
    //   260: iconst_2
    //   261: new 166	java/lang/StringBuilder
    //   264: dup
    //   265: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   268: ldc_w 357
    //   271: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: iload 4
    //   276: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc_w 359
    //   282: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: aload_1
    //   286: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 361
    //   292: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: lload 7
    //   297: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: ldc_w 366
    //   303: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: iload 6
    //   308: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   311: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: return
    //   318: iconst_m1
    //   319: istore 4
    //   321: goto -174 -> 147
    //   324: ldc_w 368
    //   327: astore_1
    //   328: goto -134 -> 194
    //   331: ldc2_w 42
    //   334: lstore 7
    //   336: goto -115 -> 221
    //   339: astore_2
    //   340: aconst_null
    //   341: astore_1
    //   342: iconst_0
    //   343: istore 6
    //   345: iload 5
    //   347: istore 4
    //   349: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +12 -> 364
    //   355: ldc 96
    //   357: iconst_2
    //   358: ldc_w 370
    //   361: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload_2
    //   365: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   368: ldc2_w 42
    //   371: lstore 7
    //   373: goto -149 -> 224
    //   376: aconst_null
    //   377: astore_1
    //   378: iload 5
    //   380: istore 4
    //   382: iconst_0
    //   383: istore 6
    //   385: ldc2_w 42
    //   388: lstore 7
    //   390: goto -166 -> 224
    //   393: astore_2
    //   394: goto -45 -> 349
    //   397: iconst_0
    //   398: istore 6
    //   400: ldc2_w 42
    //   403: lstore 7
    //   405: goto -181 -> 224
    //   408: aconst_null
    //   409: astore_1
    //   410: goto -216 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	413	0	this	TroopHandler
    //   0	413	1	paramToServiceMsg	ToServiceMsg
    //   0	413	2	paramFromServiceMsg	FromServiceMsg
    //   0	413	3	paramObject	Object
    //   48	333	4	i	int
    //   54	325	5	j	int
    //   200	199	6	bool	boolean
    //   219	185	7	l	long
    // Exception table:
    //   from	to	target	type
    //   76	88	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   92	102	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   106	125	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   129	147	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   151	170	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   174	194	339	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   202	221	393	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleGetHomeworkInfo");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(114, false, null);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleGetHomeworkInfo: req == null || resp == null");
      }
      return;
    }
    int i = paramFromServiceMsg.getResultCode();
    HomeworkInfo localHomeworkInfo = new HomeworkInfo();
    if (i == 1000) {
      paramFromServiceMsg = new hw_get_homework_info.RspGetHomeworkInfo();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.errinfo.has()) {
          break label459;
        }
        if (((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_code.has()) {
          i = ((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_code.get();
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        label290:
        label375:
        label380:
        paramToServiceMsg = null;
        i = -1;
        bool = false;
      }
      for (;;)
      {
        try
        {
          if (((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_desc.has())
          {
            paramToServiceMsg = ((hw_get_homework_info.ErrorInfo)paramFromServiceMsg.errinfo.get()).error_desc.get().toStringUtf8();
            if (i != 0) {
              continue;
            }
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          bool = false;
          paramToServiceMsg = null;
          continue;
          bool = false;
          break label290;
        }
        try
        {
          if (!paramFromServiceMsg.info.has()) {
            break label375;
          }
          paramObject = (value.HomeworkInfo)paramFromServiceMsg.info.get();
          if (paramObject == null) {
            continue;
          }
          if (!paramObject.content.has()) {
            break label380;
          }
          paramFromServiceMsg = paramObject.content.get().toStringUtf8();
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          bool = true;
          continue;
          paramFromServiceMsg = null;
          break;
        }
      }
      localHomeworkInfo.jdField_b_of_type_JavaLangString = paramFromServiceMsg;
      if (paramObject.title.has())
      {
        paramFromServiceMsg = paramObject.title.get();
        localHomeworkInfo.jdField_a_of_type_JavaLangString = paramFromServiceMsg;
        paramFromServiceMsg = localObject;
        if (paramObject.course_name.has()) {
          paramFromServiceMsg = paramObject.course_name.get();
        }
        localHomeworkInfo.d = paramFromServiceMsg;
        bool = true;
        a(114, bool, new Object[] { localHomeworkInfo });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopHandler", 2, "handleGetHomeworkInfo.errCode:" + i + "　erroDesc:" + paramToServiceMsg + ",hwInfo:" + localHomeworkInfo);
        return;
        i = -1;
        continue;
        paramToServiceMsg = "";
        continue;
        paramObject = null;
        continue;
        paramFromServiceMsg = null;
        continue;
      }
      paramFromServiceMsg = null;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleGetHomeworkInfo: RspBody parseFrom byte InvalidProtocolBufferMicroException");
      }
      paramFromServiceMsg.printStackTrace();
      continue;
      paramToServiceMsg = null;
      i = -1;
      boolean bool = false;
      continue;
      label459:
      i = -1;
      paramToServiceMsg = null;
    }
  }
  
  /* Error */
  private void Y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 6
    //   6: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +12 -> 21
    //   12: ldc 96
    //   14: iconst_2
    //   15: ldc_w 421
    //   18: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_1
    //   22: ifnull +7 -> 29
    //   25: aload_2
    //   26: ifnonnull +27 -> 53
    //   29: aload_0
    //   30: bipush 115
    //   32: iconst_0
    //   33: aconst_null
    //   34: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   37: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   40: ifeq +12 -> 52
    //   43: ldc 96
    //   45: iconst_2
    //   46: ldc_w 423
    //   49: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: return
    //   53: aload_2
    //   54: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   57: istore 4
    //   59: iload 4
    //   61: sipush 1000
    //   64: if_icmpne +257 -> 321
    //   67: new 425	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework
    //   70: dup
    //   71: invokespecial 426	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:<init>	()V
    //   74: astore_2
    //   75: aload_2
    //   76: aload_3
    //   77: checkcast 151	[B
    //   80: checkcast 151	[B
    //   83: invokevirtual 427	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   86: pop
    //   87: aload_2
    //   88: getfield 430	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:errinfo	Lcom/tencent/protofile/homework/hw_submit_homework$ErrorInfo;
    //   91: invokevirtual 433	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:has	()Z
    //   94: ifeq +251 -> 345
    //   97: aload_2
    //   98: getfield 430	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:errinfo	Lcom/tencent/protofile/homework/hw_submit_homework$ErrorInfo;
    //   101: invokevirtual 434	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   104: checkcast 432	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo
    //   107: getfield 435	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   113: ifeq +155 -> 268
    //   116: aload_2
    //   117: getfield 430	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:errinfo	Lcom/tencent/protofile/homework/hw_submit_homework$ErrorInfo;
    //   120: invokevirtual 434	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   123: checkcast 432	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo
    //   126: getfield 435	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:error_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: istore 4
    //   134: aload_2
    //   135: getfield 430	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:errinfo	Lcom/tencent/protofile/homework/hw_submit_homework$ErrorInfo;
    //   138: invokevirtual 434	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   141: checkcast 432	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo
    //   144: getfield 436	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:error_desc	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   150: ifeq +124 -> 274
    //   153: aload_2
    //   154: getfield 430	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:errinfo	Lcom/tencent/protofile/homework/hw_submit_homework$ErrorInfo;
    //   157: invokevirtual 434	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   160: checkcast 432	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo
    //   163: getfield 436	com/tencent/protofile/homework/hw_submit_homework$ErrorInfo:error_desc	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   166: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   169: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   172: astore_1
    //   173: iload 4
    //   175: ifne +6 -> 181
    //   178: iconst_1
    //   179: istore 6
    //   181: aload_2
    //   182: getfield 440	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:status	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   185: invokevirtual 443	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   188: ifeq +93 -> 281
    //   191: aload_2
    //   192: getfield 440	com/tencent/protofile/homework/hw_submit_homework$RspSubmitHomework:status	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   195: invokevirtual 444	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   198: istore 5
    //   200: aload_0
    //   201: bipush 115
    //   203: iload 6
    //   205: iload 4
    //   207: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   213: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   216: ifeq -164 -> 52
    //   219: ldc 96
    //   221: iconst_2
    //   222: new 166	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 446
    //   232: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: iload 4
    //   237: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc_w 359
    //   243: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc_w 448
    //   253: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: iload 5
    //   258: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: return
    //   268: iconst_m1
    //   269: istore 4
    //   271: goto -137 -> 134
    //   274: ldc_w 368
    //   277: astore_1
    //   278: goto -105 -> 173
    //   281: iconst_m1
    //   282: istore 5
    //   284: goto -84 -> 200
    //   287: astore_2
    //   288: iconst_0
    //   289: istore 6
    //   291: aconst_null
    //   292: astore_1
    //   293: iconst_m1
    //   294: istore 4
    //   296: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +12 -> 311
    //   302: ldc 96
    //   304: iconst_2
    //   305: ldc_w 450
    //   308: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   311: aload_2
    //   312: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   315: iconst_m1
    //   316: istore 5
    //   318: goto -118 -> 200
    //   321: iconst_0
    //   322: istore 6
    //   324: iconst_m1
    //   325: istore 5
    //   327: aconst_null
    //   328: astore_1
    //   329: goto -129 -> 200
    //   332: astore_2
    //   333: aconst_null
    //   334: astore_1
    //   335: iconst_0
    //   336: istore 6
    //   338: goto -42 -> 296
    //   341: astore_2
    //   342: goto -46 -> 296
    //   345: iconst_m1
    //   346: istore 4
    //   348: aload 7
    //   350: astore_1
    //   351: goto -178 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	this	TroopHandler
    //   0	354	1	paramToServiceMsg	ToServiceMsg
    //   0	354	2	paramFromServiceMsg	FromServiceMsg
    //   0	354	3	paramObject	Object
    //   57	290	4	i	int
    //   198	128	5	j	int
    //   4	333	6	bool	boolean
    //   1	348	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   75	134	287	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   134	173	332	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   181	200	341	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  private void Z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 5
    //   3: aload_2
    //   4: invokevirtual 453	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +635 -> 642
    //   10: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: astore_1
    //   18: aload_1
    //   19: aload_3
    //   20: checkcast 151	[B
    //   23: checkcast 151	[B
    //   26: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   29: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   32: astore_2
    //   33: aload_2
    //   34: astore_1
    //   35: aload_1
    //   36: ifnull +659 -> 695
    //   39: aload_1
    //   40: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   43: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   46: istore 6
    //   48: iload 6
    //   50: istore 4
    //   52: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   55: ifeq +35 -> 90
    //   58: ldc_w 460
    //   61: iconst_2
    //   62: new 166	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 462
    //   72: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload 6
    //   77: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   86: iload 6
    //   88: istore 4
    //   90: iload 4
    //   92: ifne +425 -> 517
    //   95: aload_1
    //   96: ifnull +421 -> 517
    //   99: aload_1
    //   100: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   106: ifeq +411 -> 517
    //   109: aload_1
    //   110: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   113: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   116: ifnull +401 -> 517
    //   119: aload_1
    //   120: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   126: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   129: astore 9
    //   131: aload_0
    //   132: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   135: bipush 51
    //   137: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   140: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   143: astore_2
    //   144: aload_2
    //   145: invokevirtual 483	com/tencent/mobileqq/app/TroopManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   148: astore_1
    //   149: new 485	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   152: dup
    //   153: invokespecial 486	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   156: astore_3
    //   157: aload_3
    //   158: aload 9
    //   160: invokevirtual 487	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   163: pop
    //   164: aload_1
    //   165: invokevirtual 491	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   168: aload_3
    //   169: getfield 494	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   172: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   175: ifeq +338 -> 513
    //   178: aload_3
    //   179: getfield 498	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   182: invokevirtual 503	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   185: ifne +328 -> 513
    //   188: aload_3
    //   189: getfield 498	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   192: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   195: astore 10
    //   197: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   200: ifeq +43 -> 243
    //   203: new 166	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   210: ldc_w 506
    //   213: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: astore 9
    //   218: aload 10
    //   220: ifnonnull +342 -> 562
    //   223: iconst_0
    //   224: istore 4
    //   226: ldc_w 460
    //   229: iconst_2
    //   230: aload 9
    //   232: iload 4
    //   234: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   237: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 10
    //   245: ifnull +264 -> 509
    //   248: aload_3
    //   249: getfield 494	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   252: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   255: lstore 7
    //   257: aload_2
    //   258: lload 7
    //   260: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   263: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   266: astore 9
    //   268: aload 9
    //   270: ifnull +239 -> 509
    //   273: aload 9
    //   275: aload 10
    //   277: invokevirtual 515	com/tencent/mobileqq/data/TroopInfo:setTroopLevelMap787	(Ljava/util/List;)V
    //   280: aload_3
    //   281: getfield 518	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   284: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   287: ifeq +287 -> 574
    //   290: aload_3
    //   291: getfield 518	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_level_name_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   294: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   297: istore 4
    //   299: aload 9
    //   301: iload 4
    //   303: i2l
    //   304: putfield 521	com/tencent/mobileqq/data/TroopInfo:dwGroupLevelSeq	J
    //   307: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +31 -> 341
    //   313: ldc_w 460
    //   316: iconst_2
    //   317: new 166	java/lang/StringBuilder
    //   320: dup
    //   321: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   324: ldc_w 523
    //   327: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: iload 4
    //   332: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   335: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: aload_3
    //   342: getfield 526	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   345: astore 10
    //   347: aload 10
    //   349: ifnull +18 -> 367
    //   352: aload 9
    //   354: aload_3
    //   355: getfield 526	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_owner_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   358: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   361: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   364: putfield 529	com/tencent/mobileqq/data/TroopInfo:ownerNameShow	Ljava/lang/String;
    //   367: aload_3
    //   368: getfield 532	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   371: astore 10
    //   373: aload 10
    //   375: ifnull +18 -> 393
    //   378: aload 9
    //   380: aload_3
    //   381: getfield 532	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:bytes_admin_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   384: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   387: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   390: putfield 535	com/tencent/mobileqq/data/TroopInfo:adminNameShow	Ljava/lang/String;
    //   393: aload_3
    //   394: getfield 538	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   397: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   400: ifeq +289 -> 689
    //   403: aload 9
    //   405: aload_3
    //   406: getfield 538	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_sys_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   409: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   412: i2b
    //   413: putfield 542	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   416: aload 9
    //   418: getfield 542	com/tencent/mobileqq/data/TroopInfo:cGroupRankSysFlag	B
    //   421: istore 4
    //   423: aload_3
    //   424: getfield 545	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   427: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   430: ifeq +23 -> 453
    //   433: aload 9
    //   435: aload_3
    //   436: getfield 545	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint32_user_show_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   439: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   442: i2b
    //   443: putfield 548	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   446: aload 9
    //   448: getfield 548	com/tencent/mobileqq/data/TroopInfo:cGroupRankUserFlag	B
    //   451: istore 5
    //   453: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +47 -> 503
    //   459: ldc_w 460
    //   462: iconst_2
    //   463: new 166	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   470: lload 7
    //   472: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   475: ldc_w 550
    //   478: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: iload 4
    //   483: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   486: ldc_w 552
    //   489: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: iload 5
    //   494: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   497: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload_2
    //   504: aload 9
    //   506: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   509: aload_1
    //   510: invokevirtual 557	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   513: aload_1
    //   514: invokevirtual 559	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   517: return
    //   518: astore_2
    //   519: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +33 -> 555
    //   525: ldc_w 460
    //   528: iconst_2
    //   529: new 166	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 561
    //   539: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_2
    //   543: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   546: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   555: aload_2
    //   556: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   559: goto -524 -> 35
    //   562: aload 10
    //   564: invokeinterface 565 1 0
    //   569: istore 4
    //   571: goto -345 -> 226
    //   574: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq -236 -> 341
    //   580: ldc_w 460
    //   583: iconst_2
    //   584: ldc_w 567
    //   587: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: goto -249 -> 341
    //   593: astore_2
    //   594: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   597: ifeq +33 -> 630
    //   600: ldc_w 460
    //   603: iconst_2
    //   604: new 166	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   611: ldc_w 569
    //   614: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_2
    //   618: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   621: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload_1
    //   631: invokevirtual 559	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   634: return
    //   635: astore_2
    //   636: aload_1
    //   637: invokevirtual 559	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   640: aload_2
    //   641: athrow
    //   642: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq -128 -> 517
    //   648: ldc_w 460
    //   651: iconst_2
    //   652: new 166	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   659: ldc_w 571
    //   662: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload_2
    //   666: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   669: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   672: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: return
    //   679: astore 10
    //   681: goto -288 -> 393
    //   684: astore 10
    //   686: goto -319 -> 367
    //   689: iconst_m1
    //   690: istore 4
    //   692: goto -269 -> 423
    //   695: iconst_m1
    //   696: istore 4
    //   698: goto -608 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	701	0	this	TroopHandler
    //   0	701	1	paramToServiceMsg	ToServiceMsg
    //   0	701	2	paramFromServiceMsg	FromServiceMsg
    //   0	701	3	paramObject	Object
    //   50	647	4	i	int
    //   1	492	5	j	int
    //   46	41	6	k	int
    //   255	216	7	l	long
    //   129	376	9	localObject1	Object
    //   195	368	10	localObject2	Object
    //   679	1	10	localException1	Exception
    //   684	1	10	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   18	33	518	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   149	218	593	java/lang/Exception
    //   226	243	593	java/lang/Exception
    //   248	268	593	java/lang/Exception
    //   273	341	593	java/lang/Exception
    //   341	347	593	java/lang/Exception
    //   367	373	593	java/lang/Exception
    //   393	423	593	java/lang/Exception
    //   423	453	593	java/lang/Exception
    //   453	503	593	java/lang/Exception
    //   503	509	593	java/lang/Exception
    //   509	513	593	java/lang/Exception
    //   562	571	593	java/lang/Exception
    //   574	590	593	java/lang/Exception
    //   149	218	635	finally
    //   226	243	635	finally
    //   248	268	635	finally
    //   273	341	635	finally
    //   341	347	635	finally
    //   352	367	635	finally
    //   367	373	635	finally
    //   378	393	635	finally
    //   393	423	635	finally
    //   423	453	635	finally
    //   453	503	635	finally
    //   503	509	635	finally
    //   509	513	635	finally
    //   562	571	635	finally
    //   574	590	635	finally
    //   594	630	635	finally
    //   378	393	679	java/lang/Exception
    //   352	367	684	java/lang/Exception
  }
  
  private long a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return 0L;
  }
  
  private String a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong + 4294967296L;
    }
    return String.valueOf(l);
  }
  
  public static String a(String paramString)
  {
    return paramString + "_role";
  }
  
  private List a(String paramString, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong == 0L)) {
      return null;
    }
    long l3 = System.currentTimeMillis();
    Object localObject1 = paramString + "_" + paramLong;
    try
    {
      if ((this.jdField_c_of_type_JavaUtilHashMap == null) || (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject1))) {
        return null;
      }
    }
    finally {}
    ArrayList localArrayList2 = (ArrayList)this.jdField_c_of_type_JavaUtilHashMap.remove(localObject1);
    if ((localArrayList2 == null) || (localArrayList2.isEmpty())) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    EntityTransaction localEntityTransaction = localEntityManager.a();
    localEntityTransaction.a();
    stTroopMemberInfo localstTroopMemberInfo;
    label618:
    Object localObject2;
    for (;;)
    {
      try
      {
        Iterator localIterator = localArrayList2.iterator();
        if (!localIterator.hasNext()) {
          break label1503;
        }
        localstTroopMemberInfo = (stTroopMemberInfo)localIterator.next();
        long l2 = localstTroopMemberInfo.MemberUin;
        long l1 = l2;
        if (l2 < 0L) {
          l1 = localstTroopMemberInfo.MemberUin + 4294967296L;
        }
        String str = String.valueOf(l1);
        localObject1 = localEntityManager.a(TroopMemberInfo.class, false, "troopuin=? and memberuin=?", new String[] { paramString, str }, null, null, null, null);
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label1828;
        }
        localObject1 = (TroopMemberInfo)((List)localObject1).get(0);
        if (localObject1 != null) {
          break;
        }
        localObject1 = new TroopMemberInfo();
        ((TroopMemberInfo)localObject1).troopuin = paramString;
        ((TroopMemberInfo)localObject1).memberuin = str;
        ((TroopMemberInfo)localObject1).friendnick = localstTroopMemberInfo.Nick;
        ((TroopMemberInfo)localObject1).pyFirst_friendnick = ChnToSpell.a(((TroopMemberInfo)localObject1).friendnick, 2);
        ((TroopMemberInfo)localObject1).pyAll_friendnick = ChnToSpell.a(((TroopMemberInfo)localObject1).friendnick, 1);
        ((TroopMemberInfo)localObject1).troopnick = localstTroopMemberInfo.sName;
        ((TroopMemberInfo)localObject1).pyFirst_troopnick = ChnToSpell.a(((TroopMemberInfo)localObject1).troopnick, 2);
        ((TroopMemberInfo)localObject1).pyAll_troopnick = ChnToSpell.a(((TroopMemberInfo)localObject1).troopnick, 1);
        ((TroopMemberInfo)localObject1).autoremark = localstTroopMemberInfo.strAutoRemark;
        ((TroopMemberInfo)localObject1).faceid = localstTroopMemberInfo.FaceId;
        ((TroopMemberInfo)localObject1).sex = localstTroopMemberInfo.Gender;
        ((TroopMemberInfo)localObject1).status = localstTroopMemberInfo.Status;
        ((TroopMemberInfo)localObject1).age = localstTroopMemberInfo.Age;
        ((TroopMemberInfo)localObject1).alias = localstTroopMemberInfo.sShowName;
        ((TroopMemberInfo)localObject1).datetime = paramLong;
        ((TroopMemberInfo)localObject1).qqVipInfo = 0;
        ((TroopMemberInfo)localObject1).superQqInfo = 0;
        ((TroopMemberInfo)localObject1).superVipInfo = 0;
        ((TroopMemberInfo)localObject1).realLevel = ((int)localstTroopMemberInfo.dwMemberLevel);
        ((TroopMemberInfo)localObject1).level = ((int)localstTroopMemberInfo.dwTitleId);
        ((TroopMemberInfo)localObject1).join_time = localstTroopMemberInfo.dwJoinTime;
        ((TroopMemberInfo)localObject1).last_active_time = localstTroopMemberInfo.dwLastSpeakTime;
        ((TroopMemberInfo)localObject1).active_point = localstTroopMemberInfo.dwPoint;
        ((TroopMemberInfo)localObject1).credit_level = localstTroopMemberInfo.dwCreditLevel;
        if (localstTroopMemberInfo.cConcerned == 1)
        {
          bool = true;
          ((TroopMemberInfo)localObject1).isTroopFollowed = bool;
          if (localstTroopMemberInfo.cShielded != 1) {
            break label779;
          }
          bool = true;
          ((TroopMemberInfo)localObject1).mIsShielded = bool;
          ((TroopMemberInfo)localObject1).globalTroopLevel = ((int)localstTroopMemberInfo.dwGlobalGroupLevel);
          if ((localstTroopMemberInfo.dwSpecialTitleExpireTime == -1L) || (localstTroopMemberInfo.dwSpecialTitleExpireTime - NetConnInfoCenter.getServerTime() > 0L))
          {
            ((TroopMemberInfo)localObject1).mUniqueTitle = localstTroopMemberInfo.sSpecialTitle;
            ((TroopMemberInfo)localObject1).mUniqueTitleExpire = ((int)localstTroopMemberInfo.dwSpecialTitleExpireTime);
          }
          localEntityManager.a((Entity)localObject1);
          TroopMemberCardInfo localTroopMemberCardInfo = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString, str);
          localObject2 = localTroopMemberCardInfo;
          if (localTroopMemberCardInfo == null)
          {
            localObject2 = new TroopMemberCardInfo();
            ((TroopMemberCardInfo)localObject2).troopuin = paramString;
            ((TroopMemberCardInfo)localObject2).memberuin = str;
          }
          ((TroopMemberCardInfo)localObject2).nick = localstTroopMemberInfo.Nick;
          ((TroopMemberCardInfo)localObject2).name = localstTroopMemberInfo.sName;
          ((TroopMemberCardInfo)localObject2).sex = localstTroopMemberInfo.cGender;
          ((TroopMemberCardInfo)localObject2).tel = localstTroopMemberInfo.sPhone;
          ((TroopMemberCardInfo)localObject2).email = localstTroopMemberInfo.sEmail;
          ((TroopMemberCardInfo)localObject2).memo = localstTroopMemberInfo.sMemo;
          ((TroopMemberCardInfo)localObject2).job = localstTroopMemberInfo.bytes_job;
          DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (TroopMemberCardInfo)localObject2);
          localArrayList1.add(localObject1);
          continue;
        }
        bool = false;
      }
      finally
      {
        localEntityManager.a();
        localEntityTransaction.b();
      }
      continue;
      label779:
      bool = false;
    }
    if ((localstTroopMemberInfo.Nick == null) || (localstTroopMemberInfo.Nick.length() == 0))
    {
      ((TroopMemberInfo)localObject1).pyFirst_friendnick = "";
      ((TroopMemberInfo)localObject1).pyAll_friendnick = "";
      label820:
      ((TroopMemberInfo)localObject1).friendnick = localstTroopMemberInfo.Nick;
      if ((localstTroopMemberInfo.sName != null) && (localstTroopMemberInfo.sName.length() != 0)) {
        break label1271;
      }
      ((TroopMemberInfo)localObject1).pyFirst_troopnick = "";
      ((TroopMemberInfo)localObject1).pyAll_troopnick = "";
      label865:
      ((TroopMemberInfo)localObject1).troopnick = localstTroopMemberInfo.sName;
      if ((localstTroopMemberInfo.strAutoRemark != null) && (localstTroopMemberInfo.strAutoRemark.length() != 0)) {
        break label1387;
      }
      ((TroopMemberInfo)localObject1).pyFirst_autoremark = "";
      ((TroopMemberInfo)localObject1).pyAll_autoremark = "";
      label910:
      ((TroopMemberInfo)localObject1).autoremark = localstTroopMemberInfo.strAutoRemark;
      ((TroopMemberInfo)localObject1).faceid = localstTroopMemberInfo.FaceId;
      ((TroopMemberInfo)localObject1).sex = localstTroopMemberInfo.Gender;
      ((TroopMemberInfo)localObject1).status = localstTroopMemberInfo.Status;
      ((TroopMemberInfo)localObject1).age = localstTroopMemberInfo.Age;
      ((TroopMemberInfo)localObject1).alias = localstTroopMemberInfo.sShowName;
      ((TroopMemberInfo)localObject1).datetime = paramLong;
      ((TroopMemberInfo)localObject1).realLevel = ((int)localstTroopMemberInfo.dwMemberLevel);
      if (localstTroopMemberInfo.dwTitleId > 0L) {
        ((TroopMemberInfo)localObject1).level = ((int)localstTroopMemberInfo.dwTitleId);
      }
      ((TroopMemberInfo)localObject1).join_time = localstTroopMemberInfo.dwJoinTime;
      ((TroopMemberInfo)localObject1).last_active_time = localstTroopMemberInfo.dwLastSpeakTime;
      ((TroopMemberInfo)localObject1).active_point = localstTroopMemberInfo.dwPoint;
      ((TroopMemberInfo)localObject1).credit_level = localstTroopMemberInfo.dwCreditLevel;
      if (localstTroopMemberInfo.cConcerned != 1) {
        break label1834;
      }
      bool = true;
      label1060:
      ((TroopMemberInfo)localObject1).isTroopFollowed = bool;
      if (localstTroopMemberInfo.cShielded != 1) {
        break label1840;
      }
    }
    label1828:
    label1834:
    label1840:
    for (boolean bool = true;; bool = false)
    {
      ((TroopMemberInfo)localObject1).mIsShielded = bool;
      if ((localstTroopMemberInfo.dwSpecialTitleExpireTime == -1L) || (localstTroopMemberInfo.dwSpecialTitleExpireTime - NetConnInfoCenter.getServerTime() > 0L))
      {
        ((TroopMemberInfo)localObject1).mUniqueTitle = localstTroopMemberInfo.sSpecialTitle;
        ((TroopMemberInfo)localObject1).mUniqueTitleExpire = ((int)localstTroopMemberInfo.dwSpecialTitleExpireTime);
      }
      ((TroopMemberInfo)localObject1).globalTroopLevel = ((int)localstTroopMemberInfo.dwGlobalGroupLevel);
      localEntityManager.a((Entity)localObject1);
      break label618;
      if (!localstTroopMemberInfo.Nick.equals(((TroopMemberInfo)localObject1).friendnick))
      {
        ((TroopMemberInfo)localObject1).pyFirst_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 2);
        ((TroopMemberInfo)localObject1).pyAll_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 1);
        break label820;
      }
      if ((((TroopMemberInfo)localObject1).pyFirst_friendnick == null) || (((TroopMemberInfo)localObject1).pyFirst_friendnick.length() == 0)) {
        ((TroopMemberInfo)localObject1).pyFirst_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 2);
      }
      if ((((TroopMemberInfo)localObject1).pyAll_friendnick != null) && (((TroopMemberInfo)localObject1).pyAll_friendnick.length() != 0)) {
        break label820;
      }
      ((TroopMemberInfo)localObject1).pyAll_friendnick = ChnToSpell.a(localstTroopMemberInfo.Nick, 1);
      break label820;
      label1271:
      if (!localstTroopMemberInfo.sName.equals(((TroopMemberInfo)localObject1).troopnick))
      {
        ((TroopMemberInfo)localObject1).pyFirst_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 2);
        ((TroopMemberInfo)localObject1).pyAll_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 1);
        break label865;
      }
      if ((((TroopMemberInfo)localObject1).pyFirst_troopnick == null) || (((TroopMemberInfo)localObject1).pyFirst_troopnick.length() == 0)) {
        ((TroopMemberInfo)localObject1).pyFirst_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 2);
      }
      if ((((TroopMemberInfo)localObject1).pyAll_troopnick != null) && (((TroopMemberInfo)localObject1).pyAll_troopnick.length() != 0)) {
        break label865;
      }
      ((TroopMemberInfo)localObject1).pyAll_troopnick = ChnToSpell.a(localstTroopMemberInfo.sName, 1);
      break label865;
      label1387:
      if (!localstTroopMemberInfo.strAutoRemark.equals(((TroopMemberInfo)localObject1).autoremark))
      {
        ((TroopMemberInfo)localObject1).pyFirst_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 2);
        ((TroopMemberInfo)localObject1).pyAll_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 1);
        break label910;
      }
      if ((((TroopMemberInfo)localObject1).pyFirst_autoremark == null) || (((TroopMemberInfo)localObject1).pyFirst_autoremark.length() == 0)) {
        ((TroopMemberInfo)localObject1).pyFirst_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 2);
      }
      if ((((TroopMemberInfo)localObject1).pyAll_autoremark != null) && (((TroopMemberInfo)localObject1).pyAll_autoremark.length() != 0)) {
        break label910;
      }
      ((TroopMemberInfo)localObject1).pyAll_autoremark = ChnToSpell.a(localstTroopMemberInfo.strAutoRemark, 1);
      break label910;
      label1503:
      localEntityTransaction.c();
      localEntityManager.a();
      localEntityTransaction.b();
      paramString = localArrayList2.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (stTroopMemberInfo)paramString.next();
        localObject2 = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if (localObject2 != null)
        {
          localObject2 = ((ApolloManager)localObject2).b(((stTroopMemberInfo)localObject1).MemberUin + "");
          if ((localObject2 != null) && ((((ApolloBaseInfo)localObject2).apolloStatus != ((stTroopMemberInfo)localObject1).cApolloFlag) || (((ApolloBaseInfo)localObject2).apolloServerTS != ((stTroopMemberInfo)localObject1).dwApolloTimestamp)))
          {
            ((ApolloBaseInfo)localObject2).apolloStatus = ((stTroopMemberInfo)localObject1).cApolloFlag;
            ((ApolloBaseInfo)localObject2).apolloServerTS = ((stTroopMemberInfo)localObject1).dwApolloTimestamp;
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject2);
            if ((QLog.isColorLevel()) && (((ApolloBaseInfo)localObject2).uin.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
              QLog.d("TroopHandler", 2, "troop handler apollo status: " + ((ApolloBaseInfo)localObject2).apolloStatus + ", apollo svr ts: " + ((ApolloBaseInfo)localObject2).apolloServerTS);
            }
          }
        }
      }
      ((ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).b(this.jdField_b_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      paramLong = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "processDataInRsp2TroopMemberList, Thread id:" + Thread.currentThread().getId() + ",threadName:" + Thread.currentThread().getName() + ", cost:" + (paramLong - l3));
      }
      return localArrayList1;
      localObject1 = null;
      break;
      bool = false;
      break label1060;
    }
  }
  
  public static oidb_0xae6.ReqBody a(int paramInt1, int paramInt2, String paramString, MsgInfo paramMsgInfo1, MsgInfo paramMsgInfo2)
  {
    oidb_0xae6.ReqBody localReqBody = new oidb_0xae6.ReqBody();
    localReqBody.type.set(paramInt1);
    Object localObject = localReqBody.source;
    if (paramInt2 == 3000) {}
    for (paramInt1 = 2;; paramInt1 = 1)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      if (paramMsgInfo1 != null)
      {
        localObject = new oidb_0xae6.MsgInfo();
        ((oidb_0xae6.MsgInfo)localObject).uin.set(paramMsgInfo1.jdField_a_of_type_Long);
        ((oidb_0xae6.MsgInfo)localObject).seq.set(paramMsgInfo1.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(paramMsgInfo1.jdField_a_of_type_JavaLangString)) {
          ((oidb_0xae6.MsgInfo)localObject).pic.set(paramMsgInfo1.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramMsgInfo1.jdField_b_of_type_JavaLangString)) {
          ((oidb_0xae6.MsgInfo)localObject).content.set(paramMsgInfo1.jdField_b_of_type_JavaLangString);
        }
        localReqBody.quote_msg_info.set((MessageMicro)localObject);
      }
      if (paramMsgInfo2 != null)
      {
        localObject = new oidb_0xae6.MsgInfo();
        ((oidb_0xae6.MsgInfo)localObject).uin.set(paramMsgInfo2.jdField_a_of_type_Long);
        ((oidb_0xae6.MsgInfo)localObject).seq.set(paramMsgInfo2.jdField_a_of_type_Int);
        if (!TextUtils.isEmpty(paramMsgInfo2.jdField_a_of_type_JavaLangString)) {
          ((oidb_0xae6.MsgInfo)localObject).pic.set(paramMsgInfo2.jdField_a_of_type_JavaLangString);
        }
        if (!TextUtils.isEmpty(paramMsgInfo2.jdField_b_of_type_JavaLangString)) {
          ((oidb_0xae6.MsgInfo)localObject).content.set(paramMsgInfo2.jdField_b_of_type_JavaLangString);
        }
        localReqBody.comment_msg_info.set((MessageMicro)localObject);
      }
      try
      {
        localReqBody.group_id.set(Long.valueOf(paramString).longValue());
        if (QLog.isColorLevel()) {
          QLog.i("zivonchen", 2, "construct0xae6ReqBody ok. istroop = " + paramInt2 + ", troopUin = " + paramString + ", sourceMsg = " + paramMsgInfo1 + ", commentMsg = " + paramMsgInfo2);
        }
        return localReqBody;
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          break label396;
        }
        QLog.i("zivonchen", 2, "construct0xae6ReqBody error! istroop = " + paramInt2 + ", troopUin = " + paramString + ", sourceMsg = " + paramMsgInfo1 + ", commentMsg = " + paramMsgInfo2 + ", errorMsg = " + QLog.getStackTraceString(localException));
      }
    }
    label396:
    return null;
  }
  
  private void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool = false;
    zlu localzlu = new zlu();
    localzlu.jdField_a_of_type_Long = paramIntent.getLongExtra("TroopUin", 0L);
    localzlu.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("isClear", false);
    localzlu.jdField_b_of_type_Int = paramIntent.getIntExtra("lat", 0);
    localzlu.jdField_c_of_type_Int = paramIntent.getIntExtra("lon", 0);
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramIntent = new GroupLocation.SetGroupLocationRes();
        paramIntent.mergeFrom(paramArrayOfByte);
        localzlu.jdField_a_of_type_Int = paramIntent.result.get();
        if (localzlu.jdField_a_of_type_Int != 0) {
          break label213;
        }
        localzlu.jdField_a_of_type_JavaLangString = paramIntent.grouplocation.get();
        paramIntent = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (paramIntent != null)
        {
          paramFromServiceMsg = paramIntent.a("" + localzlu.jdField_a_of_type_Long);
          paramFromServiceMsg.strLocation = localzlu.jdField_a_of_type_JavaLangString;
          paramIntent.b(paramFromServiceMsg);
        }
        bool = true;
      }
      catch (Exception paramIntent)
      {
        localzlu.jdField_a_of_type_Int = -1;
        continue;
      }
      a(15, bool, localzlu);
      return;
      localzlu.jdField_a_of_type_Int = paramFromServiceMsg.getResultCode();
      continue;
      label213:
      bool = false;
    }
  }
  
  private void a(TroopAIOAppInfo paramTroopAIOAppInfo, cmd0xca02.Result paramResult)
  {
    paramTroopAIOAppInfo.appid = paramResult.uint32_id.get();
    paramTroopAIOAppInfo.name = paramResult.string_name.get().toStringUtf8();
    paramTroopAIOAppInfo.canRemove = paramResult.bool_can_remove.get();
    paramTroopAIOAppInfo.hashVal = paramResult.string_hash_val.get().toStringUtf8();
    paramTroopAIOAppInfo.redPoint = paramResult.bool_red_point.get();
    paramTroopAIOAppInfo.iconUrl = paramResult.string_icon.get().toStringUtf8();
    paramTroopAIOAppInfo.url = paramResult.string_url.get().toStringUtf8();
    if (((cmd0xca02.AppInfo)paramResult.msg_app_info.get()).plat_type.get() == 2) {
      paramTroopAIOAppInfo.minVersion = ((cmd0xca02.AppInfo)paramResult.msg_app_info.get()).str_app_version.get();
    }
    if (!TroopAIOAppInfo.checkVersion(paramTroopAIOAppInfo.minVersion)) {
      paramTroopAIOAppInfo.minVersion = "0";
    }
    paramTroopAIOAppInfo.identifyMask = paramResult.uint32_identify_visibilty.get();
  }
  
  private void a(oidb_0x496.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.msg_group_msg_config;
    if ((paramRspBody.has()) && (paramRspBody.bool_uin_enable.has()) && (paramRspBody.uint32_max_aio_msg.has()) && (paramRspBody.uint32_enable_helper.has()) && (paramRspBody.uint32_group_max_number.has()))
    {
      TroopMessageManager localTroopMessageManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      localTroopMessageManager.jdField_a_of_type_Boolean = paramRspBody.bool_uin_enable.get();
      localTroopMessageManager.jdField_a_of_type_Int = paramRspBody.uint32_max_aio_msg.get();
      localTroopMessageManager.jdField_b_of_type_Int = paramRspBody.uint32_group_max_number.get();
      localTroopMessageManager.jdField_c_of_type_Int = paramRspBody.uint32_enable_helper.get();
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetMultiTroopInfoResp paramGetMultiTroopInfoResp)
  {
    int j = 0;
    if (paramGetMultiTroopInfoResp == null)
    {
      a(3, false, null);
      return;
    }
    if (paramFromServiceMsg == null)
    {
      a(3, false, null);
      return;
    }
    if (paramGetMultiTroopInfoResp.result != 0)
    {
      a(3, false, null);
      return;
    }
    TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    ArrayList localArrayList = new ArrayList();
    long l = System.currentTimeMillis();
    int i = j;
    if (paramGetMultiTroopInfoResp.vecTroopInfo != null)
    {
      i = j;
      if (paramGetMultiTroopInfoResp.vecTroopInfo.size() > 0)
      {
        Iterator localIterator = paramGetMultiTroopInfoResp.vecTroopInfo.iterator();
        i = 0;
        while (localIterator.hasNext())
        {
          stTroopInfoV2 localstTroopInfoV2 = (stTroopInfoV2)localIterator.next();
          paramGetMultiTroopInfoResp = localTroopManager.a(String.valueOf(localstTroopInfoV2.dwGroupCode));
          paramFromServiceMsg = paramGetMultiTroopInfoResp;
          if (paramGetMultiTroopInfoResp == null)
          {
            paramFromServiceMsg = new TroopInfo();
            paramFromServiceMsg.troopuin = String.valueOf(localstTroopInfoV2.dwGroupCode);
          }
          paramFromServiceMsg.troopcode = String.valueOf(localstTroopInfoV2.dwGroupUin);
          if (paramFromServiceMsg.troopcode != null)
          {
            j = i;
            if (!paramFromServiceMsg.troopcode.equals("0")) {}
          }
          else
          {
            j = 1;
          }
          paramFromServiceMsg.troopname = localstTroopInfoV2.strGroupName;
          paramFromServiceMsg.troopmemo = localstTroopInfoV2.strGroupMemo;
          paramFromServiceMsg.fingertroopmemo = localstTroopInfoV2.strFingerMemo;
          paramFromServiceMsg.troopowneruin = Long.toString(localstTroopInfoV2.dwGroupOwnerUin);
          paramFromServiceMsg.dwGroupClassExt = localstTroopInfoV2.dwGroupClassExt;
          paramFromServiceMsg.troopface = ((short)localstTroopInfoV2.wGroupFace);
          paramFromServiceMsg.cGroupOption = ((short)localstTroopInfoV2.cGroupOption);
          paramFromServiceMsg.wMemberNum = localstTroopInfoV2.memberNum;
          paramFromServiceMsg.timeSec = l;
          paramFromServiceMsg.dwGroupFlagExt = localstTroopInfoV2.dwGroupFlagExt;
          paramFromServiceMsg.dwAuthGroupType = localstTroopInfoV2.dwCertificationType;
          localArrayList.add(paramFromServiceMsg);
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("refreshTroopList", 2, "handleMultiTroopInfo save troop " + paramFromServiceMsg.troopuin + " troopcode:" + paramFromServiceMsg.troopcode);
            i = j;
          }
        }
        localTroopManager.a(localArrayList, l);
      }
    }
    if (i != 0) {
      a(jdField_b_of_type_Int);
    }
    a(3, true, localArrayList);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetTroopAppointRemarkResp paramGetTroopAppointRemarkResp)
  {
    if (paramFromServiceMsg == null) {
      a(11, false, null);
    }
    do
    {
      do
      {
        return;
      } while (paramGetTroopAppointRemarkResp == null);
      try
      {
        if (paramGetTroopAppointRemarkResp.result != 0)
        {
          a(11, false, null);
          return;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        a(11, false, null);
        return;
      }
      paramFromServiceMsg = paramGetTroopAppointRemarkResp.vecTroopRemark;
    } while (paramFromServiceMsg == null);
    paramFromServiceMsg = DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(paramGetTroopAppointRemarkResp.GroupCode), paramFromServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("handlerGetTroopMemberCardInfoList", 2, "bRet = " + paramFromServiceMsg[1]);
    }
    a(11, true, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GroupMngRes paramGroupMngRes)
  {
    Object localObject1 = paramGroupMngRes.vecBody;
    paramToServiceMsg = new TroopInfo();
    try
    {
      localObject1 = ByteBuffer.wrap((byte[])localObject1);
      paramToServiceMsg.troopcode = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.troopuin = String.valueOf(((ByteBuffer)localObject1).getInt() & 0xFFFFFFFF);
      paramToServiceMsg.strLocation = paramGroupMngRes.sGroupLocation;
      paramToServiceMsg.troopAuthenticateInfo = paramGroupMngRes.sAuthGrpInfo;
      paramToServiceMsg.joinTroopQuestion = paramGroupMngRes.sJoinQuestion;
      paramToServiceMsg.joinTroopAnswer = paramGroupMngRes.sJoinAnswer;
      while (((ByteBuffer)localObject1).remaining() > 0)
      {
        i = ((ByteBuffer)localObject1).get();
        ((ByteBuffer)localObject1).remaining();
        switch (i & 0xFF)
        {
        case 6: 
        case 10: 
        case 15: 
        case 17: 
          i = ((ByteBuffer)localObject1).get() & 0xFF;
          ((ByteBuffer)localObject1).get(new byte[i], 0, i);
        }
      }
    }
    catch (BufferUnderflowException localBufferUnderflowException)
    {
      for (;;)
      {
        int i;
        localBufferUnderflowException.printStackTrace();
        TroopInfo localTroopInfo = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramToServiceMsg.troopuin);
        Object localObject2;
        if (localTroopInfo != null)
        {
          localTroopInfo.trooptype = paramToServiceMsg.trooptype;
          localTroopInfo.troopCreateTime = paramToServiceMsg.troopCreateTime;
          localTroopInfo.dwGroupFlag = paramToServiceMsg.dwGroupFlag;
          localTroopInfo.troopowneruin = paramToServiceMsg.troopowneruin;
          localTroopInfo.cGroupOption = paramToServiceMsg.cGroupOption;
          localTroopInfo.dwGroupClassExt = paramToServiceMsg.dwGroupClassExt;
          localTroopInfo.wMemberMax = paramToServiceMsg.wMemberMax;
          localTroopInfo.wSpecialClass = paramToServiceMsg.wSpecialClass;
          localTroopInfo.cGroupLevel = paramToServiceMsg.cGroupLevel;
          localTroopInfo.troopname = paramToServiceMsg.troopname;
          localTroopInfo.troopface = paramToServiceMsg.troopface;
          localTroopInfo.fingertroopmemo = paramToServiceMsg.fingertroopmemo;
          localTroopInfo.wMemberNum = paramToServiceMsg.wMemberNum;
          localTroopInfo.strLocation = paramToServiceMsg.strLocation;
          localTroopInfo.dwGroupFlagExt = paramToServiceMsg.dwGroupFlagExt;
          localTroopInfo.troopAuthenticateInfo = paramToServiceMsg.troopAuthenticateInfo;
          localTroopInfo.joinTroopQuestion = paramToServiceMsg.joinTroopQuestion;
          localTroopInfo.joinTroopAnswer = paramToServiceMsg.joinTroopAnswer;
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
          ((EntityManager)localObject2).a(localTroopInfo);
          ((EntityManager)localObject2).a();
        }
        for (boolean bool = true;; bool = false)
        {
          a(7, true, new Object[] { Byte.valueOf(paramGroupMngRes.result), paramToServiceMsg, Boolean.valueOf(bool) });
          return;
          localTroopInfo.get();
          paramToServiceMsg.trooptype = (localTroopInfo.get() & 0xFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopCreateTime = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupFlag = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopowneruin = String.valueOf(localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.cGroupOption = ((short)(localTroopInfo.get() & 0xFF));
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupClassExt = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wMemberMax = (localTroopInfo.getShort() & 0xFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wSpecialClass = (localTroopInfo.getShort() & 0xFFFF);
          break;
          localTroopInfo.get();
          paramToServiceMsg.cGroupLevel = ((short)(localTroopInfo.get() & 0xFF));
          break;
          localTroopInfo.get();
          paramToServiceMsg.dwGroupFlagExt = (localTroopInfo.getInt() & 0xFFFFFFFF);
          break;
          i = localTroopInfo.get() & 0xFF;
          localObject2 = new byte[i];
          localTroopInfo.get((byte[])localObject2, 0, i);
          paramToServiceMsg.troopname = PkgTools.b((byte[])localObject2, 0, i);
          break;
          localTroopInfo.get();
          paramToServiceMsg.troopface = ((short)(localTroopInfo.getShort() & 0xFFFF));
          break;
          i = localTroopInfo.get() & 0xFF;
          localObject2 = new byte[i];
          localTroopInfo.get((byte[])localObject2, 0, i);
          paramToServiceMsg.fingertroopmemo = PkgTools.b((byte[])localObject2, 0, i);
          break;
          localTroopInfo.get();
          paramToServiceMsg.wMemberNum = (localTroopInfo.getShort() & 0xFFFF);
          break;
          TroopSystemMsgUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramToServiceMsg.troopuin, paramToServiceMsg.troopname);
          TroopSystemMsgUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramToServiceMsg.troopuin, paramToServiceMsg.dwGroupFlagExt);
          TroopSystemMsgUtil.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramToServiceMsg.troopuin, paramToServiceMsg.joinTroopQuestion);
          TroopSystemMsgUtil.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), paramToServiceMsg.troopuin, paramToServiceMsg.joinTroopAnswer);
        }
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramToServiceMsg.extraData.getInt("groupreqtype");
    String str1 = paramToServiceMsg.extraData.getString("troop_uin");
    GroupMngRes localGroupMngRes;
    if (paramFromServiceMsg.isSuccess())
    {
      localGroupMngRes = (GroupMngRes)a(paramFromServiceMsg.getWupBuffer(), "GroupMngRes", new GroupMngRes());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("handleGroupManager: groupreqType = ").append(j).append(", troopCode = ").append(str1).append(", res.isSucc=").append(paramFromServiceMsg.isSuccess()).append(", resp.ret=");
        if (localGroupMngRes != null) {
          break label246;
        }
      }
    }
    label246:
    for (int i = -1;; i = localGroupMngRes.result)
    {
      QLog.d("TroopHandler", 2, i);
      switch (j)
      {
      default: 
        a(6, false, new Object[] { Integer.valueOf(j), Byte.valueOf(-1) });
        return;
        a(6, false, new Object[] { Integer.valueOf(j), Byte.valueOf(-1) });
        return;
      }
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      a(paramToServiceMsg, localGroupMngRes);
      return;
    }
    a(7, paramFromServiceMsg.isSuccess(), new Object[] { Byte.valueOf(localGroupMngRes.result), null, Boolean.valueOf(false) });
    return;
    Object localObject1 = paramToServiceMsg.extraData.getString("troop_uin");
    Object localObject2 = paramToServiceMsg.extraData.getStringArrayList("frie_uins");
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0) && (str1 != null) && (localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject1 = paramFromServiceMsg.a((String)localObject1);
      localObject2 = ((ArrayList)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str2 = (String)((Iterator)localObject2).next();
        TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)paramToServiceMsg.a(TroopMemberInfo.class, "troopuin=? and memberuin=?", new String[] { str1, str2 });
        if (localTroopMemberInfo != null)
        {
          paramToServiceMsg.b(localTroopMemberInfo);
          if (((TroopInfo)localObject1).wMemberNum > 0) {
            ((TroopInfo)localObject1).wMemberNum -= 1;
          }
          if ((((TroopInfo)localObject1).Administrator != null) && (((TroopInfo)localObject1).Administrator.contains(str2))) {
            ((TroopInfo)localObject1).Administrator.replace(str2, "");
          }
        }
      }
      paramFromServiceMsg.b((TroopInfo)localObject1);
      paramToServiceMsg.a();
      a(6, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(6, false, new Object[] { Integer.valueOf(j), Byte.valueOf(b1) });
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      a(6, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(6, false, new Object[] { Integer.valueOf(j), Byte.valueOf(b1) });
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 1);
      paramToServiceMsg.b(str1);
      DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      a(6, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(6, false, new Object[] { Integer.valueOf(j), Byte.valueOf(b1) });
      return;
    }
    if ((j == 4) || (j == 5)) {
      if (paramFromServiceMsg.isSuccess()) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(String.valueOf(AppConstants.F), 0).edit().putInt(paramToServiceMsg.extraData.getString("Request_uin") + "_answer_joined_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L), j).commit();
      }
    }
    while ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      a(6, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
      if (((j == 6) || (j == 7)) && (paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
      {
        i = 0;
        if (j == 6)
        {
          if (1 != localGroupMngRes.cIsMemInvite) {
            break label1331;
          }
          i = 1;
          label1100:
          if (i == 0)
          {
            localObject1 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            if (((TroopManager)localObject1).a(paramToServiceMsg.extraData.getString("troop_uin")) == null)
            {
              localObject2 = new TroopInfo();
              ((TroopInfo)localObject2).troopuin = String.valueOf(paramToServiceMsg.extraData.getString("troop_uin"));
              ((TroopManager)localObject1).a((TroopInfo)localObject2);
              ((TroopHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(((TroopInfo)localObject2).troopuin, (byte)1, ((TroopInfo)localObject2).dwTimeStamp, 0);
            }
          }
        }
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(String.valueOf(AppConstants.F), 0).edit();
        paramToServiceMsg = paramToServiceMsg.extraData.getString("Request_uin") + "_member_answer_joined_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
        ((SharedPreferences.Editor)localObject1).putInt(paramToServiceMsg, j);
        if (j == 6) {
          if (i == 0) {
            break label1337;
          }
        }
        label1331:
        label1337:
        for (i = 1;; i = 0)
        {
          ((SharedPreferences.Editor)localObject1).putInt(a(paramToServiceMsg), i);
          ((SharedPreferences.Editor)localObject1).commit();
          break;
          i = 0;
          break label1100;
        }
      }
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(6, false, new Object[] { Integer.valueOf(j), Byte.valueOf(b1) });
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (localGroupMngRes.result == 0))
    {
      paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str1, 1);
      paramToServiceMsg.b(str1);
      DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      a(6, true, new Object[] { Integer.valueOf(localGroupMngRes.reqtype), Byte.valueOf(localGroupMngRes.result), str1 });
      return;
    }
    if (paramFromServiceMsg.isSuccess()) {}
    for (b1 = localGroupMngRes.result;; b1 = -1)
    {
      a(6, false, new Object[] { Integer.valueOf(j), Byte.valueOf(b1) });
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, ModifyGroupCardResp paramModifyGroupCardResp)
  {
    if (paramFromServiceMsg == null)
    {
      a(10, false, null);
      return;
    }
    if (paramModifyGroupCardResp == null)
    {
      a(10, false, null);
      return;
    }
    if (paramToServiceMsg == null)
    {
      a(10, false, null);
      return;
    }
    if (paramModifyGroupCardResp.result != 0)
    {
      a(10, false, null);
      return;
    }
    paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("vecUinInfo");
    long l = paramToServiceMsg.extraData.getLong("dwGroupCode");
    paramToServiceMsg.extraData.getLong("dwZero");
    paramToServiceMsg.extraData.getLong("dwNewSeq");
    a(10, true, DBUtils.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(l), paramFromServiceMsg));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, ModifyGroupInfoResp paramModifyGroupInfoResp)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null))
    {
      a(12, false, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null });
      return;
    }
    long l = paramToServiceMsg.extraData.getLong("dwGroupCode");
    int i = paramToServiceMsg.extraData.getInt("modify_troopinfo_flag");
    TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = localTroopManager.a(Long.toString(l));
    if ((paramModifyGroupInfoResp == null) || (l != paramModifyGroupInfoResp.dwGroupCode) || (paramModifyGroupInfoResp.result != 0))
    {
      a(12, false, new Object[] { Long.valueOf(l), Integer.valueOf(i), localTroopInfo });
      return;
    }
    paramFromServiceMsg = localTroopInfo;
    if (localTroopInfo == null)
    {
      paramFromServiceMsg = new TroopInfo();
      paramFromServiceMsg.troopuin = Long.toString(l);
    }
    paramFromServiceMsg.troopname = paramToServiceMsg.extraData.getString("strGroupName");
    paramFromServiceMsg.dwGroupClassExt = paramToServiceMsg.extraData.getLong("dwGroupClass");
    paramFromServiceMsg.cGroupOption = ((short)(int)paramToServiceMsg.extraData.getLong("cGroupOption"));
    paramFromServiceMsg.troopmemo = paramToServiceMsg.extraData.getString("strGroupMemo");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("strFingerMemo");
    try
    {
      paramModifyGroupInfoResp = paramToServiceMsg.getBytes("utf-8");
      if (paramModifyGroupInfoResp.length > 120) {}
      for (paramFromServiceMsg.fingertroopmemo = SubString.a(paramModifyGroupInfoResp, 120);; paramFromServiceMsg.fingertroopmemo = paramToServiceMsg)
      {
        paramFromServiceMsg.mRichFingerMemo = paramToServiceMsg;
        paramFromServiceMsg.setOnlyTroopMemberInviteOption(false);
        localTroopManager.b(paramFromServiceMsg);
        a(12, true, new Object[] { Long.valueOf(l), Integer.valueOf(i), paramFromServiceMsg });
        return;
      }
    }
    catch (IOException paramModifyGroupInfoResp)
    {
      for (;;)
      {
        paramModifyGroupInfoResp.printStackTrace();
        paramFromServiceMsg.fingertroopmemo = "";
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopListRespV2 paramGetTroopListRespV2)
  {
    if (paramGetTroopListRespV2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.getTroopList", 2, "handle get troop list resp, resp == null");
      }
      a(2, false, null);
    }
    boolean bool;
    int i;
    label166:
    label195:
    label255:
    Object localObject3;
    label260:
    label265:
    label270:
    label275:
    long l;
    ArrayList localArrayList;
    TroopManager localTroopManager;
    Object localObject2;
    Object localObject5;
    Object localObject4;
    label551:
    label582:
    label605:
    do
    {
      return;
      if ((paramGetTroopListRespV2.vecTroopList == null) && (paramGetTroopListRespV2.vecTroopListDel == null) && (paramGetTroopListRespV2.vecTroopRank == null) && (paramGetTroopListRespV2.vecFavGroup == null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopList", 2, "handle get troop list resp, vecTroopList == null, vecTroopListDel == null, vecTroopRank == null, vecFavGroup == null");
        }
        jdField_a_of_type_Boolean = true;
        if (paramGetTroopListRespV2.errorCode == 0) {}
        for (bool = true;; bool = false)
        {
          a(2, bool, null);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder().append("handle get troop list resp, changeNum: ");
        if (paramGetTroopListRespV2.vecTroopList == null) {
          break label255;
        }
        i = paramGetTroopListRespV2.vecTroopList.size();
        localObject1 = ((StringBuilder)localObject1).append(i).append(" deleteNum: ");
        if (paramGetTroopListRespV2.vecTroopListDel == null) {
          break label260;
        }
        i = paramGetTroopListRespV2.vecTroopListDel.size();
        localObject1 = ((StringBuilder)localObject1).append(i).append(" LevelInfoNum: ");
        if (paramGetTroopListRespV2.vecTroopRank == null) {
          break label265;
        }
        i = paramGetTroopListRespV2.vecTroopRank.size();
        localObject1 = ((StringBuilder)localObject1).append(i).append(" FavGroupNum: ");
        if (paramGetTroopListRespV2.vecFavGroup == null) {
          break label270;
        }
      }
      for (i = paramGetTroopListRespV2.vecFavGroup.size();; i = -1)
      {
        QLog.d("Q.getTroopList", 2, i);
        if (paramGetTroopListRespV2.errorCode != 2001) {
          break label275;
        }
        b();
        return;
        i = -1;
        break;
        i = -1;
        break label166;
        i = -1;
        break label195;
      }
      localObject3 = new ArrayList();
      l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      try
      {
        localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        localObject2 = new ArrayList();
        if (paramGetTroopListRespV2.vecTroopListDel == null) {
          break label664;
        }
        localObject1 = new StringBuilder("vecTroopListDel==>");
        i = 0;
        if (i >= paramGetTroopListRespV2.vecTroopListDel.size()) {
          break;
        }
        localObject5 = (stTroopNum)paramGetTroopListRespV2.vecTroopListDel.get(i);
        localObject4 = String.valueOf(((stTroopNum)localObject5).GroupCode);
        if ((TextUtils.isEmpty((CharSequence)localObject4)) || ("0".equals(localObject4)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopHandlerQ.getTroopList", 2, "error troopuin: " + (String)localObject4);
          }
          ReportController.b(null, "P_CliOper", "BizTechReport", "", "troopuinerror", "gettrooplist", 0, 1, 0, "", "", "", "");
        }
        else
        {
          ((List)localObject2).add(localObject4);
          ((StringBuilder)localObject1).append("| troopItem.GroupUin: ").append(((stTroopNum)localObject5).GroupUin).append(" troopItem.GroupCode: ").append(((stTroopNum)localObject5).GroupCode);
          localObject5 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          localObject4 = ((ProxyManager)localObject5).a().a((String)localObject4, 1);
          if (localObject4 != null) {
            ((ProxyManager)localObject5).a().b((RecentUser)localObject4);
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        localObject1 = null;
      }
      paramToServiceMsg.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.contacttab.troop", 2, QLog.getStackTraceString(paramToServiceMsg));
      }
      if (localObject1 != null) {
        ((EntityTransaction)localObject1).b();
      }
      if ((paramGetTroopListRespV2.vecCookies == null) || (paramGetTroopListRespV2.vecCookies.length <= 0)) {
        break label2296;
      }
      b(paramGetTroopListRespV2.vecCookies);
      paramToServiceMsg = (LbsInfoMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(65);
    } while (paramToServiceMsg == null);
    paramToServiceMsg.a();
    return;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandlerQ.getTroopList", 2, "handle get troop list resp, delete troop," + ((StringBuilder)localObject1).toString());
    }
    label664:
    Object localObject1 = localTroopManager.a();
    for (;;)
    {
      try
      {
        ((EntityTransaction)localObject1).a();
        if (!((List)localObject2).isEmpty()) {
          localTroopManager.a((List)localObject2);
        }
        ((EntityTransaction)localObject1).c();
        ((EntityTransaction)localObject1).b();
        localObject2 = ((List)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localTroopManager.a((String)((Iterator)localObject2).next());
          continue;
        }
        if (paramGetTroopListRespV2.vecTroopList != null)
        {
          localObject4 = new ArrayList();
          j = 0;
          i = 0;
          Object localObject6;
          if (j < paramGetTroopListRespV2.vecTroopList.size())
          {
            localObject5 = (stTroopNum)paramGetTroopListRespV2.vecTroopList.get(j);
            localObject2 = localTroopManager.a(String.valueOf(((stTroopNum)localObject5).GroupCode));
            if (localObject2 != null) {
              break label2461;
            }
            k = 1;
            if (k != 0)
            {
              localObject2 = new TroopInfo();
              ((TroopInfo)localObject2).troopuin = String.valueOf(((stTroopNum)localObject5).GroupCode);
              ((TroopInfo)localObject2).uin = paramToServiceMsg.getUin();
              ((TroopInfo)localObject2).troopcode = String.valueOf(((stTroopNum)localObject5).GroupUin);
              ((TroopInfo)localObject2).dwGroupInfoSeq = ((stTroopNum)localObject5).dwGroupInfoSeq;
              ((TroopInfo)localObject2).troopname = ((stTroopNum)localObject5).strGroupName;
              ((TroopInfo)localObject2).troopmemo = ((stTroopNum)localObject5).strGroupMemo;
              ((TroopInfo)localObject2).dwGroupFlagExt = ((stTroopNum)localObject5).dwGroupFlagExt;
              ((TroopInfo)localObject2).dwAuthGroupType = ((stTroopNum)localObject5).dwCertificationType;
              ((TroopInfo)localObject2).timeSec = l;
              ((TroopInfo)localObject2).dwGroupLevelSeq = ((stTroopNum)localObject5).dwGroupRankSeq;
              ((TroopInfo)localObject2).dwGagTimeStamp = ((stTroopNum)localObject5).dwShutupTimestamp;
              ((TroopInfo)localObject2).dwGagTimeStamp_me = ((stTroopNum)localObject5).dwMyShutupTimestamp;
              ((TroopInfo)localObject2).dwCmdUinUinFlag = ((stTroopNum)localObject5).dwCmdUinUinFlag;
              ((TroopInfo)localObject2).dwAdditionalFlag = ((stTroopNum)localObject5).dwAdditionalFlag;
              ((TroopInfo)localObject2).troopTypeExt = ((int)((stTroopNum)localObject5).dwGroupTypeFlag);
              ((TroopInfo)localObject2).dwGroupClassExt = ((stTroopNum)localObject5).dwGroupClassExt;
              ((TroopInfo)localObject2).dwCmdUinJoinTime = ((stTroopNum)localObject5).dwCmduinJoinTime;
              if (((((TroopInfo)localObject2).dwAdditionalFlag & 1L) == 1L) && (TextUtils.isEmpty(((TroopInfo)localObject2).troopowneruin))) {
                ((TroopInfo)localObject2).troopowneruin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              }
              if (((stTroopNum)localObject5).dwGroupOwnerUin != 0L) {
                ((TroopInfo)localObject2).troopowneruin = String.valueOf(((stTroopNum)localObject5).dwGroupOwnerUin);
              }
              ((TroopInfo)localObject2).dwAppPrivilegeFlag = ((stTroopNum)localObject5).dwAppPrivilegeFlag;
              ((TroopInfo)localObject2).troopPrivilegeFlag = ((stTroopNum)localObject5).dwAppPrivilegeFlag;
              ((TroopInfo)localObject2).associatePubAccount = ((stTroopNum)localObject5).dwSubscriptionUin;
              if (((TroopInfo)localObject2).Administrator != null)
              {
                if (((TroopInfo)localObject2).Administrator.startsWith("|")) {
                  ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(1);
                }
                if (((TroopInfo)localObject2).Administrator.endsWith("|")) {
                  ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.substring(0, ((TroopInfo)localObject2).Administrator.length() - 1);
                }
                if ((((TroopInfo)localObject2).dwCmdUinUinFlag & 1L) == 1L)
                {
                  if (!((TroopInfo)localObject2).Administrator.contains(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                    ((TroopInfo)localObject2).Administrator = (((TroopInfo)localObject2).Administrator + "|" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                  }
                  ((TroopInfo)localObject2).wMemberNum = ((int)((stTroopNum)localObject5).dwMemberNum);
                  ((TroopInfo)localObject2).wMemberNumClient = ((TroopInfo)localObject2).wMemberNum;
                  ((TroopInfo)localObject2).mMemberNumSeq = ((stTroopNum)localObject5).dwMemberNumSeq;
                  ((TroopInfo)localObject2).mMemberCardSeq = ((stTroopNum)localObject5).dwMemberCardSeq;
                  ((TroopInfo)localObject2).troopCreditLevel = ((stTroopNum)localObject5).dwGroupSecType;
                  ((TroopInfo)localObject2).troopCreditLevelInfo = ((stTroopNum)localObject5).dwGroupSecTypeInfo;
                  ((TroopInfo)localObject2).dwGroupFlagExt3 = ((stTroopNum)localObject5).dwGroupFlagExt3;
                  if (((stTroopNum)localObject5).cIsConfGroup != 1) {
                    break label2467;
                  }
                  bool = true;
                  ((TroopInfo)localObject2).isNewTroop = bool;
                  if (((stTroopNum)localObject5).cIsModifyConfGroupFace != 1) {
                    break label2473;
                  }
                  bool = true;
                  ((TroopInfo)localObject2).hasSetNewTroopHead = bool;
                  if (((stTroopNum)localObject5).cIsModifyConfGroupName != 1) {
                    break label2479;
                  }
                  bool = true;
                  ((TroopInfo)localObject2).hasSetNewTroopName = bool;
                  if ((QLog.isColorLevel()) && (((TroopInfo)localObject2).isQidianPrivateTroop())) {
                    QLog.d(".troop.qidian_private_troop", 2, "handleTroopList, vecTroopList privateTroop troopUin=" + ((TroopInfo)localObject2).troopuin);
                  }
                  ((List)localObject4).add(localObject2);
                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(((TroopInfo)localObject2).troopuin);
                  if (((TroopInfo)localObject2).troopcode == null) {
                    break label2447;
                  }
                  if (!((TroopInfo)localObject2).troopcode.equals("0")) {
                    continue;
                  }
                  break label2447;
                  if (QLog.isColorLevel()) {
                    QLog.d("Q.getTroopList", 2, "handle get troop list resp, save troop, troopUin: " + ((stTroopNum)localObject5).GroupUin + " troopCode: " + ((stTroopNum)localObject5).GroupCode + ", cLevel:" + ((TroopInfo)localObject2).troopCreditLevel + ", cInfo:" + ((TroopInfo)localObject2).troopCreditLevelInfo + ", info.wMemberNum:" + ((TroopInfo)localObject2).wMemberNum + ", info.mMemberNumSeq" + ((TroopInfo)localObject2).mMemberNumSeq + ", info.mMemberCardSeq:" + ((TroopInfo)localObject2).mMemberCardSeq);
                  }
                  localObject6 = localTroopManager.a(((TroopInfo)localObject2).troopuin);
                  if ((((TroopInfo)localObject2).hasSetTroopHead()) || ((((ArrayList)localObject6).size() != 0) && ((((ArrayList)localObject6).size() >= 5) || (((TroopInfo)localObject2).mMemberNumSeq == ((TroopInfo)localObject2).mOldMemberNumSeq)))) {
                    break label2452;
                  }
                  this.jdField_c_of_type_JavaUtilArrayList.add(Long.valueOf(((stTroopNum)localObject5).GroupCode));
                  break label2452;
                }
              }
              else
              {
                ((TroopInfo)localObject2).Administrator = "";
                continue;
              }
              ((TroopInfo)localObject2).Administrator = ((TroopInfo)localObject2).Administrator.replace(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "|", "").replace("|" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "").replace(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "");
              continue;
              ((ArrayList)localObject3).add(Long.valueOf(((stTroopNum)localObject5).GroupCode));
              continue;
            }
          }
          else
          {
            localTroopManager.b((List)localObject4);
            if (paramGetTroopListRespV2.vecTroopRank != null)
            {
              localObject4 = new ArrayList();
              localObject5 = paramGetTroopListRespV2.vecTroopRank.iterator();
              if (((Iterator)localObject5).hasNext())
              {
                localObject6 = (stGroupRankInfo)((Iterator)localObject5).next();
                localObject3 = localTroopManager.a(String.valueOf(((stGroupRankInfo)localObject6).dwGroupCode));
                localObject2 = localObject3;
                if (localObject3 == null)
                {
                  localObject2 = new TroopInfo();
                  ((TroopInfo)localObject2).troopuin = String.valueOf(((stGroupRankInfo)localObject6).dwGroupCode);
                }
                ((TroopInfo)localObject2).uin = paramToServiceMsg.getUin();
                ((TroopInfo)localObject2).cGroupRankSysFlag = ((stGroupRankInfo)localObject6).cGroupRankSysFlag;
                ((TroopInfo)localObject2).cGroupRankUserFlag = ((stGroupRankInfo)localObject6).cGroupRankUserFlag;
                ((TroopInfo)localObject2).dwGroupLevelSeq = ((stGroupRankInfo)localObject6).dwGroupRankSeq;
                ((TroopInfo)localObject2).setTroopLevelMap(((stGroupRankInfo)localObject6).vecRankMap);
                ((TroopInfo)localObject2).ownerNameShow = ((stGroupRankInfo)localObject6).strOwnerName;
                ((TroopInfo)localObject2).adminNameShow = ((stGroupRankInfo)localObject6).strAdminName;
                ((TroopInfo)localObject2).dwOfficeMode = ((stGroupRankInfo)localObject6).dwOfficeMode;
                ((List)localObject4).add(localObject2);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                localObject2 = new StringBuilder().append("handle getTroopList resp->vecTroopRank,troopUin: ").append(((stGroupRankInfo)localObject6).dwGroupCode).append(" ,sys flag: ").append(((stGroupRankInfo)localObject6).cGroupRankSysFlag).append(" ,user flag: ").append(((stGroupRankInfo)localObject6).cGroupRankUserFlag).append(" ,level seq: ").append(((stGroupRankInfo)localObject6).dwGroupRankSeq).append(" ,level size: ");
                if (((stGroupRankInfo)localObject6).vecRankMap == null) {
                  break label2485;
                }
                j = ((stGroupRankInfo)localObject6).vecRankMap.size();
                QLog.d("Q.getTroopMemberLevelInfo", 2, j);
                continue;
              }
              localTroopManager.b((List)localObject4);
            }
            if ((paramGetTroopListRespV2.vecFavGroup != null) && (this.jdField_b_of_type_Boolean))
            {
              paramToServiceMsg = new HashMap();
              localObject2 = new HashMap();
              localObject3 = paramGetTroopListRespV2.vecFavGroup.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                localObject4 = (stFavoriteGroup)((Iterator)localObject3).next();
                l = ((stFavoriteGroup)localObject4).dwSnsFlag;
                if ((1L & l) == 1L) {
                  paramToServiceMsg.put(new Long(((stFavoriteGroup)localObject4).dwGroupCode).toString(), Long.valueOf(((stFavoriteGroup)localObject4).dwTimestamp));
                }
                if ((0x2 & l) == 2L) {
                  ((Map)localObject2).put(new Long(((stFavoriteGroup)localObject4).dwGroupCode).toString(), Long.valueOf(((stFavoriteGroup)localObject4).dwOpenTimestamp));
                }
                if ((l & 0x4) != 4L) {
                  continue;
                }
                localArrayList.add(String.valueOf(((stFavoriteGroup)localObject4).dwGroupCode));
                continue;
              }
              localTroopManager.a(paramToServiceMsg);
              localTroopManager.b((Map)localObject2);
              ((TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(localArrayList);
            }
            if (i == 0) {
              break label582;
            }
            a(jdField_a_of_type_Int);
            break label582;
            label2296:
            if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
            {
              a(this.jdField_c_of_type_JavaUtilArrayList);
              this.jdField_c_of_type_JavaUtilArrayList.clear();
            }
            if (QLog.isColorLevel()) {
              QLog.i("TroopHandler", 2, "notifyUI(TYPE_GET_TROOP_LIST");
            }
            paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            paramToServiceMsg.c();
            paramToServiceMsg.d();
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "load_trooplist", 0).edit().putBoolean("load_all_3", false).commit();
            a(2, true, null);
            jdField_a_of_type_Boolean = true;
            break label605;
          }
          continue;
        }
        i = 0;
        continue;
        i += 1;
      }
      catch (Exception paramToServiceMsg) {}
      break label551;
      label2447:
      i = 1;
      continue;
      label2452:
      j += 1;
      continue;
      label2461:
      int k = 0;
      continue;
      label2467:
      bool = false;
      continue;
      label2473:
      bool = false;
      continue;
      label2479:
      bool = false;
      continue;
      label2485:
      int j = -1;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetTroopMemberListResp paramGetTroopMemberListResp)
  {
    String str1 = a(paramToServiceMsg.extraData.getLong("troop_uin"));
    long l1 = paramToServiceMsg.extraData.getLong("troop_time");
    boolean bool = paramToServiceMsg.extraData.getBoolean("needCallBackCache");
    int i = paramToServiceMsg.extraData.getInt("reqType", 0);
    long l2 = paramToServiceMsg.extraData.getLong("timestamp");
    String str2 = str1 + "_" + i;
    long l3;
    Object localObject2;
    Object localObject1;
    if (paramGetTroopMemberListResp != null)
    {
      if (paramGetTroopMemberListResp.NextGetTime != 0L) {
        this.jdField_d_of_type_JavaUtilHashMap.put(str2, Long.valueOf(paramGetTroopMemberListResp.NextGetTime));
      }
      l3 = paramGetTroopMemberListResp.GroupUin;
      paramGetTroopMemberListResp.GroupUin = paramGetTroopMemberListResp.GroupCode;
      paramGetTroopMemberListResp.GroupCode = l3;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "req troopUin:" + str1 + "| resp.GroupUin:" + paramGetTroopMemberListResp.GroupUin + "|resp.GroupCode:" + paramGetTroopMemberListResp.GroupCode);
      }
      TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localObject2 = localTroopManager.a(str1);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new TroopInfo();
        ((TroopInfo)localObject1).troopuin = str1;
      }
      ((TroopInfo)localObject1).dwOfficeMode = paramGetTroopMemberListResp.office_mode;
      localTroopManager.b((TroopInfo)localObject1);
      if (paramGetTroopMemberListResp.result != 0) {
        break label901;
      }
    }
    for (;;)
    {
      try
      {
        if (this.jdField_c_of_type_JavaUtilHashMap == null) {
          this.jdField_c_of_type_JavaUtilHashMap = new HashMap();
        }
        localObject2 = str1 + "_" + l1;
        if (this.jdField_c_of_type_JavaUtilHashMap.containsKey(localObject2))
        {
          ((ArrayList)this.jdField_c_of_type_JavaUtilHashMap.get(localObject2)).addAll(paramGetTroopMemberListResp.vecTroopMember);
          paramGetTroopMemberListResp.vecTroopMember.size();
          if (paramGetTroopMemberListResp.NextUin == 0L) {
            break label734;
          }
          paramToServiceMsg.extraData.putBoolean("force_refresh", true);
          paramToServiceMsg.extraData.putLong("nextuin", paramGetTroopMemberListResp.NextUin);
          paramToServiceMsg.extraData.putLong("troop_time", l1);
          paramToServiceMsg.extraData.putInt("reqType", i);
          paramToServiceMsg.extraData.putLong("timestamp", l2);
          localObject1 = new UniPacket(true);
          ((UniPacket)localObject1).setEncodeName("utf-8");
          if (a(paramToServiceMsg, (UniPacket)localObject1))
          {
            paramToServiceMsg.setServiceName("mobileqq.service");
            paramToServiceMsg.setRequestSsoSeq(((UniPacket)localObject1).getRequestId());
            paramToServiceMsg.putWupBuffer(((UniPacket)localObject1).encode());
            a(paramToServiceMsg);
            if (QLog.isColorLevel()) {
              QLog.d("get_troop_member", 2, "FriendListHandler.handleGetTroopMemberList, request the next page data");
            }
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder().append("FriendListHandler.handleGetTroopMemberList, resp.result: ").append(paramGetTroopMemberListResp.result).append(" member count: ").append(paramGetTroopMemberListResp.vecTroopMember.size()).append("|reqType:").append(i).append("|memberListNextReqTime:");
              if (!this.jdField_d_of_type_JavaUtilHashMap.containsKey(str2)) {
                break label956;
              }
              l1 = ((Long)this.jdField_d_of_type_JavaUtilHashMap.get(str2)).longValue();
              QLog.d("get_troop_member.troop.req_troop_mem_list_optimize", 2, l1 + "|troopUin:" + str1);
            }
          }
        }
        else
        {
          this.jdField_c_of_type_JavaUtilHashMap.put(localObject2, paramGetTroopMemberListResp.vecTroopMember);
          continue;
        }
        if (!bool) {
          break label693;
        }
      }
      finally {}
      paramToServiceMsg = new Object[4];
      paramToServiceMsg[0] = str1;
      paramToServiceMsg[1] = a(str1, l1);
      paramToServiceMsg[2] = Integer.valueOf(i);
      paramToServiceMsg[3] = Long.valueOf(l2);
      for (;;)
      {
        a(5, false, paramToServiceMsg);
        break;
        label693:
        a(str1, l1);
        paramToServiceMsg = new Object[4];
        paramToServiceMsg[0] = str1;
        paramToServiceMsg[1] = null;
        paramToServiceMsg[2] = Integer.valueOf(i);
        paramToServiceMsg[3] = Long.valueOf(l2);
      }
      label734:
      l3 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "netWorkCost:" + (l3 - l1));
      }
      if (bool)
      {
        a(5, true, new Object[] { str1, a(str1, l1), Integer.valueOf(i), Long.valueOf(l2) });
        ThreadManager.post(new zkv(this, str1, l1, (TroopInfo)localObject1), 5, null, false);
      }
      else
      {
        a(str1, l1);
        a(str1, l1, (TroopInfo)localObject1);
        a(5, true, new Object[] { str1, null, Integer.valueOf(i), Long.valueOf(l2) });
        continue;
        label901:
        if (paramGetTroopMemberListResp.result == 2) {}
        for (bool = true;; bool = false)
        {
          a(5, bool, new Object[] { str1, null, Integer.valueOf(i), Long.valueOf(l2) });
          break;
        }
        label956:
        l1 = 0L;
      }
    }
  }
  
  private void a(String paramString, long paramLong, TroopInfo paramTroopInfo)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a() != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(new TroopMemberInfo().getTableName(), "troopuin=? and memberuin<>? and memberuin<>? and datetime<?", new String[] { paramString, "1000000", "10000", String.valueOf(paramLong) });
    }
    if (paramTroopInfo == null) {}
    TroopManager localTroopManager;
    do
    {
      return;
      if ((paramTroopInfo.mOldMemberNumSeq != paramTroopInfo.mMemberNumSeq) || (paramTroopInfo.mMemberCardSeq != paramTroopInfo.mOldMemberCardSeq))
      {
        paramTroopInfo.mOldMemberNumSeq = paramTroopInfo.mMemberNumSeq;
        paramTroopInfo.mOldMemberCardSeq = paramTroopInfo.mMemberCardSeq;
        ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramTroopInfo);
      }
      localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localTroopManager.c(paramString);
    } while ((localTroopManager.a().a(paramString)) || (paramTroopInfo.hasSetTroopName()));
    TroopNameHelper.a(paramString);
  }
  
  private void a(String paramString, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    oidb_0xa2a.ReqBody localReqBody = new oidb_0xa2a.ReqBody();
    localReqBody.group_id.set(Long.valueOf(paramString).longValue());
    localReqBody.is_private.set(TroopInfo.isQidianPrivateTroop(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
    if (paramSosoLbsInfo != null)
    {
      oidb_0xa2a.LBSInfo localLBSInfo = new oidb_0xa2a.LBSInfo();
      oidb_0xa2a.GPS localGPS = new oidb_0xa2a.GPS();
      if (paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null)
      {
        localGPS.int64_longitude.set((paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
        localGPS.int64_latitude.set((paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
        localGPS.uint32_gps_type.set(0);
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      Object localObject3;
      if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject1 = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SosoInterface.SosoCell)((Iterator)localObject1).next();
          localObject3 = new oidb_0xa2a.Cell();
          ((oidb_0xa2a.Cell)localObject3).int32_cell_id.set(((SosoInterface.SosoCell)localObject2).jdField_d_of_type_Int);
          ((oidb_0xa2a.Cell)localObject3).int32_location_area_code.set(((SosoInterface.SosoCell)localObject2).jdField_c_of_type_Int);
          ((oidb_0xa2a.Cell)localObject3).int32_mobile_country_code.set(((SosoInterface.SosoCell)localObject2).jdField_a_of_type_Int);
          ((oidb_0xa2a.Cell)localObject3).int32_mobile_network_code.set(((SosoInterface.SosoCell)localObject2).jdField_b_of_type_Int);
          ((oidb_0xa2a.Cell)localObject3).int32_rssi.set(((SosoInterface.SosoCell)localObject2).e);
          localArrayList.add(localObject3);
        }
      }
      Object localObject1 = new ArrayList();
      if (paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList != null)
      {
        paramSosoLbsInfo = paramSosoLbsInfo.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (paramSosoLbsInfo.hasNext())
        {
          localObject2 = (SosoInterface.SosoWifi)paramSosoLbsInfo.next();
          localObject3 = new oidb_0xa2a.Wifi();
          ((oidb_0xa2a.Wifi)localObject3).int64_mac.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long);
          ((oidb_0xa2a.Wifi)localObject3).int32_rssi.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int);
          ((List)localObject1).add(localObject3);
        }
      }
      localLBSInfo.msg_gpsdw.set(localGPS);
      localLBSInfo.rpt_msg_cells.set(localArrayList);
      localLBSInfo.rpt_msg_wifis.set((List)localObject1);
      localReqBody.lbs_info.set(localLBSInfo);
    }
    paramSosoLbsInfo = a("OidbSvc.0xa2a_0", 2602, 0, localReqBody.toByteArray());
    paramSosoLbsInfo.extraData.putString("troopUin", paramString);
    b(paramSosoLbsInfo);
  }
  
  private void a(String paramString, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      a(44, false, new Object[] { Integer.valueOf(3), null, "" });
    }
    for (;;)
    {
      return;
      paramString = paramToServiceMsg.extraData.getLong("troopUin") + "";
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(44, false, new Object[] { Integer.valueOf(3), null, paramString });
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
        {
          a(44, false, new Object[] { Integer.valueOf(3), null, paramString });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(44, false, new Object[] { Integer.valueOf(3), null, paramString });
        return;
      }
      paramFromServiceMsg = new oidb_0x8a0.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_kick_result.get();
        paramToServiceMsg = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = (oidb_0x8a0.KickResult)paramFromServiceMsg.next();
          if (paramObject.opt_uint32_result.get() == 0) {
            paramToServiceMsg.add(Long.toString(paramObject.opt_uint64_member_uin.get()));
          }
        }
        if (paramToServiceMsg.size() <= 0) {}
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(44, false, new Object[] { Integer.valueOf(3), null, paramString });
        return;
      }
    }
    paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    paramObject = paramToServiceMsg.iterator();
    while (paramObject.hasNext()) {
      paramFromServiceMsg.c(paramString, (String)paramObject.next());
    }
    a(44, true, new Object[] { Integer.valueOf(1), paramToServiceMsg, paramString });
  }
  
  private void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "getTroopMemberRemark troopUin=" + paramString + " uins.len=" + paramArrayList.size() + " uinOffset=" + paramInt);
    }
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    int i = paramArrayList.size();
    if (i - paramInt > 20) {
      i = paramInt + 20;
    }
    for (;;)
    {
      Object localObject = new byte[(i - paramInt) * 4 + 7];
      PkgTools.a((byte[])localObject, 0, (short)2);
      PkgTools.a((byte[])localObject, 2, l);
      localObject[6] = ((byte)(i - paramInt));
      int k = 7;
      int j = paramInt;
      paramInt = k;
      while (j < i)
      {
        PkgTools.a((byte[])localObject, paramInt, Long.parseLong((String)paramArrayList.get(j)));
        j += 1;
        paramInt += 4;
      }
      localObject = a("OidbSvc.0x53c_2", 1340, 2, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject).extraData.putStringArrayList("memberUins", paramArrayList);
      ((ToServiceMsg)localObject).extraData.putInt("offset", i);
      ((ToServiceMsg)localObject).extraData.putLong("curTs", System.currentTimeMillis());
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  private void a(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleSwitchTroopShowExStatusRsp");
    }
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    paramObject = new Object[3];
    paramObject[0] = str;
    paramObject[1] = Integer.valueOf(paramFromServiceMsg.getResultCode());
    paramObject[2] = Integer.valueOf(-1);
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      a(55, false, paramObject);
    }
    if (!"getShowEternalStatus".equals(paramToServiceMsg.extraData.getString("0x8d4_cmd_key"))) {
      return;
    }
    paramToServiceMsg = new cmd0x8b4.RspBody();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        if ((!paramFromServiceMsg.isSuccess()) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        a(55, true, new Object[] { str, Integer.valueOf(paramToServiceMsg.uint32_result.get()), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
        if (paramToServiceMsg.uint32_flag.get() == 1)
        {
          paramBoolean = true;
          a(null, str, paramBoolean, true);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(55, false, paramObject);
        return;
      }
      paramBoolean = false;
    }
    a(55, false, paramObject);
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    long l1 = 0L;
    long l2 = a(paramToServiceMsg.getUin());
    if (l2 == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    GetTroopMemberListReq localGetTroopMemberListReq = new GetTroopMemberListReq();
    localGetTroopMemberListReq.uin = l2;
    localGetTroopMemberListReq.GroupCode = paramToServiceMsg.getLong("troop_uin");
    localGetTroopMemberListReq.GroupUin = paramToServiceMsg.getLong("troop_code");
    localGetTroopMemberListReq.NextUin = paramToServiceMsg.getLong("nextuin");
    localGetTroopMemberListReq.ReqType = paramToServiceMsg.getInt("reqType");
    String str = localGetTroopMemberListReq.GroupCode + "_" + localGetTroopMemberListReq.ReqType;
    if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(str)) {
      l1 = ((Long)this.jdField_d_of_type_JavaUtilHashMap.get(str)).longValue();
    }
    localGetTroopMemberListReq.GetListAppointTime = l1;
    paramToServiceMsg.getBoolean("force_refresh");
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetTroopMemberListReq");
    paramUniPacket.put("GTML", localGetTroopMemberListReq);
    return true;
  }
  
  private void aa(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(93, false, null);
        return;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0.0F) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
        {
          a(93, false, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(93, false, null);
        return;
      }
      paramFromServiceMsg = new cmd0x91c.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        a(93, true, new Object[] { String.valueOf(paramFromServiceMsg.uint64_group_code.get()), Integer.valueOf(paramFromServiceMsg.uint64_application_submit_time.get()) });
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(93, false, null);
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopHandler", 2, "oidb_91c error : " + paramToServiceMsg.toString());
  }
  
  private void ab(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troop_code");
    if (paramFromServiceMsg.isSuccess()) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        label291:
        paramToServiceMsg = null;
      }
      for (;;)
      {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
          if (paramToServiceMsg != null) {
            paramToServiceMsg.uint32_result.get();
          }
          if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          }
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          continue;
        }
        try
        {
          paramFromServiceMsg = new oidb_0x88d.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          paramToServiceMsg = paramFromServiceMsg.stzrspgroupinfo.get();
          if (paramToServiceMsg != null) {
            continue;
          }
          i = 0;
          if (i > 0)
          {
            paramToServiceMsg = (oidb_0x88d.RspGroupInfo)paramToServiceMsg.get(0);
            if ((paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.uint64_group_code.has()) && (paramToServiceMsg.uint64_group_code.get() == Long.parseLong(str)) && (paramToServiceMsg.stgroupinfo.has()))
            {
              paramObject = (oidb_0x88d.GroupInfo)paramToServiceMsg.stgroupinfo.get();
              if (paramObject.uint32_group_admin_max_num.has())
              {
                TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                paramFromServiceMsg = localTroopManager.a(str);
                paramToServiceMsg = paramFromServiceMsg;
                if (paramFromServiceMsg == null)
                {
                  paramToServiceMsg = new TroopInfo();
                  paramToServiceMsg.troopuin = str;
                }
                paramToServiceMsg.maxAdminNum = paramObject.uint32_group_admin_max_num.get();
                localTroopManager.b(paramToServiceMsg);
                a(27, true, new Object[] { str, Integer.valueOf(paramObject.uint32_group_admin_max_num.get()) });
              }
            }
          }
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            break label291;
          }
          QLog.i("TroopHandler", 2, paramToServiceMsg.toString());
          break label291;
        }
      }
      a(27, false, null);
      return;
      paramFromServiceMsg.printStackTrace();
      continue;
      int i = paramToServiceMsg.size();
    }
  }
  
  /* Error */
  private void ac(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: aconst_null
    //   7: astore 16
    //   9: aconst_null
    //   10: astore 17
    //   12: aconst_null
    //   13: astore 18
    //   15: aload_1
    //   16: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   19: ldc_w 1384
    //   22: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   25: lstore 12
    //   27: aload_1
    //   28: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 2289
    //   34: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   37: istore 9
    //   39: iconst_m1
    //   40: istore 4
    //   42: iload 4
    //   44: istore 5
    //   46: aload_2
    //   47: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   50: sipush 1000
    //   53: if_icmpne +782 -> 835
    //   56: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   59: dup
    //   60: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: aload_3
    //   66: checkcast 151	[B
    //   69: checkcast 151	[B
    //   72: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: astore_2
    //   79: aload_2
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +53 -> 135
    //   85: aload_1
    //   86: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   92: istore 5
    //   94: iload 5
    //   96: istore 4
    //   98: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +34 -> 135
    //   104: ldc 96
    //   106: iconst_2
    //   107: new 166	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 2291
    //   117: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload 5
    //   122: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iload 5
    //   133: istore 4
    //   135: iload 4
    //   137: istore 5
    //   139: aload_1
    //   140: ifnull +695 -> 835
    //   143: iload 4
    //   145: istore 5
    //   147: aload_1
    //   148: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   151: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   154: ifeq +681 -> 835
    //   157: iload 4
    //   159: istore 5
    //   161: aload_1
    //   162: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   165: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: ifnull +667 -> 835
    //   171: aload_1
    //   172: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   175: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   178: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   181: astore_1
    //   182: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   185: dup
    //   186: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   189: astore_3
    //   190: aload_3
    //   191: aload_1
    //   192: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   195: pop
    //   196: iload 4
    //   198: ifeq +632 -> 830
    //   201: aload_3
    //   202: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   205: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   208: ifeq +622 -> 830
    //   211: aload_3
    //   212: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   221: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   224: astore_1
    //   225: aconst_null
    //   226: astore_2
    //   227: iload 4
    //   229: istore 5
    //   231: aload_3
    //   232: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   235: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   238: astore_3
    //   239: aload_3
    //   240: ifnonnull +123 -> 363
    //   243: iconst_0
    //   244: istore 7
    //   246: goto +599 -> 845
    //   249: aload_2
    //   250: ifnonnull +189 -> 439
    //   253: iload 8
    //   255: iload 7
    //   257: if_icmpge +182 -> 439
    //   260: iload 4
    //   262: istore 5
    //   264: aload_3
    //   265: iload 8
    //   267: invokeinterface 638 2 0
    //   272: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   275: astore 18
    //   277: iload 4
    //   279: istore 6
    //   281: aload 18
    //   283: ifnull +540 -> 823
    //   286: iload 4
    //   288: istore 5
    //   290: aload 18
    //   292: getfield 2272	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   295: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   298: lstore 14
    //   300: lload 14
    //   302: lload 12
    //   304: lcmp
    //   305: ifeq +73 -> 378
    //   308: iload 8
    //   310: iconst_1
    //   311: iadd
    //   312: istore 8
    //   314: goto -65 -> 249
    //   317: astore_2
    //   318: aconst_null
    //   319: astore_1
    //   320: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +33 -> 356
    //   326: ldc_w 2296
    //   329: iconst_2
    //   330: new 166	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   337: ldc_w 2298
    //   340: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_2
    //   344: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   347: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_2
    //   357: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   360: goto -279 -> 81
    //   363: iload 4
    //   365: istore 5
    //   367: aload_3
    //   368: invokeinterface 565 1 0
    //   373: istore 7
    //   375: goto +470 -> 845
    //   378: iload 4
    //   380: istore 5
    //   382: aload 18
    //   384: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   390: istore 4
    //   392: iload 4
    //   394: istore 6
    //   396: iload 4
    //   398: ifne +425 -> 823
    //   401: iload 4
    //   403: istore 5
    //   405: iload 4
    //   407: istore 6
    //   409: aload 18
    //   411: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   414: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   417: ifeq +406 -> 823
    //   420: iload 4
    //   422: istore 5
    //   424: aload 18
    //   426: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   429: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   432: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   435: astore_2
    //   436: goto -128 -> 308
    //   439: aload_2
    //   440: ifnull +374 -> 814
    //   443: iconst_1
    //   444: istore 11
    //   446: aload 17
    //   448: astore_3
    //   449: aload_0
    //   450: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   453: bipush 51
    //   455: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   458: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   461: lload 12
    //   463: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   466: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   469: astore 16
    //   471: aload 16
    //   473: ifnonnull +335 -> 808
    //   476: new 511	com/tencent/mobileqq/data/TroopInfo
    //   479: dup
    //   480: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   483: astore 17
    //   485: aload 17
    //   487: astore_3
    //   488: aload 17
    //   490: lload 12
    //   492: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   495: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   498: aload 17
    //   500: astore_3
    //   501: aload_2
    //   502: getfield 2301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   505: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   508: ifeq +50 -> 558
    //   511: aload_3
    //   512: aload_2
    //   513: getfield 2301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   516: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   519: i2l
    //   520: putfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   523: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +32 -> 558
    //   529: ldc 96
    //   531: iconst_2
    //   532: new 166	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   539: ldc_w 2303
    //   542: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: aload_3
    //   546: getfield 1329	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   549: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   558: aload_3
    //   559: astore 16
    //   561: iload 11
    //   563: istore 10
    //   565: aload_2
    //   566: getfield 2306	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   569: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   572: ifeq +82 -> 654
    //   575: aload_3
    //   576: new 166	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 368
    //   586: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_2
    //   590: getfield 2306	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   593: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   596: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   599: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: putfield 1211	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   605: aload_3
    //   606: astore 16
    //   608: iload 11
    //   610: istore 10
    //   612: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +39 -> 654
    //   618: ldc 96
    //   620: iconst_2
    //   621: new 166	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 2308
    //   631: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload_3
    //   635: getfield 1211	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   638: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   647: iload 11
    //   649: istore 10
    //   651: aload_3
    //   652: astore 16
    //   654: iload 10
    //   656: istore 11
    //   658: aload 16
    //   660: astore 17
    //   662: iload 4
    //   664: istore 5
    //   666: aload_1
    //   667: astore 16
    //   669: aload_0
    //   670: bipush 51
    //   672: iload 11
    //   674: iconst_5
    //   675: anewarray 103	java/lang/Object
    //   678: dup
    //   679: iconst_0
    //   680: lload 12
    //   682: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   685: aastore
    //   686: dup
    //   687: iconst_1
    //   688: iload 9
    //   690: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   693: aastore
    //   694: dup
    //   695: iconst_2
    //   696: aload 17
    //   698: aastore
    //   699: dup
    //   700: iconst_3
    //   701: iload 5
    //   703: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   706: aastore
    //   707: dup
    //   708: iconst_4
    //   709: aload 16
    //   711: aastore
    //   712: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   715: return
    //   716: astore_2
    //   717: aconst_null
    //   718: astore_1
    //   719: aload 16
    //   721: astore_3
    //   722: aload_1
    //   723: astore 16
    //   725: iload 4
    //   727: istore 5
    //   729: aload_3
    //   730: astore 17
    //   732: iload 10
    //   734: istore 11
    //   736: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq -70 -> 669
    //   742: ldc 96
    //   744: iconst_2
    //   745: aload_2
    //   746: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   749: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   752: aload_1
    //   753: astore 16
    //   755: iload 4
    //   757: istore 5
    //   759: aload_3
    //   760: astore 17
    //   762: iload 10
    //   764: istore 11
    //   766: goto -97 -> 669
    //   769: astore_2
    //   770: iload 5
    //   772: istore 4
    //   774: aload 16
    //   776: astore_3
    //   777: goto -55 -> 722
    //   780: astore_2
    //   781: iconst_1
    //   782: istore 10
    //   784: goto -62 -> 722
    //   787: astore_2
    //   788: aload 16
    //   790: astore_3
    //   791: iconst_1
    //   792: istore 10
    //   794: goto -72 -> 722
    //   797: astore_2
    //   798: iconst_1
    //   799: istore 10
    //   801: goto -79 -> 722
    //   804: astore_2
    //   805: goto -485 -> 320
    //   808: aload 16
    //   810: astore_3
    //   811: goto -310 -> 501
    //   814: aconst_null
    //   815: astore 16
    //   817: iconst_0
    //   818: istore 10
    //   820: goto -166 -> 654
    //   823: iload 6
    //   825: istore 4
    //   827: goto -519 -> 308
    //   830: aconst_null
    //   831: astore_1
    //   832: goto -607 -> 225
    //   835: aconst_null
    //   836: astore 16
    //   838: aload 18
    //   840: astore 17
    //   842: goto -173 -> 669
    //   845: iconst_0
    //   846: istore 8
    //   848: goto -599 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	851	0	this	TroopHandler
    //   0	851	1	paramToServiceMsg	ToServiceMsg
    //   0	851	2	paramFromServiceMsg	FromServiceMsg
    //   0	851	3	paramObject	Object
    //   40	786	4	i	int
    //   44	727	5	j	int
    //   279	545	6	k	int
    //   244	130	7	m	int
    //   253	594	8	n	int
    //   37	652	9	i1	int
    //   1	818	10	bool1	boolean
    //   4	761	11	bool2	boolean
    //   25	656	12	l1	long
    //   298	3	14	l2	long
    //   7	830	16	localObject1	Object
    //   10	831	17	localObject2	Object
    //   13	826	18	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    // Exception table:
    //   from	to	target	type
    //   56	64	317	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   182	196	716	java/lang/Exception
    //   201	225	716	java/lang/Exception
    //   231	239	769	java/lang/Exception
    //   264	277	769	java/lang/Exception
    //   290	300	769	java/lang/Exception
    //   367	375	769	java/lang/Exception
    //   382	392	769	java/lang/Exception
    //   409	420	769	java/lang/Exception
    //   424	436	769	java/lang/Exception
    //   449	471	780	java/lang/Exception
    //   488	498	780	java/lang/Exception
    //   476	485	787	java/lang/Exception
    //   501	558	797	java/lang/Exception
    //   565	605	797	java/lang/Exception
    //   612	647	797	java/lang/Exception
    //   64	79	804	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void ad(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData.getString("troop_uin");
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localObject);
    paramObject = (ProfGroupInfoRes)paramObject;
    if (paramFromServiceMsg.isSuccess()) {
      if (paramObject.cResult == 0)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramToServiceMsg.getUin()) == null) {
          return;
        }
        paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        paramToServiceMsg = paramFromServiceMsg.a(String.valueOf(paramObject.uGroupCode));
        if (paramToServiceMsg != null) {
          break label505;
        }
        paramToServiceMsg = new TroopInfo();
        paramToServiceMsg.troopuin = String.valueOf(paramObject.uGroupCode);
      }
    }
    label437:
    label505:
    for (;;)
    {
      paramToServiceMsg.troopcode = String.valueOf(paramObject.uGroupUin);
      if ((paramToServiceMsg.troopcode == null) || (paramToServiceMsg.troopcode.equals("0"))) {
        a(jdField_c_of_type_Int);
      }
      paramToServiceMsg.troopowneruin = String.valueOf(paramObject.uGroupOwnerUin);
      paramToServiceMsg.troopname = paramObject.sGroupName;
      paramToServiceMsg.troopface = paramObject.wGroupFace;
      paramToServiceMsg.troopmemo = paramObject.sGroupMemo;
      if (paramObject.vAdministrator != null)
      {
        paramToServiceMsg.fingertroopmemo = paramObject.sFingerGroupMemo;
        localObject = new StringBuffer();
        Iterator localIterator = paramObject.vAdministrator.iterator();
        while (localIterator.hasNext())
        {
          GroupMemberFlag localGroupMemberFlag = (GroupMemberFlag)localIterator.next();
          if (localGroupMemberFlag.dwUin != 0L) {
            ((StringBuffer)localObject).append(String.valueOf(localGroupMemberFlag.dwUin) + "|");
          }
        }
        paramToServiceMsg.Administrator = ((StringBuffer)localObject).toString();
      }
      if (paramObject.cAlbumResult == 33)
      {
        paramToServiceMsg.cAlbumResult = paramObject.cAlbumResult;
        paramToServiceMsg.dwTimeStamp = 0L;
        paramToServiceMsg.updateQZonePhotoUrls(null);
        paramToServiceMsg.strLocation = paramObject.sGroupLocation;
        if (1 != paramObject.cInviteSwitchOpen) {
          break label437;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        paramToServiceMsg.mMemberInvitingFlag = bool;
        paramToServiceMsg.dwGroupFlagExt = paramObject.dwFlagExt;
        paramToServiceMsg.troopAuthenticateInfo = paramObject.sAuthGrpInfo;
        paramFromServiceMsg.b(paramToServiceMsg);
        a(9, true, paramObject.uGroupCode + "");
        return;
        if (paramObject.cAlbumResult != 0) {
          break;
        }
        paramToServiceMsg.cAlbumResult = paramObject.cAlbumResult;
        if (paramToServiceMsg.dwTimeStamp == paramObject.dwTimeStamp) {
          break;
        }
        paramToServiceMsg.dwTimeStamp = paramObject.dwTimeStamp;
        paramToServiceMsg.updateQZonePhotoUrls(paramObject.vsUrl);
        break;
      }
      if (paramObject.cResult != 5) {
        break;
      }
      paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      paramFromServiceMsg = String.valueOf(paramObject.uGroupCode);
      if (paramToServiceMsg.a(paramFromServiceMsg) != null) {
        paramToServiceMsg.b(paramFromServiceMsg);
      }
      a(9, false, localObject);
      return;
      a(9, false, localObject);
      return;
    }
  }
  
  private void ae(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handle0x8b4Rsp");
    }
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000) {}
    for (boolean bool = false;; bool = true)
    {
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
        localObject = localOIDBSSOPkg;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopHandler", 2, "handle0x8b4Rsp InvalidProtocolBufferMicroException");
          }
          bool = false;
        }
        b(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
        return;
      }
      if (localObject == null) {
        break;
      }
      if ((!((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) || (!((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) || (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() == null)) {
        bool = false;
      }
      switch (((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get())
      {
      case 1: 
      case 3: 
      default: 
        return;
      case 0: 
        a(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
        return;
      }
      c(bool, paramToServiceMsg, paramFromServiceMsg, (oidb_sso.OIDBSSOPkg)localObject, paramObject);
      return;
    }
  }
  
  private void af(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    int j;
    long l;
    Object[] arrayOfObject;
    do
    {
      return;
      str = paramToServiceMsg.extraData.getString("troop_uin");
      j = paramToServiceMsg.extraData.getInt("reqType");
      l = paramToServiceMsg.extraData.getLong("timestamp");
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.set_show_external_status", 2, "handleSwitchTroopShowExStatusAfterJoinedTroopRsp, handle response begin==>" + "isSuccess:" + paramFromServiceMsg.isSuccess() + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|troopUin:" + str + "|reqType:" + j + "|timestamp:" + l);
      }
      arrayOfObject = new Object[4];
      arrayOfObject[0] = str;
      arrayOfObject[1] = Integer.valueOf(j);
      arrayOfObject[2] = Integer.valueOf(paramFromServiceMsg.getResultCode());
      if (j == 1) {}
      for (int i = 0;; i = 1)
      {
        arrayOfObject[3] = Integer.valueOf(i);
        if (paramFromServiceMsg.getResultCode() == 1000) {
          break;
        }
        a(54, false, arrayOfObject);
        return;
      }
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
        if ((paramObject == null) || (!paramObject.uint32_result.has()) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
        {
          a(54, false, arrayOfObject);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(54, false, arrayOfObject);
        return;
      }
    } while (!"setShowExternalStatus0x5d6".equals(paramToServiceMsg.extraData.getString("0x5d6_cmd_key")));
    paramToServiceMsg = new oidb_0x5d6.RspBody();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        paramToServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (j == 1)
        {
          paramToServiceMsg.b(str, l);
          a(54, true, new Object[] { str, Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()), Integer.valueOf(j) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(54, false, arrayOfObject);
        return;
      }
      if (j == 0) {
        paramToServiceMsg.e(str);
      }
    }
  }
  
  private void ag(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(48, false, null);
      return;
    }
    paramFromServiceMsg = new cmd0x3bb.AnonyMsg();
    try
    {
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      paramFromServiceMsg = (cmd0x3bb.RspBody)paramFromServiceMsg.msg_anony_rsp.get();
      if (paramFromServiceMsg == null)
      {
        a(48, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(48, false, null);
      return;
    }
    if (paramFromServiceMsg.int32_ret.get() != 0)
    {
      a(48, false, null);
      return;
    }
    paramObject = paramToServiceMsg.extraData.getString("troopUin");
    String str = new String(paramFromServiceMsg.str_anony_name.get().toByteArray());
    int j = paramFromServiceMsg.uint32_portrait_index.get();
    int k = paramFromServiceMsg.uint32_bubble_index.get();
    int m = paramFromServiceMsg.uint32_expired_time.get();
    paramToServiceMsg = (cmd0x3bb.AnonyStatus)paramFromServiceMsg.msg_anony_status.get();
    int i;
    if (paramToServiceMsg != null)
    {
      i = paramToServiceMsg.uint32_forbid_talking.get();
      paramToServiceMsg = new String(paramToServiceMsg.str_err_msg.get().toByteArray());
    }
    for (;;)
    {
      a(48, true, new Object[] { paramObject, str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), paramToServiceMsg, paramFromServiceMsg.color.get() });
      return;
      paramToServiceMsg = "";
      i = 0;
    }
  }
  
  private void ah(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    paramToServiceMsg = new Object[2];
    paramToServiceMsg[0] = str;
    paramToServiceMsg[1] = Integer.valueOf(-1);
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(53, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(53, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(53, false, paramToServiceMsg);
      return;
    }
    paramObject = new oidb_0x88d.RspBody();
    int i;
    try
    {
      paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = paramObject.stzrspgroupinfo.get();
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
        break label294;
      }
      paramFromServiceMsg = (oidb_0x88d.RspGroupInfo)paramFromServiceMsg.get(0);
      i = paramFromServiceMsg.uint32_result.get();
      if (i == 0)
      {
        a(53, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(((oidb_0x88d.GroupInfo)paramFromServiceMsg.stgroupinfo.get()).uint32_group_member_max_num.get()) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      a(53, false, paramToServiceMsg);
      return;
    }
    a(53, false, new Object[] { str, Integer.valueOf(i) });
    return;
    label294:
    a(53, false, paramToServiceMsg);
  }
  
  private void ai(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopCode");
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = str;
    arrayOfObject[1] = Boolean.valueOf(false);
    arrayOfObject[2] = "";
    arrayOfObject[3] = "";
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(57, false, arrayOfObject);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(57, false, arrayOfObject);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(57, false, arrayOfObject);
      return;
    }
    paramObject = new cmd0x8a7.RspBody();
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        boolean bool = paramObject.bool_can_at_all.get();
        if (!paramObject.bytes_prompt_msg_1.has()) {
          break label422;
        }
        paramToServiceMsg = paramObject.bytes_prompt_msg_1.get().toStringUtf8();
        if (!paramObject.bytes_prompt_msg_2.has()) {
          break label415;
        }
        paramFromServiceMsg = paramObject.bytes_prompt_msg_2.get().toStringUtf8();
        if (paramObject.uint32_remain_at_all_count_for_group.has())
        {
          i = paramObject.uint32_remain_at_all_count_for_group.get();
          int j = 0;
          if (paramObject.uint32_remain_at_all_count_for_uin.has()) {
            j = paramObject.uint32_remain_at_all_count_for_uin.get();
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler.atAll", 2, "handleGetAtAllRemainCountInfo:" + str + ", groupRemainCnt=" + i + ", memberRemainCnt=" + j + ", beCanAtAll=" + bool + ", tips1=" + paramToServiceMsg + ", tips2=" + paramFromServiceMsg);
          }
          a(57, true, new Object[] { str, Boolean.valueOf(bool), paramToServiceMsg, paramFromServiceMsg });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(57, false, arrayOfObject);
        return;
      }
      int i = 0;
      continue;
      label415:
      paramFromServiceMsg = "";
      continue;
      label422:
      paramToServiceMsg = "";
    }
  }
  
  /* Error */
  private void aj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 453	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +912 -> 916
    //   7: aload_3
    //   8: ifnull +908 -> 916
    //   11: iconst_1
    //   12: istore 7
    //   14: iconst_1
    //   15: istore 6
    //   17: iconst_1
    //   18: istore 4
    //   20: iload 7
    //   22: ifeq +1083 -> 1105
    //   25: iload 6
    //   27: istore 5
    //   29: aload_1
    //   30: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   33: ldc_w 2510
    //   36: iconst_0
    //   37: invokevirtual 2512	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   40: istore 8
    //   42: iload 6
    //   44: istore 5
    //   46: aload_0
    //   47: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: bipush 50
    //   52: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   55: checkcast 2514	com/tencent/mobileqq/app/FriendsManager
    //   58: astore 17
    //   60: iload 6
    //   62: istore 5
    //   64: aload_0
    //   65: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: bipush 51
    //   70: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   73: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   76: astore 18
    //   78: iload 6
    //   80: istore 5
    //   82: aload_1
    //   83: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   86: ldc_w 268
    //   89: invokevirtual 136	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokestatic 967	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   95: invokevirtual 970	java/lang/Long:longValue	()J
    //   98: lstore 10
    //   100: iload 6
    //   102: istore 5
    //   104: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +56 -> 163
    //   110: iload 6
    //   112: istore 5
    //   114: ldc 96
    //   116: iconst_2
    //   117: new 166	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 2516
    //   127: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: iload 7
    //   132: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   135: ldc_w 2518
    //   138: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: lload 10
    //   143: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   146: ldc_w 2520
    //   149: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: iload 8
    //   154: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   157: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: iload 6
    //   165: istore 5
    //   167: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   170: dup
    //   171: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   174: astore_2
    //   175: iload 6
    //   177: istore 5
    //   179: aload_2
    //   180: aload_3
    //   181: checkcast 151	[B
    //   184: checkcast 151	[B
    //   187: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   190: pop
    //   191: aload_2
    //   192: ifnull +16 -> 208
    //   195: iload 6
    //   197: istore 5
    //   199: aload_2
    //   200: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   203: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   206: istore 4
    //   208: aload_2
    //   209: ifnull +893 -> 1102
    //   212: iload 4
    //   214: istore 5
    //   216: aload_2
    //   217: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   223: istore 9
    //   225: iload 9
    //   227: ifeq +875 -> 1102
    //   230: aload_2
    //   231: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   234: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   237: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   240: astore_3
    //   241: new 485	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   244: dup
    //   245: invokespecial 486	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   248: astore_2
    //   249: aload_2
    //   250: aload_3
    //   251: invokevirtual 487	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   254: pop
    //   255: lload 10
    //   257: aload_2
    //   258: getfield 494	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   261: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   264: lcmp
    //   265: ifne +727 -> 992
    //   268: new 2343	java/lang/StringBuffer
    //   271: dup
    //   272: invokespecial 2344	java/lang/StringBuffer:<init>	()V
    //   275: astore 19
    //   277: aload_2
    //   278: getfield 2523	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   281: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   284: astore_2
    //   285: new 53	java/util/HashMap
    //   288: dup
    //   289: aload_2
    //   290: invokeinterface 565 1 0
    //   295: invokespecial 72	java/util/HashMap:<init>	(I)V
    //   298: astore 20
    //   300: aload_2
    //   301: invokeinterface 221 1 0
    //   306: astore 21
    //   308: aload 21
    //   310: invokeinterface 226 1 0
    //   315: ifeq +607 -> 922
    //   318: aload 21
    //   320: invokeinterface 230 1 0
    //   325: checkcast 2525	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo
    //   328: astore 23
    //   330: ldc_w 368
    //   333: astore 14
    //   335: ldc_w 368
    //   338: astore 15
    //   340: ldc_w 368
    //   343: astore 16
    //   345: aload 23
    //   347: getfield 2528	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   350: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   353: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   356: astore 22
    //   358: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq +25 -> 386
    //   364: aload 19
    //   366: ldc_w 2530
    //   369: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   372: pop
    //   373: aload 19
    //   375: aload 22
    //   377: iconst_0
    //   378: iconst_4
    //   379: invokevirtual 1723	java/lang/String:substring	(II)Ljava/lang/String;
    //   382: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   385: pop
    //   386: aload 23
    //   388: getfield 2533	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:str_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   391: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   394: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   397: astore 24
    //   399: aload 14
    //   401: astore_2
    //   402: aload 16
    //   404: astore_3
    //   405: aload 24
    //   407: ifnull +190 -> 597
    //   410: aload 14
    //   412: astore_2
    //   413: aload 16
    //   415: astore_3
    //   416: aload 24
    //   418: arraylength
    //   419: ifle +178 -> 597
    //   422: new 291	java/lang/String
    //   425: dup
    //   426: aload 24
    //   428: invokespecial 2442	java/lang/String:<init>	([B)V
    //   431: astore_3
    //   432: aload_1
    //   433: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   436: getstatic 2536	com/tencent/mobileqq/utils/ContactUtils:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   439: getstatic 2537	com/tencent/mobileqq/utils/ContactUtils:jdField_a_of_type_Int	I
    //   442: invokevirtual 1902	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   445: istore 4
    //   447: aload_1
    //   448: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   451: getstatic 2538	com/tencent/mobileqq/utils/ContactUtils:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   454: lconst_0
    //   455: invokevirtual 1463	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   458: lstore 12
    //   460: iload 4
    //   462: getstatic 2539	com/tencent/mobileqq/utils/ContactUtils:jdField_b_of_type_Int	I
    //   465: if_icmpne +73 -> 538
    //   468: aload_0
    //   469: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   472: invokevirtual 1152	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   475: new 166	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   482: lload 10
    //   484: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   487: ldc_w 368
    //   490: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: iconst_1
    //   497: lload 12
    //   499: invokevirtual 2542	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   502: astore_2
    //   503: aload_2
    //   504: ifnull +34 -> 538
    //   507: aload_2
    //   508: instanceof 2544
    //   511: ifeq +27 -> 538
    //   514: aload_2
    //   515: checkcast 2544	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   518: aload_0
    //   519: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   522: aload_3
    //   523: invokestatic 2550	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   526: ldc_w 2551
    //   529: invokevirtual 2553	com/tencent/common/app/BaseApplicationImpl:getString	(I)Ljava/lang/String;
    //   532: invokevirtual 2556	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   535: invokevirtual 2560	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:updateUniteGrayTipMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   538: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   541: ifeq +570 -> 1111
    //   544: aload 19
    //   546: ldc_w 2562
    //   549: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   552: pop
    //   553: aload 19
    //   555: aload_3
    //   556: invokestatic 2565	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   559: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   562: pop
    //   563: aload 19
    //   565: ldc_w 2567
    //   568: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   571: ldc_w 2569
    //   574: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   577: iload 4
    //   579: invokevirtual 2572	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   582: ldc_w 2574
    //   585: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   588: lload 12
    //   590: invokevirtual 2577	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   593: pop
    //   594: goto +517 -> 1111
    //   597: aload_3
    //   598: astore 14
    //   600: aload_3
    //   601: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   604: ifeq +44 -> 648
    //   607: aload_3
    //   608: astore 14
    //   610: iload 8
    //   612: ifeq +36 -> 648
    //   615: aload_3
    //   616: astore 14
    //   618: aload 17
    //   620: ifnull +28 -> 648
    //   623: aload_3
    //   624: astore 14
    //   626: aload 17
    //   628: aload 22
    //   630: invokevirtual 2579	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Z
    //   633: ifeq +15 -> 648
    //   636: aload 17
    //   638: aload 22
    //   640: invokevirtual 2582	com/tencent/mobileqq/app/FriendsManager:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   643: invokevirtual 2587	com/tencent/mobileqq/data/Friends:getFriendNickWithoutUin	()Ljava/lang/String;
    //   646: astore 14
    //   648: aload 23
    //   650: getfield 2590	tencent/im/oidb/cmd0x787/oidb_0x787$MemberLevelInfo:bytes_nick_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   653: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   656: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   659: astore_3
    //   660: aload_3
    //   661: ifnull +435 -> 1096
    //   664: aload_3
    //   665: arraylength
    //   666: ifle +430 -> 1096
    //   669: aload 14
    //   671: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   674: ifeq +422 -> 1096
    //   677: new 291	java/lang/String
    //   680: dup
    //   681: aload_3
    //   682: invokespecial 2442	java/lang/String:<init>	([B)V
    //   685: astore 14
    //   687: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   690: ifeq +426 -> 1116
    //   693: aload 19
    //   695: ldc_w 2592
    //   698: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   701: pop
    //   702: aload 19
    //   704: aload 14
    //   706: invokestatic 2565	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/String;)Ljava/lang/String;
    //   709: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   712: pop
    //   713: goto +403 -> 1116
    //   716: aload 14
    //   718: astore 15
    //   720: aload 14
    //   722: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   725: ifeq +21 -> 746
    //   728: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq +391 -> 1122
    //   734: aload 19
    //   736: ldc_w 2594
    //   739: invokevirtual 2352	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   742: pop
    //   743: goto +379 -> 1122
    //   746: aload 20
    //   748: aload 22
    //   750: aload 15
    //   752: invokeinterface 1859 3 0
    //   757: pop
    //   758: aload 18
    //   760: ifnull -452 -> 308
    //   763: aload_2
    //   764: astore 14
    //   766: aload_2
    //   767: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   770: ifeq +6 -> 776
    //   773: aconst_null
    //   774: astore 14
    //   776: aload_3
    //   777: astore_2
    //   778: aload_3
    //   779: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   782: ifeq +5 -> 787
    //   785: aconst_null
    //   786: astore_2
    //   787: aload 18
    //   789: lload 10
    //   791: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   794: aload 22
    //   796: aload 14
    //   798: bipush 156
    //   800: aload_2
    //   801: aconst_null
    //   802: bipush 156
    //   804: bipush 156
    //   806: bipush 156
    //   808: ldc2_w 2595
    //   811: bipush 156
    //   813: ldc2_w 2595
    //   816: ldc2_w 2597
    //   819: aconst_null
    //   820: bipush 156
    //   822: invokevirtual 2601	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJBJDLjava/lang/String;I)Z
    //   825: pop
    //   826: goto -518 -> 308
    //   829: astore_1
    //   830: iconst_0
    //   831: istore 4
    //   833: iconst_0
    //   834: istore 7
    //   836: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   839: ifeq +13 -> 852
    //   842: ldc 96
    //   844: iconst_2
    //   845: ldc_w 2603
    //   848: aload_1
    //   849: invokestatic 2607	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   852: iload 4
    //   854: istore 5
    //   856: iload 7
    //   858: istore 8
    //   860: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   863: ifeq +39 -> 902
    //   866: ldc 96
    //   868: iconst_2
    //   869: new 166	java/lang/StringBuilder
    //   872: dup
    //   873: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   876: ldc_w 2609
    //   879: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: invokestatic 597	java/lang/System:currentTimeMillis	()J
    //   885: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   888: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   891: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   894: iload 7
    //   896: istore 8
    //   898: iload 4
    //   900: istore 5
    //   902: aload_0
    //   903: bipush 58
    //   905: iload 8
    //   907: iload 5
    //   909: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   912: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   915: return
    //   916: iconst_0
    //   917: istore 7
    //   919: goto -905 -> 14
    //   922: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   925: ifeq +14 -> 939
    //   928: ldc 96
    //   930: iconst_2
    //   931: aload 19
    //   933: invokevirtual 2353	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   936: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   939: lload 10
    //   941: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   944: invokestatic 2039	com/tencent/mobileqq/troop/utils/TroopNameHelper:a	(Ljava/lang/String;)V
    //   947: aload_0
    //   948: bipush 58
    //   950: iload 7
    //   952: aload 20
    //   954: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   957: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   960: ifeq -45 -> 915
    //   963: ldc 96
    //   965: iconst_2
    //   966: new 166	java/lang/StringBuilder
    //   969: dup
    //   970: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   973: ldc_w 2609
    //   976: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokestatic 597	java/lang/System:currentTimeMillis	()J
    //   982: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   985: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   991: return
    //   992: iconst_0
    //   993: istore 4
    //   995: iconst_0
    //   996: istore 7
    //   998: iload 4
    //   1000: istore 5
    //   1002: iload 7
    //   1004: istore 8
    //   1006: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1009: ifeq -107 -> 902
    //   1012: ldc 96
    //   1014: iconst_2
    //   1015: new 166	java/lang/StringBuilder
    //   1018: dup
    //   1019: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1022: ldc_w 2609
    //   1025: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1028: invokestatic 597	java/lang/System:currentTimeMillis	()J
    //   1031: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1034: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1037: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1040: iload 4
    //   1042: istore 5
    //   1044: iload 7
    //   1046: istore 8
    //   1048: goto -146 -> 902
    //   1051: astore_1
    //   1052: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1055: ifeq +31 -> 1086
    //   1058: ldc 96
    //   1060: iconst_2
    //   1061: new 166	java/lang/StringBuilder
    //   1064: dup
    //   1065: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1068: ldc_w 2609
    //   1071: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: invokestatic 597	java/lang/System:currentTimeMillis	()J
    //   1077: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1080: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1083: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1086: aload_1
    //   1087: athrow
    //   1088: astore_1
    //   1089: iload 5
    //   1091: istore 4
    //   1093: goto -260 -> 833
    //   1096: aload 15
    //   1098: astore_3
    //   1099: goto -383 -> 716
    //   1102: goto -107 -> 995
    //   1105: iconst_1
    //   1106: istore 4
    //   1108: goto -110 -> 998
    //   1111: aload_3
    //   1112: astore_2
    //   1113: goto -516 -> 597
    //   1116: aload 14
    //   1118: astore_3
    //   1119: goto -403 -> 716
    //   1122: ldc_w 2611
    //   1125: astore 15
    //   1127: goto -381 -> 746
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1130	0	this	TroopHandler
    //   0	1130	1	paramToServiceMsg	ToServiceMsg
    //   0	1130	2	paramFromServiceMsg	FromServiceMsg
    //   0	1130	3	paramObject	Object
    //   18	1089	4	i	int
    //   27	1063	5	j	int
    //   15	181	6	k	int
    //   12	1033	7	bool1	boolean
    //   40	1007	8	bool2	boolean
    //   223	3	9	bool3	boolean
    //   98	842	10	l1	long
    //   458	131	12	l2	long
    //   333	784	14	localObject1	Object
    //   338	788	15	localObject2	Object
    //   343	71	16	str1	String
    //   58	579	17	localFriendsManager	FriendsManager
    //   76	712	18	localTroopManager	TroopManager
    //   275	657	19	localStringBuffer	StringBuffer
    //   298	655	20	localHashMap	HashMap
    //   306	13	21	localIterator	Iterator
    //   356	439	22	str2	String
    //   328	321	23	localMemberLevelInfo	oidb_0x787.MemberLevelInfo
    //   397	30	24	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   230	308	829	java/lang/Exception
    //   308	330	829	java/lang/Exception
    //   345	386	829	java/lang/Exception
    //   386	399	829	java/lang/Exception
    //   416	503	829	java/lang/Exception
    //   507	538	829	java/lang/Exception
    //   538	594	829	java/lang/Exception
    //   600	607	829	java/lang/Exception
    //   626	648	829	java/lang/Exception
    //   648	660	829	java/lang/Exception
    //   664	713	829	java/lang/Exception
    //   720	743	829	java/lang/Exception
    //   746	758	829	java/lang/Exception
    //   766	773	829	java/lang/Exception
    //   778	785	829	java/lang/Exception
    //   787	826	829	java/lang/Exception
    //   922	939	829	java/lang/Exception
    //   939	957	829	java/lang/Exception
    //   29	42	1051	finally
    //   46	60	1051	finally
    //   64	78	1051	finally
    //   82	100	1051	finally
    //   104	110	1051	finally
    //   114	163	1051	finally
    //   167	175	1051	finally
    //   179	191	1051	finally
    //   199	208	1051	finally
    //   216	225	1051	finally
    //   230	308	1051	finally
    //   308	330	1051	finally
    //   345	386	1051	finally
    //   386	399	1051	finally
    //   416	503	1051	finally
    //   507	538	1051	finally
    //   538	594	1051	finally
    //   600	607	1051	finally
    //   626	648	1051	finally
    //   648	660	1051	finally
    //   664	713	1051	finally
    //   720	743	1051	finally
    //   746	758	1051	finally
    //   766	773	1051	finally
    //   778	785	1051	finally
    //   787	826	1051	finally
    //   836	852	1051	finally
    //   922	939	1051	finally
    //   939	957	1051	finally
    //   29	42	1088	java/lang/Exception
    //   46	60	1088	java/lang/Exception
    //   64	78	1088	java/lang/Exception
    //   82	100	1088	java/lang/Exception
    //   104	110	1088	java/lang/Exception
    //   114	163	1088	java/lang/Exception
    //   167	175	1088	java/lang/Exception
    //   179	191	1088	java/lang/Exception
    //   199	208	1088	java/lang/Exception
    //   216	225	1088	java/lang/Exception
  }
  
  private void ak(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    for (;;)
    {
      return;
      String str = paramToServiceMsg.extraData.getString("troopUin");
      paramToServiceMsg = paramToServiceMsg.extraData.getString("type");
      if (paramFromServiceMsg.getResultCode() != 1000)
      {
        a(61, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null))
        {
          a(61, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(61, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
        return;
      }
      paramObject = new cmd0x8ca.RspBody();
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        long l = paramObject.opt_uint64_group_code.get();
        ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "" + l, Integer.valueOf(0));
        a(61, true, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
        if (QLog.isColorLevel())
        {
          QLog.i("TroopHandler", 2, "handleClearTroopAioRedDot, succ, troopUin=" + str);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(61, false, new Object[] { str, paramToServiceMsg, Boolean.valueOf(true) });
      }
    }
  }
  
  private void al(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new UserFollowStatus.UserFollowStatusRsp();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (!paramFromServiceMsg.follow_status_info_list.has()) {
          break label283;
        }
        paramObject = paramFromServiceMsg.follow_status_info_list.get().iterator();
        if (!paramObject.hasNext()) {
          break label283;
        }
        paramFromServiceMsg = (UserFollowStatus.UserFollowStatusInfo)paramObject.next();
        if (paramFromServiceMsg.dst_uin.get() != Long.parseLong(paramToServiceMsg.extraData.getString("distUin"))) {
          continue;
        }
        paramObject = paramFromServiceMsg.dst_uin.get() + "";
        int i = paramFromServiceMsg.follow_status.get();
        if (i != 1) {
          break label277;
        }
        bool = true;
        a(86, true, new Object[] { paramObject, Boolean.valueOf(bool) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("TroopHandlerQ.nearby.follow", 2, "handleGetFollowStatus, uin:" + paramObject + "|followStatus:" + i);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        a(86, false, new Object[] { paramToServiceMsg.extraData.getString("distUin"), Boolean.valueOf(false) });
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("TroopHandlerQ.nearby.follow", 2, "handleGetFollowStatus,InvalidProtocolBufferMicroException: " + paramFromServiceMsg.toString());
      return;
      label277:
      boolean bool = false;
    }
    label283:
    a(86, false, new Object[] { paramToServiceMsg.extraData.getString("distUin"), Boolean.valueOf(false) });
  }
  
  private void am(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler.troopgroup_vedio.invite", 2, "receive cmd=OidbSvc.0x6d1, DealInviteRspBody, isSuccess:" + paramFromServiceMsg.isSuccess());
    }
    try
    {
      if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        new cmd0x6d1.DealInviteRspBody().mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("TroopHandler", 2, "receive cmd=OidbSvc.0x6d1.DealInviteReqBody, InvalidProtocolBufferMicroException");
    }
  }
  
  private void an(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xa2a.RspBody localRspBody = new oidb_0xa2a.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "handleGetDetailOnlineMemberList, retCode=" + i + ",troopUin=" + paramToServiceMsg);
    }
    if (i == 0)
    {
      paramFromServiceMsg = localRspBody.online_info.get();
      paramObject = localRspBody.infos.get();
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramObject.iterator();
      while (localIterator.hasNext())
      {
        oidb_0xa2a.UserInfo localUserInfo = (oidb_0xa2a.UserInfo)localIterator.next();
        TroopOnlineMemberItem localTroopOnlineMemberItem = new TroopOnlineMemberItem();
        localTroopOnlineMemberItem.jdField_a_of_type_JavaLangString = String.valueOf(localUserInfo.uin.get());
        localTroopOnlineMemberItem.c = localUserInfo.nick.get();
        localTroopOnlineMemberItem.jdField_b_of_type_JavaLangString = localUserInfo.tag.get();
        localTroopOnlineMemberItem.jdField_a_of_type_Int = localUserInfo.tag_color.get();
        localArrayList.add(localTroopOnlineMemberItem);
      }
      i = localRspBody.cache_time.get();
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "handleGetDetailOnlineMemberList, onlineTip=" + paramFromServiceMsg + ",size=" + paramObject.size() + ",cacheTime=" + i);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        ((TroopOnlineMemberManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233)).a(paramToServiceMsg, localArrayList, i, paramFromServiceMsg);
        if (QLog.isColorLevel())
        {
          i = 0;
          while ((i < 3) && (i < localArrayList.size()))
          {
            QLog.i("TroopHandler", 2, "handleGetDetailOnlineMemberList, uin=" + ((TroopOnlineMemberItem)localArrayList.get(i)).jdField_a_of_type_JavaLangString + ",name=" + ((TroopOnlineMemberItem)localArrayList.get(i)).c + ",tag=" + ((TroopOnlineMemberItem)localArrayList.get(i)).jdField_b_of_type_JavaLangString);
            i += 1;
          }
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.i("TroopHandler", 2, "getDetailOnlineMemberList, app == null");
      }
      a(97, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    QLog.i("TroopHandler", 1, "handleGetDetailOnlineMemberList error, retCode=" + i);
    a(97, false, new Object[] { paramToServiceMsg, "" });
  }
  
  private void ao(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xa2a.RspBody localRspBody = new oidb_0xa2a.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "handleGetOnlineMemberTips, retCode=" + i + ",troopUin=" + paramToServiceMsg);
    }
    if (i == 0)
    {
      i = localRspBody.cache_time.get();
      paramFromServiceMsg = localRspBody.online_info.get();
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "handleGetOnlineMemberTips, cacheTime=" + i + ", onlineTip:" + paramFromServiceMsg);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((TroopOnlineMemberManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233)).a(paramToServiceMsg, i, paramFromServiceMsg);
      }
      a(99, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    QLog.i("TroopHandler", 1, "handleGetOnlineMemberTips, retCode=" + i);
    a(99, false, new Object[] { paramToServiceMsg, null });
  }
  
  private void ap(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xa2a.RspBody localRspBody = new oidb_0xa2a.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "handleGetAllOnlineMemberList, retCode=" + i + ",troopUin=" + paramToServiceMsg);
    }
    if (i == 0)
    {
      paramFromServiceMsg = new ArrayList();
      paramObject = localRspBody.infos.get().iterator();
      while (paramObject.hasNext()) {
        paramFromServiceMsg.add(String.valueOf(((oidb_0xa2a.UserInfo)paramObject.next()).uin.get()));
      }
      i = localRspBody.cache_time.get();
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        ((TroopOnlineMemberManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233)).a(paramToServiceMsg, paramFromServiceMsg, i);
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "handleGetAllOnlineMemberList, size=" + paramFromServiceMsg.size());
      }
      a(98, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
      return;
    }
    QLog.i("TroopHandler", 1, "handleGetAllOnlineMemberList, retCode=" + i);
    a(98, false, new Object[] { paramToServiceMsg, null });
  }
  
  private void aq(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troopUin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troopCode");
    cmd0xb01.RspBody localRspBody = new cmd0xb01.RspBody();
    int n = a(paramFromServiceMsg, paramObject, localRspBody);
    int k = 0;
    int m = 0;
    int i = -1;
    int j = i;
    if (n == 0)
    {
      j = m;
      if (localRspBody.uint32_result.has())
      {
        k = localRspBody.uint32_result.get();
        if (k == 0)
        {
          i = 1;
          if (k == 2)
          {
            double d1 = localRspBody.double_density.get();
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_addFrd", "", "nonGreyTip", "density", 0, 0, str, "", String.valueOf(d1), "");
          }
          j = i;
          i = k;
        }
      }
      else
      {
        paramFromServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
        paramObject = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_security_check_flag", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str });
        paramFromServiceMsg.edit().putInt(paramObject, j).apply();
        k = j;
        j = i;
      }
    }
    else
    {
      if (n != 0) {
        break label341;
      }
    }
    label341:
    for (boolean bool = true;; bool = false)
    {
      a(100, bool, new Object[] { Integer.valueOf(k), str, paramToServiceMsg });
      if (QLog.isDevelopLevel()) {
        QLog.d("TroopHandler", 4, String.format(Locale.getDefault(), "handleBatchAddFriendSecurityCheck troopUin: %s, result: %s, iSecurityResult: %s, nCheckResult: %s", new Object[] { str, Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(j) }));
      }
      if ((n == 0) && (k == 1)) {
        t(str);
      }
      return;
      i = 2;
      break;
    }
  }
  
  private void ar(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.extraData.get("troopUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isProfileAppListChangedFromWebOperate");
    if (!paramFromServiceMsg.isSuccess())
    {
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, -1, str, "", "", "");
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
      i = paramToServiceMsg.uint32_result.get();
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TroopHandler.troop.troop_app", 2, "mGetTroopAppListObserver: result = " + i);
        }
        ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, i, str, "false", "", "");
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopHandler.troop.troop_app", 2, "mGetTroopAppListObserver: " + paramToServiceMsg.getMessage());
      }
      ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, -2, str, "wrong data", "", "");
      return;
    }
    ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "BizTechReport", "", "troopInfoCard", "getAppList", 0, i, str, "", "", "");
    paramFromServiceMsg = new oidb_0xaf4.RspBody();
    paramObject = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
    int i = paramToServiceMsg.uint32_service_type.get();
    ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(str, paramObject);
    ((TroopInfoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(str, paramObject);
    if (bool)
    {
      paramToServiceMsg = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(false, str);
      }
    }
    paramFromServiceMsg.mergeFrom(paramObject);
    a(106, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i) });
  }
  
  private void as(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    try
    {
      oidb_0x783.RspBody localRspBody = new oidb_0x783.RspBody();
      i = a(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        i = localRspBody.uint32_result.get();
        if (i == 0)
        {
          paramFromServiceMsg = localRspBody.rpt_remark_infos.get();
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
            return;
          }
          paramFromServiceMsg = ((oidb_0x783.RemarkInfo)paramFromServiceMsg.get(0)).bytes_remark.get().toStringUtf8();
          a(110, true, new Object[] { (String)paramToServiceMsg.extraData.get("memberUin"), paramFromServiceMsg });
          return;
        }
        QLog.e("TroopHandler", 1, new Object[] { "handleGetAutoRemark result failed! result code = ", Integer.valueOf(i), localRspBody.str_errmsg.get() });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TroopHandler", 1, "handleGetAutoRemark exception. e=", paramToServiceMsg);
      return;
    }
    QLog.e("TroopHandler", 1, new Object[] { "handleGetAutoRemark failed! retCode = ", Integer.valueOf(i) });
  }
  
  private void b(oidb_0x496.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.robot_config;
    int i = BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).getInt("troop_robot_config_version", 0);
    if ((paramRspBody.has()) && (i != paramRspBody.version.get()))
    {
      TroopRobotManager localTroopRobotManager = (TroopRobotManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(202);
      localTroopRobotManager.a(paramRspBody);
      localTroopRobotManager.b(paramRspBody);
    }
  }
  
  private void b(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("troop_uin");
    int j = paramToServiceMsg.extraData.getInt("reqType");
    long l = paramToServiceMsg.extraData.getLong("timestamp");
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.set_show_external_status", 2, "handleSwitchTroopShowExStatusBeforeJoinedTroopRsp, handle response begin==>" + "isSuccess:" + paramBoolean + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|troopUin:" + str + "|reqType:" + j + "|timestamp:" + l);
    }
    paramObject = new Object[4];
    paramObject[0] = str;
    paramObject[1] = Integer.valueOf(j);
    paramObject[2] = Integer.valueOf(paramFromServiceMsg.getResultCode());
    if (j == 1) {}
    for (int i = 0;; i = 1)
    {
      paramObject[3] = Integer.valueOf(i);
      if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
        a(54, false, paramObject);
      }
      if ("setShowExternalStatus0x8d4".equals(paramToServiceMsg.extraData.getString("0x8d4_cmd_key"))) {
        break;
      }
      return;
    }
    paramToServiceMsg = new cmd0x8b4.RspBody();
    try
    {
      paramToServiceMsg.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      if ((paramFromServiceMsg.isSuccess()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        a(54, true, new Object[] { str, Integer.valueOf(j), Integer.valueOf(0), Integer.valueOf(paramToServiceMsg.uint32_flag.get()) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(54, false, paramObject);
      return;
    }
    a(54, false, paramObject);
  }
  
  private void c(oidb_0x496.RspBody paramRspBody)
  {
    paramRspBody = paramRspBody.aio_keyword_config;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "handleAioKeywordConfig, app == null");
      }
    }
    label167:
    do
    {
      do
      {
        do
        {
          return;
          if (!paramRspBody.has()) {
            break label167;
          }
          if (!paramRspBody.version.has()) {
            break;
          }
          int i = SharedPreUtils.aM(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          if (paramRspBody.version.get() != i)
          {
            if (QLog.isColorLevel()) {
              QLog.i("TroopHandler", 2, "handleAioKeywordConfig, version change, new_version=" + paramRspBody.version.get() + "old_version=" + i);
            }
            ThreadManager.post(new zkx(this, paramRspBody), 8, null, true);
            return;
          }
        } while (!QLog.isColorLevel());
        QLog.i("TroopHandler", 2, "handleAioKeywordConfig, version no change");
        return;
      } while (!QLog.isColorLevel());
      QLog.i("TroopHandler", 2, "handleAioKeywordConfig, do not has version");
      return;
    } while (!QLog.isColorLevel());
    QLog.i("TroopHandler", 2, "handleAioKeywordConfig, do not has aioKeyword");
  }
  
  private void c(boolean paramBoolean, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleGetShowExtTroopListRsp");
    }
    if ((!paramBoolean) || (paramOIDBSSOPkg == null)) {
      a(56, paramBoolean, null);
    }
    for (;;)
    {
      return;
      paramObject = paramToServiceMsg.extraData.getString("target_uin");
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject1 = new cmd0x8b4.RspBody();
      try
      {
        ((cmd0x8b4.RspBody)localObject1).mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
        paramOIDBSSOPkg = new Object[2];
        paramOIDBSSOPkg[0] = Integer.valueOf(((cmd0x8b4.RspBody)localObject1).uint32_result.get());
        paramOIDBSSOPkg[1] = null;
        if ((paramFromServiceMsg.isSuccess()) && (((cmd0x8b4.RspBody)localObject1).uint32_result.get() == 0)) {
          if (!((cmd0x8b4.RspBody)localObject1).rpt_group_info.has())
          {
            a(56, paramBoolean, paramOIDBSSOPkg);
            return;
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramOIDBSSOPkg)
      {
        a(56, paramBoolean, null);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopHandler.troop.get_show_external_troop_list", 2, "handleGetShowExtTroopListRsp, handle rsp begin==>" + "|ssoSeq:" + paramFromServiceMsg.getRequestSsoSeq() + "|ServiceCmd:" + paramToServiceMsg.getServiceCmd() + "|destUin:" + paramObject + "|seTroopArray:" + localStringBuilder.toString());
        return;
        paramOIDBSSOPkg = new ArrayList();
        localObject2 = ((cmd0x8b4.RspBody)localObject1).rpt_group_info.get();
        localStringBuilder.append("groupInfoList size:").append(((List)localObject2).size());
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          cmd0x8b4.GroupInfo localGroupInfo = (cmd0x8b4.GroupInfo)((Iterator)localObject2).next();
          paramOIDBSSOPkg.add(new ShowExternalTroop(localGroupInfo));
          localStringBuilder.append("[uint64_gc:").append(localGroupInfo.uint64_gc.get()).append(",addedTimestamp:").append(localGroupInfo.uint32_set_display_time.get()).append("], ");
        }
      }
      catch (NullPointerException paramOIDBSSOPkg)
      {
        for (;;)
        {
          a(56, paramBoolean, null);
          continue;
          localObject1 = ((cmd0x8b4.RspBody)localObject1).bytes_text_label.get();
          Object localObject2 = new ArrayList();
          int i = 0;
          while (i < ((List)localObject1).size())
          {
            ((List)localObject2).add(((ByteStringMicro)((List)localObject1).get(i)).toStringUtf8());
            i += 1;
          }
          a(56, paramBoolean, new Object[] { Integer.valueOf(0), paramOIDBSSOPkg, localObject2 });
          continue;
          a(56, paramBoolean, paramOIDBSSOPkg);
        }
      }
    }
  }
  
  private void v(String paramString)
  {
    MqqHandler localMqqHandler = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(AVNotifyCenter.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(10011);
      localMessage.obj = Long.valueOf(paramString);
      localMqqHandler.sendMessage(localMessage);
    }
  }
  
  /* Error */
  public void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 2226
    //   7: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   10: lstore 10
    //   12: aload_2
    //   13: invokevirtual 453	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: istore 14
    //   18: aload_1
    //   19: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 2999
    //   25: invokevirtual 264	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   28: istore 15
    //   30: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +42 -> 75
    //   36: ldc_w 3001
    //   39: iconst_2
    //   40: new 166	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 3003
    //   50: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: lload 10
    //   55: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   58: ldc_w 3005
    //   61: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: iload 14
    //   66: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   69: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: lload 10
    //   77: lconst_0
    //   78: lcmp
    //   79: ifeq +8 -> 87
    //   82: iload 14
    //   84: ifne +4 -> 88
    //   87: return
    //   88: aload_0
    //   89: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   92: bipush 51
    //   94: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   97: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   100: astore 16
    //   102: aconst_null
    //   103: astore_1
    //   104: aload 16
    //   106: ifnull +30 -> 136
    //   109: aload 16
    //   111: new 166	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   118: lload 10
    //   120: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 368
    //   126: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   135: astore_1
    //   136: aload_1
    //   137: ifnonnull +993 -> 1130
    //   140: new 511	com/tencent/mobileqq/data/TroopInfo
    //   143: dup
    //   144: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   147: astore_1
    //   148: aload_1
    //   149: lload 10
    //   151: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   154: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   157: aload 16
    //   159: ifnull +9 -> 168
    //   162: aload 16
    //   164: aload_1
    //   165: invokevirtual 1479	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   168: aload_3
    //   169: checkcast 3007	KQQ/RespBatchProcess
    //   172: astore 17
    //   174: aload 17
    //   176: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   179: ifnull -92 -> 87
    //   182: aload 17
    //   184: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   187: invokevirtual 1172	java/util/ArrayList:size	()I
    //   190: ifeq -103 -> 87
    //   193: aload 17
    //   195: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   198: invokevirtual 1172	java/util/ArrayList:size	()I
    //   201: istore 9
    //   203: iconst_0
    //   204: istore 5
    //   206: iload 5
    //   208: iload 9
    //   210: if_icmpge +815 -> 1025
    //   213: aload 17
    //   215: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   218: iload 5
    //   220: invokevirtual 1585	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   223: checkcast 3012	KQQ/BatchResponse
    //   226: astore_2
    //   227: aload_2
    //   228: ifnull +10 -> 238
    //   231: aload_2
    //   232: getfield 3013	KQQ/BatchResponse:result	I
    //   235: ifeq +12 -> 247
    //   238: iload 5
    //   240: iconst_1
    //   241: iadd
    //   242: istore 5
    //   244: goto -38 -> 206
    //   247: aload_2
    //   248: getfield 3015	KQQ/BatchResponse:type	I
    //   251: iconst_1
    //   252: if_icmpne -14 -> 238
    //   255: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   258: dup
    //   259: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   262: astore_3
    //   263: aload_3
    //   264: aload_2
    //   265: getfield 3018	KQQ/BatchResponse:buffer	[B
    //   268: checkcast 151	[B
    //   271: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   274: pop
    //   275: aload_2
    //   276: getfield 3020	KQQ/BatchResponse:seq	I
    //   279: ifne -41 -> 238
    //   282: aload_3
    //   283: ifnull -45 -> 238
    //   286: aload_3
    //   287: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   290: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   293: ifeq -55 -> 238
    //   296: aload_3
    //   297: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   300: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   303: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   306: astore_3
    //   307: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   310: dup
    //   311: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   314: astore_2
    //   315: aload_2
    //   316: aload_3
    //   317: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   320: pop
    //   321: aconst_null
    //   322: astore_3
    //   323: aload_2
    //   324: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   327: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   330: astore 18
    //   332: aload 18
    //   334: ifnonnull +58 -> 392
    //   337: iconst_0
    //   338: istore 6
    //   340: goto +793 -> 1133
    //   343: aload_3
    //   344: ifnonnull -106 -> 238
    //   347: iload 7
    //   349: iload 6
    //   351: if_icmpge -113 -> 238
    //   354: aload 18
    //   356: iload 7
    //   358: invokeinterface 638 2 0
    //   363: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   366: astore 19
    //   368: aload 19
    //   370: ifnonnull +34 -> 404
    //   373: aload_3
    //   374: astore_2
    //   375: iload 7
    //   377: iconst_1
    //   378: iadd
    //   379: istore 7
    //   381: aload_2
    //   382: astore_3
    //   383: goto -40 -> 343
    //   386: astore_1
    //   387: aload_1
    //   388: invokevirtual 1261	java/lang/Exception:printStackTrace	()V
    //   391: return
    //   392: aload 18
    //   394: invokeinterface 565 1 0
    //   399: istore 6
    //   401: goto +732 -> 1133
    //   404: aload_3
    //   405: astore_2
    //   406: aload 19
    //   408: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   411: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   414: ifne -39 -> 375
    //   417: aload_3
    //   418: astore_2
    //   419: aload 19
    //   421: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   424: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   427: ifeq -52 -> 375
    //   430: aload 19
    //   432: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   435: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   438: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   441: astore_3
    //   442: aload_3
    //   443: astore_2
    //   444: aload_3
    //   445: ifnull -70 -> 375
    //   448: aload_3
    //   449: getfield 2301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   452: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   455: ifeq +15 -> 470
    //   458: aload_1
    //   459: aload_3
    //   460: getfield 2301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   463: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   466: i2l
    //   467: putfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   470: aload_3
    //   471: getfield 3023	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   474: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   477: ifeq +17 -> 494
    //   480: aload_1
    //   481: aload_3
    //   482: getfield 3023	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_class_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   485: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   488: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   491: putfield 3026	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   494: aload_3
    //   495: getfield 3029	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   498: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   501: ifeq +17 -> 518
    //   504: aload_1
    //   505: aload_3
    //   506: getfield 3029	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   509: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   512: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   515: putfield 1191	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   518: aload_3
    //   519: getfield 2306	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   522: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   525: ifeq +33 -> 558
    //   528: aload_1
    //   529: new 166	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   536: ldc_w 368
    //   539: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: aload_3
    //   543: getfield 2306	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   546: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   549: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   552: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: putfield 1211	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   558: aload_3
    //   559: getfield 3032	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_face	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   562: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   565: ifeq +15 -> 580
    //   568: aload_1
    //   569: aload_3
    //   570: getfield 3032	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_face	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   573: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   576: i2s
    //   577: putfield 1221	com/tencent/mobileqq/data/TroopInfo:troopface	S
    //   580: aload_3
    //   581: getfield 3035	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   584: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   587: ifeq +22 -> 609
    //   590: aload_1
    //   591: aload_3
    //   592: getfield 3035	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   595: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   598: putfield 1232	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   601: aload_1
    //   602: aload_1
    //   603: getfield 1232	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   606: putfield 1729	com/tencent/mobileqq/data/TroopInfo:wMemberNumClient	I
    //   609: aload_3
    //   610: getfield 3038	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_is_conf_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   613: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   616: ifeq +63 -> 679
    //   619: aload_3
    //   620: getfield 3038	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_is_conf_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   623: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   626: iconst_1
    //   627: if_icmpne +300 -> 927
    //   630: iconst_1
    //   631: istore 14
    //   633: aload_1
    //   634: iload 14
    //   636: putfield 1763	com/tencent/mobileqq/data/TroopInfo:isNewTroop	Z
    //   639: aload_3
    //   640: getfield 3041	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_is_modify_conf_group_face	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   643: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   646: iconst_1
    //   647: if_icmpne +286 -> 933
    //   650: iconst_1
    //   651: istore 14
    //   653: aload_1
    //   654: iload 14
    //   656: putfield 1769	com/tencent/mobileqq/data/TroopInfo:hasSetNewTroopHead	Z
    //   659: aload_3
    //   660: getfield 3044	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_is_modify_conf_group_name	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   663: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   666: iconst_1
    //   667: if_icmpne +272 -> 939
    //   670: iconst_1
    //   671: istore 14
    //   673: aload_1
    //   674: iload 14
    //   676: putfield 1775	com/tencent/mobileqq/data/TroopInfo:hasSetNewTroopName	Z
    //   679: aload_3
    //   680: getfield 3047	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_subscription_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   683: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   686: ifeq +14 -> 700
    //   689: aload_1
    //   690: aload_3
    //   691: getfield 3047	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_subscription_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   694: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   697: putfield 1708	com/tencent/mobileqq/data/TroopInfo:associatePubAccount	J
    //   700: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +44 -> 747
    //   706: ldc_w 3049
    //   709: iconst_2
    //   710: new 166	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   717: ldc_w 3003
    //   720: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: lload 10
    //   725: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   728: ldc_w 3005
    //   731: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: aload_1
    //   735: getfield 1708	com/tencent/mobileqq/data/TroopInfo:associatePubAccount	J
    //   738: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   741: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: iload 15
    //   749: ifeq +254 -> 1003
    //   752: iconst_1
    //   753: istore 8
    //   755: aload_1
    //   756: getfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   759: ldc2_w 3050
    //   762: lcmp
    //   763: ifne +182 -> 945
    //   766: iconst_0
    //   767: istore 4
    //   769: iload 4
    //   771: ifeq +56 -> 827
    //   774: aload_0
    //   775: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   778: bipush 31
    //   780: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   783: checkcast 3053	com/tencent/mobileqq/troop/data/TroopCreateLogic
    //   786: astore_2
    //   787: aload_2
    //   788: ifnull +39 -> 827
    //   791: aload_1
    //   792: invokevirtual 3055	com/tencent/mobileqq/data/TroopInfo:isNewTroop	()Z
    //   795: ifne +32 -> 827
    //   798: aload_2
    //   799: aload_0
    //   800: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   803: new 166	java/lang/StringBuilder
    //   806: dup
    //   807: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   810: lload 10
    //   812: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   815: ldc_w 368
    //   818: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokevirtual 3057	com/tencent/mobileqq/troop/data/TroopCreateLogic:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   827: aload_0
    //   828: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   831: invokevirtual 1152	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   834: new 166	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   841: lload 10
    //   843: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   846: ldc_w 368
    //   849: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   852: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokevirtual 3058	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Ljava/lang/String;)Z
    //   858: pop
    //   859: aload_3
    //   860: astore_2
    //   861: aload 16
    //   863: ifnull -488 -> 375
    //   866: aload_3
    //   867: astore_2
    //   868: aload_1
    //   869: ifnull -494 -> 375
    //   872: aload 16
    //   874: aload_1
    //   875: invokevirtual 3060	com/tencent/mobileqq/app/TroopManager:d	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   878: aload_3
    //   879: astore_2
    //   880: goto -505 -> 375
    //   883: astore_2
    //   884: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   887: ifeq +33 -> 920
    //   890: ldc_w 3001
    //   893: iconst_2
    //   894: new 166	java/lang/StringBuilder
    //   897: dup
    //   898: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   901: ldc_w 3003
    //   904: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_2
    //   908: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   911: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   917: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   920: aload_2
    //   921: invokevirtual 1261	java/lang/Exception:printStackTrace	()V
    //   924: goto -686 -> 238
    //   927: iconst_0
    //   928: istore 14
    //   930: goto -297 -> 633
    //   933: iconst_0
    //   934: istore 14
    //   936: goto -283 -> 653
    //   939: iconst_0
    //   940: istore 14
    //   942: goto -269 -> 673
    //   945: iload 8
    //   947: istore 4
    //   949: aload_1
    //   950: getfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   953: ldc2_w 3061
    //   956: lcmp
    //   957: ifne -188 -> 769
    //   960: iload 8
    //   962: istore 4
    //   964: aload_0
    //   965: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   968: invokevirtual 3066	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   971: ifnull -202 -> 769
    //   974: iload 8
    //   976: istore 4
    //   978: aload_0
    //   979: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   982: invokevirtual 3066	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   985: ldc_w 3068
    //   988: iconst_0
    //   989: invokeinterface 3069 3 0
    //   994: ifeq -225 -> 769
    //   997: iconst_0
    //   998: istore 4
    //   1000: goto -231 -> 769
    //   1003: aload_1
    //   1004: getfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   1007: lstore 12
    //   1009: aload_3
    //   1010: astore_2
    //   1011: lload 12
    //   1013: ldc2_w 3050
    //   1016: lcmp
    //   1017: ifne -642 -> 375
    //   1020: aload_3
    //   1021: astore_2
    //   1022: goto -647 -> 375
    //   1025: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1028: ifeq +68 -> 1096
    //   1031: ldc_w 3001
    //   1034: iconst_2
    //   1035: new 166	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1042: ldc_w 3003
    //   1045: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1048: lload 10
    //   1050: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1053: ldc_w 3005
    //   1056: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: aload_1
    //   1060: getfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   1063: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1066: ldc_w 3005
    //   1069: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: aload_1
    //   1073: getfield 3026	com/tencent/mobileqq/data/TroopInfo:mGroupClassExtText	Ljava/lang/String;
    //   1076: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: ldc_w 3005
    //   1082: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: iload 9
    //   1087: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1090: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1096: aload 16
    //   1098: ifnull -1011 -> 87
    //   1101: aload_1
    //   1102: ifnull -1015 -> 87
    //   1105: aload 16
    //   1107: aload_1
    //   1108: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1111: aload_0
    //   1112: bipush 105
    //   1114: iconst_1
    //   1115: iconst_1
    //   1116: anewarray 103	java/lang/Object
    //   1119: dup
    //   1120: iconst_0
    //   1121: aload_1
    //   1122: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1125: aastore
    //   1126: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1129: return
    //   1130: goto -962 -> 168
    //   1133: iconst_0
    //   1134: istore 7
    //   1136: goto -793 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1139	0	this	TroopHandler
    //   0	1139	1	paramToServiceMsg	ToServiceMsg
    //   0	1139	2	paramFromServiceMsg	FromServiceMsg
    //   0	1139	3	paramObject	Object
    //   767	232	4	i	int
    //   204	39	5	j	int
    //   338	62	6	k	int
    //   347	788	7	m	int
    //   753	222	8	n	int
    //   201	885	9	i1	int
    //   10	1039	10	l1	long
    //   1007	5	12	l2	long
    //   16	925	14	bool1	boolean
    //   28	720	15	bool2	boolean
    //   100	1006	16	localTroopManager	TroopManager
    //   172	42	17	localRespBatchProcess	RespBatchProcess
    //   330	63	18	localList	List
    //   366	65	19	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    // Exception table:
    //   from	to	target	type
    //   263	275	386	java/lang/Exception
    //   307	321	883	java/lang/Exception
    //   323	332	883	java/lang/Exception
    //   354	368	883	java/lang/Exception
    //   392	401	883	java/lang/Exception
    //   406	417	883	java/lang/Exception
    //   419	442	883	java/lang/Exception
    //   448	470	883	java/lang/Exception
    //   470	494	883	java/lang/Exception
    //   494	518	883	java/lang/Exception
    //   518	558	883	java/lang/Exception
    //   558	580	883	java/lang/Exception
    //   580	609	883	java/lang/Exception
    //   609	630	883	java/lang/Exception
    //   633	650	883	java/lang/Exception
    //   653	670	883	java/lang/Exception
    //   673	679	883	java/lang/Exception
    //   679	700	883	java/lang/Exception
    //   700	747	883	java/lang/Exception
    //   755	766	883	java/lang/Exception
    //   774	787	883	java/lang/Exception
    //   791	827	883	java/lang/Exception
    //   827	859	883	java/lang/Exception
    //   872	878	883	java/lang/Exception
    //   949	960	883	java/lang/Exception
    //   964	974	883	java/lang/Exception
    //   978	997	883	java/lang/Exception
    //   1003	1009	883	java/lang/Exception
  }
  
  protected void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
      a(72, false, new Object[] { null });
    }
    int i;
    int j;
    boolean bool;
    cmd0xca02.RspBody localRspBody;
    TroopAppMgr localTroopAppMgr;
    do
    {
      for (;;)
      {
        return;
        i = paramToServiceMsg.extraData.getInt("readType");
        j = paramToServiceMsg.extraData.getInt("groupType");
        bool = paramToServiceMsg.extraData.getBoolean("appListChangedFromWebOperate");
        if ((i == 2) || (i == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler.troop.troop_app", 2, new Object[] { "handleGetTroopAppList(), readType: ", Integer.valueOf(i), " ,groupType: ", Integer.valueOf(j) });
          }
          localRspBody = new cmd0xca02.RspBody();
          try
          {
            localRspBody.mergeFrom((byte[])paramObject);
            if (localRspBody.uint32_res.get() != 0) {
              break label782;
            }
            localTroopAppMgr = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
            if (localTroopAppMgr != null) {
              break label237;
            }
            a(72, false, new Object[] { null });
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler.troop.troop_app", 2, "handleGetTroopAppList==>troopAppMgr == null");
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            a(72, false, new Object[] { null });
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_app", 2, "Exception, handleGetTroopAppList");
    return;
    label237:
    if (bool) {
      localTroopAppMgr.a(false);
    }
    localTroopAppMgr.b(localRspBody.uint32_timestamp.get(), j);
    localTroopAppMgr.a(true, j);
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, "handleGetTroopAppList==>appListTimestamp:" + localRspBody.uint32_timestamp.get());
    }
    paramToServiceMsg = localRspBody.rpt_result.get();
    ArrayList localArrayList1 = new ArrayList();
    if (i == 1) {}
    for (paramFromServiceMsg = new ArrayList();; paramFromServiceMsg = null)
    {
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramToServiceMsg.iterator();
      for (;;)
      {
        label360:
        if (localIterator.hasNext())
        {
          paramObject = (cmd0xca02.Result)localIterator.next();
          if (paramObject.uint32_id.get() > 0) {
            if (paramObject.uint32_res.get() == 2)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopHandler.troop.troop_app", 2, "result.uint32_res.get() == 2|appid:" + paramObject.uint32_id.get() + "|appName:" + paramObject.string_name.get().toStringUtf8());
              }
              localTroopAppMgr.a(paramObject.uint32_id.get(), j);
            }
            else
            {
              paramToServiceMsg = new TroopAIOAppInfo();
              a(paramToServiceMsg, paramObject);
              paramToServiceMsg.groupType = j;
              if (i != 1) {
                break label798;
              }
              localArrayList2.add(Integer.valueOf(paramToServiceMsg.appid));
              if (paramFromServiceMsg.contains(Integer.valueOf(paramToServiceMsg.appid))) {
                break label798;
              }
              if (localTroopAppMgr.a(paramToServiceMsg))
              {
                localTroopAppMgr.b(paramToServiceMsg);
                paramFromServiceMsg.add(Integer.valueOf(paramToServiceMsg.appid));
                if (!QLog.isColorLevel()) {
                  break label798;
                }
                QLog.d(".troop.troop_app", 2, "troopAppInfo need detail:" + paramToServiceMsg.toString());
              }
            }
          }
        }
      }
      label782:
      label798:
      for (;;)
      {
        localArrayList1.add(paramToServiceMsg);
        break label360;
        paramObject = localTroopAppMgr.a(paramToServiceMsg.appid, j);
        AssertUtils.a(paramObject);
        paramToServiceMsg = paramObject;
        if (QLog.isColorLevel())
        {
          QLog.d(".troop.troop_app", 2, "troopAppInfo not need detail:" + paramObject.toString());
          paramToServiceMsg = paramObject;
          continue;
          if (i == 1) {
            localTroopAppMgr.a(localRspBody.all_app_wording.get());
          }
          localTroopAppMgr.a(j);
          if (i == 1)
          {
            if ((localTroopAppMgr.a(localArrayList2, j)) && (paramFromServiceMsg.isEmpty())) {
              a(72, true, new Object[] { null });
            }
            if (paramFromServiceMsg.isEmpty()) {
              break;
            }
            a(2, j, paramFromServiceMsg, false);
            return;
          }
          localTroopAppMgr.a(localArrayList1, j);
          a(72, true, new Object[] { null });
          return;
          a(72, false, new Object[] { null });
          return;
        }
      }
    }
  }
  
  protected void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
      a(73, false, null);
    }
    int i;
    label170:
    label216:
    do
    {
      cmd0xca04.RspBody localRspBody;
      do
      {
        for (;;)
        {
          return;
          paramFromServiceMsg = paramToServiceMsg.extraData.getIntegerArrayList("appidList2sort");
          localRspBody = new cmd0xca04.RspBody();
          try
          {
            localRspBody.mergeFrom((byte[])paramObject);
            i = localRspBody.uint32_res.get();
            if (QLog.isColorLevel()) {
              QLog.d("TroopHandler.troop.troop_app", 2, "onrecive, cmd_troop_sort_app_list, re:" + i);
            }
            if (i != 0) {
              break label216;
            }
            paramObject = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
            if (paramObject != null) {
              break label170;
            }
            a(73, false, null);
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler.troop.troop_app", 2, "troopAppMgr == null");
              return;
            }
          }
          catch (Exception paramToServiceMsg)
          {
            a(73, false, null);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopHandler.troop.troop_app", 2, "Exception, handleSortTroopAppList");
      return;
      paramObject.b(localRspBody.uint32_timestamp.get(), 0);
      paramObject.a(paramFromServiceMsg, 0);
      a(73, true, null);
      a(2, 0, paramToServiceMsg.extraData.getIntegerArrayList("appidToAdd"), false);
      return;
      a(73, false, null);
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_app", 2, "sort troop apps falied, rspBody.uint32_res:" + i);
  }
  
  protected void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getIntegerArrayList("appids");
    int i = paramToServiceMsg.extraData.getInt("groupType");
    if ((paramObject == null) || (!paramFromServiceMsg.isSuccess())) {
      a(74, false, new Object[] { localArrayList, null });
    }
    do
    {
      for (;;)
      {
        return;
        paramToServiceMsg = new cmd0xca05.RspBody();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          int j = paramToServiceMsg.uint32_res.get();
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler.troop.troop_app", 2, "handleClearTroopAppRedPoint, retCode:" + j);
          }
          if (j != 0) {
            break label260;
          }
          paramFromServiceMsg = paramToServiceMsg.rpt_result.get();
          paramObject = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
          if (paramObject != null)
          {
            paramObject.b(paramToServiceMsg.uint32_timestamp.get(), i);
            i = 0;
            while (i < localArrayList.size())
            {
              paramObject.b(((Integer)localArrayList.get(i)).intValue());
              i += 1;
            }
            a(74, true, new Object[] { localArrayList, paramFromServiceMsg });
            return;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          a(74, false, new Object[] { localArrayList, null });
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_app", 2, "Exception, handleClearTroopAppRedPoint");
    return;
    label260:
    a(74, false, null);
  }
  
  public void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = paramToServiceMsg.extraData.getString("troopUin");
    String str2 = paramToServiceMsg.extraData.getString("memberUin");
    int j = paramToServiceMsg.extraData.getInt("cmd");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.closeRcvMsgTmp", 2, "handle_oidb_0xa80_0:" + str1 + "," + str2 + "," + j + "," + paramFromServiceMsg.isSuccess());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      a(77, false, new Object[] { str1, str2, Integer.valueOf(j) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    int i;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      i = -1;
      if (paramToServiceMsg.uint32_result.has()) {
        i = paramToServiceMsg.uint32_result.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "sso result:" + i);
      }
      if (i != 0)
      {
        a(77, false, new Object[] { str1, str2, Integer.valueOf(j) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.closeRcvMsgTmp", 2, "handle_oidb_0xa80_0, pkg.mergeFrom:" + paramToServiceMsg.toString());
      }
      a(77, false, new Object[] { str1, str2, Integer.valueOf(j) });
      return;
    }
    paramFromServiceMsg = new oidb_cmd0xa80.RspBody();
    try
    {
      paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = (oidb_cmd0xa80.RspGroupInfo)paramFromServiceMsg.rpt_msg_rsp_group_info.get().get(0);
      i = paramToServiceMsg.uint32_result.get();
      long l = paramToServiceMsg.uint64_group_code.get();
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "ret=" + i + "," + l + "," + paramToServiceMsg);
      }
      if (i == 0)
      {
        a(77, true, new Object[] { str1, str2, Integer.valueOf(j) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.closeRcvMsgTmp", 2, "handle_oidb_0xa80_0:" + paramToServiceMsg.toString());
      }
      a(77, false, new Object[] { str1, str2, Integer.valueOf(j) });
    }
  }
  
  public void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6b6. subCmd=" + i);
    }
    switch (i)
    {
    }
  }
  
  public void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6c3. subCmd=" + i);
    }
    switch (i)
    {
    }
  }
  
  public void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6b5. subCmd=" + i);
    }
    switch (i)
    {
    }
  }
  
  public void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("subCmd", -1);
    if (QLog.isColorLevel()) {
      QLog.i(".troop.send_gift", 2, "handle_oidb_0x6c2. subCmd=" + i);
    }
    switch (i)
    {
    }
  }
  
  public void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramToServiceMsg.extraData.getString("troopUin");
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("isJoin");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleJoinOrExitOpenTroop:").append((String)localObject).append(",");
      if (!bool1) {
        break label135;
      }
    }
    label135:
    for (paramToServiceMsg = "join";; paramToServiceMsg = "exit")
    {
      QLog.d(".troop.inOrOutOpenTroop", 2, paramToServiceMsg + "," + paramFromServiceMsg.isSuccess());
      if (paramFromServiceMsg.isSuccess()) {
        break;
      }
      a(83, false, new Object[] { localObject, Integer.valueOf(2131429689), Boolean.valueOf(bool1) });
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    int i;
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      i = -1;
      if (paramToServiceMsg.uint32_result.has()) {
        i = paramToServiceMsg.uint32_result.get();
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.inOrOutOpenTroop", 2, "sso result:" + i);
      }
      if (i == 0) {
        break label387;
      }
      switch (i)
      {
      default: 
        a(83, false, new Object[] { localObject, Integer.valueOf(2131429689), Boolean.valueOf(bool1) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.e(".troop.inOrOutOpenTroop", 2, "pkg.mergeFrom:" + paramToServiceMsg.toString());
      }
      a(83, false, new Object[] { localObject, Integer.valueOf(2131429689), Boolean.valueOf(bool1) });
      return;
    }
    a(83, false, new Object[] { localObject, Integer.valueOf(2131429688), Boolean.valueOf(bool1) });
    return;
    label387:
    paramObject = new oidb_0xa8d.RspBody();
    paramFromServiceMsg = (FromServiceMsg)localObject;
    try
    {
      paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramToServiceMsg = (ToServiceMsg)localObject;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      if (paramObject.uint64_group_code.has())
      {
        paramFromServiceMsg = (FromServiceMsg)localObject;
        paramToServiceMsg = String.valueOf(paramObject.uint64_group_code.get());
      }
      paramFromServiceMsg = paramToServiceMsg;
      if (!paramObject.uint32_req_type.has()) {
        break label1073;
      }
      paramFromServiceMsg = paramToServiceMsg;
      i = paramObject.uint32_req_type.get();
      paramFromServiceMsg = paramToServiceMsg;
      j = jdField_d_of_type_Int;
      if (i != j) {
        break label1023;
      }
      bool1 = true;
    }
    catch (Exception paramToServiceMsg)
    {
      label483:
      for (;;)
      {
        int j;
      }
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_0xa8d.Cmd0xa8dJoinPublicGroupRspBody)paramObject.msg_join_group.get();
        paramObject = new TroopInfo();
        i = 0;
        j = 0;
        boolean bool2 = false;
        localObject = new StringBuilder();
        if (paramFromServiceMsg.uint32_GroupFlagEx.has())
        {
          paramObject.dwGroupFlagExt = paramFromServiceMsg.uint32_GroupFlagEx.get();
          bool2 = TroopInfo.isVisitorSpeakEnabled(paramFromServiceMsg.uint32_GroupFlagEx.get());
          ((StringBuilder)localObject).append(" dwGroupFlagExt: ").append(paramObject.dwGroupFlagExt);
          ((StringBuilder)localObject).append(" visitorSpeakEnabled: ").append(bool2);
        }
        if (paramFromServiceMsg.uint32_SpeakInterval.has())
        {
          i = paramFromServiceMsg.uint32_SpeakInterval.get();
          ((StringBuilder)localObject).append(" speakInterval: ").append(i);
        }
        if (paramFromServiceMsg.uint32_StartSpeakInterval.has())
        {
          j = paramFromServiceMsg.uint32_StartSpeakInterval.get();
          ((StringBuilder)localObject).append(" startSpeakInterval: ").append(j);
        }
        if (paramFromServiceMsg.uint32_GroupClassEx.has())
        {
          paramObject.dwGroupClassExt = paramFromServiceMsg.uint32_GroupClassEx.get();
          ((StringBuilder)localObject).append(" dwGroupClassExt: ").append(paramObject.dwGroupClassExt);
        }
        if (paramFromServiceMsg.uint32_GroupClass.has())
        {
          paramObject.trooptype = paramFromServiceMsg.uint32_GroupClass.get();
          ((StringBuilder)localObject).append(" trooptype: ").append(paramObject.trooptype);
        }
        if (paramFromServiceMsg.uint32_MaxMember.has())
        {
          paramObject.wMemberMax = paramFromServiceMsg.uint32_MaxMember.get();
          ((StringBuilder)localObject).append(" wMemberMax: ").append(paramObject.wMemberMax);
        }
        if (paramFromServiceMsg.uint32_SpecialClass.has())
        {
          paramObject.wSpecialClass = paramFromServiceMsg.uint32_SpecialClass.get();
          ((StringBuilder)localObject).append(" wSpecialClass: ").append(paramObject.wSpecialClass);
        }
        if (paramFromServiceMsg.bytes_GroupName.has())
        {
          paramObject.troopname = paramFromServiceMsg.bytes_GroupName.get().toStringUtf8();
          ((StringBuilder)localObject).append(" troopname: ").append(paramObject.troopname);
        }
        if (QLog.isColorLevel()) {
          QLog.d(".troop.inOrOutOpenTroop", 2, ((StringBuilder)localObject).toString());
        }
        a(83, true, new Object[] { paramToServiceMsg, Integer.valueOf(2131429686), Boolean.valueOf(bool1), Boolean.valueOf(bool2), Integer.valueOf(i), Integer.valueOf(j) });
        paramObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        if (paramObject == null) {
          break;
        }
        if (!bool1) {
          break label1064;
        }
        paramFromServiceMsg = paramToServiceMsg;
        paramObject.e(paramFromServiceMsg);
        return;
      }
      catch (Exception paramObject)
      {
        paramFromServiceMsg = paramToServiceMsg;
        paramToServiceMsg = paramObject;
      }
      if (QLog.isColorLevel()) {
        QLog.d(".troop.inOrOutOpenTroop", 2, "handleJoinOrExitOpenTroop:" + paramToServiceMsg.toString());
      }
      a(83, false, new Object[] { paramFromServiceMsg, Integer.valueOf(2131429689), Boolean.valueOf(bool1) });
      return;
      label1023:
      bool1 = false;
      break label483;
      a(83, true, new Object[] { paramToServiceMsg, Integer.valueOf(2131429687), Boolean.valueOf(bool1) });
      continue;
      label1064:
      paramFromServiceMsg = null;
    }
  }
  
  public void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() == 0) {
          bool = true;
        }
        long l;
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.size() > 0))
          {
            paramToServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0);
            l = paramToServiceMsg.uint64_uin.get();
            if (!paramToServiceMsg.uint32_global_group_level.has()) {
              break label203;
            }
          }
        }
        label203:
        for (i = paramToServiceMsg.uint32_global_group_level.get();; i = -1)
        {
          a(87, bool, new Object[] { Long.valueOf(l), Integer.valueOf(i) });
          return;
          i = 0;
          break;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
  }
  
  public void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool1;
    int j;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          try
          {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg);
            if (!paramFromServiceMsg.rpt_msg_uin_data.has()) {
              break label325;
            }
            paramToServiceMsg = paramFromServiceMsg.rpt_msg_uin_data.get().iterator();
            i = 1;
            bool1 = false;
            j = i;
            bool2 = bool1;
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            i = 1;
          }
          try
          {
            if (!paramToServiceMsg.hasNext()) {
              break label282;
            }
            paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramToServiceMsg.next();
            if (!paramFromServiceMsg.uint32_req_invite2group_auto_agree_flag.has()) {
              break label322;
            }
            j = paramFromServiceMsg.uint32_req_invite2group_auto_agree_flag.get();
            i = j;
            bool1 = true;
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            break;
            continue;
          }
          paramFromServiceMsg = paramFromServiceMsg;
          paramFromServiceMsg.printStackTrace();
        }
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()))
      {
        int k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("TroopHandler", 2, "handleAutoAgreeInvite2GroupIn50Flag ret=" + k);
        }
        if ((k == 0) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.i("TroopHandler", 2, "handleAutoAgreeInvite2GroupIn50Flag ret=" + k);
          }
          bool2 = false;
          j = i;
        }
      }
    }
    for (;;)
    {
      label282:
      if (j == 0) {}
      for (bool1 = bool3;; bool1 = false)
      {
        a(89, bool2, new Object[] { Boolean.valueOf(bool1) });
        return;
      }
      label322:
      label325:
      j = 1;
      bool2 = false;
    }
  }
  
  public void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramObject = new oidb_sso.OIDBSSOPkg();
    }
    int i;
    byte[] arrayOfByte;
    label176:
    int m;
    HashMap localHashMap;
    int j;
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("TroopHandler", 2, "handleGetTroopMemberRemark ret=" + i);
        }
        if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          arrayOfByte = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          i = arrayOfByte[0];
          if (i == 0) {
            break label176;
          }
          QLog.e("TroopHandler", 1, "handleGetTroopMemberRemark error! cResult=" + i);
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = paramObject;
      }
      m = arrayOfByte[1];
      localHashMap = new HashMap();
      j = 0;
      i = 2;
    }
    long l;
    int k;
    label237:
    int i2;
    if (j < m)
    {
      l = PkgTools.a(arrayOfByte, i);
      i += 4;
      int n = arrayOfByte[i];
      paramFromServiceMsg = null;
      i += 1;
      k = 0;
      if (k < n)
      {
        int i1 = arrayOfByte[i];
        i2 = i + 1;
        i = arrayOfByte[i2];
        i2 += 1;
        paramObject = PkgTools.a(arrayOfByte, i2, i);
        if (!TextUtils.isEmpty(paramFromServiceMsg)) {
          break label580;
        }
        paramFromServiceMsg = paramObject;
        if (QLog.isColorLevel())
        {
          QLog.i("TroopHandler", 2, "handleGetTroopMemberRemark uin=" + l + " cTag=" + i1 + " sRemark=" + paramObject);
          paramFromServiceMsg = paramObject;
        }
      }
    }
    label580:
    for (;;)
    {
      k += 1;
      i += i2;
      break label237;
      if (!TextUtils.isEmpty(paramFromServiceMsg)) {
        localHashMap.put(String.valueOf(l), paramFromServiceMsg);
      }
      j += 1;
      break;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("troopUin");
      i = paramToServiceMsg.extraData.getInt("offset");
      paramObject = paramToServiceMsg.extraData.getStringArrayList("memberUins");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr == null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr = new TroopBatchAddFriendMgr(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr.b(paramFromServiceMsg, localHashMap);
      if (i < paramObject.size())
      {
        a(paramFromServiceMsg, paramObject, i);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "handleGetTroopMemberRemark ... ok, that's all.");
      }
      l = paramToServiceMsg.extraData.getLong("curTs");
      paramToServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      paramObject = String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { "sp_baf_data_check_flag_remark", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFromServiceMsg });
      paramToServiceMsg.edit().putLong(paramObject, l).apply();
      a(109, true, new Object[] { paramFromServiceMsg });
      return;
    }
  }
  
  public void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramObject = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("TroopHandler", 2, "handleOidb0x4ff_86Rsp ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.a(paramFromServiceMsg, 0));
              if ((TextUtils.isEmpty(paramFromServiceMsg)) || (!paramFromServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("Q.dating", 2, "handleOidb0x4ff_86Rsp uin error");
                }
                bool = false;
                a(88, bool, new Object[] { Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("switch", false)) });
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = paramObject;
        continue;
        bool = true;
        continue;
      }
      boolean bool = false;
    }
  }
  
  public void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0x928.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    long l = paramToServiceMsg.extraData.getLong("troopUin");
    if (QLog.isColorLevel()) {
      QLog.d(".troop.notify_feeds.data", 2, "<---- handleGetTroopAioNotifyFeeds, troopUin=" + l + ", ret=" + i);
    }
    if (i == 0) {}
    for (;;)
    {
      try
      {
        paramObject = ((oidb_0x928.RspBody)localObject).notice_info_list.get();
        paramToServiceMsg = TroopAioNotifyManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l + "");
        paramFromServiceMsg = new ArrayList();
        int j = paramObject.size();
        i = 0;
        if (i < j)
        {
          localObject = (oidb_0x928.NoticeInfo)paramObject.get(i);
          TroopAIONotifyItem localTroopAIONotifyItem = new TroopAIONotifyItem();
          localTroopAIONotifyItem.id = ((oidb_0x928.NoticeInfo)localObject).id.get();
          localTroopAIONotifyItem.title = ((oidb_0x928.NoticeInfo)localObject).title.get();
          localTroopAIONotifyItem.summary = ((oidb_0x928.NoticeInfo)localObject).summary.get();
          localTroopAIONotifyItem.url = ((oidb_0x928.NoticeInfo)localObject).url.get();
          localTroopAIONotifyItem.icon = ((oidb_0x928.NoticeInfo)localObject).icon.get();
          localTroopAIONotifyItem.type = ((oidb_0x928.NoticeInfo)localObject).type.get();
          localTroopAIONotifyItem.expireTime = ((oidb_0x928.NoticeInfo)localObject).show_expire.get();
          localTroopAIONotifyItem.hideMode = ((oidb_0x928.NoticeInfo)localObject).hide_mode.get();
          localTroopAIONotifyItem.troopUin = String.valueOf(l);
          localTroopAIONotifyItem.appId = ((oidb_0x928.NoticeInfo)localObject).app_id.get();
          if (paramFromServiceMsg.contains(localTroopAIONotifyItem)) {
            break label528;
          }
          paramFromServiceMsg.add(localTroopAIONotifyItem);
          break label528;
        }
        paramObject = TroopAioNotifyManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.notify_feeds.data", 2, "handleGetTroopAioNotifyFeeds, serverList=" + paramFromServiceMsg.size() + ", localList=" + paramToServiceMsg.size() + ", resultList=" + paramObject.size() + " ---->");
        }
        a(94, true, new Object[] { String.valueOf(l), paramObject });
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        a(94, false, new Object[] { String.valueOf(l), new ArrayList() });
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.notify_feeds.data", 2, "handleGetTroopAioNotifyFeeds exp:, " + paramToServiceMsg.toString() + " ---->");
        return;
      }
      a(94, false, new Object[] { String.valueOf(l), new ArrayList() });
      return;
      label528:
      i += 1;
    }
  }
  
  public void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    long l = paramToServiceMsg.extraData.getLong("timeSeq");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("troop_uin");
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "handleGetTroopHideWebConfig: isSuccess = " + bool + " code:" + paramFromServiceMsg.getResultCode() + " sendTimeKey:" + l + " troopUin:" + paramToServiceMsg);
    }
    if (bool)
    {
      Object localObject = new cmd0x3fb.GrayMsg();
      for (;;)
      {
        try
        {
          ((cmd0x3fb.GrayMsg)localObject).mergeFrom((byte[])paramObject);
          paramObject = (cmd0x3fb.RspBody)((cmd0x3fb.GrayMsg)localObject).msg_gray_rsp.get();
          Monitor.a("2729126");
          if ((paramObject.int32_ret.has()) && (paramObject.int32_ret.get() == 0))
          {
            i = paramObject.int32_color.get();
            localObject = paramObject.str_url.get();
            int j = paramObject.int32_gray_flag.get();
            int k = paramObject.int32_enter_glive_strategy.get();
            String str1 = paramObject.str_update_title.get();
            String str2 = paramObject.str_update_content.get();
            int m = paramObject.int32_pre_download_toggle.get();
            a(95, true, new Object[] { paramToServiceMsg, Integer.valueOf(i), localObject, Integer.valueOf(j), Integer.valueOf(k), str1, str2, Integer.valueOf(m), Integer.valueOf(paramFromServiceMsg.getResultCode()), Long.valueOf(l) });
            if (QLog.isColorLevel()) {
              QLog.d(".troop.notify_feeds.data", 2, "<---- handleGetTroopHideWebConfig,troopUin=" + paramToServiceMsg + " ,color=" + i + ", url=" + (String)localObject + " flag:" + j + " ,strategy:" + k + " title:" + str1 + " content:" + str2 + " preDownloadToggle:" + m);
            }
            Monitor.a("2729127");
            ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 1, 0, "", "7.6.0", "", "");
            return;
          }
          a(95, false, new Object[] { paramToServiceMsg, Integer.valueOf(0), "", Integer.valueOf(-1), Integer.valueOf(-1), "", "", Integer.valueOf(-1), Integer.valueOf(-1), Long.valueOf(l) });
          paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
          if (paramObject.int32_ret.has())
          {
            i = paramObject.int32_ret.get();
            ReportController.b(paramFromServiceMsg, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 0, i, "", "7.6.0", "", "");
            return;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          a(95, false, new Object[] { paramToServiceMsg, Integer.valueOf(0), "", Integer.valueOf(-1), Integer.valueOf(-1), "", "", Integer.valueOf(-1), Integer.valueOf(-1), Long.valueOf(l) });
          if (QLog.isColorLevel()) {
            QLog.e(".troop.notify_feeds.data", 2, "GetTroopHideWebConfig exp:, " + paramFromServiceMsg.toString() + " ---->");
          }
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Huayang_video", "", "group_video", "GetTroopHideWebConfig", 0, 0, paramFromServiceMsg.toString(), "7.6.0", "", "");
          return;
        }
        int i = -1;
      }
    }
    a(95, false, new Object[] { paramToServiceMsg, Integer.valueOf(0), "", Integer.valueOf(-1), Integer.valueOf(-1), "", "", Integer.valueOf(-1), Integer.valueOf(paramFromServiceMsg.getResultCode()), Long.valueOf(l) });
  }
  
  public void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleRequestGroupVideoStateList: isSuccess = " + bool);
      }
      if (bool)
      {
        paramToServiceMsg = new cmd0x2323.RspBody();
        try
        {
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg.ret.has()) && (paramToServiceMsg.ret.get() == 0))
          {
            paramFromServiceMsg = paramToServiceMsg.body_msg.get();
            paramToServiceMsg = new ArrayList();
            paramFromServiceMsg = paramFromServiceMsg.iterator();
          }
          while (paramFromServiceMsg.hasNext())
          {
            paramObject = (cmd0x2323.BodyMsg)paramFromServiceMsg.next();
            VideoStateInfo localVideoStateInfo = new VideoStateInfo();
            localVideoStateInfo.jdField_a_of_type_Long = paramObject.group_code.get();
            localVideoStateInfo.jdField_b_of_type_Int = paramObject.action.get();
            localVideoStateInfo.jdField_a_of_type_Int = paramObject.user_num.get();
            localVideoStateInfo.jdField_a_of_type_JavaUtilList = paramObject.video_user_list.get();
            paramToServiceMsg.add(localVideoStateInfo);
            continue;
            this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoStateGetListener = null;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, "handleRequestGroupVideoStateList: InvalidProtocolBufferMicroException  = " + paramToServiceMsg.toString());
          }
        }
      }
    }
    for (;;)
    {
      return;
      bool = false;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleRequestGroupVideoStateList: msgInfos size " + paramToServiceMsg.size());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoStateGetListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoStateGetListener.a(paramToServiceMsg);
      }
    }
  }
  
  public void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xae6.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    int j = paramToServiceMsg.extraData.getInt("type");
    int k = paramToServiceMsg.extraData.getInt("istroop");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("groupuin");
    paramObject = paramToServiceMsg.extraData.getString("senderUin");
    long l = paramToServiceMsg.extraData.getLong("shmsgseq");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("uuid");
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "handPicLightReply operate = " + j + ", retCode=" + i);
    }
    if (i == 0)
    {
      int m = ((oidb_0xae6.RspBody)localObject).comment_num.get();
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "handPicLightReply operate = " + j + ", istroop = " + k + ", groupUin = " + paramFromServiceMsg + ", senderuin = " + paramObject + ", shmsgseq = " + l + ", uuid = " + paramToServiceMsg + ", retCode = " + i + ", num = " + m);
      }
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        localObject = new Intent("light_reply_count_changed");
        ((Intent)localObject).putExtra("type", j);
        ((Intent)localObject).putExtra("istroop", k);
        ((Intent)localObject).putExtra("groupuin", paramFromServiceMsg);
        ((Intent)localObject).putExtra("senderUin", paramObject);
        ((Intent)localObject).putExtra("shmsgseq", l);
        ((Intent)localObject).putExtra("uuid", paramToServiceMsg);
        ((Intent)localObject).putExtra("replyCount", m);
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
      }
      return;
    }
    QLog.e("TroopHandler", 2, "handPicLightReply error operate = " + j + ", istroop = " + k + ", groupUin = " + paramFromServiceMsg + ", senderuin = " + paramObject + ", shmsgseq = " + l + ", uuid = " + paramToServiceMsg + ", retCode = " + i);
  }
  
  public void S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new cmd0xaf6.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    if (i == 0)
    {
      paramToServiceMsg = new StringBuffer("groupUins:");
      if (((cmd0xaf6.RspBody)localObject1).group_member.has())
      {
        paramFromServiceMsg = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        paramObject = ((cmd0xaf6.RspBody)localObject1).group_member.get().iterator();
        while (paramObject.hasNext())
        {
          Object localObject2 = (cmd0xaf6.GroupMember)paramObject.next();
          localObject1 = paramFromServiceMsg.b(String.valueOf(((cmd0xaf6.GroupMember)localObject2).group_id.get()));
          ArrayList localArrayList = new ArrayList();
          localObject2 = ((cmd0xaf6.GroupMember)localObject2).uins.get().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            long l = ((Long)((Iterator)localObject2).next()).longValue();
            localArrayList.add(String.valueOf(l));
            paramToServiceMsg.append(l).append("|");
          }
          if (localObject1 != null)
          {
            ((TroopInfo)localObject1).updateHeadMemberList(localArrayList);
            this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.c(((TroopInfo)localObject1).troopuin);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "handleGetTroopMemberListForHeadBatch:" + paramToServiceMsg.toString());
      }
      return;
    }
    QLog.e("TroopHandler", 1, "getTroopMemberListBatch failed! retCode = " + i);
  }
  
  public void T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      Object localObject = new oidb_0xb14.RspBody();
      int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
      if (i == 0)
      {
        paramToServiceMsg = String.valueOf(((oidb_0xb14.RspBody)localObject).group_id.get());
        localObject = ((oidb_0xb14.RspBody)localObject).infos.get();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          paramFromServiceMsg = String.valueOf(((oidb_0xb14.UserInfo)((List)localObject).get(0)).uin.get());
          i = ((oidb_0xb14.UserInfo)((List)localObject).get(0)).id.get();
          paramObject = ((oidb_0xb14.UserInfo)((List)localObject).get(0)).course.get();
          localObject = ((oidb_0xb14.UserInfo)((List)localObject).get(0)).name.get();
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, new Object[] { "handleGetHomeworkTroopIdentity. troopUin=", paramToServiceMsg, ", memberUin=", paramFromServiceMsg, ", identity=", Integer.valueOf(i), ", course=", paramObject, ", name=", localObject });
          }
          ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramToServiceMsg, paramFromServiceMsg, null, i, paramObject, (String)localObject);
          a(107, true, new Object[] { paramToServiceMsg, paramFromServiceMsg, Integer.valueOf(i), paramObject, localObject });
        }
      }
      else
      {
        QLog.e("TroopHandler", 1, new Object[] { "handleGetHomeworkTroopIdentity failed! retCode = ", Integer.valueOf(i) });
        a(107, false, new Object[] { "", "", Integer.valueOf(0), "", "" });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TroopHandler", 1, "handleGetHomeworkTroopIdentity exception. e=", paramToServiceMsg);
      a(107, false, new Object[] { "", "", Integer.valueOf(0), "", "" });
    }
  }
  
  public long a(int paramInt, long paramLong)
  {
    cmd0x3fb.GrayMsg localGrayMsg = new cmd0x3fb.GrayMsg();
    localGrayMsg.uint32_subcmd.set(1);
    Object localObject = new cmd0x3fb.ReqBody();
    ((cmd0x3fb.ReqBody)localObject).uint32_identity.set(paramInt);
    ((cmd0x3fb.ReqBody)localObject).uint32_client_id.set(2);
    ((cmd0x3fb.ReqBody)localObject).str_version.set("7.6.0");
    ((cmd0x3fb.ReqBody)localObject).uint64_to_guin.set(paramLong);
    localGrayMsg.msg_gray_req.set((MessageMicro)localObject);
    localObject = a("qunVideoGray.0x3fb_0");
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramLong + "");
    ((ToServiceMsg)localObject).extraData.putLong("timeSeq", SystemClock.elapsedRealtime());
    ((ToServiceMsg)localObject).putWupBuffer(localGrayMsg.toByteArray());
    b((ToServiceMsg)localObject);
    long l = ((ToServiceMsg)localObject).extraData.getLong("timeSeq");
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, " requestVideoGrayWebConfig, identity:" + paramInt + " client_id: 2 str_version:" + "7.6.0" + " to_guin:" + paramLong + " timeKey:" + l);
    }
    return l;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) || (paramBoolean))
    {
      try
      {
        return ImageUtil.f();
      }
      catch (Throwable paramString)
      {
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          break label83;
        }
        QLog.e("TroopHandler", 2, "getDiscussionFaceIcon error", paramString);
        return null;
        paramString = null;
      }
      localBitmap = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(113, paramString, (byte)1, false, (byte)1, 0);
      if (localBitmap == null)
      {
        g(paramString, true);
        if (paramBoolean) {
          return ImageUtil.f();
        }
      }
      else
      {
        g(paramString, false);
        return localBitmap;
      }
    }
    label83:
    return null;
    return paramString;
  }
  
  protected Class a()
  {
    return TroopObserver.class;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr = null;
    }
    super.a();
  }
  
  public void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInt));
    StatisticCollector.a(BaseApplication.getContext()).a(null, jdField_a_of_type_JavaLangString, false, 0L, 0L, localHashMap, "");
  }
  
  public void a(int paramInt1, int paramInt2, List paramList, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, new Object[] { "getTroopAppList: start", "readType: ", Integer.valueOf(paramInt1), " ,groupType: ", Integer.valueOf(paramInt2) });
    }
    cmd0xca02.ReqBody localReqBody = new cmd0xca02.ReqBody();
    localReqBody.uint32_type.set(paramInt1);
    Object localObject = new cmd0xca02.AppInfo();
    ((cmd0xca02.AppInfo)localObject).plat_type.set(2);
    ((cmd0xca02.AppInfo)localObject).str_app_version.set("7.6.0");
    localReqBody.msg_app_info.set((MessageMicro)localObject);
    if (paramInt2 != 0) {
      localReqBody.uint32_group_type.set(paramInt2);
    }
    if (paramInt1 == 2)
    {
      if ((paramList == null) || (paramList.isEmpty()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler.troop.troop_app", 2, "invaliedAppids.isEmpty");
        }
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (Integer)paramList.next();
        localReqBody.rpt_app_ids.add(localObject);
      }
    }
    paramList = a("GroupOpen.ReadAppList");
    paramList.putWupBuffer(localReqBody.toByteArray());
    paramList.extraData.putInt("readType", paramInt1);
    paramList.extraData.putBoolean("appListChangedFromWebOperate", paramBoolean);
    paramList.extraData.putInt("groupType", paramInt2);
    b(paramList);
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x899_0").append("|troopuin = ").append(paramLong1).append("|flag = ").append(paramInt2).append("|nStartUin = ").append(paramLong2).append("|memberNum = ").append(paramInt3).append("|filterMethod = ").append(paramInt4);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x899.memberlist();
    ((oidb_0x899.memberlist)localObject2).uint64_member_uin.set(0L);
    Object localObject1 = new oidb_0x899.ReqBody();
    ((oidb_0x899.ReqBody)localObject1).uint64_group_code.set(paramLong1);
    ((oidb_0x899.ReqBody)localObject1).uint64_start_uin.set(paramLong2);
    if (paramInt2 == 4)
    {
      ((oidb_0x899.memberlist)localObject2).uint32_uin_flag.set(0);
      ((oidb_0x899.ReqBody)localObject1).uint32_identify_flag.set(paramInt2);
      ((oidb_0x899.ReqBody)localObject1).memberlist_opt.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2201);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject1).toByteArray()));
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(paramInt1);
      localObject1 = "OidbSvc.0x899_0";
      if (paramInt1 != 0) {
        break label372;
      }
      localObject1 = "OidbSvc.0x899_0";
    }
    for (;;)
    {
      localObject1 = a((String)localObject1);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", paramLong1);
      ((ToServiceMsg)localObject1).extraData.putInt("nFlag", paramInt2);
      ((ToServiceMsg)localObject1).extraData.putLong("nStartUin", paramLong2);
      ((ToServiceMsg)localObject1).extraData.putInt("serviceType", paramInt1);
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
      if (paramInt2 == 5)
      {
        ((oidb_0x899.ReqBody)localObject1).uint32_member_num.set(paramInt3);
        ((oidb_0x899.ReqBody)localObject1).uint32_filter_method.set(paramInt4);
        break;
      }
      if (paramInt2 != 2) {
        break;
      }
      ((oidb_0x899.memberlist)localObject2).uint32_privilege.set(1);
      break;
      label372:
      if (paramInt1 == 1) {
        localObject1 = "OidbSvc.0x899_9";
      }
    }
  }
  
  protected void a(int paramInt, MessageForReplyText paramMessageForReplyText)
  {
    MessageRecord localMessageRecord = ReplyTextItemBuilder.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForReplyText.frienduin, paramMessageForReplyText.istroop, paramMessageForReplyText.mSourceMsgInfo.mSourceMsgSeq);
    if (localMessageRecord == null)
    {
      ThreadManager.post(new zlb(this, paramMessageForReplyText, paramInt), 8, null, true);
      return;
    }
    a(paramInt, paramMessageForReplyText, localMessageRecord);
  }
  
  public void a(int paramInt, MessageForReplyText paramMessageForReplyText, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForPic))
    {
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      paramMessageRecord = new MsgInfo(paramMessageRecord.senderuin, paramMessageRecord.shmsgseq, paramMessageRecord.uuid, null);
    }
    for (;;)
    {
      Object localObject1;
      if (paramMessageRecord != null)
      {
        localObject1 = new MsgInfo(paramMessageForReplyText.senderuin, paramMessageForReplyText.shmsgseq, null, paramMessageForReplyText.msg);
        Object localObject2 = a(paramInt, paramMessageForReplyText.istroop, paramMessageForReplyText.frienduin, paramMessageRecord, (MsgInfo)localObject1);
        if (localObject2 == null) {
          break label376;
        }
        localObject2 = a("OidbSvc.0xae6", 2790, 0, ((oidb_0xae6.ReqBody)localObject2).toByteArray());
        ((ToServiceMsg)localObject2).extraData.putInt("type", paramInt);
        ((ToServiceMsg)localObject2).extraData.putInt("istroop", paramMessageForReplyText.istroop);
        ((ToServiceMsg)localObject2).extraData.putString("groupuin", paramMessageForReplyText.frienduin);
        ((ToServiceMsg)localObject2).extraData.putString("senderUin", String.valueOf(paramMessageRecord.jdField_a_of_type_Long));
        ((ToServiceMsg)localObject2).extraData.putLong("shmsgseq", paramMessageRecord.jdField_a_of_type_Int);
        ((ToServiceMsg)localObject2).extraData.putString("uuid", paramMessageRecord.jdField_a_of_type_JavaLangString);
        b((ToServiceMsg)localObject2);
        if (QLog.isColorLevel()) {
          QLog.i("TroopHandler", 1, "req0xae6 ok. operate = " + paramInt + ", istroop = " + paramMessageForReplyText.istroop + ", troopUin = " + paramMessageForReplyText.frienduin + ", sourceMsg = " + paramMessageRecord + ", commentMsg = " + localObject1);
        }
      }
      label376:
      while (!QLog.isColorLevel())
      {
        return;
        if ((paramMessageRecord instanceof MessageForMixedMsg))
        {
          localObject1 = new MessageForReplyText.LightReplyMsgRich2(paramMessageForReplyText.mSourceMsgInfo.mRichMsg2);
          paramMessageRecord = ReplyTextItemBuilder.a((MessageForMixedMsg)paramMessageRecord, ((MessageForReplyText.LightReplyMsgRich2)localObject1).subMsgId);
          if (paramMessageRecord == null) {
            break label461;
          }
          paramMessageRecord = new MsgInfo(paramMessageRecord.senderuin, paramMessageRecord.shmsgseq, paramMessageRecord.uuid, null);
          break;
        }
        if (!(paramMessageRecord instanceof MessageForTroopFile)) {
          break label456;
        }
        paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
        paramMessageRecord = new MsgInfo(paramMessageRecord.senderuin, paramMessageRecord.shmsgseq, paramMessageRecord.uuid, null);
        break;
      }
      QLog.i("TroopHandler", 1, "req0xae6 error. operate = " + paramInt + ", istroop = " + paramMessageForReplyText.istroop + ", troopUin = " + paramMessageForReplyText.frienduin + ", sourceMsg = " + paramMessageRecord + ", commentMsg = " + localObject1);
      return;
      label456:
      paramMessageRecord = null;
      continue;
      label461:
      paramMessageRecord = null;
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject = new cmd0x3bb.ReqBody();
    try
    {
      ((cmd0x3bb.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x3bb.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      cmd0x3bb.AnonyMsg localAnonyMsg = new cmd0x3bb.AnonyMsg();
      localAnonyMsg.uint32_cmd.set(paramInt);
      localAnonyMsg.msg_anony_req.set((MessageMicro)localObject);
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_anonymous_generate_nick.group");
      ((ToServiceMsg)localObject).putWupBuffer(localAnonyMsg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString2);
      b((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "TroopHandler.getAnonymousChatNick, memberUin: " + paramString1 + " troopUin: " + paramString2);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", troopUin : " + paramString2);
    }
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if ((paramInt1 == 0) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1809);
    localOIDBSSOPkg.uint32_service_type.set(127);
    Object localObject = ByteBuffer.allocate(paramString1.getBytes().length + 6);
    ((ByteBuffer)localObject).putInt(paramInt1);
    ((ByteBuffer)localObject).putShort((short)paramString1.getBytes().length);
    ((ByteBuffer)localObject).put(paramString1.getBytes());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x711_127");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    ((ToServiceMsg)localObject).extraData.putString("openId", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("token", paramString2);
    ((ToServiceMsg)localObject).extraData.putInt("appid", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("seq", paramInt2);
    b((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
  {
    jstoken.ReqBody localReqBody = new jstoken.ReqBody();
    localReqBody.uint32_appid.set(paramInt1);
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.bytes_group_openid.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.bytes_jstoken.set(ByteStringMicro.copyFromUtf8(paramString2));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.bytes_url.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    ToServiceMsg localToServiceMsg = a("GroupOpen.CheckJsApiToken");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.extraData.putInt("appid", paramInt1);
    localToServiceMsg.extraData.putString("url", paramString3);
    localToServiceMsg.extraData.putString("openGroupId", paramString1);
    localToServiceMsg.extraData.putString("token", paramString2);
    localToServiceMsg.extraData.putInt("seq", paramInt2);
    b(localToServiceMsg);
  }
  
  public void a(int paramInt, ArrayList paramArrayList)
  {
    a(paramInt, paramArrayList, null);
  }
  
  public void a(int paramInt, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, "modifyTroopAppList, start==>appListTimestamp:" + paramInt);
    }
    if ((paramArrayList1 == null) || (paramArrayList1.isEmpty())) {
      return;
    }
    cmd0xca04.ReqBody localReqBody = new cmd0xca04.ReqBody();
    localReqBody.uint32_timestamp.set(paramInt);
    Object localObject = new cmd0xca04.AppInfo();
    ((cmd0xca04.AppInfo)localObject).plat_type.set(2);
    ((cmd0xca04.AppInfo)localObject).str_app_version.set("7.6.0");
    localReqBody.msg_app_info.set((MessageMicro)localObject);
    localObject = paramArrayList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if (localInteger.intValue() > 0) {
        localReqBody.rpt_uint32_appids.add(localInteger);
      }
    }
    localObject = a("GroupOpen.SortAppList");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("appidList2sort", paramArrayList1);
    if ((paramArrayList2 != null) && (!paramArrayList2.isEmpty())) {
      ((ToServiceMsg)localObject).extraData.putIntegerArrayList("appidToAdd", paramArrayList2);
    }
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getHomeworkInfo homeworkID = " + paramLong);
    }
    hw_get_homework_info.ReqGetHomeworkInfo localReqGetHomeworkInfo = new hw_get_homework_info.ReqGetHomeworkInfo();
    localReqGetHomeworkInfo.hw_id.set(paramLong);
    ToServiceMsg localToServiceMsg = a("HwSvc.get_homework_info");
    localToServiceMsg.putWupBuffer(localReqGetHomeworkInfo.toByteArray());
    b(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x88d_1").append("|troopuin = ").append(paramLong).append("|flag = ").append(paramInt);
      QLog.i("Q.troopquestionverify.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    if ((paramInt & 0x80) == 128) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_option.set(0);
    }
    if ((paramInt & 0x800000) == 8388608) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_question.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt & 0x800) == 2048) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_answer.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt & 0x1) == 1) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    }
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flagext3.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(paramLong);
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong);
    ((ToServiceMsg)localObject2).extraData.putInt("nFlag", paramInt);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    a(paramLong, paramInt1, paramInt2, -1, "");
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x88d_0").append("|troopuin = ").append(paramLong).append("|flag = ").append(paramInt1);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x88d.GroupInfo();
    if ((paramInt1 & 0x2) == 2) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_create_time.set(0);
    }
    if ((paramInt1 & 0x4) == 4) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_question.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt1 & 0x8) == 8) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext.set(0);
    }
    if ((paramInt1 & 0x10) == 16) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag.set(0);
    }
    if ((paramInt1 & 0x20) == 32) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_member_num.set(0);
    }
    if ((paramInt1 & 0x800) == 2048) {
      ((oidb_0x88d.GroupInfo)localObject2).string_group_answer.set(ByteStringMicro.EMPTY);
    }
    if ((paramInt1 & 0x40) == 64) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    }
    if ((paramInt1 & 0x80) == 128) {
      ((oidb_0x88d.GroupInfo)localObject2).uint32_group_option.set(0);
    }
    if ((paramInt1 & 0x100) == 256) {
      ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(0L);
    }
    ((oidb_0x88d.GroupInfo)localObject2).uint32_auto_agree_join_group_user_num_for_conf_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_auto_agree_join_group_user_num_for_normal_group.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(paramLong);
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    if (paramInt2 > 0) {
      ((oidb_0x88d.ReqGroupInfo)localObject1).uint32_last_get_group_name_time.set(paramInt2);
    }
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong);
    ((ToServiceMsg)localObject2).extraData.putInt("nFlag", paramInt1);
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 1);
    ((ToServiceMsg)localObject2).extraData.putInt("seq", paramInt3);
    ((ToServiceMsg)localObject2).extraData.putString("processName", paramString);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    a(paramLong1, paramLong2, false);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    cmd0x3fe.LevelMsg localLevelMsg = new cmd0x3fe.LevelMsg();
    localLevelMsg.uint32_subcmd.set(1);
    Object localObject = new cmd0x3fe.ReqBody();
    cmd0x3fe.UserInfo localUserInfo = new cmd0x3fe.UserInfo();
    localUserInfo.uint64_uin.set(paramLong1);
    localUserInfo.uint32_online_time.set(paramInt);
    ((cmd0x3fe.ReqBody)localObject).rpt_msg_user_info.add(localUserInfo);
    ((cmd0x3fe.ReqBody)localObject).uint64_group_code.set(paramLong2);
    localLevelMsg.msg_level_req.set((MessageMicro)localObject);
    localObject = a("qunVideoOnlineLevel.0x3fe_0");
    ((ToServiceMsg)localObject).putWupBuffer(localLevelMsg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, int paramInt3)
  {
    a(0, paramLong1, paramLong2, paramInt1, paramInt2, paramInt3);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, List paramList, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(150);
      ((StringBuilder)localObject).append("send_oidb_0x899_0").append("|troopuin = ").append(paramLong1).append("|flag = ").append(paramInt1).append("|nStartUin = ").append(paramLong2).append("|memberNum = ").append(paramInt2).append("|filterMethod = ").append(paramInt3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
    }
    oidb_0x899.memberlist localmemberlist = new oidb_0x899.memberlist();
    localmemberlist.uint64_member_uin.set(0L);
    localmemberlist.uint32_shutup_timestap.set(0);
    Object localObject = new oidb_0x899.ReqBody();
    ((oidb_0x899.ReqBody)localObject).uint64_group_code.set(paramLong1);
    ((oidb_0x899.ReqBody)localObject).uint64_start_uin.set(paramLong2);
    if (paramInt1 == 3)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Long localLong = (Long)paramList.next();
        ((oidb_0x899.ReqBody)localObject).rpt_uint64_uin_list.add(localLong);
      }
    }
    ((oidb_0x899.ReqBody)localObject).uint32_identify_flag.set(paramInt1);
    ((oidb_0x899.ReqBody)localObject).memberlist_opt.set(localmemberlist);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2201);
    paramList.uint32_result.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x899.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x899_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putInt("nFlag", paramInt1);
    ((ToServiceMsg)localObject).extraData.putLong("nStartUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(150);
      ((StringBuilder)localObject1).append("send_oidb_0x89e").append("|troopuin = ").append(paramLong1).append("|oldOwner = ").append(paramLong2).append("|newOwner = ").append(paramLong3);
      QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject2 = new oidb_0x89e.ReqBody();
    ((oidb_0x89e.ReqBody)localObject2).uint64_group_code.set(paramLong1);
    ((oidb_0x89e.ReqBody)localObject2).uint64_old_owner.set(paramLong2);
    ((oidb_0x89e.ReqBody)localObject2).uint64_new_owner.set(paramLong3);
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2206);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x89e.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x89e_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong1);
    ((ToServiceMsg)localObject2).extraData.putLong("OldOwner", paramLong2);
    ((ToServiceMsg)localObject2).extraData.putLong("NewOwner", paramLong3);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.ModifyGroupInfoReq");
    localToServiceMsg.extraData.putLong("dwGroupCode", paramLong1);
    localToServiceMsg.extraData.putLong("cGroupOption", paramLong2);
    localToServiceMsg.extraData.putLong("dwGroupClass", paramLong3);
    Bundle localBundle = localToServiceMsg.extraData;
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = "";
    }
    localBundle.putString("strGroupName", (String)localObject);
    localToServiceMsg.extraData.putInt("wGroupFace", paramInt1);
    localObject = localToServiceMsg.extraData;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = "";
    }
    ((Bundle)localObject).putString("strGroupMemo", paramString1);
    paramString2 = localToServiceMsg.extraData;
    paramString1 = paramString3;
    if (paramString3 == null) {
      paramString1 = "";
    }
    paramString2.putString("strFingerMemo", paramString1);
    localToServiceMsg.extraData.putInt("modify_troopinfo_flag", paramInt2);
    if ((paramInt2 & 0x2) == 2) {
      localToServiceMsg.extraData.putLong("dwValidMask", 2L);
    }
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "submitHomework  homeworkID = " + paramLong1 + ",troopUin = " + paramLong2 + ",content = " + paramString);
    }
    hw_submit_homework.ReqSubmitHomework localReqSubmitHomework = new hw_submit_homework.ReqSubmitHomework();
    localReqSubmitHomework.hw_id.set(paramLong1);
    localReqSubmitHomework.gid.set(paramLong2);
    localReqSubmitHomework.status.set(2);
    hw_submit_homework.HwCommentInfo localHwCommentInfo = new hw_submit_homework.HwCommentInfo();
    localHwCommentInfo.text.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqSubmitHomework.comment_info.set(localHwCommentInfo);
    paramString = a("HwSvc.submit_homework");
    paramString.putWupBuffer(localReqSubmitHomework.toByteArray());
    b(paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_member_card.get_group_member_card_info");
    group_member_info.ReqBody localReqBody = new group_member_info.ReqBody();
    localReqBody.uint64_group_code.set(paramLong1);
    localReqBody.uint64_uin.set(paramLong2);
    localReqBody.bool_new_client.set(true);
    localReqBody.uint32_client_type.set(1);
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    localToServiceMsg.setTimeout(30000L);
    localToServiceMsg.extraData.putBoolean("once", paramBoolean);
    b(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberCard, memberUin: " + paramLong2 + " troopCode: " + paramLong1);
    }
  }
  
  public void a(long paramLong1, String paramString1, long paramLong2, List paramList, int paramInt, long paramLong3, long paramLong4, long paramLong5, String paramString2, String paramString3)
  {
    cmd0x91b.ReqBody localReqBody = new cmd0x91b.ReqBody();
    localReqBody.uint64_group_code.set(Long.valueOf(paramLong1).longValue());
    localReqBody.uint32_source.set(1);
    localReqBody.uint32_notify_aio_flag.set(1);
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "setTroopInfoAndAuditTimesBy0x91a: cityId:" + paramInt + "|lat:" + paramLong3 + "|lon:" + paramLong4);
    }
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    if (!TextUtils.isEmpty(paramString1)) {
      localGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    localGroupInfo.uint32_group_class_ext.set((int)paramLong2);
    new ArrayList();
    paramString1 = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      oidb_0x88d.TagRecord localTagRecord = new oidb_0x88d.TagRecord();
      localTagRecord.bytes_tag_value.set(ByteStringMicro.copyFromUtf8(str));
      paramString1.add(localTagRecord);
    }
    localGroupInfo.rpt_tag_record.set(paramString1);
    if ((paramLong3 != 0L) && (paramLong4 != 0L))
    {
      paramString1 = new oidb_0x88d.GroupGeoInfo();
      paramString1.uint32_cityid.set(paramInt);
      paramString1.int64_latitude.set(paramLong3);
      paramString1.int64_longitude.set(paramLong4);
      paramString1.bytes_geocontent.set(ByteStringMicro.copyFromUtf8(paramString2));
      paramString1.uint64_poi_id.set(paramLong5);
      localGroupInfo.group_geo_info.set(paramString1);
    }
    if (paramString3 != null)
    {
      localGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
      localGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.info.set(localGroupInfo);
    paramString1 = new oidb_sso.OIDBSSOPkg();
    paramString1.uint32_command.set(2331);
    paramString1.uint32_service_type.set(1);
    paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramList = a("OidbSvc.0x91b_1");
    paramList.putWupBuffer(paramString1.toByteArray());
    paramList.setTimeout(30000L);
    b(paramList);
  }
  
  public void a(long paramLong, List paramList, boolean paramBoolean)
  {
    Object localObject = new oidb_0x8a0.ReqBody();
    ((oidb_0x8a0.ReqBody)localObject).opt_uint64_group_code.set(paramLong);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      oidb_0x8a0.KickMemberInfo localKickMemberInfo = new oidb_0x8a0.KickMemberInfo();
      localKickMemberInfo.opt_uint32_opearte.set(5);
      localKickMemberInfo.opt_uint64_member_uin.set(((Long)paramList.get(i)).longValue());
      PBUInt32Field localPBUInt32Field = localKickMemberInfo.opt_uint32_flag;
      if (paramBoolean) {}
      for (int j = 1;; j = 0)
      {
        localPBUInt32Field.set(j);
        localArrayList.add(localKickMemberInfo);
        i += 1;
        break;
      }
    }
    ((oidb_0x8a0.ReqBody)localObject).rpt_msg_kick_list.set(localArrayList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2208);
    paramList.uint32_result.set(0);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8a0.ReqBody)localObject).toByteArray()));
    localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x8a0_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("troopUin", paramLong);
    b((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.ReqBatchProcess");
    localToServiceMsg.extraData.putLong("troop_code", paramLong);
    localToServiceMsg.extraData.putBoolean("is_admin", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean, String paramString)
  {
    int i = 0;
    NewIntent localNewIntent = new NewIntent(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), PbServlet.class);
    localNewIntent.putExtra("cmd", "ProfileService.Pb.SetGroupLocation");
    GroupLocation.SetGroupLocationReq localSetGroupLocationReq = new GroupLocation.SetGroupLocationReq();
    localSetGroupLocationReq.groupcode.set(Utils.a(paramLong));
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localSetGroupLocationReq.grouplocation.set(str);
    localNewIntent.putExtra("data", localSetGroupLocationReq.toByteArray());
    localNewIntent.putExtra("TroopUin", paramLong);
    localNewIntent.putExtra("isClear", paramBoolean);
    paramString = str.split("\\|");
    int j;
    if (paramString.length == 4)
    {
      j = (int)(Float.valueOf(paramString[1]).floatValue() * 1000000.0F);
      i = (int)(Float.valueOf(paramString[2]).floatValue() * 1000000.0F);
    }
    for (;;)
    {
      localNewIntent.putExtra("lat", j);
      localNewIntent.putExtra("lon", i);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      return;
      j = 0;
    }
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramIntent.getStringExtra("cmd");
    paramObject = (byte[])paramObject;
    if (str.equalsIgnoreCase("ProfileService.Pb.SetGroupLocation")) {
      a(paramIntent, paramFromServiceMsg, paramObject);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, byte[] paramArrayOfByte, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "clearTroopAIORedDot, troopUin=" + paramString);
    }
    cmd0x8ca.ReqBody localReqBody = new cmd0x8ca.ReqBody();
    localReqBody.opt_uint32_sub_cmd.set(3L);
    try
    {
      localReqBody.opt_uint64_from_uin.set(Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
      localReqBody.opt_uint64_group_code.set(Long.parseLong(paramString));
      localReqBody.opt_bytes_group_sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      localReqBody.opt_uint64_appid.set(paramLong);
      paramArrayOfByte = new oidb_sso.OIDBSSOPkg();
      paramArrayOfByte.uint32_command.set(2250);
      paramArrayOfByte.uint32_result.set(0);
      paramArrayOfByte.uint32_service_type.set(2);
      paramArrayOfByte.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramQQAppInterface = new ToServiceMsg("mobileqq.service", paramQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x8ca_2");
      paramQQAppInterface.extraData.putString("troopUin", paramString);
      paramQQAppInterface.extraData.putString("type", String.valueOf(paramLong));
      paramQQAppInterface.putWupBuffer(paramArrayOfByte.toByteArray());
      b(paramQQAppInterface);
      return;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "clearTroopAIORedDot error, NumberFormatException, troopUin : " + paramString);
    }
  }
  
  public void a(MessageForReplyText paramMessageForReplyText)
  {
    a(1, paramMessageForReplyText);
  }
  
  public void a(TroopEnterEffectController.TroopEnterEffectData paramTroopEnterEffectData)
  {
    TroopEnterEffectManager localTroopEnterEffectManager = (TroopEnterEffectManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(230);
    if (localTroopEnterEffectManager.a().jdField_a_of_type_Boolean)
    {
      localTroopEnterEffectManager.a(paramTroopEnterEffectData);
      ContactUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramTroopEnterEffectData.jdField_a_of_type_JavaLangString, paramTroopEnterEffectData.jdField_b_of_type_JavaLangString, 1, 0);
      a(96, true, paramTroopEnterEffectData);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopEnterEffect", 2, "handleTroopEnterEffectPush function not enable");
  }
  
  public void a(HomeworkInfo paramHomeworkInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "assignHomework hwInfo = " + paramHomeworkInfo);
    }
    long l1 = paramHomeworkInfo.jdField_a_of_type_Long;
    long l2 = paramHomeworkInfo.jdField_b_of_type_Long;
    Object localObject = paramHomeworkInfo.jdField_a_of_type_JavaLangString;
    String str = paramHomeworkInfo.jdField_b_of_type_JavaLangString;
    boolean bool = paramHomeworkInfo.jdField_a_of_type_Boolean;
    List localList = paramHomeworkInfo.jdField_a_of_type_JavaUtilList;
    paramHomeworkInfo = new hw_assign_homework.ReqAssignHomework();
    value.HomeworkInfo localHomeworkInfo = new value.HomeworkInfo();
    localHomeworkInfo.group_id.set(l1);
    localHomeworkInfo.uin.set(l2);
    localHomeworkInfo.title.set((String)localObject);
    localHomeworkInfo.content.set(ByteStringMicro.copyFromUtf8(str));
    localHomeworkInfo.date.set("dd");
    localHomeworkInfo.need_feedback.set(bool);
    localHomeworkInfo.syncgids.set(localList);
    paramHomeworkInfo.info.set(localHomeworkInfo);
    localObject = a("HwSvc.assign_homework");
    ((ToServiceMsg)localObject).putWupBuffer(paramHomeworkInfo.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "onReceive,resp == null");
      }
    }
    String str;
    do
    {
      return;
      str = paramFromServiceMsg.getServiceCmd();
      if (!a(str)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler", 2, "cmdfilter error=" + str);
    return;
    if ("HwSvc.send_msg".equalsIgnoreCase(str))
    {
      TroopHandler.TroopBulkSendMessage.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (TroopHandler.Oidb_0xb36.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str))
    {
      TroopHandler.Oidb_0xb36.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("GroupSvc.JoinGroupLink".equalsIgnoreCase(str))
    {
      V(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("GroupOpen.CheckJsApiToken".equals(str))
    {
      U(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("HwSvc.assign_homework".equals(str))
    {
      W(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("HwSvc.get_homework_info".equals(str))
    {
      X(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("HwSvc.submit_homework".equals(str))
    {
      Y(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("friendlist.GetTroopListReqV2".equals(str))
    {
      if ((paramFromServiceMsg.getResultCode() == 2901) && (paramToServiceMsg != null))
      {
        int i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "k_resend_cnt" + i);
        }
        if (i < 2)
        {
          paramToServiceMsg.extraData.putInt("k_resend_cnt", i + 1);
          a(paramToServiceMsg);
          return;
        }
      }
      if (paramObject == null)
      {
        a(2, false, null);
        return;
      }
      paramFromServiceMsg = (GetTroopListRespV2)paramObject;
      if ((paramFromServiceMsg.result == 1) || ((paramFromServiceMsg.vecTroopList == null) && (paramFromServiceMsg.vecTroopListDel == null)))
      {
        a(2, false, null);
        return;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("friendlist.GetMultiTroopInfoReq".equals(str))
    {
      if (paramFromServiceMsg.isSuccess())
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (GetMultiTroopInfoResp)paramObject);
          return;
        }
        a(3, true, null);
        return;
      }
      a(3, false, null);
      return;
    }
    if ("friendlist.ModifyGroupCardReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject != null)
      {
        a(paramToServiceMsg, paramFromServiceMsg, (ModifyGroupCardResp)paramObject);
        return;
      }
      a(10, false, null);
      return;
    }
    if ("friendlist.ModifyGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd())) {
      if (!(paramObject instanceof ModifyGroupInfoResp)) {
        break label2094;
      }
    }
    label2094:
    for (paramObject = (ModifyGroupInfoResp)paramObject;; paramObject = null)
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
      if ("OidbSvc.0x903_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("friendlist.GetTroopAppointRemarkReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramFromServiceMsg, (GetTroopAppointRemarkResp)paramObject);
          return;
        }
        a(11, false, null);
        return;
      }
      if ("friendlist.getTroopMemberList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramObject != null)
        {
          a(paramToServiceMsg, (GetTroopMemberListResp)paramObject);
          return;
        }
        a(5, false, new Object[] { a(paramToServiceMsg.extraData.getLong("troop_uin")), null, Integer.valueOf(paramToServiceMsg.extraData.getInt("reqType", 0)), Long.valueOf(paramToServiceMsg.extraData.getLong("timestamp")) });
        return;
      }
      if ("group_member_card.get_group_member_card_info".equals(paramFromServiceMsg.getServiceCmd()))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x406_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ad(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        switch (paramToServiceMsg.extraData.getInt("subCmd", -1))
        {
        case 3: 
        case 5: 
        default: 
          return;
        case 1: 
          j(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 4: 
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 10: 
          n(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 2: 
          ab(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 6: 
          x(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 7: 
          v(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 8: 
          w(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        z(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x899_0".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x899_9".equals(paramFromServiceMsg.getServiceCmd())))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x89e_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8c9_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b8_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        switch (paramToServiceMsg.extraData.getInt("subCmd", -1))
        {
        case 4: 
        default: 
          r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        case 3: 
          m(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        ah(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x88d_10".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ac(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.ReqBatchProcess".equals(paramFromServiceMsg.getServiceCmd()))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x8bb_2".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x8bb_9".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x8bb_7".equals(paramFromServiceMsg.getServiceCmd()))) {
        break;
      }
      if ("OidbSvc.0x8a0_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramFromServiceMsg.getServiceCmd(), paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("group_anonymous_generate_nick.group".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ag(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("ProfileService.GroupMngReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      if ("OidbSvc.0x8b4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ae(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d6_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        af(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        Z(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8a7_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ai(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        aj(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8ca_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ak(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9fa".equals(paramFromServiceMsg.getServiceCmd()))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9ab_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("SHomeworkSvc.querycard".equals(paramFromServiceMsg.getServiceCmd())) || ("SHomeworkSvc.modifycard".equals(paramFromServiceMsg.getServiceCmd()))) {
        break;
      }
      if ("GroupOpen.ReadAppList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        B(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.SortAppList".equals(paramFromServiceMsg.getServiceCmd()))
      {
        C(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("GroupOpen.ClearRedPoint".equals(paramFromServiceMsg.getServiceCmd()))
      {
        D(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qunVideoOnlineLevel.0x3fe_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa80_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        E(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6b6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        F(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6b5".equals(paramFromServiceMsg.getServiceCmd()))
      {
        H(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6c2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        I(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6c3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        G(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (("OidbSvc.0x5ba_4".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x5ba_7".equals(paramFromServiceMsg.getServiceCmd()))) {
        break;
      }
      if ("OidbSvc.0xa8d".equals(paramFromServiceMsg.getServiceCmd()))
      {
        J(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x6d1_3".equals(paramFromServiceMsg.getServiceCmd()))
      {
        am(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x711_127".equals(paramFromServiceMsg.getServiceCmd()))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x91a_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x91c_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        aa(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("NearbyExt.query_user_follow_status".equals(paramFromServiceMsg.getServiceCmd()))
      {
        al(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_96".equals(paramFromServiceMsg.getServiceCmd()))
      {
        K(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_86".equals(paramFromServiceMsg.getServiceCmd()))
      {
        N(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_94".equals(paramFromServiceMsg.getServiceCmd()))
      {
        L(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x928".equals(paramFromServiceMsg.getServiceCmd()))
      {
        O(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("qunVideoGray.0x3fb_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        P(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa2a_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        an(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa2a_1".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ap(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa2a_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        ao(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("videohub_group_notify_read.cmd0x2323".equals(paramFromServiceMsg.getServiceCmd()))
      {
        Q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xae6".equals(paramFromServiceMsg.getServiceCmd()))
      {
        R(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb01".equals(paramFromServiceMsg.getServiceCmd()))
      {
        aq(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x42d_4".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TroopHandler", 2, "mTroopBatchAddFriendMgr is null");
        return;
      }
      if ("OidbSvc.0xaf6_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        S(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xaf4_1".equalsIgnoreCase(str))
      {
        ar(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xb14".equalsIgnoreCase(str))
      {
        T(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x53c_2".equals(str))
      {
        M(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("oidbSvc.0x783_15".equals(paramFromServiceMsg.getServiceCmd()))
      {
        as(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (!"OidbSvc.0x787_11".equals(str)) {
        break;
      }
      t(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
  }
  
  public void a(Long paramLong)
  {
    Object localObject = new cmd0x903.SubCmd0x2Req();
    ((cmd0x903.SubCmd0x2Req)localObject).opt_uint64_group_code.set(paramLong.longValue());
    paramLong = new cmd0x903.ReqBody();
    paramLong.opt_msg_get_invited_uin_list_req.set((MessageMicro)localObject);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2307);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramLong.toByteArray()));
    paramLong = a("OidbSvc.0x903_2");
    paramLong.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramLong.setTimeout(30000L);
    b(paramLong);
  }
  
  public void a(String paramString)
  {
    Object localObject = new cmd0x91a.ReqBody();
    ((cmd0x91a.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString).longValue());
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2330);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x91a.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x91a_1");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, byte paramByte, long paramLong, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Long localLong;
    do
    {
      return;
      localObject = Long.valueOf(SystemClock.uptimeMillis());
      localLong = (Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    } while ((localLong != null) && (Math.abs(((Long)localObject).longValue() - localLong.longValue()) < 60000L));
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    Object localObject = a("ProfileService.getGroupInfoReq");
    ((ToServiceMsg)localObject).extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((ToServiceMsg)localObject).extraData.putString("troop_uin", paramString);
    ((ToServiceMsg)localObject).extraData.putByte("get_groupablm", paramByte);
    ((ToServiceMsg)localObject).extraData.putLong("groupablm_timestamp", paramLong);
    ((ToServiceMsg)localObject).extraData.putInt("cStatOption", paramInt);
    ((ToServiceMsg)localObject).extraData.putByte("cIfGetAuthInfo", (byte)1);
    a((ToServiceMsg)localObject);
  }
  
  public void a(String paramString, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 0);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localToServiceMsg.extraData.putInt("stat_option", paramInt);
    localToServiceMsg.extraData.putByte("cIfGetAuthInfo", (byte)1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (paramString == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopHandler", 2, "getShowExternalTroopList destUin is null");
      }
    }
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramString = paramString.trim();
          long l = Long.parseLong(paramString);
          if (l != 0L)
          {
            Object localObject1 = new cmd0x8b4.ReqBody();
            ((cmd0x8b4.ReqBody)localObject1).uint64_dst_uin.set(l);
            ((cmd0x8b4.ReqBody)localObject1).uint32_start.set(paramInt1);
            ((cmd0x8b4.ReqBody)localObject1).uint32_cnt.set(paramInt2);
            Object localObject2 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            localObject2 = new oidb_sso.OIDBSSOPkg();
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2228);
            ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject1).toByteArray()));
            ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(4);
            localObject1 = a("OidbSvc.0x8b4");
            ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
            ((ToServiceMsg)localObject1).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
            ((ToServiceMsg)localObject1).extraData.putString("target_uin", paramString);
            b((ToServiceMsg)localObject1);
            if (QLog.isColorLevel())
            {
              QLog.d("TroopHandler.troop.get_show_external_troop_list", 2, "getShowExternalTroopList, request begin==>" + "|ssoSeq:" + ((ToServiceMsg)localObject1).getRequestSsoSeq() + "|ServiceCmd:" + ((ToServiceMsg)localObject1).getServiceCmd() + "|destUin:" + paramString);
              return;
            }
          }
        }
        catch (NumberFormatException paramString) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopHandler", 2, "NumberFormatException");
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    Object localObject1 = new oidb_0x8b8.ReqBody();
    if ((paramArrayList == null) || (paramInt > 2)) {
      return;
    }
    try
    {
      ((oidb_0x8b8.ReqBody)localObject1).uint64_group_uin.set(Long.parseLong(paramString));
      ((oidb_0x8b8.ReqBody)localObject1).uint32_subcmd.set(paramInt + 1);
      ((oidb_0x8b8.ReqBody)localObject1).uint32_sequence.set(23);
      Object localObject2;
      if (paramInt == 0)
      {
        localObject2 = new oidb_0x8b8.ModifyOrderReq();
        ((oidb_0x8b8.ModifyOrderReq)localObject2).rpt_uint32_pic_list.set(paramArrayList);
        ((oidb_0x8b8.ModifyOrderReq)localObject2).uint32_pic_cnt.set(paramArrayList.size());
        ((oidb_0x8b8.ReqBody)localObject1).msg_modify_order.set((MessageMicro)localObject2);
      }
      for (;;)
      {
        paramArrayList = new oidb_sso.OIDBSSOPkg();
        paramArrayList.uint32_command.set(2232);
        paramArrayList.uint32_service_type.set(1);
        paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8b8.ReqBody)localObject1).toByteArray()));
        localObject1 = a("OidbSvc.0x8b8_1");
        ((ToServiceMsg)localObject1).putWupBuffer(paramArrayList.toByteArray());
        ((ToServiceMsg)localObject1).extraData.putInt("subCmd", paramInt);
        ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
        ((ToServiceMsg)localObject1).setTimeout(30000L);
        b((ToServiceMsg)localObject1);
        return;
        int i;
        if (paramInt == 1)
        {
          localObject2 = new oidb_0x8b8.SetDefaultReq();
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            i = ((Integer)paramArrayList.next()).intValue();
            ((oidb_0x8b8.SetDefaultReq)localObject2).uint32_default_id.set(i);
          }
          ((oidb_0x8b8.ReqBody)localObject1).msg_set_default.set((MessageMicro)localObject2);
        }
        else if (paramInt == 2)
        {
          localObject2 = new oidb_0x8b8.DelPicReq();
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            i = ((Integer)localIterator.next()).intValue();
            ((oidb_0x8b8.DelPicReq)localObject2).rpt_uint32_del_list.add(Integer.valueOf(i));
          }
          ((oidb_0x8b8.DelPicReq)localObject2).uint32_del_cnt.set(paramArrayList.size());
          ((oidb_0x8b8.ReqBody)localObject1).msg_del_pic.set((MessageMicro)localObject2);
        }
      }
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troopgroup_vedio.invite", 2, " troopUin:" + paramString1 + ",inviterUin:" + paramLong + ", inviteId:" + paramString2);
    }
    cmd0x6d1.ReqBody localReqBody = new cmd0x6d1.ReqBody();
    cmd0x6d1.DealInviteReqBody localDealInviteReqBody = new cmd0x6d1.DealInviteReqBody();
    try
    {
      localDealInviteReqBody.uint64_group_code.set(Long.parseLong(paramString1));
      localDealInviteReqBody.str_id.set(paramString2);
      localDealInviteReqBody.uint64_uin.set(paramLong);
      localDealInviteReqBody.uint32_deal_result.set(paramInt);
      localReqBody.deal_invite_req_body.set(localDealInviteReqBody);
      localReqBody.uint32_app_type.set(2);
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(1745);
      paramString1.uint32_service_type.set(3);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      paramString2 = a("OidbSvc.0x6d1_3");
      paramString2.putWupBuffer(paramString1.toByteArray());
      b(paramString2);
      return;
    }
    catch (NumberFormatException paramString2)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, " NumberFormatException, troopUin:" + paramString1);
    }
  }
  
  public void a(String paramString, Boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("hw_troop", 2, "getTroopClassType, troopCode = " + paramString);
      }
      long l = Long.parseLong(paramString);
      paramString = a("ProfileService.ReqBatchProcess");
      paramString.extraData.putLong("troop_code", l);
      paramString.extraData.putBoolean("param_get_troop_class_type", true);
      paramString.extraData.putBoolean("is_admin", true);
      paramString.extraData.putBoolean("isFromMsg0x26", paramBoolean.booleanValue());
      a(paramString);
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        paramString.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("hw_troop", 2, "getTroopClassType:" + paramString.toString());
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new cmd0x8a7.ReqBody();
    ((cmd0x8a7.ReqBody)localObject).uint32_sub_cmd.set(1);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_uin.set(2);
    ((cmd0x8a7.ReqBody)localObject).uint32_limit_interval_type_for_group.set(1);
    try
    {
      ((cmd0x8a7.ReqBody)localObject).uint64_uin.set(Long.parseLong(paramString1));
      ((cmd0x8a7.ReqBody)localObject).uint64_group_code.set(Long.parseLong(paramString2));
      paramString1 = new oidb_sso.OIDBSSOPkg();
      paramString1.uint32_command.set(2215);
      paramString1.uint32_result.set(0);
      paramString1.uint32_service_type.set(0);
      paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8a7.ReqBody)localObject).toByteArray()));
      localObject = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x8a7_0");
      ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString2);
      ((ToServiceMsg)localObject).putWupBuffer(paramString1.toByteArray());
      b((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", troopUin : " + paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x406_3");
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1030);
    localOIDBSSOPkg.uint32_service_type.set(3);
    cmd0x406.ReqBody localReqBody = new cmd0x406.ReqBody();
    cmd0x406.GroupFeeMemberListQuery localGroupFeeMemberListQuery = new cmd0x406.GroupFeeMemberListQuery();
    localGroupFeeMemberListQuery.string_project_id.set(paramString2);
    localGroupFeeMemberListQuery.uint32_member_type.set(paramInt);
    localGroupFeeMemberListQuery.uint32_page_index.set(0);
    localGroupFeeMemberListQuery.uint32_page_size.set(-1);
    try
    {
      localReqBody.uint64_group_id.set(Long.valueOf(paramString1).longValue());
      localReqBody.msg_member_list.set(localGroupFeeMemberListQuery);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
      localToServiceMsg.putWupBuffer(localOIDBSSOPkg.toByteArray());
      b(localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.troop_fee", 2, "getTroopFeeMembers, troopUin: " + paramString1 + " troopFeeId: " + paramString2);
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TroopHandler.troop.troop_fee", 2, "NumberFormatException!getTroopFeeMembers, troopUin: " + paramString1 + " troopFeeId: " + paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.closeRcvMsgTmp", 2, "send_oidb_0xa80_0:" + paramString1 + "," + paramString2 + "," + paramInt1);
    }
    if (paramInt1 == 1) {
      this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramString2);
        long l2 = Long.parseLong(paramString1);
        localObject2 = new oidb_cmd0xa80.MemberInfo();
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint64_member_uin.set(l1);
        if (paramInt2 != 0) {
          continue;
        }
        ((oidb_cmd0xa80.MemberInfo)localObject2).uint32_heartbeat_time.set((int)(System.currentTimeMillis() / 1000L));
        Object localObject1 = new oidb_cmd0xa80.ReqGroupInfo();
        ((oidb_cmd0xa80.ReqGroupInfo)localObject1).rpt_msg_member_info.add((MessageMicro)localObject2);
        ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint64_group_code.set(l2);
        ((oidb_cmd0xa80.ReqGroupInfo)localObject1).uint32_op.set(paramInt1);
        localObject2 = new oidb_cmd0xa80.ReqBody();
        ((oidb_cmd0xa80.ReqBody)localObject2).rpt_msg_req_group_info.add((MessageMicro)localObject1);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2688);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_cmd0xa80.ReqBody)localObject2).toByteArray()));
        localObject2 = a("OidbSvc.0xa80_0");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).extraData.putString("troopUin", paramString1);
        ((ToServiceMsg)localObject2).extraData.putString("memberUin", paramString2);
        ((ToServiceMsg)localObject2).extraData.putInt("cmd", paramInt1);
        b((ToServiceMsg)localObject2);
        return;
      }
      catch (Exception paramString1)
      {
        long l1;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(".troop.closeRcvMsgTmp", 2, "send_oidb_0xa80_0:" + paramString1.toString());
      }
      if (paramInt1 == 0)
      {
        l1 = System.currentTimeMillis();
        if ((this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString1)) && (l1 - ((Long)this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1)).longValue() < 15000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d(".troop.closeRcvMsgTmp", 2, "send 0xa80cmd==0 less 15s");
          }
        }
        else
        {
          this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, Long.valueOf(l1));
          continue;
          ((oidb_cmd0xa80.MemberInfo)localObject2).uint64_group_msg_mask.set(paramInt2);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_cmduin_join_msg_seq.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_cmduin_join_time.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_class_ext.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString1));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(200000020);
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("inviteUin", paramString2);
    ((ToServiceMsg)localObject2).extraData.putInt("from", paramInt);
    ((ToServiceMsg)localObject2).extraData.putString("fromUin", paramString3);
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString1));
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 10);
    ((ToServiceMsg)localObject2).setTimeout(5000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, String paramString3, byte[] paramArrayOfByte, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("joinGroup", 2, "sourceID:" + paramInt);
    }
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 1);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localToServiceMsg.extraData.putString("back_msg", paramString2);
    localToServiceMsg.extraData.putInt("stat_option", paramInt);
    localToServiceMsg.extraData.putString("join_group_key", paramString3);
    if (paramArrayOfByte != null) {
      localToServiceMsg.extraData.putByteArray("new_Member_Msg", paramArrayOfByte);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localToServiceMsg.extraData.putString("pic_url", paramString4);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    long l = System.currentTimeMillis();
    Object localObject = "add_" + paramString1 + "_" + paramString2;
    if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject)) && (l - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localObject)).longValue() < 2000L)) {}
    TroopInfo localTroopInfo;
    ArrayList localArrayList;
    do
    {
      return;
      this.jdField_b_of_type_JavaUtilHashMap.put(localObject, Long.valueOf(l));
      localObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      localTroopInfo = ((TroopManager)localObject).b(paramString1);
      if ((localTroopInfo == null) || (localTroopInfo.hasSetTroopHead())) {
        break;
      }
      localArrayList = ((TroopManager)localObject).a(paramString1);
    } while (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2));
    if ((localArrayList.size() == 0) || ((localArrayList.size() < 5) && (localTroopInfo.wMemberNum > 5))) {
      b(Long.parseLong(paramString1));
    }
    if ((localArrayList.size() < 5) && (!localArrayList.contains(paramString2)))
    {
      localArrayList.add(paramString2);
      localTroopInfo.updateHeadMemberList(localArrayList);
      this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.c(paramString1);
    }
    ((TroopManager)localObject).a(String.valueOf(paramString1), paramString2, null, -100, paramString3, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D, null, -100);
    if (localTroopInfo != null)
    {
      if (!((TroopCreateLogic)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(31)).a(paramString1, paramString2)) {
        localTroopInfo.wMemberNumClient += 1;
      }
      ((TroopManager)localObject).b(localTroopInfo);
    }
    a(104, true, null);
  }
  
  public void a(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = a("friendlist.GetTroopAppointRemarkReq");
    localToServiceMsg.extraData.putString("GroupUin", paramString1);
    localToServiceMsg.extraData.putString("GroupCode", paramString2);
    localToServiceMsg.extraData.putByte("cRichInfo", (byte)2);
    localToServiceMsg.extraData.putSerializable("vecUinList", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2 = null;
    Object localObject1;
    long l;
    int i;
    if (paramBoolean2)
    {
      if (paramString2 == null) {}
      label88:
      label242:
      do
      {
        return;
        paramString1 = (String)localObject2;
        localObject1 = paramString2;
        try
        {
          paramString2 = paramString2.trim();
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          l = Long.parseLong(paramString2);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          Object localObject3 = new cmd0x8b4.ReqBody();
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((cmd0x8b4.ReqBody)localObject3).uint64_gc.set(l);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          Object localObject4 = ((cmd0x8b4.ReqBody)localObject3).uint32_flag;
          if (paramBoolean1 != true) {
            break;
          }
          i = 1;
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((PBUInt32Field)localObject4).set(i);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          localObject4 = new oidb_sso.OIDBSSOPkg();
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((oidb_sso.OIDBSSOPkg)localObject4).uint32_command.set(2228);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((oidb_sso.OIDBSSOPkg)localObject4).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x8b4.ReqBody)localObject3).toByteArray()));
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((oidb_sso.OIDBSSOPkg)localObject4).uint32_service_type.set(2);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          localObject2 = a("OidbSvc.0x8b4");
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject4).toByteArray());
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((ToServiceMsg)localObject2).extraData.putString("0x8d4_cmd_key", "setShowExternalStatus0x8d4");
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          localObject3 = ((ToServiceMsg)localObject2).extraData;
          if (paramBoolean1 != true) {
            break label410;
          }
          i = 1;
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((Bundle)localObject3).putInt("reqType", i);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          ((ToServiceMsg)localObject2).extraData.putString("troop_uin", paramString2);
          paramString1 = (String)localObject2;
          localObject1 = paramString2;
          b((ToServiceMsg)localObject2);
        }
        catch (NumberFormatException paramString2)
        {
          for (;;)
          {
            localObject2 = paramString1;
            paramString2 = (String)localObject1;
            if (QLog.isColorLevel())
            {
              QLog.e("TroopHandler", 2, "NumberFormatException");
              localObject2 = paramString1;
              paramString2 = (String)localObject1;
            }
          }
        }
      } while (!QLog.isColorLevel());
      localObject1 = new StringBuilder("switchTroopShowExternalStatus, requset begin==>").append("ssoSeq:");
      if (localObject2 != null) {
        break label827;
      }
      paramString1 = "null";
      label321:
      localObject1 = ((StringBuilder)localObject1).append(paramString1).append("|ServiceCmd:");
      if (localObject2 != null) {
        break label839;
      }
    }
    label410:
    label821:
    label827:
    label839:
    for (paramString1 = "null";; paramString1 = ((ToServiceMsg)localObject2).getServiceCmd())
    {
      QLog.d("TroopHandler.troop.set_show_external_status", 2, paramString1 + "|beforeJoinedTroop:" + paramBoolean2 + "|troopUin:" + paramString2 + "|reqType:" + paramBoolean1 + "|timestamp:" + NetConnInfoCenter.getServerTime());
      return;
      i = 0;
      break label88;
      i = 0;
      break label242;
      if (paramString1 == null) {
        break;
      }
      localObject1 = new oidb_0x5d6.SnsUpdateItem();
      ((oidb_0x5d6.SnsUpdateItem)localObject1).uint32_update_sns_type.set(13571);
      l = NetConnInfoCenter.getServerTime();
      localObject2 = new byte[5];
      if (paramBoolean1)
      {
        localObject2[0] = 1;
        label490:
        localObject2[1] = ((byte)(int)(l >> 24 & 0xFF));
        localObject2[2] = ((byte)(int)(l >> 16 & 0xFF));
        localObject2[3] = ((byte)(int)(l >> 8 & 0xFF));
        localObject2[4] = ((byte)(int)(0xFF & l));
        ((oidb_0x5d6.SnsUpdateItem)localObject1).uint32_value_offset.set(1);
        ((oidb_0x5d6.SnsUpdateItem)localObject1).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject2));
        localObject2 = new ArrayList();
        ((List)localObject2).add(localObject1);
        localObject1 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(BizTroopHandler.a(paramString1));
        ((oidb_0x5d6.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.set((List)localObject2);
        paramString1 = new ArrayList();
        paramString1.add(localObject1);
        localObject1 = new oidb_0x5d6.ReqBody();
        ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(11);
        ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
        ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set(paramString1);
        paramString1 = new oidb_sso.OIDBSSOPkg();
        paramString1.uint32_command.set(1494);
        paramString1.uint32_result.set(0);
        paramString1.uint32_service_type.set(3);
        paramString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
        localObject2 = a("OidbSvc.0x5d6_3");
        ((ToServiceMsg)localObject2).extraData.putString("0x5d6_cmd_key", "setShowExternalStatus0x5d6");
        ((ToServiceMsg)localObject2).extraData.putString("troop_uin", paramString2);
        localObject1 = ((ToServiceMsg)localObject2).extraData;
        if (paramBoolean1 != true) {
          break label821;
        }
      }
      for (i = 1;; i = 0)
      {
        ((Bundle)localObject1).putInt("reqType", i);
        ((ToServiceMsg)localObject2).extraData.putLong("timestamp", l);
        ((ToServiceMsg)localObject2).putWupBuffer(paramString1.toByteArray());
        b((ToServiceMsg)localObject2);
        break;
        localObject2[0] = 0;
        break label490;
      }
      paramString1 = Integer.valueOf(((ToServiceMsg)localObject2).getRequestSsoSeq());
      break label321;
    }
  }
  
  public void a(String paramString, ArrayList paramArrayList)
  {
    a(paramString, paramArrayList, 0);
  }
  
  public void a(String paramString1, ArrayList paramArrayList, String paramString2)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 8);
    localToServiceMsg.extraData.putString("troop_uin", paramString1);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localToServiceMsg.extraData.putStringArrayList("Invite_uins", paramArrayList);
    localToServiceMsg.extraData.putString("back_msg", paramString2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    if ((paramString == null) || (paramArrayList1 == null) || (paramArrayList2 == null)) {}
    while (paramArrayList1.size() != paramArrayList2.size()) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      TroopMemberCardInfo localTroopMemberCardInfo = (TroopMemberCardInfo)paramArrayList1.get(i);
      int j = ((Integer)paramArrayList2.get(i)).intValue();
      stUinInfo localstUinInfo = new stUinInfo();
      localstUinInfo.cGender = localTroopMemberCardInfo.sex;
      localstUinInfo.dwuin = Long.parseLong(localTroopMemberCardInfo.memberuin);
      localstUinInfo.sEmail = localTroopMemberCardInfo.email;
      localstUinInfo.sName = localTroopMemberCardInfo.name;
      localstUinInfo.sPhone = localTroopMemberCardInfo.tel;
      localstUinInfo.sRemark = localTroopMemberCardInfo.memo;
      localstUinInfo.dwFlag = j;
      localArrayList.add(localstUinInfo);
      i += 1;
    }
    paramArrayList1 = a("friendlist.ModifyGroupCardReq");
    paramArrayList1.extraData.putLong("dwZero", 0L);
    paramArrayList1.extraData.putLong("dwGroupCode", Long.parseLong(paramString));
    paramArrayList1.extraData.putSerializable("vecUinInfo", localArrayList);
    paramArrayList1.extraData.putLong("dwNewSeq", 0L);
    a(paramArrayList1);
  }
  
  public void a(String paramString, List paramList, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, String.format("getTroopMemberCmnFrds troopUin:%s uin.size:%s", new Object[] { paramString, Integer.valueOf(paramList.size()) }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr = new TroopBatchAddFriendMgr(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr.a(paramString, paramList, paramLong);
  }
  
  public void a(String paramString, List paramList, boolean paramBoolean)
  {
    long l2 = -1L;
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopgetnews.", 2, "send_oidb_0x8c9_2, troopUin = " + paramString + ", appIds : " + paramList);
    }
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (localObject != null) {}
    for (;;)
    {
      try
      {
        l1 = Long.valueOf((String)localObject).longValue();
        if (paramString != null) {
          l2 = Long.valueOf(paramString).longValue();
        }
        paramString = new oidb_0x8c9.ReqBody();
        paramString.opt_uint64_from_uin.set(l1);
        paramString.opt_uint64_group_code.set(l2);
        paramString.rpt_uint64_appid.set(paramList);
        paramList = new oidb_sso.OIDBSSOPkg();
        paramList.uint32_command.set(2249);
        localObject = paramList.uint32_service_type;
        if (paramBoolean)
        {
          i = 4;
          ((PBUInt32Field)localObject).set(i);
          paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
          paramString = a("OidbSvc.0x8c9_2");
          paramString.putWupBuffer(paramList.toByteArray());
          b(paramString);
          return;
        }
      }
      catch (Exception paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.troopgetnews.", 2, "myUin error: myUin = " + (String)localObject + ", strTroopUin = " + paramString);
        return;
      }
      int i = 2;
      continue;
      long l1 = -1L;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getTroopShareLink: start");
    }
    join_group_link.ReqBody localReqBody = new join_group_link.ReqBody();
    if (paramBoolean) {
      localReqBody.type.set(1);
    }
    for (;;)
    {
      localReqBody.group_code.set(Long.valueOf(paramString).longValue());
      ToServiceMsg localToServiceMsg = a("GroupSvc.JoinGroupLink");
      localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
      localToServiceMsg.extraData.putBoolean("isVerify", paramBoolean);
      localToServiceMsg.extraData.putString("troopUin", paramString);
      b(localToServiceMsg);
      return;
      localReqBody.type.set(2);
    }
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    long l = a(paramString);
    if (l == 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopHandler.troop.troop_app", 2, new Object[] { "getNewTroopAppList troopUin invalid. str=", paramString });
      }
      return;
    }
    Object localObject = new oidb_0xaf4.ClientInfo();
    ((oidb_0xaf4.ClientInfo)localObject).platform.set(2);
    ((oidb_0xaf4.ClientInfo)localObject).version.set("7.6.0");
    oidb_0xaf4.ReqBody localReqBody = new oidb_0xaf4.ReqBody();
    localReqBody.group_id.set(l);
    localReqBody.client_info.set((MessageMicro)localObject);
    localReqBody.last_game_dynamic_ts.set(paramInt1);
    localObject = a("OidbSvc.0xaf4_1", 2804, paramInt2, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject).extraData.putBoolean("isProfileAppListChangedFromWebOperate", paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 1, "getNewTroopAppList. troopUin = " + paramString + ", isProfileAppListChangedFromWebOperate = " + paramBoolean + ", time=" + paramInt1);
    }
    b((ToServiceMsg)localObject);
  }
  
  public void a(String paramString1, boolean paramBoolean1, String paramString2, boolean paramBoolean2)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_face.set(0);
    Object localObject2 = new oidb_0x88d.GroupGeoInfo();
    ((oidb_0x88d.GroupGeoInfo)localObject2).bytes_geocontent.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_latitude.set(0L);
    ((oidb_0x88d.GroupGeoInfo)localObject2).int64_longitude.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).group_geo_info.set((MessageMicro)localObject2);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject1).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_class_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_cmduin_join_time.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_shutup_timestamp.set(1);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_conf_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_face.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_is_modify_conf_group_name.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_auto_agree_join_group_user_num_for_conf_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).uint32_auto_agree_join_group_user_num_for_normal_group.set(0);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString1));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(200000020);
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    if (paramBoolean1) {
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(19);
    }
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString1));
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 4);
    ((ToServiceMsg)localObject1).extraData.putString("source", paramString2);
    ((ToServiceMsg)localObject1).extraData.putBoolean("forceSave", paramBoolean2);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetMultiTroopInfoReq");
    localToServiceMsg.extraData.putSerializable("vecGroupCode", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList, int paramInt)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troop.troop_app", 2, "getTroopAppList: start");
    }
    cmd0xca05.ReqBody localReqBody = new cmd0xca05.ReqBody();
    localReqBody.uint32_type.set(0);
    Object localObject = new cmd0xca05.AppInfo();
    ((cmd0xca05.AppInfo)localObject).plat_type.set(2);
    ((cmd0xca05.AppInfo)localObject).str_app_version.set("7.6.0");
    int i = 0;
    while (i < paramArrayList.size())
    {
      localObject = (Integer)paramArrayList.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.troop_app", 2, "redPoint appid:" + localObject);
      }
      localReqBody.rpt_app_ids.add(Long.valueOf(((Integer)localObject).intValue() + 0L));
      i += 1;
    }
    localObject = a("GroupOpen.ClearRedPoint");
    ((ToServiceMsg)localObject).putWupBuffer(localReqBody.toByteArray());
    ((ToServiceMsg)localObject).extraData.putIntegerArrayList("appids", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putInt("groupType", paramInt);
    b((ToServiceMsg)localObject);
  }
  
  public void a(List paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getTroopMemberListForHeadBatch, size = " + paramList.size());
    }
    int k = (int)Math.ceil(paramList.size() / 50.0D);
    int i = 0;
    if (i < k)
    {
      if (paramList.size() < (i + 1) * 50) {}
      for (int j = paramList.size();; j = (i + 1) * 50)
      {
        Object localObject2 = paramList.subList(i * 50, j);
        Object localObject1 = new cmd0xaf6.ReqBody();
        ((cmd0xaf6.ReqBody)localObject1).group_id.set((List)localObject2);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2806);
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xaf6.ReqBody)localObject1).toByteArray()));
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
        localObject1 = a("OidbSvc.0xaf6_0");
        ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        ((ToServiceMsg)localObject1).setTimeout(30000L);
        b((ToServiceMsg)localObject1);
        i += 1;
        break;
      }
    }
  }
  
  public void a(List paramList, TroopHandler.KeywordTipInfoObserver paramKeywordTipInfoObserver)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getTroopAioKeywordTipInfo, ruleIds == null || ruleIds.size() == 0");
      }
      paramKeywordTipInfoObserver.a(false, null);
    }
    do
    {
      return;
      localObject = new oidb_0x971.ReqBody();
      ((oidb_0x971.ReqBody)localObject).rule_id.set(paramList);
      ProtoUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramKeywordTipInfoObserver, ((oidb_0x971.ReqBody)localObject).toByteArray(), "OidbSvc.0x971_0", 2417, 0);
    } while (!QLog.isColorLevel());
    paramKeywordTipInfoObserver = new StringBuilder();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramKeywordTipInfoObserver.append((Integer)((Iterator)localObject).next());
      paramKeywordTipInfoObserver.append(";");
    }
    QLog.i("TroopHandler", 2, "getTroopAioKeywordTipInfo,ruleIds.size=" + paramList.size() + ",content=" + paramKeywordTipInfoObserver.toString());
  }
  
  public void a(List paramList, GVideoStateGetListener paramGVideoStateGetListener)
  {
    cmd0x2323.ReqBody localReqBody = new cmd0x2323.ReqBody();
    localReqBody.group_code_list.set(paramList);
    ToServiceMsg localToServiceMsg = a("videohub_group_notify_read.cmd0x2323");
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    b(localToServiceMsg);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoGroupvideoGVideoStateGetListener = paramGVideoStateGetListener;
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, " requestGroupVideoState, groupUins size:" + paramList.size());
    }
  }
  
  public void a(SubMsgType0xab.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {}
    String str1;
    Object localObject;
    String str2;
    int i;
    do
    {
      return;
      str1 = paramMsgBody.uint64_gc.get() + "";
      localObject = paramMsgBody.uint64_uin.get() + "";
      str2 = paramMsgBody.string_reward_id.get();
      i = paramMsgBody.uint32_reward_status.get();
      if (QLog.isColorLevel()) {
        QLog.d(".troop.troop_reward.push", 2, "onLinePush receive 0x210_0xab: gc=" + str1 + ", ownerUin=" + (String)localObject + ", id=" + str2 + ", status=" + i);
      }
      paramMsgBody = (TroopRewardMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(151);
      localObject = paramMsgBody.a(str1, str2);
    } while (localObject == null);
    ((MessageForTroopReward)localObject).rewardStatus = i;
    paramMsgBody.a((MessageForTroopReward)localObject);
    a(82, true, new Object[] { str1, str2 });
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = ByteBuffer.allocate(13);
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramBoolean) {}
    for (short s = 0;; s = 1)
    {
      ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25190).putShort((short)2).putShort(s);
      localObject = a("OidbSvc.0x4ff_86", 1279, 86, ((ByteBuffer)localObject).array());
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      b((ToServiceMsg)localObject);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    a(paramBoolean, paramString1, paramString2, false, paramInt, System.currentTimeMillis());
  }
  
  public void a(boolean paramBoolean1, String paramString1, String paramString2, boolean paramBoolean2, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString1)) || ("0".equals(paramString1)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("get_troop_member", 2, "error troopuin: " + paramString1);
      }
      ReportController.b(null, "P_CliOper", "BizTechReport", "", "troopuinerror", "gettroopmemberlist", 0, 1, 0, "", "", "", "");
    }
    for (;;)
    {
      return;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendlist.getTroopMemberList");
      localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
      localToServiceMsg.extraData.putBoolean("force_refresh", paramBoolean1);
      localToServiceMsg.extraData.putBoolean("needCallBackCache", paramBoolean2);
      localToServiceMsg.extraData.putInt("reqType", paramInt);
      localToServiceMsg.extraData.putLong("timestamp", paramLong);
      String str = paramString1 + "_" + paramInt;
      Bundle localBundle = localToServiceMsg.extraData;
      if (this.jdField_d_of_type_JavaUtilHashMap.containsKey(str))
      {
        paramLong = ((Long)this.jdField_d_of_type_JavaUtilHashMap.get(str)).longValue();
        localBundle.putLong("get_list_appoint_time", paramLong);
      }
      try
      {
        localToServiceMsg.extraData.putLong("uin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
        localToServiceMsg.extraData.putLong("troop_uin", Long.parseLong(paramString1));
        localToServiceMsg.extraData.putLong("troop_code", Long.parseLong(paramString2));
        paramLong = System.currentTimeMillis();
        localToServiceMsg.extraData.putLong("troop_time", paramLong);
        localToServiceMsg.extraData.putLong("version", 2L);
        a(localToServiceMsg);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("get_troop_member", 2, "TroopHandler.getTroopMemberList,Thread id:" + Thread.currentThread().getId() + ",threadName:" + Thread.currentThread().getName() + ", troopUin: " + paramString1 + " troopCode: " + paramString2);
        return;
        paramLong = 0L;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("get_troop_member", 2, "FriendListHandler.getTroopMemberList error, NumberFormatException, troopUin: " + paramString1 + " troopCode: " + paramString2);
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    a(103, paramBoolean1, Pair.create(Boolean.valueOf(paramBoolean2), paramString));
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush.");
    }
    Object localObject1 = new submsgtype0x26.MsgBody();
    long l1;
    label322:
    label473:
    do
    {
      do
      {
        for (;;)
        {
          try
          {
            ((submsgtype0x26.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
            if (((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.get() == 4)
            {
              if ((!((submsgtype0x26.MsgBody)localObject1).msg_subcmd_0x4_push_body.has()) && (QLog.isColorLevel())) {
                QLog.e("TroopHandler", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
              }
              localObject2 = (submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)((submsgtype0x26.MsgBody)localObject1).msg_subcmd_0x4_push_body.get();
              if ((((submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)localObject2).msg_app_id.has()) && (((submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)localObject2).msg_app_id.uint64_app_id.has()) && (((submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)localObject2).uint64_group_code.has()) && (((submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)localObject2).sint32_unread_num.has()))
              {
                l1 = ((submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)localObject2).msg_app_id.uint64_app_id.get();
                paramArrayOfByte = ((submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)localObject2).uint64_group_code.get() + "";
                if (l1 != 1105933138L) {
                  break label322;
                }
                localObject2 = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
                if (localObject2 != null)
                {
                  localObject2 = ((HotChatManager)localObject2).a(paramArrayOfByte);
                  if ((localObject2 != null) && (((HotChatInfo)localObject2).isBuLuoHotChat()))
                  {
                    ((HotChatInfo)localObject2).setHasRedPoint();
                    a(90, true, new Object[] { paramArrayOfByte });
                  }
                }
              }
            }
            if ((((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.has()) && (((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.get() == 1)) {
              break label407;
            }
            if (QLog.isDevelopLevel()) {
              QLog.e("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush : msgBody is null or NotSupportSubCMd :" + ((submsgtype0x26.MsgBody)localObject1).uint32_sub_cmd.get());
            }
            return;
          }
          catch (Exception paramArrayOfByte)
          {
            if (!QLog.isDevelopLevel()) {
              continue;
            }
            QLog.e("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush : fail to parse submsgtype0x26.");
            return;
          }
          if ((((submsgtype0x26.MsgBody.SubCmd0x4UpdateApp)localObject2).sint32_unread_num.get() == 0) && (l1 == 1102858908L))
          {
            if (QLog.isColorLevel()) {
              QLog.i(".troop.notify_feeds.data", 2, "handleTroopNewsOnlinePush, deleteFeedInfo, troopUin=" + paramArrayOfByte);
            }
            a(62, true, new Object[] { paramArrayOfByte, Boolean.valueOf(true), Boolean.valueOf(true) });
            continue;
            try
            {
              if (((submsgtype0x26.MsgBody)localObject1).rpt_msg_subcmd_0x1_push_body.has()) {
                break label473;
              }
              if (QLog.isDevelopLevel())
              {
                QLog.i("Q.troopgetnews..troop.notification_center", 4, "rpt_msg_subcmd_0x1_push_body.has() = false");
                return;
              }
            }
            catch (Exception paramArrayOfByte) {}
          }
        }
      } while (!QLog.isDevelopLevel());
      QLog.i("Q.troopgetnews..troop.notification_center", 4, "handleTroopNewsOnlinePush|exception = " + paramArrayOfByte.toString());
      return;
      paramArrayOfByte = ((submsgtype0x26.MsgBody)localObject1).rpt_msg_subcmd_0x1_push_body.get();
      if (paramArrayOfByte != null) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    label407:
    QLog.e("Q.troopgetnews..troop.notification_center", 4, "rpt_msg_subcmd_0x1_push_body is null");
    return;
    Object localObject2 = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramArrayOfByte.iterator();
    paramArrayOfByte = null;
    int i = 0;
    int k = 0;
    label536:
    Object localObject3;
    int m;
    int j;
    while (localIterator.hasNext())
    {
      localObject3 = (submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localIterator.next();
      if (localObject3 == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.e("Q.troopgetnews..troop.notification_center", 4, "unreadNum is null");
        }
      }
      else
      {
        l1 = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).msg_app_id.uint64_app_id.get();
        localObject1 = new TroopUnreadMsgInfo();
        ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long = l1;
        ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).uint64_group_code.get());
        ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).sint32_unread_num.get();
        m = ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int;
        ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Int = ((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).sint32_album_cnt.get();
        if (!((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).msg_app_tip_notify.has()) {
          break label2120;
        }
        paramArrayOfByte = (submsgtype0x26.AppTipNotify)((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).msg_app_tip_notify.get();
        if (!paramArrayOfByte.opt_msg_app_notify_content.has()) {
          break label2120;
        }
        List localList = ((submsgtype0x26.AppNotifyContent)paramArrayOfByte.opt_msg_app_notify_content.get()).opt_msg_app_notify_user.get();
        paramArrayOfByte = new long[localList.size()];
        j = 0;
        for (;;)
        {
          if (j < localList.size())
          {
            paramArrayOfByte[j] = ((submsgtype0x26.AppNotifyUser)localList.get(j)).opt_uint64_uin.get();
            j += 1;
            continue;
            label761:
            if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 2L)
            {
              DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "troop_photo_new", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
              DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "troop_photo_message", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Int);
            }
          }
        }
      }
    }
    for (;;)
    {
      label819:
      if (QLog.isDevelopLevel()) {
        localStringBuilder.append("add photoinfo, groupCode = ").append(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString).append(", appid = ").append(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long).append(", messageNum = ").append(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Int).append(", newPhotoes = ").append(((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
      }
      ((List)localObject2).add(localObject1);
      k += m;
      paramArrayOfByte = (byte[])localObject1;
      break label536;
      if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1L)
      {
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "troop_file_new", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
      }
      else if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1101236949L)
      {
        DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "troop_notification_new", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
      }
      else if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 21L)
      {
        GVideoGrayConfig.a().a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, new zle(this, (TroopUnreadMsgInfo)localObject1, paramArrayOfByte));
      }
      else
      {
        if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 23L)
        {
          if (((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).msg_app_tip_notify.has())
          {
            localObject3 = (submsgtype0x26.AppTipNotify)((submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum)localObject3).msg_app_tip_notify.get();
            if (((submsgtype0x26.AppTipNotify)localObject3).uint32_action.has())
            {
              j = ((submsgtype0x26.AppTipNotify)localObject3).uint32_action.get();
              if (j == 1) {
                l1 = 0L;
              }
            }
          }
          try
          {
            l2 = Long.parseLong(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString);
            l1 = l2;
          }
          catch (NumberFormatException localNumberFormatException)
          {
            for (;;)
            {
              localNumberFormatException.printStackTrace();
            }
          }
          if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
            break label2128;
          }
        }
        label2120:
        label2128:
        for (long l2 = paramArrayOfByte[0];; l2 = 0L)
        {
          push_msg.PushMsg localPushMsg;
          for (;;)
          {
            if ((l1 > 0L) && (l2 > 0L))
            {
              localObject3 = ((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a();
              if (localObject3 != null)
              {
                ((AVNotifyCenter)localObject3).a(8, l1, 2, 20, 1);
                ((AVNotifyCenter)localObject3).a(l1, true);
                ((AVNotifyCenter)localObject3).a(21, 1, l1, 0L);
              }
              VideoMsgTools.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1, 13, false, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, Long.toString(l2), TextUtils.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), String.valueOf(l2)), null, TextUtils.equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), String.valueOf(l2)), 2, new Object[0]);
            }
            ((GroupVideoManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(235)).a(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString);
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int, paramArrayOfByte, 14);
            break;
            if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1104651886L)
            {
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(1, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int, paramArrayOfByte, 10);
              break;
            }
            if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1101484419L)
            {
              DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "group_activity_new_message", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
              break;
            }
            if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1102858908L)
            {
              if ((((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int == -1) || (((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int > 0))
              {
                ChatActivityUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, Integer.valueOf(-1));
                i = 1;
              }
              j = i;
              if (!QLog.isColorLevel()) {
                break label2134;
              }
              QLog.i(".troop.notify_feeds.data", 2, "handleTroopNewsOnlinePush, troopUin=" + ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString + ", nNewNum=" + ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
              break;
            }
            if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1105933138L)
            {
              if (((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int == -1)
              {
                paramArrayOfByte = ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString);
                if ((paramArrayOfByte != null) && (paramArrayOfByte.isBuLuoHotChat()))
                {
                  paramArrayOfByte.setHasRedPoint();
                  a(90, true, new Object[] { ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString });
                }
              }
              j = i;
              if (!QLog.isColorLevel()) {
                break label2134;
              }
              QLog.d("TroopHandlerQ.hotchat.aio_post_red_point", 2, "handleTroopNewsOnlinePush, msgInfo.nNewNum:" + ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
              break;
            }
            if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1106180084L)
            {
              if (QLog.isColorLevel()) {
                QLog.d("TroopEnterEffect", 2, "onLinePush receive 0x210_0x26_cmd0x1, [Enter Troop]");
              }
              j = i;
              if (!localNumberFormatException.msg_app_tip_notify.has()) {
                break label2134;
              }
              paramArrayOfByte = (submsgtype0x26.AppTipNotify)localNumberFormatException.msg_app_tip_notify.get();
              localPushMsg = new push_msg.PushMsg();
              try
              {
                localPushMsg.mergeFrom(paramArrayOfByte.bytes_text.get().toByteArray());
                if (localPushMsg.rc.get() == 0) {
                  a(new TroopEnterEffectController.TroopEnterEffectData(((group_effect.EffectInfo)localPushMsg.effect_info.get()).effect_id.get(), "" + localPushMsg.uin.get(), "" + localPushMsg.group_code.get(), localPushMsg.svip_level.get(), localPushMsg.svip_type.get(), localPushMsg.group_level.get(), localPushMsg.set_mode.get()));
                }
              }
              catch (InvalidProtocolBufferMicroException paramArrayOfByte)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TroopEnterEffect", 2, "onLinePush receive 0x210_0x8ca error: " + QLog.getStackTraceString(paramArrayOfByte));
                  }
                }
              }
            }
          }
          if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1104445552L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("hw_troop", 2, "onLinePush receive 0x210_0x26_cmd0x1 homework.");
            }
            HWTroopUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
            a(61, true, new Object[] { ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, String.valueOf(1104445552), Boolean.valueOf(false) });
            break label819;
          }
          if (((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_Long == 1106611799L)
          {
            DBUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "troop_game_feed", ((TroopUnreadMsgInfo)localObject1).jdField_a_of_type_JavaLangString, ((TroopUnreadMsgInfo)localObject1).jdField_b_of_type_Int);
            break label819;
          }
          j = i;
          if (!TroopHandler.Oidb_0xb36.a(this, (TroopUnreadMsgInfo)localObject1, localPushMsg, 2)) {
            break label2134;
          }
          j = i;
          if (!QLog.isColorLevel()) {
            break label2134;
          }
          QLog.d(".troop.survey", 2, "handleTroopNewsOnlinePush() msginfo handled by Oidb_0xb36");
          j = i;
          break label2134;
          if (QLog.isDevelopLevel()) {
            QLog.i("Q.troopgetnews..troop.notification_center", 4, localStringBuilder.toString());
          }
          if (k != 0) {
            a(30, true, new Object[] { Boolean.valueOf(true), localObject2, Integer.valueOf(-1) });
          }
          while (i != 0)
          {
            a(62, true, new Object[] { paramArrayOfByte.jdField_a_of_type_JavaLangString, Boolean.valueOf(false), Boolean.valueOf(true) });
            return;
            a(30, true, new Object[] { Boolean.valueOf(true), localObject2, Integer.valueOf(0) });
          }
          break;
          paramArrayOfByte = null;
          break label761;
          break label761;
        }
        label2134:
        i = j;
      }
    }
  }
  
  public void a(long[] paramArrayOfLong, long paramLong)
  {
    cmd0x3fe.LevelMsg localLevelMsg = new cmd0x3fe.LevelMsg();
    localLevelMsg.uint32_subcmd.set(6);
    cmd0x3fe.ReqBody localReqBody = new cmd0x3fe.ReqBody();
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = paramArrayOfLong[i];
      cmd0x3fe.UserInfo localUserInfo = new cmd0x3fe.UserInfo();
      localUserInfo.uint64_uin.set(l);
      localReqBody.rpt_msg_user_info.add(localUserInfo);
      i += 1;
    }
    localReqBody.uint64_group_code.set(paramLong);
    localLevelMsg.msg_level_req.set(localReqBody);
    paramArrayOfLong = a("qunVideoOnlineLevel.0x3fe_0");
    paramArrayOfLong.putWupBuffer(localLevelMsg.toByteArray());
    b(paramArrayOfLong);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilSet == null)
    {
      this.jdField_a_of_type_JavaUtilSet = new HashSet();
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x787_0");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetTroopListReqV2");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.getGroupInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetMultiTroopInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.ModifyGroupCardReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.ModifyGroupInfoReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.GetTroopAppointRemarkReq");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getTroopMemberList");
      this.jdField_a_of_type_JavaUtilSet.add("group_member_card.get_group_member_card_info");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a0_0");
      this.jdField_a_of_type_JavaUtilSet.add("friendlist.getTroopRemark");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x899_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x899_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_7");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x89e_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b8_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8c9_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x88d_10");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x903_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x91a_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x91b_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x91c_1");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.ReqBatchProcess");
      this.jdField_a_of_type_JavaUtilSet.add("GroupSvc.JoinGroupLink");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.CheckJsApiToken");
      this.jdField_a_of_type_JavaUtilSet.add("ProfileService.GroupMngReq");
      this.jdField_a_of_type_JavaUtilSet.add("HwSvc.assign_homework");
      this.jdField_a_of_type_JavaUtilSet.add("HwSvc.submit_homework");
      this.jdField_a_of_type_JavaUtilSet.add("HwSvc.get_homework_info");
      this.jdField_a_of_type_JavaUtilSet.add("group_anonymous_generate_nick.group");
      this.jdField_a_of_type_JavaUtilSet.add("qunVideoOnlineLevel.0x3fe_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8bb_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8bb_9");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8bb_7");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8b4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5d6_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8a7_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x8ca_2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x787_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x787_11");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9fa");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x9ab_1");
      this.jdField_a_of_type_JavaUtilSet.add("SHomeworkSvc.querycard");
      this.jdField_a_of_type_JavaUtilSet.add("SHomeworkSvc.modifycard");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.ReadAppList");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.SortAppList");
      this.jdField_a_of_type_JavaUtilSet.add("GroupOpen.ClearRedPoint");
      this.jdField_a_of_type_JavaUtilSet.add(TroopHandler.Oidb_0xb36.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilSet.add("HwSvc.send_msg");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x406_3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xa80_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ba_4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5ba_7");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6b6");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6b5");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6c2");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6c3");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xa8d");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x711_127");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x6d1_3");
      this.jdField_a_of_type_JavaUtilSet.add("NearbyExt.query_user_follow_status");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5eb_96");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x4ff_86");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x5eb_94");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x928");
      this.jdField_a_of_type_JavaUtilSet.add("qunVideoGray.0x3fb_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x987_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xa2a_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xa2a_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xa2a_2");
      this.jdField_a_of_type_JavaUtilSet.add("videohub_group_notify_read.cmd0x2323");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xae6");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xb01");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x42d_4");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xaf6_0");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xaf4_1");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0xb14");
      this.jdField_a_of_type_JavaUtilSet.add("OidbSvc.0x53c_2");
      this.jdField_a_of_type_JavaUtilSet.add("oidbSvc.0x783_15");
    }
    return !this.jdField_a_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString, ArrayList paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getTroopCardDefaultNickBatch uin=" + paramString + " size=" + paramArrayList.size() + " time=" + System.currentTimeMillis());
    }
    short s = (short)paramArrayList.size();
    if (s > 500) {
      return false;
    }
    long l;
    try
    {
      l = Long.parseLong(paramString);
      localObject1 = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(l);
      ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
      localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        try
        {
          l = Long.parseLong(str);
          ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(l));
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "getTroopCardDefaultNickBatch parseLong err uin=" + str, localException);
        }
      }
      localObject2 = new oidb_0x787.Filter();
    }
    catch (Exception paramString)
    {
      return false;
    }
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_uin.set(1);
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_name.set(1);
    ((oidb_0x787.Filter)localObject2).uint32_nick_name.set(1);
    ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
    Object localObject1 = a("OidbSvc.0x787_1");
    if (paramBundle != null)
    {
      int i = paramBundle.getInt(ContactUtils.jdField_a_of_type_JavaLangString, ContactUtils.jdField_a_of_type_Int);
      l = paramBundle.getLong(ContactUtils.jdField_b_of_type_JavaLangString, 0L);
      ((ToServiceMsg)localObject1).extraData.putInt(ContactUtils.jdField_a_of_type_JavaLangString, i);
      ((ToServiceMsg)localObject1).extraData.putLong(ContactUtils.jdField_b_of_type_JavaLangString, l);
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.revoked_msg_get_troop_mem_card", 2, "extraNotifyTarget:" + i + "|uniseq:" + l);
      }
    }
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject1).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject1).extraData.putShort("uincount", s);
    ((ToServiceMsg)localObject1).extraData.putBoolean("needRemark", paramBoolean);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
    return true;
  }
  
  public void b()
  {
    b(null);
  }
  
  public void b(long paramLong)
  {
    a(9, paramLong, 0L, 5, 6, 2);
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    Object localObject1 = new oidb_0x9fa.ReqBody();
    ((oidb_0x9fa.ReqBody)localObject1).uint32_appid.set(1);
    ((oidb_0x9fa.ReqBody)localObject1).uint32_cmdid.set(6);
    ((oidb_0x9fa.ReqBody)localObject1).int32_channel.set(3);
    Object localObject2 = new oidb_0x9fa.GetSimilarGroupWebInfo();
    ((oidb_0x9fa.GetSimilarGroupWebInfo)localObject2).uint64_group_code.set(paramLong1);
    ((oidb_0x9fa.GetSimilarGroupWebInfo)localObject2).uint64_uin.set(paramLong2);
    ((oidb_0x9fa.ReqBody)localObject1).msg_get_web_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2554);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9fa.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x9fa");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(3000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void b(MessageForReplyText paramMessageForReplyText)
  {
    a(2, paramMessageForReplyText);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      for (;;)
      {
        return;
        if (paramFromServiceMsg.getResultCode() != 1000)
        {
          a(92, false, null);
          return;
        }
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0.0F) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
          {
            a(92, false, null);
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          a(92, false, null);
          return;
        }
        paramFromServiceMsg = new cmd0x91a.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          a(92, true, new Object[] { String.valueOf(paramFromServiceMsg.uint64_group_code.get()), Integer.valueOf(paramFromServiceMsg.uint32_result_status.get()), Integer.valueOf(paramFromServiceMsg.uint32_audit_times_max.get()), Integer.valueOf(paramFromServiceMsg.uint32_audit_times_remain.get()), paramFromServiceMsg.group_info.get() });
          boolean bool = QLog.isColorLevel();
          if (bool) {
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          a(92, false, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopHandler", 2, "oidb_91a error : " + paramToServiceMsg.toString());
  }
  
  public void b(Long paramLong)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint64_invite_no_auth_num_limit.set(0L);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(paramLong.longValue());
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", paramLong.longValue());
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 9);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void b(String paramString)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_admin_max_num.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putString("troop_code", paramString);
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 2);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void b(String paramString, int paramInt)
  {
    a(52, true, new Object[] { paramString, Integer.valueOf(paramInt) });
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.set(0);
    Object localObject2 = new oidb_0x88d.GroupExInfoOnly();
    ((oidb_0x88d.GroupExInfoOnly)localObject2).uint32_money_for_add_group.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).st_group_ex_info.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString1));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString1));
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 7);
    ((ToServiceMsg)localObject1).extraData.putString("processName", paramString2);
    ((ToServiceMsg)localObject1).extraData.putBoolean("needUpdatePreferences", false);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void b(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || ("0".equals(paramString2))) {}
    MessageForGrayTips localMessageForGrayTips;
    do
    {
      String str;
      do
      {
        return;
        str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
        localMessageForGrayTips.frienduin = paramString1;
        paramString3 = "修改了群名称为\"" + paramString3 + "\"";
      } while (str.equals(paramString2));
      paramString2 = ContactUtils.g(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2) + paramString3;
      localMessageForGrayTips.init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramString2, NetConnInfoCenter.getServerTime(), -1047, 1, 0L);
      localMessageForGrayTips.setTextGravity(17);
    } while (MessageHandlerUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForGrayTips, false));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForGrayTips, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  public void b(String paramString1, ArrayList paramArrayList, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      cmd0x758.InviteUinInfo localInviteUinInfo;
      ResultRecord localResultRecord;
      try
      {
        localArrayList = new ArrayList();
        i = 0;
        if (i >= paramArrayList.size()) {
          break label181;
        }
        localInviteUinInfo = new cmd0x758.InviteUinInfo();
        localResultRecord = (ResultRecord)paramArrayList.get(i);
        if (localResultRecord.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          break label247;
        }
        localInviteUinInfo.uint64_uin.set(Long.parseLong(localResultRecord.jdField_a_of_type_JavaLangString));
        if (localResultRecord.jdField_a_of_type_Int == 1)
        {
          localInviteUinInfo.uint64_judge_group_code.set(Long.parseLong(localResultRecord.c));
          localArrayList.add(localInviteUinInfo);
        }
      }
      catch (NumberFormatException paramString1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler", 2, "inviteToGroupWithNonFriends NumberFormatException:" + paramString1.toString());
        }
        return;
      }
      if (localResultRecord.jdField_a_of_type_Int == 2)
      {
        localInviteUinInfo.uint64_judge_conf_code.set(Long.parseLong(localResultRecord.c));
        continue;
        label181:
        paramArrayList = new cmd0x758.ReqBody();
        paramArrayList.uint64_join_group_code.set(Long.parseLong(paramString1));
        paramArrayList.string_msg.set(paramString2);
        paramArrayList.be_invited_uin_info.set(localArrayList);
        ProtoUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, new zky(this, paramString1, paramString1), paramArrayList.toByteArray(), "OidbSvc.oidb_0x758", 1880, 1, null);
        return;
        label247:
        i += 1;
      }
    }
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean, "", false);
  }
  
  public void b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
    ToServiceMsg localToServiceMsg = a("friendlist.GetTroopListReqV2");
    localToServiceMsg.setEnableFastResend(true);
    localToServiceMsg.extraData.putByte("bGetMSFMsgFlag", (byte)0);
    localToServiceMsg.extraData.putByte("bGroupFlagExt", (byte)1);
    if (paramArrayOfByte != null)
    {
      this.jdField_b_of_type_Boolean = false;
      localToServiceMsg.extraData.putByteArray("vecCookies", paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.d("Q.getTroopList", 2, "get troop list, cookie != null");
      }
    }
    for (;;)
    {
      a(localToServiceMsg);
      return;
      this.jdField_b_of_type_Boolean = true;
      paramArrayOfByte = new ArrayList();
      Object localObject1 = ((TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a();
      Object localObject2;
      if (localObject1 != null)
      {
        boolean bool = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + "load_trooplist", 0).getBoolean("load_all_3", true);
        int i = 0;
        if (i < ((List)localObject1).size())
        {
          localObject2 = (TroopInfo)((List)localObject1).get(i);
          if (localObject2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            if (((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).b(((TroopInfo)localObject2).troopuin))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.getTroopList", 2, "getTroopList.hotchat troopuin=" + ((TroopInfo)localObject2).troopuin);
              }
            }
            else
            {
              stTroopNum localstTroopNum = new stTroopNum();
              try
              {
                localstTroopNum.GroupCode = Long.parseLong(((TroopInfo)localObject2).troopuin);
                if (!bool)
                {
                  localstTroopNum.dwGroupInfoSeq = ((TroopInfo)localObject2).dwGroupInfoSeq;
                  localstTroopNum.dwGroupRankSeq = ((TroopInfo)localObject2).dwGroupLevelSeq;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("Q.getTroopList", 2, "dwGroupInfoSeq = " + localstTroopNum.dwGroupInfoSeq + ",dwGroupRankSeq = " + localstTroopNum.dwGroupRankSeq);
                }
                localstTroopNum.dwGroupFlagExt = ((TroopInfo)localObject2).dwGroupFlagExt;
                paramArrayOfByte.add(localstTroopNum);
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.getTroopList", 2, "dwGroupRankSeq: " + ((TroopInfo)localObject2).dwGroupLevelSeq);
              }
              catch (NumberFormatException localNumberFormatException) {}
              if (QLog.isColorLevel()) {
                QLog.d("Q.getTroopList", 2, "NumberFormatException,info.troopuin=" + ((TroopInfo)localObject2).troopuin);
              }
            }
          }
        }
      }
      if (!paramArrayOfByte.isEmpty()) {
        localToServiceMsg.extraData.putSerializable("vecGroupInfo", paramArrayOfByte);
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        localObject2 = paramArrayOfByte.iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((StringBuilder)localObject1).append(((stTroopNum)((Iterator)localObject2).next()).GroupCode).append(";");
        }
        QLog.d("Q.getTroopList", 2, "get troop list, cookie == null, request size: " + paramArrayOfByte.size() + " request troop uins: " + ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getTroopConfig, app= null");
      }
      return;
    }
    oidb_0x496.ReqBody localReqBody = new oidb_0x496.ReqBody();
    localReqBody.uint64_update_time.set(0L);
    localReqBody.uint64_first_unread_manager_msg_seq.set(1L);
    int i = BaseApplication.getContext().getSharedPreferences("troop_robot_config", 0).getInt("troop_robot_config_version", 0);
    localReqBody.uint32_version.set(i, true);
    localReqBody.uint32_aio_keyword_version.set(SharedPreUtils.aM(BaseApplicationImpl.getApplication(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "getTroopConfig, type =" + 3);
    }
    localReqBody.uint32_type.set(3, true);
    ProtoUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, new zkw(this), localReqBody.toByteArray(), "OidbSvc.0x496", 1174, 0);
  }
  
  public void c(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.troopgetnews.", 2, "send_oidb_0xf110_1 troopCode = " + paramLong);
    }
    Object localObject1 = (TroopAppMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(108);
    if ((localObject1 != null) && (((TroopAppMgr)localObject1).a(1104445552, 0) != null)) {
      return;
    }
    Object localObject2 = new oidb_0x9ab.ReqBody();
    ((oidb_0x9ab.ReqBody)localObject2).uint64_group_code.set(paramLong);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2475);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x9ab.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x9ab_1");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  public void c(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler", 2, "sendPbRequest. request is null.");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "sendPbRequest. cmd=" + paramToServiceMsg.getServiceCmd());
    }
    super.b(paramToServiceMsg);
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp:");
    }
    int i = paramToServiceMsg.extraData.getInt("appid");
    String str1 = paramToServiceMsg.extraData.getString("openId");
    String str2 = paramToServiceMsg.extraData.getString("token");
    int j = paramToServiceMsg.extraData.getInt("seq");
    if (!paramFromServiceMsg.isSuccess())
    {
      a(84, false, new Object[] { Integer.valueOf(i), str1, str2, "", Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()), null });
      return;
    }
    for (paramToServiceMsg = new oidb_sso.OIDBSSOPkg();; paramToServiceMsg = new ProfileActivity.AllInOne(paramObject, 78)) {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        int k = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp, resultCode:" + k);
        }
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        if (k != 0) {
          break;
        }
        paramObject = new byte[4];
        System.arraycopy(paramToServiceMsg, 0, paramObject, 0, 4);
        paramObject = ByteBuffer.wrap(paramObject).getInt() + "";
        Friends localFriends = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).c(paramObject);
        if ((localFriends != null) && (localFriends.isFriend()))
        {
          paramToServiceMsg = new ProfileActivity.AllInOne(paramObject, 1);
          paramToServiceMsg.h = localFriends.name;
          paramToServiceMsg.i = localFriends.remark;
          a(84, true, new Object[] { Integer.valueOf(i), str1, str2, paramObject, Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()), paramToServiceMsg });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("TroopHandler.troopTAG_GET_UIN_BY_OPEN_ID", 2, "handleOidb0x711_21Rsp, uin:" + paramObject);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e(".troopTAG_GET_UIN_BY_OPEN_ID", 2, "pkg.mergeFrom:" + paramToServiceMsg.toString());
        }
        a(84, false, new Object[] { Integer.valueOf(i), str1, str2, "", Integer.valueOf(j), Integer.valueOf(paramFromServiceMsg.getResultCode()), null });
        return;
      }
    }
  }
  
  public void c(String paramString)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).string_group_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_name.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_face.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_flag_ext.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_type_flag.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).string_certification_text.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).string_group_rich_finger_memo.set(ByteStringMicro.EMPTY);
    ((oidb_0x88d.GroupInfo)localObject2).uint64_group_owner.set(0L);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_group_class_ext.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(10);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_10");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    b((ToServiceMsg)localObject2);
  }
  
  public void c(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          l2 = Long.parseLong(paramString2);
          if ((l1 != 0L) && (l2 != 0L)) {
            break;
          }
          if (QLog.isDevelopLevel()) {
            QLog.d("TroopHandler", 4, "batchAddFriendSecurityCheck invalid param!");
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          long l1;
          long l2;
          Object localObject;
          break label50;
        }
        localThrowable1 = localThrowable1;
        l1 = 0L;
      }
      label50:
      l2 = 0L;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopHandler", 4, String.format(Locale.getDefault(), "batchAddFriendSecurityCheck troopUin: %s", new Object[] { Long.valueOf(l2) }));
    }
    localObject = new cmd0xb01.ReqBody();
    ((cmd0xb01.ReqBody)localObject).uint64_uin.set(l1);
    ((cmd0xb01.ReqBody)localObject).uint64_group_uin.set(l2);
    localObject = a("OidbSvc.0xb01", 2817, 1, ((cmd0xb01.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString1);
    ((ToServiceMsg)localObject).extraData.putString("troopCode", paramString2);
    b((ToServiceMsg)localObject);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!NetworkUtil.d(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelSwitchAndMap net disabble, return:" + paramString);
        }
        return;
      }
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString)) {
        break label404;
      }
    }
    label404:
    for (long l = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();; l = 0L)
    {
      if (System.currentTimeMillis() - l < 30000L)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelSwitchAndMap: lastReq < 30s, return:" + paramString);
        return;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
      Object localObject2 = new oidb_0x787.Filter();
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_uin.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_point.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_active_day.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_level.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_level_name.set(1);
      ((oidb_0x787.Filter)localObject2).uint32_data_time.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_sys_show_flag.set(0);
      ((oidb_0x787.Filter)localObject2).uint32_user_show_flag.set(0);
      Object localObject1 = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
      ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
      ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x787_0");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.getTroopMemberLevelInfo", 2, "getTroopLevelSwitchAndMap: troopCode=" + paramString + ", isForceReq=" + paramBoolean);
      return;
    }
  }
  
  public void d()
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_invite2group_auto_agree_flag.set(1);
    localObject = a("OidbSvc.0x5eb_94", 1515, 94, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("OidbSvc.0x5eb_94", true);
    b((ToServiceMsg)localObject);
  }
  
  public void d(long paramLong)
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Long.valueOf(paramLong));
    ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.set(localArrayList);
    ((oidb_0x5eb.ReqBody)localObject).uint32_req_global_group_level.set(1);
    localObject = a("OidbSvc.0x5eb_96", 1515, 96, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("OidbSvc.0x5eb_96", true);
    b((ToServiceMsg)localObject);
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : data==null");
      }
      a(76, false, null);
    }
    do
    {
      for (;;)
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("TroopHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : resp.isSuccess=" + paramFromServiceMsg.isSuccess());
        }
        if (!paramFromServiceMsg.isSuccess())
        {
          a(76, false, null);
          return;
        }
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramToServiceMsg = paramFromServiceMsg;
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          for (;;)
          {
            int i;
            int j;
            if (QLog.isColorLevel()) {
              QLog.d("Q.troopdisband.", 2, "handleTroopFeeMemberListQuery|oidb_sso parseFrom byte " + paramFromServiceMsg.toString());
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            a(76, false, null);
          }
          a(76, false, null);
        }
        i = -1;
        if (paramToServiceMsg != null)
        {
          j = paramToServiceMsg.uint32_result.get();
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.troopdisband.", 2, "handleTroopFeeMemberListQuery|oidb_sso.OIDBSSOPkg.result " + j);
            i = j;
          }
        }
        if (i != 0) {
          break label364;
        }
        paramFromServiceMsg = new cmd0x406.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i = paramFromServiceMsg.uint32_ret.get();
          if (i != 0) {
            break label353;
          }
          a(76, true, ((cmd0x406.GroupFeeMemberListResult)paramFromServiceMsg.msg_member_list.get()).msg_member_list.get());
          if (QLog.isColorLevel())
          {
            QLog.d("TroopHandler.troop.troop_fee", 2, "ret :" + i + ",msg:" + paramFromServiceMsg.string_msg.get().toString());
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          a(76, false, null);
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("TroopHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : InvalidProtocolBufferMicroException");
    return;
    label353:
    label364:
    return;
  }
  
  public void d(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.set(0);
    Object localObject2 = new oidb_0x88d.GroupHeadPortrait();
    ((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    try
    {
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
      localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x88d_7");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void d(String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    Object localObject = "del_" + paramString1 + "_" + paramString2;
    if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey(localObject)) && (l - ((Long)this.jdField_b_of_type_JavaUtilHashMap.get(localObject)).longValue() < 2000L)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(localObject, Long.valueOf(l));
    localObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    TroopInfo localTroopInfo = ((TroopManager)localObject).b(paramString1);
    if ((localTroopInfo != null) && (!localTroopInfo.hasSetTroopHead()))
    {
      ArrayList localArrayList = ((TroopManager)localObject).a(paramString1);
      if (localArrayList.contains(paramString2))
      {
        localArrayList.remove(paramString2);
        localTroopInfo.mHeaderUinsNew = GroupIconHelper.a(localArrayList, false);
      }
    }
    try
    {
      b(Long.parseLong(paramString1));
      if ((localTroopInfo != null) && (localTroopInfo.isNewTroop()))
      {
        localTroopInfo.wMemberNumClient -= 1;
        ((TroopManager)localObject).b(localTroopInfo);
      }
      TroopNameHelper.a(paramString1);
      a(104, true, null);
      return;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        QLog.e("TroopHandler", 2, "send 0x899 for Head failed! troopUin = " + paramString1, paramString2);
      }
    }
  }
  
  public void d(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("troop.credit.data", 2, "th->getTroopCreditLevel:" + paramString + ", " + paramBoolean);
    }
    try
    {
      long l = Long.parseLong(paramString);
      ToServiceMsg localToServiceMsg = a("ProfileService.ReqBatchProcess");
      localToServiceMsg.extraData.putLong("troop_code", l);
      localToServiceMsg.extraData.putBoolean("param_get_credit_info", true);
      localToServiceMsg.extraData.putBoolean("is_admin", paramBoolean);
      a(localToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.data", 2, "th->getTroopCreditLevel->sendReq:" + paramString);
      }
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.i("troop.credit.data", 2, "th->getTroopCreditLevel:" + paramString.toString());
      }
      a(33, false, null);
    }
  }
  
  public void e(long paramLong)
  {
    try
    {
      String str = AppSetting.c();
      Object localObject = new oidb_0x928.ReqBody();
      ((oidb_0x928.ReqBody)localObject).group_id.set(paramLong);
      ((oidb_0x928.ReqBody)localObject).platform.set(2);
      ((oidb_0x928.ReqBody)localObject).version.set(str);
      localObject = a("OidbSvc.0x928", 2344, 0, ((oidb_0x928.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putLong("troopUin", paramLong);
      b((ToServiceMsg)localObject);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.notify_feeds.data", 2, "getTroopAioNotifyFeeds, troopUin=" + paramLong + ", version=" + str);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(".troop.notify_feeds.data", 2, "getTroopAioNotifyFeeds, exp:", localException);
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : data==null");
      }
      a(50, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("get_troop_member", 2, "handleGetTroopMemberCard : resp.isSuccess=" + paramFromServiceMsg.isSuccess());
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      a(50, false, null);
      return;
    }
    Object localObject1 = new group_member_info.RspBody();
    long l1;
    int k;
    int i;
    int j;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        ((group_member_info.RspBody)localObject1).mergeFrom((byte[])paramObject);
        l1 = ((group_member_info.RspBody)localObject1).uint64_group_code.get();
        k = ((group_member_info.RspBody)localObject1).uint32_self_role.get();
        paramFromServiceMsg = new TroopMemberCard();
        paramFromServiceMsg.result = -1;
        if (((group_member_info.RspBody)localObject1).uint32_group_type.has()) {
          paramFromServiceMsg.mGroupType = ((group_member_info.RspBody)localObject1).uint32_group_type.get();
        }
        if (!((group_member_info.RspBody)localObject1).msg_meminfo.has()) {
          break label2221;
        }
        paramObject = (group_member_info.MemberInfo)((group_member_info.RspBody)localObject1).msg_meminfo.get();
        paramFromServiceMsg.result = paramObject.uint32_result.get();
        paramFromServiceMsg.isAllowModCard = paramObject.bool_is_allow_mod_card.get();
        paramFromServiceMsg.memberUin = paramObject.uint64_uin.get();
        paramFromServiceMsg.isFriend = paramObject.bool_is_friend.get();
        paramFromServiceMsg.credit = paramObject.uint32_credit.get();
        if (!paramObject.uint32_concern_type.has()) {
          break label1003;
        }
        i = paramObject.uint32_concern_type.get();
        if (i == 0)
        {
          paramFromServiceMsg.isConcerned = false;
          paramFromServiceMsg.mIsShield = false;
          paramFromServiceMsg.sex = -1;
          if (paramObject.uint32_sex.has()) {
            paramFromServiceMsg.sex = paramObject.uint32_sex.get();
          }
          paramFromServiceMsg.location = "";
          if (paramObject.str_location.has()) {
            paramFromServiceMsg.location = paramObject.str_location.get().toStringUtf8();
          }
          paramFromServiceMsg.age = paramObject.uint32_age.get();
          paramFromServiceMsg.nick = "";
          paramFromServiceMsg.remark = "";
          paramFromServiceMsg.card = "";
          if (paramObject.str_nick.has()) {
            paramFromServiceMsg.nick = paramObject.str_nick.get().toStringUtf8();
          }
          if (paramObject.str_remark.has()) {
            paramFromServiceMsg.remark = paramObject.str_remark.get().toStringUtf8();
          }
          if (paramObject.str_card.has()) {
            paramFromServiceMsg.card = paramObject.str_card.get().toStringUtf8();
          }
          paramFromServiceMsg.levelName = paramObject.str_lev.get().toStringUtf8();
          if ((paramObject.medal_id.has()) && (paramObject.medal_id.get() > 0)) {
            paramFromServiceMsg.titleId = paramObject.medal_id.get();
          }
          if (paramObject.uint32_level.has()) {
            paramFromServiceMsg.realLevel = paramObject.uint32_level.get();
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopRankConfig", 2, "handleGetTroopMemberCard, troopUin=" + l1 + ", memberUin=" + paramFromServiceMsg.memberUin + ", titleId=" + paramFromServiceMsg.titleId);
          }
          paramFromServiceMsg.memberRole = -1;
          if (paramObject.uint32_role.has()) {
            paramFromServiceMsg.memberRole = paramObject.uint32_role.get();
          }
          paramFromServiceMsg.joinTime = paramObject.uint64_join.get();
          paramFromServiceMsg.lastSpeak = paramObject.uint64_last_speak.get();
          paramFromServiceMsg.isVip = paramObject.bool_is_vip.get();
          paramFromServiceMsg.isYearVip = paramObject.bool_is_year_vip.get();
          paramFromServiceMsg.isSuperVip = paramObject.bool_is_super_vip.get();
          paramFromServiceMsg.isSuperQQ = paramObject.bool_is_super_qq.get();
          paramFromServiceMsg.vipLevel = paramObject.uint32_vip_lev.get();
          paramFromServiceMsg.gbarTitle = paramObject.str_gbar_title.get().toStringUtf8();
          paramFromServiceMsg.gbarLinkUrl = paramObject.str_gbar_url.get().toStringUtf8();
          paramFromServiceMsg.gbarCount = paramObject.uint32_gbar_cnt.get();
          paramFromServiceMsg.gbarList = new ArrayList();
          if ((paramObject.uint32_special_title_expire_time.has()) && ((paramObject.uint32_special_title_expire_time.get() == -1) || (paramObject.uint32_special_title_expire_time.get() - NetConnInfoCenter.getServerTime() > 0L)))
          {
            if (paramObject.bytes_special_title.has()) {
              paramFromServiceMsg.mUniqueTitle = paramObject.bytes_special_title.get().toStringUtf8();
            }
            paramFromServiceMsg.mUniqueTitleExpire = paramObject.uint32_special_title_expire_time.get();
          }
          localObject1 = paramObject.rpt_msg_gbar_concerned.get();
          if (localObject1 == null) {
            break label2295;
          }
          i = ((List)localObject1).size();
          break label2289;
          if (j >= i) {
            break;
          }
          localObject2 = (group_member_info.GBarInfo)((List)localObject1).get(j);
          localObject3 = new TroopMemberCard.GBarInfo();
          ((TroopMemberCard.GBarInfo)localObject3).gbarId = ((group_member_info.GBarInfo)localObject2).uint32_gbar_id.get();
          ((TroopMemberCard.GBarInfo)localObject3).level = ((group_member_info.GBarInfo)localObject2).uint32_uin_lev.get();
          ((TroopMemberCard.GBarInfo)localObject3).headUrl = ((group_member_info.GBarInfo)localObject2).str_head_portrait.get().toStringUtf8();
          ((TroopMemberCard.GBarInfo)localObject3).name = ((group_member_info.GBarInfo)localObject2).bytes_gbar_name.get().toStringUtf8();
          paramFromServiceMsg.gbarList.add(localObject3);
          j += 1;
          continue;
        }
        if (i == 1)
        {
          paramFromServiceMsg.isConcerned = true;
          paramFromServiceMsg.mIsShield = false;
          continue;
        }
        if (i != 2) {
          continue;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("get_troop_member", 2, "onReceive: handleGetTroopMemberCard mergeFrom:" + paramToServiceMsg.toString());
        }
        a(50, false, null);
        return;
      }
      paramFromServiceMsg.isConcerned = false;
      paramFromServiceMsg.mIsShield = true;
      continue;
      label1003:
      paramFromServiceMsg.isConcerned = paramObject.bool_is_concerned.get();
    }
    paramFromServiceMsg.customEntryList = new ArrayList();
    localObject1 = paramObject.rpt_msg_custom_enties.get();
    if (localObject1 != null)
    {
      i = ((List)localObject1).size();
      break label2301;
      while (j < i)
      {
        localObject2 = (group_member_info.CustomEntry)((List)localObject1).get(j);
        localObject3 = new TroopMemberCard.CustomEntry();
        ((TroopMemberCard.CustomEntry)localObject3).label = ((group_member_info.CustomEntry)localObject2).str_name.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject3).info = ((group_member_info.CustomEntry)localObject2).str_value.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject3).linkUrl = ((group_member_info.CustomEntry)localObject2).str_url.get().toStringUtf8();
        ((TroopMemberCard.CustomEntry)localObject3).isClickable = ((group_member_info.CustomEntry)localObject2).bool_clicked.get();
        ((TroopMemberCard.CustomEntry)localObject3).reportId = ((group_member_info.CustomEntry)localObject2).uint64_report_id.get();
        paramFromServiceMsg.customEntryList.add(localObject3);
        j += 1;
      }
      if ((paramObject.bool_location_shared.has()) && (paramObject.bool_location_shared.get() == true) && (paramObject.uint64_distance.has())) {
        paramFromServiceMsg.distance = paramObject.uint64_distance.get();
      }
      long l2;
      for (;;)
      {
        if (paramObject.bytes_phone_num.has()) {
          paramFromServiceMsg.phoneNumber = paramObject.bytes_phone_num.get().toStringUtf8();
        }
        if (!paramObject.msg_team_entry.has()) {
          break label1511;
        }
        paramFromServiceMsg.mOrgIds.clear();
        localObject1 = ((group_member_info.TeamEntry)paramObject.msg_team_entry.get()).rpt_uint64_depid.get().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          l2 = ((Long)((Iterator)localObject1).next()).longValue();
          localObject2 = "" + l1 + l2;
          if (!paramFromServiceMsg.mOrgIds.contains(localObject2)) {
            paramFromServiceMsg.mOrgIds.add(localObject2);
          }
        }
        if ((paramObject.bool_location_shared.has()) && (!paramObject.bool_location_shared.get())) {
          paramFromServiceMsg.distance = -1001L;
        } else {
          paramFromServiceMsg.distance = -100L;
        }
      }
      paramFromServiceMsg.mCurrAccountOrgIds.clear();
      localObject1 = ((group_member_info.TeamEntry)paramObject.msg_team_entry.get()).rpt_uint64_self_depid.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        l2 = ((Long)((Iterator)localObject1).next()).longValue();
        localObject2 = "" + l1 + l2;
        if (!paramFromServiceMsg.mCurrAccountOrgIds.contains(localObject2)) {
          paramFromServiceMsg.mCurrAccountOrgIds.add(localObject2);
        }
      }
      label1511:
      if (paramObject.bytes_job.has()) {
        paramFromServiceMsg.mPosition = paramObject.bytes_job.get().toStringUtf8();
      }
      if (paramObject.qqstory_infocard.has())
      {
        localObject1 = (group_member_info.RspGroupCardGetStory)paramObject.qqstory_infocard.get();
        if (((group_member_info.RspGroupCardGetStory)localObject1).flag.has()) {
          if (((group_member_info.RspGroupCardGetStory)localObject1).flag.get() != 1) {
            break label2322;
          }
        }
      }
    }
    label2322:
    for (boolean bool = true;; bool = false)
    {
      paramFromServiceMsg.mHasStory = bool;
      if (((group_member_info.RspGroupCardGetStory)localObject1).video_info.has())
      {
        localObject1 = ((group_member_info.RspGroupCardGetStory)localObject1).video_info.get();
        if (((List)localObject1).size() > 0)
        {
          paramFromServiceMsg.mStoryInfoList = new ArrayList();
          i = 0;
        }
      }
      for (;;)
      {
        if (i < ((List)localObject1).size())
        {
          localObject2 = (group_member_info.InfoCardVideoInfo)((List)localObject1).get(i);
          if (((group_member_info.InfoCardVideoInfo)localObject2).cover.has())
          {
            localObject3 = new TroopMemberCard.StoryInfo();
            ((TroopMemberCard.StoryInfo)localObject3).mCoverUrl = ((group_member_info.InfoCardVideoInfo)localObject2).cover.get().toStringUtf8();
            paramFromServiceMsg.mStoryInfoList.add(localObject3);
          }
        }
        else
        {
          if (paramObject.msg_game_info.has())
          {
            localObject1 = (group_member_info.MemberGameInfo)paramObject.msg_game_info.get();
            paramObject = new TroopMemberCard.MemberGameInfo();
            paramObject.gameName = ((group_member_info.MemberGameInfo)localObject1).str_game_name.get();
            paramObject.levelName = ((group_member_info.MemberGameInfo)localObject1).str_level_name.get();
            paramObject.levelIcon = ((group_member_info.MemberGameInfo)localObject1).str_level_icon.get();
            paramObject.gameFontColor = ((group_member_info.MemberGameInfo)localObject1).str_game_font_color.get();
            paramObject.gameBackGroundColor = ((group_member_info.MemberGameInfo)localObject1).str_game_background_color.get();
            paramObject.gameUrl = ((group_member_info.MemberGameInfo)localObject1).str_game_url.get();
            localObject1 = ((group_member_info.MemberGameInfo)localObject1).str_desc_info.get();
            paramObject.descInfo = new ArrayList();
            if ((localObject1 != null) && (((List)localObject1).size() > 0))
            {
              paramObject.descInfo.addAll((Collection)localObject1);
              if (QLog.isColorLevel()) {
                QLog.d("get_troop_member", 2, new Object[] { "desc=", ((List)localObject1).get(0) });
              }
            }
            paramFromServiceMsg.mMemberGameInfo = paramObject;
            if (QLog.isColorLevel()) {
              QLog.d("get_troop_member", 2, new Object[] { "gameInfo, gameName=", paramObject.gameName, ", levelName=", paramObject.levelName, ", gameUrl=", paramObject.gameUrl, ", levelIcon=", paramObject.levelIcon, ", gameFontColor=", paramObject.gameFontColor, ", gameBackGroundColor=", paramObject.gameBackGroundColor });
            }
          }
          for (;;)
          {
            paramObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
            if (paramObject != null)
            {
              i = -100;
              if (paramFromServiceMsg.titleId > 0) {
                i = paramFromServiceMsg.titleId;
              }
              if (paramFromServiceMsg.mUniqueTitle == null) {
                paramFromServiceMsg.mUniqueTitle = "";
              }
              localObject1 = String.valueOf(paramFromServiceMsg.memberUin);
              localObject2 = paramObject.b(String.valueOf(l1));
              if ((paramFromServiceMsg.memberRole == 3) && (localObject2 != null) && (paramFromServiceMsg.memberUin != 0L) && (!((String)localObject1).equals(((TroopInfo)localObject2).troopowneruin)))
              {
                if (QLog.isColorLevel()) {
                  QLog.d("get_troop_member", 2, "handleGetTroopMemberCard change troopOwner:" + l1 + ", oldOwner=" + ((TroopInfo)localObject2).troopowneruin + ", newOwner=" + (String)localObject1);
                }
                ((TroopInfo)localObject2).troopowneruin = ((String)localObject1);
                paramObject.b((TroopInfo)localObject2);
              }
              paramObject.a(String.valueOf(l1), (String)localObject1, paramFromServiceMsg.card, i, paramFromServiceMsg.nick, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D, paramFromServiceMsg.mUniqueTitle, paramFromServiceMsg.realLevel);
            }
            label2221:
            a(50, true, new Object[] { Long.valueOf(l1), Integer.valueOf(k), paramFromServiceMsg, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("once", false)) });
            return;
            if (QLog.isColorLevel()) {
              QLog.d("get_troop_member", 2, "has no game info");
            }
          }
          for (;;)
          {
            label2289:
            j = 0;
            break;
            label2295:
            i = 0;
          }
          for (;;)
          {
            label2301:
            j = 0;
            break;
            i = 0;
          }
        }
        i += 1;
      }
    }
  }
  
  public void e(String paramString)
  {
    c(paramString, true);
  }
  
  public void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, new Object[] { "getHomeworkTroopIdentity. troopUin = ", paramString1, ", uin = ", paramString2 });
    }
    try
    {
      oidb_0xb14.ReqBody localReqBody = new oidb_0xb14.ReqBody();
      localReqBody.type.set(1);
      localReqBody.group_id.set(Long.parseLong(paramString1));
      localReqBody.uins.set(Collections.singletonList(Long.valueOf(Long.parseLong(paramString2))));
      b(a("OidbSvc.0xb14", 2836, 0, localReqBody.toByteArray()));
      return;
    }
    catch (NumberFormatException paramString1) {}
  }
  
  public void e(String paramString, boolean paramBoolean)
  {
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_app_privilege_flag.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 6);
    ((ToServiceMsg)localObject2).extraData.putBoolean("needUpdatePreferences", paramBoolean);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  /* Error */
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 2226
    //   7: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   10: lstore 9
    //   12: aload_2
    //   13: invokevirtual 453	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: istore 11
    //   18: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +42 -> 63
    //   24: ldc_w 6034
    //   27: iconst_2
    //   28: new 166	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 6486
    //   38: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: lload 9
    //   43: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: ldc_w 3005
    //   49: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload 11
    //   54: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: lload 9
    //   65: lconst_0
    //   66: lcmp
    //   67: ifne +16 -> 83
    //   70: aload_0
    //   71: bipush 66
    //   73: iconst_0
    //   74: lload 9
    //   76: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   79: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   82: return
    //   83: iload 11
    //   85: ifne +16 -> 101
    //   88: aload_0
    //   89: bipush 66
    //   91: iconst_0
    //   92: lload 9
    //   94: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   97: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   100: return
    //   101: aload_3
    //   102: checkcast 3007	KQQ/RespBatchProcess
    //   105: astore 12
    //   107: aload 12
    //   109: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   112: ifnull +14 -> 126
    //   115: aload 12
    //   117: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   120: invokevirtual 1172	java/util/ArrayList:size	()I
    //   123: ifne +32 -> 155
    //   126: aload_0
    //   127: bipush 66
    //   129: iconst_0
    //   130: lload 9
    //   132: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   135: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   138: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   141: ifeq -59 -> 82
    //   144: ldc_w 6034
    //   147: iconst_2
    //   148: ldc_w 6488
    //   151: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: return
    //   155: aload_0
    //   156: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   159: bipush 51
    //   161: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   164: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   167: astore 13
    //   169: aload 13
    //   171: ifnull +641 -> 812
    //   174: aload 13
    //   176: new 166	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   183: lload 9
    //   185: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: ldc_w 368
    //   191: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   200: astore_2
    //   201: aload_2
    //   202: ifnonnull +32 -> 234
    //   205: aload_0
    //   206: bipush 66
    //   208: iconst_0
    //   209: lload 9
    //   211: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   214: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   217: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq -138 -> 82
    //   223: ldc_w 6034
    //   226: iconst_2
    //   227: ldc_w 6490
    //   230: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: return
    //   234: aload 12
    //   236: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   239: invokevirtual 1172	java/util/ArrayList:size	()I
    //   242: istore 7
    //   244: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   247: ifeq +31 -> 278
    //   250: ldc_w 6034
    //   253: iconst_2
    //   254: new 166	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   261: ldc_w 6492
    //   264: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: iload 7
    //   269: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iconst_0
    //   279: istore 4
    //   281: iload 4
    //   283: iload 7
    //   285: if_icmpge +480 -> 765
    //   288: aload 12
    //   290: getfield 3010	KQQ/RespBatchProcess:batch_response_list	Ljava/util/ArrayList;
    //   293: iload 4
    //   295: invokevirtual 1585	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   298: checkcast 3012	KQQ/BatchResponse
    //   301: astore_1
    //   302: aload_1
    //   303: ifnull +10 -> 313
    //   306: aload_1
    //   307: getfield 3013	KQQ/BatchResponse:result	I
    //   310: ifeq +12 -> 322
    //   313: iload 4
    //   315: iconst_1
    //   316: iadd
    //   317: istore 4
    //   319: goto -38 -> 281
    //   322: aload_1
    //   323: getfield 3015	KQQ/BatchResponse:type	I
    //   326: iconst_1
    //   327: if_icmpne -14 -> 313
    //   330: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   333: dup
    //   334: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   337: astore_3
    //   338: aload_3
    //   339: aload_1
    //   340: getfield 3018	KQQ/BatchResponse:buffer	[B
    //   343: checkcast 151	[B
    //   346: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   349: pop
    //   350: aload_1
    //   351: getfield 3020	KQQ/BatchResponse:seq	I
    //   354: ifne -41 -> 313
    //   357: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +13 -> 373
    //   363: ldc_w 6034
    //   366: iconst_2
    //   367: ldc_w 6494
    //   370: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload_3
    //   374: ifnull -61 -> 313
    //   377: aload_3
    //   378: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   381: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   384: ifeq -71 -> 313
    //   387: aload_3
    //   388: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   391: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   394: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   397: astore_1
    //   398: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   401: dup
    //   402: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   405: astore_3
    //   406: aload_3
    //   407: aload_1
    //   408: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   411: pop
    //   412: aconst_null
    //   413: astore_1
    //   414: aload_3
    //   415: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   418: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   421: astore 14
    //   423: aload 14
    //   425: ifnonnull +84 -> 509
    //   428: iconst_0
    //   429: istore 5
    //   431: goto +386 -> 817
    //   434: aload_1
    //   435: ifnonnull -122 -> 313
    //   438: iload 6
    //   440: iload 5
    //   442: if_icmpge -129 -> 313
    //   445: aload 14
    //   447: iload 6
    //   449: invokeinterface 638 2 0
    //   454: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   457: astore_3
    //   458: aload_3
    //   459: ifnonnull +62 -> 521
    //   462: iload 6
    //   464: iconst_1
    //   465: iadd
    //   466: istore 6
    //   468: goto -34 -> 434
    //   471: astore_1
    //   472: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   475: ifeq -393 -> 82
    //   478: ldc_w 6034
    //   481: iconst_2
    //   482: new 166	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 6486
    //   492: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_1
    //   496: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   499: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: return
    //   509: aload 14
    //   511: invokeinterface 565 1 0
    //   516: istore 5
    //   518: goto +299 -> 817
    //   521: aload_3
    //   522: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   525: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   528: istore 8
    //   530: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   533: ifeq +290 -> 823
    //   536: ldc_w 6034
    //   539: iconst_2
    //   540: new 166	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   547: ldc_w 6496
    //   550: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: iload 8
    //   555: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   558: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   564: goto +259 -> 823
    //   567: iload 8
    //   569: ifne +240 -> 809
    //   572: aload_3
    //   573: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   576: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   579: ifeq +230 -> 809
    //   582: aload_3
    //   583: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   586: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   589: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   592: astore_3
    //   593: aload_3
    //   594: astore_1
    //   595: aload_3
    //   596: ifnull -134 -> 462
    //   599: aload_3
    //   600: getfield 6499	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   603: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   606: ifeq +15 -> 621
    //   609: aload_2
    //   610: aload_3
    //   611: getfield 6499	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   614: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   617: i2l
    //   618: putfield 1747	com/tencent/mobileqq/data/TroopInfo:troopCreditLevel	J
    //   621: aload_3
    //   622: getfield 6502	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level_info	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   625: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   628: ifeq +15 -> 643
    //   631: aload_2
    //   632: aload_3
    //   633: getfield 6502	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_sec_level_info	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   636: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   639: i2l
    //   640: putfield 1753	com/tencent/mobileqq/data/TroopInfo:troopCreditLevelInfo	J
    //   643: aload_3
    //   644: astore_1
    //   645: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq -186 -> 462
    //   651: ldc_w 6034
    //   654: iconst_2
    //   655: new 166	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 6504
    //   665: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_2
    //   669: getfield 1191	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   672: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: ldc_w 3005
    //   678: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload_2
    //   682: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   685: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: ldc_w 3005
    //   691: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   694: aload_2
    //   695: getfield 1747	com/tencent/mobileqq/data/TroopInfo:troopCreditLevel	J
    //   698: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   701: ldc_w 3005
    //   704: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: aload_2
    //   708: getfield 1753	com/tencent/mobileqq/data/TroopInfo:troopCreditLevelInfo	J
    //   711: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   714: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   717: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   720: aload_3
    //   721: astore_1
    //   722: goto -260 -> 462
    //   725: astore_1
    //   726: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq -416 -> 313
    //   732: ldc_w 6034
    //   735: iconst_2
    //   736: new 166	java/lang/StringBuilder
    //   739: dup
    //   740: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   743: ldc_w 6506
    //   746: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_1
    //   750: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   753: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   756: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 186	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: goto -449 -> 313
    //   765: aload 13
    //   767: ifnull +29 -> 796
    //   770: aload_2
    //   771: ifnull +25 -> 796
    //   774: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +13 -> 790
    //   780: ldc_w 6034
    //   783: iconst_2
    //   784: ldc_w 6508
    //   787: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   790: aload 13
    //   792: aload_2
    //   793: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   796: aload_0
    //   797: bipush 66
    //   799: iconst_1
    //   800: lload 9
    //   802: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   805: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   808: return
    //   809: goto -347 -> 462
    //   812: aconst_null
    //   813: astore_2
    //   814: goto -613 -> 201
    //   817: iconst_0
    //   818: istore 6
    //   820: goto -386 -> 434
    //   823: iload 8
    //   825: bipush 72
    //   827: if_icmpne -260 -> 567
    //   830: iload 6
    //   832: ifne -265 -> 567
    //   835: goto -373 -> 462
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	838	0	this	TroopHandler
    //   0	838	1	paramToServiceMsg	ToServiceMsg
    //   0	838	2	paramFromServiceMsg	FromServiceMsg
    //   0	838	3	paramObject	Object
    //   279	39	4	i	int
    //   429	88	5	j	int
    //   438	393	6	k	int
    //   242	44	7	m	int
    //   528	300	8	n	int
    //   10	791	9	l	long
    //   16	68	11	bool	boolean
    //   105	184	12	localRespBatchProcess	RespBatchProcess
    //   167	624	13	localTroopManager	TroopManager
    //   421	89	14	localList	List
    // Exception table:
    //   from	to	target	type
    //   338	350	471	java/lang/Exception
    //   398	412	725	java/lang/Exception
    //   414	423	725	java/lang/Exception
    //   445	458	725	java/lang/Exception
    //   509	518	725	java/lang/Exception
    //   521	564	725	java/lang/Exception
    //   572	593	725	java/lang/Exception
    //   599	621	725	java/lang/Exception
    //   621	643	725	java/lang/Exception
    //   645	720	725	java/lang/Exception
  }
  
  public void f(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    Object localObject2 = new oidb_0x88d.TagRecord();
    ((oidb_0x88d.TagRecord)localObject2).uint32_bad_num.set(0);
    ((oidb_0x88d.GroupInfo)localObject1).rpt_tag_record.add((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
    localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 3);
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void f(String paramString, boolean paramBoolean)
  {
    Object localObject1 = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      localObject1 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      if (localObject1 != null) {
        paramString = ((TroopManager)localObject1).jdField_a_of_type_JavaLangString;
      }
      localObject1 = paramString;
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("joinOrExitOpenTroop:").append((String)localObject1).append(", ");
      if (!paramBoolean) {
        break label338;
      }
      paramString = "join";
      label86:
      QLog.d(".troop.inOrOutOpenTroop", 2, paramString);
    }
    for (;;)
    {
      long l2;
      try
      {
        long l1 = Long.parseLong((String)localObject1);
        l2 = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c());
        paramString = new oidb_0xa8d.ReqBody();
        paramString.uint64_group_code.set(l1);
        localObject2 = paramString.uint32_req_type;
        if (!paramBoolean) {
          break label345;
        }
        i = jdField_d_of_type_Int;
        ((PBUInt32Field)localObject2).set(i);
        paramString.uint32_req_client_type.set(1);
        if (!paramBoolean) {
          break label352;
        }
        localObject2 = new oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody();
        ((oidb_0xa8d.Cmd0xa8dJoinPublicGroupReqBody)localObject2).uint64_visitor_uin.set(l2);
        paramString.msg_join_group.set((MessageMicro)localObject2);
        localObject2 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2701);
        PBUInt32Field localPBUInt32Field = ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type;
        if (!paramBoolean) {
          break label383;
        }
        i = jdField_d_of_type_Int;
        localPBUInt32Field.set(i);
        ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString.toByteArray()));
        paramString = a("OidbSvc.0xa8d");
        paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
        paramString.extraData.putString("troopUin", (String)localObject1);
        paramString.extraData.putBoolean("isJoin", paramBoolean);
        b(paramString);
        return;
      }
      catch (Exception paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(".troop.inOrOutOpenTroop", 2, "joinOrExitOpenTroop:" + paramString.toString());
      return;
      label338:
      paramString = "exit";
      break label86;
      label345:
      int i = e;
      continue;
      label352:
      localObject2 = new oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody();
      ((oidb_0xa8d.Cmd0xa8dExitPublicGroupReqBody)localObject2).uint64_visitor_uin.set(l2);
      paramString.msg_exit_group.set((MessageMicro)localObject2);
      continue;
      label383:
      i = e;
    }
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramToServiceMsg.extraData.getBoolean("param_get_credit_info", false);
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("param_get_troop_class_type", false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, "handleBatchGetTroopInfo, isTroopCreditLevelReq:" + bool1);
    }
    if (bool1) {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (bool2)
      {
        A(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      bool1 = paramFromServiceMsg.isSuccess();
      if (!bool1) {
        break;
      }
      paramToServiceMsg = (RespBatchProcess)paramObject;
    } while ((paramToServiceMsg.batch_response_list == null) || (paramToServiceMsg.batch_response_list.size() == 0));
    a(33, bool1, paramToServiceMsg);
    return;
    a(33, bool1, null);
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.get(paramString) == null) {}
    for (long l = 0L; (l != 0L) && (System.currentTimeMillis() - l < 1800000L); l = ((Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString)).longValue()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    Object localObject2 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject2).uint32_shutup_timestamp.set(0);
    ((oidb_0x88d.GroupInfo)localObject2).uint32_shutup_timestamp_me.set(0);
    Object localObject1 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject1).stgroupinfo.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject2).uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    ((oidb_0x88d.ReqBody)localObject2).stzreqgroupinfo.add((MessageMicro)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x88d_0");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("troop_uin", Long.parseLong(paramString));
    ((ToServiceMsg)localObject2).extraData.putInt("subCmd", 8);
    ((ToServiceMsg)localObject2).setTimeout(30000L);
    b((ToServiceMsg)localObject2);
  }
  
  public void g(String paramString, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.c())
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.a(paramString);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper.b(paramString);
  }
  
  /* Error */
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: sipush 1000
    //   7: if_icmpne +493 -> 500
    //   10: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: aload_3
    //   18: checkcast 151	[B
    //   21: checkcast 151	[B
    //   24: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +46 -> 78
    //   35: aload_1
    //   36: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   39: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   42: istore 4
    //   44: invokestatic 2796	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +31 -> 78
    //   50: ldc_w 5354
    //   53: iconst_4
    //   54: new 166	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 6565
    //   64: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 4
    //   69: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_1
    //   79: ifnull +421 -> 500
    //   82: aload_1
    //   83: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   86: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   89: ifeq +411 -> 500
    //   92: aload_1
    //   93: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   96: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   99: ifnull +401 -> 500
    //   102: aload_1
    //   103: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   112: astore_1
    //   113: new 6567	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody
    //   116: dup
    //   117: invokespecial 6568	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:<init>	()V
    //   120: astore_3
    //   121: aload_3
    //   122: aload_1
    //   123: invokevirtual 6569	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload_3
    //   128: getfield 6570	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:opt_uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   131: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   134: lstore 6
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_3
    //   139: getfield 6573	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:rpt_group_app_unread_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   142: invokevirtual 2636	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   145: ifeq +895 -> 1040
    //   148: aload_3
    //   149: getfield 6573	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:rpt_group_app_unread_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   152: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   155: astore_1
    //   156: new 58	java/util/ArrayList
    //   159: dup
    //   160: invokespecial 59	java/util/ArrayList:<init>	()V
    //   163: astore_2
    //   164: new 166	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   171: astore 10
    //   173: aload_1
    //   174: invokeinterface 221 1 0
    //   179: astore 11
    //   181: aconst_null
    //   182: astore_1
    //   183: iconst_0
    //   184: istore 4
    //   186: aload 11
    //   188: invokeinterface 226 1 0
    //   193: ifeq +789 -> 982
    //   196: aload 11
    //   198: invokeinterface 230 1 0
    //   203: checkcast 6575	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo
    //   206: astore 12
    //   208: aload 12
    //   210: getfield 6576	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_uint64_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   213: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   216: lstore 8
    //   218: new 5429	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo
    //   221: dup
    //   222: invokespecial 5430	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:<init>	()V
    //   225: astore_1
    //   226: aload_1
    //   227: lload 8
    //   229: putfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   232: aload_1
    //   233: lload 6
    //   235: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   238: putfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   241: aload_1
    //   242: aload 12
    //   244: getfield 6579	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_int32_group_unread_num	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   247: invokevirtual 444	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   250: putfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   253: aload_1
    //   254: aload 12
    //   256: getfield 6582	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$GroupAppUnreadInfo:opt_int32_group_album_passive_cnt	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   259: invokevirtual 444	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   262: putfield 5439	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   265: aload_1
    //   266: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   269: ldc2_w 5390
    //   272: lcmp
    //   273: ifne +228 -> 501
    //   276: aload_1
    //   277: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   280: iconst_m1
    //   281: if_icmpne +72 -> 353
    //   284: aload_0
    //   285: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   288: bipush 59
    //   290: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   293: checkcast 5393	com/tencent/mobileqq/app/HotChatManager
    //   296: astore 13
    //   298: aload 13
    //   300: ifnull +53 -> 353
    //   303: lload 6
    //   305: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: astore 12
    //   310: aload 13
    //   312: aload 12
    //   314: invokevirtual 5396	com/tencent/mobileqq/app/HotChatManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/HotChatInfo;
    //   317: astore 13
    //   319: aload 13
    //   321: ifnull +32 -> 353
    //   324: aload 13
    //   326: invokevirtual 5401	com/tencent/mobileqq/data/HotChatInfo:isBuLuoHotChat	()Z
    //   329: ifeq +24 -> 353
    //   332: aload 13
    //   334: invokevirtual 5404	com/tencent/mobileqq/data/HotChatInfo:setHasRedPoint	()V
    //   337: aload_0
    //   338: bipush 90
    //   340: iconst_1
    //   341: iconst_1
    //   342: anewarray 103	java/lang/Object
    //   345: dup
    //   346: iconst_0
    //   347: aload 12
    //   349: aastore
    //   350: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   353: iload 4
    //   355: istore 5
    //   357: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +754 -> 1114
    //   363: ldc_w 5553
    //   366: iconst_2
    //   367: new 166	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 6584
    //   377: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: getfield 5439	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   384: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   387: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: invokestatic 2796	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   396: ifeq +56 -> 452
    //   399: aload 10
    //   401: ldc_w 5472
    //   404: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: lload 6
    //   409: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   412: ldc_w 5474
    //   415: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload_1
    //   419: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   422: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   425: ldc_w 5476
    //   428: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_1
    //   432: getfield 5439	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   435: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   438: ldc_w 5478
    //   441: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload_1
    //   445: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   448: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_2
    //   453: aload_1
    //   454: invokeinterface 847 2 0
    //   459: pop
    //   460: goto -274 -> 186
    //   463: astore_1
    //   464: invokestatic 2796	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   467: ifeq +33 -> 500
    //   470: ldc_w 5354
    //   473: iconst_4
    //   474: new 166	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 6586
    //   484: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: aload_1
    //   488: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   491: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   497: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: return
    //   501: aload_1
    //   502: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   505: ldc2_w 1860
    //   508: lcmp
    //   509: ifne +50 -> 559
    //   512: aload_0
    //   513: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   516: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   519: ldc_w 5465
    //   522: lload 6
    //   524: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   527: aload_1
    //   528: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   531: invokestatic 5468	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   534: aload_0
    //   535: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   538: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   541: ldc_w 5470
    //   544: lload 6
    //   546: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   549: aload_1
    //   550: getfield 5439	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Int	I
    //   553: invokestatic 5468	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   556: goto -163 -> 393
    //   559: aload_1
    //   560: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   563: lconst_1
    //   564: lcmp
    //   565: ifne +28 -> 593
    //   568: aload_0
    //   569: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   572: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   575: ldc_w 5480
    //   578: lload 6
    //   580: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   583: aload_1
    //   584: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   587: invokestatic 5468	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   590: goto -197 -> 393
    //   593: aload_1
    //   594: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   597: ldc2_w 5481
    //   600: lcmp
    //   601: ifne +28 -> 629
    //   604: aload_0
    //   605: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   608: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   611: ldc_w 5484
    //   614: lload 6
    //   616: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   619: aload_1
    //   620: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   623: invokestatic 5468	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   626: goto -233 -> 393
    //   629: aload_1
    //   630: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   633: ldc2_w 5544
    //   636: lcmp
    //   637: ifne +28 -> 665
    //   640: aload_0
    //   641: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   644: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   647: ldc_w 5547
    //   650: lload 6
    //   652: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   655: aload_1
    //   656: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   659: invokestatic 5468	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   662: goto -269 -> 393
    //   665: aload_1
    //   666: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   669: ldc2_w 5410
    //   672: lcmp
    //   673: ifne +120 -> 793
    //   676: aload_1
    //   677: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   680: iconst_m1
    //   681: if_icmpeq +10 -> 691
    //   684: aload_1
    //   685: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   688: ifle +77 -> 765
    //   691: aload_0
    //   692: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   695: aload_1
    //   696: getfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   699: iconst_m1
    //   700: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   703: invokestatic 2625	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Integer;)V
    //   706: iconst_1
    //   707: istore 4
    //   709: iload 4
    //   711: istore 5
    //   713: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +398 -> 1114
    //   719: ldc_w 3384
    //   722: iconst_2
    //   723: new 166	java/lang/StringBuilder
    //   726: dup
    //   727: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   730: ldc_w 6588
    //   733: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: aload_1
    //   737: getfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   740: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: ldc_w 5551
    //   746: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: aload_1
    //   750: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   753: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   756: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   759: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   762: goto -369 -> 393
    //   765: aload_1
    //   766: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   769: ifne -60 -> 709
    //   772: aload_0
    //   773: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   776: aload_1
    //   777: getfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   780: iconst_0
    //   781: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   784: invokestatic 2625	com/tencent/mobileqq/activity/ChatActivityUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/Integer;)V
    //   787: iconst_1
    //   788: istore 4
    //   790: goto -81 -> 709
    //   793: aload_1
    //   794: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   797: ldc2_w 5600
    //   800: lcmp
    //   801: ifne +105 -> 906
    //   804: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   807: ifeq +46 -> 853
    //   810: ldc_w 3001
    //   813: iconst_2
    //   814: new 166	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 6588
    //   824: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: aload_1
    //   828: getfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   831: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: ldc_w 5551
    //   837: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: aload_1
    //   841: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   844: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   847: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   850: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   853: aload_0
    //   854: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   857: aload_1
    //   858: getfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   861: aload_1
    //   862: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   865: invokestatic 5608	com/tencent/mobileqq/troop/utils/HWTroopUtils:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   868: aload_0
    //   869: bipush 61
    //   871: iconst_1
    //   872: iconst_3
    //   873: anewarray 103	java/lang/Object
    //   876: dup
    //   877: iconst_0
    //   878: lload 6
    //   880: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   883: aastore
    //   884: dup
    //   885: iconst_1
    //   886: ldc_w 5609
    //   889: invokestatic 5611	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   892: aastore
    //   893: dup
    //   894: iconst_2
    //   895: iconst_0
    //   896: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   899: aastore
    //   900: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   903: goto -510 -> 393
    //   906: aload_1
    //   907: getfield 5431	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_Long	J
    //   910: ldc2_w 5612
    //   913: lcmp
    //   914: ifne +27 -> 941
    //   917: aload_0
    //   918: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   921: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   924: ldc_w 5615
    //   927: aload_1
    //   928: getfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   931: aload_1
    //   932: getfield 5435	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_b_of_type_Int	I
    //   935: invokestatic 5468	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   938: goto -545 -> 393
    //   941: iload 4
    //   943: istore 5
    //   945: aload_0
    //   946: aload_1
    //   947: aconst_null
    //   948: iconst_1
    //   949: invokestatic 5618	com/tencent/mobileqq/app/TroopHandler$Oidb_0xb36:a	(Lcom/tencent/mobileqq/app/TroopHandler;Lcom/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo;Ltencent/im/s2c/msgtype0x210/submsgtype0x26/submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum;I)Z
    //   952: ifeq +162 -> 1114
    //   955: iload 4
    //   957: istore 5
    //   959: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   962: ifeq +152 -> 1114
    //   965: ldc_w 5620
    //   968: iconst_2
    //   969: ldc_w 6590
    //   972: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   975: iload 4
    //   977: istore 5
    //   979: goto +135 -> 1114
    //   982: invokestatic 2796	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   985: ifeq +15 -> 1000
    //   988: ldc_w 5354
    //   991: iconst_4
    //   992: aload 10
    //   994: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1000: iload 4
    //   1002: ifeq +119 -> 1121
    //   1005: aload_0
    //   1006: bipush 62
    //   1008: iconst_1
    //   1009: iconst_3
    //   1010: anewarray 103	java/lang/Object
    //   1013: dup
    //   1014: iconst_0
    //   1015: aload_1
    //   1016: getfield 5433	com/tencent/mobileqq/troopinfo/TroopUnreadMsgInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1019: aastore
    //   1020: dup
    //   1021: iconst_1
    //   1022: iconst_0
    //   1023: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1026: aastore
    //   1027: dup
    //   1028: iconst_2
    //   1029: iconst_0
    //   1030: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1033: aastore
    //   1034: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1037: goto +84 -> 1121
    //   1040: aload_0
    //   1041: bipush 30
    //   1043: iconst_1
    //   1044: iconst_3
    //   1045: anewarray 103	java/lang/Object
    //   1048: dup
    //   1049: iconst_0
    //   1050: iconst_0
    //   1051: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   1054: aastore
    //   1055: dup
    //   1056: iconst_1
    //   1057: aload_1
    //   1058: aastore
    //   1059: dup
    //   1060: iconst_2
    //   1061: aload_3
    //   1062: getfield 6593	tencent/im/oidb/oidb_0x8c9/oidb_0x8c9$RspBody:opt_int32_show_red_point_mobile	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   1065: invokevirtual 444	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   1068: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1071: aastore
    //   1072: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1075: return
    //   1076: astore_1
    //   1077: invokestatic 2796	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1080: ifeq -580 -> 500
    //   1083: ldc_w 5354
    //   1086: iconst_4
    //   1087: new 166	java/lang/StringBuilder
    //   1090: dup
    //   1091: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1094: ldc_w 6595
    //   1097: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: aload_1
    //   1101: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   1104: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1107: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1110: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1113: return
    //   1114: iload 5
    //   1116: istore 4
    //   1118: goto -725 -> 393
    //   1121: aload_2
    //   1122: astore_1
    //   1123: goto -83 -> 1040
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1126	0	this	TroopHandler
    //   0	1126	1	paramToServiceMsg	ToServiceMsg
    //   0	1126	2	paramFromServiceMsg	FromServiceMsg
    //   0	1126	3	paramObject	Object
    //   42	1075	4	i	int
    //   355	760	5	j	int
    //   134	745	6	l1	long
    //   216	12	8	l2	long
    //   171	822	10	localStringBuilder	StringBuilder
    //   179	18	11	localIterator	Iterator
    //   206	142	12	localObject1	Object
    //   296	37	13	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	31	463	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	136	1076	java/lang/Exception
    //   138	181	1076	java/lang/Exception
    //   186	298	1076	java/lang/Exception
    //   303	319	1076	java/lang/Exception
    //   324	353	1076	java/lang/Exception
    //   357	393	1076	java/lang/Exception
    //   393	452	1076	java/lang/Exception
    //   452	460	1076	java/lang/Exception
    //   501	556	1076	java/lang/Exception
    //   559	590	1076	java/lang/Exception
    //   593	626	1076	java/lang/Exception
    //   629	662	1076	java/lang/Exception
    //   665	691	1076	java/lang/Exception
    //   691	706	1076	java/lang/Exception
    //   713	762	1076	java/lang/Exception
    //   765	787	1076	java/lang/Exception
    //   793	853	1076	java/lang/Exception
    //   853	903	1076	java/lang/Exception
    //   906	938	1076	java/lang/Exception
    //   945	955	1076	java/lang/Exception
    //   959	975	1076	java/lang/Exception
    //   982	1000	1076	java/lang/Exception
    //   1005	1037	1076	java/lang/Exception
    //   1040	1075	1076	java/lang/Exception
  }
  
  public void h(String paramString)
  {
    Object localObject = new cmd0x91c.ReqBody();
    ((cmd0x91c.ReqBody)localObject).uint64_group_code.set(Long.valueOf(paramString).longValue());
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(2332);
    paramString.uint32_service_type.set(1);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x91c.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0x91c_1");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  /* Error */
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 3852
    //   7: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   10: istore 9
    //   12: iconst_0
    //   13: istore 11
    //   15: iconst_0
    //   16: istore 12
    //   18: iconst_0
    //   19: istore 10
    //   21: aconst_null
    //   22: astore 23
    //   24: aconst_null
    //   25: astore 22
    //   27: aconst_null
    //   28: astore 24
    //   30: aconst_null
    //   31: astore 21
    //   33: aload_1
    //   34: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   37: ldc_w 1384
    //   40: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   43: lstore 19
    //   45: aload_1
    //   46: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   49: ldc_w 2289
    //   52: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   55: istore 5
    //   57: aload_1
    //   58: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   61: ldc_w 3850
    //   64: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   67: lstore 13
    //   69: aload_2
    //   70: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   73: sipush 1000
    //   76: if_icmpne +1735 -> 1811
    //   79: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: astore_1
    //   87: aload_1
    //   88: aload_3
    //   89: checkcast 151	[B
    //   92: checkcast 151	[B
    //   95: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_3
    //   102: aload_3
    //   103: astore_1
    //   104: aload_1
    //   105: ifnull +1700 -> 1805
    //   108: aload_1
    //   109: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: istore 6
    //   117: iload 6
    //   119: istore 4
    //   121: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   124: ifeq +35 -> 159
    //   127: ldc_w 2296
    //   130: iconst_2
    //   131: new 166	java/lang/StringBuilder
    //   134: dup
    //   135: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   138: ldc_w 6602
    //   141: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: iload 6
    //   146: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   149: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   155: iload 6
    //   157: istore 4
    //   159: aload_1
    //   160: ifnull +1632 -> 1792
    //   163: aload_1
    //   164: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   167: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   170: ifeq +1622 -> 1792
    //   173: aload_1
    //   174: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   177: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   180: ifnull +1612 -> 1792
    //   183: aload_1
    //   184: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   187: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   190: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   193: astore_1
    //   194: new 6604	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody
    //   197: dup
    //   198: invokespecial 6605	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:<init>	()V
    //   201: astore 23
    //   203: aload 23
    //   205: aload_1
    //   206: invokevirtual 6606	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   209: pop
    //   210: iload 4
    //   212: ifeq +1575 -> 1787
    //   215: aload 23
    //   217: getfield 6607	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   223: ifeq +1564 -> 1787
    //   226: aload 23
    //   228: getfield 6607	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   237: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   240: astore_1
    //   241: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +30 -> 274
    //   247: ldc_w 2296
    //   250: iconst_2
    //   251: new 166	java/lang/StringBuilder
    //   254: dup
    //   255: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   258: ldc_w 6609
    //   261: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_1
    //   265: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: iload 4
    //   276: ifne +1503 -> 1779
    //   279: iload 5
    //   281: istore 7
    //   283: lload 13
    //   285: lstore 17
    //   287: aload 21
    //   289: astore_3
    //   290: aload 23
    //   292: getfield 6610	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   295: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   298: lload 19
    //   300: lcmp
    //   301: ifne +1478 -> 1779
    //   304: iconst_1
    //   305: istore 11
    //   307: iload 5
    //   309: istore 7
    //   311: lload 13
    //   313: lstore 17
    //   315: aload 21
    //   317: astore_3
    //   318: iload 11
    //   320: istore 10
    //   322: aload 23
    //   324: getfield 6613	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:rpt_memberlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   327: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   330: astore 22
    //   332: lload 13
    //   334: lstore 15
    //   336: iload 5
    //   338: istore 7
    //   340: lload 13
    //   342: lstore 17
    //   344: aload 22
    //   346: astore_3
    //   347: iload 11
    //   349: istore 10
    //   351: aload 23
    //   353: getfield 6614	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_start_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   356: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   359: ifeq +100 -> 459
    //   362: iload 5
    //   364: istore 7
    //   366: lload 13
    //   368: lstore 17
    //   370: aload 22
    //   372: astore_3
    //   373: iload 11
    //   375: istore 10
    //   377: aload 23
    //   379: getfield 6614	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint64_start_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   382: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   385: lstore 13
    //   387: lload 13
    //   389: lstore 15
    //   391: iload 5
    //   393: istore 7
    //   395: lload 13
    //   397: lstore 17
    //   399: aload 22
    //   401: astore_3
    //   402: iload 11
    //   404: istore 10
    //   406: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +50 -> 459
    //   412: iload 5
    //   414: istore 7
    //   416: lload 13
    //   418: lstore 17
    //   420: aload 22
    //   422: astore_3
    //   423: iload 11
    //   425: istore 10
    //   427: ldc_w 2296
    //   430: iconst_2
    //   431: new 166	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 6616
    //   441: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: lload 13
    //   446: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: lload 13
    //   457: lstore 15
    //   459: iload 5
    //   461: istore 6
    //   463: iload 5
    //   465: istore 7
    //   467: lload 15
    //   469: lstore 17
    //   471: aload 22
    //   473: astore_3
    //   474: iload 11
    //   476: istore 10
    //   478: aload 23
    //   480: getfield 6617	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint32_identify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   483: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   486: ifeq +100 -> 586
    //   489: iload 5
    //   491: istore 7
    //   493: lload 15
    //   495: lstore 17
    //   497: aload 22
    //   499: astore_3
    //   500: iload 11
    //   502: istore 10
    //   504: aload 23
    //   506: getfield 6617	tencent/im/oidb/cmd0x899/oidb_0x899$RspBody:uint32_identify_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   509: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   512: istore 5
    //   514: iload 5
    //   516: istore 6
    //   518: iload 5
    //   520: istore 7
    //   522: lload 15
    //   524: lstore 17
    //   526: aload 22
    //   528: astore_3
    //   529: iload 11
    //   531: istore 10
    //   533: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   536: ifeq +50 -> 586
    //   539: iload 5
    //   541: istore 7
    //   543: lload 15
    //   545: lstore 17
    //   547: aload 22
    //   549: astore_3
    //   550: iload 11
    //   552: istore 10
    //   554: ldc_w 2296
    //   557: iconst_2
    //   558: new 166	java/lang/StringBuilder
    //   561: dup
    //   562: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   565: ldc_w 6619
    //   568: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: iload 5
    //   573: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: iload 5
    //   584: istore 6
    //   586: iload 6
    //   588: iconst_5
    //   589: if_icmpne +720 -> 1309
    //   592: iload 6
    //   594: istore 7
    //   596: lload 15
    //   598: lstore 17
    //   600: aload 22
    //   602: astore_3
    //   603: iload 11
    //   605: istore 10
    //   607: aload_0
    //   608: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   611: bipush 51
    //   613: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   616: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   619: astore 24
    //   621: iload 6
    //   623: istore 7
    //   625: lload 15
    //   627: lstore 17
    //   629: aload 22
    //   631: astore_3
    //   632: iload 11
    //   634: istore 10
    //   636: aload 24
    //   638: lload 19
    //   640: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   643: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   646: astore 23
    //   648: iload 9
    //   650: bipush 9
    //   652: if_icmpne +369 -> 1021
    //   655: iload 6
    //   657: istore 7
    //   659: lload 15
    //   661: lstore 17
    //   663: aload 22
    //   665: astore_3
    //   666: iload 11
    //   668: istore 10
    //   670: aload 23
    //   672: aload 22
    //   674: invokevirtual 6622	com/tencent/mobileqq/data/TroopInfo:updateHeadMemberUins	(Ljava/util/List;)V
    //   677: iload 6
    //   679: istore 7
    //   681: lload 15
    //   683: lstore 17
    //   685: aload 22
    //   687: astore_3
    //   688: iload 11
    //   690: istore 10
    //   692: aload_0
    //   693: getfield 84	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_ComTencentMobileqqAppGroupIconHelper	Lcom/tencent/mobileqq/app/GroupIconHelper;
    //   696: aload 23
    //   698: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   701: invokevirtual 3653	com/tencent/mobileqq/app/GroupIconHelper:c	(Ljava/lang/String;)V
    //   704: aload 23
    //   706: astore 21
    //   708: iload 6
    //   710: istore 7
    //   712: lload 15
    //   714: lstore 17
    //   716: aload 22
    //   718: astore_3
    //   719: iload 11
    //   721: istore 10
    //   723: aload 24
    //   725: aload 21
    //   727: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   730: iload 6
    //   732: istore 7
    //   734: lload 15
    //   736: lstore 17
    //   738: aload 22
    //   740: astore_3
    //   741: iload 11
    //   743: istore 10
    //   745: aload_0
    //   746: getfield 45	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_Long	J
    //   749: lload 19
    //   751: lcmp
    //   752: ifne +557 -> 1309
    //   755: iload 6
    //   757: istore 7
    //   759: lload 15
    //   761: lstore 17
    //   763: aload 22
    //   765: astore_3
    //   766: iload 11
    //   768: istore 10
    //   770: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   773: ifeq +27 -> 800
    //   776: iload 6
    //   778: istore 7
    //   780: lload 15
    //   782: lstore 17
    //   784: aload 22
    //   786: astore_3
    //   787: iload 11
    //   789: istore 10
    //   791: ldc 96
    //   793: iconst_2
    //   794: ldc_w 6624
    //   797: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   800: iload 6
    //   802: istore 7
    //   804: lload 15
    //   806: lstore 17
    //   808: aload 22
    //   810: astore_3
    //   811: iload 11
    //   813: istore 10
    //   815: aload_0
    //   816: getfield 6625	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   819: ifnonnull +465 -> 1284
    //   822: iload 6
    //   824: istore 7
    //   826: lload 15
    //   828: lstore 17
    //   830: aload 22
    //   832: astore_3
    //   833: iload 11
    //   835: istore 10
    //   837: aload_0
    //   838: new 58	java/util/ArrayList
    //   841: dup
    //   842: invokespecial 59	java/util/ArrayList:<init>	()V
    //   845: putfield 6625	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   848: goto +979 -> 1827
    //   851: iload 6
    //   853: istore 7
    //   855: lload 15
    //   857: lstore 17
    //   859: aload 22
    //   861: astore_3
    //   862: iload 11
    //   864: istore 10
    //   866: iload 5
    //   868: aload 22
    //   870: invokeinterface 565 1 0
    //   875: if_icmpge +434 -> 1309
    //   878: iload 6
    //   880: istore 7
    //   882: lload 15
    //   884: lstore 17
    //   886: aload 22
    //   888: astore_3
    //   889: iload 11
    //   891: istore 10
    //   893: aload 22
    //   895: iload 5
    //   897: invokeinterface 638 2 0
    //   902: checkcast 3812	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist
    //   905: astore 21
    //   907: iload 6
    //   909: istore 7
    //   911: lload 15
    //   913: lstore 17
    //   915: aload 22
    //   917: astore_3
    //   918: iload 11
    //   920: istore 10
    //   922: aload 21
    //   924: getfield 3816	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   927: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   930: ifeq +37 -> 967
    //   933: iload 6
    //   935: istore 7
    //   937: lload 15
    //   939: lstore 17
    //   941: aload 22
    //   943: astore_3
    //   944: iload 11
    //   946: istore 10
    //   948: aload_0
    //   949: getfield 6625	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   952: aload 21
    //   954: getfield 3816	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   957: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   960: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   963: invokevirtual 234	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   966: pop
    //   967: iload 5
    //   969: iconst_1
    //   970: iadd
    //   971: istore 5
    //   973: goto -122 -> 851
    //   976: astore_3
    //   977: aconst_null
    //   978: astore_1
    //   979: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   982: ifeq +32 -> 1014
    //   985: ldc 96
    //   987: iconst_2
    //   988: new 166	java/lang/StringBuilder
    //   991: dup
    //   992: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   995: ldc_w 6627
    //   998: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: aload_3
    //   1002: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   1005: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1008: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1011: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1014: aload_3
    //   1015: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   1018: goto -914 -> 104
    //   1021: aload 23
    //   1023: astore 21
    //   1025: aload 23
    //   1027: ifnonnull +52 -> 1079
    //   1030: iload 6
    //   1032: istore 7
    //   1034: lload 15
    //   1036: lstore 17
    //   1038: aload 22
    //   1040: astore_3
    //   1041: iload 11
    //   1043: istore 10
    //   1045: new 511	com/tencent/mobileqq/data/TroopInfo
    //   1048: dup
    //   1049: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   1052: astore 21
    //   1054: iload 6
    //   1056: istore 7
    //   1058: lload 15
    //   1060: lstore 17
    //   1062: aload 22
    //   1064: astore_3
    //   1065: iload 11
    //   1067: istore 10
    //   1069: aload 21
    //   1071: lload 19
    //   1073: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1076: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1079: iload 6
    //   1081: istore 7
    //   1083: lload 15
    //   1085: lstore 17
    //   1087: aload 22
    //   1089: astore_3
    //   1090: iload 11
    //   1092: istore 10
    //   1094: aload 21
    //   1096: aload 22
    //   1098: invokevirtual 6630	com/tencent/mobileqq/data/TroopInfo:updateSomeMemberUins	(Ljava/util/List;)V
    //   1101: goto -393 -> 708
    //   1104: astore 21
    //   1106: lload 17
    //   1108: lstore 13
    //   1110: iload 7
    //   1112: istore 5
    //   1114: iload 9
    //   1116: ifne +573 -> 1689
    //   1119: aload_0
    //   1120: bipush 19
    //   1122: iload 10
    //   1124: bipush 6
    //   1126: anewarray 103	java/lang/Object
    //   1129: dup
    //   1130: iconst_0
    //   1131: lload 19
    //   1133: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1136: aastore
    //   1137: dup
    //   1138: iconst_1
    //   1139: iload 5
    //   1141: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1144: aastore
    //   1145: dup
    //   1146: iconst_2
    //   1147: aload_3
    //   1148: aastore
    //   1149: dup
    //   1150: iconst_3
    //   1151: lload 13
    //   1153: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1156: aastore
    //   1157: dup
    //   1158: iconst_4
    //   1159: iload 4
    //   1161: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1164: aastore
    //   1165: dup
    //   1166: iconst_5
    //   1167: aload_1
    //   1168: aastore
    //   1169: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1172: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1175: ifeq +108 -> 1283
    //   1178: new 166	java/lang/StringBuilder
    //   1181: dup
    //   1182: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1185: astore_3
    //   1186: aload_3
    //   1187: ldc_w 6632
    //   1190: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1193: ldc_w 6634
    //   1196: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1199: iload 10
    //   1201: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1204: ldc_w 6636
    //   1207: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: aload_2
    //   1211: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1214: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1217: ldc_w 3802
    //   1220: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1223: lload 19
    //   1225: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1228: ldc_w 3804
    //   1231: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1234: iload 5
    //   1236: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1239: ldc_w 6638
    //   1242: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1245: lload 13
    //   1247: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1250: ldc_w 6640
    //   1253: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: iload 4
    //   1258: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1261: ldc_w 6642
    //   1264: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: aload_1
    //   1268: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1271: pop
    //   1272: ldc_w 2296
    //   1275: iconst_2
    //   1276: aload_3
    //   1277: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1280: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1283: return
    //   1284: iload 6
    //   1286: istore 7
    //   1288: lload 15
    //   1290: lstore 17
    //   1292: aload 22
    //   1294: astore_3
    //   1295: iload 11
    //   1297: istore 10
    //   1299: aload_0
    //   1300: getfield 6625	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   1303: invokevirtual 894	java/util/ArrayList:clear	()V
    //   1306: goto +521 -> 1827
    //   1309: iload 6
    //   1311: istore 7
    //   1313: lload 15
    //   1315: lstore 17
    //   1317: aload 22
    //   1319: astore_3
    //   1320: iload 11
    //   1322: istore 10
    //   1324: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1327: ifeq +345 -> 1672
    //   1330: iload 6
    //   1332: istore 7
    //   1334: lload 15
    //   1336: lstore 17
    //   1338: aload 22
    //   1340: astore_3
    //   1341: iload 11
    //   1343: istore 10
    //   1345: new 166	java/lang/StringBuilder
    //   1348: dup
    //   1349: sipush 200
    //   1352: invokespecial 3798	java/lang/StringBuilder:<init>	(I)V
    //   1355: astore 21
    //   1357: iload 6
    //   1359: istore 7
    //   1361: lload 15
    //   1363: lstore 17
    //   1365: aload 22
    //   1367: astore_3
    //   1368: iload 11
    //   1370: istore 10
    //   1372: aload 21
    //   1374: ldc_w 6632
    //   1377: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1380: ldc_w 6644
    //   1383: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1386: lload 15
    //   1388: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1391: ldc_w 6646
    //   1394: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1397: iload 6
    //   1399: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1402: pop
    //   1403: aload 22
    //   1405: ifnull +437 -> 1842
    //   1408: iload 6
    //   1410: istore 7
    //   1412: lload 15
    //   1414: lstore 17
    //   1416: aload 22
    //   1418: astore_3
    //   1419: iload 11
    //   1421: istore 10
    //   1423: aload 22
    //   1425: invokeinterface 565 1 0
    //   1430: istore 5
    //   1432: iload 6
    //   1434: istore 7
    //   1436: lload 15
    //   1438: lstore 17
    //   1440: aload 22
    //   1442: astore_3
    //   1443: iload 11
    //   1445: istore 10
    //   1447: aload 21
    //   1449: ldc_w 6648
    //   1452: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1455: iload 5
    //   1457: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1460: ldc_w 6650
    //   1463: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1466: pop
    //   1467: iconst_0
    //   1468: istore 8
    //   1470: iload 8
    //   1472: iload 5
    //   1474: if_icmpge +147 -> 1621
    //   1477: iload 6
    //   1479: istore 7
    //   1481: lload 15
    //   1483: lstore 17
    //   1485: aload 22
    //   1487: astore_3
    //   1488: iload 11
    //   1490: istore 10
    //   1492: aload 22
    //   1494: iload 8
    //   1496: invokeinterface 638 2 0
    //   1501: checkcast 3812	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist
    //   1504: astore 23
    //   1506: aload 23
    //   1508: ifnull +69 -> 1577
    //   1511: iload 6
    //   1513: istore 7
    //   1515: lload 15
    //   1517: lstore 17
    //   1519: aload 22
    //   1521: astore_3
    //   1522: iload 11
    //   1524: istore 10
    //   1526: aload 21
    //   1528: ldc_w 6652
    //   1531: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1534: iload 8
    //   1536: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1539: ldc_w 3005
    //   1542: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: aload 23
    //   1547: getfield 3816	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint64_member_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   1550: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1553: ldc_w 3005
    //   1556: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1559: aload 23
    //   1561: getfield 3826	tencent/im/oidb/cmd0x899/oidb_0x899$memberlist:uint32_uin_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1564: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1567: ldc_w 6654
    //   1570: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1573: pop
    //   1574: goto +259 -> 1833
    //   1577: iload 6
    //   1579: istore 7
    //   1581: lload 15
    //   1583: lstore 17
    //   1585: aload 22
    //   1587: astore_3
    //   1588: iload 11
    //   1590: istore 10
    //   1592: aload 21
    //   1594: ldc_w 6652
    //   1597: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1600: iload 8
    //   1602: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1605: ldc_w 6656
    //   1608: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1611: ldc_w 6654
    //   1614: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1617: pop
    //   1618: goto +215 -> 1833
    //   1621: iload 6
    //   1623: istore 7
    //   1625: lload 15
    //   1627: lstore 17
    //   1629: aload 22
    //   1631: astore_3
    //   1632: iload 11
    //   1634: istore 10
    //   1636: aload 21
    //   1638: ldc_w 6658
    //   1641: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1644: pop
    //   1645: iload 6
    //   1647: istore 7
    //   1649: lload 15
    //   1651: lstore 17
    //   1653: aload 22
    //   1655: astore_3
    //   1656: iload 11
    //   1658: istore 10
    //   1660: ldc_w 2296
    //   1663: iconst_2
    //   1664: aload 21
    //   1666: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1669: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1672: iload 6
    //   1674: istore 5
    //   1676: aload 22
    //   1678: astore_3
    //   1679: lload 15
    //   1681: lstore 13
    //   1683: iconst_1
    //   1684: istore 10
    //   1686: goto -572 -> 1114
    //   1689: iload 9
    //   1691: iconst_1
    //   1692: if_icmpne -520 -> 1172
    //   1695: aload_0
    //   1696: bipush 20
    //   1698: iload 10
    //   1700: bipush 6
    //   1702: anewarray 103	java/lang/Object
    //   1705: dup
    //   1706: iconst_0
    //   1707: lload 19
    //   1709: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1712: aastore
    //   1713: dup
    //   1714: iconst_1
    //   1715: iload 5
    //   1717: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1720: aastore
    //   1721: dup
    //   1722: iconst_2
    //   1723: aload_3
    //   1724: aastore
    //   1725: dup
    //   1726: iconst_3
    //   1727: lload 13
    //   1729: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1732: aastore
    //   1733: dup
    //   1734: iconst_4
    //   1735: iload 4
    //   1737: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1740: aastore
    //   1741: dup
    //   1742: iconst_5
    //   1743: aload_1
    //   1744: aastore
    //   1745: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1748: goto -576 -> 1172
    //   1751: astore_1
    //   1752: aconst_null
    //   1753: astore_1
    //   1754: aload 22
    //   1756: astore_3
    //   1757: iload 11
    //   1759: istore 10
    //   1761: goto -647 -> 1114
    //   1764: astore_3
    //   1765: aload 22
    //   1767: astore_3
    //   1768: iload 11
    //   1770: istore 10
    //   1772: goto -658 -> 1114
    //   1775: astore_3
    //   1776: goto -797 -> 979
    //   1779: aconst_null
    //   1780: astore_3
    //   1781: iconst_0
    //   1782: istore 10
    //   1784: goto -98 -> 1686
    //   1787: aconst_null
    //   1788: astore_1
    //   1789: goto -1515 -> 274
    //   1792: aload 24
    //   1794: astore_3
    //   1795: iload 12
    //   1797: istore 10
    //   1799: aload 23
    //   1801: astore_1
    //   1802: goto -688 -> 1114
    //   1805: iconst_m1
    //   1806: istore 4
    //   1808: goto -1649 -> 159
    //   1811: iconst_m1
    //   1812: istore 4
    //   1814: aload 24
    //   1816: astore_3
    //   1817: iload 12
    //   1819: istore 10
    //   1821: aload 23
    //   1823: astore_1
    //   1824: goto -710 -> 1114
    //   1827: iconst_0
    //   1828: istore 5
    //   1830: goto -979 -> 851
    //   1833: iload 8
    //   1835: iconst_1
    //   1836: iadd
    //   1837: istore 8
    //   1839: goto -369 -> 1470
    //   1842: iconst_0
    //   1843: istore 5
    //   1845: goto -413 -> 1432
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1848	0	this	TroopHandler
    //   0	1848	1	paramToServiceMsg	ToServiceMsg
    //   0	1848	2	paramFromServiceMsg	FromServiceMsg
    //   0	1848	3	paramObject	Object
    //   119	1694	4	i	int
    //   55	1789	5	j	int
    //   115	1558	6	k	int
    //   281	1367	7	m	int
    //   1468	370	8	n	int
    //   10	1683	9	i1	int
    //   19	1801	10	bool1	boolean
    //   13	1756	11	bool2	boolean
    //   16	1802	12	bool3	boolean
    //   67	1661	13	l1	long
    //   334	1346	15	l2	long
    //   285	1367	17	l3	long
    //   43	1665	19	l4	long
    //   31	1064	21	localObject1	Object
    //   1104	1	21	localException	Exception
    //   1355	310	21	localStringBuilder	StringBuilder
    //   25	1741	22	localList	List
    //   22	1800	23	localObject2	Object
    //   28	1787	24	localTroopManager	TroopManager
    // Exception table:
    //   from	to	target	type
    //   79	87	976	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   290	304	1104	java/lang/Exception
    //   322	332	1104	java/lang/Exception
    //   351	362	1104	java/lang/Exception
    //   377	387	1104	java/lang/Exception
    //   406	412	1104	java/lang/Exception
    //   427	455	1104	java/lang/Exception
    //   478	489	1104	java/lang/Exception
    //   504	514	1104	java/lang/Exception
    //   533	539	1104	java/lang/Exception
    //   554	582	1104	java/lang/Exception
    //   607	621	1104	java/lang/Exception
    //   636	648	1104	java/lang/Exception
    //   670	677	1104	java/lang/Exception
    //   692	704	1104	java/lang/Exception
    //   723	730	1104	java/lang/Exception
    //   745	755	1104	java/lang/Exception
    //   770	776	1104	java/lang/Exception
    //   791	800	1104	java/lang/Exception
    //   815	822	1104	java/lang/Exception
    //   837	848	1104	java/lang/Exception
    //   866	878	1104	java/lang/Exception
    //   893	907	1104	java/lang/Exception
    //   922	933	1104	java/lang/Exception
    //   948	967	1104	java/lang/Exception
    //   1045	1054	1104	java/lang/Exception
    //   1069	1079	1104	java/lang/Exception
    //   1094	1101	1104	java/lang/Exception
    //   1299	1306	1104	java/lang/Exception
    //   1324	1330	1104	java/lang/Exception
    //   1345	1357	1104	java/lang/Exception
    //   1372	1403	1104	java/lang/Exception
    //   1423	1432	1104	java/lang/Exception
    //   1447	1467	1104	java/lang/Exception
    //   1492	1506	1104	java/lang/Exception
    //   1526	1574	1104	java/lang/Exception
    //   1592	1618	1104	java/lang/Exception
    //   1636	1645	1104	java/lang/Exception
    //   1660	1672	1104	java/lang/Exception
    //   194	210	1751	java/lang/Exception
    //   215	241	1751	java/lang/Exception
    //   241	274	1764	java/lang/Exception
    //   87	102	1775	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void i(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 2);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    a(localToServiceMsg);
    v(paramString);
  }
  
  /* Error */
  public void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 13
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 11
    //   9: aconst_null
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 18
    //   15: aconst_null
    //   16: astore 20
    //   18: aload_1
    //   19: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 1384
    //   25: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   28: lstore 14
    //   30: aload_1
    //   31: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 2289
    //   37: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   40: istore 9
    //   42: aload_1
    //   43: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   46: ldc 122
    //   48: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   51: istore 10
    //   53: aload_1
    //   54: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   57: ldc_w 4128
    //   60: invokevirtual 136	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: astore 21
    //   65: iconst_m1
    //   66: istore 4
    //   68: iload 4
    //   70: istore 5
    //   72: aload_2
    //   73: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   76: sipush 1000
    //   79: if_icmpne +1231 -> 1310
    //   82: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   85: dup
    //   86: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   89: astore_1
    //   90: aload_1
    //   91: aload_3
    //   92: checkcast 151	[B
    //   95: checkcast 151	[B
    //   98: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   101: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   104: astore_3
    //   105: aload_3
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +54 -> 162
    //   111: aload_1
    //   112: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: istore 5
    //   120: iload 5
    //   122: istore 4
    //   124: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +35 -> 162
    //   130: ldc_w 2296
    //   133: iconst_2
    //   134: new 166	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 6662
    //   144: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: iload 5
    //   149: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   152: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: iload 5
    //   160: istore 4
    //   162: iload 4
    //   164: istore 5
    //   166: aload_1
    //   167: ifnull +1143 -> 1310
    //   170: iload 4
    //   172: istore 5
    //   174: aload_1
    //   175: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   178: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   181: ifeq +1129 -> 1310
    //   184: iload 4
    //   186: istore 5
    //   188: aload_1
    //   189: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   192: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   195: ifnull +1115 -> 1310
    //   198: aload_1
    //   199: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   202: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   205: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   208: astore_1
    //   209: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   212: dup
    //   213: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   216: astore 20
    //   218: aload 20
    //   220: aload_1
    //   221: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   224: pop
    //   225: iload 4
    //   227: ifeq +1078 -> 1305
    //   230: aload 20
    //   232: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   238: ifeq +1067 -> 1305
    //   241: aload 20
    //   243: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   246: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   249: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   252: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   255: astore_1
    //   256: aconst_null
    //   257: astore_3
    //   258: iload 4
    //   260: istore 5
    //   262: aload 18
    //   264: astore 19
    //   266: iload 12
    //   268: istore 11
    //   270: aload 20
    //   272: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   275: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   278: astore 20
    //   280: aload 20
    //   282: ifnonnull +140 -> 422
    //   285: iconst_0
    //   286: istore 7
    //   288: goto +1032 -> 1320
    //   291: aload_3
    //   292: ifnonnull +239 -> 531
    //   295: iload 8
    //   297: iload 7
    //   299: if_icmpge +232 -> 531
    //   302: iload 4
    //   304: istore 5
    //   306: aload 18
    //   308: astore 19
    //   310: iload 12
    //   312: istore 11
    //   314: aload 20
    //   316: iload 8
    //   318: invokeinterface 638 2 0
    //   323: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   326: astore 22
    //   328: iload 4
    //   330: istore 6
    //   332: aload 22
    //   334: ifnull +964 -> 1298
    //   337: iload 4
    //   339: istore 5
    //   341: aload 18
    //   343: astore 19
    //   345: iload 12
    //   347: istore 11
    //   349: aload 22
    //   351: getfield 2272	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   354: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   357: lstore 16
    //   359: lload 16
    //   361: lload 14
    //   363: lcmp
    //   364: ifeq +82 -> 446
    //   367: iload 8
    //   369: iconst_1
    //   370: iadd
    //   371: istore 8
    //   373: goto -82 -> 291
    //   376: astore_3
    //   377: aconst_null
    //   378: astore_1
    //   379: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq +33 -> 415
    //   385: ldc_w 2296
    //   388: iconst_2
    //   389: new 166	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 6664
    //   399: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload_3
    //   403: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   406: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload_3
    //   416: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   419: goto -312 -> 107
    //   422: iload 4
    //   424: istore 5
    //   426: aload 18
    //   428: astore 19
    //   430: iload 12
    //   432: istore 11
    //   434: aload 20
    //   436: invokeinterface 565 1 0
    //   441: istore 7
    //   443: goto +877 -> 1320
    //   446: iload 4
    //   448: istore 5
    //   450: aload 18
    //   452: astore 19
    //   454: iload 12
    //   456: istore 11
    //   458: aload 22
    //   460: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   463: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   466: istore 4
    //   468: iload 4
    //   470: istore 6
    //   472: iload 4
    //   474: ifne +824 -> 1298
    //   477: iload 4
    //   479: istore 5
    //   481: aload 18
    //   483: astore 19
    //   485: iload 12
    //   487: istore 11
    //   489: iload 4
    //   491: istore 6
    //   493: aload 22
    //   495: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   498: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   501: ifeq +797 -> 1298
    //   504: iload 4
    //   506: istore 5
    //   508: aload 18
    //   510: astore 19
    //   512: iload 12
    //   514: istore 11
    //   516: aload 22
    //   518: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   521: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   524: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   527: astore_3
    //   528: goto -161 -> 367
    //   531: aload_3
    //   532: ifnull +758 -> 1290
    //   535: iconst_1
    //   536: istore 13
    //   538: iconst_1
    //   539: istore 12
    //   541: iload 4
    //   543: istore 5
    //   545: aload 18
    //   547: astore 19
    //   549: iload 13
    //   551: istore 11
    //   553: aload_0
    //   554: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   557: bipush 51
    //   559: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   562: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   565: astore 20
    //   567: iload 4
    //   569: istore 5
    //   571: aload 18
    //   573: astore 19
    //   575: iload 13
    //   577: istore 11
    //   579: aload 20
    //   581: lload 14
    //   583: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   586: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   589: astore 18
    //   591: aload 18
    //   593: ifnonnull +694 -> 1287
    //   596: iload 4
    //   598: istore 5
    //   600: aload 18
    //   602: astore 19
    //   604: iload 13
    //   606: istore 11
    //   608: new 511	com/tencent/mobileqq/data/TroopInfo
    //   611: dup
    //   612: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   615: astore 18
    //   617: aload 18
    //   619: lload 14
    //   621: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   624: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   627: aload_3
    //   628: getfield 4109	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   631: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   634: ifeq +53 -> 687
    //   637: aload 18
    //   639: aload_3
    //   640: getfield 4109	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   643: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   646: i2l
    //   647: putfield 1329	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   650: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq +34 -> 687
    //   656: ldc_w 2296
    //   659: iconst_2
    //   660: new 166	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   667: ldc_w 6666
    //   670: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload 18
    //   675: getfield 1329	com/tencent/mobileqq/data/TroopInfo:troopCreateTime	J
    //   678: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   681: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: aload_3
    //   688: getfield 3035	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   691: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   694: ifeq +62 -> 756
    //   697: aload 18
    //   699: aload_3
    //   700: getfield 3035	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_member_num	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   703: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   706: putfield 1232	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   709: aload 18
    //   711: aload 18
    //   713: getfield 1232	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   716: putfield 1729	com/tencent/mobileqq/data/TroopInfo:wMemberNumClient	I
    //   719: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   722: ifeq +34 -> 756
    //   725: ldc_w 2296
    //   728: iconst_2
    //   729: new 166	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 6668
    //   739: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 18
    //   744: getfield 1232	com/tencent/mobileqq/data/TroopInfo:wMemberNum	I
    //   747: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   750: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: aload_3
    //   757: getfield 4066	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   760: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   763: ifeq +18 -> 781
    //   766: aload 18
    //   768: aload_3
    //   769: getfield 4066	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   772: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   775: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   778: putfield 1307	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   781: aload_3
    //   782: getfield 4073	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   785: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   788: ifeq +18 -> 806
    //   791: aload 18
    //   793: aload_3
    //   794: getfield 4073	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   797: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   800: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   803: putfield 1313	com/tencent/mobileqq/data/TroopInfo:joinTroopAnswer	Ljava/lang/String;
    //   806: aload_3
    //   807: getfield 4112	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   810: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   813: ifeq +16 -> 829
    //   816: aload 18
    //   818: aload_3
    //   819: getfield 4112	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   822: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   825: i2l
    //   826: putfield 1239	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   829: aload_3
    //   830: getfield 4115	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   833: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   836: ifeq +15 -> 851
    //   839: aload 18
    //   841: aload_3
    //   842: getfield 4115	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   845: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   848: putfield 1687	com/tencent/mobileqq/data/TroopInfo:troopTypeExt	I
    //   851: aload_3
    //   852: getfield 4076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   855: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   858: ifeq +29 -> 887
    //   861: aload 18
    //   863: aload_3
    //   864: getfield 4076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   867: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   870: i2l
    //   871: putfield 1699	com/tencent/mobileqq/data/TroopInfo:dwAppPrivilegeFlag	J
    //   874: aload 18
    //   876: aload_3
    //   877: getfield 4076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   880: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   883: i2l
    //   884: putfield 1702	com/tencent/mobileqq/data/TroopInfo:troopPrivilegeFlag	J
    //   887: aload_3
    //   888: getfield 4062	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   891: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   894: ifeq +16 -> 910
    //   897: aload 18
    //   899: aload_3
    //   900: getfield 4062	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   903: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   906: i2s
    //   907: putfield 1226	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   910: aload_3
    //   911: getfield 2306	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   914: invokevirtual 286	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   917: ifeq +34 -> 951
    //   920: aload 18
    //   922: new 166	java/lang/StringBuilder
    //   925: dup
    //   926: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   929: ldc_w 368
    //   932: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: aload_3
    //   936: getfield 2306	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   939: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   942: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   945: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   948: putfield 1211	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   951: aload 18
    //   953: invokevirtual 3055	com/tencent/mobileqq/data/TroopInfo:isNewTroop	()Z
    //   956: ifeq +208 -> 1164
    //   959: aload 18
    //   961: aload_3
    //   962: getfield 4118	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_auto_agree_join_group_user_num_for_conf_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   965: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   968: putfield 6671	com/tencent/mobileqq/data/TroopInfo:maxInviteMemNum	I
    //   971: aload 20
    //   973: aload 18
    //   975: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   978: aload 18
    //   980: astore_3
    //   981: iconst_1
    //   982: istore 11
    //   984: iload 11
    //   986: istore 12
    //   988: aload_3
    //   989: astore 20
    //   991: iload 4
    //   993: istore 5
    //   995: aload_1
    //   996: astore 19
    //   998: aload_0
    //   999: bipush 18
    //   1001: iload 12
    //   1003: bipush 7
    //   1005: anewarray 103	java/lang/Object
    //   1008: dup
    //   1009: iconst_0
    //   1010: lload 14
    //   1012: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1015: aastore
    //   1016: dup
    //   1017: iconst_1
    //   1018: iload 9
    //   1020: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1023: aastore
    //   1024: dup
    //   1025: iconst_2
    //   1026: aload 20
    //   1028: aastore
    //   1029: dup
    //   1030: iconst_3
    //   1031: iload 5
    //   1033: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1036: aastore
    //   1037: dup
    //   1038: iconst_4
    //   1039: aload 19
    //   1041: aastore
    //   1042: dup
    //   1043: iconst_5
    //   1044: iload 10
    //   1046: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1049: aastore
    //   1050: dup
    //   1051: bipush 6
    //   1053: aload 21
    //   1055: aastore
    //   1056: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1059: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1062: ifeq +101 -> 1163
    //   1065: new 166	java/lang/StringBuilder
    //   1068: dup
    //   1069: sipush 150
    //   1072: invokespecial 3798	java/lang/StringBuilder:<init>	(I)V
    //   1075: astore_1
    //   1076: aload_1
    //   1077: ldc_w 6673
    //   1080: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: ldc_w 6634
    //   1086: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: iload 12
    //   1091: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1094: ldc_w 6636
    //   1097: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: aload_2
    //   1101: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1104: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1107: ldc_w 3802
    //   1110: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: lload 14
    //   1115: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1118: ldc_w 3804
    //   1121: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: iload 9
    //   1126: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1129: ldc_w 6640
    //   1132: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1135: iload 5
    //   1137: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1140: ldc_w 6642
    //   1143: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1146: aload 19
    //   1148: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: ldc_w 2296
    //   1155: iconst_2
    //   1156: aload_1
    //   1157: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1160: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1163: return
    //   1164: aload 18
    //   1166: aload_3
    //   1167: getfield 4121	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_auto_agree_join_group_user_num_for_normal_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1170: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1173: putfield 6671	com/tencent/mobileqq/data/TroopInfo:maxInviteMemNum	I
    //   1176: goto -205 -> 971
    //   1179: astore 19
    //   1181: aload 18
    //   1183: astore_3
    //   1184: aload 19
    //   1186: astore 18
    //   1188: iload 12
    //   1190: istore 11
    //   1192: aload_1
    //   1193: astore 19
    //   1195: iload 4
    //   1197: istore 5
    //   1199: aload_3
    //   1200: astore 20
    //   1202: iload 11
    //   1204: istore 12
    //   1206: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1209: ifeq -211 -> 998
    //   1212: ldc_w 2296
    //   1215: iconst_2
    //   1216: aload 18
    //   1218: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   1221: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1224: aload_1
    //   1225: astore 19
    //   1227: iload 4
    //   1229: istore 5
    //   1231: aload_3
    //   1232: astore 20
    //   1234: iload 11
    //   1236: istore 12
    //   1238: goto -240 -> 998
    //   1241: astore 18
    //   1243: aconst_null
    //   1244: astore_1
    //   1245: aload 19
    //   1247: astore_3
    //   1248: iload 13
    //   1250: istore 11
    //   1252: goto -60 -> 1192
    //   1255: astore 18
    //   1257: iload 5
    //   1259: istore 4
    //   1261: aload 19
    //   1263: astore_3
    //   1264: goto -72 -> 1192
    //   1267: astore 19
    //   1269: aload 18
    //   1271: astore_3
    //   1272: aload 19
    //   1274: astore 18
    //   1276: iload 12
    //   1278: istore 11
    //   1280: goto -88 -> 1192
    //   1283: astore_3
    //   1284: goto -905 -> 379
    //   1287: goto -660 -> 627
    //   1290: aconst_null
    //   1291: astore_3
    //   1292: iconst_0
    //   1293: istore 11
    //   1295: goto -311 -> 984
    //   1298: iload 6
    //   1300: istore 4
    //   1302: goto -935 -> 367
    //   1305: aconst_null
    //   1306: astore_1
    //   1307: goto -1051 -> 256
    //   1310: aconst_null
    //   1311: astore 19
    //   1313: iload 11
    //   1315: istore 12
    //   1317: goto -319 -> 998
    //   1320: iconst_0
    //   1321: istore 8
    //   1323: goto -1032 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1326	0	this	TroopHandler
    //   0	1326	1	paramToServiceMsg	ToServiceMsg
    //   0	1326	2	paramFromServiceMsg	FromServiceMsg
    //   0	1326	3	paramObject	Object
    //   66	1235	4	i	int
    //   70	1188	5	j	int
    //   330	969	6	k	int
    //   286	156	7	m	int
    //   295	1027	8	n	int
    //   40	1085	9	i1	int
    //   51	994	10	i2	int
    //   7	1307	11	bool1	boolean
    //   4	1312	12	bool2	boolean
    //   1	1248	13	bool3	boolean
    //   28	1086	14	l1	long
    //   357	3	16	l2	long
    //   13	1204	18	localObject1	Object
    //   1241	1	18	localException1	Exception
    //   1255	15	18	localException2	Exception
    //   1274	1	18	localException3	Exception
    //   10	1137	19	localObject2	Object
    //   1179	6	19	localException4	Exception
    //   1193	69	19	localToServiceMsg	ToServiceMsg
    //   1267	6	19	localException5	Exception
    //   1311	1	19	localObject3	Object
    //   16	1217	20	localObject4	Object
    //   63	991	21	str	String
    //   326	191	22	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    // Exception table:
    //   from	to	target	type
    //   82	90	376	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   627	687	1179	java/lang/Exception
    //   687	756	1179	java/lang/Exception
    //   756	781	1179	java/lang/Exception
    //   781	806	1179	java/lang/Exception
    //   806	829	1179	java/lang/Exception
    //   829	851	1179	java/lang/Exception
    //   851	887	1179	java/lang/Exception
    //   887	910	1179	java/lang/Exception
    //   910	951	1179	java/lang/Exception
    //   951	971	1179	java/lang/Exception
    //   971	978	1179	java/lang/Exception
    //   1164	1176	1179	java/lang/Exception
    //   209	225	1241	java/lang/Exception
    //   230	256	1241	java/lang/Exception
    //   270	280	1255	java/lang/Exception
    //   314	328	1255	java/lang/Exception
    //   349	359	1255	java/lang/Exception
    //   434	443	1255	java/lang/Exception
    //   458	468	1255	java/lang/Exception
    //   493	504	1255	java/lang/Exception
    //   516	528	1255	java/lang/Exception
    //   553	567	1255	java/lang/Exception
    //   579	591	1255	java/lang/Exception
    //   608	617	1255	java/lang/Exception
    //   617	627	1267	java/lang/Exception
    //   90	105	1283	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void j(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.GroupMngReq");
    localToServiceMsg.extraData.putInt("groupreqtype", 9);
    localToServiceMsg.extraData.putString("troop_uin", paramString);
    localToServiceMsg.extraData.putString("uin", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    a(localToServiceMsg);
    v(paramString);
  }
  
  public void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    int k = paramToServiceMsg.extraData.getInt("subCmd");
    if (paramFromServiceMsg.getResultCode() == 1000) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x8b8_1|oidb_sso.OIDBSSOPkg.result " + i);
        }
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramObject = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          try
          {
            paramToServiceMsg = new oidb_0x8b8.RspBody();
            paramToServiceMsg.mergeFrom(paramObject);
            i = -1;
            if (paramToServiceMsg.uint32_result.has())
            {
              int j = paramToServiceMsg.uint32_result.get();
              i = j;
              if (j == 0)
              {
                i = j;
                bool = true;
                paramObject = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                localTroopInfo = paramObject.a(String.valueOf(l));
                localArrayList = new ArrayList();
                Iterator localIterator = paramToServiceMsg.rpt_uint32_pic_list.get().iterator();
                if (localIterator.hasNext())
                {
                  j = ((Integer)localIterator.next()).intValue();
                  if (j < 0) {
                    continue;
                  }
                  localArrayList.add(String.valueOf(j));
                  continue;
                  return;
                }
              }
            }
          }
          catch (Exception paramToServiceMsg)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        int i;
        TroopInfo localTroopInfo;
        ArrayList localArrayList;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.troopdisband.", 2, "handle_oidb_0x8b8_1|oidb_sso parseFrom byte " + paramObject.toString());
        continue;
        if (localTroopInfo != null)
        {
          localTroopInfo.mTroopAvatarId = paramToServiceMsg.uint32_default_id.get();
          localTroopInfo.mTroopPicList = localArrayList;
          paramObject.b(localTroopInfo);
        }
        a(47, bool, new Object[] { String.valueOf(l), Integer.valueOf(i), null, Integer.valueOf(k), localArrayList });
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramToServiceMsg = new StringBuilder(150);
        paramToServiceMsg.append("handle_oidb_0x8b8_1").append("|isSuccess = ").append(bool).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l).append("|result = ").append(i).append("|strErrorMsg = ").append(null);
        QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        return;
      }
      boolean bool = false;
    }
  }
  
  public void k(String paramString)
  {
    a(paramString, 0);
  }
  
  public void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool4 = false;
    boolean bool3 = false;
    bool1 = false;
    localObject1 = null;
    Object localObject10 = null;
    localObject9 = null;
    Object localObject8 = null;
    Object localObject11 = null;
    n = -1;
    l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i2 = paramToServiceMsg.extraData.getInt("nFlag");
    localException5 = null;
    Object localObject12 = null;
    i = -1;
    localObject6 = localObject10;
    j = i;
    localObject7 = localObject12;
    m = n;
    Object localObject3 = localObject11;
    bool2 = bool1;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
        }
        j = i;
        localObject3 = localObject8;
        bool1 = bool3;
        m = ((List)localObject6).size();
      }
      if (paramToServiceMsg != null)
      {
        j = paramToServiceMsg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_7|oidb_sso.OIDBSSOPkg.result " + j);
          i = j;
        }
      }
      localObject6 = localObject10;
      j = i;
      localObject7 = localObject12;
      m = n;
      localObject3 = localObject11;
      bool2 = bool1;
      if (paramToServiceMsg != null)
      {
        localObject6 = localObject10;
        j = i;
        localObject7 = localObject12;
        m = n;
        localObject3 = localObject11;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.has())
        {
          localObject6 = localObject10;
          j = i;
          localObject7 = localObject12;
          m = n;
          localObject3 = localObject11;
          bool2 = bool1;
          if (paramToServiceMsg.bytes_bodybuffer.get() != null) {
            paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
          }
        }
      }
    }
    try
    {
      paramObject = new oidb_0x88d.RspBody();
      paramObject.mergeFrom(paramToServiceMsg);
      if ((i == 0) || (!paramObject.str_errorinfo.has())) {
        break label1247;
      }
      paramToServiceMsg = String.valueOf(paramObject.str_errorinfo.get().toByteArray());
    }
    catch (Exception localException3)
    {
      for (;;)
      {
        int i1;
        bool1 = bool4;
        paramObject = localObject9;
        k = n;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        localObject1 = localException3;
        localObject6 = paramToServiceMsg;
        j = i;
        localObject7 = localException5;
        m = k;
        localObject4 = paramObject;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troopdisband.", 2, ((Exception)localObject1).toString());
          localObject6 = paramToServiceMsg;
          j = i;
          localObject7 = localException5;
          m = k;
          localObject4 = paramObject;
          bool2 = bool1;
          continue;
          a(46, bool2, new Object[] { String.valueOf(l1), Integer.valueOf(j), localObject6, Integer.valueOf(m), localObject7 });
          continue;
          paramToServiceMsg = null;
          continue;
          i1 = 0;
        }
      }
    }
    localObject1 = null;
    j = i;
    localObject3 = localObject8;
    bool1 = bool3;
    try
    {
      localObject6 = paramObject.stzrspgroupinfo.get();
      if (localObject6 != null) {
        break label492;
      }
      m = 0;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        long l2;
        label492:
        i = j;
        int k = n;
        paramObject = localObject4;
        continue;
        paramObject = null;
        j = -1;
        Object localObject2 = null;
        bool1 = false;
        continue;
        paramObject = localObject2;
        i = k;
      }
    }
    if ((localObject1 == null) && (i1 < m))
    {
      j = i;
      localObject3 = localObject8;
      bool1 = bool3;
      paramObject = (oidb_0x88d.RspGroupInfo)((List)localObject6).get(i1);
      k = i;
      if (paramObject != null)
      {
        j = i;
        localObject3 = localObject8;
        bool1 = bool3;
        l2 = paramObject.uint64_group_code.get();
        if (l2 != l1) {}
        for (paramObject = localObject1;; paramObject = (oidb_0x88d.GroupInfo)paramObject.stgroupinfo.get())
        {
          i1 += 1;
          localObject1 = paramObject;
          break;
          j = i;
          localObject3 = localObject8;
          bool1 = bool3;
          i = paramObject.uint32_result.get();
          k = i;
          if (i != 0) {
            break label1237;
          }
          j = i;
          localObject3 = localObject8;
          bool1 = bool3;
          k = i;
          if (!paramObject.stgroupinfo.has()) {
            break label1237;
          }
          j = i;
          localObject3 = localObject8;
          bool1 = bool3;
        }
      }
    }
    else if (localObject1 != null)
    {
      bool3 = true;
      bool2 = true;
      j = i;
      localObject3 = localObject8;
      bool1 = bool3;
      localObject6 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
      j = i;
      localObject3 = localObject8;
      bool1 = bool3;
      paramObject = ((TroopManager)localObject6).a(String.valueOf(l1));
      j = i;
      localObject3 = paramObject;
      bool1 = bool3;
      if (((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait.has())
      {
        j = i;
        localObject3 = paramObject;
        bool1 = bool3;
        if (((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.has())
        {
          j = i;
          localObject3 = paramObject;
          bool1 = bool3;
          localObject7 = ((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait;
          j = i;
          localObject3 = paramObject;
          bool1 = bool3;
          k = ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.get();
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = TroopInfo.setAvatarPicId((oidb_0x88d.GroupHeadPortrait)localObject7);
        }
        catch (Exception localException2)
        {
          Object localObject4;
          bool1 = bool2;
          continue;
        }
        try
        {
          localObject3 = TroopInfo.setVerifyingAvatarPicId((oidb_0x88d.GroupHeadPortrait)localObject7);
          if (paramObject != null)
          {
            paramObject.mTroopPicList = ((List)localObject1);
            paramObject.mTroopVerifyingPics = ((Set)localObject3);
            ((TroopManager)localObject6).b(paramObject);
          }
          localObject3 = localObject1;
          bool1 = true;
          j = k;
          localObject1 = paramObject;
          paramObject = localObject3;
        }
        catch (Exception localException4)
        {
          localException5 = localException2;
          localObject2 = localException4;
          bool1 = bool2;
          continue;
          Object localObject5 = null;
          j = -1;
          localObject2 = paramObject;
          bool1 = true;
          paramObject = localObject5;
          continue;
        }
        bool2 = bool1;
        localObject3 = localObject1;
        m = j;
        localObject7 = paramObject;
        j = i;
        localObject6 = paramToServiceMsg;
        if (localObject3 == null) {
          continue;
        }
        a(46, bool2, new Object[] { String.valueOf(l1), Integer.valueOf(j), localObject6, Integer.valueOf(m), null });
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder(150);
          paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool2).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|seq = ").append(i2).append("|result = ").append(j).append("|strErrorMsg = ").append((String)localObject6);
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        }
        return;
        j = i;
        localObject3 = paramObject;
        bool1 = bool3;
        if (!((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.has()) {
          break label1205;
        }
        j = i;
        localObject3 = paramObject;
        bool1 = bool3;
        k = ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.get();
        j = k;
        localObject1 = paramObject;
        paramObject = null;
        bool1 = true;
      }
    }
  }
  
  public void l(String paramString)
  {
    Object localObject1 = new oidb_0x88d.ReqBody();
    ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(0);
    Object localObject2 = new oidb_0x88d.ReqGroupInfo();
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(BizTroopHandler.a(paramString));
    ((oidb_0x88d.ReqGroupInfo)localObject2).uint32_last_get_group_name_time.set(0);
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.uint32_group_member_max_num.set(0);
    localGroupInfo.uint32_active_member_num.set(0);
    ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set(localGroupInfo);
    ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
    localObject1 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x88d_1");
    ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject1).extraData.putInt("subCmd", 5);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i1 = paramToServiceMsg.extraData.getInt("nFlag");
    int i = -1;
    int j;
    Object localObject3;
    Object localObject4;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
        }
        j = i;
        bool1 = bool2;
        m = ((List)localObject1).size();
      }
      if (paramToServiceMsg != null)
      {
        j = paramToServiceMsg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + j);
          i = j;
        }
      }
      localObject3 = null;
      localObject4 = null;
      if ((i == 0) && (paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    else
    {
      try
      {
        localObject1 = new oidb_0x88d.RspBody();
        ((oidb_0x88d.RspBody)localObject1).mergeFrom(paramToServiceMsg);
        if ((i == 0) || (!((oidb_0x88d.RspBody)localObject1).str_errorinfo.has())) {
          break label864;
        }
        paramToServiceMsg = String.valueOf(((oidb_0x88d.RspBody)localObject1).str_errorinfo.get().toByteArray());
      }
      catch (Exception paramObject)
      {
        for (;;)
        {
          try
          {
            if (!TextUtils.isEmpty(paramObject))
            {
              ((TroopInfo)localObject4).mTags = paramObject;
              ((TroopManager)localObject1).b((TroopInfo)localObject4);
            }
            bool1 = true;
            bool2 = bool1;
            localObject4 = paramObject;
            j = i;
            localObject1 = paramToServiceMsg;
            a(32, bool2, new Object[] { Long.valueOf(l1), Integer.valueOf(i1), localObject4, Integer.valueOf(j), localObject1 });
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder(150);
              paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool2).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|flag = ").append(i1).append("|result = ").append(j).append("|strErrorMsg = ").append((String)localObject1);
              QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
            }
            return;
          }
          catch (Exception localException)
          {
            Object localObject1;
            localObject3 = paramObject;
            paramObject = localException;
            bool1 = bool2;
            continue;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          bool1 = bool3;
          localObject1 = paramToServiceMsg;
          j = i;
          localObject4 = localObject3;
          bool2 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("Q.troopdisband.", 2, paramObject.toString());
            localObject1 = paramToServiceMsg;
            j = i;
            localObject4 = localObject3;
            bool2 = bool1;
            continue;
            paramToServiceMsg = null;
          }
        }
      }
      paramObject = null;
      j = i;
      bool1 = bool2;
    }
    for (;;)
    {
      try
      {
        localObject1 = ((oidb_0x88d.RspBody)localObject1).stzrspgroupinfo.get();
        if (localObject1 != null) {
          continue;
        }
        m = 0;
      }
      catch (Exception paramObject)
      {
        int m;
        int k;
        long l2;
        i = j;
        continue;
        paramObject = null;
        continue;
        paramObject = null;
        bool1 = false;
        continue;
        i = k;
        continue;
      }
      if ((paramObject == null) && (n < m))
      {
        j = i;
        bool1 = bool2;
        localObject4 = (oidb_0x88d.RspGroupInfo)((List)localObject1).get(n);
        k = i;
        if (localObject4 != null)
        {
          j = i;
          bool1 = bool2;
          l2 = ((oidb_0x88d.RspGroupInfo)localObject4).uint64_group_code.get();
          if (l2 != l1)
          {
            n += 1;
            continue;
          }
          j = i;
          bool1 = bool2;
          i = ((oidb_0x88d.RspGroupInfo)localObject4).uint32_result.get();
          k = i;
          if (i == 0)
          {
            j = i;
            bool1 = bool2;
            k = i;
            if (((oidb_0x88d.RspGroupInfo)localObject4).stgroupinfo.has())
            {
              j = i;
              bool1 = bool2;
              paramObject = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject4).stgroupinfo.get();
              continue;
            }
          }
        }
      }
      else if (paramObject != null)
      {
        bool3 = true;
        bool2 = true;
        j = i;
        bool1 = bool3;
        localObject1 = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
        j = i;
        bool1 = bool3;
        localObject4 = ((TroopManager)localObject1).a(String.valueOf(l1));
        j = i;
        bool1 = bool3;
        if (paramObject.rpt_tag_record.has())
        {
          j = i;
          bool1 = bool3;
          if (paramObject.rpt_tag_record.size() > 0)
          {
            j = i;
            bool1 = bool3;
            paramObject = TroopInfo.setTags(paramObject.rpt_tag_record.get());
            if (localObject4 == null) {}
          }
        }
      }
      label864:
      Object localObject2 = null;
      j = i;
      bool2 = bool1;
      continue;
      int n = 0;
    }
  }
  
  public void m(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, "getTroopMemberListBy0x787 uin=" + paramString);
    }
    try
    {
      long l = Long.parseLong(paramString);
      Object localObject = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject).uint64_group_code.set(l);
      ((oidb_0x787.ReqBody)localObject).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject).uint64_data_time.set(0L);
      oidb_0x787.Filter localFilter = new oidb_0x787.Filter();
      localFilter.uint32_member_level_info_uin.set(1);
      localFilter.uint32_member_level_info_name.set(1);
      localFilter.uint32_nick_name.set(1);
      ((oidb_0x787.ReqBody)localObject).opt_filter.set(localFilter);
      localObject = a("OidbSvc.0x787_11", 1927, 11, ((oidb_0x787.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  public void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1384
    //   7: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   10: lstore 9
    //   12: aload_1
    //   13: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 5028
    //   19: invokevirtual 136	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 14
    //   24: aload_1
    //   25: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   28: ldc_w 5030
    //   31: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   34: istore 6
    //   36: aload_1
    //   37: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   40: ldc_w 5032
    //   43: invokevirtual 136	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   46: astore 16
    //   48: lload 9
    //   50: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: astore 17
    //   55: aload_1
    //   56: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   59: ldc_w 2289
    //   62: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   65: pop
    //   66: aload_2
    //   67: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   70: sipush 1000
    //   73: if_icmpne +1305 -> 1378
    //   76: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   79: dup
    //   80: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   83: astore_1
    //   84: aload_1
    //   85: aload_3
    //   86: checkcast 151	[B
    //   89: checkcast 151	[B
    //   92: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   95: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   98: astore_2
    //   99: aload_2
    //   100: astore_1
    //   101: aload_1
    //   102: ifnull +1257 -> 1359
    //   105: aload_1
    //   106: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   109: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   112: istore 5
    //   114: iload 5
    //   116: istore 4
    //   118: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   121: ifeq +35 -> 156
    //   124: ldc_w 2296
    //   127: iconst_2
    //   128: new 166	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   135: ldc_w 6662
    //   138: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload 5
    //   143: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iload 5
    //   154: istore 4
    //   156: iload 4
    //   158: ifne +1220 -> 1378
    //   161: aload_1
    //   162: ifnull +1216 -> 1378
    //   165: aload_1
    //   166: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   169: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   172: ifeq +1206 -> 1378
    //   175: aload_1
    //   176: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   179: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   182: ifnull +1196 -> 1378
    //   185: aload_1
    //   186: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   195: astore_1
    //   196: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   199: dup
    //   200: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   203: astore_2
    //   204: aload_2
    //   205: aload_1
    //   206: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   209: pop
    //   210: iload 4
    //   212: ifeq +27 -> 239
    //   215: aload_2
    //   216: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   219: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   222: ifeq +17 -> 239
    //   225: aload_2
    //   226: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   238: pop
    //   239: aconst_null
    //   240: astore_1
    //   241: aload_2
    //   242: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   245: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   248: astore_2
    //   249: aload_2
    //   250: ifnonnull +106 -> 356
    //   253: iconst_0
    //   254: istore 4
    //   256: goto +1109 -> 1365
    //   259: aload_1
    //   260: ifnonnull +141 -> 401
    //   263: iload 5
    //   265: iload 4
    //   267: if_icmpge +134 -> 401
    //   270: aload_2
    //   271: iload 5
    //   273: invokeinterface 638 2 0
    //   278: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   281: astore_3
    //   282: aload_3
    //   283: ifnull +1073 -> 1356
    //   286: aload_3
    //   287: getfield 2272	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   290: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   293: lstore 7
    //   295: lload 7
    //   297: lload 9
    //   299: lcmp
    //   300: ifeq +67 -> 367
    //   303: iload 5
    //   305: iconst_1
    //   306: iadd
    //   307: istore 5
    //   309: goto -50 -> 259
    //   312: astore_2
    //   313: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   316: ifeq +33 -> 349
    //   319: ldc_w 2296
    //   322: iconst_2
    //   323: new 166	java/lang/StringBuilder
    //   326: dup
    //   327: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   330: ldc_w 6664
    //   333: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: aload_2
    //   337: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   340: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   349: aload_2
    //   350: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   353: goto -252 -> 101
    //   356: aload_2
    //   357: invokeinterface 565 1 0
    //   362: istore 4
    //   364: goto +1001 -> 1365
    //   367: aload_3
    //   368: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   371: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   374: ifne +982 -> 1356
    //   377: aload_3
    //   378: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   381: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   384: ifeq +972 -> 1356
    //   387: aload_3
    //   388: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   391: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   394: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   397: astore_1
    //   398: goto -95 -> 303
    //   401: aload_1
    //   402: ifnull +976 -> 1378
    //   405: aload_0
    //   406: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   409: bipush 51
    //   411: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   414: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   417: astore 15
    //   419: aload 15
    //   421: aload 17
    //   423: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   426: astore_3
    //   427: aload_3
    //   428: ifnull +951 -> 1379
    //   431: iconst_1
    //   432: istore 13
    //   434: aload_3
    //   435: ifnonnull +918 -> 1353
    //   438: new 511	com/tencent/mobileqq/data/TroopInfo
    //   441: dup
    //   442: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   445: astore_3
    //   446: aload_3
    //   447: aload 17
    //   449: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   452: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +13 -> 468
    //   458: ldc_w 6726
    //   461: iconst_2
    //   462: ldc_w 6728
    //   465: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   468: aload_1
    //   469: getfield 2301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   472: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   475: ifeq +15 -> 490
    //   478: aload_3
    //   479: aload_1
    //   480: getfield 2301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   483: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   486: i2l
    //   487: putfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   490: aload_1
    //   491: getfield 5025	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_cmduin_join_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   494: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   497: ifeq +881 -> 1378
    //   500: aload_3
    //   501: aload_1
    //   502: getfield 5025	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_cmduin_join_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   505: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   508: i2l
    //   509: putfield 1694	com/tencent/mobileqq/data/TroopInfo:dwCmdUinJoinTime	J
    //   512: aload_1
    //   513: getfield 5025	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_cmduin_join_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   516: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   519: i2l
    //   520: lstore 11
    //   522: aload 15
    //   524: aload_3
    //   525: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   528: invokevirtual 6730	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;)J
    //   531: lstore 7
    //   533: aload_1
    //   534: getfield 5022	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_cmduin_join_msg_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   537: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   540: istore 4
    //   542: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   545: ifeq +826 -> 1371
    //   548: ldc_w 6726
    //   551: iconst_2
    //   552: new 166	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 6732
    //   562: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: lload 11
    //   567: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   570: ldc_w 6734
    //   573: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: iload 13
    //   578: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   581: ldc_w 6736
    //   584: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: lload 7
    //   589: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   592: ldc_w 6738
    //   595: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 4
    //   600: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   603: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: goto +762 -> 1371
    //   612: iload 4
    //   614: ifle +609 -> 1223
    //   617: sipush -4012
    //   620: invokestatic 5752	com/tencent/mobileqq/service/message/MessageRecordFactory:a	(I)Lcom/tencent/mobileqq/data/MessageRecord;
    //   623: checkcast 6740	com/tencent/mobileqq/data/MessageForSplitLineTips
    //   626: astore_1
    //   627: aload_1
    //   628: aload_0
    //   629: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   632: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   635: aload_3
    //   636: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   639: aload_0
    //   640: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   643: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   646: ldc_w 6742
    //   649: lload 11
    //   651: sipush -4012
    //   654: iconst_1
    //   655: lload 11
    //   657: invokevirtual 6743	com/tencent/mobileqq/data/MessageForSplitLineTips:init	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIIJ)V
    //   660: aload_1
    //   661: iload 4
    //   663: iconst_1
    //   664: iadd
    //   665: i2l
    //   666: putfield 6744	com/tencent/mobileqq/data/MessageForSplitLineTips:shmsgseq	J
    //   669: aload_1
    //   670: iconst_1
    //   671: putfield 6747	com/tencent/mobileqq/data/MessageForSplitLineTips:isread	Z
    //   674: aload_1
    //   675: iconst_0
    //   676: putfield 6750	com/tencent/mobileqq/data/MessageForSplitLineTips:mNeedTimeStamp	Z
    //   679: aload_1
    //   680: ldc_w 6742
    //   683: putfield 6753	com/tencent/mobileqq/data/MessageForSplitLineTips:msgContent	Ljava/lang/String;
    //   686: aload_1
    //   687: iconst_1
    //   688: putfield 6756	com/tencent/mobileqq/data/MessageForSplitLineTips:subType	I
    //   691: aload_0
    //   692: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   695: invokevirtual 1152	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   698: aload_1
    //   699: aload_0
    //   700: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   703: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   706: invokevirtual 5777	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   709: aload_3
    //   710: invokevirtual 6759	com/tencent/mobileqq/data/TroopInfo:isHomeworkTroop	()Z
    //   713: ifne +614 -> 1327
    //   716: aload_0
    //   717: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   720: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   723: ldc_w 6760
    //   726: invokevirtual 6761	com/tencent/qphone/base/util/BaseApplication:getString	(I)Ljava/lang/String;
    //   729: astore_1
    //   730: new 6763	com/tencent/mobileqq/graytip/UniteGrayTipParam
    //   733: dup
    //   734: lload 9
    //   736: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   739: lload 9
    //   741: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   744: aload_1
    //   745: iconst_1
    //   746: sipush -5021
    //   749: ldc_w 6764
    //   752: lload 11
    //   754: invokespecial 6767	com/tencent/mobileqq/graytip/UniteGrayTipParam:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIIJ)V
    //   757: astore 17
    //   759: aload 14
    //   761: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   764: ifne +186 -> 950
    //   767: aload_0
    //   768: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   771: aload 14
    //   773: lload 9
    //   775: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   778: invokestatic 6769	com/tencent/mobileqq/app/MessageHandlerUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   781: astore_2
    //   782: aconst_null
    //   783: astore_1
    //   784: iload 6
    //   786: iconst_1
    //   787: if_icmpne +473 -> 1260
    //   790: aload_0
    //   791: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   794: bipush 51
    //   796: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   799: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   802: astore 18
    //   804: aload 18
    //   806: ifnull +11 -> 817
    //   809: aload 18
    //   811: aload 16
    //   813: invokevirtual 6770	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   816: astore_1
    //   817: aload_2
    //   818: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   821: ifne +12 -> 833
    //   824: aload_2
    //   825: aload 14
    //   827: invokevirtual 860	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   830: ifeq +520 -> 1350
    //   833: aload 18
    //   835: aload 16
    //   837: aload 14
    //   839: invokevirtual 6773	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   842: astore 16
    //   844: aload 16
    //   846: ifnull +504 -> 1350
    //   849: aload 16
    //   851: getfield 651	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   854: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   857: ifne +493 -> 1350
    //   860: aload 16
    //   862: getfield 651	com/tencent/mobileqq/data/TroopMemberInfo:friendnick	Ljava/lang/String;
    //   865: astore_2
    //   866: goto +519 -> 1385
    //   869: aload_1
    //   870: invokestatic 592	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   873: ifne +429 -> 1302
    //   876: ldc_w 6775
    //   879: iconst_2
    //   880: anewarray 103	java/lang/Object
    //   883: dup
    //   884: iconst_0
    //   885: aload_2
    //   886: aastore
    //   887: dup
    //   888: iconst_1
    //   889: aload_1
    //   890: aastore
    //   891: invokestatic 5143	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   894: astore_1
    //   895: aload 17
    //   897: aload_1
    //   898: putfield 6776	com/tencent/mobileqq/graytip/UniteGrayTipParam:c	Ljava/lang/String;
    //   901: new 124	android/os/Bundle
    //   904: dup
    //   905: invokespecial 6777	android/os/Bundle:<init>	()V
    //   908: astore 16
    //   910: aload 16
    //   912: ldc_w 6779
    //   915: iconst_5
    //   916: invokevirtual 1948	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   919: aload 16
    //   921: ldc_w 6781
    //   924: aload 14
    //   926: invokevirtual 2152	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   929: aload 16
    //   931: ldc_w 6783
    //   934: iconst_0
    //   935: invokevirtual 1939	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   938: aload 17
    //   940: iconst_0
    //   941: aload_2
    //   942: invokevirtual 577	java/lang/String:length	()I
    //   945: aload 16
    //   947: invokevirtual 6786	com/tencent/mobileqq/graytip/UniteGrayTipParam:a	(IILandroid/os/Bundle;)V
    //   950: new 166	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   957: aload_1
    //   958: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   961: ldc_w 6788
    //   964: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: ldc_w 6790
    //   970: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: ldc_w 6792
    //   976: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: astore_1
    //   983: aload 17
    //   985: aload_1
    //   986: putfield 6776	com/tencent/mobileqq/graytip/UniteGrayTipParam:c	Ljava/lang/String;
    //   989: new 124	android/os/Bundle
    //   992: dup
    //   993: invokespecial 6777	android/os/Bundle:<init>	()V
    //   996: astore_2
    //   997: aload_2
    //   998: ldc_w 6779
    //   1001: bipush 19
    //   1003: invokevirtual 1948	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1006: aload_2
    //   1007: ldc_w 6781
    //   1010: aload_0
    //   1011: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1014: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1017: invokevirtual 2152	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1020: aload_2
    //   1021: ldc_w 268
    //   1024: new 166	java/lang/StringBuilder
    //   1027: dup
    //   1028: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1031: lload 9
    //   1033: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1036: ldc_w 368
    //   1039: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1042: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1045: invokevirtual 2152	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1048: aload_1
    //   1049: ldc_w 6790
    //   1052: invokevirtual 6795	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1055: istore 5
    //   1057: aload_1
    //   1058: ldc_w 6790
    //   1061: invokevirtual 6795	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   1064: istore 6
    //   1066: aload 17
    //   1068: iload 5
    //   1070: ldc_w 6790
    //   1073: invokevirtual 577	java/lang/String:length	()I
    //   1076: iload 6
    //   1078: iadd
    //   1079: aload_2
    //   1080: invokevirtual 6786	com/tencent/mobileqq/graytip/UniteGrayTipParam:a	(IILandroid/os/Bundle;)V
    //   1083: new 2544	com/tencent/mobileqq/graytip/MessageForUniteGrayTip
    //   1086: dup
    //   1087: invokespecial 6796	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:<init>	()V
    //   1090: astore_1
    //   1091: aload_1
    //   1092: aload_0
    //   1093: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1096: aload 17
    //   1098: invokevirtual 6800	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:initGrayTipMsg	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/graytip/UniteGrayTipParam;)V
    //   1101: aload_1
    //   1102: iconst_1
    //   1103: putfield 6801	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:isread	Z
    //   1106: iload 4
    //   1108: ifgt +280 -> 1388
    //   1111: lconst_0
    //   1112: lstore 7
    //   1114: aload_1
    //   1115: lload 7
    //   1117: putfield 6802	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:shmsgseq	J
    //   1120: aload_0
    //   1121: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1124: invokevirtual 1152	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1127: lload 9
    //   1129: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1132: iconst_1
    //   1133: aload_1
    //   1134: getfield 6802	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:shmsgseq	J
    //   1137: invokevirtual 6804	com/tencent/mobileqq/app/message/QQMessageFacade:d	(Ljava/lang/String;IJ)Lcom/tencent/mobileqq/data/MessageRecord;
    //   1140: astore_2
    //   1141: aload_2
    //   1142: ifnull +11 -> 1153
    //   1145: aload_1
    //   1146: aload_2
    //   1147: getfield 6809	com/tencent/mobileqq/data/MessageRecord:time	J
    //   1150: putfield 6810	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:time	J
    //   1153: aload_1
    //   1154: iconst_1
    //   1155: putfield 6811	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:mNeedTimeStamp	Z
    //   1158: aload_1
    //   1159: aload_0
    //   1160: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1163: invokevirtual 6814	com/tencent/mobileqq/graytip/MessageForUniteGrayTip:updateUniteGrayTipMsgData	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   1166: aload_0
    //   1167: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1170: invokevirtual 1152	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   1173: aload_1
    //   1174: aload_0
    //   1175: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1178: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1181: invokevirtual 5777	com/tencent/mobileqq/app/message/QQMessageFacade:a	(Lcom/tencent/mobileqq/data/MessageRecord;Ljava/lang/String;)V
    //   1184: aload 15
    //   1186: aload_3
    //   1187: lload 11
    //   1189: invokevirtual 6817	com/tencent/mobileqq/app/TroopManager:a	(Lcom/tencent/mobileqq/data/TroopInfo;J)V
    //   1192: aload 15
    //   1194: aload_3
    //   1195: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1198: lload 11
    //   1200: invokevirtual 6819	com/tencent/mobileqq/app/TroopManager:b	(Ljava/lang/String;J)V
    //   1203: return
    //   1204: astore_1
    //   1205: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1208: ifeq +170 -> 1378
    //   1211: ldc_w 2296
    //   1214: iconst_2
    //   1215: aload_1
    //   1216: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   1219: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1222: return
    //   1223: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1226: ifeq -517 -> 709
    //   1229: ldc_w 6726
    //   1232: iconst_2
    //   1233: new 166	java/lang/StringBuilder
    //   1236: dup
    //   1237: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1240: ldc_w 6821
    //   1243: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1246: iload 4
    //   1248: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1251: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1254: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1257: goto -548 -> 709
    //   1260: iload 6
    //   1262: iconst_2
    //   1263: if_icmpne +82 -> 1345
    //   1266: aload_0
    //   1267: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1270: bipush 52
    //   1272: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1275: checkcast 6823	com/tencent/mobileqq/app/DiscussionManager
    //   1278: astore_1
    //   1279: aload_1
    //   1280: ifnull +65 -> 1345
    //   1283: aload_1
    //   1284: aload 16
    //   1286: invokevirtual 6826	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   1289: astore_1
    //   1290: aload_1
    //   1291: ifnull +54 -> 1345
    //   1294: aload_1
    //   1295: getfield 6831	com/tencent/mobileqq/data/DiscussionInfo:discussionName	Ljava/lang/String;
    //   1298: astore_1
    //   1299: goto -430 -> 869
    //   1302: aload_0
    //   1303: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1306: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1309: ldc_w 6832
    //   1312: iconst_1
    //   1313: anewarray 103	java/lang/Object
    //   1316: dup
    //   1317: iconst_0
    //   1318: aload_2
    //   1319: aastore
    //   1320: invokevirtual 6835	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   1323: astore_1
    //   1324: goto -429 -> 895
    //   1327: aload_0
    //   1328: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1331: aload_3
    //   1332: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   1335: iload 4
    //   1337: iconst_1
    //   1338: iadd
    //   1339: invokestatic 6837	com/tencent/mobileqq/troop/utils/HWTroopUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;I)V
    //   1342: goto -150 -> 1192
    //   1345: aconst_null
    //   1346: astore_1
    //   1347: goto -478 -> 869
    //   1350: goto +35 -> 1385
    //   1353: goto -901 -> 452
    //   1356: goto -1053 -> 303
    //   1359: iconst_m1
    //   1360: istore 4
    //   1362: goto -1206 -> 156
    //   1365: iconst_0
    //   1366: istore 5
    //   1368: goto -1109 -> 259
    //   1371: lload 7
    //   1373: lconst_0
    //   1374: lcmp
    //   1375: ifle -763 -> 612
    //   1378: return
    //   1379: iconst_0
    //   1380: istore 13
    //   1382: goto -948 -> 434
    //   1385: goto -516 -> 869
    //   1388: iload 4
    //   1390: i2l
    //   1391: lstore 7
    //   1393: goto -279 -> 1114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1396	0	this	TroopHandler
    //   0	1396	1	paramToServiceMsg	ToServiceMsg
    //   0	1396	2	paramFromServiceMsg	FromServiceMsg
    //   0	1396	3	paramObject	Object
    //   116	1273	4	i	int
    //   112	1255	5	j	int
    //   34	1230	6	k	int
    //   293	1099	7	l1	long
    //   10	1118	9	l2	long
    //   520	679	11	l3	long
    //   432	949	13	bool	boolean
    //   22	903	14	str	String
    //   417	776	15	localTroopManager1	TroopManager
    //   46	1239	16	localObject1	Object
    //   53	1044	17	localObject2	Object
    //   802	32	18	localTroopManager2	TroopManager
    // Exception table:
    //   from	to	target	type
    //   84	99	312	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   196	210	1204	java/lang/Exception
    //   215	239	1204	java/lang/Exception
    //   241	249	1204	java/lang/Exception
    //   270	282	1204	java/lang/Exception
    //   286	295	1204	java/lang/Exception
    //   356	364	1204	java/lang/Exception
    //   367	398	1204	java/lang/Exception
    //   405	427	1204	java/lang/Exception
    //   438	452	1204	java/lang/Exception
    //   452	468	1204	java/lang/Exception
    //   468	490	1204	java/lang/Exception
    //   490	609	1204	java/lang/Exception
    //   617	709	1204	java/lang/Exception
    //   709	759	1204	java/lang/Exception
    //   759	782	1204	java/lang/Exception
    //   790	804	1204	java/lang/Exception
    //   809	817	1204	java/lang/Exception
    //   817	833	1204	java/lang/Exception
    //   833	844	1204	java/lang/Exception
    //   849	866	1204	java/lang/Exception
    //   869	895	1204	java/lang/Exception
    //   895	950	1204	java/lang/Exception
    //   950	1106	1204	java/lang/Exception
    //   1114	1141	1204	java/lang/Exception
    //   1145	1153	1204	java/lang/Exception
    //   1153	1192	1204	java/lang/Exception
    //   1192	1203	1204	java/lang/Exception
    //   1223	1257	1204	java/lang/Exception
    //   1266	1279	1204	java/lang/Exception
    //   1283	1290	1204	java/lang/Exception
    //   1294	1299	1204	java/lang/Exception
    //   1302	1324	1204	java/lang/Exception
    //   1327	1342	1204	java/lang/Exception
  }
  
  public void n(String paramString)
  {
    e(paramString, false);
  }
  
  /* Error */
  public void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 10
    //   9: aconst_null
    //   10: astore 18
    //   12: aconst_null
    //   13: astore 19
    //   15: aconst_null
    //   16: astore 20
    //   18: aload_1
    //   19: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 1384
    //   25: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   28: lstore 14
    //   30: lload 14
    //   32: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   35: astore 22
    //   37: aload_1
    //   38: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   41: ldc_w 2289
    //   44: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   47: istore 9
    //   49: aload_1
    //   50: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   53: ldc_w 5218
    //   56: invokevirtual 136	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   59: astore 21
    //   61: aload_1
    //   62: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   65: ldc_w 5220
    //   68: invokevirtual 264	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   71: istore 13
    //   73: iconst_m1
    //   74: istore 4
    //   76: aload_2
    //   77: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   80: sipush 1000
    //   83: if_icmpne +1299 -> 1382
    //   86: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   89: dup
    //   90: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   93: astore_1
    //   94: aload_1
    //   95: aload_3
    //   96: checkcast 151	[B
    //   99: checkcast 151	[B
    //   102: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   105: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   108: astore_2
    //   109: aload_2
    //   110: astore_1
    //   111: aload_1
    //   112: ifnull +54 -> 166
    //   115: aload_1
    //   116: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: istore 5
    //   124: iload 5
    //   126: istore 4
    //   128: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +35 -> 166
    //   134: ldc_w 2296
    //   137: iconst_2
    //   138: new 166	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 6662
    //   148: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: iload 5
    //   153: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: iload 5
    //   164: istore 4
    //   166: iload 4
    //   168: ifne +1361 -> 1529
    //   171: aload_1
    //   172: ifnull +1357 -> 1529
    //   175: aload_1
    //   176: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   179: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   182: ifeq +1347 -> 1529
    //   185: aload_1
    //   186: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   192: ifnull +1337 -> 1529
    //   195: aload_1
    //   196: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   202: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   205: astore_1
    //   206: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   209: dup
    //   210: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   213: astore 20
    //   215: aload 20
    //   217: aload_1
    //   218: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   221: pop
    //   222: iload 4
    //   224: ifeq +1300 -> 1524
    //   227: aload 20
    //   229: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   235: ifeq +1289 -> 1524
    //   238: aload 20
    //   240: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   243: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   246: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   249: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   252: astore_1
    //   253: aconst_null
    //   254: astore_3
    //   255: iload 4
    //   257: istore 5
    //   259: aload 18
    //   261: astore_2
    //   262: iload 11
    //   264: istore 10
    //   266: aload 20
    //   268: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   271: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   274: astore 19
    //   276: aload 19
    //   278: ifnonnull +140 -> 418
    //   281: iconst_0
    //   282: istore 7
    //   284: goto +1263 -> 1547
    //   287: aload_3
    //   288: ifnonnull +237 -> 525
    //   291: iload 8
    //   293: iload 7
    //   295: if_icmpge +230 -> 525
    //   298: iload 4
    //   300: istore 5
    //   302: aload 18
    //   304: astore_2
    //   305: iload 11
    //   307: istore 10
    //   309: aload 19
    //   311: iload 8
    //   313: invokeinterface 638 2 0
    //   318: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   321: astore 20
    //   323: iload 4
    //   325: istore 6
    //   327: aload 20
    //   329: ifnull +1186 -> 1515
    //   332: iload 4
    //   334: istore 5
    //   336: aload 18
    //   338: astore_2
    //   339: iload 11
    //   341: istore 10
    //   343: aload 20
    //   345: getfield 2272	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   348: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   351: lstore 16
    //   353: lload 16
    //   355: lload 14
    //   357: lcmp
    //   358: ifeq +83 -> 441
    //   361: aload_3
    //   362: astore_2
    //   363: iload 8
    //   365: iconst_1
    //   366: iadd
    //   367: istore 8
    //   369: aload_2
    //   370: astore_3
    //   371: goto -84 -> 287
    //   374: astore_2
    //   375: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +33 -> 411
    //   381: ldc_w 2296
    //   384: iconst_2
    //   385: new 166	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 6664
    //   395: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_2
    //   399: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   402: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_2
    //   412: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   415: goto -304 -> 111
    //   418: iload 4
    //   420: istore 5
    //   422: aload 18
    //   424: astore_2
    //   425: iload 11
    //   427: istore 10
    //   429: aload 19
    //   431: invokeinterface 565 1 0
    //   436: istore 7
    //   438: goto +1109 -> 1547
    //   441: iload 4
    //   443: istore 5
    //   445: aload 18
    //   447: astore_2
    //   448: iload 11
    //   450: istore 10
    //   452: aload 20
    //   454: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   457: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   460: istore 4
    //   462: iload 4
    //   464: istore 6
    //   466: iload 4
    //   468: ifne +1047 -> 1515
    //   471: iload 4
    //   473: istore 5
    //   475: aload 18
    //   477: astore_2
    //   478: iload 11
    //   480: istore 10
    //   482: iload 4
    //   484: istore 6
    //   486: aload 20
    //   488: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   491: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   494: ifeq +1021 -> 1515
    //   497: iload 4
    //   499: istore 5
    //   501: aload 18
    //   503: astore_2
    //   504: iload 11
    //   506: istore 10
    //   508: aload 20
    //   510: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   513: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   516: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   519: astore_3
    //   520: aload_3
    //   521: astore_2
    //   522: goto -159 -> 363
    //   525: aload_3
    //   526: ifnull +981 -> 1507
    //   529: iconst_1
    //   530: istore 11
    //   532: iconst_1
    //   533: istore 12
    //   535: iload 4
    //   537: istore 5
    //   539: aload 18
    //   541: astore_2
    //   542: iload 12
    //   544: istore 10
    //   546: aload_0
    //   547: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   550: bipush 51
    //   552: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   555: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   558: astore 20
    //   560: iload 4
    //   562: istore 5
    //   564: aload 18
    //   566: astore_2
    //   567: iload 12
    //   569: istore 10
    //   571: aload 20
    //   573: aload 22
    //   575: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   578: astore 18
    //   580: aload 18
    //   582: ifnull +3 -> 585
    //   585: aload 18
    //   587: ifnonnull +917 -> 1504
    //   590: new 511	com/tencent/mobileqq/data/TroopInfo
    //   593: dup
    //   594: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   597: astore 19
    //   599: iload 4
    //   601: istore 5
    //   603: aload 19
    //   605: astore_2
    //   606: iload 12
    //   608: istore 10
    //   610: aload 19
    //   612: aload 22
    //   614: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   617: aload 19
    //   619: astore 18
    //   621: iload 4
    //   623: istore 5
    //   625: aload 18
    //   627: astore_2
    //   628: iload 12
    //   630: istore 10
    //   632: aload 18
    //   634: aload_3
    //   635: getfield 2306	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint64_group_owner	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   638: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   641: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   644: putfield 1211	com/tencent/mobileqq/data/TroopInfo:troopowneruin	Ljava/lang/String;
    //   647: iload 4
    //   649: istore 5
    //   651: aload 18
    //   653: astore_2
    //   654: iload 12
    //   656: istore 10
    //   658: aload 18
    //   660: aload_3
    //   661: getfield 3029	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   664: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   667: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   670: putfield 1191	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   673: iload 4
    //   675: istore 5
    //   677: aload 18
    //   679: astore_2
    //   680: iload 12
    //   682: istore 10
    //   684: aload 18
    //   686: aload_3
    //   687: getfield 3032	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_face	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   690: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   693: i2s
    //   694: putfield 1221	com/tencent/mobileqq/data/TroopInfo:troopface	S
    //   697: iload 4
    //   699: istore 5
    //   701: aload 18
    //   703: astore_2
    //   704: iload 12
    //   706: istore 10
    //   708: aload 18
    //   710: aload_3
    //   711: getfield 5208	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   714: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   717: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   720: putfield 1197	com/tencent/mobileqq/data/TroopInfo:troopmemo	Ljava/lang/String;
    //   723: iload 4
    //   725: istore 5
    //   727: aload 18
    //   729: astore_2
    //   730: iload 12
    //   732: istore 10
    //   734: aload 18
    //   736: aload_3
    //   737: getfield 4294	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   740: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   743: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   746: putfield 1203	com/tencent/mobileqq/data/TroopInfo:fingertroopmemo	Ljava/lang/String;
    //   749: iload 4
    //   751: istore 5
    //   753: aload 18
    //   755: astore_2
    //   756: iload 12
    //   758: istore 10
    //   760: aload 18
    //   762: aload_3
    //   763: getfield 4297	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_rich_finger_memo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   766: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   769: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   772: putfield 1541	com/tencent/mobileqq/data/TroopInfo:mRichFingerMemo	Ljava/lang/String;
    //   775: iload 4
    //   777: istore 5
    //   779: aload 18
    //   781: astore_2
    //   782: iload 12
    //   784: istore 10
    //   786: aload_3
    //   787: getfield 4290	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:group_geo_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo;
    //   790: invokevirtual 6840	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   793: checkcast 4274	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo
    //   796: astore 19
    //   798: iload 4
    //   800: istore 5
    //   802: aload 18
    //   804: astore_2
    //   805: iload 12
    //   807: istore 10
    //   809: aload 18
    //   811: aload 19
    //   813: getfield 4283	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:bytes_geocontent	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   816: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   819: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   822: putfield 1036	com/tencent/mobileqq/data/TroopInfo:strLocation	Ljava/lang/String;
    //   825: iload 4
    //   827: istore 5
    //   829: aload 18
    //   831: astore_2
    //   832: iload 12
    //   834: istore 10
    //   836: aload 18
    //   838: aload 19
    //   840: getfield 4279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_latitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   843: invokevirtual 6841	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   846: l2i
    //   847: putfield 6844	com/tencent/mobileqq/data/TroopInfo:troopLat	I
    //   850: iload 4
    //   852: istore 5
    //   854: aload 18
    //   856: astore_2
    //   857: iload 12
    //   859: istore 10
    //   861: aload 18
    //   863: aload 19
    //   865: getfield 4280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupGeoInfo:int64_longitude	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   868: invokevirtual 6841	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   871: l2i
    //   872: putfield 6847	com/tencent/mobileqq/data/TroopInfo:troopLon	I
    //   875: iload 4
    //   877: istore 5
    //   879: aload 18
    //   881: astore_2
    //   882: iload 12
    //   884: istore 10
    //   886: aload 18
    //   888: aload_3
    //   889: getfield 4115	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_type_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   892: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   895: putfield 1687	com/tencent/mobileqq/data/TroopInfo:troopTypeExt	I
    //   898: iload 4
    //   900: istore 5
    //   902: aload 18
    //   904: astore_2
    //   905: iload 12
    //   907: istore 10
    //   909: aload 18
    //   911: aload_3
    //   912: getfield 2301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_class_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   915: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   918: i2l
    //   919: putfield 1215	com/tencent/mobileqq/data/TroopInfo:dwGroupClassExt	J
    //   922: iload 4
    //   924: istore 5
    //   926: aload 18
    //   928: astore_2
    //   929: iload 12
    //   931: istore 10
    //   933: aload 18
    //   935: aload_3
    //   936: getfield 5025	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_cmduin_join_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   939: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   942: i2l
    //   943: putfield 1694	com/tencent/mobileqq/data/TroopInfo:dwCmdUinJoinTime	J
    //   946: iload 4
    //   948: istore 5
    //   950: aload 18
    //   952: astore_2
    //   953: iload 12
    //   955: istore 10
    //   957: aload 18
    //   959: aload_3
    //   960: getfield 4112	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag_ext	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   963: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   966: i2l
    //   967: putfield 1239	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt	J
    //   970: iload 4
    //   972: istore 5
    //   974: aload 18
    //   976: astore_2
    //   977: iload 12
    //   979: istore 10
    //   981: aload 18
    //   983: aload_3
    //   984: getfield 5211	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   987: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   990: i2l
    //   991: putfield 1332	com/tencent/mobileqq/data/TroopInfo:dwGroupFlag	J
    //   994: iload 4
    //   996: istore 5
    //   998: aload 18
    //   1000: astore_2
    //   1001: iload 12
    //   1003: istore 10
    //   1005: aload 18
    //   1007: aload_3
    //   1008: getfield 5214	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_certification_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1011: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1014: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   1017: putfield 1301	com/tencent/mobileqq/data/TroopInfo:troopAuthenticateInfo	Ljava/lang/String;
    //   1020: iload 4
    //   1022: istore 5
    //   1024: aload 18
    //   1026: astore_2
    //   1027: iload 12
    //   1029: istore 10
    //   1031: aload 18
    //   1033: aload_3
    //   1034: getfield 5217	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_shutup_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1037: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1040: i2l
    //   1041: putfield 1667	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   1044: iload 4
    //   1046: istore 5
    //   1048: aload 18
    //   1050: astore_2
    //   1051: iload 12
    //   1053: istore 10
    //   1055: aload_3
    //   1056: getfield 3038	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_is_conf_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1059: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1062: iconst_1
    //   1063: if_icmpne +320 -> 1383
    //   1066: iconst_1
    //   1067: istore 11
    //   1069: iload 4
    //   1071: istore 5
    //   1073: aload 18
    //   1075: astore_2
    //   1076: iload 12
    //   1078: istore 10
    //   1080: aload 18
    //   1082: iload 11
    //   1084: putfield 1763	com/tencent/mobileqq/data/TroopInfo:isNewTroop	Z
    //   1087: iload 4
    //   1089: istore 5
    //   1091: aload 18
    //   1093: astore_2
    //   1094: iload 12
    //   1096: istore 10
    //   1098: aload_3
    //   1099: getfield 3041	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_is_modify_conf_group_face	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1102: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1105: iconst_1
    //   1106: if_icmpne +283 -> 1389
    //   1109: iconst_1
    //   1110: istore 11
    //   1112: iload 4
    //   1114: istore 5
    //   1116: aload 18
    //   1118: astore_2
    //   1119: iload 12
    //   1121: istore 10
    //   1123: aload 18
    //   1125: iload 11
    //   1127: putfield 1769	com/tencent/mobileqq/data/TroopInfo:hasSetNewTroopHead	Z
    //   1130: iload 4
    //   1132: istore 5
    //   1134: aload 18
    //   1136: astore_2
    //   1137: iload 12
    //   1139: istore 10
    //   1141: aload_3
    //   1142: getfield 3044	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_is_modify_conf_group_name	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1145: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1148: iconst_1
    //   1149: if_icmpne +246 -> 1395
    //   1152: iconst_1
    //   1153: istore 11
    //   1155: iload 4
    //   1157: istore 5
    //   1159: aload 18
    //   1161: astore_2
    //   1162: iload 12
    //   1164: istore 10
    //   1166: aload 18
    //   1168: iload 11
    //   1170: putfield 1775	com/tencent/mobileqq/data/TroopInfo:hasSetNewTroopName	Z
    //   1173: iload 4
    //   1175: istore 5
    //   1177: aload 18
    //   1179: astore_2
    //   1180: iload 12
    //   1182: istore 10
    //   1184: aload 18
    //   1186: invokevirtual 3055	com/tencent/mobileqq/data/TroopInfo:isNewTroop	()Z
    //   1189: ifeq +212 -> 1401
    //   1192: iload 4
    //   1194: istore 5
    //   1196: aload 18
    //   1198: astore_2
    //   1199: iload 12
    //   1201: istore 10
    //   1203: aload 18
    //   1205: aload_3
    //   1206: getfield 4118	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_auto_agree_join_group_user_num_for_conf_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1209: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1212: putfield 6671	com/tencent/mobileqq/data/TroopInfo:maxInviteMemNum	I
    //   1215: iload 4
    //   1217: istore 5
    //   1219: aload 18
    //   1221: astore_2
    //   1222: iload 12
    //   1224: istore 10
    //   1226: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1229: ifeq +58 -> 1287
    //   1232: iload 4
    //   1234: istore 5
    //   1236: aload 18
    //   1238: astore_2
    //   1239: iload 12
    //   1241: istore 10
    //   1243: ldc 96
    //   1245: iconst_2
    //   1246: new 166	java/lang/StringBuilder
    //   1249: dup
    //   1250: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1253: ldc_w 6849
    //   1256: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1259: aload 18
    //   1261: getfield 1667	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   1264: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1267: ldc_w 6851
    //   1270: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1273: aload 18
    //   1275: getfield 1191	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   1278: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1281: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1284: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1287: iload 13
    //   1289: ifeq +21 -> 1310
    //   1292: iload 4
    //   1294: istore 5
    //   1296: aload 18
    //   1298: astore_2
    //   1299: iload 12
    //   1301: istore 10
    //   1303: aload 20
    //   1305: aload 18
    //   1307: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   1310: aload 18
    //   1312: astore_2
    //   1313: iconst_1
    //   1314: istore 10
    //   1316: iload 10
    //   1318: istore 11
    //   1320: aload_2
    //   1321: astore 19
    //   1323: iload 4
    //   1325: istore 5
    //   1327: aload_1
    //   1328: astore 18
    //   1330: aload_0
    //   1331: bipush 34
    //   1333: iload 11
    //   1335: bipush 6
    //   1337: anewarray 103	java/lang/Object
    //   1340: dup
    //   1341: iconst_0
    //   1342: lload 14
    //   1344: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1347: aastore
    //   1348: dup
    //   1349: iconst_1
    //   1350: iload 9
    //   1352: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1355: aastore
    //   1356: dup
    //   1357: iconst_2
    //   1358: aload 19
    //   1360: aastore
    //   1361: dup
    //   1362: iconst_3
    //   1363: iload 5
    //   1365: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1368: aastore
    //   1369: dup
    //   1370: iconst_4
    //   1371: aload 18
    //   1373: aastore
    //   1374: dup
    //   1375: iconst_5
    //   1376: aload 21
    //   1378: aastore
    //   1379: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   1382: return
    //   1383: iconst_0
    //   1384: istore 11
    //   1386: goto -317 -> 1069
    //   1389: iconst_0
    //   1390: istore 11
    //   1392: goto -280 -> 1112
    //   1395: iconst_0
    //   1396: istore 11
    //   1398: goto -243 -> 1155
    //   1401: iload 4
    //   1403: istore 5
    //   1405: aload 18
    //   1407: astore_2
    //   1408: iload 12
    //   1410: istore 10
    //   1412: aload 18
    //   1414: aload_3
    //   1415: getfield 4121	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_auto_agree_join_group_user_num_for_normal_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1418: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1421: putfield 6671	com/tencent/mobileqq/data/TroopInfo:maxInviteMemNum	I
    //   1424: goto -209 -> 1215
    //   1427: astore_3
    //   1428: iload 5
    //   1430: istore 4
    //   1432: aload_1
    //   1433: astore 18
    //   1435: iload 4
    //   1437: istore 5
    //   1439: aload_2
    //   1440: astore 19
    //   1442: iload 10
    //   1444: istore 11
    //   1446: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1449: ifeq -119 -> 1330
    //   1452: ldc_w 2296
    //   1455: iconst_2
    //   1456: aload_3
    //   1457: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   1460: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1463: aload_1
    //   1464: astore 18
    //   1466: iload 4
    //   1468: istore 5
    //   1470: aload_2
    //   1471: astore 19
    //   1473: iload 10
    //   1475: istore 11
    //   1477: goto -147 -> 1330
    //   1480: astore_3
    //   1481: aconst_null
    //   1482: astore_1
    //   1483: aload 19
    //   1485: astore_2
    //   1486: iload 12
    //   1488: istore 10
    //   1490: goto -58 -> 1432
    //   1493: astore_3
    //   1494: aload 18
    //   1496: astore_2
    //   1497: iload 11
    //   1499: istore 10
    //   1501: goto -69 -> 1432
    //   1504: goto -883 -> 621
    //   1507: aconst_null
    //   1508: astore_2
    //   1509: iconst_0
    //   1510: istore 10
    //   1512: goto -196 -> 1316
    //   1515: aload_3
    //   1516: astore_2
    //   1517: iload 6
    //   1519: istore 4
    //   1521: goto -1158 -> 363
    //   1524: aconst_null
    //   1525: astore_1
    //   1526: goto -1273 -> 253
    //   1529: aconst_null
    //   1530: astore 18
    //   1532: iload 4
    //   1534: istore 5
    //   1536: aload 20
    //   1538: astore 19
    //   1540: iload 10
    //   1542: istore 11
    //   1544: goto -214 -> 1330
    //   1547: iconst_0
    //   1548: istore 8
    //   1550: goto -1263 -> 287
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1553	0	this	TroopHandler
    //   0	1553	1	paramToServiceMsg	ToServiceMsg
    //   0	1553	2	paramFromServiceMsg	FromServiceMsg
    //   0	1553	3	paramObject	Object
    //   74	1459	4	i	int
    //   122	1413	5	j	int
    //   325	1193	6	k	int
    //   282	155	7	m	int
    //   291	1258	8	n	int
    //   47	1304	9	i1	int
    //   7	1534	10	bool1	boolean
    //   1	1542	11	bool2	boolean
    //   4	1483	12	bool3	boolean
    //   71	1217	13	bool4	boolean
    //   28	1315	14	l1	long
    //   351	3	16	l2	long
    //   10	1521	18	localObject1	Object
    //   13	1526	19	localObject2	Object
    //   16	1521	20	localObject3	Object
    //   59	1318	21	str1	String
    //   35	578	22	str2	String
    // Exception table:
    //   from	to	target	type
    //   94	109	374	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   266	276	1427	java/lang/Exception
    //   309	323	1427	java/lang/Exception
    //   343	353	1427	java/lang/Exception
    //   429	438	1427	java/lang/Exception
    //   452	462	1427	java/lang/Exception
    //   486	497	1427	java/lang/Exception
    //   508	520	1427	java/lang/Exception
    //   546	560	1427	java/lang/Exception
    //   571	580	1427	java/lang/Exception
    //   610	617	1427	java/lang/Exception
    //   632	647	1427	java/lang/Exception
    //   658	673	1427	java/lang/Exception
    //   684	697	1427	java/lang/Exception
    //   708	723	1427	java/lang/Exception
    //   734	749	1427	java/lang/Exception
    //   760	775	1427	java/lang/Exception
    //   786	798	1427	java/lang/Exception
    //   809	825	1427	java/lang/Exception
    //   836	850	1427	java/lang/Exception
    //   861	875	1427	java/lang/Exception
    //   886	898	1427	java/lang/Exception
    //   909	922	1427	java/lang/Exception
    //   933	946	1427	java/lang/Exception
    //   957	970	1427	java/lang/Exception
    //   981	994	1427	java/lang/Exception
    //   1005	1020	1427	java/lang/Exception
    //   1031	1044	1427	java/lang/Exception
    //   1055	1066	1427	java/lang/Exception
    //   1080	1087	1427	java/lang/Exception
    //   1098	1109	1427	java/lang/Exception
    //   1123	1130	1427	java/lang/Exception
    //   1141	1152	1427	java/lang/Exception
    //   1166	1173	1427	java/lang/Exception
    //   1184	1192	1427	java/lang/Exception
    //   1203	1215	1427	java/lang/Exception
    //   1226	1232	1427	java/lang/Exception
    //   1243	1287	1427	java/lang/Exception
    //   1303	1310	1427	java/lang/Exception
    //   1412	1424	1427	java/lang/Exception
    //   206	222	1480	java/lang/Exception
    //   227	253	1480	java/lang/Exception
    //   590	599	1493	java/lang/Exception
  }
  
  public void o(String paramString)
  {
    TroopInfo localTroopInfo = (TroopInfo)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(TroopInfo.class, paramString);
    if ((QLog.isColorLevel()) && (localTroopInfo != null))
    {
      QLog.d("TroopHandler", 2, "PrivilegeFlag:" + localTroopInfo.troopPrivilegeFlag);
      QLog.d("TroopHandler", 2, "troop.isAdmin:" + localTroopInfo.isAdmin());
    }
    if ((localTroopInfo != null) && ((localTroopInfo.troopPrivilegeFlag & 1L) == 1L) && (!localTroopInfo.isAdmin())) {}
    for (int i = 0;; i = 1)
    {
      long l = Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue();
      if (i != LocalMultiProcConfig.getInt4Uin(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "__qzone_pic_permission__" + paramString, -1, l)) {
        LocalMultiProcConfig.putInt4Uin(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "__qzone_pic_permission__" + paramString, i, l);
      }
      return;
    }
  }
  
  public void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(91, false, null);
      return;
    }
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has()) || (paramToServiceMsg.uint32_result.get() != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null))
      {
        a(91, false, null);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      a(91, false, null);
      return;
    }
    paramFromServiceMsg = new cmd0x903.RspBody();
    for (;;)
    {
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (!paramFromServiceMsg.opt_msg_get_invited_uin_list_rsp.has()) {
          break;
        }
        new cmd0x903.SubCmd0x2Rsp();
        paramFromServiceMsg = (cmd0x903.SubCmd0x2Rsp)paramFromServiceMsg.opt_msg_get_invited_uin_list_rsp.get();
        paramToServiceMsg = Long.valueOf(paramFromServiceMsg.opt_uint64_group_code.get());
        paramObject = paramFromServiceMsg.rpt_uint64_uin.get();
        a(91, true, new Object[] { paramToServiceMsg, paramObject });
        if (!QLog.isColorLevel()) {
          break;
        }
        paramFromServiceMsg = new StringBuilder().append("handleGetInvitedUinList:").append(paramToServiceMsg).append(", uins=");
        if (paramObject == null)
        {
          paramToServiceMsg = "null";
          QLog.d("TroopHandler", 2, paramToServiceMsg);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(91, false, null);
        return;
      }
      paramToServiceMsg = paramObject.toString();
    }
  }
  
  public void p(String paramString)
  {
    UserFollowStatus.UserFollowStatusReq localUserFollowStatusReq = new UserFollowStatus.UserFollowStatusReq();
    Object localObject = new ArrayList();
    try
    {
      ((List)localObject).add(Long.valueOf(Long.parseLong(paramString)));
      localUserFollowStatusReq.uin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      localUserFollowStatusReq.dst_uin_list.set((List)localObject);
      localObject = a("NearbyExt.query_user_follow_status");
      ((ToServiceMsg)localObject).extraData.putString("distUin", paramString);
      ((ToServiceMsg)localObject).putWupBuffer(localUserFollowStatusReq.toByteArray());
      b((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopHandler", 2, "getFollowStatus:NumberFormatException" + localNumberFormatException.toString() + "|distUin:" + paramString);
    }
  }
  
  public void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool4 = false;
    boolean bool3 = false;
    Object localObject1 = null;
    long l1 = paramToServiceMsg.extraData.getLong("OldOwner");
    long l2 = paramToServiceMsg.extraData.getLong("NewOwner");
    long l3 = paramToServiceMsg.extraData.getLong("troop_uin");
    int j;
    int i;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          try
          {
            label135:
            localObject2 = new oidb_0x89e.RspBody();
            ((oidb_0x89e.RspBody)localObject2).mergeFrom(paramToServiceMsg);
            if (!((oidb_0x89e.RspBody)localObject2).uint32_result.has()) {
              break label821;
            }
            j = ((oidb_0x89e.RspBody)localObject2).uint32_result.get();
            i = j;
            k = j;
          }
          catch (Exception localException1)
          {
            bool2 = false;
            paramToServiceMsg = null;
            j = i;
            i = j;
            paramObject = paramToServiceMsg;
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|exception = " + localException1.toString());
            i = j;
            paramObject = paramToServiceMsg;
            bool1 = bool2;
            continue;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              k = j;
              QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|oidb_0x89e.RspBody.result = " + j);
              i = j;
            }
            paramToServiceMsg = (ToServiceMsg)localObject1;
            if (i > 0)
            {
              paramToServiceMsg = (ToServiceMsg)localObject1;
              k = i;
              if (((oidb_0x89e.RspBody)localObject2).str_errorinfo.has())
              {
                k = i;
                localObject1 = String.valueOf(((oidb_0x89e.RspBody)localObject2).str_errorinfo.get().toByteArray());
                paramToServiceMsg = (ToServiceMsg)localObject1;
                bool1 = bool4;
                paramObject = localObject1;
              }
            }
          }
          catch (Exception localException2)
          {
            j = k;
            bool2 = false;
            paramToServiceMsg = null;
            continue;
          }
          try
          {
            if (QLog.isColorLevel())
            {
              bool1 = bool4;
              paramObject = localObject1;
              QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|strErrorMsg = " + (String)localObject1);
              paramToServiceMsg = (ToServiceMsg)localObject1;
            }
            bool2 = bool3;
            if (i == 0)
            {
              bool2 = bool3;
              bool1 = bool4;
              paramObject = paramToServiceMsg;
              if (((oidb_0x89e.RspBody)localObject2).uint64_group_code.get() == l3)
              {
                bool3 = true;
                bool2 = true;
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localObject2 = localTroopManager.a(String.valueOf(l3));
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  bool1 = bool3;
                  paramObject = paramToServiceMsg;
                  localObject1 = new TroopInfo();
                  bool1 = bool3;
                  paramObject = paramToServiceMsg;
                  ((TroopInfo)localObject1).troopuin = String.valueOf(l3);
                }
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                ((TroopInfo)localObject1).troopowneruin = String.valueOf(l2);
                bool1 = bool3;
                paramObject = paramToServiceMsg;
                localTroopManager.b((TroopInfo)localObject1);
              }
            }
            bool1 = bool2;
            paramObject = paramToServiceMsg;
            a(21, bool1, new Object[] { Long.valueOf(l3), String.valueOf(l1), String.valueOf(l2), Integer.valueOf(i), paramObject });
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder(150);
              paramToServiceMsg.append("handle_oidb_0x89e_0").append("|isSuccess = ").append(bool1).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l3).append("|oldOwner = ").append(l1).append("|newOwner = ").append(l2).append("|result = ").append(i).append("|strErrorMsg = ").append(paramObject);
              QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
            }
            return;
          }
          catch (Exception localException3)
          {
            paramToServiceMsg = paramObject;
            j = i;
            bool2 = bool1;
            continue;
          }
          paramObject = paramObject;
          paramToServiceMsg = null;
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, "handle_oidb_0x89e_0| oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
        }
      }
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
        if (paramToServiceMsg == null) {
          break label832;
        }
        j = paramToServiceMsg.uint32_result.get();
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.troopdisband.", 2, "handle_oidb_0x89e_0|oidb_sso.OIDBSSOPkg.result = " + j);
          i = j;
        }
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        break label675;
        break label257;
        bool1 = false;
        paramObject = null;
        break label509;
        i = -1;
        break label135;
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    for (;;)
    {
      Object localObject2;
      int k;
      label257:
      boolean bool2;
      TroopManager localTroopManager;
      label509:
      i = -1;
      label675:
      label821:
      label832:
      boolean bool1 = false;
      paramObject = null;
    }
  }
  
  public void q(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getOnlineMemTips, app == null");
      }
      return;
    }
    Object localObject = (TroopOnlineMemberManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233);
    if (NetConnInfoCenter.getServerTime() < ((TroopOnlineMemberManager)localObject).b(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getOnlineMemTips, too frequency");
      }
      a(99, true, new Object[] { paramString, ((TroopOnlineMemberManager)localObject).a(paramString) });
      return;
    }
    try
    {
      localObject = new oidb_0xa2a.ReqBody();
      ((oidb_0xa2a.ReqBody)localObject).group_id.set(Long.valueOf(paramString).longValue());
      ((oidb_0xa2a.ReqBody)localObject).is_private.set(TroopInfo.isQidianPrivateTroop(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString));
      localObject = a("OidbSvc.0xa2a_2", 2602, 2, ((oidb_0xa2a.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      QLog.i("TroopHandler", 1, "getOnlineMemTips, e=" + paramString.toString());
    }
  }
  
  /* Error */
  public void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 12
    //   3: iconst_0
    //   4: istore 13
    //   6: aconst_null
    //   7: astore 18
    //   9: aconst_null
    //   10: astore 19
    //   12: aconst_null
    //   13: astore 20
    //   15: aload_1
    //   16: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   19: ldc_w 1384
    //   22: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   25: lstore 14
    //   27: aload_1
    //   28: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   31: ldc_w 2289
    //   34: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   37: istore 11
    //   39: iconst_m1
    //   40: istore 6
    //   42: iload 6
    //   44: istore 7
    //   46: aload_2
    //   47: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   50: sipush 1000
    //   53: if_icmpne +1051 -> 1104
    //   56: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   59: dup
    //   60: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: aload_3
    //   66: checkcast 151	[B
    //   69: checkcast 151	[B
    //   72: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   75: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: astore_3
    //   79: aload_3
    //   80: astore_1
    //   81: aload_1
    //   82: ifnull +54 -> 136
    //   85: aload_1
    //   86: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   89: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   92: istore 7
    //   94: iload 7
    //   96: istore 6
    //   98: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq +35 -> 136
    //   104: ldc_w 2296
    //   107: iconst_2
    //   108: new 166	java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   115: ldc_w 6935
    //   118: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload 7
    //   123: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: iload 7
    //   134: istore 6
    //   136: iload 6
    //   138: istore 7
    //   140: aload_1
    //   141: ifnull +963 -> 1104
    //   144: iload 6
    //   146: istore 7
    //   148: aload_1
    //   149: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   152: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   155: ifeq +949 -> 1104
    //   158: iload 6
    //   160: istore 7
    //   162: aload_1
    //   163: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   166: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   169: ifnull +935 -> 1104
    //   172: aload_1
    //   173: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   176: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   179: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   182: astore_1
    //   183: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   186: dup
    //   187: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   190: astore 20
    //   192: aload 20
    //   194: aload_1
    //   195: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   198: pop
    //   199: iload 6
    //   201: ifeq +898 -> 1099
    //   204: aload 20
    //   206: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   212: ifeq +887 -> 1099
    //   215: aload 20
    //   217: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   226: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   229: astore_1
    //   230: aconst_null
    //   231: astore_3
    //   232: iload 6
    //   234: istore 7
    //   236: aload 20
    //   238: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   241: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   244: astore 20
    //   246: aload 20
    //   248: ifnonnull +124 -> 372
    //   251: iconst_0
    //   252: istore 9
    //   254: goto +856 -> 1110
    //   257: aload_3
    //   258: ifnonnull +191 -> 449
    //   261: iload 10
    //   263: iload 9
    //   265: if_icmpge +184 -> 449
    //   268: iload 6
    //   270: istore 7
    //   272: aload 20
    //   274: iload 10
    //   276: invokeinterface 638 2 0
    //   281: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   284: astore 21
    //   286: iload 6
    //   288: istore 8
    //   290: aload 21
    //   292: ifnull +800 -> 1092
    //   295: iload 6
    //   297: istore 7
    //   299: aload 21
    //   301: getfield 2272	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   304: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   307: lstore 16
    //   309: lload 16
    //   311: lload 14
    //   313: lcmp
    //   314: ifeq +74 -> 388
    //   317: iload 10
    //   319: iconst_1
    //   320: iadd
    //   321: istore 10
    //   323: goto -66 -> 257
    //   326: astore_3
    //   327: aconst_null
    //   328: astore_1
    //   329: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   332: ifeq +33 -> 365
    //   335: ldc_w 2296
    //   338: iconst_2
    //   339: new 166	java/lang/StringBuilder
    //   342: dup
    //   343: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   346: ldc_w 6937
    //   349: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_3
    //   353: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   356: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload_3
    //   366: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   369: goto -288 -> 81
    //   372: iload 6
    //   374: istore 7
    //   376: aload 20
    //   378: invokeinterface 565 1 0
    //   383: istore 9
    //   385: goto +725 -> 1110
    //   388: iload 6
    //   390: istore 7
    //   392: aload 21
    //   394: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   397: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   400: istore 6
    //   402: iload 6
    //   404: istore 8
    //   406: iload 6
    //   408: ifne +684 -> 1092
    //   411: iload 6
    //   413: istore 7
    //   415: iload 6
    //   417: istore 8
    //   419: aload 21
    //   421: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   424: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   427: ifeq +665 -> 1092
    //   430: iload 6
    //   432: istore 7
    //   434: aload 21
    //   436: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   439: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   442: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   445: astore_3
    //   446: goto -129 -> 317
    //   449: aload_3
    //   450: ifnull +633 -> 1083
    //   453: iconst_1
    //   454: istore 12
    //   456: aload 19
    //   458: astore 18
    //   460: aload_0
    //   461: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   464: bipush 51
    //   466: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   469: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   472: lload 14
    //   474: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   477: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   480: astore 19
    //   482: aload 19
    //   484: ifnonnull +592 -> 1076
    //   487: new 511	com/tencent/mobileqq/data/TroopInfo
    //   490: dup
    //   491: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   494: astore 20
    //   496: aload 20
    //   498: astore 18
    //   500: aload 20
    //   502: lload 14
    //   504: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   507: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   510: aload 20
    //   512: astore 18
    //   514: aload_3
    //   515: getfield 4062	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   518: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   521: ifeq +16 -> 537
    //   524: aload 18
    //   526: aload_3
    //   527: getfield 4062	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   530: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   533: i2s
    //   534: putfield 1226	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   537: aload_3
    //   538: getfield 4066	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   541: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   544: ifeq +55 -> 599
    //   547: aload 18
    //   549: aload_3
    //   550: getfield 4066	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_question	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   553: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   556: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   559: putfield 1307	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   562: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +34 -> 599
    //   568: ldc_w 4058
    //   571: iconst_2
    //   572: new 166	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 6939
    //   582: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload 18
    //   587: getfield 1307	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   590: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload_3
    //   600: getfield 4073	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   603: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   606: ifeq +18 -> 624
    //   609: aload 18
    //   611: aload_3
    //   612: getfield 4073	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:string_group_answer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   615: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   618: invokevirtual 203	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   621: putfield 1313	com/tencent/mobileqq/data/TroopInfo:joinTroopAnswer	Ljava/lang/String;
    //   624: aload_3
    //   625: getfield 4076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   628: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   631: ifeq +86 -> 717
    //   634: aload_3
    //   635: getfield 4076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   638: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   641: istore 7
    //   643: fconst_0
    //   644: fstore 5
    //   646: fload 5
    //   648: fstore 4
    //   650: aload_3
    //   651: getfield 5744	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   654: invokevirtual 6940	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:has	()Z
    //   657: ifeq +37 -> 694
    //   660: fload 5
    //   662: fstore 4
    //   664: aload_3
    //   665: getfield 5744	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   668: getfield 5740	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   671: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   674: ifeq +20 -> 694
    //   677: aload_3
    //   678: getfield 5744	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   681: getfield 5740	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   684: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   687: i2f
    //   688: ldc_w 6941
    //   691: fmul
    //   692: fstore 4
    //   694: aload 18
    //   696: iload 7
    //   698: i2l
    //   699: putfield 1702	com/tencent/mobileqq/data/TroopInfo:troopPrivilegeFlag	J
    //   702: aload 18
    //   704: iload 7
    //   706: i2l
    //   707: putfield 1699	com/tencent/mobileqq/data/TroopInfo:dwAppPrivilegeFlag	J
    //   710: aload 18
    //   712: fload 4
    //   714: putfield 6944	com/tencent/mobileqq/data/TroopInfo:mTroopNeedPayNumber	F
    //   717: aload_3
    //   718: getfield 4079	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   721: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   724: ifeq +16 -> 740
    //   727: aload 18
    //   729: aload_3
    //   730: getfield 4079	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_group_flagext3	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   733: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   736: i2l
    //   737: putfield 1757	com/tencent/mobileqq/data/TroopInfo:dwGroupFlagExt3	J
    //   740: aload_0
    //   741: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   744: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   747: aload 18
    //   749: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   752: aload 18
    //   754: getfield 1191	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   757: invokestatic 1372	com/tencent/mobileqq/util/TroopSystemMsgUtil:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   760: aload_0
    //   761: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   764: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   767: aload 18
    //   769: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   772: aload 18
    //   774: getfield 1226	com/tencent/mobileqq/data/TroopInfo:cGroupOption	S
    //   777: invokestatic 6947	com/tencent/mobileqq/util/TroopSystemMsgUtil:a	(Landroid/content/Context;Ljava/lang/String;I)V
    //   780: aload_0
    //   781: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   784: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   787: aload 18
    //   789: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   792: aload 18
    //   794: getfield 1307	com/tencent/mobileqq/data/TroopInfo:joinTroopQuestion	Ljava/lang/String;
    //   797: invokestatic 1377	com/tencent/mobileqq/util/TroopSystemMsgUtil:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   800: aload_0
    //   801: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   804: invokevirtual 1367	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   807: aload 18
    //   809: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   812: aload 18
    //   814: getfield 1313	com/tencent/mobileqq/data/TroopInfo:joinTroopAnswer	Ljava/lang/String;
    //   817: invokestatic 1379	com/tencent/mobileqq/util/TroopSystemMsgUtil:c	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   820: iload 12
    //   822: istore 13
    //   824: aload 18
    //   826: astore 20
    //   828: iload 6
    //   830: istore 7
    //   832: aload_1
    //   833: astore 19
    //   835: aload_0
    //   836: bipush 26
    //   838: iload 13
    //   840: iconst_5
    //   841: anewarray 103	java/lang/Object
    //   844: dup
    //   845: iconst_0
    //   846: lload 14
    //   848: invokestatic 355	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   851: aastore
    //   852: dup
    //   853: iconst_1
    //   854: iload 11
    //   856: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   859: aastore
    //   860: dup
    //   861: iconst_2
    //   862: aload 20
    //   864: aastore
    //   865: dup
    //   866: iconst_3
    //   867: iload 7
    //   869: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   872: aastore
    //   873: dup
    //   874: iconst_4
    //   875: aload 19
    //   877: aastore
    //   878: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   881: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   884: ifeq +101 -> 985
    //   887: new 166	java/lang/StringBuilder
    //   890: dup
    //   891: sipush 150
    //   894: invokespecial 3798	java/lang/StringBuilder:<init>	(I)V
    //   897: astore_1
    //   898: aload_1
    //   899: ldc_w 6949
    //   902: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   905: ldc_w 6634
    //   908: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: iload 13
    //   913: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   916: ldc_w 6636
    //   919: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   922: aload_2
    //   923: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   926: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   929: ldc_w 3802
    //   932: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   935: lload 14
    //   937: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   940: ldc_w 3804
    //   943: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: iload 11
    //   948: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   951: ldc_w 6640
    //   954: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: iload 7
    //   959: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   962: ldc_w 6642
    //   965: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: aload 19
    //   970: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: ldc_w 4058
    //   977: iconst_2
    //   978: aload_1
    //   979: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: return
    //   986: astore_3
    //   987: aconst_null
    //   988: astore_1
    //   989: aload_1
    //   990: astore 19
    //   992: iload 6
    //   994: istore 7
    //   996: aload 18
    //   998: astore 20
    //   1000: iload 12
    //   1002: istore 13
    //   1004: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1007: ifeq -172 -> 835
    //   1010: ldc_w 4058
    //   1013: iconst_2
    //   1014: aload_3
    //   1015: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   1018: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1021: aload_1
    //   1022: astore 19
    //   1024: iload 6
    //   1026: istore 7
    //   1028: aload 18
    //   1030: astore 20
    //   1032: iload 12
    //   1034: istore 13
    //   1036: goto -201 -> 835
    //   1039: astore_3
    //   1040: iload 7
    //   1042: istore 6
    //   1044: goto -55 -> 989
    //   1047: astore_3
    //   1048: iconst_1
    //   1049: istore 12
    //   1051: goto -62 -> 989
    //   1054: astore_3
    //   1055: aload 19
    //   1057: astore 18
    //   1059: iconst_1
    //   1060: istore 12
    //   1062: goto -73 -> 989
    //   1065: astore_3
    //   1066: iconst_1
    //   1067: istore 12
    //   1069: goto -80 -> 989
    //   1072: astore_3
    //   1073: goto -744 -> 329
    //   1076: aload 19
    //   1078: astore 18
    //   1080: goto -566 -> 514
    //   1083: aconst_null
    //   1084: astore 18
    //   1086: iconst_0
    //   1087: istore 12
    //   1089: goto -269 -> 820
    //   1092: iload 8
    //   1094: istore 6
    //   1096: goto -779 -> 317
    //   1099: aconst_null
    //   1100: astore_1
    //   1101: goto -871 -> 230
    //   1104: aconst_null
    //   1105: astore 19
    //   1107: goto -272 -> 835
    //   1110: iconst_0
    //   1111: istore 10
    //   1113: goto -856 -> 257
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1116	0	this	TroopHandler
    //   0	1116	1	paramToServiceMsg	ToServiceMsg
    //   0	1116	2	paramFromServiceMsg	FromServiceMsg
    //   0	1116	3	paramObject	Object
    //   648	65	4	f1	float
    //   644	17	5	f2	float
    //   40	1055	6	i	int
    //   44	997	7	j	int
    //   288	805	8	k	int
    //   252	132	9	m	int
    //   261	851	10	n	int
    //   37	910	11	i1	int
    //   1	1087	12	bool1	boolean
    //   4	1031	13	bool2	boolean
    //   25	911	14	l1	long
    //   307	3	16	l2	long
    //   7	1078	18	localObject1	Object
    //   10	1096	19	localObject2	Object
    //   13	1018	20	localObject3	Object
    //   284	151	21	localRspGroupInfo	oidb_0x88d.RspGroupInfo
    // Exception table:
    //   from	to	target	type
    //   56	64	326	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   183	199	986	java/lang/Exception
    //   204	230	986	java/lang/Exception
    //   236	246	1039	java/lang/Exception
    //   272	286	1039	java/lang/Exception
    //   299	309	1039	java/lang/Exception
    //   376	385	1039	java/lang/Exception
    //   392	402	1039	java/lang/Exception
    //   419	430	1039	java/lang/Exception
    //   434	446	1039	java/lang/Exception
    //   460	482	1047	java/lang/Exception
    //   500	510	1047	java/lang/Exception
    //   487	496	1054	java/lang/Exception
    //   514	537	1065	java/lang/Exception
    //   537	599	1065	java/lang/Exception
    //   599	624	1065	java/lang/Exception
    //   624	643	1065	java/lang/Exception
    //   650	660	1065	java/lang/Exception
    //   664	694	1065	java/lang/Exception
    //   694	717	1065	java/lang/Exception
    //   717	740	1065	java/lang/Exception
    //   740	820	1065	java/lang/Exception
    //   64	79	1072	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void r(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getDetailOnlineMemberList, app == null");
      }
    }
    do
    {
      return;
      TroopOnlineMemberManager localTroopOnlineMemberManager = (TroopOnlineMemberManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(233);
      if (NetConnInfoCenter.getServerTime() < localTroopOnlineMemberManager.a(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.i("TroopHandler", 2, "getDetailOnlineMemberList, too frequency");
        }
        a(97, true, new Object[] { paramString, localTroopOnlineMemberManager.a(paramString) });
        return;
      }
      try
      {
        SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
        if (localSosoLbsInfo != null)
        {
          a(paramString, localSosoLbsInfo);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.i("TroopHandler", 1, "getDetailOnlineMemberList, e=" + paramString.toString());
        return;
      }
      if (NetConnInfoCenter.getServerTimeMillis() - localTroopOnlineMemberManager.a() > 300000L)
      {
        localTroopOnlineMemberManager.a(NetConnInfoCenter.getServerTimeMillis());
        SosoInterface.a(new zkz(this, 0, false, true, 180000L, false, false, "BizTroopHandler", SystemClock.uptimeMillis(), paramString));
        return;
      }
      a(paramString, null);
    } while (!QLog.isColorLevel());
    QLog.i("TroopHandler", 2, "location too frequency");
  }
  
  void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    do
    {
      return;
      paramToServiceMsg = new cmd0x3fe.RspBody();
    } while (paramObject == null);
    for (;;)
    {
      int j;
      int i;
      long l;
      int k;
      int m;
      int n;
      int i1;
      int i2;
      int i3;
      int i4;
      ArrayList localArrayList;
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((!paramToServiceMsg.int32_ret.has()) || (paramToServiceMsg.int32_ret.get() != 0) || (!paramToServiceMsg.uint32_subcmd.has())) {
          break;
        }
        j = paramToServiceMsg.uint32_subcmd.get();
        paramToServiceMsg = paramToServiceMsg.rpt_msg_level_info;
        paramFromServiceMsg = new Object[paramToServiceMsg.size()];
        i = 0;
        if (i >= paramToServiceMsg.size()) {
          break label377;
        }
        Object localObject = (cmd0x3fe.LevelInfo)paramToServiceMsg.get(i);
        l = ((cmd0x3fe.LevelInfo)localObject).uint64_uin.get();
        k = ((cmd0x3fe.LevelInfo)localObject).uint32_online_level.get();
        m = ((cmd0x3fe.LevelInfo)localObject).uint32_show_level.get();
        n = ((cmd0x3fe.LevelInfo)localObject).uint32_level_color.get();
        i1 = ((cmd0x3fe.LevelInfo)localObject).uint32_score.get();
        i2 = ((cmd0x3fe.LevelInfo)localObject).uint32_req_flag.get();
        i3 = ((cmd0x3fe.LevelInfo)localObject).uint32_req_timer.get();
        i4 = ((cmd0x3fe.LevelInfo)localObject).uint32_user_identity.get();
        paramObject = ((cmd0x3fe.LevelInfo)localObject).nickname.get();
        localArrayList = new ArrayList();
        localObject = ((cmd0x3fe.LevelInfo)localObject).rpt_medal_list.get();
        if (localObject == null) {
          break label336;
        }
        localObject = ((List)localObject).iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label336;
        }
        cmd0x3fe.Medal localMedal = (cmd0x3fe.Medal)((Iterator)localObject).next();
        localArrayList.add(new RecvGVideoLevelInfo.Medal(localMedal.uint32_id.get(), localMedal.uint32_level.get(), localMedal.uint32_type.get(), localMedal.str_icon_url.get(), localMedal.str_head_icon_url.get(), localMedal.str_name.get()));
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramToServiceMsg) {}
      QLog.e("TroopHandler", 2, "handleGetGVideoLevelInfo error", paramToServiceMsg);
      return;
      label336:
      paramFromServiceMsg[i] = new RecvGVideoLevelInfo(l, k, m, n, i1, i2, i3, j, i4, paramObject, localArrayList);
      i += 1;
    }
    label377:
    a(75, true, paramFromServiceMsg);
  }
  
  public void s(String paramString)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopHandler", 2, "getAllOnlineMemberList, app == null");
      }
      return;
    }
    ThreadManager.post(new zla(this, paramString), 8, null, true);
  }
  
  public void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    long l;
    StringBuffer localStringBuffer;
    for (boolean bool = true;; bool = false) {
      if (bool) {
        try
        {
          TroopManager localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
          l = Long.valueOf(paramToServiceMsg.extraData.getString("troopUin")).longValue();
          if (QLog.isColorLevel()) {
            QLog.d("TroopHandler", 2, "handleGetTroopCardDefaultNickBatch success=" + bool + " troopUin=" + l);
          }
          paramToServiceMsg = new oidb_0x787.RspBody();
          if ((a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) && (l == paramToServiceMsg.uint64_group_code.get()))
          {
            localStringBuffer = new StringBuffer();
            Iterator localIterator = paramToServiceMsg.rpt_msg_member_level_info.get().iterator();
            while (localIterator.hasNext())
            {
              paramObject = (oidb_0x787.MemberLevelInfo)localIterator.next();
              paramFromServiceMsg = "";
              paramToServiceMsg = "";
              String str = String.valueOf(paramObject.uint64_uin.get());
              if (QLog.isColorLevel())
              {
                localStringBuffer.append(" uin=");
                localStringBuffer.append(str.substring(0, 4));
              }
              if (paramObject.str_name.has()) {
                paramFromServiceMsg = paramObject.str_name.get().toStringUtf8();
              }
              if (paramObject.bytes_nick_name.has())
              {
                paramObject = paramObject.bytes_nick_name.get().toStringUtf8();
                paramToServiceMsg = paramObject;
                if (QLog.isColorLevel())
                {
                  localStringBuffer.append(" nick=");
                  localStringBuffer.append(Utils.a(paramObject));
                  paramToServiceMsg = paramObject;
                }
              }
              if (localTroopManager != null)
              {
                paramObject = paramFromServiceMsg;
                if (TextUtils.isEmpty(paramFromServiceMsg)) {
                  paramObject = null;
                }
                paramFromServiceMsg = paramToServiceMsg;
                if (TextUtils.isEmpty(paramToServiceMsg)) {
                  paramFromServiceMsg = null;
                }
                localTroopManager.a(String.valueOf(l), str, paramObject, -100, paramFromServiceMsg, null, -100, -100, -100, -100L, (byte)-100, -100L, -100.0D, null, -100);
              }
            }
          }
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TroopHandler", 2, "handleGetTroopCardDefaultNickBatch ex", paramToServiceMsg);
          }
        }
      }
    }
    a(112, true, new Object[] { String.valueOf(l) });
    if (QLog.isColorLevel()) {
      QLog.d("TroopHandler", 2, localStringBuffer.toString());
    }
    TroopNameHelper.a(String.valueOf(l), true);
  }
  
  public void t(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopHandler", 2, String.format("getTroopMemberInfoBAF troopUin:%s", new Object[] { paramString }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr = new TroopBatchAddFriendMgr(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopBatchAddFriendMgr.c(paramString);
  }
  
  public void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject = null;
    boolean bool1;
    if ((paramObject != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      bool2 = bool1;
      paramToServiceMsg = localObject;
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramFromServiceMsg = new oidb_0x9fa.RspBody();
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((!paramFromServiceMsg.web_info.has()) || (!((oidb_0x9fa.SimilarGroupWebInfo)paramFromServiceMsg.web_info.get()).bytes_url.has())) {
          continue;
        }
        paramToServiceMsg = ((oidb_0x9fa.SimilarGroupWebInfo)paramFromServiceMsg.web_info.get()).bytes_url.get().toStringUtf8();
        bool1 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        bool2 = false;
        paramToServiceMsg = localObject;
        continue;
        paramToServiceMsg = null;
        continue;
      }
      bool2 = bool1;
      a(65, bool2, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      paramToServiceMsg = null;
    }
  }
  
  public void u(String paramString)
  {
    try
    {
      Object localObject1 = new oidb_0x783.ReqBody();
      Object localObject2 = new oidb_0x783.UinListInfo();
      ((oidb_0x783.UinListInfo)localObject2).uint64_uin.set(Long.valueOf(paramString).longValue());
      ((oidb_0x783.ReqBody)localObject1).rpt_uinlist.add((MessageMicro)localObject2);
      ((oidb_0x783.ReqBody)localObject1).uint32_subcmd.set(3);
      ((oidb_0x783.ReqBody)localObject1).uint32_type.set(15);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1923);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(15);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x783.ReqBody)localObject1).toByteArray()));
      localObject1 = a("oidbSvc.0x783_15");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(5000L);
      ((ToServiceMsg)localObject1).extraData.putString("memberUin", paramString);
      b((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("TroopHandler", 2, "NumberFormatException");
    }
  }
  
  /* Error */
  public void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 12
    //   3: iconst_0
    //   4: istore 11
    //   6: aload_1
    //   7: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   10: ldc_w 1384
    //   13: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   16: lstore 13
    //   18: aload_1
    //   19: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   22: ldc_w 2289
    //   25: invokevirtual 128	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   28: istore 10
    //   30: aload_1
    //   31: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 4128
    //   37: invokevirtual 136	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   40: astore 18
    //   42: iconst_m1
    //   43: istore 5
    //   45: aload_2
    //   46: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   49: sipush 1000
    //   52: if_icmpne +591 -> 643
    //   55: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   58: dup
    //   59: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   62: astore_1
    //   63: aload_1
    //   64: aload_3
    //   65: checkcast 151	[B
    //   68: checkcast 151	[B
    //   71: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   74: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: astore_3
    //   78: aload_3
    //   79: astore_1
    //   80: aload_1
    //   81: ifnull +54 -> 135
    //   84: aload_1
    //   85: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   88: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   91: istore 6
    //   93: iload 6
    //   95: istore 5
    //   97: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   100: ifeq +35 -> 135
    //   103: ldc_w 2296
    //   106: iconst_2
    //   107: new 166	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   114: ldc_w 6662
    //   117: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload 6
    //   122: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: iload 6
    //   133: istore 5
    //   135: iload 5
    //   137: ifne +769 -> 906
    //   140: aload_1
    //   141: ifnull +765 -> 906
    //   144: aload_1
    //   145: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   148: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   151: ifeq +755 -> 906
    //   154: aload_1
    //   155: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   158: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   161: ifnull +745 -> 906
    //   164: aload_1
    //   165: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   168: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   171: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   174: astore_1
    //   175: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   178: dup
    //   179: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   182: astore 17
    //   184: aload 17
    //   186: aload_1
    //   187: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   190: pop
    //   191: iload 5
    //   193: ifeq +708 -> 901
    //   196: aload 17
    //   198: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   204: ifeq +697 -> 901
    //   207: aload 17
    //   209: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   212: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   215: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   218: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   221: astore_1
    //   222: aconst_null
    //   223: astore_3
    //   224: iload 5
    //   226: istore 6
    //   228: aload 17
    //   230: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   233: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   236: astore 17
    //   238: aload 17
    //   240: ifnonnull +122 -> 362
    //   243: iconst_0
    //   244: istore 8
    //   246: goto +669 -> 915
    //   249: aload_3
    //   250: ifnonnull +189 -> 439
    //   253: iload 9
    //   255: iload 8
    //   257: if_icmpge +182 -> 439
    //   260: iload 5
    //   262: istore 6
    //   264: aload 17
    //   266: iload 9
    //   268: invokeinterface 638 2 0
    //   273: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   276: astore 19
    //   278: iload 5
    //   280: istore 7
    //   282: aload 19
    //   284: ifnull +610 -> 894
    //   287: iload 5
    //   289: istore 6
    //   291: aload 19
    //   293: getfield 2272	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   296: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   299: lstore 15
    //   301: lload 15
    //   303: lload 13
    //   305: lcmp
    //   306: ifeq +72 -> 378
    //   309: iload 9
    //   311: iconst_1
    //   312: iadd
    //   313: istore 9
    //   315: goto -66 -> 249
    //   318: astore_3
    //   319: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +33 -> 355
    //   325: ldc_w 2296
    //   328: iconst_2
    //   329: new 166	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 6664
    //   339: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_3
    //   343: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   346: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: aload_3
    //   356: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   359: goto -279 -> 80
    //   362: iload 5
    //   364: istore 6
    //   366: aload 17
    //   368: invokeinterface 565 1 0
    //   373: istore 8
    //   375: goto +540 -> 915
    //   378: iload 5
    //   380: istore 6
    //   382: aload 19
    //   384: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   387: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   390: istore 5
    //   392: iload 5
    //   394: istore 7
    //   396: iload 5
    //   398: ifne +496 -> 894
    //   401: iload 5
    //   403: istore 6
    //   405: iload 5
    //   407: istore 7
    //   409: aload 19
    //   411: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   414: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   417: ifeq +477 -> 894
    //   420: iload 5
    //   422: istore 6
    //   424: aload 19
    //   426: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   429: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   432: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   435: astore_3
    //   436: goto -127 -> 309
    //   439: aload_3
    //   440: ifnull +448 -> 888
    //   443: aload_3
    //   444: getfield 4076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   447: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   450: ifeq +206 -> 656
    //   453: aload_3
    //   454: getfield 4076	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_app_privilege_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   457: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   460: istore 6
    //   462: aload_3
    //   463: getfield 5744	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   466: invokevirtual 6940	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:has	()Z
    //   469: ifeq +413 -> 882
    //   472: aload_3
    //   473: getfield 5744	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   476: getfield 5740	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   479: invokevirtual 279	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   482: ifeq +400 -> 882
    //   485: aload_3
    //   486: getfield 5744	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:st_group_ex_info	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly;
    //   489: getfield 5740	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupExInfoOnly:uint32_money_for_add_group	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   492: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   495: i2f
    //   496: ldc_w 6941
    //   499: fmul
    //   500: fstore 4
    //   502: goto +419 -> 921
    //   505: lload 13
    //   507: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   510: astore 19
    //   512: aload_0
    //   513: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   516: bipush 51
    //   518: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   521: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   524: astore 20
    //   526: aload 20
    //   528: ifnull +349 -> 877
    //   531: aload 20
    //   533: aload 19
    //   535: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   538: astore_3
    //   539: aload_3
    //   540: astore 17
    //   542: aload_3
    //   543: ifnonnull +19 -> 562
    //   546: new 511	com/tencent/mobileqq/data/TroopInfo
    //   549: dup
    //   550: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   553: astore 17
    //   555: aload 17
    //   557: aload 19
    //   559: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   562: aload 17
    //   564: iload 6
    //   566: i2l
    //   567: putfield 1702	com/tencent/mobileqq/data/TroopInfo:troopPrivilegeFlag	J
    //   570: aload 17
    //   572: iload 6
    //   574: i2l
    //   575: putfield 1699	com/tencent/mobileqq/data/TroopInfo:dwAppPrivilegeFlag	J
    //   578: aload 17
    //   580: fload 4
    //   582: putfield 6944	com/tencent/mobileqq/data/TroopInfo:mTroopNeedPayNumber	F
    //   585: aload 20
    //   587: aload 17
    //   589: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   592: aload_0
    //   593: bipush 60
    //   595: iconst_1
    //   596: iconst_5
    //   597: anewarray 103	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload 17
    //   604: getfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   607: aastore
    //   608: dup
    //   609: iconst_1
    //   610: aload 17
    //   612: invokevirtual 6861	com/tencent/mobileqq/data/TroopInfo:isAdmin	()Z
    //   615: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   618: aastore
    //   619: dup
    //   620: iconst_2
    //   621: iload 11
    //   623: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   626: aastore
    //   627: dup
    //   628: iconst_3
    //   629: iload 12
    //   631: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   634: aastore
    //   635: dup
    //   636: iconst_4
    //   637: aload 18
    //   639: aastore
    //   640: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   643: return
    //   644: iconst_0
    //   645: istore 11
    //   647: goto +286 -> 933
    //   650: iconst_0
    //   651: istore 12
    //   653: goto -148 -> 505
    //   656: iconst_1
    //   657: istore 11
    //   659: iload 5
    //   661: istore 6
    //   663: aload_1
    //   664: astore_3
    //   665: aload_0
    //   666: bipush 60
    //   668: iload 11
    //   670: iconst_5
    //   671: anewarray 103	java/lang/Object
    //   674: dup
    //   675: iconst_0
    //   676: lload 13
    //   678: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   681: aastore
    //   682: dup
    //   683: iconst_1
    //   684: iconst_0
    //   685: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   688: aastore
    //   689: dup
    //   690: iconst_2
    //   691: iconst_0
    //   692: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   695: aastore
    //   696: dup
    //   697: iconst_3
    //   698: iconst_0
    //   699: invokestatic 1353	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   702: aastore
    //   703: dup
    //   704: iconst_4
    //   705: aload 18
    //   707: aastore
    //   708: invokevirtual 112	com/tencent/mobileqq/app/TroopHandler:a	(IZLjava/lang/Object;)V
    //   711: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq -71 -> 643
    //   717: new 166	java/lang/StringBuilder
    //   720: dup
    //   721: sipush 150
    //   724: invokespecial 3798	java/lang/StringBuilder:<init>	(I)V
    //   727: astore_1
    //   728: aload_1
    //   729: ldc_w 6673
    //   732: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: ldc_w 6634
    //   738: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: iload 11
    //   743: invokevirtual 314	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   746: ldc_w 6636
    //   749: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload_2
    //   753: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   756: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc_w 3802
    //   762: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: lload 13
    //   767: invokevirtual 364	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   770: ldc_w 3804
    //   773: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: iload 10
    //   778: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   781: ldc_w 6640
    //   784: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: iload 6
    //   789: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   792: ldc_w 6642
    //   795: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: aload_3
    //   799: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: ldc_w 7089
    //   806: iconst_2
    //   807: aload_1
    //   808: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   811: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: return
    //   815: astore 17
    //   817: aconst_null
    //   818: astore_1
    //   819: aload_1
    //   820: astore_3
    //   821: iload 5
    //   823: istore 6
    //   825: iload 12
    //   827: istore 11
    //   829: invokestatic 94	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   832: ifeq -167 -> 665
    //   835: ldc_w 7089
    //   838: iconst_2
    //   839: aload 17
    //   841: invokevirtual 184	java/lang/Exception:toString	()Ljava/lang/String;
    //   844: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aload_1
    //   848: astore_3
    //   849: iload 5
    //   851: istore 6
    //   853: iload 12
    //   855: istore 11
    //   857: goto -192 -> 665
    //   860: astore 17
    //   862: iload 6
    //   864: istore 5
    //   866: goto -47 -> 819
    //   869: astore 17
    //   871: iconst_1
    //   872: istore 12
    //   874: goto -55 -> 819
    //   877: aconst_null
    //   878: astore_3
    //   879: goto -340 -> 539
    //   882: fconst_0
    //   883: fstore 4
    //   885: goto +36 -> 921
    //   888: iconst_0
    //   889: istore 11
    //   891: goto -232 -> 659
    //   894: iload 7
    //   896: istore 5
    //   898: goto -589 -> 309
    //   901: aconst_null
    //   902: astore_1
    //   903: goto -681 -> 222
    //   906: aconst_null
    //   907: astore_3
    //   908: iload 5
    //   910: istore 6
    //   912: goto -247 -> 665
    //   915: iconst_0
    //   916: istore 9
    //   918: goto -669 -> 249
    //   921: iload 6
    //   923: sipush 128
    //   926: iand
    //   927: ifeq -283 -> 644
    //   930: iconst_1
    //   931: istore 11
    //   933: iload 6
    //   935: sipush 512
    //   938: iand
    //   939: ifeq -289 -> 650
    //   942: iconst_1
    //   943: istore 12
    //   945: goto -440 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	948	0	this	TroopHandler
    //   0	948	1	paramToServiceMsg	ToServiceMsg
    //   0	948	2	paramFromServiceMsg	FromServiceMsg
    //   0	948	3	paramObject	Object
    //   500	384	4	f	float
    //   43	866	5	i	int
    //   91	848	6	j	int
    //   280	615	7	k	int
    //   244	130	8	m	int
    //   253	664	9	n	int
    //   28	749	10	i1	int
    //   4	928	11	bool1	boolean
    //   1	943	12	bool2	boolean
    //   16	750	13	l1	long
    //   299	3	15	l2	long
    //   182	429	17	localObject1	Object
    //   815	25	17	localException1	Exception
    //   860	1	17	localException2	Exception
    //   869	1	17	localException3	Exception
    //   40	666	18	str	String
    //   276	282	19	localObject2	Object
    //   524	62	20	localTroopManager	TroopManager
    // Exception table:
    //   from	to	target	type
    //   63	78	318	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   175	191	815	java/lang/Exception
    //   196	222	815	java/lang/Exception
    //   228	238	860	java/lang/Exception
    //   264	278	860	java/lang/Exception
    //   291	301	860	java/lang/Exception
    //   366	375	860	java/lang/Exception
    //   382	392	860	java/lang/Exception
    //   409	420	860	java/lang/Exception
    //   424	436	860	java/lang/Exception
    //   443	502	869	java/lang/Exception
    //   505	526	869	java/lang/Exception
    //   531	539	869	java/lang/Exception
    //   546	562	869	java/lang/Exception
    //   562	643	869	java/lang/Exception
  }
  
  /* Error */
  public void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 120	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 1384
    //   7: invokevirtual 1505	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   10: lstore 8
    //   12: aload_2
    //   13: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   16: sipush 1000
    //   19: if_icmpne +430 -> 449
    //   22: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   25: dup
    //   26: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   29: astore_1
    //   30: aload_1
    //   31: aload_3
    //   32: checkcast 151	[B
    //   35: checkcast 151	[B
    //   38: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   44: astore_2
    //   45: aload_2
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +402 -> 450
    //   51: aload_1
    //   52: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   55: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   58: istore 4
    //   60: iload 4
    //   62: ifne +387 -> 449
    //   65: aload_1
    //   66: ifnull +383 -> 449
    //   69: aload_1
    //   70: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   73: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   76: ifeq +373 -> 449
    //   79: aload_1
    //   80: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   83: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   86: ifnull +363 -> 449
    //   89: aload_1
    //   90: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   93: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   96: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   99: astore_1
    //   100: new 2263	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody
    //   103: dup
    //   104: invokespecial 2264	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: aload_1
    //   110: invokevirtual 2265	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   113: pop
    //   114: iload 4
    //   116: ifeq +27 -> 143
    //   119: aload_2
    //   120: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   123: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   126: ifeq +17 -> 143
    //   129: aload_2
    //   130: getfield 2294	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:str_errorinfo	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   133: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   136: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   139: invokestatic 1442	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   142: pop
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_2
    //   146: getfield 2268	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspBody:stzrspgroupinfo	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   149: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   152: astore 12
    //   154: aload 12
    //   156: ifnonnull +77 -> 233
    //   159: iconst_0
    //   160: istore 4
    //   162: goto +294 -> 456
    //   165: aload_1
    //   166: ifnonnull +283 -> 449
    //   169: iload 5
    //   171: iload 4
    //   173: if_icmpge +276 -> 449
    //   176: aload 12
    //   178: iload 5
    //   180: invokeinterface 638 2 0
    //   185: checkcast 2270	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo
    //   188: astore_3
    //   189: aload_1
    //   190: astore_2
    //   191: aload_3
    //   192: ifnull +22 -> 214
    //   195: aload_3
    //   196: getfield 2272	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   199: invokevirtual 289	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   202: lstore 10
    //   204: lload 10
    //   206: lload 8
    //   208: lcmp
    //   209: ifeq +36 -> 245
    //   212: aload_1
    //   213: astore_2
    //   214: iload 5
    //   216: iconst_1
    //   217: iadd
    //   218: istore 5
    //   220: aload_2
    //   221: astore_1
    //   222: goto -57 -> 165
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 323	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   230: goto -183 -> 47
    //   233: aload 12
    //   235: invokeinterface 565 1 0
    //   240: istore 4
    //   242: goto +214 -> 456
    //   245: aload_1
    //   246: astore_2
    //   247: aload_3
    //   248: getfield 2271	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   251: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   254: ifne -40 -> 214
    //   257: aload_1
    //   258: astore_2
    //   259: aload_3
    //   260: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   263: invokevirtual 2279	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:has	()Z
    //   266: ifeq -52 -> 214
    //   269: aload_3
    //   270: getfield 2276	tencent/im/oidb/cmd0x88d/oidb_0x88d$RspGroupInfo:stgroupinfo	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   273: invokevirtual 2280	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   276: checkcast 2278	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo
    //   279: astore_2
    //   280: aload_2
    //   281: getfield 5217	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_shutup_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   284: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   287: istore 6
    //   289: aload_2
    //   290: getfield 6554	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_shutup_timestamp_me	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   293: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   296: istore 7
    //   298: lload 8
    //   300: invokestatic 294	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   303: astore 13
    //   305: aload_0
    //   306: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   309: bipush 51
    //   311: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   314: checkcast 480	com/tencent/mobileqq/app/TroopManager
    //   317: astore 14
    //   319: aload 14
    //   321: aload 13
    //   323: invokevirtual 509	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   326: astore_3
    //   327: aload_3
    //   328: astore_1
    //   329: aload_3
    //   330: ifnonnull +17 -> 347
    //   333: new 511	com/tencent/mobileqq/data/TroopInfo
    //   336: dup
    //   337: invokespecial 1178	com/tencent/mobileqq/data/TroopInfo:<init>	()V
    //   340: astore_1
    //   341: aload_1
    //   342: aload 13
    //   344: putfield 1179	com/tencent/mobileqq/data/TroopInfo:troopuin	Ljava/lang/String;
    //   347: aload_1
    //   348: iload 6
    //   350: i2l
    //   351: putfield 1667	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   354: aload_1
    //   355: iload 7
    //   357: i2l
    //   358: putfield 1673	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp_me	J
    //   361: aload_1
    //   362: getfield 1667	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp	J
    //   365: lconst_0
    //   366: lcmp
    //   367: ifne +22 -> 389
    //   370: aload_1
    //   371: getfield 1673	com/tencent/mobileqq/data/TroopInfo:dwGagTimeStamp_me	J
    //   374: lconst_0
    //   375: lcmp
    //   376: ifne +13 -> 389
    //   379: aload_0
    //   380: getfield 56	com/tencent/mobileqq/app/TroopHandler:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   383: aload 13
    //   385: invokevirtual 608	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   388: pop
    //   389: aload 14
    //   391: aload_1
    //   392: invokevirtual 555	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   395: aload 14
    //   397: aload 13
    //   399: aload_0
    //   400: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   403: invokevirtual 885	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   406: aconst_null
    //   407: bipush 156
    //   409: aconst_null
    //   410: aconst_null
    //   411: bipush 156
    //   413: bipush 156
    //   415: bipush 156
    //   417: ldc2_w 2595
    //   420: iload 7
    //   422: i2l
    //   423: invokevirtual 7092	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   426: pop
    //   427: aload_0
    //   428: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   431: bipush 47
    //   433: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   436: checkcast 7094	com/tencent/mobileqq/troop/utils/TroopGagMgr
    //   439: aload 13
    //   441: iconst_1
    //   442: invokevirtual 7095	com/tencent/mobileqq/troop/utils/TroopGagMgr:a	(Ljava/lang/String;Z)V
    //   445: goto -231 -> 214
    //   448: astore_1
    //   449: return
    //   450: iconst_m1
    //   451: istore 4
    //   453: goto -393 -> 60
    //   456: iconst_0
    //   457: istore 5
    //   459: goto -294 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	this	TroopHandler
    //   0	462	1	paramToServiceMsg	ToServiceMsg
    //   0	462	2	paramFromServiceMsg	FromServiceMsg
    //   0	462	3	paramObject	Object
    //   58	394	4	i	int
    //   169	289	5	j	int
    //   287	62	6	k	int
    //   296	125	7	m	int
    //   10	289	8	l1	long
    //   202	3	10	l2	long
    //   152	82	12	localList	List
    //   303	137	13	str	String
    //   317	79	14	localTroopManager	TroopManager
    // Exception table:
    //   from	to	target	type
    //   30	45	225	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	114	448	java/lang/Exception
    //   119	143	448	java/lang/Exception
    //   145	154	448	java/lang/Exception
    //   176	189	448	java/lang/Exception
    //   195	204	448	java/lang/Exception
    //   233	242	448	java/lang/Exception
    //   247	257	448	java/lang/Exception
    //   259	327	448	java/lang/Exception
    //   333	347	448	java/lang/Exception
    //   347	389	448	java/lang/Exception
    //   389	445	448	java/lang/Exception
  }
  
  public void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("troop_uin");
    int i1 = paramToServiceMsg.extraData.getInt("nFlag");
    int i = -1;
    Object localObject1;
    int j;
    int n;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      for (localObject1 = new oidb_sso.OIDBSSOPkg();; localObject1 = (oidb_0x88d.GroupInfo)((oidb_0x88d.RspGroupInfo)localObject3).stgroupinfo.get())
      {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject1).mergeFrom((byte[])paramObject);
          if (paramObject != null)
          {
            j = paramObject.uint32_result.get();
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso.OIDBSSOPkg.result " + j);
              i = j;
            }
          }
          if ((i != 0) || (paramObject == null) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null)) {
            break label855;
          }
          paramObject = paramObject.bytes_bodybuffer.get().toByteArray();
          try
          {
            localObject2 = new oidb_0x88d.RspBody();
            ((oidb_0x88d.RspBody)localObject2).mergeFrom(paramObject);
            if ((i == 0) || (!((oidb_0x88d.RspBody)localObject2).str_errorinfo.has())) {
              break label850;
            }
            paramObject = String.valueOf(((oidb_0x88d.RspBody)localObject2).str_errorinfo.get().toByteArray());
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              try
              {
                Object localObject2;
                if (((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.has())
                {
                  j = ((oidb_0x88d.GroupInfo)localObject1).uint32_app_privilege_flag.get();
                  if ((j & 0x1) != 1)
                  {
                    bool1 = true;
                    break;
                    localObject3 = String.valueOf(l1);
                    localTroopManager = (TroopManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
                    localObject2 = localTroopManager.a((String)localObject3);
                    localObject1 = localObject2;
                    if (localObject2 == null)
                    {
                      localObject1 = new TroopInfo();
                      ((TroopInfo)localObject1).troopuin = ((String)localObject3);
                    }
                    ((TroopInfo)localObject1).troopPrivilegeFlag = j;
                    localTroopManager.b((TroopInfo)localObject1);
                    if (paramToServiceMsg.extraData.getBoolean("needUpdatePreferences", false)) {
                      o((String)localObject3);
                    }
                    a(59, true, new Object[] { Boolean.valueOf(((TroopInfo)localObject1).isAdmin()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject3 });
                    return;
                  }
                  bool1 = false;
                  break;
                  bool2 = false;
                  continue;
                }
                bool1 = true;
                j = i;
                a(59, bool1, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), String.valueOf(l1) });
                if (!QLog.isColorLevel()) {
                  continue;
                }
                paramToServiceMsg = new StringBuilder(150);
                paramToServiceMsg.append("handle_oidb_0x88d_0").append("|isSuccess = ").append(bool1).append("|resultcode = ").append(paramFromServiceMsg.getResultCode()).append("|troopuin = ").append(l1).append("|flag = ").append(i1).append("|result = ").append(j).append("|strErrorMsg = ").append(paramObject);
                QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
                return;
              }
              catch (Exception localException3)
              {
                bool2 = true;
                paramToServiceMsg = paramObject;
                continue;
              }
              localException1 = localException1;
              paramToServiceMsg = null;
              paramObject = paramToServiceMsg;
              j = i;
              bool1 = bool2;
              if (QLog.isColorLevel())
              {
                QLog.i("Q.troopdisband.", 2, localException1.toString());
                paramObject = paramToServiceMsg;
                j = i;
                bool1 = bool2;
                continue;
                paramObject = null;
              }
            }
          }
          localObject1 = null;
          j = i;
          for (;;)
          {
            try
            {
              localObject2 = ((oidb_0x88d.RspBody)localObject2).stzrspgroupinfo.get();
              if (localObject2 != null) {
                continue;
              }
              m = 0;
            }
            catch (Exception localException2)
            {
              int m;
              Object localObject3;
              int k;
              long l2;
              paramToServiceMsg = paramObject;
              i = j;
              continue;
              bool1 = false;
              continue;
              i = k;
              continue;
            }
            if ((localObject1 != null) || (n >= m)) {
              continue;
            }
            j = i;
            localObject3 = (oidb_0x88d.RspGroupInfo)((List)localObject2).get(n);
            k = i;
            if (localObject3 == null) {
              continue;
            }
            j = i;
            l2 = ((oidb_0x88d.RspGroupInfo)localObject3).uint64_group_code.get();
            if (l2 == l1) {
              continue;
            }
            n += 1;
          }
        }
        catch (InvalidProtocolBufferMicroException paramObject)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.troopdisband.", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramObject.toString());
            }
            paramObject.printStackTrace();
            paramObject = localObject1;
          }
          j = i;
          m = ((List)localObject2).size();
        }
        j = i;
        i = ((oidb_0x88d.RspGroupInfo)localObject3).uint32_result.get();
        k = i;
        if (i != 0) {
          break label843;
        }
        j = i;
        k = i;
        if (!((oidb_0x88d.RspGroupInfo)localObject3).stgroupinfo.has()) {
          break label843;
        }
        j = i;
      }
      if (localObject1 == null) {
        break label837;
      }
    }
    for (;;)
    {
      TroopManager localTroopManager;
      label837:
      label843:
      label850:
      label855:
      paramObject = null;
      j = i;
      continue;
      n = 0;
      break;
      if ((j & 0x2) != 2) {
        bool2 = true;
      }
    }
  }
  
  /* Error */
  public void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 146	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   4: sipush 1000
    //   7: if_icmpne +205 -> 212
    //   10: new 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   13: dup
    //   14: invokespecial 456	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   17: aload_3
    //   18: checkcast 151	[B
    //   21: checkcast 151	[B
    //   24: invokevirtual 457	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   27: checkcast 455	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +46 -> 78
    //   35: aload_1
    //   36: getfield 458	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   39: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   42: istore 4
    //   44: invokestatic 2796	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   47: ifeq +31 -> 78
    //   50: ldc_w 5354
    //   53: iconst_4
    //   54: new 166	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   61: ldc_w 7099
    //   64: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: iload 4
    //   69: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 983	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_1
    //   79: ifnull +133 -> 212
    //   82: aload_1
    //   83: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   86: invokevirtual 347	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   89: ifeq +123 -> 212
    //   92: aload_1
    //   93: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   96: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   99: ifnull +113 -> 212
    //   102: aload_1
    //   103: getfield 465	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   106: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   112: astore_1
    //   113: new 7101	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody
    //   116: dup
    //   117: invokespecial 7102	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:<init>	()V
    //   120: astore_2
    //   121: aload_2
    //   122: aload_1
    //   123: invokevirtual 7103	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload_2
    //   128: getfield 7107	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$RspBody:list	Ltencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList;
    //   131: invokevirtual 7110	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   134: checkcast 7109	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList
    //   137: astore_1
    //   138: aload_1
    //   139: getfield 7113	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:rpt_tab_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   142: invokevirtual 504	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   145: astore_2
    //   146: aload_1
    //   147: getfield 7116	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$GroupTabList:uint32_curr_tab_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   150: invokevirtual 164	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   153: i2l
    //   154: lstore 5
    //   156: lload 5
    //   158: ldc2_w 1865
    //   161: lcmp
    //   162: ifne +50 -> 212
    //   165: new 291	java/lang/String
    //   168: dup
    //   169: aload_2
    //   170: lload 5
    //   172: l2i
    //   173: invokeinterface 638 2 0
    //   178: checkcast 7118	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$TabItem
    //   181: getfield 7121	tencent/im/oidb/cmd0x9ab/oidb_0x9ab$TabItem:byt_tab_wording	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   184: invokevirtual 198	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   187: invokevirtual 469	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   190: invokespecial 2442	java/lang/String:<init>	([B)V
    //   193: pop
    //   194: aload_0
    //   195: getfield 472	com/tencent/mobileqq/app/TroopHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   198: bipush 108
    //   200: invokevirtual 478	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   203: checkcast 2835	com/tencent/mobileqq/troop/utils/TroopAppMgr
    //   206: iconst_1
    //   207: iconst_0
    //   208: invokevirtual 7124	com/tencent/mobileqq/troop/utils/TroopAppMgr:a	(ZI)Ljava/util/List;
    //   211: pop
    //   212: return
    //   213: astore_1
    //   214: invokestatic 2796	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   217: ifeq -5 -> 212
    //   220: ldc_w 5354
    //   223: iconst_4
    //   224: new 166	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   231: ldc_w 7126
    //   234: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload_1
    //   238: invokevirtual 562	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   241: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 101	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: return
    //   251: astore_1
    //   252: aload_1
    //   253: athrow
    //   254: astore_1
    //   255: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	TroopHandler
    //   0	256	1	paramToServiceMsg	ToServiceMsg
    //   0	256	2	paramFromServiceMsg	FromServiceMsg
    //   0	256	3	paramObject	Object
    //   42	26	4	i	int
    //   154	17	5	l	long
    // Exception table:
    //   from	to	target	type
    //   10	31	213	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   113	156	251	finally
    //   165	212	251	finally
    //   113	156	254	java/lang/Exception
    //   165	212	254	java/lang/Exception
  }
  
  public void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    long l3 = paramToServiceMsg.extraData.getLong("troop_uin");
    long l1 = -1L;
    int i;
    int j;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.troopInviteMember", 2, "handle_oidb_0x88d_0|oidb_sso parseFrom byte " + paramObject.toString());
          }
          paramObject.printStackTrace();
        }
        j = i;
        m = paramToServiceMsg.size();
      }
      i = paramToServiceMsg.uint32_result.get();
      if ((i != 0) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
        break label578;
      }
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      j = i;
    }
    for (;;)
    {
      try
      {
        paramObject = new oidb_0x88d.RspBody();
        j = i;
        paramObject.mergeFrom(paramToServiceMsg);
        j = i;
        paramToServiceMsg = paramObject.stzrspgroupinfo.get();
        if (paramToServiceMsg != null) {
          continue;
        }
        m = 0;
      }
      catch (Exception paramToServiceMsg)
      {
        int k;
        try
        {
          int m;
          bool2 = paramToServiceMsg.uint64_invite_no_auth_num_limit.has();
          if (!bool2) {
            continue;
          }
          bool1 = true;
        }
        catch (Exception paramToServiceMsg)
        {
          l2 = l1;
          continue;
        }
        try
        {
          l2 = paramToServiceMsg.uint64_invite_no_auth_num_limit.get();
          l1 = l2;
        }
        catch (Exception paramToServiceMsg)
        {
          bool1 = true;
          l2 = l1;
          continue;
        }
        try
        {
          a(85, true, new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
          bool2 = bool1;
          j = i;
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopInviteMember", 2, "handle_oidb_0x88d_0|isSuccess = " + bool2 + "|resultcode = " + paramFromServiceMsg.getResultCode() + "|troopuin = " + l3 + "|result = " + j + "|invite_no_auth_num_limit = " + l1);
          }
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          bool1 = true;
          l2 = l1;
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        i = j;
        long l2 = l1;
        j = i;
        bool2 = bool1;
        l1 = l2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.troopInviteMember", 2, paramToServiceMsg.toString());
        j = i;
        bool2 = bool1;
        l1 = l2;
        continue;
        l1 = -1L;
        bool1 = false;
        continue;
        i = k;
        continue;
        paramToServiceMsg = null;
        continue;
      }
      if (n < m)
      {
        j = i;
        paramObject = (oidb_0x88d.RspGroupInfo)paramToServiceMsg.get(n);
        k = i;
        if (paramObject != null)
        {
          j = i;
          l2 = paramObject.uint64_group_code.get();
          if (l2 != l3)
          {
            n += 1;
            continue;
          }
          j = i;
          i = paramObject.uint32_result.get();
          k = i;
          if (i == 0)
          {
            j = i;
            k = i;
            if (paramObject.stgroupinfo.has())
            {
              j = i;
              paramToServiceMsg = (oidb_0x88d.GroupInfo)paramObject.stgroupinfo.get();
              if (paramToServiceMsg == null) {}
            }
          }
        }
      }
      label578:
      j = i;
      continue;
      int n = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopHandler
 * JD-Core Version:    0.7.0.1
 */