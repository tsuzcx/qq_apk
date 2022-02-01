import android.view.View;
import java.lang.ref.WeakReference;

class bavh
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<afyl> b;
  WeakReference<bduk> c;
  
  public bavh(bavg parambavg, View paramView, afyl paramafyl)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramafyl);
  }
  
  public afyl a()
  {
    return (afyl)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public bduk a()
  {
    if (this.c == null) {
      return null;
    }
    return (bduk)this.c.get();
  }
  
  public void a(bduk parambduk)
  {
    this.c = new WeakReference(parambduk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bavh
 * JD-Core Version:    0.7.0.1
 */