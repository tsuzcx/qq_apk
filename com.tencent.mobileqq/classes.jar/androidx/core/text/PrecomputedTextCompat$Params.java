package androidx.core.text;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import java.util.Locale;

public final class PrecomputedTextCompat$Params
{
  private final int mBreakStrategy;
  private final int mHyphenationFrequency;
  @NonNull
  private final TextPaint mPaint;
  @Nullable
  private final TextDirectionHeuristic mTextDir;
  final PrecomputedText.Params mWrapped;
  
  @RequiresApi(28)
  public PrecomputedTextCompat$Params(@NonNull PrecomputedText.Params paramParams)
  {
    this.mPaint = paramParams.getTextPaint();
    this.mTextDir = paramParams.getTextDirection();
    this.mBreakStrategy = paramParams.getBreakStrategy();
    this.mHyphenationFrequency = paramParams.getHyphenationFrequency();
    if (Build.VERSION.SDK_INT >= 29) {}
    for (;;)
    {
      this.mWrapped = paramParams;
      return;
      paramParams = null;
    }
  }
  
  @SuppressLint({"NewApi"})
  PrecomputedTextCompat$Params(@NonNull TextPaint paramTextPaint, @NonNull TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 29) {}
    for (this.mWrapped = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();; this.mWrapped = null)
    {
      this.mPaint = paramTextPaint;
      this.mTextDir = paramTextDirectionHeuristic;
      this.mBreakStrategy = paramInt1;
      this.mHyphenationFrequency = paramInt2;
      return;
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof Params)) {
        return false;
      }
      paramObject = (Params)paramObject;
      if (!equalsWithoutTextDirection(paramObject)) {
        return false;
      }
    } while ((Build.VERSION.SDK_INT < 18) || (this.mTextDir == paramObject.getTextDirection()));
    return false;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean equalsWithoutTextDirection(@NonNull Params paramParams)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      if (this.mBreakStrategy == paramParams.getBreakStrategy()) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while (this.mHyphenationFrequency != paramParams.getHyphenationFrequency());
        } while ((this.mPaint.getTextSize() != paramParams.getTextPaint().getTextSize()) || (this.mPaint.getTextScaleX() != paramParams.getTextPaint().getTextScaleX()) || (this.mPaint.getTextSkewX() != paramParams.getTextPaint().getTextSkewX()) || ((Build.VERSION.SDK_INT >= 21) && ((this.mPaint.getLetterSpacing() != paramParams.getTextPaint().getLetterSpacing()) || (!TextUtils.equals(this.mPaint.getFontFeatureSettings(), paramParams.getTextPaint().getFontFeatureSettings())))) || (this.mPaint.getFlags() != paramParams.getTextPaint().getFlags()));
        if (Build.VERSION.SDK_INT < 24) {
          break;
        }
      } while (!this.mPaint.getTextLocales().equals(paramParams.getTextPaint().getTextLocales()));
      if (this.mPaint.getTypeface() != null) {
        break label229;
      }
    } while (paramParams.getTextPaint().getTypeface() != null);
    label229:
    while (this.mPaint.getTypeface().equals(paramParams.getTextPaint().getTypeface()))
    {
      return true;
      if ((Build.VERSION.SDK_INT < 17) || (this.mPaint.getTextLocale().equals(paramParams.getTextPaint().getTextLocale()))) {
        break;
      }
      return false;
    }
    return false;
  }
  
  @RequiresApi(23)
  public int getBreakStrategy()
  {
    return this.mBreakStrategy;
  }
  
  @RequiresApi(23)
  public int getHyphenationFrequency()
  {
    return this.mHyphenationFrequency;
  }
  
  @Nullable
  @RequiresApi(18)
  public TextDirectionHeuristic getTextDirection()
  {
    return this.mTextDir;
  }
  
  @NonNull
  public TextPaint getTextPaint()
  {
    return this.mPaint;
  }
  
  public int hashCode()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocales(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
    }
    if (Build.VERSION.SDK_INT >= 21) {
      return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Float.valueOf(this.mPaint.getLetterSpacing()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), Boolean.valueOf(this.mPaint.isElegantTextHeight()), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
    }
    if (Build.VERSION.SDK_INT >= 18) {
      return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
    }
    if (Build.VERSION.SDK_INT >= 17) {
      return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTextLocale(), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
    }
    return ObjectsCompat.hash(new Object[] { Float.valueOf(this.mPaint.getTextSize()), Float.valueOf(this.mPaint.getTextScaleX()), Float.valueOf(this.mPaint.getTextSkewX()), Integer.valueOf(this.mPaint.getFlags()), this.mPaint.getTypeface(), this.mTextDir, Integer.valueOf(this.mBreakStrategy), Integer.valueOf(this.mHyphenationFrequency) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("{");
    localStringBuilder.append("textSize=" + this.mPaint.getTextSize());
    localStringBuilder.append(", textScaleX=" + this.mPaint.getTextScaleX());
    localStringBuilder.append(", textSkewX=" + this.mPaint.getTextSkewX());
    if (Build.VERSION.SDK_INT >= 21)
    {
      localStringBuilder.append(", letterSpacing=" + this.mPaint.getLetterSpacing());
      localStringBuilder.append(", elegantTextHeight=" + this.mPaint.isElegantTextHeight());
    }
    if (Build.VERSION.SDK_INT >= 24) {
      localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocales());
    }
    for (;;)
    {
      localStringBuilder.append(", typeface=" + this.mPaint.getTypeface());
      if (Build.VERSION.SDK_INT >= 26) {
        localStringBuilder.append(", variationSettings=" + this.mPaint.getFontVariationSettings());
      }
      localStringBuilder.append(", textDir=" + this.mTextDir);
      localStringBuilder.append(", breakStrategy=" + this.mBreakStrategy);
      localStringBuilder.append(", hyphenationFrequency=" + this.mHyphenationFrequency);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
      if (Build.VERSION.SDK_INT >= 17) {
        localStringBuilder.append(", textLocale=" + this.mPaint.getTextLocale());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.text.PrecomputedTextCompat.Params
 * JD-Core Version:    0.7.0.1
 */