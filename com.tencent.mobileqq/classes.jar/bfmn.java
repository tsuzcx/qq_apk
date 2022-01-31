import android.content.Context;
import android.view.View;
import com.tencent.shadow.dynamic.host.EnterCallback;

final class bfmn
  implements EnterCallback
{
  bfmn(Context paramContext, long paramLong) {}
  
  public void onCloseLoadingView()
  {
    bfne.d("ReaderPluginHelper", "launchShadowPlugin [onCloseLoadingView]");
  }
  
  public void onEnterComplete()
  {
    bfne.d("ReaderPluginHelper", "launchShadowPlugin [onEnterComplete]");
    bfnk.a(this.jdField_a_of_type_AndroidContentContext, String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long), "0");
  }
  
  public void onShowLoadingView(View paramView)
  {
    bfne.d("ReaderPluginHelper", "launchShadowPlugin [onShowLoadingView]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmn
 * JD-Core Version:    0.7.0.1
 */