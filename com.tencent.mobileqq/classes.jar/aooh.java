import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.richmedia.FlowCameraConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraMqqAction;
import java.io.File;

public class aooh
  implements View.OnClickListener
{
  public aooh(FlowCameraActivity2 paramFlowCameraActivity2, File paramFile) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaFlowCameraActivity2.l();
    if (((!QLog.isColorLevel()) || (!FileUtils.d(this.jdField_a_of_type_JavaIoFile.getAbsolutePath()))) || (FlowCameraConstant.a == 1))
    {
      FlowCameraMqqAction.b("", "0X8005F5B", "0");
      return;
    }
    FlowCameraMqqAction.b("", "0X8005F5B", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aooh
 * JD-Core Version:    0.7.0.1
 */