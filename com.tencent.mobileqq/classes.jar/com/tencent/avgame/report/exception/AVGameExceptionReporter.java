package com.tencent.avgame.report.exception;

import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.Game;
import com.tencent.avgame.gamelogic.data.GameInfo;
import com.tencent.avgame.report.AVGameReporterConstants.EVENT_EXCEPTION_REFER_TYPE;
import com.tencent.avgame.report.AVGameReporterConstants.EVENT_MEDIA_PLAYER_TYPE;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class AVGameExceptionReporter
{
  private static AVGameExceptionReporter a;
  
  public static AVGameExceptionReporter a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AVGameExceptionReporter();
        }
      }
      finally {}
    }
    return a;
  }
  
  private ExceptionReporterBuilder a(@AVGameReporterConstants.EVENT_MEDIA_PLAYER_TYPE int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    try
    {
      EngineData localEngineData = GameEngine.a().a();
      ExceptionReporterBuilder localExceptionReporterBuilder = new ExceptionReporterBuilder();
      localExceptionReporterBuilder.a(16);
      localExceptionReporterBuilder.a(1, paramString1);
      if (paramInt1 == 3)
      {
        localExceptionReporterBuilder.a(2, String.valueOf(paramInt2));
        localExceptionReporterBuilder.a(3, paramString2);
      }
      localExceptionReporterBuilder.a(4, String.valueOf(paramInt1));
      localExceptionReporterBuilder.a(5, String.valueOf(localEngineData.a().a.a));
      localExceptionReporterBuilder.a(6, String.valueOf(localEngineData.b()));
      localExceptionReporterBuilder.a(7, String.valueOf(localEngineData.j()));
      localExceptionReporterBuilder.a(8, String.valueOf(localEngineData.k()));
      localExceptionReporterBuilder.a(9, String.valueOf(localEngineData.a()));
      return localExceptionReporterBuilder;
    }
    finally {}
  }
  
  private ExceptionReporterBuilder a(@AVGameReporterConstants.EVENT_EXCEPTION_REFER_TYPE int paramInt, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      EngineData localEngineData = GameEngine.a().a();
      ExceptionReporterBuilder localExceptionReporterBuilder = new ExceptionReporterBuilder();
      localExceptionReporterBuilder.a(paramInt);
      if (!TextUtils.isEmpty(paramString1)) {
        localExceptionReporterBuilder.a(1, paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localExceptionReporterBuilder.a(2, paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localExceptionReporterBuilder.a(3, paramString3);
      }
      if (localEngineData == null) {
        return localExceptionReporterBuilder;
      }
      localExceptionReporterBuilder.a(7, String.valueOf(localEngineData.j()));
      localExceptionReporterBuilder.a(8, String.valueOf(localEngineData.k()));
      return localExceptionReporterBuilder;
    }
    finally {}
  }
  
  private void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramHashMap == null) {
        str = "";
      } else {
        str = paramHashMap.toString();
      }
      QLog.i("AVGameExceptionReporter", 2, String.format("reportForVoiceRecognize: tag:%s params:%s", new Object[] { paramString, str }));
    }
    StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "", false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportScoreInvalidData localScore:");
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append(" svrScore:");
        ((StringBuilder)localObject1).append(paramInt2);
        ((StringBuilder)localObject1).append(" reportType:");
        ((StringBuilder)localObject1).append(paramInt3);
        QLog.d("AVGameExceptionReporter", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = GameEngine.a().a();
      if ((localObject1 != null) && (((EngineData)localObject1).g()))
      {
        ExceptionReporterBuilder localExceptionReporterBuilder = new ExceptionReporterBuilder();
        localExceptionReporterBuilder.a(15);
        localExceptionReporterBuilder.a(1, String.valueOf(paramInt1));
        localExceptionReporterBuilder.a(2, String.valueOf(paramInt2));
        localExceptionReporterBuilder.a(4, String.valueOf(paramInt3));
        localExceptionReporterBuilder.a(5, String.valueOf(((EngineData)localObject1).p()));
        localExceptionReporterBuilder.a(6, String.valueOf(((EngineData)localObject1).b()));
        localExceptionReporterBuilder.a(7, String.valueOf(((EngineData)localObject1).j()));
        localExceptionReporterBuilder.a(8, String.valueOf(((EngineData)localObject1).k()));
        localExceptionReporterBuilder.a(9, String.valueOf(((EngineData)localObject1).a()));
        a("actAVGameProcessException", localExceptionReporterBuilder.a());
        return;
      }
      return;
    }
    finally {}
  }
  
  public void a(@AVGameReporterConstants.EVENT_MEDIA_PLAYER_TYPE int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameExceptionReporter", 2, "reportMediaPlayer");
      }
      EngineData localEngineData = GameEngine.a().a();
      if (localEngineData != null)
      {
        boolean bool = localEngineData.g();
        if (!bool) {
          return;
        }
      }
      a("actAVGameProcessException", a(paramInt1, paramString1, paramInt2, paramString2).a());
      return;
    }
    finally {}
  }
  
  public void a(@AVGameReporterConstants.EVENT_EXCEPTION_REFER_TYPE int paramInt, String paramString1, String paramString2, String paramString3)
  {
    a("actAVGameProcessException", a(paramInt, paramString1, paramString2, paramString3).a());
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportGameIdInvalidData svrGameId:");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" pushType:");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("AVGameExceptionReporter", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = GameEngine.a().a();
      if ((localObject != null) && (((EngineData)localObject).g()))
      {
        ExceptionReporterBuilder localExceptionReporterBuilder = new ExceptionReporterBuilder();
        localExceptionReporterBuilder.a(14);
        localExceptionReporterBuilder.a(1, String.valueOf(((EngineData)localObject).b()));
        localExceptionReporterBuilder.a(2, paramString);
        localExceptionReporterBuilder.a(3, String.valueOf(paramInt));
        localExceptionReporterBuilder.a(5, String.valueOf(((EngineData)localObject).p()));
        localExceptionReporterBuilder.a(7, String.valueOf(((EngineData)localObject).j()));
        localExceptionReporterBuilder.a(8, String.valueOf(((EngineData)localObject).k()));
        localExceptionReporterBuilder.a(9, String.valueOf(((EngineData)localObject).a()));
        a("actAVGameProcessException", localExceptionReporterBuilder.a());
        return;
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.exception.AVGameExceptionReporter
 * JD-Core Version:    0.7.0.1
 */