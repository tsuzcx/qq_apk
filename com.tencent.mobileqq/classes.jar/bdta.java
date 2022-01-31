import android.graphics.SurfaceTexture;

class bdta
  implements bdtj
{
  bdta(bdsz parambdsz) {}
  
  public void a()
  {
    veg.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    veg.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (bdsz.a(this.a) == 0)
    {
      bdtb.a(this.a.hashCode(), "[Player] on video decode first frame");
      bdsz.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bdsz.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    veg.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    bdsz.a(this.a);
  }
  
  public void b(long paramLong)
  {
    veg.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    veg.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    bdsz.a(this.a);
  }
  
  public void d()
  {
    veg.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    bdsz.a(this.a);
    bdsz.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bdta
 * JD-Core Version:    0.7.0.1
 */