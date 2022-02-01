package com.tencent.mobileqq.app;

import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.ConversationFacade.Callback;
import com.tencent.imcore.message.ConversationFacadeCallback;
import com.tencent.imcore.message.MessageRecordCursor;
import com.tencent.imcore.message.MessageRecordCursorCallback;
import com.tencent.imcore.message.MsgProxy;
import com.tencent.imcore.message.MsgProxyCallback;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.imcore.message.MsgProxyContainerCallback;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.Registry;
import com.tencent.imcore.message.core.CreateMessageRecordCallbackGenerator;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallbackGenerator;
import com.tencent.imcore.message.core.GetAioListCallbackGenerator;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallbackGenerator;
import com.tencent.imcore.message.core.codec.RoutingTypeGenerator;
import com.tencent.imcore.message.core.codec.UinTypeRoutingTypeMap;
import com.tencent.imcore.message.ext.codec.LbsGetAioList;
import com.tencent.imcore.message.ext.codec.PaiYiPaiGetAioList;
import com.tencent.imcore.message.ext.codec.PublicAccountGetAioList;
import com.tencent.imcore.message.ext.codec.UinType4UnreadMsgNumCallback;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ArkAppElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ArkBabyQReplyElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ArkSdkElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ConfessMsgElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.CrmFlagsElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.DeliverGiftElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.DoodleElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.EmojiBubbleElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.FlashChatElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.FlashPicCommonElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.FlashPictureElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.GameInterCommElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.GeneralFlagsElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.GoldMsgElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.GroupFileElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.LifeOnlineElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.LimitChatConfirmElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.MarketFaceElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.MarketTransmissionElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.NearByMsgElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.NearbyGiftElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.PictureElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.PokeMsgElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.PublicAccountElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.QQStoryCommentElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.QWalletElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.RichMsgElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ShakeWindowElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ShareLocationElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.SrcElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.TextElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.TipsInfoElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.TransferElemElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.TroopConfessElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.TroopStoryCommentElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.TroopStoryElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.UpdateAvatarElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.VideoFileElemDecoder;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.WriteTogetherElemDecoder;
import com.tencent.imcore.message.ext.codec.routingtype.ApprovalTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.AudioRoomMsgTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.BusinessCRMRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.C2CRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.CircleGroupRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.CmgameTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.ConfessTmpARoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.ConfessTmpBRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.ContactRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.DisRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.DisTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.FriendValidationRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.GameBuddyRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.GrpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.GrpTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.HotchatTopicRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.LBSFriendRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.LimitChatTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.MatchCampusChatTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.MatchChatTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.MovieTicketTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.NearbyAssistantRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.NearbyDatingRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.OpenGrpTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.PcQQSearchTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.PubRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.QQCircleMsgTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.QQGameMsgTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.SameStateRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.TribeTmpRoutingType;
import com.tencent.imcore.message.ext.codec.routingtype.WPARoutingType;
import com.tencent.imcore.message.ext.summary.WriteTogetherMessageSummaryCallback;
import com.tencent.imcore.message.msgproxy.MsgProxyUtilsCallback;
import com.tencent.mobileqq.activity.recent.msgbox.MsgBoxGetUnreadMsgNumCallback;
import com.tencent.mobileqq.apollo.message.ApolloElemDecoder;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.AtTroopMemberInfo.Callback;
import com.tencent.mobileqq.data.AtTroopMemberInfoCallback;
import com.tencent.mobileqq.data.ConversationInfo;
import com.tencent.mobileqq.data.ConversationInfo.Callback;
import com.tencent.mobileqq.data.ConversationInfoCallback;
import com.tencent.mobileqq.data.MessageNavInfoCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MessageRecord.Callback;
import com.tencent.mobileqq.data.MessageRecordCallback;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCacheCallback;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.codec.decoder.AppShareInfoDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.C2CMessageDecoderGenerator;
import com.tencent.mobileqq.service.message.codec.decoder.CreateGrpInPCDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.DiscussionUpdateDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.MsgType0x211Decoder;
import com.tencent.mobileqq.service.message.codec.decoder.MsgType0x2dcDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.MultiVideoDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.PTTDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.SharpVideoDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.SystemMessageDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.TempSessionDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.TroopAddMemberBroadcastDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.TroopSystemMessageDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.VideoDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.VideoQCallDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.buddyMessage.BuddyMessageDecoder;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallBackTofuAioMiniProfile;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallBackTofuAskAnonymously;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuBaseProfile;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuIntimateAnniversary;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuNicePics;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuQCircleIceBreak;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackWriteTogether;
import com.tencent.mobileqq.troop.blocktroop.TroopUnreadMsgNumCallback;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo.Callback;
import java.util.ArrayList;

public class QQMessageFacadeConfig
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends AtTroopMemberInfo.Callback>> sAtTroopMemberInfoCallbackCls;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=3)
  public static ArrayList<Class<? extends ConversationFacade.Callback>> sConversationFacadeCallbackCls;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=3)
  public static ArrayList<Class<? extends ConversationInfo.Callback>> sConversationInfoCallbackCls;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends MessageNavInfo.Callback>> sMessageNavInfoCallbackCls;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends MessageRecord.Callback>> sMessageRecordCallbackCls = new ArrayList();
  private QQMessageFacade mFacade;
  
  static
  {
    sMessageRecordCallbackCls.add(MessageRecordCallback.class);
    sMessageNavInfoCallbackCls = new ArrayList();
    sMessageNavInfoCallbackCls.add(MessageNavInfoCallback.class);
    sAtTroopMemberInfoCallbackCls = new ArrayList();
    sAtTroopMemberInfoCallbackCls.add(AtTroopMemberInfoCallback.class);
    sConversationInfoCallbackCls = new ArrayList();
    sConversationInfoCallbackCls.add(ConversationInfoCallback.class);
    sConversationFacadeCallbackCls = new ArrayList();
    sConversationFacadeCallbackCls.add(ConversationFacadeCallback.class);
    initAtClsInit();
  }
  
  public QQMessageFacadeConfig(QQMessageFacade paramQQMessageFacade)
  {
    this.mFacade = paramQQMessageFacade;
    this.mFacade.a(this);
  }
  
  private static void initAtClsInit()
  {
    registerMessageRecord();
    registerMessageNavInfo();
    registerAtTroopMemberInfo();
    registerConversationInfo();
    registerConversationFacade();
    MsgProxy.a(new MsgProxyCallback());
    MsgProxyContainer.a(new MsgProxyContainerCallback());
    MessageRecordCursor.a(new MessageRecordCursorCallback());
    MessageCache.a(new MessageCacheCallback());
    MsgProxyUtils.a(new MsgProxyUtilsCallback());
  }
  
  private static void registerAtTroopMemberInfo()
  {
    if (sAtTroopMemberInfoCallbackCls.isEmpty()) {
      return;
    }
    try
    {
      AtTroopMemberInfo.setCallback((AtTroopMemberInfo.Callback)((Class)sAtTroopMemberInfoCallbackCls.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void registerConversationFacade()
  {
    if (sConversationFacadeCallbackCls.isEmpty()) {
      return;
    }
    try
    {
      ConversationFacade.a((ConversationFacade.Callback)((Class)sConversationFacadeCallbackCls.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void registerConversationInfo()
  {
    if (sConversationInfoCallbackCls.isEmpty()) {
      return;
    }
    try
    {
      ConversationInfo.setCallback((ConversationInfo.Callback)((Class)sConversationInfoCallbackCls.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void registerCreateMessageRecordCallback()
  {
    CreateMessageRecordCallbackGenerator localCreateMessageRecordCallbackGenerator = MessageRecordFactory.a();
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7009), CreateMessageRecordCallbackTofuIntimateAnniversary.class);
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7010), CreateMessageRecordCallbackTofuBaseProfile.class);
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7011), CreateMessageRecordCallbackTofuNicePics.class);
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7012), CreateMessageRecordCallBackTofuAioMiniProfile.class);
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7013), CreateMessageRecordCallbackTofuQCircleIceBreak.class);
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7014), CreateMessageRecordCallbackWriteTogether.class);
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7015), CreateMessageRecordCallBackTofuAskAnonymously.class);
  }
  
  private void registerGetAioListCallback(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(LbsGetAioList.class);
    paramRegistry.a(PublicAccountGetAioList.class);
    paramRegistry.a(PaiYiPaiGetAioList.class);
  }
  
  private static void registerMessageNavInfo()
  {
    if (sMessageNavInfoCallbackCls.isEmpty()) {
      return;
    }
    try
    {
      MessageNavInfo.a((MessageNavInfo.Callback)((Class)sMessageNavInfoCallbackCls.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private static void registerMessageRecord()
  {
    if (sMessageRecordCallbackCls.isEmpty()) {
      return;
    }
    try
    {
      MessageRecord.setCallback((MessageRecord.Callback)((Class)sMessageRecordCallbackCls.get(0)).newInstance());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void registerMessageSummary(Registry paramRegistry)
  {
    paramRegistry.a().a(WriteTogetherMessageSummaryCallback.class);
  }
  
  private void registerRoutingType(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(Integer.valueOf(1), C2CRoutingType.class);
    paramRegistry.a(Integer.valueOf(3), GrpTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(6), WPARoutingType.class);
    paramRegistry.a(Integer.valueOf(8), PubRoutingType.class);
    paramRegistry.a(Integer.valueOf(10), ContactRoutingType.class);
    paramRegistry.a(Integer.valueOf(5), DisTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(11), SameStateRoutingType.class);
    paramRegistry.a(Integer.valueOf(12), LBSFriendRoutingType.class);
    paramRegistry.a(Integer.valueOf(23), TribeTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(25), ConfessTmpARoutingType.class);
    paramRegistry.a(Integer.valueOf(26), ConfessTmpBRoutingType.class);
    paramRegistry.a(Integer.valueOf(24), MovieTicketTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(4), DisRoutingType.class);
    paramRegistry.a(Integer.valueOf(2), GrpRoutingType.class);
    paramRegistry.a(Integer.valueOf(14), OpenGrpTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(16), CircleGroupRoutingType.class);
    paramRegistry.a(Integer.valueOf(17), FriendValidationRoutingType.class);
    paramRegistry.a(Integer.valueOf(18), PcQQSearchTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(15), BusinessCRMRoutingType.class);
    paramRegistry.a(Integer.valueOf(19), NearbyDatingRoutingType.class);
    paramRegistry.a(Integer.valueOf(20), NearbyAssistantRoutingType.class);
    paramRegistry.a(Integer.valueOf(21), HotchatTopicRoutingType.class);
    paramRegistry.a(Integer.valueOf(22), ApprovalTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(28), LimitChatTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(27), CmgameTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(29), MatchChatTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(30), MatchCampusChatTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(31), QQGameMsgTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(32), QQCircleMsgTmpRoutingType.class);
    paramRegistry.a(Integer.valueOf(33), GameBuddyRoutingType.class);
    paramRegistry.a(Integer.valueOf(34), AudioRoomMsgTmpRoutingType.class);
  }
  
  private void registerUnreadMsgNumCallback(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(TroopUnreadMsgNumCallback.class);
    paramRegistry.a(MsgBoxGetUnreadMsgNumCallback.class);
    paramRegistry.a(UinType4UnreadMsgNumCallback.class);
  }
  
  protected void registerPBMsgElemDecoder(Registry paramRegistry)
  {
    paramRegistry.a(ShakeWindowElemDecoder.class);
    paramRegistry.a(TroopConfessElemDecoder.class);
    paramRegistry.a(DeliverGiftElemDecoder.class);
    paramRegistry.a(ApolloElemDecoder.class);
    paramRegistry.a(GroupFileElemDecoder.class);
    paramRegistry.a(ArkAppElemDecoder.class);
    paramRegistry.a(MarketTransmissionElemDecoder.class);
    paramRegistry.a(FlashChatElemDecoder.class);
    paramRegistry.a(VideoFileElemDecoder.class);
    paramRegistry.a(TipsInfoElemDecoder.class);
    paramRegistry.a(PublicAccountElemDecoder.class);
    paramRegistry.a(TransferElemElemDecoder.class);
    paramRegistry.a(QWalletElemDecoder.class);
    paramRegistry.a(PokeMsgElemDecoder.class);
    paramRegistry.a(RichMsgElemDecoder.class);
    paramRegistry.a(MarketFaceElemDecoder.class);
    paramRegistry.a(PictureElemDecoder.class);
    paramRegistry.a(SrcElemDecoder.class);
    paramRegistry.a(TextElemDecoder.class);
    paramRegistry.a(FlashPictureElemDecoder.class);
    paramRegistry.a(FlashPicCommonElemDecoder.class);
    paramRegistry.a(QQStoryCommentElemDecoder.class);
    paramRegistry.a(NearbyGiftElemDecoder.class);
    paramRegistry.a(TroopStoryCommentElemDecoder.class);
    paramRegistry.a(TroopStoryElemDecoder.class);
    paramRegistry.a(DoodleElemDecoder.class);
    paramRegistry.a(ArkBabyQReplyElemDecoder.class);
    paramRegistry.a(ArkSdkElemDecoder.class);
    paramRegistry.a(EmojiBubbleElemDecoder.class);
    paramRegistry.a(LimitChatConfirmElemDecoder.class);
    paramRegistry.a(ShareLocationElemDecoder.class);
    paramRegistry.a(LifeOnlineElemDecoder.class);
    paramRegistry.a(NearByMsgElemDecoder.class);
    paramRegistry.a(GeneralFlagsElemDecoder.class);
    paramRegistry.a(CrmFlagsElemDecoder.class);
    paramRegistry.a(UpdateAvatarElemDecoder.class);
    paramRegistry.a(GoldMsgElemDecoder.class);
    paramRegistry.a(ConfessMsgElemDecoder.class);
    paramRegistry.a(GameInterCommElemDecoder.class);
    paramRegistry.a(WriteTogetherElemDecoder.class);
  }
  
  protected void registerUinTypeRoutingType(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(0, 1);
    paramRegistry.a(1000, 3);
    paramRegistry.a(10004, 24);
    paramRegistry.a(1005, 6);
    paramRegistry.a(1008, 8);
    paramRegistry.a(1006, 10);
    paramRegistry.a(1004, 5);
    paramRegistry.a(1009, 11);
    paramRegistry.a(3000, 4);
    paramRegistry.a(1, 2);
    paramRegistry.a(1001, 12);
    paramRegistry.a(10002, 23);
    paramRegistry.a(1033, 25);
    paramRegistry.a(1034, 26);
    paramRegistry.a(1020, 14);
    paramRegistry.a(1021, 16);
    paramRegistry.a(1022, 17);
    paramRegistry.a(1023, 18);
    paramRegistry.a(1025, 15);
    paramRegistry.a(1024, 15);
    paramRegistry.a(1010, 19);
    paramRegistry.a(7400, 22);
    paramRegistry.a(1026, 21);
    paramRegistry.a(1037, 28);
    paramRegistry.a(1036, 27);
    paramRegistry.a(1044, 29);
    paramRegistry.a(1045, 30);
    paramRegistry.a(10007, 31);
    paramRegistry.a(10008, 32);
    paramRegistry.a(10009, 33);
    paramRegistry.a(10010, 34);
  }
  
  public void start()
  {
    Registry localRegistry = this.mFacade.a();
    C2CMessageDecoderGenerator localC2CMessageDecoderGenerator = localRegistry.a();
    localC2CMessageDecoderGenerator.a(Integer.valueOf(734), SharpVideoDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(193), VideoDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(562), VideoQCallDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(519), MultiVideoDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(524), DiscussionUpdateDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(528), MsgType0x210Decoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(529), MsgType0x211Decoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(208), PTTDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(38), CreateGrpInPCDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(732), MsgType0x2dcDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(33), TroopAddMemberBroadcastDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(140), TempSessionDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(141), TempSessionDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(187), SystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(188), SystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(189), SystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(190), SystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(191), SystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(84), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(85), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(86), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(87), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(35), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(36), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(37), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(45), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(46), TroopSystemMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(9), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(10), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(31), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(79), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(97), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(120), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(132), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(133), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(166), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(Integer.valueOf(167), BuddyMessageDecoder.class);
    localC2CMessageDecoderGenerator.a(AppShareInfoDecoder.class);
    registerCreateMessageRecordCallback();
    registerPBMsgElemDecoder(localRegistry);
    registerUinTypeRoutingType(localRegistry);
    registerRoutingType(localRegistry);
    registerMessageSummary(localRegistry);
    registerUnreadMsgNumCallback(localRegistry);
    registerGetAioListCallback(localRegistry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQMessageFacadeConfig
 * JD-Core Version:    0.7.0.1
 */