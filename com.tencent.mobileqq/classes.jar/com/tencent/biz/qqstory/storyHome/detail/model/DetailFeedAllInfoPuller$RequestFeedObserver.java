package com.tencent.biz.qqstory.storyHome.detail.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;

public class DetailFeedAllInfoPuller$RequestFeedObserver
  extends SimpleObserver
{
  public DetailFeedAllInfoPuller$RequestFeedObserver(DetailFeedAllInfoPuller paramDetailFeedAllInfoPuller) {}
  
  public void a(DetailFeedItem paramDetailFeedItem)
  {
    super.onNext(paramDetailFeedItem);
    DetailFeedAllInfoPuller.a(this.a, paramDetailFeedItem, false, new ErrorMessage());
  }
  
  public void onCancel()
  {
    super.onCancel();
    SLog.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "refresh data cancel");
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    DetailFeedAllInfoPuller.a(this.a, null, false, (ErrorMessage)paramError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.RequestFeedObserver
 * JD-Core Version:    0.7.0.1
 */