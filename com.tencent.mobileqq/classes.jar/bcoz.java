import android.graphics.SurfaceTexture;

class bcoz
  implements bcpi
{
  bcoz(bcoy parambcoy) {}
  
  public void a()
  {
    urk.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    urk.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (bcoy.a(this.a) == 0)
    {
      bcpa.a(this.a.hashCode(), "[Player] on video decode first frame");
      bcoy.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bcoy.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    urk.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    bcoy.a(this.a);
  }
  
  public void b(long paramLong)
  {
    urk.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    urk.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    bcoy.a(this.a);
  }
  
  public void d()
  {
    urk.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    bcoy.a(this.a);
    bcoy.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcoz
 * JD-Core Version:    0.7.0.1
 */