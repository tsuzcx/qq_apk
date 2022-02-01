package com.tencent.mobileqq.app;

import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import mqq.manager.Manager;

public class WeishiManager
  implements Manager
{
  private QQAppInterface a;
  
  public WeishiManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.map_pass_back != null))
    {
      if (paramstSimpleMetaFeed.map_pass_back.size() != 0) {
        return;
      }
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localObject == null) {
        return;
      }
      localObject = (WeishiManager)((QQAppInterface)localObject).getManager(QQManagerFactory.WEISHI_MANAGER);
      if (localObject == null) {
        return;
      }
      localObject = FileUtils.readFile(((WeishiManager)localObject).b());
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load map passback length:");
        localStringBuilder.append(localObject.length);
        QLog.i("weishi-report", 2, localStringBuilder.toString());
        paramstSimpleMetaFeed.map_pass_back.put(Integer.valueOf(1), localObject);
        paramstSimpleMetaFeed.map_ext.put("recmd_feed_key", new Gson().toJson(paramstSimpleMetaFeed.map_pass_back));
      }
    }
  }
  
  private void a(MessageRecord paramMessageRecord, String paramString, long paramLong)
  {
    paramMessageRecord.issend = 1;
    paramMessageRecord.isread = true;
    paramMessageRecord.frienduin = AppConstants.WEISHI_UIN;
    paramMessageRecord.senderuin = AppConstants.WEISHI_UIN;
    paramMessageRecord.istroop = 1008;
    paramMessageRecord.msg = paramString;
    paramMessageRecord.time = paramLong;
    paramMessageRecord.createMessageUniseq();
  }
  
  public MessageForStructing a()
  {
    try
    {
      if ((this.a != null) && (this.a.getMessageFacade() != null))
      {
        if (this.a.getMessageFacade().a() == null) {
          return null;
        }
        Object localObject = this.a.getMessageFacade().b(AppConstants.WEISHI_UIN, 1008);
        if ((localObject instanceof MessageForStructing))
        {
          localObject = (MessageForStructing)localObject;
          return localObject;
        }
      }
      else
      {
        return null;
      }
    }
    catch (Exception localException)
    {
      QLog.e("WeishiManager", 2, localException, new Object[0]);
    }
    return null;
  }
  
  public MessageRecord a(String paramString, long paramLong)
  {
    if (this.a == null) {
      return null;
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.selfuin = this.a.getCurrentAccountUin();
    a(localMessageRecord, paramString, paramLong);
    return localMessageRecord;
  }
  
  public String a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      localObject = ((MessageForStructing)localObject).structingMsg;
      if ((localObject != null) && (!TextUtils.isEmpty(((AbsStructMsg)localObject).mMsgActionData))) {
        return ((AbsStructMsg)localObject).mMsgActionData;
      }
    }
    return "";
  }
  
  public void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    String str1 = paramstSimpleMetaFeed.id;
    String str2 = paramstSimpleMetaFeed.feed_desc;
    paramstSimpleMetaFeed = paramstSimpleMetaFeed.map_pass_back;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("from:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", id:");
    ((StringBuilder)localObject).append(str1);
    ((StringBuilder)localObject).append(", feed_desc:");
    ((StringBuilder)localObject).append(str2);
    QLog.d("WeishiManager", 2, ((StringBuilder)localObject).toString());
    localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = ((QQAppInterface)localObject).getMessageFacade();
    long l = NetConnInfoCenter.getServerTime();
    if (localObject == null) {
      return;
    }
    ThreadManager.post(new WeishiManager.2(this, str2, l, (QQMessageFacade)localObject, str1, paramString, paramstSimpleMetaFeed), 10, null, false);
  }
  
  public void a(Activity paramActivity)
  {
    paramActivity = this.a;
    if (paramActivity == null) {
      return;
    }
    paramActivity = paramActivity.getMessageFacade();
    if (paramActivity != null)
    {
      paramActivity = paramActivity.a();
      if ((paramActivity != null) && (paramActivity.a(AppConstants.WEISHI_UIN, 1008) > 0)) {
        ThreadManager.post(new WeishiManager.1(this), 8, null, false);
      }
    }
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir().getAbsolutePath());
    localStringBuilder.append("/file/weishi/ws_recommend_mappassback");
    return localStringBuilder.toString();
  }
  
  public String c()
  {
    try
    {
      long l = Long.parseLong(this.a.getCurrentAccountUin());
      String str = PreferenceManager.getDefaultPreference(this.a.getApplication(), l).getString("key_weishi_newest_feed_id", "");
      return str;
    }
    catch (Exception localException)
    {
      localException = localException;
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
      return "";
    }
    finally {}
    return "";
  }
  
  public String d()
  {
    try
    {
      long l = Long.parseLong(this.a.getCurrentAccountUin());
      String str = PreferenceManager.getDefaultPreference(this.a.getApplication(), l).getString("key_weishi_newest_feed_desc", "");
      return str;
    }
    catch (Exception localException)
    {
      localException = localException;
      QLog.d("WeishiManager", 2, localException.getMessage(), localException);
      return "";
    }
    finally {}
    return "";
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.WeishiManager
 * JD-Core Version:    0.7.0.1
 */