import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;

public class atrg
  implements Comparable<atrg>
{
  static boolean a;
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
  
  static
  {
    jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT >= 23) {
      jdField_a_of_type_Boolean = akhu.a(BaseApplicationImpl.getContext());
    }
  }
  
  public int a(atrg paramatrg)
  {
    if (paramatrg != null) {
      return this.c - paramatrg.c;
    }
    return 0;
  }
  
  public Drawable a()
  {
    if ((jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)))
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      URLDrawable localURLDrawable = URLDrawable.getDrawable(this.e, (URLDrawable.URLDrawableOptions)localObject);
      localObject = URLDrawable.getDrawable(this.f, (URLDrawable.URLDrawableOptions)localObject);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { -16842908, -16842913, -16842919 }, localURLDrawable);
      localStateListDrawable.addState(new int[] { -16842908, 16842913, -16842919 }, (Drawable)localObject);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localStateListDrawable;
    }
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public Drawable b()
  {
    if ((jdField_a_of_type_Boolean) && (this.b == null) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h)))
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     atrg
 * JD-Core Version:    0.7.0.1
 */