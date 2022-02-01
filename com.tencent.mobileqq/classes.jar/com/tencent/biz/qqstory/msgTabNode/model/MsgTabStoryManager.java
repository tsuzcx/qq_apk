package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Looper;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader;
import com.tencent.biz.qqstory.support.ImageDownloader.FILE;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.biz.qqstory.utils.DateUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class MsgTabStoryManager
  implements Manager
{
  MsgTabNodeListLoader a = new MsgTabNodeListLoader(QQStoryContext.j(), this);
  MsgTabStoryVideoPreloader b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  public int h;
  public int i;
  public ArrayList<MsgTabNodeInfo> j = new ArrayList();
  
  public MsgTabStoryManager(QQAppInterface paramQQAppInterface) {}
  
  public static MsgTabStoryManager a(QQAppInterface paramQQAppInterface)
  {
    return (MsgTabStoryManager)paramQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
  }
  
  public static void a(MsgTabNodeInfo paramMsgTabNodeInfo, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramMsgTabNodeInfo.b;
    localMsgTabNodeVidListEntity.unionId = paramMsgTabNodeInfo.d;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramMsgTabNodeInfo.g;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramMsgTabNodeInfo.w;
    localEntityManager.persistOrReplace(localMsgTabNodeVidListEntity);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 60	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 63	com/tencent/biz/qqstory/app/QQStoryContext:d	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   6: invokevirtual 69	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 114	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: invokevirtual 119	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   17: iload_1
    //   18: ifeq +26 -> 44
    //   21: new 121	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 122	com/tencent/biz/qqstory/database/MsgTabNodeEntity:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: sipush 1001
    //   33: invokevirtual 126	com/tencent/biz/qqstory/database/MsgTabNodeEntity:setStatus	(I)V
    //   36: aload_2
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 130	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 134	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 140 1 0
    //   55: ifeq +40 -> 95
    //   58: aload_0
    //   59: invokeinterface 144 1 0
    //   64: checkcast 121	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 145	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   72: iconst_1
    //   73: if_icmpeq -24 -> 49
    //   76: aload_3
    //   77: getfield 145	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   80: iconst_2
    //   81: if_icmpne +6 -> 87
    //   84: goto -35 -> 49
    //   87: aload_2
    //   88: aload_3
    //   89: invokevirtual 107	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   92: goto -43 -> 49
    //   95: aload_2
    //   96: invokevirtual 114	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   99: invokevirtual 148	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   102: goto +17 -> 119
    //   105: astore_0
    //   106: goto +21 -> 127
    //   109: astore_0
    //   110: ldc 150
    //   112: aload_0
    //   113: invokestatic 155	com/tencent/biz/qqstory/utils/StoryDebugUtils$StoryExceptionCallback:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   116: invokestatic 160	com/tencent/qqperf/monitor/crash/catchedexception/CaughtExceptionReport:a	(Ljava/lang/Throwable;)V
    //   119: aload_2
    //   120: invokevirtual 114	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   123: invokevirtual 163	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   126: return
    //   127: aload_2
    //   128: invokevirtual 114	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   131: invokevirtual 163	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   134: goto +5 -> 139
    //   137: aload_0
    //   138: athrow
    //   139: goto -2 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	142	1	paramBoolean	boolean
    //   9	119	2	localEntityManager	EntityManager
    //   28	61	3	localMsgTabNodeEntity	MsgTabNodeEntity
    // Exception table:
    //   from	to	target	type
    //   21	44	105	finally
    //   44	49	105	finally
    //   49	84	105	finally
    //   87	92	105	finally
    //   95	102	105	finally
    //   110	119	105	finally
    //   21	44	109	java/lang/NullPointerException
    //   44	49	109	java/lang/NullPointerException
    //   49	84	109	java/lang/NullPointerException
    //   87	92	109	java/lang/NullPointerException
    //   95	102	109	java/lang/NullPointerException
  }
  
  public static byte[] c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    Object localObject = QQStoryContext.a().d().createEntityManager().query(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramMsgTabNodeInfo), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramMsgTabNodeInfo.g)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("db has valid vid list, nodeType=");
          localStringBuilder.append(paramMsgTabNodeInfo.b);
          localStringBuilder.append(", unionId=");
          localStringBuilder.append(paramMsgTabNodeInfo.d);
          QLog.d("Q.qqstory.msgTab.mgr", 2, localStringBuilder.toString());
        }
        return ((MsgTabNodeVidListEntity)localObject).rspData;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("db vid list expired, nodeType=");
        ((StringBuilder)localObject).append(paramMsgTabNodeInfo.b);
        ((StringBuilder)localObject).append(", unionId=");
        ((StringBuilder)localObject).append(paramMsgTabNodeInfo.d);
        QLog.d("Q.qqstory.msgTab.mgr", 2, ((StringBuilder)localObject).toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("no db vid list, nodeType=");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.b);
      ((StringBuilder)localObject).append(", unionId=");
      ((StringBuilder)localObject).append(paramMsgTabNodeInfo.d);
      QLog.d("Q.qqstory.msgTab.mgr", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public static boolean d(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramMsgTabNodeInfo.b;
    localMsgTabNodeVidListEntity.unionId = paramMsgTabNodeInfo.d;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localEntityManager.remove(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramMsgTabNodeInfo));
  }
  
  public static final boolean f(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo = QQStoryContext.a().d().createEntityManager().query(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramMsgTabNodeInfo), null, null, null, null, null);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMsgTabNodeInfo != null)
    {
      bool1 = bool2;
      if (paramMsgTabNodeInfo.size() > 0)
      {
        paramMsgTabNodeInfo = (MsgTabNodeRecommendActivityReadEntity)paramMsgTabNodeInfo.get(0);
        bool1 = bool2;
        if (paramMsgTabNodeInfo != null)
        {
          bool1 = bool2;
          if (paramMsgTabNodeInfo.hasRead == 1) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static final void g(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    QQStoryContext.a().d().createEntityManager().persistOrReplace(new MsgTabNodeRecommendActivityReadEntity(paramMsgTabNodeInfo, 1));
  }
  
  public MsgTabNodeListLoader a()
  {
    return this.a;
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    boolean bool;
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (paramMsgTabNodeEntity.nodeType != 1)
    {
      if (paramMsgTabNodeEntity.nodeType == 2) {
        return;
      }
      QQStoryContext.a().d().createEntityManager().persistOrReplace(paramMsgTabNodeEntity);
    }
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo = paramMsgTabNodeInfo.a();
    if (paramMsgTabNodeInfo.nodeType != 1)
    {
      if (paramMsgTabNodeInfo.nodeType == 2) {
        return;
      }
      ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramMsgTabNodeInfo));
    }
  }
  
  public void a(List<MsgTabNodeInfo> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
      if ((localMsgTabNodeInfo.b != 1) && (localMsgTabNodeInfo.b != 2)) {
        paramList.add(localMsgTabNodeInfo.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.a.f;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
        if ((localMsgTabNodeInfo.b == 12) && (TextUtils.equals(paramString, localMsgTabNodeInfo.d))) {
          return true;
        }
      }
    }
    return false;
  }
  
  @UiThread
  public MsgTabNodeInfo b(String paramString)
  {
    Object localObject = this.a.f;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localMsgTabNodeInfo.d)) {
          return localMsgTabNodeInfo;
        }
      }
    }
    return null;
  }
  
  public MsgTabStoryVideoPreloader b()
  {
    if (this.b == null) {
      try
      {
        if (this.b == null) {
          this.b = new MsgTabStoryVideoPreloader();
        }
      }
      finally {}
    }
    return this.b;
  }
  
  public void b(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    boolean bool;
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    if (paramMsgTabNodeEntity.nodeType != 1)
    {
      if (paramMsgTabNodeEntity.nodeType == 2) {
        return;
      }
      EntityManager localEntityManager = QQStoryContext.a().d().createEntityManager();
      paramMsgTabNodeEntity.setStatus(1001);
      localEntityManager.remove(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
      localEntityManager.remove(paramMsgTabNodeEntity);
    }
  }
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo = paramMsgTabNodeInfo.a();
    if (paramMsgTabNodeInfo.nodeType != 1)
    {
      if (paramMsgTabNodeInfo.nodeType == 2) {
        return;
      }
      ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramMsgTabNodeInfo));
    }
  }
  
  public ArrayList<MsgTabNodeInfo> c()
  {
    Object localObject = QQStoryContext.a().d().createEntityManager().query(MsgTabNodeEntity.class);
    if (localObject == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeEntity localMsgTabNodeEntity = (MsgTabNodeEntity)((Iterator)localObject).next();
      MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
      if (localMsgTabNodeInfo.b != 12) {
        localMsgTabNodeInfo.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localMsgTabNodeInfo);
    }
    Collections.sort(localArrayList, new MsgTabNodeInfoComparator());
    this.j = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public MsgTabNodeInfo d()
  {
    Object localObject1 = (StoryManager)SuperManager.a(5);
    int k = 0;
    List localList = ((StoryManager)localObject1).a(false);
    MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
    localMsgTabNodeInfo.b = 5;
    localMsgTabNodeInfo.d = QQStoryContext.a().i();
    localMsgTabNodeInfo.c = QQStoryContext.a().h();
    localMsgTabNodeInfo.r = localList.size();
    localMsgTabNodeInfo.h = (System.currentTimeMillis() / 1000L);
    localMsgTabNodeInfo.s = false;
    localMsgTabNodeInfo.i = localList.size();
    localObject1 = "";
    Object localObject2 = localObject1;
    boolean bool = false;
    while (k < localList.size())
    {
      Object localObject3 = (StoryVideoItem)localList.get(k);
      localObject2 = localObject1;
      if (((StoryVideoItem)localObject3).isUploading())
      {
        if (TextUtils.isEmpty(((StoryVideoItem)localObject3).mVideoLocalThumbnailPath)) {
          localObject1 = ImageDownloader.FILE.a(((StoryVideoItem)localObject3).mVideoLocalThumbnailOrigFakePath);
        } else {
          localObject1 = ImageDownloader.FILE.a(((StoryVideoItem)localObject3).mVideoLocalThumbnailPath);
        }
        bool = true;
        localObject2 = localObject1;
      }
      if (TextUtils.isEmpty(((StoryVideoItem)localObject3).mVideoLocalThumbnailPath)) {
        localObject1 = ImageDownloader.FILE.a(((StoryVideoItem)localObject3).mVideoLocalThumbnailOrigFakePath);
      } else {
        localObject1 = ImageDownloader.FILE.a(((StoryVideoItem)localObject3).mVideoLocalThumbnailPath);
      }
      SLog.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(k), Long.valueOf(((StoryVideoItem)localObject3).mLocalCreateTime), Long.valueOf(((StoryVideoItem)localObject3).mCreateTime), ((StoryVideoItem)localObject3).mVid);
      k += 1;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    localMsgTabNodeInfo.s = bool;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject1 = localObject2;
    }
    localMsgTabNodeInfo.t = ((String)localObject1);
    SLog.b("VASH", "getUnUploadInfo %s", String.valueOf(localMsgTabNodeInfo));
    return localMsgTabNodeInfo;
  }
  
  public void e(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.a.a(paramMsgTabNodeInfo);
  }
  
  public boolean e()
  {
    MsgTabNodeListLoader localMsgTabNodeListLoader = a();
    SLog.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localMsgTabNodeListLoader.y), Boolean.valueOf(localMsgTabNodeListLoader.w), Boolean.valueOf(localMsgTabNodeListLoader.x));
    return localMsgTabNodeListLoader.y;
  }
  
  public boolean f()
  {
    MsgTabNodeListLoader localMsgTabNodeListLoader = a();
    SLog.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localMsgTabNodeListLoader.y), Boolean.valueOf(localMsgTabNodeListLoader.w), Boolean.valueOf(localMsgTabNodeListLoader.x));
    return localMsgTabNodeListLoader.w;
  }
  
  public boolean g()
  {
    if (!TextUtils.equals(DateUtils.a(), (String)((StoryConfigManager)SuperManager.a(10)).c("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      MsgTabNodeListLoader localMsgTabNodeListLoader = a();
      SLog.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localMsgTabNodeListLoader.z));
      return localMsgTabNodeListLoader.z;
    }
    SLog.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void h()
  {
    String str = DateUtils.a();
    SLog.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((StoryConfigManager)SuperManager.a(10)).d("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void onDestroy()
  {
    MsgTabNodeListLoader localMsgTabNodeListLoader = this.a;
    if (localMsgTabNodeListLoader != null) {
      localMsgTabNodeListLoader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager
 * JD-Core Version:    0.7.0.1
 */