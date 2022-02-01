package com.tencent.aelight.camera.aeeditor.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.utils.ViewUtils;

public class AEEditorMusicWaveView
  extends View
  implements AEEditorMusicWaveScrollProcessor.IMusicScrollProcessorParent
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = ViewConfiguration.get(getContext()).getScaledTouchSlop();
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener;
  private AEEditorMusicWaveScrollProcessor jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
  private AEEditorMusicWaveView.IDragIndicatorListener jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView$IDragIndicatorListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 0.0F;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private float jdField_d_of_type_Float = 0.0F;
  private boolean jdField_d_of_type_Boolean = false;
  private float jdField_e_of_type_Float = 0.0F;
  private boolean jdField_e_of_type_Boolean = true;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  
  public AEEditorMusicWaveView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setFocusable(true);
    setFocusableInTouchMode(true);
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.a(paramMotionEvent);
    }
  }
  
  private void d()
  {
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.f();
  }
  
  public int a(int paramInt)
  {
    AEEditorMusicWaveScrollProcessor localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if (localAEEditorMusicWaveScrollProcessor != null)
    {
      this.jdField_b_of_type_Int = localAEEditorMusicWaveScrollProcessor.a();
      if ((this.jdField_b_of_type_Int <= this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c()) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c()))
      {
        f1 = paramInt * 1.0F / (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c() * 2) * (this.jdField_b_of_type_Int - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c());
        break label96;
      }
    }
    float f1 = 0.0F;
    label96:
    return (int)f1;
  }
  
  public Context a()
  {
    return getContext();
  }
  
  public void a()
  {
    invalidate();
  }
  
  public void a(int paramInt)
  {
    AEEditorMusicWaveScrollProcessor localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if (localAEEditorMusicWaveScrollProcessor != null) {
      localAEEditorMusicWaveScrollProcessor.c(paramInt);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString2))
    {
      AEQLog.d("AEEditorMusicWaveView", "audioPath is empty, can not init");
      return;
    }
    if ((paramString2.equals(this.jdField_a_of_type_JavaLangString)) && (!paramBoolean2))
    {
      AEQLog.b("AEEditorMusicWaveView", "相同 audioPath， 不再重新初始化裁剪条");
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor = new AEEditorMusicWaveScrollProcessor(this, paramString1, paramString2, paramInt1, paramInt2, ViewUtils.a(18.0F), paramBoolean1, paramInt3, paramInt4);
    paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if (paramString1 != null) {
      paramString1.a(this.h);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_Boolean = true;
    if (!paramBoolean1)
    {
      paramString1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
      if (paramString1 != null)
      {
        this.jdField_b_of_type_Int = paramString1.a();
        this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.b();
      }
    }
    requestLayout();
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, int paramInt4, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.g = paramBoolean2;
    a(paramString1, paramString2, paramInt1, paramInt2, paramBoolean1, paramInt3, paramInt4, paramBoolean3);
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  void b()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  void c()
  {
    this.jdField_b_of_type_Boolean = false;
  }
  
  public boolean c()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AEEditorMusicWaveScrollProcessor localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if (localAEEditorMusicWaveScrollProcessor == null) {
      return;
    }
    localAEEditorMusicWaveScrollProcessor.a(paramCanvas, this.jdField_e_of_type_Boolean);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor == null)
    {
      setMeasuredDimension(0, 0);
      return;
    }
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.e());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isEnabled()) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor == null) {
      return false;
    }
    if (!a()) {
      return false;
    }
    int i = paramMotionEvent.getAction() & 0xFF;
    AEEditorMusicWaveScrollProcessor localAEEditorMusicWaveScrollProcessor;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            this.f = false;
            if (b())
            {
              c();
              a(paramMotionEvent);
              setPressed(false);
            }
            invalidate();
          }
        }
        else
        {
          localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
          if (localAEEditorMusicWaveScrollProcessor != null)
          {
            this.jdField_b_of_type_Int = localAEEditorMusicWaveScrollProcessor.a();
            if (this.f)
            {
              localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
              if ((localAEEditorMusicWaveScrollProcessor != null) && (this.jdField_b_of_type_Int >= localAEEditorMusicWaveScrollProcessor.c()) && (paramMotionEvent.getX() >= this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c()) && (paramMotionEvent.getX() <= this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.d()))
              {
                this.jdField_b_of_type_Int = ((int)paramMotionEvent.getX());
                this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.a(this.jdField_b_of_type_Int);
                this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.b(this.jdField_b_of_type_Int);
                invalidate();
                break label525;
              }
            }
          }
          if (b())
          {
            a(paramMotionEvent);
          }
          else if (Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float) > this.jdField_a_of_type_Int)
          {
            setPressed(true);
            invalidate();
            b();
            a(paramMotionEvent);
            d();
          }
        }
      }
      else if (this.f)
      {
        this.f = false;
        paramMotionEvent = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView$IDragIndicatorListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.a());
        }
      }
      else
      {
        if (b())
        {
          a(paramMotionEvent);
          c();
          setPressed(false);
          this.jdField_d_of_type_Boolean = true;
        }
        else
        {
          b();
          a(paramMotionEvent);
          c();
        }
        this.f = false;
        invalidate();
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
      if (localAEEditorMusicWaveScrollProcessor != null)
      {
        this.jdField_b_of_type_Int = localAEEditorMusicWaveScrollProcessor.a();
        if ((this.g) && (this.jdField_b_of_type_Int >= this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c()))
        {
          float f1 = this.jdField_a_of_type_Float;
          i = this.jdField_b_of_type_Int;
          int j = this.jdField_c_of_type_Int;
          if ((f1 >= i - j / 2 - 70) && (f1 <= i + j / 2 + 70)) {
            this.f = true;
          }
        }
        this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
      }
      if (!this.jdField_a_of_type_Boolean) {
        return super.onTouchEvent(paramMotionEvent);
      }
      setPressed(true);
      invalidate();
      b();
      a(paramMotionEvent);
      d();
    }
    label525:
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setCurrentPosition(int paramInt1, int paramInt2)
  {
    AEEditorMusicWaveScrollProcessor localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if (localAEEditorMusicWaveScrollProcessor != null) {
      localAEEditorMusicWaveScrollProcessor.a(paramInt1, paramInt2);
    }
  }
  
  public void setDragIndicatorListener(AEEditorMusicWaveView.IDragIndicatorListener paramIDragIndicatorListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveView$IDragIndicatorListener = paramIDragIndicatorListener;
  }
  
  public void setEnableTrimMusic(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setIndicatorIndex(int paramInt)
  {
    AEEditorMusicWaveScrollProcessor localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if ((localAEEditorMusicWaveScrollProcessor != null) && (localAEEditorMusicWaveScrollProcessor.g() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.f() > 0.01D))
    {
      float f1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c();
      float f2 = (paramInt - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.f()) * 1.0F / (this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.g() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.f());
      float f3 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c() * 2;
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.a((int)(f1 + f2 * f3));
    }
  }
  
  public void setIndicatorIndexByVideo(int paramInt1, int paramInt2)
  {
    AEEditorMusicWaveScrollProcessor localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if ((localAEEditorMusicWaveScrollProcessor != null) && (localAEEditorMusicWaveScrollProcessor.g() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.f() > 0.01D))
    {
      float f1 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c();
      float f2 = paramInt1 * 1.0F / paramInt2;
      float f3 = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.d() - this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.c() * 2;
      localAEEditorMusicWaveScrollProcessor = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
      paramInt1 = (int)(f1 + f2 * f3);
      localAEEditorMusicWaveScrollProcessor.a(paramInt1);
      this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor.b(paramInt1);
    }
  }
  
  public void setIsPinjieWithOneMusic(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setOnMusicMoveListener(AEEditorMusicWaveScrollProcessor.IMusicBarMoveListener paramIMusicBarMoveListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener = paramIMusicBarMoveListener;
    paramIMusicBarMoveListener = this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor;
    if (paramIMusicBarMoveListener != null) {
      paramIMusicBarMoveListener.a(this.jdField_a_of_type_ComTencentAelightCameraAeeditorViewAEEditorMusicWaveScrollProcessor$IMusicBarMoveListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveView
 * JD-Core Version:    0.7.0.1
 */