import android.util.LruCache;

public final class becs
  extends LruCache<String, abui>
{
  public becs(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, abui paramabui1, abui paramabui2)
  {
    super.entryRemoved(paramBoolean, paramString, paramabui1, paramabui2);
    paramabui1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     becs
 * JD-Core Version:    0.7.0.1
 */