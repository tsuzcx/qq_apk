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
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.honor.TroopHonorAIOUtils;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberLevelUtils;
import com.tencent.mobileqq.troop.troopMemberLevel.TroopMemberNewLevelView;
import com.tencent.mobileqq.troop.troopgame.TroopMemGradeLevelBuilder;
import com.tencent.mobileqq.troop.utils.RobotUtils;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil;
import com.tencent.mobileqq.troop.utils.TroopBusinessUtil.TroopBusinessMessage;
import com.tencent.mobileqq.troop.utils.TroopLinkManager;
import com.tencent.mobileqq.troop.utils.TroopLinkManager.LinkParams;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
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
  private int jdField_a_of_type_Int = 0;
  boolean jdField_a_of_type_Boolean = false;
  boolean b;
  boolean c = false;
  
  public TroopRelevantHandler(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, IChatLayoutListenerController paramIChatLayoutListenerController)
  {
    super(paramQQAppInterface, paramSessionInfo, paramContext, paramOnClickListener, paramOnLongClickListener, paramIChatLayoutListenerController);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private ColorStateList a(ChatMessage paramChatMessage, ColorStateList paramColorStateList)
  {
    ColorStateList localColorStateList = paramColorStateList;
    if (this.jdField_b_of_type_Boolean)
    {
      localColorStateList = paramColorStateList;
      if (this.c)
      {
        localColorStateList = paramColorStateList;
        if (!paramChatMessage.isMultiMsg)
        {
          localColorStateList = paramColorStateList;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1)
          {
            localColorStateList = paramColorStateList;
            if (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
              localColorStateList = ColorStateList.valueOf(AnonymousChatHelper.jdField_d_of_type_Int);
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
    if (ThemeUtil.isNowThemeIsDefault(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null))
    {
      localColorStateList = paramColorStateList;
      if (!TroopConfessUtil.a(paramChatMessage)) {
        localColorStateList = ColorStateList.valueOf(paramTroopBusinessMessage.b);
      }
    }
    return localColorStateList;
  }
  
  @Nullable
  private HotChatInfo a(ChatMessage paramChatMessage, HotChatManager paramHotChatManager, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramHotChatManager.a(paramChatMessage.frienduin);
    }
    return null;
  }
  
  private CharSequence a(ChatMessage paramChatMessage, CharSequence paramCharSequence)
  {
    if (paramChatMessage.msgtype == -3006) {
      paramCharSequence = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
    }
    Object localObject = paramCharSequence;
    if ((paramChatMessage instanceof MessageForStructing))
    {
      localObject = paramCharSequence;
      if (TroopBindPublicAccountMgr.a(paramChatMessage)) {
        localObject = ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext());
      }
    }
    return localObject;
  }
  
  private String a(MessageRecord paramMessageRecord, int paramInt, String paramString)
  {
    TroopLinkManager localTroopLinkManager = TroopLinkManager.a();
    if (paramInt == 2) {}
    for (Object localObject = "troop_unique_title";; localObject = "troop_rank")
    {
      localObject = localTroopLinkManager.a((String)localObject);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://web.qun.qq.com/cgi-bin/misc/dynamic_url?");
      ((StringBuilder)localObject).append("gc=").append(paramMessageRecord.frienduin).append("&");
      ((StringBuilder)localObject).append("uin=").append(paramMessageRecord.senderuin).append("&");
      ((StringBuilder)localObject).append("nick=").append(paramString).append("&");
      ((StringBuilder)localObject).append("type=").append(paramInt).append("&");
      ((StringBuilder)localObject).append("from=").append("aio").append("&");
      return ((StringBuilder)localObject).toString();
    }
    TroopLinkManager.LinkParams localLinkParams = new TroopLinkManager.LinkParams();
    localLinkParams.jdField_a_of_type_JavaLangString = paramMessageRecord.frienduin;
    localLinkParams.b = paramMessageRecord.senderuin;
    localLinkParams.e = paramString;
    localLinkParams.jdField_d_of_type_JavaLangString = ("" + paramInt);
    localLinkParams.jdField_c_of_type_JavaLangString = "aio";
    return localTroopLinkManager.a((String)localObject, localLinkParams);
  }
  
  private void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    Object localObject1;
    boolean bool1;
    if (AnonymousChatHelper.a(paramChatMessage))
    {
      localObject1 = AnonymousChatHelper.a(paramChatMessage).b;
      bool1 = true;
    }
    for (;;)
    {
      ColorStateList localColorStateList = a(paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidContentResColorStateList);
      boolean bool4 = a(paramChatMessage, false);
      localObject1 = a(paramChatMessage, (CharSequence)localObject1);
      Object localObject2 = TroopBusinessUtil.a(paramChatMessage);
      if (localObject2 != null)
      {
        localObject1 = ((TroopBusinessUtil.TroopBusinessMessage)localObject2).jdField_c_of_type_JavaLangString;
        localColorStateList = a(paramChatMessage, localColorStateList, (TroopBusinessUtil.TroopBusinessMessage)localObject2);
      }
      for (;;)
      {
        boolean bool2;
        if (a(paramChatMessage))
        {
          localObject2 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
          bool2 = ((HotChatManager)localObject2).b(paramChatMessage.frienduin);
          if (a(bool2, a(paramChatMessage, (HotChatManager)localObject2, bool2)))
          {
            localColorStateList = ColorStateList.valueOf(-1);
            if (paramChatMessage.isSend()) {
              localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
            }
          }
        }
        for (localObject2 = localObject1;; localObject2 = localObject1)
        {
          int i;
          if (((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramChatMessage.senderuin) == 1)
          {
            i = 1;
            localObject1 = ((FlashChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a;
            if (i == 0) {
              break label459;
            }
            localObject1 = ((FlashChatManager.GlobalConfig)localObject1).jdField_d_of_type_JavaLangString;
            label217:
            localObject2 = b(paramChatMessage, (CharSequence)localObject2);
            if (!TextUtils.isEmpty((CharSequence)localObject2)) {
              break label477;
            }
            if (paramChatMessage.istroop == 1)
            {
              localObject2 = paramChatMessage.senderuin;
              if ((localObject2 == null) && (!bool1)) {
                break label465;
              }
              bool2 = true;
              label261:
              if (((!bool1) || (!AnonymousChatHelper.b(paramChatMessage))) && (!paramChatMessage.isSend())) {
                break label471;
              }
            }
          }
          label459:
          label465:
          label471:
          for (boolean bool3 = true;; bool3 = false)
          {
            paramBaseChatItemLayout.setNick(bool2, (CharSequence)localObject2, localColorStateList, bool3, bool4, false, false, "", null, (String)localObject1);
            TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
            TroopRelevantHandler.TmiCallBackForNickName localTmiCallBackForNickName = (TroopRelevantHandler.TmiCallBackForNickName)paramBaseChatItemLayout.getTag(2131364652);
            localObject2 = localTmiCallBackForNickName;
            if (localTmiCallBackForNickName == null)
            {
              localObject2 = new TroopRelevantHandler.TmiCallBackForNickName(this, null);
              paramBaseChatItemLayout.setTag(2131364652, localObject2);
            }
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_a_of_type_Boolean = bool1;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_a_of_type_AndroidContentResColorStateList = localColorStateList;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_b_of_type_Boolean = bool4;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).c = false;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_a_of_type_JavaLangCharSequence = "";
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_b_of_type_AndroidContentResColorStateList = null;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).d = false;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
            ((TroopRelevantHandler.TmiCallBackForNickName)localObject2).jdField_a_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$ViewHolder = paramViewHolder;
            localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject2);
            e(paramChatMessage, paramBaseChatItemLayout);
            return;
            i = 0;
            break;
            localObject1 = null;
            break label217;
            bool2 = false;
            break label261;
          }
          label477:
          if ((localObject2 != null) || (bool1))
          {
            bool2 = true;
            label490:
            if (((!bool1) || (!AnonymousChatHelper.b(paramChatMessage))) && (!TroopConfessUtil.c(paramChatMessage)) && (!paramChatMessage.isSend())) {
              break label609;
            }
          }
          label609:
          for (bool1 = true;; bool1 = false)
          {
            paramBaseChatItemLayout.setNick(bool2, (CharSequence)localObject2, localColorStateList, bool1, bool4, false, false, "", null, (String)localObject1);
            a(((CharSequence)localObject2).toString(), paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
            if ((!paramChatMessage.isMultiMsg) || (AnonymousChatHelper.a(paramChatMessage))) {
              break;
            }
            paramViewHolder = paramBaseChatItemLayout.a(NickNameLayoutProcessor.h);
            if (paramViewHolder == null) {
              break;
            }
            paramViewHolder.setData(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localObject2 });
            break;
            bool2 = false;
            break label490;
          }
        }
      }
      bool1 = false;
      localObject1 = null;
    }
  }
  
  private void a(String paramString, ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int i;
    int j;
    label30:
    int k;
    label65:
    int m;
    label92:
    String str;
    if (AppSetting.d)
    {
      if (paramChatMessage.istroop != 1) {
        break label185;
      }
      i = 1;
      if (paramChatMessage.istroop != 3000) {
        break label191;
      }
      j = 1;
      if ((paramChatMessage.fakeSenderType != 2) && (((paramChatMessage.istroop != 0) && (paramChatMessage.istroop != 3000)) || (!paramChatMessage.isMultiMsg))) {
        break label197;
      }
      k = 1;
      if ((!TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) && (!paramChatMessage.isSend())) {
        break label203;
      }
      m = 1;
      if ((i != 0) || (j != 0) || (k != 0))
      {
        if (i == 0) {
          break label316;
        }
        if (m == 0) {
          break label209;
        }
        str = HardCodeUtil.a(2131701024);
      }
    }
    label185:
    label191:
    label197:
    label203:
    label459:
    for (;;)
    {
      paramBaseChatItemLayout.a.setContentDescription(str);
      if ((AppSetting.d) && (paramViewHolder.b != null))
      {
        if ((TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramChatMessage.senderuin)) || (paramChatMessage.isSend())) {
          paramViewHolder.b.append("我");
        }
      }
      else
      {
        return;
        i = 0;
        break;
        j = 0;
        break label30;
        k = 0;
        break label65;
        m = 0;
        break label92;
        label209:
        if ("1000000".equals(paramChatMessage.senderuin))
        {
          if (paramChatMessage.msgtype == -3006)
          {
            str = String.format(paramBaseChatItemLayout.getResources().getString(2131697673), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
            continue;
          }
          str = HardCodeUtil.a(2131701025);
          continue;
        }
        str = paramString + HardCodeUtil.a(2131701017);
        continue;
        if (j != 0)
        {
          if (m != 0)
          {
            str = HardCodeUtil.a(2131701028);
            continue;
          }
          str = paramString + HardCodeUtil.a(2131701018);
          continue;
        }
        if (m != 0) {}
        for (str = HardCodeUtil.a(2131701028);; str = paramString + HardCodeUtil.a(2131701018))
        {
          if (paramChatMessage.msgtype != -3006) {
            break label459;
          }
          str = String.format(paramBaseChatItemLayout.getResources().getString(2131697673), new Object[] { ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.getContext()) });
          break;
        }
      }
    }
    label316:
    paramBaseChatItemLayout = paramString;
    if (paramString == null) {
      paramBaseChatItemLayout = "";
    }
    paramString = paramBaseChatItemLayout;
    if (AnonymousChatHelper.a(paramChatMessage)) {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690097) + paramBaseChatItemLayout;
    }
    paramViewHolder.b.insert(0, paramString);
  }
  
  private boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.istroop == 1) && (!AnonymousChatHelper.a(paramChatMessage));
  }
  
  private boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramChatMessage.istroop == 1)
    {
      bool = paramBoolean;
      if (((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramChatMessage.frienduin) != null) {
        bool = HotChatManager.a(paramChatMessage);
      }
    }
    return bool;
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord != null) && (paramMessageRecord.istroop == 1))
    {
      paramMessageRecord = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      TroopInfo localTroopInfo = paramMessageRecord.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      if ((localTroopInfo != null) && (localTroopInfo.isQidianPrivateTroop())) {
        return true;
      }
      if (paramMessageRecord.h(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    return (paramBoolean) && (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.frienduin, Long.parseLong(paramMessageRecord.senderuin)));
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
      if (!AnonymousChatHelper.a(paramChatMessage))
      {
        localObject = paramChatMessage.getExtInfoFromExtStr("self_nickname");
        paramCharSequence = (CharSequence)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramCharSequence = MultiMsgManager.a().a(paramChatMessage.senderuin, paramChatMessage.msgseq, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        if (paramCharSequence != null)
        {
          localObject = paramCharSequence;
          if (TextUtils.getTrimmedLength(paramCharSequence) != 0) {}
        }
        else
        {
          localObject = MultiMsgUtil.a(paramChatMessage.senderuin);
        }
        localObject = new ColorNickText((CharSequence)localObject, 13).a();
      }
    }
    return localObject;
  }
  
  private void b(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = paramBaseChatItemLayout.a(NickNameLayoutProcessor.i);
    if ((AnonymousChatHelper.a(paramChatMessage)) || ("1000000".equals(paramChatMessage.senderuin)) || ((paramChatMessage instanceof MessageForTroopConfess))) {
      if ((localObject != null) && (((NickNameExtenderViewBasicAbility)localObject).checkViewNonNull()))
      {
        ((NickNameExtenderViewBasicAbility)localObject).setViewVisibility(8);
        ((NickNameExtenderViewBasicAbility)localObject).setOnClickListener(null);
      }
    }
    label361:
    label365:
    for (;;)
    {
      return;
      if (TroopBusinessUtil.a(paramChatMessage) != null)
      {
        if ((localObject != null) && (((NickNameExtenderViewBasicAbility)localObject).checkViewNonNull()))
        {
          ((NickNameExtenderViewBasicAbility)localObject).setViewVisibility(8);
          ((NickNameExtenderViewBasicAbility)localObject).setOnClickListener(null);
        }
      }
      else if (paramChatMessage.istroop == 1)
      {
        if ((localObject != null) && (((NickNameExtenderViewBasicAbility)localObject).checkViewNonNull())) {
          ((NickNameExtenderViewBasicAbility)localObject).setViewVisibility(8);
        }
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        if (localTroopManager != null)
        {
          TroopInfo localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
          localObject = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
          if ((localTroopInfo != null) && (!((TroopRobotManager)localObject).b(paramChatMessage.senderuin)))
          {
            boolean bool = TroopMemberLevelUtils.a(paramChatMessage.frienduin);
            int i;
            if ((localTroopInfo.cGroupRankUserFlag == 1) || (localTroopInfo.cNewGroupRankUserFlag == 0))
            {
              i = 1;
              if ((i != 0) || ((!localTroopInfo.isTroopOwner(paramChatMessage.senderuin)) && (!localTroopInfo.isTroopAdmin(paramChatMessage.senderuin)))) {
                break label361;
              }
            }
            for (int j = 1;; j = 0)
            {
              if ((!bool) || ((i == 0) && (j == 0) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop()))) {
                break label365;
              }
              TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel localTmiCallBackForTroopMemberNewLevel = (TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)paramBaseChatItemLayout.getTag(2131364674);
              localObject = localTmiCallBackForTroopMemberNewLevel;
              if (localTmiCallBackForTroopMemberNewLevel == null)
              {
                localObject = new TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel(this, null);
                paramBaseChatItemLayout.setTag(2131364674, localObject);
              }
              ((TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
              ((TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
              ((TroopRelevantHandler.TmiCallBackForTroopMemberNewLevel)localObject).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
              localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject);
              return;
              i = 0;
              break;
            }
          }
        }
      }
    }
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = TroopBusinessUtil.a(paramMessageRecord);
    if (localObject != null)
    {
      TroopBusinessUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, (TroopBusinessUtil.TroopBusinessMessage)localObject);
      localObject = ((TroopBusinessUtil.TroopBusinessMessage)localObject).jdField_c_of_type_JavaLangString;
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "five_m", "clk_name", 0, 0, paramMessageRecord.frienduin, "", (String)localObject, "");
      if (paramMessageRecord.msgtype != -2051) {}
    }
    try
    {
      paramMessageRecord = (MessageForQQStory)paramMessageRecord;
      paramMessageRecord = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, paramMessageRecord.msgAction);
      QQStoryItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, "clk_name", paramMessageRecord, false);
      bool = true;
      return bool;
    }
    catch (Exception paramMessageRecord)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("Q.qqstory.share", 2, "onHeadIconClick exp:", paramMessageRecord);
        }
      }
    }
  }
  
  private void c(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (AnonymousChatHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString)))
    {
      bool = true;
      if (!bool) {
        break label777;
      }
    }
    label769:
    label771:
    label777:
    for (int i = AnonymousChatHelper.e;; i = -1)
    {
      Object localObject1 = paramBaseChatItemLayout.a(NickNameLayoutProcessor.j);
      int k;
      int j;
      if (AnonymousChatHelper.a(paramChatMessage))
      {
        k = TroopRankConfig.a().jdField_a_of_type_Int;
        paramBaseChatItemLayout = AnonymousChatHelper.a(paramChatMessage);
        j = k;
      }
      for (;;)
      {
        try
        {
          if (!TextUtils.isEmpty(paramBaseChatItemLayout.jdField_c_of_type_JavaLangString)) {
            j = Color.parseColor(paramBaseChatItemLayout.jdField_c_of_type_JavaLangString);
          }
          if ((!TroopMemberLevelUtils.a(paramChatMessage.frienduin)) || (AnonymousChatHelper.b(paramChatMessage))) {
            break label771;
          }
          bool = false;
          if ((localObject1 != null) && (((NickNameExtenderViewBasicAbility)localObject1).checkViewNonNull()))
          {
            ((NickNameExtenderViewBasicAbility)localObject1).setData(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(bool), this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690091), Boolean.valueOf(AnonymousChatHelper.b(paramChatMessage)), Integer.valueOf(j), Integer.valueOf(i) });
            ((NickNameExtenderViewBasicAbility)localObject1).setOnClickListener(null);
          }
          return;
          bool = false;
        }
        catch (Exception paramBaseChatItemLayout)
        {
          paramBaseChatItemLayout.printStackTrace();
          QLog.e("TroopRelevantHandler", 1, "handleTroopMemberLevel Exception");
          j = k;
          continue;
        }
        if ("1000000".equals(paramChatMessage.senderuin))
        {
          this.jdField_a_of_type_Boolean = false;
          if ((localObject1 != null) && (((NickNameExtenderViewBasicAbility)localObject1).checkViewNonNull())) {
            ((NickNameExtenderViewBasicAbility)localObject1).setData(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(false), null, Boolean.valueOf(false), Integer.valueOf(-1), Integer.valueOf(i) });
          }
        }
        else if ((paramChatMessage instanceof MessageForTroopConfess))
        {
          if ((localObject1 != null) && (((NickNameExtenderViewBasicAbility)localObject1).checkViewNonNull())) {
            ((NickNameExtenderViewBasicAbility)localObject1).setData(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(false), null, Boolean.valueOf(false), Integer.valueOf(-1), Integer.valueOf(i) });
          }
        }
        else
        {
          Object localObject2 = TroopBusinessUtil.a(paramChatMessage);
          if (localObject2 != null)
          {
            j = ((TroopBusinessUtil.TroopBusinessMessage)localObject2).jdField_c_of_type_Int;
            i = ((TroopBusinessUtil.TroopBusinessMessage)localObject2).jdField_d_of_type_Int;
            if (bool)
            {
              j = AnonymousChatHelper.e;
              i = TroopRankConfig.a().jdField_a_of_type_Int;
            }
            if (!TroopMemberLevelUtils.a(paramChatMessage.frienduin)) {
              break label765;
            }
          }
          label765:
          for (bool = false;; bool = true)
          {
            if ((localObject1 == null) || (!((NickNameExtenderViewBasicAbility)localObject1).checkViewNonNull())) {
              break label769;
            }
            ((NickNameExtenderViewBasicAbility)localObject1).setData(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(bool), ((TroopBusinessUtil.TroopBusinessMessage)localObject2).jdField_d_of_type_JavaLangString, Boolean.valueOf(false), Integer.valueOf(i), Integer.valueOf(j) });
            ((NickNameExtenderViewBasicAbility)localObject1).setTag(Integer.valueOf(2131364673));
            ((NickNameExtenderViewBasicAbility)localObject1).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
            return;
            if (paramChatMessage.istroop != 1) {
              break;
            }
            if ((localObject1 != null) && (((NickNameExtenderViewBasicAbility)localObject1).checkViewNonNull())) {
              ((NickNameExtenderViewBasicAbility)localObject1).setData(new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Boolean.valueOf(false), null, Boolean.valueOf(false), Integer.valueOf(-1), Integer.valueOf(i) });
            }
            this.jdField_a_of_type_Boolean = false;
            if (localTroopManager == null) {
              break;
            }
            TroopInfo localTroopInfo = localTroopManager.b(paramChatMessage.frienduin);
            localObject1 = (TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
            if ((localTroopInfo == null) || ((localTroopInfo.cGroupRankSysFlag != 1) && (!((TroopRobotManager)localObject1).b(paramChatMessage.senderuin)) && (!localTroopInfo.isQidianPrivateTroop()) && (!localTroopInfo.isHomeworkTroop()))) {
              break;
            }
            localObject2 = (TroopRelevantHandler.TmiCallBackForMemberLevel)paramBaseChatItemLayout.getTag(2131364673);
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = new TroopRelevantHandler.TmiCallBackForMemberLevel(this, null);
              paramBaseChatItemLayout.setTag(2131364673, localObject1);
            }
            ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
            ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).jdField_a_of_type_Boolean = bool;
            ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).jdField_a_of_type_Int = i;
            ((TroopRelevantHandler.TmiCallBackForMemberLevel)localObject1).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = localTroopInfo;
            localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject1);
            return;
          }
          continue;
          bool = true;
        }
      }
    }
  }
  
  private boolean c(MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    Object localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (localObject != null) {}
    for (localObject = ((HotChatManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);; localObject = null)
    {
      if (localObject != null)
      {
        if (!((HotChatInfo)localObject).isGameRoom) {
          break;
        }
        bool = true;
      }
      return bool;
    }
    if (a(paramMessageRecord, ((HotChatInfo)localObject).isRobotHotChat)) {
      return true;
    }
    localObject = paramMessageRecord.senderuin;
    paramMessageRecord = NearbyURLSafeUtil.a((String)localObject);
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject)) {}
    for (paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747" + "&strangerUin=" + paramMessageRecord;; paramMessageRecord = "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747")
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(localObject)) {}
      for (localObject = "2";; localObject = "1")
      {
        ReportController.b(null, "dc00899", "grp_lbs", "", "rank_room", "clk_name", 0, 0, (String)localObject, "", "", "");
        localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramMessageRecord);
        this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        return true;
      }
    }
  }
  
  private void d(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramChatMessage.frienduin);
    if (localObject != null)
    {
      bool = ((HotChatInfo)localObject).isGameRoom;
      if (!bool) {
        break label98;
      }
      localObject = ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a("");
      if (localObject != null)
      {
        paramChatMessage = ((WerewolvesPluginManager)localObject).a(paramChatMessage.senderuin);
        if (TextUtils.isEmpty(paramChatMessage)) {
          break label91;
        }
        paramBaseChatItemLayout.setHotChatRoomIndex(true, paramChatMessage);
      }
    }
    label91:
    label98:
    do
    {
      do
      {
        return;
        bool = false;
        break;
        paramBaseChatItemLayout.setHotChatRoomIndex(false, paramChatMessage);
        return;
        localObject = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      } while (localObject == null);
      paramChatMessage = ((TroopManager)localObject).b(paramChatMessage.frienduin, paramChatMessage.senderuin);
    } while (paramChatMessage == null);
    if (paramChatMessage.hotChatGlamourLevel >= 1) {}
    for (boolean bool = true;; bool = false)
    {
      paramBaseChatItemLayout.setHotChatGlamourLevel(bool, paramChatMessage.hotChatGlamourLevel);
      paramBaseChatItemLayout.setHotChatGlamourLevelTag(Integer.valueOf(2131364670));
      paramBaseChatItemLayout.setHotChatGlamourOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
    }
  }
  
  private void e(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    boolean bool = RobotUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.senderuin);
    paramBaseChatItemLayout.setRobotTag(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool, paramChatMessage.isSend());
    NickNameExtenderViewBasicAbility localNickNameExtenderViewBasicAbility = paramBaseChatItemLayout.a(NickNameLayoutProcessor.jdField_d_of_type_Int);
    if ((localNickNameExtenderViewBasicAbility != null) && (localNickNameExtenderViewBasicAbility.checkViewNonNull())) {
      localNickNameExtenderViewBasicAbility.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    paramBaseChatItemLayout = paramBaseChatItemLayout.a(NickNameLayoutProcessor.h);
    if ((paramBaseChatItemLayout != null) && (paramBaseChatItemLayout.checkViewNonNull()))
    {
      if (AnonymousChatHelper.a(paramChatMessage)) {
        break label127;
      }
      paramBaseChatItemLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      paramBaseChatItemLayout.setTag(Integer.valueOf(2131364651));
    }
    for (;;)
    {
      if ((AppSetting.d) && (Build.VERSION.SDK_INT >= 14)) {
        paramBaseChatItemLayout.setAccessibilityDelegate(new TroopRelevantHandler.1(this));
      }
      return;
      label127:
      paramBaseChatItemLayout.setOnClickListener(null);
    }
  }
  
  private void f(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    HotChatInfo localHotChatInfo = ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    if ((localHotChatInfo == null) || (localHotChatInfo.isGameRoom)) {
      return;
    }
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramChatMessage.senderuin)) {
      if (paramChatMessage.senderuin.equals(localHotChatInfo.ownerUin))
      {
        paramChatMessage = HardCodeUtil.a(2131701019);
        i = 0;
      }
    }
    for (;;)
    {
      paramBaseChatItemLayout.setHotChatAdmin(paramChatMessage, i);
      return;
      if ((localHotChatInfo.adminUins != null) && (localHotChatInfo.adminUins.contains(paramChatMessage.senderuin)))
      {
        paramChatMessage = HardCodeUtil.a(2131701021);
        i = 1;
      }
      else if ((localHotChatInfo.isRobotHotChat) && (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramChatMessage.senderuin)))
      {
        paramChatMessage = HardCodeUtil.a(2131701027);
        i = 0;
      }
      else
      {
        i = 0;
        paramChatMessage = null;
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, ViewGroup paramViewGroup, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    if ((paramChatMessage == null) || (paramViewGroup == null) || (paramContext == null) || (paramBaseChatItemLayout == null) || (paramViewHolder == null)) {
      return;
    }
    if (paramBundle != null)
    {
      this.jdField_b_of_type_Boolean = paramBundle.getBoolean("inChatHistory", false);
      this.c = paramBundle.getBoolean("inInMiniAIO", false);
    }
    if (TroopBindPublicAccountMgr.a(paramChatMessage)) {
      paramBaseChatItemLayout.setGrayTipsText(true, paramChatMessage, paramContext.getString(2131696411), this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165442), 0);
    }
    for (;;)
    {
      if ((paramChatMessage.fakeSenderType == 2) && (AnonymousChatHelper.a(paramChatMessage))) {
        a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
      }
      if ((paramChatMessage.fakeSenderType != 0) || (paramChatMessage.istroop != 1)) {
        break;
      }
      paramViewGroup = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((paramViewGroup == null) || (!paramViewGroup.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString))) {
        break label230;
      }
      f(paramChatMessage, paramBaseChatItemLayout);
      d(paramChatMessage, paramBaseChatItemLayout);
      a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
      a(paramChatMessage, paramBaseChatItemLayout);
      return;
      paramBaseChatItemLayout.setGrayTipsText(paramChatMessage.mNeedGrayTips, paramChatMessage, paramChatMessage.mMessageSource, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131165442), 235);
    }
    label230:
    a(paramChatMessage, paramBaseChatItemLayout, paramViewHolder);
    c(paramChatMessage, paramBaseChatItemLayout);
    a(paramChatMessage, paramBaseChatItemLayout);
    b(paramChatMessage, paramBaseChatItemLayout);
    new TroopMemGradeLevelBuilder(paramChatMessage, paramBaseChatItemLayout).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(View paramView)
  {
    if (paramView == null) {}
    label194:
    do
    {
      do
      {
        return;
        switch (paramView.getId())
        {
        default: 
          return;
        case 2131364625: 
        case 2131364670: 
          c(paramView);
          return;
        case 2131364672: 
        case 2131364673: 
          Object localObject = (ChatItemBuilder.BaseHolder)AIOUtils.a(paramView);
          String str = ((ChatItemBuilder.BaseHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin;
          localObject = ((ChatItemBuilder.BaseHolder)localObject).jdField_a_of_type_ComTencentMobileqqDataChatMessage.senderuin;
          if (!((ITroopHonorService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopHonorService.class, "")).isSupportTroopHonor(str)) {
            break label194;
          }
          str = TroopLinkManager.a().a(str, (String)localObject);
          localObject = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject).putExtra("url", str);
          paramView.getContext().startActivity((Intent)localObject);
        }
      } while (paramView.getId() != 2131364672);
      ReportController.b(null, "dc00898", "", "", "0X800A705", "0X800A705", 0, 0, "", "", "", "");
      return;
    } while (paramView.getId() != 2131364673);
    c(paramView);
    return;
    b(paramView);
  }
  
  public void a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    Object localObject = paramBaseChatItemLayout.a(NickNameLayoutProcessor.jdField_c_of_type_Int);
    if ((!TroopHonorAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage)) && (localObject != null)) {
      ((NickNameExtenderViewBasicAbility)localObject).setData(null);
    }
    TroopManager localTroopManager;
    do
    {
      do
      {
        return;
        if ((!TroopHonorAIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage.frienduin)) && (localObject != null))
        {
          ((NickNameExtenderViewBasicAbility)localObject).setData(null);
          return;
        }
      } while ((paramChatMessage.istroop != 1) || (localObject == null));
      ((NickNameExtenderViewBasicAbility)localObject).setData(null);
      localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    } while (!((ITroopHonorService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopHonorService.class, "")).isSupportTroopHonor(paramChatMessage.frienduin));
    TroopRelevantHandler.TmiCallBackForTroopHonor localTmiCallBackForTroopHonor = (TroopRelevantHandler.TmiCallBackForTroopHonor)paramBaseChatItemLayout.getTag(2131364672);
    localObject = localTmiCallBackForTroopHonor;
    if (localTmiCallBackForTroopHonor == null)
    {
      localObject = new TroopRelevantHandler.TmiCallBackForTroopHonor(this, null);
      paramBaseChatItemLayout.setTag(2131364672, localObject);
    }
    ((TroopRelevantHandler.TmiCallBackForTroopHonor)localObject).jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    ((TroopRelevantHandler.TmiCallBackForTroopHonor)localObject).jdField_a_of_type_JavaLangString = paramChatMessage.senderuin;
    localTroopManager.a(paramChatMessage.frienduin, paramChatMessage.senderuin, (TroopManager.ITroopMemberInfoCallBack)localObject);
  }
  
  protected void b(View paramView)
  {
    int i = 1;
    Object localObject2 = AIOUtils.a(paramView);
    if (a((MessageRecord)localObject2)) {}
    while ((TroopBusinessUtil.a((MessageRecord)localObject2) != null) || (localObject2 == null) || (((MessageRecord)localObject2).istroop != 1) || (!Utils.d(((MessageRecord)localObject2).senderuin))) {
      return;
    }
    Object localObject1 = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (localObject1 != null)
    {
      localObject1 = ((HotChatManager)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
      label81:
      if ((localObject1 != null) || (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, ((MessageRecord)localObject2).frienduin, Long.parseLong(((MessageRecord)localObject2).senderuin)))) {
        break label275;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("https://qun.qq.com/interactive/userhonor?gc=").append(((MessageRecord)localObject2).frienduin);
      ((StringBuilder)localObject1).append("&uin=").append(((MessageRecord)localObject2).senderuin);
      ((StringBuilder)localObject1).append("&_wv=3&&_wwv=128");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new Intent(paramView.getContext(), QQBrowserActivity.class);
      ((Intent)localObject2).putExtra("url", (String)localObject1);
      paramView.getContext().startActivity((Intent)localObject2);
      if (!(paramView instanceof TroopMemberNewLevelView)) {
        break label301;
      }
    }
    label275:
    label301:
    for (paramView = (TroopMemberNewLevelView)paramView;; paramView = null)
    {
      if (paramView != null) {
        if ((paramView.a()) && (paramView.b())) {
          i = 3;
        }
      }
      for (;;)
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B200", "0X800B200", i, 0, "", "", "", "");
        return;
        localObject1 = null;
        break label81;
        break;
        if (!paramView.a()) {
          if (paramView.b()) {
            i = 2;
          } else {
            i = 0;
          }
        }
      }
    }
  }
  
  protected void c(View paramView)
  {
    ChatMessage localChatMessage = AIOUtils.a(paramView);
    if (a(localChatMessage)) {}
    while ((b(localChatMessage)) || (localChatMessage == null) || (localChatMessage.istroop != 1) || (!Utils.d(localChatMessage.senderuin)) || (c(localChatMessage)) || (((TroopRobotManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).a(this.jdField_a_of_type_AndroidContentContext, localChatMessage.frienduin, Long.parseLong(localChatMessage.senderuin)))) {
      return;
    }
    Object localObject2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    int i;
    Object localObject1;
    label154:
    Object localObject3;
    if ((localObject2 != null) && (TroopInfo.hasPayPrivilege(((TroopInfo)localObject2).troopPrivilegeFlag, 32)))
    {
      i = paramView.getId();
      if (i == 2131364673)
      {
        localObject1 = "clk_title";
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_grade", "", "grp_aio", (String)localObject1, 0, 0, localChatMessage.frienduin, "", "", "");
        localObject3 = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localChatMessage.senderuin, ((TroopInfo)localObject2).troopuin, 1, 0);
        if (i != 2131364673) {
          break label437;
        }
        i = 2;
        localObject1 = "Clk_label";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = Base64.encodeToString(((String)localObject3).getBytes("UTF-8"), 0);
        localObject2 = a(localChatMessage, i, (String)localObject2);
        paramView = paramView.getContext();
        localObject3 = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject3).putExtra("url", (String)localObject2);
        ((Intent)localObject3).putExtra("selfSet_leftViewText", HardCodeUtil.a(2131701020));
        paramView.startActivity((Intent)localObject3);
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        String str = localChatMessage.frienduin;
        if (localChatMessage.isSend())
        {
          paramView = "1";
          ReportController.b((AppRuntime)localObject3, "dc00899", "Grp_msg", "", "AIO", (String)localObject1, 0, 0, str, paramView, "", "");
          if (QLog.isColorLevel()) {
            QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:" + (String)localObject2);
          }
          if (this.jdField_a_of_type_Int < 2) {
            break;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_flower", "", "charm", "Clk_name", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, String.valueOf(this.jdField_a_of_type_Int), "", "");
          return;
          localObject1 = "clk_nickname";
          break label154;
          label437:
          i = 1;
          localObject1 = "Clk_name";
          continue;
        }
      }
      catch (Exception localException)
      {
        localObject2 = localObject3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("BaseBubbleBuilder", 2, "onTroopMemberLevelClick:", localException);
        localObject2 = localObject3;
        continue;
        paramView = "0";
        continue;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseBubbleBuilder", 2, "onTroopMemberLevelClick, openLevelPKPage");
        }
        localObject1 = new Intent(paramView.getContext(), QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", "https://qinfo.clt.qq.com/qlevel/faq.html?_bid=125#gc=" + localChatMessage.frienduin + "&target=" + localChatMessage.senderuin);
        ((Intent)localObject1).putExtra("hide_operation_bar", true);
        ((Intent)localObject1).putExtra("hide_more_button", true);
        paramView.getContext().startActivity((Intent)localObject1);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_rank", "", "AIOchat", "Clk_level", 0, 0, localChatMessage.frienduin, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.TroopRelevantHandler
 * JD-Core Version:    0.7.0.1
 */