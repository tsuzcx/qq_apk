import android.view.View;
import com.tencent.mobileqq.scribble.ScribbleResMgr;
import java.lang.ref.WeakReference;

public class aycj
{
  int jdField_a_of_type_Int;
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  int b;
  public WeakReference<ayck> b;
  
  public aycj(ScribbleResMgr paramScribbleResMgr, int paramInt1, int paramInt2, View paramView, ayck paramayck)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramayck);
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ayck a()
  {
    return (ayck)this.jdField_b_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycj
 * JD-Core Version:    0.7.0.1
 */