package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.Timer;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  private TextView[] A;
  private ImageView[] B;
  private View[] C;
  private String D = "";
  private String E = "";
  private String F = "";
  private String G = "86";
  private TextView H;
  private QQProgressDialog I;
  private Timer J = null;
  private MqqHandler K = new RegisterActivity.11(this);
  private final int L = 0;
  private final int M = 1;
  private final int N = 2;
  private final int O = 3;
  private final int P = 4;
  private final int Q = 5;
  private final int R = -1;
  private AccountObserver S = new RegisterActivity.13(this);
  byte a = 0;
  Dialog b;
  String c = "";
  int d = 30;
  String e;
  final int f = -1;
  final int g = 1;
  final int h = 2;
  final int i = 3;
  final int j = 4;
  final int k = 5;
  final int l = 6;
  final int m = 7;
  final int n = 8;
  final int o = 9;
  Handler p = new RegisterActivity.12(this);
  private final byte q = 0;
  private final byte r = 1;
  private final byte s = 2;
  private final byte t = 3;
  private final byte u = 4;
  private final byte v = 5;
  private final byte w = 6;
  private final int x = 30;
  private String y;
  private Button z;
  
  private void a(int paramInt)
  {
    if (paramInt < this.A.length)
    {
      int i1 = 0;
      for (;;)
      {
        TextView[] arrayOfTextView = this.A;
        if (i1 >= arrayOfTextView.length) {
          break;
        }
        if (i1 == paramInt)
        {
          arrayOfTextView[i1].setTextColor(-16777216);
          this.C[i1].setVisibility(0);
        }
        else
        {
          arrayOfTextView[i1].setTextColor(-7829368);
          this.C[i1].setVisibility(4);
        }
        i1 += 1;
      }
    }
    if (paramInt >= 1) {
      this.B[(paramInt - 1)].setVisibility(0);
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      if (this.J != null)
      {
        this.J.cancel();
        this.J = null;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reQuerySms time = ");
        localStringBuilder.append(paramLong);
        QLog.d("", 2, localStringBuilder.toString());
      }
      this.J = new Timer();
      this.J.schedule(new RegisterActivity.9(this, paramLong), paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void b(int paramInt)
  {
    this.b = new ReportDialog(this, 2131953338);
    this.b.setContentView(2131623999);
    ((TextView)this.b.findViewById(2131431876)).setText(getString(paramInt));
    this.b.show();
  }
  
  private void c(String paramString)
  {
    try
    {
      if (this.I == null) {
        this.I = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.I.a(paramString);
      this.I.setOnKeyListener(new RegisterActivity.5(this));
      this.I.show();
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void d(String paramString)
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.G, this.y, null, Long.valueOf(AppSetting.d()), "8.8.17", new Bundle(), this.S);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    this.z = ((Button)findViewById(2131430116));
    this.z.setOnClickListener(this);
    this.A = new TextView[3];
    this.A[0] = ((TextView)findViewById(2131449356));
    this.A[1] = ((TextView)findViewById(2131445695));
    this.A[2] = ((TextView)findViewById(2131444593));
    this.B = new ImageView[2];
    this.B[0] = ((ImageView)findViewById(2131449355));
    this.B[1] = ((ImageView)findViewById(2131445694));
    this.C = new View[3];
    this.C[0] = findViewById(2131449348);
    this.C[1] = findViewById(2131445693);
    this.C[2] = findViewById(2131444591);
    TextView localTextView = (TextView)findViewById(2131440779);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(this);
    localTextView.getPaint().setFlags(8);
    a(0);
    f();
    this.e = getIntent().getStringExtra("uin");
  }
  
  private boolean e(String paramString)
  {
    int i2 = paramString.length();
    if ((i2 >= 6) && (i2 <= 16)) {}
    try
    {
      Integer.parseInt(paramString);
      i1 = 1;
    }
    catch (Exception paramString)
    {
      int i1;
      label30:
      break label30;
    }
    i1 = 0;
    if ((i2 <= 9) && (i1 != 0))
    {
      Toast.makeText(getApplicationContext(), 2131914053, 0).show();
      return false;
    }
    return true;
    Toast.makeText(getApplicationContext(), 2131914052, 0).show();
    return false;
  }
  
  private void f()
  {
    this.H = ((TextView)findViewById(2131437682));
    TextView localTextView = this.H;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(this.G);
    localStringBuilder.append(HardCodeUtil.a(2131910838));
    localTextView.setText(localStringBuilder.toString());
    findViewById(2131430472).setOnClickListener(this);
  }
  
  private void g()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131914069));
    localQQCustomDialog.setMessage(getString(2131914027));
    RegisterActivity.1 local1 = new RegisterActivity.1(this);
    RegisterActivity.2 local2 = new RegisterActivity.2(this);
    localQQCustomDialog.setPositiveButton(2131892267, local1);
    localQQCustomDialog.setNegativeButton(2131887648, local2);
    localQQCustomDialog.show();
  }
  
  private void h()
  {
    this.p.post(new RegisterActivity.6(this));
  }
  
  private void i()
  {
    try
    {
      if (this.J != null)
      {
        this.J.cancel();
        this.J = null;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void j()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).queryUpSmsStat(this.S);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    if (t())
    {
      if (!s()) {
        return;
      }
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.G, this.y, this.S);
        b(2131914100);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void l()
  {
    findViewById(2131438788).setVisibility(8);
    findViewById(2131449354).setVisibility(0);
    ((TextView)findViewById(2131444569)).setOnClickListener(this);
    this.p.sendEmptyMessage(4);
    this.z.setText(2131914020);
  }
  
  private void m()
  {
    Object localObject = ((EditText)findViewById(2131449347)).getText();
    if (localObject != null)
    {
      this.D = localObject.toString();
      localObject = this.D;
      if (localObject != null) {
        this.D = ((String)localObject).trim();
      }
    }
    localObject = this.D;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterByCommitSmsVerifycode(this.D, this.S);
        b(2131914022);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(getApplicationContext(), 2131914033, 0).show();
  }
  
  private void n()
  {
    this.d = 0;
    findViewById(2131438788).setVisibility(8);
    findViewById(2131449354).setVisibility(8);
    findViewById(2131439865).setVisibility(0);
    a(1);
    this.z.setText(2131914019);
  }
  
  private void o()
  {
    Object localObject1 = ((EditText)findViewById(2131439858)).getText();
    Object localObject3 = null;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject1.toString();
      localObject1 = localObject2;
      if (localObject2 != null) {
        localObject1 = ((String)localObject2).trim();
      }
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        Toast.makeText(getApplicationContext(), 2131914059, 0).show();
      }
    }
    else
    {
      localObject2 = null;
    }
    localObject1 = ((EditText)findViewById(2131444196)).getText();
    if (localObject1 != null)
    {
      localObject3 = localObject1.toString();
      localObject1 = localObject3;
      if (localObject3 != null) {
        localObject1 = ((String)localObject3).trim();
      }
      if (localObject1 != null)
      {
        localObject3 = localObject1;
        if (((String)localObject1).length() > 0) {}
      }
      else
      {
        Toast.makeText(getApplicationContext(), 2131914057, 0).show();
        return;
      }
    }
    if ((localObject2 != null) && (((String)localObject2).equals(localObject3)))
    {
      if (!e((String)localObject2)) {
        return;
      }
      try
      {
        this.F = ((String)localObject2);
        b(2131914021);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(getApplicationContext(), 2131914051, 0).show();
  }
  
  private void p()
  {
    findViewById(2131439865).setVisibility(8);
    findViewById(2131444592).setVisibility(0);
    a(2);
    ((TextView)findViewById(2131439108)).setText(this.E);
    this.z.setText(2131914039);
    this.p.sendEmptyMessageDelayed(3, 200L);
  }
  
  private void q()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.E);
    localIntent.putExtra("password", this.F);
    localIntent.addFlags(131072);
    RouteUtils.a(this, localIntent, "/base/login");
    finish();
  }
  
  private void r()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.S);
      ((TextView)findViewById(2131447380)).setVisibility(0);
      ((TextView)findViewById(2131444569)).setVisibility(8);
      b();
      b(2131914022);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private boolean s()
  {
    boolean bool = ((CheckBox)findViewById(2131444201)).isChecked();
    if (!bool) {
      Toast.makeText(getApplicationContext(), 2131914058, 0).show();
    }
    return bool;
  }
  
  private boolean t()
  {
    Editable localEditable = ((EditText)findViewById(2131438787)).getText();
    if (localEditable != null) {
      i1 = 3;
    }
    try
    {
      if (("852".equals(this.G)) || ("853".equals(this.G))) {
        break label166;
      }
      if ("886".equals(this.G)) {
        i1 = 9;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        boolean bool2;
        boolean bool3;
        continue;
        i1 = 6;
        continue;
        boolean bool1 = true;
      }
    }
    this.y = localEditable.toString().trim();
    Long.parseLong(this.y);
    if (this.y.length() < i1)
    {
      bool1 = false;
      bool2 = bool1;
      if (!this.y.startsWith("1"))
      {
        bool3 = "86".equals(this.G);
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
      if (!bool2) {
        Toast.makeText(getApplicationContext(), 2131914056, 0).show();
      }
      return bool2;
    }
  }
  
  void a()
  {
    int i2 = this.a;
    int i1 = 0;
    switch (i2)
    {
    default: 
      break;
    case 6: 
      q();
      break;
    case 5: 
      p();
      break;
    case 4: 
      o();
      break;
    case 3: 
      n();
      break;
    case 2: 
      m();
      break;
    case 1: 
      l();
      i1 = 1;
      break;
    }
    d(null);
    if (i1 != 0) {
      this.a = ((byte)(this.a + 1));
    }
  }
  
  void a(String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return;
      }
      Object localObject = paramString;
      if (!paramString.startsWith("http://"))
      {
        localObject = paramString;
        if (!paramString.startsWith("https://"))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https://");
          ((StringBuilder)localObject).append(paramString);
          localObject = ((StringBuilder)localObject).toString();
        }
      }
      paramString = DialogUtil.a(this, 230);
      paramString.setTitle(2131914117);
      paramString.setMessage(2131914118);
      paramString.setPositiveButton(2131892267, new RegisterActivity.3(this, (String)localObject));
      paramString.show();
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString1.length() <= 0) {
        return;
      }
      if (paramString2 != null)
      {
        if (paramString2.length() <= 0) {
          return;
        }
        QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
        localQQCustomDialog.setTitle(2131914117);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131910843));
        localStringBuilder.append(paramString2);
        localStringBuilder.append(HardCodeUtil.a(2131910825));
        localStringBuilder.append(paramString1);
        localStringBuilder.append(HardCodeUtil.a(2131910839));
        localQQCustomDialog.setMessage(localStringBuilder.toString());
        localQQCustomDialog.setPositiveButton(2131892267, new RegisterActivity.4(this, paramString2, paramString1));
        localQQCustomDialog.show();
      }
    }
  }
  
  void b()
  {
    if (this.d <= 0)
    {
      this.d = 30;
      ((TextView)findViewById(2131447380)).setVisibility(8);
      ((TextView)findViewById(2131444569)).setVisibility(0);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131447380);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(getResources().getString(2131914110));
    localTextView.setText(localStringBuilder.toString());
    this.d -= 1;
    this.p.sendEmptyMessageDelayed(4, 1000L);
  }
  
  void b(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    this.p.sendMessage(localMessage);
  }
  
  void b(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    paramString1 = new RegisterActivity.7(this);
    paramString2 = new RegisterActivity.8(this);
    localQQCustomDialog.setPositiveButton(2131892267, paramString1);
    localQQCustomDialog.setNegativeButton(2131430272, paramString2);
    localQQCustomDialog.show();
  }
  
  void c()
  {
    this.p.post(new RegisterActivity.10(this));
  }
  
  void c(String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 7;
    Bundle localBundle = new Bundle();
    localBundle.putString("telNum", paramString1);
    localBundle.putString("msg", paramString2);
    localMessage.setData(localBundle);
    this.p.sendMessage(localMessage);
  }
  
  /* Error */
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 625	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 672	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   7: getfield 677	android/util/DisplayMetrics:widthPixels	I
    //   10: aload_0
    //   11: invokevirtual 625	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   14: invokevirtual 672	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   17: getfield 680	android/util/DisplayMetrics:heightPixels	I
    //   20: getstatic 686	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 692	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore 4
    //   28: new 694	android/graphics/Canvas
    //   31: dup
    //   32: aload 4
    //   34: invokespecial 697	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   37: astore_1
    //   38: aload_0
    //   39: invokevirtual 701	com/tencent/mobileqq/activity/RegisterActivity:getWindow	()Landroid/view/Window;
    //   42: invokevirtual 707	android/view/Window:getDecorView	()Landroid/view/View;
    //   45: aload_1
    //   46: invokevirtual 711	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   49: new 713	java/io/File
    //   52: dup
    //   53: getstatic 717	com/tencent/mobileqq/app/ScreenShot:j	Ljava/lang/String;
    //   56: invokespecial 719	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 722	java/io/File:exists	()Z
    //   64: ifne +8 -> 72
    //   67: aload_1
    //   68: invokevirtual 725	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: new 196	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: getstatic 717	com/tencent/mobileqq/app/ScreenShot:j	Ljava/lang/String;
    //   84: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: aload_0
    //   90: getfield 95	com/tencent/mobileqq/activity/RegisterActivity:E	Ljava/lang/String;
    //   93: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_1
    //   98: ldc_w 727
    //   101: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: new 713	java/io/File
    //   108: dup
    //   109: aload_1
    //   110: invokevirtual 210	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokespecial 719	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: new 729	java/io/FileOutputStream
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 732	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: astore_1
    //   130: aload 4
    //   132: getstatic 738	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   135: bipush 100
    //   137: aload_1
    //   138: invokevirtual 742	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   141: pop
    //   142: aload_1
    //   143: invokevirtual 745	java/io/FileOutputStream:close	()V
    //   146: return
    //   147: astore_3
    //   148: aload_1
    //   149: astore_2
    //   150: aload_3
    //   151: astore_1
    //   152: goto +7 -> 159
    //   155: goto +14 -> 169
    //   158: astore_1
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 745	java/io/FileOutputStream:close	()V
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 745	java/io/FileOutputStream:close	()V
    //   177: return
    //   178: astore_1
    //   179: aload_3
    //   180: astore_1
    //   181: goto -12 -> 169
    //   184: astore_2
    //   185: goto -30 -> 155
    //   188: astore_1
    //   189: return
    //   190: astore_2
    //   191: goto -24 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	RegisterActivity
    //   37	115	1	localObject1	Object
    //   158	16	1	localObject2	Object
    //   178	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   180	1	1	localObject3	Object
    //   188	1	1	localIOException1	java.io.IOException
    //   120	44	2	localObject4	Object
    //   184	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   190	1	2	localIOException2	java.io.IOException
    //   118	1	3	localObject5	Object
    //   147	33	3	localObject6	Object
    //   26	105	4	localBitmap	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   130	142	147	finally
    //   121	130	158	finally
    //   121	130	178	java/io/FileNotFoundException
    //   130	142	184	java/io/FileNotFoundException
    //   142	146	188	java/io/IOException
    //   173	177	188	java/io/IOException
    //   163	167	190	java/io/IOException
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.G = paramIntent.getStringExtra("k_code");
      paramIntent = this.H;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(this.G);
      localStringBuilder.append(" ");
      localStringBuilder.append(str);
      paramIntent.setText(localStringBuilder.toString());
    }
  }
  
  protected boolean onBackEvent()
  {
    int i1 = this.a;
    getClass();
    if (i1 != 6) {
      g();
    } else {
      a();
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131430116)
    {
      k();
    }
    else if (i1 == 2131430472)
    {
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
    }
    else if (i1 == 2131444569)
    {
      r();
    }
    else if (i1 == 2131440779)
    {
      Intent localIntent = new Intent(this, QQBrowserActivity.class);
      localIntent.putExtra("uin", this.app.getCurrentAccountUin());
      localIntent.putExtra("ba_is_login", false);
      localIntent.putExtra("url", "https://ti.qq.com/agreement/index.html");
      startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131629185);
    setContentBackgroundResource(2130838958);
    setTitle(2131914069);
    e();
    this.app.setHandler(getClass(), this.K);
    getWindow().getDecorView().setDrawingCacheEnabled(true);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    i();
  }
  
  protected void onResume()
  {
    super.onResume();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity
 * JD-Core Version:    0.7.0.1
 */