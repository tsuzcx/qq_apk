package com.tencent.biz.qqstory.base.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

class DownloadUrlManager$2
  extends SimpleJob<Object>
{
  DownloadUrlManager$2(DownloadUrlManager paramDownloadUrlManager, String paramString1, String paramString2, int paramInt, DownloadUrlManager.QueryUrlResultUICallBack paramQueryUrlResultUICallBack)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, false);
    ThreadManager.getUIHandler().post(new DownloadUrlManager.2.1(this, paramJobContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.2
 * JD-Core Version:    0.7.0.1
 */