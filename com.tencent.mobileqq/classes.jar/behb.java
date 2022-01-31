import android.util.LruCache;

public final class behb
  extends LruCache<String, abyx>
{
  public behb(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, abyx paramabyx1, abyx paramabyx2)
  {
    super.entryRemoved(paramBoolean, paramString, paramabyx1, paramabyx2);
    paramabyx1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behb
 * JD-Core Version:    0.7.0.1
 */