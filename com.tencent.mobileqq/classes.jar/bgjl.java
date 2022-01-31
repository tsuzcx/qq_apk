import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.ref.WeakReference;

public class bgjl
{
  private static volatile bgjl jdField_a_of_type_Bgjl;
  private WeakReference<ViewGroup> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static bgjl a()
  {
    if (jdField_a_of_type_Bgjl == null) {}
    try
    {
      if (jdField_a_of_type_Bgjl == null) {
        jdField_a_of_type_Bgjl = new bgjl();
      }
      return jdField_a_of_type_Bgjl;
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
 * Qualified Name:     bgjl
 * JD-Core Version:    0.7.0.1
 */