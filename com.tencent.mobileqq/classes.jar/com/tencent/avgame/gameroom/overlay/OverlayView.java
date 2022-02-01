package com.tencent.avgame.gameroom.overlay;

import agej;
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
import bhtq;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.contact.addcontact.findtroop.BubbleLayout;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.richstatus.sign.RoundCornerRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import myk;
import mze;
import mzj;
import mzu;
import naw;
import nbo;
import nbp;
import nci;
import ncj;
import nck;
import ncl;
import ncm;
import ncn;

public class OverlayView
  extends RelativeLayout
  implements ncj
{
  private int jdField_a_of_type_Int = -855638016;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout.LayoutParams jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AVGameText jdField_a_of_type_ComTencentAvgameUiAVGameText;
  private BubbleLayout jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private RoundCornerRelativeLayout jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout;
  Runnable jdField_a_of_type_JavaLangRunnable = new OverlayView.1(this);
  protected nck a;
  private boolean jdField_a_of_type_Boolean;
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
  private TextView e;
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
    this.jdField_a_of_type_Nck = new nck(this);
    LayoutInflater.from(getContext()).inflate(2131558709, this, true);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)findViewById(2131372796));
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = ((RelativeLayout.LayoutParams)this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.getLayoutParams());
    this.g = ((TextView)findViewById(2131372795));
    this.g.setSelected(true);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setVisibility(8);
    this.f = ((TextView)findViewById(2131362713));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131367651);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131364207));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362705));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131367905));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362706));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362708));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370120));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362013));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362015));
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131362712));
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText = ((AVGameText)findViewById(2131364767));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setAttribute("#FFC000", "#FFFFFF");
    ((TextView)findViewById(2131365085)).setTypeface(AVGameText.a());
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131362711));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout = ((RoundCornerRelativeLayout)findViewById(2131372784));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setRadius(agej.a(12.0F, getResources()));
    this.jdField_b_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout = ((RoundCornerRelativeLayout)findViewById(2131362014));
    this.jdField_b_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setRadius(agej.a(12.0F, getResources()));
    this.e = ((TextView)findViewById(2131377084));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131372789));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372783));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout = ((BubbleLayout)findViewById(2131365385));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365384));
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setSelected(true);
    this.jdField_a_of_type_AndroidViewView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
    c();
  }
  
  private Drawable a()
  {
    mzj localmzj = myk.a().a().a();
    if ((localmzj == null) || (TextUtils.isEmpty(localmzj.f))) {
      return mzu.a("avgame_answer_bg_self@2x.png");
    }
    return URLDrawable.getDrawable(localmzj.f);
  }
  
  private void a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    int i;
    if (paramFloat != 0.0F)
    {
      localLayoutParams.width = agej.a(199.0F, getResources());
      localLayoutParams.height = agej.a(170.0F, getResources());
      localLayoutParams.addRule(13, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.bottomMargin = agej.a(70.0F, getResources());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      localLayoutParams = (RelativeLayout.LayoutParams)this.f.getLayoutParams();
      i = paramString.length();
      if (i < 6) {
        break label292;
      }
      localLayoutParams.topMargin = agej.a(110.0F - paramFloat, getResources());
      if (i == 6) {
        localLayoutParams.topMargin = agej.a(129.0F - paramFloat, getResources());
      }
      localLayoutParams.width = agej.a(140.0F, getResources());
      this.f.setTextSize(1, 22.0F);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OverlayView", 2, "updateAnswerTextLayout answer = " + paramString + ",length = " + i);
      }
      this.f.setLayoutParams(localLayoutParams);
      return;
      localLayoutParams.width = agej.a(198.0F, getResources());
      localLayoutParams.height = agej.a(198.0F, getResources());
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.bottomMargin = 0;
      break;
      label292:
      localLayoutParams.topMargin = agej.a(124.0F - paramFloat, getResources());
      localLayoutParams.width = agej.a(150.0F, getResources());
      this.f.setTextSize(1, 28.0F);
    }
  }
  
  private void c()
  {
    naw.a(getContext(), "avgame_answer_card_star/data.json", "avgame_answer_card_star/images/", 300, 300, new ncl(this));
    naw.a(getContext(), "avgame_answer_head_cheer_friend/data.json", "avgame_answer_head_cheer_friend/images/", 275, 275, new ncm(this));
    naw.a(getContext(), "avgame_answer_head_cheer_self/data.json", "avgame_answer_head_cheer_self/images/", 275, 275, new ncn(this));
  }
  
  private void c(RectF paramRectF)
  {
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setTriangleOffset(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = ((int)paramRectF.top - bhtq.b(42.0F));
    int k = (int)(paramRectF.left + paramRectF.right) / 2;
    int i = k - this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width / 2;
    int m = bhtq.b(12.0F);
    int j;
    if (i < m)
    {
      j = i - m;
      i = m;
    }
    for (;;)
    {
      int n = bhtq.a() - (k + this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width / 2);
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
    localLayoutParams.topMargin = nbo.o;
    localLayoutParams.width = nbo.q;
    localLayoutParams.height = nbo.p;
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
  
  public nci a()
  {
    return this.jdField_a_of_type_Nck;
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
    this.g.setText(2131690251);
    this.g.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = bhtq.b(76.0F);
    c(paramRectF);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.postDelayed(new OverlayView.6(this), 3000L);
  }
  
  void a(LottieDrawable paramLottieDrawable, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "playSuccessfulRaceAnim");
    }
    d();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable);
    this.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(paramLottieDrawable);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.pauseAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
    if (paramLottieDrawable != null)
    {
      paramLottieDrawable.pauseAnimation();
      paramLottieDrawable.playAnimation();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.8F);
    paramLottieDrawable = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { agej.a(-76.0F, getResources()), agej.a(11.0F, getResources()), 0.0F });
    paramLottieDrawable.setDuration(360L);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(360L);
    Object localObject = new AnimatorSet();
    ((AnimatorSet)localObject).play(paramLottieDrawable).after(0L);
    ((AnimatorSet)localObject).play(localObjectAnimator1).after(0L);
    ((AnimatorSet)localObject).setInterpolator(new DecelerateInterpolator());
    ((AnimatorSet)localObject).start();
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setAlpha(0.0F);
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(0.0F);
    paramLottieDrawable = ObjectAnimator.ofFloat(this.jdField_c_of_type_AndroidWidgetTextView, "alpha", new float[] { 0.0F, 1.0F });
    paramLottieDrawable.setDuration(170L);
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(280L);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setPivotX(bhtq.b(100.0F) / 2);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setPivotY(bhtq.b(100.0F));
    localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout, "scaleX", new float[] { 0.74F, 1.1F, 1.0F });
    ((ObjectAnimator)localObject).setDuration(440L);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout, "scaleY", new float[] { 0.74F, 1.1F, 1.0F });
    localObjectAnimator2.setDuration(440L);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setScaleX(0.74F);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.setScaleY(0.74F);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout, "rotation", new float[] { 0.0F, -21.6F, 18.0F, -10.8F, 10.8F, -3.6F, 0.0F });
    localObjectAnimator3.setDuration(720L);
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator4.setDuration(240L);
    ObjectAnimator localObjectAnimator5 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout, "translationY", new float[] { agej.a(8.5F, getResources()), agej.a(-6.5F, getResources()), 0.0F });
    localObjectAnimator5.setDuration(480L);
    localObjectAnimator5.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play((Animator)localObject).after(240L);
    localAnimatorSet.play(localObjectAnimator2).after(240L);
    localAnimatorSet.play(localObjectAnimator3).after(800L);
    localAnimatorSet.play(localObjectAnimator1).after(160L);
    localAnimatorSet.play(paramLottieDrawable).after(270L);
    localAnimatorSet.play(localObjectAnimator4).after(1320L);
    localAnimatorSet.play(localObjectAnimator5).after(1320L);
    localAnimatorSet.start();
    this.e.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignRoundCornerRelativeLayout.postDelayed(new OverlayView.5(this, paramLong1, paramLong2), 1800L);
  }
  
  public void a(String paramString)
  {
    this.f.setText(paramString);
    a(paramString, 0.0F);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(mzu.a("avgame_answer_bg_timeout@2x.png"));
    b();
  }
  
  public void a(String paramString1, Bitmap paramBitmap1, String paramString2, long paramLong1, long paramLong2, long paramLong3, Bitmap paramBitmap2, long paramLong4, boolean paramBoolean)
  {
    this.f.setText(paramString1);
    a(paramString1, 50.0F);
    this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
    this.jdField_d_of_type_AndroidWidgetTextView.setText("+" + paramLong1);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(paramString2);
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(a());
      if (paramLong3 >= 2L)
      {
        this.jdField_a_of_type_ComTencentAvgameUiAVGameText.setText("x" + paramLong3);
        this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        a(this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable, paramLong2 - paramLong1, paramLong2);
        if (this.jdField_b_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
          this.jdField_c_of_type_Boolean = true;
        }
        label157:
        if (paramBitmap2 == null) {
          break label345;
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
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("抢答成功!");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFDE2E"));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      break;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(mzu.a("avgame_answer_bg_friend@2x.png"));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("好友答对了");
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#FFFFFF"));
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      a(this.jdField_c_of_type_ComTencentMobileqqDiniflyLottieDrawable, paramLong2 - paramLong1, paramLong2);
      if (this.jdField_c_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
        break label157;
      }
      this.jdField_d_of_type_Boolean = true;
      break label157;
      label345:
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    }
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
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = bhtq.b(paramInt);
    c(paramRectF);
    this.jdField_b_of_type_ComTencentMobileqqActivityContactAddcontactFindtroopBubbleLayout.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public void a(nbp paramnbp)
  {
    this.jdField_a_of_type_Nck.a(paramnbp);
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "playTimeoutShowAnswerAnim");
    }
    d();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setAlpha(0.8F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_b_of_type_AndroidWidgetRelativeLayout, "translationY", new float[] { agej.a(-76.0F, getResources()), agej.a(11.0F, getResources()), 0.0F });
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
    this.g.setText(2131690273);
    this.g.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = bhtq.b(244.0F);
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
      this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.width = bhtq.b(147.0F);
      c(paramRectF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView
 * JD-Core Version:    0.7.0.1
 */