import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;

class bhik
  extends MQLruCache<String, Object>
{
  bhik(bhij parambhij, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(String paramString, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Bitmap)))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    return super.sizeOfObj(paramString, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhik
 * JD-Core Version:    0.7.0.1
 */