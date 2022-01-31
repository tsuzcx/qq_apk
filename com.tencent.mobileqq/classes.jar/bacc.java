import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class bacc
  implements View.OnKeyListener
{
  bacc(baca parambaca, bacg parambacg) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.jdField_a_of_type_Bacg.a.getSelectionStart() == 0))
    {
      this.jdField_a_of_type_Baca.a.b(this.jdField_a_of_type_Bacg);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bacc
 * JD-Core Version:    0.7.0.1
 */