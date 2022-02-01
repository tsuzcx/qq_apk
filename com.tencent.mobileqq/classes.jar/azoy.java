import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.phonecontact.PermissionPageUtil.1;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class azoy
{
  private static String b;
  private Context jdField_a_of_type_AndroidContentContext;
  private String jdField_a_of_type_JavaLangString;
  
  public azoy(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    ThreadManager.excute(new PermissionPageUtil.1(this), 16, null, true);
    a(String.format("PermissionPageUtil [%s]", new Object[] { paramString }));
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: getstatic 45	azoy:b	Ljava/lang/String;
    //   3: ifnull +7 -> 10
    //   6: getstatic 45	azoy:b	Ljava/lang/String;
    //   9: areturn
    //   10: aconst_null
    //   11: astore_0
    //   12: new 47	java/io/BufferedReader
    //   15: dup
    //   16: new 49	java/io/InputStreamReader
    //   19: dup
    //   20: invokestatic 55	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   23: new 57	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   30: ldc 60
    //   32: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 66
    //   37: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokevirtual 73	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   46: invokevirtual 79	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: invokespecial 82	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   52: sipush 1024
    //   55: invokespecial 85	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   58: astore_1
    //   59: aload_1
    //   60: astore_0
    //   61: aload_1
    //   62: invokevirtual 88	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: putstatic 45	azoy:b	Ljava/lang/String;
    //   68: aload_1
    //   69: astore_0
    //   70: aload_1
    //   71: invokevirtual 91	java/io/BufferedReader:close	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 91	java/io/BufferedReader:close	()V
    //   82: getstatic 45	azoy:b	Ljava/lang/String;
    //   85: ifnonnull +8 -> 93
    //   88: ldc 93
    //   90: putstatic 45	azoy:b	Ljava/lang/String;
    //   93: ldc 95
    //   95: iconst_1
    //   96: anewarray 4	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: getstatic 45	azoy:b	Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 36	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   108: invokestatic 39	azoy:a	(Ljava/lang/String;)V
    //   111: getstatic 45	azoy:b	Ljava/lang/String;
    //   114: areturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   120: goto -38 -> 82
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_1
    //   126: aload_1
    //   127: astore_0
    //   128: aload_2
    //   129: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   132: aload_1
    //   133: ifnull +7 -> 140
    //   136: aload_1
    //   137: invokevirtual 91	java/io/BufferedReader:close	()V
    //   140: getstatic 45	azoy:b	Ljava/lang/String;
    //   143: ifnonnull -50 -> 93
    //   146: ldc 93
    //   148: putstatic 45	azoy:b	Ljava/lang/String;
    //   151: goto -58 -> 93
    //   154: astore_0
    //   155: aload_0
    //   156: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   159: goto -19 -> 140
    //   162: astore_2
    //   163: aload_0
    //   164: astore_1
    //   165: aload_2
    //   166: astore_0
    //   167: aload_1
    //   168: ifnull +7 -> 175
    //   171: aload_1
    //   172: invokevirtual 91	java/io/BufferedReader:close	()V
    //   175: getstatic 45	azoy:b	Ljava/lang/String;
    //   178: ifnonnull +8 -> 186
    //   181: ldc 93
    //   183: putstatic 45	azoy:b	Ljava/lang/String;
    //   186: aload_0
    //   187: athrow
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 98	java/lang/Throwable:printStackTrace	()V
    //   193: goto -18 -> 175
    //   196: astore_2
    //   197: aload_0
    //   198: astore_1
    //   199: aload_2
    //   200: astore_0
    //   201: goto -34 -> 167
    //   204: astore_2
    //   205: goto -79 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   11	59	0	localObject1	Object
    //   115	2	0	localThrowable1	Throwable
    //   127	1	0	localObject2	Object
    //   154	10	0	localThrowable2	Throwable
    //   166	35	0	localObject3	Object
    //   58	114	1	localObject4	Object
    //   188	2	1	localThrowable3	Throwable
    //   198	1	1	localObject5	Object
    //   123	6	2	localThrowable4	Throwable
    //   162	4	2	localObject6	Object
    //   196	4	2	localObject7	Object
    //   204	1	2	localThrowable5	Throwable
    // Exception table:
    //   from	to	target	type
    //   78	82	115	java/lang/Throwable
    //   12	59	123	java/lang/Throwable
    //   136	140	154	java/lang/Throwable
    //   12	59	162	finally
    //   171	175	188	java/lang/Throwable
    //   61	68	196	finally
    //   70	74	196	finally
    //   128	132	196	finally
    //   61	68	204	java/lang/Throwable
    //   70	74	204	java/lang/Throwable
  }
  
  public static void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PermissionPageUtil", 2, paramString);
    }
  }
  
  private void b(String paramString)
  {
    Object localObject;
    try
    {
      paramString = this.jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(paramString, 0);
      if (paramString == null)
      {
        c();
        return;
      }
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
      localObject = new Intent("android.intent.action.MAIN", null);
      ((Intent)localObject).addCategory("android.intent.category.LAUNCHER");
      ((Intent)localObject).setPackage(paramString.packageName);
      paramString = this.jdField_a_of_type_AndroidContentContext.getPackageManager().queryIntentActivities((Intent)localObject, 0);
      if (paramString == null) {
        break label158;
      }
    }
    if (paramString.size() > 0) {}
    label158:
    for (paramString = (ResolveInfo)paramString.get(0);; paramString = null)
    {
      if (paramString != null)
      {
        localObject = paramString.activityInfo.packageName;
        paramString = paramString.activityInfo.name;
        Intent localIntent = new Intent("android.intent.action.MAIN");
        localIntent.addCategory("android.intent.category.LAUNCHER");
        localIntent.setComponent(new ComponentName((String)localObject, paramString));
        a(localIntent);
        return;
      }
      c();
      return;
    }
  }
  
  private void c()
  {
    a("goIntentSetting");
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", this.jdField_a_of_type_AndroidContentContext.getPackageName(), null));
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 99999);
      return;
    }
    this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
  }
  
  private void d()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_JavaLangString);
    localIntent.setFlags(268435456);
    localIntent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
    a(localIntent);
  }
  
  private void e()
  {
    Object localObject = a();
    if (("V6".equals(localObject)) || ("V7".equals(localObject)))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("miui.intent.action.APP_PERM_EDITOR");
      ((Intent)localObject).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
      ((Intent)localObject).putExtra("extra_pkgname", this.jdField_a_of_type_JavaLangString);
      a((Intent)localObject);
      return;
    }
    if (("V8".equals(localObject)) || ("V9".equals(localObject)))
    {
      localObject = new Intent();
      ((Intent)localObject).setAction("miui.intent.action.APP_PERM_EDITOR");
      ((Intent)localObject).setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
      ((Intent)localObject).putExtra("extra_pkgname", this.jdField_a_of_type_JavaLangString);
      a((Intent)localObject);
      return;
    }
    c();
  }
  
  public void a()
  {
    a(String.format("jumpPermissionPage [brand: %s, model: %s, manufacture: %s]", new Object[] { Build.BRAND, Build.MODEL, Build.MANUFACTURER }));
    String str = Build.MANUFACTURER;
    if ("HUAWEI".equals(str))
    {
      d();
      return;
    }
    if ("vivo".equals(str))
    {
      b("com.bairenkeji.icaller");
      return;
    }
    if ("OPPO".equals(str))
    {
      b("com.coloros.safecenter");
      return;
    }
    if ("Xiaomi".equals(str))
    {
      e();
      return;
    }
    c();
  }
  
  public void a(Intent paramIntent)
  {
    try
    {
      if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
      {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(paramIntent, 99999);
        return;
      }
      this.jdField_a_of_type_AndroidContentContext.startActivity(paramIntent);
      return;
    }
    catch (Throwable paramIntent)
    {
      paramIntent.printStackTrace();
      a(String.format("doStartApplicationWithPackageName [%s]", new Object[] { paramIntent.getMessage() }));
      c();
    }
  }
  
  public void b()
  {
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("url", "https://kf.qq.com/touch/faq/120307IVnEni150407eEv2IF.html?platform=14&_wv=0");
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult(localIntent, 99999);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PermissionPageUtil", 2, "openDefaultGuide");
      }
      return;
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azoy
 * JD-Core Version:    0.7.0.1
 */