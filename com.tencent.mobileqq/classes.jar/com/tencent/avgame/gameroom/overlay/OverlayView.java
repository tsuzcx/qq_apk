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
  private RelativeLayout.LayoutParams A;
  private ImageView B;
  private TextView C;
  private TextView D;
  private int E = -855638016;
  private boolean F = false;
  private boolean G;
  private boolean H;
  private boolean I;
  protected OverlayPresenterImp a = new OverlayPresenterImp(this);
  Runnable b = new OverlayView.1(this);
  private View c;
  private RelativeLayout d;
  private RelativeLayout e;
  private RelativeLayout f;
  private RelativeLayout g;
  private RoundCorneredRelativeLayout h;
  private RoundCorneredRelativeLayout i;
  private ImageView j;
  private LottieDrawable k;
  private LinearLayout l;
  private ImageView m;
  private TextView n;
  private TextView o;
  private AVGameText p;
  private RelativeLayout q;
  private ImageView r;
  private LottieDrawable s;
  private LottieDrawable t;
  private TextView u;
  private BubbleLayout v;
  private TextView w;
  private TextView x;
  private ImageView y;
  private BubbleLayout z;
  
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
    LayoutInflater.from(getContext()).inflate(2131624272, this, true);
    this.z = ((BubbleLayout)findViewById(2131440421));
    this.z.setSelected(true);
    this.A = ((RelativeLayout.LayoutParams)this.z.getLayoutParams());
    this.D = ((TextView)findViewById(2131440420));
    this.D.setSelected(true);
    this.z.setVisibility(8);
    this.C = ((TextView)findViewById(2131428404));
    this.c = findViewById(2131434352);
    this.d = ((RelativeLayout)findViewById(2131430323));
    this.e = ((RelativeLayout)findViewById(2131428392));
    this.f = ((RelativeLayout)findViewById(2131434894));
    this.j = ((ImageView)findViewById(2131428393));
    this.r = ((ImageView)findViewById(2131428395));
    this.l = ((LinearLayout)findViewById(2131437402));
    this.m = ((ImageView)findViewById(2131427612));
    this.n = ((TextView)findViewById(2131427614));
    this.n.setTypeface(AVGameText.getTypeface());
    this.o = ((TextView)findViewById(2131428403));
    this.o.setTypeface(AVGameText.getTypeface());
    this.p = ((AVGameText)findViewById(2131431017));
    this.p.setAttribute("#FFC000", "#FFFFFF");
    ((TextView)findViewById(2131431374)).setTypeface(AVGameText.getTypeface());
    this.q = ((RelativeLayout)findViewById(2131428402));
    this.h = ((RoundCorneredRelativeLayout)findViewById(2131440404));
    this.g = ((RelativeLayout)findViewById(2131440403));
    this.h.setRadius(ViewUtils.dip2px(12.0F));
    this.i = ((RoundCorneredRelativeLayout)findViewById(2131427613));
    this.i.setRadius(ViewUtils.dip2px(12.0F));
    this.x = ((TextView)findViewById(2131445327));
    this.u = ((TextView)findViewById(2131440409));
    this.B = ((ImageView)findViewById(2131440401));
    this.v = ((BubbleLayout)findViewById(2131431729));
    this.w = ((TextView)findViewById(2131431728));
    this.v.setSelected(true);
    this.y = ((ImageView)findViewById(2131440402));
    this.y.setVisibility(8);
    this.y.setImageBitmap(AVGameUtil.c("avgame_pk_head_win@2x.png"));
    this.c.setVisibility(4);
    this.d.setVisibility(4);
    this.f.setVisibility(4);
    c();
  }
  
  private void a(String paramString, float paramFloat)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    if (IGameEngine.I().D())
    {
      localLayoutParams.width = ViewUtils.dip2px(205.0F);
      localLayoutParams.height = ViewUtils.dip2px(205.0F);
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.bottomMargin = 0;
    }
    else if (paramFloat != 0.0F)
    {
      localLayoutParams.width = ViewUtils.dip2px(199.0F);
      localLayoutParams.height = ViewUtils.dip2px(170.0F);
      localLayoutParams.addRule(13, 0);
      localLayoutParams.addRule(12, -1);
      localLayoutParams.bottomMargin = ViewUtils.dip2px(70.0F);
    }
    else
    {
      localLayoutParams.width = ViewUtils.dip2px(198.0F);
      localLayoutParams.height = ViewUtils.dip2px(198.0F);
      localLayoutParams.addRule(13, -1);
      localLayoutParams.addRule(12, 0);
      localLayoutParams.bottomMargin = 0;
    }
    this.e.setLayoutParams(localLayoutParams);
    localLayoutParams = (RelativeLayout.LayoutParams)this.C.getLayoutParams();
    int i1 = paramString.length();
    if (IGameEngine.I().D())
    {
      if (i1 >= 6)
      {
        localLayoutParams.topMargin = ViewUtils.dip2px(110.0F);
        if (i1 == 6) {
          localLayoutParams.topMargin = ViewUtils.dip2px(129.0F);
        }
        localLayoutParams.width = ViewUtils.dip2px(140.0F);
        this.C.setTextSize(1, 22.0F);
      }
      else
      {
        localLayoutParams.topMargin = ViewUtils.dip2px(122.0F);
        localLayoutParams.width = ViewUtils.dip2px(150.0F);
        this.C.setTextSize(1, 28.0F);
      }
    }
    else if (i1 >= 6)
    {
      localLayoutParams.topMargin = ViewUtils.dip2px(110.0F - paramFloat);
      if (i1 == 6) {
        localLayoutParams.topMargin = ViewUtils.dip2px(129.0F - paramFloat);
      }
      localLayoutParams.width = ViewUtils.dip2px(140.0F);
      this.C.setTextSize(1, 22.0F);
    }
    else
    {
      localLayoutParams.topMargin = ViewUtils.dip2px(124.0F - paramFloat);
      localLayoutParams.width = ViewUtils.dip2px(150.0F);
      this.C.setTextSize(1, 28.0F);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateAnswerTextLayout answer = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",length = ");
      localStringBuilder.append(i1);
      QLog.d("OverlayView", 2, localStringBuilder.toString());
    }
    this.C.setLayoutParams(localLayoutParams);
  }
  
  private void c()
  {
    AVGameLottieHelper.a(getContext(), "avgame_answer_card_star/data.json", "avgame_answer_card_star/images/", 300, 300, new OverlayView.2(this));
    AVGameLottieHelper.a(getContext(), "avgame_answer_head_cheer_friend/data.json", "avgame_answer_head_cheer_friend/images/", 275, 275, new OverlayView.3(this));
    AVGameLottieHelper.a(getContext(), "avgame_answer_head_cheer_self/data.json", "avgame_answer_head_cheer_self/images/", 275, 275, new OverlayView.4(this));
  }
  
  private void c(RectF paramRectF)
  {
    this.z.setTriangleOffset(0);
    this.A.topMargin = ((int)paramRectF.top - ViewUtils.dpToPx(42.0F));
    int i3 = (int)(paramRectF.left + paramRectF.right) / 2;
    int i1 = i3 - this.A.width / 2;
    int i4 = ViewUtils.dpToPx(12.0F);
    int i2;
    if (i1 < i4)
    {
      i2 = i1 - i4;
      i1 = i4;
    }
    else
    {
      i2 = -1;
    }
    int i5 = ViewUtils.getScreenWidth() - (i3 + this.A.width / 2);
    i3 = i1;
    if (i5 < i4)
    {
      i2 = i4 - i5;
      i3 = i1 - i2;
    }
    if (QLog.isColorLevel())
    {
      paramRectF = new StringBuilder();
      paramRectF.append("updatePlayerTipsLocation offset:");
      paramRectF.append(i2);
      QLog.d("OverlayView", 2, paramRectF.toString());
    }
    if (i2 != -1) {
      this.z.setTriangleOffset(i2);
    }
    paramRectF = this.A;
    paramRectF.leftMargin = i3;
    this.z.setLayoutParams(paramRectF);
  }
  
  private void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.d.getLayoutParams();
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
    this.d.setLayoutParams(localLayoutParams);
  }
  
  private Drawable getSelfAnswerCardDrawable()
  {
    if (!IGameEngine.J()) {
      localObject = IGameEngine.I().s().f();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return AvGameResDownloadUtil.a("avgame_answer_bg_self@2x.png");
    }
    Object localObject = ((GameItem)localObject).i;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return AvGameResDownloadUtil.a("avgame_answer_bg_self@2x.png");
    }
    return URLDrawable.getDrawable((String)localObject);
  }
  
  public void a()
  {
    this.C.setText("");
    this.l.setVisibility(8);
    this.d.setVisibility(8);
    this.f.setVisibility(8);
    this.c.setVisibility(8);
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
    this.z.setVisibility(0);
    this.z.setSelected(true);
    this.D.setText(2131887222);
    this.D.setTextSize(1, 14.0F);
    this.A.width = ViewUtils.dpToPx(76.0F);
    c(paramRectF);
    this.z.postDelayed(new OverlayView.6(this), 3000L);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.a.a(paramIGameRoomPresenter);
  }
  
  void a(LottieDrawable paramLottieDrawable, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "playSuccessfulRaceAnim");
    }
    d();
    this.d.setVisibility(0);
    if ((IGameEngine.I().D()) && (!paramBoolean))
    {
      this.j.setVisibility(4);
    }
    else
    {
      this.j.setVisibility(0);
      this.j.setImageDrawable(this.k);
      localObject1 = this.k;
      if (localObject1 != null)
      {
        ((LottieDrawable)localObject1).pauseAnimation();
        this.k.playAnimation();
      }
    }
    this.c.setVisibility(0);
    this.c.setAlpha(0.8F);
    Object localObject1 = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { ViewUtils.dip2px(-76.0F), ViewUtils.dip2px(11.0F), 0.0F });
    ((ObjectAnimator)localObject1).setDuration(360L);
    this.e.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator1.setDuration(360L);
    Object localObject2 = new AnimatorSet();
    ((AnimatorSet)localObject2).play((Animator)localObject1).after(0L);
    ((AnimatorSet)localObject2).play(localObjectAnimator1).after(0L);
    ((AnimatorSet)localObject2).setInterpolator(new DecelerateInterpolator());
    ((AnimatorSet)localObject2).start();
    if ((IGameEngine.I().A()) && (!paramBoolean)) {
      return;
    }
    this.f.setVisibility(0);
    this.r.setImageDrawable(paramLottieDrawable);
    if (paramLottieDrawable != null)
    {
      paramLottieDrawable.pauseAnimation();
      paramLottieDrawable.playAnimation();
    }
    this.g.setAlpha(0.0F);
    this.u.setAlpha(0.0F);
    paramLottieDrawable = ObjectAnimator.ofFloat(this.u, "alpha", new float[] { 0.0F, 1.0F });
    paramLottieDrawable.setDuration(170L);
    localObject1 = ObjectAnimator.ofFloat(this.g, "alpha", new float[] { 0.0F, 1.0F });
    ((ObjectAnimator)localObject1).setDuration(280L);
    this.g.setPivotX(ViewUtils.dpToPx(100.0F) / 2);
    this.g.setPivotY(ViewUtils.dpToPx(100.0F));
    localObjectAnimator1 = ObjectAnimator.ofFloat(this.g, "scaleX", new float[] { 0.74F, 1.1F, 1.0F });
    localObjectAnimator1.setDuration(440L);
    localObject2 = ObjectAnimator.ofFloat(this.g, "scaleY", new float[] { 0.74F, 1.1F, 1.0F });
    ((ObjectAnimator)localObject2).setDuration(440L);
    this.g.setScaleX(0.74F);
    this.g.setScaleY(0.74F);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.g, "rotation", new float[] { 0.0F, -21.6F, 18.0F, -10.8F, 10.8F, -3.6F, 0.0F });
    localObjectAnimator2.setDuration(720L);
    if (IGameEngine.I().D())
    {
      this.v.setSelectedColor("#FC5E31");
      this.w.setTextColor(Color.parseColor("#FFFFFF"));
    }
    this.v.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator3 = ObjectAnimator.ofFloat(this.v, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator3.setDuration(240L);
    ObjectAnimator localObjectAnimator4 = ObjectAnimator.ofFloat(this.v, "translationY", new float[] { ViewUtils.dip2px(8.5F), ViewUtils.dip2px(-6.5F), 0.0F });
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
    this.x.setVisibility(4);
    this.h.postDelayed(new OverlayView.5(this, paramLong1, paramLong2), 1800L);
  }
  
  public void a(String paramString)
  {
    this.C.setText(paramString);
    a(paramString, 0.0F);
    this.o.setVisibility(8);
    this.l.setVisibility(8);
    this.q.setVisibility(8);
    this.e.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_answer_bg_timeout@2x.png"));
    b();
    paramString = IGameEngine.I().s();
    if (paramString.N())
    {
      int i1;
      if (paramString.O()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_result_wrong", "survival_result_wrong", i1, 0, String.valueOf(paramString.h().f.a), String.valueOf(paramString.Y()), CJSurvivalReporterUtil.a().b(paramString), String.valueOf(paramString.Q()));
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap1, String paramString2, long paramLong1, long paramLong2, long paramLong3, Bitmap paramBitmap2, long paramLong4, boolean paramBoolean)
  {
    this.C.setText(paramString1);
    a(paramString1, 50.0F);
    this.B.setImageBitmap(paramBitmap1);
    paramString1 = this.w;
    paramBitmap1 = new StringBuilder();
    paramBitmap1.append("+");
    paramBitmap1.append(paramLong1);
    paramString1.setText(paramBitmap1.toString());
    this.u.setText(paramString2);
    if (paramBoolean)
    {
      this.e.setBackgroundDrawable(getSelfAnswerCardDrawable());
      if (paramLong3 >= 2L)
      {
        paramString1 = this.p;
        paramBitmap1 = new StringBuilder();
        paramBitmap1.append("x");
        paramBitmap1.append(paramLong3);
        paramString1.setText(paramBitmap1.toString());
        this.q.setVisibility(0);
        this.o.setVisibility(8);
      }
      else
      {
        if (IGameEngine.I().D())
        {
          this.o.setText("");
          this.o.setVisibility(8);
        }
        else
        {
          this.o.setVisibility(0);
          this.o.setText("抢答成功!");
        }
        this.o.setTextColor(Color.parseColor("#FFDE2E"));
        this.q.setVisibility(8);
      }
      a(this.s, paramLong2 - paramLong1, paramLong2, true);
      if (this.s == null) {
        this.H = true;
      }
    }
    else
    {
      this.e.setBackgroundDrawable(AvGameResDownloadUtil.a("avgame_answer_bg_friend@2x.png"));
      if (IGameEngine.I().D())
      {
        this.o.setVisibility(8);
        this.o.setText("");
      }
      else
      {
        this.o.setText("好友答对了");
        this.o.setTextColor(Color.parseColor("#FFFFFF"));
        this.o.setVisibility(0);
      }
      this.q.setVisibility(8);
      a(this.t, paramLong2 - paramLong1, paramLong2, false);
      if (this.t == null) {
        this.I = true;
      }
    }
    paramString1 = IGameEngine.I().s();
    if (paramString1.N())
    {
      int i1;
      if (paramString1.O()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_result_right", "survival_result_right", i1, 0, String.valueOf(paramString1.h().f.a), String.valueOf(paramString1.Y()), CJSurvivalReporterUtil.a().b(paramString1), String.valueOf(paramString1.Q()));
    }
    if (paramBitmap2 != null)
    {
      this.m.setImageBitmap(paramBitmap2);
      paramString1 = this.n;
      paramBitmap1 = new StringBuilder();
      paramBitmap1.append("表演成功 +");
      paramBitmap1.append(paramLong4);
      paramString1.setText(paramBitmap1.toString());
      this.l.setVisibility(0);
    }
    else
    {
      this.l.setVisibility(8);
    }
    if (this.k == null) {
      this.G = true;
    }
    if (IGameEngine.I().D())
    {
      this.y.setVisibility(0);
      return;
    }
    this.y.setVisibility(8);
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
    this.F = true;
    this.z.setVisibility(0);
    this.z.setSelected(true);
    this.D.setText(paramString);
    this.D.setTextSize(1, 14.0F);
    this.A.width = ViewUtils.dpToPx(paramInt);
    c(paramRectF);
    this.z.postDelayed(this.b, 3000L);
  }
  
  void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "playTimeoutShowAnswerAnim");
    }
    d();
    this.d.setVisibility(0);
    this.j.setVisibility(4);
    this.c.setVisibility(0);
    this.c.setAlpha(0.8F);
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.e, "translationY", new float[] { ViewUtils.dip2px(-76.0F), ViewUtils.dip2px(11.0F), 0.0F });
    localObjectAnimator1.setDuration(360L);
    this.e.setAlpha(0.0F);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.e, "alpha", new float[] { 0.0F, 1.0F });
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
    this.z.setVisibility(0);
    this.z.setSelected(true);
    this.D.setText(2131887248);
    this.D.setTextSize(1, 14.0F);
    this.A.width = ViewUtils.dpToPx(244.0F);
    c(paramRectF);
    this.z.postDelayed(new OverlayView.7(this), 3000L);
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OverlayView", 2, "onHideNewGuideToast");
    }
    String str = this.D.getText().toString();
    if ((str != null) && (str.equals(paramString)))
    {
      this.z.removeCallbacks(this.b);
      this.z.setVisibility(8);
    }
  }
  
  public void b(String paramString, RectF paramRectF, int paramInt)
  {
    String str = this.D.getText().toString();
    if ((this.F) && (str != null) && (str.equals(paramString)))
    {
      this.A.width = ViewUtils.dpToPx(147.0F);
      c(paramRectF);
    }
  }
  
  public View getAnswerCardWrapperView()
  {
    return this.e;
  }
  
  public int getAnswerCoverColor()
  {
    return this.E;
  }
  
  public IOverlayPresenter getPresenter()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.overlay.OverlayView
 * JD-Core Version:    0.7.0.1
 */