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
  public int a;
  MsgTabNodeListLoader jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader = new MsgTabNodeListLoader(QQStoryContext.a(), this);
  MsgTabStoryVideoPreloader jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader;
  public ArrayList<MsgTabNodeInfo> a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g;
  
  public MsgTabStoryManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public static MsgTabStoryManager a(QQAppInterface paramQQAppInterface)
  {
    return (MsgTabStoryManager)paramQQAppInterface.getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER);
  }
  
  public static void a(MsgTabNodeInfo paramMsgTabNodeInfo, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramMsgTabNodeInfo.c;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramMsgTabNodeInfo.f;
    localEntityManager.persistOrReplace(localMsgTabNodeVidListEntity);
  }
  
  /* Error */
  public static void a(ArrayList<MsgTabNodeEntity> paramArrayList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 57	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 60	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   6: invokevirtual 66	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: invokevirtual 115	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   17: iload_1
    //   18: ifeq +26 -> 44
    //   21: new 117	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 118	com/tencent/biz/qqstory/database/MsgTabNodeEntity:<init>	()V
    //   28: astore_3
    //   29: aload_3
    //   30: sipush 1001
    //   33: invokevirtual 122	com/tencent/biz/qqstory/database/MsgTabNodeEntity:setStatus	(I)V
    //   36: aload_2
    //   37: aload_3
    //   38: aconst_null
    //   39: aconst_null
    //   40: invokevirtual 126	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   43: pop
    //   44: aload_0
    //   45: invokevirtual 130	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_0
    //   49: aload_0
    //   50: invokeinterface 136 1 0
    //   55: ifeq +55 -> 110
    //   58: aload_0
    //   59: invokeinterface 140 1 0
    //   64: checkcast 117	com/tencent/biz/qqstory/database/MsgTabNodeEntity
    //   67: astore_3
    //   68: aload_3
    //   69: getfield 141	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   72: iconst_1
    //   73: if_icmpeq -24 -> 49
    //   76: aload_3
    //   77: getfield 141	com/tencent/biz/qqstory/database/MsgTabNodeEntity:nodeType	I
    //   80: iconst_2
    //   81: if_icmpeq -32 -> 49
    //   84: aload_2
    //   85: aload_3
    //   86: invokevirtual 103	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   89: goto -40 -> 49
    //   92: astore_0
    //   93: ldc 143
    //   95: aload_0
    //   96: invokestatic 148	com/tencent/biz/qqstory/utils/StoryDebugUtils$StoryExceptionCallback:b	(Ljava/lang/String;Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   99: invokestatic 153	com/tencent/mobileqq/statistics/CaughtExceptionReport:a	(Ljava/lang/Throwable;)V
    //   102: aload_2
    //   103: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   106: invokevirtual 156	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   109: return
    //   110: aload_2
    //   111: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   114: invokevirtual 159	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   117: aload_2
    //   118: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   121: invokevirtual 156	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   124: return
    //   125: astore_0
    //   126: aload_2
    //   127: invokevirtual 110	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   130: invokevirtual 156	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   133: aload_0
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	paramArrayList	ArrayList<MsgTabNodeEntity>
    //   0	135	1	paramBoolean	boolean
    //   9	118	2	localEntityManager	EntityManager
    //   28	58	3	localMsgTabNodeEntity	MsgTabNodeEntity
    // Exception table:
    //   from	to	target	type
    //   21	44	92	java/lang/NullPointerException
    //   44	49	92	java/lang/NullPointerException
    //   49	89	92	java/lang/NullPointerException
    //   110	117	92	java/lang/NullPointerException
    //   21	44	125	finally
    //   44	49	125	finally
    //   49	89	125	finally
    //   93	102	125	finally
    //   110	117	125	finally
  }
  
  public static boolean a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localEntityManager.remove(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramMsgTabNodeInfo));
  }
  
  public static byte[] a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramMsgTabNodeInfo), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramMsgTabNodeInfo.c)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.msgTab.mgr", 2, "db has valid vid list, nodeType=" + paramMsgTabNodeInfo.jdField_a_of_type_Int + ", unionId=" + paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
        }
        arrayOfByte = ((MsgTabNodeVidListEntity)localObject).rspData;
      }
    }
    while (!QLog.isColorLevel())
    {
      do
      {
        return arrayOfByte;
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.msgTab.mgr", 2, "db vid list expired, nodeType=" + paramMsgTabNodeInfo.jdField_a_of_type_Int + ", unionId=" + paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
      return null;
    }
    QLog.d("Q.qqstory.msgTab.mgr", 2, "no db vid list, nodeType=" + paramMsgTabNodeInfo.jdField_a_of_type_Int + ", unionId=" + paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString);
    return null;
  }
  
  public static final boolean b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    boolean bool2 = false;
    paramMsgTabNodeInfo = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeRecommendActivityReadEntity.getSelection(), MsgTabNodeRecommendActivityReadEntity.getArgs(paramMsgTabNodeInfo), null, null, null, null, null);
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
  
  public static final void d(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    QQStoryContext.a().a().createEntityManager().persistOrReplace(new MsgTabNodeRecommendActivityReadEntity(paramMsgTabNodeInfo, 1));
  }
  
  public MsgTabNodeInfo a()
  {
    List localList = ((StoryManager)SuperManager.a(5)).a(false);
    MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
    localMsgTabNodeInfo.jdField_a_of_type_Int = 5;
    localMsgTabNodeInfo.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localMsgTabNodeInfo.jdField_b_of_type_Long = QQStoryContext.a().a();
    localMsgTabNodeInfo.jdField_d_of_type_Int = localList.size();
    localMsgTabNodeInfo.jdField_d_of_type_Long = (System.currentTimeMillis() / 1000L);
    localMsgTabNodeInfo.jdField_b_of_type_Boolean = false;
    localMsgTabNodeInfo.jdField_b_of_type_Int = localList.size();
    int i = 0;
    String str2 = "";
    boolean bool = false;
    String str1 = "";
    StoryVideoItem localStoryVideoItem;
    if (i < localList.size())
    {
      localStoryVideoItem = (StoryVideoItem)localList.get(i);
      if (!localStoryVideoItem.isUploading()) {
        break label288;
      }
      bool = true;
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {
        str1 = ImageDownloader.FILE.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);
      }
    }
    label159:
    label288:
    for (;;)
    {
      if (TextUtils.isEmpty(localStoryVideoItem.mVideoLocalThumbnailPath)) {}
      for (str2 = ImageDownloader.FILE.a(localStoryVideoItem.mVideoLocalThumbnailOrigFakePath);; str2 = ImageDownloader.FILE.a(localStoryVideoItem.mVideoLocalThumbnailPath))
      {
        SLog.b("Q.qqstory.msgTab.mgrVASH", "getLocalList: %d time: %d %d vid: %s", Integer.valueOf(i), Long.valueOf(localStoryVideoItem.mLocalCreateTime), Long.valueOf(localStoryVideoItem.mCreateTime), localStoryVideoItem.mVid);
        i += 1;
        break;
        str1 = ImageDownloader.FILE.a(localStoryVideoItem.mVideoLocalThumbnailPath);
        break label159;
      }
      localMsgTabNodeInfo.jdField_b_of_type_Boolean = bool;
      if (!TextUtils.isEmpty(str1)) {}
      for (;;)
      {
        localMsgTabNodeInfo.h = str1;
        SLog.b("VASH", "getUnUploadInfo %s", String.valueOf(localMsgTabNodeInfo));
        return localMsgTabNodeInfo;
        str1 = str2;
      }
    }
  }
  
  @UiThread
  public MsgTabNodeInfo a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
        if (TextUtils.equals(paramString, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString)) {
          return localMsgTabNodeInfo;
        }
      }
    }
    return null;
  }
  
  public MsgTabNodeListLoader a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader;
  }
  
  public MsgTabStoryVideoPreloader a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader = new MsgTabStoryVideoPreloader();
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader;
    }
    finally {}
  }
  
  public ArrayList<MsgTabNodeInfo> a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager().query(MsgTabNodeEntity.class);
    if (localObject == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeEntity localMsgTabNodeEntity = (MsgTabNodeEntity)((Iterator)localObject).next();
      MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
      if (localMsgTabNodeInfo.jdField_a_of_type_Int != 12) {
        localMsgTabNodeInfo.a(localMsgTabNodeEntity);
      }
      localArrayList.add(localMsgTabNodeInfo);
    }
    Collections.sort(localArrayList, new MsgTabNodeInfoComparator());
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    return new ArrayList(localArrayList);
  }
  
  public void a()
  {
    String str = DateUtils.a();
    SLog.a("Q.qqstory.msgTab.mgr", "markShowAnimate() %s", str);
    ((StoryConfigManager)SuperManager.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", str);
  }
  
  public void a(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    QQStoryContext.a().a().createEntityManager().persistOrReplace(paramMsgTabNodeEntity);
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo = paramMsgTabNodeInfo.a();
    if ((paramMsgTabNodeInfo.nodeType == 1) || (paramMsgTabNodeInfo.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.2(this, paramMsgTabNodeInfo));
  }
  
  public void a(List<MsgTabNodeInfo> paramList, boolean paramBoolean)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
      if ((localMsgTabNodeInfo.jdField_a_of_type_Int != 1) && (localMsgTabNodeInfo.jdField_a_of_type_Int != 2)) {
        paramList.add(localMsgTabNodeInfo.a());
      }
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.1(this, paramList, paramBoolean));
  }
  
  public boolean a()
  {
    MsgTabNodeListLoader localMsgTabNodeListLoader = a();
    SLog.a("Q.qqstory.msgTab.mgr", "hasRedPoint() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localMsgTabNodeListLoader.g), Boolean.valueOf(localMsgTabNodeListLoader.e), Boolean.valueOf(localMsgTabNodeListLoader.f));
    return localMsgTabNodeListLoader.g;
  }
  
  @UiThread
  public boolean a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.b;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MsgTabNodeInfo localMsgTabNodeInfo = (MsgTabNodeInfo)((Iterator)localObject).next();
        if ((localMsgTabNodeInfo.jdField_a_of_type_Int == 12) && (TextUtils.equals(paramString, localMsgTabNodeInfo.jdField_a_of_type_JavaLangString))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public void b(MsgTabNodeEntity paramMsgTabNodeEntity)
  {
    if (Looper.myLooper() == ThreadManagerV2.getFileThreadLooper()) {}
    for (boolean bool = true;; bool = false)
    {
      AssertUtils.a(bool);
      if ((paramMsgTabNodeEntity.nodeType != 1) && (paramMsgTabNodeEntity.nodeType != 2)) {
        break;
      }
      return;
    }
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    paramMsgTabNodeEntity.setStatus(1001);
    localEntityManager.remove(paramMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeEntity.nodeType), String.valueOf(paramMsgTabNodeEntity.uid), paramMsgTabNodeEntity.unionId });
    localEntityManager.remove(paramMsgTabNodeEntity);
  }
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    paramMsgTabNodeInfo = paramMsgTabNodeInfo.a();
    if ((paramMsgTabNodeInfo.nodeType == 1) || (paramMsgTabNodeInfo.nodeType == 2)) {
      return;
    }
    ThreadManagerV2.executeOnFileThread(new MsgTabStoryManager.3(this, paramMsgTabNodeInfo));
  }
  
  public boolean b()
  {
    MsgTabNodeListLoader localMsgTabNodeListLoader = a();
    SLog.a("Q.qqstory.msgTab.mgr", "hasUnreadNode() hasRedPoint=%b, hasUnreadNode=%b, hasNewUnreadNode=%b", Boolean.valueOf(localMsgTabNodeListLoader.g), Boolean.valueOf(localMsgTabNodeListLoader.e), Boolean.valueOf(localMsgTabNodeListLoader.f));
    return localMsgTabNodeListLoader.e;
  }
  
  public void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a(paramMsgTabNodeInfo);
  }
  
  public boolean c()
  {
    if (!TextUtils.equals(DateUtils.a(), (String)((StoryConfigManager)SuperManager.a(10)).b("key_msg_tab_show_node_list_breath_view_animate_date", "")))
    {
      MsgTabNodeListLoader localMsgTabNodeListLoader = a();
      SLog.a("Q.qqstory.msgTab.mgr", "shouldShowAnimate() date not equal and mShouldShowAnimate=%b", Boolean.valueOf(localMsgTabNodeListLoader.h));
      return localMsgTabNodeListLoader.h;
    }
    SLog.b("Q.qqstory.msgTab.mgr", "shouldShowAnimate() return false");
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager
 * JD-Core Version:    0.7.0.1
 */