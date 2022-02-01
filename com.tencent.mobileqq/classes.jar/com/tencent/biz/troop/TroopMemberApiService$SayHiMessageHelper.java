package com.tencent.biz.troop;

import android.content.Context;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.data.RecentSayHelloListItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopMemberApiService$SayHiMessageHelper
{
  private static int a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    ConversationFacade localConversationFacade = paramQQAppInterface.getConversationFacade();
    if (localQQMessageFacade != null) {
      paramQQAppInterface = localQQMessageFacade.getLastMessage(paramMessageRecord.senderuin, paramMessageRecord.istroop);
    } else {
      paramQQAppInterface = null;
    }
    int j = 0;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (localConversationFacade != null) {
        i = localConversationFacade.a(paramQQAppInterface.frienduin, paramQQAppInterface.istroop);
      }
    }
    return i;
  }
  
  private static final JSONObject a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject = paramQQAppInterface.getMessageProxy(1001).b(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001);
    if (localObject == null)
    {
      QLog.i("SayHiMessageHelper", 1, "getSayHiBoxInnerMessages, no tribe say hi info");
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
      if (localMessageRecord.istroop == 10002) {
        localArrayList.add(localMessageRecord);
      }
    }
    paramInt2 = Math.min(paramInt2 + paramInt1, localArrayList.size());
    for (;;)
    {
      if (paramInt1 < paramInt2) {}
      try
      {
        localJSONArray.put(a(paramContext, paramQQAppInterface, (MessageRecord)localArrayList.get(paramInt1)));
        paramInt1 += 1;
      }
      catch (JSONException paramContext)
      {
        QLog.e("SayHiMessageHelper", 1, "getSayHiBoxInnerMessages Exception:", paramContext);
      }
    }
    localJSONObject.put("msgArray", localJSONArray);
    paramInt1 = localArrayList.size();
    if (paramInt2 < paramInt1) {
      localJSONObject.put("isEnd", 0);
    } else {
      localJSONObject.put("isEnd", 1);
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("getSayHiBoxInnerMessages, jsonResult = ");
      paramContext.append(localJSONObject.toString());
      QLog.i("SayHiMessageHelper", 1, paramContext.toString());
      return localJSONObject;
    }
    return localJSONObject;
  }
  
  public static final JSONObject a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 == 1) || (paramInt2 == 2)) && (paramInt1 >= 0) && (paramInt3 >= 1))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getTribeSayHelloInfo, viewIndex =");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" start = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(" count = ");
        localStringBuilder.append(paramInt3);
        QLog.i("SayHiMessageHelper", 1, localStringBuilder.toString());
      }
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return null;
        }
        return a(paramContext, paramQQAppInterface, paramInt1, paramInt3);
      }
      return b(paramContext, paramQQAppInterface, paramInt1, paramInt3);
    }
    paramContext = new StringBuilder();
    paramContext.append("getTribeSayHelloInfo, invalid parameters viewIndex =");
    paramContext.append(paramInt2);
    paramContext.append(" start = ");
    paramContext.append(paramInt1);
    paramContext.append(" count = ");
    paramContext.append(paramInt3);
    QLog.e("SayHiMessageHelper", 1, paramContext.toString());
    return null;
  }
  
  private static JSONObject a(Context paramContext, QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    JSONObject localJSONObject = new JSONObject();
    paramMessageRecord = new RecentSayHelloListItem(paramMessageRecord);
    paramMessageRecord.a(paramQQAppInterface, paramContext);
    try
    {
      localJSONObject.put("uin", paramMessageRecord.getRecentUserUin());
      localJSONObject.put("content", paramMessageRecord.mLastMsg);
      localJSONObject.put("time", paramMessageRecord.mShowTime);
      localJSONObject.put("nickName", paramMessageRecord.mTitleName);
      localJSONObject.put("redPointCount", paramMessageRecord.getUnreadNum());
      return localJSONObject;
    }
    catch (JSONException paramContext)
    {
      QLog.e("SayHiMessageHelper", 1, "getNormalTribeSayHiMsg Exception:", paramContext);
    }
    return localJSONObject;
  }
  
  private static final void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.getMessageProxy(1001).b(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001);
    if (localObject1 == null)
    {
      QLog.i("SayHiMessageHelper", 1, "deleteSayHiBox, no tribe say hi info");
      return;
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = ((List)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject3).next();
      if (localMessageRecord.istroop == 10002) {
        ((ArrayList)localObject2).add(localMessageRecord.senderuin);
      }
    }
    if (((List)localObject1).size() == ((ArrayList)localObject2).size())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SayHiMessageHelper", 1, "deleteSayHiBox, delete total box");
      }
      paramQQAppInterface.getMessageFacade().a(AppConstants.LBS_HELLO_UIN, 1001, AppConstants.LBS_SAY_HELLO_LIST_UIN, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
    localObject1 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("deleteSayHiBox, delete uin = ");
        ((StringBuilder)localObject3).append((String)localObject2);
        QLog.i("SayHiMessageHelper", 1, ((StringBuilder)localObject3).toString());
      }
      paramQQAppInterface.getMessageFacade().a(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001, (String)localObject2, paramQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private static final void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.getMessageFacade().a(paramString, 1001);
  }
  
  public static final void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (((paramInt2 != 1) && (paramInt2 != 2) && (paramInt1 == 1)) || ((paramInt1 != 1) && (paramInt1 != 2)))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("clearTribeSayHiNodeUnread, invalid parameters viewIndex =");
      paramQQAppInterface.append(paramInt2);
      paramQQAppInterface.append(" clearType = ");
      paramQQAppInterface.append(paramInt1);
      paramQQAppInterface.append(" clearUin = ");
      paramQQAppInterface.append(paramString);
      QLog.e("SayHiMessageHelper", 1, paramQQAppInterface.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearTribeSayHiNodeUnread, viewIndex =");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" clearUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" clearType = ");
      localStringBuilder.append(paramInt1);
      QLog.i("SayHiMessageHelper", 1, localStringBuilder.toString());
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return;
        }
        a(paramQQAppInterface, paramString);
        return;
      }
      a(paramQQAppInterface, paramString);
    }
  }
  
  private static final void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    paramQQAppInterface.getMessageFacade().a(paramString2, 1001, paramString1, paramQQAppInterface.getCurrentAccountUin());
  }
  
  private static void a(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject)
  {
    Object localObject = paramQQAppInterface.getMessageProxy(1001).b(AppConstants.LBS_SAY_HELLO_LIST_UIN, 1001);
    paramQQAppInterface = paramQQAppInterface.getConversationFacade();
    int k = 0;
    int j = 0;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((List)localObject).size();
    }
    if (i > 0)
    {
      localObject = ((List)localObject).iterator();
      i = 0;
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (localMessageRecord.istroop == 10002)
        {
          j += paramQQAppInterface.a(localMessageRecord.senderuin, localMessageRecord.istroop);
          i = 1;
        }
      }
    }
    else
    {
      j = 0;
      i = k;
    }
    if (i != 0) {
      try
      {
        paramJSONObject.put("redPointCount", j);
        paramJSONObject.put("status", 1);
        return;
      }
      catch (JSONException paramQQAppInterface)
      {
        QLog.e("SayHiMessageHelper", 1, "handleTribeSayHiBox Exception:", paramQQAppInterface);
      }
    }
  }
  
  private static final JSONObject b(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    Object localObject = paramQQAppInterface.getMessageProxy(1001).b(AppConstants.LBS_HELLO_UIN, 1001);
    if (localObject == null)
    {
      QLog.i("SayHiMessageHelper", 1, "getNewSayHiMessages, no tribe say hi info");
      return null;
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject2.put("redPointCount", 0);
      localJSONObject2.put("status", 0);
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      int i = 0;
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if (AppConstants.LBS_SAY_HELLO_LIST_UIN.equals(localMessageRecord.senderuin))
        {
          a(paramQQAppInterface, localJSONObject2);
        }
        else if ((!AppConstants.MSG_BOX_INTERACT_UIN.equals(localMessageRecord.senderuin)) && (!AppConstants.MSG_BOX_FOLLOW_UIN.equals(localMessageRecord.senderuin)) && (!AppConstants.MSG_BOX_MYMOMMENT_UIN.equals(localMessageRecord.senderuin)) && (!AppConstants.MSG_BOX_DAREN_ASSISTANT_UIN.equals(localMessageRecord.senderuin)) && (!AppConstants.MSG_BOX_YANZHI_UIN.equals(localMessageRecord.senderuin)))
        {
          localArrayList.add(localMessageRecord);
          i += a(paramQQAppInterface, localMessageRecord);
        }
      }
      paramInt2 = Math.min(paramInt1 + paramInt2, localArrayList.size());
      while (paramInt1 < paramInt2)
      {
        localJSONArray.put(a(paramContext, paramQQAppInterface, (MessageRecord)localArrayList.get(paramInt1)));
        paramInt1 += 1;
      }
      localJSONObject1.put("greetingNodeInfo", localJSONObject2);
      localJSONObject1.put("msgArray", localJSONArray);
      localJSONObject1.put("redPointCount", i);
      paramInt1 = localArrayList.size();
      if (paramInt2 < paramInt1) {
        localJSONObject1.put("isEnd", 0);
      } else {
        localJSONObject1.put("isEnd", 1);
      }
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getNewSayHiMessages, jsonResult = ");
        paramContext.append(localJSONObject1.toString());
        QLog.i("SayHiMessageHelper", 1, paramContext.toString());
        return localJSONObject1;
      }
    }
    catch (JSONException paramContext)
    {
      QLog.e("SayHiMessageHelper", 1, "getNewSayHiMessages Exception:", paramContext);
    }
    return localJSONObject1;
  }
  
  public static final void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (((paramInt2 != 1) && (paramInt2 != 2) && (paramInt1 == 1)) || ((paramInt1 != 1) && (paramInt1 != 2)))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("deleteTribeSayHiNode, invalid parameters msgType =");
      paramQQAppInterface.append(paramInt2);
      paramQQAppInterface.append(" deleteType = ");
      paramQQAppInterface.append(paramInt1);
      paramQQAppInterface.append(" deleteUin = ");
      paramQQAppInterface.append(paramString);
      QLog.e("SayHiMessageHelper", 1, paramQQAppInterface.toString());
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteTribeSayHiNode, msgType =");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" deleteUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" deleteType = ");
      localStringBuilder.append(paramInt1);
      QLog.i("SayHiMessageHelper", 1, localStringBuilder.toString());
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2) {
          return;
        }
        a(paramQQAppInterface, paramString, AppConstants.LBS_SAY_HELLO_LIST_UIN);
        return;
      }
      a(paramQQAppInterface, paramString, AppConstants.LBS_HELLO_UIN);
      return;
    }
    a(paramQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.SayHiMessageHelper
 * JD-Core Version:    0.7.0.1
 */