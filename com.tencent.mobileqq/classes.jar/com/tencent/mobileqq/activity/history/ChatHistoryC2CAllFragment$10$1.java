package com.tencent.mobileqq.activity.history;

import android.os.AsyncTask;
import android.os.Handler;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.model.IMessageForApollo;
import com.tencent.mobileqq.apollo.script.api.ISpriteCommFunc;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQProgressDialog;

class ChatHistoryC2CAllFragment$10$1
  extends AsyncTask<MessageRecord, Object, Object>
{
  ChatHistoryC2CAllFragment$10$1(ChatHistoryC2CAllFragment.10 param10) {}
  
  protected Object a(MessageRecord... paramVarArgs)
  {
    if (paramVarArgs[0].time <= this.a.c.G.L())
    {
      int i = ((QSlowTableManager)this.a.c.a.getManager(QQManagerFactory.SLOW_TABLE_MANAGER)).a(paramVarArgs[0], true);
      if (i > 0) {
        this.a.c.J = true;
      } else if ((i == 0) && (paramVarArgs[0].time == this.a.c.G.L())) {
        this.a.c.a.getMessageFacade().a(paramVarArgs[0], true);
      }
    }
    else
    {
      this.a.c.a.getMessageFacade().a(paramVarArgs[0], true);
    }
    if ((paramVarArgs[0] instanceof IMessageForApollo)) {
      ((ISpriteCommFunc)QRoute.api(ISpriteCommFunc.class)).stopAllTask(this.a.c.a, "chat_history_c2c_del_all_msg");
    }
    return null;
  }
  
  protected void onPostExecute(Object paramObject)
  {
    super.onPostExecute(paramObject);
    this.a.c.R.removeMessages(1);
    if ((this.a.c.Q != null) && (this.a.c.Q.isShowing())) {
      this.a.c.Q.dismiss();
    }
    if ((this.a.c.J) && (this.a.c.z))
    {
      this.a.c.z = false;
      this.a.c.G.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment.10.1
 * JD-Core Version:    0.7.0.1
 */