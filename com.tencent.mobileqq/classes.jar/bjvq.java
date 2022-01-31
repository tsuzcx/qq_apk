import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.SurfaceView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

public class bjvq
{
  private static SurfaceView a;
  public static String a;
  private static String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "";
  }
  
  public static void a(becq parambecq, String... paramVarArgs)
  {
    if ((parambecq == null) || (parambecq.a() == null) || (parambecq.a() == null)) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
        localFrameLayout = (FrameLayout)parambecq.a().findViewById(2131380117);
        if ((jdField_a_of_type_AndroidViewSurfaceView != null) && (jdField_a_of_type_AndroidViewSurfaceView.getParent() == localFrameLayout))
        {
          bizm.b(parambecq.a(), jdField_a_of_type_AndroidViewSurfaceView);
          return;
        }
        jdField_a_of_type_JavaLangString = parambecq.a().getUrl();
        if (paramVarArgs != null) {
          b = paramVarArgs[0];
        }
      } while (TextUtils.isEmpty(b));
      jdField_a_of_type_AndroidViewSurfaceView = bizm.a(parambecq.a(), b);
    } while (jdField_a_of_type_AndroidViewSurfaceView == null);
    localFrameLayout.addView(jdField_a_of_type_AndroidViewSurfaceView, new FrameLayout.LayoutParams(-1, -1));
  }
  
  public static void b(becq parambecq, String... paramVarArgs)
  {
    if (parambecq == null) {}
    do
    {
      do
      {
        return;
        parambecq = parambecq.a();
      } while (parambecq == null);
      paramVarArgs = (FrameLayout)parambecq.findViewById(2131380117);
      if ((paramVarArgs != null) && (jdField_a_of_type_AndroidViewSurfaceView != null)) {
        paramVarArgs.removeView(jdField_a_of_type_AndroidViewSurfaceView);
      }
      bizm.a(parambecq, jdField_a_of_type_AndroidViewSurfaceView);
      jdField_a_of_type_AndroidViewSurfaceView = null;
      paramVarArgs = new Intent("action_js2qzone");
      Bundle localBundle = new Bundle();
      localBundle.putString("cmd", "setFloat");
      paramVarArgs.putExtras(localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("QZoneFloatJsHandleLogic", 2, "actionString: " + paramVarArgs.getAction());
      }
      bizm.a(parambecq, bizt.a(), paramVarArgs);
      bjta.a(parambecq);
      parambecq.finish();
    } while (!bizm.f());
    bfhq.a().a(bizm.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvq
 * JD-Core Version:    0.7.0.1
 */