import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class azbk
  implements View.OnKeyListener
{
  azbk(azbi paramazbi, azbo paramazbo) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent.getAction() == 0) && (paramInt == 67) && (this.jdField_a_of_type_Azbo.a.getSelectionStart() == 0))
    {
      this.jdField_a_of_type_Azbi.a.b(this.jdField_a_of_type_Azbo);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azbk
 * JD-Core Version:    0.7.0.1
 */