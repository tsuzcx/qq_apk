import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class bfwb
  implements View.OnKeyListener
{
  bfwb(bfvz parambfvz, bfwf parambfwf) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.jdField_a_of_type_Bfwf.a.getSelectionStart() == 0))
    {
      this.jdField_a_of_type_Bfvz.a.b(this.jdField_a_of_type_Bfwf);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwb
 * JD-Core Version:    0.7.0.1
 */