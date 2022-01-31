import android.view.View;
import android.widget.FrameLayout;

public class bcsm
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
    bcld localbcld = new bcld(localView);
    localbcld.setDuration(jdField_a_of_type_Long);
    localbcld.setFillAfter(true);
    bcle localbcle = new bcle(paramFrameLayout);
    localbcle.setDuration(jdField_a_of_type_Long);
    localbcle.setFillAfter(true);
    localView.startAnimation(localbcld);
    paramFrameLayout.startAnimation(localbcle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcsm
 * JD-Core Version:    0.7.0.1
 */