package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pair;

public final class PaintCompat
{
  private static final String EM_STRING = "m";
  private static final String TOFU_STRING = "󟿽";
  private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal();
  
  public static boolean hasGlyph(@NonNull Paint paramPaint, @NonNull String paramString)
  {
    boolean bool2 = false;
    if (Build.VERSION.SDK_INT >= 23) {
      bool1 = paramPaint.hasGlyph(paramString);
    }
    int j;
    float f2;
    float f1;
    float f3;
    do
    {
      do
      {
        do
        {
          return bool1;
          j = paramString.length();
          if ((j == 1) && (Character.isWhitespace(paramString.charAt(0)))) {
            return true;
          }
          f2 = paramPaint.measureText("󟿽");
          f1 = paramPaint.measureText("m");
          f3 = paramPaint.measureText(paramString);
          bool1 = bool2;
        } while (f3 == 0.0F);
        if (paramString.codePointCount(0, paramString.length()) <= 1) {
          break;
        }
        bool1 = bool2;
      } while (f3 > f1 * 2.0F);
      f1 = 0.0F;
      int i = 0;
      while (i < j)
      {
        int k = Character.charCount(paramString.codePointAt(i));
        f1 += paramPaint.measureText(paramString, i, i + k);
        i += k;
      }
      bool1 = bool2;
    } while (f3 >= f1);
    if (f3 != f2) {
      return true;
    }
    Pair localPair = obtainEmptyRects();
    paramPaint.getTextBounds("󟿽", 0, "󟿽".length(), (Rect)localPair.first);
    paramPaint.getTextBounds(paramString, 0, j, (Rect)localPair.second);
    if (!((Rect)localPair.first).equals(localPair.second)) {}
    for (boolean bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
  
  private static Pair<Rect, Rect> obtainEmptyRects()
  {
    Pair localPair = (Pair)sRectThreadLocal.get();
    if (localPair == null)
    {
      localPair = new Pair(new Rect(), new Rect());
      sRectThreadLocal.set(localPair);
      return localPair;
    }
    ((Rect)localPair.first).setEmpty();
    ((Rect)localPair.second).setEmpty();
    return localPair;
  }
  
  public static boolean setBlendMode(@NonNull Paint paramPaint, @Nullable BlendModeCompat paramBlendModeCompat)
  {
    Object localObject = null;
    PorterDuff.Mode localMode = null;
    if (Build.VERSION.SDK_INT >= 29)
    {
      localObject = localMode;
      if (paramBlendModeCompat != null) {
        localObject = BlendModeUtils.obtainBlendModeFromCompat(paramBlendModeCompat);
      }
      paramPaint.setBlendMode((BlendMode)localObject);
      return true;
    }
    if (paramBlendModeCompat != null)
    {
      localMode = BlendModeUtils.obtainPorterDuffFromCompat(paramBlendModeCompat);
      paramBlendModeCompat = (BlendModeCompat)localObject;
      if (localMode != null) {
        paramBlendModeCompat = new PorterDuffXfermode(localMode);
      }
      paramPaint.setXfermode(paramBlendModeCompat);
      if (localMode != null) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    paramPaint.setXfermode(null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.graphics.PaintCompat
 * JD-Core Version:    0.7.0.1
 */