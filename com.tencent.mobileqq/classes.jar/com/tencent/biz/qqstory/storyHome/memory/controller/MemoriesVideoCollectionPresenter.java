package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.DataSortedComparator;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import nxc;
import nxd;

public class MemoriesVideoCollectionPresenter
  implements IEventReceiver
{
  public int a;
  private MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter$VideoCollectionPresenterEventListener;
  private MemoryDataPuller jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller;
  private VideoCollectionItem.DataSortedComparator jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$DataSortedComparator = new VideoCollectionItem.DataSortedComparator();
  public String a;
  public ArrayList a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private nxc jdField_a_of_type_Nxc;
  private nxd jdField_a_of_type_Nxd;
  public boolean a;
  public boolean b = true;
  
  public MemoriesVideoCollectionPresenter(String paramString, @NonNull MemoriesVideoCollectionPresenter.VideoCollectionPresenterEventListener paramVideoCollectionPresenterEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoriesVideoCollectionPresenter$VideoCollectionPresenterEventListener = paramVideoCollectionPresenterEventListener;
  }
  
  private void a(VideoCollectionItem paramVideoCollectionItem)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.indexOf(paramVideoCollectionItem) > 0) {
      SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "data already exist, id=%s, time=%d", paramVideoCollectionItem.collectionId, Long.valueOf(paramVideoCollectionItem.collectionTime));
    }
    do
    {
      return;
      i = Collections.binarySearch(this.jdField_a_of_type_JavaUtilArrayList, paramVideoCollectionItem, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryModelVideoCollectionItem$DataSortedComparator);
    } while (i >= 0);
    int i = -i;
    this.jdField_a_of_type_JavaUtilArrayList.add(i - 1, paramVideoCollectionItem);
  }
  
  public VideoCollectionItem a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      VideoCollectionItem localVideoCollectionItem2 = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      VideoCollectionItem localVideoCollectionItem1;
      if (localVideoCollectionItem2.isEmptyFakeItem)
      {
        if (this.jdField_a_of_type_JavaUtilArrayList.size() >= 2)
        {
          localVideoCollectionItem1 = (VideoCollectionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 2);
          if (TextUtils.isEmpty(localVideoCollectionItem1.collectionId)) {}
        }
      }
      else {
        do
        {
          return localVideoCollectionItem1;
          localVideoCollectionItem1 = localVideoCollectionItem2;
        } while (!TextUtils.isEmpty(localVideoCollectionItem2.collectionId));
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Nxc = new nxc(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Nxc);
    this.jdField_a_of_type_Nxd = new nxd(this);
    Dispatchers.get().registerSubscriber(this.jdField_a_of_type_Nxd);
  }
  
  public void a(String paramString)
  {
    SLog.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request video info list.");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a(paramString);
  }
  
  public void a(List paramList)
  {
    SLog.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request visit count.");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.b(paramList, true);
  }
  
  public void a(List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((VideoCollectionItem)paramList.next());
    }
    if ((this.jdField_a_of_type_JavaUtilArrayList.size() > 0) && (paramBoolean2))
    {
      paramList = ((UserManager)SuperManager.a(2)).b(this.jdField_a_of_type_JavaLangString);
      if ((paramList != null) && (!paramList.isMe()) && (!paramList.isFriend()) && (!paramList.isVip))
      {
        paramList = new VideoCollectionItem();
        paramList.collectionType = 8;
        paramList.collectionId = "";
        paramList.collectionTime = -1L;
        paramList.key = "local_desc_item";
        paramList.isEmptyFakeItem = true;
        this.jdField_a_of_type_JavaUtilArrayList.add(paramList);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SLog.b("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request refresh video collection data. from cache : %s.", Boolean.valueOf(paramBoolean));
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller = new MemoryDataPuller(this.jdField_a_of_type_JavaLangString, String.valueOf(hashCode()));
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a();
    }
    if (paramBoolean)
    {
      DateCollectionListPageLoader.GetCollectionListEvent localGetCollectionListEvent = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a();
      a(localGetCollectionListEvent.jdField_a_of_type_JavaUtilList, localGetCollectionListEvent.c, localGetCollectionListEvent.jdField_a_of_type_Boolean);
      this.b = localGetCollectionListEvent.jdField_a_of_type_Boolean;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_Boolean = true;
      }
      SLog.a("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "get video collection data from cache: collectionList.size() = %d.", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()));
      return;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.d();
  }
  
  public void b()
  {
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Nxc);
    Dispatchers.get().unRegisterSubscriber(this.jdField_a_of_type_Nxd);
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.b();
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void c()
  {
    SLog.c("Q.qqstory.memories.MemoriesVideoCollectionPresenter", "request load next page video collection.");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryControllerMemoryDataPuller.a(a());
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesVideoCollectionPresenter
 * JD-Core Version:    0.7.0.1
 */