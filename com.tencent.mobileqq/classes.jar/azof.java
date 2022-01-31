import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.commonsdk.cache.Sizeable;

public class azof
  extends MQLruCache<String, Object>
{
  public azof(Integer paramInteger)
  {
    super(paramInteger.intValue());
  }
  
  protected int a(String paramString, Object paramObject)
  {
    if ((paramObject instanceof Pair)) {
      return ((Integer)((Pair)paramObject).second).intValue();
    }
    if ((paramObject instanceof Bitmap))
    {
      paramString = (Bitmap)paramObject;
      return paramString.getRowBytes() * paramString.getHeight();
    }
    if ((paramObject instanceof BitmapDrawable))
    {
      paramObject = ((BitmapDrawable)paramObject).getBitmap();
      if (paramObject != null)
      {
        int i = paramObject.getRowBytes();
        return paramObject.getHeight() * i;
      }
    }
    else if ((paramObject instanceof sfc))
    {
      paramObject = ((sfc)paramObject).a();
      if (paramObject != null) {
        return sfm.a(paramObject);
      }
    }
    else if ((paramObject instanceof Sizeable))
    {
      return ((Sizeable)paramObject).getByteSize();
    }
    zie.a(paramString, zie.m);
    return 204800;
  }
  
  public Object a(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof sfc)) {
      localObject = ((sfc)paramObject).a();
    }
    return super.put(paramString, localObject);
  }
  
  public Object a(String paramString, Object paramObject, byte paramByte)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof sfc)) {
      localObject = ((sfc)paramObject).a();
    }
    return super.put(paramString, localObject, paramByte);
  }
  
  public void a(String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof sfc)) {
      ((sfc)paramObject1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azof
 * JD-Core Version:    0.7.0.1
 */