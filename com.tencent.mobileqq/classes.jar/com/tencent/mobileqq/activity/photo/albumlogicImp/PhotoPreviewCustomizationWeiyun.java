package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoOtherData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

public class PhotoPreviewCustomizationWeiyun
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationWeiyun";
  
  PhotoPreviewCustomizationWeiyun(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
    if (this.c.isFinishing()) {
      s().p.setText(HardCodeUtil.a(2131905943));
    }
  }
  
  protected void j()
  {
    Object localObject = s().l();
    Intent localIntent = this.c.getIntent();
    if (localObject != null)
    {
      StatisticConstants.a(((ArrayList)localObject).size(), this.d.D);
      StatisticConstants.a(localIntent, ((ArrayList)localObject).size(), ((PhotoOtherData)this.g).d);
    }
    localObject = this.c;
    if (localObject != null)
    {
      if (((NewPhotoPreviewActivity)localObject).isFinishing()) {
        return;
      }
      ((NewPhotoPreviewActivity)localObject).setResult(-1, new Intent());
      ((NewPhotoPreviewActivity)localObject).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationWeiyun
 * JD-Core Version:    0.7.0.1
 */