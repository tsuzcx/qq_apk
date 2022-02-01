package androidx.core.text;

import java.util.Locale;

public final class BidiFormatter$Builder
{
  private int mFlags;
  private boolean mIsRtlContext;
  private TextDirectionHeuristicCompat mTextDirectionHeuristicCompat;
  
  public BidiFormatter$Builder()
  {
    initialize(BidiFormatter.isRtlLocale(Locale.getDefault()));
  }
  
  public BidiFormatter$Builder(Locale paramLocale)
  {
    initialize(BidiFormatter.isRtlLocale(paramLocale));
  }
  
  public BidiFormatter$Builder(boolean paramBoolean)
  {
    initialize(paramBoolean);
  }
  
  private static BidiFormatter getDefaultInstanceFromContext(boolean paramBoolean)
  {
    if (paramBoolean) {
      return BidiFormatter.DEFAULT_RTL_INSTANCE;
    }
    return BidiFormatter.DEFAULT_LTR_INSTANCE;
  }
  
  private void initialize(boolean paramBoolean)
  {
    this.mIsRtlContext = paramBoolean;
    this.mTextDirectionHeuristicCompat = BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC;
    this.mFlags = 2;
  }
  
  public BidiFormatter build()
  {
    if ((this.mFlags == 2) && (this.mTextDirectionHeuristicCompat == BidiFormatter.DEFAULT_TEXT_DIRECTION_HEURISTIC)) {
      return getDefaultInstanceFromContext(this.mIsRtlContext);
    }
    return new BidiFormatter(this.mIsRtlContext, this.mFlags, this.mTextDirectionHeuristicCompat);
  }
  
  public Builder setTextDirectionHeuristic(TextDirectionHeuristicCompat paramTextDirectionHeuristicCompat)
  {
    this.mTextDirectionHeuristicCompat = paramTextDirectionHeuristicCompat;
    return this;
  }
  
  public Builder stereoReset(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mFlags |= 0x2;
      return this;
    }
    this.mFlags &= 0xFFFFFFFD;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.text.BidiFormatter.Builder
 * JD-Core Version:    0.7.0.1
 */