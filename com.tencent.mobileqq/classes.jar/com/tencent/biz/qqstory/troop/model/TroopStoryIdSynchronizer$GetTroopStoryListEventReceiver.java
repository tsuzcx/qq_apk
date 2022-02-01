package com.tencent.biz.qqstory.troop.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.GetTroopStoryListHandler.GetTroopStoryListEvent;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.List;

public class TroopStoryIdSynchronizer$GetTroopStoryListEventReceiver
  extends QQUIEventReceiver<TroopStoryIdSynchronizer, GetTroopStoryListHandler.GetTroopStoryListEvent>
{
  public void a(@NonNull TroopStoryIdSynchronizer paramTroopStoryIdSynchronizer, @NonNull GetTroopStoryListHandler.GetTroopStoryListEvent paramGetTroopStoryListEvent)
  {
    if (!paramTroopStoryIdSynchronizer.b.equals(paramGetTroopStoryListEvent.jdField_a_of_type_JavaLangString)) {
      return;
    }
    List localList = paramGetTroopStoryListEvent.jdField_a_of_type_JavaUtilList;
    if ((paramGetTroopStoryListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess()) && (localList != null) && (!localList.isEmpty()))
    {
      paramTroopStoryIdSynchronizer.a(localList);
      paramTroopStoryIdSynchronizer.jdField_a_of_type_JavaUtilList.addAll(localList);
      paramTroopStoryIdSynchronizer.jdField_d_of_type_Boolean = paramGetTroopStoryListEvent.jdField_a_of_type_Boolean;
      paramTroopStoryIdSynchronizer.jdField_d_of_type_Int = paramGetTroopStoryListEvent.jdField_a_of_type_Int;
      paramTroopStoryIdSynchronizer.a();
    }
    paramTroopStoryIdSynchronizer.c = false;
  }
  
  public Class acceptEventClass()
  {
    return GetTroopStoryListHandler.GetTroopStoryListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryIdSynchronizer.GetTroopStoryListEventReceiver
 * JD-Core Version:    0.7.0.1
 */