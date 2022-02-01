package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicRawImage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import java.util.ArrayList;
import java.util.List;

public class DoodleEditView
  extends DoodleView
  implements DoodleLayout.OnTextDialogShowListener
{
  private float jdField_a_of_type_Float = 0.0F;
  private IFaceSelectedListener jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
  protected TextFaceEditLayer a;
  private DoodleEditView.DoodleEditViewListener jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new DoodleEditView.3(this);
  private float jdField_b_of_type_Float = 0.0F;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  private int e;
  
  public DoodleEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public int a()
  {
    return this.e;
  }
  
  public IFaceSelectedListener a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener;
  }
  
  public TextFaceEditLayer a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer = new TextFaceEditLayer(this);
    setLayerType(1, null);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureDataIFaceSelectedListener = new DoodleEditView.1(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int j = getContext().getResources().getDisplayMetrics().widthPixels;
    int i = getContext().getResources().getDisplayMetrics().heightPixels;
    if (EditPicRawImage.a != 0) {
      i = EditPicRawImage.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("w: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" h: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" width: ");
    localStringBuilder.append(j);
    localStringBuilder.append(" height: ");
    localStringBuilder.append(i);
    AEQLog.b("DoodleEditView", localStringBuilder.toString());
    if (j > paramInt1) {
      this.jdField_a_of_type_Float = ((j - paramInt1) / 2.0F);
    }
    if (i > paramInt2) {
      this.jdField_b_of_type_Float = ((i - paramInt2) / 2.0F);
    }
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams = paramEditVideoParams;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0)))
    {
      if (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b())
      {
        localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a();
        ((GestureHelper.ZoomItem)localObject1).f = false;
        Object localObject2;
        Object localObject3;
        if ((localObject1 instanceof FaceLayer.FaceItem))
        {
          localObject2 = (FaceLayer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(FaceLayer.jdField_a_of_type_JavaLangString);
          localObject3 = (FaceLayer.FaceItem)localObject1;
          if (((FaceLayer.FaceItem)localObject3).h != 1)
          {
            localObject1 = localObject2;
            if (((FaceLayer.FaceItem)localObject3).h != 3) {}
          }
          else if (this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams != null)
          {
            localObject1 = localObject2;
            if (!this.jdField_a_of_type_ComTencentMobileqqEditorParamsEditVideoParams.b()) {}
          }
          else
          {
            localObject1 = (FaceLayer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a("DynamicFaceLayer");
            ((FaceLayer.FaceItem)localObject3).a.setCallback(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView);
          }
          if (localObject1 != null) {
            ((FaceLayer)localObject1).jdField_a_of_type_JavaUtilList.add(localObject3);
          }
        }
        else if ((localObject1 instanceof TextLayer.TextItem))
        {
          localObject1 = (TextLayer.TextItem)localObject1;
          if (((TextLayer.TextItem)localObject1).a != null) {
            ((TextLayer.TextItem)localObject1).a.a(-1, false);
          }
          localObject2 = (TextLayer)this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.a(TextLayer.jdField_a_of_type_JavaLangString);
          if (localObject2 != null)
          {
            localObject3 = ((TextLayer.TextItem)localObject1).a;
            if (localObject3 != null)
            {
              if ((!((DynamicTextItem)localObject3).e()) && (((DynamicTextItem)localObject3).d())) {
                ((DynamicTextItem)localObject3).a(true);
              }
              if (!((DynamicTextItem)localObject3).b()) {
                ((TextLayer)localObject2).jdField_a_of_type_JavaUtilArrayList.add(localObject1);
              }
            }
          }
        }
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleView.invalidate();
      }
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.d();
      setVisibility(8);
      Object localObject1 = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener;
      if (localObject1 != null) {
        ((DoodleEditView.DoodleEditViewListener)localObject1).a();
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b();
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setVisibility(4);
      return;
    }
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, TextLayer.e);
  }
  
  public void c()
  {
    a(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    paramCanvas.save();
    if ((this.jdField_a_of_type_Float > 0.0F) || (this.jdField_b_of_type_Float > 0.0F)) {
      paramCanvas.translate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.d(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if ((this.jdField_a_of_type_Float <= 0.0F) && (this.jdField_b_of_type_Float <= 0.0F))
    {
      i = 0;
    }
    else
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setLocation(paramMotionEvent.getX() - this.jdField_a_of_type_Float, paramMotionEvent.getY() - this.jdField_b_of_type_Float);
      paramMotionEvent = localMotionEvent;
      i = 1;
    }
    if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.b(paramMotionEvent))) {
      this.c = true;
    }
    boolean bool;
    if (this.c)
    {
      bool = this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.c(paramMotionEvent);
      invalidate();
    }
    else
    {
      c();
      bool = false;
    }
    if (paramMotionEvent.getAction() == 1) {
      this.c = false;
    }
    if (i != 0) {
      paramMotionEvent.recycle();
    }
    return bool;
  }
  
  public void setDoodleEditViewListener(DoodleEditView.DoodleEditViewListener paramDoodleEditViewListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener = paramDoodleEditViewListener;
  }
  
  public void setFrom(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleUiDoodleDoodleLayout$TextFaceLayerTouchListener);
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorTakevideoDoodleLayerTextFaceEditLayer.a(new DoodleEditView.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */