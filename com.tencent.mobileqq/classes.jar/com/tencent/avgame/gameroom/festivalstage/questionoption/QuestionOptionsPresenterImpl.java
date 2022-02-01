package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class QuestionOptionsPresenterImpl
  implements IQuestionOptionPresenter
{
  private static int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  private AnswerInfo jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = null;
  private TopicBase jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase;
  private QuestionOptionsAdapter jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter;
  private QuestionOptionsDataSource jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource;
  private QuestionOptionsView jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView;
  private IStagePresenter jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 0;
  
  QuestionOptionsPresenterImpl(QuestionOptionsView paramQuestionOptionsView)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView = paramQuestionOptionsView;
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  private void a(List<String> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter == null)) {}
    for (;;)
    {
      return;
      paramList = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource.a(paramList).iterator();
      while (paramList.hasNext())
      {
        Integer localInteger = (Integer)paramList.next();
        this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter.a(localInteger.intValue());
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuestionOptionsPresenterImpl", 2, "showSelfOptionAnswerResult uin=" + this.jdField_a_of_type_JavaLangString + " childCount=" + this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getChildCount() + " isRight=" + paramBoolean);
    }
    if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getChildCount() == 0)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getViewTreeObserver().addOnGlobalLayoutListener(new QuestionOptionsPresenterImpl.1(this, paramBoolean));
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.a(jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramBoolean, false);
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo != null) && (this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_index >= 0);
  }
  
  private void b()
  {
    EngineData localEngineData = GameEngine.a().a();
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase.d() == jdField_a_of_type_Int)
    {
      a(true);
      localEngineData.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase, this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase.e(), localEngineData.a(), 1L, 0, localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo, false);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(true, true);
      CJSurvivalFestivalReporter.a(6, 0, true);
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "showSelfAnswerResult answer right");
      }
    }
    for (;;)
    {
      if (this.b < 0) {
        this.b = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      }
      GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase.c_() + 1, jdField_a_of_type_Int, this.b);
      return;
      a(false);
      localEngineData.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase, false);
      localEngineData.a = 0;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(true, false);
      CJSurvivalFestivalReporter.a(6, 0, false);
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "showSelfAnswerResult answer wrong");
      }
    }
  }
  
  private void b(List<String> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource == null) || (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource.a();
    a(paramList);
  }
  
  private void c()
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QuestionOptionsPresenterImpl", 2, "showOpponentAnswerResult uin=" + this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.uin + " childCount=" + this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getChildCount());
    }
    QuestionOptionsView localQuestionOptionsView = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView;
    int i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_index;
    long l = this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.uin;
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_result == 1) {}
    for (;;)
    {
      localQuestionOptionsView.a(i, String.valueOf(l), bool, false);
      return;
      bool = false;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, AnswerInfo paramAnswerInfo)
  {
    EngineData localEngineData;
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_Boolean = false;
      jdField_a_of_type_Int = paramInt;
      localEngineData = GameEngine.a().a();
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase.d() != jdField_a_of_type_Int) {
        break label112;
      }
      a(true);
      localEngineData.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase, 0, localEngineData.a(), 1L, 0, localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo, false);
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "restore answer right");
      }
    }
    for (;;)
    {
      if ((paramAnswerInfo != null) && (paramAnswerInfo.answer_index >= 0))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = paramAnswerInfo;
        if (jdField_a_of_type_Int >= 0)
        {
          c();
          this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d();
        }
      }
      return;
      label112:
      a(false);
      localEngineData.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase, false);
      localEngineData.a = 0;
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "restore answer wrong");
      }
    }
  }
  
  public void a(EngineData paramEngineData)
  {
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = paramEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo;
    if (jdField_a_of_type_Int >= 0)
    {
      c();
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d();
    }
  }
  
  public void a(TopicBase paramTopicBase)
  {
    b(paramTopicBase.b());
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase = paramTopicBase;
    jdField_a_of_type_Int = -1;
    this.b = -1;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = null;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.b(true);
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.b();
    EngineData localEngineData = GameEngine.a().a();
    if (!this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(localEngineData)) {
      GameEngine.a().a().d();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QuestionOptionsPresenterImpl", 2, "updateTopic right answer : " + paramTopicBase.d());
    }
  }
  
  public void a(QuestionOptionsAdapter paramQuestionOptionsAdapter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter = paramQuestionOptionsAdapter;
  }
  
  public void a(QuestionOptionsDataSource paramQuestionOptionsDataSource)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource = paramQuestionOptionsDataSource;
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this);
    this.jdField_a_of_type_JavaLangString = GameEngine.a().a().getAccount();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((a()) && (jdField_a_of_type_Int < 0)) {
      c();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d();
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getContext().getString(2131690375));
      CJSurvivalFestivalReporter.a(6, 0, false);
    }
    while (!paramBoolean2) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getContext().getString(2131690376));
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuestionOptionsPresenterImpl", 2, "onSelectOption mSelectEnable=" + this.jdField_a_of_type_Boolean + " index=" + paramInt);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Int = paramInt;
      this.b = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_Boolean = false;
      IStagePresenter localIStagePresenter;
      if (a())
      {
        c();
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d();
        localIStagePresenter = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_result != 1) {
          break label130;
        }
      }
      label130:
      for (boolean bool = true;; bool = false)
      {
        localIStagePresenter.a(false, bool);
        if (paramInt >= 0) {
          b();
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsPresenterImpl
 * JD-Core Version:    0.7.0.1
 */