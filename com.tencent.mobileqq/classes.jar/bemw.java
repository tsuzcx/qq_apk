import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class bemw
{
  private static int jdField_a_of_type_Int = -1;
  private static bemz jdField_a_of_type_Bemz = new bemz(Looper.getMainLooper(), null);
  private static Class jdField_a_of_type_JavaLangClass;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static BlockingQueue<WeakReference<bemw>> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  private long jdField_a_of_type_Long = 2000L;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private Toast jdField_a_of_type_AndroidWidgetToast;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  
  public bemw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2130840726;
    case 1: 
      return 2130840725;
    }
    return 2130840727;
  }
  
  @TargetApi(19)
  public static int a(Context paramContext)
  {
    int i = 1;
    try
    {
      if (Build.VERSION.SDK_INT < 19) {
        return 2;
      }
      boolean bool;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = true;
      }
      while (besl.a())
      {
        besl.a("PushOpenNotify", "isNotificationEnabled,  isEnabled, " + bool);
        break;
        AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
        ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
        paramContext = paramContext.getApplicationContext().getPackageName();
        int j = localApplicationInfo.uid;
        if (jdField_a_of_type_JavaLangClass == null) {
          jdField_a_of_type_JavaLangClass = Class.forName(AppOpsManager.class.getName());
        }
        if (jdField_a_of_type_JavaLangReflectMethod == null) {
          jdField_a_of_type_JavaLangReflectMethod = jdField_a_of_type_JavaLangClass.getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class });
        }
        if (jdField_a_of_type_JavaLangReflectField == null) {
          jdField_a_of_type_JavaLangReflectField = jdField_a_of_type_JavaLangClass.getDeclaredField("OP_POST_NOTIFICATION");
        }
        int k = ((Integer)jdField_a_of_type_JavaLangReflectField.get(Integer.class)).intValue();
        j = ((Integer)jdField_a_of_type_JavaLangReflectMethod.invoke(localAppOpsManager, new Object[] { Integer.valueOf(k), Integer.valueOf(j), paramContext })).intValue();
        if (j == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      while (bool) {}
    }
    catch (Throwable paramContext)
    {
      if (besl.a()) {
        besl.a("PushOpenNotify", " isNotificationEnabled, get except, " + paramContext.getMessage());
      }
      i = 2;
      return i;
    }
    return 0;
  }
  
  public static bemw a(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new bemw(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.b(paramInt1);
    paramContext.a(paramCharSequence);
    paramContext.c(paramInt2);
    return paramContext;
  }
  
  public static bemw a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return a(paramContext, 0, paramCharSequence, paramInt);
  }
  
  public static boolean a()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000")));
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return false;
      if ((jdField_a_of_type_Int == -1) || (paramBoolean))
      {
        int i = jdField_a_of_type_Int;
        jdField_a_of_type_Int = a(paramContext);
        besl.a("QQToast", "canUseCustomToast = " + jdField_a_of_type_Int);
        if ((i == 0) && (jdField_a_of_type_Int == 1)) {
          besl.a("QQToast", "Temp Report mark: now Notification from disable to Enabled ");
        }
      }
    } while (jdField_a_of_type_Int == 1);
    return true;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -15550475;
    case 1: 
      return -1;
    }
    return -7745469;
  }
  
  public static boolean b()
  {
    return Build.BOARD.contains("mx2");
  }
  
  private static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return -16777216;
    }
    return -16578533;
  }
  
  public int a()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public Toast a()
  {
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetToast = a(a());
      this.jdField_a_of_type_AndroidWidgetToast.show();
    }
    for (;;)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      return this.jdField_a_of_type_AndroidWidgetToast;
      this.jdField_a_of_type_AndroidWidgetToast = a(0);
      this.jdField_a_of_type_AndroidWidgetToast.show();
    }
  }
  
  public Toast a(int paramInt)
  {
    return a(paramInt, 2131559310, null);
  }
  
  public Toast a(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    bemy localbemy = new bemy(this.jdField_a_of_type_AndroidContentContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    Object localObject = localView.findViewById(2131377515);
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)localObject).setElevation(6.0F);
    }
    AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772088);
    localView.findViewById(2131377521);
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      localObject = (ImageView)localView.findViewById(2131377519);
      ((ImageView)localObject).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      ((ImageView)localObject).setColorFilter(b(this.jdField_b_of_type_Int), PorterDuff.Mode.MULTIPLY);
      if (this.jdField_a_of_type_JavaLangCharSequence != null)
      {
        localObject = (TextView)localView.findViewById(2131377522);
        ((TextView)localObject).setTextColor(c(this.jdField_b_of_type_Int));
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangCharSequence);
        String str = this.jdField_a_of_type_JavaLangCharSequence.toString();
        TextPaint localTextPaint = ((TextView)localObject).getPaint();
        float f1 = localTextPaint.measureText(str);
        DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics();
        float f2 = localDisplayMetrics.densityDpi / 160 * 50;
        f2 = localDisplayMetrics.widthPixels - f2;
        if (f1 > f2) {
          ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * 5.0F / 6.0F / localDisplayMetrics.density);
        }
        if (this.jdField_a_of_type_Boolean)
        {
          f1 = localTextPaint.measureText(str);
          if (f1 > f2) {
            ((TextView)localObject).setTextSize(2, ((TextView)localObject).getTextSize() * f2 / f1 / localDisplayMetrics.scaledDensity);
          }
        }
      }
      if (!a()) {
        break label372;
      }
      localbemy.setGravity(55, 0, 0);
    }
    for (;;)
    {
      localbemy.setView(localView);
      localbemy.setDuration(this.jdField_c_of_type_Int);
      if (a()) {
        localView.setOnTouchListener(new bemx(this, localbemy, paramOnTouchListener));
      }
      return localbemy;
      ((ImageView)localView.findViewById(2131377519)).setVisibility(8);
      break;
      label372:
      if (paramInt1 == 6316128) {
        localbemy.setGravity(55, 0, a());
      } else {
        localbemy.setGravity(55, 0, b());
      }
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    jdField_a_of_type_Bemz.sendEmptyMessage(2);
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int b()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 44.0F + 0.5D);
  }
  
  public Toast b(int paramInt)
  {
    Toast localToast = a(paramInt);
    localToast.show();
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_c_of_type_Boolean = false;
    return localToast;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bemw
 * JD-Core Version:    0.7.0.1
 */