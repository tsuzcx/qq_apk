import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;

class bdwz
  extends MQLruCache<String, Object>
{
  bdwz(bdwy parambdwy, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwz
 * JD-Core Version:    0.7.0.1
 */