import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import java.util.ArrayList;
import java.util.List;

public class apvb
  implements Animation.AnimationListener
{
  public static int a;
  public static int b;
  View jdField_a_of_type_AndroidViewView;
  apvc jdField_a_of_type_Apvc;
  List<apvc> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[1];
  
  public apvb(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  private void b(apvc paramapvc)
  {
    this.jdField_a_of_type_Apvc = paramapvc;
    Animation localAnimation = (Animation)paramapvc.jdField_a_of_type_JavaLangObject;
    localAnimation.setDuration(paramapvc.b);
    localAnimation.setAnimationListener(this);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        continue;
      }
      synchronized (this.jdField_a_of_type_ArrayOfInt)
      {
        apvc localapvc = (apvc)this.jdField_a_of_type_JavaUtilList.get(0);
        this.jdField_a_of_type_JavaUtilList.remove(0);
        if ((localapvc == null) || ((localapvc.jdField_a_of_type_Boolean == true) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)) || ((!localapvc.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4)))) {
          continue;
        }
        this.jdField_a_of_type_AndroidViewView.setAnimation((Animation)localapvc.jdField_a_of_type_JavaLangObject);
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localapvc.jdField_a_of_type_JavaLangObject);
        return;
      }
    }
  }
  
  public void a(apvc paramapvc)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_a_of_type_JavaUtilList.add(paramapvc);
      b(paramapvc);
      return;
    }
  }
  
  public void b()
  {
    synchronized (this.jdField_a_of_type_ArrayOfInt)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_AndroidViewView.clearAnimation();
      return;
    }
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Apvc.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      a();
      return;
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apvb
 * JD-Core Version:    0.7.0.1
 */