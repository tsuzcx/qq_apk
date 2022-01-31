package com.tencent.biz.qqstory.base;

import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.data.MessageForQQStoryFeed;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import ndg;
import ndh;
import org.json.JSONObject;

public class QQStoryFeedManager
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private Map jdField_a_of_type_JavaUtilMap;
  
  public QQStoryFeedManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(100);
  }
  
  @NonNull
  public static QQStoryFeedManager a(QQAppInterface paramQQAppInterface)
  {
    return (QQStoryFeedManager)paramQQAppInterface.getManager(252);
  }
  
  private void b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      MessageForQQStoryFeed localMessageForQQStoryFeed = (MessageForQQStoryFeed)localIterator.next();
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForQQStoryFeed.frienduin, 0, new int[] { -2061 });
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedManager", 2, "insertAIOQQStoryFeedFromCache: invoked. msg: " + localMessageForQQStoryFeed);
      }
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
          if (QLog.isColorLevel()) {
            QLog.i("QQStoryFeedManager", 2, "insertAIOQQStoryFeedFromCache: invoked. delete mr: " + localMessageRecord);
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord.frienduin, 0, localMessageRecord.msgtype, localMessageRecord.uniseq);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageForQQStoryFeed, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "parseJsonConfig: invoked. Message: json: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      return;
    }
    if (new JSONObject(paramString).optInt("enabled") == 1) {}
    for (paramString = Boolean.TRUE;; paramString = Boolean.FALSE)
    {
      this.jdField_a_of_type_JavaLangBoolean = paramString;
      return;
    }
  }
  
  private boolean c(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject = BaseActivity.sTopActivity;
    if (((localObject instanceof SplashActivity)) && (SplashActivity.a == 2))
    {
      localObject = ((FragmentActivity)localObject).getChatFragment();
      if (localObject == null) {
        return false;
      }
      localObject = ((ChatFragment)localObject).a();
      if (localObject == null) {
        return false;
      }
      return paramString.equals(((BaseChatPie)localObject).a().a);
    }
    return false;
  }
  
  public int a(String paramString)
  {
    return SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  public long a(String paramString)
  {
    return SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  @NonNull
  public MessageForQQStoryFeed a(byte[] paramArrayOfByte, String paramString)
  {
    MessageForQQStoryFeed localMessageForQQStoryFeed = new MessageForQQStoryFeed();
    localMessageForQQStoryFeed.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localMessageForQQStoryFeed.frienduin = paramString;
    localMessageForQQStoryFeed.senderuin = paramString;
    localMessageForQQStoryFeed.isread = true;
    localMessageForQQStoryFeed.msgData = paramArrayOfByte;
    localMessageForQQStoryFeed.mergeFrom(paramArrayOfByte);
    return localMessageForQQStoryFeed;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "insertAIOQQStoryFeedFromCacheSync: invoked. ");
    }
    ndg localndg = new ndg(this);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ThreadManager.post(localndg, 10, null, false);
      return;
    }
    localndg.run();
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aT(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str;
    if (i != j)
    {
      str = ConfigServlet.b(paramConfig, j, paramConfig.type.get());
      if (QLog.isColorLevel()) {
        QLog.i("QQStoryFeedManager", 2, "handleConfig: invoked. Message: configJson: " + str);
      }
      if (!TextUtils.isEmpty(str)) {
        break label87;
      }
    }
    label87:
    do
    {
      return;
      SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramConfig.version.get(), str);
      try
      {
        b(str);
        return;
      }
      catch (Exception paramConfig) {}
    } while (!QLog.isColorLevel());
    QLog.e("QQStoryFeedManager", 2, "handleConfig: failed. Message: exception: " + paramConfig);
  }
  
  public void a(@NonNull MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "handleAIOQQStoryFeedMessage: invoked. Message: messageForQQStoryFeed: " + paramMessageForQQStoryFeed);
    }
    if (!a())
    {
      QLog.i("QQStoryFeedManager", 1, "handleAIOQQStoryFeedMessage forbidden. ");
      return;
    }
    MessageForQQStoryFeed localMessageForQQStoryFeed = (MessageForQQStoryFeed)this.jdField_a_of_type_JavaUtilMap.get(paramMessageForQQStoryFeed.frienduin);
    StoryReportor.a("aio_msg", "aio_push", 0, 0, new String[] { paramMessageForQQStoryFeed.frienduin });
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "handleAIOQQStoryFeedMessage: invoked. cached feed: " + localMessageForQQStoryFeed);
    }
    if ((localMessageForQQStoryFeed == null) || (localMessageForQQStoryFeed.friendActionMills <= paramMessageForQQStoryFeed.friendActionMills)) {
      this.jdField_a_of_type_JavaUtilMap.put(paramMessageForQQStoryFeed.frienduin, paramMessageForQQStoryFeed);
    }
    boolean bool = c(paramMessageForQQStoryFeed.frienduin);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "handleAIOQQStoryFeedMessage: invoked. Message: inFriendAIO: " + bool);
    }
    if (!bool) {
      a();
    }
    long l = paramMessageForQQStoryFeed.mQZoneRemainTime;
    SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramMessageForQQStoryFeed.frienduin, l);
    int i = paramMessageForQQStoryFeed.mKeepTime;
    SharedPreUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramMessageForQQStoryFeed.frienduin, i);
  }
  
  public void a(String paramString)
  {
    paramString = new ndh(this, paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.post(paramString, 8, null, true);
      return;
    }
    paramString.run();
  }
  
  public boolean a()
  {
    String str;
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      str = SharedPreUtils.u(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    try
    {
      b(str);
      return Boolean.TRUE.equals(this.jdField_a_of_type_JavaLangBoolean);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQStoryFeedManager", 2, "getEnable: failed. Message: exception: " + localException);
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
    }
  }
  
  public boolean a(MessageForQQStoryFeed paramMessageForQQStoryFeed)
  {
    String str = paramMessageForQQStoryFeed.frienduin;
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = StoryHaloManager.a(paramMessageForQQStoryFeed.mFeedTime);
    int i = a(str);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedItemBuilder", 2, "isFeedItemTimeout invoked. info: keepTimeSecond: " + i + " curServerTimeSecond - msgTimeSecond: " + (l1 - l2));
    }
    return l1 - l2 > i;
  }
  
  public boolean a(String paramString)
  {
    long l1 = a(paramString);
    long l2 = c(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "isQZoneFeedRecently invoked. info: qzoneExceedSecond: " + l2 + " latestQZoneFeedSecond: " + l1);
    }
    return NetConnInfoCenter.getServerTime() - l1 < l2;
  }
  
  public long b(String paramString)
  {
    return SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  public boolean b(String paramString)
  {
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = c(paramString);
    long l3 = b(paramString);
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "isSignatureRecently invoked. info: qzoneExceedSecond: " + l2 + " latestSignatureFeedSecond: " + l3);
    }
    return l1 - l3 < l2;
  }
  
  public long c(String paramString)
  {
    return SharedPreUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), paramString);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQStoryFeedManager", 2, "onDestroy invoked. info: TAG: QQStoryFeedManager");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.QQStoryFeedManager
 * JD-Core Version:    0.7.0.1
 */