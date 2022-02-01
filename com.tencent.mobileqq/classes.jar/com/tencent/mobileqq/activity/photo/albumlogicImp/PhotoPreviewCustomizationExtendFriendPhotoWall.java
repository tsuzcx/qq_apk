package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import java.util.ArrayList;

public class PhotoPreviewCustomizationExtendFriendPhotoWall
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationExtendFriendPhotoWall";
  
  protected PhotoPreviewCustomizationExtendFriendPhotoWall(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    s().l.setOnClickListener(new PhotoPreviewCustomizationExtendFriendPhotoWall.1(this));
  }
  
  public boolean g()
  {
    return (this.f.selectedPhotoList != null) && (!this.f.selectedPhotoList.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationExtendFriendPhotoWall
 * JD-Core Version:    0.7.0.1
 */