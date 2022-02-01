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
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.b = true;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.c = true;
    if (this.a.f == 5)
    {
      this.a.d();
    }
    else
    {
      VideoCoverView localVideoCoverView = this.a;
      localVideoCoverView.b(VideoCoverView.f(localVideoCoverView));
    }
    AdvertisementStatistics.a().a(VideoCoverView.b(this.a).g.c, this.a.e, true);
  }
  
  public void b()
  {
    VideoCoverView localVideoCoverView = this.a;
    localVideoCoverView.f = 6;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.b = false;
    com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment.c = true;
    localVideoCoverView.g();
    AdvertisementStatistics.a().a(VideoCoverView.b(this.a).g.c, this.a.e, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView.9
 * JD-Core Version:    0.7.0.1
 */