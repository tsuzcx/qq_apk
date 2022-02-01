package com.tencent.aelight.camera.aioeditor;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.QQStoryFlowCallback;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase;
import com.tencent.mobileqq.editor.composite.step.MergeEditVideo;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class PhotoListCustomizationAECamera
  extends PhotoListCustomizationDefault
{
  public static final String a = "com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera";
  
  PhotoListCustomizationAECamera(AbstractPhotoListActivity paramAbstractPhotoListActivity)
  {
    super(paramAbstractPhotoListActivity);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent() == null) {
        return;
      }
      if (paramLocalMediaInfo != null)
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().getIntExtra("entrance_type", 120);
        QQStoryFlowCallback.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, paramLocalMediaInfo.path, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, i, 10023, 0, null, null, false, 11, 14, paramBundle);
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().putExtra("key_from_pic_choose", true);
    }
  }
  
  private void g(LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramLocalMediaInfo != null) && (!TextUtils.isEmpty(paramLocalMediaInfo.path)) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent() != null))
    {
      d();
      if (!((IAECameraEntryManager)QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent()))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a.b();
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", paramLocalMediaInfo.path);
        ((Bundle)localObject1).putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
        a(paramLocalMediaInfo, (Bundle)localObject1);
        return;
      }
      localObject1 = VideoStoryPicToVideo.a().a(paramLocalMediaInfo.path, "2");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
        BitmapManager.a(paramLocalMediaInfo.path, (BitmapFactory.Options)localObject2);
        int i = ScreenUtil.SCREEN_WIDTH;
        float f = ((BitmapFactory.Options)localObject2).outWidth / ((BitmapFactory.Options)localObject2).outHeight;
        int k = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(i);
        int m = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize((int)(k / f));
        int j = k;
        i = m;
        if (m > MergeEditVideo.a)
        {
          localObject2 = (ICaptureUtil)QRoute.api(ICaptureUtil.class);
          double d1 = k;
          double d2 = MergeEditVideo.a;
          Double.isNaN(d1);
          Double.isNaN(d2);
          double d3 = m;
          Double.isNaN(d3);
          j = ((ICaptureUtil)localObject2).alainSize((int)(d1 * d2 / d3));
          i = MergeEditVideo.a;
        }
        VideoStoryPicToVideo.a().a(paramLocalMediaInfo.path, (String)localObject1, "2", j, i, false, 0, new PhotoListCustomizationAECamera.3(this, (String)localObject1, paramLocalMediaInfo));
      }
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("data error: ");
    if (paramLocalMediaInfo == null) {
      paramLocalMediaInfo = "";
    } else {
      paramLocalMediaInfo = paramLocalMediaInfo.path;
    }
    ((StringBuilder)localObject1).append(paramLocalMediaInfo);
    AEQLog.d("PhotoListCustomizationAECamera", ((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (((paramInt1 == 10023) || (paramInt1 == 2)) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.setResult(paramInt2, paramIntent);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      return;
    }
    if (paramInt1 == 10023)
    {
      int j = 0;
      int i = j;
      if (paramIntent != null)
      {
        i = j;
        if (paramIntent.getBooleanExtra("key_edit_to_photo_list", false)) {
          i = 1;
        }
      }
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.finish();
      }
    }
    super.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity == null)
    {
      AEQLog.d("PhotoListCustomizationAECamera", "mActivity is null");
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a.a();
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new PhotoListCustomizationAECamera.1(this), paramView);
  }
  
  public void b(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity == null)
    {
      AEQLog.d("PhotoListCustomizationAECamera", "mActivity is null.");
      return;
    }
    if (!Utils.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getResources().getString(2131718574), 0).a();
      return;
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotolistPhotoListSceneBase.a.a(paramInt);
    if (paramView == null)
    {
      AEQLog.d("PhotoListCustomizationAECamera", "photoInfo is null.");
      return;
    }
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoListActivity.getIntent();
    localIntent.putExtra("file_send_path", paramView.path);
    localIntent.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
    localIntent.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
    localIntent.putExtra("file_send_duration", paramView.mDuration);
    localIntent.putExtra("file_width", paramView.mediaWidth);
    localIntent.putExtra("file_height", paramView.mediaHeight);
    localIntent.putExtra("media_info", paramView);
    localIntent.putExtra("key_from_pic_choose", true);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView.path);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoListData.a.a();
    d();
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new PhotoListCustomizationAECamera.2(this, localIntent, localArrayList), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera
 * JD-Core Version:    0.7.0.1
 */