package com.tencent.aelight.camera.ae.camera.ui.gallery;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceHandler;
import com.tencent.aelight.camera.ae.config.CameraPeakServiceObserver;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.PhotoPreviewData;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collections;

public class PhotoPreviewCustomizationAECapture
  extends PhotoPreviewCustomizationDefault
{
  public static final String a = "com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture";
  public static final String b = "PhotoPreviewCustomizationAECapture";
  private AppInterface j = QQStoryContext.k();
  private CameraPeakServiceHandler k = (CameraPeakServiceHandler)this.j.getBusinessHandler(PeakAppInterface.e);
  private CameraPeakServiceObserver l;
  private Dialog m;
  private int n;
  private int o;
  
  public PhotoPreviewCustomizationAECapture(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
    paramAbstractPhotoPreviewActivity = paramAbstractPhotoPreviewActivity.getIntent();
    if (paramAbstractPhotoPreviewActivity != null)
    {
      this.n = paramAbstractPhotoPreviewActivity.getIntExtra("MaterialConfig.minImageWidth", 0);
      this.o = paramAbstractPhotoPreviewActivity.getIntExtra("MaterialConfig.minImageHeight", 0);
    }
  }
  
  private void A()
  {
    if ((this.c != null) && (!this.c.isFinishing()))
    {
      Dialog localDialog = this.m;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.m.dismiss();
      }
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    A();
    if ((s().l != null) && (s().l.getVisibility() == 0)) {
      s().l.setClickable(true);
    }
    if (paramBoolean)
    {
      if ((paramInt != 0) && (paramInt != -2))
      {
        if (paramInt == -1) {
          c(this.c.getString(2064187421));
        }
      }
      else {
        a(paramString);
      }
    }
    else
    {
      if (paramInt == -100)
      {
        a(paramString);
        return;
      }
      c(this.c.getString(2064187422));
    }
  }
  
  private boolean a(@Nullable String paramString, @Nullable LocalMediaInfo paramLocalMediaInfo)
  {
    if ((paramString != null) && (paramString.endsWith(".gif"))) {
      return true;
    }
    return (paramLocalMediaInfo != null) && ("image/gif".equalsIgnoreCase(paramLocalMediaInfo.mMimeType));
  }
  
  private void b(String paramString)
  {
    if ((s().l != null) && (s().l.getVisibility() == 0)) {
      s().l.setClickable(false);
    }
    CameraPeakServiceObserver localCameraPeakServiceObserver = this.l;
    if (localCameraPeakServiceObserver != null) {
      this.j.removeObserver(localCameraPeakServiceObserver);
    }
    this.l = new PhotoPreviewCustomizationAECapture.2(this, paramString);
    z();
    this.j.addObserver(this.l);
    this.k.b(paramString);
  }
  
  private void c(String paramString)
  {
    long l1 = System.currentTimeMillis();
    if (l1 - this.d.C >= 700L)
    {
      this.d.C = l1;
      QQToast.makeText(this.c, paramString, 0).show(this.c.getResources().getDimensionPixelSize(2131299920));
    }
  }
  
  private boolean d()
  {
    return this.f.selectedPhotoList.size() < this.f.maxSelectNum;
  }
  
  private void z()
  {
    if ((this.c != null) && (!this.c.isFinishing()))
    {
      if (this.m == null)
      {
        this.m = new Dialog(this.c, 2131953338);
        this.m.setContentView(2131625585);
        ((TextView)this.m.findViewById(2131440191)).setText(2064187425);
        this.m.setCancelable(true);
        this.m.setCanceledOnTouchOutside(false);
        this.m.setOnDismissListener(new PhotoPreviewCustomizationAECapture.3(this));
      }
      this.m.show();
    }
  }
  
  public void a()
  {
    super.a();
    s().l.setOnClickListener(new PhotoPreviewCustomizationAECapture.1(this));
  }
  
  public void a(View paramView)
  {
    if ((!this.f.selectedIndex.contains(Integer.valueOf(s().m()))) && (this.f.selectedPhotoList.size() >= this.f.maxSelectNum))
    {
      c(String.format(this.c.getString(2064187561), new Object[] { Integer.valueOf(this.f.maxSelectNum) }));
      return;
    }
    super.a(paramView);
  }
  
  protected void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", new ArrayList(Collections.singletonList(paramString)));
    this.c.setResult(-1, localIntent);
    this.c.finish();
  }
  
  public void b()
  {
    super.b();
    String str = this.c.getString(2064187423);
    int i = this.f.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(this.f.maxSelectNum);
    str = localStringBuilder.toString();
    s().l.setText(str);
    s().l.setEnabled(true);
    if (d())
    {
      s().l.setBackgroundResource(2130851880);
      return;
    }
    s().l.setBackgroundResource(2130837935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture
 * JD-Core Version:    0.7.0.1
 */