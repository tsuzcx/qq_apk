package com.tencent.mobileqq.activity.specialcare;

import Override;
import agbv;
import agej;
import amjt;
import amju;
import amjv;
import amjw;
import amjx;
import amjy;
import amjz;
import amka;
import amkb;
import amkc;
import amkd;
import amke;
import amkf;
import amkg;
import amkh;
import amki;
import amkj;
import amkk;
import amkl;
import amkm;
import amkn;
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
import anyu;
import anyw;
import anzj;
import aoof;
import aoog;
import bbvd;
import bdll;
import bhil;
import bhlg;
import bhmg;
import bhnv;
import bhsr;
import bjbs;
import blih;
import blnt;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements agbv, View.OnClickListener, aoog, blih
{
  public static final String a;
  public static final String b;
  public int a;
  public amkl a;
  amkm jdField_a_of_type_Amkm = new amke(this);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  anyu jdField_a_of_type_Anyu = new amkf(this);
  anyw jdField_a_of_type_Anyw;
  public aoof a;
  bbvd jdField_a_of_type_Bbvd;
  public bjbs a;
  blnt jdField_a_of_type_Blnt = new amkd(this);
  public ActivateFriendGrid a;
  public FriendListHandler a;
  public PullRefreshHeader a;
  public XListView a;
  ArrayList<amkk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
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
    jdField_a_of_type_JavaLangString = anzj.a(2131713108);
    jdField_b_of_type_JavaLangString = anzj.a(2131713109);
  }
  
  public SpecailCareListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new amjt(this);
  }
  
  public int a(View paramView, amkn paramamkn, boolean paramBoolean)
  {
    int j = getResources().getDimensionPixelSize(2131296755);
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
      j = paramamkn.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(paramView, paramamkn, j, i);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("SpecailCareListActivity", 2, "getNickRightMargin=" + j);
    return j;
  }
  
  public SpannableString a(Friends paramFriends, amkn paramamkn)
  {
    Object localObject1 = (bbvd)this.app.getManager(15);
    Object localObject2 = (anyw)this.app.getManager(51);
    if ((localObject1 == null) || (localObject2 == null)) {
      return null;
    }
    localObject1 = ((anyw)localObject2).a(paramFriends.uin);
    paramFriends = null;
    boolean bool;
    label86:
    int j;
    label108:
    int k;
    if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedContent)))
    {
      i = 1;
      if (localObject1 != null)
      {
        if (this.d == 0) {
          break label257;
        }
        bool = true;
        paramFriends = ((ExtensionInfo)localObject1).getRichStatus(bool);
      }
      if ((paramFriends == null) || (paramFriends.isEmpty())) {
        break label263;
      }
      j = 1;
      if ((j == 0) || (TextUtils.isEmpty(paramFriends.actionText))) {
        break label269;
      }
      k = 1;
      label126:
      if ((i == 0) || ((((ExtensionInfo)localObject1).feedTime <= ((ExtensionInfo)localObject1).richTime) && (j != 0))) {
        break label382;
      }
      paramFriends = new SpannableString(((ExtensionInfo)localObject1).feedContent);
      paramamkn.b.setCompoundDrawables(null, null, null, null);
      if (((ExtensionInfo)localObject1).feedType != 2) {
        break label294;
      }
      paramamkn.e.setVisibility(0);
      if (TextUtils.isEmpty(((ExtensionInfo)localObject1).feedPhotoUrl)) {
        break label275;
      }
      bhil.a(paramamkn.e, ((ExtensionInfo)localObject1).feedPhotoUrl, getResources().getDrawable(2130850266));
    }
    for (;;)
    {
      paramamkn.f.setVisibility(8);
      paramamkn.g.setVisibility(8);
      paramamkn.b.setText(paramFriends);
      return paramFriends;
      i = 0;
      break;
      label257:
      bool = false;
      break label86;
      label263:
      j = 0;
      break label108;
      label269:
      k = 0;
      break label126;
      label275:
      paramamkn.e.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130850266));
    }
    label294:
    paramamkn.f.setVisibility(0);
    localObject2 = paramamkn.f;
    if (((ExtensionInfo)localObject1).feedType == 1)
    {
      i = 2130849590;
      label321:
      ((ImageView)localObject2).setBackgroundResource(i);
      localObject2 = paramamkn.g;
      if (!((ExtensionInfo)localObject1).feedHasPhoto) {
        break label376;
      }
    }
    label376:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject2).setVisibility(i);
      paramamkn.e.setVisibility(8);
      paramamkn.e.setImageDrawable(null);
      break;
      i = 2130849588;
      break label321;
    }
    label382:
    if (k != 0)
    {
      localObject1 = this.jdField_a_of_type_Bbvd.a(paramFriends.actionId, 200);
      localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
      i = this.jdField_b_of_type_Int;
      ((Drawable)localObject1).setBounds(0, 0, Math.round(((Drawable)localObject1).getIntrinsicWidth() * 1.0F / ((Drawable)localObject1).getIntrinsicHeight() * i), i);
      paramamkn.b.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    for (;;)
    {
      paramFriends = paramFriends.toSpannableString(null);
      paramamkn.f.setVisibility(8);
      paramamkn.g.setVisibility(8);
      paramamkn.e.setVisibility(8);
      paramamkn.e.setImageDrawable(null);
      break;
      if (j == 0)
      {
        paramFriends = RichStatus.getEmptyStatus();
        paramamkn.b.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    List localList = this.jdField_a_of_type_Anyw.b();
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
          localObject = this.jdField_a_of_type_Anyw.b(((SpecialCareInfo)localObject).uin);
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
    if ((this.jdField_a_of_type_Amkl != null) && (this.jdField_a_of_type_Amkl.a() != null)) {
      return;
    }
    if (((anyw)this.app.getManager(51)).a() > 0) {
      bdll.b(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      View localView = getLayoutInflater().inflate(2131561587, null);
      if (this.jdField_a_of_type_Amkl == null) {
        break;
      }
      this.jdField_a_of_type_Amkl.a(localView);
      return;
      bdll.b(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
  }
  
  void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return;
    }
    bdll.b(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561590, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, agej.a(75.0F, getResources()), 0, 0);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new amkg(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131362133));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_c_of_type_AndroidViewView.findViewById(2131367686));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (amkk)localIterator.next();
      if ((this.jdField_a_of_type_Anyw != null) && (!this.jdField_a_of_type_Anyw.b(((amkk)localObject2).jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, ((amkk)localObject2).jdField_a_of_type_JavaLangString + " is not friend.. ");
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((amkk)localObject2).jdField_a_of_type_JavaLangString).longValue(), ((amkk)localObject2).jdField_b_of_type_JavaLangString);
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
      bdll.b(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i), "", "", "");
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
        setRightButton(2131698197, this);
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
      localTranslateAnimation.setAnimationListener(new amkh(this));
      this.jdField_c_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
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
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561589);
    super.setTitle(2131716142);
    super.setRightButton(2131693474, this);
    this.app.addObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_Int = ((int)bhmg.a(this, 9.0F));
    this.jdField_b_of_type_Int = ((int)bhmg.a(this, 12.0F));
    this.jdField_c_of_type_Int = ((int)bhmg.a(this, 20.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131376774));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131370052));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366709);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getLayoutInflater().inflate(2131561586, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Amkl = new amkl(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Amkl);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2131559968, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131298761));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Blnt);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838778);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844961);
    this.jdField_a_of_type_Aoof = new aoof(this, this.app);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_Anyw = ((anyw)this.app.getManager(51));
    this.jdField_a_of_type_Bbvd = ((bbvd)this.app.getManager(15));
    this.jdField_a_of_type_Bbvd.a(this.jdField_a_of_type_Amkm);
    a();
    if ((this.jdField_b_of_type_JavaUtilArrayList.size() <= 0) && (a(1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a(true);
      FriendListHandler.jdField_a_of_type_Int = 2;
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.a();
      if ((paramBundle == null) || (paramBundle.size() <= 0)) {
        break label699;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList() return size:" + paramBundle.size());
      }
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      paramBundle = paramBundle.iterator();
      while (paramBundle.hasNext())
      {
        oidb_0x7df.FriendScore localFriendScore = (oidb_0x7df.FriendScore)paramBundle.next();
        amkk localamkk = new amkk();
        localamkk.jdField_a_of_type_JavaLangString = String.valueOf(localFriendScore.uint64_friend_uin.get());
        Friends localFriends = this.jdField_a_of_type_Anyw.b(localamkk.jdField_a_of_type_JavaLangString);
        if (localFriends != null) {
          localamkk.jdField_b_of_type_JavaLangString = bhlg.a(localFriends);
        }
        if ((TextUtils.isEmpty(localamkk.jdField_b_of_type_JavaLangString)) && (localFriendScore.bytes_nick != null) && (localFriendScore.bytes_nick.get() != null)) {
          localamkk.jdField_b_of_type_JavaLangString = localFriendScore.bytes_nick.get().toStringUtf8();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localamkk);
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
        this.leftView.setContentDescription(anzj.a(2131713105));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(anzj.a(2131713106));
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.d(this.app.getCurrentAccountUin(), (byte)3);
      return true;
      label699:
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
      }
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    this.app.removeObserver(this.jdField_a_of_type_Anyu);
    this.jdField_a_of_type_Bbvd.b(this.jdField_a_of_type_Amkm);
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
      bdll.b(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
      localFrameLayout = (FrameLayout)getWindow().getDecorView();
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561588, null);
      Button localButton = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131369576);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131374408).setOnClickListener(this);
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
    if (this.jdField_a_of_type_Bjbs == null)
    {
      this.jdField_a_of_type_Bjbs = new bjbs(this);
      this.jdField_a_of_type_Bjbs.b(getTitleBarHeight());
    }
    this.jdField_a_of_type_Bjbs.c(2131689665);
    if (!this.jdField_a_of_type_Bjbs.isShowing()) {
      this.jdField_a_of_type_Bjbs.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Bjbs != null) && (this.jdField_a_of_type_Bjbs.isShowing()))
    {
      this.jdField_a_of_type_Bjbs.dismiss();
      this.jdField_a_of_type_Bjbs = null;
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
        ((AlphaAnimation)localObject1).setAnimationListener(new amki(this));
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      }
      int i = 0;
      while (i < j)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof amkn)))
        {
          localObject1 = (amkn)localObject1;
          int k = a((View)localObject2, (amkn)localObject1, true);
          localObject2 = new TranslateAnimation(-(this.mDensity * 34.0F), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(120L);
          ((AlphaAnimation)localObject3).setDuration(180L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          ((amkn)localObject1).c.setVisibility(0);
          ((TranslateAnimation)localObject2).setAnimationListener(new amkj(this, (amkn)localObject1));
          ((amkn)localObject1).c.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new amju(this, (amkn)localObject1));
          ((amkn)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new amjv(this, (amkn)localObject1, k));
          ((amkn)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new amjw(this, (amkn)localObject1));
          ((amkn)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, 28.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          ((amkn)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation(localAnimationSet);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((amkn)localObject1).d.setVisibility(0);
          ((amkn)localObject1).d.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new amjx(this));
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
        if ((localObject1 != null) && ((localObject1 instanceof amkn)))
        {
          localObject1 = (amkn)localObject1;
          k = a((View)localObject2, (amkn)localObject1, false);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(180L);
          Object localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((TranslateAnimation)localObject2).setAnimationListener(new amjy(this, (amkn)localObject1));
          ((amkn)localObject1).c.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new amjz(this, (amkn)localObject1));
          ((amkn)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((AnimationSet)localObject4).setAnimationListener(new amka(this, (amkn)localObject1, k));
          ((amkn)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject4);
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
          localAnimationSet.setAnimationListener(new amkb(this, (amkn)localObject1));
          ((amkn)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
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
          ((amkn)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation((Animation)localObject4);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((amkn)localObject1).d.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new amkc(this));
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
      if (!bhsr.a((String)localObject1))
      {
        bdll.b(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (!bhnv.d(this)) {
          break label143;
        }
        localObject2 = (FriendListHandler)this.app.a(1);
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { localObject1 };
        ((FriendListHandler)localObject2).b(1, this.jdField_a_of_type_ArrayOfJavaLangString, new boolean[] { false });
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2002);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label143:
      QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
      continue;
      switch (paramView.getId())
      {
      case 2131374408: 
      default: 
        localObject1 = paramView.getTag();
        if ((localObject1 == null) || (!(localObject1 instanceof amkn)))
        {
          bdll.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
          localObject1 = new Intent(this, ForwardFriendListActivity.class);
          ((Intent)localObject1).putExtra("extra_choose_friend", 1);
          ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
          startActivity((Intent)localObject1);
          overridePendingTransition(2130771979, 2130771977);
        }
        break;
      case 2131369073: 
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          d();
          bdll.b(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
        }
        else
        {
          i();
        }
        break;
      case 2131362133: 
        if (!bhnv.d(this))
        {
          QQToast.a(this, getString(2131691989), 0).b(getTitleBarHeight());
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
          this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(1, arrayOfString, (boolean[])localObject2);
          bdll.b(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(localObject1.length), "", "", "");
        }
        break;
      case 2131369576: 
        f();
        break;
      case 2131366015: 
        bdll.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        localObject1 = new Intent(this, ForwardFriendListActivity.class);
        ((Intent)localObject1).putExtra("extra_choose_friend", 1);
        ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
        startActivity((Intent)localObject1);
        overridePendingTransition(2130771979, 2130771977);
        continue;
        localObject1 = (amkn)localObject1;
        localObject2 = ((amkn)localObject1).jdField_a_of_type_ComTencentMobileqqDataFriends;
        localObject2 = new Intent(this, QQSpecialCareSettingActivity.class);
        ((Intent)localObject2).putExtra("key_friend_uin", ((amkn)localObject1).jdField_a_of_type_JavaLangString);
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
    if ((paramBitmap == null) || (this.jdField_a_of_type_Aoof.a())) {}
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
          localObject = (amkn)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((amkn)localObject).jdField_a_of_type_ComTencentMobileqqDataFriends.uin)))
          {
            ((amkn)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
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
      this.jdField_a_of_type_Amkl.notifyDataSetChanged();
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
          paramAbsListView = (amkn)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
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