package com.tencent.mobileqq.activity.aio.rebuild;

import aequ;
import ajxn;
import android.text.TextUtils;
import android.widget.TextView;
import auja;
import awbs;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class LimitChatPie$9
  implements Runnable
{
  public LimitChatPie$9(aequ paramaequ, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.this$0.f.setText(aequ.a(this.this$0));
    }
    for (;;)
    {
      localObject = (awbs)this.this$0.a(45);
      if (!((awbs)localObject).b()) {
        break;
      }
      return;
      this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((awbs)localObject).a()) || (!this.this$0.Q)) {
      bool = false;
    }
    Object localObject = ((ajxn)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    auja.a().a((Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.9
 * JD-Core Version:    0.7.0.1
 */