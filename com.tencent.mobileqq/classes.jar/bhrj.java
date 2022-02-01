import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper.1;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper.2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.jvm.functions.Function0;

public class bhrj
{
  private static bhrg jdField_a_of_type_Bhrg;
  private static bhrj jdField_a_of_type_Bhrj = new bhrj();
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private bhrk jdField_a_of_type_Bhrk = new bhrk(this);
  
  static
  {
    jdField_a_of_type_Bhrg = new bhqx();
    jdField_a_of_type_Boolean = arli.c().a(Build.VERSION.SDK_INT);
    b = true;
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.1());
  }
  
  private bhrj()
  {
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.2(this));
  }
  
  public static bhrg a()
  {
    return jdField_a_of_type_Bhrg;
  }
  
  public static bhrj a()
  {
    return jdField_a_of_type_Bhrj;
  }
  
  private void a()
  {
    if ((!bhrc.a()) && (!bhrc.b()) && (!jdField_a_of_type_Bhrg.a()) && (!jdField_a_of_type_Bhrg.b())) {
      jdField_a_of_type_Bhrg.a();
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
    return bhrc.a(paramDrawable);
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return bhrc.a(paramDrawable);
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    return bhrc.b(paramDrawable);
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
    return bhrc.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean);
  }
  
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    a();
    return bhrc.a().a(paramString, paramHandler, paramBoolean);
  }
  
  public bhqs a(bhrb parambhrb, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    return bhrc.a().a(parambhrb, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public bhqs a(File paramFile, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GLDrawable", 1, "use Async-GLDrawable : " + paramFile.getAbsolutePath());
    }
    return bhrc.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public bhrk a()
  {
    return this.jdField_a_of_type_Bhrk;
  }
  
  public void a(Drawable paramDrawable)
  {
    bhrc.a().a(paramDrawable);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    bhrc.a().a(paramDrawable, paramBoolean);
  }
  
  public boolean a(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return bhrc.a().a(paramDrawable, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrj
 * JD-Core Version:    0.7.0.1
 */