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
  long jdField_a_of_type_Long;
  protected View a;
  protected RelativeLayout a;
  protected UserInfoHandler a;
  protected IStagePresenter a;
  protected IStageRecordPresenter a;
  protected BaseGuessActionStageView a;
  protected BaseGuessPictureStageView a;
  protected BaseGuessSongStageView a;
  protected BaseGuessStarStageView a;
  protected BaseGuessTextStageView a;
  protected RoundedCornerImageViewNoPadding a;
  protected LottieDrawable a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new BaseStageView.1(this);
  long jdField_b_of_type_Long;
  protected ImageView b;
  protected RelativeLayout b;
  protected LottieDrawable b;
  boolean jdField_b_of_type_Boolean;
  long c;
  protected ImageView c;
  protected RelativeLayout c;
  
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
  
  private Drawable a()
  {
    GameItem localGameItem = GameEngine.a().a().a();
    if ((localGameItem != null) && (!TextUtils.isEmpty(localGameItem.h))) {
      return URLDrawable.getDrawable(localGameItem.h);
    }
    return AvGameResDownloadUtil.a("avgame_game_over@2x.png");
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
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable((String)localObject));
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable((String)localObject));
      } else {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
      }
    }
    addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
    }
    if (paramLong1 > 0L) {
      f = 6000.0F / (float)paramLong1;
    } else {
      f = 1.0F;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setSpeed(f);
    this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    float f = 0.0F;
    ((LottieDrawable)localObject).setProgress(0.0F);
    if (paramLong1 > 0L) {
      f = (float)paramLong2 * 1.0F / (float)paramLong1;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setMinProgress(f);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
  }
  
  private void f()
  {
    AVGameLottieHelper.a(getContext(), "avgame_5s_count_down/data.json", "avgame_5s_count_down/images/", 200, 200, new BaseStageView.4(this));
    AVGameLottieHelper.a(getContext(), "avgame_game_over/data.json", "avgame_game_over/images/", 200, 200, new BaseStageView.5(this));
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Long == 0L) {
      return;
    }
    long l2 = System.currentTimeMillis();
    long l3 = this.jdField_c_of_type_Long;
    long l1 = this.jdField_a_of_type_Long;
    l2 = l3 + (l1 - this.jdField_b_of_type_Long) - l2;
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
      localStringBuilder.append(this.jdField_a_of_type_Long);
      QLog.d("BaseStageView", 2, localStringBuilder.toString());
    }
    b(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Long, l1);
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void h()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { ViewUtils.a(-76.0F), ViewUtils.a(11.0F), 0.0F });
    localObjectAnimator1.setDuration(360L);
    localObjectAnimator1.setInterpolator(new DecelerateInterpolator());
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(360L);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "rotation", new float[] { -21.6F, 18.0F, -10.8F, 7.2F, -3.6F, 0.0F });
    localObjectAnimator3.setDuration(960L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).after(0L);
    localAnimatorSet.play(localObjectAnimator2).after(0L);
    localAnimatorSet.play(localObjectAnimator3).after(40L);
    localAnimatorSet.start();
  }
  
  public RectF a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView;
    Object localObject2;
    if ((localObject1 != null) && (((BaseGuessActionStageView)localObject1).getVisibility() == 0))
    {
      localObject2 = new int[2];
      GameRoomViewLayoutParamsDef.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView, (int[])localObject2);
      localObject1 = new RectF();
      ((RectF)localObject1).left = localObject2[0];
      ((RectF)localObject1).top = localObject2[1];
      ((RectF)localObject1).right = (((RectF)localObject1).left + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.getMeasuredWidth());
      ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.getMeasuredHeight());
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getPlayingVideoDisplayRect rectF1:");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("BaseStageView", 2, ((StringBuilder)localObject2).toString());
      }
      return localObject1;
    }
    localObject1 = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView;
    if ((localObject1 != null) && (((BaseGuessStarStageView)localObject1).getVisibility() == 0))
    {
      localObject2 = new int[2];
      GameRoomViewLayoutParamsDef.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView, (int[])localObject2);
      localObject1 = new RectF();
      ((RectF)localObject1).left = localObject2[0];
      ((RectF)localObject1).top = localObject2[1];
      ((RectF)localObject1).right = (((RectF)localObject1).left + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.getMeasuredWidth());
      ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.getMeasuredHeight());
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
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.a();
  }
  
  public IStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  }
  
  public void a()
  {
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a());
    LottieDrawable localLottieDrawable = this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable != null)
    {
      if (localLottieDrawable.isAnimating()) {
        this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(0.0F);
      this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
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
    int i = paramEngineData.c();
    int j = paramEngineData.a();
    if (QLog.isColorLevel())
    {
      paramEngineData = new StringBuilder();
      paramEngineData.append("refreshUI gameType = ");
      paramEngineData.append(i);
      paramEngineData.append(",gameStatus = ");
      paramEngineData.append(j);
      QLog.d("BaseStageView", 2, paramEngineData.toString());
    }
    if ((i != 0) && (j != 0))
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramIGameRoomPresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter = paramIGameRoomPresenter.a();
    setRadius(getContext().getResources().getColor(2131165311), ViewUtils.b(16.0F));
    setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558688, this, false));
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundedCornerImageViewNoPadding = ((RoundedCornerImageViewNoPadding)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131372854));
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundedCornerImageViewNoPadding.setCorner(ViewUtils.b(125.0F) / 2);
    addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558665, this, false));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131367489));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131367488);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558651, this, false));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365267));
    f();
    a(GameEngine.a().a());
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.setOnSwitchTopicClickListener(new BaseStageView.2(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter);
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.b(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter);
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.b(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.setOnSwitchTopicClickListener(new BaseStageView.3(this));
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.b(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.setVisibility(8);
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.b(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.b(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.c(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.e(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.a());
    paramIGameRoomPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter;
    if ((paramIGameRoomPresenter != null) && ((paramIGameRoomPresenter instanceof IGameVideoRecordPresenterWrapper))) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.setGameRecordCtrl(((IGameVideoRecordPresenterWrapper)paramIGameRoomPresenter).a());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.setStageRecordPresenter(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter);
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
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Long = paramLong1;
      this.jdField_b_of_type_Long = paramLong2;
      this.jdField_c_of_type_Long = System.currentTimeMillis();
      return;
    }
    b(paramBoolean, paramLong1, paramLong2);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.c();
  }
  
  public void b(EngineData paramEngineData)
  {
    int i = paramEngineData.a();
    int j = paramEngineData.c();
    AVGameUserInfo localAVGameUserInfo = null;
    if ((i != 0) && (i != 10) && (j == 1)) {
      paramEngineData = paramEngineData.b();
    } else {
      paramEngineData = null;
    }
    boolean bool2 = false;
    boolean bool1 = false;
    String str;
    if (paramEngineData != null)
    {
      localAVGameUserInfo = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.uin);
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
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1500L);
      paramEngineData = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b();
      if (!TextUtils.equals(paramEngineData, String.valueOf(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTag()))) {
        if (!TextUtils.isEmpty(paramEngineData))
        {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(paramEngineData));
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(paramEngineData);
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_float_act_guess_place_holder@2x.png"));
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(paramEngineData);
        }
      }
      if ((!TextUtils.equals(str, String.valueOf(this.jdField_a_of_type_ComTencentAvgameWidgetRoundedCornerImageViewNoPadding.getTag()))) && (!TextUtils.isEmpty(str)))
      {
        this.jdField_a_of_type_ComTencentAvgameWidgetRoundedCornerImageViewNoPadding.setImageBitmap(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a(str, (byte)1));
        this.jdField_a_of_type_ComTencentAvgameWidgetRoundedCornerImageViewNoPadding.setTag(str);
      }
    }
    else
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    e();
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void d() {}
  
  public void e()
  {
    if (getVisibility() == 0)
    {
      if (GameRoomViewLayoutParamsDef.w > 0) {
        return;
      }
      Player localPlayer = GameEngine.a().a().b();
      AVGameUserInfo localAVGameUserInfo = null;
      if (localPlayer != null) {
        localAVGameUserInfo = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(localPlayer.uin);
      }
      Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView;
      if ((localObject != null) && (((BaseGuessPictureStageView)localObject).getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView;
      if ((localObject != null) && (((BaseGuessActionStageView)localObject).getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView;
      if ((localObject != null) && (((BaseGuessStarStageView)localObject).getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView;
      if ((localObject != null) && (((BaseGuessSongStageView)localObject).getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.a(localPlayer, localAVGameUserInfo);
      }
      localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView;
      if ((localObject != null) && (((BaseGuessTextStageView)localObject).getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.a(localPlayer, localAVGameUserInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView
 * JD-Core Version:    0.7.0.1
 */