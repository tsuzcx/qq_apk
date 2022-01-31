package com.tencent.mobileqq.activity.selectmember;

import ajyp;
import ajyq;
import ajyr;
import ajys;
import ajyt;
import ajyu;
import ajyv;
import ajyx;
import ajyy;
import alto;
import alud;
import alxi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import azqs;
import bdbb;
import bdbc;
import bdgc;
import bdhj;
import bdin;
import bety;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tencent.im.nearfield_discuss.nearfield_discuss.GPS;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class CreateFaceToFaceDiscussionActivity
  extends LbsBaseActivity
  implements View.OnClickListener, bdbc
{
  public int a;
  public long a;
  public ajyx a;
  alto jdField_a_of_type_Alto;
  private alxi jdField_a_of_type_Alxi = new ajyu(this);
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  public Context a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  public Drawable a;
  public Handler a;
  public View a;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public Button a;
  public GridView a;
  public ImageView a;
  public LinearLayout a;
  TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  public TextView a;
  bdbb jdField_a_of_type_Bdbb;
  public bety a;
  public StringBuffer a;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public List<nearfield_discuss.UserProfile> a;
  nearfield_discuss.LBSInfo jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
  public nearfield_discuss.UserProfile a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  View b;
  public TranslateAnimation b;
  public ImageView b;
  public LinearLayout b;
  public TableLayout b;
  public TextView b;
  public boolean b;
  final int c;
  public ImageView c;
  public TextView c;
  public boolean c;
  final int jdField_d_of_type_Int = 1;
  public ImageView d;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  final int jdField_e_of_type_Int = 2;
  public ImageView e;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  final int jdField_f_of_type_Int = 50;
  public ImageView f;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  final int jdField_g_of_type_Int = 11;
  public ImageView g;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  public int h;
  public ImageView h;
  public ImageView i;
  public ImageView j;
  public ImageView k;
  public ImageView l;
  public ImageView m;
  public ImageView n;
  public ImageView o;
  
  public CreateFaceToFaceDiscussionActivity()
  {
    this.jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(4);
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 60000L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new ajys(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private nearfield_discuss.LBSInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramSosoLbsInfo == null) {
      paramSosoLbsInfo = this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
    }
    nearfield_discuss.LBSInfo localLBSInfo;
    do
    {
      return paramSosoLbsInfo;
      localLBSInfo = new nearfield_discuss.LBSInfo();
      nearfield_discuss.GPS localGPS = new nearfield_discuss.GPS();
      localGPS.int32_lat.set((int)(paramSosoLbsInfo.a.a * 1000000.0D));
      localGPS.int32_lon.set((int)(paramSosoLbsInfo.a.b * 1000000.0D));
      localGPS.int32_alt.set(-1);
      localGPS.eType.set(1);
      localLBSInfo.msg_gps.set(localGPS);
      localStringBuffer.append(" GPS: ").append(paramSosoLbsInfo.a.a * 1000000.0D).append(",").append(paramSosoLbsInfo.a.b * 1000000.0D);
      this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo = localLBSInfo;
      paramSosoLbsInfo = localLBSInfo;
    } while (!QLog.isColorLevel());
    QLog.i("CreateFaceToFaceDiscussionActivity", 2, localStringBuffer.toString());
    return localLBSInfo;
  }
  
  private void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        requestPermissions(new ajyv(this, paramInt), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      b(paramInt);
      return;
    }
    b(paramInt);
  }
  
  private void a(View paramView)
  {
    ajyy localajyy = (ajyy)paramView.getTag();
    localajyy.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844809);
    localajyy.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    localajyy.jdField_a_of_type_JavaLangString = "";
    ViewCompat.setImportantForAccessibility(localajyy.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(localajyy.jdField_a_of_type_AndroidWidgetImageView, 2);
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    ajyy localajyy = (ajyy)paramView.getTag();
    Bitmap localBitmap = this.jdField_a_of_type_Bdbb.a(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_Bdbb.a(str, 1, false, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a();
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localajyy.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    if (this.jdField_a_of_type_Alto == null) {
      this.jdField_a_of_type_Alto = ((alto)this.app.getManager(51));
    }
    if ((str != null) && (this.jdField_a_of_type_Alto.b(str))) {}
    for (paramView = bdgc.a(this.app, str);; paramView = paramUserProfile)
    {
      localajyy.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      ViewCompat.setImportantForAccessibility(localajyy.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localajyy.jdField_a_of_type_AndroidWidgetImageView, 1);
      localajyy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView);
      localajyy.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramView + alud.a(2131703004));
      localajyy.jdField_a_of_type_JavaLangString = str;
      return;
    }
  }
  
  private void b()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371367));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379099));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377817));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131366788));
    this.i = ((ImageView)findViewById(2131366404));
    this.j = ((ImageView)findViewById(2131376805));
    this.k = ((ImageView)findViewById(2131376546));
    this.l = ((ImageView)findViewById(2131365637));
    this.m = ((ImageView)findViewById(2131371174));
    this.n = ((ImageView)findViewById(2131380394));
    this.o = ((ImageView)findViewById(2131365082));
    this.jdField_e_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_g_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_h_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365285));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365287));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365286));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365284));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372367);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839229);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364781));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380282));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364924));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377796));
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131365274));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131371327));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377798));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365362);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689735));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689735));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368626));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368655));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689738));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689738));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131719696));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131719696));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131719697));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131719697));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690623);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131703006));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new ajyq(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363407));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(2131690648);
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(alud.a(2131703003));
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new ajyr(this));
    }
  }
  
  private void b(int paramInt)
  {
    ThreadManager.post(new CreateFaceToFaceDiscussionActivity.9(this, paramInt), 8, null, false);
  }
  
  private void c()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
      this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(400L);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidWidgetTableLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.start();
    this.jdField_a_of_type_AndroidWidgetTableLayout.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.jdField_a_of_type_AndroidWidgetTextView.getBottom());
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ajyt(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    azqs.b(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.jdField_a_of_type_JavaLangStringBuffer.toString(), "", "", "");
  }
  
  private void d()
  {
    int i1 = 1;
    if (bdin.d(this))
    {
      this.jdField_a_of_type_Bety = new bety(this, getResources().getDimensionPixelSize(2131298914));
      this.jdField_a_of_type_Bety.c(2131721007);
      this.jdField_a_of_type_Bety.show();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        a(i1);
        return;
        i1 = 0;
      }
    }
    a(1, getString(2131694831));
  }
  
  public String a()
  {
    int i1 = 0;
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
    int i2 = this.jdField_a_of_type_JavaLangStringBuffer.length();
    if (i2 > 0) {
      while (i1 < i2)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_JavaLangStringBuffer.charAt(i1));
        if (i1 < i2 - 1) {
          this.jdField_a_of_type_JavaLangStringBuilder.append(65292);
        }
        i1 += 1;
      }
    }
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755151);
    super.doOnCreate(paramBundle);
    setContentView(2131562623);
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    paramBundle = getIntent();
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("create_source", 0);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    b();
    this.app.addObserver(this.jdField_a_of_type_Alxi);
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    this.jdField_a_of_type_Bdbb = new bdbb(this, this.app);
    this.jdField_a_of_type_Bdbb.a(this);
    this.jdField_a_of_type_Ajyx = new ajyx(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367311));
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Ajyx);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.str_nick.set(this.app.getCurrentNickname());
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ajyp(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a(new CreateFaceToFaceDiscussionActivity.2(this));
    azqs.b(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Alxi);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.jdField_a_of_type_Boolean) && (bdin.d(this))) {
      a(4);
    }
    if (this.jdField_a_of_type_Bdbb != null)
    {
      this.jdField_a_of_type_Bdbb.d();
      this.jdField_a_of_type_Bdbb = null;
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.jdField_c_of_type_Boolean)
      {
        azqs.b(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
        finish();
        if (this.jdField_e_of_type_Boolean) {
          overridePendingTransition(2130771988, 2130771989);
        }
      }
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      azqs.b(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
      break;
      switch (paramInt)
      {
      default: 
        break;
      case 7: 
        this.n.performClick();
        break;
      case 8: 
        this.jdField_e_of_type_AndroidWidgetImageView.performClick();
        break;
      case 9: 
        this.jdField_f_of_type_AndroidWidgetImageView.performClick();
        break;
      case 10: 
        this.jdField_g_of_type_AndroidWidgetImageView.performClick();
        break;
      case 11: 
        this.jdField_h_of_type_AndroidWidgetImageView.performClick();
        break;
      case 12: 
        this.i.performClick();
        break;
      case 13: 
        this.j.performClick();
        break;
      case 14: 
        this.k.performClick();
        break;
      case 15: 
        this.l.performClick();
        break;
      case 16: 
        this.m.performClick();
        break;
      case 67: 
        this.o.performClick();
      }
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0))) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
    }
  }
  
  public void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2130771978);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364924)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        azqs.b(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
      }
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_JavaLangStringBuffer.length();
    } while (i1 >= 4);
    label200:
    int i2;
    switch (paramView.getId())
    {
    default: 
      this.jdField_b_of_type_AndroidWidgetTableLayout.setContentDescription(a());
      i2 = this.jdField_a_of_type_JavaLangStringBuffer.length();
      i1 = -1;
      switch (this.jdField_a_of_type_JavaLangStringBuffer.charAt(i2 - 1))
      {
      }
      break;
    }
    for (;;)
    {
      switch (i2)
      {
      default: 
        return;
      case 1: 
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
        return;
        this.jdField_a_of_type_JavaLangStringBuffer.append('1');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('2');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('3');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('4');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('5');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('6');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('7');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('8');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('9');
        break label200;
        this.jdField_a_of_type_JavaLangStringBuffer.append('0');
        break label200;
        if ((i1 > 0) && (i1 < 4)) {
          this.jdField_a_of_type_JavaLangStringBuffer.deleteCharAt(i1 - 1);
        }
        this.jdField_b_of_type_AndroidWidgetTableLayout.setContentDescription(a());
        switch (i1)
        {
        default: 
          return;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844834);
          return;
        case 2: 
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844834);
          return;
        case 3: 
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844834);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130844834);
        return;
        i1 = 2130844824;
        continue;
        i1 = 2130844825;
        continue;
        i1 = 2130844826;
        continue;
        i1 = 2130844827;
        continue;
        i1 = 2130844828;
        continue;
        i1 = 2130844829;
        continue;
        i1 = 2130844830;
        continue;
        i1 = 2130844831;
        continue;
        i1 = 2130844832;
        continue;
        i1 = 2130844833;
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i1);
    return;
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i1);
    return;
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(i1);
    this.jdField_e_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_f_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_g_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_h_of_type_AndroidWidgetImageView.setEnabled(false);
    this.i.setEnabled(false);
    this.j.setEnabled(false);
    this.k.setEnabled(false);
    this.l.setEnabled(false);
    this.m.setEnabled(false);
    this.n.setEnabled(false);
    this.o.setEnabled(false);
    if ((this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("1234")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("1111")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("2222")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("3333")) || (this.jdField_a_of_type_JavaLangStringBuffer.toString().equals("0000")))
    {
      if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131720896), 0).a();
      azqs.b(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    if (bdin.d(this))
    {
      this.jdField_a_of_type_AndroidWidgetTableLayout.setEnabled(false);
      a(2);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    a(1, getString(2131694831));
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_AndroidWidgetGridView.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof ajyy)))
      {
        localObject = (ajyy)localObject;
        if (((ajyy)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          ((ajyy)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      paramInt1 += 1;
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */