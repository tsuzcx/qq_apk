import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class bgby
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  bgby(bgbw parambgbw, boolean paramBoolean) {}
  
  public void onGlobalLayout()
  {
    bgbw.a(this.jdField_a_of_type_Bgbw).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    bgbw.b(this.jdField_a_of_type_Bgbw).setVisibility(4);
    bgbw.a(this.jdField_a_of_type_Bgbw, this.jdField_a_of_type_Boolean, bgbw.a(this.jdField_a_of_type_Bgbw), bgbw.c(this.jdField_a_of_type_Bgbw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgby
 * JD-Core Version:    0.7.0.1
 */