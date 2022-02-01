package com.tencent.biz.qqstory.base.download;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class DownloadUrlManager$1
  implements DownloadUrlManager.PullNewVideoInfoCallBack
{
  DownloadUrlManager$1(DownloadUrlManager paramDownloadUrlManager, String paramString, int paramInt, DownloadUrlManager.QueryUrlResultUICallBack paramQueryUrlResultUICallBack) {}
  
  public void a(boolean paramBoolean)
  {
    DownloadUrlManager.DownloadUrlQueryResult localDownloadUrlQueryResult = this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloadUrlManager.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramBoolean);
    ThreadManager.getUIHandler().post(new DownloadUrlManager.1.1(this, localDownloadUrlQueryResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.download.DownloadUrlManager.1
 * JD-Core Version:    0.7.0.1
 */