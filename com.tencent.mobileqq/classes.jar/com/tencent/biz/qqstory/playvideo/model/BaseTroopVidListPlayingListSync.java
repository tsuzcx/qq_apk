package com.tencent.biz.qqstory.playvideo.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.TroopVidToVideoInfoPuller;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class BaseTroopVidListPlayingListSync
  extends DefaultPlayerVideoListSynchronizer
  implements DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  protected TroopVidToVideoInfoPuller a;
  protected String a;
  
  protected abstract TroopVidToVideoInfoPuller a();
  
  public void a()
  {
    super.a();
  }
  
  public void a(String paramString, IVidToVideoInfoPuller.OnFinishCallBack paramOnFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a(paramOnFinishCallBack);
  }
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a()) && (TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl)) && (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath));
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.b();
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller = a();
      this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a(this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelTroopVidToVideoInfoPuller.a();
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BaseTroopVidListPlayingListSync
 * JD-Core Version:    0.7.0.1
 */