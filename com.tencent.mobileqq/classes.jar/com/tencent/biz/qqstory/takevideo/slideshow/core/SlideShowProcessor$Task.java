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
  long jdField_a_of_type_Long;
  private ImageToVideo jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo = new ImageToVideo(true);
  public SlideShowProcessor.TaskContext a;
  private VideoMerger jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger = new VideoMerger();
  private VideoToVideo jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoToVideo = new VideoToVideo();
  private Queue<SlideShowProcessor.TaskContext> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  protected AtomicLong a;
  private boolean jdField_a_of_type_Boolean = true;
  long b;
  
  public SlideShowProcessor$Task()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  }
  
  private SlideShowProcessor.TaskContext a()
  {
    try
    {
      Object localObject1 = this.jdField_a_of_type_JavaUtilQueue;
      if (localObject1 == null) {
        return null;
      }
      if (this.jdField_a_of_type_JavaUtilQueue.size() != 0) {
        a(this.jdField_a_of_type_JavaUtilQueue, "poll");
      }
      localObject1 = (SlideShowProcessor.TaskContext)this.jdField_a_of_type_JavaUtilQueue.poll();
      return localObject1;
    }
    finally {}
  }
  
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
          if ((paramString.a != null) && (paramString.a.jdField_b_of_type_JavaLangString != null)) {
            localStringBuilder1.append(paramString.a.jdField_b_of_type_JavaLangString);
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
              localStringBuilder1.append(((SlideItemInfo)paramString.next()).jdField_b_of_type_JavaLangString);
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
  
  public void a()
  {
    try
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      while (localIterator.hasNext())
      {
        SlideShowProcessor.TaskContext localTaskContext = (SlideShowProcessor.TaskContext)localIterator.next();
        Object localObject2 = new ResultInfo();
        ((ResultInfo)localObject2).jdField_a_of_type_Int = 2;
        ((ResultInfo)localObject2).jdField_a_of_type_Long = localTaskContext.b;
        ((ResultInfo)localObject2).jdField_a_of_type_Boolean = false;
        ((ResultInfo)localObject2).jdField_b_of_type_Int = 1;
        if (localTaskContext.a != null)
        {
          localTaskContext.a.a((ResultInfo)localObject2);
        }
        else if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("listener is null, taskContext Type : ");
          ((StringBuilder)localObject2).append(localTaskContext.getClass().getSimpleName());
          QLog.d("SlideShowProcessorTask", 2, ((StringBuilder)localObject2).toString());
        }
      }
      a(this.jdField_a_of_type_JavaUtilQueue, "stopAll");
      this.jdField_a_of_type_JavaUtilQueue.clear();
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
      this.jdField_a_of_type_JavaUtilQueue.add(paramTaskContext);
      if (QLog.isColorLevel()) {
        if ((paramTaskContext instanceof VideoMerger.MergeContext)) {
          QLog.d("SlideShowProcessorTask", 2, "add merge context");
        } else if ((paramTaskContext instanceof SlideShowProcessor.ConvertContext)) {
          if (((SlideShowProcessor.ConvertContext)paramTaskContext).a == null)
          {
            QLog.d("SlideShowProcessorTask", 2, "add convertContext itemInfo is null");
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("add convertContext : ");
            localStringBuilder.append(((SlideShowProcessor.ConvertContext)paramTaskContext).a.jdField_b_of_type_JavaLangString);
            QLog.d("SlideShowProcessorTask", 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString)
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext instanceof SlideShowProcessor.ConvertContext)) && (((SlideShowProcessor.ConvertContext)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext).a.jdField_b_of_type_JavaLangString.equals(paramString)))
      {
        b();
      }
      else
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
        while (localIterator.hasNext())
        {
          SlideShowProcessor.TaskContext localTaskContext = (SlideShowProcessor.TaskContext)localIterator.next();
          if (((localTaskContext instanceof SlideShowProcessor.ConvertContext)) && (((SlideShowProcessor.ConvertContext)localTaskContext).a.jdField_b_of_type_JavaLangString.equals(paramString))) {
            this.jdField_a_of_type_JavaUtilQueue.remove(localTaskContext);
          }
        }
      }
      a(this.jdField_a_of_type_JavaUtilQueue, "stopByPath");
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public boolean a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return false;
      }
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext instanceof SlideShowProcessor.ConvertContext)) && (((SlideShowProcessor.ConvertContext)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext).a != null))
      {
        bool = paramString.equals(((SlideShowProcessor.ConvertContext)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext).a.jdField_b_of_type_JavaLangString);
        if (bool) {
          return true;
        }
      }
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      while (localIterator.hasNext())
      {
        SlideShowProcessor.TaskContext localTaskContext = (SlideShowProcessor.TaskContext)localIterator.next();
        if ((localTaskContext instanceof SlideShowProcessor.ConvertContext))
        {
          bool = ((SlideShowProcessor.ConvertContext)localTaskContext).a.jdField_b_of_type_JavaLangString.equals(paramString);
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
      if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext.d == true) && (this.jdField_a_of_type_Boolean))
      {
        SlideShowProcessor.TaskContext localTaskContext = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext.d = false;
        ResultInfo localResultInfo = new ResultInfo();
        localResultInfo.jdField_a_of_type_Long = localTaskContext.b;
        localResultInfo.jdField_a_of_type_Boolean = false;
        localResultInfo.jdField_b_of_type_Int = 1;
        if (localTaskContext.a != null) {
          localTaskContext.a.a(localResultInfo);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessorTask", 2, "stopPeek end");
      }
      a(this.jdField_a_of_type_JavaUtilQueue, "stopPeek");
      return;
    }
    finally {}
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 133
    //   8: iconst_2
    //   9: ldc 226
    //   11: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: getfield 35	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Boolean	Z
    //   18: ifeq +590 -> 608
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: aload_0
    //   25: invokespecial 228	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:a	()Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   28: putfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_0
    //   34: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   37: ifnull +366 -> 403
    //   40: aload_0
    //   41: monitorenter
    //   42: aload_0
    //   43: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   46: iconst_1
    //   47: putfield 215	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:d	Z
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_0
    //   53: getfield 28	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong	Ljava/util/concurrent/atomic/AtomicLong;
    //   56: lconst_1
    //   57: invokevirtual 232	java/util/concurrent/atomic/AtomicLong:addAndGet	(J)J
    //   60: lstore_1
    //   61: aload_0
    //   62: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   65: lload_1
    //   66: putfield 147	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:b	J
    //   69: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +34 -> 106
    //   75: new 72	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   82: astore_3
    //   83: aload_3
    //   84: ldc 234
    //   86: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload_3
    //   91: lload_1
    //   92: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 133
    //   98: iconst_2
    //   99: aload_3
    //   100: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_0
    //   107: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   110: instanceof 112
    //   113: ifeq +48 -> 161
    //   116: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   119: ifeq +11 -> 130
    //   122: ldc 133
    //   124: iconst_2
    //   125: ldc 239
    //   127: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload_0
    //   131: getfield 52	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoMerger	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger;
    //   134: aload_0
    //   135: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   138: checkcast 112	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger$MergeContext
    //   141: invokevirtual 242	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/VideoMerger$MergeContext;)V
    //   144: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +226 -> 373
    //   150: ldc 133
    //   152: iconst_2
    //   153: ldc 244
    //   155: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   158: goto +215 -> 373
    //   161: aload_0
    //   162: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   165: checkcast 100	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext
    //   168: getfield 103	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext:a	Lcom/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo;
    //   171: getfield 245	com/tencent/biz/qqstory/takevideo/slideshow/SlideItemInfo:jdField_b_of_type_Int	I
    //   174: ifne +102 -> 276
    //   177: aload_0
    //   178: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   181: putfield 252	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_Long	J
    //   184: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   187: ifeq +34 -> 221
    //   190: new 72	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   197: astore_3
    //   198: aload_3
    //   199: ldc 254
    //   201: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_3
    //   206: lload_1
    //   207: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: ldc 133
    //   213: iconst_2
    //   214: aload_3
    //   215: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: aload_0
    //   222: getfield 42	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo;
    //   225: aload_0
    //   226: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   229: checkcast 100	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext
    //   232: invokevirtual 257	com/tencent/biz/qqstory/takevideo/slideshow/core/ImageToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   235: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   238: ifeq +135 -> 373
    //   241: new 72	java/lang/StringBuilder
    //   244: dup
    //   245: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   248: astore_3
    //   249: aload_3
    //   250: ldc_w 259
    //   253: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload_3
    //   258: lload_1
    //   259: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 133
    //   265: iconst_2
    //   266: aload_3
    //   267: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   273: goto +100 -> 373
    //   276: aload_0
    //   277: invokestatic 251	java/lang/System:currentTimeMillis	()J
    //   280: putfield 260	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:b	J
    //   283: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +35 -> 321
    //   289: new 72	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   296: astore_3
    //   297: aload_3
    //   298: ldc_w 262
    //   301: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload_3
    //   306: lload_1
    //   307: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: ldc 133
    //   313: iconst_2
    //   314: aload_3
    //   315: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload_0
    //   322: getfield 47	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoToVideo	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo;
    //   325: aload_0
    //   326: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   329: checkcast 100	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext
    //   332: invokevirtual 263	com/tencent/biz/qqstory/takevideo/slideshow/core/VideoToVideo:a	(Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$ConvertContext;)V
    //   335: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   338: ifeq +35 -> 373
    //   341: new 72	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   348: astore_3
    //   349: aload_3
    //   350: ldc_w 265
    //   353: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_3
    //   358: lload_1
    //   359: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: ldc 133
    //   365: iconst_2
    //   366: aload_3
    //   367: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload_0
    //   374: monitorenter
    //   375: aload_0
    //   376: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   379: iconst_0
    //   380: putfield 215	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:d	Z
    //   383: aload_0
    //   384: aconst_null
    //   385: putfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   388: aload_0
    //   389: monitorexit
    //   390: goto +13 -> 403
    //   393: astore_3
    //   394: aload_0
    //   395: monitorexit
    //   396: aload_3
    //   397: athrow
    //   398: astore_3
    //   399: aload_0
    //   400: monitorexit
    //   401: aload_3
    //   402: athrow
    //   403: aload_0
    //   404: monitorenter
    //   405: aload_0
    //   406: invokevirtual 268	java/lang/Object:notifyAll	()V
    //   409: aload_0
    //   410: monitorexit
    //   411: aload_0
    //   412: monitorenter
    //   413: aload_0
    //   414: invokevirtual 268	java/lang/Object:notifyAll	()V
    //   417: aload_0
    //   418: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   421: ifnull +16 -> 437
    //   424: aload_0
    //   425: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   428: iconst_0
    //   429: putfield 215	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:d	Z
    //   432: aload_0
    //   433: aconst_null
    //   434: putfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   437: aload_0
    //   438: monitorexit
    //   439: goto +93 -> 532
    //   442: astore_3
    //   443: aload_0
    //   444: monitorexit
    //   445: aload_3
    //   446: athrow
    //   447: astore_3
    //   448: aload_0
    //   449: monitorexit
    //   450: aload_3
    //   451: athrow
    //   452: astore_3
    //   453: goto +115 -> 568
    //   456: astore_3
    //   457: aload_3
    //   458: invokestatic 273	com/tencent/util/ThrowablesUtils:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   461: astore_3
    //   462: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +39 -> 504
    //   468: new 72	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   475: astore 4
    //   477: aload 4
    //   479: ldc_w 275
    //   482: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 4
    //   488: aload_3
    //   489: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: ldc 133
    //   495: iconst_2
    //   496: aload 4
    //   498: invokevirtual 83	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: aload_0
    //   505: monitorenter
    //   506: aload_0
    //   507: invokevirtual 268	java/lang/Object:notifyAll	()V
    //   510: aload_0
    //   511: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   514: ifnull +16 -> 530
    //   517: aload_0
    //   518: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   521: iconst_0
    //   522: putfield 215	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:d	Z
    //   525: aload_0
    //   526: aconst_null
    //   527: putfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   530: aload_0
    //   531: monitorexit
    //   532: ldc2_w 276
    //   535: invokestatic 282	java/lang/Thread:sleep	(J)V
    //   538: goto -524 -> 14
    //   541: astore_3
    //   542: aload_3
    //   543: invokestatic 273	com/tencent/util/ThrowablesUtils:a	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   546: astore_3
    //   547: invokestatic 131	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq -536 -> 14
    //   553: ldc 133
    //   555: iconst_2
    //   556: aload_3
    //   557: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: goto -546 -> 14
    //   563: astore_3
    //   564: aload_0
    //   565: monitorexit
    //   566: aload_3
    //   567: athrow
    //   568: aload_0
    //   569: monitorenter
    //   570: aload_0
    //   571: invokevirtual 268	java/lang/Object:notifyAll	()V
    //   574: aload_0
    //   575: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   578: ifnull +16 -> 594
    //   581: aload_0
    //   582: getfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   585: iconst_0
    //   586: putfield 215	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext:d	Z
    //   589: aload_0
    //   590: aconst_null
    //   591: putfield 200	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$TaskContext	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$TaskContext;
    //   594: aload_0
    //   595: monitorexit
    //   596: aload_3
    //   597: athrow
    //   598: astore_3
    //   599: aload_0
    //   600: monitorexit
    //   601: aload_3
    //   602: athrow
    //   603: astore_3
    //   604: aload_0
    //   605: monitorexit
    //   606: aload_3
    //   607: athrow
    //   608: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	609	0	this	Task
    //   60	299	1	l	long
    //   82	285	3	localStringBuilder1	StringBuilder
    //   393	4	3	localObject1	Object
    //   398	4	3	localObject2	Object
    //   442	4	3	localObject3	Object
    //   447	4	3	localObject4	Object
    //   452	1	3	localObject5	Object
    //   456	2	3	localException	java.lang.Exception
    //   461	28	3	str1	String
    //   541	2	3	localInterruptedException	java.lang.InterruptedException
    //   546	11	3	str2	String
    //   563	34	3	localObject6	Object
    //   598	4	3	localObject7	Object
    //   603	4	3	localObject8	Object
    //   475	22	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   375	390	393	finally
    //   394	396	393	finally
    //   42	52	398	finally
    //   399	401	398	finally
    //   413	437	442	finally
    //   437	439	442	finally
    //   443	445	442	finally
    //   405	411	447	finally
    //   448	450	447	finally
    //   33	42	452	finally
    //   52	106	452	finally
    //   106	130	452	finally
    //   130	158	452	finally
    //   161	221	452	finally
    //   221	273	452	finally
    //   276	321	452	finally
    //   321	373	452	finally
    //   373	375	452	finally
    //   396	398	452	finally
    //   401	403	452	finally
    //   403	405	452	finally
    //   450	452	452	finally
    //   457	504	452	finally
    //   33	42	456	java/lang/Exception
    //   52	106	456	java/lang/Exception
    //   106	130	456	java/lang/Exception
    //   130	158	456	java/lang/Exception
    //   161	221	456	java/lang/Exception
    //   221	273	456	java/lang/Exception
    //   276	321	456	java/lang/Exception
    //   321	373	456	java/lang/Exception
    //   373	375	456	java/lang/Exception
    //   396	398	456	java/lang/Exception
    //   401	403	456	java/lang/Exception
    //   403	405	456	java/lang/Exception
    //   450	452	456	java/lang/Exception
    //   532	538	541	java/lang/InterruptedException
    //   506	530	563	finally
    //   530	532	563	finally
    //   564	566	563	finally
    //   570	594	598	finally
    //   594	596	598	finally
    //   599	601	598	finally
    //   23	33	603	finally
    //   604	606	603	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.Task
 * JD-Core Version:    0.7.0.1
 */