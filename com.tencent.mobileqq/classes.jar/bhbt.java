import android.graphics.drawable.Drawable;
import android.media.MediaCodecInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.gldrawable.GLDrawableWraper.1;
import java.io.File;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;

public class bhbt
{
  private static bhbq jdField_a_of_type_Bhbq;
  private static bhbt jdField_a_of_type_Bhbt = new bhbt();
  private static boolean jdField_a_of_type_Boolean;
  private static boolean b;
  
  static
  {
    jdField_a_of_type_Bhbq = new bhbk();
    jdField_a_of_type_Boolean = aqyj.c().a(Build.VERSION.SDK_INT);
    b = true;
    ThreadManagerV2.executeOnSubThread(new GLDrawableWraper.1());
  }
  
  private bhbt()
  {
    Object localObject1;
    if ((bhak.a()) && (Build.VERSION.SDK_INT >= 16))
    {
      localObject1 = bhbv.a("video/avc");
      if (((ArrayList)localObject1).size() <= 0) {
        break label140;
      }
      localObject1 = ((MediaCodecInfo)((ArrayList)localObject1).get(0)).getName();
      localObject2 = bhbv.a("video/hevc");
      if (((ArrayList)localObject2).size() <= 0) {
        break label146;
      }
    }
    label140:
    label146:
    for (Object localObject2 = ((MediaCodecInfo)((ArrayList)localObject2).get(0)).getName();; localObject2 = "")
    {
      bhak.a("gldrawable_video_codec", new Pair[] { new Pair("avc", localObject1), new Pair("hevc", localObject2), new Pair("api", String.valueOf(Build.VERSION.SDK_INT)), new Pair("level", String.valueOf(bgln.f())) });
      return;
      localObject1 = "";
      break;
    }
  }
  
  public static bhbq a()
  {
    return jdField_a_of_type_Bhbq;
  }
  
  public static bhbt a()
  {
    return jdField_a_of_type_Bhbt;
  }
  
  private void a()
  {
    if ((!bhbn.a()) && (!bhbn.b()) && (!jdField_a_of_type_Bhbq.a()) && (!jdField_a_of_type_Bhbq.b())) {
      jdField_a_of_type_Bhbq.a();
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
    return bhbn.a(paramDrawable);
  }
  
  public static boolean b()
  {
    return b;
  }
  
  public static boolean b(Drawable paramDrawable)
  {
    return bhbn.a(paramDrawable);
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    return bhbn.b(paramDrawable);
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
    return bhbn.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean);
  }
  
  public Drawable a(String paramString, Handler paramHandler, boolean paramBoolean)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    a();
    return bhbn.a().a(paramString, paramHandler, paramBoolean);
  }
  
  public bhbg a(File paramFile, boolean paramBoolean, Function0<Drawable> paramFunction0)
  {
    if (!jdField_a_of_type_Boolean) {
      return null;
    }
    return bhbn.a().a(paramFile, ThreadManagerV2.getFileThreadLooper(), paramBoolean, paramFunction0);
  }
  
  public void a(Drawable paramDrawable)
  {
    bhbn.a().a(paramDrawable);
  }
  
  public void a(Drawable paramDrawable, boolean paramBoolean)
  {
    bhbn.a().a(paramDrawable, paramBoolean);
  }
  
  public boolean a(Drawable paramDrawable, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    return bhbn.a().a(paramDrawable, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhbt
 * JD-Core Version:    0.7.0.1
 */