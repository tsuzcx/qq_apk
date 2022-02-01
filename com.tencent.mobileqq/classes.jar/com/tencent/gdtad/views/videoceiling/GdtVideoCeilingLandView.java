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
  public int a = 0;
  public int b = 0;
  public boolean c;
  private GdtVideoCeilingListener d;
  private float e;
  private float f;
  private float g;
  private float h;
  private boolean i = false;
  private WebView j;
  private AdCanvasView k;
  private int l;
  private boolean m;
  private boolean n;
  private boolean o = false;
  
  public GdtVideoCeilingLandView(Context paramContext)
  {
    super(paramContext);
    this.l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public GdtVideoCeilingLandView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  public static boolean a(float paramFloat)
  {
    return paramFloat < 0.0F;
  }
  
  private boolean d()
  {
    boolean bool3 = this.o;
    boolean bool2 = false;
    boolean bool1 = false;
    StringBuilder localStringBuilder;
    if ((!bool3) && (this.j != null))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("noCanvasViewScrollY mWebView.getWebScrollY() -> ");
      localStringBuilder.append(this.j.getWebScrollY());
      GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
      if (Math.abs(this.j.getWebScrollY()) < 1) {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (this.o)
    {
      bool1 = bool2;
      if (this.k != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("noCanvasViewScrollY mNativeView.getPageViewScrollY() -> ");
        localStringBuilder.append(this.k.getPageViewScrollY());
        GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
        bool1 = bool2;
        if (Math.abs(this.k.getPageViewScrollY()) < 1) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void a()
  {
    AdCanvasView localAdCanvasView = this.k;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityResume();
    }
  }
  
  public void b()
  {
    AdCanvasView localAdCanvasView = this.k;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityPause();
    }
  }
  
  public void c()
  {
    AdCanvasView localAdCanvasView = this.k;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityDestroy();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.m) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    boolean bool3 = this.c;
    boolean bool1 = true;
    boolean bool2 = true;
    if (!bool3)
    {
      if (this.i) {
        return true;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInterceptTouchEvent mState ");
      localStringBuilder.append(this.a);
      GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
      int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
      if (i1 != 0)
      {
        if (i1 != 1) {
          if (i1 != 2)
          {
            if (i1 != 3) {
              break label415;
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onInterceptTouchEvent ACTION_MOVE mBeingDrag ");
            localStringBuilder.append(this.i);
            GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
            float f1 = paramMotionEvent.getRawX();
            float f3 = paramMotionEvent.getRawY();
            float f2 = this.f;
            f3 -= this.e;
            if ((Math.abs(f3) <= this.l) || (Math.abs(f3) <= Math.abs(f1 - f2))) {
              break label415;
            }
            i1 = this.a;
            if (i1 == 0)
            {
              this.i = true;
              GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent ACTION_MOVE mState -> BOTTOM_WEBVIEW_STATE ");
              return true;
            }
            if (i1 != 2) {
              break label415;
            }
            if ((!this.i) && ((!d()) || (a(f3))))
            {
              bool1 = false;
            }
            else
            {
              this.i = true;
              bool1 = bool2;
            }
            paramMotionEvent = new StringBuilder();
            paramMotionEvent.append("onInterceptTouchEvent ACTION_MOVE mState -> TOP_WEBVIEW_STATE, result -> ");
            paramMotionEvent.append(bool1);
            paramMotionEvent.append(", noCanvasViewScrollY -> ");
            paramMotionEvent.append(d());
            paramMotionEvent.append(", isScrollUp -> ");
            paramMotionEvent.append(a(f3));
            GdtLog.b("GdtVideoCeilingLandView", paramMotionEvent.toString());
            return bool1;
          }
        }
        GdtLog.b("GdtVideoCeilingLandView", "onInterceptTouchEvent  ACTION_UP");
        this.f = 0.0F;
        this.e = 0.0F;
        this.i = false;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onInterceptTouchEvent ACTION_DOWN mBeingDrag ");
        localStringBuilder.append(this.i);
        GdtLog.b("GdtVideoCeilingLandView", localStringBuilder.toString());
        this.f = paramMotionEvent.getRawX();
        this.e = paramMotionEvent.getRawY();
      }
      label415:
      bool1 = false;
    }
    return bool1;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.n) {
      return super.onTouchEvent(paramMotionEvent);
    }
    if (this.c) {
      return true;
    }
    if ((this.h == 0.0F) || (this.g == 0.0F))
    {
      this.h = paramMotionEvent.getRawX();
      this.g = paramMotionEvent.getRawY();
      GdtVideoCeilingListener localGdtVideoCeilingListener = this.d;
      if (localGdtVideoCeilingListener != null) {
        localGdtVideoCeilingListener.a(this.a);
      }
    }
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if (i1 != 0)
    {
      if (i1 != 1) {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return true;
          }
        }
        else
        {
          GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_MOVE");
          float f1 = paramMotionEvent.getRawX();
          float f2 = paramMotionEvent.getRawY();
          float f3 = f2 - this.g;
          float f4 = this.h;
          if (Math.abs(f3) <= Math.abs(f1 - f4)) {
            break label244;
          }
          if (this.d != null)
          {
            GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  onDrag");
            this.d.b((int)f3);
          }
          this.h = f1;
          this.g = f2;
          return true;
        }
      }
      GdtLog.c("GdtVideoCeilingLandView", "onTouchEvent  ACTION_UP");
      this.h = 0.0F;
      this.g = 0.0F;
      paramMotionEvent = this.d;
      if (paramMotionEvent != null)
      {
        paramMotionEvent.c(this.a);
        this.i = false;
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
    this.d = paramGdtVideoCeilingListener;
    this.j = paramWebView;
    this.o = false;
  }
  
  public void setGdtVideoCeilingNativeListeners(GdtVideoCeilingListener paramGdtVideoCeilingListener, AdCanvasView paramAdCanvasView)
  {
    this.d = paramGdtVideoCeilingListener;
    this.k = paramAdCanvasView;
    this.o = true;
  }
  
  public void setIgnoreInterceptTouchEvent(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setIgnoreTouchEvent(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.videoceiling.GdtVideoCeilingLandView
 * JD-Core Version:    0.7.0.1
 */