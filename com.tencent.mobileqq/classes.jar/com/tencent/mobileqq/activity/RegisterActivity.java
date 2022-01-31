package com.tencent.mobileqq.activity;

import adpf;
import adpg;
import adph;
import adpi;
import adpj;
import adpk;
import adpl;
import adpm;
import adpn;
import adpo;
import alpo;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import bdcd;
import bdfq;
import bepp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;

public class RegisterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public byte a;
  public int a;
  Dialog jdField_a_of_type_AndroidAppDialog;
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bepp jdField_a_of_type_Bepp;
  public String a;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new adpi(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adpg(this);
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private ImageView[] jdField_a_of_type_ArrayOfAndroidWidgetImageView;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private final byte jdField_b_of_type_Byte = 0;
  final int jdField_b_of_type_Int = -1;
  String jdField_b_of_type_JavaLangString;
  private final byte jdField_c_of_type_Byte = 1;
  final int jdField_c_of_type_Int = 1;
  private String jdField_c_of_type_JavaLangString;
  private final byte jdField_d_of_type_Byte = 2;
  final int jdField_d_of_type_Int = 2;
  private String jdField_d_of_type_JavaLangString = "";
  private final byte jdField_e_of_type_Byte = 3;
  final int jdField_e_of_type_Int = 3;
  private String jdField_e_of_type_JavaLangString = "";
  private final byte jdField_f_of_type_Byte = 4;
  final int jdField_f_of_type_Int = 4;
  private String jdField_f_of_type_JavaLangString = "";
  private final byte jdField_g_of_type_Byte = 5;
  final int jdField_g_of_type_Int = 5;
  private String jdField_g_of_type_JavaLangString = "86";
  private final byte jdField_h_of_type_Byte = 6;
  final int jdField_h_of_type_Int = 6;
  final int i = 7;
  final int j = 8;
  final int k = 9;
  private final int l = 30;
  private final int m = 0;
  private final int n = 1;
  private final int o = 2;
  private final int p = 3;
  private final int q = 4;
  private final int r = 5;
  private final int s = -1;
  
  public RegisterActivity()
  {
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 30;
    this.jdField_a_of_type_AndroidOsHandler = new adph(this);
  }
  
  private void a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidWidgetTextView.length)
    {
      int i1 = 0;
      if (i1 < this.jdField_a_of_type_ArrayOfAndroidWidgetTextView.length)
      {
        if (i1 == paramInt)
        {
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i1].setTextColor(-16777216);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
        }
        for (;;)
        {
          i1 += 1;
          break;
          this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i1].setTextColor(-7829368);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(4);
        }
      }
    }
    if (paramInt >= 1) {
      this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[(paramInt - 1)].setVisibility(0);
    }
  }
  
  private void a(long paramLong)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "reQuerySms time = " + paramLong);
      }
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new RegisterActivity.9(this, paramLong), paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean a()
  {
    boolean bool = ((CheckBox)findViewById(2131375182)).isChecked();
    if (!bool) {
      Toast.makeText(getApplicationContext(), 2131717500, 0).show();
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    int i2 = paramString.length();
    if ((i2 < 6) || (i2 > 16))
    {
      Toast.makeText(getApplicationContext(), 2131717492, 0).show();
      return false;
    }
    try
    {
      Integer.parseInt(paramString);
      i1 = 1;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        int i1 = 0;
      }
    }
    if ((i2 <= 9) && (i1 != 0))
    {
      Toast.makeText(getApplicationContext(), 2131717493, 0).show();
      return false;
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131755801);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558428);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365231)).setText(getString(paramInt));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private boolean b()
  {
    Editable localEditable = ((EditText)findViewById(2131370649)).getText();
    boolean bool2 = true;
    int i1;
    if (localEditable != null) {
      i1 = 3;
    }
    for (;;)
    {
      try
      {
        if ("852".equals(this.jdField_g_of_type_JavaLangString)) {
          break label174;
        }
        if (!"853".equals(this.jdField_g_of_type_JavaLangString)) {
          continue;
        }
      }
      catch (Exception localException)
      {
        boolean bool3;
        bool1 = false;
        continue;
      }
      this.jdField_c_of_type_JavaLangString = localEditable.toString().trim();
      Long.parseLong(this.jdField_c_of_type_JavaLangString);
      if (this.jdField_c_of_type_JavaLangString.length() < i1) {
        bool2 = false;
      }
      boolean bool1 = bool2;
      if (!this.jdField_c_of_type_JavaLangString.startsWith("1"))
      {
        bool3 = "86".equals(this.jdField_g_of_type_JavaLangString);
        bool1 = bool2;
        if (bool3) {
          bool1 = false;
        }
      }
      if (!bool1) {
        Toast.makeText(getApplicationContext(), 2131717498, 0).show();
      }
      return bool1;
      bool1 = "886".equals(this.jdField_g_of_type_JavaLangString);
      if (bool1)
      {
        i1 = 9;
        continue;
        bool1 = false;
        continue;
        label174:
        i1 = 6;
      }
    }
  }
  
  private void c(String paramString)
  {
    try
    {
      if (this.jdField_a_of_type_Bepp == null) {
        this.jdField_a_of_type_Bepp = new bepp(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_Bepp.a(paramString);
      this.jdField_a_of_type_Bepp.setOnKeyListener(new adpm(this));
      this.jdField_a_of_type_Bepp.show();
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
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, Long.valueOf(AppSetting.a()), "8.3.3", new Bundle(), this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363796));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)findViewById(2131379463));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)findViewById(2131376443));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)findViewById(2131375570));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[2];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)findViewById(2131379462));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)findViewById(2131376442));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = findViewById(2131379457);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = findViewById(2131376441);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = findViewById(2131375568);
    TextView localTextView = (TextView)findViewById(2131372360);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(this);
    localTextView.getPaint().setFlags(8);
    a(0);
    f();
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369792));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.jdField_g_of_type_JavaLangString + alpo.a(2131713742));
    findViewById(2131364091).setOnClickListener(this);
  }
  
  private void g()
  {
    bdfq localbdfq = bdcd.a(this, 230);
    localbdfq.setTitle(getString(2131717513));
    localbdfq.setMessage(getString(2131717457));
    adpf localadpf = new adpf(this);
    adpj localadpj = new adpj(this);
    localbdfq.setPositiveButton(2131694951, localadpf);
    localbdfq.setNegativeButton(2131690648, localadpj);
    localbdfq.show();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RegisterActivity.6(this));
  }
  
  private void i()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
      return;
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
      ((AccountManager)this.app.getManager(0)).queryUpSmsStat(this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void k()
  {
    if ((!b()) || (!a())) {
      return;
    }
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
      b(2131717544);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void l()
  {
    findViewById(2131370650).setVisibility(8);
    findViewById(2131379461).setVisibility(0);
    ((TextView)findViewById(2131375545)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131717451);
  }
  
  private void m()
  {
    Editable localEditable = ((EditText)findViewById(2131379456)).getText();
    if (localEditable != null)
    {
      this.jdField_d_of_type_JavaLangString = localEditable.toString();
      if (this.jdField_d_of_type_JavaLangString != null) {
        this.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString.trim();
      }
    }
    if ((this.jdField_d_of_type_JavaLangString != null) && (this.jdField_d_of_type_JavaLangString.length() > 0)) {
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterByCommitSmsVerifycode(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
        b(2131717453);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(getApplicationContext(), 2131717464, 0).show();
  }
  
  private void n()
  {
    this.jdField_a_of_type_Int = 0;
    findViewById(2131370650).setVisibility(8);
    findViewById(2131379461).setVisibility(8);
    findViewById(2131371599).setVisibility(0);
    a(1);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131717450);
  }
  
  private void o()
  {
    Object localObject3 = null;
    Object localObject1 = ((EditText)findViewById(2131371592)).getText();
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
        if (((String)localObject1).length() > 0) {
          break label66;
        }
      }
      Toast.makeText(getApplicationContext(), 2131717501, 0).show();
    }
    label66:
    do
    {
      return;
      localObject2 = null;
      localObject1 = ((EditText)findViewById(2131375177)).getText();
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
          Toast.makeText(getApplicationContext(), 2131717499, 0).show();
          return;
        }
      }
      if ((localObject2 == null) || (!((String)localObject2).equals(localObject3))) {
        break;
      }
    } while (!a((String)localObject2));
    try
    {
      this.jdField_f_of_type_JavaLangString = ((String)localObject2);
      ((AccountManager)this.app.getManager(0)).sendRegisterBySetPass((String)localObject2, "nickName", "smsCode", null, true, "8.3.3", this.jdField_a_of_type_MqqObserverAccountObserver);
      b(2131717452);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Toast.makeText(getApplicationContext(), 2131717491, 0).show();
  }
  
  private void p()
  {
    findViewById(2131371599).setVisibility(8);
    findViewById(2131375569).setVisibility(0);
    a(2);
    ((TextView)findViewById(2131370927)).setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131717471);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
  }
  
  private void q()
  {
    Intent localIntent = new Intent(this, LoginActivity.class);
    localIntent.putExtra("uin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("password", this.jdField_f_of_type_JavaLangString);
    localIntent.addFlags(131072);
    startActivity(localIntent);
    finish();
  }
  
  private void r()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      ((TextView)findViewById(2131377820)).setVisibility(0);
      ((TextView)findViewById(2131375545)).setVisibility(8);
      b();
      b(2131717453);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    int i1 = 0;
    switch (this.jdField_a_of_type_Byte)
    {
    }
    for (;;)
    {
      if (i1 != 0) {
        this.jdField_a_of_type_Byte = ((byte)(this.jdField_a_of_type_Byte + 1));
      }
      return;
      d(null);
      continue;
      l();
      i1 = 1;
      continue;
      m();
      continue;
      n();
      i1 = 1;
      continue;
      o();
      continue;
      p();
      i1 = 1;
      continue;
      q();
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    String str = paramString;
    if (!paramString.startsWith("http://")) {
      str = "http://" + paramString;
    }
    paramString = bdcd.a(this, 230);
    paramString.setTitle(2131717566);
    paramString.setMessage(2131717569);
    paramString.setPositiveButton(2131694951, new adpk(this, str));
    paramString.show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {}
    while ((paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    bdfq localbdfq = bdcd.a(this, 230);
    localbdfq.setTitle(2131717566);
    localbdfq.setMessage(alpo.a(2131713747) + paramString2 + alpo.a(2131713729) + paramString1 + alpo.a(2131713743));
    localbdfq.setPositiveButton(2131694951, new adpl(this, paramString2, paramString1));
    localbdfq.show();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_Int = 30;
      ((TextView)findViewById(2131377820)).setVisibility(8);
      ((TextView)findViewById(2131375545)).setVisibility(0);
      return;
    }
    ((TextView)findViewById(2131377820)).setText(this.jdField_a_of_type_Int + getResources().getString(2131717556));
    this.jdField_a_of_type_Int -= 1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  public void b(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void b(String paramString1, String paramString2)
  {
    bdfq localbdfq = bdcd.a(this, 230);
    localbdfq.setTitle(paramString1);
    localbdfq.setMessage(paramString2);
    paramString1 = new adpn(this);
    paramString2 = new adpo(this);
    localbdfq.setPositiveButton(2131694951, paramString1);
    localbdfq.setNegativeButton(2131363907, paramString2);
    localbdfq.show();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RegisterActivity.10(this));
  }
  
  public void c(String paramString1, String paramString2)
  {
    Message localMessage = new Message();
    localMessage.what = 7;
    Bundle localBundle = new Bundle();
    localBundle.putString("telNum", paramString1);
    localBundle.putString("msg", paramString2);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 606	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 653	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   7: getfield 658	android/util/DisplayMetrics:widthPixels	I
    //   10: aload_0
    //   11: invokevirtual 606	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   14: invokevirtual 653	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   17: getfield 661	android/util/DisplayMetrics:heightPixels	I
    //   20: getstatic 667	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 673	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore_3
    //   27: new 675	android/graphics/Canvas
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 678	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 682	com/tencent/mobileqq/activity/RegisterActivity:getWindow	()Landroid/view/Window;
    //   40: invokevirtual 688	android/view/Window:getDecorView	()Landroid/view/View;
    //   43: aload_1
    //   44: invokevirtual 692	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   47: new 694	java/io/File
    //   50: dup
    //   51: getstatic 697	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 699	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 702	java/io/File:exists	()Z
    //   62: ifne +8 -> 70
    //   65: aload_1
    //   66: invokevirtual 705	java/io/File:mkdirs	()Z
    //   69: pop
    //   70: new 694	java/io/File
    //   73: dup
    //   74: new 173	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   81: getstatic 697	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 71	com/tencent/mobileqq/activity/RegisterActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 707
    //   97: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 699	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +33 -> 141
    //   111: aconst_null
    //   112: astore_2
    //   113: new 709	java/io/FileOutputStream
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 712	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_1
    //   122: aload_3
    //   123: getstatic 718	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   126: bipush 100
    //   128: aload_1
    //   129: invokevirtual 722	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: pop
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 725	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -5 -> 141
    //   149: aload_1
    //   150: invokevirtual 725	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: return
    //   156: astore_1
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 725	java/io/FileOutputStream:close	()V
    //   165: aload_1
    //   166: athrow
    //   167: astore_1
    //   168: return
    //   169: astore_2
    //   170: goto -5 -> 165
    //   173: astore_3
    //   174: aload_1
    //   175: astore_2
    //   176: aload_3
    //   177: astore_1
    //   178: goto -21 -> 157
    //   181: astore_2
    //   182: goto -37 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	RegisterActivity
    //   35	103	1	localObject1	Object
    //   142	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   144	6	1	localObject2	Object
    //   154	1	1	localIOException1	java.io.IOException
    //   156	10	1	localObject3	Object
    //   167	8	1	localIOException2	java.io.IOException
    //   177	1	1	localObject4	Object
    //   112	50	2	localObject5	Object
    //   169	1	2	localIOException3	java.io.IOException
    //   175	1	2	localIOException4	java.io.IOException
    //   181	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   26	97	3	localBitmap	android.graphics.Bitmap
    //   173	4	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   113	122	142	java/io/FileNotFoundException
    //   149	153	154	java/io/IOException
    //   113	122	156	finally
    //   137	141	167	java/io/IOException
    //   161	165	169	java/io/IOException
    //   122	133	173	finally
    //   122	133	181	java/io/FileNotFoundException
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.jdField_g_of_type_JavaLangString + " " + str);
    }
  }
  
  public boolean onBackEvent()
  {
    int i1 = this.jdField_a_of_type_Byte;
    getClass();
    if (i1 != 6) {
      g();
    }
    for (;;)
    {
      return true;
      a();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 == 2131363796) {
      k();
    }
    do
    {
      return;
      if (i1 == 2131364091)
      {
        startActivityForResult(new Intent(this, CountryActivity.class), 1);
        return;
      }
      if (i1 == 2131375545)
      {
        r();
        return;
      }
    } while (i1 != 2131372360);
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.app.getCurrentAccountUin());
    paramView.putExtra("ba_is_login", false);
    paramView.putExtra("url", "https://ti.qq.com/agreement/index.html");
    startActivity(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2131562546);
    setContentBackgroundResource(2130838591);
    setTitle(2131717513);
    e();
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
    getWindow().getDecorView().setDrawingCacheEnabled(true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    i();
  }
  
  public void onResume()
  {
    super.onResume();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity
 * JD-Core Version:    0.7.0.1
 */