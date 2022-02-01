package androidx.core.content.res;

import androidx.annotation.NonNull;
import androidx.core.provider.FontRequest;

public final class FontResourcesParserCompat$ProviderResourceEntry
  implements FontResourcesParserCompat.FamilyResourceEntry
{
  @NonNull
  private final FontRequest mRequest;
  private final int mStrategy;
  private final int mTimeoutMs;
  
  public FontResourcesParserCompat$ProviderResourceEntry(@NonNull FontRequest paramFontRequest, int paramInt1, int paramInt2)
  {
    this.mRequest = paramFontRequest;
    this.mStrategy = paramInt1;
    this.mTimeoutMs = paramInt2;
  }
  
  public int getFetchStrategy()
  {
    return this.mStrategy;
  }
  
  @NonNull
  public FontRequest getRequest()
  {
    return this.mRequest;
  }
  
  public int getTimeout()
  {
    return this.mTimeoutMs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.content.res.FontResourcesParserCompat.ProviderResourceEntry
 * JD-Core Version:    0.7.0.1
 */