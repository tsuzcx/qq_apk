package com.tencent.mobileqq.activity;

import abkc;
import abkd;
import actn;
import ajtk;
import ajtq;
import ajxn;
import ajyc;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import axqw;
import bavi;
import bbct;
import bbev;
import bcpw;
import bfxg;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.KPLScoreView;
import com.tencent.mobileqq.widget.ProfileCardFavorItemView;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.os.MqqHandler;

public class KPLProfileCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  ajtq jdField_a_of_type_Ajtq = new abkd(this);
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  public KplCard a;
  KplRoleInfo.WZRYUIinfo jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  PullToZoomHeaderListView jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  public boolean a;
  TextView b;
  
  public KPLProfileCardActivity()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static Intent a(Context paramContext)
  {
    return new Intent(paramContext, KPLProfileCardActivity.class);
  }
  
  private ViewGroup a(ViewGroup paramViewGroup, int paramInt, String paramString)
  {
    View localView = null;
    Object localObject = localView;
    if (paramViewGroup != null)
    {
      localObject = localView;
      if (paramInt > 0)
      {
        localObject = localView;
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560980, null);
          localView = ((ViewGroup)localObject).findViewById(2131367679);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131368086);
          localView.setBackgroundResource(paramInt);
          localTextView.setText(paramString.trim());
          paramViewGroup.addView((View)localObject);
        }
      }
    }
    return localObject;
  }
  
  private void a()
  {
    setContentView(2131560803);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131560802, null);
    this.jdField_a_of_type_Boolean = false;
    Object localObject = (FrameLayout)findViewById(16908290);
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundResource(2130844921);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368116));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368093));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368111));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363080), false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)findViewById(2131364566));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentImageURLImageView);
    this.b = ((TextView)findViewById(2131368429));
    this.b.setText(getString(2131690572));
    this.b.setBackgroundResource(2130848196);
    this.b.setTextColor(getResources().getColor(2131166557));
    this.b.setOnClickListener(this);
    localObject = (LinearLayout)findViewById(2131363702);
    View localView = View.inflate(this, 2131560962, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131378431));
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131691136);
    this.jdField_a_of_type_AndroidWidgetButton.setTag("addFriend");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((LinearLayout)localObject).addView(localView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131377439));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new bfxg(this.jdField_a_of_type_AndroidViewView));
  }
  
  private void a(KplCard paramKplCard)
  {
    b(paramKplCard);
    c(paramKplCard);
  }
  
  private void a(HorizontalScrollLayout paramHorizontalScrollLayout, KplCard paramKplCard)
  {
    paramHorizontalScrollLayout.removeAllViews();
    int k = paramKplCard.roleList.size();
    int i = (int)bbct.i();
    Object localObject1;
    int m;
    int j;
    label77:
    Object localObject3;
    if (k <= 4)
    {
      i /= 4;
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      paramHorizontalScrollLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = null;
      m = i - actn.a(20.0F, getResources());
      j = 0;
      if (j >= k) {
        return;
      }
      localObject3 = (KplRoleInfo)paramKplCard.roleList.get(j);
      if (localObject3 != null) {
        break label127;
      }
    }
    for (;;)
    {
      j += 1;
      break label77;
      i = i * 146 / 640;
      break;
      label127:
      View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560972, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131367700);
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getResources().getDrawable(2130844946);
      }
      Object localObject4 = ((KplRoleInfo)localObject3).roleUrl;
      localObject1 = ((KplRoleInfo)localObject3).roleName;
      localObject3 = ((KplRoleInfo)localObject3).roleScore;
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
        localURLDrawableOptions.mRequestHeight = m;
        localURLDrawableOptions.mRequestWidth = m;
        localObject4 = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
        ((URLDrawable)localObject4).setTag(bavi.b(m, m, (int)(16.0F * bbct.a())));
        ((URLDrawable)localObject4).setDecodeHandler(bavi.i);
        localImageView.setImageDrawable((Drawable)localObject4);
        ((TextView)localView.findViewById(2131377442)).setText((CharSequence)localObject1);
        ((TextView)localView.findViewById(2131365041)).setText((CharSequence)localObject3);
        localView.setContentDescription((String)localObject1 + (String)localObject3);
        paramHorizontalScrollLayout.addView(localView, new LinearLayout.LayoutParams(i, -2));
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void b()
  {
    ThreadManager.postImmediately(new KPLProfileCardActivity.1(this), null, true);
  }
  
  private void b(KplCard paramKplCard)
  {
    if (paramKplCard == null) {
      return;
    }
    try
    {
      localDrawable = getResources().getDrawable(2130844896);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      try
      {
        for (;;)
        {
          Drawable localDrawable;
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = localDrawable;
          localURLDrawableOptions.mFailedDrawable = localDrawable;
          int i = getResources().getDimensionPixelSize(2131297389);
          int j = getResources().getDisplayMetrics().widthPixels;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = j;
          paramKplCard = URLDrawable.getDrawable(paramKplCard.bgUrl, localURLDrawableOptions);
          paramKplCard.setTag(bavi.b(j, i, (int)(10.0F * bbct.a())));
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramKplCard);
          this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, 200, true, true, true, false, 3);
          return;
          localOutOfMemoryError = localOutOfMemoryError;
          localOutOfMemoryError.printStackTrace();
          ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131165275));
        }
      }
      catch (Exception paramKplCard)
      {
        for (;;)
        {
          paramKplCard.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    ajxn localajxn = (ajxn)this.app.getManager(51);
    ajtk localajtk = (ajtk)this.app.a(2);
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataKplCard = localajxn.a(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
      if (bbev.g(this)) {
        break label85;
      }
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.2(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.3(this));
      return;
      label85:
      localajtk.d(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
    }
  }
  
  private void c(KplCard paramKplCard)
  {
    if (paramKplCard == null) {
      return;
    }
    Object localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName(paramKplCard.qqNick, paramKplCard.gameNick);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131361834);
    ((View)localObject1).setVisibility(0);
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131361833);
    ((LinearLayout)localObject2).removeAllViews();
    localObject1 = "";
    if (paramKplCard.gender == 0) {
      localObject1 = ajyc.a(2131705951);
    }
    for (;;)
    {
      a((ViewGroup)localObject2, 2130844931, (String)localObject1 + paramKplCard.gameLevel);
      a((ViewGroup)localObject2, 2130844481, paramKplCard.commonInfo);
      localObject1 = (ProfileCardFavorShowView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368863);
      ((ProfileCardFavorShowView)localObject1).setVisibility(0);
      ((ProfileCardFavorShowView)localObject1).setTitle(ajyc.a(2131705952));
      ((ProfileCardFavorShowView)localObject1).removeAllViews();
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(ajyc.a(2131705955));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      ((ProfileCardFavorItemView)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
      Object localObject3 = new KPLScoreView(this);
      ((KPLScoreView)localObject3).setKplValue(paramKplCard.mvpLevel + ajyc.a(2131705957), paramKplCard.superLevel + ajyc.a(2131705956), paramKplCard.score + "%", paramKplCard.round + ajyc.a(2131705957));
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).b.setImageDrawable(new ColorDrawable(getResources().getColor(2131167134)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      if ((paramKplCard.roleList == null) || (paramKplCard.roleList.size() <= 0)) {
        break;
      }
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(ajyc.a(2131705958));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      localObject3 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131560990, null);
      HorizontalScrollLayout localHorizontalScrollLayout = (HorizontalScrollLayout)((View)localObject3).findViewById(2131375657);
      localHorizontalScrollLayout.setOnTouchListener(new abkc(this));
      a(localHorizontalScrollLayout, paramKplCard);
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).b.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131167134)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      return;
      if (paramKplCard.gender == 1) {
        localObject1 = ajyc.a(2131705953);
      }
    }
  }
  
  private void d()
  {
    if (!bbev.g(this)) {}
    do
    {
      bcpw.a(this, getResources().getString(2131694673), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataKplCard == null));
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg)) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg = KplRoleInfo.getKplVerifyMsg(this.app);
      }
    } while (((ajxn)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin));
    Object localObject = KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqDataKplCard.qqNick, this.jdField_a_of_type_ComTencentMobileqqDataKplCard.gameNick);
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.sourceId == 0)
    {
      i = 3045;
      if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.subSourceId != 0) {
        break label238;
      }
    }
    label238:
    for (int j = 23;; j = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.subSourceId)
    {
      localObject = AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, null, i, j, (String)localObject, null, null, getString(2131689628), null);
      ((Intent)localObject).putExtra("param_wzry_data", this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo);
      startActivityForResult((Intent)localObject, 228);
      axqw.b(this.app, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.sourceId;
      break;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)getIntent().getSerializableExtra("param_wzry_data"));
    a();
    b();
    this.app.addObserver(this.jdField_a_of_type_Ajtq);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Ajtq);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      if ("addFriend".equals(paramView.getTag()))
      {
        d();
        axqw.b(this.app, "dc00898", "", "", "0X8008436", "0X8008436", 0, 0, "", "", "", "");
      }
    case 2131368457: 
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */