import android.graphics.SurfaceTexture;

class bofp
  implements boiv
{
  bofp(bofh parambofh) {}
  
  public void a()
  {
    bpam.b("AEPituCameraUnit", "onPreviewSurfaceTextureRelease---" + bofh.a(this.a));
    bofh.a(this.a, null);
  }
  
  public void a(int paramInt)
  {
    bofh.a(this.a).a(paramInt, new bofq(this));
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bofh.a(this.a, paramSurfaceTexture);
    bpam.b("AEPituCameraUnit", "onPreviewSurfaceTextureCreate---" + bofh.a(this.a));
    bofh.f(this.a);
  }
  
  public void b()
  {
    bowp.a().a("onFirstFrameDone");
    bofh.h(this.a);
  }
  
  public void c()
  {
    bofh.a(this.a).b(new bofr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bofp
 * JD-Core Version:    0.7.0.1
 */