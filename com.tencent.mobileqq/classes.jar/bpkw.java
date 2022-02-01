import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

public class bpkw
{
  public int a;
  public Bitmap a;
  
  protected void finalize()
  {
    super.finalize();
    if ((this.a != null) && (!this.a.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Frames", 2, "recycle bitmap");
      }
      this.a.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpkw
 * JD-Core Version:    0.7.0.1
 */