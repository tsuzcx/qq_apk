package com.tencent.biz.qqstory.playvideo.dataprovider;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.network.handler.DateCollectionListPageLoader.GetCollectionListEvent;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

class MemoriesFeedPlayPageLoader$GetCollectListEventReceiver
  extends QQUIEventReceiver<MemoriesFeedPlayPageLoader, DateCollectionListPageLoader.GetCollectionListEvent>
{
  public MemoriesFeedPlayPageLoader$GetCollectListEventReceiver(@NonNull MemoriesFeedPlayPageLoader paramMemoriesFeedPlayPageLoader)
  {
    super(paramMemoriesFeedPlayPageLoader);
  }
  
  public void a(@NonNull MemoriesFeedPlayPageLoader paramMemoriesFeedPlayPageLoader, @NonNull DateCollectionListPageLoader.GetCollectionListEvent paramGetCollectionListEvent)
  {
    if (TextUtils.equals(MemoriesFeedPlayPageLoader.a(paramMemoriesFeedPlayPageLoader).mContext, paramGetCollectionListEvent.jdField_a_of_type_JavaLangString))
    {
      if (MemoriesFeedPlayPageLoader.a(paramMemoriesFeedPlayPageLoader) == null) {
        return;
      }
      if (paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isFail())
      {
        SLog.a(this.TAG, "pull feedId list fail %s", paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg);
        MemoriesFeedPlayPageLoader.a(paramMemoriesFeedPlayPageLoader).a(new ErrorMessage(paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorCode, paramGetCollectionListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.errorMsg), null, false);
        return;
      }
      MemoriesFeedPlayPageLoader.a(paramMemoriesFeedPlayPageLoader).mIsEnd = paramGetCollectionListEvent.jdField_a_of_type_Boolean;
      MemoriesFeedPlayPageLoader.a(paramMemoriesFeedPlayPageLoader).b(new ErrorMessage(), MemoriesFeedPlayPageLoader.b(paramGetCollectionListEvent.jdField_a_of_type_JavaUtilList), paramGetCollectionListEvent.jdField_a_of_type_Boolean);
    }
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader.GetCollectListEventReceiver
 * JD-Core Version:    0.7.0.1
 */