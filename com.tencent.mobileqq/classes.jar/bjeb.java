import android.view.View;
import android.view.ViewGroup;

public class bjeb
{
  private static long jdField_a_of_type_Long = 400L;
  private static boolean jdField_a_of_type_Boolean;
  
  public static void a()
  {
    jdField_a_of_type_Boolean = false;
  }
  
  public static void a(ViewGroup paramViewGroup)
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    jdField_a_of_type_Boolean = true;
    paramViewGroup.invalidate();
    View localView = paramViewGroup.getChildAt(0);
    paramViewGroup = paramViewGroup.getChildAt(1);
    bjcq localbjcq = new bjcq(paramViewGroup);
    localbjcq.setDuration(jdField_a_of_type_Long);
    localbjcq.setFillAfter(true);
    localbjcq.setAnimationListener(new bjec(localView, paramViewGroup));
    paramViewGroup.startAnimation(localbjcq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjeb
 * JD-Core Version:    0.7.0.1
 */