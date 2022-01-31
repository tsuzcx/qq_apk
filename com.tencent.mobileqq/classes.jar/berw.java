import android.view.View;
import android.view.ViewGroup;

public class berw
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
    beql localbeql = new beql(paramViewGroup);
    localbeql.setDuration(jdField_a_of_type_Long);
    localbeql.setFillAfter(true);
    localbeql.setAnimationListener(new berx(localView, paramViewGroup));
    paramViewGroup.startAnimation(localbeql);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     berw
 * JD-Core Version:    0.7.0.1
 */