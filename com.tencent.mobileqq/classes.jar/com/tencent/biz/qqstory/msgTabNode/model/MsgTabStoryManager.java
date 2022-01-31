package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabStoryVideoPreloader;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
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
  
  public void a(List paramList, boolean paramBoolean)
  {
    EntityManager localEntityManager = QQStoryContext.a().a().createEntityManager();
    localEntityManager.a().a();
    if (paramBoolean) {}
    try
    {
      Object localObject = new MsgTabNodeEntity();
      ((MsgTabNodeEntity)localObject).setStatus(1001);
      localEntityManager.a((Entity)localObject, null, null);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (MsgTabNodeInfo)paramList.next();
        if ((((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 1) && (((MsgTabNodeInfo)localObject).jdField_a_of_type_Int != 2)) {
          localEntityManager.b(((MsgTabNodeInfo)localObject).a());
        }
      }
    }
    finally
    {
      localEntityManager.a().b();
    }
    localEntityManager.a().b();
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