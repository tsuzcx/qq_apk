import android.graphics.SurfaceTexture;

class bfxt
  implements bfyc
{
  bfxt(bfxs parambfxs) {}
  
  public void a()
  {
    wxe.b("DefaultMediaPlayer", "decoder -> onDecodeStart");
  }
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    wxe.d("DefaultMediaPlayer", "decoder -> onDecodeError :%d , %s", new Object[] { Integer.valueOf(paramInt), paramThrowable });
  }
  
  public void a(long paramLong)
  {
    if (bfxs.a(this.a) == 0)
    {
      bfxu.a(this.a.hashCode(), "[Player] on video decode first frame");
      bfxs.a(this.a, 1);
    }
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bfxs.a(this.a, paramSurfaceTexture);
  }
  
  public void b()
  {
    wxe.d("DefaultMediaPlayer", "decoder -> onDecodeFinish");
    bfxs.a(this.a);
  }
  
  public void b(long paramLong)
  {
    wxe.d("DefaultMediaPlayer", "decoder -> onDecodeSeekTo :%d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public void c()
  {
    wxe.d("DefaultMediaPlayer", "decoder -> onDecodeCancel");
    bfxs.a(this.a);
  }
  
  public void d()
  {
    wxe.d("DefaultMediaPlayer", "decoder -> onDecodeRepeat");
    bfxs.a(this.a);
    bfxs.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfxt
 * JD-Core Version:    0.7.0.1
 */