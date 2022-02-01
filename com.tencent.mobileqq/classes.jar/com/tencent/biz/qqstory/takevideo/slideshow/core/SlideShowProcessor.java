package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class SlideShowProcessor
{
  public static final String a;
  public static final String b;
  private SlideShowProcessor.EglHandlerThreadEx c;
  private boolean d = true;
  private AtomicLong e = new AtomicLong(0L);
  private SlideShowProcessor.Task f;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Environment.getExternalStorageDirectory().getAbsolutePath());
    localStringBuilder.append("/Android/data/com.tencent.mobileqq/qq/video/imagevideo/");
    a = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append("cache/");
    b = localStringBuilder.toString();
  }
  
  public static File[] c(String paramString)
  {
    paramString = new File(paramString).listFiles(new SlideShowProcessor.1());
    if (paramString != null) {
      Arrays.sort(paramString, new SlideShowProcessor.2());
    }
    return paramString;
  }
  
  public static void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "clearCache start");
    }
    File[] arrayOfFile = c(b);
    int j = 100;
    if ((arrayOfFile != null) && (arrayOfFile.length > 100))
    {
      int i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("SlideShowProcessor", 2, "clear cache delete file over 100");
        i = j;
      }
      while (i < arrayOfFile.length)
      {
        FileUtil.a(arrayOfFile[i]);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(arrayOfFile[i]);
        localStringBuilder.append(".dat");
        FileUtil.e(localStringBuilder.toString());
        i += 1;
      }
    }
  }
  
  public ResultInfo a(SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, SlideShowProcessor.SlideShowProcessListener paramSlideShowProcessListener)
  {
    ResultInfo localResultInfo = new ResultInfo();
    localResultInfo.a = this.e.addAndGet(1L);
    localResultInfo.c = paramSlideItemInfo.f;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start, taskId:");
      localStringBuilder.append(localResultInfo.a);
      localStringBuilder.append(", image:");
      localStringBuilder.append(paramSlideItemInfo.f);
      localStringBuilder.append(", widht:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" height:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" duration:");
      localStringBuilder.append(paramLong);
      QLog.d("SlideShowProcessor", 2, localStringBuilder.toString());
    }
    if (this.c == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessor", 2, "thread not init");
      }
      localResultInfo.b = 3;
      if (paramSlideShowProcessListener != null) {
        paramSlideShowProcessListener.a(localResultInfo);
      }
      return localResultInfo;
    }
    if (TextUtils.isEmpty(paramSlideItemInfo.f))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessor", 2, "strImage == null");
      }
      localResultInfo.b = 4;
      if (paramSlideShowProcessListener != null) {
        paramSlideShowProcessListener.a(localResultInfo);
      }
      return localResultInfo;
    }
    localResultInfo.b = 1;
    paramSlideItemInfo = new SlideShowProcessor.ConvertContext(localResultInfo.a, paramSlideItemInfo, paramInt1, paramInt2, paramLong, paramSlideShowProcessListener, paramBoolean);
    this.f.a(paramSlideItemInfo);
    return localResultInfo;
  }
  
  public void a(SlideItemInfo paramSlideItemInfo, SlideShowProcessor.SlideShowProcessListener paramSlideShowProcessListener)
  {
    a(paramSlideItemInfo, 720, 1280, 2000L, this.d, paramSlideShowProcessListener);
  }
  
  public void a(String paramString)
  {
    this.f.b(paramString);
  }
  
  public void a(List<SlideItemInfo> paramList, VideoMerger.VideoMergeListener paramVideoMergeListener, Activity paramActivity, Handler paramHandler, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      VideoMerger.MergeContext localMergeContext = new VideoMerger.MergeContext();
      localMergeContext.a = paramList;
      localMergeContext.b = paramVideoMergeListener;
      localMergeContext.c = paramActivity;
      localMergeContext.d = paramHandler;
      localMergeContext.e = paramInt1;
      localMergeContext.f = paramInt2;
      localMergeContext.g = paramString;
      this.f.a(localMergeContext);
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 88
    //   8: iconst_2
    //   9: ldc 217
    //   11: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: getstatic 222	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 18
    //   19: if_icmpge +13 -> 32
    //   22: ldc 88
    //   24: iconst_2
    //   25: ldc 224
    //   27: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 226	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:b	()V
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: new 228	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx
    //   42: dup
    //   43: ldc 230
    //   45: aconst_null
    //   46: aload_0
    //   47: invokespecial 233	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   50: putfield 145	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   53: aload_0
    //   54: new 172	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task
    //   57: dup
    //   58: invokespecial 234	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:<init>	()V
    //   61: putfield 170	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:f	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task;
    //   64: aload_0
    //   65: getfield 145	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   68: invokevirtual 237	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:start	()V
    //   71: aload_0
    //   72: getfield 145	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   75: invokevirtual 239	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:a	()Z
    //   78: istore_1
    //   79: iload_1
    //   80: ifne +10 -> 90
    //   83: aload_0
    //   84: ldc2_w 240
    //   87: invokevirtual 244	java/lang/Object:wait	(J)V
    //   90: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq +59 -> 152
    //   96: new 19	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 22	java/lang/StringBuilder:<init>	()V
    //   103: astore_2
    //   104: aload_2
    //   105: ldc 246
    //   107: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload_2
    //   112: aload_0
    //   113: getfield 145	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   116: invokevirtual 239	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:a	()Z
    //   119: invokevirtual 249	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload_2
    //   124: ldc 251
    //   126: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: aload_0
    //   132: getfield 145	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   135: invokevirtual 254	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:b	()Landroid/os/Handler;
    //   138: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 88
    //   144: iconst_2
    //   145: aload_2
    //   146: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: aload_0
    //   153: getfield 145	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   156: invokevirtual 254	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:b	()Landroid/os/Handler;
    //   159: ifnull +18 -> 177
    //   162: aload_0
    //   163: getfield 145	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:c	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   166: invokevirtual 254	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:b	()Landroid/os/Handler;
    //   169: aload_0
    //   170: getfield 170	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:f	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task;
    //   173: invokevirtual 260	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   176: pop
    //   177: aload_0
    //   178: monitorexit
    //   179: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +12 -> 194
    //   185: ldc 88
    //   187: iconst_2
    //   188: ldc_w 262
    //   191: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: iconst_1
    //   195: ireturn
    //   196: astore_2
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_2
    //   200: athrow
    //   201: astore_2
    //   202: goto -112 -> 90
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	SlideShowProcessor
    //   78	2	1	bool	boolean
    //   103	43	2	localStringBuilder	StringBuilder
    //   196	4	2	localObject	Object
    //   201	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   38	79	196	finally
    //   83	90	196	finally
    //   90	152	196	finally
    //   152	177	196	finally
    //   177	179	196	finally
    //   197	199	196	finally
    //   83	90	201	java/lang/InterruptedException
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "uninit..");
    }
    try
    {
      if (this.c != null)
      {
        this.c.quitSafely();
        this.c = null;
      }
      return;
    }
    finally {}
  }
  
  public boolean b(String paramString)
  {
    return this.f.a(paramString);
  }
  
  public void c()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stopALl , ");
      localStringBuilder.append(ThrowablesUtils.a(new Throwable()));
      QLog.d("SlideShowProcessor", 2, localStringBuilder.toString());
    }
    this.f.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor
 * JD-Core Version:    0.7.0.1
 */