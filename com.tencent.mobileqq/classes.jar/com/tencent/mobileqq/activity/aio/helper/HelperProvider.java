package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.av.wtogether.util.WTEntranceHelper;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeDataReportHelper;
import com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.RobotChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.apollo.aio.ApolloHelper;
import com.tencent.mobileqq.bubble.LeftSwipeReplyHelper;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarAIOHelper;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper;
import com.tencent.mobileqq.emosm.AIOBubbleAnimHelper;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper;
import com.tencent.mobileqq.filemanager.fileassistant.aio.DatalineMultiForwardHelper;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper;
import com.tencent.mobileqq.fudai.aio.FuDaiHelper;
import com.tencent.mobileqq.haoliyou.orion.ChatPieInputHelper;
import com.tencent.mobileqq.inputstatus.InputStatusHelper;
import com.tencent.mobileqq.listentogether.ui.C2CListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import com.tencent.mobileqq.pushdialog.AIOPushDialogHelper;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftHelper;
import com.tencent.mobileqq.richstatus.AioFriendTitleHelper;
import com.tencent.mobileqq.tofumsg.AIOTofuMsgHelper;
import cooperation.ilive.group.IliveGroupTipsBarHelper;

public class HelperProvider
  extends CoreHelperProvider
{
  public HelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    if (!(paramBaseChatPie instanceof DatalineChatPie)) {
      a(1, new MultiForwardHelper(paramBaseChatPie));
    }
    a(2, new FuDaiHelper(paramBaseChatPie));
    a(3, new HitAndRunHelper(paramBaseChatPie));
    a(4, new ChatPieSelectableHelper(paramBaseChatPie));
    a(5, new UnreadCountHelper(paramBaseChatPie));
    a(6, new ChatPieInputHelper(paramBaseChatPie));
    a(7, new PhotoListHelper(this, paramBaseChatPie));
    a(8, new ApolloHelper(this, paramBaseChatPie));
    a(9, new QzoneGiftHelper(paramBaseChatPie));
    a(10, new IceBreakHelper(paramBaseChatPie));
    a(11, new MultiFavoriteHelper(paramBaseChatPie));
    a(12, new CMGameHelper(paramBaseChatPie));
    a(13, new ForwardShareByServerHelper(paramBaseChatPie));
    a(57, new ForwardSDKB77AIOHelper(paramBaseChatPie));
    a(37, new ForwardIMByThirdPartyHelper(paramBaseChatPie));
    a(14, new StickerRecHelper(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new QEffectBgProvider(paramBaseChatPie));
    a(18, new HiBoomHelper());
    a(19, new CopyPromptHelper(paramBaseChatPie));
    a(20, new FontBubbleHelper());
    a(24, new FullScreenInputHelper(paramBaseChatPie));
    a(22, new WeiShiSubScribeHelper());
    a(21, new AIOIconChangeByTimeHelper(paramBaseChatPie));
    a(25, new FileSaveHelper(paramBaseChatPie));
    a(26, new MultiWindowAIOHelper(paramBaseChatPie));
    a(27, new QWalletAIOLifeCycleHelper(paramBaseChatPie));
    a(29, new SimpleUIAIOHelper(paramBaseChatPie));
    a(39, new HiddenChatHelper(paramBaseChatPie));
    a(44, new ReplyOnlyHelper(paramBaseChatPie));
    a(38, new PttAutoToTxtHelper(paramBaseChatPie));
    a(40, new SelectToBottomHelper(paramBaseChatPie));
    a(41, new SpecWordEmotionThinkHelper(paramBaseChatPie));
    a(43, new TogetherControlHelper(paramBaseChatPie));
    a(46, new AIORevokeMsgHelper(paramBaseChatPie));
    a(47, new LocationShareHelper(paramBaseChatPie));
    a(49, new AIOMessageRecordExposeDataReportHelper(paramBaseChatPie));
    a(53, new UnreadBackBottomHelper(paramBaseChatPie));
    a(54, new AIOEmoticonGuideHelper(paramBaseChatPie));
    a(59, new AIOUpComingMsgHelper(paramBaseChatPie));
    a(83, new FastImageHelper(paramBaseChatPie));
    a(65, new AIOShakeHelper(paramBaseChatPie));
    a(66, new AIOMultiActionHelper(paramBaseChatPie));
    a(67, new PokeAndEmoPanelHelper(this, paramBaseChatPie));
    a(68, new HongBaoPanelHelper(paramBaseChatPie));
    a(69, new EnterForSendHelper(paramBaseChatPie));
    a(70, new AIOJubaoDialogHelper(this, paramBaseChatPie));
    a(72, new AIORelatedEmotionHelper(paramBaseChatPie));
    a(80, new VoiceMessageHelper(paramBaseChatPie));
    a(74, new WriteTogetherHelper(this, paramBaseChatPie));
    a(78, new GameCenterHelper(this, paramBaseChatPie));
    a(82, new PttSttHelper(paramBaseChatPie));
    a(84, new AioPaiYiPaiHelper(this, paramBaseChatPie));
    a(87, new QQLiveImageHelper(paramBaseChatPie));
    a(88, new FMHelper(paramBaseChatPie));
    a(89, new PlusRedPointHelper(paramBaseChatPie));
    a(63, new PlusPanelHelper(paramBaseChatPie));
    a(98, new FileAssistantChatHelper(this, paramBaseChatPie));
    a(100, new AIOBusinessRecordHelper());
    a(101, new AIODtReportHelper(paramBaseChatPie));
    a(102, new AIOAvatarHelper(paramBaseChatPie));
    a(104, new AIOEmoticonPanelHelper(paramBaseChatPie));
    a(105, new AIOEmoticonUIHelper(paramBaseChatPie));
    a(106, new AIOBubbleAnimHelper());
    a(108, new AIOTianShuTraceInfoHelper(paramBaseChatPie));
  }
  
  public void a(BaseTroopChatPie paramBaseTroopChatPie)
  {
    a(23, new TroopRobotHelper(paramBaseTroopChatPie));
  }
  
  public void a(DiscussChatPie paramDiscussChatPie)
  {
    a(50, new LeftSwipeReplyHelper(paramDiscussChatPie));
  }
  
  public void a(FriendChatPie paramFriendChatPie)
  {
    a(16, new InputStatusHelper(paramFriendChatPie));
    a(30, new ReactiveHelper(paramFriendChatPie));
    a(32, new C2CListenTogetherPanel(paramFriendChatPie));
    a(35, new AIOSearchBarHelper(paramFriendChatPie));
    a(42, new AIOPushDialogHelper(paramFriendChatPie));
    a(45, new AioFriendTitleHelper(paramFriendChatPie));
    a(50, new LeftSwipeReplyHelper(paramFriendChatPie));
    a(60, new AIOTofuMsgHelper(paramFriendChatPie));
    a(61, new QidianHelper(paramFriendChatPie));
    a(52, new C2CShortcutBarAIOHelper(paramFriendChatPie));
    paramFriendChatPie = new WTEntranceHelper(paramFriendChatPie);
    a(107, paramFriendChatPie);
    a(paramFriendChatPie);
  }
  
  public void a(TroopChatPie paramTroopChatPie)
  {
    a(28, new TroopAddFriendTipsHelper(paramTroopChatPie));
    a(55, new TroopAppShortcutHelper(paramTroopChatPie));
    a(33, new TroopListenTogetherPanel(paramTroopChatPie));
    a(34, new AIOAtHelper(paramTroopChatPie));
    a(35, new AIOSearchBarHelper(paramTroopChatPie));
    a(48, new TroopKeyWordHelper(paramTroopChatPie));
    a(50, new LeftSwipeReplyHelper(paramTroopChatPie));
    a(51, new TroopNotificationAIOHelper(paramTroopChatPie));
    a(52, new ShortcutBarAIOHelper(paramTroopChatPie));
    a(58, new TroopEggLottieAnimHelper(paramTroopChatPie));
    a(71, new AVGameHelper(paramTroopChatPie));
    a(73, new HWTroopClassInfoTipsHelper(paramTroopChatPie));
    a(75, new StudyRoomTipBarHelper(paramTroopChatPie));
    a(76, new TroopBlockDialogHelper(paramTroopChatPie));
    a(79, new TroopRedTipHelper(paramTroopChatPie));
    a(81, new IliveGroupTipsBarHelper(this, paramTroopChatPie));
    a(85, new ClockInEntryHelper(paramTroopChatPie));
    a(91, new FansTroopTipsBarHelper(paramTroopChatPie));
    a(86, new QcircleTroopRedDotHelper(this, paramTroopChatPie));
    a(90, new QQGamePubAIOHelper(paramTroopChatPie));
    a(92, new TroopGameGuideHelper(paramTroopChatPie));
    a(93, new TroopGameNotifyUpdateHelper(paramTroopChatPie));
    a(94, new GetSimpleTroopInfoHelper(paramTroopChatPie));
    a(96, new TroopSettingRedPointHelper(paramTroopChatPie));
    a(97, new TroopAskAnonymouslyHelper(paramTroopChatPie));
    a(99, new WriteTogetherEssenceMsgHelper(this, paramTroopChatPie));
  }
  
  public void a(DatalineChatPie paramDatalineChatPie)
  {
    a(1, new DatalineMultiForwardHelper(paramDatalineChatPie));
  }
  
  public void a(GameMsgChatPie paramGameMsgChatPie)
  {
    a(56, new GameMsgChatHelper(paramGameMsgChatPie));
    a(103, new GameMsgAppHelper(paramGameMsgChatPie));
  }
  
  public void a(LimitChatPie paramLimitChatPie)
  {
    a(16, new InputStatusHelper(paramLimitChatPie));
    a(45, new AioFriendTitleHelper(paramLimitChatPie));
    a(77, new AioLimitColdPalaceHelper(paramLimitChatPie));
    a(52, new C2CShortcutBarAIOHelper(paramLimitChatPie));
  }
  
  public void a(NearbyChatPie paramNearbyChatPie)
  {
    a(42, new AIOPushDialogHelper(paramNearbyChatPie));
  }
  
  public void a(RobotChatPie paramRobotChatPie)
  {
    a(23, new TroopRobotHelper(paramRobotChatPie));
    a(36, new RobotChatUIHelper(paramRobotChatPie));
  }
  
  public void a(StrangerChatPie paramStrangerChatPie)
  {
    a(42, new AIOPushDialogHelper(paramStrangerChatPie));
    a(95, new TempMsgBoxAIOHelper(paramStrangerChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HelperProvider
 * JD-Core Version:    0.7.0.1
 */