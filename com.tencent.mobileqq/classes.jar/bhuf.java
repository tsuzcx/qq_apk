import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

public class bhuf
{
  private static SurfaceView a;
  public static String a;
  private static String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(bcdp parambcdp, String... paramVarArgs)
  {
    if ((parambcdp == null) || (parambcdp.a() == null) || (parambcdp.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)parambcdp.a().findViewById(2131379402);
        if ((jdField_a_of_type_AndroidViewSurfaceView != null) && (jdField_a_of_type_AndroidViewSurfaceView.getParent() == localFrameLayout))
        {
          bgyp.b(parambcdp.a(), jdField_a_of_type_AndroidViewSurfaceView);
          return;
        }
        jdField_a_of_type_JavaLangString = parambcdp.a().getUrl();
        if (paramVarArgs != null) {
          b = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(b));
      jdField_a_of_type_AndroidViewSurfaceView = bgyp.a(parambcdp.a(), b);
    } while (jdField_a_of_type_AndroidViewSurfaceView == null);
    localFrameLayout.addView(jdField_a_of_type_AndroidViewSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void b(bcdp parambcdp, String... paramVarArgs)
  {
    if (parambcdp == null) {}
    do
    {
      do
      {
        return;
        parambcdp = parambcdp.a();
      } while (parambcdp == null);
      paramVarArgs = (FrameLayout)parambcdp.findViewById(2131379402);
      if ((paramVarArgs != null) && (jdField_a_of_type_AndroidViewSurfaceView != null)) {
        paramVarArgs.removeView(jdField_a_of_type_AndroidViewSurfaceView);
      }
      bgyp.a(parambcdp, jdField_a_of_type_AndroidViewSurfaceView);
      jdField_a_of_type_AndroidViewSurfaceView = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      bgyp.a(parambcdp, bgyw.a(), paramVarArgs);
      bhrp.a(parambcdp);
      parambcdp.finish();
    } while (!bgyp.f());
    bdis.a().a(bgyp.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhuf
 * JD-Core Version:    0.7.0.1
 */