import android.util.LruCache;

public final class bipa
  extends LruCache<String, adpb>
{
  public bipa(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, adpb paramadpb1, adpb paramadpb2)
  {
    super.entryRemoved(paramBoolean, paramString, paramadpb1, paramadpb2);
    paramadpb1.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bipa
 * JD-Core Version:    0.7.0.1
 */