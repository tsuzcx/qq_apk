package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.crop.CropNewView.CropListener;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GenerateContext;
import com.tencent.aelight.camera.aioeditor.takevideo.publish.GeneratePicArgs;
import com.tencent.aelight.camera.report.api.IAEBaseReportParam;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.ocr.api.IOCR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;

public class EditPicCropPart
  extends EditVideoPart
  implements View.OnClickListener, CropNewView.CropListener
{
  int jdField_a_of_type_Int = 0;
  public Bitmap a;
  View jdField_a_of_type_AndroidViewView;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CropNewView jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[5];
  public Bitmap b;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = false;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = false;
  boolean e = false;
  boolean f = false;
  
  public EditPicCropPart(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager == null) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiRestoreClick , bussiId = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",hasModified");
      localStringBuilder.append(paramBoolean);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
  }
  
  private boolean c()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a();
    boolean bool;
    if (i == 103)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.f();
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiCropClick , bussiId = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",clickHit = ");
      localStringBuilder.append(bool);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private boolean d()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a();
    this.jdField_d_of_type_Boolean = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiCropClickIntercept , bussiId = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",intercepte = ");
      localStringBuilder.append(false);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
    return false;
  }
  
  private boolean e()
  {
    int i = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a();
    boolean bool;
    if (i == 103)
    {
      bool = true;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b();
    }
    else
    {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBussiBackPressed , bussiId = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",clickHit = ");
      localStringBuilder.append(bool);
      QLog.d("EditPicCropPart", 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void g()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)a(2064122065));
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
      {
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
        localLayoutParams.bottomMargin = ViewUtils.a(56.5F);
        this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(localLayoutParams);
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView = ((CropNewView)a(2064122084));
      this.jdField_a_of_type_AndroidViewView = a(2064122080);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = a(2064122082);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2064122063));
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_c_of_type_AndroidViewView = a(2064122024);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)a(2064122083));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)a(2064122081));
      this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)a(2064122665));
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView.setCropListener(this);
    }
  }
  
  private void h()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    if (!this.f)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    k();
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_b_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  private void j()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 103)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699063);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void l() {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.jdField_b_of_type_AndroidViewView.setEnabled(false);
      return;
    }
    if (paramInt == 2) {
      this.jdField_b_of_type_AndroidViewView.setEnabled(true);
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    GeneratePicArgs localGeneratePicArgs = paramGenerateContext.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoPublishGeneratePicArgs;
    localGeneratePicArgs.jdField_a_of_type_Int += this.jdField_a_of_type_Int;
    if (this.jdField_c_of_type_Boolean)
    {
      paramGenerateContext.jdField_a_of_type_CooperationQzoneReportLpLpReportInfo_pf00064.reservesArray.add("2");
      VideoEditReport.b("0X80075E9", VideoEditReport.jdField_a_of_type_Int);
      ((IAEBaseReportParam)QRoute.api(IAEBaseReportParam.class)).setEditHasCut(true);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    g();
    if (paramInt == 7)
    {
      if (!this.jdField_b_of_type_Boolean) {
        h();
      }
    }
    else if (this.jdField_b_of_type_Boolean) {
      j();
    }
  }
  
  public boolean a()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      if (!e()) {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.b(0);
      }
      VideoEditReport.b("0X80075D5");
      ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE5", 0);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_a_of_type_AndroidViewView.setEnabled(true);
    this.e = true;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2064122024)
    {
      if (i != 2064122063)
      {
        switch (i)
        {
        default: 
          return;
        case 2064122082: 
          b();
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView.b();
          VideoEditReport.b("0X80075D4");
          ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE4", 0);
          return;
        case 2064122081: 
          l();
          return;
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView.a();
        this.jdField_a_of_type_AndroidViewView.setEnabled(false);
        if (!this.f) {
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        }
        if ((this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager != null) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.a() == 103)) {
          this.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        }
        this.e = false;
        a(this.e);
        VideoEditReport.b("0X80075D3");
        ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE3", 0);
        return;
      }
      if (d()) {
        return;
      }
      this.jdField_a_of_type_Int += 1;
      this.jdField_c_of_type_Boolean = true;
      boolean bool = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView.c();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("crop remove face items");
        paramView.append(bool);
        QLog.d("EditPicCrop", 2, paramView.toString());
      }
      if (bool)
      {
        if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle != null)
        {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.remove(FaceLayer.a);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.remove("DynamicFaceLayer");
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.jdField_a_of_type_AndroidOsBundle.remove(TextLayer.a);
        }
        paramView = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView.a();
        if (paramView != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = paramView;
          VideoFilterTools.a().a(this.jdField_a_of_type_AndroidGraphicsBitmap);
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.a(this.jdField_a_of_type_AndroidGraphicsBitmap, false);
          if (!c()) {
            this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoEditVideoPartManager.w();
          }
        }
        VideoEditReport.b("0X80075D2");
        ((IOCR)QRoute.api(IOCR.class)).report("0X800AAE6", 0);
        GeneratePicArgs.a(this.jdField_a_of_type_ArrayOfInt);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiCropCropNewView.c();
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.EditPicCropPart
 * JD-Core Version:    0.7.0.1
 */