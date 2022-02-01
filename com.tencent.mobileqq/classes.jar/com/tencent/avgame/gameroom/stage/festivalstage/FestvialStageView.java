package com.tencent.avgame.gameroom.stage.festivalstage;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadUtil;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.base.BaseStageView;
import com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.BaseGuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureClickStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesssong.BaseGuessSongStageView;
import com.tencent.avgame.gameroom.stage.guesssong.GuessSongClickStageView;
import com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView;
import com.tencent.avgame.gameroom.stage.guessstar.BaseGuessStarStageView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarClickStageView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView;
import com.tencent.avgame.gameroom.stage.guesstext.BaseGuessTextStageView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextClickStageView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class FestvialStageView
  extends BaseStageView
{
  protected ImageView a;
  protected RelativeLayout.LayoutParams a;
  protected TextView a;
  Runnable a;
  protected RelativeLayout.LayoutParams b;
  Runnable b;
  private boolean c = false;
  
  public FestvialStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FestvialStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FestvialStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new FestvialStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new FestvialStageView.2(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = new FestivalStagePresenterImp(this);
  }
  
  private void f()
  {
    FontStyleConfig localFontStyleConfig = GameEngine.a().a().a;
    if (localFontStyleConfig != null)
    {
      int i = 0;
      try
      {
        int j = Color.parseColor(localFontStyleConfig.i);
        i = j;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(i);
    }
  }
  
  public void a(IGameRoomPresenter paramIGameRoomPresenter)
  {
    super.a(paramIGameRoomPresenter);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 17.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setGravity(17);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(12);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ViewUtils.b(33.0F);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams = new RelativeLayout.LayoutParams(ViewUtils.b(190.0F), ViewUtils.b(40.0F));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(12);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.addRule(14);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.bottomMargin = ViewUtils.b(20.0F);
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
    f();
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onShowImageTipOnStageBottom imageName = ");
      localStringBuilder.append(paramString);
      QLog.d("StageView", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null) {
      removeView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    addView(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(AvGameResDownloadUtil.a(paramString));
    postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1500L);
  }
  
  public void d()
  {
    if (this.c) {
      super.d();
    }
    boolean bool1 = GameEngine.a().h();
    boolean bool2 = GameEngine.a().i();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView = new GuessActionStageView(getContext());
    if ((bool2) && (!bool1))
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView = new GuessPictureClickStageView(getContext());
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView = new GuessSongClickStageView(getContext());
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView = new GuessTextClickStageView(getContext());
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView = new GuessStarClickStageView(getContext());
    }
    else
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView = new GuessPictureStageView(getContext());
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView = new GuessSongStageView(getContext());
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView = new GuessTextStageView(getContext());
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView = new GuessStarStageView(getContext());
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.setSpecialMode(true);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.setSpecialMode(true);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.setSpecialMode(true);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.setSpecialMode(true);
    }
    FontStyleConfig localFontStyleConfig = GameEngine.a().a().a;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView.setFontStyle(localFontStyleConfig);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView.setFontStyle(localFontStyleConfig);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView.setFontStyle(localFontStyleConfig);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView.setFontStyle(localFontStyleConfig);
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.festivalstage.FestvialStageView
 * JD-Core Version:    0.7.0.1
 */