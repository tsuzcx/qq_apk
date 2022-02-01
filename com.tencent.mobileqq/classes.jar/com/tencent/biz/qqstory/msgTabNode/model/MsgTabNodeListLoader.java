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
  protected static Comparator<MsgTabNodeInfo> p = new MsgTabNodeInfoComparator();
  protected static Comparator<MsgTabNodeInfo> q = new MsgTabNodeInfoPositionComparator();
  private GetUserInfoHandler.OnGetUserInfoCallback A = new MsgTabNodeListLoader.1(this);
  protected String a;
  protected String b;
  protected boolean c;
  protected AtomicBoolean d = new AtomicBoolean(false);
  protected volatile ArrayList<MsgTabNodeInfo> e;
  protected volatile ArrayList<MsgTabNodeInfo> f;
  protected ConcurrentHashMap<String, QQUserUIItem> g = new ConcurrentHashMap();
  protected Set<String> h = Collections.synchronizedSet(new ArraySet());
  protected ArrayList<qqstory_service.MsgTabNodePushNotify> i = new ArrayList();
  protected final ArrayList<MsgTabNodeListLoader.OnMsgTabNodeListLoadListener> j = new ArrayList();
  protected Handler k = new Handler(Looper.getMainLooper());
  protected HandlerThread l = (HandlerThread)ThreadManagerV2.getRecentThread();
  protected Handler m;
  protected MsgTabStoryManager n;
  protected HashMap<String, Boolean> o = new HashMap();
  protected CmdTaskManger.CommandCallback<MsgTabNodeListRequest, MsgTabNodeListRequest.MsgTabNodeListResponse> r = new MsgTabNodeListLoader.2(this);
  protected final Object s = new Object();
  boolean t = false;
  boolean u = false;
  boolean v = false;
  boolean w = false;
  boolean x = false;
  boolean y = false;
  boolean z = false;
  
  MsgTabNodeListLoader(QQAppInterface paramQQAppInterface, MsgTabStoryManager paramMsgTabStoryManager)
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListLoader ctor()");
    if (paramQQAppInterface == null) {
      SLog.c("Q.qqstory.msgTab.MsgTabNodeListLoader", "Error app is null", new IllegalArgumentException());
    }
    this.n = paramMsgTabStoryManager;
    this.e = this.n.c();
    a(this.e, true);
    this.f = new ArrayList(this.e);
    this.m = new MsgTabNodeListLoader.MsgTabWorkThreadHandler(this, this.l.getLooper());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "create new loader");
    }
    int i1 = 0;
    while (i1 < this.e.size())
    {
      paramQQAppInterface = (MsgTabNodeInfo)this.e.get(i1);
      int i2 = 0;
      while (i2 < paramQQAppInterface.e.size())
      {
        paramMsgTabStoryManager = (MsgTabNodeVideoInfo)paramQQAppInterface.e.get(i2);
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramQQAppInterface.d);
        ((StringBuilder)localObject).append("-");
        ((StringBuilder)localObject).append(paramMsgTabStoryManager.a);
        localObject = ((StringBuilder)localObject).toString();
        this.o.put(localObject, Boolean.valueOf(paramMsgTabStoryManager.b));
        i2 += 1;
      }
      i1 += 1;
    }
    this.m.post(new MsgTabNodeListLoader.5(this));
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
      if (localMsgTabNodeInfo.q > 0)
      {
        localArrayList.add(localMsgTabNodeInfo);
        ((Iterator)localObject).remove();
      }
    }
    if (paramBoolean) {
      Collections.sort(paramArrayList, p);
    }
    if (localArrayList.size() > 0)
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() specialPositionNodes.size() = %d", Integer.valueOf(localArrayList.size()));
      Collections.sort(localArrayList, q);
      int i1 = 0;
      while (i1 < paramArrayList.size())
      {
        localObject = (MsgTabNodeInfo)paramArrayList.get(i1);
        if ((((MsgTabNodeInfo)localObject).b != 1) && (((MsgTabNodeInfo)localObject).b != 4) && (((MsgTabNodeInfo)localObject).b != 3))
        {
          SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() find baseIndex: %d", Integer.valueOf(i1));
          break label196;
        }
        i1 += 1;
      }
      i1 = -1;
      label196:
      int i2 = i1;
      if (i1 == -1) {
        i2 = paramArrayList.size();
      }
      i1 = 0;
      while (i1 < localArrayList.size())
      {
        localObject = (MsgTabNodeInfo)localArrayList.get(i1);
        if (((MsgTabNodeInfo)localObject).q > 0) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        AssertUtils.assertTrue(paramBoolean, "position must be greater than 0");
        int i3 = Math.min(((MsgTabNodeInfo)localObject).q + i2 - 1, paramArrayList.size());
        paramArrayList.add(i3, localObject);
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "sortNodeList() insert %s to nodeList index: %d", localObject, Integer.valueOf(i3));
        i1 += 1;
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
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "realHandlePushMsg() receive push! body: ", PBUtils.b(paramMsgTabNodePushNotify) });
    }
    MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
    localMsgTabNodeInfo.a((qqstory_service.MsgTabNodeInfo)paramMsgTabNodePushNotify.msg_notify_node_info.get());
    String str = paramMsgTabNodePushNotify.bytes_current_seq.get().toStringUtf8();
    int i1 = paramMsgTabNodePushNotify.uint32_notify_type.get();
    boolean bool1;
    if (paramMsgTabNodePushNotify.uint32_animate.get() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (i1 == 1)
    {
      if (localMsgTabNodeInfo.b == 5)
      {
        paramMsgTabNodePushNotify = this.n.d();
        if (paramMsgTabNodePushNotify.r > 0)
        {
          i1 = this.e.indexOf(localMsgTabNodeInfo);
          if (i1 != -1) {
            localMsgTabNodeInfo.a((MsgTabNodeInfo)this.e.get(i1));
          } else {
            localMsgTabNodeInfo.a(paramMsgTabNodePushNotify);
          }
        }
      }
      if ((localMsgTabNodeInfo.b == 7) && (this.e.indexOf(localMsgTabNodeInfo) == -1))
      {
        int i2 = this.e.size();
        i1 = 0;
        while (i1 < i2)
        {
          paramMsgTabNodePushNotify = (MsgTabNodeInfo)this.e.get(i1);
          if ((paramMsgTabNodePushNotify.b == 9) && (TextUtils.equals(localMsgTabNodeInfo.d, paramMsgTabNodePushNotify.d)))
          {
            this.e.set(i1, localMsgTabNodeInfo);
            this.n.b(paramMsgTabNodePushNotify);
            this.n.a(localMsgTabNodeInfo);
            if (paramBoolean)
            {
              a(paramMsgTabNodePushNotify, true, 3, bool1);
              a(localMsgTabNodeInfo, true, 1, bool1);
            }
            StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo.b) });
            return true;
          }
          i1 += 1;
        }
      }
      d(localMsgTabNodeInfo);
      bool2 = e(localMsgTabNodeInfo);
      c(Collections.singletonList(localMsgTabNodeInfo));
      b(Collections.singletonList(localMsgTabNodeInfo));
      if (bool2)
      {
        this.n.a(localMsgTabNodeInfo);
        this.f = new ArrayList(this.e);
        this.b = str;
        if (paramBoolean) {
          a(localMsgTabNodeInfo, true, 1, bool1);
        }
        StoryReportor.a("msg_tab", "exp_push", 0, 0, new String[] { String.valueOf(localMsgTabNodeInfo.b) });
      }
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data inserted, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.b, localMsgTabNodeInfo);
      return bool2;
    }
    if (i1 == 2)
    {
      bool2 = f(localMsgTabNodeInfo);
      if (bool2)
      {
        this.f = new ArrayList(this.e);
        this.n.b(localMsgTabNodeInfo);
        this.b = str;
        if (paramBoolean) {
          a(localMsgTabNodeInfo, true, 3, bool1);
        }
      }
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "realHandlePushMsg() data removed, change=%b, mSeq=%s, data=%s", Boolean.valueOf(bool2), this.b, localMsgTabNodeInfo);
    }
    return bool2;
  }
  
  public static boolean a(List<MsgTabNodeInfo> paramList1, List<MsgTabNodeInfo> paramList2)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "calc hasNewUnreadNodes(%s, %s)", paramList1, paramList2);
    HashSet localHashSet = new HashSet();
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    int i2;
    Object localObject3;
    while (i1 < paramList1.size())
    {
      localObject1 = ((MsgTabNodeInfo)paramList1.get(i1)).d;
      if (((MsgTabNodeInfo)paramList1.get(i1)).b != 12)
      {
        localObject2 = ((MsgTabNodeInfo)paramList1.get(i1)).e;
        i2 = 0;
        while (i2 < ((List)localObject2).size())
        {
          localObject3 = (MsgTabNodeVideoInfo)((List)localObject2).get(i2);
          if (!((MsgTabNodeVideoInfo)localObject3).b)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append("-");
            localStringBuilder.append(((MsgTabNodeVideoInfo)localObject3).a);
            localHashSet.add(localStringBuilder.toString());
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < paramList2.size())
    {
      paramList1 = ((MsgTabNodeInfo)paramList2.get(i1)).d;
      if (((MsgTabNodeInfo)paramList2.get(i1)).b != 12)
      {
        localObject1 = ((MsgTabNodeInfo)paramList2.get(i1)).e;
        i2 = 0;
        while (i2 < ((List)localObject1).size())
        {
          localObject2 = (MsgTabNodeVideoInfo)((List)localObject1).get(i2);
          if (!((MsgTabNodeVideoInfo)localObject2).b)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(paramList1);
            ((StringBuilder)localObject3).append("-");
            ((StringBuilder)localObject3).append(((MsgTabNodeVideoInfo)localObject2).a);
            if (!localHashSet.contains(((StringBuilder)localObject3).toString())) {
              return true;
            }
          }
          i2 += 1;
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean a(List<String> paramList, boolean paramBoolean)
  {
    boolean bool = paramList.isEmpty();
    int i1 = 0;
    if (bool)
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "loadUserItemOnWorkThread() unionIds is empty");
      return false;
    }
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    ArrayList localArrayList = new ArrayList();
    bool = false;
    while (i1 < paramList.size())
    {
      String str = (String)paramList.get(i1);
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
      i1 += 1;
    }
    if (!localArrayList.isEmpty())
    {
      if (paramBoolean)
      {
        new GetUserInfoHandler(this.A).a(1, localArrayList);
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
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "onHandlePushMsg %s", PBUtils.b(paramMsgTabNodePushNotify));
    }
    if (this.d.get())
    {
      this.i.add(paramMsgTabNodePushNotify);
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
    int i2 = 0;
    int i1 = 0;
    while ((i2 < paramList.size()) && (i1 < 8))
    {
      int i3 = i2 + 1;
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)paramList.get(i2);
      if (localMsgTabNodeInfo.i == 0)
      {
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(i2));
        break;
      }
      if ((localMsgTabNodeInfo.b == 6) || (localMsgTabNodeInfo.b == 9) || (localMsgTabNodeInfo.b == 7) || (localMsgTabNodeInfo.b == 5))
      {
        Iterator localIterator = localMsgTabNodeInfo.e.iterator();
        MsgTabNodeVideoInfo localMsgTabNodeVideoInfo;
        do
        {
          boolean bool = localIterator.hasNext();
          i2 = 1;
          if (!bool) {
            break;
          }
          localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)localIterator.next();
          if (TextUtils.isEmpty(localMsgTabNodeVideoInfo.c))
          {
            localArrayList1.add(localMsgTabNodeInfo);
            i1 += 1;
            SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] vid empty, will requestVids", Integer.valueOf(i3));
            break label245;
          }
        } while (localMsgTabNodeVideoInfo.b);
        localArrayList2.add(localMsgTabNodeVideoInfo.c);
        i1 += 1;
        SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] add %s to vid request list", Integer.valueOf(i3), localMsgTabNodeVideoInfo.c);
        break label245;
        i2 = 0;
        label245:
        if (i2 == 0)
        {
          SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "requestVideoInfoIfNecessary() [%d] node already read! break", Integer.valueOf(i3));
          break;
        }
      }
      i2 = i3;
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
  
  private void c(List<MsgTabNodeInfo> paramList)
  {
    UserManager localUserManager = (UserManager)SuperManager.a(2);
    paramList = new ArrayList(paramList);
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    while (i1 < paramList.size())
    {
      Object localObject = (MsgTabNodeInfo)paramList.get(i1);
      if ((((MsgTabNodeInfo)localObject).b != 12) && (((MsgTabNodeInfo)localObject).b != 10) && (((MsgTabNodeInfo)localObject).b != 11) && (((MsgTabNodeInfo)localObject).b != 13))
      {
        localObject = ((MsgTabNodeInfo)localObject).d;
        QQUserUIItem localQQUserUIItem = localUserManager.b((String)localObject);
        if ((localQQUserUIItem != null) && (localQQUserUIItem.isAvailable())) {
          a(localQQUserUIItem);
        } else {
          localArrayList.add(new QQUserUIItem.UserID("", (String)localObject));
        }
      }
      i1 += 1;
    }
    if (!localArrayList.isEmpty())
    {
      new GetUserInfoHandler(this.A).a(1, localArrayList);
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() Will fetch %s users", localArrayList);
      return;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.VASH", "requestUserItemIfNecessary() All nodes has local cache, no need request");
  }
  
  private void d(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    int i2 = paramMsgTabNodeInfo.e.size();
    int i1 = 0;
    while (i1 < paramMsgTabNodeInfo.e.size())
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramMsgTabNodeInfo.e.get(i1);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.d);
      ((StringBuilder)localObject).append("-");
      ((StringBuilder)localObject).append(localMsgTabNodeVideoInfo.a);
      localObject = ((StringBuilder)localObject).toString();
      localObject = (Boolean)this.o.get(localObject);
      if ((localObject != null) && (((Boolean)localObject).booleanValue())) {
        localMsgTabNodeVideoInfo.b = true;
      }
      int i3 = i2;
      if (localMsgTabNodeVideoInfo.b) {
        i3 = i2 - 1;
      }
      i1 += 1;
      i2 = i3;
    }
    paramMsgTabNodeInfo.i = i2;
  }
  
  private boolean e(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool;
    if (Thread.currentThread() == this.l) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    int i1 = this.e.indexOf(paramMsgTabNodeInfo);
    if (i1 != -1)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.e.get(i1);
      if (paramMsgTabNodeInfo.g >= localMsgTabNodeInfo.g) {
        this.e.remove(paramMsgTabNodeInfo);
      } else {
        return false;
      }
    }
    int i2 = this.e.size();
    i1 = 0;
    while (i1 < i2)
    {
      if (p.compare(paramMsgTabNodeInfo, this.e.get(i1)) <= 0)
      {
        this.e.add(i1, paramMsgTabNodeInfo);
        a(this.e, false);
        return true;
      }
      i1 += 1;
    }
    this.e.add(paramMsgTabNodeInfo);
    a(this.e, false);
    return true;
  }
  
  @WorkerThread
  private void f()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertOrUpdateSelfNodeWithUnUploadInfo()");
    MsgTabNodeInfo localMsgTabNodeInfo2 = this.n.d();
    if (localMsgTabNodeInfo2.r > 0)
    {
      MsgTabNodeInfo localMsgTabNodeInfo3 = a(localMsgTabNodeInfo2.b, localMsgTabNodeInfo2.d);
      MsgTabNodeInfo localMsgTabNodeInfo1 = localMsgTabNodeInfo2;
      if (localMsgTabNodeInfo3 != null)
      {
        localMsgTabNodeInfo3.a(localMsgTabNodeInfo2);
        localMsgTabNodeInfo1 = localMsgTabNodeInfo3;
      }
      a(localMsgTabNodeInfo1, false);
    }
  }
  
  private boolean f(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool;
    if (Thread.currentThread() == this.l) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    int i1 = this.e.indexOf(paramMsgTabNodeInfo);
    if (i1 != -1)
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)this.e.get(i1);
      if (paramMsgTabNodeInfo.g < localMsgTabNodeInfo.g) {
        return false;
      }
    }
    return this.e.remove(paramMsgTabNodeInfo);
  }
  
  public MsgTabNodeInfo a(int paramInt, String paramString)
  {
    if (this.e != null)
    {
      if (this.e.isEmpty()) {
        return null;
      }
      if (paramInt == -1)
      {
        Iterator localIterator = this.e.iterator();
        MsgTabNodeInfo localMsgTabNodeInfo;
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
        } while (!TextUtils.equals(localMsgTabNodeInfo.d, paramString));
        return localMsgTabNodeInfo;
      }
      paramString = new MsgTabNodeInfo(paramInt, paramString);
      paramInt = this.e.indexOf(paramString);
      if (paramInt != -1) {
        return (MsgTabNodeInfo)this.e.get(paramInt);
      }
    }
    return null;
  }
  
  public MsgTabNodeInfo a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.e != null))
    {
      if (this.e.isEmpty()) {
        return null;
      }
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
        if (TextUtils.equals(paramString, localMsgTabNodeInfo.d)) {
          return localMsgTabNodeInfo;
        }
      }
    }
    return null;
  }
  
  public void a()
  {
    this.g.clear();
    synchronized (this.j)
    {
      this.j.clear();
      this.k.removeCallbacksAndMessages(null);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.d;
    Boolean localBoolean = Boolean.valueOf(false);
    if (!((AtomicBoolean)localObject).compareAndSet(false, true))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "requestLatestPage() is loading, ignore this request...");
      }
      return;
    }
    localObject = new MsgTabNodeListRequest();
    ((MsgTabNodeListRequest)localObject).f = this.b;
    ((MsgTabNodeListRequest)localObject).g = paramInt;
    StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
    boolean bool = ((Boolean)localStoryConfigManager.c("key_force_refresh_msg_node_list", localBoolean)).booleanValue();
    if (bool) {
      localStoryConfigManager.d("key_force_refresh_msg_node_list", localBoolean);
    }
    ((MsgTabNodeListRequest)localObject).i = bool;
    CmdTaskManger.a().a((NetworkRequest)localObject, this.r);
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "requestLatestPage(): ", ((MsgTabNodeListRequest)localObject).toString() });
    }
  }
  
  public void a(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    if (paramStoryVideoPublishStatusEvent.b)
    {
      boolean bool = QLog.isDevelopLevel();
      int i2 = 0;
      if (bool)
      {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload event: mFakeStoryVideoItem:  isUploading: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.c.isUploading()), ", isUploadFaul: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.c.isUploadFail()), ", isUploadSucc: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.c.isUploadSuc()), ", isCancel: ", Boolean.valueOf(paramStoryVideoPublishStatusEvent.c.isCancel()) });
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "StoryVideoPublishStatusEvent event: ", String.valueOf(paramStoryVideoPublishStatusEvent) });
      }
      Object localObject3 = this.n.d();
      Object localObject2 = a(((MsgTabNodeInfo)localObject3).b, ((MsgTabNodeInfo)localObject3).d);
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new MsgTabNodeInfo(((MsgTabNodeInfo)localObject3).b, ((MsgTabNodeInfo)localObject3).d);
        ((MsgTabNodeInfo)localObject1).c = QQStoryContext.a().h();
        a((MsgTabNodeInfo)localObject1, false);
      }
      int i3 = ((MsgTabNodeInfo)localObject1).c();
      int i4 = ((MsgTabNodeInfo)localObject3).c();
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "upload status change, currentUploadStatus: ", Integer.valueOf(i3), "\tnewUploadStatus: ", Integer.valueOf(i4) });
      }
      ((MsgTabNodeInfo)localObject1).a((MsgTabNodeInfo)localObject3);
      if (paramStoryVideoPublishStatusEvent.d != null) {
        paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.d;
      } else {
        paramStoryVideoPublishStatusEvent = paramStoryVideoPublishStatusEvent.c;
      }
      int i1 = i2;
      if (paramStoryVideoPublishStatusEvent.isUploadSuc())
      {
        localObject2 = new MsgTabNodeVideoInfo();
        ((MsgTabNodeVideoInfo)localObject2).b = false;
        ((MsgTabNodeVideoInfo)localObject2).a = paramStoryVideoPublishStatusEvent.mVideoIndex;
        if (((MsgTabNodeVideoInfo)localObject2).a == 0L) {
          ((MsgTabNodeVideoInfo)localObject2).a = paramStoryVideoPublishStatusEvent.mCreateTime;
        }
        if (((MsgTabNodeInfo)localObject1).e.indexOf(localObject2) != -1) {
          i1 = 1;
        } else {
          i1 = 0;
        }
        if (i1 == 0)
        {
          ((MsgTabNodeInfo)localObject1).e.add(localObject2);
          ((MsgTabNodeInfo)localObject1).i += 1;
          ((MsgTabNodeInfo)localObject1).p = paramStoryVideoPublishStatusEvent.getThumbUrl();
          ((MsgTabNodeInfo)localObject1).h = (paramStoryVideoPublishStatusEvent.mCreateTime / 1000L);
          if (((MsgTabNodeInfo)localObject1).u == null) {
            ((MsgTabNodeInfo)localObject1).u = new ArrayList();
          }
          localObject3 = new MsgTabVideoData();
          ((MsgTabVideoData)localObject3).b = paramStoryVideoPublishStatusEvent.mAttachedFeedId;
          ((MsgTabVideoData)localObject3).c = paramStoryVideoPublishStatusEvent.mVid;
          ((MsgTabVideoData)localObject3).d = paramStoryVideoPublishStatusEvent.mVideoIndex;
          ((MsgTabVideoData)localObject3).a = false;
          ((MsgTabVideoData)localObject3).e = paramStoryVideoPublishStatusEvent;
          ((MsgTabNodeInfo)localObject1).u.add(localObject3);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , videoInfo=", localObject2, ", \nnodeInfo=", localObject1, ", \nnow videoList=", ((MsgTabNodeInfo)localObject1).e });
          }
          i1 = 1;
        }
        else
        {
          i1 = i2;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add videoInfo to list , but exist!!! videoInfo=", localObject2 });
            i1 = i2;
          }
        }
      }
      if (i3 != i4) {
        i1 = 1;
      }
      if (i1 != 0) {
        a((MsgTabNodeInfo)localObject1, true);
      }
    }
  }
  
  public void a(DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    if (!paramDeleteStoryVideoEvent.g.isSuccess()) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "delete video event, event=", paramDeleteStoryVideoEvent });
    }
    Object localObject;
    if (paramDeleteStoryVideoEvent.f)
    {
      localObject = this.n.d();
      MsgTabNodeInfo localMsgTabNodeInfo = a(((MsgTabNodeInfo)localObject).b, ((MsgTabNodeInfo)localObject).d);
      paramDeleteStoryVideoEvent = (DeleteStoryVideoEvent)localObject;
      if (localMsgTabNodeInfo != null)
      {
        localMsgTabNodeInfo.a((MsgTabNodeInfo)localObject);
        paramDeleteStoryVideoEvent = localMsgTabNodeInfo;
      }
      a(paramDeleteStoryVideoEvent, true);
      return;
    }
    int i1;
    if (!TextUtils.isEmpty(paramDeleteStoryVideoEvent.c)) {
      i1 = 8;
    } else {
      i1 = 5;
    }
    if (!TextUtils.isEmpty(paramDeleteStoryVideoEvent.c)) {
      localObject = paramDeleteStoryVideoEvent.c;
    } else {
      localObject = paramDeleteStoryVideoEvent.b;
    }
    a(i1, (String)localObject, paramDeleteStoryVideoEvent.e);
    a(i1, paramDeleteStoryVideoEvent.b, paramDeleteStoryVideoEvent.c);
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
      this.g.put(paramQQUserUIItem.uid, paramQQUserUIItem);
      return;
    }
    SLog.c("Q.qqstory.msgTab.MsgTabNodeListLoader", new IllegalArgumentException(), "addUserUIItemCache item Illegal %s", new Object[] { String.valueOf(paramQQUserUIItem) });
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)localIterator.next();
      if ((localMsgTabNodeInfo.b == 13) && (TextUtils.equals(localMsgTabNodeInfo.d, paramMsgTabNodeInfo.d))) {
        paramMsgTabNodeInfo.D = localMsgTabNodeInfo.D;
      }
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "insertNodeSync(%s, %b)", String.valueOf(paramMsgTabNodeInfo), Boolean.valueOf(paramBoolean));
    int i2 = this.e.indexOf(paramMsgTabNodeInfo);
    if (e(paramMsgTabNodeInfo))
    {
      this.n.a(paramMsgTabNodeInfo);
      this.f = new ArrayList(this.e);
      int i3 = this.e.indexOf(paramMsgTabNodeInfo);
      int i1 = 1;
      boolean bool;
      if (i2 != i3) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "insertNode: hasChangePos=", Boolean.valueOf(bool), ", oldIndex=", Integer.valueOf(i2), ", newIndex=", Integer.valueOf(i3) });
      }
      if (paramBoolean)
      {
        if (!bool) {
          i1 = 2;
        }
        a(paramMsgTabNodeInfo, false, i1, false);
      }
    }
  }
  
  protected void a(MsgTabNodeInfo paramMsgTabNodeInfo, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "notifySingleDataChange() data=%s, push=%b, type=%d, animate=%b", String.valueOf(paramMsgTabNodeInfo), Boolean.valueOf(paramBoolean1), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean2));
    int i1;
    if (paramInt == 1)
    {
      i1 = this.e.indexOf(paramMsgTabNodeInfo);
      if (i1 == -1)
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
      i1 = -1;
    }
    this.k.post(new MsgTabNodeListLoader.11(this, paramMsgTabNodeInfo, paramBoolean1, paramInt, i1, paramBoolean2));
  }
  
  public void a(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    synchronized (this.j)
    {
      if (this.j.contains(paramOnMsgTabNodeListLoadListener))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "listener already exist");
        }
        return;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "add listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
      }
      this.j.add(paramOnMsgTabNodeListLoadListener);
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
      bool = b();
      a(this.e, true);
      if (bool)
      {
        this.f = new ArrayList(this.e);
        a(this.f, true, this.c, true);
      }
      this.d.set(false);
      return;
    }
    a(true);
    this.z = paramMsgTabNodeListResponse.a;
    if (TextUtils.equals(this.b, paramMsgTabNodeListResponse.b))
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() seq(%s) equals, sort only, mData size=%d", this.b, Integer.valueOf(this.e.size()));
      if (paramErrorMessage.errorCode == 15001)
      {
        paramErrorMessage = null;
        paramMsgTabNodeListRequest = paramErrorMessage;
        if (paramMsgTabNodeListResponse.g.size() > 0)
        {
          i1 = 0;
          for (;;)
          {
            paramMsgTabNodeListRequest = paramErrorMessage;
            if (i1 >= paramMsgTabNodeListResponse.g.size()) {
              break;
            }
            paramMsgTabNodeListRequest = (MsgTabNodeInfo)paramMsgTabNodeListResponse.g.get(i1);
            if (paramMsgTabNodeListRequest.b == 12) {
              break;
            }
            i1 += 1;
          }
        }
        if (paramMsgTabNodeListRequest != null)
        {
          SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "weishi Node replace!");
          i1 = 0;
          while (i1 < this.e.size())
          {
            if (((MsgTabNodeInfo)this.e.get(i1)).b == 12)
            {
              this.e.set(i1, paramMsgTabNodeListRequest);
              i1 = 1;
              break label305;
            }
            i1 += 1;
          }
          i1 = 0;
          label305:
          if (i1 == 0) {
            this.e.add(paramMsgTabNodeListRequest);
          }
        }
      }
      a(this.e, true);
      b();
      c(this.e);
      b(this.e);
      a(this.e);
      this.f = new ArrayList(this.e);
      a(this.f, true, this.c, false);
      this.d.set(false);
      b(false);
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin syncLocalReadStatus() of nodeList, size = %d", Integer.valueOf(paramMsgTabNodeListResponse.g.size()));
    int i1 = 0;
    while (i1 < paramMsgTabNodeListResponse.g.size())
    {
      d((MsgTabNodeInfo)paramMsgTabNodeListResponse.g.get(i1));
      i1 += 1;
    }
    if (paramMsgTabNodeListRequest.g == 1) {
      bool = a(this.e, paramMsgTabNodeListResponse.g);
    } else {
      bool = false;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end syncLocalReadStatus() of nodeList");
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin replace mData with response, and sort data");
    this.b = paramMsgTabNodeListResponse.b;
    this.a = paramMsgTabNodeListResponse.e;
    this.e.clear();
    this.e.addAll(paramMsgTabNodeListResponse.g);
    a(this.e);
    a(this.e, true);
    this.c = paramMsgTabNodeListResponse.f;
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end replace mData with response");
    b();
    f();
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() begin save changedData(mData) to DB");
    this.n.a(this.e, true);
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() end save changedData(mData) to DB");
    c(this.e);
    b(this.e);
    this.f = new ArrayList(this.e);
    a(this.f, true, this.c, false);
    this.d.set(false);
    b(bool);
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "MsgTabNodeListResponse onCmdRespond() return, mData.size() = %d", Integer.valueOf(this.e.size()));
  }
  
  @WorkerThread
  public void a(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    StringBuilder localStringBuilder;
    if ((paramUpdateUserInfoEvent.g.isSuccess()) && (paramUpdateUserInfoEvent.b != null) && (!paramUpdateUserInfoEvent.b.isEmpty()))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onStoryUpdateUserInfoEvent isSuccess userUIItems: ");
        localStringBuilder.append(paramUpdateUserInfoEvent.b);
        QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, localStringBuilder.toString());
      }
      int i4 = paramUpdateUserInfoEvent.b.size();
      int i3 = 0;
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= i4) {
          break;
        }
        if (a(((QQUserUIItem)paramUpdateUserInfoEvent.b.get(i1)).uid) != null)
        {
          i2 = 1;
          break;
        }
        i1 += 1;
      }
      if (i2 != 0) {
        this.k.post(new MsgTabNodeListLoader.13(this));
      }
    }
    else if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStoryUpdateUserInfoEvent errorInfo: ");
      localStringBuilder.append(paramUpdateUserInfoEvent.g);
      localStringBuilder.append(", userUIItems = ");
      localStringBuilder.append(paramUpdateUserInfoEvent.b);
      QLog.i("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, localStringBuilder.toString());
    }
  }
  
  public void a(qqstory_service.MsgTabNodePushNotify paramMsgTabNodePushNotify)
  {
    boolean bool = QQStoryNetReqUtils.a();
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 1) && (!bool))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is not in testEnv", PBUtils.b(paramMsgTabNodePushNotify));
      return;
    }
    if ((paramMsgTabNodePushNotify.uint32_is_test_env.get() == 0) && (bool))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "handlePushMsg drop push %s, is in testEnv", PBUtils.b(paramMsgTabNodePushNotify));
      return;
    }
    this.m.post(new MsgTabNodeListLoader.6(this, paramMsgTabNodePushNotify));
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
    this.k.post(new MsgTabNodeListLoader.10(this, paramArrayList, paramBoolean1, paramBoolean2, paramBoolean3));
  }
  
  void a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list: %s", paramList);
      StoryManager localStoryManager = (StoryManager)SuperManager.a(5);
      int i1 = 0;
      while (i1 < paramList.size())
      {
        localStoryManager.b((String)paramList.get(i1));
        i1 += 1;
      }
      return;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "preloadVideoItemByVidList(), list is empty.");
  }
  
  protected void a(boolean paramBoolean)
  {
    this.k.post(new MsgTabNodeListLoader.8(this, paramBoolean));
  }
  
  public boolean a(int paramInt, String paramString, long paramLong)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "deleteNodeVideoFromNodeInfoFromWorkThread(type=%d, uid=%s, videoIndex=%d)", Integer.valueOf(paramInt), paramString, Long.valueOf(paramLong));
    paramString = a(paramInt, paramString);
    if (paramString == null) {
      return false;
    }
    paramInt = paramString.e.size() - 1;
    int i1 = 0;
    boolean bool2;
    for (boolean bool1 = false; paramInt >= 0; bool1 = bool2)
    {
      MsgTabNodeVideoInfo localMsgTabNodeVideoInfo = (MsgTabNodeVideoInfo)paramString.e.get(paramInt);
      int i2;
      if (localMsgTabNodeVideoInfo.a == paramLong)
      {
        paramString.e.remove(paramInt);
        bool2 = true;
        i2 = i1;
      }
      else
      {
        i2 = i1;
        bool2 = bool1;
        if (!localMsgTabNodeVideoInfo.b)
        {
          i2 = i1 + 1;
          bool2 = bool1;
        }
      }
      paramInt -= 1;
      i1 = i2;
    }
    paramString.i = i1;
    if ((!bool1) && (QLog.isDevelopLevel())) {
      QLog.e("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "deleteNodeVideoFromNodeInfoFromWorkThread, nothing to delete", " info.unreadCount =", Integer.valueOf(paramString.i), ", info.videoInfoList=", paramString.e });
    }
    if (paramString.e.isEmpty())
    {
      this.e.remove(paramString);
      this.f = new ArrayList(this.e);
      this.n.b(paramString);
      a(paramString, false, 3, false);
      return bool1;
    }
    if (bool1)
    {
      this.n.a(paramString);
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
    return MsgTabStoryManager.d(new MsgTabNodeInfo(paramInt, paramString1));
  }
  
  @WorkerThread
  public boolean a(String paramString, long paramLong)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "setNodeVideoIsRead(unionId=%s, index=%d)", paramString, Long.valueOf(paramLong));
    paramString = a(-1, paramString);
    if (paramString == null) {
      return false;
    }
    int i1 = paramString.e.size() - 1;
    Object localObject;
    while (i1 >= 0)
    {
      localObject = (MsgTabNodeVideoInfo)paramString.e.get(i1);
      if ((((MsgTabNodeVideoInfo)localObject).a == paramLong) && (!((MsgTabNodeVideoInfo)localObject).b))
      {
        ((MsgTabNodeVideoInfo)localObject).b = true;
        paramString.i -= 1;
        bool = true;
        break label112;
      }
      i1 -= 1;
    }
    boolean bool = false;
    label112:
    if ((paramString.i <= 0) && (!paramString.e.isEmpty()))
    {
      localObject = new MsgTabNodeWatchedRequest();
      ((MsgTabNodeWatchedRequest)localObject).f = paramString.d;
      ((MsgTabNodeWatchedRequest)localObject).g = paramString.b;
      ((MsgTabNodeWatchedRequest)localObject).h = 5;
      ((MsgTabNodeWatchedRequest)localObject).i = paramString.j;
      CmdTaskManger.a().a((NetworkRequest)localObject, null);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "update unread count, hasChangeUnRead? :", Boolean.valueOf(bool), ", videoIndex=", Long.valueOf(paramLong), ", \ninfo=", paramString, ", \nvideoInfo=", paramString.e });
    }
    if (bool)
    {
      i1 = this.e.indexOf(paramString);
      if (i1 >= 0)
      {
        localObject = (MsgTabNodeInfo)this.e.get(i1);
        ((MsgTabNodeInfo)localObject).copy(paramString);
        this.n.a((MsgTabNodeInfo)localObject);
      }
      a(paramString, false, 2, false);
    }
    return bool;
  }
  
  public void b(StoryVideoUploadManager.StoryVideoPublishStatusEvent paramStoryVideoPublishStatusEvent)
  {
    this.m.post(new MsgTabNodeListLoader.15(this, paramStoryVideoPublishStatusEvent));
  }
  
  public void b(DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    this.m.post(new MsgTabNodeListLoader.16(this, paramDeleteStoryVideoEvent));
  }
  
  public void b(MsgTabNodeListLoader.OnMsgTabNodeListLoadListener paramOnMsgTabNodeListLoadListener)
  {
    synchronized (this.j)
    {
      this.j.remove(paramOnMsgTabNodeListLoadListener);
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, new Object[] { "remove listener ", paramOnMsgTabNodeListLoadListener.getClass().getSimpleName() });
      }
      return;
    }
  }
  
  public void b(GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent)
  {
    this.m.post(new MsgTabNodeListLoader.14(this, paramUpdateUserInfoEvent));
  }
  
  public void b(String paramString)
  {
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "scheduleRequireUserItem() %s", paramString);
    Message.obtain(this.m, 2, paramString).sendToTarget();
  }
  
  public void b(String paramString, long paramLong)
  {
    this.m.post(new MsgTabNodeListLoader.12(this, paramString, paramLong));
  }
  
  @GuardedBy("mNotifyLock")
  public void b(boolean paramBoolean)
  {
    synchronized (this.s)
    {
      this.u = true;
      this.x = paramBoolean;
      int i1;
      if (this.t)
      {
        i1 = 1;
      }
      else
      {
        this.v = true;
        i1 = 0;
      }
      if (i1 != 0)
      {
        ??? = new ArrayList(this.e).iterator();
        while (((Iterator)???).hasNext())
        {
          MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)???).next();
          if ((localMsgTabNodeInfo.i > 0) && (localMsgTabNodeInfo.b == 6)) {
            this.w = true;
          }
        }
        ((QQStoryHandler)QQStoryContext.k().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1026, true, Boolean.valueOf(false));
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  protected boolean b()
  {
    SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue()");
    boolean bool;
    if (Thread.currentThread() == this.l) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (this.i.size() > 0)
    {
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() mWaitingQueue.size() > 0");
      Iterator localIterator = this.i.iterator();
      bool = false;
      while (localIterator.hasNext()) {
        bool |= a((qqstory_service.MsgTabNodePushNotify)localIterator.next(), false);
      }
      if (bool) {
        this.f = new ArrayList(this.e);
      }
      this.i.clear();
    }
    else
    {
      bool = false;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabNodeListLoader", "applyWaitingQueue() return, hasChange = %b", Boolean.valueOf(bool));
    return bool;
  }
  
  public boolean b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool = f(paramMsgTabNodeInfo);
    if (bool)
    {
      this.n.b(paramMsgTabNodeInfo);
      a(paramMsgTabNodeInfo, false, 3, false);
    }
    return bool;
  }
  
  public ArrayList<MsgTabNodeInfo> c()
  {
    return this.e;
  }
  
  public void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.m.post(new MsgTabNodeListLoader.7(this, paramMsgTabNodeInfo));
  }
  
  @UiThread
  public ArrayList<MsgTabNodeInfo> d()
  {
    boolean bool;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    return this.f;
  }
  
  @GuardedBy("mNotifyLock")
  public void e()
  {
    boolean bool;
    if (RedPointUtils.a(52) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.y = bool;
    if ((this.v) && (this.t)) {
      return;
    }
    for (;;)
    {
      synchronized (this.s)
      {
        this.t = true;
        if (this.v)
        {
          this.v = false;
          i1 = 1;
          if (i1 != 0) {
            ((QQStoryHandler)QQStoryContext.k().getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1026, true, Boolean.valueOf(false));
          }
          return;
        }
      }
      int i1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader
 * JD-Core Version:    0.7.0.1
 */