import android.os.Handler;
import android.support.annotation.RequiresApi;
import com.tencent.biz.qqstory.takevideo.slideshow.Image2Video.EglHandlerThreadEx;
import com.tencent.mobileqq.identification.ConvertRunnable;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nonnull;

@RequiresApi(api=18)
public class aqiu
  implements aqic
{
  private Image2Video.EglHandlerThreadEx jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  private AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private vgr jdField_a_of_type_Vgr;
  
  public aqiu()
  {
    a();
  }
  
  public vgv a(byte[][] paramArrayOfByte, int paramInt1, int paramInt2, String paramString, @Nonnull vgr paramvgr)
  {
    this.jdField_a_of_type_Vgr = paramvgr;
    vgv localvgv = new vgv();
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return localvgv;
    }
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    localvgv.jdField_a_of_type_Long = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.addAndGet(1L);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("identification_yuv", 2, "thread not init");
      }
      localvgv.jdField_a_of_type_Int = 3;
      paramvgr.a(localvgv);
      return localvgv;
    }
    localvgv.jdField_a_of_type_Int = 1;
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx != null)
      {
        paramArrayOfByte = new ConvertRunnable(paramArrayOfByte, localvgv.jdField_a_of_type_Long, paramInt1, paramInt2, paramString, this);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx.a().post(paramArrayOfByte);
        if (QLog.isColorLevel()) {
          QLog.d("identification_yuv", 2, "start end, add to runlist taskId:" + localvgv.jdField_a_of_type_Long);
        }
      }
      return localvgv;
    }
    finally {}
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("identification_yuv", 2, "uninit..");
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx != null)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx.quitSafely();
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(vgv paramvgv)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_a_of_type_Vgr != null) {
      this.jdField_a_of_type_Vgr.a(paramvgv);
    }
  }
  
  /* Error */
  public boolean a()
  {
    // Byte code:
    //   0: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 65
    //   8: iconst_2
    //   9: ldc 121
    //   11: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: aload_0
    //   15: invokevirtual 123	aqiu:a	()V
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: new 86	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx
    //   24: dup
    //   25: ldc 125
    //   27: aconst_null
    //   28: aload_0
    //   29: invokespecial 128	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx:<init>	(Ljava/lang/String;Landroid/opengl/EGLContext;Ljava/lang/Object;)V
    //   32: putfield 58	aqiu:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx;
    //   35: aload_0
    //   36: getfield 58	aqiu:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx;
    //   39: invokevirtual 131	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx:start	()V
    //   42: aload_0
    //   43: getfield 58	aqiu:jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowImage2Video$EglHandlerThreadEx	Lcom/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx;
    //   46: invokevirtual 132	com/tencent/biz/qqstory/takevideo/slideshow/Image2Video$EglHandlerThreadEx:a	()Z
    //   49: istore_1
    //   50: iload_1
    //   51: ifne +10 -> 61
    //   54: aload_0
    //   55: ldc2_w 133
    //   58: invokevirtual 137	java/lang/Object:wait	(J)V
    //   61: aload_0
    //   62: monitorexit
    //   63: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +11 -> 77
    //   69: ldc 65
    //   71: iconst_2
    //   72: ldc 139
    //   74: invokestatic 71	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: iconst_1
    //   78: ireturn
    //   79: astore_2
    //   80: ldc 65
    //   82: iconst_1
    //   83: aload_2
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 143	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   91: goto -30 -> 61
    //   94: astore_2
    //   95: aload_0
    //   96: monitorexit
    //   97: aload_2
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	aqiu
    //   49	2	1	bool	boolean
    //   79	5	2	localInterruptedException	java.lang.InterruptedException
    //   94	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   54	61	79	java/lang/InterruptedException
    //   20	50	94	finally
    //   54	61	94	finally
    //   61	63	94	finally
    //   80	91	94	finally
    //   95	97	94	finally
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqiu
 * JD-Core Version:    0.7.0.1
 */