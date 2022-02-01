package androidx.core.os;

import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

@RequiresApi(24)
final class LocaleListPlatformWrapper
  implements LocaleListInterface
{
  private final LocaleList mLocaleList;
  
  LocaleListPlatformWrapper(LocaleList paramLocaleList)
  {
    this.mLocaleList = paramLocaleList;
  }
  
  public boolean equals(Object paramObject)
  {
    return this.mLocaleList.equals(((LocaleListInterface)paramObject).getLocaleList());
  }
  
  public Locale get(int paramInt)
  {
    return this.mLocaleList.get(paramInt);
  }
  
  @Nullable
  public Locale getFirstMatch(@NonNull String[] paramArrayOfString)
  {
    return this.mLocaleList.getFirstMatch(paramArrayOfString);
  }
  
  public Object getLocaleList()
  {
    return this.mLocaleList;
  }
  
  public int hashCode()
  {
    return this.mLocaleList.hashCode();
  }
  
  public int indexOf(Locale paramLocale)
  {
    return this.mLocaleList.indexOf(paramLocale);
  }
  
  public boolean isEmpty()
  {
    return this.mLocaleList.isEmpty();
  }
  
  public int size()
  {
    return this.mLocaleList.size();
  }
  
  public String toLanguageTags()
  {
    return this.mLocaleList.toLanguageTags();
  }
  
  public String toString()
  {
    return this.mLocaleList.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.os.LocaleListPlatformWrapper
 * JD-Core Version:    0.7.0.1
 */