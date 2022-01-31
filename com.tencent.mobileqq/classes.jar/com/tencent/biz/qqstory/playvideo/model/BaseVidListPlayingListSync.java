package com.tencent.biz.qqstory.playvideo.model;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer;
import com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.RetryableSynchronizer;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller;
import com.tencent.biz.qqstory.model.IVidToVideoInfoPuller.OnFinishCallBack;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public abstract class BaseVidListPlayingListSync
  extends DefaultPlayerVideoListSynchronizer
  implements DefaultPlayerVideoListSynchronizer.RetryableSynchronizer
{
  protected int a;
  protected IVidToVideoInfoPuller a;
  protected String a;
  
  public BaseVidListPlayingListSync(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = a();
  }
  
  public abstract int a();
  
  public abstract IVidToVideoInfoPuller a();
  
  public void a()
  {
    super.a();
  }
  
  public void a(String paramString, IVidToVideoInfoPuller.OnFinishCallBack paramOnFinishCallBack)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller.a(paramOnFinishCallBack);
  }
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller.a()) && (TextUtils.isEmpty(paramStoryVideoItem.mVideoUrl)) && (TextUtils.isEmpty(paramStoryVideoItem.mLocalVideoPath));
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller.b();
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller = a();
      this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller.a(this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryModelIVidToVideoInfoPuller.a();
  }
  
  public boolean isValidate()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.BaseVidListPlayingListSync
 * JD-Core Version:    0.7.0.1
 */