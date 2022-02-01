import android.util.LruCache;

public final class bgvg
  extends LruCache<String, aclu>
{
  public bgvg(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, aclu paramaclu1, aclu paramaclu2)
  {
    super.entryRemoved(paramBoolean, paramString, paramaclu1, paramaclu2);
    paramaclu1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgvg
 * JD-Core Version:    0.7.0.1
 */