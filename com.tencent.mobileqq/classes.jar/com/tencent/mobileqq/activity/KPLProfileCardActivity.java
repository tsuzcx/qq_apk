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
  KplCard a;
  TextView b;
  Button c;
  LayoutInflater d;
  PullToZoomHeaderListView e;
  ImmersiveTitleBar2 f;
  TextView g;
  URLImageView h;
  AvatarLayout i;
  KplRoleInfo.WZRYUIinfo j;
  View k;
  boolean l = false;
  CardObserver m = new KPLProfileCardActivity.5(this);
  
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
          localObject = (ViewGroup)this.d.inflate(2131627695, null);
          localView = ((ViewGroup)localObject).findViewById(2131435219);
          TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(2131435692);
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
    setContentView(2131627480);
    this.d = ((LayoutInflater)getSystemService("layout_inflater"));
    this.k = View.inflate(this, 2131627479, null);
    this.l = false;
    Object localObject = (FrameLayout)findViewById(16908290);
    if (localObject != null) {
      ((FrameLayout)localObject).setBackgroundResource(2130847424);
    }
    this.h = ((URLImageView)this.k.findViewById(2131435721));
    this.i = ((AvatarLayout)this.k.findViewById(2131435701));
    this.b = ((TextView)this.k.findViewById(2131435716));
    localObject = this.i;
    ((AvatarLayout)localObject).a(0, ((AvatarLayout)localObject).findViewById(2131429335), false);
    this.e = ((PullToZoomHeaderListView)findViewById(2131431170));
    this.e.setHeaderImage(this.h);
    this.g = ((TextView)findViewById(2131436180));
    this.g.setText(getString(2131887625));
    this.g.setBackgroundResource(2130851108);
    this.g.setTextColor(getResources().getColor(2131167662));
    this.g.setOnClickListener(this);
    localObject = (LinearLayout)findViewById(2131430077);
    View localView = View.inflate(this, 2131627664, null);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    this.c = ((Button)localView.findViewById(2131448897));
    this.c.setText(2131888093);
    this.c.setTag("addFriend");
    this.c.setOnClickListener(this);
    ((LinearLayout)localObject).addView(localView, localLayoutParams);
    this.c.setEnabled(false);
    this.f = ((ImmersiveTitleBar2)findViewById(2131447582));
    this.f.setVisibility(4);
    this.e.setAdapter(new XSimpleListAdapter(this.k));
  }
  
  private void a(KplCard paramKplCard)
  {
    b(paramKplCard);
    c(paramKplCard);
  }
  
  private void a(HorizontalScrollLayout paramHorizontalScrollLayout, KplCard paramKplCard)
  {
    paramHorizontalScrollLayout.removeAllViews();
    int i2 = paramKplCard.roleList.size();
    int n = (int)DeviceInfoUtil.D();
    int i1 = 0;
    Object localObject1;
    if (i2 <= 4)
    {
      n /= 4;
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      paramHorizontalScrollLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    else
    {
      n = n * 146 / 640;
    }
    int i3 = n - AIOUtils.b(20.0F, getResources());
    for (Object localObject2 = null; i1 < i2; localObject2 = localObject1)
    {
      Object localObject3 = (KplRoleInfo)paramKplCard.roleList.get(i1);
      if (localObject3 == null)
      {
        localObject1 = localObject2;
      }
      else
      {
        View localView = this.d.inflate(2131627679, null);
        ImageView localImageView = (ImageView)localView.findViewById(2131435246);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = getResources().getDrawable(2130847453);
        }
        Object localObject4 = ((KplRoleInfo)localObject3).roleUrl;
        localObject2 = ((KplRoleInfo)localObject3).roleName;
        localObject3 = ((KplRoleInfo)localObject3).roleScore;
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject1);
          localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject1);
          localURLDrawableOptions.mRequestHeight = i3;
          localURLDrawableOptions.mRequestWidth = i3;
          localObject4 = URLDrawable.getDrawable((String)localObject4, localURLDrawableOptions);
          ((URLDrawable)localObject4).setTag(URLDrawableDecodeHandler.b(i3, i3, (int)(16.0F * DeviceInfoUtil.A())));
          ((URLDrawable)localObject4).setDecodeHandler(URLDrawableDecodeHandler.j);
          localImageView.setImageDrawable((Drawable)localObject4);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        ((TextView)localView.findViewById(2131447585)).setText((CharSequence)localObject2);
        ((TextView)localView.findViewById(2131431753)).setText((CharSequence)localObject3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append((String)localObject3);
        localView.setContentDescription(localStringBuilder.toString());
        paramHorizontalScrollLayout.addView(localView, new LinearLayout.LayoutParams(n, -2));
      }
      i1 += 1;
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
      Drawable localDrawable = getResources().getDrawable(2130847393);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      localColorDrawable = new ColorDrawable(getResources().getColor(2131165564));
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
      localURLDrawableOptions.mFailedDrawable = localColorDrawable;
      int n = getResources().getDimensionPixelSize(2131298277);
      int i1 = getResources().getDisplayMetrics().widthPixels;
      localURLDrawableOptions.mRequestHeight = n;
      localURLDrawableOptions.mRequestWidth = i1;
      paramKplCard = URLDrawable.getDrawable(paramKplCard.bgUrl, localURLDrawableOptions);
      paramKplCard.setTag(URLDrawableDecodeHandler.b(i1, n, (int)(DeviceInfoUtil.A() * 10.0F)));
      this.h.setImageDrawable(paramKplCard);
    }
    catch (Exception paramKplCard)
    {
      paramKplCard.printStackTrace();
    }
    this.i.setFaceDrawable(this.app, 1, this.j.uin, 200, true, true, true, false, 3);
  }
  
  private void c()
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    CardHandler localCardHandler = (CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    KplRoleInfo.WZRYUIinfo localWZRYUIinfo = this.j;
    if (localWZRYUIinfo != null)
    {
      this.a = localFriendsManager.i(localWZRYUIinfo.uin);
      if (!NetworkUtil.isNetworkAvailable(this)) {
        ThreadManager.getUIHandler().post(new KPLProfileCardActivity.2(this));
      } else {
        localCardHandler.b(this.j.uin);
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
    this.b.setText((CharSequence)localObject1);
    this.c.setEnabled(true);
    localObject1 = this.k.findViewById(2131427429);
    ((View)localObject1).setVisibility(0);
    Object localObject2 = (LinearLayout)((View)localObject1).findViewById(2131427428);
    ((LinearLayout)localObject2).removeAllViews();
    if (paramKplCard.gender == 0) {
      localObject1 = HardCodeUtil.a(2131903904);
    } else if (paramKplCard.gender == 1) {
      localObject1 = HardCodeUtil.a(2131903906);
    } else {
      localObject1 = "";
    }
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(paramKplCard.gameLevel);
    a((ViewGroup)localObject2, 2130847436, ((StringBuilder)localObject3).toString());
    a((ViewGroup)localObject2, 2130846936, paramKplCard.commonInfo);
    localObject1 = (ProfileCardFavorShowView)this.k.findViewById(2131436814);
    ((ProfileCardFavorShowView)localObject1).setVisibility(0);
    ((ProfileCardFavorShowView)localObject1).setTitle(HardCodeUtil.a(2131903905));
    ((ProfileCardFavorShowView)localObject1).removeAllViews();
    localObject2 = new ProfileCardFavorItemView(this);
    ((ProfileCardFavorItemView)localObject2).setTitle(HardCodeUtil.a(2131903908));
    ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
    ((ProfileCardFavorItemView)localObject2).e.setVisibility(8);
    localObject3 = new KPLScoreView(this);
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append(paramKplCard.mvpLevel);
    ((StringBuilder)localObject4).append(HardCodeUtil.a(2131903910));
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(paramKplCard.superLevel);
    ((StringBuilder)localObject5).append(HardCodeUtil.a(2131903909));
    localObject5 = ((StringBuilder)localObject5).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append(paramKplCard.score);
    ((StringBuilder)localObject6).append("%");
    localObject6 = ((StringBuilder)localObject6).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramKplCard.round);
    localStringBuilder.append(HardCodeUtil.a(2131903910));
    ((KPLScoreView)localObject3).setKplValue((String)localObject4, (String)localObject5, (String)localObject6, localStringBuilder.toString());
    ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
    ((ProfileCardFavorItemView)localObject2).d.setImageDrawable(new ColorDrawable(getResources().getColor(2131168464)));
    ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
    if ((paramKplCard.roleList != null) && (paramKplCard.roleList.size() > 0))
    {
      localObject2 = new ProfileCardFavorItemView(this);
      ((ProfileCardFavorItemView)localObject2).setTitle(HardCodeUtil.a(2131903911));
      ((ProfileCardFavorItemView)localObject2).setArrowVisiale(false);
      localObject3 = this.d.inflate(2131627704, null);
      localObject4 = (HorizontalScrollLayout)((View)localObject3).findViewById(2131445367);
      ((HorizontalScrollLayout)localObject4).setOnTouchListener(new KPLProfileCardActivity.4(this));
      a((HorizontalScrollLayout)localObject4, paramKplCard);
      ((ProfileCardFavorItemView)localObject2).addView((View)localObject3);
      ((ProfileCardFavorItemView)localObject2).d.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131168464)));
      ((ProfileCardFavorShowView)localObject1).addView((View)localObject2);
    }
  }
  
  private void d()
  {
    if (!NetworkUtil.isNetworkAvailable(this))
    {
      QQToast.makeText(this, getResources().getString(2131892158), 0).show(getTitleBarHeight());
      return;
    }
    Object localObject = this.j;
    if (localObject != null)
    {
      if (this.a == null) {
        return;
      }
      if (TextUtils.isEmpty(((KplRoleInfo.WZRYUIinfo)localObject).verifyMsg)) {
        this.j.verifyMsg = KplHelper.a(this.app);
      }
      if (!((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).n(this.j.uin))
      {
        localObject = KplRoleInfo.WZRYUIinfo.buildNickName(this.a.qqNick, this.a.gameNick);
        int n;
        if (this.j.sourceId == 0) {
          n = 3045;
        } else {
          n = this.j.sourceId;
        }
        int i1;
        if (this.j.subSourceId == 0) {
          i1 = 23;
        } else {
          i1 = this.j.subSourceId;
        }
        localObject = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(this, 1, this.j.uin, null, n, i1, (String)localObject, null, null, getString(2131886199), null);
        ((Intent)localObject).putExtra("param_wzry_data", this.j);
        ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(this, (Intent)localObject, 228);
        ReportController.b(this.app, "CliOper", "", "", "0X80085C5", "0X80085C5", 0, 0, String.valueOf(i1), "", "", "");
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
    this.j = ((KplRoleInfo.WZRYUIinfo)getIntent().getSerializableExtra("param_wzry_data"));
    a();
    b();
    this.app.addObserver(this.m);
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.app.removeObserver(this.m);
    super.doOnDestroy();
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    if (n != 2131436180)
    {
      if ((n != 2131436211) && ("addFriend".equals(paramView.getTag())))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.KPLProfileCardActivity
 * JD-Core Version:    0.7.0.1
 */