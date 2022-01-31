import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.AccessibilityUtil.3;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.List;

public class azve
{
  @TargetApi(14)
  public static void a(Context paramContext)
  {
    try
    {
      paramContext = (AccessibilityManager)paramContext.getSystemService("accessibility");
      boolean bool1 = paramContext.isEnabled();
      boolean bool2 = paramContext.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.c = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("AccessibilityUtil", 2, "setTalkbackSwitch: " + AppSetting.c);
        }
        return;
      }
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  @TargetApi(14)
  public static void a(View paramView)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("AccessibilityUtil", 2, "requestFocus view can't be null");
      }
      return;
    }
    paramView.postDelayed(new AccessibilityUtil.3(paramView), 200L);
  }
  
  public static void a(View paramView, azvj paramazvj)
  {
    paramView.setAccessibilityDelegate(new azvh(paramazvj));
  }
  
  @TargetApi(14)
  public static void a(View paramView, CharSequence paramCharSequence, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 14) {
      paramView.setAccessibilityDelegate(new azvi(paramCharSequence, paramString));
    }
  }
  
  public static void a(View paramView, String paramString)
  {
    if (AppSetting.c) {
      paramView.setContentDescription(paramString);
    }
  }
  
  public static void a(View paramView, boolean paramBoolean)
  {
    if ((AppSetting.c) && (Build.VERSION.SDK_INT >= 16))
    {
      if (paramBoolean) {
        ViewCompat.setImportantForAccessibility(paramView, 1);
      }
    }
    else {
      return;
    }
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  @TargetApi(14)
  public static void a(EditText paramEditText, String paramString)
  {
    if ((AppSetting.c) && (Build.VERSION.SDK_INT >= 14))
    {
      paramEditText.setContentDescription(paramString);
      paramEditText.setAccessibilityDelegate(new azvf());
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return ((AccessibilityManager)paramContext.getSystemService("accessibility")).isEnabled();
  }
  
  @TargetApi(16)
  public static boolean a(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain(16384);
      localAccessibilityEvent.setPackageName(paramView.getContext().getPackageName());
      localAccessibilityEvent.setClassName(paramView.getClass().getName());
      localAccessibilityEvent.setSource(paramView);
      localAccessibilityEvent.getText().add(paramString);
      paramView.getParent().requestSendAccessibilityEvent(paramView, localAccessibilityEvent);
    }
    for (;;)
    {
      return true;
      QQAppInterface.f(paramString);
    }
  }
  
  @TargetApi(16)
  public static void b(View paramView)
  {
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)paramView.getContext().getSystemService("accessibility");
    if ((localAccessibilityManager != null) && (Build.VERSION.SDK_INT >= 14) && (localAccessibilityManager.isEnabled()))
    {
      paramView.setFocusable(true);
      paramView.setAccessibilityDelegate(new azvg());
    }
  }
  
  public static void b(View paramView, String paramString)
  {
    a(paramView, null, paramString);
  }
  
  public static void b(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = localViewGroup.getChildCount();
      int i = 0;
      while (i < j)
      {
        b(localViewGroup.getChildAt(i), paramBoolean);
        i += 1;
      }
    }
    if (paramBoolean)
    {
      ViewCompat.setImportantForAccessibility(paramView, 1);
      return;
    }
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  @TargetApi(16)
  public static void c(View paramView)
  {
    int i = 0;
    if (paramView == null) {
      if (QLog.isColorLevel()) {
        QLog.w("AccessibilityUtil", 2, "clearFocus view can't be null");
      }
    }
    label122:
    for (;;)
    {
      return;
      if ((AppSetting.c) && (Build.VERSION.SDK_INT > 15))
      {
        Method[] arrayOfMethod = paramView.getClass().getMethods();
        int j = arrayOfMethod.length;
        for (;;)
        {
          if (i >= j) {
            break label122;
          }
          Method localMethod = arrayOfMethod[i];
          if (localMethod.getName().equals("clearAccessibilityFocus"))
          {
            try
            {
              localMethod.invoke(paramView, new Object[0]);
              return;
            }
            catch (Exception paramView) {}
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.w("AccessibilityUtil", 2, "clearFocus: " + paramView.toString());
            return;
          }
          i += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     azve
 * JD-Core Version:    0.7.0.1
 */