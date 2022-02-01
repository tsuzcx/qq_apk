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

public class bgio
{
  private static bgil jdField_a_of_type_Bgil;
  private static bgio jdField_a_of_type_Bgio = new bgio();
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  private bgip jdField_a_of_type_Bgip = new bgip(this);
  
  static
  {
    jdField_a_of_type_Bgil = new bgic();
    jdField_a_of_type_Boolean = aqhy.c().a(Build.VERSION.SDK_INT);
    b = true;
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.1());
  }
  
  private bgio()
  {
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.2(this));
  }
  
  public static bgil a()
  {
    return jdField_a_of_type_Bgil;
  }
  
  public static bgio a()
  {
    return jdField_a_of_type_Bgio;
  }
  
  private void a()
  {
    if ((!bgih.a()) && (!bgih.b()) && (!jdField_a_of_type_Bgil.a()) && (!jdField_a_of_type_Bgil.b())) {
      jdField_a_of_type_Bgil.a();
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
    return bgih.a(paramDrawable);
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return bgih.a(paramDrawable);
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    return bgih.b(paramDrawable);
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
    return bgih.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean);
  }
  
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    a();
    return bgih.a().a(paramString, paramHandler, paramBoolean);
  }
  
  public bghx a(bgig parambgig, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    return bgih.a().a(parambgig, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public bghx a(File paramFile, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("GLDrawable", 1, "use Async-GLDrawable : " + paramFile.getAbsolutePath());
    }
    return bgih.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public bgip a()
  {
    return this.jdField_a_of_type_Bgip;
  }
  
  public void a(Drawable paramDrawable)
  {
    bgih.a().a(paramDrawable);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    bgih.a().a(paramDrawable, paramBoolean);
  }
  
  public boolean a(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return bgih.a().a(paramDrawable, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgio
 * JD-Core Version:    0.7.0.1
 */