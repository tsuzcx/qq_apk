package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Auth_Rst;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_CheckAuth_Rsp;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Effect_Auth_Rst;
import com.tencent.pb.chatbgInfo.chatbgInfo.Bg_Rsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class ChatBackgroundAuthHandler
  extends BusinessHandler
{
  protected QQAppInterface a;
  
  protected ChatBackgroundAuthHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  private void a(chatbgInfo.Bg_CheckAuth_Rsp paramBg_CheckAuth_Rsp)
  {
    Object localObject1 = paramBg_CheckAuth_Rsp.AuthEffectRst.get();
    paramBg_CheckAuth_Rsp = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    int i;
    for (;;)
    {
      boolean bool = ((Iterator)localObject1).hasNext();
      i = 1;
      if (!bool) {
        break;
      }
      localObject2 = (chatbgInfo.Bg_Effect_Auth_Rst)((Iterator)localObject1).next();
      int j = ((chatbgInfo.Bg_Effect_Auth_Rst)localObject2).effectId.get();
      localObject2 = String.valueOf(((chatbgInfo.Bg_Effect_Auth_Rst)localObject2).result.get());
      if ((((String)localObject2).endsWith("001")) || (((String)localObject2).equals("1004"))) {
        i = 0;
      }
      paramBg_CheckAuth_Rsp.put(Integer.valueOf(j), Integer.valueOf(i));
    }
    localObject1 = ((ChatBackgroundManager)this.a.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).i();
    Object localObject2 = this.a.getApplication().getApplicationContext();
    Object localObject3 = this.a.getCurrentAccountUin();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("chat_background_path_");
    ((StringBuilder)localObject4).append((String)localObject3);
    localObject2 = ((Context)localObject2).getSharedPreferences(((StringBuilder)localObject4).toString(), 0).edit();
    if (localObject1 != null)
    {
      localObject3 = ((HashMap)localObject1).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        i = ((Integer)((HashMap)localObject1).get(localObject4)).intValue();
        if (i > 0) {
          try
          {
            i = Integer.valueOf(i).intValue();
            if ((paramBg_CheckAuth_Rsp.containsKey(Integer.valueOf(i))) && (((Integer)paramBg_CheckAuth_Rsp.get(Integer.valueOf(i))).intValue() == 1))
            {
              StringBuilder localStringBuilder;
              if ("_chat_bg_effect".equals(localObject4))
              {
                ((SharedPreferences.Editor)localObject2).remove("_chat_bg_effect");
              }
              else
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append((String)localObject4);
                localStringBuilder.append("_chat_bg_effect");
                ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
              }
              if (QLog.isColorLevel())
              {
                localStringBuilder = new StringBuilder();
                localStringBuilder.append("chatBackground auth error: bgEffectId = ");
                localStringBuilder.append(i);
                localStringBuilder.append(" key:");
                localStringBuilder.append((String)localObject4);
                QLog.i("ChatBackgroundAuthHandler", 2, localStringBuilder.toString());
              }
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ChatBackgroundAuthHandler", 2, "bgEffectId转化int型出错");
            }
            localException.printStackTrace();
          }
        }
      }
      ((SharedPreferences.Editor)localObject2).commit();
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramToServiceMsg = new chatbgInfo.Bg_Rsp();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.ret.get() == 0L)
        {
          paramToServiceMsg = (chatbgInfo.Bg_CheckAuth_Rsp)paramToServiceMsg.rspcmd_0x01.get();
          paramObject = paramToServiceMsg.AuthRst.get();
          paramFromServiceMsg = new HashMap();
          paramObject = paramObject.iterator();
          if (paramObject.hasNext())
          {
            Object localObject = (chatbgInfo.Bg_Auth_Rst)paramObject.next();
            int j = ((chatbgInfo.Bg_Auth_Rst)localObject).bgId.get();
            localObject = String.valueOf(((chatbgInfo.Bg_Auth_Rst)localObject).result.get());
            if (((String)localObject).endsWith("001")) {
              break label198;
            }
            if (!((String)localObject).equals("1004")) {
              break label192;
            }
            break label198;
            paramFromServiceMsg.put(Integer.valueOf(j), Integer.valueOf(i));
            continue;
          }
          a(paramFromServiceMsg);
          a(paramToServiceMsg);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
      return;
      label192:
      i = 1;
      continue;
      label198:
      i = 0;
    }
  }
  
  public void a(Map<Integer, Integer> paramMap)
  {
    HashMap localHashMap = ((ChatBackgroundManager)this.a.getManager(QQManagerFactory.CHAT_BACKGROUND_MANAGER)).h();
    SharedPreferences.Editor localEditor = ChatBackgroundUtil.a(this.a.getApplication().getApplicationContext(), this.a.getCurrentAccountUin(), 0).edit();
    if (localHashMap != null)
    {
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        String str = (String)localHashMap.get(localObject);
        if ((str != null) && (!str.equals("null")) && (!str.equals("custom"))) {
          try
          {
            int i = Integer.valueOf(str).intValue();
            if ((paramMap.containsKey(Integer.valueOf(i))) && (((Integer)paramMap.get(Integer.valueOf(i))).intValue() == 1))
            {
              localEditor.putString((String)localObject, "null");
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("chatBackground auth error: bgId = ");
                ((StringBuilder)localObject).append(i);
                QLog.i("ChatBackgroundAuthHandler", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ChatBackgroundAuthHandler", 2, "背景id转化int型出错");
            }
            localException.printStackTrace();
          }
        }
      }
      localEditor.commit();
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("Background.checkAuth".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatBackgroundAuthHandler", 2, "onReceive called.");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ChatBackgroundAuthHandler
 * JD-Core Version:    0.7.0.1
 */