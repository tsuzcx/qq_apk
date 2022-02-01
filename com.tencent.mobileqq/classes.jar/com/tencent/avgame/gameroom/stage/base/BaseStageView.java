package com.tencent.avgame.gameroom.stage.base;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.IStageRecordPresenter;
import com.tencent.avgame.gameroom.stage.IStageView;
import com.tencent.avgame.gameroom.stage.guessaction.BaseGuessActionStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView;
import com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView;
import com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView;
import com.tencent.avgame.gameroom.stage.util.IBaseCountDownClockView;
import com.tencent.avgame.qav.videorecord.IGameVideoRecordPresenterWrapper;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.widget.RoundedCornerImageViewNoPadding;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class BaseStageView
  extends CoverRoundCornerRelativeLayout
  implements IStageView
{
  protected ImageView A;
  protected LottieDrawable B;
  protected View C;
  protected UserInfoHandler D;
  protected RelativeLayout E;
  protected RoundedCornerImageViewNoPadding F;
  boolean G;
  long H;
  long I;
  long J;
  private Runnable j = new BaseStageView.1(this);
  protected IStagePresenter p;
  protected IStageRecordPresenter q;
  protected BaseGuessActionStageView r;
  protected BaseGuessStarStageView s;
  protected BaseGuessPictureStageView t;
  protected BaseGuessSongStageView u;
  protected BaseGuessTextStageView v;
  protected LottieDrawable w;
  protected ImageView x;
  protected RelativeLayout y;
  protected RelativeLayout z;
  
  public BaseStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doGamePrepareCountDownAnim useTransparentBg = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",duration = ");
      ((StringBuilder)localObject).append(paramLong1);
      ((StringBuilder)localObject).append(",startOffset = ");
      ((StringBuilder)localObject).append(paramLong2);
      QLog.d("BaseStageView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.y.getParent() != null) {
      removeView(this.y);
    }
    if (paramBoolean)
    {
      localObject = this.p.a().r();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.y.setBackgroundDrawable(URLDrawable.getDrawable((String)localObject));
      }
    }
    else
    {
      localObject = this.p.a().s();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.y.setBackgroundDrawable(URLDrawable.getDrawable((String)localObject));
      } else {
        this.y.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
      }
    }
    addView(this.y);
    if (this.w.isAnimating()) {
      this.w.endAnimation();
    }
    if (paramLong1 > 0L) {
      f = 6000.0F / (float)paramLong1;
    } else {
      f = 1.0F;
    }
    this.w.setSpeed(f);
    this.x.setImageDrawable(this.w);
    Object localObject = this.w;
    float f = 0.0F;
    ((LottieDrawable)localObject).setProgress(0.0F);
    if (paramLong1 > 0L) {
      f = (float)paramLong2 * 1.0F / (float)paramLong1;
    }
    this.w.setMinProgress(f);
    this.w.playAnimation();
  }
  
  private void f()
  {
    AVGameLottieHelper.a(getContext(), "avgame_5s_count_down/data.json", "avgame_5s_count_down/images/", 200, 200, new BaseStageView.4(this));
    AVGameLottieHelper.a(getContext(), "avgame_game_over/data.json", "avgame_game_over/images/", 200, 200, new BaseStageView.5(this));
  }
  
  private void g()
  {
    if (this.J == 0L) {
      return;
    }
    long l2 = System.currentTimeMillis();
    long l3 = this.J;
    long l1 = this.H;
    l2 = l3 + (l1 - this.I) - l2;
    if (l2 <= 0L) {
      return;
    }
    l1 -= l2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryRecover5sCountDownAnim startOffset = ");
      localStringBuilder.append(l1);
      localStringBuilder.append(",duration = ");
      localStringBuilder.append(this.H);
      QLog.d("BaseStageView", 2, localStringBuilder.toString());
    }
    b(this.G, this.H, l1);
    this.J = 0L;
  }
  
  private Drawable getGameOverCardDrawable()
  {
    GameItem localGameItem = GameEngine.a().s().f();
    if ((localGameItem != null) && (!TextUtils.isEmpty(localGameItem.j))) {
      return URLDrawable.getDrawable(localGameItem.j);
    }
    return AvGameResDownloadUtil.a("avgame_game_over@2x.png");
  }
  
  private void h()
  {
    this.z.setVisibility(0);
    this.C.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.C, "translationY", new float[] { ViewUtils.dip2px(-76.0F), ViewUtils.dip2px(11.0F), 0.0F });
    localObjectAnimator1.setDuration(360L);
    localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.C, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(360L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.C, "rotation", new float[] { -21.6F, 18.0F, -10.8F, 7.2F, -3.6F, 0.0F });
    localObjectAnimator3.setDuration(960L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).after(0L);
    localAnimatorSet.play(localObjectAnimator2).after(0L);
    localAnimatorSet.play(localObjectAnimator3).after(40L);
    localAnimatorSet.start();
  }
  
  public void a()
  {
    if (this.z.getParent() != null) {
      removeView(this.z);
    }
    addView(this.z);
    this.C.setBackgroundDrawable(getGameOverCardDrawable());
    LottieDrawable localLottieDrawable = this.B;
    if (localLottieDrawable != null)
    {
      if (localLottieDrawable.isAnimating()) {
        this.B.endAnimation();
      }
      this.A.setImageDrawable(this.B);
      this.B.setProgress(0.0F);
      this.B.playAnimation();
      h();
    }
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStartTopicClockCountDown totalDuration = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",startOffset = ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(",imageView = ");
      localStringBuilder.append(paramImageView);
      QLog.d("BaseStageView", 2, localStringBuilder.toString());
    }
    if (!(paramImageView instanceof IBaseCountDownClockView))
    {
      paramImageView = new StringBuilder();
      paramImageView.append("onStartTopicClockCountDown return ,totalDuration = ");
      paramImageView.append(paramLong1);
      paramImageView.append(",startOffset = ");
      paramImageView.append(paramLong2);
      QLog.d("BaseStageView", 1, paramImageView.toString());
      return;
    }
    ((IBaseCountDownClockView)paramImageView).a(paramLong1, paramLong2);
  }
  
  public void a(EngineData paramEngineData)
  {
    int i = paramEngineData.o();
    int k = paramEngineData.j();
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("refreshUI gameType = ");
      paramEngineData.append(i);
      paramEngineData.append(",gameStatus = ");
      paramEngineData.append(k);
      QLog.d("BaseStageView", 2, paramEngineData.toString());
    }
    if ((i != 0) && (k != 0))
    {
      e();
      setVisibility(0);
      return;
    }
    setVisibility(4);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    d();
    this.p.a(paramIGameRoomPresenter);
    this.q = paramIGameRoomPresenter.g();
    setRadius(getContext().getResources().getColor(2131165547), ViewUtils.dpToPx(16.0F));
    setVisibility(4);
    this.E = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131624305, this, false));
    this.F = ((RoundedCornerImageViewNoPadding)this.E.findViewById(2131440410));
    this.F.setCorner(ViewUtils.dpToPx(125.0F) / 2);
    addView(this.E);
    this.E.setVisibility(8);
    this.D = ((UserInfoHandler)GameEngine.a().f().getBusinessHandler(HandlerFactory.b));
    this.z = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131624282, this, false));
    this.A = ((ImageView)this.z.findViewById(2131434007));
    this.C = this.z.findViewById(2131434006);
    this.y = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131624268, this, false));
    this.x = ((ImageView)this.y.findViewById(2131431440));
    f();
    a(GameEngine.a().s());
    addView(this.r, -1, -1);
    this.r.setVisibility(8);
    this.r.setOnSwitchTopicClickListener(new BaseStageView.2(this));
    this.r.a(this.p);
    addView(this.s, -1, -1);
    this.s.setVisibility(8);
    this.s.b(this.p);
    addView(this.t, -1, -1);
    this.t.b(this.p);
    this.t.setVisibility(8);
    this.t.setOnSwitchTopicClickListener(new BaseStageView.3(this));
    addView(this.u, -1, -1);
    this.u.b(this.p);
    this.u.setVisibility(8);
    addView(this.v, -1, -1);
    this.v.b(this.p);
    this.v.setVisibility(8);
    this.p.a(this.r.getPresenter());
    this.p.b(this.s.getPresenter());
    this.p.c(this.t.getPresenter());
    this.p.d(this.u.getPresenter());
    this.p.e(this.v.getPresenter());
    paramIGameRoomPresenter = this.q;
    if ((paramIGameRoomPresenter != null) && ((paramIGameRoomPresenter instanceof IGameVideoRecordPresenterWrapper))) {
      this.t.setGameRecordCtrl(((IGameVideoRecordPresenterWrapper)paramIGameRoomPresenter).g());
    }
    this.s.setStageRecordPresenter(this.q);
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlayGamePrepareCountDownAnim useTransparentBg = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(",duration = ");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(",startOffset = ");
      localStringBuilder.append(paramLong2);
      QLog.d("BaseStageView", 2, localStringBuilder.toString());
    }
    if (this.w == null)
    {
      this.G = paramBoolean;
      this.H = paramLong1;
      this.I = paramLong2;
      this.J = System.currentTimeMillis();
      return;
    }
    b(paramBoolean, paramLong1, paramLong2);
  }
  
  public void b()
  {
    this.t.d();
  }
  
  public void b(EngineData paramEngineData)
  {
    int i = paramEngineData.j();
    int k = paramEngineData.o();
    AVGameUserInfo localAVGameUserInfo = null;
    if ((i != 0) && (i != 10) && (k == 1)) {
      paramEngineData = paramEngineData.r();
    } else {
      paramEngineData = null;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    String str;
    if (paramEngineData != null)
    {
      localAVGameUserInfo = this.p.a().a(paramEngineData.uin);
      if ((localAVGameUserInfo == null) || (!localAVGameUserInfo.hasCameraVideo())) {
        bool1 = true;
      }
      str = paramEngineData.uin;
    }
    else
    {
      str = null;
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePlayerVideoStatus needShow:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" gameStatus:");
      localStringBuilder.append(i);
      localStringBuilder.append(" player:");
      localStringBuilder.append(paramEngineData);
      localStringBuilder.append(" avUserInfo:");
      localStringBuilder.append(localAVGameUserInfo);
      QLog.i("BaseStageView", 2, localStringBuilder.toString());
    }
    if (bool1)
    {
      postDelayed(this.j, 1500L);
      paramEngineData = this.p.a().s();
      if (!TextUtils.equals(paramEngineData, String.valueOf(this.E.getTag()))) {
        if (!TextUtils.isEmpty(paramEngineData))
        {
          this.E.setBackgroundDrawable(URLDrawable.getDrawable(paramEngineData));
          this.E.setTag(paramEngineData);
        }
        else
        {
          this.E.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
          this.E.setTag(paramEngineData);
        }
      }
      if ((!TextUtils.equals(str, String.valueOf(this.F.getTag()))) && (!TextUtils.isEmpty(str)))
      {
        this.F.setImageBitmap(this.D.a(str, (byte)1));
        this.F.setTag(str);
      }
    }
    else
    {
      removeCallbacks(this.j);
      this.E.setVisibility(8);
    }
    e();
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    removeView(this.y);
  }
  
  public void d() {}
  
  public void e()
  {
    if (getVisibility() == 0)
    {
      if (GameRoomViewLayoutParamsDef.w > 0) {
        return;
      }
      Player localPlayer = GameEngine.a().s().r();
      AVGameUserInfo localAVGameUserInfo = null;
      if (localPlayer != null) {
        localAVGameUserInfo = this.p.a().a(localPlayer.uin);
      }
      Object localObject = this.t;
      if ((localObject != null) && (((BaseGuessPictureStageView)localObject).getVisibility() == 0)) {
        this.t.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.r;
      if ((localObject != null) && (((BaseGuessActionStageView)localObject).getVisibility() == 0)) {
        this.r.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.s;
      if ((localObject != null) && (((BaseGuessStarStageView)localObject).getVisibility() == 0)) {
        this.s.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.u;
      if ((localObject != null) && (((BaseGuessSongStageView)localObject).getVisibility() == 0)) {
        this.u.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.v;
      if ((localObject != null) && (((BaseGuessTextStageView)localObject).getVisibility() == 0)) {
        this.v.a(localPlayer, localAVGameUserInfo);
      }
    }
  }
  
  public RectF getPlayingVideoDisplayRect()
  {
    Object localObject1 = this.r;
    Object localObject2;
    if ((localObject1 != null) && (((BaseGuessActionStageView)localObject1).getVisibility() == 0))
    {
      localObject2 = new int[2];
      GameRoomViewLayoutParamsDef.a(this.r, (int[])localObject2);
      localObject1 = new RectF();
      ((RectF)localObject1).left = localObject2[0];
      ((RectF)localObject1).top = localObject2[1];
      ((RectF)localObject1).right = (((RectF)localObject1).left + this.r.getMeasuredWidth());
      ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.r.getMeasuredHeight());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPlayingVideoDisplayRect rectF1:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("BaseStageView", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    localObject1 = this.s;
    if ((localObject1 != null) && (((BaseGuessStarStageView)localObject1).getVisibility() == 0))
    {
      localObject2 = new int[2];
      GameRoomViewLayoutParamsDef.a(this.s, (int[])localObject2);
      localObject1 = new RectF();
      ((RectF)localObject1).left = localObject2[0];
      ((RectF)localObject1).top = localObject2[1];
      ((RectF)localObject1).right = (((RectF)localObject1).left + this.s.getMeasuredWidth());
      ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.s.getMeasuredHeight());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPlayingVideoDisplayRect rectF2:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("BaseStageView", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    return null;
  }
  
  public IStagePresenter getPresenter()
  {
    return this.p;
  }
  
  public View getTopicWrapperView()
  {
    return this.r.getTopicWrapperView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView
 * JD-Core Version:    0.7.0.1
 */