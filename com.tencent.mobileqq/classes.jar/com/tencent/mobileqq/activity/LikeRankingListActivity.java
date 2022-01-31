package com.tencent.mobileqq.activity;

import adgw;
import adgx;
import adgy;
import alpk;
import alpq;
import alto;
import alvt;
import android.content.Intent;
import android.content.res.ColorStateList;
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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import awqu;
import awra;
import azqs;
import bdbb;
import bdbc;
import bddf;
import bdhj;
import bduj;
import bhsg;
import bhtd;
import bhtv;
import bhuw;
import bjdj;
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
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.PullToZoomListView;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.List;

public class LikeRankingListActivity
  extends BaseActivity
  implements Handler.Callback, View.OnClickListener, Animation.AnimationListener, bdbc, bhtv, bhuw
{
  public int a;
  long jdField_a_of_type_Long = 0L;
  public adgy a;
  alpk jdField_a_of_type_Alpk;
  alpq jdField_a_of_type_Alpq = new adgx(this);
  public alto a;
  public alvt a;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  View jdField_a_of_type_AndroidViewView;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public bdbb a;
  bhtd jdField_a_of_type_Bhtd = new bhtd(this);
  public Card a;
  public LikeRankingInfo a;
  VasQuickUpdateManager.CallBacker jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new adgw(this);
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
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130850060);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838628);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_Bhtd.post(new LikeRankingListActivity.5(this, paramCard));
    if (bhsg.a(this.app, paramCard)) {
      if (!bhsg.b(this.app, paramCard)) {
        if ((paramCard.lCurrentBgId == 1600L) || (paramCard.lCurrentBgId == 160L) || (awra.a(paramCard.lCurrentStyleId)))
        {
          bhsg.c(this.app, paramCard);
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
        ((bduj)this.app.getManager(235)).a.a(this.app, "card." + paramCard.lCurrentBgId);
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
      this.jdField_a_of_type_Bhtd.post(new LikeRankingListActivity.6(this));
      return;
    } while (paramCard.equals(this.jdField_c_of_type_JavaLangString));
    if ((((Integer)localObject).intValue() == 0) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_f_of_type_Int == 0) && (QLog.isColorLevel())) {
      QLog.d("LikeRankingListActivity", 2, "[updateCover] default");
    }
    this.jdField_c_of_type_JavaLangString = paramCard;
    this.jdField_f_of_type_Int = ((Integer)localObject).intValue();
    this.jdField_a_of_type_Bhtd.post(new LikeRankingListActivity.7(this));
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
    Bitmap localBitmap2 = this.jdField_a_of_type_Bdbb.a(1, paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      if (!this.jdField_a_of_type_Bdbb.a()) {
        this.jdField_a_of_type_Bdbb.a(paramString, 1, true);
      }
      localBitmap1 = bdhj.a();
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
        str = bddf.a(this.app.getApp(), paramCard.strDrawerCardUrl);
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
        this.jdField_a_of_type_Bhtd.postDelayed(new LikeRankingListActivity.8(this, (Bitmap)localObject), 100L);
        return;
        str = awqu.b(this.app.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId);
        break;
        paramCard = (Card)localObject;
        try
        {
          localObject = bdhj.a(str, null);
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mActNeedImmersive = false;
    super.doOnCreate(paramBundle);
    setContentView(2131561020);
    if (getIntent().getIntExtra("param_from", 0) == 1) {
      this.app.reportClickEvent("dc00898", "0X8007619");
    }
    this.jdField_a_of_type_Alvt = ((alvt)this.app.getManager(186));
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = this.jdField_a_of_type_Alvt.a();
    this.jdField_a_of_type_Alto = ((alto)this.app.getManager(51));
    this.jdField_a_of_type_Bdbb = new bdbb(this, this.app);
    this.jdField_a_of_type_Bdbb.a(this);
    this.jdField_a_of_type_Alpk = ((alpk)this.app.a(2));
    addObserver(this.jdField_a_of_type_Alpq);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131378030));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131377967);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368624));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368670));
    paramBundle = getResources();
    this.jdField_a_of_type_AndroidContentResColorStateList = paramBundle.getColorStateList(2131165335);
    this.jdField_b_of_type_AndroidContentResColorStateList = paramBundle.getColorStateList(2131166900);
    findViewById(2131368624).setOnClickListener(this);
    this.jdField_d_of_type_Int = bddf.c(this);
    this.jdField_e_of_type_Int = bddf.d(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView = ((PullToZoomListView)findViewById(2131369894));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOverScrollDistance(0);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561021, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368754));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.jdField_b_of_type_AndroidViewView.findViewById(2131368755));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(0, 2131167140, 100, 16763714);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(100.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131364888);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131368753));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131378728));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131368732);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131378692);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setHeaderImage(this.jdField_f_of_type_AndroidViewView);
    this.jdField_a_of_type_Adgy = new adgy(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setAdapter(this.jdField_a_of_type_Adgy);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnItemClickListener(this);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131365760);
    DisplayMetrics localDisplayMetrics = paramBundle.getDisplayMetrics();
    int i = paramBundle.getDimensionPixelSize(2131298914);
    this.jdField_c_of_type_Int = (paramBundle.getDimensionPixelSize(2131297408) - i - (int)(localDisplayMetrics.density * 66.0F));
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
    paramBundle = this.jdField_a_of_type_Alvt.a();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      a(String.valueOf(((LikeRankingInfo)paramBundle.get(0)).uin));
      this.jdField_a_of_type_Adgy.a(paramBundle, false);
    }
    for (;;)
    {
      this.jdField_a_of_type_Adgy.a = true;
      this.jdField_a_of_type_Adgy.notifyDataSetChanged();
      this.jdField_a_of_type_Alpk.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 500);
      ThreadManager.post(new LikeRankingListActivity.3(this), 5, null, false);
      ((VasQuickUpdateManager)this.app.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
      return true;
      a(null);
    }
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_Alpq);
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
    ((VasQuickUpdateManager)this.app.getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
    bjdj.a(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Adgy.notifyDataSetChanged();
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
    default: 
      return;
    case 2131368624: 
      finish();
      return;
    }
    String str = "2";
    paramView = str;
    if (this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo != null)
    {
      paramView = str;
      if (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString)) {
        paramView = "1";
      }
    }
    azqs.b(this.app, "dc00898", "", "", "0X8007615", "0X8007615", 0, 0, paramView, "", "", "");
    ProfileActivity.b(this, new ProfileActivity.AllInOne(this.jdField_b_of_type_JavaLangString, 1));
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
    this.jdField_a_of_type_Bhtd.removeMessages(1);
    if (l >= 800L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_Adgy.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_Bhtd.sendEmptyMessageDelayed(1, 800L - l);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {}
    do
    {
      return;
      paramInt -= 1;
    } while ((this.jdField_a_of_type_Int != -1) && (paramInt == this.jdField_a_of_type_Adgy.getCount() - 1));
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
        azqs.b(this.app, "dc00898", "", "", "0X8007616", "0X8007616", 0, 0, paramView, "", "", "");
        ProfileActivity.b(this, new ProfileActivity.AllInOne(paramAdapterView, 1));
      }
    }
    else
    {
      paramAdapterView = this.jdField_a_of_type_Adgy.a(paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity
 * JD-Core Version:    0.7.0.1
 */