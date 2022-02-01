import android.view.View;
import java.lang.ref.WeakReference;

class andj
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<andi> b;
  
  public andj(andf paramandf, View paramView, andi paramandi)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramandi);
  }
  
  public andi a()
  {
    return (andi)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     andj
 * JD-Core Version:    0.7.0.1
 */