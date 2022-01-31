package com.tencent.mobileqq.activity.selectmember;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
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
import com.tencent.mobileqq.activity.LbsBaseActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.NearFieldDiscussObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.util.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import tencent.im.nearfield_discuss.nearfield_discuss.Cell;
import tencent.im.nearfield_discuss.nearfield_discuss.GPS;
import tencent.im.nearfield_discuss.nearfield_discuss.LBSInfo;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;
import tencent.im.nearfield_discuss.nearfield_discuss.Wifi;
import xuz;
import xva;
import xvb;
import xvc;
import xvd;
import xve;
import xvf;
import xvg;
import xvi;
import xvj;

public class CreateFaceToFaceDiscussionActivity
  extends LbsBaseActivity
  implements View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener
{
  public int a;
  public long a;
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
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  private NearFieldDiscussObserver jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver = new xvf(this);
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  public QQProgressDialog a;
  public StringBuffer a;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
  public List a;
  nearfield_discuss.LBSInfo jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
  public nearfield_discuss.UserProfile a;
  public xvi a;
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
    this.jdField_a_of_type_AndroidOsHandler = new xvd(this);
    this.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  private nearfield_discuss.LBSInfo a(SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramSosoLbsInfo == null) {
      return this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo;
    }
    nearfield_discuss.LBSInfo localLBSInfo = new nearfield_discuss.LBSInfo();
    Object localObject1 = new nearfield_discuss.GPS();
    ((nearfield_discuss.GPS)localObject1).int32_lat.set((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D));
    ((nearfield_discuss.GPS)localObject1).int32_lon.set((int)(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D));
    ((nearfield_discuss.GPS)localObject1).int32_alt.set(-1);
    ((nearfield_discuss.GPS)localObject1).eType.set(0);
    localLBSInfo.msg_gps.set((MessageMicro)localObject1);
    localStringBuffer.append(" GPS: ").append(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.c * 1000000.0D).append(",").append(paramSosoLbsInfo.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.d * 1000000.0D);
    Object localObject2;
    if (paramSosoLbsInfo.b != null)
    {
      localObject1 = paramSosoLbsInfo.b.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (SosoInterface.SosoWifi)((Iterator)localObject1).next();
        nearfield_discuss.Wifi localWifi = new nearfield_discuss.Wifi();
        localWifi.uint64_mac.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long);
        localWifi.int32_rssi.set(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int);
        localLBSInfo.rpt_msg_wifis.add(localWifi);
        localStringBuffer.append("| WIFI: ").append(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Long).append(",").append(((SosoInterface.SosoWifi)localObject2).jdField_a_of_type_Int);
      }
    }
    if (paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList != null)
    {
      paramSosoLbsInfo = paramSosoLbsInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramSosoLbsInfo.hasNext())
      {
        localObject1 = (SosoInterface.SosoCell)paramSosoLbsInfo.next();
        localObject2 = new nearfield_discuss.Cell();
        ((nearfield_discuss.Cell)localObject2).int32_mcc.set(((SosoInterface.SosoCell)localObject1).jdField_a_of_type_Int);
        ((nearfield_discuss.Cell)localObject2).int32_mnc.set(((SosoInterface.SosoCell)localObject1).jdField_b_of_type_Int);
        ((nearfield_discuss.Cell)localObject2).int32_lac.set(((SosoInterface.SosoCell)localObject1).jdField_c_of_type_Int);
        ((nearfield_discuss.Cell)localObject2).int32_cellid.set(((SosoInterface.SosoCell)localObject1).jdField_d_of_type_Int);
        ((nearfield_discuss.Cell)localObject2).int32_rssi.set(((SosoInterface.SosoCell)localObject1).jdField_e_of_type_Int);
        localLBSInfo.rpt_msg_cells.add((MessageMicro)localObject2);
        localStringBuffer.append("| CELL: ").append(((SosoInterface.SosoCell)localObject1).jdField_a_of_type_Int).append(",").append(((SosoInterface.SosoCell)localObject1).jdField_b_of_type_Int).append(",").append(((SosoInterface.SosoCell)localObject1).jdField_c_of_type_Int).append(",").append(((SosoInterface.SosoCell)localObject1).jdField_d_of_type_Int).append(",").append(((SosoInterface.SosoCell)localObject1).jdField_e_of_type_Int);
      }
    }
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$LBSInfo = localLBSInfo;
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, localStringBuffer.toString());
    }
    return localLBSInfo;
  }
  
  private void a(int paramInt)
  {
    ThreadManager.post(new xvg(this, paramInt), 8, null, false);
  }
  
  private void a(View paramView)
  {
    paramView = (xvj)paramView.getTag();
    paramView.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842442);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    paramView.jdField_a_of_type_JavaLangString = "";
    paramView.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramView.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(null);
  }
  
  private void a(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str = String.valueOf(paramUserProfile.uint64_uin.get());
    paramUserProfile = paramUserProfile.str_nick.get();
    xvj localxvj = (xvj)paramView.getTag();
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(1, str);
    paramView = localBitmap;
    if (localBitmap == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(str, 1, false, (byte)1);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
      }
      paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
    }
    localxvj.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(50));
    }
    if ((str != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager.b(str))) {}
    for (paramView = ContactUtils.a(this.app, str);; paramView = paramUserProfile)
    {
      localxvj.jdField_a_of_type_AndroidWidgetTextView.setText(paramView);
      localxvj.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(paramView);
      localxvj.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(paramView + "头像");
      localxvj.jdField_a_of_type_JavaLangString = str;
      return;
    }
  }
  
  private void b()
  {
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374863));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374864));
    this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374865));
    this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374866));
    this.i = ((ImageView)findViewById(2131374867));
    this.j = ((ImageView)findViewById(2131374868));
    this.k = ((ImageView)findViewById(2131374869));
    this.l = ((ImageView)findViewById(2131374870));
    this.m = ((ImageView)findViewById(2131374871));
    this.n = ((ImageView)findViewById(2131374873));
    this.o = ((ImageView)findViewById(2131374775));
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
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374875));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374876));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374877));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131374878));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365629);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130838596);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364094));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131366072));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131368286));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374879));
    this.jdField_a_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131374862));
    this.jdField_b_of_type_AndroidWidgetTableLayout = ((TableLayout)findViewById(2131374874));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131374880));
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131363937);
    this.jdField_b_of_type_AndroidViewView.setVisibility(4);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363363));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131435481));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435481));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363227));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363455));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131363410));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getString(2131435482));
    this.jdField_d_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435482));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(getString(2131435954));
    this.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435954));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getString(2131435956));
    this.jdField_b_of_type_AndroidWidgetTextView.setContentDescription(getString(2131435956));
    if (this.jdField_e_of_type_Boolean)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_e_of_type_AndroidWidgetTextView.setText(2131433681);
      this.jdField_e_of_type_AndroidWidgetTextView.setContentDescription("返回，按钮");
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(new xvb(this));
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131364035));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(4);
      return;
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(2131432998);
      this.jdField_g_of_type_AndroidWidgetTextView.setContentDescription("取消，按钮");
      this.jdField_g_of_type_AndroidWidgetTextView.setOnClickListener(new xvc(this));
    }
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
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new xve(this));
    this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_b_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetLinearLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(500L);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    ReportController.b(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.jdField_a_of_type_JavaLangStringBuffer.toString(), "", "", "");
  }
  
  private void d()
  {
    int i1 = 1;
    if (NetworkUtil.d(this))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, getResources().getDimensionPixelSize(2131558448));
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131433968);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
      if (this.jdField_b_of_type_Boolean) {}
      for (;;)
      {
        a(i1);
        return;
        i1 = 0;
      }
    }
    a(1, getString(2131434596));
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131624736);
    super.doOnCreate(paramBundle);
    setContentView(2130971506);
    this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
    paramBundle = getIntent();
    this.jdField_h_of_type_Int = paramBundle.getIntExtra("create_source", 0);
    this.jdField_e_of_type_Boolean = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    b();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver);
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.a(this);
    this.jdField_a_of_type_Xvi = new xvi(this);
    this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)findViewById(2131362555));
    this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Xvi);
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile = new nearfield_discuss.UserProfile();
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    this.jdField_a_of_type_TencentImNearfield_discussNearfield_discuss$UserProfile.str_nick.set(this.app.getCurrentNickname());
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new xuz(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    a(new xva(this));
    ReportController.b(this.app, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppNearFieldDiscussObserver);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if ((this.jdField_a_of_type_Boolean) && (NetworkUtil.d(this))) {
      a(4);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = null;
    }
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      if (this.jdField_c_of_type_Boolean)
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
        finish();
        if (this.jdField_e_of_type_Boolean) {
          overridePendingTransition(2131034129, 2131034130);
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
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0))) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
  }
  
  protected void doOnResume()
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
  
  protected void doOnStart()
  {
    super.doOnStart();
    getWindow().setSoftInputMode(16);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 2131034122);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368286)
    {
      this.jdField_a_of_type_Boolean = false;
      d();
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        ReportController.b(this.app, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", "" + this.jdField_h_of_type_Int, "", "");
      }
    }
    int i1;
    do
    {
      return;
      i1 = this.jdField_a_of_type_JavaLangStringBuffer.length();
    } while (i1 >= 4);
    label204:
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
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('2');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('3');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('4');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('5');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('6');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('7');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('8');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('9');
        break label204;
        this.jdField_a_of_type_JavaLangStringBuffer.append('0');
        break label204;
        if ((i1 > 0) && (i1 < 4)) {
          this.jdField_a_of_type_JavaLangStringBuffer.deleteCharAt(i1 - 1);
        }
        this.jdField_b_of_type_AndroidWidgetTableLayout.setContentDescription(a());
        switch (i1)
        {
        default: 
          return;
        case 1: 
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842467);
          return;
        case 2: 
          this.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130842467);
          return;
        case 3: 
          this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130842467);
          return;
        }
        this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130842467);
        return;
        i1 = 2130842457;
        continue;
        i1 = 2130842458;
        continue;
        i1 = 2130842459;
        continue;
        i1 = 2130842460;
        continue;
        i1 = 2130842461;
        continue;
        i1 = 2130842462;
        continue;
        i1 = 2130842463;
        continue;
        i1 = 2130842464;
        continue;
        i1 = 2130842465;
        continue;
        i1 = 2130842466;
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
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, getString(2131437161), 0).a();
      ReportController.b(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    if (NetworkUtil.d(this))
    {
      this.jdField_a_of_type_AndroidWidgetTableLayout.setEnabled(false);
      a(2);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    a(1, getString(2131434596));
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
      if ((localObject != null) && ((localObject instanceof xvj)))
      {
        localObject = (xvj)localObject;
        if (((xvj)localObject).jdField_a_of_type_JavaLangString.equals(paramString)) {
          ((xvj)localObject).jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
        }
      }
      paramInt1 += 1;
    }
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */