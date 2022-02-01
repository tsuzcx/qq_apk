import android.text.Layout;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;

class bgpd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bgpd(bgpa parambgpa, int paramInt, String paramString) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_Bgpa.text.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i;
    if (this.jdField_a_of_type_Bgpa.text.getLineCount() > this.jdField_a_of_type_Int)
    {
      i = this.jdField_a_of_type_Bgpa.text.getLayout().getLineEnd(this.jdField_a_of_type_Int - 1);
      if (this.jdField_a_of_type_JavaLangString != null) {
        break label134;
      }
    }
    label134:
    for (String str = "";; str = this.jdField_a_of_type_JavaLangString)
    {
      boolean bool1 = bdnt.a(str);
      boolean bool2 = bdnt.b(str);
      if ((!bool1) && (!bool2))
      {
        str = this.jdField_a_of_type_Bgpa.text.getText().subSequence(0, i - 3) + "...";
        this.jdField_a_of_type_Bgpa.text.setText(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpd
 * JD-Core Version:    0.7.0.1
 */