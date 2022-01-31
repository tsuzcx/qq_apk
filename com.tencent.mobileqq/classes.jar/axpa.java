import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class axpa
  implements GLGestureListener
{
  protected View a;
  private axpb a;
  protected ProviderContainerView a;
  protected AEMaterialPanel a;
  protected AEProviderContainerView a;
  protected QIMProviderContainerView a;
  
  public axpa() {}
  
  public axpa(QIMProviderContainerView paramQIMProviderContainerView)
  {
    this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView = paramQIMProviderContainerView;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(axpb paramaxpb)
  {
    this.jdField_a_of_type_Axpb = paramaxpb;
  }
  
  public void a(AEMaterialPanel paramAEMaterialPanel)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel = paramAEMaterialPanel;
  }
  
  public void a(AEProviderContainerView paramAEProviderContainerView)
  {
    this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView = paramAEProviderContainerView;
  }
  
  public int onGetPriority()
  {
    return 1060;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int j = paramMotionEvent.getPointerCount();
    int k = paramMotionEvent.getAction() & 0xFF;
    Object localObject = new StringBuilder().append("action: ").append(k).append(" event Y: ").append(paramMotionEvent.getY()).append(" container view height: ");
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight())
    {
      bljn.a("CameraProviderViewGesture", i);
      if ((j == 1) && (!paramBoolean)) {}
      switch (k)
      {
      default: 
        return false;
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {}
    for (localObject = this.jdField_a_of_type_AndroidViewView;; localObject = GLGestureProxy.getInstance().getGLSurfaceView())
    {
      if (this.jdField_a_of_type_Axpb != null) {
        this.jdField_a_of_type_Axpb.a();
      }
      if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.getHeight())) {
        this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView.a();
      }
      if ((localObject != null) && (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.getHeight()))
      {
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCloseEventTouch(true);
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.c();
        this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setCloseEventTouch(false);
      }
      if ((localObject != null) && (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel != null) && (paramMotionEvent.getY() < ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.getHeight()))
      {
        bljn.a("CameraProviderViewGesture", "in hide close panel.");
        this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEMaterialPanel.a(true);
      }
      if ((localObject == null) || (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView == null) || (paramMotionEvent.getY() >= ((View)localObject).getHeight() - this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.getHeight())) {
        break;
      }
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.d();
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axpa
 * JD-Core Version:    0.7.0.1
 */