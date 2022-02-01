package com.tencent.mobileqq.activity.specialcare;

import Override;
import afma;
import amcm;
import amcn;
import amco;
import amcp;
import amcq;
import amcr;
import amcs;
import amct;
import amcu;
import amcv;
import amcw;
import amcx;
import amcy;
import amcz;
import amda;
import amdb;
import amdc;
import amdd;
import amde;
import amdf;
import amdg;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anvi;
import anvk;
import anvx;
import bbvn;
import bdla;
import bham;
import bhdz;
import bisl;
import bldp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements afma, View.OnClickListener, FaceDecoder.DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  public static final String a;
  public static final String b;
  public int a;
  public amde a;
  amdf jdField_a_of_type_Amdf = new amcx(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  anvi jdField_a_of_type_Anvi = new amcy(this);
  anvk jdField_a_of_type_Anvk;
  bbvn jdField_a_of_type_Bbvn;
  public bisl a;
  bldp jdField_a_of_type_Bldp = new amcw(this);
  public ActivateFriendGrid a;
  public FriendListHandler a;
  public FaceDecoder a;
  public PullRefreshHeader a;
  public XListView a;
  ArrayList<amdd> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  public ArrayList<Entity> b;
  public boolean b;
  int c;
  public View c;
  public boolean c;
  public int d = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = anvx.a(2131713687);
    jdField_b_of_type_JavaLangString = anvx.a(2131713688);
  }
  
  public SpecailCareListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new amcm(this);
  }
  
  public int a(View paramView, amdg paramamdg, boolean paramBoolean)
  {
    int j = getResources().getDimensionPixelSize(2131296811);
    int i;
    if (paramBoolean) {
      i = j;
    }
    do
    {
      return i;
      i = 0;
      if (this.jdField_a_of_type_ComTencentWidgetXListView != null) {
        i = this.jdField_a_of_type_ComTencentWidgetXListView.getWidth();
      }
      j = paramamdg.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(paramView, paramamdg, j, i);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("SpecailCareListActivity", 2, "getNickRightMargin=" + j);
    return j;
  }
  
  public SpannableString a(Friends paramFriends, amdg paramamdg)
  {
    Object localObject1 = (bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    Object localObject2 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((localObject1 == null) || (localObject2 == null)) {
      return null;
    }
    localObject1 = ((anvk)localObject2).a(paramFriends.uin);
    paramFriends = null;
    boolean bool;
    label88:
    int j;
    label110:
    int k;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedContent)))
    {
      i = 1;
      if (localObject1 != null)
      {
        if (this.d == 0) {
          break label259;
        }
        bool = true;
        paramFriends = ((ExtensionInfo)localObject1).getRichStatus(bool);
      }
      if ((paramFriends == null) || (paramFriends.isEmpty())) {
        break label265;
      }
      j = 1;
      if ((j == 0) || (TextUtils.isEmpty(paramFriends.actionText))) {
        break label271;
      }
      k = 1;
      label128:
      if ((i == 0) || ((((ExtensionInfo)localObject1).feedTime <= ((ExtensionInfo)localObject1).richTime) && (j != 0))) {
        break label384;
      }
      paramFriends = new SpannableString(((ExtensionInfo)localObject1).feedContent);
      paramamdg.b.setCompoundDrawables(null, null, null, null);
      if (((ExtensionInfo)localObject1).feedType != 2) {
        break label296;
      }
      paramamdg.e.setVisibility(0);
      if (TextUtils.isEmpty(((ExtensionInfo)localObject1).feedPhotoUrl)) {
        break label277;
      }
      bham.a(paramamdg.e, ((ExtensionInfo)localObject1).feedPhotoUrl, getResources().getDrawable(2130850289));
    }
    for (;;)
    {
      paramamdg.f.setVisibility(8);
      paramamdg.g.setVisibility(8);
      paramamdg.b.setText(paramFriends);
      return paramFriends;
      i = 0;
      break;
      label259:
      bool = false;
      break label88;
      label265:
      j = 0;
      break label110;
      label271:
      k = 0;
      break label128;
      label277:
      paramamdg.e.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850289));
    }
    label296:
    paramamdg.f.setVisibility(0);
    localObject2 = paramamdg.f;
    if (((ExtensionInfo)localObject1).feedType == 1)
    {
      i = 2130849595;
      label323:
      ((ImageView)localObject2).setBackgroundResource(i);
      localObject2 = paramamdg.g;
      if (!((ExtensionInfo)localObject1).feedHasPhoto) {
        break label378;
      }
    }
    label378:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject2).setVisibility(i);
      paramamdg.e.setVisibility(8);
      paramamdg.e.setImageDrawable(null);
      break;
      i = 2130849593;
      break label323;
    }
    label384:
    if (k != 0)
    {
      localObject1 = this.jdField_a_of_type_Bbvn.a(paramFriends.actionId, 200);
      localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
      i = this.jdField_b_of_type_Int;
      ((Drawable)localObject1).setBounds(0, 0, Math.round(((Drawable)localObject1).getIntrinsicWidth() * 1.0F / ((Drawable)localObject1).getIntrinsicHeight() * i), i);
      paramamdg.b.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    for (;;)
    {
      paramFriends = paramFriends.toSpannableString(null);
      paramamdg.f.setVisibility(8);
      paramamdg.g.setVisibility(8);
      paramamdg.e.setVisibility(8);
      paramamdg.e.setImageDrawable(null);
      break;
      if (j == 0)
      {
        paramFriends = RichStatus.getEmptyStatus();
        paramamdg.b.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    List localList = this.jdField_a_of_type_Anvk.b();
    if ((localList == null) || (localList.size() <= 0))
    {
      b();
      this.leftView.setVisibility(0);
      this.jdField_c_of_type_Boolean = false;
      this.rightViewText.setVisibility(4);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos: empty...");
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "refreshSpecialCareData cost time = " + (l2 - l1));
      }
      return;
      this.rightViewText.setVisibility(0);
      if (this.jdField_c_of_type_Boolean)
      {
        this.rightViewText.setText(jdField_b_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos return size:" + localList.size());
        }
        int i = 0;
        while (i < localList.size())
        {
          Object localObject = (SpecialCareInfo)localList.get(i);
          localObject = this.jdField_a_of_type_Anvk.b(((SpecialCareInfo)localObject).uin);
          if (localObject != null) {
            this.jdField_b_of_type_JavaUtilArrayList.add(localObject);
          }
          i += 1;
        }
        this.rightViewText.setText(jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      ThreadManager.post(new SpecailCareListActivity.5(this), 8, null, true);
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    getPreferences(0).edit().putBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + paramInt, paramBoolean).commit();
  }
  
  boolean a(int paramInt)
  {
    boolean bool = false;
    if (!getPreferences(0).getBoolean("enterSpecailCare" + this.app.getCurrentAccountUin() + "_" + paramInt, false)) {
      bool = true;
    }
    return bool;
  }
  
  void b()
  {
    if ((this.jdField_a_of_type_Amde != null) && (this.jdField_a_of_type_Amde.a() != null)) {
      return;
    }
    if (((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a() > 0) {
      bdla.b(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      View localView = getLayoutInflater().inflate(2131561527, null);
      if (this.jdField_a_of_type_Amde == null) {
        break;
      }
      this.jdField_a_of_type_Amde.a(localView);
      return;
      bdla.b(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
  }
  
  void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return;
    }
    bdla.b(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561530, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, AIOUtils.dp2px(75.0F, getResources()), 0, 0);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new amcz(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131362137));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_c_of_type_AndroidViewView.findViewById(2131367854));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (amdd)localIterator.next();
      if ((this.jdField_a_of_type_Anvk != null) && (!this.jdField_a_of_type_Anvk.b(((amdd)localObject2).jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, ((amdd)localObject2).jdField_a_of_type_JavaLangString + " is not friend.. ");
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((amdd)localObject2).jdField_a_of_type_JavaLangString).longValue(), ((amdd)localObject2).jdField_b_of_type_JavaLangString);
        if (i >= 6) {
          break label423;
        }
        ((ArrayList)localObject1).add(localObject2);
        i += 1;
      }
    }
    label403:
    label423:
    for (;;)
    {
      break;
      bdla.b(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i), "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setData(this.app, (ArrayList)localObject1);
      if (this.jdField_c_of_type_AndroidViewView.getParent() == null)
      {
        if (Build.VERSION.SDK_INT >= 14) {
          break label403;
        }
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).addView(this.jdField_c_of_type_AndroidViewView);
      }
      for (;;)
      {
        setRightButton(2131698658, this);
        return;
        ((FrameLayout)getWindow().getDecorView()).addView(this.jdField_c_of_type_AndroidViewView);
      }
    }
  }
  
  public void d()
  {
    if ((this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getParent() != null))
    {
      if (Build.VERSION.SDK_INT >= 14) {
        break label80;
      }
      ((ViewGroup)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent().getParent()).removeView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_c_of_type_AndroidViewView = null;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
        this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = null;
      }
    }
    for (;;)
    {
      this.rightViewText.setVisibility(4);
      return;
      label80:
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 2, -1.0F);
      localTranslateAnimation.setInterpolator(new AccelerateInterpolator());
      localTranslateAnimation.setDuration(500L);
      localTranslateAnimation.setFillAfter(true);
      localTranslateAnimation.setAnimationListener(new amda(this));
      this.jdField_c_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
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
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561529);
    super.setTitle(2131716737);
    super.setRightButton(2131693753, this);
    this.app.addObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Int = ((int)bhdz.a(this, 9.0F));
    this.jdField_b_of_type_Int = ((int)bhdz.a(this, 12.0F));
    this.jdField_c_of_type_Int = ((int)bhdz.a(this, 20.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376803));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131370221));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366855);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getLayoutInflater().inflate(2131561526, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Amde = new amde(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amde);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2131560016, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131298830));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Bldp);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838911);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844916);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_Anvk = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_Bbvn = ((bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_Amdf);
    a();
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) && (a(1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendGroupList(true);
      FriendListHandler.getSpecialRecommendStat = 2;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getRecommendList();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label703;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList() return size:" + paramBundle.size());
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        oidb_0x7df.FriendScore localFriendScore = (oidb_0x7df.FriendScore)paramBundle.next();
        amdd localamdd = new amdd();
        localamdd.jdField_a_of_type_JavaLangString = String.valueOf(localFriendScore.uint64_friend_uin.get());
        Friends localFriends = this.jdField_a_of_type_Anvk.b(localamdd.jdField_a_of_type_JavaLangString);
        if (localFriends != null) {
          localamdd.jdField_b_of_type_JavaLangString = ContactUtils.getFriendName(localFriends);
        }
        if ((TextUtils.isEmpty(localamdd.jdField_b_of_type_JavaLangString)) && (localFriendScore.bytes_nick != null) && (localFriendScore.bytes_nick.get() != null)) {
          localamdd.jdField_b_of_type_JavaLangString = localFriendScore.bytes_nick.get().toStringUtf8();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localamdd);
      }
      c();
    }
    for (;;)
    {
      a(1, true);
      a(2, true);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "doOnCreate cost time = " + (l2 - l1));
      }
      if (AppSetting.jdField_c_of_type_Boolean)
      {
        this.leftView.setContentDescription(anvx.a(2131713684));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anvx.a(2131713685));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getOnlineFriend(this.app.getCurrentAccountUin(), (byte)3);
      return true;
      label703:
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    this.app.removeObserver(this.jdField_a_of_type_Anvi);
    this.jdField_a_of_type_Bbvn.b(this.jdField_a_of_type_Amdf);
    h();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = null;
    }
  }
  
  void e()
  {
    if (this.jdField_b_of_type_AndroidViewView != null) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (this.jdField_c_of_type_AndroidViewView != null);
      bdla.b(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
      localFrameLayout = (FrameLayout)getWindow().getDecorView();
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561528, null);
      Button localButton = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131369736);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131374410).setOnClickListener(this);
      localButton.setOnClickListener(this);
    } while (this.jdField_b_of_type_AndroidViewView.getParent() != null);
    localFrameLayout.addView(this.jdField_b_of_type_AndroidViewView);
  }
  
  void f()
  {
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getParent() != null))
    {
      ((FrameLayout)getWindow().getDecorView()).removeView(this.jdField_b_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidViewView = null;
    }
  }
  
  void g()
  {
    if (this.jdField_a_of_type_Bisl == null)
    {
      this.jdField_a_of_type_Bisl = new bisl(this);
      this.jdField_a_of_type_Bisl.b(getTitleBarHeight());
    }
    this.jdField_a_of_type_Bisl.c(2131689664);
    if (!this.jdField_a_of_type_Bisl.isShowing()) {
      this.jdField_a_of_type_Bisl.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing()))
    {
      this.jdField_a_of_type_Bisl.dismiss();
      this.jdField_a_of_type_Bisl = null;
    }
  }
  
  void i()
  {
    this.rightViewText.setClickable(false);
    int j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
    Object localObject1 = this.rightViewText.getText().toString();
    if (jdField_a_of_type_JavaLangString.equals(localObject1))
    {
      if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new amdb(this));
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      }
      int i = 0;
      while (i < j)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof amdg)))
        {
          localObject1 = (amdg)localObject1;
          int k = a((View)localObject2, (amdg)localObject1, true);
          localObject2 = new TranslateAnimation(-(this.mDensity * 34.0F), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(120L);
          ((AlphaAnimation)localObject3).setDuration(180L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          ((amdg)localObject1).c.setVisibility(0);
          ((TranslateAnimation)localObject2).setAnimationListener(new amdc(this, (amdg)localObject1));
          ((amdg)localObject1).c.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new amcn(this, (amdg)localObject1));
          ((amdg)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new amco(this, (amdg)localObject1, k));
          ((amdg)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new amcp(this, (amdg)localObject1));
          ((amdg)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, 28.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          ((amdg)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation(localAnimationSet);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((amdg)localObject1).d.setVisibility(0);
          ((amdg)localObject1).d.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new amcq(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
        }
        i += 1;
      }
    }
    if (jdField_b_of_type_JavaLangString.equals(localObject1)) {
      j();
    }
  }
  
  void j()
  {
    int i = this.jdField_a_of_type_ComTencentWidgetXListView.getLastVisiblePosition();
    int j = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
    int k = this.jdField_a_of_type_ComTencentWidgetXListView.getBottom();
    if (i == this.jdField_a_of_type_ComTencentWidgetXListView.getCount() - 1) {
      if ((j > this.jdField_c_of_type_Int) && (k >= j - this.jdField_c_of_type_Int)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
    }
    for (;;)
    {
      j = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      i = 0;
      while (i < j)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        Object localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof amdg)))
        {
          localObject1 = (amdg)localObject1;
          k = a((View)localObject2, (amdg)localObject1, false);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(180L);
          Object localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((TranslateAnimation)localObject2).setAnimationListener(new amcr(this, (amdg)localObject1));
          ((amdg)localObject1).c.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new amcs(this, (amdg)localObject1));
          ((amdg)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((AnimationSet)localObject4).setAnimationListener(new amct(this, (amdg)localObject1, k));
          ((amdg)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject4).setDuration(300L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.addAnimation((Animation)localObject4);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new amcu(this, (amdg)localObject1));
          ((amdg)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(24.0F * this.mDensity, 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setFillAfter(true);
          localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(60L);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((amdg)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation((Animation)localObject4);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((amdg)localObject1).d.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new amcv(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.startAnimation((Animation)localObject1);
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      continue;
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_c_of_type_Boolean = false;
      j();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (((paramView instanceof ImageView)) && (paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      localObject1 = (String)paramView.getTag();
      if (!StringUtil.isEmpty((String)localObject1))
      {
        bdla.b(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (!NetworkUtil.isNetSupport(this)) {
          break label145;
        }
        localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { localObject1 };
        ((FriendListHandler)localObject2).setSpecialCareSwitch(1, this.jdField_a_of_type_ArrayOfJavaLangString, new boolean[] { false });
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2002);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label145:
      QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
      continue;
      switch (paramView.getId())
      {
      case 2131374410: 
      default: 
        localObject1 = paramView.getTag();
        if ((localObject1 == null) || (!(localObject1 instanceof amdg)))
        {
          bdla.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
          localObject1 = new Intent(this, ForwardFriendListActivity.class);
          ((Intent)localObject1).putExtra("extra_choose_friend", 1);
          ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
          startActivity((Intent)localObject1);
          overridePendingTransition(2130771979, 2130771977);
        }
        break;
      case 2131369262: 
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          d();
          bdla.b(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
        }
        else
        {
          i();
        }
        break;
      case 2131362137: 
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.a(this, getString(2131692125), 0).b(getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.i("SpecailCareListActivity", 2, "No Network!");
          }
        }
        else
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
          localObject2 = new boolean[localObject1.length];
          String[] arrayOfString = new String[localObject1.length];
          this.jdField_a_of_type_ArrayOfJavaLangString = new String[arrayOfString.length];
          int i = 0;
          while (i < localObject1.length)
          {
            localObject2[i] = 1;
            arrayOfString[i] = String.valueOf(localObject1[i]);
            this.jdField_a_of_type_ArrayOfJavaLangString[i] = arrayOfString[i];
            i += 1;
          }
          g();
          if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
          }
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.setSpecialCareSwitch(1, arrayOfString, (boolean[])localObject2);
          bdla.b(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(localObject1.length), "", "", "");
        }
        break;
      case 2131369736: 
        f();
        break;
      case 2131366146: 
        bdla.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        localObject1 = new Intent(this, ForwardFriendListActivity.class);
        ((Intent)localObject1).putExtra("extra_choose_friend", 1);
        ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
        startActivity((Intent)localObject1);
        overridePendingTransition(2130771979, 2130771977);
        continue;
        localObject1 = (amdg)localObject1;
        localObject2 = ((amdg)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends;
        localObject2 = new Intent(this, QQSpecialCareSettingActivity.class);
        ((Intent)localObject2).putExtra("key_friend_uin", ((amdg)localObject1).jdField_a_of_type_JavaLangString);
        ((Intent)localObject2).putExtra("key_start_from", 5);
        startActivity((Intent)localObject2);
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
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.isPausing())) {}
    for (;;)
    {
      return;
      if (this.d != 0)
      {
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (amdg)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((amdg)localObject).jdField_a_of_type_ComTencentMobileqqDataFriends.uin)))
          {
            ((amdg)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) || (paramAbsListView == null)) {
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    int i = this.jdField_a_of_type_AndroidWidgetLinearLayout.getBottom();
    int j = paramAbsListView.getBottom();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "onScroll.firstVisibleItem=" + paramInt1 + ", visibleItemCount=" + paramInt2 + ",totalItemCount=" + paramInt3 + ",addBtnBottom=" + i + ",listviewBottom=" + j + ",mBottomBtnBottomMargin=" + this.jdField_c_of_type_Int);
    }
    if (paramInt1 + paramInt2 == paramInt3)
    {
      if ((i > this.jdField_c_of_type_Int) && (j >= i - this.jdField_c_of_type_Int))
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.d = paramInt;
    if ((this.jdField_b_of_type_Boolean) && (paramInt == 0))
    {
      this.jdField_a_of_type_Amde.notifyDataSetChanged();
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      return;
      if (paramInt == 0)
      {
        int i = this.jdField_a_of_type_ComTencentWidgetXListView.getChildCount();
        paramInt = 0;
        while (paramInt < i)
        {
          paramAbsListView = (amdg)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
          if ((paramAbsListView != null) && (paramAbsListView.jdField_a_of_type_JavaLangString != null) && (paramAbsListView.jdField_a_of_type_JavaLangString.length() > 0)) {
            a(paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataFriends, paramAbsListView);
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity
 * JD-Core Version:    0.7.0.1
 */