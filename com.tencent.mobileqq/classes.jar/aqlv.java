import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.widget.Gallery;

public class aqlv
{
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, true, paramObject);
  }
  
  public static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, Object paramObject)
  {
    float f = Gallery.a(paramInt1, paramInt2, paramInt3, paramInt4, paramObject);
    int i;
    label67:
    label79:
    Rect localRect;
    if (paramInt2 >= paramInt1 * 3)
    {
      i = 1;
      if ((i == 0) || ((paramInt1 <= paramInt3) && (paramInt2 <= paramInt4)) || ((paramInt1 < aywm.c) && (paramInt2 < aywm.c))) {
        break label119;
      }
      f = Math.min(paramInt3 / paramInt1, Gallery.c);
      i = 49;
      if ((paramBoolean) || (f <= 1.0F)) {
        break label126;
      }
      localRect = new Rect(0, 0, paramInt1, paramInt2);
      if (i != 49) {
        break label143;
      }
      localRect.offset((paramInt3 - paramInt1) / 2, 0);
    }
    label119:
    label126:
    do
    {
      do
      {
        do
        {
          return localRect;
          i = 0;
          break;
          i = 17;
          break label67;
          paramInt1 = (int)(paramInt1 * f);
          paramInt2 = (int)(paramInt2 * f);
          break label79;
        } while (i != 17);
        localRect.offset((paramInt3 - paramInt1) / 2, (paramInt4 - paramInt2) / 2);
      } while ((paramObject == null) || (!(paramObject instanceof AIOImageData)));
      paramObject = (AIOImageData)paramObject;
    } while ((paramObject.i == null) || (paramObject.i.length() == 0) || (paramObject.i.equals("null")));
    label143:
    localRect.offset(0, (int)(-15.0F * BaseApplicationImpl.sApplication.getResources().getDisplayMetrics().density * f));
    return localRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqlv
 * JD-Core Version:    0.7.0.1
 */