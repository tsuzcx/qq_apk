import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class bdet
{
  private static volatile bdet jdField_a_of_type_Bdet;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<ViewGroup> b;
  
  public static bdet a()
  {
    if (jdField_a_of_type_Bdet == null) {}
    try
    {
      if (jdField_a_of_type_Bdet == null) {
        jdField_a_of_type_Bdet = new bdet();
      }
      return jdField_a_of_type_Bdet;
    }
    finally {}
  }
  
  public void a(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.b = new WeakReference(paramViewGroup);
  }
  
  public void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)this.b.get();
    if (localViewGroup == null)
    {
      bdnw.d("GameVideoPlayerManager", "removePlayerView error: parent == null");
      return;
    }
    localViewGroup.removeView(paramView);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.b != null) {}
    for (ViewGroup localViewGroup = (ViewGroup)this.b.get(); localViewGroup == null; localViewGroup = null)
    {
      bdnw.d("GameVideoPlayerManager", "addPlayerView error: parent == null");
      return;
    }
    localViewGroup.addView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdet
 * JD-Core Version:    0.7.0.1
 */