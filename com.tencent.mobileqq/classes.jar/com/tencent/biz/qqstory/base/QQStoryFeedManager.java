package com.tencent.biz.qqstory.base;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.aio.BeancurdMsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class QQStoryFeedManager
  implements Manager
{
  private QQAppInterface a;
  private Map<String, MessageForQQStoryFeed> b;
  private Boolean c;
  
  public QQStoryFeedManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = new ConcurrentHashMap(100);
  }
  
  @NonNull
  public static QQStoryFeedManager a(QQAppInterface paramQQAppInterface)
  {
    return (QQStoryFeedManager)paramQQAppInterface.getManager(QQManagerFactory.QQ_STORY_FEED_MANAGER);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseJsonConfig: invoked. Message: json: ");
      localStringBuilder.append(paramString);
      QLog.i("QQStoryFeedManager", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.c = Boolean.valueOf(false);
      return;
    }
    if (new JSONObject(paramString).optInt("enabled") == 1) {
      paramString = Boolean.TRUE;
    } else {
      paramString = Boolean.FALSE;
    }
    this.c = paramString;
  }
  
  @NonNull
  public MessageForQQStoryFeed a(byte[] paramArrayOfByte, String paramString)
  {
    MessageForQQStoryFeed localMessageForQQStoryFeed = new MessageForQQStoryFeed();
    localMessageForQQStoryFeed.selfuin = this.a.getCurrentAccountUin();
    localMessageForQQStoryFeed.frienduin = paramString;
    localMessageForQQStoryFeed.senderuin = paramString;
    localMessageForQQStoryFeed.isread = true;
    localMessageForQQStoryFeed.msgData = paramArrayOfByte;
    localMessageForQQStoryFeed.mergeFrom(paramArrayOfByte);
    return localMessageForQQStoryFeed;
  }
  
  public void a() {}
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.bG(this.a.getApp(), this.a.getCurrentAccountUin());
    if (i != j)
    {
      Object localObject = ConfigServlet.b(paramConfig, j, paramConfig.type.get());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleConfig: invoked. Message: configJson: ");
        localStringBuilder.append((String)localObject);
        QLog.i("QQStoryFeedManager", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      SharedPreUtils.e(this.a.getApp(), this.a.getCurrentAccountUin(), paramConfig.version.get(), (String)localObject);
      try
      {
        b((String)localObject);
        return;
      }
      catch (Exception paramConfig)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleConfig: failed. Message: exception: ");
          ((StringBuilder)localObject).append(paramConfig);
          QLog.e("QQStoryFeedManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  public void a(@NonNull MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleAIOQQStoryFeedMessage: invoked. Message: messageForQQStoryFeed: ");
      ((StringBuilder)localObject1).append(paramMessageForQQStoryFeed);
      QLog.i("QQStoryFeedManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (!b())
    {
      QLog.i("QQStoryFeedManager", 1, "handleAIOQQStoryFeedMessage forbidden. ");
      return;
    }
    StoryReportor.a("aio_msg", "aio_push", 0, 0, new String[] { paramMessageForQQStoryFeed.frienduin });
    Object localObject2 = (BeancurdManager)this.a.getManager(QQManagerFactory.BEANCURD_MANAGER);
    Object localObject1 = ((BeancurdManager)localObject2).b(paramMessageForQQStoryFeed.frienduin, 0, 5);
    if (localObject1 != null)
    {
      if (((BeancurdMsg)localObject1).originTime < paramMessageForQQStoryFeed.friendActionMills) {}
    }
    else {
      do
      {
        i = 0;
        break;
        localObject1 = this.a.getMessageFacade().a(paramMessageForQQStoryFeed.frienduin, 0, new int[] { -2061 });
      } while ((localObject1 != null) && (((List)localObject1).size() > 0) && (((MessageForQQStoryFeed)((List)localObject1).get(((List)localObject1).size() - 1)).friendActionMills >= paramMessageForQQStoryFeed.friendActionMills));
    }
    int i = 1;
    if (i != 0) {
      try
      {
        BeancurdMsg localBeancurdMsg = new BeancurdMsg();
        localBeancurdMsg.frienduin = paramMessageForQQStoryFeed.frienduin;
        localBeancurdMsg.busiid = 5;
        localBeancurdMsg.isNeedDelHistory = true;
        localBeancurdMsg.ispush = false;
        localBeancurdMsg.originTime = paramMessageForQQStoryFeed.friendActionMills;
        localBeancurdMsg.startTime = paramMessageForQQStoryFeed.mFeedTime;
        localBeancurdMsg.validTime = paramMessageForQQStoryFeed.mKeepTime;
        localObject1 = null;
        if (!TextUtils.isEmpty(paramMessageForQQStoryFeed.mFeedId)) {
          localObject1 = new String(paramMessageForQQStoryFeed.msgData, "ISO_8859_1");
        }
        localBeancurdMsg.buffer = ((String)localObject1);
        ((BeancurdManager)localObject2).a(localBeancurdMsg);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("handleAIOQQStoryFeedMessage: parse data to MessageRecord has error. Message: ");
          ((StringBuilder)localObject2).append(localException.getMessage());
          QLog.i("QQStoryFeedManager", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    i = paramMessageForQQStoryFeed.mKeepTime;
    SharedPreUtils.a(this.a.getCurrentUin(), paramMessageForQQStoryFeed.frienduin, i);
  }
  
  public void a(String paramString)
  {
    paramString = new QQStoryFeedManager.1(this, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(paramString, 8, null, true);
      return;
    }
    paramString.run();
  }
  
  public boolean b()
  {
    return true;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "onDestroy invoked. info: TAG: QQStoryFeedManager");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryFeedManager
 * JD-Core Version:    0.7.0.1
 */