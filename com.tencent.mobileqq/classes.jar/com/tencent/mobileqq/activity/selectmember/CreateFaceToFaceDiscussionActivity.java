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
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
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

@RoutePage(desc="面对面建群", path="/base/face2faceDiscussion")
public class CreateFaceToFaceDiscussionActivity
  extends LbsBaseActivity
  implements View.OnClickListener, DecodeTaskCompletionListener
{
  public static final String TAG = "CreateFaceToFaceDiscussionActivity";
  private static final int TYPE_ENTER_DISCUSSION = 0;
  private static final int TYPE_ENTER_TROOP = 1;
  private static final int TYPE_EXIT_HALL = 4;
  private static final int TYPE_GET_MEMBERLIST = 3;
  private static final int TYPE_GET_MEMBERLIST_FIRST = 2;
  public static final int TYPE_NEW_TROOP = 2;
  final int MAX_MEMBERS_COUNT = 50;
  final int MEMBERS_COUNT_THREE_LINE = 11;
  final int MSG_SHOW_TOAST = 2;
  final int MSG_WHAT = 0;
  final int MSG_WHAT_TRY_AGAIN = 1;
  int TYPE_DISCUSS = 0;
  LinearLayout bottomLayout;
  LinearLayout contentLayout;
  int createSource = 0;
  StringBuffer digits = new StringBuffer(4);
  FriendsManager fm;
  private boolean fromFace2FaceActivity;
  boolean isEnteredHall;
  boolean isExitedHall = false;
  boolean isFirstEnterHall = true;
  boolean isTroop = true;
  View line;
  AlphaAnimation mAlphaAnimation;
  Context mContext;
  Button mCreateTroopBtn;
  IFaceDecoder mDecoder;
  private Bitmap mDefaultAvatar;
  ImageView mDelete;
  ImageView mDigitEight;
  ImageView mDigitFive;
  ImageView mDigitFour;
  ImageView mDigitNine;
  ImageView mDigitOne;
  TableLayout mDigitPadLayout;
  ImageView mDigitSeven;
  ImageView mDigitSix;
  ImageView mDigitThree;
  ImageView mDigitTwo;
  ImageView mDigitViewFour;
  ImageView mDigitViewOne;
  ImageView mDigitViewThree;
  ImageView mDigitViewTwo;
  ImageView mDigitZero;
  TextView mEnterTextviewTip;
  TextView mEnterWording;
  private Runnable mGetSelfNickRunnable = new CreateFaceToFaceDiscussionActivity.3(this);
  CreateFaceToFaceDiscussionActivity.GridViewAdapter mGridViewAdapter;
  GridView mGridview;
  Handler mHandler = new CreateFaceToFaceDiscussionActivity.6(this);
  long mInterval = 60000L;
  nearfield_discuss.LBSInfo mLBSInfo;
  TranslateAnimation mLayoutAnimation;
  private TextView mLeftBackBtn;
  private TextView mLeftCancelBtn;
  List<nearfield_discuss.UserProfile> mMemberList = new ArrayList();
  private NearFieldDiscussObserver mNearFieldDisObsever = new CreateFaceToFaceDiscussionActivity.8(this);
  BroadcastReceiver mNetWorkReceiver;
  TableLayout mNumberViewLayout;
  Drawable mProgressDrawable;
  QQProgressDialog mQQProgressDialog;
  private TextView mRightBtn;
  nearfield_discuss.UserProfile mSelf;
  int mSessionId = -1;
  TextView mTextviewTip;
  private TextView mTitle;
  TranslateAnimation mTranslateAnimation;
  View progress;
  StringBuilder sb = new StringBuilder();
  
  private void enterDiscussOrTroop()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void fillBlankData(View paramView)
  {
    CreateFaceToFaceDiscussionActivity.ViewHolder localViewHolder = (CreateFaceToFaceDiscussionActivity.ViewHolder)paramView.getTag();
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845217);
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    localViewHolder.jdField_a_of_type_JavaLangString = "";
    ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetImageView, 2);
    ViewCompat.setImportantForAccessibility(paramView, 2);
  }
  
  private void fillData(View paramView, nearfield_discuss.UserProfile paramUserProfile)
  {
    String str2 = String.valueOf(paramUserProfile.uint64_uin.get());
    String str1 = paramUserProfile.str_nick.get();
    CreateFaceToFaceDiscussionActivity.ViewHolder localViewHolder = (CreateFaceToFaceDiscussionActivity.ViewHolder)paramView.getTag();
    Bitmap localBitmap = this.mDecoder.getBitmapFromCache(1, str2);
    paramUserProfile = localBitmap;
    if (localBitmap == null)
    {
      this.mDecoder.requestDecodeFace(str2, 1, false, (byte)1);
      if (this.mDefaultAvatar == null) {
        this.mDefaultAvatar = ImageUtil.f();
      }
      paramUserProfile = this.mDefaultAvatar;
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramUserProfile);
    if (this.fm == null) {
      this.fm = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    }
    paramUserProfile = str1;
    if (str2 != null)
    {
      paramUserProfile = str1;
      if (this.fm.b(str2)) {
        paramUserProfile = ContactUtils.a(this.app, str2);
      }
    }
    localViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramUserProfile);
    ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetTextView, 2);
    ViewCompat.setImportantForAccessibility(localViewHolder.jdField_a_of_type_AndroidWidgetImageView, 2);
    ViewCompat.setImportantForAccessibility(paramView, 1);
    paramView.setContentDescription(paramUserProfile);
    localViewHolder.jdField_a_of_type_JavaLangString = str2;
  }
  
  private nearfield_discuss.LBSInfo generateLbsInfo(SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramSosoLbsInfo == null) {
      return this.mLBSInfo;
    }
    nearfield_discuss.LBSInfo localLBSInfo = new nearfield_discuss.LBSInfo();
    nearfield_discuss.GPS localGPS = new nearfield_discuss.GPS();
    localGPS.int32_lat.set((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
    localGPS.int32_lon.set((int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
    localGPS.int32_alt.set(-1);
    localGPS.eType.set(1);
    localLBSInfo.msg_gps.set(localGPS);
    localStringBuffer.append(" GPS: ");
    localStringBuffer.append(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D);
    localStringBuffer.append(",");
    localStringBuffer.append(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D);
    this.mLBSInfo = localLBSInfo;
    if (QLog.isColorLevel()) {
      QLog.i("CreateFaceToFaceDiscussionActivity", 2, localStringBuffer.toString());
    }
    return localLBSInfo;
  }
  
  private void getSelfNickname(nearfield_discuss.UserProfile paramUserProfile)
  {
    if (paramUserProfile == null) {
      return;
    }
    String str1 = this.app.getAccount();
    String str2 = ContactUtils.e(this.app, str1);
    paramUserProfile.str_nick.set(str2);
    if ((TextUtils.isEmpty(str2)) || (TextUtils.equals(str2, str1))) {
      ThreadManager.getSubThreadHandler().post(this.mGetSelfNickRunnable);
    }
  }
  
  private void initUi()
  {
    this.mDigitOne = ((ImageView)findViewById(2131372092));
    this.mDigitTwo = ((ImageView)findViewById(2131379985));
    this.mDigitThree = ((ImageView)findViewById(2131378657));
    this.mDigitFour = ((ImageView)findViewById(2131367209));
    this.mDigitFive = ((ImageView)findViewById(2131366893));
    this.mDigitSix = ((ImageView)findViewById(2131377639));
    this.mDigitSeven = ((ImageView)findViewById(2131377346));
    this.mDigitEight = ((ImageView)findViewById(2131366108));
    this.mDigitNine = ((ImageView)findViewById(2131371891));
    this.mDigitZero = ((ImageView)findViewById(2131381339));
    this.mDelete = ((ImageView)findViewById(2131365494));
    this.mDigitOne.setOnClickListener(this);
    this.mDigitTwo.setOnClickListener(this);
    this.mDigitThree.setOnClickListener(this);
    this.mDigitFour.setOnClickListener(this);
    this.mDigitFive.setOnClickListener(this);
    this.mDigitSix.setOnClickListener(this);
    this.mDigitSeven.setOnClickListener(this);
    this.mDigitEight.setOnClickListener(this);
    this.mDigitNine.setOnClickListener(this);
    this.mDigitZero.setOnClickListener(this);
    this.mDelete.setOnClickListener(this);
    this.mDigitViewOne = ((ImageView)findViewById(2131365692));
    this.mDigitViewTwo = ((ImageView)findViewById(2131365694));
    this.mDigitViewThree = ((ImageView)findViewById(2131365693));
    this.mDigitViewFour = ((ImageView)findViewById(2131365691));
    this.progress = findViewById(2131373160);
    this.mProgressDrawable = getResources().getDrawable(2130839406);
    this.contentLayout = ((LinearLayout)findViewById(2131365179));
    this.mEnterWording = ((TextView)findViewById(2131381187));
    this.mCreateTroopBtn = ((Button)findViewById(2131365323));
    this.mCreateTroopBtn.setOnClickListener(this);
    this.mTextviewTip = ((TextView)findViewById(2131378641));
    this.mDigitPadLayout = ((TableLayout)findViewById(2131365684));
    this.mNumberViewLayout = ((TableLayout)findViewById(2131372046));
    this.mEnterTextviewTip = ((TextView)findViewById(2131378643));
    this.mEnterTextviewTip.setVisibility(4);
    this.line = findViewById(2131365768);
    this.line.setVisibility(4);
    this.mTitle = ((TextView)findViewById(2131369249));
    this.mTitle.setText(getString(2131689679));
    this.mTitle.setContentDescription(getString(2131689679));
    this.mLeftBackBtn = ((TextView)findViewById(2131369202));
    this.mLeftCancelBtn = ((TextView)findViewById(2131369204));
    this.mRightBtn = ((TextView)findViewById(2131369233));
    this.mTitle.setText(getString(2131689682));
    this.mTitle.setContentDescription(getString(2131689682));
    this.mTextviewTip.setText(getString(2131718694));
    this.mTextviewTip.setContentDescription(getString(2131718694));
    this.mEnterTextviewTip.setText(getString(2131718695));
    this.mEnterTextviewTip.setContentDescription(getString(2131718695));
    if (this.fromFace2FaceActivity)
    {
      this.mLeftBackBtn.setVisibility(0);
      this.mRightBtn.setVisibility(4);
      this.mLeftCancelBtn.setVisibility(4);
      this.mLeftBackBtn.setText(2131690706);
      this.mLeftBackBtn.setContentDescription(HardCodeUtil.a(2131702787));
      this.mLeftBackBtn.setOnClickListener(new CreateFaceToFaceDiscussionActivity.4(this));
    }
    else
    {
      this.mLeftBackBtn.setVisibility(4);
      this.mLeftCancelBtn.setVisibility(4);
      this.mRightBtn.setVisibility(0);
      this.mRightBtn.setText(2131690728);
      this.mRightBtn.setContentDescription(HardCodeUtil.a(2131702784));
      this.mRightBtn.setOnClickListener(new CreateFaceToFaceDiscussionActivity.5(this));
    }
    this.bottomLayout = ((LinearLayout)findViewById(2131363750));
    this.bottomLayout.setVisibility(4);
  }
  
  private void oneWayRequest(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)
      {
        requestPermissions(new CreateFaceToFaceDiscussionActivity.9(this, paramInt), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
        return;
      }
      oneWayRequestInner(paramInt);
      return;
    }
    oneWayRequestInner(paramInt);
  }
  
  private void oneWayRequestInner(int paramInt)
  {
    ThreadManager.post(new CreateFaceToFaceDiscussionActivity.10(this, paramInt), 8, null, false);
  }
  
  private void uiChange()
  {
    this.isEnteredHall = true;
    if (this.mAlphaAnimation == null)
    {
      this.mAlphaAnimation = new AlphaAnimation(1.0F, 0.2F);
      this.mAlphaAnimation.setDuration(400L);
    }
    this.mTextviewTip.setAnimation(this.mAlphaAnimation);
    this.mDigitPadLayout.setAnimation(this.mAlphaAnimation);
    this.mAlphaAnimation.start();
    this.mDigitPadLayout.setVisibility(4);
    this.mEnterTextviewTip.setVisibility(0);
    this.line.setVisibility(0);
    this.mLayoutAnimation = new TranslateAnimation(0.0F, 0.0F, 0.0F, -this.mTextviewTip.getBottom());
    this.mLayoutAnimation.setAnimationListener(new CreateFaceToFaceDiscussionActivity.7(this));
    this.mLayoutAnimation.setDuration(500L);
    this.contentLayout.setAnimation(this.mLayoutAnimation);
    this.mTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.bottomLayout.getHeight(), 0.0F);
    this.mTranslateAnimation.setDuration(500L);
    this.bottomLayout.setAnimation(this.mTranslateAnimation);
    this.bottomLayout.setVisibility(0);
    ReportController.b(this.app, "CliOper", "", "", "0X80041AA", "0X80041AA", 0, 0, this.digits.toString(), "", "", "");
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    setTheme(2131755317);
    super.doOnCreate(paramBundle);
    setContentView(2131562814);
    this.mContext = getApplicationContext();
    paramBundle = getIntent();
    this.createSource = paramBundle.getIntExtra("create_source", 0);
    this.fromFace2FaceActivity = paramBundle.getBooleanExtra("fromFace2FaceActivity", false);
    initUi();
    this.app.addObserver(this.mNearFieldDisObsever);
    this.mSessionId = Math.abs(new Random().nextInt());
    this.mDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.mDecoder.setDecodeTaskCompletionListener(this);
    this.mGridViewAdapter = new CreateFaceToFaceDiscussionActivity.GridViewAdapter(this);
    this.mGridview = ((GridView)findViewById(2131367814));
    this.mGridview.setAdapter(this.mGridViewAdapter);
    this.mSelf = new nearfield_discuss.UserProfile();
    this.mSelf.uint64_uin.set(Long.parseLong(this.app.getAccount()));
    getSelfNickname(this.mSelf);
    this.isEnteredHall = false;
    this.mNetWorkReceiver = new CreateFaceToFaceDiscussionActivity.1(this);
    paramBundle = new IntentFilter();
    paramBundle.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    registerReceiver(this.mNetWorkReceiver, paramBundle);
    checkLbsOnlySystemSwitch(new CreateFaceToFaceDiscussionActivity.2(this));
    paramBundle = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.createSource);
    ReportController.b(paramBundle, "dc00899", "Grp_create_new", "", "face_create", "exp", 0, 0, "", localStringBuilder.toString(), "", "");
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.app.removeObserver(this.mNearFieldDisObsever);
    this.mHandler.removeMessages(1);
    ThreadManager.getSubThreadHandler().removeCallbacks(this.mGetSelfNickRunnable);
    if ((this.isExitedHall) && (NetworkUtil.isNetSupport(this))) {
      oneWayRequest(4);
    }
    IFaceDecoder localIFaceDecoder = this.mDecoder;
    if (localIFaceDecoder != null)
    {
      localIFaceDecoder.destory();
      this.mDecoder = null;
    }
    try
    {
      unregisterReceiver(this.mNetWorkReceiver);
      return;
    }
    catch (Exception localException) {}
  }
  
  protected boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.isEnteredHall) {
        ReportController.b(this.app, "CliOper", "", "", "0X80041AE", "0X80041AE", 0, 0, "", "", "", "");
      } else {
        ReportController.b(this.app, "CliOper", "", "", "0X80041A9", "0X80041A9", 0, 0, "", "", "", "");
      }
      finish();
      if (this.fromFace2FaceActivity) {
        overridePendingTransition(2130772002, 2130772003);
      }
    }
    else if (paramInt != 67)
    {
      switch (paramInt)
      {
      default: 
        break;
      case 16: 
        this.mDigitNine.performClick();
        break;
      case 15: 
        this.mDigitEight.performClick();
        break;
      case 14: 
        this.mDigitSeven.performClick();
        break;
      case 13: 
        this.mDigitSix.performClick();
        break;
      case 12: 
        this.mDigitFive.performClick();
        break;
      case 11: 
        this.mDigitFour.performClick();
        break;
      case 10: 
        this.mDigitThree.performClick();
        break;
      case 9: 
        this.mDigitTwo.performClick();
        break;
      case 8: 
        this.mDigitOne.performClick();
        break;
      case 7: 
        this.mDigitZero.performClick();
        break;
      }
    }
    else
    {
      this.mDelete.performClick();
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if ((this.isEnteredHall) && (this.mHandler.hasMessages(0))) {
      this.mHandler.removeMessages(0);
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    if (this.isEnteredHall)
    {
      if (this.mHandler.hasMessages(0)) {
        this.mHandler.removeMessages(0);
      }
      this.mHandler.sendEmptyMessage(0);
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
    overridePendingTransition(0, 2130771992);
  }
  
  String getDescription()
  {
    StringBuilder localStringBuilder = this.sb;
    int j = localStringBuilder.length();
    int i = 0;
    localStringBuilder.delete(0, j);
    j = this.digits.length();
    if (j > 0) {
      while (i < j)
      {
        this.sb.append(this.digits.charAt(i));
        if (i < j - 1) {
          this.sb.append(65292);
        }
        i += 1;
      }
    }
    return this.sb.toString();
  }
  
  protected void notifyShowLbsEnableDlg()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80041AB", "0X80041AB", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365323)
    {
      this.isExitedHall = false;
      enterDiscussOrTroop();
      if (this.mMemberList.size() == 0)
      {
        QQAppInterface localQQAppInterface = this.app;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(this.createSource);
        ReportController.b(localQQAppInterface, "dc00899", "Grp_create_new", "", "suc_create", "clk_now", 0, 0, "", localStringBuilder.toString(), "", "");
      }
    }
    else
    {
      int i = this.digits.length();
      if (i < 4)
      {
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131381339: 
          this.digits.append('0');
          break;
        case 2131379985: 
          this.digits.append('2');
          break;
        case 2131378657: 
          this.digits.append('3');
          break;
        case 2131377639: 
          this.digits.append('6');
          break;
        case 2131377346: 
          this.digits.append('7');
          break;
        case 2131372092: 
          this.digits.append('1');
          break;
        case 2131371891: 
          this.digits.append('9');
          break;
        case 2131367209: 
          this.digits.append('4');
          break;
        case 2131366893: 
          this.digits.append('5');
          break;
        case 2131366108: 
          this.digits.append('8');
          break;
        case 2131365494: 
          if ((i > 0) && (i < 4)) {
            this.digits.deleteCharAt(i - 1);
          }
          this.mNumberViewLayout.setContentDescription(getDescription());
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3)
              {
                if (i == 4) {
                  this.mDigitViewFour.setImageResource(2130845242);
                }
              }
              else {
                this.mDigitViewThree.setImageResource(2130845242);
              }
            }
            else {
              this.mDigitViewTwo.setImageResource(2130845242);
            }
          }
          else {
            this.mDigitViewOne.setImageResource(2130845242);
          }
          break;
        }
        this.mNumberViewLayout.setContentDescription(getDescription());
        int j = this.digits.length();
        i = -1;
        switch (this.digits.charAt(j - 1))
        {
        default: 
          break;
        case '9': 
          i = 2130845241;
          break;
        case '8': 
          i = 2130845240;
          break;
        case '7': 
          i = 2130845239;
          break;
        case '6': 
          i = 2130845238;
          break;
        case '5': 
          i = 2130845237;
          break;
        case '4': 
          i = 2130845236;
          break;
        case '3': 
          i = 2130845235;
          break;
        case '2': 
          i = 2130845234;
          break;
        case '1': 
          i = 2130845233;
          break;
        case '0': 
          i = 2130845232;
        }
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j == 4)
              {
                this.mDigitViewFour.setImageResource(i);
                this.mDigitOne.setEnabled(false);
                this.mDigitTwo.setEnabled(false);
                this.mDigitThree.setEnabled(false);
                this.mDigitFour.setEnabled(false);
                this.mDigitFive.setEnabled(false);
                this.mDigitSix.setEnabled(false);
                this.mDigitSeven.setEnabled(false);
                this.mDigitEight.setEnabled(false);
                this.mDigitNine.setEnabled(false);
                this.mDigitZero.setEnabled(false);
                this.mDelete.setEnabled(false);
                if ((!this.digits.toString().equals("1234")) && (!this.digits.toString().equals("1111")) && (!this.digits.toString().equals("2222")) && (!this.digits.toString().equals("3333")) && (!this.digits.toString().equals("0000")))
                {
                  this.progress.setVisibility(0);
                  this.progress.setBackgroundDrawable(this.mProgressDrawable);
                  ((Animatable)this.mProgressDrawable).start();
                  if (NetworkUtil.isNetSupport(this))
                  {
                    this.mDigitPadLayout.setEnabled(false);
                    oneWayRequest(2);
                    this.isExitedHall = true;
                  }
                  else
                  {
                    showToast(1, getString(2131694475));
                    ((Animatable)this.mProgressDrawable).stop();
                    this.progress.setVisibility(4);
                    if (this.mHandler.hasMessages(1)) {
                      this.mHandler.removeMessages(1);
                    }
                    this.mHandler.sendEmptyMessageDelayed(1, 600L);
                  }
                }
                else
                {
                  if (this.mHandler.hasMessages(1)) {
                    this.mHandler.removeMessages(1);
                  }
                  this.mHandler.sendEmptyMessageDelayed(1, 600L);
                  QQToast.a(this.mContext, getString(2131719719), 0).a();
                  ReportController.b(this.app, "CliOper", "", "", "0X80041AD", "0X80041AD", 0, 0, "", "", "", "");
                }
              }
            }
            else {
              this.mDigitViewThree.setImageResource(i);
            }
          }
          else {
            this.mDigitViewTwo.setImageResource(i);
          }
        }
        else {
          this.mDigitViewOne.setImageResource(i);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    paramInt2 = this.mGridview.getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      Object localObject = this.mGridview.getChildAt(paramInt1).getTag();
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
  
  protected void onEnableClick()
  {
    ReportController.b(this.app, "CliOper", "", "", "0X80041AC", "0X80041AC", 0, 0, "", "", "", "");
  }
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity
 * JD-Core Version:    0.7.0.1
 */