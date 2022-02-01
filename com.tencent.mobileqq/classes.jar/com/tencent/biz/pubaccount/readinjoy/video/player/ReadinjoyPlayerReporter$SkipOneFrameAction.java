package com.tencent.biz.pubaccount.readinjoy.video.player;

public class ReadinjoyPlayerReporter$SkipOneFrameAction
  extends ReadinjoyPlayerReporter.ReportInfoAction
{
  public ReadinjoyPlayerReporter$SkipOneFrameAction(ReadinjoyPlayerReporter paramReadinjoyPlayerReporter)
  {
    super(paramReadinjoyPlayerReporter);
  }
  
  /* Error */
  public void a(int paramInt, java.lang.Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 18	org/json/JSONObject
    //   5: dup
    //   6: aload_2
    //   7: checkcast 20	java/lang/String
    //   10: invokespecial 23	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: ldc 25
    //   17: iconst_0
    //   18: invokevirtual 29	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   21: istore_1
    //   22: aload_2
    //   23: ldc 31
    //   25: iconst_1
    //   26: invokevirtual 29	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   29: istore 4
    //   31: iload 4
    //   33: istore_3
    //   34: iload_3
    //   35: ifle +21 -> 56
    //   38: aload_0
    //   39: getfield 10	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter$SkipOneFrameAction:a	Lcom/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter;
    //   42: getfield 36	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter:a	Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;
    //   45: astore_2
    //   46: aload_2
    //   47: aload_2
    //   48: getfield 42	com/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData:q	I
    //   51: iload_3
    //   52: iadd
    //   53: putfield 42	com/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData:q	I
    //   56: aload_0
    //   57: getfield 10	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter$SkipOneFrameAction:a	Lcom/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter;
    //   60: getfield 36	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter:a	Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;
    //   63: astore_2
    //   64: aload_2
    //   65: aload_2
    //   66: getfield 45	com/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData:r	I
    //   69: iload_3
    //   70: iadd
    //   71: putfield 45	com/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData:r	I
    //   74: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq +73 -> 150
    //   80: ldc 53
    //   82: iconst_2
    //   83: new 55	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   90: ldc 60
    //   92: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: iload_1
    //   96: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc 69
    //   101: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload_3
    //   105: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   108: ldc 71
    //   110: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 10	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter$SkipOneFrameAction:a	Lcom/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter;
    //   117: getfield 36	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter:a	Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;
    //   120: getfield 42	com/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData:q	I
    //   123: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc 73
    //   128: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: aload_0
    //   132: getfield 10	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter$SkipOneFrameAction:a	Lcom/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter;
    //   135: getfield 36	com/tencent/biz/pubaccount/readinjoy/video/player/ReadinjoyPlayerReporter:a	Lcom/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData;
    //   138: getfield 45	com/tencent/biz/pubaccount/readinjoy/struct/ReadinjoyVideoReportData:r	I
    //   141: invokevirtual 67	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   150: return
    //   151: astore_2
    //   152: iconst_0
    //   153: istore_1
    //   154: ldc 53
    //   156: iconst_2
    //   157: new 55	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   164: ldc 83
    //   166: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload_2
    //   170: invokevirtual 86	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   173: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 89	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: goto -148 -> 34
    //   185: astore_2
    //   186: goto -32 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	SkipOneFrameAction
    //   0	189	1	paramInt	int
    //   0	189	2	paramObject	java.lang.Object
    //   1	104	3	i	int
    //   29	3	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	22	151	java/lang/Exception
    //   22	31	185	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.SkipOneFrameAction
 * JD-Core Version:    0.7.0.1
 */