import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class bcfi
  implements View.OnKeyListener
{
  bcfi(bcfg parambcfg, bcfm parambcfm) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.jdField_a_of_type_Bcfm.a.getSelectionStart() == 0))
    {
      this.jdField_a_of_type_Bcfg.a.b(this.jdField_a_of_type_Bcfm);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcfi
 * JD-Core Version:    0.7.0.1
 */