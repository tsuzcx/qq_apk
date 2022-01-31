package com.tencent.gdtad.views.videoceiling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.views.canvas.framework.GdtCanvasView;
import yxp;
import zbl;

public class GdtVideoCeilingLandView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtCanvasView jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView;
  private zbl jdField_a_of_type_Zbl;
  public boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public GdtVideoCeilingLandView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private boolean a()
  {
    if ((!this.e) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null))
    {
      yxp.b("GdtVideoCeilingView", "noCanvasViewScrollY mWebView.getWebScrollY() -> " + this.jdField_a_of_type_ComTencentBizUiTouchWebView.getWebScrollY());
      if (Math.abs(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getWebScrollY()) >= 1) {}
    }
    do
    {
      return true;
      return false;
      if ((!this.e) || (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView == null)) {
        break;
      }
      yxp.b("GdtVideoCeilingView", "noCanvasViewScrollY mNativeView.getPageViewScrollY() -> " + this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView.a());
    } while (Math.abs(this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView.a()) < 1);
    return false;
    return false;
  }
  
  public static boolean a(float paramFloat)
  {
    return paramFloat < 0.0F;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView.b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView.c();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView != null) {
      this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView.a();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1;
    if (this.jdField_c_of_type_Boolean) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    float f3;
    do
    {
      float f1;
      float f2;
      do
      {
        do
        {
          return bool1;
          if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) {
            return true;
          }
          yxp.b("GdtVideoCeilingView", "onInterceptTouchEvent mState " + this.jdField_a_of_type_Int);
          switch (MotionEventCompat.getActionMasked(paramMotionEvent))
          {
          default: 
            return false;
          case 0: 
            yxp.b("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_DOWN mBeingDrag " + this.jdField_b_of_type_Boolean);
            this.jdField_b_of_type_Float = paramMotionEvent.getRawX();
            this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
            return false;
          case 2: 
            yxp.b("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_MOVE mBeingDrag " + this.jdField_b_of_type_Boolean);
            f1 = paramMotionEvent.getRawX();
            f3 = paramMotionEvent.getRawY();
            f2 = this.jdField_b_of_type_Float;
            f3 -= this.jdField_a_of_type_Float;
            bool1 = bool3;
          }
        } while (Math.abs(f3) <= this.jdField_b_of_type_Int);
        bool1 = bool3;
      } while (Math.abs(f3) <= Math.abs(f1 - f2));
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_b_of_type_Boolean = true;
        yxp.b("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_MOVE mState -> BOTTOM_WEBVIEW_STATE ");
        return true;
      }
      bool1 = bool3;
    } while (this.jdField_a_of_type_Int != 2);
    if (!this.jdField_b_of_type_Boolean)
    {
      bool1 = bool2;
      if (a())
      {
        bool1 = bool2;
        if (a(f3)) {}
      }
    }
    else
    {
      this.jdField_b_of_type_Boolean = true;
      bool1 = true;
    }
    yxp.b("GdtVideoCeilingView", "onInterceptTouchEvent ACTION_MOVE mState -> TOP_WEBVIEW_STATE, result -> " + bool1 + ", noCanvasViewScrollY -> " + a() + ", isScrollUp -> " + a(f3));
    return bool1;
    yxp.b("GdtVideoCeilingView", "onInterceptTouchEvent  ACTION_UP");
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_b_of_type_Boolean = false;
    return false;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.jdField_d_of_type_Boolean) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      float f1;
      float f2;
      float f3;
      float f4;
      do
      {
        do
        {
          return bool1;
          bool1 = bool2;
        } while (this.jdField_a_of_type_Boolean);
        if ((this.jdField_d_of_type_Float == 0.0F) || (this.jdField_c_of_type_Float == 0.0F))
        {
          this.jdField_d_of_type_Float = paramMotionEvent.getRawX();
          this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
          if (this.jdField_a_of_type_Zbl != null) {
            this.jdField_a_of_type_Zbl.a(this.jdField_a_of_type_Int);
          }
        }
        switch (MotionEventCompat.getActionMasked(paramMotionEvent))
        {
        default: 
          return true;
        case 0: 
          yxp.c("GdtVideoCeilingView", "onTouchEvent  ACTION_DOWN");
          return true;
        case 2: 
          yxp.c("GdtVideoCeilingView", "onTouchEvent  ACTION_MOVE");
          f1 = paramMotionEvent.getRawX();
          f2 = paramMotionEvent.getRawY();
          f3 = f2 - this.jdField_c_of_type_Float;
          f4 = this.jdField_d_of_type_Float;
          bool1 = bool2;
        }
      } while (Math.abs(f3) <= Math.abs(f1 - f4));
      if (this.jdField_a_of_type_Zbl != null)
      {
        yxp.c("GdtVideoCeilingView", "onTouchEvent  onDrag");
        this.jdField_a_of_type_Zbl.b((int)f3);
      }
      this.jdField_d_of_type_Float = f1;
      this.jdField_c_of_type_Float = f2;
      return true;
      yxp.c("GdtVideoCeilingView", "onTouchEvent  ACTION_UP");
      this.jdField_d_of_type_Float = 0.0F;
      this.jdField_c_of_type_Float = 0.0F;
      bool1 = bool2;
    } while (this.jdField_a_of_type_Zbl == null);
    this.jdField_a_of_type_Zbl.c(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Boolean = false;
    return true;
  }
  
  public void setGdtVideoCeilingListeners(zbl paramzbl, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_Zbl = paramzbl;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    this.e = false;
  }
  
  public void setGdtVideoCeilingNativeListeners(zbl paramzbl, GdtCanvasView paramGdtCanvasView)
  {
    this.jdField_a_of_type_Zbl = paramzbl;
    this.jdField_a_of_type_ComTencentGdtadViewsCanvasFrameworkGdtCanvasView = paramGdtCanvasView;
    this.e = true;
  }
  
  public void setIgnoreInterceptTouchEvent(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setIgnoreTouchEvent(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView
 * JD-Core Version:    0.7.0.1
 */