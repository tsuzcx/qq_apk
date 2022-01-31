package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader;
import com.tencent.mobileqq.app.QQAppInterface;
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
  MsgTabNodeListLoader jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader;
  MsgTabStoryVideoPreloader jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeNetworkMsgTabStoryVideoPreloader;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public int b;
  
  public MsgTabStoryManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(MsgTabNodeInfo paramMsgTabNodeInfo, byte[] paramArrayOfByte)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.reqTimeStamp = paramMsgTabNodeInfo.jdField_c_of_type_Long;
    localMsgTabNodeVidListEntity.rspData = paramArrayOfByte;
    localMsgTabNodeVidListEntity.requestSource = paramMsgTabNodeInfo.e;
    localEntityManager.b(localMsgTabNodeVidListEntity);
  }
  
  public static boolean a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeVidListEntity localMsgTabNodeVidListEntity = new MsgTabNodeVidListEntity();
    localMsgTabNodeVidListEntity.nodeType = paramMsgTabNodeInfo.jdField_a_of_type_Int;
    localMsgTabNodeVidListEntity.unionId = paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString;
    localMsgTabNodeVidListEntity.setStatus(1001);
    return localEntityManager.a(localMsgTabNodeVidListEntity, "nodeType=? and unionId=?", MsgTabNodeVidListEntity.getArgs(paramMsgTabNodeInfo));
  }
  
  public static byte[] a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    byte[] arrayOfByte = null;
    Object localObject = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeVidListEntity.class, MsgTabNodeVidListEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramMsgTabNodeInfo), null, null, null, null, null);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (MsgTabNodeVidListEntity)((List)localObject).get(0);
      if (((MsgTabNodeVidListEntity)localObject).reqTimeStamp == paramMsgTabNodeInfo.jdField_c_of_type_Long)
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
    paramMsgTabNodeInfo = QQStoryContext.a().a().createEntityManager().a(MsgTabNodeRecommendActivityReadEntity.class, MsgTabNodeRecommendActivityReadEntity.class.getSimpleName(), false, MsgTabNodeVidListEntity.getSelection(), MsgTabNodeVidListEntity.getArgs(paramMsgTabNodeInfo), null, null, null, null, null);
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
  
  public static final void c(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    QQStoryContext.a().a().createEntityManager().b(new MsgTabNodeRecommendActivityReadEntity(paramMsgTabNodeInfo, 1));
  }
  
  public MsgTabNodeInfo a()
  {
    Object localObject = ((StoryManager)SuperManager.a(5)).a(false);
    MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
    localMsgTabNodeInfo.jdField_a_of_type_Int = 5;
    localMsgTabNodeInfo.jdField_a_of_type_JavaLangString = QQStoryContext.a().b();
    localMsgTabNodeInfo.jdField_b_of_type_Long = QQStoryContext.a().a();
    localMsgTabNodeInfo.jdField_c_of_type_Int = ((List)localObject).size();
    localMsgTabNodeInfo.d = (System.currentTimeMillis() / 1000L);
    localMsgTabNodeInfo.jdField_b_of_type_Boolean = false;
    localMsgTabNodeInfo.jdField_b_of_type_Int = ((List)localObject).size();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((StoryVideoItem)((Iterator)localObject).next()).isUploading()) {
        localMsgTabNodeInfo.jdField_b_of_type_Boolean = true;
      }
    }
    return localMsgTabNodeInfo;
  }
  
  public MsgTabNodeListLoader a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader == null) {}
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader == null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader = new MsgTabNodeListLoader(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader;
    }
    finally {}
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
  
  public ArrayList a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager();
    ArrayList localArrayList = new ArrayList();
    localObject = ((EntityManager)localObject).a(MsgTabNodeEntity.class);
    if (localObject == null) {
      return localArrayList;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MsgTabNodeEntity localMsgTabNodeEntity = (MsgTabNodeEntity)((Iterator)localObject).next();
      MsgTabNodeInfo localMsgTabNodeInfo = new MsgTabNodeInfo();
      localMsgTabNodeInfo.a(localMsgTabNodeEntity);
      localArrayList.add(localMsgTabNodeInfo);
    }
    Collections.sort(localArrayList, new MsgTabNodeInfoComparator());
    return localArrayList;
  }
  
  public void a(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((paramMsgTabNodeInfo.jdField_a_of_type_Int == 1) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 2)) {
      return;
    }
    QQStoryContext.a().a().createEntityManager().b(paramMsgTabNodeInfo.a());
  }
  
  /* Error */
  public void a(List paramList, boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 26	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/biz/qqstory/app/QQStoryContext;
    //   3: invokevirtual 29	com/tencent/biz/qqstory/app/QQStoryContext:a	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   6: invokevirtual 35	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   9: astore_3
    //   10: aload_3
    //   11: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   14: invokevirtual 257	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   17: iload_2
    //   18: ifeq +29 -> 47
    //   21: new 225	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeEntity
    //   24: dup
    //   25: invokespecial 258	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeEntity:<init>	()V
    //   28: astore 4
    //   30: aload 4
    //   32: sipush 1001
    //   35: invokevirtual 259	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeEntity:setStatus	(I)V
    //   38: aload_3
    //   39: aload 4
    //   41: aconst_null
    //   42: aconst_null
    //   43: invokevirtual 87	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;Ljava/lang/String;[Ljava/lang/String;)Z
    //   46: pop
    //   47: aload_1
    //   48: invokeinterface 191 1 0
    //   53: astore_1
    //   54: aload_1
    //   55: invokeinterface 196 1 0
    //   60: ifeq +63 -> 123
    //   63: aload_1
    //   64: invokeinterface 200 1 0
    //   69: checkcast 40	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo
    //   72: astore 4
    //   74: aload 4
    //   76: getfield 42	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo:jdField_a_of_type_Int	I
    //   79: iconst_1
    //   80: if_icmpeq -26 -> 54
    //   83: aload 4
    //   85: getfield 42	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo:jdField_a_of_type_Int	I
    //   88: iconst_2
    //   89: if_icmpeq -35 -> 54
    //   92: aload_3
    //   93: aload 4
    //   95: invokevirtual 247	com/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeInfo:a	()Lcom/tencent/biz/qqstory/msgTabNode/model/MsgTabNodeEntity;
    //   98: invokevirtual 73	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   101: goto -47 -> 54
    //   104: astore_1
    //   105: aload_1
    //   106: ldc_w 261
    //   109: ldc_w 263
    //   112: invokestatic 269	com/tencent/mobileqq/statistics/QQCatchedExceptionReporter:reportQQCatchedException	(Ljava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_3
    //   116: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   119: invokevirtual 271	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   122: return
    //   123: aload_3
    //   124: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   127: invokevirtual 273	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   130: aload_3
    //   131: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   134: invokevirtual 271	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   137: return
    //   138: astore_1
    //   139: aload_3
    //   140: invokevirtual 253	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   143: invokevirtual 271	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   146: aload_1
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	MsgTabStoryManager
    //   0	148	1	paramList	List
    //   0	148	2	paramBoolean	boolean
    //   9	131	3	localEntityManager	EntityManager
    //   28	66	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   21	47	104	java/lang/NullPointerException
    //   47	54	104	java/lang/NullPointerException
    //   54	101	104	java/lang/NullPointerException
    //   123	130	104	java/lang/NullPointerException
    //   21	47	138	finally
    //   47	54	138	finally
    //   54	101	138	finally
    //   105	115	138	finally
    //   123	130	138	finally
  }
  
  public void b(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    if ((paramMsgTabNodeInfo.jdField_a_of_type_Int == 1) || (paramMsgTabNodeInfo.jdField_a_of_type_Int == 2)) {
      return;
    }
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    MsgTabNodeEntity localMsgTabNodeEntity = paramMsgTabNodeInfo.a();
    localMsgTabNodeEntity.setStatus(1001);
    localEntityManager.a(localMsgTabNodeEntity, "nodeType=? and uid=? and unionId=?", new String[] { String.valueOf(paramMsgTabNodeInfo.jdField_a_of_type_Int), String.valueOf(paramMsgTabNodeInfo.jdField_b_of_type_Long), paramMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
    localEntityManager.b(localMsgTabNodeEntity);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeListLoader.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryManager
 * JD-Core Version:    0.7.0.1
 */