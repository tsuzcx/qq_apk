package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.app.Activity;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import apvd;
import bfnu;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import vto;
import vul;
import vum;
import vun;
import vuo;
import vus;
import vut;

public class SlideShowProcessor
{
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "cache/";
  private SlideShowProcessor.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx;
  private SlideShowProcessor.Task jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task;
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangString = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.tencent.mobileqq/qq/video/imagevideo/";
  }
  
  private void a(List<SlideItemInfo> paramList, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, vuo paramvuo)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label281;
      }
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if (localSlideItemInfo != null)
      {
        vto localvto = new vto();
        localvto.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.addAndGet(1L);
        localvto.jdField_a_of_type_JavaLangString = localSlideItemInfo.b;
        if (QLog.isColorLevel()) {
          QLog.d("SlideShowProcessor", 2, "start, taskId:" + localvto.jdField_a_of_type_Long + ", image:" + localSlideItemInfo.b + ", widht:" + paramInt1 + " height:" + paramInt2 + " duration:" + paramLong);
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "thread not init");
          }
          localvto.jdField_a_of_type_Int = 3;
          if (paramvuo == null) {
            break;
          }
          paramvuo.a(localvto);
          return;
        }
        if (TextUtils.isEmpty(localSlideItemInfo.b))
        {
          if (QLog.isColorLevel()) {
            QLog.d("SlideShowProcessor", 2, "strImage == null");
          }
          localvto.jdField_a_of_type_Int = 4;
          if (paramvuo == null) {
            break;
          }
          paramvuo.a(localvto);
          return;
        }
        localvto.jdField_a_of_type_Int = 1;
        localArrayList.add(new vun(localvto.jdField_a_of_type_Long, localSlideItemInfo, paramInt1, paramInt2, paramLong, paramvuo, paramBoolean));
      }
    }
    label281:
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a(localArrayList);
  }
  
  public static File[] a(String paramString)
  {
    paramString = new File(paramString).listFiles(new vul());
    if (paramString != null) {
      Arrays.sort(paramString, new vum());
    }
    return paramString;
  }
  
  public static void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "clearCache start");
    }
    File[] arrayOfFile = a(b);
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
        apvd.a(arrayOfFile[i]);
        apvd.c(arrayOfFile[i] + ".dat");
        i += 1;
      }
    }
  }
  
  public vto a(SlideItemInfo paramSlideItemInfo, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, vuo paramvuo)
  {
    vto localvto = new vto();
    localvto.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.addAndGet(1L);
    localvto.jdField_a_of_type_JavaLangString = paramSlideItemInfo.b;
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "start, taskId:" + localvto.jdField_a_of_type_Long + ", image:" + paramSlideItemInfo.b + ", widht:" + paramInt1 + " height:" + paramInt2 + " duration:" + paramLong);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessor", 2, "thread not init");
      }
      localvto.jdField_a_of_type_Int = 3;
      if (paramvuo != null) {
        paramvuo.a(localvto);
      }
      return localvto;
    }
    if (TextUtils.isEmpty(paramSlideItemInfo.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SlideShowProcessor", 2, "strImage == null");
      }
      localvto.jdField_a_of_type_Int = 4;
      if (paramvuo != null) {
        paramvuo.a(localvto);
      }
      return localvto;
    }
    localvto.jdField_a_of_type_Int = 1;
    paramSlideItemInfo = new vun(localvto.jdField_a_of_type_Long, paramSlideItemInfo, paramInt1, paramInt2, paramLong, paramvuo, paramBoolean);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a(paramSlideItemInfo);
    return localvto;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "uninit..");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx.quitSafely();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(SlideItemInfo paramSlideItemInfo, vuo paramvuo)
  {
    if (paramvuo == null) {}
    a(paramSlideItemInfo, 720, 1280, 2000L, this.jdField_a_of_type_Boolean, paramvuo);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a(paramString);
  }
  
  public void a(List<SlideItemInfo> paramList, vuo paramvuo)
  {
    if (paramvuo == null) {}
    a(paramList, 720, 1280, 2000L, this.jdField_a_of_type_Boolean, paramvuo);
  }
  
  public void a(List<SlideItemInfo> paramList, vut paramvut, Activity paramActivity, Handler paramHandler, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      vus localvus = new vus();
      localvus.jdField_a_of_type_JavaUtilList = paramList;
      localvus.jdField_a_of_type_Vut = paramvut;
      localvus.jdField_a_of_type_AndroidAppActivity = paramActivity;
      localvus.jdField_a_of_type_AndroidOsHandler = paramHandler;
      localvus.jdField_a_of_type_Int = paramInt1;
      localvus.b = paramInt2;
      localvus.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a(localvus);
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 97
    //   8: iconst_2
    //   9: ldc 246
    //   11: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: getstatic 251	android/os/Build$VERSION:SDK_INT	I
    //   17: bipush 18
    //   19: if_icmpge +13 -> 32
    //   22: ldc 97
    //   24: iconst_2
    //   25: ldc 253
    //   27: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   30: iconst_0
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 255	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:a	()V
    //   36: aload_0
    //   37: monitorenter
    //   38: aload_0
    //   39: new 203	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx
    //   42: dup
    //   43: ldc_w 257
    //   46: aconst_null
    //   47: aload_0
    //   48: invokespecial 260	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   51: putfield 119	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   54: aload_0
    //   55: new 150	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task
    //   58: dup
    //   59: invokespecial 261	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task:<init>	()V
    //   62: putfield 148	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task;
    //   65: aload_0
    //   66: getfield 119	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   69: invokevirtual 264	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:start	()V
    //   72: aload_0
    //   73: getfield 119	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   76: invokevirtual 266	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:a	()Z
    //   79: istore_1
    //   80: iload_1
    //   81: ifne +10 -> 91
    //   84: aload_0
    //   85: ldc2_w 267
    //   88: invokevirtual 271	java/lang/Object:wait	(J)V
    //   91: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +51 -> 145
    //   97: ldc 97
    //   99: iconst_2
    //   100: new 15	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 18	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 273
    //   110: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 119	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   117: invokevirtual 266	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:a	()Z
    //   120: invokevirtual 276	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: ldc_w 278
    //   126: invokevirtual 34	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 119	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   133: invokevirtual 281	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:a	()Landroid/os/Handler;
    //   136: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 39	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload_0
    //   146: getfield 119	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   149: invokevirtual 281	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:a	()Landroid/os/Handler;
    //   152: ifnull +18 -> 170
    //   155: aload_0
    //   156: getfield 119	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx;
    //   159: invokevirtual 281	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$EglHandlerThreadEx:a	()Landroid/os/Handler;
    //   162: aload_0
    //   163: getfield 148	com/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task	Lcom/tencent/biz/qqstory/takevideo/slideshow/core/SlideShowProcessor$Task;
    //   166: invokevirtual 287	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   169: pop
    //   170: aload_0
    //   171: monitorexit
    //   172: invokestatic 95	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 97
    //   180: iconst_2
    //   181: ldc_w 289
    //   184: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_1
    //   188: ireturn
    //   189: astore_2
    //   190: aload_0
    //   191: monitorexit
    //   192: aload_2
    //   193: athrow
    //   194: astore_2
    //   195: goto -104 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	198	0	this	SlideShowProcessor
    //   79	2	1	bool	boolean
    //   189	4	2	localObject	Object
    //   194	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   38	80	189	finally
    //   84	91	189	finally
    //   91	145	189	finally
    //   145	170	189	finally
    //   170	172	189	finally
    //   190	192	189	finally
    //   84	91	194	java/lang/InterruptedException
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowProcessor", 2, "stopALl , " + bfnu.a(new Throwable()));
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$Task.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor
 * JD-Core Version:    0.7.0.1
 */