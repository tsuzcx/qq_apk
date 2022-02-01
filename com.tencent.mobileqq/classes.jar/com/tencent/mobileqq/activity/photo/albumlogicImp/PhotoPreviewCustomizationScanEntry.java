package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class PhotoPreviewCustomizationScanEntry
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationScanEntry";
  
  protected PhotoPreviewCustomizationScanEntry(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a.size() > 1)
    {
      TextView localTextView = a().e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f + 1);
      localStringBuilder.append(" / ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a.size());
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    a().e.setText(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getString(2131694994));
  }
  
  public void a(Intent paramIntent)
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getIntent().getIntExtra("PhotoConst.CURRENT_SELECTED_INDEX", -1);
    ArrayList localArrayList1 = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    ArrayList localArrayList2 = new ArrayList();
    if (localArrayList1 != null) {
      localArrayList2.addAll(localArrayList1);
    }
    super.a(paramIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a = localArrayList2;
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a.size();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f = i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f = -1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.add(Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f));
    paramIntent = paramIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList = new ArrayList();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.clear();
    }
    if ((paramIntent != null) && (!paramIntent.equals(""))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.add(paramIntent);
    }
    QLog.d("PhotoPreviewCustomizationScanEntry", 1, new Object[] { "count=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.d), " pos=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f) });
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPreviewPresenterPreviewPresenter.notifyImageListChanged(paramIntent, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationScanEntry
 * JD-Core Version:    0.7.0.1
 */