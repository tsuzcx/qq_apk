import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

public class bnpl
{
  private static SurfaceView a;
  public static String a;
  private static String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(bioy parambioy, String... paramVarArgs)
  {
    if ((parambioy == null) || (parambioy.a() == null) || (parambioy.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)parambioy.a().findViewById(2131381325);
        if ((jdField_a_of_type_AndroidViewSurfaceView != null) && (jdField_a_of_type_AndroidViewSurfaceView.getParent() == localFrameLayout))
        {
          bmtd.b(parambioy.a(), jdField_a_of_type_AndroidViewSurfaceView);
          return;
        }
        jdField_a_of_type_JavaLangString = parambioy.a().getUrl();
        if (paramVarArgs != null) {
          b = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(b));
      jdField_a_of_type_AndroidViewSurfaceView = bmtd.a(parambioy.a(), b);
    } while (jdField_a_of_type_AndroidViewSurfaceView == null);
    localFrameLayout.addView(jdField_a_of_type_AndroidViewSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void b(bioy parambioy, String... paramVarArgs)
  {
    if (parambioy == null) {}
    do
    {
      do
      {
        return;
        parambioy = parambioy.a();
      } while (parambioy == null);
      paramVarArgs = (FrameLayout)parambioy.findViewById(2131381325);
      if ((paramVarArgs != null) && (jdField_a_of_type_AndroidViewSurfaceView != null)) {
        paramVarArgs.removeView(jdField_a_of_type_AndroidViewSurfaceView);
      }
      bmtd.a(parambioy, jdField_a_of_type_AndroidViewSurfaceView);
      jdField_a_of_type_AndroidViewSurfaceView = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      bmtd.a(parambioy, bmtk.a(), paramVarArgs);
      bnmv.a(parambioy);
      parambioy.finish();
    } while (!bmtd.f());
    bjuh.a().a(bmtd.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpl
 * JD-Core Version:    0.7.0.1
 */