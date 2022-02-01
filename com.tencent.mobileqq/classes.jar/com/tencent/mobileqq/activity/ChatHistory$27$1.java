package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.model.MessageForApollo;
import com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistory$27$1
  extends AsyncTask<MessageRecord, Object, Object>
{
  ChatHistory$27$1(ChatHistory.27 param27) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    if (this.a.a.d) {
      if (this.a.a.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager != null) {
        this.a.a.jdField_a_of_type_ComTencentMobileqqPersistenceQslowtableQSlowTableManager.a(paramVarArgs[0], true);
      }
    }
    for (;;)
    {
      if ((paramVarArgs[0] instanceof MessageForApollo)) {
        ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.a.app, "chat_history_start_del_msg");
      }
      return null;
      this.a.a.app.getMessageFacade().a(paramVarArgs[0], true);
    }
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.a.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.a.a.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    if (this.a.a.d) {
      this.a.a.a(11, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.27.1
 * JD-Core Version:    0.7.0.1
 */