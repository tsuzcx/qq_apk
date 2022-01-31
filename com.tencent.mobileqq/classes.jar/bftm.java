import android.graphics.SurfaceTexture;

class bftm
  implements bftv
{
  bftm(bftl parambftl) {}
  
  public void a()
  {
    wsv.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    wsv.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (bftl.a(this.a) == 0)
    {
      bftn.a(this.a.hashCode(), "[Player] on video decode first frame");
      bftl.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bftl.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    wsv.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    bftl.a(this.a);
  }
  
  public void b(long paramLong)
  {
    wsv.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    wsv.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    bftl.a(this.a);
  }
  
  public void d()
  {
    wsv.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    bftl.a(this.a);
    bftl.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bftm
 * JD-Core Version:    0.7.0.1
 */