package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class PhotoPreviewCustomizationAioLongShot
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAioLongShot";
  
  protected PhotoPreviewCustomizationAioLongShot(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
  }
  
  public void a()
  {
    super.a();
    s().p.setVisibility(8);
    s().l.setOnClickListener(new PhotoPreviewCustomizationAioLongShot.1(this));
  }
  
  public void a(Intent paramIntent)
  {
    super.a(paramIntent);
    this.f.customSendBtnText = this.c.getString(2131886532);
  }
  
  protected void a(View paramView, int paramInt1, Bundle paramBundle, int paramInt2, Intent paramIntent)
  {
    if (s().m() != -1) {
      this.d.m = ((String)this.d.y.get(s().m()));
    }
    super.a(paramView, 18003, paramBundle, paramInt2, ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.c, this.d.m, true, true, true, true, true, false, false, false, 2, 122, 0, false, null));
    AIOLongShotHelper.a("0X8009DED");
  }
  
  public void b()
  {
    super.b();
    int i;
    if ((this.f.selectedPhotoList != null) && (this.f.selectedPhotoList.size() > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((i != 0) && ((this.d.l) || (this.f.isSingleMode)))
    {
      s().g.setVisibility(0);
      s().g.setEnabled(true);
    }
  }
  
  void b(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      this.c.setResult(-1, paramIntent);
      this.c.finish();
    }
  }
  
  void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      this.c.setResult(-1, paramIntent);
      this.c.finish();
    }
  }
  
  void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      AIOLongShotHelper.a(this.c, paramIntent);
      return;
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false)))
    {
      this.c.setResult(-1, paramIntent);
      this.c.finish();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18001)
    {
      d(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18002)
    {
      c(paramInt1, paramInt2, paramIntent);
      return;
    }
    if (paramInt1 == 18003)
    {
      b(paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAioLongShot
 * JD-Core Version:    0.7.0.1
 */