import android.graphics.Bitmap;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public class bmtx
  implements bmqt
{
  public bmtx(DoodleLayout paramDoodleLayout) {}
  
  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (this.a.a != null) {
      this.a.a.a(paramBitmap, paramBoolean);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.a.a != null)
    {
      wxe.b("DoodleLayout", "notify outside onDrawMosaic. width:" + paramInt1 + ",height:" + paramInt2);
      this.a.a.a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtx
 * JD-Core Version:    0.7.0.1
 */