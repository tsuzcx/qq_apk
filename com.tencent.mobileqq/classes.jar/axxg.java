import android.view.View;
import java.lang.ref.WeakReference;

class axxg
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aesa> b;
  WeakReference<bass> c;
  
  public axxg(axxf paramaxxf, View paramView, aesa paramaesa)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaesa);
  }
  
  public aesa a()
  {
    return (aesa)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public bass a()
  {
    if (this.c == null) {
      return null;
    }
    return (bass)this.c.get();
  }
  
  public void a(bass parambass)
  {
    this.c = new WeakReference(parambass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axxg
 * JD-Core Version:    0.7.0.1
 */