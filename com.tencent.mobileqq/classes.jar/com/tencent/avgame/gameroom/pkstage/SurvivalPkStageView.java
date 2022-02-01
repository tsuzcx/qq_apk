package com.tencent.avgame.gameroom.pkstage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.config.AvGameConfigUtil;
import com.tencent.avgame.config.data.AvGameConfBean;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.ui.AVGameSplitNumberView;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class SurvivalPkStageView
  extends CoverRoundCornerRelativeLayout
  implements ISurvivalStageView
{
  public static String j = "https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_bg.png";
  private static String k = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_win_bg.png";
  private static String l = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_suc2.png";
  private static String m = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail_bg.png";
  private static String n = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail.png";
  private ISurvivalStagePresenter o;
  private TextView p;
  private TextView q;
  private RelativeLayout r;
  private AVGameSplitNumberView s;
  private ImageView t;
  private RelativeLayout u;
  private TextView v;
  private TextView w;
  private TextView x;
  private ImageView y;
  
  public SurvivalPkStageView(Context paramContext)
  {
    this(paramContext, null);
    g();
  }
  
  public SurvivalPkStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    g();
  }
  
  public SurvivalPkStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return paramString2;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AvGameResDownloadUtil.c());
      localStringBuilder.append(paramString1);
      if (FileUtils.fileExistsAndNotEmpty(localStringBuilder.toString())) {
        return paramString1;
      }
    }
    return paramString2;
  }
  
  private void a(View paramView)
  {
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F });
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 0.5F, 1.0F, 1.15F, 0.94F, 1.02F, 1.0F });
    paramView = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 0.5F, 1.0F, 1.15F, 0.94F, 1.02F, 1.0F });
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.setDuration(1500L);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
    localAnimatorSet.start();
  }
  
  private void a(View paramView, String paramString1, String paramString2)
  {
    a(paramView, null, paramString1, paramString2);
  }
  
  private void a(View paramView, String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString1));
      return;
    }
    paramString1 = AVGameUtil.c(paramString2);
    if (paramString1 != null)
    {
      paramView.setBackgroundDrawable(new BitmapDrawable(paramString1));
      return;
    }
    paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString3));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = AVGameUtil.c(paramString);
    if (paramString != null) {
      paramImageView.setImageBitmap(paramString);
    }
  }
  
  private String b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:///");
    localStringBuilder.append(AvGameResDownloadUtil.c());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (((this.s != null) && (paramBoolean) && (IGameEngine.I().D())) || ((this.s != null) && (!IGameEngine.I().D()))) {
      this.s.a(paramInt);
    }
    if ((this.p != null) && (!paramBoolean) && (IGameEngine.I().D())) {
      this.p.setText(String.format(getContext().getResources().getString(2131887379), new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  private void b(ImageView paramImageView, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramImageView.getWidth();
    localURLDrawableOptions.mRequestHeight = paramImageView.getHeight();
    localURLDrawableOptions.mUseApngImage = true;
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = b(paramString);
    }
    paramImageView.setImageDrawable(URLDrawable.getDrawable(str, localURLDrawableOptions));
  }
  
  private void g()
  {
    this.o = new GameSurvivalPkPresenterImpl(this);
    setRadius(getContext().getResources().getColor(2131165547), ViewUtils.dpToPx(16.0F));
    this.r = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131624327, null));
    this.p = ((TextView)this.r.findViewById(2131448783));
    this.q = ((TextView)this.r.findViewById(2131448784));
    this.s = ((AVGameSplitNumberView)this.r.findViewById(2131436606));
    this.t = ((ImageView)this.r.findViewById(2131436605));
    this.s.setDimension(ViewUtils.dpToPx(61.0F), ViewUtils.dpToPx(99.0F));
    this.s.setNumDrawable(getConveneNumber());
    b(0, false);
    this.r.setVisibility(8);
    this.u = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131624328, null));
    this.v = ((TextView)this.u.findViewById(2131448787));
    this.w = ((TextView)this.u.findViewById(2131448786));
    this.x = ((TextView)this.u.findViewById(2131448785));
    this.v.setTypeface(AVGameText.getTypeface());
    this.w.setTypeface(AVGameText.getTypeface());
    this.x.setTypeface(AVGameText.getTypeface());
    this.u.setVisibility(8);
    this.y = new ImageView(getContext());
    this.y.setVisibility(0);
    a(this.y, "avgame_pk_stage_suc.png", l);
    a(this.y, "avgame_pk_stage_fail.png", n);
    a(this, "avgame_pk_stage_win_bg.png", k);
    a(this, "avgame_pk_stage_fail_bg.png", m);
    a(this, "avgame_room_survival_bg.png", j);
  }
  
  private int getContentMarginForCJ()
  {
    if (IGameEngine.I().D()) {
      return getResources().getDimensionPixelOffset(2131296916);
    }
    return 0;
  }
  
  private List<Bitmap> getConveneNumber()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      localArrayList.add(AVGameUtil.c(String.format("avgame_pk_match_num%d@2x.png", new Object[] { Integer.valueOf(i) })));
      i += 1;
    }
    return localArrayList;
  }
  
  private void h()
  {
    this.p.setVisibility(0);
    this.q.setVisibility(0);
    this.s.setVisibility(4);
    this.t.setVisibility(4);
    this.q.setText(getContext().getResources().getString(2131887378));
    b(0, false);
  }
  
  private void i()
  {
    if (this.y.getParent() != null) {
      removeView(this.y);
    }
    this.y.setVisibility(0);
    addView(this.y, -1, -1);
    if (this.u.getVisibility() != 0)
    {
      if (this.u.getParent() != null) {
        removeView(this.u);
      }
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      addView(this.u, (ViewGroup.LayoutParams)localObject);
      localObject = this.u;
      ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), getContentMarginForCJ(), this.u.getPaddingRight(), this.u.getPaddingBottom());
      this.u.setVisibility(0);
    }
    this.u.bringToFront();
  }
  
  private void j()
  {
    if (this.y.getParent() != null) {
      removeView(this.y);
    }
    if (this.u.getVisibility() == 0)
    {
      if (this.u.getParent() != null) {
        removeView(this.u);
      }
      this.u.setVisibility(8);
    }
  }
  
  private void k()
  {
    if (this.r.getVisibility() != 0)
    {
      if (this.r.getParent() != null) {
        removeView(this.r);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = getContentMarginForCJ();
      addView(this.r, localLayoutParams);
      this.r.setVisibility(0);
    }
    a(this, "avgame_room_survival_bg.png", j);
    this.p.setVisibility(0);
    this.q.setVisibility(0);
    this.s.setVisibility(0);
    this.t.setVisibility(0);
  }
  
  private void l()
  {
    if (this.r.getVisibility() == 0)
    {
      if (this.r.getParent() != null) {
        removeView(this.r);
      }
      this.r.setVisibility(8);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalPkStageView", 2, "onShowLoseThisRun run");
    }
    ApngImage.resumeAll();
    b(this.y, a("avgame_pk_stage_fail.png", n));
    l();
    i();
    this.v.setVisibility(0);
    this.w.setVisibility(0);
    this.v.setText(getResources().getString(2131887386));
    if (!IGameEngine.J()) {
      this.v.setTextColor(Color.parseColor(IGameEngine.I().s().x.I));
    }
    this.w.setText(getResources().getString(2131887385));
    this.x.setText(getResources().getString(2131887384));
    this.x.setTextSize(1, 24.0F);
    a(this, "avgame_pk_stage_fail_bg.png", m);
    a(this.t, "avgame_pk_left_user@2x.png");
    a(this.u);
    EngineData localEngineData = IGameEngine.I().s();
    if (localEngineData.N())
    {
      int i;
      if (localEngineData.O()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_term_result_lose", "survival_term_result_lose", i, 0, "", "", "", String.valueOf(localEngineData.Q()));
    }
  }
  
  public void a(int paramInt)
  {
    this.p.setTextColor(paramInt);
    this.q.setTextColor(paramInt);
    this.v.setTextColor(paramInt);
    this.w.setTextColor(paramInt);
    this.x.setTextColor(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i;
      if ((!IGameEngine.J()) && (IGameEngine.I().s().S() > paramInt)) {
        i = IGameEngine.I().s().S() - paramInt;
      } else {
        i = 0;
      }
      String str = String.format(getContext().getResources().getString(2131887383), new Object[] { Integer.valueOf(i) });
      this.q.setText(str);
    }
    else if (IGameEngine.I().D())
    {
      this.q.setText(getContext().getResources().getString(2131887378));
    }
    else
    {
      this.q.setText("");
    }
    b(paramInt, paramBoolean);
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData.X() == 3)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.o.a(paramIGameRoomPresenter);
  }
  
  public void a(String paramString)
  {
    a(this, paramString, "avgame_room_survival_bg.png", j);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalPkStageView", 2, String.format("updatePKBgUrl() conveneBgUrl=%s pkWinBgUrl=%s pkWinTopUrl=%s pkLoseBgUrl=%s pkLoseTopUrl=%s", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 }));
    }
    if (paramString1 != null) {
      j = paramString1;
    }
    if (paramString2 != null) {
      k = paramString2;
    }
    if (paramString3 != null) {
      l = paramString3;
    }
    if (paramString4 != null) {
      m = paramString4;
    }
    if (paramString5 != null) {
      n = paramString5;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (!IGameEngine.J())
    {
      i = IGameEngine.I().s().Z().winReason;
      localObject = IGameEngine.I().s().Z().winTips;
    }
    else
    {
      localObject = null;
      i = 0;
    }
    b(this.y, a("avgame_pk_stage_suc.png", l));
    l();
    i();
    this.v.setVisibility(0);
    this.w.setVisibility(0);
    this.v.setText(getResources().getString(2131887391));
    if (!IGameEngine.J()) {
      this.v.setTextColor(Color.parseColor(IGameEngine.I().s().x.H));
    }
    if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      this.w.setText((CharSequence)localObject);
    } else {
      this.w.setText(getResources().getString(2131887390));
    }
    if (paramBoolean) {
      this.x.setText(getResources().getString(2131887382));
    } else {
      this.x.setText(getResources().getString(2131887389));
    }
    this.x.setTextSize(1, 24.0F);
    a(this, "avgame_pk_stage_win_bg.png", k);
    a(this.t, "avgame_pk_left_user@2x.png");
    a(this.u);
    Object localObject = IGameEngine.I().s();
    if (((EngineData)localObject).N())
    {
      if (((EngineData)localObject).O()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_term_result_win", "survival_term_result_win", i, 0, "", "", String.valueOf(((EngineData)localObject).R()), String.valueOf(((EngineData)localObject).Q()));
    }
  }
  
  public void b()
  {
    ApngImage.pauseAll();
    j();
    k();
    if (!IGameEngine.I().D())
    {
      f();
      a(this.t, "avgame_pk_joined_user@2x.png");
      this.t.setVisibility(0);
      return;
    }
    h();
  }
  
  public void c()
  {
    j();
    k();
    String str;
    if (!IGameEngine.J()) {
      str = IGameEngine.I().s().af();
    } else {
      str = null;
    }
    AvGameConfBean localAvGameConfBean = AvGameConfigUtil.a();
    if (TextUtils.isEmpty(str)) {
      if (!TextUtils.isEmpty(localAvGameConfBean.n())) {
        str = localAvGameConfBean.n();
      } else {
        str = getContext().getResources().getString(2131887396);
      }
    }
    this.p.setText(str);
    a(this.t, "avgame_pk_left_user@2x.png");
  }
  
  public void d()
  {
    l();
    i();
    if (this.y.getParent() != null) {
      removeView(this.y);
    }
    this.v.setVisibility(8);
    this.w.setVisibility(0);
    this.w.setText(getResources().getString(2131887381));
    this.x.setText(getResources().getString(2131887380));
    this.x.setTextSize(1, 24.0F);
    a(this, null, "avgame_room_survival_bg.png", j);
  }
  
  public void e()
  {
    l();
    i();
    this.v.setVisibility(0);
    this.w.setVisibility(0);
    this.x.setVisibility(0);
    this.v.setText(getResources().getString(2131887391));
    if (!IGameEngine.J()) {
      this.v.setTextColor(Color.parseColor(IGameEngine.I().s().x.H));
    }
    this.w.setText(getResources().getString(2131887393));
    this.x.setText(getResources().getString(2131887392));
    a(this, "avgame_room_survival_bg.png", j);
    EngineData localEngineData = IGameEngine.I().s();
    if (localEngineData.N())
    {
      int i;
      if (localEngineData.O()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_term_result_win", "survival_term_result_win", i, 0, "", "", String.valueOf(localEngineData.R()), String.valueOf(localEngineData.Q()));
    }
  }
  
  public void f()
  {
    int i;
    if (!IGameEngine.J()) {
      i = IGameEngine.I().s().aa();
    } else {
      i = 0;
    }
    String str = getContext().getResources().getString(2131887388);
    if (i > 0) {
      str = String.format(str, new Object[] { Integer.valueOf(i) });
    } else {
      str = str.split("\n")[0];
    }
    this.p.setText(str);
  }
  
  public ISurvivalStagePresenter getPresenter()
  {
    return this.o;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.pkstage.SurvivalPkStageView
 * JD-Core Version:    0.7.0.1
 */