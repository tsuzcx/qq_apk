package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest;
import com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.biz.qqstory.utils.RedPointUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;
import nhy;
import nia;
import nib;
import nic;
import nid;
import nie;
import nif;
import nig;

public class MsgTabNodeListLoader
{
  public Handler a;
  protected CmdTaskManger.CommandCallback a;
  public MsgTabStoryManager a;
  private GetUserInfoHandler.OnGetUserInfoCallback a;
  protected QQAppInterface a;
  public final Object a;
  public String a;
  public volatile ArrayList a;
  public Comparator a;
  protected HashMap a;
  protected ConcurrentHashMap a;
  public AtomicBoolean a;
  public boolean a;
  protected CmdTaskManger.CommandCallback b;
  protected final Object b;
  public String b;
  protected ArrayList b;
  boolean b;
  public final ArrayList c;
  boolean c;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  public boolean g = false;
  
  MsgTabNodeListLoader(QQAppInterface paramQQAppInterface, MsgTabStoryManager paramMsgTabStoryManager)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback = new nhy(this);
    this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback = new nia(this);
    this.jdField_b_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback = new nib(this);
    this.jdField_b_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    if (paramQQAppInterface == null) {
      SLog.c("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilComparator = new MsgTabNodeInfoComparator();
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager = paramMsgTabStoryManager;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
    e();
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "create new loader");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      paramQQAppInterface = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      int j = 0;
      while (j < paramQQAppInterface.jdField_a_of_type_JavaUtilList.size())
      {
        paramMsgTabStoryManager = (MsgTabNodeVideoInfo)paramQQAppInterface.jdField_a_of_type_JavaUtilList.get(j);
        String str = paramQQAppInterface.jdField_a_of_type_JavaLangString + "-" + paramMsgTabStoryManager.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(paramMsgTabStoryManager.jdField_a_of_type_Boolean));
        j += 1;
      }
      i += 1;
    }
  }
  
  private void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = 0;
    while (i < paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString + "-" + localMsgTabNodeVideoInfo.jdField_a_of_type_Long;
      localObject = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean = true;
      }
      i += 1;
    }
  }
  
  private void a(ArrayList paramArrayList) {}
  
  @NonNull
  private void a(List paramList)
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      String str = ((MsgTabNodeInfo)paramList.get(i)).jdField_a_of_type_JavaLangString;
      QQUserUIItem localQQUserUIItem = localUserManager.b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList.add(new QQUserUIItem.UserID("", str));
      }
      for (;;)
      {
        i += 1;
        break;
        a(localQQUserUIItem);
      }
    }
    if (!localArrayList.isEmpty())
    {
      new GetUserInfoHandler(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback).a(1, localArrayList);
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private boolean a(qqstory_service.MsgTabNodePushNotify arg1, boolean paramBoolean)
  {
    if (??? == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "realHandlePushMsg, msg is null!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", PBUtils.a(???) });
    }
    MsgTabNodeInfo localMsgTabNodeInfo1 = new MsgTabNodeInfo();
    localMsgTabNodeInfo1.a((qqstory_service.MsgTabNodeInfo)???.msg_notify_node_info.get());
    ??? = ???.bytes_current_seq.get().toStringUtf8();
    int i = ???.uint32_notify_type.get();
    boolean bool1;
    int j;
    if (???.uint32_animate.get() == 1)
    {
      bool1 = true;
      if (i != 1) {
        break label486;
      }
      if (localMsgTabNodeInfo1.jdField_a_of_type_Int == 5)
      {
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
        if (???.jdField_c_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo1);
          if (i == -1) {
            break label341;
          }
          localMsgTabNodeInfo1.a((MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if ((localMsgTabNodeInfo1.jdField_a_of_type_Int != 7) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo1) != -1)) {
        break label363;
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      for (;;)
      {
        if (i >= j) {
          break label363;
        }
        ??? = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((???.jdField_a_of_type_Int == 9) && (TextUtils.equals(localMsgTabNodeInfo1.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_JavaLangString))) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilArrayList.set(i, localMsgTabNodeInfo1);
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(???);
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(localMsgTabNodeInfo1);
            if (paramBoolean)
            {
              a(???, true, 3, bool1);
              a(localMsgTabNodeInfo1, true, 1, bool1);
            }
            StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo1.jdField_a_of_type_Int) });
            return true;
            bool1 = false;
            break;
            label341:
            localMsgTabNodeInfo1.a(???);
          }
        }
      }
      i += 1;
    }
    for (;;)
    {
      label363:
      boolean bool2;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        a(localMsgTabNodeInfo1);
        bool2 = b(localMsgTabNodeInfo1);
        a(Collections.singletonList(localMsgTabNodeInfo1));
        if (bool2)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(localMsgTabNodeInfo1);
          this.jdField_b_of_type_JavaLangString = ((String)???);
          if (paramBoolean) {
            a(localMsgTabNodeInfo1, true, 1, bool1);
          }
          StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo1.jdField_a_of_type_Int) });
        }
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localMsgTabNodeInfo1);
        paramBoolean = bool2;
        return paramBoolean;
      }
      label486:
      if (i == 2) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          bool2 = c(localMsgTabNodeInfo2);
          if (bool2)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(localMsgTabNodeInfo2);
            this.jdField_b_of_type_JavaLangString = ((String)???);
            if (paramBoolean) {
              a(localMsgTabNodeInfo2, true, 3, bool1);
            }
          }
          SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localMsgTabNodeInfo2);
          paramBoolean = bool2;
        }
      }
      paramBoolean = false;
    }
  }
  
  @GuardedBy("mLock")
  private boolean b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
    if (j != -1)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(j);
      if (paramMsgTabNodeInfo.jdField_c_of_type_Long >= localMsgTabNodeInfo.jdField_c_of_type_Long) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramMsgTabNodeInfo);
      }
    }
    else
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
    }
    while (i < j)
    {
      if (this.jdField_a_of_type_JavaUtilComparator.compare(paramMsgTabNodeInfo, this.jdField_a_of_type_JavaUtilArrayList.get(i)) <= 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(i, paramMsgTabNodeInfo);
        return true;
        return false;
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramMsgTabNodeInfo);
    return true;
  }
  
  @GuardedBy("mLock")
  private boolean c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
    if (i != -1)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramMsgTabNodeInfo.jdField_c_of_type_Long < localMsgTabNodeInfo.jdField_c_of_type_Long) {
        return false;
      }
    }
    return this.jdField_a_of_type_JavaUtilArrayList.remove(paramMsgTabNodeInfo);
  }
  
  private void e()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
    if (((MsgTabNodeInfo)localObject).jdField_c_of_type_Int > 0)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = a(((MsgTabNodeInfo)localObject).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject).jdField_a_of_type_JavaLangString);
      if (localMsgTabNodeInfo == null) {
        break label54;
      }
      localMsgTabNodeInfo.a((MsgTabNodeInfo)localObject);
      localObject = localMsgTabNodeInfo;
    }
    label54:
    for (;;)
    {
      a((MsgTabNodeInfo)localObject, false);
      return;
    }
  }
  
  public MsgTabNodeInfo a(int paramInt, String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    if (paramInt == -1)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      MsgTabNodeInfo localMsgTabNodeInfo;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
      } while (!TextUtils.equals(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, paramString));
      return localMsgTabNodeInfo;
    }
    paramString = new MsgTabNodeInfo(paramInt, paramString);
    paramInt = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
    if (paramInt != -1) {
      return (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public MsgTabNodeInfo a(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
      if (TextUtils.equals(paramString, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString)) {
        return localMsgTabNodeInfo;
      }
    }
    return null;
  }
  
  public ArrayList a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestLatestPage() is loading, ignore this request...");
      }
    }
    MsgTabNodeListRequest localMsgTabNodeListRequest;
    do
    {
      return;
      localMsgTabNodeListRequest = new MsgTabNodeListRequest();
      localMsgTabNodeListRequest.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      localMsgTabNodeListRequest.jdField_c_of_type_Int = paramInt;
      CmdTaskManger.a().a(localMsgTabNodeListRequest, this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", localMsgTabNodeListRequest.toString() });
  }
  
  public void a(QQUserUIItem paramQQUserUIItem)
  {
    if ((paramQQUserUIItem == null) || (TextUtils.isEmpty(paramQQUserUIItem.uid)) || (!paramQQUserUIItem.isAvailable()))
    {
      SLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalStateException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQUserUIItem.uid, paramQQUserUIItem);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean)
  {
    int i = 1;
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramMsgTabNodeInfo), Boolean.valueOf(paramBoolean));
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        bool = b(paramMsgTabNodeInfo);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramMsgTabNodeInfo);
          int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
          if (j == k) {
            break label163;
          }
          bool = true;
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "insertNode: hasChangePos=", Boolean.valueOf(bool), ", oldIndex=", Integer.valueOf(j), ", newIndex=", Integer.valueOf(k) });
          }
          if (paramBoolean)
          {
            if (!bool) {
              break label169;
            }
            a(paramMsgTabNodeInfo, false, i, false);
          }
        }
        return;
      }
      label163:
      boolean bool = false;
      continue;
      label169:
      i = 2;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(paramMsgTabNodeInfo), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i;
    if (paramInt == 1)
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
      i = j;
      if (j == -1) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 1, "insert position not found:" + paramMsgTabNodeInfo);
      }
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new nif(this, paramMsgTabNodeInfo, paramBoolean1, paramInt, i, paramBoolean2));
  }
  
  public void a(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      if (this.jdField_c_of_type_JavaUtilArrayList.contains(paramOnMsgTabNodeListLoadListener))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
      }
      this.jdField_c_of_type_JavaUtilArrayList.add(paramOnMsgTabNodeListLoadListener);
      return;
    }
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    boolean bool = QQStoryNetReqUtils.a();
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 1) && (!bool))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is not in testEnv", PBUtils.a(paramMsgTabNodePushNotify));
      return;
    }
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 0) && (bool))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is in testEnv", PBUtils.a(paramMsgTabNodePushNotify));
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg %s", PBUtils.a(paramMsgTabNodePushNotify));
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramMsgTabNodePushNotify);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "refreshing, add to waiting queue");
        }
        return;
      }
    }
    a(paramMsgTabNodePushNotify, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new QQStoryGuideRequest(paramString1, paramString2);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide request = " + paramString1.toString());
    }
    CmdTaskManger.a().a(paramString1, new nig(this));
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() dataList=%s, isFirstPage=%b, isEnd=%b, push=%b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3));
    this.jdField_a_of_type_AndroidOsHandler.post(new nie(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new nic(this, paramBoolean));
  }
  
  @GuardedBy("mLock")
  public boolean a()
  {
    boolean bool = false;
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      bool = false;
      while (localIterator.hasNext()) {
        bool |= a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false);
      }
      this.jdField_b_of_type_JavaUtilArrayList.clear();
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
      return bool;
    }
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfo(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    label52:
    if (i >= 0)
    {
      ??? = (MsgTabNodeVideoInfo)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if (((MsgTabNodeVideoInfo)???).jdField_a_of_type_Long == paramLong)
      {
        paramString.jdField_a_of_type_JavaUtilList.remove(i);
        bool1 = true;
      }
    }
    for (;;)
    {
      i -= 1;
      break label52;
      if (!((MsgTabNodeVideoInfo)???).jdField_a_of_type_Boolean)
      {
        paramInt += 1;
        continue;
        paramString.b = paramInt;
        if ((!bool1) && (QLog.isDevelopLevel())) {
          QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "deleteNodeVideoFromNodeInfo, nothing to delete", " info.unreadCount =", Integer.valueOf(paramString.b), ", info.videoInfoList=", paramString.jdField_a_of_type_JavaUtilList });
        }
        if (paramString.jdField_a_of_type_JavaUtilList.isEmpty()) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(paramString);
            a(paramString, false, 3, false);
            return bool1;
          }
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramString);
        a(paramString, false, 2, false);
        return bool1;
      }
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidList(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return MsgTabStoryManager.a(new MsgTabNodeInfo(paramInt, paramString1));
      paramString1 = paramString2;
    }
  }
  
  public boolean a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      boolean bool = c(paramMsgTabNodeInfo);
      if (bool)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(paramMsgTabNodeInfo);
        a(paramMsgTabNodeInfo, false, 3, false);
      }
      return bool;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    Object localObject;
    if (i >= 0)
    {
      localObject = (MsgTabNodeVideoInfo)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if ((((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Long == paramLong) && (!((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Boolean))
      {
        ((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Boolean = true;
        paramString.b -= 1;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramString.b <= 0) && (!paramString.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = new MsgTabNodeWatchedRequest();
        ((MsgTabNodeWatchedRequest)localObject).jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        ((MsgTabNodeWatchedRequest)localObject).jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
        ((MsgTabNodeWatchedRequest)localObject).d = 0;
        CmdTaskManger.a().a((NetworkRequest)localObject, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.jdField_a_of_type_JavaUtilList });
      }
      if (bool)
      {
        i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramString);
        if (i >= 0)
        {
          localObject = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((MsgTabNodeInfo)localObject).copy(paramString);
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a((MsgTabNodeInfo)localObject);
        }
        a(paramString, false, 2, false);
      }
      return bool;
      i -= 1;
      break;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {}
    return false;
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "no cookie, call requestLatestPage first");
      }
    }
    MsgTabNodeListRequest localMsgTabNodeListRequest;
    do
    {
      do
      {
        do
        {
          return;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "already ended");
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "already loading");
      return;
      localMsgTabNodeListRequest = new MsgTabNodeListRequest();
      localMsgTabNodeListRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      CmdTaskManger.a().a(localMsgTabNodeListRequest, this.jdField_b_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "send request: " + localMsgTabNodeListRequest.toString());
  }
  
  public void b(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.remove(paramOnMsgTabNodeListLoadListener);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new nid(this, paramBoolean));
  }
  
  @GuardedBy("mNotifyLock")
  public void c()
  {
    if (RedPointUtils.a(49) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.f = bool;
      if ((!this.d) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.d)
        {
          this.d = false;
          i = 1;
          if (i == 0) {
            break;
          }
          ((QQStoryHandler)QQStoryContext.a().getBusinessHandler(98)).a(1026, true, Boolean.valueOf(false));
          return;
        }
      }
      int i = 0;
    }
  }
  
  @GuardedBy("mNotifyLock")
  public void d()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_b_of_type_Boolean)
      {
        i = 1;
        if (i != 0)
        {
          ??? = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
          while (((Iterator)???).hasNext())
          {
            MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)???).next();
            if ((localMsgTabNodeInfo.b > 0) && (localMsgTabNodeInfo.jdField_a_of_type_Int == 6)) {
              this.e = true;
            }
          }
          ((QQStoryHandler)QQStoryContext.a().getBusinessHandler(98)).a(1026, true, Boolean.valueOf(false));
        }
        return;
      }
      this.d = true;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader
 * JD-Core Version:    0.7.0.1
 */