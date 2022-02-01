import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.PlatformInfor.1;
import cooperation.qzone.util.NetworkState;

public class blrt
{
  private static blrt jdField_a_of_type_Blrt;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static String e = "";
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone");
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  
  private blrt()
  {
    try
    {
      e = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(this.jdField_a_of_type_AndroidContentContext.getPackageName(), 0).versionName;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private int a(Context paramContext)
  {
    if (this.jdField_a_of_type_Int == -1)
    {
      ThreadManager.executeOnSubThread(new PlatformInfor.1(this, paramContext));
      return 0;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public static blrt a()
  {
    if (jdField_a_of_type_Blrt == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Blrt == null) {
        jdField_a_of_type_Blrt = new blrt();
      }
      return jdField_a_of_type_Blrt;
    }
  }
  
  private String g()
  {
    String str2 = Build.MODEL;
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = bgjq.a("ro.product.marketname");
    }
    return str1;
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = bkfy.a("52b7f2");
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String b()
  {
    if (TextUtils.isEmpty(this.b)) {
      this.b = bkfy.b("52b7f2");
    }
    return this.b;
  }
  
  public String c()
  {
    if ((this.d != null) && (this.d.length() > 0))
    {
      localObject1 = new StringBuilder(this.d);
      ((StringBuilder)localObject1).append("sharpP=").append(a(this.jdField_a_of_type_AndroidContentContext)).append('&');
      ((StringBuilder)localObject1).append("n=").append(d());
      return ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    Object localObject1 = new DisplayMetrics();
    ((WindowManager)localObject2).getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("i=").append(a()).append('&');
    ((StringBuilder)localObject2).append("imsi=").append(b()).append('&');
    ((StringBuilder)localObject2).append("mac=").append(e()).append('&');
    ((StringBuilder)localObject2).append("m=").append(g()).append('&');
    ((StringBuilder)localObject2).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject2).append("a=").append(Build.VERSION.SDK_INT).append('&');
    StringBuilder localStringBuilder = ((StringBuilder)localObject2).append("sc=");
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (int i = 1;; i = 0)
    {
      localStringBuilder.append(i).append('&');
      ((StringBuilder)localObject2).append("sd=").append("0").append('&');
      ((StringBuilder)localObject2).append("p=").append(((DisplayMetrics)localObject1).widthPixels).append('*').append(((DisplayMetrics)localObject1).heightPixels).append('&');
      ((StringBuilder)localObject2).append("f=").append(Build.MANUFACTURER).append('&');
      ((StringBuilder)localObject2).append("mm=").append(bgln.d() / 1048576L).append('&');
      ((StringBuilder)localObject2).append("cf=").append(bgln.a()).append('&');
      ((StringBuilder)localObject2).append("cc=").append(bgln.b()).append('&');
      ((StringBuilder)localObject2).append("aid=").append(bgln.f()).append('&');
      ((StringBuilder)localObject2).append("qimei=").append(UserAction.getQIMEI()).append('&');
      this.d = ((StringBuilder)localObject2).toString();
      ((StringBuilder)localObject2).append("sharpP=").append(a(this.jdField_a_of_type_AndroidContentContext)).append('&');
      ((StringBuilder)localObject2).append("n=").append(d());
      return ((StringBuilder)localObject2).toString();
    }
  }
  
  public String d()
  {
    switch ()
    {
    default: 
      return "wan";
    case 1: 
      return "wifi";
    case 3: 
      return "3g";
    case 2: 
      return "2g";
    case 4: 
      return "4g";
    }
    return "5g";
  }
  
  public String e()
  {
    if (TextUtils.isEmpty(this.c)) {
      this.c = bkfy.c("52b7f2");
    }
    return this.c;
  }
  
  public String f()
  {
    Object localObject = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)localObject).getDefaultDisplay().getMetrics(localDisplayMetrics);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("m=").append(Build.MODEL).append('&');
    ((StringBuilder)localObject).append("o=").append(Build.VERSION.RELEASE).append('&');
    ((StringBuilder)localObject).append("a=").append(Build.VERSION.SDK_INT).append('&');
    ((StringBuilder)localObject).append("p=").append(localDisplayMetrics.widthPixels).append('*').append(localDisplayMetrics.heightPixels).append('&');
    ((StringBuilder)localObject).append("f=").append(Build.MANUFACTURER).append('&');
    ((StringBuilder)localObject).append("mm=").append(bgln.d() / 1048576L).append('&');
    ((StringBuilder)localObject).append("cf=").append(bgln.a()).append('&');
    ((StringBuilder)localObject).append("cc=").append(bgln.b()).append('&');
    ((StringBuilder)localObject).append("qqversion=").append("8.4.1");
    return ((StringBuilder)localObject).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blrt
 * JD-Core Version:    0.7.0.1
 */