package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener;

class PhotoListCustomizationQzone$3
  implements XMPCoreUtil.XMPCoreJarLoadListener
{
  PhotoListCustomizationQzone$3(PhotoListCustomizationQzone paramPhotoListCustomizationQzone, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void loadState(boolean paramBoolean)
  {
    QZLog.i("QQAlbum", "loadPanoramaPhoto loadXMPCoreModuleSuccess");
    if (paramBoolean)
    {
      if ((this.a.rotation == 90) && (this.a.mediaWidth < this.a.mediaHeight))
      {
        int i = this.a.mediaHeight;
        LocalMediaInfo localLocalMediaInfo = this.a;
        localLocalMediaInfo.mediaHeight = localLocalMediaInfo.mediaWidth;
        this.a.mediaWidth = i;
        QZLog.i("QQAlbum", "loadPanoramaPhoto LocalTake");
        ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).setPanoramaType(this.a);
        return;
      }
      QZLog.i("QQAlbum", "loadPanoramaPhoto NotLocalTake");
      ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).setPanoramaType(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.3
 * JD-Core Version:    0.7.0.1
 */