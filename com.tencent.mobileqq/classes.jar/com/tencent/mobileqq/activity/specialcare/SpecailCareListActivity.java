package com.tencent.mobileqq.activity.specialcare;

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
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid.GridCallBack;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.ActivateFriendItem;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.mutualmark.view.MutualMarkIconsView;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.QQStoryCoverImageViewHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.util.BadgeUtils;
import com.tencent.util.notification.NotifyIdManager;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;

public class SpecailCareListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, ActivateFriendGrid.GridCallBack, DecodeTaskCompletionListener, AbsListView.OnScrollListener
{
  static final String a = HardCodeUtil.a(2131911642);
  static final String b = HardCodeUtil.a(2131911643);
  Handler A = new SpecailCareListActivity.1(this);
  OverScrollViewListener B = new SpecailCareListActivity.2(this);
  SpecailCareListActivity.StatusIconListener C = new SpecailCareListActivity.3(this);
  FriendListObserver D = new SpecailCareListActivity.4(this);
  int E = 0;
  private int F;
  private FormSwitchItem G;
  private String H = "";
  private CardHandler I;
  private String[] J;
  private CompoundButton.OnCheckedChangeListener K = new SpecailCareListActivity.5(this);
  private CardObserver L = new SpecailCareListActivity.6(this);
  int c;
  int d;
  RelativeLayout e;
  LinearLayout f;
  View g;
  XListView h;
  QQProgressDialog i;
  PullRefreshHeader j;
  Drawable k;
  View l;
  View m;
  Button n;
  SpecailCareListActivity.SpecailCareListAdapter o;
  IFaceDecoder p;
  int q;
  boolean r = false;
  ActivateFriendGrid s;
  ArrayList<SpecailCareListActivity.RecommendFriend> t = new ArrayList();
  ArrayList<Entity> u = new ArrayList();
  FriendListHandler v;
  FriendsManager w;
  StatusManager x;
  boolean y = false;
  boolean z = false;
  
  public int a(View paramView, SpecailCareListActivity.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    int i2 = getResources().getDimensionPixelSize(2131297142);
    if (paramBoolean) {
      return i2;
    }
    int i1 = 0;
    XListView localXListView = this.h;
    if (localXListView != null) {
      i1 = localXListView.getWidth();
    }
    i1 = paramViewHolder.n.a(paramView, paramViewHolder, i2, i1);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("getNickRightMargin=");
      paramView.append(i1);
      QLog.d("SpecailCareListActivity", 2, paramView.toString());
    }
    return i1;
  }
  
  SpannableString a(Friends paramFriends, SpecailCareListActivity.ViewHolder paramViewHolder)
  {
    Object localObject1 = (StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER);
    Object localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject1 != null)
    {
      if (localObject2 == null) {
        return null;
      }
      localObject1 = ((FriendsManager)localObject2).x(paramFriends.uin);
      int i4 = 0;
      int i1;
      if ((localObject1 != null) && (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedContent))) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (localObject1 != null)
      {
        boolean bool;
        if (this.E != 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramFriends = ExtensionRichStatus.a((ExtensionInfo)localObject1, bool);
      }
      else
      {
        paramFriends = null;
      }
      int i2;
      if ((paramFriends != null) && (!paramFriends.isEmpty())) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      int i3;
      if ((i2 != 0) && (!TextUtils.isEmpty(paramFriends.actionText))) {
        i3 = 1;
      } else {
        i3 = 0;
      }
      if ((i1 != 0) && ((((ExtensionInfo)localObject1).feedTime > ((ExtensionInfo)localObject1).richTime) || (i2 == 0)))
      {
        paramFriends = new SpannableString(((ExtensionInfo)localObject1).feedContent);
        paramViewHolder.d.setCompoundDrawables(null, null, null, null);
        if (((ExtensionInfo)localObject1).feedType == 2)
        {
          paramViewHolder.j.setVisibility(0);
          if (!TextUtils.isEmpty(((ExtensionInfo)localObject1).feedPhotoUrl)) {
            QQStoryCoverImageViewHelper.a(paramViewHolder.j, ((ExtensionInfo)localObject1).feedPhotoUrl, getResources().getDrawable(2130852411));
          } else {
            paramViewHolder.j.setImageDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(2130852411));
          }
          paramViewHolder.k.setVisibility(8);
          paramViewHolder.l.setVisibility(8);
        }
        else
        {
          paramViewHolder.k.setVisibility(0);
          localObject2 = paramViewHolder.k;
          if (((ExtensionInfo)localObject1).feedType == 1) {
            i1 = 2130851613;
          } else {
            i1 = 2130851611;
          }
          ((ImageView)localObject2).setBackgroundResource(i1);
          localObject2 = paramViewHolder.l;
          if (((ExtensionInfo)localObject1).feedHasPhoto) {
            i1 = i4;
          } else {
            i1 = 8;
          }
          ((ImageView)localObject2).setVisibility(i1);
          paramViewHolder.j.setVisibility(8);
          paramViewHolder.j.setImageDrawable(null);
        }
      }
      else
      {
        if (i3 != 0)
        {
          localObject1 = this.x.a(paramFriends.actionId, 200);
          localObject1 = new BitmapDrawable(getResources(), (Bitmap)localObject1);
          i1 = this.d;
          ((Drawable)localObject1).setBounds(0, 0, Math.round(((Drawable)localObject1).getIntrinsicWidth() * 1.0F / ((Drawable)localObject1).getIntrinsicHeight() * i1), i1);
          paramViewHolder.d.setCompoundDrawables((Drawable)localObject1, null, null, null);
        }
        else if (i2 == 0)
        {
          paramFriends = RichStatus.getEmptyStatus();
          paramViewHolder.d.setCompoundDrawables(null, null, null, null);
        }
        paramFriends = paramFriends.toSpannableString(null);
        paramViewHolder.k.setVisibility(8);
        paramViewHolder.l.setVisibility(8);
        paramViewHolder.j.setVisibility(8);
        paramViewHolder.j.setImageDrawable(null);
      }
      paramViewHolder.d.setText(paramFriends);
      return paramFriends;
    }
    return null;
  }
  
  void a()
  {
    long l1 = System.currentTimeMillis();
    this.u.clear();
    Object localObject1 = this.w.o();
    int i2 = 0;
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      this.rightViewText.setVisibility(0);
      if (this.z)
      {
        this.rightViewText.setText(b);
        this.f.setVisibility(8);
      }
      else
      {
        this.rightViewText.setText(a);
        this.f.setVisibility(0);
      }
      int i1 = i2;
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getSpecailCareInfos return size:");
        ((StringBuilder)localObject2).append(((List)localObject1).size());
        QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject2).toString());
        i1 = i2;
      }
      while (i1 < ((List)localObject1).size())
      {
        localObject2 = (SpecialCareInfo)((List)localObject1).get(i1);
        localObject2 = this.w.c(((SpecialCareInfo)localObject2).uin);
        if (localObject2 != null) {
          this.u.add(localObject2);
        }
        i1 += 1;
      }
      ThreadManager.post(new SpecailCareListActivity.7(this), 8, null, true);
    }
    else
    {
      b();
      this.leftView.setVisibility(0);
      this.z = false;
      this.rightViewText.setVisibility(4);
      this.f.setVisibility(8);
      if (QLog.isColorLevel()) {
        QLog.d("SpecailCareListActivity", 2, "getSpecailCareInfos: empty...");
      }
    }
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("refreshSpecialCareData cost time = ");
      ((StringBuilder)localObject1).append(l2 - l1);
      QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 0)
    {
      this.n.setEnabled(true);
      return;
    }
    this.n.setEnabled(false);
  }
  
  void a(int paramInt, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getPreferences(0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterSpecailCare");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean).commit();
  }
  
  void b()
  {
    Object localObject = this.o;
    if ((localObject != null) && (((SpecailCareListActivity.SpecailCareListAdapter)localObject).a() != null)) {
      return;
    }
    if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).u() > 0) {
      ReportController.b(this.app, "CliOper", "", "", "0X80050E0", "0X80050E0", 0, 0, "", "", "", "");
    } else {
      ReportController.b(this.app, "CliOper", "", "", "0X80050DF", "0X80050DF", 0, 0, "", "", "", "");
    }
    localObject = getLayoutInflater().inflate(2131627849, null);
    SpecailCareListActivity.SpecailCareListAdapter localSpecailCareListAdapter = this.o;
    if (localSpecailCareListAdapter != null) {
      localSpecailCareListAdapter.a((View)localObject);
    }
  }
  
  boolean b(int paramInt)
  {
    SharedPreferences localSharedPreferences = getPreferences(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("enterSpecailCare");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false) ^ true;
  }
  
  void c()
  {
    if (this.m != null) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DA", "0X80050DA", 0, 0, "", "", "", "");
    this.m = LayoutInflater.from(this).inflate(2131627852, null);
    Object localObject1 = new FrameLayout.LayoutParams(-1, -1);
    int i2 = AIOUtils.b(75.0F, getResources());
    int i1 = 0;
    ((FrameLayout.LayoutParams)localObject1).setMargins(0, i2, 0, 0);
    this.m.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    this.m.setOnClickListener(new SpecailCareListActivity.8(this));
    this.n = ((Button)this.m.findViewById(2131427764));
    this.n.setOnClickListener(this);
    this.s = ((ActivateFriendGrid)this.m.findViewById(2131434389));
    this.s.setGridCallBack(this);
    localObject1 = new ArrayList();
    Iterator localIterator = this.t.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (SpecailCareListActivity.RecommendFriend)localIterator.next();
      Object localObject3 = this.w;
      if ((localObject3 != null) && (!((FriendsManager)localObject3).n(((SpecailCareListActivity.RecommendFriend)localObject2).a)))
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(((SpecailCareListActivity.RecommendFriend)localObject2).a);
          ((StringBuilder)localObject3).append(" is not friend.. ");
          QLog.d("SpecialCare", 2, ((StringBuilder)localObject3).toString());
        }
      }
      else
      {
        localObject2 = new ActivateFriendItem(1, Long.valueOf(((SpecailCareListActivity.RecommendFriend)localObject2).a).longValue(), ((SpecailCareListActivity.RecommendFriend)localObject2).b);
        if (i1 < 6)
        {
          ((ArrayList)localObject1).add(localObject2);
          i1 += 1;
        }
      }
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DC", "0X80050DC", 0, 0, String.valueOf(i1), "", "", "");
    this.s.setData(this.app, (ArrayList)localObject1);
    if (this.m.getParent() == null) {
      if (Build.VERSION.SDK_INT < 14) {
        ((ViewGroup)this.e.getParent().getParent()).addView(this.m);
      } else {
        ((FrameLayout)getWindow().getDecorView()).addView(this.m);
      }
    }
    setRightButton(2131897049, this);
  }
  
  void d()
  {
    Object localObject = this.m;
    if ((localObject != null) && (((View)localObject).getParent() != null)) {
      if (Build.VERSION.SDK_INT < 14)
      {
        ((ViewGroup)this.e.getParent().getParent()).removeView(this.m);
        this.m = null;
        localObject = this.s;
        if (localObject != null)
        {
          ((ActivateFriendGrid)localObject).b();
          this.s = null;
        }
      }
      else
      {
        localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 2, -1.0F);
        ((TranslateAnimation)localObject).setInterpolator(new AccelerateInterpolator());
        ((TranslateAnimation)localObject).setDuration(500L);
        ((TranslateAnimation)localObject).setFillAfter(true);
        ((TranslateAnimation)localObject).setAnimationListener(new SpecailCareListActivity.9(this));
        this.m.startAnimation((Animation)localObject);
      }
    }
    this.rightViewText.setVisibility(4);
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
    long l1 = System.currentTimeMillis();
    super.doOnCreate(paramBundle);
    setContentView(2131627851);
    super.setTitle(2131914364);
    super.setRightButton(2131891485, this);
    this.app.addObserver(this.D);
    this.app.addObserver(this.L);
    this.c = ((int)DisplayUtils.a(this, 9.0F));
    this.d = ((int)DisplayUtils.a(this, 12.0F));
    this.q = ((int)DisplayUtils.a(this, 20.0F));
    this.e = ((RelativeLayout)super.findViewById(2131444933));
    this.h = ((XListView)super.findViewById(2131437317));
    this.g = super.findViewById(2131433225);
    this.g.setOnClickListener(this);
    this.f = ((LinearLayout)getLayoutInflater().inflate(2131627848, null));
    this.f.setOnClickListener(this);
    this.h.addFooterView(this.f);
    this.o = new SpecailCareListActivity.SpecailCareListAdapter(this);
    this.h.setAdapter(this.o);
    this.j = ((PullRefreshHeader)getLayoutInflater().inflate(2131626006, this.h, false));
    this.h.setOverScrollHeader(this.j);
    this.h.setOverScrollHeight(getResources().getDimensionPixelSize(2131299643));
    this.h.setOverScrollListener(this.B);
    this.h.setOnScrollListener(this);
    this.k = getResources().getDrawable(2130846389);
    this.p = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.p.setDecodeTaskCompletionListener(this);
    this.v = ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.w = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.x = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.x.a(this.C);
    this.G = ((FormSwitchItem)findViewById(2131446211));
    this.I = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    this.H = this.app.getCurrentAccountUin();
    this.G.setOnCheckedChangeListener(this.K);
    boolean bool = NotifyIdManager.a();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("initUI: invoked. special bar enable: ");
      paramBundle.append(bool);
      QLog.i("SpecailCareListActivity", 2, paramBundle.toString());
    }
    this.G.setChecked(bool);
    this.I.c(bool);
    this.G.setContentDescription(getString(2131914365));
    this.G.setVisibility(0);
    a();
    if ((this.u.size() <= 0) && (b(1)))
    {
      this.v.getFriendGroupList(true);
      FriendListHandler.getSpecialRecommendStat = 2;
      paramBundle = this.v.getRecommendList();
      if ((paramBundle != null) && (paramBundle.size() > 0))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fh.getRecommendList() return size:");
          ((StringBuilder)localObject).append(paramBundle.size());
          QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject).toString());
        }
        this.t.clear();
        paramBundle = paramBundle.iterator();
        while (paramBundle.hasNext())
        {
          localObject = (oidb_0x7df.FriendScore)paramBundle.next();
          SpecailCareListActivity.RecommendFriend localRecommendFriend = new SpecailCareListActivity.RecommendFriend();
          localRecommendFriend.a = String.valueOf(((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.get());
          Friends localFriends = this.w.c(localRecommendFriend.a);
          if (localFriends != null) {
            localRecommendFriend.b = ContactUtils.a(localFriends);
          }
          if ((TextUtils.isEmpty(localRecommendFriend.b)) && (((oidb_0x7df.FriendScore)localObject).bytes_nick != null) && (((oidb_0x7df.FriendScore)localObject).bytes_nick.get() != null)) {
            localRecommendFriend.b = ((oidb_0x7df.FriendScore)localObject).bytes_nick.get().toStringUtf8();
          }
          this.t.add(localRecommendFriend);
        }
        c();
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("SpecailCareListActivity", 2, "fh.getRecommendList(): empty...");
      }
    }
    a(1, true);
    a(2, true);
    long l2 = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("doOnCreate cost time = ");
      paramBundle.append(l2 - l1);
      QLog.d("SpecailCareListActivity", 2, paramBundle.toString());
    }
    if (AppSetting.e)
    {
      this.leftView.setContentDescription(HardCodeUtil.a(2131901576));
      this.g.setContentDescription(HardCodeUtil.a(2131911640));
    }
    this.v.getOnlineFriend(this.app.getCurrentAccountUin(), (byte)3);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    Object localObject = this.p;
    if (localObject != null) {
      ((IFaceDecoder)localObject).destory();
    }
    if (this.app != null)
    {
      this.app.removeObserver(this.L);
      if (BadgeUtils.a(this.app.getApplication())) {
        BadgeUtils.c();
      }
      this.app.removeObserver(this.D);
    }
    this.x.b(this.C);
    h();
    localObject = this.s;
    if (localObject != null)
    {
      ((ActivateFriendGrid)localObject).b();
      this.s = null;
    }
  }
  
  void e()
  {
    if (this.l != null) {
      return;
    }
    if (this.m != null) {
      return;
    }
    ReportController.b(this.app, "CliOper", "", "", "0X80050DB", "0X80050DB", 0, 0, "", "", "", "");
    FrameLayout localFrameLayout = (FrameLayout)getWindow().getDecorView();
    this.l = LayoutInflater.from(this).inflate(2131627850, null);
    Button localButton = (Button)this.l.findViewById(2131436801);
    this.l.findViewById(2131442451).setOnClickListener(this);
    localButton.setOnClickListener(this);
    if (this.l.getParent() == null) {
      localFrameLayout.addView(this.l);
    }
  }
  
  void f()
  {
    View localView = this.l;
    if ((localView != null) && (localView.getParent() != null))
    {
      ((FrameLayout)getWindow().getDecorView()).removeView(this.l);
      this.l = null;
    }
  }
  
  void g()
  {
    if (this.i == null)
    {
      this.i = new QQProgressDialog(this);
      this.i.b(getTitleBarHeight());
    }
    this.i.c(2131886315);
    if (!this.i.isShowing()) {
      this.i.show();
    }
  }
  
  void h()
  {
    QQProgressDialog localQQProgressDialog = this.i;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing()))
    {
      this.i.dismiss();
      this.i = null;
    }
  }
  
  void i()
  {
    this.rightViewText.setClickable(false);
    int i2 = this.h.getChildCount();
    Object localObject1 = this.rightViewText.getText().toString();
    if (a.equals(localObject1))
    {
      if (this.g.getVisibility() == 0)
      {
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new SpecailCareListActivity.10(this));
        this.g.startAnimation((Animation)localObject1);
      }
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject2 = this.h.getChildAt(i1);
        localObject1 = ((View)localObject2).getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
        {
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          int i3 = a((View)localObject2, (SpecailCareListActivity.ViewHolder)localObject1, true);
          localObject2 = new TranslateAnimation(-(this.mDensity * 34.0F), 0.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          Object localObject3 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject3).setStartOffset(120L);
          ((AlphaAnimation)localObject3).setDuration(180L);
          AnimationSet localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          ((SpecailCareListActivity.ViewHolder)localObject1).h.setVisibility(0);
          ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.11(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).h.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.12(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).b.startAnimation((Animation)localObject2);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mDensity * 12.0F);
          ((TranslateAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          localAnimationSet.setAnimationListener(new SpecailCareListActivity.13(this, (SpecailCareListActivity.ViewHolder)localObject1, i3));
          ((SpecailCareListActivity.ViewHolder)localObject1).c.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 34.0F, 0.0F, this.mDensity * -12.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(300L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setAnimationListener(new SpecailCareListActivity.14(this, (SpecailCareListActivity.ViewHolder)localObject1));
          ((SpecailCareListActivity.ViewHolder)localObject1).m.startAnimation(localAnimationSet);
          localObject2 = new TranslateAnimation(0.0F, this.mDensity * 28.0F, 0.0F, 0.0F);
          ((TranslateAnimation)localObject2).setDuration(300L);
          localObject3 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject3).setDuration(240L);
          localAnimationSet = new AnimationSet(true);
          localAnimationSet.addAnimation((Animation)localObject2);
          localAnimationSet.addAnimation((Animation)localObject3);
          localAnimationSet.setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).n.startAnimation(localAnimationSet);
          localObject2 = new AlphaAnimation(0.0F, 1.0F);
          ((AlphaAnimation)localObject2).setDuration(300L);
          ((AlphaAnimation)localObject2).setFillAfter(true);
          ((SpecailCareListActivity.ViewHolder)localObject1).i.setVisibility(0);
          ((SpecailCareListActivity.ViewHolder)localObject1).i.startAnimation((Animation)localObject2);
        }
        if (i1 == i2 - 2)
        {
          localObject1 = new AlphaAnimation(1.0F, 0.0F);
          ((AlphaAnimation)localObject1).setDuration(300L);
          ((AlphaAnimation)localObject1).setAnimationListener(new SpecailCareListActivity.15(this));
          this.leftView.startAnimation((Animation)localObject1);
          this.f.startAnimation((Animation)localObject1);
        }
        i1 += 1;
      }
    }
    if (b.equals(localObject1)) {
      j();
    }
  }
  
  void j()
  {
    int i3 = this.h.getLastVisiblePosition();
    int i1 = this.f.getBottom();
    int i2 = this.h.getBottom();
    if (i3 == this.h.getCount() - 1)
    {
      i3 = this.q;
      if ((i1 > i3) && (i2 >= i1 - i3)) {
        this.g.setVisibility(8);
      } else {
        this.g.setVisibility(0);
      }
    }
    else
    {
      this.g.setVisibility(0);
    }
    i2 = this.h.getChildCount();
    i1 = 0;
    while (i1 < i2)
    {
      Object localObject2 = this.h.getChildAt(i1);
      Object localObject1 = ((View)localObject2).getTag();
      if ((localObject1 != null) && ((localObject1 instanceof SpecailCareListActivity.ViewHolder)))
      {
        localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
        i3 = a((View)localObject2, (SpecailCareListActivity.ViewHolder)localObject1, false);
        localObject2 = new TranslateAnimation(0.0F, -(this.mDensity * 34.0F), 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        Object localObject3 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject3).setDuration(180L);
        Object localObject4 = new AnimationSet(true);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
        ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.16(this, (SpecailCareListActivity.ViewHolder)localObject1));
        ((SpecailCareListActivity.ViewHolder)localObject1).h.startAnimation((Animation)localObject4);
        localObject2 = new TranslateAnimation(0.0F, -(this.mDensity * 34.0F), 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        ((TranslateAnimation)localObject2).setAnimationListener(new SpecailCareListActivity.17(this, (SpecailCareListActivity.ViewHolder)localObject1));
        ((SpecailCareListActivity.ViewHolder)localObject1).b.startAnimation((Animation)localObject2);
        localObject2 = new TranslateAnimation(0.0F, this.mDensity * -34.0F, 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mDensity * -12.0F);
        ((TranslateAnimation)localObject3).setDuration(300L);
        localObject4 = new AnimationSet(true);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
        ((AnimationSet)localObject4).setFillAfter(true);
        ((AnimationSet)localObject4).setAnimationListener(new SpecailCareListActivity.18(this, (SpecailCareListActivity.ViewHolder)localObject1, i3));
        ((SpecailCareListActivity.ViewHolder)localObject1).c.startAnimation((Animation)localObject4);
        localObject2 = new TranslateAnimation(0.0F, this.mDensity * -34.0F, 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        localObject3 = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.mDensity * 12.0F);
        ((TranslateAnimation)localObject3).setDuration(300L);
        localObject4 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject4).setDuration(300L);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation((Animation)localObject3);
        localAnimationSet.addAnimation((Animation)localObject4);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setAnimationListener(new SpecailCareListActivity.19(this, (SpecailCareListActivity.ViewHolder)localObject1));
        ((SpecailCareListActivity.ViewHolder)localObject1).m.startAnimation(localAnimationSet);
        localObject2 = new TranslateAnimation(this.mDensity * 24.0F, 0.0F, 0.0F, 0.0F);
        ((TranslateAnimation)localObject2).setDuration(300L);
        ((TranslateAnimation)localObject2).setFillAfter(true);
        localObject3 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject3).setStartOffset(60L);
        ((AlphaAnimation)localObject3).setDuration(240L);
        localObject4 = new AnimationSet(true);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject2);
        ((AnimationSet)localObject4).addAnimation((Animation)localObject3);
        ((AnimationSet)localObject4).setFillAfter(true);
        ((SpecailCareListActivity.ViewHolder)localObject1).n.startAnimation((Animation)localObject4);
        localObject2 = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject2).setDuration(300L);
        ((AlphaAnimation)localObject2).setFillAfter(true);
        ((SpecailCareListActivity.ViewHolder)localObject1).i.startAnimation((Animation)localObject2);
      }
      if (i1 == i2 - 2)
      {
        localObject1 = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject1).setDuration(300L);
        ((AlphaAnimation)localObject1).setAnimationListener(new SpecailCareListActivity.20(this));
        this.leftView.startAnimation((Animation)localObject1);
        this.f.startAnimation((Animation)localObject1);
      }
      i1 += 1;
    }
  }
  
  protected boolean onBackEvent()
  {
    if (this.z)
    {
      this.z = false;
      j();
      return true;
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    boolean bool = paramView instanceof ImageView;
    int i1 = 0;
    Object localObject1;
    Object localObject2;
    if ((bool) && (paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      localObject1 = (String)paramView.getTag();
      if (!StringUtil.isEmpty((String)localObject1))
      {
        ReportController.b(this.app, "CliOper", "", "", "0X80050E1", "0X80050E1", 0, 0, "", "", "", "");
        if (NetworkUtil.isNetSupport(this))
        {
          localObject2 = (FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
          this.J = new String[] { localObject1 };
          ((FriendListHandler)localObject2).setSpecialCareSwitch(1, this.J, new boolean[] { false });
          this.A.sendEmptyMessage(2002);
        }
        else
        {
          QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
        }
      }
    }
    else
    {
      switch (paramView.getId())
      {
      default: 
        localObject1 = paramView.getTag();
        if (localObject1 != null) {
          if ((localObject1 instanceof SpecailCareListActivity.ViewHolder)) {
            break;
          }
        }
        break;
      case 2131436801: 
        f();
        break;
      case 2131436211: 
        if (this.m != null)
        {
          d();
          ReportController.b(this.app, "CliOper", "", "", "0X80050DE", "0X80050DE", 0, 0, "", "", "", "");
        }
        else
        {
          i();
        }
        break;
      case 2131432494: 
        ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
        localObject1 = new Intent(this, ForwardFriendListActivity.class);
        ((Intent)localObject1).putExtra("extra_choose_friend", 1);
        ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
        startActivity((Intent)localObject1);
        overridePendingTransition(2130771996, 2130771994);
        break;
      case 2131427764: 
        if (!NetworkUtil.isNetSupport(this))
        {
          QQToast.makeText(this, getString(2131889169), 0).show(getTitleBarHeight());
          if (QLog.isColorLevel()) {
            QLog.i("SpecailCareListActivity", 2, "No Network!");
          }
        }
        else
        {
          localObject1 = this.s.getCheckedFriends();
          localObject2 = new boolean[localObject1.length];
          String[] arrayOfString = new String[localObject1.length];
          this.J = new String[arrayOfString.length];
          while (i1 < localObject1.length)
          {
            localObject2[i1] = 1;
            arrayOfString[i1] = String.valueOf(localObject1[i1]);
            this.J[i1] = arrayOfString[i1];
            i1 += 1;
          }
          g();
          if (QLog.isColorLevel()) {
            QLog.d("SpecailCareListActivity", 2, "setSpecialCareSwitch  start...");
          }
          this.v.setSpecialCareSwitch(1, arrayOfString, (boolean[])localObject2);
          ReportController.b(this.app, "CliOper", "", "", "0X80050DD", "0X80050DD", 0, 0, String.valueOf(localObject1.length), "", "", "");
          break label708;
          localObject1 = (SpecailCareListActivity.ViewHolder)localObject1;
          localObject2 = ((SpecailCareListActivity.ViewHolder)localObject1).o;
          localObject2 = new Intent(this, QQSpecialCareSettingActivity.class);
          ((Intent)localObject2).putExtra("key_friend_uin", ((SpecailCareListActivity.ViewHolder)localObject1).a);
          ((Intent)localObject2).putExtra("key_start_from", 5);
          startActivity((Intent)localObject2);
          break label708;
          ReportController.b(this.app, "CliOper", "", "", "0X80050D9", "0X80050D9", 0, 0, "", "", "", "");
          localObject1 = new Intent(this, ForwardFriendListActivity.class);
          ((Intent)localObject1).putExtra("extra_choose_friend", 1);
          ((Intent)localObject1).putExtra("extra_add_special_friend", 2);
          startActivity((Intent)localObject1);
          overridePendingTransition(2130771996, 2130771994);
        }
        break;
      }
    }
    label708:
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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",avatar= ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("SpecailCareListActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBitmap != null)
    {
      if (this.p.isPausing()) {
        return;
      }
      if (this.E != 0)
      {
        this.y = true;
        return;
      }
      paramInt2 = this.h.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localObject = this.h.getChildAt(paramInt1);
        if (localObject != null)
        {
          localObject = (SpecailCareListActivity.ViewHolder)((View)localObject).getTag();
          if ((localObject != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(((SpecailCareListActivity.ViewHolder)localObject).o.uin)))
          {
            ((SpecailCareListActivity.ViewHolder)localObject).b.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
            return;
          }
        }
        paramInt1 += 1;
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.F = paramInt3;
    if (this.u.size() > 0)
    {
      if (paramAbsListView == null) {
        return;
      }
      if (this.z)
      {
        this.g.setVisibility(8);
        return;
      }
      int i1 = this.f.getBottom();
      int i2 = paramAbsListView.getBottom();
      if (QLog.isColorLevel())
      {
        paramAbsListView = new StringBuilder();
        paramAbsListView.append("onScroll.firstVisibleItem=");
        paramAbsListView.append(paramInt1);
        paramAbsListView.append(", visibleItemCount=");
        paramAbsListView.append(paramInt2);
        paramAbsListView.append(",totalItemCount=");
        paramAbsListView.append(paramInt3);
        paramAbsListView.append(",addBtnBottom=");
        paramAbsListView.append(i1);
        paramAbsListView.append(",listviewBottom=");
        paramAbsListView.append(i2);
        paramAbsListView.append(",mBottomBtnBottomMargin=");
        paramAbsListView.append(this.q);
        QLog.d("SpecailCareListActivity", 2, paramAbsListView.toString());
      }
      if (paramInt1 + paramInt2 == paramInt3)
      {
        paramInt1 = this.q;
        if ((i1 > paramInt1) && (i2 >= i1 - paramInt1))
        {
          this.g.setVisibility(8);
          return;
        }
        this.g.setVisibility(0);
        return;
      }
      this.g.setVisibility(0);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.E = paramInt;
    boolean bool = this.y;
    int i1 = 0;
    if ((bool) && (paramInt == 0))
    {
      this.o.notifyDataSetChanged();
      this.y = false;
      return;
    }
    if (paramInt == 0)
    {
      int i2 = this.h.getChildCount();
      paramInt = i1;
      while (paramInt < i2)
      {
        paramAbsListView = (SpecailCareListActivity.ViewHolder)this.h.getChildAt(paramInt).getTag();
        if ((paramAbsListView != null) && (paramAbsListView.a != null) && (paramAbsListView.a.length() > 0)) {
          a(paramAbsListView.o, paramAbsListView);
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity
 * JD-Core Version:    0.7.0.1
 */