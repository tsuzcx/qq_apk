package com.tencent.gdtad.views.videoceiling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.log.GdtLog;

public class GdtVideoCeilingLandView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  private AdCanvasView jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  private GdtVideoCeilingListener jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener;
  public boolean a;
  private float jdField_b_of_type_Float;
  public int b;
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private float jdField_d_of_type_Float;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = false;
  
  public GdtVideoCeilingLandView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private boolean a()
  {
    if ((!this.e) && (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null))
    {
      GdtLog.b("GdtVideoCeilingLandView", "noCanvasViewScrollY mWebView.getWebScrollY() -> " + this.jdField_a_of_type_ComTencentBizUiTouchWebView.getWebScrollY());
      if (Math.abs(this.jdField_a_of_type_ComTencentBizUiTouchWebView.getWebScrollY()) >= 1) {}
    }
    do
    {
      return true;
      return false;
      if ((!this.e) || (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView == null)) {
        break;
      }
      GdtLog.b("GdtVideoCeilingLandView", "noCanvasViewScrollY mNativeView.getPageViewScrollY() -> " + this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.getPageViewScrollY());
    } while (Math.abs(this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.getPageViewScrollY()) < 1);
    return false;
    return false;
  }
  
  public static boolean a(float paramFloat)
  {
    return paramFloat < 0.0F;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityResume();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityPause();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityDestroy();
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
          GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent mState " + this.jdField_a_of_type_Int);
          switch (MotionEventCompat.getActionMasked(paramMotionEvent))
          {
          default: 
            return false;
          case 0: 
            GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent ACTION_DOWN mBeingDrag " + this.jdField_b_of_type_Boolean);
            this.jdField_b_of_type_Float = paramMotionEvent.getRawX();
            this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
            return false;
          case 2: 
            GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent ACTION_MOVE mBeingDrag " + this.jdField_b_of_type_Boolean);
            f1 = paramMotionEvent.getRawX();
            f3 = paramMotionEvent.getRawY();
            f2 = this.jdField_b_of_type_Float;
            f3 -= this.jdField_a_of_type_Float;
            bool1 = bool3;
          }
        } while (Math.abs(f3) <= this.jdField_c_of_type_Int);
        bool1 = bool3;
      } while (Math.abs(f3) <= Math.abs(f1 - f2));
      if (this.jdField_a_of_type_Int == 0)
      {
        this.jdField_b_of_type_Boolean = true;
        GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent ACTION_MOVE mState -> BOTTOM_WEBVIEW_STATE ");
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
    GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent ACTION_MOVE mState -> TOP_WEBVIEW_STATE, result -> " + bool1 + ", noCanvasViewScrollY -> " + a() + ", isScrollUp -> " + a(f3));
    return bool1;
    GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent  ACTION_UP");
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
          if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener != null) {
            this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener.a(this.jdField_a_of_type_Int);
          }
        }
        switch (MotionEventCompat.getActionMasked(paramMotionEvent))
        {
        default: 
          return true;
        case 0: 
          GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_DOWN");
          return true;
        case 2: 
          GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_MOVE");
          f1 = paramMotionEvent.getRawX();
          f2 = paramMotionEvent.getRawY();
          f3 = f2 - this.jdField_c_of_type_Float;
          f4 = this.jdField_d_of_type_Float;
          bool1 = bool2;
        }
      } while (Math.abs(f3) <= Math.abs(f1 - f4));
      if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener != null)
      {
        GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  onDrag");
        this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener.b((int)f3);
      }
      this.jdField_d_of_type_Float = f1;
      this.jdField_c_of_type_Float = f2;
      return true;
      GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_UP");
      this.jdField_d_of_type_Float = 0.0F;
      this.jdField_c_of_type_Float = 0.0F;
      bool1 = bool2;
    } while (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener == null);
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener.c(this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Boolean = false;
    return true;
  }
  
  public void setGdtVideoCeilingListeners(GdtVideoCeilingListener paramGdtVideoCeilingListener, TouchWebView paramTouchWebView)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener = paramGdtVideoCeilingListener;
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = paramTouchWebView;
    this.e = false;
  }
  
  public void setGdtVideoCeilingNativeListeners(GdtVideoCeilingListener paramGdtVideoCeilingListener, AdCanvasView paramAdCanvasView)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener = paramGdtVideoCeilingListener;
    this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView = paramAdCanvasView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView
 * JD-Core Version:    0.7.0.1
 */