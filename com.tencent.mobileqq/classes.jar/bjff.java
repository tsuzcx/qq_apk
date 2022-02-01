import android.graphics.SurfaceTexture;

class bjff
  implements bjfo
{
  bjff(bjfe parambjfe) {}
  
  public void a()
  {
    yqp.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    yqp.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (bjfe.a(this.a) == 0)
    {
      bjfg.a(this.a.hashCode(), "[Player] on video decode first frame");
      bjfe.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bjfe.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    yqp.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    bjfe.a(this.a);
  }
  
  public void b(long paramLong)
  {
    yqp.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    yqp.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    bjfe.a(this.a);
  }
  
  public void d()
  {
    yqp.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    bjfe.a(this.a);
    bjfe.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjff
 * JD-Core Version:    0.7.0.1
 */