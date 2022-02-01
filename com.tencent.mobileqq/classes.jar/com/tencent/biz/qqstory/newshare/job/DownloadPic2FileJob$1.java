package com.tencent.biz.qqstory.newshare.job;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.shareGroup.icon.UrlBitmapDownloader.Listener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.mobileqq.utils.ImageUtil;

class DownloadPic2FileJob$1
  implements UrlBitmapDownloader.Listener
{
  DownloadPic2FileJob$1(DownloadPic2FileJob paramDownloadPic2FileJob, String paramString) {}
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    if (DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob))
    {
      paramString = ImageUtil.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
      if (paramString == null)
      {
        DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob, false);
        return;
      }
      bool = BitmapUtils.a(paramString, DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob));
      paramString.recycle();
      DownloadPic2FileJob.b(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob, bool);
      return;
    }
    boolean bool = BitmapUtils.a(paramBitmap, DownloadPic2FileJob.a(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob));
    DownloadPic2FileJob.c(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob, bool);
  }
  
  public void a(String paramString, Throwable paramThrowable)
  {
    SLog.e("DownloadPic2FileJob", "Download url failed url=%s", new Object[] { this.jdField_a_of_type_JavaLangString });
    DownloadPic2FileJob.d(this.jdField_a_of_type_ComTencentBizQqstoryNewshareJobDownloadPic2FileJob, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.newshare.job.DownloadPic2FileJob.1
 * JD-Core Version:    0.7.0.1
 */