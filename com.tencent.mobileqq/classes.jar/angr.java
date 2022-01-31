import android.text.Editable;
import android.widget.EditText;
import cooperation.qzone.share.QZoneShareActivity;

public class angr
  implements Runnable
{
  public angr(QZoneShareActivity paramQZoneShareActivity) {}
  
  public void run()
  {
    Editable localEditable;
    if (this.a.a != null)
    {
      localEditable = this.a.a.getText();
      if (localEditable == null) {
        break label71;
      }
    }
    label71:
    for (int i = localEditable.length();; i = 0)
    {
      this.a.a.setSelection(i);
      if ((!this.a.isFinishing()) && (!this.a.d)) {
        this.a.h();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     angr
 * JD-Core Version:    0.7.0.1
 */