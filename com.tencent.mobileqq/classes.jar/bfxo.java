import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.reflect.Method;

public class bfxo
  implements Handler.Callback
{
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  public static boolean b;
  private ColorFilter jdField_a_of_type_AndroidGraphicsColorFilter;
  public Handler a;
  public View a;
  private final bfxq jdField_a_of_type_Bfxq;
  public boolean a;
  private boolean c;
  
  static
  {
    if (bfni.j()) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      jdField_a_of_type_JavaLangString = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      jdField_a_of_type_Int = -1;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        jdField_a_of_type_JavaLangString = null;
      }
    }
  }
  
  @TargetApi(19)
  public bfxo(Window paramWindow, boolean paramBoolean)
  {
    ViewGroup localViewGroup = (ViewGroup)paramWindow.getDecorView();
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      this.c = paramBoolean;
    }
    this.jdField_a_of_type_Bfxq = new bfxq(paramWindow, this.c, null);
    if (this.c) {
      a(paramWindow, localViewGroup);
    }
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    if (paramWindow.getContext().getResources().getConfiguration().orientation == 1) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      b = paramBoolean;
      return;
    }
  }
  
  @TargetApi(14)
  public static int a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i = 0;
    if (Build.VERSION.SDK_INT >= 14) {
      if (!b) {
        break label32;
      }
    }
    label32:
    for (paramContext = "navigation_bar_height";; paramContext = "navigation_bar_height_landscape")
    {
      i = a(localResources, paramContext);
      return i;
    }
  }
  
  private static int a(Resources paramResources, String paramString)
  {
    int i = 0;
    int j = paramResources.getIdentifier(paramString, "dimen", "android");
    if (j > 0) {
      i = paramResources.getDimensionPixelSize(j);
    }
    return i;
  }
  
  private void a(Window paramWindow, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewView = new View(paramWindow.getContext());
    paramWindow = new FrameLayout.LayoutParams(-1, this.jdField_a_of_type_Bfxq.a());
    paramWindow.gravity = 48;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramWindow);
    try
    {
      IphoneTitleBarActivity.setLayerType(this.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      paramViewGroup.addView(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    catch (Exception paramWindow)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("setupStatusBarView", 2, paramWindow.toString());
        }
      }
    }
  }
  
  @TargetApi(14)
  public static boolean a(Context paramContext)
  {
    if (jdField_a_of_type_Int != -1) {
      return jdField_a_of_type_Int == 1;
    }
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool;
    if (i != 0)
    {
      bool = localResources.getBoolean(i);
      if ("1".equals(jdField_a_of_type_JavaLangString)) {
        bool = false;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XPanelContainer", 2, "hasNavbar=" + bool);
      }
      if (bool) {}
      for (jdField_a_of_type_Int = 1;; jdField_a_of_type_Int = 0)
      {
        return bool;
        if (!"0".equals(jdField_a_of_type_JavaLangString)) {
          break;
        }
        bool = true;
        break;
        if (Build.VERSION.SDK_INT < 14) {
          break label149;
        }
        if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey())
        {
          bool = true;
          break;
        }
        bool = false;
        break;
      }
      label149:
      bool = false;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c)
    {
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramInt);
      if (this.jdField_a_of_type_AndroidViewView.getBackground() != null) {
        this.jdField_a_of_type_AndroidViewView.getBackground().setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "setStatusBarVisible=" + paramInt1);
    }
    if (paramInt1 == 0) {}
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(paramInt1, paramInt2);
      return;
    }
  }
  
  public void a(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsColorFilter = paramColorFilter;
    Drawable localDrawable = this.jdField_a_of_type_AndroidViewView.getBackground();
    if (localDrawable != null)
    {
      localDrawable.setColorFilter(paramColorFilter);
      localDrawable.invalidateSelf();
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    if (this.c)
    {
      if (paramDrawable != null) {
        paramDrawable.setColorFilter(this.jdField_a_of_type_AndroidGraphicsColorFilter);
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SystemBarTintManager", 2, "setStatusBarTintEnabled enabled = " + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    View localView;
    if (this.c)
    {
      localView = this.jdField_a_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label62;
      }
    }
    label62:
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "setStatusBarVisible=" + paramBoolean);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, paramInt);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramInt);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (QLog.isColorLevel()) {
      QLog.d("status", 2, "SystemBarTintManager=" + paramMessage.what);
    }
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return false;
    case 1: 
      this.jdField_a_of_type_AndroidViewView.setVisibility(4);
      return false;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfxo
 * JD-Core Version:    0.7.0.1
 */