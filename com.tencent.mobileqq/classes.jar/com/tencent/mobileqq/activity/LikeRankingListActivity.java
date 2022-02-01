package com.tencent.mobileqq.activity;

import Override;
import aewp;
import aewq;
import aewr;
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
import anum;
import anuw;
import anyw;
import aobc;
import aoof;
import aoog;
import azxs;
import azxy;
import bdll;
import bhhz;
import bhmq;
import bhzq;
import blgu;
import blhq;
import blih;
import bljm;
import bmst;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;

public class LikeRankingListActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener, aoog, blih, bljm
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public aewr a;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  View jdField_a_of_type_AndroidViewView;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  anum jdField_a_of_type_Anum;
  anuw jdField_a_of_type_Anuw = new aewq(this);
  public anyw a;
  public aobc a;
  public aoof a;
  blhq jdField_a_of_type_Blhq = new blhq(this);
  public Card a;
  public LikeRankingInfo a;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new aewp(this);
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  PullToZoomListView jdField_a_of_type_ComTencentWidgetPullToZoomListView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 0;
  ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  View jdField_b_of_type_AndroidViewView;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  int e;
  public View e;
  int jdField_f_of_type_Int = 0;
  private View jdField_f_of_type_AndroidViewView;
  int g = 1;
  
  public LikeRankingListActivity()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850668);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838891);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_Blhq.post(new LikeRankingListActivity.5(this, paramCard));
    if (blgu.a(this.app, paramCard)) {
      if (!blgu.b(this.app, paramCard)) {
        if ((paramCard.lCurrentBgId == 1600L) || (paramCard.lCurrentBgId == 160L) || (azxy.a(paramCard.lCurrentStyleId)))
        {
          blgu.c(this.app, paramCard);
          b(paramCard);
        }
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
        ((bhzq)this.app.getManager(235)).a.a(this.app, "card." + paramCard.lCurrentBgId);
        return;
        b(paramCard);
        return;
        localObject = paramCard.getCoverData(this.jdField_f_of_type_Int);
        paramCard = (String)localObject[0];
        localObject = (Integer)localObject[1];
        if (!TextUtils.isEmpty(paramCard)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.e("LikeRankingListActivity", 2, "[updateCover] url is null");
        }
      } while ((this.jdField_c_of_type_JavaLangString != null) || (this.jdField_f_of_type_Int != 0));
      this.jdField_c_of_type_JavaLangString = paramCard;
      this.jdField_f_of_type_Int = ((Integer)localObject).intValue();
      this.jdField_a_of_type_Blhq.post(new LikeRankingListActivity.6(this));
      return;
    } while (paramCard.equals(this.jdField_c_of_type_JavaLangString));
    if ((((Integer)localObject).intValue() == 0) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_f_of_type_Int == 0) && (QLog.isColorLevel())) {
      QLog.d("LikeRankingListActivity", 2, "[updateCover] default");
    }
    this.jdField_c_of_type_JavaLangString = paramCard;
    this.jdField_f_of_type_Int = ((Integer)localObject).intValue();
    this.jdField_a_of_type_Blhq.post(new LikeRankingListActivity.7(this));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_b_of_type_JavaLangString != null) && (this.jdField_b_of_type_JavaLangString.equals(paramString))) {
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = null;
    if (paramString == null)
    {
      this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.a(false);
      this.jdField_b_of_type_AndroidWidgetImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      this.jdField_c_of_type_AndroidViewView.setVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setVisibility(4);
      this.jdField_d_of_type_AndroidViewView.setVisibility(4);
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_f_of_type_Int = 0;
      a(true);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.a(true);
    Bitmap localBitmap2 = this.jdField_a_of_type_Aoof.a(1, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_Aoof.a()) {
        this.jdField_a_of_type_Aoof.a(paramString, 1, true);
      }
      localBitmap1 = bhmq.a();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap1);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.g = 1;
    this.app.a(new LikeRankingListActivity.4(this, paramString));
  }
  
  public void b(Card paramCard)
  {
    Object localObject = null;
    if ((this.jdField_c_of_type_JavaLangString != null) && (this.jdField_c_of_type_JavaLangString.equals(paramCard.backgroundUrl))) {}
    String str;
    label195:
    do
    {
      return;
      this.jdField_f_of_type_Int = 0;
      this.jdField_c_of_type_JavaLangString = paramCard.backgroundUrl;
      if ((paramCard.lCurrentBgId == 160L) || (paramCard.lCurrentBgId == 1600L))
      {
        str = bhhz.a(this.app.getApp(), paramCard.strDrawerCardUrl);
        if (QLog.isColorLevel()) {
          QLog.d("LikeRankingListActivity", 2, "updateCoverCard type personal card, path" + str);
        }
        paramCard = BaseApplicationImpl.sImageCache.get(str + "#rank");
        if (!Bitmap.class.isInstance(paramCard)) {
          break label195;
        }
        localObject = (Bitmap)paramCard;
      }
      for (;;)
      {
        if (localObject == null) {
          break label264;
        }
        this.jdField_a_of_type_Blhq.postDelayed(new LikeRankingListActivity.8(this, (Bitmap)localObject), 100L);
        return;
        str = azxs.b(this.app.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId);
        break;
        paramCard = (Card)localObject;
        try
        {
          localObject = bhmq.a(str, null);
          paramCard = (Card)localObject;
          BaseApplicationImpl.sImageCache.put(str + "#rank", localObject);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject = paramCard;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, localOutOfMemoryError, new Object[0]);
          localObject = paramCard;
        }
      }
    } while (!QLog.isColorLevel());
    label264:
    QLog.e("LikeRankingListActivity", 2, "updateCoverCard type personal card bitmap = null, path" + str);
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
    setContentView(2131561272);
    if (getIntent().getIntExtra("param_from", 0) == 1) {
      this.app.reportClickEvent("dc00898", "0X8007619");
    }
    this.jdField_a_of_type_Aobc = ((aobc)this.app.getManager(186));
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = this.jdField_a_of_type_Aobc.a();
    this.jdField_a_of_type_Anyw = ((anyw)this.app.getManager(51));
    this.jdField_a_of_type_Aoof = new aoof(this, this.app);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_Anum = ((anum)this.app.a(2));
    addObserver(this.jdField_a_of_type_Anuw);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131379037));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378967);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369042));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369088));
    paramBundle = getResources();
    this.jdField_a_of_type_AndroidContentResColorStateList = paramBundle.getColorStateList(2131165370);
    this.jdField_b_of_type_AndroidContentResColorStateList = paramBundle.getColorStateList(2131166987);
    findViewById(2131369042).setOnClickListener(this);
    this.jdField_d_of_type_Int = bhhz.c(this);
    this.jdField_e_of_type_Int = bhhz.d(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView = ((PullToZoomListView)findViewById(2131370438));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOverScrollDistance(0);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561273, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369185));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.jdField_b_of_type_AndroidViewView.findViewById(2131369187));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(0, 2131167247, 100, 16763714);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(100.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365167);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369184));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379767));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369159);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379726);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setHeaderImage(this.jdField_f_of_type_AndroidViewView);
    this.jdField_a_of_type_Aewr = new aewr(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setAdapter(this.jdField_a_of_type_Aewr);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnItemClickListener(this);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366047);
    DisplayMetrics localDisplayMetrics = paramBundle.getDisplayMetrics();
    int i = paramBundle.getDimensionPixelSize(2131299011);
    this.jdField_c_of_type_Int = (paramBundle.getDimensionPixelSize(2131297499) - i - (int)(localDisplayMetrics.density * 66.0F));
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setDuration(300L);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setInterpolator(this, 17432581);
    this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation.setAnimationListener(this);
    if ((this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum == 1) && (this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday > 0)) {
      a(this.jdField_a_of_type_JavaLangString);
    }
    paramBundle = this.jdField_a_of_type_Aobc.a();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      a(String.valueOf(((LikeRankingInfo)paramBundle.get(0)).uin));
      this.jdField_a_of_type_Aewr.a(paramBundle, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aewr.a = true;
      this.jdField_a_of_type_Aewr.notifyDataSetChanged();
      this.jdField_a_of_type_Anum.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 500);
      ThreadManager.post(new LikeRankingListActivity.3(this), 5, null, false);
      ((VasQuickUpdateManager)this.app.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      return true;
      a(null);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Anuw);
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    bmst.a(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Aewr.notifyDataSetChanged();
    return true;
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation) {
      a(false);
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation) {
      a(true);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      String str2 = "2";
      String str1 = str2;
      if (this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo != null)
      {
        str1 = str2;
        if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
          str1 = "1";
        }
      }
      bdll.b(this.app, "dc00898", "", "", "0X8007615", "0X8007615", 0, 0, str1, "", "", "");
      ProfileActivity.b(this, new ProfileActivity.AllInOne(this.jdField_b_of_type_JavaLangString, 1));
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
      QLog.d("LikeRankingListActivity", 2, "onDecodeTaskCompleted, remainingTasks= " + paramInt1 + " ,type= " + paramInt2 + ", uin= " + paramString + ", avatar= " + paramBitmap);
    }
    if (paramString.equals(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Blhq.removeMessages(1);
    if (l >= 800L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Aewr.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Blhq.sendEmptyMessageDelayed(1, 800L - l);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      paramInt -= 1;
    } while ((this.jdField_a_of_type_Int != -1) && (paramInt == this.jdField_a_of_type_Aewr.getCount() - 1));
    if (paramInt == -1)
    {
      paramAdapterView = this.jdField_b_of_type_JavaLangString;
      label40:
      if (!TextUtils.isEmpty(paramAdapterView))
      {
        String str = "2";
        paramView = str;
        if (this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo != null)
        {
          paramView = str;
          if (this.jdField_a_of_type_JavaLangString.equals(paramAdapterView)) {
            paramView = "1";
          }
        }
        bdll.b(this.app, "dc00898", "", "", "0X8007616", "0X8007616", 0, 0, paramView, "", "", "");
        ProfileActivity.b(this, new ProfileActivity.AllInOne(paramAdapterView, 1));
      }
    }
    else
    {
      paramAdapterView = this.jdField_a_of_type_Aewr.a(paramInt);
      if (paramAdapterView != null) {
        break label148;
      }
    }
    label148:
    for (paramAdapterView = "";; paramAdapterView = String.valueOf(paramAdapterView.uin))
    {
      break label40;
      break;
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramAbsListView = this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.getChildAt(0);
    Object localObject;
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      paramInt1 = Math.abs(paramAbsListView.getTop());
      localObject = null;
      if ((paramInt1 <= this.jdField_b_of_type_Int) || (paramInt1 < this.jdField_c_of_type_Int) || (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
        break label102;
      }
      paramAbsListView = this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
    }
    for (;;)
    {
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_AndroidViewView.getAnimation()))
      {
        paramAbsListView.reset();
        this.jdField_a_of_type_AndroidViewView.startAnimation(paramAbsListView);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
      }
      this.jdField_b_of_type_Int = paramInt1;
      return;
      label102:
      paramAbsListView = localObject;
      if (paramInt1 < this.jdField_b_of_type_Int)
      {
        paramAbsListView = localObject;
        if (paramInt1 <= this.jdField_c_of_type_Int)
        {
          paramAbsListView = localObject;
          if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0) {
            paramAbsListView = this.jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity
 * JD-Core Version:    0.7.0.1
 */