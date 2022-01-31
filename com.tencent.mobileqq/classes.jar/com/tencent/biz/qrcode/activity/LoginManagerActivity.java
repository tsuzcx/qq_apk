package com.tencent.biz.qrcode.activity;

import QQService.SvcReqKikOut;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.compatible.TempServlet;
import com.tencent.mobileqq.service.MobileQQService;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.NewIntent;
import oxb;
import oxc;
import oxd;

public class LoginManagerActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener
{
  protected int a;
  protected long a;
  protected Button a;
  protected ImageView a;
  protected TextView a;
  private DownloadTask jdField_a_of_type_ComTencentMobileqqVipDownloadTask;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
  protected String a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  protected ImageView b;
  protected TextView b;
  private Boolean jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(false);
  protected String b;
  protected TextView c;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  
  private boolean a()
  {
    File localFile = new File(this.d);
    if (localFile.exists()) {
      return true;
    }
    if (NetworkUtil.a(BaseApplicationImpl.getApplication()) == 0) {
      return false;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask != null)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a() == 2) || (this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a() == 3)) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask.a(true);
    }
    this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask = new DownloadTask(this.jdField_c_of_type_JavaLangString, localFile);
    ((DownloaderFactory)this.app.getManager(46)).a(1).a(this.jdField_a_of_type_ComTencentMobileqqVipDownloadTask, new oxd(this), null);
    return false;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_JavaLangBoolean.booleanValue())
    {
      SharedPreferences localSharedPreferences = this.app.getApp().getSharedPreferences("tim_pc_banner_shared_pre_" + this.app.c(), 0);
      this.jdField_b_of_type_JavaLangBoolean = Boolean.valueOf(localSharedPreferences.getBoolean("tim_pc_banner_switch", false));
      this.jdField_c_of_type_JavaLangString = localSharedPreferences.getString("tim_pc_banner_image_url", "");
      this.jdField_b_of_type_Int = localSharedPreferences.getInt("tim_pc_banner_image_ver", 0);
      this.e = localSharedPreferences.getString("tim_pc_banner_click_url", "");
      this.f = localSharedPreferences.getString("tim_pc_banner_link_text", "");
      this.g = localSharedPreferences.getString("tim_pc_banner_link_url", "");
      this.d = (AppConstants.aK + "timLoginRes/timPcLoginPic_ver_" + this.jdField_b_of_type_Int + ".png");
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
    }
    if (this.jdField_b_of_type_JavaLangBoolean.booleanValue())
    {
      if (a()) {
        c();
      }
      if (!TextUtils.isEmpty(this.f))
      {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(this.f);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void c()
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeFile(this.d);
      if (localBitmap == null) {
        return;
      }
      Object localObject = getWindowManager().getDefaultDisplay();
      Point localPoint = new Point();
      ((Display)localObject).getSize(localPoint);
      int i = localPoint.x;
      int j = (int)(localBitmap.getHeight() / localBitmap.getWidth() * i);
      localObject = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = i;
      ((LinearLayout.LayoutParams)localObject).height = j;
      this.jdField_b_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(getResources(), localBitmap));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      ReportController.b(this.app, "dc00898", "", "", "0X8008881", "0X8008881", 0, 0, "", "", "", "");
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  protected String a()
  {
    String str = "电脑";
    if (this.jdField_a_of_type_Int == 5) {
      str = "Mac";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LoginManagerActivity", 2, "getDeviceName " + str + " " + this.jdField_a_of_type_Int);
      }
      return str;
      if (this.jdField_a_of_type_Int == 4) {
        str = "儿童手表";
      }
    }
  }
  
  public void a()
  {
    if (this.app.isLogin())
    {
      Object localObject2 = this.app.getCurrentAccountUin();
      localObject1 = new UniPacket(true);
      ((UniPacket)localObject1).setEncodeName("utf-8");
      int i = MobileQQService.jdField_a_of_type_Int;
      MobileQQService.jdField_a_of_type_Int = i + 1;
      ((UniPacket)localObject1).setRequestId(i);
      SvcReqKikOut localSvcReqKikOut = new SvcReqKikOut(Long.parseLong((String)localObject2), this.jdField_a_of_type_Long, (byte)0, new byte[0]);
      ((UniPacket)localObject1).setServantName("StatSvc");
      ((UniPacket)localObject1).setFuncName("SvcReqKikOut");
      ((UniPacket)localObject1).put("req", localSvcReqKikOut);
      localObject2 = new ToServiceMsg("mobileqq.service", (String)localObject2, "StatSvc.SvcReqKikOut");
      ((ToServiceMsg)localObject2).putWupBuffer(((UniPacket)localObject1).encode());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      localObject1 = new NewIntent(this.app.getApplication(), TempServlet.class);
      ((NewIntent)localObject1).putExtra(ToServiceMsg.class.getSimpleName(), (Parcelable)localObject2);
      this.app.startServlet((NewIntent)localObject1);
    }
    QQToast.a(this, -1, 2131429985, 0).a();
    super.finish();
    Object localObject1 = new Intent("com.tencent.mobileqq.action.PC_STATUS_MANAGE");
    ((Intent)localObject1).putExtra("status", "logout");
    super.sendBroadcast((Intent)localObject1);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
      paramView = DialogUtil.a(this, 230);
      paramView.setMessage(getString(2131429984, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      paramView.setPositiveButton(2131430013, new oxb(this));
      paramView.setNegativeButton(2131433029, new oxc(this));
      paramView.show();
      return;
      if (!TextUtils.isEmpty(this.e))
      {
        paramView = new Intent(this, QQBrowserActivity.class);
        paramView.putExtra("url", this.e);
        startActivity(paramView);
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8008882", "0X8008882", 0, 0, "", "", "", "");
      return;
      if (PackageUtil.a(this, "com.tencent.tim"))
      {
        paramView = new Intent();
        paramView.setComponent(new ComponentName("com.tencent.tim", "com.tencent.mobileqq.activity.SplashActivity"));
        paramView.setFlags(268435456);
        startActivity(paramView);
        return;
      }
    } while (TextUtils.isEmpty(this.g));
    paramView = new Intent(this, QQBrowserActivity.class);
    paramView.putExtra("url", this.g);
    startActivity(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.setContentView(2130969707);
    super.setTitle(2131429982);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131367579));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367576));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367241));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367575));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367583));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131367582));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    if (this.app == null)
    {
      super.finish();
      return;
    }
    paramBundle = this.app.getCurrentAccountUin();
    this.jdField_b_of_type_AndroidWidgetTextView.setText(ContactUtils.j(this.app, paramBundle));
    this.jdField_a_of_type_Int = getIntent().getIntExtra("appType", -1);
    this.jdField_a_of_type_Long = getIntent().getLongExtra("subappid", 1L);
    this.jdField_b_of_type_Long = getIntent().getLongExtra("clientType", 0L);
    this.jdField_a_of_type_JavaLangString = a();
    String str = getIntent().getStringExtra("loginInfo");
    if (this.jdField_b_of_type_Long == 77313L)
    {
      this.jdField_b_of_type_JavaLangString = "TIM";
      if ((TextUtils.isEmpty(str)) || (str.equalsIgnoreCase("null")) || (str.contains("未知")))
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131429979, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
        label303:
        b();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setText(getString(2131429983, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString }));
      paramBundle = FaceDrawable.a(this.app, paramBundle, (byte)3);
      if (paramBundle == null) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      return;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131429978, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, str }));
      break label303;
      this.jdField_b_of_type_JavaLangString = "QQ";
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131429978, new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, str }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.LoginManagerActivity
 * JD-Core Version:    0.7.0.1
 */