package com.tencent.beacon.core.event;

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
    //   3: ifnull +713 -> 716
    //   6: aload_0
    //   7: aload_1
    //   8: ldc 239
    //   10: invokeinterface 173 2 0
    //   15: checkcast 163	java/lang/String
    //   18: aload_0
    //   19: getfield 50	com/tencent/beacon/core/event/EventStrategyBean:realNumUpload	I
    //   22: iconst_1
    //   23: bipush 50
    //   25: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   28: putfield 50	com/tencent/beacon/core/event/EventStrategyBean:realNumUpload	I
    //   31: aload_0
    //   32: aload_1
    //   33: ldc 247
    //   35: invokeinterface 173 2 0
    //   40: checkcast 163	java/lang/String
    //   43: aload_0
    //   44: getfield 55	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   47: bipush 10
    //   49: sipush 600
    //   52: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   55: putfield 55	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   58: aload_0
    //   59: aload_1
    //   60: ldc 248
    //   62: invokeinterface 173 2 0
    //   67: checkcast 163	java/lang/String
    //   70: aload_0
    //   71: getfield 60	com/tencent/beacon/core/event/EventStrategyBean:comNumDB	I
    //   74: iconst_1
    //   75: bipush 50
    //   77: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   80: putfield 60	com/tencent/beacon/core/event/EventStrategyBean:comNumDB	I
    //   83: aload_0
    //   84: aload_1
    //   85: ldc 249
    //   87: invokeinterface 173 2 0
    //   92: checkcast 163	java/lang/String
    //   95: aload_0
    //   96: getfield 65	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   99: bipush 30
    //   101: sipush 600
    //   104: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   107: putfield 65	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   110: aload_0
    //   111: aload_1
    //   112: ldc 251
    //   114: invokeinterface 173 2 0
    //   119: checkcast 163	java/lang/String
    //   122: aload_0
    //   123: getfield 70	com/tencent/beacon/core/event/EventStrategyBean:comNumUpload	I
    //   126: iconst_1
    //   127: bipush 100
    //   129: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   132: putfield 70	com/tencent/beacon/core/event/EventStrategyBean:comNumUpload	I
    //   135: aload_0
    //   136: aload_1
    //   137: ldc 253
    //   139: invokeinterface 173 2 0
    //   144: checkcast 163	java/lang/String
    //   147: aload_0
    //   148: getfield 77	com/tencent/beacon/core/event/EventStrategyBean:heartbeatUsable	Z
    //   151: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   154: putfield 77	com/tencent/beacon/core/event/EventStrategyBean:heartbeatUsable	Z
    //   157: aload_0
    //   158: aload_1
    //   159: ldc_w 258
    //   162: invokeinterface 173 2 0
    //   167: checkcast 163	java/lang/String
    //   170: aload_0
    //   171: getfield 83	com/tencent/beacon/core/event/EventStrategyBean:isTidyEventFields	Z
    //   174: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   177: putfield 83	com/tencent/beacon/core/event/EventStrategyBean:isTidyEventFields	Z
    //   180: aload_0
    //   181: aload_1
    //   182: ldc_w 260
    //   185: invokeinterface 173 2 0
    //   190: checkcast 163	java/lang/String
    //   193: aload_0
    //   194: getfield 85	com/tencent/beacon/core/event/EventStrategyBean:isLaunchEventSimple	Z
    //   197: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   200: putfield 85	com/tencent/beacon/core/event/EventStrategyBean:isLaunchEventSimple	Z
    //   203: aload_0
    //   204: aload_1
    //   205: ldc_w 261
    //   208: invokeinterface 173 2 0
    //   213: checkcast 163	java/lang/String
    //   216: aload_0
    //   217: getfield 75	com/tencent/beacon/core/event/EventStrategyBean:comPollUp	Z
    //   220: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   223: putfield 75	com/tencent/beacon/core/event/EventStrategyBean:comPollUp	Z
    //   226: aload_0
    //   227: aload_1
    //   228: ldc_w 263
    //   231: invokeinterface 173 2 0
    //   236: checkcast 163	java/lang/String
    //   239: aload_0
    //   240: getfield 88	com/tencent/beacon/core/event/EventStrategyBean:dailyConsumeLimit	I
    //   243: ldc_w 264
    //   246: ldc 86
    //   248: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   251: putfield 88	com/tencent/beacon/core/event/EventStrategyBean:dailyConsumeLimit	I
    //   254: aload_1
    //   255: ldc_w 266
    //   258: invokeinterface 173 2 0
    //   263: checkcast 163	java/lang/String
    //   266: invokestatic 270	com/tencent/beacon/core/e/d:a	()Z
    //   269: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   272: invokestatic 273	com/tencent/beacon/core/e/d:a	(Z)V
    //   275: aload_0
    //   276: aload_1
    //   277: ldc_w 274
    //   280: invokeinterface 173 2 0
    //   285: checkcast 163	java/lang/String
    //   288: aload_0
    //   289: getfield 90	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakOnOff	Z
    //   292: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   295: putfield 90	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakOnOff	Z
    //   298: aload_1
    //   299: ldc_w 275
    //   302: invokeinterface 173 2 0
    //   307: checkcast 163	java/lang/String
    //   310: astore_3
    //   311: aload_3
    //   312: ifnull +55 -> 367
    //   315: aload_3
    //   316: invokevirtual 278	java/lang/String:trim	()Ljava/lang/String;
    //   319: astore_3
    //   320: aload_3
    //   321: invokevirtual 281	java/lang/String:length	()I
    //   324: istore_2
    //   325: iload_2
    //   326: ifle +41 -> 367
    //   329: aload_3
    //   330: ldc 220
    //   332: invokevirtual 224	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   335: astore_3
    //   336: aload_3
    //   337: arraylength
    //   338: istore_2
    //   339: iload_2
    //   340: iconst_2
    //   341: if_icmpne +26 -> 367
    //   344: aload_0
    //   345: aload_3
    //   346: iconst_0
    //   347: aaload
    //   348: invokestatic 228	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   351: invokevirtual 179	java/lang/Float:floatValue	()F
    //   354: aload_3
    //   355: iconst_1
    //   356: aaload
    //   357: invokestatic 228	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   360: invokevirtual 179	java/lang/Float:floatValue	()F
    //   363: fdiv
    //   364: putfield 92	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakRate	F
    //   367: aload_0
    //   368: aload_1
    //   369: ldc_w 283
    //   372: invokeinterface 173 2 0
    //   377: checkcast 163	java/lang/String
    //   380: aload_0
    //   381: getfield 120	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDaxMax	Z
    //   384: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   387: putfield 120	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDaxMax	Z
    //   390: aload_0
    //   391: aload_1
    //   392: ldc_w 285
    //   395: invokeinterface 173 2 0
    //   400: checkcast 163	java/lang/String
    //   403: aload_0
    //   404: getfield 122	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDayMaxTimes	I
    //   407: iconst_1
    //   408: ldc_w 286
    //   411: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   414: putfield 122	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDayMaxTimes	I
    //   417: aload_0
    //   418: getfield 55	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   421: getstatic 53	com/tencent/beacon/upload/UploadStrategy:DEFAULT_REAL_TIME_DELAY	I
    //   424: if_icmpeq +9 -> 433
    //   427: invokestatic 291	com/tencent/beacon/core/event/TunnelModule:getInstance	()Lcom/tencent/beacon/core/event/TunnelModule;
    //   430: invokevirtual 294	com/tencent/beacon/core/event/TunnelModule:updateSchedule	()V
    //   433: aload_0
    //   434: getfield 65	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   437: getstatic 63	com/tencent/beacon/upload/UploadStrategy:DEFAULT_COMMON_DELAY	I
    //   440: if_icmpeq +9 -> 449
    //   443: invokestatic 291	com/tencent/beacon/core/event/TunnelModule:getInstance	()Lcom/tencent/beacon/core/event/TunnelModule;
    //   446: invokevirtual 294	com/tencent/beacon/core/event/TunnelModule:updateSchedule	()V
    //   449: aload_0
    //   450: aload_1
    //   451: ldc_w 295
    //   454: invokeinterface 173 2 0
    //   459: checkcast 163	java/lang/String
    //   462: aload_0
    //   463: getfield 97	com/tencent/beacon/core/event/EventStrategyBean:sensorEnable	Z
    //   466: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   469: putfield 97	com/tencent/beacon/core/event/EventStrategyBean:sensorEnable	Z
    //   472: aload_0
    //   473: aload_1
    //   474: ldc_w 296
    //   477: invokeinterface 173 2 0
    //   482: checkcast 163	java/lang/String
    //   485: aload_0
    //   486: getfield 99	com/tencent/beacon/core/event/EventStrategyBean:acceleEnable	Z
    //   489: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   492: putfield 99	com/tencent/beacon/core/event/EventStrategyBean:acceleEnable	Z
    //   495: aload_0
    //   496: aload_1
    //   497: ldc_w 297
    //   500: invokeinterface 173 2 0
    //   505: checkcast 163	java/lang/String
    //   508: aload_0
    //   509: getfield 101	com/tencent/beacon/core/event/EventStrategyBean:gyroEnable	Z
    //   512: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   515: putfield 101	com/tencent/beacon/core/event/EventStrategyBean:gyroEnable	Z
    //   518: aload_0
    //   519: aload_1
    //   520: ldc_w 298
    //   523: invokeinterface 173 2 0
    //   528: checkcast 163	java/lang/String
    //   531: aload_0
    //   532: getfield 103	com/tencent/beacon/core/event/EventStrategyBean:magneticEnable	Z
    //   535: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   538: putfield 103	com/tencent/beacon/core/event/EventStrategyBean:magneticEnable	Z
    //   541: aload_0
    //   542: aload_1
    //   543: ldc_w 299
    //   546: invokeinterface 173 2 0
    //   551: checkcast 163	java/lang/String
    //   554: aload_0
    //   555: getfield 105	com/tencent/beacon/core/event/EventStrategyBean:gatherCount	I
    //   558: iconst_1
    //   559: bipush 50
    //   561: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   564: putfield 105	com/tencent/beacon/core/event/EventStrategyBean:gatherCount	I
    //   567: aload_0
    //   568: aload_1
    //   569: ldc_w 300
    //   572: invokeinterface 173 2 0
    //   577: checkcast 163	java/lang/String
    //   580: aload_0
    //   581: getfield 109	com/tencent/beacon/core/event/EventStrategyBean:gatherDur	J
    //   584: ldc2_w 301
    //   587: ldc2_w 303
    //   590: invokestatic 307	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;JJJ)J
    //   593: putfield 109	com/tencent/beacon/core/event/EventStrategyBean:gatherDur	J
    //   596: aload_0
    //   597: aload_1
    //   598: ldc_w 308
    //   601: invokeinterface 173 2 0
    //   606: checkcast 163	java/lang/String
    //   609: aload_0
    //   610: getfield 111	com/tencent/beacon/core/event/EventStrategyBean:hertzCount	I
    //   613: bipush 20
    //   615: bipush 100
    //   617: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   620: putfield 111	com/tencent/beacon/core/event/EventStrategyBean:hertzCount	I
    //   623: aload_0
    //   624: aload_1
    //   625: ldc_w 309
    //   628: invokeinterface 173 2 0
    //   633: checkcast 163	java/lang/String
    //   636: aload_0
    //   637: getfield 113	com/tencent/beacon/core/event/EventStrategyBean:consuming	I
    //   640: bipush 60
    //   642: ldc_w 310
    //   645: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   648: putfield 113	com/tencent/beacon/core/event/EventStrategyBean:consuming	I
    //   651: aload_1
    //   652: ldc_w 312
    //   655: invokeinterface 173 2 0
    //   660: checkcast 163	java/lang/String
    //   663: iconst_1
    //   664: invokestatic 256	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;Z)Z
    //   667: putstatic 315	com/tencent/beacon/upload/UploadStrategy:DEFAULT_BEACON_ID_ENABLE	Z
    //   670: aload_1
    //   671: ldc_w 317
    //   674: invokeinterface 173 2 0
    //   679: checkcast 163	java/lang/String
    //   682: astore_1
    //   683: aload_1
    //   684: ifnull +32 -> 716
    //   687: invokestatic 322	com/tencent/beacon/core/d/i:a	()Lcom/tencent/beacon/core/d/i;
    //   690: aload_1
    //   691: aload_0
    //   692: getfield 118	com/tencent/beacon/core/event/EventStrategyBean:uploadErrorBound	I
    //   695: bipush 100
    //   697: sipush 20000
    //   700: invokestatic 245	com/tencent/beacon/core/e/b:a	(Ljava/lang/String;III)I
    //   703: invokevirtual 325	com/tencent/beacon/core/d/i:a	(I)V
    //   706: invokestatic 322	com/tencent/beacon/core/d/i:a	()Lcom/tencent/beacon/core/d/i;
    //   709: aload_0
    //   710: getfield 118	com/tencent/beacon/core/event/EventStrategyBean:uploadErrorBound	I
    //   713: invokevirtual 325	com/tencent/beacon/core/d/i:a	(I)V
    //   716: aload_0
    //   717: monitorexit
    //   718: return
    //   719: astore_1
    //   720: aload_1
    //   721: invokestatic 328	com/tencent/beacon/core/e/d:a	(Ljava/lang/Throwable;)V
    //   724: goto -8 -> 716
    //   727: astore_1
    //   728: aload_0
    //   729: monitorexit
    //   730: aload_1
    //   731: athrow
    //   732: astore_3
    //   733: goto -366 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	736	0	this	EventStrategyBean
    //   0	736	1	paramMap	Map<String, String>
    //   324	18	2	i	int
    //   310	45	3	localObject	Object
    //   732	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	31	719	java/lang/Exception
    //   31	58	719	java/lang/Exception
    //   58	83	719	java/lang/Exception
    //   83	110	719	java/lang/Exception
    //   110	135	719	java/lang/Exception
    //   135	157	719	java/lang/Exception
    //   157	180	719	java/lang/Exception
    //   180	203	719	java/lang/Exception
    //   203	226	719	java/lang/Exception
    //   226	254	719	java/lang/Exception
    //   254	275	719	java/lang/Exception
    //   275	298	719	java/lang/Exception
    //   298	311	719	java/lang/Exception
    //   315	325	719	java/lang/Exception
    //   329	339	719	java/lang/Exception
    //   367	390	719	java/lang/Exception
    //   390	433	719	java/lang/Exception
    //   433	449	719	java/lang/Exception
    //   449	472	719	java/lang/Exception
    //   472	495	719	java/lang/Exception
    //   495	518	719	java/lang/Exception
    //   518	541	719	java/lang/Exception
    //   541	567	719	java/lang/Exception
    //   567	596	719	java/lang/Exception
    //   596	623	719	java/lang/Exception
    //   623	651	719	java/lang/Exception
    //   651	670	719	java/lang/Exception
    //   670	683	719	java/lang/Exception
    //   687	716	719	java/lang/Exception
    //   6	31	727	finally
    //   31	58	727	finally
    //   58	83	727	finally
    //   83	110	727	finally
    //   110	135	727	finally
    //   135	157	727	finally
    //   157	180	727	finally
    //   180	203	727	finally
    //   203	226	727	finally
    //   226	254	727	finally
    //   254	275	727	finally
    //   275	298	727	finally
    //   298	311	727	finally
    //   315	325	727	finally
    //   329	339	727	finally
    //   344	367	727	finally
    //   367	390	727	finally
    //   390	433	727	finally
    //   433	449	727	finally
    //   449	472	727	finally
    //   472	495	727	finally
    //   495	518	727	finally
    //   518	541	727	finally
    //   541	567	727	finally
    //   567	596	727	finally
    //   596	623	727	finally
    //   623	651	727	finally
    //   651	670	727	finally
    //   670	683	727	finally
    //   687	716	727	finally
    //   720	724	727	finally
    //   344	367	732	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.EventStrategyBean
 * JD-Core Version:    0.7.0.1
 */