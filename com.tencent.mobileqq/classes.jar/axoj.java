import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.util.MQLruCache;
import android.util.Pair;
import com.tencent.commonsdk.cache.Sizeable;

public class axoj
  extends MQLruCache<String, Object>
{
  public axoj(Integer paramInteger)
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
    else if ((paramObject instanceof rpg))
    {
      paramObject = ((rpg)paramObject).a();
      if (paramObject != null) {
        return rpq.a(paramObject);
      }
    }
    else if ((paramObject instanceof Sizeable))
    {
      return ((Sizeable)paramObject).getByteSize();
    }
    xoz.a(paramString, xoz.m);
    return 204800;
  }
  
  public Object a(String paramString, Object paramObject)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof rpg)) {
      localObject = ((rpg)paramObject).a();
    }
    return super.put(paramString, localObject);
  }
  
  public Object a(String paramString, Object paramObject, byte paramByte)
  {
    Object localObject = paramObject;
    if ((paramObject instanceof rpg)) {
      localObject = ((rpg)paramObject).a();
    }
    return super.put(paramString, localObject, paramByte);
  }
  
  public void a(String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 instanceof rpg)) {
      ((rpg)paramObject1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axoj
 * JD-Core Version:    0.7.0.1
 */