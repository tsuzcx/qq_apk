package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.widget.Button;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewLogicDefault;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import java.util.ArrayList;

public class PhotoPreviewLogicAECMShow
  extends PhotoPreviewLogicDefault
{
  PhotoPreviewLogicAECMShow(NewPhotoPreviewActivity paramNewPhotoPreviewActivity)
  {
    super(paramNewPhotoPreviewActivity);
  }
  
  private void e()
  {
    if (this.mPhotoCommonData.selectedPhotoList.size() > 0)
    {
      ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(true);
      return;
    }
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setEnabled(false);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    e();
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    e();
  }
  
  public void initUI()
  {
    super.initUI();
    ((NewPhotoPreviewActivity)this.mActivity).sendBtn.setOnClickListener(new PhotoPreviewLogicAECMShow.1(this));
    e();
  }
  
  public void onBackPressed(boolean paramBoolean)
  {
    AEBaseDataReporter.a().aH();
    super.onBackPressed(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewLogicAECMShow
 * JD-Core Version:    0.7.0.1
 */