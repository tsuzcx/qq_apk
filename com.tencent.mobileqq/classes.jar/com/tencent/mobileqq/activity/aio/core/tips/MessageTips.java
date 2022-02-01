package com.tencent.mobileqq.activity.aio.core.tips;

import android.content.Intent;
import android.support.v4.util.ArraySet;
import android.text.SpannableStringBuilder;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.rebuild.tips.TipsRegister;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class MessageTips
{
  private static ArraySet<Integer> jdField_a_of_type_AndroidSupportV4UtilArraySet;
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  private final TipsController jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public MessageTips(AIOContext paramAIOContext, TipsController paramTipsController)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramAIOContext.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController = paramTipsController;
  }
  
  @NotNull
  static CharSequence a(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    int i = 0;
    while (i < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('\024');
      localStringBuilder.append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]);
      Object localObject = paramCharSequence;
      if (paramCharSequence.indexOf(localStringBuilder.toString()) != -1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append('\024');
        ((StringBuilder)localObject).append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]);
        localObject = ((StringBuilder)localObject).toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("\024");
        localStringBuilder.append((char)i);
        localObject = paramCharSequence.replace((CharSequence)localObject, localStringBuilder.toString());
      }
      i += 1;
      paramCharSequence = (CharSequence)localObject;
    }
    return paramCharSequence;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if (jdField_a_of_type_AndroidSupportV4UtilArraySet == null)
    {
      jdField_a_of_type_AndroidSupportV4UtilArraySet = new ArraySet();
      jdField_a_of_type_AndroidSupportV4UtilArraySet.addAll(Arrays.asList(new Integer[] { Integer.valueOf(1036), Integer.valueOf(10010) }));
    }
    return jdField_a_of_type_AndroidSupportV4UtilArraySet.contains(Integer.valueOf(paramMessage.istroop));
  }
  
  @NotNull
  private CharSequence b(Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a();
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((IMsgTipsFilter)((Iterator)localObject2).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramIntent, paramMessageRecord, paramMessage);
      if (localObject3 != null) {
        localSpannableStringBuilder.append((CharSequence)localObject3);
      }
    }
    Object localObject3 = ((List)localObject1).iterator();
    localObject1 = null;
    while (((Iterator)localObject3).hasNext())
    {
      localObject2 = ((IMsgTipsFilter)((Iterator)localObject3).next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramMessageRecord, paramMessage);
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    paramMessageRecord = (MessageRecord)localObject1;
    if (localObject1 == null) {
      paramMessageRecord = paramMessage.getMessageText();
    }
    localObject1 = paramMessageRecord;
    if (localSpannableStringBuilder.length() == 0) {
      if (paramMessage.nickName != null)
      {
        localObject1 = paramMessageRecord;
        if (paramMessage.nickName.equals(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getString(2131693780))) {
          localObject1 = a(paramMessageRecord);
        }
        paramIntent = paramIntent.getStringExtra("uinname");
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("[");
        paramMessageRecord.append(paramIntent);
        paramMessageRecord.append("]");
        localSpannableStringBuilder.append(new ColorNickText(paramMessageRecord.toString(), 16));
        localSpannableStringBuilder.append(" ");
        localSpannableStringBuilder.append(new ColorNickText(paramMessage.nickName, 16));
      }
      else
      {
        paramIntent = paramIntent.getStringExtra("uinname");
        if ((paramIntent != null) && (paramIntent.length() != 0))
        {
          localSpannableStringBuilder.append(paramIntent);
          localObject1 = paramMessageRecord;
        }
        else
        {
          localSpannableStringBuilder.append(paramMessage.frienduin);
          localObject1 = paramMessageRecord;
        }
      }
    }
    if (localObject1 != null)
    {
      localSpannableStringBuilder.append("：");
      localSpannableStringBuilder.append((CharSequence)localObject1);
    }
    return localSpannableStringBuilder;
  }
  
  public CharSequence a(Intent paramIntent, MessageRecord paramMessageRecord, Message paramMessage)
  {
    try
    {
      paramIntent = b(paramIntent, paramMessageRecord, paramMessage);
      return paramIntent;
    }
    catch (Exception paramIntent)
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("getMessageTipsStr error: ");
      paramMessageRecord.append(paramMessage);
      QLog.e("MessageTips", 1, paramMessageRecord.toString(), paramIntent);
    }
    return "";
  }
  
  public boolean a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface, Message paramMessage)
  {
    if ((paramMessage != null) && (!paramMessage.isread))
    {
      if (paramMessage.isSendFromLocal()) {
        return false;
      }
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTipsTipsController.a().a().iterator();
      while (localIterator.hasNext()) {
        if (((IMsgTipsFilter)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramMessageRecord, paramMessage)) {
          return false;
        }
      }
      if (a(paramQQAppInterface, paramMessage)) {
        return false;
      }
      return (paramMessage.istroop != 0) || (!FriendsStatusUtil.a(paramMessage.frienduin, paramQQAppInterface));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.tips.MessageTips
 * JD-Core Version:    0.7.0.1
 */