package com.tencent.biz.qqstory.storyHome;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.reactive.SimpleObserver;

class QQStoryTakeVideoHelper$2
  extends SimpleObserver<Void>
{
  QQStoryTakeVideoHelper$2(QQStoryTakeVideoHelper paramQQStoryTakeVideoHelper, QQStoryTakeVideoHelper.GenerateManifestCallback paramGenerateManifestCallback) {}
  
  public void a(Void paramVoid)
  {
    super.onNext(paramVoid);
    SLog.b("QQStoryTakeVideoHelper", "generate video manifest success.");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a = 2;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper$GenerateManifestCallback.a();
  }
  
  public void onError(@NonNull Error paramError)
  {
    super.onError(paramError);
    SLog.e("QQStoryTakeVideoHelper", "generate video manifest failed.");
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper.a = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryTakeVideoHelper$GenerateManifestCallback.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryTakeVideoHelper.2
 * JD-Core Version:    0.7.0.1
 */