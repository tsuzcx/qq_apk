package com.tencent.aelight.camera.ae.gesture;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.aelight.camera.ae.camera.ui.panel.AEAbsBottomPanal;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CameraProviderViewGesture
  implements GLGestureListener
{
  protected View a;
  protected List<AEAbsBottomPanal> b;
  private List<CameraProviderViewGesture.TouchDownHandler> c;
  private CameraProviderViewGesture.Listener d;
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public void a(AEAbsBottomPanal paramAEAbsBottomPanal)
  {
    List localList = this.b;
    if (localList == null)
    {
      this.b = new ArrayList();
      this.b.add(paramAEAbsBottomPanal);
      return;
    }
    if (!localList.contains(paramAEAbsBottomPanal)) {
      this.b.add(paramAEAbsBottomPanal);
    }
  }
  
  public void a(CameraProviderViewGesture.Listener paramListener)
  {
    this.d = paramListener;
  }
  
  public void a(CameraProviderViewGesture.TouchDownHandler paramTouchDownHandler)
  {
    if (paramTouchDownHandler == null) {
      return;
    }
    if (this.c == null) {
      this.c = new ArrayList();
    }
    if (!this.c.contains(paramTouchDownHandler)) {
      this.c.add(paramTouchDownHandler);
    }
  }
  
  public int onGetPriority()
  {
    return 1060;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean) && ((j & 0xFF) == 0))
    {
      Object localObject1 = this.a;
      if (localObject1 == null) {
        localObject1 = GLGestureProxy.getInstance().getGLSurfaceView();
      }
      Object localObject2 = this.d;
      if (localObject2 != null) {
        ((CameraProviderViewGesture.Listener)localObject2).a();
      }
      localObject2 = this.b;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          AEAbsBottomPanal localAEAbsBottomPanal = (AEAbsBottomPanal)((Iterator)localObject2).next();
          if ((localObject1 != null) && (localAEAbsBottomPanal != null) && (paramMotionEvent.getY() < ((View)localObject1).getHeight() - localAEAbsBottomPanal.getHeight()) && (!localAEAbsBottomPanal.e())) {
            localAEAbsBottomPanal.h();
          }
        }
      }
      paramMotionEvent = this.c;
      if (paramMotionEvent != null)
      {
        paramMotionEvent = paramMotionEvent.iterator();
        while (paramMotionEvent.hasNext()) {
          ((CameraProviderViewGesture.TouchDownHandler)paramMotionEvent.next()).a();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gesture.CameraProviderViewGesture
 * JD-Core Version:    0.7.0.1
 */