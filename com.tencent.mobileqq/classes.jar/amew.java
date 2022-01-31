import android.view.View;
import java.lang.ref.WeakReference;

class amew
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<amev> b;
  
  public amew(ames paramames, View paramView, amev paramamev)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramamev);
  }
  
  public amev a()
  {
    return (amev)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amew
 * JD-Core Version:    0.7.0.1
 */