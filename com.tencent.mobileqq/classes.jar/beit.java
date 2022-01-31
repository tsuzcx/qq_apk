import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class beit
{
  private static volatile beit jdField_a_of_type_Beit;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<ViewGroup> b;
  
  public static beit a()
  {
    if (jdField_a_of_type_Beit == null) {}
    try
    {
      if (jdField_a_of_type_Beit == null) {
        jdField_a_of_type_Beit = new beit();
      }
      return jdField_a_of_type_Beit;
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
      besl.d("GameVideoPlayerManager", "removePlayerView error: parent == null");
      return;
    }
    localViewGroup.removeView(paramView);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.b != null) {}
    for (ViewGroup localViewGroup = (ViewGroup)this.b.get(); localViewGroup == null; localViewGroup = null)
    {
      besl.d("GameVideoPlayerManager", "addPlayerView error: parent == null");
      return;
    }
    localViewGroup.addView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beit
 * JD-Core Version:    0.7.0.1
 */