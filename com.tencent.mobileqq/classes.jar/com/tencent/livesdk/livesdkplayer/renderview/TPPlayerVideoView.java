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
import android.view.ViewGroup.LayoutParams;
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
    Object localObject1 = this.mVideoViewCallBackList;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoViewBase.IVideoViewCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoViewBase.IVideoViewCallback)localObject2).onSurfaceChanged(paramObject);
        }
      }
    }
    localObject1 = this.mVideoSurfaceBackList;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoViewBase.IVideoSurfaceCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoViewBase.IVideoSurfaceCallback)localObject2).onSurfaceChanged(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceCreate(Object paramObject)
  {
    Object localObject1 = this.mVideoViewCallBackList;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoViewBase.IVideoViewCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoViewBase.IVideoViewCallback)localObject2).onSurfaceCreated(paramObject);
        }
      }
    }
    localObject1 = this.mVideoSurfaceBackList;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoViewBase.IVideoSurfaceCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoViewBase.IVideoSurfaceCallback)localObject2).onSurfaceCreated(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceDestroy(Object paramObject)
  {
    Object localObject1 = this.mVideoViewCallBackList;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoViewBase.IVideoViewCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoViewBase.IVideoViewCallback)localObject2).onSurfaceDestroy(paramObject);
        }
      }
    }
    localObject1 = this.mVideoSurfaceBackList;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoViewBase.IVideoSurfaceCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoViewBase.IVideoSurfaceCallback)localObject2).onSurfaceDestroy(paramObject);
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
    if (paramIVideoSurfaceCallback == null) {
      return;
    }
    if (this.mVideoSurfaceBackList == null) {
      this.mVideoSurfaceBackList = new CopyOnWriteArrayList();
    }
    if (!this.mVideoSurfaceBackList.contains(paramIVideoSurfaceCallback)) {
      this.mVideoSurfaceBackList.add(paramIVideoSurfaceCallback);
    }
  }
  
  public void addVideoViewCallback(ITPPlayerVideoViewBase.IVideoViewCallback paramIVideoViewCallback)
  {
    if (paramIVideoViewCallback == null) {
      return;
    }
    if (this.mVideoViewCallBackList == null) {
      this.mVideoViewCallBackList = new CopyOnWriteArrayList();
    }
    if (!this.mVideoViewCallBackList.contains(paramIVideoViewCallback)) {
      this.mVideoViewCallBackList.add(paramIVideoViewCallback);
    }
  }
  
  public View getCurrentDisplayView()
  {
    return (View)this.mDisplayView;
  }
  
  public Rect getDisplayViewRect()
  {
    Rect localRect = new Rect();
    ITPViewBase localITPViewBase = this.mDisplayView;
    if ((localITPViewBase != null) && ((localITPViewBase instanceof View))) {
      ((View)localITPViewBase).getGlobalVisibleRect(localRect);
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
    return this.viewIsReady;
  }
  
  public void readyRender()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("readyRender, , NO: ");
    ((StringBuilder)localObject).append(this.serialNO);
    ((StringBuilder)localObject).append(", w: ");
    ((StringBuilder)localObject).append(((View)this.mDisplayView).getWidth());
    ((StringBuilder)localObject).append(", h: ");
    ((StringBuilder)localObject).append(((View)this.mDisplayView).getHeight());
    ((StringBuilder)localObject).append(", pw: ");
    ((StringBuilder)localObject).append(getWidth());
    ((StringBuilder)localObject).append(", ph: ");
    ((StringBuilder)localObject).append(getHeight());
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", ((StringBuilder)localObject).toString());
    this.haveUsedView = true;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (this.resetDeleteView)
      {
        this.lastDisplayView = null;
      }
      else
      {
        localObject = this.lastDisplayView;
        if (localObject != null) {
          removeView((View)localObject);
        }
        this.lastDisplayView = null;
      }
      this.mDisplayView.setOpaqueInfo(true);
      ((View)this.mDisplayView).requestFocus();
    }
    else
    {
      TPThreadUtil.postRunnableOnMainThreadFront(new TPPlayerVideoView.2(this));
    }
    this.mDisplayView.setRadio(0, 0);
  }
  
  public void release()
  {
    removeAllViews();
    this.context = null;
  }
  
  public void removeSurfaceCallback(ITPPlayerVideoViewBase.IVideoSurfaceCallback paramIVideoSurfaceCallback)
  {
    List localList = this.mVideoSurfaceBackList;
    if ((localList != null) && (paramIVideoSurfaceCallback != null)) {
      localList.remove(paramIVideoSurfaceCallback);
    }
  }
  
  public void removeVideoViewCallback(ITPPlayerVideoViewBase.IVideoViewCallback paramIVideoViewCallback)
  {
    List localList = this.mVideoViewCallBackList;
    if ((localList != null) && (paramIVideoViewCallback != null)) {
      localList.remove(paramIVideoViewCallback);
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
    if ((this.viewIsReady) && (this.haveUsedView) && (paramBoolean))
    {
      localObject = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.viewIsReady = false;
      this.surfaceOrHolder = null;
      this.mDisplayView.setViewCallBack(null);
      ITPViewBase localITPViewBase1 = TPViewFactory.createPlayView(this.context, this.isSupportTextureView, this.isZOrderOnTop, this.isZOderMediaOverlay);
      localITPViewBase1.setViewCallBack(this.mViewCallBack);
      View localView = (View)localITPViewBase1;
      localView.setVisibility(0);
      localITPViewBase1.setOpaqueInfo(true);
      localITPViewBase1.setXYAxis(this.type);
      this.mDisplayView.setOpaqueInfo(false);
      if (this.resetDeleteView)
      {
        removeView((View)this.mDisplayView);
        this.lastDisplayView = null;
      }
      else
      {
        ITPViewBase localITPViewBase2 = this.lastDisplayView;
        if (localITPViewBase2 != null) {
          removeView((View)localITPViewBase2);
        }
        this.lastDisplayView = this.mDisplayView;
      }
      addView(localView, (ViewGroup.LayoutParams)localObject);
      this.mDisplayView = localITPViewBase1;
    }
    if (paramBoolean)
    {
      this.haveUsedView = false;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("resetView , NO: ");
      ((StringBuilder)localObject).append(this.serialNO);
      TPLogUtil.i("TPPlayer[TPPlayerVideoView]", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.subView;
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViews();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setFixedSize, vW: ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", vH: ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(", NO: ");
    localStringBuilder.append(this.serialNO);
    TPLogUtil.i("TPPlayer[TPPlayerVideoView]", localStringBuilder.toString());
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
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
  }
  
  public void setMidLayout(View paramView)
  {
    if (paramView != null)
    {
      if ((paramView instanceof ViewStub))
      {
        this.subView = ((ViewGroup)((ViewStub)paramView).inflate());
        return;
      }
      if ((paramView instanceof ViewGroup)) {
        this.subView = ((ViewGroup)paramView);
      }
    }
  }
  
  public void setRadio(int paramInt1, int paramInt2)
  {
    ITPViewBase localITPViewBase = this.mDisplayView;
    if (localITPViewBase != null) {
      localITPViewBase.setRadio(paramInt1, paramInt2);
    }
  }
  
  public void setRenderGravity(int paramInt)
  {
    Object localObject = this.mDisplayView;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
      setLayoutParams((ViewGroup.LayoutParams)localObject);
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