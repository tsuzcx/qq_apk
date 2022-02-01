package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelAioHelper;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.AIOOnTouchListener;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.helper.OnFinishListener;
import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeDataReportHelper;
import com.tencent.mobileqq.activity.aio.rebuild.DatalineChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.panel.HotPicPanelProvider;
import com.tencent.mobileqq.activity.aio.rebuild.panel.PtvPanelProviderHelper;
import com.tencent.mobileqq.activity.aio.rebuild.panel.RichTextPanelProviderHelper;
import com.tencent.mobileqq.activity.aio.upcoming.AIOUpComingMsgHelper;
import com.tencent.mobileqq.activity.selectable.ChatPieSelectableHelper;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.copyprompt.CopyPromptHelper;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.doutu.DoutuHelper;
import com.tencent.mobileqq.emosm.AIOBubbleAnimHelper;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.forward.ForwardIMByThirdPartyHelper;
import com.tencent.mobileqq.forward.ForwardSDKB77AIOHelper;
import com.tencent.mobileqq.forward.ForwardShareByServerHelper;
import com.tencent.mobileqq.fudai.aio.FuDaiHelper;
import com.tencent.mobileqq.haoliyou.orion.ChatPieInputHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.IHongBaoPanelHelper;
import com.tencent.mobileqq.qzonevip.gift.QzoneGiftHelper;
import com.tencent.mobileqq.receipt.ReceiptHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HelperProvider
  extends CoreHelperProvider
{
  private final List<OnTroopChatMsgChangedCallback> a = new ArrayList();
  
  public HelperProvider(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(int paramInt, TroopChatPie paramTroopChatPie, List<ChatMessage> paramList)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((OnTroopChatMsgChangedCallback)localIterator.next()).a(paramInt, paramTroopChatPie, paramList);
    }
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
    if (!b())
    {
      localObject = (IApolloAIOHelper)QRoute.api(IApolloAIOHelper.class);
      ((IApolloAIOHelper)localObject).init(paramBaseChatPie);
      a(8, (ILifeCycleHelper)localObject);
    }
    a(9, new QzoneGiftHelper(paramBaseChatPie));
    a(10, new IceBreakHelper(paramBaseChatPie));
    Object localObject = new MultiFavoriteHelper(paramBaseChatPie);
    a(11, (ILifeCycleHelper)localObject);
    a((OnActivityResultCallback)localObject);
    a(13, new ForwardShareByServerHelper(paramBaseChatPie));
    a(57, new ForwardSDKB77AIOHelper(paramBaseChatPie));
    a(37, new ForwardIMByThirdPartyHelper(paramBaseChatPie));
    a(14, new StickerRecHelper(paramBaseChatPie));
    a(15, new AIOLongShotHelper(this, paramBaseChatPie));
    a(17, new QEffectBgProvider(paramBaseChatPie));
    a(18, new HiBoomHelper(paramBaseChatPie));
    a(19, new CopyPromptHelper(paramBaseChatPie));
    a(20, new FontBubbleHelper());
    a(24, new FullScreenInputHelper(paramBaseChatPie, this));
    a(22, new WeiShiSubScribeHelper());
    a(21, new AIOIconChangeByTimeHelper(paramBaseChatPie));
    localObject = new FileSaveHelper(paramBaseChatPie);
    a(25, (ILifeCycleHelper)localObject);
    a((Handler.Callback)localObject);
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
    localObject = new AudioPanelAioHelper(paramBaseChatPie);
    a(128, (ILifeCycleHelper)localObject);
    a((OnFinishListener)localObject);
    a(54, new AIOEmoticonGuideHelper(paramBaseChatPie));
    a(59, new AIOUpComingMsgHelper(paramBaseChatPie));
    localObject = new FastImageHelper(paramBaseChatPie);
    a(83, (ILifeCycleHelper)localObject);
    a((Handler.Callback)localObject);
    a(65, new AIOShakeHelper(paramBaseChatPie));
    a(66, new AIOMultiActionHelper(paramBaseChatPie));
    a(67, new PokeAndEmoPanelHelper(paramBaseChatPie.bv()));
    a(68, ((IHongBaoPanelHelper)QRoute.api(IHongBaoPanelHelper.class)).init(paramBaseChatPie));
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
    a(120, new AIOBubbleAnimHelper());
    a(123, new AIOTianShuTraceInfoHelper(paramBaseChatPie));
    a(111, new AIODraftHelper(paramBaseChatPie));
    a(106, new AVHelper(paramBaseChatPie.bv()));
    a(107, new FraudHelper(paramBaseChatPie.bv()));
    a(108, new QQOperateTipsHelper(paramBaseChatPie.bv()));
    a(109, new TipsHelper(paramBaseChatPie.bv()));
    a(110, new ArkHelper(paramBaseChatPie.bv(), paramBaseChatPie));
    localObject = new JdTipHelper(paramBaseChatPie.bv());
    a(112, (ILifeCycleHelper)localObject);
    a((Handler.Callback)localObject);
    a(52, new AIOShortcutBarHelper(paramBaseChatPie.bv()));
    localObject = new DoutuHelper(paramBaseChatPie.bv());
    a(115, (ILifeCycleHelper)localObject);
    a((Handler.Callback)localObject);
    a((AIOOnTouchListener)localObject);
    localObject = new AIOZhituHelper(paramBaseChatPie.bv());
    a(116, (ILifeCycleHelper)localObject);
    a((Handler.Callback)localObject);
    a(117, new AIOInputRightHelper(paramBaseChatPie));
    a(118, new ReceiptHelper(paramBaseChatPie.bv()));
    localObject = new ReplyHelper(paramBaseChatPie.bv());
    a(119, (ILifeCycleHelper)localObject);
    a((OnActivityResultCallback)localObject);
    a(121, new DoodlePanelLifeHelper(paramBaseChatPie.bv(), this));
    if (!b(paramBaseChatPie)) {
      a(124, new ChatDrawerHelper(paramBaseChatPie.bv()));
    }
    a(126, new RichTextPanelProviderHelper(paramBaseChatPie));
    a(127, new HotPicPanelProvider(paramBaseChatPie.bv()));
    a(137, new NetStateTipsHelper(paramBaseChatPie.bv()));
    localObject = new PtvPanelProviderHelper(paramBaseChatPie);
    a(131, (ILifeCycleHelper)localObject);
    a((OnActivityResultCallback)localObject);
    a(132, new AioOnClickHelper(paramBaseChatPie.bv()));
    a(133, new EmojiStickerHelper(paramBaseChatPie));
    localObject = new SignatureHelper(paramBaseChatPie);
    a(135, (ILifeCycleHelper)localObject);
    a((Handler.Callback)localObject);
    a(136, new GiftPanelHelper(paramBaseChatPie));
  }
  
  public void a(OnTroopChatMsgChangedCallback paramOnTroopChatMsgChangedCallback)
  {
    this.a.add(paramOnTroopChatMsgChangedCallback);
  }
  
  protected boolean b()
  {
    return false;
  }
  
  protected boolean b(BaseChatPie paramBaseChatPie)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.HelperProvider
 * JD-Core Version:    0.7.0.1
 */