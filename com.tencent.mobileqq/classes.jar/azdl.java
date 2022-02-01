import android.content.Context;
import android.media.AudioRecord;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qassistant.audio.AudioNewRecorder.2;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public class azdl
{
  public static int a;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  private volatile AudioRecord jdField_a_of_type_AndroidMediaAudioRecord;
  private AcousticEchoCanceler jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler;
  private volatile azfz jdField_a_of_type_Azfz;
  public AtomicBoolean a;
  public AtomicLong a;
  private volatile int b;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public azdl()
  {
    this(1, 16000, 16, 2, 3200);
  }
  
  private azdl(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    if (paramInt5 == -1)
    {
      this.b = AudioRecord.getMinBufferSize(paramInt2, paramInt3, paramInt3);
      azeu.a("AudioNewRecorder", "AudioNewRecorder, inited bufferSizeInBytes:" + this.b);
      this.jdField_a_of_type_AndroidMediaAudioRecord = new AudioRecord(paramInt1, paramInt2, paramInt3, paramInt4, this.b);
      if (Build.VERSION.SDK_INT >= 16)
      {
        jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioRecord.getAudioSessionId();
        if (this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler != null)
        {
          azeu.a("AudioNewRecorder", "echo canceler not null, release it");
          this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler.release();
          this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler = null;
        }
        if (AcousticEchoCanceler.isAvailable())
        {
          azeu.a("AudioNewRecorder", "create echo canceler, set enable true, session id:" + jdField_a_of_type_Int);
          this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler = AcousticEchoCanceler.create(jdField_a_of_type_Int);
        }
        if (this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler == null) {
          break label218;
        }
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler.setEnabled(true);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
      return;
      this.b = paramInt5;
      break;
      label218:
      azeu.a("AudioNewRecorder", "echo canceler not available");
    }
  }
  
  public azdl(QQRecorder.RecorderParam paramRecorderParam)
  {
    this(7, 16000, 16, 2, 6400);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    byte[] arrayOfByte = new byte[this.b];
    System.currentTimeMillis();
    bftt.a(this.jdField_a_of_type_AndroidContentContext, true);
    double d = 0.0D;
    long l2 = 0L;
    while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
    {
      paramInt1 = this.jdField_a_of_type_AndroidMediaAudioRecord.read(arrayOfByte, 0, this.b);
      if (paramInt1 <= 0)
      {
        if (this.jdField_a_of_type_Azfz != null) {
          this.jdField_a_of_type_Azfz.a("readsize invalid...");
        }
        Thread.sleep(10L);
      }
      else
      {
        if (this.jdField_a_of_type_Azfz != null) {
          this.jdField_a_of_type_Azfz.a(arrayOfByte, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get());
        }
        l2 += 1L;
        l1 += paramInt1;
        d += QQRecorder.a(paramInt1, 16000);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(d);
      }
    }
    azeu.a("AudioNewRecorder", "record finished, slice index:" + l2 + ", total size:" + l1);
  }
  
  public void a()
  {
    azeu.a("AudioNewRecorder", "stop recorder...");
    try
    {
      if (this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler != null) {
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler.setEnabled(false);
      }
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
      }
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      azeu.a("AudioNewRecorder", localIllegalStateException.getMessage());
    }
  }
  
  public void a(int paramInt, QQRecorder.RecorderParam paramRecorderParam)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioRecord.getState() != 1)
    {
      if (this.jdField_a_of_type_Azfz != null) {
        this.jdField_a_of_type_Azfz.a("AudioRecorder init state failure");
      }
      return;
    }
    ThreadManagerV2.excute(new AudioNewRecorder.2(this), 16, null, false);
  }
  
  public void a(azfz paramazfz)
  {
    this.jdField_a_of_type_Azfz = paramazfz;
  }
  
  /* Error */
  public boolean a(azga paramazga)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 80	azdl:jdField_a_of_type_AndroidMediaAudioRecord	Landroid/media/AudioRecord;
    //   8: invokevirtual 192	android/media/AudioRecord:getState	()I
    //   11: istore_2
    //   12: iload_2
    //   13: iconst_1
    //   14: if_icmpne +7 -> 21
    //   17: aload_1
    //   18: ifnonnull +9 -> 27
    //   21: iconst_0
    //   22: istore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_3
    //   26: ireturn
    //   27: new 209	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1
    //   30: dup
    //   31: aload_0
    //   32: aload_1
    //   33: invokespecial 212	com/tencent/mobileqq/qassistant/audio/AudioNewRecorder$1:<init>	(Lazdl;Lazga;)V
    //   36: bipush 16
    //   38: aconst_null
    //   39: iconst_0
    //   40: invokestatic 205	com/tencent/mobileqq/app/ThreadManagerV2:excute	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   43: goto -20 -> 23
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	azdl
    //   0	51	1	paramazga	azga
    //   11	4	2	i	int
    //   1	25	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	12	46	finally
    //   27	43	46	finally
  }
  
  public void b()
  {
    azeu.a("AudioNewRecorder", "release recorder...");
    try
    {
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_AndroidMediaAudioRecord.stop();
      }
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_AndroidMediaAudioRecord.release();
      }
      if (this.jdField_a_of_type_AndroidMediaAudioRecord != null) {
        this.jdField_a_of_type_AndroidMediaAudioRecord = null;
      }
      if (this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler != null)
      {
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler.release();
        this.jdField_a_of_type_AndroidMediaAudiofxAcousticEchoCanceler = null;
      }
      return;
    }
    catch (Exception localException)
    {
      azeu.a("AudioNewRecorder", "release err:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdl
 * JD-Core Version:    0.7.0.1
 */