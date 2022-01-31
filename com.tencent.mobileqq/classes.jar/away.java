import android.view.View;
import java.lang.ref.WeakReference;

class away
{
  WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  WeakReference<acwb> b;
  WeakReference<ayqo> c;
  
  public away(awax paramawax, View paramView, acwb paramacwb)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    this.b = new WeakReference(paramacwb);
  }
  
  public acwb a()
  {
    return (acwb)this.b.get();
  }
  
  public View a()
  {
    return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public ayqo a()
  {
    if (this.c == null) {
      return null;
    }
    return (ayqo)this.c.get();
  }
  
  public void a(ayqo paramayqo)
  {
    this.c = new WeakReference(paramayqo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     away
 * JD-Core Version:    0.7.0.1
 */