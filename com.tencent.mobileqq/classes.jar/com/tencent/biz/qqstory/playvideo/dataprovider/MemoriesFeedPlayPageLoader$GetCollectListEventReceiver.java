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
    if (TextUtils.equals(MemoriesFeedPlayPageLoader.a(paramMemoriesFeedPlayPageLoader).mContext, paramGetCollectionListEvent.i))
    {
      if (MemoriesFeedPlayPageLoader.b(paramMemoriesFeedPlayPageLoader) == null) {
        return;
      }
      if (paramGetCollectionListEvent.g.isFail())
      {
        SLog.a(this.TAG, "pull feedId list fail %s", paramGetCollectionListEvent.g.errorMsg);
        MemoriesFeedPlayPageLoader.b(paramMemoriesFeedPlayPageLoader).a(new ErrorMessage(paramGetCollectionListEvent.g.errorCode, paramGetCollectionListEvent.g.errorMsg), null, false);
        return;
      }
      MemoriesFeedPlayPageLoader.a(paramMemoriesFeedPlayPageLoader).mIsEnd = paramGetCollectionListEvent.a;
      MemoriesFeedPlayPageLoader.b(paramMemoriesFeedPlayPageLoader).b(new ErrorMessage(), MemoriesFeedPlayPageLoader.b(paramGetCollectionListEvent.e), paramGetCollectionListEvent.a);
    }
  }
  
  public Class acceptEventClass()
  {
    return DateCollectionListPageLoader.GetCollectionListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.dataprovider.MemoriesFeedPlayPageLoader.GetCollectListEventReceiver
 * JD-Core Version:    0.7.0.1
 */