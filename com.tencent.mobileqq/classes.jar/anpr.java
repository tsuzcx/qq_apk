import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoSwitchCameraPicMgr;

class anpr
  implements DialogInterface.OnClickListener
{
  anpr(anpq paramanpq) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a.a.getIntent();
    paramDialogInterface.putExtra("flow_back", 0);
    this.a.a.setResult(1001, paramDialogInterface);
    paramDialogInterface = null;
    if (this.a.a.g) {
      paramDialogInterface = this.a.a.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoClipSpec;
    }
    this.a.a.a.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaStateRMVideoSwitchCameraPicMgr.a(this.a.a.d, this.a.a.e, this.a.a.n, this.a.a.g, paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpr
 * JD-Core Version:    0.7.0.1
 */