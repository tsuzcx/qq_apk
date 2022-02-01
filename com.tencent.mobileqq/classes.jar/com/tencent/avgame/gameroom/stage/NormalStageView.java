package com.tencent.avgame.gameroom.stage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.base.BaseStageView;
import com.tencent.avgame.gameroom.stage.guessaction.GuessActionStageView;
import com.tencent.avgame.gameroom.stage.guesspicture.GuessPictureStageView;
import com.tencent.avgame.gameroom.stage.guesssong.GuessSongStageView;
import com.tencent.avgame.gameroom.stage.guessstar.GuessStarStageView;
import com.tencent.avgame.gameroom.stage.guesstext.GuessTextStageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

public class NormalStageView
  extends BaseStageView
{
  protected ImageView a;
  protected RelativeLayout.LayoutParams a;
  protected TextView a;
  Runnable a;
  protected RelativeLayout.LayoutParams b;
  Runnable b;
  
  public NormalStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NormalStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NormalStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_JavaLangRunnable = new NormalStageView.1(this);
    this.jdField_b_of_type_JavaLangRunnable = new NormalStageView.2(this);
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = new StagePresenterImp(this);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessactionBaseGuessActionStageView = new GuessActionStageView(getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesspictureBaseGuessPictureStageView = new GuessPictureStageView(getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesssongBaseGuessSongStageView = new GuessSongStageView(getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuesstextBaseGuessTextStageView = new GuessTextStageView(getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomStageGuessstarBaseGuessStarStageView = new GuessStarStageView(getContext());
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
    postDelayed(this.jdField_a_of_type_JavaLangRunnable, 3000L);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(AvGameResDownloadManager.a(paramString));
    postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.NormalStageView
 * JD-Core Version:    0.7.0.1
 */