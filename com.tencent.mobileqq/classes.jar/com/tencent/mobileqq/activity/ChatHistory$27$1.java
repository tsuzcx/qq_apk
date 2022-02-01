package com.tencent.mobileqq.activity;

import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
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
    if (this.a.c.R)
    {
      if (this.a.c.Q != null) {
        this.a.c.Q.a(paramVarArgs[0], true);
      }
    }
    else {
      this.a.c.app.getMessageFacade().a(paramVarArgs[0], true);
    }
    if ((paramVarArgs[0] instanceof IMessageForApollo)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.c.app, "chat_history_start_del_msg");
    }
    return null;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.c.W.removeMessages(1);
    if ((this.a.c.V != null) && (this.a.c.V.isShowing())) {
      this.a.c.V.dismiss();
    }
    if (this.a.c.R) {
      this.a.c.a(11, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.27.1
 * JD-Core Version:    0.7.0.1
 */