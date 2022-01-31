import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.AECamera.View.AEProviderContainerView;
import dov.com.qq.im.AECamera.panel.material.AEMaterialPanel;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class auti
  implements GLGestureListener
{
  protected View a;
  private autj a;
  protected ProviderContainerView a;
  protected AEProviderContainerView a;
  protected AEMaterialPanel a;
  protected QIMProviderContainerView a;
  
  public auti() {}
  
  public auti(QIMProviderContainerView paramQIMProviderContainerView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = paramQIMProviderContainerView;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(autj paramautj)
  {
    this.jdField_a_of_type_Autj = paramautj;
  }
  
  public void a(AEProviderContainerView paramAEProviderContainerView)
  {
    this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView = paramAEProviderContainerView;
  }
  
  public void a(AEMaterialPanel paramAEMaterialPanel)
  {
    this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel = paramAEMaterialPanel;
  }
  
  public int onGetPriority()
  {
    return 1060;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean)) {}
    switch (j & 0xFF)
    {
    default: 
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    for (Object localObject = this.jdField_a_of_type_AndroidViewView;; localObject = GLGestureProxy.getInstance().getGLSurfaceView())
    {
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.getHeight())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a();
      }
      if ((localObject != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.getHeight()))
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCloseEventTouch(true);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.c();
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCloseEventTouch(false);
      }
      if ((localObject != null) && (this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.getHeight())) {
        this.jdField_a_of_type_DovComQqImAECameraPanelMaterialAEMaterialPanel.a(true);
      }
      if ((localObject != null) && (this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView.getHeight())) {
        this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView.d();
      }
      if (this.jdField_a_of_type_Autj == null) {
        break;
      }
      this.jdField_a_of_type_Autj.a();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     auti
 * JD-Core Version:    0.7.0.1
 */