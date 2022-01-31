import android.util.LruCache;

public final class bcdr
  extends LruCache<String, aadl>
{
  public bcdr(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, aadl paramaadl1, aadl paramaadl2)
  {
    super.entryRemoved(paramBoolean, paramString, paramaadl1, paramaadl2);
    paramaadl1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bcdr
 * JD-Core Version:    0.7.0.1
 */