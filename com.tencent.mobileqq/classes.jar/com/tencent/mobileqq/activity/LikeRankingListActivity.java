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
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  View jdField_a_of_type_AndroidViewView;
  AlphaAnimation jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LikeRankingListActivity.LikeRankingListAdapter jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter;
  CardHandler jdField_a_of_type_ComTencentMobileqqAppCardHandler;
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new LikeRankingListActivity.2(this);
  FriendsManager jdField_a_of_type_ComTencentMobileqqAppFriendsManager;
  LikeRankingListManager jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  Card jdField_a_of_type_ComTencentMobileqqDataCard;
  LikeRankingInfo jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new LikeRankingListActivity.3(this);
  CallBacker jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker = new LikeRankingListActivity.1(this);
  CircleProgress jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
  PullToZoomListView jdField_a_of_type_ComTencentWidgetPullToZoomListView;
  ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  String jdField_a_of_type_JavaLangString;
  int jdField_b_of_type_Int = 0;
  ColorStateList jdField_b_of_type_AndroidContentResColorStateList;
  View jdField_b_of_type_AndroidViewView;
  AlphaAnimation jdField_b_of_type_AndroidViewAnimationAlphaAnimation;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  int jdField_c_of_type_Int;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  String jdField_c_of_type_JavaLangString;
  int jdField_d_of_type_Int;
  View jdField_d_of_type_AndroidViewView;
  int jdField_e_of_type_Int;
  View jdField_e_of_type_AndroidViewView;
  int jdField_f_of_type_Int = 0;
  private View jdField_f_of_type_AndroidViewView;
  int g = 1;
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    ((CardHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).a(str, paramString, 1, 0L, (byte)1, 0L, 0L, null, "", 8225L, 3022, null, (byte)SharedPreUtils.U(BaseApplicationImpl.getApplication(), paramQQAppInterface.getCurrentAccountUin()));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130851066);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_b_of_type_AndroidContentResColorStateList);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130838767);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentResColorStateList);
  }
  
  void a(Card paramCard)
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new LikeRankingListActivity.6(this, paramCard));
    if (DrawerCoverUtil.a(this.app, paramCard))
    {
      if (!DrawerCoverUtil.b(this.app, paramCard))
      {
        if ((paramCard.lCurrentBgId != 1600L) && (paramCard.lCurrentBgId != 160L) && (!ProfileTemplateApi.isDiyTemplateStyleID(paramCard.lCurrentStyleId)))
        {
          this.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
          localObject = ((VasExtensionManager)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
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
    Object localObject = paramCard.getCoverData(this.jdField_f_of_type_Int);
    paramCard = (String)localObject[0];
    localObject = (Integer)localObject[1];
    if (TextUtils.isEmpty(paramCard))
    {
      if (QLog.isColorLevel()) {
        QLog.e("LikeRankingListActivity", 2, "[updateCover] url is null");
      }
      if ((this.jdField_c_of_type_JavaLangString == null) && (this.jdField_f_of_type_Int == 0))
      {
        this.jdField_c_of_type_JavaLangString = paramCard;
        this.jdField_f_of_type_Int = ((Integer)localObject).intValue();
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new LikeRankingListActivity.7(this));
      }
      return;
    }
    if (paramCard.equals(this.jdField_c_of_type_JavaLangString)) {
      return;
    }
    if ((((Integer)localObject).intValue() == 0) && (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_f_of_type_Int == 0) && (QLog.isColorLevel())) {
      QLog.d("LikeRankingListActivity", 2, "[updateCover] default");
    }
    this.jdField_c_of_type_JavaLangString = paramCard;
    this.jdField_f_of_type_Int = ((Integer)localObject).intValue();
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new LikeRankingListActivity.8(this));
  }
  
  void a(String paramString)
  {
    Object localObject = this.jdField_b_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).equals(paramString))) {
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
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    localObject = localBitmap;
    if (localBitmap == null)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 1, true);
      }
      localObject = ImageUtil.f();
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.g = 1;
    this.app.execute(new LikeRankingListActivity.5(this, paramString));
  }
  
  public void b(Card paramCard)
  {
    Object localObject = this.jdField_c_of_type_JavaLangString;
    if ((localObject != null) && (((String)localObject).equals(paramCard.backgroundUrl))) {
      return;
    }
    this.jdField_f_of_type_Int = 0;
    this.jdField_c_of_type_JavaLangString = paramCard.backgroundUrl;
    String str;
    if ((paramCard.lCurrentBgId != 160L) && (paramCard.lCurrentBgId != 1600L)) {
      str = ProfileCardManager.b(this.app.getApp(), paramCard.lCurrentStyleId, paramCard.lCurrentBgId);
    } else {
      str = ProfileCardUtil.a(paramCard.strDrawerCardUrl);
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
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new LikeRankingListActivity.9(this, (Bitmap)localObject), 100L);
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
    setContentView(2131561151);
    if (getIntent().getIntExtra("param_from", 0) == 1) {
      ReportController.b(this.app, "dc00898", "", "", "0X8007619", "0X8007619", 0, 0, "", "", "", "");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager = ((LikeRankingListManager)this.app.getManager(QQManagerFactory.LIKE_RANKING_LIST_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
    this.jdField_a_of_type_ComTencentMobileqqAppFriendsManager = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler = ((CardHandler)this.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER));
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)findViewById(2131378881));
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131378813);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131369249));
    paramBundle = getResources();
    this.jdField_a_of_type_AndroidContentResColorStateList = paramBundle.getColorStateList(2131165352);
    this.jdField_b_of_type_AndroidContentResColorStateList = paramBundle.getColorStateList(2131167053);
    findViewById(2131369202).setOnClickListener(this);
    this.jdField_d_of_type_Int = ProfileCardUtil.c(this);
    this.jdField_e_of_type_Int = ProfileCardUtil.d(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView = ((PullToZoomListView)findViewById(2131370511));
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOverScrollDistance(0);
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this).inflate(2131561152, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369332));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress = ((CircleProgress)this.jdField_b_of_type_AndroidViewView.findViewById(2131369333));
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setStrokeWidth(2.0F);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setBgAndProgressColor(0, 2131167333, 100, 16763714);
    this.jdField_a_of_type_ComTencentMobileqqWidgetCircleProgress.setProgress(100.0F);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_f_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131365291);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369331));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131379602));
    this.jdField_c_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131369308);
    this.jdField_d_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379563);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.addHeaderView(this.jdField_b_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setHeaderImage(this.jdField_f_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter = new LikeRankingListActivity.LikeRankingListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.setOnItemClickListener(this);
    this.jdField_e_of_type_AndroidViewView = findViewById(2131366237);
    DisplayMetrics localDisplayMetrics = paramBundle.getDisplayMetrics();
    int i = paramBundle.getDimensionPixelSize(2131299168);
    this.jdField_c_of_type_Int = (paramBundle.getDimensionPixelSize(2131297613) - i - (int)(localDisplayMetrics.density * 66.0F));
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
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppLikeRankingListManager.a();
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      a(String.valueOf(((LikeRankingInfo)paramBundle.get(0)).uin));
      this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.a(paramBundle, false);
    }
    else
    {
      a(null);
    }
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter;
    paramBundle.a = true;
    paramBundle.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, 500);
    ThreadManager.post(new LikeRankingListActivity.4(this), 5, null, false);
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
    ((IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "")).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemCallbackCallBacker);
    LeakUtil.removeLeakOn_SpenGestureManager(this);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.notifyDataSetChanged();
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
    int i = paramView.getId();
    if (i != 2131369202)
    {
      if (i == 2131369332)
      {
        String str;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo != null) && (this.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString))) {
          str = "1";
        } else {
          str = "2";
        }
        ReportController.b(this.app, "dc00898", "", "", "0X8007615", "0X8007615", 0, 0, str, "", "", "");
        ProfileUtils.openProfileCard(this, new AllInOne(this.jdField_b_of_type_JavaLangString, 1));
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
    if (paramString.equals(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
    if ((paramBitmap == null) && (paramInt1 > 0)) {
      return;
    }
    long l = SystemClock.uptimeMillis() - this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1);
    if (l >= 800L)
    {
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.notifyDataSetChanged();
      return;
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1, 800L - l);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt == 0) {
      return;
    }
    paramInt -= 1;
    if ((this.jdField_a_of_type_Int != -1) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.getCount() - 1)) {
      return;
    }
    if (paramInt == -1)
    {
      paramAdapterView = this.jdField_b_of_type_JavaLangString;
    }
    else
    {
      paramAdapterView = this.jdField_a_of_type_ComTencentMobileqqActivityLikeRankingListActivity$LikeRankingListAdapter.a(paramInt);
      if (paramAdapterView == null) {
        paramAdapterView = "";
      } else {
        paramAdapterView = String.valueOf(paramAdapterView.uin);
      }
    }
    if (!TextUtils.isEmpty(paramAdapterView))
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo != null) && (this.jdField_a_of_type_JavaLangString.equals(paramAdapterView))) {
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
    paramAbsListView = this.jdField_a_of_type_ComTencentWidgetPullToZoomListView.getChildAt(0);
    if ((paramAbsListView != null) && (paramInt1 == 0))
    {
      paramInt1 = Math.abs(paramAbsListView.getTop());
      Object localObject = null;
      if ((paramInt1 > this.jdField_b_of_type_Int) && (paramInt1 >= this.jdField_c_of_type_Int) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8))
      {
        paramAbsListView = this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation;
      }
      else
      {
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
      if ((paramAbsListView != null) && (paramAbsListView != this.jdField_a_of_type_AndroidViewView.getAnimation()))
      {
        paramAbsListView.reset();
        this.jdField_a_of_type_AndroidViewView.startAnimation(paramAbsListView);
        this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.startAnimation(paramAbsListView);
      }
      this.jdField_b_of_type_Int = paramInt1;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LikeRankingListActivity
 * JD-Core Version:    0.7.0.1
 */