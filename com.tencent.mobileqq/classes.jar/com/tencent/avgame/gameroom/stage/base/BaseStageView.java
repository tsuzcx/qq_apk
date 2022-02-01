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
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.handler.UserInfoHandler;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
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
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.avgame.videorecord.GameVideoRecordPresenterWrapper;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundedCornerImageViewNoPadding;
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
  protected LottieDrawable a;
  protected RoundedCornerImageViewNoPadding a;
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
    if ((localGameItem == null) || (TextUtils.isEmpty(localGameItem.h))) {
      return AvGameResDownloadManager.a("avgame_game_over@2x.png");
    }
    return URLDrawable.getDrawable(localGameItem.h);
  }
  
  private void b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseStageView", 2, "doGamePrepareCountDownAnim useTransparentBg = " + paramBoolean + ",duration = " + paramLong1 + ",startOffset = " + paramLong2);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    String str;
    if (paramBoolean)
    {
      str = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a();
      if (!TextUtils.isEmpty(str)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(str));
      }
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
      }
      if (paramLong1 <= 0L) {
        break label261;
      }
      f = 6000.0F / (float)paramLong1;
      label146:
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setSpeed(f);
      this.jdField_b_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(0.0F);
      if (paramLong1 <= 0L) {
        break label267;
      }
    }
    label261:
    label267:
    for (float f = (float)paramLong2 * 1.0F / (float)paramLong1;; f = 0.0F)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setMinProgress(f);
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      return;
      str = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b();
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(str));
        break;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadManager.a("avgame_float_act_guess_place_holder@2x.png"));
      break;
      f = 1.0F;
      break label146;
    }
  }
  
  private void f()
  {
    AVGameLottieHelper.a(getContext(), "avgame_5s_count_down/data.json", "avgame_5s_count_down/images/", 200, 200, new BaseStageView.4(this));
    AVGameLottieHelper.a(getContext(), "avgame_game_over/data.json", "avgame_game_over/images/", 200, 200, new BaseStageView.5(this));
  }
  
  private void g()
  {
    if (this.jdField_c_of_type_Long == 0L) {}
    do
    {
      return;
      l = System.currentTimeMillis();
      l = this.jdField_c_of_type_Long + (this.jdField_a_of_type_Long - this.jdField_b_of_type_Long) - l;
    } while (l <= 0L);
    long l = this.jdField_a_of_type_Long - l;
    if (QLog.isColorLevel()) {
      QLog.d("BaseStageView", 2, "tryRecover5sCountDownAnim startOffset = " + l + ",duration = " + this.jdField_a_of_type_Long);
    }
    b(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Long, l);
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void h()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { AIOUtils.a(-76.0F, getResources()), AIOUtils.a(11.0F, getResources()), 0.0F });
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
    Object localObject;
    RectF localRectF;
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.getVisibility() == 0))
    {
      localObject = new int[2];
      GameRoomViewLayoutParamsDef.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView, (int[])localObject);
      localRectF = new RectF();
      localRectF.left = localObject[0];
      localRectF.top = localObject[1];
      localRectF.right = (localRectF.left + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.getMeasuredWidth());
      localRectF.bottom = (localRectF.top + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.getMeasuredHeight());
      localObject = localRectF;
      if (QLog.isColorLevel())
      {
        QLog.i("BaseStageView", 2, "getPlayingVideoDisplayRect rectF1:" + localRectF);
        localObject = localRectF;
      }
    }
    do
    {
      return localObject;
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.getVisibility() != 0)) {
        break;
      }
      localObject = new int[2];
      GameRoomViewLayoutParamsDef.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView, (int[])localObject);
      localRectF = new RectF();
      localRectF.left = localObject[0];
      localRectF.top = localObject[1];
      localRectF.right = (localRectF.left + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.getMeasuredWidth());
      localRectF.bottom = (localRectF.top + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.getMeasuredHeight());
      localObject = localRectF;
    } while (!QLog.isColorLevel());
    QLog.i("BaseStageView", 2, "getPlayingVideoDisplayRect rectF2:" + localRectF);
    return localRectF;
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
  
  public void a() {}
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseStageView", 2, "onStartTopicClockCountDown totalDuration = " + paramLong1 + ",startOffset = " + paramLong2 + ",imageView = " + paramImageView);
    }
    if (!(paramImageView instanceof IBaseCountDownClockView))
    {
      QLog.d("BaseStageView", 1, "onStartTopicClockCountDown return ,totalDuration = " + paramLong1 + ",startOffset = " + paramLong2);
      return;
    }
    ((IBaseCountDownClockView)paramImageView).a(paramLong1, paramLong2);
  }
  
  public void a(EngineData paramEngineData)
  {
    int i = paramEngineData.c();
    int j = paramEngineData.a();
    if (QLog.isColorLevel()) {
      QLog.d("BaseStageView", 2, "refreshUI gameType = " + i + ",gameStatus = " + j);
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
    a();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramIGameRoomPresenter);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter = paramIGameRoomPresenter.a();
    setRadius(getContext().getResources().getColor(2131165345), ViewUtils.b(16.0F));
    setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558789, this, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding = ((RoundedCornerImageViewNoPadding)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131373276));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.setCorner(ViewUtils.b(125.0F) / 2);
    addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler = ((UserInfoHandler)GameEngine.a().a().getBusinessHandler(HandlerFactory.b));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558766, this, false));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131367732));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131367731);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558752, this, false));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365403));
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
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter != null) && ((this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter instanceof GameVideoRecordPresenterWrapper))) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.setGameRecordCtrl(((GameVideoRecordPresenterWrapper)this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter).a());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.setStageRecordPresenter(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStageRecordPresenter);
  }
  
  public void a(String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseStageView", 2, "onPlayGamePrepareCountDownAnim useTransparentBg = " + paramBoolean + ",duration = " + paramLong1 + ",startOffset = " + paramLong2);
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
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    }
    addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(a());
    if (this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) {
        this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.setProgress(0.0F);
      this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      h();
    }
  }
  
  public void b(EngineData paramEngineData)
  {
    boolean bool = false;
    String str = null;
    int i = paramEngineData.a();
    int j = paramEngineData.c();
    if ((i != 0) && (i != 10) && (j == 1)) {}
    for (paramEngineData = paramEngineData.b();; paramEngineData = null)
    {
      AVGameUserInfo localAVGameUserInfo;
      if (paramEngineData != null)
      {
        localAVGameUserInfo = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(paramEngineData.uin);
        if ((localAVGameUserInfo == null) || (!localAVGameUserInfo.hasCameraVideo())) {
          bool = true;
        }
        str = paramEngineData.uin;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("BaseStageView", 2, "updatePlayerVideoStatus needShow:" + bool + " gameStatus:" + i + " player:" + paramEngineData + " avUserInfo:" + localAVGameUserInfo);
        }
        if (bool)
        {
          postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1500L);
          paramEngineData = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().b();
          if (!TextUtils.equals(paramEngineData, String.valueOf(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTag())))
          {
            if (!TextUtils.isEmpty(paramEngineData))
            {
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(paramEngineData));
              this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(paramEngineData);
            }
          }
          else if ((!TextUtils.equals(str, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.getTag()))) && (!TextUtils.isEmpty(str)))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.setImageBitmap(this.jdField_a_of_type_ComTencentAvgameBusinessHandlerUserInfoHandler.a(str, (byte)1));
            this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.setTag(str);
          }
        }
        for (;;)
        {
          e();
          return;
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadManager.a("avgame_float_act_guess_place_holder@2x.png"));
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(paramEngineData);
          break;
          removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        bool = false;
        localAVGameUserInfo = null;
      }
    }
  }
  
  public void b(String paramString) {}
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.c();
  }
  
  public void d()
  {
    removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void e()
  {
    if ((getVisibility() != 0) || (GameRoomViewLayoutParamsDef.l > 0)) {}
    Player localPlayer;
    AVGameUserInfo localAVGameUserInfo;
    do
    {
      return;
      localPlayer = GameEngine.a().a().b();
      localAVGameUserInfo = null;
      if (localPlayer != null) {
        localAVGameUserInfo = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(localPlayer.uin);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.a(localPlayer, localAVGameUserInfo);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView.a(localPlayer, localAVGameUserInfo);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.a(localPlayer, localAVGameUserInfo);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.a(localPlayer, localAVGameUserInfo);
      }
    } while ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.getVisibility() != 0));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.a(localPlayer, localAVGameUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseStageView
 * JD-Core Version:    0.7.0.1
 */