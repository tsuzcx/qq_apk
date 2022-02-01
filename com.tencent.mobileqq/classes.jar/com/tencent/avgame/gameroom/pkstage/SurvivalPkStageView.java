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
  public static String a = "https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_bg.png";
  private static String jdField_b_of_type_JavaLangString = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_win_bg.png";
  private static String jdField_c_of_type_JavaLangString = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_suc2.png";
  private static String jdField_d_of_type_JavaLangString = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail_bg.png";
  private static String jdField_e_of_type_JavaLangString = "https://static-res.qq.com/static-res/avgames/survival/avgame_pk_stage_fail.png";
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ISurvivalStagePresenter jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter;
  private AVGameSplitNumberView jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  
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
  
  private int a()
  {
    if (IGameEngine.a().i()) {
      return getResources().getDimensionPixelOffset(2131296614);
    }
    return 0;
  }
  
  private String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("file:///");
    localStringBuilder.append(AvGameResDownloadUtil.c());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
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
  
  private List<Bitmap> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      localArrayList.add(AVGameUtil.a(String.format("avgame_pk_match_num%d@2x.png", new Object[] { Integer.valueOf(i) })));
      i += 1;
    }
    return localArrayList;
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
    paramString1 = AVGameUtil.a(paramString2);
    if (paramString1 != null)
    {
      paramView.setBackgroundDrawable(new BitmapDrawable(paramString1));
      return;
    }
    paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString3));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = AVGameUtil.a(paramString);
    if (paramString != null) {
      paramImageView.setImageBitmap(paramString);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (((this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView != null) && (paramBoolean) && (IGameEngine.a().i())) || ((this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView != null) && (!IGameEngine.a().i()))) {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a(paramInt);
    }
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!paramBoolean) && (IGameEngine.a().i())) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(getContext().getResources().getString(2131690468), new Object[] { Integer.valueOf(paramInt) }));
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
      str = a(paramString);
    }
    paramImageView.setImageDrawable(URLDrawable.getDrawable(str, localURLDrawableOptions));
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter = new GameSurvivalPkPresenterImpl(this);
    setRadius(getContext().getResources().getColor(2131165311), ViewUtils.b(16.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558710, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379909));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379910));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView = ((AVGameSplitNumberView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369519));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369518));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setDimension(ViewUtils.b(61.0F), ViewUtils.b(99.0F));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setNumDrawable(a());
    b(0, false);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558711, null));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379913));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379912));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131379911));
    this.jdField_c_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_d_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_e_of_type_AndroidWidgetTextView.setTypeface(AVGameText.a());
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    a(this.jdField_b_of_type_AndroidWidgetImageView, "avgame_pk_stage_suc.png", jdField_c_of_type_JavaLangString);
    a(this.jdField_b_of_type_AndroidWidgetImageView, "avgame_pk_stage_fail.png", jdField_e_of_type_JavaLangString);
    a(this, "avgame_pk_stage_win_bg.png", jdField_b_of_type_JavaLangString);
    a(this, "avgame_pk_stage_fail_bg.png", jdField_d_of_type_JavaLangString);
    a(this, "avgame_room_survival_bg.png", jdField_a_of_type_JavaLangString);
  }
  
  private void h()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131690467));
    b(0, false);
  }
  
  private void i()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    addView(this.jdField_b_of_type_AndroidWidgetImageView, -1, -1);
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)
    {
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      Object localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
      localObject = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      ((RelativeLayout)localObject).setPadding(((RelativeLayout)localObject).getPaddingLeft(), a(), this.jdField_b_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetRelativeLayout.getPaddingBottom());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.bringToFront();
  }
  
  private void j()
  {
    if (this.jdField_b_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.topMargin = a();
      addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    a(this, "avgame_room_survival_bg.png", jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null) {
        removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public ISurvivalStagePresenter a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalPkStageView", 2, "onShowLoseThisRun run");
    }
    ApngImage.resumeAll();
    b(this.jdField_b_of_type_AndroidWidgetImageView, a("avgame_pk_stage_fail.png", jdField_e_of_type_JavaLangString));
    l();
    i();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690475));
    if (!IGameEngine.k()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(IGameEngine.a().a().a.A));
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690474));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690473));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 24.0F);
    a(this, "avgame_pk_stage_fail_bg.png", jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_left_user@2x.png");
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    EngineData localEngineData = IGameEngine.a().a();
    if (localEngineData.g())
    {
      int i;
      if (localEngineData.h()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_term_result_lose", "survival_term_result_lose", i, 0, "", "", "", String.valueOf(localEngineData.k()));
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i;
      if ((!IGameEngine.k()) && (IGameEngine.a().a().m() > paramInt)) {
        i = IGameEngine.a().a().m() - paramInt;
      } else {
        i = 0;
      }
      String str = String.format(getContext().getResources().getString(2131690472), new Object[] { Integer.valueOf(i) });
      this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
    }
    else if (IGameEngine.a().i())
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131690467));
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
    b(paramInt, paramBoolean);
  }
  
  public void a(EngineData paramEngineData)
  {
    if (paramEngineData.o() == 3)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomPkstageISurvivalStagePresenter.a(paramIGameRoomPresenter);
  }
  
  public void a(String paramString)
  {
    a(this, paramString, "avgame_room_survival_bg.png", jdField_a_of_type_JavaLangString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SurvivalPkStageView", 2, String.format("updatePKBgUrl() conveneBgUrl=%s pkWinBgUrl=%s pkWinTopUrl=%s pkLoseBgUrl=%s pkLoseTopUrl=%s", new Object[] { paramString1, paramString2, paramString3, paramString4, paramString5 }));
    }
    if (paramString1 != null) {
      jdField_a_of_type_JavaLangString = paramString1;
    }
    if (paramString2 != null) {
      jdField_b_of_type_JavaLangString = paramString2;
    }
    if (paramString3 != null) {
      jdField_c_of_type_JavaLangString = paramString3;
    }
    if (paramString4 != null) {
      jdField_d_of_type_JavaLangString = paramString4;
    }
    if (paramString5 != null) {
      jdField_e_of_type_JavaLangString = paramString5;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i;
    if (!IGameEngine.k())
    {
      i = IGameEngine.a().a().a().winReason;
      localObject = IGameEngine.a().a().a().winTips;
    }
    else
    {
      localObject = null;
      i = 0;
    }
    b(this.jdField_b_of_type_AndroidWidgetImageView, a("avgame_pk_stage_suc.png", jdField_c_of_type_JavaLangString));
    l();
    i();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690480));
    if (!IGameEngine.k()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(IGameEngine.a().a().a.z));
    }
    if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject))) {
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    } else {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690479));
    }
    if (paramBoolean) {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690471));
    } else {
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690478));
    }
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 24.0F);
    a(this, "avgame_pk_stage_win_bg.png", jdField_b_of_type_JavaLangString);
    a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_left_user@2x.png");
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    Object localObject = IGameEngine.a().a();
    if (((EngineData)localObject).g())
    {
      if (((EngineData)localObject).h()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_term_result_win", "survival_term_result_win", i, 0, "", "", String.valueOf(((EngineData)localObject).l()), String.valueOf(((EngineData)localObject).k()));
    }
  }
  
  public void b()
  {
    ApngImage.pauseAll();
    j();
    k();
    if (!IGameEngine.a().i())
    {
      f();
      a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_joined_user@2x.png");
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    h();
  }
  
  public void c()
  {
    j();
    k();
    String str;
    if (!IGameEngine.k()) {
      str = IGameEngine.a().a().g();
    } else {
      str = null;
    }
    AvGameConfBean localAvGameConfBean = AvGameConfigUtil.a();
    if (TextUtils.isEmpty(str)) {
      if (!TextUtils.isEmpty(localAvGameConfBean.c())) {
        str = localAvGameConfBean.c();
      } else {
        str = getContext().getResources().getString(2131690485);
      }
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
    a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_left_user@2x.png");
  }
  
  public void d()
  {
    l();
    i();
    if (this.jdField_b_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690470));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690469));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 24.0F);
    a(this, null, "avgame_room_survival_bg.png", jdField_a_of_type_JavaLangString);
  }
  
  public void e()
  {
    l();
    i();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690480));
    if (!IGameEngine.k()) {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(IGameEngine.a().a().a.z));
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690482));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690481));
    a(this, "avgame_room_survival_bg.png", jdField_a_of_type_JavaLangString);
    EngineData localEngineData = IGameEngine.a().a();
    if (localEngineData.g())
    {
      int i;
      if (localEngineData.h()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "survival_term_result_win", "survival_term_result_win", i, 0, "", "", String.valueOf(localEngineData.l()), String.valueOf(localEngineData.k()));
    }
  }
  
  public void f()
  {
    int i;
    if (!IGameEngine.k()) {
      i = IGameEngine.a().a().q();
    } else {
      i = 0;
    }
    String str = getContext().getResources().getString(2131690477);
    if (i > 0) {
      str = String.format(str, new Object[] { Integer.valueOf(i) });
    } else {
      str = str.split("\n")[0];
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.pkstage.SurvivalPkStageView
 * JD-Core Version:    0.7.0.1
 */