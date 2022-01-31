import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.widget.ConfigClearableEditText;

public class bbhd
  implements View.OnTouchListener
{
  public bbhd(ConfigClearableEditText paramConfigClearableEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a;
    int i;
    if (paramMotionEvent.getX() > ConfigClearableEditText.a(this.a))
    {
      i = 1;
      if (ConfigClearableEditText.a(this.a) != null)
      {
        if ((i == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) {
          break label102;
        }
        ConfigClearableEditText.a(this.a).b(true);
      }
      label66:
      if ((paramView.getCompoundDrawables()[2] != null) || ((ConfigClearableEditText.a(this.a)) && (ConfigClearableEditText.a(this.a) != null))) {
        break label118;
      }
    }
    label102:
    label118:
    do
    {
      do
      {
        return false;
        i = 0;
        break;
        ConfigClearableEditText.a(this.a).b(false);
        break label66;
      } while ((paramMotionEvent.getAction() != 1) || (i == 0));
      this.a.setText("");
      this.a.setClearButtonVisible(false);
    } while (this.a.a == null);
    this.a.a.a();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbhd
 * JD-Core Version:    0.7.0.1
 */