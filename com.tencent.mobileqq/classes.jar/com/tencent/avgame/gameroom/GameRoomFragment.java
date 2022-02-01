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
import bdla;
import bhdj;
import bjum;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gameroom.gamelist.GameListView;
import com.tencent.avgame.gameroom.overlay.OverlayView;
import com.tencent.avgame.gameroom.pkstage.SurvivalPkStageView;
import com.tencent.avgame.gameroom.seat.PkSeatView;
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
import ndx;
import nfc;
import nfv;
import nfy;
import ngq;
import nia;
import nib;
import nic;
import nid;
import nie;
import nif;
import nig;
import nii;
import nin;
import nio;
import nip;
import niq;
import njj;
import njl;
import njs;
import nky;
import nkz;
import nlw;
import nlx;
import nom;
import npy;
import nqf;

public class GameRoomFragment
  extends GameBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, nip
{
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new nid(this);
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
  protected SurvivalPkStageView a;
  protected PkSeatView a;
  public SeatView a;
  protected StageView a;
  protected VideoGLView a;
  protected AutoBgImageView a;
  protected RoundRectImageView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new GameRoomFragment.1(this);
  private String jdField_a_of_type_JavaLangString;
  public nio a;
  private nlw jdField_a_of_type_Nlw;
  private nlx jdField_a_of_type_Nlx;
  protected boolean a;
  protected View b;
  public TextView b;
  protected AutoBgImageView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new GameRoomFragment.2(this);
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  protected View c;
  protected TextView c;
  Runnable jdField_c_of_type_JavaLangRunnable = new GameRoomFragment.3(this);
  private boolean jdField_c_of_type_Boolean;
  public TextView d;
  private boolean d;
  private TextView e;
  
  public static GameRoomFragment a()
  {
    GameRoomFragment localGameRoomFragment = new GameRoomFragment();
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGameRoomFragment.setArguments(localBundle);
    localGameRoomFragment.jdField_a_of_type_Nio = new nii(localGameRoomFragment);
    return localGameRoomFragment;
  }
  
  private void a(View paramView)
  {
    if (nfc.a().f())
    {
      ((ViewStub)paramView.findViewById(2131363123)).inflate();
      this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView = ((SurvivalPkStageView)paramView.findViewById(2131363236));
      ((ViewStub)paramView.findViewById(2131363122)).inflate();
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView = ((PkSeatView)paramView.findViewById(2131363298));
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.a();
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        paramView = new RelativeLayout.LayoutParams(-1, -2);
        ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.getParent();
        int i = localViewGroup.indexOfChild(this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView);
        localViewGroup.addView(this.jdField_a_of_type_AndroidViewView, i + 1, paramView);
      }
    }
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
    ((ViewStub)paramView.findViewById(2131363113)).inflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363202));
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363201);
    Bitmap localBitmap = nqf.a("avgame_guide_bkg@2x.png");
    TextView localTextView = (TextView)paramView.findViewById(2131363300);
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
    paramView = (Button)paramView.findViewById(2131363200);
    paramView.setBackgroundDrawable(nqf.a(getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    paramView.setOnClickListener(this);
  }
  
  private void b(boolean paramBoolean)
  {
    boolean bool = true;
    nfv localnfv = nfc.a().a();
    int i = localnfv.a();
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      a(false);
      if (localnfv.e())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_Nio.i(localnfv);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (localnfv.a() != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localnfv.a());
      label139:
      if (i != 10) {
        break label171;
      }
      i = 1;
      label147:
      if (i != 0) {
        break label176;
      }
    }
    for (;;)
    {
      a(bool);
      break;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      break label139;
      label171:
      i = 0;
      break label147;
      label176:
      bool = false;
    }
  }
  
  private void c(View paramView)
  {
    Object localObject = nfc.a().a().getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + (String)localObject, 4);
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("_b_show_guide_", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("_b_show_add_", false);
    if (!bool1)
    {
      ((SharedPreferences)localObject).edit().putBoolean("_b_show_guide_", true).apply();
      b(paramView);
      return;
    }
    if ((!bool2) && (nfc.a().a()) && (!nfc.a().e()))
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
      {
        ((ViewStub)paramView.findViewById(2131363113)).inflate();
        this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363202));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.post(new GameRoomFragment.6(this, paramView));
      return;
    }
    m();
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
  
  private void d(View paramView)
  {
    paramView = nfc.a().a().getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + paramView, 4).edit().putBoolean("_b_show_add_", true).apply();
    l();
    paramView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363183);
    Object localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = nin.s;
    ((RelativeLayout.LayoutParams)localObject).height = nin.s;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363201).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363200).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363300).setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.b();
    if (localObject == null)
    {
      QLog.e("GameRoomFragment", 1, "seatViwe Rect get failed!");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    int i = nin.s;
    int j = nin.t;
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).centerY(), i, j);
    paramView = (RelativeLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363184);
    i = paramView.getMeasuredWidth();
    j = paramView.getHeight();
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).top - AIOUtils.dp2px(15.0F, getResources()), i, j);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = nin.a;
    this.jdField_b_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.getLayoutParams();
    localLayoutParams.height = nin.c;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = nin.k;
    if (localLayoutParams.height > 0) {
      k();
    }
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getLayoutParams();
    localLayoutParams.topMargin = nin.n;
    localLayoutParams.height = nin.o;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setPadding(nin.p, 0, nin.q, 0);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setHorizontalSpacing(nin.r);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.getLayoutParams();
    localLayoutParams.topMargin = nin.k;
    localLayoutParams.width = nin.m;
    localLayoutParams.height = nin.l;
    int j = ViewUtils.dpToPx(2.0F);
    if (localLayoutParams.topMargin > 0) {}
    for (int i = j;; i = 0)
    {
      localLayoutParams.height += i + j;
      localLayoutParams.topMargin -= i;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.setPadding(0, i, 0, j);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.setLayoutParams(localLayoutParams);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView.getLayoutParams();
        localLayoutParams.topMargin = nin.k;
        localLayoutParams.width = nin.m;
        localLayoutParams.height = nin.l;
      }
      if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.getLayoutParams();
        localLayoutParams.topMargin = nin.u;
        localLayoutParams.bottomMargin = ViewUtils.dip2px(65.0F);
        localLayoutParams.addRule(10, -1);
        localLayoutParams.addRule(12, -1);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.topMargin = nin.u;
          localLayoutParams.bottomMargin = ViewUtils.dip2px(65.0F);
          localLayoutParams.addRule(10, -1);
          localLayoutParams.addRule(12, -1);
        }
      }
      return;
    }
  }
  
  private void k()
  {
    Bitmap localBitmap = nqf.a("avgame_room_bg@2x.png");
    if (localBitmap != null)
    {
      int i = localBitmap.getWidth();
      Matrix localMatrix = new Matrix();
      float f = nin.d / i;
      localMatrix.setScale(f, f);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(localMatrix);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(getResources().getColor(2131165344));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null)
    {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new nif(this);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
  }
  
  private void m()
  {
    if ((nfc.a().a()) && (!nfc.a().e())) {
      nom.a().b().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 10000L);
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
    Object localObject = nfc.a().a().a();
    if (((RoomInfo)localObject).id != 0L)
    {
      localObject = new StringBuilder(nqf.a(((RoomInfo)localObject).id));
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
    QQCustomDialog localQQCustomDialog = bhdj.a(getActivity(), 230);
    if (localQQCustomDialog != null)
    {
      int j = nfc.a().a().a();
      i = 2131690331;
      if ((j == 0) || (j == 10)) {
        i = 2131690332;
      }
      localQQCustomDialog.setMessage(i);
      nia localnia = new nia(this);
      localQQCustomDialog.setPositiveButton(2131694399, localnia);
      localQQCustomDialog.setNegativeButton(2131690697, localnia);
      localQQCustomDialog.show();
    }
    if (nfc.a().a()) {}
    for (int i = 1;; i = 2)
    {
      bdla.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", "" + nfc.a().a().a(), "", "");
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
    nom.a().b().post(new GameRoomFragment.8(this, paramInt, paramString));
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Nlx != null) {
      this.jdField_a_of_type_Nlx.a(paramLong, paramInt, paramString1, paramString2);
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
    this.jdField_a_of_type_AndroidOsCountDownTimer = new nig(this, paramLong1 - paramLong2, 1000L);
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
      bjum.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.e.setText(paramString);
    this.e.setVisibility(0);
    this.jdField_c_of_type_Boolean = true;
    bjum.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTransientTip delay ,tip" + paramString + ", delayMs" + paramInt + ",isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    nom.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    nom.a().b().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    nom.a().b().post(new GameRoomFragment.9(this, paramString, paramOnClickListener));
  }
  
  public void a(List<niq> paramList)
  {
    if (this.jdField_a_of_type_Nlx != null) {
      this.jdField_a_of_type_Nlx.a(paramList);
    }
  }
  
  public void a(nfy paramnfy)
  {
    if (this.jdField_c_of_type_AndroidViewView == null) {
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363189);
    ImageView localImageView2 = (ImageView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363191);
    if ((paramnfy != null) && (paramnfy.a()))
    {
      Object localObject = getResources();
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if (TextUtils.isEmpty(paramnfy.jdField_a_of_type_JavaLangString))
      {
        localObject = ((Resources)localObject).getDrawable(2130838723);
        localImageView1.setImageDrawable((Drawable)localObject);
        localImageView1.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        if (!paramnfy.b()) {
          break label221;
        }
      }
      label221:
      for (int i = 0;; i = 8)
      {
        localImageView2.setVisibility(i);
        bdla.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
        return;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject).getDrawable(2130838723);
        localURLDrawableOptions.mFailedDrawable = ((Resources)localObject).getDrawable(2130838723);
        localURLDrawableOptions.mRequestWidth = ((Resources)localObject).getDimensionPixelSize(2131296613);
        localURLDrawableOptions.mRequestHeight = ((Resources)localObject).getDimensionPixelSize(2131296612);
        localObject = URLDrawable.getDrawable(paramnfy.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        break;
      }
    }
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    localImageView1.setOnClickListener(null);
    localImageView2.setVisibility(8);
  }
  
  public void a(boolean paramBoolean)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTopRightCountDownView show = " + paramBoolean);
    }
    Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
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
    this.jdField_a_of_type_Nio.a(false);
    return true;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_Nlx != null) {
      return this.jdField_a_of_type_Nlx.a(paramInt, paramKeyEvent);
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
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
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
    bjum.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
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
      this.jdField_a_of_type_Nio.a(false);
      continue;
      q();
      continue;
      if (nfc.a().a()) {
        d(paramView);
      }
      for (;;)
      {
        if (paramView.getId() != 2131363200) {
          break label156;
        }
        bdla.b(null, "dc00898", "", "", "0X800B0A5", "0X800B0A5", 0, 0, "", "", "", "");
        break;
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      label156:
      bdla.b(null, "dc00898", "", "", "0X800B0A4", "0X800B0A4", 0, 0, "", "", "", "");
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ngq.a().jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558734, null);
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
      this.jdField_a_of_type_Nio.a(true);
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      n();
    }
    this.jdField_a_of_type_Nio.c();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Nlx != null)
    {
      this.jdField_a_of_type_Nlx.d(l);
      this.jdField_a_of_type_Nlx = null;
    }
    this.jdField_a_of_type_Boolean = false;
    nom.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    nom.a().b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    ngq.a().jdField_a_of_type_Boolean = false;
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
      paramView = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2131558754, null, false);
      paramView.measure(0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
      paramView.setOnClickListener(new nib(this));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new nic(this));
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
    if (this.jdField_a_of_type_Nlx != null) {
      this.jdField_a_of_type_Nlx.b();
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
    if (this.jdField_a_of_type_Nlx != null) {
      this.jdField_a_of_type_Nlx.b(l);
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidViewView.getVisibility() == 0)) {
      bdla.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onStart()
  {
    super.onStart();
    long l = AudioHelper.b();
    QLog.w("GameRoomFragment", 1, "avideo life_onStart, seq[" + l + "]");
    if (this.jdField_a_of_type_Nlx != null) {
      this.jdField_a_of_type_Nlx.a(l);
    }
    this.jdField_a_of_type_Nio.a();
    b(true);
  }
  
  public void onStop()
  {
    super.onStop();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
    if (this.jdField_a_of_type_Nlx != null) {
      this.jdField_a_of_type_Nlx.c(l);
    }
    this.jdField_a_of_type_Nio.b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onViewCreated");
    }
    nin.a(getActivity());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView = ((VideoGLView)paramView.findViewById(2131363315));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView = ((GameListView)paramView.findViewById(2131363199));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView = ((StageView)paramView.findViewById(2131363299));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView = ((SeatView)paramView.findViewById(2131363298));
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView = ((OverlayView)paramView.findViewById(2131363235));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363312);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363293));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363288));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363281));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363190);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363197));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131363769));
    float f = AIOUtils.dp2px(12.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode((int)f, 1);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setBackgroundColor(16777215);
    a(false);
    a(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363188));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363193));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)paramView.findViewById(2131363315));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.e = ((TextView)paramView.findViewById(2131363196));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.e.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = nin.B;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367506));
    paramBundle = getActivity();
    if ((paramBundle instanceof AVGameActivity))
    {
      if (!((AVGameActivity)paramBundle).b()) {
        break label780;
      }
      this.jdField_b_of_type_Boolean = false;
      if ((!nfc.a().a()) && (!nfc.a().e())) {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getViewTreeObserver().addOnGlobalLayoutListener(new nie(this));
      }
    }
    paramBundle = (AVGameAppInterface)getActivity().getAppRuntime();
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderOnTop(true);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderMediaOverlay(true);
    this.jdField_a_of_type_Nlw = new nlw(getActivity(), paramBundle);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this.jdField_a_of_type_Nlw);
    this.jdField_a_of_type_Nlx = new AVGameControlUIImpl(paramBundle, getActivity(), (ViewGroup)paramView);
    this.jdField_a_of_type_Nlx.a(this.jdField_a_of_type_Nlw);
    a(paramView);
    nio localnio = this.jdField_a_of_type_Nio;
    FragmentActivity localFragmentActivity = getActivity();
    njj localnjj = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a();
    nky localnky = this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a();
    label543:
    njl localnjl;
    nlx localnlx;
    nkz localnkz;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.a();
      localnjl = this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a();
      localnlx = this.jdField_a_of_type_Nlx;
      localnkz = this.jdField_a_of_type_Nlw.a();
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView == null) {
        break label799;
      }
    }
    label780:
    label799:
    for (njs localnjs = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView.a();; localnjs = null)
    {
      localnio.a(localFragmentActivity, localnjj, localnky, paramBundle, localnjl, localnlx, localnkz, localnjs);
      this.jdField_a_of_type_Nlw.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a());
      this.jdField_a_of_type_Nlx.a(this.jdField_a_of_type_Nio);
      if (this.jdField_a_of_type_Nlx != null) {
        this.jdField_a_of_type_Nlx.a();
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView.a(this.jdField_a_of_type_Nio);
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a(this.jdField_a_of_type_Nio, this.jdField_a_of_type_Nlx);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageStageView.a(this.jdField_a_of_type_Nio);
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a(this.jdField_a_of_type_Nio);
      this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a(this.jdField_a_of_type_Nio);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.a(this.jdField_a_of_type_Nio);
      }
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView.a(this.jdField_a_of_type_Nio);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      o();
      j();
      ndx.a().c();
      c(paramView);
      this.jdField_a_of_type_Boolean = true;
      return;
      this.jdField_b_of_type_Boolean = true;
      break;
      paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
      break label543;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment
 * JD-Core Version:    0.7.0.1
 */