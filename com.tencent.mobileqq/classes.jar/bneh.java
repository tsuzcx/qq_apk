import android.graphics.SurfaceTexture;

class bneh
  implements bnhn
{
  bneh(bndy parambndy) {}
  
  public void a()
  {
    bnzb.b("AEPituCameraUnit", "onPreviewSurfaceTextureRelease---" + bndy.a(this.a));
    bndy.a(this.a, null);
  }
  
  public void a(int paramInt)
  {
    bndy.a(this.a).a(paramInt, new bnei(this));
  }
  
  public void a(SurfaceTexture paramSurfaceTexture)
  {
    bndy.a(this.a, paramSurfaceTexture);
    bnzb.b("AEPituCameraUnit", "onPreviewSurfaceTextureCreate---" + bndy.a(this.a));
    bndy.g(this.a);
  }
  
  public void b()
  {
    bnvd.a().a("onFirstFrameDone");
    bndy.i(this.a);
  }
  
  public void c()
  {
    bndy.a(this.a).b(new bnej(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bneh
 * JD-Core Version:    0.7.0.1
 */