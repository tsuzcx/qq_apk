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
  private int jdField_a_of_type_Int;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private CameraPeakServiceHandler jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler = (CameraPeakServiceHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(PeakAppInterface.d);
  private CameraPeakServiceObserver jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface = QQStoryContext.a();
  private int b;
  
  public PhotoPreviewCustomizationAECapture(AbstractPhotoPreviewActivity paramAbstractPhotoPreviewActivity)
  {
    super(paramAbstractPhotoPreviewActivity);
    paramAbstractPhotoPreviewActivity = paramAbstractPhotoPreviewActivity.getIntent();
    if (paramAbstractPhotoPreviewActivity != null)
    {
      this.jdField_a_of_type_Int = paramAbstractPhotoPreviewActivity.getIntExtra("MaterialConfig.minImageWidth", 0);
      this.b = paramAbstractPhotoPreviewActivity.getIntExtra("MaterialConfig.minImageHeight", 0);
    }
  }
  
  private void a(String paramString, boolean paramBoolean, int paramInt)
  {
    m();
    if ((a().a != null) && (a().a.getVisibility() == 0)) {
      a().a.setClickable(true);
    }
    if (paramBoolean)
    {
      if ((paramInt != 0) && (paramInt != -2))
      {
        if (paramInt == -1) {
          c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(2064515091));
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
      c(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(2064515092));
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
    if ((a().a != null) && (a().a.getVisibility() == 0)) {
      a().a.setClickable(false);
    }
    CameraPeakServiceObserver localCameraPeakServiceObserver = this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver;
    if (localCameraPeakServiceObserver != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(localCameraPeakServiceObserver);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver = new PhotoPreviewCustomizationAECapture.2(this, paramString);
    d();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceObserver);
    this.jdField_a_of_type_ComTencentAelightCameraAeConfigCameraPeakServiceHandler.b(paramString);
  }
  
  private void c(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a >= 700L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoPreviewData.a = l;
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, paramString, 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getResources().getDimensionPixelSize(2131299168));
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.isFinishing()))
    {
      if (this.jdField_a_of_type_AndroidAppDialog == null)
      {
        this.jdField_a_of_type_AndroidAppDialog = new Dialog(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity, 2131756189);
        this.jdField_a_of_type_AndroidAppDialog.setContentView(2131559561);
        ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131372646)).setText(2064515095);
        this.jdField_a_of_type_AndroidAppDialog.setCancelable(true);
        this.jdField_a_of_type_AndroidAppDialog.setCanceledOnTouchOutside(false);
        this.jdField_a_of_type_AndroidAppDialog.setOnDismissListener(new PhotoPreviewCustomizationAECapture.3(this));
      }
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  private boolean e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum;
  }
  
  private void m()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.isFinishing()))
    {
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
    }
  }
  
  public void a()
  {
    super.a();
    a().a.setOnClickListener(new PhotoPreviewCustomizationAECapture.1(this));
  }
  
  public void a(View paramView)
  {
    if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedIndex.contains(Integer.valueOf(a().a()))) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size() >= this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum))
    {
      c(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(2064515214), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum) }));
      return;
    }
    super.a(paramView);
  }
  
  protected void a(String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", new ArrayList(Collections.singletonList(paramString)));
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.setResult(-1, localIntent);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.finish();
  }
  
  public void b()
  {
    super.b();
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumNewPhotoPreviewActivity.getString(2064515093);
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.selectedPhotoList.size();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(" ");
    localStringBuilder.append(i);
    localStringBuilder.append("/");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumPhotoCommonBaseData.maxSelectNum);
    str = localStringBuilder.toString();
    a().a.setText(str);
    a().a.setEnabled(true);
    if (e())
    {
      a().a.setBackgroundResource(2130850104);
      return;
    }
    a().a.setBackgroundResource(2130837911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.gallery.PhotoPreviewCustomizationAECapture
 * JD-Core Version:    0.7.0.1
 */