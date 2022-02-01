package androidx.core.os;

import android.os.Build.VERSION;
import android.os.LocaleList;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.Size;
import java.util.Locale;

public final class LocaleListCompat
{
  private static final LocaleListCompat sEmptyLocaleList = create(new Locale[0]);
  private LocaleListInterface mImpl;
  
  private LocaleListCompat(LocaleListInterface paramLocaleListInterface)
  {
    this.mImpl = paramLocaleListInterface;
  }
  
  @NonNull
  public static LocaleListCompat create(@NonNull Locale... paramVarArgs)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return wrap(new LocaleList(paramVarArgs));
    }
    return new LocaleListCompat(new LocaleListCompatWrapper(paramVarArgs));
  }
  
  static Locale forLanguageTagCompat(String paramString)
  {
    String[] arrayOfString;
    if (paramString.contains("-"))
    {
      arrayOfString = paramString.split("-", -1);
      if (arrayOfString.length > 2) {
        return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      }
      if (arrayOfString.length > 1) {
        return new Locale(arrayOfString[0], arrayOfString[1]);
      }
      if (arrayOfString.length == 1) {
        return new Locale(arrayOfString[0]);
      }
    }
    else if (paramString.contains("_"))
    {
      arrayOfString = paramString.split("_", -1);
      if (arrayOfString.length > 2) {
        return new Locale(arrayOfString[0], arrayOfString[1], arrayOfString[2]);
      }
      if (arrayOfString.length > 1) {
        return new Locale(arrayOfString[0], arrayOfString[1]);
      }
      if (arrayOfString.length == 1) {
        return new Locale(arrayOfString[0]);
      }
    }
    else
    {
      return new Locale(paramString);
    }
    throw new IllegalArgumentException("Can not parse language tag: [" + paramString + "]");
  }
  
  @NonNull
  public static LocaleListCompat forLanguageTags(@Nullable String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return getEmptyLocaleList();
    }
    String[] arrayOfString = paramString.split(",", -1);
    Locale[] arrayOfLocale = new Locale[arrayOfString.length];
    int i = 0;
    if (i < arrayOfLocale.length)
    {
      if (Build.VERSION.SDK_INT >= 21) {}
      for (paramString = Locale.forLanguageTag(arrayOfString[i]);; paramString = forLanguageTagCompat(arrayOfString[i]))
      {
        arrayOfLocale[i] = paramString;
        i += 1;
        break;
      }
    }
    return create(arrayOfLocale);
  }
  
  @NonNull
  @Size(min=1L)
  public static LocaleListCompat getAdjustedDefault()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return wrap(LocaleList.getAdjustedDefault());
    }
    return create(new Locale[] { Locale.getDefault() });
  }
  
  @NonNull
  @Size(min=1L)
  public static LocaleListCompat getDefault()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return wrap(LocaleList.getDefault());
    }
    return create(new Locale[] { Locale.getDefault() });
  }
  
  @NonNull
  public static LocaleListCompat getEmptyLocaleList()
  {
    return sEmptyLocaleList;
  }
  
  @NonNull
  @RequiresApi(24)
  public static LocaleListCompat wrap(@NonNull LocaleList paramLocaleList)
  {
    return new LocaleListCompat(new LocaleListPlatformWrapper(paramLocaleList));
  }
  
  @Deprecated
  @RequiresApi(24)
  public static LocaleListCompat wrap(Object paramObject)
  {
    return wrap((LocaleList)paramObject);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof LocaleListCompat)) && (this.mImpl.equals(((LocaleListCompat)paramObject).mImpl));
  }
  
  public Locale get(int paramInt)
  {
    return this.mImpl.get(paramInt);
  }
  
  @Nullable
  public Locale getFirstMatch(@NonNull String[] paramArrayOfString)
  {
    return this.mImpl.getFirstMatch(paramArrayOfString);
  }
  
  public int hashCode()
  {
    return this.mImpl.hashCode();
  }
  
  @IntRange(from=-1L)
  public int indexOf(Locale paramLocale)
  {
    return this.mImpl.indexOf(paramLocale);
  }
  
  public boolean isEmpty()
  {
    return this.mImpl.isEmpty();
  }
  
  @IntRange(from=0L)
  public int size()
  {
    return this.mImpl.size();
  }
  
  @NonNull
  public String toLanguageTags()
  {
    return this.mImpl.toLanguageTags();
  }
  
  public String toString()
  {
    return this.mImpl.toString();
  }
  
  @Nullable
  public Object unwrap()
  {
    return this.mImpl.getLocaleList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.core.os.LocaleListCompat
 * JD-Core Version:    0.7.0.1
 */