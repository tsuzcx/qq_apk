package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.annotation.WorkerThread;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.StoryVideoPublishStatusEvent;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.QQUserUIItem.UserID;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeListRequest.MsgTabNodeListResponse;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabNodeWatchedRequest;
import com.tencent.biz.qqstory.msgTabNode.network.QQStoryGuideRequest;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.OnGetUserInfoCallback;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_service.MsgTabNodePushNotify;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.QQStoryNetReqUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.PBUtils;
import com.tencent.biz.qqstory.utils.RedPointUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.reactive.Stream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

public class MsgTabNodeListLoader
{
  protected static Comparator<MsgTabNodeInfo> a;
  protected static Comparator<MsgTabNodeInfo> b;
  protected Handler a;
  protected HandlerThread a;
  protected CmdTaskManger.CommandCallback<MsgTabNodeListRequest, MsgTabNodeListRequest.MsgTabNodeListResponse> a;
  protected MsgTabStoryManager a;
  private GetUserInfoHandler.OnGetUserInfoCallback a;
  protected final Object a;
  protected String a;
  protected volatile ArrayList<MsgTabNodeInfo> a;
  protected HashMap<String, Boolean> a;
  protected Set<String> a;
  protected ConcurrentHashMap<String, QQUserUIItem> a;
  protected AtomicBoolean a;
  protected boolean a;
  protected Handler b;
  protected String b;
  protected volatile ArrayList<MsgTabNodeInfo> b;
  boolean b;
  protected ArrayList<qqstory_service.MsgTabNodePushNotify> c;
  boolean c;
  protected final ArrayList<MsgTabNodeListLoader.OnMsgTabNodeListLoadListener> d;
  boolean d;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new MsgTabNodeInfoComparator();
    jdField_b_of_type_JavaUtilComparator = new MsgTabNodeInfoPositionComparator();
  }
  
  MsgTabNodeListLoader(QQAppInterface paramQQAppInterface, MsgTabStoryManager paramMsgTabStoryManager)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new ArraySet());
    this.jdField_c_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_d_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidOsHandlerThread = ((HandlerThread)ThreadManagerV2.getRecentThread());
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback = new MsgTabNodeListLoader.1(this);
    this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback = new MsgTabNodeListLoader.2(this);
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListLoader ctor()");
    if (paramQQAppInterface == null) {
      SLog.c("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager = paramMsgTabStoryManager;
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
    a(this.jdField_a_of_type_JavaUtilArrayList, true);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_AndroidOsHandler = new MsgTabNodeListLoader.MsgTabWorkThreadHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
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
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramQQAppInterface.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramMsgTabStoryManager.jdField_a_of_type_Long);
        localObject = ((StringBuilder)localObject).toString();
        this.jdField_a_of_type_JavaUtilHashMap.put(localObject, Boolean.valueOf(paramMsgTabStoryManager.jdField_a_of_type_Boolean));
        j += 1;
      }
      i += 1;
    }
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.5(this));
  }
  
  private void a(ArrayList<MsgTabNodeInfo> paramArrayList) {}
  
  private static void a(ArrayList<MsgTabNodeInfo> paramArrayList, boolean paramBoolean)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() listSize=%d, sortOriginList=%b", Integer.valueOf(paramArrayList.size()), Boolean.valueOf(paramBoolean));
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramArrayList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
      if (localMsgTabNodeInfo.jdField_c_of_type_Int > 0)
      {
        localArrayList.add(localMsgTabNodeInfo);
        ((Iterator)localObject).remove();
      }
    }
    if (paramBoolean) {
      Collections.sort(paramArrayList, jdField_a_of_type_JavaUtilComparator);
    }
    if (localArrayList.size() > 0)
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, jdField_b_of_type_JavaUtilComparator);
      int i = 0;
      while (i < paramArrayList.size())
      {
        localObject = (MsgTabNodeInfo)paramArrayList.get(i);
        if ((((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 1) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 4) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 3))
        {
          SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i));
          break label196;
        }
        i += 1;
      }
      i = -1;
      label196:
      int j = i;
      if (i == -1) {
        j = paramArrayList.size();
      }
      i = 0;
      while (i < localArrayList.size())
      {
        localObject = (MsgTabNodeInfo)localArrayList.get(i);
        if (((MsgTabNodeInfo)localObject).jdField_c_of_type_Int > 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        AssertUtils.assertTrue(paramBoolean, "position must be greater than 0");
        int k = Math.min(((MsgTabNodeInfo)localObject).jdField_c_of_type_Int + j - 1, paramArrayList.size());
        paramArrayList.add(k, localObject);
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(k));
        i += 1;
      }
    }
  }
  
  private boolean a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramMsgTabNodePushNotify == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "realHandlePushMsg, msg is null!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", PBUtils.a(paramMsgTabNodePushNotify) });
    }
    MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
    localMsgTabNodeInfo.a((qqstory_service.MsgTabNodeInfo)paramMsgTabNodePushNotify.msg_notify_node_info.get());
    String str = paramMsgTabNodePushNotify.bytes_current_seq.get().toStringUtf8();
    int i = paramMsgTabNodePushNotify.uint32_notify_type.get();
    boolean bool1;
    if (paramMsgTabNodePushNotify.uint32_animate.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (i == 1)
    {
      if (localMsgTabNodeInfo.jdField_a_of_type_Int == 5)
      {
        paramMsgTabNodePushNotify = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
        if (paramMsgTabNodePushNotify.jdField_d_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo);
          if (i != -1) {
            localMsgTabNodeInfo.a((MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          } else {
            localMsgTabNodeInfo.a(paramMsgTabNodePushNotify);
          }
        }
      }
      if ((localMsgTabNodeInfo.jdField_a_of_type_Int == 7) && (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo) == -1))
      {
        int j = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        while (i < j)
        {
          paramMsgTabNodePushNotify = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((paramMsgTabNodePushNotify.jdField_a_of_type_Int == 9) && (TextUtils.equals(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, paramMsgTabNodePushNotify.jdField_a_of_type_JavaLangString)))
          {
            this.jdField_a_of_type_JavaUtilArrayList.set(i, localMsgTabNodeInfo);
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(paramMsgTabNodePushNotify);
            this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(localMsgTabNodeInfo);
            if (paramBoolean)
            {
              a(paramMsgTabNodePushNotify, true, 3, bool1);
              a(localMsgTabNodeInfo, true, 1, bool1);
            }
            StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo.jdField_a_of_type_Int) });
            return true;
          }
          i += 1;
        }
      }
      c(localMsgTabNodeInfo);
      bool2 = b(localMsgTabNodeInfo);
      c(Collections.singletonList(localMsgTabNodeInfo));
      b(Collections.singletonList(localMsgTabNodeInfo));
      if (bool2)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(localMsgTabNodeInfo);
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_b_of_type_JavaLangString = str;
        if (paramBoolean) {
          a(localMsgTabNodeInfo, true, 1, bool1);
        }
        StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo.jdField_a_of_type_Int) });
      }
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localMsgTabNodeInfo);
      return bool2;
    }
    if (i == 2)
    {
      bool2 = c(localMsgTabNodeInfo);
      if (bool2)
      {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(localMsgTabNodeInfo);
        this.jdField_b_of_type_JavaLangString = str;
        if (paramBoolean) {
          a(localMsgTabNodeInfo, true, 3, bool1);
        }
      }
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.jdField_b_of_type_JavaLangString, localMsgTabNodeInfo);
    }
    return bool2;
  }
  
  public static boolean a(List<MsgTabNodeInfo> paramList1, List<MsgTabNodeInfo> paramList2)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    Object localObject3;
    while (i < paramList1.size())
    {
      localObject1 = ((MsgTabNodeInfo)paramList1.get(i)).jdField_a_of_type_JavaLangString;
      if (((MsgTabNodeInfo)paramList1.get(i)).jdField_a_of_type_Int != 12)
      {
        localObject2 = ((MsgTabNodeInfo)paramList1.get(i)).jdField_a_of_type_JavaUtilList;
        j = 0;
        while (j < ((List)localObject2).size())
        {
          localObject3 = (MsgTabNodeVideoInfo)((List)localObject2).get(j);
          if (!((MsgTabNodeVideoInfo)localObject3).jdField_a_of_type_Boolean)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("-");
            localStringBuilder.append(((MsgTabNodeVideoInfo)localObject3).jdField_a_of_type_Long);
            localHashSet.add(localStringBuilder.toString());
          }
          j += 1;
        }
      }
      i += 1;
    }
    i = 0;
    while (i < paramList2.size())
    {
      paramList1 = ((MsgTabNodeInfo)paramList2.get(i)).jdField_a_of_type_JavaLangString;
      if (((MsgTabNodeInfo)paramList2.get(i)).jdField_a_of_type_Int != 12)
      {
        localObject1 = ((MsgTabNodeInfo)paramList2.get(i)).jdField_a_of_type_JavaUtilList;
        j = 0;
        while (j < ((List)localObject1).size())
        {
          localObject2 = (MsgTabNodeVideoInfo)((List)localObject1).get(j);
          if (!((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramList1);
            ((StringBuilder)localObject3).append("-");
            ((StringBuilder)localObject3).append(((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long);
            if (!localHashSet.contains(((StringBuilder)localObject3).toString())) {
              return true;
            }
          }
          j += 1;
        }
      }
      i += 1;
    }
    return false;
  }
  
  private boolean a(List<String> paramList, boolean paramBoolean)
  {
    boolean bool = paramList.isEmpty();
    int i = 0;
    if (bool)
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    ArrayList localArrayList = new ArrayList();
    bool = false;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = localUserManager.b(str);
      if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable()))
      {
        a(localQQUserUIItem);
        bool = true;
      }
      else
      {
        localArrayList.add(new QQUserUIItem.UserID("", str));
      }
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        new GetUserInfoHandler(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback).a(1, localArrayList);
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() Will fetch %s users", localArrayList);
        return bool;
      }
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() miss %s users, did not find in db, won't request", localArrayList);
      return bool;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() All nodes has local cache, no need request");
    return bool;
  }
  
  @WorkerThread
  private void b(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    if (SLog.a()) {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "onHandlePushMsg %s", PBUtils.a(paramMsgTabNodePushNotify));
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      this.jdField_c_of_type_JavaUtilArrayList.add(paramMsgTabNodePushNotify);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "refreshing, add to waiting queue");
      }
    }
    else
    {
      a(paramMsgTabNodePushNotify, true);
    }
  }
  
  private void b(List<MsgTabNodeInfo> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int j = 0;
    int i = 0;
    while ((j < paramList.size()) && (i < 8))
    {
      int k = j + 1;
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)paramList.get(j);
      if (localMsgTabNodeInfo.jdField_b_of_type_Int == 0)
      {
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(j));
        break;
      }
      if ((localMsgTabNodeInfo.jdField_a_of_type_Int == 6) || (localMsgTabNodeInfo.jdField_a_of_type_Int == 9) || (localMsgTabNodeInfo.jdField_a_of_type_Int == 7) || (localMsgTabNodeInfo.jdField_a_of_type_Int == 5))
      {
        Iterator localIterator = localMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.iterator();
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
        do
        {
          boolean bool = localIterator.hasNext();
          j = 1;
          if (!bool) {
            break;
          }
          localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
          if (TextUtils.isEmpty(localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString))
          {
            localArrayList1.add(localMsgTabNodeInfo);
            i += 1;
            SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(k));
            break label245;
          }
        } while (localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean);
        localArrayList2.add(localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString);
        i += 1;
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(k), localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString);
        break label245;
        j = 0;
        label245:
        if (j == 0)
        {
          SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(k));
          break;
        }
      }
      j = k;
    }
    a(localArrayList2);
    if (localArrayList1.isEmpty())
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest is empty");
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest load vidlist size=%d", Integer.valueOf(localArrayList1.size()));
    Stream.fromIterator(localArrayList1.iterator()).map(new MsgTabNodeListLoader.4(this)).map(new MsgTabNodeVidListPullSegment("MsgTabPreloader")).subscribe(new MsgTabNodeListLoader.3(this));
  }
  
  private boolean b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
    if (i != -1)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramMsgTabNodeInfo.jdField_c_of_type_Long >= localMsgTabNodeInfo.jdField_c_of_type_Long) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramMsgTabNodeInfo);
      } else {
        return false;
      }
    }
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    i = 0;
    while (i < j)
    {
      if (jdField_a_of_type_JavaUtilComparator.compare(paramMsgTabNodeInfo, this.jdField_a_of_type_JavaUtilArrayList.get(i)) <= 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(i, paramMsgTabNodeInfo);
        a(this.jdField_a_of_type_JavaUtilArrayList, false);
        return true;
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramMsgTabNodeInfo);
    a(this.jdField_a_of_type_JavaUtilArrayList, false);
    return true;
  }
  
  @WorkerThread
  private void c()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    MsgTabNodeInfo localMsgTabNodeInfo2 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
    if (localMsgTabNodeInfo2.jdField_d_of_type_Int > 0)
    {
      MsgTabNodeInfo localMsgTabNodeInfo3 = a(localMsgTabNodeInfo2.jdField_a_of_type_Int, localMsgTabNodeInfo2.jdField_a_of_type_JavaLangString);
      MsgTabNodeInfo localMsgTabNodeInfo1 = localMsgTabNodeInfo2;
      if (localMsgTabNodeInfo3 != null)
      {
        localMsgTabNodeInfo3.a(localMsgTabNodeInfo2);
        localMsgTabNodeInfo1 = localMsgTabNodeInfo3;
      }
      a(localMsgTabNodeInfo1, false);
    }
  }
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int j = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(localMsgTabNodeVideoInfo.jdField_a_of_type_Long);
      localObject = ((StringBuilder)localObject).toString();
      localObject = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean = true;
      }
      int k = j;
      if (localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean) {
        k = j - 1;
      }
      i += 1;
      j = k;
    }
    paramMsgTabNodeInfo.jdField_b_of_type_Int = j;
  }
  
  private void c(List<MsgTabNodeInfo> paramList)
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (MsgTabNodeInfo)paramList.get(i);
      if ((((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 12) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 10) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 11) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 13))
      {
        localObject = ((MsgTabNodeInfo)localObject).jdField_a_of_type_JavaLangString;
        QQUserUIItem localQQUserUIItem = localUserManager.b((String)localObject);
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
          a(localQQUserUIItem);
        } else {
          localArrayList.add(new QQUserUIItem.UserID("", (String)localObject));
        }
      }
      i += 1;
    }
    if (!localArrayList.isEmpty())
    {
      new GetUserInfoHandler(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback).a(1, localArrayList);
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private boolean c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
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
  
  public MsgTabNodeInfo a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
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
    }
    return null;
  }
  
  public MsgTabNodeInfo a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilArrayList != null))
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
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
    }
    return null;
  }
  
  public ArrayList<MsgTabNodeInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
    Boolean localBoolean = Boolean.valueOf(false);
    if (!((AtomicBoolean)localObject).compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestLatestPage() is loading, ignore this request...");
      }
      return;
    }
    localObject = new MsgTabNodeListRequest();
    ((MsgTabNodeListRequest)localObject).jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    ((MsgTabNodeListRequest)localObject).jdField_c_of_type_Int = paramInt;
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    boolean bool = ((Boolean)localStoryConfigManager.b("key_force_refresh_msg_node_list", localBoolean)).booleanValue();
    if (bool) {
      localStoryConfigManager.b("key_force_refresh_msg_node_list", localBoolean);
    }
    ((MsgTabNodeListRequest)localObject).jdField_a_of_type_Boolean = bool;
    CmdTaskManger.a().a((NetworkRequest)localObject, this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", ((MsgTabNodeListRequest)localObject).toString() });
    }
  }
  
  public void a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.jdField_b_of_type_Boolean)
    {
      boolean bool = QLog.isDevelopLevel();
      int j = 0;
      if (bool)
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramStoryVideoPublishStatusEvent) });
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
      Object localObject2 = a(((MsgTabNodeInfo)localObject3).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject3).jdField_a_of_type_JavaLangString);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new MsgTabNodeInfo(((MsgTabNodeInfo)localObject3).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject3).jdField_a_of_type_JavaLangString);
        ((MsgTabNodeInfo)localObject1).jdField_b_of_type_Long = QQStoryContext.a().a();
        a((MsgTabNodeInfo)localObject1, false);
      }
      int k = ((MsgTabNodeInfo)localObject1).a();
      int m = ((MsgTabNodeInfo)localObject3).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(k), "\tnewUploadStatus: ", Integer.valueOf(m) });
      }
      ((MsgTabNodeInfo)localObject1).a((MsgTabNodeInfo)localObject3);
      if (paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null) {
        paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      } else {
        paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      }
      int i = j;
      if (paramStoryVideoPublishStatusEvent.isUploadSuc())
      {
        localObject2 = new MsgTabNodeVideoInfo();
        ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean = false;
        ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long = paramStoryVideoPublishStatusEvent.mVideoIndex;
        if (((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long == 0L) {
          ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long = paramStoryVideoPublishStatusEvent.mCreateTime;
        }
        if (((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localObject2) != -1) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0)
        {
          ((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaUtilList.add(localObject2);
          ((MsgTabNodeInfo)localObject1).jdField_b_of_type_Int += 1;
          ((MsgTabNodeInfo)localObject1).g = paramStoryVideoPublishStatusEvent.getThumbUrl();
          ((MsgTabNodeInfo)localObject1).jdField_d_of_type_Long = (paramStoryVideoPublishStatusEvent.mCreateTime / 1000L);
          if (((MsgTabNodeInfo)localObject1).jdField_b_of_type_JavaUtilList == null) {
            ((MsgTabNodeInfo)localObject1).jdField_b_of_type_JavaUtilList = new ArrayList();
          }
          localObject3 = new MsgTabVideoData();
          ((MsgTabVideoData)localObject3).jdField_a_of_type_JavaLangString = paramStoryVideoPublishStatusEvent.mAttachedFeedId;
          ((MsgTabVideoData)localObject3).jdField_b_of_type_JavaLangString = paramStoryVideoPublishStatusEvent.mVid;
          ((MsgTabVideoData)localObject3).jdField_a_of_type_Long = paramStoryVideoPublishStatusEvent.mVideoIndex;
          ((MsgTabVideoData)localObject3).jdField_a_of_type_Boolean = false;
          ((MsgTabVideoData)localObject3).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoPublishStatusEvent;
          ((MsgTabNodeInfo)localObject1).jdField_b_of_type_JavaUtilList.add(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaUtilList });
          }
          i = 1;
        }
        else
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , but exist!!! videoInfo=", localObject2 });
            i = j;
          }
        }
      }
      if (k != m) {
        i = 1;
      }
      if (i != 0) {
        a((MsgTabNodeInfo)localObject1, true);
      }
    }
  }
  
  public void a(DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (!paramDeleteStoryVideoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "delete video event, event=", paramDeleteStoryVideoEvent });
    }
    Object localObject;
    if (paramDeleteStoryVideoEvent.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
      MsgTabNodeInfo localMsgTabNodeInfo = a(((MsgTabNodeInfo)localObject).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject).jdField_a_of_type_JavaLangString);
      paramDeleteStoryVideoEvent = (DeleteStoryVideoEvent)localObject;
      if (localMsgTabNodeInfo != null)
      {
        localMsgTabNodeInfo.a((MsgTabNodeInfo)localObject);
        paramDeleteStoryVideoEvent = localMsgTabNodeInfo;
      }
      a(paramDeleteStoryVideoEvent, true);
      return;
    }
    int i;
    if (!TextUtils.isEmpty(paramDeleteStoryVideoEvent.c)) {
      i = 8;
    } else {
      i = 5;
    }
    if (!TextUtils.isEmpty(paramDeleteStoryVideoEvent.c)) {
      localObject = paramDeleteStoryVideoEvent.c;
    } else {
      localObject = paramDeleteStoryVideoEvent.jdField_b_of_type_JavaLangString;
    }
    a(i, (String)localObject, paramDeleteStoryVideoEvent.jdField_a_of_type_Long);
    a(i, paramDeleteStoryVideoEvent.jdField_b_of_type_JavaLangString, paramDeleteStoryVideoEvent.c);
  }
  
  protected void a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null)
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal is null!", new Object[0]);
      return;
    }
    if ((!TextUtils.isEmpty(paramQQUserUIItem.uid)) && (paramQQUserUIItem.isAvailable()))
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQUserUIItem.uid, paramQQUserUIItem);
      return;
    }
    SLog.c("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
      if ((localMsgTabNodeInfo.jdField_a_of_type_Int == 13) && (TextUtils.equals(localMsgTabNodeInfo.jdField_a_of_type_JavaLangString, paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString))) {
        paramMsgTabNodeInfo.jdField_d_of_type_Boolean = localMsgTabNodeInfo.jdField_d_of_type_Boolean;
      }
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramMsgTabNodeInfo), Boolean.valueOf(paramBoolean));
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
    if (b(paramMsgTabNodeInfo))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramMsgTabNodeInfo);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
      int i = 1;
      boolean bool;
      if (j != k) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "insertNode: hasChangePos=", Boolean.valueOf(bool), ", oldIndex=", Integer.valueOf(j), ", newIndex=", Integer.valueOf(k) });
      }
      if (paramBoolean)
      {
        if (!bool) {
          i = 2;
        }
        a(paramMsgTabNodeInfo, false, i, false);
      }
    }
  }
  
  protected void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(paramMsgTabNodeInfo), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i;
    if (paramInt == 1)
    {
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
      if (i == -1)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert position not found:");
        localStringBuilder.append(paramMsgTabNodeInfo);
        QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 1, localStringBuilder.toString());
        return;
      }
    }
    else
    {
      i = -1;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.11(this, paramMsgTabNodeInfo, paramBoolean1, paramInt, i, paramBoolean2));
  }
  
  public void a(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      if (this.jdField_d_of_type_JavaUtilArrayList.contains(paramOnMsgTabNodeListLoadListener))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
      }
      this.jdField_d_of_type_JavaUtilArrayList.add(paramOnMsgTabNodeListLoadListener);
      return;
    }
  }
  
  @WorkerThread
  protected void a(@NonNull MsgTabNodeListRequest paramMsgTabNodeListRequest, @Nullable MsgTabNodeListRequest.MsgTabNodeListResponse paramMsgTabNodeListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool;
    if (((paramErrorMessage.errorCode != 0) && (paramErrorMessage.errorCode != 15000) && (paramErrorMessage.errorCode != 15001)) || (paramMsgTabNodeListResponse == null))
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() get latest failed: %s", paramErrorMessage.getErrorMessage());
      a(false);
      bool = a();
      a(this.jdField_a_of_type_JavaUtilArrayList, true);
      if (bool)
      {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
        a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, true);
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      return;
    }
    a(true);
    this.h = paramMsgTabNodeListResponse.jdField_a_of_type_Boolean;
    if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramMsgTabNodeListResponse.jdField_a_of_type_JavaLangString))
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.jdField_b_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      if (paramErrorMessage.errorCode == 15001)
      {
        paramErrorMessage = null;
        paramMsgTabNodeListRequest = paramErrorMessage;
        if (paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size() > 0)
        {
          i = 0;
          for (;;)
          {
            paramMsgTabNodeListRequest = paramErrorMessage;
            if (i >= paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size()) {
              break;
            }
            paramMsgTabNodeListRequest = (MsgTabNodeInfo)paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (paramMsgTabNodeListRequest.jdField_a_of_type_Int == 12) {
              break;
            }
            i += 1;
          }
        }
        if (paramMsgTabNodeListRequest != null)
        {
          SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i = 0;
          while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
          {
            if (((MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int == 12)
            {
              this.jdField_a_of_type_JavaUtilArrayList.set(i, paramMsgTabNodeListRequest);
              i = 1;
              break label305;
            }
            i += 1;
          }
          i = 0;
          label305:
          if (i == 0) {
            this.jdField_a_of_type_JavaUtilArrayList.add(paramMsgTabNodeListRequest);
          }
        }
      }
      a(this.jdField_a_of_type_JavaUtilArrayList, true);
      a();
      c(this.jdField_a_of_type_JavaUtilArrayList);
      b(this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
      b(false);
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size()));
    int i = 0;
    while (i < paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size())
    {
      c((MsgTabNodeInfo)paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.get(i));
      i += 1;
    }
    if (paramMsgTabNodeListRequest.jdField_c_of_type_Int == 1) {
      bool = a(this.jdField_a_of_type_JavaUtilArrayList, paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList);
    } else {
      bool = false;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
    this.jdField_b_of_type_JavaLangString = paramMsgTabNodeListResponse.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_JavaLangString = paramMsgTabNodeListResponse.c;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList);
    a(this.jdField_a_of_type_JavaUtilArrayList);
    a(this.jdField_a_of_type_JavaUtilArrayList, true);
    this.jdField_a_of_type_Boolean = paramMsgTabNodeListResponse.jdField_b_of_type_Boolean;
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
    a();
    c();
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(this.jdField_a_of_type_JavaUtilArrayList, true);
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
    c(this.jdField_a_of_type_JavaUtilArrayList);
    b(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    a(this.jdField_b_of_type_JavaUtilArrayList, true, this.jdField_a_of_type_Boolean, false);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    b(bool);
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
  }
  
  @WorkerThread
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    StringBuilder localStringBuilder;
    if ((paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList != null) && (!paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onStoryUpdateUserInfoEvent isSuccess userUIItems: ");
        localStringBuilder.append(paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList);
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, localStringBuilder.toString());
      }
      int m = paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.size();
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (a(((QQUserUIItem)paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.get(i)).uid) != null)
        {
          j = 1;
          break;
        }
        i += 1;
      }
      if (j != 0) {
        this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.13(this));
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStoryUpdateUserInfoEvent errorInfo: ");
      localStringBuilder.append(paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
      localStringBuilder.append(", userUIItems = ");
      localStringBuilder.append(paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList);
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, localStringBuilder.toString());
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
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.6(this, paramMsgTabNodePushNotify));
  }
  
  public void a(String paramString)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "scheduleRequireUserItem() %s", paramString);
    Message.obtain(this.jdField_b_of_type_AndroidOsHandler, 2, paramString).sendToTarget();
  }
  
  public void a(String paramString, long paramLong)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.12(this, paramString, paramLong));
  }
  
  public void a(String paramString1, String paramString2)
  {
    paramString1 = new QQStoryGuideRequest(paramString1, paramString2);
    if (QLog.isDevelopLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("requestQQStoryGuide request = ");
      paramString2.append(paramString1.toString());
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, paramString2.toString());
    }
    CmdTaskManger.a().a(paramString1, new MsgTabNodeListLoader.17(this));
  }
  
  protected void a(ArrayList<MsgTabNodeInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() dataList=%s, isFirstPage=%b, isEnd=%b, push=%b", String.valueOf(paramArrayList), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3));
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.10(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  void a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      int i = 0;
      while (i < paramList.size())
      {
        localStoryManager.b((String)paramList.get(i));
        i += 1;
      }
      return;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  protected boolean a()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    boolean bool;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (this.jdField_c_of_type_JavaUtilArrayList.size() > 0)
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      bool = false;
      while (localIterator.hasNext()) {
        bool |= a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false);
      }
      if (bool) {
        this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      }
      this.jdField_c_of_type_JavaUtilArrayList.clear();
    }
    else
    {
      bool = false;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
    return bool;
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return false;
    }
    paramInt = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    int i = 0;
    boolean bool2;
    for (boolean bool1 = false; paramInt >= 0; bool1 = bool2)
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramString.jdField_a_of_type_JavaUtilList.get(paramInt);
      int j;
      if (localMsgTabNodeVideoInfo.jdField_a_of_type_Long == paramLong)
      {
        paramString.jdField_a_of_type_JavaUtilList.remove(paramInt);
        bool2 = true;
        j = i;
      }
      else
      {
        j = i;
        bool2 = bool1;
        if (!localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean)
        {
          j = i + 1;
          bool2 = bool1;
        }
      }
      paramInt -= 1;
      i = j;
    }
    paramString.jdField_b_of_type_Int = i;
    if ((!bool1) && (QLog.isDevelopLevel())) {
      QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "deleteNodeVideoFromNodeInfoFromWorkThread, nothing to delete", " info.unreadCount =", Integer.valueOf(paramString.jdField_b_of_type_Int), ", info.videoInfoList=", paramString.jdField_a_of_type_JavaUtilList });
    }
    if (paramString.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      this.jdField_a_of_type_JavaUtilArrayList.remove(paramString);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(paramString);
      a(paramString, false, 3, false);
      return bool1;
    }
    if (bool1)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramString);
      a(paramString, false, 2, false);
    }
    return bool1;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidListFromWorkThread(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    return MsgTabStoryManager.a(new MsgTabNodeInfo(paramInt, paramString1));
  }
  
  public boolean a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool = c(paramMsgTabNodeInfo);
    if (bool)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.b(paramMsgTabNodeInfo);
      a(paramMsgTabNodeInfo, false, 3, false);
    }
    return bool;
  }
  
  @WorkerThread
  public boolean a(String paramString, long paramLong)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    Object localObject;
    while (i >= 0)
    {
      localObject = (MsgTabNodeVideoInfo)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if ((((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Long == paramLong) && (!((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Boolean))
      {
        ((MsgTabNodeVideoInfo)localObject).jdField_a_of_type_Boolean = true;
        paramString.jdField_b_of_type_Int -= 1;
        bool = true;
        break label112;
      }
      i -= 1;
    }
    boolean bool = false;
    label112:
    if ((paramString.jdField_b_of_type_Int <= 0) && (!paramString.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      localObject = new MsgTabNodeWatchedRequest();
      ((MsgTabNodeWatchedRequest)localObject).jdField_b_of_type_JavaLangString = paramString.jdField_a_of_type_JavaLangString;
      ((MsgTabNodeWatchedRequest)localObject).jdField_c_of_type_Int = paramString.jdField_a_of_type_Int;
      ((MsgTabNodeWatchedRequest)localObject).jdField_d_of_type_Int = 5;
      ((MsgTabNodeWatchedRequest)localObject).jdField_b_of_type_Long = paramString.e;
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
  }
  
  @UiThread
  public ArrayList<MsgTabNodeInfo> b()
  {
    boolean bool;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  @GuardedBy("mNotifyLock")
  public void b()
  {
    boolean bool;
    if (RedPointUtils.a(52) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.g = bool;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_b_of_type_Boolean)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_b_of_type_Boolean = true;
        if (this.jdField_d_of_type_Boolean)
        {
          this.jdField_d_of_type_Boolean = false;
          i = 1;
          if (i != 0) {
            ((QQStoryHandler)QQStoryContext.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1026, true, Boolean.valueOf(false));
          }
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void b(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.15(this, paramStoryVideoPublishStatusEvent));
  }
  
  public void b(DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.16(this, paramDeleteStoryVideoEvent));
  }
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.7(this, paramMsgTabNodeInfo));
  }
  
  public void b(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    synchronized (this.jdField_d_of_type_JavaUtilArrayList)
    {
      this.jdField_d_of_type_JavaUtilArrayList.remove(paramOnMsgTabNodeListLoadListener);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    this.jdField_b_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.14(this, paramUpdateUserInfoEvent));
  }
  
  @GuardedBy("mNotifyLock")
  public void b(boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Boolean = true;
      this.f = paramBoolean;
      int i;
      if (this.jdField_b_of_type_Boolean)
      {
        i = 1;
      }
      else
      {
        this.jdField_d_of_type_Boolean = true;
        i = 0;
      }
      if (i != 0)
      {
        ??? = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList).iterator();
        while (((Iterator)???).hasNext())
        {
          MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)???).next();
          if ((localMsgTabNodeInfo.jdField_b_of_type_Int > 0) && (localMsgTabNodeInfo.jdField_a_of_type_Int == 6)) {
            this.e = true;
          }
        }
        ((QQStoryHandler)QQStoryContext.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1026, true, Boolean.valueOf(false));
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader
 * JD-Core Version:    0.7.0.1
 */