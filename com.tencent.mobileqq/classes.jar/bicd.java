import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper.1;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper.2;
import java.io.File;
import kotlin.jvm.functions.Function0;

public class bicd
{
  private static bica jdField_a_of_type_Bica;
  private static bicd jdField_a_of_type_Bicd = new bicd();
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private bice jdField_a_of_type_Bice = new bice(this);
  
  static
  {
    jdField_a_of_type_Bica = new bibs();
    jdField_a_of_type_Boolean = aroa.c().a(Build.VERSION.SDK_INT);
    b = true;
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.1());
  }
  
  private bicd()
  {
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.2(this));
  }
  
  public static bica a()
  {
    return jdField_a_of_type_Bica;
  }
  
  public static bicd a()
  {
    return jdField_a_of_type_Bicd;
  }
  
  private void a()
  {
    if ((!bibw.a()) && (!bibw.b()) && (!jdField_a_of_type_Bica.a()) && (!jdField_a_of_type_Bica.b())) {
      jdField_a_of_type_Bica.a();
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static boolean a(Drawable paramDrawable)
  {
    if (d(paramDrawable)) {
      return true;
    }
    return bibw.a(paramDrawable);
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return bibw.a(paramDrawable);
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    return bibw.b(paramDrawable);
  }
  
  private static boolean d(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof URLDrawable))
    {
      paramDrawable = ((URLDrawable)paramDrawable).getExtraInfo();
      if ((paramDrawable instanceof Bundle)) {
        return ((Bundle)paramDrawable).getBoolean("key_use_gldrawable", false);
      }
    }
    return false;
  }
  
  public Drawable a(File paramFile, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    a();
    return bibw.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean);
  }
  
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    a();
    return bibw.a().a(paramString, paramHandler, paramBoolean);
  }
  
  public bibn a(bibv parambibv, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    return bibw.a().a(parambibv, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public bibn a(File paramFile, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    return bibw.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public bice a()
  {
    return this.jdField_a_of_type_Bice;
  }
  
  public void a(Drawable paramDrawable)
  {
    bibw.a().a(paramDrawable);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    bibw.a().a(paramDrawable, paramBoolean);
  }
  
  public boolean a(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return bibw.a().a(paramDrawable, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bicd
 * JD-Core Version:    0.7.0.1
 */