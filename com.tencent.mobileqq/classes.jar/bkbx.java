import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class bkbx
  implements View.OnClickListener
{
  bkbx(bkbv parambkbv) {}
  
  public void onClick(View paramView)
  {
    this.a.a.setSelectAllOnFocus(false);
    this.a.a.setSelection(this.a.a.length());
    this.a.a.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbx
 * JD-Core Version:    0.7.0.1
 */