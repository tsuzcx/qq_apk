package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.tips.StudyRoomTipBarHelper;
import com.tencent.mobileqq.bubble.LeftSwipeReplyHelper;
import com.tencent.mobileqq.listentogether.ui.TroopListenTogetherPanel;
import cooperation.ilive.group.IliveGroupTipsBarHelper;

public class TroopHelperProvider
  extends HelperProvider
{
  public TroopHelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(BaseChatPie paramBaseChatPie)
  {
    super.a(paramBaseChatPie);
    a((TroopChatPie)paramBaseChatPie);
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
    a(58, new TroopEggLottieAnimHelper(paramTroopChatPie));
    a(71, new AVGameHelper(paramTroopChatPie.b()));
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
    TroopTipsHelper localTroopTipsHelper = new TroopTipsHelper(paramTroopChatPie.b());
    a(109, localTroopTipsHelper);
    a(125, new TroopObserversHelper(paramTroopChatPie));
    a(localTroopTipsHelper);
    a(134, new TroopEffectHelper(paramTroopChatPie));
    a(136, new TroopGiftPanelHelper(paramTroopChatPie));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopHelperProvider
 * JD-Core Version:    0.7.0.1
 */