package com.tencent.biz.qqstory.base.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

class DownloadUrlManager$3
  extends SimpleJob<Void>
{
  DownloadUrlManager$3(DownloadUrlManager paramDownloadUrlManager, String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = DownloadUrlManager.a(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    if (paramJobContext != null)
    {
      paramVarArgs = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_JavaLangString);
      long l1;
      if (paramVarArgs == null) {
        l1 = 0L;
      } else {
        l1 = paramVarArgs.mCreateTime;
      }
      long l2;
      if (paramJobContext.updatedMs > 0L) {
        l2 = paramJobContext.updatedMs;
      } else {
        l2 = System.currentTimeMillis();
      }
      int i = paramJobContext.compressLevel;
      StoryReportor.b("download_video", "video_download_info", 0, 0, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(i), this.jdField_a_of_type_JavaLangString });
      SLog.a("Q.qqstory.DownloadUrlManager", "report url level , vid = %s , compress level = %d , cms = %d , dms = %d", this.jdField_a_of_type_JavaLangString, Integer.valueOf(i), Long.valueOf(l1), Long.valueOf(l2));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.3
 * JD-Core Version:    0.7.0.1
 */