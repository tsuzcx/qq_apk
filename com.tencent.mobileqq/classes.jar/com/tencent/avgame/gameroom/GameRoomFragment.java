package com.tencent.avgame.gameroom;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bcef;
import bfur;
import bijk;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.gamelist.GameListView;
import com.tencent.avgame.gameroom.overlay.OverlayView;
import com.tencent.avgame.gameroom.seat.SeatView;
import com.tencent.avgame.gameroom.stage.StageView;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl;
import com.tencent.avgame.gameroom.video.VideoGLView;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import myl;
import mzl;
import naf;
import nai;
import nba;
import ncd;
import nce;
import ncf;
import ncg;
import nch;
import nci;
import ncj;
import ncl;
import ncp;
import ncq;
import ncr;
import ncs;
import nfe;
import nff;
import nht;
import njb;
import njh;

public class GameRoomFragment
  extends GameBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, ncr
{
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new ncg(this);
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  protected View a;
  protected ImageView a;
  public PopupWindow a;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  private GLRootView jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
  protected GameListView a;
  protected OverlayView a;
  public SeatView a;
  protected StageView a;
  protected VideoGLView a;
  protected AutoBgImageView a;
  protected RoundRectImageView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new GameRoomFragment.1(this);
  private String jdField_a_of_type_JavaLangString;
  public ncq a;
  private nfe jdField_a_of_type_Nfe;
  private nff jdField_a_of_type_Nff;
  protected boolean a;
  protected View b;
  public TextView b;
  protected AutoBgImageView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new GameRoomFragment.2(this);
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  protected TextView c;
  Runnable jdField_c_of_type_JavaLangRunnable = new GameRoomFragment.3(this);
  private boolean jdField_c_of_type_Boolean;
  public TextView d;
  private TextView e;
  
  public static GameRoomFragment a()
  {
    GameRoomFragment localGameRoomFragment = new GameRoomFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGameRoomFragment.setArguments(localBundle);
    localGameRoomFragment.jdField_a_of_type_Ncq = new ncl(localGameRoomFragment);
    return localGameRoomFragment;
  }
  
  private void a(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131363096)).inflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363183));
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363182);
    Bitmap localBitmap = njh.a("avgame_guide_bkg@2x.png");
    TextView localTextView = (TextView)paramView.findViewById(2131363241);
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
    paramView = (Button)paramView.findViewById(2131363181);
    paramView.setBackgroundDrawable(njh.a(getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    paramView.setOnClickListener(this);
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = (int)(paramFloat1 - paramInt1 / 2);
    int j = (int)(paramFloat2 - paramInt2 / 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramView.getLayoutParams());
    localMarginLayoutParams.setMargins(i, j, i + paramInt1, j + paramInt2);
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(localMarginLayoutParams));
    paramView.setVisibility(0);
  }
  
  private void a(RoundRectImageView paramRoundRectImageView)
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet != null) {
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofObject(paramRoundRectImageView, "backgroundColor", new ArgbEvaluator(), new Object[] { Integer.valueOf(2147441002), Integer.valueOf(-42646), Integer.valueOf(2147441002) });
    localObjectAnimator1.setDuration(1000L);
    localObjectAnimator1.setRepeatCount(10);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramRoundRectImageView, "scaleX", new float[] { 1.12F, 1.0F, 1.12F });
    localObjectAnimator2.setDuration(1000L);
    localObjectAnimator2.setRepeatCount(10);
    paramRoundRectImageView = ObjectAnimator.ofFloat(paramRoundRectImageView, "scaleY", new float[] { 1.12F, 1.0F, 1.12F });
    paramRoundRectImageView.setDuration(1000L);
    paramRoundRectImageView.setRepeatCount(10);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2).with(paramRoundRectImageView);
  }
  
  private void b(View paramView)
  {
    Object localObject = mzl.a().a().getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + (String)localObject, 4);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("_b_show_guide_", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("_b_show_add_", false);
    if (!bool1)
    {
      ((SharedPreferences)localObject).edit().putBoolean("_b_show_guide_", true).apply();
      a(paramView);
      return;
    }
    if ((!bool2) && (mzl.a().a()) && (!mzl.a().e()))
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        ((ViewStub)paramView.findViewById(2131363096)).inflate();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363183));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new GameRoomFragment.6(this, paramView));
      return;
    }
    m();
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = true;
    naf localnaf = mzl.a().a();
    int i = localnaf.a();
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      a(false);
      if (paramBoolean) {
        this.jdField_a_of_type_Ncq.i(localnaf);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (localnaf.a() != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localnaf.a());
      label104:
      if (i != 10) {
        break label136;
      }
      i = 1;
      label112:
      if (i != 0) {
        break label141;
      }
    }
    for (;;)
    {
      a(bool);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label104;
      label136:
      i = 0;
      break label112;
      label141:
      bool = false;
    }
  }
  
  private void c(View paramView)
  {
    paramView = mzl.a().a().getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + paramView, 4).edit().putBoolean("_b_show_add_", true).apply();
    l();
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363164);
    Object localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = ncp.s;
    ((RelativeLayout.LayoutParams)localObject).height = ncp.s;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363182).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363181).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363241).setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.b();
    if (localObject == null)
    {
      QLog.e("GameRoomFragment", 1, "seatViwe Rect get failed!");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    int i = ncp.s;
    int j = ncp.t;
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).centerY(), i, j);
    paramView = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363165);
    i = paramView.getMeasuredWidth();
    j = paramView.getHeight();
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).top - AIOUtils.dp2px(15.0F, getResources()), i, j);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void c(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (getActivity() != null)
        {
          if (Build.VERSION.SDK_INT < 11)
          {
            ((android.text.ClipboardManager)getActivity().getSystemService("clipboard")).setText(paramString);
            return;
          }
          ((android.content.ClipboardManager)getActivity().getSystemService("clipboard")).setText(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("GameRoomFragment", 2, "copyContent fail.", paramString);
      }
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "refreshCommonBlackTipView ,isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.e.setVisibility(8);
      return;
    }
    this.e.setVisibility(0);
    this.e.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  private void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = ncp.a;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.getLayoutParams();
    localLayoutParams.height = ncp.c;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = ncp.k;
    if (localLayoutParams.height > 0) {
      k();
    }
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getLayoutParams();
    localLayoutParams.topMargin = ncp.n;
    localLayoutParams.height = ncp.o;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setPadding(ncp.p, 0, ncp.q, 0);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setHorizontalSpacing(ncp.r);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.getLayoutParams();
    localLayoutParams.topMargin = ncp.k;
    localLayoutParams.width = ncp.m;
    localLayoutParams.height = ncp.l;
    int j = ViewUtils.dpToPx(2.0F);
    if (localLayoutParams.topMargin > 0) {}
    for (int i = j;; i = 0)
    {
      localLayoutParams.height += i + j;
      localLayoutParams.topMargin -= i;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.setPadding(0, i, 0, j);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.setLayoutParams(localLayoutParams);
      return;
    }
  }
  
  private void k()
  {
    Bitmap localBitmap = njh.a("avgame_room_bg@2x.png");
    if (localBitmap != null)
    {
      int i = localBitmap.getWidth();
      Matrix localMatrix = new Matrix();
      float f = ncp.d / i;
      localMatrix.setScale(f, f);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(localMatrix);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(getResources().getColor(2131165341));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null)
    {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new nci(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
  }
  
  private void m()
  {
    if ((mzl.a().a()) && (!mzl.a().e())) {
      nht.a().b().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 10000L);
    }
  }
  
  private void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "resetBreath");
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setBackgroundColor(16777215);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setScaleY(1.0F);
  }
  
  private void o()
  {
    Object localObject = mzl.a().a().a();
    if (((RoomInfo)localObject).id != 0L)
    {
      localObject = new StringBuilder(njh.a(((RoomInfo)localObject).id));
      if (((StringBuilder)localObject).length() == 9)
      {
        ((StringBuilder)localObject).insert(6, "-");
        ((StringBuilder)localObject).insert(3, "-");
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
    }
  }
  
  private void p()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      n();
    }
  }
  
  private void q()
  {
    QQCustomDialog localQQCustomDialog = bfur.a(getActivity(), 230);
    if (localQQCustomDialog != null)
    {
      int j = mzl.a().a().a();
      i = 2131690293;
      if ((j == 0) || (j == 10)) {
        i = 2131690294;
      }
      localQQCustomDialog.setMessage(i);
      ncd localncd = new ncd(this);
      localQQCustomDialog.setPositiveButton(2131694201, localncd);
      localQQCustomDialog.setNegativeButton(2131690620, localncd);
      localQQCustomDialog.show();
    }
    if (mzl.a().a()) {}
    for (int i = 1;; i = 2)
    {
      bcef.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", "" + mzl.a().a().a(), "", "");
      return;
    }
  }
  
  public Activity a()
  {
    return getActivity();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_Boolean)) {
      b(true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomFragment", 2, "showToastTip toast:" + paramString + " trace: ", new Throwable("not crash, rint stack"));
    }
    if ((getActivity() == null) || (getActivity().isFinishing()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    nht.a().b().post(new GameRoomFragment.8(this, paramInt, paramString));
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Nff != null) {
      this.jdField_a_of_type_Nff.a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onStartTopRightCountDown called ,startOffsetDuration = " + paramLong2 + ",totalDuration = " + paramLong1);
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      n();
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new ncj(this, paramLong1 - paramLong2, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
    a(true);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTransientTip tip = " + paramString + ",isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
    }
    if (this.jdField_c_of_type_Boolean) {
      bijk.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.e.setText(paramString);
    this.e.setVisibility(0);
    this.jdField_c_of_type_Boolean = true;
    bijk.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTransientTip delay ,tip" + paramString + ", delayMs" + paramInt + ",isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    nht.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    nht.a().b().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    nht.a().b().post(new GameRoomFragment.9(this, paramString, paramOnClickListener));
  }
  
  public void a(List<ncs> paramList)
  {
    if (this.jdField_a_of_type_Nff != null) {
      this.jdField_a_of_type_Nff.a(paramList);
    }
  }
  
  public void a(nai paramnai)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363170);
    ImageView localImageView2 = (ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363172);
    if ((paramnai != null) && (paramnai.a()))
    {
      Object localObject = getResources();
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (TextUtils.isEmpty(paramnai.jdField_a_of_type_JavaLangString))
      {
        localObject = ((Resources)localObject).getDrawable(2130838707);
        localImageView1.setImageDrawable((Drawable)localObject);
        localImageView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (!paramnai.b()) {
          break label188;
        }
      }
      label188:
      for (int i = 0;; i = 8)
      {
        localImageView2.setVisibility(i);
        return;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject).getDrawable(2130838707);
        localURLDrawableOptions.mFailedDrawable = ((Resources)localObject).getDrawable(2130838707);
        localURLDrawableOptions.mRequestWidth = ((Resources)localObject).getDimensionPixelSize(2131296613);
        localURLDrawableOptions.mRequestHeight = ((Resources)localObject).getDimensionPixelSize(2131296612);
        localObject = URLDrawable.getDrawable(paramnai.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        break;
      }
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    localImageView1.setOnClickListener(null);
    localImageView2.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTopRightCountDownView show = " + paramBoolean);
    }
    Object localObject = this.d;
    if (paramBoolean)
    {
      i = 0;
      ((TextView)localObject).setVisibility(i);
      localObject = this.jdField_a_of_type_ComTencentWidgetRoundRectImageView;
      if (!paramBoolean) {
        break label91;
      }
    }
    label91:
    for (int i = j;; i = 8)
    {
      ((RoundRectImageView)localObject).setVisibility(i);
      if (paramBoolean) {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      i = 8;
      break;
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_Ncq.a(false);
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Nff != null) {
      return this.jdField_a_of_type_Nff.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    b(false);
    a(true);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onHidePermanentTip ,isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowPermanentTip tip = " + paramString + ",isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onSetTopRightCountDownContent content = " + paramString);
    }
    this.d.setText(paramString);
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    b(false);
    p();
    a(false);
    if (a() != null) {
      a().c();
    }
  }
  
  public void d()
  {
    b(false);
    if (a() != null) {
      a().b();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomFragment", 2, "finishActivity trace: ", new Throwable("not crash, print stack"));
    }
    if ((getActivity() == null) || (getActivity().isFinishing()))
    {
      QLog.d("GameRoomFragment", 2, "finishActivity aready finished!");
      return;
    }
    getActivity().finish();
  }
  
  public void f()
  {
    if (a() != null) {
      a().d();
    }
  }
  
  public void g()
  {
    bijk.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_c_of_type_Boolean = false;
    i();
  }
  
  public View getView()
  {
    return super.getView();
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
      this.jdField_a_of_type_Ncq.a(false);
      continue;
      q();
      continue;
      if (mzl.a().a()) {
        c(paramView);
      }
      for (;;)
      {
        if (paramView.getId() != 2131363181) {
          break label155;
        }
        bcef.b(null, "dc00898", "", "", "0X800B0A5", "0X800B0A5", 0, 0, "", "", "", "");
        break;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      label155:
      bcef.b(null, "dc00898", "", "", "0X800B0A4", "0X800B0A4", 0, 0, "", "", "", "");
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    nba.a().jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558720, null);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onCreateView");
    }
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("GameRoomFragment", 1, "avideo onDestroy");
    if ((a() != null) && (!a().a()))
    {
      QLog.i("GameRoomFragment", 1, "doOnDestroy exit not by Finished");
      this.jdField_a_of_type_Ncq.a(true);
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      n();
    }
    this.jdField_a_of_type_Ncq.c();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Nff != null)
    {
      this.jdField_a_of_type_Nff.d(l);
      this.jdField_a_of_type_Nff = null;
    }
    this.jdField_a_of_type_Boolean = false;
    nht.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    nht.a().b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    nba.a().jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.c();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidWidgetPopupWindow != null) {
      return true;
    }
    try
    {
      paramView = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2131558737, null, false);
      paramView.measure(0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
      paramView.setOnClickListener(new nce(this));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new ncf(this));
      int i = (this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() - ViewUtils.dip2px(90.0F)) / 2;
      int j = -ViewUtils.dip2px(4.0F);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.showAsDropDown(this.jdField_b_of_type_AndroidWidgetTextView, i, j);
      return true;
    }
    catch (Exception paramView)
    {
      QLog.e("GameRoomFragment", 1, "onLongClick exception, ", paramView);
    }
    return true;
  }
  
  public void onPause()
  {
    QLog.i("GameRoomFragment", 1, "avideo onPause");
    super.onPause();
    if (this.jdField_a_of_type_Nff != null) {
      this.jdField_a_of_type_Nff.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    long l = AudioHelper.b();
    QLog.w("GameRoomFragment", 1, "avideo life_onResume, seq[" + l + "]");
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null)
    {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onResume();
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.requestRender();
    }
    if (this.jdField_a_of_type_Nff != null) {
      this.jdField_a_of_type_Nff.b(l);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    long l = AudioHelper.b();
    QLog.w("GameRoomFragment", 1, "avideo life_onStart, seq[" + l + "]");
    if (this.jdField_a_of_type_Nff != null) {
      this.jdField_a_of_type_Nff.a(l);
    }
    this.jdField_a_of_type_Ncq.a();
    b(true);
  }
  
  public void onStop()
  {
    super.onStop();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
    if (this.jdField_a_of_type_Nff != null) {
      this.jdField_a_of_type_Nff.c(l);
    }
    this.jdField_a_of_type_Ncq.b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onViewCreated");
    }
    ncp.a(getActivity());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView = ((VideoGLView)paramView.findViewById(2131363252));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView = ((GameListView)paramView.findViewById(2131363180));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView = ((StageView)paramView.findViewById(2131363240));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView = ((SeatView)paramView.findViewById(2131363239));
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView = ((OverlayView)paramView.findViewById(2131363204));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363249);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363234));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363233));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363227));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363171);
    this.d = ((TextView)paramView.findViewById(2131363178));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131363698));
    float f = AIOUtils.dp2px(12.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode((int)f, 1);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setBackgroundColor(16777215);
    a(false);
    a(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363169));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363174));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)paramView.findViewById(2131363252));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.e = ((TextView)paramView.findViewById(2131363177));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.e.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ncp.u;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367382));
    paramBundle = getActivity();
    if ((paramBundle instanceof AVGameActivity))
    {
      if (!((AVGameActivity)paramBundle).b()) {
        break label685;
      }
      this.jdField_b_of_type_Boolean = false;
      if ((!mzl.a().a()) && (!mzl.a().e())) {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getViewTreeObserver().addOnGlobalLayoutListener(new nch(this));
      }
    }
    for (;;)
    {
      paramBundle = (AVGameAppInterface)getActivity().getAppRuntime();
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderOnTop(true);
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderMediaOverlay(true);
      this.jdField_a_of_type_Nfe = new nfe(getActivity(), paramBundle);
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this.jdField_a_of_type_Nfe);
      this.jdField_a_of_type_Nff = new AVGameControlUIImpl(paramBundle, getActivity(), (ViewGroup)paramView);
      this.jdField_a_of_type_Nff.a(this.jdField_a_of_type_Nfe);
      this.jdField_a_of_type_Ncq.a(getActivity(), this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a(), this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a(), this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a(), this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a(), this.jdField_a_of_type_Nff, this.jdField_a_of_type_Nfe.a());
      this.jdField_a_of_type_Nfe.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a());
      this.jdField_a_of_type_Nff.a(this.jdField_a_of_type_Ncq);
      if (this.jdField_a_of_type_Nff != null) {
        this.jdField_a_of_type_Nff.a();
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView.a(this.jdField_a_of_type_Ncq);
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a(this.jdField_a_of_type_Ncq, this.jdField_a_of_type_Nff);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a(this.jdField_a_of_type_Ncq);
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a(this.jdField_a_of_type_Ncq);
      this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a(this.jdField_a_of_type_Ncq);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      o();
      j();
      myl.a().c();
      b(paramView);
      this.jdField_a_of_type_Boolean = true;
      return;
      label685:
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment
 * JD-Core Version:    0.7.0.1
 */