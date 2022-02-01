package com.tencent.mobileqq.activity.aio.coreui.tips;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.tips.MessageTips;
import com.tencent.mobileqq.activity.aio.core.tips.TipsController;
import com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class MsgBox
  implements Handler.Callback, View.OnClickListener
{
  private View jdField_a_of_type_AndroidViewView;
  protected RelativeLayout a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final MessageTips jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsMessageTips;
  Runnable jdField_a_of_type_JavaLangRunnable = new MsgBox.2(this);
  
  public MsgBox(AIOContext paramAIOContext, MessageTips paramMessageTips)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsMessageTips = paramMessageTips;
    paramAIOContext.a().a(this);
  }
  
  private void a(View paramView)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().b().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IMsgTipsListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a();
    Intent localIntent = (Intent)paramView.getTag();
    localIntent.putExtra("message_box_click", true);
    MediaPlayerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a()).a(false);
    paramView.setVisibility(8);
    paramView = this.jdField_a_of_type_AndroidViewView;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    int i = AIOUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a(), (BaseActivity)localObject, localIntent);
    if (i == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MsgBox", 2, "openAIO by start SplashAct");
      }
      ((BaseActivity)localObject).startActivity(localIntent);
    }
    else if (i == 2)
    {
      QLog.e("MsgBox", 1, "openAIO rediectToAIOWithMt 2");
      return;
    }
    if ((localIntent.getBooleanExtra("finishAIO", false)) && ((localObject instanceof ChatActivity))) {
      ((BaseActivity)localObject).finish();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MsgBox", 2, " onClick R.id.msgbox ");
    }
  }
  
  public void a()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetTextView = null;
      this.jdField_a_of_type_AndroidViewView = null;
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramActivity.findViewById(2131364587));
  }
  
  public final void a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, com.tencent.imcore.message.Message paramMessage)
  {
    if (paramAIOContext.b()) {
      return;
    }
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    BaseActivity localBaseActivity = paramAIOContext.a();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsMessageTips.a(paramMessageRecord, localQQAppInterface, paramMessage)) {
      return;
    }
    Intent localIntent = localQQAppInterface.getIntentByMessage(localBaseActivity, paramMessage, false);
    if (9002 == paramMessage.istroop) {
      localIntent.putExtra("af_key_from", 2);
    }
    localBaseActivity.runOnUiThread(new MsgBox.1(this, paramAIOContext, paramMessage, localQQAppInterface, localBaseActivity, localIntent, paramMessageRecord));
  }
  
  public boolean a()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localTextView != null)
    {
      bool1 = bool2;
      if (localTextView.getVisibility() == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      AIOUtils.a(localTextView.getBackground());
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    if (paramMessage.what == 95)
    {
      if (((paramMessage.obj instanceof CharSequence)) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
      {
        paramMessage = (CharSequence)paramMessage.obj;
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_AndroidWidgetTextView.requestLayout();
      }
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131371574) {
      a(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox
 * JD-Core Version:    0.7.0.1
 */