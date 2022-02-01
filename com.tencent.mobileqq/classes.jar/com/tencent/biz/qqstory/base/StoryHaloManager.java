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
    if (!bool1) {
      return -3;
    }
    boolean bool2 = c(paramMsgTabNodeInfo);
    if (!bool2) {
      return -3;
    }
    boolean bool3 = a(paramMsgTabNodeInfo);
    if (QLog.isColorLevel())
    {
      paramMsgTabNodeInfo = new StringBuilder();
      paramMsgTabNodeInfo.append("tellHaloState: invoked. Message: storyNodeRecently: ");
      paramMsgTabNodeInfo.append(bool2);
      paramMsgTabNodeInfo.append(" storyNodeVideoAllRead: ");
      paramMsgTabNodeInfo.append(bool3);
      paramMsgTabNodeInfo.append(" storyVideoExisted: ");
      paramMsgTabNodeInfo.append(bool1);
      QLog.i("StoryHaloManager", 2, paramMsgTabNodeInfo.toString());
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
    int i = (int)(paramLong / 86400) * 86400;
    if (QLog.isColorLevel())
    {
      Object localObject = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      ((SimpleDateFormat)localObject).setTimeZone(TimeZone.getTimeZone("UTC+8"));
      localObject = ((SimpleDateFormat)localObject).format(new Date(i * 1000L));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("todayDawnSecond: invoked. Message: wholeDaySecond: ");
      localStringBuilder.append(i);
      localStringBuilder.append(" format: ");
      localStringBuilder.append((String)localObject);
      QLog.i("StoryHaloManager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private List<Long> a(Set<Long> paramSet, List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramSet == null) && (paramList == null)) {
      return localArrayList;
    }
    if ((paramSet == null) && (paramList != null)) {
      return paramList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Long localLong = (Long)paramList.next();
      if (!paramSet.contains(localLong)) {
        localArrayList.add(localLong);
      }
    }
    return localArrayList;
  }
  
  private boolean a(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null) {
      return true;
    }
    return paramMsgTabNodeInfo.jdField_b_of_type_Int <= 0;
  }
  
  private void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init: invoked.  this: ");
      localStringBuilder.append(this);
      QLog.i("StoryHaloManager", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(99);
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloBatchLoader = new RecentTabHaloBatchLoader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseJsonConfig: invoked. Message: json: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      this.jdField_a_of_type_JavaLangDouble = Double.valueOf(0.0D);
      return;
    }
    Object localObject = new JSONObject(paramString);
    if (((JSONObject)localObject).optInt("enabled") == 1) {
      paramString = Boolean.TRUE;
    } else {
      paramString = Boolean.FALSE;
    }
    this.jdField_a_of_type_JavaLangBoolean = paramString;
    this.jdField_a_of_type_JavaLangDouble = Double.valueOf(((JSONObject)localObject).optDouble("timeout_day", 0.0D));
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
    boolean bool = false;
    if (paramMsgTabNodeInfo == null) {
      return false;
    }
    if (paramMsgTabNodeInfo.a.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean c(@Nullable MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (paramMsgTabNodeInfo == null) {
      return false;
    }
    long l1 = NetConnInfoCenter.getServerTime();
    long l2 = paramMsgTabNodeInfo.d;
    long l3 = a(l2);
    long l4 = a();
    if (QLog.isColorLevel())
    {
      paramMsgTabNodeInfo = new StringBuilder();
      paramMsgTabNodeInfo.append("isStoryNodeRecently: invoked. Message: timeoutSecond: ");
      paramMsgTabNodeInfo.append(l4);
      paramMsgTabNodeInfo.append(" serverTime: ");
      paramMsgTabNodeInfo.append(l1);
      paramMsgTabNodeInfo.append(" nodeInfoTimeStamp: ");
      paramMsgTabNodeInfo.append(l2);
      QLog.i("StoryHaloManager", 2, paramMsgTabNodeInfo.toString());
    }
    return l1 - l3 < l4;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_JavaLangDouble == null)
    {
      String str = SharedPreUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      try
      {
        b(str);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getEnabled: failed. Message: exception: ");
          localStringBuilder.append(localException);
          QLog.e("StoryHaloManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaLangDouble = Double.valueOf(0.0D);
      }
    }
    double d1 = 86400;
    double d2 = this.jdField_a_of_type_JavaLangDouble.doubleValue();
    Double.isNaN(d1);
    return (d1 * d2);
  }
  
  @Nullable
  public MsgTabNodeInfo a(@NonNull MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), MsgTabHaloEntity.getSelectionArgs(paramMsgTabNodeInfo), null, null, null, null);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dbQueryUserNode: invoked. Message: msgTabHaloEntities: ");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramMsgTabNodeInfo != null) && (paramMsgTabNodeInfo.size() > 0))
    {
      paramMsgTabNodeInfo = (MsgTabHaloEntity)paramMsgTabNodeInfo.get(0);
      localObject = new MsgTabNodeInfo();
      ((MsgTabNodeInfo)localObject).a(paramMsgTabNodeInfo);
      return localObject;
    }
    return null;
  }
  
  @Nullable
  public MsgTabNodeInfo a(@NonNull String paramString)
  {
    paramString = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, MsgTabHaloEntity.getSelection(), new String[] { paramString }, null, null, null, null);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dbQueryUinNode: invoked. Message: msgTabHaloEntities: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = (MsgTabHaloEntity)paramString.get(0);
      localObject = new MsgTabNodeInfo();
      ((MsgTabNodeInfo)localObject).a(paramString);
      return localObject;
    }
    return null;
  }
  
  public List<MsgTabNodeInfo> a()
  {
    Object localObject2 = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("dbQueryAllNode: invoked. Message: entities: ");
      ((StringBuilder)localObject1).append(localObject2);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    if (localObject2 == null) {
      return localObject1;
    }
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      MsgTabHaloEntity localMsgTabHaloEntity = (MsgTabHaloEntity)((Iterator)localObject2).next();
      MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
      localMsgTabNodeInfo.a(localMsgTabHaloEntity);
      ((ArrayList)localObject1).add(localMsgTabNodeInfo);
    }
    return localObject1;
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getFriendUins: failed.  exception: ");
          localStringBuilder.append(localNumberFormatException);
          QLog.e("StoryHaloManager", 1, localStringBuilder.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick: invoked. Message: uin: ");
      localStringBuilder.append(paramRecentItemChatMsgData.getRecentUserUin());
      QLog.i("StoryHaloManager", 2, localStringBuilder.toString());
    }
    Bosses.get().postLightWeightJob(new StoryHaloManager.2(this, paramRecentItemChatMsgData, paramView), 0);
  }
  
  public void a(@NonNull MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handlePushPacket: invoked. Message: msgTabNodeInfo: ");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
    }
    d(paramMsgTabNodeInfo);
    Object localObject = a(paramMsgTabNodeInfo);
    if ((localObject != null) && (((MsgTabNodeInfo)localObject).c < paramMsgTabNodeInfo.c))
    {
      c(paramMsgTabNodeInfo);
      b(paramMsgTabNodeInfo);
      return;
    }
    if (localObject == null)
    {
      c(paramMsgTabNodeInfo);
      b(paramMsgTabNodeInfo);
    }
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("assignHaloState: invoked. Message: haloState: ");
        localStringBuilder.append(i);
        localStringBuilder.append(" uin: ");
        localStringBuilder.append(l);
        localStringBuilder.append(" msgTabNodeInfo: ");
        localStringBuilder.append(localObject);
        QLog.i("StoryHaloManager", 2, localStringBuilder.toString());
      }
      paramRecentItemChatMsgData.haloState = i;
      return;
    }
    catch (NumberFormatException paramRecentItemChatMsgData)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("assignHaloState: failed.  exception: ");
      ((StringBuilder)localObject).append(paramRecentItemChatMsgData);
      QLog.e("StoryHaloManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(ConfigurationService.Config paramConfig)
  {
    int i = paramConfig.version.get();
    int j = SharedPreUtils.az(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (i != j)
    {
      Object localObject = ConfigServlet.b(paramConfig, j, paramConfig.type.get());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleConfig: invoked. Message: configJson: ");
        localStringBuilder.append((String)localObject);
        QLog.i("StoryHaloManager", 2, localStringBuilder.toString());
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      SharedPreUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramConfig.version.get(), (String)localObject);
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
          QLog.e("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
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
      Object localObject = (MsgTabNodeInfo)paramList.next();
      if (((MsgTabNodeInfo)localObject).e != 1)
      {
        b((MsgTabNodeInfo)localObject);
      }
      else
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localConcurrentHashMap.get(Long.valueOf(((MsgTabNodeInfo)localObject).jdField_b_of_type_Long));
        if (localMsgTabNodeInfo == null)
        {
          localMsgTabNodeInfo = a(String.valueOf(((MsgTabNodeInfo)localObject).jdField_b_of_type_Long));
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateHaloStateMap: invoked. use db cache. dbMsgNode: ");
            ((StringBuilder)localObject).append(localMsgTabNodeInfo);
            QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
          }
          b(localMsgTabNodeInfo);
        }
        else
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("updateHaloStateMap: invoked. use memory cache. backupNode: ");
            ((StringBuilder)localObject).append(localMsgTabNodeInfo);
            QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
          }
          b(localMsgTabNodeInfo);
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
    try
    {
      Object localObject = new MsgTabHaloEntity();
      ((MsgTabHaloEntity)localObject).setStatus(1001);
      localEntityManager.remove((Entity)localObject, null, null);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (MsgTabNodeInfo)localIterator.next();
        paramList = (List<MsgTabNodeInfo>)localObject;
        if (((MsgTabNodeInfo)localObject).e == 1)
        {
          int i = a(localList, (MsgTabNodeInfo)localObject);
          if (i == -1)
          {
            paramList = (List<MsgTabNodeInfo>)localObject;
            if (QLog.isColorLevel())
            {
              paramList = new StringBuilder();
              paramList.append("dbBuildAllNodes: failed.  exception: info: ");
              paramList.append(localObject);
              QLog.e("StoryHaloManager", 2, paramList.toString());
              paramList = (List<MsgTabNodeInfo>)localObject;
            }
          }
          else
          {
            paramList = (MsgTabNodeInfo)localList.get(i);
          }
        }
        localEntityManager.persistOrReplace(paramList.a());
      }
      localEntityManager.getTransaction().commit();
      localEntityManager.getTransaction().end();
      return;
    }
    finally
    {
      localEntityManager.getTransaction().end();
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null)
    {
      String str = SharedPreUtils.n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      try
      {
        b(str);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getEnabled: failed. Message: exception: ");
          localStringBuilder.append(localException);
          QLog.e("StoryHaloManager", 2, localStringBuilder.toString());
        }
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
      }
    }
    return Boolean.TRUE.equals(this.jdField_a_of_type_JavaLangBoolean);
  }
  
  public boolean a(@Nullable Object paramObject)
  {
    return false;
  }
  
  @Nullable
  public MsgTabNodeInfo b(@NonNull String paramString)
  {
    paramString = QQStoryContext.a().a().createEntityManager().query(MsgTabHaloEntity.class, MsgTabHaloEntity.class.getSimpleName(), false, "unionId=?", new String[] { paramString }, null, null, null, null);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dbQueryUnionIdNode: invoked. Message: msgTabHaloEntities: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = (MsgTabHaloEntity)paramString.get(0);
      localObject = new MsgTabNodeInfo();
      ((MsgTabNodeInfo)localObject).a(paramString);
      return localObject;
    }
    return null;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("tinkerHaloStateMap: invoked.  msgTabNodeInfo: ");
        localStringBuilder.append(paramMsgTabNodeInfo);
        QLog.i("StoryHaloManager", 2, localStringBuilder.toString());
      }
      return;
    }
    long l = paramMsgTabNodeInfo.jdField_b_of_type_Long;
    this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(l), paramMsgTabNodeInfo);
  }
  
  public boolean b(@Nullable Object paramObject)
  {
    boolean bool3 = a(paramObject);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
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
    if (paramMsgTabNodeInfo == null) {
      return;
    }
    int i = a(paramMsgTabNodeInfo);
    if (i != -3)
    {
      if (i == -1) {
        i = 1;
      } else {
        i = 2;
      }
      StoryReportor.a("msg_tab", "circle_exp", 0, i, new String[] { String.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Long) });
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroy: invoked.  this: ");
      ((StringBuilder)localObject).append(this);
      QLog.i("StoryHaloManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerRecentTabHaloBatchLoader;
    if (localObject != null) {
      ((RecentTabHaloBatchLoader)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryHaloManager
 * JD-Core Version:    0.7.0.1
 */