package com.tencent.mobileqq.activity;

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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.KplHelper;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.profilecard.base.view.PullToZoomHeaderListView;
import com.tencent.mobileqq.profilecard.bussiness.photowall.view.ProfileCardFavorShowView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.HorizontalScrollLayout;
import com.tencent.mobileqq.widget.KPLScoreView;
import com.tencent.mobileqq.widget.ProfileCardFavorItemView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XSimpleListAdapter;
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
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new KPLProfileCardActivity.5(this);
  KplCard jdField_a_of_type_ComTencentMobileqqDataKplCard;
  KplRoleInfo.WZRYUIinfo jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
  PullToZoomHeaderListView jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewPullToZoomHeaderListView;
  AvatarLayout jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  boolean jdField_a_of_type_Boolean = false;
  TextView b;
  
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
          localObject = (ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561339, null);
          localView = ((ViewGroup)localObject).findViewById(2131368343);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131368773);
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
    setContentView(2131561130);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)getSystemService("layout_inflater"));
    this.jdField_a_of_type_AndroidViewView = View.inflate(this, 2131561129, null);
    this.jdField_a_of_type_Boolean = false;
    Object localObject = (FrameLayout)findViewById(16908290);
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundResource(2130845954);
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368800));
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout = ((AvatarLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368780));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368795));
    localObject = this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout;
    ((AvatarLayout)localObject).a(0, ((AvatarLayout)localObject).findViewById(2131363438), false);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewPullToZoomHeaderListView = ((PullToZoomHeaderListView)findViewById(2131365037));
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewPullToZoomHeaderListView.setHeaderImage(this.jdField_a_of_type_ComTencentImageURLImageView);
    this.b = ((TextView)findViewById(2131369202));
    this.b.setText(getString(2131690706));
    this.b.setBackgroundResource(2130849424);
    this.b.setTextColor(getResources().getColor(2131166742));
    this.b.setOnClickListener(this);
    localObject = (LinearLayout)findViewById(2131364110);
    View localView = View.inflate(this, 2131561308, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131379994));
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131691147);
    this.jdField_a_of_type_AndroidWidgetButton.setTag("addFriend");
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    ((LinearLayout)localObject).addView(localView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131378881));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewPullToZoomHeaderListView.setAdapter(new XSimpleListAdapter(this.jdField_a_of_type_AndroidViewView));
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
    int i = (int)DeviceInfoUtil.i();
    int j = 0;
    Object localObject1;
    if (k <= 4)
    {
      i /= 4;
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      paramHorizontalScrollLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    else
    {
      i = i * 146 / 640;
    }
    int m = i - AIOUtils.b(20.0F, getResources());
    for (Object localObject2 = null; j < k; localObject2 = localObject1)
    {
      Object localObject3 = (KplRoleInfo)paramKplCard.roleList.get(j);
      if (localObject3 == null)
      {
        localObject1 = localObject2;
      }
      else
      {
        View localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561323, null);
        ImageView localImageView = (ImageView)localView.findViewById(2131368367);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = getResources().getDrawable(2130845983);
        }
        Object localObject4 = ((KplRoleInfo)localObject3).roleUrl;
        localObject2 = ((KplRoleInfo)localObject3).roleName;
        localObject3 = ((KplRoleInfo)localObject3).roleScore;
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
          localURLDrawableOptions.mRequestHeight = m;
          localURLDrawableOptions.mRequestWidth = m;
          localObject4 = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
          ((URLDrawable)localObject4).setTag(URLDrawableDecodeHandler.b(m, m, (int)(16.0F * DeviceInfoUtil.a())));
          ((URLDrawable)localObject4).setDecodeHandler(URLDrawableDecodeHandler.i);
          localImageView.setImageDrawable((Drawable)localObject4);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        ((TextView)localView.findViewById(2131378884)).setText((CharSequence)localObject2);
        ((TextView)localView.findViewById(2131365534)).setText((CharSequence)localObject3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject3);
        localView.setContentDescription(localStringBuilder.toString());
        paramHorizontalScrollLayout.addView(localView, new LinearLayout.LayoutParams(i, -2));
      }
      j += 1;
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
    ColorDrawable localColorDrawable;
    try
    {
      Drawable localDrawable = getResources().getDrawable(2130845923);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      localColorDrawable = new ColorDrawable(getResources().getColor(2131165327));
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      int i = getResources().getDimensionPixelSize(2131297613);
      int j = getResources().getDisplayMetrics().widthPixels;
      localURLDrawableOptions.mRequestHeight = i;
      localURLDrawableOptions.mRequestWidth = j;
      paramKplCard = URLDrawable.getDrawable(paramKplCard.bgUrl, localURLDrawableOptions);
      paramKplCard.setTag(URLDrawableDecodeHandler.b(j, i, (int)(DeviceInfoUtil.a() * 10.0F)));
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramKplCard);
    }
    catch (Exception paramKplCard)
    {
      paramKplCard.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentMobileqqVasAvatarAvatarLayout.setFaceDrawable(this.app, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, 200, true, true, true, false, 3);
  }
  
  private void c()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
    if (localWZRYUIinfo != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataKplCard = localFriendsManager.a(localWZRYUIinfo.uin);
      if (!NetworkUtil.isNetworkAvailable(this)) {
        ThreadManager.getUIHandler().post(new KPLProfileCardActivity.2(this));
      } else {
        localCardHandler.b(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin);
      }
    }
    ThreadManager.getUIHandler().post(new KPLProfileCardActivity.3(this));
  }
  
  private void c(KplCard paramKplCard)
  {
    if (paramKplCard == null) {
      return;
    }
    Object localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName(paramKplCard.qqNick, paramKplCard.gameNick);
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
    localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131361875);
    ((View)localObject1).setVisibility(0);
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131361874);
    ((LinearLayout)localObject2).removeAllViews();
    if (paramKplCard.gender == 0) {
      localObject1 = HardCodeUtil.a(2131706030);
    } else if (paramKplCard.gender == 1) {
      localObject1 = HardCodeUtil.a(2131706032);
    } else {
      localObject1 = "";
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(paramKplCard.gameLevel);
    a((ViewGroup)localObject2, 2130845966, ((StringBuilder)localObject3).toString());
    a((ViewGroup)localObject2, 2130845480, paramKplCard.commonInfo);
    localObject1 = (ProfileCardFavorShowView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369703);
    ((ProfileCardFavorShowView)localObject1).setVisibility(0);
    ((ProfileCardFavorShowView)localObject1).setTitle(HardCodeUtil.a(2131706031));
    ((ProfileCardFavorShowView)localObject1).removeAllViews();
    localObject2 = new ProfileCardFavorItemView(this);
    ((ProfileCardFavorItemView)localObject2).setTitle(HardCodeUtil.a(2131706034));
    ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
    ((ProfileCardFavorItemView)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(8);
    localObject3 = new KPLScoreView(this);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramKplCard.mvpLevel);
    ((StringBuilder)localObject4).append(HardCodeUtil.a(2131706036));
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(paramKplCard.superLevel);
    ((StringBuilder)localObject5).append(HardCodeUtil.a(2131706035));
    localObject5 = ((StringBuilder)localObject5).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append(paramKplCard.score);
    ((StringBuilder)localObject6).append("%");
    localObject6 = ((StringBuilder)localObject6).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramKplCard.round);
    localStringBuilder.append(HardCodeUtil.a(2131706036));
    ((KPLScoreView)localObject3).setKplValue((String)localObject4, (String)localObject5, (String)localObject6, localStringBuilder.toString());
    ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
    ((ProfileCardFavorItemView)localObject2).b.setImageDrawable(new ColorDrawable(getResources().getColor(2131167394)));
    ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
    if ((paramKplCard.roleList != null) && (paramKplCard.roleList.size() > 0))
    {
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(HardCodeUtil.a(2131706037));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      localObject3 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561348, null);
      localObject4 = (HorizontalScrollLayout)((View)localObject3).findViewById(2131377003);
      ((HorizontalScrollLayout)localObject4).setOnTouchListener(new KPLProfileCardActivity.4(this));
      a((HorizontalScrollLayout)localObject4, paramKplCard);
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).b.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131167394)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
    }
  }
  
  private void d()
  {
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.a(this, getResources().getString(2131694476), 0).b(getTitleBarHeight());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataKplCard == null) {
        return;
      }
      if (TextUtils.isEmpty(((KplRoleInfo.WZRYUIinfo)localObject).verifyMsg)) {
        this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.verifyMsg = KplHelper.a(this.app);
      }
      if (!((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin))
      {
        localObject = KplRoleInfo.WZRYUIinfo.buildNickName(this.jdField_a_of_type_ComTencentMobileqqDataKplCard.qqNick, this.jdField_a_of_type_ComTencentMobileqqDataKplCard.gameNick);
        int i;
        if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.sourceId == 0) {
          i = 3045;
        } else {
          i = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.sourceId;
        }
        int j;
        if (this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.subSourceId == 0) {
          j = 23;
        } else {
          j = this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.subSourceId;
        }
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 1, this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo.uin, null, i, j, (String)localObject, null, null, getString(2131689589), null);
        ((Intent)localObject).putExtra("param_wzry_data", this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, (Intent)localObject, 228);
        ReportController.b(this.app, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(j), "", "", "");
      }
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
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqDataKplRoleInfo$WZRYUIinfo = ((KplRoleInfo.WZRYUIinfo)getIntent().getSerializableExtra("param_wzry_data"));
    a();
    b();
    this.app.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131369202)
    {
      if ((i != 2131369233) && ("addFriend".equals(paramView.getTag())))
      {
        d();
        ReportController.b(this.app, "dc00898", "", "", "0X8008436", "0X8008436", 0, 0, "", "", "", "");
      }
    }
    else {
      finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */