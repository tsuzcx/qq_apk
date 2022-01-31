import android.graphics.SurfaceTexture;

class bdtr
  implements bdua
{
  bdtr(bdtq parambdtq) {}
  
  public void a()
  {
    ved.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    ved.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (bdtq.a(this.a) == 0)
    {
      bdts.a(this.a.hashCode(), "[Player] on video decode first frame");
      bdtq.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bdtq.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    ved.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    bdtq.a(this.a);
  }
  
  public void b(long paramLong)
  {
    ved.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    ved.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    bdtq.a(this.a);
  }
  
  public void d()
  {
    ved.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    bdtq.a(this.a);
    bdtq.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdtr
 * JD-Core Version:    0.7.0.1
 */