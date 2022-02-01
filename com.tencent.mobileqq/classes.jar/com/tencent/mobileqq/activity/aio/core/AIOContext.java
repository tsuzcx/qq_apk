package com.tencent.mobileqq.activity.aio.core;

import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.core.msglist.MsgList;
import com.tencent.mobileqq.activity.aio.helper.IHelper;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import java.util.Observer;
import mqq.os.MqqHandler;

public class AIOContext
{
  public final FragmentActivity a;
  @NonNull
  public final SessionInfo a;
  @NonNull
  protected final BaseChatPie a;
  public final QQAppInterface a;
  
  public AIOContext(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, @NonNull SessionInfo paramSessionInfo, @NonNull BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g();
  }
  
  public final AIOAnimationConatiner a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner;
  }
  
  public CoreHelperProvider a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioHelperHelperProvider;
  }
  
  public MsgList a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioCoreMsglistMsgList;
  }
  
  public <T extends IHelper> T a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramInt);
  }
  
  public TipsManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
  }
  
  public Observer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  }
  
  public final MqqHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.g(paramInt);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramInt1, paramLong, paramInt2, paramMessageRecord);
  }
  
  public void a(List<ChatMessage> paramList, MessageRecord paramMessageRecord)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramList, paramMessageRecord);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramList, paramCharSequence);
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a(paramList, paramCharSequence, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.q = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.t();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_c_of_type_AndroidViewViewGroup.invalidate();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.G;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_c_of_type_Int;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.w;
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.w();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.AIOContext
 * JD-Core Version:    0.7.0.1
 */