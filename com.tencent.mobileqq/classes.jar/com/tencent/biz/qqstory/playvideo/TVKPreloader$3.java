package com.tencent.biz.qqstory.playvideo;

import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.QueryUrlResultUICallBack;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import java.io.File;

final class TVKPreloader$3
  implements DownloadUrlManager.QueryUrlResultUICallBack
{
  TVKPreloader$3(File paramFile, String paramString) {}
  
  public void a(DownloadUrlManager.DownloadUrlQueryResult paramDownloadUrlQueryResult)
  {
    String str = paramDownloadUrlQueryResult.b;
    if (str != null)
    {
      if ((paramDownloadUrlQueryResult.a) && (this.jdField_a_of_type_JavaIoFile.exists()) && (!FileCacheUtils.a(this.jdField_a_of_type_JavaIoFile))) {
        this.jdField_a_of_type_JavaIoFile.delete();
      }
      TVKPreloader.a(new TVKPreloader.PreloadItem(this.jdField_a_of_type_JavaLangString, str, this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), ""));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.TVKPreloader.3
 * JD-Core Version:    0.7.0.1
 */