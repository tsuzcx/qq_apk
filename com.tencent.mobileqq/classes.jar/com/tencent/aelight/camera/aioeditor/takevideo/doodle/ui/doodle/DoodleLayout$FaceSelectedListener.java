package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFaceConstant;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage.Item;
import com.tencent.aelight.camera.aioeditor.doodle.ui.widget.InfoStickerDrawable;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicActivity;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

class DoodleLayout$FaceSelectedListener
  implements IFaceSelectedListener
{
  private DoodleLayout$FaceSelectedListener(DoodleLayout paramDoodleLayout) {}
  
  private boolean a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper, boolean paramBoolean)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.e != 0) || (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d != 0)) && (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.e <= this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d)) {
      paramFloat2 = ScreenUtil.SCREEN_HIGHT / 2;
    }
    FaceLayer.LayerParams localLayerParams = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight());
    if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    FaceLayer localFaceLayer = this.a.a();
    int i = paramSelectedItem.jdField_a_of_type_Int;
    paramBoolean = true;
    Object localObject = localFaceLayer;
    if (i == 1) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null)
      {
        localObject = localFaceLayer;
        if (!this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b()) {}
      }
      else
      {
        localObject = this.a.a();
      }
    }
    boolean bool = ((FaceLayer)localObject).a(paramSelectedItem.jdField_a_of_type_JavaLangString, paramSelectedItem.b, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, paramString, false, paramSelectedItem.jdField_a_of_type_Int, this.a.d(), paramSegmentKeeper);
    if ((!this.a.b) || (!bool)) {
      paramBoolean = false;
    }
    DoodleLayout.d(paramBoolean);
    return bool;
  }
  
  public void a()
  {
    this.a.a().d();
    this.a.a().d();
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void a(InformationFacePackage.Item paramItem, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramItem == null)
    {
      SLog.e("DoodleLayout", "the item is null.");
      return;
    }
    SLog.a("DoodleLayout", "onInformationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", paramItem.b, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.b();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("addLocationFaceItem:");
    ((StringBuilder)localObject1).append(paramItem.toString());
    SLog.b("DoodleLayout", ((StringBuilder)localObject1).toString());
    boolean bool1 = this.a.getContext() instanceof EditPicActivity;
    boolean bool2 = false;
    if (bool1) {
      paramItem.d = 0;
    } else {
      paramItem.d = 3;
    }
    InfoStickerDrawable localInfoStickerDrawable = InformationFaceConstant.a(paramItem, this.a.getContext(), -1L);
    if (bool1)
    {
      if (localInfoStickerDrawable != null) {
        localObject1 = new BitmapDrawable(this.a.getContext().getResources(), localInfoStickerDrawable.a());
      } else {
        localObject1 = null;
      }
    }
    else {
      localObject1 = localInfoStickerDrawable;
    }
    if (localObject1 != null)
    {
      ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[");
        ((StringBuilder)localObject2).append(((Drawable)localObject1).getIntrinsicWidth());
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(((Drawable)localObject1).getIntrinsicHeight());
        ((StringBuilder)localObject2).append("]");
        QLog.d("DoodleLayout", 2, ((StringBuilder)localObject2).toString());
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.e != 0) || (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d != 0)) && (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.e <= this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.d)) {
        paramFloat2 = ScreenUtil.SCREEN_HIGHT / 2;
      }
      FaceLayer.LayerParams localLayerParams = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      Object localObject2 = this.a.a();
      int i;
      if ((paramItem.d == 3) && ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams == null) || (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b())))
      {
        localObject2 = this.a.a();
        i = 3;
      }
      else
      {
        i = 0;
      }
      if (TextUtils.isEmpty(paramString)) {
        paramString = paramItem.b;
      }
      boolean bool3 = ((FaceLayer)localObject2).a(paramItem.m, paramString, (Drawable)localObject1, localLayerParams, "", paramItem.a, paramItem.l, i, localInfoStickerDrawable.c(), 0, this.a.d());
      if (QLog.isColorLevel())
      {
        paramItem = new StringBuilder();
        paramItem.append("add Face result");
        paramItem.append(bool3);
        QLog.d("DoodleLayout", 2, paramItem.toString());
      }
      bool1 = bool2;
      if (this.a.b)
      {
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      DoodleLayout.d(bool1);
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    SLog.a("DoodleLayout", "onLocationFaceSelected, pictureUrl: %s , x : %s , y : %s , scale : %f", paramItem.d, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3));
    this.a.a(paramItem, paramFloat1, paramFloat2, paramFloat3);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    VideoEditReport.b("0X80075E3");
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onComboLocationFaceSelected, pictureUrl:");
    localStringBuilder.append(paramItem.d);
    SLog.b("DoodleLayout", localStringBuilder.toString());
    this.a.a(paramItem, paramFloat1, paramFloat2, paramFloat3, paramSegmentKeeper);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null) && (this.a.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.jdField_a_of_type_Int == 3)) {
      LpReportInfo_pf00064.report(615, 6);
    }
    VideoEditReport.b("0X80075E3");
  }
  
  public void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    SLog.b("DoodleLayout", "onNormalFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramSelectedItem, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    if (a(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, true))
    {
      DoodleLayout.a("clk_oneface");
      VideoEditReport.a("0X80076CA");
      VideoEditReport.b("0X80075DF");
    }
    if (SlideShowPhotoListManager.a().b() == 22) {
      LpReportInfo_pf00064.allReport(680, 8, 1);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.a.a().a(paramString1, paramString2);
    this.a.a().a(paramString1, paramString2);
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.invalidate();
  }
  
  public void b(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    SLog.b("DoodleLayout", "onInformationFaceSelected, item : %s , x : %s , y : %s , scale : %s path: %s", new Object[] { paramSelectedItem, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), paramString });
    a(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout.FaceSelectedListener
 * JD-Core Version:    0.7.0.1
 */