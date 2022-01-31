import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

public class bgkt
{
  private static SurfaceView a;
  public static String a;
  private static String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(bbac parambbac, String... paramVarArgs)
  {
    if ((parambbac == null) || (parambbac.a() == null) || (parambbac.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)parambbac.a().findViewById(2131313562);
        if ((jdField_a_of_type_AndroidViewSurfaceView != null) && (jdField_a_of_type_AndroidViewSurfaceView.getParent() == localFrameLayout))
        {
          bfpr.b(parambbac.a(), jdField_a_of_type_AndroidViewSurfaceView);
          return;
        }
        jdField_a_of_type_JavaLangString = parambbac.a().getUrl();
        if (paramVarArgs != null) {
          b = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(b));
      jdField_a_of_type_AndroidViewSurfaceView = bfpr.a(parambbac.a(), b);
    } while (jdField_a_of_type_AndroidViewSurfaceView == null);
    localFrameLayout.addView(jdField_a_of_type_AndroidViewSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void b(bbac parambbac, String... paramVarArgs)
  {
    if (parambbac == null) {}
    do
    {
      do
      {
        return;
        parambbac = parambbac.a();
      } while (parambbac == null);
      paramVarArgs = (FrameLayout)parambbac.findViewById(2131313562);
      if ((paramVarArgs != null) && (jdField_a_of_type_AndroidViewSurfaceView != null)) {
        paramVarArgs.removeView(jdField_a_of_type_AndroidViewSurfaceView);
      }
      bfpr.a(parambbac, jdField_a_of_type_AndroidViewSurfaceView);
      jdField_a_of_type_AndroidViewSurfaceView = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      bfpr.a(parambbac, bfpy.a(), paramVarArgs);
      bgif.a(parambbac);
      parambbac.finish();
    } while (!bfpr.f());
    bcec.a().a(bfpr.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgkt
 * JD-Core Version:    0.7.0.1
 */