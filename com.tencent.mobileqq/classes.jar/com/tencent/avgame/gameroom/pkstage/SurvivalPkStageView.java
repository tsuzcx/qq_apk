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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.CoverRoundCornerRelativeLayout;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.avgame.ui.AVGameSplitNumberView;
import com.tencent.avgame.ui.AVGameText;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.config.business.AvGameConfProcessor;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class SurvivalPkStageView
  extends CoverRoundCornerRelativeLayout
  implements ISurvivalStageView
{
  public static String a;
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
  
  static
  {
    jdField_a_of_type_JavaLangString = "https://static-res.qq.com/static-res/avgames/survival/avgame_room_survival_bg.png";
  }
  
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
    if (GameEngine.a().i()) {
      return getResources().getDimensionPixelOffset(2131296635);
    }
    return 0;
  }
  
  private String a(String paramString)
  {
    return "file:///" + AvGameResDownloadManager.c() + paramString;
  }
  
  private String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    while (!FileUtils.b(AvGameResDownloadManager.c() + paramString1)) {
      return paramString2;
    }
    return paramString1;
  }
  
  private List<Bitmap> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 10)
    {
      localArrayList.add(AVGameUtils.a(String.format("avgame_pk_match_num%d@2x.png", new Object[] { Integer.valueOf(i) })));
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
    paramString1 = AVGameUtils.a(paramString1);
    if (paramString1 != null)
    {
      paramView.setBackgroundDrawable(new BitmapDrawable(paramString1));
      return;
    }
    paramView.setBackgroundDrawable(URLDrawable.getDrawable(paramString2));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = AVGameUtils.a(paramString);
    if (paramString != null) {
      paramImageView.setImageBitmap(paramString);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView != null) {
      this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.a(paramInt);
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
    setRadius(getContext().getResources().getColor(2131165345), ViewUtils.b(16.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558810, null));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380627));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380628));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView = ((AVGameSplitNumberView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369832));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131369831));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setDimension(ViewUtils.b(61.0F), ViewUtils.b(99.0F));
    this.jdField_a_of_type_ComTencentAvgameUiAVGameSplitNumberView.setNumDrawable(a());
    b(0);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131558811, null));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380631));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380630));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidWidgetRelativeLayout.findViewById(2131380629));
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
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13, -1);
      addView(this.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setPadding(this.jdField_b_of_type_AndroidWidgetRelativeLayout.getPaddingLeft(), a(), this.jdField_b_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), this.jdField_b_of_type_AndroidWidgetRelativeLayout.getPaddingBottom());
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.bringToFront();
  }
  
  private void i()
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
  
  private void j()
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
  }
  
  private void k()
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
    k();
    h();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690548));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(GameEngine.a().a().a.A));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690547));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690546));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 24.0F);
    a(this, "avgame_pk_stage_fail_bg.png", jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_left_user@2x.png");
    a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
    CJSurvivalFestivalReporter.a(8, 0, false);
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
    int i;
    if (paramBoolean)
    {
      Object localObject = GameEngine.a().a();
      String str = getContext().getResources().getString(2131690545);
      if (((EngineData)localObject).m() > paramInt)
      {
        i = ((EngineData)localObject).m() - paramInt;
        localObject = String.format(str, new Object[] { Integer.valueOf(i) });
        this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    for (;;)
    {
      b(paramInt);
      return;
      i = 0;
      break;
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
    }
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
  
  public void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
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
    int i = GameEngine.a().a().a().winReason;
    String str = GameEngine.a().a().a().winTips;
    b(this.jdField_b_of_type_AndroidWidgetImageView, a("avgame_pk_stage_suc.png", jdField_c_of_type_JavaLangString));
    k();
    h();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690553));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(GameEngine.a().a().a.z));
    if ((i == 1) && (!TextUtils.isEmpty(str)))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str);
      if (!paramBoolean) {
        break label217;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690544));
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 24.0F);
      a(this, "avgame_pk_stage_win_bg.png", jdField_b_of_type_JavaLangString);
      a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_left_user@2x.png");
      a(this.jdField_b_of_type_AndroidWidgetRelativeLayout);
      CJSurvivalFestivalReporter.a(8, 0, true);
      return;
      this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690552));
      break;
      label217:
      this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690551));
    }
  }
  
  public void b()
  {
    ApngImage.pauseAll();
    i();
    j();
    if (!GameEngine.a().i()) {
      f();
    }
    a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_joined_user@2x.png");
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void c()
  {
    i();
    j();
    Object localObject = GameEngine.a().a();
    AvGameConfBean localAvGameConfBean = AvGameConfProcessor.a();
    if (!TextUtils.isEmpty(((EngineData)localObject).h())) {
      localObject = ((EngineData)localObject).h();
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      a(this.jdField_a_of_type_AndroidWidgetImageView, "avgame_pk_left_user@2x.png");
      return;
      if (!TextUtils.isEmpty(localAvGameConfBean.c())) {
        localObject = localAvGameConfBean.c();
      } else {
        localObject = getContext().getResources().getString(2131690558);
      }
    }
  }
  
  public void d()
  {
    k();
    h();
    if (this.jdField_b_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_b_of_type_AndroidWidgetImageView);
    }
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690543));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690542));
    this.jdField_e_of_type_AndroidWidgetTextView.setTextSize(1, 24.0F);
  }
  
  public void e()
  {
    k();
    h();
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_e_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690553));
    this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(GameEngine.a().a().a.z));
    this.jdField_d_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690555));
    this.jdField_e_of_type_AndroidWidgetTextView.setText(getResources().getString(2131690554));
    a(this, "avgame_room_survival_bg.png", jdField_a_of_type_JavaLangString);
    CJSurvivalFestivalReporter.a(8, 0, true);
  }
  
  public void f()
  {
    int i = GameEngine.a().a().q();
    String str = getContext().getResources().getString(2131690550);
    if (i > 0) {}
    for (str = String.format(str, new Object[] { Integer.valueOf(i) });; str = str.split("\n")[0])
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.pkstage.SurvivalPkStageView
 * JD-Core Version:    0.7.0.1
 */