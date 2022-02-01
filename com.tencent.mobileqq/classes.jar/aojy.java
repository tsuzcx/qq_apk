import android.view.View;
import java.lang.ref.WeakReference;

class aojy
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aojx> b;
  
  public aojy(aoju paramaoju, View paramView, aojx paramaojx)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaojx);
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public aojx a()
  {
    return (aojx)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aojy
 * JD-Core Version:    0.7.0.1
 */