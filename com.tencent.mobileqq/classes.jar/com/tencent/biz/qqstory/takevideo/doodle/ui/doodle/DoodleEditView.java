package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.List;
import ohw;
import ohx;
import oim;

public class DoodleEditView
  extends DoodleView
  implements oim
{
  private float jdField_a_of_type_Float;
  public TextFaceEditLayer a;
  private DoodleEditView.DoodleEditViewListener jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener;
  Runnable jdField_a_of_type_JavaLangRunnable = new ohx(this);
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  
  public DoodleEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer = new TextFaceEditLayer(this);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    setLayoutParams(localLayoutParams);
  }
  
  public void a(EditVideoParams paramEditVideoParams)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    Object localObject2;
    Object localObject1;
    if ((paramBoolean) || ((!paramBoolean) && (getVisibility() == 0))) {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b())
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a();
        ((GestureHelper.ZoomItem)localObject2).d = false;
        if (!(localObject2 instanceof FaceLayer.FaceItem)) {
          break label118;
        }
        localObject1 = (FaceLayer)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("FaceLayer");
        localObject2 = (FaceLayer.FaceItem)localObject2;
        if (localObject1 != null) {
          ((FaceLayer)localObject1).a.add(localObject2);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b();
      setVisibility(8);
      return;
      label118:
      if ((localObject2 instanceof TextLayer.TextItem))
      {
        localObject1 = (TextLayer)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
        if (localObject1 != null) {
          ((TextLayer)localObject1).d();
        }
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.f();
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Float = 0.0F;
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
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.d(paramCanvas);
    paramCanvas.restore();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Float > 0.0F) || (this.jdField_b_of_type_Float > 0.0F))
    {
      MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
      localMotionEvent.setLocation(paramMotionEvent.getX() - this.jdField_a_of_type_Float, paramMotionEvent.getY() - this.jdField_b_of_type_Float);
      paramMotionEvent = localMotionEvent;
    }
    for (int i = 1;; i = 0)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b(paramMotionEvent))) {
        this.jdField_b_of_type_Boolean = true;
      }
      boolean bool;
      if (this.jdField_b_of_type_Boolean)
      {
        bool = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.e(paramMotionEvent);
        invalidate();
      }
      for (;;)
      {
        if (paramMotionEvent.getAction() == 1) {
          this.jdField_b_of_type_Boolean = false;
        }
        if (i != 0) {
          paramMotionEvent.recycle();
        }
        return bool;
        c();
        bool = false;
      }
    }
  }
  
  public void setDoodleEditViewListener(DoodleEditView.DoodleEditViewListener paramDoodleEditViewListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleEditView$DoodleEditViewListener = paramDoodleEditViewListener;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Oin);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.a(new ohw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */