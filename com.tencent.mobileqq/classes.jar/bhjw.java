import android.view.View;
import android.widget.FrameLayout;

public class bhjw
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
    bhcr localbhcr = new bhcr(localView);
    localbhcr.setDuration(jdField_a_of_type_Long);
    localbhcr.setFillAfter(true);
    bhcs localbhcs = new bhcs(paramFrameLayout);
    localbhcs.setDuration(jdField_a_of_type_Long);
    localbhcs.setFillAfter(true);
    localView.startAnimation(localbhcr);
    paramFrameLayout.startAnimation(localbhcs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjw
 * JD-Core Version:    0.7.0.1
 */