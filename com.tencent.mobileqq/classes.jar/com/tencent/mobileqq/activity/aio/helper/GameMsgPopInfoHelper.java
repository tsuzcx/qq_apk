package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class GameMsgPopInfoHelper
  extends SimpleUIAIOHelper
{
  public GameMsgPopInfoHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    if ((this.c instanceof GameMsgChatPie)) {
      return;
    }
    throw new IllegalArgumentException("GameMsgPopInfoHelper: A GameMsgChatPie is required");
  }
  
  private MessageForArkApp a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if ((paramJSONObject != null) && (this.c.aE() != null) && (this.c.d != null))
    {
      String str2 = paramJSONObject.optString("app");
      String str3 = paramJSONObject.optString("view");
      String str4 = paramJSONObject.optString("desc");
      String str5 = paramJSONObject.optString("ver");
      String str1 = paramJSONObject.optString("prompt");
      String str6 = paramJSONObject.optString("meta");
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str6)))
      {
        if (paramBoolean) {
          paramJSONObject = " ";
        } else {
          paramJSONObject = str1;
        }
        paramJSONObject = new ArkAppMessage(paramJSONObject, str2, str4, str3, str5, str6, "{\"forward\":0,\"autosize\":1,\"type\":\"normal\",\"showSender\":0, \"showTime\":0, \"menuMode\":0}", null);
        paramJSONObject = MessageRecordFactory.a(this.c.d, this.c.aE().b, this.c.aE().c, this.c.aE().a, paramJSONObject);
        if (paramJSONObject != null)
        {
          if (paramBoolean)
          {
            paramJSONObject.msg = "";
            return paramJSONObject;
          }
        }
        else {
          QLog.e("GameMsgPopInfoHelper", 1, "createArkMessage msg is null");
        }
        return paramJSONObject;
      }
      QLog.e("GameMsgPopInfoHelper", 1, "createArkMessage one of name, view, meta is null");
      return null;
    }
    QLog.e("GameMsgPopInfoHelper", 1, "createArkMessage parameters is null");
    return null;
  }
  
  protected void a(MessageForArkApp paramMessageForArkApp)
  {
    if (this.c != null)
    {
      if (this.c.d == null) {
        return;
      }
      try
      {
        QQMessageFacade localQQMessageFacade = this.c.d.getMessageFacade();
        if (localQQMessageFacade == null) {
          return;
        }
        String str = this.c.ae();
        int i = this.c.F();
        if (localQQMessageFacade.a(str, i, "extInt=12000 and msgtype=-5008") != null)
        {
          QLog.i("GameMsgPopInfoHelper", 1, "insertAsIckBreakMsg exist an ick-break message.");
          return;
        }
        localObject = localQQMessageFacade.o(str, i);
        if ((localObject != null) && (((List)localObject).size() > 0) && (((List)localObject).get(0) != null))
        {
          paramMessageForArkApp.time = (((ChatMessage)((List)localObject).get(0)).time - 1L);
          localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
        }
        else
        {
          paramMessageForArkApp.time = MessageCache.c();
          localObject = paramMessageForArkApp;
        }
        paramMessageForArkApp.extInt = 12000;
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramMessageForArkApp);
        localQQMessageFacade.d(str, i, localArrayList);
        localQQMessageFacade.f();
        localQQMessageFacade.notifyObservers(localObject);
        return;
      }
      catch (Throwable paramMessageForArkApp)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("insertAsIckBreakMsg error:");
        ((StringBuilder)localObject).append(paramMessageForArkApp);
        QLog.e("GameMsgPopInfoHelper", 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (this.c != null))
    {
      if (this.c.d == null) {
        return;
      }
      paramJSONObject = paramJSONObject.optJSONObject("sgamebattle");
      if ((paramJSONObject != null) && (paramJSONObject.has("type")))
      {
        if (!paramJSONObject.has("content")) {
          return;
        }
        int i = paramJSONObject.optInt("type");
        if ((i != 1) && (i != 2)) {
          return;
        }
        paramJSONObject = paramJSONObject.optJSONObject("content");
        boolean bool;
        if (i == 1) {
          bool = true;
        } else {
          bool = false;
        }
        paramJSONObject = a(paramJSONObject, bool);
        if (paramJSONObject == null) {
          return;
        }
        QQMessageFacade localQQMessageFacade = this.c.d.getMessageFacade();
        if (localQQMessageFacade == null) {
          return;
        }
        if (i == 2)
        {
          localQQMessageFacade.a(paramJSONObject, this.c.d.getCurrentUin());
          return;
        }
        if (i == 1) {
          ThreadManager.getSubThreadHandler().post(new GameMsgPopInfoHelper.1(this, paramJSONObject));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.GameMsgPopInfoHelper
 * JD-Core Version:    0.7.0.1
 */