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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class bcpw
{
  private static int jdField_a_of_type_Int = -1;
  private static bcqb jdField_a_of_type_Bcqb = new bcqb(Looper.getMainLooper(), null);
  private static Class jdField_a_of_type_JavaLangClass;
  private static Field jdField_a_of_type_JavaLangReflectField;
  private static Method jdField_a_of_type_JavaLangReflectMethod;
  private static BlockingQueue<bcqa> jdField_a_of_type_JavaUtilConcurrentBlockingQueue = new LinkedBlockingQueue();
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  
  public bcpw(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_AndroidContentResResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  @TargetApi(19)
  public static int a()
  {
    int i = 1;
    try
    {
      if (Build.VERSION.SDK_INT < 19) {
        return 2;
      }
      boolean bool;
      if (Build.VERSION.SDK_INT >= 24) {
        bool = QQNotificationManager.getInstance().areNotificationsEnabled(BaseApplicationImpl.getContext());
      }
      while (QLog.isColorLevel())
      {
        QLog.d("PushOpenNotify", 2, new Object[] { "isNotificationEnabled,  isEnabled, ", Boolean.valueOf(bool) });
        break;
        AppOpsManager localAppOpsManager = (AppOpsManager)BaseApplicationImpl.sApplication.getSystemService("appops");
        ApplicationInfo localApplicationInfo = BaseApplicationImpl.sApplication.getApplicationInfo();
        String str = BaseApplicationImpl.sApplication.getApplicationContext().getPackageName();
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
        j = ((Integer)jdField_a_of_type_JavaLangReflectMethod.invoke(localAppOpsManager, new Object[] { Integer.valueOf(k), Integer.valueOf(j), str })).intValue();
        if (j == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      while (bool) {}
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PushOpenNotify", 2, " isNotificationEnabled, get except, " + localThrowable.getMessage());
      }
      i = 2;
      return i;
    }
    return 0;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 3: 
    case 6: 
    default: 
      return 2130839019;
    case 1: 
    case 4: 
      return 2130846890;
    }
    return 2130846891;
  }
  
  public static bcpw a(Context paramContext, int paramInt1, int paramInt2)
  {
    return a(paramContext, 0, paramInt1, paramInt2);
  }
  
  public static bcpw a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = new bcpw(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.b(paramInt1);
    paramContext.c(paramInt2);
    paramContext.d(paramInt3);
    return paramContext;
  }
  
  public static bcpw a(Context paramContext, int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    paramContext = new bcpw(paramContext);
    paramContext.a(a(paramInt1));
    paramContext.b(paramInt1);
    paramContext.a(paramCharSequence);
    paramContext.d(paramInt2);
    return paramContext;
  }
  
  public static bcpw a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    return a(paramContext, 0, paramCharSequence, paramInt);
  }
  
  public static boolean a()
  {
    return ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("U20"))) && ((!Build.BRAND.equals("Meizu")) || (!Build.MODEL.equals("M3s"))) && ((!Build.BRAND.equals("xiaolajiao")) || (!Build.MODEL.equals("HLJ-GM-Q1"))) && ((!Build.BRAND.equals("UOOGOU")) || (!Build.MODEL.equals("UOOGOU"))) && ((!Build.BRAND.equals("samsung")) || (!Build.MODEL.equals("SM-A9000"))) && (!DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.UICfg.name(), "1").equals("0"));
  }
  
  public static boolean a(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 11) {}
    do
    {
      return false;
      if ((jdField_a_of_type_Int == -1) || (paramBoolean))
      {
        int i = jdField_a_of_type_Int;
        jdField_a_of_type_Int = a();
        if (QLog.isColorLevel()) {
          QLog.d("QQToast", 2, "canUseCustomToast = " + jdField_a_of_type_Int);
        }
        if ((i == 0) && (jdField_a_of_type_Int == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQToast", 2, "Temp Report mark: now Notification from disable to Enabled ");
          }
          axqw.b(null, "dc00898", "", "", "0X8009ACA", "0X8009ACA", 0, 0, "", "", "", "");
        }
      }
    } while (jdField_a_of_type_Int == 1);
    return true;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    case 3: 
    case 6: 
    default: 
      return -15550475;
    case 1: 
    case 4: 
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
    case 0: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    default: 
      return -16777216;
    }
    return -16578533;
  }
  
  public Toast a()
  {
    Toast localToast;
    if (b())
    {
      localToast = a(b());
      localToast.show();
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      return localToast;
      localToast = a(0);
      localToast.show();
    }
  }
  
  public Toast a(int paramInt)
  {
    return a(paramInt, 2131561134, null);
  }
  
  public Toast a(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    bcpz localbcpz = new bcpz(this.jdField_a_of_type_AndroidContentContext);
    View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt2, null);
    Object localObject = localView.findViewById(2131377515);
    if (Build.VERSION.SDK_INT >= 21) {
      ((View)localObject).setElevation(6.0F);
    }
    AnimationUtils.loadAnimation(this.jdField_a_of_type_AndroidContentContext, 2130772215);
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
      localbcpz.setGravity(55, 0, 0);
    }
    for (;;)
    {
      localbcpz.setView(localView);
      localbcpz.setDuration(this.c);
      if (a()) {
        localView.setOnTouchListener(new bcpx(this, localbcpz, paramOnTouchListener));
      }
      return localbcpz;
      ((ImageView)localView.findViewById(2131377519)).setVisibility(8);
      break;
      label372:
      if (paramInt1 == 6316128) {
        localbcpz.setGravity(55, 0, b());
      } else {
        localbcpz.setGravity(55, 0, c());
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt));
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(bcpy parambcpy)
  {
    parambcpy = new bcqa(this, parambcpy);
    jdField_a_of_type_JavaUtilConcurrentBlockingQueue.add(parambcpy);
    jdField_a_of_type_Bcqb.sendEmptyMessage(1);
    if (QLog.isColorLevel()) {
      QLog.d("QQToast", 2, "current queue size is " + jdField_a_of_type_JavaUtilConcurrentBlockingQueue.size());
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
  }
  
  public int b()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 25.0F + 0.5D);
  }
  
  public Toast b(int paramInt)
  {
    Toast localToast = a(paramInt);
    localToast.show();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    return localToast;
  }
  
  public Toast b(int paramInt1, int paramInt2, View.OnTouchListener paramOnTouchListener)
  {
    paramOnTouchListener = a(paramInt1, paramInt2, paramOnTouchListener);
    paramOnTouchListener.show();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    return paramOnTouchListener;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public int c()
  {
    try
    {
      int i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("navigation_bar_height", "dimen", "android"));
      return i;
    }
    catch (Exception localException) {}
    return (int)(this.jdField_a_of_type_AndroidContentResResources.getDisplayMetrics().density * 44.0F + 0.5D);
  }
  
  public void c(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getString(paramInt));
  }
  
  public boolean c()
  {
    if (this.c == 0) {}
    for (long l = 2000L; (System.currentTimeMillis() - this.jdField_a_of_type_Long > l) || (this.jdField_b_of_type_Boolean); l = 3500L) {
      return false;
    }
    return true;
  }
  
  public void d(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcpw
 * JD-Core Version:    0.7.0.1
 */