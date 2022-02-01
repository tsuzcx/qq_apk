package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameExtenderViewBasicAbility;
import com.tencent.mobileqq.activity.aio.coreui.msglist.basechatItemlayout.NickNameLayoutProcessor;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder.Holder;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.ApolloGameArkHandler;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.api.aio.item.IApolloGameItemBuilder;
import com.tencent.mobileqq.apollo.api.model.ApolloMessage;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.lightGame.CmGameSessionUtil;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.view.ApolloMessageProgressView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class ApolloGameItemBuilder
  extends ArkAppItemBubbleBuilder
  implements IApolloGameItemBuilder
{
  protected View.OnClickListener a;
  private ApolloGameArkHandler jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private long c;
  private boolean f = true;
  
  public ApolloGameItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ApolloGameItemBuilder.1(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler = ((ApolloGameManager)paramQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a();
    CmGameUtil.a(paramQQAppInterface);
  }
  
  protected static void a(ApolloGameItemBuilder.GameHolder paramGameHolder, int paramInt)
  {
    if (paramInt < 100)
    {
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setDrawStatus(1);
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setAnimProgress(paramInt, paramGameHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramGameHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
      return;
    }
    paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setAnimProgress(paramInt, paramGameHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin + paramGameHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq);
  }
  
  private void a(ApolloGameItemBuilder.GameHolder paramGameHolder, MessageForApollo paramMessageForApollo, View paramView)
  {
    if (paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView == null)
    {
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView = new ApolloMessageProgressView(this.jdField_a_of_type_AndroidContentContext);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.a(242.66667F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(173.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(13);
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setRadius(15.0F, true);
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setShowCorner(false);
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setSharpCornerCor(BubbleImageView.a);
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setCornerDirection(false);
      ((RelativeLayout)paramView).addView(paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView, localLayoutParams);
    }
    paramMessageForApollo = ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(paramMessageForApollo.gameId);
    if ((paramMessageForApollo != null) && (paramMessageForApollo.uniseq == paramGameHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq))
    {
      paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
      return;
    }
    paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(4);
  }
  
  public static void a(ApolloGameItemBuilder.GameHolder paramGameHolder, MessageForApollo paramMessageForApollo, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if ((paramGameHolder == null) || (paramQQAppInterface == null) || (paramMessageForApollo == null)) {}
    for (;;)
    {
      return;
      if (paramMessageForApollo.uniseq == paramGameHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq)
      {
        paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(0);
        a(paramGameHolder, paramInt2);
        if (paramInt2 == 100) {
          paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ApolloGameItemBuilder", 2, new Object[] { "gameId = ", Integer.valueOf(paramInt1), ":", Integer.valueOf(paramInt2) });
        return;
        paramGameHolder.jdField_a_of_type_ComTencentMobileqqApolloViewApolloMessageProgressView.setVisibility(8);
      }
    }
  }
  
  private void a(MessageForApollo paramMessageForApollo, View paramView)
  {
    if ((paramMessageForApollo == null) || (paramView == null)) {}
    while (TextUtils.isEmpty(ApolloUtilImpl.getRobotOpenId(paramMessageForApollo))) {
      return;
    }
    c(paramView);
  }
  
  private void b(MessageForApollo paramMessageForApollo)
  {
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1036)
    {
      localObject = ApolloUtilImpl.getRobotOpenId(paramMessageForApollo);
      if ((NetConnInfoCenter.getServerTimeMillis() / 1000L < paramMessageForApollo.time + 60L) && (paramMessageForApollo.gameStatus == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP start robot game");
        CmGameStartChecker.StartCheckParam localStartCheckParam = new CmGameStartChecker.StartCheckParam(paramMessageForApollo.gameId, true, "message", paramMessageForApollo.roomId, 7, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 318001, paramMessageForApollo.gameName);
        localStartCheckParam.extendJson = paramMessageForApollo.extendJson;
        localStartCheckParam.disableMinGame = true;
        localStartCheckParam.mRobotOpenId = ((String)localObject);
        localStartCheckParam.mTempAIOUin = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
        localStartCheckParam.mTempAIONickName = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d;
        ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, localStartCheckParam);
        CmGameSessionUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, paramMessageForApollo.gameId, paramMessageForApollo.roomId);
        return;
      }
      QLog.i("ApolloGameItemBuilder", 1, "UIN_TYPE_CMGAME_TEMP onClickGameView but dispatch to ark");
      return;
    }
    int i;
    if (paramMessageForApollo.msgType == 4)
    {
      i = 201;
      int j = paramMessageForApollo.mGameMode;
      localObject = new CmGameStartChecker.StartCheckParam(paramMessageForApollo.gameId, paramMessageForApollo.isSend(), "message", paramMessageForApollo.roomId, 1, j, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, i, paramMessageForApollo.gameName);
      if (paramMessageForApollo.msgType != 4) {
        break label362;
      }
      ((CmGameStartChecker.StartCheckParam)localObject).launchNewGame = true;
    }
    for (;;)
    {
      ((CmGameStartChecker.StartCheckParam)localObject).mSendMsgUin = paramMessageForApollo.senderuin;
      ((CmGameStartChecker.StartCheckParam)localObject).msgGameStatus = paramMessageForApollo.gameStatus;
      ((CmGameStartChecker.StartCheckParam)localObject).extendJson = paramMessageForApollo.gameExtendJson;
      ApolloGameUtil.a(this.jdField_a_of_type_AndroidContentContext, (CmGameStartChecker.StartCheckParam)localObject);
      return;
      i = 200;
      break;
      label362:
      ((CmGameStartChecker.StartCheckParam)localObject).showAlertTips = true;
    }
  }
  
  private void c(View paramView)
  {
    if ((paramView instanceof ViewGroup))
    {
      int k = ((ViewGroup)paramView).getChildCount();
      int i = 0;
      while (i < k)
      {
        View localView1 = ((ViewGroup)paramView).getChildAt(i);
        if ((localView1 instanceof ViewGroup))
        {
          int m = ((ViewGroup)localView1).getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView2 = ((ViewGroup)localView1).getChildAt(j);
            if ((localView2 instanceof ArkAppView))
            {
              localView2.setOnTouchListener(null);
              localView2.setClickable(false);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 2;
  }
  
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramChatMessage = (BaseChatItemLayout)super.a(paramInt1, paramInt2, paramChatMessage, paramView, paramViewGroup, paramOnLongClickAndTouchListener);
    if (!(paramChatMessage.getTag() instanceof ApolloGameItemBuilder.GameHolder))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getView], NOT GameHolder.");
      return paramChatMessage;
    }
    paramView = (ApolloGameItemBuilder.GameHolder)paramChatMessage.getTag();
    paramViewGroup = (RelativeLayout.LayoutParams)paramView.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramOnLongClickAndTouchListener = paramChatMessage.a(NickNameLayoutProcessor.h);
    if (paramOnLongClickAndTouchListener != null)
    {
      if ((!paramOnLongClickAndTouchListener.checkViewNonNull()) || (paramOnLongClickAndTouchListener.getViewVisibility() != 0)) {
        break label119;
      }
      paramViewGroup.addRule(3, 2131364652);
    }
    for (paramViewGroup.topMargin = BaseChatItemLayout.h;; paramViewGroup.topMargin = 0)
    {
      paramView.jdField_a_of_type_AndroidViewView.setLayoutParams(paramViewGroup);
      return paramChatMessage;
      label119:
      paramViewGroup.addRule(6, 2131364643);
    }
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if ((paramChatMessage == null) || (paramViewHolder == null) || (paramBaseChatItemLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler == null)) {
      return paramView;
    }
    if (!(paramViewHolder instanceof ApolloGameItemBuilder.GameHolder))
    {
      QLog.w("ApolloGameItemBuilder", 1, "[getBubbleView], NOT GameHolder.");
      return paramView;
    }
    paramChatMessage = (MessageForApollo)paramChatMessage;
    paramViewHolder = (ApolloGameItemBuilder.GameHolder)paramViewHolder;
    MessageForArkApp localMessageForArkApp = this.jdField_a_of_type_ComTencentMobileqqApolloApolloGameArkHandler.a(paramChatMessage, paramChatMessage.mApolloGameArkMsg);
    if (localMessageForArkApp.arkContainer == null) {
      localMessageForArkApp.arkContainer = new ArkAioContainerWrapper();
    }
    localMessageForArkApp.arkContainer.a(true);
    paramChatMessage.mApolloGameArkMsg = localMessageForArkApp;
    paramView = super.a(localMessageForArkApp, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    a(paramViewHolder, paramChatMessage, paramView);
    paramViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    a(paramChatMessage, paramView);
    return paramView;
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new ApolloGameItemBuilder.GameHolder();
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    return HardCodeUtil.a(2131700455) + paramChatMessage.msg;
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloGameItemBuilder", 2, "this:" + this + ", destroy(),apollo check game dialog dismiss");
    }
  }
  
  public void a(View paramView)
  {
    paramView = (ArkAppItemBubbleBuilder.Holder)AIOUtils.a(paramView);
    try
    {
      if (paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
      {
        QLog.w("ApolloGameItemBuilder", 1, "onErrorIconClick err code: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode + ", extraflag: " + paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.extraflag);
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
        if ((paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage.sendFailCode != 0) || (super.a(paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramView.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout)))
        {
          localActionSheet.addButton(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690126), 1);
          localActionSheet.addCancelButton(2131690800);
          localActionSheet.setOnButtonClickListener(new ApolloGameItemBuilder.2(this, paramView, localActionSheet));
          localActionSheet.show();
        }
      }
      return;
    }
    catch (Throwable paramView)
    {
      QLog.e("ApolloGameItemBuilder", 1, paramView, new Object[0]);
    }
  }
  
  public void a(MessageForApollo paramMessageForApollo)
  {
    if ((paramMessageForApollo != null) && (!paramMessageForApollo.hasPlayed)) {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).setReaded(paramMessageForApollo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    }
  }
  
  public void a(ChatMessage paramChatMessage, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, BaseBubbleBuilder.ViewHolder paramViewHolder, int paramInt1, int paramInt2)
  {
    super.a(paramChatMessage, paramContext, paramBaseChatItemLayout, paramViewHolder, paramInt1, paramInt2);
    if (!(paramViewHolder instanceof ApolloGameItemBuilder.GameHolder)) {
      QLog.w("ApolloGameItemBuilder", 1, "[handleBubbleBg], NOT GameHolder.");
    }
    do
    {
      return;
      paramChatMessage = (ApolloGameItemBuilder.GameHolder)paramViewHolder;
    } while (paramChatMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView == null);
    paramChatMessage.jdField_a_of_type_AndroidViewView.setBackgroundResource(0);
    paramChatMessage.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return BaseChatItemLayout.a;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = AIOUtils.a(paramView);
    if (ApolloGameUtil.a(paramView))
    {
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
      return localQQCustomMenu.a();
    }
    if ((paramView instanceof MessageForApollo))
    {
      MessageForApollo localMessageForApollo = (MessageForApollo)paramView;
      if ((paramView != null) && (paramView.extraflag != 32768) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView))) {
        a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
      }
      a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
      if (localMessageForApollo.mApolloMessage != null) {
        VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "long_press_msg", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { Integer.toString(localMessageForApollo.mApolloMessage.id) });
      }
    }
    a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloGameItemBuilder
 * JD-Core Version:    0.7.0.1
 */