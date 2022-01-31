import android.view.View;
import android.view.ViewGroup;

public class bcsn
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
    bcrc localbcrc = new bcrc(paramViewGroup);
    localbcrc.setDuration(jdField_a_of_type_Long);
    localbcrc.setFillAfter(true);
    localbcrc.setAnimationListener(new bcso(localView, paramViewGroup));
    paramViewGroup.startAnimation(localbcrc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcsn
 * JD-Core Version:    0.7.0.1
 */