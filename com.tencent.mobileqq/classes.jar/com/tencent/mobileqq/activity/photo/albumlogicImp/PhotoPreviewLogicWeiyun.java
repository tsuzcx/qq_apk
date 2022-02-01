package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.widget.AdapterView;
import java.util.ArrayList;

public class PhotoPreviewLogicWeiyun
  extends PhotoPreviewLogicDefault
{
  PhotoPreviewLogicWeiyun(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  public void d()
  {
    Object localObject = ((NewPhotoPreviewActivity)this.mActivity).getSubmitPhotoList();
    Intent localIntent = ((NewPhotoPreviewActivity)this.mActivity).getIntent();
    if (localObject != null)
    {
      StatisticConstants.a(((ArrayList)localObject).size(), this.a.totalPicCount);
      StatisticConstants.a(localIntent, ((ArrayList)localObject).size(), this.mPhotoCommonData.currentQualityType);
    }
    localObject = (NewPhotoPreviewActivity)this.mActivity;
    if ((localObject == null) || (((NewPhotoPreviewActivity)localObject).isFinishing())) {
      return;
    }
    ((NewPhotoPreviewActivity)localObject).setResult(-1, new Intent());
    ((NewPhotoPreviewActivity)localObject).finish();
  }
  
  public void onGalleryItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onGalleryItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if (((NewPhotoPreviewActivity)this.mActivity).isFinishing()) {
      ((NewPhotoPreviewActivity)this.mActivity).titleView.setText(HardCodeUtil.a(2131708127));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicWeiyun
 * JD-Core Version:    0.7.0.1
 */