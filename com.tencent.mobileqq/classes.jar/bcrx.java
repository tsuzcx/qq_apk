import android.view.View;
import android.widget.FrameLayout;

public class bcrx
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
    bcko localbcko = new bcko(localView);
    localbcko.setDuration(jdField_a_of_type_Long);
    localbcko.setFillAfter(true);
    bckp localbckp = new bckp(paramFrameLayout);
    localbckp.setDuration(jdField_a_of_type_Long);
    localbckp.setFillAfter(true);
    localView.startAnimation(localbcko);
    paramFrameLayout.startAnimation(localbckp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcrx
 * JD-Core Version:    0.7.0.1
 */