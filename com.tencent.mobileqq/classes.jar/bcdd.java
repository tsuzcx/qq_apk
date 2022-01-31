import android.util.LruCache;

public final class bcdd
  extends LruCache<String, aadp>
{
  public bcdd(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, aadp paramaadp1, aadp paramaadp2)
  {
    super.entryRemoved(paramBoolean, paramString, paramaadp1, paramaadp2);
    paramaadp1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdd
 * JD-Core Version:    0.7.0.1
 */