package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
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
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qroute.QRoute;
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
  private BaseChatPie a(BaseActivity paramBaseActivity)
  {
    paramBaseActivity = paramBaseActivity.getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
    if ((paramBaseActivity instanceof ChatFragment)) {
      return ((ChatFragment)paramBaseActivity).a();
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
    if (localObject == null) {
      localObject = paramContext;
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a((Context)localObject, 230, paramContext.getResources().getString(2131690242), paramContext.getResources().getString(2131690241), 2131690728, 2131693521, new AutoReplyTextItemBuilder.2(this, paramContext), new AutoReplyTextItemBuilder.3(this));
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
      return;
    }
    catch (Exception paramContext)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[谨慎此异常，弹窗无法展示] showSetAutoReplyDialog: failed. context: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidContentContext.getClass().getName());
      QLog.e("[AutoReply] AutoReplyTextItemBuilder", 1, ((StringBuilder)localObject).toString(), paramContext);
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
    localLayoutParams.addRule(3, 2131364521);
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131296383);
    int j = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    localLayoutParams.addRule(5, 2131364521);
    localLayoutParams.leftMargin = (i + j);
    paramView.setLayoutParams(localLayoutParams);
    paramView.setVisibility(0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    Intent localIntent = new Intent();
    if (AutoReplyUtil.a(((IOnlineStatusService)paramQQAppInterface.getRuntimeService(IOnlineStatusService.class)).getOnlineStatus())) {
      localIntent.putExtra("KEY_ONLINE_STATUS", AppRuntime.Status.away);
    }
    localIntent.putExtra("KEY_HAS_LEFT_BUTTON_TEXT", true);
    localIntent.putExtra("KEY_ENTRANCE", 1);
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).startAccountOnlineStateActivity(paramContext, localIntent);
  }
  
  private void a(MessageForAutoReply paramMessageForAutoReply)
  {
    if (!paramMessageForAutoReply.needClickAction) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin().equals(paramMessageForAutoReply.senderuin)) {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext);
    } else {
      a(this.jdField_a_of_type_AndroidContentContext);
    }
    ReportHelperKt.a("0X800B0AE");
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[action] onTextLinkClicked: invoked. ", " message: ", paramMessageForAutoReply.senderuin });
    }
  }
  
  View a(ViewGroup paramViewGroup)
  {
    TextView localTextView = (TextView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559134, null);
    paramViewGroup.addView(localTextView, new RelativeLayout.LayoutParams(-2, DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 21.0F)));
    return localTextView;
  }
  
  protected View a(ChatMessage paramChatMessage, BaseBubbleBuilder.ViewHolder paramViewHolder, View paramView, BaseChatItemLayout paramBaseChatItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
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
      if (paramChatMessage.needShowTail)
      {
        a(paramViewHolder.c, paramChatMessage);
        paramViewHolder.c.setVisibility(0);
      }
      else
      {
        paramViewHolder.c.setVisibility(8);
      }
      if (QLog.isColorLevel()) {
        QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[view] bindQQTextView: invoked. ", " message.needTextLink: ", Boolean.valueOf(paramChatMessage.needShowTail) });
      }
    }
    return paramView;
  }
  
  protected BaseBubbleBuilder.ViewHolder a()
  {
    return new AutoReplyTextItemBuilder.AutoReplyHolder();
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("[AutoReply] AutoReplyTextItemBuilder", 2, new Object[] { "[dialog] destroy: invoked. ", " setAutoReplyDialog: ", this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog });
    }
    QQCustomDialog localQQCustomDialog = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localQQCustomDialog != null)
    {
      try
      {
        localQQCustomDialog.dismiss();
      }
      catch (Exception localException)
      {
        QLog.d("[AutoReply] AutoReplyTextItemBuilder", 1, new Object[] { "[dialog] destroy: invoked. ", " e: ", localException });
      }
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = null;
    }
  }
  
  boolean c()
  {
    boolean bool3 = BaseActivity.sTopActivity instanceof BaseActivity;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      BaseChatPie localBaseChatPie = a(BaseActivity.sTopActivity);
      if (localBaseChatPie == null) {
        return false;
      }
      bool1 = bool2;
      if ((localBaseChatPie instanceof FriendChatPie))
      {
        bool1 = bool2;
        if (localBaseChatPie.b() == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AutoReplyTextItemBuilder
 * JD-Core Version:    0.7.0.1
 */