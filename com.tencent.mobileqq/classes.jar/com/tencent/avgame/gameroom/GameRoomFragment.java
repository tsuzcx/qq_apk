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
  Runnable A = new GameRoomFragment.2(this);
  Runnable B = new GameRoomFragment.3(this);
  private ImageView C;
  private RelativeLayout D;
  private TextView E;
  private String F;
  private RelativeLayout.LayoutParams G;
  private String H;
  private boolean I;
  private boolean J = false;
  private boolean K = false;
  private Button L;
  private QQCustomDialog M;
  private boolean N;
  private GLRootView O;
  private AVGameBusinessVideoLayer P;
  private AVGameControlUI Q;
  private RelativeLayout R = null;
  private View.OnTouchListener S = null;
  private View.OnTouchListener T = null;
  private View.OnClickListener U = null;
  private View.OnClickListener V = new GameRoomFragment.22(this);
  protected IGameRoomPresenter a;
  protected VideoGLView b;
  protected GameListView c;
  protected BaseStageView d;
  protected SurvivalPkStageView e;
  protected PkSeatView f;
  protected View g;
  protected View h;
  protected SeatView i;
  protected OverlayView j;
  protected View k;
  protected TextView l;
  protected TextView m;
  protected TextView n;
  protected TextView o;
  protected ImageView p;
  protected RoundRectImageView q;
  protected AutoBgImageView r;
  protected AutoBgImageView s;
  protected View t;
  protected boolean u = false;
  AnimatorSet v;
  boolean w;
  CountDownTimer x;
  PopupWindow y;
  Runnable z = new GameRoomFragment.1(this);
  
  public static GameRoomFragment a()
  {
    GameRoomFragment localGameRoomFragment = new GameRoomFragment();
    localGameRoomFragment.setArguments(new Bundle());
    localGameRoomFragment.a = new GameRoomPresenterImp(localGameRoomFragment);
    return localGameRoomFragment;
  }
  
  private void a(View paramView)
  {
    if (GameEngine.a().A())
    {
      ((ViewStub)paramView.findViewById(2131428967)).inflate();
      this.e = ((SurvivalPkStageView)paramView.findViewById(2131429120));
      ((ViewStub)paramView.findViewById(2131428966)).inflate();
      this.f = ((PkSeatView)paramView.findViewById(2131429183));
      this.d.setVisibility(8);
      this.i.setVisibility(8);
      this.g = this.f.getMemberItemRootTop();
      RelativeLayout.LayoutParams localLayoutParams;
      ViewGroup localViewGroup;
      int i1;
      if (this.g != null)
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localViewGroup = (ViewGroup)this.f.getParent();
        i1 = localViewGroup.indexOfChild(this.f);
        localViewGroup.addView(this.g, i1 + 1, localLayoutParams);
      }
      this.h = this.f.getCheerRootTop();
      if ((this.h != null) && (this.g != null))
      {
        localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localViewGroup = (ViewGroup)this.f.getParent();
        i1 = localViewGroup.indexOfChild(this.f);
        localViewGroup.addView(this.h, i1 + 2, localLayoutParams);
      }
      if (GameEngine.a().D())
      {
        b(paramView);
        if (GameEngine.a().E()) {
          a(GameEngine.a().s());
        }
      }
    }
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    int i1 = (int)(paramFloat1 - paramInt1 / 2);
    int i2 = (int)(paramFloat2 - paramInt2 / 2);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(paramView.getLayoutParams());
    localMarginLayoutParams.setMargins(i1, i2, paramInt1 + i1, paramInt2 + i2);
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(localMarginLayoutParams));
    paramView.setVisibility(0);
  }
  
  private void a(RoundRectImageView paramRoundRectImageView)
  {
    if (this.v != null) {
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
    this.v = new AnimatorSet();
    this.v.play(localObjectAnimator1).with(localObjectAnimator2).with(paramRoundRectImageView);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    Object localObject = GameEngine.a().s();
    int i1 = ((EngineData)localObject).ak();
    boolean bool1 = ((EngineData)localObject).al();
    boolean bool2 = ((EngineData)localObject).N();
    String str;
    if (paramBoolean) {
      str = "0X800BA13";
    } else {
      str = "0X800BA11";
    }
    if ((bool2) && (((EngineData)localObject).M()))
    {
      localObject = "6";
    }
    else
    {
      if (!this.N) {
        break label81;
      }
      localObject = "7";
    }
    for (;;)
    {
      break;
      label81:
      if ((bool1) && (AvGameRoomListHandler.a(i1) == 2)) {
        localObject = "1";
      } else if (((!bool1) && (AvGameRoomListHandler.b(i1) == 3)) || ((bool1) && (AvGameRoomListHandler.a(i1) == 3))) {
        localObject = "2";
      } else if ((!bool1) && (AvGameRoomListHandler.b(i1) == 1)) {
        localObject = "3";
      } else if (((!bool1) && (AvGameRoomListHandler.b(i1) == 2)) || ((bool1) && (AvGameRoomListHandler.a(i1) == 4))) {
        localObject = "4";
      } else if ((bool1) && (i1 == 500)) {
        localObject = "5";
      } else {
        localObject = "0";
      }
    }
    if (this.N) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (!paramBoolean) {
      paramString = "";
    }
    ReportController.b(null, "dc00898", "", "", str, str, i1, 0, (String)localObject, paramString, "", "");
  }
  
  private void b(RectF paramRectF)
  {
    if (this.T == null) {
      ((GuideView)this.R.findViewById(2131429064)).setHoleOnClick(new GameRoomFragment.7(this));
    }
  }
  
  private void b(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131428952)).inflate();
    this.d = ((FestvialStageView)paramView.findViewById(2131429063));
    this.d.setVisibility(8);
    this.C = ((ImageView)paramView.findViewById(2131429058));
    this.C.setVisibility(0);
    this.D = ((RelativeLayout)paramView.findViewById(2131429059));
    this.D.setVisibility(0);
    Object localObject = AVGameUtil.c("avgame_cj_house_full@2x.png");
    if (localObject != null)
    {
      float f3 = ((Bitmap)localObject).getWidth();
      float f4 = ((Bitmap)localObject).getHeight();
      float f1 = GameRoomViewLayoutParamsDef.Q;
      float f2 = GameRoomViewLayoutParamsDef.R;
      f3 = f4 / f3 * f1;
      this.C.setImageBitmap((Bitmap)localObject);
      localObject = (RelativeLayout.LayoutParams)this.D.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(f2 - f3));
      int i1 = (int)f3;
      ((RelativeLayout.LayoutParams)localObject).height = i1;
      int i2 = (int)f1;
      ((RelativeLayout.LayoutParams)localObject).width = i2;
      localObject = (RelativeLayout.LayoutParams)this.C.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).height = i1;
      ((RelativeLayout.LayoutParams)localObject).width = i2;
      paramView = (RelativeLayout.LayoutParams)paramView.findViewById(2131429057).getLayoutParams();
      f2 = GameRoomViewLayoutParamsDef.S / GameRoomViewLayoutParamsDef.V;
      f3 = GameRoomViewLayoutParamsDef.T / GameRoomViewLayoutParamsDef.V;
      i1 = (int)(GameRoomViewLayoutParamsDef.U / GameRoomViewLayoutParamsDef.V * f1);
      paramView.width = i1;
      paramView.height = i1;
      paramView.leftMargin = ((int)(f3 * f1));
      paramView.bottomMargin = ((int)(f2 * f1));
    }
  }
  
  private void c(View paramView)
  {
    ((ViewStub)paramView.findViewById(2131428954)).inflate();
    this.R = ((RelativeLayout)paramView.findViewById(2131429070));
    ImageView localImageView = (ImageView)this.R.findViewById(2131429069);
    Bitmap localBitmap = AVGameUtil.c("avgame_guide_bkg@2x.png");
    TextView localTextView = (TextView)paramView.findViewById(2131429185);
    localTextView.setVisibility(0);
    localTextView.setOnClickListener(this);
    if (localBitmap != null) {
      localImageView.setImageBitmap(localBitmap);
    }
    paramView = (Button)paramView.findViewById(2131429068);
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
          int i1 = Build.VERSION.SDK_INT;
          if (i1 < 11)
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
    EngineData localEngineData = GameEngine.a().s();
    int i2 = localEngineData.j();
    int i1 = 0;
    if (i2 == 0)
    {
      this.l.setVisibility(0);
      this.m.setVisibility(0);
      this.n.setVisibility(8);
      b(false);
    }
    else
    {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      if (localEngineData.f() != null) {
        this.n.setText(localEngineData.g());
      } else {
        this.n.setVisibility(8);
      }
      if (i2 == 10) {
        i1 = 1;
      }
      b(i1 ^ 0x1);
    }
    if (localEngineData.M())
    {
      this.l.setVisibility(8);
      this.m.setVisibility(8);
      this.n.setVisibility(8);
    }
    if (paramBoolean) {
      this.a.i(localEngineData);
    }
  }
  
  private void d(View paramView)
  {
    if (!GameEngine.a().A())
    {
      if (GameEngine.a().s().j() != 0) {
        return;
      }
      Object localObject = GameEngine.a().f().getCurrentAccountUin();
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
      if ((!bool2) && (GameEngine.a().d()) && (!GameEngine.a().v()))
      {
        if (this.R == null)
        {
          ((ViewStub)paramView.findViewById(2131428954)).inflate();
          this.R = ((RelativeLayout)paramView.findViewById(2131429070));
        }
        this.R.post(new GameRoomFragment.8(this, paramView));
        return;
      }
      r();
    }
  }
  
  private boolean d(boolean paramBoolean)
  {
    int i1;
    if ((GameEngine.a().A()) && (GameEngine.a().s().j() == 0)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      this.a.a(paramBoolean);
      return true;
    }
    a(getString(2131887319), getString(2131887320), getString(2131887321), new GameRoomFragment.10(this), new GameRoomFragment.11(this), false);
    return true;
  }
  
  private void e(View paramView)
  {
    this.R.findViewById(2131429069).setVisibility(8);
    this.R.findViewById(2131429068).setVisibility(8);
    this.R.findViewById(2131429185).setVisibility(8);
    a(getString(2131887225), new GameRoomFragment.9(this, paramView));
  }
  
  private void f(View paramView)
  {
    paramView = GameEngine.a().f().getCurrentAccountUin();
    Object localObject = BaseApplicationImpl.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("av_game_sp");
    localStringBuilder.append(paramView);
    ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 4).edit().putBoolean("_b_show_add_", true).apply();
    q();
    paramView = this.R.findViewById(2131429044);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.F;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.F;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.R.findViewById(2131429069).setVisibility(8);
    this.R.findViewById(2131429068).setVisibility(8);
    this.R.findViewById(2131429185).setVisibility(8);
    localObject = this.i.getAddMemberViewRect();
    if (localObject == null)
    {
      QLog.e("GameRoomFragment", 1, "seatViwe Rect get failed!");
      this.R.setVisibility(8);
      return;
    }
    int i1 = GameRoomViewLayoutParamsDef.F;
    int i2 = GameRoomViewLayoutParamsDef.G;
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).centerY(), i1, i2);
    this.L.setX(((RectF)localObject).left);
    this.L.setY(((RectF)localObject).top);
    this.L.setContentDescription(getString(2131887262));
    this.L.setLayoutParams(new FrameLayout.LayoutParams(i1, i2));
    this.L.setBackgroundColor(0);
    this.R.addView(this.L);
    paramView = (RelativeLayout)this.R.findViewById(2131429045);
    i1 = paramView.getMeasuredWidth();
    i2 = paramView.getHeight();
    a(paramView, ((RectF)localObject).centerX(), ((RectF)localObject).top - AIOUtils.b(15.0F, getResources()), i1, i2);
    localObject = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = 0;
    ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  private void g(View paramView)
  {
    paramView = GameEngine.a().f().getCurrentAccountUin();
    Object localObject1 = BaseApplicationImpl.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("av_game_sp");
    ((StringBuilder)localObject2).append(paramView);
    ((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 4);
    this.R.findViewById(2131429069).setVisibility(8);
    this.R.findViewById(2131429068).setVisibility(8);
    this.R.findViewById(2131429185).setVisibility(8);
    paramView = h(this.c.findViewById(2131433993));
    if (paramView == null)
    {
      QLog.e("GameRoomFragment", 1, "gameMatchView Rect get failed!");
      this.R.setVisibility(8);
      return;
    }
    localObject1 = new RectF(paramView);
    int i1 = GameRoomViewLayoutParamsDef.Y;
    int i2 = GameRoomViewLayoutParamsDef.Z;
    float f1 = ((RectF)localObject1).centerY();
    float f2 = i2 / 2;
    ((RectF)localObject1).top = (f1 - f2);
    ((RectF)localObject1).bottom = (((RectF)localObject1).centerY() + f2);
    f1 = ((RectF)localObject1).centerX();
    f2 = i1 / 2;
    ((RectF)localObject1).left = (f1 - f2);
    ((RectF)localObject1).right = (((RectF)localObject1).centerX() + f2);
    this.R.setBackgroundColor(Color.argb(0, 0, 0, 0));
    localObject2 = (GuideView)this.R.findViewById(2131429064);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new HoleBean((RectF)localObject1, 1));
    ((GuideView)localObject2).setHoleList(localArrayList);
    ((GuideView)localObject2).a();
    b(paramView);
    localObject1 = (RelativeLayout)this.R.findViewById(2131429065);
    i1 = ((RelativeLayout)localObject1).getMeasuredWidth();
    i2 = ((RelativeLayout)localObject1).getHeight();
    a((View)localObject1, paramView.centerX(), paramView.top - AIOUtils.b(15.0F, getResources()), i1, i2);
    paramView = (RelativeLayout.LayoutParams)((RelativeLayout)localObject1).getLayoutParams();
    paramView.width = -2;
    paramView.bottomMargin = 0;
    paramView.rightMargin = 0;
    ((RelativeLayout)localObject1).setLayoutParams(paramView);
  }
  
  private RectF h(View paramView)
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
  
  private void n()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshCommonBlackTipView ,isShowingTransientTip");
      localStringBuilder.append(this.I);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.F);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(this.F))
    {
      this.E.setVisibility(8);
      return;
    }
    this.E.setVisibility(0);
    this.E.setText(this.F);
  }
  
  private void o()
  {
    Object localObject = (RelativeLayout.LayoutParams)this.k.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.a;
    this.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.c;
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)this.p.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.w;
    if (((RelativeLayout.LayoutParams)localObject).height > 0) {
      p();
    }
    localObject = (RelativeLayout.LayoutParams)this.i.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.A;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.B;
    this.i.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.i.setVerticalScrollBarEnabled(false);
    this.i.setPadding(GameRoomViewLayoutParamsDef.C, 0, GameRoomViewLayoutParamsDef.D, 0);
    this.i.setHorizontalSpacing(GameRoomViewLayoutParamsDef.E);
    localObject = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.w;
    ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.z;
    ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.y;
    int i2 = ViewUtils.dpToPx(2.0F);
    int i1;
    if (((RelativeLayout.LayoutParams)localObject).topMargin > 0) {
      i1 = i2;
    } else {
      i1 = 0;
    }
    ((RelativeLayout.LayoutParams)localObject).height += i1 + i2;
    ((RelativeLayout.LayoutParams)localObject).topMargin -= i1;
    this.d.setPadding(0, i1, 0, i2);
    this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = this.e;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((SurvivalPkStageView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.w;
      ((RelativeLayout.LayoutParams)localObject).width = GameRoomViewLayoutParamsDef.z;
      ((RelativeLayout.LayoutParams)localObject).height = GameRoomViewLayoutParamsDef.y;
    }
    localObject = this.f;
    if (localObject != null)
    {
      localObject = (RelativeLayout.LayoutParams)((PkSeatView)localObject).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.J;
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.dip2px(65.0F);
      ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
      ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      localObject = this.g;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.J;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.dip2px(65.0F);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      }
      localObject = this.h;
      if (localObject != null)
      {
        localObject = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).topMargin = GameRoomViewLayoutParamsDef.J;
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = ViewUtils.dip2px(65.0F);
        ((RelativeLayout.LayoutParams)localObject).addRule(10, -1);
        ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
      }
    }
  }
  
  private void p()
  {
    Bitmap localBitmap = AVGameUtil.c("avgame_room_bg@2x.png");
    if (localBitmap != null)
    {
      int i1 = localBitmap.getWidth();
      Matrix localMatrix = new Matrix();
      float f1 = GameRoomViewLayoutParamsDef.d / i1;
      localMatrix.setScale(f1, f1);
      this.p.setImageMatrix(localMatrix);
      this.p.setImageBitmap(localBitmap);
      return;
    }
    this.p.setBackgroundColor(getResources().getColor(2131165546));
  }
  
  private void q()
  {
    if (this.S == null)
    {
      this.S = new GameRoomFragment.5(this);
      this.R.setOnTouchListener(this.S);
    }
    if (this.U == null)
    {
      this.U = new GameRoomFragment.6(this);
      this.L.setOnClickListener(this.U);
    }
  }
  
  private void r()
  {
    if ((GameEngine.a().d()) && (!GameEngine.a().v())) {
      AVGameHandler.a().c().postDelayed(this.B, 10000L);
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "resetBreath");
    }
    this.v.cancel();
    this.q.setBackgroundColor(16777215);
    this.q.setScaleX(1.0F);
    this.q.setScaleY(1.0F);
  }
  
  private void t()
  {
    Object localObject = GameEngine.a().s().e();
    if (((RoomInfo)localObject).id != 0L)
    {
      localObject = new StringBuilder(AVGameUtil.a(((RoomInfo)localObject).id));
      if (((StringBuilder)localObject).length() == 9)
      {
        ((StringBuilder)localObject).insert(6, "-");
        ((StringBuilder)localObject).insert(3, "-");
      }
      this.m.setText(((StringBuilder)localObject).toString());
    }
  }
  
  private void u()
  {
    CountDownTimer localCountDownTimer = this.x;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      s();
    }
  }
  
  private void v()
  {
    boolean bool = y();
    int i1 = 2131887240;
    if (bool)
    {
      a(getString(2131887240), getString(2131887243), getString(2131887244), new GameRoomFragment.16(this), new GameRoomFragment.17(this), new GameRoomFragment.18(this), true);
    }
    else
    {
      localObject = DialogUtil.a(getActivity(), 230);
      if (localObject != null)
      {
        int i2 = GameEngine.a().s().j();
        if ((i2 == 0) || (i2 == 10)) {
          i1 = 2131887241;
        }
        ((QQCustomDialog)localObject).setMessage(i1);
        GameRoomFragment.19 local19 = new GameRoomFragment.19(this);
        ((QQCustomDialog)localObject).setPositiveButton(2131892267, local19);
        ((QQCustomDialog)localObject).setNegativeButton(2131887648, local19);
        ((QQCustomDialog)localObject).show();
      }
    }
    if (GameEngine.a().d()) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(GameEngine.a().s().i());
    ReportController.b(null, "dc00898", "", "", "0X800B02F", "0X800B02F", i1, 0, "", ((StringBuilder)localObject).toString(), "", "");
    a(false, "0");
  }
  
  private void w()
  {
    x();
    QPublicFragmentActivity.start(getActivity(), AVGameRoomCenterFragment.class);
  }
  
  private void x()
  {
    this.a.a(false, 1);
    GameRoomViewLayoutParamsDef.H = 0;
    GameRoomViewLayoutParamsDef.I = 0;
    i();
  }
  
  private boolean y()
  {
    if (GameEngine.a().s() == null) {
      return false;
    }
    this.N = ((AVGameAppInterface)GameEngine.a().f()).a().d();
    return !this.N;
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (this.u)) {
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
      AVGameHandler.a().c().post(new GameRoomFragment.13(this, paramInt, paramString));
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    AVGameControlUI localAVGameControlUI = this.Q;
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
    Object localObject = this.x;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      s();
    }
    this.x = new GameRoomFragment.12(this, paramLong1 - paramLong2, 1000L);
    this.x.start();
    b(true);
  }
  
  public void a(RectF paramRectF)
  {
    AVGameControlUI localAVGameControlUI = this.Q;
    if (localAVGameControlUI != null) {
      localAVGameControlUI.a(paramRectF);
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onPkUpdateCJLogo ");
    }
    paramEngineData = AVGameUtil.a(paramEngineData.ad(), paramEngineData.ae(), null);
    Object localObject;
    if ((this.D != null) && (paramEngineData != null))
    {
      int i1 = (int)(GameRoomViewLayoutParamsDef.U / GameRoomViewLayoutParamsDef.V * GameRoomViewLayoutParamsDef.Q);
      paramEngineData.setBounds(0, 0, i1, i1);
      localObject = this.D.findViewById(2131429057);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((View)localObject).getLayoutParams();
      localLayoutParams.width = i1;
      localLayoutParams.height = i1;
      ((View)localObject).setBackgroundDrawable(paramEngineData);
    }
    paramEngineData = this.d;
    if ((paramEngineData instanceof FestvialStageView))
    {
      localObject = this.a;
      if (localObject != null) {
        paramEngineData.a((IGameRoomPresenter)localObject);
      }
    }
  }
  
  public void a(GameActivityCenterEntry paramGameActivityCenterEntry)
  {
    Object localObject = this.t;
    if (localObject == null) {
      return;
    }
    ImageView localImageView1 = (ImageView)((View)localObject).findViewById(2131429050);
    ImageView localImageView2 = (ImageView)this.t.findViewById(2131429052);
    int i1 = 8;
    if ((paramGameActivityCenterEntry != null) && (paramGameActivityCenterEntry.a()))
    {
      localObject = getResources();
      this.t.setVisibility(0);
      this.t.setOnClickListener(this.V);
      if (TextUtils.isEmpty(paramGameActivityCenterEntry.b))
      {
        localObject = ((Resources)localObject).getDrawable(2130838765);
      }
      else
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Resources)localObject).getDrawable(2130838765);
        localURLDrawableOptions.mFailedDrawable = ((Resources)localObject).getDrawable(2130838765);
        localURLDrawableOptions.mRequestWidth = ((Resources)localObject).getDimensionPixelSize(2131296911);
        localURLDrawableOptions.mRequestHeight = ((Resources)localObject).getDimensionPixelSize(2131296910);
        localObject = URLDrawable.getDrawable(paramGameActivityCenterEntry.b, localURLDrawableOptions);
      }
      localImageView1.setImageDrawable((Drawable)localObject);
      localImageView1.setOnClickListener(this.V);
      if (paramGameActivityCenterEntry.b()) {
        i1 = 0;
      }
      localImageView2.setVisibility(i1);
      ReportController.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
      return;
    }
    this.t.setVisibility(8);
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
      localStringBuilder.append(this.I);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.F);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    if (this.I) {
      ThreadManager.a().removeCallbacks(this.z);
    }
    this.E.setText(paramString);
    this.E.setVisibility(0);
    this.I = true;
    ThreadManager.a().postDelayed(this.z, 3000L);
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
      localStringBuilder.append(this.I);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.F);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.H = paramString;
    AVGameHandler.a().c().removeCallbacks(this.A);
    AVGameHandler.a().c().postDelayed(this.A, paramInt);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    a(paramString, paramOnClickListener, true);
  }
  
  public void a(String paramString, DialogInterface.OnClickListener paramOnClickListener, boolean paramBoolean)
  {
    a(paramString, getString(2131887191), null, paramOnClickListener, null, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, DialogInterface.OnClickListener paramOnClickListener3, boolean paramBoolean)
  {
    if (getActivity() != null)
    {
      if (getActivity().isFinishing()) {
        return;
      }
      AVGameHandler.a().c().post(new GameRoomFragment.15(this, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2, paramOnClickListener3, paramBoolean));
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2, boolean paramBoolean)
  {
    if ((getQBaseActivity() != null) && (!getQBaseActivity().isFinishing()) && (!TextUtils.isEmpty(paramString1)))
    {
      AVGameHandler.a().c().post(new GameRoomFragment.14(this, paramString1, paramOnClickListener2, paramString2, paramString3, paramOnClickListener1, paramBoolean));
      return;
    }
    QLog.e("GameRoomFragment", 1, "showDialogTip err", new Throwable("not crash, print stack"));
  }
  
  public void a(List<MemberVideoDisplayInfo> paramList)
  {
    AVGameControlUI localAVGameControlUI = this.Q;
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
    this.K = paramBoolean;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    AVGameControlUI localAVGameControlUI = this.Q;
    if (localAVGameControlUI != null) {
      return localAVGameControlUI.a(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  void b()
  {
    if (this.v.isRunning()) {
      return;
    }
    this.v.start();
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onHidePermanentTip ,isShowingTransientTip");
      localStringBuilder.append(this.I);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.F);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.F = "";
    if (this.I) {
      return;
    }
    n();
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowPermanentTip tip = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isShowingTransientTip");
      localStringBuilder.append(this.I);
      localStringBuilder.append(",permanentTipString");
      localStringBuilder.append(this.F);
      QLog.d("GameRoomFragment", 2, localStringBuilder.toString());
    }
    this.F = paramString;
    if (this.I) {
      return;
    }
    n();
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
    this.o.setText(paramString);
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
    Object localObject = this.o;
    int i2 = 0;
    int i1;
    if (paramBoolean) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    ((TextView)localObject).setVisibility(i1);
    localObject = this.q;
    if (paramBoolean) {
      i1 = i2;
    } else {
      i1 = 8;
    }
    ((RoundRectImageView)localObject).setVisibility(i1);
    if (paramBoolean) {
      this.n.setVisibility(8);
    }
  }
  
  public boolean c()
  {
    return false;
  }
  
  public Activity d()
  {
    return getQBaseActivity();
  }
  
  public boolean e()
  {
    return d(false);
  }
  
  public void f()
  {
    c(false);
    b(true);
    if (GameEngine.a().s().M()) {
      this.n.setVisibility(8);
    } else {
      this.n.setVisibility(0);
    }
    if (GameEngine.a().A()) {
      ReportController.b(null, "dc00898", "", "", "0X800B8C2", "0X800B8C2", 0, 0, "", "", "", "");
    }
  }
  
  public void g()
  {
    c(false);
    u();
    b(false);
    if (m() != null) {
      m().showResult();
    }
  }
  
  public View getView()
  {
    return super.getView();
  }
  
  public void h()
  {
    c(false);
    if (m() != null) {
      m().showRoom();
    }
  }
  
  public void i()
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
  
  public void j()
  {
    if (m() != null) {
      m().notifyExitGamed();
    }
  }
  
  public void k()
  {
    ThreadManager.a().removeCallbacks(this.z);
    this.I = false;
    n();
  }
  
  public void l()
  {
    RelativeLayout localRelativeLayout = this.R;
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
    case 2131429068: 
    case 2131429185: 
      e(paramView);
      if (paramView.getId() == 2131429068) {
        ReportController.b(null, "dc00898", "", "", "0X800B0A5", "0X800B0A5", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800B0A4", "0X800B0A4", 0, 0, "", "", "", "");
      }
      break;
    case 2131429054: 
      v();
      break;
    case 2131429049: 
      d(false);
      break;
    case 2131429044: 
      this.R.setVisibility(8);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GlobalExitRoomDialog.a().a = true;
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onCreate");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131624281, null);
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
    if ((m() != null) && (!m().isExitByFinish()))
    {
      QLog.i("GameRoomFragment", 1, "doOnDestroy exit not by Finished");
      this.a.a(true);
    }
    Object localObject = this.x;
    if (localObject != null)
    {
      ((CountDownTimer)localObject).cancel();
      s();
    }
    this.a.c();
    long l1 = QQAudioHelper.d();
    localObject = this.Q;
    if (localObject != null)
    {
      ((AVGameControlUI)localObject).d(l1);
      this.Q = null;
    }
    this.u = false;
    AVGameHandler.a().c().removeCallbacks(this.A);
    AVGameHandler.a().c().removeCallbacks(this.B);
    GlobalExitRoomDialog.a().a = false;
    localObject = this.c;
    if (localObject != null)
    {
      ((GameListView)localObject).c();
      this.c.d();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.y != null) {
      return true;
    }
    try
    {
      paramView = ((LayoutInflater)getQBaseActivity().getSystemService("layout_inflater")).inflate(2131624312, null, false);
      paramView.measure(0, 0);
      this.y = new PopupWindow(paramView);
      this.y.setHeight(-2);
      this.y.setWidth(-2);
      this.y.setOutsideTouchable(true);
      this.y.setFocusable(false);
      paramView.setOnClickListener(new GameRoomFragment.20(this));
      this.y.setOnDismissListener(new GameRoomFragment.21(this));
      int i1 = (this.m.getMeasuredWidth() - ViewUtils.dip2px(90.0F)) / 2;
      int i2 = -ViewUtils.dip2px(4.0F);
      this.y.showAsDropDown(this.m, i1, i2);
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
    AVGameControlUI localAVGameControlUI = this.Q;
    if (localAVGameControlUI != null) {
      localAVGameControlUI.c();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    long l1 = QQAudioHelper.d();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo life_onResume, seq[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("]");
    QLog.w("GameRoomFragment", 1, ((StringBuilder)localObject).toString());
    localObject = this.O;
    if (localObject != null)
    {
      ((GLRootView)localObject).onResume();
      this.O.requestRender();
    }
    localObject = this.Q;
    if (localObject != null) {
      ((AVGameControlUI)localObject).b(l1);
    }
    if (this.J)
    {
      localObject = this.t;
      if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
        ReportController.b(null, "dc00898", "", "", "0X800B519", "0X800B519", 0, 0, "", "", "", "");
      }
    }
    this.J = true;
  }
  
  public void onStart()
  {
    super.onStart();
    long l1 = QQAudioHelper.d();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("avideo life_onStart, seq[");
    ((StringBuilder)localObject).append(l1);
    ((StringBuilder)localObject).append("]");
    QLog.w("GameRoomFragment", 1, ((StringBuilder)localObject).toString());
    localObject = this.Q;
    if (localObject != null) {
      ((AVGameControlUI)localObject).a(l1);
    }
    this.a.a();
    c(true);
  }
  
  public void onStop()
  {
    super.onStop();
    long l1 = QQAudioHelper.d();
    Object localObject = this.O;
    if (localObject != null) {
      ((GLRootView)localObject).onPause();
    }
    localObject = this.Q;
    if (localObject != null) {
      ((AVGameControlUI)localObject).c(l1);
    }
    this.a.b();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("GameRoomFragment", 2, "onViewCreated");
    }
    GameRoomViewLayoutParamsDef.a(getQBaseActivity(), GameEngine.a().A());
    this.b = ((VideoGLView)paramView.findViewById(2131429200));
    this.c = ((GameListView)paramView.findViewById(2131429067));
    this.d = ((BaseStageView)paramView.findViewById(2131429184));
    this.i = ((SeatView)paramView.findViewById(2131429183));
    this.j = ((OverlayView)paramView.findViewById(2131429119));
    this.k = paramView.findViewById(2131429197);
    this.l = ((TextView)paramView.findViewById(2131429178));
    this.m = ((TextView)paramView.findViewById(2131429173));
    this.n = ((TextView)paramView.findViewById(2131429166));
    this.t = paramView.findViewById(2131429051);
    this.o = ((TextView)paramView.findViewById(2131429061));
    this.q = ((RoundRectImageView)paramView.findViewById(2131429729));
    float f1 = AIOUtils.b(12.0F, getResources());
    this.q.setCornerRadiusAndMode((int)f1, 1);
    this.q.setBackgroundColor(16777215);
    b(false);
    a(this.q);
    this.r = ((AutoBgImageView)paramView.findViewById(2131429049));
    this.s = ((AutoBgImageView)paramView.findViewById(2131429054));
    this.O = ((GLRootView)paramView.findViewById(2131429200));
    this.l.setOnLongClickListener(this);
    this.m.setOnLongClickListener(this);
    this.E = ((TextView)paramView.findViewById(2131429060));
    this.G = ((RelativeLayout.LayoutParams)this.E.getLayoutParams());
    this.G.topMargin = GameRoomViewLayoutParamsDef.W;
    this.p = ((ImageView)paramView.findViewById(2131433949));
    this.L = new Button(getQBaseActivity());
    paramBundle = getQBaseActivity();
    if ((paramBundle instanceof IAVGameRootContainer)) {
      if (((IAVGameRootContainer)paramBundle).isNewEnter())
      {
        this.w = false;
        if ((!GameEngine.a().d()) && (!GameEngine.a().v())) {
          this.i.getViewTreeObserver().addOnGlobalLayoutListener(new GameRoomFragment.4(this));
        }
      }
      else
      {
        this.w = true;
      }
    }
    paramBundle = (AVGameAppInterface)getQBaseActivity().getAppRuntime();
    this.O.setZOrderOnTop(true);
    this.O.setZOrderMediaOverlay(true);
    this.P = new AVGameBusinessVideoLayer(getQBaseActivity(), paramBundle);
    this.O.setContentPane(this.P);
    this.Q = new AVGameControlUIImpl(paramBundle, getQBaseActivity(), (ViewGroup)paramView);
    this.Q.a(this.P);
    a(paramView);
    if (this.a == null) {
      this.a = new GameRoomPresenterImp(this);
    }
    IGameRoomPresenter localIGameRoomPresenter = this.a;
    QBaseActivity localQBaseActivity = getQBaseActivity();
    IGameListPresenter localIGameListPresenter = this.c.getPresenter();
    IStagePresenter localIStagePresenter = this.d.getPresenter();
    paramBundle = this.f;
    if (paramBundle != null) {
      paramBundle = paramBundle.getPresenter();
    } else {
      paramBundle = this.i.getPresenter();
    }
    IOverlayPresenter localIOverlayPresenter = this.j.getPresenter();
    AVGameControlUI localAVGameControlUI = this.Q;
    IStageRecordPresenter localIStageRecordPresenter = this.P.A();
    Object localObject = this.e;
    if (localObject != null) {
      localObject = ((SurvivalPkStageView)localObject).getPresenter();
    } else {
      localObject = null;
    }
    localIGameRoomPresenter.a(localQBaseActivity, localIGameListPresenter, localIStagePresenter, paramBundle, localIOverlayPresenter, localAVGameControlUI, localIStageRecordPresenter, (ISurvivalStagePresenter)localObject);
    this.P.a(this.d.getPresenter());
    this.Q.a(this.a);
    paramBundle = this.Q;
    if (paramBundle != null) {
      paramBundle.b();
    }
    this.b.a(this.a);
    this.c.a(this.a, this.Q);
    paramBundle = this.d;
    if ((paramBundle instanceof NormalStageView)) {
      paramBundle.a(this.a);
    }
    this.i.a(this.a);
    this.j.a(this.a);
    paramBundle = this.f;
    if (paramBundle != null) {
      paramBundle.a(this.a);
    }
    paramBundle = this.e;
    if (paramBundle != null) {
      paramBundle.a(this.a);
    }
    this.r.setOnClickListener(this);
    this.s.setOnClickListener(this);
    t();
    o();
    FloatWindowController.c().d();
    d(paramView);
    this.u = true;
    if (!GameEngine.a().A()) {
      ReportController.b(null, "dc00898", "", "", "0X800B8AF", "0X800B8AF", AVGameUtil.e(), 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.GameRoomFragment
 * JD-Core Version:    0.7.0.1
 */