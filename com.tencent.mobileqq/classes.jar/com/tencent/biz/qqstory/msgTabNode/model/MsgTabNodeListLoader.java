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
        String str = paramQQAppInterface.jdField_a_of_type_JavaLangString + "-" + paramMsgTabStoryManager.jdField_a_of_type_Long;
        this.jdField_a_of_type_JavaUtilHashMap.put(str, Boolean.valueOf(paramMsgTabStoryManager.jdField_a_of_type_Boolean));
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
    int i;
    if (localArrayList.size() > 0)
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, jdField_b_of_type_JavaUtilComparator);
      i = 0;
      if (i >= paramArrayList.size()) {
        break label297;
      }
      localObject = (MsgTabNodeInfo)paramArrayList.get(i);
      if ((((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 1) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 4) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 3)) {
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i));
      }
    }
    for (;;)
    {
      if (i == -1) {
        i = paramArrayList.size();
      }
      for (;;)
      {
        int j = 0;
        label196:
        if (j < localArrayList.size())
        {
          localObject = (MsgTabNodeInfo)localArrayList.get(j);
          if (((MsgTabNodeInfo)localObject).jdField_c_of_type_Int > 0) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            AssertUtils.a(paramBoolean, "position must be greater than 0");
            int k = Math.min(((MsgTabNodeInfo)localObject).jdField_c_of_type_Int + i - 1, paramArrayList.size());
            paramArrayList.add(k, localObject);
            SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(k));
            j += 1;
            break label196;
            i += 1;
            break;
          }
        }
        return;
      }
      label297:
      i = -1;
    }
  }
  
  private boolean a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify, boolean paramBoolean)
  {
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
    label168:
    int j;
    if (paramMsgTabNodePushNotify.uint32_animate.get() == 1)
    {
      bool1 = true;
      if (i != 1) {
        break label476;
      }
      if (localMsgTabNodeInfo.jdField_a_of_type_Int == 5)
      {
        paramMsgTabNodePushNotify = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
        if (paramMsgTabNodePushNotify.jdField_d_of_type_Int > 0)
        {
          i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo);
          if (i == -1) {
            break label329;
          }
          localMsgTabNodeInfo.a((MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i));
        }
      }
      if ((localMsgTabNodeInfo.jdField_a_of_type_Int != 7) || (this.jdField_a_of_type_JavaUtilArrayList.indexOf(localMsgTabNodeInfo) != -1)) {
        break label345;
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label345;
      }
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
        bool1 = false;
        break;
        label329:
        localMsgTabNodeInfo.a(paramMsgTabNodePushNotify);
        break label168;
      }
      i += 1;
    }
    label345:
    c(localMsgTabNodeInfo);
    boolean bool2 = b(localMsgTabNodeInfo);
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
    paramBoolean = bool2;
    for (;;)
    {
      return paramBoolean;
      label476:
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
        paramBoolean = bool2;
      }
      else
      {
        paramBoolean = false;
      }
    }
  }
  
  public static boolean a(List<MsgTabNodeInfo> paramList1, List<MsgTabNodeInfo> paramList2)
  {
    boolean bool2 = false;
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    if (i < paramList1.size())
    {
      localObject1 = ((MsgTabNodeInfo)paramList1.get(i)).jdField_a_of_type_JavaLangString;
      if (((MsgTabNodeInfo)paramList1.get(i)).jdField_a_of_type_Int == 12) {}
      for (;;)
      {
        i += 1;
        break;
        localObject2 = ((MsgTabNodeInfo)paramList1.get(i)).jdField_a_of_type_JavaUtilList;
        j = 0;
        while (j < ((List)localObject2).size())
        {
          MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)((List)localObject2).get(j);
          if (!localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean) {
            localHashSet.add((String)localObject1 + "-" + localMsgTabNodeVideoInfo.jdField_a_of_type_Long);
          }
          j += 1;
        }
      }
    }
    i = 0;
    boolean bool1 = bool2;
    if (i < paramList2.size())
    {
      paramList1 = ((MsgTabNodeInfo)paramList2.get(i)).jdField_a_of_type_JavaLangString;
      if (((MsgTabNodeInfo)paramList2.get(i)).jdField_a_of_type_Int != 12) {}
    }
    for (;;)
    {
      i += 1;
      break;
      localObject1 = ((MsgTabNodeInfo)paramList2.get(i)).jdField_a_of_type_JavaUtilList;
      j = 0;
      while (j < ((List)localObject1).size())
      {
        localObject2 = (MsgTabNodeVideoInfo)((List)localObject1).get(j);
        if ((!((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean) && (!localHashSet.contains(paramList1 + "-" + ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long)))
        {
          bool1 = true;
          return bool1;
        }
        j += 1;
      }
    }
  }
  
  private boolean a(List<String> paramList, boolean paramBoolean)
  {
    if (paramList.isEmpty())
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    boolean bool = false;
    if (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      QQUserUIItem localQQUserUIItem = localUserManager.b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList.add(new QQUserUIItem.UserID("", str));
      }
      for (;;)
      {
        i += 1;
        break;
        a(localQQUserUIItem);
        bool = true;
      }
    }
    if (!localArrayList.isEmpty()) {
      if (paramBoolean)
      {
        new GetUserInfoHandler(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetUserInfoHandler$OnGetUserInfoCallback).a(1, localArrayList);
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() Will fetch %s users", localArrayList);
      }
    }
    for (;;)
    {
      return bool;
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() miss %s users, did not find in db, won't request", localArrayList);
      continue;
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() All nodes has local cache, no need request");
    }
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
      return;
    }
    a(paramMsgTabNodePushNotify, true);
  }
  
  private void b(List<MsgTabNodeInfo> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    int k;
    MsgTabNodeInfo localMsgTabNodeInfo;
    for (int j = 0;; j = k)
    {
      if ((j < paramList.size()) && (i < 8))
      {
        k = j + 1;
        localMsgTabNodeInfo = (MsgTabNodeInfo)paramList.get(j);
        if (localMsgTabNodeInfo.jdField_b_of_type_Int == 0) {
          SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(j));
        }
      }
      else
      {
        label75:
        a(localArrayList2);
        if (!localArrayList1.isEmpty()) {
          break label287;
        }
        SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest is empty");
        return;
      }
      if ((localMsgTabNodeInfo.jdField_a_of_type_Int == 6) || (localMsgTabNodeInfo.jdField_a_of_type_Int == 9) || (localMsgTabNodeInfo.jdField_a_of_type_Int == 7) || (localMsgTabNodeInfo.jdField_a_of_type_Int == 5)) {
        break;
      }
    }
    Iterator localIterator = localMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.iterator();
    label155:
    MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
    if (localIterator.hasNext())
    {
      localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
      if (TextUtils.isEmpty(localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString))
      {
        localArrayList1.add(localMsgTabNodeInfo);
        i += 1;
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(k));
        j = 1;
      }
    }
    for (;;)
    {
      if (j == 0)
      {
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(k));
        break label75;
        if (localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean) {
          break label155;
        }
        localArrayList2.add(localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString);
        i += 1;
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(k), localMsgTabNodeVideoInfo.jdField_a_of_type_JavaLangString);
        j = 1;
        continue;
      }
      j = k;
      break;
      label287:
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() nodesForVidListRequest load vidlist size=%d", Integer.valueOf(localArrayList1.size()));
      Stream.fromIterator(localArrayList1.iterator()).map(new MsgTabNodeListLoader.4(this)).map(new MsgTabNodeVidListPullSegment("MsgTabPreloader")).subscribe(new MsgTabNodeListLoader.3(this));
      return;
      j = 0;
    }
  }
  
  private boolean b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool;
    int i;
    int j;
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread)
    {
      bool = true;
      AssertUtils.a(bool);
      i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
      if (i != -1)
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if (paramMsgTabNodeInfo.jdField_c_of_type_Long < localMsgTabNodeInfo.jdField_c_of_type_Long) {
          break label127;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(paramMsgTabNodeInfo);
      }
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label136;
      }
      if (jdField_a_of_type_JavaUtilComparator.compare(paramMsgTabNodeInfo, this.jdField_a_of_type_JavaUtilArrayList.get(i)) <= 0)
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(i, paramMsgTabNodeInfo);
        a(this.jdField_a_of_type_JavaUtilArrayList, false);
        return true;
        bool = false;
        break;
        label127:
        return false;
      }
      i += 1;
    }
    label136:
    this.jdField_a_of_type_JavaUtilArrayList.add(paramMsgTabNodeInfo);
    a(this.jdField_a_of_type_JavaUtilArrayList, false);
    return true;
  }
  
  @WorkerThread
  private void c()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
    if (((MsgTabNodeInfo)localObject).jdField_d_of_type_Int > 0)
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
  
  private void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i = paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size();
    int j = 0;
    if (j < paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.size())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramMsgTabNodeInfo.jdField_a_of_type_JavaUtilList.get(j);
      Object localObject = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString + "-" + localMsgTabNodeVideoInfo.jdField_a_of_type_Long;
      localObject = (Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean = true;
      }
      if (!localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean) {
        break label130;
      }
      i -= 1;
    }
    label130:
    for (;;)
    {
      j += 1;
      break;
      paramMsgTabNodeInfo.jdField_b_of_type_Int = i;
      return;
    }
  }
  
  private void c(List<MsgTabNodeInfo> paramList)
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      Object localObject = (MsgTabNodeInfo)paramList.get(i);
      if ((((MsgTabNodeInfo)localObject).jdField_a_of_type_Int == 12) || (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int == 10) || (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int == 11) || (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int == 13)) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = ((MsgTabNodeInfo)localObject).jdField_a_of_type_JavaLangString;
        QQUserUIItem localQQUserUIItem = localUserManager.b((String)localObject);
        if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
          localArrayList.add(new QQUserUIItem.UserID("", (String)localObject));
        } else {
          a(localQQUserUIItem);
        }
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
  
  private boolean c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
      if (i == -1) {
        break;
      }
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (paramMsgTabNodeInfo.jdField_c_of_type_Long >= localMsgTabNodeInfo.jdField_c_of_type_Long) {
        break;
      }
      return false;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.remove(paramMsgTabNodeInfo);
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
      StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
      boolean bool = ((Boolean)localStoryConfigManager.b("key_force_refresh_msg_node_list", Boolean.valueOf(false))).booleanValue();
      if (bool) {
        localStoryConfigManager.b("key_force_refresh_msg_node_list", Boolean.valueOf(false));
      }
      localMsgTabNodeListRequest.jdField_a_of_type_Boolean = bool;
      CmdTaskManger.a().a(localMsgTabNodeListRequest, this.jdField_a_of_type_ComTencentBizQqstoryChannelCmdTaskManger$CommandCallback);
    } while (!QLog.isDevelopLevel());
    QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", localMsgTabNodeListRequest.toString() });
  }
  
  public void a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    Object localObject2;
    Object localObject1;
    int i;
    if (paramStoryVideoPublishStatusEvent.jdField_b_of_type_Boolean)
    {
      if (QLog.isDevelopLevel())
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramStoryVideoPublishStatusEvent) });
      }
      Object localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
      localObject2 = a(((MsgTabNodeInfo)localObject3).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject3).jdField_a_of_type_JavaLangString);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new MsgTabNodeInfo(((MsgTabNodeInfo)localObject3).jdField_a_of_type_Int, ((MsgTabNodeInfo)localObject3).jdField_a_of_type_JavaLangString);
        ((MsgTabNodeInfo)localObject1).jdField_b_of_type_Long = QQStoryContext.a().a();
        a((MsgTabNodeInfo)localObject1, false);
      }
      int j = ((MsgTabNodeInfo)localObject1).a();
      int k = ((MsgTabNodeInfo)localObject3).a();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(j), "\tnewUploadStatus: ", Integer.valueOf(k) });
      }
      ((MsgTabNodeInfo)localObject1).a((MsgTabNodeInfo)localObject3);
      if (paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null) {
        break label544;
      }
      paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.jdField_b_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      if (!paramStoryVideoPublishStatusEvent.isUploadSuc()) {
        break label584;
      }
      localObject2 = new MsgTabNodeVideoInfo();
      ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Boolean = false;
      ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long = paramStoryVideoPublishStatusEvent.mVideoIndex;
      if (((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long == 0L) {
        ((MsgTabNodeVideoInfo)localObject2).jdField_a_of_type_Long = paramStoryVideoPublishStatusEvent.mCreateTime;
      }
      if (((MsgTabNodeInfo)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localObject2) == -1) {
        break label552;
      }
      i = 1;
      label339:
      if (i != 0) {
        break label557;
      }
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
      label526:
      if (j != k) {
        break label589;
      }
    }
    for (;;)
    {
      if (i != 0) {
        a((MsgTabNodeInfo)localObject1, true);
      }
      return;
      label544:
      paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
      break;
      label552:
      i = 0;
      break label339;
      label557:
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , but exist!!! videoInfo=", localObject2 });
      }
      label584:
      i = 0;
      break label526;
      label589:
      i = 1;
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
    if (paramDeleteStoryVideoEvent.jdField_a_of_type_Boolean)
    {
      paramDeleteStoryVideoEvent = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a();
      localObject = a(paramDeleteStoryVideoEvent.jdField_a_of_type_Int, paramDeleteStoryVideoEvent.jdField_a_of_type_JavaLangString);
      if (localObject != null)
      {
        ((MsgTabNodeInfo)localObject).a(paramDeleteStoryVideoEvent);
        paramDeleteStoryVideoEvent = (DeleteStoryVideoEvent)localObject;
      }
      for (;;)
      {
        a(paramDeleteStoryVideoEvent, true);
        return;
      }
    }
    int i;
    if (!TextUtils.isEmpty(paramDeleteStoryVideoEvent.c))
    {
      i = 8;
      if (TextUtils.isEmpty(paramDeleteStoryVideoEvent.c)) {
        break label145;
      }
    }
    label145:
    for (Object localObject = paramDeleteStoryVideoEvent.c;; localObject = paramDeleteStoryVideoEvent.jdField_b_of_type_JavaLangString)
    {
      a(i, (String)localObject, paramDeleteStoryVideoEvent.jdField_a_of_type_Long);
      a(i, paramDeleteStoryVideoEvent.jdField_b_of_type_JavaLangString, paramDeleteStoryVideoEvent.c);
      return;
      i = 5;
      break;
    }
  }
  
  protected void a(QQUserUIItem paramQQUserUIItem)
  {
    if (paramQQUserUIItem == null)
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal is null!", new Object[0]);
      return;
    }
    if ((TextUtils.isEmpty(paramQQUserUIItem.uid)) || (!paramQQUserUIItem.isAvailable()))
    {
      SLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramQQUserUIItem.uid, paramQQUserUIItem);
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
    int i = 1;
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramMsgTabNodeInfo), Boolean.valueOf(paramBoolean));
    int j = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
    boolean bool;
    if (b(paramMsgTabNodeInfo))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryManager.a(paramMsgTabNodeInfo);
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
      int k = this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramMsgTabNodeInfo);
      if (j == k) {
        break label156;
      }
      bool = true;
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "insertNode: hasChangePos=", Boolean.valueOf(bool), ", oldIndex=", Integer.valueOf(j), ", newIndex=", Integer.valueOf(k) });
      }
      if (paramBoolean) {
        if (!bool) {
          break label162;
        }
      }
    }
    for (;;)
    {
      a(paramMsgTabNodeInfo, false, i, false);
      return;
      label156:
      bool = false;
      break;
      label162:
      i = 2;
    }
  }
  
  protected void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
          paramMsgTabNodeListRequest = paramErrorMessage;
          if (i < paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramMsgTabNodeListRequest = (MsgTabNodeInfo)paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.get(i);
            if (paramMsgTabNodeListRequest.jdField_a_of_type_Int != 12) {
              break label372;
            }
          }
        }
        if (paramMsgTabNodeListRequest != null)
        {
          SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i = 0;
          label232:
          if (i >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label673;
          }
          if (((MsgTabNodeInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Int != 12) {
            break label381;
          }
          this.jdField_a_of_type_JavaUtilArrayList.set(i, paramMsgTabNodeListRequest);
        }
      }
    }
    label673:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramMsgTabNodeListRequest);
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
      label372:
      i += 1;
      break;
      label381:
      i += 1;
      break label232;
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size()));
      i = 0;
      while (i < paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.size())
      {
        c((MsgTabNodeInfo)paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      if (paramMsgTabNodeListRequest.jdField_c_of_type_Int == 1) {}
      for (bool = a(this.jdField_a_of_type_JavaUtilArrayList, paramMsgTabNodeListResponse.jdField_a_of_type_JavaUtilArrayList);; bool = false)
      {
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
        return;
      }
    }
  }
  
  @WorkerThread
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    if ((paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList != null) && (!paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent isSuccess userUIItems: " + paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList);
      }
      int j = paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.size();
      i = 0;
      if (i >= j) {
        break label183;
      }
      if (a(((QQUserUIItem)paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList.get(i)).uid) == null) {}
    }
    label183:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.13(this));
      }
      do
      {
        return;
        i += 1;
        break;
      } while (!QLog.isColorLevel());
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "onStoryUpdateUserInfoEvent errorInfo: " + paramUpdateUserInfoEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage + ", userUIItems = " + paramUpdateUserInfoEvent.jdField_a_of_type_JavaUtilList);
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
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestQQStoryGuide request = " + paramString1.toString());
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
    if ((paramList == null) || (paramList.isEmpty())) {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
    }
    for (;;)
    {
      return;
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      int i = 0;
      while (i < paramList.size())
      {
        localStoryManager.b((String)paramList.get(i));
        i += 1;
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  protected boolean a()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    if (Thread.currentThread() == this.jdField_a_of_type_AndroidOsHandlerThread) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      if (this.jdField_c_of_type_JavaUtilArrayList.size() <= 0) {
        break label126;
      }
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.jdField_c_of_type_JavaUtilArrayList.iterator();
      for (bool = false; localIterator.hasNext(); bool = a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false) | bool) {}
    }
    if (bool) {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilArrayList);
    }
    this.jdField_c_of_type_JavaUtilArrayList.clear();
    for (;;)
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
      return bool;
      label126:
      bool = false;
    }
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    boolean bool1 = false;
    boolean bool2 = false;
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return bool2;
    }
    paramInt = 0;
    int i = paramString.jdField_a_of_type_JavaUtilList.size() - 1;
    label52:
    MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
    if (i >= 0)
    {
      localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramString.jdField_a_of_type_JavaUtilList.get(i);
      if (localMsgTabNodeVideoInfo.jdField_a_of_type_Long == paramLong)
      {
        paramString.jdField_a_of_type_JavaUtilList.remove(i);
        bool1 = true;
      }
    }
    for (;;)
    {
      i -= 1;
      break label52;
      if (!localMsgTabNodeVideoInfo.jdField_a_of_type_Boolean)
      {
        paramInt += 1;
        continue;
        paramString.jdField_b_of_type_Int = paramInt;
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
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteVidFromNodeVidListFromWorkThread(type=%d, uid=%s, groupId=%s)", Integer.valueOf(paramInt), paramString1, paramString2);
    if (TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return MsgTabStoryManager.a(new MsgTabNodeInfo(paramInt, paramString1));
      paramString1 = paramString2;
    }
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
      i -= 1;
      break;
    }
  }
  
  @UiThread
  public ArrayList<MsgTabNodeInfo> b()
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      return this.jdField_b_of_type_JavaUtilArrayList;
    }
  }
  
  @GuardedBy("mNotifyLock")
  public void b()
  {
    if (RedPointUtils.a(52) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.g = bool;
      if ((!this.jdField_d_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
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
          if (i == 0) {
            break;
          }
          ((QQStoryHandler)QQStoryContext.a().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1026, true, Boolean.valueOf(false));
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
      if (this.jdField_b_of_type_Boolean)
      {
        i = 1;
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
      this.jdField_d_of_type_Boolean = true;
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader
 * JD-Core Version:    0.7.0.1
 */