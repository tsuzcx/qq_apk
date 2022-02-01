import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class bffw
  implements View.OnKeyListener
{
  bffw(bffu parambffu, bfga parambfga) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.jdField_a_of_type_Bfga.a.getSelectionStart() == 0))
    {
      this.jdField_a_of_type_Bffu.a.b(this.jdField_a_of_type_Bfga);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bffw
 * JD-Core Version:    0.7.0.1
 */