package com.tencent.beacon.core.event;

import com.tencent.beacon.core.e.d;
import com.tencent.beacon.upload.UploadStrategy;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class EventStrategyBean
{
  private static volatile EventStrategyBean mInstance;
  private boolean acceleEnable = true;
  private int comDelayDB = UploadStrategy.DEFAULT_COMMON_DELAY;
  private int comNumDB = UploadStrategy.DEFAULT_COM_NUM_DB;
  private int comNumUpload = UploadStrategy.DEFAULT_COM_NUM_UPLOAD;
  private boolean comPollUp = UploadStrategy.DEFAULT_COM_POLL_UP;
  private int consuming = 300;
  private int dailyConsumeLimit = 10485760;
  private int gatherCount = 1;
  private long gatherDur = 6400L;
  private boolean gyroEnable = true;
  private boolean heartbeatUsable = true;
  private int hertzCount = 20;
  private boolean isLaunchEventSimple = false;
  private boolean isTidyEventFields = false;
  private boolean magneticEnable = true;
  private Set<String> preventEventCode = null;
  private int realDelayUpload = UploadStrategy.DEFAULT_REAL_TIME_DELAY;
  private int realNumUpload = UploadStrategy.DEFAULT_REAL_NUM_UPLOAD;
  private Map<String, Float> sampleEvent = null;
  private boolean sensorEnable = UploadStrategy.DEFAULT_SENSOR_ENABLE;
  private boolean strategyQuerySuccessDaxMax = false;
  private int strategyQuerySuccessDayMaxTimes = 1;
  private int uploadErrorBound = UploadStrategy.defaultErrorRandomBound;
  private boolean zeroPeakOnOff = false;
  private float zeroPeakRate = 1.0F;
  
  public static EventStrategyBean getInstance()
  {
    try
    {
      if (mInstance == null) {
        mInstance = new EventStrategyBean();
      }
      EventStrategyBean localEventStrategyBean = mInstance;
      return localEventStrategyBean;
    }
    finally {}
  }
  
  public int getComDelayDB()
  {
    try
    {
      int i = this.comDelayDB;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getComNumDB()
  {
    try
    {
      int i = this.comNumDB;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getComNumUpload()
  {
    try
    {
      int i = this.comNumUpload;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getConsuming()
  {
    try
    {
      int i = this.consuming;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getDailyConsumeLimit()
  {
    try
    {
      int i = this.dailyConsumeLimit;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getGatherCount()
  {
    try
    {
      int i = this.gatherCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getGatherDur()
  {
    try
    {
      long l = this.gatherDur;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getHertzCount()
  {
    try
    {
      int i = this.hertzCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getRealDelayUpload()
  {
    try
    {
      int i = this.realDelayUpload;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getRealNumUpload()
  {
    try
    {
      int i = this.realNumUpload;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getStrategyQuerySuccessDayMaxTimes()
  {
    try
    {
      int i = this.strategyQuerySuccessDayMaxTimes;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAcceleEnable()
  {
    try
    {
      boolean bool = this.acceleEnable;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isComPollUp()
  {
    try
    {
      boolean bool = this.comPollUp;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isGyroEnable()
  {
    try
    {
      boolean bool = this.gyroEnable;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isHeartbeatUsable()
  {
    try
    {
      boolean bool = this.heartbeatUsable;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isInPreventEventCode(String paramString)
  {
    boolean bool2 = false;
    try
    {
      Set localSet = this.preventEventCode;
      boolean bool1 = bool2;
      if (localSet != null)
      {
        bool1 = bool2;
        if (localSet.size() > 0) {
          bool1 = this.preventEventCode.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean isLaunchEventSimple()
  {
    try
    {
      boolean bool = this.isLaunchEventSimple;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isMagneticEnable()
  {
    try
    {
      boolean bool = this.magneticEnable;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isSensorEnable()
  {
    try
    {
      boolean bool = this.sensorEnable;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isStrategyQuerySuccessDaxMax()
  {
    try
    {
      boolean bool = this.strategyQuerySuccessDaxMax;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isTidyEventFields()
  {
    try
    {
      boolean bool = this.isTidyEventFields;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isUploadByRate(String paramString)
  {
    for (;;)
    {
      try
      {
        Object localObject = this.sampleEvent;
        boolean bool;
        if (localObject != null)
        {
          localObject = ((Map)localObject).get(paramString.toLowerCase());
          if (localObject != null) {}
        }
        else
        {
          bool = true;
          return bool;
        }
        int i = (int)(((Float)this.sampleEvent.get(paramString.toLowerCase())).floatValue() * 1000.0F);
        int j = new Random().nextInt(1000);
        if (j + 1 > i) {
          bool = false;
        } else {
          bool = true;
        }
      }
      finally {}
    }
  }
  
  public boolean isZeroPeakUploadByRate()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    try
    {
      if (this.zeroPeakOnOff)
      {
        Calendar localCalendar = Calendar.getInstance();
        int i = localCalendar.get(11);
        int j = localCalendar.get(12);
        bool1 = bool2;
        if (i == 0)
        {
          bool1 = bool2;
          if (j >= 0)
          {
            bool1 = bool2;
            if (30 >= j)
            {
              i = (int)(this.zeroPeakRate * 1000.0F);
              j = new Random().nextInt(1000);
              bool1 = bool2;
              if (j + 1 > i) {
                bool1 = false;
              }
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public void setPreventEventCode(Set<String> paramSet)
  {
    try
    {
      d.a("setPreventEventCode.size = " + paramSet.size(), new Object[0]);
      this.preventEventCode = paramSet;
      return;
    }
    finally
    {
      paramSet = finally;
      throw paramSet;
    }
  }
  
  public void setSampleEvent(Set<String> paramSet)
  {
    try
    {
      d.a("setSampleEvent.size = " + paramSet.size(), new Object[0]);
      if (this.sampleEvent == null) {
        this.sampleEvent = new HashMap();
      }
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        String[] arrayOfString = ((String)paramSet.next()).split(",");
        int i = arrayOfString.length;
        if (i == 3) {
          try
          {
            float f = Float.valueOf(arrayOfString[1]).floatValue() / Float.valueOf(arrayOfString[2]).floatValue();
            this.sampleEvent.put(arrayOfString[0].toLowerCase(), Float.valueOf(f));
          }
          catch (Exception localException) {}
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void updateConfig(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ifnull +719 -> 722
    //   6: aload_0
    //   7: aload_1
    //   8: ldc_w 262
    //   11: invokeinterface 173 2 0
    //   16: checkcast 163	java/lang/String
    //   19: aload_0
    //   20: getfield 50	com/tencent/beacon/core/event/EventStrategyBean:realNumUpload	I
    //   23: iconst_1
    //   24: bipush 50
    //   26: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   29: putfield 50	com/tencent/beacon/core/event/EventStrategyBean:realNumUpload	I
    //   32: aload_0
    //   33: aload_1
    //   34: ldc_w 269
    //   37: invokeinterface 173 2 0
    //   42: checkcast 163	java/lang/String
    //   45: aload_0
    //   46: getfield 55	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   49: bipush 10
    //   51: sipush 600
    //   54: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   57: putfield 55	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   60: aload_0
    //   61: aload_1
    //   62: ldc_w 270
    //   65: invokeinterface 173 2 0
    //   70: checkcast 163	java/lang/String
    //   73: aload_0
    //   74: getfield 60	com/tencent/beacon/core/event/EventStrategyBean:comNumDB	I
    //   77: iconst_1
    //   78: bipush 50
    //   80: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   83: putfield 60	com/tencent/beacon/core/event/EventStrategyBean:comNumDB	I
    //   86: aload_0
    //   87: aload_1
    //   88: ldc_w 271
    //   91: invokeinterface 173 2 0
    //   96: checkcast 163	java/lang/String
    //   99: aload_0
    //   100: getfield 65	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   103: bipush 30
    //   105: sipush 600
    //   108: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   111: putfield 65	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   114: aload_0
    //   115: aload_1
    //   116: ldc_w 273
    //   119: invokeinterface 173 2 0
    //   124: checkcast 163	java/lang/String
    //   127: aload_0
    //   128: getfield 70	com/tencent/beacon/core/event/EventStrategyBean:comNumUpload	I
    //   131: iconst_1
    //   132: bipush 100
    //   134: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   137: putfield 70	com/tencent/beacon/core/event/EventStrategyBean:comNumUpload	I
    //   140: aload_0
    //   141: aload_1
    //   142: ldc_w 275
    //   145: invokeinterface 173 2 0
    //   150: checkcast 163	java/lang/String
    //   153: aload_0
    //   154: getfield 77	com/tencent/beacon/core/event/EventStrategyBean:heartbeatUsable	Z
    //   157: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   160: putfield 77	com/tencent/beacon/core/event/EventStrategyBean:heartbeatUsable	Z
    //   163: aload_0
    //   164: aload_1
    //   165: ldc_w 280
    //   168: invokeinterface 173 2 0
    //   173: checkcast 163	java/lang/String
    //   176: aload_0
    //   177: getfield 83	com/tencent/beacon/core/event/EventStrategyBean:isTidyEventFields	Z
    //   180: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   183: putfield 83	com/tencent/beacon/core/event/EventStrategyBean:isTidyEventFields	Z
    //   186: aload_0
    //   187: aload_1
    //   188: ldc_w 282
    //   191: invokeinterface 173 2 0
    //   196: checkcast 163	java/lang/String
    //   199: aload_0
    //   200: getfield 85	com/tencent/beacon/core/event/EventStrategyBean:isLaunchEventSimple	Z
    //   203: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   206: putfield 85	com/tencent/beacon/core/event/EventStrategyBean:isLaunchEventSimple	Z
    //   209: aload_0
    //   210: aload_1
    //   211: ldc_w 283
    //   214: invokeinterface 173 2 0
    //   219: checkcast 163	java/lang/String
    //   222: aload_0
    //   223: getfield 75	com/tencent/beacon/core/event/EventStrategyBean:comPollUp	Z
    //   226: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   229: putfield 75	com/tencent/beacon/core/event/EventStrategyBean:comPollUp	Z
    //   232: aload_0
    //   233: aload_1
    //   234: ldc_w 285
    //   237: invokeinterface 173 2 0
    //   242: checkcast 163	java/lang/String
    //   245: aload_0
    //   246: getfield 88	com/tencent/beacon/core/event/EventStrategyBean:dailyConsumeLimit	I
    //   249: ldc_w 286
    //   252: ldc 86
    //   254: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   257: putfield 88	com/tencent/beacon/core/event/EventStrategyBean:dailyConsumeLimit	I
    //   260: aload_1
    //   261: ldc_w 288
    //   264: invokeinterface 173 2 0
    //   269: checkcast 163	java/lang/String
    //   272: invokestatic 290	com/tencent/beacon/core/e/d:a	()Z
    //   275: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   278: invokestatic 293	com/tencent/beacon/core/e/d:a	(Z)V
    //   281: aload_0
    //   282: aload_1
    //   283: ldc_w 294
    //   286: invokeinterface 173 2 0
    //   291: checkcast 163	java/lang/String
    //   294: aload_0
    //   295: getfield 90	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakOnOff	Z
    //   298: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   301: putfield 90	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakOnOff	Z
    //   304: aload_1
    //   305: ldc_w 295
    //   308: invokeinterface 173 2 0
    //   313: checkcast 163	java/lang/String
    //   316: astore_3
    //   317: aload_3
    //   318: ifnull +55 -> 373
    //   321: aload_3
    //   322: invokevirtual 298	java/lang/String:trim	()Ljava/lang/String;
    //   325: astore_3
    //   326: aload_3
    //   327: invokevirtual 301	java/lang/String:length	()I
    //   330: istore_2
    //   331: iload_2
    //   332: ifle +41 -> 373
    //   335: aload_3
    //   336: ldc 243
    //   338: invokevirtual 247	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   341: astore_3
    //   342: aload_3
    //   343: arraylength
    //   344: istore_2
    //   345: iload_2
    //   346: iconst_2
    //   347: if_icmpne +26 -> 373
    //   350: aload_0
    //   351: aload_3
    //   352: iconst_0
    //   353: aaload
    //   354: invokestatic 251	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   357: invokevirtual 179	java/lang/Float:floatValue	()F
    //   360: aload_3
    //   361: iconst_1
    //   362: aaload
    //   363: invokestatic 251	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   366: invokevirtual 179	java/lang/Float:floatValue	()F
    //   369: fdiv
    //   370: putfield 92	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakRate	F
    //   373: aload_0
    //   374: aload_1
    //   375: ldc_w 303
    //   378: invokeinterface 173 2 0
    //   383: checkcast 163	java/lang/String
    //   386: aload_0
    //   387: getfield 120	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDaxMax	Z
    //   390: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   393: putfield 120	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDaxMax	Z
    //   396: aload_0
    //   397: aload_1
    //   398: ldc_w 305
    //   401: invokeinterface 173 2 0
    //   406: checkcast 163	java/lang/String
    //   409: aload_0
    //   410: getfield 122	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDayMaxTimes	I
    //   413: iconst_1
    //   414: ldc_w 306
    //   417: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   420: putfield 122	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDayMaxTimes	I
    //   423: aload_0
    //   424: getfield 55	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   427: getstatic 53	com/tencent/beacon/upload/UploadStrategy:DEFAULT_REAL_TIME_DELAY	I
    //   430: if_icmpeq +9 -> 439
    //   433: invokestatic 311	com/tencent/beacon/core/event/TunnelModule:getInstance	()Lcom/tencent/beacon/core/event/TunnelModule;
    //   436: invokevirtual 314	com/tencent/beacon/core/event/TunnelModule:updateSchedule	()V
    //   439: aload_0
    //   440: getfield 65	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   443: getstatic 63	com/tencent/beacon/upload/UploadStrategy:DEFAULT_COMMON_DELAY	I
    //   446: if_icmpeq +9 -> 455
    //   449: invokestatic 311	com/tencent/beacon/core/event/TunnelModule:getInstance	()Lcom/tencent/beacon/core/event/TunnelModule;
    //   452: invokevirtual 314	com/tencent/beacon/core/event/TunnelModule:updateSchedule	()V
    //   455: aload_0
    //   456: aload_1
    //   457: ldc_w 315
    //   460: invokeinterface 173 2 0
    //   465: checkcast 163	java/lang/String
    //   468: aload_0
    //   469: getfield 97	com/tencent/beacon/core/event/EventStrategyBean:sensorEnable	Z
    //   472: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   475: putfield 97	com/tencent/beacon/core/event/EventStrategyBean:sensorEnable	Z
    //   478: aload_0
    //   479: aload_1
    //   480: ldc_w 316
    //   483: invokeinterface 173 2 0
    //   488: checkcast 163	java/lang/String
    //   491: aload_0
    //   492: getfield 99	com/tencent/beacon/core/event/EventStrategyBean:acceleEnable	Z
    //   495: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   498: putfield 99	com/tencent/beacon/core/event/EventStrategyBean:acceleEnable	Z
    //   501: aload_0
    //   502: aload_1
    //   503: ldc_w 317
    //   506: invokeinterface 173 2 0
    //   511: checkcast 163	java/lang/String
    //   514: aload_0
    //   515: getfield 101	com/tencent/beacon/core/event/EventStrategyBean:gyroEnable	Z
    //   518: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   521: putfield 101	com/tencent/beacon/core/event/EventStrategyBean:gyroEnable	Z
    //   524: aload_0
    //   525: aload_1
    //   526: ldc_w 318
    //   529: invokeinterface 173 2 0
    //   534: checkcast 163	java/lang/String
    //   537: aload_0
    //   538: getfield 103	com/tencent/beacon/core/event/EventStrategyBean:magneticEnable	Z
    //   541: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   544: putfield 103	com/tencent/beacon/core/event/EventStrategyBean:magneticEnable	Z
    //   547: aload_0
    //   548: aload_1
    //   549: ldc_w 319
    //   552: invokeinterface 173 2 0
    //   557: checkcast 163	java/lang/String
    //   560: aload_0
    //   561: getfield 105	com/tencent/beacon/core/event/EventStrategyBean:gatherCount	I
    //   564: iconst_1
    //   565: bipush 50
    //   567: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   570: putfield 105	com/tencent/beacon/core/event/EventStrategyBean:gatherCount	I
    //   573: aload_0
    //   574: aload_1
    //   575: ldc_w 320
    //   578: invokeinterface 173 2 0
    //   583: checkcast 163	java/lang/String
    //   586: aload_0
    //   587: getfield 109	com/tencent/beacon/core/event/EventStrategyBean:gatherDur	J
    //   590: ldc2_w 321
    //   593: ldc2_w 323
    //   596: invokestatic 327	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;JJJ)J
    //   599: putfield 109	com/tencent/beacon/core/event/EventStrategyBean:gatherDur	J
    //   602: aload_0
    //   603: aload_1
    //   604: ldc_w 328
    //   607: invokeinterface 173 2 0
    //   612: checkcast 163	java/lang/String
    //   615: aload_0
    //   616: getfield 111	com/tencent/beacon/core/event/EventStrategyBean:hertzCount	I
    //   619: bipush 20
    //   621: bipush 100
    //   623: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   626: putfield 111	com/tencent/beacon/core/event/EventStrategyBean:hertzCount	I
    //   629: aload_0
    //   630: aload_1
    //   631: ldc_w 329
    //   634: invokeinterface 173 2 0
    //   639: checkcast 163	java/lang/String
    //   642: aload_0
    //   643: getfield 113	com/tencent/beacon/core/event/EventStrategyBean:consuming	I
    //   646: bipush 60
    //   648: ldc_w 330
    //   651: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   654: putfield 113	com/tencent/beacon/core/event/EventStrategyBean:consuming	I
    //   657: aload_1
    //   658: ldc_w 332
    //   661: invokeinterface 173 2 0
    //   666: checkcast 163	java/lang/String
    //   669: iconst_1
    //   670: invokestatic 278	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   673: putstatic 335	com/tencent/beacon/upload/UploadStrategy:DEFAULT_BEACON_ID_ENABLE	Z
    //   676: aload_1
    //   677: ldc_w 337
    //   680: invokeinterface 173 2 0
    //   685: checkcast 163	java/lang/String
    //   688: astore_1
    //   689: aload_1
    //   690: ifnull +32 -> 722
    //   693: invokestatic 342	com/tencent/beacon/core/d/i:a	()Lcom/tencent/beacon/core/d/i;
    //   696: aload_1
    //   697: aload_0
    //   698: getfield 118	com/tencent/beacon/core/event/EventStrategyBean:uploadErrorBound	I
    //   701: bipush 100
    //   703: sipush 20000
    //   706: invokestatic 267	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   709: invokevirtual 345	com/tencent/beacon/core/d/i:a	(I)V
    //   712: invokestatic 342	com/tencent/beacon/core/d/i:a	()Lcom/tencent/beacon/core/d/i;
    //   715: aload_0
    //   716: getfield 118	com/tencent/beacon/core/event/EventStrategyBean:uploadErrorBound	I
    //   719: invokevirtual 345	com/tencent/beacon/core/d/i:a	(I)V
    //   722: aload_0
    //   723: monitorexit
    //   724: return
    //   725: astore_1
    //   726: aload_1
    //   727: invokestatic 348	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   730: goto -8 -> 722
    //   733: astore_1
    //   734: aload_0
    //   735: monitorexit
    //   736: aload_1
    //   737: athrow
    //   738: astore_3
    //   739: goto -366 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	742	0	this	EventStrategyBean
    //   0	742	1	paramMap	Map<String, String>
    //   330	18	2	i	int
    //   316	45	3	localObject	Object
    //   738	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	32	725	java/lang/Exception
    //   32	60	725	java/lang/Exception
    //   60	86	725	java/lang/Exception
    //   86	114	725	java/lang/Exception
    //   114	140	725	java/lang/Exception
    //   140	163	725	java/lang/Exception
    //   163	186	725	java/lang/Exception
    //   186	209	725	java/lang/Exception
    //   209	232	725	java/lang/Exception
    //   232	260	725	java/lang/Exception
    //   260	281	725	java/lang/Exception
    //   281	304	725	java/lang/Exception
    //   304	317	725	java/lang/Exception
    //   321	331	725	java/lang/Exception
    //   335	345	725	java/lang/Exception
    //   373	396	725	java/lang/Exception
    //   396	439	725	java/lang/Exception
    //   439	455	725	java/lang/Exception
    //   455	478	725	java/lang/Exception
    //   478	501	725	java/lang/Exception
    //   501	524	725	java/lang/Exception
    //   524	547	725	java/lang/Exception
    //   547	573	725	java/lang/Exception
    //   573	602	725	java/lang/Exception
    //   602	629	725	java/lang/Exception
    //   629	657	725	java/lang/Exception
    //   657	676	725	java/lang/Exception
    //   676	689	725	java/lang/Exception
    //   693	722	725	java/lang/Exception
    //   6	32	733	finally
    //   32	60	733	finally
    //   60	86	733	finally
    //   86	114	733	finally
    //   114	140	733	finally
    //   140	163	733	finally
    //   163	186	733	finally
    //   186	209	733	finally
    //   209	232	733	finally
    //   232	260	733	finally
    //   260	281	733	finally
    //   281	304	733	finally
    //   304	317	733	finally
    //   321	331	733	finally
    //   335	345	733	finally
    //   350	373	733	finally
    //   373	396	733	finally
    //   396	439	733	finally
    //   439	455	733	finally
    //   455	478	733	finally
    //   478	501	733	finally
    //   501	524	733	finally
    //   524	547	733	finally
    //   547	573	733	finally
    //   573	602	733	finally
    //   602	629	733	finally
    //   629	657	733	finally
    //   657	676	733	finally
    //   676	689	733	finally
    //   693	722	733	finally
    //   726	730	733	finally
    //   350	373	738	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.EventStrategyBean
 * JD-Core Version:    0.7.0.1
 */