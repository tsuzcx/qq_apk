package com.tencent.mobileqq.activity.aio.rebuild;

import aicl;
import android.text.TextUtils;
import android.widget.TextView;
import anmw;
import ayox;
import bazp;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;

public class LimitChatPie$9
  implements Runnable
{
  public LimitChatPie$9(aicl paramaicl, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.this$0.f.setText(aicl.a(this.this$0));
    }
    for (;;)
    {
      localObject = (bazp)this.this$0.a(45);
      if (!((bazp)localObject).c()) {
        break;
      }
      return;
      this.this$0.f.setText(this.jdField_a_of_type_JavaLangString);
    }
    boolean bool = true;
    if ((this.jdField_a_of_type_Boolean) || (((bazp)localObject).b()) || (!this.this$0.P)) {
      bool = false;
    }
    Object localObject = ((anmw)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).e(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    ayox.a().a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Friends)localObject, this.this$0.f, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.9
 * JD-Core Version:    0.7.0.1
 */