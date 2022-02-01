import android.view.View;
import java.lang.ref.WeakReference;

class anxm
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<anxl> b;
  
  public anxm(anxi paramanxi, View paramView, anxl paramanxl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramanxl);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public anxl a()
  {
    return (anxl)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxm
 * JD-Core Version:    0.7.0.1
 */