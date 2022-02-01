package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.util.PanoramaUtil;
import cooperation.qzone.util.XMPCoreUtil.XMPCoreJarLoadListener;

class PhotoListLogicQzone$3
  implements XMPCoreUtil.XMPCoreJarLoadListener
{
  PhotoListLogicQzone$3(PhotoListLogicQzone paramPhotoListLogicQzone, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void loadState(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation == 90) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = i;
        PanoramaUtil.setPanoramaType(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
      }
    }
    else {
      return;
    }
    PanoramaUtil.setPanoramaType(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicQzone.3
 * JD-Core Version:    0.7.0.1
 */