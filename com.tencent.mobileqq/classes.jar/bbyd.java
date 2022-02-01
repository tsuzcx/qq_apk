import android.view.View;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import java.lang.ref.WeakReference;

public class bbyd
{
  int jdField_a_of_type_Int;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  int b;
  public WeakReference<bbye> b;
  
  public bbyd(ScribbleResMgr paramScribbleResMgr, int paramInt1, int paramInt2, View paramView, bbye parambbye)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parambbye);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public bbye a()
  {
    return (bbye)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyd
 * JD-Core Version:    0.7.0.1
 */