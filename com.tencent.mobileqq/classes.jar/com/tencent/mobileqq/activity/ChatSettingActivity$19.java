package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class ChatSettingActivity$19
  extends FriendListObserver
{
  ChatSettingActivity$19(ChatSettingActivity paramChatSettingActivity) {}
  
  public void onSetComment(boolean paramBoolean, String paramString1, String paramString2, byte paramByte)
  {
    if (paramBoolean) {
      if ((ChatSettingActivity.a(this.a) == 0) && (ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).equals(paramString1)) && (paramString2 != null) && (!ChatSettingActivity.f(this.a).equals(paramString2)))
      {
        if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing()))
        {
          ChatSettingActivity.a(this.a, 2131693408, 2);
          ChatSettingActivity.a(this.a).dismiss();
        }
        ChatSettingActivity.c(this.a, paramString2);
        ChatSettingActivity.b(this.a, paramString2);
        ChatSettingActivity.a(this.a, paramString2);
      }
    }
    while (ChatSettingActivity.a(this.a) != 0) {
      return;
    }
    if ((ChatSettingActivity.a(this.a) != null) && (ChatSettingActivity.a(this.a).isShowing()) && (!this.a.isFinishing())) {
      ChatSettingActivity.a(this.a).dismiss();
    }
    ChatSettingActivity.b(this.a, ChatSettingActivity.f(this.a));
  }
  
  public void onSetGenralSettingsTroopFilter(boolean paramBoolean, Map<String, Integer> paramMap) {}
  
  public void onSetHiddenChatSwitch(boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 2)) {
      QLog.e("tag_hidden_chat", 1, "data not right");
    }
    label270:
    for (;;)
    {
      return;
      Object localObject = (String[])paramArrayOfObject[0];
      boolean[] arrayOfBoolean = (boolean[])paramArrayOfObject[1];
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, new Object[] { "res:", Boolean.valueOf(paramBoolean), " len1:", Integer.valueOf(localObject.length), " len2:", Integer.valueOf(arrayOfBoolean.length) });
      }
      if (paramBoolean)
      {
        int i = 0;
        for (;;)
        {
          if (i >= localObject.length) {
            break label270;
          }
          paramArrayOfObject = localObject[i];
          paramBoolean = arrayOfBoolean[i];
          if (paramArrayOfObject.equals(ChatSettingActivity.a(this.a)))
          {
            this.a.b.setOnCheckedChangeListener(null);
            this.a.b.setChecked(paramBoolean);
            this.a.a();
            localObject = this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
            if ((!this.a.b.a()) && (!this.a.c.a())) {}
            for (i = 0;; i = 8)
            {
              ((FormSwitchItem)localObject).setVisibility(i);
              this.a.b.setOnCheckedChangeListener(this.a);
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("tag_hidden_chat", 2, new Object[] { "uin:", paramArrayOfObject, " switch:", Boolean.valueOf(paramBoolean) });
              return;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  public void onUpdateDelFriend(boolean paramBoolean, Object paramObject)
  {
    QLog.i(ChatSettingActivity.c(this.a), 1, "onUpdateDelFriend isSuccess: " + paramBoolean + " object: " + paramObject);
    if ((paramBoolean) && (String.valueOf(paramObject).equals(ChatSettingActivity.a(this.a))) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.getVisibility() == 0)) {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
    }
  }
  
  public void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (TextUtils.equals(paramString, ChatSettingActivity.a(this.a))))
    {
      ChatSettingActivity.c(this.a, ChatSettingActivity.d(this.a, ChatSettingActivity.a(this.a)));
      if (ChatSettingActivity.f(this.a) == null) {
        ChatSettingActivity.c(this.a, "");
      }
      ChatSettingActivity.b(this.a, ChatSettingActivity.f(this.a));
      ChatSettingActivity.f(this.a);
    }
  }
  
  public void onUpdateFriendShieldFlag(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    ChatSettingActivity.g(this.a);
    ChatSettingActivity.e(this.a);
    if (paramBoolean2) {
      if (!ChatSettingActivity.a(this.a).endsWith(paramLong + "")) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        ChatSettingActivity.a(this.a, paramString, 1);
        return;
      }
    } while (!ChatSettingActivity.a(this.a).endsWith(paramLong + ""));
    if (paramBoolean1)
    {
      ChatSettingActivity.a(this.a, 2131719330, 1);
      return;
    }
    ChatSettingActivity.a(this.a, 2131719328, 1);
  }
  
  public void onUpdateHotFriendLevel(boolean paramBoolean, ArrayList<String> paramArrayList)
  {
    super.onUpdateHotFriendLevel(paramBoolean, paramArrayList);
    if ((ChatSettingActivity.a(this.a) == 0) && (paramBoolean) && (paramArrayList != null) && (paramArrayList.contains(ChatSettingActivity.a(this.a))))
    {
      if (QLog.isColorLevel()) {
        QLog.d(ChatSettingActivity.c(this.a), 2, "onUpdateHotFriendLevel");
      }
      ChatSettingActivity.f(this.a);
    }
  }
  
  public void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    int j;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (this.a.h != null) && (ChatSettingActivity.a(this.a) == 0) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))))
    {
      j = paramArrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (ChatSettingActivity.a(this.a).equals(str)) {
          ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a, ChatSettingActivity.a(this.a)), this.a.h);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public void onUpdateStrangerRichStatus(boolean paramBoolean, String[] paramArrayOfString, Map<String, RichStatus> paramMap)
  {
    if ((this.a.h != null) && (!TextUtils.isEmpty(ChatSettingActivity.a(this.a))) && (paramMap != null) && (paramMap.containsKey(ChatSettingActivity.a(this.a)))) {
      ChatSettingActivity.a(this.a, (RichStatus)paramMap.get(ChatSettingActivity.a(this.a)), this.a.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingActivity.19
 * JD-Core Version:    0.7.0.1
 */