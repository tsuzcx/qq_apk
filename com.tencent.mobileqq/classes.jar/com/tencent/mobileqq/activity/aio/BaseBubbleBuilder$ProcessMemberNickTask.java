package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ContactUtils;
import java.io.UnsupportedEncodingException;

class BaseBubbleBuilder$ProcessMemberNickTask
  implements Runnable
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  BaseChatItemLayout jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  String jdField_a_of_type_JavaLangString;
  String b;
  
  public BaseBubbleBuilder$ProcessMemberNickTask(QQAppInterface paramQQAppInterface, Context paramContext, BaseChatItemLayout paramBaseChatItemLayout, String paramString1, String paramString2, int paramInt, View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout = paramBaseChatItemLayout;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
  
  public void run()
  {
    String str1 = null;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout == null) || (this.jdField_a_of_type_AndroidViewView$OnLongClickListener == null)) {}
    for (;;)
    {
      return;
      label55:
      Object localObject;
      if (this.jdField_a_of_type_Int == 1)
      {
        str1 = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b);
        localObject = str1;
        if (str1 != null)
        {
          localObject = str1;
          if (str1.getBytes().length > 3)
          {
            byte[] arrayOfByte = str1.getBytes();
            localObject = str1;
            if (arrayOfByte[0] == -17)
            {
              localObject = str1;
              if (arrayOfByte[1] == -69)
              {
                localObject = str1;
                if (arrayOfByte[2] == -65)
                {
                  localObject = new byte[arrayOfByte.length - 3];
                  System.arraycopy(arrayOfByte, 3, localObject, 0, localObject.length);
                }
              }
            }
          }
        }
      }
      try
      {
        localObject = new String((byte[])localObject, "UTF-8");
        if (!(this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
          continue;
        }
        ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new BaseBubbleBuilder.ProcessMemberNickTask.1(this, (String)localObject));
        return;
        if (this.jdField_a_of_type_Int != 3000) {
          break label55;
        }
        str1 = ContactUtils.getDiscussionMemberShowName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_JavaLangString, this.b);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          localUnsupportedEncodingException.printStackTrace();
          String str2 = str1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ProcessMemberNickTask
 * JD-Core Version:    0.7.0.1
 */