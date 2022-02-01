import android.view.View;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import java.lang.ref.WeakReference;

public class bbxt
{
  int jdField_a_of_type_Int;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  int b;
  public WeakReference<bbxu> b;
  
  public bbxt(ScribbleResMgr paramScribbleResMgr, int paramInt1, int paramInt2, View paramView, bbxu parambbxu)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(parambbxu);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public bbxu a()
  {
    return (bbxu)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxt
 * JD-Core Version:    0.7.0.1
 */