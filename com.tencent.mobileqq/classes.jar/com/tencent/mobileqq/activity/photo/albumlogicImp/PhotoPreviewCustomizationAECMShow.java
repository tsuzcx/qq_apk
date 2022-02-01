package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.widget.Button;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class PhotoPreviewCustomizationAECMShow
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAECMShow";
  
  PhotoPreviewCustomizationAECMShow(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  private void d()
  {
    if (this.f.selectedPhotoList.size() > 0)
    {
      s().l.setEnabled(true);
      return;
    }
    s().l.setEnabled(false);
  }
  
  public void a()
  {
    super.a();
    s().l.setOnClickListener(new PhotoPreviewCustomizationAECMShow.1(this));
    d();
  }
  
  protected void b(int paramInt)
  {
    super.b(paramInt);
    d();
  }
  
  protected void c(int paramInt)
  {
    super.c(paramInt);
    d();
  }
  
  public void i()
  {
    ((IAEBaseDataReporter)QRoute.api(IAEBaseDataReporter.class)).reportCmShowPhotoPreviewClickBackBtn();
    super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAECMShow
 * JD-Core Version:    0.7.0.1
 */