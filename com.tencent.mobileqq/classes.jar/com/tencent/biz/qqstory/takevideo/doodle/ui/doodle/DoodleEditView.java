package com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.List;
import xdn;
import xdr;
import xdz;
import xeb;
import xed;
import xge;
import xgf;
import xgg;
import xgx;
import xiq;

public class DoodleEditView
  extends DoodleView
  implements xgx
{
  private float jdField_a_of_type_Float;
  private DoodleView jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  Runnable jdField_a_of_type_JavaLangRunnable = new DoodleEditView.2(this);
  public xdz a;
  private xgf jdField_a_of_type_Xgf;
  private xgg jdField_a_of_type_Xgg;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  
  public DoodleEditView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_Xdz = new xdz(this);
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
      if (this.jdField_a_of_type_Xdz.b())
      {
        localObject2 = this.jdField_a_of_type_Xdz.a();
        ((xiq)localObject2).d = false;
        if (!(localObject2 instanceof xdr)) {
          break label112;
        }
        localObject1 = (xdn)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("FaceLayer");
        localObject2 = (xdr)localObject2;
        if (localObject1 != null) {
          ((xdn)localObject1).a.add(localObject2);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.invalidate();
      this.jdField_a_of_type_Xdz.b();
      setVisibility(8);
      return;
      label112:
      if ((localObject2 instanceof xed))
      {
        localObject1 = (xeb)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.a("TextLayer");
        if (localObject1 != null) {
          ((xeb)localObject1).d();
        }
      }
    }
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Xdz.f();
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
    this.jdField_a_of_type_Xdz.d(paramCanvas);
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
      if ((paramMotionEvent.getAction() == 0) && (this.jdField_a_of_type_Xdz.b(paramMotionEvent))) {
        this.jdField_b_of_type_Boolean = true;
      }
      boolean bool;
      if (this.jdField_b_of_type_Boolean)
      {
        bool = this.jdField_a_of_type_Xdz.e(paramMotionEvent);
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
  
  public void setDoodleEditViewListener(xgf paramxgf)
  {
    this.jdField_a_of_type_Xgf = paramxgf;
  }
  
  public void setDoodleLayout(DoodleLayout paramDoodleLayout)
  {
    super.setDoodleLayout(paramDoodleLayout);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = paramDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView;
  }
  
  public void setDoodleView(DoodleView paramDoodleView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView = paramDoodleView;
  }
  
  public void setEditListener(xgg paramxgg)
  {
    this.jdField_a_of_type_Xgg = paramxgg;
  }
  
  public void setOnLayerTouchListener()
  {
    this.jdField_a_of_type_Xdz.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_Xgz);
    setOnTextEditListener();
  }
  
  public void setOnTextEditListener()
  {
    this.jdField_a_of_type_Xdz.a(new xge(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView
 * JD-Core Version:    0.7.0.1
 */