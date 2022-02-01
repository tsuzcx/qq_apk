package com.tencent.avgame.gameroom.festivalstage.questionoption;

import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.AnswerInfo;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.gamelogic.data.TopicBase;
import com.tencent.avgame.gameroom.IGameRoomPresenter;
import com.tencent.avgame.gameroom.stage.IStagePresenter;
import com.tencent.avgame.report.CJSurvivalReporterUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

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
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter == null) {
        return;
      }
      paramList = ((QuestionOptionsDataSource)localObject).a(paramList).iterator();
      while (paramList.hasNext())
      {
        localObject = (Integer)paramList.next();
        this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter.a(((Integer)localObject).intValue());
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showSelfOptionAnswerResult uin=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" childCount=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getChildCount());
      localStringBuilder.append(" isRight=");
      localStringBuilder.append(paramBoolean);
      QLog.d("QuestionOptionsPresenterImpl", 2, localStringBuilder.toString());
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
    AnswerInfo localAnswerInfo = this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo;
    return (localAnswerInfo != null) && (localAnswerInfo.answer_index >= 0);
  }
  
  private void b()
  {
    if (IGameEngine.k()) {
      return;
    }
    EngineData localEngineData = IGameEngine.a().a();
    int i;
    if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase.d() == jdField_a_of_type_Int)
    {
      a(true);
      TopicBase localTopicBase = this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase;
      localEngineData.a(localTopicBase, localTopicBase.e(), localEngineData.a(), 1L, 0, localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo, false);
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(true, true);
      if (localEngineData.g())
      {
        if (localEngineData.h()) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_result_right", "survival_result_right", i, 0, String.valueOf(localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int), String.valueOf(localEngineData.p()), CJSurvivalReporterUtil.a().a(localEngineData), String.valueOf(localEngineData.k()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "showSelfAnswerResult answer right");
      }
    }
    else
    {
      a(false);
      localEngineData.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase, false);
      localEngineData.a = 0;
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(true, false);
      if (localEngineData.g())
      {
        if (localEngineData.h()) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_result_wrong", "survival_result_wrong", i, 0, String.valueOf(localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int), String.valueOf(localEngineData.p()), CJSurvivalReporterUtil.a().a(localEngineData), String.valueOf(localEngineData.k()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "showSelfAnswerResult answer wrong");
      }
    }
    if (this.b < 0) {
      this.b = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    IGameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase.c_() + 1, jdField_a_of_type_Int, this.b);
  }
  
  private void b(List<String> paramList)
  {
    QuestionOptionsDataSource localQuestionOptionsDataSource = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource;
    if (localQuestionOptionsDataSource != null)
    {
      if (this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter == null) {
        return;
      }
      localQuestionOptionsDataSource.a();
      a(paramList);
    }
  }
  
  private void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showOpponentAnswerResult uin=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.uin);
      ((StringBuilder)localObject).append(" childCount=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getChildCount());
      QLog.d("QuestionOptionsPresenterImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView;
    int i = this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_index;
    long l = this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.uin;
    int j = this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_result;
    boolean bool = true;
    if (j != 1) {
      bool = false;
    }
    ((QuestionOptionsView)localObject).a(i, String.valueOf(l), bool, false);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt, AnswerInfo paramAnswerInfo)
  {
    if (IGameEngine.k()) {
      return;
    }
    if (paramInt >= 0)
    {
      this.jdField_a_of_type_Boolean = false;
      jdField_a_of_type_Int = paramInt;
      EngineData localEngineData = IGameEngine.a().a();
      if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase.d() == jdField_a_of_type_Int)
      {
        a(true);
        localEngineData.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase, 0, localEngineData.a(), 1L, 0, localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo, false);
        if (QLog.isColorLevel()) {
          QLog.d("QuestionOptionsPresenterImpl", 2, "restore answer right");
        }
      }
      else
      {
        a(false);
        localEngineData.a(this.jdField_a_of_type_ComTencentAvgameGamelogicDataTopicBase, false);
        localEngineData.a = 0;
        if (QLog.isColorLevel()) {
          QLog.d("QuestionOptionsPresenterImpl", 2, "restore answer wrong");
        }
      }
    }
    if ((paramAnswerInfo != null) && (paramAnswerInfo.answer_index >= 0))
    {
      this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo = paramAnswerInfo;
      if (jdField_a_of_type_Int >= 0)
      {
        c();
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d();
      }
    }
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsAdapter = ((QuestionOptionsAdapter)paramBaseAdapter);
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTopic right answer : ");
      localStringBuilder.append(paramTopicBase.d());
      QLog.d("QuestionOptionsPresenterImpl", 2, localStringBuilder.toString());
    }
    if (IGameEngine.k()) {
      return;
    }
    paramTopicBase = IGameEngine.a().a();
    if (!this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(paramTopicBase)) {
      paramTopicBase.d();
    }
  }
  
  public void a(QuestionOptionsDataSource paramQuestionOptionsDataSource)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsDataSource = paramQuestionOptionsDataSource;
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter = paramIStagePresenter;
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a(this);
    this.jdField_a_of_type_JavaLangString = IGameEngine.a().getAccount();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((a()) && (jdField_a_of_type_Int < 0)) {
      c();
    }
    this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d();
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getContext().getString(2131690298));
      EngineData localEngineData = IGameEngine.a().a();
      if (localEngineData.g())
      {
        int i;
        if (localEngineData.h()) {
          i = 1;
        } else {
          i = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_result_wrong", "survival_result_wrong", i, 0, String.valueOf(localEngineData.a().jdField_a_of_type_ComTencentAvgameGamelogicDataGameInfo.jdField_a_of_type_Int), String.valueOf(localEngineData.p()), CJSurvivalReporterUtil.a().a(localEngineData), String.valueOf(localEngineData.k()));
      }
    }
    else if (paramBoolean2)
    {
      this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.a().a(this.jdField_a_of_type_ComTencentAvgameGameroomFestivalstageQuestionoptionQuestionOptionsView.getContext().getString(2131690299));
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectOption mSelectEnable=");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" index=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QuestionOptionsPresenterImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Int = paramInt;
      this.b = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
      this.jdField_a_of_type_Boolean = false;
      if (a())
      {
        c();
        this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter.d();
        localObject = this.jdField_a_of_type_ComTencentAvgameGameroomStageIStagePresenter;
        boolean bool;
        if (this.jdField_a_of_type_ComTencentAvgameGamelogicDataAnswerInfo.answer_result == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((IStagePresenter)localObject).a(false, bool);
      }
      if (paramInt >= 0) {
        b();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.festivalstage.questionoption.QuestionOptionsPresenterImpl
 * JD-Core Version:    0.7.0.1
 */