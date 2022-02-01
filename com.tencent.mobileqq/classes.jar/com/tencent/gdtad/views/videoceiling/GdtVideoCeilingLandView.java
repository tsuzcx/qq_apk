package com.tencent.gdtad.views.videoceiling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.smtt.sdk.WebView;

public class GdtVideoCeilingLandView
  extends RelativeLayout
{
  private float jdField_a_of_type_Float;
  public int a;
  private AdCanvasView jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView;
  private GdtVideoCeilingListener jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener;
  private WebView jdField_a_of_type_ComTencentSmttSdkWebView;
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
    boolean bool3 = this.e;
    boolean bool2 = false;
    boolean bool1 = false;
    StringBuilder localStringBuilder;
    if ((!bool3) && (this.jdField_a_of_type_ComTencentSmttSdkWebView != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("noCanvasViewScrollY mWebView.getWebScrollY() -> ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentSmttSdkWebView.getWebScrollY());
      GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
      if (Math.abs(this.jdField_a_of_type_ComTencentSmttSdkWebView.getWebScrollY()) < 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.e)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("noCanvasViewScrollY mNativeView.getPageViewScrollY() -> ");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView.getPageViewScrollY());
        GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
        bool1 = bool2;
        if (Math.abs(this.jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView.getPageViewScrollY()) < 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(float paramFloat)
  {
    return paramFloat < 0.0F;
  }
  
  public void a()
  {
    AdCanvasView localAdCanvasView = this.jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityResume();
    }
  }
  
  public void b()
  {
    AdCanvasView localAdCanvasView = this.jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityPause();
    }
  }
  
  public void c()
  {
    AdCanvasView localAdCanvasView = this.jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityDestroy();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_c_of_type_Boolean) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool3 = this.jdField_a_of_type_Boolean;
    boolean bool1 = true;
    boolean bool2 = true;
    if (!bool3)
    {
      if (this.jdField_b_of_type_Boolean) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInterceptTouchEvent mState ");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
      int i = MotionEventCompat.getActionMasked(paramMotionEvent);
      if (i != 0)
      {
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              break label415;
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onInterceptTouchEvent ACTION_MOVE mBeingDrag ");
            localStringBuilder.append(this.jdField_b_of_type_Boolean);
            GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
            float f1 = paramMotionEvent.getRawX();
            float f3 = paramMotionEvent.getRawY();
            float f2 = this.jdField_b_of_type_Float;
            f3 -= this.jdField_a_of_type_Float;
            if ((Math.abs(f3) <= this.jdField_c_of_type_Int) || (Math.abs(f3) <= Math.abs(f1 - f2))) {
              break label415;
            }
            i = this.jdField_a_of_type_Int;
            if (i == 0)
            {
              this.jdField_b_of_type_Boolean = true;
              GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent ACTION_MOVE mState -> BOTTOM_WEBVIEW_STATE ");
              return true;
            }
            if (i != 2) {
              break label415;
            }
            if ((!this.jdField_b_of_type_Boolean) && ((!a()) || (a(f3))))
            {
              bool1 = false;
            }
            else
            {
              this.jdField_b_of_type_Boolean = true;
              bool1 = bool2;
            }
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("onInterceptTouchEvent ACTION_MOVE mState -> TOP_WEBVIEW_STATE, result -> ");
            paramMotionEvent.append(bool1);
            paramMotionEvent.append(", noCanvasViewScrollY -> ");
            paramMotionEvent.append(a());
            paramMotionEvent.append(", isScrollUp -> ");
            paramMotionEvent.append(a(f3));
            GdtLog.b("GdtVideoCeilingLandView", paramMotionEvent.toString());
            return bool1;
          }
        }
        GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent  ACTION_UP");
        this.jdField_b_of_type_Float = 0.0F;
        this.jdField_a_of_type_Float = 0.0F;
        this.jdField_b_of_type_Boolean = false;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onInterceptTouchEvent ACTION_DOWN mBeingDrag ");
        localStringBuilder.append(this.jdField_b_of_type_Boolean);
        GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
        this.jdField_b_of_type_Float = paramMotionEvent.getRawX();
        this.jdField_a_of_type_Float = paramMotionEvent.getRawY();
      }
      label415:
      bool1 = false;
    }
    return bool1;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_d_of_type_Boolean) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_Boolean) {
      return true;
    }
    if ((this.jdField_d_of_type_Float == 0.0F) || (this.jdField_c_of_type_Float == 0.0F))
    {
      this.jdField_d_of_type_Float = paramMotionEvent.getRawX();
      this.jdField_c_of_type_Float = paramMotionEvent.getRawY();
      GdtVideoCeilingListener localGdtVideoCeilingListener = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener;
      if (localGdtVideoCeilingListener != null) {
        localGdtVideoCeilingListener.a(this.jdField_a_of_type_Int);
      }
    }
    int i = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_MOVE");
          float f1 = paramMotionEvent.getRawX();
          float f2 = paramMotionEvent.getRawY();
          float f3 = f2 - this.jdField_c_of_type_Float;
          float f4 = this.jdField_d_of_type_Float;
          if (Math.abs(f3) <= Math.abs(f1 - f4)) {
            break label244;
          }
          if (this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener != null)
          {
            GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  onDrag");
            this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener.b((int)f3);
          }
          this.jdField_d_of_type_Float = f1;
          this.jdField_c_of_type_Float = f2;
          return true;
        }
      }
      GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_UP");
      this.jdField_d_of_type_Float = 0.0F;
      this.jdField_c_of_type_Float = 0.0F;
      paramMotionEvent = this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.c(this.jdField_a_of_type_Int);
        this.jdField_b_of_type_Boolean = false;
        return true;
      }
    }
    else
    {
      GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_DOWN");
    }
    label244:
    return true;
  }
  
  public void setGdtVideoCeilingListeners(GdtVideoCeilingListener paramGdtVideoCeilingListener, WebView paramWebView)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener = paramGdtVideoCeilingListener;
    this.jdField_a_of_type_ComTencentSmttSdkWebView = paramWebView;
    this.e = false;
  }
  
  public void setGdtVideoCeilingNativeListeners(GdtVideoCeilingListener paramGdtVideoCeilingListener, AdCanvasView paramAdCanvasView)
  {
    this.jdField_a_of_type_ComTencentGdtadViewsVideoceilingGdtVideoCeilingListener = paramGdtVideoCeilingListener;
    this.jdField_a_of_type_ComTencentAdTangramViewsCanvasFrameworkAdCanvasView = paramAdCanvasView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView
 * JD-Core Version:    0.7.0.1
 */