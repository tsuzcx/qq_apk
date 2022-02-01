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
    if (Build.VERSION.SDK_INT < 29) {
      paramParams = null;
    }
    this.mWrapped = paramParams;
  }
  
  @SuppressLint({"NewApi"})
  PrecomputedTextCompat$Params(@NonNull TextPaint paramTextPaint, @NonNull TextDirectionHeuristic paramTextDirectionHeuristic, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 29) {
      this.mWrapped = new PrecomputedText.Params.Builder(paramTextPaint).setBreakStrategy(paramInt1).setHyphenationFrequency(paramInt2).setTextDirection(paramTextDirectionHeuristic).build();
    } else {
      this.mWrapped = null;
    }
    this.mPaint = paramTextPaint;
    this.mTextDir = paramTextDirectionHeuristic;
    this.mBreakStrategy = paramInt1;
    this.mHyphenationFrequency = paramInt2;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Params)) {
      return false;
    }
    paramObject = (Params)paramObject;
    if (!equalsWithoutTextDirection(paramObject)) {
      return false;
    }
    return (Build.VERSION.SDK_INT < 18) || (this.mTextDir == paramObject.getTextDirection());
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public boolean equalsWithoutTextDirection(@NonNull Params paramParams)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.mBreakStrategy != paramParams.getBreakStrategy()) {
        return false;
      }
      if (this.mHyphenationFrequency != paramParams.getHyphenationFrequency()) {
        return false;
      }
    }
    if (this.mPaint.getTextSize() != paramParams.getTextPaint().getTextSize()) {
      return false;
    }
    if (this.mPaint.getTextScaleX() != paramParams.getTextPaint().getTextScaleX()) {
      return false;
    }
    if (this.mPaint.getTextSkewX() != paramParams.getTextPaint().getTextSkewX()) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (this.mPaint.getLetterSpacing() != paramParams.getTextPaint().getLetterSpacing()) {
        return false;
      }
      if (!TextUtils.equals(this.mPaint.getFontFeatureSettings(), paramParams.getTextPaint().getFontFeatureSettings())) {
        return false;
      }
    }
    if (this.mPaint.getFlags() != paramParams.getTextPaint().getFlags()) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      if (!this.mPaint.getTextLocales().equals(paramParams.getTextPaint().getTextLocales())) {
        return false;
      }
    }
    else if ((Build.VERSION.SDK_INT >= 17) && (!this.mPaint.getTextLocale().equals(paramParams.getTextPaint().getTextLocale()))) {
      return false;
    }
    if (this.mPaint.getTypeface() == null)
    {
      if (paramParams.getTextPaint().getTypeface() != null) {
        return false;
      }
    }
    else if (!this.mPaint.getTypeface().equals(paramParams.getTextPaint().getTypeface())) {
      return false;
    }
    return true;
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
    StringBuilder localStringBuilder1 = new StringBuilder("{");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("textSize=");
    localStringBuilder2.append(this.mPaint.getTextSize());
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", textScaleX=");
    localStringBuilder2.append(this.mPaint.getTextScaleX());
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", textSkewX=");
    localStringBuilder2.append(this.mPaint.getTextSkewX());
    localStringBuilder1.append(localStringBuilder2.toString());
    if (Build.VERSION.SDK_INT >= 21)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", letterSpacing=");
      localStringBuilder2.append(this.mPaint.getLetterSpacing());
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", elegantTextHeight=");
      localStringBuilder2.append(this.mPaint.isElegantTextHeight());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", textLocale=");
      localStringBuilder2.append(this.mPaint.getTextLocales());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    else if (Build.VERSION.SDK_INT >= 17)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", textLocale=");
      localStringBuilder2.append(this.mPaint.getTextLocale());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", typeface=");
    localStringBuilder2.append(this.mPaint.getTypeface());
    localStringBuilder1.append(localStringBuilder2.toString());
    if (Build.VERSION.SDK_INT >= 26)
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(", variationSettings=");
      localStringBuilder2.append(this.mPaint.getFontVariationSettings());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", textDir=");
    localStringBuilder2.append(this.mTextDir);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", breakStrategy=");
    localStringBuilder2.append(this.mBreakStrategy);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(", hyphenationFrequency=");
    localStringBuilder2.append(this.mHyphenationFrequency);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append("}");
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.PrecomputedTextCompat.Params
 * JD-Core Version:    0.7.0.1
 */