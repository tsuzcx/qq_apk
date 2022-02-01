import android.util.LruCache;

public final class bhof
  extends LruCache<String, adgd>
{
  public bhof(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, adgd paramadgd1, adgd paramadgd2)
  {
    super.entryRemoved(paramBoolean, paramString, paramadgd1, paramadgd2);
    paramadgd1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhof
 * JD-Core Version:    0.7.0.1
 */