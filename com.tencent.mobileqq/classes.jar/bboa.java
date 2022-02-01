import android.view.View;
import java.lang.ref.WeakReference;

class bboa
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<agif> b;
  WeakReference<bete> c;
  
  public bboa(bbnz parambbnz, View paramView, agif paramagif)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramagif);
  }
  
  public agif a()
  {
    return (agif)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public bete a()
  {
    if (this.c == null) {
      return null;
    }
    return (bete)this.c.get();
  }
  
  public void a(bete parambete)
  {
    this.c = new WeakReference(parambete);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bboa
 * JD-Core Version:    0.7.0.1
 */