package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupVideoDataProvider$GetShareGroupDateListReceiver
  extends QQUIEventReceiver
{
  public ShareGroupVideoDataProvider$GetShareGroupDateListReceiver(@NonNull ShareGroupVideoDataProvider paramShareGroupVideoDataProvider)
  {
    super(paramShareGroupVideoDataProvider);
  }
  
  public void a(@NonNull ShareGroupVideoDataProvider paramShareGroupVideoDataProvider, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (!TextUtils.equals(paramGetCollectionListEvent.jdField_a_of_type_JavaLangString, paramShareGroupVideoDataProvider.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "GetMemoryKeyListReceiver onEvent: mIsEnd = " + paramGetCollectionListEvent.jdField_a_of_type_Boolean + ", list data: " + paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList.toString());
    }
    paramShareGroupVideoDataProvider.jdField_a_of_type_Boolean = paramGetCollectionListEvent.jdField_a_of_type_Boolean;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList.size())
    {
      localArrayList.add(((VideoCollectionItem)paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList.get(i)).feedId);
      i += 1;
    }
    paramShareGroupVideoDataProvider.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
    paramShareGroupVideoDataProvider.c();
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.ShareGroupVideoDataProvider.GetShareGroupDateListReceiver
 * JD-Core Version:    0.7.0.1
 */