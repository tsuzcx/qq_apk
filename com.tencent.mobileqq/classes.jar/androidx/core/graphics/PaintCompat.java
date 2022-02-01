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
    if (Build.VERSION.SDK_INT >= 23) {
      return paramPaint.hasGlyph(paramString);
    }
    int k = paramString.length();
    if ((k == 1) && (Character.isWhitespace(paramString.charAt(0)))) {
      return true;
    }
    float f2 = paramPaint.measureText("󟿽");
    float f4 = paramPaint.measureText("m");
    float f3 = paramPaint.measureText(paramString);
    float f1 = 0.0F;
    if (f3 == 0.0F) {
      return false;
    }
    if (paramString.codePointCount(0, paramString.length()) > 1)
    {
      if (f3 > f4 * 2.0F) {
        return false;
      }
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = Character.charCount(paramString.codePointAt(i)) + i;
        f1 += paramPaint.measureText(paramString, i, j);
      }
      if (f3 >= f1) {
        return false;
      }
    }
    if (f3 != f2) {
      return true;
    }
    Pair localPair = obtainEmptyRects();
    paramPaint.getTextBounds("󟿽", 0, 2, (Rect)localPair.first);
    paramPaint.getTextBounds(paramString, 0, k, (Rect)localPair.second);
    return ((Rect)localPair.first).equals(localPair.second) ^ true;
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
    int i = Build.VERSION.SDK_INT;
    Object localObject = null;
    PorterDuff.Mode localMode = null;
    if (i >= 29)
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
      return localMode != null;
    }
    paramPaint.setXfermode(null);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.graphics.PaintCompat
 * JD-Core Version:    0.7.0.1
 */