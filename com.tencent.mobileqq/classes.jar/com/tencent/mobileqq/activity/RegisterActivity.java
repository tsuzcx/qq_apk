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
  byte jdField_a_of_type_Byte = 0;
  int jdField_a_of_type_Int = 30;
  Dialog jdField_a_of_type_AndroidAppDialog;
  Handler jdField_a_of_type_AndroidOsHandler = new RegisterActivity.12(this);
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString = "";
  private Timer jdField_a_of_type_JavaUtilTimer = null;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new RegisterActivity.13(this);
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new RegisterActivity.11(this);
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
  
  private void a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_ArrayOfAndroidWidgetTextView.length)
    {
      int i1 = 0;
      for (;;)
      {
        TextView[] arrayOfTextView = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView;
        if (i1 >= arrayOfTextView.length) {
          break;
        }
        if (i1 == paramInt)
        {
          arrayOfTextView[i1].setTextColor(-16777216);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(0);
        }
        else
        {
          arrayOfTextView[i1].setTextColor(-7829368);
          this.jdField_a_of_type_ArrayOfAndroidViewView[i1].setVisibility(4);
        }
        i1 += 1;
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
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("reQuerySms time = ");
        localStringBuilder.append(paramLong);
        QLog.d("", 2, localStringBuilder.toString());
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
    boolean bool = ((CheckBox)findViewById(2131376001)).isChecked();
    if (!bool) {
      Toast.makeText(getApplicationContext(), 2131716595, 0).show();
    }
    return bool;
  }
  
  private boolean a(String paramString)
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
      Toast.makeText(getApplicationContext(), 2131716590, 0).show();
      return false;
    }
    return true;
    Toast.makeText(getApplicationContext(), 2131716589, 0).show();
    return false;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_AndroidAppDialog = new ReportDialog(this, 2131756189);
    this.jdField_a_of_type_AndroidAppDialog.setContentView(2131558463);
    ((TextView)this.jdField_a_of_type_AndroidAppDialog.findViewById(2131365644)).setText(getString(paramInt));
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  private boolean b()
  {
    Editable localEditable = ((EditText)findViewById(2131371422)).getText();
    if (localEditable != null) {
      i1 = 3;
    }
    try
    {
      if (("852".equals(this.jdField_g_of_type_JavaLangString)) || ("853".equals(this.jdField_g_of_type_JavaLangString))) {
        break label166;
      }
      if ("886".equals(this.jdField_g_of_type_JavaLangString)) {
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
    this.jdField_c_of_type_JavaLangString = localEditable.toString().trim();
    Long.parseLong(this.jdField_c_of_type_JavaLangString);
    if (this.jdField_c_of_type_JavaLangString.length() < i1)
    {
      bool1 = false;
      bool2 = bool1;
      if (!this.jdField_c_of_type_JavaLangString.startsWith("1"))
      {
        bool3 = "86".equals(this.jdField_g_of_type_JavaLangString);
        bool2 = bool1;
        if (bool3) {
          bool2 = false;
        }
      }
      if (!bool2) {
        Toast.makeText(getApplicationContext(), 2131716593, 0).show();
      }
      return bool2;
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
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setOnKeyListener(new RegisterActivity.5(this));
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
      ((AccountManager)this.app.getManager(0)).sendRegistByPhoneNumber(paramString, (byte)2, this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, null, Long.valueOf(AppSetting.a()), "8.7.0", new Bundle(), this.jdField_a_of_type_MqqObserverAccountObserver);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364149));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[3];
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[0] = ((TextView)findViewById(2131380406));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[1] = ((TextView)findViewById(2131377307));
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[2] = ((TextView)findViewById(2131376377));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView = new ImageView[2];
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[0] = ((ImageView)findViewById(2131380405));
    this.jdField_a_of_type_ArrayOfAndroidWidgetImageView[1] = ((ImageView)findViewById(2131377306));
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[3];
    this.jdField_a_of_type_ArrayOfAndroidViewView[0] = findViewById(2131380399);
    this.jdField_a_of_type_ArrayOfAndroidViewView[1] = findViewById(2131377305);
    this.jdField_a_of_type_ArrayOfAndroidViewView[2] = findViewById(2131376375);
    TextView localTextView = (TextView)findViewById(2131373169);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
    localTextView.setOnClickListener(this);
    localTextView.getPaint().setFlags(8);
    a(0);
    f();
    this.jdField_b_of_type_JavaLangString = getIntent().getStringExtra("uin");
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370414));
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("+");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append(HardCodeUtil.a(2131713285));
    localTextView.setText(localStringBuilder.toString());
    findViewById(2131364438).setOnClickListener(this);
  }
  
  private void g()
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(getString(2131716606));
    localQQCustomDialog.setMessage(getString(2131716564));
    RegisterActivity.1 local1 = new RegisterActivity.1(this);
    RegisterActivity.2 local2 = new RegisterActivity.2(this);
    localQQCustomDialog.setPositiveButton(2131694583, local1);
    localQQCustomDialog.setNegativeButton(2131690728, local2);
    localQQCustomDialog.show();
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
    if (b())
    {
      if (!a()) {
        return;
      }
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterQueryMobile(this.jdField_g_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
        b(2131716637);
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
    findViewById(2131371423).setVisibility(8);
    findViewById(2131380404).setVisibility(0);
    ((TextView)findViewById(2131376353)).setOnClickListener(this);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131716557);
  }
  
  private void m()
  {
    Object localObject = ((EditText)findViewById(2131380398)).getText();
    if (localObject != null)
    {
      this.jdField_d_of_type_JavaLangString = localObject.toString();
      localObject = this.jdField_d_of_type_JavaLangString;
      if (localObject != null) {
        this.jdField_d_of_type_JavaLangString = ((String)localObject).trim();
      }
    }
    localObject = this.jdField_d_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).length() > 0)) {
      try
      {
        ((AccountManager)this.app.getManager(0)).sendRegisterByCommitSmsVerifycode(this.jdField_d_of_type_JavaLangString, this.jdField_a_of_type_MqqObserverAccountObserver);
        b(2131716559);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(getApplicationContext(), 2131716570, 0).show();
  }
  
  private void n()
  {
    this.jdField_a_of_type_Int = 0;
    findViewById(2131371423).setVisibility(8);
    findViewById(2131380404).setVisibility(8);
    findViewById(2131372350).setVisibility(0);
    a(1);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131716556);
  }
  
  private void o()
  {
    Object localObject1 = ((EditText)findViewById(2131372343)).getText();
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
        Toast.makeText(getApplicationContext(), 2131716596, 0).show();
      }
    }
    else
    {
      localObject2 = null;
    }
    localObject1 = ((EditText)findViewById(2131375996)).getText();
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
        Toast.makeText(getApplicationContext(), 2131716594, 0).show();
        return;
      }
    }
    if ((localObject2 != null) && (((String)localObject2).equals(localObject3)))
    {
      if (!a((String)localObject2)) {
        return;
      }
      try
      {
        this.jdField_f_of_type_JavaLangString = ((String)localObject2);
        b(2131716558);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Toast.makeText(getApplicationContext(), 2131716588, 0).show();
  }
  
  private void p()
  {
    findViewById(2131372350).setVisibility(8);
    findViewById(2131376376).setVisibility(0);
    a(2);
    ((TextView)findViewById(2131371684)).setText(this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131716576);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(3, 200L);
  }
  
  private void q()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uin", this.jdField_e_of_type_JavaLangString);
    localIntent.putExtra("password", this.jdField_f_of_type_JavaLangString);
    localIntent.addFlags(131072);
    RouteUtils.a(this, localIntent, "/base/login");
    finish();
  }
  
  private void r()
  {
    try
    {
      ((AccountManager)this.app.getManager(0)).sendRegistByResendSms(this.jdField_a_of_type_MqqObserverAccountObserver);
      ((TextView)findViewById(2131378721)).setVisibility(0);
      ((TextView)findViewById(2131376353)).setVisibility(8);
      b();
      b(2131716559);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  void a()
  {
    int i2 = this.jdField_a_of_type_Byte;
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
      this.jdField_a_of_type_Byte = ((byte)(this.jdField_a_of_type_Byte + 1));
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
      paramString.setTitle(2131716654);
      paramString.setMessage(2131716655);
      paramString.setPositiveButton(2131694583, new RegisterActivity.3(this, (String)localObject));
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
        localQQCustomDialog.setTitle(2131716654);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131713290));
        localStringBuilder.append(paramString2);
        localStringBuilder.append(HardCodeUtil.a(2131713272));
        localStringBuilder.append(paramString1);
        localStringBuilder.append(HardCodeUtil.a(2131713286));
        localQQCustomDialog.setMessage(localStringBuilder.toString());
        localQQCustomDialog.setPositiveButton(2131694583, new RegisterActivity.4(this, paramString2, paramString1));
        localQQCustomDialog.show();
      }
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_Int = 30;
      ((TextView)findViewById(2131378721)).setVisibility(8);
      ((TextView)findViewById(2131376353)).setVisibility(0);
      return;
    }
    TextView localTextView = (TextView)findViewById(2131378721);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(getResources().getString(2131716647));
    localTextView.setText(localStringBuilder.toString());
    this.jdField_a_of_type_Int -= 1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(4, 1000L);
  }
  
  void b(String paramString)
  {
    Message localMessage = new Message();
    localMessage.what = 6;
    Bundle localBundle = new Bundle();
    localBundle.putString("url", paramString);
    localMessage.setData(localBundle);
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  void b(String paramString1, String paramString2)
  {
    QQCustomDialog localQQCustomDialog = DialogUtil.a(this, 230);
    localQQCustomDialog.setTitle(paramString1);
    localQQCustomDialog.setMessage(paramString2);
    paramString1 = new RegisterActivity.7(this);
    paramString2 = new RegisterActivity.8(this);
    localQQCustomDialog.setPositiveButton(2131694583, paramString1);
    localQQCustomDialog.setNegativeButton(2131364259, paramString2);
    localQQCustomDialog.show();
  }
  
  void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RegisterActivity.10(this));
  }
  
  void c(String paramString1, String paramString2)
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
  void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 601	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   4: invokevirtual 648	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   7: getfield 653	android/util/DisplayMetrics:widthPixels	I
    //   10: aload_0
    //   11: invokevirtual 601	com/tencent/mobileqq/activity/RegisterActivity:getResources	()Landroid/content/res/Resources;
    //   14: invokevirtual 648	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   17: getfield 656	android/util/DisplayMetrics:heightPixels	I
    //   20: getstatic 662	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   23: invokestatic 668	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   26: astore 4
    //   28: new 670	android/graphics/Canvas
    //   31: dup
    //   32: aload 4
    //   34: invokespecial 673	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   37: astore_1
    //   38: aload_0
    //   39: invokevirtual 677	com/tencent/mobileqq/activity/RegisterActivity:getWindow	()Landroid/view/Window;
    //   42: invokevirtual 683	android/view/Window:getDecorView	()Landroid/view/View;
    //   45: aload_1
    //   46: invokevirtual 687	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   49: new 689	java/io/File
    //   52: dup
    //   53: getstatic 692	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   56: invokespecial 694	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 697	java/io/File:exists	()Z
    //   64: ifne +8 -> 72
    //   67: aload_1
    //   68: invokevirtual 700	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: new 173	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   79: astore_1
    //   80: aload_1
    //   81: getstatic 692	com/tencent/mobileqq/app/ScreenShot:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   84: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_1
    //   89: aload_0
    //   90: getfield 71	com/tencent/mobileqq/activity/RegisterActivity:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   93: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload_1
    //   98: ldc_w 702
    //   101: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: pop
    //   105: new 689	java/io/File
    //   108: dup
    //   109: aload_1
    //   110: invokevirtual 187	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokespecial 694	java/io/File:<init>	(Ljava/lang/String;)V
    //   116: astore_1
    //   117: aconst_null
    //   118: astore_3
    //   119: aconst_null
    //   120: astore_2
    //   121: new 704	java/io/FileOutputStream
    //   124: dup
    //   125: aload_1
    //   126: invokespecial 707	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: astore_1
    //   130: aload 4
    //   132: getstatic 713	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   135: bipush 100
    //   137: aload_1
    //   138: invokevirtual 717	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   141: pop
    //   142: aload_1
    //   143: invokevirtual 720	java/io/FileOutputStream:close	()V
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
    //   164: invokevirtual 720	java/io/FileOutputStream:close	()V
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +7 -> 177
    //   173: aload_1
    //   174: invokevirtual 720	java/io/FileOutputStream:close	()V
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
      this.jdField_g_of_type_JavaLangString = paramIntent.getStringExtra("k_code");
      paramIntent = this.jdField_a_of_type_AndroidWidgetTextView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("+");
      localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
      localStringBuilder.append(" ");
      localStringBuilder.append(str);
      paramIntent.setText(localStringBuilder.toString());
    }
  }
  
  protected boolean onBackEvent()
  {
    int i1 = this.jdField_a_of_type_Byte;
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
    if (i1 == 2131364149)
    {
      k();
    }
    else if (i1 == 2131364438)
    {
      startActivityForResult(new Intent(this, CountryActivity.class), 1);
    }
    else if (i1 == 2131376353)
    {
      r();
    }
    else if (i1 == 2131373169)
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
    super.setContentView(2131562748);
    setContentBackgroundResource(2130838739);
    setTitle(2131716606);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterActivity
 * JD-Core Version:    0.7.0.1
 */