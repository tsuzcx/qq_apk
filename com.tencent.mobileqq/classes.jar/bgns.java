import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;

public class bgns
{
  private static volatile bgns jdField_a_of_type_Bgns;
  private WeakReference<ViewGroup> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bgns a()
  {
    if (jdField_a_of_type_Bgns == null) {}
    try
    {
      if (jdField_a_of_type_Bgns == null) {
        jdField_a_of_type_Bgns = new bgns();
      }
      return jdField_a_of_type_Bgns;
    }
    finally {}
  }
  
  public void a(View paramView)
  {
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localViewGroup == null)
    {
      QMLog.e("GameVideoPlayerManager", "removePlayerView error: parent == null");
      return;
    }
    localViewGroup.removeView(paramView);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_JavaLangRefWeakReference.get(); localViewGroup == null; localViewGroup = null)
    {
      QMLog.e("GameVideoPlayerManager", "addPlayerView error: parent == null");
      return;
    }
    localViewGroup.addView(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgns
 * JD-Core Version:    0.7.0.1
 */