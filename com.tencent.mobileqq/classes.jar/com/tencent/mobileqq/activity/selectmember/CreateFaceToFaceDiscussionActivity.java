package com.tencent.mobileqq.activity.selectmember;

import Override;
import akyy;
import akza;
import akzb;
import akzc;
import akzd;
import akze;
import akzf;
import akzg;
import akzh;
import amsw;
import amtj;
import amww;
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
import bcef;
import bfvo;
import bhht;
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  public long a;
  public akzg a;
  amsw jdField_a_of_type_Amsw;
  private amww jdField_a_of_type_Amww = new akze(this);
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
  public bhht a;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
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
    this.jdField_a_of_type_AndroidOsHandler = new akzc(this);
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
      localGPS.int32_lat.set((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      localGPS.int32_lon.set((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      localGPS.int32_alt.set(-1);
      localGPS.eType.set(1);
      localLBSInfo.msg_gps.set(localGPS);
      localStringBuffer.append(" GPS: ").append(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).append(",").append(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
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
        requestPermissions(new akzf(this, paramInt), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      b(paramInt);
      return;
    }
    b(paramInt);
  }
  
  private void a(View paramView)
  {
    akzh localakzh = (akzh)paramView.getTag();
    localakzh.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845108);
    localakzh.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    localakzh.jdField_a_of_type_JavaLangString = "";
    ViewCompat.setImportantForAccessibility(localakzh.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(localakzh.jdField_a_of_type_AndroidWidgetImageView, 2);
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    akzh localakzh = (akzh)paramView.getTag();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(str, 1, false, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a();
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localakzh.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    if (this.jdField_a_of_type_Amsw == null) {
      this.jdField_a_of_type_Amsw = ((amsw)this.app.getManager(51));
    }
    if ((str != null) && (this.jdField_a_of_type_Amsw.b(str))) {}
    for (paramView = ContactUtils.getFriendNick(this.app, str);; paramView = paramUserProfile)
    {
      localakzh.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      ViewCompat.setImportantForAccessibility(localakzh.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localakzh.jdField_a_of_type_AndroidWidgetImageView, 1);
      localakzh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView);
      localakzh.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramView + amtj.a(2131701753));
      localakzh.jdField_a_of_type_JavaLangString = str;
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
      str2 = ContactUtils.getFriendDisplayNameJustCache(this.app, str1);
      paramUserProfile.str_nick.set(str2);
    } while ((!TextUtils.isEmpty(str2)) && (!TextUtils.equals(str2, str1)));
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void b()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372014));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379935));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131378580));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367123));
    this.i = ((ImageView)findViewById(2131366737));
    this.j = ((ImageView)findViewById(2131377539));
    this.k = ((ImageView)findViewById(2131377239));
    this.l = ((ImageView)findViewById(2131365946));
    this.m = ((ImageView)findViewById(2131371808));
    this.n = ((ImageView)findViewById(2131381307));
    this.o = ((ImageView)findViewById(2131365396));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365600));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365602));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365601));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365599));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373044);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839449);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365083));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381160));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365228));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378558));
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131365592));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131371971));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378560));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365675);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369115));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689640));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689640));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369068));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369070));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369099));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689643));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689643));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131718070));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718070));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718071));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718071));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690599);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131701755));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new akza(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363657));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(2131690620);
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(amtj.a(2131701752));
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new akzb(this));
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
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new akzd(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    bcef.b(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.jdField_a_of_type_JavaLangStringBuffer.toString(), "", "", "");
  }
  
  private void d()
  {
    int i1 = 1;
    if (NetworkUtil.isNetSupport(this))
    {
      this.jdField_a_of_type_Bhht = new bhht(this, getResources().getDimensionPixelSize(2131299076));
      this.jdField_a_of_type_Bhht.c(2131719144);
      this.jdField_a_of_type_Bhht.show();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        a(i1);
        return;
        i1 = 0;
      }
    }
    a(1, getString(2131694108));
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
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755153);
    super.doOnCreate(paramBundle);
    setContentView(2131562774);
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    paramBundle = getIntent();
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("create_source", 0);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    b();
    this.app.addObserver(this.jdField_a_of_type_Amww);
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_Akzg = new akzg(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131367718));
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Akzg);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    a(this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new akyy(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a(new CreateFaceToFaceDiscussionActivity.2(this));
    bcef.b(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Amww);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_Boolean) && (NetworkUtil.isNetSupport(this))) {
      a(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = null;
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
        bcef.b(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
        finish();
        if (this.jdField_e_of_type_Boolean) {
          overridePendingTransition(2130771988, 2130771989);
        }
      }
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      bcef.b(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
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
    if (paramView.getId() == 2131365228)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        bcef.b(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i1 = this.jdField_a_of_type_JavaLangStringBuffer.length();
      if (i1 < 4)
      {
        label212:
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
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('2');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('3');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('4');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('5');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('6');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('7');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('8');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('9');
            break label212;
            this.jdField_a_of_type_JavaLangStringBuffer.append('0');
            break label212;
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
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845133);
              continue;
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845133);
              continue;
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845133);
              continue;
              this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845133);
            }
            i1 = 2130845123;
            continue;
            i1 = 2130845124;
            continue;
            i1 = 2130845125;
            continue;
            i1 = 2130845126;
            continue;
            i1 = 2130845127;
            continue;
            i1 = 2130845128;
            continue;
            i1 = 2130845129;
            continue;
            i1 = 2130845130;
            continue;
            i1 = 2130845131;
            continue;
            i1 = 2130845132;
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131719019), 0).a();
          bcef.b(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
          if (NetworkUtil.isNetSupport(this))
          {
            this.jdField_a_of_type_AndroidWidgetTableLayout.setEnabled(false);
            a(2);
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            a(1, getString(2131694108));
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
      if ((localObject != null) && ((localObject instanceof akzh)))
      {
        localObject = (akzh)localObject;
        if (((akzh)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          ((akzh)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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