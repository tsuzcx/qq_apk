import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class bdft
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bdft(bdfq parambdfq, int paramInt, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Bdfq.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i;
    if (this.jdField_a_of_type_Bdfq.text.getLineCount() > this.jdField_a_of_type_Int)
    {
      i = this.jdField_a_of_type_Bdfq.text.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label134;
      }
    }
    label134:
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      boolean bool1 = baig.a(str);
      boolean bool2 = baig.b(str);
      if ((!bool1) && (!bool2))
      {
        str = this.jdField_a_of_type_Bdfq.text.getText().subSequence(0, i - 3) + "...";
        this.jdField_a_of_type_Bdfq.text.setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdft
 * JD-Core Version:    0.7.0.1
 */