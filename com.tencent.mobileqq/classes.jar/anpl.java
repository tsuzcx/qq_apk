import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import java.io.File;
import java.util.ArrayList;

public class anpl
  implements View.OnClickListener
{
  public anpl(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile, Button paramButton) {}
  
  public void onClick(View paramView)
  {
    if (new File(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.b).exists())
    {
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(this.jdField_a_of_type_JavaIoFile)));
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.l();
      paramView = new ArrayList();
      paramView.add(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.b);
      FlowCameraMqqAction.a(this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2, paramView);
      this.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.setResult(1001);
      this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.finish();
      if (FlowCameraConstant.a == 1) {
        FlowCameraMqqAction.b("", "0X8005F5C", "0");
      }
    }
    else
    {
      return;
    }
    FlowCameraMqqAction.b("", "0X8005F5C", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpl
 * JD-Core Version:    0.7.0.1
 */