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
  private View jdField_a_of_type_AndroidViewView = null;
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private final BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List<MessageForShakeWindow> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public AIOShakeHelper(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie.a();
    this.jdField_a_of_type_MqqOsMqqHandler = paramBaseChatPie.a();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addVibrateListener(this);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeVibrateListener(this);
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
    Object localObject = new AIOShakeHelper.1(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    int i;
    if (localInputMethodManager.isActive())
    {
      i = 1;
      localInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    else
    {
      i = 0;
    }
    if (i != 0)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed((Runnable)localObject, 60L);
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
      this.jdField_a_of_type_MqqOsMqqHandler.post(new AIOShakeHelper.2(this));
    }
  }
  
  public void a(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    a(paramChatMessage);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((!paramMessageRecord.isread) && ((paramMessageRecord instanceof MessageForShakeWindow)))
    {
      paramMessageRecord = (MessageForShakeWindow)paramMessageRecord;
      paramMessageRecord.parse();
      if ((paramMessageRecord.mShakeWindowMsg != null) && (paramMessageRecord.mShakeWindowMsg.onlineFlag == 1))
      {
        if (this.jdField_a_of_type_JavaUtilList == null) {
          this.jdField_a_of_type_JavaUtilList = new ArrayList();
        }
        this.jdField_a_of_type_JavaUtilList.add(paramMessageRecord);
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
    ((ViewGroup)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView()).getChildAt(0).clearAnimation();
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (localView.getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_AndroidViewView.getParent()).removeView(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void b(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
  public boolean b(AIOContext paramAIOContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = this.jdField_a_of_type_JavaUtilList;
      localObject = (MessageForShakeWindow)((List)localObject).get(((List)localObject).size() - 1);
      if (((MessageForShakeWindow)localObject).isSendFromLocal())
      {
        this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOShakeHelper.3(this, (MessageForShakeWindow)localObject), 20L);
      }
      else
      {
        long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOnlineStauts();
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
          localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus);
          QLog.d("Q.msg.shakemsg", 2, localStringBuilder.toString());
        }
        if ((l == 11L) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.userActiveStatus == 0)) {
          this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new AIOShakeHelper.4(this, (MessageForShakeWindow)localObject), 20L);
        }
      }
      this.jdField_a_of_type_JavaUtilList.clear();
    }
  }
  
  public void c(AIOContext paramAIOContext, ChatMessage paramChatMessage) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOShakeHelper
 * JD-Core Version:    0.7.0.1
 */