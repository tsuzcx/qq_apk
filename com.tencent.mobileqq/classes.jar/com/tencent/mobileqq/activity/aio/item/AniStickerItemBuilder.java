package com.tencent.mobileqq.activity.aio.item;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.emoticon.IAniStickerAIOOperation;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticon.api.IAniStickerUtils;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerAnimationListener;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerHelper.Builder;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.MobileQQ;

public class AniStickerItemBuilder
  extends BaseBubbleBuilder
{
  protected HashMap<Integer, IAniStickerAIOOperation> a = new HashMap();
  protected long w = 0L;
  protected int x;
  
  static {}
  
  public AniStickerItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    int i;
    if (QQTheme.isNowThemeIsNight()) {
      i = 2130852724;
    } else {
      i = 2130852735;
    }
    this.x = i;
  }
  
  private void a(QQAppInterface paramQQAppInterface, MessageForAniSticker paramMessageForAniSticker, int paramInt1, int paramInt2)
  {
    if (paramMessageForAniSticker != null)
    {
      if (paramQQAppInterface == null) {
        return;
      }
      int i = 0;
      if (paramMessageForAniSticker.isMsgRead != paramInt1)
      {
        paramMessageForAniSticker.isMsgRead = paramInt1;
        i = 1;
      }
      if (paramMessageForAniSticker.isMsgPlay != paramInt2)
      {
        paramMessageForAniSticker.isMsgPlay = paramInt2;
        i = 1;
      }
      if (i != 0)
      {
        paramMessageForAniSticker.msgData = paramMessageForAniSticker.serializeMsgData();
        paramQQAppInterface.getMessageFacade().a(this.f.b, this.f.a, paramMessageForAniSticker.uniseq, paramMessageForAniSticker.msgData);
      }
    }
  }
  
  private void a(ChatMessage paramChatMessage, AniStickerItemBuilder.AniStickerHolder paramAniStickerHolder, View paramView)
  {
    if ((v) && (paramView != null))
    {
      if ((a(paramChatMessage, paramAniStickerHolder.j)) && (paramAniStickerHolder.j.ah != null)) {
        paramAniStickerHolder.j.ah.setContentDescription(HardCodeUtil.a(2131904384));
      }
      if (!TextUtils.isEmpty(paramAniStickerHolder.r)) {
        paramAniStickerHolder.r.setLength(0);
      }
      paramView.setContentDescription(d(paramChatMessage));
    }
  }
  
  private void a(MessageForAniSticker paramMessageForAniSticker)
  {
    if (this.f.a != 1) {
      return;
    }
    long l = this.f.b().getLong("key_troop_last_read_seq", 0L);
    if (paramMessageForAniSticker.shmsgseq <= l) {
      paramMessageForAniSticker.setIsMsgRead(1);
    }
  }
  
  private void a(MessageForAniSticker paramMessageForAniSticker, int paramInt)
  {
    if ((paramMessageForAniSticker != null) && (paramMessageForAniSticker.isAniStickerRandom()) && (!TextUtils.isEmpty(paramMessageForAniSticker.surpriseId)))
    {
      Object localObject2 = (ViewGroup)((ViewGroup)((Activity)this.e).getWindow().getDecorView()).getChildAt(0).findViewById(2131427887);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MessageForAniSticker", 2, "playSurpriseAniSticker when afrootView==null");
        }
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      Object localObject1 = new AniStickerLottieView(this.e);
      ((AniStickerLottieView)localObject1).setLayoutParams(localLayoutParams);
      ((ViewGroup)localObject2).addView((View)localObject1);
      localObject2 = new AniStickerItemBuilder.5(this, (AniStickerLottieView)localObject1);
      localObject1 = new AniStickerHelper.Builder((AniStickerLottieView)localObject1).localId(paramInt).surpriseId(paramMessageForAniSticker.surpriseId).listener((AniStickerAnimationListener)localObject2).build();
      a(this.d, paramMessageForAniSticker, 1, 3);
      AniStickerHelper.setAniStickerRandomSurpriseResource((AniStickerHelper.Builder)localObject1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MessageForAniSticker", 2, "playSurpriseAniSticker when surpriseId Empty");
    }
  }
  
  private void a(MessageForAniSticker paramMessageForAniSticker, AniStickerLottieView paramAniStickerLottieView)
  {
    if ((paramAniStickerLottieView != null) && (paramMessageForAniSticker.isAniStickerRandom()))
    {
      if (TextUtils.isEmpty(paramMessageForAniSticker.resultId)) {
        return;
      }
      AniStickerItemBuilder.4 local4 = new AniStickerItemBuilder.4(this, paramMessageForAniSticker);
      AniStickerHelper.setAniStickerRandomResultResource(new AniStickerHelper.Builder(paramAniStickerLottieView).resultId(paramMessageForAniSticker.resultId).listener(local4).build());
    }
  }
  
  private void a(MessageForAniSticker paramMessageForAniSticker, AniStickerLottieView paramAniStickerLottieView, int paramInt)
  {
    if ((paramMessageForAniSticker != null) && (paramAniStickerLottieView != null))
    {
      if (!paramMessageForAniSticker.isAniStickerRandom()) {
        return;
      }
      a(paramMessageForAniSticker);
      int i;
      if ((paramMessageForAniSticker.isSendFromLocal()) && (paramMessageForAniSticker.isMsgPlay == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if ((paramMessageForAniSticker.isMsgReadState()) && (i == 0) && (!TextUtils.isEmpty(paramMessageForAniSticker.resultId)))
      {
        paramAniStickerLottieView = new AniStickerHelper.Builder(paramAniStickerLottieView).localId(paramInt).placeholderDrawable(this.x).resultId(paramMessageForAniSticker.resultId).build();
        a(this.d, paramMessageForAniSticker, 1, 2);
        AniStickerHelper.setAniStickerRandomLastFrameResource(paramAniStickerLottieView);
        return;
      }
      if ((paramMessageForAniSticker.isMsgReadState()) && (TextUtils.isEmpty(paramMessageForAniSticker.resultId)) && (QLog.isColorLevel()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("MessageForAniSticker(");
        ((StringBuilder)localObject).append(paramMessageForAniSticker.uniseq);
        ((StringBuilder)localObject).append(")");
        localObject = ((StringBuilder)localObject).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" isRead but resultId isEmpty");
        QLog.d("MessageForAniSticker", 2, localStringBuilder.toString());
      }
      Object localObject = new AniStickerItemBuilder.3(this);
      localObject = new AniStickerHelper.Builder(paramAniStickerLottieView).localId(paramInt).placeholderDrawable(this.x).listener((AniStickerAnimationListener)localObject);
      a(this.d, paramMessageForAniSticker, 1, 1);
      AniStickerHelper.setAniStickerRandomResource((AniStickerHelper.Builder)localObject);
      a(paramMessageForAniSticker, paramAniStickerLottieView);
    }
  }
  
  private void f(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    MessageForAniSticker localMessageForAniSticker = (MessageForAniSticker)paramChatMessage;
    AniStickerItemBuilder.AniStickerHolder localAniStickerHolder = (AniStickerItemBuilder.AniStickerHolder)paramViewHolder;
    if ((paramView != null) && (paramView.getTag() == paramChatMessage))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AniStickerItemBuilder", 2, "convertView#getTag == viewHolder");
      }
      return paramView;
    }
    paramBaseChatItemLayout.setProgressVisable(false);
    if (paramView == null)
    {
      paramViewHolder = new FrameLayout(this.e);
      paramViewHolder.setId(2131428372);
      paramView = new AniStickerLottieView(paramBaseChatItemLayout.getContext());
      paramView.setId(2131428371);
      paramView.setOnClickListener(this);
      paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
      paramViewHolder.addView(paramView, new ViewGroup.LayoutParams(-2, -2));
      localAniStickerHolder.a = paramView;
    }
    else
    {
      paramViewHolder = paramView;
    }
    paramViewHolder.setTag(localMessageForAniSticker);
    paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
    int i = AniStickerHelper.LOTTIE_ANIM_SIZE;
    paramView = new FrameLayout.LayoutParams(i, i);
    localAniStickerHolder.a.setLayoutParams(paramView);
    localAniStickerHolder.q = localMessageForAniSticker;
    localAniStickerHolder.k = 2;
    i = QQSysFaceUtil.convertToLocal(localMessageForAniSticker.sevrId);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getBubbleView:");
      paramView.append(localMessageForAniSticker.toString());
      QLog.d("MessageForAniSticker", 2, paramView.toString());
    }
    if (localMessageForAniSticker.isAniStickerRandom()) {
      a(localMessageForAniSticker, localAniStickerHolder.a, i);
    } else {
      AniStickerHelper.setAniStickerResource(new AniStickerHelper.Builder(localAniStickerHolder.a).localId(i).placeholderDrawable(this.x).build());
    }
    if (localMessageForAniSticker.isAniStickerRandom()) {
      paramView = "0X800BCCD";
    } else {
      paramView = "0X800BBD6";
    }
    ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", paramView, paramView, localMessageForAniSticker.sevrId, 0, "", "", "", "");
    a(paramChatMessage, localAniStickerHolder, paramViewHolder);
    return paramViewHolder;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new AniStickerItemBuilder.AniStickerHolder();
  }
  
  protected IAniStickerAIOOperation a(int paramInt)
  {
    try
    {
      if (this.a.containsKey(Integer.valueOf(paramInt)))
      {
        localIAniStickerAIOOperation = (IAniStickerAIOOperation)this.a.get(Integer.valueOf(paramInt));
        return localIAniStickerAIOOperation;
      }
      IAniStickerAIOOperation localIAniStickerAIOOperation = ((IAniStickerUtils)QRoute.api(IAniStickerUtils.class)).createAniStickerAIOOperation(paramInt, this.e, this.d, this.f);
      if (localIAniStickerAIOOperation != null) {
        this.a.put(Integer.valueOf(paramInt), localIAniStickerAIOOperation);
      }
      return localIAniStickerAIOOperation;
    }
    finally {}
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForAniSticker))
    {
      MessageForAniSticker localMessageForAniSticker = (MessageForAniSticker)paramChatMessage;
      IAniStickerAIOOperation localIAniStickerAIOOperation = a(localMessageForAniSticker.getAniStickerType());
      if (localIAniStickerAIOOperation != null)
      {
        bool = localIAniStickerAIOOperation.onMenuItemClicked(paramInt, paramContext, localMessageForAniSticker);
        break label48;
      }
    }
    boolean bool = false;
    label48:
    if (!bool) {
      super.a(paramInt, paramContext, paramChatMessage);
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    super.a(paramView, paramChatMessage, paramInt);
    paramView = (AniStickerItemBuilder.AniStickerHolder)AIOUtils.b(paramView);
    paramChatMessage = (MessageForAniSticker)paramChatMessage;
    if (paramView != null)
    {
      if (paramChatMessage == null) {
        return;
      }
      if (paramChatMessage.isAniStickerRandom())
      {
        if ((paramChatMessage.isMsgReadState()) && (!paramChatMessage.isMsgPlayState())) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        if ((paramInt != 0) && (!TextUtils.isEmpty(paramChatMessage.resultId)))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateView:");
            localStringBuilder.append(paramChatMessage.toString());
            QLog.d("MessageForAniSticker", 2, localStringBuilder.toString());
          }
          a(paramChatMessage, paramView.a);
        }
      }
    }
  }
  
  public boolean a(BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof AniStickerItemBuilder.AniStickerHolder;
  }
  
  protected boolean a(ChatMessage paramChatMessage, BaseChatItemLayout paramBaseChatItemLayout)
  {
    return super.a(paramChatMessage, paramBaseChatItemLayout);
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    paramView = ((AniStickerItemBuilder.AniStickerHolder)AIOUtils.b(paramView)).q;
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    if ((paramView instanceof MessageForAniSticker))
    {
      MessageForAniSticker localMessageForAniSticker = (MessageForAniSticker)paramView;
      Object localObject = a(localMessageForAniSticker.getAniStickerType());
      if (localObject != null)
      {
        ((IAniStickerAIOOperation)localObject).getCustomMenuItem(localQQCustomMenu, localMessageForAniSticker);
        localObject = ((IAniStickerAIOOperation)localObject).getDefaultMenuItem(localMessageForAniSticker);
        if (((HashMap)localObject).size() > 0)
        {
          localObject = ((HashMap)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            a(localQQCustomMenu, this.e, ((Integer)localEntry.getKey()).intValue(), paramView, (Bundle)localEntry.getValue());
          }
        }
      }
      if (localMessageForAniSticker.isAniStickerRandom()) {
        paramView = "0X800BCD0";
      } else {
        paramView = "0X800BBD9";
      }
      ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", paramView, paramView, localMessageForAniSticker.sevrId, 0, "", "", "", "");
    }
    if (localQQCustomMenu.b() == 0) {
      ChatActivityFacade.a(localQQCustomMenu, this.e, this.f.a);
    }
    return localQQCustomMenu.d();
  }
  
  protected void b(View paramView)
  {
    paramView = (AniStickerItemBuilder.AniStickerHolder)AIOUtils.b(paramView);
    Object localObject = (MessageForAniSticker)paramView.q;
    if (paramView.q.isSendFromLocal())
    {
      paramView = new AniStickerItemBuilder.1(this, (MessageForAniSticker)localObject);
      localObject = new AniStickerItemBuilder.2(this);
      DialogUtil.a(this.e, 230, this.e.getString(2131886574), this.e.getString(2131886575), paramView, (DialogInterface.OnClickListener)localObject).show();
      return;
    }
    boolean bool = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
    paramView = new AniStickerHelper.Builder(paramView.a).localId(QQSysFaceUtil.convertToLocal(((MessageForAniSticker)localObject).sevrId));
    int i;
    if (bool) {
      i = 2130852724;
    } else {
      i = 2130852735;
    }
    AniStickerHelper.setAniStickerResource(paramView.placeholderDrawable(i).build());
  }
  
  public int c(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  protected String d(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage instanceof MessageForAniSticker))
    {
      paramChatMessage = (MessageForAniSticker)paramChatMessage;
      StringBuilder localStringBuilder = new StringBuilder();
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
        localStringBuilder.append(HardCodeUtil.a(2131886654));
      } else {
        localStringBuilder.append(HardCodeUtil.a(2131886653));
      }
      if (!TextUtils.isEmpty(paramChatMessage.text)) {
        localStringBuilder.append(paramChatMessage.text);
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  protected void e(View paramView)
  {
    Object localObject = (AniStickerItemBuilder.AniStickerHolder)AIOUtils.b(paramView);
    if ((localObject != null) && ((((AniStickerItemBuilder.AniStickerHolder)localObject).q instanceof MessageForAniSticker)))
    {
      long l = System.currentTimeMillis();
      if (l - this.w < 500L) {
        return;
      }
      this.w = l;
      localObject = (MessageForAniSticker)((AniStickerItemBuilder.AniStickerHolder)localObject).q;
      IAniStickerAIOOperation localIAniStickerAIOOperation = a(((MessageForAniSticker)localObject).getAniStickerType());
      if (localIAniStickerAIOOperation != null) {
        localIAniStickerAIOOperation.onClick(paramView, (MessageForAniSticker)localObject);
      }
      if (((MessageForAniSticker)localObject).isAniStickerRandom()) {
        paramView = "0X800BCCE";
      } else {
        paramView = "0X800BBD7";
      }
      ReportController.b(MobileQQ.sMobileQQ.waitAppRuntime(null), "dc00898", "", "", paramView, paramView, ((MessageForAniSticker)localObject).sevrId, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    AIOUtils.q = true;
    if (!super.c()) {
      if (paramView.getId() == 2131428371) {
        e(paramView);
      } else {
        super.onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AniStickerItemBuilder
 * JD-Core Version:    0.7.0.1
 */