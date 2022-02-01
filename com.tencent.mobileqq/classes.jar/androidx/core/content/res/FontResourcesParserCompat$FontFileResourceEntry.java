package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class FontResourcesParserCompat$FontFileResourceEntry
{
  @NonNull
  private final String mFileName;
  private boolean mItalic;
  private int mResourceId;
  private int mTtcIndex;
  private String mVariationSettings;
  private int mWeight;
  
  public FontResourcesParserCompat$FontFileResourceEntry(@NonNull String paramString1, int paramInt1, boolean paramBoolean, @Nullable String paramString2, int paramInt2, int paramInt3)
  {
    this.mFileName = paramString1;
    this.mWeight = paramInt1;
    this.mItalic = paramBoolean;
    this.mVariationSettings = paramString2;
    this.mTtcIndex = paramInt2;
    this.mResourceId = paramInt3;
  }
  
  @NonNull
  public String getFileName()
  {
    return this.mFileName;
  }
  
  public int getResourceId()
  {
    return this.mResourceId;
  }
  
  public int getTtcIndex()
  {
    return this.mTtcIndex;
  }
  
  @Nullable
  public String getVariationSettings()
  {
    return this.mVariationSettings;
  }
  
  public int getWeight()
  {
    return this.mWeight;
  }
  
  public boolean isItalic()
  {
    return this.mItalic;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.content.res.FontResourcesParserCompat.FontFileResourceEntry
 * JD-Core Version:    0.7.0.1
 */