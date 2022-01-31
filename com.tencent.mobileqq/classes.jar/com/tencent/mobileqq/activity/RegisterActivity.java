package com.tencent.mobileqq.activity;

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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.phone.CountryActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.manager.AccountManager;
import mqq.observer.AccountObserver;
import mqq.os.MqqHandler;
import tlk;
import tll;
import tlm;
import tln;
import tlo;
import tlr;
import tls;
import tlt;
import tlu;
import tlv;
import tlw;
import tlx;
import tly;

public class RegisterActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  public byte a;
  public int a;
  public Dialog a;
  public Handler a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  public String a;
  private Timer jdField_a_of_type_JavaUtilTimer;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new tlo(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new tlm(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new tln(this);
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
      this.jdField_a_of_type_JavaUtilTimer.schedule(new tly(this, paramLong), paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private boolean a()
  {
    boolean bool = ((CheckBox)findViewById(2131374755)).isChecked();
    if (!bool) {
      Toast.makeText(getApplicationContext(), 2131434211, 0).show();
    }
    return bool;
  }
  
  private boolean a(String paramString)
  {
    int i2 = paramString.length();
    if ((i2 < 6) || (i2 > 16))
    {
      Toast.makeText(getApplicationContext(), 2131434223, 0).show();
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
      Toast.makeText(getApplicationContext(), 2131434222, 0).show();
      return false;
    }
    return true;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = new Dialog(this, 2131624515);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2130968595);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131362758)).setText(getString(paramInt));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private boolean b()
  {
    Editable localEditable = ((EditText)findViewById(2131374754)).getText();
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
        Toast.makeText(getApplicationContext(), 2131434232, 0).show();
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
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getTitleBarHeight());
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(paramString);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(new tlu(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
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
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, Long.valueOf(AppSetting.jdField_a_of_type_Int), this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131366745));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)findViewById(2131374730));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)findViewById(2131374734));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)findViewById(2131374738));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[2];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)findViewById(2131374731));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)findViewById(2131374735));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = findViewById(2131374732);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = findViewById(2131374736);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = findViewById(2131374740);
    TextView localTextView = (TextView)findViewById(2131374756);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(this);
    localTextView.getPaint().setFlags(8);
    a(0);
    f();
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369872));
    this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.jdField_g_of_type_JavaLangString + " 中国大陆");
    findViewById(2131374753).setOnClickListener(this);
  }
  
  private void g()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131434202));
    localQQCustomDialog.setMessage(getString(2131434235));
    tlk localtlk = new tlk(this);
    tlr localtlr = new tlr(this);
    localQQCustomDialog.setPositiveButton(2131432999, localtlk);
    localQQCustomDialog.setNegativeButton(2131432998, localtlr);
    localQQCustomDialog.show();
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tlv(this));
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
      b(2131434214);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void l()
  {
    findViewById(2131374741).setVisibility(8);
    findViewById(2131374742).setVisibility(0);
    ((TextView)findViewById(2131374768)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131434217);
  }
  
  private void m()
  {
    Editable localEditable = ((EditText)findViewById(2131374766)).getText();
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
        b(2131434218);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(getApplicationContext(), 2131434258, 0).show();
  }
  
  private void n()
  {
    this.jdField_a_of_type_Int = 0;
    findViewById(2131374741).setVisibility(8);
    findViewById(2131374742).setVisibility(8);
    findViewById(2131374743).setVisibility(0);
    a(1);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131434219);
  }
  
  private void o()
  {
    Object localObject3 = null;
    Object localObject1 = ((EditText)findViewById(2131364807)).getText();
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
      Toast.makeText(getApplicationContext(), 2131434224, 0).show();
    }
    label66:
    do
    {
      return;
      localObject2 = null;
      localObject1 = ((EditText)findViewById(2131374757)).getText();
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
          Toast.makeText(getApplicationContext(), 2131434225, 0).show();
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
      ((AccountManager)this.app.getManager(0)).sendRegisterBySetPass((String)localObject2, "nickName", "smsCode", true, this.jdField_a_of_type_MqqObserverAccountObserver);
      b(2131434220);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    Toast.makeText(getApplicationContext(), 2131434226, 0).show();
  }
  
  private void p()
  {
    findViewById(2131374743).setVisibility(8);
    findViewById(2131374744).setVisibility(0);
    a(2);
    ((TextView)findViewById(2131374748)).setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131434228);
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
      ((TextView)findViewById(2131374767)).setVisibility(0);
      ((TextView)findViewById(2131374768)).setVisibility(8);
      b();
      b(2131434218);
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
    paramString = DialogUtil.a(this, 230);
    paramString.setTitle(2131434236);
    paramString.setMessage(2131434237);
    paramString.setPositiveButton(2131432999, new tls(this, str));
    paramString.show();
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0)) {}
    while ((paramString2 == null) || (paramString2.length() <= 0)) {
      return;
    }
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(2131434236);
    localQQCustomDialog.setMessage("请发送短信" + paramString2 + "至" + paramString1 + "来直接验证");
    localQQCustomDialog.setPositiveButton(2131432999, new tlt(this, paramString2, paramString1));
    localQQCustomDialog.show();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_Int = 30;
      ((TextView)findViewById(2131374767)).setVisibility(8);
      ((TextView)findViewById(2131374768)).setVisibility(0);
      return;
    }
    ((TextView)findViewById(2131374767)).setText(this.jdField_a_of_type_Int + getResources().getString(2131434230));
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
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    paramString1 = new tlw(this);
    paramString2 = new tlx(this);
    localQQCustomDialog.setPositiveButton(2131432999, paramString1);
    localQQCustomDialog.setNegativeButton(2131363969, paramString2);
    localQQCustomDialog.show();
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new tll(this));
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
    //   1: invokevirtual 600	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 650	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   7: getfield 655	android/util/DisplayMetrics:widthPixels	I
    //   10: aload_0
    //   11: invokevirtual 600	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   14: invokevirtual 650	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   17: getfield 658	android/util/DisplayMetrics:heightPixels	I
    //   20: getstatic 664	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 670	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore_3
    //   27: new 672	android/graphics/Canvas
    //   30: dup
    //   31: aload_3
    //   32: invokespecial 675	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 679	com/tencent/mobileqq/activity/RegisterActivity:getWindow	()Landroid/view/Window;
    //   40: invokevirtual 685	android/view/Window:getDecorView	()Landroid/view/View;
    //   43: aload_1
    //   44: invokevirtual 689	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   47: new 691	java/io/File
    //   50: dup
    //   51: getstatic 694	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 696	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore_1
    //   58: aload_1
    //   59: invokevirtual 699	java/io/File:exists	()Z
    //   62: ifne +8 -> 70
    //   65: aload_1
    //   66: invokevirtual 702	java/io/File:mkdirs	()Z
    //   69: pop
    //   70: new 691	java/io/File
    //   73: dup
    //   74: new 173	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   81: getstatic 694	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 71	com/tencent/mobileqq/activity/RegisterActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: ldc_w 704
    //   97: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokespecial 696	java/io/File:<init>	(Ljava/lang/String;)V
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +33 -> 141
    //   111: aconst_null
    //   112: astore_2
    //   113: new 706	java/io/FileOutputStream
    //   116: dup
    //   117: aload_1
    //   118: invokespecial 709	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   121: astore_1
    //   122: aload_3
    //   123: getstatic 715	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   126: bipush 100
    //   128: aload_1
    //   129: invokevirtual 719	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: pop
    //   133: aload_1
    //   134: ifnull +7 -> 141
    //   137: aload_1
    //   138: invokevirtual 722	java/io/FileOutputStream:close	()V
    //   141: return
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: ifnull -5 -> 141
    //   149: aload_1
    //   150: invokevirtual 722	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: astore_1
    //   155: return
    //   156: astore_1
    //   157: aload_2
    //   158: ifnull +7 -> 165
    //   161: aload_2
    //   162: invokevirtual 722	java/io/FileOutputStream:close	()V
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
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      String str = paramIntent.getStringExtra("k_name");
      this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      this.jdField_a_of_type_AndroidWidgetTextView.setText("+" + this.jdField_g_of_type_JavaLangString + " " + str);
    }
  }
  
  protected boolean onBackEvent()
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
    if (i1 == 2131366745) {
      k();
    }
    do
    {
      return;
      if (i1 == 2131374753)
      {
        startActivityForResult(new Intent(this, CountryActivity.class), 1);
        return;
      }
      if (i1 == 2131374768)
      {
        r();
        return;
      }
    } while (i1 != 2131374756);
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("uin", this.app.getCurrentAccountUin());
    paramView.putExtra("ba_is_login", false);
    paramView.putExtra("url", "http://zc.qq.com/chs/agreement1_chs.html");
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130971448);
    setContentBackgroundResource(2130838210);
    setTitle(2131434202);
    e();
    this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
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