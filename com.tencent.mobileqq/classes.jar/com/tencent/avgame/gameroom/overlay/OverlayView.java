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
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.GameItem;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.avgame.gameroom.GameRoomViewLayoutParamsDef;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.richstatus.sign.RoundCornerRelativeLayout;
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
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private RoundCornerRelativeLayout jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout;
  Runnable jdField_a_of_type_JavaLangRunnable = new OverlayView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private BubbleLayout jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private LottieDrawable jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private RoundCornerRelativeLayout jdField_b_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout;
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
    LayoutInflater.from(getContext()).inflate(2131558756, this, true);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)findViewById(2131373283));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.getLayoutParams());
    this.g = ((TextView)findViewById(2131373282));
    this.g.setSelected(true);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
    this.f = ((TextView)findViewById(2131362763));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131368027);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364409));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362755));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131368292));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362756));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362758));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370559));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362019));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362021));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362762));
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131365008));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
    ((TextView)findViewById(2131365336)).setTypeface(AVGameText.a());
    this.jdField_e_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362761));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout = ((RoundCornerRelativeLayout)findViewById(2131373270));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131373269));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setRadius(AIOUtils.a(12.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout = ((RoundCornerRelativeLayout)findViewById(2131362020));
    this.jdField_b_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setRadius(AIOUtils.a(12.0F, getResources()));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377520));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131373275));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373267));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)findViewById(2131365671));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365670));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131373268));
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(AVGameUtils.a("avgame_pk_head_win@2x.png"));
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    c();
  }
  
  private Drawable a()
  {
    Object localObject = GameEngine.a().a().a();
    if (localObject == null) {
      return AvGameResDownloadManager.a("avgame_answer_bg_self@2x.png");
    }
    localObject = ((GameItem)localObject).g;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return AvGameResDownloadManager.a("avgame_answer_bg_self@2x.png");
    }
    return URLDrawable.getDrawable((String)localObject);
  }
  
  private void a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i;
    if (GameEngine.a().i())
    {
      localLayoutParams.width = AIOUtils.a(205.0F, getResources());
      localLayoutParams.height = AIOUtils.a(205.0F, getResources());
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.bottomMargin = 0;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      i = paramString.length();
      if (!GameEngine.a().i()) {
        break label406;
      }
      if (i < 6) {
        break label362;
      }
      localLayoutParams.topMargin = AIOUtils.a(110.0F, getResources());
      if (i == 6) {
        localLayoutParams.topMargin = AIOUtils.a(129.0F, getResources());
      }
      localLayoutParams.width = AIOUtils.a(140.0F, getResources());
      this.f.setTextSize(1, 22.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OverlayView", 2, "updateAnswerTextLayout answer = " + paramString + ",length = " + i);
      }
      this.f.setLayoutParams(localLayoutParams);
      return;
      if (paramFloat != 0.0F)
      {
        localLayoutParams.width = AIOUtils.a(199.0F, getResources());
        localLayoutParams.height = AIOUtils.a(170.0F, getResources());
        localLayoutParams.addRule(13, 0);
        localLayoutParams.addRule(12, -1);
        localLayoutParams.bottomMargin = AIOUtils.a(70.0F, getResources());
        break;
      }
      localLayoutParams.width = AIOUtils.a(198.0F, getResources());
      localLayoutParams.height = AIOUtils.a(198.0F, getResources());
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.bottomMargin = 0;
      break;
      label362:
      localLayoutParams.topMargin = AIOUtils.a(122.0F, getResources());
      localLayoutParams.width = AIOUtils.a(150.0F, getResources());
      this.f.setTextSize(1, 28.0F);
      continue;
      label406:
      if (i >= 6)
      {
        localLayoutParams.topMargin = AIOUtils.a(110.0F - paramFloat, getResources());
        if (i == 6) {
          localLayoutParams.topMargin = AIOUtils.a(129.0F - paramFloat, getResources());
        }
        localLayoutParams.width = AIOUtils.a(140.0F, getResources());
        this.f.setTextSize(1, 22.0F);
      }
      else
      {
        localLayoutParams.topMargin = AIOUtils.a(124.0F - paramFloat, getResources());
        localLayoutParams.width = AIOUtils.a(150.0F, getResources());
        this.f.setTextSize(1, 28.0F);
      }
    }
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
    for (;;)
    {
      int n = ViewUtils.a() - (k + this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width / 2);
      k = j;
      j = i;
      if (n < m)
      {
        k = m - n;
        j = i - (m - n);
      }
      if (QLog.isColorLevel()) {
        QLog.d("OverlayView", 2, "updatePlayerTipsLocation offset:" + k);
      }
      if (k != -1) {
        this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setTriangleOffset(k);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = j;
      this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
      return;
      j = -1;
    }
  }
  
  private void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    localLayoutParams.topMargin = GameRoomViewLayoutParamsDef.l;
    localLayoutParams.width = GameRoomViewLayoutParamsDef.o;
    localLayoutParams.height = GameRoomViewLayoutParamsDef.n;
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "updateCardAnimWrapperLP topMargin = " + localLayoutParams.topMargin + ",width = " + localLayoutParams.width + ",height = " + localLayoutParams.height);
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
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "onShowDesigningTopicTipOnMemberSeat rectF = " + paramRectF);
    }
    if (paramRectF == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.g.setText(2131690387);
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
    if ((!GameEngine.a().i()) || (paramBoolean))
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
        this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setAlpha(0.8F);
      localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { AIOUtils.a(-76.0F, getResources()), AIOUtils.a(11.0F, getResources()), 0.0F });
      localObjectAnimator1.setDuration(360L);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.0F);
      localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
      localObjectAnimator2.setDuration(360L);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).play(localObjectAnimator1).after(0L);
      ((AnimatorSet)localObject).play(localObjectAnimator2).after(0L);
      ((AnimatorSet)localObject).setInterpolator(new DecelerateInterpolator());
      ((AnimatorSet)localObject).start();
      if ((!GameEngine.a().f()) || (paramBoolean)) {
        break;
      }
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
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
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(280L);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPivotX(ViewUtils.b(100.0F) / 2);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setPivotY(ViewUtils.b(100.0F));
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "scaleX", new float[] { 0.74F, 1.1F, 1.0F });
    localObjectAnimator2.setDuration(440L);
    Object localObject = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "scaleY", new float[] { 0.74F, 1.1F, 1.0F });
    ((ObjectAnimator)localObject).setDuration(440L);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setScaleX(0.74F);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setScaleY(0.74F);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_d_of_type_AndroidWidgetRelativeLayout, "rotation", new float[] { 0.0F, -21.6F, 18.0F, -10.8F, 10.8F, -3.6F, 0.0F });
    localObjectAnimator3.setDuration(720L);
    if (GameEngine.a().i())
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelectedColor("#FC5E31");
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator4.setDuration(240L);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout, "translationY", new float[] { AIOUtils.a(8.5F, getResources()), AIOUtils.a(-6.5F, getResources()), 0.0F });
    localObjectAnimator5.setDuration(480L);
    localObjectAnimator5.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localObjectAnimator2).after(240L);
    localAnimatorSet.play((Animator)localObject).after(240L);
    localAnimatorSet.play(localObjectAnimator3).after(800L);
    localAnimatorSet.play(localObjectAnimator1).after(160L);
    localAnimatorSet.play(paramLottieDrawable).after(270L);
    localAnimatorSet.play(localObjectAnimator4).after(1320L);
    localAnimatorSet.play(localObjectAnimator5).after(1320L);
    localAnimatorSet.start();
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.postDelayed(new OverlayView.5(this, paramLong1, paramLong2), 1800L);
  }
  
  public void a(String paramString)
  {
    this.f.setText(paramString);
    a(paramString, 0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadManager.a("avgame_answer_bg_timeout@2x.png"));
    b();
    CJSurvivalFestivalReporter.a(6, 0, false);
  }
  
  public void a(String paramString1, Bitmap paramBitmap1, String paramString2, long paramLong1, long paramLong2, long paramLong3, Bitmap paramBitmap2, long paramLong4, boolean paramBoolean)
  {
    this.f.setText(paramString1);
    a(paramString1, 50.0F);
    this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("+" + paramLong1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a());
      if (paramLong3 >= 2L)
      {
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText("x" + paramLong3);
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        a(this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable, paramLong2 - paramLong1, paramLong2, true);
        if (this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
          this.jdField_c_of_type_Boolean = true;
        }
        CJSurvivalFestivalReporter.a(6, 0, true, paramBoolean);
        if (paramBitmap2 == null) {
          break label435;
        }
        this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap2);
        this.jdField_a_of_type_AndroidWidgetTextView.setText("表演成功 +" + paramLong4);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
        this.jdField_b_of_type_Boolean = true;
      }
      if (!GameEngine.a().i()) {
        break label447;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
      if (GameEngine.a().i())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFDE2E"));
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("抢答成功!");
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(AvGameResDownloadManager.a("avgame_answer_bg_friend@2x.png"));
      if (GameEngine.a().i())
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      }
      for (;;)
      {
        this.jdField_e_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        a(this.jdField_c_of_type_ComTencentMobileqqDiniflyLottieDrawable, paramLong2 - paramLong1, paramLong2, false);
        if (this.jdField_c_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
          break;
        }
        this.jdField_d_of_type_Boolean = true;
        break;
        this.jdField_b_of_type_AndroidWidgetTextView.setText("好友答对了");
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      label435:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
    label447:
    this.jdField_d_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void a(String paramString, RectF paramRectF, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "onShowNewGuideToast rectF = " + paramRectF + ", txt: " + paramString);
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
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { AIOUtils.a(-76.0F, getResources()), AIOUtils.a(11.0F, getResources()), 0.0F });
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
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "onShowGoingToOnStageTipOnMemberSeat rectF = " + paramRectF);
    }
    if (paramRectF == null) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(0);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.g.setText(2131690413);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView
 * JD-Core Version:    0.7.0.1
 */