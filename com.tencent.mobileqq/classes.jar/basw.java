import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.SurfaceHolder;
import com.tencent.qphone.base.util.QLog;

public class basw
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, bass
{
  private int jdField_a_of_type_Int = 0;
  private MediaPlayer jdField_a_of_type_AndroidMediaMediaPlayer;
  private bast jdField_a_of_type_Bast;
  private basu jdField_a_of_type_Basu;
  private basv jdField_a_of_type_Basv;
  private int b;
  
  public basw()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer construct");
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "null";
    case 0: 
      return " idle ";
    case 1: 
      return " playing ";
    case 2: 
      return " pause ";
    }
    return " error ";
  }
  
  private void b(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer changePlayState " + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Basu != null) {
      this.jdField_a_of_type_Basu.a(this.jdField_a_of_type_Int);
    }
  }
  
  public int a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getPlayState " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.jdField_a_of_type_Int;
    }
    return 3;
  }
  
  public void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer start");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.start();
      b(1);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer seek to " + paramInt);
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {}
    try
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      QLog.e("LocalVideoMediaPlayer", 2, "mMediaPlayer seekTo " + paramInt + " IllegalStateException");
    }
  }
  
  public void a(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setDisplay ");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDisplay(paramSurfaceHolder);
    }
  }
  
  public void a(bast parambast)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setCompletionListener ");
    }
    this.jdField_a_of_type_Bast = parambast;
  }
  
  public void a(basu parambasu)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPlayStateListener ");
    }
    this.jdField_a_of_type_Basu = parambasu;
  }
  
  public void a(basv parambasv)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer setPreparedListener ");
    }
    this.jdField_a_of_type_Basv = parambasv;
  }
  
  public boolean a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer resume");
    }
    if (a() == 2) {
      a();
    }
    return a() == 1;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer play " + paramInt);
    }
    this.b = paramInt;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocalVideoMediaPlayer", 2, "#play#, msec=" + paramInt);
      }
      c();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = new MediaPlayer();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setAudioStreamType(3);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setOnPreparedListener(this);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.setDataSource(paramString);
      this.jdField_a_of_type_AndroidMediaMediaPlayer.prepareAsync();
      return true;
    }
    catch (Exception paramString)
    {
      QLog.e("LocalVideoMediaPlayer", 2, "#play#, msec=" + paramInt, paramString);
      d();
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition " + this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getCurrentPosition();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getCurrentPosition -1");
    }
    return -1;
  }
  
  public void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer pause");
    }
    if (b())
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.pause();
      b(2);
    }
  }
  
  public boolean b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer isPlaying ");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null) {
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.isPlaying();
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration " + this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getDuration();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getDuration -1");
    }
    return -1;
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer release");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.stop();
      this.jdField_a_of_type_AndroidMediaMediaPlayer.release();
      this.jdField_a_of_type_AndroidMediaMediaPlayer = null;
    }
    b(0);
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth " + this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoWidth();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoWidth -1");
    }
    return -1;
  }
  
  public void d()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer reset ");
    }
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      this.jdField_a_of_type_AndroidMediaMediaPlayer.reset();
      b(0);
    }
  }
  
  public int e()
  {
    if (this.jdField_a_of_type_AndroidMediaMediaPlayer != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight " + this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight());
      }
      return this.jdField_a_of_type_AndroidMediaMediaPlayer.getVideoHeight();
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer getVideoHeight -1");
    }
    return -1;
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onCompletion ");
    }
    b(0);
    if (this.jdField_a_of_type_Bast != null) {
      this.jdField_a_of_type_Bast.a(this);
    }
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("LocalVideoMediaPlayer", 2, "mMediaPlayer onError what=" + paramInt1 + ",extra=" + paramInt2);
    b(3);
    d();
    return false;
  }
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("LocalVideoMediaPlayer", 2, "LocalVideoMediaPlayer onPrepared ");
    }
    if (this.jdField_a_of_type_Basv != null) {
      this.jdField_a_of_type_Basv.a(this);
    }
    a();
    if (this.b > 0) {
      a(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     basw
 * JD-Core Version:    0.7.0.1
 */