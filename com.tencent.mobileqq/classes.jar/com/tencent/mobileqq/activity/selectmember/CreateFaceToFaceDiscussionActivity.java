package com.tencent.mobileqq.activity.selectmember;

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
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.NearFieldDiscussObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
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
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  int jdField_a_of_type_Int = -1;
  long jdField_a_of_type_Long = 60000L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler = new CreateFaceToFaceDiscussionActivity.6(this);
  View jdField_a_of_type_AndroidViewView;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  GridView jdField_a_of_type_AndroidWidgetGridView;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TableLayout jdField_a_of_type_AndroidWidgetTableLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  CreateFaceToFaceDiscussionActivity.GridViewAdapter jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$GridViewAdapter;
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private NearFieldDiscussObserver jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver = new CreateFaceToFaceDiscussionActivity.8(this);
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CreateFaceToFaceDiscussionActivity.3(this);
  StringBuffer jdField_a_of_type_JavaLangStringBuffer = new StringBuffer(4);
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  List<nearfield_discuss.UserProfile> jdField_a_of_type_JavaUtilList = new ArrayList();
  nearfield_discuss.LBSInfo jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
  nearfield_discuss.UserProfile jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  TranslateAnimation jdField_b_of_type_AndroidViewAnimationTranslateAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  TableLayout jdField_b_of_type_AndroidWidgetTableLayout;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  boolean jdField_b_of_type_Boolean = true;
  final int jdField_c_of_type_Int = 0;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean;
  final int jdField_d_of_type_Int = 1;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  boolean jdField_d_of_type_Boolean = true;
  final int jdField_e_of_type_Int = 2;
  ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  final int jdField_f_of_type_Int = 50;
  ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  final int jdField_g_of_type_Int = 11;
  ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  int jdField_h_of_type_Int = 0;
  ImageView jdField_h_of_type_AndroidWidgetImageView;
  ImageView i;
  ImageView j;
  ImageView k;
  ImageView l;
  ImageView m;
  ImageView n;
  ImageView o;
  
  private nearfield_discuss.LBSInfo a(SosoLbsInfo paramSosoLbsInfo)
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
        requestPermissions(new CreateFaceToFaceDiscussionActivity.9(this, paramInt), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      b(paramInt);
      return;
    }
    b(paramInt);
  }
  
  private void a(View paramView)
  {
    CreateFaceToFaceDiscussionActivity.ViewHolder localViewHolder = (CreateFaceToFaceDiscussionActivity.ViewHolder)paramView.getTag();
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845344);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    localViewHolder.jdField_a_of_type_JavaLangString = "";
    ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetImageView, 2);
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    CreateFaceToFaceDiscussionActivity.ViewHolder localViewHolder = (CreateFaceToFaceDiscussionActivity.ViewHolder)paramView.getTag();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(str, 1, false, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    }
    if ((str != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(str))) {}
    for (paramView = ContactUtils.a(this.app, str);; paramView = paramUserProfile)
    {
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, 1);
      ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetImageView, 1);
      localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView);
      localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramView + HardCodeUtil.a(2131702652));
      localViewHolder.jdField_a_of_type_JavaLangString = str;
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
      str2 = ContactUtils.k(this.app, str1);
      paramUserProfile.str_nick.set(str2);
    } while ((!TextUtils.isEmpty(str2)) && (!TextUtils.equals(str2, str1)));
    ThreadManager.getSubThreadHandler().post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  private void b(int paramInt)
  {
    ThreadManager.post(new CreateFaceToFaceDiscussionActivity.10(this, paramInt), 8, null, false);
  }
  
  private void d()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372508));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380717));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131379305));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131367427));
    this.i = ((ImageView)findViewById(2131367043));
    this.j = ((ImageView)findViewById(2131378224));
    this.k = ((ImageView)findViewById(2131377923));
    this.l = ((ImageView)findViewById(2131366218));
    this.m = ((ImageView)findViewById(2131372306));
    this.n = ((ImageView)findViewById(2131382135));
    this.o = ((ImageView)findViewById(2131365650));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365856));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365858));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365857));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365855));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131373580);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130839549);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131365304));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131381983));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131365460));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379281));
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131365848));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131372464));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379283));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131365931);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369534));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689647));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689647));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369487));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369489));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369518));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131689650));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131689650));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131718978));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718978));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131718979));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131718979));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131690778);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131702654));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new CreateFaceToFaceDiscussionActivity.4(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131363822));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(2131690800);
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription(HardCodeUtil.a(2131702651));
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new CreateFaceToFaceDiscussionActivity.5(this));
    }
  }
  
  private void e()
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
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new CreateFaceToFaceDiscussionActivity.7(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ReportController.b(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.jdField_a_of_type_JavaLangStringBuffer.toString(), "", "", "");
  }
  
  private void f()
  {
    int i1 = 1;
    if (NetworkUtil.d(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131299166));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131720120);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        a(i1);
        return;
        i1 = 0;
      }
    }
    a(1, getString(2131694510));
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
  
  public void b()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80041AC", "0X80041AC", 0, 0, "", "", "", "");
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
    setTheme(2131755155);
    super.doOnCreate(paramBundle);
    setContentView(2131562992);
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    paramBundle = getIntent();
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("create_source", 0);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    d();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver);
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$GridViewAdapter = new CreateFaceToFaceDiscussionActivity.GridViewAdapter(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131368062));
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity$GridViewAdapter);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    a(this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile);
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new CreateFaceToFaceDiscussionActivity.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a(new CreateFaceToFaceDiscussionActivity.2(this));
    ReportController.b(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    if ((this.jdField_a_of_type_Boolean) && (NetworkUtil.d(this))) {
      a(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = null;
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
        ReportController.b(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
        finish();
        if (this.jdField_e_of_type_Boolean) {
          overridePendingTransition(2130771990, 2130771991);
        }
      }
    }
    for (;;)
    {
      return super.doOnKeyDown(paramInt, paramKeyEvent);
      ReportController.b(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
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
    overridePendingTransition(0, 2130771980);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365460)
    {
      this.jdField_a_of_type_Boolean = false;
      f();
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        ReportController.b(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
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
              this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845369);
              continue;
              this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130845369);
              continue;
              this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845369);
              continue;
              this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845369);
            }
            i1 = 2130845359;
            continue;
            i1 = 2130845360;
            continue;
            i1 = 2130845361;
            continue;
            i1 = 2130845362;
            continue;
            i1 = 2130845363;
            continue;
            i1 = 2130845364;
            continue;
            i1 = 2130845365;
            continue;
            i1 = 2130845366;
            continue;
            i1 = 2130845367;
            continue;
            i1 = 2130845368;
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
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131719987), 0).a();
          ReportController.b(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
        }
        else
        {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
          if (NetworkUtil.d(this))
          {
            this.jdField_a_of_type_AndroidWidgetTableLayout.setEnabled(false);
            a(2);
            this.jdField_a_of_type_Boolean = true;
          }
          else
          {
            a(1, getString(2131694510));
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
      if ((localObject != null) && ((localObject instanceof CreateFaceToFaceDiscussionActivity.ViewHolder)))
      {
        localObject = (CreateFaceToFaceDiscussionActivity.ViewHolder)localObject;
        if (((CreateFaceToFaceDiscussionActivity.ViewHolder)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          ((CreateFaceToFaceDiscussionActivity.ViewHolder)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
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