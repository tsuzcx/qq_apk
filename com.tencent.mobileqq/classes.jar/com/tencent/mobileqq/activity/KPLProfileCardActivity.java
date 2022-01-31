package com.tencent.mobileqq.activity;

import abad;
import abae;
import aciy;
import ajfi;
import ajfo;
import ajjj;
import ajjy;
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
import awqx;
import azue;
import babp;
import badq;
import bbmy;
import bepm;
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
  ajfo jdField_a_of_type_Ajfo = new abae(this);
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
          localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495402, null);
          localView = ((ViewGroup)localObject).findViewById(2131302061);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131302466);
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
    setContentView(2131495226);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131495225, null);
    this.jdField_a_of_type_Boolean = false;
    Object localObject = (FrameLayout)findViewById(16908290);
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundResource(2130844840);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302496));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131302473));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302491));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.a(0, this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.findViewById(2131297539), false);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView = ((PullToZoomHeaderListView)findViewById(2131299006));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentImageURLImageView);
    this.b = ((TextView)findViewById(2131302804));
    this.b.setText(getString(2131625011));
    this.b.setBackgroundResource(2130847966);
    this.b.setTextColor(getResources().getColor(2131100964));
    this.b.setOnClickListener(this);
    localObject = (LinearLayout)findViewById(2131298149);
    View localView = View.inflate(this, 2131495383, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131312607));
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131625564);
    this.jdField_a_of_type_AndroidWidgetButton.setTag("addFriend");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((LinearLayout)localObject).addView(localView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131311626));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView.setAdapter(new bepm(this.jdField_a_of_type_AndroidViewView));
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
    int i = (int)babp.i();
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
      m = i - aciy.a(20.0F, getResources());
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
      View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495394, null);
      ImageView localImageView = (ImageView)localView.findViewById(2131302082);
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getResources().getDrawable(2130844865);
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
        ((URLDrawable)localObject4).setTag(azue.b(m, m, (int)(16.0F * babp.a())));
        ((URLDrawable)localObject4).setDecodeHandler(azue.i);
        localImageView.setImageDrawable((Drawable)localObject4);
        ((TextView)localView.findViewById(2131311629)).setText((CharSequence)localObject1);
        ((TextView)localView.findViewById(2131299473)).setText((CharSequence)localObject3);
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
      localDrawable = getResources().getDrawable(2130844815);
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
          int i = getResources().getDimensionPixelSize(2131166308);
          int j = getResources().getDisplayMetrics().widthPixels;
          localURLDrawableOptions.mRequestHeight = i;
          localURLDrawableOptions.mRequestWidth = j;
          paramKplCard = URLDrawable.getDrawable(paramKplCard.bgUrl, localURLDrawableOptions);
          paramKplCard.setTag(azue.b(j, i, (int)(10.0F * babp.a())));
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramKplCard);
          this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, 200, true, true, true, false, 3);
          return;
          localOutOfMemoryError = localOutOfMemoryError;
          localOutOfMemoryError.printStackTrace();
          ColorDrawable localColorDrawable = new ColorDrawable(getResources().getColor(2131099738));
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
    ajjj localajjj = (ajjj)this.app.getManager(51);
    ajfi localajfi = (ajfi)this.app.a(2);
    if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataKplCard = localajjj.a(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
      if (badq.g(this)) {
        break label85;
      }
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.2(this));
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new KPLProfileCardActivity.3(this));
      return;
      label85:
      localajfi.d(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
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
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131296298);
    ((View)localObject1).setVisibility(0);
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131296297);
    ((LinearLayout)localObject2).removeAllViews();
    localObject1 = "";
    if (paramKplCard.gender == 0) {
      localObject1 = ajjy.a(2131640166);
    }
    for (;;)
    {
      a((ViewGroup)localObject2, 2130844850, (String)localObject1 + paramKplCard.gameLevel);
      a((ViewGroup)localObject2, 2130844399, paramKplCard.commonInfo);
      localObject1 = (ProfileCardFavorShowView)this.jdField_a_of_type_AndroidViewView.findViewById(2131303198);
      ((ProfileCardFavorShowView)localObject1).setVisibility(0);
      ((ProfileCardFavorShowView)localObject1).setTitle(ajjy.a(2131640167));
      ((ProfileCardFavorShowView)localObject1).removeAllViews();
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(ajjy.a(2131640170));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      ((ProfileCardFavorItemView)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
      Object localObject3 = new KPLScoreView(this);
      ((KPLScoreView)localObject3).setKplValue(paramKplCard.mvpLevel + ajjy.a(2131640172), paramKplCard.superLevel + ajjy.a(2131640171), paramKplCard.score + "%", paramKplCard.round + ajjy.a(2131640172));
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).b.setImageDrawable(new ColorDrawable(getResources().getColor(2131101537)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      if ((paramKplCard.roleList == null) || (paramKplCard.roleList.size() <= 0)) {
        break;
      }
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(ajjy.a(2131640173));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      localObject3 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131495412, null);
      HorizontalScrollLayout localHorizontalScrollLayout = (HorizontalScrollLayout)((View)localObject3).findViewById(2131309898);
      localHorizontalScrollLayout.setOnTouchListener(new abad(this));
      a(localHorizontalScrollLayout, paramKplCard);
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).b.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131101537)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
      return;
      if (paramKplCard.gender == 1) {
        localObject1 = ajjy.a(2131640168);
      }
    }
  }
  
  private void d()
  {
    if (!badq.g(this)) {}
    do
    {
      bbmy.a(this, getResources().getString(2131629009), 0).b(getTitleBarHeight());
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo == null) || (this.jdField_a_of_type_ComTencentMobileqqDataKplCard == null));
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg)) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg = KplRoleInfo.getKplVerifyMsg(this.app);
      }
    } while (((ajjj)this.app.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin));
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
      localObject = AddFriendLogicActivity.a(this, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, null, i, j, (String)localObject, null, null, getString(2131624088), null);
      ((Intent)localObject).putExtra("param_wzry_data", this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo);
      startActivityForResult((Intent)localObject, 228);
      awqx.b(this.app, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
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
    this.app.addObserver(this.jdField_a_of_type_Ajfo);
    return true;
  }
  
  public void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_Ajfo);
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
        awqx.b(this.app, "dc00898", "", "", "0X8008436", "0X8008436", 0, 0, "", "", "", "");
      }
    case 2131302832: 
      return;
    }
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */