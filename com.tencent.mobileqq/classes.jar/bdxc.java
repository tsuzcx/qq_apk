import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public class bdxc
  implements DownloadParams.DecodeHandler
{
  private int a;
  private int b;
  
  @Deprecated
  public bdxc() {}
  
  public bdxc(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  @Deprecated
  public void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    return bdia.a(paramBitmap, this.a, this.b);
  }
  
  public String toString()
  {
    return "NinePatchDecoderHandler{reqW=" + this.a + ", reqH=" + this.b + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxc
 * JD-Core Version:    0.7.0.1
 */