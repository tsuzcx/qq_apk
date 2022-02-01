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
    if (paramInt != 2131431695)
    {
      if (paramInt != 2131433636)
      {
        super.a(paramInt, paramContext, paramChatMessage);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.troopstory.share", 2, "start forward from aio");
      }
      paramContext = new Bundle();
      TroopStoryUtil.a(localMessageForTroopStory, paramContext);
      paramContext.putInt("selection_mode", this.u);
      paramContext.putInt("forward_source_uin_type", this.f.a);
      paramChatMessage = new Intent();
      paramChatMessage.putExtras(paramContext);
      ForwardBaseOption.a((Activity)this.a, paramChatMessage, 21);
      return;
    }
    ChatActivityFacade.b(this.a, this.d, paramChatMessage);
  }
  
  protected void a(ViewGroup paramViewGroup, ChatMessage paramChatMessage)
  {
    paramChatMessage = (MessageForTroopStory)paramChatMessage;
    paramChatMessage.parse();
    QQStoryItemBuilder.QQStoryMsgHolder localQQStoryMsgHolder = (QQStoryItemBuilder.QQStoryMsgHolder)paramViewGroup.getTag();
    boolean bool = paramChatMessage.isSend();
    if (TextUtils.isEmpty(paramChatMessage.sourceName))
    {
      if (localQQStoryMsgHolder.u != null) {
        localQQStoryMsgHolder.u.setVisibility(8);
      }
    }
    else
    {
      if (localQQStoryMsgHolder.u == null) {
        a(localQQStoryMsgHolder, paramViewGroup, bool);
      }
      paramViewGroup = (FrameLayout.LayoutParams)localQQStoryMsgHolder.v.getLayoutParams();
      if (bool) {
        paramViewGroup.leftMargin = BaseChatItemLayout.getBubblePaddingAlignError();
      } else {
        paramViewGroup.leftMargin = (DisplayUtil.a(this.a, localQQStoryMsgHolder.c.f) + BaseChatItemLayout.getBubblePaddingAlignHead());
      }
      localQQStoryMsgHolder.v.setLayoutParams(paramViewGroup);
      localQQStoryMsgHolder.v.setText(paramChatMessage.sourceName);
      localQQStoryMsgHolder.u.setVisibility(0);
    }
    localQQStoryMsgHolder.t.setVisibility(8);
    if ((!TextUtils.isEmpty(paramChatMessage.storyId)) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
    {
      paramViewGroup = (Long)localQQStoryMsgHolder.c.getTag();
      if ((paramViewGroup == null) || (paramViewGroup.longValue() != paramChatMessage.uniseq))
      {
        localQQStoryMsgHolder.C = false;
        localQQStoryMsgHolder.d.setImageDrawable(null);
        a(localQQStoryMsgHolder.c, paramChatMessage.thumbUrl, this.z, this.A, this.x);
        a(localQQStoryMsgHolder, paramChatMessage.thumbUrl, paramChatMessage.storyId, paramChatMessage.uniseq, false);
        localQQStoryMsgHolder.c.setTag(Long.valueOf(paramChatMessage.uniseq));
      }
    }
    else
    {
      localQQStoryMsgHolder.C = false;
      localQQStoryMsgHolder.x.setDrawStatus(2);
      localQQStoryMsgHolder.x.setVisibility(0);
      a(localQQStoryMsgHolder.c, paramChatMessage.thumbUrl, this.z, this.A, this.x);
      localQQStoryMsgHolder.d.setImageDrawable(null);
    }
  }
  
  protected void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    if ((paramQQStoryMsgHolder != null) && ((paramQQStoryMsgHolder.q instanceof MessageForTroopStory)))
    {
      Object localObject = (MessageForTroopStory)paramQQStoryMsgHolder.q;
      if (TextUtils.isEmpty(((MessageForTroopStory)localObject).storyId)) {
        return;
      }
      if ((!paramQQStoryMsgHolder.C) && (ShortVideoUtils.ShortVideoPlayConfig.sAutoPlayInAIO))
      {
        a(paramQQStoryMsgHolder, ((MessageForTroopStory)localObject).thumbUrl, ((MessageForTroopStory)localObject).storyId, ((MessageForTroopStory)localObject).uniseq, true);
        return;
      }
      if (UIUtils.d()) {
        return;
      }
      if (((MessageForTroopStory)localObject).istroop == 1)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("openTroopStoryVideo, enter=");
          localStringBuilder.append(((MessageForTroopStory)localObject).storyId);
          QLog.d("Q.qqstory.troopstory", 2, localStringBuilder.toString());
        }
        localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1003).f();
        ((OpenPlayerBuilder.Data)localObject).mUIStyle.mPlayerRepeatMode = 2;
        StoryPlayerLauncher.a(this.a, (OpenPlayerBuilder.Data)localObject, paramQQStoryMsgHolder.c);
        return;
      }
      localObject = new OpenPlayerBuilder(new VidListPlayInfo(((MessageForTroopStory)localObject).storyId), 1007);
      StoryPlayerLauncher.a(this.a, ((OpenPlayerBuilder)localObject).f(), paramQQStoryMsgHolder.c);
    }
  }
  
  public void a(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder, long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    b(paramQQStoryMsgHolder, paramLong, paramInt1, paramInt2, paramString1, paramString2);
    if ((paramQQStoryMsgHolder.q.istroop == 1) && ((paramQQStoryMsgHolder.q instanceof MessageForTroopStory)) && (!AIOSingleReporter.a().a(paramQQStoryMsgHolder.q, "aio_msg|play_msg_obj")))
    {
      AIOSingleReporter.a().b(paramQQStoryMsgHolder.q, "aio_msg|play_msg_obj");
      StoryReportor.a("aio_msg", "play_msg_obj", 0, 0, new String[] { "", "", "", ((MessageForTroopStory)paramQQStoryMsgHolder.q).storyId });
    }
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    if (((paramChatMessage instanceof MessageForTroopStory)) && (TextUtils.isEmpty(((MessageForTroopStory)paramChatMessage).storyId)) && (!this.d.getMsgCache().f(paramChatMessage))) {
      return true;
    }
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    paramView = (QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.b(paramView);
    boolean bool = "1".equals(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCAccountNames.shortvideo_forward_switch.name(), "1"));
    paramView = (MessageForTroopStory)paramView.q;
    if (!TextUtils.isEmpty(paramView.storyId))
    {
      if (bool) {
        localQQCustomMenu.a(2131433636, this.a.getString(2131889668), 2130839066);
      }
      if (!this.d.getMsgCache().f(paramView)) {
        a(localQQCustomMenu, this.a, 2131438943, paramView, new Bundle());
      }
    }
    a(localQQCustomMenu, this.a, 2131431695, paramView, new Bundle());
    super.a(localQQCustomMenu, this.a, 2131428089, null, null);
    return localQQCustomMenu.d();
  }
  
  protected void b(View paramView)
  {
    paramView = (MessageForTroopStory)((QQStoryItemBuilder.QQStoryMsgHolder)AIOUtils.b(paramView)).q;
    if (!paramView.isSendFromLocal()) {
      return;
    }
    ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.b(this.a, null);
    localActionSheet.addButton(2131886574, 5);
    localActionSheet.addCancelButton(2131887648);
    localActionSheet.setOnButtonClickListener(new TroopStoryItemBuilder.1(this, paramView, localActionSheet));
    localActionSheet.show();
  }
  
  protected void b(QQStoryItemBuilder.QQStoryMsgHolder paramQQStoryMsgHolder)
  {
    try
    {
      paramQQStoryMsgHolder = (MessageForTroopStory)paramQQStoryMsgHolder.q;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("storyMsg onSourceOnClick:");
        localStringBuilder.append(paramQQStoryMsgHolder.toString());
        localStringBuilder.append(", sourceType = ");
        localStringBuilder.append(paramQQStoryMsgHolder.sourceActionData);
        localStringBuilder.append(", sourceActionData = ");
        localStringBuilder.append(paramQQStoryMsgHolder.sourceActionData);
        QLog.d("Q.qqstory.share", 2, localStringBuilder.toString());
      }
      if ("plugin".equals(paramQQStoryMsgHolder.sourceActionType))
      {
        paramQQStoryMsgHolder = JumpParser.a(this.d, this.a, paramQQStoryMsgHolder.sourceActionData);
        if (paramQQStoryMsgHolder != null)
        {
          paramQQStoryMsgHolder.a();
          return;
        }
      }
    }
    catch (Exception paramQQStoryMsgHolder)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.qqstory.share", 2, "storyMsg onSourceOnClick exp:", paramQQStoryMsgHolder);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopStoryItemBuilder
 * JD-Core Version:    0.7.0.1
 */