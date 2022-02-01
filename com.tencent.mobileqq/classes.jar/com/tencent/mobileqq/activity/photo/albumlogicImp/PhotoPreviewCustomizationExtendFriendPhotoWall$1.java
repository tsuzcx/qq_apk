package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class PhotoPreviewCustomizationExtendFriendPhotoWall$1
  implements View.OnClickListener
{
  PhotoPreviewCustomizationExtendFriendPhotoWall$1(PhotoPreviewCustomizationExtendFriendPhotoWall paramPhotoPreviewCustomizationExtendFriendPhotoWall) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    int i = this.a.s().m();
    if ((this.a.f.selectedPhotoList != null) && (this.a.f.selectedPhotoList.size() != 0))
    {
      localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.f.selectedPhotoList);
    }
    else if ((PhotoPreviewCustomizationExtendFriendPhotoWall.a(this.a).y != null) && (i != -1))
    {
      ArrayList localArrayList = new ArrayList();
      String str = (String)PhotoPreviewCustomizationExtendFriendPhotoWall.b(this.a).y.get(i);
      if (!TextUtils.isEmpty(str))
      {
        localArrayList.add(str);
        localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", localArrayList);
      }
      else
      {
        QLog.d("PhotoPreviewCustomizationExtendFriendPhotoWall", 1, "sendBtn click currentPath is null");
      }
    }
    PhotoPreviewCustomizationExtendFriendPhotoWall.c(this.a).setResult(-1, localIntent);
    PhotoPreviewCustomizationExtendFriendPhotoWall.d(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationExtendFriendPhotoWall.1
 * JD-Core Version:    0.7.0.1
 */