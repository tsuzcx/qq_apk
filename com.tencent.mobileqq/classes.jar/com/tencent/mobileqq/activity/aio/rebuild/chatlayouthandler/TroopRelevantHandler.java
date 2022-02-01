package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.anonymous.AnonymousChatHelper.AnonymousExtInfo;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.utils.Base64;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder.BaseHolder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.BaseChatItemLayoutViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.HeadIconWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.INickNameLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameChatItemLayoutProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutViewWrapper;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.ChatLayoutHandler;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IBaseBubbleClickProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.chatlayouthandler.IChatLayoutListenerController;
import com.tencent.mobileqq.activity.aio.item.QQStoryItemBuilder;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.confess.TroopConfessUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageForQQStory;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.flashchat.FlashChatManager.GlobalConfig;
import com.tencent.mobileqq.multimsg.MultiMsgManager;
import com.tencent.mobileqq.multimsg.MultiMsgUtil;
import com.tencent.mobileqq.nearby.NearbyURLSafeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.memberlevel.api.ITroopMemberLevelUtilsApi;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi;
import com.tencent.mobileqq.troop.trooplink.api.ITroopLinkApi.LinkParams;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.widget.troopmemberlevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

public class TroopRelevantHandler
  extends ChatLayoutHandler
  implements IBaseBubbleClickProcessor
{
  boolean a = false;
  boolean g = false;
  boolean h = false;
  private int i = 0;
  
  public TroopRelevantHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
  }
  
  private ColorStateList a(ChatMessage paramChatMessage, ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (this.g)
    {
      localColorStateList = paramColorStateList;
      if (this.h)
      {
        localColorStateList = paramColorStateList;
        if (!paramChatMessage.isMultiMsg)
        {
          localColorStateList = paramColorStateList;
          if (this.c.a == 1)
          {
            localColorStateList = paramColorStateList;
            if (AnonymousChatHelper.a().a(this.c.b)) {
              localColorStateList = ColorStateList.valueOf(AnonymousChatHelper.d);
            }
          }
        }
      }
    }
    return localColorStateList;
  }
  
  private ColorStateList a(ChatMessage paramChatMessage, ColorStateList paramColorStateList, TroopBusinessUtil.TroopBusinessMessage paramTroopBusinessMessage)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (ThemeUtil.isNowThemeIsDefault(this.b, false, null))
    {
      localColorStateList = paramColorStateList;
      if (!TroopConfessUtil.a(paramChatMessage)) {
        localColorStateList = ColorStateList.valueOf(paramTroopBusinessMessage.e);
      }
    }
    return localColorStateList;
  }
  
  @Nullable
  private HotChatInfo a(ChatMessage paramChatMessage, HotChatManager paramHotChatManager, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramHotChatManager.c(paramChatMessage.frienduin);
    }
    return null;
  }
  
  private CharSequence a(ChatMessage paramChatMessage, CharSequence paramCharSequence)
  {
    if (paramChatMessage.msgtype == -3006) {
      paramCharSequence = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b, BaseApplicationImpl.getContext());
    }
    Object localObject = paramCharSequence;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localObject = paramCharSequence;
      if (TroopBindPublicAccountMgr.a(paramChatMessage)) {
        localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b, BaseApplicationImpl.getContext());
      }
    }
    return localObject;
  }
  
  private String a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    ITroopLinkApi localITroopLinkApi = (ITroopLinkApi)QRoute.api(ITroopLinkApi.class);
    if (paramInt == 2) {
      localObject = "troop_unique_title";
    } else {
      localObject = "troop_rank";
    }
    Object localObject = localITroopLinkApi.getUrl((String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      ((StringBuilder)localObject).append("gc=");
      ((StringBuilder)localObject).append(paramMessageRecord.frienduin);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramMessageRecord.senderuin);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("nick=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("type=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("&");
      ((StringBuilder)localObject).append("from=");
      ((StringBuilder)localObject).append("aio");
      ((StringBuilder)localObject).append("&");
      return ((StringBuilder)localObject).toString();
    }
    ITroopLinkApi.LinkParams localLinkParams = new ITroopLinkApi.LinkParams();
    localLinkParams.a = paramMessageRecord.frienduin;
    localLinkParams.b = paramMessageRecord.senderuin;
    localLinkParams.e = paramString;
    paramMessageRecord = new StringBuilder();
    paramMessageRecord.append("");
    paramMessageRecord.append(paramInt);
    localLinkParams.d = paramMessageRecord.toString();
    localLinkParams.c = "aio";
    return localITroopLinkApi.replaceParams((String)localObject, localLinkParams);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    boolean bool1 = AnonymousChatHelper.c(paramChatMessage);
    boolean bool4 = true;
    if (bool1)
    {
      localObject1 = AnonymousChatHelper.g(paramChatMessage).c;
      bool1 = true;
    }
    else
    {
      localObject1 = null;
      bool1 = false;
    }
    Object localObject3 = a(paramChatMessage, this.c.H.b);
    boolean bool5 = a(paramChatMessage, false);
    Object localObject1 = a(paramChatMessage, (CharSequence)localObject1);
    Object localObject4 = TroopBusinessUtil.a(paramChatMessage);
    Object localObject2 = localObject3;
    if (localObject4 != null)
    {
      localObject1 = ((TroopBusinessUtil.TroopBusinessMessage)localObject4).d;
      localObject2 = a(paramChatMessage, (ColorStateList)localObject3, (TroopBusinessUtil.TroopBusinessMessage)localObject4);
    }
    localObject4 = localObject1;
    localObject3 = localObject2;
    Object localObject5;
    boolean bool2;
    if (a(paramChatMessage))
    {
      localObject5 = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      bool2 = ((HotChatManager)localObject5).b(paramChatMessage.frienduin);
      localObject4 = localObject1;
      localObject3 = localObject2;
      if (a(bool2, a(paramChatMessage, (HotChatManager)localObject5, bool2)))
      {
        localObject2 = ColorStateList.valueOf(-1);
        localObject4 = localObject1;
        localObject3 = localObject2;
        if (paramChatMessage.isSend())
        {
          localObject4 = this.b.getCurrentNickname();
          localObject3 = localObject2;
        }
      }
    }
    int j;
    if (((FriendsManager)this.b.getManager(QQManagerFactory.FRIENDS_MANAGER)).p(paramChatMessage.senderuin) == 1) {
      j = 1;
    } else {
      j = 0;
    }
    localObject1 = ((FlashChatManager)this.b.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c;
    if (j != 0) {
      localObject1 = ((FlashChatManager.GlobalConfig)localObject1).d;
    } else {
      localObject1 = null;
    }
    localObject2 = b(paramChatMessage, (CharSequence)localObject4);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      if (paramChatMessage.istroop == 1)
      {
        localObject2 = paramChatMessage.senderuin;
        if ((localObject2 == null) && (!bool1)) {
          bool2 = false;
        } else {
          bool2 = true;
        }
        boolean bool3;
        if (bool1)
        {
          bool3 = bool4;
          if (AnonymousChatHelper.f(paramChatMessage)) {}
        }
        else if (paramChatMessage.isSend())
        {
          bool3 = bool4;
        }
        else
        {
          bool3 = false;
        }
        paramBaseChatItemLayout.setNick(bool2, (CharSequence)localObject2, (ColorStateList)localObject3, bool3, bool5, false, false, "", null, (String)localObject1);
        localObject5 = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
        localObject4 = (TroopRelevantHandler.TmiCallBackForNickName)paramBaseChatItemLayout.getTag(2131430596);
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          localObject2 = new TroopRelevantHandler.TmiCallBackForNickName(this, null);
          paramBaseChatItemLayout.setTag(2131430596, localObject2);
        }
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).a = bool1;
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).b = ((ColorStateList)localObject3);
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).c = bool5;
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).d = false;
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).e = "";
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).f = null;
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).g = false;
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).h = ((String)localObject1);
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).i = paramBaseChatItemLayout;
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).j = paramChatMessage;
        ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).k = paramViewHolder;
        ((TroopManager)localObject5).a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject2);
      }
    }
    else
    {
      if ((localObject2 == null) && (!bool1)) {
        bool2 = false;
      } else {
        bool2 = true;
      }
      if (((!bool1) || (!AnonymousChatHelper.f(paramChatMessage))) && (!TroopConfessUtil.c(paramChatMessage)) && (!paramChatMessage.isSend())) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      paramBaseChatItemLayout.setNick(bool2, (CharSequence)localObject2, (ColorStateList)localObject3, bool1, bool5, false, false, "", null, (String)localObject1);
      a(((CharSequence)localObject2).toString(), paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
      if ((paramChatMessage.isMultiMsg) && (!AnonymousChatHelper.c(paramChatMessage)))
      {
        paramViewHolder = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.h);
        if (paramViewHolder != null) {
          paramViewHolder.setData(new Object[] { this.b, localObject2 });
        }
      }
    }
    e(paramChatMessage, paramBaseChatItemLayout);
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    if (AppSetting.e)
    {
      int j;
      if (paramChatMessage.istroop == 1) {
        j = 1;
      } else {
        j = 0;
      }
      int k;
      if (paramChatMessage.istroop == 3000) {
        k = 1;
      } else {
        k = 0;
      }
      int m;
      if ((paramChatMessage.fakeSenderType != 2) && (((paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 3000)) || (!paramChatMessage.isMultiMsg))) {
        m = 0;
      } else {
        m = 1;
      }
      int n;
      if ((!TextUtils.equals(this.b.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
        n = 0;
      } else {
        n = 1;
      }
      if ((j != 0) || (k != 0) || (m != 0))
      {
        Object localObject;
        if (j != 0)
        {
          if (n != 0)
          {
            localObject = HardCodeUtil.a(2131899183);
          }
          else if ("1000000".equals(paramChatMessage.senderuin))
          {
            if (paramChatMessage.msgtype == -3006) {
              localObject = String.format(paramBaseChatItemLayout.getResources().getString(2131895452), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b, BaseApplicationImpl.getContext()) });
            } else {
              localObject = HardCodeUtil.a(2131899184);
            }
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899177));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else if (k != 0)
        {
          if (n != 0)
          {
            localObject = HardCodeUtil.a(2131899187);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899178));
            localObject = ((StringBuilder)localObject).toString();
          }
        }
        else
        {
          if (n != 0)
          {
            localObject = HardCodeUtil.a(2131899187);
          }
          else
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(HardCodeUtil.a(2131899178));
            localObject = ((StringBuilder)localObject).toString();
          }
          if (paramChatMessage.msgtype == -3006) {
            localObject = String.format(paramBaseChatItemLayout.getResources().getString(2131895452), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.b, BaseApplicationImpl.getContext()) });
          }
        }
        paramBaseChatItemLayout = (HeadIconWrapper)paramBaseChatItemLayout.a(HeadIconWrapper.class);
        if (paramBaseChatItemLayout != null)
        {
          paramBaseChatItemLayout = paramBaseChatItemLayout.c();
          if (paramBaseChatItemLayout != null) {
            paramBaseChatItemLayout.setContentDescription((CharSequence)localObject);
          }
        }
      }
    }
    if ((AppSetting.e) && (paramViewHolder.r != null))
    {
      if ((!TextUtils.equals(this.b.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend()))
      {
        paramBaseChatItemLayout = paramString;
        if (paramString == null) {
          paramBaseChatItemLayout = "";
        }
        paramString = paramBaseChatItemLayout;
        if (AnonymousChatHelper.c(paramChatMessage))
        {
          paramString = new StringBuilder();
          paramString.append(this.d.getResources().getString(2131886662));
          paramString.append(paramBaseChatItemLayout);
          paramString = paramString.toString();
        }
        paramViewHolder.r.insert(0, paramString);
        return;
      }
      paramViewHolder.r.append("我");
    }
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.istroop == 1) && (!AnonymousChatHelper.c(paramChatMessage));
  }
  
  private boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramChatMessage.istroop == 1)
    {
      bool = paramBoolean;
      if (((HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramChatMessage.frienduin) != null) {
        bool = HotChatManager.a(paramChatMessage);
      }
    }
    return bool;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1))
    {
      paramMessageRecord = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
      TroopInfo localTroopInfo = paramMessageRecord.f(this.c.b);
      if ((localTroopInfo != null) && (localTroopInfo.isQidianPrivateTroop())) {
        return true;
      }
      if (paramMessageRecord.F(this.c.b)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return (paramBoolean) && (((ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.d, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
  }
  
  private boolean a(boolean paramBoolean, HotChatInfo paramHotChatInfo)
  {
    return (paramBoolean) && (paramHotChatInfo != null) && (paramHotChatInfo.isGameRoom);
  }
  
  private CharSequence b(ChatMessage paramChatMessage, CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramChatMessage.isMultiMsg)
    {
      localObject = paramCharSequence;
      if (!AnonymousChatHelper.c(paramChatMessage))
      {
        localObject = paramChatMessage.getExtInfoFromExtStr("self_nickname");
        paramCharSequence = (CharSequence)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramCharSequence = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.b);
        }
        if (paramCharSequence != null)
        {
          localObject = paramCharSequence;
          if (TextUtils.getTrimmedLength(paramCharSequence) != 0) {}
        }
        else
        {
          localObject = MultiMsgUtil.b(paramChatMessage.senderuin);
        }
        localObject = new ColorNickText((CharSequence)localObject, 13).b();
      }
    }
    return localObject;
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.i);
    if ((!AnonymousChatHelper.c(paramChatMessage)) && (!"1000000".equals(paramChatMessage.senderuin)) && (!(paramChatMessage instanceof MessageForTroopConfess)))
    {
      if (TroopBusinessUtil.a(paramChatMessage) != null)
      {
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()))
        {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setViewVisibility(8);
          ((BaseChatItemLayoutViewBasicAbility)localObject).setOnClickListener(null);
        }
        return;
      }
      int j = paramChatMessage.istroop;
      int m = 1;
      if (j == 1)
      {
        if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull())) {
          ((BaseChatItemLayoutViewBasicAbility)localObject).setViewVisibility(8);
        }
        TroopManager localTroopManager = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager != null)
        {
          TroopInfo localTroopInfo = localTroopManager.f(paramChatMessage.frienduin);
          localObject = (ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all");
          if (localTroopInfo == null) {
            return;
          }
          if (((ITroopRobotService)localObject).isRobotUin(paramChatMessage.senderuin)) {
            return;
          }
          boolean bool = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramChatMessage.frienduin);
          if ((localTroopInfo.cGroupRankUserFlag != 1) && (localTroopInfo.cNewGroupRankUserFlag != 0)) {
            j = 0;
          } else {
            j = 1;
          }
          if (j == 0)
          {
            k = m;
            if (localTroopInfo.isTroopOwner(paramChatMessage.senderuin)) {
              break label265;
            }
            if (localTroopInfo.isTroopAdmin(paramChatMessage.senderuin))
            {
              k = m;
              break label265;
            }
          }
          int k = 0;
          label265:
          if ((bool) && ((j != 0) || (k != 0) || (localTroopInfo.isQidianPrivateTroop()) || (localTroopInfo.isHomeworkTroop())))
          {
            TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel localTmiCallBackForTroopMemberNewLevel = (TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)paramBaseChatItemLayout.getTag(2131430620);
            localObject = localTmiCallBackForTroopMemberNewLevel;
            if (localTmiCallBackForTroopMemberNewLevel == null)
            {
              localObject = new TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel(this, null);
              paramBaseChatItemLayout.setTag(2131430620, localObject);
            }
            ((TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)localObject).a = paramBaseChatItemLayout;
            ((TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)localObject).b = paramChatMessage.senderuin;
            ((TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)localObject).c = localTroopInfo;
            localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject);
          }
        }
      }
      return;
    }
    if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull()))
    {
      ((BaseChatItemLayoutViewBasicAbility)localObject).setViewVisibility(8);
      ((BaseChatItemLayoutViewBasicAbility)localObject).setOnClickListener(null);
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    Object localObject = TroopBusinessUtil.a(paramMessageRecord);
    if (localObject != null)
    {
      TroopBusinessUtil.a(this.b, this.d, (TroopBusinessUtil.TroopBusinessMessage)localObject);
      localObject = ((TroopBusinessUtil.TroopBusinessMessage)localObject).d;
      ReportController.b(this.b, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, paramMessageRecord.frienduin, "", (String)localObject, "");
      if (paramMessageRecord.msgtype == -2051) {
        try
        {
          paramMessageRecord = (MessageForQQStory)paramMessageRecord;
          paramMessageRecord = JumpParser.a(this.b, this.d, paramMessageRecord.msgAction);
          QQStoryItemBuilder.a(this.b, this.c.a, "clk_name", paramMessageRecord, false);
        }
        catch (Exception paramMessageRecord)
        {
          if (QLog.isColorLevel()) {
            QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
          }
        }
      }
      return true;
    }
    return false;
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    TroopManager localTroopManager = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    int j = this.c.a;
    Object localObject2 = Boolean.valueOf(false);
    boolean bool;
    if ((j == 1) && (AnonymousChatHelper.a().a(this.c.b))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      j = AnonymousChatHelper.e;
    } else {
      j = -1;
    }
    Object localObject1 = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.j);
    int k;
    if (AnonymousChatHelper.c(paramChatMessage))
    {
      int m = TroopRankConfig.a().a;
      paramBaseChatItemLayout = AnonymousChatHelper.g(paramChatMessage);
      k = m;
      try
      {
        if (!TextUtils.isEmpty(paramBaseChatItemLayout.f)) {
          k = Color.parseColor(paramBaseChatItemLayout.f);
        }
      }
      catch (Exception paramBaseChatItemLayout)
      {
        paramBaseChatItemLayout.printStackTrace();
        QLog.e("TroopRelevantHandler", 1, "handleTroopMemberLevel Exception");
        k = m;
      }
      if ((((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramChatMessage.frienduin)) && (!AnonymousChatHelper.f(paramChatMessage))) {
        bool = false;
      } else {
        bool = true;
      }
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull()))
      {
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setData(new Object[] { this.b, Boolean.valueOf(bool), this.d.getResources().getString(2131886656), Boolean.valueOf(AnonymousChatHelper.f(paramChatMessage)), Integer.valueOf(k), Integer.valueOf(j) });
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setOnClickListener(null);
      }
      return;
    }
    if ("1000000".equals(paramChatMessage.senderuin))
    {
      this.a = false;
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull())) {
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setData(new Object[] { this.b, localObject2, null, localObject2, Integer.valueOf(-1), Integer.valueOf(j) });
      }
      return;
    }
    if ((paramChatMessage instanceof MessageForTroopConfess))
    {
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull())) {
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setData(new Object[] { this.b, localObject2, null, localObject2, Integer.valueOf(-1), Integer.valueOf(j) });
      }
      return;
    }
    Object localObject3 = TroopBusinessUtil.a(paramChatMessage);
    if (localObject3 != null)
    {
      j = ((TroopBusinessUtil.TroopBusinessMessage)localObject3).g;
      k = ((TroopBusinessUtil.TroopBusinessMessage)localObject3).h;
      if (bool)
      {
        j = AnonymousChatHelper.e;
        k = TroopRankConfig.a().a;
      }
      bool = ((ITroopMemberLevelUtilsApi)QRoute.api(ITroopMemberLevelUtilsApi.class)).isNewRealLevelGrayTroop(paramChatMessage.frienduin);
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull()))
      {
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setData(new Object[] { this.b, Boolean.valueOf(bool ^ true), ((TroopBusinessUtil.TroopBusinessMessage)localObject3).f, localObject2, Integer.valueOf(k), Integer.valueOf(j) });
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setTag(Integer.valueOf(2131430619));
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setOnClickListener(this.e);
      }
      return;
    }
    if (paramChatMessage.istroop == 1)
    {
      if ((localObject1 != null) && (((BaseChatItemLayoutViewBasicAbility)localObject1).checkViewNonNull())) {
        ((BaseChatItemLayoutViewBasicAbility)localObject1).setData(new Object[] { this.b, localObject2, null, localObject2, Integer.valueOf(-1), Integer.valueOf(j) });
      }
      this.a = false;
      if (localTroopManager != null)
      {
        localObject3 = localTroopManager.f(paramChatMessage.frienduin);
        localObject1 = (ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all");
        if ((localObject3 != null) && ((((TroopInfo)localObject3).cGroupRankSysFlag == 1) || (((ITroopRobotService)localObject1).isRobotUin(paramChatMessage.senderuin)) || (((TroopInfo)localObject3).isQidianPrivateTroop()) || (((TroopInfo)localObject3).isHomeworkTroop())))
        {
          localObject2 = (TroopRelevantHandler.TmiCallBackForMemberLevel)paramBaseChatItemLayout.getTag(2131430619);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = new TroopRelevantHandler.TmiCallBackForMemberLevel(this, null);
            paramBaseChatItemLayout.setTag(2131430619, localObject1);
          }
          ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).a = paramBaseChatItemLayout;
          ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).b = bool;
          ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).d = j;
          ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).c = ((TroopInfo)localObject3);
          localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject1);
        }
      }
    }
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    Object localObject = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (localObject != null) {
      localObject = ((HotChatManager)localObject).c(this.c.b);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if (((HotChatInfo)localObject).isGameRoom) {
        return true;
      }
      if (a(paramMessageRecord, ((HotChatInfo)localObject).isRobotHotChat)) {
        return true;
      }
      localObject = paramMessageRecord.senderuin;
      String str = NearbyURLSafeUtil.b((String)localObject);
      paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747";
      if (!this.b.getCurrentAccountUin().equals(localObject))
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747");
        paramMessageRecord.append("&strangerUin=");
        paramMessageRecord.append(str);
        paramMessageRecord = paramMessageRecord.toString();
      }
      if (!this.b.getCurrentAccountUin().equals(localObject)) {
        localObject = "2";
      } else {
        localObject = "1";
      }
      ReportController.b(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject, "", "", "");
      localObject = new Intent(this.d, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("url", paramMessageRecord);
      this.d.startActivity((Intent)localObject);
      return true;
    }
    return false;
  }
  
  private void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramChatMessage.frienduin);
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((HotChatInfo)localObject).isGameRoom;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      localObject = ((WerewolvesHandler)this.b.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((WerewolvesPluginManager)localObject).a(paramChatMessage.senderuin);
        paramBaseChatItemLayout = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
        if (paramBaseChatItemLayout != null)
        {
          if (!TextUtils.isEmpty(paramChatMessage))
          {
            ((INickNameLayoutProcessor)paramBaseChatItemLayout.a()).a(true, paramChatMessage);
            return;
          }
          ((INickNameLayoutProcessor)paramBaseChatItemLayout.a()).a(false, paramChatMessage);
        }
      }
      return;
    }
    localObject = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      paramChatMessage = ((TroopManager)localObject).g(paramChatMessage.frienduin, paramChatMessage.senderuin);
      if (paramChatMessage != null)
      {
        paramBaseChatItemLayout = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
        if (paramBaseChatItemLayout != null)
        {
          localObject = (INickNameLayoutProcessor)paramBaseChatItemLayout.a();
          bool1 = bool2;
          if (paramChatMessage.hotChatGlamourLevel >= 1) {
            bool1 = true;
          }
          ((INickNameLayoutProcessor)localObject).a(bool1, paramChatMessage.hotChatGlamourLevel);
          paramChatMessage = ((INickNameLayoutProcessor)paramBaseChatItemLayout.a()).b();
          if (paramChatMessage != null)
          {
            paramChatMessage.setTag(Integer.valueOf(2131430616));
            paramChatMessage.setOnClickListener(this.e);
          }
        }
      }
    }
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
    if (localObject != null)
    {
      boolean bool = RobotUtils.a(this.b, paramChatMessage.senderuin);
      ((INickNameLayoutProcessor)((NickNameLayoutViewWrapper)localObject).a()).a(bool, paramChatMessage.isSend());
    }
    localObject = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.d);
    if ((localObject != null) && (((BaseChatItemLayoutViewBasicAbility)localObject).checkViewNonNull())) {
      ((BaseChatItemLayoutViewBasicAbility)localObject).setOnClickListener(this.e);
    }
    paramBaseChatItemLayout = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.h);
    if ((paramBaseChatItemLayout != null) && (paramBaseChatItemLayout.checkViewNonNull()))
    {
      if (!AnonymousChatHelper.c(paramChatMessage))
      {
        paramBaseChatItemLayout.setOnClickListener(this.e);
        paramBaseChatItemLayout.setTag(Integer.valueOf(2131430595));
      }
      else
      {
        paramBaseChatItemLayout.setOnClickListener(null);
      }
      if ((AppSetting.e) && (Build.VERSION.SDK_INT >= 14)) {
        paramBaseChatItemLayout.setAccessibilityDelegate(new TroopRelevantHandler.1(this));
      }
    }
  }
  
  private void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(this.c.b);
    if (localHotChatInfo != null)
    {
      if (localHotChatInfo.isGameRoom) {
        return;
      }
      Object localObject2 = null;
      boolean bool = this.b.getCurrentAccountUin().equals(paramChatMessage.senderuin);
      int k = 0;
      Object localObject1 = localObject2;
      int j = k;
      if (!bool) {
        if (paramChatMessage.senderuin.equals(localHotChatInfo.ownerUin))
        {
          localObject1 = HardCodeUtil.a(2131899179);
          j = k;
        }
        else if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
        {
          localObject1 = HardCodeUtil.a(2131899180);
          j = 1;
        }
        else
        {
          localObject1 = localObject2;
          j = k;
          if (localHotChatInfo.isRobotHotChat)
          {
            localObject1 = localObject2;
            j = k;
            if (((ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(paramChatMessage.senderuin))
            {
              localObject1 = HardCodeUtil.a(2131899186);
              j = k;
            }
          }
        }
      }
      paramChatMessage = (NickNameLayoutViewWrapper)paramBaseChatItemLayout.a(NickNameLayoutViewWrapper.class);
      if (paramChatMessage != null) {
        ((INickNameLayoutProcessor)paramChatMessage.a()).a((String)localObject1, j);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if ((paramChatMessage != null) && (paramViewGroup != null) && (paramContext != null) && (paramBaseChatItemLayout != null))
    {
      if (paramViewHolder == null) {
        return;
      }
      if (paramBundle != null)
      {
        this.g = paramBundle.getBoolean("inChatHistory", false);
        this.h = paramBundle.getBoolean("inInMiniAIO", false);
      }
      if (TroopBindPublicAccountMgr.a(paramChatMessage)) {
        paramBaseChatItemLayout.setGrayTipsText(true, paramChatMessage, paramContext.getString(2131894202), this.d.getResources().getColorStateList(2131165715), 0);
      } else {
        paramBaseChatItemLayout.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage, paramChatMessage.mMessageSource, this.d.getResources().getColorStateList(2131165715), 235);
      }
      if ((paramChatMessage.fakeSenderType == 2) && (AnonymousChatHelper.c(paramChatMessage))) {
        a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
      }
      if ((paramChatMessage.fakeSenderType == 0) && (paramChatMessage.istroop == 1))
      {
        paramViewGroup = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((paramViewGroup != null) && (paramViewGroup.b(this.c.b)))
        {
          f(paramChatMessage, paramBaseChatItemLayout);
          d(paramChatMessage, paramBaseChatItemLayout);
          a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
          a(paramChatMessage, paramBaseChatItemLayout);
          return;
        }
        a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
        c(paramChatMessage, paramBaseChatItemLayout);
        a(paramChatMessage, paramBaseChatItemLayout);
        b(paramChatMessage, paramBaseChatItemLayout);
        new TroopMemGradeLevelBuilder(paramChatMessage, paramBaseChatItemLayout).a(this.b);
      }
    }
  }
  
  protected void a(View paramView)
  {
    Object localObject3 = AIOUtils.a(paramView);
    if (a((MessageRecord)localObject3)) {
      return;
    }
    if (TroopBusinessUtil.a((MessageRecord)localObject3) != null) {
      return;
    }
    if ((localObject3 != null) && (((MessageRecord)localObject3).istroop == 1) && (Utils.e(((MessageRecord)localObject3).senderuin)))
    {
      Object localObject1 = (HotChatManager)this.b.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      Object localObject2 = null;
      if (localObject1 != null) {
        localObject1 = ((HotChatManager)localObject1).c(this.c.b);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        return;
      }
      if (((ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.d, ((MessageRecord)localObject3).frienduin, Long.parseLong(((MessageRecord)localObject3).senderuin))) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://qun.qq.com/interactive/userhonor?gc=");
      ((StringBuilder)localObject1).append(((MessageRecord)localObject3).frienduin);
      ((StringBuilder)localObject1).append("&uin=");
      ((StringBuilder)localObject1).append(((MessageRecord)localObject3).senderuin);
      ((StringBuilder)localObject1).append("&_wv=3&&_wwv=128");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject3).putExtra("url", (String)localObject1);
      paramView.getContext().startActivity((Intent)localObject3);
      localObject1 = localObject2;
      if ((paramView instanceof TroopMemberNewLevelView)) {
        localObject1 = (TroopMemberNewLevelView)paramView;
      }
      if (localObject1 != null)
      {
        if ((((TroopMemberNewLevelView)localObject1).a()) && (((TroopMemberNewLevelView)localObject1).b()))
        {
          j = 3;
          break label291;
        }
        if (((TroopMemberNewLevelView)localObject1).a())
        {
          j = 1;
          break label291;
        }
        if (((TroopMemberNewLevelView)localObject1).b())
        {
          j = 2;
          break label291;
        }
      }
      int j = 0;
      label291:
      ReportController.b(this.b, "dc00898", "", "", "0X800B200", "0X800B200", j, 0, "", "", "", "");
    }
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = paramBaseChatItemLayout.a(NickNameChatItemLayoutProcessor.c);
    if ((!TroopHonorAIOUtils.a(this.b, paramChatMessage)) && (localObject != null))
    {
      ((BaseChatItemLayoutViewBasicAbility)localObject).setData(null);
      return;
    }
    if ((!TroopHonorAIOUtils.a(this.b, paramChatMessage.frienduin)) && (localObject != null))
    {
      ((BaseChatItemLayoutViewBasicAbility)localObject).setData(null);
      return;
    }
    if ((paramChatMessage.istroop == 1) && (localObject != null))
    {
      ((BaseChatItemLayoutViewBasicAbility)localObject).setData(null);
      TroopManager localTroopManager = (TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER);
      if (((ITroopHonorService)this.b.getRuntimeService(ITroopHonorService.class, "")).isSupportTroopHonor(paramChatMessage.frienduin))
      {
        TroopRelevantHandler.TmiCallBackForTroopHonor localTmiCallBackForTroopHonor = (TroopRelevantHandler.TmiCallBackForTroopHonor)paramBaseChatItemLayout.getTag(2131430618);
        localObject = localTmiCallBackForTroopHonor;
        if (localTmiCallBackForTroopHonor == null)
        {
          localObject = new TroopRelevantHandler.TmiCallBackForTroopHonor(this, null);
          paramBaseChatItemLayout.setTag(2131430618, localObject);
        }
        ((TroopRelevantHandler.TmiCallBackForTroopHonor)localObject).a = paramBaseChatItemLayout;
        ((TroopRelevantHandler.TmiCallBackForTroopHonor)localObject).b = paramChatMessage.senderuin;
        localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject);
      }
    }
  }
  
  public void b(View paramView)
  {
    if (paramView == null) {
      return;
    }
    int j = paramView.getId();
    if ((j != 2131430569) && (j != 2131430616))
    {
      switch (j)
      {
      default: 
        return;
      case 2131430620: 
        a(paramView);
        return;
      }
      Object localObject = (ChatItemBuilder.BaseHolder)AIOUtils.b(paramView);
      String str = ((ChatItemBuilder.BaseHolder)localObject).q.frienduin;
      localObject = ((ChatItemBuilder.BaseHolder)localObject).q.senderuin;
      if (((ITroopHonorService)this.b.getRuntimeService(ITroopHonorService.class, "")).isSupportTroopHonor(str))
      {
        str = ((ITroopLinkApi)QRoute.api(ITroopLinkApi.class)).getTroopMemberHonorUrl(str, (String)localObject);
        localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", str);
        paramView.getContext().startActivity((Intent)localObject);
        if (paramView.getId() == 2131430618) {
          ReportController.b(null, "dc00898", "", "", "0X800A705", "0X800A705", 0, 0, "", "", "", "");
        }
      }
      else if (paramView.getId() == 2131430619)
      {
        c(paramView);
      }
    }
    else
    {
      c(paramView);
    }
  }
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (a(localChatMessage)) {
      return;
    }
    if (b(localChatMessage)) {
      return;
    }
    if (localChatMessage != null)
    {
      int k = localChatMessage.istroop;
      int j = 1;
      if ((k == 1) && (Utils.e(localChatMessage.senderuin)))
      {
        if (c(localChatMessage)) {
          return;
        }
        if (((ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.d, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin))) {
          return;
        }
        Object localObject2 = ((TroopManager)this.b.getManager(QQManagerFactory.TROOP_MANAGER)).f(this.c.b);
        Object localObject1;
        if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
        {
          k = paramView.getId();
          if (k == 2131430619) {
            localObject1 = "clk_title";
          } else {
            localObject1 = "clk_nickname";
          }
          ReportController.b(this.b, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
          Object localObject3 = ContactUtils.a(this.b, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
          if (k == 2131430619)
          {
            localObject1 = "Clk_label";
            j = 2;
          }
          else
          {
            localObject1 = "Clk_name";
          }
          try
          {
            localObject2 = Base64.encodeToString(((String)localObject3).getBytes("UTF-8"), 0);
          }
          catch (Exception localException)
          {
            localObject2 = localObject3;
            if (QLog.isColorLevel())
            {
              QLog.e("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:", localException);
              localObject2 = localObject3;
            }
          }
          localObject2 = a(localChatMessage, j, (String)localObject2);
          paramView = paramView.getContext();
          localObject3 = new Intent(paramView, QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("url", (String)localObject2);
          ((Intent)localObject3).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
          paramView.startActivity((Intent)localObject3);
          localObject3 = this.b;
          String str = localChatMessage.frienduin;
          if (localChatMessage.isSend()) {
            paramView = "1";
          } else {
            paramView = "0";
          }
          ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, str, paramView, "", "");
          if (QLog.isColorLevel())
          {
            paramView = new StringBuilder();
            paramView.append("onTroopMemberLevelClick:");
            paramView.append((String)localObject2);
            QLog.d("BaseBubbleBuilder", 2, paramView.toString());
          }
        }
        else if (this.a)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick, openLevelPKPage");
          }
          localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("https://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=");
          ((StringBuilder)localObject2).append(localChatMessage.frienduin);
          ((StringBuilder)localObject2).append("&target=");
          ((StringBuilder)localObject2).append(localChatMessage.senderuin);
          ((Intent)localObject1).putExtra("url", ((StringBuilder)localObject2).toString());
          ((Intent)localObject1).putExtra("hide_operation_bar", true);
          ((Intent)localObject1).putExtra("hide_more_button", true);
          paramView.getContext().startActivity((Intent)localObject1);
          ReportController.b(this.b, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
        }
        if (this.i >= 2) {
          ReportController.b(this.b, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.c.b, String.valueOf(this.i), "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler
 * JD-Core Version:    0.7.0.1
 */