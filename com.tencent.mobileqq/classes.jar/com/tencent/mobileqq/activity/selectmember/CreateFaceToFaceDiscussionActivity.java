package com.tencent.mobileqq.activity.selectmember;

import ahqa;
import ahqb;
import ahqc;
import ahqd;
import ahqe;
import ahqf;
import ahqg;
import ahqi;
import ahqj;
import ajjj;
import ajjy;
import ajmw;
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
import awqx;
import azwg;
import azwh;
import babh;
import bacm;
import badq;
import bbms;
import bbmy;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tencent.im.nearfield_discuss.nearfield_discuss.GPS;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class CreateFaceToFaceDiscussionActivity
  extends LbsBaseActivity
  implements View.OnClickListener, azwh
{
  public int a;
  public long a;
  public ahqi a;
  ajjj jdField_a_of_type_Ajjj;
  private ajmw jdField_a_of_type_Ajmw = new ahqf(this);
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
  azwg jdField_a_of_type_Azwg;
  public bbms a;
  public StringBuffer a;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public List<nearfield_discuss.UserProfile> a;
  nearfield_discuss.LBSInfo jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
  public nearfield_discuss.UserProfile a;
  boolean jdField_a_of_type_Boolean = false;
  public int b;
  View jdField_b_of_type_AndroidViewView;
  public TranslateAnimation b;
  public ImageView b;
  public LinearLayout b;
  TableLayout jdField_b_of_type_AndroidWidgetTableLayout;
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
    this.jdField_a_of_type_AndroidOsHandler = new ahqd(this);
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
        requestPermissions(new ahqg(this, paramInt), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      b(paramInt);
      return;
    }
    b(paramInt);
  }
  
  private void a(View paramView)
  {
    ahqj localahqj = (ahqj)paramView.getTag();
    localahqj.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844289);
    localahqj.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    localahqj.jdField_a_of_type_JavaLangString = "";
    ViewCompat.setImportantForAccessibility(localahqj.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(localahqj.jdField_a_of_type_AndroidWidgetImageView, 2);
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    ahqj localahqj = (ahqj)paramView.getTag();
    Bitmap localBitmap = this.jdField_a_of_type_Azwg.a(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_Azwg.a(str, 1, false, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = bacm.a();
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localahqj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    if (this.jdField_a_of_type_Ajjj == null) {
      this.jdField_a_of_type_Ajjj = ((ajjj)this.app.getManager(51));
    }
    if ((str != null) && (this.jdField_a_of_type_Ajjj.b(str))) {}
    for (paramView = babh.a(this.app, str);; paramView = paramUserProfile)
    {
      localahqj.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      ViewCompat.setImportantForAccessibility(localahqj.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localahqj.jdField_a_of_type_AndroidWidgetImageView, 1);
      localahqj.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView);
      localahqj.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramView + ajjy.a(2131636825));
      localahqj.jdField_a_of_type_JavaLangString = str;
      return;
    }
  }
  
  private void b()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131305343));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131312599));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131311425));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131301049));
    this.i = ((ImageView)findViewById(2131300701));
    this.j = ((ImageView)findViewById(2131310454));
    this.k = ((ImageView)findViewById(2131310224));
    this.l = ((ImageView)findViewById(2131299970));
    this.m = ((ImageView)findViewById(2131305172));
    this.n = ((ImageView)findViewById(2131313751));
    this.o = ((ImageView)findViewById(2131299428));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299631));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299633));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299632));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299630));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131306333);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839117);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131299142));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131313666));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131299274));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311408));
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131299620));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131305321));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131311410));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131299708);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302847));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131624194));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131624194));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302804));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302806));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131302832));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131624197));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131624197));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131653363));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131653363));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131653364));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131653364));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131625011);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131636827));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new ahqb(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131297823));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(2131625035);
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(ajjy.a(2131636824));
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new ahqc(this));
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
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ahqe(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    awqx.b(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.jdField_a_of_type_JavaLangStringBuffer.toString(), "", "", "");
  }
  
  private void d()
  {
    int i1 = 1;
    if (badq.d(this))
    {
      this.jdField_a_of_type_Bbms = new bbms(this, getResources().getDimensionPixelSize(2131167766));
      this.jdField_a_of_type_Bbms.c(2131654550);
      this.jdField_a_of_type_Bbms.show();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        a(i1);
        return;
        i1 = 0;
      }
    }
    a(1, getString(2131629008));
  }
  
  String a()
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
    setTheme(2131689611);
    super.doOnCreate(paramBundle);
    setContentView(2131496802);
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    paramBundle = getIntent();
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("create_source", 0);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    b();
    this.app.addObserver(this.jdField_a_of_type_Ajmw);
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    this.jdField_a_of_type_Azwg = new azwg(this, this.app);
    this.jdField_a_of_type_Azwg.a(this);
    this.jdField_a_of_type_Ahqi = new ahqi(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131301559));
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Ahqi);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.str_nick.set(this.app.getCurrentNickname());
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new ahqa(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a(new CreateFaceToFaceDiscussionActivity.2(this));
    awqx.b(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Ajmw);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.jdField_a_of_type_Boolean) && (badq.d(this))) {
      a(4);
    }
    if (this.jdField_a_of_type_Azwg != null)
    {
      this.jdField_a_of_type_Azwg.d();
      this.jdField_a_of_type_Azwg = null;
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
        awqx.b(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
        finish();
        if (this.jdField_e_of_type_Boolean) {
          overridePendingTransition(2130771988, 2130771989);
        }
      }
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      awqx.b(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
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
    if (paramView.getId() == 2131299274)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        awqx.b(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
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
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844314);
          return;
        case 2: 
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130844314);
          return;
        case 3: 
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130844314);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130844314);
        return;
        i1 = 2130844304;
        continue;
        i1 = 2130844305;
        continue;
        i1 = 2130844306;
        continue;
        i1 = 2130844307;
        continue;
        i1 = 2130844308;
        continue;
        i1 = 2130844309;
        continue;
        i1 = 2130844310;
        continue;
        i1 = 2130844311;
        continue;
        i1 = 2130844312;
        continue;
        i1 = 2130844313;
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
      bbmy.a(this.jdField_a_of_type_AndroidContentContext, getString(2131654442), 0).a();
      awqx.b(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    if (badq.d(this))
    {
      this.jdField_a_of_type_AndroidWidgetTableLayout.setEnabled(false);
      a(2);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    a(1, getString(2131629008));
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
      if ((localObject != null) && ((localObject instanceof ahqj)))
      {
        localObject = (ahqj)localObject;
        if (((ahqj)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          ((ahqj)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */