package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

public class PhotoPreviewCustomizationWeiyun
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationWeiyun";
  
  PhotoPreviewCustomizationWeiyun(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.isFinishing()) {
      a().e.setText(HardCodeUtil.a(2131708146));
    }
  }
  
  protected void h()
  {
    Object localObject = a().a();
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent();
    if (localObject != null)
    {
      StatisticConstants.a(((ArrayList)localObject).size(), this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d);
      StatisticConstants.a(localIntent, ((ArrayList)localObject).size(), ((PhotoOtherData)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumOtherCommonData).a);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity;
    if (localObject != null)
    {
      if (((NewPhotoPreviewActivity)localObject).isFinishing()) {
        return;
      }
      ((NewPhotoPreviewActivity)localObject).setResult(-1, new Intent());
      ((NewPhotoPreviewActivity)localObject).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationWeiyun
 * JD-Core Version:    0.7.0.1
 */