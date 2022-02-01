package com.tencent.mobileqq.activity.selectmember;

import Override;
import alrf;
import alrh;
import alri;
import alrj;
import alrk;
import alrl;
import alrm;
import alrn;
import alro;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
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
import anmw;
import anni;
import anqo;
import aobu;
import aobv;
import bcst;
import bglf;
import bgmo;
import bgnt;
import biau;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mqq.os.MqqHandler;
import tencent.im.nearfield_discuss.nearfield_discuss.GPS;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class CreateFaceToFaceDiscussionActivity
  extends LbsBaseActivity
  implements View.OnClickListener, aobv
{
  public int a;
  public long a;
  public alrn a;
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
  anmw jdField_a_of_type_Anmw;
  private anqo jdField_a_of_type_Anqo = new alrl(this);
  aobu jdField_a_of_type_Aobu;
  public biau a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CreateFaceToFaceDiscussionActivity.3(this);
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
    this.jdField_a_of_type_AndroidOsHandler = new alrj(this);
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
        requestPermissions(new alrm(this, paramInt), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      b(paramInt);
      return;
    }
    b(paramInt);
  }
  
  private void a(View paramView)
  {
    alro localalro = (alro)paramView.getTag();
    localalro.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845206);
    localalro.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    localalro.jdField_a_of_type_JavaLangString = "";
    ViewCompat.setImportantForAccessibility(localalro.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(localalro.jdField_a_of_type_AndroidWidgetImageView, 2);
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    alro localalro = (alro)paramView.getTag();
    Bitmap localBitmap = this.jdField_a_of_type_Aobu.a(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_Aobu.a(str, 1, false, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = bgmo.a();
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localalro.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    if (this.jdField_a_of_type_Anmw == null) {
      this.jdField_a_of_type_Anmw = ((anmw)this.app.getManager(51));
    }
    if ((str != null) && (this.jdField_a_of_type_Anmw.b(str))) {}
    for (paramView = bglf.a(this.app, str);; paramView = paramUserProfile)
    {
      localalro.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      ViewCompat.setImportantForAccessibility(localalro.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localalro.jdField_a_of_type_AndroidWidgetImageView, 1);
      localalro.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView);
      localalro.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramView + anni.a(2131701411));
      localalro.jdField_a_of_type_JavaLangString = str;
      return;
    }
  }
  
  private void a(nearfield_discuss.UserProfile paramUserProfile)
  {
    if (paramUserProfile == null) {}
    String str1;
    String str2;
    do
    {
      return;
      str1 = this.app.getAccount();
      str2 = bglf.k(this.app, str1);
      paramUserProfile.str_nick.set(str2);
    } while ((!TextUtils.isEmpty(str2)) && (!TextUtils.equals(str2, str1)));
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void b()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371935));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380022));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378658));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367056));
    this.i = ((ImageView)findViewById(2131366657));
    this.j = ((ImageView)findViewById(2131377617));
    this.k = ((ImageView)findViewById(2131377336));
    this.l = ((ImageView)findViewById(2131365871));
    this.m = ((ImageView)findViewById(2131371735));
    this.n = ((ImageView)findViewById(2131381401));
    this.o = ((ImageView)findViewById(2131365319));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365525));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365527));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365526));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365524));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131372961);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839406);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365009));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381268));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365159));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378635));
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131365517));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131371893));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378637));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365599);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368994));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689639));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689639));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368947));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368949));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368979));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689642));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689642));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131717701));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131717701));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131717702));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131717702));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690563);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131701413));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new alrh(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363601));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(2131690582);
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(anni.a(2131701410));
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new alri(this));
    }
  }
  
  private void b(int paramInt)
  {
    ThreadManager.post(new CreateFaceToFaceDiscussionActivity.10(this, paramInt), 8, null, false);
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
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new alrk(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    bcst.b(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.jdField_a_of_type_JavaLangStringBuffer.toString(), "", "", "");
  }
  
  private void d()
  {
    int i1 = 1;
    if (bgnt.d(this))
    {
      this.jdField_a_of_type_Biau = new biau(this, getResources().getDimensionPixelSize(2131298998));
      this.jdField_a_of_type_Biau.c(2131718735);
      this.jdField_a_of_type_Biau.show();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        a(i1);
        return;
        i1 = 0;
      }
    }
    a(1, getString(2131693991));
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
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755152);
    super.doOnCreate(paramBundle);
    setContentView(2131562861);
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    paramBundle = getIntent();
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("create_source", 0);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    b();
    this.app.addObserver(this.jdField_a_of_type_Anqo);
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    this.jdField_a_of_type_Aobu = new aobu(this, this.app);
    this.jdField_a_of_type_Aobu.a(this);
    this.jdField_a_of_type_Alrn = new alrn(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367617));
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Alrn);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    a(this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new alrf(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a(new CreateFaceToFaceDiscussionActivity.2(this));
    bcst.b(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Anqo);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_Boolean) && (bgnt.d(this))) {
      a(4);
    }
    if (this.jdField_a_of_type_Aobu != null)
    {
      this.jdField_a_of_type_Aobu.d();
      this.jdField_a_of_type_Aobu = null;
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
        bcst.b(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
        finish();
        if (this.jdField_e_of_type_Boolean) {
          overridePendingTransition(2130771988, 2130771989);
        }
      }
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      bcst.b(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
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
    if (paramView.getId() == 2131365159)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        bcst.b(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i1 = this.jdField_a_of_type_JavaLangStringBuffer.length();
      if (i1 < 4)
      {
        label208:
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
            break;
          case 1: 
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i1);
            break;
            this.jdField_a_of_type_JavaLangStringBuffer.append('1');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('2');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('3');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('4');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('5');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('6');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('7');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('8');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('9');
            break label208;
            this.jdField_a_of_type_JavaLangStringBuffer.append('0');
            break label208;
            if ((i1 > 0) && (i1 < 4)) {
              this.jdField_a_of_type_JavaLangStringBuffer.deleteCharAt(i1 - 1);
            }
            this.jdField_b_of_type_AndroidWidgetTableLayout.setContentDescription(a());
            switch (i1)
            {
            }
            for (;;)
            {
              break;
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845231);
              continue;
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845231);
              continue;
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845231);
              continue;
              this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845231);
            }
            i1 = 2130845221;
            continue;
            i1 = 2130845222;
            continue;
            i1 = 2130845223;
            continue;
            i1 = 2130845224;
            continue;
            i1 = 2130845225;
            continue;
            i1 = 2130845226;
            continue;
            i1 = 2130845227;
            continue;
            i1 = 2130845228;
            continue;
            i1 = 2130845229;
            continue;
            i1 = 2130845230;
          }
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(i1);
        continue;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i1);
        continue;
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131718634), 0).a();
          bcst.b(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
          if (bgnt.d(this))
          {
            this.jdField_a_of_type_AndroidWidgetTableLayout.setEnabled(false);
            a(2);
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            a(1, getString(2131693991));
            ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
            this.jdField_a_of_type_AndroidViewView.setVisibility(4);
            if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
              this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
            }
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 600L);
          }
        }
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.jdField_a_of_type_AndroidWidgetGridView.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetGridView.getChildAt(paramInt1).getTag();
      if ((localObject != null) && ((localObject instanceof alro)))
      {
        localObject = (alro)localObject;
        if (((alro)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          ((alro)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */