package com.tencent.mobileqq.activity;

import Override;
import aeve;
import aevf;
import agej;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import anum;
import anuw;
import anyw;
import anzj;
import bdll;
import bhez;
import bhlo;
import bhnv;
import blrq;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PullToZoomHeaderListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;
import mqq.os.MqqHandler;

public class KPLProfileCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anuw jdField_a_of_type_Anuw = new aevf(this);
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
          localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561443, null);
          localView = ((ViewGroup)localObject).findViewById(2131368212);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131368636);
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
    setContentView(2131561250);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561249, null);
    this.jdField_a_of_type_Boolean = false;
    Object localObject = (FrameLayout)findViewById(16908290);
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundResource(2130845770);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368663));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368643));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368658));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131363327), false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)findViewById(2131364907));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentImageURLImageView);
    this.b = ((TextView)findViewById(2131369042));
    this.b.setText(getString(2131690559));
    this.b.setBackgroundResource(2130849155);
    this.b.setTextColor(getResources().getColor(2131166690));
    this.b.setOnClickListener(this);
    localObject = (LinearLayout)findViewById(2131363990);
    View localView = View.inflate(this, 2131561414, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131380216));
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131690994);
    this.jdField_a_of_type_AndroidWidgetButton.setTag("addFriend");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((LinearLayout)localObject).addView(localView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131379037));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new blrq(this.jdField_a_of_type_AndroidViewView));
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
    int i = (int)bhlo.i();
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
      m = i - agej.a(20.0F, getResources());
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
      View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561427, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131368238);
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getResources().getDrawable(2130845796);
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
        ((URLDrawable)localObject4).setTag(bhez.b(m, m, (int)(16.0F * bhlo.a())));
        ((URLDrawable)localObject4).setDecodeHandler(bhez.j);
        localImageView.setImageDrawable((Drawable)localObject4);
        ((TextView)localView.findViewById(2131379040)).setText((CharSequence)localObject1);
        ((TextView)localView.findViewById(2131365411)).setText((CharSequence)localObject3);
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
      localDrawable = getResources().getDrawable(2130845745);
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
          int i = getResources().getDimensionPixelSize(2131297499);
          int j = getResources().getDisplayMetrics().widthPixels;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = j;
          paramKplCard = URLDrawable.getDrawable(paramKplCard.bgUrl, localURLDrawableOptions);
          paramKplCard.setTag(bhez.b(j, i, (int)(10.0F * bhlo.a())));
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramKplCard);
          this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, 200, true, true, true, false, 3);
          return;
          localOutOfMemoryError = localOutOfMemoryError;
          localOutOfMemoryError.printStackTrace();
          ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131165343));
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
    anyw localanyw = (anyw)this.app.getManager(51);
    anum localanum = (anum)this.app.a(2);
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataKplCard = localanyw.a(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
      if (bhnv.g(this)) {
        break label85;
      }
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.2(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.3(this));
      return;
      label85:
      localanum.b(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
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
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131361867);
    ((View)localObject1).setVisibility(0);
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131361866);
    ((LinearLayout)localObject2).removeAllViews();
    localObject1 = "";
    if (paramKplCard.gender == 0) {
      localObject1 = anzj.a(2131704854);
    }
    for (;;)
    {
      a((ViewGroup)localObject2, 2130845780, (String)localObject1 + paramKplCard.gameLevel);
      a((ViewGroup)localObject2, 2130845328, paramKplCard.commonInfo);
      localObject1 = (ProfileCardFavorShowView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369589);
      ((ProfileCardFavorShowView)localObject1).setVisibility(0);
      ((ProfileCardFavorShowView)localObject1).setTitle(anzj.a(2131704855));
      ((ProfileCardFavorShowView)localObject1).removeAllViews();
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(anzj.a(2131704858));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      ((ProfileCardFavorItemView)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
      Object localObject3 = new KPLScoreView(this);
      ((KPLScoreView)localObject3).setKplValue(paramKplCard.mvpLevel + anzj.a(2131704860), paramKplCard.superLevel + anzj.a(2131704859), paramKplCard.score + "%", paramKplCard.round + anzj.a(2131704860));
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).b.setImageDrawable(new ColorDrawable(getResources().getColor(2131167302)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      if ((paramKplCard.roleList == null) || (paramKplCard.roleList.size() <= 0)) {
        break;
      }
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(anzj.a(2131704861));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      localObject3 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561454, null);
      HorizontalScrollLayout localHorizontalScrollLayout = (HorizontalScrollLayout)((View)localObject3).findViewById(2131377115);
      localHorizontalScrollLayout.setOnTouchListener(new aeve(this));
      a(localHorizontalScrollLayout, paramKplCard);
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).b.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131167302)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      return;
      if (paramKplCard.gender == 1) {
        localObject1 = anzj.a(2131704856);
      }
    }
  }
  
  private void d()
  {
    if (!bhnv.g(this)) {}
    do
    {
      QQToast.a(this, getResources().getString(2131694009), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataKplCard == null));
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg)) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg = KplRoleInfo.getKplVerifyMsg(this.app);
      }
    } while (((anyw)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin));
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
      localObject = AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, null, i, j, (String)localObject, null, null, getString(2131689551), null);
      ((Intent)localObject).putExtra("param_wzry_data", this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo);
      startActivityForResult((Intent)localObject, 228);
      bdll.b(this.app, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
      return;
      i = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.sourceId;
      break;
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
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)getIntent().getSerializableExtra("param_wzry_data"));
    a();
    b();
    this.app.addObserver(this.jdField_a_of_type_Anuw);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Anuw);
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
        bdll.b(this.app, "dc00898", "", "", "0X8008436", "0X8008436", 0, 0, "", "", "", "");
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */