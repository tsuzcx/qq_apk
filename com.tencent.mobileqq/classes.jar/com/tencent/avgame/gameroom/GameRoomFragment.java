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
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.globalmanage.GlobalExitRoomDialog;
import com.tencent.avgame.gameroom.gamelist.GameListView;
import com.tencent.avgame.gameroom.gamelist.IGameListPresenter;
import com.tencent.avgame.gameroom.overlay.IOverlayPresenter;
import com.tencent.avgame.gameroom.overlay.OverlayView;
import com.tencent.avgame.gameroom.pkstage.ISurvivalStagePresenter;
import com.tencent.avgame.gameroom.pkstage.SurvivalPkStageView;
import com.tencent.avgame.gameroom.seat.PkSeatView;
import com.tencent.avgame.gameroom.seat.SeatView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.gameroom.stage.NormalStageView;
import com.tencent.avgame.gameroom.stage.base.BaseStageView;
import com.tencent.avgame.gameroom.stage.festivalstage.FestvialStageView;
import com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer;
import com.tencent.avgame.gameroom.video.AVGameControlUI;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl;
import com.tencent.avgame.gameroom.video.VideoGLView;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.avgame.ui.GuideView;
import com.tencent.avgame.ui.HoleBean;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qmethodmonitor.monitor.ClipboardMonitor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.RoundRectImageView;
import java.util.ArrayList;
import java.util.List;

public class GameRoomFragment
  extends GameBaseFragment
  implements View.OnClickListener, View.OnLongClickListener, IGameRoomView
{
  AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = null;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener = null;
  protected View a;
  private Button jdField_a_of_type_AndroidWidgetButton;
  protected ImageView a;
  PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  protected TextView a;
  private GLRootView jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
  protected IGameRoomPresenter a;
  protected GameListView a;
  protected OverlayView a;
  protected SurvivalPkStageView a;
  protected PkSeatView a;
  protected SeatView a;
  protected BaseStageView a;
  private AVGameBusinessVideoLayer jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer;
  private AVGameControlUI jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
  protected VideoGLView a;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  protected AutoBgImageView a;
  protected RoundRectImageView a;
  Runnable jdField_a_of_type_JavaLangRunnable = new GameRoomFragment.1(this);
  private String jdField_a_of_type_JavaLangString;
  protected boolean a;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GameRoomFragment.22(this);
  private View.OnTouchListener jdField_b_of_type_AndroidViewView$OnTouchListener = null;
  protected View b;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  protected TextView b;
  protected AutoBgImageView b;
  Runnable jdField_b_of_type_JavaLangRunnable = new GameRoomFragment.2(this);
  private String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean;
  protected View c;
  protected TextView c;
  Runnable jdField_c_of_type_JavaLangRunnable = new GameRoomFragment.3(this);
  private boolean jdField_c_of_type_Boolean;
  protected View d;
  protected TextView d;
  private boolean d;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean f;
  
  public GameRoomFragment()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  private RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    GameRoomViewLayoutParamsDef.a(paramView, arrayOfInt);
    RectF localRectF = new RectF();
    localRectF.left = arrayOfInt[0];
    localRectF.top = arrayOfInt[1];
    localRectF.right = (localRectF.left + paramView.getMeasuredWidth());
    localRectF.bottom = (localRectF.top + paramView.getMeasuredHeight());
    return localRectF;
  }
  
  public static GameRoomFragment a()
  {
    GameRoomFragment localGameRoomFragment = new GameRoomFragment();
    localGameRoomFragment.setArguments(new Bundle());
    localGameRoomFragment.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = new GameRoomPresenterImp(localGameRoomFragment);
    return localGameRoomFragment;
  }
  
  private void a(View paramView)
  {
    if (GameEngine.a().f())
    {
      ((ViewStub)paramView.findViewById(2131363114)).inflate();
      this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView = ((SurvivalPkStageView)paramView.findViewById(2131363246));
      ((ViewStub)paramView.findViewById(2131363113)).inflate();
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView = ((PkSeatView)paramView.findViewById(2131363309));
      this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.a();
      RelativeLayout.LayoutParams localLayoutParams;
      ViewGroup localViewGroup;
      int i;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.getParent();
        i = localViewGroup.indexOfChild(this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView);
        localViewGroup.addView(this.jdField_a_of_type_AndroidViewView, i + 1, localLayoutParams);
      }
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.b();
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.getParent();
        i = localViewGroup.indexOfChild(this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView);
        localViewGroup.addView(this.jdField_b_of_type_AndroidViewView, i + 2, localLayoutParams);
      }
      if (GameEngine.a().i())
      {
        b(paramView);
        if (GameEngine.a().j()) {
          a(GameEngine.a().a());
        }
      }
    }
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i = (int)(paramFloat1 - paramInt1 / 2);
    int j = (int)(paramFloat2 - paramInt2 / 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramView.getLayoutParams());
    localMarginLayoutParams.setMargins(i, j, paramInt1 + i, paramInt2 + j);
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
  
  private void a(boolean paramBoolean, String paramString)
  {
    Object localObject = GameEngine.a().a();
    int i = ((EngineData)localObject).t();
    boolean bool1 = ((EngineData)localObject).l();
    boolean bool2 = ((EngineData)localObject).g();
    String str;
    if (paramBoolean) {
      str = "0X800BA13";
    } else {
      str = "0X800BA11";
    }
    if ((bool2) && (((EngineData)localObject).f()))
    {
      localObject = "6";
    }
    else
    {
      if (!this.f) {
        break label81;
      }
      localObject = "7";
    }
    for (;;)
    {
      break;
      label81:
      if ((bool1) && (AvGameRoomListHandler.a(i) == 2)) {
        localObject = "1";
      } else if (((!bool1) && (AvGameRoomListHandler.b(i) == 3)) || ((bool1) && (AvGameRoomListHandler.a(i) == 3))) {
        localObject = "2";
      } else if ((!bool1) && (AvGameRoomListHandler.b(i) == 1)) {
        localObject = "3";
      } else if (((!bool1) && (AvGameRoomListHandler.b(i) == 2)) || ((bool1) && (AvGameRoomListHandler.a(i) == 4))) {
        localObject = "4";
      } else if ((bool1) && (i == 500)) {
        localObject = "5";
      } else {
        localObject = "0";
      }
    }
    if (this.f) {
      i = 1;
    } else {
      i = 2;
    }
    if (!paramBoolean) {
      paramString = "";
    }
    ReportController.b(null, "dc00898", "", "", str, str, i, 0, (String)localObject, paramString, "", "");
  }
  
  private boolean a(boolean paramBoolean)
  {
    int i;
    if ((GameEngine.a().f()) && (GameEngine.a().a().a() == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(paramBoolean);
      return true;
    }
    a(getString(2131690408), getString(2131690409), getString(2131690410), new GameRoomFragment.10(this), new GameRoomFragment.11(this), false);
    return true;
  }
  
  private void b(RectF paramRectF)
  {
    if (this.jdField_b_of_type_AndroidViewView$OnTouchListener == null) {
      ((GuideView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363190)).setHoleOnClick(new GameRoomFragment.7(this));
    }
  }
  
  private void b(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131363099)).inflate();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView = ((FestvialStageView)paramView.findViewById(2131363189));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363184));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363185));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = AVGameUtil.a("avgame_cj_house_full@2x.png");
    if (localObject != null)
    {
      float f3 = ((Bitmap)localObject).getWidth();
      float f4 = ((Bitmap)localObject).getHeight();
      float f1 = GameRoomViewLayoutParamsDef.Q;
      float f2 = GameRoomViewLayoutParamsDef.R;
      f3 = f4 / f3 * f1;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(f2 - f3));
      int i = (int)f3;
      ((RelativeLayout.LayoutParams)localObject).height = i;
      int j = (int)f1;
      ((RelativeLayout.LayoutParams)localObject).width = j;
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = i;
      ((RelativeLayout.LayoutParams)localObject).width = j;
      paramView = (RelativeLayout.LayoutParams)paramView.findViewById(2131363183).getLayoutParams();
      f2 = GameRoomViewLayoutParamsDef.jdField_a_of_type_Float / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float;
      f3 = GameRoomViewLayoutParamsDef.b / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float;
      i = (int)(GameRoomViewLayoutParamsDef.jdField_c_of_type_Float / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float * f1);
      paramView.width = i;
      paramView.height = i;
      paramView.leftMargin = ((int)(f3 * f1));
      paramView.bottomMargin = ((int)(f2 * f1));
    }
  }
  
  private void c(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131363101)).inflate();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363196));
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363195);
    Bitmap localBitmap = AVGameUtil.a("avgame_guide_bkg@2x.png");
    TextView localTextView = (TextView)paramView.findViewById(2131363311);
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
    paramView = (Button)paramView.findViewById(2131363194);
    paramView.setBackgroundDrawable(AVGameUtil.a(getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    paramView.setOnClickListener(this);
  }
  
  private void c(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (getQBaseActivity() != null)
        {
          int i = Build.VERSION.SDK_INT;
          if (i < 11)
          {
            ((android.text.ClipboardManager)getQBaseActivity().getSystemService("clipboard")).setText(paramString);
            return;
          }
          android.content.ClipboardManager localClipboardManager = (android.content.ClipboardManager)getQBaseActivity().getSystemService("clipboard");
          ClipboardMonitor.setText(localClipboardManager, paramString);
          localClipboardManager.setText(paramString);
          return;
        }
      }
      catch (Exception paramString)
      {
        QLog.e("GameRoomFragment", 2, "copyContent fail.", paramString);
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    EngineData localEngineData = GameEngine.a().a();
    int j = localEngineData.a();
    int i = 0;
    if (j == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      b(false);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      if (localEngineData.a() != null) {
        this.jdField_c_of_type_AndroidWidgetTextView.setText(localEngineData.a());
      } else {
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (j == 10) {
        i = 1;
      }
      b(i ^ 0x1);
    }
    if (localEngineData.f())
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.i(localEngineData);
    }
  }
  
  private boolean c()
  {
    if (GameEngine.a().a() == null) {
      return false;
    }
    this.f = ((AVGameAppInterface)GameEngine.a().a()).a().b();
    return !this.f;
  }
  
  private void d(View paramView)
  {
    if (!GameEngine.a().f())
    {
      if (GameEngine.a().a().a() != 0) {
        return;
      }
      Object localObject = GameEngine.a().a().getCurrentAccountUin();
      BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("av_game_sp");
      localStringBuilder.append((String)localObject);
      localObject = localBaseApplicationImpl.getSharedPreferences(localStringBuilder.toString(), 4);
      boolean bool1 = ((SharedPreferences)localObject).getBoolean("_b_show_guide_", false);
      boolean bool2 = ((SharedPreferences)localObject).getBoolean("_b_show_add_", false);
      if (!bool1)
      {
        ((SharedPreferences)localObject).edit().putBoolean("_b_show_guide_", true).apply();
        c(paramView);
        return;
      }
      if ((!bool2) && (GameEngine.a().a()) && (!GameEngine.a().e()))
      {
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null)
        {
          ((ViewStub)paramView.findViewById(2131363101)).inflate();
          this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363196));
        }
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.post(new GameRoomFragment.8(this, paramView));
        return;
      }
      m();
    }
  }
  
  private void e(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363195).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363194).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363311).setVisibility(8);
    a(getString(2131690314), new GameRoomFragment.9(this, paramView));
  }
  
  private void f(View paramView)
  {
    paramView = GameEngine.a().a().getCurrentAccountUin();
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("av_game_sp");
    localStringBuilder.append(paramView);
    ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4).edit().putBoolean("_b_show_add_", true).apply();
    l();
    paramView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363170);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.F;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.F;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363195).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363194).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363311).setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.b();
    if (localObject == null)
    {
      QLog.e("GameRoomFragment", 1, "seatViwe Rect get failed!");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    int i = GameRoomViewLayoutParamsDef.F;
    int j = GameRoomViewLayoutParamsDef.G;
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).centerY(), i, j);
    this.jdField_a_of_type_AndroidWidgetButton.setX(((RectF)localObject).left);
    this.jdField_a_of_type_AndroidWidgetButton.setY(((RectF)localObject).top);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690351));
    this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(new FrameLayout.LayoutParams(i, j));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetButton);
    paramView = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363171);
    i = paramView.getMeasuredWidth();
    j = paramView.getHeight();
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).top - AIOUtils.b(15.0F, getResources()), i, j);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void g(View paramView)
  {
    paramView = GameEngine.a().a().getCurrentAccountUin();
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("av_game_sp");
    ((StringBuilder)localObject2).append(paramView);
    ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363195).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363194).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363311).setVisibility(8);
    paramView = a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.findViewById(2131367484));
    if (paramView == null)
    {
      QLog.e("GameRoomFragment", 1, "gameMatchView Rect get failed!");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    localObject1 = new RectF(paramView);
    int i = GameRoomViewLayoutParamsDef.U;
    int j = GameRoomViewLayoutParamsDef.V;
    float f1 = ((RectF)localObject1).centerY();
    float f2 = j / 2;
    ((RectF)localObject1).top = (f1 - f2);
    ((RectF)localObject1).bottom = (((RectF)localObject1).centerY() + f2);
    f1 = ((RectF)localObject1).centerX();
    f2 = i / 2;
    ((RectF)localObject1).left = (f1 - f2);
    ((RectF)localObject1).right = (((RectF)localObject1).centerX() + f2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
    localObject2 = (GuideView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363190);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new HoleBean((RectF)localObject1, 1));
    ((GuideView)localObject2).setHoleList(localArrayList);
    ((GuideView)localObject2).a();
    b(paramView);
    localObject1 = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363191);
    i = ((RelativeLayout)localObject1).getMeasuredWidth();
    j = ((RelativeLayout)localObject1).getHeight();
    a((View)localObject1, paramView.centerX(), paramView.top - AIOUtils.b(15.0F, getResources()), i, j);
    paramView = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    paramView.width = -2;
    paramView.bottomMargin = 0;
    paramView.rightMargin = 0;
    ((RelativeLayout)localObject1).setLayoutParams(paramView);
  }
  
  private void i()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshCommonBlackTipView ,isShowingTransientTip");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
  }
  
  private void j()
  {
    Object localObject = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.jdField_a_of_type_Int;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.w;
    if (((RelativeLayout.LayoutParams)localObject).height > 0) {
      k();
    }
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.A;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.B;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setPadding(GameRoomViewLayoutParamsDef.C, 0, GameRoomViewLayoutParamsDef.D, 0);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setHorizontalSpacing(GameRoomViewLayoutParamsDef.E);
    localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.w;
    ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.z;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.y;
    int j = ViewUtils.b(2.0F);
    int i;
    if (((RelativeLayout.LayoutParams)localObject).topMargin > 0) {
      i = j;
    } else {
      i = 0;
    }
    ((RelativeLayout.LayoutParams)localObject).height += i + j;
    ((RelativeLayout.LayoutParams)localObject).topMargin -= i;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.setPadding(0, i, 0, j);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((SurvivalPkStageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.w;
      ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.z;
      ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.y;
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((PkSeatView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.J;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.a(65.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      localObject = this.jdField_a_of_type_AndroidViewView;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.J;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.a(65.0F);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      }
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.J;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.a(65.0F);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      }
    }
  }
  
  private void k()
  {
    Bitmap localBitmap = AVGameUtil.a("avgame_room_bg@2x.png");
    if (localBitmap != null)
    {
      int i = localBitmap.getWidth();
      Matrix localMatrix = new Matrix();
      float f1 = GameRoomViewLayoutParamsDef.jdField_d_of_type_Int / i;
      localMatrix.setScale(f1, f1);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageMatrix(localMatrix);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(getResources().getColor(2131165310));
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener == null)
    {
      this.jdField_a_of_type_AndroidViewView$OnTouchListener = new GameRoomFragment.5(this);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null)
    {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new GameRoomFragment.6(this);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
  }
  
  private void m()
  {
    if ((GameEngine.a().a()) && (!GameEngine.a().e())) {
      AVGameHandler.a().b().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 10000L);
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
    Object localObject = GameEngine.a().a().a();
    if (((RoomInfo)localObject).id != 0L)
    {
      localObject = new StringBuilder(AVGameUtil.a(((RoomInfo)localObject).id));
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
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      n();
    }
  }
  
  private void q()
  {
    boolean bool = c();
    int i = 2131690329;
    if (bool)
    {
      a(getString(2131690329), getString(2131690332), getString(2131690333), new GameRoomFragment.16(this), new GameRoomFragment.17(this), new GameRoomFragment.18(this), true);
    }
    else
    {
      localObject = DialogUtil.a(getActivity(), 230);
      if (localObject != null)
      {
        int j = GameEngine.a().a().a();
        if ((j == 0) || (j == 10)) {
          i = 2131690330;
        }
        ((QQCustomDialog)localObject).setMessage(i);
        GameRoomFragment.19 local19 = new GameRoomFragment.19(this);
        ((QQCustomDialog)localObject).setPositiveButton(2131694583, local19);
        ((QQCustomDialog)localObject).setNegativeButton(2131690728, local19);
        ((QQCustomDialog)localObject).show();
      }
    }
    if (GameEngine.a().a()) {
      i = 1;
    } else {
      i = 2;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(GameEngine.a().a().a());
    ReportController.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", ((StringBuilder)localObject).toString(), "", "");
    a(false, "0");
  }
  
  private void r()
  {
    s();
    QPublicFragmentActivity.start(getActivity(), AVGameRoomCenterFragment.class);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(false, 1);
    GameRoomViewLayoutParamsDef.H = 0;
    GameRoomViewLayoutParamsDef.I = 0;
    e();
  }
  
  public Activity a()
  {
    return getQBaseActivity();
  }
  
  void a()
  {
    if (this.jdField_a_of_type_AndroidAnimationAnimatorSet.isRunning()) {
      return;
    }
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_Boolean)) {
      c(true);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showToastTip toast:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" trace: ");
      QLog.i("GameRoomFragment", 2, localStringBuilder.toString(), new Throwable("not crash, rint stack"));
    }
    if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      AVGameHandler.a().b().post(new GameRoomFragment.13(this, paramInt, paramString));
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AVGameControlUI localAVGameControlUI = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localAVGameControlUI != null) {
      localAVGameControlUI.a(paramLong, paramInt, paramString1, paramString2);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStartTopRightCountDown called ,startOffsetDuration = ");
      ((StringBuilder)localObject).append(paramLong2);
      ((StringBuilder)localObject).append(",totalDuration = ");
      ((StringBuilder)localObject).append(paramLong1);
      QLog.d("GameRoomFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      n();
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new GameRoomFragment.12(this, paramLong1 - paramLong2, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
    b(true);
  }
  
  public void a(RectF paramRectF)
  {
    AVGameControlUI localAVGameControlUI = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localAVGameControlUI != null) {
      localAVGameControlUI.a(paramRectF);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onPkUpdateCJLogo ");
    }
    paramEngineData = AVGameUtil.a(paramEngineData.e(), paramEngineData.f(), null);
    Object localObject;
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramEngineData != null))
    {
      int i = (int)(GameRoomViewLayoutParamsDef.jdField_c_of_type_Float / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float * GameRoomViewLayoutParamsDef.Q);
      paramEngineData.setBounds(0, 0, i, i);
      localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363183);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      ((View)localObject).setBackgroundDrawable(paramEngineData);
    }
    paramEngineData = this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView;
    if ((paramEngineData instanceof FestvialStageView))
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter;
      if (localObject != null) {
        paramEngineData.a((IGameRoomPresenter)localObject);
      }
    }
  }
  
  public void a(GameActivityCenterEntry paramGameActivityCenterEntry)
  {
    Object localObject = this.jdField_d_of_type_AndroidViewView;
    if (localObject == null) {
      return;
    }
    ImageView localImageView1 = (ImageView)((View)localObject).findViewById(2131363176);
    ImageView localImageView2 = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363178);
    int i = 8;
    if ((paramGameActivityCenterEntry != null) && (paramGameActivityCenterEntry.a()))
    {
      localObject = getResources();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (TextUtils.isEmpty(paramGameActivityCenterEntry.jdField_a_of_type_JavaLangString))
      {
        localObject = ((Resources)localObject).getDrawable(2130838636);
      }
      else
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject).getDrawable(2130838636);
        localURLDrawableOptions.mFailedDrawable = ((Resources)localObject).getDrawable(2130838636);
        localURLDrawableOptions.mRequestWidth = ((Resources)localObject).getDimensionPixelSize(2131296609);
        localURLDrawableOptions.mRequestHeight = ((Resources)localObject).getDimensionPixelSize(2131296608);
        localObject = URLDrawable.getDrawable(paramGameActivityCenterEntry.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
      }
      localImageView1.setImageDrawable((Drawable)localObject);
      localImageView1.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (paramGameActivityCenterEntry.b()) {
        i = 0;
      }
      localImageView2.setVisibility(i);
      ReportController.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
      return;
    }
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    localImageView1.setOnClickListener(null);
    localImageView2.setVisibility(8);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowTransientTip tip = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isShowingTransientTip");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    if (this.jdField_c_of_type_Boolean) {
      ThreadManager.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowTransientTip delay ,tip");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", delayMs");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isShowingTransientTip");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_JavaLangString = paramString;
    AVGameHandler.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    AVGameHandler.a().b().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramInt);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    a(paramString, paramOnClickListener, true);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    a(paramString, getString(2131690280), null, paramOnClickListener, null, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, boolean paramBoolean)
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      AVGameHandler.a().b().post(new GameRoomFragment.15(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramOnClickListener3, paramBoolean));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()) && (!TextUtils.isEmpty(paramString1)))
    {
      AVGameHandler.a().b().post(new GameRoomFragment.14(this, paramString1, paramOnClickListener2, paramString2, paramString3, paramOnClickListener1, paramBoolean));
      return;
    }
    QLog.e("GameRoomFragment", 1, "showDialogTip err", new Throwable("not crash, print stack"));
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    AVGameControlUI localAVGameControlUI = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localAVGameControlUI != null) {
      localAVGameControlUI.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setStartMatchWhenEnterRoom ");
      localStringBuilder.append(paramBoolean);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return a(false);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    AVGameControlUI localAVGameControlUI = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localAVGameControlUI != null) {
      return localAVGameControlUI.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    c(false);
    b(true);
    if (GameEngine.a().a().f()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    } else {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    if (GameEngine.a().f()) {
      ReportController.b(null, "dc00898", "", "", "0X800B8C2", "0X800B8C2", 0, 0, "", "", "", "");
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHidePermanentTip ,isShowingTransientTip");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = "";
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowPermanentTip tip = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isShowingTransientTip");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    i();
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSetTopRightCountDownContent content = ");
      localStringBuilder.append(paramString);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onShowTopRightCountDownView show = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("GameRoomFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
    int j = 0;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((TextView)localObject).setVisibility(i);
    localObject = this.jdField_a_of_type_ComTencentWidgetRoundRectImageView;
    if (paramBoolean) {
      i = j;
    } else {
      i = 8;
    }
    ((RoundRectImageView)localObject).setVisibility(i);
    if (paramBoolean) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c()
  {
    c(false);
    p();
    b(false);
    if (a() != null) {
      a().showResult();
    }
  }
  
  public void d()
  {
    c(false);
    if (a() != null) {
      a().showRoom();
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomFragment", 2, "finishActivity trace: ", new Throwable("not crash, print stack"));
    }
    if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()))
    {
      getQBaseActivity().finish();
      return;
    }
    QLog.d("GameRoomFragment", 2, "finishActivity aready finished!");
  }
  
  public void f()
  {
    if (a() != null) {
      a().notifyExitGamed();
    }
  }
  
  public void g()
  {
    ThreadManager.a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_c_of_type_Boolean = false;
    i();
  }
  
  public View getView()
  {
    return super.getView();
  }
  
  public void h()
  {
    RelativeLayout localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363194: 
    case 2131363311: 
      e(paramView);
      if (paramView.getId() == 2131363194) {
        ReportController.b(null, "dc00898", "", "", "0X800B0A5", "0X800B0A5", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800B0A4", "0X800B0A4", 0, 0, "", "", "", "");
      }
      break;
    case 2131363180: 
      q();
      break;
    case 2131363175: 
      a(false);
      break;
    case 2131363170: 
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GlobalExitRoomDialog.a().jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558664, null);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onCreateView");
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("GameRoomFragment", 1, "avideo onDestroy");
    if ((a() != null) && (!a().isExitByFinish()))
    {
      QLog.i("GameRoomFragment", 1, "doOnDestroy exit not by Finished");
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(true);
    }
    Object localObject = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      n();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c();
    long l = QQAudioHelper.b();
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localObject != null)
    {
      ((AVGameControlUI)localObject).d(l);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI = null;
    }
    this.jdField_a_of_type_Boolean = false;
    AVGameHandler.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    AVGameHandler.a().b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    GlobalExitRoomDialog.a().jdField_a_of_type_Boolean = false;
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView;
    if (localObject != null)
    {
      ((GameListView)localObject).c();
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.d();
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
      paramView = ((LayoutInflater)getQBaseActivity().getSystemService("layout_inflater")).inflate(2131558695, null, false);
      paramView.measure(0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
      paramView.setOnClickListener(new GameRoomFragment.20(this));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new GameRoomFragment.21(this));
      int i = (this.jdField_b_of_type_AndroidWidgetTextView.getMeasuredWidth() - ViewUtils.a(90.0F)) / 2;
      int j = -ViewUtils.a(4.0F);
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
    AVGameControlUI localAVGameControlUI = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localAVGameControlUI != null) {
      localAVGameControlUI.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    long l = QQAudioHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo life_onResume, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("GameRoomFragment", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
    if (localObject != null)
    {
      ((GLRootView)localObject).onResume();
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.requestRender();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localObject != null) {
      ((AVGameControlUI)localObject).b(l);
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_d_of_type_AndroidViewView;
      if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
        ReportController.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
      }
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onStart()
  {
    super.onStart();
    long l = QQAudioHelper.b();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo life_onStart, seq[");
    ((StringBuilder)localObject).append(l);
    ((StringBuilder)localObject).append("]");
    QLog.w("GameRoomFragment", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localObject != null) {
      ((AVGameControlUI)localObject).a(l);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    c(true);
  }
  
  public void onStop()
  {
    super.onStop();
    long l = QQAudioHelper.b();
    Object localObject = this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView;
    if (localObject != null) {
      ((GLRootView)localObject).onPause();
    }
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (localObject != null) {
      ((AVGameControlUI)localObject).c(l);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onViewCreated");
    }
    GameRoomViewLayoutParamsDef.a(getQBaseActivity(), GameEngine.a().f());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView = ((VideoGLView)paramView.findViewById(2131363326));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView = ((GameListView)paramView.findViewById(2131363193));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView = ((BaseStageView)paramView.findViewById(2131363310));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView = ((SeatView)paramView.findViewById(2131363309));
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView = ((OverlayView)paramView.findViewById(2131363245));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363323);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363304));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363299));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363292));
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131363177);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363187));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131363796));
    float f1 = AIOUtils.b(12.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode((int)f1, 1);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setBackgroundColor(16777215);
    b(false);
    a(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363175));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363180));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)paramView.findViewById(2131363326));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363186));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = GameRoomViewLayoutParamsDef.S;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367446));
    this.jdField_a_of_type_AndroidWidgetButton = new Button(getQBaseActivity());
    paramBundle = getQBaseActivity();
    if ((paramBundle instanceof IAVGameRootContainer)) {
      if (((IAVGameRootContainer)paramBundle).isNewEnter())
      {
        this.jdField_b_of_type_Boolean = false;
        if ((!GameEngine.a().a()) && (!GameEngine.a().e())) {
          this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getViewTreeObserver().addOnGlobalLayoutListener(new GameRoomFragment.4(this));
        }
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
      }
    }
    paramBundle = (AVGameAppInterface)getQBaseActivity().getAppRuntime();
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderOnTop(true);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderMediaOverlay(true);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer = new AVGameBusinessVideoLayer(getQBaseActivity(), paramBundle);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI = new AVGameControlUIImpl(paramBundle, getQBaseActivity(), (ViewGroup)paramView);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer);
    a(paramView);
    if (this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter == null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = new GameRoomPresenterImp(this);
    }
    IGameRoomPresenter localIGameRoomPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter;
    QBaseActivity localQBaseActivity = getQBaseActivity();
    IGameListPresenter localIGameListPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a();
    IStagePresenter localIStagePresenter = this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.a();
    paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView;
    if (paramBundle != null) {
      paramBundle = paramBundle.a();
    } else {
      paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
    }
    IOverlayPresenter localIOverlayPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a();
    AVGameControlUI localAVGameControlUI = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    IStageRecordPresenter localIStageRecordPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.a();
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView;
    if (localObject != null) {
      localObject = ((SurvivalPkStageView)localObject).a();
    } else {
      localObject = null;
    }
    localIGameRoomPresenter.a(localQBaseActivity, localIGameListPresenter, localIStagePresenter, paramBundle, localIOverlayPresenter, localAVGameControlUI, localIStageRecordPresenter, (ISurvivalStagePresenter)localObject);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
    if (paramBundle != null) {
      paramBundle.a();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter, this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI);
    paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView;
    if ((paramBundle instanceof NormalStageView)) {
      paramBundle.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView;
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    }
    paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView;
    if (paramBundle != null) {
      paramBundle.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
    o();
    j();
    FloatWindowController.a().c();
    d(paramView);
    this.jdField_a_of_type_Boolean = true;
    if (!GameEngine.a().f()) {
      ReportController.b(null, "dc00898", "", "", "0X800B8AF", "0X800B8AF", AVGameUtil.e(), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment
 * JD-Core Version:    0.7.0.1
 */