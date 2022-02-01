package com.tencent.aelight.camera.ae.camera.testpkg;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

@TargetApi(16)
public class VideoDecodeHardWare
{
  private MediaExtractor a;
  private MediaCodec b;
  private boolean c;
  private VideoCameraProxy.IDecodeListener d;
  private Handler e;
  private Runnable f = new VideoDecodeHardWare.1(this);
  
  void a()
  {
    HandlerThread localHandlerThread = new HandlerThread("testDecode");
    localHandlerThread.start();
    this.e = new Handler(localHandlerThread.getLooper());
  }
  
  public void a(VideoCameraProxy.IDecodeListener paramIDecodeListener)
  {
    this.d = paramIDecodeListener;
  }
  
  public boolean a(Surface paramSurface, String paramString)
  {
    this.c = false;
    try
    {
      this.a = new MediaExtractor();
      this.a.setDataSource(paramString);
      paramString = new StringBuilder();
      paramString.append("getTrackCount: ");
      paramString.append(this.a.getTrackCount());
      QLog.i("VideoDecoder", 4, paramString.toString());
      int i = 0;
      while (i < this.a.getTrackCount())
      {
        Object localObject = this.a.getTrackFormat(i);
        paramString = ((MediaFormat)localObject).getString("mime");
        if (paramString.startsWith("video/"))
        {
          this.a.selectTrack(i);
          this.b = MediaCodec.createDecoderByType(paramString);
          try
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("format : ");
            localStringBuilder.append(localObject);
            QLog.i("VideoDecoder", 4, localStringBuilder.toString());
            this.b.configure((MediaFormat)localObject, paramSurface, null, 0);
            this.b.start();
            a();
          }
          catch (IllegalStateException paramSurface)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("codec '");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append("' failed configuration. ");
            ((StringBuilder)localObject).append(paramSurface);
            QLog.i("VideoDecoder", 4, ((StringBuilder)localObject).toString());
            return false;
          }
        }
        i += 1;
      }
      return true;
    }
    catch (IOException paramSurface)
    {
      paramSurface.printStackTrace();
    }
  }
  
  public void b()
  {
    Handler localHandler = this.e;
    if (localHandler == null) {
      return;
    }
    localHandler.post(this.f);
  }
  
  public void c()
  {
    b();
  }
  
  /* Error */
  @TargetApi(18)
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 34	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:c	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: iconst_1
    //   10: putfield 34	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:c	Z
    //   13: aload_0
    //   14: getfield 64	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:e	Landroid/os/Handler;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +4 -> 23
    //   22: return
    //   23: aload_1
    //   24: new 164	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare$2
    //   27: dup
    //   28: aload_0
    //   29: invokespecial 165	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare$2:<init>	(Lcom/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare;)V
    //   32: invokevirtual 157	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   35: pop
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 34	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:c	Z
    //   41: ldc 94
    //   43: iconst_4
    //   44: ldc 167
    //   46: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 64	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:e	Landroid/os/Handler;
    //   53: invokevirtual 170	android/os/Handler:getLooper	()Landroid/os/Looper;
    //   56: invokevirtual 175	android/os/Looper:quitSafely	()V
    //   59: aload_0
    //   60: getfield 37	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:b	Landroid/media/MediaCodec;
    //   63: invokevirtual 178	android/media/MediaCodec:flush	()V
    //   66: aload_0
    //   67: getfield 37	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:b	Landroid/media/MediaCodec;
    //   70: invokevirtual 181	android/media/MediaCodec:stop	()V
    //   73: aload_0
    //   74: getfield 37	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:b	Landroid/media/MediaCodec;
    //   77: invokevirtual 184	android/media/MediaCodec:release	()V
    //   80: goto +42 -> 122
    //   83: astore_1
    //   84: goto +54 -> 138
    //   87: astore_1
    //   88: new 78	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   95: astore_2
    //   96: aload_2
    //   97: ldc 186
    //   99: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_2
    //   104: aload_1
    //   105: invokevirtual 189	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   108: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: ldc 94
    //   114: iconst_4
    //   115: aload_2
    //   116: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_0
    //   123: getfield 40	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:a	Landroid/media/MediaExtractor;
    //   126: invokevirtual 190	android/media/MediaExtractor:release	()V
    //   129: ldc 94
    //   131: iconst_4
    //   132: ldc 192
    //   134: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: return
    //   138: aload_0
    //   139: getfield 40	com/tencent/aelight/camera/ae/camera/testpkg/VideoDecodeHardWare:a	Landroid/media/MediaExtractor;
    //   142: invokevirtual 190	android/media/MediaExtractor:release	()V
    //   145: ldc 94
    //   147: iconst_4
    //   148: ldc 192
    //   150: invokestatic 169	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   153: aload_1
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	VideoDecodeHardWare
    //   17	7	1	localHandler	Handler
    //   83	1	1	localObject	Object
    //   87	67	1	localException	java.lang.Exception
    //   95	21	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   41	80	83	finally
    //   88	122	83	finally
    //   41	80	87	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.testpkg.VideoDecodeHardWare
 * JD-Core Version:    0.7.0.1
 */