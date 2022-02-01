package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.FriendChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.chat.autoreply.AutoReplyUtil;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForAutoReply;
import com.tencent.mobileqq.onlinestatus.AccountOnlineStateActivity;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import org.jetbrains.annotations.Nullable;

public class AutoReplyTextItemBuilder
  extends TextItemBuilder
{
  private QQCustomDialog a;
  
  public AutoReplyTextItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
  }
  
  @Nullable
  private BaseChatPie a(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = paramFragmentActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((paramFragmentActivity instanceof ChatFragment)) {
      return ((ChatFragment)paramFragmentActivity).a();
    }
    return null;
  }
  
  @Nullable
  private CharSequence a(MessageForAutoReply paramMessageForAutoReply)
  {
    boolean bool = c();
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[view] getMessageContent: invoked. ", " friendChatPie: ", Boolean.valueOf(bool) });
    }
    paramMessageForAutoReply.needClickAction = bool;
    if (bool) {
      return paramMessageForAutoReply.sb;
    }
    return new QQText(paramMessageForAutoReply.msg, 13, ChatTextSizeSettingActivity.a(), paramMessageForAutoReply);
  }
  
  private void a(Context paramContext)
  {
    Object localObject = BaseActivity.sTopActivity;
    if (localObject != null) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a((Context)localObject, 230, paramContext.getResources().getString(2131690321), paramContext.getResources().getString(2131690320), 2131690800, 2131693566, new AutoReplyTextItemBuilder.2(this, paramContext), new AutoReplyTextItemBuilder.3(this));
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        return;
      }
      catch (Exception paramContext)
      {
        QLog.e("[AutoReply] AutoReplyTextItemBuilder", 1, "[谨慎此异常，弹窗无法展示] showSetAutoReplyDialog: failed. context: " + this.jdField_a_of_type_AndroidContentContext.getClass().getName(), paramContext);
      }
      localObject = paramContext;
    }
  }
  
  private void a(View paramView, MessageForAutoReply paramMessageForAutoReply)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams == null)
    {
      paramView.setVisibility(8);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[autoReply] adjustTailViewLayoutParams: invoked. ", " message.isSend: ", Boolean.valueOf(paramMessageForAutoReply.isSend()) });
    }
    paramView.setOnClickListener(new AutoReplyTextItemBuilder.1(this, paramMessageForAutoReply));
    a(localLayoutParams);
    localLayoutParams.addRule(3, 2131364634);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296404);
    int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    localLayoutParams.addRule(5, 2131364634);
    localLayoutParams.leftMargin = (i + j);
    paramView.setLayoutParams(localLayoutParams);
    paramView.setVisibility(0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Intent localIntent = new Intent();
    if (AutoReplyUtil.a(paramQQAppInterface.getOnlineStatus())) {
      localIntent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.away);
    }
    localIntent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
    localIntent.putExtra("KEY_ENTRANCE", 1);
    PublicFragmentActivity.a(paramContext, localIntent, AccountOnlineStateActivity.class);
  }
  
  private void a(MessageForAutoReply paramMessageForAutoReply)
  {
    if (!paramMessageForAutoReply.needClickAction) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramMessageForAutoReply.senderuin)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    }
    for (;;)
    {
      ReportHelperKt.a("0X800B0AE");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[action] onTextLinkClicked: invoked. ", " message: ", paramMessageForAutoReply.senderuin });
      return;
      a(this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  View a(ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559258, null);
    paramViewGroup.addView(localTextView, new RelativeLayout.LayoutParams(-2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F)));
    return localTextView;
  }
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramView = super.a(paramChatMessage, paramViewHolder, paramView, paramBaseChatItemLayout, paramOnLongClickAndTouchListener);
    paramViewHolder = (AutoReplyTextItemBuilder.AutoReplyHolder)paramViewHolder;
    if ((paramChatMessage instanceof MessageForAutoReply))
    {
      paramChatMessage = (MessageForAutoReply)paramChatMessage;
      paramOnLongClickAndTouchListener = a(paramChatMessage);
      paramViewHolder.d.setText(paramOnLongClickAndTouchListener);
      if (paramViewHolder.c == null) {
        paramViewHolder.c = a(paramBaseChatItemLayout);
      }
      if (!paramChatMessage.needShowTail) {
        break label126;
      }
      a(paramViewHolder.c, paramChatMessage);
      paramViewHolder.c.setVisibility(0);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[view] bindQQTextView: invoked. ", " message.needTextLink: ", Boolean.valueOf(paramChatMessage.needShowTail) });
      }
      return paramView;
      label126:
      paramViewHolder.c.setVisibility(8);
    }
  }
  
  public BaseBubbleBuilder.ViewHolder a()
  {
    return new AutoReplyTextItemBuilder.AutoReplyHolder();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[dialog] destroy: invoked. ", " setAutoReplyDialog: ", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog });
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("[AutoReply] AutoReplyTextItemBuilder", 1, new Object[] { "[dialog] destroy: invoked. ", " e: ", localException });
      }
    }
  }
  
  boolean c()
  {
    BaseChatPie localBaseChatPie;
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      localBaseChatPie = a((FragmentActivity)BaseActivity.sTopActivity);
      if (localBaseChatPie != null) {}
    }
    else
    {
      return false;
    }
    if (((localBaseChatPie instanceof FriendChatPie)) && (localBaseChatPie.b() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AutoReplyTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */