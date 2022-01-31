import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class ayxs
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ayxs(ayxq paramayxq, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    ayxq.a(this.jdField_a_of_type_Ayxq).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    ayxq.b(this.jdField_a_of_type_Ayxq).setVisibility(4);
    ayxq.a(this.jdField_a_of_type_Ayxq, this.jdField_a_of_type_Boolean, ayxq.a(this.jdField_a_of_type_Ayxq), ayxq.c(this.jdField_a_of_type_Ayxq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayxs
 * JD-Core Version:    0.7.0.1
 */