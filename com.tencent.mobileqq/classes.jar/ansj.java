import android.view.View;
import android.view.View.OnClickListener;
import java.lang.ref.WeakReference;

public class ansj
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  String jdField_a_of_type_JavaLangString;
  WeakReference<View.OnClickListener> jdField_a_of_type_JavaLangRefWeakReference;
  int b;
  
  public ansj(View paramView, int paramInt1, String paramString, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramInt2;
    if (paramOnClickListener != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnClickListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ansj
 * JD-Core Version:    0.7.0.1
 */