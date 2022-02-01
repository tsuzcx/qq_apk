package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.List;

final class ChatActivityFacade$18
  implements Runnable
{
  ChatActivityFacade$18(Context paramContext, List paramList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    ChatActivityFacade.b = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null);
    ChatActivityFacade.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131696093);
    ChatActivityFacade.b.setMainTitle(str);
    ChatActivityFacade.b.addButton(2131691479, 3);
    ChatActivityFacade.b.addCancelButton(2131690728);
    ChatActivityFacade.b.setOnButtonClickListener(new ChatActivityFacade.18.1(this));
    ChatActivityFacade.b.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.18
 * JD-Core Version:    0.7.0.1
 */