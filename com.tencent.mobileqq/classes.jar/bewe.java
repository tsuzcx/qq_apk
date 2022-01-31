import android.view.View;
import android.widget.FrameLayout;

public class bewe
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
    beon localbeon = new beon(localView);
    localbeon.setDuration(jdField_a_of_type_Long);
    localbeon.setFillAfter(true);
    beoo localbeoo = new beoo(paramFrameLayout);
    localbeoo.setDuration(jdField_a_of_type_Long);
    localbeoo.setFillAfter(true);
    localView.startAnimation(localbeon);
    paramFrameLayout.startAnimation(localbeoo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewe
 * JD-Core Version:    0.7.0.1
 */