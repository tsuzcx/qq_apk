import android.view.View;
import java.lang.ref.WeakReference;

class aoga
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aofz> b;
  
  public aoga(aofw paramaofw, View paramView, aofz paramaofz)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaofz);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public aofz a()
  {
    return (aofz)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoga
 * JD-Core Version:    0.7.0.1
 */