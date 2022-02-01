package com.tencent.avgame.gameroom.stage.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.festivalstage.questionoption.IQuestionOptionPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.util.FontStyleConfig;
import com.tencent.avgame.gameroom.stage.util.IBaseCountDownClockView;
import com.tencent.avgame.gameroom.stage.util.IBaseCountDownClockView.OnCountDownListener;
import com.tencent.qphone.base.util.QLog;

public class BaseGuessClickStageView
  extends RelativeLayout
  implements IGameStageView
{
  protected IQuestionOptionPresenter a;
  protected QuestionOptionsView a;
  private IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = null;
  private IBaseCountDownClockView.OnCountDownListener jdField_a_of_type_ComTencentAvgameGameroomStageUtilIBaseCountDownClockView$OnCountDownListener = new BaseGuessClickStageView.1(this);
  private boolean jdField_a_of_type_Boolean = false;
  
  public BaseGuessClickStageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseGuessClickStageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseGuessClickStageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView = null;
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter = null;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView = new QuestionOptionsView(getContext());
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.a();
  }
  
  public ImageView a()
  {
    return null;
  }
  
  public IGameStagePresenter a()
  {
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuessClickStageView", 2, "showQuestionOptionView run");
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.a();
    addView(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView, QuestionOptionsView.a());
    if (this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter != null) {
      this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter);
    }
  }
  
  public void a(ITopic paramITopic) {}
  
  protected void a(IStagePresenter paramIStagePresenter)
  {
    if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter == null)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a(paramIStagePresenter);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a()
  {
    return false;
  }
  
  protected void b(ITopic paramITopic)
  {
    if (!GameEngine.a().h())
    {
      if (paramITopic == null) {
        break label88;
      }
      if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter == null) {
        a();
      }
      this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.setVisibility(0);
      if ((!this.jdField_a_of_type_Boolean) && (a() != null))
      {
        ((IBaseCountDownClockView)a()).setOnTimeEndListener(this.jdField_a_of_type_ComTencentAvgameGameroomStageUtilIBaseCountDownClockView$OnCountDownListener);
        this.jdField_a_of_type_Boolean = true;
      }
      if ((paramITopic instanceof TopicBase)) {
        this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter.a((TopicBase)paramITopic);
      }
    }
    return;
    label88:
    removeView(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionIQuestionOptionPresenter = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(IStagePresenter paramIStagePresenter) {}
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig) {}
  
  public void setSpecialMode(boolean paramBoolean) {}
  
  public void setTitleCenter(String paramString) {}
  
  public void setTitleRight(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseGuessClickStageView
 * JD-Core Version:    0.7.0.1
 */