import android.util.LruCache;

public final class bify
  extends LruCache<String, adcd>
{
  public bify(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, adcd paramadcd1, adcd paramadcd2)
  {
    super.entryRemoved(paramBoolean, paramString, paramadcd1, paramadcd2);
    paramadcd1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bify
 * JD-Core Version:    0.7.0.1
 */