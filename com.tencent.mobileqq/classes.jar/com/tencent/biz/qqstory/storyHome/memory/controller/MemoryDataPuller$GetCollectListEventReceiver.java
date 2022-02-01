package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.BatchHandlerListPuller;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MemoryDataPuller$GetCollectListEventReceiver
  extends QQUIEventReceiver<MemoryDataPuller, DateCollectionListPageLoader.GetCollectionListEvent>
{
  public MemoryDataPuller$GetCollectListEventReceiver(MemoryDataPuller paramMemoryDataPuller)
  {
    super(paramMemoryDataPuller);
  }
  
  public void a(MemoryDataPuller paramMemoryDataPuller, DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (!TextUtils.equals(paramGetCollectionListEvent.jdField_a_of_type_JavaLangString, paramMemoryDataPuller.c)) {
      return;
    }
    paramMemoryDataPuller.b(paramMemoryDataPuller.b);
    if (!paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
    {
      if (!paramGetCollectionListEvent.e) {
        return;
      }
      if (paramGetCollectionListEvent.c) {
        paramMemoryDataPuller.a.clear();
      }
      paramGetCollectionListEvent = paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList;
      if (paramGetCollectionListEvent != null)
      {
        paramGetCollectionListEvent = paramGetCollectionListEvent.iterator();
        while (paramGetCollectionListEvent.hasNext())
        {
          VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramGetCollectionListEvent.next();
          Object localObject1 = new ArrayList();
          ArrayList localArrayList = new ArrayList(localVideoCollectionItem.videoVidList);
          Object localObject2 = new ArrayList();
          Iterator localIterator = localVideoCollectionItem.videoItemList.iterator();
          while (localIterator.hasNext()) {
            ((ArrayList)localObject2).add(((StoryVideoItem)localIterator.next()).mVid);
          }
          localArrayList.removeAll((Collection)localObject2);
          int j;
          for (int i = 0; i < localArrayList.size(); i = j)
          {
            j = Math.min(localArrayList.size(), i + 20);
            if (i >= j) {
              break;
            }
            localObject2 = localArrayList.subList(i, j);
            ((List)localObject1).add(paramMemoryDataPuller.a(localVideoCollectionItem.collectionId, (List)localObject2));
          }
          localObject1 = new BatchHandlerListPuller((List)localObject1);
          ((BatchHandlerListPuller)localObject1).a("Q.qqstory.memories:MemoryDataPuller");
          paramMemoryDataPuller.a.put(localVideoCollectionItem.collectionId, localObject1);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.GetCollectListEventReceiver
 * JD-Core Version:    0.7.0.1
 */