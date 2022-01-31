import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;

class bbxy
  extends MQLruCache<String, Object>
{
  bbxy(bbxx parambbxx, int paramInt)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxy
 * JD-Core Version:    0.7.0.1
 */