import android.util.LruCache;

public final class bbae
  extends LruCache<String, ztw>
{
  public bbae(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, ztw paramztw1, ztw paramztw2)
  {
    super.entryRemoved(paramBoolean, paramString, paramztw1, paramztw2);
    paramztw1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbae
 * JD-Core Version:    0.7.0.1
 */