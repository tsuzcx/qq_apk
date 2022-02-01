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
    if (!this.a.a.d()) {
      return;
    }
    paramSegmentKeeper = DoodleUtil.a(paramSelectedItem, paramFloat1, paramFloat2, paramFloat3);
    paramSelectedItem = this.a.l.getFaceLayer().a(this.a.a.h(), paramSelectedItem.a, paramSelectedItem.b, paramSelectedItem.c, paramSegmentKeeper, paramString, paramSelectedItem.d, false, null, null, this.a.getFrom());
    this.a.a.b(paramSelectedItem);
    this.a.postInvalidate();
  }
  
  public void a()
  {
    this.a.a.i();
  }
  
  public void a(InformationFacePackage.Item paramItem, String paramString, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (this.a.a.d())
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
        paramItem.o = 0;
      } else {
        paramItem.o = 3;
      }
      localObject2 = InformationFaceConstant.a(paramItem, this.a.getContext(), -1L);
      if (bool)
      {
        if (localObject2 != null) {
          localObject1 = new BitmapDrawable(this.a.getContext().getResources(), ((InfoStickerDrawable)localObject2).h());
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
        bool = this.a.a.b instanceof FaceLayer.FaceItem;
        float f2 = 0.0F;
        float f1;
        if (bool)
        {
          localObject2 = (FaceLayer.FaceItem)this.a.a.b;
          if (((FaceLayer.FaceItem)localObject2).B > 4.0D) {
            ((FaceLayer.FaceItem)localObject2).B = 1.0F;
          }
          f2 = ((FaceLayer.FaceItem)localObject2).A.x - ((FaceLayer.FaceItem)localObject2).B * ((Drawable)localObject1).getIntrinsicWidth() / 2.0F + ((FaceLayer.FaceItem)localObject2).D;
          f1 = ((FaceLayer.FaceItem)localObject2).A.x;
          if (f2 < ScreenUtil.dip2px(23.0F)) {
            f1 = ((FaceLayer.FaceItem)localObject2).A.x - f2 + ScreenUtil.dip2px(23.0F);
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
          paramItem = this.a.l.getDynamicFaceLayer().a(this.a.a.h(), paramItem.t, paramString, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, "", paramItem.o, paramItem.p, paramItem.q, ((InfoStickerDrawable)localObject1).g(), this.a.getFrom());
        }
        else
        {
          paramItem.o = 0;
          paramItem = this.a.l.getFaceLayer().a(this.a.a.h(), paramItem.t, paramString, (Drawable)localObject1, (FaceLayer.LayerParams)localObject2, "", paramItem.o, false, paramItem.q, null, this.a.getFrom());
        }
        if (((paramItem instanceof FaceLayer.FaceItem)) && ((this.a.a.b instanceof FaceLayer.FaceItem))) {
          ((FaceLayer.FaceItem)paramItem).x = ((FaceLayer.FaceItem)this.a.a.b).x;
        }
        this.a.a.b(paramItem);
        paramItem.A.x = f1;
        this.a.postInvalidate();
      }
    }
  }
  
  public void a(LocationFacePackage.Item paramItem, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.a.a.d()) {
      return;
    }
    FaceLayer.LayerParams localLayerParams = DoodleUtil.a(paramItem, this.a.getWidth(), this.a.getHeight(), paramFloat1, paramFloat2);
    if (localLayerParams != null)
    {
      if ((paramItem.e != null) && ((paramItem.e instanceof URLDrawable)))
      {
        File localFile = ((URLDrawable)paramItem.e).getFileInLocal();
        if ((localFile != null) && (localFile.exists()))
        {
          paramItem = this.a.l.getFaceLayer().a(this.a.a.h(), paramItem.i, paramItem.c, paramItem.e, localLayerParams, localFile.getAbsolutePath(), paramItem.j, false, null, null, this.a.getFrom());
          this.a.a.b(paramItem);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView.1
 * JD-Core Version:    0.7.0.1
 */