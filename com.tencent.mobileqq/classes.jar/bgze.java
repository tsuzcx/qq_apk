import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;

public class bgze
{
  private static volatile bgze jdField_a_of_type_Bgze;
  private WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<ViewGroup> b;
  
  public static bgze a()
  {
    if (jdField_a_of_type_Bgze == null) {}
    try
    {
      if (jdField_a_of_type_Bgze == null) {
        jdField_a_of_type_Bgze = new bgze();
      }
      return jdField_a_of_type_Bgze;
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
      QMLog.e("GameVideoPlayerManager", "removePlayerView error: parent == null");
      return;
    }
    localViewGroup.removeView(paramView);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.b != null) {}
    for (ViewGroup localViewGroup = (ViewGroup)this.b.get(); localViewGroup == null; localViewGroup = null)
    {
      QMLog.e("GameVideoPlayerManager", "addPlayerView error: parent == null");
      return;
    }
    localViewGroup.addView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgze
 * JD-Core Version:    0.7.0.1
 */