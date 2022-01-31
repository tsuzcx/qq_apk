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
  private static EventStrategyBean mInstance;
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
    return this.consuming;
  }
  
  public int getDailyConsumeLimit()
  {
    return this.dailyConsumeLimit;
  }
  
  public int getGatherCount()
  {
    return this.gatherCount;
  }
  
  public long getGatherDur()
  {
    return this.gatherDur;
  }
  
  public int getHertzCount()
  {
    return this.hertzCount;
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
    return this.strategyQuerySuccessDayMaxTimes;
  }
  
  public boolean isAcceleEnable()
  {
    return this.acceleEnable;
  }
  
  public boolean isComPollUp()
  {
    return this.comPollUp;
  }
  
  public boolean isGyroEnable()
  {
    return this.gyroEnable;
  }
  
  public boolean isHeartbeatUsable()
  {
    return this.heartbeatUsable;
  }
  
  public boolean isInPreventEventCode(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.preventEventCode != null)
      {
        bool1 = bool2;
        if (this.preventEventCode.size() > 0) {
          bool1 = this.preventEventCode.contains(paramString);
        }
      }
      return bool1;
    }
    finally {}
  }
  
  public boolean isLaunchEventSimple()
  {
    return this.isLaunchEventSimple;
  }
  
  public boolean isMagneticEnable()
  {
    return this.magneticEnable;
  }
  
  public boolean isSensorEnable()
  {
    return this.sensorEnable;
  }
  
  public boolean isStrategyQuerySuccessDaxMax()
  {
    return this.strategyQuerySuccessDaxMax;
  }
  
  public boolean isTidyEventFields()
  {
    return this.isTidyEventFields;
  }
  
  public boolean isUploadByRate(String paramString)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.sampleEvent != null)
        {
          Object localObject = this.sampleEvent.get(paramString);
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
    //   3: ifnull +637 -> 640
    //   6: aload_0
    //   7: aload_1
    //   8: ldc 233
    //   10: invokeinterface 161 2 0
    //   15: checkcast 163	java/lang/String
    //   18: aload_0
    //   19: getfield 49	com/tencent/beacon/core/event/EventStrategyBean:realNumUpload	I
    //   22: iconst_1
    //   23: bipush 50
    //   25: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   28: putfield 49	com/tencent/beacon/core/event/EventStrategyBean:realNumUpload	I
    //   31: aload_0
    //   32: aload_1
    //   33: ldc 241
    //   35: invokeinterface 161 2 0
    //   40: checkcast 163	java/lang/String
    //   43: aload_0
    //   44: getfield 54	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   47: bipush 10
    //   49: sipush 600
    //   52: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   55: putfield 54	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   58: aload_0
    //   59: aload_1
    //   60: ldc 242
    //   62: invokeinterface 161 2 0
    //   67: checkcast 163	java/lang/String
    //   70: aload_0
    //   71: getfield 59	com/tencent/beacon/core/event/EventStrategyBean:comNumDB	I
    //   74: iconst_1
    //   75: bipush 50
    //   77: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   80: putfield 59	com/tencent/beacon/core/event/EventStrategyBean:comNumDB	I
    //   83: aload_0
    //   84: aload_1
    //   85: ldc 243
    //   87: invokeinterface 161 2 0
    //   92: checkcast 163	java/lang/String
    //   95: aload_0
    //   96: getfield 64	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   99: bipush 30
    //   101: sipush 600
    //   104: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   107: putfield 64	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   110: aload_0
    //   111: aload_1
    //   112: ldc 245
    //   114: invokeinterface 161 2 0
    //   119: checkcast 163	java/lang/String
    //   122: aload_0
    //   123: getfield 69	com/tencent/beacon/core/event/EventStrategyBean:comNumUpload	I
    //   126: iconst_1
    //   127: bipush 100
    //   129: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   132: putfield 69	com/tencent/beacon/core/event/EventStrategyBean:comNumUpload	I
    //   135: aload_0
    //   136: aload_1
    //   137: ldc 247
    //   139: invokeinterface 161 2 0
    //   144: checkcast 163	java/lang/String
    //   147: aload_0
    //   148: getfield 76	com/tencent/beacon/core/event/EventStrategyBean:heartbeatUsable	Z
    //   151: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   154: putfield 76	com/tencent/beacon/core/event/EventStrategyBean:heartbeatUsable	Z
    //   157: aload_0
    //   158: aload_1
    //   159: ldc 252
    //   161: invokeinterface 161 2 0
    //   166: checkcast 163	java/lang/String
    //   169: aload_0
    //   170: getfield 82	com/tencent/beacon/core/event/EventStrategyBean:isTidyEventFields	Z
    //   173: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   176: putfield 82	com/tencent/beacon/core/event/EventStrategyBean:isTidyEventFields	Z
    //   179: aload_0
    //   180: aload_1
    //   181: ldc 254
    //   183: invokeinterface 161 2 0
    //   188: checkcast 163	java/lang/String
    //   191: aload_0
    //   192: getfield 84	com/tencent/beacon/core/event/EventStrategyBean:isLaunchEventSimple	Z
    //   195: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   198: putfield 84	com/tencent/beacon/core/event/EventStrategyBean:isLaunchEventSimple	Z
    //   201: aload_0
    //   202: aload_1
    //   203: ldc 255
    //   205: invokeinterface 161 2 0
    //   210: checkcast 163	java/lang/String
    //   213: aload_0
    //   214: getfield 74	com/tencent/beacon/core/event/EventStrategyBean:comPollUp	Z
    //   217: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   220: putfield 74	com/tencent/beacon/core/event/EventStrategyBean:comPollUp	Z
    //   223: aload_0
    //   224: aload_1
    //   225: ldc_w 257
    //   228: invokeinterface 161 2 0
    //   233: checkcast 163	java/lang/String
    //   236: aload_0
    //   237: getfield 87	com/tencent/beacon/core/event/EventStrategyBean:dailyConsumeLimit	I
    //   240: ldc_w 258
    //   243: ldc 85
    //   245: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   248: putfield 87	com/tencent/beacon/core/event/EventStrategyBean:dailyConsumeLimit	I
    //   251: aload_1
    //   252: ldc_w 260
    //   255: invokeinterface 161 2 0
    //   260: checkcast 163	java/lang/String
    //   263: getstatic 265	com/tencent/beacon/core/d/b:b	Z
    //   266: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   269: putstatic 265	com/tencent/beacon/core/d/b:b	Z
    //   272: aload_0
    //   273: aload_1
    //   274: ldc_w 266
    //   277: invokeinterface 161 2 0
    //   282: checkcast 163	java/lang/String
    //   285: aload_0
    //   286: getfield 89	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakOnOff	Z
    //   289: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   292: putfield 89	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakOnOff	Z
    //   295: aload_1
    //   296: ldc_w 267
    //   299: invokeinterface 161 2 0
    //   304: checkcast 163	java/lang/String
    //   307: astore_3
    //   308: aload_3
    //   309: ifnull +53 -> 362
    //   312: aload_3
    //   313: invokevirtual 270	java/lang/String:trim	()Ljava/lang/String;
    //   316: astore_3
    //   317: aload_3
    //   318: invokevirtual 273	java/lang/String:length	()I
    //   321: ifle +41 -> 362
    //   324: aload_3
    //   325: ldc 214
    //   327: invokevirtual 218	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   330: astore_3
    //   331: aload_3
    //   332: arraylength
    //   333: istore_2
    //   334: iload_2
    //   335: iconst_2
    //   336: if_icmpne +26 -> 362
    //   339: aload_0
    //   340: aload_3
    //   341: iconst_0
    //   342: aaload
    //   343: invokestatic 222	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   346: invokevirtual 173	java/lang/Float:floatValue	()F
    //   349: aload_3
    //   350: iconst_1
    //   351: aaload
    //   352: invokestatic 222	java/lang/Float:valueOf	(Ljava/lang/String;)Ljava/lang/Float;
    //   355: invokevirtual 173	java/lang/Float:floatValue	()F
    //   358: fdiv
    //   359: putfield 91	com/tencent/beacon/core/event/EventStrategyBean:zeroPeakRate	F
    //   362: aload_0
    //   363: aload_1
    //   364: ldc_w 275
    //   367: invokeinterface 161 2 0
    //   372: checkcast 163	java/lang/String
    //   375: aload_0
    //   376: getfield 114	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDaxMax	Z
    //   379: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   382: putfield 114	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDaxMax	Z
    //   385: aload_0
    //   386: aload_1
    //   387: ldc_w 277
    //   390: invokeinterface 161 2 0
    //   395: checkcast 163	java/lang/String
    //   398: aload_0
    //   399: getfield 116	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDayMaxTimes	I
    //   402: iconst_1
    //   403: ldc_w 278
    //   406: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   409: putfield 116	com/tencent/beacon/core/event/EventStrategyBean:strategyQuerySuccessDayMaxTimes	I
    //   412: aload_0
    //   413: getfield 54	com/tencent/beacon/core/event/EventStrategyBean:realDelayUpload	I
    //   416: getstatic 52	com/tencent/beacon/upload/UploadStrategy:DEFAULT_REAL_TIME_DELAY	I
    //   419: if_icmpeq +9 -> 428
    //   422: invokestatic 283	com/tencent/beacon/core/event/TunnelModule:getInstance	()Lcom/tencent/beacon/core/event/TunnelModule;
    //   425: invokevirtual 286	com/tencent/beacon/core/event/TunnelModule:updateSchedule	()V
    //   428: aload_0
    //   429: getfield 64	com/tencent/beacon/core/event/EventStrategyBean:comDelayDB	I
    //   432: getstatic 62	com/tencent/beacon/upload/UploadStrategy:DEFAULT_COMMON_DELAY	I
    //   435: if_icmpeq +9 -> 444
    //   438: invokestatic 283	com/tencent/beacon/core/event/TunnelModule:getInstance	()Lcom/tencent/beacon/core/event/TunnelModule;
    //   441: invokevirtual 286	com/tencent/beacon/core/event/TunnelModule:updateSchedule	()V
    //   444: aload_0
    //   445: aload_1
    //   446: ldc_w 287
    //   449: invokeinterface 161 2 0
    //   454: checkcast 163	java/lang/String
    //   457: aload_0
    //   458: getfield 96	com/tencent/beacon/core/event/EventStrategyBean:sensorEnable	Z
    //   461: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   464: putfield 96	com/tencent/beacon/core/event/EventStrategyBean:sensorEnable	Z
    //   467: aload_0
    //   468: aload_1
    //   469: ldc_w 288
    //   472: invokeinterface 161 2 0
    //   477: checkcast 163	java/lang/String
    //   480: aload_0
    //   481: getfield 98	com/tencent/beacon/core/event/EventStrategyBean:acceleEnable	Z
    //   484: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   487: putfield 98	com/tencent/beacon/core/event/EventStrategyBean:acceleEnable	Z
    //   490: aload_0
    //   491: aload_1
    //   492: ldc_w 289
    //   495: invokeinterface 161 2 0
    //   500: checkcast 163	java/lang/String
    //   503: aload_0
    //   504: getfield 100	com/tencent/beacon/core/event/EventStrategyBean:gyroEnable	Z
    //   507: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   510: putfield 100	com/tencent/beacon/core/event/EventStrategyBean:gyroEnable	Z
    //   513: aload_0
    //   514: aload_1
    //   515: ldc_w 290
    //   518: invokeinterface 161 2 0
    //   523: checkcast 163	java/lang/String
    //   526: aload_0
    //   527: getfield 102	com/tencent/beacon/core/event/EventStrategyBean:magneticEnable	Z
    //   530: invokestatic 250	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;Z)Z
    //   533: putfield 102	com/tencent/beacon/core/event/EventStrategyBean:magneticEnable	Z
    //   536: aload_0
    //   537: aload_1
    //   538: ldc_w 291
    //   541: invokeinterface 161 2 0
    //   546: checkcast 163	java/lang/String
    //   549: aload_0
    //   550: getfield 104	com/tencent/beacon/core/event/EventStrategyBean:gatherCount	I
    //   553: iconst_1
    //   554: bipush 50
    //   556: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   559: putfield 104	com/tencent/beacon/core/event/EventStrategyBean:gatherCount	I
    //   562: aload_0
    //   563: aload_1
    //   564: ldc_w 292
    //   567: invokeinterface 161 2 0
    //   572: checkcast 163	java/lang/String
    //   575: aload_0
    //   576: getfield 108	com/tencent/beacon/core/event/EventStrategyBean:gatherDur	J
    //   579: invokestatic 295	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;J)J
    //   582: putfield 108	com/tencent/beacon/core/event/EventStrategyBean:gatherDur	J
    //   585: aload_0
    //   586: aload_1
    //   587: ldc_w 296
    //   590: invokeinterface 161 2 0
    //   595: checkcast 163	java/lang/String
    //   598: aload_0
    //   599: getfield 110	com/tencent/beacon/core/event/EventStrategyBean:hertzCount	I
    //   602: bipush 20
    //   604: bipush 100
    //   606: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   609: putfield 110	com/tencent/beacon/core/event/EventStrategyBean:hertzCount	I
    //   612: aload_0
    //   613: aload_1
    //   614: ldc_w 297
    //   617: invokeinterface 161 2 0
    //   622: checkcast 163	java/lang/String
    //   625: aload_0
    //   626: getfield 112	com/tencent/beacon/core/event/EventStrategyBean:consuming	I
    //   629: bipush 60
    //   631: ldc_w 298
    //   634: invokestatic 239	com/tencent/beacon/core/d/i:a	(Ljava/lang/String;III)I
    //   637: putfield 112	com/tencent/beacon/core/event/EventStrategyBean:consuming	I
    //   640: aload_0
    //   641: monitorexit
    //   642: return
    //   643: astore_1
    //   644: aload_1
    //   645: invokestatic 301	com/tencent/beacon/core/d/b:a	(Ljava/lang/Throwable;)V
    //   648: goto -8 -> 640
    //   651: astore_1
    //   652: aload_0
    //   653: monitorexit
    //   654: aload_1
    //   655: athrow
    //   656: astore_3
    //   657: goto -295 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	this	EventStrategyBean
    //   0	660	1	paramMap	Map<String, String>
    //   333	4	2	i	int
    //   307	43	3	localObject	Object
    //   656	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   6	308	643	java/lang/Exception
    //   312	334	643	java/lang/Exception
    //   362	428	643	java/lang/Exception
    //   428	444	643	java/lang/Exception
    //   444	640	643	java/lang/Exception
    //   6	308	651	finally
    //   312	334	651	finally
    //   339	362	651	finally
    //   362	428	651	finally
    //   428	444	651	finally
    //   444	640	651	finally
    //   644	648	651	finally
    //   339	362	656	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.event.EventStrategyBean
 * JD-Core Version:    0.7.0.1
 */