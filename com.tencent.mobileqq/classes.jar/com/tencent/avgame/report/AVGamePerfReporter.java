package com.tencent.avgame.report;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.av.audioprocess.AudioProcess;
import com.tencent.av.audioprocess.api.IAudioProcessApi;
import com.tencent.av.so.ResInfo;
import com.tencent.av.so.ResMgr;
import com.tencent.avgame.localvoicerecog.api.IAILabVoiceRecogEngine;
import com.tencent.avgame.localvoicerecog.api.IVoiceRecogEngineFactory;
import com.tencent.avgame.util.AVGameStep;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class AVGamePerfReporter
{
  private static final String[] a = { "param_StepEntrance", "param_StepLoading", "param_StepPrepareGame", "param_StepGameReady", "param_StepGameCanStart" };
  private static final String[] b = { "param_StepEntrance", "param_StepLoading", "param_StepPrepareGame", "param_StepSecure", "param_StepResource", "param_StepRoomProto", "param_StepAvAlive" };
  private static AVGamePerfReporter c = null;
  private static boolean d = true;
  private boolean e = false;
  private final ConcurrentHashMap<String, AVGameStep> f = new ConcurrentHashMap(4);
  private volatile String g;
  private volatile String h = "";
  
  public static AVGamePerfReporter a()
  {
    if (c == null) {
      try
      {
        if (c == null) {
          c = new AVGamePerfReporter();
        }
      }
      finally {}
    }
    return c;
  }
  
  private AVGameStep b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (AVGameStep)this.f.get(paramString);
    }
    return null;
  }
  
  public static boolean b()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      return AudioProcess.b().isRecogStarted();
    }
    return false;
  }
  
  private AVGameStep c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AVGameStep localAVGameStep = new AVGameStep(paramString);
    this.f.put(paramString, localAVGameStep);
    return localAVGameStep;
  }
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("exit, report[");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("], from[");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.e)
    {
      boolean bool = true;
      if (paramInt == 1)
      {
        localObject = b("param_StepGameCanStart");
        if ((localObject != null) && (((AVGameStep)localObject).b())) {}
        do
        {
          bool = true;
          break;
          localObject = b("param_StepGameReady");
        } while ((localObject != null) && (((AVGameStep)localObject).b()));
        bool = false;
        if (bool) {
          b(1);
        } else {
          b(2);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("exit, isReady[");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append("]");
          QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if (paramInt == 2)
      {
        localObject = b("param_StepLoading");
        if ((localObject != null) && (((AVGameStep)localObject).b())) {
          bool = false;
        } else {
          a("param_StepLoading", 0);
        }
        if (bool) {
          b(3);
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("exit, needReport[");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append("]");
          QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    this.f.clear();
    this.e = false;
  }
  
  public void a(int paramInt, long paramLong1, String paramString, long paramLong2)
  {
    HashMap localHashMap = new HashMap(10);
    localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
    localHashMap.put("opt", String.valueOf(paramInt));
    localHashMap.put("game_id", paramString);
    localHashMap.put("cost", String.valueOf(paramLong2));
    localHashMap.put("room_id", String.valueOf(paramLong1));
    a("actAVGameExitRoom", localHashMap);
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject1;
    if ((paramIntent != null) && (!this.e))
    {
      localObject1 = b;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        AVGameStep localAVGameStep1 = b((String)localObject2);
        AVGameStep localAVGameStep2 = (AVGameStep)paramIntent.getParcelableExtra((String)localObject2);
        if ((localAVGameStep2 != null) && ((localAVGameStep1 == null) || (!localAVGameStep1.a()) || ((localAVGameStep2.b()) && (!localAVGameStep1.b()))))
        {
          this.f.put(localObject2, localAVGameStep2);
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getStepInfoFromIntent, pre[");
            ((StringBuilder)localObject2).append(localAVGameStep1);
            ((StringBuilder)localObject2).append("], cur[");
            ((StringBuilder)localObject2).append(localAVGameStep2);
            ((StringBuilder)localObject2).append("]");
            QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject2).toString());
          }
        }
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getStepInfoFromIntent, report[");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append("], intent[");
      ((StringBuilder)localObject1).append(paramIntent);
      ((StringBuilder)localObject1).append("]");
      QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1;
    if ((!TextUtils.isEmpty(paramString)) && (!this.e))
    {
      boolean bool = false;
      Object localObject2 = b(paramString);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = c(paramString);
      }
      if ((localObject1 != null) && (((AVGameStep)localObject1).b == 0L)) {
        ((AVGameStep)localObject1).b = System.currentTimeMillis();
      } else {
        bool = true;
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("stepStart, name[");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("], isRepeatStep[");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append("], step[");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append("]");
        QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("stepStart, report[");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append("], name[");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("]");
      QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject;
    if ((!TextUtils.isEmpty(paramString)) && (!this.e))
    {
      boolean bool1 = false;
      boolean bool2 = false;
      long l2 = System.currentTimeMillis();
      localObject = b(paramString);
      long l1 = 0L;
      if (localObject != null)
      {
        if (((AVGameStep)localObject).c == 0L)
        {
          ((AVGameStep)localObject).c = l2;
          bool1 = bool2;
        }
        else
        {
          bool1 = true;
        }
        l1 = Math.abs(((AVGameStep)localObject).c - ((AVGameStep)localObject).b);
        ((AVGameStep)localObject).d = paramInt;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stepEnd, name[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], cost[");
        localStringBuilder.append(l1);
        localStringBuilder.append("], isRepeatStep[");
        localStringBuilder.append(bool1);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], time[");
        localStringBuilder.append(l2);
        localStringBuilder.append("]");
        QLog.i("AVGamePerfReporter", 2, localStringBuilder.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("stepEnd, report[");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("], name[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap)
  {
    if (QLog.isColorLevel())
    {
      String str;
      if (paramHashMap == null) {
        str = "";
      } else {
        str = paramHashMap.toString();
      }
      QLog.i("AVGamePerfReporter", 2, String.format("reportForVoiceRecognize: tag:%s params:%s", new Object[] { paramString, str }));
    }
    StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext()).collectPerformance("", paramString, true, 0L, 0L, paramHashMap, "", true);
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    HashMap localHashMap = new HashMap(20);
    boolean bool = b();
    String str;
    if (bool) {
      str = "1";
    } else {
      str = "0";
    }
    localHashMap.put("is_local", str);
    if (bool) {
      str = c();
    } else {
      str = "";
    }
    localHashMap.put("asr_model", str);
    localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
    localHashMap.put("asr_model", c());
    localHashMap.put("roomID", String.valueOf(paramLong));
    if (paramBoolean) {
      str = "actAVGameASRStart";
    } else {
      str = "actAVGameASRStop";
    }
    a(str, localHashMap);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, long paramLong1, String paramString3, String paramString4, String paramString5, long paramLong2)
  {
    HashMap localHashMap = new HashMap(20);
    String str = paramString5;
    if (!paramBoolean)
    {
      if (TextUtils.isEmpty(paramString5)) {
        paramString5 = this.h;
      }
      this.h = paramString5;
      str = this.h;
    }
    if (paramBoolean) {
      paramString5 = "1";
    } else {
      paramString5 = "0";
    }
    localHashMap.put("is_local", paramString5);
    localHashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000L));
    localHashMap.put("asr_model", str);
    localHashMap.put("game_id", paramString3);
    localHashMap.put("asr_uin", paramString4);
    localHashMap.put("time_cost", String.valueOf(paramLong1));
    localHashMap.put("asr_result", paramString1);
    localHashMap.put("keyWord", paramString2);
    localHashMap.put("roomID", String.valueOf(paramLong2));
    localHashMap.put("ai_denoise", String.valueOf(((IVoiceRecogEngineFactory)QRoute.api(IVoiceRecogEngineFactory.class)).isEnableAINS()));
    if (((IVoiceRecogEngineFactory)QRoute.api(IVoiceRecogEngineFactory.class)).getVoiceRecogEngineType() == 3) {
      localHashMap.put("score", String.valueOf(((IAILabVoiceRecogEngine)QRoute.api(IAILabVoiceRecogEngine.class)).getCurSceneWordScore()));
    }
    a("actAVGameASRResult", localHashMap);
  }
  
  public void b(int paramInt)
  {
    if (this.e)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("reportForEnterGame, repeat report. retCode[");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append("=");
        QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    Object localObject2 = new ArrayList();
    long l1 = 0L;
    long l3 = l1;
    long l2 = l3;
    int i = 0;
    for (;;)
    {
      localObject1 = a;
      if (i >= localObject1.length) {
        break;
      }
      localObject1 = (AVGameStep)this.f.get(localObject1[i]);
      if (localObject1 == null)
      {
        l4 = l2;
      }
      else
      {
        ((List)localObject2).add(localObject1);
        l2 = l3;
        if (l3 == 0L) {
          l2 = ((AVGameStep)localObject1).b;
        }
        if (((AVGameStep)localObject1).c != 0L) {
          l1 = ((AVGameStep)localObject1).c;
        }
        l4 = i + 1;
        l3 = l2;
      }
      i += 1;
      l2 = l4;
    }
    if (((List)localObject2).size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGamePerfReporter", 2, "reportForEnterGame, no main step for report.");
      }
      return;
    }
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_RetCode", String.valueOf(paramInt));
    long l4 = l1;
    if (l1 == 0L) {
      l4 = System.currentTimeMillis();
    }
    if (l3 != 0L) {
      l1 = Math.abs(l4 - l3);
    } else {
      l1 = 0L;
    }
    Object localObject3 = this.f.keySet().iterator();
    Object localObject4;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (String)((Iterator)localObject3).next();
      localObject4 = (AVGameStep)this.f.get(localObject4);
      if ((localObject4 != null) && (!((List)localObject2).contains(localObject4))) {
        ((List)localObject2).add(localObject4);
      }
    }
    i = 0;
    while (i < ((List)localObject2).size())
    {
      localObject3 = (AVGameStep)((List)localObject2).get(i);
      if ((((AVGameStep)localObject3).b != 0L) && (((AVGameStep)localObject3).c != 0L) && (Math.abs(((AVGameStep)localObject3).c - ((AVGameStep)localObject3).b) > 0L))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((AVGameStep)localObject3).a);
        ((StringBuilder)localObject4).append("Cost");
        ((HashMap)localObject1).put(((StringBuilder)localObject4).toString(), String.valueOf(((AVGameStep)localObject3).c - ((AVGameStep)localObject3).b));
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((AVGameStep)localObject3).a);
        ((StringBuilder)localObject4).append("Ret");
        ((HashMap)localObject1).put(((StringBuilder)localObject4).toString(), String.valueOf(((AVGameStep)localObject3).d));
      }
      else if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("reportForEnterGame, invalid step[");
        ((StringBuilder)localObject4).append(localObject3);
        ((StringBuilder)localObject4).append("]");
        QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject4).toString());
      }
      i += 1;
    }
    localObject2 = MobileQQ.sMobileQQ.getQQProcessName();
    if ((d) && (localObject2 != null) && (((String)localObject2).endsWith(":avgame")))
    {
      d = false;
      ((HashMap)localObject1).put("param_AVGameFirst", "1");
    }
    else
    {
      ((HashMap)localObject1).put("param_AVGameFirst", "0");
    }
    this.e = true;
    localObject2 = StatisticCollector.getInstance(MobileQQ.sMobileQQ.getApplicationContext());
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StatisticCollector)localObject2).collectPerformance("", "actAVGameMainCost", bool, l1, l2, (HashMap)localObject1, "", true);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reportForEnterGame, tagName[");
      ((StringBuilder)localObject2).append("actAVGameMainCost");
      ((StringBuilder)localObject2).append("], retCode[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("], duration[");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("], mainStepCnt[");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append("], params[");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append("]");
      QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void b(Intent paramIntent)
  {
    Object localObject1;
    if ((paramIntent != null) && (!this.e))
    {
      localObject1 = b;
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        AVGameStep localAVGameStep = (AVGameStep)this.f.get(localObject2);
        if (localAVGameStep != null) {
          paramIntent.putExtra((String)localObject2, localAVGameStep);
        }
        if ((localAVGameStep != null) && (QLog.isColorLevel()))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("addStepInfoToIntent, step[");
          ((StringBuilder)localObject2).append(localAVGameStep);
          ((StringBuilder)localObject2).append("]");
          QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject2).toString());
        }
        i += 1;
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addStepInfoToIntent, report[");
      ((StringBuilder)localObject1).append(this.e);
      ((StringBuilder)localObject1).append("], intent[");
      ((StringBuilder)localObject1).append(paramIntent);
      ((StringBuilder)localObject1).append("]");
      QLog.i("AVGamePerfReporter", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public String c()
  {
    int i = ((IVoiceRecogEngineFactory)QRoute.api(IVoiceRecogEngineFactory.class)).getVoiceRecogEngineType();
    if (i == 1) {
      return "s2";
    }
    if (i == 2) {
      localObject1 = "AVGameVoiceRecogModel";
    } else {
      localObject1 = "AVGameVoiceRecogAILabModel";
    }
    Object localObject3 = ResMgr.a().f((String)localObject1);
    String str = "";
    Object localObject1 = str;
    if (localObject3 != null) {
      localObject3 = ((ResInfo)localObject3).resZipUrl;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        int k = ((String)localObject3).lastIndexOf(File.separator);
        int j = 0;
        if (k < 0) {
          break label148;
        }
        i = 1;
        if (k < ((String)localObject3).length() - 1) {
          j = 1;
        }
        localObject1 = str;
        if ((j & i) != 0) {
          localObject1 = ((String)localObject3).substring(k + 1);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = str;
      }
      this.g = localObject2;
      return localObject2;
      label148:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.report.AVGamePerfReporter
 * JD-Core Version:    0.7.0.1
 */