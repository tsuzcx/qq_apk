package com.tencent.biz.qqstory.base.videoupload;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import dov.com.qq.im.story.StoryGameAudioMixManager;
import java.io.File;

class VideoCompositeManager$1
  extends SimpleJob<String>
{
  VideoCompositeManager$1(VideoCompositeManager paramVideoCompositeManager, String paramString1, String paramString2, long paramLong)
  {
    super(paramString1);
  }
  
  protected String a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    SLog.d("Q.qqstory.publish.upload.VideoCompositeManager", "start composite vid:%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    paramJobContext = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    paramVarArgs = QQStoryConstant.e + System.currentTimeMillis() + ".mp4";
    new File(QQStoryConstant.e).mkdirs();
    if (!TextUtils.isEmpty(paramJobContext.mbgmAudioFilePath)) {
      StoryGameAudioMixManager.a().a(paramJobContext.mAudioFilePath, paramJobContext.mbgmAudioFilePath);
    }
    new VideoCompositeHelper().a(paramJobContext, paramVarArgs, false, true, new VideoCompositeManager.1.1(this, paramJobContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager.1
 * JD-Core Version:    0.7.0.1
 */