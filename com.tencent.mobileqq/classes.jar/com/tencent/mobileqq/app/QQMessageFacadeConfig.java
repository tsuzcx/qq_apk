package com.tencent.mobileqq.app;

import com.tencent.av.aio.message.DavBubbleElemDecoder;
import com.tencent.imcore.message.BaseMessageManager;
import com.tencent.imcore.message.BaseMessageManagerCallback;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDiscCallback;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.BaseMessageProcessorCallback;
import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.C2CMessageManagerCallback;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.imcore.message.C2CMessageProcessorCallback;
import com.tencent.imcore.message.ConversationFacade;
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
import com.tencent.imcore.message.adder.AddMessageHandlerGenerator;
import com.tencent.imcore.message.adder.C2CAddMessageHandlerGenerator;
import com.tencent.imcore.message.adder.C2CIMaxAdAccountAddMessageHandler;
import com.tencent.imcore.message.adder.C2CIceBreakingAddMessageHandler;
import com.tencent.imcore.message.adder.C2CPaAdAddMessageHandler;
import com.tencent.imcore.message.adder.C2CTroopVideoAddMessageHandler;
import com.tencent.imcore.message.adder.CommonAddMessageHandler;
import com.tencent.imcore.message.adder.LongMixAddMessageHandler;
import com.tencent.imcore.message.adder.LongTextAddMessageHandler;
import com.tencent.imcore.message.adder.StructingAddMessageHandler;
import com.tencent.imcore.message.adder.UniteGrayTipAddMessageHandler;
import com.tencent.imcore.message.aiolist.AioMsgHandlerGenerator;
import com.tencent.imcore.message.aiolist.ArkAioMsgHandler;
import com.tencent.imcore.message.aiolist.ChatAioMsgHandler;
import com.tencent.imcore.message.aiolist.GrayTipsAioMsgHandler;
import com.tencent.imcore.message.aiolist.PokeAioMsgHandler;
import com.tencent.imcore.message.aiolist.StructingAioMsgHandler;
import com.tencent.imcore.message.aiolist.TofuMsgHandler;
import com.tencent.imcore.message.core.CreateMessageRecordCallbackGenerator;
import com.tencent.imcore.message.core.ExtractMessageSummaryCallbackGenerator;
import com.tencent.imcore.message.core.GetAioListCallbackGenerator;
import com.tencent.imcore.message.core.GetUnreadMsgNumCallbackGenerator;
import com.tencent.imcore.message.core.codec.RoutingTypeGenerator;
import com.tencent.imcore.message.core.codec.UinTypeRoutingTypeMap;
import com.tencent.imcore.message.decoder.ActiveFriendsMsgDecoder;
import com.tencent.imcore.message.decoder.ApolloMsgDecoder;
import com.tencent.imcore.message.decoder.ArkAppMsgDecoder;
import com.tencent.imcore.message.decoder.ArkBabyQReplyMsgDecoder;
import com.tencent.imcore.message.decoder.ArkSdkShareMsgDecoder;
import com.tencent.imcore.message.decoder.DefaultMsgDecoder;
import com.tencent.imcore.message.decoder.DeviceFileMsgDecoder;
import com.tencent.imcore.message.decoder.FileMsgDecoder;
import com.tencent.imcore.message.decoder.FlashChatMsgDecoder;
import com.tencent.imcore.message.decoder.FuDaiMsgDecoder;
import com.tencent.imcore.message.decoder.GrayTipsMsgDecoder;
import com.tencent.imcore.message.decoder.HiboomMsgDecoder;
import com.tencent.imcore.message.decoder.MarketFaceMsgDecoder;
import com.tencent.imcore.message.decoder.MessageDecoderGenerator;
import com.tencent.imcore.message.decoder.MixMsgDecoder;
import com.tencent.imcore.message.decoder.MixedMsgDecoder;
import com.tencent.imcore.message.decoder.PicMsgDecoder;
import com.tencent.imcore.message.decoder.PokeEmoMsgDecoder;
import com.tencent.imcore.message.decoder.PokeMsgDecoder;
import com.tencent.imcore.message.decoder.PttMsgDecoder;
import com.tencent.imcore.message.decoder.PublicAccountMsgDecoder;
import com.tencent.imcore.message.decoder.QQStoryMsgDecoder;
import com.tencent.imcore.message.decoder.SecretaryMsgDecoder;
import com.tencent.imcore.message.decoder.ShakeWindowMsgDecoder;
import com.tencent.imcore.message.decoder.StickerMsgDecoder;
import com.tencent.imcore.message.decoder.StructMsgDecoder;
import com.tencent.imcore.message.decoder.SystemMsgDecoder;
import com.tencent.imcore.message.decoder.SystemStructMsgDecoder;
import com.tencent.imcore.message.decoder.TextMsgDecoder;
import com.tencent.imcore.message.decoder.TribeShortVideoMsgDecoder;
import com.tencent.imcore.message.decoder.TroopConfessMsgDecoder;
import com.tencent.imcore.message.decoder.TroopEffectPicMsgDecoder;
import com.tencent.imcore.message.decoder.TroopRewardMsgDecoder;
import com.tencent.imcore.message.decoder.TroopSignMsgDecoder;
import com.tencent.imcore.message.decoder.UniteGrayMsgDecoder;
import com.tencent.imcore.message.decoder.WalletMsgDecoder;
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
import com.tencent.imcore.message.msgboxappender.ConfessMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.LbsFriendMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.LbsHelloMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.MatchChatOrCircleMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.MsgBoxAppenderGenerator;
import com.tencent.imcore.message.msgboxappender.RecommendMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.SameStateMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.SystemMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.TroopSuspiciousMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.TroopSystemMsgBoxAppender;
import com.tencent.imcore.message.msgboxappender.VoteMsgBoxAppender;
import com.tencent.imcore.message.msgproxy.MsgProxyUtilsCallback;
import com.tencent.mobileqq.activity.recent.msgbox.MsgBoxGetUnreadMsgNumCallback;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.generalflag.BubbleMsgGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.DouTuMsgGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.ExtensionInfoGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.FileAssistantGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.GeneralFlagProviderGenerator;
import com.tencent.mobileqq.app.generalflag.KplRoleGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.PasteMsgGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.PicMsgAioSyncGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.PicMsgCustomFeatureGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.PicMsgSyncQZoneGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.PttMsgGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.RedBagGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.ReplyTextGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.RobotGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.ShortVideoGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.StickerMsgGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.StructLongTextGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.TroopRobotGeneralFlagProvider;
import com.tencent.mobileqq.app.generalflag.WantGiftGeneralFlagProvider;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHookerCallback;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManager;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyManagerCallback;
import com.tencent.mobileqq.app.pbsendhandler.AnonymousMsgPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.ClassicHeadActivityPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.ClearingMsgPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.CreatePbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.GeneralFlagPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.KplTempMsgPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.PbSendReqHandlerGenerator;
import com.tencent.mobileqq.app.pbsendhandler.PicMsgPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.RedBagPbSendReqHandler;
import com.tencent.mobileqq.app.pbsendhandler.StructingMsgPbSendReqHandler;
import com.tencent.mobileqq.app.richtext.AISpecialGuideRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.ArkAppRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.ArkSDKShakeRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.BabyQReplyRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.FlashChatRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.HiboomRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.LimitChatConfirmRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.MediaMarkfaceRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.MediaPicRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.MediaPttRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.MediaShortVideoRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.MixMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.PokeEmoMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.PokeMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.ReplyTextMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.RichTextAndMsgViaProviderGenerator;
import com.tencent.mobileqq.app.richtext.ScribbleMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.ShakeWindowRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.StickerMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.StructLongTextRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.StructMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.TextMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.TroopStoryRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.TroopWantGiftMsgRichTextAndMsgViaProvider;
import com.tencent.mobileqq.app.richtext.VasApolloRichTextAndMsgViaProvider;
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
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtilCallback;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipParamCallback;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCacheCallback;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiverCallback;
import com.tencent.mobileqq.service.message.MessageFactorySender;
import com.tencent.mobileqq.service.message.MessageFactorySenderCallback;
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
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackForBeancurd;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuBaseProfile;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuIntimateAnniversary;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuNicePics;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackTofuQCircleIceBreak;
import com.tencent.mobileqq.service.message.mrcallback.CreateMessageRecordCallbackWriteTogether;
import com.tencent.mobileqq.troop.blocktroop.TroopUnreadMsgNumCallback;
import com.tencent.mobileqq.troop.data.MessageNavInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo.Callback;
import com.tencent.mobileqq.troop.data.TroopMessageProcessor;
import com.tencent.mobileqq.troop.data.TroopMessageProcessorCallback;
import java.util.ArrayList;

public class QQMessageFacadeConfig
{
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreCustomizedConfig.yml", version=2)
  public static ArrayList<Class<? extends AtTroopMemberInfo.Callback>> sAtTroopMemberInfoCallbackCls;
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
    initAtClsInit();
  }
  
  public QQMessageFacadeConfig(QQMessageFacade paramQQMessageFacade)
  {
    this.mFacade = paramQQMessageFacade;
  }
  
  private static void initAtClsInit()
  {
    registerMessageRecord();
    registerMessageNavInfo();
    registerAtTroopMemberInfo();
    registerConversationInfo();
    ConversationFacade.a(new ConversationFacadeCallback());
    MsgProxy.a(new MsgProxyCallback());
    MsgProxyContainer.a(new MsgProxyContainerCallback());
    MessageRecordCursor.a(new MessageRecordCursorCallback());
    MessageCache.a(new MessageCacheCallback());
    MsgProxyUtils.a(new MsgProxyUtilsCallback());
    UniteGrayTipParam.a(new UniteGrayTipParamCallback());
    UniteGrayTipMsgUtil.a(new UniteGrayTipMsgUtilCallback());
    BaseMessageProcessor.a(new BaseMessageProcessorCallback());
    MsgNotifyManager.a(new MsgNotifyManagerCallback());
    C2CMessageProcessor.a(new C2CMessageProcessorCallback());
    BaseMessageManager.a(new BaseMessageManagerCallback());
    BaseMessageManagerForTroopAndDisc.a(new BaseMessageManagerForTroopAndDiscCallback());
    MessageFactorySender.a(new MessageFactorySenderCallback());
    MessageFactoryReceiver.a(new MessageFactoryReceiverCallback());
    ParcelHooker.a(new ParcelHookerCallback());
    MessageHandlerUtils.a(new MessageHandlerUtilsCallback());
    TroopMessageProcessor.a(new TroopMessageProcessorCallback());
    C2CMessageManager.a(new C2CMessageManagerCallback());
  }
  
  private void registerAddMessageHandler(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(UniteGrayTipAddMessageHandler.class);
    paramRegistry.a(StructingAddMessageHandler.class);
    paramRegistry.a(CommonAddMessageHandler.class);
    paramRegistry.a(LongTextAddMessageHandler.class);
    paramRegistry.a(LongMixAddMessageHandler.class);
  }
  
  private void registerAioMsgHandler(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(ArkAioMsgHandler.class);
    paramRegistry.a(TofuMsgHandler.class);
    paramRegistry.a(ChatAioMsgHandler.class);
    paramRegistry.a(GrayTipsAioMsgHandler.class);
    paramRegistry.a(StructingAioMsgHandler.class);
    paramRegistry.a(PokeAioMsgHandler.class);
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
  
  private void registerC2CAddMessageHandler(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(C2CTroopVideoAddMessageHandler.class);
    paramRegistry.a(C2CPaAdAddMessageHandler.class);
    paramRegistry.a(C2CIMaxAdAccountAddMessageHandler.class);
    paramRegistry.a(C2CIceBreakingAddMessageHandler.class);
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
    localCreateMessageRecordCallbackGenerator.a(Integer.valueOf(-7016), CreateMessageRecordCallbackForBeancurd.class);
  }
  
  private void registerGeneralFlagProvider(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(BubbleMsgGeneralFlagProvider.class);
    paramRegistry.a(RedBagGeneralFlagProvider.class);
    paramRegistry.a(StickerMsgGeneralFlagProvider.class);
    paramRegistry.a(StructLongTextGeneralFlagProvider.class);
    paramRegistry.a(ExtensionInfoGeneralFlagProvider.class);
    paramRegistry.a(WantGiftGeneralFlagProvider.class);
    paramRegistry.a(RobotGeneralFlagProvider.class);
    paramRegistry.a(PasteMsgGeneralFlagProvider.class);
    paramRegistry.a(TroopRobotGeneralFlagProvider.class);
    paramRegistry.a(DouTuMsgGeneralFlagProvider.class);
    paramRegistry.a(PicMsgCustomFeatureGeneralFlagProvider.class);
    paramRegistry.a(KplRoleGeneralFlagProvider.class);
    paramRegistry.a(ShortVideoGeneralFlagProvider.class);
    paramRegistry.a(PicMsgAioSyncGeneralFlagProvider.class);
    paramRegistry.a(PicMsgSyncQZoneGeneralFlagProvider.class);
    paramRegistry.a(PttMsgGeneralFlagProvider.class);
    paramRegistry.a(ReplyTextGeneralFlagProvider.class);
    paramRegistry.a(FileAssistantGeneralFlagProvider.class);
  }
  
  private void registerGetAioListCallback(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(LbsGetAioList.class);
    paramRegistry.a(PublicAccountGetAioList.class);
    paramRegistry.a(PaiYiPaiGetAioList.class);
  }
  
  private void registerMessageDecoder(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(SecretaryMsgDecoder.class);
    paramRegistry.a(SystemStructMsgDecoder.class);
    paramRegistry.a(StructMsgDecoder.class);
    paramRegistry.a(ActiveFriendsMsgDecoder.class);
    paramRegistry.a(TextMsgDecoder.class);
    paramRegistry.a(PokeMsgDecoder.class);
    paramRegistry.a(PokeEmoMsgDecoder.class);
    paramRegistry.a(UniteGrayMsgDecoder.class);
    paramRegistry.a(MixedMsgDecoder.class);
    paramRegistry.a(SystemMsgDecoder.class);
    paramRegistry.a(MarketFaceMsgDecoder.class);
    paramRegistry.a(StickerMsgDecoder.class);
    paramRegistry.a(MixMsgDecoder.class);
    paramRegistry.a(GrayTipsMsgDecoder.class);
    paramRegistry.a(DeviceFileMsgDecoder.class);
    paramRegistry.a(PublicAccountMsgDecoder.class);
    paramRegistry.a(PicMsgDecoder.class);
    paramRegistry.a(FileMsgDecoder.class);
    paramRegistry.a(ShakeWindowMsgDecoder.class);
    paramRegistry.a(PttMsgDecoder.class);
    paramRegistry.a(WalletMsgDecoder.class);
    paramRegistry.a(FuDaiMsgDecoder.class);
    paramRegistry.a(ApolloMsgDecoder.class);
    paramRegistry.a(ArkAppMsgDecoder.class);
    paramRegistry.a(ArkBabyQReplyMsgDecoder.class);
    paramRegistry.a(ArkSdkShareMsgDecoder.class);
    paramRegistry.a(FlashChatMsgDecoder.class);
    paramRegistry.a(HiboomMsgDecoder.class);
    paramRegistry.a(TroopRewardMsgDecoder.class);
    paramRegistry.a(QQStoryMsgDecoder.class);
    paramRegistry.a(TribeShortVideoMsgDecoder.class);
    paramRegistry.a(TroopSignMsgDecoder.class);
    paramRegistry.a(TroopEffectPicMsgDecoder.class);
    paramRegistry.a(TroopConfessMsgDecoder.class);
    paramRegistry.a(DefaultMsgDecoder.class);
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
  
  private void registerMsgBoxAppender(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(SameStateMsgBoxAppender.class);
    paramRegistry.a(LbsHelloMsgBoxAppender.class);
    paramRegistry.a(LbsFriendMsgBoxAppender.class);
    paramRegistry.a(SystemMsgBoxAppender.class);
    paramRegistry.a(TroopSystemMsgBoxAppender.class);
    paramRegistry.a(TroopSuspiciousMsgBoxAppender.class);
    paramRegistry.a(VoteMsgBoxAppender.class);
    paramRegistry.a(RecommendMsgBoxAppender.class);
    paramRegistry.a(ConfessMsgBoxAppender.class);
    paramRegistry.a(MatchChatOrCircleMsgBoxAppender.class);
  }
  
  private void registerPbSendReqHandler(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(RedBagPbSendReqHandler.class);
    paramRegistry.a(AnonymousMsgPbSendReqHandler.class);
    paramRegistry.a(ClearingMsgPbSendReqHandler.class);
    paramRegistry.a(ClassicHeadActivityPbSendReqHandler.class);
    paramRegistry.a(KplTempMsgPbSendReqHandler.class);
    paramRegistry.a(CreatePbSendReqHandler.class);
    paramRegistry.a(StructingMsgPbSendReqHandler.class);
    paramRegistry.a(GeneralFlagPbSendReqHandler.class);
    paramRegistry.a(PicMsgPbSendReqHandler.class);
  }
  
  private void registerRichTextAndMsgViaProvider(Registry paramRegistry)
  {
    paramRegistry = paramRegistry.a();
    paramRegistry.a(TextMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(ReplyTextMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(TroopWantGiftMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(MediaPicRichTextAndMsgViaProvider.class);
    paramRegistry.a(MediaPttRichTextAndMsgViaProvider.class);
    paramRegistry.a(MediaMarkfaceRichTextAndMsgViaProvider.class);
    paramRegistry.a(StickerMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(VasApolloRichTextAndMsgViaProvider.class);
    paramRegistry.a(StructMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(ShakeWindowRichTextAndMsgViaProvider.class);
    paramRegistry.a(MediaShortVideoRichTextAndMsgViaProvider.class);
    paramRegistry.a(ArkAppRichTextAndMsgViaProvider.class);
    paramRegistry.a(FlashChatRichTextAndMsgViaProvider.class);
    paramRegistry.a(HiboomRichTextAndMsgViaProvider.class);
    paramRegistry.a(PokeMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(PokeEmoMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(StructLongTextRichTextAndMsgViaProvider.class);
    paramRegistry.a(AISpecialGuideRichTextAndMsgViaProvider.class);
    paramRegistry.a(MixMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(TroopStoryRichTextAndMsgViaProvider.class);
    paramRegistry.a(ScribbleMsgRichTextAndMsgViaProvider.class);
    paramRegistry.a(BabyQReplyRichTextAndMsgViaProvider.class);
    paramRegistry.a(ArkSDKShakeRichTextAndMsgViaProvider.class);
    paramRegistry.a(LimitChatConfirmRichTextAndMsgViaProvider.class);
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
    paramRegistry.a(ApolloClassFactoryApi.c());
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
    paramRegistry.a(DavBubbleElemDecoder.class);
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
    registerMessageDecoder(localRegistry);
    registerAddMessageHandler(localRegistry);
    registerAioMsgHandler(localRegistry);
    registerC2CAddMessageHandler(localRegistry);
    registerMsgBoxAppender(localRegistry);
    registerGeneralFlagProvider(localRegistry);
    registerPbSendReqHandler(localRegistry);
    registerRichTextAndMsgViaProvider(localRegistry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQMessageFacadeConfig
 * JD-Core Version:    0.7.0.1
 */