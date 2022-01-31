import android.view.View;
import android.widget.FrameLayout;

public class bbov
{
  private static long jdField_a_of_type_Long = 400L;
  private static boolean jdField_a_of_type_Boolean;
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(FrameLayout paramFrameLayout)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    paramFrameLayout.invalidate();
    View localView = paramFrameLayout.getChildAt(1);
    paramFrameLayout = paramFrameLayout.getChildAt(0);
    bbho localbbho = new bbho(localView);
    localbbho.setDuration(jdField_a_of_type_Long);
    localbbho.setFillAfter(true);
    bbhp localbbhp = new bbhp(paramFrameLayout);
    localbbhp.setDuration(jdField_a_of_type_Long);
    localbbhp.setFillAfter(true);
    localView.startAnimation(localbbho);
    paramFrameLayout.startAnimation(localbbhp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbov
 * JD-Core Version:    0.7.0.1
 */