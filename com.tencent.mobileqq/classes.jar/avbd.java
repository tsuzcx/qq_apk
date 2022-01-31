import android.view.View;
import java.lang.ref.WeakReference;

class avbd
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<aclm> b;
  WeakReference<axqf> c;
  
  public avbd(avbc paramavbc, View paramView, aclm paramaclm)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramaclm);
  }
  
  public aclm a()
  {
    return (aclm)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public axqf a()
  {
    if (this.c == null) {
      return null;
    }
    return (axqf)this.c.get();
  }
  
  public void a(axqf paramaxqf)
  {
    this.c = new WeakReference(paramaxqf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avbd
 * JD-Core Version:    0.7.0.1
 */