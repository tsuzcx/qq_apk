import android.view.View;
import android.view.ViewGroup;

public class biun
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
    bith localbith = new bith(paramViewGroup);
    localbith.setDuration(jdField_a_of_type_Long);
    localbith.setFillAfter(true);
    localbith.setAnimationListener(new biuo(localView, paramViewGroup));
    paramViewGroup.startAnimation(localbith);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biun
 * JD-Core Version:    0.7.0.1
 */