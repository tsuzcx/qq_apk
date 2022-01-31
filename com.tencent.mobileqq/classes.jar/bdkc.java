import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class bdkc
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bdkc(bdjz parambdjz, int paramInt, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Bdjz.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i;
    if (this.jdField_a_of_type_Bdjz.text.getLineCount() > this.jdField_a_of_type_Int)
    {
      i = this.jdField_a_of_type_Bdjz.text.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label134;
      }
    }
    label134:
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      boolean bool1 = bamp.a(str);
      boolean bool2 = bamp.b(str);
      if ((!bool1) && (!bool2))
      {
        str = this.jdField_a_of_type_Bdjz.text.getText().subSequence(0, i - 3) + "...";
        this.jdField_a_of_type_Bdjz.text.setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdkc
 * JD-Core Version:    0.7.0.1
 */