package com.tencent.TMG.opengl.ui;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.TMG.opengl.GraphicRendererMgr;
import com.tencent.TMG.utils.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class VideoViewLayer
  extends GLViewGroup
{
  static final String TAG = "VideoLayerUI";
  int mCacheRotation = 0;
  Context mContext = null;
  GLRootView mGlRootView = null;
  List<GLVideoView> mGlVideoViewBusyList = new LinkedList();
  List<GLVideoView> mGlVideoViewFreeList = new LinkedList();
  ViewGroup mRootView = null;
  int mRotation = 0;
  
  public VideoViewLayer(Context paramContext, ViewGroup paramViewGroup)
  {
    this.mContext = paramContext;
    this.mRootView = paramViewGroup;
    initQQGlView();
  }
  
  public GLVideoView addVideo(String paramString, int paramInt1, int paramInt2)
  {
    if (this.mContext == null) {}
    do
    {
      return null;
      Log.e("VideoLayerUI", "addVideo|identifier = " + paramString + ", videoSrcType = " + paramInt1);
      int i = getViewIndexById(paramString, paramInt1);
      if (i >= 0) {
        return (GLVideoView)this.mGlVideoViewBusyList.get(i);
      }
    } while (this.mGlVideoViewFreeList.isEmpty());
    GLVideoView localGLVideoView = (GLVideoView)this.mGlVideoViewFreeList.get(0);
    this.mGlVideoViewFreeList.remove(0);
    localGLVideoView.setRender(paramString, paramInt1);
    localGLVideoView.setMirror(false);
    localGLVideoView.enableLoading(true);
    localGLVideoView.setZOrder(paramInt2);
    this.mGlVideoViewBusyList.add(localGLVideoView);
    addView(localGLVideoView);
    layoutVideoView();
    return localGLVideoView;
  }
  
  public GLVideoView getVideoView(String paramString, int paramInt)
  {
    paramInt = getViewIndexById(paramString, paramInt);
    if (paramInt >= 0) {
      return (GLVideoView)this.mGlVideoViewBusyList.get(paramInt);
    }
    return null;
  }
  
  int getViewCount()
  {
    return this.mGlVideoViewBusyList.size();
  }
  
  public int getViewIndexById(String paramString, int paramInt)
  {
    if (paramString == null) {
      return -1;
    }
    int i = 0;
    if (i < this.mGlVideoViewBusyList.size())
    {
      GLVideoView localGLVideoView = (GLVideoView)this.mGlVideoViewBusyList.get(i);
      if ((!paramString.equals(localGLVideoView.getIdentifier())) || (localGLVideoView.getVideoSrcType() != paramInt)) {}
    }
    for (;;)
    {
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  void initQQGlView()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 0, "initQQGlView");
    }
    this.mGlRootView = new GLRootView(this.mRootView.getContext());
    Object localObject = new ViewGroup.LayoutParams(-1, -1);
    this.mRootView.addView(this.mGlRootView, (ViewGroup.LayoutParams)localObject);
    while (i < 13)
    {
      localObject = new GLVideoView(this.mContext.getApplicationContext(), GraphicRendererMgr.getInstance());
      this.mGlVideoViewFreeList.add(localObject);
      i += 1;
    }
    this.mGlRootView.setContentPane(this);
  }
  
  protected void layoutVideoView()
  {
    if (this.mContext == null) {
      return;
    }
    if (this.mGlVideoViewBusyList.isEmpty())
    {
      invalidate();
      return;
    }
    int k = getWidth();
    int i = getHeight();
    Log.d("VideoLayerUI", "width: " + getWidth() + "height: " + getHeight());
    int j = (int)Math.ceil(Math.sqrt(this.mGlVideoViewBusyList.size()));
    k = (k - (j - 1) * 5) / j;
    int m = (i - (j - 1) * 5) / j;
    i = 0;
    while (i < this.mGlVideoViewBusyList.size())
    {
      int n = (k + 5) * (i % j);
      int i1 = (m + 5) * (i / j);
      ((GLVideoView)this.mGlVideoViewBusyList.get(i)).layout(n, i1, n + k, i1 + m);
      i += 1;
    }
    invalidate();
  }
  
  public void onDestroy()
  {
    Log.e("memoryLeak", "memoryLeak AVUIControl onDestroy");
    this.mRootView.removeView(this.mGlRootView);
    this.mContext = null;
    this.mRootView = null;
    removeAllView();
    Iterator localIterator = this.mGlVideoViewBusyList.iterator();
    while (localIterator.hasNext())
    {
      GLVideoView localGLVideoView = (GLVideoView)localIterator.next();
      localGLVideoView.flush();
      localGLVideoView.clearRender();
    }
    this.mGlVideoViewBusyList.clear();
    this.mGlVideoViewFreeList.clear();
    this.mGlRootView.setOnTouchListener(null);
    this.mGlRootView.setContentPane(null);
    this.mGlRootView = null;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoLayerUI", 0, "onLayout|left: " + paramInt1 + ", top: " + paramInt2 + ", right: " + paramInt3 + ", bottom: " + paramInt4);
    }
    layoutVideoView();
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    setRotation(this.mCacheRotation);
  }
  
  public void removeVideo(String paramString, int paramInt)
  {
    Log.e("VideoLayerUI", "addVideo|identifier = " + paramString + ", videoSrcType = " + paramInt);
    paramInt = getViewIndexById(paramString, paramInt);
    if (paramInt >= 0)
    {
      paramString = (GLVideoView)this.mGlVideoViewBusyList.get(paramInt);
      this.mGlVideoViewBusyList.remove(paramInt);
      paramString.enableLoading(false);
      paramString.flush();
      paramString.clearRender();
      removeView(paramString);
      this.mGlVideoViewFreeList.add(paramString);
      layoutVideoView();
    }
  }
  
  public void setMirror(boolean paramBoolean, String paramString)
  {
    int i = getViewIndexById(paramString, 1);
    if (i >= 0) {
      ((GLVideoView)this.mGlVideoViewBusyList.get(i)).setMirror(paramBoolean);
    }
  }
  
  public void setRotation(int paramInt)
  {
    if (this.mContext == null) {}
    for (;;)
    {
      return;
      this.mRotation = paramInt;
      this.mCacheRotation = paramInt;
      int i = 0;
      while (i < getChildCount())
      {
        try
        {
          GLView localGLView = getChild(i);
          if (localGLView != null) {
            localGLView.setRotation(paramInt);
          }
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          label43:
          break label43;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.TMG.opengl.ui.VideoViewLayer
 * JD-Core Version:    0.7.0.1
 */