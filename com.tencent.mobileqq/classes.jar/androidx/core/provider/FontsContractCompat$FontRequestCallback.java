package androidx.core.provider;

import android.graphics.Typeface;
import androidx.annotation.RestrictTo;

public class FontsContractCompat$FontRequestCallback
{
  public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
  public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
  public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
  public static final int FAIL_REASON_MALFORMED_QUERY = 3;
  public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
  public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
  public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final int RESULT_OK = 0;
  
  public void onTypefaceRequestFailed(int paramInt) {}
  
  public void onTypefaceRetrieved(Typeface paramTypeface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.provider.FontsContractCompat.FontRequestCallback
 * JD-Core Version:    0.7.0.1
 */