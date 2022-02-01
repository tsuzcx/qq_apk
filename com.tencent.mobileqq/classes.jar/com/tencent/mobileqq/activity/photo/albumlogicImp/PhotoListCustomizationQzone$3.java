package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener;

class PhotoListCustomizationQzone$3
  implements XMPCoreUtil.XMPCoreJarLoadListener
{
  PhotoListCustomizationQzone$3(PhotoListCustomizationQzone paramPhotoListCustomizationQzone, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void loadState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 90) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight;
        LocalMediaInfo localLocalMediaInfo = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
        localLocalMediaInfo.mediaHeight = localLocalMediaInfo.mediaWidth;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = i;
        ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).setPanoramaType(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
        return;
      }
      ((IPanoramaUtil)QRoute.api(IPanoramaUtil.class)).setPanoramaType(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQzone.3
 * JD-Core Version:    0.7.0.1
 */