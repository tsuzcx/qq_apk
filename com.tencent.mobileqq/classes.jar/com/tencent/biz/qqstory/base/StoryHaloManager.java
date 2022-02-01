package com.tencent.biz.qqstory.base;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloBatchLoader;
import com.tencent.biz.qqstory.network.handler.RecentTabHaloBatchLoader.RecentTabHaloEvent;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;>;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import org.json.JSONObject;

public class StoryHaloManager
  implements Manager
{
  private static long jdField_a_of_type_Long;
  private RecentTabHaloBatchLoader jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloBatchLoader;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new StoryHaloManager.1(this);
  private FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private Double jdField_a_of_type_JavaLangDouble;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile String jdField_a_of_type_JavaLangString;
  private Map<Long, MsgTabNodeInfo> jdField_a_of_type_JavaUtilMap;
  private Set<Long> jdField_a_of_type_JavaUtilSet;
  
  public StoryHaloManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    b();
  }
  
  private int a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool1 = b(paramMsgTabNodeInfo);
    if (!bool1) {}
    boolean bool2;
    do
    {
      return -3;
      bool2 = c(paramMsgTabNodeInfo);
    } while (!bool2);
    boolean bool3 = a(paramMsgTabNodeInfo);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "tellHaloState: invoked. Message: storyNodeRecently: " + bool2 + " storyNodeVideoAllRead: " + bool3 + " storyVideoExisted: " + bool1);
    }
    if (!bool3) {
      return -1;
    }
    return -2;
  }
  
  private int a(List<MsgTabNodeInfo> paramList, MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (paramMsgTabNodeInfo.jdField_b_of_type_Long == ((MsgTabNodeInfo)paramList.get(i)).jdField_b_of_type_Long) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public static long a(long paramLong)
  {
    int i = 86400 * (int)(paramLong / 86400);
    if (QLog.isColorLevel())
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC+8"));
      localObject = ((SimpleDateFormat)localObject).format(new Date(i * 1000L));
      QLog.i("StoryHaloManager", 2, "todayDawnSecond: invoked. Message: wholeDaySecond: " + i + " format: " + (String)localObject);
    }
    return i;
  }
  
  private List<Long> a(Set<Long> paramSet, List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramSet == null) && (paramList == null)) {
      localObject = localArrayList;
    }
    do
    {
      return localObject;
      if (paramSet != null) {
        break;
      }
      localObject = paramList;
    } while (paramList != null);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject = (Long)paramList.next();
      if (!paramSet.contains(localObject)) {
        localArrayList.add(localObject);
      }
    }
    return localArrayList;
  }
  
  private boolean a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null) {}
    while (paramMsgTabNodeInfo.jdField_b_of_type_Int <= 0) {
      return true;
    }
    return false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "init: invoked.  this: " + this);
    }
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(99);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloBatchLoader = new RecentTabHaloBatchLoader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "parseJsonConfig: invoked. Message: json: " + paramString);
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_a_of_type_JavaLangDouble = Double.valueOf(0.0D);
      return;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    if (localJSONObject.optInt("enabled") == 1) {}
    for (paramString = Boolean.TRUE;; paramString = Boolean.FALSE)
    {
      this.jdField_a_of_type_JavaLangBoolean = paramString;
      this.jdField_a_of_type_JavaLangDouble = Double.valueOf(localJSONObject.optDouble("timeout_day", 0.0D));
      return;
    }
  }
  
  private static boolean b()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - jdField_a_of_type_Long;
    if ((l2 > 0L) && (l2 < 3000L)) {
      return true;
    }
    jdField_a_of_type_Long = l1;
    return false;
  }
  
  private boolean b(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null) {}
    while (paramMsgTabNodeInfo.a.size() <= 0) {
      return false;
    }
    return true;
  }
  
  private boolean c(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null) {}
    long l1;
    long l3;
    long l4;
    do
    {
      return false;
      l1 = NetConnInfoCenter.getServerTime();
      long l2 = paramMsgTabNodeInfo.d;
      l3 = a(l2);
      l4 = a();
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "isStoryNodeRecently: invoked. Message: timeoutSecond: " + l4 + " serverTime: " + l1 + " nodeInfoTimeStamp: " + l2);
      }
    } while (l1 - l3 >= l4);
    return true;
  }
  
  public long a()
  {
    String str;
    if (this.jdField_a_of_type_JavaLangDouble == null) {
      str = SharedPreUtils.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    try
    {
      b(str);
      return (86400 * this.jdField_a_of_type_JavaLangDouble.doubleValue());
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("StoryHaloManager", 2, "getEnabled: failed. Message: exception: " + localException);
        }
        this.jdField_a_of_type_JavaLangDouble = Double.valueOf(0.0D);
      }
    }
  }
  
  @Nullable
  public MsgTabNodeInfo a(@NonNull MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), MsgTabHaloEntity.getSelectionArgs(paramMsgTabNodeInfo), null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUserNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    paramMsgTabNodeInfo = localMsgTabHaloEntity;
    if (localList != null)
    {
      paramMsgTabNodeInfo = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        paramMsgTabNodeInfo = new MsgTabNodeInfo();
        paramMsgTabNodeInfo.a(localMsgTabHaloEntity);
      }
    }
    return paramMsgTabNodeInfo;
  }
  
  @Nullable
  public MsgTabNodeInfo a(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), new String[] { paramString }, null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUinNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    paramString = localMsgTabHaloEntity;
    if (localList != null)
    {
      paramString = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        paramString = new MsgTabNodeInfo();
        paramString.a(localMsgTabHaloEntity);
      }
    }
    return paramString;
  }
  
  public List<MsgTabNodeInfo> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryAllNode: invoked. Message: entities: " + localObject);
    }
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabHaloEntity localMsgTabHaloEntity = (MsgTabHaloEntity)((Iterator)localObject).next();
      MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
      localMsgTabNodeInfo.a(localMsgTabHaloEntity);
      localArrayList.add(localMsgTabNodeInfo);
    }
    return localArrayList;
  }
  
  @NonNull
  public List<Long> a(List<RecentBaseData> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = new ArrayList(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (a(localObject))
      {
        localObject = (RecentItemChatMsgData)localObject;
        try
        {
          localArrayList.add(Long.valueOf(Long.valueOf(((RecentItemChatMsgData)localObject).getRecentUserUin()).longValue()));
        }
        catch (NumberFormatException localNumberFormatException)
        {
          QLog.e("StoryHaloManager", 1, "getFriendUins: failed.  exception: " + localNumberFormatException);
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    RecentTabHaloBatchLoader.RecentTabHaloEvent localRecentTabHaloEvent = new RecentTabHaloBatchLoader.RecentTabHaloEvent(true);
    StoryDispatcher.a().dispatch(localRecentTabHaloEvent);
  }
  
  public void a(int paramInt, List<Long> paramList) {}
  
  public void a(View paramView, @NonNull RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onClick: invoked. Message: uin: " + paramRecentItemChatMsgData.getRecentUserUin());
    }
    Bosses.get().postLightWeightJob(new StoryHaloManager.2(this, paramRecentItemChatMsgData, paramView), 0);
  }
  
  public void a(@NonNull MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "handlePushPacket: invoked. Message: msgTabNodeInfo: " + paramMsgTabNodeInfo);
    }
    d(paramMsgTabNodeInfo);
    MsgTabNodeInfo localMsgTabNodeInfo = a(paramMsgTabNodeInfo);
    if ((localMsgTabNodeInfo != null) && (localMsgTabNodeInfo.c < paramMsgTabNodeInfo.c))
    {
      c(paramMsgTabNodeInfo);
      b(paramMsgTabNodeInfo);
    }
    while (localMsgTabNodeInfo != null) {
      return;
    }
    c(paramMsgTabNodeInfo);
    b(paramMsgTabNodeInfo);
  }
  
  public void a(RecentItemChatMsgData paramRecentItemChatMsgData)
  {
    if (!a())
    {
      paramRecentItemChatMsgData.haloState = 0;
      return;
    }
    Object localObject = paramRecentItemChatMsgData.getRecentUserUin();
    try
    {
      long l = Long.valueOf((String)localObject).longValue();
      localObject = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(l));
      int i = a((MsgTabNodeInfo)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "assignHaloState: invoked. Message: haloState: " + i + " uin: " + l + " msgTabNodeInfo: " + localObject);
      }
      paramRecentItemChatMsgData.haloState = i;
      return;
    }
    catch (NumberFormatException paramRecentItemChatMsgData)
    {
      QLog.e("StoryHaloManager", 1, "assignHaloState: failed.  exception: " + paramRecentItemChatMsgData);
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.aG(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str;
    if (i != j)
    {
      str = ConfigServlet.b(paramConfig, j, paramConfig.type.get());
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "handleConfig: invoked. Message: configJson: " + str);
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
    QLog.e("StoryHaloManager", 2, "handleConfig: failed. Message: exception: " + paramConfig);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(@NonNull List<MsgTabNodeInfo> paramList)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_JavaUtilMap.clear();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo1 = (MsgTabNodeInfo)paramList.next();
      if (localMsgTabNodeInfo1.e != 1)
      {
        b(localMsgTabNodeInfo1);
      }
      else
      {
        MsgTabNodeInfo localMsgTabNodeInfo2 = (MsgTabNodeInfo)localConcurrentHashMap.get(Long.valueOf(localMsgTabNodeInfo1.jdField_b_of_type_Long));
        if (localMsgTabNodeInfo2 == null)
        {
          localMsgTabNodeInfo1 = a(String.valueOf(localMsgTabNodeInfo1.jdField_b_of_type_Long));
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use db cache. dbMsgNode: " + localMsgTabNodeInfo1);
          }
          b(localMsgTabNodeInfo1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.i("StoryHaloManager", 2, "updateHaloStateMap: invoked. use memory cache. backupNode: " + localMsgTabNodeInfo2);
          }
          b(localMsgTabNodeInfo2);
        }
      }
    }
  }
  
  public void a(List<MsgTabNodeInfo> paramList, boolean paramBoolean)
  {
    List localList = a();
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.getTransaction().begin();
    if (paramBoolean) {}
    label174:
    for (;;)
    {
      try
      {
        Object localObject = new MsgTabHaloEntity();
        ((MsgTabHaloEntity)localObject).setStatus(1001);
        localEntityManager.remove((Entity)localObject, null, null);
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (MsgTabNodeInfo)localIterator.next();
        paramList = (List<MsgTabNodeInfo>)localObject;
        int i;
        if (((MsgTabNodeInfo)localObject).e == 1)
        {
          i = a(localList, (MsgTabNodeInfo)localObject);
          if (i != -1) {
            break label174;
          }
          paramList = (List<MsgTabNodeInfo>)localObject;
          if (QLog.isColorLevel())
          {
            QLog.e("StoryHaloManager", 2, "dbBuildAllNodes: failed.  exception: info: " + localObject);
            paramList = (List<MsgTabNodeInfo>)localObject;
          }
        }
        localEntityManager.persistOrReplace(paramList.a());
        continue;
        paramList = (MsgTabNodeInfo)localList.get(i);
      }
      finally
      {
        localEntityManager.getTransaction().end();
      }
    }
    localEntityManager.getTransaction().commit();
    localEntityManager.getTransaction().end();
  }
  
  public boolean a()
  {
    String str;
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      str = SharedPreUtils.r(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
          QLog.e("StoryHaloManager", 2, "getEnabled: failed. Message: exception: " + localException);
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
    }
  }
  
  public boolean a(@Nullable Object paramObject)
  {
    return false;
  }
  
  @Nullable
  public MsgTabNodeInfo b(@NonNull String paramString)
  {
    MsgTabHaloEntity localMsgTabHaloEntity = null;
    List localList = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, "unionId=?", new String[] { paramString }, null, null, null, null);
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "dbQueryUnionIdNode: invoked. Message: msgTabHaloEntities: " + localList);
    }
    paramString = localMsgTabHaloEntity;
    if (localList != null)
    {
      paramString = localMsgTabHaloEntity;
      if (localList.size() > 0)
      {
        localMsgTabHaloEntity = (MsgTabHaloEntity)localList.get(0);
        paramString = new MsgTabNodeInfo();
        paramString.a(localMsgTabHaloEntity);
      }
    }
    return paramString;
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (b()) {
        return;
      }
      List localList = a(this.jdField_a_of_type_JavaUtilSet, paramList);
      if (localList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilSet = new HashSet(paramList);
        a(paramInt, localList);
      }
      return;
    }
  }
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StoryHaloManager", 2, "tinkerHaloStateMap: invoked.  msgTabNodeInfo: " + paramMsgTabNodeInfo);
      }
      return;
    }
    long l = paramMsgTabNodeInfo.jdField_b_of_type_Long;
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), paramMsgTabNodeInfo);
  }
  
  public boolean b(@Nullable Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a(paramObject))
    {
      paramObject = (RecentItemChatMsgData)paramObject;
      if (paramObject.haloState != -1)
      {
        bool1 = bool2;
        if (paramObject.haloState != -2) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo.e == 1) {
      return;
    }
    QQStoryContext.a().a().createEntityManager().persistOrReplace(paramMsgTabNodeInfo.a());
  }
  
  public void d(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null) {}
    do
    {
      return;
      i = a(paramMsgTabNodeInfo);
    } while (i == -3);
    if (i == -1) {}
    for (int i = 1;; i = 2)
    {
      StoryReportor.a("msg_tab", "circle_exp", 0, i, new String[] { String.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Long) });
      return;
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StoryHaloManager", 2, "onDestroy: invoked.  this: " + this);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloBatchLoader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloBatchLoader.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager
 * JD-Core Version:    0.7.0.1
 */