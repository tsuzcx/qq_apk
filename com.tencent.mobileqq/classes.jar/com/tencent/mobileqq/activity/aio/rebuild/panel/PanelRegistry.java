package com.tencent.mobileqq.activity.aio.rebuild.panel;

import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelProvider;
import com.tencent.mobileqq.activity.aio.audiopanel.VoiceTextEditPanelProvider;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.GiftPanelHelper;
import com.tencent.mobileqq.activity.aio.helper.HWTroopClassInfoTipsHelper;
import com.tencent.mobileqq.activity.aio.helper.HotGiftPanelHelper;
import com.tencent.mobileqq.activity.aio.panel.ArkAppManagerPanelProvider;
import com.tencent.mobileqq.activity.aio.panel.DoodlePanelProvider;
import com.tencent.mobileqq.activity.aio.panel.PanelListener;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.panel.PhotoListPanelProvider;
import com.tencent.mobileqq.activity.aio.panel.PlusPanelProvider;
import com.tencent.mobileqq.activity.aio.panel.PokeAndEmoPanelProvider;
import com.tencent.mobileqq.activity.aio.panel.QQAssistantProvider;
import com.tencent.mobileqq.activity.aio.panel.RelateEmoPanelProvider;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioShortcutBarProvider;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.apollo.aio.panel.api.IApolloPanelProvider;
import com.tencent.mobileqq.apollo.aio.panel.api.ICmGamePanelProvider;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.IHongbaoPanelProvider;

public class PanelRegistry
{
  public static void a(BaseChatPie paramBaseChatPie, PanelManager paramPanelManager)
  {
    paramPanelManager.a(new PlusPanelProvider(paramBaseChatPie));
    paramPanelManager.a(new PokeAndEmoPanelProvider(paramBaseChatPie));
    paramPanelManager.a((PanelProvider)((IHongbaoPanelProvider)QRoute.api(IHongbaoPanelProvider.class)).init(paramBaseChatPie));
    paramPanelManager.a(new ArkAppManagerPanelProvider(paramBaseChatPie));
    paramPanelManager.a(new PhotoListPanelProvider(paramBaseChatPie));
    paramPanelManager.a(new RelateEmoPanelProvider(paramBaseChatPie));
    Object localObject = (ICmGamePanelProvider)QRoute.api(ICmGamePanelProvider.class);
    ((ICmGamePanelProvider)localObject).init(paramBaseChatPie);
    paramPanelManager.a((PanelProvider)localObject);
    localObject = (IApolloPanelProvider)QRoute.api(IApolloPanelProvider.class);
    ((IApolloPanelProvider)localObject).init(paramBaseChatPie);
    paramPanelManager.a((PanelProvider)localObject);
    if (((paramBaseChatPie instanceof TroopChatPie)) || ((paramBaseChatPie instanceof FriendChatPie)) || ((paramBaseChatPie instanceof LimitChatPie))) {
      paramPanelManager.a(new AioShortcutBarProvider(paramBaseChatPie));
    }
    paramPanelManager.a(new QQAssistantProvider());
    paramPanelManager.a(new DoodlePanelProvider(paramBaseChatPie));
    paramPanelManager.a(new AudioPanelProvider(paramBaseChatPie));
    paramPanelManager.a(new VoiceTextEditPanelProvider(paramBaseChatPie));
    localObject = (AIOEmoticonUIHelper)paramBaseChatPie.a(105);
    if (localObject != null) {
      paramPanelManager.a((PanelProvider)localObject);
    }
    paramPanelManager.a((PanelListener)paramBaseChatPie.a(116));
    paramPanelManager.a((PanelListener)paramBaseChatPie.a(108));
    paramPanelManager.a((PanelListener)paramBaseChatPie.a(24));
    paramPanelManager.a((PanelListener)paramBaseChatPie.a(124));
    paramPanelManager.a((PanelListener)paramBaseChatPie.a(4));
    paramPanelManager.a((PanelProvider)paramBaseChatPie.a(110));
    paramPanelManager.a((PanelProvider)paramBaseChatPie.a(126));
    paramPanelManager.a(new HotTroopFlashPicPanelProvider(paramBaseChatPie.b()));
    paramPanelManager.a((PanelProvider)paramBaseChatPie.a(127));
    paramPanelManager.a(new CameraPanelProvider(paramBaseChatPie.b()));
    paramPanelManager.a(new TroopNotificationPanelProvider(paramBaseChatPie.b()));
    paramPanelManager.a(new TroopHomeWorkPanelProvider(paramBaseChatPie.b()));
    paramPanelManager.a(new PositionPanelProvider(paramBaseChatPie.b()));
    paramPanelManager.a((PanelProvider)paramBaseChatPie.a(131));
    paramPanelManager.a((PanelListener)paramBaseChatPie.a(110));
    localObject = (HWTroopClassInfoTipsHelper)paramBaseChatPie.a(73);
    if (localObject != null) {
      paramPanelManager.a((PanelListener)localObject);
    }
    paramBaseChatPie = (GiftPanelHelper)paramBaseChatPie.a(136);
    if ((paramBaseChatPie instanceof HotGiftPanelHelper)) {
      paramPanelManager.a((HotGiftPanelHelper)paramBaseChatPie);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.PanelRegistry
 * JD-Core Version:    0.7.0.1
 */