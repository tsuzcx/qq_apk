import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

public class bejk
{
  private static volatile bejk jdField_a_of_type_Bejk;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<ViewGroup> b;
  
  public static bejk a()
  {
    if (jdField_a_of_type_Bejk == null) {}
    try
    {
      if (jdField_a_of_type_Bejk == null) {
        jdField_a_of_type_Bejk = new bejk();
      }
      return jdField_a_of_type_Bejk;
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
      betc.d("GameVideoPlayerManager", "removePlayerView error: parent == null");
      return;
    }
    localViewGroup.removeView(paramView);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.b != null) {}
    for (ViewGroup localViewGroup = (ViewGroup)this.b.get(); localViewGroup == null; localViewGroup = null)
    {
      betc.d("GameVideoPlayerManager", "addPlayerView error: parent == null");
      return;
    }
    localViewGroup.addView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bejk
 * JD-Core Version:    0.7.0.1
 */