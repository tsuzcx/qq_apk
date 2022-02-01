package com.tencent.avgame.gameroom;

import afur;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.RectF;
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
import bcst;
import bglp;
import bgpa;
import bgtn;
import bjda;
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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.List;
import mxb;
import mxl;
import myc;
import myw;
import mzz;
import naa;
import nab;
import nac;
import nad;
import nae;
import nag;
import nak;
import nal;
import nam;
import nan;
import nck;
import ncl;
import neq;
import nfr;
import nfx;

public class GameRoomFragment
  extends GameBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, nam
{
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  protected View a;
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
  public nal a;
  private nck jdField_a_of_type_Nck;
  private ncl jdField_a_of_type_Ncl;
  protected boolean a;
  public TextView b;
  protected AutoBgImageView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new GameRoomFragment.2(this);
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  protected TextView c;
  private boolean c;
  public TextView d;
  private TextView e;
  
  public static GameRoomFragment a()
  {
    GameRoomFragment localGameRoomFragment = new GameRoomFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGameRoomFragment.setArguments(localBundle);
    localGameRoomFragment.jdField_a_of_type_Nal = new nag(localGameRoomFragment);
    return localGameRoomFragment;
  }
  
  private void a(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131363059)).inflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363144));
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363143);
    Bitmap localBitmap = nfx.a("avgame_guide_bkg@2x.png");
    TextView localTextView = (TextView)paramView.findViewById(2131363186);
    localTextView.setVisibility(8);
    localTextView.setOnClickListener(this);
    if (localBitmap != null)
    {
      localImageView.setImageBitmap(localBitmap);
      localImageView.post(new GameRoomFragment.5(this, localBitmap, localImageView, localTextView));
    }
    paramView = (Button)paramView.findViewById(2131363142);
    paramView.setBackgroundDrawable(nfx.a(getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
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
    Object localObject = mxl.a().a().getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + (String)localObject, 4);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("_b_show_guide_", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("_b_show_add_", false);
    if (!bool1)
    {
      ((SharedPreferences)localObject).edit().putBoolean("_b_show_guide_", true).apply();
      a(paramView);
    }
    while ((bool2) || (!mxl.a().a())) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      ((ViewStub)paramView.findViewById(2131363059)).inflate();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363144));
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new GameRoomFragment.6(this, paramView));
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = true;
    myc localmyc = mxl.a().a();
    int i = localmyc.a();
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      a(false);
      if (paramBoolean) {
        this.jdField_a_of_type_Nal.i(localmyc);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (localmyc.a() != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localmyc.a());
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
    paramView = mxl.a().a().getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + paramView, 4).edit().putBoolean("_b_show_add_", true).apply();
    k();
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363127);
    Object localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = nak.s;
    ((RelativeLayout.LayoutParams)localObject).height = nak.s;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363143).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363142).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363186).setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
    if (localObject == null)
    {
      QLog.e("GameRoomFragment", 1, "seatViwe Rect get failed!");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    int i = nak.s;
    int j = nak.t;
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).centerY(), i, j);
    paramView = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363128);
    i = paramView.getMeasuredWidth();
    j = paramView.getHeight();
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).top - afur.a(15.0F, getResources()), i, j);
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
    localLayoutParams.topMargin = nak.a;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.getLayoutParams();
    localLayoutParams.topMargin = nak.b;
    localLayoutParams.height = nak.c;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getLayoutParams();
    localLayoutParams.topMargin = nak.n;
    localLayoutParams.height = nak.o;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setPadding(nak.p, 0, nak.q, 0);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setHorizontalSpacing(nak.r);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.getLayoutParams();
    localLayoutParams.topMargin = nak.k;
    localLayoutParams.width = nak.m;
    localLayoutParams.height = nak.l;
    int j = bgtn.b(2.0F);
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
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null)
    {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new nad(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
  }
  
  private void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "resetBreath");
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setBackgroundColor(16777215);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setScaleX(1.0F);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setScaleY(1.0F);
  }
  
  private void m()
  {
    Object localObject = mxl.a().a().a();
    if (((RoomInfo)localObject).id != 0L)
    {
      localObject = new StringBuilder(nfx.a(((RoomInfo)localObject).id));
      if (((StringBuilder)localObject).length() == 9)
      {
        ((StringBuilder)localObject).insert(6, "-");
        ((StringBuilder)localObject).insert(3, "-");
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(((StringBuilder)localObject).toString());
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      l();
    }
  }
  
  private void o()
  {
    bgpa localbgpa = bglp.a(getActivity(), 230);
    if (localbgpa != null)
    {
      int j = mxl.a().a().a();
      i = 2131690262;
      if ((j == 0) || (j == 10)) {
        i = 2131690263;
      }
      localbgpa.setMessage(i);
      mzz localmzz = new mzz(this);
      localbgpa.setPositiveButton(2131694081, localmzz);
      localbgpa.setNegativeButton(2131690582, localmzz);
      localbgpa.show();
    }
    if (mxl.a().a()) {}
    for (int i = 1;; i = 2)
    {
      bcst.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", "" + mxl.a().a().a(), "", "");
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
    neq.a().b().post(new GameRoomFragment.8(this, paramInt, paramString));
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ncl != null) {
      this.jdField_a_of_type_Ncl.a(paramLong, paramInt, paramString1, paramString2);
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
      l();
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new nae(this, paramLong1 - paramLong2, 1000L);
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
      bjda.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.e.setText(paramString);
    this.e.setVisibility(0);
    this.jdField_c_of_type_Boolean = true;
    bjda.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTransientTip delay ,tip" + paramString + ", delayMs" + paramInt + ",isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    neq.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    neq.a().b().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    neq.a().b().post(new GameRoomFragment.9(this, paramString, paramOnClickListener));
  }
  
  public void a(List<nan> paramList)
  {
    if (this.jdField_a_of_type_Ncl != null) {
      this.jdField_a_of_type_Ncl.a(paramList);
    }
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
    this.jdField_a_of_type_Nal.a(false);
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Ncl != null) {
      return this.jdField_a_of_type_Ncl.a(paramInt, paramKeyEvent);
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
    n();
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
    bjda.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
      this.jdField_a_of_type_Nal.a(false);
      continue;
      o();
      continue;
      if (mxl.a().a()) {
        c(paramView);
      }
      for (;;)
      {
        if (paramView.getId() != 2131363142) {
          break label155;
        }
        bcst.b(null, "dc00898", "", "", "0X800B0A5", "0X800B0A5", 0, 0, "", "", "", "");
        break;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      label155:
      bcst.b(null, "dc00898", "", "", "0X800B0A4", "0X800B0A4", 0, 0, "", "", "", "");
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    myw.a().jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558712, null);
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
      this.jdField_a_of_type_Nal.a(true);
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      l();
    }
    this.jdField_a_of_type_Nal.c();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Ncl != null)
    {
      this.jdField_a_of_type_Ncl.d(l);
      this.jdField_a_of_type_Ncl = null;
    }
    this.jdField_a_of_type_Boolean = false;
    neq.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    myw.a().jdField_a_of_type_Boolean = false;
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
      paramView = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2131558728, null, false);
      paramView.measure(0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
      paramView.setOnClickListener(new naa(this));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new nab(this));
      int i = (this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() - bgtn.a(90.0F)) / 2;
      int j = -bgtn.a(4.0F);
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
    if (this.jdField_a_of_type_Ncl != null) {
      this.jdField_a_of_type_Ncl.b();
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
    if (this.jdField_a_of_type_Ncl != null) {
      this.jdField_a_of_type_Ncl.b(l);
    }
  }
  
  public void onStart()
  {
    super.onStart();
    long l = AudioHelper.b();
    QLog.w("GameRoomFragment", 1, "avideo life_onStart, seq[" + l + "]");
    if (this.jdField_a_of_type_Ncl != null) {
      this.jdField_a_of_type_Ncl.a(l);
    }
    this.jdField_a_of_type_Nal.a();
    b(true);
  }
  
  public void onStop()
  {
    super.onStop();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
    if (this.jdField_a_of_type_Ncl != null) {
      this.jdField_a_of_type_Ncl.c(l);
    }
    this.jdField_a_of_type_Nal.b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onViewCreated");
    }
    nak.a(getActivity());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView = ((VideoGLView)paramView.findViewById(2131363197));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView = ((GameListView)paramView.findViewById(2131363141));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView = ((StageView)paramView.findViewById(2131363185));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView = ((SeatView)paramView.findViewById(2131363184));
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView = ((OverlayView)paramView.findViewById(2131363150));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363194);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363180));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363179));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363173));
    this.d = ((TextView)paramView.findViewById(2131363139));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131363643));
    float f = afur.a(12.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode((int)f, 1);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setBackgroundColor(16777215);
    a(false);
    a(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363132));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363134));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)paramView.findViewById(2131363197));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.e = ((TextView)paramView.findViewById(2131363138));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.e.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = nak.u;
    paramBundle = getActivity();
    if ((paramBundle instanceof AVGameActivity))
    {
      if (!((AVGameActivity)paramBundle).b()) {
        break label651;
      }
      this.jdField_b_of_type_Boolean = false;
      if (!mxl.a().a()) {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getViewTreeObserver().addOnGlobalLayoutListener(new nac(this));
      }
    }
    for (;;)
    {
      j();
      paramBundle = (AVGameAppInterface)getActivity().getAppRuntime();
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderOnTop(true);
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderMediaOverlay(true);
      this.jdField_a_of_type_Nck = new nck(getActivity(), paramBundle);
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this.jdField_a_of_type_Nck);
      this.jdField_a_of_type_Ncl = new AVGameControlUIImpl(paramBundle, getActivity(), (ViewGroup)paramView);
      this.jdField_a_of_type_Ncl.a(this.jdField_a_of_type_Nck);
      this.jdField_a_of_type_Nal.a(getActivity(), this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a(), this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a(), this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a(), this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a(), this.jdField_a_of_type_Ncl, this.jdField_a_of_type_Nck.a());
      this.jdField_a_of_type_Nck.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a());
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView.a(this.jdField_a_of_type_Nal);
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a(this.jdField_a_of_type_Nal);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a(this.jdField_a_of_type_Nal);
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a(this.jdField_a_of_type_Nal);
      this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a(this.jdField_a_of_type_Nal);
      this.jdField_a_of_type_Ncl.a(this.jdField_a_of_type_Nal);
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      if (this.jdField_a_of_type_Ncl != null) {
        this.jdField_a_of_type_Ncl.a();
      }
      m();
      j();
      mxb.a().c();
      b(paramView);
      this.jdField_a_of_type_Boolean = true;
      return;
      label651:
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment
 * JD-Core Version:    0.7.0.1
 */