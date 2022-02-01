package com.tencent.mobileqq.activity.aio;

import afpw;
import afpx;
import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import bahv;
import bahw;
import bhck;
import bhcl;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;

public abstract class AudioPlayerBase
  implements bahw, Runnable
{
  public static int a;
  public static final List<Integer> a;
  public static boolean a;
  public static int b;
  public static volatile boolean b;
  public static boolean c;
  protected float a;
  protected long a;
  public afpx a;
  protected Application a;
  public AudioManager a;
  public Handler a;
  public bahv a;
  public volatile bhck a;
  protected String a;
  protected Timer a;
  protected volatile int c;
  public volatile int d;
  protected boolean d;
  
  static
  {
    jdField_a_of_type_Int = -999;
    jdField_a_of_type_Boolean = true;
    jdField_b_of_type_Int = -1;
    jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1796) });
  }
  
  public AudioPlayerBase(Context paramContext, afpx paramafpx)
  {
    this.jdField_a_of_type_Float = MediaPlayerManager.jdField_a_of_type_Float;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidOsHandler = new afpw(this);
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_Afpx = paramafpx;
  }
  
  @TargetApi(14)
  public static boolean a(AudioManager paramAudioManager)
  {
    if (!jdField_a_of_type_Boolean) {}
    BluetoothAdapter localBluetoothAdapter;
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 14);
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    } while ((localBluetoothAdapter == null) || (!localBluetoothAdapter.isEnabled()) || (localBluetoothAdapter.getProfileConnectionState(1) != 2) || (localBluetoothAdapter.getProfileConnectionState(2) == 2) || (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(jdField_b_of_type_Int))) || (jdField_b_of_type_Boolean) || (paramAudioManager.isBluetoothScoOn()) || (!paramAudioManager.isBluetoothScoAvailableOffCall()));
    return true;
  }
  
  public AudioManager a()
  {
    return this.jdField_a_of_type_AndroidMediaAudioManager;
  }
  
  public bahv a()
  {
    return this.jdField_a_of_type_Bahv;
  }
  
  protected abstract bhck a();
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    c();
    if (this.jdField_a_of_type_Afpx != null) {
      this.jdField_a_of_type_Afpx.a(this);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Afpx != null) {}
    try
    {
      this.jdField_a_of_type_Afpx.d(this, c());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, "startProgressTimer e= " + localException);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(bahv parambahv, int paramInt1, int paramInt2)
  {
    c();
    QLog.e("AudioPlayer", 2, "onError: " + paramInt1);
    if (this.jdField_a_of_type_Afpx != null) {
      this.jdField_a_of_type_Afpx.a(this, -2);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = -1;
    if (paramBoolean2)
    {
      if (paramBoolean1) {
        i = 0;
      }
      AudioPlayer.jdField_b_of_type_Int = i;
      AudioPlayer.jdField_b_of_type_Boolean = false;
      return;
    }
    if (paramBoolean1) {}
    for (;;)
    {
      AudioPlayer.jdField_b_of_type_Int = i;
      break;
      i = 0;
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Bahv != null) && (this.jdField_a_of_type_Bahv.a());
  }
  
  public boolean a(String paramString)
  {
    return a(paramString, 0);
  }
  
  protected abstract boolean a(String paramString, int paramInt);
  
  public int b()
  {
    if (this.jdField_a_of_type_Bahv == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bahv.b();
  }
  
  public abstract void b();
  
  public void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (QLog.isColorLevel()) {
      QLog.i("AudioPlayer", 2, "setPlaySpeed: " + paramFloat);
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public boolean b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "seekPlay ", new Exception());
    }
    return a(paramString, paramInt);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Bahv == null) {
      return 0;
    }
    return this.jdField_a_of_type_Bahv.a();
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 71	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   6: sipush 1000
    //   9: invokevirtual 226	android/os/Handler:removeMessages	(I)V
    //   12: aload_0
    //   13: invokevirtual 228	com/tencent/mobileqq/activity/aio/AudioPlayerBase:e	()V
    //   16: aload_0
    //   17: getfield 135	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Bahv	Lbahv;
    //   20: ifnull +84 -> 104
    //   23: aload_0
    //   24: getfield 135	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Bahv	Lbahv;
    //   27: invokeinterface 198 1 0
    //   32: ifeq +12 -> 44
    //   35: aload_0
    //   36: getfield 135	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Bahv	Lbahv;
    //   39: invokeinterface 229 1 0
    //   44: aload_0
    //   45: getfield 135	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Bahv	Lbahv;
    //   48: invokeinterface 231 1 0
    //   53: aload_0
    //   54: getfield 135	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Bahv	Lbahv;
    //   57: invokeinterface 232 1 0
    //   62: aload_0
    //   63: getstatic 57	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_Float	F
    //   66: putfield 58	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Float	F
    //   69: aload_0
    //   70: ldc2_w 59
    //   73: putfield 62	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Long	J
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 139	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 135	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Bahv	Lbahv;
    //   86: aload_0
    //   87: getstatic 30	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Int	I
    //   90: putfield 64	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_c_of_type_Int	I
    //   93: aload_0
    //   94: bipush 8
    //   96: aconst_null
    //   97: iconst_0
    //   98: invokestatic 238	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    //   104: invokestatic 243	awel:a	()Lawel;
    //   107: invokevirtual 244	awel:a	()Z
    //   110: ifeq -9 -> 101
    //   113: aload_0
    //   114: getstatic 30	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_a_of_type_Int	I
    //   117: putfield 64	com/tencent/mobileqq/activity/aio/AudioPlayerBase:jdField_c_of_type_Int	I
    //   120: aload_0
    //   121: bipush 8
    //   123: aconst_null
    //   124: iconst_0
    //   125: invokestatic 238	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   128: goto -27 -> 101
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	AudioPlayerBase
    //   131	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	131	finally
    //   44	101	131	finally
    //   104	128	131	finally
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "replay ", new Exception());
    }
    if (this.jdField_a_of_type_JavaLangString != null) {
      a(this.jdField_a_of_type_JavaLangString, paramInt);
    }
  }
  
  protected void d()
  {
    if ((this.jdField_a_of_type_Bahv instanceof AmrPlayer))
    {
      e();
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new AudioPlayerBase.2(this), 0L, 100L);
    }
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
  }
  
  public void f()
  {
    i = 1;
    this.jdField_d_of_type_Boolean = this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
    this.jdField_a_of_type_Bhck = a();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_a_of_type_Bhck.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_a_of_type_Bhck.jdField_a_of_type_Boolean);
    if (this.jdField_c_of_type_Int != jdField_a_of_type_Int) {
      this.jdField_a_of_type_Bhck.jdField_b_of_type_Int = this.jdField_c_of_type_Int;
    }
    if (this.jdField_a_of_type_Afpx != null) {
      this.jdField_a_of_type_Afpx.b(this, this.jdField_a_of_type_Bhck.jdField_b_of_type_Int);
    }
    bhcl.a(this.jdField_a_of_type_AndroidAppApplication, true);
    if (this.jdField_a_of_type_Bahv != null) {
      this.jdField_a_of_type_Bahv.a(this.jdField_a_of_type_Bhck.jdField_b_of_type_Int);
    }
    try
    {
      this.jdField_a_of_type_Bahv.g();
      i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.jdField_a_of_type_Bhck.jdField_b_of_type_Int);
      int j = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.jdField_a_of_type_Bhck.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "currentVolume=" + i + " maxVolume=" + j);
      }
      if (i / j >= 0.18F) {
        break label326;
      }
      this.jdField_d_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.e("AudioPlayer", 2, "mPlayer.prepare error", localThrowable);
        if ((this.jdField_a_of_type_Bahv instanceof SilkPlayer)) {}
        for (;;)
        {
          AudioPlayer.a(0, i, 3, localThrowable.toString());
          return;
          i = 0;
        }
        this.jdField_d_of_type_Int = 1;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        continue;
        i = 0;
      }
    }
    if (this.jdField_a_of_type_Afpx != null) {
      this.jdField_a_of_type_Afpx.c(this, this.jdField_d_of_type_Int);
    }
    if ((this.jdField_a_of_type_Bahv instanceof SilkPlayer))
    {
      i = 1;
      AudioPlayer.a(1, i, 0, "");
      d();
      return;
    }
  }
  
  protected void g()
  {
    if (this.jdField_a_of_type_Bahv != null)
    {
      if (this.jdField_a_of_type_Bahv.a()) {
        this.jdField_a_of_type_Bahv.c();
      }
      this.jdField_a_of_type_Bahv.d();
      this.jdField_a_of_type_Bahv.e();
      this.jdField_a_of_type_Bahv = null;
    }
  }
  
  public void h() {}
  
  public void i() {}
  
  public void j()
  {
    if ((jdField_c_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      jdField_c_of_type_Boolean = false;
    }
  }
  
  public void k()
  {
    j();
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_d_of_type_Boolean);
      bhcl.a(this.jdField_a_of_type_AndroidAppApplication, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayerBase
 * JD-Core Version:    0.7.0.1
 */