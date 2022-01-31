import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

class azvs<Bitmap>
  extends WeakReference<Bitmap>
{
  private final String a;
  
  public azvs(String paramString, Bitmap paramBitmap, ReferenceQueue paramReferenceQueue)
  {
    super(paramBitmap, paramReferenceQueue);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azvs
 * JD-Core Version:    0.7.0.1
 */