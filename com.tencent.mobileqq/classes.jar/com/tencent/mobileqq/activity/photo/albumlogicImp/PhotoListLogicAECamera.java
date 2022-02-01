package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.videostory.support.VideoStoryPicToVideo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.richmedia.capture.util.CaptureUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import java.util.ArrayList;

public class PhotoListLogicAECamera
  extends PhotoListLogicDefault
{
  PhotoListLogicAECamera(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  private void a(LocalMediaInfo paramLocalMediaInfo, Bundle paramBundle)
  {
    if ((this.mActivity == null) || (((NewPhotoListActivity)this.mActivity).getIntent() == null)) {}
    while (paramLocalMediaInfo == null) {
      return;
    }
    int i = ((NewPhotoListActivity)this.mActivity).getIntent().getIntExtra("entrance_type", 120);
    QQStoryFlowCallback.a(this.mActivity, paramLocalMediaInfo.path, paramLocalMediaInfo, 0, (int)paramLocalMediaInfo.mDuration, i, 10023, 0, null, null, false, 11, 14, paramBundle);
  }
  
  private void g()
  {
    if ((this.mActivity != null) && (((NewPhotoListActivity)this.mActivity).getIntent() != null)) {
      ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("key_from_pic_choose", true);
    }
  }
  
  private void g(LocalMediaInfo paramLocalMediaInfo)
  {
    Object localObject;
    if ((paramLocalMediaInfo == null) || (TextUtils.isEmpty(paramLocalMediaInfo.path)) || (this.mActivity == null) || (((NewPhotoListActivity)this.mActivity).getIntent() == null))
    {
      localObject = new StringBuilder().append("data error: ");
      if (paramLocalMediaInfo == null)
      {
        paramLocalMediaInfo = "";
        AEQLog.d("PhotoListLogicAECamera", paramLocalMediaInfo);
      }
    }
    do
    {
      return;
      paramLocalMediaInfo = paramLocalMediaInfo.path;
      break;
      g();
      if (!AECameraEntry.a(((NewPhotoListActivity)this.mActivity).getIntent()))
      {
        ((NewPhotoListActivity)this.mActivity).cancleProgressDailog();
        localObject = new Bundle();
        ((Bundle)localObject).putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", paramLocalMediaInfo.path);
        ((Bundle)localObject).putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
        ((NewPhotoListActivity)this.mActivity).getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
        a(paramLocalMediaInfo, (Bundle)localObject);
        return;
      }
      localObject = VideoStoryPicToVideo.a().a(paramLocalMediaInfo.path, "2");
    } while (TextUtils.isEmpty((CharSequence)localObject));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapManager.a(paramLocalMediaInfo.path, localOptions);
    int i = ScreenUtil.SCREEN_WIDTH;
    float f = localOptions.outWidth / localOptions.outHeight;
    int k = CaptureUtil.a(i);
    int m = CaptureUtil.a((int)(k / f));
    int j = k;
    i = m;
    if (m > MergeEditVideo.a)
    {
      j = CaptureUtil.a((int)(k * MergeEditVideo.a / m));
      i = MergeEditVideo.a;
    }
    VideoStoryPicToVideo.a().a(paramLocalMediaInfo.path, (String)localObject, "2", j, i, false, 0, new PhotoListLogicAECamera.3(this, (String)localObject, paramLocalMediaInfo));
  }
  
  public void caseSingleModeImage(View paramView, int paramInt)
  {
    if (this.mActivity == null)
    {
      AEQLog.d("PhotoListLogicAECamera", "mActivity is null");
      return;
    }
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    ((NewPhotoListActivity)this.mActivity).showProgressDialog();
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new PhotoListLogicAECamera.1(this), paramView);
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    if (this.mActivity == null)
    {
      AEQLog.d("PhotoListLogicAECamera", "mActivity is null.");
      return;
    }
    if (!Utils.a())
    {
      QQToast.a(this.mActivity, ((NewPhotoListActivity)this.mActivity).getResources().getString(2131718859), 0).a();
      return;
    }
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (paramView == null)
    {
      AEQLog.d("PhotoListLogicAECamera", "photoInfo is null.");
      return;
    }
    Intent localIntent = ((NewPhotoListActivity)this.mActivity).getIntent();
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
    ((NewPhotoListActivity)this.mActivity).showProgressDialog();
    g();
    MediaScanner.getInstance(BaseApplicationImpl.getContext()).queryMediaInfoAsync(new PhotoListLogicAECamera.2(this, localIntent, localArrayList), paramView);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int j = 0;
    if (((paramInt1 == 10023) || (paramInt1 == 2)) && (paramInt2 == -1))
    {
      ((NewPhotoListActivity)this.mActivity).setResult(paramInt2, paramIntent);
      ((NewPhotoListActivity)this.mActivity).finish();
      return;
    }
    if (paramInt1 == 10023)
    {
      int i = j;
      if (paramIntent != null)
      {
        i = j;
        if (paramIntent.getBooleanExtra("key_edit_to_photo_list", false)) {
          i = 1;
        }
      }
      if (i != 0) {
        ((NewPhotoListActivity)this.mActivity).finish();
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicAECamera
 * JD-Core Version:    0.7.0.1
 */