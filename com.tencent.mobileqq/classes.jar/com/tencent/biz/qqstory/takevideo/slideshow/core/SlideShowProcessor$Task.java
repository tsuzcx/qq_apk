package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class SlideShowProcessor$Task
  implements Runnable
{
  long a;
  long b;
  public SlideShowProcessor.TaskContext c;
  protected AtomicLong d = new AtomicLong(0L);
  private VideoToVideo e = new VideoToVideo();
  private ImageToVideo f = new ImageToVideo(true);
  private VideoMerger g = new VideoMerger();
  private boolean h = true;
  private Queue<SlideShowProcessor.TaskContext> i = new LinkedList();
  
  private void a(Queue<SlideShowProcessor.TaskContext> paramQueue, String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("PendingTask : ");
    localStringBuilder2.append(paramString);
    localStringBuilder1.append(localStringBuilder2.toString());
    if ((paramQueue != null) && (paramQueue.size() > 0))
    {
      paramQueue = paramQueue.iterator();
      while (paramQueue.hasNext())
      {
        paramString = (SlideShowProcessor.TaskContext)paramQueue.next();
        localStringBuilder1.append("\n");
        if ((paramString instanceof SlideShowProcessor.ConvertContext))
        {
          paramString = (SlideShowProcessor.ConvertContext)paramString;
          if ((paramString.e != null) && (paramString.e.f != null)) {
            localStringBuilder1.append(paramString.e.f);
          } else {
            localStringBuilder1.append("null");
          }
        }
        else if ((paramString instanceof VideoMerger.MergeContext))
        {
          paramString = new VideoMerger.MergeContext();
          localStringBuilder1.append("merge task");
          if ((paramString.a != null) && (paramString.a.size() > 0))
          {
            localStringBuilder1.append(" : ");
            paramString = paramString.a.iterator();
            while (paramString.hasNext())
            {
              localStringBuilder1.append(((SlideItemInfo)paramString.next()).f);
              localStringBuilder1.append("  ----  ");
            }
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessorTask", 2, localStringBuilder1.toString());
    }
  }
  
  private SlideShowProcessor.TaskContext c()
  {
    try
    {
      Object localObject1 = this.i;
      if (localObject1 == null) {
        return null;
      }
      if (this.i.size() != 0) {
        a(this.i, "poll");
      }
      localObject1 = (SlideShowProcessor.TaskContext)this.i.poll();
      return localObject1;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        SlideShowProcessor.TaskContext localTaskContext = (SlideShowProcessor.TaskContext)localIterator.next();
        Object localObject2 = new ResultInfo();
        ((ResultInfo)localObject2).b = 2;
        ((ResultInfo)localObject2).a = localTaskContext.k;
        ((ResultInfo)localObject2).i = false;
        ((ResultInfo)localObject2).j = 1;
        if (localTaskContext.l != null)
        {
          localTaskContext.l.a((ResultInfo)localObject2);
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("listener is null, taskContext Type : ");
          ((StringBuilder)localObject2).append(localTaskContext.getClass().getSimpleName());
          QLog.d("SlideShowProcessorTask", 2, ((StringBuilder)localObject2).toString());
        }
      }
      a(this.i, "stopAll");
      this.i.clear();
      b();
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void a(SlideShowProcessor.TaskContext paramTaskContext)
  {
    try
    {
      this.i.add(paramTaskContext);
      if (QLog.isColorLevel()) {
        if ((paramTaskContext instanceof VideoMerger.MergeContext)) {
          QLog.d("SlideShowProcessorTask", 2, "add merge context");
        } else if ((paramTaskContext instanceof SlideShowProcessor.ConvertContext)) {
          if (((SlideShowProcessor.ConvertContext)paramTaskContext).e == null)
          {
            QLog.d("SlideShowProcessorTask", 2, "add convertContext itemInfo is null");
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("add convertContext : ");
            localStringBuilder.append(((SlideShowProcessor.ConvertContext)paramTaskContext).e.f);
            QLog.d("SlideShowProcessorTask", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return false;
      }
      if ((this.c != null) && ((this.c instanceof SlideShowProcessor.ConvertContext)) && (((SlideShowProcessor.ConvertContext)this.c).e != null))
      {
        bool = paramString.equals(((SlideShowProcessor.ConvertContext)this.c).e.f);
        if (bool) {
          return true;
        }
      }
      Iterator localIterator = this.i.iterator();
      while (localIterator.hasNext())
      {
        SlideShowProcessor.TaskContext localTaskContext = (SlideShowProcessor.TaskContext)localIterator.next();
        if ((localTaskContext instanceof SlideShowProcessor.ConvertContext))
        {
          bool = ((SlideShowProcessor.ConvertContext)localTaskContext).e.f.equals(paramString);
          if (bool) {
            return true;
          }
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessorTask", 2, "stopPeek begin");
      }
      if ((this.c != null) && (this.c.j == true) && (this.h))
      {
        SlideShowProcessor.TaskContext localTaskContext = this.c;
        this.c.j = false;
        ResultInfo localResultInfo = new ResultInfo();
        localResultInfo.a = localTaskContext.k;
        localResultInfo.i = false;
        localResultInfo.j = 1;
        if (localTaskContext.l != null) {
          localTaskContext.l.a(localResultInfo);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessorTask", 2, "stopPeek end");
      }
      a(this.i, "stopPeek");
      return;
    }
    finally {}
  }
  
  public void b(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessorTask", 2, "stopByPath begin");
      }
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if ((this.c != null) && ((this.c instanceof SlideShowProcessor.ConvertContext)) && (((SlideShowProcessor.ConvertContext)this.c).e.f.equals(paramString)))
      {
        b();
      }
      else
      {
        Iterator localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          SlideShowProcessor.TaskContext localTaskContext = (SlideShowProcessor.TaskContext)localIterator.next();
          if (((localTaskContext instanceof SlideShowProcessor.ConvertContext)) && (((SlideShowProcessor.ConvertContext)localTaskContext).e.f.equals(paramString))) {
            this.i.remove(localTaskContext);
          }
        }
      }
      a(this.i, "stopByPath");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 133
    //   8: iconst_2
    //   9: ldc 236
    //   11: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 42	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:h	Z
    //   18: ifeq +591 -> 609
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: aload_0
    //   25: invokespecial 238	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	()Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   28: putfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   37: ifnull +367 -> 404
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   46: iconst_1
    //   47: putfield 217	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:j	Z
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_0
    //   53: getfield 35	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:d	Ljava/util/concurrent/atomic/AtomicLong;
    //   56: lconst_1
    //   57: invokevirtual 242	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   60: lstore_1
    //   61: aload_0
    //   62: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   65: lload_1
    //   66: putfield 154	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:k	J
    //   69: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +34 -> 106
    //   75: new 63	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   82: astore_3
    //   83: aload_3
    //   84: ldc 244
    //   86: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: lload_1
    //   92: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 133
    //   98: iconst_2
    //   99: aload_3
    //   100: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_0
    //   107: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   110: instanceof 112
    //   113: ifeq +48 -> 161
    //   116: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +11 -> 130
    //   122: ldc 133
    //   124: iconst_2
    //   125: ldc 249
    //   127: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: getfield 59	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:g	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger;
    //   134: aload_0
    //   135: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   138: checkcast 112	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger$MergeContext
    //   141: invokevirtual 252	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger$MergeContext;)V
    //   144: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +227 -> 374
    //   150: ldc 133
    //   152: iconst_2
    //   153: ldc 254
    //   155: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: goto +216 -> 374
    //   161: aload_0
    //   162: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   165: checkcast 100	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext
    //   168: getfield 103	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:e	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
    //   171: getfield 256	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:e	I
    //   174: ifne +103 -> 277
    //   177: aload_0
    //   178: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   181: putfield 263	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:a	J
    //   184: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +35 -> 222
    //   190: new 63	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   197: astore_3
    //   198: aload_3
    //   199: ldc_w 265
    //   202: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload_3
    //   207: lload_1
    //   208: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 133
    //   214: iconst_2
    //   215: aload_3
    //   216: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   222: aload_0
    //   223: getfield 49	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:f	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo;
    //   226: aload_0
    //   227: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   230: checkcast 100	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext
    //   233: invokevirtual 268	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   236: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   239: ifeq +135 -> 374
    //   242: new 63	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   249: astore_3
    //   250: aload_3
    //   251: ldc_w 270
    //   254: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: aload_3
    //   259: lload_1
    //   260: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 133
    //   266: iconst_2
    //   267: aload_3
    //   268: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: goto +100 -> 374
    //   277: aload_0
    //   278: invokestatic 262	java/lang/System:currentTimeMillis	()J
    //   281: putfield 272	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:b	J
    //   284: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   287: ifeq +35 -> 322
    //   290: new 63	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   297: astore_3
    //   298: aload_3
    //   299: ldc_w 274
    //   302: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload_3
    //   307: lload_1
    //   308: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: ldc 133
    //   314: iconst_2
    //   315: aload_3
    //   316: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: aload_0
    //   323: getfield 54	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:e	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo;
    //   326: aload_0
    //   327: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   330: checkcast 100	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext
    //   333: invokevirtual 275	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   336: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +35 -> 374
    //   342: new 63	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   349: astore_3
    //   350: aload_3
    //   351: ldc_w 277
    //   354: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: aload_3
    //   359: lload_1
    //   360: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: ldc 133
    //   366: iconst_2
    //   367: aload_3
    //   368: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload_0
    //   375: monitorenter
    //   376: aload_0
    //   377: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   380: iconst_0
    //   381: putfield 217	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:j	Z
    //   384: aload_0
    //   385: aconst_null
    //   386: putfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   389: aload_0
    //   390: monitorexit
    //   391: goto +13 -> 404
    //   394: astore_3
    //   395: aload_0
    //   396: monitorexit
    //   397: aload_3
    //   398: athrow
    //   399: astore_3
    //   400: aload_0
    //   401: monitorexit
    //   402: aload_3
    //   403: athrow
    //   404: aload_0
    //   405: monitorenter
    //   406: aload_0
    //   407: invokevirtual 280	java/lang/Object:notifyAll	()V
    //   410: aload_0
    //   411: monitorexit
    //   412: aload_0
    //   413: monitorenter
    //   414: aload_0
    //   415: invokevirtual 280	java/lang/Object:notifyAll	()V
    //   418: aload_0
    //   419: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   422: ifnull +16 -> 438
    //   425: aload_0
    //   426: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   429: iconst_0
    //   430: putfield 217	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:j	Z
    //   433: aload_0
    //   434: aconst_null
    //   435: putfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   438: aload_0
    //   439: monitorexit
    //   440: goto +93 -> 533
    //   443: astore_3
    //   444: aload_0
    //   445: monitorexit
    //   446: aload_3
    //   447: athrow
    //   448: astore_3
    //   449: aload_0
    //   450: monitorexit
    //   451: aload_3
    //   452: athrow
    //   453: astore_3
    //   454: goto +115 -> 569
    //   457: astore_3
    //   458: aload_3
    //   459: invokestatic 285	com/tencent/util/ThrowablesUtils:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   462: astore_3
    //   463: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +39 -> 505
    //   469: new 63	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   476: astore 4
    //   478: aload 4
    //   480: ldc_w 287
    //   483: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 4
    //   489: aload_3
    //   490: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: ldc 133
    //   496: iconst_2
    //   497: aload 4
    //   499: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_0
    //   506: monitorenter
    //   507: aload_0
    //   508: invokevirtual 280	java/lang/Object:notifyAll	()V
    //   511: aload_0
    //   512: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   515: ifnull +16 -> 531
    //   518: aload_0
    //   519: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   522: iconst_0
    //   523: putfield 217	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:j	Z
    //   526: aload_0
    //   527: aconst_null
    //   528: putfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   531: aload_0
    //   532: monitorexit
    //   533: ldc2_w 288
    //   536: invokestatic 294	java/lang/Thread:sleep	(J)V
    //   539: goto -525 -> 14
    //   542: astore_3
    //   543: aload_3
    //   544: invokestatic 285	com/tencent/util/ThrowablesUtils:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   547: astore_3
    //   548: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   551: ifeq -537 -> 14
    //   554: ldc 133
    //   556: iconst_2
    //   557: aload_3
    //   558: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: goto -547 -> 14
    //   564: astore_3
    //   565: aload_0
    //   566: monitorexit
    //   567: aload_3
    //   568: athrow
    //   569: aload_0
    //   570: monitorenter
    //   571: aload_0
    //   572: invokevirtual 280	java/lang/Object:notifyAll	()V
    //   575: aload_0
    //   576: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   579: ifnull +16 -> 595
    //   582: aload_0
    //   583: getfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   586: iconst_0
    //   587: putfield 217	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:j	Z
    //   590: aload_0
    //   591: aconst_null
    //   592: putfield 208	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   595: aload_0
    //   596: monitorexit
    //   597: aload_3
    //   598: athrow
    //   599: astore_3
    //   600: aload_0
    //   601: monitorexit
    //   602: aload_3
    //   603: athrow
    //   604: astore_3
    //   605: aload_0
    //   606: monitorexit
    //   607: aload_3
    //   608: athrow
    //   609: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	610	0	this	Task
    //   60	300	1	l	long
    //   82	286	3	localStringBuilder1	StringBuilder
    //   394	4	3	localObject1	Object
    //   399	4	3	localObject2	Object
    //   443	4	3	localObject3	Object
    //   448	4	3	localObject4	Object
    //   453	1	3	localObject5	Object
    //   457	2	3	localException	java.lang.Exception
    //   462	28	3	str1	String
    //   542	2	3	localInterruptedException	java.lang.InterruptedException
    //   547	11	3	str2	String
    //   564	34	3	localObject6	Object
    //   599	4	3	localObject7	Object
    //   604	4	3	localObject8	Object
    //   476	22	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   376	391	394	finally
    //   395	397	394	finally
    //   42	52	399	finally
    //   400	402	399	finally
    //   414	438	443	finally
    //   438	440	443	finally
    //   444	446	443	finally
    //   406	412	448	finally
    //   449	451	448	finally
    //   33	42	453	finally
    //   52	106	453	finally
    //   106	130	453	finally
    //   130	158	453	finally
    //   161	222	453	finally
    //   222	274	453	finally
    //   277	322	453	finally
    //   322	374	453	finally
    //   374	376	453	finally
    //   397	399	453	finally
    //   402	404	453	finally
    //   404	406	453	finally
    //   451	453	453	finally
    //   458	505	453	finally
    //   33	42	457	java/lang/Exception
    //   52	106	457	java/lang/Exception
    //   106	130	457	java/lang/Exception
    //   130	158	457	java/lang/Exception
    //   161	222	457	java/lang/Exception
    //   222	274	457	java/lang/Exception
    //   277	322	457	java/lang/Exception
    //   322	374	457	java/lang/Exception
    //   374	376	457	java/lang/Exception
    //   397	399	457	java/lang/Exception
    //   402	404	457	java/lang/Exception
    //   404	406	457	java/lang/Exception
    //   451	453	457	java/lang/Exception
    //   533	539	542	java/lang/InterruptedException
    //   507	531	564	finally
    //   531	533	564	finally
    //   565	567	564	finally
    //   571	595	599	finally
    //   595	597	599	finally
    //   600	602	599	finally
    //   23	33	604	finally
    //   605	607	604	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.Task
 * JD-Core Version:    0.7.0.1
 */