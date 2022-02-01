package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.PointF;
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
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.LayerParams;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.model.SelectedItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DoodleUtil;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DoodleEditView$1
  implements IFaceSelectedListener
{
  DoodleEditView$1(DoodleEditView paramDoodleEditView) {}
  
  private void c(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    if (!this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b()) {
      return;
    }
    paramSegmentKeeper = DoodleUtil.a(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3);
    paramSelectedItem = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a(), paramSelectedItem.jdField_a_of_type_JavaLangString, paramSelectedItem.b, paramSelectedItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramSegmentKeeper, paramString, paramSelectedItem.jdField_a_of_type_Int, false, null, null, this.a.a());
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b(paramSelectedItem);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.d();
  }
  
  public void a(InformationFacePackage.Item paramItem, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b())
    {
      if (paramItem == null) {
        return;
      }
      Object localObject1 = null;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addLocationFaceItem:");
      ((StringBuilder)localObject2).append(paramItem.toString());
      SLog.b("DoodleEditView", ((StringBuilder)localObject2).toString());
      boolean bool = this.a.getContext() instanceof EditPicActivity;
      if (bool) {
        paramItem.d = 0;
      } else {
        paramItem.d = 3;
      }
      localObject2 = InformationFaceConstant.a(paramItem, this.a.getContext(), -1L);
      if (bool)
      {
        if (localObject2 != null) {
          localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((InfoStickerDrawable)localObject2).a());
        }
      }
      else {
        localObject1 = localObject2;
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
          QLog.d("DoodleEditView", 2, ((StringBuilder)localObject2).toString());
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("x:");
          ((StringBuilder)localObject2).append(paramFloat1);
          QLog.d("DoodleEditView", 2, ((StringBuilder)localObject2).toString());
        }
        bool = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a instanceof FaceLayer.FaceItem;
        float f2 = 0.0F;
        float f1;
        if (bool)
        {
          localObject2 = (FaceLayer.FaceItem)this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a;
          if (((FaceLayer.FaceItem)localObject2).j > 4.0D) {
            ((FaceLayer.FaceItem)localObject2).j = 1.0F;
          }
          f2 = ((FaceLayer.FaceItem)localObject2).a.x - ((FaceLayer.FaceItem)localObject2).j * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F + ((FaceLayer.FaceItem)localObject2).l;
          f1 = ((FaceLayer.FaceItem)localObject2).a.x;
          if (f2 < ScreenUtil.dip2px(23.0F)) {
            f1 = ((FaceLayer.FaceItem)localObject2).a.x - f2 + ScreenUtil.dip2px(23.0F);
          }
        }
        else
        {
          f1 = 0.0F;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startX:");
          ((StringBuilder)localObject2).append(f2);
          ((StringBuilder)localObject2).append("x:");
          ((StringBuilder)localObject2).append(paramFloat1);
          QLog.d("DoodleEditView", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = new FaceLayer.LayerParams(paramFloat1, paramFloat2, paramFloat3, 0.0F, 0.0F, 0.0F, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        if (TextUtils.isEmpty(paramString)) {
          paramString = paramItem.b;
        }
        if ((localObject1 instanceof InfoStickerDrawable))
        {
          paramItem = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a(), paramItem.m, paramString, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, "", paramItem.d, paramItem.a, paramItem.l, ((InfoStickerDrawable)localObject1).c(), this.a.a());
        }
        else
        {
          paramItem.d = 0;
          paramItem = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a(), paramItem.m, paramString, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, "", paramItem.d, false, paramItem.l, null, this.a.a());
        }
        if (((paramItem instanceof FaceLayer.FaceItem)) && ((this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a instanceof FaceLayer.FaceItem))) {
          ((FaceLayer.FaceItem)paramItem).g = ((FaceLayer.FaceItem)this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a).g;
        }
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b(paramItem);
        paramItem.a.x = f1;
        this.a.postInvalidate();
      }
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b()) {
      return;
    }
    FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localLayerParams != null)
    {
      if ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && ((paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          paramItem = this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.a().a(this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a(), paramItem.g, paramItem.c, paramItem.jdField_a_of_type_AndroidGraphicsDrawableDrawable, localLayerParams, localFile.getAbsolutePath(), paramItem.jdField_a_of_type_Int, false, null, null, this.a.a());
          this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b(paramItem);
        }
      }
    }
    else {
      SLog.e("DoodleEditView", "create FaceLayer.ItemParams failed.");
    }
    this.a.postInvalidate();
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3, SegmentKeeper paramSegmentKeeper) {}
  
  public void a(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
  
  public void a(String paramString1, String paramString2) {}
  
  public void b(SelectedItem paramSelectedItem, float paramFloat1, float paramFloat2, float paramFloat3, String paramString, SegmentKeeper paramSegmentKeeper)
  {
    c(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3, paramString, paramSegmentKeeper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView.1
 * JD-Core Version:    0.7.0.1
 */