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
import com.tencent.mobileqq.activity.aio.item.supplier.AniStickerSupplier;
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
import com.tencent.mobileqq.data.MessageForAniSticker;
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
  private static ArrayMap<Class<? extends MessageRecord>, Integer> h = new ArrayMap();
  private static ArrayMap<Class<? extends ChatMessage>, MessageTypeSupplier> i;
  protected Context a;
  protected QQAppInterface b;
  protected SessionInfo c;
  protected AIOAnimationConatiner d;
  protected MiniChatTextItemBuilder e;
  private BaseChatPie f;
  private Set<ChatItemBuilder> g;
  private final SparseArray<ItemBuilderSupplier<ChatItemBuilder>> j = new SparseArray();
  
  static
  {
    Object localObject = h;
    Integer localInteger = Integer.valueOf(15);
    ((ArrayMap)localObject).put(MessageForNewGrayTips.class, localInteger);
    h.put(MessageForSafeGrayTips.class, localInteger);
    h.put(MessageForIncompatibleGrayTips.class, localInteger);
    h.put(MessageForNearbyMarketGrayTips.class, localInteger);
    h.put(MessageForTroopEffectPic.class, Integer.valueOf(80));
    h.put(MessageForDevPtt.class, Integer.valueOf(33));
    h.put(MessageForPtt.class, Integer.valueOf(2));
    h.put(MessageForVideo.class, Integer.valueOf(11));
    h.put(MessageForLocationShare.class, Integer.valueOf(113));
    h.put(MessageForAutoReply.class, Integer.valueOf(124));
    h.put(MessageForMarketFace.class, Integer.valueOf(12));
    h.put(MessageForRichState.class, Integer.valueOf(13));
    h.put(MessageForQQStory.class, Integer.valueOf(67));
    h.put(MessageForTribeShortVideo.class, Integer.valueOf(89));
    h.put(MessageForTroopPobing.class, Integer.valueOf(77));
    h.put(MessageForTroopNotification.class, Integer.valueOf(28));
    h.put(MessageForQzoneFeed.class, Integer.valueOf(21));
    h.put(MessageForPLNews.class, Integer.valueOf(79));
    h.put(MessageForMedalNews.class, Integer.valueOf(86));
    h.put(MessageForConfessCard.class, Integer.valueOf(92));
    h.put(MessageForConfessNews.class, Integer.valueOf(91));
    h.put(MessageForTroopConfess.class, Integer.valueOf(97));
    h.put(MessageForEnterTroop.class, Integer.valueOf(22));
    h.put(MessageForMyEnterTroop.class, Integer.valueOf(23));
    h.put(MessageForShakeWindow.class, Integer.valueOf(26));
    h.put(MessageForTroopUnreadTips.class, Integer.valueOf(27));
    h.put(MessageForSplitLineTips.class, Integer.valueOf(70));
    h.put(MessageForDevShortVideo.class, Integer.valueOf(35));
    h.put(MessageForDevLittleVideo.class, Integer.valueOf(45));
    h.put(MessageForColorRing.class, Integer.valueOf(31));
    h.put(MessageForTroopFee.class, Integer.valueOf(44));
    h.put(MessageForDeviceSingleStruct.class, Integer.valueOf(34));
    h.put(MessageForQQWalletTips.class, localInteger);
    h.put(MessageForDeviceText.class, Integer.valueOf(39));
    h.put(((IHotChatApi)QRoute.api(IHotChatApi.class)).getShareHotChatGrayTipsClass(), localInteger);
    h.put(MessageForDeliverGiftTips.class, localInteger);
    h.put(MessageForArkFlashChat.class, Integer.valueOf(76));
    h.put(MessageForReplyText.class, Integer.valueOf(50));
    h.put(MessageForApproval.class, Integer.valueOf(52));
    h.put(MessageForVIPDonate.class, Integer.valueOf(58));
    h.put(MessageForFoldMsgGrayTips.class, Integer.valueOf(57));
    h.put(MessageForPokeEmo.class, Integer.valueOf(96));
    h.put(MessageForQQStoryComment.class, Integer.valueOf(68));
    h.put(MessageForTroopStory.class, Integer.valueOf(73));
    h.put(MessageForScribble.class, Integer.valueOf(75));
    h.put(MessageForQQStoryFeed.class, Integer.valueOf(87));
    h.put(MessageForTimDouFuGuide.class, Integer.valueOf(85));
    h.put(MessageForCommonHobbyForAIOShow.class, Integer.valueOf(94));
    h.put(MessageForLimitChatTopic.class, Integer.valueOf(102));
    h.put(MessageForStarLeague.class, Integer.valueOf(101));
    h.put(MessageForFuDai.class, Integer.valueOf(104));
    h.put(MessageForBirthdayNotice.class, Integer.valueOf(108));
    h.put(MessageForAIOStoryVideo.class, Integer.valueOf(109));
    h.put(MessageForTofuIntimateAnniversary.class, Integer.valueOf(115));
    h.put(MessageForTofuBaseProfile.class, Integer.valueOf(116));
    h.put(MessageForTofuNicePics.class, Integer.valueOf(117));
    h.put(MessageForTofuAioMiniProfile.class, Integer.valueOf(118));
    h.put(MessageForQCircleIceBreak.class, Integer.valueOf(119));
    h.put(MessageForQCircleFeed.class, Integer.valueOf(123));
    h.put(MessageForWriteTogether.class, Integer.valueOf(125));
    h.put(MessageForTofuAskAnonymously.class, Integer.valueOf(126));
    h.put(MessageForBeancurd.class, Integer.valueOf(127));
    h.put(MessageForAniSticker.class, Integer.valueOf(128));
    i = new ArrayMap();
    i.put(MessageForText.class, new TextTypeSupplier());
    i.put(MessageForTroopGift.class, new GiftTypeSupplier());
    i.put(MessageForGrayTips.class, new GrayTipsTypeSupplier());
    i.put(MessageForPic.class, new PicTypeSupplier());
    i.put(MessageForFile.class, new FileTypeSupplier());
    i.put(MessageForDLFile.class, new DLFileTypeSupplier());
    i.put(MessageForPubAccount.class, new PATypeSupplier());
    i.put(MessageForTroopSign.class, new TroopSignTypeSupplier());
    i.put(MessageForStructing.class, new StructTypeSupplier());
    i.put(MessageForLongMsg.class, new LongMsgTypeSupplier());
    i.put(MessageForMixedMsg.class, new MixedTypeSupplier());
    i.put(MessageForTroopFile.class, new TroopFileTypeSupplier());
    localObject = new ShortVideoTypeSupplier();
    i.put(MessageForShortVideo.class, localObject);
    i.put(MessageForDanceMachine.class, localObject);
    i.put(MessageForBlessPTV.class, localObject);
    i.put(MessageForQQWalletMsg.class, new QQWalletTypeSupplier());
    i.put(MessageForDeviceFile.class, new DeviceFileTypeSupplier());
    i.put(MessageForArkApp.class, new ArkAppTypeSupplier());
    i.put(MessageForArkBabyqReply.class, new ArkBabyqReplyTypeSupplier());
    localObject = ApolloMessageTypeSupplierApi.a();
    if ((localObject instanceof MessageTypeSupplier)) {
      i.put(ApolloClassFactoryApi.e(), (MessageTypeSupplier)localObject);
    }
    i.put(MessageForTroopReward.class, new TroopRewardTypeSupplier());
    i.put(MessageForPoke.class, new PokeTypeSupplier());
    i.put(MessageForUniteGrayTip.class, new UniteGrayTipTypeSupplier());
    i.put(MessageForHiBoom.class, new HiBoomTypeSupplier());
  }
  
  public ItemBuilderFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.j.put(61, new FilePicSupplier());
    this.j.put(65, new FileVideoSupplier());
    this.j.put(3, new FileSupplier());
    this.j.put(120, new DLFileSupplier());
    this.j.put(121, new DLFilePicSupplier());
    this.j.put(122, new DLFileVideoSupplier());
    this.j.put(1, new ImageSupplier());
    this.j.put(24, new AppSharePicSupplier());
    this.j.put(2, new PTTSupplier());
    this.j.put(33, new DevPTTSupplier());
    this.j.put(15, new GrayTipsSupplier());
    this.j.put(72, new TroopWantGiftSupplier());
    this.j.put(6, new PASingleSupplier());
    this.j.put(7, new PAMultiSupplier());
    this.j.put(8, new PATextSupplier());
    this.j.put(5, new StructSupplier());
    this.j.put(11, new VideoSupplier());
    this.j.put(113, new LocationShareSupplier());
    this.j.put(124, new AutoReplySupplier());
    this.j.put(13, new RichSignatureSupplier());
    this.j.put(9, new TranslationSupplier());
    this.j.put(12, new MarketFaceSupplier());
    this.j.put(16, new ActivitySupplier());
    this.j.put(22, new EnterTroopSupplier());
    this.j.put(23, new MyEnterTroopSupplier());
    this.j.put(17, new LongMsgSupplier());
    this.j.put(18, new MixedSupplier());
    this.j.put(21, new QzoneFeedSupplier());
    this.j.put(108, new BirthdayNoticeSupplier());
    this.j.put(79, new PLNewsSupplier());
    this.j.put(86, new MedalNewsSupplier());
    this.j.put(94, new CommonHobbySupplier());
    this.j.put(91, new ConfessNewsSupplier());
    this.j.put(92, new ConfessCardSupplier());
    this.j.put(97, new TroopConfessSupplier());
    this.j.put(26, new ShakeWindowSupplier());
    this.j.put(62, new PokeSupplier());
    this.j.put(96, new PokeEmoSupplier());
    this.j.put(27, new TroopUnreadTipsSupplier());
    this.j.put(70, new TroopLineTipsSupplier());
    this.j.put(28, new StructTroopNotificationSupplier());
    this.j.put(29, new ShortVideoSupplier());
    Object localObject = new ShortVideoRealSupplier();
    this.j.put(38, localObject);
    this.j.put(40, localObject);
    this.j.put(41, localObject);
    this.j.put(46, new ShortVideoPTVSupplier());
    this.j.put(31, new ThumbSupplier());
    this.j.put(32, new QQWalletSupplier());
    this.j.put(90, new QQWalletTransSupplier());
    this.j.put(44, new TroopFeeSupplier());
    this.j.put(48, new TroopGiftSupplier());
    this.j.put(49, new TroopGiftReceiverSupplier());
    this.j.put(35, new DevShortVideoSupplier());
    this.j.put(45, new DevLittleVideoSupplier());
    this.j.put(34, new DevSingleStructSupplier());
    this.j.put(36, new DevPicSupplier());
    this.j.put(37, new DevFileSupplier());
    this.j.put(39, new DevTextSupplier());
    localObject = new FlashPicSupplier();
    this.j.put(42, localObject);
    this.j.put(66, localObject);
    this.j.put(56, new ApolloSupplier());
    this.j.put(88, new ApolloGameSupplier());
    this.j.put(100, new CmGameTipsSupplier());
    this.j.put(47, new ArkAppSupplier());
    this.j.put(81, new ArkAppShareMultiSupplier());
    this.j.put(112, new ArkAppMultiSupplier());
    this.j.put(76, new ArkFlashChatSupplier());
    this.j.put(50, new ReplySupplier());
    this.j.put(52, new ApprovalSupplier());
    this.j.put(58, new VIPDonateSupplier());
    this.j.put(57, new FoldMsgGrayTipsSupplier());
    this.j.put(63, new LongTextSupplier());
    this.j.put(64, new UniteGrayTipSupplier());
    this.j.put(67, new QQStorySupplier());
    this.j.put(89, new TribeShortVideoSupplier());
    this.j.put(77, new PobingSupplier());
    this.j.put(68, new QQStoryCommentSupplier());
    this.j.put(71, new TroopSignPicSupplier());
    this.j.put(84, new TroopSignVideoSupplier());
    this.j.put(73, new TroopStorySupplier());
    this.j.put(78, new HiBoomSupplier());
    this.j.put(75, new ScribbleSupplier());
    this.j.put(80, new TroopEffectPicSupplier());
    this.j.put(87, new QQStoryFeedSupplier());
    this.j.put(85, new TimDouFuGuideSupplier());
    this.j.put(93, new TimDocsSupplier());
    this.j.put(101, new TroopStarLeagueSupplier());
    this.j.put(104, new FuDaiSupplier());
    this.j.put(109, new AIOStoryVideoSupplier());
    this.j.put(110, new LoverChattingGrayTipSupplier());
    this.j.put(111, new AutoVideoSupplier());
    localObject = new TextSupplier();
    SparseArray localSparseArray = this.j;
    int k = 0;
    localSparseArray.put(0, localObject);
    this.j.put(115, new TofuIntimateAnniversarySupplier());
    this.j.put(116, new TofuBaseProfileSupplier());
    this.j.put(117, new TofuNicePicsSupplier());
    this.j.put(118, new TofuAioMiniProfileSupplier());
    this.j.put(119, new QCircleChatIceBreakSupplier());
    this.j.put(123, new QCircleFeedSupplier());
    this.j.put(125, new WriteTogetherSupplier());
    this.j.put(126, new TofuAskAnonymouslySupplier());
    this.j.put(127, new BeancurdSupplier());
    this.j.put(128, new AniStickerSupplier());
    this.a = paramContext;
    this.b = paramQQAppInterface;
    this.c = paramSessionInfo;
    this.d = paramAIOAnimationConatiner;
    this.f = paramBaseChatPie;
    this.g = new HashSet();
    int m = this.j.size();
    while (k < m)
    {
      ((ItemBuilderSupplier)this.j.valueAt(k)).a(paramContext, paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramAIOAnimationConatiner);
      k += 1;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, @Nullable ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      QLog.e("ItemBuilderFactory", 1, "message is null");
      return 0;
    }
    if (i.containsKey(paramChatMessage.getClass()))
    {
      int k = ((MessageTypeSupplier)i.get(paramChatMessage.getClass())).get(paramQQAppInterface, paramChatMessage);
      if (k != -1) {
        return k;
      }
    }
    if (h.containsKey(paramChatMessage.getClass())) {
      return ((Integer)h.get(paramChatMessage.getClass())).intValue();
    }
    return 0;
  }
  
  protected ChatItemBuilder a(ChatItemBuilder paramChatItemBuilder, BaseAdapter paramBaseAdapter)
  {
    if (((paramChatItemBuilder instanceof BaseBubbleBuilder)) && ((paramBaseAdapter instanceof ChatAdapter1)))
    {
      paramBaseAdapter = (ChatAdapter1)paramBaseAdapter;
      ((BaseBubbleBuilder)paramChatItemBuilder).a(paramBaseAdapter.i);
    }
    this.g.add(paramChatItemBuilder);
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
    int k = a(this.b, paramChatMessage);
    if (this.j.get(k) != null)
    {
      localObject = (ItemBuilderSupplier)this.j.get(k);
      paramChatMessage = ((ItemBuilderSupplier)localObject).a(paramChatMessage, paramBaseAdapter);
      if (((ItemBuilderSupplier)localObject).a())
      {
        a(paramChatMessage, paramBaseAdapter);
        return paramChatMessage;
      }
      this.g.add(paramChatMessage);
      return paramChatMessage;
    }
    return ((ItemBuilderSupplier)this.j.get(0)).a(paramChatMessage, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.g.iterator();
    while (localIterator.hasNext()) {
      ((ChatItemBuilder)localIterator.next()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */