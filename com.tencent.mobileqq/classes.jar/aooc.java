import android.view.View;
import android.widget.Button;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

public class aooc
  implements Runnable
{
  public aooc(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void run()
  {
    if ((this.a.b != null) && (!this.a.b.isEnabled()))
    {
      this.a.b.setEnabled(true);
      this.a.b.setText(2131438182);
      this.a.b.setTextColor(-15550475);
    }
    int i = 0;
    if (this.a.a != null) {
      i = this.a.a.c();
    }
    if ((!this.a.i.isEnabled()) && (i > 0)) {
      this.a.i.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aooc
 * JD-Core Version:    0.7.0.1
 */