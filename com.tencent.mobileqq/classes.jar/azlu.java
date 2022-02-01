import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;

public class azlu
  implements Comparable<azlu>
{
  public int a;
  public Drawable a;
  public String a;
  public int[] a;
  public int b;
  public Drawable b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public String f;
  public String g;
  public String h;
  
  public int a(azlu paramazlu)
  {
    if (paramazlu != null) {
      return this.c - paramazlu.c;
    }
    return 0;
  }
  
  public Drawable a()
  {
    try
    {
      if ((this.a == null) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.e, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.f, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.a = localStateListDrawable;
      }
      return this.a;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
      }
    }
  }
  
  public Drawable b()
  {
    try
    {
      if ((this.b == null) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h)))
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        URLDrawable localURLDrawable = URLDrawable.getDrawable(this.g, (URLDrawable.URLDrawableOptions)localObject);
        localObject = URLDrawable.getDrawable(this.h, (URLDrawable.URLDrawableOptions)localObject);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
        localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
        this.b = localStateListDrawable;
      }
      return this.b;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AIOPanelIconItem", 1, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlu
 * JD-Core Version:    0.7.0.1
 */