package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.msglist.IMsgUpdateCallback;
import com.tencent.mobileqq.activity.aio.core.msglist.IRefreshCallback;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.VibrateListener;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class AIOShakeHelper
  implements IMsgUpdateCallback, IRefreshCallback, ILifeCycleHelper, VibrateListener
{
  private final BaseChatPie a;
  private final QQAppInterface b;
  private final BaseActivity c;
  private final MqqHandler d;
  private List<MessageForShakeWindow> e;
  private View f = null;
  
  public AIOShakeHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = paramBaseChatPie.d;
    this.c = paramBaseChatPie.aX();
    this.d = paramBaseChatPie.j();
  }
  
  private void d()
  {
    this.b.addVibrateListener(this);
  }
  
  private void e()
  {
    this.b.removeVibrateListener(this);
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startShakeAnim() is called,time is:");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      QLog.d("Q.msg.shakemsg", 2, ((StringBuilder)localObject).toString());
    }
    b();
    Object localObject = new AIOShakeHelper.1(this, this.c);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.c.getSystemService("input_method");
    int i;
    if (localInputMethodManager.isActive())
    {
      i = 1;
      localInputMethodManager.hideSoftInputFromWindow(this.c.getWindow().getDecorView().getWindowToken(), 0);
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      this.d.postDelayed((Runnable)localObject, 60L);
      return;
    }
    ((Runnable)localObject).run();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("beforeVibrate() is called,time is:");
        localStringBuilder.append(System.currentTimeMillis());
        QLog.d("Q.msg.shakemsg", 2, localStringBuilder.toString());
      }
      this.d.post(new AIOShakeHelper.2(this));
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isread) && ((paramMessageRecord instanceof MessageForShakeWindow)))
    {
      paramMessageRecord = (MessageForShakeWindow)paramMessageRecord;
      paramMessageRecord.parse();
      if ((paramMessageRecord.mShakeWindowMsg != null) && (paramMessageRecord.mShakeWindowMsg.onlineFlag == 1))
      {
        if (this.e == null) {
          this.e = new ArrayList();
        }
        this.e.add(paramMessageRecord);
      }
    }
  }
  
  public void a(List<ChatMessage> paramList1, List<ChatMessage> paramList2)
  {
    c();
  }
  
  public boolean a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  void b()
  {
    ((ViewGroup)this.c.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    View localView = this.f;
    if ((localView != null) && (localView.getParent() != null)) {
      ((ViewGroup)this.f.getParent()).removeView(this.f);
    }
    this.f = null;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    a(paramChatMessage);
  }
  
  public void c()
  {
    Object localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.e;
      localObject = (MessageForShakeWindow)((List)localObject).get(((List)localObject).size() - 1);
      if (((MessageForShakeWindow)localObject).isSendFromLocal())
      {
        this.d.postDelayed(new AIOShakeHelper.3(this, (MessageForShakeWindow)localObject), 20L);
      }
      else
      {
        long l = this.b.getOnlineStauts();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("time is:");
          localStringBuilder.append(System.currentTimeMillis());
          localStringBuilder.append(",shmsgseq is:");
          localStringBuilder.append(((MessageForShakeWindow)localObject).shmsgseq);
          localStringBuilder.append(",msgUid is:");
          localStringBuilder.append(((MessageForShakeWindow)localObject).msgUid);
          localStringBuilder.append(",uniseq is:");
          localStringBuilder.append(((MessageForShakeWindow)localObject).uniseq);
          localStringBuilder.append(",onlineStatus is:");
          localStringBuilder.append(l);
          localStringBuilder.append(",userActiveStatus is:");
          localStringBuilder.append(this.b.userActiveStatus);
          QLog.d("Q.msg.shakemsg", 2, localStringBuilder.toString());
        }
        if ((l == 11L) && (this.b.userActiveStatus == 0)) {
          this.d.postDelayed(new AIOShakeHelper.4(this, (MessageForShakeWindow)localObject), 20L);
        }
      }
      this.e.clear();
    }
  }
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean d(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void e(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public String getTag()
  {
    return "Q.aio.BaseChatPie.AIOShakeHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      e();
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper
 * JD-Core Version:    0.7.0.1
 */