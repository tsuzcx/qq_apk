import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnSeekCompleteListener;
import android.os.Handler;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.runtime.widget.media.MiniAppAudioPlayer.2;
import com.tencent.qqmini.sdk.runtime.widget.media.MiniAppAudioPlayer.3;

public class bhkl
  implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private bhkn jdField_a_of_type_Bhkn;
  private bhko jdField_a_of_type_Bhko;
  private Runnable jdField_a_of_type_JavaLangRunnable = new MiniAppAudioPlayer.2(this);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private Runnable jdField_b_of_type_JavaLangRunnable = new MiniAppAudioPlayer.3(this);
  private volatile int c;
  
  public bhkl()
  {
    this(null);
  }
  
  public bhkl(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying()) {
        b();
      }
    }
    for (;;)
    {
      bgpo.a().a(new bhkm(this));
      return;
      f();
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    QMLog.d("MiniAppAudioPlayer", "notifyPlayerError.....what..." + paramInt1 + " extra..." + paramInt2);
    if (this.jdField_a_of_type_Bhkn != null)
    {
      this.jdField_a_of_type_Bhkn.onError(paramInt1, paramInt2);
      d(6);
    }
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_Bhkn != null) {
      this.jdField_a_of_type_Bhkn.onPlayerProgress(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, paramInt);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).muteAudioFocus(this.jdField_a_of_type_AndroidContentContext, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppAudioPlayer", "muteAudioFocus....." + localException);
    }
  }
  
  private void d(int paramInt)
  {
    try
    {
      this.jdField_b_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Bhkn != null) {
        this.jdField_a_of_type_Bhkn.onPlayerStateChange(paramInt);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnSeekCompleteListener(this);
    this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnBufferingUpdateListener(this);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppAudioPlayer", "resetMediaPlayer....." + localException);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void a()
  {
    c(false);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      d(3);
    }
  }
  
  public void a(float paramFloat)
  {
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      QMLog.i("MiniAppAudioPlayer", "setVolume:" + paramFloat);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setVolume(paramFloat, paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(bhkn parambhkn)
  {
    this.jdField_a_of_type_Bhkn = parambhkn;
  }
  
  public void a(String paramString, bhko parambhko)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bhko = parambhko;
    try
    {
      this.jdField_a_of_type_Int = 0;
      g();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      d(0);
      c(0);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return;
    }
    catch (Exception paramString)
    {
      g();
      a(1, 0);
      QMLog.e("MiniAppAudioPlayer", "setDataSource....." + paramString);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
      {
        boolean bool3 = this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniAppAudioPlayer", "mPlayer.isPlaying exception. " + localException);
    }
    return false;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      c(false);
      c(0);
      d(4);
    }
  }
  
  public void b(int paramInt)
  {
    int i = a();
    if ((this.jdField_a_of_type_AndroidMediaMediaPlayer != null) && (i > 0) && (i < 3) && (paramInt >= 0)) {
      try
      {
        if (this.jdField_a_of_type_Bhkn != null) {
          this.jdField_a_of_type_Bhkn.onPlayerSeek(false, paramInt);
        }
        this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
        return;
      }
      catch (Exception localException)
      {
        QMLog.e("MiniAppAudioPlayer", "seekTo....." + localException);
        return;
      }
    }
    this.c = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setLooping(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Int == 3;
  }
  
  public int c()
  {
    int j = 0;
    int i = j;
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      i = Math.max(this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition(), 0);
      return Math.min(i, this.jdField_a_of_type_Int);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.w("MiniAppAudioPlayer", "getCurrentPosition: failed", localException);
        i = j;
      }
    }
  }
  
  public void c()
  {
    c(false);
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
      c(0);
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Int == 1;
  }
  
  public void d()
  {
    if ((this.jdField_b_of_type_Int == 1) || (this.jdField_b_of_type_Int == 3)) {}
    try
    {
      ThreadManager.a(this.jdField_a_of_type_JavaLangRunnable, 16, null, false);
      c(this.jdField_a_of_type_Boolean);
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_b_of_type_JavaLangRunnable);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("MiniAppAudioPlayer", "resetMediaPlayer....." + localThrowable);
    }
  }
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    QMLog.d("MiniAppAudioPlayer", "onBufferingUpdate....." + paramInt);
    if (this.jdField_a_of_type_Bhkn != null) {
      this.jdField_a_of_type_Bhkn.onPlayerBufferingUpdate(paramInt);
    }
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QMLog.d("MiniAppAudioPlayer", "onCompletion.....");
    e();
    d(5);
    c(0);
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QMLog.d("MiniAppAudioPlayer", "onError.....what..." + paramInt1 + " extra..." + paramInt2);
    if (paramInt1 == 100)
    {
      if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
        this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      }
      f();
    }
    a(paramInt1, paramInt2);
    c(0);
    return true;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QMLog.d("MiniAppAudioPlayer", "onPrepared.....");
    d(1);
    if (this.jdField_a_of_type_Bhko != null) {
      this.jdField_a_of_type_Bhko.onPrepared();
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    for (int i = this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();; i = 0)
    {
      this.jdField_a_of_type_Int = Math.max(i, 0);
      return;
    }
  }
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    QMLog.d("MiniAppAudioPlayer", "onSeekComplete.....");
    if (this.jdField_a_of_type_Bhkn != null) {
      this.jdField_a_of_type_Bhkn.onPlayerSeek(true, c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhkl
 * JD-Core Version:    0.7.0.1
 */