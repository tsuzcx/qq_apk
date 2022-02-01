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
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameActivityCenterEntry;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.avgame.gamelogic.globalmanage.GlobalExitRoomDialog;
import com.tencent.avgame.gameroom.festivalstage.FestvialStageView;
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
import com.tencent.avgame.gameroom.video.AVGameBusinessVideoLayer;
import com.tencent.avgame.gameroom.video.AVGameControlUI;
import com.tencent.avgame.gameroom.video.AVGameControlUIImpl;
import com.tencent.avgame.gameroom.video.VideoGLView;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.AVGameHandler;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.avgame.ui.GameBaseFragment;
import com.tencent.avgame.ui.GuideView;
import com.tencent.avgame.ui.HoleBean;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.AutoBgImageView;
import com.tencent.qav.thread.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
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
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new GameRoomFragment.21(this);
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
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("should_restore_from_kill", false);
    localGameRoomFragment.setArguments(localBundle);
    localGameRoomFragment.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter = new GameRoomPresenterImp(localGameRoomFragment);
    return localGameRoomFragment;
  }
  
  private void a(View paramView)
  {
    if (GameEngine.a().f())
    {
      ((ViewStub)paramView.findViewById(2131363174)).inflate();
      this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView = ((SurvivalPkStageView)paramView.findViewById(2131363314));
      ((ViewStub)paramView.findViewById(2131363173)).inflate();
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView = ((PkSeatView)paramView.findViewById(2131363377));
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
  
  private void a(boolean paramBoolean, String paramString)
  {
    int i = 1;
    Object localObject = GameEngine.a().a();
    int j = ((EngineData)localObject).t();
    boolean bool1 = ((EngineData)localObject).l();
    boolean bool2 = ((EngineData)localObject).g();
    String str;
    if (paramBoolean)
    {
      str = "0X800BA13";
      if ((!bool2) || (!((EngineData)localObject).f())) {
        break label106;
      }
      localObject = "6";
      label58:
      if (!this.f) {
        break label266;
      }
      label65:
      if (!paramBoolean) {
        break label271;
      }
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", str, str, i, 0, (String)localObject, paramString, "", "");
      return;
      str = "0X800BA11";
      break;
      label106:
      if (this.f)
      {
        localObject = "7";
        break label58;
      }
      if ((bool1) && (AvGameRoomListHandler.a(j) == 2))
      {
        localObject = "1";
        break label58;
      }
      if (((!bool1) && (AvGameRoomListHandler.b(j) == 3)) || ((bool1) && (AvGameRoomListHandler.a(j) == 3)))
      {
        localObject = "2";
        break label58;
      }
      if ((!bool1) && (AvGameRoomListHandler.b(j) == 1))
      {
        localObject = "3";
        break label58;
      }
      if (((!bool1) && (AvGameRoomListHandler.b(j) == 2)) || ((bool1) && (AvGameRoomListHandler.a(j) == 4)))
      {
        localObject = "4";
        break label58;
      }
      if ((bool1) && (j == 500))
      {
        localObject = "5";
        break label58;
      }
      localObject = "0";
      break label58;
      label266:
      i = 2;
      break label65;
      label271:
      paramString = "";
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    if ((GameEngine.a().f()) && (GameEngine.a().a().a() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(paramBoolean);
      return true;
    }
    a(getString(2131690484), getString(2131690485), getString(2131690486), null, new GameRoomFragment.10(this), false);
    return true;
  }
  
  private void b(RectF paramRectF)
  {
    if (this.jdField_b_of_type_AndroidViewView$OnTouchListener == null) {
      ((GuideView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363258)).setHoleOnClick(new GameRoomFragment.7(this));
    }
  }
  
  private void b(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131363159)).inflate();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView = ((FestvialStageView)paramView.findViewById(2131363257));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131363252));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363253));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = AVGameUtils.a("avgame_cj_house_full@2x.png");
    if (localObject != null)
    {
      float f3 = ((Bitmap)localObject).getWidth();
      float f4 = ((Bitmap)localObject).getHeight();
      float f1 = GameRoomViewLayoutParamsDef.F;
      float f2 = GameRoomViewLayoutParamsDef.G;
      f3 = f4 / f3 * f1;
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(f2 - f3));
      ((RelativeLayout.LayoutParams)localObject).height = ((int)f3);
      ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
      localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = ((int)f3);
      ((RelativeLayout.LayoutParams)localObject).width = ((int)f1);
      paramView = (RelativeLayout.LayoutParams)paramView.findViewById(2131363251).getLayoutParams();
      f2 = GameRoomViewLayoutParamsDef.jdField_a_of_type_Float / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float;
      f3 = GameRoomViewLayoutParamsDef.b / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float;
      f4 = GameRoomViewLayoutParamsDef.jdField_c_of_type_Float / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float;
      paramView.width = ((int)(f4 * f1));
      paramView.height = ((int)(f4 * f1));
      paramView.leftMargin = ((int)(f3 * f1));
      paramView.bottomMargin = ((int)(f2 * f1));
    }
  }
  
  private void c(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131363161)).inflate();
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363264));
    ImageView localImageView = (ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363263);
    Bitmap localBitmap = AVGameUtils.a("avgame_guide_bkg@2x.png");
    TextView localTextView = (TextView)paramView.findViewById(2131363379);
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
    paramView = (Button)paramView.findViewById(2131363262);
    paramView.setBackgroundDrawable(AVGameUtils.a(getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    paramView.setOnClickListener(this);
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
  
  private void c(boolean paramBoolean)
  {
    boolean bool = true;
    EngineData localEngineData = GameEngine.a().a();
    int i = localEngineData.a();
    if (i == 0)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      b(false);
      if (localEngineData.f())
      {
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.i(localEngineData);
      }
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (localEngineData.a() != null)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setText(localEngineData.a());
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
      b(bool);
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
  
  private boolean c()
  {
    if (GameEngine.a().a() == null) {}
    do
    {
      return false;
      this.f = GameEngine.a().a().a().b();
    } while (this.f);
    return true;
  }
  
  private void d(View paramView)
  {
    if (GameEngine.a().f()) {
      return;
    }
    Object localObject = GameEngine.a().a().getCurrentAccountUin();
    localObject = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + (String)localObject, 4);
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
        ((ViewStub)paramView.findViewById(2131363161)).inflate();
        this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131363264));
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.post(new GameRoomFragment.8(this, paramView));
      return;
    }
    m();
  }
  
  private void e(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363263).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363262).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363379).setVisibility(8);
    a(getString(2131690390), new GameRoomFragment.9(this, paramView));
  }
  
  private void f(View paramView)
  {
    paramView = GameEngine.a().a().getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + paramView, 4).edit().putBoolean("_b_show_add_", true).apply();
    l();
    paramView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363238);
    Object localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.u;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.u;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363263).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363262).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363379).setVisibility(8);
    localObject = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.b();
    if (localObject == null)
    {
      QLog.e("GameRoomFragment", 1, "seatViwe Rect get failed!");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    int i = GameRoomViewLayoutParamsDef.u;
    int j = GameRoomViewLayoutParamsDef.v;
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).centerY(), i, j);
    this.jdField_a_of_type_AndroidWidgetButton.setX(((RectF)localObject).left);
    this.jdField_a_of_type_AndroidWidgetButton.setY(((RectF)localObject).top);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(getString(2131690427));
    this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(new FrameLayout.LayoutParams(i, j));
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundColor(0);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetButton);
    paramView = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363239);
    i = paramView.getMeasuredWidth();
    j = paramView.getHeight();
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).top - AIOUtils.a(15.0F, getResources()), i, j);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void g(View paramView)
  {
    paramView = GameEngine.a().a().getCurrentAccountUin();
    BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp" + paramView, 4);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363263).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363262).setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363379).setVisibility(8);
    paramView = a(this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.findViewById(2131367727));
    if (paramView == null)
    {
      QLog.e("GameRoomFragment", 1, "gameMatchView Rect get failed!");
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject = new RectF(paramView);
    int i = GameRoomViewLayoutParamsDef.J;
    int j = GameRoomViewLayoutParamsDef.K;
    ((RectF)localObject).top = (((RectF)localObject).centerY() - j / 2);
    float f1 = ((RectF)localObject).centerY();
    ((RectF)localObject).bottom = (j / 2 + f1);
    ((RectF)localObject).left = (((RectF)localObject).centerX() - i / 2);
    f1 = ((RectF)localObject).centerX();
    ((RectF)localObject).right = (i / 2 + f1);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundColor(Color.argb(0, 0, 0, 0));
    GuideView localGuideView = (GuideView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363258);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new HoleBean((RectF)localObject, 1));
    localGuideView.setHoleList(localArrayList);
    localGuideView.a();
    b(paramView);
    localObject = (RelativeLayout)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131363259);
    i = ((RelativeLayout)localObject).getMeasuredWidth();
    j = ((RelativeLayout)localObject).getHeight();
    a((View)localObject, paramView.centerX(), paramView.top - AIOUtils.a(15.0F, getResources()), i, j);
    paramView = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    paramView.width = -2;
    paramView.bottomMargin = 0;
    paramView.rightMargin = 0;
    ((RelativeLayout)localObject).setLayoutParams(paramView);
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "refreshCommonBlackTipView ,isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
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
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.jdField_a_of_type_Int;
    this.jdField_c_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.getLayoutParams();
    localLayoutParams.height = GameRoomViewLayoutParamsDef.jdField_c_of_type_Int;
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    localLayoutParams.height = GameRoomViewLayoutParamsDef.l;
    if (localLayoutParams.height > 0) {
      k();
    }
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getLayoutParams();
    localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.p;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.q;
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setPadding(GameRoomViewLayoutParamsDef.r, 0, GameRoomViewLayoutParamsDef.s, 0);
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.setHorizontalSpacing(GameRoomViewLayoutParamsDef.t);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.getLayoutParams();
    localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.l;
    localLayoutParams.width = GameRoomViewLayoutParamsDef.o;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.n;
    int j = ViewUtils.b(2.0F);
    if (localLayoutParams.topMargin > 0) {}
    for (int i = j;; i = 0)
    {
      localLayoutParams.height += i + j;
      localLayoutParams.topMargin -= i;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.setPadding(0, i, 0, j);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.setLayoutParams(localLayoutParams);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView.getLayoutParams();
        localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.l;
        localLayoutParams.width = GameRoomViewLayoutParamsDef.o;
        localLayoutParams.height = GameRoomViewLayoutParamsDef.n;
      }
      if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView != null)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.getLayoutParams();
        localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.y;
        localLayoutParams.bottomMargin = ViewUtils.a(65.0F);
        localLayoutParams.addRule(10, -1);
        localLayoutParams.addRule(12, -1);
        if (this.jdField_a_of_type_AndroidViewView != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.y;
          localLayoutParams.bottomMargin = ViewUtils.a(65.0F);
          localLayoutParams.addRule(10, -1);
          localLayoutParams.addRule(12, -1);
        }
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
          localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.y;
          localLayoutParams.bottomMargin = ViewUtils.a(65.0F);
          localLayoutParams.addRule(10, -1);
          localLayoutParams.addRule(12, -1);
        }
      }
      return;
    }
  }
  
  private void k()
  {
    Bitmap localBitmap = AVGameUtils.a("avgame_room_bg@2x.png");
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
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundColor(getResources().getColor(2131165344));
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
      localObject = new StringBuilder(AVGameUtils.a(((RoomInfo)localObject).id));
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
    int i = 2131690405;
    if (c())
    {
      a(getString(2131690405), getString(2131690408), getString(2131690409), new GameRoomFragment.15(this), new GameRoomFragment.16(this), new GameRoomFragment.17(this), true);
      if (!GameEngine.a().a()) {
        break label221;
      }
    }
    label221:
    for (i = 1;; i = 2)
    {
      ReportController.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i, 0, "", "" + GameEngine.a().a().a(), "", "");
      a(false, "0");
      return;
      QQCustomDialog localQQCustomDialog = DialogUtil.a(getActivity(), 230);
      if (localQQCustomDialog == null) {
        break;
      }
      int j = GameEngine.a().a().a();
      if ((j == 0) || (j == 10)) {
        i = 2131690406;
      }
      localQQCustomDialog.setMessage(i);
      GameRoomFragment.18 local18 = new GameRoomFragment.18(this);
      localQQCustomDialog.setPositiveButton(2131694615, local18);
      localQQCustomDialog.setNegativeButton(2131690800, local18);
      localQQCustomDialog.show();
      break;
    }
  }
  
  private void r()
  {
    s();
    PublicFragmentActivity.a(getActivity(), AVGameRoomCenterFragment.class);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(false, 1);
    GameRoomViewLayoutParamsDef.w = 0;
    GameRoomViewLayoutParamsDef.x = 0;
    e();
  }
  
  public Activity a()
  {
    return getActivity();
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
    if (QLog.isColorLevel()) {
      QLog.i("GameRoomFragment", 2, "showToastTip toast:" + paramString + " trace: ", new Throwable("not crash, rint stack"));
    }
    if ((getActivity() == null) || (getActivity().isFinishing()) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    AVGameHandler.a().b().post(new GameRoomFragment.12(this, paramInt, paramString));
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(paramLong, paramInt, paramString1, paramString2);
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
    this.jdField_a_of_type_AndroidOsCountDownTimer = new GameRoomFragment.11(this, paramLong1 - paramLong2, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
    b(true);
  }
  
  public void a(RectF paramRectF)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(paramRectF);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onPkUpdateCJLogo ");
    }
    paramEngineData = AVGameUtils.a(paramEngineData.e(), paramEngineData.f(), null);
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (paramEngineData != null))
    {
      int i = (int)(GameRoomViewLayoutParamsDef.jdField_c_of_type_Float / GameRoomViewLayoutParamsDef.jdField_d_of_type_Float * GameRoomViewLayoutParamsDef.F);
      paramEngineData.setBounds(0, 0, i, i);
      View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363251);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.width = i;
      localLayoutParams.height = i;
      localView.setBackgroundDrawable(paramEngineData);
    }
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView instanceof FestvialStageView)) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
    }
  }
  
  public void a(GameActivityCenterEntry paramGameActivityCenterEntry)
  {
    if (this.jdField_d_of_type_AndroidViewView == null) {
      return;
    }
    ImageView localImageView1 = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363244);
    ImageView localImageView2 = (ImageView)this.jdField_d_of_type_AndroidViewView.findViewById(2131363246);
    if ((paramGameActivityCenterEntry != null) && (paramGameActivityCenterEntry.a()))
    {
      Object localObject = getResources();
      this.jdField_d_of_type_AndroidViewView.setVisibility(0);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
      if (TextUtils.isEmpty(paramGameActivityCenterEntry.jdField_a_of_type_JavaLangString))
      {
        localObject = ((Resources)localObject).getDrawable(2130838841);
        localImageView1.setImageDrawable((Drawable)localObject);
        localImageView1.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
        if (!paramGameActivityCenterEntry.b()) {
          break label221;
        }
      }
      label221:
      for (int i = 0;; i = 8)
      {
        localImageView2.setVisibility(i);
        ReportController.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
        return;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject).getDrawable(2130838841);
        localURLDrawableOptions.mFailedDrawable = ((Resources)localObject).getDrawable(2130838841);
        localURLDrawableOptions.mRequestWidth = ((Resources)localObject).getDimensionPixelSize(2131296630);
        localURLDrawableOptions.mRequestHeight = ((Resources)localObject).getDimensionPixelSize(2131296629);
        localObject = URLDrawable.getDrawable(paramGameActivityCenterEntry.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        break;
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTransientTip tip = " + paramString + ",isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
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
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onShowTransientTip delay ,tip" + paramString + ", delayMs" + paramInt + ",isShowingTransientTip" + this.jdField_c_of_type_Boolean + ",permanentTipString" + this.jdField_a_of_type_JavaLangString);
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
    a(paramString, getString(2131690357), null, paramOnClickListener, null, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, boolean paramBoolean)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    AVGameHandler.a().b().post(new GameRoomFragment.14(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramOnClickListener3, paramBoolean));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    if ((getActivity() == null) || (getActivity().isFinishing())) {
      return;
    }
    AVGameHandler.a().b().post(new GameRoomFragment.13(this, paramString1, paramOnClickListener2, paramString2, paramString3, paramOnClickListener1, paramBoolean));
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "setStartMatchWhenEnterRoom " + paramBoolean);
    }
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return a(false);
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      return this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void b()
  {
    c(false);
    b(true);
    if (GameEngine.a().a().f()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    for (;;)
    {
      if (GameEngine.a().f()) {
        ReportController.b(null, "dc00898", "", "", "0X800B8C2", "0X800B8C2", 0, 0, "", "", "", "");
      }
      return;
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
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
  
  public void b(boolean paramBoolean)
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
      a().c();
    }
  }
  
  public void d()
  {
    c(false);
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
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
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
      a(false);
      continue;
      q();
      continue;
      e(paramView);
      if (paramView.getId() == 2131363262)
      {
        ReportController.b(null, "dc00898", "", "", "0X800B0A5", "0X800B0A5", 0, 0, "", "", "", "");
      }
      else
      {
        ReportController.b(null, "dc00898", "", "", "0X800B0A4", "0X800B0A4", 0, 0, "", "", "", "");
        continue;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
    }
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131558765, null);
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
    if ((a() != null) && (!a().b()))
    {
      QLog.i("GameRoomFragment", 1, "doOnDestroy exit not by Finished");
      this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a(true);
    }
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      n();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.c();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.d(l);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI = null;
    }
    this.jdField_a_of_type_Boolean = false;
    AVGameHandler.a().b().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    AVGameHandler.a().b().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    GlobalExitRoomDialog.a().jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView != null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.c();
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
      paramView = ((LayoutInflater)getActivity().getSystemService("layout_inflater")).inflate(2131558796, null, false);
      paramView.measure(0, 0);
      this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(paramView);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setHeight(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setWidth(-2);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(false);
      paramView.setOnClickListener(new GameRoomFragment.19(this));
      this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(new GameRoomFragment.20(this));
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
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.b();
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
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.b(l);
    }
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_d_of_type_AndroidViewView.getVisibility() == 0)) {
      ReportController.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onStart()
  {
    super.onStart();
    long l = AudioHelper.b();
    QLog.w("GameRoomFragment", 1, "avideo life_onStart, seq[" + l + "]");
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(l);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.a();
    c(true);
  }
  
  public void onStop()
  {
    super.onStop();
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView != null) {
      this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.onPause();
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.c(l);
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter.b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onViewCreated");
    }
    GameRoomViewLayoutParamsDef.a(getActivity());
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView = ((VideoGLView)paramView.findViewById(2131363394));
    this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView = ((GameListView)paramView.findViewById(2131363261));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView = ((BaseStageView)paramView.findViewById(2131363378));
    this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView = ((SeatView)paramView.findViewById(2131363377));
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView = ((OverlayView)paramView.findViewById(2131363313));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131363391);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363372));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363367));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363360));
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131363245);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363255));
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView = ((RoundRectImageView)paramView.findViewById(2131363868));
    float f1 = AIOUtils.a(12.0F, getResources());
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setCornerRadiusAndMode((int)f1, 1);
    this.jdField_a_of_type_ComTencentWidgetRoundRectImageView.setBackgroundColor(16777215);
    b(false);
    a(this.jdField_a_of_type_ComTencentWidgetRoundRectImageView);
    this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363243));
    this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView = ((AutoBgImageView)paramView.findViewById(2131363248));
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView = ((GLRootView)paramView.findViewById(2131363394));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnLongClickListener(this);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363254));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_e_of_type_AndroidWidgetTextView.getLayoutParams());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = GameRoomViewLayoutParamsDef.H;
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131367693));
    this.jdField_a_of_type_AndroidWidgetButton = new Button(getActivity());
    paramBundle = getActivity();
    if ((paramBundle instanceof AVGameActivity))
    {
      if (!((AVGameActivity)paramBundle).c()) {
        break label849;
      }
      this.jdField_b_of_type_Boolean = false;
      if ((!GameEngine.a().a()) && (!GameEngine.a().e())) {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.getViewTreeObserver().addOnGlobalLayoutListener(new GameRoomFragment.4(this));
      }
    }
    paramBundle = (AVGameAppInterface)getActivity().getAppRuntime();
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderOnTop(true);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setZOrderMediaOverlay(true);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer = new AVGameBusinessVideoLayer(getActivity(), paramBundle);
    this.jdField_a_of_type_ComTencentAvOpenglUiGLRootView.setContentPane(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI = new AVGameControlUIImpl(paramBundle, getActivity(), (ViewGroup)paramView);
    this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer);
    a(paramView);
    IGameRoomPresenter localIGameRoomPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter;
    FragmentActivity localFragmentActivity = getActivity();
    IGameListPresenter localIGameListPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a();
    IStagePresenter localIStagePresenter = this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.a();
    label558:
    IOverlayPresenter localIOverlayPresenter;
    AVGameControlUI localAVGameControlUI;
    IStageRecordPresenter localIStageRecordPresenter;
    if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView != null)
    {
      paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.a();
      localIOverlayPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a();
      localAVGameControlUI = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI;
      localIStageRecordPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.a();
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView == null) {
        break label868;
      }
    }
    label849:
    label868:
    for (ISurvivalStagePresenter localISurvivalStagePresenter = this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView.a();; localISurvivalStagePresenter = null)
    {
      localIGameRoomPresenter.a(localFragmentActivity, localIGameListPresenter, localIStagePresenter, paramBundle, localIOverlayPresenter, localAVGameControlUI, localIStageRecordPresenter, localISurvivalStagePresenter);
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameBusinessVideoLayer.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.a());
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI.a();
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomVideoVideoGLView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
      this.jdField_a_of_type_ComTencentAvgameGameroomGamelistGameListView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter, this.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameControlUI);
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView instanceof NormalStageView)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageBaseBaseStageView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
      this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
      if (this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomSeatPkSeatView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
      }
      if (this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView != null) {
        this.jdField_a_of_type_ComTencentAvgameGameroomPkstageSurvivalPkStageView.a(this.jdField_a_of_type_ComTencentAvgameGameroomIGameRoomPresenter);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      this.jdField_b_of_type_ComTencentMobileqqWidgetAutoBgImageView.setOnClickListener(this);
      o();
      j();
      FloatWindowController.a().c();
      d(paramView);
      this.jdField_a_of_type_Boolean = true;
      if (!GameEngine.a().f()) {
        ReportController.b(null, "dc00898", "", "", "0X800B8AF", "0X800B8AF", AVGameUtils.e(), 0, "", "", "", "");
      }
      return;
      this.jdField_b_of_type_Boolean = true;
      break;
      paramBundle = this.jdField_a_of_type_ComTencentAvgameGameroomSeatSeatView.a();
      break label558;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment
 * JD-Core Version:    0.7.0.1
 */