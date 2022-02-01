package com.tencent.mobileqq.activity.aio.core.msglist.item;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.device.msg.data.MessageForDevLittleVideo;
import com.tencent.device.msg.data.MessageForDevPtt;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.item.supplier.AIOStoryVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ActivitySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ApolloGameSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ApolloSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.AppSharePicSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ApprovalSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ArkAppMultiSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ArkAppShareMultiSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ArkAppSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ArkFlashChatSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.AutoReplySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.AutoVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.BeancurdSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.BirthdayNoticeSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.CmGameTipsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.CommonHobbySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ConfessCardSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ConfessNewsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DLFilePicSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DLFileSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DLFileVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DevFileSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DevLittleVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DevPTTSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DevPicSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DevShortVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DevSingleStructSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.DevTextSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.EnterTroopSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.FilePicSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.FileSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.FileVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.FlashPicSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.FoldMsgGrayTipsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.FuDaiSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.GrayTipsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.HiBoomSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ImageSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.LocationShareSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.LongMsgSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.LongTextSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.LoverChattingGrayTipSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.MarketFaceSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.MedalNewsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.MixedSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.MyEnterTroopSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PAMultiSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PASingleSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PATextSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PLNewsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PTTSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PobingSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PokeEmoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.PokeSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QCircleChatIceBreakSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QCircleFeedSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QQStoryCommentSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QQStoryFeedSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QQStorySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QQWalletSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QQWalletTransSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.QzoneFeedSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ReplySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.RichSignatureSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ScribbleSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ShakeWindowSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ShortVideoPTVSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ShortVideoRealSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ShortVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.StructSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.StructTroopNotificationSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TextSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.ThumbSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TimDocsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TimDouFuGuideSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TofuAioMiniProfileSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TofuAskAnonymouslySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TofuBaseProfileSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TofuIntimateAnniversarySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TofuNicePicsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TranslationSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TribeShortVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopConfessSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopEffectPicSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopFeeSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopGiftReceiverSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopGiftSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopLineTipsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopSignPicSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopSignVideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopStarLeagueSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopStorySupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopUnreadTipsSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.TroopWantGiftSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.UniteGrayTipSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.VIPDonateSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.VideoSupplier;
import com.tencent.mobileqq.activity.aio.item.supplier.WriteTogetherSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.ArkAppTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.ArkBabyqReplyTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.DLFileTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.DeviceFileTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.FileTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.GiftTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.GrayTipsTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.HiBoomTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.LongMsgTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.MixedTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.PATypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.PicTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.PokeTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.QQWalletTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.ShortVideoTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.StructTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.TextTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.TroopFileTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.TroopRewardTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.TroopSignTypeSupplier;
import com.tencent.mobileqq.activity.aio.item.typesupplier.UniteGrayTipTypeSupplier;
import com.tencent.mobileqq.activity.miniaio.MiniChatTextItemBuilder;
import com.tencent.mobileqq.apollo.aio.item.ApolloMessageTypeSupplierApi;
import com.tencent.mobileqq.apollo.utils.ApolloClassFactoryApi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAIOStoryVideo;
import com.tencent.mobileqq.data.MessageForApproval;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.data.MessageForBeancurd;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForColorRing;
import com.tencent.mobileqq.data.MessageForCommonHobbyForAIOShow;
import com.tencent.mobileqq.data.MessageForConfessCard;
import com.tencent.mobileqq.data.MessageForConfessNews;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForDeviceText;
import com.tencent.mobileqq.data.MessageForEnterTroop;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForFoldMsgGrayTips;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForIncompatibleGrayTips;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMedalNews;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForMyEnterTroop;
import com.tencent.mobileqq.data.MessageForNearbyMarketGrayTips;
import com.tencent.mobileqq.data.MessageForNewGrayTips;
import com.tencent.mobileqq.data.MessageForPLNews;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.data.MessageForQCircleIceBreak;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.data.MessageForSafeGrayTips;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageForStarLeague;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTimDouFuGuide;
import com.tencent.mobileqq.data.MessageForTofuAioMiniProfile;
import com.tencent.mobileqq.data.MessageForTofuAskAnonymously;
import com.tencent.mobileqq.data.MessageForTofuBaseProfile;
import com.tencent.mobileqq.data.MessageForTofuIntimateAnniversary;
import com.tencent.mobileqq.data.MessageForTofuNicePics;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageForTroopEffectPic;
import com.tencent.mobileqq.data.MessageForTroopFee;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.MessageForTroopNotification;
import com.tencent.mobileqq.data.MessageForTroopPobing;
import com.tencent.mobileqq.data.MessageForTroopReward;
import com.tencent.mobileqq.data.MessageForTroopSign;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageForVIPDonate;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageForWriteTogether;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ItemBuilderFactory
{
  private static ArrayMap<Class<? extends MessageRecord>, Integer> jdField_a_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private static ArrayMap<Class<? extends ChatMessage>, MessageTypeSupplier> b;
  protected Context a;
  private final SparseArray<ItemBuilderSupplier<ChatItemBuilder>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  protected SessionInfo a;
  protected AIOAnimationConatiner a;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  protected MiniChatTextItemBuilder a;
  protected QQAppInterface a;
  private Set<ChatItemBuilder> jdField_a_of_type_JavaUtilSet;
  
  static
  {
    Object localObject = jdField_a_of_type_AndroidSupportV4UtilArrayMap;
    Integer localInteger = Integer.valueOf(15);
    ((ArrayMap)localObject).put(MessageForNewGrayTips.class, localInteger);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForSafeGrayTips.class, localInteger);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForIncompatibleGrayTips.class, localInteger);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForNearbyMarketGrayTips.class, localInteger);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopEffectPic.class, Integer.valueOf(80));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevPtt.class, Integer.valueOf(33));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPtt.class, Integer.valueOf(2));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForVideo.class, Integer.valueOf(11));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForLocationShare.class, Integer.valueOf(113));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForAutoReply.class, Integer.valueOf(124));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMarketFace.class, Integer.valueOf(12));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForRichState.class, Integer.valueOf(13));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStory.class, Integer.valueOf(67));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTribeShortVideo.class, Integer.valueOf(89));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopPobing.class, Integer.valueOf(77));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopNotification.class, Integer.valueOf(28));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQzoneFeed.class, Integer.valueOf(21));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPLNews.class, Integer.valueOf(79));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMedalNews.class, Integer.valueOf(86));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForConfessCard.class, Integer.valueOf(92));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForConfessNews.class, Integer.valueOf(91));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopConfess.class, Integer.valueOf(97));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForEnterTroop.class, Integer.valueOf(22));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForMyEnterTroop.class, Integer.valueOf(23));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForShakeWindow.class, Integer.valueOf(26));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopUnreadTips.class, Integer.valueOf(27));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForSplitLineTips.class, Integer.valueOf(70));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevShortVideo.class, Integer.valueOf(35));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDevLittleVideo.class, Integer.valueOf(45));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForColorRing.class, Integer.valueOf(31));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopFee.class, Integer.valueOf(44));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeviceSingleStruct.class, Integer.valueOf(34));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQWalletTips.class, localInteger);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeviceText.class, Integer.valueOf(39));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(((IHotChatApi)QRoute.api(IHotChatApi.class)).getShareHotChatGrayTipsClass(), localInteger);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForDeliverGiftTips.class, localInteger);
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForArkFlashChat.class, Integer.valueOf(76));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForReplyText.class, Integer.valueOf(50));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForApproval.class, Integer.valueOf(52));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForVIPDonate.class, Integer.valueOf(58));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFoldMsgGrayTips.class, Integer.valueOf(57));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForPokeEmo.class, Integer.valueOf(96));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStoryComment.class, Integer.valueOf(68));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTroopStory.class, Integer.valueOf(73));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForScribble.class, Integer.valueOf(75));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQQStoryFeed.class, Integer.valueOf(87));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTimDouFuGuide.class, Integer.valueOf(85));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForCommonHobbyForAIOShow.class, Integer.valueOf(94));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForLimitChatTopic.class, Integer.valueOf(102));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForStarLeague.class, Integer.valueOf(101));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForFuDai.class, Integer.valueOf(104));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForBirthdayNotice.class, Integer.valueOf(108));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForAIOStoryVideo.class, Integer.valueOf(109));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuIntimateAnniversary.class, Integer.valueOf(115));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuBaseProfile.class, Integer.valueOf(116));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuNicePics.class, Integer.valueOf(117));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuAioMiniProfile.class, Integer.valueOf(118));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQCircleIceBreak.class, Integer.valueOf(119));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForQCircleFeed.class, Integer.valueOf(123));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForWriteTogether.class, Integer.valueOf(125));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForTofuAskAnonymously.class, Integer.valueOf(126));
    jdField_a_of_type_AndroidSupportV4UtilArrayMap.put(MessageForBeancurd.class, Integer.valueOf(127));
    b = new ArrayMap();
    b.put(MessageForText.class, new TextTypeSupplier());
    b.put(MessageForTroopGift.class, new GiftTypeSupplier());
    b.put(MessageForGrayTips.class, new GrayTipsTypeSupplier());
    b.put(MessageForPic.class, new PicTypeSupplier());
    b.put(MessageForFile.class, new FileTypeSupplier());
    b.put(MessageForDLFile.class, new DLFileTypeSupplier());
    b.put(MessageForPubAccount.class, new PATypeSupplier());
    b.put(MessageForTroopSign.class, new TroopSignTypeSupplier());
    b.put(MessageForStructing.class, new StructTypeSupplier());
    b.put(MessageForLongMsg.class, new LongMsgTypeSupplier());
    b.put(MessageForMixedMsg.class, new MixedTypeSupplier());
    b.put(MessageForTroopFile.class, new TroopFileTypeSupplier());
    localObject = new ShortVideoTypeSupplier();
    b.put(MessageForShortVideo.class, localObject);
    b.put(MessageForDanceMachine.class, localObject);
    b.put(MessageForBlessPTV.class, localObject);
    b.put(MessageForQQWalletMsg.class, new QQWalletTypeSupplier());
    b.put(MessageForDeviceFile.class, new DeviceFileTypeSupplier());
    b.put(MessageForArkApp.class, new ArkAppTypeSupplier());
    b.put(MessageForArkBabyqReply.class, new ArkBabyqReplyTypeSupplier());
    localObject = ApolloMessageTypeSupplierApi.a();
    if ((localObject instanceof MessageTypeSupplier)) {
      b.put(ApolloClassFactoryApi.e(), (MessageTypeSupplier)localObject);
    }
    b.put(MessageForTroopReward.class, new TroopRewardTypeSupplier());
    b.put(MessageForPoke.class, new PokeTypeSupplier());
    b.put(MessageForUniteGrayTip.class, new UniteGrayTipTypeSupplier());
    b.put(MessageForHiBoom.class, new HiBoomTypeSupplier());
  }
  
  public ItemBuilderFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(61, new FilePicSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(65, new FileVideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(3, new FileSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(120, new DLFileSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(121, new DLFilePicSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(122, new DLFileVideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(1, new ImageSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(24, new AppSharePicSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(2, new PTTSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(33, new DevPTTSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(15, new GrayTipsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(72, new TroopWantGiftSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(6, new PASingleSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(7, new PAMultiSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(8, new PATextSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(5, new StructSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(11, new VideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(113, new LocationShareSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(124, new AutoReplySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(13, new RichSignatureSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(9, new TranslationSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(12, new MarketFaceSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(16, new ActivitySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(22, new EnterTroopSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(23, new MyEnterTroopSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(17, new LongMsgSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(18, new MixedSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(21, new QzoneFeedSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(108, new BirthdayNoticeSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(79, new PLNewsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(86, new MedalNewsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(94, new CommonHobbySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(91, new ConfessNewsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(92, new ConfessCardSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(97, new TroopConfessSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(26, new ShakeWindowSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(62, new PokeSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(96, new PokeEmoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(27, new TroopUnreadTipsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(70, new TroopLineTipsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(28, new StructTroopNotificationSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(29, new ShortVideoSupplier());
    Object localObject = new ShortVideoRealSupplier();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(38, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(40, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(41, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(46, new ShortVideoPTVSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(31, new ThumbSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(32, new QQWalletSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(90, new QQWalletTransSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(44, new TroopFeeSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(48, new TroopGiftSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(49, new TroopGiftReceiverSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(35, new DevShortVideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(45, new DevLittleVideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(34, new DevSingleStructSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(36, new DevPicSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(37, new DevFileSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(39, new DevTextSupplier());
    localObject = new FlashPicSupplier();
    this.jdField_a_of_type_AndroidUtilSparseArray.put(42, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(66, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(56, new ApolloSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(88, new ApolloGameSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(100, new CmGameTipsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(47, new ArkAppSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(81, new ArkAppShareMultiSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(112, new ArkAppMultiSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(76, new ArkFlashChatSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(50, new ReplySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(52, new ApprovalSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(58, new VIPDonateSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(57, new FoldMsgGrayTipsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(63, new LongTextSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(64, new UniteGrayTipSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(67, new QQStorySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(89, new TribeShortVideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(77, new PobingSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(68, new QQStoryCommentSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(71, new TroopSignPicSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(84, new TroopSignVideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(73, new TroopStorySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(78, new HiBoomSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(75, new ScribbleSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(80, new TroopEffectPicSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(87, new QQStoryFeedSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(85, new TimDouFuGuideSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(93, new TimDocsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(101, new TroopStarLeagueSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(104, new FuDaiSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(109, new AIOStoryVideoSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(110, new LoverChattingGrayTipSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(111, new AutoVideoSupplier());
    localObject = new TextSupplier();
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int i = 0;
    localSparseArray.put(0, localObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(115, new TofuIntimateAnniversarySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(116, new TofuBaseProfileSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(117, new TofuNicePicsSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(118, new TofuAioMiniProfileSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(119, new QCircleChatIceBreakSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(123, new QCircleFeedSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(125, new WriteTogetherSupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(126, new TofuAskAnonymouslySupplier());
    this.jdField_a_of_type_AndroidUtilSparseArray.put(127, new BeancurdSupplier());
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner = paramAIOAnimationConatiner;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    int j = this.jdField_a_of_type_AndroidUtilSparseArray.size();
    while (i < j)
    {
      ((ItemBuilderSupplier)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).a(paramContext, paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramAIOAnimationConatiner);
      i += 1;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, @Nullable ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      QLog.e("ItemBuilderFactory", 1, "message is null");
      return 0;
    }
    if (b.containsKey(paramChatMessage.getClass()))
    {
      int i = ((MessageTypeSupplier)b.get(paramChatMessage.getClass())).get(paramQQAppInterface, paramChatMessage);
      if (i != -1) {
        return i;
      }
    }
    if (jdField_a_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramChatMessage.getClass())) {
      return ((Integer)jdField_a_of_type_AndroidSupportV4UtilArrayMap.get(paramChatMessage.getClass())).intValue();
    }
    return 0;
  }
  
  protected ChatItemBuilder a(ChatItemBuilder paramChatItemBuilder, BaseAdapter paramBaseAdapter)
  {
    if (((paramChatItemBuilder instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof ChatAdapter1)))
    {
      paramBaseAdapter = (ChatAdapter1)paramBaseAdapter;
      ((BaseBubbleBuilder)paramChatItemBuilder).a(paramBaseAdapter.a);
    }
    this.jdField_a_of_type_JavaUtilSet.add(paramChatItemBuilder);
    return paramChatItemBuilder;
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("findItemBuilder: invoked. info: message = ");
      ((StringBuilder)localObject).append(paramChatMessage);
      QLog.i("ItemBuilderFactory", 2, ((StringBuilder)localObject).toString());
    }
    int i = a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null)
    {
      localObject = (ItemBuilderSupplier)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      paramChatMessage = ((ItemBuilderSupplier)localObject).a(paramChatMessage, paramBaseAdapter);
      if (((ItemBuilderSupplier)localObject).a())
      {
        a(paramChatMessage, paramBaseAdapter);
        return paramChatMessage;
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramChatMessage);
      return paramChatMessage;
    }
    return ((ItemBuilderSupplier)this.jdField_a_of_type_AndroidUtilSparseArray.get(0)).a(paramChatMessage, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext()) {
      ((ChatItemBuilder)localIterator.next()).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */