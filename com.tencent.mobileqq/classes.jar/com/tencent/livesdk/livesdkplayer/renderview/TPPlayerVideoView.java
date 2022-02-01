package com.tencent.livesdk.livesdkplayer.renderview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.thumbplayer.utils.TPLogUtil;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressLint({"ObsoleteSdkInt"})
public class TPPlayerVideoView
  extends FrameLayout
  implements ITPPlayerVideoViewBase
{
  private static final String TAG = "TPPlayer[TPPlayerVideoView]";
  private Context context;
  private boolean haveUsedView = false;
  private int height = 0;
  private boolean isSupportTextureView = false;
  private boolean isZOderMediaOverlay = false;
  private boolean isZOrderOnTop = false;
  private ITPViewBase lastDisplayView = null;
  private ITPViewBase mDisplayView;
  private List<ITPPlayerVideoViewBase.IVideoSurfaceCallback> mVideoSurfaceBackList;
  private List<ITPPlayerVideoViewBase.IVideoViewCallback> mVideoViewCallBackList;
  private ITPViewBase.ViewCreateCallBack mViewCallBack = new TPPlayerVideoView.1(this);
  private boolean resetDeleteView = false;
  private int serialNO = 0;
  private ViewGroup subView = null;
  private Object surfaceOrHolder;
  private int type = 0;
  private boolean viewIsReady = false;
  private int width = 0;
  
  public TPPlayerVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.mVideoViewCallBackList = new ArrayList();
    this.serialNO = new Random().nextInt();
    initViewAfterV4();
  }
  
  public TPPlayerVideoView(@NonNull Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.context = paramContext;
    this.mVideoViewCallBackList = new ArrayList();
    this.isSupportTextureView = paramBoolean;
    this.serialNO = new Random().nextInt();
    initViewAfterV4();
  }
  
  public TPPlayerVideoView(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext);
    this.context = paramContext;
    this.isSupportTextureView = paramBoolean1;
    this.isZOrderOnTop = paramBoolean2;
    this.isZOderMediaOverlay = paramBoolean3;
    this.serialNO = new Random().nextInt();
    initViewAfterV4();
  }
  
  private void callOnSurfaceChanged(Object paramObject)
  {
    Iterator localIterator;
    Object localObject;
    if (this.mVideoViewCallBackList != null)
    {
      localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ITPPlayerVideoViewBase.IVideoViewCallback)localIterator.next();
        if (localObject != null) {
          ((ITPPlayerVideoViewBase.IVideoViewCallback)localObject).onSurfaceChanged(paramObject);
        }
      }
    }
    if (this.mVideoSurfaceBackList != null)
    {
      localIterator = this.mVideoSurfaceBackList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ITPPlayerVideoViewBase.IVideoSurfaceCallback)localIterator.next();
        if (localObject != null) {
          ((ITPPlayerVideoViewBase.IVideoSurfaceCallback)localObject).onSurfaceChanged(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceCreate(Object paramObject)
  {
    Iterator localIterator;
    Object localObject;
    if (this.mVideoViewCallBackList != null)
    {
      localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ITPPlayerVideoViewBase.IVideoViewCallback)localIterator.next();
        if (localObject != null) {
          ((ITPPlayerVideoViewBase.IVideoViewCallback)localObject).onSurfaceCreated(paramObject);
        }
      }
    }
    if (this.mVideoSurfaceBackList != null)
    {
      localIterator = this.mVideoSurfaceBackList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ITPPlayerVideoViewBase.IVideoSurfaceCallback)localIterator.next();
        if (localObject != null) {
          ((ITPPlayerVideoViewBase.IVideoSurfaceCallback)localObject).onSurfaceCreated(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceDestroy(Object paramObject)
  {
    Iterator localIterator;
    Object localObject;
    if (this.mVideoViewCallBackList != null)
    {
      localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ITPPlayerVideoViewBase.IVideoViewCallback)localIterator.next();
        if (localObject != null) {
          ((ITPPlayerVideoViewBase.IVideoViewCallback)localObject).onSurfaceDestroy(paramObject);
        }
      }
    }
    if (this.mVideoSurfaceBackList != null)
    {
      localIterator = this.mVideoSurfaceBackList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (ITPPlayerVideoViewBase.IVideoSurfaceCallback)localIterator.next();
        if (localObject != null) {
          ((ITPPlayerVideoViewBase.IVideoSurfaceCallback)localObject).onSurfaceDestroy(paramObject);
        }
      }
    }
  }
  
  private void initViewAfterV4()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 48;
    this.mDisplayView = TPViewFactory.createPlayView(this.context, this.isSupportTextureView, this.isZOrderOnTop, this.isZOderMediaOverlay);
    this.mDisplayView.setViewCallBack(this.mViewCallBack);
    addView((View)this.mDisplayView, localLayoutParams);
  }
  
  public void addSurfaceCallback(ITPPlayerVideoViewBase.IVideoSurfaceCallback paramIVideoSurfaceCallback)
  {
    if (paramIVideoSurfaceCallback == null) {}
    do
    {
      return;
      if (this.mVideoSurfaceBackList == null) {
        this.mVideoSurfaceBackList = new CopyOnWriteArrayList();
      }
    } while (this.mVideoSurfaceBackList.contains(paramIVideoSurfaceCallback));
    this.mVideoSurfaceBackList.add(paramIVideoSurfaceCallback);
  }
  
  public void addVideoViewCallback(ITPPlayerVideoViewBase.IVideoViewCallback paramIVideoViewCallback)
  {
    if (paramIVideoViewCallback == null) {}
    do
    {
      return;
      if (this.mVideoViewCallBackList == null) {
        this.mVideoViewCallBackList = new CopyOnWriteArrayList();
      }
    } while (this.mVideoViewCallBackList.contains(paramIVideoViewCallback));
    this.mVideoViewCallBackList.add(paramIVideoViewCallback);
  }
  
  public View getCurrentDisplayView()
  {
    return (View)this.mDisplayView;
  }
  
  public Rect getDisplayViewRect()
  {
    Rect localRect = new Rect();
    if ((this.mDisplayView != null) && ((this.mDisplayView instanceof View))) {
      ((View)this.mDisplayView).getGlobalVisibleRect(localRect);
    }
    return localRect;
  }
  
  public ViewGroup getMidLayout()
  {
    return this.subView;
  }
  
  public Object getRenderObject()
  {
    if (this.viewIsReady) {
      return this.surfaceOrHolder;
    }
    return null;
  }
  
  public String getSerialNO()
  {
    return String.valueOf(this.serialNO);
  }
  
  public int getViewRenderMode()
  {
    return this.type;
  }
  
  public Surface getViewSurface()
  {
    try
    {
      readyRender();
      Object localObject = getRenderObject();
      if ((localObject instanceof SurfaceHolder)) {
        return ((SurfaceHolder)localObject).getSurface();
      }
      if (((localObject instanceof SurfaceTexture)) && (Build.VERSION.SDK_INT > 14)) {
        return new Surface((SurfaceTexture)localObject);
      }
      if ((localObject instanceof Surface))
      {
        localObject = (Surface)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPPlayer[TPPlayerVideoView]", localException);
    }
    return null;
  }
  
  public boolean isSurfaceReady()
  {
    boolean bool = false;
    if (this.viewIsReady) {
      bool = true;
    }
    return bool;
  }
  
  public void readyRender()
  {
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", "readyRender, , NO: " + this.serialNO + ", w: " + ((View)this.mDisplayView).getWidth() + ", h: " + ((View)this.mDisplayView).getHeight() + ", pw: " + getWidth() + ", ph: " + getHeight());
    this.haveUsedView = true;
    if (Looper.myLooper() == Looper.getMainLooper()) {
      if (this.resetDeleteView)
      {
        this.lastDisplayView = null;
        this.mDisplayView.setOpaqueInfo(true);
        ((View)this.mDisplayView).requestFocus();
      }
    }
    for (;;)
    {
      this.mDisplayView.setRadio(0, 0);
      return;
      if (this.lastDisplayView != null) {
        removeView((View)this.lastDisplayView);
      }
      this.lastDisplayView = null;
      break;
      TPThreadUtil.postRunnableOnMainThreadFront(new TPPlayerVideoView.2(this));
    }
  }
  
  public void release()
  {
    removeAllViews();
    this.context = null;
  }
  
  public void removeSurfaceCallback(ITPPlayerVideoViewBase.IVideoSurfaceCallback paramIVideoSurfaceCallback)
  {
    if ((this.mVideoSurfaceBackList != null) && (paramIVideoSurfaceCallback != null)) {
      this.mVideoSurfaceBackList.remove(paramIVideoSurfaceCallback);
    }
  }
  
  public void removeVideoViewCallback(ITPPlayerVideoViewBase.IVideoViewCallback paramIVideoViewCallback)
  {
    if ((this.mVideoViewCallBackList != null) && (paramIVideoViewCallback != null)) {
      this.mVideoViewCallBackList.remove(paramIVideoViewCallback);
    }
  }
  
  public void requestRenderLayout()
  {
    TPThreadUtil.postRunnableOnMainThread(new TPPlayerVideoView.4(this));
  }
  
  public void resetView(boolean paramBoolean)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      TPThreadUtil.postRunnableOnMainThreadFront(new TPPlayerVideoView.6(this, paramBoolean));
      return;
    }
    FrameLayout.LayoutParams localLayoutParams;
    ITPViewBase localITPViewBase;
    if ((this.viewIsReady) && (this.haveUsedView) && (paramBoolean))
    {
      localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 17;
      this.viewIsReady = false;
      this.surfaceOrHolder = null;
      this.mDisplayView.setViewCallBack(null);
      localITPViewBase = TPViewFactory.createPlayView(this.context, this.isSupportTextureView, this.isZOrderOnTop, this.isZOderMediaOverlay);
      localITPViewBase.setViewCallBack(this.mViewCallBack);
      ((View)localITPViewBase).setVisibility(0);
      localITPViewBase.setOpaqueInfo(true);
      localITPViewBase.setXYAxis(this.type);
      this.mDisplayView.setOpaqueInfo(false);
      if (!this.resetDeleteView) {
        break label230;
      }
      removeView((View)this.mDisplayView);
    }
    for (this.lastDisplayView = null;; this.lastDisplayView = this.mDisplayView)
    {
      addView((View)localITPViewBase, localLayoutParams);
      this.mDisplayView = localITPViewBase;
      if (paramBoolean)
      {
        this.haveUsedView = false;
        TPLogUtil.i("TPPlayer[TPPlayerVideoView]", "resetView , NO: " + this.serialNO);
      }
      if (this.subView == null) {
        break;
      }
      this.subView.removeAllViews();
      return;
      label230:
      if (this.lastDisplayView != null) {
        removeView((View)this.lastDisplayView);
      }
    }
  }
  
  public boolean setDegree(int paramInt)
  {
    boolean bool = this.mDisplayView.setDegree(paramInt);
    TPThreadUtil.postRunnableOnMainThread(new TPPlayerVideoView.7(this));
    return bool;
  }
  
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", "setFixedSize, vW: " + paramInt1 + ", vH: " + paramInt2 + ", NO: " + this.serialNO);
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    this.mDisplayView.setVideoWidthAndHeight(paramInt1, paramInt2);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ((View)this.mDisplayView).requestLayout();
      return;
    }
    TPThreadUtil.postRunnableOnMainThread(new TPPlayerVideoView.3(this));
  }
  
  public void setMidLayout(View paramView)
  {
    if (paramView != null)
    {
      if (!(paramView instanceof ViewStub)) {
        break label26;
      }
      this.subView = ((ViewGroup)((ViewStub)paramView).inflate());
    }
    label26:
    while (!(paramView instanceof ViewGroup)) {
      return;
    }
    this.subView = ((ViewGroup)paramView);
  }
  
  public void setRadio(int paramInt1, int paramInt2)
  {
    if (this.mDisplayView != null) {
      this.mDisplayView.setRadio(paramInt1, paramInt2);
    }
  }
  
  public void setRenderGravity(int paramInt)
  {
    if (this.mDisplayView != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((View)this.mDisplayView).getLayoutParams();
      localLayoutParams.gravity = paramInt;
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void setScaleParam(float paramFloat)
  {
    this.mDisplayView.setScaleParam(paramFloat);
  }
  
  public void setXYAxis(int paramInt)
  {
    try
    {
      this.mDisplayView.setXYAxis(paramInt);
      this.type = paramInt;
      TPThreadUtil.postRunnableOnMainThread(new TPPlayerVideoView.5(this));
      return;
    }
    catch (Exception localException)
    {
      TPLogUtil.e("TPPlayer[TPPlayerVideoView]", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.renderview.TPPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */