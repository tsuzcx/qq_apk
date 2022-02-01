package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.videostory.support.VSReporter;
import dov.com.qq.im.capture.music.MusicDownloadListener;

class VideoCompositeHelper$3
  extends MusicDownloadListener
{
  private long jdField_a_of_type_Long = 0L;
  
  VideoCompositeHelper$3(VideoCompositeHelper paramVideoCompositeHelper, PublishVideoEntry paramPublishVideoEntry, VideoCompositeHelper.RetCode paramRetCode, String paramString) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a(-3);
    this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a("task canceled");
    VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper, "needAndStartDownloadMusic");
  }
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean)
  {
    SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download");
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "[vs_publish_flow] | fakeid:" + this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.fakeVid + " music onStart download onFinish ");
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.backgroundMusicPath = paramString;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_Long;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a(paramInt);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a("unknown error the music download failed");
    }
    for (;;)
    {
      VSReporter.a("edit_music_download", VSReporter.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a(), l1 - l2, this.jdField_a_of_type_JavaLangString, FileUtils.a(paramString)));
      VideoCompositeHelper.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper, "needAndStartDownloadMusic");
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a("music downloadSuccess");
      continue;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a(-2);
      this.jdField_a_of_type_ComTencentBizQqstoryBaseVideouploadVideoCompositeHelper$RetCode.a("none network");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.3
 * JD-Core Version:    0.7.0.1
 */