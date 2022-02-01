package com.tencent.avgame.gameroom.stage.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.avgame.data.FontStyleConfig;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.ITopic;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.festivalstage.questionoption.IQuestionOptionPresenter;
import com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsView;
import com.tencent.avgame.gameroom.stage.IGameStagePresenter;
import com.tencent.avgame.gameroom.stage.IGameStageView;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.gameroom.stage.util.IBaseCountDownClockView;
import com.tencent.avgame.gameroom.stage.util.IBaseCountDownClockView.OnCountDownListener;
import com.tencent.qphone.base.util.QLog;

public class BaseGuessClickStageView
  extends RelativeLayout
  implements IGameStageView
{
  protected QuestionOptionsView a = null;
  protected IQuestionOptionPresenter b = null;
  private IStagePresenter c = null;
  private boolean d = false;
  private IBaseCountDownClockView.OnCountDownListener e = new BaseGuessClickStageView.1(this);
  
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
    c();
  }
  
  private void c()
  {
    this.a = new QuestionOptionsView(getContext());
    this.a.a();
  }
  
  public void a(ITopic paramITopic) {}
  
  protected void a(IStagePresenter paramIStagePresenter)
  {
    IQuestionOptionPresenter localIQuestionOptionPresenter = this.b;
    if (localIQuestionOptionPresenter == null)
    {
      this.c = paramIStagePresenter;
      return;
    }
    localIQuestionOptionPresenter.a(paramIStagePresenter);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuessClickStageView", 2, "showQuestionOptionView run");
    }
    this.b = this.a.getPresenter();
    addView(this.a, QuestionOptionsView.getDefaultLayoutParams());
    IStagePresenter localIStagePresenter = this.c;
    if (localIStagePresenter != null) {
      this.b.a(localIStagePresenter);
    }
  }
  
  protected void b(ITopic paramITopic)
  {
    if (!IGameEngine.I().C()) {
      if (paramITopic != null)
      {
        if (this.b == null) {
          b();
        }
        this.a.setVisibility(0);
        if ((!this.d) && (getTopicClockView() != null))
        {
          ((IBaseCountDownClockView)getTopicClockView()).setOnTimeEndListener(this.e);
          this.d = true;
        }
        if ((paramITopic instanceof TopicBase)) {
          this.b.a((TopicBase)paramITopic);
        }
      }
      else
      {
        removeView(this.a);
        this.b = null;
        this.d = false;
      }
    }
  }
  
  public void b(IStagePresenter paramIStagePresenter) {}
  
  public IGameStagePresenter getPresenter()
  {
    return null;
  }
  
  public ImageView getTopicClockView()
  {
    return null;
  }
  
  public void setFontStyle(FontStyleConfig paramFontStyleConfig) {}
  
  public void setSpecialMode(boolean paramBoolean) {}
  
  public void setTitleCenter(String paramString) {}
  
  public void setTitleRight(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.stage.base.BaseGuessClickStageView
 * JD-Core Version:    0.7.0.1
 */