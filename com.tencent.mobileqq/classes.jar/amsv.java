import android.util.LruCache;

class amsv
  extends LruCache<String, amsw>
{
  amsv(amsu paramamsu, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, amsw paramamsw)
  {
    if ((paramamsw == null) || (paramamsw.a == null)) {
      return 0;
    }
    return paramamsw.a.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amsv
 * JD-Core Version:    0.7.0.1
 */