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
  private static int e = -1;
  private QuestionOptionsDataSource a;
  private QuestionOptionsAdapter b;
  private QuestionOptionsView c;
  private TopicBase d;
  private long f = 0L;
  private int g = 0;
  private IStagePresenter h;
  private boolean i = true;
  private AnswerInfo j = null;
  private String k = "";
  
  QuestionOptionsPresenterImpl(QuestionOptionsView paramQuestionOptionsView)
  {
    this.c = paramQuestionOptionsView;
  }
  
  private void a(List<String> paramList)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      if (this.b == null) {
        return;
      }
      paramList = ((QuestionOptionsDataSource)localObject).a(paramList).iterator();
      while (paramList.hasNext())
      {
        localObject = (Integer)paramList.next();
        this.b.a(((Integer)localObject).intValue());
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showSelfOptionAnswerResult uin=");
      localStringBuilder.append(this.k);
      localStringBuilder.append(" childCount=");
      localStringBuilder.append(this.c.getChildCount());
      localStringBuilder.append(" isRight=");
      localStringBuilder.append(paramBoolean);
      QLog.d("QuestionOptionsPresenterImpl", 2, localStringBuilder.toString());
    }
    if (this.c.getChildCount() == 0)
    {
      this.c.getViewTreeObserver().addOnGlobalLayoutListener(new QuestionOptionsPresenterImpl.1(this, paramBoolean));
      return;
    }
    this.c.a(e, this.k, paramBoolean, false);
  }
  
  public static int b()
  {
    return e;
  }
  
  private void b(List<String> paramList)
  {
    QuestionOptionsDataSource localQuestionOptionsDataSource = this.a;
    if (localQuestionOptionsDataSource != null)
    {
      if (this.b == null) {
        return;
      }
      localQuestionOptionsDataSource.a();
      a(paramList);
    }
  }
  
  private void d()
  {
    if (IGameEngine.J()) {
      return;
    }
    EngineData localEngineData = IGameEngine.I().s();
    int m;
    if (this.d.l() == e)
    {
      a(true);
      TopicBase localTopicBase = this.d;
      localEngineData.a(localTopicBase, localTopicBase.m(), localEngineData.q(), 1L, 0, localEngineData.h().k, false);
      this.h.a(true, true);
      if (localEngineData.N())
      {
        if (localEngineData.O()) {
          m = 1;
        } else {
          m = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_result_right", "survival_result_right", m, 0, String.valueOf(localEngineData.h().f.a), String.valueOf(localEngineData.Y()), CJSurvivalReporterUtil.a().b(localEngineData), String.valueOf(localEngineData.Q()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "showSelfAnswerResult answer right");
      }
    }
    else
    {
      a(false);
      localEngineData.a(this.d, false);
      localEngineData.z = 0;
      this.h.a(true, false);
      if (localEngineData.N())
      {
        if (localEngineData.O()) {
          m = 1;
        } else {
          m = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_result_wrong", "survival_result_wrong", m, 0, String.valueOf(localEngineData.h().f.a), String.valueOf(localEngineData.Y()), CJSurvivalReporterUtil.a().b(localEngineData), String.valueOf(localEngineData.Q()));
      }
      if (QLog.isColorLevel()) {
        QLog.d("QuestionOptionsPresenterImpl", 2, "showSelfAnswerResult answer wrong");
      }
    }
    if (this.g < 0) {
      this.g = ((int)(System.currentTimeMillis() - this.f));
    }
    IGameEngine.I().a(this.d.aC_() + 1, e, this.g);
  }
  
  private void e()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showOpponentAnswerResult uin=");
      ((StringBuilder)localObject).append(this.j.uin);
      ((StringBuilder)localObject).append(" childCount=");
      ((StringBuilder)localObject).append(this.c.getChildCount());
      QLog.d("QuestionOptionsPresenterImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
    int m = this.j.answer_index;
    long l = this.j.uin;
    int n = this.j.answer_result;
    boolean bool = true;
    if (n != 1) {
      bool = false;
    }
    ((QuestionOptionsView)localObject).a(m, String.valueOf(l), bool, false);
  }
  
  private boolean f()
  {
    AnswerInfo localAnswerInfo = this.j;
    return (localAnswerInfo != null) && (localAnswerInfo.answer_index >= 0);
  }
  
  public void a()
  {
    this.i = false;
  }
  
  public void a(int paramInt, AnswerInfo paramAnswerInfo)
  {
    if (IGameEngine.J()) {
      return;
    }
    if (paramInt >= 0)
    {
      this.i = false;
      e = paramInt;
      EngineData localEngineData = IGameEngine.I().s();
      if (this.d.l() == e)
      {
        a(true);
        localEngineData.a(this.d, 0, localEngineData.q(), 1L, 0, localEngineData.h().k, false);
        if (QLog.isColorLevel()) {
          QLog.d("QuestionOptionsPresenterImpl", 2, "restore answer right");
        }
      }
      else
      {
        a(false);
        localEngineData.a(this.d, false);
        localEngineData.z = 0;
        if (QLog.isColorLevel()) {
          QLog.d("QuestionOptionsPresenterImpl", 2, "restore answer wrong");
        }
      }
    }
    if ((paramAnswerInfo != null) && (paramAnswerInfo.answer_index >= 0))
    {
      this.j = paramAnswerInfo;
      if (e >= 0)
      {
        e();
        this.h.h();
      }
    }
  }
  
  public void a(BaseAdapter paramBaseAdapter)
  {
    this.b = ((QuestionOptionsAdapter)paramBaseAdapter);
  }
  
  public void a(EngineData paramEngineData)
  {
    this.j = paramEngineData.h().k;
    if (e >= 0)
    {
      e();
      this.h.h();
    }
  }
  
  public void a(TopicBase paramTopicBase)
  {
    b(paramTopicBase.k());
    this.d = paramTopicBase;
    e = -1;
    this.g = -1;
    this.f = System.currentTimeMillis();
    this.i = true;
    this.j = null;
    this.h.b(true);
    this.c.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTopic right answer : ");
      localStringBuilder.append(paramTopicBase.l());
      QLog.d("QuestionOptionsPresenterImpl", 2, localStringBuilder.toString());
    }
    if (IGameEngine.J()) {
      return;
    }
    paramTopicBase = IGameEngine.I().s();
    if (!this.h.c(paramTopicBase)) {
      paramTopicBase.k();
    }
  }
  
  public void a(QuestionOptionsDataSource paramQuestionOptionsDataSource)
  {
    this.a = paramQuestionOptionsDataSource;
  }
  
  public void a(IStagePresenter paramIStagePresenter)
  {
    this.h = paramIStagePresenter;
    this.h.a(this);
    this.k = IGameEngine.K().getAccount();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((f()) && (e < 0)) {
      e();
    }
    this.h.h();
    if (paramBoolean1)
    {
      this.h.a().b(this.c.getContext().getString(2131887209));
      EngineData localEngineData = IGameEngine.I().s();
      if (localEngineData.N())
      {
        int m;
        if (localEngineData.O()) {
          m = 1;
        } else {
          m = 2;
        }
        ReportController.b(null, "dc00898", "", "", "survival_result_wrong", "survival_result_wrong", m, 0, String.valueOf(localEngineData.h().f.a), String.valueOf(localEngineData.Y()), CJSurvivalReporterUtil.a().b(localEngineData), String.valueOf(localEngineData.Q()));
      }
    }
    else if (paramBoolean2)
    {
      this.h.a().b(this.c.getContext().getString(2131887210));
    }
  }
  
  public boolean a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectOption mSelectEnable=");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(" index=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QuestionOptionsPresenterImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (this.i)
    {
      e = paramInt;
      this.g = ((int)(System.currentTimeMillis() - this.f));
      this.i = false;
      if (f())
      {
        e();
        this.h.h();
        localObject = this.h;
        boolean bool;
        if (this.j.answer_result == 1) {
          bool = true;
        } else {
          bool = false;
        }
        ((IStagePresenter)localObject).a(false, bool);
      }
      if (paramInt >= 0) {
        d();
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