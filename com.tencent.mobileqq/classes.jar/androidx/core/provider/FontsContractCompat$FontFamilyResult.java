package androidx.core.provider;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

public class FontsContractCompat$FontFamilyResult
{
  public static final int STATUS_OK = 0;
  public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
  public static final int STATUS_WRONG_CERTIFICATES = 1;
  private final FontsContractCompat.FontInfo[] mFonts;
  private final int mStatusCode;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public FontsContractCompat$FontFamilyResult(int paramInt, @Nullable FontsContractCompat.FontInfo[] paramArrayOfFontInfo)
  {
    this.mStatusCode = paramInt;
    this.mFonts = paramArrayOfFontInfo;
  }
  
  public FontsContractCompat.FontInfo[] getFonts()
  {
    return this.mFonts;
  }
  
  public int getStatusCode()
  {
    return this.mStatusCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.FontFamilyResult
 * JD-Core Version:    0.7.0.1
 */