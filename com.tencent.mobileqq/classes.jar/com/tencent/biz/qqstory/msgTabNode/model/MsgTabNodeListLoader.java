package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest;
import com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.observer.GetRedPointExObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import neb;
import nec;
import ned;
import nef;
import neg;
import neh;
import nei;
import nej;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public class MsgTabNodeListLoader
{
  protected Handler a;
  protected CmdTaskManger.CommandCallback a;
  public MsgTabStoryManager a;
  protected QQAppInterface a;
  protected GetRedPointExObserver a;
  public final Object a;
  public String a;
  public volatile ArrayList a;
  public Comparator a;
  protected HashMap a;
  public AtomicBoolean a;
  public boolean a;
  protected CmdTaskManger.CommandCallback b;
  public String b;
  protected ArrayList b;
  public ArrayList c = new ArrayList();
  
  MsgTabNodeListLoader(QQAppInterface paramQQAppInterface, MsgTabStoryManager paramMsgTabStoryManager)
  {
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback = new neb(this);
    this.jdField_b_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback = new nec(this);
    this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver = new ned(this);
    this.jdField_a_of_type_JavaUtilComparator = new MsgTabNodeInfoComparator();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager = paramMsgTabStoryManager;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
    c();
    a(false, false);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.nodeList", 2, "create new loader");
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
  
  private boolean a(qqstory_service.MsgTabNodePushNotify arg1, boolean paramBoolean)
  {
    if (??? == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.msgTab.nodeList", 2, "realHandlePushMsg, msg is null!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.nodeList", 2, "receive push!");
    }
    MsgTabNodeInfo localMsgTabNodeInfo1 = new MsgTabNodeInfo();
    localMsgTabNodeInfo1.a((qqstory_service.MsgTabNodeInfo)???.msg_notify_node_info.get());
    ??? = ???.bytes_current_seq.get().toStringUtf8();
    int i = ???.uint32_notify_type.get();
    if (i == 1)
    {
      if (localMsgTabNodeInfo1.jdField_a_of_type_Int == 5)
      {
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
        if (???.jdField_c_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo1);
          if (i == -1) {
            break label300;
          }
          localMsgTabNodeInfo1.a((MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if ((localMsgTabNodeInfo1.jdField_a_of_type_Int == 7) && (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo1) == -1))
      {
        int j = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        while (i < j)
        {
          for (;;)
          {
            ??? = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            if ((???.jdField_a_of_type_Int == 9) && (TextUtils.equals(localMsgTabNodeInfo1.jdField_a_of_type_JavaLangString, ???.jdField_a_of_type_JavaLangString))) {
              synchronized (this.jdField_a_of_type_JavaLangObject)
              {
                this.jdField_a_of_type_JavaUtilArrayList.set(i, localMsgTabNodeInfo1);
                this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(???);
                this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(localMsgTabNodeInfo1);
                if (paramBoolean)
                {
                  a(???, true, 3);
                  a(localMsgTabNodeInfo1, true, 1);
                }
                StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo1.jdField_a_of_type_Int) });
                return true;
                label300:
                localMsgTabNodeInfo1.a(???);
              }
            }
          }
          i += 1;
        }
      }
    }
    for (;;)
    {
      boolean bool;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        a(localMsgTabNodeInfo1);
        bool = b(localMsgTabNodeInfo1);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(localMsgTabNodeInfo1);
          this.jdField_b_of_type_JavaLangString = ((String)???);
          if (paramBoolean) {
            a(localMsgTabNodeInfo1, true, 1);
          }
          StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo1.jdField_a_of_type_Int) });
        }
        paramBoolean = bool;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.qqstory.msgTab.nodeList", 2, new Object[] { "insert push done, change=", Boolean.valueOf(bool), ", mSeq=", this.jdField_b_of_type_JavaLangString, ", data = ", localMsgTabNodeInfo1 });
          paramBoolean = bool;
        }
        return paramBoolean;
      }
      if (i == 2) {
        synchronized (this.jdField_a_of_type_JavaLangObject)
        {
          bool = c(localMsgTabNodeInfo2);
          if (bool)
          {
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(localMsgTabNodeInfo2);
            this.jdField_b_of_type_JavaLangString = ((String)???);
            if (paramBoolean) {
              a(localMsgTabNodeInfo2, true, 3);
            }
          }
          paramBoolean = bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.qqstory.msgTab.nodeList", 2, new Object[] { "remove push, mSeq=", this.jdField_b_of_type_JavaLangString, ",  change=" + bool, ", data = ", localMsgTabNodeInfo2 });
          paramBoolean = bool;
        }
      }
      paramBoolean = false;
    }
  }
  
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
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
    if (((MsgTabNodeInfo)localObject).jdField_c_of_type_Int > 0)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = a(((MsgTabNodeInfo)localObject).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject).jdField_a_of_type_JavaLangString);
      if (localMsgTabNodeInfo == null) {
        break label46;
      }
      localMsgTabNodeInfo.a((MsgTabNodeInfo)localObject);
      localObject = localMsgTabNodeInfo;
    }
    label46:
    for (;;)
    {
      a((MsgTabNodeInfo)localObject, false);
      return;
    }
  }
  
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
  
  public MsgTabNodeInfo a(int paramInt, long paramLong)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
      if ((paramLong == localMsgTabNodeInfo.jdField_b_of_type_Long) && (paramInt == localMsgTabNodeInfo.jdField_a_of_type_Int)) {
        return localMsgTabNodeInfo;
      }
    }
    return null;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqObserverGetRedPointExObserver);
    this.c.clear();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.nodeList", 2, "already loading");
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
    QLog.d("Q.qqstory.msgTab.nodeList", 2, "send request: " + localMsgTabNodeListRequest.toString());
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean)
  {
    int i = 1;
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
            break label146;
          }
          bool = true;
          if (QLog.isDevelopLevel()) {
            QLog.d("Q.qqstory.msgTab.nodeList", 2, new Object[] { "insertNode: hasChangePos=", Boolean.valueOf(bool), ", oldIndex=", Integer.valueOf(j), ", newIndex=", Integer.valueOf(k) });
          }
          if (paramBoolean)
          {
            if (!bool) {
              break label152;
            }
            a(paramMsgTabNodeInfo, false, i);
          }
        }
        return;
      }
      label146:
      boolean bool = false;
      continue;
      label152:
      i = 2;
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean, int paramInt)
  {
    int i;
    if (paramInt == 1)
    {
      int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
      i = j;
      if (j == -1) {
        QLog.e("Q.qqstory.msgTab.nodeList", 1, "insert position not found:" + paramMsgTabNodeInfo);
      }
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new nei(this, paramMsgTabNodeInfo, paramBoolean, paramInt, i));
  }
  
  public void a(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    if (this.c.contains(paramOnMsgTabNodeListLoadListener))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.nodeList", 2, "listener already exist");
      }
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.nodeList", 2, new Object[] { "add listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
    }
    this.c.add(paramOnMsgTabNodeListLoadListener);
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_JavaUtilArrayList.add(paramMsgTabNodePushNotify);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.nodeList", 2, "refreshing, add to waiting queue");
        }
        return;
      }
    }
    a(paramMsgTabNodePushNotify, true);
  }
  
  public void a(String paramString)
  {
    paramString = new QQStoryGuideRequest(paramString);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.nodeList", 2, "requestQQStoryGuide request = " + paramString.toString());
    }
    CmdTaskManger.a().a(paramString, new nej(this));
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new neh(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new nef(this, paramBoolean));
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        boolean bool = false;
        while (localIterator.hasNext()) {
          bool |= a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false);
        }
        this.jdField_b_of_type_JavaUtilArrayList.clear();
        return bool;
      }
    }
    return false;
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    label35:
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
      break label35;
      if (!((MsgTabNodeVideoInfo)???).jdField_a_of_type_Boolean)
      {
        paramInt += 1;
        continue;
        paramString.jdField_b_of_type_Int = paramInt;
        if ((!bool1) && (QLog.isDevelopLevel())) {
          QLog.e("Q.qqstory.msgTab.nodeList", 2, new Object[] { "deleteNodeVideoFromNodeInfo, nothing to delete", " info.unreadCount =", Integer.valueOf(paramString.jdField_b_of_type_Int), ", info.videoInfoList=", paramString.jdField_a_of_type_JavaUtilList });
        }
        if (paramString.jdField_a_of_type_JavaUtilList.isEmpty()) {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(paramString);
            a(paramString, false, 3);
            return bool1;
          }
        }
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramString);
        a(paramString, false, 2);
        return bool1;
      }
    }
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
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
        a(paramMsgTabNodeInfo, false, 3);
      }
      return bool;
    }
  }
  
  public boolean a(String paramString, long paramLong)
  {
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
        paramString.jdField_b_of_type_Int -= 1;
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((paramString.jdField_b_of_type_Int <= 0) && (!paramString.jdField_a_of_type_JavaUtilList.isEmpty()))
      {
        localObject = new MsgTabNodeWatchedRequest();
        ((MsgTabNodeWatchedRequest)localObject).jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
        ((MsgTabNodeWatchedRequest)localObject).jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
        ((MsgTabNodeWatchedRequest)localObject).d = 0;
        CmdTaskManger.a().a((NetworkRequest)localObject, null);
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.nodeList", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.jdField_a_of_type_JavaUtilList });
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
        a(paramString, false, 2);
      }
      return bool;
      i -= 1;
      break;
    }
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    boolean bool1;
    if (??? == null) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo(2);
      ??? = ((TroopRedTouchManager)((QQAppInterface)???).getManager(69)).a(48);
      boolean bool2;
      if (??? != null)
      {
        int i = ((oidb_0x791.RedDotInfo)???).uint32_number.get();
        bool1 = ((oidb_0x791.RedDotInfo)???).bool_display_reddot.get();
        long l = ((oidb_0x791.RedDotInfo)???).uint32_last_time.get();
        if ((i > 0) && (bool1))
        {
          localMsgTabNodeInfo.jdField_b_of_type_Int = i;
          localMsgTabNodeInfo.jdField_c_of_type_Long = l;
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            bool2 = b(localMsgTabNodeInfo);
            bool1 = bool2;
            if (!bool2) {
              continue;
            }
            bool1 = bool2;
            if (!paramBoolean1) {
              continue;
            }
            a(localMsgTabNodeInfo, paramBoolean2, 1);
            return bool2;
          }
        }
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        bool2 = this.jdField_a_of_type_JavaUtilArrayList.remove(localObject1);
        bool1 = bool2;
        if (!bool2) {
          continue;
        }
        bool1 = bool2;
        if (!paramBoolean1) {
          continue;
        }
        a(localObject1, paramBoolean2, 3);
        return bool2;
      }
    }
  }
  
  public void b()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.nodeList", 2, "no cookie, call requestLatestPage first");
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
        QLog.d("Q.qqstory.msgTab.nodeList", 2, "already ended");
        return;
        if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.compareAndSet(false, true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgTab.nodeList", 2, "already loading");
      return;
      localMsgTabNodeListRequest = new MsgTabNodeListRequest();
      localMsgTabNodeListRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      CmdTaskManger.a().a(localMsgTabNodeListRequest, this.jdField_b_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.nodeList", 2, "send request: " + localMsgTabNodeListRequest.toString());
  }
  
  public void b(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    this.c.remove(paramOnMsgTabNodeListLoadListener);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.nodeList", 2, new Object[] { "remove listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new neg(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader
 * JD-Core Version:    0.7.0.1
 */