package com.tencent.mobileqq.activity.specialcare;

import acrg;
import actj;
import aijd;
import aije;
import aijf;
import aijg;
import aijh;
import aiji;
import aijj;
import aijk;
import aijl;
import aijm;
import aijn;
import aijo;
import aijp;
import aijq;
import aijr;
import aijs;
import aijt;
import aiju;
import aijv;
import aijw;
import aijx;
import ajxj;
import ajxl;
import ajya;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import auko;
import aweq;
import axqy;
import baxy;
import baxz;
import bbao;
import bbcz;
import bbdv;
import bbfj;
import bbkk;
import bcqf;
import bcql;
import bfos;
import bfub;
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
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements acrg, View.OnClickListener, baxz, bfos
{
  public static final String a;
  public static final String b;
  public int a;
  public aijv a;
  aijw jdField_a_of_type_Aijw = new aijo(this);
  ajxj jdField_a_of_type_Ajxj = new aijp(this);
  ajxl jdField_a_of_type_Ajxl;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  public Handler a;
  public View a;
  Button jdField_a_of_type_AndroidWidgetButton;
  public LinearLayout a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  aweq jdField_a_of_type_Aweq;
  public baxy a;
  public bcqf a;
  bfub jdField_a_of_type_Bfub = new aijn(this);
  public ActivateFriendGrid a;
  public FriendListHandler a;
  public PullRefreshHeader a;
  public XListView a;
  ArrayList<aiju> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  int jdField_b_of_type_Int;
  View jdField_b_of_type_AndroidViewView;
  public ArrayList<auko> b;
  public boolean b;
  int c;
  public View c;
  public boolean c;
  public int d = 0;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajya.a(2131714275);
    jdField_b_of_type_JavaLangString = ajya.a(2131714276);
  }
  
  public SpecailCareListActivity()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new aijd(this);
  }
  
  public int a(View paramView, aijx paramaijx, boolean paramBoolean)
  {
    int j = getResources().getDimensionPixelSize(2131296677);
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
      j = paramaijx.jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.a(paramView, paramaijx, j, i);
      i = j;
    } while (!QLog.isColorLevel());
    QLog.d("SpecailCareListActivity", 2, "getNickRightMargin=" + j);
    return j;
  }
  
  public SpannableString a(Friends paramFriends, aijx paramaijx)
  {
    Object localObject1 = (aweq)this.app.getManager(15);
    Object localObject2 = (ajxl)this.app.getManager(51);
    if ((localObject1 == null) || (localObject2 == null)) {
      return null;
    }
    localObject1 = ((ajxl)localObject2).a(paramFriends.uin);
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
      paramaijx.b.setCompoundDrawables(null, null, null, null);
      if (((ExtensionInfo)localObject1).feedType != 2) {
        break label294;
      }
      paramaijx.e.setVisibility(0);
      if (TextUtils.isEmpty(((ExtensionInfo)localObject1).feedPhotoUrl)) {
        break label275;
      }
      bbao.a(paramaijx.e, ((ExtensionInfo)localObject1).feedPhotoUrl, getResources().getDrawable(2130849174));
    }
    for (;;)
    {
      paramaijx.f.setVisibility(8);
      paramaijx.g.setVisibility(8);
      paramaijx.b.setText(paramFriends);
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
      paramaijx.e.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130849174));
    }
    label294:
    paramaijx.f.setVisibility(0);
    localObject2 = paramaijx.f;
    if (((ExtensionInfo)localObject1).feedType == 1)
    {
      i = 2130848543;
      label321:
      ((ImageView)localObject2).setBackgroundResource(i);
      localObject2 = paramaijx.g;
      if (!((ExtensionInfo)localObject1).feedHasPhoto) {
        break label376;
      }
    }
    label376:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject2).setVisibility(i);
      paramaijx.e.setVisibility(8);
      paramaijx.e.setImageDrawable(null);
      break;
      i = 2130848541;
      break label321;
    }
    label382:
    if (k != 0)
    {
      localObject1 = this.jdField_a_of_type_Aweq.a(paramFriends.actionId, 200);
      localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
      i = this.jdField_b_of_type_Int;
      ((Drawable)localObject1).setBounds(0, 0, Math.round(((Drawable)localObject1).getIntrinsicWidth() * 1.0F / ((Drawable)localObject1).getIntrinsicHeight() * i), i);
      paramaijx.b.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    for (;;)
    {
      paramFriends = paramFriends.toSpannableString(null);
      paramaijx.f.setVisibility(8);
      paramaijx.g.setVisibility(8);
      paramaijx.e.setVisibility(8);
      paramaijx.e.setImageDrawable(null);
      break;
      if (j == 0)
      {
        paramFriends = RichStatus.getEmptyStatus();
        paramaijx.b.setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  public void a()
  {
    long l1 = System.currentTimeMillis();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    List localList = this.jdField_a_of_type_Ajxl.b();
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
          localObject = this.jdField_a_of_type_Ajxl.b(((SpecialCareInfo)localObject).uin);
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
    if ((this.jdField_a_of_type_Aijv != null) && (this.jdField_a_of_type_Aijv.a() != null)) {
      return;
    }
    if (((ajxl)this.app.getManager(51)).a() > 0) {
      axqy.b(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      View localView = getLayoutInflater().inflate(2131561111, null);
      if (this.jdField_a_of_type_Aijv == null) {
        break;
      }
      this.jdField_a_of_type_Aijv.a(localView);
      return;
      axqy.b(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
  }
  
  void c()
  {
    if (this.jdField_c_of_type_AndroidViewView != null) {
      return;
    }
    axqy.b(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561114, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, actj.a(75.0F, getResources()), 0, 0);
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new aijq(this));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_c_of_type_AndroidViewView.findViewById(2131362064));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid = ((ActivateFriendGrid)this.jdField_c_of_type_AndroidViewView.findViewById(2131367171));
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject2 = (aiju)localIterator.next();
      if ((this.jdField_a_of_type_Ajxl != null) && (!this.jdField_a_of_type_Ajxl.b(((aiju)localObject2).jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("SpecialCare", 2, ((aiju)localObject2).jdField_a_of_type_JavaLangString + " is not friend.. ");
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((aiju)localObject2).jdField_a_of_type_JavaLangString).longValue(), ((aiju)localObject2).jdField_b_of_type_JavaLangString);
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
      axqy.b(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i), "", "", "");
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
        setRightButton(2131699200, this);
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
      localTranslateAnimation.setAnimationListener(new aijr(this));
      this.jdField_c_of_type_AndroidViewView.startAnimation(localTranslateAnimation);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131561113);
    super.setTitle(2131717485);
    super.setRightButton(2131694075, this);
    this.app.addObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_Int = ((int)bbdv.a(this, 9.0F));
    this.jdField_b_of_type_Int = ((int)bbdv.a(this, 12.0F));
    this.jdField_c_of_type_Int = ((int)bbdv.a(this, 20.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131375364));
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)super.findViewById(2131369306));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131366310);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)getLayoutInflater().inflate(2131561110, null));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.addFooterView(this.jdField_a_of_type_AndroidWidgetLinearLayout);
    this.jdField_a_of_type_Aijv = new aijv(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_Aijv);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader = ((PullRefreshHeader)getLayoutInflater().inflate(2131559766, this.jdField_a_of_type_ComTencentWidgetXListView, false));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeader(this.jdField_a_of_type_ComTencentMobileqqWidgetPullRefreshHeader);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollHeight(getResources().getDimensionPixelSize(2131298637));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOverScrollListener(this.jdField_a_of_type_Bfub);
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setContentBackground(2130838514);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130844137);
    this.jdField_a_of_type_Baxy = new baxy(this, this.app);
    this.jdField_a_of_type_Baxy.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)this.app.a(1));
    this.jdField_a_of_type_Ajxl = ((ajxl)this.app.getManager(51));
    this.jdField_a_of_type_Aweq = ((aweq)this.app.getManager(15));
    this.jdField_a_of_type_Aweq.a(this.jdField_a_of_type_Aijw);
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
        aiju localaiju = new aiju();
        localaiju.jdField_a_of_type_JavaLangString = String.valueOf(localFriendScore.uint64_friend_uin.get());
        Friends localFriends = this.jdField_a_of_type_Ajxl.b(localaiju.jdField_a_of_type_JavaLangString);
        if (localFriends != null) {
          localaiju.jdField_b_of_type_JavaLangString = bbcz.a(localFriends);
        }
        if ((TextUtils.isEmpty(localaiju.jdField_b_of_type_JavaLangString)) && (localFriendScore.bytes_nick != null) && (localFriendScore.bytes_nick.get() != null)) {
          localaiju.jdField_b_of_type_JavaLangString = localFriendScore.bytes_nick.get().toStringUtf8();
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(localaiju);
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
      if (AppSetting.d)
      {
        this.leftView.setContentDescription(ajya.a(2131714272));
        this.jdField_a_of_type_AndroidViewView.setContentDescription(ajya.a(2131714273));
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
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    this.app.removeObserver(this.jdField_a_of_type_Ajxj);
    this.jdField_a_of_type_Aweq.b(this.jdField_a_of_type_Aijw);
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
      axqy.b(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
      localFrameLayout = (FrameLayout)getWindow().getDecorView();
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561112, null);
      Button localButton = (Button)this.jdField_b_of_type_AndroidViewView.findViewById(2131368850);
      this.jdField_b_of_type_AndroidViewView.findViewById(2131373077).setOnClickListener(this);
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
    if (this.jdField_a_of_type_Bcqf == null)
    {
      this.jdField_a_of_type_Bcqf = new bcqf(this);
      this.jdField_a_of_type_Bcqf.b(getTitleBarHeight());
    }
    this.jdField_a_of_type_Bcqf.c(2131689776);
    if (!this.jdField_a_of_type_Bcqf.isShowing()) {
      this.jdField_a_of_type_Bcqf.show();
    }
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()))
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
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
        ((AlphaAnimation)localObject1).setAnimationListener(new aijs(this));
        this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject1);
      }
      int i = 0;
      while (i < j)
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(i);
        localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof aijx)))
        {
          localObject1 = (aijx)localObject1;
          int k = a((View)localObject2, (aijx)localObject1, true);
          localObject2 = new TranslateAnimation(-(this.mDensity * 34.0F), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(120L);
          ((AlphaAnimation)localObject3).setDuration(180L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          ((aijx)localObject1).c.setVisibility(0);
          ((TranslateAnimation)localObject2).setAnimationListener(new aijt(this, (aijx)localObject1));
          ((aijx)localObject1).c.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new aije(this, (aijx)localObject1));
          ((aijx)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, 12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new aijf(this, (aijx)localObject1, k));
          ((aijx)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new aijg(this, (aijx)localObject1));
          ((aijx)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, 28.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          ((aijx)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation(localAnimationSet);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((aijx)localObject1).d.setVisibility(0);
          ((aijx)localObject1).d.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new aijh(this));
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
        if ((localObject1 != null) && ((localObject1 instanceof aijx)))
        {
          localObject1 = (aijx)localObject1;
          k = a((View)localObject2, (aijx)localObject1, false);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(180L);
          Object localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((TranslateAnimation)localObject2).setAnimationListener(new aiji(this, (aijx)localObject1));
          ((aijx)localObject1).c.startAnimation((Animation)localObject4);
          localObject2 = new TranslateAnimation(0.0F, -(34.0F * this.mDensity), 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new aijj(this, (aijx)localObject1));
          ((aijx)localObject1).jdField_a_of_type_AndroidWidgetImageView.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, -34.0F * this.mDensity, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, -12.0F * this.mDensity);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localObject4 = new AnimationSet(true);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
          ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
          ((AnimationSet)localObject4).setFillAfter(true);
          ((AnimationSet)localObject4).setAnimationListener(new aijk(this, (aijx)localObject1, k));
          ((aijx)localObject1).jdField_a_of_type_AndroidWidgetTextView.startAnimation((Animation)localObject4);
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
          localAnimationSet.setAnimationListener(new aijl(this, (aijx)localObject1));
          ((aijx)localObject1).jdField_a_of_type_AndroidViewView.startAnimation(localAnimationSet);
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
          ((aijx)localObject1).jdField_a_of_type_ComTencentMobileqqMutualmarkViewMutualMarkIconsView.startAnimation((Animation)localObject4);
          localObject2 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((aijx)localObject1).d.startAnimation((Animation)localObject2);
        }
        if (i == j - 2)
        {
          localObject1 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new aijm(this));
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
    if (((paramView instanceof ImageView)) && (paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      if (!bbkk.a(paramView))
      {
        axqy.b(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (!bbfj.d(this)) {
          break label134;
        }
        localObject = (FriendListHandler)this.app.a(1);
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[] { paramView };
        ((FriendListHandler)localObject).b(1, this.jdField_a_of_type_ArrayOfJavaLangString, new boolean[] { false });
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2002);
      }
    }
    label134:
    do
    {
      return;
      bcql.a(this, getString(2131692321), 0).b(getTitleBarHeight());
      return;
      switch (paramView.getId())
      {
      case 2131373077: 
      default: 
        paramView = paramView.getTag();
        if ((paramView != null) && ((paramView instanceof aijx))) {
          break;
        }
        axqy.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        paramView = new Intent(this, ForwardFriendListActivity.class);
        paramView.putExtra("extra_choose_friend", 1);
        paramView.putExtra("extra_add_special_friend", 2);
        startActivity(paramView);
        overridePendingTransition(2130771979, 2130771977);
        return;
      case 2131368457: 
        if (this.jdField_c_of_type_AndroidViewView != null)
        {
          d();
          axqy.b(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
          return;
        }
        i();
        return;
      case 2131362064: 
        if (bbfj.d(this)) {
          break label402;
        }
        bcql.a(this, getString(2131692321), 0).b(getTitleBarHeight());
      }
    } while (!QLog.isColorLevel());
    QLog.i("SpecailCareListActivity", 2, "No Network!");
    return;
    label402:
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
    Object localObject = new boolean[paramView.length];
    String[] arrayOfString = new String[paramView.length];
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[arrayOfString.length];
    int i = 0;
    while (i < paramView.length)
    {
      localObject[i] = 1;
      arrayOfString[i] = String.valueOf(paramView[i]);
      this.jdField_a_of_type_ArrayOfJavaLangString[i] = arrayOfString[i];
      i += 1;
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(1, arrayOfString, (boolean[])localObject);
    axqy.b(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(paramView.length), "", "", "");
    return;
    f();
    return;
    axqy.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
    paramView = new Intent(this, ForwardFriendListActivity.class);
    paramView.putExtra("extra_choose_friend", 1);
    paramView.putExtra("extra_add_special_friend", 2);
    startActivity(paramView);
    overridePendingTransition(2130771979, 2130771977);
    return;
    paramView = (aijx)paramView;
    localObject = paramView.jdField_a_of_type_ComTencentMobileqqDataFriends;
    localObject = new Intent(this, QQSpecialCareSettingActivity.class);
    ((Intent)localObject).putExtra("key_friend_uin", paramView.jdField_a_of_type_JavaLangString);
    ((Intent)localObject).putExtra("key_start_from", 5);
    startActivity((Intent)localObject);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpecailCareListActivity", 2, "uin=" + paramString + ", type=" + paramInt2 + ",avatar= " + paramBitmap);
    }
    if ((paramBitmap == null) || (this.jdField_a_of_type_Baxy.a())) {}
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
          localObject = (aijx)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((aijx)localObject).jdField_a_of_type_ComTencentMobileqqDataFriends.uin)))
          {
            ((aijx)localObject).jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
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
      this.jdField_a_of_type_Aijv.notifyDataSetChanged();
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
          paramAbsListView = (aijx)this.jdField_a_of_type_ComTencentWidgetXListView.getChildAt(paramInt).getTag();
          if ((paramAbsListView != null) && (paramAbsListView.jdField_a_of_type_JavaLangString != null) && (paramAbsListView.jdField_a_of_type_JavaLangString.length() > 0)) {
            a(paramAbsListView.jdField_a_of_type_ComTencentMobileqqDataFriends, paramAbsListView);
          }
          paramInt += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity
 * JD-Core Version:    0.7.0.1
 */