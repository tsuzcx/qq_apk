package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.troop.TroopStoryUtil;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCAccountNames;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils.ShortVideoPlayConfig;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.AIOSingleReporter;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class TroopStoryItemBuilder
  extends QQStoryItemBuilder
{
  public TroopStoryItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    MessageForTroopStory localMessageForTroopStory = (MessageForTroopStory)paramChatMessage;
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    case 2131365636: 
      ChatActivityFacade.b(this.jdField_b_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("Q.qqstory.troopstory.share", 2, "start forward from aio");
    }
    paramContext = new Bundle();
    TroopStoryUtil.a(localMessageForTroopStory, paramContext);
    paramContext.putInt("selection_mode", this.jdField_b_of_type_Int);
    paramContext.putInt("forward_source_uin_type", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    paramChatMessage = new Intent();
    paramChatMessage.putExtras(paramContext);
    ForwardBaseOption.a((Activity)this.jdField_b_of_type_AndroidContentContext, paramChatMessage, 21);
  }
  
  public void a(View paramView)
  {
    paramView = (MessageForTroopStory)((QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.a(paramView)).jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!paramView.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.jdField_b_of_type_AndroidContentContext, null);
    localActionSheet.addButton(2131690018, 5);
    localActionSheet.addCancelButton(2131690800);
    localActionSheet.setOnButtonClickListener(new TroopStoryItemBuilder.1(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopStory)paramChatMessage;
    paramChatMessage.parse();
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)paramViewGroup.getTag();
    boolean bool = paramChatMessage.isSend();
    if (TextUtils.isEmpty(paramChatMessage.sourceName))
    {
      if (localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout != null) {
        localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      }
      localQQStoryMsgHolder.b.setVisibility(8);
      if ((!TextUtils.isEmpty(paramChatMessage.storyId)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO)) {
        break label233;
      }
      localQQStoryMsgHolder.jdField_a_of_type_Boolean = false;
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setDrawStatus(2);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetAutoStartProgressBar.setVisibility(0);
      a(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    }
    label233:
    do
    {
      return;
      if (localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout == null) {
        a(localQQStoryMsgHolder, paramViewGroup, bool);
      }
      paramViewGroup = (FrameLayout.LayoutParams)localQQStoryMsgHolder.c.getLayoutParams();
      if (bool) {}
      for (paramViewGroup.leftMargin = BaseChatItemLayout.k;; paramViewGroup.leftMargin = (DisplayUtil.a(this.jdField_b_of_type_AndroidContentContext, localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.a) + BaseChatItemLayout.j))
      {
        localQQStoryMsgHolder.c.setLayoutParams(paramViewGroup);
        localQQStoryMsgHolder.c.setText(paramChatMessage.sourceName);
        localQQStoryMsgHolder.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
        break;
      }
      paramViewGroup = (Long)localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.getTag();
    } while ((paramViewGroup != null) && (paramViewGroup.longValue() == paramChatMessage.uniseq));
    localQQStoryMsgHolder.jdField_a_of_type_Boolean = false;
    localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable(null);
    a(localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView, paramChatMessage.thumbUrl, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(localQQStoryMsgHolder, paramChatMessage.thumbUrl, paramChatMessage.storyId, paramChatMessage.uniseq, false);
    localQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView.setTag(Long.valueOf(paramChatMessage.uniseq));
  }
  
  protected void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    if ((paramQQStoryMsgHolder != null) && ((paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)))
    {
      localObject = (MessageForTroopStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (!TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId)) {
        break label33;
      }
    }
    label33:
    do
    {
      return;
      if ((!paramQQStoryMsgHolder.jdField_a_of_type_Boolean) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
      {
        a(paramQQStoryMsgHolder, ((MessageForTroopStory)localObject).thumbUrl, ((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).uniseq, true);
        return;
      }
    } while (UIUtils.b());
    if (((MessageForTroopStory)localObject).istroop == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.troopstory", 2, "openTroopStoryVideo, enter=" + ((MessageForTroopStory)localObject).storyId);
      }
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1003).a();
      ((OpenPlayerBuilder.Data)localObject).mUIStyle.mPlayerRepeatMode = 2;
      StoryPlayerLauncher.a(this.jdField_b_of_type_AndroidContentContext, (OpenPlayerBuilder.Data)localObject, paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
      return;
    }
    Object localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1007);
    StoryPlayerLauncher.a(this.jdField_b_of_type_AndroidContentContext, ((OpenPlayerBuilder)localObject).a(), paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqActivityAioItemQQStoryItemBuilder$StoryChatVideoView);
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramQQStoryMsgHolder, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if ((paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.istroop == 1) && ((paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForTroopStory)) && (!AIOSingleReporter.a().a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj")))
    {
      AIOSingleReporter.a().a(paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage, "aio_msg|play_msg_obj");
      StoryReportor.a("aio_msg", "play_msg_obj", 0, 0, new String[] { "", "", "", ((MessageForTroopStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage).storyId });
    }
  }
  
  public boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForTroopStory)) && (TextUtils.isEmpty(((MessageForTroopStory)paramChatMessage).storyId)) && (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramChatMessage))) {
      return true;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.a(paramView);
    boolean bool = "1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.shortvideo_forward_switch.name(), "1"));
    paramView = (MessageForTroopStory)paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    if (!TextUtils.isEmpty(paramView.storyId))
    {
      if (bool) {
        localQQCustomMenu.a(2131367398, this.jdField_b_of_type_AndroidContentContext.getString(2131692687), 2130839059);
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache().b(paramView)) {
        a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131371954, paramView, new Bundle());
      }
    }
    a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131365636, paramView, new Bundle());
    super.a(localQQCustomMenu, this.jdField_b_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
  
  protected void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    try
    {
      paramQQStoryMsgHolder = (MessageForTroopStory)paramQQStoryMsgHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.share", 2, "storyMsg onSourceOnClick:" + paramQQStoryMsgHolder.toString() + ", sourceType = " + paramQQStoryMsgHolder.sourceActionData + ", sourceActionData = " + paramQQStoryMsgHolder.sourceActionData);
      }
      if ("plugin".equals(paramQQStoryMsgHolder.sourceActionType))
      {
        paramQQStoryMsgHolder = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_AndroidContentContext, paramQQStoryMsgHolder.sourceActionData);
        if (paramQQStoryMsgHolder != null) {
          paramQQStoryMsgHolder.a();
        }
      }
      return;
    }
    catch (Exception paramQQStoryMsgHolder)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("Q.qqstory.share", 2, "storyMsg onSourceOnClick exp:", paramQQStoryMsgHolder);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */