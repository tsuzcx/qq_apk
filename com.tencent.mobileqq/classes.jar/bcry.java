import android.view.View;
import android.view.ViewGroup;

public class bcry
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
    bcqn localbcqn = new bcqn(paramViewGroup);
    localbcqn.setDuration(jdField_a_of_type_Long);
    localbcqn.setFillAfter(true);
    localbcqn.setAnimationListener(new bcrz(localView, paramViewGroup));
    paramViewGroup.startAnimation(localbcqn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcry
 * JD-Core Version:    0.7.0.1
 */