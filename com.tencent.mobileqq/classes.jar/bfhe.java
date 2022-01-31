import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.open.base.img.ImageCache;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class bfhe
{
  public static Bitmap a(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static Bitmap a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public static Bitmap a(String paramString)
  {
    String str1 = a(paramString, 100);
    String str2 = ImageCache.a("app", str1);
    bfhg.b("ImageUtil", "100_url:" + str1 + " icon_path=" + str2);
    if (new File(str2).exists()) {
      return bfhc.a(str2, 72, 72, false);
    }
    paramString = a(paramString, 75);
    str1 = ImageCache.a("app", paramString);
    bfhg.b("ImageUtil", "75_url:" + paramString + " icon_path=" + str1);
    if (new File(str1).exists()) {
      return bfhc.a(str1, 72, 72, false);
    }
    return null;
  }
  
  @TargetApi(8)
  public static String a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT <= 7) {
      return "";
    }
    paramDrawable = a(paramDrawable);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramDrawable.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    String str = "00000000" + paramString;
    str = str.substring(str.length() - 8);
    paramString = String.format("http://i.gtimg.cn/open/app_icon/%s/%s/%s/%s/%s_%d_m.png", new Object[] { str.substring(0, 2), str.substring(2, 4), str.substring(4, 6), str.substring(6, 8), paramString, Integer.valueOf(paramInt) });
    bfhg.b("opensdk", ">>iconUrl=" + paramString);
    return paramString;
  }
  
  public static Bitmap b(Drawable paramDrawable)
  {
    return a(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfhe
 * JD-Core Version:    0.7.0.1
 */