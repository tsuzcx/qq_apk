import android.graphics.SurfaceTexture;

class bkgf
  implements bkgo
{
  bkgf(bkge parambkge) {}
  
  public void a()
  {
    yuk.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    yuk.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (bkge.a(this.a) == 0)
    {
      bkgg.a(this.a.hashCode(), "[Player] on video decode first frame");
      bkge.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bkge.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    yuk.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    bkge.a(this.a);
  }
  
  public void b(long paramLong)
  {
    yuk.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    yuk.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    bkge.a(this.a);
  }
  
  public void d()
  {
    yuk.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    bkge.a(this.a);
    bkge.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkgf
 * JD-Core Version:    0.7.0.1
 */