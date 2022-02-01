package com.tencent.avgame.gameroom.overlay;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.report.CJSurvivalReporterUtil;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.avgame.widget.RoundCorneredRelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class OverlayView
  extends RelativeLayout
  implements IOverlayView
{
  private int jdField_a_of_type_Int = -855638016;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  protected OverlayPresenterImp a;
  private AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  private RoundCorneredRelativeLayout jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout;
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  Runnable jdField_a_of_type_JavaLangRunnable = new OverlayView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private RoundCorneredRelativeLayout jdField_b_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout;
  private BubbleLayout jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private LottieDrawable jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_b_of_type_Boolean;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private LottieDrawable jdField_c_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_c_of_type_Boolean;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_e_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private TextView f;
  private TextView g;
  
  public OverlayView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OverlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayPresenterImp = new OverlayPresenterImp(this);
    LayoutInflater.from(getContext()).inflate(2131558655, this, true);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)findViewById(2131372859));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.getLayoutParams());
    this.g = ((TextView)findViewById(2131372858));
    this.g.setSelected(true);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
    this.f = ((TextView)findViewById(2131362718));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367781);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364300));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362710));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368044));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362711));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362713));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370217));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362034));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362036));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362717));
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131364891));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
    ((TextView)findViewById(2131365208)).setTypeface(AVGameText.a());
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362716));
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)findViewById(2131372848));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131372847));
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.setRadius(ViewUtils.a(12.0F));
    this.jdField_b_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout = ((RoundCorneredRelativeLayout)findViewById(2131362035));
    this.jdField_b_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.setRadius(ViewUtils.a(12.0F));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376963));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372853));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372845));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)findViewById(2131365514));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365513));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372846));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtil.a("avgame_pk_head_win@2x.png"));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    c();
  }
  
  private Drawable a()
  {
    if (!IGameEngine.k()) {
      localObject = IGameEngine.a().a().a();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return AvGameResDownloadUtil.a("avgame_answer_bg_self@2x.png");
    }
    Object localObject = ((GameItem)localObject).g;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return AvGameResDownloadUtil.a("avgame_answer_bg_self@2x.png");
    }
    return URLDrawable.getDrawable((String)localObject);
  }
  
  private void a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    if (IGameEngine.a().i())
    {
      localLayoutParams.width = ViewUtils.a(205.0F);
      localLayoutParams.height = ViewUtils.a(205.0F);
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.bottomMargin = 0;
    }
    else if (paramFloat != 0.0F)
    {
      localLayoutParams.width = ViewUtils.a(199.0F);
      localLayoutParams.height = ViewUtils.a(170.0F);
      localLayoutParams.addRule(13, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.bottomMargin = ViewUtils.a(70.0F);
    }
    else
    {
      localLayoutParams.width = ViewUtils.a(198.0F);
      localLayoutParams.height = ViewUtils.a(198.0F);
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.bottomMargin = 0;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
    int i = paramString.length();
    if (IGameEngine.a().i())
    {
      if (i >= 6)
      {
        localLayoutParams.topMargin = ViewUtils.a(110.0F);
        if (i == 6) {
          localLayoutParams.topMargin = ViewUtils.a(129.0F);
        }
        localLayoutParams.width = ViewUtils.a(140.0F);
        this.f.setTextSize(1, 22.0F);
      }
      else
      {
        localLayoutParams.topMargin = ViewUtils.a(122.0F);
        localLayoutParams.width = ViewUtils.a(150.0F);
        this.f.setTextSize(1, 28.0F);
      }
    }
    else if (i >= 6)
    {
      localLayoutParams.topMargin = ViewUtils.a(110.0F - paramFloat);
      if (i == 6) {
        localLayoutParams.topMargin = ViewUtils.a(129.0F - paramFloat);
      }
      localLayoutParams.width = ViewUtils.a(140.0F);
      this.f.setTextSize(1, 22.0F);
    }
    else
    {
      localLayoutParams.topMargin = ViewUtils.a(124.0F - paramFloat);
      localLayoutParams.width = ViewUtils.a(150.0F);
      this.f.setTextSize(1, 28.0F);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAnswerTextLayout answer = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",length = ");
      localStringBuilder.append(i);
      QLog.d("OverlayView", 2, localStringBuilder.toString());
    }
    this.f.setLayoutParams(localLayoutParams);
  }
  
  private void c()
  {
    AVGameLottieHelper.a(getContext(), "avgame_answer_card_star/data.json", "avgame_answer_card_star/images/", 300, 300, new OverlayView.2(this));
    AVGameLottieHelper.a(getContext(), "avgame_answer_head_cheer_friend/data.json", "avgame_answer_head_cheer_friend/images/", 275, 275, new OverlayView.3(this));
    AVGameLottieHelper.a(getContext(), "avgame_answer_head_cheer_self/data.json", "avgame_answer_head_cheer_self/images/", 275, 275, new OverlayView.4(this));
  }
  
  private void c(RectF paramRectF)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setTriangleOffset(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)paramRectF.top - ViewUtils.b(42.0F));
    int k = (int)(paramRectF.left + paramRectF.right) / 2;
    int i = k - this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width / 2;
    int m = ViewUtils.b(12.0F);
    int j;
    if (i < m)
    {
      j = i - m;
      i = m;
    }
    else
    {
      j = -1;
    }
    int n = ViewUtils.a() - (k + this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width / 2);
    k = i;
    if (n < m)
    {
      j = m - n;
      k = i - j;
    }
    if (QLog.isColorLevel())
    {
      paramRectF = new StringBuilder();
      paramRectF.append("updatePlayerTipsLocation offset:");
      paramRectF.append(j);
      QLog.d("OverlayView", 2, paramRectF.toString());
    }
    if (j != -1) {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setTriangleOffset(j);
    }
    paramRectF = this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
    paramRectF.leftMargin = k;
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setLayoutParams(paramRectF);
  }
  
  private void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.w;
    localLayoutParams.width = GameRoomViewLayoutParamsDef.z;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.y;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateCardAnimWrapperLP topMargin = ");
      localStringBuilder.append(localLayoutParams.topMargin);
      localStringBuilder.append(",width = ");
      localStringBuilder.append(localLayoutParams.width);
      localStringBuilder.append(",height = ");
      localStringBuilder.append(localLayoutParams.height);
      QLog.d("OverlayView", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public IOverlayPresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayPresenterImp;
  }
  
  public void a()
  {
    this.f.setText("");
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(RectF paramRectF)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowDesigningTopicTipOnMemberSeat rectF = ");
      localStringBuilder.append(paramRectF);
      QLog.d("OverlayView", 2, localStringBuilder.toString());
    }
    if (paramRectF == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.g.setText(2131690311);
    this.g.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = ViewUtils.b(76.0F);
    c(paramRectF);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.postDelayed(new OverlayView.6(this), 3000L);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomOverlayOverlayPresenterImp.a(paramIGameRoomPresenter);
  }
  
  void a(LottieDrawable paramLottieDrawable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "playSuccessfulRaceAnim");
    }
    d();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if ((IGameEngine.a().i()) && (!paramBoolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
      if (localObject1 != null)
      {
        ((LottieDrawable)localObject1).pauseAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.8F);
    Object localObject1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { ViewUtils.a(-76.0F), ViewUtils.a(11.0F), 0.0F });
    ((ObjectAnimator)localObject1).setDuration(360L);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(360L);
    Object localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).after(0L);
    ((AnimatorSet)localObject2).play(localObjectAnimator1).after(0L);
    ((AnimatorSet)localObject2).setInterpolator(new DecelerateInterpolator());
    ((AnimatorSet)localObject2).start();
    if ((IGameEngine.a().f()) && (!paramBoolean)) {
      return;
    }
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramLottieDrawable);
    if (paramLottieDrawable != null)
    {
      paramLottieDrawable.pauseAnimation();
      paramLottieDrawable.playAnimation();
    }
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setAlpha(0.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.0F);
    paramLottieDrawable = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetTextView, "alpha", new float[] { 0.0F, 1.0F });
    paramLottieDrawable.setDuration(170L);
    localObject1 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    ((ObjectAnimator)localObject1).setDuration(280L);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPivotX(ViewUtils.b(100.0F) / 2);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPivotY(ViewUtils.b(100.0F));
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "scaleX", new float[] { 0.74F, 1.1F, 1.0F });
    localObjectAnimator1.setDuration(440L);
    localObject2 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "scaleY", new float[] { 0.74F, 1.1F, 1.0F });
    ((ObjectAnimator)localObject2).setDuration(440L);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setScaleX(0.74F);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setScaleY(0.74F);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "rotation", new float[] { 0.0F, -21.6F, 18.0F, -10.8F, 10.8F, -3.6F, 0.0F });
    localObjectAnimator2.setDuration(720L);
    if (IGameEngine.a().i())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelectedColor("#FC5E31");
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setDuration(240L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout, "translationY", new float[] { ViewUtils.a(8.5F), ViewUtils.a(-6.5F), 0.0F });
    localObjectAnimator4.setDuration(480L);
    localObjectAnimator4.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).after(240L);
    localAnimatorSet.play((Animator)localObject2).after(240L);
    localAnimatorSet.play(localObjectAnimator2).after(800L);
    localAnimatorSet.play((Animator)localObject1).after(160L);
    localAnimatorSet.play(paramLottieDrawable).after(270L);
    localAnimatorSet.play(localObjectAnimator3).after(1320L);
    localAnimatorSet.play(localObjectAnimator4).after(1320L);
    localAnimatorSet.start();
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentAvgameWidgetRoundCorneredRelativeLayout.postDelayed(new OverlayView.5(this, paramLong1, paramLong2), 1800L);
  }
  
  public void a(String paramString)
  {
    this.f.setText(paramString);
    a(paramString, 0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_answer_bg_timeout@2x.png"));
    b();
    paramString = IGameEngine.a().a();
    if (paramString.g())
    {
      int i;
      if (paramString.h()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_result_wrong", "survival_result_wrong", i, 0, String.valueOf(paramString.a().a.jdField_a_of_type_Int), String.valueOf(paramString.p()), CJSurvivalReporterUtil.a().a(paramString), String.valueOf(paramString.k()));
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap1, String paramString2, long paramLong1, long paramLong2, long paramLong3, Bitmap paramBitmap2, long paramLong4, boolean paramBoolean)
  {
    this.f.setText(paramString1);
    a(paramString1, 50.0F);
    this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
    paramString1 = this.jdField_d_of_type_AndroidWidgetTextView;
    paramBitmap1 = new StringBuilder();
    paramBitmap1.append("+");
    paramBitmap1.append(paramLong1);
    paramString1.setText(paramBitmap1.toString());
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a());
      if (paramLong3 >= 2L)
      {
        paramString1 = this.jdField_a_of_type_ComTencentAvgameUiAVGameText;
        paramBitmap1 = new StringBuilder();
        paramBitmap1.append("x");
        paramBitmap1.append(paramLong3);
        paramString1.setText(paramBitmap1.toString());
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      else
      {
        if (IGameEngine.a().i())
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setText("");
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          this.jdField_b_of_type_AndroidWidgetTextView.setText("抢答成功!");
        }
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFDE2E"));
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      a(this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable, paramLong2 - paramLong1, paramLong2, true);
      if (this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
        this.jdField_c_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_answer_bg_friend@2x.png"));
      if (IGameEngine.a().i())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("好友答对了");
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(this.jdField_c_of_type_ComTencentMobileqqDiniflyLottieDrawable, paramLong2 - paramLong1, paramLong2, false);
      if (this.jdField_c_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
        this.jdField_d_of_type_Boolean = true;
      }
    }
    paramString1 = IGameEngine.a().a();
    if (paramString1.g())
    {
      int i;
      if (paramString1.h()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_result_right", "survival_result_right", i, 0, String.valueOf(paramString1.a().a.jdField_a_of_type_Int), String.valueOf(paramString1.p()), CJSurvivalReporterUtil.a().a(paramString1), String.valueOf(paramString1.k()));
    }
    if (paramBitmap2 != null)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap2);
      paramString1 = this.jdField_a_of_type_AndroidWidgetTextView;
      paramBitmap1 = new StringBuilder();
      paramBitmap1.append("表演成功 +");
      paramBitmap1.append(paramLong4);
      paramString1.setText(paramBitmap1.toString());
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    }
    else
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
      this.jdField_b_of_type_Boolean = true;
    }
    if (IGameEngine.a().i())
    {
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(String paramString, RectF paramRectF, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowNewGuideToast rectF = ");
      localStringBuilder.append(paramRectF);
      localStringBuilder.append(", txt: ");
      localStringBuilder.append(paramString);
      QLog.d("OverlayView", 2, localStringBuilder.toString());
    }
    if (paramRectF == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.g.setText(paramString);
    this.g.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = ViewUtils.b(paramInt);
    c(paramRectF);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "playTimeoutShowAnswerAnim");
    }
    d();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.8F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { ViewUtils.a(-76.0F), ViewUtils.a(11.0F), 0.0F });
    localObjectAnimator1.setDuration(360L);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator2.setDuration(360L);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator1).after(0L);
    localAnimatorSet.play(localObjectAnimator2).after(0L);
    localAnimatorSet.setInterpolator(new DecelerateInterpolator());
    localAnimatorSet.start();
  }
  
  public void b(RectF paramRectF)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowGoingToOnStageTipOnMemberSeat rectF = ");
      localStringBuilder.append(paramRectF);
      QLog.d("OverlayView", 2, localStringBuilder.toString());
    }
    if (paramRectF == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.g.setText(2131690337);
    this.g.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = ViewUtils.b(244.0F);
    c(paramRectF);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.postDelayed(new OverlayView.7(this), 3000L);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "onHideNewGuideToast");
    }
    String str = this.g.getText().toString();
    if ((str != null) && (str.equals(paramString)))
    {
      this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
    }
  }
  
  public void b(String paramString, RectF paramRectF, int paramInt)
  {
    String str = this.g.getText().toString();
    if ((this.jdField_a_of_type_Boolean) && (str != null) && (str.equals(paramString)))
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = ViewUtils.b(147.0F);
      c(paramRectF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView
 * JD-Core Version:    0.7.0.1
 */