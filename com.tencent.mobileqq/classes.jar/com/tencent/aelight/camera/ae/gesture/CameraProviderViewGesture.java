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
  private CameraProviderViewGesture.Listener a;
  protected List<AEAbsBottomPanal> a;
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(AEAbsBottomPanal paramAEAbsBottomPanal)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      this.jdField_a_of_type_JavaUtilList.add(paramAEAbsBottomPanal);
      return;
    }
    if (!localList.contains(paramAEAbsBottomPanal)) {
      this.jdField_a_of_type_JavaUtilList.add(paramAEAbsBottomPanal);
    }
  }
  
  public void a(CameraProviderViewGesture.Listener paramListener)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture$Listener = paramListener;
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
      Object localObject1 = this.jdField_a_of_type_AndroidViewView;
      if (localObject1 == null) {
        localObject1 = GLGestureProxy.getInstance().getGLSurfaceView();
      }
      Object localObject2 = this.jdField_a_of_type_ComTencentAelightCameraAeGestureCameraProviderViewGesture$Listener;
      if (localObject2 != null) {
        ((CameraProviderViewGesture.Listener)localObject2).a();
      }
      localObject2 = this.jdField_a_of_type_JavaUtilList;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          AEAbsBottomPanal localAEAbsBottomPanal = (AEAbsBottomPanal)((Iterator)localObject2).next();
          if ((localObject1 != null) && (localAEAbsBottomPanal != null) && (paramMotionEvent.getY() < ((View)localObject1).getHeight() - localAEAbsBottomPanal.getHeight()) && (!localAEAbsBottomPanal.a())) {
            localAEAbsBottomPanal.d();
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gesture.CameraProviderViewGesture
 * JD-Core Version:    0.7.0.1
 */