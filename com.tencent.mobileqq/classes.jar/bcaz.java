import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class bcaz
  implements View.OnKeyListener
{
  bcaz(bcax parambcax, bcbd parambcbd) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.jdField_a_of_type_Bcbd.a.getSelectionStart() == 0))
    {
      this.jdField_a_of_type_Bcax.a.b(this.jdField_a_of_type_Bcbd);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcaz
 * JD-Core Version:    0.7.0.1
 */