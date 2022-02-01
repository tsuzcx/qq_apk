package com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;

public class FramesProcessor
  implements FrameAdapter.DataSetChangeListener
{
  public static final boolean a;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private GestureDetector.OnGestureListener jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener = new FramesProcessor.1(this);
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private FrameAdapter jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter;
  private FrameParent jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent;
  private FramesProcessor.OnMoveListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener;
  private OnFetchFrameListener jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener;
  private float[] jdField_a_of_type_ArrayOfFloat = { 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.33F, 0.5F, 0.11F, 0.0F, -50.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  private Rect jdField_c_of_type_AndroidGraphicsRect = new Rect();
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 10) {
      bool = true;
    } else {
      bool = false;
    }
    jdField_a_of_type_Boolean = bool;
  }
  
  public FramesProcessor(FrameParent paramFrameParent, String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3, float paramFloat3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent = paramFrameParent;
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    this.jdField_d_of_type_Int = paramInt2;
    paramFloat2 = paramInt3;
    this.i = paramFloat2;
    float f1 = paramInt1 * 1.0F / paramInt4 * paramFloat1;
    this.f = f1;
    float f2 = this.f;
    float f3 = paramInt2 * paramFloat1;
    this.g = Math.max(f2 - f3, 0.0F);
    this.h = 0.0F;
    if (QLog.isColorLevel())
    {
      paramFrameParent = new StringBuilder();
      paramFrameParent.append("mTotalRange=");
      paramFrameParent.append(this.f);
      paramFrameParent.append(", mMaxMovedDistance=");
      paramFrameParent.append(this.g);
      QLog.d("FramesProcessor", 2, paramFrameParent.toString());
    }
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(paramInt3, (int)this.jdField_c_of_type_Float, Bitmap.Config.RGB_565);
    this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColorFilter(new ColorMatrixColorFilter(this.jdField_a_of_type_ArrayOfFloat));
    this.jdField_a_of_type_Float = paramFloat3;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, (int)paramFloat3, (int)this.jdField_c_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect((int)(paramFloat3 + Math.min(f1, f3)), 0, paramInt3, (int)this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.getContext());
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.getContext(), this.jdField_a_of_type_AndroidViewGestureDetector$OnGestureListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter = new FrameAdapter(this);
    this.jdField_b_of_type_Int = ((int)Math.ceil(paramFloat2 * 1.0F / this.jdField_b_of_type_Float));
    this.jdField_b_of_type_Int = Math.min(this.jdField_b_of_type_Int, paramInt2);
    this.jdField_c_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = 0;
    if (jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener = new VideoFramesRetriever(paramString, paramFloat1);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener = new VideoFramesFetcher();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener.a(paramInt4, paramInt1, this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  private boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) == 0.0F;
  }
  
  private void c()
  {
    FrameAdapter localFrameAdapter = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter;
    if (localFrameAdapter != null)
    {
      if (localFrameAdapter.a()) {
        return;
      }
      int j = (int)(this.jdField_d_of_type_Float / this.jdField_b_of_type_Float);
      this.jdField_a_of_type_Int = Math.max(j, 0);
      int k = this.jdField_c_of_type_Int;
      if (k >= 6) {
        this.jdField_b_of_type_Int = Math.min(k + j, this.jdField_d_of_type_Int);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawColor(-16777216);
    if (this.jdField_a_of_type_AndroidWidgetScroller.computeScrollOffset())
    {
      this.jdField_d_of_type_Float = this.jdField_a_of_type_AndroidWidgetScroller.getCurrX();
      f1 = this.jdField_d_of_type_Float;
      f2 = this.h;
      if (f1 < f2)
      {
        this.jdField_d_of_type_Float = f2;
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      f1 = this.jdField_d_of_type_Float;
      f2 = this.g;
      if (f1 > f2)
      {
        this.jdField_d_of_type_Float = f2;
        this.jdField_a_of_type_AndroidWidgetScroller.forceFinished(true);
      }
      c();
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent;
      if (localObject != null) {
        ((FrameParent)localObject).invalidate();
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    float f1 = this.jdField_d_of_type_Float;
    float f2 = this.e;
    this.e = f1;
    if (a(f1 - f2, 0.0F)) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener;
    if (localObject != null)
    {
      f1 = this.jdField_d_of_type_Float;
      ((FramesProcessor.OnMoveListener)localObject).a(f1, -f1, this.f - f1);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.postInvalidate();
  }
  
  public void a(int paramInt)
  {
    int j = this.jdField_a_of_type_AndroidGraphicsRect.right;
    this.h += j - paramInt;
    this.jdField_a_of_type_AndroidGraphicsRect.right = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.invalidate();
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter == null) {
      return;
    }
    d();
    int j = Math.max(this.jdField_a_of_type_Int - 1, 0);
    float f1 = j * this.jdField_b_of_type_Float;
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(f1 - this.jdField_d_of_type_Float + this.jdField_a_of_type_Float, 0.0F);
    int m = Math.min(this.jdField_b_of_type_Int + 3, this.jdField_d_of_type_Int);
    int k = (int)this.jdField_b_of_type_Float;
    while (j < m)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter.a(j);
      if (localObject2 != null)
      {
        k = (int)Math.min(this.f - f1, this.jdField_b_of_type_Float);
        this.jdField_c_of_type_AndroidGraphicsRect.set(0, 0, k, (int)this.jdField_c_of_type_Float);
        localObject1 = this.jdField_a_of_type_AndroidGraphicsCanvas;
        localObject2 = ((FramesProcessor.Frame)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
        Rect localRect = this.jdField_c_of_type_AndroidGraphicsRect;
        ((Canvas)localObject1).drawBitmap((Bitmap)localObject2, localRect, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      localObject1 = this.jdField_a_of_type_AndroidGraphicsCanvas;
      float f2 = k;
      ((Canvas)localObject1).translate(f2, 0.0F);
      f1 += f2;
      j += 1;
    }
    this.jdField_a_of_type_AndroidGraphicsCanvas.translate(-f1 + this.jdField_d_of_type_Float - this.jdField_a_of_type_Float, 0.0F);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    Object localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
    paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, (Rect)localObject2, this.jdField_b_of_type_AndroidGraphicsPaint);
    localObject1 = this.jdField_a_of_type_AndroidGraphicsBitmap;
    localObject2 = this.jdField_b_of_type_AndroidGraphicsRect;
    paramCanvas.drawBitmap((Bitmap)localObject1, (Rect)localObject2, (Rect)localObject2, this.jdField_b_of_type_AndroidGraphicsPaint);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    GestureDetector localGestureDetector = this.jdField_a_of_type_AndroidViewGestureDetector;
    if (localGestureDetector != null) {
      localGestureDetector.onTouchEvent(paramMotionEvent);
    }
  }
  
  public void a(FramesProcessor.OnMoveListener paramOnMoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener = paramOnMoveListener;
    paramOnMoveListener = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener;
    if (paramOnMoveListener != null)
    {
      float f1 = this.jdField_d_of_type_Float;
      paramOnMoveListener.a(f1, -f1, this.f - f1);
    }
  }
  
  public boolean a()
  {
    return a(this.jdField_d_of_type_Float, 0.0F) ^ true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFramesProcessor$OnMoveListener = null;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetOnFetchFrameListener;
    if (localObject != null) {
      ((OnFetchFrameListener)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter;
    if (localObject != null) {
      ((FrameAdapter)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameAdapter = null;
  }
  
  public void b(int paramInt)
  {
    int j = this.jdField_b_of_type_AndroidGraphicsRect.left;
    this.g += j - paramInt;
    this.jdField_b_of_type_AndroidGraphicsRect.left = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaTrimvideoVideoWidgetFrameParent.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FramesProcessor
 * JD-Core Version:    0.7.0.1
 */