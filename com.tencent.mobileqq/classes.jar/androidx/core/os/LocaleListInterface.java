package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

abstract interface LocaleListInterface
{
  public abstract Locale get(int paramInt);
  
  @Nullable
  public abstract Locale getFirstMatch(@NonNull String[] paramArrayOfString);
  
  public abstract Object getLocaleList();
  
  @IntRange(from=-1L)
  public abstract int indexOf(Locale paramLocale);
  
  public abstract boolean isEmpty();
  
  @IntRange(from=0L)
  public abstract int size();
  
  public abstract String toLanguageTags();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.os.LocaleListInterface
 * JD-Core Version:    0.7.0.1
 */