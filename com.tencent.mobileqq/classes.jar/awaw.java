import android.view.View;
import java.lang.ref.WeakReference;

class awaw
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<acwf> b;
  WeakReference<ayqm> c;
  
  public awaw(awav paramawav, View paramView, acwf paramacwf)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramacwf);
  }
  
  public acwf a()
  {
    return (acwf)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ayqm a()
  {
    if (this.c == null) {
      return null;
    }
    return (ayqm)this.c.get();
  }
  
  public void a(ayqm paramayqm)
  {
    this.c = new WeakReference(paramayqm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awaw
 * JD-Core Version:    0.7.0.1
 */