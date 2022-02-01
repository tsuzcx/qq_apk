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
  public static final String j;
  final Context a;
  Window b;
  Button c;
  Button d;
  Button e;
  Button f;
  Bitmap g;
  Bitmap h;
  Bitmap i;
  final ScreenShot.ScreenView k;
  Drawable l;
  Drawable m;
  public Bitmap n;
  public Object o;
  private final Handler p;
  private final Handler q;
  private ViewGroup r;
  private boolean s = false;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_ROOT);
    localStringBuilder.append("/QQ_Screenshot/");
    j = localStringBuilder.toString();
  }
  
  public ScreenShot(Context paramContext, Window paramWindow)
  {
    this.a = paramContext;
    Context localContext = this.a;
    if ((localContext instanceof Activity))
    {
      for (paramWindow = (Activity)localContext; paramWindow.getParent() != null; paramWindow = paramWindow.getParent()) {}
      this.b = paramWindow.getWindow();
    }
    else
    {
      this.b = paramWindow;
    }
    this.l = paramContext.getResources().getDrawable(2130851694);
    this.m = paramContext.getResources().getDrawable(2130851693);
    this.k = new ScreenShot.ScreenView(this, this.a);
    this.p = new Handler(Looper.getMainLooper(), this);
    this.q = new Handler(ThreadManager.getFileThreadLooper(), this);
    if (Looper.getMainLooper() != Looper.myLooper()) {
      this.p.sendEmptyMessage(4);
    } else {
      e();
    }
    this.o = new Object();
    this.n = null;
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
      this.c.setVisibility(8);
      this.d.setVisibility(8);
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      return;
    }
    this.c.setVisibility(0);
    this.d.setVisibility(0);
    this.e.setVisibility(8);
    this.f.setVisibility(8);
  }
  
  private boolean a(Bitmap paramBitmap)
  {
    int i3 = paramBitmap.getWidth();
    int i2 = paramBitmap.getHeight();
    Object localObject = this.a.getResources().getDisplayMetrics();
    int i1 = ((DisplayMetrics)localObject).widthPixels;
    int i4 = ((DisplayMetrics)localObject).heightPixels;
    if (((i3 == i1) && (i2 == i4)) || ((i3 == i4) && (i2 == i1)))
    {
      localObject = new int[i3];
      paramBitmap.getPixels((int[])localObject, 0, i3, 0, i2 / 2, i3, 1);
      i1 = 0;
      while (i1 < i3)
      {
        if (localObject[i1] != -16777216) {
          return true;
        }
        i1 += 1;
      }
      localObject = new int[i2];
      paramBitmap.getPixels((int[])localObject, 0, 1, i3 / 2, 0, 1, i2);
      i1 = 0;
      while (i1 < i2)
      {
        if (localObject[i1] != -16777216) {
          return true;
        }
        i1 += 1;
      }
    }
    return false;
  }
  
  private void e()
  {
    this.r = ((ViewGroup)((LayoutInflater)this.a.getSystemService("layout_inflater")).inflate(2131629211, null));
    this.r.addView(this.k, 0);
    this.e = ((Button)this.r.findViewById(2131445347));
    this.c = ((Button)this.r.findViewById(2131433897));
    this.f = ((Button)this.r.findViewById(2131430272));
    this.d = ((Button)this.r.findViewById(2131431951));
    this.f.setOnClickListener(this);
    this.e.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.s = true;
  }
  
  private void f()
  {
    if (!b())
    {
      WindowManager localWindowManager = (WindowManager)this.a.getSystemService("window");
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
        if (((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission(this.a)) {
          localWindowManager.addView(this.r, localLayoutParams);
        } else {
          ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).enterPermissionRequestDialogCustom(this.a, 2131916711, 2131916710);
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
  
  private void g()
  {
    if (b()) {
      ((WindowManager)this.a.getSystemService("window")).removeView(this.r);
    } else if (this.p.hasMessages(4)) {
      this.p.removeMessages(4);
    }
    this.i = null;
    this.g = null;
    this.h = null;
  }
  
  private boolean h()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("current phone Build.Model is ");
      localStringBuilder.append(Build.MODEL);
      QLog.d("BaseActivity.ScreenShot", 2, localStringBuilder.toString());
    }
    return (!i()) && (!Build.MODEL.contains("Lenovo S810t")) && (!Build.MODEL.contains("OPPO R7005")) && (!Build.MODEL.contains(HardCodeUtil.a(2131911056))) && (!Build.MODEL.contains("vivo X5L")) && (!Build.MODEL.contains("OPPO N3")) && (!Build.MODEL.contains("OPPO R7")) && (!j());
  }
  
  private boolean i()
  {
    return (Build.MODEL.contains("Galaxy Nexus")) || (Build.MODEL.contains("HTC S720")) || (Build.MODEL.contains("SM-N9006")) || ((Build.MODEL.contains("ZTE U930")) && (Build.VERSION.SDK_INT == 16)) || ((Build.MODEL.contains("HTC One X")) && (Build.VERSION.SDK_INT == 16)) || ((Build.MODEL.contains("GT-I9260")) && (Build.VERSION.SDK_INT == 16)) || (Build.MODEL.contains("vivo Y18L")) || (Build.MODEL.contains("HM 1SW")) || (Build.MODEL.contains("DOOV S2y")) || (Build.MODEL.contains("H30-T10")) || (Build.MODEL.contains("vivo Y17T")) || (Build.MODEL.contains("HUAWEI B199")) || (Build.MODEL.contains("NX511J")) || (Build.MODEL.contains("vivo Y11iW")) || (Build.MODEL.contains("R809")) || (Build.MODEL.contains("V185")) || (Build.MODEL.contains("I9300"));
  }
  
  private boolean j()
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
  
  public boolean a()
  {
    return this.s;
  }
  
  public boolean b()
  {
    ViewGroup localViewGroup = this.r;
    return (localViewGroup != null) && (localViewGroup.getParent() != null);
  }
  
  public boolean c()
  {
    Object localObject = this.k;
    ((ScreenShot.ScreenView)localObject).n = 0;
    ((ScreenShot.ScreenView)localObject).d.setEmpty();
    this.h = null;
    a(false);
    if (h())
    {
      try
      {
        localObject = NativeUtil.screenshot(this.a);
        this.g = ((Bitmap)localObject);
        this.i = ((Bitmap)localObject);
        if ((this.g != null) && (!a(this.g)))
        {
          this.g = null;
          this.i = null;
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
    boolean bool = this.a instanceof Activity;
    if ((!bool) && (this.g == null)) {
      return false;
    }
    this.p.sendEmptyMessage(3);
    String str;
    if (bool) {
      str = "1";
    } else {
      str = "0";
    }
    ReportController.b(null, "CliOper", "", "", "0X8005006", "0X8005006", 0, 0, str, "", "", "");
    return true;
  }
  
  public void d()
  {
    a("disactivate");
    g();
    ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "0", "", "", "");
  }
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 455	android/os/Message:what	I
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
    //   28: invokespecial 135	com/tencent/mobileqq/app/ScreenShot:e	()V
    //   31: iconst_1
    //   32: ireturn
    //   33: aload_0
    //   34: invokespecial 457	com/tencent/mobileqq/app/ScreenShot:f	()V
    //   37: iconst_1
    //   38: ireturn
    //   39: aload_1
    //   40: getfield 460	android/os/Message:obj	Ljava/lang/Object;
    //   43: checkcast 101	com/tencent/mobileqq/app/ScreenShot$ScreenView
    //   46: astore 5
    //   48: new 462	java/io/File
    //   51: dup
    //   52: getstatic 62	com/tencent/mobileqq/app/ScreenShot:j	Ljava/lang/String;
    //   55: invokespecial 464	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: astore_1
    //   59: aload_1
    //   60: invokevirtual 467	java/io/File:exists	()Z
    //   63: ifne +8 -> 71
    //   66: aload_1
    //   67: invokevirtual 470	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: new 42	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   78: astore_1
    //   79: aload_1
    //   80: getstatic 62	com/tencent/mobileqq/app/ScreenShot:j	Ljava/lang/String;
    //   83: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_1
    //   88: invokestatic 476	java/lang/System:currentTimeMillis	()J
    //   91: invokevirtual 479	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_1
    //   96: ldc_w 481
    //   99: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 462	java/io/File
    //   106: dup
    //   107: aload_1
    //   108: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 464	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore 4
    //   116: new 483	java/io/FileOutputStream
    //   119: dup
    //   120: aload 4
    //   122: invokespecial 486	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   125: astore_1
    //   126: aload 5
    //   128: getfield 488	com/tencent/mobileqq/app/ScreenShot$ScreenView:a	Landroid/graphics/Bitmap;
    //   131: getstatic 494	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   134: bipush 80
    //   136: aload_1
    //   137: invokevirtual 498	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   140: istore_3
    //   141: aload 5
    //   143: aconst_null
    //   144: putfield 488	com/tencent/mobileqq/app/ScreenShot$ScreenView:a	Landroid/graphics/Bitmap;
    //   147: aload_1
    //   148: invokevirtual 501	java/io/FileOutputStream:close	()V
    //   151: goto +45 -> 196
    //   154: astore 4
    //   156: goto +7 -> 163
    //   159: astore 4
    //   161: aconst_null
    //   162: astore_1
    //   163: aload 5
    //   165: aconst_null
    //   166: putfield 488	com/tencent/mobileqq/app/ScreenShot$ScreenView:a	Landroid/graphics/Bitmap;
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 501	java/io/FileOutputStream:close	()V
    //   177: aload 4
    //   179: athrow
    //   180: aload 5
    //   182: aconst_null
    //   183: putfield 488	com/tencent/mobileqq/app/ScreenShot$ScreenView:a	Landroid/graphics/Bitmap;
    //   186: aload_1
    //   187: ifnull +7 -> 194
    //   190: aload_1
    //   191: invokevirtual 501	java/io/FileOutputStream:close	()V
    //   194: iconst_0
    //   195: istore_3
    //   196: aload_0
    //   197: getfield 69	com/tencent/mobileqq/app/ScreenShot:a	Landroid/content/Context;
    //   200: invokestatic 507	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   203: invokeinterface 513 1 0
    //   208: astore_1
    //   209: aload_1
    //   210: ldc_w 515
    //   213: aload 4
    //   215: invokestatic 521	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   218: invokevirtual 522	android/net/Uri:toString	()Ljava/lang/String;
    //   221: invokeinterface 528 3 0
    //   226: pop
    //   227: aload_1
    //   228: invokeinterface 531 1 0
    //   233: pop
    //   234: aload_0
    //   235: getfield 69	com/tencent/mobileqq/app/ScreenShot:a	Landroid/content/Context;
    //   238: new 533	android/content/Intent
    //   241: dup
    //   242: ldc_w 535
    //   245: aload 4
    //   247: invokestatic 521	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   250: invokespecial 538	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
    //   253: invokevirtual 542	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   256: aload_0
    //   257: getfield 119	com/tencent/mobileqq/app/ScreenShot:p	Landroid/os/Handler;
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
    //   276: invokevirtual 546	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   279: invokevirtual 549	android/os/Message:sendToTarget	()V
    //   282: iconst_1
    //   283: ireturn
    //   284: aload_1
    //   285: getfield 552	android/os/Message:arg1	I
    //   288: iconst_1
    //   289: if_icmpne +83 -> 372
    //   292: aload_1
    //   293: getfield 460	android/os/Message:obj	Ljava/lang/Object;
    //   296: checkcast 101	com/tencent/mobileqq/app/ScreenShot$ScreenView
    //   299: astore_1
    //   300: aload_1
    //   301: ldc_w 553
    //   304: putfield 403	com/tencent/mobileqq/app/ScreenShot$ScreenView:n	I
    //   307: aload_0
    //   308: iconst_0
    //   309: invokespecial 146	com/tencent/mobileqq/app/ScreenShot:a	(Z)V
    //   312: aload_1
    //   313: invokevirtual 556	com/tencent/mobileqq/app/ScreenShot$ScreenView:invalidate	()V
    //   316: aload_1
    //   317: aconst_null
    //   318: new 558	com/tencent/mobileqq/app/ScreenShot$1
    //   321: dup
    //   322: aload_0
    //   323: aload_1
    //   324: invokespecial 561	com/tencent/mobileqq/app/ScreenShot$1:<init>	(Lcom/tencent/mobileqq/app/ScreenShot;Lcom/tencent/mobileqq/app/ScreenShot$ScreenView;)V
    //   327: invokestatic 566	android/os/SystemClock:uptimeMillis	()J
    //   330: ldc2_w 567
    //   333: ladd
    //   334: invokevirtual 572	com/tencent/mobileqq/app/ScreenShot$ScreenView:scheduleDrawable	(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    //   337: aload_0
    //   338: getfield 69	com/tencent/mobileqq/app/ScreenShot:a	Landroid/content/Context;
    //   341: invokevirtual 576	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   344: aload_0
    //   345: getfield 69	com/tencent/mobileqq/app/ScreenShot:a	Landroid/content/Context;
    //   348: ldc_w 577
    //   351: invokevirtual 580	android/content/Context:getString	(I)Ljava/lang/String;
    //   354: ldc_w 582
    //   357: getstatic 62	com/tencent/mobileqq/app/ScreenShot:j	Ljava/lang/String;
    //   360: invokevirtual 586	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   363: iconst_1
    //   364: invokestatic 592	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   367: invokevirtual 595	android/widget/Toast:show	()V
    //   370: iconst_1
    //   371: ireturn
    //   372: aload_0
    //   373: getfield 69	com/tencent/mobileqq/app/ScreenShot:a	Landroid/content/Context;
    //   376: invokevirtual 576	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   379: ldc_w 596
    //   382: iconst_1
    //   383: invokestatic 599	android/widget/Toast:makeText	(Landroid/content/Context;II)Landroid/widget/Toast;
    //   386: invokevirtual 595	android/widget/Toast:show	()V
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
    //   4	418	2	i1	int
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
    case 2131445347: 
      this.k.a(false);
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.b);
      }
      break;
    case 2131433897: 
      this.k.a(true);
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.b);
      }
      break;
    case 2131431951: 
      a("click disable");
      g();
      ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "1", "", "", "");
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.b);
      }
      break;
    case 2131430272: 
      a("click cancel");
      g();
      ReportController.b(null, "CliOper", "", "", "0X8005008", "0X8005008", 0, 0, "2", "", "", "");
      if ((!MobileIssueSettings.g) && (Build.VERSION.SDK_INT < 11)) {
        KapalaiAdapterUtil.a().b(this.b);
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot
 * JD-Core Version:    0.7.0.1
 */