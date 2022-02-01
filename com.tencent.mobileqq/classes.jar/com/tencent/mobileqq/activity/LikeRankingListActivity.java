package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.LikeRankingListManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.profile.ProfileCardManager;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.DrawerCoverUtil;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import cooperation.qzone.LeakUtil;
import java.util.List;

public class LikeRankingListActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener, AdapterView.OnItemClickListener
{
  long A = 0L;
  int B;
  int C;
  String D;
  int E = 0;
  int F = 1;
  Card G;
  CallBacker H = new LikeRankingListActivity.1(this);
  AlphaAnimation I;
  AlphaAnimation J;
  CardObserver K = new LikeRankingListActivity.2(this);
  ProfileCardObserver L = new LikeRankingListActivity.3(this);
  WeakReferenceHandler M = new WeakReferenceHandler(this);
  private View N;
  LikeRankingListManager a;
  FriendsManager b;
  IFaceDecoder c;
  CardHandler d;
  int e = 0;
  String f;
  String g;
  LikeRankingInfo h;
  ImmersiveTitleBar2 i;
  View j;
  TextView k;
  TextView l;
  PullToZoomListView m;
  LikeRankingListActivity.LikeRankingListAdapter n;
  View o;
  ImageView p;
  ImageView q;
  CircleProgress r;
  TextView s;
  View t;
  View u;
  View v;
  ColorStateList w;
  ColorStateList x;
  int y = 0;
  int z;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    ((CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(str, paramString, 1, 0L, (byte)1, 0L, 0L, null, "", 8225L, 3022, null, (byte)SharedPreUtils.am(BaseApplicationImpl.getApplication(), paramQQAppInterface.getCurrentAccountUin()));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.setVisibility(0);
      this.j.setVisibility(0);
      this.k.setBackgroundResource(2130853297);
      this.k.setTextColor(this.x);
      this.l.setTextColor(this.x);
      return;
    }
    this.i.setVisibility(4);
    this.j.setVisibility(8);
    this.k.setBackgroundResource(2130838989);
    this.k.setTextColor(this.w);
    this.l.setTextColor(this.w);
  }
  
  void a(Card paramCard)
  {
    this.M.post(new LikeRankingListActivity.6(this, paramCard));
    if (DrawerCoverUtil.a(this.app, paramCard))
    {
      if (!DrawerCoverUtil.b(this.app, paramCard))
      {
        if ((paramCard.lCurrentBgId != 1600L) && (paramCard.lCurrentBgId != 160L) && (!ProfileTemplateApi.isDiyTemplateStyleID(paramCard.lCurrentStyleId)))
        {
          this.G = paramCard;
          localObject = ((VasExtensionManager)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).e;
          QQAppInterface localQQAppInterface = this.app;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("card.");
          localStringBuilder.append(paramCard.lCurrentBgId);
          ((ProfileCardManager)localObject).a(localQQAppInterface, localStringBuilder.toString());
          return;
        }
        DrawerCoverUtil.c(this.app, paramCard);
        b(paramCard);
        return;
      }
      b(paramCard);
      return;
    }
    Object localObject = paramCard.getCoverData(this.E);
    paramCard = (String)localObject[0];
    localObject = (Integer)localObject[1];
    if (TextUtils.isEmpty(paramCard))
    {
      if (QLog.isColorLevel()) {
        QLog.e("LikeRankingListActivity", 2, "[updateCover] url is null");
      }
      if ((this.D == null) && (this.E == 0))
      {
        this.D = paramCard;
        this.E = ((Integer)localObject).intValue();
        this.M.post(new LikeRankingListActivity.7(this));
      }
      return;
    }
    if (paramCard.equals(this.D)) {
      return;
    }
    if ((((Integer)localObject).intValue() == 0) && (!TextUtils.isEmpty(this.D)) && (this.E == 0) && (QLog.isColorLevel())) {
      QLog.d("LikeRankingListActivity", 2, "[updateCover] default");
    }
    this.D = paramCard;
    this.E = ((Integer)localObject).intValue();
    this.M.post(new LikeRankingListActivity.8(this));
  }
  
  void a(String paramString)
  {
    Object localObject = this.g;
    if ((localObject != null) && (((String)localObject).equals(paramString))) {
      return;
    }
    this.g = paramString;
    this.E = 0;
    this.D = null;
    if (paramString == null)
    {
      this.m.a(false);
      this.q.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.p.setVisibility(4);
      this.s.setVisibility(4);
      this.t.setVisibility(4);
      this.r.setVisibility(4);
      this.u.setVisibility(4);
      this.D = null;
      this.E = 0;
      a(true);
      return;
    }
    this.m.a(true);
    Bitmap localBitmap = this.c.getBitmapFromCache(1, paramString);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      if (!this.c.isPausing()) {
        this.c.requestDecodeFace(paramString, 1, true);
      }
      localObject = ImageUtil.k();
    }
    this.p.setImageBitmap((Bitmap)localObject);
    this.p.setVisibility(0);
    this.F = 1;
    this.app.execute(new LikeRankingListActivity.5(this, paramString));
  }
  
  public void b(Card paramCard)
  {
    Object localObject = this.D;
    if ((localObject != null) && (((String)localObject).equals(paramCard.backgroundUrl))) {
      return;
    }
    this.E = 0;
    this.D = paramCard.backgroundUrl;
    String str;
    if ((paramCard.lCurrentBgId != 160L) && (paramCard.lCurrentBgId != 1600L)) {
      str = ProfileCardManager.b(this.app.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId);
    } else {
      str = ProfileCardUtil.c(paramCard.strDrawerCardUrl);
    }
    if (QLog.isColorLevel())
    {
      paramCard = new StringBuilder();
      paramCard.append("updateCoverCard type personal card, path");
      paramCard.append(str);
      QLog.d("LikeRankingListActivity", 2, paramCard.toString());
    }
    paramCard = GlobalImageCache.a;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append("#rank");
    paramCard = paramCard.get(((StringBuilder)localObject).toString());
    if (Bitmap.class.isInstance(paramCard))
    {
      localObject = (Bitmap)paramCard;
    }
    else
    {
      paramCard = null;
      try
      {
        localObject = ImageUtil.a(str, null);
        paramCard = (Card)localObject;
        MQLruCache localMQLruCache = GlobalImageCache.a;
        paramCard = (Card)localObject;
        StringBuilder localStringBuilder = new StringBuilder();
        paramCard = (Card)localObject;
        localStringBuilder.append(str);
        paramCard = (Card)localObject;
        localStringBuilder.append("#rank");
        paramCard = (Card)localObject;
        localMQLruCache.put(localStringBuilder.toString(), localObject);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject = paramCard;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, localOutOfMemoryError, new Object[0]);
          localObject = paramCard;
        }
      }
    }
    if (localObject != null)
    {
      this.M.postDelayed(new LikeRankingListActivity.9(this, (Bitmap)localObject), 100L);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramCard = new StringBuilder();
      paramCard.append("updateCoverCard type personal card bitmap = null, path");
      paramCard.append(str);
      QLog.e("LikeRankingListActivity", 2, paramCard.toString());
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
    setContentView(2131627502);
    if (getIntent().getIntExtra("param_from", 0) == 1) {
      ReportController.b(this.app, "dc00898", "", "", "0X8007619", "0X8007619", 0, 0, "", "", "", "");
    }
    this.a = ((LikeRankingListManager)this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER));
    this.h = this.a.b();
    this.b = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.c = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.c.setDecodeTaskCompletionListener(this);
    this.d = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    addObserver(this.K);
    addObserver(this.L);
    this.f = this.app.getCurrentAccountUin();
    this.i = ((ImmersiveTitleBar2)findViewById(2131447582));
    this.i.setVisibility(4);
    this.j = findViewById(2131447496);
    this.k = ((TextView)findViewById(2131436180));
    this.l = ((TextView)findViewById(2131436227));
    paramBundle = getResources();
    this.w = paramBundle.getColorStateList(2131165594);
    this.x = paramBundle.getColorStateList(2131167990);
    findViewById(2131436180).setOnClickListener(this);
    this.B = ProfileCardUtil.c(this);
    this.C = ProfileCardUtil.d(this);
    this.m = ((PullToZoomListView)findViewById(2131437783));
    this.m.setNeedCheckSpringback(true);
    this.m.setOverScrollDistance(0);
    this.o = LayoutInflater.from(this).inflate(2131627503, null);
    this.p = ((ImageView)this.o.findViewById(2131436335));
    this.r = ((CircleProgress)this.o.findViewById(2131436337));
    this.r.setStrokeWidth(2.0F);
    this.r.setBgAndProgressColor(0, 2131168376, 100, 16763714);
    this.r.setProgress(100.0F);
    this.p.setOnClickListener(this);
    this.N = this.o.findViewById(2131431467);
    this.q = ((ImageView)this.o.findViewById(2131436334));
    this.s = ((TextView)this.o.findViewById(2131448363));
    this.t = this.o.findViewById(2131436306);
    this.u = this.o.findViewById(2131448319);
    this.m.addHeaderView(this.o);
    this.m.setHeaderImage(this.N);
    this.n = new LikeRankingListActivity.LikeRankingListAdapter(this);
    this.m.setAdapter(this.n);
    this.m.setOnScrollListener(this);
    this.m.setOnItemClickListener(this);
    this.v = findViewById(2131432529);
    DisplayMetrics localDisplayMetrics = paramBundle.getDisplayMetrics();
    int i1 = paramBundle.getDimensionPixelSize(2131299920);
    this.z = (paramBundle.getDimensionPixelSize(2131298277) - i1 - (int)(localDisplayMetrics.density * 66.0F));
    this.I = new AlphaAnimation(0.0F, 1.0F);
    this.I.setDuration(300L);
    this.I.setInterpolator(this, 17432581);
    this.I.setAnimationListener(this);
    this.J = new AlphaAnimation(1.0F, 0.0F);
    this.J.setDuration(300L);
    this.J.setInterpolator(this, 17432581);
    this.J.setAnimationListener(this);
    if ((this.h.rankingNum == 1) && (this.h.likeCountOfToday > 0)) {
      a(this.f);
    }
    paramBundle = this.a.a();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      a(String.valueOf(((LikeRankingInfo)paramBundle.get(0)).uin));
      this.n.a(paramBundle, false);
    }
    else
    {
      a(null);
    }
    paramBundle = this.n;
    paramBundle.b = true;
    paramBundle.notifyDataSetChanged();
    this.d.a(this.f, this.e, 500);
    ThreadManager.post(new LikeRankingListActivity.4(this), 5, null, false);
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.H);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.K);
    removeObserver(this.L);
    IFaceDecoder localIFaceDecoder = this.c;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.H);
    LeakUtil.removeLeakOn_SpenGestureManager(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    this.A = SystemClock.uptimeMillis();
    this.n.notifyDataSetChanged();
    return true;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.J) {
      a(false);
    }
    this.i.clearAnimation();
    this.j.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.I) {
      a(true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436180)
    {
      if (i1 == 2131436335)
      {
        String str;
        if ((this.h != null) && (this.f.equals(this.g))) {
          str = "1";
        } else {
          str = "2";
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8007615", "0X8007615", 0, 0, str, "", "", "");
        ProfileUtils.openProfileCard(this, new AllInOne(this.g, 1));
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
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDecodeTaskCompleted, remainingTasks= ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" ,type= ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", uin= ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", avatar= ");
      localStringBuilder.append(paramBitmap);
      QLog.d("LikeRankingListActivity", 2, localStringBuilder.toString());
    }
    if (paramString.equals(this.g)) {
      this.p.setImageBitmap(paramBitmap);
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l1 = SystemClock.uptimeMillis() - this.A;
    this.M.removeMessages(1);
    if (l1 >= 800L)
    {
      this.A = SystemClock.uptimeMillis();
      this.n.notifyDataSetChanged();
      return;
    }
    this.M.sendEmptyMessageDelayed(1, 800L - l1);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      return;
    }
    paramInt -= 1;
    if ((this.e != -1) && (paramInt == this.n.getCount() - 1)) {
      return;
    }
    if (paramInt == -1)
    {
      paramAdapterView = this.g;
    }
    else
    {
      paramAdapterView = this.n.a(paramInt);
      if (paramAdapterView == null) {
        paramAdapterView = "";
      } else {
        paramAdapterView = String.valueOf(paramAdapterView.uin);
      }
    }
    if (!TextUtils.isEmpty(paramAdapterView))
    {
      if ((this.h != null) && (this.f.equals(paramAdapterView))) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      ReportController.b(this.app, "dc00898", "", "", "0X8007616", "0X8007616", 0, 0, paramView, "", "", "");
      ProfileUtils.openProfileCard(this, new AllInOne(paramAdapterView, 1));
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.m.getChildAt(0);
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      paramInt1 = Math.abs(paramAbsListView.getTop());
      Object localObject = null;
      if ((paramInt1 > this.y) && (paramInt1 >= this.z) && (this.j.getVisibility() == 8))
      {
        paramAbsListView = this.I;
      }
      else
      {
        paramAbsListView = localObject;
        if (paramInt1 < this.y)
        {
          paramAbsListView = localObject;
          if (paramInt1 <= this.z)
          {
            paramAbsListView = localObject;
            if (this.j.getVisibility() == 0) {
              paramAbsListView = this.J;
            }
          }
        }
      }
      if ((paramAbsListView != null) && (paramAbsListView != this.j.getAnimation()))
      {
        paramAbsListView.reset();
        this.j.startAnimation(paramAbsListView);
        this.i.startAnimation(paramAbsListView);
      }
      this.y = paramInt1;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity
 * JD-Core Version:    0.7.0.1
 */