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
  private static final int jdField_a_of_type_Int = BaseChatItemLayout.h + BaseChatItemLayout.m;
  private static final int d = BaseChatItemLayout.i + BaseChatItemLayout.n;
  private static final int e = BaseChatItemLayout.j + BaseChatItemLayout.o;
  private static final int jdField_f_of_type_Int = BaseChatItemLayout.k + BaseChatItemLayout.p;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  LocationMessageModule jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule = new LocationMessageModule();
  private long c;
  private boolean jdField_f_of_type_Boolean = true;
  
  public LocationShareItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167075);
    if (QLog.isColorLevel()) {
      QLog.d("ChatItemBuilder", 2, new Object[] { "LocationShareItemBuilder.new: invoked. ", " clickable: ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    }
  }
  
  private void a(TextView paramTextView, int paramInt)
  {
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    Drawable localDrawable = localResources.getDrawable(paramInt);
    int j = localDrawable.getIntrinsicWidth();
    int i = localDrawable.getIntrinsicHeight();
    paramInt = this.jdField_a_of_type_AndroidContentContext.getSharedPreferences("setting_text_size", 0).getInt("chat_text_size_type", 0);
    if ((paramInt != 1) && (paramInt != 2) && (paramInt != 3))
    {
      paramInt = j;
    }
    else
    {
      int k = localResources.getDimensionPixelSize(2131297700);
      int m = localResources.getDimensionPixelSize(2131297701);
      paramInt = k;
      if (k == 0) {
        paramInt = 1;
      }
      double d1 = j * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / paramInt + m;
      Double.isNaN(d1);
      j = (int)(d1 * 1.6D);
      d1 = i * this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b / paramInt + m;
      Double.isNaN(d1);
      i = (int)(d1 * 1.6D);
      paramInt = j;
    }
    localDrawable.setBounds(0, 0, paramInt, i);
    paramTextView.setCompoundDrawables(localDrawable, null, null, null);
    paramTextView.setCompoundDrawablePadding(BaseChatItemLayout.r);
  }
  
  private void a(MessageForLocationShare paramMessageForLocationShare)
  {
    if (this.c == 0L)
    {
      List localList = LocationMessageUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForLocationShare.istroop, paramMessageForLocationShare.frienduin);
      if ((localList != null) && (localList.size() >= 1)) {
        this.c = ((MessageRecord)localList.get(localList.size() - 1)).time;
      } else {
        this.c = (System.currentTimeMillis() / 1000L);
      }
    }
    if (this.c > paramMessageForLocationShare.time)
    {
      paramMessageForLocationShare.isSharingLocation = false;
      ThreadManager.excute(new LocationShareItemBuilder.1(this, paramMessageForLocationShare), 32, null, true);
    }
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 1;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramBaseChatItemLayout = (LocationShareItemBuilder.Holder)paramViewHolder;
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    paramViewHolder = paramView;
    if (paramView == null)
    {
      paramViewHolder = new TextView(this.jdField_a_of_type_AndroidContentContext);
      paramViewHolder.setId(2131364524);
      paramViewHolder.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
      paramViewHolder.setTextSize(localResources.getDimensionPixelOffset(2131296454));
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
        if (!ThemeImageWrapper.isNightMode())
        {
          if (paramView.isSend()) {
            i = 2130838045;
          } else {
            i = 2130838040;
          }
        }
        else {
          i = 2130838041;
        }
        j = localResources.getColor(2131167056);
      }
      else
      {
        if (!ThemeImageWrapper.isNightMode())
        {
          if (paramView.isSend()) {
            i = 2130838044;
          } else {
            i = 2130838043;
          }
        }
        else {
          i = 2130838042;
        }
        j = Color.parseColor("#6603081A");
      }
      a(paramBaseChatItemLayout.a, i);
      paramBaseChatItemLayout.a.setTextColor(j);
      paramBaseChatItemLayout.a.setText(paramChatMessage.msg);
      paramViewHolder.setOnTouchListener(paramOnLongClickAndTouchListener);
      paramViewHolder.setOnLongClickListener(paramOnLongClickAndTouchListener);
      this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule = new LocationMessageModule();
      this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule.a(paramView);
      paramView = this.jdField_a_of_type_ComTencentMobileqqLocationLocationMessageModule;
      paramView.a = this.jdField_f_of_type_Boolean;
      paramViewHolder.setOnClickListener(paramView);
      if (AppSetting.d) {
        paramViewHolder.setContentDescription(paramChatMessage.msg);
      }
      return paramViewHolder;
    }
    catch (Throwable localThrowable)
    {
      break label81;
    }
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new LocationShareItemBuilder.Holder(this);
  }
  
  protected String a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage != null) {
      return paramChatMessage.msg;
    }
    return null;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (paramInt == 2131365480)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramChatMessage);
      return;
    }
    super.a(paramInt, paramContext, paramChatMessage);
  }
  
  protected void a(View paramView, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isSend())
    {
      paramView.setPadding(jdField_f_of_type_Int, jdField_a_of_type_Int, e, d);
      return;
    }
    paramView.setPadding(e, jdField_a_of_type_Int, jdField_f_of_type_Int, d);
  }
  
  protected void a(BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, ChatMessage paramChatMessage, BubbleInfo paramBubbleInfo)
  {
    LocationShareItemBuilder.Holder localHolder = (LocationShareItemBuilder.Holder)paramViewHolder;
    if (!(paramChatMessage instanceof MessageForLocationShare)) {
      return;
    }
    localHolder.a.setTextSize(0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b);
    if ((paramBubbleInfo.jdField_a_of_type_Int != 0) && (paramBubbleInfo.a()))
    {
      if (paramBubbleInfo.b == 0) {
        localHolder.a.setTextColor(-16777216);
      } else {
        localHolder.a.setTextColor(paramBubbleInfo.b);
      }
      if (paramBubbleInfo.c == 0)
      {
        localHolder.a.setLinkTextColor(paramView.getResources().getColorStateList(2131167077));
        return;
      }
      localHolder.a.setLinkTextColor(paramBubbleInfo.c);
      return;
    }
    paramViewHolder = paramView.getResources();
    paramView = (MessageForLocationShare)paramChatMessage;
    try
    {
      a(paramView);
      label141:
      if (paramView.isSharingLocation)
      {
        int i;
        if (paramChatMessage.isSend()) {
          i = 2131167079;
        } else {
          i = 2131167075;
        }
        paramViewHolder = paramViewHolder.getColorStateList(i);
        localHolder.a.setTextColor(paramViewHolder);
        return;
      }
      if ((!paramChatMessage.isSend()) && (!ThemeImageWrapper.isNightMode())) {
        paramViewHolder = paramViewHolder.getColorStateList(2131167076);
      } else {
        paramViewHolder = paramViewHolder.getColorStateList(2131167080);
      }
      localHolder.a.setTextColor(paramViewHolder);
      return;
    }
    catch (Throwable paramBubbleInfo)
    {
      break label141;
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
    ChatActivityFacade.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131371603, null, null);
    super.a(localQQCustomMenu, this.jdField_a_of_type_AndroidContentContext, 2131362480, null, null);
    return localQQCustomMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.LocationShareItemBuilder
 * JD-Core Version:    0.7.0.1
 */