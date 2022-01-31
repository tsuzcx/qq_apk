import android.view.View;
import java.lang.ref.WeakReference;

class axsx
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aenl> b;
  WeakReference<baoj> c;
  
  public axsx(axsw paramaxsw, View paramView, aenl paramaenl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaenl);
  }
  
  public aenl a()
  {
    return (aenl)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public baoj a()
  {
    if (this.c == null) {
      return null;
    }
    return (baoj)this.c.get();
  }
  
  public void a(baoj parambaoj)
  {
    this.c = new WeakReference(parambaoj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axsx
 * JD-Core Version:    0.7.0.1
 */