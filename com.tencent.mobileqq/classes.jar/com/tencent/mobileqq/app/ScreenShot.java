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
import anvx;
import aodd;
import bdla;
import bhkk;
import bhkn;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.NativeUtil;

public class ScreenShot
  implements Handler.Callback, View.OnClickListener
{
  public static final String a;
  public final Context a;
  public Bitmap a;
  public Drawable a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public Window a;
  public Button a;
  final aodd jdField_a_of_type_Aodd;
  public Object a;
  private boolean jdField_a_of_type_Boolean;
  public Bitmap b;
  public Drawable b;
  private final Handler b;
  public Button b;
  public Bitmap c;
  public Button c;
  public Bitmap d;
  public Button d;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.SDCARD_ROOT + "/QQ_Screenshot/";
  }
  
  public ScreenShot(Context paramContext, Window paramWindow)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      for (paramWindow = (Activity)this.jdField_a_of_type_AndroidContentContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
      this.jdField_a_of_type_AndroidViewWindow = paramWindow.getWindow();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849622);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130849621);
      this.jdField_a_of_type_Aodd = new aodd(this, this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
      this.jdField_b_of_type_AndroidOsHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
      if (Looper.getMainLooper() == Looper.myLooper()) {
        break label165;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangObject = new Object();
      this.jdField_d_of_type_AndroidGraphicsBitmap = null;
      return;
      this.jdField_a_of_type_AndroidViewWindow = paramWindow;
      break;
      label165:
      b();
    }
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
      for (;;)
      {
        if (i >= j) {
          break label151;
        }
        if (localObject[i] != -16777216) {
          break;
        }
        i += 1;
      }
    }
    label151:
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater")).inflate(2131562800, null));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_Aodd, 0);
    this.jdField_c_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377121));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131367455));
    this.jdField_d_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364250));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365711));
    this.jdField_d_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void c()
  {
    WindowManager localWindowManager;
    WindowManager.LayoutParams localLayoutParams;
    if (!b())
    {
      localWindowManager = (WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window");
      localLayoutParams = new WindowManager.LayoutParams();
      if (Build.VERSION.SDK_INT >= 26) {
        break label87;
      }
      localLayoutParams.type = 2003;
    }
    for (;;)
    {
      localLayoutParams.format = 1;
      localLayoutParams.flags |= 0x100;
      try
      {
        if (FloatingScreenPermission.checkPermission(this.jdField_a_of_type_AndroidContentContext)) {
          localWindowManager.addView(this.jdField_a_of_type_AndroidViewViewGroup, localLayoutParams);
        }
        for (;;)
        {
          a("ScreenShot show");
          return;
          label87:
          localLayoutParams.type = 2038;
          break;
          FloatingScreenPermission.enterPermissionRequestDialogCustom(this.jdField_a_of_type_AndroidContentContext, 2131718924, 2131718923);
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("ScreenShot", 2, "", localThrowable);
          }
        }
      }
    }
  }
  
  private void d()
  {
    if (b()) {
      ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window")).removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    for (;;)
    {
      this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      this.jdField_b_of_type_AndroidGraphicsBitmap = null;
      return;
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(4)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      }
    }
  }
  
  private boolean d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseActivity.ScreenShot", 2, "current phone Build.Model is " + Build.MODEL);
    }
    return (!e()) && (!Build.MODEL.contains("Lenovo S810t")) && (!Build.MODEL.contains("OPPO R7005")) && (!Build.MODEL.contains(anvx.a(2131713043))) && (!Build.MODEL.contains("vivo X5L")) && (!Build.MODEL.contains("OPPO N3")) && (!Build.MODEL.contains("OPPO R7")) && (!f());
  }
  
  private boolean e()
  {
    return (Build.MODEL.contains("Galaxy Nexus")) || (Build.MODEL.contains("HTC S720")) || (Build.MODEL.contains("SM-N9006")) || ((Build.MODEL.contains("ZTE U930")) && (Build.VERSION.SDK_INT == 16)) || ((Build.MODEL.contains("HTC One X")) && (Build.VERSION.SDK_INT == 16)) || ((Build.MODEL.contains("GT-I9260")) && (Build.VERSION.SDK_INT == 16)) || (Build.MODEL.contains("vivo Y18L")) || (Build.MODEL.contains("HM 1SW")) || (Build.MODEL.contains("DOOV S2y")) || (Build.MODEL.contains("H30-T10")) || (Build.MODEL.contains("vivo Y17T")) || (Build.MODEL.contains("HUAWEI B199")) || (Build.MODEL.contains("NX511J")) || (Build.MODEL.contains("vivo Y11iW")) || (Build.MODEL.contains("R809")) || (Build.MODEL.contains("V185")) || (Build.MODEL.contains("I9300"));
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (Build.MANUFACTURER.contains("Meizu")) {
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
    bdla.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "0", "", "", "");
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getParent() != null);
  }
  
  public boolean c()
  {
    this.jdField_a_of_type_Aodd.f = 0;
    this.jdField_a_of_type_Aodd.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    a(false);
    if (d()) {}
    try
    {
      Bitmap localBitmap = NativeUtil.screenshot(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
      this.jdField_c_of_type_AndroidGraphicsBitmap = localBitmap;
      if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!a(this.jdField_a_of_type_AndroidGraphicsBitmap)))
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        this.jdField_c_of_type_AndroidGraphicsBitmap = null;
      }
      a("ScreenShot activate");
      bool = this.jdField_a_of_type_AndroidContentContext instanceof Activity;
      if ((!bool) && (this.jdField_a_of_type_AndroidGraphicsBitmap == null)) {
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      boolean bool;
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShot", 2, "", localThrowable);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
      if (!bool) {}
    }
    for (String str = "1";; str = "0")
    {
      bdla.b(null, "CliOper", "", "", "0X8005006", "0X8005006", 0, 0, str, "", "", "");
      return true;
    }
  }
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_1
    //   4: getfield 436	android/os/Message:what	I
    //   7: tableswitch	default:+29 -> 36, 1:+43->50, 2:+150->157, 3:+37->44, 4:+31->38
    //   37: ireturn
    //   38: aload_0
    //   39: invokespecial 122	com/tencent/mobileqq/app/ScreenShot:b	()V
    //   42: iconst_1
    //   43: ireturn
    //   44: aload_0
    //   45: invokespecial 438	com/tencent/mobileqq/app/ScreenShot:c	()V
    //   48: iconst_1
    //   49: ireturn
    //   50: aload_1
    //   51: getfield 441	android/os/Message:arg1	I
    //   54: iconst_1
    //   55: if_icmpne +83 -> 138
    //   58: aload_1
    //   59: getfield 444	android/os/Message:obj	Ljava/lang/Object;
    //   62: checkcast 84	aodd
    //   65: astore_1
    //   66: aload_1
    //   67: ldc_w 445
    //   70: putfield 397	aodd:f	I
    //   73: aload_0
    //   74: iconst_0
    //   75: invokespecial 130	com/tencent/mobileqq/app/ScreenShot:a	(Z)V
    //   78: aload_1
    //   79: invokevirtual 448	aodd:invalidate	()V
    //   82: aload_1
    //   83: aconst_null
    //   84: new 450	com/tencent/mobileqq/app/ScreenShot$1
    //   87: dup
    //   88: aload_0
    //   89: aload_1
    //   90: invokespecial 453	com/tencent/mobileqq/app/ScreenShot$1:<init>	(Lcom/tencent/mobileqq/app/ScreenShot;Laodd;)V
    //   93: invokestatic 459	android/os/SystemClock:uptimeMillis	()J
    //   96: ldc2_w 460
    //   99: ladd
    //   100: invokevirtual 465	aodd:scheduleDrawable	(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    //   103: aload_0
    //   104: getfield 52	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   107: invokevirtual 469	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   110: aload_0
    //   111: getfield 52	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   114: ldc_w 470
    //   117: invokevirtual 473	android/content/Context:getString	(I)Ljava/lang/String;
    //   120: ldc_w 475
    //   123: getstatic 47	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   126: invokevirtual 479	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   129: iconst_1
    //   130: invokestatic 485	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   133: invokevirtual 488	android/widget/Toast:show	()V
    //   136: iconst_1
    //   137: ireturn
    //   138: aload_0
    //   139: getfield 52	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   142: invokevirtual 469	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   145: ldc_w 489
    //   148: iconst_1
    //   149: invokestatic 492	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   152: invokevirtual 488	android/widget/Toast:show	()V
    //   155: iconst_1
    //   156: ireturn
    //   157: aload_1
    //   158: getfield 444	android/os/Message:obj	Ljava/lang/Object;
    //   161: checkcast 84	aodd
    //   164: astore 6
    //   166: new 494	java/io/File
    //   169: dup
    //   170: getstatic 47	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   173: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 499	java/io/File:exists	()Z
    //   181: ifne +8 -> 189
    //   184: aload_1
    //   185: invokevirtual 502	java/io/File:mkdirs	()Z
    //   188: pop
    //   189: new 494	java/io/File
    //   192: dup
    //   193: new 27	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   200: getstatic 47	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   203: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: invokestatic 507	java/lang/System:currentTimeMillis	()J
    //   209: invokevirtual 510	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   212: ldc_w 512
    //   215: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 45	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokespecial 496	java/io/File:<init>	(Ljava/lang/String;)V
    //   224: astore 5
    //   226: aload 5
    //   228: ifnull +197 -> 425
    //   231: new 514	java/io/FileOutputStream
    //   234: dup
    //   235: aload 5
    //   237: invokespecial 517	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   240: astore_1
    //   241: aload 6
    //   243: getfield 518	aodd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   246: getstatic 524	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   249: bipush 80
    //   251: aload_1
    //   252: invokevirtual 528	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   255: istore_3
    //   256: aload 6
    //   258: aconst_null
    //   259: putfield 518	aodd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   262: aload_1
    //   263: ifnull +167 -> 430
    //   266: aload_1
    //   267: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   270: aload_0
    //   271: getfield 52	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   274: invokestatic 537	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   277: invokeinterface 543 1 0
    //   282: astore_1
    //   283: aload_1
    //   284: ldc_w 545
    //   287: aload 5
    //   289: invokestatic 551	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   292: invokevirtual 552	android/net/Uri:toString	()Ljava/lang/String;
    //   295: invokeinterface 558 3 0
    //   300: pop
    //   301: aload_1
    //   302: invokeinterface 561 1 0
    //   307: pop
    //   308: aload_0
    //   309: getfield 52	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   312: new 563	android/content/Intent
    //   315: dup
    //   316: ldc_w 565
    //   319: aload 5
    //   321: invokestatic 551	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   324: invokespecial 568	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   327: invokevirtual 572	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   330: aload_0
    //   331: getfield 102	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   334: astore_1
    //   335: iload_3
    //   336: ifeq +63 -> 399
    //   339: iconst_1
    //   340: istore_2
    //   341: aload_1
    //   342: iconst_1
    //   343: iload_2
    //   344: iconst_0
    //   345: aload 6
    //   347: invokevirtual 576	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   350: invokevirtual 579	android/os/Message:sendToTarget	()V
    //   353: iconst_1
    //   354: ireturn
    //   355: aload 6
    //   357: aconst_null
    //   358: putfield 518	aodd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   361: aload_1
    //   362: ifnull +63 -> 425
    //   365: aload_1
    //   366: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   369: iconst_0
    //   370: istore_3
    //   371: goto -101 -> 270
    //   374: astore_1
    //   375: iconst_0
    //   376: istore_3
    //   377: goto -107 -> 270
    //   380: astore_1
    //   381: aload 6
    //   383: aconst_null
    //   384: putfield 518	aodd:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   387: aload 4
    //   389: ifnull +8 -> 397
    //   392: aload 4
    //   394: invokevirtual 531	java/io/FileOutputStream:close	()V
    //   397: aload_1
    //   398: athrow
    //   399: iconst_0
    //   400: istore_2
    //   401: goto -60 -> 341
    //   404: astore 4
    //   406: goto -9 -> 397
    //   409: astore 5
    //   411: aload_1
    //   412: astore 4
    //   414: aload 5
    //   416: astore_1
    //   417: goto -36 -> 381
    //   420: astore 4
    //   422: goto -67 -> 355
    //   425: iconst_0
    //   426: istore_3
    //   427: goto -157 -> 270
    //   430: goto -160 -> 270
    //   433: astore_1
    //   434: iconst_1
    //   435: ireturn
    //   436: astore_1
    //   437: goto -167 -> 270
    //   440: astore_1
    //   441: aconst_null
    //   442: astore_1
    //   443: goto -88 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	ScreenShot
    //   0	446	1	paramMessage	android.os.Message
    //   340	61	2	i	int
    //   255	172	3	bool	boolean
    //   1	392	4	localObject1	Object
    //   404	1	4	localIOException	java.io.IOException
    //   412	1	4	localMessage	android.os.Message
    //   420	1	4	localFileNotFoundException	java.io.FileNotFoundException
    //   224	96	5	localFile	java.io.File
    //   409	6	5	localObject2	Object
    //   164	218	6	localaodd	aodd
    // Exception table:
    //   from	to	target	type
    //   365	369	374	java/io/IOException
    //   231	241	380	finally
    //   392	397	404	java/io/IOException
    //   241	256	409	finally
    //   241	256	420	java/io/FileNotFoundException
    //   157	189	433	java/lang/Exception
    //   189	226	433	java/lang/Exception
    //   256	262	433	java/lang/Exception
    //   266	270	433	java/lang/Exception
    //   270	335	433	java/lang/Exception
    //   341	353	433	java/lang/Exception
    //   355	361	433	java/lang/Exception
    //   365	369	433	java/lang/Exception
    //   381	387	433	java/lang/Exception
    //   392	397	433	java/lang/Exception
    //   397	399	433	java/lang/Exception
    //   266	270	436	java/io/IOException
    //   231	241	440	java/io/FileNotFoundException
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_Aodd.a(true);
      if ((!bhkn.g) && (Build.VERSION.SDK_INT < 11))
      {
        bhkk.a().b(this.jdField_a_of_type_AndroidViewWindow);
        continue;
        this.jdField_a_of_type_Aodd.a(false);
        if ((!bhkn.g) && (Build.VERSION.SDK_INT < 11))
        {
          bhkk.a().b(this.jdField_a_of_type_AndroidViewWindow);
          continue;
          a("click disable");
          d();
          bdla.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "1", "", "", "");
          if ((!bhkn.g) && (Build.VERSION.SDK_INT < 11))
          {
            bhkk.a().b(this.jdField_a_of_type_AndroidViewWindow);
            continue;
            a("click cancel");
            d();
            bdla.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "2", "", "", "");
            if ((!bhkn.g) && (Build.VERSION.SDK_INT < 11)) {
              bhkk.a().b(this.jdField_a_of_type_AndroidViewWindow);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot
 * JD-Core Version:    0.7.0.1
 */