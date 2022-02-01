package com.tencent.mobileqq.activity.aio.coreui.tips;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Handler.Callback;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SimpleModeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

public class MsgBox
  implements Handler.Callback, View.OnClickListener
{
  protected RelativeLayout a;
  Runnable b = new MsgBox.2(this);
  private final AIOContext c;
  private final MessageTips d;
  private TextView e;
  private View f;
  
  public MsgBox(AIOContext paramAIOContext, MessageTips paramMessageTips)
  {
    this.c = paramAIOContext;
    this.d = paramMessageTips;
    paramAIOContext.d().a(this);
  }
  
  private void a(View paramView)
  {
    Object localObject = this.c.z().a().b().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IMsgTipsListener)((Iterator)localObject).next()).a(this.c);
    }
    localObject = this.c.b();
    Intent localIntent = (Intent)paramView.getTag();
    localIntent.putExtra("message_box_click", true);
    MediaPlayerManager.a(this.c.a()).a(false);
    paramView.setVisibility(8);
    paramView = this.f;
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    int i = AIOUtils.a(this.c.a(), (BaseActivity)localObject, localIntent);
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
  
  public void a(Activity paramActivity)
  {
    this.a = ((RelativeLayout)this.c.s().findViewById(2131430649));
  }
  
  public final void a(AIOContext paramAIOContext, MessageRecord paramMessageRecord, com.tencent.imcore.message.Message paramMessage)
  {
    if (paramAIOContext.l()) {
      return;
    }
    QQAppInterface localQQAppInterface = paramAIOContext.a();
    BaseActivity localBaseActivity = paramAIOContext.b();
    if (!this.d.a(paramMessageRecord, localQQAppInterface, paramMessage)) {
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
    TextView localTextView = this.e;
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
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.removeAllViews();
      this.e = null;
      this.f = null;
    }
  }
  
  public void c()
  {
    TextView localTextView = this.e;
    if (localTextView != null) {
      AIOUtils.a(localTextView.getBackground());
    }
  }
  
  public boolean handleMessage(android.os.Message paramMessage)
  {
    if (paramMessage.what == 95)
    {
      if (((paramMessage.obj instanceof CharSequence)) && (this.e != null))
      {
        paramMessage = (CharSequence)paramMessage.obj;
        this.e.setText(paramMessage);
        this.e.requestLayout();
      }
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131438955)
    {
      SimpleModeHelper.a(this.c);
      ThreadManagerV2.getUIHandlerV2().postDelayed(new MsgBox.3(this, paramView), 200L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.tips.MsgBox
 * JD-Core Version:    0.7.0.1
 */