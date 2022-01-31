import android.graphics.Bitmap;
import com.tencent.biz.qqstory.base.BitmapError;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

public class biir
  extends JobSegment<Bitmap, Bitmap>
{
  public int a;
  
  public biir()
  {
    this.a = 10;
  }
  
  public biir(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    if (paramBitmap == null) {
      return null;
    }
    bain.a(paramBitmap, paramInt);
    return paramBitmap;
  }
  
  protected void a(JobContext paramJobContext, Bitmap paramBitmap)
  {
    long l = System.currentTimeMillis();
    paramJobContext = a(paramBitmap, this.a, false);
    urk.b("BlurJobSegment", "blur time = " + (System.currentTimeMillis() - l) + ", blur ratio = " + this.a);
    if (paramJobContext == null)
    {
      super.notifyError(new BitmapError("BlurJobSegment", 7));
      return;
    }
    super.notifyResult(paramJobContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biir
 * JD-Core Version:    0.7.0.1
 */