package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLocationShare;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.location.LocationMessageModule;
import com.tencent.mobileqq.location.LocationMessageUtil;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageWrapper;
import java.util.List;

public class LocationShareItemBuilder
  extends BaseBubbleBuilder
{
  private static final int jdField_c_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  LocationMessageModule jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule = new LocationMessageModule();
  private long jdField_c_of_type_Long;
  private boolean jdField_f_of_type_Boolean = true;
  
  public LocationShareItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167052);
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "LocationShareItemBuilder.new: invoked. ", " clickable: ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int i = localDrawable.getIntrinsicWidth();
    int j = localDrawable.getIntrinsicHeight();
    switch (this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0))
    {
    }
    int m;
    for (paramInt = j;; paramInt = (int)((j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / paramInt + m) * 1.6D))
    {
      localDrawable.setBounds(0, 0, i, paramInt);
      paramTextView.setCompoundDrawables(localDrawable, null, null, null);
      paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.r);
      return;
      int k = localResources.getDimensionPixelSize(2131297709);
      m = localResources.getDimensionPixelSize(2131297710);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      i = (int)((i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / paramInt + m) * 1.6D);
    }
  }
  
  private void a(MessageForLocationShare paramMessageForLocationShare)
  {
    List localList;
    if (this.jdField_c_of_type_Long == 0L)
    {
      localList = LocationMessageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
      if ((localList == null) || (localList.size() < 1)) {
        break label97;
      }
    }
    label97:
    for (this.jdField_c_of_type_Long = ((MessageRecord)localList.get(localList.size() - 1)).time;; this.jdField_c_of_type_Long = (System.currentTimeMillis() / 1000L))
    {
      if (this.jdField_c_of_type_Long > paramMessageForLocationShare.time)
      {
        paramMessageForLocationShare.isSharingLocation = false;
        ThreadManager.excute(new LocationShareItemBuilder.1(this, paramMessageForLocationShare), 32, null, true);
      }
      return;
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (LocationShareItemBuilder.Holder)paramViewHolder;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131364637);
      paramViewHolder.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131296475));
      paramViewHolder.setGravity(16);
      paramBaseChatItemLayout.a = paramViewHolder;
    }
    paramView = (MessageForLocationShare)paramChatMessage;
    try
    {
      a(paramView);
      label81:
      int i;
      int j;
      if (paramView.isSharingLocation)
      {
        if (!ThemeImageWrapper.isNightMode()) {
          if (paramView.isSend()) {
            i = 2130838204;
          }
        }
        for (;;)
        {
          j = localResources.getColor(2131167033);
          a(paramBaseChatItemLayout.a, i);
          paramBaseChatItemLayout.a.setTextColor(j);
          paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
          paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
          paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
          this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule = new LocationMessageModule();
          this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule.a(paramView);
          this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule.a = this.jdField_f_of_type_Boolean;
          paramViewHolder.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule);
          if (AppSetting.d) {
            paramViewHolder.setContentDescription(paramChatMessage.msg);
          }
          return paramViewHolder;
          i = 2130838199;
          continue;
          i = 2130838200;
        }
      }
      if (!ThemeImageWrapper.isNightMode()) {
        if (paramView.isSend()) {
          i = 2130838203;
        }
      }
      for (;;)
      {
        j = Color.parseColor("#6603081A");
        break;
        i = 2130838202;
        continue;
        i = 2130838201;
      }
    }
    catch (Throwable localThrowable)
    {
      break label81;
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new LocationShareItemBuilder.Holder(this);
  }
  
  public String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.msg;
    }
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365636)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, jdField_c_of_type_Int, e, d);
      return;
    }
    paramView.setPadding(e, jdField_c_of_type_Int, jdField_f_of_type_Int, d);
  }
  
  public void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LocationShareItemBuilder.Holder localHolder = (LocationShareItemBuilder.Holder)paramViewHolder;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localHolder.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramBubbleInfo.a == 0) || (!paramBubbleInfo.a()))
    {
      paramViewHolder = paramView.getResources();
      paramView = (MessageForLocationShare)paramChatMessage;
    }
    try
    {
      a(paramView);
      label62:
      if (paramView.isSharingLocation)
      {
        if (paramChatMessage.isSend()) {}
        for (paramViewHolder = paramViewHolder.getColorStateList(2131167056);; paramViewHolder = paramViewHolder.getColorStateList(2131167052))
        {
          localHolder.a.setTextColor(paramViewHolder);
          return;
        }
      }
      if ((paramChatMessage.isSend()) || (ThemeImageWrapper.isNightMode())) {}
      for (paramViewHolder = paramViewHolder.getColorStateList(2131167057);; paramViewHolder = paramViewHolder.getColorStateList(2131167053))
      {
        localHolder.a.setTextColor(paramViewHolder);
        return;
      }
      if (paramBubbleInfo.b == 0) {
        localHolder.a.setTextColor(-16777216);
      }
      while (paramBubbleInfo.jdField_c_of_type_Int == 0)
      {
        localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131167054));
        return;
        localHolder.a.setTextColor(paramBubbleInfo.b);
      }
      localHolder.a.setLinkTextColor(paramBubbleInfo.jdField_c_of_type_Int);
      return;
    }
    catch (Throwable paramBubbleInfo)
    {
      break label62;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule.a = paramBoolean;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu = new QQCustomMenu();
    AIOUtils.a(paramView);
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371997, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362524, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LocationShareItemBuilder
 * JD-Core Version:    0.7.0.1
 */