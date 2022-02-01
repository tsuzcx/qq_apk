package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.kapalaiadapter.KapalaiAdapterUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.MobileIssueSettings;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.NativeUtil;

public class ScreenShot
  implements Handler.Callback, View.OnClickListener
{
  public static final String a;
  final Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Window jdField_a_of_type_AndroidViewWindow;
  Button jdField_a_of_type_AndroidWidgetButton;
  final ScreenShot.ScreenView jdField_a_of_type_ComTencentMobileqqAppScreenShot$ScreenView;
  public Object a;
  private boolean jdField_a_of_type_Boolean = false;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private final Handler jdField_b_of_type_AndroidOsHandler;
  Button jdField_b_of_type_AndroidWidgetButton;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  Button jdField_c_of_type_AndroidWidgetButton;
  public Bitmap d;
  Button d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/QQ_Screenshot/");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public ScreenShot(Context paramContext, Window paramWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if ((localContext instanceof Activity))
    {
      for (paramWindow = (Activity)localContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
      this.jdField_a_of_type_AndroidViewWindow = paramWindow.getWindow();
    }
    else
    {
      this.jdField_a_of_type_AndroidViewWindow = paramWindow;
    }
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849944);
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849943);
    this.jdField_a_of_type_ComTencentMobileqqAppScreenShot$ScreenView = new ScreenShot.ScreenView(this, this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
    if (Looper.getMainLooper() != Looper.myLooper()) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    } else {
      b();
    }
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_d_of_type_AndroidGraphicsBitmap = null;
  }
  
  public static void a(String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ScreenShot", 2, paramString);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetButton.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetButton.setVisibility(8);
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int k = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    int i = ((DisplayMetrics)localObject).widthPixels;
    int m = ((DisplayMetrics)localObject).heightPixels;
    if (((k == i) && (j == m)) || ((k == m) && (j == i)))
    {
      localObject = new int[k];
      paramBitmap.getPixels((int[])localObject, 0, k, 0, j / 2, k, 1);
      i = 0;
      while (i < k)
      {
        if (localObject[i] != -16777216) {
          return true;
        }
        i += 1;
      }
      localObject = new int[j];
      paramBitmap.getPixels((int[])localObject, 0, 1, k / 2, 0, 1, j);
      i = 0;
      while (i < j)
      {
        if (localObject[i] != -16777216) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131562766, null));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot$ScreenView, 0);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131376983));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367397));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364259));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365711));
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void c()
  {
    if (!b())
    {
      WindowManager localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      if (Build.VERSION.SDK_INT < 26) {
        localLayoutParams.type = 2003;
      } else {
        localLayoutParams.type = 2038;
      }
      localLayoutParams.format = 1;
      localLayoutParams.flags |= 0x100;
      try
      {
        if (((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(this.jdField_a_of_type_AndroidContentContext)) {
          localWindowManager.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
        } else {
          ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialogCustom(this.jdField_a_of_type_AndroidContentContext, 2131719169, 2131719168);
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ScreenShot", 2, "", localThrowable);
        }
      }
      a("ScreenShot show");
    }
  }
  
  private void d()
  {
    if (b()) {
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    } else if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(4)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    }
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
  }
  
  private boolean d()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current phone Build.Model is ");
      localStringBuilder.append(Build.MODEL);
      QLog.d("BaseActivity.ScreenShot", 2, localStringBuilder.toString());
    }
    return (!e()) && (!Build.MODEL.contains("Lenovo S810t")) && (!Build.MODEL.contains("OPPO R7005")) && (!Build.MODEL.contains(HardCodeUtil.a(2131713506))) && (!Build.MODEL.contains("vivo X5L")) && (!Build.MODEL.contains("OPPO N3")) && (!Build.MODEL.contains("OPPO R7")) && (!f());
  }
  
  private boolean e()
  {
    return (Build.MODEL.contains("Galaxy Nexus")) || (Build.MODEL.contains("HTC S720")) || (Build.MODEL.contains("SM-N9006")) || ((Build.MODEL.contains("ZTE U930")) && (Build.VERSION.SDK_INT == 16)) || ((Build.MODEL.contains("HTC One X")) && (Build.VERSION.SDK_INT == 16)) || ((Build.MODEL.contains("GT-I9260")) && (Build.VERSION.SDK_INT == 16)) || (Build.MODEL.contains("vivo Y18L")) || (Build.MODEL.contains("HM 1SW")) || (Build.MODEL.contains("DOOV S2y")) || (Build.MODEL.contains("H30-T10")) || (Build.MODEL.contains("vivo Y17T")) || (Build.MODEL.contains("HUAWEI B199")) || (Build.MODEL.contains("NX511J")) || (Build.MODEL.contains("vivo Y11iW")) || (Build.MODEL.contains("R809")) || (Build.MODEL.contains("V185")) || (Build.MODEL.contains("I9300"));
  }
  
  private boolean f()
  {
    boolean bool3 = Build.MANUFACTURER.contains("Meizu");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      if ((!Build.MODEL.contains("M351")) && (!Build.MODEL.contains("M353")) && (!Build.MODEL.contains("M355")) && (!Build.MODEL.contains("M356")) && (!Build.MODEL.contains("MX4")) && (!Build.MODEL.contains("MX4 Pro")))
      {
        bool1 = bool2;
        if (!Build.MODEL.contains("m2 note")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static native int snapScreen(int paramInt1, int paramInt2);
  
  public void a()
  {
    a("disactivate");
    d();
    ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "0", "", "", "");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    return (localViewGroup != null) && (localViewGroup.getParent() != null);
  }
  
  public boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot$ScreenView;
    ((ScreenShot.ScreenView)localObject).f = 0;
    ((ScreenShot.ScreenView)localObject).jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    a(false);
    if (d())
    {
      try
      {
        localObject = NativeUtil.screenshot(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        this.jdField_c_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!a(this.jdField_a_of_type_AndroidGraphicsBitmap)))
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = null;
          this.jdField_c_of_type_AndroidGraphicsBitmap = null;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShot", 2, "", localThrowable);
        }
      }
      a("ScreenShot activate");
    }
    boolean bool = this.jdField_a_of_type_AndroidContentContext instanceof Activity;
    if ((!bool) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
      return false;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
    String str;
    if (bool) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(null, "CliOper", "", "", "0X8005006", "0X8005006", 0, 0, str, "", "", "");
    return true;
  }
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 442	android/os/Message:what	I
    //   4: istore_2
    //   5: iload_2
    //   6: iconst_1
    //   7: if_icmpeq +277 -> 284
    //   10: iload_2
    //   11: iconst_2
    //   12: if_icmpeq +27 -> 39
    //   15: iload_2
    //   16: iconst_3
    //   17: if_icmpeq +16 -> 33
    //   20: iload_2
    //   21: iconst_4
    //   22: if_icmpeq +5 -> 27
    //   25: iconst_1
    //   26: ireturn
    //   27: aload_0
    //   28: invokespecial 120	com/tencent/mobileqq/app/ScreenShot:b	()V
    //   31: iconst_1
    //   32: ireturn
    //   33: aload_0
    //   34: invokespecial 444	com/tencent/mobileqq/app/ScreenShot:c	()V
    //   37: iconst_1
    //   38: ireturn
    //   39: aload_1
    //   40: getfield 447	android/os/Message:obj	Ljava/lang/Object;
    //   43: checkcast 86	com/tencent/mobileqq/app/ScreenShot$ScreenView
    //   46: astore 5
    //   48: new 449	java/io/File
    //   51: dup
    //   52: getstatic 47	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokespecial 451	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 454	java/io/File:exists	()Z
    //   63: ifne +8 -> 71
    //   66: aload_1
    //   67: invokevirtual 457	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: new 27	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: getstatic 47	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   83: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_1
    //   88: invokestatic 463	java/lang/System:currentTimeMillis	()J
    //   91: invokevirtual 466	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: ldc_w 468
    //   99: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 449	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 451	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore 4
    //   116: new 470	java/io/FileOutputStream
    //   119: dup
    //   120: aload 4
    //   122: invokespecial 473	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   125: astore_1
    //   126: aload 5
    //   128: getfield 474	com/tencent/mobileqq/app/ScreenShot$ScreenView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   131: getstatic 480	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   134: bipush 80
    //   136: aload_1
    //   137: invokevirtual 484	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   140: istore_3
    //   141: aload 5
    //   143: aconst_null
    //   144: putfield 474	com/tencent/mobileqq/app/ScreenShot$ScreenView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   147: aload_1
    //   148: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   151: goto +45 -> 196
    //   154: astore 4
    //   156: goto +7 -> 163
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_1
    //   163: aload 5
    //   165: aconst_null
    //   166: putfield 474	com/tencent/mobileqq/app/ScreenShot$ScreenView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   177: aload 4
    //   179: athrow
    //   180: aload 5
    //   182: aconst_null
    //   183: putfield 474	com/tencent/mobileqq/app/ScreenShot$ScreenView:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   186: aload_1
    //   187: ifnull +7 -> 194
    //   190: aload_1
    //   191: invokevirtual 487	java/io/FileOutputStream:close	()V
    //   194: iconst_0
    //   195: istore_3
    //   196: aload_0
    //   197: getfield 54	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   200: invokestatic 493	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   203: invokeinterface 499 1 0
    //   208: astore_1
    //   209: aload_1
    //   210: ldc_w 501
    //   213: aload 4
    //   215: invokestatic 507	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   218: invokevirtual 508	android/net/Uri:toString	()Ljava/lang/String;
    //   221: invokeinterface 514 3 0
    //   226: pop
    //   227: aload_1
    //   228: invokeinterface 517 1 0
    //   233: pop
    //   234: aload_0
    //   235: getfield 54	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   238: new 519	android/content/Intent
    //   241: dup
    //   242: ldc_w 521
    //   245: aload 4
    //   247: invokestatic 507	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   250: invokespecial 524	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   253: invokevirtual 528	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   256: aload_0
    //   257: getfield 104	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   260: astore_1
    //   261: iload_3
    //   262: ifeq +158 -> 420
    //   265: iconst_1
    //   266: istore_2
    //   267: goto +3 -> 270
    //   270: aload_1
    //   271: iconst_1
    //   272: iload_2
    //   273: iconst_0
    //   274: aload 5
    //   276: invokevirtual 532	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   279: invokevirtual 535	android/os/Message:sendToTarget	()V
    //   282: iconst_1
    //   283: ireturn
    //   284: aload_1
    //   285: getfield 538	android/os/Message:arg1	I
    //   288: iconst_1
    //   289: if_icmpne +83 -> 372
    //   292: aload_1
    //   293: getfield 447	android/os/Message:obj	Ljava/lang/Object;
    //   296: checkcast 86	com/tencent/mobileqq/app/ScreenShot$ScreenView
    //   299: astore_1
    //   300: aload_1
    //   301: ldc_w 539
    //   304: putfield 403	com/tencent/mobileqq/app/ScreenShot$ScreenView:f	I
    //   307: aload_0
    //   308: iconst_0
    //   309: invokespecial 132	com/tencent/mobileqq/app/ScreenShot:a	(Z)V
    //   312: aload_1
    //   313: invokevirtual 542	com/tencent/mobileqq/app/ScreenShot$ScreenView:invalidate	()V
    //   316: aload_1
    //   317: aconst_null
    //   318: new 544	com/tencent/mobileqq/app/ScreenShot$1
    //   321: dup
    //   322: aload_0
    //   323: aload_1
    //   324: invokespecial 547	com/tencent/mobileqq/app/ScreenShot$1:<init>	(Lcom/tencent/mobileqq/app/ScreenShot;Lcom/tencent/mobileqq/app/ScreenShot$ScreenView;)V
    //   327: invokestatic 552	android/os/SystemClock:uptimeMillis	()J
    //   330: ldc2_w 553
    //   333: ladd
    //   334: invokevirtual 558	com/tencent/mobileqq/app/ScreenShot$ScreenView:scheduleDrawable	(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    //   337: aload_0
    //   338: getfield 54	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   341: invokevirtual 562	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   344: aload_0
    //   345: getfield 54	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   348: ldc_w 563
    //   351: invokevirtual 566	android/content/Context:getString	(I)Ljava/lang/String;
    //   354: ldc_w 568
    //   357: getstatic 47	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   360: invokevirtual 572	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   363: iconst_1
    //   364: invokestatic 578	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   367: invokevirtual 581	android/widget/Toast:show	()V
    //   370: iconst_1
    //   371: ireturn
    //   372: aload_0
    //   373: getfield 54	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   376: invokevirtual 562	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   379: ldc_w 582
    //   382: iconst_1
    //   383: invokestatic 585	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   386: invokevirtual 581	android/widget/Toast:show	()V
    //   389: iconst_1
    //   390: ireturn
    //   391: astore_1
    //   392: iconst_1
    //   393: ireturn
    //   394: astore_1
    //   395: goto +20 -> 415
    //   398: astore 6
    //   400: goto -220 -> 180
    //   403: astore_1
    //   404: goto -208 -> 196
    //   407: astore_1
    //   408: goto -231 -> 177
    //   411: astore_1
    //   412: goto -218 -> 194
    //   415: aconst_null
    //   416: astore_1
    //   417: goto -237 -> 180
    //   420: iconst_0
    //   421: istore_2
    //   422: goto -152 -> 270
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	425	0	this	ScreenShot
    //   0	425	1	paramMessage	android.os.Message
    //   4	418	2	i	int
    //   140	122	3	bool	boolean
    //   114	7	4	localFile1	java.io.File
    //   154	1	4	localObject	Object
    //   159	87	4	localFile2	java.io.File
    //   46	229	5	localScreenView	ScreenShot.ScreenView
    //   398	1	6	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   126	141	154	finally
    //   116	126	159	finally
    //   39	71	391	java/lang/Exception
    //   71	116	391	java/lang/Exception
    //   141	147	391	java/lang/Exception
    //   147	151	391	java/lang/Exception
    //   163	169	391	java/lang/Exception
    //   173	177	391	java/lang/Exception
    //   177	180	391	java/lang/Exception
    //   180	186	391	java/lang/Exception
    //   190	194	391	java/lang/Exception
    //   196	261	391	java/lang/Exception
    //   270	282	391	java/lang/Exception
    //   116	126	394	java/io/FileNotFoundException
    //   126	141	398	java/io/FileNotFoundException
    //   147	151	403	java/io/IOException
    //   173	177	407	java/io/IOException
    //   190	194	411	java/io/IOException
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131376983: 
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot$ScreenView.a(false);
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
      }
      break;
    case 2131367397: 
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot$ScreenView.a(true);
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
      }
      break;
    case 2131365711: 
      a("click disable");
      d();
      ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "1", "", "", "");
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
      }
      break;
    case 2131364259: 
      a("click cancel");
      d();
      ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "2", "", "", "");
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.jdField_a_of_type_AndroidViewWindow);
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot
 * JD-Core Version:    0.7.0.1
 */