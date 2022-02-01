package com.tencent.avgame.gameroom.stage;

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
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.Player;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView;
import com.tencent.avgame.session.AVGameUserInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundedCornerImageViewNoPadding;
import com.tencent.qphone.base.util.QLog;
import mxz;
import mzl;
import naf;
import nak;
import nav;
import nbx;
import ncp;
import ncq;
import neg;
import neh;
import nei;
import nej;
import nek;
import nel;
import nem;
import nen;
import nka;

public class StageView
  extends CoverRoundCornerRelativeLayout
  implements nei
{
  long jdField_a_of_type_Long;
  protected View a;
  protected ImageView a;
  protected RelativeLayout.LayoutParams a;
  protected RelativeLayout a;
  protected TextView a;
  protected GuessActionStageView a;
  protected GuessPictureStageView a;
  protected GuessSongStageView a;
  protected GuessStarStageView a;
  protected GuessTextStageView a;
  public LottieDrawable a;
  protected RoundedCornerImageViewNoPadding a;
  Runnable jdField_a_of_type_JavaLangRunnable = new StageView.1(this);
  protected mxz a;
  protected neg a;
  protected neh a;
  long jdField_b_of_type_Long;
  protected ImageView b;
  protected RelativeLayout.LayoutParams b;
  public RelativeLayout b;
  public LottieDrawable b;
  Runnable jdField_b_of_type_JavaLangRunnable = new StageView.2(this);
  boolean jdField_b_of_type_Boolean;
  long jdField_c_of_type_Long;
  protected ImageView c;
  protected RelativeLayout c;
  private Runnable jdField_c_of_type_JavaLangRunnable = new StageView.3(this);
  
  public StageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public StageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public StageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Neg = new nej(this);
  }
  
  private Drawable a()
  {
    nak localnak = mzl.a().a().a();
    if ((localnak == null) || (TextUtils.isEmpty(localnak.g))) {
      return nav.a("avgame_game_over@2x.png");
    }
    return URLDrawable.getDrawable(localnak.g);
  }
  
  private void b(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "doGamePrepareCountDownAnim useTransparentBg = " + paramBoolean + ",duration = " + paramLong1 + ",startOffset = " + paramLong2);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    String str;
    if (paramBoolean)
    {
      str = this.jdField_a_of_type_Neg.a().a();
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
      str = this.jdField_a_of_type_Neg.a().b();
      if (!TextUtils.isEmpty(str))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(str));
        break;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(nav.a("avgame_float_act_guess_place_holder@2x.png"));
      break;
      f = 1.0F;
      break label146;
    }
  }
  
  private void e()
  {
    nbx.a(getContext(), "avgame_5s_count_down/data.json", "avgame_5s_count_down/images/", 200, 200, new nem(this));
    nbx.a(getContext(), "avgame_game_over/data.json", "avgame_game_over/images/", 200, 200, new nen(this));
  }
  
  private void f()
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
      QLog.d("StageView", 2, "tryRecover5sCountDownAnim startOffset = " + l + ",duration = " + this.jdField_a_of_type_Long);
    }
    b(this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Long, l);
    this.jdField_c_of_type_Long = 0L;
  }
  
  private void g()
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, "translationY", new float[] { AIOUtils.dp2px(-76.0F, getResources()), AIOUtils.dp2px(11.0F, getResources()), 0.0F });
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
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.getVisibility() == 0))
    {
      localObject = new int[2];
      ncp.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView, (int[])localObject);
      localRectF = new RectF();
      localRectF.left = localObject[0];
      localRectF.top = localObject[1];
      localRectF.right = (localRectF.left + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.getMeasuredWidth());
      localRectF.bottom = (localRectF.top + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.getMeasuredHeight());
      localObject = localRectF;
      if (QLog.isColorLevel())
      {
        QLog.i("StageView", 2, "getPlayingVideoDisplayRect rectF1:" + localRectF);
        localObject = localRectF;
      }
    }
    do
    {
      return localObject;
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.getVisibility() != 0)) {
        break;
      }
      localObject = new int[2];
      ncp.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView, (int[])localObject);
      localRectF = new RectF();
      localRectF.left = localObject[0];
      localRectF.top = localObject[1];
      localRectF.right = (localRectF.left + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.getMeasuredWidth());
      localRectF.bottom = (localRectF.top + this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.getMeasuredHeight());
      localObject = localRectF;
    } while (!QLog.isColorLevel());
    QLog.i("StageView", 2, "getPlayingVideoDisplayRect rectF2:" + localRectF);
    return localRectF;
    return null;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.a();
  }
  
  public neg a()
  {
    return this.jdField_a_of_type_Neg;
  }
  
  public void a()
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
      g();
    }
  }
  
  public void a(ImageView paramImageView, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "onStartTopicClockCountDown totalDuration = " + paramLong1 + ",startOffset = " + paramLong2 + ",imageView = " + paramImageView);
    }
    if (!(paramImageView instanceof CountDownClockView))
    {
      QLog.d("StageView", 1, "onStartTopicClockCountDown return ,totalDuration = " + paramLong1 + ",startOffset = " + paramLong2);
      return;
    }
    ((CountDownClockView)paramImageView).a(paramLong1, paramLong2);
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetTextView);
    }
    addView(this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(naf paramnaf)
  {
    int i = paramnaf.c();
    int j = paramnaf.a();
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "refreshUI gameType = " + i + ",gameStatus = " + j);
    }
    if ((i != 0) && (j != 0))
    {
      d();
      setVisibility(0);
      return;
    }
    setVisibility(4);
  }
  
  public void a(ncq paramncq)
  {
    this.jdField_a_of_type_Neg.a(paramncq);
    this.jdField_a_of_type_Neh = paramncq.a();
    setRadius(getContext().getResources().getColor(2131165342), ViewUtils.dpToPx(16.0F));
    setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558732, this, false));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding = ((RoundedCornerImageViewNoPadding)this.jdField_c_of_type_AndroidWidgetRelativeLayout.findViewById(2131372758));
    this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.setCorner(ViewUtils.dpToPx(125.0F) / 2);
    addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_Mxz = ((mxz)mzl.a().a().a(2));
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(12);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ViewUtils.dpToPx(33.0F);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(190.0F), ViewUtils.dpToPx(40.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(12);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ViewUtils.dpToPx(20.0F);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558721, this, false));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131367412));
    this.jdField_a_of_type_AndroidViewView = this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131367411);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558710, this, false));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131365178));
    e();
    a(mzl.a().a());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView = ((GuessActionStageView)LayoutInflater.from(getContext()).inflate(2131558739, null));
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.setOnSwitchTopicClickListener(new nek(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.a(this.jdField_a_of_type_Neg);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView = new GuessStarStageView(getContext());
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.a(this.jdField_a_of_type_Neg);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView = ((GuessPictureStageView)LayoutInflater.from(getContext()).inflate(2131558740, null));
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.a(this.jdField_a_of_type_Neg);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.setOnSwitchTopicClickListener(new nel(this));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView = ((GuessSongStageView)LayoutInflater.from(getContext()).inflate(2131558741, null));
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView.a(this.jdField_a_of_type_Neg);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView = ((GuessTextStageView)LayoutInflater.from(getContext()).inflate(2131558742, null));
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView, -1, -1);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.a(this.jdField_a_of_type_Neg);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.setVisibility(8);
    this.jdField_a_of_type_Neg.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.a());
    this.jdField_a_of_type_Neg.b(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.a());
    this.jdField_a_of_type_Neg.c(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.a());
    this.jdField_a_of_type_Neg.d(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView.a());
    this.jdField_a_of_type_Neg.e(this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.a());
    if ((this.jdField_a_of_type_Neh != null) && ((this.jdField_a_of_type_Neh instanceof nka))) {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.setGameRecordCtrl(((nka)this.jdField_a_of_type_Neh).a());
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.setStageRecordPresenter(this.jdField_a_of_type_Neh);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "onPlayGamePrepareCountDownAnim useTransparentBg = " + paramBoolean + ",duration = " + paramLong1 + ",startOffset = " + paramLong2);
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
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.a();
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StageView", 2, "onShowImageTipOnStageBottom imageName = " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(nav.a(paramString));
    postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1500L);
  }
  
  public void b(naf paramnaf)
  {
    boolean bool = false;
    String str = null;
    int i = paramnaf.a();
    int j = paramnaf.c();
    if ((i != 0) && (i != 10) && (j == 1)) {}
    for (paramnaf = paramnaf.b();; paramnaf = null)
    {
      AVGameUserInfo localAVGameUserInfo;
      if (paramnaf != null)
      {
        localAVGameUserInfo = this.jdField_a_of_type_Neg.a().a(paramnaf.uin);
        if ((localAVGameUserInfo == null) || (!localAVGameUserInfo.hasCameraVideo())) {
          bool = true;
        }
        str = paramnaf.uin;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("StageView", 2, "updatePlayerVideoStatus needShow:" + bool + " gameStatus:" + i + " player:" + paramnaf + " avUserInfo:" + localAVGameUserInfo);
        }
        if (bool)
        {
          postDelayed(this.jdField_c_of_type_JavaLangRunnable, 1500L);
          paramnaf = this.jdField_a_of_type_Neg.a().b();
          if ((!TextUtils.equals(paramnaf, String.valueOf(this.jdField_c_of_type_AndroidWidgetRelativeLayout.getTag()))) && (!TextUtils.isEmpty(paramnaf)))
          {
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(URLDrawable.getDrawable(paramnaf));
            this.jdField_c_of_type_AndroidWidgetRelativeLayout.setTag(paramnaf);
          }
          if ((!TextUtils.equals(str, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.getTag()))) && (!TextUtils.isEmpty(str)))
          {
            this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.setImageBitmap(this.jdField_a_of_type_Mxz.a(str, (byte)1));
            this.jdField_a_of_type_ComTencentMobileqqWidgetRoundedCornerImageViewNoPadding.setTag(str);
          }
        }
        for (;;)
        {
          d();
          return;
          removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        }
        bool = false;
        localAVGameUserInfo = null;
      }
    }
  }
  
  public void c()
  {
    removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  public void d()
  {
    if ((getVisibility() != 0) || (ncp.k > 0)) {}
    Player localPlayer;
    AVGameUserInfo localAVGameUserInfo;
    do
    {
      return;
      localPlayer = mzl.a().a().b();
      localAVGameUserInfo = null;
      if (localPlayer != null) {
        localAVGameUserInfo = this.jdField_a_of_type_Neg.a().a(localPlayer.uin);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureGuessPictureStageView.a(localPlayer, localAVGameUserInfo);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionGuessActionStageView.a(localPlayer, localAVGameUserInfo);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarGuessStarStageView.a(localPlayer, localAVGameUserInfo);
      }
      if ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView != null) && (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView.getVisibility() == 0)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongGuessSongStageView.a(localPlayer, localAVGameUserInfo);
      }
    } while ((this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.getVisibility() != 0));
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextGuessTextStageView.a(localPlayer, localAVGameUserInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.StageView
 * JD-Core Version:    0.7.0.1
 */