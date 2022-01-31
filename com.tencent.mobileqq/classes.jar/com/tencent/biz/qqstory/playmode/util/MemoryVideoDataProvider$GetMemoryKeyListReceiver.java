package com.tencent.biz.qqstory.playmode.util;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller.GetMemoryCollectionKeyEvent;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;

public class MemoryVideoDataProvider$GetMemoryKeyListReceiver
  extends QQUIEventReceiver
{
  public MemoryVideoDataProvider$GetMemoryKeyListReceiver(@NonNull MemoryVideoDataProvider paramMemoryVideoDataProvider)
  {
    super(paramMemoryVideoDataProvider);
  }
  
  public void a(@NonNull MemoryVideoDataProvider paramMemoryVideoDataProvider, @NonNull MemoryDataPuller.GetMemoryCollectionKeyEvent paramGetMemoryCollectionKeyEvent)
  {
    if (!TextUtils.equals(paramGetMemoryCollectionKeyEvent.jdField_a_of_type_JavaLangString, paramMemoryVideoDataProvider.jdField_a_of_type_JavaLangString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.TAG, 2, "GetMemoryKeyListReceiver onEvent: mIsEnd = " + paramGetMemoryCollectionKeyEvent.jdField_a_of_type_Boolean + ", list data: " + paramGetMemoryCollectionKeyEvent.jdField_a_of_type_JavaUtilList.toString());
    }
    paramMemoryVideoDataProvider.jdField_a_of_type_Boolean = paramGetMemoryCollectionKeyEvent.jdField_a_of_type_Boolean;
    paramMemoryVideoDataProvider.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramGetMemoryCollectionKeyEvent.jdField_a_of_type_JavaUtilList);
    paramMemoryVideoDataProvider.b = paramGetMemoryCollectionKeyEvent.jdField_a_of_type_JavaUtilArrayList;
    paramMemoryVideoDataProvider.c();
  }
  
  public Class acceptEventClass()
  {
    return MemoryDataPuller.GetMemoryCollectionKeyEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.MemoryVideoDataProvider.GetMemoryKeyListReceiver
 * JD-Core Version:    0.7.0.1
 */