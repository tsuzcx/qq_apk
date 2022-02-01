package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.Holder;
import com.tencent.mobileqq.activity.photo.album.AbstractPhotoListActivity.PhotoListAdapter;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;

public class PhotoListLogicQcircle
  extends PhotoListLogicDefault
{
  public PhotoListLogicQcircle(NewPhotoListActivity paramNewPhotoListActivity)
  {
    super(paramNewPhotoListActivity);
  }
  
  public void caseVideo(View paramView, int paramInt)
  {
    paramView = ((NewPhotoListActivity)this.mActivity).photoListAdapter.getItem(paramInt);
    if (paramView.fileSize > this.mPhotoCommonData.videoSizeLimit)
    {
      QQToast.a(this.mActivity, "请上传不超过" + (float)this.mPhotoCommonData.videoSizeLimit / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).a();
      return;
    }
    if (paramView.mDuration > this.mPhotoCommonData.videoDurationLimit + 1000L)
    {
      QQToast.a(this.mActivity, "请上传不超过" + this.mPhotoCommonData.videoDurationLimit / 60L / 1000L + "分钟的视频", 0).a();
      return;
    }
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramView.path);
    HashMap localHashMap = new HashMap();
    localHashMap.put(paramView.path, paramView);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    localIntent.putExtra("PeakConstants.selectedMediaInfoHashMap", localHashMap);
    localIntent.addFlags(268435456);
    ((NewPhotoListActivity)this.mActivity).setResult(-1, localIntent);
    d();
  }
  
  public AbstractPhotoListActivity.Holder getViewCaseVideo(@NonNull AbstractPhotoListActivity.Holder paramHolder, int paramInt)
  {
    return super.getViewCaseVideo(paramHolder, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicQcircle
 * JD-Core Version:    0.7.0.1
 */