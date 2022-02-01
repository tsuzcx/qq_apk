package com.tencent.biz.pubaccount.Advertisement.view;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementStatistics;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;

class VideoCoverView$9
  implements FMDialogUtil.FMDialogInterface
{
  VideoCoverView$9(VideoCoverView paramVideoCoverView) {}
  
  public void a()
  {
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.a = true;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.b = true;
    if (this.a.jdField_a_of_type_Int == 5)
    {
      this.a.d();
    }
    else
    {
      VideoCoverView localVideoCoverView = this.a;
      localVideoCoverView.b(VideoCoverView.a(localVideoCoverView));
    }
    AdvertisementStatistics.a().a(VideoCoverView.a(this.a).a.c, this.a.jdField_a_of_type_JavaLangString, true);
  }
  
  public void b()
  {
    VideoCoverView localVideoCoverView = this.a;
    localVideoCoverView.jdField_a_of_type_Int = 6;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.a = false;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.b = true;
    localVideoCoverView.g();
    AdvertisementStatistics.a().a(VideoCoverView.a(this.a).a.c, this.a.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.9
 * JD-Core Version:    0.7.0.1
 */