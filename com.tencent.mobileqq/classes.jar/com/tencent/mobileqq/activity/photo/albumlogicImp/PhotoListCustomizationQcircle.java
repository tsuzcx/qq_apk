package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.Holder;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListCustomizationQcircle
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQcircle";
  
  public PhotoListCustomizationQcircle(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  public void b(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt);
    if (paramView.fileSize > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("请上传不超过");
      ((StringBuilder)localObject1).append((float)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoSizeLimit / 1024.0F / 1024.0F / 1024.0F);
      ((StringBuilder)localObject1).append("G的视频");
      QQToast.a(paramView, ((StringBuilder)localObject1).toString(), 0).a();
      return;
    }
    if (paramView.mDuration > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration + 1000L)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("请上传不超过");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.filter.videoMaxDuration / 60L / 1000L);
      ((StringBuilder)localObject1).append("分钟的视频");
      QQToast.a(paramView, ((StringBuilder)localObject1).toString(), 0).a();
      return;
    }
    Object localObject1 = new Intent();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    if ((localObject2 != null) && (((Intent)localObject2).getExtras() != null)) {
      ((Intent)localObject1).putExtras(((Intent)localObject2).getExtras());
    }
    localObject2 = new ArrayList();
    ((ArrayList)localObject2).add(paramView.path);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramView.path, paramView);
    ((Intent)localObject1).putStringArrayListExtra("PhotoConst.PHOTO_PATHS", (ArrayList)localObject2);
    ((Intent)localObject1).putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    ((Intent)localObject1).addFlags(268435456);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(-1, (Intent)localObject1);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
  }
  
  public Holder c(@NonNull Holder paramHolder, int paramInt)
  {
    return super.c(paramHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationQcircle
 * JD-Core Version:    0.7.0.1
 */