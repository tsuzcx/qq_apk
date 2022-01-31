import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.datareportviewer.DataReportViewer;

public class apcs
  implements CompoundButton.OnCheckedChangeListener
{
  public apcs(DataReportViewer paramDataReportViewer) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.a = paramBoolean;
    if (this.a.a) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apcs
 * JD-Core Version:    0.7.0.1
 */